package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportMikeikaBBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportMikeikaBEntity;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportSsnSriEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.command.StringUtl;
import jp.co.pro_app.projframe.common.model.DBModelBase;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

/**
 * 帳票出力：未経過リース料期末残高別表Model.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSReportPDFMikeikaBWriter extends LACSReportPDFWriterBase {

	private static final String	HEAD_STOCK_NEW	= "1年超（固定負債）";

	private static final String	HEAD_STOCK_OLD	= "1年超";

	private static final String	HEAD_FLOW_NEW	= "1年内（流動負債）";

	private static final String	HEAD_FLOW_OLD	= "1年内";

	private static final String	TITLE_NEW		= "未経過リース料期末残高別表[新]";

	private static final String	TITLE_OLD		= "未経過リース料期末残高別表[旧]";

	private DBModelBase			modelBase		= null;

/* 2014/05/28 ADD START */
	private static final String	TITLE_TRD_HNTI_ITN_FL		= "ファイナンスリース取引に係る注記(所有権移転ファイナンスリース)";

	private static final String	TITLE_TRD_HNTI_ITNGI_FL		= "ファイナンスリース取引に係る注記(所有権移転外ファイナンスリース)";

	private static final String	TITLE_TRD_HNTI_OP			= "オペレーティングリース取引に係る注記（解約不能オペレーティングリース）";

	private static final String	TITLE_LAMT					= "未経過リース料";

	private static final String	TITLE_STAX					= "(　　未経過消費税　)";

	private static final String	STAX_K_ST					= "(";

	private static final String	STAX_K_ED					= ")";

	private String					index					= "";						// 修飾子
