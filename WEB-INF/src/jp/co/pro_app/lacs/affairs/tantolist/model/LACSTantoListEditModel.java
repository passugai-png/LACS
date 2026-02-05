package jp.co.pro_app.lacs.affairs.tantolist.model;

import jp.co.pro_app.lacs.affairs.tantolist.bean.LACSTantoListBean;

/**
 * 契約検索支払推移表遷移クラス.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSTantoListEditModel extends LACSTantoListModelBase {

	/**
	 * 業務個別処理.
	 * 
	 * @param piUserListBean
	 *            リースユーザーマスタ一覧Bean
	 */
	protected void businessProc(LACSTantoListBean piUserListBean) {
		super.setForwardPath("/search.tanto");
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
