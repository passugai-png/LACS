package jp.co.pro_app.lacs.affairs.companyuserlist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.companyuserlist.bean.LACSCompanyUserListBean;

/**
 * リース会社別リースユーザーマスタ一覧：ページ制御Model.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSCompanyUserListPageModel extends LACSCompanyUserListSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piCompanyUserListBean
	 *            リース会社別リースユーザーマスタ一覧Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSCompanyUserListBean piCompanyUserListBean) throws SQLException {
		piCompanyUserListBean.setCurrent(super.getParam("nextPage", 0));
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "ページ遷移";
	}
}
