package jp.co.pro_app.lacs.affairs.companylist.model;

import jp.co.pro_app.lacs.affairs.companylist.bean.LACSCompanyListBean;

/**
 * リース会社マスタ：ページ制御Model.
 * 
 * @author katoken
 * @version 20071218
 */
public class LACSCompanyListPageModel extends LACSCompanyListSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piCompanyListBean
	 *            リース会社マスタ一覧Bean
	 */
	protected void initSub(LACSCompanyListBean piCompanyListBean) {
		piCompanyListBean.setCurrent(super.getParam("nextPage", 0));
	}

}
