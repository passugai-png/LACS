package jp.co.pro_app.lacs.affairs.login.model;

import jp.co.pro_app.lacs.affairs.login.bean.LACSLoginBean;

/**
 * ログイン：リセット処理.
 * 
 * @author katoken
 * @version 20090210
 */
public class LACSLoginResetModel extends LACSLoginStartModel {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "リセット";
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 * @exception Exception
	 *                実行例外
	 */
	protected void initSub(LACSLoginBean piShiharaiBean) throws Exception {
		piShiharaiBean.setUserId("");
		piShiharaiBean.setPassword("");
	}

}
