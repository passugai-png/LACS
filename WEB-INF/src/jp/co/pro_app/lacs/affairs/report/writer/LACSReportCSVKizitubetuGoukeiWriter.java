package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportKizitubetuGoukeiEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;

public class LACSReportCSVKizitubetuGoukeiWriter extends LACSReportCSVWriterBase {

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
	public LACSReportCSVKizitubetuGoukeiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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

		LACSReportKizitubetuGoukeiEntity reportEntity = new LACSReportKizitubetuGoukeiEntity(super.model, this.commonBean, piReportBean, acStd);
		
		String fileName = "";

		File tmpFile = null; // 出力先ファイル

		String[] header = new String[]{ "作成日", "基準日", "リース会社", "開示先", "重要性有無コード", "重要性有無名称", "リース取引分類コード", "リース取引分類名称", "会計処理方法コード", "会計処理方法名称", 				                        
                                        "未経過リース料(1年以内)", "残価保証額(1年以内)", "元本(1年以内)", "利息(1年以内)", "維持管理費(1年以内)", "役務提供費(1年以内)", "消費税等(1年以内)",
                                        "未経過リース料(2年以内)", "残価保証額(2年以内)", "元本(2年以内)", "利息(2年以内)", "維持管理費(2年以内)", "役務提供費(2年以内)", "消費税等(2年以内)",
                                        "未経過リース料(3年以内)", "残価保証額(3年以内)", "元本(3年以内)", "利息(3年以内)", "維持管理費(3年以内)", "役務提供費(3年以内)", "消費税等(3年以内)",
                                        "未経過リース料(4年以内)", "残価保証額(4年以内)", "元本(4年以内)", "利息(4年以内)", "維持管理費(4年以内)", "役務提供費(4年以内)", "消費税等(4年以内)",
                                        "未経過リース料(5年以内)", "残価保証額(5年以内)", "元本(5年以内)", "利息(5年以内)", "維持管理費(5年以内)", "役務提供費(5年以内)", "消費税等(5年以内)",
                                        "未経過リース料(5年超)", "残価保証額(5年超)", "元本(5年超)", "利息(5年超)", "維持管理費(5年超)", "役務提供費(5年超)", "消費税等(5年超)",		
                                        "未経過リース料(合計)", "残価保証額(合計)", "元本(合計)", "利息(合計)", "維持管理費(合計)", "役務提供費(合計)", "消費税等(合計)",
				                        "資産-有形取得価額(1年以内)", "資産-有形 減価償却累計額(1年以内)", "資産-有形 減価償却費(1年以内)", "資産-有形 簿価(1年以内)", 
				                        "資産-有形 取得価額(2年以内)", "資産-有形 減価償却累計額(2年以内)", "資産-有形 減価償却費(2年以内)", "資産-有形 簿価(2年以内)", 
				                        "資産-有形 取得価額(3年以内)", "資産-有形 減価償却累計額(3年以内)", "資産-有形 減価償却費(3年以内)", "資産-有形 簿価(3年以内)", 
				                        "資産-有形 取得価額(4年以内)", "資産-有形 減価償却累計額(4年以内)", "資産-有形 減価償却費(4年以内)", "資産-有形 簿価(4年以内)", 
				                        "資産-有形 取得価額(5年以内)", "資産-有形 減価償却累計額(5年以内)", "資産-有形 減価償却費(5年以内)", "資産-有形 簿価(5年以内)", 
				                        "資産-有形 取得価額(5年超)", "資産-有形 減価償却累計額(5年超)", "資産-有形 減価償却費(5年超)", "資産-有形 簿価(5年超)",
				                        "資産-有形 取得価額(合計)", "資産-有形 減価償却累計額(合計)", "資産-有形 減価償却費(合計)", "資産-有形 簿価(合計)",
				                        "資産-無形 取得価額(1年以内)", "資産-無形 減価償却累計額(1年以内)", "資産-無形 減価償却費(1年以内)", "資産-無形 簿価(1年以内)", 
				                        "資産-無形 取得価額(2年以内)", "資産-無形 減価償却累計額(2年以内)", "資産-無形 減価償却費(2年以内)", "資産-無形 簿価(2年以内)", 
				                        "資産-無形 取得価額(3年以内)", "資産-無形 減価償却累計額(3年以内)", "資産-無形 減価償却費(3年以内)", "資産-無形 簿価(3年以内)", 
				                        "資産-無形 取得価額(4年以内)", "資産-無形 減価償却累計額(4年以内)", "資産-無形 減価償却費(4年以内)", "資産-無形 簿価(4年以内)", 
				                        "資産-無形 取得価額(5年以内)", "資産-無形 減価償却累計額(5年以内)", "資産-無形 減価償却費(5年以内)", "資産-無形 簿価(5年以内)", 
				                        "資産-無形 取得価額(5年超)", "資産-無形 減価償却累計額(5年超)", "資産-無形 減価償却費(5年超)", "資産-無形 簿価(5年超)",
				                        "資産-無形 取得価額(合計)", "資産-無形 減価償却累計額(合計)", "資産-無形 減価償却費(合計)", "資産-無形 簿価(合計)"
		                              };
		
