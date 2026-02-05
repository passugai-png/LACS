package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.csv.MakeCSVNODoubleQuotes;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
/**
 * CSV出力：帳票一括出力用CSV.（各帳票の出力ページ数を出力する）
 * 
 * @author Liu.ZJ
 * @version 2013/03/28
 */
public class LACSReportCSVPrintBatchWriter extends LACSReportCSVWriterBase{
	
	// CSV出力先
	protected static final String	SCRATCH_PATH	= "out_pdf";
	
	/**
	 * CSV作成.
	 * 
	 * @param batchCSVData
	 *			  CSV出力データ
	 * @param date
	 * 			  CSV出力ファイル名用日付（YYYYMM）
	 * @param piContext
	 * 			  ServletContext
	 * @return CSVファイル名
	 * @throws Exception
	 * 				  実行例外
	 */
	public String makeCsv(String[][] batchCSVData,String date, ServletContext piContext)throws Exception{
		
		// 出力CSVファイル名
		String fileName = "";	
		
		// 出力CSVヘーダー部作成
		// 2020/05/22 DEL START LACS帳票バッチ出力
//		String[] header = new String[]{ "部署コード"
//										, "部署名"
//										, "担当者コード"
//										, "担当者名"
//										, "開示先コード"
//										, "開示先名称"
//										, "宛名"
//										, "注記書類作成基準書"
//										, "リース契約注記合計表【旧】（当期分）"
//										, "リース契約注記合計表【旧】（通期分）"
//										, "リース契約注記合計表【新】（当期分）"
//										, "リース契約注記合計表【新】（通期分）"
//										, "受払合計表（当期分）"
//										, "受払合計表（通期分）"
//										, "リース会計基準明細書"};
		// 2020/05/22 DEL END   LACS帳票バッチ出力
		// 2020/05/22 ADD START LACS帳票バッチ出力
//		String[] header = new String[]{ "部署コード"
//				, "部署名"
//				, "担当者コード"
//				, "担当者名"
//				, "開示先コード"
//				, "開示先名称"
//				, "宛名"
//				, "注記書類作成基準書"
//				, "仕訳合計表（当期分）"
//				, "仕訳合計表（通期分）"
//				, "受払合計表（当期分）"
//				, "受払合計表（通期分）"
//				, "リース料受払明細表(当期分)"
//				, "リース料受払明細表(通期分)"
//				, "リース資産受払明細表(当期分)"
//				, "リース資産受払明細表(通期分)"
//				, "リース契約注記合計表【旧】（当期分）"
//				, "リース契約注記合計表【旧】（通期分）"
//				, "リース契約注記合計表【新】（当期分）"
//				, "リース契約注記合計表【新】（通期分）"
//				, "リース会計資料(支払リース料等)【旧】(当期分)"
//				, "リース会計資料(支払リース料等)【旧】(通期分)"
//				, "リース会計資料(支払リース料等)【新】(当期分)"
//				, "リース会計資料(支払リース料等)【新】(通期分)"
//				, "リース会計資料(減価償却費)【旧】(当期分)"
//				, "リース会計資料(減価償却費)【旧】(通期分)"
//				, "リース会計資料(減価償却費)【新】(当期分)"
//				, "リース会計資料(減価償却費)【新】(通期分)"
//				, "期日別予定表(合計表)【旧】(当期分)"
//				, "期日別予定表(合計表)【旧】(通期分)"
//				, "期日別予定表(合計表)【新】(当期分)"
//				, "期日別予定表(合計表)【新】(通期分)"
//				, "期日別予定表(債務)【旧】(当期分)"
//				, "期日別予定表(債務)【旧】(通期分)"
//				, "期日別予定表(債務)【新】(当期分)"
//				, "期日別予定表(債務)【新】(通期分)"
//				, "期日別予定表(資産)【旧】(当期分)"
//				, "期日別予定表(資産)【旧】(通期分)"
//				, "期日別予定表(資産)【新】(当期分)"
//				, "期日別予定表(資産)【新】(通期分)"};
		String[] header = new String[]{};
		// 2020/05/22 ADD END   LACS帳票バッチ出力
		//MakeCSVNODoubleQuotes makeCSV=new MakeCSVNODoubleQuotes(header);
		MakeCSVNODoubleQuotes makeCSV=new MakeCSVNODoubleQuotes(header);
		
		// 出力用データを設定する
		makeCSV.setValues(batchCSVData);
		
		// 出力先にCSVファイルを作成する
		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		// 2020/05/22 REP START LACS帳票バッチ出力
		//File tmpFile = new File(scratchDirectory+File.separator+"LIST_"+date+".csv"); 
		File tmpFile = new File(scratchDirectory+File.separator+"NAME_LIST.txt"); 
		// 2020/05/22 REP END   LACS帳票バッチ出力
		
		// CSVファイルを出力する
		makeCSV.write(tmpFile.getAbsolutePath());
		
		// CSVファイル名を取得する
		fileName = tmpFile.getName();
		
		// CSVファイル名を戻る
		return fileName;
	}

	/**
	 * CSV作成.
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
	@Override
	protected String makeCSV(LACSReportBean piReportBean, String piDateMode,
			ServletContext piContext) throws Exception {
		return null;
	}
	
	/**
	 * 
	 * @param piCommonBean
	 * 			  LACS用共通Bean
	 * @param piModel
	 * 			  LACSModelスーパークラス
	 * @param piCon
	 * 			  DB接続
	 */
	public LACSReportCSVPrintBatchWriter(LACSCommonBean piCommonBean,
			LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
	}

}