/* 2014/05/28 ADD END */
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
	public LACSReportPDFMikeikaBWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
		LACSReportMikeikaBEntity reportEntity = new LACSReportMikeikaBEntity(super.model, commonBean, piReportBean, this.acStd);
		LACSReportMikeikaBBean detail = null;

		try {
			reportEntity.setCon(super.con);

			piReportBean.setDataMax(reportEntity.execSQL());

			while (reportEntity.next()) {
				detail = new LACSReportMikeikaBBean();
				piReportBean.addMikeikaBBean(detail);

				detail.setLeaseCompany("");

				detail.setS1MikeikaZan01(reportEntity.getS1MikeikaZan01());
				detail.setS2MikeikaZan01(reportEntity.getS2MikeikaZan01());
				detail.setS3MikeikaZan01(reportEntity.getS3MikeikaZan01());
				detail.setS4MikeikaZan01(reportEntity.getS4MikeikaZan01());
				detail.setS5MikeikaZan01(reportEntity.getS5MikeikaZan01());
				detail.setS6MikeikaZan01(reportEntity.getS6MikeikaZan01());
				detail.setS7MikeikaZan01(reportEntity.getS7MikeikaZan01());
				// 2020/05/22 ADD START
				detail.setS8MikeikaZan01(reportEntity.getS8MikeikaZan01());
				detail.setS9MikeikaZan01(reportEntity.getS9MikeikaZan01());
				// 2020/05/22 ADD END

				detail.setS1MikeikaZan02(reportEntity.getS1MikeikaZan02());
				detail.setS2MikeikaZan02(reportEntity.getS2MikeikaZan02());
				detail.setS3MikeikaZan02(reportEntity.getS3MikeikaZan02());
				detail.setS4MikeikaZan02(reportEntity.getS4MikeikaZan02());
				detail.setS5MikeikaZan02(reportEntity.getS5MikeikaZan02());
				detail.setS6MikeikaZan02(reportEntity.getS6MikeikaZan02());
				detail.setS7MikeikaZan02(reportEntity.getS7MikeikaZan02());
				// 2020/05/22 ADD START
				detail.setS8MikeikaZan02(reportEntity.getS8MikeikaZan02());
				detail.setS9MikeikaZan02(reportEntity.getS9MikeikaZan02());
				// 2020/05/22 ADD END

				detail.setMikeikaZan01(reportEntity.getMikeikaZan01());
				detail.setMikeikaZan02(reportEntity.getMikeikaZan02());
				detail.setMikeikaZan03(reportEntity.getMikeikaZan03());

				detail.setLeasCompanyNm(reportEntity.getLeasCompanyNm());
				detail.setLeasUserNm(reportEntity.getLeasUserNm());

				detail.setAcShrKbnName(reportEntity.getAcShrKbnName());

/* 2014/05/28 ADD START */
				detail.setS1MikeikaStax01(reportEntity.getS1MikeikaStax01());
				detail.setS2MikeikaStax01(reportEntity.getS2MikeikaStax01());
				detail.setS3MikeikaStax01(reportEntity.getS3MikeikaStax01());
				detail.setS4MikeikaStax01(reportEntity.getS4MikeikaStax01());
				detail.setS5MikeikaStax01(reportEntity.getS5MikeikaStax01());
				detail.setS6MikeikaStax01(reportEntity.getS6MikeikaStax01());
				detail.setS7MikeikaStax01(reportEntity.getS7MikeikaStax01());
				// 2020/05/22 ADD START
				detail.setS8MikeikaStax01(reportEntity.getS8MikeikaStax01());
				detail.setS9MikeikaStax01(reportEntity.getS9MikeikaStax01());
				// 2020/05/22 ADD END

				detail.setS1MikeikaStax02(reportEntity.getS1MikeikaStax02());
				detail.setS2MikeikaStax02(reportEntity.getS2MikeikaStax02());
				detail.setS3MikeikaStax02(reportEntity.getS3MikeikaStax02());
				detail.setS4MikeikaStax02(reportEntity.getS4MikeikaStax02());
				detail.setS5MikeikaStax02(reportEntity.getS5MikeikaStax02());
				detail.setS6MikeikaStax02(reportEntity.getS6MikeikaStax02());
				detail.setS7MikeikaStax02(reportEntity.getS7MikeikaStax02());
				// 2020/05/22 ADD START
				detail.setS8MikeikaStax02(reportEntity.getS8MikeikaStax02());
				detail.setS9MikeikaStax02(reportEntity.getS9MikeikaStax02());
				// 2020/05/22 ADD END

				detail.setMikeikaStax01(reportEntity.getMikeikaStax01());
				detail.setMikeikaStax02(reportEntity.getMikeikaStax02());
				detail.setMikeikaStax03(reportEntity.getMikeikaStax03());

				detail.setTrdHnteKekaKbn(reportEntity.getTrdHnteKekaKbn());
/* 2014/05/28 ADD END   */

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
		File formFile = null;
		File datFile = null;

		File tmpFile = null; // 出力先ファイル
		FileOutputStream fout = null; // 出力ファイルストリーム

		Field field = null;

		LACSReportMikeikaBBean detail = null;

		Report report = null; // WebKCoreレポートオブジェクト

		LACSReportSsnSriEntity reportSsnSriEntity = new LACSReportSsnSriEntity(modelBase);

		String ssnSriNm1 = ""; // 資産種類名称（CODE=1）
		String ssnSriNm2 = ""; // 資産種類名称（CODE=2）
		String ssnSriNm3 = ""; // 資産種類名称（CODE=3）
		String ssnSriNm4 = ""; // 資産種類名称（CODE=4）
		String ssnSriNm5 = ""; // 資産種類名称（CODE=5）
		String ssnSriNm6 = ""; // 資産種類名称（CODE=6）
		String ssnSriNm7 = ""; // 資産種類名称（CODE=7）
		// 2020/05/22 ADD START
		String ssnSriNm8 = ""; // 資産種類名称（CODE=8）
		String ssnSriNm9 = ""; // 資産種類名称（CODE=9）
		// 2020/05/22 ADD END

		int intCnt = 1;

		reportSsnSriEntity.setCon(super.con);
		reportSsnSriEntity.execSQL();

		while (reportSsnSriEntity.next()) {

			switch (intCnt) {
				case 1:
					ssnSriNm1 = reportSsnSriEntity.getSsnSriNm();
					break;
				case 2:
					ssnSriNm2 = reportSsnSriEntity.getSsnSriNm();
					break;
				case 3:
					ssnSriNm3 = reportSsnSriEntity.getSsnSriNm();
					break;
				case 4:
					ssnSriNm4 = reportSsnSriEntity.getSsnSriNm();
					break;
				case 5:
					ssnSriNm5 = reportSsnSriEntity.getSsnSriNm();
					break;
				case 6:
					ssnSriNm6 = reportSsnSriEntity.getSsnSriNm();
					break;
				case 7:
					ssnSriNm7 = reportSsnSriEntity.getSsnSriNm();
					break;
				// 2020/05/22 ADD START
				case 8:
					ssnSriNm8 = reportSsnSriEntity.getSsnSriNm();
					break;
				case 9:
					ssnSriNm9 = reportSsnSriEntity.getSsnSriNm();
					break;
				// 2020/05/22 ADD END
				default:
					break;
			}
			intCnt++;

		}
		reportSsnSriEntity.close();

		try {
			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
			formDirectory = new File(wprlHomeDirectory, FORM_PATH);

			tmpFile = File.createTempFile("pdf07_" + prefix + "_", ".pdf", scratchDirectory);
			fout = new FileOutputStream(tmpFile);

			//2014/05/19 ADD START
			if ("1".equals(super.commonBean.getControlMikeikaBStaxDsp())) {
				formFile = new File(formDirectory, "MikeikaB_STAX.pdf");
				datFile = new File(formDirectory, "MikeikaB_STAX.dat");
			}else{
				formFile = new File(formDirectory, "MikeikaB.pdf");
				datFile = new File(formDirectory, "MikeikaB.dat");			
			}
			//formFile = new File(formDirectory, "MikeikaB.pdf");
			//datFile = new File(formDirectory, "MikeikaB.dat");
			//2014/05/19 ADD END

			report = new Report(formFile, datFile, fout);

			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				detail = piReportBean.getMikeikaBBean(i);

				report.createPage(1);

				field = report.getField("xTitle");
				report.putFieldData(field, super.acStd.equals(LACSDefine.AccountStandard.NEW_1) ? TITLE_NEW : TITLE_OLD);

				field = report.getField("xPage");
				report.putFieldData(field, ":" + (i + 1) + "/" + piReportBean.getDataMax());

				field = report.getField("xDate");
				report.putFieldData(field, ":" + super.convertReki(Convert.toString(new Date()), piDateMode));

				field = report.getField("xLeaseCompany");
				report.putFieldData(field, detail.getLeasCompanyNm());

				field = report.getField("xLeaseUser");
				report.putFieldData(field, detail.getLeasUserNm());

				field = report.getField("xTaisyouFrom");
				report.putFieldData(field, super.convertRekiLong(piReportBean.getTermFrom().getYYYYMMDD(), piDateMode));

				field = report.getField("xTaisyouTo");
				report.putFieldData(field, super.convertRekiLong(piReportBean.getTermTo().getYYYYMMDD(), piDateMode));

				field = report.getField("xFlow");
				report.putFieldData(field, super.acStd.equals(LACSDefine.AccountStandard.NEW_1) ? HEAD_FLOW_NEW : HEAD_FLOW_OLD);

				field = report.getField("xStock");
				report.putFieldData(field, super.acStd.equals(LACSDefine.AccountStandard.NEW_1) ? HEAD_STOCK_NEW : HEAD_STOCK_OLD);

/* 2014/05/28 ADD START */
				if ("1".equals(super.commonBean.getControlMikeikaBStaxDsp())) {
					switch (detail.getTrdHnteKekaKbn()) {
					case LACSDefine.TorihikiHanteiKekkaKbn.ITEN_FINANCE_LEAS_1:
						field = report.getField("xTrdHntiKekka");
						report.putFieldData(field, TITLE_TRD_HNTI_ITN_FL);				
						break;
					case LACSDefine.TorihikiHanteiKekkaKbn.ITEN_GAI_FINANCE_LEAS_2:
						field = report.getField("xTrdHntiKekka");
						report.putFieldData(field, TITLE_TRD_HNTI_ITNGI_FL);				
						break;
					case LACSDefine.TorihikiHanteiKekkaKbn.OPERATING_LEAS_3:
						field = report.getField("xTrdHntiKekka");
						report.putFieldData(field, TITLE_TRD_HNTI_OP);				
						break;
					default:
						break;
					}
					field = report.getField("xComment3");
					report.putFieldData(field, TITLE_LAMT);	
					field = report.getField("xComment4");
					report.putFieldData(field, TITLE_LAMT);	
					field = report.getField("xComment5");
					report.putFieldData(field, TITLE_LAMT);	
	
					field = report.getField("xComment6");
					report.putFieldData(field, TITLE_STAX);	
					field = report.getField("xComment7");
					report.putFieldData(field, TITLE_STAX);	
					field = report.getField("xComment8");
					report.putFieldData(field, TITLE_STAX);	

					// 20200827 arai start
					// 資産種類コードの追加に伴い、修正					
					for (int j = 1; j < 10; j++) {
						index = Convert.toString(j); // 明細行修飾子の設定
						field = report.getField("xS" + index + "01_k_st");
						report.putFieldData(field, STAX_K_ST);				
						field = report.getField("xS" + index + "02_k_st");
						report.putFieldData(field, STAX_K_ST);				
						field = report.getField("xS" + index + "03_k_st");
						report.putFieldData(field, STAX_K_ST);
					
						field = report.getField("xS" + index + "01_k_ed");
						report.putFieldData(field, STAX_K_ED);				
						field = report.getField("xS" + index + "02_k_ed");
						report.putFieldData(field, STAX_K_ED);				
						field = report.getField("xS" + index + "03_k_ed");
						report.putFieldData(field, STAX_K_ED);								
					}
					// 20200827 arai end
					
					field = report.getField("x01_k_st");
					report.putFieldData(field, STAX_K_ST);
					field = report.getField("x02_k_st");
					report.putFieldData(field, STAX_K_ST);
					field = report.getField("x03_k_st");
					report.putFieldData(field, STAX_K_ST);
	
					field = report.getField("x01_k_ed");
					report.putFieldData(field, STAX_K_ED);				
					field = report.getField("x02_k_ed");
					report.putFieldData(field, STAX_K_ED);				
					field = report.getField("x03_k_ed");
					report.putFieldData(field, STAX_K_ED);								
	
					}
/* 2014/05/28 ADD END   */
				field = report.getField("xS1MikeikaZan01");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS1MikeikaZan01())); 

				field = report.getField("xS2MikeikaZan01");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS2MikeikaZan01()));

				field = report.getField("xS3MikeikaZan01");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS3MikeikaZan01()));

				field = report.getField("xS4MikeikaZan01");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS4MikeikaZan01()));

				field = report.getField("xS5MikeikaZan01");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS5MikeikaZan01()));

				field = report.getField("xS6MikeikaZan01");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS6MikeikaZan01()));

				field = report.getField("xS7MikeikaZan01");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS7MikeikaZan01()));

				// 2020/05/22 ADD START
				field = report.getField("xS8MikeikaZan01");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS8MikeikaZan01()));

				field = report.getField("xS9MikeikaZan01");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS9MikeikaZan01()));
				// 2020/05/22 ADD END

				field = report.getField("xS1MikeikaZan02");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS1MikeikaZan02()));

				field = report.getField("xS2MikeikaZan02");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS2MikeikaZan02()));

				field = report.getField("xS3MikeikaZan02");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS3MikeikaZan02()));

				field = report.getField("xS4MikeikaZan02");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS4MikeikaZan02()));

				field = report.getField("xS5MikeikaZan02");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS5MikeikaZan02()));

				field = report.getField("xS6MikeikaZan02");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS6MikeikaZan02()));

				field = report.getField("xS7MikeikaZan02");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS7MikeikaZan02()));

				// 2020/05/22 ADD START
				field = report.getField("xS8MikeikaZan02");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS8MikeikaZan02()));

				field = report.getField("xS9MikeikaZan02");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS9MikeikaZan02()));
				// 2020/05/22 ADD END

				field = report.getField("xS1MikeikaZan03");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS1MikeikaZan01() + detail.getS1MikeikaZan02()));

				field = report.getField("xS2MikeikaZan03");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS2MikeikaZan01() + detail.getS2MikeikaZan02()));

				field = report.getField("xS3MikeikaZan03");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS3MikeikaZan01() + detail.getS3MikeikaZan02()));

				field = report.getField("xS4MikeikaZan03");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS4MikeikaZan01() + detail.getS4MikeikaZan02()));

				field = report.getField("xS5MikeikaZan03");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS5MikeikaZan01() + detail.getS5MikeikaZan02()));

				field = report.getField("xS6MikeikaZan03");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS6MikeikaZan01() + detail.getS6MikeikaZan02()));

				field = report.getField("xS7MikeikaZan03");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS7MikeikaZan01() + detail.getS7MikeikaZan02()));

				// 2020/05/22 ADD START
				field = report.getField("xS8MikeikaZan03");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS8MikeikaZan01() + detail.getS8MikeikaZan02()));

				field = report.getField("xS9MikeikaZan03");
				report.putFieldData(field, StringUtl.formatNumber(detail.getS9MikeikaZan01() + detail.getS9MikeikaZan02()));
				// 2020/05/22 ADD END

				field = report.getField("xMikeikaZan01");
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaZan01()));

				field = report.getField("xMikeikaZan02");
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaZan02()));

				field = report.getField("xMikeikaZan03");
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaZan03()));

