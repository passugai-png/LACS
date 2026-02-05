package jp.co.pro_app.lacs.affairs.report.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
//import jp.co.pro_app.lacs.affairs.report.common.LACSReportCommon;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 帳票出力：期日別予定表(債務）Entity.
 * 
 * @author arai
 * @version 20200616
 */

public class LACSReportKizituSaimuEntity extends LACSReportEntityBase {		
	
	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 * @param piCommonBean
	 *            LACS共通Bean
	 * @param piReportBean
	 *            帳票出力Bean
	 * @param piAcStd
	 *            対象会計基準
	 */
	public LACSReportKizituSaimuEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSReportBean piReportBean, String piAcStd) {		
		
		super(piModel, piCommonBean, piReportBean, piAcStd);		
		super.dateFrom = piReportBean.getTermFrom().getYYYYMMDD();
		super.termNum = piReportBean.getTermNum();	
		
	}
	
	/**
	 * SQLを生成.
	 */
	protected void makeSQL() {
					
		super.sql.append("SELECT RPAD(KEI.LU_COSMOS_CD, 10, ' ') BRAKE_KEY0 " + "\n");
		super.sql.append("        ,RPAD(KEI.LU_COSMOS_CD, 10, ' ') || RPAD(KEI.JYSI_UM, 1, ' ') BRAKE_KEY1 " + "\n");
		super.sql.append("        ,RPAD(KEI.LU_COSMOS_CD, 10, ' ') || RPAD(KEI.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ') BRAKE_KEY2 " + "\n");
		super.sql.append("        ,RPAD(KEI.LU_COSMOS_CD, 10, ' ') || RPAD(KEI.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(AC.AC_SHR_KBN , 1, ' ') BRAKE_KEY3 " + "\n");
		super.sql.append("        ,RPAD(KEI.LU_COSMOS_CD, 10, ' ') || RPAD(KEI.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(AC.AC_SHR_KBN , 1, ' ') || RPAD(RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN , 1, ' ') BRAKE_KEY4 " + "\n");
		super.sql.append("        ,RPAD(KEI.LU_COSMOS_CD, 10, ' ') || RPAD(KEI.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(AC.AC_SHR_KBN , 1, ' ') || RPAD(RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN , 1, ' ') || RPAD(FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_CD , 1, ' ') BRAKE_KEY5 " + "\n");		
		super.sql.append("        ,DECODE(LU.PDF_COMPANY_NM, NULL, M_LC.LC_NM, LU.PDF_COMPANY_NM) LEASE_COMPANY " + "\n"); // リース会社		
		super.sql.append("        ,TO_CHAR(SYSDATE, 'YYYYMMDD') CREATE_DATE " + "\n"); // 作成日
		super.sql.append("        ,LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ") END_YMD " + "\n"); // 基準日				
		super.sql.append("        ,LU.LU_NM LU_NM " +  "\n"); // 開示先
		super.sql.append("        ,CASE WHEN KEI.JYSI_UM = 1 THEN 'あり' ELSE 'なし' END JYSI_UM " + "\n"); // 重要性有無
		super.sql.append("        ,KEI.JYSI_UM JYSI_UM_CD" + "\n"); // 重要性有無コード
		super.sql.append("        ,TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN TRD_HNTE_KEKA_KBN  " + "\n"); // リース取引分類コード		
		super.sql.append("        ,AC.AC_SHR_KBN AC_SHR_KBN" + "\n"); // 会計処理方法コード
		super.sql.append("        ,RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN " + "\n"); // 利息相当額配分方法コード
		super.sql.append("        ,FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_CD FKN_TNKI_HOHO_CD " + "\n"); // 当期支払リース料計算基準コード 
		super.sql.append("        ,DECODE(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, '3', '解約不能') || TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_NM LEASE_BUNRUI " + "\n"); // リース取引分類
		super.sql.append("        ,AC.AC_SHR_NM AC_SHR_KBN_NM" + "\n"); // 会計処理方法
		super.sql.append("        ,RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN_NM " + "\n"); //利息相当額配分方法
		super.sql.append("        ,FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_NM " + "\n"); // 当期支払リース料計算基準
		super.sql.append("        ,KEI.HYJYO_KEI_NO KEI_NO " + "\n"); // 契約番号
		super.sql.append("        ,BKN.BKN_NO || " + "\n");		
		super.sql.append("         CASE WHEN TRIM(BKN.BKN_EDANO) IS NULL THEN '' ELSE '-' || BKN.BKN_EDANO END BKN_NO " + "\n"); // 物件番号
		super.sql.append("        ,BKN.BKN_NM BKN_NM " + "\n"); // 物件名
		super.sql.append("        ,TO_CHAR(TO_DATE(KEI.KNSHU_YMD), 'YYYY/MM/DD') KNSHU_YMD " + "\n"); // リース開始日
		super.sql.append("        ,TO_CHAR(TO_DATE(KEI.MRYO_YMD), 'YYYY/MM/DD') MRYO_YMD " + "\n"); // リース終了日
		super.sql.append("        ,TO_CHAR(TO_DATE(KEI.KAI_YMD), 'YYYY/MM/DD') KAI_YMD " + "\n"); // 中途解約日
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) MIKEIKA_LEASE_ONE_YEAR " + "\n"); // 未経過リース料(1年以内)
		super.sql.append("        ,MAX(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) ZANK_HOSYOGAKU_ONE_YEAR " + "\n"); // 残価保証額(1年以内)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) GNPN_ONE_YEAR " + "\n"); // 元本(1年以内)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) RSK_ONE_YEAR " + "\n"); // 利息(1年以内)
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.OTH_CST " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) IJI_KANRIHI_ONE_YEAR " + "\n"); // 維持管理費(1年以内)
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) EKM_TEIK_ONE_YEAR " + "\n"); // 役務提供費(1年以内)	
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT_STAX " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) LAMT_STAX_ONE_YEAR " + "\n"); //  消費税等(1年以内)			
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) MIKEIKA_LEASE_TWO_YEARS " + "\n"); // 未経過リース料(2年以内)
		super.sql.append("        ,MAX(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) ZANK_HOSYOGAKU_TWO_YEARS " + "\n"); // 残価保証額(2年以内)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) GNPN_TWO_YEARS " + "\n"); // 元本(2年以内)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) RSK_TWO_YEARS " + "\n"); // 利息(2年以内)
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.OTH_CST " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) IJI_KANRIHI_TWO_YEARS " + "\n"); // 維持管理費(2年以内)
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) EKM_TEIK_TWO_YEARS " + "\n"); // 役務提供費(2年以内)	
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT_STAX " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) LAMT_STAX_TWO_YEARS " + "\n"); //  消費税等(2年以内)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) MIKEIKA_LEASE_THREE_YEARS " + "\n"); // 未経過リース料(3年以内)
		super.sql.append("        ,MAX(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) ZANK_HOSYOGAKU_THREE_YEARS " + "\n"); // 残価保証額(3年以内)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) GNPN_THREE_YEARS " + "\n"); // 元本(3年以内)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) RSK_THREE_YEARS " + "\n"); // 利息(3年以内)
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.OTH_CST " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) IJI_KANRIHI_THREE_YEARS " + "\n"); // 維持管理費(3年以内)
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) EKM_TEIK_THREE_YEARS " + "\n"); // 役務提供費(3年以内)	
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT_STAX " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) LAMT_STAX_THREE_YEARS " + "\n"); //  消費税等(3年以内)
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) MIKEIKA_LEASE_FOUR_YEARS " + "\n"); // 未経過リース料(4年以内)
		super.sql.append("        ,MAX(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");		
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) ZANK_HOSYOGAKU_FOUR_YEARS " + "\n"); // 残価保証額(4年以内)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) GNPN_FOUR_YEARS " + "\n"); // 元本(4年以内)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) RSK_FOUR_YEARS " + "\n"); // 利息(4年以内)
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.OTH_CST " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) IJI_KANRIHI_FOUR_YEARS " + "\n"); // 維持管理費(4年以内)
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) EKM_TEIK_FOUR_YEARS " + "\n"); // 役務提供費(4年以内)	
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT_STAX " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) LAMT_STAX_FOUR_YEARS " + "\n"); //  消費税等(4年以内)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) MIKEIKA_LEASE_FIVE_YEARS " + "\n"); // 未経過リース料(5年以内)
		super.sql.append("        ,MAX(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) ZANK_HOSYOGAKU_FIVE_YEARS " + "\n"); // 残価保証額(5年以内)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) GNPN_FIVE_YEARS " + "\n"); // 元本(5年以内)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) RSK_FIVE_YEARS " + "\n"); // 利息(5年以内)
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.OTH_CST " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) IJI_KANRIHI_FIVE_YEARS " + "\n"); // 維持管理費(5年以内)
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) EKM_TEIK_FIVE_YEARS " + "\n"); // 役務提供費(5年以内)	
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT_STAX " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) LAMT_STAX_FIVE_YEARS " + "\n"); //  消費税等(5年以内)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");		
		super.sql.append("                 TNKI.LAMT " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) MIKEIKA_LEASE_OVER_FIVE_YEARS " + "\n"); // 未経過リース料(5年超)
		super.sql.append("        ,MAX(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");
		super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) ZANK_HOSYOGAKU_OVER_FIVE_YEARS " + "\n"); // 残価保証額(5年超)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) GNPN_OVER_FIVE_YEARS " + "\n"); // 元本(5年超)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) RSK_OVER_FIVE_YEARS " + "\n"); // 利息(5年超)
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");
		super.sql.append("                 TNKI.OTH_CST " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) IJI_KANRIHI_OVER_FIVE_YEARS " + "\n"); // 維持管理費(5年超)
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");
		super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) EKM_TEIK_OVER_FIVE_YEARS " + "\n"); // 役務提供費(5年超)	
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");
		super.sql.append("                 TNKI.LAMT_STAX " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) LAMT_STAX_OVER_FIVE_YEARS " + "\n"); //  消費税等(5年超)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n"); 
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n"); 
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END " + "\n"); 
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n"); 
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n");
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");		
		super.sql.append("                 TNKI.LAMT " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) MIKEIKA_LEASE_TOTAL " + "\n"); // 未経過リース料(合計)
		super.sql.append("        ,MAX(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END) " + "\n"); 
		super.sql.append("        + MAX(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END )  " + "\n"); 
		super.sql.append("        + MAX(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END )  " + "\n");
		super.sql.append("        + MAX(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END )  " + "\n");
		super.sql.append("        + MAX(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")), 60), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END )  " + "\n");
		super.sql.append("        + MAX(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <=  TNKI.KEIJ_YM THEN " + "\n");
		super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) ZANK_HOSYOGAKU_TOTAL " + "\n"); // 残価保証額(合計)
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END   " + "\n"); 		
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END   " + "\n"); 				
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END   " + "\n");		
		super.sql.append("        + CASE " + "\n");
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n");
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n");
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) GNPN_TOTAL " + "\n"); 
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n"); 
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n");
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n");
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n");
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n");
		super.sql.append("       + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM THEN " + "\n");
		super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) RSK_TOTAL " + "\n"); // 利息(合計)		
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.OTH_CST " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n"); 		
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.OTH_CST " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n"); 
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.OTH_CST " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n");
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.OTH_CST " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n");
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.OTH_CST " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n");
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");
		super.sql.append("                 TNKI.OTH_CST " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) IJI_KANRIHI_TOTAL " + "\n"); // 維持管理費(合計)
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n"); 
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n"); 
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n"); 
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n"); 		
		super.sql.append("        + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");
		super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) EKM_TEIK_TOTAL " + "\n"); // 役務提供費(合計)
		super.sql.append("        ,SUM(CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT_STAX " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n"); 
		super.sql.append("       + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT_STAX " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n"); 
		super.sql.append("       + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT_STAX " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n");
		super.sql.append("       + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT_STAX " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n");
		super.sql.append("       + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
		super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
		super.sql.append("                 TNKI.LAMT_STAX " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END  " + "\n");	
		super.sql.append("       + CASE " + "\n"); 
		super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");
		super.sql.append("                 TNKI.LAMT_STAX " + "\n");
		super.sql.append("             ELSE " + "\n");
		super.sql.append("                 0 " + "\n");
		super.sql.append("             END ) LAMT_STAX_TOTAL " + "\n"); // 消費税等(合計)		
		//super.sql.append("FROM   (" + super.getCoreSQL() + ") KB " + "\n");				
		super.sql.append("FROM   T_KEI KEI " + "\n");
		super.sql.append("LEFT   JOIN (SELECT BKN.LC_CD, BKN.KEI_NO, BKN.BKN_NO, BKN.BKN_EDANO, BKN.BKN_NM, " + super.getRisokuKeijoHohoKbn("BKN") + " AS RSK_KEIJ_HOHO_KBN FROM T_BKN BKN) BKN ON BKN.LC_CD = KEI.LC_CD AND BKN.KEI_NO = KEI.KEI_NO " + "\n");		
		super.sql.append("LEFT   JOIN M_LC ON KEI.LC_CD = M_LC.LC_CD " + "\n");
		super.sql.append("LEFT   JOIN M_LU LU ON LU.LU_COSMOS_CD = KEI.LU_COSMOS_CD " + "\n");
		super.sql.append("LEFT   JOIN M_RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN ON RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN = BKN.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("LEFT   JOIN M_FKN_TNKI_HOHO_CD FKN_TNKI_HOHO_CD ON FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_CD = KEI.TNKI_HOHO_KBN " + "\n");
		super.sql.append("LEFT   JOIN M_TRD_HNTE_KEKA_KBN TRD_HNTE_KEKA_KBN ON TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN = KEI.TRD_HNTE_KEKA_KBN " + "\n");
	    super.sql.append("LEFT   JOIN M_AC_SHR_KBN AC ON  AC.CTSHK_FLG = KEI.CTSHK_FLG AND AC.AC_SHR_KBN = " + super.kaikeiSyori + " \n");	
	    super.sql.append("LEFT   JOIN T_UKB_TNKI_HEAD TNKI  ON TNKI.LC_CD = KEI.LC_CD AND TNKI.KEI_NO = KEI.KEI_NO AND TNKI.BKN_NO = BKN.BKN_NO AND TNKI.BKN_EDANO = BKN.BKN_EDANO " + "\n");
	    super.sql.append("LEFT   JOIN T_UKB_TNKI_DETAIL TNKI_DETAIL ON TNKI_DETAIL.LC_CD = TNKI.LC_CD AND TNKI_DETAIL.KEI_NO = KEI.KEI_NO AND TNKI_DETAIL.BKN_NO = BKN.BKN_NO AND TNKI_DETAIL.BKN_EDANO = BKN.BKN_EDANO AND TNKI.KEIJ_YM = TNKI_DETAIL.KEIJ_YM " + "\n");	    	  
	    super.sql.append("            AND BKN.RSK_KEIJ_HOHO_KBN = TNKI_DETAIL.KEIJ_HOHO_KBN AND TNKI.KEIJ_YM = TNKI_DETAIL.KEIJ_YM " + "\n");
		//super.sql.append("WHERE  KEI.TRD_HNTE_KEKA_KBN IN ('1', '2') " + "\n");
		super.sql.append("WHERE  KEI.TRD_HNTE_KEKA_KBN IN ('1', '2', '3') " + "\n");
		super.sql.append("AND    KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "' " + "\n"); // リースユーザ
		super.sql.append("AND    KEI.TAISHO_AC_KIJYUN_CD ='" + super.acStd + "'" + "\n");	
		super.sql.append("AND    AC.AC_SHR_KBN = " + super.kaikeiSyori + "\n");
		super.sql.append("AND    NVL(SUBSTR(KEI.KAI_YMD, 1, 6), '999999') > LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ") " +  "\n"); 		
		
	    // 20210525 arai 対象期間内に受払データが存在するデータのみ取得 START
		super.sql.append("AND  TNKI.KEIJ_YM >= TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') " +  "\n");
	    // 20210525 arai 対象期間内に受払データが存在するデータのみ取得 END
		 
		// 20210524 arai 解約可能リース start
		if (commonBean.isShowKaiKnoOpt()) {
			if (super.kaiknoTermkei.equals("0")) {
				super.sql.append("AND    TNKI.KAI_FNO_FLG = '1' " + "\n");
			}
		}
		// 20210524 arai 解約可能リース対応 end
	
		if (super.keiyakuNo.trim().length() > 0) {
			super.sql.append("AND    KEI.HYJYO_KEI_NO = '" + super.keiyakuNo + "' \n"); // 契約番号
		}

		if (this.bukkenNo.trim().length() > 0) {
			super.sql.append("AND    BKN.BKN_NO || CASE WHEN TRIM(BKN.BKN_EDANO) IS NULL THEN '' ELSE '-' || BKN.BKN_EDANO END = '" + this.bukkenNo + "' " + "\n"); // 物件番号
		}

		// 抽出条件-旧会計基準
		if (super.acStd.equals(LACSDefine.AccountStandard.OLD_0)) {
			if (super.oldkeiyakuGaku.equals("0")) {
				super.sql.append("  AND    ((KEI.SGK_SSN_KBN IS NULL AND KEI.KEI_AMT > 3000000) " + "\n"); // 契約金額３００万円以下(KEI_AMTは物件から取得しているためKEI.KEI_AMTを使用)
				super.sql.append("      OR   (KEI.SGK_SSN_KBN IS NOT NULL AND KEI.SGK_SSN_KBN = '0')) " + "\n");
			}

			if (super.oldleaseKikan.equals("0")) {
				super.sql.append("  AND KEI.KEI_TERM >= 12 " + "\n"); // リース期間１年未満
			}

			if (super.oldsaiLease.equals("0")) {
				super.sql.append("  AND KEI.RLS_TMS = 0" + "\n"); // 再リース契約
			}

			if (super.oldtyutoKaiyaku.equals("0")) {
				super.sql.append("  AND KEI.KAI_YMD IS NULL" + "\n"); // 中途解約物件
			}

			if ("1".equals(super.commonBean.getControlGokeiDsp())) {
				super.sql.append("  AND KEI.CTSHK_FLG = '1'" + "\n"); // 注記合計表表示制御
			}
		}
		// 抽出条件-新会計基準
		if (super.acStd.equals(LACSDefine.AccountStandard.NEW_1)) {
			if (super.newkeiyakuGaku.equals("0")) {
				super.sql.append("  AND    ((KEI.SGK_SSN_KBN IS NULL AND KEI.KEI_AMT > 3000000) " + "\n"); // 契約金額３００万円以下(KEI_AMTは物件から取得しているためKEI.KEI_AMTを使用)
				super.sql.append("      OR   (KEI.SGK_SSN_KBN IS NOT NULL AND KEI.SGK_SSN_KBN = '0')) " + "\n");
			}

			if (super.newleaseKikan.equals("0")) {
				super.sql.append("  AND KEI.KEI_TERM > 12 " + "\n"); // リース期間１年以内
			}

			if (super.newsaiLease.equals("0")) {
				super.sql.append("  AND KEI.RLS_TMS = 0" + "\n"); // 再リース契約
			}

			if (super.newtyutoKaiyaku.equals("0")) {
				super.sql.append("  AND KEI.KAI_YMD IS NULL" + "\n"); // 中途解約物件
			}
		}

		super.sql.append("GROUP  BY DECODE(LU.PDF_COMPANY_NM, NULL, M_LC.LC_NM, LU.PDF_COMPANY_NM) " + "\n");
		super.sql.append("         ,LU.LU_NM " + "\n");		
		super.sql.append("         ,CASE WHEN KEI.JYSI_UM = 1 THEN 'あり' ELSE 'なし' END " + "\n");
		super.sql.append("         ,DECODE(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, '3', '解約不能') || TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_NM " + "\n");
		super.sql.append("         ,AC.AC_SHR_NM " + "\n");
		super.sql.append("         ,FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_NM " + "\n");
		super.sql.append("         ,RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN_NM " + "\n");
		super.sql.append("         ,KEI.HYJYO_KEI_NO " + "\n");
		super.sql.append("         ,BKN.BKN_NO || " + "\n");	
		super.sql.append("          CASE WHEN TRIM(BKN.BKN_EDANO) IS NULL THEN '' ELSE '-' || BKN.BKN_EDANO END " + "\n");
		super.sql.append("         ,KNSHU_YMD " + "\n");
		super.sql.append("         ,MRYO_YMD " + "\n");
		super.sql.append("         ,KAI_YMD " + "\n");
		super.sql.append("         ,BKN.BKN_NM " + "\n");
		super.sql.append("         ,KEI.JYSI_UM " + "\n");
		super.sql.append("         ,TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN " + "\n");		                 
		super.sql.append("         ,AC.AC_SHR_KBN " + "\n");
		super.sql.append("         ,RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("         ,FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_CD " + "\n");			
		super.sql.append("         ,BKN.BKN_NO " + "\n");	
		super.sql.append("         ,RPAD(KEI.LU_COSMOS_CD, 10, ' ')  " + "\n");
		super.sql.append("         ,RPAD(KEI.LU_COSMOS_CD, 10, ' ') || RPAD(KEI.JYSI_UM, 1, ' ')  " + "\n");
		super.sql.append("         ,RPAD(KEI.LU_COSMOS_CD, 10, ' ') || RPAD(KEI.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ')  " + "\n");
		super.sql.append("         ,RPAD(KEI.LU_COSMOS_CD, 10, ' ') || RPAD(KEI.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(AC.AC_SHR_KBN , 1, ' ')  " + "\n");
		super.sql.append("         ,RPAD(KEI.LU_COSMOS_CD, 10, ' ') || RPAD(KEI.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(AC.AC_SHR_KBN , 1, ' ') || RPAD(RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN , 1, ' ')  " + "\n");
		super.sql.append("         ,RPAD(KEI.LU_COSMOS_CD, 10, ' ') || RPAD(KEI.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(AC.AC_SHR_KBN , 1, ' ') || RPAD(RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN , 1, ' ') || RPAD(FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_CD , 1, ' ')  " + "\n");
		super.sql.append("ORDER  BY JYSI_UM_CD" + "\n");
		super.sql.append("         ,TRD_HNTE_KEKA_KBN  " + "\n");		
		super.sql.append("         ,AC_SHR_KBN" + "\n");
		super.sql.append("         ,RSK_KEIJ_HOHO_KBN" + "\n");
		super.sql.append("         ,FKN_TNKI_HOHO_CD " + "\n");		
		super.sql.append("         ,BKN_NO" + "\n");	
		super.sql.append("         ,KEI.HYJYO_KEI_NO " + "\n");
		
		//System.out.print(super.sql);
		
	}
	
	/**
	 * 基準日を取得.
	 * 
	 * @return 基準日
	 */
	public String getBaseDate() {
		return super.getString("END_YMD");
	}
		
	/**
	 * 開示先を取得.
	 * 
	 * @return 開示先
	 */
	public String getKaizisaki() {
		return super.getString("LU_NM");
	}
	
	/**
	 * 重要性有無を取得.
	 * 
	 * @return 重要性有無
	 */
	public String getJysiUm() {
		return super.getString("JYSI_UM");
	}
	
	/**
	 * 重要性有無コードを取得.
	 * 
	 * @return 重要性有無
	 */
	public String getJysiUmCd() {
		return super.getString("JYSI_UM_CD");
	}	


	/**
	 * リース会社を取得.
	 * 
	 * @return リース会社
	 */
	public String getLeaseCompany() {
		return super.getString("LEASE_COMPANY");
	}

	/**
	 * リース取引分類を取得.
	 * 
	 * @return リース会社
	 */
	public String getLeaseBunrui() {
		return super.getString("LEASE_BUNRUI");
	}
	
	
	/**
	 * リース取引分類を取得.
	 * 
	 * @return リース会社
	 */
	public String getLeaseBunruiCd() {
		return super.getString("TRD_HNTE_KEKA_KBN");
	}
	
	/**
	 * 会計処理方法を取得.
	 * 
	 * @return 会計処理方法
	 */
	public String getKaikeiSyori() {
		return super.getString("AC_SHR_KBN_NM");
	}
	
	/**
	 * 会計処理方法コードを取得.
	 * 
	 * @return 会計処理方法
	 */
	public String getKaikeiSyoriCd() {
		return super.getString("AC_SHR_KBN");
	}

	/**
	 * 利息相当額配分方法を取得.
	 * 
	 * @return 利息相当額配分方法
	 */
	public String getRisokuBunpaiHouhou() {
		return super.getString("RSK_KEIJ_HOHO_KBN_NM");
	}
	
	/**
	 * 利息相当額配分方法コードを取得.
	 * 
	 * @return 利息相当額配分方法
	 */
	public String getRisokuBunpaiHouhouCd() {
		return super.getString("RSK_KEIJ_HOHO_KBN_CD");
	}

	/**
	 * 当期支払リース料計算基準を取得.
	 * 
	 * @return 当期支払リース料計算基準
	 */
	public String getToukiReaseRyouKeisanKijyun() {
		return super.getString("FKN_TNKI_HOHO_NM");
	}
		
	/**
	 * 当期支払リース料計算基準コードを取得.
	 * 
	 * @return 当期支払リース料計算基準
	 */
	public String getToukiReaseRyouKeisanKijyunCd() {
		return super.getString("FKN_TNKI_HOHO_CD");
	}
	
	/**
	 * 契約番号を取得.
	 * 
	 * @return 契約番号
	 */
	public String getKeiyakuNo() {
		return super.getString("KEI_NO");
	}
	
	/**
	 * 物件番号を取得.
	 * 
	 * @return 物件番号
	 */
	public String getBukenNo() {
		return super.getString("BKN_NO");
	}
	
	/**
	 * 物件名を取得.
	 * 
	 * @return 物件名
	 */
	public String getBukenNm() {
		return super.getString("BKN_NM");
	}

	/**
	 * リース開始日を取得.
	 * 
	 * @return リース開始日
	 */
	public String getLeaseFrom() {
		return super.getString("KNSHU_YMD");
	}

	/**
	 * リース終了日を取得.
	 * 
	 * @return リース終了日
	 */
	public String getLeaseTo() {
		return super.getString("MRYO_YMD");
	}

	/**
	 * 中途解約日を取得.
	 * 
	 * @return 中途解約日
	 */
	public String getKaiyakuYmd() {
		return super.getString("KAI_YMD");
	}
	
	/**
	 * 未経過リース料(1年以内)を取得.
	 * 
	 * @return 未経過リース料(1年以内)
	 */
	public long getMikeikaLeaseWithinOneYear() {
		return super.getLong("MIKEIKA_LEASE_ONE_YEAR");
	}
	
	/**
	 * 未経過リース料(2年以内)を取得.
	 * 
	 * @return 未経過リース料(2年以内)
	 */
	public long getMikeikaLeaseWithinTwoYears() {
		return super.getLong("MIKEIKA_LEASE_TWO_YEARS");
	}
	
	/**
	 * 未経過リース料(3年以内)を取得.
	 * 
	 * @return 未経過リース料(3年以内)
	 */
	public long getMikeikaLeaseWithinThreeYears() {
		return super.getLong("MIKEIKA_LEASE_THREE_YEARS");
	}
	
	/**
	 * 未経過リース料(4年以内)を取得.
	 * 
	 * @return 未経過リース料(4年以内)
	 */
	public long getMikeikaLeaseWithinFourYears() {
		return super.getLong("MIKEIKA_LEASE_FOUR_YEARS");
	}
	
	/**
	 * 未経過リース料(5年以内)を取得.
	 * 
	 * @return 未経過リース料(5年以内)
	 */
	public long getMikeikaLeaseWithinFiveYears() {
		return super.getLong("MIKEIKA_LEASE_FIVE_YEARS");
	}
	
	/**
	 * 未経過リース料(5年超)を取得.
	 * 
	 * @return 未経過リース料(5年超)
	 */
	public long getMikeikaLeaseOverFiveYears() {
		return super.getLong("MIKEIKA_LEASE_OVER_FIVE_YEARS");
	}
	
	/**
	 * 残価保証額(1年以内)を取得.
	 * 
	 * @return 残価保証額(1年以内)
	 */
	public long getZankaHosyogakuWithinOneYear() {
		return super.getLong("ZANK_HOSYOGAKU_ONE_YEAR");
	}
	
	/**
	 * 残価保証額(2年以内)を取得.
	 * 
	 * @return 残価保証額(2年以内)
	 */
	public long getZankaHosyogakuWithinTwoYears() {
		return super.getLong("ZANK_HOSYOGAKU_TWO_YEARS");
	}
	
	/**
	 * 残価保証額(3年以内)を取得.
	 * 
	 * @return 残価保証額(3年以内)
	 */
	public long getZankaHosyogakuWithinThreeYears() {
		return super.getLong("ZANK_HOSYOGAKU_THREE_YEARS");
	}
	
	/**
	 * 残価保証額(4年以内)を取得.
	 * 
	 * @return 残価保証額(4年以内)
	 */
	public long getZankaHosyogakuWithinFourYears() {
		return super.getLong("ZANK_HOSYOGAKU_FOUR_YEARS");
	}
	
	/**
	 * 残価保証額(5年以内)を取得.
	 * 
	 * @return 残価保証額(5年以内)
	 */
	public long getZankaHosyogakuWithinFiveYears() {
		return super.getLong("ZANK_HOSYOGAKU_FIVE_YEARS");
	}
	
	/**
	 * 残価保証額(5年超)を取得.
	 * 
	 * @return 残価保証額(5年超)
	 */
	public long getZankaHosyogakuOverFiveYears() {
		return super.getLong("ZANK_HOSYOGAKU_OVER_FIVE_YEARS");
	}
	
	/**
	 * 元本(1年以内)を取得.
	 * 
	 * @return 元本(1年以内)
	 */
	public long getGanponWithinOneYear() {
		return super.getLong("GNPN_ONE_YEAR");
	}
	
	/**
	 * 元本(2年以内)を取得.
	 * 
	 * @return 元本(2年以内)
	 */
	public long getGanponWithinTwoYears() {
		return super.getLong("GNPN_TWO_YEARS");
	}
	
	/**
	 * 元本(3年以内)を取得.
	 * 
	 * @return 元本(3年以内)
	 */
	public long getGanponWithinThreeYears() {
		return super.getLong("GNPN_THREE_YEARS");
	}
	
	/**
	 * 元本(4年以内)を取得.
	 * 
	 * @return 元本(4年以内)
	 */
	public long getGanponWithinFourYears() {
		return super.getLong("GNPN_FOUR_YEARS");
	}
	
	/**
	 * 元本(5年以内)を取得.
	 * 
	 * @return 元本(5年以内)
	 */
	public long getGanponWithinFiveYears() {
		return super.getLong("GNPN_FIVE_YEARS");
	}
	
	/**
	 * 元本(5年超)を取得.
	 * 
	 * @return 元本(5年超)
	 */
	public long getGanponOverFiveYears() {
		return super.getLong("GNPN_OVER_FIVE_YEARS");
	}
	
	/**
	 * 利息(1年以内)を取得.
	 * 
	 * @return 利息(1年以内)
	 */
	public long getRisokuWithinOneYear() {
		return super.getLong("RSK_ONE_YEAR");
	}
	
	/**
	 * 利息(2年以内)を取得.
	 * 
	 * @return 利息(2年以内)
	 */
	public long getRisokuWithinTwoYears() {
		return super.getLong("RSK_TWO_YEARS");
	}
	
	/**
	 * 利息(3年以内)を取得.
	 * 
	 * @return 利息(3年以内)
	 */
	public long getRisokuWithinThreeYears() {
		return super.getLong("RSK_THREE_YEARS");
	}
	
	/**
	 * 利息(4年以内)を取得.
	 * 
	 * @return 利息(4年以内)
	 */
	public long getRisokuWithinFourYears() {
		return super.getLong("RSK_FOUR_YEARS");
	}
	
	/**
	 * 利息(5年以内)を取得.
	 * 
	 * @return 利息(5年以内)
	 */
	public long getRisokuWithinFiveYears() {
		return super.getLong("RSK_FIVE_YEARS");
	}
	
	/**
	 * 利息(5年超)を取得.
	 * 
	 * @return 利息(5年超)
	 */
	public long getRisokuOverFiveYears() {
		return super.getLong("RSK_OVER_FIVE_YEARS");
	}

	/**
	 * 維持管理費(1年以内)を取得.
	 * 
	 * @return 維持管理費(1年以内)
	 */
	public long getIjiKanrihiWithinOneYear() {
		return super.getLong("IJI_KANRIHI_ONE_YEAR");
	}
	
	/**
	 * 維持管理費(2年以内)を取得.
	 * 
	 * @return 維持管理費(2年以内)
	 */
	public long getIjiKanrihiWithinTwoYears() {
		return super.getLong("IJI_KANRIHI_TWO_YEARS");
	}
	
	/**
	 * 維持管理費(3年以内)を取得.
	 * 
	 * @return 維持管理費(3年以内)
	 */
	public long getIjiKanrihiWithinThreeYears() {
		return super.getLong("IJI_KANRIHI_THREE_YEARS");
	}
	
	/**
	 * 維持管理費(4年以内)を取得.
	 * 
	 * @return 維持管理費(4年以内)
	 */
	public long getIjiKanrihiWithinFourYears() {
		return super.getLong("IJI_KANRIHI_FOUR_YEARS");
	}
	
	/**
	 * 維持管理費(5年以内)を取得.
	 * 
	 * @return 維持管理費(5年以内)
	 */
	public long getIjiKanrihiWithinFiveYears() {
		return super.getLong("IJI_KANRIHI_FIVE_YEARS");
	}
	
	/**
	 * 維持管理費(5年超)を取得.
	 * 
	 * @return 維持管理費(5年超)
	 */
	public long getIjiKanrihiOverFiveYears() {
		return super.getLong("IJI_KANRIHI_OVER_FIVE_YEARS");
	}
	
	/**
	 * 役務提供費(1年以内)を取得.
	 * 
	 * @return 役務提供費(1年以内)
	 */
	public long getEkimuteikiWithinOneYear() {
		return super.getLong("EKM_TEIK_ONE_YEAR");
	}
	
	/**
	 * 役務提供費(2年以内)を取得.
	 * 
	 * @return 役務提供費(2年以内)
	 */
	public long getEkimuteikiWithinTwoYears() {
		return super.getLong("EKM_TEIK_TWO_YEARS");
	}
	
	/**
	 * 役務提供費(3年以内)を取得.
	 * 
	 * @return 役務提供費(3年以内)
	 */
	public long getEkimuteikiWithinThreeYears() {
		return super.getLong("EKM_TEIK_THREE_YEARS");
	}
	
	/**
	 * 役務提供費(4年以内)を取得.
	 * 
	 * @return 役務提供費(4年以内)
	 */
	public long getEkimuteikiWithinFourYears() {
		return super.getLong("EKM_TEIK_FOUR_YEARS");
	}
	
	/**
	 * 役務提供費(5年以内)を取得.
	 * 
	 * @return 役務提供費(5年以内)
	 */
	public long getEkimuteikiWithinFiveYears() {
		return super.getLong("EKM_TEIK_FIVE_YEARS");
	}
	
	/**
	 * 役務提供費(5年超)を取得.
	 * 
	 * @return 役務提供費(5年超)
	 */
	public long getEkimuteikiOverFiveYears() {
		return super.getLong("EKM_TEIK_OVER_FIVE_YEARS");
	}
	
	/**
	 * 消費税等(1年以内)を取得.
	 * 
	 * @return 消費税等(1年以内)
	 */
	public long getSyohizeiWithinOneYear() {
		return super.getLong("LAMT_STAX_ONE_YEAR");
	}
	
	/**
	 * 消費税等(2年以内)を取得.
	 * 
	 * @return 消費税等(2年以内)
	 */
	public long getSyohizeiWithinTwoYears() {
		return super.getLong("LAMT_STAX_TWO_YEARS");
	}
	
	/**
	 * 消費税等(3年以内)を取得.
	 * 
	 * @return 消費税等(3年以内)
	 */
	public long getSyohizeiWithinThreeYears() {
		return super.getLong("LAMT_STAX_THREE_YEARS");
	}
	
	/**
	 * 消費税等(4年以内)を取得.
	 * 
	 * @return 消費税等(4年以内)
	 */
	public long getSyohizeiWithinFourYears() {
		return super.getLong("LAMT_STAX_FOUR_YEARS");
	}
	
	/**
	 * 消費税等(5年以内)を取得.
	 * 
	 * @return 消費税等(5年以内)
	 */
	public long getSyohizeiWithinFiveYears() {
		return super.getLong("LAMT_STAX_FIVE_YEARS");
	}
	
	/**
	 * 消費税等(5年超)を取得.
	 * 
	 * @return 消費税等(5年超)
	 */
	public long getSyohizeiOverFiveYears() {
		return super.getLong("LAMT_STAX_OVER_FIVE_YEARS");
	}
	
    /**
	 * 未経過リース料(合計)を取得.
	 * 
	 * @return 未経過リース料(合計)
	 */
	public long getMikeikaLeaseTotal() {
		return super.getLong("MIKEIKA_LEASE_TOTAL");
	}
	
	/**
	 * 残価保証額(合計)を取得.
	 * 
	 * @return 残価保証額(合計)
	 */
	public long getZankaHosyogakuTotal() {
		return super.getLong("ZANK_HOSYOGAKU_TOTAL");
	}
 
    /**
	 * 元本(合計)を取得.
	 * 
	 * @return 元本(合計)
	 */
	public long getGanponTotal() {
		return super.getLong("GNPN_TOTAL");
	}
 
    /**
	 * 利息(合計)を取得.
	 * 
	 * @return 利息(合計)
	 */
	public long getRisokuTotal() {
		return super.getLong("RSK_TOTAL");
	}
	
	/**
	 * 維持管理費(合計)を取得.
	 * 
	 * @return 維持管理費(合計)
	 */
	public long getIjiKanrihiTotal() {
		return super.getLong("IJI_KANRIHI_TOTAL");
	}
	
	/**
	 * 役務提供費(合計)を取得.
	 * 
	 * @return 役務提供費(合計)
	 */
	public long getEkimuteikiTotal() {
		return super.getLong("EKM_TEIK_TOTAL");
	}
	
	/**
	 * 消費税等(合計)を取得.
	 * 
	 * @return 消費税等(合計)
	 */
	public long getSyohizeiTotal() {
		return super.getLong("LAMT_STAX_TOTAL");
	}
		
	/**
	 * ブレイクキー0を取得.
	 * 
	 * @return ブレイクキー0
	 */
	public String getBreakKey0() {
		return super.getString("BRAKE_KEY0");
	}
	
	/**
	 * ブレイクキー0を取得.
	 * 
	 * @return ブレイクキー0
	 */
	public String getBreakKey1() {
		return super.getString("BRAKE_KEY1");
	}
	
	/**
	 * ブレイクキー2を取得.
	 * 
	 * @return ブレイクキー2
	 */
	public String getBreakKey2() {
		return super.getString("BRAKE_KEY2");
	}
	
	/**
	 * ブレイクキー3を取得.
	 * 
	 * @return ブレイクキー3
	 */
	public String getBreakKey3() {
		return super.getString("BRAKE_KEY3");
	
	}
	
	/**
	 * ブレイクキー4を取得.
	 * 
	 * @return ブレイクキー4
	 */
	public String getBreakKey4() {
		return super.getString("BRAKE_KEY4");
	}
	
	/**
	 * ブレイクキー5を取得.
	 * 
	 * @return ブレイクキー5
	 */
	public String getBreakKey5() {
		return super.getString("BRAKE_KEY5");
	
	}
	

}
