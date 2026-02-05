package jp.co.pro_app.lacs.affairs.user.data.entity;

import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リースユーザーマスタEntity.
 * 
 * @author takeda
 * @version 20070910
 */
public class LACSUserEntity extends EntityBase {

	/**
	 * リースユーザーマスタ コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSUserEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	cosmosCode	= "";	// COSMOSコード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT LU_COSMOS_CD " + "\n");
		super.sql.append("	  ,LU_NM " + "\n");
		super.sql.append("	  ,LU_ZIP1 " + "\n");
		super.sql.append("	  ,LU_ZIP2 " + "\n");
		super.sql.append("	  ,LU_ADR1 " + "\n");
		super.sql.append("	  ,LU_ADR2 " + "\n");
		super.sql.append("	  ,LU_TELNO " + "\n");
		super.sql.append("	  ,LU_TNT_NM " + "\n");
		super.sql.append("	  ,SRKI_WRKI_CD " + "\n");
		super.sql.append("	  ,AC_SHR_KBN " + "\n");
		super.sql.append("	  ,KESN_KI " + "\n");
		super.sql.append("	  ,GTJ_SRT_KEI_JGI_FLG " + "\n");
		super.sql.append("	  ,GTJ_RLS_KEI_JGI_FLG " + "\n");
		super.sql.append("	  ,GTJ_SGK_KEI_JGI_FLG " + "\n");
		super.sql.append("	  ,GTJ_CYT_KAI_JGI_FLG " + "\n");
		super.sql.append("	  ,WEB_DB_DATA_SRC " + "\n");
		super.sql.append("	  ,OLD_ITN_YUKEI_SKK_HOHO_CD " + "\n");
		super.sql.append("	  ,OLD_ITN_MUKEI_SKK_HOHO_CD " + "\n");
		super.sql.append("	  ,OLD_ITNGI_YUKEI_SKK_HOHO_CD " + "\n");
		super.sql.append("	  ,OLD_ITNGI_MUKEI_SKK_HOHO_CD " + "\n");
		super.sql.append("	  ,OLD_MBRI_ABRI_KBN " + "\n");
		super.sql.append("	  ,OLD_RSK_CLC_HOHO_CD " + "\n");
		super.sql.append("	  ,OLD_FKN_TNKI_HOHO_CD " + "\n");
		super.sql.append("	  ,OLD_IJI_KNRI_HYO_JYO_KBN " + "\n");
		super.sql.append("	  ,OLD_EKM_TEIK_HYO_JYO_KBN " + "\n");
		super.sql.append("	  ,OLD_GNKSK_HASU_CHSE_CD " + "\n");
		super.sql.append("	  ,OLD_FKN_TNKI_CHSE_CD " + "\n");
		super.sql.append("	  ,OLD_KNU_AMT_TUTI_UM_FLG " + "\n");
		super.sql.append("	  ,NEW_ITN_YUKEI_SKK_HOHO_CD " + "\n");
		super.sql.append("	  ,NEW_ITN_MUKEI_SKK_HOHO_CD " + "\n");
		super.sql.append("	  ,NEW_ITNGI_YUKEI_SKK_HOHO_CD " + "\n");
		super.sql.append("	  ,NEW_ITNGI_MUKEI_SKK_HOHO_CD " + "\n");
		super.sql.append("	  ,NEW_MBRI_ABRI_KBN " + "\n");
		super.sql.append("	  ,NEW_RSK_CLC_HOHO_CD " + "\n");
		super.sql.append("	  ,NEW_FKN_TNKI_HOHO_CD " + "\n");
		super.sql.append("	  ,NEW_IJI_KNRI_HYO_JYO_KBN " + "\n");
		super.sql.append("	  ,NEW_EKM_TEIK_HYO_JYO_KBN " + "\n");
		super.sql.append("	  ,NEW_GNKSK_HASU_CHSE_CD " + "\n");
		super.sql.append("	  ,NEW_FKN_TNKI_CHSE_CD " + "\n");
		super.sql.append("	  ,NEW_KNU_AMT_TUTI_UM_FLG " + "\n");
		super.sql.append("	  ,SYOSU_KETASU " + "\n");
		super.sql.append("	  ,PDF_COMPANY_NM " + "\n");
		super.sql.append("	  ,PDF_COMPANY_ZIP1 " + "\n");
		super.sql.append("	  ,PDF_COMPANY_ZIP2 " + "\n");
		super.sql.append("	  ,PDF_COMPANY_ADR1 " + "\n");
		super.sql.append("	  ,PDF_COMPANY_ADR2 " + "\n");
		super.sql.append("	  ,PDF_COMPANY_TELNO " + "\n");
		super.sql.append("	  ,OLD_SRT_KEI_JGI_FLG " + "\n");
		super.sql.append("	  ,OLD_RLS_KEI_JGI_FLG " + "\n");
		super.sql.append("	  ,OLD_SGK_KEI_JGI_FLG " + "\n");
		super.sql.append("	  ,OLD_CYT_KAI_JGI_FLG " + "\n");
		super.sql.append("	  ,NEW_SRT_KEI_JGI_FLG " + "\n");
		super.sql.append("	  ,NEW_RLS_KEI_JGI_FLG " + "\n");
		super.sql.append("	  ,NEW_SGK_KEI_JGI_FLG " + "\n");
		super.sql.append("	  ,NEW_CYT_KAI_JGI_FLG " + "\n");
		super.sql.append("	  ,OLD_SUM_UNT " + "\n");
		super.sql.append("	  ,NEW_SUM_UNT " + "\n");
		
		//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/21 start
		super.sql.append("	  ,BATCH_PRINT_TIMING_CD " + "\n");
		super.sql.append("	  ,LC_TNT_CD " + "\n");
		super.sql.append("	  ,LC_TNT_NM " + "\n");
		super.sql.append("	  ,LC_SHZK_SHO " + "\n");
		super.sql.append("	  ,LC_SHZK_BU " + "\n");
		super.sql.append("	  ,LC_SHZK_GRP " + "\n");
		super.sql.append("	  ,LC_SHZK_NM " + "\n");
		//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 end
		
		super.sql.append("FROM   M_LU " + "\n");
		super.sql.append("WHERE  LU_COSMOS_CD = '" + Command.changeQt(this.cosmosCode) + "' " + "\n");
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
	 * COSMOSコードを取得.
	 * 
	 * @return COSMOSコード
	 */
	public String getUserCosmosCode() {
		return super.getString("LU_COSMOS_CD");
	}

