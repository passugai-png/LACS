package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBukkenBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportBukkenEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

/**
 * 帳票出力：リース料支払スケジュール（物件単位）Model.
 * 
 * @author ohmura
 * @version 20070905
 */
public class LACSReportPDFBukkenWriter extends LACSReportPDFWriterBase {

	private int					souPage				= 0;							// 総ページ数

	private int					page				= 0;							// ページ

	private int					lineCount			= 0;							// 明細カウンタ

	private String				brakeKey			= "";							// ブレイクキー

	private String				index				= "";							// 明細行修飾子

	private long				siharaiLeaseRyou	= 0;							// (支払リース料)

	private long				ekimuhi				= 0;							// 役務提供費

	private long				ijikanriHi			= 0;							// (維持管理費相当額)

	private long				netSiharaiLeaseRyou	= 0;							// (NET支払リース料)

	private long				uchiRisokuBun		= 0;							// (うち利息分)

	private long				uchiLeaseSaimuBun	= 0;							// (うちリース債務分)

	private long				siharaiRisoku		= 0;							// (支払利息相当額)

	private static final int	MAX_LINE			= 29;							// 明細行数

	private static final String	KAIKEI_0			= "0";							// 賃貸借処理(詳細注記)

	private static final String	KAIKEI_TITLE		= "会計処理方法　　　：";

	private static final String	MAE_BARAI			= "前払";

	private static final String	ATO_BARAI			= "後払";

	private static final String	TITLE_1				= "取得価格相当額　　：";

	private static final String	TITLE_2				= "支払利息相当額総額：";

	private static final String	TITLE_3				= "利息計算利子率　　：";

	private static final String	TITLE_4				= "利息相当額配分方法：";

	private static final String	HEAD_TITLE6			= "+ 残価保証額（ﾘｰｽ終了月の支払ﾘｰｽ料に加算）";

	private static final String	HEAD_TTILE5			= "- 役務提供費（控除する場合のみ）";

	private static final String	TITLE_COMP			= "リース会社　：";

	private static final String	TITLE_USER			= "開示先　　　：";

	/**
	 * コンストラクタ.
	 * 
	 * @param piCommonBean
	 *            LACS用共通Bean
	 * @param piModel
	 *            Modelクラス
	 * @param piCon
	 *            DB接続
	 */
	public LACSReportPDFBukkenWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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

		File wprlHomeDirectory = new File(PdfProperties.getInstance().getProperty(PdfProperties.WKC_PDF_HOME));

		File tmpFile = null; // 出力先ファイル
		FileOutputStream fout = null; // 出力ファイルストリーム

		Report report = null; // WebKCoreレポートオブジェクト
		LACSReportBukkenBean detail = null;

		Field field = null;

		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		formDirectory = new File(wprlHomeDirectory, FORM_PATH);

		souPage = 0; // 総ページ数
		page = 0; // ページ
		lineCount = 0; // 明細カウンタ
		brakeKey = ""; // ブレイクキー
		index = ""; // 明細行修飾子

