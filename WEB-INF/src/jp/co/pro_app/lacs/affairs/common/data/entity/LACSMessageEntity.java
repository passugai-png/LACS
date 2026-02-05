package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * メッセージ取得Entity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSMessageEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSMessageEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	messageCode	= "";	// メッセージコード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT T.MSG " + "\n");
		super.sql.append("FROM   M_MSG T " + "\n");
		super.sql.append("WHERE  T.MSG_CD = '" + this.messageCode + "' " + "\n");
	}

	/**
	 * メッセージコードを設定.
	 * 
	 * @param piMessageCode
	 *            メッセージコード
	 */
	public void setMessageCode(String piMessageCode) {
		this.messageCode = piMessageCode;
	}

	/**
	 * メッセージを取得します.
	 * 
	 * @return メッセージ
	 */
	public String getMessage() {
		return super.getString("MSG");
	}
}
