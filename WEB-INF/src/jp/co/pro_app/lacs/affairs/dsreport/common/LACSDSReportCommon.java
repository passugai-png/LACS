package jp.co.pro_app.lacs.affairs.dsreport.common;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCheckUtl;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.common.command.LACSMessage;
import jp.co.pro_app.lacs.affairs.dsreport.bean.LACSDSReportBean;
import jp.co.pro_app.lacs.affairs.dsreport.model.LACSDSReportModelBase;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.CheckUtl;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.command.StringUtl;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 帳票出力：共通部品.
 * 
 * @author katoken
 * @version 20080215
 */
public class LACSDSReportCommon {

	/**
	 * タイミング：初期化.
	 */
	public static final int	TIMING_INIT			= 0;

	/**
	 * タイミング：リースユーザ切り替え.
	 */
	public static final int	TIMING_USER_CHANGE	= 1;

	/**
	 * タイミング：期間切り替え.
	 */
	public static final int	TIMING_TERM_CHANGE	= 2;

	/**
	 * タイミング：印刷.
	 */
	public static final int	TIMING_PRINT_PDF	= 3;

	/**
	 * タイミング：CSV作成.
	 */
	public static final int	TIMING_PRINT_CSV	= 4;

	/**
	 * コンストラクタ.
	 */
	private LACSDSReportCommon() {
	}

	/**
	 * 入力値取得.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piCon
	 *            DB接続
	 * @param piModel
	 *            モデル
	 * @param piReportBean
	 *            LACS帳票Bean
	 * @param piTiming
	 *            処理タイミング
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public static void getInput(LACSCommonBean piCommonBean, Connection piCon, LACSDSReportBean piReportBean, LACSDSReportModelBase piModel, int piTiming) throws SQLException {

		int quarter = piModel.getParam("quarter", 4);

		piReportBean.getTermFrom().setDate(piModel.getInput("termFromEra", ""), piModel.getInput("termFromData", ""), piModel.getInput("termFromMonth", ""), piModel.getInput("termFromDay", ""));
		piReportBean.setTermNum0(piModel.getInput("termNum0", ""));
		piReportBean.setQuarter(piModel.getInput("quarter", ""));

		piReportBean.getLeasCompany().setSelectedValue(piModel.getInput("leasCompany", ""));

		piReportBean.setLeasCompanyNm(piModel.getInput("leasCompanyNm", ""));

		piReportBean.setDataMax(0);

		piReportBean.setMessage("");

		piReportBean.getTermTo().setDate(piModel.getInput("termTo" + quarter + "Era", ""), piModel.getInput("termTo" + quarter + "Data", ""), piModel.getInput("termTo" + quarter + "Month", ""), piModel.getInput("termTo" + quarter + "Day", ""));
		piReportBean.setTermNum(piModel.getInput("termNum" + quarter, "0"));

		String termFrom = "";

		termFrom = LACSCommand.toDateYYYYMMDD(piCommonBean, piCon, piModel, piReportBean.getTermFrom());
		if (CheckUtl.isDate(termFrom)) {
			LACSDSReportCommon.setTerm(piCommonBean, piCon, piModel, piReportBean, Convert.toDate(termFrom, Convert.FORMAT_YYYYMMDD), piTiming);
		}

		piReportBean.setNextFocus(piModel.getParam("nextFocus", 0));

	}

	/**
	 * 日付を加算します.
	 * 
	 * @param piDate
	 *            対象日付
	 * @param piTerm
	 *            期間
	 * @return 指定期間後の日付
	 */
	public static Date addMonth(Date piDate, int piTerm) {
		Date temp = null;

		temp = DateUtl.add(Calendar.MONTH, piTerm, piDate);
		temp = DateUtl.add(Calendar.DAY_OF_YEAR, -1, temp);

		return temp;
	}

