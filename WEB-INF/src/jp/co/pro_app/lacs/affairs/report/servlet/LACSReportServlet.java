package jp.co.pro_app.lacs.affairs.report.servlet;

import jp.co.pro_app.projframe.common.servlet.ServletBase;

/**
 * 帳票出力Servlet.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSReportServlet extends ServletBase {

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
