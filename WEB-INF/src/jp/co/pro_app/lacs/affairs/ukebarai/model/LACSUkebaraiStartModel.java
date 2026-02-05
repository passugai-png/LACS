package jp.co.pro_app.lacs.affairs.ukebarai.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.report.common.LACSReportCommon;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportUserEntity;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.command.StringUtl;

/**
 * 受払合計表：初期表示Model.
 * 
 * @author active
 * @version 20080808
 */
public class LACSUkebaraiStartModel extends LACSUkebaraiModelBase {

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
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSUkebaraiBean piUkebaraiBean) throws Exception {
		LACSReportUserEntity reportUserEntity = new LACSReportUserEntity(this);
		LACSCommonBean commonBean = super.getCommonBean();

		piUkebaraiBean.init(commonBean);
		piUkebaraiBean.initsub(commonBean);
		super.prepareComoboBox(piUkebaraiBean);

		Calendar calendar = (GregorianCalendar)Calendar.getInstance();

		Date now = new Date();
		piUkebaraiBean.setNextFocus(this.getParam("nextFocus", 0));

		Date termFrom = null;
		Date termTo = null;

		if (commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER) {

			try {

				reportUserEntity.setCon(super.con);
				reportUserEntity.setLeasCompany(commonBean.getCosmosCode());
				reportUserEntity.execSQL();

				if (reportUserEntity.next()) {
					termFrom = Convert.toDate(DateUtl.getYear(now) + reportUserEntity.getKesnKi(), Convert.FORMAT_YYYYMMDD);
					termFrom = DateUtl.add(Calendar.DAY_OF_MONTH, 1, termFrom);
					super.prepareComoboBox(piUkebaraiBean);
					if (reportUserEntity.getKesnKi().equals("0228")) {
						calendar.setTime(termFrom);
						calendar.set(Calendar.MONTH, 2);
						calendar.set(Calendar.DAY_OF_MONTH, 1);
						termFrom = calendar.getTime();
					}
					LACSCommand.setDateField(super.getCommonBean(), con, this, Convert.toString(DateUtl.getYear(termFrom)) + StringUtl.formatNumber(DateUtl.getMonth(termFrom), "00") + StringUtl.formatNumber(DateUtl.getDay(termFrom), "00"), piUkebaraiBean.getTermFrom());

					termTo = LACSReportCommon.addMonth(termFrom, Convert.toInt(piUkebaraiBean.getTsukiSu()));

					LACSCommand.setDateField(super.getCommonBean(), con, this, Convert.toString(DateUtl.getYear(termTo)) + StringUtl.formatNumber(DateUtl.getMonth(termTo), "00") + StringUtl.formatNumber(DateUtl.getDay(termTo), "00"), piUkebaraiBean.getTermTo());
				}

			}
			finally {
				reportUserEntity.close();
			}
			piUkebaraiBean.getLeasCompany().setSelectedValue(commonBean.getCosmosCode());
		}
		else {
			LACSCommand.setDateField(super.getCommonBean(), con, this, Convert.toString(DateUtl.getYear(now)) + StringUtl.formatNumber(DateUtl.getMonth(now), "00") + StringUtl.formatNumber(DateUtl.getDay(now), "00"), piUkebaraiBean.getTermFrom());

			termTo = LACSReportCommon.addMonth(now, Convert.toInt(piUkebaraiBean.getTsukiSu()));

			LACSCommand.setDateField(super.getCommonBean(), con, this, Convert.toString(DateUtl.getYear(termTo)) + StringUtl.formatNumber(DateUtl.getMonth(termTo), "00") + StringUtl.formatNumber(DateUtl.getDay(termTo), "00"), piUkebaraiBean.getTermTo());
		}
	}
}
