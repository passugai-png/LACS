package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportTyukiBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportTyukiEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

/**
 * 帳票出力：注記書類作成基準書 Model.
 * 
 * @author fukuhara
 * @version 20080409
 */
public class LACSReportPDFTyukiWriter extends LACSReportPDFWriterBase {

	private Report				report	= null; // WebKCoreレポートオブジェクト

	private LACSReportTyukiBean	detail	= null;
	
	//ADD Liu.ZJ LACS帳票バッチ対応 2013/04/11 start
	File tmpFile = null; // 出力先ファイル
	
	FileOutputStream fout = null; // 出力ファイルストリーム
	
	private boolean batchFlg = false; //　バッチ実行フラグ
	
	private boolean batchStartFlg = false; //　バッチ出力開始フラグ
	
	/**　バッチ実行フラグを設定する
	 * @param boolean batchFlg
	 */
	public void setBatchFlg(boolean batchFlg) {
		this.batchFlg = batchFlg;
	}
	
	/**　作成しだPDFファイル名を返す
	 * @return String 作成しだPDFファイル名
	 */
	public String getFileName() {
		return tmpFile != null ? tmpFile.getName() : ""; 
	}
	
	/**　バッチ出力開始
	 * @param piContext
	 * @throws Exception
	 */
	public void startReport(ServletContext piContext) throws Exception {
		File wprlHomeDirectory = new File(PdfProperties.getInstance().getProperty(PdfProperties.WKC_PDF_HOME));
		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		formDirectory = new File(wprlHomeDirectory, FORM_PATH);
		File formFile = null;
		File datFile = null;
		if ("1".equals(super.commonBean.getControlTyukiPdf())) {
			tmpFile = File.createTempFile("pdf04_agl_", ".pdf", scratchDirectory);
		}
		else {
			tmpFile = File.createTempFile("pdf04_", ".pdf", scratchDirectory);
		}
		fout = new FileOutputStream(tmpFile);
		if ("1".equals(super.commonBean.getControlTyukiPdf())) {
			formFile = new File(formDirectory, "Tyuki_agl.pdf");
			datFile = new File(formDirectory, "Tyuki_agl.dat");
		}
		else {
			formFile = new File(formDirectory, "Tyuki.pdf");
			datFile = new File(formDirectory, "Tyuki.dat");
		}
		report = new Report(formFile, datFile, fout);
	}
	
