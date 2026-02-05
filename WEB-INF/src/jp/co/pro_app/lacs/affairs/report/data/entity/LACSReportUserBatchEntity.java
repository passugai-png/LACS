package jp.co.pro_app.lacs.affairs.report.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リースユーザ：リースユーザEntity.
 * 
 * @author active
 * @version 20071208
 */
public class LACSReportUserBatchEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSReportUserBatchEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	lucosmoscd	= "";	// COSMOSコード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		String luCosmosCd = this.getLeasCompany(); // リースユーザ

		super.sql.append(" SELECT 	KESN_KI " + "\n"); // 決算月
		super.sql.append("		,	GTJ_SGK_KEI_JGI_FLG" + "\n"); // 月次帳票-契約額３００万円以下
		super.sql.append("		,	GTJ_SRT_KEI_JGI_FLG" + "\n"); // 月次帳票-リース期間１年未満
		super.sql.append("		,	GTJ_RLS_KEI_JGI_FLG" + "\n"); // 月次帳票-再リース契約
		super.sql.append("		,	GTJ_CYT_KAI_JGI_FLG" + "\n"); // 月次帳票-中途解約物件
		super.sql.append("		,	OLD_SGK_KEI_JGI_FLG" + "\n"); // 旧会計基準-契約額３００万円以下
		super.sql.append("		,	OLD_SRT_KEI_JGI_FLG" + "\n"); // 旧会計基準-リース期間１年未満
		super.sql.append("		,	OLD_RLS_KEI_JGI_FLG" + "\n"); // 旧会計基準-再リース契約
		super.sql.append("		,	OLD_CYT_KAI_JGI_FLG" + "\n"); // 旧会計基準-中途解約物件
		super.sql.append("		,	NEW_SGK_KEI_JGI_FLG" + "\n"); // 新会計基準-契約額３００万円以下
		super.sql.append("		,	NEW_SRT_KEI_JGI_FLG" + "\n"); // 新会計基準-リース期間１年未満
		super.sql.append("		,	NEW_RLS_KEI_JGI_FLG" + "\n"); // 新会計基準-再リース契約
		super.sql.append("		,	NEW_CYT_KAI_JGI_FLG" + "\n"); // 新会計基準-中途解約物件
		super.sql.append("		,	AC_SHR_KBN" + "\n"); // 会計処理区分
		super.sql.append("		,   SRKI_WRKI_CD" + "\n"); // 西暦和暦コード
		super.sql.append("		,	LC_TNT_CD" + "\n"); // リース会社担当者コード
		super.sql.append("		,	LC_TNT_NM" + "\n"); // リース会社担当者名
		super.sql.append("		,	LU_TNT_NM" + "\n"); // リース会社担当者名
		super.sql.append("		,	LU_ADR1" + "\n"); // リース会社住所１
		super.sql.append("		,	LU_ADR2" + "\n"); // リース会社住所2
		super.sql.append("		,　'〒' || LU_ZIP1 || '-' || LU_ZIP2 AS LU_ZIP" + "\n"); // リース会社郵便番号
		super.sql.append("		,	LC_SHZK_SHO || '-' || LC_SHZK_BU || '-' || LC_SHZK_GRP AS LC_SHZK_CD" + "\n"); //リース会社部署 コード
		super.sql.append("		,	LC_SHZK_NM" + "\n"); // リース会社部署名称
		super.sql.append("		,	LU_NM" + "\n"); // リースユーザー名称
		super.sql.append("		,	(SELECT COUNT(ROWID) FROM T_KEI WHERE LU_COSMOS_CD = '" + this.lucosmoscd + "' AND TAISHO_AC_KIJYUN_CD = '1' AND ERR_FLG = '0') NEW_CNT " + "\n"); // 新会計基準契約数
		super.sql.append("		,	(SELECT COUNT(ROWID) FROM T_KEI WHERE LU_COSMOS_CD = '" + this.lucosmoscd + "' AND TAISHO_AC_KIJYUN_CD = '0' AND ERR_FLG = '0') OLD_CNT " + "\n"); // 旧会計基準契約数
		super.sql.append("	  ,OLD_SUM_UNT " + "\n");
		super.sql.append("	  ,NEW_SUM_UNT " + "\n");
		super.sql.append("		,	BATCH_PRINT_TIMING_CD" + "\n"); // バッチ出力タイミング
		super.sql.append(" FROM 	M_LU LU" + "\n");
		super.sql.append(" WHERE 	LU_COSMOS_CD = '" + luCosmosCd + "'" + "\n");
		
		System.out.println(sql);
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
	 * 月次帳票-契約額３００万円以下を取得.
	 * 
	 * @return 月次帳票-契約額３００万円以下
	 */
	public String getGtjSgkKeiJgiFlg() {
		return super.getString("GTJ_SGK_KEI_JGI_FLG");
	}

	/**
	 * 月次帳票-リース期間１年未満を取得.
	 * 
	 * @return 月次帳票-リース期間１年未満
	 */
	public String getGtjSrtKeiJgiFlg() {
		return super.getString("GTJ_SRT_KEI_JGI_FLG");
	}

	/**
	 * 月次帳票-再リース契約を取得.
	 * 
	 * @return 月次帳票-再リース契約
	 */
	public String getGtjRlsKeiJgiFlg() {
		return super.getString("GTJ_RLS_KEI_JGI_FLG");
	}

	/**
	 * 月次帳票-中途解約物件を取得.
	 * 
	 * @return 月次帳票-中途解約物件
	 */
	public String getGtjCytKaiJgiFlg() {
		return super.getString("GTJ_CYT_KAI_JGI_FLG");
	}

	/**
	 * 旧会計基準-契約額３００万円以下を取得.
	 * 
	 * @return 旧会計基準-契約額３００万円以下
	 */
	public String getOldSgkKeiJgiFlg() {
		return super.getString("OLD_SGK_KEI_JGI_FLG");
	}

	/**
	 * 旧会計基準-リース期間１年未満を取得.
	 * 
	 * @return 旧会計基準-リース期間１年未満
	 */
	public String getOldSrtKeiJgiFlg() {
		return super.getString("OLD_SRT_KEI_JGI_FLG");
	}

	/**
	 * 旧会計基準-再リース契約を取得.
	 * 
	 * @return 旧会計基準-再リース契約
	 */
	public String getOldRlsKeiJgiFlg() {
		return super.getString("OLD_RLS_KEI_JGI_FLG");
	}

	/**
	 * 旧会計基準-中途解約物件を取得.
	 * 
	 * @return 旧会計基準-中途解約物件
	 */
	public String getOldCytKaiJgiFlg() {
		return super.getString("OLD_CYT_KAI_JGI_FLG");
	}

	/**
	 * 新会計基準-契約額３００万円以下を取得.
	 * 
	 * @return 新会計基準-契約額３００万円以下
	 */
	public String getNewSgkKeiJgiFlg() {
		return super.getString("NEW_SGK_KEI_JGI_FLG");
	}

	/**
	 * 新会計基準-リース期間１年未満を取得.
	 * 
	 * @return 新会計基準-リース期間１年未満
	 */
	public String getNewSrtKeiJgiFlg() {
		return super.getString("NEW_SRT_KEI_JGI_FLG");
	}

	/**
	 * 新会計基準-再リース契約を取得.
	 * 
	 * @return 新会計基準-再リース契約
	 */
	public String getNewRlsKeiJgiFlg() {
		return super.getString("NEW_RLS_KEI_JGI_FLG");
	}

	/**
	 * 新会計基準-中途解約物件を取得.
	 * 
	 * @return 新会計基準-中途解約物件
	 */
	public String getNewCytKaiJgiFlg() {
		return super.getString("NEW_CYT_KAI_JGI_FLG");
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
	 * 西暦和暦コードを取得.
	 * 
	 * @return 西暦和暦コード
	 */
	public String getSeirekiWarekiCode() {
		return super.getString("SRKI_WRKI_CD");
	}
	
	/**
	 * バッチ出力タイミングを取得.
	 * 
	 * @return バッチ出力タイミング
	 */
	public String getBatchPrintTimingCd() {
		return super.getString("BATCH_PRINT_TIMING_CD");
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

	/**
	 * 旧会計基準－集計単位を取得.
	 * 
	 * @return 旧会計基準－集計単位
	 */
	public String getOldSumUnit() {
		return super.getString("OLD_SUM_UNT");
	}

	/**
	 * 新会計基準－集計単位を取得.
	 * 
	 * @return 新会計基準－集計単位
	 */
	
	public String getNewSumUnit() {
		return super.getString("NEW_SUM_UNT");
	}
	
	/**
	 * リース会社担当者コードを取得.
	 * 
	 * @return リース会社担当者コード
	 */
	public String getTantosyaCode() {
		return super.getString("LC_TNT_CD");
	}
	
	/**
	 * リース会社担当者名を取得.
	 * 
	 * @return リース会社担当者名
	 */
	public String getLcTantosyaName() {
		return super.getString("LC_TNT_NM");
	}
	
	/**
	 * リース会社担当者名を取得.
	 * 
	 * @return リース会社担当者名
	 */
	public String getLuTantosyaName() {
		return super.getString("LU_TNT_NM");
	}
	
	/**
	 *リース会社部署コードを取得.
	 * 
	 * @return リース会社部署コード
	 */
	public String getShzkCode() {
		return super.getString("LC_SHZK_CD");
	}
	
	/**
	 * リース会社部署名称を取得.
	 * 
	 * @return リース会社部署名称
	 */
	public String getShzkName() {
		return super.getString("LC_SHZK_NM");
	}
	
	/**
	 *  リースユーザー名称を取得.
	 * 
	 * @return  リースユーザー名称
	 */
	public String getLacsUserName() {
		return super.getString("LU_NM");
	}
	
	/**
	 *  リース会社住所１を取得.
	 * 
	 * @return  リース会社住所１
	 */
	public String getLeaseCompanyAddr1	() {
		return super.getString("LU_ADR1");
	}
	
	/**
	 *  リース会社住所２を取得.
	 * 
	 * @return  リース会社住所２
	 */
	public String getLeaseCompanyAddr2	() {
		return super.getString("LU_ADR2");
	}
	
	
	/**
	 *  リース会社郵便番号を取得.
	 * 
	 * @return  リース会社郵便番号
	 */
	public String getLeaseCompanyZip() {
		return super.getString("LU_ZIP");
	}
}
