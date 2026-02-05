package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportGenkaBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportGenkaEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

/**
 * 帳票出力：リース会計資料（減価償却費）Model.
 * 
 * @author ohmura
 * @version 20070829
 */ 
public class LACSReportPDFGenkaWriter extends LACSReportPDFWriterBase {

	private Report				report					= null;				// WebKCoreレポートオブジェクト

	private LACSReportGenkaBean	detail					= null;

	// 2020/05/22 REP START LACS帳票バッチ出力
	//private long					souPage					= 0;						// 総ページ数
	private int						souPage					= 0;						// 総ページ数
	// 2020/05/22 REP END   LACS帳票バッチ出力

	private long				page					= 0;					// ページ

	private int					lineCount				= 0;					// 明細カウンタ

	private String				index					= "";					// 明細行修飾子

	private long				syutokuKakaku			= 0;					// (取得価格相当額)

	private long				zanHosyou				= 0;					// (残価保証額)

	private long				toukiGenkasyokyaku		= 0;					// (当期減価償却費)

	private long				genkasyoukyakuRuikei	= 0;					// (減価償却累計額)

	private long				kimatuZan				= 0;					// (期末残高相当額)

	private long				syutokuKakaku0			= 0;					// (取得価格相当額)

	private long				zanHosyou0				= 0;					// (残価保証額)

	private long				toukiGenkasyokyaku0		= 0;					// (当期減価償却費)

	private long				genkasyoukyakuRuikei0	= 0;					// (減価償却累計額)

	private long				kimatuZan0				= 0;					// (期末残高相当額)

	// 2020/05/22 ADD START
	private long				syutokuKakaku0_1		= 0;					// (取得価格相当額)

	private long				zanHosyou0_1			= 0;					// (残価保証額)

	private long				toukiGenkasyokyaku0_1	= 0;					// (当期減価償却費)

	private long				genkasyoukyakuRuikei0_1	= 0;					// (減価償却累計額)

	private long				kimatuZan0_1			= 0;					// (期末残高相当額)
	// 2020/05/22 ADD END
	
	private long				syutokuKakaku1			= 0;					// (取得価格相当額)

	private long				zanHosyou1				= 0;					// (残価保証額)

	private long				toukiGenkasyokyaku1		= 0;					// (当期減価償却費)

	private long				genkasyoukyakuRuikei1	= 0;					// (減価償却累計額)

	private long				kimatuZan1				= 0;					// (期末残高相当額)

	private long				syutokuKakaku2			= 0;					// (取得価格相当額)

	private long				zanHosyou2				= 0;					// (残価保証額)

	private long				toukiGenkasyokyaku2		= 0;					// (当期減価償却費)

	private long				genkasyoukyakuRuikei2	= 0;					// (減価償却累計額)

	private long				kimatuZan2				= 0;					// (期末残高相当額)

	private long				syutokuKakaku3			= 0;					// (取得価格相当額)

	private long				zanHosyou3				= 0;					// (残価保証額)

	private long				toukiGenkasyokyaku3		= 0;					// (当期減価償却費)

	private long				genkasyoukyakuRuikei3	= 0;					// (減価償却累計額)

	private long				kimatuZan3				= 0;					// (期末残高相当額)

	private long				syutokuKakaku4			= 0;					// (取得価格相当額)

	private long				zanHosyou4				= 0;					// (残価保証額)

	private long				toukiGenkasyokyaku4		= 0;					// (当期減価償却費)

	private long				genkasyoukyakuRuikei4	= 0;					// (減価償却累計額)

	private long				kimatuZan4				= 0;					// (期末残高相当額)

	private static final int	MAX_LINE				= 19;					// 明細行数

	private static final String	TITLE_COMP				= "リース会社　：";

	private static final String	TITLE_USER				= "開示先　　　：";

	private static final String	TITLE_OLD				= "リース会計資料（減価償却費）[旧]";

