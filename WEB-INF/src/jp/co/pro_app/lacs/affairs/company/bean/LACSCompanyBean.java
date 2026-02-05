package jp.co.pro_app.lacs.affairs.company.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSDispControlBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSMaintenanceBeanBase;

/**
 * リース会社マスタBean.
 * 
 * @author takeda
 * @version 20070910
 */
public class LACSCompanyBean extends LACSMaintenanceBeanBase {

	private static final long serialVersionUID = 1L;

	private String				leasCompanyCode			= "";							// リース会社コード

	private String				name					= "";							// リース会社名称

	private String				logo					= "";							// リース会社ロゴ

	private String				zip1					= "";							// リース会社郵便番号１

	private String				zip2					= "";							// リース会社郵便番号２

	private String				address1				= "";							// リース会社住所１

	private String				address2				= "";							// リース会社住所２

	private String				busyo					= "";							// リース会社担当者部署

	private String				tanto					= "";							// リース会社担当者

	private String				tantoTel				= "";							// リース会社担当電話番号

	private String				kakinPattern			= "";							// 課金ルールパターン

	private String				kihonAmount				= "";							// 基本料金

	private String				waribiki				= "";							// 割引率

	private String				kaisyuKbn				= "";							// 回収予定分割区分

	private String				syoriYM					= "";							// 処理年月

	private String				condCompanyCode			= "";							// リース会社コード(条件)

	private String				kimatsuAmtOutCtl		= "";							// 期末残高出力制御

	private String				sessionTimeOut			= "";							// セッションタイムアウト時間

	private String				loginErrorMaxCount		= "";							// ログインエラー許容回数

	private String				tempPassValidityTerm	= "";							// 仮パスワード有効期間

	private String				passValidityTerm		= "";							// 本パスワード有効期間

	private String				passwordLengthMin		= "";							// パスワード文字の下限

	private String				passwordLengthMax		= "";							// パスワード文字の上限

	private String				errorLockType			= "";							// エラー時の処理メニューの制御

	private String				logoFileName			= "";							// リース会社ロゴファイル名

	private String				certificateMarkURL		= "";							// SSL証明書のマーク

	private String				freeWord				= "";							// お問合せ

	private String				tyukiComment1			= "";							// 注記書類作成基準書文言１

	private String				tyukiComment2			= "";							// 注記書類作成基準書文言２

	private LACSDispControlBean	dispControl				= new LACSDispControlBean();	// 表示制御

	/**
	 * コンストラクタ.
	 */
	public LACSCompanyBean() {
	}

	/**
	 * 初期化.
	 */
	public void init() {
		this.leasCompanyCode = "";
		super.init();
	}

	/**
	 * リース会社コードを取得.
	 * 
	 * @return リース会社コード
	 */
	public String getLeasCompanyCode() {
		return this.leasCompanyCode;
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
		return this.name;
	}

	/**
	 * リース会社名称を設定.
	 * 
	 * @param piName
	 *            リース会社名称
	 */
	public void setName(String piName) {
		this.name = piName;
	}

	/**
	 * リース会社ロゴを取得.
	 * 
	 * @return リース会社ロゴ
	 */
	public String getLogo() {
		return this.logo;
	}

	/**
	 * リース会社ロゴを設定.
	 * 
	 * @param piLogo
	 *            リース会社ロゴ
	 */
	public void setLogo(String piLogo) {
		this.logo = piLogo;
	}

	/**
	 * リース会社郵便番号１を取得.
	 * 
	 * @return リース会社郵便番号１
	 */
	public String getZip1() {
		return this.zip1;
	}

	/**
	 * リース会社郵便番号１を設定.
	 * 
	 * @param piLcZip1
	 *            リース会社郵便番号１
	 */
	public void setZip1(String piLcZip1) {
		this.zip1 = piLcZip1;
	}

	/**
	 * リース会社郵便番号２を取得.
	 * 
	 * @return リース会社郵便番号２
	 */
	public String getZip2() {
		return this.zip2;
	}

	/**
	 * リース会社郵便番号２を設定.
	 * 
	 * @param piLcZip2
	 *            リース会社郵便番号２
	 */
	public void setZip2(String piLcZip2) {
		this.zip2 = piLcZip2;
	}

	/**
	 * リース会社住所１を取得.
	 * 
	 * @return リース会社住所１
	 */
	public String getAddress1() {
		return this.address1;
	}

	/**
	 * リース会社住所１を設定.
	 * 
	 * @param piLcAddress1
	 *            リース会社住所１
	 */
	public void setAddress1(String piLcAddress1) {
		this.address1 = piLcAddress1;
	}

	/**
	 * リース会社住所２を取得.
	 * 
	 * @return リース会社住所２
	 */
	public String getAddress2() {
		return this.address2;
	}

	/**
	 * リース会社住所２を設定.
	 * 
	 * @param piLcAddress2
	 *            リース会社住所２
	 */
	public void setAddress2(String piLcAddress2) {
		this.address2 = piLcAddress2;
	}

