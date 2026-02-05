package jp.co.pro_app.lacs.affairs.companylist.data.entity;

import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リース会社マスタ一覧Entity.
 * 
 * @author active
 * @version 20071210
 */
public class LACSCompanyListEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSCompanyListEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	leasCompanyCode	= "";	// リース会社コード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT LC_CD " + "\n"); // リース会社コード
		super.sql.append("      ,LC_NM " + "\n"); // リース会社名称
		super.sql.append("      ,LC_ADR1 " + "\n"); // リース会社住所
		super.sql.append("      ,LC_TNT_BUSHO_NM " + "\n"); // リース会社担当者部署
		super.sql.append("      ,LC_TNT_NM " + "\n"); // リース会社担当者
		super.sql.append("      ,LC_TNT_TELNO " + "\n"); // リース会社担当電話番号
		super.sql.append("      ,KKN_RUL_PTN " + "\n"); // 課金ルールパターン
		super.sql.append("      ,KHN_AMT " + "\n"); // 基本料金
		super.sql.append("      ,WRBKRT " + "\n"); // 割引率
		super.sql.append("      ,KIS_KBN " + "\n"); // 回収予定分割区分
		super.sql.append("      ,SHR_YM " + "\n"); // 処理年月
		super.sql.append("FROM   M_LC " + "\n");
		if (this.leasCompanyCode.trim().length() > 0) {
			super.sql.append("WHERE  LC_CD = '" + Command.changeQt(this.leasCompanyCode) + "' " + "\n");
		}
		super.sql.append("ORDER BY LC_CD " + "\n");

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
	 * リース会社名称を取得.
	 * 
	 * @return リース会社名称
	 */
	public String getName() {
		String retStr = super.getString("LC_NM");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * リース会社住所１を取得.
	 * 
	 * @return リース会社住所１
	 */
	public String getAddress1() {
		String retStr = super.getString("LC_ADR1");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * リース会社担当者部署を取得.
	 * 
	 * @return リース会社担当者部署
	 */
	public String getBusyo() {
		String retStr = super.getString("LC_TNT_BUSHO_NM");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * リース会社担当者を取得.
	 * 
	 * @return リース会社担当者
	 */
	public String getTanto() {
		String retStr = super.getString("LC_TNT_NM");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * リース会社担当電話番号を取得.
	 * 
	 * @return リース会社担当電話番号
	 */
	public String getTantoTel() {
		String retStr = super.getString("LC_TNT_TELNO");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 課金ルールパターンを取得.
	 * 
	 * @return 課金ルールパターン
	 */
	public String getKakinPattern() {
		String retStr = super.getString("KKN_RUL_PTN");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 基本料金を取得.
	 * 
	 * @return 基本料金
	 */
	public String getKihonAmount() {
		String retStr = super.getString("KHN_AMT");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 割引率を取得.
	 * 
	 * @return 割引率
	 */
	public String getWaribiki() {
		String retStr = super.getString("WRBKRT");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 回収予定分割区分を取得.
	 * 
	 * @return 回収予定分割区分
	 */
	public String getKaisyuKbn() {
		String retStr = super.getString("KIS_KBN");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

	/**
	 * 処理年月を取得.
	 * 
	 * @return 処理年月
	 */
	public String getSyoriYM() {
		String retStr = super.getString("SHR_YM");
		if (retStr == null) {
			retStr = "";
		}
		return retStr;
	}

}
