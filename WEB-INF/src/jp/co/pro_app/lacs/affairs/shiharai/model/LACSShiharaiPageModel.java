package jp.co.pro_app.lacs.affairs.shiharai.model;

import jp.co.pro_app.lacs.affairs.shiharai.bean.LACSShiharaiBean;

/**
 * 支払推移表：ページ制御処理Model.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiharaiPageModel extends LACSShiharaiSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 */
	protected void initSub(LACSShiharaiBean piShiharaiBean) {
		piShiharaiBean.setCurrent(super.getParam("nextPage", 0));
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "ページ遷移";
	}

}
