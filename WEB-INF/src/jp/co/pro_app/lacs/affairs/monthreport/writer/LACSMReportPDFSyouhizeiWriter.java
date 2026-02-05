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
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportSyouhizeiBean;
import jp.co.pro_app.lacs.affairs.monthreport.data.entity.LACSMReportSyouhizeiEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

/**
 * 月次帳票出力：消費税明細票 Model.
 * 
 * @author yokota
 * @version 20081030
 */
public class LACSMReportPDFSyouhizeiWriter extends LACSMReportPDFWriterBase {

	private static final int			MAX_LINE						= 12;	// 明細行数

	private long						leaseRyoSougakuTotal			= 0;	// リース料総額合計

	private long						zankHoshoAmtTotal				= 0;	// うち保証残価合計

	private long						syouhizeiSougakuTotal			= 0;	// 消費税総額合計

	private long						toukiShiharaiLeaseRyoTotal		= 0;	// 当期支払リース料合計

	private long						toukiKaribaraiSyouhizeiTotal	= 0;	// 当期仮払消費税額合計

	private long						karibaraiSyouhizeiRuiTotal		= 0;	// 仮払消費税累計合計

	private long						miharaiSyouhizeiZanTotal		= 0;	// 未払消費税残高合計

	private long						miharaiSyouhizeiZanTotal1Nai	= 0;	// 未払消費税残高合計（１年内）

	private long						miharaiSyouhizeiZanTotal1Cyo	= 0;	// 未払消費税残高合計（１年超）

	private long						leaseRyoSougakuTotal1			= 0;	// リース料総額合計

	private long						zankHoshoAmtTotal1				= 0;	// うち保証残価合計

	private long						syouhizeiSougakuTotal1			= 0;	// 消費税総額合計

	private long						toukiShiharaiLeaseRyoTotal1		= 0;	// 当期支払リース料合計

	private long						toukiKaribaraiSyouhizeiTotal1	= 0;	// 当期仮払消費税額合計

	private long						karibaraiSyouhizeiRuiTotal1		= 0;	// 仮払消費税累計合計

	private long						miharaiSyouhizeiZanTotal1		= 0;	// 未払消費税残高合計

	private long						miharaiSyouhizeiZanTotal1Nai1	= 0;	// 未払消費税残高合計（１年内）

	private long						miharaiSyouhizeiZanTotal1Cyo1	= 0;	// 未払消費税残高

	private long						leaseRyoSougakuTotal2			= 0;	// リース料総額合計

	private long						zankHoshoAmtTotal2				= 0;	// うち保証残価合計

	private long						syouhizeiSougakuTotal2			= 0;	// 消費税総額合計

	private long						toukiShiharaiLeaseRyoTotal2		= 0;	// 当期支払リース料合計

	private long						toukiKaribaraiSyouhizeiTotal2	= 0;	// 当期仮払消費税額合計

	private long						karibaraiSyouhizeiRuiTotal2		= 0;	// 仮払消費税累計合計

	private long						miharaiSyouhizeiZanTotal2		= 0;	// 未払消費税残高合計

	private long						miharaiSyouhizeiZanTotal1Nai2	= 0;	// 未払消費税残高合計（１年内）

	private long						miharaiSyouhizeiZanTotal1Cyo2	= 0;	// 未払消費税残高

	private long						leaseRyoSougakuTotal3			= 0;	// リース料総額合計

	private long						zankHoshoAmtTotal3				= 0;	// うち保証残価合計

	private long						syouhizeiSougakuTotal3			= 0;	// 消費税総額合計

	private long						toukiShiharaiLeaseRyoTotal3		= 0;	// 当期支払リース料合計

	private long						toukiKaribaraiSyouhizeiTotal3	= 0;	// 当期仮払消費税額合計

	private long						karibaraiSyouhizeiRuiTotal3		= 0;	// 仮払消費税累計合計

	private long						miharaiSyouhizeiZanTotal3		= 0;	// 未払消費税残高合計

	private long						miharaiSyouhizeiZanTotal1Nai3	= 0;	// 未払消費税残高合計（１年内）

	private long						miharaiSyouhizeiZanTotal1Cyo3	= 0;	// 未払消費税残高

	private long						leaseRyoSougakuTotal4			= 0;	// リース料総額合計

	private long						zankHoshoAmtTotal4				= 0;	// うち保証残価合計

	private long						syouhizeiSougakuTotal4			= 0;	// 消費税総額合計

	private long						toukiShiharaiLeaseRyoTotal4		= 0;	// 当期支払リース料合計

	private long						toukiKaribaraiSyouhizeiTotal4	= 0;	// 当期仮払消費税額合計

	private long						karibaraiSyouhizeiRuiTotal4		= 0;	// 仮払消費税累計合計

