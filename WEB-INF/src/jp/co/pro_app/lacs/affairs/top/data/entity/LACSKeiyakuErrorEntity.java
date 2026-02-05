package jp.co.pro_app.lacs.affairs.top.data.entity;

import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * エラー契約取得Entity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSKeiyakuErrorEntity extends EntityBase {

	private String	companyCd	= "";	// リース会社コード

	private String	cosmosCd	= "";	// 開示先コード

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSKeiyakuErrorEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT LC.LC_NM " + "\n");
		super.sql.append("      ,LU.LU_NM " + "\n");
		super.sql.append("      ,T_E.KEI_NO KEI_NO " + "\n");
		super.sql.append("      ,KEI.SHR_YM " + "\n");
		super.sql.append("      ,NVL(M_E.ERR_MSG, 'メッセージが設定されていません(' || TRIM(T_E.ERR_CD) || ')。') ERR_MSG " + "\n");
		super.sql.append("      ,DECODE(NVL(KEI.KEI_NO, '" + LACSDefine.ERROR_KEIYAKU + "'), '" + LACSDefine.ERROR_KEIYAKU + "', 1, 2) DISP_ORDER" + "\n");
		super.sql.append("FROM   T_ERR T_E " + "\n");
		super.sql.append("LEFT   JOIN   T_KEI KEI ON KEI.LC_CD = T_E.LC_CD " + "\n");
		super.sql.append("             AND    KEI.KEI_NO = T_E.KEI_NO " + "\n");
		super.sql.append("LEFT JOIN   M_LU LU ON KEI.LU_COSMOS_CD = LU.LU_COSMOS_CD " + "\n");
		super.sql.append("LEFT JOIN   M_LC LC ON KEI.LC_CD = LC.LC_CD " + "\n");
		super.sql.append("LEFT JOIN M_ERR_CD M_E ON M_E.ERR_CD = T_E.ERR_CD " + "\n");

		if (this.companyCd.trim().length() > 0) {
			super.sql.append("WHERE   KEI.LC_CD = '" + this.companyCd + "' " + "\n");
		}
		if (this.cosmosCd.trim().length() > 0) {
			super.sql.append("WHERE   NVL(KEI.LU_COSMOS_CD,'" + this.cosmosCd + "') = '" + this.cosmosCd + "' " + "\n");
		}
		super.sql.append("ORDER  BY DECODE(NVL(KEI.KEI_NO, '" + LACSDefine.ERROR_KEIYAKU + "'), '" + LACSDefine.ERROR_KEIYAKU + "', 1, 2) " + "\n");
		super.sql.append("         ,DECODE(T_E.KEI_NO, '" + LACSDefine.ERROR_KEIYAKU + "', 1, 2) " + "\n");
		super.sql.append("         ,KEI.LC_CD " + "\n");
		super.sql.append("         ,KEI.LU_COSMOS_CD " + "\n");
		super.sql.append("         ,T_E.KEI_NO " + "\n");

	}

	/**
	 * リース会社コードを設定.
	 * 
	 * @param piCompanyCd
	 *            リース会社コード
	 */
	public void setCompanyCd(String piCompanyCd) {
		this.companyCd = piCompanyCd;
	}

	/**
	 * 開示先コードを設定.
	 * 
	 * @param piCosmosCd
	 *            開示先コード
	 */
	public void setCosmosCd(String piCosmosCd) {
		this.cosmosCd = piCosmosCd;
	}

	/**
	 * リース会社名を取得.
	 * 
	 * @return リース会社名
	 */
	public String getCompanyName() {

		return super.getString("LC_NM", "");

	}

	/**
	 * リースユーザーを取得.
	 * 
	 * @return リースユーザー
	 */
	public String getUserName() {

		return super.getString("LU_NM", "");

	}

	/**
	 * 契約番号を取得.
	 * 
	 * @return 契約番号
	 */
	public String getKeiyakuNo() {
		return super.getString("KEI_NO");
	}

	/**
	 * 処理年月を取得.
	 * 
	 * @return 処理年月
	 */
	public String getShoriYM() {
		return super.getString("SHR_YM");
	}

	/**
	 * エラーメッセージを取得.
	 * 
	 * @return エラーメッセージ
	 */
	public String getErrMsg() {
		return super.getString("ERR_MSG", "");
	}

	/**
	 * 表示順を取得.
	 * 
	 * @return 表示順
	 */
	public String getDispOrder() {
		return super.getString("DISP_ORDER", "");
	}
}
