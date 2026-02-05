package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 取引判定結果Entity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSTradeHanteiKbnEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSTradeHanteiKbnEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("	  ,TRD_HNTE_KEKA_NM " + "\n");
		super.sql.append("FROM   M_TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("ORDER  BY TRD_HNTE_KEKA_KBN " + "\n");
	}

	/**
	 * 取引判定結果区分を取得.
	 * 
	 * @return 取引判定結果区分
	 */
	public String getTradeHanteiKekkaCode() {
		return super.getString("TRD_HNTE_KEKA_KBN");
	}

	/**
	 * 取引判定結果名を取得.
	 * 
	 * @return 取引判定結果名
	 */
	public String getTradeHanteiKekkaName() {
		return super.getString("TRD_HNTE_KEKA_NM");
	}

}
