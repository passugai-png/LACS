package jp.co.pro_app.lacs.affairs.ukebarai.model;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.report.common.LACSReportCommon;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportUserEntity;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.command.StringUtl;

/**
 * 受払合計表：検索処理Model.
 * 
 * @author active
 * @version 20081122
 */
public class LACSUkebaraiUserChangeModel extends LACSUkebaraiModelBase {

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
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSUkebaraiBean piUkebaraiBean) throws Exception {
		LACSCommonBean commonBean = super.getCommonBean();
		piUkebaraiBean.initsub(commonBean);
		this.getData(piUkebaraiBean);
		piUkebaraiBean.setMessage(message.getMessage());
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSUkebaraiBean piUkebaraiBean) throws SQLException {
		piUkebaraiBean.setNextFocus(this.getParam("nextFocus", 0));
		piUkebaraiBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));
		piUkebaraiBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));
		piUkebaraiBean.setTsukiSu(super.getInput("tsukiSu", ""));

		// piUkebaraiBean.setPathGokei("");
		// piUkebaraiBean.setPathSisan("");
		// piUkebaraiBean.setPathLease("");
		// piUkebaraiBean.setPathHiyo("");
		// piUkebaraiBean.setChkGokei("");
		// piUkebaraiBean.setChkSisan("");
		// piUkebaraiBean.setChkLease("");
		// piUkebaraiBean.setChkHiyo("");

		piUkebaraiBean.getGokei().init(0);
		piUkebaraiBean.getSisan().init(0);
		piUkebaraiBean.getLease().init(0);
		piUkebaraiBean.getHiyo().init(0);

		piUkebaraiBean.setCurrent(1);
		piUkebaraiBean.setMessage("");
	}

	/**
	 * データをDBから取得する.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @throws SQLException
	 *             SQL実行例外
	 */
	private void getData(LACSUkebaraiBean piUkebaraiBean) throws SQLException {
		LACSReportUserEntity reportUserEntity = new LACSReportUserEntity(this);

		Date termFrom = null;
		Date termTo = null;
		Date now = new Date();
		Calendar calendar = (GregorianCalendar)Calendar.getInstance();

		try {
			reportUserEntity.setCon(super.con);

			reportUserEntity.setLeasCompany(piUkebaraiBean.getLeasCompany().getValue());
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

				if (reportUserEntity.getKesnKi().equals("0228")) {
					calendar.setTime(termFrom);
					calendar.set(Calendar.MONTH, 2);
					calendar.set(Calendar.DAY_OF_MONTH, 1);

					termFrom = calendar.getTime();
				}

				piUkebaraiBean.getTermFrom().setDate("", StringUtl.paddingLeft(DateUtl.getYear(termFrom), "0", 4), StringUtl.paddingLeft(DateUtl.getMonth(termFrom), "0", 2), StringUtl.paddingLeft(DateUtl.getDay(termFrom), "0", 2));
				piUkebaraiBean.setTsukiSu("1");

				termTo = LACSReportCommon.addMonth(termFrom, Convert.toInt(piUkebaraiBean.getTsukiSu()));

				LACSCommand.setDateField(super.getCommonBean(), con, this, Convert.toString(DateUtl.getYear(termTo)) + StringUtl.formatNumber(DateUtl.getMonth(termTo), "00") + StringUtl.formatNumber(DateUtl.getDay(termTo), "00"), piUkebaraiBean.getTermTo());
			}
			else {
				piUkebaraiBean.getTermFrom().setDate("", this.getInput("termFromData", ""), this.getInput("termFromMonth", ""), this.getInput("termFromDay", ""));
			}
		}
		finally {
			reportUserEntity.close();
		}
	}
}
