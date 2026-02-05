package jp.co.pro_app.lacs.affairs.shiwake.model;

import jp.co.pro_app.lacs.affairs.shiwake.bean.LACSShiwakeBean;

/**
 * 仕訳照会：ページ制御処理Model.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiwakePageModel extends LACSShiwakeSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piShiwakeBean
	 *            仕訳照会Bean
	 */
	protected void initSub(LACSShiwakeBean piShiwakeBean) {
		piShiwakeBean.setCurrent(super.getParam("nextPage", 0));
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
