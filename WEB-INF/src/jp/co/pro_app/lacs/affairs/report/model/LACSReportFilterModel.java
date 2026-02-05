package jp.co.pro_app.lacs.affairs.report.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.common.LACSReportCommon;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportUserEntity;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.command.StringUtl;

/**
 * í†ï[èoóÕÅFçiÇËçûÇ›Model.
 * 
 * @author katoken
 * @version 20080616
 */
public class LACSReportFilterModel extends LACSReportModelBase {

	/**
	 * èàóùñºÇéÊìæ.
	 * 
	 * @return èàóùñº
	 */
	public String getProcSubName() {
		return "çiçû";
	}

	/**
	 * ã∆ñ±å≈óLèâä˙âª.
	 * 
	 * @param piReportBean
	 *            í†ï[èoóÕBean
	 * @exception Exception
	 *                é¿çsó·äO
	 */
	protected void initSub(LACSReportBean piReportBean) throws Exception {
		piReportBean.init(this.getCommonBean());
		piReportBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));
		super.prepareComoboBox(piReportBean);

		LACSReportCommon.getInput(super.getCommonBean(), this.con, piReportBean, this, LACSReportCommon.TIMING_PRINT_PDF);
		LACSReportUserEntity reportUserEntity = new LACSReportUserEntity(this);

		Date termFrom = null;
		Date now = new Date();

		Calendar calendar = (GregorianCalendar)Calendar.getInstance();

		try {
			reportUserEntity.setCon(super.con);

			reportUserEntity.setLeasCompany(piReportBean.getLeasCompany().getValue());
			reportUserEntity.execSQL();
			if (reportUserEntity.next()) {
				termFrom = Convert.toDate(DateUtl.getYear(now) + reportUserEntity.getKesnKi(), Convert.FORMAT_YYYYMMDD);

				calendar.setTime(now);

				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);

				if (calendar.getTime().compareTo(termFrom) < 0) {
					termFrom = DateUtl.add(Calendar.YEAR, -1, termFrom);
				}

				termFrom = DateUtl.add(Calendar.DAY_OF_MONTH, 1, termFrom);

				piReportBean.getTermFrom().setDate("", StringUtl.paddingLeft(DateUtl.getYear(termFrom), "0", 4), StringUtl.paddingLeft(DateUtl.getMonth(termFrom), "0", 2), StringUtl.paddingLeft(DateUtl.getDay(termFrom), "0", 2));
				piReportBean.setOldTyutoKaiyaku(Command.init(reportUserEntity.getOldCytKaiJgiFlg(), "0"));
				piReportBean.setOldSaiLease(Command.init(reportUserEntity.getOldRlsKeiJgiFlg(), "0"));
				piReportBean.setOldKeiyakuGaku(Command.init(reportUserEntity.getOldSgkKeiJgiFlg(), "0"));
				piReportBean.setOldLeaseKikan(Command.init(reportUserEntity.getOldSrtKeiJgiFlg(), "0"));
				piReportBean.setNewTyutoKaiyaku(Command.init(reportUserEntity.getNewCytKaiJgiFlg(), "0"));
				piReportBean.setNewSaiLease(Command.init(reportUserEntity.getNewRlsKeiJgiFlg(), "0"));
				piReportBean.setNewKeiyakuGaku(Command.init(reportUserEntity.getNewSgkKeiJgiFlg(), "0"));
				piReportBean.setNewLeaseKikan(Command.init(reportUserEntity.getNewSrtKeiJgiFlg(), "0"));
				piReportBean.setKaikeiSyori(Command.init(reportUserEntity.getAcShrKbn(), "0"));
				piReportBean.setNewACCount(reportUserEntity.getNewACCount());
				piReportBean.setOldACCount(reportUserEntity.getOldACCount());

				LACSReportCommon.setTerm(super.getCommonBean(), con, this, piReportBean, termFrom, LACSReportCommon.TIMING_USER_CHANGE);
			}
			else {
				piReportBean.setNewACCount(1);
				piReportBean.setOldACCount(1);
			}
		}
		finally {
			reportUserEntity.close();
		}

	}
}
