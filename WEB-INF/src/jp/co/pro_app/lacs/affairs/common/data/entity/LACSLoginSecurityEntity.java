package jp.co.pro_app.lacs.affairs.common.data.entity;

import java.util.Date;

import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * セキュリティチェックエンティティ.
 * 
 * @author Katoken
 * @version 20080916
 */
public class LACSLoginSecurityEntity extends EntityBase {

	private String	userId	= "";

	/**
	 * SQL生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT NVL(LST_ACS_DTM, TO_DATE('19000101', 'YYYYMMDD')) LST_ACS_DTM " + "\n");
		super.sql.append("      ,(SELECT SSN_TIME_OUT FROM M_LC) SSN_TIME_OUT " + "\n");
		super.sql.append("      ,ONE_TIM_PSWD " + "\n");
		super.sql.append("FROM   T_RQST_CTL_TBL " + "\n");
		super.sql.append("WHERE  LU_ID = '" + Command.changeQt(userId) + "' " + " \n");
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            DB接続モデル
	 */
	public LACSLoginSecurityEntity(DBModelBase piModel) {
		super(piModel);
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
	 * 最終アクセス日時を取得.
	 * 
	 * @return 最終アクセス日時
	 */
	public Date getLastAccessDateTime() {
		return super.getDateTime("LST_ACS_DTM");
	}

	/**
	 * セッションタイムアウト時間を取得.
	 * 
	 * @return セッションタイムアウト時間
	 */
	public int getSessionTimeOut() {
		return super.getInt("SSN_TIME_OUT");
	}

	/**
	 * ワンタイムパスワードを取得.
	 * 
	 * @return ワンタイムパスワード
	 */
	public String getOneTimePassword() {
		return super.getString("ONE_TIM_PSWD");
	}
}
