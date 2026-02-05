package jp.co.pro_app.lacs.affairs.companyuser.model;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCheckUtl;
import jp.co.pro_app.lacs.affairs.common.command.LACSMessage;
import jp.co.pro_app.lacs.affairs.company.data.entity.LACSCompanyEntity;
import jp.co.pro_app.lacs.affairs.companyuser.bean.LACSCompanyUserBean;
import jp.co.pro_app.lacs.affairs.companyuser.data.entity.LACSCompanyUserEntity;
import jp.co.pro_app.lacs.affairs.user.data.entity.LACSUserEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.dbaccess.MakeSQLInsertBase;
import jp.co.pro_app.projframe.common.dbaccess.MakeSQLUpdateBase;
import jp.co.pro_app.projframe.common.dbaccess.NotSelectExecute;

/**
 * リース会社別リースユーザーマスタ：登録処理Model.
 * 
 * @author takeda
 * @version 20070907
 */
public class LACSCompanyUserRegistModel extends LACSCompanyUserModelBase {

	/**
	 * テーブル名.
	 */
	private static final String	TABLE_NAME	= "M_LC_BETU_LU";

	/**
	 * 業務個別処理.
	 * 
	 * @param piCompanyUserBean
	 *            リース会社別リースユーザーマスタBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSCompanyUserBean piCompanyUserBean) throws Exception {
		NotSelectExecute notSelectExecute = new NotSelectExecute();

		try {
			if (this.checkInput(super.getCommonBean(), piCompanyUserBean)) {

				notSelectExecute.setCon(super.con);
				notSelectExecute.execState(makeSQL(piCompanyUserBean));
			}

			if (message.hasMessage()) {
				piCompanyUserBean.setMessage(message.getMessage());
			}
			else {
				super.setForwardPath("/return.companyuserlist");
			}
		}
		finally {
			notSelectExecute.closeState();
		}

	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piCompanyUserBean
	 *            リース会社別リースユーザーマスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSCompanyUserBean piCompanyUserBean) throws SQLException {

		piCompanyUserBean.setCosmosCode(super.getInput("cosmosCode", "").trim());
		piCompanyUserBean.setTeikyouYMD(super.getInput("teikyouYMD", "").trim());
		piCompanyUserBean.setTeikyouYM(super.getInput("teikyouYM", "").trim());

		piCompanyUserBean.setMessage("");
	}

	/**
	 * データ取得.
	 * 
	 * @param piCompanyUserBean
	 *            リース会社別リースユーザーマスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	private void getData(LACSCompanyUserBean piCompanyUserBean) throws SQLException {
		LACSCompanyUserEntity companyUserEntity = new LACSCompanyUserEntity(this);

		try {
			companyUserEntity.setCon(super.con);

			companyUserEntity.setLeasCompanyCode(piCompanyUserBean.getLeasCompanyCode());
			companyUserEntity.setTorihikiCode(piCompanyUserBean.getTorihikiCode());

			piCompanyUserBean.setDataMax(companyUserEntity.getAllDataCount());
		}
		finally {
			companyUserEntity.close();
		}
	}

	/**
	 * 入力チェック.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piCompanyUserBean
	 *            リース会社別リースユーザーマスタBean
	 * @return チェック結果
	 * @throws SQLException
	 */
	private boolean checkInput(LACSCommonBean piCommonBean, LACSCompanyUserBean piCompanyUserBean) throws SQLException {
		boolean result = true;

		LACSCheckUtl checkUtl = new LACSCheckUtl(message);

		result &= checkUtl.checkMandatory("リース会社コード", piCompanyUserBean.getLeasCompanyCode());
		result &= this.checkLeaseCompany("リース会社コード", piCompanyUserBean.getLeasCompanyCode());
		result &= checkUtl.checkMandatory("取引先コード", piCompanyUserBean.getTorihikiCode());
		result &= checkUtl.checkTabooChar("取引先コード", piCompanyUserBean.getTorihikiCode());

		result &= checkUtl.checkMandatory("開示先コード", piCompanyUserBean.getCosmosCode());
		result &= this.checkLeaseUser("開示先コード", piCompanyUserBean.getCosmosCode(), message);

		this.getData(piCompanyUserBean);

		if (piCompanyUserBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_NEW && piCompanyUserBean.getDataMax() > 0) {
			message.addMessage(LACSDefine.MessageCode.ERROR_DB_DATA_EXIST, "リース会社コード・取引先コードの組み合わせ");
			result = false;
		}

		return result;
	}

