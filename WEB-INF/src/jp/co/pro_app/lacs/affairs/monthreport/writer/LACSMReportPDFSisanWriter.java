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
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportSisanBean;
import jp.co.pro_app.lacs.affairs.monthreport.data.entity.LACSMReportSisanEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

/**
 * 月次帳票出力：資産台帳 Model.
 * 
 * @author yokota
 * @version 20081030
 */
public class LACSMReportPDFSisanWriter extends LACSMReportPDFWriterBase {

	private static final int		MAX_LINE				= 21;	// 明細行数

	private long					syutokuKakakuTotal		= 0;	// 取得価格合計

	private long					zenkimatsuBokaTotal		= 0;	// 前期末簿価合計

	private long					tougetsuHasseiTotal		= 0;	// 当月発生合計

	private long					tougetsuGensyoTotal		= 0;	// 当月減少合計

	private long					tougetsuJitsugenTotal	= 0;	// 当月実現合計

	private long					toukimatsuBokaTotal		= 0;	// 当期末簿価合計

	private long					syutokuKakakuTotal1		= 0;	// 取得価格合計

	private long					zenkimatsuBokaTotal1	= 0;	// 前期末簿価合計

	private long					tougetsuHasseiTotal1	= 0;	// 当月発生合計

	private long					tougetsuGensyoTotal1	= 0;	// 当月減少合計

	private long					tougetsuJitsugenTotal1	= 0;	// 当月実現合計

	private long					toukimatsuBokaTotal1	= 0;	// 当期末簿価合計

	private long					syutokuKakakuTotal2		= 0;	// 取得価格合計

	private long					zenkimatsuBokaTotal2	= 0;	// 前期末簿価合計

	private long					tougetsuHasseiTotal2	= 0;	// 当月発生合計

	private long					tougetsuGensyoTotal2	= 0;	// 当月減少合計

	private long					tougetsuJitsugenTotal2	= 0;	// 当月実現合計

	private long					toukimatsuBokaTotal2	= 0;	// 当期末簿価合計

	private long					syutokuKakakuTotal3		= 0;	// 取得価格合計

	private long					zenkimatsuBokaTotal3	= 0;	// 前期末簿価合計

	private long					tougetsuHasseiTotal3	= 0;	// 当月発生合計

	private long					tougetsuGensyoTotal3	= 0;	// 当月減少合計

	private long					tougetsuJitsugenTotal3	= 0;	// 当月実現合計

	private long					toukimatsuBokaTotal3	= 0;	// 当期末簿価合計

	private long					syutokuKakakuTotal4		= 0;	// 取得価格合計

	private long					zenkimatsuBokaTotal4	= 0;	// 前期末簿価合計

	private long					tougetsuHasseiTotal4	= 0;	// 当月発生合計

	private long					tougetsuGensyoTotal4	= 0;	// 当月減少合計

	private long					tougetsuJitsugenTotal4	= 0;	// 当月実現合計

	private long					toukimatsuBokaTotal4	= 0;	// 当期末簿価合計

	private long					syutokuKakakuTotal5		= 0;	// 取得価格合計

	private long					zenkimatsuBokaTotal5	= 0;	// 前期末簿価合計

	private long					tougetsuHasseiTotal5	= 0;	// 当月発生合計

	private long					tougetsuGensyoTotal5	= 0;	// 当月減少合計

	private long					tougetsuJitsugenTotal5	= 0;	// 当月実現合計

	private long					toukimatsuBokaTotal5	= 0;	// 当期末簿価合計

	private long					souPage					= 0;	// 総ページ数

	private long					page					= 0;	// ページ

	private int						lineCount				= 0;	// 明細カウンタ

	private String					index					= "";	// 明細行修飾子

	private Report					report					= null; // WebKCoreレポートオブジェクト

	private LACSMReportSisanBean	detail					= null;

