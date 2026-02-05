package jp.co.pro_app.lacs.affairs.karirisi.data.entity;

import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リースユーザー別借入利子率マスタEntity.
 * 
 * @author ohmura
 * @version 20070918
 */
public class LACSKariRisiEntity extends EntityBase {

	/**
	 * リースユーザー別借入利子率マスタ コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSKariRisiEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	cosmosCode	= "";	// COSMOSコード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT TKY_TERM_FROM " + "\n"); // 適用期間FROM
		super.sql.append("      ,TKY_TERM_TO " + "\n"); // 適用期間TO
		super.sql.append("      ,JISH_KRI_RS_RT " + "\n"); // 自社借入利子率
		super.sql.append("      ,B.LU_NM " + "\n"); // 開示先名称
		super.sql.append("FROM   M_LU_BETU_KRI_RS_RT A" + "\n");
		super.sql.append("JOIN   M_LU B" + "\n");
		super.sql.append("ON     A.LU_COSMOS_CD = B.LU_COSMOS_CD " + "\n");
		super.sql.append("WHERE A.LU_COSMOS_CD = '" + Command.changeQt(this.cosmosCode) + "' " + "\n");
		super.sql.append("ORDER BY TKY_TERM_FROM DESC " + "\n");

	}

	/**
	 * COSMOSコードを設定.
	 * 
	 * @param piCosmosCode
	 *            ユーザーID
	 */
	public void setCosmosCode(String piCosmosCode) {
		this.cosmosCode = piCosmosCode;
	}

	/**
	 * 適用期間FROMを取得.
	 * 
	 * @return 適用期間FROM
	 */
	public String getKikanFrom() {
		return super.getString("TKY_TERM_FROM");
	}

	/**
	 * 適用期間TOを取得.
	 * 
	 * @return 適用期間TO
	 */
	public String getKikanTo() {
		return super.getString("TKY_TERM_TO");
	}

	/**
	 * 自社借入利子率を取得.
	 * 
	 * @return 自社借入利子率
	 */
	public String getRisiRitu() {
		return super.getString("JISH_KRI_RS_RT");
	}

	/**
	 * 開示先名称を取得.
	 * 
	 * @return 開示先名称
	 */
	public String getUserName() {
		return super.getString("LU_NM");
	}
}
