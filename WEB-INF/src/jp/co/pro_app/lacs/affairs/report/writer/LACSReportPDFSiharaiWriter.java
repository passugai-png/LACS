package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportSiharaiBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportSiharaiEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

/**
 * 帳票出力：リース会計資料（支払リース料等）Model.
 * 
 * @author ohmura
 * @version 20070901
 */
public class LACSReportPDFSiharaiWriter extends LACSReportPDFWriterBase {

	private Report					report					= null;					// WebKCoreレポートオブジェクト

	private LACSReportSiharaiBean	detail					= null;

	// 2020/05/22 REP START LACS帳票バッチ出力
	//private long					souPage					= 0;						// 総ページ数
	private int						souPage					= 0;						// 総ページ数
	// 2020/05/22 REP END   LACS帳票バッチ出力

	private long					page					= 0;						// ページ

	private int						lineCount				= 0;						// 明細カウンタ

	private String					index					= "";						// 明細行修飾子

	private long					leaseSougaku			= 0;						// (リース料総額)

	private long					syutokuKakakuSoutou		= 0;						// (取得価格相当額)

	private long					ijikanriHi				= 0;						// (維持「管理費相当額)

	private long					ekmteikHi				= 0;						// (役務提供費)

	private long					zanHosyou				= 0;						// (残価保証額)

	private long					toukSiharaiLeaseRyou	= 0;						// (当期支払リース料)

	private long					toukiIjiKanriHi			= 0;						// (当期維持管理費)

	private long					toukiekmteikHi			= 0;						// (当期役務提供費)

	private long					siharaiRisoku			= 0;						// (支払利息相当額)

	private long					leaseSaimuHensaiGaku	= 0;						// (リース債務返済額)

	private long					mikeikaKimatuZan		= 0;						// (期末残高相当額)

	private long					mikeikaKimatuZan1Nai	= 0;						// (期末残高相当額うち１年内)

	private long					mikeikaKimatuZan1Cyo	= 0;						// (期末残高相当額うち１年超)

	private long					leaseSougaku0			= 0;						// (リース料総額)

	private long					syutokuKakakuSoutou0	= 0;						// (取得価格相当額)

	private long					ijikanriHi0				= 0;						// (維持「管理費相当額)

	private long					ekmteikHi0				= 0;						// (当期役務提供費)

	private long					zanHosyou0				= 0;						// (残価保証額)

	private long					toukSiharaiLeaseRyou0	= 0;						// (当期支払リース料)

	private long					toukiIjiKanriHi0		= 0;						// (当期維持管理費)

	private long					toukiekmteikHi0			= 0;						// (役務提供費)

	private long					siharaiRisoku0			= 0;						// (支払利息相当額)

	private long					leaseSaimuHensaiGaku0	= 0;						// (リース債務返済額)

	private long					mikeikaKimatuZan0		= 0;						// (期末残高相当額)

	private long					mikeikaKimatuZan1Nai0	= 0;						// (期末残高相当額うち１年内)

	private long					mikeikaKimatuZan1Cyo0	= 0;						// (期末残高相当額うち１年超)

	// 2020/05/22 ADD START
	private long					leaseSougaku0_1			= 0;						// (リース料総額)

	private long					syutokuKakakuSoutou0_1	= 0;						// (取得価格相当額)

	private long					ijikanriHi0_1			= 0;						// (維持「管理費相当額)

	private long					ekmteikHi0_1			= 0;						// (当期役務提供費)

	private long					zanHosyou0_1			= 0;						// (残価保証額)

	private long					toukSiharaiLeaseRyou0_1	= 0;						// (当期支払リース料)

	private long					toukiIjiKanriHi0_1		= 0;						// (当期維持管理費)

	private long					toukiekmteikHi0_1		= 0;						// (役務提供費)

	private long					siharaiRisoku0_1		= 0;						// (支払利息相当額)

	private long					leaseSaimuHensaiGaku0_1	= 0;						// (リース債務返済額)

	private long					mikeikaKimatuZan0_1		= 0;						// (期末残高相当額)

	private long					mikeikaKimatuZan1Nai0_1	= 0;						// (期末残高相当額うち１年内)

	private long					mikeikaKimatuZan1Cyo0_1	= 0;						// (期末残高相当額うち１年超)

	// 2020/05/22 ADD END

	private long					leaseSougaku1			= 0;						// (リース料総額)

	private long					syutokuKakakuSoutou1	= 0;						// (取得価格相当額)

	private long					ijikanriHi1				= 0;						// (維持「管理費相当額)

	private long					ekmteikHi1				= 0;						// (役務提供費)

	private long					zanHosyou1				= 0;						// (残価保証額)

	private long					toukSiharaiLeaseRyou1	= 0;						// (当期支払リース料)

	private long					toukiIjiKanriHi1		= 0;						// (当期維持管理費)

	private long					toukiekmteikHi1			= 0;						// (当期役務提供費)

	private long					siharaiRisoku1			= 0;						// (支払利息相当額)

	private long					leaseSaimuHensaiGaku1	= 0;						// (リース債務返済額)

	private long					mikeikaKimatuZan1		= 0;						// (期末残高相当額)

	private long					mikeikaKimatuZan1Nai1	= 0;						// (期末残高相当額うち１年内)

	private long					mikeikaKimatuZan1Cyo1	= 0;						// (期末残高相当額うち１年超)

	private long					leaseSougaku2			= 0;						// (リース料総額)

	private long					syutokuKakakuSoutou2	= 0;						// (取得価格相当額)

	private long					ijikanriHi2				= 0;						// (維持「管理費相当額)

	private long					ekmteikHi2				= 0;						// (役務提供費)

	private long					zanHosyou2				= 0;						// (残価保証額)

	private long					toukSiharaiLeaseRyou2	= 0;						// (当期支払リース料)

	private long					toukiIjiKanriHi2		= 0;						// (当期維持管理費)

	private long					toukiekmteikHi2			= 0;						// (当期役務提供費)

	private long					siharaiRisoku2			= 0;						// (支払利息相当額)

	private long					leaseSaimuHensaiGaku2	= 0;						// (リース債務返済額)

	private long					mikeikaKimatuZan2		= 0;						// (期末残高相当額)

	private long					mikeikaKimatuZan1Nai2	= 0;						// (期末残高相当額うち１年内)

	private long					mikeikaKimatuZan1Cyo2	= 0;						// (期末残高相当額うち１年超)

	private long					leaseSougaku3			= 0;						// (リース料総額)

	private long					syutokuKakakuSoutou3	= 0;						// (取得価格相当額)

	private long					ijikanriHi3				= 0;						// (維持「管理費相当額)

	private long					ekmteikHi3				= 0;						// (役務提供費)

	private long					zanHosyou3				= 0;						// (残価保証額)

	private long					toukSiharaiLeaseRyou3	= 0;						// (当期支払リース料)

	private long					toukiIjiKanriHi3		= 0;						// (当期維持管理費)

	private long					toukiekmteikHi3			= 0;						// (当期役務提供費)

