package jp.co.pro_app.lacs.affairs.infolist.model;

import jp.co.pro_app.lacs.affairs.infolist.bean.LACSInfoListBean;

/**
 * 契約検索支払推移表遷移クラス.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSInfoListEditModel extends LACSInfoListModelBase {

	/**
	 * 業務個別処理.
	 * 
	 * @param piInfoListBean
	 *            リースユーザーマスタ一覧Bean
	 */
	protected void businessProc(LACSInfoListBean piInfoListBean) {
		super.setForwardPath("/search.info");
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
