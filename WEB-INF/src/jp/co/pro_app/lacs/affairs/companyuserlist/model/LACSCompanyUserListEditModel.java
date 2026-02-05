package jp.co.pro_app.lacs.affairs.companyuserlist.model;

import jp.co.pro_app.lacs.affairs.companyuserlist.bean.LACSCompanyUserListBean;

/**
 * 契約検索支払推移表遷移クラス.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSCompanyUserListEditModel extends LACSCompanyUserListModelBase {

	/**
	 * 業務個別処理.
	 * 
	 * @param piCompanyUserListBean
	 *            リース会社別リースユーザーマスタ一覧Bean
	 */
	protected void businessProc(LACSCompanyUserListBean piCompanyUserListBean) {
		super.setForwardPath("/search.companyuser");
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
