package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportKizituSisanEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;
import jp.co.pro_app.projframe.common.model.DBModelBase;

public class LACSReportCSVKizitubetuSisanWriter extends LACSReportCSVWriterBase {

	@SuppressWarnings("unused")
	private DBModelBase	modelBase	= null;
	
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
	public LACSReportCSVKizitubetuSisanWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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

		LACSReportKizituSisanEntity reportEntity = new LACSReportKizituSisanEntity(super.model, this.commonBean, piReportBean, acStd);
		String fileName = "";

		File tmpFile = null; // 出力先ファイル

		String[] header = new String[]{ "作成日", "基準日", "リース会社", "開示先", "重要性有無コード", "重要性有無名称", "リース取引分類コード", "リース取引分類名称", "会計処理方法コード", "会計処理方法名称", "資産区分コード", "資産区分名称", "減価償却方法コード", "減価償却方法名称", "固定資産科目コード","固定資産科目名称", "契約番号","物件番号", "物件名",  "リース開始日", "リース終了日" ,"中途解約日", 
				                        "取得価額(1年以内)", "減価償却累計額(1年以内)", "減価償却費(1年以内)", "簿価(1年以内)", 
				                        "取得価額(2年以内)", "減価償却累計額(2年以内)", "減価償却費(2年以内)", "簿価(2年以内)", 
				                        "取得価額(3年以内)", "減価償却累計額(3年以内)", "減価償却費(3年以内)", "簿価(3年以内)", 
				                        "取得価額(4年以内)", "減価償却累計額(4年以内)", "減価償却費(4年以内)", "簿価(4年以内)", 
				                        "取得価額(5年以内)", "減価償却累計額(5年以内)", "減価償却費(5年以内)", "簿価(5年以内)", 
				                        "取得価額(5年超)", "減価償却累計額(5年超)", "減価償却費(5年超)", "簿価(5年超)",
				                        "取得価額(合計)", "減価償却累計額(合計)", "減価償却費(合計)", "簿価(合計)",
		                              };
		
		String[] columns = new String[]{ "CREATE_DATE", "END_YMD", "LEASE_COMPANY", "LU_NM", "JYSI_UM_CD", "JYSI_UM_NM", "LEASE_BUNRUI_CD", "LEASE_BUNRUI", "AC_SHR_KBN", "AC_SHR_NM", "YUKEI_MUKEI_KBN", "YUKEI_MUKEI_KBN_NM", "SKK_KEIJ_HOHO_KBN", "SKK_HOHO_NM", "SSN_SRI_CD","SSN_SRI_NM",  "KEI_NO","BKN_EDANO", "BKN_NM", "KNSHU_YMD", "MRYO_YMD","KAI_YMD", 
				                         "FIRST_KNU_AMT", "FIRST_GNK_RUI_AMT", "FIRST_GNK_SKK_AMT", "FIRST_BOKA_AMT", 
				                         "SECOND_KNU_AMT", "SECOND_GNK_RUI_AMT", "SECOND_GNK_SKK_AMT", "SECOND_BOKA_AMT", 
				                         "THIRD_KNU_AMT", "THIRD_GNK_RUI_AMT", "THIRD_GNK_SKK_AMT", "THIRD_BOKA_AMT", 
				                         "FOURTH_KNU_AMT", "FOURTH_GNK_RUI_AMT", "FOURTH_GNK_SKK_AMT", "FOURTH_BOKA_AMT", 
				                         "FIFTH_KNU_AMT", "FIFTH_GNK_RUI_AMT", "FIFTH_GNK_SKK_AMT", "FIFTH_BOKA_AMT", 
				                         "OVER_FIFTH_KNU_AMT", "OVER_FIFTH_GNK_RUI_AMT", "OVER_FIFTH_GNK_SKK_AMT", "OVER_FIFTH_BOKA_AMT",
				                         "TOTAL_KNU_AMT", "TOTAL_GNK_RUI_AMT", "TOTAL_GNK_SKK_AMT", "TOTAL_BOKA_AMT",
		                               };
		
		try {
			reportEntity.setCon(super.con);

			if (reportEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			tmpFile = File.createTempFile("csv11_" + prefix + "_", ".csv", scratchDirectory);

			reportEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			reportEntity.close();
		}
		
		return fileName;		
	}
	
	/**
	 * DBModelBase設定.
	 * 
	 * @param piModelBase
	 *            DBModelBase
	 */
	public void setModelBase(DBModelBase piModelBase) {
		this.modelBase = piModelBase;
	}

}
