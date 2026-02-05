package jp.co.pro_app.lacs.common.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * バッチ処理実行中判定Entity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSBatchProcEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSBatchProcEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT T.EXECUTE_FLG " + "\n");
		super.sql.append("FROM   T_BATCH_PROC T " + "\n");
		super.sql.append("WHERE  T.EXECUTE_FLG = '1' " + "\n");
	}
}
