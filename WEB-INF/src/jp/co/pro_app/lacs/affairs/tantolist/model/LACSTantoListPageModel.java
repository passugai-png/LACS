package jp.co.pro_app.lacs.affairs.tantolist.model;

import jp.co.pro_app.lacs.affairs.tantolist.bean.LACSTantoListBean;

/**
 * リースユーザー担当者マスタ一覧：ページ制御Model.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSTantoListPageModel extends LACSTantoListSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piTantoListBean
	 *            リースユーザー担当者マスタ一覧Bean
	 */
	protected void initSub(LACSTantoListBean piTantoListBean) {
		piTantoListBean.setCurrent(super.getParam("nextPage", 0));
	}

}
