package jp.co.pro_app.lacs.affairs.syousai.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リースユーザ：リースユーザEntity.
 * 
 * @author active
 * @version 20071208
 */
public class LACSReportUserEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSReportUserEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	lucosmoscd	= "";	// COSMOSコード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		String luCosmosCd = this.getLeasCompany(); // リースユーザ

		super.sql.append(" SELECT 	KESN_KI " + "\n"); // 決算月
		super.sql.append("		,	SGK_KEI_JGI_FLG" + "\n"); // 契約額３００万円以下
		super.sql.append("		,	SRT_KEI_JGI_FLG" + "\n"); // リース期間１年未満
		super.sql.append("		,	RLS_KEI_JGI_FLG" + "\n"); // 再リース契約
		super.sql.append("		,	CYT_KAI_JGI_FLG" + "\n"); // 中途解約物件
		super.sql.append("		,	AC_SHR_KBN" + "\n"); // 会計処理区分
		super.sql.append("		,	SRKI_WRKI_CD" + "\n"); // 西暦和暦コード
		super.sql.append("		,	(SELECT COUNT(ROWID) FROM T_KEI WHERE LU_COSMOS_CD = '" + this.lucosmoscd + "' AND TAISHO_AC_KIJYUN_CD = '1' AND ERR_FLG = '0') NEW_CNT " + "\n"); // 新会計基準契約数
		super.sql.append("		,	(SELECT COUNT(ROWID) FROM T_KEI WHERE LU_COSMOS_CD = '" + this.lucosmoscd + "' AND TAISHO_AC_KIJYUN_CD = '0' AND ERR_FLG = '0') OLD_CNT " + "\n"); // 旧会計基準契約数

		super.sql.append(" FROM 	M_LU LU" + "\n");
		super.sql.append(" WHERE 	LU_COSMOS_CD = '" + luCosmosCd + "'" + "\n");
	}

	/**
	 * COSMOSコードを取得.
	 * 
	 * @return COSMOSコード
	 */
	public String getLeasCompany() {
		return this.lucosmoscd;
	}

	/**
	 * COSMOSコードを設定.
	 * 
	 * @param piLuCosmosCd
	 *            COSMOSコード
	 */
	public void setLeasCompany(String piLuCosmosCd) {
		this.lucosmoscd = piLuCosmosCd;
	}

	/**
	 * 決算月を取得.
	 * 
	 * @return 決算月
	 */
	public String getKesnKi() {
		return super.getString("KESN_KI");
	}

	/**
	 * 契約額３００万円以下を取得.
	 * 
	 * @return 契約額３００万円以下
	 */
	public String getSgkKeiJgiFlg() {
		return super.getString("SGK_KEI_JGI_FLG");
	}

	/**
	 * リース期間１年未満を取得.
	 * 
	 * @return リース期間１年未満
	 */
	public String getSrtKeiJgiFlg() {
		return super.getString("SRT_KEI_JGI_FLG");
	}

	/**
	 * 再リース契約を取得.
	 * 
	 * @return 再リース契約
	 */
	public String getRlsKeiJgiFlg() {
		return super.getString("RLS_KEI_JGI_FLG");
	}

	/**
	 * 中途解約物件を取得.
	 * 
	 * @return 中途解約物件
	 */
	public String getCytKaiJgiFlg() {
		return super.getString("CYT_KAI_JGI_FLG");
	}

	/**
	 * 会計処理区分を取得.
	 * 
	 * @return 会計処理区分
	 */
	public String getAcShrKbn() {
		return super.getString("AC_SHR_KBN");
	}

	/**
	 * 会計処理区分を取得.
	 * 
	 * @return 会計処理区分
	 */
	public String getSeirekiWarekiCode() {
		return super.getString("SRKI_WRKI_CD");
	}

	/**
	 * 新会計基準契約数を取得.
	 * 
	 * @return 新会計基準契約数
	 */
	public int getNewACCount() {
		return super.getInt("NEW_CNT");
	}

	/**
	 * 旧会計基準契約数を取得.
	 * 
	 * @return 旧会計基準契約数
	 */
	public int getOldACCount() {
		return super.getInt("OLD_CNT");
	}
}
