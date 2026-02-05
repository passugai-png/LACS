package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 担当者別開示先Entity.
 * 
 * @author katoken
 * @version 20090205
 */
public class LACSTantoUserEntity extends EntityBase {

	private String	userId	= "";

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSTantoUserEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT 1 " + "\n");
		super.sql.append("	  ,'" + LACSDefine.INFO_ALL + "' LU_COSMOS_CD " + "\n");
		super.sql.append("	  ,'全開示先' LU_NM " + "\n");
		super.sql.append("FROM   M_LU_TNT_BETU_USER TNT " + "\n");
		super.sql.append("WHERE  TNT.LU_ID = '" + this.userId + "' " + "\n");
		super.sql.append("AND    TNT.LU_COSMOS_CD = '" + LACSDefine.INFO_ALL + "' " + "\n");
		super.sql.append("UNION " + "\n");
		super.sql.append("SELECT 2 " + "\n");
		super.sql.append("	  ,LU.LU_COSMOS_CD " + "\n");
		super.sql.append("	  ,LU.LU_NM " + "\n");
		super.sql.append("FROM   M_LU_TNT_BETU_USER TNT " + "\n");
		super.sql.append("JOIN   M_LU LU ON TNT.LU_COSMOS_CD = LU.LU_COSMOS_CD " + "\n");
		super.sql.append("WHERE  TNT.LU_ID = '" + this.userId + "' " + "\n");
	}

	/**
	 * 開示先コードを取得.
	 * 
	 * @return 開示先コード
	 */
	public String getCosmosCode() {
		return super.getString("LU_COSMOS_CD");
	}

	/**
	 * 開示先名を取得.
	 * 
	 * @return 開示先名
	 */
	public String getUserName() {
		return super.getString("LU_NM");
	}

	/**
	 * 担当者IDを設定.
	 * 
	 * @param piUserId
	 *            担当者ID
	 */
	public void setUserId(String piUserId) {
		this.userId = piUserId;
	}

}
