package jp.co.pro_app.lacs.affairs.ukebarai.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiLeaseBean;
import jp.co.pro_app.lacs.affairs.ukebarai.data.entity.LACSUkebaraiLeaseEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

/**
 * 受払合計表：リース料受払明細表 PDF Model.
 * 
 * @author active
 * @version 20080814
 */
public class LACSUkebaraiPDFLeaseWriter extends LACSUkebaraiPDFWriterBase {

	private Report					report						= null; // WebKCoreレポートオブジェクト

	private LACSUkebaraiLeaseBean	detail						= null;

	private int						souPage						= 0;	// 総ページ数

	private int						page						= 0;	// ページ

	private int						lineCount					= 0;	// 明細カウンタ

	private String					brakeKey0					= "";	// ブレイクキー

	private String					brakeKey1					= "";	// ブレイクキー

	// 2020/05/22 ADD START
	private String					brakeKey1_0					= "";	// ブレイクキー
	// 2020/05/22 ADD END

	private String					brakeKey2					= "";	// ブレイクキー

	private String					brakeKey3					= "";	// ブレイクキー

	private String					brakeKey4					= "";	// ブレイクキー

	private String					brakeKey5					= "";	// ブレイクキー

	private String					index						= "";	// 明細行修飾子

	private long					leasAmtSougaku				= 0;	// リース料総額

	private long					zankaHosyoAmt				= 0;	// 残価保証額

	private long					saimuSougaku				= 0;	// リース債務 総額

	private long					saimuZenkimatuAmt			= 0;	// リース債務 前期末

	private long					saimuToukiZoukaAmt			= 0;	// リース債務 当期検収

	private long					saimuToukiJitugenAmt		= 0;	// リース債務 当期実現

	private long					saimuToukiGensyoAmt			= 0;	// リース債務 当期減少

	private long					saimuToukimatuAmt			= 0;	// リース債務 当期末

	// 2020/05/22 ADD START
	private long					zankSougaku					= 0;	// 残価保証額 総額

	private long					zankZenkimatuAmt			= 0;	// 残価保証額 前期末

	private long					zankToukiZoukaAmt			= 0;	// 残価保証額 当期検収

	@SuppressWarnings("unused")
	private long					zankToukiJitugenAmt			= 0;	// 残価保証額 当期実現

	private long					zankToukiGensyoAmt			= 0;	// 残価保証額 当期減少

	private long					zankToukimatuAmt			= 0;	// 残価保証額 当期末
	// 2020/05/22 ADD END

	private long					rskSougaku					= 0;	// 利息総額

	private long					rskZenkimatuAmt				= 0;	// 利息前期末

	private long					rskToukiJitugenAmt			= 0;	// 利息当期実現

	private long					rskToukiGensyoAmt			= 0;	// 利息 当期減少

	private long					rskToukimatuAmt				= 0;	// 利息当期末

	private long					ijiSougaku					= 0;	// 維持管理費総額

	private long					ijiZenkimatuAmt				= 0;	// 維持管理費前期末

	private long					ijiToukiJitugenAmt			= 0;	// 維持管理費当期実現

	private long					ijiToukiGensyoAmt			= 0;	// 維持管理費 当期減少

	private long					ijiToukimatuAmt				= 0;	// 維持管理費当期末

	private long					ekmSougaku					= 0;	// 役務提供費総額

	private long					ekmZenkimatuAmt				= 0;	// 役務提供費前期末

	private long					ekmToukiJitugenAmt			= 0;	// 役務提供費当期実現

	private long					ekmToukiGensyoAmt			= 0;	// 役務提供費 当期減少

	private long					ekmToukimatuAmt				= 0;	// 役務提供費当期末

	private long					leasAmtRuiSougaku			= 0;	// リース料累計 総額

	private long					leasAmtRuiZenkimatuAmt		= 0;	// リース料累計 前期末

	private long					leasAmtRuiToukiJitugenAmt	= 0;	// リース料累計 当期実現

	private long					leasAmtRuiToukiGensyoAmt	= 0;	// リース料累計 当期減少

	private long					leasAmtRuiToukimatuAmt		= 0;	// リース料累計 当期末

	private long					mibaraiSougaku				= 0;	// 未払金(消費税)総額

	private long					mibaraiZenkimatuAmt			= 0;	// 未払金(消費税)前期末

	private long					mibaraiToukiZoukaAmt		= 0;	// 未払金(消費税)当期検収

	private long					mibaraiToukiJitugenAmt		= 0;	// 未払金(消費税)当期実現

	private long					mibaraiToukiGensyoAmt		= 0;	// 未払金(消費税)当期減少

	private long					mibaraiToukimatuAmt			= 0;	// 未払金(消費税)当期末

	private long					leasAmtSougaku1				= 0;	// リース料総額

	private long					zankaHosyoAmt1				= 0;	// 残価保証額

	private long					saimuSougaku1				= 0;	// リース債務 総額

	private long					saimuZenkimatuAmt1			= 0;	// リース債務 前期末

	private long					saimuToukiZoukaAmt1			= 0;	// リース債務 当期検収

	private long					saimuToukiJitugenAmt1		= 0;	// リース債務 当期実現

	private long					saimuToukiGensyoAmt1		= 0;	// リース債務 当期減少

	private long					saimuToukimatuAmt1			= 0;	// リース債務 当期末

	// 2020/05/22 ADD START
	private long					zankSougaku1				= 0;	// 残価保証額 総額

	private long					zankZenkimatuAmt1			= 0;	// 残価保証額 前期末

	private long					zankToukiZoukaAmt1			= 0;	// 残価保証額 当期検収

	@SuppressWarnings("unused")
	private long					zankToukiJitugenAmt1		= 0;	// 残価保証額 当期実現

	private long					zankToukiGensyoAmt1			= 0;	// 残価保証額 当期減少

	private long					zankToukimatuAmt1			= 0;	// 残価保証額 当期末
	// 2020/05/22 ADD END
	
	private long					rskSougaku1					= 0;	// 利息総額

	private long					rskZenkimatuAmt1			= 0;	// 利息前期末

	private long					rskToukiJitugenAmt1			= 0;	// 利息当期実現

	private long					rskToukiGensyoAmt1			= 0;	// 利息 当期減少

	private long					rskToukimatuAmt1			= 0;	// 利息当期末

	private long					ijiSougaku1					= 0;	// 維持管理費総額

	private long					ijiZenkimatuAmt1			= 0;	// 維持管理費前期末

	private long					ijiToukiJitugenAmt1			= 0;	// 維持管理費当期実現

	private long					ijiToukiGensyoAmt1			= 0;	// 維持管理費 当期減少

	private long					ijiToukimatuAmt1			= 0;	// 維持管理費当期末

	private long					ekmSougaku1					= 0;	// 役務提供費総額

	private long					ekmZenkimatuAmt1			= 0;	// 役務提供費前期末

	private long					ekmToukiJitugenAmt1			= 0;	// 役務提供費当期実現

	private long					ekmToukiGensyoAmt1			= 0;	// 役務提供費 当期減少

	private long					ekmToukimatuAmt1			= 0;	// 役務提供費当期末

	private long					leasAmtRuiSougaku1			= 0;	// リース料累計 総額

	private long					leasAmtRuiZenkimatuAmt1		= 0;	// リース料累計 前期末

	private long					leasAmtRuiToukiJitugenAmt1	= 0;	// リース料累計 当期実現

	private long					leasAmtRuiToukiGensyoAmt1	= 0;	// リース料累計 当期減少

	private long					leasAmtRuiToukimatuAmt1		= 0;	// リース料累計 当期末

	private long					mibaraiSougaku1				= 0;	// 未払金(消費税)総額

	private long					mibaraiZenkimatuAmt1		= 0;	// 未払金(消費税)前期末

	private long					mibaraiToukiZoukaAmt1		= 0;	// 未払金(消費税)当期検収

	private long					mibaraiToukiJitugenAmt1		= 0;	// 未払金(消費税)当期実現

	private long					mibaraiToukiGensyoAmt1		= 0;	// 未払金(消費税)当期減少

	private long					mibaraiToukimatuAmt1		= 0;	// 未払金(消費税)当期末

	// 2020/05/22 ADD START

	private long					leasAmtSougaku1_0				= 0;	// リース料総額

	private long					zankaHosyoAmt1_0				= 0;	// 残価保証額

	private long					saimuSougaku1_0					= 0;	// リース債務 総額

	private long					saimuZenkimatuAmt1_0			= 0;	// リース債務 前期末

	private long					saimuToukiZoukaAmt1_0			= 0;	// リース債務 当期検収

	private long					saimuToukiJitugenAmt1_0			= 0;	// リース債務 当期実現

	private long					saimuToukiGensyoAmt1_0			= 0;	// リース債務 当期減少

	private long					saimuToukimatuAmt1_0			= 0;	// リース債務 当期末

	private long					zankSougaku1_0					= 0;	// 残価保証額 総額

	private long					zankZenkimatuAmt1_0				= 0;	// 残価保証額 前期末

	private long					zankToukiZoukaAmt1_0			= 0;	// 残価保証額 当期検収

	@SuppressWarnings("unused")
	private long					zankToukiJitugenAmt1_0			= 0;	// 残価保証額 当期実現

	private long					zankToukiGensyoAmt1_0			= 0;	// 残価保証額 当期減少

	private long					zankToukimatuAmt1_0				= 0;	// 残価保証額 当期末
	
	private long					rskSougaku1_0					= 0;	// 利息総額

	private long					rskZenkimatuAmt1_0				= 0;	// 利息前期末

	private long					rskToukiJitugenAmt1_0			= 0;	// 利息当期実現

	private long					rskToukiGensyoAmt1_0			= 0;	// 利息 当期減少

	private long					rskToukimatuAmt1_0				= 0;	// 利息当期末

	private long					ijiSougaku1_0					= 0;	// 維持管理費総額

	private long					ijiZenkimatuAmt1_0				= 0;	// 維持管理費前期末

	private long					ijiToukiJitugenAmt1_0			= 0;	// 維持管理費当期実現

	private long					ijiToukiGensyoAmt1_0			= 0;	// 維持管理費 当期減少

	private long					ijiToukimatuAmt1_0				= 0;	// 維持管理費当期末

	private long					ekmSougaku1_0					= 0;	// 役務提供費総額

	private long					ekmZenkimatuAmt1_0				= 0;	// 役務提供費前期末

	private long					ekmToukiJitugenAmt1_0			= 0;	// 役務提供費当期実現

	private long					ekmToukiGensyoAmt1_0			= 0;	// 役務提供費 当期減少

	private long					ekmToukimatuAmt1_0				= 0;	// 役務提供費当期末

	private long					leasAmtRuiSougaku1_0			= 0;	// リース料累計 総額

	private long					leasAmtRuiZenkimatuAmt1_0		= 0;	// リース料累計 前期末

	private long					leasAmtRuiToukiJitugenAmt1_0	= 0;	// リース料累計 当期実現

	private long					leasAmtRuiToukiGensyoAmt1_0		= 0;	// リース料累計 当期減少

	private long					leasAmtRuiToukimatuAmt1_0		= 0;	// リース料累計 当期末

	private long					mibaraiSougaku1_0				= 0;	// 未払金(消費税)総額

	private long					mibaraiZenkimatuAmt1_0			= 0;	// 未払金(消費税)前期末

	private long					mibaraiToukiZoukaAmt1_0			= 0;	// 未払金(消費税)当期検収

	private long					mibaraiToukiJitugenAmt1_0		= 0;	// 未払金(消費税)当期実現

	private long					mibaraiToukiGensyoAmt1_0		= 0;	// 未払金(消費税)当期減少

	private long					mibaraiToukimatuAmt1_0			= 0;	// 未払金(消費税)当期末

	// 2020/05/22 ADD END
	
	private long					leasAmtSougaku2				= 0;	// リース料総額

	private long					zankaHosyoAmt2				= 0;	// 残価保証額

	private long					saimuSougaku2				= 0;	// リース債務 総額

	private long					saimuZenkimatuAmt2			= 0;	// リース債務 前期末

	private long					saimuToukiZoukaAmt2			= 0;	// リース債務 当期検収

	private long					saimuToukiJitugenAmt2		= 0;	// リース債務 当期実現

	private long					saimuToukiGensyoAmt2		= 0;	// リース債務 当期減少

	private long					saimuToukimatuAmt2			= 0;	// リース債務 当期末

	// 2020/05/22 ADD START
	private long					zankSougaku2				= 0;	// 残価保証額 総額

	private long					zankZenkimatuAmt2			= 0;	// 残価保証額 前期末

	private long					zankToukiZoukaAmt2			= 0;	// 残価保証額 当期検収

	@SuppressWarnings("unused")
	private long					zankToukiJitugenAmt2		= 0;	// 残価保証額 当期実現

	private long					zankToukiGensyoAmt2			= 0;	// 残価保証額 当期減少

	private long					zankToukimatuAmt2			= 0;	// 残価保証額 当期末
	// 2020/05/22 ADD END

	private long					rskSougaku2					= 0;	// 利息総額

	private long					rskZenkimatuAmt2			= 0;	// 利息前期末

	private long					rskToukiJitugenAmt2			= 0;	// 利息当期実現

	private long					rskToukiGensyoAmt2			= 0;	// 利息 当期減少

	private long					rskToukimatuAmt2			= 0;	// 利息当期末

	private long					ijiSougaku2					= 0;	// 維持管理費総額

	private long					ijiZenkimatuAmt2			= 0;	// 維持管理費前期末

	private long					ijiToukiJitugenAmt2			= 0;	// 維持管理費当期実現

	private long					ijiToukiGensyoAmt2			= 0;	// 維持管理費 当期減少

	private long					ijiToukimatuAmt2			= 0;	// 維持管理費当期末

	private long					ekmSougaku2					= 0;	// 役務提供費総額

	private long					ekmZenkimatuAmt2			= 0;	// 役務提供費前期末

	private long					ekmToukiJitugenAmt2			= 0;	// 役務提供費当期実現

	private long					ekmToukiGensyoAmt2			= 0;	// 役務提供費 当期減少

	private long					ekmToukimatuAmt2			= 0;	// 役務提供費当期末

	private long					leasAmtRuiSougaku2			= 0;	// リース料累計 総額

	private long					leasAmtRuiZenkimatuAmt2		= 0;	// リース料累計 前期末

	private long					leasAmtRuiToukiJitugenAmt2	= 0;	// リース料累計 当期実現

	private long					leasAmtRuiToukiGensyoAmt2	= 0;	// リース料累計 当期減少

	private long					leasAmtRuiToukimatuAmt2		= 0;	// リース料累計 当期末

	private long					mibaraiSougaku2				= 0;	// 未払金(消費税)総額

	private long					mibaraiZenkimatuAmt2		= 0;	// 未払金(消費税)前期末

	private long					mibaraiToukiZoukaAmt2		= 0;	// 未払金(消費税)当期検収

	private long					mibaraiToukiJitugenAmt2		= 0;	// 未払金(消費税)当期実現

	private long					mibaraiToukiGensyoAmt2		= 0;	// 未払金(消費税)当期減少

	private long					mibaraiToukimatuAmt2		= 0;	// 未払金(消費税)当期末

	private long					leasAmtSougaku3				= 0;	// リース料総額

	private long					zankaHosyoAmt3				= 0;	// 残価保証額

	private long					saimuSougaku3				= 0;	// リース債務 総額

	private long					saimuZenkimatuAmt3			= 0;	// リース債務 前期末

	private long					saimuToukiZoukaAmt3			= 0;	// リース債務 当期検収

	private long					saimuToukiJitugenAmt3		= 0;	// リース債務 当期実現

