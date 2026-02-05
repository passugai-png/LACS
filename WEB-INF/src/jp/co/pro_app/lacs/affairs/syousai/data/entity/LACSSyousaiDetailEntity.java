package jp.co.pro_app.lacs.affairs.syousai.data.entity;

import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 契約詳細Entity.
 * 
 * @author yokota
 * @version 20081017
 */
public class LACSSyousaiDetailEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSSyousaiDetailEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	keiyakuNo		= "";	// 契約番号

	private String	leasCompanyCode	= "";	// リース会社コード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT DISTINCT BKN.KEI_NO " + "\n");
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
		
		// 20210415 arai 追加 start 取得価格相当額 対応	    		
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
		// 20210415 arai 追加 end 取得価格相当額 対応
		
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
		
		// 20210415 arai 維持管理費用対応 start
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
		// 20210415 arai 維持管理費用 対応 end
		
		super.sql.append("	  ,BKN.IPN_EKM_TEIK_HYO " + "\n");
		super.sql.append("		+ BKN.SHRY_EKM_TEIK_HYO EKM_TEIK_HI" + "\n");
		super.sql.append("	  ,DECODE(KEI.LU_TRSK_CD , BKN.ZANK_HSHOSK_CD , '有' , BKN.IPN_ZANK_HSHOSK_CD , '有' ,'無') ZANK_UMU " + "\n");
		super.sql.append("	  ,BKN.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("	  ,KEIJ_HOHO_KBN.DISP_SKK_HOHO_NM " + "\n");
		super.sql.append("	  ,BKN.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("FROM   T_BKN BKN " + "\n");
		super.sql.append("JOIN   T_KEI KEI ON KEI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("			 AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("JOIN   M_LC LC ON LC.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("JOIN   M_SSN_SRI SSN_SRI ON BKN.SSN_SRI_CD = SSN_SRI.SSN_SRI_CD " + "\n");
		super.sql.append("LEFT JOIN   M_SKK_KEIJ_HOHO_KBN KEIJ_HOHO_KBN ON KEIJ_HOHO_KBN.SKK_KEIJ_HOHO_KBN = BKN.SKK_KEIJ_HOHO_KBN " + "\n");	
		
		// 20210415 arai 維持管理費用対応 start
		//super.sql.append("LEFT JOIN T_FKN_TNKI_HEAD FKN ON BKN.LC_CD = FKN.LC_CD  \n");
		//super.sql.append("              	  AND BKN.KEI_NO = FKN.KEI_NO  \n");
		//super.sql.append("					  AND BKN.BKN_NO = FKN.BKN_NO  \n");
		//super.sql.append("					  AND BKN.BKN_EDANO = FKN.BKN_EDANO  \n");
		//super.sql.append("LEFT JOIN T_FKN_TNKI_DETAIL FKN_DETAIL ON FKN.LC_CD = FKN_DETAIL.LC_CD  \n");
		//super.sql.append("				      AND FKN.KEI_NO = FKN_DETAIL.KEI_NO  \n");
		//super.sql.append("					  AND FKN.BKN_NO = FKN_DETAIL.BKN_NO  \n");
		//super.sql.append("					  AND FKN.BKN_EDANO = FKN_DETAIL.BKN_EDANO  \n");
		//super.sql.append("					  AND FKN.KEIJ_YM = FKN_DETAIL.KEIJ_YM  \n");		
		//super.sql.append("					  AND BKN.RSK_KEIJ_HOHO_KBN = FKN_DETAIL.KEIJ_HOHO_KBN  \n");
		// 20210415 arai 維持管理費用対応 end			
		
		super.sql.append("WHERE KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "'  \n");
		super.sql.append("	AND KEI.KEI_NO='" + this.keiyakuNo + "' \n");
		super.sql.append("ORDER BY " + "\n");
		super.sql.append("	  BKN_NO " + "\n");
		
		//System.out.println(sql);

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
	public double getWaribikiKeisanRisiRitu() {
		return super.getDouble("WRBK_RS_RT");
	}

	/**
	 * 利息計算利子率を取得.
	 * 
	 * @return 利息計算利子率
	 */
	public double getRisokuKeisanRisiRitu() {
		return super.getDouble("RSK_CLC_RS_RT");
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
		return super.getString("DISP_SKK_HOHO_NM", "");
	}

	/**
	 * 利息計上方法区分を取得.
	 * 
	 * @return 利息計上方法区分
	 */
	public String getRskKeijHohoKbn() {
		return super.getString("RSK_KEIJ_HOHO_KBN");
	}
}
