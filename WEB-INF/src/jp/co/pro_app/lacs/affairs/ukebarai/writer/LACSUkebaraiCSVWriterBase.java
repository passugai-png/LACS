package jp.co.pro_app.lacs.affairs.ukebarai.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.common.model.LACSModelBase;

/**
 * 受払合計表：CSV作成Modelスーパークラス.
 * 
 * @author active
 * @version 20080812
 */
public abstract class LACSUkebaraiCSVWriterBase extends LACSUkebaraiWriterBase {

	/**
	 * CSV出力先.
	 */
	protected static final String	SCRATCH_PATH	= "csv";

	/**
	 * CSV出力先オブジェクト .
	 */
	protected File					scratchDirectory;

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
	public LACSUkebaraiCSVWriterBase(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
	}

	/**
	 * CSV作成.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @param piContext
	 *            ServletContext
	 * @return CSVファイル名
	 * @exception Exception
	 *                実行例外
	 */
	public abstract String makeCSV(LACSUkebaraiBean piUkebaraiBean, ServletContext piContext) throws Exception;

}
