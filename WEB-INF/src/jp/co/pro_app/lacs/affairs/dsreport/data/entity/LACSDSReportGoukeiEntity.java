package jp.co.pro_app.lacs.affairs.dsreport.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.dsreport.bean.LACSDSReportBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * í†ï[èoóÕÅFÉäÅ[ÉXâÔåvíçãLçáåvï\Entity.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSDSReportGoukeiEntity extends LACSDSReportEntityBase {

	/**
	 * ÉRÉìÉXÉgÉâÉNÉ^.
	 * 
	 * @param piModel
	 *            ÉÇÉfÉã
	 * @param piCommonBean
	 *            LACSã§í Bean
	 * @param piReportBean
	 *            í†ï[èoóÕBean
	 */
	public LACSDSReportGoukeiEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSDSReportBean piReportBean) {
		super(piModel, piCommonBean, piReportBean);
	}

	/**
	 * ÇrÇpÇkÇê∂ê¨.
	 */
	protected void makeSQL() {
		super.sql = new StringBuffer();

		super.sql.append("SELECT TMP.START_YMD " + "\n");
		super.sql.append("	  ,TMP.END_YMD " + "\n");
		super.sql.append("	  ,TMP.END_KEIJ_YM " + "\n");
		super.sql.append("	  ,TMP.FIRST_START_KEIJ_YM " + "\n");
		super.sql.append("	  ,TMP.FIRST_END_KEIJ_YM " + "\n");
		super.sql.append("	  ,TMP.SECOND_START_KEIJ_YM " + "\n");
		super.sql.append("	  ,TMP.SECOND_END_KEIJ_YM " + "\n");
		super.sql.append("	  ,TMP.THIRD_START_KEIJ_YM " + "\n");
		super.sql.append("	  ,TMP.THIRD_END_KEIJ_YM " + "\n");
		super.sql.append("	  ,TMP.FOURTH_START_KEIJ_YM " + "\n");
		super.sql.append("	  ,TMP.FOURTH_END_KEIJ_YM " + "\n");
		super.sql.append("	  ,TMP.FIFTH_START_KEIJ_YM " + "\n");
		super.sql.append("	  ,TMP.FIFTH_END_KEIJ_YM " + "\n");
		super.sql.append("	  ,TMP.OVER_START_KEIJ_YM " + "\n");
		super.sql.append("	  ,TO_CHAR(SYSDATE, 'YYYYMMDD') CREATE_DATE " + "\n");
		super.sql.append("	  ,SUM(TMP.B1_GFL_A_LAMT) B1_GFL_A_LAMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B1_GFL_B_MTMR_ZANZON_AMT) B1_GFL_B_MTMR_ZANZON_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B1_GFL_C_HSE_RSK) B1_GFL_C_HSE_RSK " + "\n");
		super.sql.append("	  ,SUM(TMP.B1_GFL_D_IJI_KANRI_AMT) B1_GFL_D_IJI_KANRI_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B1_GFL_E_EKIM_TEIK_AMT) B1_GFL_E_EKIM_TEIK_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B1_GFL_F_GNPN_AMT) B1_GFL_F_GNPN_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B2_FL_FIRST_AMT) B2_FL_FIRST_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B2_FL_SECOND_AMT) B2_FL_SECOND_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B2_FL_THIRD_AMT) B2_FL_THIRD_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B2_FL_FOURTH_AMT) B2_FL_FOURTH_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B2_FL_FIFTH_AMT) B2_FL_FIFTH_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B2_FL_OVER_AMT) B2_FL_OVER_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B2_GFL_FIRST_AMT) B2_GFL_FIRST_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B2_GFL_SECOND_AMT) B2_GFL_SECOND_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B2_GFL_THIRD_AMT) B2_GFL_THIRD_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B2_GFL_FOURTH_AMT) B2_GFL_FOURTH_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B2_GFL_FIFTH_AMT) B2_GFL_FIFTH_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B2_GFL_OVER_AMT) B2_GFL_OVER_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B2_GFL_FIFTH_AMT) B2_GFL_FIFTH_AMT " + "\n");
		super.sql.append("	  ,SUM(TMP.B2_GFL_OVER_AMT) B2_GFL_OVER_AMT " + "\n");
		super.sql.append("    ,SUM(TMP.B3_OP_FIRST_AMT) B3_OP_FIRST_AMT " + "\n");
		super.sql.append("    ,SUM(TMP.B3_OP_OVER_AMT) B3_OP_OVER_AMT " + "\n");
		super.sql.append("    ,SUM(TMP.B3_OP_FIRST_AMT) + SUM(TMP.B3_OP_OVER_AMT) B3_OP_TOTAL_AMT " + "\n");
		super.sql.append("FROM   (SELECT KB.LC_CD " + "\n");
		super.sql.append("			  ,KB.KEI_NO " + "\n");
		super.sql.append("			  ,KB.START_YMD " + "\n");
		super.sql.append("			  ,KB.END_YMD " + "\n");
		super.sql.append("			  ,KB.END_KEIJ_YM " + "\n");
		super.sql.append("			  ,KB.FIRST_START_KEIJ_YM " + "\n");
		super.sql.append("			  ,KB.FIRST_END_KEIJ_YM " + "\n");
		super.sql.append("			  ,KB.SECOND_START_KEIJ_YM " + "\n");
		super.sql.append("			  ,KB.SECOND_END_KEIJ_YM " + "\n");
		super.sql.append("			  ,KB.THIRD_START_KEIJ_YM " + "\n");
		super.sql.append("			  ,KB.THIRD_END_KEIJ_YM " + "\n");
		super.sql.append("			  ,KB.FOURTH_START_KEIJ_YM " + "\n");
		super.sql.append("			  ,KB.FOURTH_END_KEIJ_YM " + "\n");
		super.sql.append("			  ,KB.FIFTH_START_KEIJ_YM " + "\n");
		super.sql.append("			  ,KB.FIFTH_END_KEIJ_YM " + "\n");
		super.sql.append("			  ,KB.OVER_START_KEIJ_YM " + "\n");
		super.sql.append("			  ,KB.KAI_START_KEIJ_YM " + "\n");
		super.sql.append("			  ,KB.BKN_NO " + "\n");
		super.sql.append("			  ,KB.BKN_EDANO " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '2' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.LAMT " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_LAMT " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM > KB.END_KEIJ_YM), 0) " + "\n");
		super.sql.append("					+ " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B1_GFL_A_LAMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '2' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B1_GFL_B_MTMR_ZANZON_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '2' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.HSE_RSK " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_HSE_RSK " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_DETAIL FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_HOHO_KBN = KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM > KB.END_KEIJ_YM), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B1_GFL_C_HSE_RSK " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '2' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.IPN_EKM_TEIK_HYO + FKN_TNKI.SHRY_EKM_TEIK_HYO " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_IPN_EKM_TEIK_HYO + FKN_TNKI.YTE_SHRY_EKM_TEIK_HYO " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM > KB.END_KEIJ_YM), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B1_GFL_E_EKIM_TEIK_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '2' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.ENT_SHOHYO_KZI " + "\n");
		super.sql.append("										 + FKN_TNKI.ENT_SHOHYO_HKZI " + "\n");
		super.sql.append("										 + FKN_TNKI.GTAX " + "\n");
		super.sql.append("										 + FKN_TNKI.CTAX " + "\n");
		super.sql.append("										 + FKN_TNKI.JTAX " + "\n");
		super.sql.append("										 + FKN_TNKI.JBSK_HKN " + "\n");
		super.sql.append("										 + FKN_TNKI.NNI_HKN " + "\n");
		super.sql.append("										 + FKN_TNKI.RCYCL_RYO_KNRI_AMT " + "\n");
		super.sql.append("										 + FKN_TNKI.DOSO " + "\n");
		super.sql.append("										 + FKN_TNKI.KOZEI " + "\n");
		super.sql.append("										 + FKN_TNKI.OTH_CST " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_ENT_SHOHYO_KZI " + "\n");
		super.sql.append("										 + FKN_TNKI.YTE_ENT_SHOHYO_HKZI " + "\n");
		super.sql.append("										 + FKN_TNKI.YTE_GTAX " + "\n");
		super.sql.append("										 + FKN_TNKI.YTE_CTAX " + "\n");
		super.sql.append("										 + FKN_TNKI.YTE_JTAX " + "\n");
		super.sql.append("										 + FKN_TNKI.YTE_JBSK_HKN " + "\n");
		super.sql.append("										 + FKN_TNKI.YTE_NNI_HKN " + "\n");
		super.sql.append("										 + FKN_TNKI.YTE_RCYCL_RYO_KNRI_AMT " + "\n");
		super.sql.append("										 + FKN_TNKI.YTE_DOSO " + "\n");
		super.sql.append("										 + FKN_TNKI.YTE_KOZEI " + "\n");
		super.sql.append("										 + FKN_TNKI.YTE_OTH_CST " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM > KB.END_KEIJ_YM), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B1_GFL_D_IJI_KANRI_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '2' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.TGTU_GNPN " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_TGTU_GNPN " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_DETAIL FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_HOHO_KBN = KB.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM > KB.END_KEIJ_YM), 0) " + "\n");
		super.sql.append("					+ " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B1_GFL_F_GNPN_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '1' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.LAMT " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_LAMT " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN FIRST_START_KEIJ_YM AND FIRST_END_KEIJ_YM), 0) " + "\n");
		super.sql.append("					+ " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN FIRST_START_KEIJ_YM AND FIRST_END_KEIJ_YM " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B2_FL_FIRST_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '1' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.LAMT " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_LAMT " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN SECOND_START_KEIJ_YM AND SECOND_END_KEIJ_YM), 0) " + "\n");
		super.sql.append("					+ " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN SECOND_START_KEIJ_YM AND SECOND_END_KEIJ_YM " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B2_FL_SECOND_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '1' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.LAMT " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_LAMT " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN THIRD_START_KEIJ_YM AND THIRD_END_KEIJ_YM), 0) " + "\n");
		super.sql.append("					+ " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN THIRD_START_KEIJ_YM AND THIRD_END_KEIJ_YM " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B2_FL_THIRD_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '1' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.LAMT " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_LAMT " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN FOURTH_START_KEIJ_YM AND FOURTH_END_KEIJ_YM), 0) " + "\n");
		super.sql.append("					+ " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN FOURTH_START_KEIJ_YM AND FOURTH_END_KEIJ_YM " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B2_FL_FOURTH_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '1' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.LAMT " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_LAMT " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN FIFTH_START_KEIJ_YM AND FIFTH_END_KEIJ_YM), 0) " + "\n");
		super.sql.append("					+ " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN FIFTH_START_KEIJ_YM AND FIFTH_END_KEIJ_YM " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B2_FL_FIFTH_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '1' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.LAMT " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_LAMT " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM >= OVER_START_KEIJ_YM), 0) " + "\n");
		super.sql.append("					+ " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM >= OVER_START_KEIJ_YM " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B2_FL_OVER_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '2' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.LAMT " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_LAMT " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN FIRST_START_KEIJ_YM AND FIRST_END_KEIJ_YM), 0) " + "\n");
		super.sql.append("					+ " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN FIRST_START_KEIJ_YM AND FIRST_END_KEIJ_YM " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B2_GFL_FIRST_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '2' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.LAMT " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_LAMT " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN SECOND_START_KEIJ_YM AND SECOND_END_KEIJ_YM), 0) " + "\n");
		super.sql.append("					+ " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN SECOND_START_KEIJ_YM AND SECOND_END_KEIJ_YM " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B2_GFL_SECOND_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '2' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.LAMT " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_LAMT " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN THIRD_START_KEIJ_YM AND THIRD_END_KEIJ_YM), 0) " + "\n");
		super.sql.append("					+ " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN THIRD_START_KEIJ_YM AND THIRD_END_KEIJ_YM " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B2_GFL_THIRD_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '2' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.LAMT " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_LAMT " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN FOURTH_START_KEIJ_YM AND FOURTH_END_KEIJ_YM), 0) " + "\n");
		super.sql.append("					+ " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN FOURTH_START_KEIJ_YM AND FOURTH_END_KEIJ_YM " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B2_GFL_FOURTH_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '2' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.LAMT " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_LAMT " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN FIFTH_START_KEIJ_YM AND FIFTH_END_KEIJ_YM), 0) " + "\n");
		super.sql.append("					+ " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN FIFTH_START_KEIJ_YM AND FIFTH_END_KEIJ_YM " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B2_GFL_FIFTH_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '2' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.LAMT " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_LAMT " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM >= OVER_START_KEIJ_YM), 0) " + "\n");
		super.sql.append("					+ " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM >= OVER_START_KEIJ_YM " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B2_GFL_OVER_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '3' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.LAMT " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_LAMT " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN FIRST_START_KEIJ_YM AND FIRST_END_KEIJ_YM), 0) " + "\n");
		super.sql.append("					+ " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM BETWEEN FIRST_START_KEIJ_YM AND FIRST_END_KEIJ_YM " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B3_OP_FIRST_AMT " + "\n");
		super.sql.append("			  ,CASE " + "\n");
		super.sql.append("				   WHEN KB.TRD_HNTE_KEKA_KBN = '3' " + "\n");
		super.sql.append("						AND (KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD)) THEN " + "\n");
		super.sql.append("					CASE " + "\n");
		super.sql.append("				   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("						OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("						OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("					0 " + "\n");
		super.sql.append("				   ELSE " + "\n");
		super.sql.append("					NVL((SELECT SUM(CASE " + "\n");
		super.sql.append("									   WHEN FKN_TNKI.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN " + "\n");
		super.sql.append("										FKN_TNKI.LAMT " + "\n");
		super.sql.append("									   ELSE " + "\n");
		super.sql.append("										FKN_TNKI.YTE_LAMT " + "\n");
		super.sql.append("								   END) " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM >= SECOND_START_KEIJ_YM), 0) " + "\n");
		super.sql.append("					+ " + "\n");
		super.sql.append("					NVL((SELECT BKN.JSH_ZANK + BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("						FROM   T_UKB_TNKI_HEAD FKN_TNKI " + "\n");
		super.sql.append("							  ,T_BKN           BKN " + "\n");
		super.sql.append("						WHERE  FKN_TNKI.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM >= SECOND_START_KEIJ_YM " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEIJ_YM = KB.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("						AND    FKN_TNKI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("						AND    FKN_TNKI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("						AND    FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO), 0) " + "\n");
		super.sql.append("			   END ELSE 0 END B3_OP_OVER_AMT " + "\n");
		super.sql.append("		FROM   (SELECT KEI.LC_CD " + "\n");
		super.sql.append("					  ,KEI.KEI_NO " + "\n");
		super.sql.append("					  ,KEI.KNSHU_YMD " + "\n");
		super.sql.append("					  ,KEI.MRYO_YMD " + "\n");
		super.sql.append("					  ,KEI.KAI_YMD " + "\n");
		super.sql.append("					  ,TO_CHAR(TO_DATE(KEI.KAI_YMD, 'YYYYMMDD') - 1, 'YYYYMMDD') KAI_YMD_PRE " + "\n");
		super.sql.append("					  ,KEI.START_YMD " + "\n");
		super.sql.append("					  ,KEI.END_YMD " + "\n");
		super.sql.append("					  ,KEI.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("					  ,BKN.BKN_NO " + "\n");
		super.sql.append("					  ,BKN.BKN_EDANO " + "\n");
		super.sql.append("					  ,BKN.RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("					  ,KEI.END_KEIJ_YM " + "\n");
		super.sql.append("					  ,KEI.FIRST_START_KEIJ_YM " + "\n");
		super.sql.append("					  ,KEI.FIRST_END_KEIJ_YM " + "\n");
		super.sql.append("					  ,KEI.SECOND_START_KEIJ_YM " + "\n");
		super.sql.append("					  ,KEI.SECOND_END_KEIJ_YM " + "\n");
		super.sql.append("					  ,KEI.THIRD_START_KEIJ_YM " + "\n");
		super.sql.append("					  ,KEI.THIRD_END_KEIJ_YM " + "\n");
		super.sql.append("					  ,KEI.FOURTH_START_KEIJ_YM " + "\n");
		super.sql.append("					  ,KEI.FOURTH_END_KEIJ_YM " + "\n");
		super.sql.append("					  ,KEI.FIFTH_START_KEIJ_YM " + "\n");
		super.sql.append("					  ,KEI.FIFTH_END_KEIJ_YM " + "\n");
		super.sql.append("					  ,KEI.OVER_START_KEIJ_YM " + "\n");
		super.sql.append("					  ,KEI.MRYO_KEIJ_YM " + "\n");
		super.sql.append("					  ,KEI.KAI_START_KEIJ_YM " + "\n");
		super.sql.append("					  ,BKN.FKN_KEIJ_YM_MAX " + "\n");
		super.sql.append("					  ,BKN.FKN_KEIJ_YM_END " + "\n");
		super.sql.append("					  ,NVL(KEI.KAI_KEIJ_YM, '999999') KAI_KEIJ_YM " + "\n");
		super.sql.append("					  ,GREATEST(BKN.FKN_KEIJ_YM_MAX, DECODE(KAI_YMD, NULL, KEI.MRYO_KEIJ_YM, '000000')) FKN_KEIJ_YM_GREATEST " + "\n");
		super.sql.append("					  ,LEAST(GREATEST(BKN.FKN_KEIJ_YM_MAX, DECODE(KAI_YMD, NULL, KEI.MRYO_KEIJ_YM, '000000')), KEI.FIRST_END_KEIJ_YM, NVL(KEI.KAI_KEIJ_YM, '999999')) FKN_KEIJ_YM_LAST " + "\n");
		super.sql.append("					  ,CASE " + "\n");
		super.sql.append("						   WHEN SUBSTR(KEI.MRYO_YMD, 1, 6) >= FKN_KEIJ_YM_MAX THEN " + "\n");
		super.sql.append("							KEI.MRYO_YMD " + "\n");
		super.sql.append("						   ELSE " + "\n");
		super.sql.append("							TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.TO_BACK_DATE(NVL(FKN_KEIJ_YM_MAX, '999911') || SUBSTR(KNSHU_YMD, -2)), 'YYYYMMDD'), 1) - 1, 'YYYYMMDD') " + "\n");
		super.sql.append("					   END FKN_LAST_YMD " + "\n");
		super.sql.append("				FROM   (SELECT T.* " + "\n");
		super.sql.append("							  ,'" + this.dateFrom + "' START_YMD " + "\n");
		super.sql.append("							  ,LACS_COMMON.GET_TERM_DATE('" + this.dateFrom + "', " + this.termNum + ") END_YMD " + "\n");
		super.sql.append("							  ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD, '" + this.dateFrom + "', LACS_COMMON.GET_TERM_DATE('" + this.dateFrom + "', " + this.termNum + ")) END_KEIJ_YM " + "\n");
		super.sql.append("							  ,TO_CHAR(ADD_MONTHS(TO_DATE('" + this.dateFrom + "', 'YYYYMMDD')," + this.termNum + "), 'YYYYMM') FIRST_START_KEIJ_YM " + "\n");
		super.sql.append("							  ,TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + this.dateFrom + "'," + this.termNum + "), 'YYYYMMDD'), 12), 'YYYYMM') FIRST_END_KEIJ_YM " + "\n");
		super.sql.append("							  ,TO_CHAR(ADD_MONTHS(TO_DATE('" + this.dateFrom + "', 'YYYYMMDD'), " + Integer.toString((Integer.parseInt(this.termNum) + 12)) + "), 'YYYYMM') SECOND_START_KEIJ_YM " + "\n");
		super.sql.append("							  ,TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + this.dateFrom + "', " + Integer.toString((Integer.parseInt(this.termNum) + 12)) + "), 'YYYYMMDD'), 12), 'YYYYMM') SECOND_END_KEIJ_YM " + "\n");
		super.sql.append("							  ,TO_CHAR(ADD_MONTHS(TO_DATE('" + this.dateFrom + "', 'YYYYMMDD'), " + Integer.toString((Integer.parseInt(this.termNum) + 24)) + "), 'YYYYMM') THIRD_START_KEIJ_YM " + "\n");
		super.sql.append("							  ,TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + this.dateFrom + "', " + Integer.toString((Integer.parseInt(this.termNum) + 24)) + "), 'YYYYMMDD'), 12), 'YYYYMM') THIRD_END_KEIJ_YM " + "\n");
		super.sql.append("							  ,TO_CHAR(ADD_MONTHS(TO_DATE('" + this.dateFrom + "', 'YYYYMMDD'), " + Integer.toString((Integer.parseInt(this.termNum) + 36)) + "), 'YYYYMM') FOURTH_START_KEIJ_YM " + "\n");
		super.sql.append("							  ,TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + this.dateFrom + "', " + Integer.toString((Integer.parseInt(this.termNum) + 36)) + "), 'YYYYMMDD'), 12), 'YYYYMM') FOURTH_END_KEIJ_YM " + "\n");
		super.sql.append("							  ,TO_CHAR(ADD_MONTHS(TO_DATE('" + this.dateFrom + "', 'YYYYMMDD'), " + Integer.toString((Integer.parseInt(this.termNum) + 48)) + "), 'YYYYMM') FIFTH_START_KEIJ_YM " + "\n");
		super.sql.append("							  ,TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + this.dateFrom + "', " + Integer.toString((Integer.parseInt(this.termNum) + 48)) + "), 'YYYYMMDD'), 12), 'YYYYMM') FIFTH_END_KEIJ_YM " + "\n");
		super.sql.append("							  ,TO_CHAR(ADD_MONTHS(TO_DATE('" + this.dateFrom + "', 'YYYYMMDD'), " + Integer.toString((Integer.parseInt(this.termNum) + 60)) + "), 'YYYYMM') OVER_START_KEIJ_YM " + "\n");
		super.sql.append("							  ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD, '" + this.dateFrom + "', T.MRYO_YMD) MRYO_KEIJ_YM " + "\n");
		super.sql.append("							  ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD, '" + this.dateFrom + "', TO_CHAR(TO_DATE(T.KAI_YMD, 'YYYYMMDD') - 1, 'YYYYMMDD')) KAI_KEIJ_YM " + "\n");
		super.sql.append("							  ,NVL(LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD, KAI_YMD, KAI_YMD), '999999') KAI_START_KEIJ_YM " + "\n");
		super.sql.append("						FROM   T_KEI T " + "\n");
		super.sql.append("						WHERE  T.ERR_FLG = '0' " + "\n");
		super.sql.append("						AND    T.LC_CD = '" + LACSDefine.LC_CD + "' " + "\n");

		if (this.leasCompanyCode.trim().length() != 0) {
			super.sql.append("						AND    T.LU_COSMOS_CD = '" + this.leasCompanyCode + "' " + "\n");
		}

		super.sql.append("						) KEI " + "\n");
		super.sql.append("				INNER  JOIN (SELECT B.* " + "\n");
		super.sql.append("								  ,(SELECT MAX(KEIJ_YM) " + "\n");
		super.sql.append("									FROM   T_UKB_TNKI_HEAD FKN_HEAD " + "\n");
		super.sql.append("									WHERE  FKN_HEAD.LC_CD = B.LC_CD " + "\n");
		super.sql.append("									AND    FKN_HEAD.KEI_NO = B.KEI_NO " + "\n");
		super.sql.append("									AND    FKN_HEAD.BKN_NO = B.BKN_NO " + "\n");
		super.sql.append("									AND    FKN_HEAD.BKN_EDANO = B.BKN_EDANO " + "\n");
		super.sql.append("									AND    FKN_HEAD.KAI_REC_FLG = '0') FKN_KEIJ_YM_MAX " + "\n");
		super.sql.append("								  ,(SELECT MAX(KEIJ_YM) " + "\n");
		super.sql.append("									FROM   T_UKB_TNKI_HEAD FKN_HEAD " + "\n");
		super.sql.append("									WHERE  FKN_HEAD.LC_CD = B.LC_CD " + "\n");
		super.sql.append("									AND    FKN_HEAD.KEI_NO = B.KEI_NO " + "\n");
		super.sql.append("									AND    FKN_HEAD.BKN_NO = B.BKN_NO " + "\n");
		super.sql.append("									AND    FKN_HEAD.BKN_EDANO = B.BKN_EDANO) FKN_KEIJ_YM_END " + "\n");
		super.sql.append("							FROM   T_BKN B) BKN ON KEI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("											AND    KEI.KEI_NO = BKN.KEI_NO) KB " + "\n");
		super.sql.append("		JOIN   M_LC ON KB.LC_CD = M_LC.LC_CD " + "\n");
		super.sql.append("		WHERE  KB.KNSHU_YMD <= KB.END_YMD " + "\n");
		super.sql.append("		AND    (((KB.KNSHU_YMD <> NVL(KB.KAI_YMD, 'A') AND ((KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD) OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD))) OR (KB.KNSHU_YMD = KB.KAI_YMD AND KB.START_YMD <= KB.KNSHU_YMD)))) TMP " + "\n");
		super.sql.append("GROUP  BY TMP.START_YMD " + "\n");
		super.sql.append("		 ,TMP.END_YMD " + "\n");
		super.sql.append("		 ,TMP.END_KEIJ_YM " + "\n");
		super.sql.append("		 ,TMP.FIRST_START_KEIJ_YM " + "\n");
		super.sql.append("		 ,TMP.FIRST_END_KEIJ_YM " + "\n");
		super.sql.append("		 ,TMP.SECOND_START_KEIJ_YM " + "\n");
		super.sql.append("		 ,TMP.SECOND_END_KEIJ_YM " + "\n");
		super.sql.append("		 ,TMP.THIRD_START_KEIJ_YM " + "\n");
		super.sql.append("		 ,TMP.THIRD_END_KEIJ_YM " + "\n");
		super.sql.append("		 ,TMP.FOURTH_START_KEIJ_YM " + "\n");
		super.sql.append("		 ,TMP.FOURTH_END_KEIJ_YM " + "\n");
		super.sql.append("		 ,TMP.FIFTH_START_KEIJ_YM " + "\n");
		super.sql.append("		 ,TMP.FIFTH_END_KEIJ_YM " + "\n");
		super.sql.append("		 ,TMP.OVER_START_KEIJ_YM " + "\n");
	}

	/**
	 * ëŒè€ä˙ä‘(äJén)ÇéÊìæ.
	 * 
	 * @return ëŒè€ä˙ä‘(äJén)
	 */
	public String getTermFrom() {
		return super.getString("START_YMD");
	}

	/**
	 * ëŒè€ä˙ä‘(èIóπ)ÇéÊìæ.
	 * 
	 * @return ëŒè€ä˙ä‘(èIóπ)
	 */
	public String getTermTo() {
		return super.getString("END_YMD");
	}

	/**
	 * ÇPîNì‡(äJén)ÇéÊìæ.
	 * 
	 * @return ÇPîNì‡(äJén)
	 */
	public String getTermFirstFrom() {
		return super.getString("FIRST_START_KEIJ_YM");
	}

	/**
	 * ÇPîNì‡(èIóπ)ÇéÊìæ.
	 * 
	 * @return ÇPîNì‡(èIóπ)
	 */
	public String getTermFirstTo() {
		return super.getString("FIRST_END_KEIJ_YM");
	}

	/**
	 * ÇQîNì‡(äJén)ÇéÊìæ.
	 * 
	 * @return ÇQîNì‡(äJén)
	 */
	public String getTermSecondFrom() {
		return super.getString("SECOND_START_KEIJ_YM");
	}

	/**
	 * ÇQîNì‡(èIóπ)ÇéÊìæ.
	 * 
	 * @return ÇQîNì‡(èIóπ)
	 */
	public String getTermSecondTo() {
		return super.getString("SECOND_END_KEIJ_YM");
	}

	/**
	 * ÇRîNì‡(äJén)ÇéÊìæ.
	 * 
	 * @return ÇRîNì‡(äJén)
	 */
	public String getTermThirdFrom() {
		return super.getString("THIRD_START_KEIJ_YM");
	}

	/**
	 * ÇRîNì‡(èIóπ)ÇéÊìæ.
	 * 
	 * @return ÇRîNì‡(èIóπ)
	 */
	public String getTermThirdTo() {
		return super.getString("THIRD_END_KEIJ_YM");
	}

	/**
	 * ÇSîNì‡(äJén)ÇéÊìæ.
	 * 
	 * @return ÇSîNì‡(äJén)
	 */
	public String getTermFourthFrom() {
		return super.getString("FOURTH_START_KEIJ_YM");
	}

	/**
	 * ÇSîNì‡(èIóπ)ÇéÊìæ.
	 * 
	 * @return ÇSîNì‡(èIóπ)
	 */
	public String getTermFourthTo() {
		return super.getString("FOURTH_END_KEIJ_YM");
	}

	/**
	 * ÇTîNì‡(äJén)ÇéÊìæ.
	 * 
	 * @return ÇTîNì‡(äJén)
	 */
	public String getTermFifthFrom() {
		return super.getString("FIFTH_START_KEIJ_YM");
	}

	/**
	 * ÇTîNì‡(èIóπ)ÇéÊìæ.
	 * 
	 * @return ÇTîNì‡(èIóπ)
	 */
	public String getTermFifthTo() {
		return super.getString("FIFTH_END_KEIJ_YM");
	}

	/**
	 * ÇTîNí¥ÇéÊìæ.
	 * 
	 * @return ÇTîNí¥
	 */
	public String getTermOver() {
		return super.getString("OVER_START_KEIJ_YM");
	}

	/**
	 * ÇPÅFèäóLå†à⁄ì]äOÅFñ¢åoâﬂÉäÅ[ÉXóøÇéÊìæ.
	 * 
	 * @return ÇPÅFèäóLå†à⁄ì]äOÅFñ¢åoâﬂÉäÅ[ÉXóø
	 */
	public long getB1aLeaseAmount() {
		return super.getLong("B1_GFL_A_LAMT");
	}

	/**
	 * ÇPÅFèäóLå†à⁄ì]äOÅFå©êœécë∂âøäiÇéÊìæ.
	 * 
	 * @return ÇPÅFèäóLå†à⁄ì]äOÅFå©êœécë∂âøäi
	 */
	public long getB1bMtmrZanzonAmount() {
		return super.getLong("B1_GFL_B_MTMR_ZANZON_AMT");
	}

	/**
	 * ÇPÅFèäóLå†à⁄ì]äOÅFéÛéÊóòëßëäìñäzÇéÊìæ.
	 * 
	 * @return ÇPÅFèäóLå†à⁄ì]äOÅFéÛéÊóòëßëäìñäz
	 */
	public long getB1cRisokuAmount() {
		return super.getLong("B1_GFL_C_HSE_RSK");
	}

	/**
	 * ÇPÅFèäóLå†à⁄ì]äOÅFà€éùä«óùîÔópëäìñäzÇéÊìæ.
	 * 
	 * @return ÇPÅFèäóLå†à⁄ì]äOÅFà€éùä«óùîÔópëäìñäz
	 */
	public long getB1dEkimuAmount() {
		return super.getLong("B1_GFL_D_IJI_KANRI_AMT");
	}

	/**
	 * ÇPÅFèäóLå†à⁄ì]äOÅFññ±íÒãüîÔëäìñäzÇéÊìæ.
	 * 
	 * @return ÇPÅFèäóLå†à⁄ì]äOÅFññ±íÒãüîÔëäìñäz
	 */
	public long getB1eIjiAmount() {
		return super.getLong("B1_GFL_E_EKIM_TEIK_AMT");
	}

	/**
	 * ÇPÅFèäóLå†à⁄ì]äOÅFÇ§Çøå≥ñ{ÇéÊìæ.
	 * 
	 * @return ÇPÅFèäóLå†à⁄ì]äOÅFÇ§Çøå≥ñ{
	 */
	public long getB1fGanpon() {
		return super.getLong("B1_GFL_F_GNPN_AMT");
	}

	/**
	 * ÇQÅFèäóLå†à⁄ì]äOÅFÇPîNì‡ÇéÊìæ.
	 * 
	 * @return ÇQÅFèäóLå†à⁄ì]äOÅFÇPîNì‡
	 */
	public long getB2ItengaiFirst() {
		return super.getLong("B2_GFL_FIRST_AMT");
	}

	/**
	 * ÇQÅFèäóLå†à⁄ì]äOÅFÇQîNì‡ÇéÊìæ.
	 * 
	 * @return ÇQÅFèäóLå†à⁄ì]äOÅFÇQîNì‡
	 */
	public long getB2ItengaiSecond() {
		return super.getLong("B2_GFL_SECOND_AMT");
	}

	/**
	 * ÇQÅFèäóLå†à⁄ì]äOÅFÇRîNì‡ÇéÊìæ.
	 * 
	 * @return ÇQÅFèäóLå†à⁄ì]äOÅFÇRîNì‡
	 */
	public long getB2ItengaiThird() {
		return super.getLong("B2_GFL_THIRD_AMT");
	}

	/**
	 * ÇQÅFèäóLå†à⁄ì]äOÅFÇSîNì‡ÇéÊìæ.
	 * 
	 * @return ÇQÅFèäóLå†à⁄ì]äOÅFÇSîNì‡
	 */
	public long getB2ItengaiFourth() {
		return super.getLong("B2_GFL_FOURTH_AMT");
	}

	/**
	 * ÇQÅFèäóLå†à⁄ì]äOÅFÇTîNì‡ÇéÊìæ.
	 * 
	 * @return ÇQÅFèäóLå†à⁄ì]äOÅFÇTîNì‡
	 */
	public long getB2ItengaiFifth() {
		return super.getLong("B2_GFL_FIFTH_AMT");
	}

	/**
	 * ÇQÅFèäóLå†à⁄ì]äOÅFÇTîNí¥ÇéÊìæ.
	 * 
	 * @return ÇQÅFèäóLå†à⁄ì]äOÅFÇTîNí¥
	 */
	public long getB2ItengaiOver() {
		return super.getLong("B2_GFL_OVER_AMT");
	}

	/**
	 * ÇQÅFèäóLå†à⁄ì]ÅFÇPîNì‡ÇéÊìæ.
	 * 
	 * @return ÇQÅFèäóLå†à⁄ì]ÅFÇPîNì‡
	 */
	public long getB2ItenFirst() {
		return super.getLong("B2_FL_FIRST_AMT");
	}

	/**
	 * ÇQÅFèäóLå†à⁄ì]ÅFÇQîNì‡ÇéÊìæ.
	 * 
	 * @return ÇQÅFèäóLå†à⁄ì]ÅFÇQîNì‡
	 */
	public long getB2ItenSecond() {
		return super.getLong("B2_FL_SECOND_AMT");
	}

	/**
	 * ÇQÅFèäóLå†à⁄ì]ÅFÇRîNì‡ÇéÊìæ.
	 * 
	 * @return ÇQÅFèäóLå†à⁄ì]ÅFÇRîNì‡
	 */
	public long getB2ItenThird() {
		return super.getLong("B2_FL_THIRD_AMT");
	}

	/**
	 * ÇQÅFèäóLå†à⁄ì]ÅFÇSîNì‡ÇéÊìæ.
	 * 
	 * @return ÇQÅFèäóLå†à⁄ì]ÅFÇSîNì‡
	 */
	public long getB2ItenFourth() {
		return super.getLong("B2_FL_FOURTH_AMT");
	}

	/**
	 * ÇQÅFèäóLå†à⁄ì]ÅFÇTîNì‡ÇéÊìæ.
	 * 
	 * @return ÇQÅFèäóLå†à⁄ì]ÅFÇTîNì‡
	 */
	public long getB2ItenFifth() {
		return super.getLong("B2_FL_FIFTH_AMT");
	}

	/**
	 * ÇQÅFèäóLå†à⁄ì]ÅFÇTîNí¥ÇéÊìæ.
	 * 
	 * @return ÇQÅFèäóLå†à⁄ì]ÅFÇTîNí¥
	 */
	public long getB2ItenOver() {
		return super.getLong("B2_FL_OVER_AMT");
	}

	/**
	 * ÇRÅFÉIÉyÉäÅ[ÉXÅFÇPîNì‡ÇéÊìæ.
	 * 
	 * @return ÇRÅFÉIÉyÉäÅ[ÉXÅFÇPîNì‡
	 */
	public long getB3OperationFirst() {
		return super.getLong("B3_OP_FIRST_AMT");
	}

	/**
	 * ÇRÅFÉIÉyÉäÅ[ÉXÅFÇPîNí¥ÇéÊìæ.
	 * 
	 * @return ÇRÅFÉIÉyÉäÅ[ÉXÅFÇPîNí¥
	 */
	public long getB3OperationOver() {
		return super.getLong("B3_OP_OVER_AMT");
	}

	/**
	 * ÇRÅFÉIÉyÉäÅ[ÉXÅFçáåvÇéÊìæ.
	 * 
	 * @return ÇRÅFÉIÉyÉäÅ[ÉXÅFçáåv
	 */
	public long getB3OperationTotal() {
		return super.getLong("B3_OP_TOTAL_AMT");
	}

}