	private long					saimuToukiGensyoAmt3		= 0;	// リース債務 当期減少

	private long					saimuToukimatuAmt3			= 0;	// リース債務 当期末

	// 2020/05/22 ADD START
	private long					zankSougaku3				= 0;	// 残価保証額 総額

	private long					zankZenkimatuAmt3			= 0;	// 残価保証額 前期末

	private long					zankToukiZoukaAmt3			= 0;	// 残価保証額 当期検収

	@SuppressWarnings("unused")
	private long					zankToukiJitugenAmt3		= 0;	// 残価保証額 当期実現

	private long					zankToukiGensyoAmt3			= 0;	// 残価保証額 当期減少

	private long					zankToukimatuAmt3			= 0;	// 残価保証額 当期末
	// 2020/05/22 ADD END

	private long					rskSougaku3					= 0;	// 利息総額

	private long					rskZenkimatuAmt3			= 0;	// 利息前期末

	private long					rskToukiJitugenAmt3			= 0;	// 利息当期実現

	private long					rskToukiGensyoAmt3			= 0;	// 利息 当期減少

	private long					rskToukimatuAmt3			= 0;	// 利息当期末

	private long					ijiSougaku3					= 0;	// 維持管理費総額

	private long					ijiZenkimatuAmt3			= 0;	// 維持管理費前期末

	private long					ijiToukiJitugenAmt3			= 0;	// 維持管理費当期実現

	private long					ijiToukiGensyoAmt3			= 0;	// 維持管理費 当期減少

	private long					ijiToukimatuAmt3			= 0;	// 維持管理費当期末

	private long					ekmSougaku3					= 0;	// 役務提供費総額

	private long					ekmZenkimatuAmt3			= 0;	// 役務提供費前期末

	private long					ekmToukiJitugenAmt3			= 0;	// 役務提供費当期実現

	private long					ekmToukiGensyoAmt3			= 0;	// 役務提供費 当期減少

	private long					ekmToukimatuAmt3			= 0;	// 役務提供費当期末

	private long					leasAmtRuiSougaku3			= 0;	// リース料累計 総額

	private long					leasAmtRuiZenkimatuAmt3		= 0;	// リース料累計 前期末

	private long					leasAmtRuiToukiJitugenAmt3	= 0;	// リース料累計 当期実現

	private long					leasAmtRuiToukiGensyoAmt3	= 0;	// リース料累計 当期減少

	private long					leasAmtRuiToukimatuAmt3		= 0;	// リース料累計 当期末

	private long					mibaraiSougaku3				= 0;	// 未払金(消費税)総額

	private long					mibaraiZenkimatuAmt3		= 0;	// 未払金(消費税)前期末

	private long					mibaraiToukiZoukaAmt3		= 0;	// 未払金(消費税)当期検収

	private long					mibaraiToukiJitugenAmt3		= 0;	// 未払金(消費税)当期実現

	private long					mibaraiToukiGensyoAmt3		= 0;	// 未払金(消費税)当期減少

	private long					mibaraiToukimatuAmt3		= 0;	// 未払金(消費税)当期末

	private long					leasAmtSougaku4				= 0;	// リース料総額

	private long					zankaHosyoAmt4				= 0;	// 残価保証額

	private long					saimuSougaku4				= 0;	// リース債務 総額

	private long					saimuZenkimatuAmt4			= 0;	// リース債務 前期末

	private long					saimuToukiZoukaAmt4			= 0;	// リース債務 当期検収

	private long					saimuToukiJitugenAmt4		= 0;	// リース債務 当期実現

	private long					saimuToukiGensyoAmt4		= 0;	// リース債務 当期減少

	private long					saimuToukimatuAmt4			= 0;	// リース債務 当期末

	// 2020/05/22 ADD START
	private long					zankSougaku4				= 0;	// 残価保証額 総額

	private long					zankZenkimatuAmt4			= 0;	// 残価保証額 前期末

	private long					zankToukiZoukaAmt4			= 0;	// 残価保証額 当期検収

	@SuppressWarnings("unused")
	private long					zankToukiJitugenAmt4		= 0;	// 残価保証額 当期実現

	private long					zankToukiGensyoAmt4			= 0;	// 残価保証額 当期減少

	private long					zankToukimatuAmt4			= 0;	// 残価保証額 当期末
	// 2020/05/22 ADD END

	private long					rskSougaku4					= 0;	// 利息総額

	private long					rskZenkimatuAmt4			= 0;	// 利息前期末

	private long					rskToukiJitugenAmt4			= 0;	// 利息当期実現

	private long					rskToukiGensyoAmt4			= 0;	// 利息 当期減少

	private long					rskToukimatuAmt4			= 0;	// 利息当期末

	private long					ijiSougaku4					= 0;	// 維持管理費総額

	private long					ijiZenkimatuAmt4			= 0;	// 維持管理費前期末

	private long					ijiToukiJitugenAmt4			= 0;	// 維持管理費当期実現

	private long					ijiToukiGensyoAmt4			= 0;	// 維持管理費 当期減少

	private long					ijiToukimatuAmt4			= 0;	// 維持管理費当期末

	private long					ekmSougaku4					= 0;	// 役務提供費総額

	private long					ekmZenkimatuAmt4			= 0;	// 役務提供費前期末

	private long					ekmToukiJitugenAmt4			= 0;	// 役務提供費当期実現

	private long					ekmToukiGensyoAmt4			= 0;	// 役務提供費 当期減少

	private long					ekmToukimatuAmt4			= 0;	// 役務提供費当期末

	private long					leasAmtRuiSougaku4			= 0;	// リース料累計 総額

	private long					leasAmtRuiZenkimatuAmt4		= 0;	// リース料累計 前期末

	private long					leasAmtRuiToukiJitugenAmt4	= 0;	// リース料累計 当期実現

	private long					leasAmtRuiToukiGensyoAmt4	= 0;	// リース料累計 当期減少

	private long					leasAmtRuiToukimatuAmt4		= 0;	// リース料累計 当期末

	private long					mibaraiSougaku4				= 0;	// 未払金(消費税)総額

	private long					mibaraiZenkimatuAmt4		= 0;	// 未払金(消費税)前期末

	private long					mibaraiToukiZoukaAmt4		= 0;	// 未払金(消費税)当期検収

	private long					mibaraiToukiJitugenAmt4		= 0;	// 未払金(消費税)当期実現

	private long					mibaraiToukiGensyoAmt4		= 0;	// 未払金(消費税)当期減少

	private long					mibaraiToukimatuAmt4		= 0;	// 未払金(消費税)当期末

	private long					leasAmtSougaku5				= 0;	// リース料総額

	private long					zankaHosyoAmt5				= 0;	// 残価保証額

	private long					saimuSougaku5				= 0;	// リース債務 総額

	private long					saimuZenkimatuAmt5			= 0;	// リース債務 前期末

	private long					saimuToukiZoukaAmt5			= 0;	// リース債務 当期検収

	private long					saimuToukiJitugenAmt5		= 0;	// リース債務 当期実現

	private long					saimuToukiGensyoAmt5		= 0;	// リース債務 当期減少

	private long					saimuToukimatuAmt5			= 0;	// リース債務 当期末

	// 2020/05/22 ADD START
	private long					zankSougaku5				= 0;	// 残価保証額 総額

	private long					zankZenkimatuAmt5			= 0;	// 残価保証額 前期末

	private long					zankToukiZoukaAmt5			= 0;	// 残価保証額 当期検収

	@SuppressWarnings("unused")
	private long					zankToukiJitugenAmt5		= 0;	// 残価保証額 当期実現

	private long					zankToukiGensyoAmt5			= 0;	// 残価保証額 当期減少

	private long					zankToukimatuAmt5			= 0;	// 残価保証額 当期末
	// 2020/05/22 ADD END

	private long					rskSougaku5					= 0;	// 利息総額

	private long					rskZenkimatuAmt5			= 0;	// 利息前期末

	private long					rskToukiJitugenAmt5			= 0;	// 利息当期実現

	private long					rskToukiGensyoAmt5			= 0;	// 利息 当期減少

	private long					rskToukimatuAmt5			= 0;	// 利息当期末

	private long					ijiSougaku5					= 0;	// 維持管理費総額

	private long					ijiZenkimatuAmt5			= 0;	// 維持管理費前期末

	private long					ijiToukiJitugenAmt5			= 0;	// 維持管理費当期実現

	private long					ijiToukiGensyoAmt5			= 0;	// 維持管理費 当期減少

	private long					ijiToukimatuAmt5			= 0;	// 維持管理費当期末

	private long					ekmSougaku5					= 0;	// 役務提供費総額

	private long					ekmZenkimatuAmt5			= 0;	// 役務提供費前期末

	private long					ekmToukiJitugenAmt5			= 0;	// 役務提供費当期実現

	private long					ekmToukiGensyoAmt5			= 0;	// 役務提供費 当期減少

	private long					ekmToukimatuAmt5			= 0;	// 役務提供費当期末

	private long					leasAmtRuiSougaku5			= 0;	// リース料累計 総額

	private long					leasAmtRuiZenkimatuAmt5		= 0;	// リース料累計 前期末

	private long					leasAmtRuiToukiJitugenAmt5	= 0;	// リース料累計 当期実現

	private long					leasAmtRuiToukiGensyoAmt5	= 0;	// リース料累計 当期減少

	private long					leasAmtRuiToukimatuAmt5		= 0;	// リース料累計 当期末

	private long					mibaraiSougaku5				= 0;	// 未払金(消費税)総額

	private long					mibaraiZenkimatuAmt5		= 0;	// 未払金(消費税)前期末

	private long					mibaraiToukiZoukaAmt5		= 0;	// 未払金(消費税)当期検収

	private long					mibaraiToukiJitugenAmt5		= 0;	// 未払金(消費税)当期実現

	private long					mibaraiToukiGensyoAmt5		= 0;	// 未払金(消費税)当期減少

	private long					mibaraiToukimatuAmt5		= 0;	// 未払金(消費税)当期末

	private static final int		MAX_LINE					= 6;	// 明細行数

	private static final String		TRHK_HNTI_OP				= "1";	// オペレーティングリースの区分

