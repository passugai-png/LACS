package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 端数調整Entity.
 * 
 * @author takeda
 * @version 20070911
 */
public class LACSHasuTyoseiEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSHasuTyoseiEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT HASU_CHSE_CD " + "\n");
		super.sql.append("      ,HASU_CHSE_NM " + "\n");
		super.sql.append("FROM   M_HASU_CHSE_CD " + "\n");
		super.sql.append("ORDER  BY HASU_CHSE_CD " + "\n");
	}

	/**
	 * 端数調整コードを取得.
	 * 
	 * @return 端数調整コード
	 */
	public String getHasuTyoseiCode() {
		return super.getString("HASU_CHSE_CD");
	}

	/**
	 * 端数調整名を取得.
	 * 
	 * @return 端数調整名
	 */
	public String getHasuTyoseiName() {
		return super.getString("HASU_CHSE_NM");
	}
}