	private long						miharaiSyouhizeiZanTotal4		= 0;	// 未払消費税残高合計

	private long						miharaiSyouhizeiZanTotal1Nai4	= 0;	// 未払消費税残高合計（１年内）

	private long						miharaiSyouhizeiZanTotal1Cyo4	= 0;	// 未払消費税残高

	private long						leaseRyoSougakuTotal5			= 0;	// リース料総額合計

	private long						zankHoshoAmtTotal5				= 0;	// うち保証残価合計

	private long						syouhizeiSougakuTotal5			= 0;	// 消費税総額合計

	private long						toukiShiharaiLeaseRyoTotal5		= 0;	// 当期支払リース料合計

	private long						toukiKaribaraiSyouhizeiTotal5	= 0;	// 当期仮払消費税額合計

	private long						karibaraiSyouhizeiRuiTotal5		= 0;	// 仮払消費税累計合計

	private long						miharaiSyouhizeiZanTotal5		= 0;	// 未払消費税残高合計

	private long						miharaiSyouhizeiZanTotal1Nai5	= 0;	// 未払消費税残高合計（１年内）

	private long						miharaiSyouhizeiZanTotal1Cyo5	= 0;	// 未払消費税残高

	private long						souPage							= 0;	// 総ページ数

	private long						page							= 0;	// ページ

	private int							lineCount						= 0;	// 明細カウンタ

	private String						index							= "";	// 明細行修飾子

	private Report						report							= null; // WebKCoreレポートオブジェクト

