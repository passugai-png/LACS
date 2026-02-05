package jp.co.pro_app.lacs.affairs.report.common;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCheckUtl;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.common.command.LACSMessage;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSOptionEntity;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.model.LACSReportModelBase;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.CheckUtl;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.command.StringUtl;
import jp.co.pro_app.projframe.common.dbaccess.SelectEx;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 帳票出力：共通部品.
 * 
 * @author katoken
 * @version 20080215
 */
public class LACSReportCommon {

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
	private LACSReportCommon() {
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
	public static void getInput(LACSCommonBean piCommonBean, Connection piCon, LACSReportBean piReportBean, LACSReportModelBase piModel, int piTiming) throws SQLException {

		int quarter = piModel.getParam("quarter", 4);

		piReportBean.getTermFrom().setDate(piModel.getInput("termFromEra", ""), piModel.getInput("termFromData", ""), piModel.getInput("termFromMonth", ""), piModel.getInput("termFromDay", ""));
		piReportBean.setTermNum0(piModel.getInput("termNum0", ""));
		piReportBean.setQuarter(piModel.getInput("quarter", ""));
		piReportBean.setOldKeiyakuGaku(piModel.getInput("oldkeiyakuGaku", ""));
		piReportBean.setOldLeaseKikan(piModel.getInput("oldleaseKikan", ""));
		piReportBean.setOldSaiLease(piModel.getInput("oldsaiLease", ""));
		piReportBean.setOldTyutoKaiyaku(piModel.getInput("oldtyutoKaiyaku", ""));
		piReportBean.setNewKeiyakuGaku(piModel.getInput("newkeiyakuGaku", ""));
		piReportBean.setNewLeaseKikan(piModel.getInput("newleaseKikan", ""));
		piReportBean.setNewSaiLease(piModel.getInput("newsaiLease", ""));
		piReportBean.setNewTyutoKaiyaku(piModel.getInput("newtyutoKaiyaku", ""));
		piReportBean.setKaikeiSyori(piModel.getInput("kaikeiSyori", ""));

		piReportBean.getGensenOld().init(piModel.getParam("chkGensenOld", 0));
		piReportBean.getGensenNew().init(piModel.getParam("chkGensenNew", 0));

		piReportBean.getGoukeiOld().init(piModel.getParam("chkGoukeiOld", 0));
		piReportBean.getGoukeiNew().init(piModel.getParam("chkGoukeiNew", 0));

		piReportBean.getMikeikaBOld().init(piModel.getParam("chkMikeikaBOld", 0));
		piReportBean.getMikeikaBNew().init(piModel.getParam("chkMikeikaBNew", 0));

		piReportBean.getGenkaOld().init(piModel.getParam("chkGenkaOld", 0));
		piReportBean.getGenkaNew().init(piModel.getParam("chkGenkaNew", 0));
		piReportBean.getShiharaiOld().init(piModel.getParam("chkShiharaiOld", 0));
		piReportBean.getShiharaiNew().init(piModel.getParam("chkShiharaiNew", 0));
		piReportBean.getSchedule().init(piModel.getParam("chkSchedule", 0));
		piReportBean.getTyuki().init(piModel.getParam("chkTyuki", 0));
		
		// 20200615 arai 追加 start
		piReportBean.getKizituGoukeiNew().init(piModel.getParam("chkKizituGoukeiNew", 0));	
		piReportBean.getKizituGoukeiOld().init(piModel.getParam("chkKizituGoukeiOld", 0));
		piReportBean.getKizituSaimuNew().init(piModel.getParam("chkKizituSaimuNew", 0));	
		piReportBean.getKizituSaimuOld().init(piModel.getParam("chkKizituSaimuOld", 0));
		piReportBean.getKizituSisanNew().init(piModel.getParam("chkKizituSisanNew", 0));	
		piReportBean.getKizituSisanOld().init(piModel.getParam("chkKizituSisanOld", 0));
		// 20200615 arai 追加 end
		
		piReportBean.getLeasCompany().setSelectedValue(piModel.getInput("leasCompany", ""));
		piReportBean.setKeiyakuNo(piModel.getInput("keiyakuNo", ""));
		piReportBean.setBukkenNo(piModel.getInput("bukkenNo", ""));
		piReportBean.setBukkenEdaNo(piModel.getInput("bukkenEdaNo", ""));

		piReportBean.setLeasCompanyNm(piModel.getInput("leasCompanyNm", ""));

		piReportBean.setDataMax(0);

		piReportBean.setMessage("");

		piReportBean.getTermTo().setDate(piModel.getInput("termTo" + quarter + "Era", ""), piModel.getInput("termTo" + quarter + "Data", ""), piModel.getInput("termTo" + quarter + "Month", ""), piModel.getInput("termTo" + quarter + "Day", ""));
		piReportBean.setTermNum(piModel.getInput("termNum" + quarter, "0"));

		String termFrom = "";

		termFrom = LACSCommand.toDateYYYYMMDD(piCommonBean, piCon, piModel, piReportBean.getTermFrom());
		if (CheckUtl.isDate(termFrom)) {
			LACSReportCommon.setTerm(piCommonBean, piCon, piModel, piReportBean, Convert.toDate(termFrom, Convert.FORMAT_YYYYMMDD), piTiming);
		}

		piReportBean.setNextFocus(piModel.getParam("nextFocus", 0));

		piReportBean.setOldSumUnt(piModel.getInput("oldSumUnt", "1"));
		piReportBean.setNewSumUnt(piModel.getInput("newSumUnt", "1"));
		piReportBean.setKaiknoTermkei(piModel.getInput("kaiknoTermkei", "0"));

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
	 *            DB接続
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
	public static void setTerm(LACSCommonBean piCommonBean, Connection piCon, DBModelBase piModel, LACSReportBean piReportBean, Date piTermFrom, int piTiming) throws SQLException {
		Date date = null;

		if (piTiming == TIMING_INIT) {
			date = LACSReportCommon.addMonth(piTermFrom, 1);

			LACSCommand.setDateField(piCommonBean, piCon, piModel, Convert.toString(DateUtl.getYear(date)) + StringUtl.formatNumber(DateUtl.getMonth(date), "00") + StringUtl.formatNumber(DateUtl.getDay(date)), piReportBean.getTermTo0());
		}
		else if (piTiming == TIMING_USER_CHANGE) {
			if (CheckUtl.isInteger(piReportBean.getTermNum0())) {
				date = LACSReportCommon.addMonth(piTermFrom, Convert.toInt(piReportBean.getTermNum0()));

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

		date = LACSReportCommon.addMonth(piTermFrom, 3);

		LACSCommand.setDateField(piCommonBean, piCon, piModel, Convert.toString(DateUtl.getYear(date)) + StringUtl.formatNumber(DateUtl.getMonth(date), "00") + StringUtl.formatNumber(DateUtl.getDay(date)), piReportBean.getTermTo1());

		date = LACSReportCommon.addMonth(piTermFrom, 6);

		LACSCommand.setDateField(piCommonBean, piCon, piModel, Convert.toString(DateUtl.getYear(date)) + StringUtl.formatNumber(DateUtl.getMonth(date), "00") + StringUtl.formatNumber(DateUtl.getDay(date)), piReportBean.getTermTo2());

		date = LACSReportCommon.addMonth(piTermFrom, 9);

		LACSCommand.setDateField(piCommonBean, piCon, piModel, Convert.toString(DateUtl.getYear(date)) + StringUtl.formatNumber(DateUtl.getMonth(date), "00") + StringUtl.formatNumber(DateUtl.getDay(date)), piReportBean.getTermTo3());

		date = LACSReportCommon.addMonth(piTermFrom, 12);

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
	public static boolean checkInput(LACSCommonBean piCommonBean, Connection piCon, LACSModelBase piModel, LACSReportBean piReportBean, LACSMessage piMessage, int piTiming) throws SQLException {
		boolean result = true;
		boolean reportSelected = false;
		SelectEx select = new SelectEx(piCon);
		int scheduleMax = 0;

		LACSOptionEntity optionEntity = new LACSOptionEntity(piModel);

		LACSCheckUtl checkUtl = new LACSCheckUtl(piMessage);

		String displayString = "";

		try {
			if (piCommonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {

				displayString = "開示先";

			}
			else {
				displayString = "リース会社";
			}

			if (piReportBean.getLeasCompany().getValue().equals("")) {
				if (piCommonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {
					piMessage.addMessage(LACSDefine.MessageCode.ERROR_RELATE_NON_CHECK, displayString);
					result = false;
				}
				else {
					if (!piReportBean.getKeiyakuNo().equals("") || !piReportBean.getBukkenNo().equals("") || !piReportBean.getBukkenEdaNo().equals("")) {
						piMessage.addMessage(LACSDefine.MessageCode.ERROR_FIELD_MANDATORY, displayString);
						result = false;
					}
				}
			}

			if (piTiming == TIMING_PRINT_PDF || piTiming == TIMING_PRINT_CSV) {
				if (piReportBean.getKeiyakuNo().trim().length() == 0 && piReportBean.getBukkenNo().trim().length() != 0) {
					piMessage.addMessage(LACSDefine.MessageCode.ERROR_RELATE_KEI_NO_BKN_NO);
					result = false;
				}

				optionEntity.setCon(piCon);
				optionEntity.setOptionCode(LACSDefine.OptionCode.SCHEDULE_MAX);

				optionEntity.execSQL();
				if (optionEntity.next()) {
					scheduleMax = Convert.toInt(optionEntity.getOptionValue());
				}

				if (piReportBean.getSchedule().getCheckOutput() == 1) {
					if (piReportBean.getKeiyakuNo().trim().length() == 0 /* || piReportBean.getBukkenNo().trim().length() == 0 */) {
						piMessage.addMessage(LACSDefine.MessageCode.ERROR_RELATE_SHIHARAI_SCHEDUKE_KEI_NO);
						result = false;
					}
					else if (piTiming == TIMING_PRINT_PDF && select.getRecordCount("T_BKN B JOIN T_KEI K ON B.LC_CD = K.LC_CD AND B.KEI_NO = K.KEI_NO", "K.LC_CD = '" + LACSDefine.LC_CD + "' AND K.HYJYO_KEI_NO = '" + Command.changeQt(piReportBean.getKeiyakuNo()) + "' AND BKN_NO || CASE WHEN TRIM(BKN_EDANO) IS NULL THEN '' ELSE '-' || BKN_EDANO END LIKE '" + piReportBean.getBukkenNo() + "%'") > scheduleMax) {
						piMessage.addMessage(LACSDefine.MessageCode.ERROR_DB_BUKKEN_TOO_MANY, Convert.toString(scheduleMax));
						result = false;
					}
				}

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

			reportSelected |= piReportBean.getGoukeiOld().getCheckOutput() == 1;
			reportSelected |= piReportBean.getGoukeiNew().getCheckOutput() == 1;
			reportSelected |= piReportBean.getMikeikaBOld().getCheckOutput() == 1;
			reportSelected |= piReportBean.getMikeikaBNew().getCheckOutput() == 1;
			reportSelected |= piReportBean.getGenkaOld().getCheckOutput() == 1;
			reportSelected |= piReportBean.getGenkaNew().getCheckOutput() == 1;
			reportSelected |= piReportBean.getShiharaiOld().getCheckOutput() == 1;
			reportSelected |= piReportBean.getShiharaiNew().getCheckOutput() == 1;
			reportSelected |= piReportBean.getSchedule().getCheckOutput() == 1;
			reportSelected |= piReportBean.getTyuki().getCheckOutput() == 1;
			// 20200622 arai 追加
			reportSelected |= piReportBean.getKizituGoukeiNew().getCheckOutput() == 1;
			reportSelected |= piReportBean.getKizituGoukeiOld().getCheckOutput() == 1;
			reportSelected |= piReportBean.getKizituSaimuNew().getCheckOutput() == 1;
			reportSelected |= piReportBean.getKizituSaimuOld().getCheckOutput() == 1;
			reportSelected |= piReportBean.getKizituSisanNew().getCheckOutput() == 1;
			reportSelected |= piReportBean.getKizituSisanOld().getCheckOutput() == 1;

			if (piTiming == TIMING_PRINT_CSV) {
				reportSelected |= piReportBean.getGensenOld().getCheckOutput() == 1;
				reportSelected |= piReportBean.getGensenNew().getCheckOutput() == 1;
			}

			if (!reportSelected) {
				piMessage.addMessage(LACSDefine.MessageCode.ERROR_RELATE_NON_CHECK, "出力対象帳票");
				result = false;
			}
		}
		finally {
			optionEntity.close();
		}

		return result;
	}

}
