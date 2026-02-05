package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;

/**
 * 帳票出力：PDF作成Modelスーパークラス.
 * 
 * @author katoken
 * @version 20080328
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
	 * 対象会計基準.
	 */
	protected String				acStd			= "";

	/**
	 * 対象会計基準接頭辞.
	 */
	protected String				prefix			= "";

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
	 * @param piReportBean
	 *            帳票出力Bean
	 * @param piDateMode
	 *            西暦和暦モード
	 * @param piContext
	 *            ServletContext
	 * @return PDFファイル名
	 * @exception Exception
	 *                実行例外
	 */
	protected abstract String makeCSV(LACSReportBean piReportBean, String piDateMode, ServletContext piContext) throws Exception;

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

	/**
	 * 対象会計基準を設定.
	 * 
	 * @param piAcStd
	 *            対象会計基準
	 */
	public void setAcStd(String piAcStd) {
		this.acStd = piAcStd;
		this.prefix = acStd.equals(LACSDefine.AccountStandard.NEW_1) ? "new" : "old";
	}
}