		try {
			String chkName = "";
			if (piReportBean.getDataMax() > 0) {

				tmpFile = File.createTempFile("pdf05_", ".pdf", scratchDirectory);
				fout = new FileOutputStream(tmpFile);
				File formFile = new File(formDirectory, "Bukken.pdf");
				File datFile = new File(formDirectory, "Bukken.dat");
				report = new Report(formFile, datFile, fout);

				siharaiLeaseRyou = 0; // (支払リース料)
				ekimuhi = 0;
				ijikanriHi = 0; // (維持管理費相当額)
				netSiharaiLeaseRyou = 0; // (NET支払リース料)
				uchiRisokuBun = 0; // (うち利息分)
				uchiLeaseSaimuBun = 0; // (うちリース債務分)
				siharaiRisoku = 0; // (支払利息相当額)

				String kaikeisyori = piReportBean.getKaikeiSyori();

				for (int i = 0; i < piReportBean.getDataMax(); i++) {
					detail = piReportBean.getBukkenBean(i);

					if (!detail.getBrakeKey().equals(brakeKey)) {
						if (!brakeKey.equals("")) {

							if (lineCount >= MAX_LINE) {
								souPage++; // 総ページ数のカウントＵＰ
								lineCount = 0;

							}

							lineCount++;
						}

						souPage++; // 総ページ数のカウントＵＰ
						lineCount = 0;

						brakeKey = detail.getBrakeKey();
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

				lineCount = 0; // 明細カウンタ
				brakeKey = ""; // ブレイクキー

				for (int i = 0; i < piReportBean.getDataMax(); i++) {
					detail = piReportBean.getBukkenBean(i);

					if (!detail.getBrakeKey().equals(brakeKey)) {
						if (!brakeKey.equals("")) {

							if (lineCount >= MAX_LINE) {

								detail = piReportBean.getBukkenBean(i - 1);
								headPrint(detail, report, kaikeisyori, piDateMode);
								detail = piReportBean.getBukkenBean(i);

							}

							gokeiPrint(piReportBean, report);

							siharaiLeaseRyou = 0; // (支払リース料)
							ekimuhi = 0;
							ijikanriHi = 0; // (維持管理費相当額)
							netSiharaiLeaseRyou = 0; // (NET支払リース料)
							uchiRisokuBun = 0; // (うち利息分)
							uchiLeaseSaimuBun = 0; // (うちリース債務分)
							siharaiRisoku = 0; // (支払利息相当額)

						}

						headPrint(detail, report, kaikeisyori, piDateMode);

						brakeKey = detail.getBrakeKey();
					}
					else {

						if (lineCount >= MAX_LINE) {
							headPrint(detail, report, kaikeisyori, piDateMode);
						}
					}

					index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

					field = report.getField("xSiharaiNenTuki" + index);
					String siharaiNenTuki = super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getSiharaiNenTuki() + "01"))), piDateMode).substring(0, 7);
					if (siharaiNenTuki.indexOf("/") == 3) {
						siharaiNenTuki = siharaiNenTuki.substring(0, 6);
					}
					report.putFieldData(field, siharaiNenTuki);

					field = report.getField("xSiharaiLeaseRyou" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getSiharaiLeaseRyou()));

