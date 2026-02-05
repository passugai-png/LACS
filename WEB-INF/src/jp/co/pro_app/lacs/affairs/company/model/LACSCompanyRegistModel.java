package jp.co.pro_app.lacs.affairs.company.model;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCheckUtl;
import jp.co.pro_app.lacs.affairs.company.bean.LACSCompanyBean;
import jp.co.pro_app.lacs.affairs.company.data.entity.LACSCompanyEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;
import jp.co.pro_app.projframe.common.dbaccess.MakeSQLInsertBase;
import jp.co.pro_app.projframe.common.dbaccess.MakeSQLUpdateBase;
import jp.co.pro_app.projframe.common.dbaccess.NotSelectExecute;

/**
 * リース会社マスタ：登録処理Model.
 * 
 * @author takeda
 * @version 20070911
 */
public class LACSCompanyRegistModel extends LACSCompanyModelBase {

	/**
	 * テーブル名.
	 */
	private static final String	TABLE_NAME	= "M_LC";

	/**
	 * 業務個別処理.
	 * 
	 * @param piCompanyBean
	 *            リース会社マスタBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSCompanyBean piCompanyBean) throws Exception {
		NotSelectExecute notSelectExecute = new NotSelectExecute();
		ArrayList<String> sqls = null;

		try {

			if (this.checkInput(super.getCommonBean(), piCompanyBean)) {

				notSelectExecute.setCon(super.con);

				sqls = dispControlCommon.getSQLDispControl(LACSDefine.INFO_ALL);
				sqls.add(makeSQL(piCompanyBean));

				notSelectExecute.execState(sqls);
			}

			if (message.hasMessage()) {
				piCompanyBean.setMessage(message.getMessage());
				super.setForwardPath("/jsp/C001.jsp");
			}
			else {
				super.setForwardPath("/show.top");
			}
		}
		finally {
			notSelectExecute.closeState();
		}

	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piCompanyBean
	 *            リース会社マスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSCompanyBean piCompanyBean) throws SQLException {

		piCompanyBean.setName(super.getInput("name", "").trim());
		piCompanyBean.setLogo(super.getInput("logo", "").trim());
		piCompanyBean.setZip1(super.getInput("zip1", "").trim());
		piCompanyBean.setZip2(super.getInput("zip2", "").trim());
		piCompanyBean.setAddress1(super.getInput("address1", "").trim());
		piCompanyBean.setAddress2(super.getInput("address2", "").trim());
		piCompanyBean.setBusyo(super.getInput("busyo", "").trim());
		piCompanyBean.setTanto(super.getInput("tanto", "").trim());
		piCompanyBean.setTantoTel(super.getInput("tantoTel", "").trim());
		piCompanyBean.setKakinPattern(super.getInput("kakinPattern", ""));
		piCompanyBean.setKihonAmount(super.getInput("kihonAmount", ""));
		piCompanyBean.setWaribiki(super.getInput("waribiki", ""));
		piCompanyBean.setKaisyuKbn(super.getInput("kaisyuKbn", ""));
		piCompanyBean.setSyoriYM(super.getInput("syoriYM", "").trim());

		piCompanyBean.setKimatsuAmtOutCtl(super.getInput("kimatsuAmtOutCtl", "0").trim());

		piCompanyBean.setSessionTimeOut(super.getInput("sessionTimeOut", "").trim());
		piCompanyBean.setLoginErrorMaxCount(super.getInput("loginErrorMaxCount", "").trim());
		piCompanyBean.setTempPassValidityTerm(super.getInput("tempPassValidityTerm", "").trim());
		piCompanyBean.setPassValidityTerm(super.getInput("passValidityTerm", "").trim());
		piCompanyBean.setPasswordLengthMin(super.getInput("passwordLengthMin", "").trim());
		piCompanyBean.setPasswordLengthMax(super.getInput("passwordLengthMax", "").trim());
		piCompanyBean.setErrorLockType(super.getInput("errorLockType", "0").trim());
		piCompanyBean.setLogoFileName(super.getInput("logoFileName", "").trim());
		piCompanyBean.setCertificateMarkURL(super.getInput("certificateMarkURL", "").trim());
		piCompanyBean.setFreeWord(super.getInput("freeWord", "").trim());

		if ("1".equals(super.getCommonBean().getShowTyukiComment())) {
			piCompanyBean.setTyukiComment1(super.getInput("tyukiComment1", "").trim());
			piCompanyBean.setTyukiComment2(super.getInput("tyukiComment2", "").trim());
		}

		dispControlCommon.getInputDispControl();

		piCompanyBean.setMessage("");
	}

	/**
	 * データ取得.
	 * 
	 * @param piCompanyBean
	 *            リース会社マスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	private void getData(LACSCompanyBean piCompanyBean) throws SQLException {
		LACSCompanyEntity companyUserEntity = new LACSCompanyEntity(this);

		try {
			companyUserEntity.setCon(super.con);

			companyUserEntity.setLeasCompanyCode(piCompanyBean.getLeasCompanyCode());

			companyUserEntity.execSQL();

			piCompanyBean.setDataMax(companyUserEntity.getAllDataCount());
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
	 * @param piCompanyBean
	 *            リース会社マスタBean
	 * @return チェック結果
	 * @throws SQLException
	 *             SQL実行例外
	 */
	private boolean checkInput(LACSCommonBean piCommonBean, LACSCompanyBean piCompanyBean) throws SQLException {
		boolean result = true;

		int passwordLengthMax = 50; // パスワード文字の上限

		LACSCheckUtl checkUtl = new LACSCheckUtl(message);

		result &= checkUtl.checkMandatory("リース会社コード", piCompanyBean.getLeasCompanyCode());
		result &= checkUtl.checkAlNumHalf("リース会社コード", piCompanyBean.getLeasCompanyCode());
		result &= checkUtl.checkMandatory("名称", piCompanyBean.getName());
		result &= checkUtl.checkLength("名称", piCompanyBean.getName(), 50);
		result &= checkUtl.checkLength("ロゴ", piCompanyBean.getLogo(), 50);
		result &= checkUtl.checkMandatory("郵便番号１", piCompanyBean.getZip1());
		result &= checkUtl.checkNumeric("郵便番号１", piCompanyBean.getZip1());
		result &= checkUtl.checkMandatory("郵便番号２", piCompanyBean.getZip2());
		result &= checkUtl.checkNumeric("郵便番号２", piCompanyBean.getZip2());
		result &= checkUtl.checkMandatory("住所１", piCompanyBean.getAddress1());

		result &= checkUtl.checkLength("担当者部署", piCompanyBean.getBusyo(), 50);

		result &= checkUtl.checkLength("担当者", piCompanyBean.getTanto(), 50);
		result &= checkUtl.checkMandatory("担当電話番号", piCompanyBean.getTantoTel());
		result &= checkUtl.checkTelFax("担当電話番号", piCompanyBean.getTantoTel());

		if (piCompanyBean.getKaisyuKbn().trim().length() == 0) {
			result &= false;
			message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_NON_CHECK, "回収予定分割区分");
		}

