package jp.co.pro_app.lacs.affairs.report.model;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSDispControlBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.common.LACSReportCommon;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportUserEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.command.StringUtl;

/**
 * 帳票出力：初期表示処理Model.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSReportStartModel extends LACSReportModelBase {

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
	protected void initSub(LACSReportBean piReportBean) throws Exception {
		LACSCommonBean commonBean = super.getCommonBean();
		LACSDispControlBean controlBean = commonBean.getDispControl();
		piReportBean.init(this.getCommonBean());
		super.prepareComoboBox(piReportBean);

		Calendar calendar = (GregorianCalendar)Calendar.getInstance();

		Date now = new Date();

		LACSCommand.setDateField(super.getCommonBean(), con, this, Convert.toString(DateUtl.getYear(now)) + StringUtl.formatNumber(DateUtl.getMonth(now), "00") + StringUtl.formatNumber(DateUtl.getDay(now), "00"), piReportBean.getTermFrom());

		calendar.setTime(now);

		calendar.set(Calendar.DAY_OF_MONTH, 1);

		now = calendar.getTime();

		LACSReportCommon.setTerm(super.getCommonBean(), this.con, this, piReportBean, now, LACSReportCommon.TIMING_INIT);

		if (commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER) {
			piReportBean.getLeasCompany().setSelectedValue(commonBean.getCosmosCode());
			this.getData(piReportBean, commonBean.getCosmosCode());

		}

		if (!controlBean.isAvailableAny(new String[]{ "P0000001", "P0000002", "P0000003", "P0000006", "P0000007" })) {
			piReportBean.setOldACCount(0);
			piReportBean.setNewACCount(0);
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
	private void getData(LACSReportBean piReportBean, String piCosmosCode) throws SQLException {
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
				piReportBean.setOldSumUnt("1");
				piReportBean.setNewSumUnt("1");

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
