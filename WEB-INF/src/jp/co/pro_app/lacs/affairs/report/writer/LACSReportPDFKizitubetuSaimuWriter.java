package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportKizituSaimuBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportKizituSaimuEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
//import jp.co.pro_app.lacs.common.define.LACSDefine.RisokuKeijoHohoKbn;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

/**
 * 帳票出力：期日別予定表（債務）Model.
 * 
 * @author arai
 * @version 20200617
 */

public class LACSReportPDFKizitubetuSaimuWriter extends LACSReportPDFWriterBase {

	private Report				        report					        = null;				     // WebKCoreレポートオブジェクト

	private LACSReportKizituSaimuBean	detail					        = null;

	private long				        souPage					        = 0;					// 総ページ数

	private long				        page					        = 0;					// ページ

	private int					        lineCount				        = 0;					// 明細カウンタ

	private String				        index					        = "";					// 明細行修飾子
	
	private int					        MAX_LINE				        = 5;					// 明細行数
	
	
	private long                       mikeikaLeaseOne0                 = 0;                    // 未経過リース料(1年以内)
	
	private long                       mikeikaLeaseTwo0                 = 0;                    // 未経過リース料(2年以内)
	
	private long                       mikeikaLeaseThree0               = 0;                    // 未経過リース料(3年以内)
	
    private long                       mikeikaLeaseFour0                = 0;                    // 未経過リース料(4年以内)
	
	private long                       mikeikaLeaseFive0                = 0;                    // 未経過リース料(5年以内)
	
	private long                       mikeikaLeaseOverFive0            = 0;                    // 未経過リース料(5年超)
	
	private long                       mikeikaLeaseTotal0               = 0;                    // 未経過リース料(合計)
	
	
	private long                       mikeikaLeaseOne1                 = 0;                    // 未経過リース料(1年以内)
	
	private long                       mikeikaLeaseTwo1                 = 0;                    // 未経過リース料(2年以内)
	
	private long                       mikeikaLeaseThree1               = 0;                    // 未経過リース料(3年以内)
	
    private long                       mikeikaLeaseFour1                = 0;                    // 未経過リース料(4年以内)
	
	private long                       mikeikaLeaseFive1                = 0;                    // 未経過リース料(5年以内)
	
	private long                       mikeikaLeaseOverFive1            = 0;                    // 未経過リース料(5年超)
	
	private long                       mikeikaLeaseTotal1               = 0;                    // 未経過リース料(合計)
	
	
	private long                       mikeikaLeaseOne2                 = 0;                    // 未経過リース料(1年以内)
	
	private long                       mikeikaLeaseTwo2                 = 0;                    // 未経過リース料(2年以内)
	
	private long                       mikeikaLeaseThree2               = 0;                    // 未経過リース料(3年以内)
	
    private long                       mikeikaLeaseFour2                = 0;                    // 未経過リース料(4年以内)
	
	private long                       mikeikaLeaseFive2                = 0;                    // 未経過リース料(5年以内)
	
	private long                       mikeikaLeaseOverFive2            = 0;                    // 未経過リース料(5年超)

	private long                       mikeikaLeaseTotal2               = 0;                    // 未経過リース料(合計)
	
	
	private long                       mikeikaLeaseOne3                 = 0;                    // 未経過リース料(1年以内)

	private long                       mikeikaLeaseTwo3                 = 0;                    // 未経過リース料(2年以内)
	
	private long                       mikeikaLeaseThree3               = 0;                    // 未経過リース料(3年以内)
	
    private long                       mikeikaLeaseFour3                = 0;                    // 未経過リース料(4年以内)
	
	private long                       mikeikaLeaseFive3                = 0;                    // 未経過リース料(5年以内)
	
	private long                       mikeikaLeaseOverFive3            = 0;                    // 未経過リース料(5年超)
	
	private long                       mikeikaLeaseTotal3               = 0;                    // 未経過リース料(合計)
	
	
	private long                       mikeikaLeaseOne4                 = 0;                    // 未経過リース料(1年以内)

	private long                       mikeikaLeaseTwo4                 = 0;                    // 未経過リース料(2年以内)
	
	private long                       mikeikaLeaseThree4               = 0;                    // 未経過リース料(3年以内)
	
    private long                       mikeikaLeaseFour4                = 0;                    // 未経過リース料(4年以内)
	
	private long                       mikeikaLeaseFive4                = 0;                    // 未経過リース料(5年以内)
	
	private long                       mikeikaLeaseOverFive4            = 0;                    // 未経過リース料(5年超)

	private long                       mikeikaLeaseTotal4               = 0;                    // 未経過リース料(合計)
	
	
	private long                       mikeikaLeaseOne5                 = 0;                    // 未経過リース料(1年以内)

	private long                       mikeikaLeaseTwo5                 = 0;                    // 未経過リース料(2年以内)
	
	private long                       mikeikaLeaseThree5               = 0;                    // 未経過リース料(3年以内)
	
    private long                       mikeikaLeaseFour5                = 0;                    // 未経過リース料(4年以内)
	
	private long                       mikeikaLeaseFive5                = 0;                    // 未経過リース料(5年以内)
	
	private long                       mikeikaLeaseOverFive5            = 0;                    // 未経過リース料(5年超)

	private long                       mikeikaLeaseTotal5               = 0;                    // 未経過リース料(合計)
	
	private long                       mikeikaLeaseOne                 = 0;                    // 未経過リース料(1年以内)

	private long                       mikeikaLeaseTwo                 = 0;                    // 未経過リース料(2年以内)
	
	private long                       mikeikaLeaseThree               = 0;                    // 未経過リース料(3年以内)
	
    private long                       mikeikaLeaseFour                = 0;                    // 未経過リース料(4年以内)
	
	private long                       mikeikaLeaseFive                = 0;                    // 未経過リース料(年以内)
	
	private long                       mikeikaLeaseOverFive            = 0;                    // 未経過リース料(年超)

	private long                       mikeikaLeaseTotal               = 0;                    // 未経過リース料(合計)

	
	private long                       zankaHosyoOne0                 = 0;                    // 残価保証額(1年以内)
	
	private long                       zankaHosyoTwo0                 = 0;                    // 残価保証額(2年以内)
	
	private long                       zankaHosyoThree0               = 0;                    // 残価保証額(3年以内)
	
    private long                       zankaHosyoFour0                = 0;                    // 残価保証額(4年以内)
	
	private long                       zankaHosyoFive0                = 0;                    // 残価保証額(5年以内)
	
	private long                       zankaHosyoOverFive0            = 0;                    // 残価保証額(5年超)
	
	private long                       zankaHosyoTotal0               = 0;                    // 残価保証額(合計)
	
	
	private long                       zankaHosyoOne1                 = 0;                    // 残価保証額(1年以内)
	
	private long                       zankaHosyoTwo1                 = 0;                    // 残価保証額(2年以内)
	
	private long                       zankaHosyoThree1               = 0;                    // 残価保証額(3年以内)
	
    private long                       zankaHosyoFour1                = 0;                    // 残価保証額(4年以内)
	
	private long                       zankaHosyoFive1                = 0;                    // 残価保証額(5年以内)
	
	private long                       zankaHosyoOverFive1            = 0;                    // 残価保証額(5年超)
	
	private long                       zankaHosyoTotal1               = 0;                    // 残価保証額(合計)
	
	
	private long                       zankaHosyoOne2                 = 0;                    // 残価保証額(1年以内)
	
	private long                       zankaHosyoTwo2                 = 0;                    // 残価保証額(2年以内)
	
	private long                       zankaHosyoThree2               = 0;                    // 残価保証額(3年以内)
	
    private long                       zankaHosyoFour2                = 0;                    // 残価保証額(4年以内)
	
	private long                       zankaHosyoFive2                = 0;                    // 残価保証額(5年以内)
	
	private long                       zankaHosyoOverFive2            = 0;                    // 残価保証額(5年超)

	private long                       zankaHosyoTotal2               = 0;                    // 残価保証額(合計)
	
	
	private long                       zankaHosyoOne3                 = 0;                    // 残価保証額(1年以内)

	private long                       zankaHosyoTwo3                 = 0;                    // 残価保証額(2年以内)
	
	private long                       zankaHosyoThree3               = 0;                    // 残価保証額(3年以内)
	
    private long                       zankaHosyoFour3                = 0;                    // 残価保証額(4年以内)
	
	private long                       zankaHosyoFive3                = 0;                    // 残価保証額(5年以内)
	
	private long                       zankaHosyoOverFive3            = 0;                    // 残価保証額(5年超)
	
	private long                       zankaHosyoTotal3               = 0;                    // 残価保証額(合計)
	
	
	private long                       zankaHosyoOne4                 = 0;                    // 残価保証額(1年以内)

	private long                       zankaHosyoTwo4                 = 0;                    // 残価保証額(2年以内)
	
	private long                       zankaHosyoThree4               = 0;                    // 残価保証額(3年以内)
	
    private long                       zankaHosyoFour4                = 0;                    // 残価保証額(4年以内)
	
	private long                       zankaHosyoFive4                = 0;                    // 残価保証額(5年以内)
	
	private long                       zankaHosyoOverFive4            = 0;                    // 残価保証額(5年超)

	private long                       zankaHosyoTotal4               = 0;                    // 残価保証額(合計)
	
	
	private long                       zankaHosyoOne5                 = 0;                    // 残価保証額(1年以内)

	private long                       zankaHosyoTwo5                 = 0;                    // 残価保証額(2年以内)
	
	private long                       zankaHosyoThree5               = 0;                    // 残価保証額(3年以内)
	
    private long                       zankaHosyoFour5                = 0;                    // 残価保証額(4年以内)
	
	private long                       zankaHosyoFive5                = 0;                    // 残価保証額(5年以内)
	
	private long                       zankaHosyoOverFive5            = 0;                    // 残価保証額(5年超)

	private long                       zankaHosyoTotal5               = 0;                    // 残価保証額(合計)
	

	private long                       zankaHosyoOne                 = 0;                    // 残価保証額(1年以内)

	private long                       zankaHosyoTwo                 = 0;                    // 残価保証額(2年以内)
	
	private long                       zankaHosyoThree               = 0;                    // 残価保証額(3年以内)
	
    private long                       zankaHosyoFour                = 0;                    // 残価保証額(4年以内)
	
	private long                       zankaHosyoFive                = 0;                    // 残価保証額(年以内)
	
	private long                       zankaHosyoOverFive            = 0;                    // 残価保証額(年超)

	private long                       zankaHosyoTotal               = 0;                    // 残価保証額(合計)
	
	
	private long                       gnpnOne0                 = 0;                    // 元本(1年以内)
	
	private long                       gnpnTwo0                 = 0;                    // 元本(2年以内)
	
	private long                       gnpnThree0               = 0;                    // 元本(3年以内)
	
    private long                       gnpnFour0                = 0;                    // 元本(4年以内)
	
	private long                       gnpnFive0                = 0;                    // 元本(5年以内)
	
	private long                       gnpnOverFive0            = 0;                    // 元本(5年超)
	
	private long                       gnpnTotal0               = 0;                    // 元本(合計)
	
	
	private long                       gnpnOne1                 = 0;                    // 元本(1年以内)
	
	private long                       gnpnTwo1                 = 0;                    // 元本(2年以内)
	
	private long                       gnpnThree1               = 0;                    // 元本(3年以内)
	
    private long                       gnpnFour1                = 0;                    // 元本(4年以内)
	
	private long                       gnpnFive1                = 0;                    // 元本(5年以内)
	
	private long                       gnpnOverFive1            = 0;                    // 元本(5年超)
	
	private long                       gnpnTotal1               = 0;                    // 元本(合計)
	
	
	private long                       gnpnOne2                 = 0;                    // 元本(1年以内)
	
	private long                       gnpnTwo2                 = 0;                    // 元本(2年以内)
	
	private long                       gnpnThree2               = 0;                    // 元本(3年以内)
	
    private long                       gnpnFour2                = 0;                    // 元本(4年以内)
	
	private long                       gnpnFive2                = 0;                    // 元本(5年以内)
	
	private long                       gnpnOverFive2            = 0;                    // 元本(5年超)

	private long                       gnpnTotal2               = 0;                    // 元本(合計)
	
	
	private long                       gnpnOne3                 = 0;                    // 元本(1年以内)

	private long                       gnpnTwo3                 = 0;                    // 元本(2年以内)
	
	private long                       gnpnThree3               = 0;                    // 元本(3年以内)
	
    private long                       gnpnFour3                = 0;                    // 元本(4年以内)
	
	private long                       gnpnFive3                = 0;                    // 元本(5年以内)
	
	private long                       gnpnOverFive3            = 0;                    // 元本(5年超)
	
	private long                       gnpnTotal3               = 0;                    // 元本(合計)
	
	
	private long                       gnpnOne4                 = 0;                    // 元本(1年以内)

	private long                       gnpnTwo4                 = 0;                    // 元本(2年以内)
	
	private long                       gnpnThree4               = 0;                    // 元本(3年以内)
	
    private long                       gnpnFour4                = 0;                    // 元本(4年以内)
	
	private long                       gnpnFive4                = 0;                    // 元本(5年以内)
	
	private long                       gnpnOverFive4            = 0;                    // 元本(5年超)

	private long                       gnpnTotal4               = 0;                    // 元本(合計)
	
	
	private long                       gnpnOne5                 = 0;                    // 元本(1年以内)

	private long                       gnpnTwo5                 = 0;                    // 元本(2年以内)
	
	private long                       gnpnThree5               = 0;                    // 元本(3年以内)
	
    private long                       gnpnFour5                = 0;                    // 元本(4年以内)
	
	private long                       gnpnFive5                = 0;                    // 元本(5年以内)
	
	private long                       gnpnOverFive5            = 0;                    // 元本(5年超)

	private long                       gnpnTotal5               = 0;                    // 元本(合計)

	
	private long                       gnpnOne                 = 0;                    // 元本(1年以内)

	private long                       gnpnTwo                 = 0;                    // 元本(2年以内)
	
	private long                       gnpnThree               = 0;                    // 元本(3年以内)
	
    private long                       gnpnFour                = 0;                    // 元本(4年以内)
	
	private long                       gnpnFive                = 0;                    // 元本(年以内)
	
	private long                       gnpnOverFive            = 0;                    // 元本(年超)

	private long                       gnpnTotal               = 0;                    // 元本(合計)
	
	private long                       rskOne0                 = 0;                    // 利息(1年以内)
	
	private long                       rskTwo0                 = 0;                    // 利息(2年以内)
	
	private long                       rskThree0               = 0;                    // 利息(3年以内)
	
    private long                       rskFour0                = 0;                    // 利息(4年以内)
	
	private long                       rskFive0                = 0;                    // 利息(5年以内)
	
	private long                       rskOverFive0            = 0;                    // 利息(5年超)
	
	private long                       rskTotal0               = 0;                    // 利息(合計)
	
	
	private long                       rskOne1                 = 0;                    // 利息(1年以内)
	
	private long                       rskTwo1                 = 0;                    // 利息(2年以内)
	
	private long                       rskThree1               = 0;                    // 利息(3年以内)
	
    private long                       rskFour1                = 0;                    // 利息(4年以内)
	
	private long                       rskFive1                = 0;                    // 利息(5年以内)
	
	private long                       rskOverFive1            = 0;                    // 利息(5年超)
	
	private long                       rskTotal1               = 0;                    // 利息(合計)
	
	
	private long                       rskOne2                 = 0;                    // 利息(1年以内)
	
	private long                       rskTwo2                 = 0;                    // 利息(2年以内)
	
	private long                       rskThree2               = 0;                    // 利息(3年以内)
	
    private long                       rskFour2                = 0;                    // 利息(4年以内)
	
	private long                       rskFive2                = 0;                    // 利息(5年以内)
	
