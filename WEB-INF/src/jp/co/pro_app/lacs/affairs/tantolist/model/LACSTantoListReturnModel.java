package jp.co.pro_app.lacs.affairs.tantolist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.tantolist.bean.LACSTantoListBean;

/**
 * リースユーザー担当者マスタ一覧：検索処理Model.
 * 
 * @author active
 * @version 20071210
 */
public class LACSTantoListReturnModel extends LACSTantoListSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piTantoListBean
	 *            リースユーザー担当者マスタ一覧Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSTantoListBean piTantoListBean) throws SQLException {
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}
}
