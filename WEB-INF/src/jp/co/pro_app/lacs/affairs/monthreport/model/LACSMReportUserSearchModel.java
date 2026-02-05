package jp.co.pro_app.lacs.affairs.monthreport.model;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.affairs.monthreport.common.LACSMReportCommon;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportUserEntity;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.command.StringUtl;

/**
 * 月次帳票出力：検索処理Model.
 * 
 * @author yamaguchi
 * @version 20080408
 */
public class LACSMReportUserSearchModel extends LACSMReportModelBase {

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
	protected void businessProc(LACSMReportBean piReportBean) throws Exception {

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
	protected void initSub(LACSMReportBean piReportBean) throws SQLException {
		LACSMReportCommon.getInput(super.getCommonBean(), this.con, piReportBean, this, LACSMReportCommon.TIMING_USER_CHANGE);

		piReportBean.getRemoveAssert().init(1);
		piReportBean.getSiwake().init(1);
		piReportBean.getSisan().init(1);
		piReportBean.getSyouhizei().init(1);

		piReportBean.getKaikeiMeisai().init(0);

		piReportBean.getDownload().init(0);

	}

	/**
	 * データ取得.
	 * 
	 * @param piReportBean
	 *            リースユーザーマスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	private void getData(LACSMReportBean piReportBean) throws SQLException {
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
