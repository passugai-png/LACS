package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportGenkaEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 帳票出力：リース会計資料（減価償却費）Model.
 * 
 * @author katoken
 * @version 20080328
 */
public class LACSReportCSVGenkaWriter extends LACSReportCSVWriterBase {

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
	public LACSReportCSVGenkaWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
	public String makeCSV(LACSReportBean piReportBean, String piDateMode, ServletContext piContext) throws Exception {
		LACSReportGenkaEntity reportEntity = new LACSReportGenkaEntity(super.model, this.commonBean, piReportBean, acStd);
		String fileName = "";

		File tmpFile = null; // 出力先ファイル
		// 2020/05/22 REP START
		//String[] header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "リース会社", "開示先", "リース取引分類コード", "リース取引分類名称", "会計処理方法コード", "会計処理方法名称", "固定資産科目コード", "固定資産科目名称", "減価償却方法コード", "減価償却方法名称", "契約番号", "リース開始日", "リース終了日", "物件番号", "物件名", "中途解約日", "リース期間", "耐用年数", "取得価格相当額", "うち残価保証額", "当期減価償却費相当額", "減価償却累計額相当額", "期末残高相当額", "割引計算利子率" };
		//String[] columns = new String[]{ "CREATE_DATE", "START_YMD", "END_YMD", "LEASE_COMPANY", "LEASE_USER", "TRD_HNTE_KEKA_KBN", "LEASE_BUNRUI", "AC_SHR_KBN", "AC_SHR_KBN_NM", "SSN_SRI_CD", "SSN_SRI_NM", "SKK_KEIJ_HOHO_KBN", "SKK_HOHO_NM", "KEI_NO", "KNSHU_YMD", "MRYO_YMD", "BKN_NO", "BKN_NM", "KAI_YMD", "KEI_TERM", "TY_YSU", "KNU_AMT", "ZANK_HSHO_AMT", "TGTU_SKK_AMT", "RUI_SKK_AMT", "ZAND_SKK_AMT", "WRBK_CLC_RS_RT" };
		String[] header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "リース会社", "重要性有無", "開示先", "リース取引分類コード", "リース取引分類名称", "会計処理方法コード", "会計処理方法名称", "固定資産科目コード", "固定資産科目名称", "減価償却方法コード", "減価償却方法名称", "契約番号", "リース開始日", "リース終了日", "物件番号", "物件名", "中途解約日", "リース期間", "取得価格相当額", "うち残価保証額", "当期減価償却費相当額", "減価償却累計額相当額", "期末残高相当額", "割引計算利子率" };
		String[] columns = new String[]{ "CREATE_DATE", "START_YMD", "END_YMD", "LEASE_COMPANY", "JYSI_UM", "LEASE_USER", "TRD_HNTE_KEKA_KBN", "LEASE_BUNRUI", "AC_SHR_KBN", "AC_SHR_KBN_NM", "SSN_SRI_CD", "SSN_SRI_NM", "SKK_KEIJ_HOHO_KBN", "SKK_HOHO_NM", "KEI_NO", "KNSHU_YMD", "MRYO_YMD", "BKN_NO", "BKN_NM", "KAI_YMD", "KEI_TERM", "KNU_AMT", "ZANK_HSHO_AMT", "TGTU_SKK_AMT", "RUI_SKK_AMT", "ZAND_SKK_AMT", "WRBK_CLC_RS_RT" };
		// 2020/05/22 REP END

		try {
			reportEntity.setCon(super.con);

			if (reportEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			tmpFile = File.createTempFile("csv02_" + prefix + "_", ".csv", scratchDirectory);

			reportEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			reportEntity.close();
		}

		return fileName;

	}
}
