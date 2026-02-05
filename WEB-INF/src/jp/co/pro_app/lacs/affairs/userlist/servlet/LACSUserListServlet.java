package jp.co.pro_app.lacs.affairs.userlist.servlet;

import jp.co.pro_app.projframe.common.servlet.ServletBase;

/**
 * リースユーザーマスタ一覧Servlet.
 * 
 * @author active
 * @version 20071210
 */
public class LACSUserListServlet extends ServletBase {

	private static final long serialVersionUID = 1L;

	/**
	 * Mapファイル名を取得.
	 * 
	 * @return Mapファイル名
	 */
	protected String getMapName() {
		return "LACS.map";
	}

	/**
	 * プロパティファイル名を取得.
	 * 
	 * @return プロパティファイル名1
	 */
	public String getPropertyName() {
		return "LACS.properties";
	}
}
