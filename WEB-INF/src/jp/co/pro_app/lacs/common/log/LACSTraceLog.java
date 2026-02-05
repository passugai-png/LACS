package jp.co.pro_app.lacs.common.log;

//import java.io.File;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
//import jp.co.pro_app.projframe.common.log.Log;
import jp.co.pro_app.projframe.common.servlet.ServletBase;
/**
 * LACS ログ出力クラス.
 * 
 * @author katoken
 * @version 20070327
 */
public class LACSTraceLog /*extends Log */{

	private Logger			logger		= null;

	private String			clientIP	= "";

	private LACSModelBase	model		= null;

	private String			procName	= "";

	/**
	 * コンストラクタ.
	 * 
	 * @param piServlet
	 *            Servlet
	 * @param piModel
	 *            Model
	 */
	LACSTraceLog(ServletBase piServlet, LACSModelBase piModel) {
//		super(piServlet, LACSTraceLog.class.getName(), "log4j" + (File.separator.equals("\\") ? "win" : "linux") + ".properties");
		this.model = piModel;
		this.procName = piModel.getProcName() + "：" + piModel.getProcSubName();
		this.clientIP = piModel.getRequest().getRemoteAddr();

		logger = LogManager.getLogger();
	}

	private String getMessage(String piLevel, String piMessage, String piProc) {
		return Convert.toString(new Date(), Convert.FORMAT_YYYY_MM_DD_HH24_MI_SS) + "," + piLevel + "," + model.getClass().getName() + "," + piMessage + "," + clientIP + "," + procName + ((piProc == null || piProc.trim().length() == 0) ? "" : " - " + piProc);
	}

	/**
	 * Infoを書き込みます.
	 * 
	 * @param piMessage
	 *            メッセージ
	 */
	public void info(String piMessage) {
		this.logger.info(this.getMessage("I", piMessage, ""));
	}

	/**
	 * Warnを書き込みます.
	 * 
	 * @param piMessage
	 *            メッセージ
	 */
	public void warn(String piMessage) {
		this.logger.warn(this.getMessage("W", piMessage, ""));
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
		this.logger.error(this.getMessage("E", piMessage, piProcSubName));
	}

	/**
	 * Fatalを書き込みます.
	 * 
	 * @param piMessage
	 *            メッセージ
	 */
	public void fatal(String piMessage) {
		this.logger.fatal(this.getMessage("S", piMessage, ""));
	}

	/**
	 * 開始メッセージを書き込みます.
	 */
	public void start() {
		this.logger.info(this.getMessage("I", "", "開始"));
	}

	/**
	 * 終了メッセージを書き込みます.
	 */
	public void end() {
		this.logger.info(this.getMessage("I", "", "終了"));
	}

}
