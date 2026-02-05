package jp.co.pro_app.lacs.affairs.report.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 帳票出力：リース会計資料（減価償却費）Entity.
 * 
 * @author ohmura
 * @version 20070828
 */
public class LACSReportGenkaEntity extends LACSReportEntityBase {

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
	public LACSReportGenkaEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSReportBean piReportBean, String piAcStd) {
		super(piModel, piCommonBean, piReportBean, piAcStd);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT RPAD(KB.LU_COSMOS_CD, 10, ' ') BRAKE_KEY0 " + "\n");
		// 2020/05/22 REP START
		// DEL super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') BRAKE_KEY1 " + "\n");
		// DEL super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG, 1, ' ') BRAKE_KEY2 " + "\n");
		// DEL super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG, 1, ' ') || RPAD(KB.SSN_SRI_CD, 1, ' ') BRAKE_KEY3 " + "\n");
		// DEL super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG, 1, ' ') || RPAD(KB.SSN_SRI_CD, 1, ' ') || RPAD(KB.SKK_KEIJ_HOHO_KBN, 3, ' ') BRAKE_KEY4 " + "\n");
		super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') BRAKE_KEY0_1 " + "\n");
		super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') BRAKE_KEY1 " + "\n");
		super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG, 1, ' ') BRAKE_KEY2 " + "\n");
		super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG, 1, ' ') || RPAD(KB.SSN_SRI_CD, 1, ' ') BRAKE_KEY3 " + "\n");
		super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG, 1, ' ') || RPAD(KB.SSN_SRI_CD, 1, ' ') || RPAD(KB.SKK_KEIJ_HOHO_KBN, 3, ' ') BRAKE_KEY4 " + "\n");
		// 2020/05/22 REP END
		super.sql.append("      ,DECODE(M_LU.PDF_COMPANY_NM, NULL, M_LC.LC_NM,M_LU.PDF_COMPANY_NM) LEASE_COMPANY " + "\n");
		super.sql.append("      ,M_LU.LU_NM LEASE_USER " + "\n");
		// 2020/05/22 REP START
		super.sql.append("      ,CASE WHEN KB.JYSI_UM = '1' THEN 'あり' ELSE 'なし' END JYSI_UM " + "\n");
		// 2020/05/22 REP END
		super.sql.append("      ,M_TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_NM LEASE_BUNRUI " + "\n");
		super.sql.append("      ,M_SSN_SRI.SSN_SRI_NM " + "\n");
		super.sql.append("      ,M_SKK_KEIJ_HOHO_KBN.SKK_HOHO_NM " + "\n");
		super.sql.append("      ,KB.HYJYO_KEI_NO KEI_NO " + "\n");
		super.sql.append("      ,KB.KNSHU_YMD " + "\n");
		super.sql.append("      ,KB.MRYO_YMD " + "\n");
		super.sql.append("      ,KB.BKN_NO || CASE " + "\n");
		super.sql.append("           WHEN TRIM(KB.BKN_EDANO) IS NULL THEN " + "\n");
		super.sql.append("            '' " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("            '-' || KB.BKN_EDANO " + "\n");
		super.sql.append("       END BKN_NO " + "\n");
		super.sql.append("      ,KB.BKN_NM " + "\n");
		super.sql.append("      ,KB.KAI_YMD " + "\n");
		super.sql.append("      ,KB.KEI_TERM " + "\n");
		super.sql.append("      ,KB.TY_YSU " + "\n");
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("           WHEN M_LC.KIMATSU_AMT_OUT_CTL = 0 AND (KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND GNKSK_LAST_YMD <= END_YMD)) THEN " + "\n");
		super.sql.append("               0 " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("               CASE KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                   WHEN '101' THEN " + "\n");
		super.sql.append("                       LEAST(KB.MBRI_WRBK_PV, KB.KNU_AMT) " + "\n");
		super.sql.append("                   WHEN '201' THEN " + "\n");
		super.sql.append("                       KB.KEI_AMT " + "\n");
		super.sql.append("                     + CASE " + "\n");
		super.sql.append("                           WHEN KB.LU_TRSK_CD IN (KB.IPN_ZANK_HSHOSK_CD, KB.ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("                               KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("                           ELSE " + "\n");
		super.sql.append("                               0 " + "\n");
		super.sql.append("                       END " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       LEAST(KB.ABRI_WRBK_PV, KB.KNU_AMT) " + "\n");
		super.sql.append("              END " + "\n");
		super.sql.append("       END KNU_AMT " + "\n");
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("           WHEN M_LC.KIMATSU_AMT_OUT_CTL = 0 AND (KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND GNKSK_LAST_YMD <= END_YMD)) THEN " + "\n");
		super.sql.append("               0 " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("               CASE " + "\n");
		super.sql.append("                   WHEN KB.LU_TRSK_CD IN (KB.IPN_ZANK_HSHOSK_CD, KB.ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("                       KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("       END ZANK_HSHO_AMT " + "\n");
		super.sql.append("      ,NVL((SELECT SUM(TGTU_SKK_AMT) TGTU_SKK_AMT " + "\n");
		super.sql.append("            FROM   T_UKB_GNKSK G " + "\n");
		super.sql.append("            WHERE  G.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("            AND    G.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("            AND    G.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("            AND    G.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("            AND    G.KEIJ_HOHO_KBN = KB.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("            AND    G.KEIJ_YM BETWEEN START_KEIJ_YM AND GNKSK_KEIJ_YM_LAST) " + "\n");
		super.sql.append("          + CASE " + "\n");
		super.sql.append("                WHEN (KB.KAI_YMD IS NULL AND KB.GNKSK_KEIJ_YM_MAX <= END_KEIJ_YM) " + "\n");
		super.sql.append("                AND KB.LU_TRSK_CD IN (KB.IPN_ZANK_HSHOSK_CD, KB.ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("                    KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("                ELSE " + "\n");
		super.sql.append("                    0 " + "\n");
		super.sql.append("           END, 0) TGTU_SKK_AMT " + "\n");
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("           WHEN M_LC.KIMATSU_AMT_OUT_CTL = 0 AND (KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND GNKSK_LAST_YMD <= END_YMD)) THEN " + "\n");
		super.sql.append("               0 " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("            (SELECT RUI_SKK_AMT " + "\n");
		super.sql.append("             FROM   T_UKB_GNKSK G " + "\n");
		super.sql.append("             WHERE  G.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("             AND    G.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("             AND    G.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("             AND    G.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("             AND    G.KEIJ_HOHO_KBN = KB.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("             AND    G.KEIJ_YM = LEAST(GNKSK_KEIJ_YM_LAST,GNKSK_KEIJ_YM_MAX)) " + "\n");
		super.sql.append("           + CASE " + "\n");
		super.sql.append("                WHEN (KB.KAI_YMD IS NULL AND KB.GNKSK_KEIJ_YM_MAX <= END_KEIJ_YM) " + "\n");
		super.sql.append("                 AND KB.LU_TRSK_CD IN (KB.IPN_ZANK_HSHOSK_CD, KB.ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("                     KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("                 ELSE " + "\n");
		super.sql.append("                     0 " + "\n");
		super.sql.append("             END " + "\n");
		super.sql.append("       END RUI_SKK_AMT " + "\n");
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("           WHEN KB.KNSHU_YMD = KB.KAI_YMD THEN " + "\n");
		super.sql.append("               CASE " + "\n");
		super.sql.append("                   WHEN M_LC.KIMATSU_AMT_OUT_CTL = 0 AND (KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND GNKSK_LAST_YMD <= END_YMD)) THEN " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       CASE KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                           WHEN '101' THEN " + "\n");
		super.sql.append("                               LEAST(KB.MBRI_WRBK_PV, KB.KNU_AMT) " + "\n");
		super.sql.append("                           WHEN '201' THEN " + "\n");
		super.sql.append("                               KB.KEI_AMT " + "\n");
		super.sql.append("                             + CASE " + "\n");
		super.sql.append("                                   WHEN KB.LU_TRSK_CD IN (KB.IPN_ZANK_HSHOSK_CD, KB.ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("                                       KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("                                   ELSE " + "\n");
		super.sql.append("                                       0 " + "\n");
		super.sql.append("                               END " + "\n");
		super.sql.append("                           ELSE " + "\n");
		super.sql.append("                               LEAST(KB.ABRI_WRBK_PV, KB.KNU_AMT) " + "\n");
		super.sql.append("                       END " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("               CASE " + "\n");
		super.sql.append("                   WHEN M_LC.KIMATSU_AMT_OUT_CTL = 0 AND (KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND GNKSK_LAST_YMD <= END_YMD)) THEN " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       CASE WHEN KB.KAI_YMD BETWEEN KB.START_YMD AND KB.END_YMD THEN " + "\n");
		super.sql.append("                                NVL((SELECT KAI_SISAN_BOKA " + "\n");
		super.sql.append("                                             /* + CASE " + "\n");
		super.sql.append("                                                    WHEN (KB.KAI_YMD IS NULL AND KB.GNKSK_KEIJ_YM_MAX <= END_KEIJ_YM) THEN " + "\n");
		super.sql.append("                                                        0 " + "\n");
		super.sql.append("                                                    WHEN KB.LU_TRSK_CD IN (KB.ZANK_HSHOSK_CD, KB.IPN_ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("                                                        KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("                                                    ELSE " + "\n");
		super.sql.append("                                                        0 " + "\n");
		super.sql.append("                                                END*/ " + "\n");
		super.sql.append("                                     FROM   T_UKB_GNKSK G " + "\n");
		super.sql.append("                                     WHERE  G.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("                                     AND    G.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("                                     AND    G.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("                                     AND    G.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("                                     AND    G.KEIJ_HOHO_KBN = KB.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                                     AND    G.KEIJ_YM = GNKSK_KEIJ_YM_MAX), 0) " + "\n");
		super.sql.append("                            ELSE " + "\n");
		super.sql.append("                                NVL((SELECT SUM(CASE WHEN G.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN G.TGTU_SKK_AMT " + "\n");
		super.sql.append("							    	                   ELSE G.YTE_TGTU_SKK_AMT " + "\n");
		super.sql.append("							                      END) " + "\n");
		super.sql.append("                                              + CASE " + "\n");
		super.sql.append("                                                    WHEN (KB.KAI_YMD IS NULL AND KB.GNKSK_KEIJ_YM_MAX <= END_KEIJ_YM) THEN " + "\n");
		super.sql.append("                                                        0 " + "\n");
		super.sql.append("                                                    WHEN KB.LU_TRSK_CD IN (KB.ZANK_HSHOSK_CD, KB.IPN_ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("                                                        KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("                                                    ELSE " + "\n");
		super.sql.append("                                                        0 " + "\n");
		super.sql.append("                                                END " + "\n");
		super.sql.append("                                     FROM   T_UKB_GNKSK G " + "\n");
		super.sql.append("                                     WHERE  G.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("                                     AND    G.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("                                     AND    G.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("                                     AND    G.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("                                     AND    G.KEIJ_HOHO_KBN = KB.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                                     AND    G.KEIJ_YM > END_KEIJ_YM), 0) " + "\n");
		super.sql.append("                       END " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("       END ZAND_SKK_AMT " + "\n");
		super.sql.append("      ,KB.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("      ,KB.SSN_SRI_CD " + "\n");
		super.sql.append("      ,'" + this.kaikeiSyori + "' AC_SHR_KBN " + "\n");
		super.sql.append("      ,(SELECT AC_SHR_NM " + "\n");
		super.sql.append("        FROM   M_AC_SHR_KBN " + "\n");
		super.sql.append("        WHERE  AC_SHR_KBN = '" + this.kaikeiSyori + "' " + "\n");
		super.sql.append("        AND    M_AC_SHR_KBN.CTSHK_FLG = KB.CTSHK_FLG) AC_SHR_KBN_NM " + "\n");
		super.sql.append("      ,KB.SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("      ,TO_CHAR(SYSDATE, 'YYYYMMDD') CREATE_DATE " + "\n");
		super.sql.append("      ,KB.START_YMD " + "\n");
		super.sql.append("      ,KB.END_YMD " + "\n");
		/*
		 * super.sql.append(" ,KB.NEXT_START_YMD " + "\n"); super.sql.append(" ,KB.NEXT_END_YMD " + "\n"); super.sql.append(" ,KB.OVER_NEXT_END_YMD " + "\n"); super.sql.append(" ,KB.START_KEIJ_YM " + "\n"); super.sql.append(" ,KB.END_KEIJ_YM " + "\n"); super.sql.append(" ,KB.NEXT_START_KEIJ_YM " + "\n"); super.sql.append(" ,KB.NEXT_END_KEIJ_YM " + "\n"); super.sql.append(" ,KB.OVER_NEXT_START_KEIJ_YM " + "\n"); super.sql.append(" ,GNKSK_KEIJ_YM_MAX " + "\n");
		 */
		super.sql.append("      ,CASE KB.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("           WHEN '221' THEN NULL " + "\n");
		super.sql.append("           WHEN '222' THEN NULL " + "\n");
		super.sql.append("           WHEN '223' THEN NULL " + "\n");
		super.sql.append("           ELSE " + "\n");

		if ("1".equals(super.commonBean.getShowTyukiComment())) {
			super.sql.append("      		DECODE(M_LU." + this.prefix + "MBRI_ABRI_KBN, '0', KB.MBRI_WRBK_CLC_RS_RT, KB.ABRI_WRBK_CLC_RS_RT) " + "\n");
		}
		else {
			super.sql.append("      		NULL " + "\n");
		}

		super.sql.append("       END WRBK_CLC_RS_RT " + "\n");
		super.sql.append("FROM   (" + super.getCoreSQL() + ") KB " + "\n");
		super.sql.append("JOIN   M_LC ON M_LC.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("JOIN   M_LU ON KB.LU_COSMOS_CD = M_LU.LU_COSMOS_CD " + "\n");
		super.sql.append("JOIN   M_TRD_HNTE_KEKA_KBN ON KB.TRD_HNTE_KEKA_KBN = M_TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("JOIN   M_SSN_SRI ON KB.SSN_SRI_CD = M_SSN_SRI.SSN_SRI_CD " + "\n");
		super.sql.append("JOIN   M_SKK_KEIJ_HOHO_KBN ON KB.SKK_KEIJ_HOHO_KBN = M_SKK_KEIJ_HOHO_KBN.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("WHERE  KB.TRD_HNTE_KEKA_KBN IN ('1', '2') " + "\n");
		super.sql.append("AND    ((KB.KNSHU_YMD <> NVL(KB.KAI_YMD,'A') " + "\n");

		//20140919 REP START
		super.sql.append("    AND ((KAI_YMD IS NULL AND KB.START_YMD <= GREATEST(KB.MRYO_YMD,  NVL2(KB.GNKSK_KEIJ_YM_MAX,KB.GNKSK_KEIJ_YM_MAX || '99',KB.MRYO_YMD))) OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD))) " + "\n");
		//super.sql.append("    AND ((KAI_YMD IS NULL AND KB.START_YMD <= GREATEST(KB.MRYO_YMD, KB.GNKSK_KEIJ_YM_MAX || '99')) OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD))) " + "\n");
		//20140919 REP END
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
		super.sql.append("         ,KB.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("         ,KB.HYJYO_KEI_NO " + "\n");
		super.sql.append("         ,KB.BKN_NO " + "\n");
		super.sql.append("         ,KB.BKN_EDANO " + "\n");
		super.sql.append("         ,KB.KEI_NO " + "\n");
		
		//System.out.print(super.sql);
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
	 * 減価償却方法を取得.
	 * 
	 * @return 減価償却方法
	 */
	public String getGenkaSyoukyakuHohou() {
		return super.getString("SKK_HOHO_NM");
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
	 * リース期間を取得.
	 * 
	 * @return リース期間
	 */
	public String getLeaseTerm() {
		return super.getString("KEI_TERM");
	}

	/**
	 * 耐用年数を取得.
	 * 
	 * @return 耐用年数
	 */
	public String getTaiyouNensu() {
		return super.getString("TY_YSU");
	}

	/**
	 * 取得価額相当額を取得.
	 * 
	 * @return 取得価額相当額
	 */
	public long getSyutokuKakaku() {
		return super.getLong("KNU_AMT");
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
	 * 当期減価償却費を取得.
	 * 
	 * @return 当期減価償却費
	 */
	public long getToukiGenkasyokyaku() {
		return super.getLong("TGTU_SKK_AMT");
	}

	/**
	 * 減価償却累計額を取得.
	 * 
	 * @return 減価償却累計額
	 */
	public long getGenkasyoukyakuRuikei() {
		return super.getLong("RUI_SKK_AMT");
	}

	/**
	 * 期末残高相当額を取得.
	 * 
	 * @return 期末残高相当額
	 */
	public long getKimatuZan() {
		return super.getLong("ZAND_SKK_AMT");
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
	 * 割引計算利子率を取得.
	 * 
	 * @return 割引計算利子率
	 */
	public String getWaribikiKeisanRisiRitu() {
		return super.getString("WRBK_CLC_RS_RT");
	}

}
