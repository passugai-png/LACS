package jp.co.pro_app.lacs.affairs.monthreport.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportSiwakeBean;
import jp.co.pro_app.lacs.affairs.monthreport.data.entity.LACSMReportSiwakeEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.StringUtl;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

import java.util.List;

/**
 * 月次帳票出力：仕訳合計表 Model.
 * 
 * @author fukuhara
 * @version 20080415
 */
public class LACSMReportPDFSiwakeWriter extends LACSMReportPDFWriterBase {

	private final int	maxLine	= 48;	// １ページの最大行

	// 2020/05/22 ADD START LACS帳票バッチ出力
		Report report = null; // WebKCoreレポートオブジェクト
		
		File tmpFile = null; // 出力先ファイル
		
		FileOutputStream fout = null; // 出力ファイルストリーム
		
		private int batchOutPageCount = 0; // 一つのPDFファイルが出力したページ数
		
		private boolean batchFlg = false; // バッチ実行フラグ 
		
		private boolean endOnePDFReportFlg = true; // 一つのPDFファイルの出力が終わってないか
		
		private List<String> batchOutPDFFiles = new ArrayList<String>(); //　作成したPDFファイルのリスト
		
		private int batchPrintedPage = 0; // makePDF執行するたびに出力したページ数
		
		private static final int MAX_PAGE = 1000; // 一つのPDFファイルの最大ページ数
		
		/**　バッチ実行フラグ を設定する
		 * 
		 */
		public void setBatchFlg(boolean batchFlg) {
			this.batchFlg = batchFlg;
		}
		
		/**　作成したPDFファイル名を返す
		 * @return String 作成しだPDFファイル名
		 */
		public String getFileName() {
			return tmpFile != null ? tmpFile.getName() : ""; 
		}

		
		/**　PDF出力を開始する
		 * @param piContext
		 * @throws Exception　
		 */
		public void startReport(ServletContext piContext) throws Exception {
			File wprlHomeDirectory = new File(PdfProperties.getInstance().getProperty(PdfProperties.WKC_PDF_HOME));
			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
			formDirectory = new File(wprlHomeDirectory, FORM_PATH);
			tmpFile = File.createTempFile("pdf13_", ".pdf", scratchDirectory);
			fout = new FileOutputStream(tmpFile);
			File formFile = new File(formDirectory, "Siwake.pdf");
			File datFile = new File(formDirectory, "Siwake.dat");
			report = new Report(formFile, datFile, fout);
			batchOutPDFFiles.add(tmpFile.getName());
			batchOutPageCount = 0;
			endOnePDFReportFlg = false;
		}
		
