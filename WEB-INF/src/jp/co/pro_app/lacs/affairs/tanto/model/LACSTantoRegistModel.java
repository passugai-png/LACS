package jp.co.pro_app.lacs.affairs.tanto.model;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCheckUtl;
import jp.co.pro_app.lacs.affairs.common.command.LACSLoginSecurity;
import jp.co.pro_app.lacs.affairs.common.command.LACSMessage;
import jp.co.pro_app.lacs.affairs.tanto.bean.LACSTantoBean;
import jp.co.pro_app.lacs.affairs.tanto.bean.LACSTantoUserComboBean;
import jp.co.pro_app.lacs.affairs.tanto.data.entity.LACSTantoEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.SecurityUtl;
import jp.co.pro_app.projframe.common.dbaccess.MakeSQLInsertBase;
import jp.co.pro_app.projframe.common.dbaccess.MakeSQLUpdateBase;
import jp.co.pro_app.projframe.common.dbaccess.NotSelectExecute;
import jp.co.pro_app.projframe.common.dbaccess.SelectEx;

/**
 * リースユーザー担当者マスタ：登録処理Model.
 * 
 * @author ohmura
 * @version 20070913
 */
public class LACSTantoRegistModel extends LACSTantoModelBase {

	/**
	 * テーブル名.
	 */
	private static final String	TABLE_NAME	= "M_LU_TNT";

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "登録";
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSTantoBean piTantoBean) throws Exception {

		NotSelectExecute notSelectExecute = new NotSelectExecute();
		LACSLoginSecurity security = new LACSLoginSecurity(this, super.con, piTantoBean.getUserID());
		ArrayList<String> sqls = null;

		try {
			if (this.checkInput(super.getCommonBean(), piTantoBean, message)) {

				this.getData(piTantoBean);

				notSelectExecute.setCon(super.con);
				sqls = this.getUserSQL(piTantoBean);
				sqls.add(makeSQL(piTantoBean));
				notSelectExecute.execState(sqls);
				security.delete();
				security.writePasswordHistory(piTantoBean.getPassword(), 5);

			}

			if (message.hasMessage()) {
				piTantoBean.setMessage(message.getMessage());
				super.setForwardPath("/jsp/T001.jsp");
			}
			else {
				super.setForwardPath("/return.tantolist");
			}
		}
		finally {
			notSelectExecute.closeState();
		}
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSTantoBean piTantoBean) throws SQLException {

		int userListCount = super.getParam("userListCount", 0);
		LACSTantoUserComboBean tantoUserComboBean = null;

		// piTantoBean.setCosmosCode(super.getInput("leasCompanyEntry", "").trim());
		piTantoBean.setUserTantoName(super.getInput("userTantoName", "").trim());
		piTantoBean.setPassword(super.getInput("password1", "").trim());
		piTantoBean.setPassword2(super.getInput("password2", "").trim());
		// piTantoBean.setLeasCompanyNm(super.getInput("leasCompanyNmEntry", "").trim());
		piTantoBean.setKriPassFlg(super.getInput("chkKriPassFlg", "").trim());

		// super.prepareComoboBox(piTantoBean);

		for (int i = 0; i < userListCount; i++) {
			tantoUserComboBean = piTantoBean.getUserList().get(i);

			tantoUserComboBean.setFilterString(super.getInput("leasCompanyNmEntry" + i, "").trim());
			tantoUserComboBean.getUserList().setSelectedValue(super.getInput("leasCompanyEntry" + i, ""));
		}

		piTantoBean.getLeasCompany().setSelectedValue(super.getInput("leasCompanyEntry", ""));

		piTantoBean.setMessage("");
	}

	/**
	 * データ取得.
	 * 
	 * @param piTantoBean
	 *            リースユーザーマスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	private void getData(LACSTantoBean piTantoBean) throws SQLException {
		LACSTantoEntity userEntity = new LACSTantoEntity(this);

		try {
			userEntity.setCon(super.con);

			userEntity.setUserId(piTantoBean.getUserID());

			userEntity.execSQL();

			piTantoBean.setDataMax(userEntity.getAllDataCount());
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
	 * @param piTantoBean
	 *            リースユーザーマスタBean
	 * @param piMessage
	 *            メッセージ
	 * @return チェック結果
	 * @throws SQLException
	 *             SQL実行例外
	 */
	private boolean checkInput(LACSCommonBean piCommonBean, LACSTantoBean piTantoBean, LACSMessage piMessage) throws SQLException {
		boolean result = true;
		SelectEx selectEx = new SelectEx(this.con);
		boolean temp = false;
		LACSTantoUserComboBean tantoUserComboBean = null;
		ArrayList<String> list = new ArrayList<String>();
		String userTemp = "";

		LACSLoginSecurity security = new LACSLoginSecurity(this, super.con, piTantoBean.getUserID());
		LACSCheckUtl checkUtl = new LACSCheckUtl(piMessage);

		result &= checkUtl.checkMandatory("ユーザID", piTantoBean.getUserID());
		result &= checkUtl.checkAlNumHalf("ユーザID", piTantoBean.getUserID());

		if (piTantoBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_NEW) {
			if (selectEx.getRecordCount("M_LU_TNT", "LU_ID = '" + Command.changeQt(piTantoBean.getUserID()) + "'") > 0) {
				message.addMessage(LACSDefine.MessageCode.ERROR_DB_DATA_EXIST, "ユーザID");
				result &= false;
			}
		}

		if (piTantoBean.getUserRight().equals(LACSDefine.UserRight.GENERAL)) {
			for (int i = 0; i < piTantoBean.getUserList().size(); i++) {
				tantoUserComboBean = piTantoBean.getUserList().get(i);

				if (tantoUserComboBean.getUserList().getValue().trim().length() > 0) {
					userTemp = tantoUserComboBean.getUserList().getValue();

					if (list.contains(tantoUserComboBean.getUserList().getValue())) {
						piMessage.addMessage(LACSDefine.MessageCode.ERROR_RELATE_DUPLICATE, "開示先");
						temp &= false;
					}
					else {
						list.add(tantoUserComboBean.getUserList().getValue());
					}
				}
			}

			temp = checkUtl.checkMandatory("開示先", userTemp);
		}
		else {
			temp = checkUtl.checkMandatory("開示先", piTantoBean.getUserList().get(0).getUserList().getValue());
		}

		result &= temp;

		result &= checkUtl.checkMandatory("新しいパスワード", piTantoBean.getPassword());
		// 20200526 arai 複雑性チェックに変更		
		result &= checkUtl.checkComplex("新しいパスワード", piTantoBean.getPassword(), true, true, true);
		result &= checkUtl.checkLength("新しいパスワード", piTantoBean.getPassword(), Convert.toInt(piTantoBean.getMinLength()), Convert.toInt(piTantoBean.getMaxLength()));

		if (!piTantoBean.getPassword().equals(piTantoBean.getPassword2())) {
			result &= false;
			this.message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_FIELD_DIFFERENT, new String[]{ "新しいパスワード", "確認パスワード" });
		}

		if (!security.checkPasswordHistory(piTantoBean.getPassword(), 5)) {
			result &= false;
			this.message.addMessage(LACSDefine.MessageCode.ERROR_DB_USED_PASSWORD);
		}

		if (piTantoBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_NEW) {
			result &= checkUtl.checkMandatory("仮発行", piTantoBean.getKriPassFlg());
		}

		if (result == true && security.checkLogin()) {
			message.addMessage(LACSDefine.MessageCode.ERROR_DB_LOGGEDIN, "登録");
			result &= false;
		}

		return result;
	}

	/**
	 * SQL文作成.
	 * 
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 * @return SQL
	 */
	private String makeSQL(LACSTantoBean piTantoBean) {
		StringBuffer sql = new StringBuffer();
		ArrayList<String> items = getItems(piTantoBean);
		ArrayList<String> values = getValues(piTantoBean);

		if (piTantoBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_UPD) {

			StringBuffer where = new StringBuffer();
			where.append("LU_ID = '" + Command.changeQt(piTantoBean.getUserID()) + "' " + "\n");
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
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 * @return DBカラム名
	 */
	private ArrayList<String> getItems(LACSTantoBean piTantoBean) {
		ArrayList<String> items = new ArrayList<String>();

		if (piTantoBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_NEW) {

			items.add("LU_ID"); // ユーザーID
			items.add("ENT_DATE"); // 登録日時
			items.add("ENT_USR"); // 登録ユーザ
		}
		items.add("UPD_DATE"); // 更新日時
		items.add("UPD_USR"); // 更新ユーザ
		items.add("LU_TNT_PASSWD"); // パスワード
		items.add("LU_TNT_NM"); // ユーザー名
		items.add("PASSWD_YUKO_TERM"); // パスワード有効期間
		items.add("KRI_PASS_FLG"); // 仮発行フラグ
		items.add("MISS_CNT"); // ミス回数
		items.add("LU_RIGHT_KBN"); // 利用者権限

		return items;
	}

	/**
	 * DB更新値取得.
	 * 
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 * @return DB更新値
	 */
	private ArrayList<String> getValues(LACSTantoBean piTantoBean) {
		ArrayList<String> values = new ArrayList<String>();

		if (piTantoBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_NEW) {

			values.add("'" + Command.changeQt(piTantoBean.getUserID()) + "'");
			values.add("SYSDATE");
			values.add("'" + super.getCommonBean().getCosmosCode() + "'");
		}
		values.add("SYSDATE");
		values.add("'" + super.getCommonBean().getCosmosCode() + "'");
		values.add("'" + Command.changeQt(SecurityUtl.getMD5(piTantoBean.getPassword())) + "'");
		values.add("'" + Command.changeQt(piTantoBean.getUserTantoName()) + "'");

		if ("1".equals(piTantoBean.getKriPassFlg())) {
			values.add("'" + Command.changeQt(piTantoBean.getKriPasswordTerm()) + "'");
		}
		else {
			values.add("'" + Command.changeQt(piTantoBean.getHonPasswordTerm()) + "'");
		}
		values.add("'" + Command.changeQt(Command.init(piTantoBean.getKriPassFlg(), "0")) + "'");
		values.add("'0'");
		values.add(piTantoBean.getUserRight()); // 利用者権限

		return values;
	}

	private ArrayList<String> getUserSQL(LACSTantoBean piTantoBean) {
		ArrayList<String> sql = new ArrayList<String>();
		LACSTantoUserComboBean tantoUserComboBean = null;

		sql.add("DELETE FROM M_LU_TNT_BETU_USER WHERE LU_ID = '" + Command.changeQt(piTantoBean.getUserID()) + "'");

		if (piTantoBean.getUserRight().equals(LACSDefine.UserRight.ADMIN)) {
			sql.add("INSERT INTO M_LU_TNT_BETU_USER (LU_ID, LU_COSMOS_CD, ENT_DATE, ENT_USR, UPD_DATE, UPD_USR) VALUES ('" + Command.changeQt(piTantoBean.getUserID()) + "', '" + LACSDefine.INFO_ALL + "', SYSDATE, 'LACS', SYSDATE, 'LACS')");
		}
		else {
			for (int i = 0; i < piTantoBean.getUserList().size(); i++) {
				tantoUserComboBean = piTantoBean.getUserList().get(i);

				if (tantoUserComboBean.getUserList().getValue().trim().length() > 0) {
					sql.add("INSERT INTO M_LU_TNT_BETU_USER (LU_ID, LU_COSMOS_CD, ENT_DATE, ENT_USR, UPD_DATE, UPD_USR) VALUES ('" + Command.changeQt(piTantoBean.getUserID()) + "', '" + Command.changeQt(tantoUserComboBean.getUserList().getValue()) + "', SYSDATE, 'LACS', SYSDATE, 'LACS')");
				}
			}
		}

		return sql;
	}
}
