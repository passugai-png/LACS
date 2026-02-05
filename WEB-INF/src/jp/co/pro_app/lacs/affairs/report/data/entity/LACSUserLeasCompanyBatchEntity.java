package jp.co.pro_app.lacs.affairs.report.data.entity;

import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リースユーザー別リース会社Entity.
 * 
 * @author katoken
 * @version 20070312
 */
	public class LACSUserLeasCompanyBatchEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSUserLeasCompanyBatchEntity(DBModelBase piModel) {
		super(piModel);
	}
	
	private String	companyCode	= "";		// リース会社コード

	public String getCompanyCode() {
		return companyCode;
	}



	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}



	public boolean isShowAll() {
		return isShowAll;
	}



	public void setShowAll(boolean isShowAll) {
		this.isShowAll = isShowAll;
	}

	private boolean	isShowAll	= false;
	
	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		if (isShowAll) {
			super.sql.append("SELECT ' ' LC_CD " + "\n");
			super.sql.append("	  ,' ' LC_NM " + "\n");
			super.sql.append("	  ,LU.LU_COSMOS_CD " + "\n");
			super.sql.append("	  ,LU.LU_NM " + "\n");
			super.sql.append("FROM   M_LU LU " + "\n");
			super.sql.append("ORDER BY CONCAT(CONCAT(LC_SHZK_SHO, LC_SHZK_BU), LC_SHZK_GRP), LC_TNT_CD, LU_COSMOS_CD " + "\n");
		}
		else {
			super.sql.append("SELECT DISTINCT LC.LC_CD " + "\n");
			super.sql.append("	  ,LC.LC_NM " + "\n");
			super.sql.append("	  ,LU.LU_COSMOS_CD " + "\n");
			super.sql.append("	  ,LU.LU_NM " + "\n");
			super.sql.append("	  ,LU.LC_TNT_CD " + "\n");
			super.sql.append("	  ,LU.LC_SHZK_SHO " + "\n");
			super.sql.append("	  ,LU.LC_SHZK_BU " + "\n");
			super.sql.append("	  ,LU.LC_SHZK_GRP " + "\n");
			super.sql.append("FROM   M_LC_BETU_LU LC_LU " + "\n");
			super.sql.append("JOIN   M_LC LC ON LC_LU.LC_CD = LC.LC_CD " + "\n");
			super.sql.append("JOIN   M_LU LU ON LC_LU.LU_COSMOS_CD = LU.LU_COSMOS_CD " + "\n");
			super.sql.append("WHERE  LC.LC_CD = '" + Command.changeQt(this.companyCode) + "' " + "\n");
			super.sql.append("ORDER BY CONCAT(CONCAT(LU.LC_SHZK_SHO, LU.LC_SHZK_BU), LU.LC_SHZK_GRP), LU.LC_TNT_CD, LU.LU_COSMOS_CD " + "\n");
		}
	}

	

	/**
	 * リース会社コードを取得.
	 * 
	 * @return リース会社コード
	 */
	public String getLeasCompanyCode() {
		return super.getString("LC_CD");
	}

	/**
	 * リース会社名を取得.
	 * 
	 * @return リース会社名
	 */
	public String getLeasCompanyName() {
		return super.getString("LC_NM");
	}

	/**
	 * リース会社コードを取得.
	 * 
	 * @return リース会社コード
	 */
	public String getCosmosCode() {
		return super.getString("LU_COSMOS_CD");
	}

	/**
	 * リース会社名を取得.
	 * 
	 * @return リース会社名
	 */
	public String getUserName() {
		return super.getString("LU_NM");
	}
	
	
	public String getSrkiWrkiCode() {
		return super.getString("SRKI_WRKI_CD");
	}
	
	/**
	 *出力タイミングコードを取得.
	 * 
	 * @return 出力タイミングコード
	 */
	public String GetBatchPrintTimingCode() {
		return super.getString("BATCH_PRINT_TIMING_CD");
	}
}
