package jp.co.pro_app.lacs.affairs.dsreport.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.dsreport.bean.LACSDSReportBean;
import jp.co.pro_app.lacs.affairs.dsreport.common.LACSDSReportCommon;

/**
 * 帳票出力：検索処理Model.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSDSReportUserSearchModel extends LACSDSReportModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "開示先変更";
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSDSReportBean piReportBean) throws Exception {
		piReportBean.setMessage(message.getMessage());
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSDSReportBean piReportBean) throws SQLException {
		piReportBean.init(this.getCommonBean());
		super.prepareComoboBox(piReportBean);

		LACSDSReportCommon.getInput(super.getCommonBean(), this.con, piReportBean, this, LACSDSReportCommon.TIMING_USER_CHANGE);

	}
}
