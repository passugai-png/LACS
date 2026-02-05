package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * オプション値取得Entity.
 * 
 * @author Zhen.XB
 * @version 20130326
 */
public class LACSADSOptionEntity extends EntityBase {

	private int	optionCode	= 0;	// オプションコード

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSADSOptionEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * オプションコードを設定.
	 * 
	 * @param piOptionCode
	 *            オプションコード
	 */
	public void setOptionCode(int piOptionCode) {
		this.optionCode = piOptionCode;
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT T.OPT_VALUE FROM M_OPTION T WHERE T.OPT_CD = " + optionCode);
	}

	/**
	 * オプション設定値を取得.
	 * 
	 * @return オプション設定値
	 */
	public String getOptionValue() {
		return super.getString("OPT_VALUE", "");
	}

}
