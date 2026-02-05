package jp.co.pro_app.lacs.common.model;

import java.util.Properties;

import jp.co.pro_app.projframe.common.dbconnection.DBConnectionInfo;

/**
 * LACS固定DBスーパークラス.
 * 
 * @author katoken
 * @version 20070312
 */
public abstract class LACSConstDBModelBase extends LACSModelBase {

	/**
	 * 業務用DB接続情報を取得.
	 * 
	 * @return 業務用DB接続情報
	 */
	protected DBConnectionInfo getConnectionInfo() {
		DBConnectionInfo connectionInfo = new DBConnectionInfo();

		Properties prop = super.getServlet().getDefaultProperties();

		connectionInfo.setConnectionMode(prop.getProperty("connectionMode", "1"));
		connectionInfo.setInitialContextFactory(prop.getProperty("initialContextFactory", ""));
		connectionInfo.setDataSource(prop.getProperty("dataSource", ""));

		return connectionInfo;

	}

}
