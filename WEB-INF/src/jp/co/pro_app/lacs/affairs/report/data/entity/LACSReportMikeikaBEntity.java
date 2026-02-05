package jp.co.pro_app.lacs.affairs.report.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 帳票出力：未経過リース料期末残高別表Entity.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSReportMikeikaBEntity extends LACSReportEntityBase {

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
	public LACSReportMikeikaBEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSReportBean piReportBean, String piAcStd) {
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

		super.sql.append("      ,KAIKEI_SHYORI " + "\n");
		super.sql.append("      ,START_YMD " + "\n");
		super.sql.append("      ,END_YMD " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '1', MIKEIKA_ZAN01, 0)), 0) S01MIKEIKA_ZAN01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '2', MIKEIKA_ZAN01, 0)), 0) S02MIKEIKA_ZAN01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '3', MIKEIKA_ZAN01, 0)), 0) S03MIKEIKA_ZAN01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '4', MIKEIKA_ZAN01, 0)), 0) S04MIKEIKA_ZAN01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '5', MIKEIKA_ZAN01, 0)), 0) S05MIKEIKA_ZAN01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '6', MIKEIKA_ZAN01, 0)), 0) S06MIKEIKA_ZAN01 " + "\n");
		// 2020/05/22 REP START
		// super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', MIKEIKA_ZAN01, 0)), 0) S07MIKEIKA_ZAN01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '7', MIKEIKA_ZAN01, 0)), 0) S07MIKEIKA_ZAN01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '8', MIKEIKA_ZAN01, 0)), 0) S08MIKEIKA_ZAN01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', MIKEIKA_ZAN01, 0)), 0) S09MIKEIKA_ZAN01 " + "\n");
		// 2020/05/22 REP END

		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '1', MIKEIKA_ZAN02, 0)), 0) S01MIKEIKA_ZAN02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '2', MIKEIKA_ZAN02, 0)), 0) S02MIKEIKA_ZAN02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '3', MIKEIKA_ZAN02, 0)), 0) S03MIKEIKA_ZAN02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '4', MIKEIKA_ZAN02, 0)), 0) S04MIKEIKA_ZAN02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '5', MIKEIKA_ZAN02, 0)), 0) S05MIKEIKA_ZAN02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '6', MIKEIKA_ZAN02, 0)), 0) S06MIKEIKA_ZAN02 " + "\n");
		// 2020/05/22 REP START
		// super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', MIKEIKA_ZAN02, 0)), 0) S07MIKEIKA_ZAN02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '7', MIKEIKA_ZAN02, 0)), 0) S07MIKEIKA_ZAN02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '8', MIKEIKA_ZAN02, 0)), 0) S08MIKEIKA_ZAN02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', MIKEIKA_ZAN02, 0)), 0) S09MIKEIKA_ZAN02 " + "\n");
		// 2020/05/22 REP END

		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '1', MIKEIKA_ZAN01 + MIKEIKA_ZAN02, 0)), 0) S01MIKEIKA_ZAN03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '2', MIKEIKA_ZAN01 + MIKEIKA_ZAN02, 0)), 0) S02MIKEIKA_ZAN03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '3', MIKEIKA_ZAN01 + MIKEIKA_ZAN02, 0)), 0) S03MIKEIKA_ZAN03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '4', MIKEIKA_ZAN01 + MIKEIKA_ZAN02, 0)), 0) S04MIKEIKA_ZAN03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '5', MIKEIKA_ZAN01 + MIKEIKA_ZAN02, 0)), 0) S05MIKEIKA_ZAN03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '6', MIKEIKA_ZAN01 + MIKEIKA_ZAN02, 0)), 0) S06MIKEIKA_ZAN03 " + "\n");
		// 2020/05/22 REP START
		// super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', MIKEIKA_ZAN01 + MIKEIKA_ZAN02, 0)), 0) S07MIKEIKA_ZAN03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '7', MIKEIKA_ZAN01 + MIKEIKA_ZAN02, 0)), 0) S07MIKEIKA_ZAN03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '8', MIKEIKA_ZAN01 + MIKEIKA_ZAN02, 0)), 0) S08MIKEIKA_ZAN03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', MIKEIKA_ZAN01 + MIKEIKA_ZAN02, 0)), 0) S09MIKEIKA_ZAN03 " + "\n");
		// 2020/05/22 REP END

		super.sql.append("      ,NVL(SUM(MIKEIKA_ZAN01), 0) MIKEIKA_ZAN01 " + "\n");
		super.sql.append("      ,NVL(SUM(MIKEIKA_ZAN02), 0) MIKEIKA_ZAN02 " + "\n");
		super.sql.append("      ,NVL(SUM(MIKEIKA_ZAN01), 0) + NVL(SUM(MIKEIKA_ZAN02), 0) MIKEIKA_ZAN03 " + "\n");

		super.sql.append("      ,MAX(TO_CHAR(SYSDATE, 'YYYYMMDD')) CREATE_DATE " + "\n");
		super.sql.append("      ,'" + super.kaikeiSyori + "' AC_SHR_KBN " + "\n");
