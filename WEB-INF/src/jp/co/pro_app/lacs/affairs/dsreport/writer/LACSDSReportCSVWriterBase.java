package jp.co.pro_app.lacs.affairs.dsreport.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.dsreport.bean.LACSDSReportBean;
import jp.co.pro_app.lacs.common.model.LACSModelBase;

/**
 * 帳票出力：PDF作成Modelスーパークラス.
 * 
 * @author katoken
 * @version 20080328
 */
public abstract class LACSDSReportCSVWriterBase {

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
	public LACSDSReportCSVWriterBase(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		this.commonBean = piCommonBean;
		this.model = piModel;
		this.con = piCon;
	}

	/**
	 * CSV作成.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @param piContext
	 *            ServletContext
	 * @return PDFファイル名
	 * @exception Exception
	 *                実行例外
	 */
	protected abstract String makeCSV(LACSDSReportBean piReportBean, ServletContext piContext) throws Exception;
}
