package jp.co.pro_app.lacs.affairs.dsreport.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.dsreport.bean.LACSDSReportBean;
import jp.co.pro_app.lacs.affairs.dsreport.common.LACSDSReportCommon;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;

/**
 * 帳票出力：初期表示処理Model.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSDSReportStartModel extends LACSDSReportModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "表示";
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
		Date termFrom = null;
		Calendar calendar = (GregorianCalendar)Calendar.getInstance();

		piReportBean.init(this.getCommonBean());
		super.prepareComoboBox(piReportBean);

		Date now = new Date();

		calendar.set(Calendar.DAY_OF_MONTH, 1);
		termFrom = Convert.toDate(DateUtl.getYear(now) + "0331", Convert.FORMAT_YYYYMMDD);

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		if (calendar.getTime().compareTo(termFrom) < 0) {
			termFrom = DateUtl.add(Calendar.YEAR, -1, termFrom);
		}
		termFrom = DateUtl.add(Calendar.DAY_OF_MONTH, 1, termFrom);

		now = calendar.getTime();

		LACSCommand.setDateField(super.getCommonBean(), con, this, Convert.toString(termFrom, Convert.FORMAT_YYYYMMDD), piReportBean.getTermFrom());

		LACSDSReportCommon.setTerm(super.getCommonBean(), this.con, this, piReportBean, termFrom, LACSDSReportCommon.TIMING_INIT);
	}
}