	/**
	 * リース会社担当者部署を取得.
	 * 
	 * @return リース会社担当者部署
	 */
	public String getBusyo() {
		return this.busyo;
	}

	/**
	 * リース会社担当者部署を設定.
	 * 
	 * @param piBusyo
	 *            リース会社担当者部署
	 */
	public void setBusyo(String piBusyo) {
		this.busyo = piBusyo;
	}

	/**
	 * リース会社担当者を取得.
	 * 
	 * @return リース会社担当者
	 */
	public String getTanto() {
		return this.tanto;
	}

	/**
	 * リース会社担当者を設定.
	 * 
	 * @param piTanto
	 *            リース会社担当者
	 */
	public void setTanto(String piTanto) {
		this.tanto = piTanto;
	}

	/**
	 * リース会社担当電話番号を取得.
	 * 
	 * @return リース会社担当電話番号
	 */
	public String getTantoTel() {
		return this.tantoTel;
	}

	/**
	 * リース会社担当電話番号を設定.
	 * 
	 * @param piTantoTel
	 *            リース会社担当電話番号
	 */
	public void setTantoTel(String piTantoTel) {
		this.tantoTel = piTantoTel;
	}

	/**
	 * 課金ルールパターンを取得.
	 * 
	 * @return 課金ルールパターン
	 */
	public String getKakinPattern() {
		return this.kakinPattern;
	}

	/**
	 * 課金ルールパターンを設定.
	 * 
	 * @param piKakinPattern
	 *            課金ルールパターン
	 */
	public void setKakinPattern(String piKakinPattern) {
		this.kakinPattern = piKakinPattern;
	}

	/**
	 * 基本料金を取得.
	 * 
	 * @return 基本料金
	 */
	public String getKihonAmount() {
		return this.kihonAmount;
	}

	/**
	 * 基本料金を設定.
	 * 
	 * @param piKihonAmount
	 *            基本料金
	 */
	public void setKihonAmount(String piKihonAmount) {
		this.kihonAmount = piKihonAmount;
	}

	/**
	 * 割引率を取得.
	 * 
	 * @return 割引率
	 */
	public String getWaribiki() {
		return this.waribiki;
	}

	/**
	 * 割引率を設定.
	 * 
	 * @param piWaribiki
	 *            割引率
	 */
	public void setWaribiki(String piWaribiki) {
		this.waribiki = piWaribiki;
	}

	/**
	 * 回収予定分割区分を取得.
	 * 
	 * @return 回収予定分割区分
	 */
	public String getKaisyuKbn() {
		return this.kaisyuKbn;
	}

	/**
	 * 回収予定分割区分を設定.
	 * 
	 * @param piKaisyuKbn
	 *            回収予定分割区分
	 */
	public void setKaisyuKbn(String piKaisyuKbn) {
		this.kaisyuKbn = piKaisyuKbn;
	}

	/**
	 * 処理年月を取得.
	 * 
	 * @return 処理年月
	 */
	public String getSyoriYM() {
		return this.syoriYM;
	}

	/**
	 * 処理年月を設定.
	 * 
	 * @param piSyoriYM
	 *            処理年月
	 */
	public void setSyoriYM(String piSyoriYM) {
		this.syoriYM = piSyoriYM;
	}

	/**
	 * リース会社コード(条件)を取得.
	 * 
	 * @return リース会社コード(条件)
	 */
	public String getCondCompanyCode() {
		return this.condCompanyCode;
	}

	/**
	 * リース会社コード(条件)を設定.
	 * 
	 * @param piCondCompanyCode
	 *            リース会社コード(条件)
	 */
	public void setCondCompanyCode(String piCondCompanyCode) {
		this.condCompanyCode = piCondCompanyCode;
	}

	/**
	 * 期末残高出力制御を取得.
	 * 
	 * @return 期末残高出力制御
	 */
	public String getKimatsuAmtOutCtl() {
		return this.kimatsuAmtOutCtl;
	}

	/**
	 * 期末残高出力制御を設定.
	 * 
	 * @param piKimatsuAmtOutCtl
	 *            期末残高出力制御
	 */
	public void setKimatsuAmtOutCtl(String piKimatsuAmtOutCtl) {
		this.kimatsuAmtOutCtl = piKimatsuAmtOutCtl;
	}

	/**
	 * セッションタイムアウト時間を取得.
	 * 
	 * @return セッションタイムアウト時間
	 */
	public String getSessionTimeOut() {
		return this.sessionTimeOut;
	}

	/**
	 * セッションタイムアウト時間を設定.
	 * 
	 * @param piSessionTimeOut
	 *            セッションタイムアウト時間
	 */
	public void setSessionTimeOut(String piSessionTimeOut) {
		this.sessionTimeOut = piSessionTimeOut;
	}

	/**
	 * ログインエラー許容回数を取得.
	 * 
	 * @return ログインエラー許容回数
	 */
	public String getLoginErrorMaxCount() {
		return this.loginErrorMaxCount;
	}

	/**
	 * ログインエラー許容回数を設定.
	 * 
	 * @param piLoginErrorMaxCoun
	 *            ログインエラー許容回数
	 */
	public void setLoginErrorMaxCount(String piLoginErrorMaxCoun) {
		this.loginErrorMaxCount = piLoginErrorMaxCoun;
	}

