package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * LACS用権限取得Entity .
 * 
 * @author katoken
 * @version 20090121
 */
public class LACSDispControlEntity extends EntityBase {

	private String	cosmosCode	= "";

	private int		adminMode	= 0;

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSDispControlEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT T.CTRL_ID, " + ((this.cosmosCode.equals(LACSDefine.INFO_ALL) && this.adminMode == 1) ? "'1'" : "T.CTRL_VALUE") + " CTRL_VALUE  FROM M_DSP_CTRL T WHERE T.LU_COSMOS_CD = '" + Command.changeQt(this.cosmosCode) + "'");
	}

	/**
	 * 開示先コードを設定.
	 * 
	 * @param piCosmosCode
	 *            開示先コード
	 */
	public void setCosmosCode(String piCosmosCode) {
		this.cosmosCode = piCosmosCode;
	}

	/**
	 * 管理者モードを設定.
	 * 
	 * @param piAdminMode
	 *            管理者モード
	 */
	public void setAdminMode(int piAdminMode) {
		this.adminMode = piAdminMode;
	}

	/**
	 * コントロールコードを取得.
	 * 
	 * @return コントロールコード
	 */
	public String getControlID() {
		return super.getString("CTRL_ID");
	}

	/**
	 * 設定値を取得.
	 * 
	 * @return 設定値
	 */
	public String getControlValue() {
		return super.getString("CTRL_VALUE");
	}
}
