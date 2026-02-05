package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 端数調整Entity.
 * 
 * @author takeda
 * @version 20070911
 */
public class LACSAcShrKbnEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSAcShrKbnEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT DISTINCT AC_SHR_KBN " + "\n");
		super.sql.append("      ,AC_SHR_RYA " + "\n");
		super.sql.append("FROM   M_AC_SHR_KBN " + "\n");
		super.sql.append("ORDER  BY AC_SHR_KBN " + "\n");

	}

	/**
	 * 会計処理区分を取得.
	 * 
	 * @return 会計処理区分
	 */
	public String getAcShrKbn() {
		return super.getString("AC_SHR_KBN");
	}

	/**
	 * 会計処理区分略称を取得.
	 * 
	 * @return 会計処理区分略称
	 */
	public String getAcShrRyaku() {
		return super.getString("AC_SHR_RYA");
	}
}