/* 2014/05/28 ADD START */
				if ("1".equals(super.commonBean.getControlMikeikaBStaxDsp())) {
					field = report.getField("xS1MikeikaStax01");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS1MikeikaStax01()));
	
					field = report.getField("xS2MikeikaStax01");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS2MikeikaStax01()));
	
					field = report.getField("xS3MikeikaStax01");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS3MikeikaStax01()));
	
					field = report.getField("xS4MikeikaStax01");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS4MikeikaStax01()));
	
					field = report.getField("xS5MikeikaStax01");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS5MikeikaStax01()));
	
					field = report.getField("xS6MikeikaStax01");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS6MikeikaStax01()));
	
					field = report.getField("xS7MikeikaStax01");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS7MikeikaStax01()));
	
					// 20200826 arai start
					field = report.getField("xS8MikeikaStax01");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS8MikeikaStax01()));
					
					field = report.getField("xS9MikeikaStax01");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS9MikeikaStax01()));													
					// 20200826 arai end
					
					field = report.getField("xS1MikeikaStax02");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS1MikeikaStax02()));
	
					field = report.getField("xS2MikeikaStax02");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS2MikeikaStax02()));
	
					field = report.getField("xS3MikeikaStax02");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS3MikeikaStax02()));
	
					field = report.getField("xS4MikeikaStax02");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS4MikeikaStax02()));
	
					field = report.getField("xS5MikeikaStax02");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS5MikeikaStax02()));
	
					field = report.getField("xS6MikeikaStax02");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS6MikeikaStax02()));
	
					field = report.getField("xS7MikeikaStax02");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS7MikeikaStax02()));
					
					// 20200826 arai start
					field = report.getField("xS8MikeikaStax02");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS8MikeikaStax02()));
					
					field = report.getField("xS9MikeikaStax02");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS9MikeikaStax02()));
					// 20200826 arai end
					
					field = report.getField("xS1MikeikaStax03");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS1MikeikaStax01() + detail.getS1MikeikaStax02()));
	
					field = report.getField("xS2MikeikaStax03");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS2MikeikaStax01() + detail.getS2MikeikaStax02()));
	
					field = report.getField("xS3MikeikaStax03");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS3MikeikaStax01() + detail.getS3MikeikaStax02()));
	
					field = report.getField("xS4MikeikaStax03");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS4MikeikaStax01() + detail.getS4MikeikaStax02()));
	
					field = report.getField("xS5MikeikaStax03");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS5MikeikaStax01() + detail.getS5MikeikaStax02()));
	
					field = report.getField("xS6MikeikaStax03");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS6MikeikaStax01() + detail.getS6MikeikaStax02()));
	
					field = report.getField("xS7MikeikaStax03");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS7MikeikaStax01() + detail.getS7MikeikaStax02()));
										
					// 20200826 arai start
					field = report.getField("xS8MikeikaStax03");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS8MikeikaStax01() + detail.getS8MikeikaStax02()));
					
					field = report.getField("xS9MikeikaStax03");
					report.putFieldData(field, StringUtl.formatNumber(detail.getS9MikeikaStax01() + detail.getS9MikeikaStax02()));					
					// 20200826 arai end
					
					field = report.getField("xMikeikaStax01");
					report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaStax01()));
	
					field = report.getField("xMikeikaStax02");
					report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaStax02()));
	
					field = report.getField("xMikeikaStax03");
					report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaStax03()));
				}
