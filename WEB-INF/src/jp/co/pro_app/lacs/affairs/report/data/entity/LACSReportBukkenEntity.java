package jp.co.pro_app.lacs.affairs.report.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 帳票出力：リース料支払スケジュール（物件単位）Entity.
 * 
 * @author ohmura
 * @version 20070905
 */
public class LACSReportBukkenEntity extends LACSReportEntityBase {

	private LACSReportBean	bean	= null;

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
	public LACSReportBukkenEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSReportBean piReportBean, String piAcStd) {
		super(piModel, piCommonBean, piReportBean, piAcStd);

		bean = piReportBean;
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT (  rpad(KEI.LC_CD, 5, ' ') " + "\n");
		super.sql.append("        || rpad(KEI.KEI_NO, 20, ' ') " + "\n");
		super.sql.append("        || rpad(BKN.BKN_NO, 20, ' ') " + "\n");
		super.sql.append("        || rpad(BKN.BKN_EDANO, 5, ' ')) BRAKE_KEY " + "\n");
		super.sql.append("      ,DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_NM, LU.PDF_COMPANY_NM) LEASE_COMPANY" + "\n");
		super.sql.append("      ,LU.LU_NM                            LEASE_USER" + "\n");
		super.sql.append("      ,KEI.HYJYO_KEI_NO KEI_NO" + "\n");
		super.sql.append("      ,BKN.BKN_NO || CASE WHEN TRIM(BKN.BKN_EDANO) IS NULL THEN '' ELSE '-' || BKN.BKN_EDANO END BKN_NO" + "\n");
		super.sql.append("      ,TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_NM  LEASE_BUNRUI" + "\n");
		super.sql.append("      ,SSN_SRI.SSN_SRI_NM " + "\n");
		super.sql.append("      ,KEI.KNSHU_YMD " + "\n");
		super.sql.append("      ,KEI.MRYO_YMD " + "\n");
		super.sql.append("      ,KEI.KEI_TERM " + "\n");
		super.sql.append("      ,BKN.BKN_NM " + "\n");

		if (super.kaikeiSyori.equals(LACSDefine.KaikeiSyori.SYOUSAI_0)) {
			super.sql.append("      ,BKN.RSK_KEIJ_HOHO_KBN " + "\n");
		}
		else {
			super.sql.append("      ,NULL RSK_KEIJ_HOHO_KBN " + "\n");
		}

		super.sql.append("      ,BKN.KEI_AMT + CASE WHEN (BKN.ZANK_HSHOSK_CD = KEI.LU_TRSK_CD) OR (BKN.IPN_ZANK_HSHOSK_CD = KEI.LU_TRSK_CD) THEN BKN.ZANK_HSHO_AMT ELSE 0 END KEI_AMT " + "\n");
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("   	    WHEN " + super.getRisokuKeijoHohoKbn("BKN") + " = '" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' THEN " + "\n");
		super.sql.append("   	        0 " + "\n");
		super.sql.append("   		ELSE " + "\n");
		super.sql.append("   		    BKN.IPN_EKM_TEIK_HYO + BKN.SHRY_EKM_TEIK_HYO " + "\n");
		super.sql.append("       END EKM_TEIK_HYO_SOU" + "\n");
		
		//super.sql.append("      ,CASE " + "\n");
		//super.sql.append("   	    WHEN " + //super.getRisokuKeijoHohoKbn("BKN") + " = '" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' THEN " + "\n");
		//super.sql.append("   	        0 " + "\n");
		//super.sql.append("   		ELSE " + "\n");
		//super.sql.append("              BKN.ENT_SHOHYO_KZI + BKN.ENT_SHOHYO_HKZI + BKN.GTAX + BKN.CTAX + BKN.JTAX + BKN.JBSK_HKN + BKN.NNI_HKN + BKN.RCYCL_RYO_KNRI_AMT + BKN.DOSO + BKN.KOZEI + BKN.OTH_CST " + "\n");
		//super.sql.append("       END IJI_KANRIHI_SOU" + "\n");
		
		// 20210419 arai 維持管理費相当額 対応 start
		super.sql.append("      ,BKN.ENT_SHOHYO_KZI + BKN.ENT_SHOHYO_HKZI + BKN.GTAX + BKN.CTAX + BKN.JTAX + BKN.JBSK_HKN + BKN.NNI_HKN + " + "\n");
		super.sql.append("       BKN.RCYCL_RYO_KNRI_AMT + BKN.DOSO + BKN.KOZEI + BKN.OTH_CST IJI_KANRIHI_SOU " + "\n");
		// 20210419 arai 維持管理費相当額 対応 end
		
		super.sql.append("      ,BKN.KNU_AMT " + "\n");
		super.sql.append("      ,CASE WHEN KEI.LU_TRSK_CD IN (BKN.ZANK_HSHOSK_CD, BKN.IPN_ZANK_HSHOSK_CD)  THEN " + "\n");
		super.sql.append("          BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("       ELSE 0 " + "\n");
		super.sql.append("       END ZANK_HSHO_AMT " + "\n");
		super.sql.append("      ,DECODE(BKN.RSK_KEIJ_HOHO_KBN ,'101',  BKN.MBRI_WRBK_CLC_RS_RT ,BKN.ABRI_WRBK_CLC_RS_RT) WRBK_CLC_RS_RT " + "\n");
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("           WHEN " + super.getRisokuKeijoHohoKbn("BKN") + " = '" + LACSDefine.RisokuKeijoHohoKbn.RSKHO_ZEN_GET_101 + "' THEN " + "\n");
		super.sql.append("               BKN.MBRI_WRBK_PV " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("               BKN.ABRI_WRBK_PV " + "\n");
		super.sql.append("       END WRBK_PV " + "\n");

		if (super.kaikeiSyori.equals(LACSDefine.KaikeiSyori.SYOUSAI_0)) {
			//super.sql.append("      ,CASE " + super.getRisokuKeijoHohoKbn("KEI") + "\n");
			//super.sql.append("            WHEN '" + LACSDefine.RisokuKeijoHohoKbn.RSKHO_ZEN_GET_101 + "' THEN " + "\n");
			//super.sql.append("                LEAST(BKN.MBRI_WRBK_PV, BKN.KNU_AMT) " + "\n");
			//super.sql.append("            WHEN '" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' THEN " + "\n");
			//super.sql.append("                BKN.KEI_AMT + CASE WHEN (BKN.ZANK_HSHOSK_CD = KEI.LU_TRSK_CD) OR (BKN.IPN_ZANK_HSHOSK_CD = KEI.LU_TRSK_CD) THEN BKN.ZANK_HSHO_AMT ELSE 0 END " + "\n");
			//super.sql.append("            ELSE " + "\n");
			//super.sql.append("                LEAST(BKN.ABRI_WRBK_PV, BKN.KNU_AMT) " + "\n");
			//super.sql.append("       END SYUTOKU_AMT " + "\n");
			
		    // 20210419 arai 取得価格相当額  対応 start
			super.sql.append("      ,(SELECT SUM(FD.GNPN_TTL) GNPN_TTL "+ "\n");
			super.sql.append("        FROM T_KEI KEI "+ "\n");
			super.sql.append("        WHERE FKN_TNKI.KI = 1 AND KEI.HYJYO_KEI_NO = '" + this.keiyakuNo + "'  "+ "\n");
			super.sql.append("        AND KEI.KEI_NO = FKN_TNKI.KEI_NO AND KEI.LC_CD = FKN_TNKI.LC_CD "+ "\n");
			super.sql.append("        AND FKN_TNKI.KEI_NO = FD.KEI_NO AND FKN_TNKI.LC_CD = FD.LC_CD "+ "\n");
			super.sql.append("        AND FKN_TNKI.BKN_NO = FD.BKN_NO AND FKN_TNKI.BKN_EDANO = FD.BKN_EDANO "+ "\n");
			super.sql.append("        AND FKN_TNKI.KEIJ_YM = FD.KEIJ_YM "+ "\n");
			super.sql.append("        AND KEI.RSK_KEIJ_HOHO_KBN = FD.KEIJ_HOHO_KBN  ) SYUTOKU_AMT "+ "\n");
			
			// 20210419 arai 取得価格相当額  対応 end
						
			super.sql.append("      ,(SELECT SUM(F.TGTU_RSK) TGTU_RSK " + "\n");
			super.sql.append("       FROM T_FKN_TNKI_DETAIL F " + "\n");
			super.sql.append("       WHERE F.LC_CD     = KEI.LC_CD " + "\n");
			super.sql.append("         AND F.KEI_NO    = KEI.KEI_NO " + "\n");
			super.sql.append("         AND F.BKN_NO    = BKN.BKN_NO " + "\n");
			super.sql.append("         AND F.BKN_EDANO = BKN.BKN_EDANO " + "\n");
			super.sql.append("         AND " + super.getRisokuKeijoHohoKbn("BKN") + " = F.KEIJ_HOHO_KBN) SIHARAI_RSK " + "\n");

			if (kaikeiSyori.equals("0")) {
				super.sql.append("      ,CASE WHEN BKN.RSK_KEIJ_HOHO_KBN = '" + LACSDefine.RisokuKeijoHohoKbn.RSKHO_ZEN_GET_101 + "' THEN " + "\n");
				super.sql.append("               BKN.MBRI_RSK_CLC_RS_RT " + "\n");
				super.sql.append("            WHEN BKN.RSK_KEIJ_HOHO_KBN = '" + LACSDefine.RisokuKeijoHohoKbn.RSKHO_ATO_GET_102 + "' THEN " + "\n");
				super.sql.append("               BKN.ABRI_RSK_CLC_RS_RT " + "\n");
				super.sql.append("            ELSE " + "\n");
				super.sql.append("               NULL " + "\n");
				super.sql.append("       END RSK_CLC_RS_RT " + "\n");
			}
			else {
				super.sql.append("      ,NULL RSK_CLC_RS_RT " + "\n");
			}
		}
		else {
			super.sql.append("      ,NULL SYUTOKU_AMT" + "\n");
			super.sql.append("      ,NULL SIHARAI_RSK" + "\n");
			super.sql.append("      ,NULL RSK_CLC_RS_RT" + "\n");
		}

		super.sql.append("      ,FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_NM " + "\n");

		if (super.kaikeiSyori.equals(LACSDefine.KaikeiSyori.SYOUSAI_0)) {
			super.sql.append("      ,RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN_NM " + "\n");
		}
		else {
			super.sql.append("      ,NULL RSK_KEIJ_HOHO_KBN_NM " + "\n");
		}

		super.sql.append("      ,FKN_TNKI.KEIJ_YM " + "\n");
		super.sql.append("      ,FKN_TNKI.LAMT " + "\n");
		super.sql.append("      ,CASE " + "\n");
		super.sql.append("   	    WHEN " + super.getRisokuKeijoHohoKbn("BKN") + " = '" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' THEN " + "\n");
		super.sql.append("   	        0 " + "\n");
		super.sql.append("   		ELSE " + "\n");
		super.sql.append("              FKN_TNKI.IPN_EKM_TEIK_HYO + FKN_TNKI.SHRY_EKM_TEIK_HYO " + "\n");
		super.sql.append("       END EKM_TEIK_HYO" + "\n");
		
		// 20210419 arai 維持管理費相当額 対応 start
		//super.sql.append("      ,CASE " + "\n");
		//super.sql.append("   	    WHEN " + //super.getRisokuKeijoHohoKbn("BKN") + " = '" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' THEN " + "\n");
		//super.sql.append("   	        0 " + "\n");
		//super.sql.append("   		ELSE " + "\n");
		//super.sql.append("              FKN_TNKI.ENT_SHOHYO_KZI + FKN_TNKI.ENT_SHOHYO_HKZI + FKN_TNKI.GTAX + FKN_TNKI.CTAX + FKN_TNKI.JTAX + FKN_TNKI.JBSK_HKN + FKN_TNKI.NNI_HKN + FKN_TNKI.RCYCL_RYO_KNRI_AMT + FKN_TNKI.DOSO + FKN_TNKI.KOZEI + FKN_TNKI.OTH_CST " + "\n");
		//super.sql.append("       END IJI_KANRIHI" + "\n");
	    super.sql.append("        ,FKN_TNKI.ENT_SHOHYO_KZI + FKN_TNKI.ENT_SHOHYO_HKZI + FKN_TNKI.GTAX + FKN_TNKI.CTAX + FKN_TNKI.JTAX + " + "\n");
		super.sql.append("         FKN_TNKI.JBSK_HKN + FKN_TNKI.NNI_HKN + FKN_TNKI.RCYCL_RYO_KNRI_AMT + FKN_TNKI.DOSO + FKN_TNKI.KOZEI + FKN_TNKI.OTH_CST IJI_KANRIHI " + "\n");
		// 20210419 arai 維持管理費相当額 対応 end
		
		super.sql.append("      ,TGTU_RSK + TGTU_GNPN NET_LEASE " + "\n");
		super.sql.append("      ,TGTU_RSK UCHI_RISOKU " + "\n");
		super.sql.append("      ,TGTU_GNPN UCHI_SAIMU " + "\n");
		super.sql.append("      ,ZAND_GNPN KIMATU_ZAN " + "\n");
		super.sql.append("      ,HSE_RSK SIHARAI_RISOKU " + "\n");
		super.sql.append("      ,KEI.TRD_HNTE_KEKA_KBN " + "\n"); // リース取引分類コード
		super.sql.append("	  ,CASE KEI.TAISHO_AC_KIJYUN_CD " + "\n");
		super.sql.append("		   WHEN '" + LACSDefine.AccountStandard.OLD_0 + "' THEN " + "\n");
		super.sql.append("			CASE '" + bean.getOldSumUnt() + "' " + "\n");
		super.sql.append("				WHEN '" + LACSDefine.SumUnit.SUM_UNT_KEI_0 + "' THEN " + "\n");
		super.sql.append("				 KEI.SSN_SRI_CD " + "\n");
		super.sql.append("				ELSE " + "\n");
		super.sql.append("				 BKN.SSN_SRI_CD " + "\n");
		super.sql.append("			END " + "\n");
		super.sql.append("		   ELSE " + "\n");
		super.sql.append("			CASE '" + bean.getNewSumUnt() + "' " + "\n");
		super.sql.append("				WHEN '" + LACSDefine.SumUnit.SUM_UNT_KEI_0 + "' THEN " + "\n");
		super.sql.append("				 KEI.SSN_SRI_CD " + "\n");
		super.sql.append("				ELSE " + "\n");
		super.sql.append("				 BKN.SSN_SRI_CD " + "\n");
		super.sql.append("			END " + "\n");
		super.sql.append("	   END SSN_SRI_CD " + "\n");
		super.sql.append("		,'" + this.kaikeiSyori + "' AC_SHR_KBN " + "\n"); // 会計処理方法
		super.sql.append("		,(SELECT AC_SHR_NM FROM M_AC_SHR_KBN WHERE AC_SHR_KBN = '" + this.kaikeiSyori + "' AND M_AC_SHR_KBN.CTSHK_FLG = KEI.CTSHK_FLG ) AC_SHR_KBN_NM " + "\n"); // 会計処理方法名
		super.sql.append("      ,RSK_KEIJ_HOHO_KBN.MBRI_ABRI_KBN " + "\n"); // 前払／後払区分コード
		super.sql.append("      ,RSK_KEIJ_HOHO_KBN.MBRI_ABRI_KBN_NM " + "\n"); // 前払／後払区分
		super.sql.append("      ,FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_CD " + "\n"); // CASHフロー展開コード
		super.sql.append("      ,TO_CHAR(SYSDATE, 'YYYYMMDD') CREATE_DATE " + "\n");
		super.sql.append("FROM   T_KEI KEI " + "\n");
		super.sql.append("INNER JOIN T_BKN BKN ON " + "\n");
		super.sql.append("                       BKN.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("                   AND BKN.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("INNER JOIN T_FKN_TNKI_HEAD FKN_TNKI ON " + "\n");
		super.sql.append("                FKN_TNKI.LC_CD     = KEI.LC_CD " + "\n");
		super.sql.append("            AND FKN_TNKI.KEI_NO    = KEI.KEI_NO " + "\n");
		super.sql.append("            AND FKN_TNKI.BKN_NO    = BKN.BKN_NO " + "\n");
		super.sql.append("            AND FKN_TNKI.BKN_EDANO = BKN.BKN_EDANO " + "\n");
		super.sql.append("INNER JOIN T_FKN_TNKI_DETAIL FD ON " + "\n");
		super.sql.append("                FKN_TNKI.LC_CD     = FD.LC_CD " + "\n");
		super.sql.append("            AND FKN_TNKI.KEI_NO    = FD.KEI_NO " + "\n");
		super.sql.append("            AND FKN_TNKI.BKN_NO    = FD.BKN_NO " + "\n");
		super.sql.append("            AND FKN_TNKI.BKN_EDANO = FD.BKN_EDANO " + "\n");
		super.sql.append("            AND " + super.getRisokuKeijoHohoKbn("BKN") + " = FD.KEIJ_HOHO_KBN " + "\n");
		super.sql.append("            AND FKN_TNKI.KEIJ_YM   = FD.KEIJ_YM " + "\n");
		super.sql.append("LEFT JOIN M_LC LC ON LC.LC_CD = KEI.LC_CD " + "\n");
		super.sql.append("LEFT JOIN M_TRD_HNTE_KEKA_KBN TRD_HNTE_KEKA_KBN ON " + "\n");
		super.sql.append("                       TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN = KEI.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("LEFT   JOIN M_SSN_SRI SSN_SRI " + "\n");
		super.sql.append("ON     SSN_SRI.SSN_SRI_CD = -- " + "\n");
		super.sql.append("	   CASE KEI.TAISHO_AC_KIJYUN_CD " + "\n");
		super.sql.append("		   WHEN '" + LACSDefine.AccountStandard.OLD_0 + "' THEN " + "\n");
		super.sql.append("			CASE '" + bean.getOldSumUnt() + "' " + "\n");
		super.sql.append("				WHEN '" + LACSDefine.SumUnit.SUM_UNT_KEI_0 + "' THEN " + "\n");
		super.sql.append("				 KEI.SSN_SRI_CD " + "\n");
		super.sql.append("				ELSE " + "\n");
		super.sql.append("				 BKN.SSN_SRI_CD " + "\n");
		super.sql.append("			END " + "\n");
		super.sql.append("		   ELSE " + "\n");
		super.sql.append("			CASE '" + bean.getNewSumUnt() + "' " + "\n");
		super.sql.append("				WHEN '" + LACSDefine.SumUnit.SUM_UNT_KEI_0 + "' THEN " + "\n");
		super.sql.append("				 KEI.SSN_SRI_CD " + "\n");
		super.sql.append("				ELSE " + "\n");
		super.sql.append("				 BKN.SSN_SRI_CD " + "\n");
		super.sql.append("			END " + "\n");
		super.sql.append("	   END " + "\n");
		super.sql.append("LEFT JOIN M_RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN ON " + "\n");
		super.sql.append("                       RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN = " + super.getRisokuKeijoHohoKbn("BKN") + " " + "\n");
		super.sql.append("LEFT JOIN M_LU LU ON " + "\n");
		super.sql.append("                       LU.LU_COSMOS_CD = KEI.LU_COSMOS_CD " + "\n");
		super.sql.append("LEFT JOIN M_FKN_TNKI_HOHO_CD FKN_TNKI_HOHO_CD ON " + "\n");
		super.sql.append("                       FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_CD = KEI.TNKI_HOHO_KBN " + "\n");
		super.sql.append("WHERE KEI.HYJYO_KEI_NO = '" + this.keiyakuNo + "' " + "\n"); // 契約番号
		super.sql.append("AND   KEI.ERR_FLG = '0' " + "\n"); // エラー契約は除外

		if (this.leasCompanyCode.trim().length() > 0) {
			super.sql.append("  AND KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "' " + "\n"); // リースユーザ
		}

		if (this.bukkenNo.trim().length() > 0) {
			super.sql.append("  AND BKN.BKN_NO || CASE WHEN TRIM(BKN.BKN_EDANO) IS NULL THEN '' ELSE '-' || BKN.BKN_EDANO END LIKE '" + this.bukkenNo + "%' " + "\n"); // 物件番号
		}

		super.sql.append("ORDER BY KEI.LC_CD,    " + "\n");
		super.sql.append("         KEI.HYJYO_KEI_NO, " + "\n");
		super.sql.append("         BKN.BKN_NO, " + "\n");
		super.sql.append("         BKN.BKN_EDANO, " + "\n");
		super.sql.append("         KEI.KEI_NO," + "\n");
		super.sql.append("         FKN_TNKI.KEIJ_YM " + "\n");
		
		System.out.println(super.sql);
	}

	/**
	 * ブレイクキーを取得.
	 * 
	 * @return ブレイクキー
	 */
	public String getBrakeKey() {
		return super.getString("BRAKE_KEY");
	}

	/**
	 * リース会社を取得.
	 * 
	 * @return リース会社
	 */
	public String getLeaseCompany() {
		return super.getString("LEASE_COMPANY");
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
	 * 物件番号を取得.
	 * 
	 * @return 物件番号
	 */
	public String getBukenNo() {
		return super.getString("BKN_NO");
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
	 * リース期間を取得.
	 * 
	 * @return リース期間
	 */
	public long getLeaseTerm() {
		return super.getLong("KEI_TERM");
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
	 * リース料総額を取得.
	 * 
	 * @return リース料総額
	 */
	public long getLeaseSougaku() {
		return super.getLong("KEI_AMT");
	}

	/**
	 * 利息計算方法を取得.
	 * 
	 * @return 利息計算方法区分
	 */
	public String getRskkeijhohoKbn() {
		return super.getString("RSK_KEIJ_HOHO_KBN");
	}

	/**
	 * 役務提供費を取得.
	 * 
	 * @return 役務提供費額
	 */
	public long getEkmteikhyoSougaku() {
		return super.getLong("EKM_TEIK_HYO_SOU");
	}

	/**
	 * 維持管理費相当額を取得.
	 * 
	 * @return 維持管理費相当額
	 */
	public long getIjikanriHiSougaku() {
		return super.getLong("IJI_KANRIHI_SOU");
	}

	/**
	 * 見積現金購入価格を取得.
	 * 
	 * @return 見積現金購入価格
	 */
	public long getMitumoriGenkinKakaku() {
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
	 * 割引計算利子率を取得.
	 * 
	 * @return 割引計算利子率
	 */
	public String getWaribikiRisiRitu() {
		return super.getString("WRBK_CLC_RS_RT");
	}

	/**
	 * 前払後払区分を取得.
	 * 
	 * @return 前払後払区分
	 */
	public String getMaeBaraiAtoBarai() {
		return super.getString("MBRI_ABRI_KBN");
	}

	/**
	 * 割引現在価格を取得.
	 * 
	 * @return 割引現在価格
	 */
	public long getWaribikiGenzaiKakaku() {
		return super.getLong("WRBK_PV");
	}

	/**
	 * 取得価格相当額を取得.
	 * 
	 * @return 取得価格相当額
	 */
	public long getSyutokuKakakuSoutou() {
		return super.getLong("SYUTOKU_AMT");
	}

	/**
	 * 支払利息相当額を取得.
	 * 
	 * @return 支払利息相当額
	 */
	public long getSiharaiRisokuSougaku() {
		return super.getLong("SIHARAI_RSK");
	}

	/**
	 * 利息計算利子率を取得.
	 * 
	 * @return 利息計算利子率
	 */
	public String getRisokuRisiRitu() {
		return super.getString("RSK_CLC_RS_RT");
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
	 * 利息相当額配分方法を取得.
	 * 
	 * @return 利息相当額配分方法
	 */
	public String getRisokuBunpaiHouhou() {
		return super.getString("RSK_KEIJ_HOHO_KBN_NM");
	}

	/**
	 * 支払年月を取得.
	 * 
	 * @return 支払年月
	 */
	public String getSiharaiNenTuki() {
		return super.getString("KEIJ_YM");
	}

	/**
	 * 支払リース料を取得.
	 * 
	 * @return 支払リース料
	 */
	public long getSiharaiLeaseRyou() {
		return super.getLong("LAMT");
	}

	/**
	 * 役務提供費を取得.
	 * 
	 * @return 役務提供費額
	 */
	public long getEkmteikhyo() {
		return super.getLong("EKM_TEIK_HYO");
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
	 * ＮＥＴ支払リース料を取得.
	 * 
	 * @return ＮＥＴ支払リース料
	 */
	public long getNetSiharaiLeaseRyou() {
		return super.getLong("NET_LEASE");
	}

	/**
	 * うち利息分を取得.
	 * 
	 * @return うち利息分
	 */
	public long getUchiRisokuBun() {
		return super.getLong("UCHI_RISOKU");
	}

	/**
	 * うち債務分を取得.
	 * 
	 * @return うち債務分
	 */
	public long getUchiLeaseSaimuBun() {
		return super.getLong("UCHI_SAIMU");
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
	 * 支払利息相当額を取得.
	 * 
	 * @return 期末残高相当額
	 */
	public long getSiharaiRisoku() {
		return super.getLong("SIHARAI_RISOKU");
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

}
