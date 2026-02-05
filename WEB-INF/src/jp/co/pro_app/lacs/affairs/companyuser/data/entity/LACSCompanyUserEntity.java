package jp.co.pro_app.lacs.affairs.companyuser.data.entity;

import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リース会社別リースユーザーマスタEntity.
 * 
 * @author takeda
 * @version 20070907
 */
public class LACSCompanyUserEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSCompanyUserEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	leasCompanyCode	= "";	// リース会社コード

	private String	torihikiCode	= "";	// リースユーザー取引先コード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT LU_COSMOS_CD " + "\n"); // リースユーザーCOSMOSコード
		super.sql.append("      ,LATE_DATA_TEIK_YMD " + "\n"); // 最新データ提供年月日
		super.sql.append("      ,LATE_DATA_TEIK_YM " + "\n"); // 最新データ提供月
		super.sql.append("FROM   M_LC_BETU_LU " + "\n");
		super.sql.append("WHERE  LC_CD = '" + Command.changeQt(this.leasCompanyCode) + "' " + "\n");
		super.sql.append("AND    LU_TRSK_CD = '" + Command.changeQt(this.torihikiCode) + "' " + "\n");
	}

	/**
	 * リース会社コードを設定.
	 * 
	 * @param piLeasCompanyCode
	 *            リース会社コードコード
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
	 * リースユーザーCOSMOSコードを取得.
	 * 
	 * @return リースユーザーCOSMOSコード
	 */
	public String getCosmosCode() {
		return super.getString("LU_COSMOS_CD");
	}

	/**
	 * 最新データ提供年月日を取得.
	 * 
	 * @return 最新データ提供年月日
	 */
	public String getTeikyouYMD() {
		return super.getString("LATE_DATA_TEIK_YMD");
	}

	/**
	 * 最新データ提供月を取得.
	 * 
	 * @return 最新データ提供月
	 */
	public String getTeikyouYM() {
		return super.getString("LATE_DATA_TEIK_YM");
	}
}
