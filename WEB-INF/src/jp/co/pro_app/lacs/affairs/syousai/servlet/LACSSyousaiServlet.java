package jp.co.pro_app.lacs.affairs.syousai.servlet;

import jp.co.pro_app.projframe.common.servlet.ServletBase;

/**
 * 契約詳細Servlet.
 * 
 * @author yokota
 * @version 20081017
 */
public class LACSSyousaiServlet extends ServletBase {

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
