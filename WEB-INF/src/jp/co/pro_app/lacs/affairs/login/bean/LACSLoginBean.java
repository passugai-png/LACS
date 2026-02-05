package jp.co.pro_app.lacs.affairs.login.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSBeanBase;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;

/**
 * LACS用ログインBean.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSLoginBean extends LACSBeanBase {

	private static final long serialVersionUID = 1L;

	private String	userId			= "";	// ユーザーID

	private String	password		= "";	// パスワード

	private String	logo			= "";	// リース会社ロゴ

	private String	securityInfo	= "";	// SSL証明書のマーク

	private String	loginInfo		= "";	// お問合せ

	private String	trhkskCode		= "";	// 取引先コード

	// private String oneTimePassword = ""; // ワンタイムパスワード

	/**
	 * 初期化.
	 * 
	 * @param piCommonBean
	 *            LACS共通Bean
	 */
	public void init(LACSCommonBean piCommonBean) {
		super.init();
	}

	/**
	 * ユーザーIDを取得.
	 * 
	 * @return ユーザーID
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * ユーザーIDを設定.
	 * 
	 * @param piUserId
	 *            ユーザーID
	 */
	public void setUserId(String piUserId) {
		this.userId = piUserId;
	}

	/**
	 * パスワードを取得.
	 * 
	 * @return パスワード
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * パスワードを設定.
	 * 
	 * @param piPassword
	 *            パスワード
	 */
	public void setPassword(String piPassword) {
		this.password = piPassword;
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
	 * SSL証明書のマークを取得.
	 * 
	 * @return SSL証明書のマーク
	 */
	public String getSecurityInfo() {
		return this.securityInfo;
	}

	/**
	 * SSL証明書のマークを設定.
	 * 
	 * @param piSecurityInfo
	 *            SSL証明書のマーク
	 */
	public void setSecurityInfo(String piSecurityInfo) {
		this.securityInfo = piSecurityInfo;
	}

	/**
	 * お問合せを取得.
	 * 
	 * @return お問合せ
	 */
	public String getLoginInfo() {
		return this.loginInfo;
	}

	/**
	 * お問合せを設定.
	 * 
	 * @param piLoginInfo
	 *            お問合せ
	 */
	public void setLoginInfo(String piLoginInfo) {
		this.loginInfo = piLoginInfo;
	}

	/**
	 * 取引先コードを取得.
	 * 
	 * @return 取引先コード
	 */
	public String getTrhkskCode() {
		return this.trhkskCode;
	}

	/**
	 * 取引先コードを設定.
	 * 
	 * @param piTrhkskCode
	 *            取引先コード
	 */
	public void setTrhkskCode(String piTrhkskCode) {
		this.trhkskCode = piTrhkskCode;
	}
	//
	// /**
	// * ワンタイムパスワードを取得.
	// *
	// * @return ワンタイムパスワード
	// */
	// public String getOneTimePassword() {
	// return this.oneTimePassword;
	// }
	//
	// /**
	// * ワンタイムパスワードを設定.
	// *
	// * @param piOneTimePassword
	// * ワンタイムパスワード
	// */
	// public void setOneTimePassword(String piOneTimePassword) {
	// this.oneTimePassword = piOneTimePassword;
	// }
}
