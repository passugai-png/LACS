package jp.co.pro_app.lacs.affairs.syousai.model;

import jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiBean;

/**
 * 契約詳細：ページ制御処理Model.
 * 
 * @author yokota
 * @version 20081017
 */
public class LACSSyousaiPageModel extends LACSSyousaiSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piSyousaiBean
	 *            契約詳細Bean
	 */
	protected void initSub(LACSSyousaiBean piSyousaiBean) {
		piSyousaiBean.setCurrent(super.getParam("nextPage", 0));

		piSyousaiBean.clearList();
	}
}
