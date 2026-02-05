package jp.co.pro_app.lacs.affairs.ukebarai.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiDetailBean;
import jp.co.pro_app.lacs.affairs.ukebarai.common.LACSUkebaraiCommon;
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
 * @version 20080812
 */
public class LACSUkebaraiPDFGokeiWriter extends LACSUkebaraiPDFWriterBase {

	//ADD Liu.ZJ LACS帳票バッチ対応 2013/04/11 start
	FileOutputStream fout = null; // 出力ファイルストリーム
	
	Report report = null; // WebKCoreレポートオブジェクト
	
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
		tmpFile = File.createTempFile("pdf21_", ".pdf", scratchDirectory);
		fout = new FileOutputStream(tmpFile);
		File formFile = new File(formDirectory, "UkebaraiAll.pdf");
		File datFile = new File(formDirectory, "UkebaraiAll.dat");
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
	//ADD Liu.ZJ LACS帳票バッチ対応 2013/04/11 end
		
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
	public LACSUkebaraiPDFGokeiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
	}

	/**
	 * PDF作成.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
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

		//DELETE Liu.ZJ LACS帳票バッチ対応 2013/04/11 start
		//File tmpFile = null; // 出力先ファイル
		//FileOutputStream fout = null; // 出力ファイルストリーム
		//DELETE Liu.ZJ LACS帳票バッチ対応 2013/04/11 end
		int pno = 0;
		int sopno = 0;
		//DELETE Liu.ZJ LACS帳票バッチ対応 2013/04/11 start
		//Report report = null;
		//DELETE Liu.ZJ LACS帳票バッチ対応 2013/04/11 end

		try {

			//MODIFY Liu.ZJ LACS帳票バッチ対応 2013/04/11 start
			//tmpFile = File.createTempFile("pdf21_", ".pdf", scratchDirectory);
			//fout = new FileOutputStream(tmpFile);
			//File formFile = new File(formDirectory, "UkebaraiAll.pdf");
			//File datFile = new File(formDirectory, "UkebaraiAll.dat");
			//report = new Report(formFile, datFile, fout);
			if(!batchFlg){
				tmpFile = File.createTempFile("pdf21_", ".pdf", scratchDirectory);
				fout = new FileOutputStream(tmpFile);
				File formFile = new File(formDirectory, "UkebaraiAll.pdf");
				File datFile = new File(formDirectory, "UkebaraiAll.dat");
				report = new Report(formFile, datFile, fout);
				
			}
			//MODIFY Liu.ZJ LACS帳票バッチ対応 2013/04/11 end
			
			//ADD ren.SL LACS帳票バッチ対応 2013/04/11 start
			if (batchFlg && !batchStartFlg) {
				this.startReport(piContext);
				batchStartFlg = true;
			}
			//ADD ren.SL LACS帳票バッチ対応 2013/04/11 end
			
			String dateMode = super.getSeirekiWarekiCode(commonBean.getCompanyCode(), piUkebaraiBean.getLeasCompany().getValue());

			Field field = null;

			// 2020/05/22 REP START
//			if ("0".equals(piUkebaraiBean.getOldBaibaiItenFlg())) {
//				sopno = sopno + 1;
//			}
//			if ("0".equals(piUkebaraiBean.getOldBaibaiItengaiFlg())) {
//				sopno = sopno + 1;
//			}
//			if ("0".equals(piUkebaraiBean.getOldTintaiItenFlg())) {
//				sopno = sopno + 1;
//			}
//			if ("0".equals(piUkebaraiBean.getOldTintaiItengaiFlg())) {
//				sopno = sopno + 1;
//			}
//			if ("0".equals(piUkebaraiBean.getOldOperateFlg())) {
//				sopno = sopno + 1;
//			}
//			if ("0".equals(piUkebaraiBean.getNewBaibaiItenFlg())) {
//				sopno = sopno + 1;
//			}
//			if ("0".equals(piUkebaraiBean.getNewBaibaiItengaiFlg())) {
//				sopno = sopno + 1;
//			}
//			if ("0".equals(piUkebaraiBean.getNewTintaiItenFlg())) {
//				sopno = sopno + 1;
//			}
//			if ("0".equals(piUkebaraiBean.getNewTintaiItengaiFlg())) {
//				sopno = sopno + 1;
//			}
//			if ("0".equals(piUkebaraiBean.getNewOperateFlg())) {
//				sopno = sopno + 1;
//			}
			//
			if ("0".equals(piUkebaraiBean.getJyNOldBaibaiItenFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyNOldBaibaiItengaiFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyNOldTintaiItenFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyNOldTintaiItengaiFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyNOldOperateFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyNNewBaibaiItenFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyNNewBaibaiItengaiFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyNNewTintaiItenFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyNNewTintaiItengaiFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyNNewOperateFlg())) {
				sopno = sopno + 1;
			}
			//
			if ("0".equals(piUkebaraiBean.getJyAOldBaibaiItenFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyAOldBaibaiItengaiFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyAOldTintaiItenFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyAOldTintaiItengaiFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyAOldOperateFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyANewBaibaiItenFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyANewBaibaiItengaiFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyANewTintaiItenFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyANewTintaiItengaiFlg())) {
				sopno = sopno + 1;
			}
			if ("0".equals(piUkebaraiBean.getJyANewOperateFlg())) {
				sopno = sopno + 1;
			}
			// 2020/05/22 REP END
			
			//ADD ren.SL LACS帳票バッチ対応 2013/04/11 start
			batchPrintedPage = sopno;
			//ADD ren.SL LACS帳票バッチ対応 2013/04/11 end
			
			// 2020/05/22 REP START
//			if ("0".equals(piUkebaraiBean.getOldBaibaiItenFlg())) {
//				report.createPage(1);
//				pno = pno + 1;
//				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "旧リース会計基準", "売買処理", "所有権移転ファイナンスリース");
//				setListDetail(piUkebaraiBean.getOldBaibaiItenList(), 0, LACSUkebaraiCommon.PL_LIST_COUNT, report, field);
//			}
//			if ("0".equals(piUkebaraiBean.getOldTintaiItenFlg())) {
//				report.createPage(3);
//				pno = pno + 1;
//				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "旧リース会計基準", "賃貸借処理", "所有権移転ファイナンスリース");
//				setListDetailTintaiFL(piUkebaraiBean.getOldTintaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
//			}
//			if ("0".equals(piUkebaraiBean.getOldBaibaiItengaiFlg())) {
//				report.createPage(1);
//				pno = pno + 1;
//				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "旧リース会計基準", "売買処理", "所有権移転外ファイナンスリース");
//				setListDetail(piUkebaraiBean.getOldBaibaiItengaiList(), 0, LACSUkebaraiCommon.PL_LIST_COUNT, report, field);
//			}
//			if ("0".equals(piUkebaraiBean.getOldTintaiItengaiFlg())) {
//				report.createPage(3);
//				pno = pno + 1;
//				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "旧リース会計基準", "賃貸借処理", "所有権移転外ファイナンスリース");
//				setListDetailTintaiFL(piUkebaraiBean.getOldTintaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
//			}
//			if ("0".equals(piUkebaraiBean.getOldOperateFlg())) {
//				report.createPage(2);
//				pno = pno + 1;
//				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "旧リース会計基準", "賃貸借処理", "オペレーティングリース");
//				setListDetail(piUkebaraiBean.getOldOperateList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
//			}
//			if ("0".equals(piUkebaraiBean.getNewBaibaiItenFlg())) {
//				report.createPage(1);
//				pno = pno + 1;
//				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "新リース会計基準", "売買処理", "所有権移転ファイナンスリース");
//				setListDetail(piUkebaraiBean.getNewBaibaiItenList(), 0, LACSUkebaraiCommon.PL_LIST_COUNT, report, field);
//			}
//			if ("0".equals(piUkebaraiBean.getNewTintaiItenFlg())) {
//				report.createPage(3);
//				pno = pno + 1;
//				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "新リース会計基準", "賃貸借処理", "所有権移転ファイナンスリース");
//				setListDetailTintaiFL(piUkebaraiBean.getNewTintaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
//			}
//			if ("0".equals(piUkebaraiBean.getNewBaibaiItengaiFlg())) {
//				report.createPage(1);
//				pno = pno + 1;
//				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "新リース会計基準", "売買処理", "所有権移転外ファイナンスリース");
//				setListDetail(piUkebaraiBean.getNewBaibaiItengaiList(), 0, LACSUkebaraiCommon.PL_LIST_COUNT, report, field);
//			}
//			if ("0".equals(piUkebaraiBean.getNewTintaiItengaiFlg())) {
//				report.createPage(3);
//				pno = pno + 1;
//				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "新リース会計基準", "賃貸借処理", "所有権移転外ファイナンスリース");
//				setListDetailTintaiFL(piUkebaraiBean.getNewTintaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
//			}
//			if ("0".equals(piUkebaraiBean.getNewOperateFlg())) {
//				report.createPage(2);
//				pno = pno + 1;
//				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "新リース会計基準", "賃貸借処理", "オペレーティングリース");
//				setListDetail(piUkebaraiBean.getNewOperateList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
//			}
			//
			/* 重要性無 */
			if ("0".equals(piUkebaraiBean.getJyNOldBaibaiItenFlg())) {
				report.createPage(1);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "旧リース会計基準", "売買処理", "所有権移転ファイナンスリース", "なし");
				setListDetail(piUkebaraiBean.getJyNOldBaibaiItenList(), 0, LACSUkebaraiCommon.PL_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyNOldTintaiItenFlg())) {
				report.createPage(3);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "旧リース会計基準", "賃貸借処理", "所有権移転ファイナンスリース", "なし");
				setListDetailTintaiFL(piUkebaraiBean.getJyNOldTintaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyNOldBaibaiItengaiFlg())) {
				report.createPage(1);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "旧リース会計基準", "売買処理", "所有権移転外ファイナンスリース", "なし");
				setListDetail(piUkebaraiBean.getJyNOldBaibaiItengaiList(), 0, LACSUkebaraiCommon.PL_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyNOldTintaiItengaiFlg())) {
				report.createPage(3);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "旧リース会計基準", "賃貸借処理", "所有権移転外ファイナンスリース", "なし");
				setListDetailTintaiFL(piUkebaraiBean.getJyNOldTintaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyNOldOperateFlg())) {
				report.createPage(2);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "旧リース会計基準", "賃貸借処理", "オペレーティングリース", "なし");
				setListDetail(piUkebaraiBean.getJyNOldOperateList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyNNewBaibaiItenFlg())) {
				report.createPage(1);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "新リース会計基準", "売買処理", "所有権移転ファイナンスリース", "なし");
				setListDetail(piUkebaraiBean.getJyNNewBaibaiItenList(), 0, LACSUkebaraiCommon.PL_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyNNewTintaiItenFlg())) {
				report.createPage(3);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "新リース会計基準", "賃貸借処理", "所有権移転ファイナンスリース", "なし");
				setListDetailTintaiFL(piUkebaraiBean.getJyNNewTintaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyNNewBaibaiItengaiFlg())) {
				report.createPage(1);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "新リース会計基準", "売買処理", "所有権移転外ファイナンスリース", "なし");
				setListDetail(piUkebaraiBean.getJyNNewBaibaiItengaiList(), 0, LACSUkebaraiCommon.PL_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyNNewTintaiItengaiFlg())) {
				report.createPage(3);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "新リース会計基準", "賃貸借処理", "所有権移転外ファイナンスリース", "なし");
				setListDetailTintaiFL(piUkebaraiBean.getJyNNewTintaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyNNewOperateFlg())) {
				report.createPage(2);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "新リース会計基準", "賃貸借処理", "オペレーティングリース", "なし");
				setListDetail(piUkebaraiBean.getJyNNewOperateList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
			}
			//
			/* 重要性有 */
			if ("0".equals(piUkebaraiBean.getJyAOldBaibaiItenFlg())) {
				report.createPage(1);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "旧リース会計基準", "売買処理", "所有権移転ファイナンスリース", "あり");
				setListDetail(piUkebaraiBean.getJyAOldBaibaiItenList(), 0, LACSUkebaraiCommon.PL_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyAOldTintaiItenFlg())) {
				report.createPage(3);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "旧リース会計基準", "賃貸借処理", "所有権移転ファイナンスリース", "あり");
				setListDetailTintaiFL(piUkebaraiBean.getJyAOldTintaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyAOldBaibaiItengaiFlg())) {
				report.createPage(1);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "旧リース会計基準", "売買処理", "所有権移転外ファイナンスリース", "あり");
				setListDetail(piUkebaraiBean.getJyAOldBaibaiItengaiList(), 0, LACSUkebaraiCommon.PL_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyAOldTintaiItengaiFlg())) {
				report.createPage(3);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "旧リース会計基準", "賃貸借処理", "所有権移転外ファイナンスリース", "あり");
				setListDetailTintaiFL(piUkebaraiBean.getJyAOldTintaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyAOldOperateFlg())) {
				report.createPage(2);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "旧リース会計基準", "賃貸借処理", "オペレーティングリース", "あり");
				setListDetail(piUkebaraiBean.getJyAOldOperateList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyANewBaibaiItenFlg())) {
				report.createPage(1);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "新リース会計基準", "売買処理", "所有権移転ファイナンスリース", "あり");
				setListDetail(piUkebaraiBean.getJyANewBaibaiItenList(), 0, LACSUkebaraiCommon.PL_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyANewTintaiItenFlg())) {
				report.createPage(3);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "新リース会計基準", "賃貸借処理", "所有権移転ファイナンスリース", "あり");
				setListDetailTintaiFL(piUkebaraiBean.getJyANewTintaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyANewBaibaiItengaiFlg())) {
				report.createPage(1);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "新リース会計基準", "売買処理", "所有権移転外ファイナンスリース", "あり");
				setListDetail(piUkebaraiBean.getJyANewBaibaiItengaiList(), 0, LACSUkebaraiCommon.PL_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyANewTintaiItengaiFlg())) {
				report.createPage(3);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "新リース会計基準", "賃貸借処理", "所有権移転外ファイナンスリース", "あり");
				setListDetailTintaiFL(piUkebaraiBean.getJyANewTintaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
			}
			if ("0".equals(piUkebaraiBean.getJyANewOperateFlg())) {
				report.createPage(2);
				pno = pno + 1;
				setHeaderData(report, field, pno, sopno, piUkebaraiBean, dateMode, "新リース会計基準", "賃貸借処理", "オペレーティングリース", "あり");
				setListDetail(piUkebaraiBean.getJyANewOperateList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, report, field);
			}
			// 2020/05/22 REP END

			return tmpFile.getName();

		}
		finally {
			//MODIFY Liu.ZJ LACS帳票バッチ対応 2013/04/11 start
			//if (report != null) {
			//	try {
			//		report.close();
			//	}
			//	catch (ReportException e) {
			//	}
			//	report = null;
			//}
			//if (fout != null) {
			//	try {
			//		fout.close();
			//	}
			//	catch (Exception e) {
			//		fout = null;
			//	}
			//}
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
			//MODIFY Liu.ZJ LACS帳票バッチ対応 2013/04/11 end
		}

	}

	/**
	 * ヘッダーにデータを設定する.
	 * 
	 * @param piReport
	 *            Report
	 * @param piField
	 *            Field
	 * @param piPageNo
	 *            ページ番号
	 * @param piSoPageNo
	 *            総ページ数
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @param piDateMode
	 *            西暦和暦出力モード
	 * @param piKijun
	 *            リース会計基準出力文言
	 * @param piHouhou
	 *            会計処理方法出力文言
	 * @param piBunrui
	 *            リース取引分類出力文言
	 * @throws Exception
	 *             処理例外
	 */
	// 2020/05/22 REP START
	//private void setHeaderData(Report piReport, Field piField, int piPageNo, int piSoPageNo, LACSUkebaraiBean piUkebaraiBean, String piDateMode, String piKijun, String piHouhou, String piBunrui) throws Exception {
	private void setHeaderData(Report piReport, Field piField, int piPageNo, int piSoPageNo, LACSUkebaraiBean piUkebaraiBean, String piDateMode, String piKijun, String piHouhou, String piBunrui, String piJysiUm) throws Exception {

	// 2020/05/22 REP END
		piField = piReport.getField("xLeaseCompanyNm");
		piReport.putFieldData(piField, piUkebaraiBean.getLcName());

		piField = piReport.getField("xKaijisaki");
		piReport.putFieldData(piField, piUkebaraiBean.getLeaseUserNm());

		piField = piReport.getField("xTermFrom");
		piReport.putFieldData(piField, super.convertRekiLong(Convert.toString(Convert.toDate(Convert.toDateString(piUkebaraiBean.getTermFrom().getYYYYMMDD()))), piDateMode));

		piField = piReport.getField("xTermTo");
		piReport.putFieldData(piField, super.convertRekiLong(Convert.toString(Convert.toDate(Convert.toDateString(piUkebaraiBean.getTermTo().getYYYYMMDD()))), piDateMode));

		String createDate = Convert.toString(new Date());
		piField = piReport.getField("xOutputDate");
		piReport.putFieldData(piField, super.convertReki(createDate, piDateMode));

		piField = piReport.getField("xLeaseKijun");
		piReport.putFieldData(piField, piKijun);

		piField = piReport.getField("xLeaseBunrui");
		piReport.putFieldData(piField, piBunrui);

		// 2020/05/22 ADD START
		piField = piReport.getField("xJysiUm");
		piReport.putFieldData(piField, piJysiUm);
		// 2020/05/22 ADD END

		piField = piReport.getField("xKaikeiHouhou");
		piReport.putFieldData(piField, piHouhou);
		String strPage = piPageNo + "/" + piSoPageNo;
		piField = piReport.getField("xPage");
		piReport.putFieldData(piField, strPage);

	}

	/**
	 * 明細行を出力する.
	 * 
	 * @param piDetailList
	 *            明細データ格納リスト
	 * @param piStartIdx
	 *            出力開始インデックス
	 * @param piBreakIdx
	 *            出力終了インデックス
	 * @param piReport
	 *            Report
	 * @param piField
	 *            Field
	 * @throws Exception
	 *             処理例外
	 */
	private void setListDetail(ArrayList<Object> piDetailList, int piStartIdx, int piBreakIdx, Report piReport, Field piField) throws Exception {
		// 2020/05/22 ADD TEST START
		System.out.println("** DETAIL ST **");
		System.out.println("setListDetail start");
		System.out.println("piStartIdx:" + piStartIdx);
		System.out.println("piBreakIdx:" + piBreakIdx);
		System.out.println("** DETAIL ED **");
		// 2020/05/22 ADD TEST END

		LACSUkebaraiDetailBean detail = null;
		for (int i = piStartIdx; i < piDetailList.size(); i++) {

			if (i == piBreakIdx) {
				break;
			}

			detail = (LACSUkebaraiDetailBean)piDetailList.get(i);

			piField = piReport.getField("xKamokuNm_" + String.valueOf(i + 1));
			piReport.putFieldData(piField, detail.getKamokuNm());

			if (detail.isZenFlag()) {
				piField = piReport.getField("xZen_" + String.valueOf(i + 1));
				piReport.putFieldData(piField, StringUtl.formatNumber(detail.getZenCost()));
			}

			if (detail.isTouzouFlag()) {
				piField = piReport.getField("xTouZou_" + String.valueOf(i + 1));
				piReport.putFieldData(piField, StringUtl.formatNumber(detail.getTouzouCost()));
			}

			if (detail.isToujitFlag()) {
				piField = piReport.getField("xTouJit_" + String.valueOf(i + 1));
				piReport.putFieldData(piField, StringUtl.formatNumber(detail.getToujitCost()));
			}

			if (detail.isTougenFlag()) {
				piField = piReport.getField("xTouGen_" + String.valueOf(i + 1));
				piReport.putFieldData(piField, StringUtl.formatNumber(detail.getTougenCost()));
			}

			if (detail.isTouzanFlag()) {
				piField = piReport.getField("xTouMatsu_" + String.valueOf(i + 1));
				piReport.putFieldData(piField, StringUtl.formatNumber(detail.getTouzanCost()));
			}
		}

	}

	/**
	 * 明細行を出力する.
	 * 
	 * @param piDetailList
	 *            明細データ格納リスト
	 * @param piStartIdx
	 *            出力開始インデックス1
	 * @param piBreakIdx
	 *            出力終了インデックス1
	 * @param piStartIdx2
	 *            出力開始インデックス2
	 * @param piBreakIdx2
	 *            出力終了インデックス2
	 * @param piReport
	 *            Report
	 * @param piField
	 *            Field
	 * @throws Exception
	 *             処理例外
	 */
	private void setListDetailTintaiFL(ArrayList<Object> piDetailList, int piStartIdx, int piBreakIdx, int piStartIdx2, int piBreakIdx2, Report piReport, Field piField) throws Exception {
		// 2020/05/22 ADD TEST START
		System.out.println("** DETAIL ST **");
		System.out.println("setListDetailTintaiFL start");
		System.out.println("** DETAIL ED **");
		// 2020/05/22 ADD TEST END

		LACSUkebaraiDetailBean detail = null;
		for (int i = piStartIdx; i < piDetailList.size(); i++) {

			if (i == piBreakIdx) {
				break;
			}

			detail = (LACSUkebaraiDetailBean)piDetailList.get(i);

			piField = piReport.getField("xKamokuNm_" + String.valueOf(i + 1));
			piReport.putFieldData(piField, detail.getKamokuNm());

			if (detail.isZenFlag()) {
				piField = piReport.getField("xZen_" + String.valueOf(i + 1));
				piReport.putFieldData(piField, StringUtl.formatNumber(detail.getZenCost()));
			}

			if (detail.isTouzouFlag()) {
				piField = piReport.getField("xTouZou_" + String.valueOf(i + 1));
				piReport.putFieldData(piField, StringUtl.formatNumber(detail.getTouzouCost()));
			}

			if (detail.isToujitFlag()) {
				piField = piReport.getField("xTouJit_" + String.valueOf(i + 1));
				piReport.putFieldData(piField, StringUtl.formatNumber(detail.getToujitCost()));
			}

			if (detail.isTougenFlag()) {
				piField = piReport.getField("xTouGen_" + String.valueOf(i + 1));
				piReport.putFieldData(piField, StringUtl.formatNumber(detail.getTougenCost()));
			}

			if (detail.isTouzanFlag()) {
				piField = piReport.getField("xTouMatsu_" + String.valueOf(i + 1));
				piReport.putFieldData(piField, StringUtl.formatNumber(detail.getTouzanCost()));
			}
		}

		detail = null;

		LACSUkebaraiDetailBean detail2 = null;
		for (int i = piStartIdx2; i < piDetailList.size(); i++) {

			if (i == piBreakIdx2) {
				break;
			}

			detail2 = (LACSUkebaraiDetailBean)piDetailList.get(i);

			piField = piReport.getField("xKamokuNm_" + String.valueOf(i + 1));
			piReport.putFieldData(piField, detail2.getKamokuNm());

			if (detail2.isZenFlag()) {
				piField = piReport.getField("xZen_" + String.valueOf(i + 1));
				piReport.putFieldData(piField, StringUtl.formatNumber(detail2.getZenCost()));
			}

			if (detail2.isTouzouFlag()) {
				piField = piReport.getField("xTouZou_" + String.valueOf(i + 1));
				piReport.putFieldData(piField, StringUtl.formatNumber(detail2.getTouzouCost()));
			}

			if (detail2.isToujitFlag()) {
				piField = piReport.getField("xTouJit_" + String.valueOf(i + 1));
				piReport.putFieldData(piField, StringUtl.formatNumber(detail2.getToujitCost()));
			}

			if (detail2.isTougenFlag()) {
				piField = piReport.getField("xTouGen_" + String.valueOf(i + 1));
				piReport.putFieldData(piField, StringUtl.formatNumber(detail2.getTougenCost()));
			}

			if (detail2.isTouzanFlag()) {
				piField = piReport.getField("xTouMatsu_" + String.valueOf(i + 1));
				piReport.putFieldData(piField, StringUtl.formatNumber(detail2.getTouzanCost()));
			}
		}

	}
}
