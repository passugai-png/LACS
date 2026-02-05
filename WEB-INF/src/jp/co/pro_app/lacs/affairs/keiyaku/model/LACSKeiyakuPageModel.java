package jp.co.pro_app.lacs.affairs.keiyaku.model;

import jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuBean;

/**
 * 契約検索：ページ制御処理Model.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSKeiyakuPageModel extends LACSKeiyakuSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piBukkenBean
	 *            契約検索Bean
	 */
	protected void initSub(LACSKeiyakuBean piBukkenBean) {
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
