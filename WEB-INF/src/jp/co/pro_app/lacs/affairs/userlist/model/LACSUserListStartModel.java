package jp.co.pro_app.lacs.affairs.userlist.model;

import jp.co.pro_app.lacs.affairs.userlist.bean.LACSUserListBean;

/**
 * リースユーザーマスタ一覧：初期表示Model.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSUserListStartModel extends LACSUserListModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "表示";
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piUserListBean
	 *            リースユーザーマスタ一覧Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSUserListBean piUserListBean) throws Exception {
		piUserListBean.init(super.getCommonBean());

		super.prepareComoboBox(piUserListBean);

	}

}
