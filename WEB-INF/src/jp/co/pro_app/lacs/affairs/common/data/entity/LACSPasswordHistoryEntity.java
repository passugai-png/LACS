package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * パスワード履歴Entity.
 * 
 * @author takeda
 * @version 20070911
 */
public class LACSPasswordHistoryEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSPasswordHistoryEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	userId	= "";

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT T.CHG_DTM " + "\n");
		super.sql.append("      ,T.LU_PASSWD " + "\n");
		super.sql.append("FROM   T_LU_PASSWORD_RRK T " + "\n");
		super.sql.append("WHERE  T.LU_ID = '" + Command.changeQt(userId) + "' " + "\n");
		super.sql.append("ORDER  BY T.CHG_DTM DESC " + "\n");
	}

	/**
	 * ユーザIDを設定.
	 * 
	 * @param piUserId
	 *            ユーザID
	 */
	public void setUserId(String piUserId) {
		this.userId = piUserId;
	}

	/**
	 * パスワード変更日時を取得.
	 * 
	 * @return パスワード変更日時
	 */
	public String getChangeTime() {
		return super.getString("CHG_DTM");
	}

	/**
	 * パスワードを取得.
	 * 
	 * @return パスワード
	 */
	public String getPassword() {
		return super.getString("LU_PASSWD");
	}
}