/* 2014/05/19 START */
		super.sql.append("      ,TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("      ,LEASE_BUNRUI " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '1', MIKEIKA_STAX01, 0)), 0) S01MIKEIKA_STAX01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '2', MIKEIKA_STAX01, 0)), 0) S02MIKEIKA_STAX01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '3', MIKEIKA_STAX01, 0)), 0) S03MIKEIKA_STAX01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '4', MIKEIKA_STAX01, 0)), 0) S04MIKEIKA_STAX01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '5', MIKEIKA_STAX01, 0)), 0) S05MIKEIKA_STAX01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '6', MIKEIKA_STAX01, 0)), 0) S06MIKEIKA_STAX01 " + "\n");
		// 2020/05/22 REP START
		// super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', MIKEIKA_STAX01, 0)), 0) S07MIKEIKA_STAX01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '7', MIKEIKA_STAX01, 0)), 0) S07MIKEIKA_STAX01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '8', MIKEIKA_STAX01, 0)), 0) S08MIKEIKA_STAX01 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', MIKEIKA_STAX01, 0)), 0) S09MIKEIKA_STAX01 " + "\n");
		// 2020/05/22 REP END

		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '1', MIKEIKA_STAX02, 0)), 0) S01MIKEIKA_STAX02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '2', MIKEIKA_STAX02, 0)), 0) S02MIKEIKA_STAX02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '3', MIKEIKA_STAX02, 0)), 0) S03MIKEIKA_STAX02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '4', MIKEIKA_STAX02, 0)), 0) S04MIKEIKA_STAX02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '5', MIKEIKA_STAX02, 0)), 0) S05MIKEIKA_STAX02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '6', MIKEIKA_STAX02, 0)), 0) S06MIKEIKA_STAX02 " + "\n");
		// 2020/05/22 REP START
		// super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', MIKEIKA_STAX02, 0)), 0) S07MIKEIKA_STAX02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '7', MIKEIKA_STAX02, 0)), 0) S07MIKEIKA_STAX02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '8', MIKEIKA_STAX02, 0)), 0) S08MIKEIKA_STAX02 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', MIKEIKA_STAX02, 0)), 0) S09MIKEIKA_STAX02 " + "\n");
		// 2020/05/22 REP END

		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '1', MIKEIKA_STAX01 + MIKEIKA_STAX02, 0)), 0) S01MIKEIKA_STAX03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '2', MIKEIKA_STAX01 + MIKEIKA_STAX02, 0)), 0) S02MIKEIKA_STAX03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '3', MIKEIKA_STAX01 + MIKEIKA_STAX02, 0)), 0) S03MIKEIKA_STAX03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '4', MIKEIKA_STAX01 + MIKEIKA_STAX02, 0)), 0) S04MIKEIKA_STAX03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '5', MIKEIKA_STAX01 + MIKEIKA_STAX02, 0)), 0) S05MIKEIKA_STAX03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '6', MIKEIKA_STAX01 + MIKEIKA_STAX02, 0)), 0) S06MIKEIKA_STAX03 " + "\n");
		// 2020/05/22 REP START
		// super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', MIKEIKA_STAX01 + MIKEIKA_STAX02, 0)), 0) S07MIKEIKA_STAX03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '7', MIKEIKA_STAX01 + MIKEIKA_STAX02, 0)), 0) S07MIKEIKA_STAX03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '8', MIKEIKA_STAX01 + MIKEIKA_STAX02, 0)), 0) S08MIKEIKA_STAX03 " + "\n");
		super.sql.append("      ,NVL(SUM(DECODE(SSN_SRI_CD, '9', MIKEIKA_STAX01 + MIKEIKA_STAX02, 0)), 0) S09MIKEIKA_STAX03 " + "\n");
		// 2020/05/22 REP END

		super.sql.append("      ,NVL(SUM(MIKEIKA_STAX01), 0) MIKEIKA_STAX01 " + "\n");
		super.sql.append("      ,NVL(SUM(MIKEIKA_STAX02), 0) MIKEIKA_STAX02 " + "\n");
		super.sql.append("      ,NVL(SUM(MIKEIKA_STAX01), 0) + NVL(SUM(MIKEIKA_STAX02), 0) MIKEIKA_STAX03 " + "\n");
