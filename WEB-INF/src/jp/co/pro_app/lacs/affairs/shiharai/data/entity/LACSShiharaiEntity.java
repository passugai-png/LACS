package jp.co.pro_app.lacs.affairs.shiharai.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 支払推移表Entity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiharaiEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSShiharaiEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	cosmosCode				= "";	// COSMOSコード

	private String	keiyakuNo				= "";	// 契約番号

	private String	bukkenNo				= "";	// 物件番号

	private String	bukkenEdaNo				= "";	// 物件枝番号

	private String	leasCompanyCode			= "";	// リース会社コード

	private String	tradeHanteiKekkaCode	= "";	// 取引判定結果区分

	private String	termFrom				= "";	// 期間From

	private String	termTo					= "";	// 期間To

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		StringBuffer where = new StringBuffer();

		this.whereSw = true;

		String from = "000000";
		String to = "999999";

		if (this.cosmosCode.trim().length() > 0) {
			where.append(this.getWhereAnd("BASE.LU_COSMOS_CD = '" + this.cosmosCode + "'"));
		}

		if (this.leasCompanyCode.trim().length() > 0) {
			where.append(this.getWhereAnd("BASE.LC_CD = '" + this.leasCompanyCode + "'"));
		}

		if (this.keiyakuNo.trim().length() > 0) {
			where.append(this.getWhereAnd("BASE.KEI_NO = '" + this.keiyakuNo + "'"));
		}

		if (this.bukkenNo.trim().length() > 0) {
			where.append(this.getWhereAnd("BASE.BKN_NO = '" + this.bukkenNo + "'"));
			where.append(this.getWhereAnd("BASE.BKN_EDANO = '" + this.bukkenEdaNo + "'"));
		}

		if (this.tradeHanteiKekkaCode.trim().length() > 0) {
			where.append(this.getWhereAnd("BASE.TRD_HNTE_KEKA_KBN = '" + this.tradeHanteiKekkaCode + "'"));
		}

		if (this.termFrom.trim().length() > 0) {
			from = this.termFrom.substring(0, 6);
		}

		
		if (this.termTo.trim().length() > 0) {
			to = this.termTo.substring(0, 6);
		}

		where.append(this.getWhereAnd("BASE.KEIJ_YM BETWEEN  '" + from + "' AND '" + to + "'"));

		sql.append("SELECT BASE.KEIJ_YM " + "\n");
		sql.append("	  ,SUM(LAMT) LAMT " + "\n");
		sql.append("	  ,SUM(LAMT_STAX) LAMT_STAX " + "\n");
		sql.append("	  ,SUM(TGTU_GNPN) TGTU_GNPN " + "\n");
		sql.append("	  ,SUM(TGTU_RSK) TGTU_RSK " + "\n");
		sql.append("	  ,SUM(IJI_KANRI_HYO) IJI_KANRI_HYO " + "\n");
		sql.append("	  ,SUM(EKM_TEIK_HYO) EKM_TEIK_HYO " + "\n");
		sql.append("	  ,SUM(TGTU_SKK_AMT) TGTU_SKK_AMT " + "\n");
		sql.append("FROM   (SELECT KEI.LU_COSMOS_CD " + "\n");
		sql.append("			  ,HEAD.LC_CD " + "\n");
		sql.append("			  ,HEAD.KEI_NO " + "\n");
		sql.append("			  ,HEAD.KEIJ_YM " + "\n");
		sql.append("			  ,HEAD.BKN_NO " + "\n");
		sql.append("			  ,HEAD.BKN_EDANO " + "\n");
		sql.append("			  ,KEI.TRD_HNTE_KEKA_KBN " + "\n");
		sql.append("			  ,HEAD.LAMT " + "\n");
		sql.append("			  ,HEAD.LAMT_STAX " + "\n");
		sql.append("			  ,DETAIL.TGTU_GNPN " + "\n");
		sql.append("			  ,DETAIL.TGTU_RSK " + "\n");
		//sql.append("			  ,CASE WHEN BKN.RSK_KEIJ_HOHO_KBN = '201' THEN 0 ELSE HEAD.ENT_SHOHYO_KZI + HEAD.ENT_SHOHYO_HKZI + HEAD.GTAX + HEAD.CTAX + HEAD.JTAX + HEAD.JBSK_HKN + HEAD.NNI_HKN + HEAD.RCYCL_RYO_KNRI_AMT + " + "\n");
		//sql.append("			   HEAD.DOSO + HEAD.KOZEI + HEAD.OTH_CST END IJI_KANRI_HYO " + "\n");
		
		// 20210414 arai 維持管理費用対応 start
		sql.append("			  ,FKN.ENT_SHOHYO_KZI + FKN.ENT_SHOHYO_HKZI + FKN.GTAX + FKN.CTAX + FKN.JTAX + FKN.JBSK_HKN + FKN.NNI_HKN + FKN.RCYCL_RYO_KNRI_AMT + " + "\n");
		sql.append("			   FKN.DOSO + FKN.KOZEI + FKN.OTH_CST IJI_KANRI_HYO " + "\n");
		// 20210414 arai 維持管理費用対応 end
		
		
		sql.append("			  ,CASE WHEN BKN.RSK_KEIJ_HOHO_KBN = '201' THEN 0 ELSE HEAD.IPN_EKM_TEIK_HYO + HEAD.SHRY_EKM_TEIK_HYO END EKM_TEIK_HYO " + "\n");
		sql.append("			  ,0 TGTU_SKK_AMT " + "\n");
		sql.append("		FROM   T_KEI KEI " + "\n");
		sql.append("		JOIN   T_BKN BKN ON KEI.LC_CD = BKN.LC_CD " + "\n");
		sql.append("					 AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		sql.append("		JOIN   T_UKB_TNKI_HEAD HEAD ON BKN.LC_CD = HEAD.LC_CD " + "\n");
		sql.append("								AND    BKN.KEI_NO = HEAD.KEI_NO " + "\n");
		sql.append("								AND    BKN.BKN_NO = HEAD.BKN_NO " + "\n");
		sql.append("								AND    BKN.BKN_EDANO = HEAD.BKN_EDANO " + "\n");
		sql.append("								AND    '0' = HEAD.KAI_REC_FLG " + "\n");
		sql.append("		JOIN   T_UKB_TNKI_DETAIL DETAIL ON HEAD.LC_CD = DETAIL.LC_CD " + "\n");
		sql.append("									AND    HEAD.KEI_NO = DETAIL.KEI_NO " + "\n");
		sql.append("									AND    HEAD.BKN_NO = DETAIL.BKN_NO " + "\n");
		sql.append("									AND    HEAD.BKN_EDANO = DETAIL.BKN_EDANO " + "\n");
		sql.append("									AND    HEAD.KEIJ_YM = DETAIL.KEIJ_YM " + "\n");
		sql.append("									AND    BKN.RSK_KEIJ_HOHO_KBN = DETAIL.KEIJ_HOHO_KBN " + "\n");		
		// 20210414 arai 維持管理費用対応 start
		sql.append("		JOIN   T_FKN_TNKI_HEAD FKN ON HEAD.LC_CD = DETAIL.LC_CD " + "\n");
		sql.append("									AND    DETAIL.KEI_NO = FKN.KEI_NO " + "\n");
		sql.append("									AND    DETAIL.BKN_NO = FKN.BKN_NO " + "\n");
		sql.append("									AND    DETAIL.BKN_EDANO = FKN.BKN_EDANO " + "\n");
		sql.append("									AND    DETAIL.KEIJ_YM = FKN.KEIJ_YM " + "\n");
		// 20210414 arai 維持管理費用対応 end	
		sql.append("		WHERE  KEI.ERR_FLG = '0' " + "\n");
		sql.append("		UNION " + "\n");
		sql.append("		SELECT KEI.LU_COSMOS_CD " + "\n");
		sql.append("			  ,GNK.LC_CD " + "\n");
		sql.append("			  ,GNK.KEI_NO " + "\n");
		sql.append("			  ,GNK.KEIJ_YM " + "\n");
		sql.append("			  ,GNK.BKN_NO " + "\n");
		sql.append("			  ,GNK.BKN_EDANO " + "\n");
		sql.append("			  ,KEI.TRD_HNTE_KEKA_KBN " + "\n");
		sql.append("			  ,0 LAMT " + "\n");
		sql.append("			  ,0 LAMT_STAX " + "\n");
		sql.append("			  ,0 TGTU_GNPN " + "\n");
		sql.append("			  ,0 TGTU_RSK " + "\n");
		sql.append("			  ,0 IJI_KANRI_HYO " + "\n");
		sql.append("			  ,0 EKM_TEIK_HYO " + "\n");
		sql.append("			  ,GNK.TGTU_SKK_AMT " + "\n");
		sql.append("		FROM   T_KEI KEI " + "\n");
		sql.append("		JOIN   T_BKN BKN ON KEI.LC_CD = BKN.LC_CD " + "\n");
		sql.append("					 AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		sql.append("		JOIN   T_UKB_GNKSK GNK ON BKN.LC_CD = GNK.LC_CD " + "\n");
		sql.append("					   AND    BKN.KEI_NO = GNK.KEI_NO " + "\n");
		sql.append("					   AND    BKN.BKN_NO = GNK.BKN_NO " + "\n");
		sql.append("					   AND    BKN.BKN_EDANO = GNK.BKN_EDANO " + "\n");
		sql.append("					   AND    BKN.SKK_KEIJ_HOHO_KBN = GNK.KEIJ_HOHO_KBN " + "\n");
		sql.append("					   AND    '0' = GNK.KAI_REC_FLG " + "\n");
		sql.append("		WHERE  KEI.ERR_FLG = '0' " + "\n");
		sql.append("		) BASE " + "\n");
		sql.append(where);
		sql.append("GROUP  BY BASE.KEIJ_YM " + "\n");
		sql.append("ORDER  BY BASE.KEIJ_YM " + "\n");

		System.out.println(super.sql);
	}

	/**
	 * COSMOSコードを設定.
	 * 
	 * @param piCosmosCode
	 *            COSMOSコード
	 */
	public void setCosmosCode(String piCosmosCode) {
		this.cosmosCode = piCosmosCode;
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
	 * 物件番号を設定.
	 * 
	 * @param piBukkenNo
	 *            物件番号
	 */
	public void setBukkenNo(String piBukkenNo) {
		this.bukkenNo = piBukkenNo;
	}

	/**
	 * 物件枝番号を設定.
	 * 
	 * @param piBukkenEdaNo
	 *            物件枝番号
	 */
	public void setBukkenEdaNo(String piBukkenEdaNo) {
		this.bukkenEdaNo = piBukkenEdaNo;
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
	 * 取引判定結果区分を設定.
	 * 
	 * @param piTradeHanteiKekkaCode
	 *            取引判定結果区分
	 */
	public void setTradeHanteiKekkaCode(String piTradeHanteiKekkaCode) {
		this.tradeHanteiKekkaCode = piTradeHanteiKekkaCode;
	}

	/**
	 * 計上年月を取得.
	 * 
	 * @return 計上年月
	 */
	public String getDate() {
		return super.getString("KEIJ_YM");
	}

	/**
	 * リース料を取得.
	 * 
	 * @return リース料
	 */
	public long getLeasAmount() {
		return super.getLong("LAMT");
	}

	/**
	 * リース料消費税を取得.
	 * 
	 * @return リース料消費税
	 */
	public long getLeasAmountSTAX() {
		return super.getLong("LAMT_STAX");
	}

	/**
	 * 当月元本を取得.
	 * 
	 * @return 当月元本
	 */
	public long getGanponAmount() {
		return super.getLong("TGTU_GNPN");
	}

	/**
	 * 利息を取得.
	 * 
	 * @return 利息
	 */
	public long getRisokuAmount() {
		return super.getLong("TGTU_RSK");
	}

	/**
	 * 維持管理費を取得.
	 * 
	 * @return 維持管理費
	 */
	public long getIjiKanriAmount() {
		return super.getLong("IJI_KANRI_HYO");
	}

	/**
	 * 役務提供費を取得.
	 * 
	 * @return 役務提供費
	 */
	public long getEkimuTeikyouAmount() {
		return super.getLong("EKM_TEIK_HYO");
	}

	/**
	 * 償却額を取得.
	 * 
	 * @return 償却額
	 */
	public long getShoukyakuAmount() {
		return super.getLong("TGTU_SKK_AMT");
	}

	/**
	 * 期間Fromを設定.
	 * 
	 * @param piTermFrom
	 *            期間From
	 */
	public void setTermFrom(String piTermFrom) {
		this.termFrom = piTermFrom;
	}

	/**
	 * 期間Toを設定.
	 * 
	 * @param piTermTo
	 *            期間To
	 */
	public void setTermTo(String piTermTo) {
		this.termTo = piTermTo;
	}

}
