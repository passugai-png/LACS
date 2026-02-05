package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportKizituSisanBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportKizituSisanEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

/**
 * 帳票出力：期日別予定表（資産）Model.
 * 
 * @author arai
 * @version 20200617
 */


public class LACSReportPDFKizitubetuSisanWriter extends LACSReportPDFWriterBase {

	private Report				        report					        = null;				     // WebKCoreレポートオブジェクト

	private LACSReportKizituSisanBean	detail					        = null;
	
	private int					        lineCount				        = 0;					// 明細カウンタ

	private String				        index					        = "";					// 明細行修飾子

	private int				            page					        = 0;					// ページ数
	
	private int				            souPage					        = 0;					// 総ページ数
	
	private int				            MAX_LINE					    = 5;					// 明細行数
	
	@SuppressWarnings("unused")
	private String                       syutokuOne1                 = "";                    // 取得価額(1年以内)

	@SuppressWarnings("unused")
	private String                       syutokuTwo1                 = "";                    // 取得価額(2年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuThree1               = "";                    // 取得価額(3年以内)
	
	@SuppressWarnings("unused")
    private String                       syutokuFour1                = "";                    // 取得価額(4年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuFive1                = "";                    // 取得価額(5年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuOverFive1            = "";                    // 取得価額(5年超)
	
	private long                       syutokuTotal1               = 0;                    // 取得価額(合計)

	@SuppressWarnings("unused")
	private String                       syutokuOne2                 = "";                    // 取得価額(1年以内)

	@SuppressWarnings("unused")
	private String                       syutokuTwo2                 = "";                    // 取得価額(2年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuThree2               = "";                    // 取得価額(3年以内)
	
	@SuppressWarnings("unused")
    private String                       syutokuFour2                = "";                    // 取得価額(4年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuFive2                = "";                    // 取得価額(5年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuOverFive2            = "";                    // 取得価額(5年超)
	
	private long                       syutokuTotal2               = 0;                    // 取得価額(合計)
	
	@SuppressWarnings("unused")
	private String                       syutokuOne3                 = "";                    // 取得価額(1年以内)

	@SuppressWarnings("unused")
	private String                       syutokuTwo3                 = "";                    // 取得価額(2年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuThree3               = "";                    // 取得価額(3年以内)
	
	@SuppressWarnings("unused")
    private String                       syutokuFour3                = "";                    // 取得価額(4年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuFive3                = "";                    // 取得価額(5年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuOverFive3            = "";                    // 取得価額(5年超)
	
	private long                       syutokuTotal3               = 0;                    // 取得価額(合計)
	
	@SuppressWarnings("unused")
	private String                       syutokuOne4                 = "";                    // 取得価額(1年以内)

	@SuppressWarnings("unused")
	private String                       syutokuTwo4                 = "";                    // 取得価額(2年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuThree4               = "";                    // 取得価額(3年以内)
	
	@SuppressWarnings("unused")
    private String                       syutokuFour4                = "";                    // 取得価額(4年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuFive4                = "";                    // 取得価額(5年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuOverFive4            = "";                    // 取得価額(5年超)
	
	private long                       syutokuTotal4               = 0;                    // 取得価額(合計)
	
	@SuppressWarnings("unused")
	private String                       syutokuOne5                 = "";                    // 取得価額(1年以内)

	@SuppressWarnings("unused")
	private String                       syutokuTwo5                 = "";                    // 取得価額(2年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuThree5               = "";                    // 取得価額(3年以内)
	
	@SuppressWarnings("unused")
    private String                       syutokuFour5                = "";                    // 取得価額(4年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuFive5                = "";                    // 取得価額(5年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuOverFive5            = "";                    // 取得価額(5年超)
	
	private long                       syutokuTotal5               = 0;                    // 取得価額(合計)
	
	@SuppressWarnings("unused")
	private String                       syutokuOne6                 = "";                    // 取得価額(1年以内)

	@SuppressWarnings("unused")
	private String                       syutokuTwo6                 = "";                    // 取得価額(2年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuThree6               = "";                    // 取得価額(6年以内)
	
	@SuppressWarnings("unused")
    private String                       syutokuFour6                = "";                    // 取得価額(4年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuFive6                = "";                    // 取得価額(5年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuOverFive6            = "";                    // 取得価額(5年超)
	
	private long                       syutokuTotal6               = 0;                    // 取得価額(合計)
	
	@SuppressWarnings("unused")
	private String                       syutokuOne                 = "";                    // 取得価額(1年以内)

	@SuppressWarnings("unused")
	private String                       syutokuTwo                 = "";                    // 取得価額(2年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuThree               = "";                    // 取得価額(年以内)
	
	@SuppressWarnings("unused")
    private String                       syutokuFour                = "";                    // 取得価額(4年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuFive                = "";                    // 取得価額(5年以内)
	
	@SuppressWarnings("unused")
	private String                       syutokuOverFive            = "";                    // 取得価額(5年超)
	
	private long                       syutokuTotal               = 0;                    // 取得価額(合計)

	@SuppressWarnings("unused")
	private String                       ruisyutokuOne1                 = "";                    // 減価償却累計額(1年以内)

	@SuppressWarnings("unused")
	private String                       ruisyutokuTwo1                 = "";                    // 減価償却累計額(2年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuThree1               = "";                    // 減価償却累計額(3年以内)
	
	@SuppressWarnings("unused")
    private String                       ruisyutokuFour1                = "";                    // 減価償却累計額(4年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuFive1                = "";                    // 減価償却累計額(5年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuOverFive1            = "";                    // 減価償却累計額(5年超)
	
	private long                       ruisyutokuTotal1               = 0;                    // 減価償却累計額(合計)

	@SuppressWarnings("unused")
	private String                       ruisyutokuOne2                 = "";                    // 減価償却累計額(1年以内)

	@SuppressWarnings("unused")
	private String                       ruisyutokuTwo2                 = "";                    // 減価償却累計額(2年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuThree2               = "";                    // 減価償却累計額(3年以内)
	
	@SuppressWarnings("unused")
    private String                       ruisyutokuFour2                = "";                    // 減価償却累計額(4年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuFive2                = "";                    // 減価償却累計額(5年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuOverFive2            = "";                    // 減価償却累計額(5年超)
	
	private long                       ruisyutokuTotal2               = 0;                    // 減価償却累計額(合計)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuOne3                 = "";                    // 減価償却累計額(1年以内)

	@SuppressWarnings("unused")
	private String                       ruisyutokuTwo3                 = "";                    // 減価償却累計額(2年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuThree3               = "";                    // 減価償却累計額(3年以内)
	
	@SuppressWarnings("unused")
    private String                       ruisyutokuFour3                = "";                    // 減価償却累計額(4年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuFive3                = "";                    // 減価償却累計額(5年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuOverFive3            = "";                    // 減価償却累計額(5年超)
	
	private long                       ruisyutokuTotal3               = 0;                    // 減価償却累計額(合計)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuOne4                 = "";                    // 減価償却累計額(1年以内)

	@SuppressWarnings("unused")
	private String                       ruisyutokuTwo4                 = "";                    // 減価償却累計額(2年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuThree4               = "";                    // 減価償却累計額(3年以内)
	
	@SuppressWarnings("unused")
    private String                       ruisyutokuFour4                = "";                    // 減価償却累計額(4年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuFive4                = "";                    // 減価償却累計額(5年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuOverFive4            = "";                    // 減価償却累計額(5年超)
	
	private long                       ruisyutokuTotal4               = 0;                    // 減価償却累計額(合計)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuOne5                 = "";                    // 減価償却累計額(1年以内)

	@SuppressWarnings("unused")
	private String                       ruisyutokuTwo5                 = "";                    // 減価償却累計額(2年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuThree5               = "";                    // 減価償却累計額(3年以内)
	
	@SuppressWarnings("unused")
    private String                       ruisyutokuFour5                = "";                    // 減価償却累計額(4年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuFive5                = "";                    // 減価償却累計額(5年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuOverFive5            = "";                    // 減価償却累計額(5年超)
	
	private long                       ruisyutokuTotal5               = 0;                    // 減価償却累計額(合計)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuOne6                 = "";                    // 減価償却累計額(1年以内)

	@SuppressWarnings("unused")
	private String                       ruisyutokuTwo6                 = "";                    // 減価償却累計額(2年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuThree6               = "";                    // 減価償却累計額(6年以内)
	
	@SuppressWarnings("unused")
    private String                       ruisyutokuFour6                = "";                    // 減価償却累計額(4年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuFive6                = "";                    // 減価償却累計額(5年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuOverFive6            = "";                    // 減価償却累計額(5年超)
	