	private LACSMReportSyouhizeiBean	detail							= null;

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
	public LACSMReportPDFSyouhizeiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
		LACSMReportSyouhizeiEntity reportEntity = new LACSMReportSyouhizeiEntity(super.model, commonBean, piReportBean);
		LACSMReportSyouhizeiBean syouhizeidetail = null;
		try {
			reportEntity.setCon(super.con);
			reportEntity.execSQL();
			int dataCount = 0;
			while (reportEntity.next()) {
				syouhizeidetail = new LACSMReportSyouhizeiBean();
				piReportBean.addSyouhizeiBean(syouhizeidetail);

				syouhizeidetail.setBrakeKey0(reportEntity.getBrakeKey0());
				syouhizeidetail.setBrakeKey1(reportEntity.getBrakeKey1());
				syouhizeidetail.setBrakeKey2(reportEntity.getBrakeKey2());
				syouhizeidetail.setBrakeKey3(reportEntity.getBrakeKey3());
				syouhizeidetail.setBrakeKey4(reportEntity.getBrakeKey4());

				syouhizeidetail.setLeasUserNm(reportEntity.getLeasUserNm());
				syouhizeidetail.setLeaseCompany(reportEntity.getLeaseCompany());
				syouhizeidetail.setAcKijyunName(reportEntity.getAcKijyunName());
				syouhizeidetail.setAcShrKbnName(reportEntity.getAcShrKbnName());
				syouhizeidetail.setLeaseBunrui(reportEntity.getLeaseBunrui());
				syouhizeidetail.setStaxIktKbnName(reportEntity.getStaxIktKbnName());

				syouhizeidetail.setHyoujiYouKeiyakuNo(reportEntity.getKeiyakuNo());
				syouhizeidetail.setLeaseFrom(reportEntity.getLeaseFrom());
				syouhizeidetail.setLeaseTo(reportEntity.getLeaseTo());
				syouhizeidetail.setLeaseTerm(reportEntity.getLeaseTerm());
				syouhizeidetail.setBukenNo(reportEntity.getBukenNo());
				syouhizeidetail.setBukenNm(reportEntity.getBukenNm());
				syouhizeidetail.setKaiyakuYmd(reportEntity.getKaiyakuYmd());
				syouhizeidetail.setLeaseSougaku(reportEntity.getLeaseSougaku());
				syouhizeidetail.setZankHoshoAmt(reportEntity.getZankHoshoAmt());
				syouhizeidetail.setSyouhizeiSougaku(reportEntity.getSyouhizeiSougaku());
				syouhizeidetail.setToukSiharaiLeaseRyou(reportEntity.getToukSiharaiLeaseRyou());
				syouhizeidetail.setToukKariSyouhizeigaku(reportEntity.getToukKariSyouhizeigaku());
				syouhizeidetail.setKariSyouhizeiRuikei(reportEntity.getKariSyouhizeiRuikei());
				syouhizeidetail.setMibaraiSyouhizeiZan(reportEntity.getMibaraiSyouhizeiZan());
				syouhizeidetail.setMibaraiSyouhizeiZan1Nai(reportEntity.getMibaraiSyouhizeiZan1Nai());
				syouhizeidetail.setMibaraiSyouhizeiZan1Cyo(reportEntity.getMibaraiSyouhizeiZan1Cyo());

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

		index = ""; // 明細行修飾子

		Field field = null;

		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		formDirectory = new File(wprlHomeDirectory, FORM_PATH);

		try {

			tmpFile = File.createTempFile("pdf16_", ".pdf", scratchDirectory);
			fout = new FileOutputStream(tmpFile);
			File formFile = new File(formDirectory, "Syouhizei.pdf");
			File datFile = new File(formDirectory, "Syouhizei.dat");
			report = new Report(formFile, datFile, fout);

			leaseRyoSougakuTotal = 0; // リース料総額合計
			zankHoshoAmtTotal = 0; // うち保証残価合計
			syouhizeiSougakuTotal = 0; // 消費税総額合計
			toukiShiharaiLeaseRyoTotal = 0; // 当期支払リース料合計
			toukiKaribaraiSyouhizeiTotal = 0; // 当期仮払消費税額合計
			karibaraiSyouhizeiRuiTotal = 0; // 仮払消費税累計合計
			miharaiSyouhizeiZanTotal = 0; // 未払消費税残高合計
			miharaiSyouhizeiZanTotal1Nai = 0; // 未払消費税残高合計（１年内）
			miharaiSyouhizeiZanTotal1Cyo = 0; // 未払消費税残高合計（１年超）

			leaseRyoSougakuTotal1 = 0; // リース料総額合計
			zankHoshoAmtTotal1 = 0; // うち保証残価合計
			syouhizeiSougakuTotal1 = 0; // 消費税総額合計
			toukiShiharaiLeaseRyoTotal1 = 0; // 当期支払リース料合計
			toukiKaribaraiSyouhizeiTotal1 = 0; // 当期仮払消費税額合計
			karibaraiSyouhizeiRuiTotal1 = 0; // 仮払消費税累計合計
			miharaiSyouhizeiZanTotal1 = 0; // 未払消費税残高合計
			miharaiSyouhizeiZanTotal1Nai1 = 0; // 未払消費税残高合計（１年内）
			miharaiSyouhizeiZanTotal1Cyo1 = 0; // 未払消費税残高

			leaseRyoSougakuTotal2 = 0; // リース料総額合計
			zankHoshoAmtTotal2 = 0; // うち保証残価合計
			syouhizeiSougakuTotal2 = 0; // 消費税総額合計
			toukiShiharaiLeaseRyoTotal2 = 0; // 当期支払リース料合計
			toukiKaribaraiSyouhizeiTotal2 = 0; // 当期仮払消費税額合計
			karibaraiSyouhizeiRuiTotal2 = 0; // 仮払消費税累計合計
			miharaiSyouhizeiZanTotal2 = 0; // 未払消費税残高合計
			miharaiSyouhizeiZanTotal1Nai2 = 0; // 未払消費税残高合計（１年内）
			miharaiSyouhizeiZanTotal1Cyo2 = 0; // 未払消費税残高

			leaseRyoSougakuTotal3 = 0; // リース料総額合計
			zankHoshoAmtTotal3 = 0; // うち保証残価合計
			syouhizeiSougakuTotal3 = 0; // 消費税総額合計
			toukiShiharaiLeaseRyoTotal3 = 0; // 当期支払リース料合計
			toukiKaribaraiSyouhizeiTotal3 = 0; // 当期仮払消費税額合計
			karibaraiSyouhizeiRuiTotal3 = 0; // 仮払消費税累計合計
			miharaiSyouhizeiZanTotal3 = 0; // 未払消費税残高合計
			miharaiSyouhizeiZanTotal1Nai3 = 0; // 未払消費税残高合計（１年内）
			miharaiSyouhizeiZanTotal1Cyo3 = 0; // 未払消費税残高

			leaseRyoSougakuTotal4 = 0; // リース料総額合計
			zankHoshoAmtTotal4 = 0; // うち保証残価合計
			syouhizeiSougakuTotal4 = 0; // 消費税総額合計
			toukiShiharaiLeaseRyoTotal4 = 0; // 当期支払リース料合計
			toukiKaribaraiSyouhizeiTotal4 = 0; // 当期仮払消費税額合計
			karibaraiSyouhizeiRuiTotal4 = 0; // 仮払消費税累計合計
			miharaiSyouhizeiZanTotal4 = 0; // 未払消費税残高合計
			miharaiSyouhizeiZanTotal1Nai4 = 0; // 未払消費税残高合計（１年内）
			miharaiSyouhizeiZanTotal1Cyo4 = 0; // 未払消費税残高

			leaseRyoSougakuTotal5 = 0; // リース料総額合計
			zankHoshoAmtTotal5 = 0; // うち保証残価合計
			syouhizeiSougakuTotal5 = 0; // 消費税総額合計
			toukiShiharaiLeaseRyoTotal5 = 0; // 当期支払リース料合計
			toukiKaribaraiSyouhizeiTotal5 = 0; // 当期仮払消費税額合計
			karibaraiSyouhizeiRuiTotal5 = 0; // 仮払消費税累計合計
			miharaiSyouhizeiZanTotal5 = 0; // 未払消費税残高合計
			miharaiSyouhizeiZanTotal1Nai5 = 0; // 未払消費税残高合計（１年内）
			miharaiSyouhizeiZanTotal1Cyo5 = 0; // 未払消費税残高

			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				detail = piReportBean.getSyouhizeiBean(i);

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
				detail = piReportBean.getSyouhizeiBean(i);

				if (!detail.getBrakeKey4().equals(brakeKey4)) {
					if (!brakeKey4.equals("")) {

						if (lineCount >= MAX_LINE) {
							detail = piReportBean.getSyouhizeiBean(i - 1);
							headPrint(piReportBean, piDateMode);
							detail = piReportBean.getSyouhizeiBean(i);
						}

						kojoHouHoGokeiPrint(piReportBean);

						leaseRyoSougakuTotal5 = 0; // リース料総額合計
						zankHoshoAmtTotal5 = 0; // うち保証残価合計
						syouhizeiSougakuTotal5 = 0; // 消費税総額合計
						toukiShiharaiLeaseRyoTotal5 = 0; // 当期支払リース料合計
						toukiKaribaraiSyouhizeiTotal5 = 0; // 当期仮払消費税額合計
						karibaraiSyouhizeiRuiTotal5 = 0; // 仮払消費税累計合計
						miharaiSyouhizeiZanTotal5 = 0; // 未払消費税残高合計
						miharaiSyouhizeiZanTotal1Nai5 = 0; // 未払消費税残高合計（１年内）
						miharaiSyouhizeiZanTotal1Cyo5 = 0; // 未払消費税残高合計（１年超）

						if (!detail.getBrakeKey3().equals(brakeKey3)) {
							if (!brakeKey3.equals("")) {

								if (lineCount >= MAX_LINE) {
									detail = piReportBean.getSyouhizeiBean(i - 1);
									headPrint(piReportBean, piDateMode);
									detail = piReportBean.getSyouhizeiBean(i);
								}

								kaikeiSyotiGokeiPrint(piReportBean);

								leaseRyoSougakuTotal4 = 0; // リース料総額合計
								zankHoshoAmtTotal4 = 0; // うち保証残価合計
								syouhizeiSougakuTotal4 = 0; // 消費税総額合計
								toukiShiharaiLeaseRyoTotal4 = 0; // 当期支払リース料合計
								toukiKaribaraiSyouhizeiTotal4 = 0; // 当期仮払消費税額合計
								karibaraiSyouhizeiRuiTotal4 = 0; // 仮払消費税累計合計
								miharaiSyouhizeiZanTotal4 = 0; // 未払消費税残高合計
								miharaiSyouhizeiZanTotal1Nai4 = 0; // 未払消費税残高合計（１年内）
								miharaiSyouhizeiZanTotal1Cyo4 = 0; // 未払消費税残高合計（１年超）

								if (!detail.getBrakeKey2().equals(brakeKey2)) {
									if (!brakeKey2.equals("")) {

										if (lineCount >= MAX_LINE) {
											detail = piReportBean.getSyouhizeiBean(i - 1);
											headPrint(piReportBean, piDateMode);
											detail = piReportBean.getSyouhizeiBean(i);
										}

										leasTorihikiBunruiGokeiPrint(piReportBean);

										leaseRyoSougakuTotal3 = 0; // リース料総額合計
										zankHoshoAmtTotal3 = 0; // うち保証残価合計
										syouhizeiSougakuTotal3 = 0; // 消費税総額合計
										toukiShiharaiLeaseRyoTotal3 = 0; // 当期支払リース料合計
										toukiKaribaraiSyouhizeiTotal3 = 0; // 当期仮払消費税額合計
										karibaraiSyouhizeiRuiTotal3 = 0; // 仮払消費税累計合計
										miharaiSyouhizeiZanTotal3 = 0; // 未払消費税残高合計
										miharaiSyouhizeiZanTotal1Nai3 = 0; // 未払消費税残高合計（１年内）
										miharaiSyouhizeiZanTotal1Cyo3 = 0; // 未払消費税残高合計（１年超）

										if (!detail.getBrakeKey1().equals(brakeKey1)) {

											if (lineCount >= MAX_LINE) {
												detail = piReportBean.getSyouhizeiBean(i - 1);
												headPrint(piReportBean, piDateMode);
												detail = piReportBean.getSyouhizeiBean(i);
											}

											leaskaikeikijyunGokeiPrint(piReportBean);

											leaseRyoSougakuTotal2 = 0; // リース料総額合計
											zankHoshoAmtTotal2 = 0; // うち保証残価合計
											syouhizeiSougakuTotal2 = 0; // 消費税総額合計
											toukiShiharaiLeaseRyoTotal2 = 0; // 当期支払リース料合計
											toukiKaribaraiSyouhizeiTotal2 = 0; // 当期仮払消費税額合計
											karibaraiSyouhizeiRuiTotal2 = 0; // 仮払消費税累計合計
											miharaiSyouhizeiZanTotal2 = 0; // 未払消費税残高合計
											miharaiSyouhizeiZanTotal1Nai2 = 0; // 未払消費税残高合計（１年内）
											miharaiSyouhizeiZanTotal1Cyo2 = 0; // 未払消費税残高合計（１年超）

											if (!detail.getBrakeKey0().equals(brakeKey0)) {

												if (lineCount >= MAX_LINE) {
													detail = piReportBean.getSyouhizeiBean(i - 1);
													headPrint(piReportBean, piDateMode);
													detail = piReportBean.getSyouhizeiBean(i);
												}

												leasCompanyGokeiPrint(piReportBean);

												leaseRyoSougakuTotal1 = 0; // リース料総額合計
												zankHoshoAmtTotal1 = 0; // うち保証残価合計
												syouhizeiSougakuTotal1 = 0; // 消費税総額合計
												toukiShiharaiLeaseRyoTotal1 = 0; // 当期支払リース料合計
												toukiKaribaraiSyouhizeiTotal1 = 0; // 当期仮払消費税額合計
												karibaraiSyouhizeiRuiTotal1 = 0; // 仮払消費税累計合計
												miharaiSyouhizeiZanTotal1 = 0; // 未払消費税残高合計
												miharaiSyouhizeiZanTotal1Nai1 = 0; // 未払消費税残高合計（１年内）
												miharaiSyouhizeiZanTotal1Cyo1 = 0; // 未払消費税残高合計（１年超）

											}
										}
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
				field = report.getField("xLeaseFrom." + index); // リース開始日
				report.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getLeaseFrom()))), piDateMode));
				field = report.getField("xLeaseTo." + index); // リース終了日
				report.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getLeaseTo()))), piDateMode));
				field = report.getField("xLeaseKikan." + index); // リース期間
				report.putFieldData(field, detail.getLeaseTerm() + "ヶ月");
				field = report.getField("xBknNo." + index); // 物件番号
				report.putFieldData(field, detail.getBukenNo());
				field = report.getField("xBknNm." + index); // 物件名
				report.putFieldData(field, detail.getBukenNm());

				field = report.getField("xKaiyakuYmd." + index); // 中途解約日
				report.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getKaiyakuYmd()))), piDateMode));

				field = report.getField("xLeaseSougaku." + index); // リース料総額
				report.putFieldData(field, StringUtl.formatNumber(detail.getLeaseSougaku()));
				field = report.getField("xHosyoZanka." + index); // うち保証残価
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankHoshoAmt()));
				field = report.getField("xSyouhizeiSougaku." + index); // 消費税総額
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyouhizeiSougaku()));
				field = report.getField("xToukSiharaiLeaseRyou." + index); // 当期支払リース料
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukSiharaiLeaseRyou()));
				field = report.getField("xToukKariSyouhizeiGaku." + index); // 当期仮払消費税額
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukKariSyouhizeigaku()));
				field = report.getField("xKariSyouhizeiRuikei." + index); // 仮払消費税累計
				report.putFieldData(field, StringUtl.formatNumber(detail.getKariSyouhizeiRuikei()));
				field = report.getField("xMibaraiSyouhizeiZandaka." + index); // 未払消費税残高
				report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiSyouhizeiZan()));
				field = report.getField("xMibaraiSyouhizeiZan1Nennai." + index); // 未払消費税残高(１年内)
				report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiSyouhizeiZan1Nai()));
				field = report.getField("xMibaraiSyouhizeiZan1NenTyou." + index); // 未払消費税残高(１年超)
				report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiSyouhizeiZan1Cyo()));

				leaseRyoSougakuTotal5 += detail.getLeaseSougaku(); // リース料総額合計
				zankHoshoAmtTotal5 += detail.getZankHoshoAmt(); // うち保証残価合計
				syouhizeiSougakuTotal5 += detail.getSyouhizeiSougaku(); // 消費税総額合計
				toukiShiharaiLeaseRyoTotal5 += detail.getToukSiharaiLeaseRyou(); // 当期支払リース料合計
				toukiKaribaraiSyouhizeiTotal5 += detail.getToukKariSyouhizeigaku(); // 当期仮払消費税額合計
				karibaraiSyouhizeiRuiTotal5 += detail.getKariSyouhizeiRuikei(); // 仮払消費税累計合計
				miharaiSyouhizeiZanTotal5 += detail.getMibaraiSyouhizeiZan(); // 未払消費税残高合計
				miharaiSyouhizeiZanTotal1Nai5 += detail.getMibaraiSyouhizeiZan1Nai(); // 未払消費税残高合計（１年内）
				miharaiSyouhizeiZanTotal1Cyo5 += detail.getMibaraiSyouhizeiZan1Cyo(); // 未払消費税残高合計（１年超）

				leaseRyoSougakuTotal4 += detail.getLeaseSougaku(); // リース料総額合計
				zankHoshoAmtTotal4 += detail.getZankHoshoAmt(); // うち保証残価合計
				syouhizeiSougakuTotal4 += detail.getSyouhizeiSougaku(); // 消費税総額合計
				toukiShiharaiLeaseRyoTotal4 += detail.getToukSiharaiLeaseRyou(); // 当期支払リース料合計
				toukiKaribaraiSyouhizeiTotal4 += detail.getToukKariSyouhizeigaku(); // 当期仮払消費税額合計
				karibaraiSyouhizeiRuiTotal4 += detail.getKariSyouhizeiRuikei(); // 仮払消費税累計合計
				miharaiSyouhizeiZanTotal4 += detail.getMibaraiSyouhizeiZan(); // 未払消費税残高合計
				miharaiSyouhizeiZanTotal1Nai4 += detail.getMibaraiSyouhizeiZan1Nai(); // 未払消費税残高合計（１年内）
				miharaiSyouhizeiZanTotal1Cyo4 += detail.getMibaraiSyouhizeiZan1Cyo(); // 未払消費税残高合計（１年超）

				leaseRyoSougakuTotal3 += detail.getLeaseSougaku(); // リース料総額合計
				zankHoshoAmtTotal3 += detail.getZankHoshoAmt(); // うち保証残価合計
				syouhizeiSougakuTotal3 += detail.getSyouhizeiSougaku(); // 消費税総額合計
				toukiShiharaiLeaseRyoTotal3 += detail.getToukSiharaiLeaseRyou(); // 当期支払リース料合計
				toukiKaribaraiSyouhizeiTotal3 += detail.getToukKariSyouhizeigaku(); // 当期仮払消費税額合計
				karibaraiSyouhizeiRuiTotal3 += detail.getKariSyouhizeiRuikei(); // 仮払消費税累計合計
				miharaiSyouhizeiZanTotal3 += detail.getMibaraiSyouhizeiZan(); // 未払消費税残高合計
				miharaiSyouhizeiZanTotal1Nai3 += detail.getMibaraiSyouhizeiZan1Nai(); // 未払消費税残高合計（１年内）
				miharaiSyouhizeiZanTotal1Cyo3 += detail.getMibaraiSyouhizeiZan1Cyo(); // 未払消費税残高合計（１年超）

				leaseRyoSougakuTotal2 += detail.getLeaseSougaku(); // リース料総額合計
				zankHoshoAmtTotal2 += detail.getZankHoshoAmt(); // うち保証残価合計
				syouhizeiSougakuTotal2 += detail.getSyouhizeiSougaku(); // 消費税総額合計
				toukiShiharaiLeaseRyoTotal2 += detail.getToukSiharaiLeaseRyou(); // 当期支払リース料合計
				toukiKaribaraiSyouhizeiTotal2 += detail.getToukKariSyouhizeigaku(); // 当期仮払消費税額合計
				karibaraiSyouhizeiRuiTotal2 += detail.getKariSyouhizeiRuikei(); // 仮払消費税累計合計
				miharaiSyouhizeiZanTotal2 += detail.getMibaraiSyouhizeiZan(); // 未払消費税残高合計
				miharaiSyouhizeiZanTotal1Nai2 += detail.getMibaraiSyouhizeiZan1Nai(); // 未払消費税残高合計（１年内）
				miharaiSyouhizeiZanTotal1Cyo2 += detail.getMibaraiSyouhizeiZan1Cyo(); // 未払消費税残高合計（１年超）

				leaseRyoSougakuTotal1 += detail.getLeaseSougaku(); // リース料総額合計
				zankHoshoAmtTotal1 += detail.getZankHoshoAmt(); // うち保証残価合計
				syouhizeiSougakuTotal1 += detail.getSyouhizeiSougaku(); // 消費税総額合計
				toukiShiharaiLeaseRyoTotal1 += detail.getToukSiharaiLeaseRyou(); // 当期支払リース料合計
				toukiKaribaraiSyouhizeiTotal1 += detail.getToukKariSyouhizeigaku(); // 当期仮払消費税額合計
				karibaraiSyouhizeiRuiTotal1 += detail.getKariSyouhizeiRuikei(); // 仮払消費税累計合計
				miharaiSyouhizeiZanTotal1 += detail.getMibaraiSyouhizeiZan(); // 未払消費税残高合計
				miharaiSyouhizeiZanTotal1Nai1 += detail.getMibaraiSyouhizeiZan1Nai(); // 未払消費税残高合計（１年内）
				miharaiSyouhizeiZanTotal1Cyo1 += detail.getMibaraiSyouhizeiZan1Cyo(); // 未払消費税残高合計（１年超）

				leaseRyoSougakuTotal += detail.getLeaseSougaku(); // リース料総額合計
				zankHoshoAmtTotal += detail.getZankHoshoAmt(); // うち保証残価合計
				syouhizeiSougakuTotal += detail.getSyouhizeiSougaku(); // 消費税総額合計
				toukiShiharaiLeaseRyoTotal += detail.getToukSiharaiLeaseRyou(); // 当期支払リース料合計
				toukiKaribaraiSyouhizeiTotal += detail.getToukKariSyouhizeigaku(); // 当期仮払消費税額合計
				karibaraiSyouhizeiRuiTotal += detail.getKariSyouhizeiRuikei(); // 仮払消費税累計合計
				miharaiSyouhizeiZanTotal += detail.getMibaraiSyouhizeiZan(); // 未払消費税残高合計
				miharaiSyouhizeiZanTotal1Nai += detail.getMibaraiSyouhizeiZan1Nai(); // 未払消費税残高合計（１年内）
				miharaiSyouhizeiZanTotal1Cyo += detail.getMibaraiSyouhizeiZan1Cyo(); // 未払消費税残高合計（１年超）
				lineCount++;
			}

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			kojoHouHoGokeiPrint(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			kaikeiSyotiGokeiPrint(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			leasTorihikiBunruiGokeiPrint(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			leaskaikeikijyunGokeiPrint(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			leasCompanyGokeiPrint(piReportBean);

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

		field = report.getField("xTani");
		report.putFieldData(field, "円");

		field = report.getField("xLeaseCompanyNm");
		report.putFieldData(field, detail.getLeaseCompany());

		field = report.getField("xLeaseUserNm");
		report.putFieldData(field, detail.getLeasUserNm());

		field = report.getField("xTaisyouFrom");
		report.putFieldData(field, super.convertRekiLong(Convert.toString(Convert.toDate(Convert.toDateString(piReportBean.getTermFrom().getYYYYMMDD()))), piDateMode));

		field = report.getField("xTaisyouTo");
		report.putFieldData(field, super.convertRekiLong(Convert.toString(Convert.toDate(Convert.toDateString(piReportBean.getTermTo().getYYYYMMDD()))), piDateMode));

		field = report.getField("xKaikeiKijun");
		report.putFieldData(field, detail.getAcKijyunName());

		field = report.getField("xKaikeiSyoriHouhou");
		report.putFieldData(field, detail.getAcShrKbnName());

		field = report.getField("xKoujoHouhou");
		report.putFieldData(field, detail.getStaxIktKbnName());

		field = report.getField("xLeaseBunrui");
		report.putFieldData(field, detail.getLeaseBunrui());

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

	private void kojoHouHoGokeiPrint(LACSMReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xTotalTitle" + index);
		report.putFieldData(field, "控除方法計");

		field = report.getField("xLeaseSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseRyoSougakuTotal5));

		field = report.getField("xHosyoZanka" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankHoshoAmtTotal5));

		field = report.getField("xSyouhizeiSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syouhizeiSougakuTotal5));

		field = report.getField("xToukSiharaiLeaseRyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiShiharaiLeaseRyoTotal5));

		field = report.getField("xToukKariSyouhizeiGaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiKaribaraiSyouhizeiTotal5));

		field = report.getField("xKariSyouhizeiRuikei" + index);
		report.putFieldData(field, StringUtl.formatNumber(karibaraiSyouhizeiRuiTotal5));

		field = report.getField("xMibaraiSyouhizeiZandaka" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal5));

		field = report.getField("xMibaraiSyouhizeiZan1Nennai" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal1Nai5));

		field = report.getField("xMibaraiSyouhizeiZan1NenTyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal1Cyo5));
		lineCount++;
	}

	private void kaikeiSyotiGokeiPrint(LACSMReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xTotalTitle" + index);
		report.putFieldData(field, "会計処理方法計");

		field = report.getField("xLeaseSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseRyoSougakuTotal4));

		field = report.getField("xHosyoZanka" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankHoshoAmtTotal4));

		field = report.getField("xSyouhizeiSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syouhizeiSougakuTotal4));

		field = report.getField("xToukSiharaiLeaseRyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiShiharaiLeaseRyoTotal4));

		field = report.getField("xToukKariSyouhizeiGaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiKaribaraiSyouhizeiTotal4));

		field = report.getField("xKariSyouhizeiRuikei" + index);
		report.putFieldData(field, StringUtl.formatNumber(karibaraiSyouhizeiRuiTotal4));

		field = report.getField("xMibaraiSyouhizeiZandaka" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal4));

		field = report.getField("xMibaraiSyouhizeiZan1Nennai" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal1Nai4));

		field = report.getField("xMibaraiSyouhizeiZan1NenTyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal1Cyo4));
		lineCount++;
	}

	private void leasTorihikiBunruiGokeiPrint(LACSMReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xTotalTitle" + index);
		report.putFieldData(field, "リース取引分類計");

		field = report.getField("xLeaseSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseRyoSougakuTotal3));

		field = report.getField("xHosyoZanka" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankHoshoAmtTotal3));

		field = report.getField("xSyouhizeiSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syouhizeiSougakuTotal3));

		field = report.getField("xToukSiharaiLeaseRyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiShiharaiLeaseRyoTotal3));

		field = report.getField("xToukKariSyouhizeiGaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiKaribaraiSyouhizeiTotal3));

		field = report.getField("xKariSyouhizeiRuikei" + index);
		report.putFieldData(field, StringUtl.formatNumber(karibaraiSyouhizeiRuiTotal3));

		field = report.getField("xMibaraiSyouhizeiZandaka" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal3));

		field = report.getField("xMibaraiSyouhizeiZan1Nennai" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal1Nai3));

		field = report.getField("xMibaraiSyouhizeiZan1NenTyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal1Cyo3));
		lineCount++;
	}

	private void leaskaikeikijyunGokeiPrint(LACSMReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xTotalTitle" + index);
		report.putFieldData(field, "リース会計基準計");

		field = report.getField("xLeaseSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseRyoSougakuTotal2));

		field = report.getField("xHosyoZanka" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankHoshoAmtTotal2));

		field = report.getField("xSyouhizeiSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syouhizeiSougakuTotal2));

		field = report.getField("xToukSiharaiLeaseRyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiShiharaiLeaseRyoTotal2));

		field = report.getField("xToukKariSyouhizeiGaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiKaribaraiSyouhizeiTotal2));

		field = report.getField("xKariSyouhizeiRuikei" + index);
		report.putFieldData(field, StringUtl.formatNumber(karibaraiSyouhizeiRuiTotal2));

		field = report.getField("xMibaraiSyouhizeiZandaka" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal2));

		field = report.getField("xMibaraiSyouhizeiZan1Nennai" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal1Nai2));

		field = report.getField("xMibaraiSyouhizeiZan1NenTyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal1Cyo2));
		lineCount++;
	}

	private void leasCompanyGokeiPrint(LACSMReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xTotalTitle" + index);
		report.putFieldData(field, "リース会社計");

		field = report.getField("xLeaseSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseRyoSougakuTotal1));

		field = report.getField("xHosyoZanka" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankHoshoAmtTotal1));

		field = report.getField("xSyouhizeiSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syouhizeiSougakuTotal1));

		field = report.getField("xToukSiharaiLeaseRyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiShiharaiLeaseRyoTotal1));

		field = report.getField("xToukKariSyouhizeiGaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiKaribaraiSyouhizeiTotal1));

		field = report.getField("xKariSyouhizeiRuikei" + index);
		report.putFieldData(field, StringUtl.formatNumber(karibaraiSyouhizeiRuiTotal1));

		field = report.getField("xMibaraiSyouhizeiZandaka" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal1));

		field = report.getField("xMibaraiSyouhizeiZan1Nennai" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal1Nai1));

		field = report.getField("xMibaraiSyouhizeiZan1NenTyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal1Cyo1));
		lineCount++;
	}

	private void souGokeiPrint(LACSMReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xTotalTitle" + index);
		report.putFieldData(field, "合　計");

		field = report.getField("xLeaseSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseRyoSougakuTotal));

		field = report.getField("xHosyoZanka" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankHoshoAmtTotal));

		field = report.getField("xSyouhizeiSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syouhizeiSougakuTotal));

		field = report.getField("xToukSiharaiLeaseRyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiShiharaiLeaseRyoTotal));

		field = report.getField("xToukKariSyouhizeiGaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiKaribaraiSyouhizeiTotal));

		field = report.getField("xKariSyouhizeiRuikei" + index);
		report.putFieldData(field, StringUtl.formatNumber(karibaraiSyouhizeiRuiTotal));

		field = report.getField("xMibaraiSyouhizeiZandaka" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal));

		field = report.getField("xMibaraiSyouhizeiZan1Nennai" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal1Nai));

		field = report.getField("xMibaraiSyouhizeiZan1NenTyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(miharaiSyouhizeiZanTotal1Cyo));
		lineCount++;
	}
}
