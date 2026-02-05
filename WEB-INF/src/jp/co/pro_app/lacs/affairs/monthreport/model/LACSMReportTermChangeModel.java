package jp.co.pro_app.lacs.affairs.monthreport.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.affairs.monthreport.common.LACSMReportCommon;

/**
 * 月次帳票出力：検索処理Model.
 * 
 * @author yamaguchi
 * @version 20080408
 */
public class LACSMReportTermChangeModel extends LACSMReportModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "期間変更";
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSMReportBean piReportBean) throws Exception {
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSMReportBean piReportBean) throws SQLException {
		LACSMReportCommon.getInput(super.getCommonBean(), this.con, piReportBean, this, LACSMReportCommon.TIMING_TERM_CHANGE);
	}
}
