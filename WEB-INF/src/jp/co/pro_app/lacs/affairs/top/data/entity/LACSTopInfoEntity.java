package jp.co.pro_app.lacs.affairs.top.data.entity;

import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * お知らせ(処理メニュー)Entity.
 * 
 * @author Katoken
 * @version 20090925
 */
public class LACSTopInfoEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSTopInfoEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	startYmd		= "";	// 期間開始

	private String	endYmd			= "";	// 期間終了

	private String	menuCosmosCode	= "";	// 処理メニュー用COSMOSコード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		String from = startYmd.length() == 0 ? "00000000" : startYmd;
		String to = endYmd.length() == 0 ? "99999999" : endYmd;

		StringBuffer where = new StringBuffer();
		where.append(super.getWhereAnd("T.START_YMD<= '" + to + "' " + "\n"));
		where.append(super.getWhereAnd("T.END_YMD >= '" + from + "' " + "\n"));
		if (this.menuCosmosCode.trim().length() > 0) {
			where.append(super.getWhereAnd("T.LU_COSMOS_CD IN ('" + Command.changeQt(this.menuCosmosCode) + "', '" + LACSDefine.INFO_ALL + "') " + "\n"));
		}
		super.whereSw = true;
		super.sql.append("SELECT T.START_YMD " + "\n");
		super.sql.append("      ,T.END_YMD " + "\n");
		super.sql.append("      ,T.INFO_DATA " + "\n");

		super.sql.append("FROM   T_INFO T " + "\n");
		super.sql.append("LEFT  JOIN   M_LU LU " + "\n");
		super.sql.append("ON     T.LU_COSMOS_CD = LU.LU_COSMOS_CD " + "\n");
		super.sql.append(where);
		super.sql.append("ORDER BY DECODE(T.LU_COSMOS_CD, '" + LACSDefine.INFO_ALL + "', 0, 1), T.START_YMD, T.END_YMD, T.ENT_DATE " + "\n");

	}

	/**
	 * 期間開始を設定.
	 * 
	 * @param piStartYmd
	 *            期間開始
	 */
	public void setStartYmd(String piStartYmd) {
		this.startYmd = piStartYmd;
	}

	/**
	 * 期間終了を設定.
	 * 
	 * @param piEndYmd
	 *            期間終了
	 */
	public void setEndYmd(String piEndYmd) {
		this.endYmd = piEndYmd;
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
	 * 処理メニュー用COSMOSコードを設定.
	 * 
	 * @param piMenuCosmosCode
	 *            処理メニュー用COSMOSコード
	 */
	public void setMenuCosmosCode(String piMenuCosmosCode) {
		this.menuCosmosCode = piMenuCosmosCode;
	}
}
