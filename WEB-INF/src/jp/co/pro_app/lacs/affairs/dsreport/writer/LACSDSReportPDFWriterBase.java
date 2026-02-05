package jp.co.pro_app.lacs.affairs.dsreport.writer;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.dsreport.bean.LACSDSReportBean;
import jp.co.pro_app.lacs.common.model.LACSModelBase;

/**
 * 帳票出力：PDF作成Modelスーパークラス.
 * 
 * @author takeda
 * @version 20070824
 */
public abstract class LACSDSReportPDFWriterBase {

	/**
	 * Modelクラス.
	 */
	protected LACSModelBase			model			= null;

	/**
	 * PDF出力先.
	 */
	protected static final String	SCRATCH_PATH	= "out_pdf";

	/**
	 * フォームディレクトリ.
	 */
	protected static final String	FORM_PATH		= "form";

	/**
	 * PDF出力先オブジェクト .
	 */
	protected File					scratchDirectory;

	/**
	 * フォームディレクトリオブジェクト .
	 */
	protected File					formDirectory;

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
	public LACSDSReportPDFWriterBase(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		this.commonBean = piCommonBean;
		this.model = piModel;
		this.con = piCon;
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSDSReportBean piReportBean) throws Exception {
		return;
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 */
	protected void initSub(LACSDSReportBean piReportBean) {
		return;
	}

	/**
	 * 出力データ取得.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected abstract void getData(LACSDSReportBean piReportBean) throws SQLException;

	/**
	 * PDF作成.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @param piContext
	 *            ServletContext
	 * @return PDFファイル名
	 * @exception Exception
	 *                実行例外
	 */
	public abstract String makePDF(LACSDSReportBean piReportBean, ServletContext piContext) throws Exception;
}
