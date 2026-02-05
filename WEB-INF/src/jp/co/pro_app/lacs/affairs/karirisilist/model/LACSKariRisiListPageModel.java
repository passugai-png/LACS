package jp.co.pro_app.lacs.affairs.karirisilist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.karirisilist.bean.LACSKariRisiListBean;

/**
 * リースユーザー別借入利子率マスタ一覧：ページ制御Model.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSKariRisiListPageModel extends LACSKariRisiListSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piKariRisiListBean
	 *            リースユーザー別借入利子率マスタ一覧Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSKariRisiListBean piKariRisiListBean) throws SQLException {
		piKariRisiListBean.setCurrent(super.getParam("nextPage", 0));
	}

}
