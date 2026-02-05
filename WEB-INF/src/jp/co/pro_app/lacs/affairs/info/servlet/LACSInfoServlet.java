package jp.co.pro_app.lacs.affairs.info.servlet;

import jp.co.pro_app.projframe.common.servlet.ServletBase;

/**
 * お知らせServlet.
 * 
 * @author takeda
 * @version 20070904
 */
public class LACSInfoServlet extends ServletBase {

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
