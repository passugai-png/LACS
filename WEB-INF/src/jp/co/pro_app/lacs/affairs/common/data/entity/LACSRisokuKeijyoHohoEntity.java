package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 利息計上方法Entity.
 * 
 * @author takeda
 * @version 20070911
 */
public class LACSRisokuKeijyoHohoEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSRisokuKeijyoHohoEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("      ,RSK_KEIJ_HOHO_KBN_NM " + "\n");
		super.sql.append("FROM   M_RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("ORDER  BY RSK_KEIJ_HOHO_KBN " + "\n");
	}

	/**
	 * 利息計上方法区分を取得.
	 * 
	 * @return 利息計上方法区分
	 */
	public String getSyokyakuHohoCode() {
		return super.getString("RSK_KEIJ_HOHO_KBN");
	}

	/**
	 * 利息計上方法区分名称を取得.
	 * 
	 * @return 利息計上方法区分名称
	 */
	public String getSyokyakuHohoName() {
		return super.getString("RSK_KEIJ_HOHO_KBN_NM");
	}
}
