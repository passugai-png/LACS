package jp.co.pro_app.lacs.affairs.ukebarai.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.affairs.ukebarai.data.entity.LACSUkebaraiHiyoEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 受払合計表：費用受払表CSV出力.
 * 
 * @author active
 * @version 20080816
 */
public class LACSUkebaraiCSVHiyoWriter extends LACSUkebaraiCSVWriterBase {

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
	public LACSUkebaraiCSVHiyoWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
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
	public String makeCSV(LACSUkebaraiBean piReportBean, ServletContext piContext) throws Exception {
		LACSUkebaraiHiyoEntity reportEntity = new LACSUkebaraiHiyoEntity(super.model, this.commonBean, piReportBean);
		String fileName = "";

		File tmpFile = null; // 出力先ファイル
		String[] header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "リース会社", "開示先", "リース会計基準コード", "リース会計基準名称", "リース取引分類コード", "リース取引分類名称", "会計処理方法コード", "会計処理方法名称", "科目コード", "科目名称", "契約番号", "物件番号", "物件名", "リース開始日", "リース終了日", "中途解約日", "総額", "前期末累計額", "当期計上高", "当期減少", "当期末累計額" };

		String[] columns = new String[]{ "CREATE_DATE", "KIKAN_START", "KIKAN_END", "LC_NM", "LU_NM", "TAISHO_AC_KIJYUN_CD", "TAISHO_AC_KIJYUN_NM", "TRD_HNTE_KEKA_KBN", "TRD_HNTE_KEKA_NM", "CTSHK_FLG", "AC_SHR_NM", "KAMOKU_CD", "KAMOKU_NM", "KEI_NO", "BKN_NO", "BKN_NM", "KNSHU_YMD", "MRYO_YMD", "KAI_YMD", "SOUGAKU_AMT", "ZENKI_MATU_AMT", "TOUKI_AMT", "TOUKI_GEN_AMT", "TOUKI_MATU_AMT" };
		try {
			reportEntity.setCon(super.con);

			if (reportEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			tmpFile = File.createTempFile("csv24_", ".csv", scratchDirectory);

			reportEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			reportEntity.close();
		}

		return fileName;

	}
}
