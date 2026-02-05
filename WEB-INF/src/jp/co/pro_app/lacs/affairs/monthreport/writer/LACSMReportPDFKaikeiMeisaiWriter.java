package jp.co.pro_app.lacs.affairs.monthreport.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//import java.util.Properties;

//import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
//import jp.co.pro_app.lacs.affairs.common.data.entity.LACSLoginCompanyEntity;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportKaikeiMeisaiBean;
import jp.co.pro_app.lacs.affairs.monthreport.data.entity.LACSMReportKaikeiMeisaiEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

/**
 * 月次帳票出力：リース会計基準明細書 Model.
 * 
 * @author fukuhara
 * @version 20080411
 */
public class LACSMReportPDFKaikeiMeisaiWriter extends LACSMReportPDFWriterBase {

	private static final String	TITLE			= "リース会計基準明細書";

	private final int			page1Max		= 15;			// １ページ目の最大行

	private final int			page2Max		= 34;			// ２ページ目以降の最大行

	private static final String	TITLE_COMP		= "リース会社　：";

	private static final String	TITLE_USER		= "開示先　　　：";

	private static final String	TITLE_KEI_NO	= "契約番号    ：";

	//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 start
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
	
	/**　作成したPDFファイルのリストを返す
	 * @return　List<String> 作成したPDFファイルのリスト
	 */
	public List<String> getBatchOutPDFFiles() {
		return batchOutPDFFiles;
	}
		