	private long                       ruisyutokuTotal6               = 0;                    // 減価償却累計額(合計)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuOne                 = "";                    // 減価償却累計額(1年以内)

	@SuppressWarnings("unused")
	private String                       ruisyutokuTwo                 = "";                    // 減価償却累計額(2年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuThree               = "";                    // 減価償却累計額(年以内)
	
	@SuppressWarnings("unused")
    private String                       ruisyutokuFour                = "";                    // 減価償却累計額(4年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuFive                = "";                    // 減価償却累計額(5年以内)
	
	@SuppressWarnings("unused")
	private String                       ruisyutokuOverFive            = "";                    // 減価償却累計額(5年超)
	
	private long                       ruisyutokuTotal               = 0;                    // 減価償却累計額(合計)

	private long                       genkOne1                 = 0;                    // 減価償却費(1年以内)

	private long                       genkTwo1                 = 0;                    // 減価償却費(2年以内)
	
	private long                       genkThree1               = 0;                    // 減価償却費(3年以内)
	
    private long                       genkFour1                = 0;                    // 減価償却費(4年以内)
	
	private long                       genkFive1                = 0;                    // 減価償却費(5年以内)
	
	private long                       genkOverFive1            = 0;                    // 減価償却費(5年超)
	
	@SuppressWarnings("unused")
	private String                       genkTotal1               = "";                    // 減価償却費(合計)

	private long                       genkOne2                 = 0;                    // 減価償却費(1年以内)

	private long                       genkTwo2                 = 0;                    // 減価償却費(2年以内)
	
	private long                       genkThree2               = 0;                    // 減価償却費(3年以内)
	
    private long                       genkFour2                = 0;                    // 減価償却費(4年以内)
	
	private long                       genkFive2                = 0;                    // 減価償却費(5年以内)
	
	private long                       genkOverFive2            = 0;                    // 減価償却費(5年超)
	
	@SuppressWarnings("unused")
	private String                       genkTotal2               = "";                    // 減価償却費(合計)
	
	private long                       genkOne3                 = 0;                    // 減価償却費(1年以内)

	private long                       genkTwo3                 = 0;                    // 減価償却費(2年以内)
	
	private long                       genkThree3               = 0;                    // 減価償却費(3年以内)
	
    private long                       genkFour3                = 0;                    // 減価償却費(4年以内)
	
	private long                       genkFive3                = 0;                    // 減価償却費(5年以内)
	
	private long                       genkOverFive3            = 0;                    // 減価償却費(5年超)
	
	@SuppressWarnings("unused")
	private String                       genkTotal3               = "";                    // 減価償却費(合計)
	
	private long                       genkOne4                 = 0;                    // 減価償却費(1年以内)

	private long                       genkTwo4                 = 0;                    // 減価償却費(2年以内)
	
	private long                       genkThree4               = 0;                    // 減価償却費(3年以内)
	
    private long                       genkFour4                = 0;                    // 減価償却費(4年以内)
	
	private long                       genkFive4                = 0;                    // 減価償却費(5年以内)
	
	private long                       genkOverFive4            = 0;                    // 減価償却費(5年超)
	
	@SuppressWarnings("unused")
	private String                       genkTotal4               = "";                    // 減価償却費(合計)
	
	private long                       genkOne5                 = 0;                    // 減価償却費(1年以内)

	private long                       genkTwo5                 = 0;                    // 減価償却費(2年以内)
	
	private long                       genkThree5               = 0;                    // 減価償却費(3年以内)
	
    private long                       genkFour5                = 0;                    // 減価償却費(4年以内)
	
	private long                       genkFive5                = 0;                    // 減価償却費(5年以内)
	
	private long                       genkOverFive5            = 0;                    // 減価償却費(5年超)
	
	@SuppressWarnings("unused")
	private String                       genkTotal5               = "";                    // 減価償却費(合計)
	
	private long                       genkOne6                 = 0;                    // 減価償却費(1年以内)

	private long                       genkTwo6                 = 0;                    // 減価償却費(2年以内)
	
	private long                       genkThree6               = 0;                    // 減価償却費(6年以内)
	
    private long                       genkFour6                = 0;                    // 減価償却費(4年以内)
	
	private long                       genkFive6                = 0;                    // 減価償却費(5年以内)
	
	private long                       genkOverFive6            = 0;                    // 減価償却費(5年超)
	
	@SuppressWarnings("unused")
	private String                       genkTotal6               = "";                    // 減価償却費(合計)

	private long                       genkOne                 = 0;                    // 減価償却費(1年以内)

	private long                       genkTwo                 = 0;                    // 減価償却費(2年以内)
	
	private long                       genkThree               = 0;                    // 減価償却費(年以内)
	
    private long                       genkFour                = 0;                    // 減価償却費(4年以内)
	
	private long                       genkFive                = 0;                    // 減価償却費(5年以内)
	
	private long                       genkOverFive            = 0;                    // 減価償却費(5年超)
	
	@SuppressWarnings("unused")
	private long                       genkTotal               = 0;                    // 減価償却費(合計)

	
	private long                       bokaOne1                 = 0;                    // 簿価(1年以内)

	private long                       bokaTwo1                 = 0;                    // 簿価(2年以内)
	
	private long                       bokaThree1               = 0;                    // 簿価(3年以内)
	
    private long                       bokaFour1                = 0;                    // 簿価(4年以内)
	
	private long                       bokaFive1                = 0;                    // 簿価(5年以内)
	
	private long                       bokaOverFive1            = 0;                    // 簿価(5年超)
	
	private long                       bokaTotal1               = 0;                    // 簿価(合計)

	private long                       bokaOne2                 = 0;                    // 簿価(1年以内)

	private long                       bokaTwo2                 = 0;                    // 簿価(2年以内)
	
	private long                       bokaThree2               = 0;                    // 簿価(3年以内)
	
    private long                       bokaFour2                = 0;                    // 簿価(4年以内)
	
	private long                       bokaFive2                = 0;                    // 簿価(5年以内)
	
	private long                       bokaOverFive2            = 0;                    // 簿価(5年超)
	
	private long                       bokaTotal2               = 0;                    // 簿価(合計)
	
	private long                       bokaOne3                 = 0;                    // 簿価(1年以内)

	private long                       bokaTwo3                 = 0;                    // 簿価(2年以内)
	
	private long                       bokaThree3               = 0;                    // 簿価(3年以内)
	
    private long                       bokaFour3                = 0;                    // 簿価(4年以内)
	
	private long                       bokaFive3                = 0;                    // 簿価(5年以内)
	
	private long                       bokaOverFive3            = 0;                    // 簿価(5年超)
	
	private long                       bokaTotal3               = 0;                    // 簿価(合計)
	
	private long                       bokaOne4                 = 0;                    // 簿価(1年以内)

	private long                       bokaTwo4                 = 0;                    // 簿価(2年以内)
	
	private long                       bokaThree4               = 0;                    // 簿価(3年以内)
	
    private long                       bokaFour4                = 0;                    // 簿価(4年以内)
	
	private long                       bokaFive4                = 0;                    // 簿価(5年以内)
	
	private long                       bokaOverFive4            = 0;                    // 簿価(5年超)
	
	private long                       bokaTotal4               = 0;                    // 簿価(合計)
	
	private long                       bokaOne5                 = 0;                    // 簿価(1年以内)

	private long                       bokaTwo5                 = 0;                    // 簿価(2年以内)
	
	private long                       bokaThree5               = 0;                    // 簿価(3年以内)
	
    private long                       bokaFour5                = 0;                    // 簿価(4年以内)
	
	private long                       bokaFive5                = 0;                    // 簿価(5年以内)
	
	private long                       bokaOverFive5            = 0;                    // 簿価(5年超)
	
	private long                       bokaTotal5               = 0;                    // 簿価(合計)
	
	private long                       bokaOne6                 = 0;                    // 簿価(1年以内)

	private long                       bokaTwo6                 = 0;                    // 簿価(2年以内)
	
	private long                       bokaThree6               = 0;                    // 簿価(6年以内)
	
    private long                       bokaFour6                = 0;                    // 簿価(4年以内)
	
	private long                       bokaFive6                = 0;                    // 簿価(5年以内)
	
	private long                       bokaOverFive6            = 0;                    // 簿価(5年超)
	
	private long                       bokaTotal6               = 0;                    // 簿価(合計)
	
	private long                       bokaOne                 = 0;                    // 簿価(1年以内)

	private long                       bokaTwo                 = 0;                    // 簿価(2年以内)
	
	private long                       bokaThree               = 0;                    // 簿価(年以内)
	
