package jp.co.pro_app.lacs.affairs.infolist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.infolist.bean.LACSInfoListBean;

/**
 * お知らせ一覧：ページ制御Model.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSInfoListPageModel extends LACSInfoListSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piInfoListBean
	 *            お知らせ一覧Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSInfoListBean piInfoListBean) throws SQLException {
		piInfoListBean.setCurrent(super.getParam("nextPage", 0));
	}

}
