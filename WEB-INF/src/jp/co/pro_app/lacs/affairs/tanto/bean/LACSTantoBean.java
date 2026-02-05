package jp.co.pro_app.lacs.affairs.tanto.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSMaintenanceBeanBase;
import jp.co.pro_app.projframe.common.html.ComboArray;

/**
 * リースユーザー担当者マスタBean.
 * 
 * @author ohmura
 * @version 20070913
 */
public class LACSTantoBean extends LACSMaintenanceBeanBase {

	private static final long serialVersionUID = 1L;

	private String					userID				= "";	// ユーザーID

	private String					cosmosCode			= "";	// COSMOSコード

	private String					password			= "";	// パスワード

	private String					userTantoName		= "";	// ユーザー担当者名

	private String					condUserID			= "";	// ユーザーID(条件)

	private String					condCosmosCode		= "";	// COSMOSコード(条件)

	private String					condUserRight		= "";	// 利用者権限(条件)

	private String					passwordYukoTerm	= "";	// パスワード有効期限

	private String					tantJtiKbn			= "";	// 担当者状態区分

	private String					tantJtiKbnName		= "";	// 担当者状態区分名

	private String					kriPassFlg			= "";	// 仮発行フラグ

	private String					kriPasswordTerm		= "";	// 仮パスワード有効期限

	private String					honPasswordTerm		= "";	// 本パスワード有効期限

	private String					password2			= "";	// 確認用パスワード

	private String					minLength			= "";	// パスワード文字の下限

	private String					maxLength			= "";	// パスワード文字の上限

	private String					userRight			= "";	// 利用者権限区分

	private LACSTantoUserManageBean	userList			= null; // 開示先リスト

	private int						pageNo				= 0;	// 現ページ保持

	/**
	 * コンストラクタ.
	 */
	public LACSTantoBean() {
	}

	/**
	 * 初期化.
	 */
	public void init() {
		this.userID = "";

		super.init();
	}

	/**
	 * ユーザーIDを取得.
	 * 
	 * @return ユーザーID
	 */
	public String getUserID() {
		return this.userID;
	}

	/**
	 * ユーザーIDを設定.
	 * 
	 * @param piUserID
	 *            ユーザーID
	 */
	public void setUserID(String piUserID) {
		this.userID = piUserID;
	}

	/**
	 * COSMOSコードを取得.
	 * 
	 * @return COSMOSコード
	 */
	public String getCosmosCode() {
		return this.cosmosCode;
	}

