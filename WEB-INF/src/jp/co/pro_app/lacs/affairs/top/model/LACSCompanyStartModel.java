package jp.co.pro_app.lacs.affairs.top.model;

import jp.co.pro_app.lacs.common.model.LACSConstDBModelBase;

/**
 * リース会社トップModel.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSCompanyStartModel extends LACSConstDBModelBase {

	/**
	 * 業務個別処理.
	 * 
	 * @throws Exception
	 *             例外発生時.
	 */
	public void performSub() throws Exception {
		super.setForwardPath("/notfound.html");
	}

	/**
	 * セッションチェックフラグ取得.
	 * 
	 * @return セッションチェックを行うか
	 */
	protected boolean isSessionCheck() {
		return false;
	}

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "";
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "";
	}
}