	private long                       rskOverFive2            = 0;                    // 利息(5年超)

	private long                       rskTotal2               = 0;                    // 利息(合計)
	
	
	private long                       rskOne3                 = 0;                    // 利息(1年以内)

	private long                       rskTwo3                 = 0;                    // 利息(2年以内)
	
	private long                       rskThree3               = 0;                    // 利息(3年以内)
	
    private long                       rskFour3                = 0;                    // 利息(4年以内)
	
	private long                       rskFive3                = 0;                    // 利息(5年以内)
	
	private long                       rskOverFive3            = 0;                    // 利息(5年超)
	
	private long                       rskTotal3               = 0;                    // 利息(合計)
	
	
	private long                       rskOne4                 = 0;                    // 利息(1年以内)

	private long                       rskTwo4                 = 0;                    // 利息(2年以内)
	
	private long                       rskThree4               = 0;                    // 利息(3年以内)
	
    private long                       rskFour4                = 0;                    // 利息(4年以内)
	
	private long                       rskFive4                = 0;                    // 利息(5年以内)
	
	private long                       rskOverFive4            = 0;                    // 利息(5年超)

	private long                       rskTotal4               = 0;                    // 利息(合計)
	
	
	private long                       rskOne5                 = 0;                    // 利息(1年以内)

	private long                       rskTwo5                 = 0;                    // 利息(2年以内)
	
	private long                       rskThree5               = 0;                    // 利息(3年以内)
	
    private long                       rskFour5                = 0;                    // 利息(4年以内)
	
	private long                       rskFive5                = 0;                    // 利息(5年以内)
	
	private long                       rskOverFive5            = 0;                    // 利息(5年超)

	private long                       rskTotal5               = 0;                    // 利息(合計)
	

	private long                       rskOne                 = 0;                    // 利息(1年以内)

	private long                       rskTwo                 = 0;                    // 利息(2年以内)
	
	private long                       rskThree               = 0;                    // 利息(3年以内)
	
    private long                       rskFour                = 0;                    // 利息(4年以内)
	
	private long                       rskFive                = 0;                    // 利息(年以内)
	
	private long                       rskOverFive            = 0;                    // 利息(年超)

	private long                       rskTotal               = 0;                    // 利息(合計)
	
	
	private long                       ijiOne0                 = 0;                    // 維持管理費(1年以内)
	
	private long                       ijiTwo0                 = 0;                    // 維持管理費(2年以内)
	
	private long                       ijiThree0               = 0;                    // 維持管理費(3年以内)
	
    private long                       ijiFour0                = 0;                    // 維持管理費(4年以内)
	
	private long                       ijiFive0                = 0;                    // 維持管理費(5年以内)
	
	private long                       ijiOverFive0            = 0;                    // 維持管理費(5年超)
	
	private long                       ijiTotal0               = 0;                    // 維持管理費(合計)
		
	private long                       ijiOne1                 = 0;                    // 維持管理費(1年以内)
	
	private long                       ijiTwo1                 = 0;                    // 維持管理費(2年以内)
	
	private long                       ijiThree1               = 0;                    // 維持管理費(3年以内)
	
    private long                       ijiFour1                = 0;                    // 維持管理費(4年以内)
	
	private long                       ijiFive1                = 0;                    // 維持管理費(5年以内)
	
	private long                       ijiOverFive1            = 0;                    // 維持管理費(5年超)
	
	private long                       ijiTotal1               = 0;                    // 維持管理費(合計)
	
	
	private long                       ijiOne2                 = 0;                    // 維持管理費(1年以内)
	
	private long                       ijiTwo2                 = 0;                    // 維持管理費(2年以内)
	
	private long                       ijiThree2               = 0;                    // 維持管理費(3年以内)
	
    private long                       ijiFour2                = 0;                    // 維持管理費(4年以内)
	
	private long                       ijiFive2                = 0;                    // 維持管理費(5年以内)
	
	private long                       ijiOverFive2            = 0;                    // 維持管理費(5年超)

	private long                       ijiTotal2               = 0;                    // 維持管理費(合計)
	
	
	private long                       ijiOne3                 = 0;                    // 維持管理費(1年以内)

	private long                       ijiTwo3                 = 0;                    // 維持管理費(2年以内)
	
	private long                       ijiThree3               = 0;                    // 維持管理費(3年以内)
	
    private long                       ijiFour3                = 0;                    // 維持管理費(4年以内)
	
	private long                       ijiFive3                = 0;                    // 維持管理費(5年以内)
	
	private long                       ijiOverFive3            = 0;                    // 維持管理費(5年超)
	
	private long                       ijiTotal3               = 0;                    // 維持管理費(合計)
	
	
	private long                       ijiOne4                 = 0;                    // 維持管理費(1年以内)

	private long                       ijiTwo4                 = 0;                    // 維持管理費(2年以内)
	
	private long                       ijiThree4               = 0;                    // 維持管理費(3年以内)
	
    private long                       ijiFour4                = 0;                    // 維持管理費(4年以内)
	
	private long                       ijiFive4                = 0;                    // 維持管理費(5年以内)
	
	private long                       ijiOverFive4            = 0;                    // 維持管理費(5年超)

	private long                       ijiTotal4               = 0;                    // 維持管理費(合計)
	
	
	private long                       ijiOne5                 = 0;                    // 維持管理費(1年以内)

	private long                       ijiTwo5                 = 0;                    // 維持管理費(2年以内)
	
	private long                       ijiThree5               = 0;                    // 維持管理費(3年以内)
	
    private long                       ijiFour5                = 0;                    // 維持管理費(4年以内)
	
	private long                       ijiFive5                = 0;                    // 維持管理費(5年以内)
	
	private long                       ijiOverFive5            = 0;                    // 維持管理費(5年超)

	private long                       ijiTotal5               = 0;                    // 維持管理費(合計)

	private long                       ijiOne                 = 0;                    // 維持管理費(1年以内)

	private long                       ijiTwo                 = 0;                    // 維持管理費(2年以内)
	
	private long                       ijiThree               = 0;                    // 維持管理費(3年以内)
	
    private long                       ijiFour                = 0;                    // 維持管理費(4年以内)
	
	private long                       ijiFive                = 0;                    // 維持管理費(年以内)
	
	private long                       ijiOverFive            = 0;                    // 維持管理費(年超)

	private long                       ijiTotal               = 0;                    // 維持管理費(合計)
	
	
	
	private long                       ekimOne0                 = 0;                    // 役務提供費(1年以内)
	
	private long                       ekimTwo0                 = 0;                    // 役務提供費(2年以内)
	
	private long                       ekimThree0               = 0;                    // 役務提供費(3年以内)
	
    private long                       ekimFour0                = 0;                    // 役務提供費(4年以内)
	
	private long                       ekimFive0                = 0;                    // 役務提供費(5年以内)
	
	private long                       ekimOverFive0            = 0;                    // 役務提供費(5年超)
	
	private long                       ekimTotal0               = 0;                    // 役務提供費(合計)
	
	
	private long                       ekimOne1                 = 0;                    // 役務提供費(1年以内)
	
	private long                       ekimTwo1                 = 0;                    // 役務提供費(2年以内)
	
	private long                       ekimThree1               = 0;                    // 役務提供費(3年以内)
	
    private long                       ekimFour1                = 0;                    // 役務提供費(4年以内)
	
	private long                       ekimFive1                = 0;                    // 役務提供費(5年以内)
	
	private long                       ekimOverFive1            = 0;                    // 役務提供費(5年超)
	
	private long                       ekimTotal1               = 0;                    // 役務提供費(合計)
	
	
	private long                       ekimOne2                 = 0;                    // 役務提供費(1年以内)
	
	private long                       ekimTwo2                 = 0;                    // 役務提供費(2年以内)
	
	private long                       ekimThree2               = 0;                    // 役務提供費(3年以内)
	
    private long                       ekimFour2                = 0;                    // 役務提供費(4年以内)
	
	private long                       ekimFive2                = 0;                    // 役務提供費(5年以内)
	
	private long                       ekimOverFive2            = 0;                    // 役務提供費(5年超)

	private long                       ekimTotal2               = 0;                    // 役務提供費(合計)
	
	
	private long                       ekimOne3                 = 0;                    // 役務提供費(1年以内)

	private long                       ekimTwo3                 = 0;                    // 役務提供費(2年以内)
	
	private long                       ekimThree3               = 0;                    // 役務提供費(3年以内)
	
    private long                       ekimFour3                = 0;                    // 役務提供費(4年以内)
	
	private long                       ekimFive3                = 0;                    // 役務提供費(5年以内)
	
	private long                       ekimOverFive3            = 0;                    // 役務提供費(5年超)
	
	private long                       ekimTotal3               = 0;                    // 役務提供費(合計)
	
	
	private long                       ekimOne4                 = 0;                    // 役務提供費(1年以内)

	private long                       ekimTwo4                 = 0;                    // 役務提供費(2年以内)
	
	private long                       ekimThree4               = 0;                    // 役務提供費(3年以内)
	
    private long                       ekimFour4                = 0;                    // 役務提供費(4年以内)
	
	private long                       ekimFive4                = 0;                    // 役務提供費(5年以内)
	
	private long                       ekimOverFive4            = 0;                    // 役務提供費(5年超)

	private long                       ekimTotal4               = 0;                    // 役務提供費(合計)
	
	
	private long                       ekimOne5                 = 0;                    // 役務提供費(1年以内)

	private long                       ekimTwo5                 = 0;                    // 役務提供費(2年以内)
	
	private long                       ekimThree5               = 0;                    // 役務提供費(3年以内)
	
    private long                       ekimFour5                = 0;                    // 役務提供費(4年以内)
	
	private long                       ekimFive5                = 0;                    // 役務提供費(5年以内)
	
	private long                       ekimOverFive5            = 0;                    // 役務提供費(5年超)

	private long                       ekimTotal5               = 0;                    // 役務提供費(合計)

	
	private long                       ekimOne                 = 0;                    // 役務提供費(1年以内)

	private long                       ekimTwo                 = 0;                    // 役務提供費(2年以内)
	
	private long                       ekimThree               = 0;                    // 役務提供費(3年以内)
	
    private long                       ekimFour                = 0;                    // 役務提供費(4年以内)
	
	private long                       ekimFive                = 0;                    // 役務提供費(年以内)
	
	private long                       ekimOverFive            = 0;                    // 役務提供費(年超)

	private long                       ekimTotal               = 0;                    // 役務提供費(合計)
	
    private long                       staxOne0                 = 0;                    // 消費税等(0年以内)
	
	private long                       staxTwo0                 = 0;                    // 消費税等(2年以内)
	
	private long                       staxThree0               = 0;                    // 消費税等(3年以内)
	
    private long                       staxFour0                = 0;                    // 消費税等(4年以内)
	
	private long                       staxFive0                = 0;                    // 消費税等(5年以内)
	
	private long                       staxOverFive0            = 0;                    // 消費税等(5年超)
	
	private long                       staxTotal0               = 0;                    // 消費税等(合計)
	

	private long                       staxOne1                 = 0;                    // 消費税等(1年以内)
	
	private long                       staxTwo1                 = 0;                    // 消費税等(2年以内)
	
	private long                       staxThree1               = 0;                    // 消費税等(3年以内)
	
    private long                       staxFour1                = 0;                    // 消費税等(4年以内)
	
	private long                       staxFive1                = 0;                    // 消費税等(5年以内)
	
	private long                       staxOverFive1            = 0;                    // 消費税等(5年超)
	
	private long                       staxTotal1               = 0;                    // 消費税等(合計)
	
	
	private long                       staxOne2                 = 0;                    // 消費税等(1年以内)
	
	private long                       staxTwo2                 = 0;                    // 消費税等(2年以内)
	
	private long                       staxThree2               = 0;                    // 消費税等(3年以内)
	
    private long                       staxFour2                = 0;                    // 消費税等(4年以内)
	
	private long                       staxFive2                = 0;                    // 消費税等(5年以内)
	
	private long                       staxOverFive2            = 0;                    // 消費税等(5年超)

	private long                       staxTotal2               = 0;                    // 消費税等(合計)
	
	
	private long                       staxOne3                 = 0;                    // 消費税等(1年以内)

	private long                       staxTwo3                 = 0;                    // 消費税等(2年以内)
	
	private long                       staxThree3               = 0;                    // 消費税等(3年以内)
	
    private long                       staxFour3                = 0;                    // 消費税等(4年以内)
	
	private long                       staxFive3                = 0;                    // 消費税等(5年以内)
	
	private long                       staxOverFive3            = 0;                    // 消費税等(5年超)
	
	private long                       staxTotal3               = 0;                    // 消費税等(合計)
	
	
	private long                       staxOne4                 = 0;                    // 消費税等(1年以内)

	private long                       staxTwo4                 = 0;                    // 消費税等(2年以内)
	
	private long                       staxThree4               = 0;                    // 消費税等(3年以内)
	
    private long                       staxFour4                = 0;                    // 消費税等(4年以内)
	
	private long                       staxFive4                = 0;                    // 消費税等(5年以内)
	
	private long                       staxOverFive4            = 0;                    // 消費税等(5年超)

	private long                       staxTotal4               = 0;                    // 消費税等(合計)
	
	
	private long                       staxOne5                 = 0;                    // 消費税等(1年以内)

	private long                       staxTwo5                 = 0;                    // 消費税等(2年以内)
	
	private long                       staxThree5               = 0;                    // 消費税等(3年以内)
	
    private long                       staxFour5                = 0;                    // 消費税等(4年以内)
	
	private long                       staxFive5                = 0;                    // 消費税等(5年以内)
	
	private long                       staxOverFive5            = 0;                    // 消費税等(5年超)

	private long                       staxTotal5               = 0;                    // 消費税等(合計)

	
	private long                       staxOne                 = 0;                    // 消費税等(1年以内)

	private long                       staxTwo                 = 0;                    // 消費税等(2年以内)
	
	private long                       staxThree               = 0;                    // 消費税等(3年以内)
	
    private long                       staxFour                = 0;                    // 消費税等(4年以内)
	
	private long                       staxFive                = 0;                    // 消費税等(年以内)
	
	private long                       staxOverFive            = 0;                    // 消費税等(年超)

	private long                       staxTotal               = 0;                    // 消費税等(合計)	
	
	
	
	
	private static final String		TITLE_OLD				    = "期日別予定表（債務）[旧]";

	private static final String		TITLE_NEW				    = "期日別予定表（債務）[新]";
	
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
		File formFile = new File(formDirectory, "KijitsuSaim.pdf");
		File datFile = new File(formDirectory, "KijitsuSaim.dat");
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
	public LACSReportPDFKizitubetuSaimuWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
	
		LACSReportKizituSaimuEntity reportEntity = new LACSReportKizituSaimuEntity(super.model, commonBean, piReportBean, this.acStd);
		LACSReportKizituSaimuBean saimuDetail = null;

