package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リースユーザーEntity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSFixedUserInfoEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSFixedUserInfoEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	companyCode	= "";	// リース会社コード

	private String	userId		= "";	// ユーザーID

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT LU.LU_COSMOS_CD " + "\n");
		super.sql.append("	  ,LU.LU_NM " + "\n");
		super.sql.append("	  ,LU.SRKI_WRKI_CD " + "\n");
		super.sql.append("	  ,LC.LATE_DATA_TEIK_YM " + "\n");
		super.sql.append("FROM   M_LU LU  " + "\n");
		super.sql.append("JOIN   M_LC_BETU_LU LC ON LC.LU_COSMOS_CD = LU.LU_COSMOS_CD " + "\n");
		super.sql.append("JOIN   M_LU_TNT_BETU_USER TNT ON LU.LU_COSMOS_CD = TNT.LU_COSMOS_CD " + "\n");

		super.sql.append("WHERE  LC.LC_CD = '" + companyCode + "' " + "\n");
		super.sql.append("AND    TNT.LU_ID = '" + userId + "' " + "\n");

	}

	/**
	 * リース会社コードを設定.
	 * 
	 * @param piCompanyCode
	 *            リース会社コード
	 */
	public void setCompanyCode(String piCompanyCode) {
		this.companyCode = piCompanyCode;
	}

	/**
	 * ユーザーIDを設定.
	 * 
	 * @param piUserId
	 *            ユーザーID
	 */
	public void setUserId(String piUserId) {
		this.userId = piUserId;
	}

	/**
	 * COSMOSコードを取得.
	 * 
	 * @return COSMOSコード
	 */
	public String getCOSMOSCode() {
		return super.getString("LU_COSMOS_CD");
	}

	/**
	 * お客様名を取得.
	 * 
	 * @return お客様名
	 */
	public String getUserName() {
		return super.getString("LU_NM");
	}

	/**
	 * 西暦和暦区分を取得.
	 * 
	 * @return 西暦和暦区分
	 */
	public String getSeirekiWarekiCode() {
		return super.getString("SRKI_WRKI_CD");
	}

	/**
	 * 西暦和暦区分を取得.
	 * 
	 * @return 西暦和暦区分
	 */
	public String getDBDataSource() {
		return super.getString("WEB_DB_DATA_SRC");
	}

	/**
	 * 西暦和暦区分を取得.
	 * 
	 * @return 西暦和暦区分
	 */
	public String getDBUserId() {
		return super.getString("WEB_DB_ID");
	}

	/**
	 * 西暦和暦区分を取得.
	 * 
	 * @return 西暦和暦区分
	 */
	public String getDBPassword() {
		return super.getString("WEB_DB_PASSWD");
	}

	/**
	 * データ提供月を取得.
	 * 
	 * @return データ提供月.
	 */
	public String getLateDateTeikyoYM() {
		return super.getString("LATE_DATA_TEIK_YM");
	}

}
