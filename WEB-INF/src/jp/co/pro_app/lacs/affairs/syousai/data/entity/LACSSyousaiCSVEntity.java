package jp.co.pro_app.lacs.affairs.syousai.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 契約詳細CSVEntity.
 * 
 * @author yokota
 * @version 20081017
 */
public class LACSSyousaiCSVEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            Model
	 * @param piCommonBean
	 *            LACS共通Bean
	 * @param piSyousaiBean
	 *            契約詳細Bean
	 */
	public LACSSyousaiCSVEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSSyousaiBean piSyousaiBean) {
		super(piModel);
	}

	private String	keiyakuNo		= "";	// 契約番号

	private String	leasCompanyCode	= "";	// リース会社コード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT \n");
		super.sql.append("	to_char(CURRENT_DATE,'yyyymmdd') CREATE_DATE \n");
		super.sql.append("	,BASE_HEAD.LEASE_USER_NM LEASE_USER_NM \n");
		super.sql.append("	,BASE_HEAD.LEASE_COMPANY_NM LEASE_COMPANY_NM \n");
		super.sql.append("	,BASE_HEAD.KEI_NO KEI_NO \n");
		super.sql.append("	,BASE_HEAD.KEI_TERM KEI_TERM \n");
		super.sql.append("	,BASE_HEAD.KEI_YMD KEI_YMD \n");
		super.sql.append("	,BASE_HEAD.KNSHU_YMD KNSHU_YMD \n");
		super.sql.append("	,BASE_HEAD.MRYO_YMD MRYO_YMD \n");
		super.sql.append("	,BASE_HEAD.KAI_YMD KAI_YMD \n");
		super.sql.append("	,BASE_HEAD.TRD_HNTE_KEKA_KBN TRD_HNTE_KEKA_KBN \n");
		super.sql.append("	,BASE_HEAD.TRD_HNTE_KEKA_NM TRD_HNTE_KEKA_NM \n");
		super.sql.append("	,BASE_HEAD.DIH_BKN_NM DIH_BKN_NM \n");
		super.sql.append("	,BASE_HEAD.JOTO_JKN_FLG JOTO_JKN_FLG \n");
		super.sql.append("	,BASE_HEAD.JOTO_JKN_NM JOTO_JKN_NM \n");
		super.sql.append("	,BASE_HEAD.WRYS_KNU_SNTK_FLG WRYS_KNU_SNTK_FLG \n");
		super.sql.append("	,BASE_HEAD.WRYS_KNU_SNTK_NM WRYS_KNU_SNTK_NM \n");
		super.sql.append("	,BASE_HEAD.SPCL_SIYO_BKN_FLG SPCL_SIYO_BKN_FLG \n");
		super.sql.append("	,BASE_HEAD.SPCL_SIYO_BKN_NM SPCL_SIYO_BKN_NM \n");
		super.sql.append("	,BASE_HEAD.CYT_KAI_KANO_KBN CYT_KAI_KANO_KBN \n");
		super.sql.append("	,BASE_HEAD.CYT_KAI_KANO_KBN_NM CYT_KAI_KANO_KBN_NM \n");
		super.sql.append("	,BASE_HEAD.LAMT_SUM LAMT_SUM \n");
		super.sql.append("	,BASE_HEAD.KEI_AMT KEI_AMT \n");
		super.sql.append("	,BASE_HEAD.KNU_AMT KNU_AMT \n");
		super.sql.append("	,(SELECT  \n");
		super.sql.append("		SUM(BKN.KEI_AMT_STAX) \n");
		super.sql.append("		FROM T_KEI KEI \n");
		super.sql.append("		INNER JOIN T_BKN BKN ON BKN.LC_CD = KEI.LC_CD  \n");
		super.sql.append("					AND BKN.KEI_NO = KEI.KEI_NO \n");
		super.sql.append("		WHERE KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "'  \n");
		super.sql.append("		AND KEI.KEI_NO = '" + this.keiyakuNo + "' \n");
		super.sql.append("	 ) KEI_AMT_STAX_SUM \n");
		super.sql.append("	,BASE_HEAD.RSK_SUM RSK_SUM \n");
		super.sql.append("	,(SELECT  \n");
		super.sql.append("		NVL(SUM(BKN.ZANK_HSHO_AMT),0)  \n");
		super.sql.append("		FROM T_KEI KEI \n");
		super.sql.append("		INNER JOIN T_BKN BKN ON BKN.LC_CD = KEI.LC_CD  \n");
		super.sql.append("					AND BKN.KEI_NO = KEI.KEI_NO  \n");
		super.sql.append("					AND (BKN.ZANK_HSHOSK_CD = KEI.LU_TRSK_CD OR BKN.IPN_ZANK_HSHOSK_CD = KEI.LU_TRSK_CD) \n");
		super.sql.append("		WHERE KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "'  \n");
		super.sql.append("		AND KEI.KEI_NO = '" + this.keiyakuNo + "' \n");
		super.sql.append("	 ) ZANK_HSHO_AMT_SUM \n");

		super.sql.append("      ,CASE " + "\n");
		super.sql.append("   	    WHEN RSK_KEIJ_HOHO_KBN = '" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' THEN " + "\n");
		super.sql.append("   	        0 " + "\n");
		super.sql.append("   		ELSE " + "\n");
		super.sql.append("              IJI_HYO_SUM " + "\n");
		super.sql.append("       END IJI_HYO_SUM" + "\n");
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("   	    WHEN RSK_KEIJ_HOHO_KBN = '" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' THEN " + "\n");
		super.sql.append("   	        0 " + "\n");
		super.sql.append("   		ELSE " + "\n");
		super.sql.append("              EKM_HYO_SUM " + "\n");
		super.sql.append("       END EKM_HYO_SUM" + "\n");
		super.sql.append("	,BASE_HEAD.RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN \n");
		super.sql.append("	,BASE_HEAD.RSK_KEIJ_HOHO_KBN_NM RSK_KEIJ_HOHO_KBN_NM \n");
		super.sql.append("	,BASE_HEAD.TNKI_HOHO_KBN TNKI_HOHO_KBN \n");
		super.sql.append("	,BASE_HEAD.FKN_TNKI_HOHO_NM FKN_TNKI_HOHO_NM \n");
		super.sql.append("	,BASE_HEAD.GNKSK_HASU_CHSE_CD GNKSK_HASU_CHSE_CD \n");
		super.sql.append("	,BASE_HEAD.HASU_CHSE_NM HASU_CHSE_NM  \n");
		super.sql.append("	,BASE_HEAD.HYJYO_KEI_NO HYJYO_KEI_NO \n");
		super.sql.append("	,CASE SGK_SSN_KBN " + "\n");
		super.sql.append("		WHEN '1' THEN " + "\n");
		super.sql.append("			'少額資産(契約指定)' " + "\n");
		super.sql.append("		WHEN '0' THEN " + "\n");
		super.sql.append("			'非少額資産(契約指定)' " + "\n");
		super.sql.append("		ELSE " + "\n");
		super.sql.append("			CASE   " + "\n");
		super.sql.append("				WHEN KEI_AMT > 3000000 THEN " + "\n");
		super.sql.append("					'非少額資産(自動判定)' " + "\n");
		super.sql.append("				ELSE " + "\n");
		super.sql.append("					'少額資産(自動判定)' " + "\n");
		super.sql.append("			END " + "\n");
		super.sql.append("	END SGK_SSN " + "\n");
		super.sql.append("	,BASE_HEAD.SGK_SSN_KBN SGK_SSN_KBN \n");
		super.sql.append("	,DETAIL.BKN_NO BKN_NO \n");
		super.sql.append("	,DETAIL.BKN_NM BKN_NM \n");
		super.sql.append("	,DETAIL.KKI_NO KKI_NO \n");
		super.sql.append("	,DETAIL.SSN_SRI_CD SSN_SRI_CD \n");
		super.sql.append("	,DETAIL.SSN_SRI_NM SSN_SRI_NM \n");
		super.sql.append("	,DETAIL.ST_PLC_ADR ST_PLC_ADR \n");
		super.sql.append("	,DETAIL.BKN_SU BKN_SU \n");
		super.sql.append("	,DETAIL.BKN_SU BKN_SU \n");
		super.sql.append("	,DETAIL.BKN_UNT BKN_UNT \n");
		super.sql.append("	,DETAIL.KNU_AMT KNU_AMT \n");
		super.sql.append("	,DETAIL.WRBK_PV WRBK_PV \n");
		super.sql.append("	,DETAIL.WRBK_RS_RT WRBK_RS_RT \n");
		super.sql.append("	,DETAIL.RSK_CLC_RS_RT RSK_CLC_RS_RT \n");
		super.sql.append("	,DETAIL.IJI_KANRI_HI IJI_KANRI_HI \n");
		super.sql.append("	,DETAIL.EKM_TEIK_HI EKM_TEIK_HI \n");
		super.sql.append("	,DETAIL.ZANK_UMU ZANK_UMU \n");
		super.sql.append("	,DETAIL.SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN \n");
		super.sql.append("	,DETAIL.DISP_SKK_HOHO_NM DISP_SKK_HOHO_NM  \n");

		super.sql.append("FROM  \n");
		super.sql.append("	(SELECT  \n");
		super.sql.append("		LU.LU_NM LEASE_USER_NM \n");
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
		super.sql.append("						,HEAD.LAMT  \n");
		super.sql.append("						,HEAD.LAMT_STAX  \n");
		super.sql.append("						,DETAIL.YTE_TGTU_GNPN  \n");
		super.sql.append("						,DETAIL.YTE_TGTU_RSK  \n");
		super.sql.append("						,DETAIL.ZAND_GNPN  \n");
		
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
		
		// 20200416 arai 維持管理費用対応 start
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
		// 20200416 arai 維持管理費用対応 end
		
		super.sql.append("						,HEAD.YTE_IPN_EKM_TEIK_HYO  \n");
		super.sql.append("						+ HEAD.YTE_SHRY_EKM_TEIK_HYO EKM_TEIK_HYO  \n");
		
		//super.sql.append("						,(CASE HEAD.KI WHEN (SELECT MAX(KI) KI FROM T_UKB_TNKI_HEAD WHERE KEI_NO = '" + this.keiyakuNo + "' AND KAI_REC_FLG = 0) THEN DETAIL.GNPN_TTL ELSE 0 END) GNPN_TTL \n");		
		// 20200416 arai リース資産計上額対応 start
		super.sql.append("						,(CASE FKN.KI WHEN (SELECT FKN.KI FROM T_FKN_TNKI_HEAD FKN WHERE KEI_NO = '" + this.keiyakuNo + "' AND KAI_REC_FLG = 0 AND KI = 1) THEN FKN_DETAIL.GNPN_TTL ELSE 0 END) GNPN_TTL \n");
		// 20200416 arai リース資産計上額対応 end
		
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
		
		// 20210416 arai 維持管理費用対応 start
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
		// 20210416 arai 維持管理費用対応 end	
		
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
		super.sql.append(" 	WHERE KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "' AND KEI.KEI_NO = '" + this.keiyakuNo + "')BASE_HEAD, \n");
		super.sql.append("(SELECT DISTINCT BKN.KEI_NO " + "\n");
		super.sql.append("	  ,KEI.HYJYO_KEI_NO " + "\n");
		super.sql.append("    ,BKN.BKN_NO || CASE WHEN TRIM(BKN.BKN_EDANO) IS NULL THEN '' ELSE '-' || BKN.BKN_EDANO END BKN_NO" + "\n");
		super.sql.append("	  ,BKN.BKN_NM " + "\n");
		super.sql.append("	  ,BKN.KKI_NO " + "\n");
		super.sql.append("	  ,BKN.SSN_SRI_CD " + "\n");
		super.sql.append("	  ,SSN_SRI.SSN_SRI_NM " + "\n");
		super.sql.append("	  ,BKN.ST_PLC_ADR " + "\n");
		super.sql.append("	  ,BKN.BKN_SU " + "\n");
		super.sql.append("	  ,BKN.BKN_UNT " + "\n");
		super.sql.append("	  ,BKN.KNU_AMT " + "\n");

		//super.sql.append("      ,CASE " + "\n");
		//super.sql.append("           WHEN BKN.RSK_KEIJ_HOHO_KBN = '" + LACSDefine.RisokuKeijoHohoKbn.RSKHO_ZEN_GET_101 + "' THEN " + "\n");
		//super.sql.append("               LEAST(BKN.MBRI_WRBK_PV,BKN.KNU_AMT) " + "\n");
		//super.sql.append("           ELSE " + "\n");
		//super.sql.append("               LEAST(BKN.ABRI_WRBK_PV,BKN.KNU_AMT) " + "\n");
		//super.sql.append("       END WRBK_PV " + "\n");

		// 20200416 arai 取得価格相当額  対応 start
		super.sql.append("      ,(SELECT DETAIL.GNPN_TTL GNPN_TTL "+ "\n");
		super.sql.append("        FROM T_BKN BKN "+ "\n");
		super.sql.append("        INNER JOIN T_FKN_TNKI_HEAD HEAD ON "+ "\n");
		super.sql.append("                   BKN.KEI_NO = HEAD.KEI_NO AND BKN.LC_CD = HEAD.LC_CD "+ "\n");
		super.sql.append("                   AND BKN.BKN_NO = HEAD.BKN_NO AND BKN.BKN_EDANO = HEAD.BKN_EDANO "+ "\n");
		super.sql.append("        INNER JOIN T_FKN_TNKI_DETAIL DETAIL ON HEAD.KEI_NO = DETAIL.KEI_NO AND HEAD.LC_CD = DETAIL.LC_CD  "+ "\n");
		super.sql.append("                   AND HEAD.BKN_NO = DETAIL.BKN_NO AND HEAD.BKN_EDANO = DETAIL.BKN_EDANO "+ "\n");
		super.sql.append("                   AND HEAD.KEIJ_YM = DETAIL.KEIJ_YM  "+ "\n");
		super.sql.append("                   AND BKN.RSK_KEIJ_HOHO_KBN = DETAIL.KEIJ_HOHO_KBN  "+ "\n");
		super.sql.append("        WHERE HEAD.KI = 1 AND BKN.KEI_NO='" + this.keiyakuNo + "' ) WRBK_PV "+ "\n");
		// 20200416 arai 取得価格相当額  対応 end 
 		
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("           WHEN BKN.RSK_KEIJ_HOHO_KBN = '" + LACSDefine.RisokuKeijoHohoKbn.RSKHO_ZEN_GET_101 + "' THEN " + "\n");
		super.sql.append("               BKN.MBRI_WRBK_CLC_RS_RT " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("               BKN.ABRI_WRBK_CLC_RS_RT " + "\n");
		super.sql.append("       END WRBK_RS_RT " + "\n");

		super.sql.append("      ,CASE WHEN BKN.RSK_KEIJ_HOHO_KBN = '" + LACSDefine.RisokuKeijoHohoKbn.RSKHO_ZEN_GET_101 + "' THEN " + "\n");
		super.sql.append("               BKN.MBRI_RSK_CLC_RS_RT " + "\n");
		super.sql.append("            WHEN BKN.RSK_KEIJ_HOHO_KBN = '" + LACSDefine.RisokuKeijoHohoKbn.RSKHO_ATO_GET_102 + "' THEN " + "\n");
		super.sql.append("               BKN.ABRI_RSK_CLC_RS_RT " + "\n");
		super.sql.append("            ELSE " + "\n");
		super.sql.append("               NULL " + "\n");
		super.sql.append("       END RSK_CLC_RS_RT " + "\n");
		//super.sql.append("	  ,BKN.ENT_SHOHYO_KZI " + "\n");
		//super.sql.append("		+ BKN.ENT_SHOHYO_HKZI " + "\n");
		//super.sql.append("		+ BKN.GTAX " + "\n");
		//super.sql.append("		+ BKN.CTAX " + "\n");
		//super.sql.append("	    + BKN.JTAX " + "\n");
		//super.sql.append("		+ BKN.JBSK_HKN " + "\n");
		//super.sql.append("		+ BKN.NNI_HKN " + "\n");
		//super.sql.append("		+ BKN.RCYCL_RYO_KNRI_AMT " + "\n");
		//super.sql.append("		+ BKN.DOSO " + "\n");
		//super.sql.append("		+ BKN.KOZEI " + "\n");
		//super.sql.append("		+ BKN.OTH_CST IJI_KANRI_HI" + "\n");
		
		// 20200416 arai 維持管理費用対応 start 
		super.sql.append("	    ,(SELECT  SUM(FKN.ENT_SHOHYO_KZI " + "\n");
		super.sql.append("		        + FKN.ENT_SHOHYO_HKZI " + "\n");
		super.sql.append("		        + FKN.GTAX " + "\n");
		super.sql.append("		        + FKN.CTAX " + "\n");
		super.sql.append("		        + FKN.JBSK_HKN " + "\n");
		super.sql.append("		        + FKN.NNI_HKN " + "\n");
		super.sql.append("		        + FKN.RCYCL_RYO_KNRI_AMT " + "\n");
		super.sql.append("		        + FKN.DOSO " + "\n");
		super.sql.append("		        + FKN.KOZEI " + "\n");
		super.sql.append("		        + FKN.OTH_CST) IJI_KANRI_HI" + "\n");
		super.sql.append("		  FROM T_FKN_TNKI_HEAD FKN " + "\n");
		super.sql.append("        WHERE FKN.KEI_NO='" + this.keiyakuNo + "' ) IJI_KANRI_HI "+ "\n");
		// 20200416 arai 維持管理費用対応 end 
			
		super.sql.append("	  ,BKN.IPN_EKM_TEIK_HYO " + "\n");
		super.sql.append("		+ BKN.SHRY_EKM_TEIK_HYO EKM_TEIK_HI" + "\n");
		super.sql.append("	  ,DECODE(KEI.LU_TRSK_CD , BKN.ZANK_HSHOSK_CD , '有' , BKN.IPN_ZANK_HSHOSK_CD , '有' ,'無') ZANK_UMU " + "\n");
		super.sql.append("	  ,BKN.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("	  ,KEIJ_HOHO_KBN.DISP_SKK_HOHO_NM " + "\n");
		super.sql.append("FROM   T_BKN BKN " + "\n");
		super.sql.append("JOIN   T_KEI KEI ON KEI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("			 AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("JOIN   M_LC LC ON LC.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("JOIN   M_SSN_SRI SSN_SRI ON BKN.SSN_SRI_CD = SSN_SRI.SSN_SRI_CD " + "\n");
		super.sql.append("LEFT JOIN   M_SKK_KEIJ_HOHO_KBN KEIJ_HOHO_KBN ON KEIJ_HOHO_KBN.SKK_KEIJ_HOHO_KBN = BKN.SKK_KEIJ_HOHO_KBN " + "\n");
		
		super.sql.append("WHERE KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "'  \n");
		super.sql.append("	AND KEI.KEI_NO='" + this.keiyakuNo + "' \n");
		super.sql.append("ORDER BY " + "\n");
		super.sql.append("	  BKN_NO ) DETAIL" + "\n");

	}

	/**
	 * リース会社コードを設定.
	 * 
	 * @param piLeasCompanyCode
	 *            リース会社コード
	 */
	public void setLeasCompanyCode(String piLeasCompanyCode) {
		this.leasCompanyCode = piLeasCompanyCode;
	}

	/**
	 * 契約番号を設定.
	 * 
	 * @param piKeiyakuNo
	 *            契約番号
	 */
	public void setKeiyakuNo(String piKeiyakuNo) {
		this.keiyakuNo = piKeiyakuNo;
	}

	/**
	 * 物件番号を取得.
	 * 
	 * @return 物件番号
	 */
	public String getBukkenNo() {
		return super.getString("BKN_NO");
	}

	/**
	 * 物件名を取得.
	 * 
	 * @return 物件名
	 */
	public String getBukkenName() {
		return super.getString("BKN_NM", "");
	}

	/**
	 * 機械番号を取得.
	 * 
	 * @return 機械番号
	 */
	public String getKikaiNo() {
		return super.getString("KKI_NO", "");
	}

	/**
	 * 資産種類を取得.
	 * 
	 * @return 資産種類
	 */
	public String getSisanSyurui() {
		return super.getString("SSN_SRI_CD");
	}

	/**
	 * 資産種類名を取得.
	 * 
	 * @return 資産種類名
	 */
	public String getSisanSyuruiName() {
		return super.getString("SSN_SRI_NM");
	}

	/**
	 * 設置場所を取得.
	 * 
	 * @return 設置場所
	 */
	public String getSettiBasyo() {
		return super.getString("ST_PLC_ADR", "");
	}

	/**
	 * 数量を取得.
	 * 
	 * @return 数量
	 */
	public long getSuryo() {
		return super.getLong("BKN_SU");
	}

	/**
	 * 単位を取得.
	 * 
	 * @return 単位
	 */
	public String getTani() {
		return super.getString("BKN_UNT", "");
	}

	/**
	 * 割引現在価値（物件）を取得.
	 * 
	 * @return 割引現在価値（物件）
	 */
	public long getBknWaribikiGenzaiKati() {
		return super.getLong("WRBK_PV");
	}

	/**
	 * 割引計算利子率を取得.
	 * 
	 * @return 割引計算利子率
	 */
	public long getWaribikiKeisanRisiRitu() {
		return super.getLong("WRBK_RS_RT");
	}

	/**
	 * 利息計算利子率を取得.
	 * 
	 * @return 利息計算利子率
	 */
	public long getRisokuKeisanRisiRitu() {
		return super.getLong("RSK_CLC_RS_RT");
	}

	/**
	 * 維持管理費を取得.
	 * 
	 * @return 維持管理費
	 */
	public long getIjikanriHi() {
		return super.getLong("IJI_KANRI_HI");
	}

	/**
	 * 役務提供費を取得.
	 * 
	 * @return 役務提供費
	 */
	public long getEkimuteikyoHi() {
		return super.getLong("EKM_TEIK_HI");
	}

	/**
	 * 残価保証有無を取得.
	 * 
	 * @return 残価保証有無
	 */
	public String getZankaHosyoUmu() {
		return super.getString("ZANK_UMU");
	}

	/**
	 * 償却計上方法区分を取得.
	 * 
	 * @return 償却計上方法区分
	 */
	public String getSaiyoSkkKeijoKbn() {
		return super.getString("SKK_KEIJ_HOHO_KBN");
	}

	/**
	 * 償却計上方法区分名称を取得.
	 * 
	 * @return 償却計上方法区分名称
	 */
	public String getSaiyoSkkKeijoKbnName() {
		return super.getString("DISP_SKK_HOHO_NM");
	}

	/**
	 * 少額資産名を取得.
	 * 
	 * @return 少額資産名
	 */
	public String getSyougakuSisanName() {
		return super.getString("SGK_SSN");
	}

	/**
	 * 少額資産区分を取得.
	 * 
	 * @return 少額資産区分
	 */
	public String getSyougakuSisanKbn() {
		return super.getString("SGK_SSN_KBN");
	}
}