	private static final String	TITLE_NEW				= "リース会計資料（減価償却費）[新]";
	// 2020/05/22 ADD START LACS帳票バッチ出力
	private FileOutputStream fout = null; // 出力ファイルストリーム
	
	//private Report report = null;

	private File tmpFile = null; // 出力先ファイル

	private boolean batchFlg = false; // バッチ実行フラグ 
	
	private boolean batchStartFlg = false; //　バッチ出力開始フラグ

	private int batchPrintedPage = 0; //makePDF実行たびに出力したページ数

	/**　makePDF実行たびに出力したページ数を返す
	 * @return　Integer makePDF実行たびに出力したページ数
	 */
	public int getBatchPrintedPage() {
		return batchPrintedPage;
	}

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
		tmpFile = File.createTempFile("pdf02_" + prefix + "_", ".pdf", scratchDirectory);
		fout = new FileOutputStream(tmpFile);
		File formFile = new File(formDirectory, "Genka.pdf");
		File datFile = new File(formDirectory, "Genka.dat");
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
	// 2020/05/22 ADD END   LACS帳票バッチ出力
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
	public LACSReportPDFGenkaWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
		LACSReportGenkaEntity reportEntity = new LACSReportGenkaEntity(super.model, commonBean, piReportBean, this.acStd);
		LACSReportGenkaBean genkaDetail = null;

