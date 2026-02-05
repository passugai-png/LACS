package jp.co.pro_app.lacs.affairs.monthreport.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 月次帳票出力：仕訳合計表 Entity.
 * 
 * @author fukuhara
 * @version 20080415
 */
public class LACSMReportSiwakeCSVEntity extends LACSMReportEntityBase {

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
	public LACSMReportSiwakeCSVEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSMReportBean piReportBean) {
		super(piModel, piCommonBean, piReportBean);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT \n");
		super.sql.append("	 to_char(CURRENT_DATE,'yyyymmdd') CREATE_DATE \n");
		super.sql.append("	,'" + this.taisyouFrom + "' TERM_FROM \n");
		super.sql.append("	,'" + this.taisyouTo + "' TERM_TO \n");
		super.sql.append("	,LU_NM LEASE_USER_NM \n");
		super.sql.append("	,DECODE(LU.PDF_COMPANY_NM, NULL, LC_NM, LU.PDF_COMPANY_NM) LEASE_COMPANY_NM \n");
		super.sql.append("	,DECODE(LU.PDF_COMPANY_NM, NULL, LC_ZIP1 || '-' || LC_ZIP2, LU.PDF_COMPANY_ZIP1 || '-' || LU.PDF_COMPANY_ZIP2) LEASE_COMPANY_ZIP \n");
		super.sql.append("	,DECODE(LU.PDF_COMPANY_NM, NULL, LC_ADR1, LU.PDF_COMPANY_ADR1) LEASE_COMPANY_ADDR1 \n");
		super.sql.append("	,DECODE(LU.PDF_COMPANY_NM, NULL, LC_ADR2, LU.PDF_COMPANY_ADR2) LEASE_COMPANY_ADDR2 \n");
		super.sql.append(" 	,TAISHO_AC_KIJYUN_CD \n");
		super.sql.append("	,DECODE(TAISHO_AC_KIJYUN_CD,'0','旧リース会計基準','新リース会計基準') TAISHO_AC_KIJYUN_NM \n");
		super.sql.append(" 	,CTSHK_FLG CTSHK_FLG \n");
		super.sql.append("	,DECODE(CTSHK_FLG,'0','売買処理','賃貸借処理') CTSHK_FLG_NM \n");
		super.sql.append("	,DECODE(TAISHO_AC_KIJYUN_CD || CTSHK_FLG || KEIJ_YM,lag(TAISHO_AC_KIJYUN_CD || CTSHK_FLG || KEIJ_YM) over(partition by LU_NM order by TAISHO_AC_KIJYUN_CD,CTSHK_FLG,KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',KEIJ_YM) KEIJ_YM \n");
		super.sql.append("	,DECODE(KRKT_AMT,0, DECODE(KR_KNJ_KMK_NM,lag(KR_KNJ_KMK_NM) over(partition by KEIJ_YM order by TAISHO_AC_KIJYUN_CD,CTSHK_FLG,KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',KR_KNJ_KMK_CD),KR_KNJ_KMK_CD) KR_KNJ_KMK_CD \n");
		super.sql.append("	,DECODE(KRKT_AMT,0, DECODE(KR_KNJ_KMK_NM,lag(KR_KNJ_KMK_NM) over(partition by KEIJ_YM order by TAISHO_AC_KIJYUN_CD,CTSHK_FLG,KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',KR_KNJ_KMK_NM),KR_KNJ_KMK_NM) KR_KNJ_KMK_NM \n");
		super.sql.append("	,DECODE(KRKT_AMT,0, DECODE(KR_KNJ_KMK_NM,lag(KR_KNJ_KMK_NM) over(partition by KEIJ_YM order by TAISHO_AC_KIJYUN_CD,CTSHK_FLG,KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',KRKT_AMT),KRKT_AMT) KRKT_AMT \n");
		super.sql.append("	,DECODE(KSKT_AMT,0, DECODE(KS_KNJ_KMK_NM,lag(KS_KNJ_KMK_NM) over(partition by KEIJ_YM order by TAISHO_AC_KIJYUN_CD,CTSHK_FLG,KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',KS_KNJ_KMK_CD),KS_KNJ_KMK_CD) KS_KNJ_KMK_CD \n");
		super.sql.append("	,DECODE(KSKT_AMT,0, DECODE(KS_KNJ_KMK_NM,lag(KS_KNJ_KMK_NM) over(partition by KEIJ_YM order by TAISHO_AC_KIJYUN_CD,CTSHK_FLG,KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',KS_KNJ_KMK_NM),KS_KNJ_KMK_NM) KS_KNJ_KMK_NM \n");
		super.sql.append("	,DECODE(KSKT_AMT,0, DECODE(KS_KNJ_KMK_NM,lag(KS_KNJ_KMK_NM) over(partition by KEIJ_YM order by TAISHO_AC_KIJYUN_CD,CTSHK_FLG,KEIJ_YM,SWK_KBN,SIWAKE_GYO),'',KSKT_AMT),KSKT_AMT) KSKT_AMT \n");
		// 2020/05/22 ADD START
		super.sql.append("  ,'0' MESI_KBN \n");
		super.sql.append(" 	,SWK_KBN SWK_KBN \n");
		super.sql.append(" 	,SIWAKE_GYO SIWAKE_GYO \n");
		// 2020/05/22 ADD END
		// 2021/03/01 arai 重要性有無コードおよび重要性有無の追加 start
		super.sql.append("  ,JYSI_UM　JYSI_UM_CD \n");
		super.sql.append("  ,CASE WHEN JYSI_UM = 1 THEN 'あり' ELSE 'なし' END JYSI_UM " + "\n"); 
		// 2021/03/01 arai 重要性有無コードおよび重要性有無の追加 end
		super.sql.append("FROM  \n");
		super.sql.append("(SELECT \n");
		super.sql.append("	 BASE.LU_COSMOS_CD  \n");
		super.sql.append("	,BASE.LC_CD  \n");
		super.sql.append("	,BASE.CTSHK_FLG  \n");
		super.sql.append("	,BASE.TAISHO_AC_KIJYUN_CD \n");
		super.sql.append("	,BASE.KEIJ_YM \n");
		super.sql.append("	,BASE.SIWAKE_GYO \n");
		super.sql.append("	,BASE.SWK_KBN  \n");
		super.sql.append("	,BASE.KR_KNJ_KMK_CD  \n");
		super.sql.append("	,BASE.KR_KNJ_KMK_NM  \n");
		super.sql.append("	,SUM(BASE.KRKT_AMT) KRKT_AMT  \n");
		super.sql.append("	,BASE.KS_KNJ_KMK_CD  \n");
		super.sql.append("	,BASE.KS_KNJ_KMK_NM  \n");
		super.sql.append("	,SUM(BASE.KSKT_AMT) KSKT_AMT  \n");
		// 2021/03/01 arai 重要性有無の追加 start
		super.sql.append("  ,BASE.JYSI_UM \n");
		// 2021/03/01 arai 重要性有無の追加 end
		super.sql.append("	FROM (SELECT KEI.LU_COSMOS_CD  \n");
		super.sql.append("			,KEI.LC_CD  \n");
		super.sql.append("			,KEI.CTSHK_FLG  \n");
		super.sql.append("			,KEI.TAISHO_AC_KIJYUN_CD \n");
		super.sql.append("			,RSK.KEIJ_YM  \n");
		super.sql.append("			,RSK.SIWAKE_GYO  \n");
		super.sql.append("			,SWK.KR_KNJ_KMK_CD  \n");
		super.sql.append("			,SWK.KR_KNJ_KMK_NM  \n");
		super.sql.append("			,RSK.KRKT_AMT  \n");
		super.sql.append("			,SWK.KS_KNJ_KMK_CD  \n");
		super.sql.append("			,SWK.KS_KNJ_KMK_NM  \n");
		super.sql.append("			,RSK.KSKT_AMT  \n");
		super.sql.append("			,'1' SWK_KBN  \n");
		// 2021/03/01 arai 重要性有無の追加 start
		super.sql.append("          ,KEI.JYSI_UM \n");
		// 2021/03/01 arai 重要性有無の追加 end
		super.sql.append("		FROM  \n");
		super.sql.append("		(SELECT T.* " + "\n");
		super.sql.append("      ,'" + super.dateFrom + "' START_YMD " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "' " + "\n");
		super.sql.append("                                ," + super.termNum + ") END_YMD " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "' " + "\n");
		super.sql.append("                                                          ," + super.termNum + ")) NEXT_START_YMD " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "' " + "\n");
		super.sql.append("                                                                                    ," + super.termNum + ") " + "\n");
		super.sql.append("                                                          ,12)) NEXT_END_YMD " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "' " + "\n");
		super.sql.append("                                                                                                              ," + super.termNum + ") " + "\n");
		super.sql.append("                                                                                    ,12))) OVER_NEXT_END_YMD " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD " + "\n");
		super.sql.append("                                  ,'" + super.dateFrom + "' " + "\n");
		super.sql.append("                                  ,'" + super.dateFrom + "') START_KEIJ_YM " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD " + "\n");
		super.sql.append("                                  ,'" + super.dateFrom + "' " + "\n");
		super.sql.append("                                  ,LACS_COMMON.GET_TERM_DATE(SUBSTR('" + super.dateFrom + "', 1, 6) || '01' " + "\n");
		super.sql.append("                                                            ," + super.termNum + ")) END_KEIJ_YM " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD " + "\n");
		super.sql.append("                                  ,'" + super.dateFrom + "' " + "\n");
		super.sql.append("                                  ,LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE(SUBSTR('" + super.dateFrom + "', 1, 6) || '01' " + "\n");
		super.sql.append("                                                                                      ," + super.termNum + "))) NEXT_START_KEIJ_YM " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD " + "\n");
		super.sql.append("                                  ,'" + super.dateFrom + "' " + "\n");
		super.sql.append("                                  ,LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE(LACS_COMMON.GET_TERM_DATE(SUBSTR('" + super.dateFrom + "', 1, 6) || '01' " + "\n");
		super.sql.append("                                                                                                                ," + super.termNum + ") " + "\n");
		super.sql.append("                                                                                      ,12))) NEXT_END_KEIJ_YM " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD " + "\n");
		super.sql.append("                                  ,'" + super.dateFrom + "' " + "\n");
		super.sql.append("                                  ,LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE(LACS_COMMON.GET_TERM_DATE(SUBSTR('" + super.dateFrom + "', 1, 6) || '01' " + "\n");
		super.sql.append("                                                                                                                                          ," + super.termNum + ") " + "\n");
		super.sql.append("                                                                                                                ,12)))) OVER_NEXT_KEIJ_YM " + "\n");
		super.sql.append("	    ,NVL(LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD, " + "\n");
		super.sql.append("								         KAI_YMD, " + "\n");
		super.sql.append("								         KAI_YMD), '999999') KAI_START_KEIJ_YM " + "\n");
		super.sql.append("		FROM   T_KEI T \n");
		super.sql.append("		WHERE T.LU_COSMOS_CD = '" + this.leasCompanyCode + "' \n");

		if (super.keiyakuNo.trim().length() > 0) {
			super.sql.append("		AND T.HYJYO_KEI_NO = '" + super.keiyakuNo + "' \n");
		}

		if (super.gtjkeiyakuGaku.equals("0")) {
			super.sql.append("  AND    ((T.SGK_SSN_KBN IS NULL AND T.KEI_AMT > 3000000) " + "\n");
			super.sql.append("      OR   (T.SGK_SSN_KBN IS NOT NULL AND T.SGK_SSN_KBN = '0')) " + "\n");
		}

		if (super.gtjleaseKikan.equals("0")) {

			super.sql.append("  	AND T.KEI_TERM > 12 " + "\n"); // リース期間１年以内

		}

		if (super.gtjsaiLease.equals("0")) {
			super.sql.append("  	AND T.RLS_TMS = 0" + "\n"); // 再リース契約
		}

		if (super.gtjtyutoKaiyaku.equals("0")) {
			super.sql.append("  	AND T.KAI_YMD IS NULL" + "\n"); // 中途解約物件
		}

		super.sql.append("		) KEI \n");
		super.sql.append("		INNER JOIN T_BKN BKN ON KEI.LC_CD = BKN.LC_CD  \n");
		super.sql.append("					AND KEI.KEI_NO = BKN.KEI_NO  \n");
		super.sql.append("		INNER JOIN T_RSK_KEIJ_SIWAKE RSK ON BKN.LC_CD = RSK.LC_CD  \n");
		super.sql.append("							AND BKN.KEI_NO = RSK.KEI_NO  \n");
		super.sql.append("							AND BKN.BKN_NO = RSK.BKN_NO  \n");
		super.sql.append("							AND BKN.BKN_EDANO = RSK.BKN_EDANO  \n");
		super.sql.append("							AND BKN.RSK_KEIJ_HOHO_KBN = RSK.KEIJ_HOHO_KBN  \n");
		super.sql.append("							AND RSK.KAI_REC_FLG = '0' \n");
		super.sql.append("							AND RSK.KEIJ_YM BETWEEN KEI.START_KEIJ_YM AND KEI.END_KEIJ_YM \n");
		super.sql.append("		INNER JOIN M_RSK_KEIJ_SIWAKE_TEIGI SWK ON KEI.SIWAKE_LU_COSMOS_CD = SWK.LU_COSMOS_CD  \n");
		super.sql.append("								AND BKN.RSK_KEIJ_HOHO_KBN = SWK.KEIJ_HOHO_KBN  \n");
		super.sql.append("								AND KEI.TRD_HNTE_KEKA_KBN = SWK.TRD_HNTE_KEKA_KBN  \n");
		super.sql.append("								AND KEI.TAISHO_AC_KIJYUN_CD = SWK.TAISHO_AC_KIJYUN_CD  \n");
		super.sql.append("								AND KEI.CTSHK_FLG = SWK.CTSHK_FLG  \n");
		super.sql.append("								AND BKN.SSN_SRI_CD = SWK.SSN_SRI_CD  \n");
		super.sql.append("								AND RSK.SIWAKE_GYO = SWK.SIWAKE_GYO  \n");
		super.sql.append("		UNION ALL \n");
		super.sql.append("		SELECT KEI.LU_COSMOS_CD  \n");
		super.sql.append("			,KEI.LC_CD  \n");
		super.sql.append("			,KEI.CTSHK_FLG  \n");
		super.sql.append("			,KEI.TAISHO_AC_KIJYUN_CD \n");
		super.sql.append("			,SKK.KEIJ_YM  \n");
		super.sql.append("			,SKK.SIWAKE_GYO  \n");
		super.sql.append("			,SWK.KR_KNJ_KMK_CD  \n");
		super.sql.append("			,SWK.KR_KNJ_KMK_NM  \n");
		super.sql.append("			,SKK.KRKT_AMT  \n");
		super.sql.append("			,SWK.KS_KNJ_KMK_CD  \n");
		super.sql.append("			,SWK.KS_KNJ_KMK_NM  \n");
		super.sql.append("			,SKK.KSKT_AMT  \n");
		super.sql.append("			,'2' SWK_KBN  \n");
		// 2021/03/01 arai 重要性有無の追加 start
		super.sql.append("          ,KEI.JYSI_UM \n");
		// 2021/03/01 arai 重要性有無の追加 end
		super.sql.append("		FROM  \n");
		super.sql.append("		(SELECT T.* " + "\n");
		super.sql.append("      ,'" + super.dateFrom + "' START_YMD " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "' " + "\n");
		super.sql.append("                                ," + super.termNum + ") END_YMD " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "' " + "\n");
		super.sql.append("                                                          ," + super.termNum + ")) NEXT_START_YMD " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "' " + "\n");
		super.sql.append("                                                                                    ," + super.termNum + ") " + "\n");
		super.sql.append("                                                          ,12)) NEXT_END_YMD " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "' " + "\n");
		super.sql.append("                                                                                                              ," + super.termNum + ") " + "\n");
		super.sql.append("                                                                                    ,12))) OVER_NEXT_END_YMD " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD " + "\n");
		super.sql.append("                                  ,'" + super.dateFrom + "' " + "\n");
		super.sql.append("                                  ,'" + super.dateFrom + "') START_KEIJ_YM " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD " + "\n");
		super.sql.append("                                  ,'" + super.dateFrom + "' " + "\n");
		super.sql.append("                                  ,LACS_COMMON.GET_TERM_DATE(SUBSTR('" + super.dateFrom + "', 1, 6) || '01' " + "\n");
		super.sql.append("                                                            ," + super.termNum + ")) END_KEIJ_YM " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD " + "\n");
		super.sql.append("                                  ,'" + super.dateFrom + "' " + "\n");
		super.sql.append("                                  ,LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE(SUBSTR('" + super.dateFrom + "', 1, 6) || '01' " + "\n");
		super.sql.append("                                                                                      ," + super.termNum + "))) NEXT_START_KEIJ_YM " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD " + "\n");
		super.sql.append("                                  ,'" + super.dateFrom + "' " + "\n");
		super.sql.append("                                  ,LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE(LACS_COMMON.GET_TERM_DATE(SUBSTR('" + super.dateFrom + "', 1, 6) || '01' " + "\n");
		super.sql.append("                                                                                                                ," + super.termNum + ") " + "\n");
		super.sql.append("                                                                                      ,12))) NEXT_END_KEIJ_YM " + "\n");
		super.sql.append("      ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD " + "\n");
		super.sql.append("                                  ,'" + super.dateFrom + "' " + "\n");
		super.sql.append("                                  ,LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE(LACS_COMMON.GET_TERM_DATE(SUBSTR('" + super.dateFrom + "', 1, 6) || '01' " + "\n");
		super.sql.append("                                                                                                                                          ," + super.termNum + ") " + "\n");
		super.sql.append("                                                                                                                ,12)))) OVER_NEXT_KEIJ_YM " + "\n");
		super.sql.append("	    ,NVL(LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD, " + "\n");
		super.sql.append("								         KAI_YMD, " + "\n");
		super.sql.append("								         KAI_YMD), '999999') KAI_START_KEIJ_YM " + "\n");
		super.sql.append("		FROM   T_KEI T \n");
		super.sql.append("		WHERE T.LU_COSMOS_CD = '" + this.leasCompanyCode + "' \n");

		if (super.keiyakuNo.trim().length() > 0) {
			super.sql.append("		AND T.HYJYO_KEI_NO = '" + super.keiyakuNo + "' \n");
		}

		if (super.gtjkeiyakuGaku.equals("0")) {
			super.sql.append("  AND    ((T.SGK_SSN_KBN IS NULL AND T.KEI_AMT > 3000000) " + "\n");
			super.sql.append("      OR   (T.SGK_SSN_KBN IS NOT NULL AND T.SGK_SSN_KBN = '0')) " + "\n");
		}

		if (super.gtjleaseKikan.equals("0")) {

			super.sql.append("  	AND T.KEI_TERM > 12 " + "\n"); // リース期間１年以内

		}

		if (super.gtjsaiLease.equals("0")) {
			super.sql.append("  	AND T.RLS_TMS = 0" + "\n"); // 再リース契約
		}

		if (super.gtjtyutoKaiyaku.equals("0")) {
			super.sql.append("  	AND T.KAI_YMD IS NULL" + "\n"); // 中途解約物件
		}

		super.sql.append("		) KEI \n");
		super.sql.append("		INNER JOIN T_BKN BKN ON KEI.LC_CD = BKN.LC_CD  \n");
		super.sql.append("				AND KEI.KEI_NO = BKN.KEI_NO  \n");
		super.sql.append("		INNER JOIN T_SKK_KEIJ_SIWAKE SKK ON BKN.LC_CD = SKK.LC_CD  \n");
		super.sql.append("							AND BKN.KEI_NO = SKK.KEI_NO  \n");
		super.sql.append("							AND BKN.BKN_NO = SKK.BKN_NO  \n");
		super.sql.append("							AND BKN.BKN_EDANO = SKK.BKN_EDANO  \n");
		super.sql.append("							AND BKN.SKK_KEIJ_HOHO_KBN = SKK.KEIJ_HOHO_KBN  \n");
		super.sql.append("							AND SKK.KAI_REC_FLG = '0' \n");
		super.sql.append("							AND SKK.KEIJ_YM BETWEEN KEI.START_KEIJ_YM AND KEI.END_KEIJ_YM \n");
		super.sql.append("		INNER JOIN M_SKK_KEIJ_SIWAKE_TEIGI SWK ON KEI.SIWAKE_LU_COSMOS_CD = SWK.LU_COSMOS_CD  \n");
		super.sql.append("								AND BKN.SKK_KEIJ_HOHO_KBN = SWK.KEIJ_HOHO_KBN  \n");
		super.sql.append("								AND KEI.TRD_HNTE_KEKA_KBN = SWK.TRD_HNTE_KEKA_KBN  \n");
		super.sql.append("								AND KEI.TAISHO_AC_KIJYUN_CD = SWK.TAISHO_AC_KIJYUN_CD  \n");
		super.sql.append("								AND KEI.CTSHK_FLG = SWK.CTSHK_FLG  \n");
		super.sql.append("								AND BKN.SSN_SRI_CD = SWK.SSN_SRI_CD  \n");
		super.sql.append("								AND SKK.SIWAKE_GYO = SWK.SIWAKE_GYO  \n");
		super.sql.append("	) BASE  \n");
		super.sql.append("	GROUP BY  \n");
		super.sql.append("		 BASE.LU_COSMOS_CD  \n");
		super.sql.append("		,BASE.LC_CD  \n");
		super.sql.append("		,BASE.CTSHK_FLG  \n");
		super.sql.append("		,BASE.TAISHO_AC_KIJYUN_CD \n");
		super.sql.append("		,BASE.KEIJ_YM \n");
		super.sql.append("		,BASE.SWK_KBN  \n");
		super.sql.append("		,BASE.SIWAKE_GYO  \n");
		super.sql.append("		,BASE.KR_KNJ_KMK_CD  \n");
		super.sql.append("		,BASE.KR_KNJ_KMK_NM  \n");
		super.sql.append("		,BASE.KS_KNJ_KMK_CD  \n");
		super.sql.append("		,BASE.KS_KNJ_KMK_NM  \n");
		// 2021/03/01 arai 重要性有無の追加 start
		super.sql.append("      ,BASE.JYSI_UM \n");
		// 2021/03/01 arai 重要性有無の追加 end
		super.sql.append(") DETAILS \n");
		super.sql.append("INNER JOIN M_LU LU ON LU.LU_COSMOS_CD = DETAILS.LU_COSMOS_CD \n");
		super.sql.append("INNER JOIN M_LC LC ON LC.LC_CD = DETAILS.LC_CD \n");
		super.sql.append("ORDER BY  \n");
		super.sql.append(" 	 DETAILS.TAISHO_AC_KIJYUN_CD \n");
		super.sql.append(" 	,DETAILS.CTSHK_FLG \n");
		super.sql.append("	,DETAILS.KEIJ_YM \n");
		super.sql.append("	,DETAILS.SWK_KBN  \n");
		super.sql.append("	,DETAILS.SIWAKE_GYO \n");
		// 2021/03/01 arai 重要性有無の追加 start
		super.sql.append("  ,DETAILS.JYSI_UM \n");
		// 2021/03/01 arai 重要性有無の追加 end
	
		// 2020/05/22 ADD TEST START
		System.out.println("SQL out start");
		System.out.println(super.sql);
		System.out.println("SQL out end");
		// 2020/05/22 ADD TEST END

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
	 * 対象期間Fromを取得.
	 * 
	 * @return 対象期間From
	 */
	public String getTermFrom() {
		return super.getString("TERM_FROM");
	}

	/**
	 * 対象期間Toを取得.
	 * 
	 * @return 対象期間To
	 */
	public String getTermTo() {
		return super.getString("TERM_TO");
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
	 * リース会計基準コードを取得.
	 * 
	 * @return リース会計基準コード
	 */
	public String getTaishoAcKijyunCd() {
		return super.getString("TAISHO_AC_KIJYUN_CD");
	}

	/**
	 * リース会計基準名称を取得.
	 * 
	 * @return リース会計基準名称
	 */
	public String getTaishoAcKijyunNm() {
		return super.getString("TAISHO_AC_KIJYUN_NM");
	}

	/**
	 * 会計処理コードを取得.
	 * 
	 * @return 会計処理コード
	 */
	public String getCtshkFlg() {
		return super.getString("CTSHK_FLG");
	}

	/**
	 * 会計処理名称を取得.
	 * 
	 * @return 会計処理名称
	 */
	public String getCtshkFlgNm() {
		return super.getString("CTSHK_FLG_NM");
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
	
	// 2021/03/01 ADD START
	/**
	 * 重要性有無コードを取得.
	 * 
	 * @return 重要性有無コード
	 */
	public String getJysiKbnCd() {
		return super.getString("JYSI_UM_CD");
	}
	// 2021/03/01 ADD END

	// 2021/03/01 ADD START
	/**
	 * 重要性有無を取得.
	 * 
	 * @return 重要性有無
	 */
	public String getJysiKbn() {
		return super.getString("JYSI_UM");
	}
	// 2021/03/01 ADD END


}
