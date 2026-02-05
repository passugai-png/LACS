package jp.co.pro_app.lacs.affairs.syousai.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * Œ_–ñÚ×Entity.
 * 
 * @author yokota
 * @version 20081017
 */
public class LACSSyousaiEntity extends EntityBase {

	/**
	 * ƒRƒ“ƒXƒgƒ‰ƒNƒ^.
	 * 
	 * @param piModel
	 *            Model
	 * @param piCommonBean
	 *            LACS‹¤’ÊBean
	 * @param piSyousaiBean
	 *            Œ_–ñÚ×Bean
	 */
	public LACSSyousaiEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSSyousaiBean piSyousaiBean) {
		super(piModel);
	}

	private String	keiyakuNo		= "";	// Œ_–ñ”Ô†

	private String	leasCompanyCode	= "";	// ƒŠ[ƒX‰ïĞƒR[ƒh

	/**
	 * ‚r‚p‚k‚ğ¶¬.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT \n");
		super.sql.append("	to_char(CURRENT_DATE,'yyyymmdd') CREATE_DATE \n");
		super.sql.append("	,LEASE_USER_NM \n");
		super.sql.append("	,LEASE_USER_CD \n");
		super.sql.append("	,LEASE_COMPANY_NM \n");
		super.sql.append("	,KEI_NO \n");
		super.sql.append("	,KEI_TERM \n");
		super.sql.append("	,KEI_YMD \n");
		super.sql.append("	,KNSHU_YMD \n");
		super.sql.append("	,MRYO_YMD \n");
		super.sql.append("	,KAI_YMD \n");
		super.sql.append("	,TRD_HNTE_KEKA_KBN \n");
		super.sql.append("	,TRD_HNTE_KEKA_NM \n");
		super.sql.append("	,DIH_BKN_NM \n");
		super.sql.append("	,JOTO_JKN_FLG \n");
		super.sql.append("	,JOTO_JKN_NM \n");
		super.sql.append("	,WRYS_KNU_SNTK_FLG \n");
		super.sql.append("	,WRYS_KNU_SNTK_NM \n");
		super.sql.append("	,SPCL_SIYO_BKN_FLG \n");
		super.sql.append("	,SPCL_SIYO_BKN_NM \n");
		super.sql.append("	,CYT_KAI_KANO_KBN \n");
		super.sql.append("	,CYT_KAI_KANO_KBN_NM \n");
		super.sql.append("	,LAMT_SUM \n");
		super.sql.append("	,KEI_AMT \n");
		super.sql.append("	,KNU_AMT \n");
		super.sql.append("	,(SELECT  \n");
		super.sql.append("		SUM(BKN.KEI_AMT_STAX) \n");
		super.sql.append("		FROM T_KEI KEI \n");
		super.sql.append("		INNER JOIN T_BKN BKN ON BKN.LC_CD = KEI.LC_CD  \n");
		super.sql.append("					AND BKN.KEI_NO = KEI.KEI_NO \n");
		super.sql.append("		WHERE KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "'  \n");
		super.sql.append("		AND KEI.KEI_NO = '" + this.keiyakuNo + "' \n");
		super.sql.append("	 ) KEI_AMT_STAX_SUM \n");
		super.sql.append("	,RSK_SUM \n");
		super.sql.append("	,(SELECT  \n");
		super.sql.append("		NVL(SUM(BKN.ZANK_HSHO_AMT),0)  \n");
		super.sql.append("		FROM T_KEI KEI \n");
		super.sql.append("		INNER JOIN T_BKN BKN ON BKN.LC_CD = KEI.LC_CD  \n");
		super.sql.append("					AND BKN.KEI_NO = KEI.KEI_NO  \n");
		super.sql.append("					AND (BKN.ZANK_HSHOSK_CD = KEI.LU_TRSK_CD OR BKN.IPN_ZANK_HSHOSK_CD = KEI.LU_TRSK_CD) \n");
		super.sql.append("		WHERE KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "'  \n");
		super.sql.append("		AND KEI.KEI_NO = '" + this.keiyakuNo + "' \n");
		super.sql.append("	 ) ZANK_HSHO_AMT_SUM \n");
		//super.sql.append("      ,CASE " + "\n");
		//super.sql.append("   	    WHEN RSK_KEIJ_HOHO_KBN = '" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' THEN " + "\n");
		//super.sql.append("   	        0 " + "\n");
		//super.sql.append("   		ELSE " + "\n");
		//super.sql.append("              IJI_HYO_SUM " + "\n");
		//super.sql.append("       END IJI_HYO_SUM" + "\n");
		// 20210413 arai ’Ç‰Á start ˆÛŠÇ—”ï‘Š“–Šz‘Šz‘Î‰
		super.sql.append("      ,IJI_HYO_SUM" + "\n");
		// 20210413 arai ’Ç‰Á end ˆÛŠÇ—”ï‘Š“–Šz‘Šz
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("   	    WHEN RSK_KEIJ_HOHO_KBN = '" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' THEN " + "\n");
		super.sql.append("   	        0 " + "\n");
		super.sql.append("   		ELSE " + "\n");
		super.sql.append("              EKM_HYO_SUM " + "\n");
		super.sql.append("       END EKM_HYO_SUM" + "\n");
		super.sql.append("	,RSK_KEIJ_HOHO_KBN \n");
		super.sql.append("	,RSK_KEIJ_HOHO_KBN_NM \n");
		super.sql.append("	,TNKI_HOHO_KBN \n");
		super.sql.append("	,FKN_TNKI_HOHO_NM \n");
		super.sql.append("	,GNKSK_HASU_CHSE_CD \n");
		super.sql.append("	,HASU_CHSE_NM \n");
		super.sql.append("	,HYJYO_KEI_NO \n");
		super.sql.append("	,CASE SGK_SSN_KBN " + "\n");
		super.sql.append("		WHEN '1' THEN " + "\n");
		super.sql.append("			'­Šz‘Y(Œ_–ñw’è)' " + "\n");
		super.sql.append("		WHEN '0' THEN " + "\n");
		super.sql.append("			'”ñ­Šz‘Y(Œ_–ñw’è)' " + "\n");
		super.sql.append("		ELSE " + "\n");
		super.sql.append("			CASE   " + "\n");
		super.sql.append("				WHEN KEI_AMT > 3000000 THEN " + "\n");
		super.sql.append("					'”ñ­Šz‘Y(©“®”»’è)' " + "\n");
		super.sql.append("				ELSE " + "\n");
		super.sql.append("					'­Šz‘Y(©“®”»’è)' " + "\n");
		super.sql.append("			END " + "\n");
		super.sql.append("	END SGK_SSN " + "\n");
		super.sql.append("FROM  \n");
		super.sql.append("	(SELECT  \n");
		super.sql.append("		LU.LU_NM LEASE_USER_NM \n");
		super.sql.append("		,LU.LU_COSMOS_CD LEASE_USER_CD \n");
		super.sql.append("		,DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_NM,LU.PDF_COMPANY_NM) LEASE_COMPANY_NM \n");
		super.sql.append("		,MG_KEI.KEI_NO KEI_NO \n");
		super.sql.append("		,KEI.KEI_TERM KEI_TERM \n");
		super.sql.append("		,KEI.KEI_YMD KEI_YMD \n");
		super.sql.append("		,KEI.KNSHU_YMD KNSHU_YMD \n");
		super.sql.append("		,KEI.MRYO_YMD MRYO_YMD \n");
		super.sql.append("		,KEI.KAI_YMD KAI_YMD \n");
		super.sql.append("		,KEI.DIH_BKN_NM DIH_BKN_NM \n");
		super.sql.append("		,KEI.TRD_HNTE_KEKA_KBN TRD_HNTE_KEKA_KBN \n");
		super.sql.append("		,TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_NM TRD_HNTE_KEKA_NM \n");
		super.sql.append("		,KEI.JOTO_JKN_FLG JOTO_JKN_FLG \n");
		super.sql.append("		,JOTO_JKN_FLG.JOTO_JKN_NM JOTO_JKN_NM \n");
		super.sql.append("		,KEI.WRYS_KNU_SNTK_FLG WRYS_KNU_SNTK_FLG \n");
		super.sql.append("		,WRYS_KNU_SNTK_FLG.WRYS_KNU_SNTK_NM WRYS_KNU_SNTK_NM \n");
		super.sql.append("		,KEI.SPCL_SIYO_BKN_FLG SPCL_SIYO_BKN_FLG \n");
		super.sql.append("		,SPCL_SIYO_BKN.SPCL_SIYO_BKN_NM SPCL_SIYO_BKN_NM \n");
		super.sql.append("		,KEI.CYT_KAI_KANO_KBN CYT_KAI_KANO_KBN \n");
		super.sql.append("		,CYT_KAI_KANO_KBN.CYT_KAI_KANO_KBN_NM CYT_KAI_KANO_KBN_NM \n");
		super.sql.append("		,MG_KEI.KEI_AMT KEI_AMT \n");
		super.sql.append("		,MG_KEI.KNU_AMT KNU_AMT \n");
		super.sql.append("		,KEI.RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN \n");
		super.sql.append("		,RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN_NM RSK_KEIJ_HOHO_KBN_NM \n");
		super.sql.append("		,KEI.TNKI_HOHO_KBN TNKI_HOHO_KBN \n");
		super.sql.append("		,FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_NM FKN_TNKI_HOHO_NM \n");
		super.sql.append("		,KEI.GNKSK_HASU_CHSE_CD GNKSK_HASU_CHSE_CD \n");
		super.sql.append("		,HASU_CHSE_CD.HASU_CHSE_NM HASU_CHSE_NM \n");
		super.sql.append("		,IJI_HYO_SUM \n");
		super.sql.append("		,EKM_HYO_SUM \n");
		super.sql.append("		,RSK_SUM \n");
		super.sql.append("		,LAMT_SUM \n");
		super.sql.append("		,KEI.HYJYO_KEI_NO \n");
		super.sql.append("		,SGK_SSN_KBN \n");
		super.sql.append("		,RLS_TMS \n");
		super.sql.append("		FROM  \n");
		super.sql.append("			T_KEI KEI \n");
		super.sql.append("			INNER JOIN (SELECT  \n");
		super.sql.append("					LU_COSMOS_CD \n");
		super.sql.append("					,MIN(KEI_NO) KEI_NO \n");
		super.sql.append("					,SUM(KEI_AMT) KEI_AMT \n");
		super.sql.append("					,SUM(KNU_AMT) KNU_AMT \n");
		super.sql.append("					FROM  \n");
		super.sql.append("						T_KEI  \n");
		super.sql.append("					WHERE LU_COSMOS_CD = '" + this.leasCompanyCode + "'  \n");
		super.sql.append("					AND KEI_NO = '" + this.keiyakuNo + "' \n");
		super.sql.append("					GROUP BY LU_COSMOS_CD)  \n");
		super.sql.append("					MG_KEI ON MG_KEI.LU_COSMOS_CD = KEI.LU_COSMOS_CD  \n");
		super.sql.append("						AND MG_KEI.KEI_NO = KEI.KEI_NO \n");
		super.sql.append("			INNER JOIN M_LU LU ON LU.LU_COSMOS_CD = MG_KEI.LU_COSMOS_CD \n");
		super.sql.append("			INNER JOIN M_LC LC ON LC.LC_CD = KEI.LC_CD \n");
		super.sql.append("			INNER JOIN (SELECT  \n");
		super.sql.append("					LU_COSMOS_CD  \n");
		super.sql.append("					,HYJYO_KEI_NO \n");
		super.sql.append("					,SUM(GNPN_TTL) LAMT_SUM \n");
		super.sql.append("					,SUM(YTE_TGTU_RSK) RSK_SUM  \n");
		super.sql.append("					,SUM(IJI_KANRI_HYO) IJI_HYO_SUM  \n");
		super.sql.append("					,SUM(EKM_TEIK_HYO) EKM_HYO_SUM \n");
		super.sql.append("					FROM \n");
		super.sql.append("					(SELECT \n");
		super.sql.append("						KEI.LU_COSMOS_CD  \n");
		super.sql.append("						,KEI.HYJYO_KEI_NO  \n");
		super.sql.append("						,HEAD.LC_CD  \n");
		super.sql.append("						,HEAD.KEI_NO  \n");
		super.sql.append("						,HEAD.KEIJ_YM  \n");
		super.sql.append("						,HEAD.BKN_NO  \n");
		super.sql.append("						,HEAD.BKN_EDANO  \n");
		super.sql.append("						,HEAD.YTE_LAMT  \n");
		super.sql.append("						,HEAD.YTE_LAMT_STAX  \n");
		super.sql.append("						,DETAIL.YTE_TGTU_GNPN  \n");
		super.sql.append("						,DETAIL.YTE_TGTU_RSK  \n");
		super.sql.append("						,DETAIL.ZAND_GNPN  \n");
		
		// 20210413 arai ’Ç‰Á start ˆÛŠÇ—”ï‘Š“–Šz‘Šz ‘Î‰
		//super.sql.append("						,HEAD.YTE_ENT_SHOHYO_KZI  \n");
		//super.sql.append("						+ HEAD.YTE_ENT_SHOHYO_HKZI  \n");
		//super.sql.append("						+ HEAD.YTE_GTAX  \n");
		//super.sql.append("						+ HEAD.YTE_CTAX  \n");
		//super.sql.append("						+ HEAD.YTE_JTAX  \n");
		//super.sql.append("						+ HEAD.YTE_JBSK_HKN  \n");
		//super.sql.append("						+ HEAD.YTE_NNI_HKN  \n");
		//super.sql.append("						+ HEAD.YTE_RCYCL_RYO_KNRI_AMT  \n");
		//super.sql.append("						+ HEAD.YTE_DOSO + HEAD.YTE_KOZEI  \n");
		//super.sql.append("						+ HEAD.YTE_OTH_CST IJI_KANRI_HYO  \n");		
		super.sql.append("						,FKN.ENT_SHOHYO_KZI  \n");
		super.sql.append("						+ FKN.ENT_SHOHYO_HKZI  \n");
		super.sql.append("						+ FKN.GTAX  \n");
		super.sql.append("						+ FKN.CTAX  \n");
		super.sql.append("						+ FKN.JTAX  \n");
		super.sql.append("						+ FKN.JBSK_HKN  \n");
		super.sql.append("						+ FKN.NNI_HKN  \n");
		super.sql.append("						+ FKN.RCYCL_RYO_KNRI_AMT  \n");
		super.sql.append("						+ FKN.DOSO + FKN.KOZEI  \n");
		super.sql.append("						+ FKN.OTH_CST IJI_KANRI_HYO  \n");
		// 20210413 arai ’Ç‰Á end ˆÛŠÇ—”ï‘Š“–Šz‘Šz ‘Î‰

		super.sql.append("						,HEAD.YTE_IPN_EKM_TEIK_HYO  \n");
		super.sql.append("						+ HEAD.YTE_SHRY_EKM_TEIK_HYO EKM_TEIK_HYO  \n");
		
		// 20210413 arai ’Ç‰Á start ƒŠ[ƒX‘YŒvãŠz‘Î‰
		//super.sql.append("				    ,(CASE HEAD.KI WHEN (SELECT MAX(KI) KI FROM T_UKB_TNKI_HEAD WHERE KEI_NO = '" + this.keiyakuNo + "' AND KAI_REC_FLG = 0) THEN DETAIL.GNPN_TTL ELSE 0 END) GNPN_TTL \n");						
		super.sql.append("						,(CASE FKN.KI WHEN (SELECT KI FROM T_FKN_TNKI_HEAD WHERE KEI_NO = '" + this.keiyakuNo + "' AND KAI_REC_FLG = '0' AND KI = 1) THEN FKN_DETAIL.GNPN_TTL ELSE 0 END) GNPN_TTL \n");
		// 20210413 arai ’Ç‰Á end ƒŠ[ƒX‘YŒvãŠz‘Î‰
		
		super.sql.append("						FROM \n");
		super.sql.append("						T_KEI KEI  \n");
		super.sql.append("						INNER JOIN T_BKN BKN ON KEI.LC_CD = BKN.LC_CD  \n");
		super.sql.append("									AND KEI.KEI_NO = BKN.KEI_NO  \n");
		super.sql.append("						INNER JOIN T_UKB_TNKI_HEAD HEAD ON BKN.LC_CD = HEAD.LC_CD  \n");
		super.sql.append("											AND BKN.KEI_NO = HEAD.KEI_NO  \n");
		super.sql.append("											AND BKN.BKN_NO = HEAD.BKN_NO  \n");
		super.sql.append("											AND BKN.BKN_EDANO = HEAD.BKN_EDANO  \n");
		super.sql.append("						INNER JOIN T_UKB_TNKI_DETAIL DETAIL ON HEAD.LC_CD = DETAIL.LC_CD  \n");
		super.sql.append("											AND HEAD.KEI_NO = DETAIL.KEI_NO  \n");
		super.sql.append("											AND HEAD.BKN_NO = DETAIL.BKN_NO  \n");
		super.sql.append("											AND HEAD.BKN_EDANO = DETAIL.BKN_EDANO  \n");
		super.sql.append("											AND HEAD.KEIJ_YM = DETAIL.KEIJ_YM  \n");
		super.sql.append("											AND BKN.RSK_KEIJ_HOHO_KBN = DETAIL.KEIJ_HOHO_KBN  \n");
		// 20210413 arai ˆÛŠÇ—”ï—p‘Î‰ start
		super.sql.append("						INNER JOIN T_FKN_TNKI_HEAD FKN ON DETAIL.LC_CD = FKN.LC_CD  \n");
		super.sql.append("											AND DETAIL.KEI_NO = FKN.KEI_NO  \n");
		super.sql.append("											AND DETAIL.BKN_NO = FKN.BKN_NO  \n");
		super.sql.append("											AND DETAIL.BKN_EDANO = FKN.BKN_EDANO  \n");
		super.sql.append("											AND DETAIL.KEIJ_YM = FKN.KEIJ_YM  \n");
		super.sql.append("						INNER JOIN T_FKN_TNKI_DETAIL FKN_DETAIL ON FKN.LC_CD = FKN_DETAIL.LC_CD  \n");
		super.sql.append("											AND FKN.KEI_NO = FKN_DETAIL.KEI_NO  \n");
		super.sql.append("											AND FKN.BKN_NO = FKN_DETAIL.BKN_NO  \n");
		super.sql.append("											AND FKN.BKN_EDANO = FKN_DETAIL.BKN_EDANO  \n");
		super.sql.append("											AND FKN.KEIJ_YM = FKN_DETAIL.KEIJ_YM  \n");		
		super.sql.append("											AND BKN.RSK_KEIJ_HOHO_KBN = FKN_DETAIL.KEIJ_HOHO_KBN  \n");
		// 20210413 arai ˆÛŠÇ—”ï—p‘Î‰ end		
		super.sql.append("						WHERE KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "'  \n");
		super.sql.append("						AND KEI.KEI_NO='" + this.keiyakuNo + "' \n");
		super.sql.append("					UNION ALL \n");
		super.sql.append("					SELECT \n");
		super.sql.append("						KEI.LU_COSMOS_CD  \n");
		super.sql.append("						,KEI.HYJYO_KEI_NO  \n");
		super.sql.append("						,GNK.LC_CD  \n");
		super.sql.append("						,GNK.KEI_NO  \n");
		super.sql.append("						,GNK.KEIJ_YM  \n");
		super.sql.append("						,GNK.BKN_NO  \n");
		super.sql.append("						,GNK.BKN_EDANO  \n");
		super.sql.append("						,0 LAMT  \n");
		super.sql.append("						,0 LAMT_STAX  \n");
		super.sql.append("						,0 TGTU_GNPN  \n");
		super.sql.append("						,0 TGTU_RSK  \n");
		super.sql.append("						,0 ZAND_GNPN  \n");
		super.sql.append("						,0 IJI_KANRI_HYO  \n");
		super.sql.append("						,0 EKM_TEIK_HYO  \n");
		super.sql.append("						,0 GNPN_TTL  \n");
		super.sql.append("						FROM \n");
		super.sql.append("						T_KEI KEI  \n");
		super.sql.append("						INNER JOIN T_BKN BKN ON KEI.LC_CD = BKN.LC_CD  \n");
		super.sql.append("											AND KEI.KEI_NO = BKN.KEI_NO  \n");
		super.sql.append("						LEFT JOIN T_UKB_GNKSK GNK ON BKN.LC_CD = GNK.LC_CD  \n");
		super.sql.append("											AND BKN.KEI_NO = GNK.KEI_NO  \n");
		super.sql.append("											AND BKN.BKN_NO = GNK.BKN_NO  \n");
		super.sql.append("											AND BKN.BKN_EDANO = GNK.BKN_EDANO  \n");
		super.sql.append("											AND BKN.SKK_KEIJ_HOHO_KBN = GNK.KEIJ_HOHO_KBN  \n");
		super.sql.append(" 											AND GNK.KAI_REC_FLG = '0' \n");
		super.sql.append("						WHERE KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "'  \n");
		super.sql.append("						AND KEI.KEI_NO='" + this.keiyakuNo + "') \n");
		super.sql.append("				GROUP BY LU_COSMOS_CD ,HYJYO_KEI_NO \n");
		super.sql.append("				) BASE_SUM ON BASE_SUM.LU_COSMOS_CD = KEI.LU_COSMOS_CD  \n");
		super.sql.append("							AND BASE_SUM.HYJYO_KEI_NO = KEI.HYJYO_KEI_NO \n");
		super.sql.append("		LEFT JOIN M_TRD_HNTE_KEKA_KBN TRD_HNTE_KEKA_KBN ON TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN = KEI.TRD_HNTE_KEKA_KBN \n");
		super.sql.append("		LEFT JOIN M_JOTO_JKN_FLG JOTO_JKN_FLG ON JOTO_JKN_FLG.JOTO_JKN_FLG = KEI.JOTO_JKN_FLG \n");
		super.sql.append("		LEFT JOIN M_WRYS_KNU_SNTK_FLG WRYS_KNU_SNTK_FLG ON WRYS_KNU_SNTK_FLG.WRYS_KNU_SNTK_FLG = KEI.WRYS_KNU_SNTK_FLG \n");
		super.sql.append("		LEFT JOIN M_SPCL_SIYO_BKN SPCL_SIYO_BKN ON SPCL_SIYO_BKN.SPCL_SIYO_BKN_FLG = KEI.SPCL_SIYO_BKN_FLG \n");
		super.sql.append("		LEFT JOIN M_CYT_KAI_KANO_KBN CYT_KAI_KANO_KBN ON CYT_KAI_KANO_KBN.CYT_KAI_KANO_KBN = KEI.CYT_KAI_KANO_KBN \n");
		super.sql.append("		LEFT JOIN M_RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN ON RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN = KEI.RSK_KEIJ_HOHO_KBN \n");
		super.sql.append("		LEFT JOIN M_FKN_TNKI_HOHO_CD FKN_TNKI_HOHO_CD ON FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_CD = KEI.TNKI_HOHO_KBN \n");
		super.sql.append("		LEFT JOIN M_HASU_CHSE_CD HASU_CHSE_CD ON HASU_CHSE_CD.HASU_CHSE_CD = KEI.GNKSK_HASU_CHSE_CD \n");
		super.sql.append(" 	WHERE KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "' AND KEI.KEI_NO = '" + this.keiyakuNo + "') \n");
		
		System.out.println(sql);
	}

	/**
	 * ƒŠ[ƒX‰ïĞƒR[ƒh‚ğİ’è.
	 * 
	 * @param piLeasCompanyCode
	 *            ƒŠ[ƒX‰ïĞƒR[ƒh
	 */
	public void setLeasCompanyCode(String piLeasCompanyCode) {
		this.leasCompanyCode = piLeasCompanyCode;
	}

	/**
	 * Œ_–ñ”Ô†‚ğİ’è.
	 * 
	 * @param piKeiyakuNo
	 *            Œ_–ñ”Ô†
	 */
	public void setKeiyakuNo(String piKeiyakuNo) {
		this.keiyakuNo = piKeiyakuNo;
	}

	/**
	 * Œ_–ñ”Ô†‚ğæ“¾.
	 * 
	 * @return Œ_–ñ”Ô†
	 */
	public String getKeiyakuNo() {
		return super.getString("KEI_NO");
	}

	/**
	 * •\¦—pŒ_–ñ”Ô†‚ğæ“¾.
	 * 
	 * @return •\¦—pŒ_–ñ”Ô†
	 */
	public String getHyoujiKeiyakuNo() {
		return super.getString("HYJYO_KEI_NO");
	}

	/**
	 * ì¬“ú‚ğæ“¾.
	 * 
	 * @return ì¬“ú
	 */
	public String getCreateDate() {
		return super.getString("CREATE_DATE");
	}

	/**
	 * ŠJ¦æ‚ğæ“¾.
	 * 
	 * @return ŠJ¦æ
	 */
	public String getKaijisakiName() {
		return super.getString("LEASE_USER_NM");
	}

	/**
	 * ƒŠ[ƒX‰ïĞ–¼‚ğæ“¾.
	 * 
	 * @return ƒŠ[ƒX‰ïĞ–¼
	 */
	public String getLeaseCompanyNm() {
		return super.getString("LEASE_COMPANY_NM");
	}

	/**
	 * ƒŠ[ƒXŠúŠÔ‚ğæ“¾.
	 * 
	 * @return ƒŠ[ƒXŠúŠÔ
	 */
	public String getLeaseTerm() {
		return super.getString("KEI_TERM");
	}

	/**
	 * Œ_–ñ“ú‚ğæ“¾.
	 * 
	 * @return Œ_–ñ“ú
	 */
	public String getKeiyakuYmd() {
		return super.getString("KEI_YMD");
	}

	/**
	 * ŒŸû“ú‚ğæ“¾.
	 * 
	 * @return ŒŸû“ú
	 */
	public String getKensyuYmd() {
		return super.getString("KNSHU_YMD");
	}

	/**
	 * –—¹“ú‚ğæ“¾.
	 * 
	 * @return –—¹“ú
	 */
	public String getManryoYmd() {
		return super.getString("MRYO_YMD");
	}

	/**
	 * ‰ğ–ñ“ú‚ğæ“¾.
	 * 
	 * @return ‰ğ–ñ“ú
	 */
	public String getKaiyakuYmd() {
		return super.getString("KAI_YMD");
	}

	/**
	 * ƒŠ[ƒXæˆø•ª—Ş‚ğæ“¾.
	 * 
	 * @return ƒŠ[ƒXæˆø•ª—Ş
	 */
	public String getTradeHanteiKekka() {
		return super.getString("TRD_HNTE_KEKA_KBN");
	}

	/**
	 * ƒŠ[ƒXæˆø•ª—Ş–¼‚ğæ“¾.
	 * 
	 * @return ƒŠ[ƒXæˆø•ª—Ş–¼
	 */
	public String getTradeHanteiKekkaName() {
		return super.getString("TRD_HNTE_KEKA_NM");
	}

	/**
	 * ‘ã•\•¨Œ–¼‚ğæ“¾.
	 * 
	 * @return ‘ã•\•¨Œ–¼
	 */
	public String getDaihyoBukkenName() {
		return super.getString("DIH_BKN_NM");
	}

	/**
	 * ÷“nğŒ‚ğæ“¾.
	 * 
	 * @return ÷“nğŒ
	 */
	public String getJoutoJouken() {
		return super.getString("JOTO_JKN_FLG");
	}

	/**
	 * ÷“nğŒ–¼‚ğæ“¾.
	 * 
	 * @return ÷“nğŒ–¼
	 */
	public String getJoutoJoukenName() {
		return super.getString("JOTO_JKN_NM");
	}

	/**
	 * Š„ˆÀw“ü‘I‘ğŒ ‚ğæ“¾.
	 * 
	 * @return Š„ˆÀw“ü‘I‘ğŒ 
	 */
	public String getWariyasuKonyuSentakuKen() {
		return super.getString("WRYS_KNU_SNTK_FLG");
	}

	/**
	 * Š„ˆÀw“ü‘I‘ğŒ –¼‚ğæ“¾.
	 * 
	 * @return Š„ˆÀw“ü‘I‘ğŒ –¼
	 */
	public String getWariyasuKonyuSentakuKenName() {
		return super.getString("WRYS_KNU_SNTK_NM");
	}

	/**
	 * “Á•Êd—l•¨Œ‚ğæ“¾.
	 * 
	 * @return “Á•Êd—l•¨Œ
	 */
	public String getTokubetiSiyoBukken() {
		return super.getString("SPCL_SIYO_BKN_FLG");
	}

	/**
	 * “Á•Êd—l•¨Œ–¼‚ğæ“¾.
	 * 
	 * @return “Á•Êd—l•¨Œ–¼
	 */
	public String getTokubetiSiyoBukkenName() {
		return super.getString("SPCL_SIYO_BKN_NM");
	}

	/**
	 * ’†“r‰ğ–ñ‚ğæ“¾.
	 * 
	 * @return ’†“r‰ğ–ñ
	 */
	public String getTyutoKaiyaku() {
		return super.getString("CYT_KAI_KANO_KBN");
	}

	/**
	 * ’†“r‰ğ–ñ–¼‚ğæ“¾.
	 * 
	 * @return ’†“r‰ğ–ñ–¼
	 */
	public String getTyutoKaiyakuName() {
		return super.getString("CYT_KAI_KANO_KBN_NM");
	}

	/**
	 * Š„ˆøŒ»İ‰¿’l‚ğæ“¾.
	 * 
	 * @return Š„ˆøŒ»İ‰¿’l
	 */
	public long getKeiWaribikiGenzaiKati() {
		return super.getLong("LAMT_SUM");
	}

	/**
	 * ƒŠ[ƒX—¿‘Šz‚ğæ“¾.
	 * 
	 * @return ƒŠ[ƒX—¿‘Šz
	 */
	public long getLeaseRyouSogaku() {
		return super.getLong("KEI_AMT");
	}

	/**
	 * Œ©ÏŒ»‹àw“ü‰¿Ši‚ğæ“¾.
	 * 
	 * @return Œ©ÏŒ»‹àw“ü‰¿Ši
	 */
	public long getMitumoriGenkinKakaku() {
		return super.getLong("KNU_AMT");
	}

	/**
	 * Á”ïÅ‘Šz‚ğæ“¾.
	 * 
	 * @return Á”ïÅ‘Šz
	 */
	public long getTaxSougaku() {
		return super.getLong("KEI_AMT_STAX_SUM");
	}

	/**
	 * x•¥—˜‘§‘Š“–Šz‘Šz‚ğæ“¾.
	 * 
	 * @return x•¥—˜‘§‘Š“–Šz‘Šz
	 */
	public long getRisokuSoutouSougaku() {
		return super.getLong("RSK_SUM");
	}

	/**
	 * c‰¿•ÛØŠz‚ğæ“¾.
	 * 
	 * @return c‰¿•ÛØŠz
	 */
	public long getZanHosyou() {
		return super.getLong("ZANK_HSHO_AMT_SUM");
	}

	/**
	 * ˆÛŠÇ—”ï‘Š“–Šz‘Šz‚ğæ“¾.
	 * 
	 * @return ˆÛŠÇ—”ï‘Š“–Šz‘Šz
	 */
	public long getIjikanriHiSougaku() {
		return super.getLong("IJI_HYO_SUM");
	}

	/**
	 * –ğ–±’ñ‹Ÿ”ï‘Š“–Šz‘Šz‚ğæ“¾.
	 * 
	 * @return –ğ–±’ñ‹Ÿ”ï‘Š“–Šz‘Šz
	 */
	public long getEkimuteikyoHiSougaku() {
		return super.getLong("EKM_HYO_SUM");
	}

	/**
	 * —˜‘§‘Š“–”z•ª•û–@‚ğæ“¾.
	 * 
	 * @return —˜‘§‘Š“–”z•ª•û–@
	 */
	public String getRisokuHaibunHohou() {
		return super.getString("RSK_KEIJ_HOHO_KBN");
	}

	/**
	 * —˜‘§‘Š“–”z•ª•û–@–¼‚ğæ“¾.
	 * 
	 * @return —˜‘§‘Š“–”z•ª•û–@–¼
	 */
	public String getRisokuHaibunHohouName() {
		return super.getString("RSK_KEIJ_HOHO_KBN_NM");
	}

	/**
	 * ƒŠ[ƒX—¿ŒvZŠî€‚ğæ“¾.
	 * 
	 * @return ƒŠ[ƒX—¿ŒvZŠî€
	 */
	public String getLeaseRyouKeisanKijun() {
		return super.getString("TNKI_HOHO_KBN");
	}

	/**
	 * ƒŠ[ƒX—¿ŒvZŠî€–¼‚ğæ“¾.
	 * 
	 * @return ƒŠ[ƒX—¿ŒvZŠî€–¼
	 */
	public String getLeaseRyouKeisanKijunName() {
		return super.getString("FKN_TNKI_HOHO_NM");
	}

	/**
	 * Œ¸‰¿‹p’[”’²®•û–@‚ğæ“¾.
	 * 
	 * @return Œ¸‰¿‹p’[”’²®•û–@
	 */
	public String getGnkskHasuChoseiHohou() {
		return super.getString("GNKSK_HASU_CHSE_CD");
	}

	/**
	 * Œ¸‰¿‹p’[”’²®•û–@–¼‚ğæ“¾.
	 * 
	 * @return Œ¸‰¿‹p’[”’²®•û–@–¼
	 */
	public String getGnkskHasuChoseiHohouName() {
		return super.getString("HASU_CHSE_NM");
	}

	/**
	 * ­Šz‘Y–¼‚ğæ“¾.
	 * 
	 * @return ­Šz‘Y–¼
	 */
	public String getSyougakuSisanName() {
		return super.getString("SGK_SSN");
	}
}
