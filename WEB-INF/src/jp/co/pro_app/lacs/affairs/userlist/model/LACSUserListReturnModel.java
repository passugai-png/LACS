package jp.co.pro_app.lacs.affairs.userlist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.userlist.bean.LACSUserListBean;

/**
 * リースユーザーマスタ一覧：検索処理Model.
 * 
 * @author active
 * @version 20071210
 */
public class LACSUserListReturnModel extends LACSUserListSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piUserListBean
	 *            リースユーザーマスタ一覧Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSUserListBean piUserListBean) throws SQLException {
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}
}