	private long					siharaiRisoku3			= 0;						// (支払利息相当額)

	private long					leaseSaimuHensaiGaku3	= 0;						// (リース債務返済額)

	private long					mikeikaKimatuZan3		= 0;						// (期末残高相当額)

	private long					mikeikaKimatuZan1Nai3	= 0;						// (期末残高相当額うち１年内)

	private long					mikeikaKimatuZan1Cyo3	= 0;						// (期末残高相当額うち１年超)

	private long					leaseSougaku4			= 0;						// (リース料総額)

	private long					syutokuKakakuSoutou4	= 0;						// (取得価格相当額)

	private long					ijikanriHi4				= 0;						// (維持「管理費相当額)

	private long					ekmteikHi4				= 0;						// (役務提供費)

	private long					zanHosyou4				= 0;						// (残価保証額)

	private long					toukSiharaiLeaseRyou4	= 0;						// (当期支払リース料)

	private long					toukiIjiKanriHi4		= 0;						// (当期維持管理費)

	private long					toukiekmteikHi4			= 0;						// (当期役務提供費)

	private long					siharaiRisoku4			= 0;						// (支払利息相当額)

	private long					leaseSaimuHensaiGaku4	= 0;						// (リース債務返済額)

	private long					mikeikaKimatuZan4		= 0;						// (期末残高相当額)

	private long					mikeikaKimatuZan1Nai4	= 0;						// (期末残高相当額うち１年内)

	private long					mikeikaKimatuZan1Cyo4	= 0;						// (期末残高相当額うち１年超)

	private long					leaseSougaku5			= 0;						// (リース料総額)

	private long					syutokuKakakuSoutou5	= 0;						// (取得価格相当額)

	private long					ijikanriHi5				= 0;						// (維持「管理費相当額)

	private long					ekmteikHi5				= 0;						// (役務提供費)

	private long					zanHosyou5				= 0;						// (残価保証額)

	private long					toukSiharaiLeaseRyou5	= 0;						// (当期支払リース料)

	private long					toukiIjiKanriHi5		= 0;						// (当期維持管理費)

	private long					toukiekmteikHi5			= 0;						// (当期役務提供費)

	private long					siharaiRisoku5			= 0;						// (支払利息相当額)

	private long					leaseSaimuHensaiGaku5	= 0;						// (リース債務返済額)

	private long					mikeikaKimatuZan5		= 0;						// (期末残高相当額)

	private long					mikeikaKimatuZan1Nai5	= 0;						// (期末残高相当額うち１年内)

	private long					mikeikaKimatuZan1Cyo5	= 0;						// (期末残高相当額うち１年超)

	private static final int		MAX_LINE				= 13;						// 明細行数

	private static final String		TITLE_COMP				= "リース会社　：";

	private static final String		TITLE_USER				= "開示先　　　：";

	private static final String		TITLE_OLD				= "リース会計資料（支払リース料等）[旧]";

	private static final String		TITLE_NEW				= "リース会計資料（支払リース料等）[新]";

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
		tmpFile = File.createTempFile("pdf03_" + prefix + "_", ".pdf", scratchDirectory);
		fout = new FileOutputStream(tmpFile);
		File formFile = new File(formDirectory, "Siharai.pdf");
		File datFile = new File(formDirectory, "Siharai.dat");
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
	public LACSReportPDFSiharaiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
		LACSReportSiharaiEntity reportEntity = new LACSReportSiharaiEntity(super.model, commonBean, piReportBean, this.acStd);
		LACSReportSiharaiBean shiharaiDetail = null;

