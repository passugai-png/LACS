package jp.co.pro_app.lacs.affairs.monthreport.model;

import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.affairs.monthreport.common.LACSMReportCommon;

/**
 * 月次帳票出力：絞り込みModel.
 * 
 * @author katoken
 * @version 20080616
 */
public class LACSMReportFilterModel extends LACSMReportModelBase {

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
	protected void initSub(LACSMReportBean piReportBean) throws Exception {
		piReportBean.init(this.getCommonBean());
		piReportBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));
		super.prepareComoboBox(piReportBean);

		LACSMReportCommon.getInput(super.getCommonBean(), this.con, piReportBean, this, LACSMReportCommon.TIMING_PRINT_PDF);

	}
}