	/**　PDF出力を開始する
	 * @param piContext
	 * @throws Exception　
	 */
	public void startReport(ServletContext piContext) throws Exception {
		File wprlHomeDirectory = new File(PdfProperties.getInstance().getProperty(PdfProperties.WKC_PDF_HOME));
		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		formDirectory = new File(wprlHomeDirectory, FORM_PATH);
		tmpFile = File.createTempFile("pdf11_", ".pdf", scratchDirectory);
		fout = new FileOutputStream(tmpFile);
		File formFile = new File(formDirectory, "KaikeiMeisai.pdf");
		File datFile = new File(formDirectory, "KaikeiMeisai.dat");
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
	//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 end
	
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
	public LACSMReportPDFKaikeiMeisaiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
		LACSMReportKaikeiMeisaiEntity reportEntity = new LACSMReportKaikeiMeisaiEntity(super.model, commonBean, piReportBean);
		LACSMReportKaikeiMeisaiBean detail = null;
			
		try {
			reportEntity.setCon(super.con);
			reportEntity.execSQL();
			int dataCount = 0;
			while (reportEntity.next()) {
				detail = new LACSMReportKaikeiMeisaiBean();
				piReportBean.addKaikeiMeisaiBean(detail);
				detail.setCreateDate(reportEntity.getCreateDate());
				detail.setLeaseUserNm(reportEntity.getLeaseUserNm());
				detail.setLeaseCompanyNm(reportEntity.getLeaseCompanyNm());
				detail.setLeaseCompanyZip(reportEntity.getLeaseCompanyZip());
				detail.setLeaseCompanyAddr1(reportEntity.getLeaseCompanyAddr1());
				detail.setLeaseCompanyAddr2(reportEntity.getLeaseCompanyAddr2());
				detail.setLeaseCompanyTelno(reportEntity.getLeaseCompanyTelno());
				detail.setKeiNo(reportEntity.getKeiNo());
				detail.setKeiTerm(reportEntity.getKeiTerm());
				detail.setKeiYmd(reportEntity.getKeiYmd());
				detail.setKnshuYmd(reportEntity.getKnshuYmd());
				detail.setMryoYmd(reportEntity.getMryoYmd());
				detail.setDihBknNm(reportEntity.getDihBknNm());
				detail.setTrdHnteKekaKbn(reportEntity.getTrdHnteKekaKbn());
				detail.setTrdHnteKekaNm(reportEntity.getTrdHnteKekaNm());
				detail.setLamtSum(reportEntity.getLamtSum());
				detail.setKeiAmt(reportEntity.getKeiAmt());
				detail.setKnuAmt(reportEntity.getKnuAmt());
				detail.setKeiAmtStaxSum(reportEntity.getKeiAmtStaxSum());
				detail.setRskSum(reportEntity.getRskSum());
				detail.setZankHshoAmtSum(reportEntity.getZankHshoAmtSum());
				detail.setIjiHyoSum(reportEntity.getIjiHyoSum());
				detail.setEkmHyoSum(reportEntity.getEkmHyoSum());
				detail.setRskKeijHohoKbn(reportEntity.getRskKeijHohoKbn());
				detail.setRskKeijHohoKbnNm(reportEntity.getRskKeijHohoKbnNm());
				detail.setTnkiHohoKbn(reportEntity.getTnkiHohoKbn());
				detail.setFknTnkiHohoNm(reportEntity.getFknTnkiHohoNm());
				detail.setGnkskHasuChseCd(reportEntity.getGnkskHasuChseCd());
				detail.setHasuChseNm(reportEntity.getHasuChseNm());
				detail.setKeijYm(reportEntity.getKeijYm());
				detail.setLamt(reportEntity.getLamt());
				detail.setTgtuGnpn(reportEntity.getTgtuGnpn());
				detail.setTgtuRsk(reportEntity.getTgtuRsk());
				detail.setIjiKanriHyo(reportEntity.getIjiKanriHyo());
				detail.setEkmTeikHyo(reportEntity.getEkmTeikHyo());
				detail.setZandGnpn(reportEntity.getZandGnpn());
				detail.setMkLamt(reportEntity.getMkLamt());
				detail.setKrKnjKmkCd(reportEntity.getKrKnjKmkCd());
				detail.setKrKnjKmkNm(reportEntity.getKrKnjKmkNm());
				detail.setKrktAmt(reportEntity.getKrktAmt());
				detail.setKsKnjKmkCd(reportEntity.getKsKnjKmkCd());
				detail.setKsKnjKmkNm(reportEntity.getKsKnjKmkNm());
				detail.setKsktAmt(reportEntity.getKsktAmt());
				detail.setHyjyoKeiNo(reportEntity.getHyjyoKeiNo());
				detail.setWarning1(reportEntity.getWarning1());
				detail.setWarning2(reportEntity.getWarning2());
				detail.setWarning3(reportEntity.getWarning3());
				
				detail.setHyjyoKeiNo(reportEntity.getHyjyoKeiNo());
				
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
		//　DELETE Ren.SL LACS帳票バッチ出力  2013/04/10 start
		//Report report = null; // WebKCoreレポートオブジェクト
		//　DELETE Ren.SL LACS帳票バッチ出力  2013/04/10 end
		LACSMReportKaikeiMeisaiBean detail = null;

		File wprlHomeDirectory = new File(PdfProperties.getInstance().getProperty(PdfProperties.WKC_PDF_HOME));
		File formFile = null;
		File datFile = null;
		Field field = null;
		
		//　DELETE Ren.SL LACS帳票バッチ出力  2013/04/10 start
		//File tmpFile = null; // 出力先ファイル
		//FileOutputStream fout = null; // 出力ファイルストリーム
		//　DELETE Ren.SL LACS帳票バッチ出力  2013/04/10 end
		
		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		formDirectory = new File(wprlHomeDirectory, FORM_PATH);
		
		detail = null;
		int pageCount = 1;
		int meisaiCount = 0;
		String pIdx = "";

		int souPage = 0; // 総ページ数
		double numResult = 0;

		try {
			
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 start
			if (!batchFlg) {
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 end
				tmpFile = File.createTempFile("pdf11_", ".pdf", scratchDirectory);
				fout = new FileOutputStream(tmpFile);
				formFile = new File(formDirectory, "KaikeiMeisai.pdf");
				datFile = new File(formDirectory, "KaikeiMeisai.dat");
				report = new Report(formFile, datFile, fout);
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 start
			}
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 end
			
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 start
			if (endOnePDFReportFlg && batchFlg) {
				this.startReport(piContext);
			}
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 end
			
			numResult = piReportBean.getDataMax() - page1Max;
			numResult = Math.ceil(numResult / page2Max);
			souPage = 1 + (int)numResult;
			
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 start
			if (batchFlg) {
				batchOutPageCount += souPage;
				batchPrintedPage = souPage;
			}
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 end
			
			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				detail = piReportBean.getKaikeiMeisaiBean(i);
				if (i == 0) {

					report.createPage(1);

					field = report.getField("xPageTittle"); // ページ
					report.putFieldData(field, "ページ  :");
					field = report.getField("xDateTittle"); // 作成日
					report.putFieldData(field, "作成日  :");
					field = report.getField("xTaniTittle"); // 単位
					report.putFieldData(field, "単位　  :");
					field = report.getField("xTaniKigo"); // 単位
					report.putFieldData(field, "円");

					field = report.getField("xPage" + pIdx); // ページ
					report.putFieldData(field, StringUtl.formatNumber(pageCount) + "/" + souPage);
					headPrint(report, detail, piDateMode);
					meisaiHaedPrint(report, detail, piDateMode, pIdx);

					field = report.getField("xTitleLine");
					report.putFieldData(field, TITLE);
					field = report.getField("xTitle");
					report.putFieldData(field, TITLE);

					field = report.getField("xDate");
					report.putFieldData(field, super.convertReki(Convert.toString(new Date()), piDateMode));

				}
				
				if (pageCount == 1) {
					if (meisaiCount == page1Max) {

						report.createPage(2);
						pIdx = "2";
						pageCount++;

						field = report.getField("xPageTittle"); // ページ
						report.putFieldData(field, "ページ  :");
						field = report.getField("xDateTittle"); // 作成日
						report.putFieldData(field, "作成日  :");
						field = report.getField("xTaniTittle"); // 単位
						report.putFieldData(field, "単位　  :");
						field = report.getField("xTaniKigo"); // 単位
						report.putFieldData(field, "円");

						field = report.getField("xPage" + pIdx); // ページ
						report.putFieldData(field, StringUtl.formatNumber(pageCount) + "/" + souPage);
						meisaiHaedPrint(report, detail, piDateMode, pIdx);

						field = report.getField("xLeasCompanyTitle");
						report.putFieldData(field, TITLE_COMP);
						field = report.getField("xLeaseCompany"); // リース会社名
						report.putFieldData(field, detail.getLeaseCompanyNm());

						field = report.getField("xLeasUserTitle");
						report.putFieldData(field, TITLE_USER);
						field = report.getField("xLeaseUser"); // リースユーザ名
						report.putFieldData(field, detail.getLeaseUserNm());

						field = report.getField("xKeiNoTitle");
						report.putFieldData(field, TITLE_KEI_NO);
						field = report.getField("xKeiNo"); // 契約番号
						report.putFieldData(field, detail.getHyjyoKeiNo());

						field = report.getField("xDate");
						report.putFieldData(field, super.convertReki(Convert.toString(new Date()), piDateMode));

						meisaiCount = 0;
					}
				}
				else {
					if (meisaiCount == page2Max) {

						report.createPage(2);
						pIdx = "2";
						pageCount++;

						field = report.getField("xPageTittle"); // ページ
						report.putFieldData(field, "ページ  :");
						field = report.getField("xDateTittle"); // 作成日
						report.putFieldData(field, "作成日  :");
						field = report.getField("xTaniTittle"); // 単位
						report.putFieldData(field, "単位　  :");
						field = report.getField("xTaniKigo"); // 単位
						report.putFieldData(field, "円");

						field = report.getField("xPage" + pIdx); // ページ
						meisaiHaedPrint(report, detail, piDateMode, pIdx);
						report.putFieldData(field, StringUtl.formatNumber(pageCount) + "/" + souPage);

						field = report.getField("xLeasCompanyTitle");
						report.putFieldData(field, TITLE_COMP);
						field = report.getField("xLeaseCompany"); // リース会社名
						report.putFieldData(field, detail.getLeaseCompanyNm());

						field = report.getField("xLeasUserTitle");
						report.putFieldData(field, TITLE_USER);
						field = report.getField("xLeaseUser"); // リースユーザ名
						report.putFieldData(field, detail.getLeaseUserNm());

						field = report.getField("xKeiNoTitle");
						report.putFieldData(field, TITLE_KEI_NO);
						field = report.getField("xKeiNo"); // 契約番号
						report.putFieldData(field, detail.getHyjyoKeiNo());

						field = report.getField("xDate");
						report.putFieldData(field, super.convertReki(Convert.toString(new Date()), piDateMode));

						meisaiCount = 0;
					}
				}
				String ym = detail.getKeijYm();
				if (ym != null && ym.length() == 6) {
					ym = ym.substring(0, 4) + "/" + ym.substring(4, 6);
				}
				else {
					ym = "";
				}
				field = report.getField("xKeijYm" + pIdx + "." + meisaiCount); // 年月
				report.putFieldData(field, ym);

				field = report.getField("xLamt" + pIdx + "." + meisaiCount); // お支払金額
				report.putFieldData(field, formatCurrency(detail.getLamt()));

				field = report.getField("xTgtuGnpn" + pIdx + "." + meisaiCount); // うち元本
				report.putFieldData(field, formatCurrency(detail.getTgtuGnpn()));

				field = report.getField("xTgtuRsk" + pIdx + "." + meisaiCount); // うち利息
				report.putFieldData(field, formatCurrency(detail.getTgtuRsk()));

				field = report.getField("xIjiKanriHyo" + pIdx + "." + meisaiCount); // 維持管理費
				report.putFieldData(field, formatCurrency(detail.getIjiKanriHyo()));

				field = report.getField("xEkmTeikHyo" + pIdx + "." + meisaiCount); // 役務提供費
				report.putFieldData(field, formatCurrency(detail.getEkmTeikHyo()));

				field = report.getField("xZandGnpn" + pIdx + "." + meisaiCount); // 元本残高
				report.putFieldData(field, formatCurrency(detail.getZandGnpn()));

				field = report.getField("xMkLamt" + pIdx + "." + meisaiCount); // 未経過リース料
				report.putFieldData(field, formatCurrency(detail.getMkLamt()));

				field = report.getField("xKrKnjKmkNm" + pIdx + "." + meisaiCount); // 借方科目名称
				report.putFieldData(field, detail.getKrKnjKmkNm());

				field = report.getField("xKrktAmt" + pIdx + "." + meisaiCount); // 借方金額
				report.putFieldData(field, formatCurrency(detail.getKrktAmt()));

				field = report.getField("xKsKnjKmkNm" + pIdx + "." + meisaiCount); // 貸方科目名称
				report.putFieldData(field, detail.getKsKnjKmkNm());

				field = report.getField("xKsktAmt" + pIdx + "." + meisaiCount); // 貸方金額
				report.putFieldData(field, formatCurrency(detail.getKsktAmt()));

				field = report.getField("xComment");
				report.putFieldData(field, COMMENT);

				meisaiCount++;
			}
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/11 start
			if (!batchFlg) {
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/11 end
				report.close();
				report = null;
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/11 start
			}
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/11 end
			
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/11 start
			if (batchOutPageCount >= MAX_PAGE && batchFlg) {
				this.endReport();
				endOnePDFReportFlg = true;
			}
			//　ADD Ren.SL LACS帳票バッチ出力  2013/04/11 end
			
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
	 * ヘッダ部出力.
	 * 
	 * @param piReport
	 *            レポート
	 * @param piDetail
	 *            出力情報
	 * @param piDateMode
	 *            西暦和暦モード
	 * @exception Exception
	 *                例外
	 */
	private void headPrint(Report piReport, LACSMReportKaikeiMeisaiBean piDetail, String piDateMode) throws Exception {
		Field field = null;

		field = piReport.getField("xLeaseUserNm"); // リースユーザ名
		piReport.putFieldData(field, piDetail.getLeaseUserNm());

		field = piReport.getField("xLeaseCompanyNm"); // リース会社名
		piReport.putFieldData(field, piDetail.getLeaseCompanyNm());

		field = piReport.getField("xLeaseCompanyZip"); // リース会社郵便番号
		piReport.putFieldData(field, piDetail.getLeaseCompanyZip());

		field = piReport.getField("xLeaseCompanyAddr1"); // リース会社住所１
		piReport.putFieldData(field, piDetail.getLeaseCompanyAddr1());

		field = piReport.getField("xLeaseCompanyAddr2"); // リース会社住所２
		piReport.putFieldData(field, piDetail.getLeaseCompanyAddr2());

		field = piReport.getField("xLeaseCompanyTelno"); // リース会社電話番号
		piReport.putFieldData(field, piDetail.getLeaseCompanyTelno());

		field = piReport.getField("xKeiNo"); // 契約番号
		piReport.putFieldData(field, piDetail.getHyjyoKeiNo());

		field = piReport.getField("xKeiTerm"); // 期間
		piReport.putFieldData(field, piDetail.getKeiTerm() + " か 月");

		field = piReport.getField("xKeiYmd"); // 契約日
		piReport.putFieldData(field, super.convertReki(piDetail.getKeiYmd(), piDateMode));

		field = piReport.getField("xKnshuYmd"); // 検収日
		piReport.putFieldData(field, super.convertReki(piDetail.getKnshuYmd(), piDateMode));

		field = piReport.getField("xMryoYmd"); // 満了日
		piReport.putFieldData(field, super.convertReki(piDetail.getMryoYmd(), piDateMode));

		field = piReport.getField("xDihBknNm"); // 代表物件名
		piReport.putFieldData(field, piDetail.getDihBknNm());

		field = piReport.getField("xTrdHnteKekaNm"); // 取引判定結果名称
		piReport.putFieldData(field, piDetail.getTrdHnteKekaNm());

		field = piReport.getField("xLamtSum"); // リース料総額現在価値
		piReport.putFieldData(field, formatCurrency(piDetail.getLamtSum()));

		field = piReport.getField("xKeiAmt"); // 契約額
		piReport.putFieldData(field, formatCurrency(piDetail.getKeiAmt()));

		field = piReport.getField("xKnuAmt"); // 見積購入価額
		piReport.putFieldData(field, formatCurrency(piDetail.getKnuAmt()));

		field = piReport.getField("xKeiAmtStaxSum"); // 消費税総額
		piReport.putFieldData(field, formatCurrency(piDetail.getKeiAmtStaxSum()));

		field = piReport.getField("xRskSum"); // 利息総額
		piReport.putFieldData(field, formatCurrency(piDetail.getRskSum()));

		field = piReport.getField("xZankHshoAmtSum"); // 残価
		piReport.putFieldData(field, formatCurrency(piDetail.getZankHshoAmtSum()));

		field = piReport.getField("xIjiHyoSum"); // 維持管理費総額
		piReport.putFieldData(field, formatCurrency(piDetail.getIjiHyoSum()));

		field = piReport.getField("xEkmHyoSum"); // 役務提供総額
		piReport.putFieldData(field, formatCurrency(piDetail.getEkmHyoSum()));

		field = piReport.getField("xRskKeijHohoKbnNm"); // 利息計上方法名称
		piReport.putFieldData(field, piDetail.getRskKeijHohoKbnNm());

		field = piReport.getField("xFknTnkiHohoNm"); // 回収スケジュール展開方法名称
		piReport.putFieldData(field, piDetail.getFknTnkiHohoNm());

		field = piReport.getField("xHasuChseNm"); // 減価償却端数調整方法名称
		piReport.putFieldData(field, piDetail.getHasuChseNm());

		field = piReport.getField("xComment");
		piReport.putFieldData(field, COMMENT);

		field = piReport.getField("xWarning1");
		piReport.putFieldData(field, piDetail.getWarning1());

		field = piReport.getField("xWarning2");
		piReport.putFieldData(field, piDetail.getWarning2());

		field = piReport.getField("xWarning3");
		piReport.putFieldData(field, piDetail.getWarning3());
	}

	/**
	 * 明細ヘッダ部出力.
	 * 
	 * @param piReport
	 *            レポート
	 * @param piDetail
	 *            出力情報
	 * @param piDateMode
	 *            西暦和暦モード
	 * @param piIdx
	 *            ページ識別
	 * @exception Exception
	 *                SQL実行例外
	 */
	private void meisaiHaedPrint(Report piReport, LACSMReportKaikeiMeisaiBean piDetail, String piDateMode, String piIdx) throws Exception {

		Field field = null;

		field = piReport.getField("xHead" + piIdx + "0");

		piReport.putFieldData(field, "支払年月");

		field = piReport.getField("xHead" + piIdx + "1");
		piReport.putFieldData(field, "お支払金額");
		field = piReport.getField("xHead" + piIdx + "2");

		piReport.putFieldData(field, "リース債務分");

		field = piReport.getField("xHead" + piIdx + "3");

		piReport.putFieldData(field, "うち利息分");

		field = piReport.getField("xHead" + piIdx + "4");
		piReport.putFieldData(field, "維持管理費");

		field = piReport.getField("xHead" + piIdx + "4_1");
		piReport.putFieldData(field, "　相当額　");

		field = piReport.getField("xHead" + piIdx + "5");
		piReport.putFieldData(field, "役務提供費");

		field = piReport.getField("xHead" + piIdx + "5_1");
		piReport.putFieldData(field, "　相当額　");

		field = piReport.getField("xHead" + piIdx + "6");

		piReport.putFieldData(field, "未経過");

		field = piReport.getField("xHead" + piIdx + "6_1");
		piReport.putFieldData(field, "リース料");

		field = piReport.getField("xHead" + piIdx + "7");
		piReport.putFieldData(field, "元本残高");
		field = piReport.getField("xHead" + piIdx + "8");
		piReport.putFieldData(field, "借方科目");
		field = piReport.getField("xHead" + piIdx + "9");
		piReport.putFieldData(field, "借方金額");
		field = piReport.getField("xHead" + piIdx + "10");
		piReport.putFieldData(field, "貸方科目");
		field = piReport.getField("xHead" + piIdx + "11");
		piReport.putFieldData(field, "貸方金額");
	}

	/**
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