/* 2014/05/28 ADD END   */
				field = report.getField("xComment");

				report.putFieldData(field, super.convertReki(DateUtl.add(Calendar.DAY_OF_MONTH, 1, Convert.toDateString(piReportBean.getTermTo().getYYYYMMDD())), piDateMode) + "～" + super.convertReki(DateUtl.add(Calendar.YEAR, 1, Convert.toDateString(piReportBean.getTermTo().getYYYYMMDD())), piDateMode) + "、1年超は" + super.convertReki(DateUtl.add(Calendar.DAY_OF_MONTH, 1, DateUtl.add(Calendar.YEAR, 1, Convert.toDateString(piReportBean.getTermTo().getYYYYMMDD()))), piDateMode) + "以降　を指す。");

				field = report.getField("xKaikeiSyoriHouhou");
				report.putFieldData(field, detail.getAcShrKbnName());

				field = report.getField("xComment2");
				report.putFieldData(field, COMMENT);

				field = report.getField("xSsnSri1");
				report.putFieldData(field, ssnSriNm1);
				field = report.getField("xSsnSri2");
				report.putFieldData(field, ssnSriNm2);
				field = report.getField("xSsnSri3");
				report.putFieldData(field, ssnSriNm3);
				field = report.getField("xSsnSri4");
				report.putFieldData(field, ssnSriNm4);
				field = report.getField("xSsnSri5");
				report.putFieldData(field, ssnSriNm5);
				field = report.getField("xSsnSri6");
				report.putFieldData(field, ssnSriNm6);
				field = report.getField("xSsnSri7");
				report.putFieldData(field, ssnSriNm7);
				// 2020/05/22 ADD START
				field = report.getField("xSsnSri8");
				report.putFieldData(field, ssnSriNm8);
				field = report.getField("xSsnSri9");
				report.putFieldData(field, ssnSriNm9);
				// 2020/05/22 ADD END

			}

			report.close();
			report = null;

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
