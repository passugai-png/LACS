package jp.co.pro_app.lacs.affairs.infolist.data.entity;

import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * お知らせ一覧Entity.
 * 
 * @author active
 * @version 20071210
 */
public class LACSInfoListEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSInfoListEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String	startYmd		= "";	// 期間開始

	private String	endYmd			= "";	// 期間終了

	private String	infoData		= "";	// 内容

	private String	cosmosCode		= "";	// COSMOSコード

	private String	menuCosmosCode	= "";	// 処理メニュー用COSMOSコード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		String from = startYmd.length() == 0 ? "00000000" : startYmd;
		String to = endYmd.length() == 0 ? "99999999" : endYmd;

		StringBuffer where = new StringBuffer();
		where.append(super.getWhereAnd("T.START_YMD<= '" + Command.changeQt(to) + "' " + "\n"));
		where.append(super.getWhereAnd("T.END_YMD >= '" + Command.changeQt(from) + "' " + "\n"));

		if (this.cosmosCode.trim().length() > 0) {
			where.append(super.getWhereAnd("T.LU_COSMOS_CD = '" + Command.changeQt(this.cosmosCode) + "' " + "\n"));
		}

		if (this.menuCosmosCode.trim().length() > 0) {
			where.append(super.getWhereAnd("T.LU_COSMOS_CD IN ('" + Command.changeQt(this.menuCosmosCode) + "', '" + LACSDefine.INFO_ALL + "') " + "\n"));
		}

		where.append(super.getWhereAnd("T.INFO_DATA LIKE '%" + Command.changeQt(infoData) + "%' " + "\n"));

		super.whereSw = true;
		
		super.sql.append("SELECT T.START_YMD " + "\n");
		super.sql.append("      ,T.END_YMD " + "\n");
		super.sql.append("      ,T.INFO_DATA " + "\n");
		super.sql.append("      ,T.ROWID RI " + "\n");
		super.sql.append("      ,NVL(LU.LU_NM,'全開示先') LU_NM" + "\n");
		super.sql.append("FROM   T_INFO T " + "\n");
		super.sql.append("LEFT  JOIN   M_LU LU " + "\n");
		super.sql.append("ON     T.LU_COSMOS_CD = LU.LU_COSMOS_CD " + "\n");
		super.sql.append(where);
		super.sql.append("ORDER BY T.START_YMD, T.END_YMD, T.LU_COSMOS_CD, T.ENT_DATE " + "\n");
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
	 * 内容を設定.
	 * 
	 * @param piData
	 *            内容
	 */
	public void setInfoData(String piData) {
		this.infoData = piData;
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
	 * ROWIDを取得.
	 * 
	 * @return ROWID
	 */
	public String getRowId() {
		return super.getString("RI");
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
	 * 処理メニュー用COSMOSコードを設定.
	 * 
	 * @param piMenuCosmosCode
	 *            処理メニュー用COSMOSコード
	 */
	public void setMenuCosmosCode(String piMenuCosmosCode) {
		this.menuCosmosCode = piMenuCosmosCode;
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
