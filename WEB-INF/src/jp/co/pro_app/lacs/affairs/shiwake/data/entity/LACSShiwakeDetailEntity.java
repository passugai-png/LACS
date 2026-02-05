package jp.co.pro_app.lacs.affairs.shiwake.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 仕訳照会Entity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiwakeDetailEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSShiwakeDetailEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	cosmosCode				= "";	// COSMOSコード

	private String	keiyakuNo				= "";	// 契約番号

	private String	bukkenNo				= "";	// 物件番号

	private String	bukkenEdaNo				= "";	// 物件枝番号

	private String	leasCompanyCode			= "";	// リース会社コード

	private String	tradeHanteiKekkaCode	= "";	// 取引判定結果区分

	private String	keijyoYM				= "";	// 計上月

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		StringBuffer where = new StringBuffer();

		this.whereSw = true;
		if (this.cosmosCode.trim().length() > 0) {
			where.append(this.getWhereAnd("BASE.LU_COSMOS_CD = '" + this.cosmosCode + "'"));
		}

		if (this.keijyoYM.trim().length() > 0) {
			where.append(this.getWhereAnd("BASE.KEIJ_YM = '" + this.keijyoYM + "'"));
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

		sql.append("SELECT BASE.KR_KNJ_KMK_NM " + "\n");
		sql.append("	  ,SUM(BASE.KRKT_AMT) KRKT_AMT " + "\n");
		sql.append("	  ,BASE.KS_KNJ_KMK_NM " + "\n");
		sql.append("	  ,SUM(BASE.KSKT_AMT) KSKT_AMT " + "\n");
		sql.append("FROM   (SELECT KEI.LU_COSMOS_CD " + "\n");
		sql.append("			  ,RSK.LC_CD " + "\n");
		sql.append("			  ,RSK.KEI_NO " + "\n");
		sql.append("			  ,RSK.KEIJ_YM " + "\n");
		sql.append("			  ,RSK.BKN_NO " + "\n");
		sql.append("			  ,RSK.BKN_EDANO " + "\n");
		sql.append("			  ,KEI.TRD_HNTE_KEKA_KBN " + "\n");
		sql.append("			  ,RSK.SIWAKE_GYO " + "\n");
		sql.append("              ,SWK.KR_KNJ_KMK_NM " + "\n");
		sql.append("			  ,RSK.KRKT_AMT " + "\n");
		sql.append("              ,SWK.KS_KNJ_KMK_NM " + "\n");
		sql.append("			  ,RSK.KSKT_AMT " + "\n");
		sql.append("              ,'1' SWK_KBN " + "\n");
		sql.append("		FROM   T_KEI KEI " + "\n");
		sql.append("		JOIN   T_BKN BKN ON KEI.LC_CD = BKN.LC_CD " + "\n");
		sql.append("					 AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		sql.append("		JOIN   T_RSK_KEIJ_SIWAKE RSK ON BKN.LC_CD = RSK.LC_CD " + "\n");
		sql.append("								 AND    BKN.KEI_NO = RSK.KEI_NO " + "\n");
		sql.append("								 AND    BKN.BKN_NO = RSK.BKN_NO " + "\n");
		sql.append("								 AND    BKN.BKN_EDANO = RSK.BKN_EDANO " + "\n");
		sql.append("								 AND    BKN.RSK_KEIJ_HOHO_KBN = RSK.KEIJ_HOHO_KBN " + "\n");
		sql.append("								 AND    '0' = RSK.KAI_REC_FLG " + "\n");
		sql.append("		JOIN   M_RSK_KEIJ_SIWAKE_TEIGI SWK ON KEI.SIWAKE_LU_COSMOS_CD = SWK.LU_COSMOS_CD " + "\n");
		sql.append("									   AND    BKN.RSK_KEIJ_HOHO_KBN = SWK.KEIJ_HOHO_KBN " + "\n");
		sql.append("									   AND    KEI.TRD_HNTE_KEKA_KBN = SWK.TRD_HNTE_KEKA_KBN " + "\n");
		sql.append("									   AND    KEI.CTSHK_FLG = SWK.CTSHK_FLG " + "\n");
		sql.append("									   AND    BKN.SSN_SRI_CD = SWK.SSN_SRI_CD " + "\n");
		sql.append("									   AND    RSK.SIWAKE_GYO = SWK.SIWAKE_GYO " + "\n");
		sql.append("		WHERE  KEI.ERR_FLG = '0' " + "\n");
		sql.append("		UNION " + "\n");
		sql.append("		SELECT KEI.LU_COSMOS_CD " + "\n");
		sql.append("			  ,SKK.LC_CD " + "\n");
		sql.append("			  ,SKK.KEI_NO " + "\n");
		sql.append("			  ,SKK.KEIJ_YM " + "\n");
		sql.append("			  ,SKK.BKN_NO " + "\n");
		sql.append("			  ,SKK.BKN_EDANO " + "\n");
		sql.append("			  ,KEI.TRD_HNTE_KEKA_KBN " + "\n");
		sql.append("			  ,SKK.SIWAKE_GYO " + "\n");
		sql.append("              ,SWK.KR_KNJ_KMK_NM " + "\n");
		sql.append("			  ,SKK.KRKT_AMT " + "\n");
		sql.append("              ,SWK.KS_KNJ_KMK_NM " + "\n");
		sql.append("			  ,SKK.KSKT_AMT " + "\n");
		sql.append("              ,'2' SWK_KBN " + "\n");
		sql.append("		FROM   T_KEI KEI " + "\n");
		sql.append("		JOIN   T_BKN BKN ON KEI.LC_CD = BKN.LC_CD " + "\n");
		sql.append("					 AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		sql.append("		JOIN   T_SKK_KEIJ_SIWAKE SKK ON BKN.LC_CD = SKK.LC_CD " + "\n");
		sql.append("								 AND    BKN.KEI_NO = SKK.KEI_NO " + "\n");
		sql.append("								 AND    BKN.BKN_NO = SKK.BKN_NO " + "\n");
		sql.append("								 AND    BKN.BKN_EDANO = SKK.BKN_EDANO " + "\n");
		sql.append("								 AND    BKN.SKK_KEIJ_HOHO_KBN = SKK.KEIJ_HOHO_KBN " + "\n");
		sql.append("								 AND    '0' = SKK.KAI_REC_FLG " + "\n");
		sql.append("		JOIN   M_SKK_KEIJ_SIWAKE_TEIGI SWK ON KEI.SIWAKE_LU_COSMOS_CD = SWK.LU_COSMOS_CD " + "\n");
		sql.append("									   AND    BKN.SKK_KEIJ_HOHO_KBN = SWK.KEIJ_HOHO_KBN " + "\n");
		sql.append("									   AND    KEI.TRD_HNTE_KEKA_KBN = SWK.TRD_HNTE_KEKA_KBN " + "\n");
		sql.append("									   AND    KEI.CTSHK_FLG = SWK.CTSHK_FLG " + "\n");
		sql.append("									   AND    BKN.SSN_SRI_CD = SWK.SSN_SRI_CD " + "\n");
		sql.append("									   AND    SKK.SIWAKE_GYO = SWK.SIWAKE_GYO " + "\n");
		sql.append("		WHERE  KEI.ERR_FLG = '0' " + "\n");
		sql.append(") BASE " + "\n");
		sql.append(where);
		sql.append("GROUP  BY BASE.SWK_KBN " + "\n");
		sql.append("		 ,BASE.SIWAKE_GYO " + "\n");
		sql.append("		 ,BASE.KR_KNJ_KMK_NM " + "\n");
		sql.append("		 ,BASE.KS_KNJ_KMK_NM " + "\n");
		sql.append("ORDER  BY BASE.SWK_KBN " + "\n");
		sql.append("		 ,BASE.SIWAKE_GYO " + "\n");

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
	 * 計上年月を設定.
	 * 
	 * @param piKeijyoYM
	 *            計上年月
	 */
	public void setKeijyoYM(String piKeijyoYM) {
		this.keijyoYM = piKeijyoYM;
	}

	/**
	 * 借方金額を取得.
	 * 
	 * @return 借方金額
	 */
	public long getKamokuAmountLKari() {
		return super.getLong("KRKT_AMT");
	}

	/**
	 * 貸方金額を取得.
	 * 
	 * @return 貸方金額
	 */
	public long getKamokuAmountRKashi() {
		return super.getLong("KSKT_AMT");
	}

	/**
	 * 貸方科目を取得.
	 * 
	 * @return 貸方科目
	 */
	public String getKamokuLKari() {
		return super.getString("KR_KNJ_KMK_NM");
	}

	/**
	 * 貸方科目を取得.
	 * 
	 * @return 貸方科目
	 */
	public String getKamokuRKashi() {
		return super.getString("KS_KNJ_KMK_NM");
	}

}
