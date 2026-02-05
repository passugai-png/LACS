package jp.co.pro_app.lacs.affairs.shiwake.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 仕訳照会Entity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiwakeMonthEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSShiwakeMonthEntity(DBModelBase piModel) {
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

		String from = "000000";
		String to = "999999";

		this.whereSw = true;
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

		sql.append("SELECT BASE2.KEIJ_YM " + "\n");
		sql.append("	  ,SUM(LAMT) LAMT " + "\n");
		sql.append("FROM   (SELECT BASE.KEIJ_YM " + "\n");
		sql.append("			  ,NVL((SELECT SUM(FKN2.LAMT) + SUM(FKN2.LAMT_STAX) " + "\n");
		sql.append("				   FROM   T_UKB_TNKI_HEAD FKN2 " + "\n");
		sql.append("				   WHERE  FKN2.LC_CD = BASE.LC_CD " + "\n");
		sql.append("				   AND    FKN2.KEI_NO = BASE.KEI_NO " + "\n");
		sql.append("				   AND    FKN2.BKN_NO = BASE.BKN_NO " + "\n");
		sql.append("				   AND    FKN2.BKN_EDANO = BASE.BKN_EDANO " + "\n");
		sql.append("				   AND    FKN2.KEIJ_YM = BASE.KEIJ_YM) " + "\n");
		sql.append("				  ,0) LAMT " + "\n");
		sql.append("		FROM   (SELECT KEI.LU_COSMOS_CD " + "\n");
		sql.append("					  ,BKN.LC_CD " + "\n");
		sql.append("					  ,BKN.KEI_NO " + "\n");
		sql.append("					  ,BKN.BKN_NO " + "\n");
		sql.append("					  ,BKN.BKN_EDANO " + "\n");
		sql.append("					  ,RSK.KEIJ_YM " + "\n");
		sql.append("					  ,KEI.TRD_HNTE_KEKA_KBN " + "\n");
		sql.append("				FROM   T_KEI KEI " + "\n");
		sql.append("				JOIN   T_BKN BKN ON KEI.LC_CD = BKN.LC_CD " + "\n");
		sql.append("							 AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		sql.append("				JOIN   T_RSK_KEIJ_SIWAKE RSK ON BKN.LC_CD = RSK.LC_CD " + "\n");
		sql.append("										AND    BKN.KEI_NO = RSK.KEI_NO " + "\n");
		sql.append("										AND    BKN.BKN_NO = RSK.BKN_NO " + "\n");
		sql.append("										AND    BKN.BKN_EDANO = RSK.BKN_EDANO " + "\n");
		sql.append("                                        AND    BKN.RSK_KEIJ_HOHO_KBN = RSK.KEIJ_HOHO_KBN " + "\n");
		sql.append("                                        AND    '0' = RSK.KAI_REC_FLG " + "\n");
		sql.append("				WHERE  ABS(RSK.KRKT_AMT) + ABS(RSK.KSKT_AMT) > 0" + "\n");
		sql.append("				AND    KEI.ERR_FLG = '0' " + "\n");
		sql.append("				UNION " + "\n");
		sql.append("				SELECT KEI.LU_COSMOS_CD " + "\n");
		sql.append("					  ,SKK.LC_CD " + "\n");
		sql.append("					  ,SKK.KEI_NO " + "\n");
		sql.append("					  ,SKK.BKN_NO " + "\n");
		sql.append("					  ,SKK.BKN_EDANO " + "\n");
		sql.append("					  ,SKK.KEIJ_YM " + "\n");
		sql.append("					  ,KEI.TRD_HNTE_KEKA_KBN " + "\n");
		sql.append("				FROM   T_KEI KEI " + "\n");
		sql.append("				JOIN   T_BKN BKN ON KEI.LC_CD = BKN.LC_CD " + "\n");
		sql.append("							 AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		sql.append("				JOIN T_SKK_KEIJ_SIWAKE SKK ON BKN.LC_CD = SKK.LC_CD " + "\n");
		sql.append("										AND    BKN.KEI_NO = SKK.KEI_NO " + "\n");
		sql.append("										AND    BKN.BKN_NO = SKK.BKN_NO " + "\n");
		sql.append("										AND    BKN.BKN_EDANO = SKK.BKN_EDANO " + "\n");
		sql.append("                                        AND    BKN.SKK_KEIJ_HOHO_KBN = SKK.KEIJ_HOHO_KBN " + "\n");
		sql.append("                                        AND    '0' = SKK.KAI_REC_FLG " + "\n");
		sql.append("				WHERE  ABS(SKK.KRKT_AMT) + ABS(SKK.KSKT_AMT) > 0" + "\n");
		sql.append("				AND    KEI.ERR_FLG = '0' " + "\n");
		sql.append("                ) BASE " + "\n");
		sql.append(where);
		sql.append("        ) BASE2 " + "\n");
		sql.append("GROUP  BY BASE2.KEIJ_YM " + "\n");

		sql.append("ORDER  BY BASE2.KEIJ_YM " + "\n");

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

	/**
	 * 計上年月を取得.
	 * 
	 * @return 計上年月
	 */
	public String getKeijyoYM() {
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
}
