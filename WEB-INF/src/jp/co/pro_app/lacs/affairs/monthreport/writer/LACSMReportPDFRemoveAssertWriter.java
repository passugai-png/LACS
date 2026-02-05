package jp.co.pro_app.lacs.affairs.monthreport.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportRemoveAssertBean;
import jp.co.pro_app.lacs.affairs.monthreport.data.entity.LACSMReportRemoveAssertEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

/**
 * 月次帳票出力：除却資産一覧Model.
 * 
 * @author yamaguchi
 * @version 20080402
 */
public class LACSMReportPDFRemoveAssertWriter extends LACSMReportPDFWriterBase {

	private Report						report			= null;		// WebKCoreレポートオブジェクト

	private LACSMReportRemoveAssertBean	detail			= null;

	private long						souPage			= 0;			// 総ページ数

	private long						page			= 0;			// ページ

	private int							lineCount		= 0;			// 明細カウンタ

	private String						index			= "";			// 明細行修飾子

	private static final int			MAX_LINE		= 16;			// 明細行数

	private static final String			TITLE_COMP		= "リース会社　：";

	private static final String			TITLE_USER		= "開示先　　　：";

	private static final String			TITLE_KEINO		= "契約番号";

	private static final String			TITLE_BKNNM		= "物件名";

	private static final String			TITLE_BKNNO		= "物件番号";

	private static final String			TITLE_BKNNO2	= "　";

	private static final String			TITLE_LEASSTR	= "リース開始日";

	private static final String			TITLE_LEASEND	= "リース終了日";

	private static final String			TITLE_KAIYMD	= "中途解約日";

	private static final String			TITLE_SSNKMKNM	= "固定資産科目";

	private static final String			TITLE_SKKSO		= "取得価格相当額";

	private static final String			TITLE_SKKKIKAN1	= "償却期間";

	private static final String			TITLE_SKKKIKAN2	= "（経過/総）";

	private static final String			TITLE_SKKRUI	= "減価償却累計額相当額";

	private static final String			TITLE_ZANK		= "うち残価保証額";

	private static final String			TITLE_BOKA		= "解約/満了時簿価";

	private long						skkSoAmt1		= 0;

	private long						skkRuiAmt1		= 0;

	private long						zankAmt1		= 0;

	private long						bokaAmt1		= 0;

	private long						skkSoAmt0		= 0;

	private long						skkRuiAmt0		= 0;

	private long						zankAmt0		= 0;

	private long						bokaAmt0		= 0;

	private long						skkSoAmt		= 0;

	private long						skkRuiAmt		= 0;

	private long						zankAmt			= 0;

	private long						bokaAmt			= 0;

	private long						skkSoAmt2		= 0;

	private long						skkRuiAmt2		= 0;

	private long						zankAmt2		= 0;

	private long						bokaAmt2		= 0;

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
	public LACSMReportPDFRemoveAssertWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
		LACSMReportRemoveAssertEntity reportEntity = new LACSMReportRemoveAssertEntity(super.model, commonBean, piReportBean);
		LACSMReportRemoveAssertBean removeAssertDetail = null;

		int count = 0;