		try {
			reportEntity.setCon(super.con);

			piReportBean.setDataMax(reportEntity.execSQL());

			while (reportEntity.next()) {
				genkaDetail = new LACSReportGenkaBean();
				piReportBean.addGenkaBean(genkaDetail);

				genkaDetail.setBrakeKey0(reportEntity.getBrakeKey0());
				genkaDetail.setBrakeKey1(reportEntity.getBrakeKey1());
				genkaDetail.setBrakeKey2(reportEntity.getBrakeKey2());
				genkaDetail.setBrakeKey3(reportEntity.getBrakeKey3());

				genkaDetail.setBrakeKey4(reportEntity.getBrakeKey4());

				// 2020/05/22 ADD START
				genkaDetail.setBrakeKey0_1(reportEntity.getBrakeKey0_1());
				genkaDetail.setJysiUm(reportEntity.getJysiUm());
				// 2020/05/22 ADD END

				genkaDetail.setLeaseCompany(reportEntity.getLeaseCompany());
				genkaDetail.setLeaseBunrui(reportEntity.getLeaseBunrui());
				genkaDetail.setKoteiSisanKamoku(reportEntity.getKoteiSisanKamoku());
				genkaDetail.setGenkaSyoukyakuHohou(reportEntity.getGenkaSyoukyakuHohou());
				genkaDetail.setKeiyakuNo(reportEntity.getKeiyakuNo());
				genkaDetail.setLeaseFrom(reportEntity.getLeaseFrom());
				genkaDetail.setLeaseTo(reportEntity.getLeaseTo());
				genkaDetail.setBukenNo(reportEntity.getBukenNo());
				genkaDetail.setBukenNm(reportEntity.getBukenNm());
				genkaDetail.setKaiyakuYmd(reportEntity.getKaiyakuYmd());
				genkaDetail.setLeaseTerm(reportEntity.getLeaseTerm());
				genkaDetail.setTaiyouNensu(reportEntity.getTaiyouNensu());
				genkaDetail.setSyutokuKakaku(reportEntity.getSyutokuKakaku());
				genkaDetail.setZanHosyou(reportEntity.getZanHosyou());
				genkaDetail.setToukiGenkasyokyaku(reportEntity.getToukiGenkasyokyaku());
				genkaDetail.setGenkasyoukyakuRuikei(reportEntity.getGenkasyoukyakuRuikei());
				genkaDetail.setKimatuZan(reportEntity.getKimatuZan());
				genkaDetail.setLeasCompanyNm(reportEntity.getLeasCompanyNm());
				genkaDetail.setLeasUserNm(reportEntity.getLeasUserNm());

				genkaDetail.setAcShrKbnName(reportEntity.getAcShrKbnName());
				if ("1".equals(super.commonBean.getShowTyukiComment())) {
					genkaDetail.setWaribikiKeisanRisiRitu(reportEntity.getWaribikiKeisanRisiRitu());
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
		File formFile = null;
		File datFile = null;

		Field field = null;

		// 2020/05/22 DEL START LACS帳票バッチ出力
		//File tmpFile = null; // 出力先ファイル
		//FileOutputStream fout = null; // 出力ファイルストリーム
		// 2020/05/22 DEL END   LACS帳票バッチ出力

		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		formDirectory = new File(wprlHomeDirectory, FORM_PATH);

		// 2020/05/22 DEL START LACS帳票バッチ出力
		//report = null; // WebKCoreレポートオブジェクト
		// 2020/05/22 DEL END   LACS帳票バッチ出力
		detail = null;
		souPage = 0; // 総ページ数
		page = 0; // ページ
		lineCount = 0; // 明細カウンタ
		String brakeKey0 = ""; // ブレイクキー
		String brakeKey1 = ""; // ブレイクキー
		String brakeKey2 = ""; // ブレイクキー
		String brakeKey3 = ""; // ブレイクキー

		String brakeKey4 = ""; // ブレイクキー

		// 2020/05/22 ADD START
		String brakeKey0_1 = ""; // ブレイクキー 重要性有無
		// 2020/05/22 ADD END

		index = ""; // 明細行修飾子

		try {
			// 2020/05/22 ADD START LACS帳票バッチ出力
			if (!batchFlg) {
			// 2020/05/22 ADD END   LACS帳票バッチ出力

			tmpFile = File.createTempFile("pdf02_" + prefix + "_", ".pdf", scratchDirectory);
			fout = new FileOutputStream(tmpFile);
			formFile = new File(formDirectory, "Genka.pdf");
			datFile = new File(formDirectory, "Genka.dat");
			report = new Report(formFile, datFile, fout);
			// 2020/05/22 ADD START LACS帳票バッチ出力
			}
			// 2020/05/22 ADD END   LACS帳票バッチ出力

			// 2020/05/22 ADD START LACS帳票バッチ出力
			if (batchFlg && !batchStartFlg) {
				this.startReport(piContext);
				batchStartFlg =true;
			}
			// 2020/05/22 ADD END   LACS帳票バッチ出力

			syutokuKakaku = 0; // (取得価格相当額)
			zanHosyou = 0; // (残価保証額)
			toukiGenkasyokyaku = 0; // (当期減価償却費)
			genkasyoukyakuRuikei = 0; // (減価償却累計額)
			kimatuZan = 0; // (期末残高相当額)

			syutokuKakaku0 = 0; // (取得価格相当額)
			zanHosyou0 = 0; // (残価保証額)
			toukiGenkasyokyaku0 = 0; // (当期減価償却費)
			genkasyoukyakuRuikei0 = 0; // (減価償却累計額)
			kimatuZan0 = 0; // (期末残高相当額)

			// 2020/05/22 ADD START
			syutokuKakaku0_1 = 0; // (取得価格相当額)
			zanHosyou0_1 = 0; // (残価保証額)
			toukiGenkasyokyaku0_1 = 0; // (当期減価償却費)
			genkasyoukyakuRuikei0_1 = 0; // (減価償却累計額)
			kimatuZan0_1 = 0; // (期末残高相当額)
			// 2020/05/22 ADD END
			
			syutokuKakaku1 = 0; // (取得価格相当額)
			zanHosyou1 = 0; // (残価保証額)
			toukiGenkasyokyaku1 = 0; // (当期減価償却費)
			genkasyoukyakuRuikei1 = 0; // (減価償却累計額)
			kimatuZan1 = 0; // (期末残高相当額)

			syutokuKakaku2 = 0; // (取得価格相当額)
			zanHosyou2 = 0; // (残価保証額)
			toukiGenkasyokyaku2 = 0; // (当期減価償却費)
			genkasyoukyakuRuikei2 = 0; // (減価償却累計額)
			kimatuZan2 = 0; // (期末残高相当額)

			syutokuKakaku3 = 0; // (取得価格相当額)
			zanHosyou3 = 0; // (残価保証額)
			toukiGenkasyokyaku3 = 0; // (当期減価償却費)
			genkasyoukyakuRuikei3 = 0; // (減価償却累計額)
			kimatuZan3 = 0; // (期末残高相当額)

			syutokuKakaku4 = 0; // (取得価格相当額)
			zanHosyou4 = 0; // (残価保証額)
			toukiGenkasyokyaku4 = 0; // (当期減価償却費)
			genkasyoukyakuRuikei4 = 0; // (減価償却累計額)
			kimatuZan4 = 0; // (期末残高相当額)

			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				detail = piReportBean.getGenkaBean(i);
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
									// 2020/05/22 ADD START
									if (!detail.getBrakeKey0_1().equals(brakeKey0_1)) {

										if (lineCount >= MAX_LINE) {
											souPage++; // 総ページ数のカウントＵＰ
											lineCount = 0;
										}

										lineCount++;
									// 2020/05/22 ADD END
										if (!detail.getBrakeKey0().equals(brakeKey0)) {
	
											if (lineCount >= MAX_LINE) {
												souPage++; // 総ページ数のカウントＵＰ
												lineCount = 0;
											}
	
											lineCount++;
										}
									// 2020/05/22 ADD START
									}
									// 2020/05/22 ADD END
								}
							}
						}
					}