	private String					ssnSriNm				= "";	// 資産種類名

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
	public LACSMReportPDFSisanWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
		LACSMReportSisanEntity reportEntity = new LACSMReportSisanEntity(super.model, commonBean, piReportBean);
		LACSMReportSisanBean sisandetail = null;
		try {
			reportEntity.setCon(super.con);
			reportEntity.execSQL();
			int dataCount = 0;
			while (reportEntity.next()) {
				sisandetail = new LACSMReportSisanBean();
				piReportBean.addSisanBean(sisandetail);

				sisandetail.setBrakeKey0(reportEntity.getBrakeKey0());
				sisandetail.setBrakeKey1(reportEntity.getBrakeKey1());
				sisandetail.setBrakeKey2(reportEntity.getBrakeKey2());
				sisandetail.setBrakeKey3(reportEntity.getBrakeKey3());
				sisandetail.setBrakeKey4(reportEntity.getBrakeKey4());
				sisandetail.setCreateDate(reportEntity.getCreateDate());
				sisandetail.setTermFrom(reportEntity.getStartYmd());
				sisandetail.setTermTo(reportEntity.getEndYmd());
				sisandetail.setLeasUserNm(reportEntity.getLeasUserNm());
				sisandetail.setLeasCompanyNm(reportEntity.getLeasCompanyNm());
				sisandetail.setAcKijyunName(reportEntity.getAcKijyunName());
				sisandetail.setAcKijyunCd(reportEntity.getAcKijyunCd());

				sisandetail.setTrdHnteKekaName(reportEntity.getTrdHnteKekaName());
				sisandetail.setTrdHnteKekaKbn(reportEntity.getTrdHnteKekaKbn());

				sisandetail.setAcShrKbnName(reportEntity.getAcShrKbnName());
				sisandetail.setAcShrKbn(reportEntity.getAcShrKbn());

				sisandetail.setSisanKbnName(reportEntity.getSisanKbnName());
				sisandetail.setSisanKbn(reportEntity.getSisanKbn());
				sisandetail.setSisanSyuruiName(reportEntity.getSisanSyuruiName());
				sisandetail.setSisanSyuruiCd(reportEntity.getSisanSyuruiCd());
				sisandetail.setKeiyakuNo(reportEntity.getKeiyakuNo());
				sisandetail.setHyoujiYouKeiyakuNo(reportEntity.getHyoujiYouKeiyakuNo());
				sisandetail.setBukenNo(reportEntity.getBukenNo());
				sisandetail.setBukenNm(reportEntity.getBukenNm());
				sisandetail.setSuryou(reportEntity.getSuryou());
				sisandetail.setLeaseFrom(reportEntity.getLeaseFrom());
				sisandetail.setSyutokuAmt(reportEntity.getSyutokuAmt());
				sisandetail.setSyoukyakuTerm(reportEntity.getSyoukyakuTerm());
				sisandetail.setSyoukyakuHohoNm(reportEntity.getSyoukyakuHohoNm());
				sisandetail.setSyoukyakuRt(reportEntity.getSyoukyakuRt());
				sisandetail.setMonthCount(reportEntity.getMonthCount());
				sisandetail.setZenkimatsuBoka(reportEntity.getZenkimatsuBoka());
				sisandetail.setTougetsuHassei(reportEntity.getTougetsuHassei());
				sisandetail.setTougetsuGensyo(reportEntity.getTougetsuGensyo());
				sisandetail.setTougetsuJitsugen(reportEntity.getTougetsuJitsugen());
				sisandetail.setToukimatsuBoka(reportEntity.getToukimatsuBoka());
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

		String brakeKey0 = ""; // ブレイクキー
		String brakeKey1 = ""; // ブレイクキー
		String brakeKey2 = ""; // ブレイクキー
		String brakeKey3 = ""; // ブレイクキー
		String brakeKey4 = ""; // ブレイクキー
		ssnSriNm = "";
		index = ""; // 明細行修飾子

		Field field = null;

		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		formDirectory = new File(wprlHomeDirectory, FORM_PATH);

		try {

			tmpFile = File.createTempFile("pdf15_", ".pdf", scratchDirectory);
			fout = new FileOutputStream(tmpFile);
			File formFile = new File(formDirectory, "SisanDaityou.pdf");
			File datFile = new File(formDirectory, "SisanDaityou.dat");
			report = new Report(formFile, datFile, fout);

			syutokuKakakuTotal = 0; // 取得価格合計
			zenkimatsuBokaTotal = 0; // 前期末簿価合計
			tougetsuHasseiTotal = 0; // 当月発生合計
			tougetsuGensyoTotal = 0; // 当月減少合計
			tougetsuJitsugenTotal = 0; // 当月実現合計
			toukimatsuBokaTotal = 0; // 当期末簿価合計

			syutokuKakakuTotal1 = 0; // 取得価格合計(会計基準)
			zenkimatsuBokaTotal1 = 0; // 前期末簿価合計(会計基準)
			tougetsuHasseiTotal1 = 0; // 当月発生合計(会計基準)
			tougetsuGensyoTotal1 = 0; // 当月減少合計(会計基準)
			tougetsuJitsugenTotal1 = 0; // 当月実現合計(会計基準)
			toukimatsuBokaTotal1 = 0; // 当期末簿価合計(会計基準)

			syutokuKakakuTotal2 = 0; // 取得価格合計(資産区分)
			zenkimatsuBokaTotal2 = 0; // 前期末簿価合計(資産区分)
			tougetsuHasseiTotal2 = 0; // 当月発生合計(資産区分)
			tougetsuGensyoTotal2 = 0; // 当月減少合計(資産区分)
			tougetsuJitsugenTotal2 = 0; // 当月実現合計(資産区分)
			toukimatsuBokaTotal2 = 0; // 当期末簿価合計(資産区分)

			syutokuKakakuTotal3 = 0; // 取得価格合計(資産種類)
			zenkimatsuBokaTotal3 = 0; // 前期末簿価合計(資産種類)
			tougetsuHasseiTotal3 = 0; // 当月発生合計(資産種類)
			tougetsuGensyoTotal3 = 0; // 当月減少合計(資産種類)
			tougetsuJitsugenTotal3 = 0; // 当月実現合計(資産種類)
			toukimatsuBokaTotal3 = 0; // 当期末簿価合計(資産種類)

			syutokuKakakuTotal4 = 0; // 取得価格合計(資産種類)
			zenkimatsuBokaTotal4 = 0; // 前期末簿価合計(資産種類)
			tougetsuHasseiTotal4 = 0; // 当月発生合計(資産種類)
			tougetsuGensyoTotal4 = 0; // 当月減少合計(資産種類)
			tougetsuJitsugenTotal4 = 0; // 当月実現合計(資産種類)
			toukimatsuBokaTotal4 = 0; // 当期末簿価合計(資産種類)

			syutokuKakakuTotal5 = 0; // 取得価格合計(資産種類)
			zenkimatsuBokaTotal5 = 0; // 前期末簿価合計(資産種類)
			tougetsuHasseiTotal5 = 0; // 当月発生合計(資産種類)
			tougetsuGensyoTotal5 = 0; // 当月減少合計(資産種類)
			tougetsuJitsugenTotal5 = 0; // 当月実現合計(資産種類)
			toukimatsuBokaTotal5 = 0; // 当期末簿価合計(資産種類)

			ssnSriNm = "";

			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				detail = piReportBean.getSisanBean(i);

				if (!detail.getBrakeKey4().equals(brakeKey4)) {
					if (!brakeKey4.equals("")) {

						if (lineCount >= MAX_LINE) {
							souPage++; // 総ページ数のカウントＵＰ
							lineCount = 0;
						}

						lineCount++;

						if (!detail.getBrakeKey3().equals(brakeKey3)) {

							if (lineCount >= MAX_LINE) {
								souPage++; // 総ページ数のカウントＵＰ
								lineCount = 0;
							}

							lineCount++;

							if (!detail.getBrakeKey2().equals(brakeKey2)) {

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
									if (!detail.getBrakeKey0().equals(brakeKey0)) {

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

					souPage++; // 総ページ数のカウントＵＰ
					lineCount = 0;

					brakeKey0 = detail.getBrakeKey0();
					brakeKey1 = detail.getBrakeKey1();
					brakeKey2 = detail.getBrakeKey2();
					brakeKey3 = detail.getBrakeKey3();
					brakeKey4 = detail.getBrakeKey4();
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

			lineCount = 0; // 明細カウンタ
			brakeKey0 = ""; // ブレイクキー
			brakeKey1 = ""; // ブレイクキー
			brakeKey2 = ""; // ブレイクキー
			brakeKey3 = ""; // ブレイクキー
			brakeKey4 = ""; // ブレイクキー

			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				detail = piReportBean.getSisanBean(i);

				if (!detail.getBrakeKey4().equals(brakeKey4)) {
					if (!brakeKey4.equals("")) {

						if (lineCount >= MAX_LINE) {
							detail = piReportBean.getSisanBean(i - 1);
							headPrint(piReportBean, piDateMode);
							detail = piReportBean.getSisanBean(i);
						}

						sisanSyuruiGokeiPrint(piReportBean);

						syutokuKakakuTotal5 = 0; // 取得価格合計
						zenkimatsuBokaTotal5 = 0; // 前期末簿価合計
						tougetsuHasseiTotal5 = 0; // 当月発生合計
						tougetsuGensyoTotal5 = 0; // 当月減少合計
						tougetsuJitsugenTotal5 = 0; // 当月実現合計
						toukimatsuBokaTotal5 = 0; // 当期末簿価合計

						if (!detail.getBrakeKey3().equals(brakeKey3)) {

							if (lineCount >= MAX_LINE) {
								detail = piReportBean.getSisanBean(i - 1);
								headPrint(piReportBean, piDateMode);
								detail = piReportBean.getSisanBean(i);
							}

							sisanKbnGokeiPrint(piReportBean);

							syutokuKakakuTotal4 = 0; // 取得価格合計
							zenkimatsuBokaTotal4 = 0; // 前期末簿価合計
							tougetsuHasseiTotal4 = 0; // 当月発生合計
							tougetsuGensyoTotal4 = 0; // 当月減少合計
							tougetsuJitsugenTotal4 = 0; // 当月実現合計
							toukimatsuBokaTotal4 = 0; // 当期末簿価合計

							if (!detail.getBrakeKey2().equals(brakeKey2)) {

								if (lineCount >= MAX_LINE) {
									detail = piReportBean.getSisanBean(i - 1);
									headPrint(piReportBean, piDateMode);
									detail = piReportBean.getSisanBean(i);
								}

								kaikeisyoriGokeiPrint(piReportBean);

								syutokuKakakuTotal3 = 0; // 取得価格合計
								zenkimatsuBokaTotal3 = 0; // 前期末簿価合計
								tougetsuHasseiTotal3 = 0; // 当月発生合計
								tougetsuGensyoTotal3 = 0; // 当月減少合計
								tougetsuJitsugenTotal3 = 0; // 当月実現合計
								toukimatsuBokaTotal3 = 0; // 当期末簿価合計
								if (!detail.getBrakeKey1().equals(brakeKey1)) {

									if (lineCount >= MAX_LINE) {
										detail = piReportBean.getSisanBean(i - 1);
										headPrint(piReportBean, piDateMode);
										detail = piReportBean.getSisanBean(i);
									}

									leasetorihikiGokeiPrint(piReportBean);

									syutokuKakakuTotal2 = 0; // 取得価格合計
									zenkimatsuBokaTotal2 = 0; // 前期末簿価合計
									tougetsuHasseiTotal2 = 0; // 当月発生合計
									tougetsuGensyoTotal2 = 0; // 当月減少合計
									tougetsuJitsugenTotal2 = 0; // 当月実現合計
									toukimatsuBokaTotal2 = 0; // 当期末簿価合計
									if (!detail.getBrakeKey0().equals(brakeKey0)) {

										if (lineCount >= MAX_LINE) {
											detail = piReportBean.getSisanBean(i - 1);
											headPrint(piReportBean, piDateMode);
											detail = piReportBean.getSisanBean(i);
										}

										kaikeikijyunGokeiPrint(piReportBean);

										syutokuKakakuTotal1 = 0; // 取得価格合計
										zenkimatsuBokaTotal1 = 0; // 前期末簿価合計
										tougetsuHasseiTotal1 = 0; // 当月発生合計
										tougetsuGensyoTotal1 = 0; // 当月減少合計
										tougetsuJitsugenTotal1 = 0; // 当月実現合計
										toukimatsuBokaTotal1 = 0; // 当期末簿価合計

									}
								}
							}

						}
					}

					headPrint(piReportBean, piDateMode);

					brakeKey0 = detail.getBrakeKey0();
					brakeKey1 = detail.getBrakeKey1();
					brakeKey2 = detail.getBrakeKey2();
					brakeKey3 = detail.getBrakeKey3();
					brakeKey4 = detail.getBrakeKey4();

				}
				else {

					if (lineCount >= MAX_LINE) {
						headPrint(piReportBean, piDateMode);
					}
				}

				index = Convert.toString(lineCount); // 明細行修飾子の設定
				field = report.getField("xKeiNo." + index); // 契約番号
				report.putFieldData(field, detail.getHyoujiYouKeiyakuNo());
				field = report.getField("xBknNo." + index); // 物件番号
				report.putFieldData(field, detail.getBukenNo());
				field = report.getField("xBknNm." + index); // 物件名
				report.putFieldData(field, detail.getBukenNm());
				field = report.getField("xSuryo." + index); // 数量
				if (detail.getSuryou() == null) {
					report.putFieldData(field, "");
				}
				else {
					report.putFieldData(field, StringUtl.formatNumber(Convert.toLong(detail.getSuryou())));
				}
				field = report.getField("xKnshuYm." + index); // 検収年月

				if (piDateMode == "2") {
					report.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getLeaseFrom()))), piDateMode).substring(0, 6));
				}
				else {
					report.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getLeaseFrom()))), piDateMode).substring(0, 7));
				}

				field = report.getField("xSyutokuKakaku." + index); // 取得価格
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyutokuAmt()));
				field = report.getField("xSyoukyakuHohou." + index); // 償却方法
				report.putFieldData(field, detail.getSyoukyakuHohoNm());
				field = report.getField("xSyoukyakuTerm." + index); // 償却期間
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyoukyakuTerm()) + "ヶ月");
				field = report.getField("xSyoukyakuRt." + index); // 償却率

				report.putFieldData(field, (detail.getSyoukyakuRt().trim().length() == 0 ? "-" : StringUtl.formatNumber(detail.getSyoukyakuRt(), "###.###") + "%"));

				field = report.getField("xTsukiSu." + index); // 月数
				report.putFieldData(field, StringUtl.formatNumber(detail.getMonthCount()) + "ヶ月");
				field = report.getField("xZenkimatsuBoka." + index); // 前期末簿価
				report.putFieldData(field, StringUtl.formatNumber(Convert.toLong(detail.getZenkimatsuBoka())));

				field = report.getField("xToukiHassei." + index); // 当月発生
				report.putFieldData(field, StringUtl.formatNumber(Convert.toLong(detail.getTougetsuHassei())));

				field = report.getField("xToukiGensyou." + index); // 当月減少
				report.putFieldData(field, StringUtl.formatNumber(Convert.toLong(detail.getTougetsuGensyo())));

				field = report.getField("xToukiJitusgen." + index); // 当月実現
				report.putFieldData(field, StringUtl.formatNumber(Convert.toLong(detail.getTougetsuJitsugen())));

				field = report.getField("xTougetsumatuBoka." + index); // 当期末簿価
				report.putFieldData(field, StringUtl.formatNumber(Convert.toLong(detail.getToukimatsuBoka())));

				ssnSriNm = detail.getSisanSyuruiName();
				syutokuKakakuTotal5 += detail.getSyutokuAmt();
				zenkimatsuBokaTotal5 += Convert.toLong(detail.getZenkimatsuBoka());
				tougetsuHasseiTotal5 += Convert.toLong(detail.getTougetsuHassei());
				tougetsuGensyoTotal5 += Convert.toLong(detail.getTougetsuGensyo());
				tougetsuJitsugenTotal5 += Convert.toLong(detail.getTougetsuJitsugen());
				toukimatsuBokaTotal5 += Convert.toLong(detail.getToukimatsuBoka());

				syutokuKakakuTotal4 += detail.getSyutokuAmt();
				zenkimatsuBokaTotal4 += Convert.toLong(detail.getZenkimatsuBoka());
				tougetsuHasseiTotal4 += Convert.toLong(detail.getTougetsuHassei());
				tougetsuGensyoTotal4 += Convert.toLong(detail.getTougetsuGensyo());
				tougetsuJitsugenTotal4 += Convert.toLong(detail.getTougetsuJitsugen());
				toukimatsuBokaTotal4 += Convert.toLong(detail.getToukimatsuBoka());

				syutokuKakakuTotal3 += detail.getSyutokuAmt();
				zenkimatsuBokaTotal3 += Convert.toLong(detail.getZenkimatsuBoka());
				tougetsuHasseiTotal3 += Convert.toLong(detail.getTougetsuHassei());
				tougetsuGensyoTotal3 += Convert.toLong(detail.getTougetsuGensyo());
				tougetsuJitsugenTotal3 += Convert.toLong(detail.getTougetsuJitsugen());
				toukimatsuBokaTotal3 += Convert.toLong(detail.getToukimatsuBoka());

				syutokuKakakuTotal2 += detail.getSyutokuAmt();
				zenkimatsuBokaTotal2 += Convert.toLong(detail.getZenkimatsuBoka());
				tougetsuHasseiTotal2 += Convert.toLong(detail.getTougetsuHassei());
				tougetsuGensyoTotal2 += Convert.toLong(detail.getTougetsuGensyo());
				tougetsuJitsugenTotal2 += Convert.toLong(detail.getTougetsuJitsugen());
				toukimatsuBokaTotal2 += Convert.toLong(detail.getToukimatsuBoka());

				syutokuKakakuTotal1 += detail.getSyutokuAmt();
				zenkimatsuBokaTotal1 += Convert.toLong(detail.getZenkimatsuBoka());
				tougetsuHasseiTotal1 += Convert.toLong(detail.getTougetsuHassei());
				tougetsuGensyoTotal1 += Convert.toLong(detail.getTougetsuGensyo());
				tougetsuJitsugenTotal1 += Convert.toLong(detail.getTougetsuJitsugen());
				toukimatsuBokaTotal1 += Convert.toLong(detail.getToukimatsuBoka());

				syutokuKakakuTotal += detail.getSyutokuAmt();
				zenkimatsuBokaTotal += Convert.toLong(detail.getZenkimatsuBoka());
				tougetsuHasseiTotal += Convert.toLong(detail.getTougetsuHassei());
				tougetsuGensyoTotal += Convert.toLong(detail.getTougetsuGensyo());
				tougetsuJitsugenTotal += Convert.toLong(detail.getTougetsuJitsugen());
				toukimatsuBokaTotal += Convert.toLong(detail.getToukimatsuBoka());
				lineCount++;
			}

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			sisanSyuruiGokeiPrint(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			sisanKbnGokeiPrint(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			kaikeisyoriGokeiPrint(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}
			leasetorihikiGokeiPrint(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}
			kaikeikijyunGokeiPrint(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}
			souGokeiPrint(piReportBean);

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

	private void headPrint(LACSMReportBean piReportBean, String piDateMode) throws Exception {
		Field field = null;

		report.createPage(1);

		lineCount = 0;

		field = report.getField("xPage");
		report.putFieldData(field, ++page + "/" + souPage);

		field = report.getField("xCreateDate");
		report.putFieldData(field, super.convertReki(Convert.toString(new Date()), piDateMode));

		field = report.getField("xLeaseCompanyNm");
		report.putFieldData(field, detail.getLeasCompanyNm());

		field = report.getField("xLeaseUserNm");
		report.putFieldData(field, detail.getLeasUserNm());

		field = report.getField("xTaisyouFrom");
		report.putFieldData(field, super.convertRekiLong(Convert.toString(Convert.toDate(Convert.toDateString(piReportBean.getTermFrom().getYYYYMMDD()))), piDateMode));

		field = report.getField("xTaisyouTo");
		report.putFieldData(field, super.convertRekiLong(Convert.toString(Convert.toDate(Convert.toDateString(piReportBean.getTermTo().getYYYYMMDD()))), piDateMode));

		field = report.getField("xKaikeiKijun");
		report.putFieldData(field, detail.getAcKijyunName());

		field = report.getField("xLeaseBunrui");
		report.putFieldData(field, detail.getTrdHnteKekaName());

		field = report.getField("xKaikeiSyoriHouhou");
		report.putFieldData(field, detail.getAcShrKbnName());

		field = report.getField("xSsnKbn");
		report.putFieldData(field, detail.getSisanKbnName());

		field = report.getField("xSsnSri");
		report.putFieldData(field, detail.getSisanSyuruiName());

		field = report.getField("xComment");
		report.putFieldData(field, COMMENT);
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

	private void sisanSyuruiGokeiPrint(LACSMReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xSsnSriNm" + index);

		report.putFieldData(field, ssnSriNm + "計");

		field = report.getField("xSyutokuKakaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakakuTotal5));

		field = report.getField("xZenkimatsuBoka" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatsuBokaTotal5));

		field = report.getField("xToukiHassei" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuHasseiTotal5));

		field = report.getField("xToukiGensyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuGensyoTotal5));

		field = report.getField("xToukiJitusgen" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuJitsugenTotal5));

		field = report.getField("xTougetsumatuBoka" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatsuBokaTotal5));
		lineCount++;
	}

	private void sisanKbnGokeiPrint(LACSMReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xSsnSriNm" + index);
		report.putFieldData(field, "資産区分計");

		field = report.getField("xSyutokuKakaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakakuTotal4));

		field = report.getField("xZenkimatsuBoka" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatsuBokaTotal4));

		field = report.getField("xToukiHassei" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuHasseiTotal4));

		field = report.getField("xToukiGensyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuGensyoTotal4));

		field = report.getField("xToukiJitusgen" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuJitsugenTotal4));

		field = report.getField("xTougetsumatuBoka" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatsuBokaTotal4));
		lineCount++;
	}

	private void kaikeikijyunGokeiPrint(LACSMReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xSsnSriNm" + index);
		report.putFieldData(field, "会計基準計");

		field = report.getField("xSyutokuKakaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakakuTotal1));

		field = report.getField("xZenkimatsuBoka" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatsuBokaTotal1));

		field = report.getField("xToukiHassei" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuHasseiTotal1));

		field = report.getField("xToukiGensyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuGensyoTotal1));

		field = report.getField("xToukiJitusgen" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuJitsugenTotal1));

		field = report.getField("xTougetsumatuBoka" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatsuBokaTotal1));
		lineCount++;
	}

	private void souGokeiPrint(LACSMReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xSsnSriNm" + index);
		report.putFieldData(field, "合　計");

		field = report.getField("xSyutokuKakaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakakuTotal));

		field = report.getField("xZenkimatsuBoka" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatsuBokaTotal));

		field = report.getField("xToukiHassei" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuHasseiTotal));

		field = report.getField("xToukiGensyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuGensyoTotal));

		field = report.getField("xToukiJitusgen" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuJitsugenTotal));

		field = report.getField("xTougetsumatuBoka" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatsuBokaTotal));
		lineCount++;
	}

	private void kaikeisyoriGokeiPrint(LACSMReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xSsnSriNm" + index);
		report.putFieldData(field, "会計処理計");

		field = report.getField("xSyutokuKakaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakakuTotal3));

		field = report.getField("xZenkimatsuBoka" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatsuBokaTotal3));

		field = report.getField("xToukiHassei" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuHasseiTotal3));

		field = report.getField("xToukiGensyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuGensyoTotal3));

		field = report.getField("xToukiJitusgen" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuJitsugenTotal3));

		field = report.getField("xTougetsumatuBoka" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatsuBokaTotal3));
		lineCount++;
	}

	private void leasetorihikiGokeiPrint(LACSMReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xSsnSriNm" + index);
		report.putFieldData(field, "リース取引分類計");

		field = report.getField("xSyutokuKakaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakakuTotal2));

		field = report.getField("xZenkimatsuBoka" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatsuBokaTotal2));

		field = report.getField("xToukiHassei" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuHasseiTotal2));

		field = report.getField("xToukiGensyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuGensyoTotal2));

		field = report.getField("xToukiJitusgen" + index);
		report.putFieldData(field, StringUtl.formatNumber(tougetsuJitsugenTotal2));

		field = report.getField("xTougetsumatuBoka" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatsuBokaTotal2));
		lineCount++;
	}
}