	private String					oPKbn						= "";	// 比較用区分

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
			tmpFile = File.createTempFile("pdf23_", ".pdf", scratchDirectory);
			fout = new FileOutputStream(tmpFile);
			File formFile = new File(formDirectory, "LeaseUkebarai.pdf");
			File datFile = new File(formDirectory, "LeaseUkebarai.dat");
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
	public LACSUkebaraiPDFLeaseWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
	}

	/**
	 * リース料受払データ取得. 出力データをBeanに設定して返却する
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	public void getLeaseData(LACSUkebaraiBean piUkebaraiBean) throws SQLException {

		LACSUkebaraiLeaseEntity reportEntity = new LACSUkebaraiLeaseEntity(model, this.commonBean, piUkebaraiBean);
		detail = null;
		try {
			reportEntity.setCon(super.con);

			piUkebaraiBean.setDataMax(reportEntity.execSQL());

			int dataCount = 0;
			while (reportEntity.next()) {
				detail = new LACSUkebaraiLeaseBean();
				piUkebaraiBean.addUkebaraiLeaseBean(detail);
				detail.setBrakeKey0(reportEntity.getBrakeKey0());
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
				detail.setTaishoAcKijyunNm(reportEntity.getTaishoAcKijyunNm());
				detail.setAcShrNm(reportEntity.getAcShrNm());
				detail.setTrdHnteiKekaNm(reportEntity.getTrdHnteiKekaNm());
				detail.setSisanKbn(reportEntity.getSisanKbn());
				detail.setKeiNo(reportEntity.getKeiNo());
				detail.setBknNo(reportEntity.getBknNo());
				detail.setBknNm(reportEntity.getBknNm());
				detail.setKnshuYmd(reportEntity.getKnshuYmd());
				detail.setMryoYmd(reportEntity.getMryoYmd());
				detail.setKaiYmd(reportEntity.getKaiYmd());
				detail.setLeasAmtSougaku(reportEntity.getLeasAmtSougaku());
				detail.setZankaHosyoAmt(reportEntity.getZankaHosyoAmt());
				detail.setSaimuSougaku(reportEntity.getSaimuSougaku());
				detail.setSaimuZenkimatuAmt(reportEntity.getSaimuZenkimatuAmt());
				detail.setSaimuToukiZoukaAmt(reportEntity.getSaimuToukiZoukaAmt());
				detail.setSaimuToukiJitugenAmt(reportEntity.getSaimuToukiJitugenAmt());
				detail.setSaimuToukiGensyoAmt(reportEntity.getSaimuToukiGensyoAmt());
				detail.setSaimuToukimatuAmt(reportEntity.getSaimuToukimatuAmt());
				// 2020/05/22 ADD START
				detail.setZankSougaku(reportEntity.getZankSougaku());
				detail.setZankZenkimatuAmt(reportEntity.getZankZenkimatuAmt());
				detail.setZankToukiZoukaAmt(reportEntity.getZankToukiZoukaAmt());
				detail.setZankToukiJitugenAmt(reportEntity.getZankToukiJitugenAmt());
				detail.setZankToukiGensyoAmt(reportEntity.getZankToukiGensyoAmt());
				detail.setZankToukimatuAmt(reportEntity.getZankToukimatuAmt());
				// 2020/05/22 ADD END
				detail.setRskSougaku(reportEntity.getRskSougaku());
				detail.setRskZenkimatuAmt(reportEntity.getRskZenkimatuAmt());
				detail.setRskToukiJitugenAmt(reportEntity.getRskToukiJitugenAmt());
				detail.setRskToukiGensyoAmt(reportEntity.getRskToukiGensyoAmt());
				detail.setRskToukimatuAmt(reportEntity.getRskToukimatuAmt());
				detail.setIjiSougaku(reportEntity.getIjiSougaku());
				detail.setIjiZenkimatuAmt(reportEntity.getIjiZenkimatuAmt());
				detail.setIjiToukiJitugenAmt(reportEntity.getIjiToukiJitugenAmt());
				detail.setIjiToukiGensyoAmt(reportEntity.getIjiToukiGensyoAmt());
				detail.setIjiToukimatuAmt(reportEntity.getIjiToukimatuAmt());
				detail.setEkmSougaku(reportEntity.getEkmSougaku());
				detail.setEkmZenkimatuAmt(reportEntity.getEkmZenkimatuAmt());
				detail.setEkmToukiJitugenAmt(reportEntity.getEkmToukiJitugenAmt());
				detail.setEkmToukiGensyoAmt(reportEntity.getEkmToukiGensyoAmt());
				detail.setEkmToukimatuAmt(reportEntity.getEkmToukimatuAmt());
				detail.setLeasAmtRuiSougaku(reportEntity.getLeasAmtRuiSougaku());
				detail.setLeasAmtRuiZenkimatuAmt(reportEntity.getLeasAmtRuiZenkimatuAmt());
				detail.setLeasAmtRuiToukiJitugenAmt(reportEntity.getLeasAmtRuiToukiJitugenAmt());
				detail.setLeasAmtRuiToukiGensyoAmt(reportEntity.getLeasAmtRuiToukiGensyoAmt());
				detail.setLeasAmtRuiToukimatuAmt(reportEntity.getLeasAmtRuiToukimatuAmt());
				detail.setMibaraiSougaku(reportEntity.getMibaraiSougaku());
				detail.setMibaraiZenkimatuAmt(reportEntity.getMibaraiZenkimatuAmt());
				detail.setMibaraiToukiZoukaAmt(reportEntity.getMibaraiToukiZoukaAmt());
				detail.setMibaraiToukiJitugenAmt(reportEntity.getMibaraiToukiJitugenAmt());
				detail.setMibaraiToukiGensyoAmt(reportEntity.getMibaraiToukiGensyoAmt());
				detail.setMibaraiToukimatuAmt(reportEntity.getMibaraiToukimatuAmt());
				// 2020/05/22 ADD START
				detail.setBrakeKey1_0(reportEntity.getBrakeKey1_0());
				detail.setJysiUm(reportEntity.getJysiUm());
				detail.setZankSougaku(reportEntity.getZankSougaku());
				detail.setZankZenkimatuAmt(reportEntity.getZankZenkimatuAmt());
				detail.setZankToukiZoukaAmt(reportEntity.getZankToukiZoukaAmt());
				detail.setZankToukiJitugenAmt(reportEntity.getZankToukiJitugenAmt());
				detail.setZankToukiGensyoAmt(reportEntity.getZankToukiGensyoAmt());
				detail.setZankToukimatuAmt(reportEntity.getZankToukimatuAmt());
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
	 *            リース料受払明細表 Bean
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
		brakeKey0 = ""; // ブレイクキー
		brakeKey1 = ""; // ブレイクキー
		brakeKey2 = ""; // ブレイクキー
		brakeKey3 = ""; // ブレイクキー
		brakeKey4 = ""; // ブレイクキー
		brakeKey5 = ""; // ブレイクキー
		index = ""; // 明細行修飾子
		// 2020/05/22 ADD START
		brakeKey1_0 = ""; // ブレイクキー
		// 2020/05/22 ADD END

		try {

			// 2020/05/22 REP START LACS帳票バッチ出力
			//tmpFile = File.createTempFile("pdf23_", ".pdf", scratchDirectory);
			//fout = new FileOutputStream(tmpFile);
			//File formFile = new File(formDirectory, "LeaseUkebarai.pdf");
			//File datFile = new File(formDirectory, "LeaseUkebarai.dat");
			//report = new Report(formFile, datFile, fout);
			//
			if(!batchFlg){
				tmpFile = File.createTempFile("pdf23_", ".pdf", scratchDirectory);
				fout = new FileOutputStream(tmpFile);
				File formFile = new File(formDirectory, "LeaseUkebarai.pdf");
				File datFile = new File(formDirectory, "LeaseUkebarai.dat");
				report = new Report(formFile, datFile, fout);
				
			}
			// 2020/05/22 REP END   LACS帳票バッチ出力

			for (int i = 0; i < piUkebaraiBean.getDataMax(); i++) {
				detail = piUkebaraiBean.getUkebaraiLeaseBean(i);
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
															if (!brakeKey1.equals("")) {
			
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
					souPage++; // 総ページ数のカウントＵＰ
					lineCount = 0;

					brakeKey0 = detail.getBrakeKey0();
					brakeKey1 = detail.getBrakeKey1();
					// 2020/05/22 ADD START
					brakeKey1_0 = detail.getBrakeKey1_0();
					// 2020/05/22 ADD END
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

			brakeKey0 = ""; // ブレイクキー０
			brakeKey1 = ""; // ブレイクキー１
			// 2020/05/22 ADD START
			brakeKey1_0 = ""; // ブレイクキー1_0
			// 2020/05/22 ADD END
			brakeKey2 = ""; // ブレイクキー２
			brakeKey3 = ""; // ブレイクキー３
			brakeKey4 = ""; // ブレイクキー４
			brakeKey5 = ""; // ブレイクキー５

			// 2020/05/22 ADD START LACS帳票バッチ出力
			if (batchFlg && !batchStartFlg) {
				this.startReport(piContext);
				batchStartFlg = true;
			}
			// 2020/05/22 ADD END   LACS帳票バッチ出力
			String piDateMode = super.getSeirekiWarekiCode(commonBean.getCompanyCode(), piUkebaraiBean.getLeasCompany().getValue());

			for (int i = 0; i < piUkebaraiBean.getDataMax(); i++) {
				detail = piUkebaraiBean.getUkebaraiLeaseBean(i);
				if (!detail.getBrakeKey5().equals(brakeKey5)) {
					if (!brakeKey5.equals("")) {

						if (lineCount >= MAX_LINE) {
							detail = piUkebaraiBean.getUkebaraiLeaseBean(i - 1);
							headPrint(detail, report, piDateMode);
							detail = piUkebaraiBean.getUkebaraiLeaseBean(i);
						}

						sisankbnGokeiPrint(oPKbn);

						if (!detail.getBrakeKey4().equals(brakeKey4)) {
							if (!brakeKey4.equals("")) {

								if (lineCount >= MAX_LINE) {
									detail = piUkebaraiBean.getUkebaraiLeaseBean(i - 1);
									headPrint(detail, report, piDateMode);
									detail = piUkebaraiBean.getUkebaraiLeaseBean(i);
								}
								kaikeiSyoriGokeiPrint(oPKbn);

								if (!detail.getBrakeKey3().equals(brakeKey3)) {
									if (!brakeKey3.equals("")) {

										if (lineCount >= MAX_LINE) {
											detail = piUkebaraiBean.getUkebaraiLeaseBean(i - 1);
											headPrint(detail, report, piDateMode);
											detail = piUkebaraiBean.getUkebaraiLeaseBean(i);
										}

										trdHnteiKekaGokeiPrint(oPKbn);
										if (!detail.getBrakeKey2().equals(brakeKey2)) {
											if (!brakeKey2.equals("")) {

												if (lineCount >= MAX_LINE) {
													detail = piUkebaraiBean.getUkebaraiLeaseBean(i - 1);
													headPrint(detail, report, piDateMode);
													detail = piUkebaraiBean.getUkebaraiLeaseBean(i);
												}

												ackijyunGokeiPrint(oPKbn);

												// 2020/05/22 ADD START
												if (!detail.getBrakeKey1_0().equals(brakeKey1_0)) {
													if (!brakeKey1.equals("")) {

														if (lineCount >= MAX_LINE) {
															detail = piUkebaraiBean.getUkebaraiLeaseBean(i - 1);
															headPrint(detail, report, piDateMode);
															detail = piUkebaraiBean.getUkebaraiLeaseBean(i);
														}

														jysiUmGokeiPrint(oPKbn);
												// 2020/05/22 ADD END

														if (!detail.getBrakeKey1().equals(brakeKey1)) {
															if (!brakeKey1.equals("")) {
		
																if (lineCount >= MAX_LINE) {
																	detail = piUkebaraiBean.getUkebaraiLeaseBean(i - 1);
																	headPrint(detail, report, piDateMode);
																	detail = piUkebaraiBean.getUkebaraiLeaseBean(i);
																}
		
																leasCompanyGokeiPrint(oPKbn);
		
																if (!detail.getBrakeKey0().equals(brakeKey0)) {
		
																	if (lineCount >= MAX_LINE) {
																		detail = piUkebaraiBean.getUkebaraiLeaseBean(i - 1);
																		headPrint(detail, report, piDateMode);
																		detail = piUkebaraiBean.getUkebaraiLeaseBean(i);
																	}
		
																	gokeiPrint(oPKbn);
		
																}
															}
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

					headPrint(detail, report, piDateMode);

					oPKbn = detail.getBrakeKey0();
					brakeKey0 = detail.getBrakeKey0();
					brakeKey1 = detail.getBrakeKey1();
					// 2020/05/22 ADD START
					brakeKey1_0 = detail.getBrakeKey1_0();
					// 2020/05/22 ADD END
					brakeKey2 = detail.getBrakeKey2();
					brakeKey3 = detail.getBrakeKey3();
					brakeKey4 = detail.getBrakeKey4();
					brakeKey5 = detail.getBrakeKey5();
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

				field = report.getField("xLeasAmtSougaku" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getLeasAmtSougaku()));

				field = report.getField("xZankaHosyo" + index);
				report.putFieldData(field, StringUtl.formatNumber(detail.getZankaHosyoAmt()));

				if (!oPKbn.equals(TRHK_HNTI_OP)) {
					field = report.getField("xSaimu" + index);
					report.putFieldData(field, "リース債務残高");

					field = report.getField("xSaimuSougaku" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getSaimuSougaku()));

					field = report.getField("xSaimuZenkimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getSaimuZenkimatuAmt()));

					field = report.getField("xSaimuToukiZoukaAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getSaimuToukiZoukaAmt()));

					field = report.getField("xSaimuToukiJitugenAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getSaimuToukiJitugenAmt()));

					field = report.getField("xSaimuToukiGensyoAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getSaimuToukiGensyoAmt()));

					field = report.getField("xSaimuToukimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getSaimuToukimatuAmt()));

					// 2020/05/22 ADD START
					field = report.getField("xZank" + index);
					report.putFieldData(field, "残価保証額");

					field = report.getField("xZankSougaku" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getZankSougaku()));

					field = report.getField("xZankZenkimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getZankZenkimatuAmt()));

					field = report.getField("xZankToukiZoukaAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getZankToukiZoukaAmt()));

					//field = report.getField("xZankToukiJitugenAmt" + index);
					//report.putFieldData(field, StringUtl.formatNumber(detail.getZankToukiJitugenAmt()));

					field = report.getField("xZankToukiGensyoAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getZankToukiGensyoAmt()));

					field = report.getField("xZankToukimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getZankToukimatuAmt()));
					// 2020/05/22 ADD END

					field = report.getField("xRsk" + index);
					report.putFieldData(field, "支払利息累計");

					field = report.getField("xRskSougaku" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getRskSougaku()));

					field = report.getField("xRskZenkimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getRskZenkimatuAmt()));

					field = report.getField("xRskToukiJitugenAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getRskToukiJitugenAmt()));

					field = report.getField("xRskToukiGensyoAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getRskToukiGensyoAmt()));

					field = report.getField("xRskToukimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getRskToukimatuAmt()));

					field = report.getField("xIji" + index);
					report.putFieldData(field, "維持管理費相当額累計");
					field = report.getField("xIjiSougaku" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getIjiSougaku()));

					field = report.getField("xIjiZenkimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getIjiZenkimatuAmt()));

					field = report.getField("xIjiToukiJitugenAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getIjiToukiJitugenAmt()));

					field = report.getField("xIjiToukiGensyoAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getIjiToukiGensyoAmt()));

					field = report.getField("xIjiToukimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getIjiToukimatuAmt()));

					field = report.getField("xEkm" + index);
					report.putFieldData(field, "役務提供費相当額累計");
					field = report.getField("xEkmSougaku" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getEkmSougaku()));

					field = report.getField("xEkmZenkimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getEkmZenkimatuAmt()));

					field = report.getField("xEkmToukiJitugenAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getEkmToukiJitugenAmt()));

					field = report.getField("xEkmToukiGensyoAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getEkmToukiGensyoAmt()));

					field = report.getField("xEkmToukimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getEkmToukimatuAmt()));

					field = report.getField("xLeasAmtRui" + index);
					report.putFieldData(field, "リース料累計");

					field = report.getField("xLeasAmtRuiSougaku" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getLeasAmtRuiSougaku()));

					field = report.getField("xLeasAmtRuiZenkimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getLeasAmtRuiZenkimatuAmt()));

					field = report.getField("xLeasAmtRuiToukiJitugenAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getLeasAmtRuiToukiJitugenAmt()));

					field = report.getField("xLeasAmtRuiToukiGensyoAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getLeasAmtRuiToukiGensyoAmt()));

					field = report.getField("xLeasAmtRuiToukimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getLeasAmtRuiToukimatuAmt()));

					field = report.getField("xMibarai" + index);
					report.putFieldData(field, "未払金(消費税)残高");

					field = report.getField("xMibaraiSougaku" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiSougaku()));

					field = report.getField("xMibaraiZenkimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiZenkimatuAmt()));

					field = report.getField("xMibaraiToukiZoukaAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiToukiZoukaAmt()));

					field = report.getField("xMibaraiToukiJitugenAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiToukiJitugenAmt()));

					field = report.getField("xMibaraiToukiGensyoAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiToukiGensyoAmt()));

					field = report.getField("xMibaraiToukimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiToukimatuAmt()));

					leasAmtSougaku1 += detail.getLeasAmtSougaku();
					zankaHosyoAmt1 += detail.getZankaHosyoAmt();
					saimuSougaku1 += detail.getSaimuSougaku();
					saimuZenkimatuAmt1 += detail.getSaimuZenkimatuAmt();
					saimuToukiZoukaAmt1 += detail.getSaimuToukiZoukaAmt();
					saimuToukiJitugenAmt1 += detail.getSaimuToukiJitugenAmt();
					saimuToukiGensyoAmt1 += detail.getSaimuToukiGensyoAmt();
					saimuToukimatuAmt1 += detail.getSaimuToukimatuAmt();
					// 2020/05/22 ADD START
					zankSougaku1 += detail.getZankSougaku();
					zankZenkimatuAmt1 += detail.getZankZenkimatuAmt();
					zankToukiZoukaAmt1 += detail.getZankToukiZoukaAmt();
					zankToukiJitugenAmt1 += detail.getZankToukiJitugenAmt();
					zankToukiGensyoAmt1 += detail.getZankToukiGensyoAmt();
					zankToukimatuAmt1 += detail.getZankToukimatuAmt();
					// 2020/05/22 ADD END
					rskSougaku1 += detail.getRskSougaku();
					rskZenkimatuAmt1 += detail.getRskZenkimatuAmt();
					rskToukiJitugenAmt1 += detail.getRskToukiJitugenAmt();
					rskToukiGensyoAmt1 += detail.getRskToukiGensyoAmt();
					rskToukimatuAmt1 += detail.getRskToukimatuAmt();
					ijiSougaku1 += detail.getIjiSougaku();
					ijiZenkimatuAmt1 += detail.getIjiZenkimatuAmt();
					ijiToukiJitugenAmt1 += detail.getIjiToukiJitugenAmt();
					ijiToukiGensyoAmt1 += detail.getIjiToukiGensyoAmt();
					ijiToukimatuAmt1 += detail.getIjiToukimatuAmt();
					ekmSougaku1 += detail.getEkmSougaku();
					ekmZenkimatuAmt1 += detail.getEkmZenkimatuAmt();
					ekmToukiJitugenAmt1 += detail.getEkmToukiJitugenAmt();
					ekmToukiGensyoAmt1 += detail.getEkmToukiGensyoAmt();
					ekmToukimatuAmt1 += detail.getEkmToukimatuAmt();
					leasAmtRuiSougaku1 += detail.getLeasAmtRuiSougaku();
					leasAmtRuiZenkimatuAmt1 += detail.getLeasAmtRuiZenkimatuAmt();
					leasAmtRuiToukiJitugenAmt1 += detail.getLeasAmtRuiToukiJitugenAmt();
					leasAmtRuiToukiGensyoAmt1 += detail.getLeasAmtRuiToukiGensyoAmt();
					leasAmtRuiToukimatuAmt1 += detail.getLeasAmtRuiToukimatuAmt();
					mibaraiSougaku1 += detail.getMibaraiSougaku();
					mibaraiZenkimatuAmt1 += detail.getMibaraiZenkimatuAmt();
					mibaraiToukiZoukaAmt1 += detail.getMibaraiToukiZoukaAmt();
					mibaraiToukiJitugenAmt1 += detail.getMibaraiToukiJitugenAmt();
					mibaraiToukiGensyoAmt1 += detail.getMibaraiToukiGensyoAmt();
					mibaraiToukimatuAmt1 += detail.getMibaraiToukimatuAmt();

					// 2020/05/22 ADD START
					leasAmtSougaku1_0 += detail.getLeasAmtSougaku();
					zankaHosyoAmt1_0 += detail.getZankaHosyoAmt();
					saimuSougaku1_0 += detail.getSaimuSougaku();
					saimuZenkimatuAmt1_0 += detail.getSaimuZenkimatuAmt();
					saimuToukiZoukaAmt1_0 += detail.getSaimuToukiZoukaAmt();
					saimuToukiJitugenAmt1_0 += detail.getSaimuToukiJitugenAmt();
					saimuToukiGensyoAmt1_0 += detail.getSaimuToukiGensyoAmt();
					saimuToukimatuAmt1_0 += detail.getSaimuToukimatuAmt();
					zankSougaku1_0 += detail.getZankSougaku();
					zankZenkimatuAmt1_0 += detail.getZankZenkimatuAmt();
					zankToukiZoukaAmt1_0 += detail.getZankToukiZoukaAmt();
					zankToukiJitugenAmt1_0 += detail.getZankToukiJitugenAmt();
					zankToukiGensyoAmt1_0 += detail.getZankToukiGensyoAmt();
					zankToukimatuAmt1_0 += detail.getZankToukimatuAmt();
					rskSougaku1_0 += detail.getRskSougaku();
					rskZenkimatuAmt1_0 += detail.getRskZenkimatuAmt();
					rskToukiJitugenAmt1_0 += detail.getRskToukiJitugenAmt();
					rskToukiGensyoAmt1_0 += detail.getRskToukiGensyoAmt();
					rskToukimatuAmt1_0 += detail.getRskToukimatuAmt();
					ijiSougaku1_0 += detail.getIjiSougaku();
					ijiZenkimatuAmt1_0 += detail.getIjiZenkimatuAmt();
					ijiToukiJitugenAmt1_0 += detail.getIjiToukiJitugenAmt();
					ijiToukiGensyoAmt1_0 += detail.getIjiToukiGensyoAmt();
					ijiToukimatuAmt1_0 += detail.getIjiToukimatuAmt();
					ekmSougaku1_0 += detail.getEkmSougaku();
					ekmZenkimatuAmt1_0 += detail.getEkmZenkimatuAmt();
					ekmToukiJitugenAmt1_0 += detail.getEkmToukiJitugenAmt();
					ekmToukiGensyoAmt1_0 += detail.getEkmToukiGensyoAmt();
					ekmToukimatuAmt1_0 += detail.getEkmToukimatuAmt();
					leasAmtRuiSougaku1_0 += detail.getLeasAmtRuiSougaku();
					leasAmtRuiZenkimatuAmt1_0 += detail.getLeasAmtRuiZenkimatuAmt();
					leasAmtRuiToukiJitugenAmt1_0 += detail.getLeasAmtRuiToukiJitugenAmt();
					leasAmtRuiToukiGensyoAmt1_0 += detail.getLeasAmtRuiToukiGensyoAmt();
					leasAmtRuiToukimatuAmt1_0 += detail.getLeasAmtRuiToukimatuAmt();
					mibaraiSougaku1_0 += detail.getMibaraiSougaku();
					mibaraiZenkimatuAmt1_0 += detail.getMibaraiZenkimatuAmt();
					mibaraiToukiZoukaAmt1_0 += detail.getMibaraiToukiZoukaAmt();
					mibaraiToukiJitugenAmt1_0 += detail.getMibaraiToukiJitugenAmt();
					mibaraiToukiGensyoAmt1_0 += detail.getMibaraiToukiGensyoAmt();
					mibaraiToukimatuAmt1_0 += detail.getMibaraiToukimatuAmt();
					// 2020/05/22 ADD END
					
					leasAmtSougaku2 += detail.getLeasAmtSougaku();
					zankaHosyoAmt2 += detail.getZankaHosyoAmt();
					saimuSougaku2 += detail.getSaimuSougaku();
					saimuZenkimatuAmt2 += detail.getSaimuZenkimatuAmt();
					saimuToukiZoukaAmt2 += detail.getSaimuToukiZoukaAmt();
					saimuToukiJitugenAmt2 += detail.getSaimuToukiJitugenAmt();
					saimuToukiGensyoAmt2 += detail.getSaimuToukiGensyoAmt();
					saimuToukimatuAmt2 += detail.getSaimuToukimatuAmt();
					// 2020/05/22 ADD START
					zankSougaku2 += detail.getZankSougaku();
					zankZenkimatuAmt2 += detail.getZankZenkimatuAmt();
					zankToukiZoukaAmt2 += detail.getZankToukiZoukaAmt();
					zankToukiJitugenAmt2 += detail.getZankToukiJitugenAmt();
					zankToukiGensyoAmt2 += detail.getZankToukiGensyoAmt();
					zankToukimatuAmt2 += detail.getZankToukimatuAmt();
					// 2020/05/22 ADD END
					rskSougaku2 += detail.getRskSougaku();
					rskZenkimatuAmt2 += detail.getRskZenkimatuAmt();
					rskToukiJitugenAmt2 += detail.getRskToukiJitugenAmt();
					rskToukiGensyoAmt2 += detail.getRskToukiGensyoAmt();
					rskToukimatuAmt2 += detail.getRskToukimatuAmt();
					ijiSougaku2 += detail.getIjiSougaku();
					ijiZenkimatuAmt2 += detail.getIjiZenkimatuAmt();
					ijiToukiJitugenAmt2 += detail.getIjiToukiJitugenAmt();
					ijiToukiGensyoAmt2 += detail.getIjiToukiGensyoAmt();
					ijiToukimatuAmt2 += detail.getIjiToukimatuAmt();
					ekmSougaku2 += detail.getEkmSougaku();
					ekmZenkimatuAmt2 += detail.getEkmZenkimatuAmt();
					ekmToukiJitugenAmt2 += detail.getEkmToukiJitugenAmt();
					ekmToukiGensyoAmt2 += detail.getEkmToukiGensyoAmt();
					ekmToukimatuAmt2 += detail.getEkmToukimatuAmt();
					leasAmtRuiSougaku2 += detail.getLeasAmtRuiSougaku();
					leasAmtRuiZenkimatuAmt2 += detail.getLeasAmtRuiZenkimatuAmt();
					leasAmtRuiToukiJitugenAmt2 += detail.getLeasAmtRuiToukiJitugenAmt();
					leasAmtRuiToukiGensyoAmt2 += detail.getLeasAmtRuiToukiGensyoAmt();
					leasAmtRuiToukimatuAmt2 += detail.getLeasAmtRuiToukimatuAmt();
					mibaraiSougaku2 += detail.getMibaraiSougaku();
					mibaraiZenkimatuAmt2 += detail.getMibaraiZenkimatuAmt();
					mibaraiToukiZoukaAmt2 += detail.getMibaraiToukiZoukaAmt();
					mibaraiToukiJitugenAmt2 += detail.getMibaraiToukiJitugenAmt();
					mibaraiToukiGensyoAmt2 += detail.getMibaraiToukiGensyoAmt();
					mibaraiToukimatuAmt2 += detail.getMibaraiToukimatuAmt();

					leasAmtSougaku3 += detail.getLeasAmtSougaku();
					zankaHosyoAmt3 += detail.getZankaHosyoAmt();
					saimuSougaku3 += detail.getSaimuSougaku();
					saimuZenkimatuAmt3 += detail.getSaimuZenkimatuAmt();
					saimuToukiZoukaAmt3 += detail.getSaimuToukiZoukaAmt();
					saimuToukiJitugenAmt3 += detail.getSaimuToukiJitugenAmt();
					saimuToukiGensyoAmt3 += detail.getSaimuToukiGensyoAmt();
					saimuToukimatuAmt3 += detail.getSaimuToukimatuAmt();
					// 2020/05/22 ADD START
					zankSougaku3 += detail.getZankSougaku();
					zankZenkimatuAmt3 += detail.getZankZenkimatuAmt();
					zankToukiZoukaAmt3 += detail.getZankToukiZoukaAmt();
					zankToukiJitugenAmt3 += detail.getZankToukiJitugenAmt();
					zankToukiGensyoAmt3 += detail.getZankToukiGensyoAmt();
					zankToukimatuAmt3 += detail.getZankToukimatuAmt();
					// 2020/05/22 ADD END
					rskSougaku3 += detail.getRskSougaku();
					rskZenkimatuAmt3 += detail.getRskZenkimatuAmt();
					rskToukiJitugenAmt3 += detail.getRskToukiJitugenAmt();
					rskToukiGensyoAmt3 += detail.getRskToukiGensyoAmt();
					rskToukimatuAmt3 += detail.getRskToukimatuAmt();
					ijiSougaku3 += detail.getIjiSougaku();
					ijiZenkimatuAmt3 += detail.getIjiZenkimatuAmt();
					ijiToukiJitugenAmt3 += detail.getIjiToukiJitugenAmt();
					ijiToukiGensyoAmt3 += detail.getIjiToukiGensyoAmt();
					ijiToukimatuAmt3 += detail.getIjiToukimatuAmt();
					ekmSougaku3 += detail.getEkmSougaku();
					ekmZenkimatuAmt3 += detail.getEkmZenkimatuAmt();
					ekmToukiJitugenAmt3 += detail.getEkmToukiJitugenAmt();
					ekmToukiGensyoAmt3 += detail.getEkmToukiGensyoAmt();
					ekmToukimatuAmt3 += detail.getEkmToukimatuAmt();
					leasAmtRuiSougaku3 += detail.getLeasAmtRuiSougaku();
					leasAmtRuiZenkimatuAmt3 += detail.getLeasAmtRuiZenkimatuAmt();
					leasAmtRuiToukiJitugenAmt3 += detail.getLeasAmtRuiToukiJitugenAmt();
					leasAmtRuiToukiGensyoAmt3 += detail.getLeasAmtRuiToukiGensyoAmt();
					leasAmtRuiToukimatuAmt3 += detail.getLeasAmtRuiToukimatuAmt();
					mibaraiSougaku3 += detail.getMibaraiSougaku();
					mibaraiZenkimatuAmt3 += detail.getMibaraiZenkimatuAmt();
					mibaraiToukiZoukaAmt3 += detail.getMibaraiToukiZoukaAmt();
					mibaraiToukiJitugenAmt3 += detail.getMibaraiToukiJitugenAmt();
					mibaraiToukiGensyoAmt3 += detail.getMibaraiToukiGensyoAmt();
					mibaraiToukimatuAmt3 += detail.getMibaraiToukimatuAmt();

					leasAmtSougaku4 += detail.getLeasAmtSougaku();
					zankaHosyoAmt4 += detail.getZankaHosyoAmt();
					saimuSougaku4 += detail.getSaimuSougaku();
					saimuZenkimatuAmt4 += detail.getSaimuZenkimatuAmt();
					saimuToukiZoukaAmt4 += detail.getSaimuToukiZoukaAmt();
					saimuToukiJitugenAmt4 += detail.getSaimuToukiJitugenAmt();
					saimuToukiGensyoAmt4 += detail.getSaimuToukiGensyoAmt();
					saimuToukimatuAmt4 += detail.getSaimuToukimatuAmt();
					// 2020/05/22 ADD START
					zankSougaku4 += detail.getZankSougaku();
					zankZenkimatuAmt4 += detail.getZankZenkimatuAmt();
					zankToukiZoukaAmt4 += detail.getZankToukiZoukaAmt();
					zankToukiJitugenAmt4 += detail.getZankToukiJitugenAmt();
					zankToukiGensyoAmt4 += detail.getZankToukiGensyoAmt();
					zankToukimatuAmt4 += detail.getZankToukimatuAmt();
					// 2020/05/22 ADD END
					rskSougaku4 += detail.getRskSougaku();
					rskZenkimatuAmt4 += detail.getRskZenkimatuAmt();
					rskToukiJitugenAmt4 += detail.getRskToukiJitugenAmt();
					rskToukiGensyoAmt4 += detail.getRskToukiGensyoAmt();
					rskToukimatuAmt4 += detail.getRskToukimatuAmt();
					ijiSougaku4 += detail.getIjiSougaku();
					ijiZenkimatuAmt4 += detail.getIjiZenkimatuAmt();
					ijiToukiJitugenAmt4 += detail.getIjiToukiJitugenAmt();
					ijiToukiGensyoAmt4 += detail.getIjiToukiGensyoAmt();
					ijiToukimatuAmt4 += detail.getIjiToukimatuAmt();
					ekmSougaku4 += detail.getEkmSougaku();
					ekmZenkimatuAmt4 += detail.getEkmZenkimatuAmt();
					ekmToukiJitugenAmt4 += detail.getEkmToukiJitugenAmt();
					ekmToukiGensyoAmt4 += detail.getEkmToukiGensyoAmt();
					ekmToukimatuAmt4 += detail.getEkmToukimatuAmt();
					leasAmtRuiSougaku4 += detail.getLeasAmtRuiSougaku();
					leasAmtRuiZenkimatuAmt4 += detail.getLeasAmtRuiZenkimatuAmt();
					leasAmtRuiToukiJitugenAmt4 += detail.getLeasAmtRuiToukiJitugenAmt();
					leasAmtRuiToukiGensyoAmt4 += detail.getLeasAmtRuiToukiGensyoAmt();
					leasAmtRuiToukimatuAmt4 += detail.getLeasAmtRuiToukimatuAmt();
					mibaraiSougaku4 += detail.getMibaraiSougaku();
					mibaraiZenkimatuAmt4 += detail.getMibaraiZenkimatuAmt();
					mibaraiToukiZoukaAmt4 += detail.getMibaraiToukiZoukaAmt();
					mibaraiToukiJitugenAmt4 += detail.getMibaraiToukiJitugenAmt();
					mibaraiToukiGensyoAmt4 += detail.getMibaraiToukiGensyoAmt();
					mibaraiToukimatuAmt4 += detail.getMibaraiToukimatuAmt();

					leasAmtSougaku5 += detail.getLeasAmtSougaku();
					zankaHosyoAmt5 += detail.getZankaHosyoAmt();
					saimuSougaku5 += detail.getSaimuSougaku();
					saimuZenkimatuAmt5 += detail.getSaimuZenkimatuAmt();
					saimuToukiZoukaAmt5 += detail.getSaimuToukiZoukaAmt();
					saimuToukiJitugenAmt5 += detail.getSaimuToukiJitugenAmt();
					saimuToukiGensyoAmt5 += detail.getSaimuToukiGensyoAmt();
					saimuToukimatuAmt5 += detail.getSaimuToukimatuAmt();
					// 2020/05/22 ADD START
					zankSougaku5 += detail.getZankSougaku();
					zankZenkimatuAmt5 += detail.getZankZenkimatuAmt();
					zankToukiZoukaAmt5 += detail.getZankToukiZoukaAmt();
					zankToukiJitugenAmt5 += detail.getZankToukiJitugenAmt();
					zankToukiGensyoAmt5 += detail.getZankToukiGensyoAmt();
					zankToukimatuAmt5 += detail.getZankToukimatuAmt();
					// 2020/05/22 ADD END
					rskSougaku5 += detail.getRskSougaku();
					rskZenkimatuAmt5 += detail.getRskZenkimatuAmt();
					rskToukiJitugenAmt5 += detail.getRskToukiJitugenAmt();
					rskToukiGensyoAmt5 += detail.getRskToukiGensyoAmt();
					rskToukimatuAmt5 += detail.getRskToukimatuAmt();
					ijiSougaku5 += detail.getIjiSougaku();
					ijiZenkimatuAmt5 += detail.getIjiZenkimatuAmt();
					ijiToukiJitugenAmt5 += detail.getIjiToukiJitugenAmt();
					ijiToukiGensyoAmt5 += detail.getIjiToukiGensyoAmt();
					ijiToukimatuAmt5 += detail.getIjiToukimatuAmt();
					ekmSougaku5 += detail.getEkmSougaku();
					ekmZenkimatuAmt5 += detail.getEkmZenkimatuAmt();
					ekmToukiJitugenAmt5 += detail.getEkmToukiJitugenAmt();
					ekmToukiGensyoAmt5 += detail.getEkmToukiGensyoAmt();
					ekmToukimatuAmt5 += detail.getEkmToukimatuAmt();
					leasAmtRuiSougaku5 += detail.getLeasAmtRuiSougaku();
					leasAmtRuiZenkimatuAmt5 += detail.getLeasAmtRuiZenkimatuAmt();
					leasAmtRuiToukiJitugenAmt5 += detail.getLeasAmtRuiToukiJitugenAmt();
					leasAmtRuiToukiGensyoAmt5 += detail.getLeasAmtRuiToukiGensyoAmt();
					leasAmtRuiToukimatuAmt5 += detail.getLeasAmtRuiToukimatuAmt();
					mibaraiSougaku5 += detail.getMibaraiSougaku();
					mibaraiZenkimatuAmt5 += detail.getMibaraiZenkimatuAmt();
					mibaraiToukiZoukaAmt5 += detail.getMibaraiToukiZoukaAmt();
					mibaraiToukiJitugenAmt5 += detail.getMibaraiToukiJitugenAmt();
					mibaraiToukiGensyoAmt5 += detail.getMibaraiToukiGensyoAmt();
					mibaraiToukimatuAmt5 += detail.getMibaraiToukimatuAmt();

					leasAmtSougaku += detail.getLeasAmtSougaku();
					zankaHosyoAmt += detail.getZankaHosyoAmt();
					saimuSougaku += detail.getSaimuSougaku();
					saimuZenkimatuAmt += detail.getSaimuZenkimatuAmt();
					saimuToukiZoukaAmt += detail.getSaimuToukiZoukaAmt();
					saimuToukiJitugenAmt += detail.getSaimuToukiJitugenAmt();
					saimuToukiGensyoAmt += detail.getSaimuToukiGensyoAmt();
					saimuToukimatuAmt += detail.getSaimuToukimatuAmt();
					// 2020/05/22 ADD START
					zankSougaku += detail.getZankSougaku();
					zankZenkimatuAmt += detail.getZankZenkimatuAmt();
					zankToukiZoukaAmt += detail.getZankToukiZoukaAmt();
					zankToukiJitugenAmt += detail.getZankToukiJitugenAmt();
					zankToukiGensyoAmt += detail.getZankToukiGensyoAmt();
					zankToukimatuAmt += detail.getZankToukimatuAmt();
					// 2020/05/22 ADD END
					rskSougaku += detail.getRskSougaku();
					rskZenkimatuAmt += detail.getRskZenkimatuAmt();
					rskToukiJitugenAmt += detail.getRskToukiJitugenAmt();
					rskToukiGensyoAmt += detail.getRskToukiGensyoAmt();
					rskToukimatuAmt += detail.getRskToukimatuAmt();
					ijiSougaku += detail.getIjiSougaku();
					ijiZenkimatuAmt += detail.getIjiZenkimatuAmt();
					ijiToukiJitugenAmt += detail.getIjiToukiJitugenAmt();
					ijiToukiGensyoAmt += detail.getIjiToukiGensyoAmt();
					ijiToukimatuAmt += detail.getIjiToukimatuAmt();
					ekmSougaku += detail.getEkmSougaku();
					ekmZenkimatuAmt += detail.getEkmZenkimatuAmt();
					ekmToukiJitugenAmt += detail.getEkmToukiJitugenAmt();
					ekmToukiGensyoAmt += detail.getEkmToukiGensyoAmt();
					ekmToukimatuAmt += detail.getEkmToukimatuAmt();
					leasAmtRuiSougaku += detail.getLeasAmtRuiSougaku();
					leasAmtRuiZenkimatuAmt += detail.getLeasAmtRuiZenkimatuAmt();
					leasAmtRuiToukiJitugenAmt += detail.getLeasAmtRuiToukiJitugenAmt();
					leasAmtRuiToukiGensyoAmt += detail.getLeasAmtRuiToukiGensyoAmt();
					leasAmtRuiToukimatuAmt += detail.getLeasAmtRuiToukimatuAmt();
					mibaraiSougaku += detail.getMibaraiSougaku();
					mibaraiZenkimatuAmt += detail.getMibaraiZenkimatuAmt();
					mibaraiToukiZoukaAmt += detail.getMibaraiToukiZoukaAmt();
					mibaraiToukiJitugenAmt += detail.getMibaraiToukiJitugenAmt();
					mibaraiToukiGensyoAmt += detail.getMibaraiToukiGensyoAmt();
					mibaraiToukimatuAmt += detail.getMibaraiToukimatuAmt();

				}
				else {
					field = report.getField("xSaimu" + index);
					report.putFieldData(field, "支払リース料累計");

					field = report.getField("xSaimuSougaku" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getLeasAmtRuiSougaku()));

					field = report.getField("xSaimuZenkimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getLeasAmtRuiZenkimatuAmt()));

					field = report.getField("xSaimuToukiJitugenAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getLeasAmtRuiToukiJitugenAmt()));
					field = report.getField("xSaimuToukiGensyoAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getLeasAmtRuiToukiGensyoAmt()));
					field = report.getField("xSaimuToukimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getLeasAmtRuiToukimatuAmt()));

					// 2020/05/22 REP START
					//field = report.getField("xRsk" + index);
					//report.putFieldData(field, "仮払消費税累計");

					//field = report.getField("xRskSougaku" + index);
					//report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiSougaku()));

					//field = report.getField("xRskZenkimatuAmt" + index);
					//report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiZenkimatuAmt()));

					//field = report.getField("xRskToukiJitugenAmt" + index);
					//report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiToukiJitugenAmt()));

					//field = report.getField("xRskToukiGensyoAmt" + index);
					//report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiToukiGensyoAmt()));

					//field = report.getField("xRskToukimatuAmt" + index);
					//report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiToukimatuAmt()));

					//
					field = report.getField("xZank" + index);
					report.putFieldData(field, "仮払消費税累計");

					field = report.getField("xZankSougaku" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiSougaku()));

					field = report.getField("xZankZenkimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiZenkimatuAmt()));

					field = report.getField("xZankToukiJitugenAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiToukiJitugenAmt()));

					field = report.getField("xZankToukiGensyoAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiToukiGensyoAmt()));

					field = report.getField("xZankToukimatuAmt" + index);
					report.putFieldData(field, StringUtl.formatNumber(detail.getMibaraiToukimatuAmt()));
					
					// 2020/05/22 REP END

					leasAmtSougaku1 += detail.getLeasAmtSougaku();
					zankaHosyoAmt1 += detail.getZankaHosyoAmt();
					leasAmtRuiSougaku1 += detail.getLeasAmtRuiSougaku();
					leasAmtRuiZenkimatuAmt1 += detail.getLeasAmtRuiZenkimatuAmt();
					leasAmtRuiToukiJitugenAmt1 += detail.getLeasAmtRuiToukiJitugenAmt();
					leasAmtRuiToukimatuAmt1 += detail.getLeasAmtRuiToukimatuAmt();
					mibaraiSougaku1 += detail.getMibaraiSougaku();
					mibaraiZenkimatuAmt1 += detail.getMibaraiZenkimatuAmt();
					mibaraiToukiJitugenAmt1 += detail.getMibaraiToukiJitugenAmt();
					mibaraiToukimatuAmt1 += detail.getMibaraiToukimatuAmt();

					// 2020/05/22 ADD START
					leasAmtSougaku1_0 += detail.getLeasAmtSougaku();
					zankaHosyoAmt1_0 += detail.getZankaHosyoAmt();
					leasAmtRuiSougaku1_0 += detail.getLeasAmtRuiSougaku();
					leasAmtRuiZenkimatuAmt1_0 += detail.getLeasAmtRuiZenkimatuAmt();
					leasAmtRuiToukiJitugenAmt1_0 += detail.getLeasAmtRuiToukiJitugenAmt();
					leasAmtRuiToukimatuAmt1_0 += detail.getLeasAmtRuiToukimatuAmt();
					mibaraiSougaku1_0 += detail.getMibaraiSougaku();
					mibaraiZenkimatuAmt1_0 += detail.getMibaraiZenkimatuAmt();
					mibaraiToukiJitugenAmt1_0 += detail.getMibaraiToukiJitugenAmt();
					mibaraiToukimatuAmt1_0 += detail.getMibaraiToukimatuAmt();
					// 2020/05/22 ADD END

					leasAmtSougaku2 += detail.getLeasAmtSougaku();
					zankaHosyoAmt2 += detail.getZankaHosyoAmt();
					leasAmtRuiSougaku2 += detail.getLeasAmtRuiSougaku();
					leasAmtRuiZenkimatuAmt2 += detail.getLeasAmtRuiZenkimatuAmt();
					leasAmtRuiToukiJitugenAmt2 += detail.getLeasAmtRuiToukiJitugenAmt();
					leasAmtRuiToukimatuAmt2 += detail.getLeasAmtRuiToukimatuAmt();
					mibaraiSougaku2 += detail.getMibaraiSougaku();
					mibaraiZenkimatuAmt2 += detail.getMibaraiZenkimatuAmt();
					mibaraiToukiJitugenAmt2 += detail.getMibaraiToukiJitugenAmt();
					mibaraiToukimatuAmt2 += detail.getMibaraiToukimatuAmt();

					leasAmtSougaku3 += detail.getLeasAmtSougaku();
					zankaHosyoAmt3 += detail.getZankaHosyoAmt();
					leasAmtRuiSougaku3 += detail.getLeasAmtRuiSougaku();
					leasAmtRuiZenkimatuAmt3 += detail.getLeasAmtRuiZenkimatuAmt();
					leasAmtRuiToukiJitugenAmt3 += detail.getLeasAmtRuiToukiJitugenAmt();
					leasAmtRuiToukimatuAmt3 += detail.getLeasAmtRuiToukimatuAmt();
					mibaraiSougaku3 += detail.getMibaraiSougaku();
					mibaraiZenkimatuAmt3 += detail.getMibaraiZenkimatuAmt();
					mibaraiToukiJitugenAmt3 += detail.getMibaraiToukiJitugenAmt();
					mibaraiToukimatuAmt3 += detail.getMibaraiToukimatuAmt();

					leasAmtSougaku4 += detail.getLeasAmtSougaku();
					zankaHosyoAmt4 += detail.getZankaHosyoAmt();
					leasAmtRuiSougaku4 += detail.getLeasAmtRuiSougaku();
					leasAmtRuiZenkimatuAmt4 += detail.getLeasAmtRuiZenkimatuAmt();
					leasAmtRuiToukiJitugenAmt4 += detail.getLeasAmtRuiToukiJitugenAmt();
					leasAmtRuiToukimatuAmt4 += detail.getLeasAmtRuiToukimatuAmt();
					mibaraiSougaku4 += detail.getMibaraiSougaku();
					mibaraiZenkimatuAmt4 += detail.getMibaraiZenkimatuAmt();
					mibaraiToukiJitugenAmt4 += detail.getMibaraiToukiJitugenAmt();
					mibaraiToukimatuAmt4 += detail.getMibaraiToukimatuAmt();

					leasAmtSougaku5 += detail.getLeasAmtSougaku();
					zankaHosyoAmt5 += detail.getZankaHosyoAmt();
					leasAmtRuiSougaku5 += detail.getLeasAmtRuiSougaku();
					leasAmtRuiZenkimatuAmt5 += detail.getLeasAmtRuiZenkimatuAmt();
					leasAmtRuiToukiJitugenAmt5 += detail.getLeasAmtRuiToukiJitugenAmt();
					leasAmtRuiToukimatuAmt5 += detail.getLeasAmtRuiToukimatuAmt();
					mibaraiSougaku5 += detail.getMibaraiSougaku();
					mibaraiZenkimatuAmt5 += detail.getMibaraiZenkimatuAmt();
					mibaraiToukiJitugenAmt5 += detail.getMibaraiToukiJitugenAmt();
					mibaraiToukimatuAmt5 += detail.getMibaraiToukimatuAmt();

					leasAmtSougaku += detail.getLeasAmtSougaku();
					zankaHosyoAmt1 += detail.getZankaHosyoAmt();
					leasAmtRuiSougaku += detail.getLeasAmtRuiSougaku();
					leasAmtRuiZenkimatuAmt += detail.getLeasAmtRuiZenkimatuAmt();
					leasAmtRuiToukiJitugenAmt += detail.getLeasAmtRuiToukiJitugenAmt();
					leasAmtRuiToukimatuAmt += detail.getLeasAmtRuiToukimatuAmt();
					mibaraiSougaku += detail.getMibaraiSougaku();
					mibaraiZenkimatuAmt += detail.getMibaraiZenkimatuAmt();
					mibaraiToukiJitugenAmt += detail.getMibaraiToukiJitugenAmt();
					mibaraiToukimatuAmt += detail.getMibaraiToukimatuAmt();
				}

				lineCount++;
			}

			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			sisankbnGokeiPrint(oPKbn);

			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			trdHnteiKekaGokeiPrint(oPKbn);

			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			kaikeiSyoriGokeiPrint(oPKbn);

			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			ackijyunGokeiPrint(oPKbn);

			// 2020/05/22 ADD START
			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			jysiUmGokeiPrint(oPKbn);
			// 2020/05/22 ADD END

			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			leasCompanyGokeiPrint(oPKbn);

			if (lineCount >= MAX_LINE) {
				headPrint(detail, report, piDateMode);
			}
			gokeiPrint(oPKbn);

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

	private void headPrint(LACSUkebaraiLeaseBean piDetail, Report piReport, String piDateMode) throws Exception {
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
		// 2020/05/22 ADD END
	}

	private void gokeiPrint(String piOpKbn) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "総　合　計");

		field = report.getField("xGoukeiLeasAmtSougaku" + index);
		report.putFieldData(field, "リース料総額");

		field = report.getField("xLeasAmtSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leasAmtSougaku));

		field = report.getField("xGoukeiZankaHosyo" + index);
		report.putFieldData(field, "うち残価保証額");

		field = report.getField("xZankaHosyo" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoAmt));

		if (!piOpKbn.equals(TRHK_HNTI_OP)) {

			field = report.getField("xSaimu" + index);
			report.putFieldData(field, "リース債務残高");

			field = report.getField("xSaimuSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuSougaku));

			field = report.getField("xSaimuZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuZenkimatuAmt));

			field = report.getField("xSaimuToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiZoukaAmt));

			field = report.getField("xSaimuToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiJitugenAmt));

			field = report.getField("xSaimuToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiGensyoAmt));

			field = report.getField("xSaimuToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukimatuAmt));

			// 2020/05/22 ADD START
			field = report.getField("xZank" + index);
			report.putFieldData(field, "残価保証額");

			field = report.getField("xZankSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankSougaku));

			field = report.getField("xZankZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankZenkimatuAmt));

			field = report.getField("xZankToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukiZoukaAmt));

			//field = report.getField("xZankToukiJitugenAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(zankToukiJitugenAmt));

			field = report.getField("xZankToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukiGensyoAmt));

			field = report.getField("xZankToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukimatuAmt));
			// 2020/05/22 ADD END

			field = report.getField("xRsk" + index);
			report.putFieldData(field, "支払利息累計");

			field = report.getField("xRskSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskSougaku));

			field = report.getField("xRskZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskZenkimatuAmt));

			field = report.getField("xRskToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukiJitugenAmt));

			field = report.getField("xRskToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukiGensyoAmt));

			field = report.getField("xRskToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukimatuAmt));

			field = report.getField("xIji" + index);
			report.putFieldData(field, "維持管理費相当額累計");
			field = report.getField("xIjiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiSougaku));

			field = report.getField("xIjiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiZenkimatuAmt));

			field = report.getField("xIjiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukiJitugenAmt));

			field = report.getField("xIjiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukiGensyoAmt));

			field = report.getField("xIjiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukimatuAmt));

			field = report.getField("xEkm" + index);
			report.putFieldData(field, "役務提供費相当額累計");
			field = report.getField("xEkmSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmSougaku));

			field = report.getField("xEkmZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmZenkimatuAmt));

			field = report.getField("xEkmToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukiJitugenAmt));

			field = report.getField("xEkmToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukiGensyoAmt));

			field = report.getField("xEkmToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukimatuAmt));

			field = report.getField("xLeasAmtRui" + index);
			report.putFieldData(field, "リース料累計");

			field = report.getField("xLeasAmtRuiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiSougaku));

			field = report.getField("xLeasAmtRuiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiZenkimatuAmt));

			field = report.getField("xLeasAmtRuiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiJitugenAmt));

			field = report.getField("xLeasAmtRuiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiGensyoAmt));

			field = report.getField("xLeasAmtRuiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukimatuAmt));

			field = report.getField("xMibarai" + index);
			report.putFieldData(field, "未払金(消費税)残高");

			field = report.getField("xMibaraiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku));

			field = report.getField("xMibaraiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt));

			field = report.getField("xMibaraiToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiZoukaAmt));

			field = report.getField("xMibaraiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt));

			field = report.getField("xMibaraiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt));

			field = report.getField("xMibaraiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt));
		}
		else {
			field = report.getField("xSaimu" + index);
			report.putFieldData(field, "支払リース料累計");

			field = report.getField("xSaimuSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiSougaku));

			field = report.getField("xSaimuZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiZenkimatuAmt));

			field = report.getField("xSaimuToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiJitugenAmt));

			field = report.getField("xSaimuToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiGensyoAmt));

			field = report.getField("xSaimuToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukimatuAmt));

			// 2020/05/22 REP START
			field = report.getField("xZank" + index);
			report.putFieldData(field, "仮払消費税累計");

			field = report.getField("xZankSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku));

			field = report.getField("xZankZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt));

			field = report.getField("xZankToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt));

			field = report.getField("xZankToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt));

			field = report.getField("xZankToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt));

			//
			//field = report.getField("xRsk" + index);
			//report.putFieldData(field, "仮払消費税累計");

			//field = report.getField("xRskSougaku" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku));

			//field = report.getField("xRskZenkimatuAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt));

			//field = report.getField("xRskToukiJitugenAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt));

			//field = report.getField("xRskToukiGensyoAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt));

			//field = report.getField("xRskToukimatuAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt));

			// 2020/05/22 REP END
		}

		leasAmtSougaku = 0;
		zankaHosyoAmt = 0;
		saimuSougaku = 0;
		saimuZenkimatuAmt = 0;
		saimuToukiZoukaAmt = 0;
		saimuToukiJitugenAmt = 0;
		saimuToukiGensyoAmt = 0;
		saimuToukimatuAmt = 0;
		// 2020/05/22 ADD START
		zankSougaku = 0;
		zankZenkimatuAmt = 0;
		zankToukiZoukaAmt = 0;
		zankToukiJitugenAmt = 0;
		zankToukiGensyoAmt = 0;
		zankToukimatuAmt = 0;
		// 2020/05/22 ADD END
		rskSougaku = 0;
		rskZenkimatuAmt = 0;
		rskToukiJitugenAmt = 0;
		rskToukiGensyoAmt = 0;
		rskToukimatuAmt = 0;
		ijiSougaku = 0;
		ijiZenkimatuAmt = 0;
		ijiToukiJitugenAmt = 0;
		ijiToukiGensyoAmt = 0;
		ijiToukimatuAmt = 0;
		ekmSougaku = 0;
		ekmZenkimatuAmt = 0;
		ekmToukiJitugenAmt = 0;
		ekmToukiGensyoAmt = 0;
		ekmToukimatuAmt = 0;
		leasAmtRuiSougaku = 0;
		leasAmtRuiZenkimatuAmt = 0;
		leasAmtRuiToukiJitugenAmt = 0;
		leasAmtRuiToukiGensyoAmt = 0;
		leasAmtRuiToukimatuAmt = 0;
		mibaraiSougaku = 0;
		mibaraiZenkimatuAmt = 0;
		mibaraiToukiZoukaAmt = 0;
		mibaraiToukiJitugenAmt = 0;
		mibaraiToukiGensyoAmt = 0;
		mibaraiToukimatuAmt = 0;

		lineCount++;
	}

	private void leasCompanyGokeiPrint(String piOpKbn) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "リース会社計");

		field = report.getField("xGoukeiLeasAmtSougaku" + index);
		report.putFieldData(field, "リース料総額");

		field = report.getField("xLeasAmtSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leasAmtSougaku1));

		field = report.getField("xGoukeiZankaHosyo" + index);
		report.putFieldData(field, "うち残価保証額");

		field = report.getField("xZankaHosyo" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoAmt1));

		if (!piOpKbn.equals(TRHK_HNTI_OP)) {
			field = report.getField("xSaimu" + index);
			report.putFieldData(field, "リース債務残高");

			field = report.getField("xSaimuSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuSougaku1));

			field = report.getField("xSaimuZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuZenkimatuAmt1));

			field = report.getField("xSaimuToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiZoukaAmt1));

			field = report.getField("xSaimuToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiJitugenAmt1));

			field = report.getField("xSaimuToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiGensyoAmt1));

			field = report.getField("xSaimuToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukimatuAmt1));

			// 2020/05/22 ADD START
			field = report.getField("xZank" + index);
			report.putFieldData(field, "残価保証額");

			field = report.getField("xZankSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankSougaku1));

			field = report.getField("xZankZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankZenkimatuAmt1));

			field = report.getField("xZankToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukiZoukaAmt1));

			//field = report.getField("xZankToukiJitugenAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(zankToukiJitugenAmt1));

			field = report.getField("xZankToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukiGensyoAmt1));

			field = report.getField("xZankToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukimatuAmt1));
			// 2020/05/22 ADD END

			field = report.getField("xRsk" + index);
			report.putFieldData(field, "支払利息累計");

			field = report.getField("xRskSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskSougaku1));

			field = report.getField("xRskZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskZenkimatuAmt1));

			field = report.getField("xRskToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukiJitugenAmt1));

			field = report.getField("xRskToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukiGensyoAmt1));

			field = report.getField("xRskToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukimatuAmt1));

			field = report.getField("xIji" + index);
			report.putFieldData(field, "維持管理費相当額累計");
			field = report.getField("xIjiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiSougaku1));

			field = report.getField("xIjiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiZenkimatuAmt1));

			field = report.getField("xIjiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukiJitugenAmt1));

			field = report.getField("xIjiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukiGensyoAmt1));

			field = report.getField("xIjiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukimatuAmt1));

			field = report.getField("xEkm" + index);
			report.putFieldData(field, "役務提供費相当額累計");
			field = report.getField("xEkmSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmSougaku1));

			field = report.getField("xEkmZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmZenkimatuAmt1));

			field = report.getField("xEkmToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukiJitugenAmt1));

			field = report.getField("xEkmToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukiGensyoAmt1));

			field = report.getField("xEkmToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukimatuAmt1));

			field = report.getField("xLeasAmtRui" + index);
			report.putFieldData(field, "リース料累計");

			field = report.getField("xLeasAmtRuiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiSougaku1));

			field = report.getField("xLeasAmtRuiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiZenkimatuAmt1));

			field = report.getField("xLeasAmtRuiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiJitugenAmt1));

			field = report.getField("xLeasAmtRuiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiGensyoAmt1));

			field = report.getField("xLeasAmtRuiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukimatuAmt1));

			field = report.getField("xMibarai" + index);
			report.putFieldData(field, "未払金(消費税)残高");

			field = report.getField("xMibaraiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku1));

			field = report.getField("xMibaraiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt1));

			field = report.getField("xMibaraiToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiZoukaAmt1));

			field = report.getField("xMibaraiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt1));

			field = report.getField("xMibaraiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt1));

			field = report.getField("xMibaraiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt1));

		}
		else {
			field = report.getField("xSaimu" + index);
			report.putFieldData(field, "支払リース料累計");

			field = report.getField("xSaimuSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiSougaku1));

			field = report.getField("xSaimuZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiZenkimatuAmt1));

			field = report.getField("xSaimuToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiJitugenAmt1));
			field = report.getField("xSaimuToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiGensyoAmt1));
			field = report.getField("xSaimuToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukimatuAmt1));

			// 2020/05/22 REP START
			field = report.getField("xZank" + index);
			report.putFieldData(field, "仮払消費税累計");

			field = report.getField("xZankSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku1));

			field = report.getField("xZankZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt1));

			field = report.getField("xZankToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt1));

			field = report.getField("xZankToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt1));

			field = report.getField("xZankToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt1));
			//
			//field = report.getField("xRsk" + index);
			//report.putFieldData(field, "仮払消費税累計");
			//field = report.getField("xRskSougaku" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku1));

			//field = report.getField("xRskZenkimatuAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt1));

			//field = report.getField("xRskToukiJitugenAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt1));

			//field = report.getField("xRskToukiGensyoAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt1));

			//field = report.getField("xRskToukimatuAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt1));

			// 2020/05/22 REP END
		}

		leasAmtSougaku1 = 0;
		zankaHosyoAmt1 = 0;
		saimuSougaku1 = 0;
		saimuZenkimatuAmt1 = 0;
		saimuToukiZoukaAmt1 = 0;
		saimuToukiJitugenAmt1 = 0;
		saimuToukiGensyoAmt1 = 0;
		saimuToukimatuAmt1 = 0;
		// 2020/05/22 ADD START
		zankSougaku1 = 0;
		zankZenkimatuAmt1 = 0;
		zankToukiZoukaAmt1 = 0;
		zankToukiJitugenAmt1 = 0;
		zankToukiGensyoAmt1 = 0;
		zankToukimatuAmt1 = 0;
		// 2020/05/22 ADD END
		rskSougaku1 = 0;
		rskZenkimatuAmt1 = 0;
		rskToukiJitugenAmt1 = 0;
		rskToukiGensyoAmt1 = 0;
		rskToukimatuAmt1 = 0;
		ijiSougaku1 = 0;
		ijiZenkimatuAmt1 = 0;
		ijiToukiJitugenAmt1 = 0;
		ijiToukiGensyoAmt1 = 0;
		ijiToukimatuAmt1 = 0;
		ekmSougaku1 = 0;
		ekmZenkimatuAmt1 = 0;
		ekmToukiJitugenAmt1 = 0;
		ekmToukiGensyoAmt1 = 0;
		ekmToukimatuAmt1 = 0;
		leasAmtRuiSougaku1 = 0;
		leasAmtRuiZenkimatuAmt1 = 0;
		leasAmtRuiToukiJitugenAmt1 = 0;
		leasAmtRuiToukiGensyoAmt1 = 0;
		leasAmtRuiToukimatuAmt1 = 0;
		mibaraiSougaku1 = 0;
		mibaraiZenkimatuAmt1 = 0;
		mibaraiToukiZoukaAmt1 = 0;
		mibaraiToukiJitugenAmt1 = 0;
		mibaraiToukiGensyoAmt1 = 0;
		mibaraiToukimatuAmt1 = 0;

		lineCount++;
	}

	// 2020/05/22 ADD START
	private void jysiUmGokeiPrint(String piOpKbn) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "重要性有無計");

		field = report.getField("xGoukeiLeasAmtSougaku" + index);
		report.putFieldData(field, "リース料総額");

		field = report.getField("xLeasAmtSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leasAmtSougaku1_0));

		field = report.getField("xGoukeiZankaHosyo" + index);
		report.putFieldData(field, "うち残価保証額");

		field = report.getField("xZankaHosyo" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoAmt1_0));

		if (!piOpKbn.equals(TRHK_HNTI_OP)) {
			field = report.getField("xSaimu" + index);
			report.putFieldData(field, "リース債務残高");

			field = report.getField("xSaimuSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuSougaku1_0));

			field = report.getField("xSaimuZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuZenkimatuAmt1_0));

			field = report.getField("xSaimuToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiZoukaAmt1_0));

			field = report.getField("xSaimuToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiJitugenAmt1_0));

			field = report.getField("xSaimuToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiGensyoAmt1_0));

			field = report.getField("xSaimuToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukimatuAmt1_0));

			// 2020/05/22 ADD START
			field = report.getField("xZank" + index);
			report.putFieldData(field, "残価保証額");

			field = report.getField("xZankSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankSougaku1_0));

			field = report.getField("xZankZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankZenkimatuAmt1_0));

			field = report.getField("xZankToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukiZoukaAmt1_0));

			//field = report.getField("xZankToukiJitugenAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(zankToukiJitugenAmt1_0));

			field = report.getField("xZankToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukiGensyoAmt1_0));

			field = report.getField("xZankToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukimatuAmt1_0));
			// 2020/05/22 ADD END
			
			field = report.getField("xRsk" + index);
			report.putFieldData(field, "支払利息累計");

			field = report.getField("xRskSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskSougaku1_0));

			field = report.getField("xRskZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskZenkimatuAmt1_0));

			field = report.getField("xRskToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukiJitugenAmt1_0));

			field = report.getField("xRskToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukiGensyoAmt1_0));

			field = report.getField("xRskToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukimatuAmt1_0));

			field = report.getField("xIji" + index);
			report.putFieldData(field, "維持管理費相当額累計");
			field = report.getField("xIjiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiSougaku1_0));

			field = report.getField("xIjiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiZenkimatuAmt1_0));

			field = report.getField("xIjiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukiJitugenAmt1_0));

			field = report.getField("xIjiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukiGensyoAmt1_0));

			field = report.getField("xIjiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukimatuAmt1_0));

			field = report.getField("xEkm" + index);
			report.putFieldData(field, "役務提供費相当額累計");
			field = report.getField("xEkmSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmSougaku1_0));

			field = report.getField("xEkmZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmZenkimatuAmt1_0));

			field = report.getField("xEkmToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukiJitugenAmt1_0));

			field = report.getField("xEkmToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukiGensyoAmt1_0));

			field = report.getField("xEkmToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukimatuAmt1_0));

			field = report.getField("xLeasAmtRui" + index);
			report.putFieldData(field, "リース料累計");

			field = report.getField("xLeasAmtRuiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiSougaku1_0));

			field = report.getField("xLeasAmtRuiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiZenkimatuAmt1_0));

			field = report.getField("xLeasAmtRuiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiJitugenAmt1_0));

			field = report.getField("xLeasAmtRuiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiGensyoAmt1_0));

			field = report.getField("xLeasAmtRuiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukimatuAmt1_0));

			field = report.getField("xMibarai" + index);
			report.putFieldData(field, "未払金(消費税)残高");

			field = report.getField("xMibaraiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku1_0));

			field = report.getField("xMibaraiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt1_0));

			field = report.getField("xMibaraiToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiZoukaAmt1_0));

			field = report.getField("xMibaraiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt1_0));

			field = report.getField("xMibaraiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt1_0));

			field = report.getField("xMibaraiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt1_0));

		}
		else {
			field = report.getField("xSaimu" + index);
			report.putFieldData(field, "支払リース料累計");

			field = report.getField("xSaimuSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiSougaku1_0));

			field = report.getField("xSaimuZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiZenkimatuAmt1_0));

			field = report.getField("xSaimuToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiJitugenAmt1_0));

			field = report.getField("xSaimuToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiGensyoAmt1_0));
			
			field = report.getField("xSaimuToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukimatuAmt1_0));

			field = report.getField("xZank" + index);
			report.putFieldData(field, "仮払消費税累計");

			field = report.getField("xZankSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku1_0));

			field = report.getField("xZankZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt1_0));

			field = report.getField("xZankToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt1_0));

			field = report.getField("xZankToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt1_0));

			field = report.getField("xZankToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt1_0));

		}

		leasAmtSougaku1_0 = 0;
		zankaHosyoAmt1_0 = 0;
		saimuSougaku1_0 = 0;
		saimuZenkimatuAmt1_0 = 0;
		saimuToukiZoukaAmt1_0 = 0;
		saimuToukiJitugenAmt1_0 = 0;
		saimuToukiGensyoAmt1_0 = 0;
		saimuToukimatuAmt1_0 = 0;
		zankSougaku1_0 = 0;
		zankZenkimatuAmt1_0 = 0;
		zankToukiZoukaAmt1_0 = 0;
		zankToukiJitugenAmt1_0 = 0;
		zankToukiGensyoAmt1_0 = 0;
		zankToukimatuAmt1_0 = 0;
		rskSougaku1_0 = 0;
		rskZenkimatuAmt1_0 = 0;
		rskToukiJitugenAmt1_0 = 0;
		rskToukiGensyoAmt1_0 = 0;
		rskToukimatuAmt1_0 = 0;
		ijiSougaku1_0 = 0;
		ijiZenkimatuAmt1_0 = 0;
		ijiToukiJitugenAmt1_0 = 0;
		ijiToukiGensyoAmt1_0 = 0;
		ijiToukimatuAmt1_0 = 0;
		ekmSougaku1_0 = 0;
		ekmZenkimatuAmt1_0 = 0;
		ekmToukiJitugenAmt1_0 = 0;
		ekmToukiGensyoAmt1_0 = 0;
		ekmToukimatuAmt1_0 = 0;
		leasAmtRuiSougaku1_0 = 0;
		leasAmtRuiZenkimatuAmt1_0 = 0;
		leasAmtRuiToukiJitugenAmt1_0 = 0;
		leasAmtRuiToukiGensyoAmt1_0 = 0;
		leasAmtRuiToukimatuAmt1_0 = 0;
		mibaraiSougaku1_0 = 0;
		mibaraiZenkimatuAmt1_0 = 0;
		mibaraiToukiZoukaAmt1_0 = 0;
		mibaraiToukiJitugenAmt1_0 = 0;
		mibaraiToukiGensyoAmt1_0 = 0;
		mibaraiToukimatuAmt1_0 = 0;

		lineCount++;
	}
	// 2020/05/22 ADD END

	private void ackijyunGokeiPrint(String piOpKbn) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "リース会計基準計");

		field = report.getField("xGoukeiLeasAmtSougaku" + index);
		report.putFieldData(field, "リース料総額");

		field = report.getField("xLeasAmtSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leasAmtSougaku2));

		field = report.getField("xGoukeiZankaHosyo" + index);
		report.putFieldData(field, "うち残価保証額");

		field = report.getField("xZankaHosyo" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoAmt2));

		if (!piOpKbn.equals(TRHK_HNTI_OP)) {
			field = report.getField("xSaimu" + index);
			report.putFieldData(field, "リース債務残高");

			field = report.getField("xSaimuSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuSougaku2));

			field = report.getField("xSaimuZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuZenkimatuAmt2));

			field = report.getField("xSaimuToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiZoukaAmt2));

			field = report.getField("xSaimuToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiJitugenAmt2));

			field = report.getField("xSaimuToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiGensyoAmt2));

			field = report.getField("xSaimuToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukimatuAmt2));

			// 2020/05/22 ADD START
			field = report.getField("xZank" + index);
			report.putFieldData(field, "残価保証額");

			field = report.getField("xZankSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankSougaku2));

			field = report.getField("xZankZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankZenkimatuAmt2));

			field = report.getField("xZankToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukiZoukaAmt2));

			//field = report.getField("xZankToukiJitugenAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(zankToukiJitugenAmt2));

			field = report.getField("xZankToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukiGensyoAmt2));

			field = report.getField("xZankToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukimatuAmt2));
			// 2020/05/22 ADD END

			field = report.getField("xRsk" + index);
			report.putFieldData(field, "支払利息累計");

			field = report.getField("xRskSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskSougaku2));

			field = report.getField("xRskZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskZenkimatuAmt2));

			field = report.getField("xRskToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukiJitugenAmt2));

			field = report.getField("xRskToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukiGensyoAmt2));

			field = report.getField("xRskToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukimatuAmt2));

			field = report.getField("xIji" + index);
			report.putFieldData(field, "維持管理費相当額累計");
			field = report.getField("xIjiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiSougaku2));

			field = report.getField("xIjiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiZenkimatuAmt2));

			field = report.getField("xIjiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukiJitugenAmt2));

			field = report.getField("xIjiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukiGensyoAmt2));

			field = report.getField("xIjiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukimatuAmt2));

			field = report.getField("xEkm" + index);
			report.putFieldData(field, "役務提供費相当額累計");
			field = report.getField("xEkmSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmSougaku2));

			field = report.getField("xEkmZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmZenkimatuAmt2));

			field = report.getField("xEkmToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukiJitugenAmt2));

			field = report.getField("xEkmToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukiGensyoAmt2));

			field = report.getField("xEkmToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukimatuAmt2));

			field = report.getField("xLeasAmtRui" + index);
			report.putFieldData(field, "リース料累計");

			field = report.getField("xLeasAmtRuiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiSougaku2));

			field = report.getField("xLeasAmtRuiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiZenkimatuAmt2));

			field = report.getField("xLeasAmtRuiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiJitugenAmt2));

			field = report.getField("xLeasAmtRuiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiGensyoAmt2));

			field = report.getField("xLeasAmtRuiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukimatuAmt2));

			field = report.getField("xMibarai" + index);
			report.putFieldData(field, "未払金(消費税)残高");

			field = report.getField("xMibaraiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku2));

			field = report.getField("xMibaraiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt2));

			field = report.getField("xMibaraiToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiZoukaAmt2));

			field = report.getField("xMibaraiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt2));

			field = report.getField("xMibaraiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt2));

			field = report.getField("xMibaraiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt2));
		}
		else {
			field = report.getField("xSaimu" + index);
			report.putFieldData(field, "支払リース料累計");

			field = report.getField("xSaimuSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiSougaku2));

			field = report.getField("xSaimuZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiZenkimatuAmt2));

			field = report.getField("xSaimuToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiJitugenAmt2));

			field = report.getField("xSaimuToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiGensyoAmt2));

			field = report.getField("xSaimuToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukimatuAmt2));

			// 2020/05/22 REP START
			field = report.getField("xZank" + index);
			report.putFieldData(field, "仮払消費税累計");

			field = report.getField("xZankSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku2));

			field = report.getField("xZankZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt2));

			field = report.getField("xZankToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt2));

			field = report.getField("xZankToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt2));

			field = report.getField("xZankToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt2));
			//
			//field = report.getField("xRsk" + index);
			//report.putFieldData(field, "仮払消費税累計");

			//field = report.getField("xRskSougaku" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku2));

			//field = report.getField("xRskZenkimatuAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt2));

			//field = report.getField("xRskToukiJitugenAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt2));

			//field = report.getField("xRskToukiGensyoAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt2));

			//field = report.getField("xRskToukimatuAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt2));
			// 2020/05/22 REP END


		}
		leasAmtSougaku2 = 0;
		zankaHosyoAmt2 = 0;
		saimuSougaku2 = 0;
		saimuZenkimatuAmt2 = 0;
		saimuToukiZoukaAmt2 = 0;
		saimuToukiJitugenAmt2 = 0;
		saimuToukiGensyoAmt2 = 0;
		saimuToukimatuAmt2 = 0;
		// 2020/05/22 ADD START
		zankSougaku2 = 0;
		zankZenkimatuAmt2 = 0;
		zankToukiZoukaAmt2 = 0;
		zankToukiJitugenAmt2 = 0;
		zankToukiGensyoAmt2 = 0;
		zankToukimatuAmt2 = 0;
		// 2020/05/22 ADD END
		rskSougaku2 = 0;
		rskZenkimatuAmt2 = 0;
		rskToukiJitugenAmt2 = 0;
		rskToukiGensyoAmt2 = 0;
		rskToukimatuAmt2 = 0;
		ijiSougaku2 = 0;
		ijiZenkimatuAmt2 = 0;
		ijiToukiJitugenAmt2 = 0;
		ijiToukiGensyoAmt2 = 0;
		ijiToukimatuAmt2 = 0;
		ekmSougaku2 = 0;
		ekmZenkimatuAmt2 = 0;
		ekmToukiJitugenAmt2 = 0;
		ekmToukiGensyoAmt2 = 0;
		ekmToukimatuAmt2 = 0;
		leasAmtRuiSougaku2 = 0;
		leasAmtRuiZenkimatuAmt2 = 0;
		leasAmtRuiToukiJitugenAmt2 = 0;
		leasAmtRuiToukiGensyoAmt2 = 0;
		leasAmtRuiToukimatuAmt2 = 0;
		mibaraiSougaku2 = 0;
		mibaraiZenkimatuAmt2 = 0;
		mibaraiToukiZoukaAmt2 = 0;
		mibaraiToukiJitugenAmt2 = 0;
		mibaraiToukiGensyoAmt2 = 0;
		mibaraiToukimatuAmt2 = 0;

		lineCount++;
	}

	private void kaikeiSyoriGokeiPrint(String piOpKbn) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "会計処理計");

		field = report.getField("xGoukeiLeasAmtSougaku" + index);
		report.putFieldData(field, "リース料総額");

		field = report.getField("xLeasAmtSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leasAmtSougaku3));

		field = report.getField("xGoukeiZankaHosyo" + index);
		report.putFieldData(field, "うち残価保証額");

		field = report.getField("xZankaHosyo" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoAmt3));

		if (!piOpKbn.equals(TRHK_HNTI_OP)) {
			field = report.getField("xSaimu" + index);
			report.putFieldData(field, "リース債務残高");

			field = report.getField("xSaimuSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuSougaku3));

			field = report.getField("xSaimuToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiZoukaAmt3));

			field = report.getField("xSaimuZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuZenkimatuAmt3));

			field = report.getField("xSaimuToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiJitugenAmt3));

			field = report.getField("xSaimuToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiGensyoAmt3));

			field = report.getField("xSaimuToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukimatuAmt3));

			// 2020/05/22 ADD START
			field = report.getField("xZank" + index);
			report.putFieldData(field, "残価保証額");

			field = report.getField("xZankSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankSougaku3));

			field = report.getField("xZankToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukiZoukaAmt3));

			field = report.getField("xZankZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankZenkimatuAmt3));

			//field = report.getField("xZankToukiJitugenAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(zankToukiJitugenAmt3));

			field = report.getField("xZankToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukiGensyoAmt3));

			field = report.getField("xZankToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukimatuAmt3));
			// 2020/05/22 ADD END

			field = report.getField("xRsk" + index);
			report.putFieldData(field, "支払利息累計");

			field = report.getField("xRskSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskSougaku3));

			field = report.getField("xRskZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskZenkimatuAmt3));

			field = report.getField("xRskToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukiJitugenAmt3));

			field = report.getField("xRskToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukiGensyoAmt3));

			field = report.getField("xRskToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukimatuAmt3));

			field = report.getField("xIji" + index);
			report.putFieldData(field, "維持管理費相当額累計");
			field = report.getField("xIjiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiSougaku3));

			field = report.getField("xIjiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiZenkimatuAmt3));

			field = report.getField("xIjiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukiJitugenAmt3));

			field = report.getField("xIjiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukiGensyoAmt3));

			field = report.getField("xIjiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukimatuAmt3));

			field = report.getField("xEkm" + index);
			report.putFieldData(field, "役務提供費相当額累計");
			field = report.getField("xEkmSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmSougaku3));

			field = report.getField("xEkmZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmZenkimatuAmt3));

			field = report.getField("xEkmToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukiJitugenAmt3));

			field = report.getField("xEkmToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukiGensyoAmt3));

			field = report.getField("xEkmToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukimatuAmt3));

			field = report.getField("xLeasAmtRui" + index);
			report.putFieldData(field, "リース料累計");

			field = report.getField("xLeasAmtRuiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiSougaku3));

			field = report.getField("xLeasAmtRuiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiZenkimatuAmt3));

			field = report.getField("xLeasAmtRuiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiJitugenAmt3));

			field = report.getField("xLeasAmtRuiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiGensyoAmt3));

			field = report.getField("xLeasAmtRuiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukimatuAmt3));

			field = report.getField("xMibarai" + index);
			report.putFieldData(field, "未払金(消費税)残高");

			field = report.getField("xMibaraiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku3));

			field = report.getField("xMibaraiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt3));

			field = report.getField("xMibaraiToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiZoukaAmt3));

			field = report.getField("xMibaraiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt3));

			field = report.getField("xMibaraiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt3));

			field = report.getField("xMibaraiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt3));
		}
		else {
			field = report.getField("xSaimu" + index);
			report.putFieldData(field, "支払リース料累計");

			field = report.getField("xSaimuSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiSougaku3));

			field = report.getField("xSaimuZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiZenkimatuAmt3));

			field = report.getField("xSaimuToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiJitugenAmt3));

			field = report.getField("xSaimuToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiGensyoAmt3));

			field = report.getField("xSaimuToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukimatuAmt3));

			// 2020/05/22 REP START

			field = report.getField("xZank" + index);
			report.putFieldData(field, "仮払消費税累計");

			field = report.getField("xZankSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku3));

			field = report.getField("xZankZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt3));

			field = report.getField("xZankToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt3));

			field = report.getField("xZankToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt3));

			field = report.getField("xZankToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt3));
			//
			//field = report.getField("xRsk" + index);
			//report.putFieldData(field, "仮払消費税累計");

			//field = report.getField("xRskSougaku" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku3));

			//field = report.getField("xRskZenkimatuAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt3));

			//field = report.getField("xRskToukiJitugenAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt3));

			//field = report.getField("xRskToukiGensyoAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt3));

			//field = report.getField("xRskToukimatuAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt3));
			// 2020/05/22 REP END

		}
		leasAmtSougaku3 = 0;
		zankaHosyoAmt3 = 0;
		saimuSougaku3 = 0;
		saimuZenkimatuAmt3 = 0;
		saimuToukiZoukaAmt3 = 0;
		saimuToukiJitugenAmt3 = 0;
		saimuToukiGensyoAmt3 = 0;
		saimuToukimatuAmt3 = 0;
		// 2020/05/22 ADD START
		zankSougaku3 = 0;
		zankZenkimatuAmt3 = 0;
		zankToukiZoukaAmt3 = 0;
		zankToukiJitugenAmt3 = 0;
		zankToukiGensyoAmt3 = 0;
		zankToukimatuAmt3 = 0;
		// 2020/05/22 ADD END
		rskSougaku3 = 0;
		rskZenkimatuAmt3 = 0;
		rskToukiJitugenAmt3 = 0;
		rskToukiGensyoAmt3 = 0;
		rskToukimatuAmt3 = 0;
		ijiSougaku3 = 0;
		ijiZenkimatuAmt3 = 0;
		ijiToukiJitugenAmt3 = 0;
		ijiToukiGensyoAmt3 = 0;
		ijiToukimatuAmt3 = 0;
		ekmSougaku3 = 0;
		ekmZenkimatuAmt3 = 0;
		ekmToukiJitugenAmt3 = 0;
		ekmToukiGensyoAmt3 = 0;
		ekmToukimatuAmt3 = 0;
		leasAmtRuiSougaku3 = 0;
		leasAmtRuiZenkimatuAmt3 = 0;
		leasAmtRuiToukiJitugenAmt3 = 0;
		leasAmtRuiToukiGensyoAmt3 = 0;
		leasAmtRuiToukimatuAmt3 = 0;
		mibaraiSougaku3 = 0;
		mibaraiZenkimatuAmt3 = 0;
		mibaraiToukiZoukaAmt3 = 0;
		mibaraiToukiJitugenAmt3 = 0;
		mibaraiToukiGensyoAmt3 = 0;
		mibaraiToukimatuAmt3 = 0;

		lineCount++;
	}

	private void trdHnteiKekaGokeiPrint(String piOpKbn) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "リース取引分類計");
		field = report.getField("xGoukeiLeasAmtSougaku" + index);
		report.putFieldData(field, "リース料総額");

		field = report.getField("xLeasAmtSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leasAmtSougaku4));

		field = report.getField("xGoukeiZankaHosyo" + index);
		report.putFieldData(field, "うち残価保証額");

		field = report.getField("xZankaHosyo" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoAmt4));

		if (!piOpKbn.equals(TRHK_HNTI_OP)) {
			field = report.getField("xSaimu" + index);
			report.putFieldData(field, "リース債務残高");

			field = report.getField("xSaimuSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuSougaku4));

			field = report.getField("xSaimuToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiZoukaAmt4));

			field = report.getField("xSaimuZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuZenkimatuAmt4));

			field = report.getField("xSaimuToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiJitugenAmt4));

			field = report.getField("xSaimuToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiGensyoAmt4));

			field = report.getField("xSaimuToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukimatuAmt4));

			// 2020/05/22 ADD START
			field = report.getField("xZank" + index);
			report.putFieldData(field, "残価保証額");

			field = report.getField("xZankSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankSougaku4));

			field = report.getField("xZankToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukiZoukaAmt4));

			field = report.getField("xZankZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankZenkimatuAmt4));

			//field = report.getField("xZankToukiJitugenAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(zankToukiJitugenAmt4));

			field = report.getField("xZankToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukiGensyoAmt4));

			field = report.getField("xZankToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukimatuAmt4));
			// 2020/05/22 ADD END

			field = report.getField("xRsk" + index);
			report.putFieldData(field, "支払利息累計");

			field = report.getField("xRskSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskSougaku4));

			field = report.getField("xRskZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskZenkimatuAmt4));

			field = report.getField("xRskToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukiJitugenAmt4));

			field = report.getField("xRskToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukiGensyoAmt4));

			field = report.getField("xRskToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukimatuAmt4));

			field = report.getField("xIji" + index);
			report.putFieldData(field, "維持管理費相当額累計");
			field = report.getField("xIjiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiSougaku4));

			field = report.getField("xIjiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiZenkimatuAmt4));

			field = report.getField("xIjiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukiJitugenAmt4));

			field = report.getField("xIjiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukiGensyoAmt4));

			field = report.getField("xIjiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukimatuAmt4));

			field = report.getField("xEkm" + index);
			report.putFieldData(field, "役務提供費相当額累計");
			field = report.getField("xEkmSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmSougaku4));

			field = report.getField("xEkmZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmZenkimatuAmt4));

			field = report.getField("xEkmToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukiJitugenAmt4));

			field = report.getField("xEkmToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukiGensyoAmt4));

			field = report.getField("xEkmToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukimatuAmt4));

			field = report.getField("xLeasAmtRui" + index);
			report.putFieldData(field, "リース料累計");

			field = report.getField("xLeasAmtRuiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiSougaku4));

			field = report.getField("xLeasAmtRuiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiZenkimatuAmt4));

			field = report.getField("xLeasAmtRuiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiJitugenAmt4));

			field = report.getField("xLeasAmtRuiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiGensyoAmt4));

			field = report.getField("xLeasAmtRuiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukimatuAmt4));

			field = report.getField("xMibarai" + index);
			report.putFieldData(field, "未払金(消費税)残高");

			field = report.getField("xMibaraiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku4));

			field = report.getField("xMibaraiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt4));

			field = report.getField("xMibaraiToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiZoukaAmt4));

			field = report.getField("xMibaraiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt4));

			field = report.getField("xMibaraiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt4));

			field = report.getField("xMibaraiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt4));
		}
		else {
			field = report.getField("xSaimu" + index);
			report.putFieldData(field, "支払リース料累計");

			field = report.getField("xSaimuSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiSougaku4));

			field = report.getField("xSaimuZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiZenkimatuAmt4));

			field = report.getField("xSaimuToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiJitugenAmt4));

			field = report.getField("xSaimuToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiGensyoAmt4));

			field = report.getField("xSaimuToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukimatuAmt4));

			// 2020/05/22 REP START
			field = report.getField("xZank" + index);
			report.putFieldData(field, "仮払消費税累計");

			field = report.getField("xZankSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku4));

			field = report.getField("xZankZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt4));

			field = report.getField("xZankToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt4));

			field = report.getField("xZankToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt4));

			field = report.getField("xZankToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt4));
			// 2020/05/22 REP END
			//
			//field = report.getField("xRsk" + index);
			//report.putFieldData(field, "仮払消費税累計");

			//field = report.getField("xRskSougaku" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku4));

			//field = report.getField("xRskZenkimatuAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt4));

			//field = report.getField("xRskToukiJitugenAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt4));

			//field = report.getField("xRskToukiGensyoAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt4));

			//field = report.getField("xRskToukimatuAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt4));

		}
		leasAmtSougaku4 = 0;
		zankaHosyoAmt4 = 0;
		saimuSougaku4 = 0;
		saimuZenkimatuAmt4 = 0;
		saimuToukiZoukaAmt4 = 0;
		saimuToukiJitugenAmt4 = 0;
		saimuToukiGensyoAmt4 = 0;
		saimuToukimatuAmt4 = 0;
		// 2020/05/22 ADD START
		zankSougaku4 = 0;
		zankZenkimatuAmt4 = 0;
		zankToukiZoukaAmt4 = 0;
		zankToukiJitugenAmt4 = 0;
		zankToukiGensyoAmt4 = 0;
		zankToukimatuAmt4 = 0;
		// 2020/05/22 ADD END
		rskSougaku4 = 0;
		rskZenkimatuAmt4 = 0;
		rskToukiJitugenAmt4 = 0;
		rskToukiGensyoAmt4 = 0;
		rskToukimatuAmt4 = 0;
		ijiSougaku4 = 0;
		ijiZenkimatuAmt4 = 0;
		ijiToukiJitugenAmt4 = 0;
		ijiToukiGensyoAmt4 = 0;
		ijiToukimatuAmt4 = 0;
		ekmSougaku4 = 0;
		ekmZenkimatuAmt4 = 0;
		ekmToukiJitugenAmt4 = 0;
		ekmToukiGensyoAmt4 = 0;
		ekmToukimatuAmt4 = 0;
		leasAmtRuiSougaku4 = 0;
		leasAmtRuiZenkimatuAmt4 = 0;
		leasAmtRuiToukiJitugenAmt4 = 0;
		leasAmtRuiToukiGensyoAmt4 = 0;
		leasAmtRuiToukimatuAmt4 = 0;
		mibaraiSougaku4 = 0;
		mibaraiZenkimatuAmt4 = 0;
		mibaraiToukiZoukaAmt4 = 0;
		mibaraiToukiJitugenAmt4 = 0;
		mibaraiToukiGensyoAmt4 = 0;
		mibaraiToukimatuAmt4 = 0;

		lineCount++;
	}

	private void sisankbnGokeiPrint(String piOpKbn) throws Exception {
		Field field = null;
		index = "." + Convert.toString(lineCount); // 明細行修飾子の設定

		field = report.getField("xGoukei" + index);
		report.putFieldData(field, "資産区分計");

		field = report.getField("xGoukeiLeasAmtSougaku" + index);
		report.putFieldData(field, "リース料総額");

		field = report.getField("xLeasAmtSougaku" + index);
		report.putFieldData(field, StringUtl.formatNumber(leasAmtSougaku5));

		field = report.getField("xGoukeiZankaHosyo" + index);
		report.putFieldData(field, "うち残価保証額");

		field = report.getField("xZankaHosyo" + index);
		report.putFieldData(field, StringUtl.formatNumber(zankaHosyoAmt5));

		if (!piOpKbn.equals(TRHK_HNTI_OP)) {
			field = report.getField("xSaimu" + index);
			report.putFieldData(field, "リース債務残高");

			field = report.getField("xSaimuSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuSougaku5));

			field = report.getField("xSaimuZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuZenkimatuAmt5));

			field = report.getField("xSaimuToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiZoukaAmt5));

			field = report.getField("xSaimuToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiJitugenAmt5));

			field = report.getField("xSaimuToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukiGensyoAmt5));

			field = report.getField("xSaimuToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(saimuToukimatuAmt5));

			// 2020/05/22 ADD START
			field = report.getField("xZank" + index);
			report.putFieldData(field, "残価保証額");

			field = report.getField("xZankSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankSougaku5));

			field = report.getField("xZankZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankZenkimatuAmt5));

			field = report.getField("xZankToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukiZoukaAmt5));

			//field = report.getField("xZankToukiJitugenAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(zankToukiJitugenAmt5));

			field = report.getField("xZankToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukiGensyoAmt5));

			field = report.getField("xZankToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(zankToukimatuAmt5));
			// 2020/05/22 ADD END

			field = report.getField("xRsk" + index);
			report.putFieldData(field, "支払利息累計");

			field = report.getField("xRskSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskSougaku5));

			field = report.getField("xRskZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskZenkimatuAmt5));

			field = report.getField("xRskToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukiJitugenAmt5));

			field = report.getField("xRskToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukiGensyoAmt5));

			field = report.getField("xRskToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(rskToukimatuAmt5));

			field = report.getField("xIji" + index);
			report.putFieldData(field, "維持管理費相当額累計");
			field = report.getField("xIjiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiSougaku5));

			field = report.getField("xIjiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiZenkimatuAmt5));

			field = report.getField("xIjiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukiJitugenAmt5));

			field = report.getField("xIjiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukiGensyoAmt5));

			field = report.getField("xIjiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ijiToukimatuAmt5));

			field = report.getField("xEkm" + index);
			report.putFieldData(field, "役務提供費相当額累計");
			field = report.getField("xEkmSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmSougaku5));

			field = report.getField("xEkmZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmZenkimatuAmt5));

			field = report.getField("xEkmToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukiJitugenAmt5));

			field = report.getField("xEkmToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukiGensyoAmt5));

			field = report.getField("xEkmToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(ekmToukimatuAmt5));

			field = report.getField("xLeasAmtRui" + index);
			report.putFieldData(field, "リース料累計");

			field = report.getField("xLeasAmtRuiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiSougaku5));

			field = report.getField("xLeasAmtRuiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiZenkimatuAmt5));

			field = report.getField("xLeasAmtRuiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiJitugenAmt5));

			field = report.getField("xLeasAmtRuiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiGensyoAmt5));

			field = report.getField("xLeasAmtRuiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukimatuAmt5));

			field = report.getField("xMibarai" + index);
			report.putFieldData(field, "未払金(消費税)残高");

			field = report.getField("xMibaraiSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku5));

			field = report.getField("xMibaraiZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt5));

			field = report.getField("xMibaraiToukiZoukaAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiZoukaAmt5));

			field = report.getField("xMibaraiToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt5));

			field = report.getField("xMibaraiToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt5));

			field = report.getField("xMibaraiToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt5));
		}
		else {
			field = report.getField("xSaimu" + index);
			report.putFieldData(field, "支払リース料累計");

			field = report.getField("xSaimuSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiSougaku5));

			field = report.getField("xSaimuZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiZenkimatuAmt5));

			field = report.getField("xSaimuToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiJitugenAmt5));

			field = report.getField("xSaimuToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukiGensyoAmt5));

			field = report.getField("xSaimuToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(leasAmtRuiToukimatuAmt5));

			// 2020/05/22 REP START
			field = report.getField("xZank" + index);
			report.putFieldData(field, "仮払消費税累計");

			field = report.getField("xZankSougaku" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku5));

			field = report.getField("xZankZenkimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt5));

			field = report.getField("xZankToukiJitugenAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt5));

			field = report.getField("xZankToukiGensyoAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt5));

			field = report.getField("xZankToukimatuAmt" + index);
			report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt5));
			//
			//field = report.getField("xRsk" + index);
			//report.putFieldData(field, "仮払消費税累計");

			//field = report.getField("xRskSougaku" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiSougaku5));

			//field = report.getField("xRskZenkimatuAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiZenkimatuAmt5));

			//field = report.getField("xRskToukiJitugenAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiJitugenAmt5));

			//field = report.getField("xRskToukiGensyoAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukiGensyoAmt5));

			//field = report.getField("xRskToukimatuAmt" + index);
			//report.putFieldData(field, StringUtl.formatNumber(mibaraiToukimatuAmt5));
			// 2020/05/22 REP END

		}

		leasAmtSougaku5 = 0;
		zankaHosyoAmt5 = 0;
		saimuSougaku5 = 0;
		saimuZenkimatuAmt5 = 0;
		saimuToukiZoukaAmt5 = 0;
		saimuToukiJitugenAmt5 = 0;
		saimuToukiGensyoAmt5 = 0;
		saimuToukimatuAmt5 = 0;
		// 2020/05/22 ADD START
		zankSougaku5 = 0;
		zankZenkimatuAmt5 = 0;
		zankToukiZoukaAmt5 = 0;
		zankToukiJitugenAmt5 = 0;
		zankToukiGensyoAmt5 = 0;
		zankToukimatuAmt5 = 0;
		// 2020/05/22 ADD END
		rskSougaku5 = 0;
		rskZenkimatuAmt5 = 0;
		rskToukiJitugenAmt5 = 0;
		rskToukiGensyoAmt5 = 0;
		rskToukimatuAmt5 = 0;
		ijiSougaku5 = 0;
		ijiZenkimatuAmt5 = 0;
		ijiToukiJitugenAmt5 = 0;
		ijiToukiGensyoAmt5 = 0;
		ijiToukimatuAmt5 = 0;
		ekmSougaku5 = 0;
		ekmZenkimatuAmt5 = 0;
		ekmToukiJitugenAmt5 = 0;
		ekmToukiGensyoAmt5 = 0;
		ekmToukimatuAmt5 = 0;
		leasAmtRuiSougaku5 = 0;
		leasAmtRuiZenkimatuAmt5 = 0;
		leasAmtRuiToukiJitugenAmt5 = 0;
		leasAmtRuiToukiGensyoAmt5 = 0;
		leasAmtRuiToukimatuAmt5 = 0;
		mibaraiSougaku5 = 0;
		mibaraiZenkimatuAmt5 = 0;
		mibaraiToukiZoukaAmt5 = 0;
		mibaraiToukiJitugenAmt5 = 0;
		mibaraiToukiGensyoAmt5 = 0;
		mibaraiToukimatuAmt5 = 0;

		lineCount++;
	}

}
