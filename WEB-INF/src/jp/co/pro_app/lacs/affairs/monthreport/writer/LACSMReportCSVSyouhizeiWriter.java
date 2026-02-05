package jp.co.pro_app.lacs.affairs.monthreport.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.affairs.monthreport.data.entity.LACSMReportSyouhizeiEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 月次帳票出力：消費税明細票Model.
 * 
 * @author yokota
 * @version 20081030
 */
public class LACSMReportCSVSyouhizeiWriter extends LACSMReportCSVWriterBase {

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
	public LACSMReportCSVSyouhizeiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
		LACSMReportSyouhizeiEntity reportEntity = new LACSMReportSyouhizeiEntity(super.model, this.commonBean, piReportBean);
		String fileName = "";

		File tmpFile = null; // 出力先ファイル
		String[] header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "リース会社", "開示先", "リース会計基準コード", "リース会計基準名称", "リース取引分類コード", "リース取引分類名称", "会計処理方法区分", "会計処理方法区分名称", "消費税一括控除区分", "消費税一括控除区分名称", "契約番号", "リース開始日", "リース終了日", "リース期間", "物件番号", "物件名", "中途解約日", "リース料総額", "うち保証残価", "消費税総額", "当期支払リース料", "当期仮払消費税額", "仮払消費税累計", "未払消費税残高", "未払消費税残高(うち１年内）", "未払消費税残高(うち１年超）" };
		String[] columns = new String[]{ "CREATE_DATE", "START_YMD", "END_YMD", "LEASE_COMPANY", "LEASE_USER", "TAISHO_AC_KIJYUN_CD", "TAISHO_AC_NM", "TRD_HNTE_KEKA_KBN", "LEASE_BUNRUI", "AC_SHR_KBN", "AC_SHR_KBN_NM", "STAX_IKT_KOJ_KBN", "STAX_IKT_KOJ_KBN_NM", "KEI_NO", "KNSHU_YMD", "MRYO_YMD", "KEI_TERM", "BKN_NO", "BKN_NM", "KAI_YMD", "KEI_AMT", "ZANK_HSHO_AMT", "KEI_AMT_STAX", "LAMT", "LAMT_STAX", "LAMT_STAX_RUI", "MIBARI_STAX_ZAN", "MIBARI_STAX_ZAN_1NAI", "MIBARI_STAX_ZAN_1CYO" };

		try {
			reportEntity.setCon(super.con);

			if (reportEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			tmpFile = File.createTempFile("csv16_", ".csv", scratchDirectory);
			reportEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			reportEntity.close();
		}

		return fileName;

	}
}
