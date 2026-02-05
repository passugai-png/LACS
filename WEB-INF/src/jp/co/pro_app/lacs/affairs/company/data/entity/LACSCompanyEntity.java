package jp.co.pro_app.lacs.affairs.company.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リース会社マスタEntity.
 * 
 * @author takeda
 * @version 20070907
 */
public class LACSCompanyEntity extends EntityBase {

	/**
	 * リース会社マスタ コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSCompanyEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	leasCompanyCode	= "";	// リース会社コード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT LC_NM " + "\n"); // リース会社名称
		super.sql.append("      ,LC_LOGO " + "\n"); // リース会社ロゴ
		super.sql.append("      ,LC_ZIP1 " + "\n"); // リース会社郵便番号１
		super.sql.append("      ,LC_ZIP2 " + "\n"); // リース会社郵便番号２
		super.sql.append("      ,LC_ADR1 " + "\n"); // リース会社住所１
		super.sql.append("      ,LC_ADR2 " + "\n"); // リース会社住所２
		super.sql.append("      ,LC_TNT_BUSHO_NM " + "\n"); // リース会社担当者部署
		super.sql.append("      ,LC_TNT_NM " + "\n"); // リース会社担当者
		super.sql.append("      ,LC_TNT_TELNO " + "\n"); // リース会社担当電話番号
		super.sql.append("      ,KKN_RUL_PTN " + "\n"); // 課金ルールパターン
		super.sql.append("      ,KHN_AMT " + "\n"); // 基本料金
		super.sql.append("      ,WRBKRT " + "\n"); // 割引率
		super.sql.append("      ,KIS_KBN " + "\n"); // 回収予定分割区分
		super.sql.append("      ,NULL KEI_AMT_KBN " + "\n"); // 契約額区分
		super.sql.append("      ,NULL KNU_AMT_KBN " + "\n"); // 購入額区分
		super.sql.append("      ,NULL OTH_CST_KBN " + "\n"); // その他原価区分
		super.sql.append("      ,SHR_YM " + "\n"); // 処理年月

		super.sql.append("      ,KIMATSU_AMT_OUT_CTL " + "\n"); // 期末残高出力制御

		super.sql.append("      ,SSN_TIME_OUT " + "\n"); // セッションタイムアウト時間
		super.sql.append("      ,CHK_CNT " + "\n"); // ログインエラー許容回数
		super.sql.append("      ,KRI_PASSWD_YUKO_TERM " + "\n"); // 仮パスワード有効期間
		super.sql.append("      ,HON_PASSWD_YUKO_TERM " + "\n"); // 本パスワード有効期間
		super.sql.append("      ,PASS_MIN " + "\n"); // パスワード文字の下限
		super.sql.append("      ,PASS_MAX " + "\n"); // パスワード文字の上限
		super.sql.append("      ,ERR_DSP_FLG " + "\n"); // エラー時の処理メニューの制御
		super.sql.append("      ,LC_LOGO " + "\n"); // リース会社ロゴファイル名
		super.sql.append("      ,SECURITY_INFO " + "\n"); // SSL証明書のマーク
		super.sql.append("      ,LOGIN_INFO " + "\n"); // お問合せ
		super.sql.append("      ,TYUKI_COMMENT1  " + "\n"); // 注記書類作成基準書可変文言１
		super.sql.append("      ,TYUKI_COMMENT2  " + "\n"); // 注記書類作成基準書可変文言２

		super.sql.append("FROM   M_LC " + "\n");
		super.sql.append("WHERE  LC_CD = '" + this.leasCompanyCode + "' " + "\n");

	}

	/**
	 * リース会社コードを設定.
	 * 
	 * @param piLeasCompanyCode
	 *            リース会社コード
	 */
	public void setLeasCompanyCode(String piLeasCompanyCode) {
		this.leasCompanyCode = piLeasCompanyCode;
	}

	/**
	 * リース会社名称を取得.
	 * 
	 * @return リース会社名称
	 */
	public String getName() {
		return super.getString("LC_NM");
	}

	/**
	 * リース会社ロゴを取得.
	 * 
	 * @return リース会社ロゴ
	 */
	public String getLogo() {
		return super.getString("LC_LOGO");
	}

	/**
	 * リース会社郵便番号１を取得.
	 * 
	 * @return リース会社郵便番号１
	 */
	public String getZip1() {
		return super.getString("LC_ZIP1");
	}

	/**
	 * リース会社郵便番号２を取得.
	 * 
	 * @return リース会社郵便番号２
	 */
	public String getZip2() {
		return super.getString("LC_ZIP2");
	}

	/**
	 * リース会社住所１を取得.
	 * 
	 * @return リース会社住所１
	 */
	public String getAddress1() {
		return super.getString("LC_ADR1");
	}

	/**
	 * リース会社住所２を取得.
	 * 
	 * @return リース会社住所２
	 */
	public String getAddress2() {
		return super.getString("LC_ADR2");
	}

