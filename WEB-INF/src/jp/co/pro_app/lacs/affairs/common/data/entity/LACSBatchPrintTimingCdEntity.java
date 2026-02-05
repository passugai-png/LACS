package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 出力タイミングEntity.
 * 
 * @author Zhen.XB
 * @version 20130321
 */
public class LACSBatchPrintTimingCdEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSBatchPrintTimingCdEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		
		super.sql.append("SELECT DISTINCT BATCH_PRINT_TIMING_CD " + "\n");
		super.sql.append("      ,TIMING_NM " + "\n");
		super.sql.append("FROM   M_OUTPUT_TIMING " + "\n");
		super.sql.append("ORDER  BY BATCH_PRINT_TIMING_CD " + "\n");
		
	}
	
	/**
	 * 出力タイミングを取得.
	 * 
	 * @return 出力タイミング
	 */
	public String getBatchPrintTimingCd() {
		return super.getString("BATCH_PRINT_TIMING_CD");
	}

	/**
	 * 出力タイミング略称を取得.
	 * 
	 * @return 出力タイミング略称
	 */
	public String getTimingNm() {
		return super.getString("TIMING_NM");
	}

}
