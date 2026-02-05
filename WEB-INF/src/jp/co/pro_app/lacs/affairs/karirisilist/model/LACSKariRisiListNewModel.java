package jp.co.pro_app.lacs.affairs.karirisilist.model;

import jp.co.pro_app.lacs.affairs.karirisilist.bean.LACSKariRisiListBean;

/**
 * 契約検索支払推移表遷移クラス.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSKariRisiListNewModel extends LACSKariRisiListModelBase {

	/**
	 * 業務個別処理.
	 * 
	 * @param piUserListBean
	 *            リースユーザーマスタ一覧Bean
	 */
	protected void businessProc(LACSKariRisiListBean piUserListBean) {
		super.setForwardPath("/search.karirisi");
	}

	/**
	 * 処理名を取得 .
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "新規";
	}

}
