package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リースユーザーEntity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSUserInfoEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSUserInfoEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	id	= "";	// お客様ID

	private String	pw	= "";	// パスワード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT TNT.LU_COSMOS_CD " + "\n");
		super.sql.append("	  ,LU.LU_NM " + "\n");
		super.sql.append("	  ,LU.SRKI_WRKI_CD " + "\n");
		super.sql.append("	  ,LU.WEB_DB_DATA_SRC " + "\n");
		super.sql.append("	  ,LU.WEB_DB_ID " + "\n");
		super.sql.append("	  ,LU.WEB_DB_PASSWD " + "\n");
		super.sql.append("	  ,MAX(LC.LATE_DATA_TEIK_YM) LATE_DATA_TEIK_YM " + "\n");
		super.sql.append("FROM   M_LU_TNT TNT " + "\n");
		super.sql.append("JOIN   M_LU LU ON TNT.LU_COSMOS_CD = LU.LU_COSMOS_CD " + "\n");
		super.sql.append("JOIN   M_LC_BETU_LU LC ON LC.LU_COSMOS_CD = LU.LU_COSMOS_CD " + "\n");
		super.sql.append("WHERE  TNT.LU_ID = '" + id + "' " + "\n");
		super.sql.append("AND    TNT.LU_PASSWD = '" + pw + "' " + "\n");
		super.sql.append("GROUP  BY TNT.LU_COSMOS_CD " + "\n");
		super.sql.append("		 ,LU.LU_NM " + "\n");
		super.sql.append("		 ,LU.SRKI_WRKI_CD " + "\n");
		super.sql.append("		 ,LU.WEB_DB_DATA_SRC " + "\n");
		super.sql.append("		 ,LU.WEB_DB_ID " + "\n");
		super.sql.append("		 ,LU.WEB_DB_PASSWD " + "\n");
	}

	/**
	 * お客様IDを設定.
	 * 
	 * @param piId
	 *            お客様ID
	 */
	public void setId(String piId) {
		this.id = piId;
	}

	/**
	 * パスワードを設定.
	 * 
	 * @param piPw
	 *            パスワード
	 */
	public void setPw(String piPw) {
		this.pw = piPw;
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