		String[] columns = new String[]{ "CREATE_DATE","KIJUN_DATE","LEASE_COMPANY","LU_NM","JYSI_UM_CD","JYSI_UM_NM","LEASE_BUNRUI_CD","LEASE_BUNRUI","AC_SHR_KBN","AC_SHR_NM"
										,"MIKEIKA_LEASE_ONE_YEAR","ZANK_HOSYOGAKU_ONE_YEAR","GNPN_ONE_YEAR","RSK_ONE_YEAR","IJI_KANRIHI_ONE_YEAR","EKM_TEIK_ONE_YEAR","LAMT_STAX_ONE_YEAR"
										,"MIKEIKA_LEASE_TWO_YEARS","ZANK_HOSYOGAKU_TWO_YEARS","GNPN_TWO_YEARS","RSK_TWO_YEARS","IJI_KANRIHI_TWO_YEARS","EKM_TEIK_TWO_YEARS","LAMT_STAX_TWO_YEARS"
										,"MIKEIKA_LEASE_THREE_YEARS","ZANK_HOSYOGAKU_THREE_YEARS","GNPN_THREE_YEARS","RSK_THREE_YEARS","IJI_KANRIHI_THREE_YEARS","EKM_TEIK_THREE_YEARS","LAMT_STAX_THREE_YEARS"
										,"MIKEIKA_LEASE_FOUR_YEARS","ZANK_HOSYOGAKU_FOUR_YEARS","GNPN_FOUR_YEARS","RSK_FOUR_YEARS","IJI_KANRIHI_FOUR_YEARS","EKM_TEIK_FOUR_YEARS","LAMT_STAX_FOUR_YEARS"
										,"MIKEIKA_LEASE_FIVE_YEARS","ZANK_HOSYOGAKU_FIVE_YEARS","GNPN_FIVE_YEARS","RSK_FIVE_YEARS","IJI_KANRIHI_FIVE_YEARS","EKM_TEIK_FIVE_YEARS","LAMT_STAX_FIVE_YEARS"
										,"MIKEIKA_LEASE_OVER_FIVE_YEARS","ZANK_HOSYOGAKU_OVER_FIVE_YEARS","GNPN_OVER_FIVE_YEARS","RSK_OVER_FIVE_YEARS","IJI_KANRIHI_OVER_FIVE_YEARS","EKM_TEIK_OVER_FIVE_YEARS","LAMT_STAX_OVER_FIVE_YEARS"
										,"MIKEIKA_LEASE_TOTAL","ZANK_HOSYOGAKU_TOTAL","GNPN_TOTAL","RSK_TOTAL","IJI_KANRIHI_TOTAL","EKM_TEIK_TOTAL","LAMT_STAX_TOTAL"
										,"FIRST_Y_KNU_AMT","FIRST_Y_GNK_RUI_AMT","FIRST_Y_GNK_SKK_AMT","FIRST_Y_BOKA_AMT"
										,"SECOND_Y_KNU_AMT","SECOND_Y_GNK_RUI_AMT","SECOND_Y_GNK_SKK_AMT","SECOND_Y_BOKA_AMT"
										,"THIRD_Y_KNU_AMT","THIRD_Y_GNK_RUI_AMT","THIRD_Y_GNK_SKK_AMT","THIRD_Y_BOKA_AMT"
										,"FOURTH_Y_KNU_AMT","FOURTH_Y_GNK_RUI_AMT","FOURTH_Y_GNK_SKK_AMT","FOURTH_Y_BOKA_AMT"
										,"FIFTH_Y_KNU_AMT","FIFTH_Y_GNK_RUI_AMT","FIFTH_Y_GNK_SKK_AMT","FIFTH_Y_BOKA_AMT"
										,"OVER_FIFTH_Y_KNU_AMT","OVER_FIFTH_Y_GNK_RUI_AMT","OVER_FIFTH_Y_GNK_SKK_AMT","OVER_FIFTH_Y_BOKA_AMT"
										,"TOTAL_Y_KNU_AMT","TOTAL_Y_GNK_RUI_AMT","TOTAL_Y_GNK_SKK_AMT","TOTAL_Y_BOKA_AMT"
										,"FIRST_M_KNU_AMT","FIRST_M_GNK_RUI_AMT","FIRST_M_GNK_SKK_AMT","FIRST_M_BOKA_AMT"
										,"SECOND_M_KNU_AMT","SECOND_M_GNK_RUI_AMT","SECOND_M_GNK_SKK_AMT","SECOND_M_BOKA_AMT"
										,"THIRD_M_KNU_AMT","THIRD_M_GNK_RUI_AMT","THIRD_M_GNK_SKK_AMT","THIRD_M_BOKA_AMT"
										,"FOURTH_M_KNU_AMT","FOURTH_M_GNK_RUI_AMT","FOURTH_M_GNK_SKK_AMT","FOURTH_M_BOKA_AMT"
										,"FIFTH_M_KNU_AMT","FIFTH_M_GNK_RUI_AMT","FIFTH_M_GNK_SKK_AMT","FIFTH_M_BOKA_AMT"
										,"OVER_FIFTH_M_KNU_AMT","OVER_FIFTH_M_GNK_RUI_AMT","OVER_FIFTH_M_GNK_SKK_AMT","OVER_FIFTH_M_BOKA_AMT"
										,"TOTAL_M_KNU_AMT","TOTAL_M_GNK_RUI_AMT","TOTAL_M_GNK_SKK_AMT","TOTAL_M_BOKA_AMT"
										};
		
		try {
			reportEntity.setCon(super.con);			

			if (reportEntity.execSQL() == 0 ) {
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

	
}
