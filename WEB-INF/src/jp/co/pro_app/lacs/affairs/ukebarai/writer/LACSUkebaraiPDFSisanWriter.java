package jp.co.pro_app.lacs.affairs.ukebarai.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiSisanBean;
import jp.co.pro_app.lacs.affairs.ukebarai.data.entity.LACSUkebaraiSisanEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

/**
 * 受払合計表：リース資産受払明細表 PDF Model.
 * 
 * @author active
 * @version 20080814
 */
public class LACSUkebaraiPDFSisanWriter extends LACSUkebaraiPDFWriterBase {

	private Report					report					= null; // WebKCoreレポートオブジェクト

	private LACSUkebaraiSisanBean	detail					= null;

	private int						souPage					= 0;	// 総ページ数

	private int						page					= 0;	// ページ

	private int						lineCount				= 0;	// 明細カウンタ

	private String					brakeKey1				= "";	// ブレイクキー

	private String					brakeKey2				= "";	// ブレイクキー

	private String					brakeKey3				= "";	// ブレイクキー

	private String					brakeKey4				= "";	// ブレイクキー

	private String					brakeKey5				= "";	// ブレイクキー

	// 2020/05/22 ADD START
	private String					brakeKey1_0				= "";	// ブレイクキー

	private String					brakeKey6				= "";	// ブレイクキー
// 2020/05/22 ADD END

	private String					index					= "";	// 明細行修飾子

	private long					zenkimatuZanAmt			= 0;	// 前期末残高

	private long					toukiZoukaAmt			= 0;	// 当期増加

	private long					toukiGensyoAmt			= 0;	// 当期減少高

	private long					toukimatuZanAmt			= 0;	// 当期末残高

	private long					zenkimatuBokaAmt		= 0;	// 前期末簿価

	private long					toukiJitugenAmt			= 0;	// 当期実現

	private long					toukiGensyoBokaAmt		= 0;	// 当期減少簿価

	private long					toukimatuBokaAmt		= 0;	// 当期末簿価

	private long					zenkimatuSyokyakuAmt	= 0;	// 前期末償却累計

	private long					toukimatuSyokyakuAmt	= 0;	// 当期末償却累計

	private long					toukiZoukaBokaAmt		= 0;	// 当期増加簿価

	private long					zenkimatuZanAmt1		= 0;	// 前期末残高

	private long					toukiZoukaAmt1			= 0;	// 当期増加

	private long					toukiGensyoAmt1			= 0;	// 当期減少高

	private long					toukimatuZanAmt1		= 0;	// 当期末残高

	private long					zenkimatuBokaAmt1		= 0;	// 前期末簿価

	private long					toukiJitugenAmt1		= 0;	// 当期実現

	private long					toukiGensyoBokaAmt1		= 0;	// 当期減少簿価

	private long					toukimatuBokaAmt1		= 0;	// 当期末簿価

	private long					zenkimatuSyokyakuAmt1	= 0;	// 前期末償却累計

	private long					toukimatuSyokyakuAmt1	= 0;	// 当期末償却累計

	private long					toukiZoukaBokaAmt1		= 0;	// 当期増加簿価

	private long					zenkimatuZanAmt2		= 0;	// 前期末残高

	private long					toukiZoukaAmt2			= 0;	// 当期増加

	private long					toukiGensyoAmt2			= 0;	// 当期減少高

	private long					toukimatuZanAmt2		= 0;	// 当期末残高

	private long					zenkimatuBokaAmt2		= 0;	// 前期末簿価

	private long					toukiJitugenAmt2		= 0;	// 当期実現

	private long					toukiGensyoBokaAmt2		= 0;	// 当期減少簿価

	private long					toukimatuBokaAmt2		= 0;	// 当期末簿価

	private long					zenkimatuSyokyakuAmt2	= 0;	// 前期末償却累計

	private long					toukimatuSyokyakuAmt2	= 0;	// 当期末償却累計

	private long					toukiZoukaBokaAmt2		= 0;	// 当期増加簿価

	private long					zenkimatuZanAmt3		= 0;	// 前期末残高

	private long					toukiZoukaAmt3			= 0;	// 当期増加

	private long					toukiGensyoAmt3			= 0;	// 当期減少高

	private long					toukimatuZanAmt3		= 0;	// 当期末残高

	private long					zenkimatuBokaAmt3		= 0;	// 前期末簿価

	private long					toukiJitugenAmt3		= 0;	// 当期実現

	private long					toukiGensyoBokaAmt3		= 0;	// 当期減少簿価

	private long					toukimatuBokaAmt3		= 0;	// 当期末簿価

	private long					zenkimatuSyokyakuAmt3	= 0;	// 前期末償却累計

	private long					toukimatuSyokyakuAmt3	= 0;	// 当期末償却累計

	private long					toukiZoukaBokaAmt3		= 0;	// 当期増加簿価

	private long					zenkimatuZanAmt4		= 0;	// 前期末残高

	private long					toukiZoukaAmt4			= 0;	// 当期増加

	private long					toukiGensyoAmt4			= 0;	// 当期減少高

	private long					toukimatuZanAmt4		= 0;	// 当期末残高

	private long					zenkimatuBokaAmt4		= 0;	// 前期末簿価

	private long					toukiJitugenAmt4		= 0;	// 当期実現

	private long					toukiGensyoBokaAmt4		= 0;	// 当期減少簿価

