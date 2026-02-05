package jp.co.pro_app.lacs.affairs.login.data.entity;

import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リースユーザー担当者Entity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSUserTantoEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSUserTantoEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	userId	= "";

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT LU_ID " + "\n");
		super.sql.append("      ,LU_TNT_PASSWD " + "\n");
		super.sql.append("      ,LU_TNT_NM " + "\n");
		super.sql.append("      ,PASSWD_YUKO_TERM " + "\n");
		super.sql.append("      ,KRI_PASS_FLG " + "\n");
		super.sql.append("      ,MISS_CNT " + "\n");
		super.sql.append("      ,LU_TNT_JTI_KBN " + "\n");
		super.sql.append("      ,LU_RIGHT_KBN " + "\n");
		super.sql.append("FROM   V_LU_TNT " + "\n");
		super.sql.append("WHERE  LU_ID = '" + Command.changeQt(this.userId) + "' " + "\n");
	}

	/**
	 * お客様IDを設定.
	 * 
	 * @param piUserId
	 *            お客様ID
	 */
	public void setUserId(String piUserId) {
		this.userId = piUserId;
	}

	/**
	 * 担当者名を取得.
	 * 
	 * @return 担当者名
	 */
	public String getTantoName() {
		return super.getString("LU_TNT_NM", "");
	}

	/**
	 * パスワードを取得.
	 * 
	 * @return パスワード
	 */
	public String getPassword() {
		return super.getString("LU_TNT_PASSWD");
	}

	/**
	 * 状態を取得.
	 * 
	 * @return 状態
	 */
	public String getStatus() {
		return super.getString("LU_TNT_JTI_KBN");
	}

	/**
	 * 状態を取得.
	 * 
	 * @return 状態
	 */
	public String getUserRight() {
		return super.getString("LU_RIGHT_KBN");
	}

	/**
	 * ミス回数を取得.
	 * 
	 * @return ミス回数
	 */
	public int getMissCount() {
		return super.getInt("MISS_CNT");
	}
}
