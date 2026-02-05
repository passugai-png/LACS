package jp.co.pro_app.lacs.affairs.monthreport.model;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.affairs.monthreport.common.LACSMReportCommon;
import jp.co.pro_app.lacs.affairs.report.common.LACSReportCommon;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportUserEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.command.StringUtl;

/**
 * 月次帳票出力：初期表示処理Model.
 * 
 * @author yamaguchi
 * @version 20080408
 */
public class LACSMReportStartModel extends LACSMReportModelBase {

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
	protected void initSub(LACSMReportBean piReportBean) throws Exception {
		LACSCommonBean commonBean = super.getCommonBean();
		piReportBean.init(commonBean);
		super.prepareComoboBox(piReportBean);

		Calendar calendar = (GregorianCalendar)Calendar.getInstance();

		Date now = new Date();

		LACSCommand.setDateField(super.getCommonBean(), con, this, Convert.toString(DateUtl.getYear(now)) + StringUtl.formatNumber(DateUtl.getMonth(now), "00") + StringUtl.formatNumber(DateUtl.getDay(now), "00"), piReportBean.getTermFrom());

		calendar.setTime(now);

		calendar.set(Calendar.DAY_OF_MONTH, 1);

		now = calendar.getTime();

		LACSMReportCommon.setTerm(super.getCommonBean(), this.con, this, piReportBean, now, LACSReportCommon.TIMING_INIT);

		if (commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER) {
			piReportBean.getLeasCompany().setSelectedValue(commonBean.getCosmosCode());
			this.getData(piReportBean, commonBean.getCosmosCode());
		}
	}

	/**
	 * データ取得.
	 * 
	 * @param piReportBean
	 *            リースユーザーマスタBean
	 * @param piCosmosCode
	 *            COSMOSコード
	 * @exception SQLException
	 *                SQL実行例外
	 */
	private void getData(LACSMReportBean piReportBean, String piCosmosCode) throws SQLException {
		LACSReportUserEntity reportUserEntity = new LACSReportUserEntity(this);

		Date termFrom = null;
		Date now = new Date();

		Calendar calendar = (GregorianCalendar)Calendar.getInstance();

		try {
			reportUserEntity.setCon(super.con);

			reportUserEntity.setLeasCompany(piCosmosCode);
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

				LACSCommand.setDateField(super.getCommonBean(), con, this, Convert.toString(DateUtl.getYear(termFrom)) + StringUtl.formatNumber(DateUtl.getMonth(termFrom), "00") + StringUtl.formatNumber(StringUtl.formatNumber(DateUtl.getDay(termFrom)), "00"), piReportBean.getTermFrom());
				piReportBean.setGtjTyutoKaiyaku(Command.init(reportUserEntity.getGtjCytKaiJgiFlg(), "0"));
				piReportBean.setGtjSaiLease(Command.init(reportUserEntity.getGtjRlsKeiJgiFlg(), "0"));
				piReportBean.setGtjKeiyakuGaku(Command.init(reportUserEntity.getGtjSgkKeiJgiFlg(), "0"));
				piReportBean.setGtjLeaseKikan(Command.init(reportUserEntity.getGtjSrtKeiJgiFlg(), "0"));

				LACSMReportCommon.setTerm(super.getCommonBean(), this.con, this, piReportBean, termFrom, LACSMReportCommon.TIMING_USER_CHANGE);
			}
		}
		finally {
			reportUserEntity.close();
		}
	}
}
