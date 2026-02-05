package jp.co.pro_app.lacs.common.log;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.html.ComboArray;
import jp.co.pro_app.projframe.common.servlet.ServletBase;

/**
 * LACS ログ出力クラス.
 * 
 * @author katoken
 * @version 20070327
 */
public class LACSLog {

	private LACSTraceLog	traceLogger		= null;

	private LACSActionLog	actionLogger	= null;

	/**
	 * コンストラクタ.
	 * 
	 * @param piServlet
	 *            Servlet
	 * @param piModel
	 *            Model
	 * @param piProcName
	 *            処理名
	 * @param piCommonBean
	 *            LACS用共通Bean
	 */
	public LACSLog(ServletBase piServlet, LACSModelBase piModel, String piProcName, LACSCommonBean piCommonBean) {
		this.traceLogger = new LACSTraceLog(piServlet, piModel);
		this.actionLogger = new LACSActionLog(piServlet, piModel, piCommonBean);
	}

	/**
	 * Infoを書き込みます.
	 * 
	 * @param piMessage
	 *            メッセージ
	 * @param piProcSubName
	 *            処理名
	 */
	public void info(String piMessage, String piProcSubName) {
		this.traceLogger.info(piMessage);
	}

	/**
	 * Warnを書き込みます.
	 * 
	 * @param piMessage
	 *            メッセージ
	 * @param piProcSubName
	 *            処理名
	 */
	public void warn(String piMessage, String piProcSubName) {
		this.traceLogger.warn(piMessage);
	}

	/**
	 * Errorを書き込みます.
	 * 
	 * @param piMessage
	 *            メッセージ
	 * @param piProcSubName
	 *            処理名
	 */
	public void error(String piMessage, String piProcSubName) {
		this.traceLogger.error(piMessage, piProcSubName);
	}

	/**
	 * Fatalを書き込みます.
	 * 
	 * @param piMessage
	 *            メッセージ
	 * @param piProcSubName
	 *            処理名
	 */
	public void fatal(String piMessage, String piProcSubName) {
		this.traceLogger.fatal(piMessage);
	}

	/**
	 * 開始メッセージを書き込みます.
	 */
	public void start() {
		this.traceLogger.start();
	}

	/**
	 * 開始メッセージを書き込みます.
	 */
	public void action() {
		this.actionLogger.write();
	}

	/**
	 * 開始メッセージを書き込みます.
	 * 
	 * @param piComobo
	 *            対象開示先
	 */
	public void start(ComboArray piComobo) {
		this.actionLogger.write(piComobo.getValue(), piComobo.getName());
		this.traceLogger.info("");
	}

	/**
	 * 終了メッセージを書き込みます.
	 */
	public void end() {
		this.traceLogger.end();
	}

}
