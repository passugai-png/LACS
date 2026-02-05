package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * コピーライト取得Entity.
 * 
 * @author Yokota
 * @version 20081006
 */
public class LACSCopyRightEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSCopyRightEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT CASE " + "\n");
		super.sql.append("           WHEN O.OPT_VALUE = '1' THEN " + "\n");
		super.sql.append("            (SELECT C.COPY_RIGHT FROM M_LC C WHERE C.LC_CD = 'LACS') " + "\n");
		super.sql.append("           ELSE " + "\n");
		super.sql.append("            ' ' " + "\n");
		super.sql.append("       END COPY_RIGHT " + "\n");
		super.sql.append("FROM   M_OPTION O " + "\n");
		super.sql.append("WHERE  O.OPT_CD = 3 " + "\n");
	}

	/**
	 * コピーライトを取得.
	 * 
	 * @return コピーライト
	 */
	public String getCopyRight() {
		return super.getString("COPY_RIGHT", "");
	}

}
