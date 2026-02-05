package jp.co.pro_app.lacs.affairs.monthreport.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.affairs.monthreport.data.entity.LACSMReportRemoveAssertEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 月次帳票出力：除却資産一覧CSV出力.
 * 
 * @author yamaguchi
 * @version 20080409
 */
public class LACSMReportCSVRemoveAssertWriter extends LACSMReportCSVWriterBase {

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
	public LACSMReportCSVRemoveAssertWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
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
	public String makeCSV(LACSMReportBean piReportBean, String piDateMode, ServletContext piContext) throws Exception {
		LACSMReportRemoveAssertEntity reportEntity = new LACSMReportRemoveAssertEntity(super.model, this.commonBean, piReportBean);
		String fileName = "";

		File tmpFile = null; // 出力先ファイル

		String[] header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "リース会計基準名", "減価償却計上方法コード", "減価償却費総額", "減価償却期間", "減価償却費計算方法", "契約番号", "物件名", "物件番号", "リース開始日", "リース終了日", "中途解約日", "固定資産科目コード", "固定資産科目名称", "取得価格相当額", "償却期間・経過", "償却期間・総", "減価償却累計額相当額", "うち残価保証額", "解約/満了時簿価" };

		String[] columns = new String[]{ "CREATE_DATE", "START_YMD", "END_YMD", "AC_KIJYUN_NM", "SKK_KEIJ_HOHO_KBN", "SKK_AMT_NM", "SKK_TERM_NM", "SKK_HOHO_NM", "HYJYO_KEI_NO", "BKN_NM", "BKN_NO", "KNSHU_YMD", "MRYO_YMD", "KAI_YMD", "SSN_SRI_CD", "SSN_SRI_NM", "SOUGAKU", "KI", "SOU", "RUI_SKK_AMT", "ZANK_AMT", "ZAND_SKK_AMT" };

		try {
			reportEntity.setCon(super.con);

			if (reportEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			tmpFile = File.createTempFile("csv12_", ".csv", scratchDirectory);

			reportEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			reportEntity.close();
		}

		return fileName;

	}
}
