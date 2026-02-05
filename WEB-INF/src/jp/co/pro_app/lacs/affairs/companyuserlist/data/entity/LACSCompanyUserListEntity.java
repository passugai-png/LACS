package jp.co.pro_app.lacs.affairs.companyuserlist.data.entity;

import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リース会社別リースユーザーマスタ一覧Entity.
 * 
 * @author active
 * @version 20071210
 */
public class LACSCompanyUserListEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSCompanyUserListEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	leasCompanyCode	= "";	// リース会社コード

	private String	torihikiCode	= "";	// リースユーザー取引先コード

	private String	cosmosCode		= "";	// COSMOSコード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		StringBuffer where = new StringBuffer();

		super.whereSw = true;

		if (this.leasCompanyCode.trim().length() > 0) {
			where.append(super.getWhereAnd("CBU.LC_CD = '" + Command.changeQt(this.leasCompanyCode) + "' " + "\n"));
		}

		if (this.torihikiCode.trim().length() > 0) {
			where.append(super.getWhereAnd("CBU.LU_TRSK_CD = '" + Command.changeQt(this.torihikiCode) + "' " + "\n"));
		}

		if (this.cosmosCode.trim().length() > 0) {
			where.append(super.getWhereAnd("CBU.LU_COSMOS_CD = '" + Command.changeQt(this.cosmosCode) + "' " + "\n"));
		}

		super.sql.append("SELECT CBU.LC_CD " + "\n"); // リース会社コード
		super.sql.append("      ,CBU.LU_TRSK_CD " + "\n"); // リースユーザー取引先コード
		super.sql.append("      ,CBU.LU_COSMOS_CD " + "\n"); // リースユーザーCOSMOSコード
		super.sql.append("      ,CBU.LATE_DATA_TEIK_YMD " + "\n"); // 最新データ提供年月日
		super.sql.append("      ,CBU.LATE_DATA_TEIK_YM " + "\n"); // 最新データ提供月
		super.sql.append("      ,LU.LU_NM " + "\n"); // 最新データ提供月
		super.sql.append("FROM   M_LC_BETU_LU CBU " + "\n");
		super.sql.append("JOIN   M_LU LU " + "\n");
		super.sql.append("ON     CBU.LU_COSMOS_CD = LU.LU_COSMOS_CD " + "\n");
		super.sql.append(where);
		super.sql.append("ORDER BY CBU.LC_CD,CBU.LU_TRSK_CD " + "\n");

	}

	/**
	 * リース会社コードを設定.
	 * 
	 * @param piLeasCompanyCode
	 *            リース会社コード
	 */
	public void setLeasCompanyCode(String piLeasCompanyCode) {
		this.leasCompanyCode = piLeasCompanyCode;
	}

	/**
	 * リースユーザー取引先コードを設定.
	 * 
	 * @param piTorihikiCode
	 *            リースユーザー取引先コード
	 */
	public void setTorihikiCode(String piTorihikiCode) {
		this.torihikiCode = piTorihikiCode;
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
		String retStr = super.getString("LC_CD");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * リースユーザー取引先コードを取得.
	 * 
	 * @return リースユーザー取引先コード
	 */
	public String getTorihikiCode() {
		String retStr = super.getString("LU_TRSK_CD");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * リースユーザーCOSMOSコードを取得.
	 * 
	 * @return リースユーザーCOSMOSコード
	 */
	public String getCosmosCode() {
		String retStr = super.getString("LU_COSMOS_CD");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 最新データ提供年月日を取得.
	 * 
	 * @return 最新データ提供年月日
	 */
	public String getTeikyouYMD() {
		String retStr = super.getString("LATE_DATA_TEIK_YMD");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 最新データ提供月を取得.
	 * 
	 * @return 最新データ提供月
	 */
	public String getTeikyouYM() {
		String retStr = super.getString("LATE_DATA_TEIK_YM");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * リースユーザー名を取得.
	 * 
	 * @return リースユーザー名
	 */
	public String getUserName() {
		return super.getString("LU_NM", "");
	}

}