	private long					toukimatuBokaAmt4		= 0;	// 当期末簿価

	private long					zenkimatuSyokyakuAmt4	= 0;	// 前期末償却累計

	private long					toukimatuSyokyakuAmt4	= 0;	// 当期末償却累計

	private long					zenkimatuZanAmt5		= 0;	// 前期末残高

	private long					toukiZoukaBokaAmt4		= 0;	// 当期増加簿価

	private long					toukiZoukaAmt5			= 0;	// 当期増加

	private long					toukiGensyoAmt5			= 0;	// 当期減少高

	private long					toukimatuZanAmt5		= 0;	// 当期末残高

	private long					zenkimatuBokaAmt5		= 0;	// 前期末簿価

	private long					toukiJitugenAmt5		= 0;	// 当期実現

	private long					toukiGensyoBokaAmt5		= 0;	// 当期減少簿価

	private long					toukimatuBokaAmt5		= 0;	// 当期末簿価

	private long					zenkimatuSyokyakuAmt5	= 0;	// 前期末償却累計

	private long					toukimatuSyokyakuAmt5	= 0;	// 当期末償却累計

	private long					toukiZoukaBokaAmt5		= 0;	// 当期増加簿価

	// 2020/05/22 ADD START
	private long					zenkimatuZanAmt1_0		= 0;	// 前期末残高

	private long					toukiZoukaAmt1_0		= 0;	// 当期増加

	private long					toukiGensyoAmt1_0		= 0;	// 当期減少高

	private long					toukimatuZanAmt1_0		= 0;	// 当期末残高

	private long					zenkimatuBokaAmt1_0		= 0;	// 前期末簿価

	private long					toukiJitugenAmt1_0		= 0;	// 当期実現

	private long					toukiGensyoBokaAmt1_0	= 0;	// 当期減少簿価

	private long					toukimatuBokaAmt1_0		= 0;	// 当期末簿価

	private long					zenkimatuSyokyakuAmt1_0	= 0;	// 前期末償却累計

	private long					toukimatuSyokyakuAmt1_0	= 0;	// 当期末償却累計

	private long					toukiZoukaBokaAmt1_0	= 0;	// 当期増加簿価

	private long					zenkimatuZanAmt6		= 0;	// 前期末残高

	private long					toukiZoukaAmt6			= 0;	// 当期増加

	private long					toukiGensyoAmt6			= 0;	// 当期減少高

	private long					toukimatuZanAmt6		= 0;	// 当期末残高

	private long					zenkimatuBokaAmt6		= 0;	// 前期末簿価

	private long					toukiJitugenAmt6		= 0;	// 当期実現

	private long					toukiGensyoBokaAmt6		= 0;	// 当期減少簿価

	private long					toukimatuBokaAmt6		= 0;	// 当期末簿価

	private long					zenkimatuSyokyakuAmt6	= 0;	// 前期末償却累計

	private long					toukimatuSyokyakuAmt6	= 0;	// 当期末償却累計

	private long					toukiZoukaBokaAmt6		= 0;	// 当期増加簿価

	// 2020/05/22 ADD END

	private static final int		MAX_LINE				= 11;	// 明細行数

	// 2020/05/22 ADD START LACS帳票バッチ出力
	FileOutputStream fout = null; // 出力ファイルストリーム
	
	//Report report = null; // WebKCoreレポートオブジェクト
	
	File tmpFile = null; // 出力先ファイル
	
	private boolean batchFlg = false; //　バッチ実行フラグ
	
	private boolean batchStartFlg = false; //　バッチ出力開始フラグ
	
	private int batchPrintedPage = 0; //makePDF実行たびに出力したページ数
	
	/**　makePDF実行たびに出力したページ数を返す
	 * @return　Integer makePDF実行たびに出力したページ数
	 */
	public int getBatchPrintedPage() {
		return batchPrintedPage;
	}

	/**　バッチ実行フラグを設定する
	 * @param boolean batchFlg
	 */
	public void setBatchFlg(boolean batchFlg) {
		this.batchFlg = batchFlg;
	}
	
	/**　バッチ出力開始
	 * @param piContext
	 * @throws Exception
	 */
	public void startReport(ServletContext piContext) throws Exception {
		File wprlHomeDirectory = new File(PdfProperties.getInstance().getProperty(PdfProperties.WKC_PDF_HOME));
		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		formDirectory = new File(wprlHomeDirectory, FORM_PATH);
		tmpFile = File.createTempFile("pdf22_", ".pdf", scratchDirectory);
		fout = new FileOutputStream(tmpFile);
		File formFile = new File(formDirectory, "SisanUkebarai.pdf");
		File datFile = new File(formDirectory, "SisanUkebarai.dat");
		report = new Report(formFile, datFile, fout);
	}
	
	/**　作成しだPDFファイル名を返す
	 * @return String 作成しだPDFファイル名
	 */
	public String getFileName() {
		return tmpFile != null ? tmpFile.getName() : ""; 
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
	public LACSUkebaraiPDFSisanWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
	}