	/**
	 * COSMOSコードを設定.
	 * 
	 * @param piCosmosCode
	 *            COSMOSコード
	 */
	public void setCosmosCode(String piCosmosCode) {
		this.cosmosCode = piCosmosCode;
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
	 * ユーザー担当者名を取得.
	 * 
	 * @return ユーザー担当者名
	 */
	public String getUserTantoName() {
		return this.userTantoName;
	}

	/**
	 * ユーザー担当者名を設定.
	 * 
	 * @param piUserTantoName
	 *            ユーザー担当者名
	 */
	public void setUserTantoName(String piUserTantoName) {
		this.userTantoName = piUserTantoName;
	}

	/**
	 * ユーザーID(条件)を取得.
	 * 
	 * @return ユーザーID(条件)
	 */
	public String getCondUserID() {
		return this.condUserID;
	}

	/**
	 * ユーザーID(条件)を設定.
	 * 
	 * @param piCondUserID
	 *            ユーザーID(条件)
	 */
	public void setCondUserID(String piCondUserID) {
		this.condUserID = piCondUserID;
	}

	/**
	 * COSMOSコード(条件)を取得.
	 * 
	 * @return COSMOSコード(条件)
	 */
	public String getCondCosmosCode() {
		return this.condCosmosCode;
	}

	/**
	 * COSMOSコード(条件)を設定.
	 * 
	 * @param piCondCosmosCode
	 *            COSMOSコード(条件)
	 */
	public void setCondCosmosCode(String piCondCosmosCode) {
		this.condCosmosCode = piCondCosmosCode;
	}

	/**
	 * 利用者権限(条件)を取得.
	 * 
	 * @return 利用者権限(条件)
	 */
	public String getCondUserRight() {
		return this.condUserRight;
	}

	/**
	 * 利用者権限(条件)を設定.
	 * 
	 * @param piCondUserRight
	 *            利用者権限(条件)
	 */
	public void setCondUserRight(String piCondUserRight) {
		this.condUserRight = piCondUserRight;
	}

	/**
	 * パスワード有効期限を取得.
	 * 
	 * @return パスワード有効期限
	 */
	public String getPasswordYukoTerm() {
		return this.passwordYukoTerm;
	}

	/**
	 * パスワード有効期限を設定.
	 * 
	 * @param piPasswordYukoTerm
	 *            パスワード有効期限
	 */
	public void setPasswordYukoTerm(String piPasswordYukoTerm) {
		this.passwordYukoTerm = piPasswordYukoTerm;
	}

	/**
	 * 担当者状態区分を取得.
	 * 
	 * @return 担当者状態区分
	 */
	public String getTantJtiKbn() {
		return this.tantJtiKbn;
	}

	/**
	 * 担当者状態区分を設定.
	 * 
	 * @param piTantJtiKbn
	 *            担当者状態区分
	 */
	public void setTantJtiKbn(String piTantJtiKbn) {
		this.tantJtiKbn = piTantJtiKbn;
	}

	/**
	 * 担当者状態区分名を取得.
	 * 
	 * @return 担当者状態区分名
	 */
	public String getTantJtiKbnName() {
		return this.tantJtiKbnName;
	}

	/**
	 * 担当者状態区分名を設定.
	 * 
	 * @param piTantJtiKbnName
	 *            担当者状態区分名
	 */
	public void setTantJtiKbnName(String piTantJtiKbnName) {
		this.tantJtiKbnName = piTantJtiKbnName;
	}

	/**
	 * 仮発行フラグを取得.
	 * 
	 * @return 仮発行フラグ
	 */
	public String getKriPassFlg() {
		return this.kriPassFlg;
	}

	/**
	 * 仮発行フラグを設定.
	 * 
	 * @param piKriPassFlg
	 *            仮発行フラグ
	 */
	public void setKriPassFlg(String piKriPassFlg) {
		this.kriPassFlg = piKriPassFlg;
	}

	/**
	 * 仮パスワード有効期限を取得.
	 * 
	 * @return 仮パスワード有効期限
	 */
	public String getKriPasswordTerm() {
		return this.kriPasswordTerm;
	}

	/**
	 * 仮パスワード有効期限を設定.
	 * 
	 * @param piKriPasswordTerm
	 *            仮パスワード有効期限
	 */
	public void setKriPasswordTerm(String piKriPasswordTerm) {
		this.kriPasswordTerm = piKriPasswordTerm;
	}

	/**
	 * 本パスワード有効期限を取得.
	 * 
	 * @return 本パスワード有効期限
	 */
	public String getHonPasswordTerm() {
		return this.honPasswordTerm;
	}

	/**
	 * 本パスワード有効期限を設定.
	 * 
	 * @param piHonPasswordTerm
	 *            本パスワード有効期限
	 */
	public void setHonPasswordTerm(String piHonPasswordTerm) {
		this.honPasswordTerm = piHonPasswordTerm;
	}

	/**
	 * 確認用パスワードを取得.
	 * 
	 * @return 確認用パスワード
	 */
	public String getPassword2() {
		return this.password2;
	}

	/**
	 * 確認用パスワードを設定.
	 * 
	 * @param piPassword2
	 *            確認用パスワード
	 */
	public void setPassword2(String piPassword2) {
		this.password2 = piPassword2;
	}

	/**
	 * パスワード文字の下限を取得.
	 * 
	 * @return パスワード文字の下限
	 */
	public String getMinLength() {
		return this.minLength;
	}

	/**
	 * パスワード文字の下限を設定.
	 * 
	 * @param piMinLength
	 *            パスワード文字の下限
	 */
	public void setMinLength(String piMinLength) {
		this.minLength = piMinLength;
	}

	/**
	 * パスワード文字の上限を取得.
	 * 
	 * @return パスワード文字の上限
	 */
	public String getMaxLength() {
		return this.maxLength;
	}

	/**
	 * パスワード文字の上限を設定.
	 * 
	 * @param piMaxLength
	 *            パスワード文字の上限
	 */
	public void setMaxLength(String piMaxLength) {
		this.maxLength = piMaxLength;
	}

	/**
	 * 利用者権限区分を取得.
	 * 
	 * @return 利用者権限区分
	 */
	public String getUserRight() {
		return this.userRight;
	}

	/**
	 * 利用者権限区分を設定.
	 * 
	 * @param piUserRight
	 *            利用者権限区分
	 */
	public void setUserRight(String piUserRight) {
		this.userRight = piUserRight;
	}

	/**
	 * 開示先リストを取得.
	 * 
	 * @param piDefaultCombo
	 *            デフォルト開示先.
	 * @return 開示先リスト
	 */
	public LACSTantoUserManageBean getUserList(ComboArray piDefaultCombo) {
		if (this.userList == null) {
			this.userList = new LACSTantoUserManageBean(piDefaultCombo);
		}

		return this.userList;
	}

	/**
	 * 開示先リストを初期化.
	 */
	public void clearUserList() {
		this.userList = null;
	}

	/**
	 * 開示先リストを取得.
	 * 
	 * @return 開示先リスト
	 */
	public LACSTantoUserManageBean getUserList() {
		return this.userList;
	}

	/**
	 * 現ページ保持を取得.
	 * 
	 * @return 現ページ保持
	 */
	public int getPageNo() {
		return this.pageNo;
	}

	/**
	 * 現ページ保持を設定.
	 * 
	 * @param piPageNo
	 *            現ページ保持
	 */
	public void setPageNo(int piPageNo) {
		this.pageNo = piPageNo;
	}
}
