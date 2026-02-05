package jp.co.pro_app.lacs.affairs.companyuserlist.servlet;

import jp.co.pro_app.projframe.common.servlet.ServletBase;

/**
 * リース会社別リースユーザーマスタ一覧Servlet.
 * 
 * @author active
 * @version 20071210
 */
public class LACSCompanyUserListServlet extends ServletBase {

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
