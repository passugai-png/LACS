package jp.co.pro_app.lacs.affairs.common.command;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSDateBean;
import jp.co.pro_app.lacs.affairs.top.data.entity.LACSWarekiEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.CheckUtl;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.command.StringUtl;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 入力チェック部品.
 * 
 * @author katoken
 * @version 20070806
 */
public class LACSCheckUtl extends LACSCheckUtlBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piMessage
	 *            メッセージ
	 */
	public LACSCheckUtl(LACSMessage piMessage) {
		super(piMessage);
	}

	/**
	 * 日付チェック.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piCon
	 *            DB接続
	 * @param piModelBase
	 *            Model
	 * @param piName
	 *            項目名
	 * @param piDateBean
	 *            日付オブジェクト
	 * @param piMandatory
	 *            必須・非必須
	 * @return 判定結果
	 * @throws SQLException
	 *             SQL例外
	 */
	public boolean checkDate(LACSCommonBean piCommonBean, Connection piCon, DBModelBase piModelBase, String piName, LACSDateBean piDateBean, boolean piMandatory) throws SQLException {
		boolean result = true;
		LACSWarekiEntity warekiEntity = new LACSWarekiEntity(piModelBase);

		String yyyymm = "";
		String yyyymmdd = "";

		try {
			if (piCommonBean.getDateMode().equals(LACSDefine.DateMode.SEIREKI)) {
				yyyymmdd = piDateBean.getInputString1().replaceAll("/", "");

				if (yyyymmdd.trim().length() == 0) {
					if (piMandatory) {
						this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_MANDATORY, piName);
						result = false;
					}
				}
				else {
					if (yyyymmdd.length() == 6) {
						yyyymmdd += "01";
					}

					if (!CheckUtl.isDate(yyyymmdd)) {
						this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_INVALID_DATE, piName);
						result = false;
					}

					else {
						yyyymm = yyyymmdd.substring(0, 6);
					}

				}
			}
			else {
				if (piDateBean.getEra().getValue().trim().length() > 0 || piDateBean.getInputString1().trim().length() > 0 || piDateBean.getInputString2().trim().length() > 0) {
					if (piDateBean.getEra().getValue().trim().length() == 0 || piDateBean.getInputString1().trim().length() == 0 || piDateBean.getInputString2().trim().length() == 0) {
						this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_INVALID_DATE, piName);
						result = false;
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
							this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_INVALID_DATE, piName);
							result = false;
						}

						if (result && (inputMonth <= 0 || 12 < inputMonth)) {
							this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_INVALID_DATE, piName);
							result = false;
						}

						if (result && inputYear == 1 && inputMonth < fromMonth) {
							this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_INVALID_DATE, piName);
							result = false;
						}

						if (result && inputYear == warekiTerm && inputMonth > toMonth) {
							this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_INVALID_DATE, piName);
							result = false;
						}

						if (result) {
							yyyymm = "" + (fromYear + inputYear - 1) + "" + StringUtl.paddingLeft(inputMonth, "0", 2);
							yyyymmdd = yyyymm + StringUtl.paddingLeft(inputDay, "0", 2);
						}
					}
				}
			}

			if (result) {
				piDateBean.setYYYYMM(yyyymm);
				piDateBean.setYYYYMMDD(yyyymmdd);
			}

			piDateBean.setCheckResult(result);
		}
		finally {
			warekiEntity.close();
		}
		return result;
	}

	/**
	 * 日付順チェック.
	 * 
	 * @param piName
	 *            項目名
	 * @param piDateFrom
	 *            開始日付オブジェクト
	 * @param piDateTo
	 *            終了日付オブジェクト
	 * @return 判定結果
	 */
	public boolean checkDateOrder(String piName, LACSDateBean piDateFrom, LACSDateBean piDateTo) {
		boolean result = true;

		if (piDateFrom.isCheckResult() && piDateTo.isCheckResult()) {
			String dateFrom = Command.init(piDateFrom.getInputString1(), "");
			String dateTo = Command.init(piDateTo.getInputString1(), "");

			if (dateFrom.trim().length() > 0 && dateTo.trim().length() > 0) {
				if (dateFrom.compareTo(dateTo) > 0) {
					this.message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_COMBINATION, piName);
					result = false;
				}
			}
		}

		return result;
	}
}
