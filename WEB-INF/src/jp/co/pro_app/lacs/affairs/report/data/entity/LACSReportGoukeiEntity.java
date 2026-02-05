package jp.co.pro_app.lacs.affairs.report.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 帳票出力：リース会計注記合計表Entity.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSReportGoukeiEntity extends LACSReportEntityBase {

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
	public LACSReportGoukeiEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSReportBean piReportBean, String piAcStd) {
		super(piModel, piCommonBean, piReportBean, piAcStd);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql = new StringBuffer();

		super.sql.append("SELECT LU_COSMOS_CD " + "\n");
		super.sql.append("      ,LU_NM " + "\n");
		super.sql.append("      ,LC_NM " + "\n");
		super.sql.append("      ,ITNGI_YUKEI_SKK_HOHO_CD " + "\n");
		super.sql.append("      ,ITNGI_MUKEI_SKK_HOHO_CD " + "\n");
		super.sql.append("      ,RSK_CLC_HOHO_CD " + "\n");
		super.sql.append("      ,KAIKEI_SHYORI " + "\n");
		super.sql.append("      ,START_YMD " + "\n");
		super.sql.append("      ,END_YMD " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '1', KNU_AMT, 0)), 0) SYUTOKU01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '2', KNU_AMT, 0)), 0) SYUTOKU02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '3', KNU_AMT, 0)), 0) SYUTOKU03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '4', KNU_AMT, 0)), 0) SYUTOKU04 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '5', KNU_AMT, 0)), 0) SYUTOKU05 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '6', KNU_AMT, 0)), 0) SYUTOKU06 " + "\n");
		// super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', KNU_AMT, 0)), 0) SYUTOKU07 " + "\n"); //2020/05/22 DEL
		// 2020/05/22 ADD START
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '7', KNU_AMT, 0)), 0) SYUTOKU07 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '8', KNU_AMT, 0)), 0) SYUTOKU08 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', KNU_AMT, 0)), 0) SYUTOKU09 " + "\n");
		// 2020/05/22 ADD END
		super.sql.append("      ,NVL(SUM(KNU_AMT), 0) SYUTOKU_TOTAL " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '1', RUI_SKK_AMT, 0)), 0) GENKA01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '2', RUI_SKK_AMT, 0)), 0) GENKA02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '3', RUI_SKK_AMT, 0)), 0) GENKA03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '4', RUI_SKK_AMT, 0)), 0) GENKA04 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '5', RUI_SKK_AMT, 0)), 0) GENKA05 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '6', RUI_SKK_AMT, 0)), 0) GENKA06 " + "\n");
		// super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', RUI_SKK_AMT, 0)), 0) GENKA07 " + "\n"); //2020/05/22 DEL
		// 2020/05/22 ADD START
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '7', RUI_SKK_AMT, 0)), 0) GENKA07 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '8', RUI_SKK_AMT, 0)), 0) GENKA08 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', RUI_SKK_AMT, 0)), 0) GENKA09 " + "\n");
		// 2020/05/22 ADD END
		super.sql.append("      ,NVL(SUM(RUI_SKK_AMT), 0) GENKA_TOTAL " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '1', ZAND_SKK_AMT, 0)), 0) ZANDAKA01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '2', ZAND_SKK_AMT, 0)), 0) ZANDAKA02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '3', ZAND_SKK_AMT, 0)), 0) ZANDAKA03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '4', ZAND_SKK_AMT, 0)), 0) ZANDAKA04 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '5', ZAND_SKK_AMT, 0)), 0) ZANDAKA05 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '6', ZAND_SKK_AMT, 0)), 0) ZANDAKA06 " + "\n");
		//super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', ZAND_SKK_AMT, 0)), 0) ZANDAKA07 " + "\n"); //2020/05/22 DEL
		// 2020/05/22 ADD START
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '7', ZAND_SKK_AMT, 0)), 0) ZANDAKA07 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '8', ZAND_SKK_AMT, 0)), 0) ZANDAKA08 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', ZAND_SKK_AMT, 0)), 0) ZANDAKA09 " + "\n");
		// 2020/05/22 ADD END
		super.sql.append("      ,NVL(SUM(ZAND_SKK_AMT), 0) ZANDAKA_TOTAL " + "\n");
		super.sql.append("      ,NVL(SUM(MIKEIKA_ZAN01), 0) MIKEIKA_ZAN01 " + "\n");
		super.sql.append("      ,NVL(SUM(MIKEIKA_ZAN02), 0) MIKEIKA_ZAN02 " + "\n");
		super.sql.append("      ,NVL(SUM(MIKEIKA_ZAN01), 0) + NVL(SUM(MIKEIKA_ZAN02), 0) MIKEIKA_ZAN03 " + "\n");
		super.sql.append("      ,NVL(SUM(TOUKI_SIHARAI), 0) TOUKI_SIHARAI " + "\n");
		super.sql.append("      ,NVL(SUM(TOUKI_GENKA), 0) TOUKI_GENKA " + "\n");
		super.sql.append("      ,NVL(SUM(TOUKI_RISOKU), 0) TOUKI_RISOKU " + "\n");
		super.sql.append("      ,NVL(SUM(MIKEIKA01), 0) MIKEIKA01 " + "\n");
		super.sql.append("      ,NVL(SUM(MIKEIKA02), 0) MIKEIKA02 " + "\n");
		super.sql.append("      ,NVL(SUM(MIKEIKA01), 0) + NVL(SUM(MIKEIKA02), 0) MIKEIKA03 " + "\n");
		super.sql.append("      ,MAX(TO_CHAR(SYSDATE, 'YYYYMMDD')) CREATE_DATE " + "\n");
		super.sql.append("      ,'" + super.kaikeiSyori + "' AC_SHR_KBN " + "\n");
		super.sql.append("FROM   (SELECT KB.LC_CD " + "\n");
		super.sql.append("              ,KB.KEI_NO " + "\n");
		super.sql.append("              ,KB.KNSHU_YMD " + "\n");
		super.sql.append("              ,KB.MRYO_YMD " + "\n");
		super.sql.append("              ,KB.KAI_YMD " + "\n");
		super.sql.append("              ,KB.START_YMD " + "\n");
		super.sql.append("              ,KB.END_YMD " + "\n");
		super.sql.append("              ,KB.NEXT_START_YMD " + "\n");
		super.sql.append("              ,KB.NEXT_END_YMD " + "\n");
		super.sql.append("              ,KB.OVER_NEXT_START_KEIJ_YM " + "\n");
		super.sql.append("              ,KB.START_KEIJ_YM " + "\n");
		super.sql.append("              ,KB.END_KEIJ_YM " + "\n");
		super.sql.append("              ,KB.NEXT_START_KEIJ_YM " + "\n");
		super.sql.append("              ,KB.NEXT_END_KEIJ_YM " + "\n");
		super.sql.append("              ,KB.OVER_NEXT_START_KEIJ_YM " + "\n");
		super.sql.append("              ,KB.KAI_START_KEIJ_YM " + "\n");
		super.sql.append("              ,KB.BKN_EDANO " + "\n");
		super.sql.append("              ,KB.SSN_SRI_CD " + "\n");
		super.sql.append("              ,KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("              ,KB.ZANK_HSHOSK_CD " + "\n");
		super.sql.append("              ,KB.IPN_ZANK_HSHOSK_CD " + "\n");
		super.sql.append("              ,KB.RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("              ,KB.SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("              ,CASE " + "\n");
		//20140919 REP START
		super.sql.append("                   WHEN KB.TRD_HNTE_KEKA_KBN = '2' AND (KAI_YMD IS NULL AND KB.START_YMD <= GREATEST(KB.MRYO_YMD, NVL2(KB.GNKSK_KEIJ_YM_MAX,KB.GNKSK_KEIJ_YM_MAX || '99',KB.MRYO_YMD)) OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		//super.sql.append("                   WHEN KB.TRD_HNTE_KEKA_KBN = '2' AND (KAI_YMD IS NULL AND KB.START_YMD <= GREATEST(KB.MRYO_YMD, KB.GNKSK_KEIJ_YM_MAX || '99') OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		//20140919 REP END
		super.sql.append("                       CASE " + "\n");
		super.sql.append("                           WHEN M_LC.KIMATSU_AMT_OUT_CTL = 0 AND (KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND GNKSK_LAST_YMD <= END_YMD)) THEN " + "\n");
		super.sql.append("                               0 " + "\n");
		super.sql.append("                           ELSE " + "\n");
		super.sql.append("                               CASE KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                                   WHEN '101' THEN " + "\n");
		super.sql.append("                                       LEAST(KB.MBRI_WRBK_PV, KB.KNU_AMT) " + "\n");
		super.sql.append("                                   WHEN '201' THEN " + "\n");
		super.sql.append("                                       KB.KEI_AMT " + "\n");
		super.sql.append("                                     + CASE " + "\n");
		super.sql.append("                                           WHEN KB.LU_TRSK_CD IN (KB.IPN_ZANK_HSHOSK_CD, KB.ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("                                               KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("                                           ELSE " + "\n");
		super.sql.append("                                               0 " + "\n");
		super.sql.append("                                       END " + "\n");
		super.sql.append("                                   ELSE " + "\n");
		super.sql.append("                                       LEAST(KB.ABRI_WRBK_PV, KB.KNU_AMT) " + "\n");
		super.sql.append("                              END " + "\n");
		super.sql.append("                       END " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                         0 " + "\n");
		super.sql.append("               END KNU_AMT " + "\n");
		super.sql.append("              ,CASE " + "\n");
		//20140919 REP START
		super.sql.append("                   WHEN KB.TRD_HNTE_KEKA_KBN = '2' AND (KAI_YMD IS NULL AND KB.START_YMD <= GREATEST(KB.MRYO_YMD, NVL2(KB.GNKSK_KEIJ_YM_MAX,KB.GNKSK_KEIJ_YM_MAX || '99',KB.MRYO_YMD)) OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		//super.sql.append("                   WHEN KB.TRD_HNTE_KEKA_KBN = '2' AND (KAI_YMD IS NULL AND KB.START_YMD <= GREATEST(KB.MRYO_YMD, KB.GNKSK_KEIJ_YM_MAX || '99') OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		//20140919 REP END
		super.sql.append("                       CASE " + "\n");
		super.sql.append("                           WHEN M_LC.KIMATSU_AMT_OUT_CTL = 0 AND (KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND GNKSK_LAST_YMD <= END_YMD)) THEN " + "\n");
		super.sql.append("                            0 " + "\n");
		super.sql.append("                           ELSE " + "\n");
		super.sql.append("                            (SELECT RUI_SKK_AMT " + "\n");
		super.sql.append("                             FROM   T_UKB_GNKSK G " + "\n");
		super.sql.append("                             WHERE  G.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("                             AND    G.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("                             AND    G.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("                             AND    G.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("                             AND    G.KEIJ_HOHO_KBN = KB.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                             AND    G.KEIJ_YM = LEAST(GNKSK_KEIJ_YM_LAST, GNKSK_KEIJ_YM_MAX)) " + "\n");
		super.sql.append("                           + CASE " + "\n");
		super.sql.append("                                 WHEN (KB.KAI_YMD IS NULL AND KB.GNKSK_KEIJ_YM_MAX <= END_KEIJ_YM) " + "\n");
		super.sql.append("                                 AND KB.LU_TRSK_CD IN (KB.IPN_ZANK_HSHOSK_CD, KB.ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("                                     KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("                                 ELSE " + "\n");
		super.sql.append("                                     0 " + "\n");
		super.sql.append("                             END " + "\n");
		super.sql.append("                       END " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                         0 " + "\n");
		super.sql.append("               END RUI_SKK_AMT " + "\n");
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("           WHEN KB.TRD_HNTE_KEKA_KBN = '2' AND KB.KNSHU_YMD = KB.KAI_YMD THEN " + "\n");
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
		super.sql.append("                   WHEN KB.TRD_HNTE_KEKA_KBN = '2' AND M_LC.KIMATSU_AMT_OUT_CTL = 0 AND (KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND GNKSK_LAST_YMD <= END_YMD)) THEN " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       CASE WHEN KB.TRD_HNTE_KEKA_KBN = '2' AND KB.KAI_YMD BETWEEN KB.START_YMD AND KB.END_YMD THEN " + "\n");
		super.sql.append("                                NVL((SELECT KAI_SISAN_BOKA " + "\n");
		super.sql.append("                                           /*   + CASE " + "\n");
		super.sql.append("                                                    WHEN (KB.KAI_YMD IS NULL AND KB.GNKSK_KEIJ_YM_GREATEST <= END_KEIJ_YM) THEN " + "\n");
		super.sql.append("                                                        0 " + "\n");
		super.sql.append("                                                    WHEN KB.LU_TRSK_CD IN (KB.ZANK_HSHOSK_CD, KB.IPN_ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("                                                        KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("                                                    ELSE " + "\n");
		super.sql.append("                                                        0 " + "\n");
		super.sql.append("                                                END */ " + "\n");
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
		super.sql.append("                                                    WHEN (KB.KAI_YMD IS NULL AND KB.GNKSK_KEIJ_YM_GREATEST <= END_KEIJ_YM) THEN " + "\n");
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
		super.sql.append("                                     AND    KB.TRD_HNTE_KEKA_KBN = '2' " + "\n");
		super.sql.append("                                     AND    G.KEIJ_YM > END_KEIJ_YM), 0) " + "\n");
		super.sql.append("                       END " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("       END ZAND_SKK_AMT " + "\n");
		super.sql.append("              ,CASE " + "\n");
		super.sql.append("                   WHEN KB.TRD_HNTE_KEKA_KBN = '2' AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("                       CASE " + "\n");
		super.sql.append("                           WHEN KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("                               0 " + "\n");
		super.sql.append("                           ELSE " + "\n");
		super.sql.append("                               (SELECT SUM(CASE WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN FKN_TNKI.TGTU_GNPN " + "\n");
		super.sql.append("								                  ELSE FKN_TNKI.YTE_TGTU_GNPN " + "\n");
		super.sql.append("							                 END) " + "\n");
		super.sql.append("                                FROM   T_UKB_TNKI_DETAIL FKN_TNKI " + "\n");
		super.sql.append("                                WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEIJ_HOHO_KBN = KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEIJ_YM BETWEEN NEXT_START_KEIJ_YM AND NEXT_END_KEIJ_YM) " + "\n");
		super.sql.append("                       END " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("               END MIKEIKA_ZAN01 " + "\n");
		super.sql.append("              ,CASE " + "\n");
		super.sql.append("                   WHEN KB.TRD_HNTE_KEKA_KBN = '2' AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("                       CASE " + "\n");
		super.sql.append("                           WHEN KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("                               0 " + "\n");
		super.sql.append("                           ELSE " + "\n");
		super.sql.append("                               (SELECT SUM(CASE WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN FKN_TNKI.TGTU_GNPN " + "\n");
		super.sql.append("								                  ELSE FKN_TNKI.YTE_TGTU_GNPN " + "\n");
		super.sql.append("							                 END) " + "\n");
		super.sql.append("                                FROM   T_UKB_TNKI_DETAIL FKN_TNKI " + "\n");
		super.sql.append("                                WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEIJ_HOHO_KBN = KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEIJ_YM >= OVER_NEXT_START_KEIJ_YM) " + "\n");
		super.sql.append("                       END " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("               END MIKEIKA_ZAN02 " + "\n");
		super.sql.append("              ,CASE " + "\n");
		//20140919 REP START
		super.sql.append("                   WHEN KB.TRD_HNTE_KEKA_KBN = '2' AND KB.START_YMD <= GREATEST(NVL(TO_CHAR(TO_DATE(KB.KAI_YMD, 'YYYYMMDD') - 1, 'YYYYMMDD'), KB.MRYO_YMD), NVL2(KB.FKN_KEIJ_YM_MAX,KB.FKN_KEIJ_YM_MAX || '99',KB.MRYO_YMD)) THEN " + "\n");
		//super.sql.append("                   WHEN KB.TRD_HNTE_KEKA_KBN = '2' AND KB.START_YMD <= GREATEST(NVL(TO_CHAR(TO_DATE(KB.KAI_YMD, 'YYYYMMDD') - 1, 'YYYYMMDD'), KB.MRYO_YMD), KB.FKN_KEIJ_YM_MAX || '99') THEN " + "\n");
		//20140919 REP END
		super.sql.append("                       (SELECT SUM(FKN_TNKI.LAMT) " + "\n");
		super.sql.append("                      - CASE " + "\n");
		super.sql.append("                            WHEN KB.RSK_KEIJ_HOHO_KBN = '201' THEN " + "\n");
		super.sql.append("                                0 " + "\n");
		super.sql.append("                            ELSE " + "\n");
		super.sql.append("                                SUM(FKN_TNKI.ENT_SHOHYO_KZI + FKN_TNKI.ENT_SHOHYO_HKZI + FKN_TNKI.GTAX + FKN_TNKI.CTAX + FKN_TNKI.JTAX + FKN_TNKI.JBSK_HKN + FKN_TNKI.NNI_HKN + FKN_TNKI.RCYCL_RYO_KNRI_AMT + FKN_TNKI.DOSO + FKN_TNKI.KOZEI + FKN_TNKI.OTH_CST + FKN_TNKI.IPN_EKM_TEIK_HYO + FKN_TNKI.SHRY_EKM_TEIK_HYO) " + "\n");
		super.sql.append("                        END " + "\n");
		super.sql.append("                      + CASE " + "\n");
		super.sql.append("                            WHEN M_LC.KIMATSU_AMT_OUT_CTL = 0 AND KB.KAI_YMD BETWEEN START_YMD AND END_YMD THEN " + "\n");
		super.sql.append("                                0 " + "\n");
		super.sql.append("                            WHEN KB.FKN_KEIJ_YM_MAX BETWEEN START_KEIJ_YM AND END_KEIJ_YM AND KB.LU_TRSK_CD IN (KB.ZANK_HSHOSK_CD, KB.IPN_ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("                                KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("                            ELSE " + "\n");
		super.sql.append("                                0 " + "\n");
		super.sql.append("                        END " + "\n");
		super.sql.append("                        FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("                        WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("                        AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("                        AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("                        AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("                        AND    FKN_TNKI.KEIJ_YM BETWEEN START_KEIJ_YM AND FKN_KEIJ_YM_LAST) " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("               END TOUKI_SIHARAI " + "\n");
		super.sql.append("              ,CASE " + "\n");
		//20140919 REP START
		super.sql.append("                   WHEN KB.TRD_HNTE_KEKA_KBN = '2' AND (KAI_YMD IS NULL AND KB.START_YMD <= GREATEST(KB.MRYO_YMD, NVL2(KB.GNKSK_KEIJ_YM_MAX,KB.GNKSK_KEIJ_YM_MAX || '99',KB.MRYO_YMD)) OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		//super.sql.append("                   WHEN KB.TRD_HNTE_KEKA_KBN = '2' AND (KAI_YMD IS NULL AND KB.START_YMD <= GREATEST(KB.MRYO_YMD, KB.GNKSK_KEIJ_YM_MAX || '99') OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		//20140919 REP END
		super.sql.append("                       NVL((SELECT SUM(TGTU_SKK_AMT) TGTU_SKK_AMT " + "\n");
		super.sql.append("                           FROM   T_UKB_GNKSK G " + "\n");
		super.sql.append("                           WHERE  G.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("                           AND    G.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("                           AND    G.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("                           AND    G.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("                           AND    G.KEIJ_HOHO_KBN = KB.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                           AND    G.KEIJ_YM BETWEEN START_KEIJ_YM AND GNKSK_KEIJ_YM_LAST) " + "\n");
		super.sql.append("                         + CASE " + "\n");
		super.sql.append("                               WHEN (KB.KAI_YMD IS NULL AND KB.GNKSK_KEIJ_YM_MAX <= END_KEIJ_YM) " + "\n");
		super.sql.append("                               AND KB.LU_TRSK_CD IN (KB.IPN_ZANK_HSHOSK_CD, KB.ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("                                   KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("                               ELSE " + "\n");
		super.sql.append("                                   0 " + "\n");
		super.sql.append("                           END, 0)" + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("               END TOUKI_GENKA " + "\n");
		super.sql.append("              ,CASE " + "\n");
		super.sql.append("                   WHEN KB.TRD_HNTE_KEKA_KBN = '2' THEN " + "\n");
		super.sql.append("                       (SELECT SUM(HSE_RSK) HSE_RSK " + "\n");
		super.sql.append("                        FROM   T_UKB_TNKI_DETAIL FKN_TNKI " + "\n");
		super.sql.append("                        WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("                        AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("                        AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("                        AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("                        AND    FKN_TNKI.KEIJ_HOHO_KBN = KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                        AND    FKN_TNKI.KEIJ_YM BETWEEN START_KEIJ_YM AND FKN_KEIJ_YM_LAST) " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("               END TOUKI_RISOKU " + "\n");
		super.sql.append("              ,CASE " + "\n");
		super.sql.append("                   WHEN KB.TRD_HNTE_KEKA_KBN = '3' AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("                       CASE " + "\n");
		super.sql.append("                           WHEN KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("                               0 " + "\n");
		super.sql.append("                           ELSE " + "\n");
		super.sql.append("                               (SELECT SUM(CASE WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN FKN_TNKI.TGTU_GNPN " + "\n");
		super.sql.append("								                  ELSE FKN_TNKI.YTE_TGTU_GNPN " + "\n");
		super.sql.append("							                 END) " + "\n");
		super.sql.append("                                FROM   T_UKB_TNKI_DETAIL FKN_TNKI " + "\n");
		super.sql.append("                                       ,T_UKB_TNKI_HEAD FKN_TNKI_H " + "\n");
		super.sql.append("                                WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEIJ_HOHO_KBN = KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                                AND    FKN_TNKI.LC_CD = FKN_TNKI_H.LC_CD " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEI_NO = FKN_TNKI_H.KEI_NO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.BKN_NO = FKN_TNKI_H.BKN_NO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.BKN_EDANO = FKN_TNKI_H.BKN_EDANO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEIJ_YM = FKN_TNKI_H.KEIJ_YM " + "\n");
		if (commonBean.isShowKaiKnoOpt()) {
			if (super.kaiknoTermkei.equals("0")) {
				super.sql.append("                        AND    FKN_TNKI_H.KAI_FNO_FLG = '1' " + "\n");
			}
		}
		super.sql.append("                                AND    FKN_TNKI.KEIJ_YM BETWEEN NEXT_START_KEIJ_YM AND NEXT_END_KEIJ_YM) " + "\n");
		super.sql.append("                       END " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("               END MIKEIKA01 " + "\n");
		super.sql.append("              ,CASE " + "\n");
		super.sql.append("                   WHEN KB.TRD_HNTE_KEKA_KBN = '3' AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("                       CASE " + "\n");
		super.sql.append("                           WHEN KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("                               0 " + "\n");
		super.sql.append("                           ELSE " + "\n");
		super.sql.append("                               (SELECT SUM(CASE WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN FKN_TNKI.TGTU_GNPN " + "\n");
		super.sql.append("								                  ELSE FKN_TNKI.YTE_TGTU_GNPN " + "\n");
		super.sql.append("							                 END) " + "\n");
		super.sql.append("                                FROM   T_UKB_TNKI_DETAIL FKN_TNKI " + "\n");
		super.sql.append("                                       ,T_UKB_TNKI_HEAD FKN_TNKI_H " + "\n");
		super.sql.append("                                WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEIJ_HOHO_KBN = KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                                AND    FKN_TNKI.LC_CD = FKN_TNKI_H.LC_CD " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEI_NO = FKN_TNKI_H.KEI_NO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.BKN_NO = FKN_TNKI_H.BKN_NO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.BKN_EDANO = FKN_TNKI_H.BKN_EDANO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEIJ_YM = FKN_TNKI_H.KEIJ_YM " + "\n");
		if (commonBean.isShowKaiKnoOpt()) {
			if (super.kaiknoTermkei.equals("0")) {
				super.sql.append("                                AND    FKN_TNKI_H.KAI_FNO_FLG = '1' " + "\n");
			}
		}
		super.sql.append("                                AND    FKN_TNKI.KEIJ_YM >= OVER_NEXT_START_KEIJ_YM) " + "\n");
		super.sql.append("                       END " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("               END MIKEIKA02 " + "\n");
		super.sql.append("              ,M_LU.LU_COSMOS_CD " + "\n");
		super.sql.append("              ,M_LU.LU_NM " + "\n");
		super.sql.append("              ,DECODE(M_LU.PDF_COMPANY_NM, NULL, M_LC.LC_NM, M_LU.PDF_COMPANY_NM) LC_NM " + "\n");

		if (super.kaikeiSyori.equals(LACSDefine.KaikeiSyori.SYOUSAI_0)) {
			super.sql.append("			  ,M_LU." + super.prefix + "ITNGI_YUKEI_SKK_HOHO_CD ITNGI_YUKEI_SKK_HOHO_CD " + "\n");
			super.sql.append("			  ,M_LU." + super.prefix + "ITNGI_MUKEI_SKK_HOHO_CD ITNGI_MUKEI_SKK_HOHO_CD " + "\n");
			super.sql.append("			  ,M_LU." + super.prefix + "RSK_CLC_HOHO_CD RSK_CLC_HOHO_CD " + "\n");
		}
		else {
			super.sql.append("			  ,'" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' ITNGI_YUKEI_SKK_HOHO_CD " + "\n");
			super.sql.append("			  ,'" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' ITNGI_MUKEI_SKK_HOHO_CD " + "\n");
			super.sql.append("			  ,'" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' RSK_CLC_HOHO_CD " + "\n");
		}

		super.sql.append("              ,TO_CHAR(SYSDATE, 'YYYYMMDD') CREATE_DATE " + "\n");
		super.sql.append("              ,(SELECT DISTINCT AC_SHR_RYA FROM M_AC_SHR_KBN WHERE AC_SHR_KBN = '" + super.kaikeiSyori + "') KAIKEI_SHYORI " + "\n");
		super.sql.append("        FROM   (" + super.getCoreSQL() + ") KB " + "\n");
		super.sql.append("        JOIN   M_LC ON KB.LC_CD = M_LC.LC_CD " + "\n");
		super.sql.append("        JOIN   M_LU ON KB.LU_COSMOS_CD = M_LU.LU_COSMOS_CD " + "\n");
		super.sql.append("        WHERE  KB.KNSHU_YMD <= KB.END_YMD " + "\n");
		super.sql.append("AND  KB.TRD_HNTE_KEKA_KBN IN ('1', '2', '3') " + "\n");
		//20140919 REP START
		super.sql.append("AND  (((KB.KNSHU_YMD <> NVL(KB.KAI_YMD,'A') AND (KAI_YMD IS NULL AND KB.START_YMD <= GREATEST(KB.MRYO_YMD, NVL2(KB.GNKSK_KEIJ_YM_MAX,KB.GNKSK_KEIJ_YM_MAX || '99',KB.MRYO_YMD))) OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) " + "\n");
		//super.sql.append("AND  (((KB.KNSHU_YMD <> NVL(KB.KAI_YMD,'A') AND (KAI_YMD IS NULL AND KB.START_YMD <= GREATEST(KB.MRYO_YMD, KB.GNKSK_KEIJ_YM_MAX || '99')) OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) " + "\n");
		//20140919 REP END
		super.sql.append("   OR  (KB.KNSHU_YMD = KB.KAI_YMD AND KB.START_YMD <= KB.KNSHU_YMD) OR (KB.START_YMD = NVL(KB.KAI_YMD,'0')))" + "\n");
		super.sql.append("OR    ((KB.KNSHU_YMD <> NVL(KB.KAI_YMD,'A') AND ((KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD) OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD))) " + "\n");
		super.sql.append("   OR  (KB.KNSHU_YMD = KB.KAI_YMD AND KB.START_YMD <= KB.KNSHU_YMD)))" + "\n");
		super.sql.append("		  AND    KB.TAISHO_AC_KIJYUN_CD ='" + super.acStd + "'" + "\n");
		super.sql.append("		  AND KB.LU_COSMOS_CD = '" + this.leasCompanyCode + "' " + "\n"); // リースユーザ

		if (this.keiyakuNo.trim().length() > 0) {
			super.sql.append("		  AND KB.HYJYO_KEI_NO = '" + this.keiyakuNo + "' " + "\n"); // 契約番号
		}

		if (this.bukkenNo.trim().length() > 0) {
			super.sql.append("		  AND KB.BKN_NO || CASE WHEN TRIM(KB.BKN_EDANO) IS NULL THEN '' ELSE '-' || KB.BKN_EDANO END = '" + this.bukkenNo + "' " + "\n"); // 物件番号
		}

		// 抽出条件-旧会計基準
		if (super.acStd.equals(LACSDefine.AccountStandard.OLD_0)) {
			if (super.oldkeiyakuGaku.equals("0")) {
				super.sql.append("  AND    ((KB.SGK_SSN_KBN IS NULL AND KB.KEI_AMT_KEI > 3000000) " + "\n"); // 契約金額３００万円以下(KEI_AMTは物件から取得しているためKEI_AMT_KEIを使用)
				super.sql.append("      OR   (KB.SGK_SSN_KBN IS NOT NULL AND KB.SGK_SSN_KBN = '0')) " + "\n");
			}

			if (super.oldleaseKikan.equals("0")) {
				super.sql.append("		  AND KB.KEI_TERM >= 12 " + "\n"); // リース期間１年未満
			}

			if (super.oldsaiLease.equals("0")) {
				super.sql.append("		  AND KB.RLS_TMS = 0" + "\n"); // 再リース契約
			}

			if (super.oldtyutoKaiyaku.equals("0")) {
				super.sql.append("		  AND KB.KAI_YMD IS NULL" + "\n"); // 中途解約物件
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
				super.sql.append("		  AND KB.KEI_TERM > 12 " + "\n"); // リース期間１年以内
			}

			if (super.newsaiLease.equals("0")) {
				super.sql.append("		  AND KB.RLS_TMS = 0" + "\n"); // 再リース契約
			}

			if (super.newtyutoKaiyaku.equals("0")) {
				super.sql.append("		  AND KB.KAI_YMD IS NULL" + "\n"); // 中途解約物件
			}
		}

		super.sql.append("		  ) BASE " + "\n");

		super.sql.append("GROUP  BY LU_COSMOS_CD " + "\n");
		super.sql.append("         ,LU_NM " + "\n");
		super.sql.append("         ,LC_NM " + "\n");
		super.sql.append("         ,ITNGI_YUKEI_SKK_HOHO_CD " + "\n");
		super.sql.append("         ,ITNGI_MUKEI_SKK_HOHO_CD " + "\n");
		super.sql.append("         ,RSK_CLC_HOHO_CD " + "\n");
		super.sql.append("         ,KAIKEI_SHYORI " + "\n");
		super.sql.append("         ,START_YMD " + "\n");
		super.sql.append("         ,END_YMD " + "\n");
		
		// test start
		//System.out.println(super.sql);
		// test end
	}

	/**
	 * リース会社を取得.
	 * 
	 * @return リース会社
	 */
	public String getLeaseCompany() {
		return super.getString("LEASE_COMPANY", "");
	}

	/**
	 * 取得価額相当額（建物）を取得.
	 * 
	 * @return 取得価額相当額（建物）
	 */
	public long getSyutoku01() {
		return super.getLong("SYUTOKU01");
	}

	/**
	 * 取得価額相当額（建物付属設備）を取得.
	 * 
	 * @return 取得価額相当額（建物付属設備）
	 */
	public long getSyutoku02() {
		return super.getLong("SYUTOKU02");
	}

	/**
	 * 取得価額相当額（構築物）を取得.
	 * 
	 * @return 取得価額相当額（構築物）
	 */
	public long getSyutoku03() {
		return super.getLong("SYUTOKU03");
	}

	/**
	 * 取得価額相当額（機械および装置）を取得.
	 * 
	 * @return 取得価額相当額（機械および装置）
	 */
	public long getSyutoku04() {
		return super.getLong("SYUTOKU04");
	}

	/**
	 * 取得価額相当額（船舶）を取得.
	 * 
	 * @return 取得価額相当額（船舶）
	 */
	public long getSyutoku05() {
		return super.getLong("SYUTOKU05");
	}

	/**
	 * 取得価額相当額（航空機）を取得.
	 * 
	 * @return 取得価額相当額（航空機）
	 */
	public long getSyutoku06() {
		return super.getLong("SYUTOKU06");
	}

	/**
	 * 取得価額相当額（車輛および運搬具）を取得.
	 * 
	 * @return 取得価額相当額（車輛および運搬具）
	 */
	public long getSyutoku07() {
		return super.getLong("SYUTOKU07");
	}

	// 2020/05/22 ADD START
	/**
	 * 取得価額相当額（工具器具備品）を取得.
	 * 
	 * @return 取得価額相当額（工具器具備品）
	 */
	public long getSyutoku08() {
		return super.getLong("SYUTOKU08");
	}

	/**
	 * 取得価額相当額（無形固定資産）を取得.
	 * 
	 * @return 取得価額相当額（無形固定資産）
	 */
	public long getSyutoku09() {
		return super.getLong("SYUTOKU09");
	}
	// 2020/05/22 ADD END
	/**
	 * 取得価額相当額（合計）を取得.
	 * 
	 * @return 取得価額相当額（合計）
	 */
	public long getSyutokuTotal() {
		return super.getLong("SYUTOKU_TOTAL");
	}

	/**
	 * 減価償却累計額（建物）を取得.
	 * 
	 * @return 減価償却累計額（建物）
	 */
	public long getGenka01() {
		return super.getLong("GENKA01");
	}

	/**
	 * 減価償却累計額（建物付属設備）を取得.
	 * 
	 * @return 減価償却累計額（建物付属設備）
	 */
	public long getGenka02() {
		return super.getLong("GENKA02");
	}

	/**
	 * 減価償却累計額（構築物）を取得.
	 * 
	 * @return 減価償却累計額（構築物）
	 */
	public long getGenka03() {
		return super.getLong("GENKA03");
	}

	/**
	 * 減価償却累計額（機械および装置）を取得.
	 * 
	 * @return 減価償却累計額（機械および装置）
	 */
	public long getGenka04() {
		return super.getLong("GENKA04");
	}

	/**
	 * 減価償却累計額（船舶）を取得.
	 * 
	 * @return 減価償却累計額（船舶）
	 */
	public long getGenka05() {
		return super.getLong("GENKA05");
	}

	/**
	 * 減価償却累計額（航空機)を取得.
	 * 
	 * @return 減価償却累計額（航空機）
	 */
	public long getGenka06() {
		return super.getLong("GENKA06");
	}

	/**
	 * 減価償却累計額（車輛および運搬具）を取得.
	 * 
	 * @return 減価償却累計額（車輛および運搬具）
	 */
	public long getGenka07() {
		return super.getLong("GENKA07");
	}

	// 2020/05/22 ADD START
	/**
	 * 減価償却累計額（工具器具備品）を取得.
	 * 
	 * @return 減価償却累計額（工具器具備品）
	 */
	public long getGenka08() {
		return super.getLong("GENKA08");
	}

	/**
	 * 減価償却累計額（無形固定資産）を取得.
	 * 
	 * @return 減価償却累計額（無形固定資産）
	 */
	public long getGenka09() {
		return super.getLong("GENKA09");
	}
	// 2020/05/22 ADD END
	/**
	 * 減価償却累計額（合計）を取得.
	 * 
	 * @return 減価償却累計額（合計）
	 */
	public long getGenkaTotal() {
		return super.getLong("GENKA_TOTAL");
	}

	/**
	 * 期末残高相当額（建物）を取得.
	 * 
	 * @return 期末残高相当額（建物）
	 */
	public long getZandaka01() {
		return super.getLong("ZANDAKA01");
	}

	/**
	 * 期末残高相当額（建物付属設備）を取得.
	 * 
	 * @return 期末残高相当額（建物付属設備）
	 */
	public long getZandaka02() {
		return super.getLong("ZANDAKA02");
	}

	/**
	 * 期末残高相当額（構築物）を取得.
	 * 
	 * @return 期末残高相当額（構築物）
	 */
	public long getZandaka03() {
		return super.getLong("ZANDAKA03");
	}

	/**
	 * 期末残高相当額（機械および装置）を取得.
	 * 
	 * @return 期末残高相当額（機械および装置）
	 */
	public long getZandaka04() {
		return super.getLong("ZANDAKA04");
	}

	/**
	 * 期末残高相当額（船舶）を取得.
	 * 
	 * @return 期末残高相当額（船舶）
	 */
	public long getZandaka05() {
		return super.getLong("ZANDAKA05");
	}

	/**
	 * 期末残高相当額（航空機）を取得.
	 * 
	 * @return 期末残高相当額（航空機）
	 */
	public long getZandaka06() {
		return super.getLong("ZANDAKA06");
	}

	/**
	 * 期末残高相当額（車輛および運搬具）を取得.
	 * 
	 * @return 期末残高相当額（車輛および運搬具）
	 */
	public long getZandaka07() {
		return super.getLong("ZANDAKA07");
	}

	// 2020/05/22 ADD START
	/**
	 * 期末残高相当額（工具器具備品）を取得.
	 * 
	 * @return 期末残高相当額（工具器具備品）
	 */
	public long getZandaka08() {
		return super.getLong("ZANDAKA08");
	}

	/**
	 * 期末残高相当額（無形固定資産）を取得.
	 * 
	 * @return 期末残高相当額（無形固定資産）
	 */
	public long getZandaka09() {
		return super.getLong("ZANDAKA09");
	}
	// 2020/05/22 ADD END
	
	/**
	 * 期末残高相当額（合計）を取得.
	 * 
	 * @return 期末残高相当額（合計）
	 */
	public long getZandakaTotal() {
		return super.getLong("ZANDAKA_TOTAL");
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）
	 */
	public long getMikeikaZan01() {
		return super.getLong("MIKEIKA_ZAN01");
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）
	 */
	public long getMikeikaZan02() {
		return super.getLong("MIKEIKA_ZAN02");
	}

	/**
	 * 未経過リース料期末残高相当額（合計）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（合計）
	 */
	public long getMikeikaZan03() {
		return super.getLong("MIKEIKA_ZAN03");
	}

	/**
	 * 支払リース料を取得.
	 * 
	 * @return 支払リース料
	 */
	public long getToukiGenka() {
		return super.getLong("TOUKI_GENKA");
	}

	/**
	 * 減価償却費相当額を取得.
	 * 
	 * @return 減価償却費相当額
	 */
	public long getToukiRisoku() {
		return super.getLong("TOUKI_RISOKU");
	}

	/**
	 * 支払利息相当額を取得.
	 * 
	 * @return 支払利息相当額
	 */
	public long getToukiSiharai() {
		return super.getLong("TOUKI_SIHARAI");
	}

	/**
	 * 未経過リース料（一年以内）を取得.
	 * 
	 * @return 未経過リース料（一年以内）
	 */
	public long getMikeika01() {
		return super.getLong("MIKEIKA01");
	}

	/**
	 * 未経過リース料（一年超）を取得.
	 * 
	 * @return 未経過リース料（一年超）
	 */
	public long getMikeika02() {
		return super.getLong("MIKEIKA02");
	}

	/**
	 * 未経過リース料（合計）を取得.
	 * 
	 * @return 未経過リース料（合計）
	 */
	public long getMikeika03() {
		return super.getLong("MIKEIKA03");
	}

	/**
	 * リース会社を取得.
	 * 
	 * @return リース会社
	 */
	public String getLeasCompanyNm() {
		return super.getString("LC_NM");
	}

	/**
	 * リースユーザを取得.
	 * 
	 * @return リースユーザ
	 */
	public String getLeasUserNm() {
		return super.getString("LU_NM");
	}

	/**
	 * 所有権移転外有形償却方法コードを取得.
	 * 
	 * @return 所有権移転外有形償却方法コード
	 */
	public String getYukeiSkkHoho() {
		return super.getString("ITNGI_YUKEI_SKK_HOHO_CD");
	}

	/**
	 * 所有権移転外無形償却方法コードを取得.
	 * 
	 * @return 所有権移転外無形償却方法コード
	 */
	public String getMukeiSkkHoho() {
		return super.getString("ITNGI_MUKEI_SKK_HOHO_CD");
	}

	/**
	 * 利息計算方法コードを取得.
	 * 
	 * @return 利息計算方法コード
	 */
	public String getRskClcHoho() {
		return super.getString("RSK_CLC_HOHO_CD");
	}

	/**
	 * 会計処理方法を取得.
	 * 
	 * @return 会計処理方法
	 */
	public String getAcShrKbnName() {
		return super.getString("KAIKEI_SHYORI");
	}

}
