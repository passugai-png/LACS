package jp.co.pro_app.lacs.affairs.userlist.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リースユーザーマスタ一覧Entity.
 * 
 * @author active
 * @version 20071210
 */
public class LACSUserListEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSUserListEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	cosmosCode	= "";	// COSMOSコード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT LU_COSMOS_CD " + "\n"); // COSMOSコード
		super.sql.append("      ,LU_NM " + "\n"); // リースユーザー名称
		super.sql.append("      ,LU_ADR1 || ' ' || LU_ADR2 LU_ADR " + "\n"); // リースユーザー住所
		super.sql.append("      ,LU_TELNO " + "\n"); // リースユーザー電話番号
		super.sql.append("      ,LU_TNT_NM " + "\n"); // リースユーザー担当者名
		super.sql.append("FROM   M_LU " + "\n");
		if (this.cosmosCode.trim().length() > 0) {
			super.sql.append("WHERE  LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
		}
		super.sql.append("ORDER BY LU_COSMOS_CD " + "\n");

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
	public String getCosmosCode() {
		String retStr = super.getString("LU_COSMOS_CD");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * リースユーザー名称を取得.
	 * 
	 * @return リースユーザー名称
	 */
	public String getName() {
		String retStr = super.getString("LU_NM");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * リースユーザー住所を取得.
	 * 
	 * @return リースユーザー住所
	 */
	public String getAddress() {
		String retStr = super.getString("LU_ADR");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * リースユーザー電話番号を取得.
	 * 
	 * @return リースユーザー電話番号
	 */
	public String getTel() {
		String retStr = super.getString("LU_TELNO");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * リースユーザー担当者名を取得.
	 * 
	 * @return リースユーザー担当者名
	 */
	public String getTanto() {
		String retStr = super.getString("LU_TNT_NM");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 所有権移転有形償却方法コードを取得.
	 * 
	 * @return 所有権移転有形償却方法コード
	 */
	public String getItenYukei() {
		String retStr = super.getString("SYUKN_ITN_YUKEI_SKK_HOHO_CD");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 所有権移転無形償却方法コードを取得.
	 * 
	 * @return 所有権移転無形償却方法コード
	 */
	public String getItenMukei() {
		String retStr = super.getString("SYUKN_ITN_MUKEI_SKK_HOHO_CD");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 所有権移転外有形償却方法コードを取得.
	 * 
	 * @return 所有権移転外有形償却方法コード
	 */
	public String getItenGaiYukei() {
		String retStr = super.getString("SYUKN_ITNGI_YUKEI_SKK_HOHO_CD");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 所有権移転外無形償却方法コードを取得.
	 * 
	 * @return 所有権移転外無形償却方法コード
	 */
	public String getItenGaiMukei() {
		String retStr = super.getString("SYUKN_ITNGI_MUKEI_SKK_HOHO_CD");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 所有権移転外利息計算方法コードを取得.
	 * 
	 * @return 所有権移転外利息計算方法コード
	 */
	public String getItenGaiRisoku() {
		String retStr = super.getString("SYUKN_ITNGI_RSK_CLC_HOHO_CD");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 注記簡便法採用表示を取得.
	 * 
	 * @return 注記簡便法採用表示
	 */
	public String getTyukiSaiyo() {
		String retStr = super.getString("AC_SHR_KBN");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 前払後払区分を取得.
	 * 
	 * @return 前払後払区分
	 */
	public String getMaeAtoHarai() {
		String retStr = super.getString("MBRI_ABRI_KBN");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 決算期FROMを取得.
	 * 
	 * @return 決算期FROM
	 */
	public String getKessanFrom() {
		String retStr = super.getString("KESN_KI_FROM");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 決算期TOを取得.
	 * 
	 * @return 決算期TO
	 */
	public String getKessanTo() {
		String retStr = super.getString("KESN_KI_TO");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 決算月１を取得.
	 * 
	 * @return 決算月１
	 */
	public String getKessanMonth1() {
		String retStr = super.getString("KESN_MM_1");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 決算月２を取得.
	 * 
	 * @return 決算月２
	 */
	public String getKessanMonth2() {
		String retStr = super.getString("KESN_MM_2");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 決算月３を取得.
	 * 
	 * @return 決算月３
	 */
	public String getKessanMonth3() {
		String retStr = super.getString("KESN_MM_3");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 決算月４を取得.
	 * 
	 * @return 決算月４
	 */
	public String getKessanMonth4() {
		String retStr = super.getString("KESN_MM_4");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 短期契約除外フラグを取得.
	 * 
	 * @return 短期契約除外フラグ
	 */
	public String getTankiKeiyaku() {
		String retStr = super.getString("SRT_KEI_JGI_FLG");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 再リース契約除外フラグを取得.
	 * 
	 * @return 再リース契約除外フラグ
	 */
	public String getSaiLease() {
		String retStr = super.getString("RLS_KEI_JGI_FLG");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 少額契約除外フラグを取得.
	 * 
	 * @return 少額契約除外フラグ
	 */
	public String getSyougakuKeiyaku() {
		String retStr = super.getString("SGK_KEI_JGI_FLG");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 判定単位フラグを取得.
	 * 
	 * @return 判定単位フラグ
	 */
	public String getHanteiTani() {
		String retStr = super.getString("HNTE_UNT_FLG");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 西暦和暦コードを取得.
	 * 
	 * @return 西暦和暦コード
	 */
	public String getReki() {
		String retStr = super.getString("SRKI_WRKI_CD");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 賦金展開調整コードを取得.
	 * 
	 * @return 賦金展開調整コード
	 */
	public String getFukinTyosei() {
		String retStr = super.getString("FKN_TNKI_CHSE_CD");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 減価償却端数調整コードを取得.
	 * 
	 * @return 減価償却端数調整コード
	 */
	public String getGenkaTyosei() {
		String retStr = super.getString("GNKSK_HASU_CHSE_CD");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 賦金展開方法コードを取得.
	 * 
	 * @return 賦金展開方法コード
	 */
	public String getFukinHouhou() {
		String retStr = super.getString("FKN_TNKI_HOHO_CD");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 購入額通知有無フラグを取得.
	 * 
	 * @return 購入額通知有無フラグ
	 */
	public String getKounyuGaku() {
		String retStr = super.getString("KNU_AMT_TUTI_UM_FLG");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 検索キー１表示名を取得.
	 * 
	 * @return 検索キー１表示名
	 */
	public String getKensakuKey1() {
		String retStr = super.getString("SEL_KEY_HJI_1");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 検索キー２表示名を取得.
	 * 
	 * @return 検索キー２表示名
	 */
	public String getKensakuKey2() {
		String retStr = super.getString("SEL_KEY_HJI_2");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 検索キー３表示名を取得.
	 * 
	 * @return 検索キー３表示名
	 */
	public String getKensakuKey3() {
		String retStr = super.getString("SEL_KEY_HJI_3");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 検索キー４表示名を取得.
	 * 
	 * @return 検索キー４表示名
	 */
	public String getKensakuKey4() {
		String retStr = super.getString("SEL_KEY_HJI_4");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 検索キー５表示名を取得.
	 * 
	 * @return 検索キー５表示名
	 */
	public String getKensakuKey5() {
		String retStr = super.getString("SEL_KEY_HJI_5");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * オンラインDBデータソース名を取得.
	 * 
	 * @return オンラインDBデータソース名
	 */
	public String getDataSource() {
		String retStr = super.getString("WEB_DB_DATA_SRC");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * オンラインDBユーザーIDを取得.
	 * 
	 * @return オンラインDBユーザーID
	 */
	public String getUserID() {
		String retStr = super.getString("WEB_DB_ID");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * オンラインDBパスワードを取得.
	 * 
	 * @return オンラインDBパスワード
	 */
	public String getPassword() {
		String retStr = super.getString("WEB_DB_PASSWD");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

}
