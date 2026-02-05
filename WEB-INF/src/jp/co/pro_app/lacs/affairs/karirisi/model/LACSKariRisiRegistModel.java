package jp.co.pro_app.lacs.affairs.karirisi.model;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCheckUtl;
import jp.co.pro_app.lacs.affairs.common.command.LACSMessage;
import jp.co.pro_app.lacs.affairs.karirisi.bean.LACSKariRisiBean;
import jp.co.pro_app.lacs.affairs.karirisi.bean.LACSKariRisiDetailBean;
import jp.co.pro_app.lacs.affairs.karirisi.data.entity.LACSKariRisiEntity;
import jp.co.pro_app.lacs.affairs.user.data.entity.LACSUserEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.dbaccess.MakeSQLDeleteBase;
import jp.co.pro_app.projframe.common.dbaccess.MakeSQLInsertBase;
import jp.co.pro_app.projframe.common.dbaccess.NotSelectExecute;

/**
 * リースユーザー別借入利子率マスタ：登録処理Model.
 * 
 * @author ohmura
 * @version 20070918
 */
public class LACSKariRisiRegistModel extends LACSKariRisiModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "登録";
	}

	/**
	 * テーブル名.
	 */
	private static final String	TABLE_NAME	= "M_LU_BETU_KRI_RS_RT";

	/**
	 * 業務個別処理.
	 * 
	 * @param piKariRisiBean
	 *            リースユーザー別借入利子率マスタBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSKariRisiBean piKariRisiBean) throws Exception {
		if (this.checkInput(super.getCommonBean(), piKariRisiBean, message)) {

			NotSelectExecute notSelectExecute = new NotSelectExecute();
			notSelectExecute.setCon(super.con);

			try {

				notSelectExecute.startTrans();

				this.getData(piKariRisiBean);

				notSelectExecute.execState(makeSQL1(piKariRisiBean));
				for (int i = 0; i < piKariRisiBean.getRetuSu(); i++) {
					LACSKariRisiDetailBean detail = null;
					detail = piKariRisiBean.getDetail(i);
					if (detail.getKikanFrom().trim().length() != 0) {
						notSelectExecute.execState(makeSQL2(piKariRisiBean, detail));
					}
				}
				piKariRisiBean.setShowList(false);

				notSelectExecute.commit();

				notSelectExecute.endTrans();
			}
			finally {

				//notSelectExecute.rollback();
			}
		}

		if (message.hasMessage()) {
			piKariRisiBean.setMessage(message.getMessage());
			super.setForwardPath("/jsp/K003.jsp");
		}
		else {
			super.setForwardPath("/return.karirisilist");
		}
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piKariRisiBean
	 *            リースユーザー別借入利子率マスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSKariRisiBean piKariRisiBean) throws SQLException {

		LACSKariRisiDetailBean detail = null;
		piKariRisiBean.clearList();

		for (int i = 0; i < piKariRisiBean.getRetuSu(); i++) {
			detail = new LACSKariRisiDetailBean();
			piKariRisiBean.addDetail(detail);

			detail.setKikanFrom(super.getInput("kikanFrom" + i, "").trim());
			detail.setKikanTo(super.getInput("kikanTo" + i, "").trim());
			detail.setRisiRitu(super.getInput("risiRitu" + i, ""));
		}

		piKariRisiBean.setMessage("");
	}

	/**
	 * データ取得.
	 * 
	 * @param piKariRisiBean
	 *            リースユーザー別借入利子率マスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	private void getData(LACSKariRisiBean piKariRisiBean) throws SQLException {
		LACSKariRisiEntity userEntity = new LACSKariRisiEntity(this);

		try {
			userEntity.setCon(super.con);

			userEntity.setCosmosCode(piKariRisiBean.getCosmosCode());

			userEntity.execSQL();

			piKariRisiBean.setDataMax(userEntity.getAllDataCount());
		}
		finally {
			userEntity.close();
		}
	}

	/**
	 * 入力チェック.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piKariRisiBean
	 *            リースユーザー別借入利子率マスタBean
	 * @param piMessage
	 *            メッセージ
	 * @return チェック結果
	 * @throws SQLException
	 */
	private boolean checkInput(LACSCommonBean piCommonBean, LACSKariRisiBean piKariRisiBean, LACSMessage piMessage) throws SQLException {
		boolean result = true;
		LACSKariRisiDetailBean kariRisiDetail1 = null;
		LACSKariRisiDetailBean kariRisiDetail2 = null;
		LACSCheckUtl checkUtl = new LACSCheckUtl(piMessage);

		result &= checkUtl.checkMandatory("開示先コード", piKariRisiBean.getCosmosCode());

		result &= this.checkLeaseUser("開示先コード", piKariRisiBean.getCosmosCode(), piMessage);

		for (int i = 0; i < piKariRisiBean.getRetuSu(); i++) {
			kariRisiDetail1 = piKariRisiBean.getDetail(i);

			if (kariRisiDetail1.getKikanFrom().trim().length() != 0) {
				if (kariRisiDetail1.getKikanTo().trim().length() == 0) {
					piMessage.addMessage(LACSDefine.MessageCode.ERROR_FIELD_MANDATORY, "適用終了日（" + (i + 1) + "）");
					result &= false;
				}
				if (kariRisiDetail1.getRisiRitu().trim().length() == 0) {
					piMessage.addMessage(LACSDefine.MessageCode.ERROR_FIELD_MANDATORY, "自社借入利子率（" + (i + 1) + "）");
					result &= false;
				}
			}
			else {
				if (kariRisiDetail1.getKikanTo().trim().length() != 0 || kariRisiDetail1.getRisiRitu().trim().length() != 0) {
					piMessage.addMessage(LACSDefine.MessageCode.ERROR_FIELD_MANDATORY, "適用開始日（" + (i + 1) + "）");
					result &= false;
				}
			}

			result &= checkUtl.checkAlNumHalf("適用開始日（" + (i + 1) + "）", kariRisiDetail1.getKikanFrom());
			result &= checkUtl.checkDate("適用開始日（" + (i + 1) + "）", kariRisiDetail1.getKikanFrom());
			result &= checkUtl.checkAlNumHalf("適用終了日（" + (i + 1) + "）", kariRisiDetail1.getKikanTo());
			result &= checkUtl.checkDate("適用終了日（" + (i + 1) + "）", kariRisiDetail1.getKikanTo());
			result &= this.checkDateOrder("適用期間（" + (i + 1) + "）", kariRisiDetail1.getKikanFrom(), kariRisiDetail1.getKikanTo(), piMessage);
			result &= checkUtl.checkDecimal("自社借入利子率（" + (i + 1) + "）", kariRisiDetail1.getRisiRitu(), 3, 6, piMessage);
		}

		for (int i = 0; i < piKariRisiBean.getRetuSu(); i++) {
			kariRisiDetail1 = piKariRisiBean.getDetail(i);
			if (kariRisiDetail1.getKikanFrom().trim().length() != 0) {
				for (int j = (i + 1); j < piKariRisiBean.getRetuSu(); j++) {
					kariRisiDetail2 = piKariRisiBean.getDetail(j);
					if (kariRisiDetail2.getKikanFrom().trim().length() != 0) {
						if ((kariRisiDetail1.getKikanFrom().compareTo(kariRisiDetail2.getKikanTo()) <= 0) && (kariRisiDetail1.getKikanTo().compareTo(kariRisiDetail2.getKikanFrom()) >= 0)) {
							piMessage.addMessage(LACSDefine.MessageCode.ERROR_RELATE_COMBINATION, "適用期間（" + (i + 1) + "）と（" + (j + 1) + "）");
							result &= false;
						}
					}
				}
			}
		}

		return result;
	}

	/**
	 * 日付順チェック.
	 * 
	 * @param piName
	 *            項目名
	 * @param piDateFrom
	 *            開始日付オブジェクト
	 * @param piDateTo
	 *            終了日付オブジェクト
	 * @param piMessage
	 *            メッセージ
	 * @return 判定結果
	 */
	private boolean checkDateOrder(String piName, String piDateFrom, String piDateTo, LACSMessage piMessage) {
		boolean result = true;

		if (piDateFrom.trim().length() > 0 && piDateTo.trim().length() > 0) {
			if (piDateFrom.compareTo(piDateTo) > 0) {
				piMessage.addMessage(LACSDefine.MessageCode.ERROR_RELATE_COMBINATION, piName);
				result = false;
			}
		}

		return result;
	}

	/**
	 * リースユーザー存在チェック.
	 * 
	 * @param piName
	 *            項目名
	 * @param piData
	 *            オブジェクト
	 * @param piMessage
	 *            メッセージ
	 * @return 判定結果
	 * @throws SQLException
	 *             SQL実行例外
	 */
	private boolean checkLeaseUser(String piName, String piData, LACSMessage piMessage) throws SQLException {
		boolean result = true;

		if (piData.trim().length() > 0) {
			LACSUserEntity userEntity = new LACSUserEntity(this);

			try {
				userEntity.setCon(super.con);
				userEntity.setCosmosCode(Command.changeQt(piData));
				userEntity.execSQL();

				if (userEntity.getAllDataCount() < 1) {
					piMessage.addMessage(LACSDefine.MessageCode.ERROR_FIELD_NOT_EXIST, piName);
					result = false;
				}
			}
			finally {
				userEntity.close();
			}
		}

		return result;
	}

	/**
	 * SQL文作成（削除用）.
	 * 
	 * @param piKariRisiBean
	 *            リースユーザー別借入利子率マスタBean
	 * @return SQL
	 */
	private String makeSQL1(LACSKariRisiBean piKariRisiBean) {
		StringBuffer sql = new StringBuffer();

		StringBuffer where = new StringBuffer();
		where.append("     LU_COSMOS_CD = '" + Command.changeQt(piKariRisiBean.getCosmosCode()) + "' " + "\n");

		MakeSQLDeleteBase.makeSQL(sql, TABLE_NAME, where.toString());

		return sql.toString();
	}

	/**
	 * SQL文作成（追加用）.
	 * 
	 * @param piKariRisiBean
	 *            リースユーザー別借入利子率マスタBean
	 * @param piDetail
	 *            リースユーザー別借入利子率マスタ明細Bean
	 * @return SQL
	 */
	private String makeSQL2(LACSKariRisiBean piKariRisiBean, LACSKariRisiDetailBean piDetail) {
		StringBuffer sql = new StringBuffer();
		ArrayList<String> items = getItems(piKariRisiBean);
		ArrayList<String> values;

		values = getValues(piKariRisiBean, piDetail);

		MakeSQLInsertBase.makeSQL(sql, TABLE_NAME, items, values);

		return sql.toString();
	}

	/**
	 * DBカラム名取得.
	 * 
	 * @param piKariRisiBean
	 *            リース別借入利子率マスタBean
	 * @return DBカラム名
	 */
	private ArrayList<String> getItems(LACSKariRisiBean piKariRisiBean) {
		ArrayList<String> items = new ArrayList<String>();

		items.add("LU_COSMOS_CD"); // COSMOSコード
		items.add("ENT_DATE"); // 登録日時
		items.add("ENT_USR"); // 登録ユーザ
		items.add("TKY_TERM_FROM"); // 適用期間FROM
		items.add("TKY_TERM_TO"); // 適用期間TO
		items.add("UPD_DATE"); // 更新日時
		items.add("UPD_USR"); // 更新ユーザ
		items.add("JISH_KRI_RS_RT"); // 自社借入利子率

		return items;
	}

	/**
	 * DB更新値取得.
	 * 
	 * @param piKariRisiBean
	 *            リース会社マスタBean
	 * @param piDetail
	 *            リースユーザー別借入利子率マスタ明細Bean
	 * @return DB更新値
	 */
	private ArrayList<String> getValues(LACSKariRisiBean piKariRisiBean, LACSKariRisiDetailBean piDetail) {
		ArrayList<String> values = new ArrayList<String>();

		values.add("'" + Command.changeQt(piKariRisiBean.getCosmosCode()) + "'");
		values.add("SYSDATE");
		values.add("'" + super.getCommonBean().getCosmosCode() + "'");
		values.add("'" + Command.changeQt(piDetail.getKikanFrom()) + "'");
		values.add("'" + Command.changeQt(piDetail.getKikanTo()) + "'");
		values.add("SYSDATE");
		values.add("'" + super.getCommonBean().getCosmosCode() + "'");
		values.add(piDetail.getRisiRitu());

		return values;
	}

}
