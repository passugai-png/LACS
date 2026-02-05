package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リースユーザー別リース会社Entity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSLoginCompanyEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSLoginCompanyEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	companyCode	= "";	// COSMOSコード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT LC.SHR_YM " + "\n");
		super.sql.append("      ,LC.ERR_DSP_FLG " + "\n");
		super.sql.append("FROM   M_LC LC  " + "\n");
		super.sql.append("WHERE  LC.LC_CD = '" + this.companyCode + "' " + "\n");
	}

	/**
	 * リース会社コードを設定.
	 * 
	 * @param piCompanyCode
	 *            リース会社コード
	 */
	public void setCompanyCode(String piCompanyCode) {
		this.companyCode = piCompanyCode;
	}

	/**
	 * 処理年月を取得.
	 * 
	 * @return 処理年月
	 */
	public String getShoriYM() {
		return super.getString("SHR_YM");
	}

	/**
	 * エラー時の処理メニューの制御を取得.
	 * 
	 * @return エラー時の処理メニューの制御
	 */
	public String getErrorDisplayFlg() {
		return super.getString("ERR_DSP_FLG");
	}
}
