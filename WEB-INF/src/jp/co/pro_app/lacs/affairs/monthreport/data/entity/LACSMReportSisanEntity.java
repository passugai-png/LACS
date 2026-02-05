package jp.co.pro_app.lacs.affairs.monthreport.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 月次帳票出力：資産台帳 Entity.
 * 
 * @author fukuhara
 * @version 20080415
 */
public class LACSMReportSisanEntity extends LACSMReportEntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 * @param piCommonBean
	 *            LACS共通Bean
	 * @param piReportBean
	 *            帳票出力Bean
	 */
	public LACSMReportSisanEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSMReportBean piReportBean) {
		super(piModel, piCommonBean, piReportBean);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT RPAD(TAISHO_AC_KIJYUN_CD, 1, ' ') BRAKE_KEY0 " + "\n");
		super.sql.append("      ,RPAD(TAISHO_AC_KIJYUN_CD, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN, 1, ' ') BRAKE_KEY1 " + "\n");
		super.sql.append("      ,RPAD(TAISHO_AC_KIJYUN_CD, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(CTSHK_FLG, 1, ' ') BRAKE_KEY2 " + "\n");
		super.sql.append("      ,RPAD(TAISHO_AC_KIJYUN_CD, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(CTSHK_FLG, 1, ' ') || RPAD(YUKEI_MUKEI_KBN, 1, ' ') BRAKE_KEY3 " + "\n");
		super.sql.append("      ,RPAD(TAISHO_AC_KIJYUN_CD, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(CTSHK_FLG, 1, ' ') || RPAD(YUKEI_MUKEI_KBN, 1, ' ') || RPAD(SSN_SRI_CD, 1, ' ') BRAKE_KEY4 " + "\n");
		super.sql.append("      ,TO_CHAR(SYSDATE, 'YYYYMMDD') CREATE_DATE " + "\n");
		super.sql.append("      ," + super.taisyouFrom + " START_YMD" + "\n");
		super.sql.append("      ," + super.taisyouTo + " END_YMD" + "\n");
		super.sql.append("      ,LEASE_COMPANY " + "\n");
		super.sql.append("      ,LU_COSMOS_CD " + "\n");
		super.sql.append("      ,LEASE_USER " + "\n");
		super.sql.append("      ,TAISHO_AC_KIJYUN_CD " + "\n");
		super.sql.append("      ,TAISHO_AC_KIJYUN_NM " + "\n");
		super.sql.append("      ,TRD_HNTE_KEKA_KBN  " + "\n");
		super.sql.append("      ,TRD_HNTE_KEKA_NM  " + "\n");
		super.sql.append("      ,CTSHK_FLG " + "\n");
		super.sql.append("      ,AC_SHR_KBN_NM " + "\n");
		super.sql.append("      ,YUKEI_MUKEI_KBN " + "\n");
		super.sql.append("      ,YUKEI_MUKEI_NM " + "\n");
		super.sql.append("      ,SSN_SRI_CD " + "\n");
		super.sql.append("      ,SSN_SRI_NM " + "\n");
		super.sql.append("      ,HYJYO_KEI_NO " + "\n");
		super.sql.append("      ,KEI_NO " + "\n");
		super.sql.append("      ,BKN_NO " + "\n");
		super.sql.append("    || CASE " + "\n");
		super.sql.append("           WHEN TRIM(BKN_EDANO) IS NULL THEN " + "\n");
		super.sql.append("               '' " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("           '-' || BKN_EDANO " + "\n");
		super.sql.append("       END BKN_NO " + "\n");
		super.sql.append("      ,BKN_NM " + "\n");
		super.sql.append("      ,BKN_SU " + "\n");
		super.sql.append("      ,KNSHU_YMD " + "\n");
		super.sql.append("      ,SUBSTR(KNSHU_YMD, 1, 6) KNSHU_YM " + "\n");
		super.sql.append("      ,SYUTOKU_AMT " + "\n");
		super.sql.append("      ,SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("      ,SKK_HOHO_NM " + "\n");
		super.sql.append("      ,SYOUKYAKU_TERM " + "\n");
		super.sql.append("      ,SKK_RT " + "\n");
		super.sql.append("      ,M_COUNT " + "\n");
		super.sql.append("      ,SGK_SSN_KBN " + "\n");
		super.sql.append("      ,KEI_TERM " + "\n");
		super.sql.append("      ,RLS_TMS " + "\n");
		super.sql.append("      ,KAI_YMD " + "\n");
		super.sql.append("      ,MRYO_YMD " + "\n");
		super.sql.append("      ,KEI_AMT_KEI  " + "\n");
		super.sql.append("      ,ZENKI_BOKA " + "\n");
		super.sql.append("      ,TOU_HASSEI " + "\n");
		super.sql.append("      ,TOU_GENSYO " + "\n");
		super.sql.append("      ,TOU_JITSU " + "\n");
		super.sql.append("      ,TOUKIMATSU_BOKA " + "\n");
		super.sql.append("FROM   (SELECT DECODE(LU.PDF_COMPANY_NM, NULL, M_LC.LC_NM, LU.PDF_COMPANY_NM) LEASE_COMPANY " + "\n");
		super.sql.append("              ,LU.LU_NM LEASE_USER " + "\n");
		super.sql.append("              ,KEI.LU_COSMOS_CD LU_COSMOS_CD " + "\n");
		super.sql.append("              ,KEI.TAISHO_AC_KIJYUN_CD TAISHO_AC_KIJYUN_CD " + "\n");
		super.sql.append("              ,DECODE(KEI.TAISHO_AC_KIJYUN_CD, '0', '旧リース会計基準', '新リース会計基準') TAISHO_AC_KIJYUN_NM " + "\n");
		super.sql.append("              ,SSN_SRI.YUKEI_MUKEI_KBN YUKEI_MUKEI_KBN " + "\n");
		super.sql.append("              ,DECODE(SSN_SRI.YUKEI_MUKEI_KBN, '1', '有形資産', '9', '無形資産') YUKEI_MUKEI_NM " + "\n");
		super.sql.append("              ,BKN.SSN_SRI_CD " + "\n");
		super.sql.append("              ,SSN_SRI.SSN_SRI_NM " + "\n");
		super.sql.append("              ,KEI.HYJYO_KEI_NO HYJYO_KEI_NO " + "\n");
		super.sql.append("              ,KEI.KEI_NO KEI_NO " + "\n");
		super.sql.append("              ,BKN.BKN_NO BKN_NO " + "\n");
		super.sql.append("              ,BKN.BKN_EDANO BKN_EDANO " + "\n");
		super.sql.append("              ,BKN.BKN_NM BKN_NM " + "\n");
		super.sql.append("              ,BKN.BKN_SU BKN_SU " + "\n");
		super.sql.append("              ,KEI.KNSHU_YMD KNSHU_YMD " + "\n");
		super.sql.append("	  ,(SELECT T_UKB_GNKSK.GNPN_TTL " + "\n");
		super.sql.append("		FROM   T_UKB_GNKSK " + "\n");
		super.sql.append("		WHERE  T_UKB_GNKSK.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("		AND    T_UKB_GNKSK.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("		AND    T_UKB_GNKSK.BKN_NO = KEI.BKN_NO " + "\n");
		super.sql.append("		AND    T_UKB_GNKSK.BKN_EDANO = KEI.BKN_EDANO " + "\n");
		super.sql.append("		AND    T_UKB_GNKSK.KEIJ_HOHO_KBN = KEI.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("		AND    T_UKB_GNKSK.KEIJ_YM = KEI.GNKSK_KEIJ_YM_MAX_KAI_REC) SYUTOKU_AMT " + "\n");
		super.sql.append("              ,BKN.SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("              ,CASE KEI.CTSHK_FLG " + "\n");
		super.sql.append("                    WHEN '0' THEN " + "\n");
		super.sql.append("                        SKK_KEIJ_HOHO_KBN.SKK_HOHO_NM " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                        '非償却' " + "\n");
		super.sql.append("               END SKK_HOHO_NM " + "\n");
		super.sql.append("              ,CASE KEI.CTSHK_FLG " + "\n");
		super.sql.append("                   WHEN '0' THEN " + "\n");
		super.sql.append("                       CASE BKN.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                           WHEN '111' THEN " + "\n");
		super.sql.append("                               BKN.TY_YSU * 12 " + "\n");
		super.sql.append("                           WHEN '112' THEN " + "\n");
		super.sql.append("                               BKN.TY_YSU * 12 " + "\n");
		super.sql.append("                           WHEN '113' THEN " + "\n");
		super.sql.append("                               BKN.TY_YSU * 12 " + "\n");
		super.sql.append("                           WHEN '121' THEN " + "\n");
		super.sql.append("                               KEI.KEI_TERM " + "\n");
		super.sql.append("                           WHEN '122' THEN " + "\n");
		super.sql.append("                               KEI.KEI_TERM " + "\n");
		super.sql.append("                           WHEN '123' THEN " + "\n");
		super.sql.append("                               KEI.KEI_TERM " + "\n");
		super.sql.append("                           WHEN '221' THEN " + "\n");
		super.sql.append("                               KEI.KEI_TERM " + "\n");
		super.sql.append("                           WHEN '222' THEN " + "\n");
		super.sql.append("                               KEI.KEI_TERM " + "\n");
		super.sql.append("                           WHEN '223' THEN " + "\n");
		super.sql.append("                               KEI.KEI_TERM " + "\n");
		super.sql.append("                       END " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                        0 " + "\n");
		super.sql.append("               END SYOUKYAKU_TERM " + "\n");
		super.sql.append("              ,TRUNC(CASE KEI.CTSHK_FLG " + "\n");
		super.sql.append("                   WHEN '0' THEN " + "\n");
		super.sql.append("                       CASE BKN.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                           WHEN '111' THEN " + "\n");
		super.sql.append("                               (SELECT t.SKK_RT / 12 FROM M_SKK_RT t WHERE t.SKK_HOHO_CD = '01' AND t.skk_msu = BKN.TY_YSU * 12) " + "\n");
		super.sql.append("                           WHEN '112' THEN " + "\n");
		super.sql.append("                               (SELECT t.SKK_RT / 12 FROM M_SKK_RT t WHERE t.SKK_HOHO_CD = '02' AND t.skk_msu = BKN.TY_YSU * 12) " + "\n");
		super.sql.append("                           WHEN '121' THEN " + "\n");
		super.sql.append("                               1/ KEI.KEI_TERM " + "\n");
		super.sql.append("                           WHEN '122' THEN " + "\n");
		super.sql.append("                               (SELECT t.SKK_RT / 12 FROM M_SKK_RT t WHERE t.SKK_HOHO_CD = '02' AND t.skk_msu = KEI.KEI_TERM) " + "\n");
		super.sql.append("                           WHEN '221' THEN " + "\n");
		super.sql.append("                               1/ KEI.KEI_TERM " + "\n");
		super.sql.append("                           WHEN '222' THEN " + "\n");
		super.sql.append("                               (SELECT t.SKK_RT / 12 FROM M_SKK_RT t WHERE t.SKK_HOHO_CD = '02' AND t.skk_msu = KEI.KEI_TERM) " + "\n");
		super.sql.append("                           ELSE " + "\n");
		super.sql.append("                               NULL " + "\n");
		super.sql.append("                       END " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("               END, LU.SYOSU_KETASU) * 100 SKK_RT " + "\n");
		super.sql.append("              ,CASE KEI.CTSHK_FLG " + "\n");
		super.sql.append("                   WHEN '0' THEN " + "\n");
		super.sql.append("                       CASE " + "\n");
		super.sql.append("                           WHEN KEI.KNSHU_YMD < '" + this.taisyouFrom + "' THEN \n");
		super.sql.append("                               INVIO_FUNC.KAI_KEIK_TERM_RET('" + this.taisyouFrom + "' , TO_CHAR(TO_DATE(LEAST(END_YMD, KEI.MRYO_YMD, NVL(KEI.KAI_YMD, '99999999')), 'YYYYMMDD') + 1, 'YYYYMMDD')) " + "\n");
		super.sql.append("                           ELSE " + "\n");
		super.sql.append("                               INVIO_FUNC.KAI_KEIK_TERM_RET(KEI.KNSHU_YMD , TO_CHAR(TO_DATE(LEAST(END_YMD, KEI.MRYO_YMD, NVL(KEI.KAI_YMD, '99999999')), 'YYYYMMDD') + 1, 'YYYYMMDD')) " + "\n");
		super.sql.append("                       END " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("               END M_COUNT " + "\n");
		super.sql.append("              ,CASE " + "\n");
		super.sql.append("                   WHEN START_YMD <= KEI.KNSHU_YMD THEN 0 " + "\n");
		super.sql.append("                   ELSE  \n");
		super.sql.append("                       CASE KEI.CTSHK_FLG " + "\n");
		super.sql.append("                           WHEN '0' THEN " + "\n");
		super.sql.append("                               (SELECT ZAND_SKK_AMT + USER_ZANK " + "\n");
		super.sql.append("                                  FROM T_UKB_GNKSK \n");
		super.sql.append("                                 WHERE T_UKB_GNKSK.LC_CD 			= BKN.LC_CD  \n");
		super.sql.append("                                   AND T_UKB_GNKSK.KEI_NO 		= BKN.KEI_NO \n");
		super.sql.append("                                   AND T_UKB_GNKSK.BKN_NO 		= BKN.BKN_NO \n");
		super.sql.append("                                   AND T_UKB_GNKSK.BKN_EDANO 		= BKN.BKN_EDANO \n");
		super.sql.append("                                   AND T_UKB_GNKSK.KEIJ_HOHO_KBN 	= BKN.SKK_KEIJ_HOHO_KBN \n");
		super.sql.append("                                   AND T_UKB_GNKSK.KEIJ_YM       = TO_CHAR(ADD_MONTHS(TO_DATE(TK.START_KEIJ_YM, 'YYYYMM'), -1), 'YYYYMM') " + "\n");
		super.sql.append("                                   AND T_UKB_GNKSK.KAI_REC_FLG   = '0') " + "\n");
		super.sql.append("                           ELSE " + "\n");
		super.sql.append("                               (SELECT GNPN_TTL " + "\n");
		super.sql.append("                                  FROM T_UKB_GNKSK \n");
		super.sql.append("                                 WHERE T_UKB_GNKSK.LC_CD 			= BKN.LC_CD  \n");
		super.sql.append("                                   AND T_UKB_GNKSK.KEI_NO 		= BKN.KEI_NO \n");
		super.sql.append("                                   AND T_UKB_GNKSK.BKN_NO 		= BKN.BKN_NO \n");
		super.sql.append("                                   AND T_UKB_GNKSK.BKN_EDANO 		= BKN.BKN_EDANO \n");
		super.sql.append("                                   AND T_UKB_GNKSK.KEIJ_HOHO_KBN 	= BKN.SKK_KEIJ_HOHO_KBN \n");
		super.sql.append("                                   AND T_UKB_GNKSK.KEIJ_YM       = TO_CHAR(ADD_MONTHS(TO_DATE(TK.START_KEIJ_YM, 'YYYYMM'), -1), 'YYYYMM') " + "\n");
		super.sql.append("                                   AND T_UKB_GNKSK.KAI_REC_FLG   = '0') " + "\n");
		super.sql.append("                       END " + "\n");
		super.sql.append("               END ZENKI_BOKA " + "\n");
		super.sql.append("	  ,CASE " + "\n");
		super.sql.append("		   WHEN KNSHU_YMD BETWEEN KEI.START_YMD AND KEI.END_YMD THEN " + "\n");
		super.sql.append("			(SELECT G1.GNPN_TTL " + "\n");
		super.sql.append("			 FROM   T_UKB_GNKSK G1 " + "\n");
		super.sql.append("			 WHERE  G1.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("			 AND    G1.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("			 AND    G1.BKN_NO = KEI.BKN_NO " + "\n");
		super.sql.append("			 AND    G1.BKN_EDANO = KEI.BKN_EDANO " + "\n");
		super.sql.append("			 AND    G1.KEIJ_HOHO_KBN = KEI.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("			 AND    G1.KEIJ_YM = KEI.GNKSK_KEIJ_YM_MIN) " + "\n");
		super.sql.append("		   ELSE " + "\n");
		super.sql.append("			0 " + "\n");
		super.sql.append("	   END + (SELECT SUM(T_UKB_GNKSK.ZOU_GNPN) " + "\n");
		super.sql.append("			  FROM   T_UKB_GNKSK " + "\n");
		super.sql.append("			  WHERE  T_UKB_GNKSK.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("			  AND    T_UKB_GNKSK.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("			  AND    T_UKB_GNKSK.BKN_NO = KEI.BKN_NO " + "\n");
		super.sql.append("			  AND    T_UKB_GNKSK.BKN_EDANO = KEI.BKN_EDANO " + "\n");
		super.sql.append("			  AND    T_UKB_GNKSK.KEIJ_HOHO_KBN = KEI.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("			  AND    T_UKB_GNKSK.KEIJ_YM BETWEEN TK.START_KEIJ_YM AND GNKSK_KEIJ_YM_LAST " + "\n");
		super.sql.append("			  AND    T_UKB_GNKSK.KAI_REC_FLG = '0') + CASE " + "\n");
		super.sql.append("		   WHEN KEI.CTSHK_FLG = '0' THEN " + "\n");
		super.sql.append("			(SELECT SUM(T_UKB_GNKSK.GEN_USER_ZANK) " + "\n");
		super.sql.append("			 FROM   T_UKB_GNKSK " + "\n");
		super.sql.append("			 WHERE  T_UKB_GNKSK.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("			 AND    T_UKB_GNKSK.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("			 AND    T_UKB_GNKSK.BKN_NO = KEI.BKN_NO " + "\n");
		super.sql.append("			 AND    T_UKB_GNKSK.BKN_EDANO = KEI.BKN_EDANO " + "\n");
		super.sql.append("			 AND    T_UKB_GNKSK.KEIJ_HOHO_KBN = KEI.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("			 AND    T_UKB_GNKSK.KEIJ_YM BETWEEN TK.START_KEIJ_YM AND GNKSK_KEIJ_YM_LAST " + "\n");
		super.sql.append("			 AND    T_UKB_GNKSK.KAI_REC_FLG = '0') " + "\n");
		super.sql.append("		   ELSE " + "\n");
		super.sql.append("			0 " + "\n");
		super.sql.append("	   END TOU_HASSEI " + "\n");
		super.sql.append("              ,TK.START_KEIJ_YM START_KEIJ_YM " + "\n");
		super.sql.append("              ,TK.END_KEIJ_YM END_KEIJ_YM " + "\n");
		super.sql.append("              ,DECODE(KEI.KNSHU_YMD,NULL,KEI.MRYO_YMD) " + "\n");
		super.sql.append("	  ,CASE KEI.CTSHK_FLG " + "\n");
		super.sql.append("		   WHEN '0' THEN " + "\n");
		super.sql.append("			CASE " + "\n");
		super.sql.append("				WHEN KEI.KAI_YMD BETWEEN KEI.START_YMD AND KEI.END_YMD THEN " + "\n");
		super.sql.append("				 (SELECT G1.KAI_SISAN_BOKA /*+ G1.USER_ZANK*/ " + "\n");
		super.sql.append("				  FROM   T_UKB_GNKSK G1 " + "\n");
		super.sql.append("				  WHERE  G1.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("				  AND    G1.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("				  AND    G1.BKN_NO = KEI.BKN_NO " + "\n");
		super.sql.append("				  AND    G1.BKN_EDANO = KEI.BKN_EDANO " + "\n");
		super.sql.append("				  AND    G1.KEIJ_HOHO_KBN = KEI.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("				  AND    G1.KEIJ_YM = KEI.GNKSK_KEIJ_YM_MAX_KAI_REC) " + "\n");
		super.sql.append("				WHEN KEI.MRYO_YMD BETWEEN KEI.START_YMD AND KEI.END_YMD THEN " + "\n");
		super.sql.append("				 (SELECT G1.USER_ZANK " + "\n");
		super.sql.append("				  FROM   T_UKB_GNKSK G1 " + "\n");
		super.sql.append("				  WHERE  G1.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("				  AND    G1.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("				  AND    G1.BKN_NO = KEI.BKN_NO " + "\n");
		super.sql.append("				  AND    G1.BKN_EDANO = KEI.BKN_EDANO " + "\n");
		super.sql.append("				  AND    G1.KEIJ_HOHO_KBN = KEI.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("				  AND    G1.KEIJ_YM = KEI.GNKSK_KEIJ_YM_MAX) " + "\n");
		super.sql.append("				ELSE " + "\n");
		super.sql.append("				 (SELECT SUM(T_UKB_GNKSK.GEN_GNPN) + SUM(T_UKB_GNKSK.ZOU_USER_ZANK) " + "\n");
		super.sql.append("				  FROM   T_UKB_GNKSK " + "\n");
		super.sql.append("				  WHERE  T_UKB_GNKSK.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.BKN_NO = KEI.BKN_NO " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.BKN_EDANO = KEI.BKN_EDANO " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.KEIJ_HOHO_KBN = KEI.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.KEIJ_YM BETWEEN TK.START_KEIJ_YM AND GNKSK_KEIJ_YM_LAST " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.KAI_REC_FLG = '0') " + "\n");
		super.sql.append("			END " + "\n");
		super.sql.append("		   ELSE " + "\n");
		super.sql.append("			CASE " + "\n");
		super.sql.append("				WHEN NVL(KEI.KAI_YMD, KEI.MRYO_YMD) BETWEEN KEI.START_YMD AND KEI.END_YMD THEN " + "\n");
		super.sql.append("				 (SELECT G1.GNPN_TTL " + "\n");
		super.sql.append("				  FROM   T_UKB_GNKSK G1 " + "\n");
		super.sql.append("				  WHERE  G1.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("				  AND    G1.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("				  AND    G1.BKN_NO = KEI.BKN_NO " + "\n");
		super.sql.append("				  AND    G1.BKN_EDANO = KEI.BKN_EDANO " + "\n");
		super.sql.append("				  AND    G1.KEIJ_HOHO_KBN = KEI.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("				  AND    G1.KEIJ_YM = KEI.GNKSK_KEIJ_YM_MAX_KAI_REC) " + "\n");
		super.sql.append("				ELSE " + "\n");
		super.sql.append("				 (SELECT SUM(T_UKB_GNKSK.GEN_GNPN) " + "\n");
		super.sql.append("				  FROM   T_UKB_GNKSK " + "\n");
		super.sql.append("				  WHERE  T_UKB_GNKSK.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.BKN_NO = KEI.BKN_NO " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.BKN_EDANO = KEI.BKN_EDANO " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.KEIJ_HOHO_KBN = KEI.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.KEIJ_YM BETWEEN TK.START_KEIJ_YM AND GNKSK_KEIJ_YM_LAST " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.KAI_REC_FLG = '0') " + "\n");
		super.sql.append("			END " + "\n");
		super.sql.append("	   END TOU_GENSYO " + "\n");
		super.sql.append("              ,CASE CTSHK_FLG " + "\n");
		super.sql.append("                   WHEN '0' THEN " + "\n");
		super.sql.append("                      (SELECT " + "\n");
		super.sql.append("                         SUM(T_UKB_GNKSK.TGTU_SKK_AMT) TOU_JITSU" + "\n");
		super.sql.append("                         FROM T_UKB_GNKSK \n");
		super.sql.append("                         WHERE T_UKB_GNKSK.LC_CD = BKN.LC_CD  \n");
		super.sql.append("                          AND T_UKB_GNKSK.KEI_NO =BKN.KEI_NO \n");
		super.sql.append("                          AND T_UKB_GNKSK.BKN_NO = BKN.BKN_NO \n");
		super.sql.append("                          AND T_UKB_GNKSK.BKN_EDANO = BKN.BKN_EDANO \n");
		super.sql.append("                          AND T_UKB_GNKSK.KEIJ_HOHO_KBN = BKN.SKK_KEIJ_HOHO_KBN \n");
		super.sql.append("                          AND T_UKB_GNKSK.KEIJ_YM BETWEEN TK.START_KEIJ_YM AND GNKSK_KEIJ_YM_LAST " + "\n");
		super.sql.append("                      ) " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("               END TOU_JITSU " + "\n");
		super.sql.append("	  ,CASE " + "\n");
		super.sql.append("		   WHEN KEI.KAI_YMD BETWEEN KEI.START_YMD AND KEI.END_YMD THEN " + "\n");
		super.sql.append("			0 " + "\n");
		super.sql.append("		   WHEN KEI.MRYO_YMD BETWEEN KEI.START_YMD AND KEI.END_YMD THEN " + "\n");
		super.sql.append("			(SELECT G1.ZAND_SKK_AMT " + "\n");
		super.sql.append("			 FROM   T_UKB_GNKSK G1 " + "\n");
		super.sql.append("			 WHERE  G1.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("			 AND    G1.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("			 AND    G1.BKN_NO = KEI.BKN_NO " + "\n");
		super.sql.append("			 AND    G1.BKN_EDANO = KEI.BKN_EDANO " + "\n");
		super.sql.append("			 AND    G1.KEIJ_HOHO_KBN = KEI.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("			 AND    G1.KEIJ_YM = KEI.GNKSK_KEIJ_YM_LAST) " + "\n");
		super.sql.append("		   ELSE " + "\n");
		super.sql.append("			CASE CTSHK_FLG " + "\n");
		super.sql.append("				WHEN '0' THEN " + "\n");
		super.sql.append("				 (SELECT T_UKB_GNKSK.ZAND_SKK_AMT + T_UKB_GNKSK.USER_ZANK " + "\n");
		super.sql.append("				  FROM   T_UKB_GNKSK " + "\n");
		super.sql.append("				  WHERE  T_UKB_GNKSK.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.BKN_NO = KEI.BKN_NO " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.BKN_EDANO = KEI.BKN_EDANO " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.KEIJ_HOHO_KBN = KEI.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.KEIJ_YM = GNKSK_KEIJ_YM_LAST " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.KAI_REC_FLG = '0') " + "\n");
		super.sql.append("				ELSE " + "\n");
		super.sql.append("				 (SELECT GNPN_TTL " + "\n");
		super.sql.append("				  FROM   T_UKB_GNKSK " + "\n");
		super.sql.append("				  WHERE  T_UKB_GNKSK.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.BKN_NO = KEI.BKN_NO " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.BKN_EDANO = KEI.BKN_EDANO " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.KEIJ_HOHO_KBN = KEI.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.KEIJ_YM = GNKSK_KEIJ_YM_LAST " + "\n");
		super.sql.append("				  AND    T_UKB_GNKSK.KAI_REC_FLG = '0') " + "\n");
		super.sql.append("			END " + "\n");
		super.sql.append("	   END TOUKIMATSU_BOKA " + "\n");
		super.sql.append("              ,KEI.SGK_SSN_KBN " + "\n");
		super.sql.append("              ,KEI.KEI_TERM " + "\n");
		super.sql.append("              ,KEI.RLS_TMS " + "\n");
		super.sql.append("              ,KEI.KAI_YMD " + "\n");
		super.sql.append("              ,KEI.MRYO_YMD " + "\n");
		super.sql.append("              ,KEI.GNKSK_LAST_YMD " + "\n");
		super.sql.append("              ,KEI.KEI_AMT KEI_AMT_KEI  " + "\n");
		super.sql.append("              ,KEI.TRD_HNTE_KEKA_KBN  " + "\n");
		super.sql.append("              ,TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_NM TRD_HNTE_KEKA_NM " + "\n");
		super.sql.append("              ,KEI.CTSHK_FLG  " + "\n");
		super.sql.append("              ,DECODE(KEI.CTSHK_FLG,'0','売買処理','賃貸借処理') AC_SHR_KBN_NM \n");
		super.sql.append("FROM   (" + super.getCoreSQL() + ") KEI " + "\n");
		super.sql.append("JOIN   T_BKN BKN ON BKN.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("             AND    BKN.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("             AND    BKN.BKN_NO = KEI.BKN_NO " + "\n");
		super.sql.append("             AND    BKN.BKN_EDANO = KEI.BKN_EDANO " + "\n");
		super.sql.append("LEFT   JOIN M_LC M_LC ON M_LC.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("LEFT   JOIN M_LU LU ON LU.LU_COSMOS_CD = KEI.LU_COSMOS_CD " + "\n");
		super.sql.append("LEFT   JOIN M_SSN_SRI SSN_SRI ON SSN_SRI.SSN_SRI_CD = BKN.SSN_SRI_CD " + "\n");
		super.sql.append("LEFT   JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN ON SKK_KEIJ_HOHO_KBN.SKK_KEIJ_HOHO_KBN = BKN.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("LEFT   JOIN M_TRD_HNTE_KEKA_KBN TRD_HNTE_KEKA_KBN ON TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN = KEI.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("LEFT   JOIN (SELECT LC_CD,KEI_NO \n");
		super.sql.append("      ,LACS_COMMON.GET_KEIJ_YYYYMM(KNSHU_YMD " + "\n");
		super.sql.append("                                  ,'" + super.dateFrom + "' " + "\n");
		super.sql.append("                                  ,'" + super.dateFrom + "') START_KEIJ_YM " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_KEIJ_YYYYMM(KNSHU_YMD " + "\n");
		super.sql.append("                                  ,'" + super.dateFrom + "' " + "\n");
		super.sql.append("                                  ,LACS_COMMON.GET_TERM_DATE(SUBSTR('" + super.dateFrom + "', 1, 6) || '01' " + "\n");
		super.sql.append("                                                            ," + super.termNum + ")) END_KEIJ_YM " + "\n");
		super.sql.append("         FROM T_KEI " + "\n");
		super.sql.append("WHERE   LU_COSMOS_CD = '" + this.leasCompanyCode + "' " + "\n"); // リースユーザ

		if (this.keiyakuNo.trim().length() > 0) {
			super.sql.append("AND    HYJYO_KEI_NO = '" + this.keiyakuNo + "' " + "\n"); // 契約番号
		}

		super.sql.append("         ) TK " + "\n");
		super.sql.append("         ON TK.LC_CD = KEI.LC_CD AND TK.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("LEFT   JOIN (SELECT UKB.LC_CD " + "\n");
		super.sql.append("                   ,UKB.KEI_NO " + "\n");
		super.sql.append("                   ,UKB.BKN_NO " + "\n");
		super.sql.append("                   ,UKB.BKN_EDANO " + "\n");
		super.sql.append("                   ,UKB.KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                   ,UKB.KAI_SISAN_BOKA " + "\n");
		super.sql.append("             FROM   T_UKB_GNKSK UKB " + "\n");
		super.sql.append("             JOIN   (SELECT T_UKB_GNKSK.LC_CD " + "\n");
		super.sql.append("                          ,T_UKB_GNKSK.KEI_NO " + "\n");
		super.sql.append("                          ,T_UKB_GNKSK.BKN_NO " + "\n");
		super.sql.append("                          ,T_UKB_GNKSK.BKN_EDANO " + "\n");
		super.sql.append("                          ,T_UKB_GNKSK.KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                          ,MAX(KEIJ_YM) MAX_KEIJ_YM " + "\n");
		super.sql.append("                    FROM   T_KEI " + "\n");
		super.sql.append("                          ,T_BKN " + "\n");
		super.sql.append("                          ,T_UKB_GNKSK " + "\n");
		super.sql.append("                    WHERE  KAI_REC_FLG='0'  " + "\n");
		super.sql.append("                    AND    T_KEI.LC_CD = T_BKN.LC_CD " + "\n");
		super.sql.append("                    AND    T_KEI.KEI_NO = T_BKN.KEI_NO " + "\n");
		super.sql.append("                    AND    T_BKN.LC_CD = T_UKB_GNKSK.LC_CD " + "\n");
		super.sql.append("                    AND    T_BKN.KEI_NO = T_UKB_GNKSK.KEI_NO " + "\n");
		super.sql.append("                    AND    T_BKN.BKN_NO = T_UKB_GNKSK.BKN_NO " + "\n");
		super.sql.append("                    AND    T_BKN.BKN_EDANO = T_UKB_GNKSK.BKN_EDANO " + "\n");
		super.sql.append("                    AND    T_BKN.SKK_KEIJ_HOHO_KBN = T_UKB_GNKSK.KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                    AND    T_KEI.LC_CD = 'LACS' " + "\n");
		super.sql.append("                    AND    T_KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "' " + "\n"); // リースユーザ
		super.sql.append("                    GROUP  BY T_UKB_GNKSK.LC_CD " + "\n");
		super.sql.append("                             ,T_UKB_GNKSK.KEI_NO " + "\n");
		super.sql.append("                             ,T_UKB_GNKSK.BKN_NO " + "\n");
		super.sql.append("                             ,T_UKB_GNKSK.BKN_EDANO " + "\n");
		super.sql.append("                             ,T_UKB_GNKSK.KEIJ_HOHO_KBN) UKB_MAX ON UKB.LC_CD = UKB_MAX.LC_CD " + "\n");
		super.sql.append("                                                 AND    UKB.KEI_NO = UKB_MAX.KEI_NO " + "\n");
		super.sql.append("                                                 AND    UKB.BKN_NO = UKB_MAX.BKN_NO " + "\n");
		super.sql.append("                                                 AND    UKB.BKN_EDANO = UKB_MAX.BKN_EDANO " + "\n");
		super.sql.append("                                                 AND    UKB.KEIJ_HOHO_KBN = UKB_MAX.KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                                                 AND    UKB.KEIJ_YM = UKB_MAX.MAX_KEIJ_YM) " + "\n");
		super.sql.append("MAX_UKB_GNKSK ON MAX_UKB_GNKSK.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("          AND    MAX_UKB_GNKSK.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("          AND    MAX_UKB_GNKSK.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("          AND    MAX_UKB_GNKSK.BKN_EDANO = BKN.BKN_EDANO " + "\n");
		super.sql.append("          AND    MAX_UKB_GNKSK.KEIJ_HOHO_KBN = BKN.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("LEFT   JOIN (SELECT UKB_M.LC_CD " + "\n");
		super.sql.append("                   ,UKB_M.KEI_NO " + "\n");
		super.sql.append("                   ,UKB_M.BKN_NO " + "\n");
		super.sql.append("                   ,UKB_M.BKN_EDANO " + "\n");
		super.sql.append("                   ,UKB_M.KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                   ,UKB_M.GNPN_TTL " + "\n");
		super.sql.append("             FROM   T_UKB_GNKSK UKB_M " + "\n");
		super.sql.append("             JOIN   (SELECT T_UKB_GNKSK.LC_CD " + "\n");
		super.sql.append("                          ,T_UKB_GNKSK.KEI_NO " + "\n");
		super.sql.append("                          ,T_UKB_GNKSK.BKN_NO " + "\n");
		super.sql.append("                          ,T_UKB_GNKSK.BKN_EDANO " + "\n");
		super.sql.append("                          ,T_UKB_GNKSK.KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                          ,MIN(T_UKB_GNKSK.KEIJ_YM) MIN_KEIJ_YM " + "\n");
		super.sql.append("                    FROM   T_KEI " + "\n");
		super.sql.append("                          ,T_BKN " + "\n");
		super.sql.append("                          ,T_UKB_GNKSK " + "\n");
		super.sql.append("                    WHERE   KAI_REC_FLG='0'  " + "\n");
		super.sql.append("                    AND    T_KEI.LC_CD = T_BKN.LC_CD " + "\n");
		super.sql.append("                    AND    T_KEI.KEI_NO = T_BKN.KEI_NO " + "\n");
		super.sql.append("                    AND    T_BKN.LC_CD = T_UKB_GNKSK.LC_CD " + "\n");
		super.sql.append("                    AND    T_BKN.KEI_NO = T_UKB_GNKSK.KEI_NO " + "\n");
		super.sql.append("                    AND    T_BKN.BKN_NO = T_UKB_GNKSK.BKN_NO " + "\n");
		super.sql.append("                    AND    T_BKN.BKN_EDANO = T_UKB_GNKSK.BKN_EDANO " + "\n");
		super.sql.append("                    AND    T_BKN.SKK_KEIJ_HOHO_KBN = T_UKB_GNKSK.KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                    AND    T_KEI.LC_CD = 'LACS' " + "\n");
		super.sql.append("                    AND    T_KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "' " + "\n"); // リースユーザ
		super.sql.append("                          AND SUBSTR('" + this.taisyouFrom + "',1,6) <= T_UKB_GNKSK.KEIJ_YM AND T_UKB_GNKSK.KEIJ_YM <= SUBSTR('" + this.taisyouTo + "',1,6)" + "\n");
		super.sql.append("                    GROUP  BY T_UKB_GNKSK.LC_CD " + "\n");
		super.sql.append("                             ,T_UKB_GNKSK.KEI_NO " + "\n");
		super.sql.append("                             ,T_UKB_GNKSK.BKN_NO " + "\n");
		super.sql.append("                             ,T_UKB_GNKSK.BKN_EDANO " + "\n");
		super.sql.append("                             ,T_UKB_GNKSK.KEIJ_HOHO_KBN) UKB_MIN ON UKB_M.LC_CD = UKB_MIN.LC_CD " + "\n");
		super.sql.append("                                                 AND    UKB_M.KEI_NO = UKB_MIN.KEI_NO " + "\n");
		super.sql.append("                                                 AND    UKB_M.BKN_NO = UKB_MIN.BKN_NO " + "\n");
		super.sql.append("                                                 AND    UKB_M.BKN_EDANO = UKB_MIN.BKN_EDANO " + "\n");
		super.sql.append("                                                 AND    UKB_M.KEIJ_HOHO_KBN = UKB_MIN.KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                                                 AND    UKB_M.KEIJ_YM = UKB_MIN.MIN_KEIJ_YM) " + "\n");
		super.sql.append("MIN_UKB_GNKSK ON MIN_UKB_GNKSK.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("          AND    MIN_UKB_GNKSK.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("          AND    MIN_UKB_GNKSK.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("          AND    MIN_UKB_GNKSK.BKN_EDANO = BKN.BKN_EDANO " + "\n");
		super.sql.append("          AND    MIN_UKB_GNKSK.KEIJ_HOHO_KBN = BKN.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("WHERE   KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "' " + "\n"); // リースユーザ

		if (this.keiyakuNo.trim().length() > 0) {
			super.sql.append("AND    KEI.HYJYO_KEI_NO = '" + this.keiyakuNo + "' " + "\n"); // 契約番号
		}

		super.sql.append("ORDER  BY KEI.HYJYO_KEI_NO " + "\n");
		super.sql.append("         ,KEI.KEI_NO " + "\n");
		super.sql.append("         ,BKN.BKN_NO || CASE " + "\n");
		super.sql.append("              WHEN TRIM(BKN.BKN_EDANO) IS NULL THEN " + "\n");
		super.sql.append("               '' " + "\n");
		super.sql.append("              ELSE " + "\n");
		super.sql.append("               '-' || BKN.BKN_EDANO " + "\n");
		super.sql.append("          END) " + "\n");
		super.sql.append("WHERE   LU_COSMOS_CD = '" + this.leasCompanyCode + "' " + "\n"); // リースユーザ
		super.sql.append("AND    ((KNSHU_YMD <> NVL(KAI_YMD,'A') " + "\n");
		super.sql.append("    AND ((KAI_YMD IS NULL AND '" + this.taisyouFrom + "' <= GNKSK_LAST_YMD) OR (KAI_YMD IS NOT NULL AND KAI_YMD >= '" + this.taisyouFrom + "'))) " + "\n");
		super.sql.append("    OR  (KNSHU_YMD = KAI_YMD AND '" + this.taisyouFrom + "' <= KNSHU_YMD)" + "\n");
		super.sql.append("  OR  ('" + this.taisyouFrom + "' = NVL(KAI_YMD,'0')))" + "\n");
		super.sql.append("  AND  (KNSHU_YMD <= '" + this.taisyouTo + "') " + "\n");
		super.sql.append("  AND  (TRD_HNTE_KEKA_KBN <> 3) " + "\n");

		if (this.keiyakuNo.trim().length() > 0) {
			super.sql.append("AND    HYJYO_KEI_NO = '" + this.keiyakuNo + "' " + "\n"); // 契約番号
		}

		if (super.gtjkeiyakuGaku.equals("0")) {
			super.sql.append("  AND    ((SGK_SSN_KBN IS NULL AND KEI_AMT_KEI > 3000000) " + "\n"); // 契約金額３００万円以下(KEI_AMTは物件から取得しているためKEI_AMT_KEIを使用)
			super.sql.append("      OR   (SGK_SSN_KBN IS NOT NULL AND SGK_SSN_KBN = '0')) " + "\n");
		}

		if (super.gtjleaseKikan.equals("0")) {
			super.sql.append("  AND KEI_TERM > 12 " + "\n"); // リース期間１年以内
		}

		if (super.gtjsaiLease.equals("0")) {
			super.sql.append("  AND RLS_TMS = 0" + "\n"); // 再リース契約
		}

		if (super.gtjtyutoKaiyaku.equals("0")) {
			super.sql.append("  AND KAI_YMD IS NULL" + "\n"); // 中途解約物件
		}

		if ("1".equals(super.commonBean.getControlSisanDsp())) {
			super.sql.append("  AND CTSHK_FLG = '0'" + "\n"); // 固定資産台帳表示制御（売買処理のみ表示）
		}

		super.sql.append("ORDER  BY TAISHO_AC_KIJYUN_CD " + "\n");
		super.sql.append("         ,TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("         ,CTSHK_FLG " + "\n");
		super.sql.append("         ,SSN_SRI_CD " + "\n");
		super.sql.append("         ,HYJYO_KEI_NO " + "\n");
		super.sql.append("         ,BKN_NO " + "\n");
		
		System.out.println(sql);
	}

	/**
	 * ブレイクキー０を取得.
	 * 
	 * @return ブレイクキー０
	 */
	public String getBrakeKey0() {
		return super.getString("BRAKE_KEY0", "");
	}

	/**
	 * ブレイクキー1を取得.
	 * 
	 * @return ブレイクキー1
	 */
	public String getBrakeKey1() {
		return super.getString("BRAKE_KEY1", "");
	}

	/**
	 * ブレイクキー2を取得.
	 * 
	 * @return ブレイクキー2
	 */
	public String getBrakeKey2() {
		return super.getString("BRAKE_KEY2", "");
	}

	/**
	 * ブレイクキー3を取得.
	 * 
	 * @return ブレイクキー3
	 */
	public String getBrakeKey3() {
		return super.getString("BRAKE_KEY3", "");
	}

	/**
	 * ブレイクキー4を取得.
	 * 
	 * @return ブレイクキー4
	 */
	public String getBrakeKey4() {
		return super.getString("BRAKE_KEY4", "");
	}

	/**
	 * 作成日を取得.
	 * 
	 * @return 作成日
	 */
	public String getCreateDate() {
		return super.getString("CREATE_DATE", "");
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
	 * 対象期間開始を取得.
	 * 
	 * @return 対象期間開始
	 */
	public String getStartYmd() {
		return super.getString("START_YMD", "");
	}

	/**
	 * 対象期間終了を取得.
	 * 
	 * @return 対象期間終了
	 */
	public String getEndYmd() {
		return super.getString("END_YMD", "");
	}

	/**
	 * COSMOSCDを取得.
	 * 
	 * @return COSMOSCD
	 */
	public String getCosmosCd() {
		return super.getString("COSMOSCD", "");
	}

	/**
	 * 契約番号を取得.
	 * 
	 * @return 契約番号
	 */
	public String getKeiyakuNo() {
		return super.getString("KEI_NO", "");
	}

	/**
	 * 表示用契約番号を取得.
	 * 
	 * @return 表示用契約番号
	 */
	public String getHyoujiYouKeiyakuNo() {
		return super.getString("HYJYO_KEI_NO", "");
	}

	/**
	 * リース会社を取得.
	 * 
	 * @return リース会社
	 */
	public String getLeasCompanyNm() {
		return super.getString("LEASE_COMPANY", "");
	}

	/**
	 * リースユーザを取得.
	 * 
	 * @return リースユーザ
	 */
	public String getLeasUserNm() {
		return super.getString("LEASE_USER", "");
	}

	/**
	 * 会計基準名を取得.
	 * 
	 * @return 会計基準名
	 */
	public String getAcKijyunName() {
		return super.getString("TAISHO_AC_KIJYUN_NM", "");
	}

	/**
	 * 会計基準コードを取得.
	 * 
	 * @return 会計基準コード
	 */
	public String getAcKijyunCd() {
		return super.getString("TAISHO_AC_KIJYUN_CD", "");
	}

	/**
	 * リース取引分類を取得.
	 * 
	 * @return リース取引分類
	 */
	public String getTrdHnteKekaKbn() {
		return super.getString("TRD_HNTE_KEKA_KBN", "");
	}

	/**
	 * リース取引分類名を取得.
	 * 
	 * @return リース取引分類名
	 */
	public String getTrdHnteKekaName() {
		return super.getString("TRD_HNTE_KEKA_NM", "");
	}

	/**
	 * 会計処理方法を取得.
	 * 
	 * @return 会計処理方法
	 */
	public String getAcShrKbn() {
		return super.getString("CTSHK_FLG", "");
	}

	/**
	 * 会計処理方法名を取得.
	 * 
	 * @return 会計処理方法名
	 */
	public String getAcShrKbnName() {
		return super.getString("AC_SHR_KBN_NM", "");
	}

	/**
	 * 資産区分名を取得.
	 * 
	 * @return 資産区分名
	 */
	public String getSisanKbnName() {
		return super.getString("YUKEI_MUKEI_NM", "");
	}

	/**
	 * 資産区分を取得.
	 * 
	 * @return 資産区分
	 */
	public String getSisanKbn() {
		return super.getString("YUKEI_MUKEI_KBN", "");
	}

	/**
	 * 資産種類名を取得.
	 * 
	 * @return 資産種類名
	 */
	public String getSisanSyuruiName() {
		return super.getString("SSN_SRI_NM", "");
	}

	/**
	 * 資産種類を取得.
	 * 
	 * @return 資産種類
	 */
	public String getSisanSyuruiCd() {
		return super.getString("SSN_SRI_CD", "");
	}

	/**
	 * リース開始日を取得.
	 * 
	 * @return リース開始日
	 */
	public String getLeaseFrom() {
		return super.getString("KNSHU_YMD", "");
	}

	/**
	 * 物件番号を取得.
	 * 
	 * @return 物件番号
	 */
	public String getBukenNo() {
		return super.getString("BKN_NO", "");
	}

	/**
	 * 物件名を取得.
	 * 
	 * @return 物件名
	 */
	public String getBukenNm() {
		return super.getString("BKN_NM", "");
	}

	/**
	 * 数量を取得.
	 * 
	 * @return 数量
	 */
	public String getSuryou() {
		return super.getString("BKN_SU");
	}

	/**
	 * 取得価格を取得.
	 * 
	 * @return 取得価格
	 */
	public long getSyutokuAmt() {
		return super.getLong("SYUTOKU_AMT");
	}

	/**
	 * 償却期間を取得.
	 * 
	 * @return 償却期間
	 */
	public long getSyoukyakuTerm() {
		return super.getLong("SYOUKYAKU_TERM");
	}

	/**
	 * 償却方法区分を取得.
	 * 
	 * @return 償却方法区分
	 */
	public String getSyoukyakuHohoKbn() {
		return super.getString("SKK_KEIJ_HOHO_KBN", "");
	}

	/**
	 * 償却方法名称を取得.
	 * 
	 * @return 償却方法名称
	 */
	public String getSyoukyakuHohoNm() {
		return super.getString("SKK_HOHO_NM", "");
	}

	/**
	 * 償却率を取得.
	 * 
	 * @return 償却率
	 */
	public String getSyoukyakuRt() {
		return super.getString("SKK_RT", "");
	}

	/**
	 * 月数を取得.
	 * 
	 * @return 月数
	 */
	public long getMonthCount() {
		return super.getLong("M_COUNT");
	}

	/**
	 * 前期末簿価を取得.
	 * 
	 * @return 前期末簿価
	 */
	public String getZenkimatsuBoka() {
		return super.getString("ZENKI_BOKA");
	}

	/**
	 * 当月発生を取得.
	 * 
	 * @return 当月発生
	 */
	public String getTougetsuHassei() {
		return super.getString("TOU_HASSEI");
	}

	/**
	 * 当月減少を取得.
	 * 
	 * @return 当月減少
	 */
	public String getTougetsuGensyo() {
		return super.getString("TOU_GENSYO");
	}

	/**
	 * 当月実現を取得.
	 * 
	 * @return 当月実現
	 */
	public String getTougetsuJitsugen() {
		return super.getString("TOU_JITSU");
	}

	/**
	 * 当期末簿価を取得.
	 * 
	 * @return 当期末簿価
	 */
	public String getToukimatsuBoka() {
		return super.getString("TOUKIMATSU_BOKA");
	}
}
