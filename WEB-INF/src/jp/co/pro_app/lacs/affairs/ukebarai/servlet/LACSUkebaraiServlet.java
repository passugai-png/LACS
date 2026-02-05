package jp.co.pro_app.lacs.affairs.ukebarai.servlet;

import jp.co.pro_app.projframe.common.servlet.ServletBase;

/**
 * 受払合計表Servlet.
 * 
 * @author active
 * @version 20080808
 */
public class LACSUkebaraiServlet extends ServletBase {

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