	/**
	 * 期間を設定します.
	 * 
	 * @param piCommonBean
	 *            LACS用共通Bean
	 * @param piCon
	 *            ＤＢ接続
	 * @param piModel
	 *            帳票出力Model
	 * @param piReportBean
	 *            LACS帳票Bean
	 * @param piTermFrom
	 *            期間開始
	 * @param piTiming
	 *            処理タイミング
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public static void setTerm(LACSCommonBean piCommonBean, Connection piCon, DBModelBase piModel, LACSDSReportBean piReportBean, Date piTermFrom, int piTiming) throws SQLException {
		Date date = null;

		if (piTiming == TIMING_INIT) {
			date = LACSDSReportCommon.addMonth(piTermFrom, 1);

			LACSCommand.setDateField(piCommonBean, piCon, piModel, Convert.toString(DateUtl.getYear(date)) + StringUtl.formatNumber(DateUtl.getMonth(date), "00") + StringUtl.formatNumber(DateUtl.getDay(date)), piReportBean.getTermTo0());
		}
		else if (piTiming == TIMING_USER_CHANGE) {
			if (CheckUtl.isInteger(piReportBean.getTermNum0())) {
				date = LACSDSReportCommon.addMonth(piTermFrom, Convert.toInt(piReportBean.getTermNum0()));

				LACSCommand.setDateField(piCommonBean, piCon, piModel, Convert.toString(DateUtl.getYear(date)) + StringUtl.formatNumber(DateUtl.getMonth(date), "00") + StringUtl.formatNumber(DateUtl.getDay(date)), piReportBean.getTermTo0());
			}
		}
		else {
			if (CheckUtl.isInteger(piReportBean.getTermNum0())) {
				date = Convert.toDate(LACSCommand.toDateYYYYMMDD(piCommonBean, piCon, piModel, piReportBean.getTermFrom()), Convert.FORMAT_YYYYMMDD);
				date = DateUtl.add(Calendar.MONTH, Convert.toInt(piReportBean.getTermNum0()), date);
				date = DateUtl.add(Calendar.DAY_OF_YEAR, -1, date);

				LACSCommand.setDateField(piCommonBean, piCon, piModel, Convert.toString(DateUtl.getYear(date)) + StringUtl.formatNumber(DateUtl.getMonth(date), "00") + StringUtl.formatNumber(DateUtl.getDay(date)), piReportBean.getTermTo0());
			}
		}

		date = LACSDSReportCommon.addMonth(piTermFrom, 3);

		LACSCommand.setDateField(piCommonBean, piCon, piModel, Convert.toString(DateUtl.getYear(date)) + StringUtl.formatNumber(DateUtl.getMonth(date), "00") + StringUtl.formatNumber(DateUtl.getDay(date)), piReportBean.getTermTo1());

		date = LACSDSReportCommon.addMonth(piTermFrom, 6);

		LACSCommand.setDateField(piCommonBean, piCon, piModel, Convert.toString(DateUtl.getYear(date)) + StringUtl.formatNumber(DateUtl.getMonth(date), "00") + StringUtl.formatNumber(DateUtl.getDay(date)), piReportBean.getTermTo2());

		date = LACSDSReportCommon.addMonth(piTermFrom, 9);

		LACSCommand.setDateField(piCommonBean, piCon, piModel, Convert.toString(DateUtl.getYear(date)) + StringUtl.formatNumber(DateUtl.getMonth(date), "00") + StringUtl.formatNumber(DateUtl.getDay(date)), piReportBean.getTermTo3());

		date = LACSDSReportCommon.addMonth(piTermFrom, 12);

		LACSCommand.setDateField(piCommonBean, piCon, piModel, Convert.toString(DateUtl.getYear(date)) + StringUtl.formatNumber(DateUtl.getMonth(date), "00") + StringUtl.formatNumber(DateUtl.getDay(date)), piReportBean.getTermTo4());
	}

	/**
	 * 入力チェック.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piCon
	 *            DB接続
	 * @param piModel
	 *            モデル
	 * @param piReportBean
	 *            帳票出力Bean
	 * @param piMessage
	 *            メッセージ
	 * @param piTiming
	 *            処理タイミング
	 * @return チェック結果
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public static boolean checkInput(LACSCommonBean piCommonBean, Connection piCon, LACSModelBase piModel, LACSDSReportBean piReportBean, LACSMessage piMessage, int piTiming) throws SQLException {
		boolean result = true;

		LACSCheckUtl checkUtl = new LACSCheckUtl(piMessage);

		try {
			if (piTiming == TIMING_PRINT_PDF || piTiming == TIMING_PRINT_CSV) {
				String termFrom = "";
				String termTo = "";

				termFrom = LACSCommand.toDateYYYYMMDD(piCommonBean, piCon, piModel, piReportBean.getTermFrom());
				result &= checkUtl.checkDate("対象期間：開始日", termFrom);
				piReportBean.getTermFrom().setYYYYMMDD(termFrom);

				if (piReportBean.getQuarter().equals("0")) {
					result &= checkUtl.checkMandatory("対象期間：○○ヶ月", piReportBean.getTermNum0());
					result &= checkUtl.checkNumeric("対象期間：○○ヶ月", piReportBean.getTermNum0());
				}

				termTo = LACSCommand.toDateYYYYMMDD(piCommonBean, piCon, piModel, piReportBean.getTermTo());
				result &= checkUtl.checkDate("対象期間：終了日", termTo);
				piReportBean.getTermTo().setYYYYMMDD(termTo);

				if (CheckUtl.isDate(termFrom) && CheckUtl.isDate(termTo)) {
					result &= checkUtl.checkDateOrder("対象期間", Convert.toDate(termFrom, Convert.FORMAT_YYYYMMDD), Convert.toDate(termTo, Convert.FORMAT_YYYYMMDD));
				}
			}
		}
		finally {
		}

		return result;
	}
}