					field = report.getField("xEkimuTeikyouhi" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getEkmTeikhyo()));

					field = report.getField("xIjikanriHi" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getIjikanriHi()));

					field = report.getField("xNetSiharaiLeaseRyou" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getNetSiharaiLeaseRyou()));

					field = report.getField("xUchiRisokuBun" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getUchiRisokuBun()));

					field = report.getField("xUchiLeaseSaimuBun" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getUchiLeaseSaimuBun()));

					field = report.getField("xMikeikaKimatuZan" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaKimatuZan()));

					field = report.getField("xSiharaiRisoku" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getSiharaiRisoku()));

					siharaiLeaseRyou = siharaiLeaseRyou + detail.getSiharaiLeaseRyou();
					ekimuhi = ekimuhi + detail.getEkmTeikhyo();

					ijikanriHi = ijikanriHi + detail.getIjikanriHi();
					netSiharaiLeaseRyou = netSiharaiLeaseRyou + detail.getNetSiharaiLeaseRyou();
					uchiRisokuBun = uchiRisokuBun + detail.getUchiRisokuBun();
					uchiLeaseSaimuBun = uchiLeaseSaimuBun + detail.getUchiLeaseSaimuBun();
					siharaiRisoku = siharaiRisoku + detail.getSiharaiRisoku();

					lineCount++;
				}

				if (lineCount >= MAX_LINE) {
					headPrint(detail, report, kaikeisyori, piDateMode);
				}

				gokeiPrint(piReportBean, report);
				report.close();
				report = null;
				chkName = tmpFile.getName();
			}
			return chkName;
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

	private void headPrint(LACSReportBukkenBean piDetail, Report piReport, String piKaikeiSyori, String piDateMode) throws Exception {

		Field field = null;

		piReport.createPage(1);

		lineCount = 0;

		field = piReport.getField("xPage");
		piReport.putFieldData(field, ++page + "/" + souPage);

		field = piReport.getField("xDate");
		piReport.putFieldData(field, super.convertReki(Convert.toString(new Date()), piDateMode));

		field = piReport.getField("xKijyunDate");
		piReport.putFieldData(field, super.convertReki(Convert.toString(new Date()), piDateMode));

		field = piReport.getField("xLeaseCompany");
		piReport.putFieldData(field, piDetail.getLeasCompanyNm());

		field = piReport.getField("xLeaseUser");
		piReport.putFieldData(field, piDetail.getLeasUserNm());

		field = piReport.getField("xKeiyakuNo");
		piReport.putFieldData(field, piDetail.getKeiyakuNo());

		field = piReport.getField("xBukenNo");
		piReport.putFieldData(field, piDetail.getBukenNo());

		field = piReport.getField("xLeaseBunrui");
		piReport.putFieldData(field, piDetail.getLeaseBunrui());

		field = piReport.getField("xKoteiSisanKamoku");
		piReport.putFieldData(field, piDetail.getKoteiSisanKamoku());

		field = piReport.getField("xLeaseFrom");
		piReport.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(piDetail.getLeaseFrom()))), piDateMode));

		field = piReport.getField("xLeaseTo");
		piReport.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(piDetail.getLeaseTo()))), piDateMode));

		field = piReport.getField("xLeaseTerm");
		piReport.putFieldData(field, StringUtl.formatNumber(piDetail.getLeaseTerm()));

		field = piReport.getField("xBukenNm");
		piReport.putFieldData(field, piDetail.getBukenNm());

		field = piReport.getField("xLeaseSougaku");
		piReport.putFieldData(field, StringUtl.formatNumber(piDetail.getLeaseSougaku()));

		field = piReport.getField("xEkimuTeikyouhiSougaku");
		piReport.putFieldData(field, StringUtl.formatNumber(piDetail.getEkmteikhyoSougaku()));

		field = piReport.getField("xIjikanriHiSougaku");
		piReport.putFieldData(field, StringUtl.formatNumber(piDetail.getIjikanriHiSougaku()));

		field = piReport.getField("xMitumoriGenkinKakaku");
		piReport.putFieldData(field, StringUtl.formatNumber(piDetail.getMitumoriGenkinKakaku()));

		field = piReport.getField("xZanHosyou");
		piReport.putFieldData(field, StringUtl.formatNumber(piDetail.getZanHosyou()));

		field = piReport.getField("xWaribikiRisiRitu");
		piReport.putFieldData(field, piDetail.getWaribikiRisiRitu() + "%");

		if (piDetail.getMaeBaraiAtoBarai() != null) {
			if (piDetail.getMaeBaraiAtoBarai().equals("0")) {
				field = piReport.getField("xMaeBaraiAtoBarai");
				piReport.putFieldData(field, MAE_BARAI);
			}
			else {
				field = piReport.getField("xMaeBaraiAtoBarai");
				piReport.putFieldData(field, ATO_BARAI);
			}
		}

		field = piReport.getField("xLeasCompanyTitle");
		piReport.putFieldData(field, TITLE_COMP);

		field = piReport.getField("xLeasUserTitle");
		piReport.putFieldData(field, TITLE_USER);

		field = piReport.getField("xWaribikiGenzaiKakaku");
		piReport.putFieldData(field, StringUtl.formatNumber(piDetail.getWaribikiGenzaiKakaku()));

		field = piReport.getField("xToukiReaseRyouKeisanKijyun");
		piReport.putFieldData(field, piDetail.getToukiReaseRyouKeisanKijyun());

		field = piReport.getField("xHeadTitle4");
		piReport.putFieldData(field, "うち残価保証額");

		field = piReport.getField("xHeadTitle4Sep");
		piReport.putFieldData(field, ":");

		field = piReport.getField("xHeadTitle5");
		piReport.putFieldData(field, HEAD_TTILE5);

		field = piReport.getField("xHeadTitle6");
		piReport.putFieldData(field, HEAD_TITLE6);

		field = piReport.getField("xKaikeiSyoriHouhouTitle");
		piReport.putFieldData(field, KAIKEI_TITLE);

		field = piReport.getField("xlblKara");
		piReport.putFieldData(field, "～");

		field = piReport.getField("xlblKagetsu");
		piReport.putFieldData(field, "ヶ月");

		field = piReport.getField("xLeaseSoutougaku");
		piReport.putFieldData(field, "リース料相当額総額");

		field = piReport.getField("xHeadTitle1");
		piReport.putFieldData(field, "維持管理費相当額総額");
		field = piReport.getField("xHeadTitle1Sep");
		piReport.putFieldData(field, ":");

		field = piReport.getField("xHeadTitle2");
		piReport.putFieldData(field, "役務提供費相当額総額");
		field = piReport.getField("xHeadTitle2Sep");
		piReport.putFieldData(field, ":");

		field = piReport.getField("xHeadTitle3");
		piReport.putFieldData(field, "見積現金購入価格");
		field = piReport.getField("xHeadTitle3Sep");
		piReport.putFieldData(field, ":");

		field = piReport.getField("xTitleWaribikiRisiRitu");
		piReport.putFieldData(field, "割引計算利子率　　：");

		field = piReport.getField("xTitleMaeBaraiAtoBarai");
		piReport.putFieldData(field, "前払／後払区分　　：");

		field = piReport.getField("xTitleWaribikiGenzaiKakaku");
		piReport.putFieldData(field, "割引現在価値　　　：");

		field = piReport.getField("xTitleFukinTenkaiHoho");
		piReport.putFieldData(field, "賦金展開方法　　　：");

		if (piKaikeiSyori.equals(KAIKEI_0)) {
			field = piReport.getField("xTitleSyutokuKakakuSoutou");
			piReport.putFieldData(field, TITLE_1);

			field = piReport.getField("xSyutokuKakakuSoutou");
			piReport.putFieldData(field, StringUtl.formatNumber(piDetail.getSyutokuKakakuSoutou()));

			field = piReport.getField("xTitleSiharaiRisokuSougaku");
			piReport.putFieldData(field, TITLE_2);

			field = piReport.getField("xSiharaiRisokuSougaku");
			piReport.putFieldData(field, StringUtl.formatNumber(piDetail.getSiharaiRisokuSougaku()));

			String rskKeijyohohoKbn = piDetail.getRskkeijhohoKbn();

			field = piReport.getField("xTitleRisokuRisiRitu");
			if (rskKeijyohohoKbn.equals(LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201)) {
				piReport.putFieldData(field, "");
			}
			else {
				if (rskKeijyohohoKbn.equals(LACSDefine.RisokuKeijoHohoKbn.KINTOHO_301)) {
					piReport.putFieldData(field, "");
				}
				else {
					piReport.putFieldData(field, TITLE_3);
				}
			}

			field = piReport.getField("xRisokuRisiRitu");

			if (piDetail.getRisokuRisiRitu() == null) {
				piReport.putFieldData(field, "");
			}
			else {
				piReport.putFieldData(field, piDetail.getRisokuRisiRitu() + "%");
			}

			field = piReport.getField("xTitleRisokuBunpaiHouhou");
			piReport.putFieldData(field, TITLE_4);

			field = piReport.getField("xRisokuBunpaiHouhou");
			piReport.putFieldData(field, piDetail.getRisokuBunpaiHouhou());

		}

		field = piReport.getField("xKaikeiSyoriHouhou");
		piReport.putFieldData(field, piDetail.getAcShrKbnName());

		field = piReport.getField("xComment");
		piReport.putFieldData(field, COMMENT);
	}

	private void gokeiPrint(LACSReportBean piReportBean, Report piReport) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = piReport.getField("xSiharaiNenTuki" + index);
		piReport.putFieldData(field, "　　　　　合計");

		field = piReport.getField("xSiharaiLeaseRyou" + index);
		piReport.putFieldData(field, StringUtl.formatNumber(siharaiLeaseRyou));

		field = piReport.getField("xEkimuTeikyouhi" + index);
		piReport.putFieldData(field, StringUtl.formatNumber(ekimuhi));

		field = piReport.getField("xIjikanriHi" + index);
		piReport.putFieldData(field, StringUtl.formatNumber(ijikanriHi));

		field = piReport.getField("xNetSiharaiLeaseRyou" + index);
		piReport.putFieldData(field, StringUtl.formatNumber(netSiharaiLeaseRyou));

		field = piReport.getField("xUchiRisokuBun" + index);
		piReport.putFieldData(field, StringUtl.formatNumber(uchiRisokuBun));

		field = piReport.getField("xUchiLeaseSaimuBun" + index);
		piReport.putFieldData(field, StringUtl.formatNumber(uchiLeaseSaimuBun));

		field = piReport.getField("xMikeikaKimatuZan" + index);
		piReport.putFieldData(field, "0");

		field = piReport.getField("xSiharaiRisoku" + index);
		piReport.putFieldData(field, StringUtl.formatNumber(siharaiRisoku));

		lineCount++;
	}

	/**
	 * 出力データ取得2.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	public void getData(LACSReportBean piReportBean) throws SQLException {
		LACSReportBukkenEntity reportEntity = new LACSReportBukkenEntity(super.model, commonBean, piReportBean, this.acStd);
		LACSReportBukkenBean bukkenDetail = null;

		try {
			reportEntity.setCon(super.con);

			piReportBean.setDataMax(reportEntity.execSQL());

			while (reportEntity.next()) {
				bukkenDetail = new LACSReportBukkenBean();
				piReportBean.addBukkenBean(bukkenDetail);

				bukkenDetail.setBrakeKey(reportEntity.getBrakeKey());
				bukkenDetail.setLeaseCompany(reportEntity.getLeaseCompany());
				bukkenDetail.setKeiyakuNo(reportEntity.getKeiNo());
				bukkenDetail.setBukenNo(reportEntity.getBukenNo());
				bukkenDetail.setLeaseBunrui(reportEntity.getLeaseBunrui());
				bukkenDetail.setKoteiSisanKamoku(reportEntity.getKoteiSisanKamoku());
				bukkenDetail.setLeaseFrom(reportEntity.getLeaseFrom());
				bukkenDetail.setLeaseTo(reportEntity.getLeaseTo());
				bukkenDetail.setLeaseTerm(reportEntity.getLeaseTerm());
				bukkenDetail.setBukenNm(reportEntity.getBukenNm());
				bukkenDetail.setLeaseSougaku(reportEntity.getLeaseSougaku());
				bukkenDetail.setRskkeijhohoKbn(reportEntity.getRskkeijhohoKbn());
				bukkenDetail.setEkmteikhyoSougaku(reportEntity.getEkmteikhyoSougaku());
				bukkenDetail.setIjikanriHiSougaku(reportEntity.getIjikanriHiSougaku());
				bukkenDetail.setMitumoriGenkinKakaku(reportEntity.getMitumoriGenkinKakaku());
				bukkenDetail.setZanHosyou(reportEntity.getZanHosyou());

				bukkenDetail.setWaribikiRisiRitu(reportEntity.getWaribikiRisiRitu());
				bukkenDetail.setMaeBaraiAtoBarai(reportEntity.getMaeBaraiAtoBarai());
				bukkenDetail.setWaribikiGenzaiKakaku(reportEntity.getWaribikiGenzaiKakaku());

				bukkenDetail.setSyutokuKakakuSoutou(reportEntity.getSyutokuKakakuSoutou());
				bukkenDetail.setSiharaiRisokuSougaku(reportEntity.getSiharaiRisokuSougaku());
				bukkenDetail.setRisokuRisiRitu(reportEntity.getRisokuRisiRitu());

				bukkenDetail.setToukiReaseRyouKeisanKijyun(reportEntity.getToukiReaseRyouKeisanKijyun());
				bukkenDetail.setRisokuBunpaiHouhou(reportEntity.getRisokuBunpaiHouhou());

				bukkenDetail.setSiharaiNenTuki(reportEntity.getSiharaiNenTuki());
				bukkenDetail.setSiharaiLeaseRyou(reportEntity.getSiharaiLeaseRyou());
				bukkenDetail.setEkmTeikhyo(reportEntity.getEkmteikhyo());
				bukkenDetail.setIjikanriHi(reportEntity.getIjikanriHi());
				bukkenDetail.setNetSiharaiLeaseRyou(reportEntity.getNetSiharaiLeaseRyou());
				bukkenDetail.setUchiRisokuBun(reportEntity.getUchiRisokuBun());
				bukkenDetail.setUchiLeaseSaimuBun(reportEntity.getUchiLeaseSaimuBun());
				bukkenDetail.setMikeikaKimatuZan(reportEntity.getMikeikaKimatuZan());
				bukkenDetail.setSiharaiRisoku(reportEntity.getSiharaiRisoku());
				bukkenDetail.setLeasCompanyNm(reportEntity.getLeasCompanyNm());
				bukkenDetail.setLeasUserNm(reportEntity.getLeasUserNm());

				bukkenDetail.setAcShrKbnName(reportEntity.getAcShrKbnName());

			}

		}
		finally {
			reportEntity.close();
		}
	}
}