    private long                       bokaFour                = 0;                    // 簿価(4年以内)
	
	private long                       bokaFive                = 0;                    // 簿価(5年以内)
	
	private long                       bokaOverFive            = 0;                    // 簿価(5年超)
	
	private long                       bokaTotal               = 0;                    // 簿価(合計)

	
			
	private static final String	TITLE_NEW	= "期日別予定表（資産） [新]";
	
	private static final String	TITLE_OLD	= "期日別予定表（資産） [旧]";
	
	// LACS帳票バッチ対応 
	private FileOutputStream fout = null; // 出力ファイルストリーム

	private File tmpFile = null; // 出力先ファイル

	private boolean batchFlg = false; // バッチ実行フラグ 
	
	private boolean batchStartFlg = false; //　バッチ出力開始フラグ
	
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
		tmpFile = File.createTempFile("pdf11_" + prefix + "_", ".pdf", scratchDirectory);
		fout = new FileOutputStream(tmpFile);
		// 2020/05/22 REP START LACS帳票バッチ出力
		File formFile = new File(formDirectory, "kijitsuSisan.pdf");	
		File datFile = new File(formDirectory, "kijitsuSisan.dat");
		// 2020/05/22 REP END   LACS帳票バッチ出力
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
	public LACSReportPDFKizitubetuSisanWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
	}
	
	/**
	 * 出力データを取得.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	public void getData(LACSReportBean piReportBean) throws SQLException {
	
		LACSReportKizituSisanEntity reportEntity = new LACSReportKizituSisanEntity(super.model, commonBean, piReportBean, this.acStd);
		LACSReportKizituSisanBean sisanDetail = null;
		

		try {
			reportEntity.setCon(super.con);

			piReportBean.setDataMax(reportEntity.execSQL());
			
			while(reportEntity.next()) {
				sisanDetail = new LACSReportKizituSisanBean();
				piReportBean.addKizituSisan(sisanDetail);
				
				sisanDetail.setBrakeKey0(reportEntity.getBreakKey0());
				sisanDetail.setBrakeKey1(reportEntity.getBreakKey1());
				sisanDetail.setBrakeKey2(reportEntity.getBreakKey2());
				sisanDetail.setBrakeKey3(reportEntity.getBreakKey3());
				sisanDetail.setBrakeKey4(reportEntity.getBreakKey4());
				sisanDetail.setBrakeKey5(reportEntity.getBreakKey5());
				sisanDetail.setBrakeKey6(reportEntity.getBreakKey6());
				
				sisanDetail.setLeaseCompany(reportEntity.getLeaseCompany());
				sisanDetail.setKaizisaki(reportEntity.getkaizisaki());
				sisanDetail.setKijyun(reportEntity.getStandardDate());
				sisanDetail.setJysiUm(reportEntity.getJysiUm());
				sisanDetail.setLeaseBunrui(reportEntity.getLeaseBunrui());
				sisanDetail.setKaikeiSyoriHouhou(reportEntity.getKaikeiSyori());
				sisanDetail.setSisanKbn(reportEntity.getSisanKbn());
				sisanDetail.setKoteiSisanKamoku(reportEntity.getSisanKamoku());
				sisanDetail.setGenkaSyokyakuHouhou(reportEntity.getGenkaSyokyakuMethod());
				sisanDetail.setKeiyakuNo(reportEntity.getKeiyakuNo());
				sisanDetail.setLeaseFrom(reportEntity.getLeaseFrom());
				sisanDetail.setLeaseTo(reportEntity.getLeaseTo());
				sisanDetail.setBukenNo(reportEntity.getBukenNo());
				sisanDetail.setBukenName(reportEntity.getBukenNm());
				sisanDetail.setkaiyakuYmd(reportEntity.getKaiyakuYmd());
				
				// 取得価額
				sisanDetail.setSyutokukagakuWithinOneYear(reportEntity.getSyutokuKagakuWithinOneYear());
				sisanDetail.setSyutokukagakuWithinTwoYear(reportEntity.getSyutokuKagakuWithinTwoYears());
				sisanDetail.setSyutokukagakuWithinThreeYear(reportEntity.getSyutokuKagakuWithinThreeYears());
				sisanDetail.setSyutokukagakuWithinFourYear(reportEntity.getSyutokuKagakuWithinFourYears());
				sisanDetail.setSyutokukagakuWithinFiveYear(reportEntity.getSyutokuKagakuWithinFiveYears());
				sisanDetail.setSyutokukagakuOverFiveYear(reportEntity.getSyutokuKagakuWithinOverFiveYears());
				sisanDetail.setSyutokukagakuTotal(reportEntity.getSyutokuKagakuTotal());				

				// 減価償却累計額
				sisanDetail.setGenkaSyokyakuRuikeiWithinOneYear(reportEntity.getGenkaRuikeiWithinOneYear());
				sisanDetail.setGenkaSyokyakuRuikeiWithinTwoYear(reportEntity.getGenkaRuikeiWithinTwoYears());
				sisanDetail.setGenkaSyokyakuRuikeiWithinThreeYear(reportEntity.getGenkaRuikeiWithinThreeYears());
				sisanDetail.setGenkaSyokyakuRuikeiWithinFourYear(reportEntity.getGenkaRuikeiWithinFourYears());
				sisanDetail.setGenkaSyokyakuRuikeiWithinFiveYear(reportEntity.getGenkaRuikeiWithinFiveYears());
				sisanDetail.setGenkaSyokyakuRuikeiOverFiveYear(reportEntity.getGenkaRuikeiWithinFiveYears());
				sisanDetail.setGenkaSyokyakuRuikeiTotal(reportEntity.getGenkaRuikeiTotal());
				
				// 減価償却費
				sisanDetail.setGenkaSyokyahiWithinOneYear(reportEntity.getGenkaSyokyakuWithinOneYear());
				sisanDetail.setGenkaSyokyahiWithinTwoYear(reportEntity.getGenkaSyokyakuWithinTwoYears());
				sisanDetail.setGenkaSyokyahiWithinThreeYear(reportEntity.getGenkaSyokyakuWithinThreeYears());
				sisanDetail.setGenkaSyokyahiWithinFourYear(reportEntity.getGenkaSyokyakuWithinFourYears());
				sisanDetail.setGenkaSyokyahiWithinFiveYear(reportEntity.getGenkaSyokyakuWithinFiveYears());				
				sisanDetail.setGenkaSyokyahiOverFiveYear(reportEntity.getGenkaSyokyakuOverFiveYears());
				sisanDetail.setGenkaSyokyahiTotal(reportEntity.getGenkaSyokyakuTotal());
				
				// 簿価
				sisanDetail.setBokaWithinOneYear(reportEntity.getBokaWithinOneYear());
				sisanDetail.setBokaWithinTwoYear(reportEntity.getBokaWithinTwoYears());
				sisanDetail.setBokaWithinThreeYear(reportEntity.getBokaWithinThreeYears());
				sisanDetail.setBokaWithinFourYear(reportEntity.getBokaWithinFourYears());
				sisanDetail.setBokaWithinFiveYear(reportEntity.getBokaWithinFiveYears());
				sisanDetail.setBokaOverFiveYear(reportEntity.getBokaWithinOverFiveYears());
				sisanDetail.setBokaTotal(reportEntity.getBokaTotal());
						
			}
					
		}finally {
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
		//report = null; // WebKCoreレポートオブジェクト
		// 2020/05/22 DEL START LACS帳票バッチ出力
		detail = null;
		lineCount = 0; // 明細カウンタ
		index = ""; // 明細行カウンタ
		Field field = null;
		
		String brakeKey1 = ""; // ブレイクキー1
		String brakeKey2 = ""; // ブレイクキー2
		String brakeKey3 = ""; // ブレイクキー3
		String brakeKey4 = ""; // ブレイクキー4
		String brakeKey5 = ""; // ブレイクキー5
		String brakeKey6 = ""; // ブレイクキー6

		try {
			
			// 取得価額					
			syutokuTotal1 = 0;			
			syutokuTotal2 = 0;			
			syutokuTotal3 = 0;		
			syutokuTotal4 = 0;			
			syutokuTotal5 = 0;		
			syutokuTotal6 = 0;
			
			// 減価償却累計額										
			ruisyutokuTotal1 = 0;			
			ruisyutokuTotal2 = 0;			
			ruisyutokuTotal3 = 0;			
			ruisyutokuTotal4 = 0;			
			ruisyutokuTotal5 = 0;			
			ruisyutokuTotal6 = 0;
			
			// 減価償却費					
			genkOne1 = 0;
			genkTwo1 = 0;
			genkThree1 = 0;
			genkFour1 = 0;
			genkFive1 = 0;
			genkOverFive1 = 0;
			//genkTotal1 = 0;
			genkOne2 = 0;
			genkTwo2 = 0;
			genkThree2 = 0;
			genkFour2 = 0;
			genkFive2 = 0;
			genkOverFive2 = 0;
			//genkTotal2 = 0;
			genkOne3 = 0;
			genkTwo3 = 0;
			genkThree3 = 0;
			genkFour3 = 0;
			genkFive3 = 0;
			genkOverFive3 = 0;
			//genkTotal3 = 0;
			genkOne4 = 0;
			genkTwo4 = 0;
			genkThree4 = 0;
			genkFour4 = 0;
			genkFive4 = 0;
			genkOverFive4 = 0;
			//genkTotal4 = 0;
			genkOne5 = 0;
			genkTwo5 = 0;
			genkThree5 = 0;
			genkFour5 = 0;
			genkFive5 = 0;
			genkOverFive5 = 0;
			//genkTotal5 = 0;
			genkOne6 = 0;
			genkTwo6 = 0;
			genkThree6 = 0;
			genkFour6 = 0;
			genkFive6 = 0;
			genkOverFive6 = 0;
			//genkTotal6 = 0;
			
			// 簿価				
			bokaOne1 = 0;
			bokaTwo1 = 0;
			bokaThree1 = 0;
			bokaFour1 = 0;
			bokaFive1 = 0;
			bokaOverFive1 = 0;
			bokaTotal1 = 0;
			bokaOne2 = 0;
			bokaTwo2 = 0;
			bokaThree2 = 0;
			bokaFour2 = 0;
			bokaFive2 = 0;
			bokaOverFive2 = 0;
			bokaTotal2 = 0;
			bokaOne3 = 0;
			bokaTwo3 = 0;
			bokaThree3 = 0;
			bokaFour3 = 0;
			bokaFive3 = 0;
			bokaOverFive3 = 0;
			bokaTotal3 = 0;
			bokaOne4 = 0;
			bokaTwo4 = 0;
			bokaThree4 = 0;
			bokaFour4 = 0;
			bokaFive4 = 0;
			bokaOverFive4 = 0;
			bokaTotal4 = 0;
			bokaOne5 = 0;
			bokaTwo5 = 0;
			bokaThree5 = 0;
			bokaFour5 = 0;
			bokaFive5 = 0;
			bokaOverFive5 = 0;
			bokaTotal5 = 0;
			bokaOne6 = 0;
			bokaTwo6 = 0;
			bokaThree6 = 0;
			bokaFour6 = 0;
			bokaFive6 = 0;
			bokaOverFive6 = 0;
			bokaTotal6 = 0;
			
			//　20210603 arai 総合計の初期化 start
			syutokuTotal = 0;
			ruisyutokuTotal = 0;
			genkOne = 0;
			genkTwo = 0;
			genkThree = 0;
			genkFour = 0;
			genkFive = 0;
			genkOverFive = 0;
			bokaOne = 0;
			bokaTwo = 0;
			bokaThree = 0; 
			bokaFour = 0;
			bokaFive = 0;
			bokaOverFive = 0;
			bokaTotal = 0;
			souPage = 0;
			page = 0;
			//　20210603 arai 総合計の初期化 end
			
			// LACS帳票バッチ出力対応
			if(!batchFlg) {
				
				scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
				formDirectory = new File(wprlHomeDirectory, FORM_PATH);
				tmpFile = File.createTempFile("pdf11_" + prefix + "_", ".pdf", scratchDirectory);
				fout = new FileOutputStream(tmpFile);
				File formFile = new File(formDirectory, "kijitsuSisan.pdf");
				File datFile = new File(formDirectory, "kijitsuSisan.dat");
				report = new Report(formFile, datFile, fout);
				
			}
				 
			if (batchFlg && !batchStartFlg) {
				this.startReport(piContext);
				batchStartFlg =true;
			}
			
			// 2020/05/22 DEL START LACS帳票バッチ出力
//			tmpFile = File.createTempFile("pdf11_" + prefix + "_", ".pdf", scratchDirectory);
//			fout = new FileOutputStream(tmpFile);
//			File formFile = new File(formDirectory, "kijitsuSisan.pdf");
//			File datFile = new File(formDirectory, "kijitsuSisan.dat");
//			report = new Report(formFile, datFile, fout);											
			// 2020/05/22 DEL END   LACS帳票バッチ出力
							
			
			
			// 総ページ数を取得
            for (int i = 0; i < piReportBean.getDataMax(); i++) {

            	detail = piReportBean.getKizituSisan(i);
            	
            	if (!detail.getBrakeKey6().equals(brakeKey6)) {
					if (!brakeKey6.equals("")) {

						if (lineCount >= MAX_LINE) {
							souPage++; 
							lineCount = 0;
						}

						lineCount++;
            	
						if (!detail.getBrakeKey5().equals(brakeKey5)) {

							if (lineCount >= MAX_LINE) {
								souPage++; 
								lineCount = 0;
							}

							lineCount++;
							
							if (!detail.getBrakeKey4().equals(brakeKey4)) {

								if (lineCount >= MAX_LINE) {
									souPage++; 
									lineCount = 0;
								}

								lineCount++;
								
								if (!detail.getBrakeKey3().equals(brakeKey3)) {

									if (lineCount >= MAX_LINE) {
										souPage++; 
										lineCount = 0;
									}

									lineCount++;
									
									if (!detail.getBrakeKey2().equals(brakeKey2)) {

										if (lineCount >= MAX_LINE) {
											souPage++; 
											lineCount = 0;
										}

										lineCount++;
										
										if (!detail.getBrakeKey1().equals(brakeKey1)) {

											if (lineCount >= MAX_LINE) {
												souPage++; 
												lineCount = 0;
											}

											lineCount++;
										}

									}

								}
							}																					
						}
				    }
													
					brakeKey1 = detail.getBrakeKey1();
					brakeKey2 = detail.getBrakeKey2();
					brakeKey3 = detail.getBrakeKey3();
					brakeKey4 = detail.getBrakeKey4();
					brakeKey5 = detail.getBrakeKey5();
					brakeKey6 = detail.getBrakeKey6();
					
					souPage++;
					lineCount = 0;					
					
            	} else {

				  if (lineCount >= MAX_LINE) {
					  souPage++; 
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
			lineCount++;
			
			if (lineCount >= MAX_LINE) {
				souPage++; // 総ページ数のカウントＵＰ
				lineCount = 0;
			}

			brakeKey1 = ""; 
			brakeKey2 = ""; 
			brakeKey3 = ""; 
			brakeKey4 = ""; 
			brakeKey5 = "";
			brakeKey6 = "";
			
			lineCount = 0;

			
			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				
				detail = piReportBean.getKizituSisan(i);
				
				if (!detail.getBrakeKey6().equals(brakeKey6)) {
					if (!brakeKey6.equals("")) {

						//if (lineCount >= MAX_LINE) {							
						//	lineCount = 0;
						//}						
						
						if (lineCount >= MAX_LINE) {
							detail = piReportBean.getKizituSisan(i - 1);
							headPrint(piReportBean, piDateMode);
							detail = piReportBean.getKizituSisan(i);
						}
						
						//lineCount++;
						
						GenkaSyokyakuGoukei(piReportBean);
						

						syutokuOne6 = "";
						syutokuTwo6 = "";
						syutokuThree6 = "";
						syutokuFour6 = "";						
						syutokuFive6 = "";
						syutokuOverFive6 = "";
						syutokuTotal6 = 0;
				
						ruisyutokuOne6 = "";
						ruisyutokuTwo6 = "";
						ruisyutokuThree6 = "";
						ruisyutokuFour6 = "";
						ruisyutokuFive6 = "";
						ruisyutokuOverFive6 = "";
						ruisyutokuTotal6 = 0;
					
						genkOne6 = 0;
						genkTwo6 = 0;
						genkThree6 = 0;
						genkFour6 = 0;
						genkFive6 = 0;
						genkOverFive6 = 0;
						//genkTotal6 = 0;
						
						bokaOne6 = 0;
						bokaTwo6 = 0;
						bokaThree6 = 0;
						bokaFour6 = 0;
						bokaFive6 = 0;
						bokaOverFive6 = 0;
						bokaTotal6 = 0;		
						
						if (!detail.getBrakeKey5().equals(brakeKey5)) {

							/*if (lineCount >= MAX_LINE) {								
								lineCount = 0;
							}*/

							if (lineCount >= MAX_LINE) {
								detail = piReportBean.getKizituSisan(i - 1);
								headPrint(piReportBean, piDateMode);
								detail = piReportBean.getKizituSisan(i);
							}
														
							//lineCount++;
							
							SisanGoukei(piReportBean);
							
							syutokuOne5 = "";
							syutokuTwo5 = "";
							syutokuThree5 = "";
							syutokuFour5 = "";
							syutokuFive5 = "";
							syutokuOverFive5 = "";
							syutokuTotal5 = 0;
					
							ruisyutokuOne5 = "";
							ruisyutokuTwo5 = "";
							ruisyutokuThree5 = "";
							ruisyutokuFour5 = "";
							ruisyutokuFive5 = "";
							ruisyutokuOverFive5 = "";
							ruisyutokuTotal5 = 0;
						
							genkOne5 = 0;
							genkTwo5 = 0;
							genkThree5 = 0;
							genkFour5 = 0;
							genkFive5 = 0;
							genkOverFive5 = 0;
							genkTotal5 = "";
							
							bokaOne5 = 0;
							bokaTwo5 = 0;
							bokaThree5 = 0;
							bokaFour5 = 0;
							bokaFive5 = 0;
							bokaOverFive5 = 0;
							bokaTotal5 = 0;		
																			    
							
							if (!detail.getBrakeKey4().equals(brakeKey4)) {

								/*if (lineCount >= MAX_LINE) {
									lineCount = 0;
								  }*/
								
								
								if (lineCount >= MAX_LINE) {
									detail = piReportBean.getKizituSisan(i - 1);
									headPrint(piReportBean, piDateMode);
									detail = piReportBean.getKizituSisan(i);
								}
								
								//lineCount++;
								
								SisanKbnGoukei(piReportBean);
								
								syutokuOne4 = "";
								syutokuTwo4 = "";
								syutokuThree4 = "";
								syutokuFour4 = "";
								syutokuFive4 = "";
								syutokuOverFive4 = "";
								syutokuTotal4 = 0;
						
								ruisyutokuOne4 = "";
								ruisyutokuTwo4 = "";
								ruisyutokuThree4 = "";
								ruisyutokuFour4 = "";
								ruisyutokuFive4 = "";
								ruisyutokuOverFive4 = "";
								ruisyutokuTotal4 = 0;
							
								genkOne4 = 0;
								genkTwo4 = 0;
								genkThree4 = 0;
								genkFour4 = 0;
								genkFive4 = 0;
								genkOverFive4 = 0;
								genkTotal4 = "";
								
								bokaOne4 = 0;
								bokaTwo4 = 0;
								bokaThree4 = 0;
								bokaFour4 = 0;
								bokaFive4 = 0;
								bokaOverFive4 = 0;
								bokaTotal4 = 0;								

								if (!detail.getBrakeKey3().equals(brakeKey3)) {

									/*if (lineCount >= MAX_LINE) {										
										lineCount = 0;
									}*/
									
									
									if (lineCount >= MAX_LINE) {
										detail = piReportBean.getKizituSisan(i - 1);
										headPrint(piReportBean, piDateMode);
										detail = piReportBean.getKizituSisan(i);
									}								

									//lineCount++;
									
									kaikeiGoukei(piReportBean);
									
									syutokuOne3 = "";
									syutokuTwo3 = "";
									syutokuThree3 = "";
									syutokuFour3 = "";
									syutokuFive3 = "";
									syutokuOverFive3 = "";
									syutokuTotal3 = 0;
							
									ruisyutokuOne3 = "";
									ruisyutokuTwo3 = "";
									ruisyutokuThree3 = "";
									ruisyutokuFour3 = "";
									ruisyutokuFive3 = "";
									ruisyutokuOverFive3 = "";
									ruisyutokuTotal3 = 0;
								
									genkOne3 = 0;
									genkTwo3 = 0;
									genkThree3 = 0;
									genkFour3 = 0;
									genkFive3 = 0;
									genkOverFive3 = 0;
									genkTotal3 = "";
									
									bokaOne3 = 0;
									bokaTwo3 = 0;
									bokaThree3 = 0;
									bokaFour3 = 0;
									bokaFive3 = 0;
									bokaOverFive3 = 0;
									bokaTotal3 = 0;	
																		
									if (!detail.getBrakeKey2().equals(brakeKey2)) {

										/*if (lineCount >= MAX_LINE) {
											lineCount = 0;
										}*/										
										
										if (lineCount >= MAX_LINE) {
											detail = piReportBean.getKizituSisan(i - 1);
											headPrint(piReportBean, piDateMode);
											detail = piReportBean.getKizituSisan(i);
										}
										
										//lineCount++;
										
										LeaseBunruiGoukei(piReportBean);
										
										syutokuOne2 = "";
										syutokuTwo2 = "";
										syutokuThree2 = "";
										syutokuFour2 = "";
										syutokuFive2 = "";
										syutokuOverFive2 = "";
										syutokuTotal2 = 0;
								
										ruisyutokuOne2 = "";
										ruisyutokuTwo2 = "";
										ruisyutokuThree2 = "";
										ruisyutokuFour2 = "";
										ruisyutokuFive2 = "";
										ruisyutokuOverFive2 = "";
										ruisyutokuTotal2 = 0;
									
										genkOne2 = 0;
										genkTwo2 = 0;
										genkThree2 = 0;
										genkFour2 = 0;
										genkFive2 = 0;
										genkOverFive2 = 0;
										genkTotal2 = "";
										
										bokaOne2 = 0;
										bokaTwo2 = 0;
										bokaThree2 = 0;
										bokaFour2 = 0;
										bokaFive2 = 0;
										bokaOverFive2 = 0;
										bokaTotal2 = 0;																	
																				
										if (!detail.getBrakeKey1().equals(brakeKey1)) {

											
											if (lineCount >= MAX_LINE) {
												detail = piReportBean.getKizituSisan(i - 1);
												headPrint(piReportBean, piDateMode);
												detail = piReportBean.getKizituSisan(i);
											}
											
											//lineCount++;
											
											JysiUmGoukei(piReportBean);
											
											syutokuOne1 = "";
											syutokuTwo1 = "";
											syutokuThree1 = "";
											syutokuFour1 = "";
											syutokuFive1 = "";
											syutokuOverFive1 = "";
											syutokuTotal1 = 0;
									
											ruisyutokuOne1 = "";
											ruisyutokuTwo1 = "";
											ruisyutokuThree1 = "";
											ruisyutokuFour1 = "";
											ruisyutokuFive1 = "";
											ruisyutokuOverFive1 = "";
											ruisyutokuTotal1 = 0;
										
											genkOne1 = 0;
											genkTwo1 = 0;
											genkThree1 = 0;
											genkFour1 = 0;
											genkFive1 = 0;
											genkOverFive1 = 0;
											genkTotal1 = "";
											
											bokaOne1 = 0;
											bokaTwo1 = 0;
											bokaThree1 = 0;
											bokaFour1 = 0;
											bokaFive1 = 0;
											bokaOverFive1 = 0;
											bokaTotal1 = 0;																	

											
										}
										
									}																		
									
								}
								
							}
						}
					}
										
					lineCount = 0;

					//brakeKey0 = detail.getBrakeKey0();					
					brakeKey1 = detail.getBrakeKey1();
					brakeKey2 = detail.getBrakeKey2();
					brakeKey3 = detail.getBrakeKey3();
					brakeKey4 = detail.getBrakeKey4();
					brakeKey5 = detail.getBrakeKey5();
					brakeKey6 = detail.getBrakeKey6();
				
				} else {

					if (lineCount >= MAX_LINE) {						
						lineCount = 0;
					}
				}				

			
				if (lineCount <= 0) {
					headPrint(piReportBean, piDateMode);
				}				
				
				index = "." + Convert.toString(lineCount); 											    													

				field = report.getField("xKeiNo" + index);
				report.putFieldData(field, detail.getKeiyakuNo());
								
				field = report.getField("xBknNo" + index);
				report.putFieldData(field, detail.getBukenNo());
				
				field = report.getField("xBknNm" + index);
				report.putFieldData(field, detail.getBukenName());
				
				field = report.getField("xKnshuYmd" + index);
				report.putFieldData(field, detail.getLeaseFrom());
				
				field = report.getField("xMryoYmd" + index);
				report.putFieldData(field, detail.getLeaseTo());
				
				field = report.getField("xKaiYmd" + index);
				report.putFieldData(field, detail.getkaiyakuYmd());
				
				field = report.getField("xGetprcTitle" + index);
				report.putFieldData(field, "取得価額");
				
				field = report.getField("xGenkruiTitle" + index);
				report.putFieldData(field, "減価償却累計額");
				
				field = report.getField("xGenkTitle" + index);
				report.putFieldData(field, "減価償却費");
				
				field = report.getField("xBokTitle" + index);
				report.putFieldData(field, "簿価");

				field = report.getField("xGetprc1" + index);
				report.putFieldData(field, detail.getSyutokukagakuWithinOneYear());
				
				field = report.getField("xGetprc2" + index);
				report.putFieldData(field, detail.getSyutokukagakuWithinTwoYear());
				
				field = report.getField("xGetprc3" + index);
				report.putFieldData(field, detail.getSyutokukagakuWithinThreeYear());
				
				field = report.getField("xGetprc4" + index);
				report.putFieldData(field, detail.getSyutokukagakuWithinFourYear());
				
				field = report.getField("xGetprc5" + index);
				report.putFieldData(field, detail.getSyutokukagakuWithinFiveYear());
				
				field = report.getField("xGetprc6" + index);
				report.putFieldData(field, detail.getSyutokukagakuOverFiveYear());
				
				field = report.getField("xGetprc7" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyutokukagakuTotal()));
				
				field = report.getField("xGenkrui1" + index);
				report.putFieldData(field, detail.getGenkaSyokyakuRuikeiWithinOneYear());
				
				field = report.getField("xGenkrui2" + index);
				report.putFieldData(field, detail.getGenkaSyokyakuRuikeiWithinTwoYear());
				
				field = report.getField("xGenkrui3" + index);
				report.putFieldData(field, detail.getGenkaSyokyakuRuikeiWithinThreeYear());
				
				field = report.getField("xGenkrui4" + index);
				report.putFieldData(field, detail.getGenkaSyokyakuRuikeiWithinFourYear());
				
				field = report.getField("xGenkrui5" + index);
				report.putFieldData(field, detail.getGenkaSyokyakuRuikeiWithinFiveYear());
				
				field = report.getField("xGenkrui6" + index);
				report.putFieldData(field, detail.getGenkaSyokyakuRuikeiOverFiveYear());
				
				field = report.getField("xGenkrui7" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenkaSyokyakuRuikeiTotal()));
				
				field = report.getField("xGenk1" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenkaSyokyahiWithinOneYear()));
				
				field = report.getField("xGenk2" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenkaSyokyahiWithinTwoYear()));
				
				field = report.getField("xGenk3" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenkaSyokyahiWithinThreeYear()));
				
				field = report.getField("xGenk4" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenkaSyokyahiWithinFourYear()));
				
				field = report.getField("xGenk5" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenkaSyokyahiWithinFiveYear()));
				
				field = report.getField("xGenk6" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getGenkaSyokyahiOverFiveYear()));
				
				field = report.getField("xGenk7" + index);
				report.putFieldData(field, detail.getGenkaSyokyahiTotal());
				
				field = report.getField("xBok1" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getBokaWithinOneYear()));
				
				field = report.getField("xBok2" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getBokaWithinTwoYear()));
				
				field = report.getField("xBok3" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getBokaWithinThreeYear()));
				
				field = report.getField("xBok4" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getBokaWithinFourYear()));
				
				field = report.getField("xBok5" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getBokaWithinFiveYear()));
				
				field = report.getField("xBok6" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getBokaOverFiveYear()));
				
				field = report.getField("xBok7" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getBokaTotal()));
															
								
				syutokuTotal1 += detail.getSyutokukagakuTotal();						
				syutokuTotal2 += detail.getSyutokukagakuTotal();						
				syutokuTotal3 += detail.getSyutokukagakuTotal();				
				syutokuTotal4 += detail.getSyutokukagakuTotal();							
				syutokuTotal5 += detail.getSyutokukagakuTotal();
				syutokuTotal6 += detail.getSyutokukagakuTotal();
				syutokuTotal += detail.getSyutokukagakuTotal();
							
				ruisyutokuTotal1 += detail.getGenkaSyokyakuRuikeiTotal();
				ruisyutokuTotal2 += detail.getGenkaSyokyakuRuikeiTotal();
				ruisyutokuTotal3 += detail.getGenkaSyokyakuRuikeiTotal();
				ruisyutokuTotal4 += detail.getGenkaSyokyakuRuikeiTotal();								
				ruisyutokuTotal5 += detail.getGenkaSyokyakuRuikeiTotal();							
				ruisyutokuTotal6 += detail.getGenkaSyokyakuRuikeiTotal();
				ruisyutokuTotal += detail.getGenkaSyokyakuRuikeiTotal();
	
				genkOne1 += detail.getGenkaSyokyahiWithinOneYear();
				genkTwo1 += detail.getGenkaSyokyahiWithinTwoYear();
				genkThree1 += detail.getGenkaSyokyahiWithinThreeYear();
				genkFour1 += detail.getGenkaSyokyahiWithinFourYear();
				genkFive1 += detail.getGenkaSyokyahiWithinFiveYear();
				genkOverFive1 += detail.getGenkaSyokyahiOverFiveYear();
				genkTotal1 += detail.getGenkaSyokyahiTotal();
				
				genkOne2 += detail.getGenkaSyokyahiWithinOneYear();
				genkTwo2 += detail.getGenkaSyokyahiWithinTwoYear();
				genkThree2 += detail.getGenkaSyokyahiWithinThreeYear();
				genkFour2 += detail.getGenkaSyokyahiWithinFourYear();
				genkFive2 += detail.getGenkaSyokyahiWithinFiveYear();
				genkOverFive2 += detail.getGenkaSyokyahiOverFiveYear();
				genkTotal2 += detail.getGenkaSyokyahiTotal();
				
				genkOne3 += detail.getGenkaSyokyahiWithinOneYear();
				genkTwo3 += detail.getGenkaSyokyahiWithinTwoYear();
				genkThree3 += detail.getGenkaSyokyahiWithinThreeYear();
				genkFour3 += detail.getGenkaSyokyahiWithinFourYear();
				genkFive3 += detail.getGenkaSyokyahiWithinFiveYear();
				genkOverFive3 += detail.getGenkaSyokyahiOverFiveYear();
				genkTotal3 += detail.getGenkaSyokyahiTotal();
				
				genkOne4 += detail.getGenkaSyokyahiWithinOneYear();
				genkTwo4 += detail.getGenkaSyokyahiWithinTwoYear();
				genkThree4 += detail.getGenkaSyokyahiWithinThreeYear();
				genkFour4 += detail.getGenkaSyokyahiWithinFourYear();
				genkFive4 += detail.getGenkaSyokyahiWithinFiveYear();
				genkOverFive4 += detail.getGenkaSyokyahiOverFiveYear();
				genkTotal4 += detail.getGenkaSyokyahiTotal();
				
				genkOne5 += detail.getGenkaSyokyahiWithinOneYear();
				genkTwo5 += detail.getGenkaSyokyahiWithinTwoYear();
				genkThree5 += detail.getGenkaSyokyahiWithinThreeYear();
				genkFour5 += detail.getGenkaSyokyahiWithinFourYear();
				genkFive5 += detail.getGenkaSyokyahiWithinFiveYear();
				genkOverFive5 += detail.getGenkaSyokyahiOverFiveYear();
				genkTotal5 += detail.getGenkaSyokyahiTotal();
				
				genkOne6 += detail.getGenkaSyokyahiWithinOneYear();
				genkTwo6 += detail.getGenkaSyokyahiWithinTwoYear();
				genkThree6 += detail.getGenkaSyokyahiWithinThreeYear();
				genkFour6 += detail.getGenkaSyokyahiWithinFourYear();
				genkFive6 += detail.getGenkaSyokyahiWithinFiveYear();
				genkOverFive6 += detail.getGenkaSyokyahiOverFiveYear();
				genkTotal6 += detail.getGenkaSyokyahiTotal();
				
				genkOne += detail.getGenkaSyokyahiWithinOneYear();
				genkTwo += detail.getGenkaSyokyahiWithinTwoYear();
				genkThree += detail.getGenkaSyokyahiWithinThreeYear();
				genkFour += detail.getGenkaSyokyahiWithinFourYear();
				genkFive += detail.getGenkaSyokyahiWithinFiveYear();
				genkOverFive += detail.getGenkaSyokyahiOverFiveYear();
				//genkTotal += detail.getGenkaSyokyahiTotal();

				bokaOne1 += detail.getBokaWithinOneYear();
				bokaTwo1 += detail.getBokaWithinTwoYear();
				bokaThree1 += detail.getBokaWithinThreeYear();
				bokaFour1 += detail.getBokaWithinFourYear();
				bokaFive1 += detail.getBokaWithinFiveYear();
				bokaOverFive1 += detail.getBokaOverFiveYear();
				bokaTotal1 += detail.getBokaTotal();
				
				bokaOne2 += detail.getBokaWithinOneYear();
				bokaTwo2 += detail.getBokaWithinTwoYear();
				bokaThree2 += detail.getBokaWithinThreeYear();
				bokaFour2 += detail.getBokaWithinFourYear();
				bokaFive2 += detail.getBokaWithinFiveYear();
				bokaOverFive2 += detail.getBokaOverFiveYear();
				bokaTotal2 += detail.getBokaTotal();
				
				bokaOne3 += detail.getBokaWithinOneYear();
				bokaTwo3 += detail.getBokaWithinTwoYear();
				bokaThree3 += detail.getBokaWithinThreeYear();
				bokaFour3 += detail.getBokaWithinFourYear();
				bokaFive3 += detail.getBokaWithinFiveYear();
				bokaOverFive3 += detail.getBokaOverFiveYear();
				bokaTotal3 += detail.getBokaTotal();
				
				bokaOne4 += detail.getBokaWithinOneYear();
				bokaTwo4 += detail.getBokaWithinTwoYear();
				bokaThree4 += detail.getBokaWithinThreeYear();
				bokaFour4 += detail.getBokaWithinFourYear();
				bokaFive4 += detail.getBokaWithinFiveYear();
				bokaOverFive4 += detail.getBokaOverFiveYear();
				bokaTotal4 += detail.getBokaTotal();
				
				bokaOne5 += detail.getBokaWithinOneYear();
				bokaTwo5 += detail.getBokaWithinTwoYear();
				bokaThree5 += detail.getBokaWithinThreeYear();
				bokaFour5 += detail.getBokaWithinFourYear();
				bokaFive5 += detail.getBokaWithinFiveYear();
				bokaOverFive5 += detail.getBokaOverFiveYear();
				bokaTotal5 += detail.getBokaTotal();
				
				bokaOne6 += detail.getBokaWithinOneYear();
				bokaTwo6 += detail.getBokaWithinTwoYear();
				bokaThree6 += detail.getBokaWithinThreeYear();
				bokaFour6 += detail.getBokaWithinFourYear();
				bokaFive6 += detail.getBokaWithinFiveYear();
				bokaOverFive6 += detail.getBokaOverFiveYear();
				bokaTotal6 += detail.getBokaTotal();
				
				bokaOne += detail.getBokaWithinOneYear();
				bokaTwo += detail.getBokaWithinTwoYear();
				bokaThree += detail.getBokaWithinThreeYear();
				bokaFour += detail.getBokaWithinFourYear();
				bokaFive += detail.getBokaWithinFiveYear();
				bokaOverFive += detail.getBokaOverFiveYear();
				bokaTotal += detail.getBokaTotal();

				
				lineCount++;	
				
				if (lineCount > MAX_LINE) {
					//souPage++; 
					lineCount = 0;
				}

			}
			
			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			GenkaSyokyakuGoukei(piReportBean);
			
			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			SisanGoukei(piReportBean);
			
			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			SisanKbnGoukei(piReportBean);
			
			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			kaikeiGoukei(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			LeaseBunruiGoukei(piReportBean);
			
			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}
											
			JysiUmGoukei(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}
											
			souGokeiPrint(piReportBean);

						
			// LACS帳票バッチ対応
			if (!batchFlg) {
				report.close();
				report = null;
			}
						
			return tmpFile.getName();
			
		}finally {
			// LACS帳票バッチ対応
			if (!batchFlg) {
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
	}

	// ヘッダー部
	private void headPrint(LACSReportBean piReportBean, String piDateMode) throws Exception {
		
		Field field = null;

		report.createPage(1);

		lineCount = 0;

		field = report.getField("xPage");
		report.putFieldData(field, ++page + "/" + souPage);
		
		field = report.getField("xCreateDate");
		report.putFieldData(field, super.convertReki(Convert.toString(new Date()), piDateMode));
		
		field = report.getField("xTitle");
		report.putFieldData(field, super.acStd.equals(LACSDefine.AccountStandard.NEW_1) ? TITLE_NEW : TITLE_OLD);
		
		field = report.getField("xLcNm");
		report.putFieldData(field, detail.getLeaseCompany());
		
		field = report.getField("xLuNm");
		report.putFieldData(field, detail.getKaizisaki());
		
		field = report.getField("xOutputDate");
		report.putFieldData(field, super.convertReki((detail.getKijyun()), piDateMode) + " 現在");
		
		field = report.getField("xJysiUm");
		report.putFieldData(field, detail.getJysiUm());
	
		field = report.getField("xTrdHnteiKekaNm");
		report.putFieldData(field, detail.getLeaseBunrui());
		
		field = report.getField("xAcShrNm");
		report.putFieldData(field, detail.getKaikeisyoriHouhou());
		
		field = report.getField("xSsnKbn");
		report.putFieldData(field, detail.getSisanKbn());
		
		field = report.getField("xKoteSsnKmkNm");
		report.putFieldData(field, detail.getKoteiSisanKamoku());
		
		field = report.getField("xGenkSkkHouNm");
		report.putFieldData(field, detail.getGenkaSyokyakuHouhou());	

	}


    // 減価償却方法計
    private void GenkaSyokyakuGoukei(LACSReportBean piReportBean) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); 
		
		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "減価償却方法計");
		
		field = report.getField("xGetprcTitle" + index);
		report.putFieldData(field, "取得価額");
		
		field = report.getField("xGenkruiTitle" + index);
		report.putFieldData(field, "減価償却累計額");
		
		field = report.getField("xGenkTitle" + index);
		report.putFieldData(field, "減価償却費");
		
		field = report.getField("xBokTitle" + index);
		report.putFieldData(field, "簿価");

		field = report.getField("xGetprc1" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc2" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc3" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc4" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc5" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc6" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc7" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuTotal6));
		
		field = report.getField("xGenkrui1" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui2" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui3" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui4" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui5" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui6" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ruisyutokuTotal6));
		
		field = report.getField("xGenk1" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkOne6));
		
		field = report.getField("xGenk2" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkTwo6));
		
		field = report.getField("xGenk3" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkThree6));
		
		field = report.getField("xGenk4" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkFour6));
		
		field = report.getField("xGenk5" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkFive6));
		
		field = report.getField("xGenk6" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkOverFive6));
		
		field = report.getField("xGenk7" + index);
		//report.putFieldData(field, StringUtl.formatNumber(genkTotal6));
		report.putFieldData(field, "-");
		
		field = report.getField("xBok1" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaOne6));
		
		field = report.getField("xBok2" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaTwo6));
		
		field = report.getField("xBok3" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaThree6));
		
		field = report.getField("xBok4" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaFour6));
		
		field = report.getField("xBok5" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaFive6));
		
		field = report.getField("xBok6" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaOverFive6));
		
		field = report.getField("xBok7" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaTotal6));
		
		lineCount++;

		
    }
    
    // 固定資産科目計
    private void SisanGoukei(LACSReportBean piReportBean) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); 
		
		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "固定資産科目計");
		
		field = report.getField("xGetprcTitle" + index);
		report.putFieldData(field, "取得価額");
		
		field = report.getField("xGenkruiTitle" + index);
		report.putFieldData(field, "減価償却累計額");
		
		field = report.getField("xGenkTitle" + index);
		report.putFieldData(field, "減価償却費");
		
		field = report.getField("xBokTitle" + index);
		report.putFieldData(field, "簿価");

		field = report.getField("xGetprc1" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc2" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc3" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc4" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc5" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc6" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc7" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuTotal5));
		
		field = report.getField("xGenkrui1" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui2" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui3" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui4" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui5" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui6" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ruisyutokuTotal5));
		
		field = report.getField("xGenk1" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkOne5));
		
		field = report.getField("xGenk2" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkTwo5));
		
		field = report.getField("xGenk3" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkThree5));
		
		field = report.getField("xGenk4" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkFour5));
		
		field = report.getField("xGenk5" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkFive5));
		
		field = report.getField("xGenk6" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkOverFive5));
		
		field = report.getField("xGenk7" + index);
		//report.putFieldData(field, StringUtl.formatNumber(genkTotal5));
		report.putFieldData(field, "-");
		
		field = report.getField("xBok1" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaOne5));
		
		field = report.getField("xBok2" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaTwo5));
		
		field = report.getField("xBok3" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaThree5));
		
		field = report.getField("xBok4" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaFour5));
		
		field = report.getField("xBok5" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaFive5));
		
		field = report.getField("xBok6" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaOverFive5));
		
		field = report.getField("xBok7" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaTotal5));
		
		lineCount++;

		
    }

    // 資産区分
    private void SisanKbnGoukei(LACSReportBean piReportBean) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); 
		
		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "資産区分計");
		
		field = report.getField("xGetprcTitle" + index);
		report.putFieldData(field, "取得価額");
		
		field = report.getField("xGenkruiTitle" + index);
		report.putFieldData(field, "減価償却累計額");
		
		field = report.getField("xGenkTitle" + index);
		report.putFieldData(field, "減価償却費");
		
		field = report.getField("xBokTitle" + index);
		report.putFieldData(field, "簿価");

		field = report.getField("xGetprc1" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc2" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc3" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc4" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc5" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc6" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc7" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuTotal4));
		
		field = report.getField("xGenkrui1" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui2" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui3" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui4" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui5" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui6" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ruisyutokuTotal4));
		
		field = report.getField("xGenk1" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkOne4));
		
		field = report.getField("xGenk2" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkTwo4));
		
		field = report.getField("xGenk3" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkThree4));
		
		field = report.getField("xGenk4" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkFour4));
		
		field = report.getField("xGenk5" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkFive4));
		
		field = report.getField("xGenk6" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkOverFive4));
		
		field = report.getField("xGenk7" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xBok1" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaOne4));
		
		field = report.getField("xBok2" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaTwo4));
		
		field = report.getField("xBok3" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaThree4));
		
		field = report.getField("xBok4" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaFour4));
		
		field = report.getField("xBok5" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaFive4));
		
		field = report.getField("xBok6" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaOverFive4));
		
		field = report.getField("xBok7" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaTotal4));
		
		lineCount++;

		
    }


    // 会計処理方法計
    private void kaikeiGoukei(LACSReportBean piReportBean) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); 
		
		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "会計処理方法計");
		
		field = report.getField("xGetprcTitle" + index);
		report.putFieldData(field, "取得価額");
		
		field = report.getField("xGenkruiTitle" + index);
		report.putFieldData(field, "減価償却累計額");
		
		field = report.getField("xGenkTitle" + index);
		report.putFieldData(field, "減価償却費");
		
		field = report.getField("xBokTitle" + index);
		report.putFieldData(field, "簿価");

		field = report.getField("xGetprc1" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc2" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc3" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc4" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc5" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc6" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc7" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuTotal3));
		
		field = report.getField("xGenkrui1" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui2" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui3" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui4" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui5" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui6" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ruisyutokuTotal3));
		
		field = report.getField("xGenk1" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkOne3));
		
		field = report.getField("xGenk2" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkTwo3));
		
		field = report.getField("xGenk3" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkThree3));
		
		field = report.getField("xGenk4" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkFour3));
		
		field = report.getField("xGenk5" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkFive3));
		
		field = report.getField("xGenk6" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkOverFive3));
		
		field = report.getField("xGenk7" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xBok1" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaOne3));
		
		field = report.getField("xBok2" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaTwo3));
		
		field = report.getField("xBok3" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaThree3));
		
		field = report.getField("xBok4" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaFour3));
		
		field = report.getField("xBok5" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaFive3));
		
		field = report.getField("xBok6" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaOverFive3));
		
		field = report.getField("xBok7" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaTotal3));
		
		lineCount++;

		
    }

    // リース取引分類計
    private void LeaseBunruiGoukei(LACSReportBean piReportBean) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); 
		
		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "リース取引分類計");
		
		field = report.getField("xGetprcTitle" + index);
		report.putFieldData(field, "取得価額");
		
		field = report.getField("xGenkruiTitle" + index);
		report.putFieldData(field, "減価償却累計額");
		
		field = report.getField("xGenkTitle" + index);
		report.putFieldData(field, "減価償却費");
		
		field = report.getField("xBokTitle" + index);
		report.putFieldData(field, "簿価");

		field = report.getField("xGetprc1" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc2" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc3" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc4" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc5" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc6" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc7" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuTotal2));
		
		field = report.getField("xGenkrui1" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui2" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui3" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui4" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui5" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui6" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ruisyutokuTotal2));
		
		field = report.getField("xGenk1" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkOne2));
		
		field = report.getField("xGenk2" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkTwo2));
		
		field = report.getField("xGenk3" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkThree2));
		
		field = report.getField("xGenk4" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkFour2));
		
		field = report.getField("xGenk5" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkFive2));
		
		field = report.getField("xGenk6" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkOverFive2));
		
		field = report.getField("xGenk7" + index);
		//report.putFieldData(field, StringUtl.formatNumber(genkTotal2));
		report.putFieldData(field, "-");
		
		field = report.getField("xBok1" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaOne2));
		
		field = report.getField("xBok2" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaTwo2));
		
		field = report.getField("xBok3" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaThree2));
		
		field = report.getField("xBok4" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaFour2));
		
		field = report.getField("xBok5" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaFive2));
		
		field = report.getField("xBok6" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaOverFive2));
		
		field = report.getField("xBok7" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaTotal2));
		
		lineCount++;

		
    }
    
    // 重要性有無計
    private void JysiUmGoukei(LACSReportBean piReportBean) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); 
		
		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "重要性有無計");
		
		field = report.getField("xGetprcTitle" + index);
		report.putFieldData(field, "取得価額");
		
		field = report.getField("xGenkruiTitle" + index);
		report.putFieldData(field, "減価償却累計額");
		
		field = report.getField("xGenkTitle" + index);
		report.putFieldData(field, "減価償却費");
		
		field = report.getField("xBokTitle" + index);
		report.putFieldData(field, "簿価");

		field = report.getField("xGetprc1" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc2" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc3" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc4" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc5" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc6" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc7" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuTotal1));
		
		field = report.getField("xGenkrui1" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui2" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui3" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui4" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui5" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui6" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ruisyutokuTotal1));
		
		field = report.getField("xGenk1" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkOne1));
		
		field = report.getField("xGenk2" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkTwo1));
		
		field = report.getField("xGenk3" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkThree1));
		
		field = report.getField("xGenk4" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkFour1));
		
		field = report.getField("xGenk5" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkFive1));
		
		field = report.getField("xGenk6" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkOverFive1));
		
		field = report.getField("xGenk7" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xBok1" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaOne1));
		
		field = report.getField("xBok2" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaTwo1));
		
		field = report.getField("xBok3" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaThree1));
		
		field = report.getField("xBok4" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaFour1));
		
		field = report.getField("xBok5" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaFive1));
		
		field = report.getField("xBok6" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaOverFive1));
		
		field = report.getField("xBok7" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaTotal1));
		
		lineCount++;

		
    }
    
    // 総合計
    private void souGokeiPrint(LACSReportBean piReportBean) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); 

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "総合計");
		
		field = report.getField("xGetprcTitle" + index);
		report.putFieldData(field, "取得価額");
		
		field = report.getField("xGenkruiTitle" + index);
		report.putFieldData(field, "減価償却累計額");
		
		field = report.getField("xGenkTitle" + index);
		report.putFieldData(field, "減価償却費");
		
		field = report.getField("xBokTitle" + index);
		report.putFieldData(field, "簿価");

		field = report.getField("xGetprc1" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc2" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc3" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc4" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc5" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc6" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGetprc7" + index);
		report.putFieldData(field, StringUtl.formatNumber(syutokuTotal));
		
		field = report.getField("xGenkrui1" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui2" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui3" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui4" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui5" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui6" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xGenkrui7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ruisyutokuTotal));
		
		field = report.getField("xGenk1" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkOne));
		
		field = report.getField("xGenk2" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkTwo));
		
		field = report.getField("xGenk3" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkThree));
		
		field = report.getField("xGenk4" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkFour));
		
		field = report.getField("xGenk5" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkFive));
		
		field = report.getField("xGenk6" + index);
		report.putFieldData(field, StringUtl.formatNumber(genkOverFive));
		
		field = report.getField("xGenk7" + index);
		report.putFieldData(field, "-");
		
		field = report.getField("xBok1" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaOne));
		
		field = report.getField("xBok2" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaTwo));
		
		field = report.getField("xBok3" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaThree));
		
		field = report.getField("xBok4" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaFour));
		
		field = report.getField("xBok5" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaFive));
		
		field = report.getField("xBok6" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaOverFive));
		
		field = report.getField("xBok7" + index);
		report.putFieldData(field, StringUtl.formatNumber(bokaTotal));
		
		lineCount++;
		
		
    }

}