		try {
			reportEntity.setCon(super.con);

			piReportBean.setDataMax(reportEntity.execSQL());
			
			while(reportEntity.next()) {
				saimuDetail = new LACSReportKizituSaimuBean();
				piReportBean.addKizituSaimu(saimuDetail);
				
				saimuDetail.setBrakeKey0(reportEntity.getBreakKey0());
				saimuDetail.setBrakeKey1(reportEntity.getBreakKey1());
				saimuDetail.setBrakeKey2(reportEntity.getBreakKey2());
				saimuDetail.setBrakeKey3(reportEntity.getBreakKey3());
				saimuDetail.setBrakeKey4(reportEntity.getBreakKey4());
				saimuDetail.setBrakeKey5(reportEntity.getBreakKey5());
				
				saimuDetail.setLeaseCompany(reportEntity.getLeaseCompany());
				saimuDetail.setKaizisaki(reportEntity.getKaizisaki());
				saimuDetail.setBaseDate(reportEntity.getBaseDate());
				saimuDetail.setJysiUm(reportEntity.getJysiUm());				
				saimuDetail.setLeaseBunrui(reportEntity.getLeaseBunrui());				
				saimuDetail.setKaikeiSyoriHouhou(reportEntity.getKaikeiSyori());
				saimuDetail.setRisokuBunpaiHouhou(reportEntity.getRisokuBunpaiHouhou());
				saimuDetail.setToukiReaseKeisanKijyun(reportEntity.getToukiReaseRyouKeisanKijyun());
				saimuDetail.setKeiyakuNo(reportEntity.getKeiyakuNo());
				saimuDetail.setLeaseFrom(reportEntity.getLeaseFrom());
				saimuDetail.setLeaseTo(reportEntity.getLeaseTo());
				saimuDetail.setBukenNo(reportEntity.getBukenNo());
				saimuDetail.setBukenName(reportEntity.getBukenNm());
				saimuDetail.setKaiyakuYmd(reportEntity.getKaiyakuYmd());
				
				saimuDetail.setMikeikaLeaseWithinOneYear(reportEntity.getMikeikaLeaseWithinOneYear());
				saimuDetail.setMikeikaLeaseWithinTwoYears(reportEntity.getMikeikaLeaseWithinTwoYears());
				saimuDetail.setMikeikaLeaseWithinThreeYears(reportEntity.getMikeikaLeaseWithinThreeYears());
				saimuDetail.setMikeikaLeaseWithinFourYears(reportEntity.getMikeikaLeaseWithinFourYears());
				saimuDetail.setMikeikaLeaseWithinFiveYears(reportEntity.getMikeikaLeaseWithinFiveYears());
				saimuDetail.setMikeikaLeaseOverFiveYears(reportEntity.getMikeikaLeaseOverFiveYears());
				saimuDetail.setMikeikaLeaseTotal(reportEntity.getMikeikaLeaseTotal());
				
				saimuDetail.setZankaHosyogakuWithinOneYear(reportEntity.getZankaHosyogakuWithinOneYear());
				saimuDetail.setZankaHosyogakuWithinTwoYears(reportEntity.getZankaHosyogakuWithinTwoYears());
				saimuDetail.setZankaHosyogakuWithinThreeYears(reportEntity.getZankaHosyogakuWithinThreeYears());
				saimuDetail.setZankaHosyogakuWithinFourYears(reportEntity.getZankaHosyogakuWithinFourYears());
				saimuDetail.setZankaHosyogakuWithinFiveYears(reportEntity.getZankaHosyogakuWithinFiveYears());
				saimuDetail.setZankaHosyogakuOverFiveYears(reportEntity.getZankaHosyogakuOverFiveYears());
				saimuDetail.setZankaHosyogakuTotal(reportEntity.getZankaHosyogakuTotal());
				
				saimuDetail.setGanponWithinOneYear(reportEntity.getGanponWithinOneYear());
				saimuDetail.setGanponWithinTwoYears(reportEntity.getGanponWithinTwoYears());
				saimuDetail.setGanponWithinThreeYears(reportEntity.getGanponWithinThreeYears());
				saimuDetail.setGanponWithinFourYears(reportEntity.getGanponWithinFourYears());
				saimuDetail.setGanponWithinFiveYears(reportEntity.getGanponWithinFiveYears());
				saimuDetail.setGanponOverFiveYears(reportEntity.getGanponOverFiveYears());
				saimuDetail.setGanponTotal(reportEntity.getGanponTotal());
				
				saimuDetail.setRisokuWithinOneYear(reportEntity.getRisokuWithinOneYear());
				saimuDetail.setRisokuWithinTwoYear(reportEntity.getRisokuWithinTwoYears());
				saimuDetail.setRisokuWithinThreeYears(reportEntity.getRisokuWithinThreeYears());
				saimuDetail.setRisokuWithinFourYears(reportEntity.getRisokuWithinFourYears());
				saimuDetail.setRisokuWithinFiveYears(reportEntity.getRisokuWithinFiveYears());
				saimuDetail.setRisokuOverFiveYears(reportEntity.getRisokuOverFiveYears());
				saimuDetail.setRisokuTotal(reportEntity.getRisokuTotal());
				
				saimuDetail.setIzikanrihiWithinOneYear(reportEntity.getIjiKanrihiWithinOneYear());
				saimuDetail.setIzikanrihiWithinTwoYears(reportEntity.getIjiKanrihiWithinTwoYears());
				saimuDetail.setIzikanrihiWithinThreeYears(reportEntity.getIjiKanrihiWithinThreeYears());
				saimuDetail.setIzikanrihiWithinFourYears(reportEntity.getIjiKanrihiWithinFourYears());
				saimuDetail.setIzikanrihiWithinFiveYears(reportEntity.getIjiKanrihiWithinFiveYears());
				saimuDetail.setIzikanrihiOverFiveYears(reportEntity.getIjiKanrihiOverFiveYears());
				saimuDetail.setIzikanrihiTotal(reportEntity.getIjiKanrihiTotal());
				
				saimuDetail.setEkimuteikyouhiWithinOneYear(reportEntity.getEkimuteikiWithinOneYear());
				saimuDetail.setEkimuteikyouhiWithinTwoYear(reportEntity.getEkimuteikiWithinTwoYears());
				saimuDetail.setEkimuteikyouhiWithinThreeYears(reportEntity.getEkimuteikiWithinThreeYears());
				saimuDetail.setEkimuteikyouhiWithinFourYears(reportEntity.getEkimuteikiWithinFourYears());
				saimuDetail.setEkimuteikyouhiWithinFiveYears(reportEntity.getEkimuteikiWithinFiveYears());
				saimuDetail.setEkimuteikyouhiOverFiveYears(reportEntity.getEkimuteikiOverFiveYears());
				saimuDetail.setEkimuteikyouhiTotal(reportEntity.getEkimuteikiTotal());
				
				saimuDetail.setSyohizeiWithinOneYear(reportEntity.getSyohizeiWithinOneYear());
				saimuDetail.setSyohizeiWithinTwoYears(reportEntity.getSyohizeiWithinTwoYears());
				saimuDetail.setSyohizeiWithinThreeYears(reportEntity.getSyohizeiWithinThreeYears());
				saimuDetail.setSyohizeiWithinFourYears(reportEntity.getSyohizeiWithinFourYears());
				saimuDetail.setSyohizeiWithinFiveYears(reportEntity.getSyohizeiWithinFiveYears());
				saimuDetail.setSyohizeiOverFiveYears(reportEntity.getSyohizeiOverFiveYears());
				saimuDetail.setSyohizeiTotal(reportEntity.getSyohizeiTotal());
				
	
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

		//File tmpFile = null; // 出力先ファイル
		//FileOutputStream fout = null; // 出力ファイルストリーム
		//report = null; // WebKCoreレポートオブジェクト
		detail = null;
		lineCount = 0; // 明細カウンタ
		index = ""; // 明細行カウンタ
		Field field = null;
				
		String brakeKey1 = ""; // ブレイクキー1
		String brakeKey2 = ""; // ブレイクキー2
		String brakeKey3 = ""; // ブレイクキー3
		String brakeKey4 = ""; // ブレイクキー4
		String brakeKey5 = ""; // ブレイクキー5


		try {
			
			// 未経過リース料(1年以内)
			mikeikaLeaseOne0 = 0;
			mikeikaLeaseOne1 = 0;
			mikeikaLeaseOne2 = 0;
			mikeikaLeaseOne3 = 0;
			mikeikaLeaseOne4 = 0;
			mikeikaLeaseOne5 = 0;
			
			// 未経過リース料(2年以内)
			mikeikaLeaseTwo0 = 0;
			mikeikaLeaseTwo1 = 0;
			mikeikaLeaseTwo2 = 0;
			mikeikaLeaseTwo3 = 0;
			mikeikaLeaseTwo4 = 0;
			mikeikaLeaseTwo5 = 0;
			
			// 未経過リース料(3年以内)
			mikeikaLeaseThree0 = 0;
			mikeikaLeaseThree1 = 0;
			mikeikaLeaseThree2 = 0;
			mikeikaLeaseThree3 = 0;
			mikeikaLeaseThree4 = 0;
			mikeikaLeaseThree5 = 0;
			
			// 未経過リース料(4年以内)
			mikeikaLeaseFour0 = 0;
			mikeikaLeaseFour1 = 0;
			mikeikaLeaseFour2 = 0;
			mikeikaLeaseFour3 = 0;
			mikeikaLeaseFour4 = 0;
			mikeikaLeaseFour5 = 0;
			
			// 未経過リース料(5年以内)
			mikeikaLeaseFive0 = 0;
			mikeikaLeaseFive1 = 0;
			mikeikaLeaseFive2 = 0;
			mikeikaLeaseFive3 = 0;
			mikeikaLeaseFive4 = 0;
			mikeikaLeaseFive5 = 0;
			
			// 未経過リース料(5年超)
			mikeikaLeaseOverFive0 = 0;
			mikeikaLeaseOverFive1 = 0;
			mikeikaLeaseOverFive2 = 0;
			mikeikaLeaseOverFive3 = 0;
			mikeikaLeaseOverFive4 = 0;
			mikeikaLeaseOverFive5 = 0;
			
			// 未経過リース料(合計)
			mikeikaLeaseTotal0 = 0;
			mikeikaLeaseTotal1 = 0;
			mikeikaLeaseTotal2 = 0;
			mikeikaLeaseTotal3 = 0;
			mikeikaLeaseTotal4 = 0;
			mikeikaLeaseTotal5 = 0;
			
			// 残価保証額(1年以内)
			zankaHosyoOne0 = 0;
			zankaHosyoOne1 = 0;
			zankaHosyoOne2 = 0;
			zankaHosyoOne3 = 0;
			zankaHosyoOne4 = 0;
			zankaHosyoOne5 = 0;			
			
			// 残価保証額(2年以内)
			zankaHosyoTwo0 = 0;
			zankaHosyoTwo1 = 0;
			zankaHosyoTwo2 = 0;
			zankaHosyoTwo3 = 0;
			zankaHosyoTwo4 = 0;
			zankaHosyoTwo5 = 0;
			
			// 残価保証額(3年以内)
			zankaHosyoThree0 = 0;
			zankaHosyoThree1 = 0;
			zankaHosyoThree2 = 0;
			zankaHosyoThree3 = 0;
			zankaHosyoThree4 = 0;
			zankaHosyoThree5 = 0;
			
			// 残価保証額(4年以内)
			zankaHosyoFour0 = 0;
			zankaHosyoFour1 = 0;
			zankaHosyoFour2 = 0;
			zankaHosyoFour3 = 0;
			zankaHosyoFour4 = 0;
			zankaHosyoFour5 = 0;			
			
			// 残価保証額(5年以内)
			zankaHosyoFive0 = 0;
			zankaHosyoFive1 = 0;
			zankaHosyoFive2 = 0;
			zankaHosyoFive3 = 0;
			zankaHosyoFive4 = 0;
			zankaHosyoFive5 = 0;
			
			// 残価保証額(5年超)
			zankaHosyoOverFive0 = 0;
			zankaHosyoOverFive1 = 0;
			zankaHosyoOverFive2 = 0;
			zankaHosyoOverFive3 = 0;
			zankaHosyoOverFive4 = 0;
			zankaHosyoOverFive5 = 0;
			
			// 残価保証額(合計)
			zankaHosyoTotal0 = 0;
			zankaHosyoTotal1 = 0;
			zankaHosyoTotal2 = 0;
			zankaHosyoTotal3 = 0;
			zankaHosyoTotal4 = 0;
			zankaHosyoTotal5 = 0;
			
			// 元本(1年以内)
			gnpnOne0 = 0;
			gnpnOne1 = 0;
			gnpnOne2 = 0;
			gnpnOne3 = 0;
			gnpnOne4 = 0;
			gnpnOne5 = 0;
			
			// 元本(2年以内)
			gnpnTwo0 = 0;
			gnpnTwo1 = 0;
			gnpnTwo2 = 0;
			gnpnTwo3 = 0;
			gnpnTwo4 = 0;
			gnpnTwo5 = 0;
			
			// 元本(3年以内)
			gnpnThree0 = 0;
			gnpnThree1 = 0;
			gnpnThree2 = 0;
			gnpnThree3 = 0;
			gnpnThree4 = 0;
			gnpnThree5 = 0;
			
			// 元本(4年以内)
			gnpnFour0 = 0;
			gnpnFour1 = 0;
			gnpnFour2 = 0;
			gnpnFour3 = 0;
			gnpnFour4 = 0;
			gnpnFour5 = 0;
			
			// 元本(5年以内)
			gnpnFive0 = 0;
			gnpnFive1 = 0;
			gnpnFive2 = 0;
			gnpnFive3 = 0;
			gnpnFive4 = 0;
			gnpnFive5 = 0;
			
			// 元本(5年超)
			gnpnOverFive0 = 0;
			gnpnOverFive1 = 0;
			gnpnOverFive2 = 0;
			gnpnOverFive3 = 0;
			gnpnOverFive4 = 0;
			gnpnOverFive5 = 0;
			
			// 元本(合計)
			gnpnTotal0 = 0;
			gnpnTotal1 = 0;
			gnpnTotal2 = 0;
			gnpnTotal3 = 0;
			gnpnTotal4 = 0;
			gnpnTotal5 = 0;
			
			// 利息(1年以内)
			rskOne0 = 0;
			rskOne1 = 0;
			rskOne2 = 0;
			rskOne3 = 0;
			rskOne4 = 0;
			rskOne5 = 0;
			
			// 利息(2年以内)
			rskTwo0 = 0;
			rskTwo1 = 0;
			rskTwo2 = 0;
			rskTwo3 = 0;
			rskTwo4 = 0;
			rskTwo5 = 0;
			
			// 利息(3年以内)
			rskThree0 = 0;
			rskThree1 = 0;
			rskThree2 = 0;
			rskThree3 = 0;
			rskThree4 = 0;
			rskThree5 = 0;
			
			// 利息(4年以内)
			rskFour0 = 0;
			rskFour1 = 0;
			rskFour2 = 0;
			rskFour3 = 0;
			rskFour4 = 0;
			rskFour5 = 0;
			
			// 利息(5年以内)
			rskFive0 = 0;
			rskFive1 = 0;
			rskFive2 = 0;
			rskFive3 = 0;
			rskFive4 = 0;
			rskFive5 = 0;
			
			// 利息(5年超)
			rskOverFive0 = 0;
			rskOverFive1 = 0;
			rskOverFive2 = 0;
			rskOverFive3 = 0;
			rskOverFive4 = 0;
			rskOverFive5 = 0;
			
			// 利息(合計)
			rskTotal0 = 0;
			rskTotal1 = 0;
			rskTotal2 = 0;
			rskTotal3 = 0;
			rskTotal4 = 0;
			rskTotal5 = 0;
			
			// 維持管理費(1年以内)
			ijiOne0 = 0;
			ijiOne1 = 0;
			ijiOne2 = 0;
			ijiOne3 = 0;
			ijiOne4 = 0;
			ijiOne5 = 0;
			
			// 維持管理費(2年以内)
			ijiTwo0 = 0;
			ijiTwo1 = 0;
			ijiTwo2 = 0;
			ijiTwo3 = 0;
			ijiTwo4 = 0;
			ijiTwo5 = 0;
			
			// 維持管理費(3年以内)
			ijiThree0 = 0;
			ijiThree1 = 0;
			ijiThree2 = 0;
			ijiThree3 = 0;
			ijiThree4 = 0;
			ijiThree5 = 0;
			
			// 維持管理費(4年以内)
			ijiFour0 = 0;
			ijiFour1 = 0;
			ijiFour2 = 0;
			ijiFour3 = 0;
			ijiFour4 = 0;
			ijiFour5 = 0;
			
			// 維持管理費(5年以内)
			ijiFive0 = 0;
			ijiFive1 = 0;
			ijiFive2 = 0;
			ijiFive3 = 0;
			ijiFive4 = 0;
			ijiFive5 = 0;
			
			// 維持管理費(5年超)
			ijiOverFive0 = 0;
			ijiOverFive1 = 0;
			ijiOverFive2 = 0;
			ijiOverFive3 = 0;
			ijiOverFive4 = 0;
			ijiOverFive5 = 0;
			
			// 維持管理費(合計)
			ijiTotal0 = 0;
			ijiTotal1 = 0;
			ijiTotal2 = 0;
			ijiTotal3 = 0;
			ijiTotal4 = 0;
			ijiTotal5 = 0;
			
			// 役務提供費(1年以内)
			ekimOne0 = 0;
			ekimOne1 = 0;
			ekimOne2 = 0;
			ekimOne3 = 0;
			ekimOne4 = 0;
			ekimOne5 = 0;
			
			// 役務提供費(2年以内)
			ekimTwo0 = 0;
			ekimTwo1 = 0;
			ekimTwo2 = 0;
			ekimTwo3 = 0;
			ekimTwo4 = 0;
			ekimTwo5 = 0;
			
			// 役務提供費(3年以内)
			ekimThree0 = 0;
			ekimThree1 = 0;
			ekimThree2 = 0;
			ekimThree3 = 0;
			ekimThree4 = 0;
			ekimThree5 = 0;
			
			// 役務提供費(4年以内)
			ekimFour0 = 0;
			ekimFour1 = 0;
			ekimFour2 = 0;
			ekimFour3 = 0;
			ekimFour4 = 0;
			ekimFour5 = 0;
			
			// 役務提供費(5年以内)
			ekimFive0 = 0;
			ekimFive1 = 0;
			ekimFive2 = 0;
			ekimFive3 = 0;
			ekimFive4 = 0;
			ekimFive5 = 0;
			
			// 役務提供費(5年超)
			ekimOverFive0 = 0;
			ekimOverFive1 = 0;
			ekimOverFive2 = 0;
			ekimOverFive3 = 0;
			ekimOverFive4 = 0;
			ekimOverFive5 = 0;
			
			// 役務提供費(合計)
			ekimTotal0 = 0;
			ekimTotal1 = 0;
			ekimTotal2 = 0;
			ekimTotal3 = 0;
			ekimTotal4 = 0;
			ekimTotal5 = 0;
			
			// 消費税等(1年以内)
			staxOne0 = 0;
			staxOne1 = 0;
			staxOne2 = 0;
			staxOne3 = 0;
			staxOne4 = 0;
			staxOne5 = 0;
			
			// 消費税等(2年以内)
			staxTwo0 = 0;
			staxTwo1 = 0;
			staxTwo2 = 0;
			staxTwo3 = 0;
			staxTwo4 = 0;
			staxTwo5 = 0;
			
			// 消費税等(3年以内)
			staxThree0 = 0;
			staxThree1 = 0;
			staxThree2 = 0;
			staxThree3 = 0;
			staxThree4 = 0;
			staxThree5 = 0;
			
			// 消費税等(4年以内)
			staxFour0 = 0;
			staxFour1 = 0;
			staxFour2 = 0;
			staxFour3 = 0;
			staxFour4 = 0;
			staxFour5 = 0;
			
			// 消費税等(5年以内)
			staxFive0 = 0;
			staxFive1 = 0;
			staxFive2 = 0;
			staxFive3 = 0;
			staxFive4 = 0;
			staxFive5 = 0;
			
			// 消費税等(5年超)
			staxOverFive0 = 0;
			staxOverFive1 = 0;
			staxOverFive2 = 0;
			staxOverFive3 = 0;
			staxOverFive4 = 0;
			staxOverFive5 = 0;
			
			// 20210603 消費税等(合計) 初期化処理の追加 start
			// 消費税等(合計)
			staxTotal0 = 0;
			staxTotal1 = 0;
			staxTotal2 = 0;
			staxTotal3 = 0;
			staxTotal4 = 0;
			staxTotal5 = 0;
			// 20210603 消費税等(合計) 初期化処理の追加 	
			
			// 20210603 総合計 初期化処理の追加 start
			// 未経過リース料(総合計)
			mikeikaLeaseOne = 0;
			mikeikaLeaseTwo = 0;
			mikeikaLeaseThree = 0;
			mikeikaLeaseFour = 0;
			mikeikaLeaseFive = 0;
			mikeikaLeaseOverFive = 0;
			mikeikaLeaseTotal = 0;
			
			// 残価保証額(総合計)
			zankaHosyoOne = 0;
			zankaHosyoTwo = 0;
			zankaHosyoThree =0;
			zankaHosyoFour = 0;
			zankaHosyoFive = 0;
			zankaHosyoOverFive = 0;
			zankaHosyoTotal =0;

			// 元本(総合計)
			gnpnOne = 0;						
			gnpnTwo = 0;
			gnpnThree = 0; 
			gnpnFour = 0; 
			gnpnFive = 0; 
			gnpnOverFive = 0;
			gnpnTotal = 0;
 
			// 利息(総合計)
			rskOne = 0;						
			rskTwo = 0;
			rskThree = 0; 
			rskFour = 0; 
			rskFive = 0; 
			rskOverFive = 0;
			rskTotal = 0;
			
			// 維持管理費(総合計)
			ijiOne = 0;						
			ijiTwo = 0;
			ijiThree = 0; 
			ijiFour = 0; 
			ijiFive = 0; 
			ijiOverFive = 0;
			ijiTotal = 0;
			
			// 役務提供費(総合計)
			ekimOne = 0;						
			ekimTwo = 0;
			ekimThree = 0; 
			ekimFour = 0; 
			ekimFive = 0; 
			ekimOverFive = 0;
			ekimTotal = 0;
			
			// 消費税等(総合計)
			staxOne = 0;						
			staxTwo = 0;
			staxThree = 0; 
			staxFour = 0; 
			staxFive = 0; 
			staxOverFive = 0;
			staxTotal = 0;
			souPage = 0;
			page = 0;
			// 20210603 総合計 初期化処理の追加 end
			
			// LACS帳票バッチ対応
			if(!batchFlg) {
				
				scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
				formDirectory = new File(wprlHomeDirectory, FORM_PATH);
				tmpFile = File.createTempFile("pdf10_" + prefix + "_", ".pdf", scratchDirectory);
				fout = new FileOutputStream(tmpFile);
				File formFile = new File(formDirectory, "kijitsuSaim.pdf");
				File datFile = new File(formDirectory, "kijitsuSaim.dat");
				report = new Report(formFile, datFile, fout);
				
			}
		
			// LACS帳票バッチ出力対応
			if (batchFlg && !batchStartFlg) {
				this.startReport(piContext);
				batchStartFlg =true;
			}			
			
			//tmpFile = File.createTempFile("pdf10_" + prefix + "_", ".pdf", scratchDirectory);
			//fout = new FileOutputStream(tmpFile);
			//File formFile = new File(formDirectory, "kijituSaim.pdf");
			//File datFile = new File(formDirectory, "kijituSaim.dat");
			//report = new Report(formFile, datFile, fout);
			
			
			// 総ページ数を取得
            for (int i = 0; i < piReportBean.getDataMax(); i++) {

            	detail = piReportBean.getKizituSaimu(i);            
            	
            	if (!detail.getBrakeKey5().equals(brakeKey5)) {
					if (!brakeKey5.equals("")) {

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
													
					brakeKey1 = detail.getBrakeKey1();
					brakeKey2 = detail.getBrakeKey2();
					brakeKey3 = detail.getBrakeKey3();
					brakeKey4 = detail.getBrakeKey4();
					brakeKey5 = detail.getBrakeKey5();
					
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
            			
			brakeKey1 = ""; 
			brakeKey2 = ""; 
			brakeKey3 = ""; 
			brakeKey4 = ""; 
			brakeKey5 = ""; 
				
			lineCount = 0;
			
			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				
				detail = piReportBean.getKizituSaimu(i);												
				
				if (!detail.getBrakeKey5().equals(brakeKey5)) {
					if (!brakeKey5.equals("")) {

						//if (lineCount >= MAX_LINE) {							
						//	lineCount = 0;
						//}						
						
						if (lineCount >= MAX_LINE) {
							detail = piReportBean.getKizituSaimu(i - 1);
							headPrint(piReportBean, piDateMode);
							detail = piReportBean.getKizituSaimu(i);
						}
						
						//lineCount++;
						
						KeisanKijunGoukei(piReportBean);
						
						mikeikaLeaseOne5 = 0;
						mikeikaLeaseTwo5 = 0;
						mikeikaLeaseThree5 = 0;
						mikeikaLeaseFour5 = 0;
						mikeikaLeaseFive5 = 0;
						mikeikaLeaseOverFive5 = 0;
						mikeikaLeaseTotal5 = 0;
						zankaHosyoOne5 = 0;
						zankaHosyoTwo5 = 0;
						zankaHosyoThree5 = 0;
						zankaHosyoFour5 = 0;
						zankaHosyoFive5 = 0;
						zankaHosyoOverFive5 = 0;
						zankaHosyoTotal5 = 0;
						gnpnOne5 = 0;
						gnpnTwo5 = 0;
						gnpnThree5 = 0;
						gnpnFour5 = 0;
						gnpnFive5 = 0;
						gnpnOverFive5 = 0;
						gnpnTotal5 = 0;
						rskOne5 = 0;
						rskTwo5 = 0;
						rskThree5 = 0;
						rskFour5 = 0;
						rskFive5 = 0;
						rskOverFive5 = 0;
						rskTotal5 = 0;
						ijiOne5 = 0;
						ijiTwo5 = 0;
						ijiThree5 = 0;
						ijiFour5 = 0;
						ijiFive5 = 0;
						ijiOverFive5 = 0;
						ijiTotal5 = 0;
						ekimOne5 = 0;
						ekimTwo5 = 0;
						ekimThree5 = 0;
						ekimFour5 = 0;
						ekimFive5 = 0;
						ekimOverFive5 = 0;
						ekimTotal5 = 0;
						staxOne5 = 0;
						staxTwo5 = 0;
						staxThree5 = 0;
						staxFour5 = 0;
						staxFive5 = 0;
						staxOverFive5 = 0;
						staxTotal5 = 0;						
						
						if (!detail.getBrakeKey4().equals(brakeKey4)) {

							/*if (lineCount >= MAX_LINE) {								
								lineCount = 0;
							}*/

							if (lineCount >= MAX_LINE) {
								detail = piReportBean.getKizituSaimu(i - 1);
								headPrint(piReportBean, piDateMode);
								detail = piReportBean.getKizituSaimu(i);
							}
														
							//lineCount++;
							
							RskHibnGoukei(piReportBean);
							
							mikeikaLeaseOne4 = 0;
							mikeikaLeaseTwo4 = 0;
							mikeikaLeaseThree4 = 0;
							mikeikaLeaseFour4 = 0;
							mikeikaLeaseFive4 = 0;
							mikeikaLeaseOverFive4 = 0;
							mikeikaLeaseTotal4 = 0;
							zankaHosyoOne4 = 0;
							zankaHosyoTwo4 = 0;
							zankaHosyoThree4 = 0;
							zankaHosyoFour4 = 0;
							zankaHosyoFive4 = 0;
							zankaHosyoOverFive4 = 0;
							zankaHosyoTotal4 = 0;
							gnpnOne4 = 0;
							gnpnTwo4 = 0;
							gnpnThree4 = 0;
							gnpnFour4 = 0;
							gnpnFive4 = 0;
							gnpnOverFive4 = 0;
							gnpnTotal4 = 0;
							rskOne4 = 0;
							rskTwo4 = 0;
							rskThree4 = 0;
							rskFour4 = 0;
							rskFive4 = 0;
							rskOverFive4 = 0;
							rskTotal4 = 0;
							ijiOne4 = 0;
							ijiTwo4 = 0;
							ijiThree4 = 0;
							ijiFour4 = 0;
							ijiFive4 = 0;
							ijiOverFive4 = 0;
							ijiTotal4 = 0;
							ekimOne4 = 0;
							ekimTwo4 = 0;
							ekimThree4 = 0;
							ekimFour4 = 0;
							ekimFive4 = 0;
							ekimOverFive4 = 0;
							ekimTotal4 = 0;
							staxOne4 = 0;
							staxTwo4 = 0;
							staxThree4 = 0;
							staxFour4 = 0;
							staxFive4 = 0;
							staxOverFive4 = 0;
							staxTotal4 = 0;
																			    
							
							if (!detail.getBrakeKey3().equals(brakeKey3)) {

								/*if (lineCount >= MAX_LINE) {
									lineCount = 0;
								  }*/
								
								
								if (lineCount >= MAX_LINE) {
									detail = piReportBean.getKizituSaimu(i - 1);
									headPrint(piReportBean, piDateMode);
									detail = piReportBean.getKizituSaimu(i);
								}
								
								//lineCount++;
								
								KaikeiSyoriGoukei(piReportBean);
								
								mikeikaLeaseOne3 = 0;
								mikeikaLeaseTwo3 = 0;
								mikeikaLeaseThree3 = 0;
								mikeikaLeaseFour3 = 0;
								mikeikaLeaseFive3 = 0;
								mikeikaLeaseOverFive3 = 0;
								mikeikaLeaseTotal3 = 0;
								zankaHosyoOne3 = 0;
								zankaHosyoTwo3 = 0;
								zankaHosyoThree3 = 0;
								zankaHosyoFour3 = 0;
								zankaHosyoFive3 = 0;
								zankaHosyoOverFive3 = 0;
								zankaHosyoTotal3 = 0;
								gnpnOne3 = 0;
								gnpnTwo3 = 0;
								gnpnThree3 = 0;
								gnpnFour3 = 0;
								gnpnFive3 = 0;
								gnpnOverFive3 = 0;
								gnpnTotal3 = 0;
								rskOne3 = 0;
								rskTwo3 = 0;
								rskThree3 = 0;
								rskFour3 = 0;
								rskFive3 = 0;
								rskOverFive3 = 0;
								rskTotal3 = 0;
								ijiOne3 = 0;
								ijiTwo3 = 0;
								ijiThree3 = 0;
								ijiFour3 = 0;
								ijiFive3 = 0;
								ijiOverFive3 = 0;
								ijiTotal3 = 0;
								ekimOne3 = 0;
								ekimTwo3 = 0;
								ekimThree3 = 0;
								ekimFour3 = 0;
								ekimFive3 = 0;
								ekimOverFive3 = 0;
								ekimTotal3 = 0;
								staxOne3 = 0;
								staxTwo3 = 0;
								staxThree3 = 0;
								staxFour3 = 0;
								staxFive3 = 0;
								staxOverFive3 = 0;
								staxTotal3 = 0;							

								if (!detail.getBrakeKey2().equals(brakeKey2)) {

									/*if (lineCount >= MAX_LINE) {										
										lineCount = 0;
									}*/
									
									
									if (lineCount >= MAX_LINE) {
										detail = piReportBean.getKizituSaimu(i - 1);
										headPrint(piReportBean, piDateMode);
										detail = piReportBean.getKizituSaimu(i);
									}								

									//lineCount++;
									
									LeaseTorihikiGoukei(piReportBean);
									
									mikeikaLeaseOne2 = 0;
									mikeikaLeaseTwo2 = 0;
									mikeikaLeaseThree2 = 0;
									mikeikaLeaseFour2 = 0;
									mikeikaLeaseFive2 = 0;
									mikeikaLeaseOverFive2 = 0;
									mikeikaLeaseTotal2 = 0;
									zankaHosyoOne2 = 0;
									zankaHosyoTwo2 = 0;
									zankaHosyoThree2 = 0;
									zankaHosyoFour2 = 0;
									zankaHosyoFive2 = 0;
									zankaHosyoOverFive2 = 0;
									zankaHosyoTotal2 = 0;
									gnpnOne2 = 0;
									gnpnTwo2 = 0;
									gnpnThree2 = 0;
									gnpnFour2 = 0;
									gnpnFive2 = 0;
									gnpnOverFive2 = 0;
									gnpnTotal2 = 0;
									rskOne2 = 0;
									rskTwo2 = 0;
									rskThree2 = 0;
									rskFour2 = 0;
									rskFive2 = 0;
									rskOverFive2 = 0;
									rskTotal2 = 0;
									ijiOne2 = 0;
									ijiTwo2 = 0;
									ijiThree2 = 0;
									ijiFour2 = 0;
									ijiFive2 = 0;
									ijiOverFive2 = 0;
									ijiTotal2 = 0;
									ekimOne2 = 0;
									ekimTwo2 = 0;
									ekimThree2 = 0;
									ekimFour2 = 0;
									ekimFive2 = 0;
									ekimOverFive2 = 0;
									ekimTotal2 = 0;
									staxOne2 = 0;
									staxTwo2 = 0;
									staxThree2 = 0;
									staxFour2 = 0;
									staxFive2 = 0;
									staxOverFive2 = 0;
									staxTotal2 = 0;									
									
									if (!detail.getBrakeKey1().equals(brakeKey1)) {

										/*if (lineCount >= MAX_LINE) {
											lineCount = 0;
										}*/										
										
										if (lineCount >= MAX_LINE) {
											detail = piReportBean.getKizituSaimu(i - 1);
											headPrint(piReportBean, piDateMode);
											detail = piReportBean.getKizituSaimu(i);
										}
										
										//lineCount++;
										
										JysiUmGoukei(piReportBean);
										
										mikeikaLeaseOne1 = 0;
										mikeikaLeaseTwo1 = 0;
										mikeikaLeaseThree1 = 0;
										mikeikaLeaseFour1 = 0;
										mikeikaLeaseFive1 = 0;
										mikeikaLeaseOverFive1 = 0;
										mikeikaLeaseTotal1 = 0;
										zankaHosyoOne1 = 0;
										zankaHosyoTwo1 = 0;
										zankaHosyoThree1 = 0;
										zankaHosyoFour1 = 0;
										zankaHosyoFive1 = 0;
										zankaHosyoOverFive1 = 0;
										zankaHosyoTotal1 = 0;
										gnpnOne1 = 0;
										gnpnTwo1 = 0;
										gnpnThree1 = 0;
										gnpnFour1 = 0;
										gnpnFive1 = 0;
										gnpnOverFive1 = 0;
										gnpnTotal1 = 0;
										rskOne1 = 0;
										rskTwo1 = 0;
										rskThree1 = 0;
										rskFour1 = 0;
										rskFive1 = 0;
										rskOverFive1 = 0;
										rskTotal1 = 0;
										ijiOne1 = 0;
										ijiTwo1 = 0;
										ijiThree1 = 0;
										ijiFour1 = 0;
										ijiFive1 = 0;
										ijiOverFive1 = 0;
										ijiTotal1 = 0;
										ekimOne1 = 0;
										ekimTwo1 = 0;
										ekimThree1 = 0;
										ekimFour1 = 0;
										ekimFive1 = 0;
										ekimOverFive1 = 0;
										ekimTotal1 = 0;
										staxOne1 = 0;
										staxTwo1 = 0;
										staxThree1 = 0;
										staxFour1 = 0;
										staxFive1 = 0;
										staxOverFive1 = 0;
										staxTotal1 = 0;																		
																				
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
								
				//report.putFieldData(report.getField("xGoukei" + index), "リース会社計");
			
				field = report.getField("xKnshuYmd" + index);
				report.putFieldData(field, detail.getLeaseFrom());
				
				field = report.getField("xMryoYmd" + index);
				report.putFieldData(field, detail.getLeaseTo());
				
				field = report.getField("xKaiYmd" + index);
				report.putFieldData(field, detail.getKaiyakuYmd());
				
				field = report.getField("xMikeikaTitle" + index);
				report.putFieldData(field, "未経過リース料");
					
				field = report.getField("xZankTitle" + index);
				report.putFieldData(field, "残価保証額");
					
				field = report.getField("xGnpnTitle" + index);
				report.putFieldData(field, "元本");
					
				field = report.getField("xRskTitle" + index);
				report.putFieldData(field, "利息");
				
				field = report.getField("xIjiTitle" + index);
				report.putFieldData(field, "維持管理費");
				
				field = report.getField("xEkimTitle" + index);
				report.putFieldData(field, "役務提供費");
				
				field = report.getField("xStaxTitle" + index);
				report.putFieldData(field, "消費税等");
		    
				
				field = report.getField("xMikeika1" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaLeaseWithinOneYear()));
				
				field = report.getField("xMikeika2" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaLeaseWithinTwoYears()));
				
				field = report.getField("xMikeika3" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaLeaseWithinThreeYears()));
				
				field = report.getField("xMikeika4" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaLeaseWithinFourYears()));
				
				field = report.getField("xMikeika5" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaLeaseWithinFiveYears()));
				
				field = report.getField("xMikeika6" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaLeaseOverFiveYears()));
				
				field = report.getField("xMikeika7" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getMikeikaLeaseTotal()));
				
				field = report.getField("xZank1" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankaHosyogakuWithinOneYear()));
				
				field = report.getField("xZank2" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankaHosyogakuWithinTwoYears()));
				
				field = report.getField("xZank3" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankaHosyogakuWithinThreeYears()));
				
				field = report.getField("xZank4" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankaHosyogakuWithinFourYears()));
				
				field = report.getField("xZank5" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankaHosyogakuWithinFiveYears()));
				
