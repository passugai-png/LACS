package jp.co.pro_app.lacs.affairs.password.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSBeanBase;

/**
 * パスワード変更Bean.
 * 
 * @author katoken
 * @version 20080918
 */
public class LACSPasswordBean extends LACSBeanBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String	userId			= "";	// ユーザID

	private String	oldPassword		= "";	// 旧パスワード

	private String	newPassword1	= "";	// 新パスワード１

	private String	newPassword2	= "";	// 新パスワード２

	private int		minLength		= 0;	// パスワード文字下限桁数

	private int		maxLength		= 0;	// パスワード文字上限桁数

	private int		availableDays	= 0;	// パスワード有効期間

	/**
	 * ユーザIDを取得.
	 * 
	 * @return ユーザID
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * ユーザIDを設定.
	 * 
	 * @param piUserId
	 *            ユーザID
	 */
	public void setUserId(String piUserId) {
		this.userId = piUserId;
	}

	/**
	 * 旧パスワードを取得.
	 * 
	 * @return 旧パスワード
	 */
	public String getOldPassword() {
		return this.oldPassword;
	}

	/**
	 * 旧パスワードを設定.
	 * 
	 * @param piOldPassword
	 *            旧パスワード
	 */
	public void setOldPassword(String piOldPassword) {
		this.oldPassword = piOldPassword;
	}

	/**
	 * 新パスワード１を取得.
	 * 
	 * @return 新パスワード１
	 */
	public String getNewPassword1() {
		return this.newPassword1;
	}

	/**
	 * 新パスワード１を設定.
	 * 
	 * @param piNewPassword1
	 *            新パスワード１
	 */
	public void setNewPassword1(String piNewPassword1) {
		this.newPassword1 = piNewPassword1;
	}

	/**
	 * 新パスワード２を取得.
	 * 
	 * @return 新パスワード２
	 */
	public String getNewPassword2() {
		return this.newPassword2;
	}

	/**
	 * 新パスワード２を設定.
	 * 
	 * @param piNewPassword2
	 *            新パスワード２
	 */
	public void setNewPassword2(String piNewPassword2) {
		this.newPassword2 = piNewPassword2;
	}

	/**
	 * パスワード文字下限桁数を取得.
	 * 
	 * @return パスワード文字下限桁数
	 */
	public int getMinLength() {
		return this.minLength;
	}

	/**
	 * パスワード文字下限桁数を設定.
	 * 
	 * @param piMinLength
	 *            パスワード文字下限桁数
	 */
	public void setMinLength(int piMinLength) {
		this.minLength = piMinLength;
	}

	/**
	 * パスワード文字上限桁数を取得.
	 * 
	 * @return パスワード文字上限桁数
	 */
	public int getMaxLength() {
		return this.maxLength;
	}

	/**
	 * パスワード文字上限桁数を設定.
	 * 
	 * @param piMaxLength
	 *            パスワード文字上限桁数
	 */
	public void setMaxLength(int piMaxLength) {
		this.maxLength = piMaxLength;
	}

	/**
	 * パスワード有効期間を取得.
	 * 
	 * @return パスワード有効期間
	 */
	public int getAvailableDays() {
		return this.availableDays;
	}

	/**
	 * パスワード有効期間を設定.
	 * 
	 * @param piAvailableDays
	 *            パスワード有効期間
	 */
	public void setAvailableDays(int piAvailableDays) {
		this.availableDays = piAvailableDays;
	}

}
