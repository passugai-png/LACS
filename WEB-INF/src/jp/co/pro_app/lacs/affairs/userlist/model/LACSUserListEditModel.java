package jp.co.pro_app.lacs.affairs.userlist.model;

import jp.co.pro_app.lacs.affairs.userlist.bean.LACSUserListBean;

/**
 * 契約検索支払推移表遷移クラス.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSUserListEditModel extends LACSUserListModelBase {

	/**
	 * 業務個別処理.
	 * 
	 * @param piUserListBean
	 *            リースユーザーマスタ一覧Bean
	 */
	protected void businessProc(LACSUserListBean piUserListBean) {
		super.setForwardPath("/search.user");
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "修正";
	}

}