		result &= checkUtl.checkMandatory("処理済年月", piCompanyBean.getSyoriYM());
		result &= checkUtl.checkDate("処理済年月", piCompanyBean.getSyoriYM() + (piCompanyBean.getSyoriYM().length() != 0 ? "01" : ""));

		result &= checkUtl.checkMandatory("セッションタイムアウト時間", piCompanyBean.getSessionTimeOut());
		result &= checkUtl.checkNumeric("セッションタイムアウト時間", piCompanyBean.getSessionTimeOut());

		if (piCompanyBean.getSessionTimeOut().trim().length() != 0) {
			if (Convert.toLong(piCompanyBean.getSessionTimeOut()) == 0) {
				result &= false;
				message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_OVER_MIN_NUMBER, new String[]{ "セッションタイムアウト時間", "1" });
			}
		}

		result &= checkUtl.checkMandatory("ログインエラー許容回数", piCompanyBean.getLoginErrorMaxCount());
		result &= checkUtl.checkNumeric("ログインエラー許容回数", piCompanyBean.getLoginErrorMaxCount());
		
		if (piCompanyBean.getLoginErrorMaxCount().trim().length() != 0) {
			if (Convert.toLong(piCompanyBean.getLoginErrorMaxCount()) == 0) {
				result &= false;
				message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_OVER_MIN_NUMBER, new String[]{ "ログインエラー許容回数", "1" });
			}
		}
		
		result &= checkUtl.checkMandatory("仮パスワード有効期間", piCompanyBean.getTempPassValidityTerm());
		result &= checkUtl.checkNumeric("仮パスワード有効期間", piCompanyBean.getTempPassValidityTerm());
		
		if (piCompanyBean.getTempPassValidityTerm().trim().length() != 0) {
			if (Convert.toLong(piCompanyBean.getTempPassValidityTerm()) == 0) {
				result &= false;
				message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_OVER_MIN_NUMBER, new String[]{ "仮パスワード有効期間", "1" });
			}
		}
		
		result &= checkUtl.checkMandatory("本パスワード有効期間", piCompanyBean.getPassValidityTerm());
		result &= checkUtl.checkNumeric("本パスワード有効期間", piCompanyBean.getPassValidityTerm());
		
		if (piCompanyBean.getPassValidityTerm().trim().length() != 0) {
			if (Convert.toLong(piCompanyBean.getPassValidityTerm()) == 0) {
				result &= false;
				message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_OVER_MIN_NUMBER, new String[]{ "本パスワード有効期間", "1" });
			}
		}

		result &= checkUtl.checkMandatory("パスワード文字の上限", piCompanyBean.getPasswordLengthMax());
		result &= checkUtl.checkNumeric("パスワード文字の上限", piCompanyBean.getPasswordLengthMax(), passwordLengthMax);

		if (piCompanyBean.getPasswordLengthMax().trim().length() != 0) {
			if (Convert.toLong(piCompanyBean.getPasswordLengthMax()) == 0) {
				result &= false;
				message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_OVER_MIN_NUMBER, new String[]{ "パスワード文字の上限", "1" });
			}
			else {
				if (Convert.toLong(piCompanyBean.getPasswordLengthMax()) <= passwordLengthMax) {
					passwordLengthMax = Integer.parseInt(piCompanyBean.getPasswordLengthMax());

				}
			}
		}

		result &= checkUtl.checkMandatory("パスワード文字の下限", piCompanyBean.getPasswordLengthMin());
		result &= checkUtl.checkNumeric("パスワード文字の下限", piCompanyBean.getPasswordLengthMin(), passwordLengthMax);
		
		if (piCompanyBean.getPasswordLengthMin().trim().length() != 0) {
			if (Convert.toLong(piCompanyBean.getPasswordLengthMin()) == 0) {
				result &= false;
				message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_OVER_MIN_NUMBER, new String[]{ "パスワード文字の下限", "1" });
			}
		}

		if (piCompanyBean.getFreeWord().replaceAll("\r\n", "\n").length() >= 2000) {
			result &= false;
			message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_CHAR_COUNT, new String[]{ "お問合せ", "2000" });
		}

		this.getData(piCompanyBean);

		if (piCompanyBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_NEW && piCompanyBean.getDataMax() > 0) {
			message.addMessage(LACSDefine.MessageCode.ERROR_DB_DATA_EXIST, "リース会社コード");
			result = false;
		}

		return result;
	}

	/**
	 * SQL文作成.
	 * 
	 * @param piCompanyBean
	 *            リース会社マスタBean
	 * @return SQL
	 */
	private String makeSQL(LACSCompanyBean piCompanyBean) {
		StringBuffer sql = new StringBuffer();
		ArrayList<String> items = getItems(piCompanyBean);
		ArrayList<String> values = getValues(piCompanyBean);

		if (piCompanyBean.getDataMax() > 0) {

			StringBuffer where = new StringBuffer();
			where.append("LC_CD = '" + Command.changeQt(piCompanyBean.getLeasCompanyCode()) + "' " + "\n");
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
	 * @param piCompanyBean
	 *            リース会社マスタBean
	 * @return DBカラム名
	 */
	private ArrayList<String> getItems(LACSCompanyBean piCompanyBean) {
		ArrayList<String> items = new ArrayList<String>();

		if (piCompanyBean.getDataMax() <= 0) {

			items.add("LC_CD"); // リース会社コード
			items.add("ENT_DATE"); // 登録日時
			items.add("ENT_USR"); // 登録ユーザ
		}
		items.add("UPD_DATE"); // 更新日時
		items.add("UPD_USR"); // 更新ユーザ
		items.add("LC_NM"); // リース会社名称
		items.add("LC_LOGO"); // リース会社ロゴ
		items.add("LC_ZIP1"); // リース会社郵便番号１
		items.add("LC_ZIP2"); // リース会社郵便番号２
		items.add("LC_ADR1"); // リース会社住所１
		items.add("LC_ADR2"); // リース会社住所２
		items.add("LC_TNT_BUSHO_NM"); // リース会社担当者部署
		items.add("LC_TNT_NM"); // リース会社担当者
		items.add("LC_TNT_TELNO"); // リース会社担当電話番号

		items.add("KIS_KBN"); // 回収予定分割区分
		items.add("SHR_YM"); // 処理年月

		items.add("KIMATSU_AMT_OUT_CTL"); // 期末残高出力制御

		items.add("SSN_TIME_OUT"); // セッションタイムアウト時間
		items.add("CHK_CNT"); // ログインエラー許容回数
		items.add("KRI_PASSWD_YUKO_TERM"); // 仮パスワード有効期間
		items.add("HON_PASSWD_YUKO_TERM"); // 本パスワード有効期間
		items.add("PASS_MIN"); // パスワード文字の下限
		items.add("PASS_MAX"); // パスワード文字の上限
		items.add("ERR_DSP_FLG"); // エラー時の処理メニューの制御
		items.add("SECURITY_INFO"); // SSL証明書のマーク
		items.add("LOGIN_INFO"); // お問合せ
		if ("1".equals(super.getCommonBean().getShowTyukiComment())) {
			items.add("TYUKI_COMMENT1"); // 注記書類作成基準書可変文言１
			items.add("TYUKI_COMMENT2"); // 注記書類作成基準書可変文言２
		}

		return items;
	}

	/**
	 * DB更新値取得.
	 * 
	 * @param piCompanyBean
	 *            リース会社マスタBean
	 * @return DB更新値
	 */
	private ArrayList<String> getValues(LACSCompanyBean piCompanyBean) {
		ArrayList<String> values = new ArrayList<String>();

		if (piCompanyBean.getDataMax() <= 0) {

			values.add("'" + Command.changeQt(piCompanyBean.getLeasCompanyCode()) + "'");
			values.add("SYSDATE");
			values.add("'" + super.getCommonBean().getCosmosCode() + "'");
		}
		values.add("SYSDATE");
		values.add("'" + super.getCommonBean().getCosmosCode() + "'");
		values.add("'" + Command.changeQt(piCompanyBean.getName()) + "'");

		values.add("'" + Command.changeQt(piCompanyBean.getLogoFileName()) + "'");

		values.add("'" + Command.changeQt(piCompanyBean.getZip1()) + "'");
		values.add("'" + Command.changeQt(piCompanyBean.getZip2()) + "'");
		values.add("'" + Command.changeQt(piCompanyBean.getAddress1()) + "'");
		values.add("'" + Command.changeQt(piCompanyBean.getAddress2()) + "'");
		values.add("'" + Command.changeQt(piCompanyBean.getBusyo()) + "'");
		values.add("'" + Command.changeQt(piCompanyBean.getTanto()) + "'");
		values.add("'" + Command.changeQt(piCompanyBean.getTantoTel()) + "'");

		values.add("'" + Command.changeQt(piCompanyBean.getKaisyuKbn()) + "'");
		values.add("'" + StringUtl.toHalfChar(Command.changeQt(piCompanyBean.getSyoriYM())) + "'");

		values.add("'" + Command.changeQt(piCompanyBean.getKimatsuAmtOutCtl()) + "'");

		values.add("'" + Command.changeQt(piCompanyBean.getSessionTimeOut()) + "'");
		values.add("'" + Command.changeQt(piCompanyBean.getLoginErrorMaxCount()) + "'");
		values.add("'" + Command.changeQt(piCompanyBean.getTempPassValidityTerm()) + "'");
		values.add("'" + Command.changeQt(piCompanyBean.getPassValidityTerm()) + "'");
		values.add("'" + Command.changeQt(piCompanyBean.getPasswordLengthMin()) + "'");
		values.add("'" + Command.changeQt(piCompanyBean.getPasswordLengthMax()) + "'");
		values.add("'" + Command.changeQt(piCompanyBean.getErrorLockType()) + "'");

		values.add("'" + Command.changeQt(piCompanyBean.getCertificateMarkURL()) + "'");
		values.add("'" + Command.changeQt(piCompanyBean.getFreeWord()) + "'");
		if ("1".equals(super.getCommonBean().getShowTyukiComment())) {
			values.add("'" + Command.changeQt(piCompanyBean.getTyukiComment1()) + "'");
			values.add("'" + Command.changeQt(piCompanyBean.getTyukiComment2()) + "'");
		}

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
