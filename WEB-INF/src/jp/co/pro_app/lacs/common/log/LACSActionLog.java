package jp.co.pro_app.lacs.common.log;

//import java.io.File;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
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
public class LACSActionLog /*extends Log*/ {

	private Logger			logger		= null;

	private String			clientIP	= "";

	private LACSCommonBean	commonBean	= null;

	private String			procName	= "";

	private String			procSubName	= "";

	/**
	 * コンストラクタ.
	 * 
	 * @param piServlet
	 *            Servlet
	 * @param piModel
	 *            Model
	 * @param piCommonBean
	 *            LACS共通Bean
	 */
	LACSActionLog(ServletBase piServlet, LACSModelBase piModel, LACSCommonBean piCommonBean) {
//		super(piServlet, LACSActionLog.class.getName(), "log4j" + (File.separator.equals("\\") ? "win" : "linux") + ".properties");
		this.clientIP = piModel.getRequest().getRemoteAddr();
		commonBean = piCommonBean == null ? new LACSCommonBean() : piCommonBean;
		this.procName = piModel.getProcName();
		this.procSubName = piModel.getProcSubName();

		logger = LogManager.getLogger();
	}

	private String getMessage(String piTarget) {

		String dt = Convert.toString(new Date(), Convert.FORMAT_YYYY_MM_DD_HH24_MI_SS);
		String userRight = commonBean.getUserRight();
		String cosmosCode = commonBean.getUserRight().equals(LACSDefine.UserRight.END_USER) ? commonBean.getCosmosCode() : "";
		String userName = commonBean.getUserRight().equals(LACSDefine.UserRight.END_USER) ? commonBean.getCosmosName() : "";
		String userId = commonBean.getLoginUserId();
		String tantoName = commonBean.getTantoName();

		return dt + "," + clientIP + "," + userRight + "," + cosmosCode + "," + userName + "," + userId + "," + tantoName + "," + procName + "：" + procSubName + "," + piTarget;
	}

	/**
	 * ログを出力.
	 */
	public void write() {

		this.logger.info(this.getMessage(","));
	}

	/**
	 * ログを出力.
	 * 
	 * @param piTargetCosmosCode
	 *            対象開示先コード
	 * @param piTagetUserName
	 *            対象開示先名称
	 */
	public void write(String piTargetCosmosCode, String piTagetUserName) {
		this.logger.info(this.getMessage(piTargetCosmosCode + "," + piTagetUserName));
	}
}
