package jp.co.pro_app.lacs.affairs.userlist.model;

import jp.co.pro_app.lacs.affairs.userlist.bean.LACSUserListBean;

/**
 * リースユーザーマスタ一覧：ページ制御Model.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSUserListPageModel extends LACSUserListSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piUserListBean
	 *            リースユーザーマスタ一覧Bean
	 */
	protected void initSub(LACSUserListBean piUserListBean) {
		piUserListBean.setCurrent(super.getParam("nextPage", 0));
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
