package jp.co.pro_app.lacs.affairs.tantolist.data.entity;

import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リースユーザー担当者マスタ一覧Entity.
 * 
 * @author active
 * @version 20071210
 */
public class LACSTantoListEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSTantoListEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	userID		= "";	// ユーザーID

	private String	cosmosCode	= "";	// COSMOSコード

	private String	tantJti		= "";	// 担当者状態区分

	private String	userRight	= "";	// 利用者権限

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		StringBuffer where = new StringBuffer();

		super.whereSw = true;

		if (this.userID.trim().length() > 0) {
			where.append(super.getWhereAnd("TNT.LU_ID = '" + Command.changeQt(this.userID) + "' " + "\n"));
		}

		if (this.cosmosCode.trim().length() > 0) {
			where.append(super.getWhereAnd("BETU.LU_COSMOS_CD IN ('" + LACSDefine.INFO_ALL + "','" + Command.changeQt(this.cosmosCode) + "') " + "\n"));
		}

		if (this.tantJti.trim().length() > 0) {
			where.append(super.getWhereAnd("TNT.LU_TNT_JTI_KBN = '" + Command.changeQt(this.tantJti) + "' " + "\n"));
		}

		if (!this.userRight.equals("0")) {
			where.append(super.getWhereAnd("TNT.LU_RIGHT_KBN = '" + Command.changeQt(this.userRight) + "' " + "\n"));
		}

		super.sql.append("SELECT DISTINCT TNT.LU_ID " + "\n"); // ユーザーID
		super.sql.append("      ,TNT.LU_TNT_NM " + "\n"); // ユーザー名
		super.sql.append("      ,TNT.PASSWD_YUKO_TERM " + "\n"); // パスワード有効期限
		super.sql.append("      ,TNT.LU_TNT_JTI_KBN " + "\n"); // 担当者状態区分
		super.sql.append("      ,JTI.LU_TNT_JTI_NM " + "\n"); // 担当者状態区分名
		super.sql.append("      ,RIGHT.LU_RIGHT_KBN " + "\n"); // 利用者権限区分
		super.sql.append("      ,RIGHT.LU_RIGHT_NAME " + "\n"); // 利用者権限区分名称
		super.sql.append("FROM   V_LU_TNT TNT " + "\n");
		super.sql.append("JOIN   M_LU_TNT_JTI_KBN JTI " + "\n");
		super.sql.append("ON     TNT.LU_TNT_JTI_KBN = JTI.LU_TNT_JTI_KBN " + "\n");
		super.sql.append("JOIN   M_USER_RIGHT RIGHT " + "\n");
		super.sql.append("ON     TNT.LU_RIGHT_KBN = RIGHT.LU_RIGHT_KBN " + "\n");
		super.sql.append("JOIN   M_LU_TNT_BETU_USER BETU " + "\n");
		super.sql.append("ON     TNT.LU_ID = BETU.LU_ID " + "\n");
		super.sql.append(where);
		super.sql.append("ORDER BY TNT.LU_ID " + "\n");
	}

	/**
	 * ユーザーIDを設定.
	 * 
	 * @param piUserId
	 *            ユーザーID
	 */
	public void setUserId(String piUserId) {
		this.userID = piUserId;
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
	 * 担当者状態区分を設定.
	 * 
	 * @param piTantJti
	 *            担当者状態区分
	 */
	public void setTanJti(String piTantJti) {
		this.tantJti = piTantJti;
	}

	/**
	 * 利用者権限を設定.
	 * 
	 * @param piUserRight
	 *            利用者権限
	 */
	public void setUserRight(String piUserRight) {
		this.userRight = piUserRight;
	}

	/**
	 * ユーザーID.
	 * 
	 * @return ユーザーID
	 */
	public String getUserId() {
		return super.getString("LU_ID");
	}

	/**
	 * リースユーザー名称を取得.
	 * 
	 * @return リースユーザー名称
	 */
	public String getUserTantoName() {
		return super.getString("LU_TNT_NM", "");
	}

	/**
	 * 担当者状態区分を取得.
	 * 
	 * @return 担当者状態区分
	 */
	public String getTantJtiKbn() {
		return super.getString("LU_TNT_JTI_KBN", "");
	}

	/**
	 * 担当者状態区分名を取得.
	 * 
	 * @return 担当者状態区分名
	 */
	public String getTantJtiName() {
		return super.getString("LU_TNT_JTI_NM", "");
	}

	/**
	 * パスワード有効期限を取得.
	 * 
	 * @return パスワード有効期限
	 */
	public String getPasswordYukoTerm() {
		return super.getString("PASSWD_YUKO_TERM", "");
	}

	/**
	 * 利用者権限区分名称を取得.
	 * 
	 * @return 利用者権限区分名称
	 */
	public String getUserRight() {
		return super.getString("LU_RIGHT_KBN", "");
	}

	/**
	 * 利用者権限区分名称を取得.
	 * 
	 * @return 利用者権限区分名称
	 */
	public String getUserRightName() {
		return super.getString("LU_RIGHT_NAME", "");
	}
}