	/**
	 * リースユーザー名称を取得.
	 * 
	 * @return リースユーザー名称
	 */
	public String getUserName() {
		return super.getString("LU_NM");
	}

	/**
	 * リースユーザー郵便番号１を取得.
	 * 
	 * @return リースユーザー郵便番号１
	 */
	public String getUserZip1() {
		return super.getString("LU_ZIP1", "");
	}

	/**
	 * リースユーザー郵便番号２を取得.
	 * 
	 * @return リースユーザー郵便番号２
	 */
	public String getUserZip2() {
		return super.getString("LU_ZIP2", "");
	}

	/**
	 * リースユーザー住所１を取得.
	 * 
	 * @return リースユーザー住所１
	 */
	public String getUserAddress1() {
		return super.getString("LU_ADR1", "");
	}

	/**
	 * リースユーザー住所２を取得.
	 * 
	 * @return リースユーザー住所２
	 */
	public String getUserAddress2() {
		return super.getString("LU_ADR2", "");
	}

	/**
	 * リースユーザー電話番号を取得.
	 * 
	 * @return リースユーザー電話番号
	 */
	public String getUserTelNo() {

		return super.getString("LU_TELNO", "");

	}

	/**
	 * リースユーザー担当者名を取得.
	 * 
	 * @return リースユーザー担当者名
	 */
	public String getUserTantoName() {

		return super.getString("LU_TNT_NM", "");

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
	 * 会計処理区分を取得.
	 * 
	 * @return 会計処理区分
	 */
	public String getACShrKbn() {
		return super.getString("AC_SHR_KBN");
	}

	/**
	 * 決算期を取得.
	 * 
	 * @return 決算期
	 */
	public String getKesnKi() {
		return super.getString("KESN_KI");
	}

	/**
	 * 月次帳票-短期契約除外フラグを取得.
	 * 
	 * @return 月次帳票-短期契約除外フラグ
	 */
	public String getGtjSrtKeiJgiFlg() {
		return super.getString("GTJ_SRT_KEI_JGI_FLG");
	}

	/**
	 * 月次帳票-再リース契約除外フラグを取得.
	 * 
	 * @return 月次帳票-再リース契約除外フラグ
	 */
	public String getGtjRlsKeiJgiFlg() {
		return super.getString("GTJ_RLS_KEI_JGI_FLG");
	}

	/**
	 * 月次帳票-少額契約除外フラグを取得.
	 * 
	 * @return 月次帳票-少額契約除外フラグ
	 */
	public String getGtjSgkKeiJgiFlg() {
		return super.getString("GTJ_SGK_KEI_JGI_FLG");
	}

	/**
	 * 月次帳票-中途解約除外フラグを取得.
	 * 
	 * @return 月次帳票-中途解約除外フラグ
	 */
	public String getGtjCytKaiJgiFlg() {
		return super.getString("GTJ_CYT_KAI_JGI_FLG");
	}

	/**
	 * オンラインDBデータソース名を取得.
	 * 
	 * @return オンラインDBデータソース名
	 */
	public String getDataSource() {
		return super.getString("WEB_DB_DATA_SRC");
	}

	/**
	 * 旧会計基準-所有権移転有形償却方法コードを取得.
	 * 
	 * @return 旧会計基準-所有権移転有形償却方法コード
	 */
	public String getOldItenYukeiSkkHohoCd() {
		return super.getString("OLD_ITN_YUKEI_SKK_HOHO_CD");
	}

	/**
	 * 旧会計基準-所有権移転無形償却方法コードを取得.
	 * 
	 * @return 旧会計基準-所有権移転無形償却方法コード
	 */
	public String getOldItenMukeiSkkHohoCd() {
		return super.getString("OLD_ITN_MUKEI_SKK_HOHO_CD");
	}

	/**
	 * 旧会計基準-所有権移転外有形償却方法コードを取得.
	 * 
	 * @return 旧会計基準-所有権移転外有形償却方法コード
	 */
	public String getOldItengiYukeiSkkHohoCd() {
		return super.getString("OLD_ITNGI_YUKEI_SKK_HOHO_CD");
	}

	/**
	 * 旧会計基準-所有権移転外無形償却方法コードを取得.
	 * 
	 * @return 旧会計基準-所有権移転外無形償却方法コード
	 */
	public String getOldItengiMukeiSkkHohoCd() {
		return super.getString("OLD_ITNGI_MUKEI_SKK_HOHO_CD");
	}

	/**
	 * 旧会計基準-前払後払区分を取得.
	 * 
	 * @return 旧会計基準-前払後払区分
	 */
	public String getOldMbriAbriKbn() {
		return super.getString("OLD_MBRI_ABRI_KBN");
	}

	/**
	 * 旧会計基準-利息計算方法コードを取得.
	 * 
	 * @return 旧会計基準-利息計算方法コード
	 */
	public String getOldRskClcHohoCd() {
		return super.getString("OLD_RSK_CLC_HOHO_CD");
	}

	/**
	 * 旧会計基準-賦金展開方法コードを取得.
	 * 
	 * @return 旧会計基準-賦金展開方法コード
	 */
	public String getOldFknTnkiHohoCd() {
		return super.getString("OLD_FKN_TNKI_HOHO_CD");
	}

	/**
	 * 旧会計基準-維持管理費重要性区分を取得.
	 * 
	 * @return 旧会計基準-維持管理費重要性区分
	 */
	public String getOldIjiKnriHyoJyoKbn() {
		return super.getString("OLD_IJI_KNRI_HYO_JYO_KBN");
	}

	/**
	 * 旧会計基準-役務提供費用重要性区分を取得.
	 * 
	 * @return 旧会計基準-役務提供費用重要性区分
	 */
	public String getOldEkmTeikHyoJyoKbn() {
		return super.getString("OLD_EKM_TEIK_HYO_JYO_KBN");
	}

	/**
	 * 旧会計基準-減価償却端数調整コードを取得.
	 * 
	 * @return 旧会計基準-減価償却端数調整コード
	 */
	public String getOldGnkskHasuChseCd() {
		return super.getString("OLD_GNKSK_HASU_CHSE_CD");
	}

	/**
	 * 旧会計基準-賦金展開調整コードを取得.
	 * 
	 * @return 旧会計基準-賦金展開調整コード
	 */
	public String getOldFknTnkiHasuChseCd() {
		return super.getString("OLD_FKN_TNKI_CHSE_CD");
	}

	/**
	 * 旧会計基準-購入額通知有無フラグを取得.
	 * 
	 * @return 旧会計基準-購入額通知有無フラグ
	 */
	public String getOldKnuAmtTutiUmFlg() {
		return super.getString("OLD_KNU_AMT_TUTI_UM_FLG");
	}

	/**
	 * 新会計基準-所有権移転有形償却方法コードを取得.
	 * 
	 * @return 新会計基準-所有権移転有形償却方法コード
	 */
	public String getNewItenYukeiSkkHohoCd() {
		return super.getString("NEW_ITN_YUKEI_SKK_HOHO_CD");
	}

	/**
	 * 新会計基準-所有権移転無形償却方法コードを取得.
	 * 
	 * @return 新会計基準-所有権移転無形償却方法コード
	 */
	public String getNewItenMukeiSkkHohoCd() {
		return super.getString("NEW_ITN_MUKEI_SKK_HOHO_CD");
	}

	/**
	 * 新会計基準-所有権移転外有形償却方法コードを取得.
	 * 
	 * @return 新会計基準-所有権移転外有形償却方法コード
	 */
	public String getNewItengiYukeiSkkHohoCd() {
		return super.getString("NEW_ITNGI_YUKEI_SKK_HOHO_CD");
	}

	/**
	 * 新会計基準-所有権移転外無形償却方法コードを取得.
	 * 
	 * @return 新会計基準-所有権移転外無形償却方法コード
	 */
	public String getNewItengiMukeiSkkHohoCd() {
		return super.getString("NEW_ITNGI_MUKEI_SKK_HOHO_CD");
	}

	/**
	 * 新会計基準-前払後払区分を取得.
	 * 
	 * @return 新会計基準-前払後払区分
	 */
	public String getNewMbriAbriKbn() {
		return super.getString("NEW_MBRI_ABRI_KBN");
	}

	/**
	 * 新会計基準-利息計算方法コードを取得.
	 * 
	 * @return 新会計基準-利息計算方法コード
	 */
	public String getNewRskClcHohoCd() {
		return super.getString("NEW_RSK_CLC_HOHO_CD");
	}

	/**
	 * 新会計基準-賦金展開方法コードを取得.
	 * 
	 * @return 新会計基準-賦金展開方法コード
	 */
	public String getNewFknTnkiHohoCd() {
		return super.getString("NEW_FKN_TNKI_HOHO_CD");
	}

	/**
	 * 新会計基準-維持管理費重要性区分を取得.
	 * 
	 * @return 新会計基準-維持管理費重要性区分
	 */
	public String getNewIjiKnriHyoJyoKbn() {
		return super.getString("NEW_IJI_KNRI_HYO_JYO_KBN");
	}

	/**
	 * 新会計基準-役務提供費用重要性区分を取得.
	 * 
	 * @return 新会計基準-役務提供費用重要性区分
	 */
	public String getNewEkmTeikHyoJyoKbn() {
		return super.getString("NEW_EKM_TEIK_HYO_JYO_KBN");
	}

	/**
	 * 新会計基準-減価償却端数調整コードを取得.
	 * 
	 * @return 新会計基準-減価償却端数調整コード
	 */
	public String getNewGnkskHasuChseCd() {
		return super.getString("NEW_GNKSK_HASU_CHSE_CD");
	}

	/**
	 * 新会計基準-賦金展開調整コードを取得.
	 * 
	 * @return 新会計基準-賦金展開調整コード
	 */
	public String getNewFknTnkiHasuChseCd() {
		return super.getString("NEW_FKN_TNKI_CHSE_CD");
	}

	/**
	 * 新会計基準-購入額通知有無フラグを取得.
	 * 
	 * @return 新会計基準-購入額通知有無フラグ
	 */
	public String getNewKnuAmtTutiUmFlg() {
		return super.getString("NEW_KNU_AMT_TUTI_UM_FLG");
	}

	/**
	 * 新会計基準-購入額通知有無フラグを取得.
	 * 
	 * @return 新会計基準-購入額通知有無フラグ
	 */
	public int getSyosuKetasu() {
		return super.getInt("SYOSU_KETASU");
	}

	/**
	 * 帳票表示リース会社を取得.
	 * 
	 * @return 帳票表示リース会社
	 */
	public String getPdfCompanyName() {
		return super.getString("PDF_COMPANY_NM", "");
	}

	/**
	 * 帳票表示郵便番号１を取得.
	 * 
	 * @return 帳票表示郵便番号１
	 */
	public String getPdfCompanyZip1() {
		return super.getString("PDF_COMPANY_ZIP1", "");
	}

	/**
	 * 帳票表示郵便番号２を取得.
	 * 
	 * @return 帳票表示郵便番号２
	 */
	public String getPdfCompanyZip2() {
		return super.getString("PDF_COMPANY_ZIP2", "");
	}

	/**
	 * 帳票表示住所１を取得.
	 * 
	 * @return 帳票表示住所１
	 */
	public String getPdfCompanyAddress1() {
		return super.getString("PDF_COMPANY_ADR1", "");
	}

	/**
	 * 帳票表示住所２を取得.
	 * 
	 * @return 帳票表示住所２
	 */
	public String getPdfCompanyAddress2() {
		return super.getString("PDF_COMPANY_ADR2", "");
	}

	/**
	 * 帳票表示電話番号を取得.
	 * 
	 * @return 帳票表示電話番号
	 */
	public String getPdfCompanyTel() {
		return super.getString("PDF_COMPANY_TELNO", "");
	}

	/**
	 * 旧会計基準-短期契約除外フラグを取得.
	 * 
	 * @return 旧会計基準-短期契約除外フラグ
	 */
	public String getOldSrtKeiJgiFlg() {
		return super.getString("OLD_SRT_KEI_JGI_FLG");
	}

	/**
	 * 旧会計基準-再リース契約除外フラグを取得.
	 * 
	 * @return 旧会計基準-再リース契約除外フラグ
	 */
	public String getOldRlsKeiJgiFlg() {
		return super.getString("OLD_RLS_KEI_JGI_FLG");
	}

	/**
	 * 旧会計基準-少額契約除外フラグを取得.
	 * 
	 * @return 旧会計基準-少額契約除外フラグ
	 */
	public String getOldSgkKeiJgiFlg() {
		return super.getString("OLD_SGK_KEI_JGI_FLG");
	}

	/**
	 * 旧会計基準-中途解約除外フラグを取得.
	 * 
	 * @return 旧会計基準-中途解約除外フラグ
	 */
	public String getOldCytKaiJgiFlg() {
		return super.getString("OLD_CYT_KAI_JGI_FLG");
	}

	/**
	 * 新会計基準-短期契約除外フラグを取得.
	 * 
	 * @return 新会計基準-短期契約除外フラグ
	 */
	public String getNewSrtKeiJgiFlg() {
		return super.getString("NEW_SRT_KEI_JGI_FLG");
	}

	/**
	 * 新会計基準-再リース契約除外フラグを取得.
	 * 
	 * @return 新会計基準-再リース契約除外フラグ
	 */
	public String getNewRlsKeiJgiFlg() {
		return super.getString("NEW_RLS_KEI_JGI_FLG");
	}

	/**
	 * 新会計基準-少額契約除外フラグを取得.
	 * 
	 * @return 新会計基準-少額契約除外フラグ
	 */
	public String getNewSgkKeiJgiFlg() {
		return super.getString("NEW_SGK_KEI_JGI_FLG");
	}

	/**
	 * 新会計基準-中途解約除外フラグを取得.
	 * 
	 * @return 新会計基準-中途解約除外フラグ
	 */
	public String getNewCytKaiJgiFlg() {
		return super.getString("NEW_CYT_KAI_JGI_FLG");
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
	
	//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 start
	/**
	 * 出力タイミングを取得.
	 * 
	 * @return 出力タイミング
	 */
	public String getBatchPrintTimingCd() {
		return super.getString("BATCH_PRINT_TIMING_CD");
	}
	
	/**
	 * リース会社部署 所コードを取得.
	 * 
	 * @return リース会社部署 所コード
	 */
	public String getLcShzkSho() {
		return super.getString("LC_SHZK_SHO", "");
	}
	
	/**
	 * リース会社部署 部コードを取得.
	 * 
	 * @return リース会社部署 部コード
	 */
	public String getLcShzkBu() {
		return super.getString("LC_SHZK_BU", "");
	}
	
	/**
	 * リース会社部署 グループコードを取得.
	 * 
	 * @return リース会社部署 グループコード
	 */
	public String getLcShzkGrp() {
		return super.getString("LC_SHZK_GRP", "");
	}
	
	/**
	 * リース会社部署名称単位を取得.
	 * 
	 * @return リース会社部署名称単位
	 */
	public String getLcShzkNm() {
		return super.getString("LC_SHZK_NM", "");
	}
	
	/**
	 * リース会社担当者コードを取得.
	 * 
	 * @return リース会社担当者コード
	 */
	public String getLcTntCd() {
		return super.getString("LC_TNT_CD", "");
	}
	
	/**
	 * リース会社担当者名を取得.
	 * 
	 * @return リース会社担当者名
	 */
	public String getLcTntNm() {
		return super.getString("LC_TNT_NM", "");
	}
	//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 end

}
