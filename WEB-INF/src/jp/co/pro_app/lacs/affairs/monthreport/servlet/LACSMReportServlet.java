package jp.co.pro_app.lacs.affairs.monthreport.servlet;

import jp.co.pro_app.projframe.common.servlet.ServletBase;

/**
 * 月次帳票出力Servlet.
 * 
 * @author fukuhara
 * @version 20080410
 */
public class LACSMReportServlet extends ServletBase {

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