					souPage++; // 総ページ数のカウントＵＰ
					lineCount = 0;

					brakeKey0 = detail.getBrakeKey0();
					// 2020/05/22 ADD START
					brakeKey0_1 = detail.getBrakeKey0_1();
					// 2020/05/22 ADD END
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

			if (lineCount >= MAX_LINE) {
				souPage++; // 総ページ数のカウントＵＰ
				lineCount = 0;
			}
			// 2020/05/22 ADD START
			lineCount++;

			if (lineCount >= MAX_LINE) {
				souPage++; // 総ページ数のカウントＵＰ
				lineCount = 0;
			}
			// 2020/05/22 ADD END

			// 2020/05/22 ADD START LACS帳票バッチ出力
			batchPrintedPage = souPage;
			// 2020/05/22 ADD END   LACS帳票バッチ出力

			lineCount = 0; // 明細カウンタ
			brakeKey0 = ""; // ブレイクキー
			brakeKey1 = ""; // ブレイクキー
			brakeKey2 = ""; // ブレイクキー
			brakeKey3 = ""; // ブレイクキー

			brakeKey4 = ""; // ブレイクキー
			// 2020/05/22 ADD START
			brakeKey0_1 = ""; // ブレイクキー 重要性有無
			// 2020/05/22 ADD END

			// 2020/05/22 ADD START LACS帳票バッチ出力
			if (batchFlg && !batchStartFlg) {
				this.startReport(piContext);
				batchStartFlg = true;
			}
			// 2020/05/22 ADD END   LACS帳票バッチ出力

			
			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				detail = piReportBean.getGenkaBean(i);