	/**
	 * リース資産受払データ取得. 出力データをBeanに設定して返却する
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	public void getSisanData(LACSUkebaraiBean piUkebaraiBean) throws SQLException {

		LACSUkebaraiSisanEntity reportEntity = new LACSUkebaraiSisanEntity(model, this.commonBean, piUkebaraiBean);
		detail = null;
		try {
			reportEntity.setCon(super.con);

			piUkebaraiBean.setDataMax(reportEntity.execSQL());

			int dataCount = 0;
			while (reportEntity.next()) {
				detail = new LACSUkebaraiSisanBean();
				piUkebaraiBean.addUkebaraiSisanBean(detail);
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
				detail.setSisanKbn(reportEntity.getSisanKbn());
				detail.setTaishoAcKijyunNm(reportEntity.getTaishoAcKijyunNm());
				detail.setAcShrNm(reportEntity.getAcShrNm());
				detail.setKeiNo(reportEntity.getKeiNo());
				detail.setBknNo(reportEntity.getBknNo());
				detail.setBknNm(reportEntity.getBknNm());
				detail.setKnshuYmd(reportEntity.getKnshuYmd());
				detail.setMryoYmd(reportEntity.getMryoYmd());
				detail.setKaiYmd(reportEntity.getKaiYmd());
				detail.setTrdHnteiKekaNm(reportEntity.getTrdHnteiKekaNm());
				detail.setZenkimatuZanAmt(reportEntity.getZenkimatuZanAmt());
				detail.setToukiZoukaAmt(reportEntity.getToukiZoukaAmt());
				detail.setToukiGensyoAmt(reportEntity.getToukiGensyoAmt());
				detail.setToukimatuZanAmt(reportEntity.getToukimatuZanAmt());
				detail.setZenkimatuBokaAmt(reportEntity.getZenkimatuBokaAmt());
				detail.setToukiJitugenAmt(reportEntity.getToukiJitugenAmt());
				detail.setToukiGensyoBokaAmt(reportEntity.getToukiGensyoBokaAmt());
				detail.setToukimatuBokaAmt(reportEntity.getToukimatuBokaAmt());
				detail.setZenkimatuSyokyakuAmt(reportEntity.getZenkimatuSyokyakuAmt());
				detail.setToukimatuSyokyakuAmt(reportEntity.getToukimatuSyokyakuAmt());
				detail.setToukiZoukaBokaAmt(reportEntity.getToukiZoukaBokaAmt());
				// 2020/05/22 ADD START
				detail.setBrakeKey1_0(reportEntity.getBrakeKey1_0());
				detail.setBrakeKey6(reportEntity.getBrakeKey6());
				detail.setJysiUm(reportEntity.getJysiUm());
				detail.setZankHshoAmt(reportEntity.getZankHshoAmt());
				detail.setSsnSriNm(reportEntity.getSsnSriNm());
				// 2020/05/22 ADD END
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
	 *            リース資産受払明細表 Bean
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

		// 2020/05/22 DEL START LACS帳票バッチ出力
		//File tmpFile = null; // 出力先ファイル
		//FileOutputStream fout = null; // 出力ファイルストリーム
		//report = null; // WebKCoreレポートオブジェクト
		// 2020/05/22 DEL END   LACS帳票バッチ出力
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
		// 2020/05/22 ADD START
		brakeKey1_0 = ""; // ブレイクキー
		brakeKey6 = ""; // ブレイクキー
		// 2020/05/22 ADD END
		index = ""; // 明細行修飾子

		try {

			// 2020/05/22 REP START LACS帳票バッチ出力
			//tmpFile = File.createTempFile("pdf22_", ".pdf", scratchDirectory);
			//fout = new FileOutputStream(tmpFile);
			//File formFile = new File(formDirectory, "SisanUkebarai.pdf");
			//File datFile = new File(formDirectory, "SisanUkebarai.dat");
			//report = new Report(formFile, datFile, fout);
			if(!batchFlg){
				tmpFile = File.createTempFile("pdf22_", ".pdf", scratchDirectory);
				fout = new FileOutputStream(tmpFile);
				File formFile = new File(formDirectory, "SisanUkebarai.pdf");
				File datFile = new File(formDirectory, "SisanUkebarai.dat");
				report = new Report(formFile, datFile, fout);
				
			}
			// 2020/05/22 REP END   LACS帳票バッチ出力

			
			for (int i = 0; i < piUkebaraiBean.getDataMax(); i++) {
				detail = piUkebaraiBean.getUkebaraiSisanBean(i);
				// 2020/05/22 ADD START
				if (!detail.getBrakeKey6().equals(brakeKey6)) {
					if (!brakeKey6.equals("")) {
				
						if (lineCount >= MAX_LINE) {
							souPage++; // 総ページ数のカウントＵＰ
							lineCount = 0;
						}
				
						lineCount++;
				// 2020/05/22 ADD END
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
														// 2020/05/22 ADD START
														if (!detail.getBrakeKey1_0().equals(brakeKey1_0)) {
															if (!brakeKey1_0.equals("")) {
				
																if (lineCount >= MAX_LINE) {
																	souPage++; // 総ページ数のカウントＵＰ
																	lineCount = 0;
																}
				
																lineCount++;														
														// 2020/05/22 ADD END
																if (!detail.getBrakeKey1().equals(brakeKey1)) {
				
																	if (lineCount >= MAX_LINE) {
																		souPage++; // 総ページ数のカウントＵＰ
																		lineCount = 0;
																	}
				
																	lineCount++;
																}
														// 2020/05/22 ADD START
															}
														}
														// 2020/05/22 ADD END
													}
												}
											}
										}
									}
								}
							}
					// 2020/05/22 ADD START
						}
					}
					// 2020/05/22 ADD END
					souPage++; // 総ページ数のカウントＵＰ
					lineCount = 0;

					brakeKey1 = detail.getBrakeKey1();
					// 2020/05/22 ADD START
					brakeKey1_0 = detail.getBrakeKey1_0();
					// 2020/05/22 ADD END
					brakeKey2 = detail.getBrakeKey2();
					brakeKey3 = detail.getBrakeKey3();
					brakeKey4 = detail.getBrakeKey4();
					brakeKey5 = detail.getBrakeKey5();
					// 2020/05/22 ADD START
					brakeKey6 = detail.getBrakeKey6();
					// 2020/05/22 ADD END
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

			brakeKey1 = ""; // ブレイクキー１
			brakeKey2 = ""; // ブレイクキー２
			brakeKey3 = ""; // ブレイクキー３
			brakeKey4 = ""; // ブレイクキー４
			brakeKey5 = ""; // ブレイクキー５
			// 2020/05/22 ADD START
			brakeKey1_0 = ""; // ブレイクキー1_0
			brakeKey6 = ""; // ブレイクキー6
			// 2020/05/22 ADD END

			// 2020/05/22 ADD START LACS帳票バッチ出力
			if (batchFlg && !batchStartFlg) {
				this.startReport(piContext);
				batchStartFlg = true;
			}
			// 2020/05/22 ADD END   LACS帳票バッチ出力
			String piDateMode = super.getSeirekiWarekiCode(commonBean.getCompanyCode(), piUkebaraiBean.getLeasCompany().getValue());

			for (int i = 0; i < piUkebaraiBean.getDataMax(); i++) {
				detail = piUkebaraiBean.getUkebaraiSisanBean(i);
				// 2020/05/22 ADD START
				if (!detail.getBrakeKey6().equals(brakeKey6)) {
					if (!brakeKey6.equals("")) {

						if (lineCount >= MAX_LINE) {
							detail = piUkebaraiBean.getUkebaraiSisanBean(i - 1);
							headPrint(detail, report, piDateMode);
							detail = piUkebaraiBean.getUkebaraiSisanBean(i);
						}

						sisansriGokeiPrint();
				// 2020/05/22 ADD END
						if (!detail.getBrakeKey5().equals(brakeKey5)) {
							if (!brakeKey5.equals("")) {
		
								if (lineCount >= MAX_LINE) {
									detail = piUkebaraiBean.getUkebaraiSisanBean(i - 1);
									headPrint(detail, report, piDateMode);
									detail = piUkebaraiBean.getUkebaraiSisanBean(i);
								}
		
								sisankbnGokeiPrint();
		
								if (!detail.getBrakeKey4().equals(brakeKey4)) {
									if (!brakeKey4.equals("")) {
		
										if (lineCount >= MAX_LINE) {
											detail = piUkebaraiBean.getUkebaraiSisanBean(i - 1);
											headPrint(detail, report, piDateMode);
											detail = piUkebaraiBean.getUkebaraiSisanBean(i);
										}
										kaikeiSyoriGokeiPrint();
										if (!detail.getBrakeKey3().equals(brakeKey3)) {
											if (!brakeKey3.equals("")) {
		
												if (lineCount >= MAX_LINE) {
													detail = piUkebaraiBean.getUkebaraiSisanBean(i - 1);
													headPrint(detail, report, piDateMode);
													detail = piUkebaraiBean.getUkebaraiSisanBean(i);
												}
		
												trdHnteiKekaGokeiPrint();
												if (!detail.getBrakeKey2().equals(brakeKey2)) {
													if (!brakeKey2.equals("")) {
		
														if (lineCount >= MAX_LINE) {
															detail = piUkebaraiBean.getUkebaraiSisanBean(i - 1);
															headPrint(detail, report, piDateMode);
															detail = piUkebaraiBean.getUkebaraiSisanBean(i);
														}
		
														ackijyunGokeiPrint();
		
														// 2020/05/22 ADD START
														if (!detail.getBrakeKey1_0().equals(brakeKey1_0)) {
															if (!brakeKey1_0.equals("")) {
				
																if (lineCount >= MAX_LINE) {
																	detail = piUkebaraiBean.getUkebaraiSisanBean(i - 1);
																	headPrint(detail, report, piDateMode);
																	detail = piUkebaraiBean.getUkebaraiSisanBean(i);
																}
				
																jysiUmGokeiPrint();
														// 2020/05/22 ADD END

																if (!detail.getBrakeKey1().equals(brakeKey1)) {
				
																	if (lineCount >= MAX_LINE) {
																		detail = piUkebaraiBean.getUkebaraiSisanBean(i - 1);
																		headPrint(detail, report, piDateMode);
																		detail = piUkebaraiBean.getUkebaraiSisanBean(i);
																	}
				
																	leasCompanyGokeiPrint();
																}
														// 2020/05/22 ADD START
															}
														}
														// 2020/05/22 ADD END
													}
												}
											}
										}
									}
								}
							}
					// 2020/05/22 ADD START
						}
					}
					// 2020/05/22 ADD END

					headPrint(detail, report, piDateMode);

					brakeKey1 = detail.getBrakeKey1();
					brakeKey2 = detail.getBrakeKey2();
					brakeKey3 = detail.getBrakeKey3();
					brakeKey4 = detail.getBrakeKey4();
					brakeKey5 = detail.getBrakeKey5();
					// 2020/05/22 ADD START
					brakeKey1_0 = detail.getBrakeKey1_0();
					brakeKey6 = detail.getBrakeKey6();
					// 2020/05/22 ADD END
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

				// 2020/05/22 ADD START
				field = report.getField("xZankaHosyoAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankHshoAmt()));
				// 2020/05/22 ADD END

				field = report.getField("xZenkimatuZanAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZenkimatuZanAmt()));

				field = report.getField("xToukiZoukaAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukiZoukaAmt()));

				field = report.getField("xToukiGensyoAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukiGensyoAmt()));

				field = report.getField("xToukimatuZanAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukimatuZanAmt()));

				field = report.getField("xZenkimatuBokaAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZenkimatuBokaAmt()));

				field = report.getField("xToukiJitugenAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukiJitugenAmt()));

				field = report.getField("xToukiGensyoBokaAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukiGensyoBokaAmt()));

				field = report.getField("xToukimatuBokaAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukimatuBokaAmt()));

				field = report.getField("xZenkimatuSyokyakuAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZenkimatuSyokyakuAmt()));

				field = report.getField("xToukimatuSyokyakuAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukimatuSyokyakuAmt()));
				field = report.getField("xToukiZoukaBokaAmt" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukiZoukaBokaAmt()));

				zenkimatuZanAmt1 += detail.getZenkimatuZanAmt();
				toukiZoukaAmt1 += detail.getToukiZoukaAmt();
				toukiGensyoAmt1 += detail.getToukiGensyoAmt();
				toukimatuZanAmt1 += detail.getToukimatuZanAmt();
				zenkimatuBokaAmt1 += detail.getZenkimatuBokaAmt();
				toukiJitugenAmt1 += detail.getToukiJitugenAmt();
				toukiGensyoBokaAmt1 += detail.getToukiGensyoBokaAmt();
				toukimatuBokaAmt1 += detail.getToukimatuBokaAmt();
				zenkimatuSyokyakuAmt1 += detail.getZenkimatuSyokyakuAmt();
				toukimatuSyokyakuAmt1 += detail.getToukimatuSyokyakuAmt();
				toukiZoukaBokaAmt1 += detail.getToukiZoukaBokaAmt();

				zenkimatuZanAmt2 += detail.getZenkimatuZanAmt();
				toukiZoukaAmt2 += detail.getToukiZoukaAmt();
				toukiGensyoAmt2 += detail.getToukiGensyoAmt();
				toukimatuZanAmt2 += detail.getToukimatuZanAmt();
				zenkimatuBokaAmt2 += detail.getZenkimatuBokaAmt();
				toukiJitugenAmt2 += detail.getToukiJitugenAmt();
				toukiGensyoBokaAmt2 += detail.getToukiGensyoBokaAmt();
				toukimatuBokaAmt2 += detail.getToukimatuBokaAmt();
				zenkimatuSyokyakuAmt2 += detail.getZenkimatuSyokyakuAmt();
				toukimatuSyokyakuAmt2 += detail.getToukimatuSyokyakuAmt();
				toukiZoukaBokaAmt2 += detail.getToukiZoukaBokaAmt();

				zenkimatuZanAmt3 += detail.getZenkimatuZanAmt();
				toukiZoukaAmt3 += detail.getToukiZoukaAmt();
				toukiGensyoAmt3 += detail.getToukiGensyoAmt();
				toukimatuZanAmt3 += detail.getToukimatuZanAmt();
				zenkimatuBokaAmt3 += detail.getZenkimatuBokaAmt();
				toukiJitugenAmt3 += detail.getToukiJitugenAmt();
				toukiGensyoBokaAmt3 += detail.getToukiGensyoBokaAmt();
				toukimatuBokaAmt3 += detail.getToukimatuBokaAmt();
				zenkimatuSyokyakuAmt3 += detail.getZenkimatuSyokyakuAmt();
				toukimatuSyokyakuAmt3 += detail.getToukimatuSyokyakuAmt();
				toukiZoukaBokaAmt3 += detail.getToukiZoukaBokaAmt();

				zenkimatuZanAmt4 += detail.getZenkimatuZanAmt();
				toukiZoukaAmt4 += detail.getToukiZoukaAmt();
				toukiGensyoAmt4 += detail.getToukiGensyoAmt();
				toukimatuZanAmt4 += detail.getToukimatuZanAmt();
				zenkimatuBokaAmt4 += detail.getZenkimatuBokaAmt();
				toukiJitugenAmt4 += detail.getToukiJitugenAmt();
				toukiGensyoBokaAmt4 += detail.getToukiGensyoBokaAmt();
				toukimatuBokaAmt4 += detail.getToukimatuBokaAmt();
				zenkimatuSyokyakuAmt4 += detail.getZenkimatuSyokyakuAmt();
				toukimatuSyokyakuAmt4 += detail.getToukimatuSyokyakuAmt();
				toukiZoukaBokaAmt4 += detail.getToukiZoukaBokaAmt();

				zenkimatuZanAmt5 += detail.getZenkimatuZanAmt();
				toukiZoukaAmt5 += detail.getToukiZoukaAmt();
				toukiGensyoAmt5 += detail.getToukiGensyoAmt();
				toukimatuZanAmt5 += detail.getToukimatuZanAmt();
				zenkimatuBokaAmt5 += detail.getZenkimatuBokaAmt();
				toukiJitugenAmt5 += detail.getToukiJitugenAmt();
				toukiGensyoBokaAmt5 += detail.getToukiGensyoBokaAmt();
				toukimatuBokaAmt5 += detail.getToukimatuBokaAmt();
				zenkimatuSyokyakuAmt5 += detail.getZenkimatuSyokyakuAmt();
				toukimatuSyokyakuAmt5 += detail.getToukimatuSyokyakuAmt();
				toukiZoukaBokaAmt5 += detail.getToukiZoukaBokaAmt();

				// 2020/05/22 ADD START
				zenkimatuZanAmt1_0 += detail.getZenkimatuZanAmt();
				toukiZoukaAmt1_0 += detail.getToukiZoukaAmt();
				toukiGensyoAmt1_0 += detail.getToukiGensyoAmt();
				toukimatuZanAmt1_0 += detail.getToukimatuZanAmt();
				zenkimatuBokaAmt1_0 += detail.getZenkimatuBokaAmt();
				toukiJitugenAmt1_0 += detail.getToukiJitugenAmt();
				toukiGensyoBokaAmt1_0 += detail.getToukiGensyoBokaAmt();
				toukimatuBokaAmt1_0 += detail.getToukimatuBokaAmt();
				zenkimatuSyokyakuAmt1_0 += detail.getZenkimatuSyokyakuAmt();
				toukimatuSyokyakuAmt1_0 += detail.getToukimatuSyokyakuAmt();
				toukiZoukaBokaAmt1_0 += detail.getToukiZoukaBokaAmt();

				zenkimatuZanAmt6 += detail.getZenkimatuZanAmt();
				toukiZoukaAmt6 += detail.getToukiZoukaAmt();
				toukiGensyoAmt6 += detail.getToukiGensyoAmt();
				toukimatuZanAmt6 += detail.getToukimatuZanAmt();
				zenkimatuBokaAmt6 += detail.getZenkimatuBokaAmt();
				toukiJitugenAmt6 += detail.getToukiJitugenAmt();
				toukiGensyoBokaAmt6 += detail.getToukiGensyoBokaAmt();
				toukimatuBokaAmt6 += detail.getToukimatuBokaAmt();
				zenkimatuSyokyakuAmt6 += detail.getZenkimatuSyokyakuAmt();
				toukimatuSyokyakuAmt6 += detail.getToukimatuSyokyakuAmt();
				toukiZoukaBokaAmt6 += detail.getToukiZoukaBokaAmt();
				
				// 2020/05/22 ADD END

				zenkimatuZanAmt += detail.getZenkimatuZanAmt();
				toukiZoukaAmt += detail.getToukiZoukaAmt();
				toukiGensyoAmt += detail.getToukiGensyoAmt();
				toukimatuZanAmt += detail.getToukimatuZanAmt();
				zenkimatuBokaAmt += detail.getZenkimatuBokaAmt();
				toukiJitugenAmt += detail.getToukiJitugenAmt();
				toukiGensyoBokaAmt += detail.getToukiGensyoBokaAmt();
				toukimatuBokaAmt += detail.getToukimatuBokaAmt();
				zenkimatuSyokyakuAmt += detail.getZenkimatuSyokyakuAmt();
				toukimatuSyokyakuAmt += detail.getToukimatuSyokyakuAmt();
				toukiZoukaBokaAmt += detail.getToukiZoukaBokaAmt();

				lineCount++;
			}

			// 2020/05/22 ADD START
			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			sisansriGokeiPrint();
			// 2020/05/22 ADD END

			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			sisankbnGokeiPrint();

			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			trdHnteiKekaGokeiPrint();

			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			kaikeiSyoriGokeiPrint();

			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			ackijyunGokeiPrint();

			// 2020/05/22 ADD START
			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			jysiUmGokeiPrint();
			// 2020/05/22 ADD END

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

	private void headPrint(LACSUkebaraiSisanBean piDetail, Report piReport, String piDateMode) throws Exception {
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

		field = piReport.getField("xSisanKbn");
		piReport.putFieldData(field, piDetail.getSisanKbn());

		// 2020/05/22 ADD START
		field = piReport.getField("xJysiUm");
		piReport.putFieldData(field, piDetail.getJysiUm());

		field = piReport.getField("xKoteiSisanKbn");
		piReport.putFieldData(field, piDetail.getSsnSriNm());
		// 2020/05/22 ADD END
	}

	private void gokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "総　合　計");

		field = report.getField("xZenkimatuZanAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuZanAmt));

		field = report.getField("xToukiZoukaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiZoukaAmt));

		field = report.getField("xToukiGensyoAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGensyoAmt));

		field = report.getField("xToukimatuZanAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuZanAmt));

		field = report.getField("xZenkimatuBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuBokaAmt));

		field = report.getField("xToukiJitugenAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiJitugenAmt));

		field = report.getField("xToukiGensyoBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGensyoBokaAmt));

		field = report.getField("xToukimatuBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuBokaAmt));

		field = report.getField("xZenkimatuSyokyakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuSyokyakuAmt));

		field = report.getField("xToukimatuSyokyakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuSyokyakuAmt));
		field = report.getField("xToukiZoukaBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiZoukaBokaAmt));
		zenkimatuZanAmt = 0;
		toukiZoukaAmt = 0;
		toukiGensyoAmt = 0;
		toukimatuZanAmt = 0;
		zenkimatuBokaAmt = 0;
		toukiJitugenAmt = 0;
		toukiGensyoBokaAmt = 0;
		toukimatuBokaAmt = 0;
		zenkimatuSyokyakuAmt = 0;
		toukimatuSyokyakuAmt = 0;
		toukiZoukaBokaAmt = 0;
		lineCount++;
	}

	private void leasCompanyGokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "リース会社計");

		field = report.getField("xZenkimatuZanAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuZanAmt1));

		field = report.getField("xToukiZoukaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiZoukaAmt1));

		field = report.getField("xToukiGensyoAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGensyoAmt1));

		field = report.getField("xToukimatuZanAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuZanAmt1));

		field = report.getField("xZenkimatuBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuBokaAmt1));

		field = report.getField("xToukiJitugenAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiJitugenAmt1));

		field = report.getField("xToukiGensyoBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGensyoBokaAmt1));

		field = report.getField("xToukimatuBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuBokaAmt1));

		field = report.getField("xZenkimatuSyokyakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuSyokyakuAmt1));

		field = report.getField("xToukimatuSyokyakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuSyokyakuAmt1));
		field = report.getField("xToukiZoukaBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiZoukaBokaAmt1));

		zenkimatuZanAmt1 = 0;
		toukiZoukaAmt1 = 0;
		toukiGensyoAmt1 = 0;
		toukimatuZanAmt1 = 0;
		zenkimatuBokaAmt1 = 0;
		toukiJitugenAmt1 = 0;
		toukiGensyoBokaAmt1 = 0;
		toukimatuBokaAmt1 = 0;
		zenkimatuSyokyakuAmt1 = 0;
		toukimatuSyokyakuAmt1 = 0;
		toukiZoukaBokaAmt1 = 0;

		lineCount++;
	}

	// 2020/05/22 ADD START
	private void jysiUmGokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "重要性有無計");

		field = report.getField("xZenkimatuZanAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuZanAmt1_0));

		field = report.getField("xToukiZoukaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiZoukaAmt1_0));

		field = report.getField("xToukiGensyoAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGensyoAmt1_0));

		field = report.getField("xToukimatuZanAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuZanAmt1_0));

		field = report.getField("xZenkimatuBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuBokaAmt1_0));

		field = report.getField("xToukiJitugenAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiJitugenAmt1_0));

		field = report.getField("xToukiGensyoBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGensyoBokaAmt1_0));

		field = report.getField("xToukimatuBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuBokaAmt1_0));

		field = report.getField("xZenkimatuSyokyakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuSyokyakuAmt1_0));

		field = report.getField("xToukimatuSyokyakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuSyokyakuAmt1_0));
		field = report.getField("xToukiZoukaBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiZoukaBokaAmt1_0));

		zenkimatuZanAmt1_0 = 0;
		toukiZoukaAmt1_0 = 0;
		toukiGensyoAmt1_0 = 0;
		toukimatuZanAmt1_0 = 0;
		zenkimatuBokaAmt1_0 = 0;
		toukiJitugenAmt1_0 = 0;
		toukiGensyoBokaAmt1_0 = 0;
		toukimatuBokaAmt1_0 = 0;
		zenkimatuSyokyakuAmt1_0 = 0;
		toukimatuSyokyakuAmt1_0 = 0;
		toukiZoukaBokaAmt1_0 = 0;

		lineCount++;
	}
	// 2020/05/22 ADD END

	private void ackijyunGokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "リース会計基準計");

		field = report.getField("xZenkimatuZanAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuZanAmt2));

		field = report.getField("xToukiZoukaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiZoukaAmt2));

		field = report.getField("xToukiGensyoAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGensyoAmt2));

		field = report.getField("xToukimatuZanAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuZanAmt2));

		field = report.getField("xZenkimatuBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuBokaAmt2));

		field = report.getField("xToukiJitugenAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiJitugenAmt2));

		field = report.getField("xToukiGensyoBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGensyoBokaAmt2));

		field = report.getField("xToukimatuBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuBokaAmt2));

		field = report.getField("xZenkimatuSyokyakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuSyokyakuAmt2));

		field = report.getField("xToukimatuSyokyakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuSyokyakuAmt2));
		field = report.getField("xToukiZoukaBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiZoukaBokaAmt2));

		zenkimatuZanAmt2 = 0;
		toukiZoukaAmt2 = 0;
		toukiGensyoAmt2 = 0;
		toukimatuZanAmt2 = 0;
		zenkimatuBokaAmt2 = 0;
		toukiJitugenAmt2 = 0;
		toukiGensyoBokaAmt2 = 0;
		toukimatuBokaAmt2 = 0;
		zenkimatuSyokyakuAmt2 = 0;
		toukimatuSyokyakuAmt2 = 0;
		toukiZoukaBokaAmt2 = 0;

		lineCount++;
	}

	private void kaikeiSyoriGokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "会計処理方法計");

		field = report.getField("xZenkimatuZanAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuZanAmt3));

		field = report.getField("xToukiZoukaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiZoukaAmt3));

		field = report.getField("xToukiGensyoAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGensyoAmt3));

		field = report.getField("xToukimatuZanAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuZanAmt3));

		field = report.getField("xZenkimatuBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuBokaAmt3));

		field = report.getField("xToukiJitugenAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiJitugenAmt3));

		field = report.getField("xToukiGensyoBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGensyoBokaAmt3));

		field = report.getField("xToukimatuBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuBokaAmt3));

		field = report.getField("xZenkimatuSyokyakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuSyokyakuAmt3));

		field = report.getField("xToukimatuSyokyakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuSyokyakuAmt3));
		field = report.getField("xToukiZoukaBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiZoukaBokaAmt3));

		zenkimatuZanAmt3 = 0;
		toukiZoukaAmt3 = 0;
		toukiGensyoAmt3 = 0;
		toukimatuZanAmt3 = 0;
		zenkimatuBokaAmt3 = 0;
		toukiJitugenAmt3 = 0;
		toukiGensyoBokaAmt3 = 0;
		toukimatuBokaAmt3 = 0;
		zenkimatuSyokyakuAmt3 = 0;
		toukimatuSyokyakuAmt3 = 0;
		toukiZoukaBokaAmt3 = 0;

		lineCount++;
	}

	private void trdHnteiKekaGokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "リース取引分類計");

		field = report.getField("xZenkimatuZanAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuZanAmt4));

		field = report.getField("xToukiZoukaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiZoukaAmt4));

		field = report.getField("xToukiGensyoAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGensyoAmt4));

		field = report.getField("xToukimatuZanAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuZanAmt4));

		field = report.getField("xZenkimatuBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuBokaAmt4));

		field = report.getField("xToukiJitugenAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiJitugenAmt4));

		field = report.getField("xToukiGensyoBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGensyoBokaAmt4));

		field = report.getField("xToukimatuBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuBokaAmt4));

		field = report.getField("xZenkimatuSyokyakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuSyokyakuAmt4));

		field = report.getField("xToukimatuSyokyakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuSyokyakuAmt4));
		field = report.getField("xToukiZoukaBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiZoukaBokaAmt4));

		zenkimatuZanAmt4 = 0;
		toukiZoukaAmt4 = 0;
		toukiGensyoAmt4 = 0;
		toukimatuZanAmt4 = 0;
		zenkimatuBokaAmt4 = 0;
		toukiJitugenAmt4 = 0;
		toukiGensyoBokaAmt4 = 0;
		toukimatuBokaAmt4 = 0;
		zenkimatuSyokyakuAmt4 = 0;
		toukimatuSyokyakuAmt4 = 0;
		toukiZoukaBokaAmt4 = 0;

		lineCount++;
	}

	private void sisankbnGokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "資産区分計");

		field = report.getField("xZenkimatuZanAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuZanAmt5));

		field = report.getField("xToukiZoukaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiZoukaAmt5));

		field = report.getField("xToukiGensyoAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGensyoAmt5));

		field = report.getField("xToukimatuZanAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuZanAmt5));

		field = report.getField("xZenkimatuBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuBokaAmt5));

		field = report.getField("xToukiJitugenAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiJitugenAmt5));

		field = report.getField("xToukiGensyoBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGensyoBokaAmt5));

		field = report.getField("xToukimatuBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuBokaAmt5));

		field = report.getField("xZenkimatuSyokyakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuSyokyakuAmt5));

		field = report.getField("xToukimatuSyokyakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuSyokyakuAmt5));
		field = report.getField("xToukiZoukaBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiZoukaBokaAmt5));

		zenkimatuZanAmt5 = 0;
		toukiZoukaAmt5 = 0;
		toukiGensyoAmt5 = 0;
		toukimatuZanAmt5 = 0;
		zenkimatuBokaAmt5 = 0;
		toukiJitugenAmt5 = 0;
		toukiGensyoBokaAmt5 = 0;
		toukimatuBokaAmt5 = 0;
		zenkimatuSyokyakuAmt5 = 0;
		toukimatuSyokyakuAmt5 = 0;
		toukiZoukaBokaAmt5 = 0;

		lineCount++;
	}

	// 2020/05/22 ADD START
	private void sisansriGokeiPrint() throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "固定資産科目計");

		field = report.getField("xZenkimatuZanAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuZanAmt6));

		field = report.getField("xToukiZoukaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiZoukaAmt6));

		field = report.getField("xToukiGensyoAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGensyoAmt6));

		field = report.getField("xToukimatuZanAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuZanAmt6));

		field = report.getField("xZenkimatuBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuBokaAmt6));

		field = report.getField("xToukiJitugenAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiJitugenAmt6));

		field = report.getField("xToukiGensyoBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiGensyoBokaAmt6));

		field = report.getField("xToukimatuBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuBokaAmt6));

		field = report.getField("xZenkimatuSyokyakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(zenkimatuSyokyakuAmt6));

		field = report.getField("xToukimatuSyokyakuAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukimatuSyokyakuAmt6));
		field = report.getField("xToukiZoukaBokaAmt" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiZoukaBokaAmt6));

		zenkimatuZanAmt6 = 0;
		toukiZoukaAmt6 = 0;
		toukiGensyoAmt6 = 0;
		toukimatuZanAmt6 = 0;
		zenkimatuBokaAmt6 = 0;
		toukiJitugenAmt6 = 0;
		toukiGensyoBokaAmt6 = 0;
		toukimatuBokaAmt6 = 0;
		zenkimatuSyokyakuAmt6 = 0;
		toukimatuSyokyakuAmt6 = 0;
		toukiZoukaBokaAmt6 = 0;

		lineCount++;
	}
	// 2020/05/22 ADD END

}
