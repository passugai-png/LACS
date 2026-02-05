package jp.co.pro_app.lacs.affairs.report.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.common.LACSReportCommon;

/**
 * 帳票出力：検索処理Model.
 * 
 * @author katoken
 * @version 20080328
 */
public class LACSReportTermChangeModel extends LACSReportModelBase {

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
	protected void businessProc(LACSReportBean piReportBean) throws Exception {
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSReportBean piReportBean) throws SQLException {
		LACSReportCommon.getInput(super.getCommonBean(), this.con, piReportBean, this, LACSReportCommon.TIMING_TERM_CHANGE);
	}
}
