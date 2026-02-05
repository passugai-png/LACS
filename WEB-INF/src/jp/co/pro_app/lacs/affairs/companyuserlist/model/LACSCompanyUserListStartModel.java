package jp.co.pro_app.lacs.affairs.companyuserlist.model;

import jp.co.pro_app.lacs.affairs.companyuserlist.bean.LACSCompanyUserListBean;

/**
 * リース会社別リースユーザーマスタ一覧：初期表示Model.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSCompanyUserListStartModel extends LACSCompanyUserListModelBase {

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
	 * @param piCompanyUserListBean
	 *            リース会社別リースユーザーマスタ一覧Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSCompanyUserListBean piCompanyUserListBean) throws Exception {
		piCompanyUserListBean.init(super.getCommonBean());

		super.prepareComoboBox(piCompanyUserListBean);

	}

}
