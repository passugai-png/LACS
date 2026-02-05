package jp.co.pro_app.lacs.affairs.ukebarai.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.common.model.LACSModelBase;

/**
 * 受払合計表：PDF作成Modelスーパークラス.
 * 
 * @author active
 * @version 20080812
 */
public abstract class LACSUkebaraiPDFWriterBase extends LACSUkebaraiWriterBase {

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
	 * コンストラクタ.
	 * 
	 * @param piCommonBean
	 *            LACS用共通Bean
	 * @param piModel
	 *            モデルクラス
	 * @param piCon
	 *            DB接続
	 */
	public LACSUkebaraiPDFWriterBase(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
	}

	/**
	 * PDF作成.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計Bean
	 * @param piContext
	 *            ServletContext
	 * @return PDFファイル名
	 * @exception Exception
	 *                実行例外
	 */
	public abstract String makePDF(LACSUkebaraiBean piUkebaraiBean, ServletContext piContext) throws Exception;

}
