package jp.co.pro_app.lacs.affairs.syousai.writer;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;

/**
 * 契約詳細帳票出力：CSV作成Modelスーパークラス.
 * 
 * @author yokota
 * @version 20081017
 */
public abstract class LACSReportCSVWriterBase {

	/**
	 * Modelクラス.
	 */
	protected LACSModelBase			model			= null;

	/**
	 * CSV出力先.
	 */
	protected static final String	SCRATCH_PATH	= "csv";

	/**
	 * CSV出力先オブジェクト .
	 */
	protected File					scratchDirectory;

	/**
	 * LACS用共通Bean.
	 */
	protected LACSCommonBean		commonBean;

	/**
	 * DB接続.
	 */
	protected Connection			con				= null;

	/**
	 * コンストラクタ.
	 * 
	 * @param piCommonBean
	 *            LACS用共通Bean
	 * @param piModel
	 *            モデルクラス
	 * @param piCon
	 *            DB接続
	 */
	public LACSReportCSVWriterBase(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		this.commonBean = piCommonBean;
		this.model = piModel;
		this.con = piCon;
	}

	/**
	 * CSV作成.
	 * 
	 * @param piSyousaiBean
	 *            契約詳細Bean
	 * @param piDateMode
	 *            西暦和暦モード
	 * @param piContext
	 *            ServletContext
	 * @return PDFファイル名
	 * @exception Exception
	 *                実行例外
	 */
	protected abstract String makeCSV(LACSSyousaiBean piSyousaiBean, String piDateMode, ServletContext piContext) throws Exception;

	/**
	 * 西暦和暦変換(yyyy年MM月dd日、eeeyy年MM月dd日 形式).
	 * 
	 * @param piDateString
	 *            日付文字列
	 * @param piDateMode
	 *            西暦和暦モード
	 * @return 日付
	 * @throws SQLException
	 *             SQL例外
	 */
	protected String convertRekiLong(String piDateString, String piDateMode) throws SQLException {
		String result = "";
		String dateString = piDateString.replaceAll("/", "");

		if (piDateMode.equals(LACSDefine.DateMode.SEIREKI)) {
			result = Convert.toString(Convert.toDate(Convert.toDateString(dateString)), Convert.FORMAT_YYYY_MM_DD_JP);
		}
		else {
			result = piDateString == null ? "" : LACSCommand.toDateYYYYMMDD(this.commonBean, this.con, this.model, dateString, piDateMode);
		}

		return result;
	}

	/**
	 * 西暦和暦変換(yyyy/MM/dd、eyy/MM/dd 形式).
	 * 
	 * @param piDateString
	 *            日付文字列
	 * @param piDateMode
	 *            西暦和暦モード
	 * @return 日付
	 * @throws SQLException
	 *             SQL例外
	 */
	protected String convertReki(String piDateString, String piDateMode) throws SQLException {
		String result = piDateString == null ? "" : LACSCommand.toDateYYYYMMDD(this.commonBean, this.con, this.model, piDateString.replaceAll("/", ""), piDateMode);

		result = result.replaceAll("昭和", "S");
		result = result.replaceAll("平成", "H");
		result = result.replaceAll("元", "1");
		result = result.replaceAll("年", "/");
		result = result.replaceAll("月", "/");
		result = result.replaceAll("日", "");

		return result;
	}

}
