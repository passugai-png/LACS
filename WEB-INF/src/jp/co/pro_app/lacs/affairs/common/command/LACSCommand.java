package jp.co.pro_app.lacs.affairs.common.command;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSDateBean;
import jp.co.pro_app.lacs.affairs.top.data.entity.LACSWarekiEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.command.StringUtl;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * LACS用共通部品.
 * 
 * @author katoken
 * @version 20070312
 */
public final class LACSCommand {

	/**
	 * コンストラクタ.
	 */
	private LACSCommand() {
	}

	/**
	 * 西暦和暦変換.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piCon
	 *            DB接続
	 * @param piModelBase
	 *            Model
	 * @param piDateString
	 *            日付文字列
	 * @return 日付
	 * @throws SQLException
	 *             SQL例外
	 */
	public static String toDateYYYYMMDD(LACSCommonBean piCommonBean, Connection piCon, DBModelBase piModelBase, String piDateString) throws SQLException {
		return toDateYYYYMMDD(piCommonBean, piCon, piModelBase, piDateString, piCommonBean.getDateMode());
	}

	/**
	 * 西暦和暦変換.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piCon
	 *            DB接続
	 * @param piModelBase
	 *            Model
	 * @param piDateString
	 *            日付文字列
	 * @param piDateMode
	 *            西暦和暦コード
	 * @return 日付
	 * @throws SQLException
	 *             SQL例外
	 */
	public static String toDateYYYYMMDD(LACSCommonBean piCommonBean, Connection piCon, DBModelBase piModelBase, String piDateString, String piDateMode) throws SQLException {
		String result = "";
		LACSWarekiEntity warekiEntity = new LACSWarekiEntity(piModelBase);

		try {
			if (piDateString != null && piDateString.trim().length() > 0) {
				if (piDateMode.equals(LACSDefine.DateMode.SEIREKI)) {
					result = Convert.toDateString(piDateString);
				}
				else {
					String from = "";

					Date fromDate = null;
					Date inputDate = null;

					int fromYear = 0;

					int inputWarekiYear = 0;
					int inputYear = 0;
					int inputMonth = 0;
					int inputDay = 0;

					String era = "";

					inputDate = Convert.toDate(piDateString, Convert.FORMAT_YYYYMMDD);

					inputYear = DateUtl.getYear(inputDate);
					inputMonth = DateUtl.getMonth(inputDate);
					inputDay = DateUtl.getDay(inputDate);

					warekiEntity.setCon(piCon);
					warekiEntity.setTargetDate(piDateString);

					warekiEntity.execSQL();

					if (warekiEntity.next()) {
						era = warekiEntity.getWarekiName();
						from = warekiEntity.getWarekiFrom();

						fromDate = Convert.toDate(from, Convert.FORMAT_YYYYMMDD);

						fromYear = DateUtl.getYear(fromDate);
					}

					inputWarekiYear = inputYear - fromYear + 1;

					result = era + (inputWarekiYear == 1 ? "元" : Convert.toString(inputWarekiYear)) + "年" + StringUtl.paddingLeft(inputMonth, "0", 2) + "月" + StringUtl.paddingLeft(inputDay, "0", 2) + "日";
				}
			}
		}
		finally {
			warekiEntity.close();
		}
		return result;
	}

	/**
	 * 西暦和暦変換.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piCon
	 *            DB接続
	 * @param piModelBase
	 *            Model
	 * @param piDateString
	 *            日付文字列
	 * @return 日付
	 * @throws SQLException
	 *             SQL例外
	 */
	public static String toDateYYYYMM(LACSCommonBean piCommonBean, Connection piCon, DBModelBase piModelBase, String piDateString) throws SQLException {
		String result = "";
		LACSWarekiEntity warekiEntity = new LACSWarekiEntity(piModelBase);

		try {
			if (piDateString != null && piDateString.trim().length() > 0) {
				if (piCommonBean.getDateMode().equals(LACSDefine.DateMode.SEIREKI)) {
					result = Convert.toString(Convert.toDate(piDateString, Convert.FORMAT_YYYYMMDD), Convert.FORMAT_YYYY_MM);
				}
				else {
					String from = "";

					Date fromDate = null;
					Date inputDate = null;

					int fromYear = 0;

					int inputWarekiYear = 0;
					int inputYear = 0;
					int inputMonth = 0;

					String era = "";

					inputDate = Convert.toDate(piDateString, Convert.FORMAT_YYYYMMDD);

					inputYear = DateUtl.getYear(inputDate);
					inputMonth = DateUtl.getMonth(inputDate);

					warekiEntity.setCon(piCon);
					warekiEntity.setTargetDate(piDateString);

					warekiEntity.execSQL();

					if (warekiEntity.next()) {
						era = warekiEntity.getWarekiName();
						from = warekiEntity.getWarekiFrom();

						fromDate = Convert.toDate(from, Convert.FORMAT_YYYYMMDD);

						fromYear = DateUtl.getYear(fromDate);
					}

					inputWarekiYear = inputYear - fromYear + 1;

					result = era + (inputWarekiYear == 1 ? "元" : Convert.toString(inputWarekiYear)) + "年" + StringUtl.paddingLeft(inputMonth, "0", 2) + "月";
				}
			}
		}
		finally {
			warekiEntity.close();
		}
		return result;
	}

