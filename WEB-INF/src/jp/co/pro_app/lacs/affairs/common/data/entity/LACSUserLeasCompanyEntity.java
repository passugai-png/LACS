package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リースユーザー別リース会社Entity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSUserLeasCompanyEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSUserLeasCompanyEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	cosmosCode	= "";		// COSMOSコード

	private String	companyCode	= "";		// リース会社コード

	private String	leasCompanyNm;			// リース会社名（曖昧検索用）

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
			super.sql.append("WHERE  LU_NM LIKE '%" + Command.changeQt(this.leasCompanyNm) + "%' " + "\n");
			super.sql.append("ORDER  BY LU_COSMOS_CD " + "\n");
		}
		else {
			super.sql.append("SELECT DISTINCT LC.LC_CD " + "\n");

			super.sql.append("	  ,LC.LC_NM " + "\n");
			super.sql.append("	  ,LU.LU_COSMOS_CD " + "\n");
			super.sql.append("	  ,LU.LU_NM " + "\n");
			super.sql.append("FROM   M_LC_BETU_LU LC_LU " + "\n");
			super.sql.append("JOIN   M_LC LC ON LC_LU.LC_CD = LC.LC_CD " + "\n");
			super.sql.append("JOIN   M_LU LU ON LC_LU.LU_COSMOS_CD = LU.LU_COSMOS_CD " + "\n");

			if (this.cosmosCode.trim().length() > 0) {
				super.sql.append("WHERE  LC_LU.LU_COSMOS_CD = '" + Command.changeQt(this.cosmosCode) + "' " + "\n");
			}
			else {
				super.sql.append("WHERE  LC.LC_CD = '" + Command.changeQt(this.companyCode) + "' " + "\n");
			}

			super.sql.append("AND  LU.LU_NM LIKE '%" + Command.changeQt(this.leasCompanyNm) + "%' " + "\n");

			super.sql.append("ORDER  BY LC.LC_CD " + "\n");
			super.sql.append("         ,LU.LU_COSMOS_CD " + "\n");
		}
	}

	/**
	 * COSMOSコードを設定.
	 * 
	 * @param piCosmosCode
	 *            COSMOSコード
	 */
	public void setCosmosCode(String piCosmosCode) {
		this.cosmosCode = piCosmosCode;
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

	/**
	 * リース会社コードを取得.
	 * 
	 * @return リース会社コード
	 */
	public String getCompanyCode() {
		return this.companyCode;
	}

	/**
	 * リース会社コードを設定します.
	 * 
	 * @param piCompanyCode
	 *            リース会社コード
	 */
	public void setCompanyCode(String piCompanyCode) {
		this.companyCode = piCompanyCode;
	}

	/**
	 * リース会社名（曖昧検索用）を取得.
	 * 
	 * @return リース会社名（曖昧検索用）
	 */
	public String getLeasCompanyNm() {
		return this.leasCompanyNm;
	}

	/**
	 * リース会社名（曖昧検索用）を設定します.
	 * 
	 * @param piLeasCompanyNm
	 *            リース会社名（曖昧検索用）
	 */
	public void setLeasCompanyNm(String piLeasCompanyNm) {
		this.leasCompanyNm = piLeasCompanyNm;
	}

	/**
	 * 全ユーザー表示制御を設定.
	 * 
	 * @param piIsShowAll
	 *            全ユーザー表示制御
	 */
	public void setShowAll(boolean piIsShowAll) {
		this.isShowAll = piIsShowAll;
	}
}