	/**
	 * リース会社担当者部署を取得.
	 * 
	 * @return リース会社担当者部署
	 */
	public String getBusyo() {
		return super.getString("LC_TNT_BUSHO_NM");
	}

	/**
	 * リース会社担当者を取得.
	 * 
	 * @return リース会社担当者
	 */
	public String getTanto() {
		return super.getString("LC_TNT_NM");
	}

	/**
	 * リース会社担当電話番号を取得.
	 * 
	 * @return リース会社担当電話番号
	 */
	public String getTantoTel() {
		return super.getString("LC_TNT_TELNO");
	}

	/**
	 * 課金ルールパターンを取得.
	 * 
	 * @return 課金ルールパターン
	 */
	public String getKakinPattern() {
		return super.getString("KKN_RUL_PTN");
	}

	/**
	 * 基本料金を取得.
	 * 
	 * @return 基本料金
	 */
	public long getKihonAmount() {
		return super.getLong("KHN_AMT");
	}

	/**
	 * 割引率を取得.
	 * 
	 * @return 割引率
	 */
	public double getWaribiki() {
		return super.getDouble("WRBKRT");
	}

	/**
	 * 回収予定分割区分を取得.
	 * 
	 * @return 回収予定分割区分
	 */
	public String getKaisyuKbn() {
		return super.getString("KIS_KBN");
	}

	/**
	 * 契約額区分を取得.
	 * 
	 * @return 契約額区分
	 */
	public String getKeiyakuKbn() {
		return super.getString("KEI_AMT_KBN");
	}

	/**
	 * 購入額区分を取得.
	 * 
	 * @return 購入額区分
	 */
	public String getKounyuKbn() {
		return super.getString("KNU_AMT_KBN");
	}

	/**
	 * その他原価区分を取得.
	 * 
	 * @return その他原価区分
	 */
	public String getGenkaKbn() {
		return super.getString("OTH_CST_KBN");
	}

	/**
	 * 処理年月を取得.
	 * 
	 * @return 処理年月
	 */
	public String getSyoriYM() {
		return super.getString("SHR_YM");
	}

	/**
	 * 期末残高出力制御を取得.
	 * 
	 * @return 期末残高出力制御
	 */
	public String getKimatsuAmtOutCtl() {
		return super.getString("KIMATSU_AMT_OUT_CTL");
	}

	/**
	 * セッションタイムアウト時間を取得.
	 * 
	 * @return セッションタイムアウト時間
	 */
	public String getSessionTimeOut() {
		String retStr = super.getString("SSN_TIME_OUT");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;

	}

	/**
	 * ログインエラー許容回数を取得.
	 * 
	 * @return ログインエラー許容回数
	 */
	public String getLoginErrorMaxCount() {

		String retStr = super.getString("CHK_CNT");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 仮パスワード有効期間を取得.
	 * 
	 * @return 仮パスワード有効期間
	 */
	public String getTempPassValidityTerm() {

		String retStr = super.getString("KRI_PASSWD_YUKO_TERM");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 本パスワード有効期間を取得.
	 * 
	 * @return 本パスワード有効期間
	 */
	public String getPassValidityTerm() {

		String retStr = super.getString("HON_PASSWD_YUKO_TERM");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * パスワード文字の下限を取得.
	 * 
	 * @return パスワード文字の下限
	 */
	public String getPasswordLengthMin() {

		String retStr = super.getString("PASS_MIN");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * パスワード文字の上限を取得.
	 * 
	 * @return パスワード文字の上限
	 */
	public String getPasswordLengthMax() {

		String retStr = super.getString("PASS_MAX");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * エラー時の処理メニューの制御を取得.
	 * 
	 * @return エラー時の処理メニューの制御
	 */
	public String getErrorLockType() {

		String retStr = super.getString("ERR_DSP_FLG");
		if (retStr == null) {
			retStr = "0";
		}
		return retStr;
	}

	/**
	 * リース会社ロゴファイル名を取得.
	 * 
	 * @return リース会社ロゴファイル名
	 */
	public String getLogoFileName() {
		return super.getString("LC_LOGO");
	}

	/**
	 * SSL証明書のマークを取得.
	 * 
	 * @return SSL証明書のマーク
	 */
	public String getCertificateMarkURL() {
		return super.getString("SECURITY_INFO");
	}

	/**
	 * お問合せを取得.
	 * 
	 * @return お問合せ
	 */
	public String getFreeWord() {
		return super.getString("LOGIN_INFO");
	}

	/**
	 * 注記書類作成基準書可変文言１を取得.
	 * 
	 * @return 注記書類作成基準書可変文言１
	 */
	public String getTyukiComment1() {
		return super.getString("TYUKI_COMMENT1");
	}

	/**
	 * 注記書類作成基準書可変文言２を取得.
	 * 
	 * @return 注記書類作成基準書可変文言２
	 */
	public String getTyukiComment2() {
		return super.getString("TYUKI_COMMENT2");
	}

}
