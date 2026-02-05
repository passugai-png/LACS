package jp.co.pro_app.lacs.affairs.ukebarai.data.entity;

import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 受払合計表Entity.
 * 
 * @author active
 * @version 20080811
 */
public class LACSUkebaraiSpaceEntity extends EntityBase {

	private String	dateFrom	= "";	// 期間開始年月日

	private String	term		= "";	// 集計期間

	private String	cosmosCode	= "";	// COSMOSコード

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 */
	public LACSUkebaraiSpaceEntity(DBModelBase piModel, LACSUkebaraiBean piUkebaraiBean) {
		super(piModel);

		this.dateFrom = piUkebaraiBean.getTermFrom().getYYYYMMDD();

		this.term = piUkebaraiBean.getTsukiSu();
		this.cosmosCode = piUkebaraiBean.getLeasCompany().getValue();
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		sql.append(" SELECT DISTINCT LC.LC_NM, LC.UKB_GOKEI,LC.UKB_SISAN,LC.UKB_LEASE,LC.UKB_HIYO " + "\n");
		sql.append(" , '" + this.dateFrom + "' START_YMD " + "\n");
		sql.append(" , LACS_COMMON.GET_TERM_DATE('" + this.dateFrom + "', " + this.term + ") AS END_YMD " + "\n");
		sql.append(" FROM T_KEI T, M_LC LC " + "\n");
		sql.append(" WHERE T.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
		sql.append(" AND   T.LC_CD        = LC.LC_CD " + "\n");

	}

	/**
	 * リース会社名称を取得.
	 * 
	 * @return リース会社名称
	 */
	public String getLcNm() {
		return super.getString("LC_NM");
	}

	/**
	 * 対象期間Fromを取得.
	 * 
	 * @return 対象期間From
	 */
	public String getStartYmd() {
		return super.getString("START_YMD");
	}

	/**
	 * 対象期間Toを取得.
	 * 
	 * @return 対象期間To
	 */
	public String getEndYmd() {
		return super.getString("END_YMD");
	}

	/**
	 * 受払合計表有無を取得.
	 * 
	 * @return 受払合計表有無
	 */
	public String getUkbGokei() {
		return super.getString("UKB_GOKEI");
	}

	/**
	 * リース資産受払明細表有無を取得.
	 * 
	 * @return リース資産受払明細表有無
	 */
	public String getUkbSisan() {
		return super.getString("UKB_SISAN");
	}

	/**
	 * リース料受払明細表有無を取得.
	 * 
	 * @return リース料受払明細表有無
	 */
	public String getUkbLease() {
		return super.getString("UKB_LEASE");
	}

	/**
	 * 費用受払明細表有無を取得.
	 * 
	 * @return 費用受払明細表有無
	 */
	public String getUkbHiyo() {
		return super.getString("UKB_HIYO");
	}

}
