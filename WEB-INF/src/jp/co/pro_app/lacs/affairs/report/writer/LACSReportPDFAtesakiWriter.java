package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportAtesakiBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;


public class LACSReportPDFAtesakiWriter extends LACSReportPDFWriterBase {

	private Report				report	= null; // WebKCoreレポートオブジェクト

	private static int font_size = 8;
	private static String font_name = "MSGothic";
	File tmpFile = null; 
	FileOutputStream fout = null; 
	
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
	public LACSReportPDFAtesakiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
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
		File formFile = null;
		File datFile = null;
		File wprlHomeDirectory = null;
		
		try {
			wprlHomeDirectory = new File(PdfProperties.getInstance().getProperty(PdfProperties.WKC_PDF_HOME));
			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
			formDirectory = new File(wprlHomeDirectory, FORM_PATH);
			formFile = new File(formDirectory, "Atesaki.pdf");
			datFile = new File(formDirectory, "Atesaki.dat");
			tmpFile = File.createTempFile("pdf07_", ".pdf", scratchDirectory);
			fout = new FileOutputStream(tmpFile);
			report = new Report(formFile, datFile, fout);
			Field field = null;
			
			for (int i =0; i < piReportBean.getListCount(); i++) {
				LACSReportAtesakiBean atesakiBean = piReportBean.getAtesakiBean(i);
				report.createPage(1);
				
				field = report.getField("xYinsatuDate");
				field.setFontName(font_name);
				field.setFontSize(9);
				report.putFieldData(field, Convert.toString(new Date(), Convert.FORMAT_YYYY_MM_DD_JP));
				
				field = report.getField("xYuubin");
				field.setFontName(font_name);
				field.setFontSize(font_size);
				report.putFieldData(field, atesakiBean.getLeaseCompanyZipCd());
				
				field = report.getField("xXyusyo1");
				field.setFontName(font_name);
				field.setFontSize(font_size);
				report.putFieldData(field, atesakiBean.getLeaseCompanyAddr1());
				
				field = report.getField("xXyusyo2");
				field.setFontName(font_name);
				field.setFontSize(font_size);
				report.putFieldData(field, atesakiBean.getLeaseCompanyAddr2());
				
				if (atesakiBean.getTantosyaName() != null && !atesakiBean.getTantosyaName().trim().equals("")) {
					field = report.getField("xAtesaki");
					field.setFontName(font_name);
					field.setFontSize(font_size);
					report.putFieldData(field, atesakiBean.getLeaseCompanyNm());
					
					field = report.getField("xTantosya");
					field.setFontName(font_name);
					field.setFontSize(font_size);
					report.putFieldData(field, atesakiBean.getTantosyaName() + "　御中");
				} else {
					field = report.getField("xAtesaki");
					field.setFontName(font_name);
					field.setFontSize(font_size);
					report.putFieldData(field, atesakiBean.getLeaseCompanyNm() + "　御中");
				}
			}
			
			return tmpFile.getName();
		}
		finally {
			
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

	@Override
	protected void getData(LACSReportBean piReportBean) throws SQLException {
	}
}