				field = report.getField("xZank6" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankaHosyogakuOverFiveYears()));
				
				field = report.getField("xZank7" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankaHosyogakuTotal()));
				
				field = report.getField("xGnpn1" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getGanponWithinOneYear()));
				
				field = report.getField("xGnpn2" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getGanponWithinTwoYears()));
				
				field = report.getField("xGnpn3" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getGanponWithinThreeYears()));
				
				field = report.getField("xGnpn4" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getGanponWithinFourYears()));
				
				field = report.getField("xGnpn5" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getGanponWithinFiveYears()));
				
				field = report.getField("xGnpn6" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getGanponOverFiveYears()));
				
				field = report.getField("xGnpn7" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getGanponTotal()));
					
				field = report.getField("xRsk1" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getRisokuWithinOneYear()));
				
				field = report.getField("xRsk2" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getRisokuWithinTwoYears()));
				
				field = report.getField("xRsk3" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getRisokuWithinThreeYears()));
				
				field = report.getField("xRsk4" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getRisokuWithinFourYears()));
				
				field = report.getField("xRsk5" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getRisokuWithinFiveYears()));
				
				field = report.getField("xRsk6" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getRisokuOverFiveYears()));
				
				field = report.getField("xRsk7" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getRisokuTotal()));
				
				field = report.getField("xIji1" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getIzikanrihiWithinOneYear()));
				
				field = report.getField("xIji2" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getIzikanrihiWithinTwoYears()));
				
				field = report.getField("xIji3" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getIzikanrihiWithinThreeYears()));
				
				field = report.getField("xIji4" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getIzikanrihiWithinFourYears()));
				
				field = report.getField("xIji5" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getIzikanrihiWithinFiveYears()));
				
				field = report.getField("xIji6" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getIzikanrihiOverFiveYears()));
				
				field = report.getField("xIji7" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getIzikanrihiTotal()));
					
				field = report.getField("xEkim1" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getEkimuteikyouhiWithinOneYear()));
				
				field = report.getField("xEkim2" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getEkimuteikyouhiWithinTwoYears()));
				
				field = report.getField("xEkim3" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getEkimuteikyouhiWithinThreeYears()));
				
				field = report.getField("xEkim4" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getEkimuteikyouhiWithinFourYears()));
				
				field = report.getField("xEkim5" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getEkimuteikyouhiWithinFiveYears()));
				
				field = report.getField("xEkim6" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getEkimuteikyouhiOverFiveYears()));
				
				field = report.getField("xEkim7" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getEkimuteikyouhiTotal()));
					
				field = report.getField("xStax1" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyohizeiWithinOneYear()));
				
				field = report.getField("xStax2" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyohizeiWithinTwoYears()));
				
				field = report.getField("xStax3" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyohizeiWithinThreeYears()));
				
				field = report.getField("xStax4" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyohizeiWithinFourYears()));
				
				field = report.getField("xStax5" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyohizeiWithinFiveYears()));
				
				field = report.getField("xStax6" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyohizeiOverFiveYears()));
				
				field = report.getField("xStax7" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getSyohizeiTotal()));
								
			    /*mikeikaLeaseOne0 += detail.getMikeikaLeaseWithinOneYear();
				mikeikaLeaseTwo0 += detail.getMikeikaLeaseWithinTwoYears();
				mikeikaLeaseThree0 += detail.getMikeikaLeaseWithinThreeYears();
				mikeikaLeaseFour0 += detail.getMikeikaLeaseWithinFourYears();
				mikeikaLeaseFive0 += detail.getMikeikaLeaseWithinFiveYears();
				mikeikaLeaseOverFive0 += detail.getMikeikaLeaseOverFiveYears();
				mikeikaLeaseTotal0 += detail.getMikeikaLeaseTotal();
				*/
				
				mikeikaLeaseOne1 += detail.getMikeikaLeaseWithinOneYear();
				mikeikaLeaseTwo1 += detail.getMikeikaLeaseWithinTwoYears();
				mikeikaLeaseThree1 += detail.getMikeikaLeaseWithinThreeYears();
				mikeikaLeaseFour1 += detail.getMikeikaLeaseWithinFourYears();
				mikeikaLeaseFive1 += detail.getMikeikaLeaseWithinFiveYears();
				mikeikaLeaseOverFive1 += detail.getMikeikaLeaseOverFiveYears();
				mikeikaLeaseTotal1 += detail.getMikeikaLeaseTotal();
				
				mikeikaLeaseOne2 += detail.getMikeikaLeaseWithinOneYear();
				mikeikaLeaseTwo2 += detail.getMikeikaLeaseWithinTwoYears();
				mikeikaLeaseThree2 += detail.getMikeikaLeaseWithinThreeYears();
				mikeikaLeaseFour2 += detail.getMikeikaLeaseWithinFourYears();
				mikeikaLeaseFive2 += detail.getMikeikaLeaseWithinFiveYears();
				mikeikaLeaseOverFive2 += detail.getMikeikaLeaseOverFiveYears();
				mikeikaLeaseTotal2 += detail.getMikeikaLeaseTotal();
				
				mikeikaLeaseOne3 += detail.getMikeikaLeaseWithinOneYear();
				mikeikaLeaseTwo3 += detail.getMikeikaLeaseWithinTwoYears();
				mikeikaLeaseThree3 += detail.getMikeikaLeaseWithinThreeYears();
				mikeikaLeaseFour3 += detail.getMikeikaLeaseWithinFourYears();
				mikeikaLeaseFive3 += detail.getMikeikaLeaseWithinFiveYears();
				mikeikaLeaseOverFive3 += detail.getMikeikaLeaseOverFiveYears();
				mikeikaLeaseTotal3 += detail.getMikeikaLeaseTotal();
				
				mikeikaLeaseOne4 += detail.getMikeikaLeaseWithinOneYear();
				mikeikaLeaseTwo4 += detail.getMikeikaLeaseWithinTwoYears();
				mikeikaLeaseThree4 += detail.getMikeikaLeaseWithinThreeYears();
				mikeikaLeaseFour4 += detail.getMikeikaLeaseWithinFourYears();
				mikeikaLeaseFive4 += detail.getMikeikaLeaseWithinFiveYears();
				mikeikaLeaseOverFive4 += detail.getMikeikaLeaseOverFiveYears();
				mikeikaLeaseTotal4 += detail.getMikeikaLeaseTotal();
				
				mikeikaLeaseOne5 += detail.getMikeikaLeaseWithinOneYear();
				mikeikaLeaseTwo5 += detail.getMikeikaLeaseWithinTwoYears();
				mikeikaLeaseThree5 += detail.getMikeikaLeaseWithinThreeYears();
				mikeikaLeaseFour5 += detail.getMikeikaLeaseWithinFourYears();
				mikeikaLeaseFive5 += detail.getMikeikaLeaseWithinFiveYears();
				mikeikaLeaseOverFive5 += detail.getMikeikaLeaseOverFiveYears();
				mikeikaLeaseTotal5 += detail.getMikeikaLeaseTotal();
				
				mikeikaLeaseOne += detail.getMikeikaLeaseWithinOneYear();
				mikeikaLeaseTwo += detail.getMikeikaLeaseWithinTwoYears();
				mikeikaLeaseThree += detail.getMikeikaLeaseWithinThreeYears();
				mikeikaLeaseFour += detail.getMikeikaLeaseWithinFourYears();
				mikeikaLeaseFive += detail.getMikeikaLeaseWithinFiveYears();
				mikeikaLeaseOverFive += detail.getMikeikaLeaseOverFiveYears();
				mikeikaLeaseTotal += detail.getMikeikaLeaseTotal();
								
				zankaHosyoOne5 += detail.getZankaHosyogakuWithinOneYear();						
				zankaHosyoTwo5 += detail.getZankaHosyogakuWithinTwoYears();
				zankaHosyoThree5 += detail.getZankaHosyogakuWithinThreeYears(); 
				zankaHosyoFour5 += detail.getZankaHosyogakuWithinFourYears(); 
				zankaHosyoFive5 += detail.getZankaHosyogakuWithinFiveYears(); 
				zankaHosyoOverFive5 += detail.getZankaHosyogakuOverFiveYears();
				zankaHosyoTotal5 += detail.getZankaHosyogakuTotal(); 
				
				zankaHosyoOne4 += detail.getZankaHosyogakuWithinOneYear();						
				zankaHosyoTwo4 += detail.getZankaHosyogakuWithinTwoYears();
				zankaHosyoThree4 += detail.getZankaHosyogakuWithinThreeYears(); 
				zankaHosyoFour4 += detail.getZankaHosyogakuWithinFourYears(); 
				zankaHosyoFive4 += detail.getZankaHosyogakuWithinFiveYears(); 
				zankaHosyoOverFive4 += detail.getZankaHosyogakuOverFiveYears();
				zankaHosyoTotal4 += detail.getZankaHosyogakuTotal(); 
				
				zankaHosyoOne3 += detail.getZankaHosyogakuWithinOneYear();						
				zankaHosyoTwo3 += detail.getZankaHosyogakuWithinTwoYears();
				zankaHosyoThree3 += detail.getZankaHosyogakuWithinThreeYears(); 
				zankaHosyoFour3 += detail.getZankaHosyogakuWithinFourYears(); 
				zankaHosyoFive3 += detail.getZankaHosyogakuWithinFiveYears(); 
				zankaHosyoOverFive3 += detail.getZankaHosyogakuOverFiveYears();
				zankaHosyoTotal3 += detail.getZankaHosyogakuTotal(); 
				
				zankaHosyoOne2 += detail.getZankaHosyogakuWithinOneYear();						
				zankaHosyoTwo2 += detail.getZankaHosyogakuWithinTwoYears();
				zankaHosyoThree2 += detail.getZankaHosyogakuWithinThreeYears(); 
				zankaHosyoFour2 += detail.getZankaHosyogakuWithinFourYears(); 
				zankaHosyoFive2 += detail.getZankaHosyogakuWithinFiveYears(); 
				zankaHosyoOverFive2 += detail.getZankaHosyogakuOverFiveYears();
				zankaHosyoTotal2 += detail.getZankaHosyogakuTotal(); 
				
				zankaHosyoOne1 += detail.getZankaHosyogakuWithinOneYear();						
				zankaHosyoTwo1 += detail.getZankaHosyogakuWithinTwoYears();
				zankaHosyoThree1 += detail.getZankaHosyogakuWithinThreeYears(); 
				zankaHosyoFour1 += detail.getZankaHosyogakuWithinFourYears(); 
				zankaHosyoFive1 += detail.getZankaHosyogakuWithinFiveYears(); 
				zankaHosyoOverFive1 += detail.getZankaHosyogakuOverFiveYears();
				zankaHosyoTotal1 += detail.getZankaHosyogakuTotal(); 
				
				/*zankaHosyoOne0 += detail.getZankaHosyogakuWithinOneYear();						
				zankaHosyoTwo0 += detail.getZankaHosyogakuWithinTwoYears();
				zankaHosyoThree0 += detail.getZankaHosyogakuWithinThreeYears(); 
				zankaHosyoFour0 += detail.getZankaHosyogakuWithinFourYears(); 
				zankaHosyoFive0 += detail.getZankaHosyogakuWithinFiveYears(); 
				zankaHosyoOverFive0 += detail.getZankaHosyogakuOverFiveYears();
				zankaHosyoTotal0 += detail.getZankaHosyogakuTotal();
				*/
				
				zankaHosyoOne += detail.getZankaHosyogakuWithinOneYear();						
				zankaHosyoTwo += detail.getZankaHosyogakuWithinTwoYears();
				zankaHosyoThree += detail.getZankaHosyogakuWithinThreeYears(); 
				zankaHosyoFour += detail.getZankaHosyogakuWithinFourYears(); 
				zankaHosyoFive += detail.getZankaHosyogakuWithinFiveYears(); 
				zankaHosyoOverFive += detail.getZankaHosyogakuOverFiveYears();
				zankaHosyoTotal += detail.getZankaHosyogakuTotal();
				
				gnpnOne5 += detail.getGanponWithinOneYear();						
				gnpnTwo5 += detail.getGanponWithinTwoYears();
				gnpnThree5 += detail.getGanponWithinThreeYears(); 
				gnpnFour5 += detail.getGanponWithinFourYears(); 
				gnpnFive5 += detail.getGanponWithinFiveYears(); 
				gnpnOverFive5 += detail.getGanponOverFiveYears();
				gnpnTotal5 += detail.getGanponTotal(); 
				
				gnpnOne4 += detail.getGanponWithinOneYear();						
				gnpnTwo4 += detail.getGanponWithinTwoYears();
				gnpnThree4 += detail.getGanponWithinThreeYears(); 
				gnpnFour4 += detail.getGanponWithinFourYears(); 
				gnpnFive4 += detail.getGanponWithinFiveYears(); 
				gnpnOverFive4 += detail.getGanponOverFiveYears();
				gnpnTotal4 += detail.getGanponTotal();
				
				gnpnOne3 += detail.getGanponWithinOneYear();						
				gnpnTwo3 += detail.getGanponWithinTwoYears();
				gnpnThree3 += detail.getGanponWithinThreeYears(); 
				gnpnFour3 += detail.getGanponWithinFourYears(); 
				gnpnFive3 += detail.getGanponWithinFiveYears(); 
				gnpnOverFive3 += detail.getGanponOverFiveYears();
				gnpnTotal3 += detail.getGanponTotal();
				
				gnpnOne2 += detail.getGanponWithinOneYear();						
				gnpnTwo2 += detail.getGanponWithinTwoYears();
				gnpnThree2 += detail.getGanponWithinThreeYears(); 
				gnpnFour2 += detail.getGanponWithinFourYears(); 
				gnpnFive2 += detail.getGanponWithinFiveYears(); 
				gnpnOverFive2 += detail.getGanponOverFiveYears();
				gnpnTotal2 += detail.getGanponTotal();
				
				gnpnOne1 += detail.getGanponWithinOneYear();						
				gnpnTwo1 += detail.getGanponWithinTwoYears();
				gnpnThree1 += detail.getGanponWithinThreeYears(); 
				gnpnFour1 += detail.getGanponWithinFourYears(); 
				gnpnFive1 += detail.getGanponWithinFiveYears(); 
				gnpnOverFive1 += detail.getGanponOverFiveYears();
				gnpnTotal1 += detail.getGanponTotal();
				
				/*gnpnOne0 += detail.getGanponWithinOneYear();						
				gnpnTwo0 += detail.getGanponWithinTwoYears();
				gnpnThree0 += detail.getGanponWithinThreeYears(); 
				gnpnFour0 += detail.getGanponWithinFourYears(); 
				gnpnFive0 += detail.getGanponWithinFiveYears(); 
				gnpnOverFive0 += detail.getGanponOverFiveYears();
				gnpnTotal0 += detail.getGanponTotal();
				*/
				gnpnOne += detail.getGanponWithinOneYear();						
				gnpnTwo += detail.getGanponWithinTwoYears();
				gnpnThree += detail.getGanponWithinThreeYears(); 
				gnpnFour += detail.getGanponWithinFourYears(); 
				gnpnFive += detail.getGanponWithinFiveYears(); 
				gnpnOverFive += detail.getGanponOverFiveYears();
				gnpnTotal += detail.getGanponTotal();
				
								
				rskOne5 += detail.getRisokuWithinOneYear();						
				rskTwo5 += detail.getRisokuWithinTwoYears();
				rskThree5 += detail.getRisokuWithinThreeYears(); 
				rskFour5 += detail.getRisokuWithinFourYears(); 
				rskFive5 += detail.getRisokuWithinFiveYears(); 
				rskOverFive5 += detail.getRisokuOverFiveYears();
				rskTotal5 += detail.getRisokuTotal(); 
				
				rskOne4 += detail.getRisokuWithinOneYear();						
				rskTwo4 += detail.getRisokuWithinTwoYears();
				rskThree4 += detail.getRisokuWithinThreeYears(); 
				rskFour4 += detail.getRisokuWithinFourYears(); 
				rskFive4 += detail.getRisokuWithinFiveYears(); 
				rskOverFive4 += detail.getRisokuOverFiveYears();
				rskTotal4 += detail.getRisokuTotal();
				
				rskOne3 += detail.getRisokuWithinOneYear();						
				rskTwo3 += detail.getRisokuWithinTwoYears();
				rskThree3 += detail.getRisokuWithinThreeYears(); 
				rskFour3 += detail.getRisokuWithinFourYears(); 
				rskFive3 += detail.getRisokuWithinFiveYears(); 
				rskOverFive3 += detail.getRisokuOverFiveYears();
				rskTotal3 += detail.getRisokuTotal();
				
				rskOne2 += detail.getRisokuWithinOneYear();						
				rskTwo2 += detail.getRisokuWithinTwoYears();
				rskThree2 += detail.getRisokuWithinThreeYears(); 
				rskFour2 += detail.getRisokuWithinFourYears(); 
				rskFive2 += detail.getRisokuWithinFiveYears(); 
				rskOverFive2 += detail.getRisokuOverFiveYears();
				rskTotal2 += detail.getRisokuTotal();
				
				rskOne1 += detail.getRisokuWithinOneYear();						
				rskTwo1 += detail.getRisokuWithinTwoYears();
				rskThree1 += detail.getRisokuWithinThreeYears(); 
				rskFour1 += detail.getRisokuWithinFourYears(); 
				rskFive1 += detail.getRisokuWithinFiveYears(); 
				rskOverFive1 += detail.getRisokuOverFiveYears();
				rskTotal1 += detail.getRisokuTotal();
				
				/*rskOne0 += detail.getRisokuWithinOneYear();						
				rskTwo0 += detail.getRisokuWithinTwoYears();
				rskThree0 += detail.getRisokuWithinThreeYears(); 
				rskFour0 += detail.getRisokuWithinFourYears(); 
				rskFive0 += detail.getRisokuWithinFiveYears(); 
				rskOverFive0 += detail.getRisokuOverFiveYears();
				rskTotal0 += detail.getRisokuTotal();
				*/
				rskOne += detail.getRisokuWithinOneYear();						
				rskTwo += detail.getRisokuWithinTwoYears();
				rskThree += detail.getRisokuWithinThreeYears(); 
				rskFour += detail.getRisokuWithinFourYears(); 
				rskFive += detail.getRisokuWithinFiveYears(); 
				rskOverFive += detail.getRisokuOverFiveYears();
				rskTotal += detail.getRisokuTotal();
				
				
				ijiOne5 += detail.getIzikanrihiWithinOneYear();						
				ijiTwo5 += detail.getIzikanrihiWithinTwoYears();
				ijiThree5 += detail.getIzikanrihiWithinThreeYears(); 
				ijiFour5 += detail.getIzikanrihiWithinFourYears(); 
				ijiFive5 += detail.getIzikanrihiWithinFiveYears(); 
				ijiOverFive5 += detail.getIzikanrihiOverFiveYears();
				ijiTotal5 += detail.getIzikanrihiTotal(); 
				
				ijiOne4 += detail.getIzikanrihiWithinOneYear();						
				ijiTwo4 += detail.getIzikanrihiWithinTwoYears();
				ijiThree4 += detail.getIzikanrihiWithinThreeYears(); 
				ijiFour4 += detail.getIzikanrihiWithinFourYears(); 
				ijiFive4 += detail.getIzikanrihiWithinFiveYears(); 
				ijiOverFive4 += detail.getIzikanrihiOverFiveYears();
				ijiTotal4 += detail.getIzikanrihiTotal();
				
				ijiOne3 += detail.getIzikanrihiWithinOneYear();						
				ijiTwo3 += detail.getIzikanrihiWithinTwoYears();
				ijiThree3 += detail.getIzikanrihiWithinThreeYears(); 
				ijiFour3 += detail.getIzikanrihiWithinFourYears(); 
				ijiFive3 += detail.getIzikanrihiWithinFiveYears(); 
				ijiOverFive3 += detail.getIzikanrihiOverFiveYears();
				ijiTotal3 += detail.getIzikanrihiTotal();
				
				ijiOne2 += detail.getIzikanrihiWithinOneYear();						
				ijiTwo2 += detail.getIzikanrihiWithinTwoYears();
				ijiThree2 += detail.getIzikanrihiWithinThreeYears(); 
				ijiFour2 += detail.getIzikanrihiWithinFourYears(); 
				ijiFive2 += detail.getIzikanrihiWithinFiveYears(); 
				ijiOverFive2 += detail.getIzikanrihiOverFiveYears();
				ijiTotal2 += detail.getIzikanrihiTotal();
				
				ijiOne1 += detail.getIzikanrihiWithinOneYear();						
				ijiTwo1 += detail.getIzikanrihiWithinTwoYears();
				ijiThree1 += detail.getIzikanrihiWithinThreeYears(); 
				ijiFour1 += detail.getIzikanrihiWithinFourYears(); 
				ijiFive1 += detail.getIzikanrihiWithinFiveYears(); 
				ijiOverFive1 += detail.getIzikanrihiOverFiveYears();
				ijiTotal1 += detail.getIzikanrihiTotal();
				
				/*ijiOne0 += detail.getIzikanrihiWithinOneYear();						
				ijiTwo0 += detail.getIzikanrihiWithinTwoYears();
				ijiThree0 += detail.getIzikanrihiWithinThreeYears(); 
				ijiFour0 += detail.getIzikanrihiWithinFourYears(); 
				ijiFive0 += detail.getIzikanrihiWithinFiveYears(); 
				ijiOverFive0 += detail.getIzikanrihiOverFiveYears();
				ijiTotal0 += detail.getIzikanrihiTotal();
				*/
				
				ijiOne += detail.getIzikanrihiWithinOneYear();						
				ijiTwo += detail.getIzikanrihiWithinTwoYears();
				ijiThree += detail.getIzikanrihiWithinThreeYears(); 
				ijiFour += detail.getIzikanrihiWithinFourYears(); 
				ijiFive += detail.getIzikanrihiWithinFiveYears(); 
				ijiOverFive += detail.getIzikanrihiOverFiveYears();
				ijiTotal += detail.getIzikanrihiTotal();
				
				ekimOne5 += detail.getEkimuteikyouhiWithinOneYear();						
				ekimTwo5 += detail.getEkimuteikyouhiWithinTwoYears();
				ekimThree5 += detail.getEkimuteikyouhiWithinThreeYears(); 
				ekimFour5 += detail.getEkimuteikyouhiWithinFourYears(); 
				ekimFive5 += detail.getEkimuteikyouhiWithinFiveYears(); 
				ekimOverFive5 += detail.getEkimuteikyouhiOverFiveYears();
				ekimTotal5 += detail.getEkimuteikyouhiTotal(); 
				
				ekimOne4 += detail.getEkimuteikyouhiWithinOneYear();						
				ekimTwo4 += detail.getEkimuteikyouhiWithinTwoYears();
				ekimThree4 += detail.getEkimuteikyouhiWithinThreeYears(); 
				ekimFour4 += detail.getEkimuteikyouhiWithinFourYears(); 
				ekimFive4 += detail.getEkimuteikyouhiWithinFiveYears(); 
				ekimOverFive4 += detail.getEkimuteikyouhiOverFiveYears();
				ekimTotal4 += detail.getEkimuteikyouhiTotal();
				
				ekimOne3 += detail.getEkimuteikyouhiWithinOneYear();						
				ekimTwo3 += detail.getEkimuteikyouhiWithinTwoYears();
				ekimThree3 += detail.getEkimuteikyouhiWithinThreeYears(); 
				ekimFour3 += detail.getEkimuteikyouhiWithinFourYears(); 
				ekimFive3 += detail.getEkimuteikyouhiWithinFiveYears(); 
				ekimOverFive3 += detail.getEkimuteikyouhiOverFiveYears();
				ekimTotal3 += detail.getEkimuteikyouhiTotal();
				
				ekimOne2 += detail.getEkimuteikyouhiWithinOneYear();						
				ekimTwo2 += detail.getEkimuteikyouhiWithinTwoYears();
				ekimThree2 += detail.getEkimuteikyouhiWithinThreeYears(); 
				ekimFour2 += detail.getEkimuteikyouhiWithinFourYears(); 
				ekimFive2 += detail.getEkimuteikyouhiWithinFiveYears(); 
				ekimOverFive2 += detail.getEkimuteikyouhiOverFiveYears();
				ekimTotal2 += detail.getEkimuteikyouhiTotal();
				
				ekimOne1 += detail.getEkimuteikyouhiWithinOneYear();						
				ekimTwo1 += detail.getEkimuteikyouhiWithinTwoYears();
				ekimThree1 += detail.getEkimuteikyouhiWithinThreeYears(); 
				ekimFour1 += detail.getEkimuteikyouhiWithinFourYears(); 
				ekimFive1 += detail.getEkimuteikyouhiWithinFiveYears(); 
				ekimOverFive1 += detail.getEkimuteikyouhiOverFiveYears();
				ekimTotal1 += detail.getEkimuteikyouhiTotal();
				
				/*ekimOne0 += detail.getEkimuteikyouhiWithinOneYear();						
				ekimTwo0 += detail.getEkimuteikyouhiWithinTwoYears();
				ekimThree0 += detail.getEkimuteikyouhiWithinThreeYears(); 
				ekimFour0 += detail.getEkimuteikyouhiWithinFourYears(); 
				ekimFive0 += detail.getEkimuteikyouhiWithinFiveYears(); 
				ekimOverFive0 += detail.getEkimuteikyouhiOverFiveYears();
				ekimTotal0 += detail.getEkimuteikyouhiTotal();
				*/
				ekimOne += detail.getEkimuteikyouhiWithinOneYear();						
				ekimTwo += detail.getEkimuteikyouhiWithinTwoYears();
				ekimThree += detail.getEkimuteikyouhiWithinThreeYears(); 
				ekimFour += detail.getEkimuteikyouhiWithinFourYears(); 
				ekimFive += detail.getEkimuteikyouhiWithinFiveYears(); 
				ekimOverFive += detail.getEkimuteikyouhiOverFiveYears();
				ekimTotal += detail.getEkimuteikyouhiTotal();
				
				staxOne5 += detail.getSyohizeiWithinOneYear();						
				staxTwo5 += detail.getSyohizeiWithinTwoYears();
				staxThree5 += detail.getSyohizeiWithinThreeYears(); 
				staxFour5 += detail.getSyohizeiWithinFourYears(); 
				staxFive5 += detail.getSyohizeiWithinFiveYears(); 
				staxOverFive5 += detail.getSyohizeiOverFiveYears();
				staxTotal5 += detail.getSyohizeiTotal(); 
				
				staxOne4 += detail.getSyohizeiWithinOneYear();						
				staxTwo4 += detail.getSyohizeiWithinTwoYears();
				staxThree4 += detail.getSyohizeiWithinThreeYears(); 
				staxFour4 += detail.getSyohizeiWithinFourYears(); 
				staxFive4 += detail.getSyohizeiWithinFiveYears(); 
				staxOverFive4 += detail.getSyohizeiOverFiveYears();
				staxTotal4 += detail.getSyohizeiTotal();
				
				staxOne3 += detail.getSyohizeiWithinOneYear();						
				staxTwo3 += detail.getSyohizeiWithinTwoYears();
				staxThree3 += detail.getSyohizeiWithinThreeYears(); 
				staxFour3 += detail.getSyohizeiWithinFourYears(); 
				staxFive3 += detail.getSyohizeiWithinFiveYears(); 
				staxOverFive3 += detail.getSyohizeiOverFiveYears();
				staxTotal3 += detail.getSyohizeiTotal();
				
				staxOne2 += detail.getSyohizeiWithinOneYear();						
				staxTwo2 += detail.getSyohizeiWithinTwoYears();
			    staxThree2 += detail.getSyohizeiWithinThreeYears(); 
				staxFour2 += detail.getSyohizeiWithinFourYears(); 
				staxFive2 += detail.getSyohizeiWithinFiveYears(); 
				staxOverFive2 += detail.getSyohizeiOverFiveYears();
				staxTotal2 += detail.getSyohizeiTotal();
				
				staxOne1 += detail.getSyohizeiWithinOneYear();						
				staxTwo1 += detail.getSyohizeiWithinTwoYears();
				staxThree1 += detail.getSyohizeiWithinThreeYears(); 
				staxFour1 += detail.getSyohizeiWithinFourYears(); 
				staxFive1 += detail.getSyohizeiWithinFiveYears(); 
				staxOverFive1 += detail.getSyohizeiOverFiveYears();
				staxTotal1 += detail.getSyohizeiTotal();
				
				/*staxOne0 += detail.getSyohizeiWithinOneYear();						
				staxTwo0 += detail.getSyohizeiWithinTwoYears();
				staxThree0 += detail.getSyohizeiWithinThreeYears(); 
				staxFour0 += detail.getSyohizeiWithinFourYears(); 
				staxFive0 += detail.getSyohizeiWithinFiveYears(); 
				staxOverFive0 += detail.getSyohizeiOverFiveYears();
				staxTotal0 += detail.getSyohizeiTotal();
				*/
				staxOne += detail.getSyohizeiWithinOneYear();						
				staxTwo += detail.getSyohizeiWithinTwoYears();
				staxThree += detail.getSyohizeiWithinThreeYears(); 
				staxFour += detail.getSyohizeiWithinFourYears(); 
				staxFive += detail.getSyohizeiWithinFiveYears(); 
				staxOverFive += detail.getSyohizeiOverFiveYears();
				staxTotal += detail.getSyohizeiTotal();
								
				lineCount++;
			
				/*if (lineCount > MAX_LINE) {
					souPage++; 
					lineCount = 0;
				}*/
	        }
			
			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			KeisanKijunGoukei(piReportBean);
			
			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			RskHibnGoukei(piReportBean);
			
			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			KaikeiSyoriGoukei(piReportBean);
			
			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			LeaseTorihikiGoukei(piReportBean);

			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}

			JysiUmGoukei(piReportBean);
			
			if (lineCount >= MAX_LINE) {
				headPrint(piReportBean, piDateMode);
			}
			
			//LeaseCompanyGoukei(piReportBean);
	        
			souGokeiPrint(piReportBean);
	    				
			//if (lineCount >= MAX_LINE) {
			//	headPrint(piReportBean, piDateMode);		    			    			    	
			//}
					
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
    	report.putFieldData(field, super.convertReki((detail.getBaseDate()), piDateMode) + " 現在");

    	field = report.getField("xJysiUm");
    	report.putFieldData(field, detail.getJysiUm());
    	
    	field = report.getField("xTaishoAcKijyunNm");
    	report.putFieldData(field, detail.getLeaseBunrui());
    	    	
    	field = report.getField("xTrdHnteiKekaNm");
    	report.putFieldData(field, detail.getRisokuBunpaiHouhou());
    	
    	field = report.getField("xAcShrNm");
    	report.putFieldData(field, detail.getKaikeisyoriHouhou());
    	
    	field = report.getField("xShriLeasKijn");
    	report.putFieldData(field, detail.getToukiReaseKeisanKijyun());    
    	
    }
    
    // 支払リース料計算基準計
    private void KeisanKijunGoukei(LACSReportBean piReportBean) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); 
		
		field = report.getField("xMikeikaTitle" + index);
		report.putFieldData(field, "未経過リース料");
			
		field = report.getField("xZankTitle" + index);
		report.putFieldData(field, "残価保証額");
			
		field = report.getField("xGnpnTitle" + index);
		report.putFieldData(field, "元本");
			
		field = report.getField("xRskTitle" + index);
		report.putFieldData(field, "利息");
		
		field = report.getField("xIjiTitle" + index);
		report.putFieldData(field, "維持管理費");
		
		field = report.getField("xEkimTitle" + index);
		report.putFieldData(field, "役務提供費");
		
		field = report.getField("xStaxTitle" + index);
		report.putFieldData(field, "消費税等");
		
		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "支払リース料計算基準計");

		field = report.getField("xMikeika1" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseOne5));
		
		field = report.getField("xMikeika2" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseTwo5));
		
		field = report.getField("xMikeika3" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseThree5));
		
		field = report.getField("xMikeika4" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseFour5));
		
		field = report.getField("xMikeika5" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseFive5));
		
		field = report.getField("xMikeika6" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseOverFive5));
		
		field = report.getField("xMikeika7" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseTotal5));
		
		
		field = report.getField("xZank1" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoOne5));
		
		field = report.getField("xZank2" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoTwo5));
		
		field = report.getField("xZank3" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoThree5));
		
		field = report.getField("xZank4" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoFour5));
		
		field = report.getField("xZank5" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoFive5));
		
		field = report.getField("xZank6" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoOverFive5));
		
		field = report.getField("xZank7" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoTotal5));
				
		field = report.getField("xGnpn1" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnOne5));
		
		field = report.getField("xGnpn2" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnTwo5));
		
		field = report.getField("xGnpn3" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnThree5));
		
		field = report.getField("xGnpn4" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnFour5));
		
		field = report.getField("xGnpn5" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnFive5));
		
		field = report.getField("xGnpn6" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnOverFive5));
		
		field = report.getField("xGnpn7" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnTotal5));
				
		field = report.getField("xRsk1" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskOne5));
		
		field = report.getField("xRsk2" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskTwo5));
		
		field = report.getField("xRsk3" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskThree5));
		
		field = report.getField("xRsk4" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskFour5));
		
		field = report.getField("xRsk5" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskFive5));
		
		field = report.getField("xRsk6" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskOverFive5));
		
		field = report.getField("xRsk7" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskTotal5));
		
		field = report.getField("xIji1" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiOne5));
		
		field = report.getField("xIji2" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiTwo5));
		
		field = report.getField("xIji3" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiThree5));
		
		field = report.getField("xIji4" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiFour5));
		
		field = report.getField("xIji5" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiFive5));
		
		field = report.getField("xIji6" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiOverFive5));
		
		field = report.getField("xIji7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiTotal5));
				
		field = report.getField("xEkim1" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimOne5));
		
		field = report.getField("xEkim2" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimTwo5));
		
		field = report.getField("xEkim3" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimThree5));
		
		field = report.getField("xEkim4" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimFour5));
		
		field = report.getField("xEkim5" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimFive5));
		
		field = report.getField("xEkim6" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimOverFive5));
		
		field = report.getField("xEkim7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimTotal5));

		field = report.getField("xStax1" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxOne5));
		
		field = report.getField("xStax2" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxTwo5));
		
		field = report.getField("xStax3" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxThree5));
		
		field = report.getField("xStax4" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxFour5));
		
		field = report.getField("xStax5" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxFive5));
		
		field = report.getField("xStax6" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxOverFive5));
		
		field = report.getField("xStax7" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxTotal5));

		

		lineCount++;
		
    }
    
    // 利息相当額配分方法計
    private void RskHibnGoukei(LACSReportBean piReportBean) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); 
		
		field = report.getField("xMikeikaTitle" + index);
		report.putFieldData(field, "未経過リース料");
			
		field = report.getField("xZankTitle" + index);
		report.putFieldData(field, "残価保証額");
			
		field = report.getField("xGnpnTitle" + index);
		report.putFieldData(field, "元本");
			
		field = report.getField("xRskTitle" + index);
		report.putFieldData(field, "利息");
		
		field = report.getField("xIjiTitle" + index);
		report.putFieldData(field, "維持管理費");
		
		field = report.getField("xEkimTitle" + index);
		report.putFieldData(field, "役務提供費");
		
		field = report.getField("xStaxTitle" + index);
		report.putFieldData(field, "消費税等");
		
		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "利息相当額配分方法計");

		field = report.getField("xMikeika1" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseOne4));
		
		field = report.getField("xMikeika2" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseTwo4));
		
		field = report.getField("xMikeika3" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseThree4));
		
		field = report.getField("xMikeika4" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseFour4));
		
		field = report.getField("xMikeika5" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseFive4));
		
		field = report.getField("xMikeika6" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseOverFive4));
		
		field = report.getField("xMikeika7" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseTotal4));

		field = report.getField("xZank1" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoOne4));
		
		field = report.getField("xZank2" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoTwo4));
		
		field = report.getField("xZank3" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoThree4));
		
		field = report.getField("xZank4" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoFour4));
		
		field = report.getField("xZank5" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoFive4));
		
		field = report.getField("xZank6" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoOverFive4));
		
		field = report.getField("xZank7" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoTotal4));
		
		field = report.getField("xGnpn1" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnOne4));
		
		field = report.getField("xGnpn2" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnTwo4));
		
		field = report.getField("xGnpn3" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnThree4));
		
		field = report.getField("xGnpn4" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnFour4));
		
		field = report.getField("xGnpn5" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnFive4));
		
		field = report.getField("xGnpn6" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnOverFive4));
		
		field = report.getField("xGnpn7" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnTotal4));
				
		field = report.getField("xRsk1" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskOne4));
		
		field = report.getField("xRsk2" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskTwo4));
		
		field = report.getField("xRsk3" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskThree4));
		
		field = report.getField("xRsk4" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskFour4));
		
		field = report.getField("xRsk5" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskFive4));
		
		field = report.getField("xRsk6" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskOverFive4));
		
		field = report.getField("xRsk7" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskTotal4));

		field = report.getField("xIji1" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiOne4));
		
		field = report.getField("xIji2" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiTwo4));
		
		field = report.getField("xIji3" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiThree4));
		
		field = report.getField("xIji4" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiFour4));
		
		field = report.getField("xIji5" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiFive4));
		
		field = report.getField("xIji6" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiOverFive4));
		
		field = report.getField("xIji7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiTotal4));
				
		field = report.getField("xEkim1" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimOne4));
		
		field = report.getField("xEkim2" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimTwo4));
		
		field = report.getField("xEkim3" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimThree4));
		
		field = report.getField("xEkim4" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimFour4));
		
		field = report.getField("xEkim5" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimFive4));
		
		field = report.getField("xEkim6" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimOverFive4));
		
		field = report.getField("xEkim7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimTotal4));

		field = report.getField("xStax1" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxOne4));
		
		field = report.getField("xStax2" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxTwo4));
		
		field = report.getField("xStax3" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxThree4));
		
		field = report.getField("xStax4" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxFour4));
		
		field = report.getField("xStax5" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxFive4));
		
		field = report.getField("xStax6" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxOverFive4));
		
		field = report.getField("xStax7" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxTotal4));

		
		
		lineCount++;
		
    }
    
    // 会計処理方法計
    private void KaikeiSyoriGoukei(LACSReportBean piReportBean) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); 
			
		field = report.getField("xMikeikaTitle" + index);
		report.putFieldData(field, "未経過リース料");
			
		field = report.getField("xZankTitle" + index);
		report.putFieldData(field, "残価保証額");
			
		field = report.getField("xGnpnTitle" + index);
		report.putFieldData(field, "元本");
			
		field = report.getField("xRskTitle" + index);
		report.putFieldData(field, "利息");
		
		field = report.getField("xIjiTitle" + index);
		report.putFieldData(field, "維持管理費");
		
		field = report.getField("xEkimTitle" + index);
		report.putFieldData(field, "役務提供費");
		
		field = report.getField("xStaxTitle" + index);
		report.putFieldData(field, "消費税等");
		
		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "会計処理方法計");

		field = report.getField("xMikeika1" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseOne3));
		
		field = report.getField("xMikeika2" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseTwo3));
		
		field = report.getField("xMikeika3" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseThree3));
		
		field = report.getField("xMikeika4" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseFour3));
		
		field = report.getField("xMikeika5" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseFive3));
		
		field = report.getField("xMikeika6" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseOverFive3));
		
		field = report.getField("xMikeika7" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseTotal3));
		
		field = report.getField("xZank1" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoOne3));
		
		field = report.getField("xZank2" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoTwo3));
		
		field = report.getField("xZank3" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoThree3));
		
		field = report.getField("xZank4" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoFour3));
		
		field = report.getField("xZank5" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoFive3));
		
		field = report.getField("xZank6" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoOverFive3));
		
		field = report.getField("xZank7" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoTotal3));
		
		field = report.getField("xGnpn1" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnOne3));
		
		field = report.getField("xGnpn2" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnTwo3));
		
		field = report.getField("xGnpn3" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnThree3));
		
		field = report.getField("xGnpn4" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnFour3));
		
		field = report.getField("xGnpn5" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnFive3));
		
		field = report.getField("xGnpn6" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnOverFive3));
		
		field = report.getField("xGnpn7" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnTotal3));
				
		field = report.getField("xRsk1" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskOne3));
		
		field = report.getField("xRsk2" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskTwo3));
		
		field = report.getField("xRsk3" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskThree3));
		
		field = report.getField("xRsk4" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskFour3));
		
		field = report.getField("xRsk5" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskFive3));
		
		field = report.getField("xRsk6" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskOverFive3));
		
		field = report.getField("xRsk7" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskTotal3));

		field = report.getField("xIji1" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiOne3));
		
		field = report.getField("xIji2" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiTwo3));
		
		field = report.getField("xIji3" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiThree3));
		
		field = report.getField("xIji4" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiFour3));
		
		field = report.getField("xIji5" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiFive3));
		
		field = report.getField("xIji6" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiOverFive3));
		
		field = report.getField("xIji7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiTotal3));
				
		field = report.getField("xEkim1" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimOne3));
		
		field = report.getField("xEkim2" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimTwo3));
		
		field = report.getField("xEkim3" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimThree3));
		
		field = report.getField("xEkim4" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimFour3));
		
		field = report.getField("xEkim5" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimFive3));
		
		field = report.getField("xEkim6" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimOverFive3));
		
		field = report.getField("xEkim7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimTotal3));

		field = report.getField("xStax1" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxOne3));
		
		field = report.getField("xStax2" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxTwo3));
		
		field = report.getField("xStax3" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxThree3));
		
		field = report.getField("xStax4" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxFour3));
		
		field = report.getField("xStax5" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxFive3));
		
		field = report.getField("xStax6" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxOverFive3));
		
		field = report.getField("xStax7" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxTotal3));

		
		
		lineCount++;

    }

    // リース取引分類計
    private void LeaseTorihikiGoukei(LACSReportBean piReportBean) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); 
				
		field = report.getField("xMikeikaTitle" + index);
		report.putFieldData(field, "未経過リース料");
			
		field = report.getField("xZankTitle" + index);
		report.putFieldData(field, "残価保証額");
			
		field = report.getField("xGnpnTitle" + index);
		report.putFieldData(field, "元本");
			
		field = report.getField("xRskTitle" + index);
		report.putFieldData(field, "利息");
		
		field = report.getField("xIjiTitle" + index);
		report.putFieldData(field, "維持管理費");
		
		field = report.getField("xEkimTitle" + index);
		report.putFieldData(field, "役務提供費");
		
		field = report.getField("xStaxTitle" + index);
		report.putFieldData(field, "消費税等");
		
		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "リース取引分類計");

		field = report.getField("xMikeika1" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseOne2));
		
		field = report.getField("xMikeika2" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseTwo2));
		
		field = report.getField("xMikeika3" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseThree2));
		
		field = report.getField("xMikeika4" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseFour2));
		
		field = report.getField("xMikeika5" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseFive2));
		
		field = report.getField("xMikeika6" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseOverFive2));
		
		field = report.getField("xMikeika7" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseTotal2));		
		
		field = report.getField("xZank1" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoOne2));
		
		field = report.getField("xZank2" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoTwo2));
		
		field = report.getField("xZank3" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoThree2));
		
		field = report.getField("xZank4" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoFour2));
		
		field = report.getField("xZank5" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoFive2));
		
		field = report.getField("xZank6" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoOverFive2));
		
		field = report.getField("xZank7" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoTotal2));
		
		field = report.getField("xGnpn1" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnOne2));
		
		field = report.getField("xGnpn2" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnTwo2));
		
		field = report.getField("xGnpn3" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnThree2));
		
		field = report.getField("xGnpn4" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnFour2));
		
		field = report.getField("xGnpn5" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnFive2));
		
		field = report.getField("xGnpn6" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnOverFive2));
		
		field = report.getField("xGnpn7" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnTotal2));
				
		field = report.getField("xRsk1" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskOne2));
		
		field = report.getField("xRsk2" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskTwo2));
		
		field = report.getField("xRsk3" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskThree2));
		
		field = report.getField("xRsk4" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskFour2));
		
		field = report.getField("xRsk5" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskFive2));
		
		field = report.getField("xRsk6" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskOverFive2));
		
		field = report.getField("xRsk7" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskTotal2));

		field = report.getField("xIji1" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiOne2));
		
		field = report.getField("xIji2" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiTwo2));
		
		field = report.getField("xIji3" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiThree2));
		
		field = report.getField("xIji4" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiFour2));
		
		field = report.getField("xIji5" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiFive2));
		
		field = report.getField("xIji6" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiOverFive2));
		
		field = report.getField("xIji7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiTotal2));
				
		field = report.getField("xEkim1" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimOne2));
		
		field = report.getField("xEkim2" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimTwo2));
		
		field = report.getField("xEkim3" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimThree2));
		
		field = report.getField("xEkim4" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimFour2));
		
		field = report.getField("xEkim5" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimFive2));
		
		field = report.getField("xEkim6" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimOverFive2));
		
		field = report.getField("xEkim7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimTotal2));

		field = report.getField("xStax1" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxOne2));
		
		field = report.getField("xStax2" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxTwo2));
		
		field = report.getField("xStax3" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxThree2));
		
		field = report.getField("xStax4" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxFour2));
		
		field = report.getField("xStax5" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxFive2));
		
		field = report.getField("xStax6" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxOverFive2));
		
		field = report.getField("xStax7" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxTotal2));

		
		
		lineCount++;
    }

    // 重要性有無計
    private void JysiUmGoukei(LACSReportBean piReportBean) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); 
				
		field = report.getField("xMikeikaTitle" + index);
		report.putFieldData(field, "未経過リース料");
			
		field = report.getField("xZankTitle" + index);
		report.putFieldData(field, "残価保証額");
			
		field = report.getField("xGnpnTitle" + index);
		report.putFieldData(field, "元本");
			
		field = report.getField("xRskTitle" + index);
		report.putFieldData(field, "利息");
		
		field = report.getField("xIjiTitle" + index);
		report.putFieldData(field, "維持管理費");
		
		field = report.getField("xEkimTitle" + index);
		report.putFieldData(field, "役務提供費");
		
		field = report.getField("xStaxTitle" + index);
		report.putFieldData(field, "消費税等");
		
		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "重要性有無計");

		field = report.getField("xMikeika1" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseOne1));
		
		field = report.getField("xMikeika2" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseTwo1));
		
		field = report.getField("xMikeika3" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseThree1));
		
		field = report.getField("xMikeika4" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseFour1));
		
		field = report.getField("xMikeika5" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseFive1));
		
		field = report.getField("xMikeika6" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseOverFive1));
		
		field = report.getField("xMikeika7" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseTotal1));

		field = report.getField("xZank1" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoOne1));
		
		field = report.getField("xZank2" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoTwo1));
		
		field = report.getField("xZank3" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoThree1));
		
		field = report.getField("xZank4" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoFour1));
		
		field = report.getField("xZank5" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoFive1));
		
		field = report.getField("xZank6" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoOverFive1));
		
		field = report.getField("xZank7" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoTotal1));
		
		field = report.getField("xGnpn1" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnOne1));
		
		field = report.getField("xGnpn2" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnTwo1));
		
		field = report.getField("xGnpn3" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnThree1));
		
		field = report.getField("xGnpn4" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnFour1));
		
		field = report.getField("xGnpn5" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnFive1));
		
		field = report.getField("xGnpn6" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnOverFive1));
		
		field = report.getField("xGnpn7" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnTotal1));
				
		field = report.getField("xRsk1" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskOne1));
		
		field = report.getField("xRsk2" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskTwo1));
		
		field = report.getField("xRsk3" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskThree1));
		
		field = report.getField("xRsk4" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskFour1));
		
		field = report.getField("xRsk5" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskFive1));
		
		field = report.getField("xRsk6" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskOverFive1));
		
		field = report.getField("xRsk7" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskTotal1));

		field = report.getField("xIji1" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiOne1));
		
		field = report.getField("xIji2" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiTwo1));
		
		field = report.getField("xIji3" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiThree1));
		
		field = report.getField("xIji4" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiFour1));
		
		field = report.getField("xIji5" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiFive1));
		
		field = report.getField("xIji6" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiOverFive1));
		
		field = report.getField("xIji7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiTotal1));
				
		field = report.getField("xEkim1" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimOne1));
		
		field = report.getField("xEkim2" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimTwo1));
		
		field = report.getField("xEkim3" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimThree1));
		
		field = report.getField("xEkim4" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimFour1));
		
		field = report.getField("xEkim5" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimFive1));
		
		field = report.getField("xEkim6" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimOverFive1));
		
		field = report.getField("xEkim7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimTotal1));

		field = report.getField("xStax1" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxOne1));
		
		field = report.getField("xStax2" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxTwo1));
		
		field = report.getField("xStax3" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxThree1));
		
		field = report.getField("xStax4" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxFour1));
		
		field = report.getField("xStax5" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxFive1));
		
		field = report.getField("xStax6" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxOverFive1));
		
		field = report.getField("xStax7" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxTotal1));

		
		
		lineCount++;
    }

    // リース会社計
    @SuppressWarnings("unused")
	private void LeaseCompanyGoukei(LACSReportBean piReportBean) throws Exception {
		Field field = null;

		index = "." + Convert.toString(lineCount); 
				
		field = report.getField("xMikeikaTitle" + index);
		report.putFieldData(field, "未経過リース料");
			
		field = report.getField("xZankTitle" + index);
		report.putFieldData(field, "残価保証額");
			
		field = report.getField("xGnpnTitle" + index);
		report.putFieldData(field, "元本");
			
		field = report.getField("xRskTitle" + index);
		report.putFieldData(field, "利息");
		
		field = report.getField("xIjiTitle" + index);
		report.putFieldData(field, "維持管理費");
		
		field = report.getField("xEkimTitle" + index);
		report.putFieldData(field, "役務提供費");
		
		field = report.getField("xStaxTitle" + index);
		report.putFieldData(field, "消費税等");
		
		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "リース会社計");

		field = report.getField("xMikeika1" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseOne0));
		
		field = report.getField("xMikeika2" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseTwo0));
		
		field = report.getField("xMikeika3" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseThree0));
		
		field = report.getField("xMikeika4" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseFour0));
		
		field = report.getField("xMikeika5" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseFive0));
		
		field = report.getField("xMikeika6" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseOverFive0));
		
		field = report.getField("xMikeika7" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseTotal0));
		
		field = report.getField("xZank1" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoOne0));
		
		field = report.getField("xZank2" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoTwo0));
		
		field = report.getField("xZank3" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoThree0));
		
		field = report.getField("xZank4" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoFour0));
		
		field = report.getField("xZank5" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoFive0));
		
		field = report.getField("xZank6" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoOverFive0));
		
		field = report.getField("xZank7" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoTotal0));
		
		field = report.getField("xGnpn1" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnOne0));
		
		field = report.getField("xGnpn2" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnTwo0));
		
		field = report.getField("xGnpn3" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnThree0));
		
		field = report.getField("xGnpn4" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnFour0));
		
		field = report.getField("xGnpn5" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnFive0));
		
		field = report.getField("xGnpn6" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnOverFive0));
		
		field = report.getField("xGnpn7" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnTotal0));
				
		field = report.getField("xRsk1" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskOne0));
		
		field = report.getField("xRsk2" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskTwo0));
		
		field = report.getField("xRsk3" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskThree0));
		
		field = report.getField("xRsk4" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskFour0));
		
		field = report.getField("xRsk5" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskFive0));
		
		field = report.getField("xRsk6" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskOverFive0));
		
		field = report.getField("xRsk7" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskTotal0));

		field = report.getField("xIji1" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiOne0));
		
		field = report.getField("xIji2" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiTwo0));
		
		field = report.getField("xIji3" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiThree0));
		
		field = report.getField("xIji4" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiFour0));
		
		field = report.getField("xIji5" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiFive0));
		
		field = report.getField("xIji6" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiOverFive0));
		
		field = report.getField("xIji7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiTotal0));
				
		field = report.getField("xEkim1" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimOne0));
		
		field = report.getField("xEkim2" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimTwo0));
		
		field = report.getField("xEkim3" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimThree0));
		
		field = report.getField("xEkim4" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimFour0));
		
		field = report.getField("xEkim5" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimFive0));
		
		field = report.getField("xEkim6" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimOverFive0));
		
		field = report.getField("xEkim7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimTotal0));

		field = report.getField("xStax1" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxOne0));
		
		field = report.getField("xStax2" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxTwo0));
		
		field = report.getField("xStax3" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxThree0));
		
		field = report.getField("xStax4" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxFour0));
		
		field = report.getField("xStax5" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxFive0));
		
		field = report.getField("xStax6" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxOverFive0));
		
		field = report.getField("xStax7" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxTotal0));
		
		lineCount++;

    }
    
    private void souGokeiPrint(LACSReportBean piReportBean) throws Exception {
    	
    	Field field = null;
		index = "." + Convert.toString(lineCount);
		
		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "総合計");

		field = report.getField("xMikeikaTitle" + index);
		report.putFieldData(field, "未経過リース料");
			
		field = report.getField("xZankTitle" + index);
		report.putFieldData(field, "残価保証額");
			
		field = report.getField("xGnpnTitle" + index);
		report.putFieldData(field, "元本");
			
		field = report.getField("xRskTitle" + index);
		report.putFieldData(field, "利息");
		
		field = report.getField("xIjiTitle" + index);
		report.putFieldData(field, "維持管理費");
		
		field = report.getField("xEkimTitle" + index);
		report.putFieldData(field, "役務提供費");
		
		field = report.getField("xStaxTitle" + index);
		report.putFieldData(field, "消費税等");
		
		field = report.getField("xMikeika1" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseOne));
		
		field = report.getField("xMikeika2" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseTwo));
		
		field = report.getField("xMikeika3" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseThree));
		
		field = report.getField("xMikeika4" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseFour));
		
		field = report.getField("xMikeika5" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseFive));
		
		field = report.getField("xMikeika6" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseOverFive));
		
		field = report.getField("xMikeika7" + index);
		report.putFieldData(field, StringUtl.formatNumber(mikeikaLeaseTotal));
		
		field = report.getField("xZank1" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoOne));
		
		field = report.getField("xZank2" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoTwo));
		
		field = report.getField("xZank3" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoThree));
		
		field = report.getField("xZank4" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoFour));
		
		field = report.getField("xZank5" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoFive));
		
		field = report.getField("xZank6" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoOverFive));
		
		field = report.getField("xZank7" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoTotal));
		
		field = report.getField("xGnpn1" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnOne));
		
		field = report.getField("xGnpn2" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnTwo));
		
		field = report.getField("xGnpn3" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnThree));
		
		field = report.getField("xGnpn4" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnFour));
		
		field = report.getField("xGnpn5" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnFive));
		
		field = report.getField("xGnpn6" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnOverFive));
		
		field = report.getField("xGnpn7" + index);
		report.putFieldData(field, StringUtl.formatNumber(gnpnTotal));
				
		field = report.getField("xRsk1" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskOne));
		
		field = report.getField("xRsk2" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskTwo));
		
		field = report.getField("xRsk3" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskThree));
		
		field = report.getField("xRsk4" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskFour));
		
		field = report.getField("xRsk5" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskFive));
		
		field = report.getField("xRsk6" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskOverFive));
		
		field = report.getField("xRsk7" + index);
		report.putFieldData(field, StringUtl.formatNumber(rskTotal));

		field = report.getField("xIji1" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiOne));
		
		field = report.getField("xIji2" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiTwo));
		
		field = report.getField("xIji3" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiThree));
		
		field = report.getField("xIji4" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiFour));
		
		field = report.getField("xIji5" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiFive));
		
		field = report.getField("xIji6" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiOverFive));
		
		field = report.getField("xIji7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ijiTotal));
				
		field = report.getField("xEkim1" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimOne));
		
		field = report.getField("xEkim2" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimTwo));
		
		field = report.getField("xEkim3" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimThree));
		
		field = report.getField("xEkim4" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimFour));
		
		field = report.getField("xEkim5" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimFive));
		
		field = report.getField("xEkim6" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimOverFive));
		
		field = report.getField("xEkim7" + index);
		report.putFieldData(field, StringUtl.formatNumber(ekimTotal));

		field = report.getField("xStax1" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxOne));
		
		field = report.getField("xStax2" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxTwo));
		
		field = report.getField("xStax3" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxThree));
		
		field = report.getField("xStax4" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxFour));
		
		field = report.getField("xStax5" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxFive));
		
		field = report.getField("xStax6" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxOverFive));
		
		field = report.getField("xStax7" + index);
		report.putFieldData(field, StringUtl.formatNumber(staxTotal));

		lineCount++;
		
	}
    
}
