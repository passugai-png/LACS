package jp.co.pro_app.lacs.affairs.report.model;

import java.sql.SQLException;
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
 * 帳票出力：検索処理Model.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSReportUserSearchModel extends LACSReportModelBase {

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
	protected void businessProc(LACSReportBean piReportBean) throws Exception {

		this.getData(piReportBean);
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
	protected void initSub(LACSReportBean piReportBean) throws SQLException {
		LACSReportCommon.getInput(super.getCommonBean(), this.con, piReportBean, this, LACSReportCommon.TIMING_USER_CHANGE);

		piReportBean.getGensenOld().init(0);
		piReportBean.getGensenNew().init(0);

		piReportBean.getGoukeiOld().init(1);
		piReportBean.getGoukeiNew().init(1);

		piReportBean.getMikeikaBOld().init(1);
		piReportBean.getMikeikaBNew().init(1);

		piReportBean.getGenkaOld().init(1);
		piReportBean.getGenkaNew().init(1);
		piReportBean.getShiharaiOld().init(1);
		piReportBean.getShiharaiNew().init(1);
		piReportBean.getSchedule().init(0);
		
		piReportBean.getKizituSaimuNew().init(1);
		piReportBean.getKizituSaimuOld().init(1);
		piReportBean.getKizituSisanNew().init(1);
		piReportBean.getKizituSisanOld().init(1);
		piReportBean.getKizituGoukeiNew().init(1);
		piReportBean.getKizituGoukeiOld().init(1);
		
		piReportBean.getTyuki().init(1);

		piReportBean.setOldACCount(0);
		piReportBean.setNewACCount(0);

		piReportBean.setOldSumUnt("1");
		piReportBean.setNewSumUnt("1");
		piReportBean.setKaiknoTermkei("0");
	}

	/**
	 * データ取得.
	 * 
	 * @param piReportBean
	 *            リースユーザーマスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	private void getData(LACSReportBean piReportBean) throws SQLException {
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

				if (reportUserEntity.getKesnKi().equals("0228")) {
					calendar.setTime(termFrom);
					calendar.set(Calendar.MONTH, 2);
					calendar.set(Calendar.DAY_OF_MONTH, 1);

					termFrom = calendar.getTime();
				}

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

				piReportBean.setOldSumUnt(Command.init(reportUserEntity.getOldSumUnit(), "0"));
				piReportBean.setNewSumUnt(Command.init(reportUserEntity.getNewSumUnit(), "1"));

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