/* 2014/05/19 END   */
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

/* 2014/05/19 START */
		super.sql.append("              ,CASE " + "\n");
		/* REPLACE START*/
		/* super.sql.append("                   WHEN KB.TRD_HNTE_KEKA_KBN = '2' AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n"); */
		super.sql.append("                   WHEN (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		/* REPLACE END  */
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
		/* REPLACE START*/
		/* super.sql.append("                   WHEN KB.TRD_HNTE_KEKA_KBN = '2' AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n"); */
		super.sql.append("                   WHEN (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		/* REPLACE END  */
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

		/* ADD     START*/
		super.sql.append("              ,CASE " + "\n");
		super.sql.append("                   WHEN (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("                       CASE " + "\n");
		super.sql.append("                           WHEN KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("                               0 " + "\n");
		super.sql.append("                           ELSE " + "\n");
		super.sql.append("                               (SELECT SUM(CASE WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN FKN_TNKI.LAMT_STAX " + "\n");
		super.sql.append("								                  ELSE FKN_TNKI.YTE_LAMT_STAX " + "\n");
		super.sql.append("							                 END) " + "\n");
		super.sql.append("                                FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("                                WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEIJ_YM BETWEEN NEXT_START_KEIJ_YM AND NEXT_END_KEIJ_YM) " + "\n");
		super.sql.append("                       END " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("               END MIKEIKA_STAX01 " + "\n");
		super.sql.append("              ,CASE " + "\n");
		super.sql.append("                   WHEN (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("                       CASE " + "\n");
		super.sql.append("                           WHEN KB.KAI_YMD < START_YMD OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("                               0 " + "\n");
		super.sql.append("                           ELSE " + "\n");
		super.sql.append("                               (SELECT SUM(CASE WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN FKN_TNKI.LAMT_STAX " + "\n");
		super.sql.append("								                  ELSE FKN_TNKI.YTE_LAMT_STAX " + "\n");
		super.sql.append("							                 END) " + "\n");
		super.sql.append("                                FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("                                WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("                                AND    FKN_TNKI.KEIJ_YM >= OVER_NEXT_START_KEIJ_YM) " + "\n");
		super.sql.append("                       END " + "\n");
		super.sql.append("                   ELSE " + "\n");
		super.sql.append("                       0 " + "\n");
		super.sql.append("               END MIKEIKA_STAX02 " + "\n");

		super.sql.append("              ,KB.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("              ,M_TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_NM LEASE_BUNRUI " + "\n");
		/* ADD     END  */
/* 2014/05/19 END   */

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
		/* 2014/05/19 START */
		super.sql.append("        JOIN   M_TRD_HNTE_KEKA_KBN ON KB.TRD_HNTE_KEKA_KBN = M_TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN " + "\n");
		/* 2014/05/19 END   */
		super.sql.append("        WHERE  KB.KNSHU_YMD <= KB.END_YMD " + "\n");
		super.sql.append("AND  (KB.TRD_HNTE_KEKA_KBN IN ('1', '2') OR (KB.TRD_HNTE_KEKA_KBN = '3' AND KB.CYT_KAI_KANO_KBN = '0')) " + "\n");
		//20140519 REP START
		super.sql.append("AND  (((KB.KNSHU_YMD <> NVL(KB.KAI_YMD,'A') AND (KAI_YMD IS NULL AND KB.START_YMD <= GREATEST(KB.MRYO_YMD, NVL2(KB.GNKSK_KEIJ_YM_MAX,KB.GNKSK_KEIJ_YM_MAX || '99',KB.MRYO_YMD))) OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) " + "\n");
		//super.sql.append("AND  (((KB.KNSHU_YMD <> NVL(KB.KAI_YMD,'A') AND (KAI_YMD IS NULL AND KB.START_YMD <= GREATEST(KB.MRYO_YMD, KB.GNKSK_KEIJ_YM_MAX || '99')) OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) " + "\n");
		//20140519 REP END
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

		//20140519 ADD START
		if ("1".equals(super.commonBean.getControlMikeikaBStaxDsp())) {
		}else{
			super.sql.append("WHERE TRD_HNTE_KEKA_KBN = '" + LACSDefine.TorihikiHanteiKekkaKbn.ITEN_GAI_FINANCE_LEAS_2 + "'\n");			
		}
		//20140519 ADD END
		super.sql.append("GROUP  BY LU_COSMOS_CD " + "\n");
		super.sql.append("         ,LU_NM " + "\n");
		super.sql.append("         ,LC_NM " + "\n");
		super.sql.append("         ,KAIKEI_SHYORI " + "\n");
		super.sql.append("         ,START_YMD " + "\n");
		super.sql.append("         ,END_YMD " + "\n");
/* 2014/05/19 START */
		super.sql.append("         ,TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("         ,LEASE_BUNRUI " + "\n");
		super.sql.append("ORDER BY TRD_HNTE_KEKA_KBN " + "\n");		
/* 2014/05/19 END   */
		System.out.println(super.sql);
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
	 * 未経過リース料期末残高相当額（一年以内）（建物）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（建物）
	 */
	public long getS1MikeikaZan01() {
		return super.getLong("S01MIKEIKA_ZAN01");
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（建物付属設備）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（建物付属設備）
	 */
	public long getS2MikeikaZan01() {
		return super.getLong("S02MIKEIKA_ZAN01");
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（構築物）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（構築物）
	 */
	public long getS3MikeikaZan01() {
		return super.getLong("S03MIKEIKA_ZAN01");
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（機械および装置）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（機械および装置）
	 */
	public long getS4MikeikaZan01() {
		return super.getLong("S04MIKEIKA_ZAN01");
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（船舶）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（船舶）
	 */
	public long getS5MikeikaZan01() {
		return super.getLong("S05MIKEIKA_ZAN01");
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（航空機）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（航空機）
	 */
	public long getS6MikeikaZan01() {
		return super.getLong("S06MIKEIKA_ZAN01");
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（車輛および運搬具）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（車輛および運搬具）
	 */
	public long getS7MikeikaZan01() {
		return super.getLong("S07MIKEIKA_ZAN01");
	}

	// 2020/05/22 ADD START
	/**
	 * 未経過リース料期末残高相当額（一年以内）（工具器具備品）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（工具器具備品）
	 */
	public long getS8MikeikaZan01() {
		return super.getLong("S08MIKEIKA_ZAN01");
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（無形固定資産）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（無形固定資産）
	 */
	public long getS9MikeikaZan01() {
		return super.getLong("S09MIKEIKA_ZAN01");
	}
	// 2020/05/22 ADD END

	/**
	 * 未経過リース料期末残高相当額（一年超）（建物）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（建物）
	 */
	public long getS1MikeikaZan02() {
		return super.getLong("S01MIKEIKA_ZAN02");
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（建物付属設備）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（建物付属設備）
	 */
	public long getS2MikeikaZan02() {
		return super.getLong("S02MIKEIKA_ZAN02");
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（構築物）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（構築物）
	 */
	public long getS3MikeikaZan02() {
		return super.getLong("S03MIKEIKA_ZAN02");
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（機械および装置）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（機械および装置）
	 */
	public long getS4MikeikaZan02() {
		return super.getLong("S04MIKEIKA_ZAN02");
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（船舶）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（船舶）
	 */
	public long getS5MikeikaZan02() {
		return super.getLong("S05MIKEIKA_ZAN02");
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（航空機）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（航空機）
	 */
	public long getS6MikeikaZan02() {
		return super.getLong("S06MIKEIKA_ZAN02");
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（車輛および運搬具）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（車輛および運搬具）
	 */
	public long getS7MikeikaZan02() {
		return super.getLong("S07MIKEIKA_ZAN02");
	}
	
	// 2020/05/22 ADD START
	/**
	 * 未経過リース料期末残高相当額（一年超）（工具器具備品）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（工具器具備品）
	 */
	public long getS8MikeikaZan02() {
		return super.getLong("S08MIKEIKA_ZAN02");
	}
	
	/**
	 * 未経過リース料期末残高相当額（一年超）（無形固定資産）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（無形固定資産）
	 */
	public long getS9MikeikaZan02() {
		return super.getLong("S09MIKEIKA_ZAN02");
	}
	// 2020/05/22 ADD END

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
	 * 会計処理方法を取得.
	 * 
	 * @return 会計処理方法
	 */
	public String getAcShrKbnName() {
		return super.getString("KAIKEI_SHYORI");
	}

/* 2014/05/19 START */
	/**
	 * 取引判定結果を取得.
	 * 
	 * @return 取引判定結果
	 */
	public String getTrdHnteKekaKbn() {
		return super.getString("TRD_HNTE_KEKA_KBN");
	}

	/**
	 * 取引判定結果名称を取得.
	 * 
	 * @return 取引判定結果名称
	 */
	public String getLeaseBunrui() {
		return super.getString("LEASE_BUNRUI");
	}

	/**
	 * 消費税（一年以内）（建物）を取得.
	 * 
	 * @return 消費税（一年以内）（建物）
	 */
	public long getS1MikeikaStax01() {
		return super.getLong("S01MIKEIKA_STAX01");
	}

	/**
	 * 消費税（一年以内）（建物付属設備）を取得.
	 * 
	 * @return 消費税（一年以内）（建物付属設備）
	 */
	public long getS2MikeikaStax01() {
		return super.getLong("S02MIKEIKA_STAX01");
	}

	/**
	 * 消費税（一年以内）（構築物）を取得.
	 * 
	 * @return 消費税（一年以内）（構築物）
	 */
	public long getS3MikeikaStax01() {
		return super.getLong("S03MIKEIKA_STAX01");
	}

	/**
	 * 消費税（一年以内）（機械および装置）を取得.
	 * 
	 * @return 消費税（一年以内）（機械および装置）
	 */
	public long getS4MikeikaStax01() {
		return super.getLong("S04MIKEIKA_STAX01");
	}

	/**
	 * 消費税（一年以内）（船舶）を取得.
	 * 
	 * @return 消費税（一年以内）（船舶）
	 */
	public long getS5MikeikaStax01() {
		return super.getLong("S05MIKEIKA_STAX01");
	}

	/**
	 * 消費税（一年以内）（航空機）を取得.
	 * 
	 * @return 消費税（一年以内）（航空機）
	 */
	public long getS6MikeikaStax01() {
		return super.getLong("S06MIKEIKA_STAX01");
	}

	/**
	 * 消費税（一年以内）（車輛および運搬具）を取得.
	 * 
	 * @return 消費税（一年以内）（車輛および運搬具）
	 */
	public long getS7MikeikaStax01() {
		return super.getLong("S07MIKEIKA_STAX01");
	}

	// 2020/05/22 ADD START
	/**
	 * 消費税（一年以内）（工具器具備品）を取得.
	 * 
	 * @return 消費税（一年以内）（工具器具備品）
	 */
	public long getS8MikeikaStax01() {
		return super.getLong("S08MIKEIKA_STAX01");
	}

	/**
	 * 消費税（一年以内）（無形固定資産）を取得.
	 * 
	 * @return 消費税（一年以内）（無形固定資産）
	 */
	public long getS9MikeikaStax01() {
		return super.getLong("S09MIKEIKA_STAX01");
	}
	// 2020/05/22 ADD END

	/**
	 * 消費税（一年超）（建物）を取得.
	 * 
	 * @return 消費税（一年超）（建物）
	 */
	public long getS1MikeikaStax02() {
		return super.getLong("S01MIKEIKA_STAX02");
	}

	/**
	 * 消費税（一年超）（建物付属設備）を取得.
	 * 
	 * @return 消費税（一年超）（建物付属設備）
	 */
	public long getS2MikeikaStax02() {
		return super.getLong("S02MIKEIKA_STAX02");
	}

	/**
	 * 消費税（一年超）（構築物）を取得.
	 * 
	 * @return 消費税（一年超）（構築物）
	 */
	public long getS3MikeikaStax02() {
		return super.getLong("S03MIKEIKA_STAX02");
	}

	/**
	 * 消費税（一年超）（機械および装置）を取得.
	 * 
	 * @return 消費税（一年超）（機械および装置）
	 */
	public long getS4MikeikaStax02() {
		return super.getLong("S04MIKEIKA_STAX02");
	}

	/**
	 * 消費税（一年超）（船舶）を取得.
	 * 
	 * @return 消費税（一年超）（船舶）
	 */
	public long getS5MikeikaStax02() {
		return super.getLong("S05MIKEIKA_STAX02");
	}

	/**
	 * 消費税（一年超）（航空機）を取得.
	 * 
	 * @return 消費税（一年超）（航空機）
	 */
	public long getS6MikeikaStax02() {
		return super.getLong("S06MIKEIKA_STAX02");
	}

	/**
	 * 消費税（一年超）（車輛および運搬具）を取得.
	 * 
	 * @return 消費税（一年超）（車輛および運搬具）
	 */
	public long getS7MikeikaStax02() {
		return super.getLong("S07MIKEIKA_STAX02");
	}

	// 2020/05/22 ADD START
	/**
	 * 消費税（一年超）（工具器具備品）を取得.
	 * 
	 * @return 消費税（一年超）（工具器具備品）
	 */
	public long getS8MikeikaStax02() {
		return super.getLong("S08MIKEIKA_STAX02");
	}

	/**
	 * 消費税（一年超）（無形固定資産）を取得.
	 * 
	 * @return 消費税（一年超）（無形固定資産）
	 */
	public long getS9MikeikaStax02() {
		return super.getLong("S09MIKEIKA_STAX02");
	}
// 2020/05/22 ADD END

	/**
	 * 消費税（一年以内）を取得.
	 * 
	 * @return 消費税（一年以内）
	 */
	public long getMikeikaStax01() {
		return super.getLong("MIKEIKA_STAX01");
	}

	/**
	 * 消費税（一年超）を取得.
	 * 
	 * @return 消費税（一年超）
	 */
	public long getMikeikaStax02() {
		return super.getLong("MIKEIKA_STAX02");
	}

	/**
	 * 消費税（合計）を取得.
	 * 
	 * @return 消費税（合計）
	 */
	public long getMikeikaStax03() {
		return super.getLong("MIKEIKA_STAX03");
	}
/* 2014/05/19 END   */

}
