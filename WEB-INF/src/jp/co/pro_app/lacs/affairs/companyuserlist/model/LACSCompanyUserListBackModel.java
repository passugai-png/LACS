package jp.co.pro_app.lacs.affairs.companyuserlist.model;

import jp.co.pro_app.lacs.affairs.companyuser.bean.LACSCompanyUserBean;
import jp.co.pro_app.lacs.affairs.companyuserlist.bean.LACSCompanyUserListBean;

/**
 * リース会社別リースユーザーマスタ一覧：戻るModel.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSCompanyUserListBackModel extends LACSCompanyUserListModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {

		LACSCompanyUserListBean companyUserListBean = new LACSCompanyUserListBean();
		LACSCompanyUserBean companyUserBean = new LACSCompanyUserBean();

		companyUserListBean.setCurrentW(1);
		companyUserBean.setPageNo(1);

		return "戻る";
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}

}
