package jp.co.pro_app.lacs.affairs.dsreport.model;

import jp.co.pro_app.lacs.affairs.dsreport.bean.LACSDSReportBean;
import jp.co.pro_app.lacs.affairs.dsreport.common.LACSDSReportCommon;

/**
 * 帳票出力：絞り込みModel.
 * 
 * @author katoken
 * @version 20080616
 */
public class LACSDSReportFilterModel extends LACSDSReportModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "絞込";
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @exception Exception
	 *                実行例外
	 */
	protected void initSub(LACSDSReportBean piReportBean) throws Exception {
		piReportBean.init(this.getCommonBean());
		piReportBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));
		super.prepareComoboBox(piReportBean);

		LACSDSReportCommon.getInput(super.getCommonBean(), this.con, piReportBean, this, LACSDSReportCommon.TIMING_PRINT_PDF);
	}
}
