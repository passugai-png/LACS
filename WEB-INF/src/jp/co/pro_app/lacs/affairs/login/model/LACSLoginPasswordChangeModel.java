package jp.co.pro_app.lacs.affairs.login.model;

import jp.co.pro_app.lacs.affairs.login.bean.LACSLoginBean;

/**
 * 契約検索支払推移表遷移クラス.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSLoginPasswordChangeModel extends LACSLoginModelBase {

	/**
	 * 業務個別処理.
	 * 
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 */
	protected void businessProc(LACSLoginBean piShiharaiBean) {
		super.setForwardPath("/start.password");
	}

	/**
	 * 処理名を取得 .
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "パスワード変更";
	}

	/**
	 * セッションチェックフラグ取得.
	 * 
	 * @return セッションチェックを行うか
	 */
	protected boolean isSessionCheck() {
		return false;
	}
}
