package jp.co.pro_app.lacs.affairs.userlist.model;

import jp.co.pro_app.lacs.affairs.user.bean.LACSUserBean;
import jp.co.pro_app.lacs.affairs.userlist.bean.LACSUserListBean;

/**
 * リースユーザーマスタ一覧：戻るModel.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSUserListBackModel extends LACSUserListModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {

		LACSUserBean userBean = new LACSUserBean();
		LACSUserListBean userListBean = new LACSUserListBean();

		userBean.setPageNo(1);
		userListBean.setCurrentW(1);

		return "戻る";
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}

}
