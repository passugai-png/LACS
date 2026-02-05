package jp.co.pro_app.lacs.affairs.info.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * お知らせEntity.
 * 
 * @author takeda
 * @version 20070907
 */
public class LACSInfoEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSInfoEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	rowId	= "";

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.whereSw = true;
		super.sql.append("SELECT T.ROWID " + "\n");
		super.sql.append("      ,T.START_YMD " + "\n");
		super.sql.append("      ,T.END_YMD " + "\n");
		super.sql.append("      ,T.INFO_DATA " + "\n");

		super.sql.append("      ,T.LU_COSMOS_CD " + "\n");
		super.sql.append("FROM   T_INFO T " + "\n");

		super.sql.append("WHERE  T.ROWID = '" + rowId + "' " + "\n");

	}

	/**
	 * RowIdを設定.
	 * 
	 * @param piRowId
	 *            RowId
	 */
	public void setRowId(String piRowId) {
		this.rowId = piRowId;
	}

	/**
	 * 期間開始を取得.
	 * 
	 * @return 期間開始
	 */
	public String getStartYmd() {
		return super.getString("START_YMD");
	}

	/**
	 * 期間終了を取得.
	 * 
	 * @return 期間終了
	 */
	public String getEndYmd() {
		return super.getString("END_YMD");
	}

	/**
	 * 内容を取得.
	 * 
	 * @return 内容
	 */
	public String getInfoData() {
		return super.getString("INFO_DATA");
	}

	/**
	 * リースユーザー名を取得.
	 * 
	 * @return リースユーザー名
	 */
	public String getUserName() {
		return super.getString("LU_NM");
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

}
