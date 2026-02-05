package jp.co.pro_app.lacs.affairs.tanto.data.entity;

import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リースユーザーマスタEntity.
 * 
 * @author ohmura
 * @version 20070913
 */
public class LACSTantoEntity extends EntityBase {

	/**
	 * リースユーザーマスタ コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSTantoEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	userId	= "";	// ユーザーID

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT TNT.LU_TNT_PASSWD " + "\n"); // パスワード
		super.sql.append("      ,TNT.LU_TNT_NM " + "\n"); // ユーザー名
		super.sql.append("      ,TNT.KRI_PASS_FLG " + "\n"); // 仮発行フラグ
		super.sql.append("      ,NVL(LC.KRI_PASSWD_YUKO_TERM, 0) KRI_PASSWD_YUKO_TERM" + "\n"); // 仮パスワード有効期間
		super.sql.append("      ,NVL(LC.HON_PASSWD_YUKO_TERM, 0) HON_PASSWD_YUKO_TERM" + "\n"); // 本パスワード有効期間
		super.sql.append("      ,LC.PASS_MIN " + "\n"); // パスワード文字の下限
		super.sql.append("      ,LC.PASS_MAX " + "\n"); // パスワード文字の上限
		super.sql.append("FROM   M_LU_TNT TNT " + "\n");
		super.sql.append("      ,M_LC LC " + "\n");
		super.sql.append("WHERE  TNT.LU_ID = '" + Command.changeQt(this.userId) + "' " + "\n");
		super.sql.append("AND    LC.LC_CD = '" + LACSDefine.LC_CD + "' " + "\n");
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
	 * パスワードを取得.
	 * 
	 * @return パスワード
	 */
	public String getPassword() {
		return super.getString("LU_TNT_PASSWD");
	}

	/**
	 * リースユーザー名称を取得.
	 * 
	 * @return リースユーザー名称
	 */
	public String getUserTantoName() {
		return super.getString("LU_TNT_NM");
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
	 * 仮発行フラグを取得.
	 * 
	 * @return 仮発行フラグ
	 */
	public String getKriPassFlg() {
		return super.getString("KRI_PASS_FLG");
	}

	/**
	 * 仮パスワード有効期間を取得.
	 * 
	 * @return 仮パスワード有効期間
	 */
	public String getKriPasswordYukoTerm() {
		return super.getString("KRI_PASSWD_YUKO_TERM");
	}

	/**
	 * 本パスワード有効期間を取得.
	 * 
	 * @return 本パスワード有効期間
	 */
	public String getHonPasswordYukoTerm() {
		return super.getString("HON_PASSWD_YUKO_TERM");
	}

	/**
	 * パスワード文字の下限を取得.
	 * 
	 * @return パスワード文字の下限
	 */
	public String getMinLength() {
		return super.getString("PASS_MIN");
	}

	/**
	 * パスワード文字の上限を取得.
	 * 
	 * @return パスワード文字の上限
	 */
	public String getMaxLength() {
		return super.getString("PASS_MAX");
	}
}