	/**
	 * リース会社存在チェック.
	 * 
	 * @param piName
	 *            項目名
	 * @param piData
	 *            オブジェクト
	 * @return 判定結果
	 * @throws SQLException
	 *             SQL実行例外
	 */
	private boolean checkLeaseCompany(String piName, String piData) throws SQLException {
		boolean result = true;

		if (piData.trim().length() > 0) {
			LACSCompanyEntity companyEntity = new LACSCompanyEntity(this);

			try {
				companyEntity.setCon(super.con);
				companyEntity.setLeasCompanyCode(Command.changeQt(piData));
				companyEntity.execSQL();

				if (companyEntity.getAllDataCount() < 1) {
					message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_NOT_EXIST, piName);
					result = false;
				}
			}
			finally {
				companyEntity.close();
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
	 * SQL文作成.
	 * 
	 * @param piCompanyUserBean
	 *            リース会社別リースユーザーマスタBean
	 * @return SQL
	 */
	private String makeSQL(LACSCompanyUserBean piCompanyUserBean) {
		StringBuffer sql = new StringBuffer();
		ArrayList<String> items = getItems(piCompanyUserBean);
		ArrayList<String> values = getValues(piCompanyUserBean);

		if (piCompanyUserBean.getDataMax() > 0) {

			StringBuffer where = new StringBuffer();
			where.append("LC_CD = '" + Command.changeQt(piCompanyUserBean.getLeasCompanyCode()) + "' AND " + "\n");
			where.append("LU_TRSK_CD = '" + Command.changeQt(piCompanyUserBean.getTorihikiCode()) + "'" + "\n");
			MakeSQLUpdateBase.makeSQL(sql, TABLE_NAME, items, values, where.toString());
		}
		else {

			MakeSQLInsertBase.makeSQL(sql, TABLE_NAME, items, values);
		}

		return sql.toString();
	}

	/**
	 * DBカラム名取得.
	 * 
	 * @param piCompanyUserBean
	 *            リース会社マスタBean
	 * @return DBカラム名
	 */
	private ArrayList<String> getItems(LACSCompanyUserBean piCompanyUserBean) {
		ArrayList<String> items = new ArrayList<String>();

		if (piCompanyUserBean.getDataMax() <= 0) {

			items.add("LC_CD"); // リース会社コード
			items.add("LU_TRSK_CD"); // リースユーザー取引先コード
			items.add("ENT_DATE"); // 登録日時
			items.add("ENT_USR"); // 登録ユーザ
		}
		items.add("LU_COSMOS_CD"); // リースユーザーCOSMOSコード
		items.add("UPD_DATE"); // 更新日時
		items.add("UPD_USR"); // 更新ユーザ
		items.add("CHANGE_FLG"); // 更新ユーザ

		return items;
	}

	/**
	 * DB更新値取得.
	 * 
	 * @param piCompanyUserBean
	 *            リース会社別リースユーザーマスタBean
	 * @return DB更新値
	 */
	private ArrayList<String> getValues(LACSCompanyUserBean piCompanyUserBean) {
		ArrayList<String> values = new ArrayList<String>();

		if (piCompanyUserBean.getDataMax() <= 0) {

			values.add("'" + Command.changeQt(piCompanyUserBean.getLeasCompanyCode()) + "'");
			values.add("'" + Command.changeQt(piCompanyUserBean.getTorihikiCode()) + "'");
			values.add("SYSDATE");
			values.add("'" + Command.changeQt(super.getCommonBean().getCosmosCode()) + "'");
		}
		values.add("'" + Command.changeQt(piCompanyUserBean.getCosmosCode()) + "'");
		values.add("SYSDATE");
		values.add("'" + Command.changeQt(super.getCommonBean().getCosmosCode()) + "'");
		values.add("'1'");

		return values;
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "登録";
	}
}
