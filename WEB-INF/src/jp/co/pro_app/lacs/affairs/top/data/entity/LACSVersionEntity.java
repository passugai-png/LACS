package jp.co.pro_app.lacs.affairs.top.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * Version取得Entity.
 * 
 * @author katoken
 * @version 20080814
 */
public class LACSVersionEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSVersionEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT COMMON_VER " + "\n");
		super.sql.append("      ,CUSTOM_VER " + "\n");
		super.sql.append("FROM   M_VERSION " + "\n");
	}

	/**
	 * 共通バージョンを取得.
	 * 
	 * @return 共通バージョン
	 */
	public String getCommonVer() {
		return super.getString("COMMON_VER", "");
	}

	/**
	 * カスタムバージョンを取得.
	 * 
	 * @return カスタムバージョン
	 */
	public String getCustomVer() {
		return super.getString("CUSTOM_VER", "");
	}
}
