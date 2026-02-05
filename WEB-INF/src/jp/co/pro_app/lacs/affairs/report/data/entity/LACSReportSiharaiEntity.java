package jp.co.pro_app.lacs.affairs.report.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 帳票出力：リース会計資料（支払リース料等）Entity.
 * 
 * @author ohmura
 * @version 20070901
 */
public class LACSReportSiharaiEntity extends LACSReportEntityBase {

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
	public LACSReportSiharaiEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSReportBean piReportBean, String piAcStd) {
		super(piModel, piCommonBean, piReportBean, piAcStd);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT RPAD(KB.LU_COSMOS_CD, 10, ' ') BRAKE_KEY0 " + "\n");
		// 2020/05/22 REP START
		//DEL super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') BRAKE_KEY1 " + "\n");
		//DEL super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG, 1, ' ') BRAKE_KEY2 " + "\n");
		//DEL super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG, 1, ' ') || RPAD(KB.SSN_SRI_CD, 1, ' ') BRAKE_KEY3 " + "\n");
		//DEL super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG, 1, ' ') || RPAD(KB.SSN_SRI_CD, 1, ' ') || RPAD(KB.RSK_KEIJ_HOHO_KBN, 3, ' ') BRAKE_KEY4 " + "\n");
		//DEL super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG, 1, ' ') || RPAD(KB.SSN_SRI_CD, 1, ' ') || RPAD(KB.RSK_KEIJ_HOHO_KBN, 3, ' ') || RPAD(KB.TNKI_HOHO_KBN, 1, ' ') BRAKE_KEY5 " + "\n");
		super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') BRAKE_KEY0_1 " + "\n");
		super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') BRAKE_KEY1 " + "\n");
		super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG, 1, ' ') BRAKE_KEY2 " + "\n");
		super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG, 1, ' ') || RPAD(KB.SSN_SRI_CD, 1, ' ') BRAKE_KEY3 " + "\n");
		super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG, 1, ' ') || RPAD(KB.SSN_SRI_CD, 1, ' ') || RPAD(KB.RSK_KEIJ_HOHO_KBN, 3, ' ') BRAKE_KEY4 " + "\n");
		super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG, 1, ' ') || RPAD(KB.SSN_SRI_CD, 1, ' ') || RPAD(KB.RSK_KEIJ_HOHO_KBN, 3, ' ') || RPAD(KB.TNKI_HOHO_KBN, 1, ' ') BRAKE_KEY5 " + "\n");
		// 2020/05/22 REP END
		super.sql.append("      ,DECODE(LU.PDF_COMPANY_NM, NULL, M_LC.LC_NM, LU.PDF_COMPANY_NM) LEASE_COMPANY " + "\n");
		super.sql.append("      ,LU.LU_NM LEASE_USER " + "\n");
		// 2020/05/22 REP START
		super.sql.append("      ,CASE WHEN KB.JYSI_UM = '1' THEN 'あり' ELSE 'なし' END JYSI_UM " + "\n");
		// 2020/05/22 REP END
		super.sql.append("      ,DECODE(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, '3', '解約不能') || TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_NM LEASE_BUNRUI " + "\n");
		super.sql.append("      ,SSN_SRI.SSN_SRI_NM " + "\n");
		super.sql.append("      ,RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN_NM " + "\n");
		super.sql.append("      ,FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_NM " + "\n");
		super.sql.append("      ,KB.HYJYO_KEI_NO KEI_NO " + "\n");
		super.sql.append("      ,KB.KNSHU_YMD " + "\n");
		super.sql.append("      ,KB.MRYO_YMD " + "\n");
		super.sql.append("      ,KB.BKN_NO " + "\n");
		super.sql.append("    || CASE " + "\n");
		super.sql.append("           WHEN TRIM(KB.BKN_EDANO) IS NULL THEN " + "\n");
		super.sql.append("               '' " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("               '-' || KB.BKN_EDANO " + "\n");
		super.sql.append("       END BKN_NO " + "\n");
		super.sql.append("      ,KB.BKN_NM " + "\n");
		super.sql.append("      ,KB.KAI_YMD " + "\n");
		super.sql.append("      ,CASE KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("           WHEN '101' THEN " + "\n");
		super.sql.append("               KB.MBRI_RSK_CLC_RS_RT " + "\n");
		super.sql.append("           WHEN '102' THEN " + "\n");
		super.sql.append("               KB.ABRI_RSK_CLC_RS_RT " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("               NULL " + "\n");
		super.sql.append("       END RSK_CLC_RS_RT " + "\n");
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("           WHEN M_LC.KIMATSU_AMT_OUT_CTL = 0 AND (KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD)) THEN " + "\n");
		super.sql.append("               0 " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("               KB.KEI_AMT " + "\n");
		super.sql.append("             + CASE " + "\n");
		super.sql.append("                   WHEN KB.LU_TRSK_CD IN (KB.IPN_ZANK_HSHOSK_CD, KB.ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("                       KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("       END KEI_AMT " + "\n");
		
		// 20210419 arai 取得価格相当額 対応 start
		// super.sql.append("      ,CASE " + "\n");
		// super.sql.append("           WHEN M_LC.KIMATSU_AMT_OUT_CTL = 0 AND (KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD)) THEN " + "\n");
		// super.sql.append("                0 " + "\n");
		// super.sql.append("           ELSE " + "\n");
		// super.sql.append("               CASE KB.RSK_KEIJ_HOHO_KBN " + "\n");
		// super.sql.append("                   WHEN '101' THEN " + "\n");
		// super.sql.append("                       LEAST(KB.MBRI_WRBK_PV, KB.KNU_AMT) " + "\n");
		// super.sql.append("                   WHEN '201' THEN " + "\n");
		// super.sql.append("                       KB.KEI_AMT " + "\n");
		// super.sql.append("                     + CASE " + "\n");
		// super.sql.append("                           WHEN KB.LU_TRSK_CD IN (KB.IPN_ZANK_HSHOSK_CD, KB.ZANK_HSHOSK_CD) THEN " + "\n");
		// super.sql.append("                               KB.ZANK_HSHO_AMT " + "\n");
		// super.sql.append("                           ELSE " + "\n");
		// super.sql.append("                               0 " + "\n");
		// super.sql.append("                       END " + "\n");
		// super.sql.append("                   ELSE " + "\n");
		// super.sql.append("                       LEAST(KB.ABRI_WRBK_PV, KB.KNU_AMT) " + "\n");
		// super.sql.append("               END " + "\n");
		// super.sql.append("       END KNU_AMT " + "\n");
		super.sql.append("      ,KB.GET_PRC_SHOMI KNU_AMT " + "\n");		
		// 20210419 arai 取得価格相当額 対応 end
		
		// 20210421 arai 維持管理費相当額 対応 start 
		// super.sql.append("      ,CASE " + "\n");
		// super.sql.append("           WHEN KB.RSK_KEIJ_HOHO_KBN = '201' THEN " + "\n");
		// super.sql.append("               0 " + "\n");
		// super.sql.append("           ELSE " + "\n");
		// super.sql.append("               CASE " + "\n");
		// super.sql.append("                   WHEN M_LC.KIMATSU_AMT_OUT_CTL = 0 AND (KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD)) THEN " + "\n");
		// super.sql.append("                       0 " + "\n");
		// super.sql.append("                   ELSE " + "\n");
		// super.sql.append("                       KB.ENT_SHOHYO_KZI + KB.ENT_SHOHYO_HKZI + KB.GTAX + KB.CTAX + KB.JTAX + KB.JBSK_HKN + KB.NNI_HKN + KB.RCYCL_RYO_KNRI_AMT + KB.DOSO + KB.KOZEI + KB.OTH_CST " + "\n");
		// super.sql.append("               END " + "\n");
		// super.sql.append("       END IJI_KANRIHI " + "\n");
		
		super.sql.append("      ,(SELECT " + "\n");
		super.sql.append("               SUM(HEAD.YTE_ENT_SHOHYO_KZI + HEAD.YTE_ENT_SHOHYO_HKZI + HEAD.YTE_GTAX + HEAD.YTE_CTAX + HEAD.YTE_JTAX + HEAD.YTE_JBSK_HKN + " + "\n");
		super.sql.append("               HEAD.YTE_NNI_HKN + HEAD.YTE_RCYCL_RYO_KNRI_AMT + HEAD.YTE_DOSO + HEAD.YTE_KOZEI + HEAD.YTE_OTH_CST) " + "\n");
		super.sql.append("        FROM   T_UKB_TNKI_HEAD HEAD " + "\n");
		super.sql.append("        WHERE  HEAD.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("        AND    HEAD.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("        AND    HEAD.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("        AND    HEAD.BKN_EDANO = KB.BKN_EDANO) IJI_KANRIHI " + "\n");
				
		// 20210421 arai 維持管理費相当額 対応 end 
		
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("           WHEN KB.RSK_KEIJ_HOHO_KBN = '201' THEN " + "\n");
		super.sql.append("               0 " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("               CASE " + "\n");
		super.sql.append("                   WHEN M_LC.KIMATSU_AMT_OUT_CTL = 0 AND (KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD)) THEN " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       KB.IPN_EKM_TEIK_HYO + KB.SHRY_EKM_TEIK_HYO " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("       END EKM_TEIK " + "\n");
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("           WHEN M_LC.KIMATSU_AMT_OUT_CTL = 0 AND (KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD)) THEN " + "\n");
		super.sql.append("               0 " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("               CASE " + "\n");
		super.sql.append("                   WHEN KB.LU_TRSK_CD IN (KB.IPN_ZANK_HSHOSK_CD, KB.ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("                       KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("       END ZANK_HSHO_AMT " + "\n");
		super.sql.append("      ,(SELECT SUM(FKN_TNKI.LAMT) " + "\n");
		super.sql.append("             - CASE " + "\n");
		super.sql.append("                   WHEN KB.RSK_KEIJ_HOHO_KBN = '201' THEN " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       SUM(FKN_TNKI.ENT_SHOHYO_KZI + FKN_TNKI.ENT_SHOHYO_HKZI + FKN_TNKI.GTAX + FKN_TNKI.CTAX + FKN_TNKI.JTAX + FKN_TNKI.JBSK_HKN + FKN_TNKI.NNI_HKN + FKN_TNKI.RCYCL_RYO_KNRI_AMT + FKN_TNKI.DOSO + FKN_TNKI.KOZEI + FKN_TNKI.OTH_CST + FKN_TNKI.IPN_EKM_TEIK_HYO + FKN_TNKI.SHRY_EKM_TEIK_HYO) " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("             + CASE " + "\n");
		super.sql.append("                   WHEN M_LC.KIMATSU_AMT_OUT_CTL = 0 AND KB.KAI_YMD <= END_YMD THEN " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("                   WHEN KB.FKN_KEIJ_YM_MAX BETWEEN START_KEIJ_YM AND END_KEIJ_YM AND KB.LU_TRSK_CD IN (KB.ZANK_HSHOSK_CD, KB.IPN_ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("                       KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("        FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("        WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("        AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("        AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("        AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("        AND    FKN_TNKI.KEIJ_YM BETWEEN START_KEIJ_YM AND FKN_KEIJ_YM_LAST) LAMT " + "\n");
		
		// 20210421 arai 当期維持管理費 対応 start
		//super.sql.append("      ,(SELECT CASE " + "\n");
		//super.sql.append("                   WHEN KB.RSK_KEIJ_HOHO_KBN = '201' THEN " + "\n");
		//super.sql.append("                       0 " + "\n");
		//super.sql.append("                   ELSE " + "\n");
		//super.sql.append("                       SUM(FKN_TNKI.ENT_SHOHYO_KZI + FKN_TNKI.ENT_SHOHYO_HKZI + FKN_TNKI.GTAX + FKN_TNKI.CTAX + FKN_TNKI.JTAX + FKN_TNKI.JBSK_HKN + FKN_TNKI.NNI_HKN + FKN_TNKI.RCYCL_RYO_KNRI_AMT + FKN_TNKI.DOSO + FKN_TNKI.KOZEI + FKN_TNKI.OTH_CST) " + "\n");
		//super.sql.append("               END " + "\n");
		//super.sql.append("        FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		//super.sql.append("        WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		//super.sql.append("        AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		//super.sql.append("        AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		//super.sql.append("        AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		//super.sql.append("        AND    FKN_TNKI.KEIJ_YM BETWEEN START_KEIJ_YM AND FKN_KEIJ_YM_LAST) TOUKI_IJI_KANRIHI " + "\n");
		
		super.sql.append("      ,(SELECT " + "\n");
		super.sql.append("               SUM(FKN_TNKI.ENT_SHOHYO_KZI + FKN_TNKI.ENT_SHOHYO_HKZI + FKN_TNKI.GTAX + FKN_TNKI.CTAX + FKN_TNKI.JTAX + FKN_TNKI.JBSK_HKN " + "\n");
		super.sql.append("               + FKN_TNKI.NNI_HKN + FKN_TNKI.RCYCL_RYO_KNRI_AMT + FKN_TNKI.DOSO + FKN_TNKI.KOZEI + FKN_TNKI.OTH_CST) " + "\n");
		super.sql.append("        FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("        WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("        AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("        AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("        AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("        AND    FKN_TNKI.KEIJ_YM BETWEEN START_KEIJ_YM AND FKN_KEIJ_YM_LAST) TOUKI_IJI_KANRIHI " + "\n");
		// 20210421 arai 当期維持管理費 対応 end
		
		super.sql.append("      ,(SELECT CASE " + "\n");
		super.sql.append("                   WHEN KB.RSK_KEIJ_HOHO_KBN = '201' THEN " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       SUM(FKN_TNKI.IPN_EKM_TEIK_HYO + FKN_TNKI.SHRY_EKM_TEIK_HYO) " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("        FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("        WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("        AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("        AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("        AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("        AND    FKN_TNKI.KEIJ_YM BETWEEN START_KEIJ_YM AND FKN_KEIJ_YM_LAST) TOUKI_EKM_TEIK " + "\n");
		super.sql.append("      ,(SELECT SUM(HSE_RSK) HSE_RSK " + "\n");
		super.sql.append("        FROM   T_UKB_TNKI_DETAIL FKN_TNKI " + "\n");
		super.sql.append("        WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("        AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("        AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("        AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("        AND    FKN_TNKI.KEIJ_HOHO_KBN = KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("        AND    FKN_TNKI.KEIJ_YM BETWEEN START_KEIJ_YM AND FKN_KEIJ_YM_LAST) SIHARAI_RSK " + "\n");
		super.sql.append("      ,(SELECT SUM(TGTU_GNPN) TGTU_GNPN " + "\n");
		super.sql.append("        FROM   T_UKB_TNKI_DETAIL FKN_TNKI " + "\n");
		super.sql.append("        WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("        AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("        AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("        AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("        AND    FKN_TNKI.KEIJ_HOHO_KBN = KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("        AND    FKN_TNKI.KEIJ_YM BETWEEN START_KEIJ_YM AND FKN_KEIJ_YM_LAST) LEASE_SAIMU " + "\n");
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("           WHEN KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("               0 " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("               (SELECT NVL(SUM(CASE WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN FKN_TNKI.TGTU_GNPN " + "\n");
		super.sql.append("								      ELSE FKN_TNKI.YTE_TGTU_GNPN " + "\n");
		super.sql.append("							     END), 0) " + "\n");
		super.sql.append("                FROM   T_UKB_TNKI_DETAIL FKN_TNKI " + "\n");
		super.sql.append("                      ,T_UKB_TNKI_HEAD FKN_TNKI_H " + "\n");
		super.sql.append("                WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("                AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("                AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("                AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("                AND    FKN_TNKI.KEIJ_HOHO_KBN = KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                AND    FKN_TNKI.LC_CD = FKN_TNKI_H.LC_CD " + "\n");
		super.sql.append("                AND    FKN_TNKI.KEI_NO = FKN_TNKI_H.KEI_NO " + "\n");
		super.sql.append("                AND    FKN_TNKI.BKN_NO = FKN_TNKI_H.BKN_NO " + "\n");
		super.sql.append("                AND    FKN_TNKI.BKN_EDANO = FKN_TNKI_H.BKN_EDANO " + "\n");
		super.sql.append("                AND    FKN_TNKI.KEIJ_YM = FKN_TNKI_H.KEIJ_YM " + "\n");
		if (commonBean.isShowKaiKnoOpt()) {
			if (super.kaiknoTermkei.equals("0")) {
				super.sql.append("                AND    FKN_TNKI_H.KAI_FNO_FLG = '1' " + "\n");
			}
		}
		super.sql.append("                AND    FKN_TNKI.KEIJ_YM >= NEXT_START_KEIJ_YM) " + "\n");
		super.sql.append("       END KIMATU_ZAN " + "\n");
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("           WHEN KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("               0 " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("               (SELECT NVL(SUM(CASE WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN FKN_TNKI.TGTU_GNPN " + "\n");
		super.sql.append("								      ELSE FKN_TNKI.YTE_TGTU_GNPN " + "\n");
		super.sql.append("							     END), 0) " + "\n");
		super.sql.append("                FROM   T_UKB_TNKI_DETAIL FKN_TNKI " + "\n");
		super.sql.append("                      ,T_UKB_TNKI_HEAD FKN_TNKI_H " + "\n");
		super.sql.append("                WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("                AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("                AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("                AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("                AND    FKN_TNKI.KEIJ_HOHO_KBN = KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                AND    FKN_TNKI.LC_CD = FKN_TNKI_H.LC_CD " + "\n");
		super.sql.append("                AND    FKN_TNKI.KEI_NO = FKN_TNKI_H.KEI_NO " + "\n");
		super.sql.append("                AND    FKN_TNKI.BKN_NO = FKN_TNKI_H.BKN_NO " + "\n");
		super.sql.append("                AND    FKN_TNKI.BKN_EDANO = FKN_TNKI_H.BKN_EDANO " + "\n");
		super.sql.append("                AND    FKN_TNKI.KEIJ_YM = FKN_TNKI_H.KEIJ_YM " + "\n");
		if (commonBean.isShowKaiKnoOpt()) {
			if (super.kaiknoTermkei.equals("0")) {
				super.sql.append("                AND    FKN_TNKI_H.KAI_FNO_FLG = '1' " + "\n");
			}
		}
		super.sql.append("                AND    FKN_TNKI.KEIJ_YM BETWEEN NEXT_START_KEIJ_YM AND NEXT_END_KEIJ_YM) " + "\n");
		super.sql.append("       END KIMATU_ZAN_1NAI " + "\n");
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("           WHEN KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("               0 " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("               (SELECT NVL(SUM(CASE WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN FKN_TNKI.TGTU_GNPN " + "\n");
		super.sql.append("								      ELSE FKN_TNKI.YTE_TGTU_GNPN " + "\n");
		super.sql.append("							     END), 0) " + "\n");
		super.sql.append("                FROM   T_UKB_TNKI_DETAIL FKN_TNKI " + "\n");
		super.sql.append("                      ,T_UKB_TNKI_HEAD FKN_TNKI_H " + "\n");
		super.sql.append("                WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("                AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("                AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("                AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("                AND    FKN_TNKI.KEIJ_HOHO_KBN = KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                AND    FKN_TNKI.LC_CD = FKN_TNKI_H.LC_CD " + "\n");
		super.sql.append("                AND    FKN_TNKI.KEI_NO = FKN_TNKI_H.KEI_NO " + "\n");
		super.sql.append("                AND    FKN_TNKI.BKN_NO = FKN_TNKI_H.BKN_NO " + "\n");
		super.sql.append("                AND    FKN_TNKI.BKN_EDANO = FKN_TNKI_H.BKN_EDANO " + "\n");
		super.sql.append("                AND    FKN_TNKI.KEIJ_YM = FKN_TNKI_H.KEIJ_YM " + "\n");
		if (commonBean.isShowKaiKnoOpt()) {
			if (super.kaiknoTermkei.equals("0")) {
				super.sql.append("                AND    FKN_TNKI_H.KAI_FNO_FLG = '1' " + "\n");
			}
		}
		super.sql.append("                AND    FKN_TNKI.KEIJ_YM >= OVER_NEXT_START_KEIJ_YM) " + "\n");
		super.sql.append("       END KIMATU_ZAN_1CYO " + "\n");
		super.sql.append("      ,TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("      ,KB.SSN_SRI_CD " + "\n");
		super.sql.append("      ,'" + super.kaikeiSyori + "' AC_SHR_KBN " + "\n");
		super.sql.append("      ,(SELECT AC_SHR_NM " + "\n");
		super.sql.append("        FROM   M_AC_SHR_KBN " + "\n");
		super.sql.append("        WHERE  AC_SHR_KBN = '" + super.kaikeiSyori + "' " + "\n");
		super.sql.append("        AND    M_AC_SHR_KBN.CTSHK_FLG = KB.CTSHK_FLG) AC_SHR_KBN_NM " + "\n");
		super.sql.append("      ,KB.RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("      ,TNKI_HOHO_KBN " + "\n");
		super.sql.append("      ,TO_CHAR(SYSDATE, 'YYYYMMDD') CREATE_DATE " + "\n");
		super.sql.append("      ,START_YMD " + "\n");
		super.sql.append("      ,END_YMD " + "\n");
		if (commonBean.isShowKaiKnoOpt()) {
			if (super.kaiknoTermkei.equals("0")) {
				super.sql.append("      ,DECODE(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN,'3',DECODE(KAI_FNO_YMD,KB.KNSHU_YMD,'',KAI_FNO_YMD),'') KAI_FNO_YMD" + "\n");
			}
			else {
				super.sql.append("      ,'' KAI_FNO_YMD " + "\n");
			}
		}
		else {
			super.sql.append("      ,'' KAI_FNO_YMD " + "\n");
		}
	
		/*
		 * super.sql.append(" ,NEXT_START_YMD " + "\n"); super.sql.append(" ,NEXT_END_YMD " + "\n"); super.sql.append(" ,OVER_NEXT_END_YMD " + "\n"); super.sql.append(" ,START_KEIJ_YM " + "\n"); super.sql.append(" ,END_KEIJ_YM " + "\n"); super.sql.append(" ,NEXT_START_KEIJ_YM " + "\n"); super.sql.append(" ,NEXT_END_KEIJ_YM " + "\n"); super.sql.append(" ,OVER_NEXT_START_KEIJ_YM " + "\n"); super.sql.append(" ,KAI_START_KEIJ_YM " + "\n"); super.sql.append(" ,MRYO_KEIJ_YM " + "\n"); super.sql.append(" ,FKN_KEIJ_YM_MAX " + "\n");
		 */
		super.sql.append("FROM   (" + super.getCoreSQL() + ") KB " + "\n");
		super.sql.append("LEFT   JOIN M_LC M_LC ON M_LC.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("LEFT   JOIN M_TRD_HNTE_KEKA_KBN TRD_HNTE_KEKA_KBN ON TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN = KB.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("LEFT   JOIN M_SSN_SRI SSN_SRI ON SSN_SRI.SSN_SRI_CD = KB.SSN_SRI_CD " + "\n");
		super.sql.append("LEFT   JOIN M_RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN ON RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN = KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("LEFT   JOIN M_LU LU ON LU.LU_COSMOS_CD = KB.LU_COSMOS_CD " + "\n");
		super.sql.append("LEFT   JOIN M_FKN_TNKI_HOHO_CD FKN_TNKI_HOHO_CD ON FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_CD = KB.TNKI_HOHO_KBN " + "\n");
		if (commonBean.isShowKaiKnoOpt() && super.kaiknoTermkei.equals("0")) {
			super.sql.append("WHERE  (KB.TRD_HNTE_KEKA_KBN IN ('1', '2') OR (KB.TRD_HNTE_KEKA_KBN = '3' AND KB.CYT_KAI_KANO_KBN = '0' AND KB.START_YMD <= KB.KAI_FNO_YMD ) ) " + "\n");
		}
		else {
			super.sql.append("WHERE  (KB.TRD_HNTE_KEKA_KBN IN ('1', '2') OR (KB.TRD_HNTE_KEKA_KBN = '3' AND KB.CYT_KAI_KANO_KBN = '0') ) " + "\n");
		}
		super.sql.append("AND    ((KB.KNSHU_YMD <> NVL(KB.KAI_YMD,'A') " + "\n");
		super.sql.append("    AND ((KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD) OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD))) " + "\n");
		super.sql.append("    OR  (KB.KNSHU_YMD = KB.KAI_YMD AND KB.START_YMD <= KB.KNSHU_YMD)" + "\n");
		super.sql.append("  OR  (KB.START_YMD = NVL(KB.KAI_YMD,'0')))" + "\n");
		super.sql.append("AND    KB.KNSHU_YMD <= KB.END_YMD " + "\n");
		super.sql.append("AND    KB.TAISHO_AC_KIJYUN_CD = '" + super.acStd + "' " + "\n");
		super.sql.append("AND    KB.LU_COSMOS_CD = '" + this.leasCompanyCode + "' " + "\n"); // リースユーザ

		if (this.keiyakuNo.trim().length() > 0) {
			super.sql.append("AND    KB.HYJYO_KEI_NO = '" + this.keiyakuNo + "' " + "\n"); // 契約番号
		}

		if (this.bukkenNo.trim().length() > 0) {
			super.sql.append("AND    KB.BKN_NO || CASE WHEN TRIM(KB.BKN_EDANO) IS NULL THEN '' ELSE '-' || KB.BKN_EDANO END = '" + this.bukkenNo + "' " + "\n"); // 物件番号
		}

		// 抽出条件-旧会計基準
		if (super.acStd.equals(LACSDefine.AccountStandard.OLD_0)) {
			if (super.oldkeiyakuGaku.equals("0")) {
				super.sql.append("  AND    ((KB.SGK_SSN_KBN IS NULL AND KB.KEI_AMT_KEI > 3000000) " + "\n"); // 契約金額３００万円以下(KEI_AMTは物件から取得しているためKEI_AMT_KEIを使用)
				super.sql.append("      OR   (KB.SGK_SSN_KBN IS NOT NULL AND KB.SGK_SSN_KBN = '0')) " + "\n");
			}

			if (super.oldleaseKikan.equals("0")) {
				super.sql.append("  AND KB.KEI_TERM >= 12 " + "\n"); // リース期間１年未満
			}

			if (super.oldsaiLease.equals("0")) {
				super.sql.append("  AND KB.RLS_TMS = 0" + "\n"); // 再リース契約
			}

			if (super.oldtyutoKaiyaku.equals("0")) {
				super.sql.append("  AND KB.KAI_YMD IS NULL" + "\n"); // 中途解約物件
			}

			if ("1".equals(super.commonBean.getControlGokeiDsp())) {
				super.sql.append("  AND CTSHK_FLG = '1'" + "\n"); // 注記合計表表示制御
			}
		}
		// 抽出条件-新会計基準
		if (super.acStd.equals(LACSDefine.AccountStandard.NEW_1)) {
			if (super.newkeiyakuGaku.equals("0")) {
				super.sql.append("  AND    ((KB.SGK_SSN_KBN IS NULL AND KB.KEI_AMT_KEI > 3000000) " + "\n"); // 契約金額３００万円以下(KEI_AMTは物件から取得しているためKEI_AMT_KEIを使用)
				super.sql.append("      OR   (KB.SGK_SSN_KBN IS NOT NULL AND KB.SGK_SSN_KBN = '0')) " + "\n");
			}

			if (super.newleaseKikan.equals("0")) {
				super.sql.append("  AND KB.KEI_TERM > 12 " + "\n"); // リース期間１年以内
			}

			if (super.newsaiLease.equals("0")) {
				super.sql.append("  AND KB.RLS_TMS = 0" + "\n"); // 再リース契約
			}

			if (super.newtyutoKaiyaku.equals("0")) {
				super.sql.append("  AND KB.KAI_YMD IS NULL" + "\n"); // 中途解約物件
			}
		}

		super.sql.append("ORDER  BY KB.LC_CD " + "\n");
		// 2020/05/22 ADD START
		super.sql.append("         ,KB.JYSI_UM " + "\n");
		// 2020/05/22 ADD END
		super.sql.append("         ,KB.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("         ,KB.CTSHK_FLG " + "\n");
		super.sql.append("         ,KB.SSN_SRI_CD " + "\n");
		super.sql.append("         ,KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("         ,KB.TNKI_HOHO_KBN " + "\n");
		super.sql.append("         ,KB.HYJYO_KEI_NO " + "\n");
		super.sql.append("         ,KB.BKN_NO " + "\n");
		super.sql.append("         ,KB.BKN_EDANO " + "\n");
		super.sql.append("         ,KB.KEI_NO " + "\n");
		
		System.out.println(super.sql);

	}

	/**
	 * ブレイクキー０を取得.
	 * 
	 * @return ブレイクキー０
	 */
	public String getBrakeKey0() {
		return super.getString("BRAKE_KEY0");
	}

	/**
	 * ブレイクキー１を取得.
	 * 
	 * @return ブレイクキー１
	 */
	public String getBrakeKey1() {
		return super.getString("BRAKE_KEY1");
	}

	/**
	 * ブレイクキー２を取得.
	 * 
	 * @return ブレイクキー２
	 */
	public String getBrakeKey2() {
		return super.getString("BRAKE_KEY2");
	}

	/**
	 * ブレイクキー３を取得.
	 * 
	 * @return ブレイクキー３
	 */
	public String getBrakeKey3() {
		return super.getString("BRAKE_KEY3");
	}

	/**
	 * ブレイクキー４を取得.
	 * 
	 * @return ブレイクキー４
	 */
	public String getBrakeKey4() {
		return super.getString("BRAKE_KEY4");
	}

	/**
	 * ブレイクキー５を取得.
	 * 
	 * @return ブレイクキー５
	 */
	public String getBrakeKey5() {
		return super.getString("BRAKE_KEY5");
	}
	// 2020/05/22 ADD START
	/**
	 * ブレイクキー０_1を取得.
	 * 
	 * @return ブレイクキー０_1
	 */
	public String getBrakeKey0_1() {
		return super.getString("BRAKE_KEY0_1");
	}

	/**
	 * 重要性有無を取得.
	 * 
	 * @return 重要性有無
	 */
	public String getJysiUm() {
		return super.getString("JYSI_UM");
	}	
	// 2020/05/22 ADD END

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
	 * 固定資産科目を取得.
	 * 
	 * @return 固定資産科目
	 */
	public String getKoteiSisanKamoku() {
		return super.getString("SSN_SRI_NM");
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
	 * 当期支払リース料計算基準を取得.
	 * 
	 * @return 当期支払リース料計算基準
	 */
	public String getToukiReaseRyouKeisanKijyun() {
		return super.getString("FKN_TNKI_HOHO_NM");
	}

	/**
	 * 未経過リース料等計算基準を取得.
	 * 
	 * @return 未経過リース料等計算基準
	 */
	public String getMikeikaReaseRyouKeisanKijyun() {
		return super.getString("FKN_TNKI_HOHO_NM");
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
	 * 中途解約日を取得.
	 * 
	 * @return 中途解約日
	 */
	public String getKaiyakuYmd() {
		return super.getString("KAI_YMD");
	}

	/**
	 * 計算利子率を取得.
	 * 
	 * @return 計算利子率
	 */
	public String getKeisanRisiRitu() {
		return super.getString("RSK_CLC_RS_RT");
	}

	/**
	 * リース料総額を取得.
	 * 
	 * @return リース料総額
	 */
	public long getLeaseSougaku() {
		return super.getLong("KEI_AMT");
	}

	/**
	 * 取得価格相当額を取得.
	 * 
	 * @return 取得価格相当額
	 */
	public long getSyutokuKakakuSoutou() {
		return super.getLong("KNU_AMT");
	}

	/**
	 * 維持管理費相当額を取得.
	 * 
	 * @return 維持管理費相当額
	 */
	public long getIjikanriHi() {
		return super.getLong("IJI_KANRIHI");
	}

	/**
	 * 役務提供費を取得.
	 * 
	 * @return 役務提供費相当額
	 */
	public long getEkmteik() {
		return super.getLong("EKM_TEIK");
	}

	/**
	 * 残価保証額を取得.
	 * 
	 * @return 残価保証額
	 */
	public long getZanHosyou() {
		return super.getLong("ZANK_HSHO_AMT");
	}

	/**
	 * 当期支払リース料を取得.
	 * 
	 * @return 当期支払リース料
	 */
	public long getToukSiharaiLeaseRyou() {
		return super.getLong("LAMT");
	}

	/**
	 * 当期維持管理費を取得.
	 * 
	 * @return 当期維持管理費
	 */
	public long getToukiIjiKanriHi() {
		return super.getLong("TOUKI_IJI_KANRIHI");
	}

	/**
	 * 当期役務提供費を取得.
	 * 
	 * @return 当期役務提供費相当額
	 */
	public long getToukiEkmteik() {
		return super.getLong("TOUKI_EKM_TEIK");
	}

	/**
	 * 支払利息相当額を取得.
	 * 
	 * @return 支払利息相当額
	 */
	public long getSiharaiRisoku() {
		return super.getLong("SIHARAI_RSK");
	}

	/**
	 * リース債務相当額を取得.
	 * 
	 * @return リース債務相当額
	 */
	public long getLeaseSaimuHensaiGaku() {
		return super.getLong("LEASE_SAIMU");
	}

	/**
	 * 期末残高相当額を取得.
	 * 
	 * @return 期末残高相当額
	 */
	public long getMikeikaKimatuZan() {
		return super.getLong("KIMATU_ZAN");
	}

	/**
	 * 期末残高相当額（内１年内）を取得.
	 * 
	 * @return 期末残高相当額（内１年内）
	 */
	public long getMikeikaKimatuZan1Nai() {
		return super.getLong("KIMATU_ZAN_1NAI");
	}

	/**
	 * 期末残高相当額（内１年超）を取得.
	 * 
	 * @return 期末残高相当額（内１年超）
	 */
	public long getMikeikaKimatuZan1Cyo() {
		return super.getLong("KIMATU_ZAN_1CYO");
	}

	/**
	 * リース会社を取得.
	 * 
	 * @return リース会社
	 */
	public String getLeasCompanyNm() {
		return super.getString("LEASE_COMPANY");
	}

	/**
	 * リースユーザを取得.
	 * 
	 * @return リースユーザ
	 */
	public String getLeasUserNm() {
		return super.getString("LEASE_USER");
	}

	/**
	 * 会計処理方法を取得.
	 * 
	 * @return 会計処理方法
	 */
	public String getAcShrKbnName() {
		return super.getString("AC_SHR_KBN_NM");
	}

	/**
	 * 解約不能期間リース終了日を取得.
	 * 
	 * @return 解約不能期間リース終了日
	 */
	public String getKaiFunoYMD() {
		return super.getString("KAI_FNO_YMD");
	}
	
	
}