		try {
			reportEntity.setCon(super.con);

			piReportBean.setDataMax(reportEntity.execSQL());

			while (reportEntity.next()) {
				shiharaiDetail = new LACSReportSiharaiBean();
				piReportBean.addSiharaiBean(shiharaiDetail);

				shiharaiDetail.setBrakeKey0(reportEntity.getBrakeKey0());
				shiharaiDetail.setBrakeKey1(reportEntity.getBrakeKey1());
				shiharaiDetail.setBrakeKey2(reportEntity.getBrakeKey2());
				shiharaiDetail.setBrakeKey3(reportEntity.getBrakeKey3());

				shiharaiDetail.setBrakeKey4(reportEntity.getBrakeKey4());
				shiharaiDetail.setBrakeKey5(reportEntity.getBrakeKey5());
			
				// 2020/05/22 ADD START
				shiharaiDetail.setBrakeKey0_1(reportEntity.getBrakeKey0_1());
				shiharaiDetail.setJysiUm(reportEntity.getJysiUm());
				// 2020/05/22 ADD END

				shiharaiDetail.setLeaseCompany(reportEntity.getLeaseCompany());

				shiharaiDetail.setLeaseBunrui(reportEntity.getLeaseBunrui());
				shiharaiDetail.setKoteiSisanKamoku(reportEntity.getKoteiSisanKamoku());
				shiharaiDetail.setRisokuBunpaiHouhou(reportEntity.getRisokuBunpaiHouhou());
				shiharaiDetail.setToukiReaseRyouKeisanKijyun(reportEntity.getToukiReaseRyouKeisanKijyun());
				shiharaiDetail.setMikeikaReaseRyouKeisanKijyun(reportEntity.getMikeikaReaseRyouKeisanKijyun());
				shiharaiDetail.setKeiyakuNo(reportEntity.getKeiyakuNo());
				shiharaiDetail.setLeaseFrom(reportEntity.getLeaseFrom());
				shiharaiDetail.setKaiFunoYMD(reportEntity.getKaiFunoYMD());
				shiharaiDetail.setLeaseTo(reportEntity.getLeaseTo());
				shiharaiDetail.setBukenNo(reportEntity.getBukenNo());
				shiharaiDetail.setBukenNm(reportEntity.getBukenNm());
				shiharaiDetail.setKaiyakuYmd(reportEntity.getKaiyakuYmd());
				shiharaiDetail.setKeisanRisiRitu(reportEntity.getKeisanRisiRitu());
				shiharaiDetail.setLeaseSougaku(reportEntity.getLeaseSougaku());
				shiharaiDetail.setSyutokuKakakuSoutou(reportEntity.getSyutokuKakakuSoutou());
				shiharaiDetail.setIjikanriHi(reportEntity.getIjikanriHi());

				shiharaiDetail.setEkmTeik(reportEntity.getEkmteik());

				shiharaiDetail.setZanHosyou(reportEntity.getZanHosyou());
				shiharaiDetail.setToukSiharaiLeaseRyou(reportEntity.getToukSiharaiLeaseRyou());
				shiharaiDetail.setToukiIjiKanriHi(reportEntity.getToukiIjiKanriHi());
				shiharaiDetail.setToukiEkmTeik(reportEntity.getToukiEkmteik());
				shiharaiDetail.setSiharaiRisoku(reportEntity.getSiharaiRisoku());
				shiharaiDetail.setLeaseSaimuHensaiGaku(reportEntity.getLeaseSaimuHensaiGaku());
				shiharaiDetail.setMikeikaKimatuZan(reportEntity.getMikeikaKimatuZan());
				shiharaiDetail.setMikeikaKimatuZan1Nai(reportEntity.getMikeikaKimatuZan1Nai());
				shiharaiDetail.setMikeikaKimatuZan1Cyo(reportEntity.getMikeikaKimatuZan1Cyo());
				shiharaiDetail.setLeasCompanyNm(reportEntity.getLeasCompanyNm());
				shiharaiDetail.setLeasUserNm(reportEntity.getLeasUserNm());

				shiharaiDetail.setAcShrKbnName(reportEntity.getAcShrKbnName());

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
		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		formDirectory = new File(wprlHomeDirectory, FORM_PATH);

		// 2020/05/22 DEL START LACS帳票バッチ出力
		//File tmpFile = null; // 出力先ファイル
		//FileOutputStream fout = null; // 出力ファイルストリーム
		// 2020/05/22 DEL END   LACS帳票バッチ出力

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
		String brakeKey5 = ""; // ブレイクキー

		// 2020/05/22 ADD START
		String brakeKey0_1 = ""; // ブレイクキー 重要性有無
		// 2020/05/22 ADD END

		index = ""; // 明細行修飾子

		Field field = null;

		try {
			// 2020/05/22 ADD START LACS帳票バッチ出力
			if (!batchFlg) {
			// 2020/05/22 ADD END   LACS帳票バッチ出力

				tmpFile = File.createTempFile("pdf03_" + prefix + "_", ".pdf", scratchDirectory);
				fout = new FileOutputStream(tmpFile);
				File formFile = new File(formDirectory, "Siharai.pdf");
				File datFile = new File(formDirectory, "Siharai.dat");
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

			leaseSougaku = 0; // (リース料総額)
			syutokuKakakuSoutou = 0; // (取得価格相当額)
			ijikanriHi = 0; // (維持「管理費相当額)
			ekmteikHi = 0; // (役務提供費)

			zanHosyou = 0; // (残価保証額)
			toukSiharaiLeaseRyou = 0; // (当期支払リース料)
			toukiIjiKanriHi = 0; // (当期維持管理費)
			toukiekmteikHi = 0; // (役務提供費)
			siharaiRisoku = 0; // (支払利息相当額)
			leaseSaimuHensaiGaku = 0; // (リース債務返済額)
			mikeikaKimatuZan = 0; // (期末残高相当額)
			mikeikaKimatuZan1Nai = 0; // (期末残高相当額うち１年内)
			mikeikaKimatuZan1Cyo = 0; // (期末残高相当額うち１年超)

			leaseSougaku0 = 0; // (リース料総額)
			syutokuKakakuSoutou0 = 0; // (取得価格相当額)
			ijikanriHi0 = 0; // (維持「管理費相当額)
			ekmteikHi0 = 0; // (役務提供費)
			zanHosyou0 = 0; // (残価保証額)
			toukSiharaiLeaseRyou0 = 0; // (当期支払リース料)
			toukiIjiKanriHi0 = 0; // (当期維持管理費)
			toukiekmteikHi0 = 0; // (役務提供費)
			siharaiRisoku0 = 0; // (支払利息相当額)
			leaseSaimuHensaiGaku0 = 0; // (リース債務返済額)
			mikeikaKimatuZan0 = 0; // (期末残高相当額)
			mikeikaKimatuZan1Nai0 = 0; // (期末残高相当額うち１年内)
			mikeikaKimatuZan1Cyo0 = 0; // (期末残高相当額うち１年超)

			// 2020/05/22 ADD START
			leaseSougaku0_1 = 0; // (リース料総額)
			syutokuKakakuSoutou0_1 = 0; // (取得価格相当額)
			ijikanriHi0_1 = 0; // (維持「管理費相当額)
			ekmteikHi0_1 = 0; // (役務提供費)
			zanHosyou0_1 = 0; // (残価保証額)
			toukSiharaiLeaseRyou0_1 = 0; // (当期支払リース料)
			toukiIjiKanriHi0_1 = 0; // (当期維持管理費)
			toukiekmteikHi0_1 = 0; // (役務提供費)
			siharaiRisoku0_1 = 0; // (支払利息相当額)
			leaseSaimuHensaiGaku0_1 = 0; // (リース債務返済額)
			mikeikaKimatuZan0_1 = 0; // (期末残高相当額)
			mikeikaKimatuZan1Nai0_1 = 0; // (期末残高相当額うち１年内)
			mikeikaKimatuZan1Cyo0_1 = 0; // (期末残高相当額うち１年超)
			// 2020/05/22 ADD END

			leaseSougaku1 = 0; // (リース料総額)
			syutokuKakakuSoutou1 = 0; // (取得価格相当額)
			ijikanriHi1 = 0; // (維持「管理費相当額)
			ekmteikHi1 = 0; // (役務提供費)
			zanHosyou1 = 0; // (残価保証額)
			toukSiharaiLeaseRyou1 = 0; // (当期支払リース料)
			toukiIjiKanriHi1 = 0; // (当期維持管理費)
			toukiekmteikHi1 = 0; // (役務提供費)
			siharaiRisoku1 = 0; // (支払利息相当額)
			leaseSaimuHensaiGaku1 = 0; // (リース債務返済額)
			mikeikaKimatuZan1 = 0; // (期末残高相当額)
			mikeikaKimatuZan1Nai1 = 0; // (期末残高相当額うち１年内)
			mikeikaKimatuZan1Cyo1 = 0; // (期末残高相当額うち１年超)

			leaseSougaku2 = 0; // (リース料総額)
			syutokuKakakuSoutou2 = 0; // (取得価格相当額)
			ijikanriHi2 = 0; // (維持「管理費相当額)
			ekmteikHi2 = 0; // (役務提供費)
			zanHosyou2 = 0; // (残価保証額)
			toukSiharaiLeaseRyou2 = 0; // (当期支払リース料)
			toukiIjiKanriHi2 = 0; // (当期維持管理費)
			toukiekmteikHi2 = 0; // (役務提供費)
			siharaiRisoku2 = 0; // (支払利息相当額)
			leaseSaimuHensaiGaku2 = 0; // (リース債務返済額)
			mikeikaKimatuZan2 = 0; // (期末残高相当額)
			mikeikaKimatuZan1Nai2 = 0; // (期末残高相当額うち１年内)
			mikeikaKimatuZan1Cyo2 = 0; // (期末残高相当額うち１年超)

			leaseSougaku3 = 0; // (リース料総額)
			syutokuKakakuSoutou3 = 0; // (取得価格相当額)
			ijikanriHi3 = 0; // (維持「管理費相当額)
			ekmteikHi3 = 0; // (役務提供費)
			zanHosyou3 = 0; // (残価保証額)
			toukSiharaiLeaseRyou3 = 0; // (当期支払リース料)
			toukiIjiKanriHi3 = 0; // (当期維持管理費)
			toukiekmteikHi3 = 0; // (役務提供費)
			siharaiRisoku3 = 0; // (支払利息相当額)
			leaseSaimuHensaiGaku3 = 0; // (リース債務返済額)
			mikeikaKimatuZan3 = 0; // (期末残高相当額)
			mikeikaKimatuZan1Nai3 = 0; // (期末残高相当額うち１年内)
			mikeikaKimatuZan1Cyo3 = 0; // (期末残高相当額うち１年超)

			leaseSougaku4 = 0; // (リース料総額)
			syutokuKakakuSoutou4 = 0; // (取得価格相当額)
			ijikanriHi4 = 0; // (維持「管理費相当額)
			ekmteikHi4 = 0; // (役務提供費)
			zanHosyou4 = 0; // (残価保証額)
			toukSiharaiLeaseRyou4 = 0; // (当期支払リース料)
			toukiIjiKanriHi4 = 0; // (当期維持管理費)
			toukiekmteikHi4 = 0; // (役務提供費)
			siharaiRisoku4 = 0; // (支払利息相当額)
			leaseSaimuHensaiGaku4 = 0; // (リース債務返済額)
			mikeikaKimatuZan4 = 0; // (期末残高相当額)
			mikeikaKimatuZan1Nai4 = 0; // (期末残高相当額うち１年内)
			mikeikaKimatuZan1Cyo4 = 0; // (期末残高相当額うち１年超)

			leaseSougaku5 = 0; // (リース料総額)
			syutokuKakakuSoutou5 = 0; // (取得価格相当額)
			ijikanriHi5 = 0; // (維持「管理費相当額)
			ekmteikHi5 = 0; // (役務提供費)
			zanHosyou5 = 0; // (残価保証額)
			toukSiharaiLeaseRyou5 = 0; // (当期支払リース料)
			toukiIjiKanriHi5 = 0; // (当期維持管理費)
			toukiekmteikHi5 = 0; // (役務提供費)
			siharaiRisoku5 = 0; // (支払利息相当額)
			leaseSaimuHensaiGaku5 = 0; // (リース債務返済額)
			mikeikaKimatuZan5 = 0; // (期末残高相当額)
			mikeikaKimatuZan1Nai5 = 0; // (期末残高相当額うち１年内)
			mikeikaKimatuZan1Cyo5 = 0; // (期末残高相当額うち１年超)

			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				detail = piReportBean.getSiharaiBean(i);

				if (!detail.getBrakeKey5().equals(brakeKey5)) {
					if (!brakeKey5.equals("")) {

						if (lineCount >= MAX_LINE) {
							souPage++; // 総ページ数のカウントＵＰ
							lineCount = 0;
						}

						lineCount++;

						if (!detail.getBrakeKey4().equals(brakeKey4)) {

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
					brakeKey5 = detail.getBrakeKey5();
				}
				else {

					if (lineCount >= MAX_LINE) {
						souPage++; // 総ページ数のカウントＵＰ
						lineCount = 0;
					}
				}
				lineCount++;

				//System.out.println("souPage\t" + souPage);
				//System.out.println("lineCount\t" + lineCount);
				//System.out.println("");
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
			brakeKey5 = ""; // ブレイクキー
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
				detail = piReportBean.getSiharaiBean(i);

				if (!detail.getBrakeKey5().equals(brakeKey5)) {
					if (!brakeKey5.equals("")) {

						if (lineCount >= MAX_LINE) {
							detail = piReportBean.getSiharaiBean(i - 1);
							headPrint(piReportBean, piDateMode);
							detail = piReportBean.getSiharaiBean(i);
						}

						keisanKijunPrint(piReportBean);

						leaseSougaku5 = 0; // (リース料総額)
						syutokuKakakuSoutou5 = 0; // (取得価格相当額)
						ijikanriHi5 = 0; // (維持「管理費相当額)
						ekmteikHi5 = 0; // (役務提供費)
						zanHosyou5 = 0; // (残価保証額)
						toukSiharaiLeaseRyou5 = 0; // (当期支払リース料)
						toukiIjiKanriHi5 = 0; // (当期維持管理費)
						toukiekmteikHi5 = 0; // (役務提供費)
						siharaiRisoku5 = 0; // (支払利息相当額)
						leaseSaimuHensaiGaku5 = 0; // (リース債務返済額)
						mikeikaKimatuZan5 = 0; // (期末残高相当額)
						mikeikaKimatuZan1Nai5 = 0; // (期末残高相当額うち１年内)
						mikeikaKimatuZan1Cyo5 = 0; // (期末残高相当額うち１年超)

						if (!detail.getBrakeKey4().equals(brakeKey4)) {

							if (lineCount >= MAX_LINE) {
								detail = piReportBean.getSiharaiBean(i - 1);
								headPrint(piReportBean, piDateMode);
								detail = piReportBean.getSiharaiBean(i);
							}

							rskKeijHohoKbnPrint(piReportBean);

							leaseSougaku4 = 0; // (リース料総額)
							syutokuKakakuSoutou4 = 0; // (取得価格相当額)
							ijikanriHi4 = 0; // (維持「管理費相当額)
							ekmteikHi4 = 0; // (役務提供費)
							zanHosyou4 = 0; // (残価保証額)
							toukSiharaiLeaseRyou4 = 0; // (当期支払リース料)
							toukiIjiKanriHi4 = 0; // (当期維持管理費)
							toukiekmteikHi4 = 0; // (役務提供費)
							siharaiRisoku4 = 0; // (支払利息相当額)
							leaseSaimuHensaiGaku4 = 0; // (リース債務返済額)
							mikeikaKimatuZan4 = 0; // (期末残高相当額)
							mikeikaKimatuZan1Nai4 = 0; // (期末残高相当額うち１年内)
							mikeikaKimatuZan1Cyo4 = 0; // (期末残高相当額うち１年超)

							if (!detail.getBrakeKey3().equals(brakeKey3)) {

								if (lineCount >= MAX_LINE) {
									detail = piReportBean.getSiharaiBean(i - 1);
									headPrint(piReportBean, piDateMode);
									detail = piReportBean.getSiharaiBean(i);
								}

								koteiSisanGokeiPrint(piReportBean);

								leaseSougaku3 = 0; // (リース料総額)
								syutokuKakakuSoutou3 = 0; // (取得価格相当額)
								ijikanriHi3 = 0; // (維持「管理費相当額)
								ekmteikHi3 = 0; // (役務提供費)
								zanHosyou3 = 0; // (残価保証額)
								toukSiharaiLeaseRyou3 = 0; // (当期支払リース料)
								toukiIjiKanriHi3 = 0; // (当期維持管理費)
								toukiekmteikHi3 = 0; // (役務提供費)
								siharaiRisoku3 = 0; // (支払利息相当額)
								leaseSaimuHensaiGaku3 = 0; // (リース債務返済額)
								mikeikaKimatuZan3 = 0; // (期末残高相当額)
								mikeikaKimatuZan1Nai3 = 0; // (期末残高相当額うち１年内)
								mikeikaKimatuZan1Cyo3 = 0; // (期末残高相当額うち１年超)

								if (!detail.getBrakeKey2().equals(brakeKey2)) {

									if (lineCount >= MAX_LINE) {
										detail = piReportBean.getSiharaiBean(i - 1);
										headPrint(piReportBean, piDateMode);
										detail = piReportBean.getSiharaiBean(i);
									}

									kaikeiSyoriPrint(piReportBean);

									leaseSougaku2 = 0; // (リース料総額)
									syutokuKakakuSoutou2 = 0; // (取得価格相当額)
									ijikanriHi2 = 0; // (維持「管理費相当額)
									ekmteikHi2 = 0; // (役務提供費)
									zanHosyou2 = 0; // (残価保証額)
									toukSiharaiLeaseRyou2 = 0; // (当期支払リース料)
									toukiIjiKanriHi2 = 0; // (当期維持管理費)
									toukiekmteikHi2 = 0; // (役務提供費)
									siharaiRisoku2 = 0; // (支払利息相当額)
									leaseSaimuHensaiGaku2 = 0; // (リース債務返済額)
									mikeikaKimatuZan2 = 0; // (期末残高相当額)
									mikeikaKimatuZan1Nai2 = 0; // (期末残高相当額うち１年内)
									mikeikaKimatuZan1Cyo2 = 0; // (期末残高相当額うち１年超)

									if (!detail.getBrakeKey1().equals(brakeKey1)) {

										if (lineCount >= MAX_LINE) {
											detail = piReportBean.getSiharaiBean(i - 1);
											headPrint(piReportBean, piDateMode);
											detail = piReportBean.getSiharaiBean(i);
										}

										leaseBunruiGokeiPrint(piReportBean);

										leaseSougaku1 = 0; // (リース料総額)
										syutokuKakakuSoutou1 = 0; // (取得価格相当額)
										ijikanriHi1 = 0; // (維持「管理費相当額)
										ekmteikHi1 = 0; // (役務提供費)
										zanHosyou1 = 0; // (残価保証額)
										toukSiharaiLeaseRyou1 = 0; // (当期支払リース料)
										toukiIjiKanriHi1 = 0; // (当期維持管理費)
										toukiekmteikHi1 = 0; // (役務提供費)
										siharaiRisoku1 = 0; // (支払利息相当額)
										leaseSaimuHensaiGaku1 = 0; // (リース債務返済額)
										mikeikaKimatuZan1 = 0; // (期末残高相当額)
										mikeikaKimatuZan1Nai1 = 0; // (期末残高相当額うち１年内)
										mikeikaKimatuZan1Cyo1 = 0; // (期末残高相当額うち１年超)
										// 2020/05/22 ADD START
										if (!detail.getBrakeKey0_1().equals(brakeKey0_1)) {

											if (lineCount >= MAX_LINE) {
												detail = piReportBean.getSiharaiBean(i - 1);
												headPrint(piReportBean, piDateMode);
												detail = piReportBean.getSiharaiBean(i);
											}

											JysiUmGokeiPrint(piReportBean);

											leaseSougaku0_1 = 0; // (リース料総額)
											syutokuKakakuSoutou0_1 = 0; // (取得価格相当額)
											ijikanriHi0_1 = 0; // (維持「管理費相当額)
											ekmteikHi0_1 = 0; // (役務提供費)
											zanHosyou0_1 = 0; // (残価保証額)
											toukSiharaiLeaseRyou0_1 = 0; // (当期支払リース料)
											toukiIjiKanriHi0_1 = 0; // (当期維持管理費)
											toukiekmteikHi0_1 = 0; // (役務提供費)
											siharaiRisoku0_1 = 0; // (支払利息相当額)
											leaseSaimuHensaiGaku0_1 = 0; // (リース債務返済額)
											mikeikaKimatuZan0_1 = 0; // (期末残高相当額)
											mikeikaKimatuZan1Nai0_1 = 0; // (期末残高相当額うち１年内)
											mikeikaKimatuZan1Cyo0_1 = 0; // (期末残高相当額うち１年超)
										// 2020/05/22 ADD END

											if (!detail.getBrakeKey0().equals(brakeKey0)) {
	
												if (lineCount >= MAX_LINE) {
													detail = piReportBean.getSiharaiBean(i - 1);
													headPrint(piReportBean, piDateMode);
													detail = piReportBean.getSiharaiBean(i);
												}
	
												leaseCompanyGokeiPrint(piReportBean);
	
												leaseSougaku0 = 0; // (リース料総額)
												syutokuKakakuSoutou0 = 0; // (取得価格相当額)
												ijikanriHi0 = 0; // (維持「管理費相当額)
												ekmteikHi0 = 0; // (役務提供費)
												zanHosyou0 = 0; // (残価保証額)
												toukSiharaiLeaseRyou0 = 0; // (当期支払リース料)
												toukiIjiKanriHi0 = 0; // (当期維持管理費)
												toukiekmteikHi0 = 0; // (役務提供費)
	
												siharaiRisoku0 = 0; // (支払利息相当額)
												leaseSaimuHensaiGaku0 = 0; // (リース債務返済額)
												mikeikaKimatuZan0 = 0; // (期末残高相当額)
												mikeikaKimatuZan1Nai0 = 0; // (期末残高相当額うち１年内)
												mikeikaKimatuZan1Cyo0 = 0; // (期末残高相当額うち１年超)
											}
										// 2020/05/22 ADD START
										}
										// 2020/05/22 ADD END
									}
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
					brakeKey5 = detail.getBrakeKey5();
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

				field = report.getField("xKaiFuno" + index);
				if (detail.getKaiFunoYMD() != null) {
					report.putFieldData(field, "(" + super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getKaiFunoYMD()))), piDateMode) + ")");
				}
				// System.out.println("xKaiFuno:" + detail.getKaiFunoYMD());

				field = report.getField("xBukenNo" + index);
				report.putFieldData(field, detail.getBukenNo());

				field = report.getField("xBukenNm" + index);
				report.putFieldData(field, detail.getBukenNm());

				field = report.getField("xKaiyakuYmd" + index);
				report.putFieldData(field, super.convertReki(Convert.toString(Convert.toDate(Convert.toDateString(detail.getKaiyakuYmd()))), piDateMode));

				if (detail.getKeisanRisiRitu() != null) {
					field = report.getField("xKeisanRisiRitu" + index);
					report.putFieldData(field, detail.getKeisanRisiRitu() + "%");
				}

				field = report.getField("xLeaseSougaku" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getLeaseSougaku()));

				field = report.getField("xSyutokuKakakuSoutou" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyutokuKakakuSoutou()));

				field = report.getField("xEkimuHi" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getEkmTeik()));

				field = report.getField("xIjikanriHi" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getIjikanriHi()));

				field = report.getField("xZanHosyou" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZanHosyou()));

				field = report.getField("xToukSiharaiLeaseRyou" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukSiharaiLeaseRyou()));

				field = report.getField("xToukiEkimuHi" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukiEkmTeik()));

