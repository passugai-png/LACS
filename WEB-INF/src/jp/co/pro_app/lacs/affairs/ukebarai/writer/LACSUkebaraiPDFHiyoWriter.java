package jp.co.pro_app.lacs.affairs.ukebarai.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiHiyoBean;
import jp.co.pro_app.lacs.affairs.ukebarai.data.entity.LACSUkebaraiHiyoEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

/**
 * 受払合計表：受払合計表PDF Model.
 * 
 * @author active
 * @version 20080814
 */
public class LACSUkebaraiPDFHiyoWriter extends LACSUkebaraiPDFWriterBase {

	private Report					report			= null; // WebKCoreレポートオブジェクト

	private LACSUkebaraiHiyoBean	detail			= null;

	private int						souPage			= 0;	// 総ページ数

	private int						page			= 0;	// ページ

	private int						lineCount		= 0;	// 明細カウンタ

	private String					brakeKey1		= "";	// ブレイクキー

	private String					brakeKey2		= "";	// ブレイクキー

	private String					brakeKey3		= "";	// ブレイクキー

	private String					brakeKey4		= "";	// ブレイクキー

	private String					brakeKey5		= "";	// ブレイクキー

	private String					index			= "";	// 明細行修飾子

	private long					sougakuamt		= 0;	// 総額

	private long					zenkimatuamt	= 0;	// 前期末累計額

	private long					toukiamt		= 0;	// 当期計上高

	private long					toukigenamt		= 0;	// 当期減少

	private long					toukimatuamt	= 0;	// 当期末累計額

	private long					sougakuamt1		= 0;	// 総額

	private long					zenkimatuamt1	= 0;	// 前期末累計額

	private long					toukiamt1		= 0;	// 当期計上高

	private long					toukigenamt1	= 0;	// 当期減少

	private long					toukimatuamt1	= 0;	// 当期末累計額

	private long					sougakuamt2		= 0;	// 総額

	private long					zenkimatuamt2	= 0;	// 前期末累計額

	private long					toukiamt2		= 0;	// 当期計上高

	private long					toukigenamt2	= 0;	// 当期減少

	private long					toukimatuamt2	= 0;	// 当期末累計額

	private long					sougakuamt3		= 0;	// 総額

	private long					zenkimatuamt3	= 0;	// 前期末累計額

	private long					toukiamt3		= 0;	// 当期計上高

	private long					toukigenamt3	= 0;	// 当期減少

	private long					toukimatuamt3	= 0;	// 当期末累計額

	private long					sougakuamt4		= 0;	// 総額

	private long					zenkimatuamt4	= 0;	// 前期末累計額

	private long					toukiamt4		= 0;	// 当期計上高

	private long					toukigenamt4	= 0;	// 当期減少

	private long					toukimatuamt4	= 0;	// 当期末累計額

	private long					sougakuamt5		= 0;	// 総額

	private long					zenkimatuamt5	= 0;	// 前期末累計額

	private long					toukiamt5		= 0;	// 当期計上高

	private long					toukigenamt5	= 0;	// 当期減少

	private long					toukimatuamt5	= 0;	// 当期末累計額