				if (!detail.getBrakeKey4().equals(brakeKey4)) {
					if (!brakeKey4.equals("")) {
						if (lineCount >= MAX_LINE) {
							detail = piReportBean.getGenkaBean(i - 1);
							headPrint(piReportBean, piDateMode);
							detail = piReportBean.getGenkaBean(i);
						}

						skkKeijHohoKbnPrint(piReportBean);

						syutokuKakaku4 = 0;
						zanHosyou4 = 0;
						toukiGenkasyokyaku4 = 0;
						genkasyoukyakuRuikei4 = 0;
						kimatuZan4 = 0;

						if (!detail.getBrakeKey3().equals(brakeKey3)) {
							if (lineCount >= MAX_LINE) {
								detail = piReportBean.getGenkaBean(i - 1);
								headPrint(piReportBean, piDateMode);
								detail = piReportBean.getGenkaBean(i);
							}

							koteiSisanGokeiPrint(piReportBean);

							syutokuKakaku3 = 0;
							zanHosyou3 = 0;
							toukiGenkasyokyaku3 = 0;
							genkasyoukyakuRuikei3 = 0;
							kimatuZan3 = 0;

							if (!detail.getBrakeKey2().equals(brakeKey2)) {

								if (lineCount >= MAX_LINE) {
									detail = piReportBean.getGenkaBean(i - 1);
									headPrint(piReportBean, piDateMode);
									detail = piReportBean.getGenkaBean(i);
								}

								kaikeiSyoriPrint(piReportBean);

								syutokuKakaku2 = 0;
								zanHosyou2 = 0;
								toukiGenkasyokyaku2 = 0;
								genkasyoukyakuRuikei2 = 0;
								kimatuZan2 = 0;

								if (!detail.getBrakeKey1().equals(brakeKey1)) {

									if (lineCount >= MAX_LINE) {
										detail = piReportBean.getGenkaBean(i - 1);
										headPrint(piReportBean, piDateMode);
										detail = piReportBean.getGenkaBean(i);
									}

									leaseBunruiGokeiPrint(piReportBean);

									syutokuKakaku1 = 0;
									zanHosyou1 = 0;
									toukiGenkasyokyaku1 = 0;
									genkasyoukyakuRuikei1 = 0;
									kimatuZan1 = 0;
									// 2020/05/22 ADD START
									if (!detail.getBrakeKey0_1().equals(brakeKey0_1)) {

										if (lineCount >= MAX_LINE) {
											detail = piReportBean.getGenkaBean(i - 1);
											headPrint(piReportBean, piDateMode);
											detail = piReportBean.getGenkaBean(i);
										}

										JysiUmGokeiPrint(piReportBean);

										syutokuKakaku0_1 = 0;
										zanHosyou0_1 = 0;
										toukiGenkasyokyaku0_1 = 0;
										genkasyoukyakuRuikei0_1 = 0;
										kimatuZan0_1 = 0;
									// 2020/05/22 ADD END
									
										if (!detail.getBrakeKey0().equals(brakeKey0)) {
	
											if (lineCount >= MAX_LINE) {
												detail = piReportBean.getGenkaBean(i - 1);
												headPrint(piReportBean, piDateMode);
												detail = piReportBean.getGenkaBean(i);
											}
	
											leaseCompanyGokeiPrint(piReportBean);
	
											syutokuKakaku0 = 0;
											zanHosyou0 = 0;
											toukiGenkasyokyaku0 = 0;
											genkasyoukyakuRuikei0 = 0;
											kimatuZan0 = 0;
										}
									// 2020/05/22 ADD START
									}
									// 2020/05/22 ADD END
								}
							}
						}
					}

					headPrint(piReportBean, piDateMode);

					brakeKey0 = detail.getBrakeKey0();
					// 2020/05/22 ADD START
					brakeKey0_1 = detail.getBrakeKey0_1();
					// 2020/05/22 ADD END
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

				index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

				field = report.getField("xKeiyakuNo" + index);
				report.putFieldData(field, detail.getKeiyakuNo());

				field = report.getField("xLeaseNm" + index);
				report.putFieldData(field, " ");

				field = report.getField("xLeaseFrom" + index);
				report.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getLeaseFrom()))), piDateMode));

				field = report.getField("xLeaseTo" + index);
				report.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getLeaseTo()))), piDateMode));

				field = report.getField("xBukenNo" + index);
				report.putFieldData(field, detail.getBukenNo());

				field = report.getField("xBukenNm" + index);
				report.putFieldData(field, detail.getBukenNm());

				if ("1".equals(super.commonBean.getShowTyukiComment())) {
					if (detail.getWaribikiKeisanRisiRitu() != null) {
						field = report.getField("xWaribikiKeisanRishiRitsu" + index);
						report.putFieldData(field, detail.getWaribikiKeisanRisiRitu() + "%");
					}
				}

				field = report.getField("xKaiyakuYmd" + index);
				report.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getKaiyakuYmd()))), piDateMode));

				field = report.getField("xLeaseKikan" + index);
				report.putFieldData(field, detail.getLeaseTerm() + "ヶ月");

				// 2020/05/22 DEL START
				// field = report.getField("xTaiyouNensu" + index);
				// report.putFieldData(field, detail.getTaiyouNensu() + "年");
				// 2020/05/22 DEL END

				field = report.getField("xSyutokuKakaku" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyutokuKakaku()));

				field = report.getField("xZanHosyou" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZanHosyou()));

				field = report.getField("xToukiGenkasyokyaku" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukiGenkasyokyaku()));

				field = report.getField("xGenkasyoukyakuRuikei" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenkasyoukyakuRuikei()));

				field = report.getField("xKimatuZan" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getKimatuZan()));

				syutokuKakaku4 += detail.getSyutokuKakaku();
				zanHosyou4 += detail.getZanHosyou();
				toukiGenkasyokyaku4 += detail.getToukiGenkasyokyaku();
				genkasyoukyakuRuikei4 += detail.getGenkasyoukyakuRuikei();
				kimatuZan4 += detail.getKimatuZan();

				syutokuKakaku3 += detail.getSyutokuKakaku();
				zanHosyou3 += detail.getZanHosyou();
				toukiGenkasyokyaku3 += detail.getToukiGenkasyokyaku();
				genkasyoukyakuRuikei3 += detail.getGenkasyoukyakuRuikei();
				kimatuZan3 += detail.getKimatuZan();

				syutokuKakaku2 += detail.getSyutokuKakaku();
				zanHosyou2 += detail.getZanHosyou();
				toukiGenkasyokyaku2 += detail.getToukiGenkasyokyaku();
				genkasyoukyakuRuikei2 += detail.getGenkasyoukyakuRuikei();
				kimatuZan2 += detail.getKimatuZan();

				syutokuKakaku1 += detail.getSyutokuKakaku();
				zanHosyou1 += detail.getZanHosyou();
				toukiGenkasyokyaku1 += detail.getToukiGenkasyokyaku();
				genkasyoukyakuRuikei1 += detail.getGenkasyoukyakuRuikei();
				kimatuZan1 += detail.getKimatuZan();

				// 2020/05/22 ADD START
				syutokuKakaku0_1 += detail.getSyutokuKakaku();
				zanHosyou0_1 += detail.getZanHosyou();
				toukiGenkasyokyaku0_1 += detail.getToukiGenkasyokyaku();
				genkasyoukyakuRuikei0_1 += detail.getGenkasyoukyakuRuikei();
				kimatuZan0_1 += detail.getKimatuZan();
				// 2020/05/22 ADD END
				
				syutokuKakaku0 += detail.getSyutokuKakaku();
				zanHosyou0 += detail.getZanHosyou();
				toukiGenkasyokyaku0 += detail.getToukiGenkasyokyaku();
				genkasyoukyakuRuikei0 += detail.getGenkasyoukyakuRuikei();
				kimatuZan0 += detail.getKimatuZan();

				syutokuKakaku += detail.getSyutokuKakaku();
				zanHosyou += detail.getZanHosyou();
				toukiGenkasyokyaku += detail.getToukiGenkasyokyaku();
				genkasyoukyakuRuikei += detail.getGenkasyoukyakuRuikei();
				kimatuZan += detail.getKimatuZan();

				lineCount++;
			}

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			skkKeijHohoKbnPrint(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			koteiSisanGokeiPrint(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			kaikeiSyoriPrint(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			leaseBunruiGokeiPrint(piReportBean);

			// 2020/05/22 ADD START
			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			JysiUmGokeiPrint(piReportBean);
			// 2020/05/22 ADD END

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			leaseCompanyGokeiPrint(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			souGokeiPrint(piReportBean);

			// 2020/05/22 DEL START LACS帳票バッチ出力
			//report.close();
			//report = null;
			// 2020/05/22 DEL END   LACS帳票バッチ出力

			return tmpFile.getName();

		}
		finally {
			// 2020/05/22 REP START LACS帳票バッチ出力
//			if (report != null) {
//				try {
//					report.close();
//				}
//				catch (ReportException e) {
//				}
//				report = null;
//			}
//			if (fout != null) {
//				try {
//					fout.close();
//				}
//				catch (Exception e) {
//					fout = null;
//				}
//			}
			//
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
			}			
			// 2020/05/22 REP END   LACS帳票バッチ出力
		}
	}

	private void headPrint(LACSReportBean piReportBean, String piDateMode) throws Exception {
		Field field = null;

		report.createPage(1);

		lineCount = 0;

		field = report.getField("xPage");
		report.putFieldData(field, ++page + "/" + souPage);

		field = report.getField("xTitle");
		report.putFieldData(field, super.acStd.equals(LACSDefine.AccountStandard.NEW_1) ? TITLE_NEW : TITLE_OLD);

		field = report.getField("xDate");
		report.putFieldData(field, super.convertReki(Convert.toString(new Date()), piDateMode));

		field = report.getField("xLeasCompanyTitle");
		report.putFieldData(field, TITLE_COMP);

		field = report.getField("xLeasUserTitle");
		report.putFieldData(field, TITLE_USER);

		field = report.getField("xLeasCompanyTitle_D");
		report.putFieldData(field, " ");

		field = report.getField("xLeaseCompany");
		report.putFieldData(field, detail.getLeasCompanyNm());

		field = report.getField("xLeaseUser");
		report.putFieldData(field, detail.getLeasUserNm());

		field = report.getField("xTaisyouFrom");
		report.putFieldData(field, super.convertRekiLong(Convert.toString(Convert.toDate(Convert.toDateString(piReportBean.getTermFrom().getYYYYMMDD()))), piDateMode));

		field = report.getField("xTaisyouTo");
		report.putFieldData(field, super.convertRekiLong(Convert.toString(Convert.toDate(Convert.toDateString(piReportBean.getTermTo().getYYYYMMDD()))), piDateMode));

		field = report.getField("xLeaseBunrui");
		report.putFieldData(field, detail.getLeaseBunrui());

		field = report.getField("xKoteiSisanKamoku");
		report.putFieldData(field, detail.getKoteiSisanKamoku());

		field = report.getField("xKaikeiSyoriHouhou");
		report.putFieldData(field, detail.getAcShrKbnName());

		field = report.getField("xGenkaSyoukyakuHohou");
		report.putFieldData(field, detail.getGenkaSyoukyakuHohou());

		field = report.getField("xComment");
		report.putFieldData(field, COMMENT);

		field = report.getField("xZanHosyouTitle");
		report.putFieldData(field, "うち残価保証額");

		field = report.getField("xToukiGenkaSyokyaku");
		report.putFieldData(field, "当期減価償却費相当額");

		field = report.getField("xGenkaSyokyakuRuikei");
		report.putFieldData(field, "減価償却累計額相当額");

		if ("1".equals(super.commonBean.getShowTyukiComment())) {
			field = report.getField("xRishiRitsuTittle");
			report.putFieldData(field, "割引計算利子率");
		}

		// 2020/05/22 ADD START
		field = report.getField("xJysiUm");
		report.putFieldData(field, detail.getJysiUm());
		// 2020/05/22 ADD END

	}

	private void koteiSisanGokeiPrint(LACSReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xLeaseKikan" + index);
		report.putFieldData(field, "固定資産科目計");

		field = report.getField("xSyutokuKakaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakaku3));

		field = report.getField("xZanHosyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(zanHosyou3));

		field = report.getField("xToukiGenkasyokyaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGenkasyokyaku3));

		field = report.getField("xGenkasyoukyakuRuikei" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkasyoukyakuRuikei3));

		field = report.getField("xKimatuZan" + index);
		report.putFieldData(field, StringUtl.formatNumber(kimatuZan3));

		lineCount++;
	}

	private void kaikeiSyoriPrint(LACSReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xLeaseKikan" + index);
		report.putFieldData(field, "会計処理方法計");

		field = report.getField("xSyutokuKakaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakaku2));

		field = report.getField("xZanHosyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(zanHosyou2));

		field = report.getField("xToukiGenkasyokyaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGenkasyokyaku2));

		field = report.getField("xGenkasyoukyakuRuikei" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkasyoukyakuRuikei2));

		field = report.getField("xKimatuZan" + index);
		report.putFieldData(field, StringUtl.formatNumber(kimatuZan2));

		lineCount++;
	}

	private void skkKeijHohoKbnPrint(LACSReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xLeaseKikan" + index);
		report.putFieldData(field, "減価償却方法計");

		field = report.getField("xSyutokuKakaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakaku4));

		field = report.getField("xZanHosyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(zanHosyou4));

		field = report.getField("xToukiGenkasyokyaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGenkasyokyaku4));

		field = report.getField("xGenkasyoukyakuRuikei" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkasyoukyakuRuikei4));

		field = report.getField("xKimatuZan" + index);
		report.putFieldData(field, StringUtl.formatNumber(kimatuZan4));

		lineCount++;
	}

	private void leaseBunruiGokeiPrint(LACSReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xLeaseKikan" + index);
		report.putFieldData(field, "リース取引分類計");

		field = report.getField("xSyutokuKakaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakaku1));

		field = report.getField("xZanHosyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(zanHosyou1));

		field = report.getField("xToukiGenkasyokyaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGenkasyokyaku1));

		field = report.getField("xGenkasyoukyakuRuikei" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkasyoukyakuRuikei1));

		field = report.getField("xKimatuZan" + index);
		report.putFieldData(field, StringUtl.formatNumber(kimatuZan1));

		lineCount++;
	}

	// 2020/05/22 ADD START
		private void JysiUmGokeiPrint(LACSReportBean piReportBean) throws Exception {
			Field field = null;
			index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

			field = report.getField("xLeaseKikan" + index);
			report.putFieldData(field, "重要性有無計");

			field = report.getField("xSyutokuKakaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(syutokuKakaku0_1));

			field = report.getField("xZanHosyou" + index);
			report.putFieldData(field, StringUtl.formatNumber(zanHosyou0_1));

			field = report.getField("xToukiGenkasyokyaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(toukiGenkasyokyaku0_1));

			field = report.getField("xGenkasyoukyakuRuikei" + index);
			report.putFieldData(field, StringUtl.formatNumber(genkasyoukyakuRuikei0_1));

			field = report.getField("xKimatuZan" + index);
			report.putFieldData(field, StringUtl.formatNumber(kimatuZan0_1));

			lineCount++;
		}
	// 2020/05/22 ADD END
	
	
	private void leaseCompanyGokeiPrint(LACSReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xLeaseKikan" + index);
		report.putFieldData(field, "リース会社計");

		field = report.getField("xSyutokuKakaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakaku0));

		field = report.getField("xZanHosyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(zanHosyou0));

		field = report.getField("xToukiGenkasyokyaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGenkasyokyaku0));

		field = report.getField("xGenkasyoukyakuRuikei" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkasyoukyakuRuikei0));

		field = report.getField("xKimatuZan" + index);
		report.putFieldData(field, StringUtl.formatNumber(kimatuZan0));

		lineCount++;
	}

	private void souGokeiPrint(LACSReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xLeaseKikan" + index);
		report.putFieldData(field, "総　合　計");

		field = report.getField("xSyutokuKakaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakaku));

		field = report.getField("xZanHosyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(zanHosyou));

		field = report.getField("xToukiGenkasyokyaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGenkasyokyaku));

		field = report.getField("xGenkasyoukyakuRuikei" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkasyoukyakuRuikei));

		field = report.getField("xKimatuZan" + index);
		report.putFieldData(field, StringUtl.formatNumber(kimatuZan));

		lineCount++;
	}
}
