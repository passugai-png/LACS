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
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportGoukeiBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportGoukeiEntity;
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
 * 帳票出力：リース会計注記合計表Model.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSReportPDFGoukeiWriter extends LACSReportPDFWriterBase {

	private static final String	HEAD_STOCK_NEW	= "1年超（固定負債）";

	private static final String	HEAD_STOCK_OLD	= "1年超";

	private static final String	HEAD_FLOW_NEW	= "1年内（流動負債）";

	private static final String	HEAD_FLOW_OLD	= "1年内";

	private static final String	TITLE_COMP		= "リース会社　：";

	private static final String	TITLE_USER		= "開示先　　　：";

	private static final String	TITLE_NEW		= "リース契約注記合計表[新]";

	private static final String	TITLE_OLD		= "リース契約注記合計表[旧]";

	private static final String	KAIKEI_TITLE	= "会計処理方法：";

	private static final String	TOUKI_TITLE		= "当期の支払リース料、減価償却費相当額、支払利息相当額";

	private static final String	SKK_HOHO_TITLE	= "減価償却費相当額の算定方法は、";

	private DBModelBase			modelBase		= null;
	
	//ADD zhen.XB LACS帳票バッチ対応  2013/04/11 start
	private FileOutputStream fout = null; // 出力ファイルストリーム
	
	private Report report = null;

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
		tmpFile = File.createTempFile("pdf01_" + prefix + "_", ".pdf", scratchDirectory);
		fout = new FileOutputStream(tmpFile);
		File formFile = new File(formDirectory, "Goukei.pdf");
		File datFile = new File(formDirectory, "Goukei.dat");
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
	//ADD zhen.XB LACS帳票バッチ対応  2013/04/11 end
	
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
	public LACSReportPDFGoukeiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
		LACSReportGoukeiEntity reportEntity = new LACSReportGoukeiEntity(super.model, commonBean, piReportBean, this.acStd);
		LACSReportGoukeiBean detail = null;

		try {
			reportEntity.setCon(super.con);

			piReportBean.setDataMax(reportEntity.execSQL());

			while (reportEntity.next()) {
				detail = new LACSReportGoukeiBean();
				piReportBean.addGoukeiBean(detail);

				detail.setLeaseCompany("");

				detail.setSyutoku01(reportEntity.getSyutoku01());
				detail.setSyutoku02(reportEntity.getSyutoku02());
				detail.setSyutoku03(reportEntity.getSyutoku03());
				detail.setSyutoku04(reportEntity.getSyutoku04());
				detail.setSyutoku05(reportEntity.getSyutoku05());
				detail.setSyutoku06(reportEntity.getSyutoku06());
				detail.setSyutoku07(reportEntity.getSyutoku07());
				// 2020/05/22 ADD START
				detail.setSyutoku08(reportEntity.getSyutoku08());
				detail.setSyutoku09(reportEntity.getSyutoku09());
				// 2020/05/22 ADD END
				detail.setSyutokuTotal(reportEntity.getSyutokuTotal());
				detail.setGenka01(reportEntity.getGenka01());
				detail.setGenka02(reportEntity.getGenka02());
				detail.setGenka03(reportEntity.getGenka03());
				detail.setGenka04(reportEntity.getGenka04());
				detail.setGenka05(reportEntity.getGenka05());
				detail.setGenka06(reportEntity.getGenka06());
				detail.setGenka07(reportEntity.getGenka07());
				// 2020/05/22 ADD START
				detail.setGenka08(reportEntity.getGenka08());
				detail.setGenka09(reportEntity.getGenka09());
				// 2020/05/22 ADD END
				detail.setGenkaTotal(reportEntity.getGenkaTotal());
				detail.setZandaka01(reportEntity.getZandaka01());
				detail.setZandaka02(reportEntity.getZandaka02());
				detail.setZandaka03(reportEntity.getZandaka03());
				detail.setZandaka04(reportEntity.getZandaka04());
				detail.setZandaka05(reportEntity.getZandaka05());
				detail.setZandaka06(reportEntity.getZandaka06());
				detail.setZandaka07(reportEntity.getZandaka07());
				// 2020/05/22 ADD START
				detail.setZandaka08(reportEntity.getZandaka08());
				detail.setZandaka09(reportEntity.getZandaka09());
				// 2020/05/22 ADD END
				detail.setZandakaTotal(reportEntity.getZandakaTotal());
				detail.setMikeikaZan01(reportEntity.getMikeikaZan01());
				detail.setMikeikaZan02(reportEntity.getMikeikaZan02());
				detail.setMikeikaZan03(reportEntity.getMikeikaZan03());
				detail.setToukiSiharai(reportEntity.getToukiSiharai());
				detail.setToukiGenka(reportEntity.getToukiGenka());
				detail.setToukiRisoku(reportEntity.getToukiRisoku());
				detail.setMikeika01(reportEntity.getMikeika01());
				detail.setMikeika02(reportEntity.getMikeika02());
				detail.setMikeika03(reportEntity.getMikeika03());
				detail.setLeasCompanyNm(reportEntity.getLeasCompanyNm());
				detail.setLeasUserNm(reportEntity.getLeasUserNm());
				detail.setYukeiSkkHoho(reportEntity.getYukeiSkkHoho());
				detail.setMukeiSkkHoho(reportEntity.getMukeiSkkHoho());
				detail.setRskClcHoho(reportEntity.getRskClcHoho());

				detail.setAcShrKbnName(reportEntity.getAcShrKbnName());

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

		//DELETE zhen.XB LACS帳票バッチ対応  2013/04/11 start
		//File tmpFile = null; // 出力先ファイル
		//FileOutputStream fout = null; // 出力ファイルストリーム
		//DELETE zhen.XB LACS帳票バッチ対応  2013/04/11 END

		Field field = null;

		LACSReportGoukeiBean detail = null;

		//DELETE zhen.XB LACS帳票バッチ対応  2013/04/11 start
		//Report report = null; // WebKCoreレポートオブジェクト
		//DELETE zhen.XB LACS帳票バッチ対応  2013/04/11 END
		
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
			
			//MODIFY zhen.XB LACS帳票バッチ対応  2013/04/11 start
			if (!batchFlg) {
			//MODIFY zhen.XB LACS帳票バッチ対応  2013/04/11 end
				scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
				formDirectory = new File(wprlHomeDirectory, FORM_PATH);	
				tmpFile = File.createTempFile("pdf01_" + prefix + "_", ".pdf", scratchDirectory);
				fout = new FileOutputStream(tmpFile);
				formFile = new File(formDirectory, "Goukei.pdf");
				datFile = new File(formDirectory, "Goukei.dat");
				//ADD zhen.XB LACS帳票バッチ対応  2013/04/11 start	
				report = new Report(formFile, datFile, fout);
				//ADD zhen.XB LACS帳票バッチ対応  2013/04/11 end	
			//MODIFY zhen.XB LACS帳票バッチ対応  2013/04/11 start	
			}
			//MODIFY zhen.XB LACS帳票バッチ対応  2013/04/11 end
			
			
			//ADD ren.SL LACS帳票バッチ出力  2013/04/11 start
			if (batchFlg && !batchStartFlg) {
				this.startReport(piContext);
				batchStartFlg =true;
			}
			//ADD ren.SL LACS帳票バッチ出力  2013/04/11 end
			
			String yukeiSkkHoho; // 有形償却方法
			String mukeiSkkHoho; // 無形償却方法
			String rskClcHoho; // 利息計算方法
			
			//DELETE zhen.XB LACS帳票バッチ対応  2013/04/11 start	
			//report = new Report(formFile, datFile, fout);
			//DELETE zhen.XB LACS帳票バッチ対応  2013/04/11 end	
			
			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				detail = piReportBean.getGoukeiBean(i);

				report.createPage(1);

				field = report.getField("xPage");
				report.putFieldData(field, (i + 1) + "/" + piReportBean.getDataMax());

				field = report.getField("xDate");
				report.putFieldData(field, super.convertReki(Convert.toString(new Date()), piDateMode));

				field = report.getField("xLeasCompanyTitle");
				report.putFieldData(field, TITLE_COMP);

				field = report.getField("xLeasUserTitle");
				report.putFieldData(field, TITLE_USER);

				field = report.getField("xLeaseGoukeiTitle");
				report.putFieldData(field, super.acStd.equals(LACSDefine.AccountStandard.NEW_1) ? TITLE_NEW : TITLE_OLD);

				field = report.getField("xLeaseCompany");
				report.putFieldData(field, detail.getLeasCompanyNm());

				field = report.getField("xLeaseUser");
				report.putFieldData(field, detail.getLeasUserNm());

				field = report.getField("xTaisyouFrom");
				report.putFieldData(field, super.convertRekiLong(piReportBean.getTermFrom().getYYYYMMDD(), piDateMode));

				field = report.getField("xTaisyouTo");
				report.putFieldData(field, super.convertRekiLong(piReportBean.getTermTo().getYYYYMMDD(), piDateMode));

				field = report.getField("xSyutoku01");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyutoku01()));

				field = report.getField("xSyutoku02");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyutoku02()));

				field = report.getField("xSyutoku03");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyutoku03()));

				field = report.getField("xSyutoku04");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyutoku04()));

				field = report.getField("xSyutoku05");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyutoku05()));

				field = report.getField("xSyutoku06");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyutoku06()));

				field = report.getField("xSyutoku07");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyutoku07()));

				// 2020/05/22 ADD START
				field = report.getField("xSyutoku08");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyutoku08()));

				field = report.getField("xSyutoku09");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyutoku09()));
				// 2020/05/22 ADD END

				field = report.getField("xSyutokuTotal");
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyutokuTotal()));

				field = report.getField("xGenka01");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenka01()));

				field = report.getField("xGenka02");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenka02()));

				field = report.getField("xGenka03");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenka03()));

				field = report.getField("xGenka04");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenka04()));

				field = report.getField("xGenka05");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenka05()));

				field = report.getField("xGenka06");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenka06()));

				field = report.getField("xGenka07");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenka07()));

				// 2020/05/22 ADD START
				field = report.getField("xGenka08");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenka08()));

				field = report.getField("xGenka09");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenka09()));
				// 2020/05/22 ADD END

				field = report.getField("xGenkaTotal");
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenkaTotal()));

				field = report.getField("xZandaka01");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZandaka01()));

				field = report.getField("xZandaka02");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZandaka02()));

				field = report.getField("xZandaka03");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZandaka03()));

				field = report.getField("xZandaka04");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZandaka04()));

				field = report.getField("xZandaka05");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZandaka05()));

				field = report.getField("xZandaka06");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZandaka06()));

				field = report.getField("xZandaka07");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZandaka07()));

				// 2020/05/22 ADD START
				field = report.getField("xZandaka08");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZandaka08()));

				field = report.getField("xZandaka09");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZandaka09()));
				// 2020/05/22 ADD END

				field = report.getField("xZandakaTotal");
				report.putFieldData(field, StringUtl.formatNumber(detail.getZandakaTotal()));

				field = report.getField("xFlow");
				report.putFieldData(field, super.acStd.equals(LACSDefine.AccountStandard.NEW_1) ? HEAD_FLOW_NEW : HEAD_FLOW_OLD);

				field = report.getField("xStock");
				report.putFieldData(field, super.acStd.equals(LACSDefine.AccountStandard.NEW_1) ? HEAD_STOCK_NEW : HEAD_STOCK_OLD);

				field = report.getField("xMikeikaZan01");
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaZan01()));

				field = report.getField("xMikeikaZan02");
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaZan02()));

				field = report.getField("xMikeikaZan03");
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaZan03()));

				field = report.getField("xToukiSiharai");
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukiSiharai()));

				field = report.getField("xToukiGenka");
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukiGenka()));

				field = report.getField("xToukiRisoku");
				if (piReportBean.getKaikeiSyori().equals("0")) {
					report.putFieldData(field, StringUtl.formatNumber(detail.getToukiRisoku()));
				}
				else {
					report.putFieldData(field, "0");
				}

				field = report.getField("xMikeika01");
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeika01()));

				field = report.getField("xMikeika02");
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeika02()));

				field = report.getField("xMikeika03");
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeika03()));

				field = report.getField("xComment");

				report.putFieldData(field, super.convertReki(DateUtl.add(Calendar.DAY_OF_MONTH, 1, Convert.toDateString(piReportBean.getTermTo().getYYYYMMDD())), piDateMode) + "～" + super.convertReki(DateUtl.add(Calendar.YEAR, 1, Convert.toDateString(piReportBean.getTermTo().getYYYYMMDD())), piDateMode) + "、1年超は" + super.convertReki(DateUtl.add(Calendar.DAY_OF_MONTH, 1, DateUtl.add(Calendar.YEAR, 1, Convert.toDateString(piReportBean.getTermTo().getYYYYMMDD()))), piDateMode) + "以降　を指す。");

				field = report.getField("xKaikeiSyoriHouhouTitle");
				report.putFieldData(field, KAIKEI_TITLE);

				field = report.getField("xKaikeiSyoriHouhou");
				report.putFieldData(field, detail.getAcShrKbnName());

				yukeiSkkHoho = getSkkHohoNm(detail.getYukeiSkkHoho());
				mukeiSkkHoho = getSkkHohoNm(detail.getMukeiSkkHoho());
				field = report.getField("xSkkHoho");
				if (detail.getYukeiSkkHoho().equals(detail.getMukeiSkkHoho())) {

					report.putFieldData(field, SKK_HOHO_TITLE + yukeiSkkHoho + "によっている。");

				}
				else {

					report.putFieldData(field, SKK_HOHO_TITLE + "有形は" + yukeiSkkHoho + "、無形は" + mukeiSkkHoho + "によっている。");

				}

				rskClcHoho = getRskClcHohoNm(detail.getRskClcHoho());
				field = report.getField("xRskHoho");
				if (detail.getRskClcHoho().equals(LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201)) {
					report.putFieldData(field, "上記注記は利息相当額の合理的な見積額を控除しない方法によっている。");
				}
				else {
					report.putFieldData(field, "利息相当額の算定方法は、リース料総額とリース資産計上価額との差額を利息相当額とし、各期への配分方法については、" + rskClcHoho + "によっている。");
				}
				field = report.getField("xComment2");
				report.putFieldData(field, COMMENT);

				field = report.getField("xToukiTitle");
				report.putFieldData(field, TOUKI_TITLE);
				field = report.getField("xFlow2");
				report.putFieldData(field, HEAD_FLOW_OLD);

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
			
			//MODIFY zhen.XB LACS帳票バッチ対応  2013/04/11 start
			if (!batchFlg) {
				report.close();
				report = null;
			}
			//MODIFY zhen.XB LACS帳票バッチ対応  2013/04/11 end
			
			return tmpFile.getName();
		}
		finally {
			
			//MODIFY zhen.XB LACS帳票バッチ対応  2013/04/11 start
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
			//MODIFY zhen.XB LACS帳票バッチ対応  2013/04/11 end
		}
	}

	/**
	 * 減価償却方法名称取得.
	 * 
	 * @param piSkkHohoCd
	 *            減価償却方法コード
	 * @return 減価償却方法名称
	 * @exception Exception
	 *                実行例外
	 */
	public String getSkkHohoNm(String piSkkHohoCd) throws Exception {

		String skkHohoNm;

		if (piSkkHohoCd.equals(LACSDefine.ShoukyakuKeijoHohoKbn.TY_YSU_TGKHO_111) || piSkkHohoCd.equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_BKN_PS_TGKHO_121) || piSkkHohoCd.equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221)) {
			skkHohoNm = "定額法";
		}
		else if (piSkkHohoCd.equals(LACSDefine.ShoukyakuKeijoHohoKbn.TY_YSU_TRTHO_112) || piSkkHohoCd.equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_BKN_PS_TRTHO_122) || piSkkHohoCd.equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222)) {
			skkHohoNm = "定率法";
		}
		else {
			skkHohoNm = "級数法";
		}

		return skkHohoNm;

	}

	/**
	 * 利息計算方法名称取得.
	 * 
	 * @param piRskClcHohoCd
	 *            利息計算方法コード
	 * @return 利息計算方法名称
	 * @exception Exception
	 *                実行例外
	 */
	public String getRskClcHohoNm(String piRskClcHohoCd) throws Exception {

		String rskClcHohoNm;

		if (piRskClcHohoCd.equals(LACSDefine.RisokuKeijoHohoKbn.RSKHO_ZEN_GET_101) || piRskClcHohoCd.equals(LACSDefine.RisokuKeijoHohoKbn.RSKHO_ATO_GET_102)) {
			rskClcHohoNm = "利息法";
		}
		else if (piRskClcHohoCd.equals(LACSDefine.RisokuKeijoHohoKbn.KINTOHO_301)) {
			rskClcHohoNm = "均等法";
		}
		else {
			rskClcHohoNm = "利息無視法";
		}

		return rskClcHohoNm;

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