	private static final int		MAX_LINE		= 11;	// 明細行数

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
	public LACSUkebaraiPDFHiyoWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
	}

	/**
	 * 費用受払データ取得. 出力データをBeanに設定して返却する
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	public void getHiyoData(LACSUkebaraiBean piUkebaraiBean) throws SQLException {

		LACSUkebaraiHiyoEntity reportEntity = new LACSUkebaraiHiyoEntity(model, this.commonBean, piUkebaraiBean);
		detail = null;
		try {
			reportEntity.setCon(super.con);

			piUkebaraiBean.setDataMax(reportEntity.execSQL());
			int dataCount = 0;
			while (reportEntity.next()) {
				detail = new LACSUkebaraiHiyoBean();
				piUkebaraiBean.addUkebaraiHiyoBean(detail);
				detail.setBrakeKey1(reportEntity.getBrakeKey1());
				detail.setBrakeKey2(reportEntity.getBrakeKey2());
				detail.setBrakeKey3(reportEntity.getBrakeKey3());
				detail.setBrakeKey4(reportEntity.getBrakeKey4());
				detail.setBrakeKey5(reportEntity.getBrakeKey5());
				detail.setCreateDate(reportEntity.getCreateDate());
				detail.setKikanStart(reportEntity.getKikanStart());
				detail.setKikanEnd(reportEntity.getKikanEnd());
				detail.setLcNm(reportEntity.getLcNm());
				detail.setLuNm(reportEntity.getLuNm());
				detail.setTaishoAcKijyunNm(reportEntity.getTaishoAcKijyunNm());
				detail.setAcShrNm(reportEntity.getAcShrNm());
				detail.setKamokuNm(reportEntity.getKamokuNm());
				detail.setTrdHnteiKekaNm(reportEntity.getTrdHnteiKekaNm());
				detail.setKeiNo(reportEntity.getKeiNo());
				detail.setBknNo(reportEntity.getBknNo());
				detail.setBknNm(reportEntity.getBknNm());
				detail.setKnshuYmd(reportEntity.getKnshuYmd());
				detail.setMryoYmd(reportEntity.getMryoYmd());
				detail.setKaiYmd(reportEntity.getKaiYmd());
				detail.setSougakuAmt(reportEntity.getSougakuAmt());
				detail.setZenkiMatuAmt(reportEntity.getZenkiMatuAmt());
				detail.setToukiAmt(reportEntity.getToukiAmt());
				detail.setToukiGenAmt(reportEntity.getToukiGenAmt());
				detail.setToukiMatuAmt(reportEntity.getToukiMatuAmt());
				dataCount++;
			}
			piUkebaraiBean.setDataMax(dataCount);

		}
		finally {
			reportEntity.close();
		}
	}

	/**
	 * PDF作成.
	 * 
	 * @param piUkebaraiBean
	 *            費用受払明細表 Bean
	 * @param piContext
	 *            ServletContext
	 * @return PDFファイル名
	 * @exception Exception
	 *                実行例外
	 */
	public String makePDF(LACSUkebaraiBean piUkebaraiBean, ServletContext piContext) throws Exception {

		File wprlHomeDirectory = new File(PdfProperties.getInstance().getProperty(PdfProperties.WKC_PDF_HOME));
		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		formDirectory = new File(wprlHomeDirectory, FORM_PATH);

		File tmpFile = null; // 出力先ファイル
		FileOutputStream fout = null; // 出力ファイルストリーム
		report = null; // WebKCoreレポートオブジェクト
		detail = null;

		Field field = null;

		souPage = 0; // 総ページ数
		page = 0; // ページ
		lineCount = 0; // 明細カウンタ
		brakeKey1 = ""; // ブレイクキー
		brakeKey2 = ""; // ブレイクキー
		brakeKey3 = ""; // ブレイクキー
		brakeKey4 = ""; // ブレイクキー
		brakeKey5 = ""; // ブレイクキー
		index = ""; // 明細行修飾子

		try {

			tmpFile = File.createTempFile("pdf24_", ".pdf", scratchDirectory);
			fout = new FileOutputStream(tmpFile);
			File formFile = new File(formDirectory, "HiyoUkebarai.pdf");
			File datFile = new File(formDirectory, "HiyoUkebarai.dat");
			report = new Report(formFile, datFile, fout);

			for (int i = 0; i < piUkebaraiBean.getDataMax(); i++) {
				detail = piUkebaraiBean.getUkebaraiHiyoBean(i);
				if (!detail.getBrakeKey5().equals(brakeKey5)) {
					if (!brakeKey5.equals("")) {

						if (lineCount >= MAX_LINE) {
							souPage++; // 総ページ数のカウントＵＰ
							lineCount = 0;
						}

						lineCount++;
						if (!detail.getBrakeKey4().equals(brakeKey4)) {
							if (!brakeKey4.equals("")) {

								if (lineCount >= MAX_LINE) {
									souPage++; // 総ページ数のカウントＵＰ
									lineCount = 0;
								}

								lineCount++;
								if (!detail.getBrakeKey3().equals(brakeKey3)) {
									if (!brakeKey3.equals("")) {

										if (lineCount >= MAX_LINE) {
											souPage++; // 総ページ数のカウントＵＰ
											lineCount = 0;
										}

										lineCount++;
										if (!detail.getBrakeKey2().equals(brakeKey2)) {
											if (!brakeKey2.equals("")) {

												if (lineCount >= MAX_LINE) {
													souPage++; // 総ページ数のカウントＵＰ
													lineCount = 0;
												}

												lineCount++;
												if (!detail.getBrakeKey1().equals(brakeKey1)) {

													if (lineCount >= MAX_LINE) {
														souPage++; // 総ページ数のカウントＵＰ
														lineCount = 0;
													}

													lineCount++;
												}
											}
										}
									}
								}
							}
						}
					}
					souPage++; // 総ページ数のカウントＵＰ
					lineCount = 0;

					brakeKey1 = detail.getBrakeKey1();
					brakeKey2 = detail.getBrakeKey2();
					brakeKey3 = detail.getBrakeKey3();
					brakeKey4 = detail.getBrakeKey4();
					brakeKey5 = detail.getBrakeKey5();
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

			lineCount++;
			if (lineCount >= MAX_LINE) {
				souPage++; // 総ページ数のカウントＵＰ
				lineCount = 0;
			}

			lineCount = 0; // 明細カウンタ

			brakeKey1 = ""; // ブレイクキー１
			brakeKey2 = ""; // ブレイクキー２
			brakeKey3 = ""; // ブレイクキー３
			brakeKey4 = ""; // ブレイクキー４
			brakeKey5 = ""; // ブレイクキー５

			String piDateMode = super.getSeirekiWarekiCode(commonBean.getCompanyCode(), piUkebaraiBean.getLeasCompany().getValue());

			for (int i = 0; i < piUkebaraiBean.getDataMax(); i++) {
				detail = piUkebaraiBean.getUkebaraiHiyoBean(i);
				if (!detail.getBrakeKey5().equals(brakeKey5)) {
					if (!brakeKey5.equals("")) {

						if (lineCount >= MAX_LINE) {
							detail = piUkebaraiBean.getUkebaraiHiyoBean(i - 1);
							headPrint(detail, report, piDateMode);
							detail = piUkebaraiBean.getUkebaraiHiyoBean(i);
						}

						kamokuGokeiPrint();

						if (!detail.getBrakeKey4().equals(brakeKey4)) {
							if (!brakeKey4.equals("")) {

								if (lineCount >= MAX_LINE) {
									detail = piUkebaraiBean.getUkebaraiHiyoBean(i - 1);
									headPrint(detail, report, piDateMode);
									detail = piUkebaraiBean.getUkebaraiHiyoBean(i);
								}
								kaikeiSyoriGokeiPrint();

								if (!detail.getBrakeKey3().equals(brakeKey3)) {
									if (!brakeKey3.equals("")) {

										if (lineCount >= MAX_LINE) {
											detail = piUkebaraiBean.getUkebaraiHiyoBean(i - 1);
											headPrint(detail, report, piDateMode);
											detail = piUkebaraiBean.getUkebaraiHiyoBean(i);
										}

										trdHnteiKekaGokeiPrint();
										if (!detail.getBrakeKey2().equals(brakeKey2)) {
											if (!brakeKey2.equals("")) {

												if (lineCount >= MAX_LINE) {
													detail = piUkebaraiBean.getUkebaraiHiyoBean(i - 1);
													headPrint(detail, report, piDateMode);
													detail = piUkebaraiBean.getUkebaraiHiyoBean(i);
												}

												ackijyunGokeiPrint();

												if (!detail.getBrakeKey1().equals(brakeKey1)) {

													if (lineCount >= MAX_LINE) {
														detail = piUkebaraiBean.getUkebaraiHiyoBean(i - 1);
														headPrint(detail, report, piDateMode);
														detail = piUkebaraiBean.getUkebaraiHiyoBean(i);
													}

													leasCompanyGokeiPrint();
												}
											}
										}
									}
								}
							}
						}
					}

					headPrint(detail, report, piDateMode);

					brakeKey1 = detail.getBrakeKey1();
					brakeKey2 = detail.getBrakeKey2();
					brakeKey3 = detail.getBrakeKey3();
					brakeKey4 = detail.getBrakeKey4();
					brakeKey5 = detail.getBrakeKey5();
				}
				else {

					if (lineCount >= MAX_LINE) {
						headPrint(detail, report, piDateMode);
					}
				}

				index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

				field = report.getField("xKeiNo" + index);
				report.putFieldData(field, detail.getKeiNo());

				field = report.getField("xBknNo" + index);
				report.putFieldData(field, detail.getBknNo());

				field = report.getField("xBknNm" + index);
				report.putFieldData(field, detail.getBknNm());

				field = report.getField("xKnshuYmd" + index);
				report.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getKnshuYmd()))), piDateMode));

				field = report.getField("xMryoYmd" + index);
				report.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getMryoYmd()))), piDateMode));

				field = report.getField("xKaiYmd" + index);
				report.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getKaiYmd()))), piDateMode));

				field = report.getField("xSougakuAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getSougakuAmt()));

				field = report.getField("xZenkiMatuAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZenkiMatuAmt()));

				field = report.getField("xToukiAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukiAmt()));

				field = report.getField("xToukiGenAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukiGenAmt()));

				field = report.getField("xToukiMatuAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukiMatuAmt()));

				sougakuamt1 += detail.getSougakuAmt();
				zenkimatuamt1 += detail.getZenkiMatuAmt();
				toukiamt1 += detail.getToukiAmt();
				toukigenamt1 += detail.getToukiGenAmt();
				toukimatuamt1 += detail.getToukiMatuAmt();

				sougakuamt2 += detail.getSougakuAmt();
				zenkimatuamt2 += detail.getZenkiMatuAmt();
				toukiamt2 += detail.getToukiAmt();
				toukigenamt2 += detail.getToukiGenAmt();
				toukimatuamt2 += detail.getToukiMatuAmt();

				sougakuamt3 += detail.getSougakuAmt();
				zenkimatuamt3 += detail.getZenkiMatuAmt();
				toukiamt3 += detail.getToukiAmt();
				toukigenamt3 += detail.getToukiGenAmt();
				toukimatuamt3 += detail.getToukiMatuAmt();

				sougakuamt4 += detail.getSougakuAmt();
				zenkimatuamt4 += detail.getZenkiMatuAmt();
				toukiamt4 += detail.getToukiAmt();
				toukigenamt4 += detail.getToukiGenAmt();
				toukimatuamt4 += detail.getToukiMatuAmt();

				sougakuamt5 += detail.getSougakuAmt();
				zenkimatuamt5 += detail.getZenkiMatuAmt();
				toukiamt5 += detail.getToukiAmt();
				toukigenamt5 += detail.getToukiGenAmt();
				toukimatuamt5 += detail.getToukiMatuAmt();

				sougakuamt += detail.getSougakuAmt();
				zenkimatuamt += detail.getZenkiMatuAmt();
				toukiamt += detail.getToukiAmt();
				toukigenamt += detail.getToukiGenAmt();
				toukimatuamt += detail.getToukiMatuAmt();

				lineCount++;
			}

			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			kamokuGokeiPrint();

			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			kaikeiSyoriGokeiPrint();
			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			trdHnteiKekaGokeiPrint();
			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			ackijyunGokeiPrint();

			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			leasCompanyGokeiPrint();

			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
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

	private void headPrint(LACSUkebaraiHiyoBean piDetail, Report piReport, String piDateMode) throws Exception {
		Field field = null;

		piReport.createPage(1);

		lineCount = 0;

		field = piReport.getField("xPage");
		piReport.putFieldData(field, ++page + "/" + souPage);

		field = piReport.getField("xCreateDate");
		piReport.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(piDetail.getCreateDate()))), piDateMode));

		field = piReport.getField("xKikanStart");
		piReport.putFieldData(field, super.convertRekiLong(Convert.toString(Convert.toDate(Convert.toDateString(piDetail.getkikanStart()))), piDateMode));

		field = piReport.getField("xKikanEnd");
		piReport.putFieldData(field, super.convertRekiLong(Convert.toString(Convert.toDate(Convert.toDateString(piDetail.getkikanEnd()))), piDateMode));

		field = piReport.getField("xLcNm");
		piReport.putFieldData(field, piDetail.getLcNm());

		field = piReport.getField("xLuNm");
		piReport.putFieldData(field, piDetail.getLuNm());

		field = piReport.getField("xTaishoAcKijyunNm");
		piReport.putFieldData(field, piDetail.getTaishoAcKijyunNm());

		field = piReport.getField("xAcShrNm");
		piReport.putFieldData(field, piDetail.getAcShrNm());

		field = piReport.getField("xTrdHnteiKekaNm");
		piReport.putFieldData(field, piDetail.getTrdHnteiKekaNm());

		field = piReport.getField("xKamokuNm");
		piReport.putFieldData(field, piDetail.getKamokuNm());

	}

	private void gokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "総　合　計");

		field = report.getField("xSougakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(sougakuamt));

		field = report.getField("xZenkiMatuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuamt));

		field = report.getField("xToukiAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiamt));

		field = report.getField("xToukiGenAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukigenamt));

		field = report.getField("xToukiMatuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuamt));

		lineCount++;
	}

	private void leasCompanyGokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "リース会社計");

		field = report.getField("xSougakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(sougakuamt1));

		field = report.getField("xZenkiMatuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuamt1));

		field = report.getField("xToukiAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiamt1));

		field = report.getField("xToukiGenAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukigenamt1));

		field = report.getField("xToukiMatuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuamt1));

		sougakuamt1 = 0;
		zenkimatuamt1 = 0;
		toukiamt1 = 0;
		toukigenamt1 = 0;
		toukimatuamt1 = 0;

		lineCount++;
	}

	private void ackijyunGokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "リース会計基準計");

		field = report.getField("xSougakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(sougakuamt2));

		field = report.getField("xZenkiMatuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuamt2));

		field = report.getField("xToukiAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiamt2));

		field = report.getField("xToukiGenAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukigenamt2));

		field = report.getField("xToukiMatuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuamt2));

		sougakuamt2 = 0;
		zenkimatuamt2 = 0;
		toukiamt2 = 0;
		toukigenamt2 = 0;
		toukimatuamt2 = 0;

		lineCount++;
	}

	private void kaikeiSyoriGokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "会計処理方法計");

		field = report.getField("xSougakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(sougakuamt3));

		field = report.getField("xZenkiMatuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuamt3));

		field = report.getField("xToukiAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiamt3));

		field = report.getField("xToukiGenAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukigenamt3));

		field = report.getField("xToukiMatuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuamt3));

		sougakuamt3 = 0;
		zenkimatuamt3 = 0;
		toukiamt3 = 0;
		toukigenamt3 = 0;
		toukimatuamt3 = 0;

		lineCount++;
	}

	private void trdHnteiKekaGokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "リース取引分類計");

		field = report.getField("xSougakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(sougakuamt4));

		field = report.getField("xZenkiMatuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuamt4));

		field = report.getField("xToukiAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiamt4));

		field = report.getField("xToukiGenAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukigenamt4));

		field = report.getField("xToukiMatuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuamt4));

		sougakuamt4 = 0;
		zenkimatuamt4 = 0;
		toukiamt4 = 0;
		toukigenamt4 = 0;
		toukimatuamt4 = 0;

		lineCount++;
	}

	private void kamokuGokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "科　目　計");

		field = report.getField("xSougakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(sougakuamt5));

		field = report.getField("xZenkiMatuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuamt5));

		field = report.getField("xToukiAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiamt5));

		field = report.getField("xToukiGenAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukigenamt5));

		field = report.getField("xToukiMatuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuamt5));

		sougakuamt5 = 0;
		zenkimatuamt5 = 0;
		toukiamt5 = 0;
		toukigenamt5 = 0;
		toukimatuamt5 = 0;

		lineCount++;
	}
}