	/**
	 * バッチ出力を終わらせる
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
	//ADD Liu.ZJ LACS帳票バッチ対応 2013/04/11 end
	
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
	public LACSReportPDFTyukiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
	public void getData(LACSReportBean piReportBean) throws SQLException {
		LACSReportTyukiEntity reportEntity = new LACSReportTyukiEntity(super.model, commonBean, piReportBean, this.acStd);
		LACSReportTyukiBean tyukiDetail = null;

		try {
			reportEntity.setCon(super.con);

			piReportBean.setDataMax(reportEntity.execSQL());

			while (reportEntity.next()) {
				tyukiDetail = new LACSReportTyukiBean();
				piReportBean.addTyukiBean(tyukiDetail);

				tyukiDetail.setLeaseCompanyNm(reportEntity.getLeaseCompanyNm());
				tyukiDetail.setLeaseCompanyZipCd(reportEntity.getLeaseCompanyZipCd());
				tyukiDetail.setLeaseCompanyAddr1(reportEntity.getLeaseCompanyAddr1());
				tyukiDetail.setLeaseCompanyAddr2(reportEntity.getLeaseCompanyAddr2());

				tyukiDetail.setLeaseUserNm(reportEntity.getLeaseUserNm());
				tyukiDetail.setLeaseUserZipCd(reportEntity.getLeaseUserZipCd());
				tyukiDetail.setLeaseUserAddr1(reportEntity.getLeaseUserAddr1());
				tyukiDetail.setLeaseUserAddr2(reportEntity.getLeaseUserAddr2());
				tyukiDetail.setOldItenSyoukyakuYukei(reportEntity.getOldItenSyoukyakuYukei());
				tyukiDetail.setOldItenSyoukyakuMukei(reportEntity.getOldItenSyoukyakuMukei());
				tyukiDetail.setOldItenGaiSyoukyakuYukei(reportEntity.getOldItenGaiSyoukyakuYukei());
				tyukiDetail.setOldItenGaiSyoukyakuMukei(reportEntity.getOldItenGaiSyoukyakuMukei());
				tyukiDetail.setOldItenGaiSyoukyakuHasu(reportEntity.getOldItenGaiSyoukyakuHasu());
				tyukiDetail.setOldRisokuKeisan(reportEntity.getOldRisokuKeisan());
				tyukiDetail.setOldRisokuHukin(reportEntity.getOldRisokuHukin());
				tyukiDetail.setOldRisokuHasu(reportEntity.getOldRisokuHasu());
				tyukiDetail.setOldJyuyouIji(reportEntity.getOldJyuyouIji());
				tyukiDetail.setOldJyuyouEkimu(reportEntity.getOldJyuyouEkimu());

				tyukiDetail.setNewItenSyoukyakuYukei(reportEntity.getNewItenSyoukyakuYukei());
				tyukiDetail.setNewItenSyoukyakuMukei(reportEntity.getNewItenSyoukyakuMukei());
				tyukiDetail.setNewItenGaiSyoukyakuYukei(reportEntity.getNewItenGaiSyoukyakuYukei());
				tyukiDetail.setNewItenGaiSyoukyakuMukei(reportEntity.getNewItenGaiSyoukyakuMukei());
				tyukiDetail.setNewItenGaiSyoukyakuHasu(reportEntity.getNewItenGaiSyoukyakuHasu());
				tyukiDetail.setNewRisokuKeisan(reportEntity.getNewRisokuKeisan());
				tyukiDetail.setNewRisokuHukin(reportEntity.getNewRisokuHukin());
				tyukiDetail.setNewRisokuHasu(reportEntity.getNewRisokuHasu());
				tyukiDetail.setNewJyuyouIji(reportEntity.getNewJyuyouIji());
				tyukiDetail.setNewJyuyouEkimu(reportEntity.getNewJyuyouEkimu());
				if ("1".equals(super.commonBean.getShowTyukiComment())) {
					tyukiDetail.setTyukiComment1(reportEntity.getTyukiComment1());
					tyukiDetail.setTyukiComment2(reportEntity.getTyukiComment2());
				}

			}

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
	public String makePDF(LACSReportBean piReportBean, String piDateMode, ServletContext piContext) throws Exception {

		File wprlHomeDirectory = new File(PdfProperties.getInstance().getProperty(PdfProperties.WKC_PDF_HOME));
		
		//DELETE Liu.ZJ LACS帳票バッチ対応 2013/04/11 start
		//File formFile = null;
		//File datFile = null;
		//DELETE Liu.ZJ LACS帳票バッチ対応 2013/04/11 end
		
		Field field = null;

		//DELETE Liu.ZJ LACS帳票バッチ対応 2013/04/11 start
		//File tmpFile = null; // 出力先ファイル
		//FileOutputStream fout = null; // 出力ファイルストリーム
		//DELETE Liu.ZJ LACS帳票バッチ対応 2013/04/11 end
		
		int addLen;

		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		formDirectory = new File(wprlHomeDirectory, FORM_PATH);
		//DELETE Liu.ZJ LACS帳票バッチ対応 2013/04/11 start
		//report = null; // WebKCoreレポートオブジェクト
		//DELETE Liu.ZJ LACS帳票バッチ対応 2013/04/11 end
		detail = null;

		try {
			//MODIFY Liu.ZJ LACS帳票バッチ対応 2013/04/11 start
			//if ("1".equals(super.commonBean.getControlTyukiPdf())) {
			//tmpFile = File.createTempFile("pdf04_agl_", ".pdf", scratchDirectory);
			//}
			//else {
			//	tmpFile = File.createTempFile("pdf04_", ".pdf", scratchDirectory);
			//}
			//fout = new FileOutputStream(tmpFile);
			//if ("1".equals(super.commonBean.getControlTyukiPdf())) {
			//	formFile = new File(formDirectory, "Tyuki_agl.pdf");
			//	datFile = new File(formDirectory, "Tyuki_agl.dat");
			//}
			//else {
			//	formFile = new File(formDirectory, "Tyuki.pdf");
			//	datFile = new File(formDirectory, "Tyuki.dat");
			//}
			
			//report = new Report(formFile, datFile, fout);
			if(!batchFlg){
				
				File formFile = null;
				File datFile = null;
				
				if ("1".equals(super.commonBean.getControlTyukiPdf())) {
					tmpFile = File.createTempFile("pdf04_agl_", ".pdf", scratchDirectory);
				}
				else {
					tmpFile = File.createTempFile("pdf04_", ".pdf", scratchDirectory);
				}
				fout = new FileOutputStream(tmpFile);
				if ("1".equals(super.commonBean.getControlTyukiPdf())) {
					formFile = new File(formDirectory, "Tyuki_agl.pdf");
					datFile = new File(formDirectory, "Tyuki_agl.dat");
				}
				else {
					formFile = new File(formDirectory, "Tyuki.pdf");
					datFile = new File(formDirectory, "Tyuki.dat");
				}
				
				report = new Report(formFile, datFile, fout);
			}
			//MODIFY Liu.ZJ LACS帳票バッチ対応 2013/04/11 end
			
			//ADD ren.SL LACS帳票バッチ対応 2013/04/11 start
			if (batchFlg && !batchStartFlg) {
				this.startReport(piContext);
				batchStartFlg = true;
			}
			//ADD ren.SL LACS帳票バッチ対応 2013/04/11 end
			
			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				detail = piReportBean.getTyukiBean(i);
				report.createPage(1);

				field = report.getField("xDate");
				report.putFieldData(field, super.convertReki(Convert.toString(new Date()), piDateMode));

				field = report.getField("xLeaseUserNm");
				if ("1".equals(super.commonBean.getControlTyukiPdf())) {
					if (detail.getLeaseUserNm().length() <= 16) {
						field.setFontSize(12);
					}
					else if (detail.getLeaseUserNm().length() <= 18) {
						field.setFontSize(10.5f);
					}
					else if (detail.getLeaseUserNm().length() <= 20) {
						field.setFontSize(10);
					}
					else if (detail.getLeaseUserNm().length() <= 22) {
						field.setFontSize(9);
					}
					else {
						field.setFontSize(8);
					}
				}
				
				report.putFieldData(field, detail.getLeaseUserNm() + "　御中");

				if ("1".equals(super.commonBean.getControlTyukiPdf())) {
					field = report.getField("xLeaseUserZipCd");
					report.putFieldData(field, detail.getLeaseUserZipCd());

					addLen = detail.getLeaseUserAddr1().length() < detail.getLeaseUserAddr2().length() ? detail.getLeaseUserAddr2().length() : detail.getLeaseUserAddr1().length();

					field = report.getField("xLeaseUserAddr1");

					if (addLen <= 20) {
						field.setFontSize(10.5f);
					}
					else if (addLen <= 22) {
						field.setFontSize(9.5f);
					}
					else if (addLen <= 24) {
						field.setFontSize(9);
					}
					else if (addLen <= 26) {
						field.setFontSize(8.5f);
					}
					else if (addLen <= 28) {
						field.setFontSize(8);
					}
					else {
						field.setFontSize(7);
					}
					report.putFieldData(field, detail.getLeaseUserAddr1());

					field = report.getField("xLeaseUserAddr2");

					if (addLen <= 20) {
						field.setFontSize(10.5f);
					}
					else if (addLen <= 22) {
						field.setFontSize(9.5f);
					}
					else if (addLen <= 24) {
						field.setFontSize(9);
					}
					else if (addLen <= 26) {
						field.setFontSize(8.5f);
					}
					else if (addLen <= 28) {
						field.setFontSize(8);
					}
					else {
						field.setFontSize(7);
					}
					report.putFieldData(field, detail.getLeaseUserAddr2());

				}

				field = report.getField("xLeaseCompanyNm");
				report.putFieldData(field, detail.getLeaseCompanyNm());

				field = report.getField("xLeaseCompanyZipCd");
				report.putFieldData(field, detail.getLeaseCompanyZipCd());
				field = report.getField("xLeaseCompanyAddr1");
				report.putFieldData(field, detail.getLeaseCompanyAddr1());
				field = report.getField("xLeaseCompanyAddr2");
				report.putFieldData(field, detail.getLeaseCompanyAddr2());

				String termFrom = super.convertRekiLong(Convert.toString(Convert.toDate(Convert.toDateString(piReportBean.getTermFrom().getYYYYMMDD()))), piDateMode);
				String termTo = super.convertRekiLong(Convert.toString(Convert.toDate(Convert.toDateString(piReportBean.getTermTo().getYYYYMMDD()))), piDateMode);
				field = report.getField("xTerm");
				report.putFieldData(field, termFrom + " ～ " + termTo);

				field = report.getField("xKaikeiSyori");
				if ("0".equals(piReportBean.getKaikeiSyori())) {

					report.putFieldData(field, "詳細注記");

				}
				else {

					report.putFieldData(field, "簡略注記");

				}

				// 除外条件-旧会計基準
				field = report.getField("xOldKeiyakuGaku");
				if ("0".equals(piReportBean.getOldKeiyakuGaku())) {
					report.putFieldData(field, "除く");
				}
				else {
					report.putFieldData(field, "除かない");
				}
				field = report.getField("xOldLeaseKikan");
				if ("0".equals(piReportBean.getOldLeaseKikan())) {
					report.putFieldData(field, "除く");
				}
				else {
					report.putFieldData(field, "除かない");
				}
				field = report.getField("xOldSaiLease");
				if ("0".equals(piReportBean.getOldSaiLease())) {
					report.putFieldData(field, "除く");
				}
				else {
					report.putFieldData(field, "除かない");
				}
				field = report.getField("xOldTyutoKaiyaku");
				if ("0".equals(piReportBean.getOldTyutoKaiyaku())) {
					report.putFieldData(field, "除く");
				}
				else {
					report.putFieldData(field, "除かない");
				}
				// 除外条件-新会計基準
				field = report.getField("xNewKeiyakuGaku");
				if ("0".equals(piReportBean.getNewKeiyakuGaku())) {
					report.putFieldData(field, "除く");
				}
				else {
					report.putFieldData(field, "除かない");
				}
				field = report.getField("xNewLeaseKikan");
				if ("0".equals(piReportBean.getNewLeaseKikan())) {
					report.putFieldData(field, "除く");
				}
				else {
					report.putFieldData(field, "除かない");
				}
				field = report.getField("xNewSaiLease");
				if ("0".equals(piReportBean.getNewSaiLease())) {
					report.putFieldData(field, "除く");
				}
				else {
					report.putFieldData(field, "除かない");
				}
				field = report.getField("xNewTyutoKaiyaku");
				if ("0".equals(piReportBean.getNewTyutoKaiyaku())) {
					report.putFieldData(field, "除く");
				}
				else {
					report.putFieldData(field, "除かない");
				}

				field = report.getField("xOldItenSyoukyakuYukei");
				report.putFieldData(field, detail.getOldItenSyoukyakuYukei());
				field = report.getField("xOldItenSyoukyakuMukei");
				report.putFieldData(field, detail.getOldItenSyoukyakuMukei());
				field = report.getField("xOldItenGaiSyoukyakuYukei");
				report.putFieldData(field, detail.getOldItenGaiSyoukyakuYukei());
				field = report.getField("xOldItenGaiSyoukyakuMukei");
				report.putFieldData(field, detail.getOldItenGaiSyoukyakuMukei());
				field = report.getField("xOldItenGaiSyoukyakuHasu");
				report.putFieldData(field, detail.getOldItenGaiSyoukyakuHasu());
				field = report.getField("xOldRisokuKeisan");
				report.putFieldData(field, detail.getOldRisokuKeisan());
				field = report.getField("xOldRisokuHukin");
				report.putFieldData(field, detail.getOldRisokuHukin());
				field = report.getField("xOldRisokuHasu");
				report.putFieldData(field, detail.getOldRisokuHasu());

				field = report.getField("xOldJyuyouIji");
				if ("0".equals(detail.getOldJyuyouIji())) {
					report.putFieldData(field, "なし");
				}
				else {
					report.putFieldData(field, "あり");
				}

				field = report.getField("xOldJyuyouEkimu");
				if ("0".equals(detail.getOldJyuyouEkimu())) {
					report.putFieldData(field, "なし");
				}
				else {
					report.putFieldData(field, "あり");
				}

				field = report.getField("xNewItenSyoukyakuYukei");
				report.putFieldData(field, detail.getNewItenSyoukyakuYukei());
				field = report.getField("xNewItenSyoukyakuMukei");
				report.putFieldData(field, detail.getNewItenSyoukyakuMukei());
				field = report.getField("xNewItenGaiSyoukyakuYukei");
				report.putFieldData(field, detail.getNewItenGaiSyoukyakuYukei());
				field = report.getField("xNewItenGaiSyoukyakuMukei");
				report.putFieldData(field, detail.getNewItenGaiSyoukyakuMukei());
				field = report.getField("xNewItenGaiSyoukyakuHasu");
				report.putFieldData(field, detail.getNewItenGaiSyoukyakuHasu());
				field = report.getField("xNewRisokuKeisan");
				report.putFieldData(field, detail.getNewRisokuKeisan());
				field = report.getField("xNewRisokuHukin");
				report.putFieldData(field, detail.getNewRisokuHukin());
				field = report.getField("xNewRisokuHasu");
				report.putFieldData(field, detail.getNewRisokuHasu());

				field = report.getField("xNewJyuyouIji");
				if ("0".equals(detail.getNewJyuyouIji())) {
					report.putFieldData(field, "なし");
				}
				else {
					report.putFieldData(field, "あり");
				}

				field = report.getField("xNewJyuyouEkimu");
				if ("0".equals(detail.getNewJyuyouEkimu())) {
					report.putFieldData(field, "なし");
				}
				else {
					report.putFieldData(field, "あり");
				}

				if ("1".equals(super.commonBean.getShowTyukiComment())) {
					field = report.getField("xTyukiComment1");
					report.putFieldData(field, detail.getTyukiComment1());
					field = report.getField("xTyukiComment2");
					report.putFieldData(field, detail.getTyukiComment2());
				}

			}

			//MODIFY Liu.ZJ LACS帳票バッチ対応 2013/04/11 start
			//report.close();
			//report = null;
			if (!batchFlg) {
				report.close();
				report = null;
			}
			//MODIFY Liu.ZJ LACS帳票バッチ対応 2013/04/11 end
			return tmpFile.getName();

		}
		finally {
			//MODIFY Liu.ZJ LACS帳票バッチ対応 2013/04/11 start
			//if (report != null) {
			//try {
			//	report.close();
			//}
			//catch (ReportException e) {
			//}
			//report = null;
			//}
			//if (fout != null) {
			//	try {
			//		fout.close();
			//	}
			//	catch (Exception e) {
			//		fout = null;
			//	}
			//}
			if(!batchFlg){
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
			//MODIFY Liu.ZJ LACS帳票バッチ対応 2013/04/11 end
			}
		}
	}
	
	

}
