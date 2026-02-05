package jp.co.pro_app.lacs.affairs.monthreport.data.entity;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 契約検索画面および契約照会画面：リース会計基準明細書 Entity.
 * 
 * @author fukuhara
 * @version 20080411
 */
public class LACSMReportKaikeiMeisaiEntity extends LACSMReportEntityBase {

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
	public LACSMReportKaikeiMeisaiEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSMReportBean piReportBean) throws SQLException {
		super(piModel, piCommonBean, piReportBean);
	}
	
	/**
	 * ＳＱＬを生成.
	 */
	@Override
	protected void makeSQL() {

		super.sql.append("SELECT \n");
		super.sql.append("	LU_COSMOS_CD \n");
		super.sql.append("	,CREATE_DATE \n");
		super.sql.append("	,LEASE_USER_NM \n");
		super.sql.append("	,LEASE_COMPANY_NM \n");
		super.sql.append("	,LEASE_COMPANY_ZIP \n");
		super.sql.append("	,LEASE_COMPANY_ADDR1 \n");
		super.sql.append("	,LEASE_COMPANY_ADDR2 \n");
		super.sql.append("	,LEASE_COMPANY_TELNO \n");
		super.sql.append("	,KEI_NO \n");
		super.sql.append("	,KEI_TERM \n");
		super.sql.append("	,KEI_YMD \n");
		super.sql.append("	,KNSHU_YMD \n");
		super.sql.append("	,MRYO_YMD \n");
		super.sql.append("	,DIH_BKN_NM \n");
		super.sql.append("	,TRD_HNTE_KEKA_KBN \n");
		super.sql.append("	,TRD_HNTE_KEKA_NM \n");		
		//super.sql.append("	,LAMT_SUM \n");
		// 2021/5/14 リース資産計上額 対応 start 
		super.sql.append("	,(SELECT  \n");
		super.sql.append("		BKN.KNU_AMT \n");
		super.sql.append("		FROM T_KEI KEI \n");
		super.sql.append("		INNER JOIN T_BKN BKN ON BKN.LC_CD = KEI.LC_CD  \n");
		super.sql.append("					AND BKN.KEI_NO = KEI.KEI_NO \n");
		super.sql.append("		WHERE KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "'  \n");					
		super.sql.append("      AND KEI.KEI_NO = '" + this.keiyakuNo + "' \n");
		super.sql.append("	 　) LAMT_SUM \n");	
		// 2021/5/14  リース資産計上額 対応 end		
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
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("   	    WHEN " + super.getRisokuKeijoHohoKbn("") + " = '" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' THEN " + "\n");
		super.sql.append("   	        0 " + "\n");
		super.sql.append("   		ELSE " + "\n");
		super.sql.append("              IJI_HYO_SUM " + "\n");
		super.sql.append("       END IJI_HYO_SUM" + "\n");
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("   	    WHEN " + super.getRisokuKeijoHohoKbn("") + " = '" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' THEN " + "\n");
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
		super.sql.append("	,DECODE(BASE1.KEIJ_YM,lag(BASE1.KEIJ_YM) over(partition by BASE1.KEIJ_YM order by BASE1.KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',BASE1.KEIJ_YM) KEIJ_YM \n");
		super.sql.append("	,DECODE(BASE1.KEIJ_YM,lag(BASE1.KEIJ_YM) over(partition by BASE1.KEIJ_YM order by BASE1.KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',LAMT) LAMT \n");
		super.sql.append("	,DECODE(BASE1.KEIJ_YM,lag(BASE1.KEIJ_YM) over(partition by BASE1.KEIJ_YM order by BASE1.KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',TGTU_GNPN) TGTU_GNPN \n");
		super.sql.append("	,DECODE(BASE1.KEIJ_YM,lag(BASE1.KEIJ_YM) over(partition by BASE1.KEIJ_YM order by BASE1.KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',TGTU_RSK) TGTU_RSK \n");
		super.sql.append("	,DECODE(BASE1.KEIJ_YM,lag(BASE1.KEIJ_YM) over(partition by BASE1.KEIJ_YM order by BASE1.KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',DECODE(" + super.getRisokuKeijoHohoKbn("") + ",'" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "', '0', IJI_KANRI_HYO)) IJI_KANRI_HYO \n");
		super.sql.append("	,DECODE(BASE1.KEIJ_YM,lag(BASE1.KEIJ_YM) over(partition by BASE1.KEIJ_YM order by BASE1.KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',DECODE(" + super.getRisokuKeijoHohoKbn("") + ",'" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "', '0', EKM_TEIK_HYO)) EKM_TEIK_HYO \n");
		super.sql.append("	,DECODE(BASE1.KEIJ_YM,lag(BASE1.KEIJ_YM) over(partition by BASE1.KEIJ_YM order by BASE1.KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',ZAND_GNPN) ZAND_GNPN \n");
		super.sql.append("	,DECODE(BASE1.KEIJ_YM,lag(BASE1.KEIJ_YM) over(partition by BASE1.KEIJ_YM order by BASE1.KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',MK_LAMT) MK_LAMT \n");
		super.sql.append("	,DECODE(KRKT_AMT,0, DECODE(KR_KNJ_KMK_NM,lag(KR_KNJ_KMK_NM) over(partition by BASE1.KEIJ_YM order by BASE1.KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',KR_KNJ_KMK_CD),KR_KNJ_KMK_CD) KR_KNJ_KMK_CD \n");
		super.sql.append("	,DECODE(KRKT_AMT,0, DECODE(KR_KNJ_KMK_NM,lag(KR_KNJ_KMK_NM) over(partition by BASE1.KEIJ_YM order by BASE1.KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',KR_KNJ_KMK_NM),KR_KNJ_KMK_NM) KR_KNJ_KMK_NM \n");
		super.sql.append("	,DECODE(KRKT_AMT,0, DECODE(KR_KNJ_KMK_NM,lag(KR_KNJ_KMK_NM) over(partition by BASE1.KEIJ_YM order by BASE1.KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',KRKT_AMT),KRKT_AMT) KRKT_AMT \n");
		super.sql.append("	,DECODE(KSKT_AMT,0, DECODE(KS_KNJ_KMK_NM,lag(KS_KNJ_KMK_NM) over(partition by BASE1.KEIJ_YM order by BASE1.KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',KS_KNJ_KMK_CD),KS_KNJ_KMK_CD) KS_KNJ_KMK_CD \n");
		super.sql.append("	,DECODE(KSKT_AMT,0, DECODE(KS_KNJ_KMK_NM,lag(KS_KNJ_KMK_NM) over(partition by BASE1.KEIJ_YM order by BASE1.KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',KS_KNJ_KMK_NM),KS_KNJ_KMK_NM) KS_KNJ_KMK_NM \n");
		super.sql.append("	,DECODE(KSKT_AMT,0, DECODE(KS_KNJ_KMK_NM,lag(KS_KNJ_KMK_NM) over(partition by BASE1.KEIJ_YM order by BASE1.KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',KSKT_AMT),KSKT_AMT) KSKT_AMT \n");
		super.sql.append("	,BASE_HEAD.HYJYO_KEI_NO \n");
		super.sql.append("	,CASE WHEN (SELECT M_OPTION.OPT_VALUE FROM M_OPTION WHERE M_OPTION.OPT_CD = 1) = '1' AND CHA_YM IS NOT NULL THEN \n");
		super.sql.append("		SUBSTRB(WARNING,1,8) \n");
		super.sql.append("	 END WARNING1 \n");
		super.sql.append("	,CASE WHEN (SELECT M_OPTION.OPT_VALUE FROM M_OPTION WHERE M_OPTION.OPT_CD = 1) = '1' AND CHA_YM IS NOT NULL THEN \n");
		super.sql.append("		'この契約は' || SUBSTRB(CHA_YM,1,4) || '年' || SUBSTRB(CHA_YM,5,2) || '月にデータが変更されています。' \n");
		super.sql.append("	 END WARNING2 \n");
		super.sql.append("	,CASE WHEN (SELECT M_OPTION.OPT_VALUE FROM M_OPTION WHERE M_OPTION.OPT_CD = 1) = '1' AND CHA_YM IS NOT NULL THEN \n");
		super.sql.append("		SUBSTRB(CHA_YM,1,4) || '年' || SUBSTRB(CHA_YM,5,2) || '月以前に対する修正仕訳を' || SUBSTRB(CHA_YM,1,4) || '年' || SUBSTRB(CHA_YM,5,2) || '月の仕訳として合算表示しています。' \n");
		super.sql.append("	 END WARNING3 \n");
		super.sql.append("	,CASE WHEN (SELECT M_OPTION.OPT_VALUE FROM M_OPTION WHERE M_OPTION.OPT_CD = 1) = '1' AND CHA_YM IS NOT NULL THEN \n");
		super.sql.append("		CHA_YM \n");
		super.sql.append("	 END CHA_YM \n");
		// super.sql.append(" ,CHA_YM \n");
		super.sql.append("FROM  \n");
		super.sql.append("	(SELECT  \n");
		super.sql.append("		KEI.LU_COSMOS_CD \n");
		super.sql.append("		,to_char(CURRENT_DATE,'yyyymmdd') CREATE_DATE \n");
		super.sql.append("		,LU.LU_NM LEASE_USER_NM \n");
		super.sql.append("		,DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_NM, LU.PDF_COMPANY_NM) LEASE_COMPANY_NM \n");
		super.sql.append("		,DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_ZIP1 || '-' || LC.LC_ZIP2, LU.PDF_COMPANY_ZIP1 || '-' || LU.PDF_COMPANY_ZIP2) LEASE_COMPANY_ZIP \n");
		super.sql.append("		,DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_ADR1, LU.PDF_COMPANY_ADR1) LEASE_COMPANY_ADDR1 \n");
		super.sql.append("		,DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_ADR2, LU.PDF_COMPANY_ADR2) LEASE_COMPANY_ADDR2 \n");
		super.sql.append("		,DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_TNT_TELNO, LU.PDF_COMPANY_TELNO) LEASE_COMPANY_TELNO \n");
		super.sql.append("		,MG_KEI.KEI_NO KEI_NO \n");
		super.sql.append("		,KEI.KEI_TERM KEI_TERM \n");
		super.sql.append("		,KEI.KEI_YMD KEI_YMD \n");
		super.sql.append("		,KEI.KNSHU_YMD KNSHU_YMD \n");
		super.sql.append("		,KEI.MRYO_YMD MRYO_YMD \n");
		super.sql.append("		,KEI.DIH_BKN_NM DIH_BKN_NM \n");
		super.sql.append("		,KEI.TRD_HNTE_KEKA_KBN TRD_HNTE_KEKA_KBN \n");
		super.sql.append("		,TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_NM TRD_HNTE_KEKA_NM \n");
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
		//super.sql.append("		,LAMT_SUM \n");
		super.sql.append("		,KEI.HYJYO_KEI_NO \n");
		super.sql.append("		,'（注意）' WARNING \n");
		super.sql.append("		,KEI.CHA_YM CHA_YM \n");
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
		//super.sql.append("					,SUM(GNPN_TTL) LAMT_SUM \n");
		super.sql.append("					,SUM(TGTU_RSK) RSK_SUM  \n");
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
		super.sql.append("						,DETAIL.YTE_TGTU_GNPN TGTU_GNPN \n");
		super.sql.append("						,DETAIL.YTE_TGTU_RSK TGTU_RSK \n");
		super.sql.append("						,DETAIL.ZAND_GNPN  \n");
		super.sql.append("						,HEAD.YTE_ENT_SHOHYO_KZI  \n");
		super.sql.append("						+ HEAD.YTE_ENT_SHOHYO_HKZI  \n");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
		super.sql.append("						+ HEAD.YTE_GTAX  \n");
		super.sql.append("						+ HEAD.YTE_CTAX  \n");
		super.sql.append("						+ HEAD.YTE_JTAX  \n");
		super.sql.append("						+ HEAD.YTE_JBSK_HKN  \n");
		super.sql.append("						+ HEAD.YTE_NNI_HKN  \n");
		super.sql.append("						+ HEAD.YTE_RCYCL_RYO_KNRI_AMT  \n");
		super.sql.append("						+ HEAD.YTE_DOSO + HEAD.YTE_KOZEI  \n");
		super.sql.append("						+ HEAD.YTE_OTH_CST IJI_KANRI_HYO  \n");
		super.sql.append("						,HEAD.YTE_IPN_EKM_TEIK_HYO  \n");
		super.sql.append("						+ HEAD.YTE_SHRY_EKM_TEIK_HYO EKM_TEIK_HYO  \n");
		//super.sql.append("						,DETAIL.YTE_TGTU_GNPN GNPN_TTL \n");
		
		// 20210510 arai リース資産計上額 取得項目変更対応 start
		//super.sql.append("						,BKN.KNU_AMT GNPN_TTL \n");
		// 20210510 arai リース資産計上額 取得項目変更対応 end
		
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
		super.sql.append("						WHERE KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "'  \n");
		super.sql.append("						AND KEI.KEI_NO = '" + this.keiyakuNo + "' \n");		
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
		//super.sql.append("						,0 GNPN_TTL  \n");
		super.sql.append("						FROM \n");
		super.sql.append("						T_KEI KEI  \n");
		super.sql.append("						INNER JOIN T_BKN BKN ON KEI.LC_CD = BKN.LC_CD  \n");
		super.sql.append("											AND KEI.KEI_NO = BKN.KEI_NO  \n");
		super.sql.append("						INNER JOIN T_UKB_GNKSK GNK ON BKN.LC_CD = GNK.LC_CD  \n");
		super.sql.append("											AND BKN.KEI_NO = GNK.KEI_NO  \n");
		super.sql.append("											AND BKN.BKN_NO = GNK.BKN_NO  \n");
		super.sql.append("											AND BKN.BKN_EDANO = GNK.BKN_EDANO  \n");
		super.sql.append("											AND BKN.SKK_KEIJ_HOHO_KBN = GNK.KEIJ_HOHO_KBN  \n");
		super.sql.append(" 											AND GNK.KAI_REC_FLG = '0' \n");
		super.sql.append("						WHERE KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "'  \n");
		super.sql.append("						AND KEI.KEI_NO = '" + this.keiyakuNo + "') \n");
		super.sql.append("				GROUP BY LU_COSMOS_CD ,HYJYO_KEI_NO \n");		
		super.sql.append("				) BASE_SUM ON BASE_SUM.LU_COSMOS_CD = KEI.LU_COSMOS_CD  \n");
		super.sql.append("							AND BASE_SUM.HYJYO_KEI_NO = KEI.HYJYO_KEI_NO \n");
		super.sql.append("		LEFT JOIN M_TRD_HNTE_KEKA_KBN TRD_HNTE_KEKA_KBN ON TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN = KEI.TRD_HNTE_KEKA_KBN \n");
		super.sql.append("		LEFT JOIN M_RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN ON RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN = KEI.RSK_KEIJ_HOHO_KBN \n");
		super.sql.append("		LEFT JOIN M_FKN_TNKI_HOHO_CD FKN_TNKI_HOHO_CD ON FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_CD = KEI.TNKI_HOHO_KBN \n");
		super.sql.append("		LEFT JOIN M_HASU_CHSE_CD HASU_CHSE_CD ON HASU_CHSE_CD.HASU_CHSE_CD = KEI.GNKSK_HASU_CHSE_CD \n");
		//super.sql.append(" 	WHERE KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "' AND KEI.KEI_NO = '" + this.keiyakuNo + "' \n");
		super.sql.append(" 	WHERE KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "' \n");
		super.sql.append("    AND KEI.KEI_NO = '" + this.keiyakuNo + "' \n");	
		super.sql.append("	) BASE_HEAD, \n");
		super.sql.append("	(SELECT \n");
		super.sql.append("		BASE.KEIJ_YM  \n");
		super.sql.append("		,SUM(LAMT + LAMT_STAX) LAMT  \n");
		super.sql.append("		,SUM(TGTU_GNPN) TGTU_GNPN  \n");
		super.sql.append("		,SUM(TGTU_RSK) TGTU_RSK  \n");
		super.sql.append("		,SUM(IJI_KANRI_HYO) IJI_KANRI_HYO  \n");
		super.sql.append("		,SUM(EKM_TEIK_HYO) EKM_TEIK_HYO  \n");
		super.sql.append("		,SUM(ZAND_GNPN) ZAND_GNPN  \n");
		super.sql.append("	FROM \n");
		super.sql.append("		(SELECT \n");
		super.sql.append("			KEI.LU_COSMOS_CD  \n");
		super.sql.append("			,KEI.HYJYO_KEI_NO  \n");
		super.sql.append("			,HEAD.LC_CD  \n");
		super.sql.append("			,HEAD.KEI_NO  \n");
		super.sql.append("			,HEAD.KEIJ_YM  \n");
		super.sql.append("			,HEAD.BKN_NO  \n");
		super.sql.append("			,HEAD.BKN_EDANO  \n");
		super.sql.append("			,HEAD.LAMT  \n");
		super.sql.append("			,HEAD.LAMT_STAX  \n");
		super.sql.append("			,DETAIL.TGTU_GNPN  \n");
		super.sql.append("			,DETAIL.TGTU_RSK  \n");
		super.sql.append("			,DETAIL.ZAND_GNPN  \n");
		super.sql.append("			,HEAD.ENT_SHOHYO_KZI  \n");
		super.sql.append("			+ HEAD.ENT_SHOHYO_HKZI  \n");
		super.sql.append("			+ HEAD.GTAX  \n");
		super.sql.append("			+ HEAD.CTAX  \n");
		super.sql.append("			+ HEAD.JTAX  \n");
		super.sql.append("			+ HEAD.JBSK_HKN  \n");
		super.sql.append("			+ HEAD.NNI_HKN  \n");
		super.sql.append("			+ HEAD.RCYCL_RYO_KNRI_AMT  \n");
		super.sql.append("			+ HEAD.DOSO  \n");
		super.sql.append("			+ HEAD.KOZEI  \n");
		super.sql.append("			+ HEAD.OTH_CST IJI_KANRI_HYO  \n");
		super.sql.append("			,HEAD.IPN_EKM_TEIK_HYO  \n");
		super.sql.append("			+ HEAD.SHRY_EKM_TEIK_HYO EKM_TEIK_HYO  \n");
		super.sql.append("		FROM \n");
		super.sql.append("			T_KEI KEI  \n");
		super.sql.append("			INNER JOIN T_BKN BKN ON KEI.LC_CD = BKN.LC_CD  \n");
		super.sql.append("						AND KEI.KEI_NO = BKN.KEI_NO  \n");
		super.sql.append("			INNER JOIN T_UKB_TNKI_HEAD HEAD ON BKN.LC_CD = HEAD.LC_CD  \n");
		super.sql.append("								AND BKN.KEI_NO = HEAD.KEI_NO  \n");
		super.sql.append("								AND BKN.BKN_NO = HEAD.BKN_NO  \n");
		super.sql.append("								AND BKN.BKN_EDANO = HEAD.BKN_EDANO  \n");
		super.sql.append(" 								AND HEAD.KAI_REC_FLG = '0' \n");
		super.sql.append("			INNER JOIN T_UKB_TNKI_DETAIL DETAIL ON HEAD.LC_CD = DETAIL.LC_CD  \n");
		super.sql.append("								AND HEAD.KEI_NO = DETAIL.KEI_NO  \n");
		super.sql.append("								AND HEAD.BKN_NO = DETAIL.BKN_NO  \n");
		super.sql.append("								AND HEAD.BKN_EDANO = DETAIL.BKN_EDANO  \n");
		super.sql.append("								AND HEAD.KEIJ_YM = DETAIL.KEIJ_YM  \n");
		super.sql.append("								AND BKN.RSK_KEIJ_HOHO_KBN = DETAIL.KEIJ_HOHO_KBN  \n");
		super.sql.append("		UNION ALL \n");
		super.sql.append("		SELECT \n");
		super.sql.append("			KEI.LU_COSMOS_CD  \n");
		super.sql.append("			,KEI.HYJYO_KEI_NO  \n");
		super.sql.append("			,GNK.LC_CD  \n");
		super.sql.append("			,GNK.KEI_NO  \n");
		super.sql.append("			,GNK.KEIJ_YM  \n");
		super.sql.append("			,GNK.BKN_NO  \n");
		super.sql.append("			,GNK.BKN_EDANO  \n");
		super.sql.append("			,0 LAMT  \n");
		super.sql.append("			,0 LAMT_STAX  \n");
		super.sql.append("			,0 TGTU_GNPN  \n");
		super.sql.append("			,0 TGTU_RSK  \n");
		super.sql.append("			,0 ZAND_GNPN  \n");
		super.sql.append("			,0 IJI_KANRI_HYO  \n");
		super.sql.append("			,0 EKM_TEIK_HYO  \n");
		super.sql.append("		FROM \n");
		super.sql.append("			T_KEI KEI  \n");
		super.sql.append("			INNER JOIN T_BKN BKN ON KEI.LC_CD = BKN.LC_CD  \n");
		super.sql.append("						AND KEI.KEI_NO = BKN.KEI_NO  \n");
		super.sql.append("			INNER JOIN T_UKB_GNKSK GNK ON BKN.LC_CD = GNK.LC_CD  \n");
		super.sql.append("						AND BKN.KEI_NO = GNK.KEI_NO  \n");
		super.sql.append("						AND BKN.BKN_NO = GNK.BKN_NO  \n");
		super.sql.append("						AND BKN.BKN_EDANO = GNK.BKN_EDANO  \n");
		super.sql.append("						AND BKN.SKK_KEIJ_HOHO_KBN = GNK.KEIJ_HOHO_KBN  \n");
		super.sql.append(" 						AND GNK.KAI_REC_FLG = '0' \n");
		super.sql.append("		) BASE  \n");
		super.sql.append("	WHERE BASE.LU_COSMOS_CD = '" + this.leasCompanyCode + "'  \n");
		super.sql.append("	AND BASE.KEI_NO='" + this.keiyakuNo + "' \n");
		super.sql.append("	GROUP  BY BASE.KEIJ_YM ) BASE1 \n");
		super.sql.append("	INNER JOIN  \n");
		super.sql.append("		(SELECT \n");
		super.sql.append("			BASE2.KEIJ_YM  \n");
		super.sql.append("			,SUM(LAMT) MK_LAMT  \n");
		super.sql.append("		FROM (SELECT DISTINCT \n");
		super.sql.append("			BASE.KEI_NO   \n");
		super.sql.append("			,BASE.KEIJ_YM   \n");
		super.sql.append("			,BASE.KEI_AMT - NVL((SELECT SUM(FKN2.LAMT)   \n");
		super.sql.append("						FROM T_UKB_TNKI_HEAD FKN2  \n");
		super.sql.append("						WHERE  FKN2.LC_CD = BASE.LC_CD  \n");
		super.sql.append("						AND FKN2.KEI_NO = BASE.KEI_NO  \n");
		super.sql.append("						AND FKN2.KEIJ_YM <= BASE.KEIJ_YM \n");
		super.sql.append(" 						AND FKN2.KAI_REC_FLG ='0' \n");
		super.sql.append("						),0) LAMT  \n");
		super.sql.append("		FROM (SELECT  \n");
		super.sql.append("			KEI.LU_COSMOS_CD  \n");
		super.sql.append("			,BKN.LC_CD  \n");
		super.sql.append("			,BKN.KEI_NO  \n");
		super.sql.append("			,RSK.KEIJ_YM  \n");
		super.sql.append("			,KEI.TRD_HNTE_KEKA_KBN  \n");
		super.sql.append("			,KEI.KEI_AMT  \n");
		super.sql.append("			FROM  \n");
		super.sql.append("			T_KEI KEI  \n");
		super.sql.append("			INNER JOIN T_BKN BKN ON KEI.LC_CD = BKN.LC_CD  \n");
		super.sql.append("						AND KEI.KEI_NO = BKN.KEI_NO  \n");
		super.sql.append("			INNER JOIN T_RSK_KEIJ_SIWAKE RSK ON BKN.LC_CD = RSK.LC_CD  \n");
		super.sql.append("								AND BKN.KEI_NO = RSK.KEI_NO  \n");
		super.sql.append("								AND BKN.BKN_NO = RSK.BKN_NO  \n");
		super.sql.append("								AND BKN.BKN_EDANO = RSK.BKN_EDANO  \n");
		super.sql.append("								AND BKN.RSK_KEIJ_HOHO_KBN = RSK.KEIJ_HOHO_KBN  \n");
		super.sql.append(" 								AND RSK.KAI_REC_FLG = '0' \n");
		super.sql.append("			WHERE ABS(RSK.KRKT_AMT) + ABS(RSK.KSKT_AMT) > 0  \n");
		super.sql.append("			AND KEI.KEI_NO = '" + this.keiyakuNo + "' \n");
		super.sql.append("			UNION ALL \n");
		super.sql.append("			SELECT  \n");
		super.sql.append("			KEI.LU_COSMOS_CD  \n");
		super.sql.append("			,SKK.LC_CD  \n");
		super.sql.append("			,SKK.KEI_NO  \n");
		super.sql.append("			,SKK.KEIJ_YM  \n");
		super.sql.append("			,KEI.TRD_HNTE_KEKA_KBN  \n");
		super.sql.append("			,KEI.KEI_AMT  \n");
		super.sql.append("			FROM T_KEI KEI  \n");
		super.sql.append("			INNER JOIN T_BKN BKN ON KEI.LC_CD = BKN.LC_CD  \n");
		super.sql.append("						AND KEI.KEI_NO = BKN.KEI_NO  \n");
		super.sql.append("			INNER JOIN T_SKK_KEIJ_SIWAKE SKK ON BKN.LC_CD = SKK.LC_CD  \n");
		super.sql.append("								AND BKN.KEI_NO = SKK.KEI_NO  \n");
		super.sql.append("								AND BKN.BKN_NO = SKK.BKN_NO  \n");
		super.sql.append("								AND BKN.BKN_EDANO = SKK.BKN_EDANO  \n");
		super.sql.append("								AND BKN.SKK_KEIJ_HOHO_KBN = SKK.KEIJ_HOHO_KBN  \n");
		super.sql.append(" 								AND SKK.KAI_REC_FLG = '0' \n");
		super.sql.append("			WHERE ABS(SKK.KRKT_AMT) + ABS(SKK.KSKT_AMT) > 0  \n");
		super.sql.append("			AND KEI.KEI_NO = '" + this.keiyakuNo + "' \n");
		super.sql.append("		) BASE  \n");
		super.sql.append("	WHERE BASE.LU_COSMOS_CD = '" + this.leasCompanyCode + "' ) BASE2  \n");
		super.sql.append("	GROUP  BY BASE2.KEIJ_YM  \n");
		super.sql.append("	) MIKEI_LAMT ON MIKEI_LAMT.KEIJ_YM = BASE1.KEIJ_YM \n");
		super.sql.append("	INNER JOIN (SELECT \n");
		super.sql.append("			BASE.KEIJ_YM \n");
		super.sql.append("			,BASE.SIWAKE_GYO \n");
		super.sql.append("			,BASE.SWK_KBN  \n");
		super.sql.append("			,BASE.KR_KNJ_KMK_CD  \n");
		super.sql.append("			,BASE.KR_KNJ_KMK_NM  \n");
		super.sql.append("			,SUM(BASE.KRKT_AMT) KRKT_AMT  \n");
		super.sql.append("			,BASE.KS_KNJ_KMK_CD  \n");
		super.sql.append("			,BASE.KS_KNJ_KMK_NM  \n");
		super.sql.append("			,SUM(BASE.KSKT_AMT) KSKT_AMT  \n");
		super.sql.append("	FROM (SELECT KEI.LU_COSMOS_CD  \n");
		super.sql.append("			,RSK.LC_CD  \n");
		super.sql.append("			,RSK.KEI_NO  \n");
		super.sql.append("			,RSK.KEIJ_YM  \n");
		super.sql.append("			,RSK.BKN_NO  \n");
		super.sql.append("			,RSK.BKN_EDANO  \n");
		super.sql.append("			,KEI.TRD_HNTE_KEKA_KBN  \n");
		super.sql.append("			,RSK.SIWAKE_GYO  \n");
		super.sql.append("			,SWK.KR_KNJ_KMK_CD  \n");
		super.sql.append("			,SWK.KR_KNJ_KMK_NM  \n");
		super.sql.append("			,RSK.KRKT_AMT  \n");
		super.sql.append("			,SWK.KS_KNJ_KMK_CD  \n");
		super.sql.append("			,SWK.KS_KNJ_KMK_NM  \n");
		super.sql.append("			,RSK.KSKT_AMT  \n");
		super.sql.append("			,'1' SWK_KBN  \n");
		super.sql.append("		FROM T_KEI KEI  \n");
		super.sql.append("		INNER JOIN T_BKN BKN ON KEI.LC_CD = BKN.LC_CD  \n");
		super.sql.append("					AND KEI.KEI_NO = BKN.KEI_NO  \n");
		super.sql.append("		INNER JOIN T_RSK_KEIJ_SIWAKE RSK ON BKN.LC_CD = RSK.LC_CD  \n");
		super.sql.append("							AND BKN.KEI_NO = RSK.KEI_NO  \n");
		super.sql.append("							AND BKN.BKN_NO = RSK.BKN_NO  \n");
		super.sql.append("							AND BKN.BKN_EDANO = RSK.BKN_EDANO  \n");
		super.sql.append("							AND BKN.RSK_KEIJ_HOHO_KBN = RSK.KEIJ_HOHO_KBN  \n");
		super.sql.append(" 							AND RSK.KAI_REC_FLG = '0' \n");
		super.sql.append("		INNER JOIN M_RSK_KEIJ_SIWAKE_TEIGI SWK ON KEI.SIWAKE_LU_COSMOS_CD = SWK.LU_COSMOS_CD  \n");
		super.sql.append("								AND BKN.RSK_KEIJ_HOHO_KBN = SWK.KEIJ_HOHO_KBN  \n");
		super.sql.append("								AND KEI.TRD_HNTE_KEKA_KBN = SWK.TRD_HNTE_KEKA_KBN  \n");
		super.sql.append("								AND KEI.TAISHO_AC_KIJYUN_CD = SWK.TAISHO_AC_KIJYUN_CD  \n");
		super.sql.append("								AND KEI.CTSHK_FLG = SWK.CTSHK_FLG  \n");
		super.sql.append("								AND BKN.SSN_SRI_CD = SWK.SSN_SRI_CD  \n");
		super.sql.append("								AND RSK.SIWAKE_GYO = SWK.SIWAKE_GYO  \n");
		super.sql.append("		WHERE KEI.KEI_NO = '" + this.keiyakuNo + "' \n");
		super.sql.append("		UNION ALL \n");
		super.sql.append("		SELECT \n");
		super.sql.append("			KEI.LU_COSMOS_CD  \n");
		super.sql.append("			,SKK.LC_CD  \n");
		super.sql.append("			,SKK.KEI_NO  \n");
		super.sql.append("			,SKK.KEIJ_YM  \n");
		super.sql.append("			,SKK.BKN_NO  \n");
		super.sql.append("			,SKK.BKN_EDANO  \n");
		super.sql.append("			,KEI.TRD_HNTE_KEKA_KBN  \n");
		super.sql.append("			,SKK.SIWAKE_GYO  \n");
		super.sql.append("			,SWK.KR_KNJ_KMK_CD  \n");
		super.sql.append("			,SWK.KR_KNJ_KMK_NM  \n");
		super.sql.append("			,SKK.KRKT_AMT  \n");
		super.sql.append("			,SWK.KS_KNJ_KMK_CD  \n");
		super.sql.append("			,SWK.KS_KNJ_KMK_NM  \n");
		super.sql.append("			,SKK.KSKT_AMT  \n");
		super.sql.append("			,'2' SWK_KBN  \n");
		super.sql.append("		FROM T_KEI KEI  \n");
		super.sql.append("		INNER JOIN T_BKN BKN ON KEI.LC_CD = BKN.LC_CD  \n");
		super.sql.append("				AND KEI.KEI_NO = BKN.KEI_NO  \n");
		super.sql.append("		INNER JOIN T_SKK_KEIJ_SIWAKE SKK ON BKN.LC_CD = SKK.LC_CD  \n");
		super.sql.append("							AND BKN.KEI_NO = SKK.KEI_NO  \n");
		super.sql.append("							AND BKN.BKN_NO = SKK.BKN_NO  \n");
		super.sql.append("							AND BKN.BKN_EDANO = SKK.BKN_EDANO  \n");
		super.sql.append("							AND BKN.SKK_KEIJ_HOHO_KBN = SKK.KEIJ_HOHO_KBN  \n");
		super.sql.append(" 							AND SKK.KAI_REC_FLG = '0' \n");
		super.sql.append("		INNER JOIN M_SKK_KEIJ_SIWAKE_TEIGI SWK ON KEI.SIWAKE_LU_COSMOS_CD = SWK.LU_COSMOS_CD  \n");
		super.sql.append("								AND BKN.SKK_KEIJ_HOHO_KBN = SWK.KEIJ_HOHO_KBN  \n");
		super.sql.append("								AND KEI.TRD_HNTE_KEKA_KBN = SWK.TRD_HNTE_KEKA_KBN  \n");
		super.sql.append("								AND KEI.TAISHO_AC_KIJYUN_CD = SWK.TAISHO_AC_KIJYUN_CD  \n");
		super.sql.append("								AND KEI.CTSHK_FLG = SWK.CTSHK_FLG  \n");
		super.sql.append("								AND BKN.SSN_SRI_CD = SWK.SSN_SRI_CD  \n");
		super.sql.append("								AND SKK.SIWAKE_GYO = SWK.SIWAKE_GYO  \n");
		super.sql.append("		WHERE KEI.KEI_NO = '" + this.keiyakuNo + "' \n");
		super.sql.append("	) BASE  \n");
		super.sql.append("	WHERE BASE.LU_COSMOS_CD = '" + this.leasCompanyCode + "' \n");
		super.sql.append("	GROUP BY  \n");
		super.sql.append("		BASE.KEIJ_YM \n");
		super.sql.append("		,BASE.SWK_KBN  \n");
		super.sql.append("		,BASE.SIWAKE_GYO  \n");
		super.sql.append("		,BASE.KR_KNJ_KMK_CD  \n");
		super.sql.append("		,BASE.KR_KNJ_KMK_NM  \n");
		super.sql.append("		,BASE.KS_KNJ_KMK_CD  \n");
		super.sql.append("		,BASE.KS_KNJ_KMK_NM  \n");
		super.sql.append("	) KAMOKU ON KAMOKU.KEIJ_YM = BASE1.KEIJ_YM  \n");
		super.sql.append(" 	ORDER BY  \n");
		super.sql.append("		BASE1.KEIJ_YM \n");
		super.sql.append("		,KAMOKU.SWK_KBN  \n");
		super.sql.append("		,KAMOKU.SIWAKE_GYO  \n");
		System.out.println(super.sql);
	}

	
	/**
	 * 作成日を取得.
	 * 
	 * @return 作成日
	 */
	public String getCreateDate() {
		return super.getString("CREATE_DATE");
	}

	/**
	 * リースユーザ名を取得.
	 * 
	 * @return リースユーザ名
	 */
	public String getLeaseUserNm() {
		return super.getString("LEASE_USER_NM");
	}

	/**
	 * リース会社名を取得.
	 * 
	 * @return リース会社名
	 */
	public String getLeaseCompanyNm() {
		return super.getString("LEASE_COMPANY_NM");
	}

	/**
	 * リース会社郵便番号を取得.
	 * 
	 * @return リース会社郵便番号
	 */
	public String getLeaseCompanyZip() {
		return super.getString("LEASE_COMPANY_ZIP");
	}

	/**
	 * リース会社住所１を取得.
	 * 
	 * @return リース会社住所１
	 */
	public String getLeaseCompanyAddr1() {
		return super.getString("LEASE_COMPANY_ADDR1");
	}

	/**
	 * リース会社住所２を取得.
	 * 
	 * @return リース会社住所２
	 */
	public String getLeaseCompanyAddr2() {
		return super.getString("LEASE_COMPANY_ADDR2");
	}

	/**
	 * リース会社電話番号を取得.
	 * 
	 * @return リース会社電話番号
	 */
	public String getLeaseCompanyTelno() {
		return super.getString("LEASE_COMPANY_TELNO");
	}

	/**
	 * 契約番号を取得.
	 * 
	 * @return 契約番号
	 */
	public String getKeiNo() {
		return super.getString("KEI_NO");
	}

	/**
	 * 期間を取得.
	 * 
	 * @return 期間
	 */
	public String getKeiTerm() {
		return super.getString("KEI_TERM");
	}

	/**
	 * 契約日を取得.
	 * 
	 * @return 契約日
	 */
	public String getKeiYmd() {
		return super.getString("KEI_YMD");
	}

	/**
	 * 検収日を取得.
	 * 
	 * @return 検収日
	 */
	public String getKnshuYmd() {
		return super.getString("KNSHU_YMD");
	}

	/**
	 * 満了日を取得.
	 * 
	 * @return 満了日
	 */
	public String getMryoYmd() {
		return super.getString("MRYO_YMD");
	}

	/**
	 * 代表物件名を取得.
	 * 
	 * @return 代表物件名
	 */
	public String getDihBknNm() {
		return super.getString("DIH_BKN_NM");
	}

	/**
	 * 取引判定結果区分を取得.
	 * 
	 * @return 取引判定結果区分
	 */
	public String getTrdHnteKekaKbn() {
		return super.getString("TRD_HNTE_KEKA_KBN");
	}

	/**
	 * 取引判定結果名称を取得.
	 * 
	 * @return 取引判定結果名称
	 */
	public String getTrdHnteKekaNm() {
		return super.getString("TRD_HNTE_KEKA_NM");
	}

	/**
	 * リース料総額現在価値を取得.
	 * 
	 * @return リース料総額現在価値
	 */
	public String getLamtSum() {
		return super.getString("LAMT_SUM");
	}

	/**
	 * 契約額を取得.
	 * 
	 * @return 契約額
	 */
	public String getKeiAmt() {
		return super.getString("KEI_AMT");
	}

	/**
	 * 見積購入価額を取得.
	 * 
	 * @return 見積購入価額
	 */
	public String getKnuAmt() {
		return super.getString("KNU_AMT");
	}

	/**
	 * 消費税総額を取得.
	 * 
	 * @return 消費税総額
	 */
	public String getKeiAmtStaxSum() {
		return super.getString("KEI_AMT_STAX_SUM");
	}

	/**
	 * 利息総額を取得.
	 * 
	 * @return 利息総額
	 */
	public String getRskSum() {
		return super.getString("RSK_SUM");
	}

	/**
	 * 残価を取得.
	 * 
	 * @return 残価
	 */
	public String getZankHshoAmtSum() {
		return super.getString("ZANK_HSHO_AMT_SUM");
	}

	/**
	 * 維持管理費総額を取得.
	 * 
	 * @return 維持管理費総額
	 */
	public String getIjiHyoSum() {
		return super.getString("IJI_HYO_SUM");
	}

	/**
	 * 役務提供総額を取得.
	 * 
	 * @return 役務提供総額
	 */
	public String getEkmHyoSum() {
		return super.getString("EKM_HYO_SUM");
	}

	/**
	 * 利息計上方法区分を取得.
	 * 
	 * @return 利息計上方法区分
	 */
	public String getRskKeijHohoKbn() {
		return super.getString("RSK_KEIJ_HOHO_KBN");
	}

	/**
	 * 利息計上方法名称を取得.
	 * 
	 * @return 利息計上方法名称
	 */
	public String getRskKeijHohoKbnNm() {
		return super.getString("RSK_KEIJ_HOHO_KBN_NM");
	}

	/**
	 * 回収スケジュール展開方法を取得.
	 * 
	 * @return 回収スケジュール展開方法
	 */
	public String getTnkiHohoKbn() {
		return super.getString("TNKI_HOHO_KBN");
	}

	/**
	 * 回収スケジュール展開方法名称を取得.
	 * 
	 * @return 回収スケジュール展開方法名称
	 */
	public String getFknTnkiHohoNm() {
		return super.getString("FKN_TNKI_HOHO_NM");
	}

	/**
	 * 減価償却端数調整コードを取得.
	 * 
	 * @return 減価償却端数調整コード
	 */
	public String getGnkskHasuChseCd() {
		return super.getString("GNKSK_HASU_CHSE_CD");
	}

	/**
	 * 減価償却端数調整方法名称を取得.
	 * 
	 * @return 減価償却端数調整方法名称
	 */
	public String getHasuChseNm() {
		return super.getString("HASU_CHSE_NM");
	}

	/**
	 * 年月を取得.
	 * 
	 * @return 年月
	 */
	public String getKeijYm() {
		return super.getString("KEIJ_YM");
	}

	/**
	 * お支払金額を取得.
	 * 
	 * @return お支払金額
	 */
	public String getLamt() {
		return super.getString("LAMT");
	}

	/**
	 * うち元本を取得.
	 * 
	 * @return うち元本
	 */
	public String getTgtuGnpn() {
		return super.getString("TGTU_GNPN");
	}

	/**
	 * うち利息を取得.
	 * 
	 * @return うち利息
	 */
	public String getTgtuRsk() {
		return super.getString("TGTU_RSK");
	}

	/**
	 * 維持管理費を取得.
	 * 
	 * @return 維持管理費
	 */
	public String getIjiKanriHyo() {
		return super.getString("IJI_KANRI_HYO");
	}

	/**
	 * 役務提供費を取得.
	 * 
	 * @return 役務提供費
	 */
	public String getEkmTeikHyo() {
		return super.getString("EKM_TEIK_HYO");
	}

	/**
	 * 元本残高を取得.
	 * 
	 * @return 元本残高
	 */
	public String getZandGnpn() {
		return super.getString("ZAND_GNPN");
	}

	/**
	 * 未経過リース料を取得.
	 * 
	 * @return 未経過リース料
	 */
	public String getMkLamt() {
		return super.getString("MK_LAMT");
	}

	/**
	 * 借方科目コードを取得.
	 * 
	 * @return 借方科目コード
	 */
	public String getKrKnjKmkCd() {
		return super.getString("KR_KNJ_KMK_CD");
	}

	/**
	 * 借方科目名称を取得.
	 * 
	 * @return 借方科目名称
	 */
	public String getKrKnjKmkNm() {
		return super.getString("KR_KNJ_KMK_NM");
	}

	/**
	 * 借方金額を取得.
	 * 
	 * @return 借方金額
	 */
	public String getKrktAmt() {
		return super.getString("KRKT_AMT");
	}

	/**
	 * 貸方科目コードを取得.
	 * 
	 * @return 貸方科目コード
	 */
	public String getKsKnjKmkCd() {
		return super.getString("KS_KNJ_KMK_CD");
	}

	/**
	 * 貸方科目名称を取得.
	 * 
	 * @return 貸方科目名称
	 */
	public String getKsKnjKmkNm() {
		return super.getString("KS_KNJ_KMK_NM");
	}

	/**
	 * 貸方金額を取得.
	 * 
	 * @return 貸方金額
	 */
	public String getKsktAmt() {
		return super.getString("KSKT_AMT");
	}

	/**
	 * 注意１を取得.
	 * 
	 * @return 注意１
	 */
	public String getWarning1() {
		return super.getString("WARNING1");
	}

	/**
	 * 注意２を取得.
	 * 
	 * @return 注意２
	 */
	public String getWarning2() {
		return super.getString("WARNING2");
	}

	/**
	 * 注意３を取得.
	 * 
	 * @return 注意３
	 */
	public String getWarning3() {
		return super.getString("WARNING3");
	}

	/**
	 * 表示用契約番号を取得.
	 * 
	 * @return 表示用契約番号
	 */
	public String getHyjyoKeiNo() {
		return super.getString("HYJYO_KEI_NO");
	}

	/**
	 * 変更年月を取得.
	 * 
	 * @return 変更年月
	 */
	public String getChaYm() {
		return super.getString("CHA_YM");
	}
}