	/**
	 * 西暦和暦変換.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piCon
	 *            DB接続
	 * @param piModelBase
	 *            Model
	 * @param piDateBean
	 *            日付文字列
	 * @return 日付
	 * @throws SQLException
	 *             SQL例外
	 */
	public static String toDateYYYYMMDD(LACSCommonBean piCommonBean, Connection piCon, DBModelBase piModelBase, LACSDateBean piDateBean) throws SQLException {
		String result = "";
		boolean check = true;
		LACSWarekiEntity warekiEntity = new LACSWarekiEntity(piModelBase);

		try {
			if (piDateBean != null && (piDateBean.getInputString1().trim().length() > 0 || piDateBean.getInputString2().trim().length() > 0 || piDateBean.getInputString3().trim().length() > 0)) {
				if (piCommonBean.getDateMode().equals(LACSDefine.DateMode.SEIREKI)) {
					result = StringUtl.formatNumber(piDateBean.getInputString1(), "0000") + StringUtl.formatNumber(piDateBean.getInputString2(), "00") + StringUtl.formatNumber(piDateBean.getInputString3(), "00");
				}
				else {
					String from = "";
					String to = "";

					Date fromDate = null;
					Date toDate = null;

					int fromYear = 0;
					int fromMonth = 0;

					int toYear = 0;
					int toMonth = 0;

					int warekiTerm = 0;

					int inputYear = Convert.toInt(piDateBean.getInputString1());
					int inputMonth = Convert.toInt(piDateBean.getInputString2());
					int inputDay = Convert.toInt(Command.init(piDateBean.getInputString3(), "1"));

					warekiEntity.setCon(piCon);

					warekiEntity.setWarekiCode(piDateBean.getEra().getValue());
					warekiEntity.execSQL();

					if (warekiEntity.next()) {
						from = warekiEntity.getWarekiFrom();
						to = warekiEntity.getWarekiTo();

						fromDate = Convert.toDate(from, Convert.FORMAT_YYYYMMDD);
						toDate = Convert.toDate(to, Convert.FORMAT_YYYYMMDD);

						fromYear = DateUtl.getYear(fromDate);
						fromMonth = DateUtl.getMonth(fromDate);

						toYear = DateUtl.getYear(toDate);
						toMonth = DateUtl.getMonth(toDate);
					}

					warekiTerm = toYear - fromYear + 1;

					if (warekiTerm < inputYear) {
						result = "";
						check = false;
					}

					if (inputMonth <= 0 || 12 < inputMonth) {
						result = "";
						check = false;
					}

					if (inputYear == 1 && inputMonth < fromMonth) {
						result = "";
						check = false;
					}

					if (inputYear == warekiTerm && inputMonth > toMonth) {
						result = "";
						check = false;
					}

					if (check) {

						result = "" + (fromYear + inputYear - 1) + "" + StringUtl.paddingLeft(inputMonth, "0", 2) + StringUtl.paddingLeft(inputDay, "0", 2);
					}
				}
			}
		}
		finally {
			warekiEntity.close();
		}
		return result;
	}

	/**
	 * 西暦和暦変換.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piCon
	 *            DB接続
	 * @param piModelBase
	 *            Model
	 * @param piDateString
	 *            日付文字列
	 * @param piDateBean
	 *            日付項目
	 * @throws SQLException
	 *             SQL例外
	 */
	public static void setDateField(LACSCommonBean piCommonBean, Connection piCon, DBModelBase piModelBase, String piDateString, LACSDateBean piDateBean) throws SQLException {
		LACSWarekiEntity warekiEntity = new LACSWarekiEntity(piModelBase);
		Date temp = null;

		try {
			if (piDateString != null && piDateString.trim().length() > 0) {
				if (piCommonBean.getDateMode().equals(LACSDefine.DateMode.SEIREKI)) {
					temp = Convert.toDate(piDateString, Convert.FORMAT_YYYYMMDD);

					piDateBean.setDate("", Convert.toString(DateUtl.getYear(temp)), Convert.toString(DateUtl.getMonth(temp)), Convert.toString(DateUtl.getDay(temp)));
					piDateBean.setYYYYMM(Convert.toString(DateUtl.getYear(temp)) + StringUtl.paddingLeft(DateUtl.getMonth(temp), "0", 2));
					piDateBean.setYYYYMMDD(Convert.toString(DateUtl.getYear(temp)) + StringUtl.paddingLeft(DateUtl.getMonth(temp), "0", 2) + StringUtl.paddingLeft(DateUtl.getDay(temp), "0", 2));
				}
				else {
					String from = "";

					Date fromDate = null;
					Date inputDate = null;

					int fromYear = 0;

					int inputWarekiYear = 0;
					int inputYear = 0;
					int inputMonth = 0;

					String era = "";

					inputDate = Convert.toDate(piDateString, Convert.FORMAT_YYYYMMDD);

					inputYear = DateUtl.getYear(inputDate);
					inputMonth = DateUtl.getMonth(inputDate);

					warekiEntity.setCon(piCon);
					warekiEntity.setTargetDate(piDateString);

					warekiEntity.execSQL();

					if (warekiEntity.next()) {
						era = warekiEntity.getWarekiCode();
						from = warekiEntity.getWarekiFrom();

						fromDate = Convert.toDate(from, Convert.FORMAT_YYYYMMDD);

						fromYear = DateUtl.getYear(fromDate);
					}

					inputWarekiYear = inputYear - fromYear + 1;

					piDateBean.setDate(era, Convert.toString(inputWarekiYear), StringUtl.formatNumber(inputMonth, "00"), StringUtl.formatNumber(DateUtl.getDay(inputDate), "00"));
					piDateBean.setYYYYMM(Convert.toString(inputWarekiYear) + StringUtl.formatNumber(inputMonth, "00"));
					piDateBean.setYYYYMMDD(Convert.toString(inputWarekiYear) + StringUtl.formatNumber(inputMonth, "00") + StringUtl.formatNumber(DateUtl.getDay(inputDate), "00"));
				}
			}
		}
		finally {
			warekiEntity.close();
		}
	}
}