				field = report.getField("xToukiIjiKanriHi" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getToukiIjiKanriHi()));

				field = report.getField("xSiharaiRisoku" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getSiharaiRisoku()));

				field = report.getField("xLeaseSaimuHensaiGaku" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getLeaseSaimuHensaiGaku()));

				field = report.getField("xMikeikaKimatuZan" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaKimatuZan()));

				field = report.getField("xMikeikaKimatuZan1Nai" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaKimatuZan1Nai()));

				field = report.getField("xMikeikaKimatuZan1Cyo" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaKimatuZan1Cyo()));

				leaseSougaku5 += detail.getLeaseSougaku();
				syutokuKakakuSoutou5 += detail.getSyutokuKakakuSoutou();
				ijikanriHi5 += detail.getIjikanriHi();
				ekmteikHi5 += detail.getEkmTeik();
				zanHosyou5 += detail.getZanHosyou();
				toukSiharaiLeaseRyou5 += detail.getToukSiharaiLeaseRyou();
				toukiIjiKanriHi5 += detail.getToukiIjiKanriHi();
				toukiekmteikHi5 += detail.getToukiEkmTeik();
				siharaiRisoku5 += detail.getSiharaiRisoku();
				leaseSaimuHensaiGaku5 += detail.getLeaseSaimuHensaiGaku();
				mikeikaKimatuZan5 += detail.getMikeikaKimatuZan();
				mikeikaKimatuZan1Nai5 += detail.getMikeikaKimatuZan1Nai();
				mikeikaKimatuZan1Cyo5 += detail.getMikeikaKimatuZan1Cyo();

				leaseSougaku4 += detail.getLeaseSougaku();
				syutokuKakakuSoutou4 += detail.getSyutokuKakakuSoutou();
				ijikanriHi4 += detail.getIjikanriHi();
				ekmteikHi4 += detail.getEkmTeik();
				zanHosyou4 += detail.getZanHosyou();
				toukSiharaiLeaseRyou4 += detail.getToukSiharaiLeaseRyou();
				toukiIjiKanriHi4 += detail.getToukiIjiKanriHi();
				toukiekmteikHi4 += detail.getToukiEkmTeik();
				siharaiRisoku4 += detail.getSiharaiRisoku();
				leaseSaimuHensaiGaku4 += detail.getLeaseSaimuHensaiGaku();
				mikeikaKimatuZan4 += detail.getMikeikaKimatuZan();
				mikeikaKimatuZan1Nai4 += detail.getMikeikaKimatuZan1Nai();
				mikeikaKimatuZan1Cyo4 += detail.getMikeikaKimatuZan1Cyo();

				leaseSougaku3 += detail.getLeaseSougaku();
				syutokuKakakuSoutou3 += detail.getSyutokuKakakuSoutou();
				ijikanriHi3 += detail.getIjikanriHi();
				ekmteikHi3 += detail.getEkmTeik();
				zanHosyou3 += detail.getZanHosyou();
				toukSiharaiLeaseRyou3 += detail.getToukSiharaiLeaseRyou();
				toukiIjiKanriHi3 += detail.getToukiIjiKanriHi();
				toukiekmteikHi3 += detail.getToukiEkmTeik();
				siharaiRisoku3 += detail.getSiharaiRisoku();
				leaseSaimuHensaiGaku3 += detail.getLeaseSaimuHensaiGaku();
				mikeikaKimatuZan3 += detail.getMikeikaKimatuZan();
				mikeikaKimatuZan1Nai3 += detail.getMikeikaKimatuZan1Nai();
				mikeikaKimatuZan1Cyo3 += detail.getMikeikaKimatuZan1Cyo();

				leaseSougaku2 += detail.getLeaseSougaku();
				syutokuKakakuSoutou2 += detail.getSyutokuKakakuSoutou();
				ijikanriHi2 += detail.getIjikanriHi();
				ekmteikHi2 += detail.getEkmTeik();
				zanHosyou2 += detail.getZanHosyou();
				toukSiharaiLeaseRyou2 += detail.getToukSiharaiLeaseRyou();
				toukiIjiKanriHi2 += detail.getToukiIjiKanriHi();
				toukiekmteikHi2 += detail.getToukiEkmTeik();
				siharaiRisoku2 += detail.getSiharaiRisoku();
				leaseSaimuHensaiGaku2 += detail.getLeaseSaimuHensaiGaku();
				mikeikaKimatuZan2 += detail.getMikeikaKimatuZan();
				mikeikaKimatuZan1Nai2 += detail.getMikeikaKimatuZan1Nai();
				mikeikaKimatuZan1Cyo2 += detail.getMikeikaKimatuZan1Cyo();

				leaseSougaku1 += detail.getLeaseSougaku();
				syutokuKakakuSoutou1 += detail.getSyutokuKakakuSoutou();
				ijikanriHi1 += detail.getIjikanriHi();
				ekmteikHi1 += detail.getEkmTeik();
				zanHosyou1 += detail.getZanHosyou();
				toukSiharaiLeaseRyou1 += detail.getToukSiharaiLeaseRyou();
				toukiIjiKanriHi1 += detail.getToukiIjiKanriHi();
				toukiekmteikHi1 += detail.getToukiEkmTeik();
				siharaiRisoku1 += detail.getSiharaiRisoku();
				leaseSaimuHensaiGaku1 += detail.getLeaseSaimuHensaiGaku();
				mikeikaKimatuZan1 += detail.getMikeikaKimatuZan();
				mikeikaKimatuZan1Nai1 += detail.getMikeikaKimatuZan1Nai();
				mikeikaKimatuZan1Cyo1 += detail.getMikeikaKimatuZan1Cyo();

				// 2020/05/22 ADD START
				leaseSougaku0_1 += detail.getLeaseSougaku();
				syutokuKakakuSoutou0_1 += detail.getSyutokuKakakuSoutou();
				ijikanriHi0_1 += detail.getIjikanriHi();
				ekmteikHi0_1 += detail.getEkmTeik();
				zanHosyou0_1 += detail.getZanHosyou();
				toukSiharaiLeaseRyou0_1 += detail.getToukSiharaiLeaseRyou();
				toukiIjiKanriHi0_1 += detail.getToukiIjiKanriHi();
				toukiekmteikHi0_1 += detail.getToukiEkmTeik();
				siharaiRisoku0_1 += detail.getSiharaiRisoku();
				leaseSaimuHensaiGaku0_1 += detail.getLeaseSaimuHensaiGaku();
				mikeikaKimatuZan0_1 += detail.getMikeikaKimatuZan();
				mikeikaKimatuZan1Nai0_1 += detail.getMikeikaKimatuZan1Nai();
				mikeikaKimatuZan1Cyo0_1 += detail.getMikeikaKimatuZan1Cyo();
				// 2020/05/22 ADD END
				
				leaseSougaku0 += detail.getLeaseSougaku();
				syutokuKakakuSoutou0 += detail.getSyutokuKakakuSoutou();
				ekmteikHi0 += detail.getEkmTeik();
				ijikanriHi0 += detail.getIjikanriHi();
				zanHosyou0 += detail.getZanHosyou();
				toukSiharaiLeaseRyou0 += detail.getToukSiharaiLeaseRyou();
				toukiIjiKanriHi0 += detail.getToukiIjiKanriHi();
				toukiekmteikHi0 += detail.getToukiEkmTeik();
				siharaiRisoku0 += detail.getSiharaiRisoku();
				leaseSaimuHensaiGaku0 += detail.getLeaseSaimuHensaiGaku();
				mikeikaKimatuZan0 += detail.getMikeikaKimatuZan();
				mikeikaKimatuZan1Nai0 += detail.getMikeikaKimatuZan1Nai();
				mikeikaKimatuZan1Cyo0 += detail.getMikeikaKimatuZan1Cyo();

				leaseSougaku += detail.getLeaseSougaku();
				syutokuKakakuSoutou += detail.getSyutokuKakakuSoutou();
				ijikanriHi += detail.getIjikanriHi();
				ekmteikHi += detail.getEkmTeik();
				zanHosyou += detail.getZanHosyou();
				toukSiharaiLeaseRyou += detail.getToukSiharaiLeaseRyou();
				toukiIjiKanriHi += detail.getToukiIjiKanriHi();
				toukiekmteikHi += detail.getToukiEkmTeik();
				siharaiRisoku += detail.getSiharaiRisoku();
				leaseSaimuHensaiGaku += detail.getLeaseSaimuHensaiGaku();
				mikeikaKimatuZan += detail.getMikeikaKimatuZan();
				mikeikaKimatuZan1Nai += detail.getMikeikaKimatuZan1Nai();
				mikeikaKimatuZan1Cyo += detail.getMikeikaKimatuZan1Cyo();

				lineCount++;
			}

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			keisanKijunPrint(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			rskKeijHohoKbnPrint(piReportBean);

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

			// 2020/05/22 ADD START LACS帳票バッチ出力
			//report.close();
			//report = null;
			// 2020/05/22 ADD END   LACS帳票バッチ出力

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

		field = report.getField("xDate");
		report.putFieldData(field, super.convertReki(Convert.toString(new Date()), piDateMode));

		field = report.getField("xTitle");
		report.putFieldData(field, super.acStd.equals(LACSDefine.AccountStandard.NEW_1) ? TITLE_NEW : TITLE_OLD);

		field = report.getField("xLeasCompanyTitle");
		report.putFieldData(field, TITLE_COMP);

		field = report.getField("xLeasUserTitle");
		report.putFieldData(field, TITLE_USER);

		field = report.getField("xLeasCompanyTitle_D");
		report.putFieldData(field, " ");

		field = report.getField("xEkimuTitle");
		report.putFieldData(field, "役務提供費相当額");

		field = report.getField("xEkimuTitle2");
		report.putFieldData(field, "当期役務提供費");

		field = report.getField("xZanHosyouTitle");

		report.putFieldData(field, "うち残価保証額");

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

		field = report.getField("xRisokuBunpaiHouhou");
		report.putFieldData(field, detail.getRisokuBunpaiHouhou());

		field = report.getField("xToukiReaseRyouKeisanKijyun");
		report.putFieldData(field, detail.getToukiReaseRyouKeisanKijyun());

		field = report.getField("xMikeikaReaseRyouKeisanKijyun");
		report.putFieldData(field, detail.getMikeikaReaseRyouKeisanKijyun());

		field = report.getField("xComment");
		report.putFieldData(field, COMMENT);

		field = report.getField("xKaiFunoTitle");
		report.putFieldData(field, "");
		if (commonBean.isShowKaiKnoOpt() && piReportBean.getkaiknoTermkei().equals("0") && LACSDefine.TorihikiHanteiKekkaKbn.OPERATING_LEAS_3.equals(detail.getBrakeKey1().substring(10, 11))) {
			field = report.getField("xKaiFunoTitle");
			report.putFieldData(field, "(解約不能)");
		}
		// 2020/05/22 ADD START
		field = report.getField("xJysiUm");
		report.putFieldData(field, detail.getJysiUm());
		// 2020/05/22 ADD END
	}

	private void koteiSisanGokeiPrint(LACSReportBean piReportBean) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xKeisanRisiRitu" + index);
		report.putFieldData(field, "固定資産科目計");

		field = report.getField("xLeaseSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseSougaku3));

		field = report.getField("xSyutokuKakakuSoutou" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakakuSoutou3));

		field = report.getField("xIjikanriHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijikanriHi3));

		field = report.getField("xEkimuHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekmteikHi3));

		field = report.getField("xZanHosyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(zanHosyou3));

		field = report.getField("xToukSiharaiLeaseRyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukSiharaiLeaseRyou3));

		field = report.getField("xToukiIjiKanriHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiIjiKanriHi3));

		field = report.getField("xToukiEkimuHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiekmteikHi3));

		field = report.getField("xSiharaiRisoku" + index);
		report.putFieldData(field, StringUtl.formatNumber(siharaiRisoku3));

		field = report.getField("xLeaseSaimuHensaiGaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseSaimuHensaiGaku3));

		field = report.getField("xMikeikaKimatuZan" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan3));

		field = report.getField("xMikeikaKimatuZan1Nai" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1Nai3));

		field = report.getField("xMikeikaKimatuZan1Cyo" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1Cyo3));

		lineCount++;
	}

	private void keisanKijunPrint(LACSReportBean piReportBean) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xKeisanRisiRitu" + index);
		report.putFieldData(field, "リース料計算基準計");

		field = report.getField("xLeaseSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseSougaku5));

		field = report.getField("xSyutokuKakakuSoutou" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakakuSoutou5));

		field = report.getField("xIjikanriHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijikanriHi5));

		field = report.getField("xEkimuHi" + index);

		report.putFieldData(field, StringUtl.formatNumber(ekmteikHi5));

		field = report.getField("xZanHosyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(zanHosyou5));

		field = report.getField("xToukSiharaiLeaseRyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukSiharaiLeaseRyou5));

		field = report.getField("xToukiIjiKanriHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiIjiKanriHi5));

		field = report.getField("xToukiEkimuHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiekmteikHi5));

		field = report.getField("xSiharaiRisoku" + index);
		report.putFieldData(field, StringUtl.formatNumber(siharaiRisoku5));

		field = report.getField("xLeaseSaimuHensaiGaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseSaimuHensaiGaku5));

		field = report.getField("xMikeikaKimatuZan" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan5));

		field = report.getField("xMikeikaKimatuZan1Nai" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1Nai5));

		field = report.getField("xMikeikaKimatuZan1Cyo" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1Cyo5));

		lineCount++;
	}

	private void rskKeijHohoKbnPrint(LACSReportBean piReportBean) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xKeisanRisiRitu" + index);
		report.putFieldData(field, "利息相当額配分方法計");

		field = report.getField("xLeaseSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseSougaku4));

		field = report.getField("xSyutokuKakakuSoutou" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakakuSoutou4));

		field = report.getField("xIjikanriHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijikanriHi4));

		field = report.getField("xEkimuHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekmteikHi4));

		field = report.getField("xZanHosyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(zanHosyou4));

		field = report.getField("xToukSiharaiLeaseRyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukSiharaiLeaseRyou4));

		field = report.getField("xToukiIjiKanriHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiIjiKanriHi4));

		field = report.getField("xToukiEkimuHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiekmteikHi4));

		field = report.getField("xSiharaiRisoku" + index);
		report.putFieldData(field, StringUtl.formatNumber(siharaiRisoku4));

		field = report.getField("xLeaseSaimuHensaiGaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseSaimuHensaiGaku4));

		field = report.getField("xMikeikaKimatuZan" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan4));

		field = report.getField("xMikeikaKimatuZan1Nai" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1Nai4));

		field = report.getField("xMikeikaKimatuZan1Cyo" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1Cyo4));

		lineCount++;
	}

	private void kaikeiSyoriPrint(LACSReportBean piReportBean) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xKeisanRisiRitu" + index);
		report.putFieldData(field, "会計処理方法計");

		field = report.getField("xLeaseSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseSougaku2));

		field = report.getField("xSyutokuKakakuSoutou" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakakuSoutou2));

		field = report.getField("xIjikanriHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijikanriHi2));

		field = report.getField("xEkimuHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekmteikHi2));

		field = report.getField("xZanHosyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(zanHosyou2));

		field = report.getField("xToukSiharaiLeaseRyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukSiharaiLeaseRyou2));

		field = report.getField("xToukiIjiKanriHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiIjiKanriHi2));

		field = report.getField("xToukiEkimuHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiekmteikHi2));

		field = report.getField("xSiharaiRisoku" + index);
		report.putFieldData(field, StringUtl.formatNumber(siharaiRisoku2));

		field = report.getField("xLeaseSaimuHensaiGaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseSaimuHensaiGaku2));

		field = report.getField("xMikeikaKimatuZan" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan2));

		field = report.getField("xMikeikaKimatuZan1Nai" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1Nai2));

		field = report.getField("xMikeikaKimatuZan1Cyo" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1Cyo2));

		lineCount++;
	}

	private void leaseBunruiGokeiPrint(LACSReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xKeisanRisiRitu" + index);
		report.putFieldData(field, "リース取引分類計");

		field = report.getField("xLeaseSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseSougaku1));

		field = report.getField("xSyutokuKakakuSoutou" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakakuSoutou1));

		field = report.getField("xIjikanriHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijikanriHi1));

		field = report.getField("xEkimuHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekmteikHi1));

		field = report.getField("xZanHosyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(zanHosyou1));

		field = report.getField("xToukSiharaiLeaseRyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukSiharaiLeaseRyou1));

		field = report.getField("xToukiIjiKanriHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiIjiKanriHi1));

		field = report.getField("xToukiEkimuHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiekmteikHi1));

		field = report.getField("xSiharaiRisoku" + index);
		report.putFieldData(field, StringUtl.formatNumber(siharaiRisoku1));

		field = report.getField("xLeaseSaimuHensaiGaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseSaimuHensaiGaku1));

		field = report.getField("xMikeikaKimatuZan" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1));

		field = report.getField("xMikeikaKimatuZan1Nai" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1Nai1));

		field = report.getField("xMikeikaKimatuZan1Cyo" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1Cyo1));

		lineCount++;
	}

	// 2020/05/22 ADD START
	private void JysiUmGokeiPrint(LACSReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xKeisanRisiRitu" + index);
		report.putFieldData(field, "重要性有無計");

		field = report.getField("xLeaseSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseSougaku0_1));

		field = report.getField("xSyutokuKakakuSoutou" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakakuSoutou0_1));

		field = report.getField("xIjikanriHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijikanriHi0_1));

		field = report.getField("xEkimuHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekmteikHi0_1));

		field = report.getField("xZanHosyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(zanHosyou0_1));

		field = report.getField("xToukSiharaiLeaseRyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukSiharaiLeaseRyou0_1));

		field = report.getField("xToukiIjiKanriHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiIjiKanriHi0_1));

		field = report.getField("xToukiEkimuHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiekmteikHi0_1));

		field = report.getField("xSiharaiRisoku" + index);
		report.putFieldData(field, StringUtl.formatNumber(siharaiRisoku0_1));

		field = report.getField("xLeaseSaimuHensaiGaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseSaimuHensaiGaku0_1));

		field = report.getField("xMikeikaKimatuZan" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan0_1));

		field = report.getField("xMikeikaKimatuZan1Nai" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1Nai0_1));

		field = report.getField("xMikeikaKimatuZan1Cyo" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1Cyo0_1));

		lineCount++;
	}
	// 2020/05/22 ADD END

	private void leaseCompanyGokeiPrint(LACSReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xKeisanRisiRitu" + index);
		report.putFieldData(field, "リース会社計");

		field = report.getField("xLeaseSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseSougaku0));

		field = report.getField("xSyutokuKakakuSoutou" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakakuSoutou0));

		field = report.getField("xIjikanriHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijikanriHi0));

		field = report.getField("xEkimuHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekmteikHi0));

		field = report.getField("xZanHosyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(zanHosyou0));

		field = report.getField("xToukSiharaiLeaseRyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukSiharaiLeaseRyou0));

		field = report.getField("xToukiIjiKanriHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiIjiKanriHi0));

		field = report.getField("xToukiEkimuHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiekmteikHi0));

		field = report.getField("xSiharaiRisoku" + index);
		report.putFieldData(field, StringUtl.formatNumber(siharaiRisoku0));

		field = report.getField("xLeaseSaimuHensaiGaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseSaimuHensaiGaku0));

		field = report.getField("xMikeikaKimatuZan" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan0));

		field = report.getField("xMikeikaKimatuZan1Nai" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1Nai0));

		field = report.getField("xMikeikaKimatuZan1Cyo" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1Cyo0));

		lineCount++;
	}

	private void souGokeiPrint(LACSReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xKeisanRisiRitu" + index);
		report.putFieldData(field, "総　合　計");

		field = report.getField("xLeaseSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseSougaku));

		field = report.getField("xSyutokuKakakuSoutou" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuKakakuSoutou));

		field = report.getField("xIjikanriHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijikanriHi));

		field = report.getField("xEkimuHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekmteikHi));

		field = report.getField("xZanHosyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(zanHosyou));

		field = report.getField("xToukSiharaiLeaseRyou" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukSiharaiLeaseRyou));

		field = report.getField("xToukiIjiKanriHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiIjiKanriHi));

		field = report.getField("xToukiEkimuHi" + index);
		report.putFieldData(field, StringUtl.formatNumber(toukiekmteikHi));

		field = report.getField("xSiharaiRisoku" + index);
		report.putFieldData(field, StringUtl.formatNumber(siharaiRisoku));

		field = report.getField("xLeaseSaimuHensaiGaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leaseSaimuHensaiGaku));

		field = report.getField("xMikeikaKimatuZan" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan));

		field = report.getField("xMikeikaKimatuZan1Nai" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1Nai));

		field = report.getField("xMikeikaKimatuZan1Cyo" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaKimatuZan1Cyo));

		lineCount++;
	}
}
