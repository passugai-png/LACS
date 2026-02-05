package jp.co.pro_app.lacs.affairs.companyuser.model;

import jp.co.pro_app.lacs.affairs.companyuser.bean.LACSCompanyUserBean;

/**
 * 契約検索支払推移表遷移クラス.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSCompanyUserBackModel extends LACSCompanyUserModelBase {

	/**
	 * 業務個別処理.
	 * 
	 * @param piCompanyUserBean
	 *            リース会社別リースユーザーマスタBean
	 */
	protected void businessProc(LACSCompanyUserBean piCompanyUserBean) {
		super.setForwardPath("/back.companyuserlist");
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piCompanyUserBean
	 *            リース会社別リースユーザーマスタBean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSCompanyUserBean piCompanyUserBean) throws Exception {
	}

	/**
	 * 処理名を取得 .
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "戻る";
	}

}
