package jp.co.pro_app.lacs.affairs.companyuserlist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.companyuserlist.bean.LACSCompanyUserListBean;

/**
 * リース会社別リースユーザーマスタ一覧：検索処理Model.
 * 
 * @author active
 * @version 20071210
 */
public class LACSCompanyUserListReturnModel extends LACSCompanyUserListSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piCompanyUserListBean
	 *            リース会社別リースユーザーマスタ一覧Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSCompanyUserListBean piCompanyUserListBean) throws SQLException {
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}

}
