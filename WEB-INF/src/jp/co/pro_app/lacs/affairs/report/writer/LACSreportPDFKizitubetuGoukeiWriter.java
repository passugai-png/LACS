package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
//import java.util.Date;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportKizituTotalBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportKizitubetuGoukeiEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
//import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

public class LACSreportPDFKizitubetuGoukeiWriter extends LACSReportPDFWriterBase {

	private Report				        report					        = null;				    // WebKCoreレポートオブジェクト

	private LACSReportKizituTotalBean	detail					    = null;                 
		
	private long				        souPage					        = 0;					// 総ページ数

	private long				        page					        = 0;					// ページ

	@SuppressWarnings("unused")
	private int					        lineCount				        = 0;					// 明細カウンタ
	
	@SuppressWarnings("unused")
	private static final int	MAX_LINE	= 7; 
	
	private static final String	TITLE_NEW	= "期日別予定表（合計表） [新]";
	
	private static final String	TITLE_OLD	= "期日別予定表（合計表） [旧]";
	
	// LACS帳票バッチ対応 
	private FileOutputStream fout = null; // 出力ファイルストリーム

	private File tmpFile = null; // 出力先ファイル

	private boolean batchFlg = false; // バッチ実行フラグ 
	
	private boolean batchStartFlg = false; //　バッチ出力開始フラグ
	
	/**　バッチ実行フラグ を設定する
	 * 
	 */
	public void setBatchFlg(boolean batchFlg) {
		this.batchFlg = batchFlg;
	}
	
	/**　PDF出力を開始する
	 * @param piContext
	 * @throws Exception　
	 */
	public void startReport(ServletContext piContext) throws Exception {
		File wprlHomeDirectory = new File(PdfProperties.getInstance().getProperty(PdfProperties.WKC_PDF_HOME));	
		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		formDirectory = new File(wprlHomeDirectory, FORM_PATH);	
		tmpFile = File.createTempFile("pdf11_" + prefix + "_", ".pdf", scratchDirectory);
		fout = new FileOutputStream(tmpFile);
		File formFile = new File(formDirectory, "KijitsuGokei.pdf");
		File datFile = new File(formDirectory, "KijitsuGokei.dat");
		report = new Report(formFile, datFile, fout);
	}
	
	/**　作成したPDFファイルを返す
	 * @return　List<String> 作成したPDFファイル
	 */
	public String getFileName() {
		return tmpFile != null ? tmpFile.getName() : ""; 
	}
	
