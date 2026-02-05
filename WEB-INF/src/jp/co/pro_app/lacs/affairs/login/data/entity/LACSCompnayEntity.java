package jp.co.pro_app.lacs.affairs.login.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リースユーザー担当者Entity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSCompnayEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSCompnayEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT LC_LOGO " + "\n");
		super.sql.append("      ,SECURITY_INFO " + "\n");
		super.sql.append("      ,LOGIN_INFO " + "\n");
		super.sql.append("      ,PASS_MIN " + "\n");
		super.sql.append("      ,PASS_MAX " + "\n");
		super.sql.append("      ,HON_PASSWD_YUKO_TERM " + "\n");
		super.sql.append("FROM   M_LC " + "\n");
	}

	/**
	 * ロゴを取得.
	 * 
	 * @return ロゴ
	 */
	public String getLogoImage() {
		return super.getString("LC_LOGO", "");
	}

	/**
	 * 証明書情報を取得.
	 * 
	 * @return 証明書情報
	 */
	public String getSecurityInfo() {
		return super.getString("SECURITY_INFO", "");
	}

	/**
	 * お問合せを取得.
	 * 
	 * @return お問合せ
	 */
	public String getLoginInfo() {
		return super.getString("LOGIN_INFO", "");
	}

	/**
	 * パスワード文字の下限を取得.
	 * 
	 * @return パスワード文字の下限
	 */
	public int getMinLength() {
		return super.getInt("PASS_MIN");

	}

	/**
	 * パスワード文字の上限を取得.
	 * 
	 * @return パスワード文字の上限
	 */
	public int getMaxLength() {
		return super.getInt("PASS_MAX");

	}

	/**
	 * 本パスワード有効期間を取得.
	 * 
	 * @return 本パスワード有効期間
	 */
	public int getAvailableDays() {
		return super.getInt("HON_PASSWD_YUKO_TERM");

	}
}