		/**
		　 * 　	PDF出力を終わらせる
		 */
		public void endReport() {
			if (!endOnePDFReportFlg) {
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
		
		/** makePDF執行するたびに出力したページ数を返す
		 * @return　Integer  makePDF執行するたびに出力したページ数
		 */
		public int getBatchPrintedPage() {
			return batchPrintedPage;
		}
	// 2020/05/22 ADD END   LACS帳票バッチ出力
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
	public LACSMReportPDFSiwakeWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
	}

	/**
	 * 出力データ取得.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	public void getData(LACSMReportBean piReportBean) throws SQLException {
		LACSMReportSiwakeEntity reportEntity = new LACSMReportSiwakeEntity(super.model, commonBean, piReportBean);
		LACSMReportSiwakeBean detail = null;
		try {
			reportEntity.setCon(super.con);
			reportEntity.execSQL();
			int dataCount = 0;
			while (reportEntity.next()) {
				detail = new LACSMReportSiwakeBean();
				piReportBean.addSiwakeBean(detail);

				detail.setCreateDate(reportEntity.getCreateDate());
				detail.setTermFrom(reportEntity.getTermFrom());
				detail.setTermTo(reportEntity.getTermTo());
				detail.setLeaseUserNm(reportEntity.getLeaseUserNm());
				detail.setLeaseCompanyNm(reportEntity.getLeaseCompanyNm());
				detail.setLeaseCompanyZip(reportEntity.getLeaseCompanyZip());
				detail.setLeaseCompanyAddr1(reportEntity.getLeaseCompanyAddr1());
				detail.setLeaseCompanyAddr2(reportEntity.getLeaseCompanyAddr2());
				detail.setTaishoAcKijyunCd(reportEntity.getTaishoAcKijyunCd());
				detail.setTaishoAcKijyunNm(reportEntity.getTaishoAcKijyunNm());
				detail.setCtshkFlg(reportEntity.getCtshkFlg());
				detail.setCtshkFlgNm(reportEntity.getCtshkFlgNm());
				detail.setKeijYm(reportEntity.getKeijYm());
				detail.setKrKnjKmkCd(reportEntity.getKrKnjKmkCd());
				detail.setKrKnjKmkNm(reportEntity.getKrKnjKmkNm());
				detail.setKrktAmt(reportEntity.getKrktAmt());
				detail.setKsKnjKmkCd(reportEntity.getKsKnjKmkCd());
				detail.setKsKnjKmkNm(reportEntity.getKsKnjKmkNm());
				detail.setKsktAmt(reportEntity.getKsktAmt());

				// 2020/05/22 ADD START
				detail.setMesiKbn(reportEntity.getMesiKbn());
				// 2020/05/22 ADD END
				
				// 2021/03/01 arai 重要性有無の追加 start
				detail.setJysiUmCd(reportEntity.getJysiUmCd());
				detail.setJysiUm(reportEntity.getJysiUm());				
				// 2021/03/01 arai 重要性有無の追加　end

				dataCount++;

			}
			piReportBean.setDataMax(dataCount);

		}
		finally {
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
	public String makePDF(LACSMReportBean piReportBean, String piDateMode, ServletContext piContext) throws Exception {
		// 2020/05/22 DEL START LACS帳票バッチ出力
		//Report report = null; // WebKCoreレポートオブジェクト
		// 2020/05/22 DEL END   LACS帳票バッチ出力
		LACSMReportSiwakeBean detail = null;

		File wprlHomeDirectory = new File(PdfProperties.getInstance().getProperty(PdfProperties.WKC_PDF_HOME));
		File formFile = null;
		File datFile = null;
		Field field = null;

		// 2020/05/22 DEL START LACS帳票バッチ出力
		//File tmpFile = null; // 出力先ファイル
		//FileOutputStream fout = null; // 出力ファイルストリーム
		// 2020/05/22 DEL END   LACS帳票バッチ出力

		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		formDirectory = new File(wprlHomeDirectory, FORM_PATH);


		// 2020/05/22 ADD START
		int gokeiFlg = 0;
		// 2020/05/22 ADD END
		
		try {
			// 2020/05/22 ADD START LACS帳票バッチ出力
			if (!batchFlg) {
			// 2020/05/22 ADD END   LACS帳票バッチ出力

			tmpFile = File.createTempFile("pdf13_", ".pdf", scratchDirectory);
			fout = new FileOutputStream(tmpFile);
			formFile = new File(formDirectory, "Siwake.pdf");
			datFile = new File(formDirectory, "Siwake.dat");
			report = new Report(formFile, datFile, fout);
			// 2020/05/22 ADD START LACS帳票バッチ出力
			}
			// 2020/05/22 ADD END   LACS帳票バッチ出力

			// 2020/05/22 ADD START LACS帳票バッチ出力
			if (endOnePDFReportFlg && batchFlg) {
				this.startReport(piContext);
			}
			// 2020/05/22 ADD START LACS帳票バッチ帳票出力
			
			String breakKey = "";
			int pageCount = 1;
			int meisaiCount = 0;
			int pageMax = 1;

			
			
			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				
				detail = piReportBean.getSiwakeBean(i);
				//System.out.println(i + "行目");
				
				if (meisaiCount == this.maxLine) {
					//report.createPage(1);
					//System.out.println("最大行改ページ");
					meisaiCount = 0;
					pageMax++;
					
				} else if (meisaiCount!=0 && !breakKey.equals(detail.getTaishoAcKijyunCd() + detail.getCtshkFlg() + detail.getJysiUmCd())) {
					//System.out.println("条件改ページ");
					//report.createPage(1);
					meisaiCount = 0;
					pageMax++;
										
				}
				meisaiCount++;
				
				breakKey = detail.getTaishoAcKijyunCd() + detail.getCtshkFlg() + detail.getJysiUmCd();
																	
			}	
						
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 start
			if (batchFlg) {
				batchOutPageCount += pageMax;
				batchPrintedPage = pageMax;
			}
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 end
			breakKey = "";
			meisaiCount = 0;		
			
			// 2021/10/18  帳票出力
			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				detail = piReportBean.getSiwakeBean(i);
							
					// 2020/05/22 ADD START
					if (detail.getMesiKbn().contentEquals("9")) {
						if (meisaiCount == this.maxLine) {
							report.createPage(1);
																																	
							field = report.getField("xPage"); // ページ数
							report.putFieldData(field, StringUtl.formatNumber(pageCount) + "/" + StringUtl.formatNumber(pageMax));
									
							field = report.getField("xCreateDate"); // 作成日 
							report.putFieldData(field, super.convertReki(detail.getCreateDate(), piDateMode));
		
							field = report.getField("xTermFrom"); // 対象期間From
							report.putFieldData(field, super.convertRekiLong(detail.getTermFrom(), piDateMode));
		
							field = report.getField("xTermTo"); // 対象期間To
							report.putFieldData(field, super.convertRekiLong(detail.getTermTo(), piDateMode));
		
							field = report.getField("xLeaseUserNm"); // リースユーザ名
							report.putFieldData(field, detail.getLeaseUserNm());
		
							field = report.getField("xLeaseCompanyNm"); // リース会社名
							report.putFieldData(field, detail.getLeaseCompanyNm());
		
							field = report.getField("xLeaseCompanyZip"); // リース会社郵便番号
							report.putFieldData(field, detail.getLeaseCompanyZip());
							
							field = report.getField("xLeaseCompanyAddr1"); // リース会社住所１
							report.putFieldData(field, detail.getLeaseCompanyAddr1());
		
							field = report.getField("xLeaseCompanyAddr2"); // リース会社住所２
							report.putFieldData(field, detail.getLeaseCompanyAddr2());	
							
							
							// 2021/10/19 ヘッダー情報出力 追加 START
							field = report.getField("xTaishoAcKijyunNm"); // リース会計基準名称
							report.putFieldData(field, detail.getTaishoAcKijyunNm());
		
							field = report.getField("xCtshkFlgNm"); // 会計処理方法名称
							report.putFieldData(field, detail.getCtshkFlgNm());
							
							field = report.getField("xJysiUm"); // 重要性有無
							report.putFieldData(field, detail.getJysiUm());				
							// 2021/10/19 ヘッダー情報出力 追加 END							
							
							pageCount++;
							meisaiCount = 0;
						}
					}else {
					// 2020/05/22 ADD END
						if (meisaiCount == this.maxLine || !breakKey.equals(detail.getTaishoAcKijyunCd() + detail.getCtshkFlg() + detail.getJysiUmCd())) {
		
							report.createPage(1);
							
							field = report.getField("xPage"); // ページ
							report.putFieldData(field, StringUtl.formatNumber(pageCount) + "/" + StringUtl.formatNumber(pageMax));
		
							field = report.getField("xCreateDate"); // 作成日
							report.putFieldData(field, super.convertReki(detail.getCreateDate(), piDateMode));
		
							field = report.getField("xTermFrom"); // 対象期間From
							report.putFieldData(field, super.convertRekiLong(detail.getTermFrom(), piDateMode));
		
							field = report.getField("xTermTo"); // 対象期間To
							report.putFieldData(field, super.convertRekiLong(detail.getTermTo(), piDateMode));
		
							field = report.getField("xLeaseUserNm"); // リースユーザ名
							report.putFieldData(field, detail.getLeaseUserNm());
		
							field = report.getField("xLeaseCompanyNm"); // リース会社名
							report.putFieldData(field, detail.getLeaseCompanyNm());
		
							field = report.getField("xLeaseCompanyZip"); // リース会社郵便番号
							report.putFieldData(field, detail.getLeaseCompanyZip());
		
							field = report.getField("xLeaseCompanyAddr1"); // リース会社住所１
							report.putFieldData(field, detail.getLeaseCompanyAddr1());
		
							field = report.getField("xLeaseCompanyAddr2"); // リース会社住所２
							report.putFieldData(field, detail.getLeaseCompanyAddr2());
		
							field = report.getField("xTaishoAcKijyunNm"); // リース会計基準名称
							report.putFieldData(field, detail.getTaishoAcKijyunNm());
		
							field = report.getField("xCtshkFlgNm"); // 会計処理方法名称
							report.putFieldData(field, detail.getCtshkFlgNm());
							
							// 2021/03/01 arai 重要性有無の追加 start
							field = report.getField("xJysiUm"); // 重要性有無
							report.putFieldData(field, detail.getJysiUm());
							// 2021/03/01 arai 重要性有無の追加 end
		
							pageCount++;
							meisaiCount = 0;
						}
						
						if (gokeiFlg == 1) {
							
							gokeiFlg = 0;
						}
						
					// 2020/05/22 ADD START
					}
					// 2020/05/22 ADD END

					String ym = detail.getKeijYm();
					if (ym != null && ym.length() == 6) {
						ym = ym.substring(0, 4) + "/" + ym.substring(4, 6);
					}
					else {
						ym = "";
					}
					
					// 2020/05/22 ADD START
					if 	(detail.getMesiKbn().contentEquals("9")) {					
						if (gokeiFlg == 0) {
							ym = "期間計";
							gokeiFlg = 1;		
							
						}else {
							ym = "";
						}	
					}					
																		
					// 2020/05/22 ADD END
					field = report.getField("xKeijYm." + meisaiCount); // 年月
					report.putFieldData(field, ym);

					field = report.getField("xKrKnjKmkNm." + meisaiCount); // 借方科目名称
					report.putFieldData(field, detail.getKrKnjKmkNm());

					field = report.getField("xKrktAmt." + meisaiCount); // 借方金額
					report.putFieldData(field, formatCurrency(detail.getKrktAmt()));

					field = report.getField("xKsKnjKmkNm." + meisaiCount); // 貸方科目名称
					report.putFieldData(field, detail.getKsKnjKmkNm());

					field = report.getField("xKsktAmt." + meisaiCount); // 貸方金額
					report.putFieldData(field, formatCurrency(detail.getKsktAmt()));

					field = report.getField("xComment");
					report.putFieldData(field, COMMENT_2LINES);

					breakKey = detail.getTaishoAcKijyunCd() + detail.getCtshkFlg() + detail.getJysiUmCd();
					meisaiCount++;

			}
			

			// 2020/05/22 ADD START LACS帳票バッチ出力
			if (!batchFlg) {
			// 2020/05/22 ADD END   LACS帳票バッチ出力
			report.close();
			report = null;
			// 2020/05/22 ADD START LACS帳票バッチ出力
			}
			// 2020/05/22 ADD END   LACS帳票バッチ出力

			// 2020/05/22 ADD START LACS帳票バッチ出力
			if (batchOutPageCount >= MAX_PAGE && batchFlg) {
				this.endReport();
				endOnePDFReportFlg = true;
			}
			// 2020/05/22 ADD END   LACS帳票バッチ出力
			
			return tmpFile.getName();

		}
		finally {
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/11 start
			if (!batchFlg) {
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/11 end
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
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/11 start
			}
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/11 end
		}
	}

	/**
	 * 通貨形式に変換（数値以外は空白）.
	 * 
	 * @param piData
	 *            入力データ
	 * @return String フォーマット変換されたデータ
	 */
	private String formatCurrency(String piData) {
		try {
			if (piData == null) {
				return "";
			}
			BigDecimal bd = new BigDecimal(piData);
			return StringUtl.formatNumber(bd.longValue());
		}
		catch (NumberFormatException e) {
			return "";
		}
	}

	/**
	 * 
	 * 出力データ取得2.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @return 帳票データ
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected ArrayList<Object> getData2(LACSMReportBean piReportBean) throws SQLException {
		return null;
	}

}