	/**
	 * 仮パスワード有効期間を取得.
	 * 
	 * @return 仮パスワード有効期間
	 */
	public String getTempPassValidityTerm() {
		return this.tempPassValidityTerm;
	}

	/**
	 * 仮パスワード有効期間を設定.
	 * 
	 * @param piTempPassValidityTerm
	 *            仮パスワード有効期間
	 */
	public void setTempPassValidityTerm(String piTempPassValidityTerm) {
		this.tempPassValidityTerm = piTempPassValidityTerm;
	}

	/**
	 * 本パスワード有効期間を取得.
	 * 
	 * @return 本パスワード有効期間
	 */
	public String getPassValidityTerm() {
		return this.passValidityTerm;
	}

	/**
	 * 本パスワード有効期間を設定.
	 * 
	 * @param piPassValidityTerm
	 *            本パスワード有効期間
	 */
	public void setPassValidityTerm(String piPassValidityTerm) {
		this.passValidityTerm = piPassValidityTerm;
	}

	/**
	 * パスワード文字の下限を取得.
	 * 
	 * @return パスワード文字の下限
	 */
	public String getPasswordLengthMin() {
		return this.passwordLengthMin;
	}

	/**
	 * パスワード文字の下限を設定.
	 * 
	 * @param piPasswordLengthMin
	 *            パスワード文字の下限
	 */
	public void setPasswordLengthMin(String piPasswordLengthMin) {
		this.passwordLengthMin = piPasswordLengthMin;
	}

	/**
	 * パスワード文字の上限を取得.
	 * 
	 * @return パスワード文字の上限
	 */
	public String getPasswordLengthMax() {
		return this.passwordLengthMax;
	}

	/**
	 * パスワード文字の上限を設定.
	 * 
	 * @param piPasswordLengthMax
	 *            パスワード文字の上限
	 */
	public void setPasswordLengthMax(String piPasswordLengthMax) {
		this.passwordLengthMax = piPasswordLengthMax;
	}

	/**
	 * エラー時の処理メニューの制御を取得.
	 * 
	 * @return エラー時の処理メニューの制御
	 */
	public String getErrorLockType() {
		return this.errorLockType;
	}

	/**
	 * エラー時の処理メニューの制御を設定.
	 * 
	 * @param piErrorLockType
	 *            エラー時の処理メニューの制御
	 */
	public void setErrorLockType(String piErrorLockType) {
		this.errorLockType = piErrorLockType;
	}

	/**
	 * リース会社ロゴファイル名を取得.
	 * 
	 * @return リース会社ロゴファイル名
	 */
	public String getLogoFileName() {
		return this.logoFileName;
	}

	/**
	 * リース会社ロゴファイル名を設定.
	 * 
	 * @param piLogoFileName
	 *            リース会社ロゴファイル名
	 */
	public void setLogoFileName(String piLogoFileName) {
		this.logoFileName = piLogoFileName;
	}

	/**
	 * SSL証明書のマークを取得.
	 * 
	 * @return SSL証明書のマーク
	 */
	public String getCertificateMarkURL() {
		return this.certificateMarkURL;
	}

	/**
	 * SSL証明書のマークを設定.
	 * 
	 * @param piCertificateMarkURL
	 *            SSL証明書のマーク
	 */
	public void setCertificateMarkURL(String piCertificateMarkURL) {
		this.certificateMarkURL = piCertificateMarkURL;
	}

	/**
	 * お問合せを取得.
	 * 
	 * @return お問合せ
	 */
	public String getFreeWord() {
		return this.freeWord;
	}

	/**
	 * お問合せを設定.
	 * 
	 * @param piFreeWord
	 *            お問合せ
	 */
	public void setFreeWord(String piFreeWord) {
		this.freeWord = piFreeWord;
	}

	/**
	 * 注記書類作成基準書文言１を取得.
	 * 
	 * @return 注記書類作成基準書文言１
	 */
	public String getTyukiComment1() {
		return this.tyukiComment1;
	}

	/**
	 * 注記書類作成基準書文言１を設定.
	 * 
	 * @param piTyukiComment1
	 *            注記書類作成基準書文言１
	 */
	public void setTyukiComment1(String piTyukiComment1) {
		this.tyukiComment1 = piTyukiComment1;
	}

	/**
	 * 注記書類作成基準書文言２を取得.
	 * 
	 * @return 注記書類作成基準書文言２
	 */
	public String getTyukiComment2() {
		return this.tyukiComment2;
	}

	/**
	 * 注記書類作成基準書文言２を設定.
	 * 
	 * @param piTyukiComment2
	 *            注記書類作成基準書文言２
	 */
	public void setTyukiComment2(String piTyukiComment2) {
		this.tyukiComment2 = piTyukiComment2;
	}

	/**
	 * 表示制御を取得.
	 * 
	 * @return 表示制御
	 */
	public LACSDispControlBean getDispControl() {
		return this.dispControl;
	}
}
