package jp.co.pro_app.lacs.affairs.infolist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.infolist.bean.LACSInfoListBean;

/**
 * お知らせ一覧：検索処理Model.
 * 
 * @author active
 * @version 20071210
 */
public class LACSInfoListReturnModel extends LACSInfoListSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piInfoListBean
	 *            お知らせ一覧Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSInfoListBean piInfoListBean) throws SQLException {
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}
}
