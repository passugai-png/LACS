package jp.co.pro_app.lacs.affairs.shiwake.servlet;

import jp.co.pro_app.projframe.common.servlet.ServletBase;

/**
 * 仕訳照会Servlet.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiwakeServlet extends ServletBase {

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
