package jp.co.pro_app.lacs.affairs.karirisilist.data.entity;

import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リースユーザー別借入利子率マスタ一覧Entity.
 * 
 * @author active
 * @version 20071210
 */
public class LACSKariRisiListEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSKariRisiListEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	cosmosCode	= "";	// COSMOSコード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT LU.LU_COSMOS_CD " + "\n");
		super.sql.append("	  ,LU.LU_NM " + "\n");
		super.sql.append("	  ,KRI2.TKY_TERM_FROM " + "\n");
		super.sql.append("	  ,KRI2.TKY_TERM_TO " + "\n");
		super.sql.append("	  ,KRI2.JISH_KRI_RS_RT " + "\n");
		super.sql.append("	  ,COUNT(KRI1.ROWID) CNT " + "\n");
		super.sql.append("FROM   M_LU_BETU_KRI_RS_RT KRI1 " + "\n");
		super.sql.append("JOIN   M_LU LU ON LU.LU_COSMOS_CD = KRI1.LU_COSMOS_CD " + "\n");
		super.sql.append("LEFT   JOIN M_LU_BETU_KRI_RS_RT KRI2 ON LU.LU_COSMOS_CD = KRI2.LU_COSMOS_CD " + "\n");
		super.sql.append("								 AND    TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN KRI2.TKY_TERM_FROM AND KRI2.TKY_TERM_TO " + "\n");
		if (this.cosmosCode.trim().length() > 0) {
			super.sql.append("WHERE  LU.LU_COSMOS_CD = '" + Command.changeQt(this.cosmosCode) + "' " + "\n");
		}
		super.sql.append("GROUP  BY LU.LU_COSMOS_CD " + "\n");
		super.sql.append("		 ,LU.LU_NM " + "\n");
		super.sql.append("		 ,KRI2.TKY_TERM_FROM " + "\n");
		super.sql.append("		 ,KRI2.TKY_TERM_TO " + "\n");
		super.sql.append("		 ,KRI2.JISH_KRI_RS_RT " + "\n");
		super.sql.append("ORDER BY LU_COSMOS_CD" + "\n");
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
	 * COSMOSコードを取得.
	 * 
	 * @return COSMOSコード
	 */
	public String getCosmosCode() {
		String retStr = super.getString("LU_COSMOS_CD");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * ユーザー名を取得.
	 * 
	 * @return ユーザー名
	 */
	public String getUserName() {
		String retStr = super.getString("LU_NM");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 適用期間FROMを取得.
	 * 
	 * @return 適用期間FROM
	 */
	public String getKikanFrom() {
		String retStr = super.getString("TKY_TERM_FROM");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 適用期間TOを取得.
	 * 
	 * @return 適用期間TO
	 */
	public String getKikanTo() {
		String retStr = super.getString("TKY_TERM_TO");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 自社借入利子率を取得.
	 * 
	 * @return 自社借入利子率
	 */
	public double getRisiRitu() {
		return super.getDouble("JISH_KRI_RS_RT");
	}

	/**
	 * 件数を取得.
	 * 
	 * @return 件数
	 */
	public int getCount() {
		return super.getInt("CNT");
	}
}
