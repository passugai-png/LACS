package jp.co.pro_app.lacs.affairs.bukken.model;

import jp.co.pro_app.lacs.affairs.bukken.bean.LACSBukkenBean;

/**
 * 物件検索：ページ制御Model.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSBukkenPageModel extends LACSBukkenSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piBukkenBean
	 *            物件検索Bean
	 */
	protected void initSub(LACSBukkenBean piBukkenBean) {
		piBukkenBean.setCurrent(super.getParam("nextPage", 0));
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