		try {
			reportEntity.setCon(super.con);

			reportEntity.execSQL();

			while (reportEntity.next()) {
				removeAssertDetail = new LACSMReportRemoveAssertBean();
				piReportBean.addRemoveAssertBean(removeAssertDetail);

				removeAssertDetail.setBrakeKey0(reportEntity.getBrakeKey0()); // ブレークキー０
				removeAssertDetail.setBrakeKey1(reportEntity.getBrakeKey1()); // ブレークキー１

				removeAssertDetail.setBrakeKey2(reportEntity.getBrakeKey2()); // ブレークキー２

				removeAssertDetail.setSkkAmtNm(reportEntity.getSkkAmtNm()); // 償却費総額名
				removeAssertDetail.setSkkTermNm(reportEntity.getSkkTermNm()); // 償却期間名
				removeAssertDetail.setSkkHohoNm(reportEntity.getSkkHohoNm()); // 償却費計算方法名
				removeAssertDetail.setHyjyoKeiNo(reportEntity.getHyjyoKeiNo()); // 表示用契約番号
				removeAssertDetail.setBknNm(reportEntity.getBknNm()); // 物件名
				removeAssertDetail.setBknNo(reportEntity.getBknNo()); // 物件番号
				removeAssertDetail.setKnshuYmd(reportEntity.getKnshuYmd()); // リース開始日
				removeAssertDetail.setMryoYmd(reportEntity.getMryoYmd()); // リース終了日
				removeAssertDetail.setKaiYmd(reportEntity.getKaiYmd()); // 中途解約日
				removeAssertDetail.setSsnSriCd(reportEntity.getSsnSriCd()); // 資産種類コード
				removeAssertDetail.setSsnSriNm(reportEntity.getSsnSriNm()); // 資産科目
				removeAssertDetail.setKi(reportEntity.getKi()); // 償却期間・経過
				removeAssertDetail.setSou(reportEntity.getSou()); // 償却期間・総
				removeAssertDetail.setRuiSkkAmt(reportEntity.getRuiSkkAmt()); // 償却累計額
				removeAssertDetail.setZankAmt(reportEntity.getZankAmt()); // 残価保証額
				removeAssertDetail.setZandSkkAmt(reportEntity.getZandSkkAmt()); // 解約・満了時簿価
				removeAssertDetail.setSkkSougaku(reportEntity.getGnpnTtl()); // 償却対象総額

				removeAssertDetail.setLeaseUserNm(reportEntity.getLeaseUserNm()); // リース会社名
				removeAssertDetail.setLeaseCompanyNm(reportEntity.getLeaseCompanyNm()); // リースユーザー名

				removeAssertDetail.setAcKijyunNm(reportEntity.getAcKijyunNm()); // リース会計基準名

				count++;

			}

			piReportBean.setDataMax(count);

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

		File wprlHomeDirectory = new File(PdfProperties.getInstance().getProperty(PdfProperties.WKC_PDF_HOME));
		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		formDirectory = new File(wprlHomeDirectory, FORM_PATH);

		File tmpFile = null; // 出力先ファイル
		FileOutputStream fout = null; // 出力ファイルストリーム
		report = null; // WebKCoreレポートオブジェクト
		detail = null;
		souPage = 0; // 総ページ数
		page = 0; // ページ
		lineCount = 0; // 明細カウンタ
		index = ""; // 明細行修飾子

		String brakeKey0 = "";
		String brakeKey1 = "";

		String brakeKey2 = "";

		Field field = null;

		try {

			tmpFile = File.createTempFile("pdf12_", ".pdf", scratchDirectory);
			fout = new FileOutputStream(tmpFile);
			File formFile = new File(formDirectory, "RemoveAssert.pdf");
			File datFile = new File(formDirectory, "RemoveAssert.dat");
			report = new Report(formFile, datFile, fout);

			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				detail = piReportBean.getRemoveAssertBean(i);
				if (!detail.getBrakeKey2().equals(brakeKey2)) {
					if (!brakeKey2.equals("")) {

						if (lineCount >= MAX_LINE) {
							souPage++; // 総ページ数のカウントＵＰ
							lineCount = 0;
						}

						lineCount++;
						if (!detail.getBrakeKey1().equals(brakeKey1)) {
							if (!brakeKey1.equals("")) {

								if (lineCount >= MAX_LINE) {
									souPage++; // 総ページ数のカウントＵＰ
									lineCount = 0;
								}

								lineCount++;
								if (!detail.getBrakeKey0().equals(brakeKey0)) {

									if (lineCount >= MAX_LINE) {
										souPage++; // 総ページ数のカウントＵＰ
										lineCount = 0;
									}

									lineCount++;
								}
							}
						}
						else {

							if (lineCount >= MAX_LINE) {
								souPage++; // 総ページ数のカウントＵＰ
								lineCount = 0;
							}
						}
					}
					souPage++; // 総ページ数のカウントＵＰ
					lineCount = 0;

					brakeKey0 = detail.getBrakeKey0();
					brakeKey1 = detail.getBrakeKey1();
					brakeKey2 = detail.getBrakeKey2();
				}
				else {

					if (lineCount >= MAX_LINE) {
						souPage++; // 総ページ数のカウントＵＰ
						lineCount = 0;
					}
				}
				lineCount++;
			}

			if (lineCount >= MAX_LINE) {
				souPage++; // 総ページ数のカウントＵＰ
				lineCount = 0;
			}

			lineCount++;
			if (lineCount >= MAX_LINE) {
				souPage++; // 総ページ数のカウントＵＰ
				lineCount = 0;
			}

			lineCount++;
			if (lineCount >= MAX_LINE) {
				souPage++; // 総ページ数のカウントＵＰ
				lineCount = 0;
			}

			lineCount = 0; // 明細カウンタ

			brakeKey0 = ""; // ブレイクキー０
			brakeKey1 = ""; // ブレイクキー１

			brakeKey2 = ""; // ブレイクキー２

			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				detail = piReportBean.getRemoveAssertBean(i);
				if (!detail.getBrakeKey2().equals(brakeKey2)) {
					if (!brakeKey2.equals("")) {

						if (lineCount >= MAX_LINE) {
							detail = piReportBean.getRemoveAssertBean(i - 1);
							headPrint(piReportBean, piDateMode);
							detail = piReportBean.getRemoveAssertBean(i);
						}

						skkHohoKbnGokeiPrint();

						if (!detail.getBrakeKey1().equals(brakeKey1)) {
							if (!brakeKey1.equals("")) {

								if (lineCount >= MAX_LINE) {
									detail = piReportBean.getRemoveAssertBean(i - 1);
									headPrint(piReportBean, piDateMode);
									detail = piReportBean.getRemoveAssertBean(i);
								}

								ackijyunGokeiPrint();

								if (!detail.getBrakeKey0().equals(brakeKey0)) {

									if (lineCount >= MAX_LINE) {
										detail = piReportBean.getRemoveAssertBean(i - 1);
										headPrint(piReportBean, piDateMode);
										detail = piReportBean.getRemoveAssertBean(i);
									}

									leaseCompanyGokeiPrint();
								}
							}
						}
						else {

							if (lineCount >= MAX_LINE) {
								headPrint(piReportBean, piDateMode);
							}
						}
					}

					headPrint(piReportBean, piDateMode);

					brakeKey0 = detail.getBrakeKey0();
					brakeKey1 = detail.getBrakeKey1();
					brakeKey2 = detail.getBrakeKey2();
				}
				else {

					if (lineCount >= MAX_LINE) {
						headPrint(piReportBean, piDateMode);
					}
				}

				index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

				field = report.getField("xKeiNo" + index);
				report.putFieldData(field, detail.getHyjyoKeiNo());

				field = report.getField("xBknNm" + index);
				report.putFieldData(field, detail.getBknNm());

				field = report.getField("xBknNo" + index);
				report.putFieldData(field, detail.getBknNo());

				field = report.getField("xLeasStrYmd" + index);
				report.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getKnshuYmd()))), piDateMode));

				field = report.getField("xLeasEndYmd" + index);
				report.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getMryoYmd()))), piDateMode));

				field = report.getField("xKaiYmd" + index);
				report.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getKaiYmd()))), piDateMode));

				field = report.getField("xSsnKmkNm" + index);
				report.putFieldData(field, detail.getSsnSriNm());

				field = report.getField("xKaiYmd" + index);
				report.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getKaiYmd()))), piDateMode));

				field = report.getField("xSkkSoAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getSkkSougaku()));

				field = report.getField("xSkkKikan" + index);
				report.putFieldData(field, Long.toString(detail.getKi()) + "/" + Long.toString(detail.getSou()));

				field = report.getField("xSkkRuiAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getRuiSkkAmt()));

				field = report.getField("xZankAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankAmt()));

				field = report.getField("xBokaAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZandSkkAmt()));

				field = report.getField("xComment");
				report.putFieldData(field, COMMENT);

				field = report.getField("xKeiNoTitle");
				report.putFieldData(field, TITLE_KEINO);

				field = report.getField("xBknNmTitle");
				report.putFieldData(field, TITLE_BKNNM);

				field = report.getField("xBknNoTitle");
				report.putFieldData(field, TITLE_BKNNO);

				field = report.getField("xBknNoTitle2");
				report.putFieldData(field, TITLE_BKNNO2);

				field = report.getField("xLeasStrTitle");
				report.putFieldData(field, TITLE_LEASSTR);

				field = report.getField("xLeasEndTitle");
				report.putFieldData(field, TITLE_LEASEND);

				field = report.getField("xKaiYmdTitle");
				report.putFieldData(field, TITLE_KAIYMD);

				field = report.getField("xSsnKmkNmTitle");
				report.putFieldData(field, TITLE_SSNKMKNM);

				field = report.getField("xSkkSoTitle");
				report.putFieldData(field, TITLE_SKKSO);

				field = report.getField("xSkkKikanTitle1");
				report.putFieldData(field, TITLE_SKKKIKAN1);

				field = report.getField("xSkkKikanTitle2");
				report.putFieldData(field, TITLE_SKKKIKAN2);

				field = report.getField("xSkkRuiTitle");
				report.putFieldData(field, TITLE_SKKRUI);

				field = report.getField("xZankTitle");
				report.putFieldData(field, TITLE_ZANK);

				field = report.getField("xBokaTitle");
				report.putFieldData(field, TITLE_BOKA);

				skkSoAmt2 += detail.getSkkSougaku();
				skkRuiAmt2 += detail.getRuiSkkAmt();
				zankAmt2 += detail.getZankAmt();
				bokaAmt2 += detail.getZandSkkAmt();

				skkSoAmt1 += detail.getSkkSougaku();
				skkRuiAmt1 += detail.getRuiSkkAmt();
				zankAmt1 += detail.getZankAmt();
				bokaAmt1 += detail.getZandSkkAmt();

				skkSoAmt0 += detail.getSkkSougaku();
				skkRuiAmt0 += detail.getRuiSkkAmt();
				zankAmt0 += detail.getZankAmt();
				bokaAmt0 += detail.getZandSkkAmt();

				skkSoAmt += detail.getSkkSougaku();
				skkRuiAmt += detail.getRuiSkkAmt();
				zankAmt += detail.getZankAmt();
				bokaAmt += detail.getZandSkkAmt();

				lineCount++;
			}

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}
			skkHohoKbnGokeiPrint();

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}
			ackijyunGokeiPrint();

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}
			leaseCompanyGokeiPrint();

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}
			gokeiPrint();

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

	private void headPrint(LACSMReportBean piReportBean, String piDateMode) throws Exception {

		Field field = null;

		report.createPage(1);

		lineCount = 0;

		field = report.getField("xPage");
		report.putFieldData(field, ++page + "/" + souPage);

		field = report.getField("xDate");
		report.putFieldData(field, super.convertReki(Convert.toString(new Date()), piDateMode));

		field = report.getField("xShkSogkNm");
		report.putFieldData(field, detail.getSkkAmtNm());

		field = report.getField("xShkKknNm");
		report.putFieldData(field, detail.getSkkTermNm());

		field = report.getField("xShkKsnNm");
		report.putFieldData(field, detail.getSkkHohoNm());

		field = report.getField("xTaisyouFrom");
		report.putFieldData(field, super.convertRekiLong(Convert.toString(Convert.toDate(Convert.toDateString(piReportBean.getTermFrom().getYYYYMMDD()))), piDateMode));

		field = report.getField("xKara");
		report.putFieldData(field, "～");

		field = report.getField("xTaisyouTo");
		report.putFieldData(field, super.convertRekiLong(Convert.toString(Convert.toDate(Convert.toDateString(piReportBean.getTermTo().getYYYYMMDD()))), piDateMode));

		field = report.getField("xLeasCompanyTitle");
		report.putFieldData(field, TITLE_COMP);
		field = report.getField("xLeaseCompany"); // リース会社名
		report.putFieldData(field, detail.getLeaseCompanyNm());

		field = report.getField("xLeasUserTitle");
		report.putFieldData(field, TITLE_USER);
		field = report.getField("xLeaseUser"); // リースユーザ名
		report.putFieldData(field, detail.getLeaseUserNm());

		field = report.getField("xAc_Kijyun_Nm"); // リース会計基準名
		report.putFieldData(field, detail.getAcKijyunNm());

		field = report.getField("xPageSep");
		report.putFieldData(field, ":");

		field = report.getField("xDateSep");
		report.putFieldData(field, ":");

		field = report.getField("xUnitSep");
		report.putFieldData(field, ":");

		field = report.getField("xUnit");
		report.putFieldData(field, "円");

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

	private void gokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xSsnKmkNm" + index);
		report.putFieldData(field, "総　合　計");

		field = report.getField("xSkkSoAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(skkSoAmt));

		field = report.getField("xSkkRuiAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(skkRuiAmt));

		field = report.getField("xZankAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankAmt));

		field = report.getField("xBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaAmt));

		lineCount++;
	}

	private void leaseCompanyGokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xSsnKmkNm" + index);
		report.putFieldData(field, "リース会社計");

		field = report.getField("xSkkSoAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(skkSoAmt0));

		field = report.getField("xSkkRuiAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(skkRuiAmt0));

		field = report.getField("xZankAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankAmt0));

		field = report.getField("xBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaAmt0));

		skkSoAmt0 = 0;
		skkRuiAmt0 = 0;
		zankAmt0 = 0;
		bokaAmt0 = 0;

		lineCount++;
	}

	private void skkHohoKbnGokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xSsnKmkNm" + index);
		report.putFieldData(field, "償却費計算方法計");

		field = report.getField("xSkkSoAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(skkSoAmt1));

		field = report.getField("xSkkRuiAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(skkRuiAmt1));

		field = report.getField("xZankAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankAmt1));

		field = report.getField("xBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaAmt1));

		skkSoAmt1 = 0;
		skkRuiAmt1 = 0;
		zankAmt1 = 0;
		bokaAmt1 = 0;

		lineCount++;
	}

	private void ackijyunGokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xSsnKmkNm" + index);
		report.putFieldData(field, "リース会計基準計");

		field = report.getField("xSkkSoAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(skkSoAmt2));

		field = report.getField("xSkkRuiAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(skkRuiAmt2));

		field = report.getField("xZankAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankAmt2));

		field = report.getField("xBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaAmt2));

		skkSoAmt2 = 0;
		skkRuiAmt2 = 0;
		zankAmt2 = 0;
		bokaAmt2 = 0;

		lineCount++;
	}

}