	/**
	　 * 　	PDF出力を終わらせる
	 */
	public void endReport() {
		if (batchStartFlg) {
			if (report != null) {
				try {
					report.close();
				}
				catch (ReportException e) {
				}
				report = null;
			}
			if (fout != null) {
				try {
					fout.close();
				}
				catch (Exception e) {
					fout = null;
				}
			}
		}
	}

	
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
	public LACSreportPDFKizitubetuGoukeiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
	}
	
	/**
	 * 出力データを取得.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	public void getData(LACSReportBean piReportBean) throws SQLException {
		
		LACSReportKizitubetuGoukeiEntity reportEntity = new LACSReportKizitubetuGoukeiEntity(super.model, commonBean, piReportBean, this.acStd);
		LACSReportKizituTotalBean GokeiDetail = null;
				

		try {
			
			reportEntity.setCon(super.con);
			piReportBean.setDataMax(reportEntity.execSQL());
			
			while(reportEntity.next()) {
				
				GokeiDetail = new LACSReportKizituTotalBean();
				piReportBean.addKizituGoukei(GokeiDetail);
												
				GokeiDetail.setCreateDate(reportEntity.getCreateDate());
				GokeiDetail.setKijunDate(reportEntity.getKijunDate());
				GokeiDetail.setLeaseCompany(reportEntity.getLeaseCompany());
				GokeiDetail.setKaizisaki(reportEntity.getKaizisaki());
				GokeiDetail.setJysiUm(reportEntity.getJysiUm());
				GokeiDetail.setLeaseBunrui(reportEntity.getLeaseBunrui());
				GokeiDetail.setKaikeiSyoriHouhou(reportEntity.getKaikeiSyori());
								
				// 期日別予定表(資産)を取得
				// 取得価額 有形
				GokeiDetail.setusyutokukagakuWithinOneYear(reportEntity.getYsyutokuKagakuWithinOneYear());
				GokeiDetail.setusyutokukagakuWithinTwoYear(reportEntity.getYsyutokuKagakuWithinTwoYears());
				GokeiDetail.setusyutokukagakuWithinThreeYear(reportEntity.getYsyutokuKagakuWithinThreeYears());
				GokeiDetail.setusyutokukagakuWithinFourYear(reportEntity.getYsyutokuKagakuWithinFourYears());
				GokeiDetail.setusyutokukagakuWithinFiveYear(reportEntity.getYsyutokuKagakuWithinFiveYears());
				GokeiDetail.setusyutokukagakuOverFiveYear(reportEntity.getYsyutokuKagakuWithinOverFiveYears());
				GokeiDetail.setusyutokukagakuTotal(reportEntity.getYsyutokuKagakuTotal());
				// 取得価額 無形
				GokeiDetail.setmsyutokukagakuWithinOneYear(reportEntity.getMsyutokuKagakuWithinOneYear());
				GokeiDetail.setmsyutokukagakuWithinTwoYear(reportEntity.getMsyutokuKagakuWithinTwoYears());
				GokeiDetail.setmsyutokukagakuWithinThreeYear(reportEntity.getMsyutokuKagakuWithinThreeYears());
				GokeiDetail.setmsyutokukagakuWithinFourYear(reportEntity.getMsyutokuKagakuWithinFourYears());
				GokeiDetail.setmsyutokukagakuWithinFiveYear(reportEntity.getMsyutokuKagakuWithinFiveYears());
				GokeiDetail.setmsyutokukagakuOverFiveYear(reportEntity.getMsyutokuKagakuWithinOverFiveYears());
				GokeiDetail.setmsyutokukagakuTotal(reportEntity.getMsyutokuKagakuTotal());
		
				// 減価償却累計額 有形
				GokeiDetail.setugenkaSyokyakuRuikeiWithinOneYear(reportEntity.getYgenkaRuikeiWithinOneYear());
				GokeiDetail.setugenkaSyokyakuRuikeiWithinTwoYear(reportEntity.getYgenkaRuikeiWithinTwoYears());
				GokeiDetail.setugenkaSyokyakuRuikeiWithinThreeYear(reportEntity.getYgenkaRuikeiWithinThreeYears());
				GokeiDetail.setugenkaSyokyakuRuikeiWithinFourYear(reportEntity.getYgenkaRuikeiWithinFourYears());
				GokeiDetail.setugenkaSyokyakuRuikeiWithinFiveYear(reportEntity.getYgenkaRuikeiWithinFiveYears());
				GokeiDetail.setugenkaSyokyakuRuikeiOverFiveYear(reportEntity.getYgenkaRuikeiWithinFiveYears());
				GokeiDetail.setugenkaSyokyakuRuikeiTotal(reportEntity.getYgenkaRuikeiTotal());
				// 減価償却累計額 無形
				GokeiDetail.setmgenkaSyokyakuRuikeiWithinOneYear(reportEntity.getMgenkaRuikeiWithinOneYear());
				GokeiDetail.setmgenkaSyokyakuRuikeiWithinTwoYear(reportEntity.getMgenkaRuikeiWithinTwoYears());
				GokeiDetail.setmgenkaSyokyakuRuikeiWithinThreeYear(reportEntity.getMgenkaRuikeiWithinThreeYears());
				GokeiDetail.setmgenkaSyokyakuRuikeiWithinFourYear(reportEntity.getMgenkaRuikeiWithinFourYears());
				GokeiDetail.setmgenkaSyokyakuRuikeiWithinFiveYear(reportEntity.getMgenkaRuikeiWithinFiveYears());
				GokeiDetail.setmgenkaSyokyakuRuikeiOverFiveYear(reportEntity.getMgenkaRuikeiWithinFiveYears());
				GokeiDetail.setmgenkaSyokyakuRuikeiTotal(reportEntity.getMgenkaRuikeiTotal());
				
				// 減価償却費 有形
				GokeiDetail.setugenkaSyokyahiWithinOneYear(reportEntity.getYgenkaSyokyakuWithinOneYear());
				GokeiDetail.setugenkaSyokyahiWithinTwoYear(reportEntity.getYgenkaSyokyakuWithinTwoYears());
				GokeiDetail.setugenkaSyokyahiWithinThreeYear(reportEntity.getYgenkaSyokyakuWithinThreeYears());
				GokeiDetail.setugenkaSyokyahiWithinFourYear(reportEntity.getYgenkaSyokyakuWithinFourYears());
				GokeiDetail.setugenkaSyokyahiWithinFiveYear(reportEntity.getYgenkaSyokyakuWithinFiveYears());				
				GokeiDetail.setugenkaSyokyahiOverFiveYear(reportEntity.getYgenkaSyokyakuOverFiveYears());
				GokeiDetail.setugenkaSyokyahi(reportEntity.getYgenkaSyokyakuTotal());
				// 減価償却費 無形
				GokeiDetail.setmgenkaSyokyahiWithinOneYear(reportEntity.getMgenkaSyokyakuWithinOneYear());
				GokeiDetail.setmgenkaSyokyahiWithinTwoYear(reportEntity.getMgenkaSyokyakuWithinTwoYears());
				GokeiDetail.setmgenkaSyokyahiWithinThreeYear(reportEntity.getMgenkaSyokyakuWithinThreeYears());
				GokeiDetail.setmgenkaSyokyahiWithinFourYear(reportEntity.getMgenkaSyokyakuWithinFourYears());
				GokeiDetail.setmgenkaSyokyahiWithinFiveYear(reportEntity.getMgenkaSyokyakuWithinFiveYears());				
				GokeiDetail.setmgenkaSyokyahiOverFiveYear(reportEntity.getMgenkaSyokyakuOverFiveYears());
				GokeiDetail.setmgenkaSyokyahi(reportEntity.getMgenkaSyokyakuTotal());
				            
				// 簿価　有形
				GokeiDetail.setubokaWithinOneYear(reportEntity.getYbokaWithinOneYear());
				GokeiDetail.setubokaWithinTwoYear(reportEntity.getYbokaWithinTwoYears());
				GokeiDetail.setubokaWithinThreeYear(reportEntity.getYbokaWithinThreeYears());
				GokeiDetail.setubokaWithinFourYear(reportEntity.getYbokaWithinFourYears());
				GokeiDetail.setubokaWithinFiveYear(reportEntity.getYbokaWithinFiveYears());
				GokeiDetail.setubokaOverFiveYear(reportEntity.getYbokaWithinOverFiveYears());
				GokeiDetail.setubokaTotal(reportEntity.getYbokaTotal());
				// 簿価　無形
				GokeiDetail.setmbokaWithinOneYear(reportEntity.getMbokaWithinOneYear());
				GokeiDetail.setmbokaWithinTwoYear(reportEntity.getMbokaWithinTwoYears());
				GokeiDetail.setmbokaWithinThreeYear(reportEntity.getMbokaWithinThreeYears());
				GokeiDetail.setmbokaWithinFourYear(reportEntity.getMbokaWithinFourYears());
				GokeiDetail.setmbokaWithinFiveYear(reportEntity.getMbokaWithinFiveYears());
				GokeiDetail.setmbokaOverFiveYear(reportEntity.getMbokaWithinOverFiveYears());
				GokeiDetail.setmbokaTotal(reportEntity.getMbokaTotal());
										
				// 期日別予定表(債務)を取得
				// 未経過リース料
				GokeiDetail.setMikeikaLeaseWithinOneYear(reportEntity.getMikeikaLeaseWithinOneYear());
				GokeiDetail.setMikeikaLeaseWithinTwoYears(reportEntity.getMikeikaLeaseWithinTwoYears());
				GokeiDetail.setMikeikaLeaseWithinThreeYears(reportEntity.getMikeikaLeaseWithinThreeYears());
				GokeiDetail.setMikeikaLeaseWithinFourYears(reportEntity.getMikeikaLeaseWithinFourYears());
				GokeiDetail.setMikeikaLeaseWithinFiveYears(reportEntity.getMikeikaLeaseWithinFiveYears());
				GokeiDetail.setMikeikaLeaseOverFiveYears(reportEntity.getMikeikaLeaseOverFiveYears());
				GokeiDetail.setMikeikaLeaseTotal(reportEntity.getMikeikaLeaseTotal());
				
				// 残価保証額
				GokeiDetail.setZankaHosyogakuWithinOneYear(reportEntity.getZankaHosyogakuWithinOneYear());
				GokeiDetail.setZankaHosyogakuWithinTwoYears(reportEntity.getZankaHosyogakuWithinTwoYears());
				GokeiDetail.setZankaHosyogakuWithinThreeYears(reportEntity.getZankaHosyogakuWithinThreeYears());
				GokeiDetail.setZankaHosyogakuWithinFourYears(reportEntity.getZankaHosyogakuWithinFourYears());
				GokeiDetail.setZankaHosyogakuWithinFiveYears(reportEntity.getZankaHosyogakuWithinFiveYears());
				GokeiDetail.setZankaHosyogakuOverFiveYears(reportEntity.getZankaHosyogakuOverFiveYears());
				GokeiDetail.setZankaHosyogakuTotal(reportEntity.getZankaHosyogakuTotal());
				
				// 元本
				GokeiDetail.setGanponWithinOneYear(reportEntity.getGanponWithinOneYear());
				GokeiDetail.setGanponWithinTwoYears(reportEntity.getGanponWithinTwoYears());
				GokeiDetail.setGanponWithinThreeYears(reportEntity.getGanponWithinThreeYears());
				GokeiDetail.setGanponWithinFourYears(reportEntity.getGanponWithinFourYears());
				GokeiDetail.setGanponWithinFiveYears(reportEntity.getGanponWithinFiveYears());
				GokeiDetail.setGanponOverFiveYears(reportEntity.getGanponOverFiveYears());
				GokeiDetail.setGanponTotal(reportEntity.getGanponTotal());
				
				// 利息
				GokeiDetail.setRisokuWithinOneYear(reportEntity.getRisokuWithinOneYear());
				GokeiDetail.setRisokuWithinTwoYear(reportEntity.getRisokuWithinTwoYears());
				GokeiDetail.setRisokuWithinThreeYears(reportEntity.getRisokuWithinThreeYears());
				GokeiDetail.setRisokuWithinFourYears(reportEntity.getRisokuWithinFourYears());
				GokeiDetail.setRisokuWithinFiveYears(reportEntity.getRisokuWithinFiveYears());
				GokeiDetail.setRisokuOverFiveYears(reportEntity.getRisokuOverFiveYears());
				GokeiDetail.setRisokuTotal(reportEntity.getRisokuTotal());
				
				// 維持管理費
				GokeiDetail.setIzikanrihiWithinOneYear(reportEntity.getIjiKanrihiWithinOneYear());
				GokeiDetail.setIzikanrihiWithinTwoYears(reportEntity.getIjiKanrihiWithinTwoYears());
				GokeiDetail.setIzikanrihiWithinThreeYears(reportEntity.getIjiKanrihiWithinThreeYears());
				GokeiDetail.setIzikanrihiWithinFourYears(reportEntity.getIjiKanrihiWithinFourYears());
				GokeiDetail.setIzikanrihiWithinFiveYears(reportEntity.getIjiKanrihiWithinFiveYears());
				GokeiDetail.setIzikanrihiOverFiveYears(reportEntity.getIjiKanrihiOverFiveYears());
				GokeiDetail.setIzikanrihiTotal(reportEntity.getIjiKanrihiTotal());
				
				// 役務提供費
				GokeiDetail.setEkimuteikyouhiWithinOneYear(reportEntity.getEkimuteikiWithinOneYear());
				GokeiDetail.setEkimuteikyouhiWithinTwoYear(reportEntity.getEkimuteikiWithinTwoYears());
				GokeiDetail.setEkimuteikyouhiWithinThreeYears(reportEntity.getEkimuteikiWithinThreeYears());
				GokeiDetail.setEkimuteikyouhiWithinFourYears(reportEntity.getEkimuteikiWithinFourYears());
				GokeiDetail.setEkimuteikyouhiWithinFiveYears(reportEntity.getEkimuteikiWithinFiveYears());
				GokeiDetail.setEkimuteikyouhiOverFiveYears(reportEntity.getEkimuteikiOverFiveYears());
				GokeiDetail.setEkimuteikyouhiTotal(reportEntity.getEkimuteikiTotal());
				
				// 消費税等
				GokeiDetail.setSyohizeiWithinOneYear(reportEntity.getSyohizeiWithinOneYear());
				GokeiDetail.setSyohizeiWithinTwoYears(reportEntity.getSyohizeiWithinTwoYears());
				GokeiDetail.setSyohizeiWithinThreeYears(reportEntity.getSyohizeiWithinThreeYears());
				GokeiDetail.setSyohizeiWithinFourYears(reportEntity.getSyohizeiWithinFourYears());
				GokeiDetail.setSyohizeiWithinFiveYears(reportEntity.getSyohizeiWithinFiveYears());
				GokeiDetail.setSyohizeiOverFiveYears(reportEntity.getSyohizeiOverFiveYears());
				GokeiDetail.setSyohizeiTotal(reportEntity.getSyohizeiTotal());
			} 
	
						 
					
		}finally {
				reportEntity.close();
		}
	}
	
	/**
	 * PDF作成.
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
	public String makePDF(LACSReportBean piReportBean, String piDateMode, ServletContext piContext) throws Exception {
		
		File wprlHomeDirectory = new File(PdfProperties.getInstance().getProperty(PdfProperties.WKC_PDF_HOME));
		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		formDirectory = new File(wprlHomeDirectory, FORM_PATH);

		//File tmpFile = null; // 出力先ファイル
		//FileOutputStream fout = null; // 出力ファイルストリーム
		//report = null; // WebKCoreレポートオブジェクト
		detail = null;
		souPage = 0; // 総ページ数
		page = 0; // ページ
		lineCount = 0; // 明細カウンタ
		
		Field field = null;
		try {
			// LACS帳票バッチ対応
			if(!batchFlg) {
				
				scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
				formDirectory = new File(wprlHomeDirectory, FORM_PATH);
				tmpFile = File.createTempFile("pdf09_" + prefix + "_", ".pdf", scratchDirectory);
				fout = new FileOutputStream(tmpFile);
				File formFile = new File(formDirectory, "KijitsuGokei.pdf");
				File datFile = new File(formDirectory, "KijitsuGokei.dat");
				report = new Report(formFile, datFile, fout);
				
			}
		
			// LACS帳票バッチ出力対応
			if (batchFlg && !batchStartFlg) {
				this.startReport(piContext);
				batchStartFlg =true;
			}		
			
			//tmpFile = File.createTempFile("pdf09_" + prefix + "_", ".pdf", scratchDirectory);
			//fout = new FileOutputStream(tmpFile);
			//File formFile = new File(formDirectory, "KijitsuGokei.pdf");
			//File datFile = new File(formDirectory, "KijitsuGokei.dat");
			//report = new Report(formFile, datFile, fout);

			// 総ページ数を取得
			souPage = piReportBean.getDataMax();
//            for (int i = 0; i < piReportBean.getDataMax(); i++) {
//								
//				if (lineCount > MAX_LINE) {
//					souPage++; 
//					lineCount = 0;
//				}
//				
//				lineCount++;				
//           }    
			
//            lineCount = 0;
						
			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				
				detail = piReportBean.getKizituGoukei(i);
								
				headPrint(piReportBean, piDateMode);
				
				field = report.getField("xMikeika1");
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaLeaseWithinOneYear()));
			
				field = report.getField("xMikeika2");
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaLeaseWithinTwoYears()));
					
				field = report.getField("xMikeika3");
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaLeaseWithinThreeYears()));
				
				field = report.getField("xMikeika4");
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaLeaseWithinFourYears()));
					
				field = report.getField("xMikeika5");
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaLeaseWithinFiveYears()));
					
				field = report.getField("xMikeika6");
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaLeaseOverFiveYears()));
					
				field = report.getField("xMikeika7");
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaLeaseTotal()));

				field = report.getField("xZank1");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankaHosyogakuWithinOneYear()));
				
				field = report.getField("xZank2");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankaHosyogakuWithinTwoYears()));
				
				field = report.getField("xZank3");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankaHosyogakuWithinThreeYears()));
				
				field = report.getField("xZank4");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankaHosyogakuWithinFourYears()));
				
				field = report.getField("xZank5");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankaHosyogakuWithinFiveYears()));
				
				field = report.getField("xZank6");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankaHosyogakuOverFiveYears()));
				
				field = report.getField("xZank7");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankaHosyogakuTotal()));																			

				field = report.getField("xGnpn1");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGanponWithinOneYear()));
				
				field = report.getField("xGnpn2");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGanponWithinTwoYears()));
				
				field = report.getField("xGnpn3");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGanponWithinThreeYears()));
				
				field = report.getField("xGnpn4");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGanponWithinFourYears()));
				
				field = report.getField("xGnpn5");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGanponWithinFiveYears()));
				
				field = report.getField("xGnpn6");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGanponOverFiveYears()));
				
				field = report.getField("xGnpn7");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGanponTotal()));
					
				field = report.getField("xRsk1");
				report.putFieldData(field, StringUtl.formatNumber(detail.getRisokuWithinOneYear()));
				
				field = report.getField("xRsk2");
				report.putFieldData(field, StringUtl.formatNumber(detail.getRisokuWithinTwoYears()));
				
				field = report.getField("xRsk3");
				report.putFieldData(field, StringUtl.formatNumber(detail.getRisokuWithinThreeYears()));
				
				field = report.getField("xRsk4");
				report.putFieldData(field, StringUtl.formatNumber(detail.getRisokuWithinFourYears()));
				
				field = report.getField("xRsk5");
				report.putFieldData(field, StringUtl.formatNumber(detail.getRisokuWithinFiveYears()));
				
				field = report.getField("xRsk6");
				report.putFieldData(field, StringUtl.formatNumber(detail.getRisokuOverFiveYears()));
				
				field = report.getField("xRsk7");
				report.putFieldData(field, StringUtl.formatNumber(detail.getRisokuTotal()));
					
				field = report.getField("xIji1");
				report.putFieldData(field, StringUtl.formatNumber(detail.getIzikanrihiWithinOneYear()));
				
				field = report.getField("xIji2");
				report.putFieldData(field, StringUtl.formatNumber(detail.getIzikanrihiWithinTwoYears()));
				
				field = report.getField("xIji3");
				report.putFieldData(field, StringUtl.formatNumber(detail.getIzikanrihiWithinThreeYears()));
				
				field = report.getField("xIji4");
				report.putFieldData(field, StringUtl.formatNumber(detail.getIzikanrihiWithinFourYears()));
				
				field = report.getField("xIji5");
				report.putFieldData(field, StringUtl.formatNumber(detail.getIzikanrihiWithinFiveYears()));
				
				field = report.getField("xIji6");
				report.putFieldData(field, StringUtl.formatNumber(detail.getIzikanrihiOverFiveYears()));
				
				field = report.getField("xIji7");
				report.putFieldData(field, StringUtl.formatNumber(detail.getIzikanrihiTotal()));

				field = report.getField("xEkim1");
				report.putFieldData(field, StringUtl.formatNumber(detail.getEkimuteikyouhiWithinOneYear()));
				
				field = report.getField("xEkim2");
				report.putFieldData(field, StringUtl.formatNumber(detail.getEkimuteikyouhiWithinTwoYears()));
				
				field = report.getField("xEkim3");
				report.putFieldData(field, StringUtl.formatNumber(detail.getEkimuteikyouhiWithinThreeYears()));
				
				field = report.getField("xEkim4");
				report.putFieldData(field, StringUtl.formatNumber(detail.getEkimuteikyouhiWithinFourYears()));
				
				field = report.getField("xEkim5");
				report.putFieldData(field, StringUtl.formatNumber(detail.getEkimuteikyouhiWithinFiveYears()));
				
				field = report.getField("xEkim6");
				report.putFieldData(field, StringUtl.formatNumber(detail.getEkimuteikyouhiOverFiveYears()));
				
				field = report.getField("xEkim7");
				report.putFieldData(field, StringUtl.formatNumber(detail.getEkimuteikyouhiTotal()));
						
				field = report.getField("xStax1");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyohizeiWithinOneYear()));
				
				field = report.getField("xStax2");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyohizeiWithinTwoYears()));
				
				field = report.getField("xStax3");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyohizeiWithinThreeYears()));
				
				field = report.getField("xStax4");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyohizeiWithinFourYears()));
				
				field = report.getField("xStax5");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyohizeiWithinFiveYears()));
				
				field = report.getField("xStax6");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyohizeiOverFiveYears()));
				
				field = report.getField("xStax7");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyohizeiTotal()));
								
				field = report.getField("xYGetprc1");
				report.putFieldData(field, detail.getusyutokukagakuWithinOneYear());
				
				field = report.getField("xYGetprc2");
				report.putFieldData(field, detail.getusyutokukagakuWithinTwoYear());
				
				field = report.getField("xYGetprc3");
				report.putFieldData(field, detail.getusyutokukagakuWithinThreeYear());
				
				field = report.getField("xYGetprc4");
				report.putFieldData(field, detail.getusyutokukagakuWithinFourYear());
				
				field = report.getField("xYGetprc5");
				report.putFieldData(field, detail.getusyutokukagakuWithinFiveYear());
				
				field = report.getField("xYGetprc6");
				report.putFieldData(field, detail.getusyutokukagakuOverFiveYear());
				
				field = report.getField("xYGetprc7");
				report.putFieldData(field, StringUtl.formatNumber(detail.getusyutokukagakuTotal()));
							
				field = report.getField("xYGenrui1");
				report.putFieldData(field, detail.getugenkaSyokyakuRuikeiWithinOneYear());
				
				field = report.getField("xYGenrui2");
				report.putFieldData(field, detail.getugenkaSyokyakuRuikeiWithinTwoYear());
				
				field = report.getField("xYGenrui3");
				report.putFieldData(field, detail.getugenkaSyokyakuRuikeiWithinThreeYear());
				
				field = report.getField("xYGenrui4");
				report.putFieldData(field, detail.getugenkaSyokyakuRuikeiWithinFourYear());
				
				field = report.getField("xYGenrui5");
				report.putFieldData(field, detail.getugenkaSyokyakuRuikeiWithinFiveYear());
				
				field = report.getField("xYGenrui6");
				report.putFieldData(field, detail.getugenkaSyokyakuRuikeiOverFiveYear());
				
				field = report.getField("xYGenrui7");
				report.putFieldData(field, StringUtl.formatNumber(detail.getugenkaSyokyakuRuikeiTotal()));
				
				field = report.getField("xYGen1");
				report.putFieldData(field, StringUtl.formatNumber(detail.getugenkaSyokyahiWithinOneYear()));
				
				field = report.getField("xYGen2");
				report.putFieldData(field, StringUtl.formatNumber(detail.getugenkaSyokyahiWithinTwoYear()));
				
				field = report.getField("xYGen3");
				report.putFieldData(field, StringUtl.formatNumber(detail.getugenkaSyokyahiWithinThreeYear()));
				
				field = report.getField("xYGen4");
				report.putFieldData(field, StringUtl.formatNumber(detail.getugenkaSyokyahiWithinFourYear()));
				
				field = report.getField("xYGen5");
				report.putFieldData(field, StringUtl.formatNumber(detail.getugenkaSyokyahiWithinFiveYear()));
				
				field = report.getField("xYGen6");
				report.putFieldData(field, StringUtl.formatNumber(detail.getugenkaSyokyahiOverFiveYear()));
				
				field = report.getField("xYGen7");
				report.putFieldData(field, detail.getugenkaSyokyahi());

				field = report.getField("xYBok1");
				report.putFieldData(field, StringUtl.formatNumber(detail.getubokaWithinOneYear()));
				
				field = report.getField("xYBok2");
				report.putFieldData(field, StringUtl.formatNumber(detail.getubokaWithinTwoYear()));
				
				field = report.getField("xYBok3");
				report.putFieldData(field, StringUtl.formatNumber(detail.getubokaWithinThreeYear()));
				
				field = report.getField("xYBok4");
				report.putFieldData(field, StringUtl.formatNumber(detail.getubokaWithinFourYear()));
				
				field = report.getField("xYBok5");
				report.putFieldData(field, StringUtl.formatNumber(detail.getubokaWithinFiveYear()));
				
				field = report.getField("xYBok6");
				report.putFieldData(field, StringUtl.formatNumber(detail.getubokaOverFiveYear()));
				
				field = report.getField("xYBok7");
				report.putFieldData(field, StringUtl.formatNumber(detail.getubokaTotal()));
				
				field = report.getField("xMGetprc1");
				report.putFieldData(field, detail.getmsyutokukagakuWithinOneYear());
				
				field = report.getField("xMGetprc2");
				report.putFieldData(field, detail.getmsyutokukagakuWithinTwoYear());
				
				field = report.getField("xMGetprc3");
				report.putFieldData(field, detail.getmsyutokukagakuWithinThreeYear());
				
				field = report.getField("xMGetprc4");
				report.putFieldData(field, detail.getmsyutokukagakuWithinFourYear());
				
				field = report.getField("xMGetprc5");
				report.putFieldData(field, detail.getmsyutokukagakuWithinFiveYear());
				
				field = report.getField("xMGetprc6");
				report.putFieldData(field, detail.getmsyutokukagakuOverFiveYear());
				
				field = report.getField("xMGetprc7");
				report.putFieldData(field, StringUtl.formatNumber(detail.getmsyutokukagakuTotal()));
							
				field = report.getField("xMGenrui1");
				report.putFieldData(field, detail.getmgenkaSyokyakuRuikeiWithinOneYear());
				
				field = report.getField("xMGenrui2");
				report.putFieldData(field, detail.getmgenkaSyokyakuRuikeiWithinTwoYear());
				
				field = report.getField("xMGenrui3");
				report.putFieldData(field, detail.getmgenkaSyokyakuRuikeiWithinThreeYear());
				
				field = report.getField("xMGenrui4");
				report.putFieldData(field, detail.getmgenkaSyokyakuRuikeiWithinFourYear());
				
				field = report.getField("xMGenrui5");
				report.putFieldData(field, detail.getmgenkaSyokyakuRuikeiWithinFiveYear());
				
				field = report.getField("xMGenrui6");
				report.putFieldData(field, detail.getmgenkaSyokyakuRuikeiOverFiveYear());
				
				field = report.getField("xMGenrui7");
				report.putFieldData(field, StringUtl.formatNumber(detail.getmgenkaSyokyakuRuikeiTotal()));
				
				field = report.getField("xMGen1");
				report.putFieldData(field, StringUtl.formatNumber(detail.getmgenkaSyokyahiWithinOneYear()));
				
				field = report.getField("xMGen2");
				report.putFieldData(field, StringUtl.formatNumber(detail.getmgenkaSyokyahiWithinTwoYear()));
				
				field = report.getField("xMGen3");
				report.putFieldData(field, StringUtl.formatNumber(detail.getmgenkaSyokyahiWithinThreeYear()));
				
				field = report.getField("xMGen4");
				report.putFieldData(field, StringUtl.formatNumber(detail.getmgenkaSyokyahiWithinFourYear()));
				
				field = report.getField("xMGen5");
				report.putFieldData(field, StringUtl.formatNumber(detail.getmgenkaSyokyahiWithinFiveYear()));
				
				field = report.getField("xMGen6");
				report.putFieldData(field, StringUtl.formatNumber(detail.getmgenkaSyokyahiOverFiveYear()));
				
				field = report.getField("xMGen7");
				report.putFieldData(field, detail.getmgenkaSyokyahi());

				field = report.getField("xMBok1");
				report.putFieldData(field, StringUtl.formatNumber(detail.getmbokaWithinOneYear()));
				
				field = report.getField("xMBok2");
				report.putFieldData(field, StringUtl.formatNumber(detail.getmbokaWithinTwoYear()));
				
				field = report.getField("xMBok3");
				report.putFieldData(field, StringUtl.formatNumber(detail.getmbokaWithinThreeYear()));
				
				field = report.getField("xMBok4");
				report.putFieldData(field, StringUtl.formatNumber(detail.getmbokaWithinFourYear()));
				
				field = report.getField("xMBok5");
				report.putFieldData(field, StringUtl.formatNumber(detail.getmbokaWithinFiveYear()));
				
				field = report.getField("xMBok6");
				report.putFieldData(field, StringUtl.formatNumber(detail.getmbokaOverFiveYear()));
				
				field = report.getField("xMBok7");
				report.putFieldData(field, StringUtl.formatNumber(detail.getmbokaTotal()));				
				
//                lineCount++;	
				
//				if (lineCount > MAX_LINE) {
					//souPage++; 
//					lineCount = 0;
//				}
				
			}
			
			
			return tmpFile.getName();

		} finally {
			// LACS帳票バッチ対応
			if (!batchFlg) {
				if (report != null) {
					try {
						report.close();
					}
					catch (ReportException e) {
					}
					report = null;
				}
				if (fout != null) {
					try {
						fout.close();
					}
					catch (Exception e) {
						fout = null;
					}
				}
			}

		}		
		
				
	}
	
	// ヘッダー部
		private void headPrint(LACSReportBean piReportBean, String piDateMode) throws Exception {
			
			Field field = null;

			lineCount = 0;
			page++;
			report.createPage(1);

			field = report.getField("xPage");
			report.putFieldData(field, page + "/" + souPage);
			
			field = report.getField("xCreateDate");
			report.putFieldData(field, super.convertReki(detail.getCreateDate(), piDateMode));
			
			field = report.getField("xTitle");
			report.putFieldData(field, super.acStd.equals(LACSDefine.AccountStandard.NEW_1) ? TITLE_NEW : TITLE_OLD);
			
			field = report.getField("xLcNm");
			report.putFieldData(field, detail.getLeaseCompany());
			
			field = report.getField("xLuNm");
			report.putFieldData(field, detail.getKaizisaki());
			
			field = report.getField("xOutputDate");
			report.putFieldData(field, super.convertReki(detail.getKijunDate(), piDateMode));
		
			field = report.getField("xJysiUm");
			report.putFieldData(field, detail.getJysiUm());
			
			field = report.getField("xTrdHnteiKekaNm");
			report.putFieldData(field, detail.getLeaseBunrui());
			
			field = report.getField("xAcShrNm");
			report.putFieldData(field, detail.getKaikeisyoriHouhou());
			
			field = report.getField("xYGetprcTitle");
			report.putFieldData(field, "取得価額");
			
			field = report.getField("xYGenruiTitle");
			report.putFieldData(field, "減価償却累計額");
			
			field = report.getField("xYGenTitle");
			report.putFieldData(field, "減価償却費");
			
			field = report.getField("xYBokTitle");
			report.putFieldData(field, "簿価");
			
			field = report.getField("xMGetprcTitle");
			report.putFieldData(field, "取得価額");
			
			field = report.getField("xMGenruiTitle");
			report.putFieldData(field, "減価償却累計額");
			
			field = report.getField("xMGenTitle");
			report.putFieldData(field, "減価償却費");
			
			field = report.getField("xMBokTitle");
			report.putFieldData(field, "簿価"); 

			field = report.getField("xMikeikaTitle");
			report.putFieldData(field, "未経過リース料");
				
			field = report.getField("xZankTitle");
			report.putFieldData(field, "残価保証額");
				
			field = report.getField("xGnpnTitle");
			report.putFieldData(field, "元本");
				
			field = report.getField("xRskTitle");
			report.putFieldData(field, "利息");
			
			field = report.getField("xIjiTitle");
			report.putFieldData(field, "維持管理費");
			
			field = report.getField("xEkimTitle");
			report.putFieldData(field, "役務提供費");
			
			field = report.getField("xStaxTitle");
			report.putFieldData(field, "消費税等");
			

		}
	
	
				

}
	