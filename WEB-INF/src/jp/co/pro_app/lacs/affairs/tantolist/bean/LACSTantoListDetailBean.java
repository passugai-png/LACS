package jp.co.pro_app.lacs.affairs.tantolist.bean;

import java.util.ArrayList;

import jp.co.pro_app.lacs.affairs.common.bean.LACSMaintenanceBeanBase;

/**
 * リースユーザー担当者一覧明細マスタBean.
 * 
 * @author ohmura
 * @version 20070913
 */
public class LACSTantoListDetailBean extends LACSMaintenanceBeanBase {

	private static final long serialVersionUID = 1L;

	private String		userID				= "";				// ユーザーID

	private String		userTantoName		= "";				// ユーザー担当者名

	private ArrayList<Object>	userName			= new ArrayList<Object>();	// ユーザー名

	private String		passwordYukoTerm	= "";				// パスワード有効期限

	private String		tantJtiKbn			= "";				// 担当者状態区分

	private String		tantJtiKbnName		= "";				// 担当者状態区分名称

	private String		userRight			= "";				// 利用者権限区分

	private String		userRightName		= "";				// 利用者権限区分名称

	/**
	 * コンストラクタ.
	 */
	public LACSTantoListDetailBean() {
	}

	/**
	 * 初期化.
	 */
	public void init() {
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
	 * ユーザー名を取得.
	 * 
	 * @return ユーザー名
	 */
	public ArrayList<Object> getUserName() {
		return this.userName;
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
	 * 担当者状態区分名称を取得.
	 * 
	 * @return 担当者状態区分名称
	 */
	public String getTantJtiKbnName() {
		return this.tantJtiKbnName;
	}

	/**
	 * 担当者状態区分名称を設定.
	 * 
	 * @param piTantJtiKbnName
	 *            担当者状態区分名称
	 */
	public void setTantJtiKbnName(String piTantJtiKbnName) {
		this.tantJtiKbnName = piTantJtiKbnName;
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
	 * 利用者権限区分名称を取得.
	 * 
	 * @return 利用者権限区分名称
	 */
	public String getUserRightName() {
		return this.userRightName;
	}

	/**
	 * 利用者権限区分名称を設定.
	 * 
	 * @param piUserRightName
	 *            利用者権限区分名称
	 */
	public void setUserRightName(String piUserRightName) {
		this.userRightName = piUserRightName;
	}

}
