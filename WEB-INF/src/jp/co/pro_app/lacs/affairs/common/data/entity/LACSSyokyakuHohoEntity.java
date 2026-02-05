package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 償却方法Entity.
 * 
 * @author takeda
 * @version 20070911
 */
public class LACSSyokyakuHohoEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSSyokyakuHohoEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT " + "\n");
		super.sql.append("       SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("      ,DISP_SKK_HOHO_NM " + "\n");
		super.sql.append("FROM   M_SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("ORDER  BY SKK_KEIJ_HOHO_KBN " + "\n");
	}

	/**
	 * 償却方法コードを取得.
	 * 
	 * @return 償却方法コード
	 */
	public String getSyokyakuHohoCode() {
		return super.getString("SKK_KEIJ_HOHO_KBN");
	}

	/**
	 * 償却方法名を取得.
	 * 
	 * @return 償却方法名
	 */
	public String getSyokyakuHohoName() {
		return super.getString("DISP_SKK_HOHO_NM");
	}
}
