package jp.co.pro_app.lacs.affairs.shiharai.bean;

import jp.co.pro_app.projframe.common.bean.BeanBase;

/**
 * 支払推移表明細Bean.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiharaiDetailBean extends BeanBase {

	private static final long serialVersionUID = 1L;

	private String	date			= "";	// 年月

	private long	leasAmount		= 0;	// リース料

	private long	staxAmount		= 0;	// リース料(消費税)

	private long	ganponAmount	= 0;	// 元本

	private long	risokuAmount	= 0;	// 利息

	private long	ijiAmount		= 0;	// 維持管理費

	private long	ekimuAmount		= 0;	// 役務提供費

	private long	shoukyakuAmount	= 0;	// 償却費

	/**
	 * 年月を取得.
	 * 
	 * @return 年月
	 */
	public String getDate() {
		return this.date;
	}

	/**
	 * 年月を設定.
	 * 
	 * @param piDate
	 *            年月
	 */
	public void setDate(String piDate) {
		this.date = piDate;
	}

	/**
	 * リース料を取得.
	 * 
	 * @return リース料
	 */
	public long getLeasAmount() {
		return this.leasAmount;
	}

	/**
	 * リース料を設定.
	 * 
	 * @param piLeasAmount
	 *            リース料
	 */
	public void setLeasAmount(long piLeasAmount) {
		this.leasAmount = piLeasAmount;
	}

	/**
	 * リース料(消費税)を取得.
	 * 
	 * @return リース料(消費税)
	 */
	public long getStaxAmount() {
		return this.staxAmount;
	}

	/**
	 * リース料(消費税)を設定.
	 * 
	 * @param piStaxAmount
	 *            リース料(消費税)
	 */
	public void setStaxAmount(long piStaxAmount) {
		this.staxAmount = piStaxAmount;
	}

	/**
	 * 元本を取得.
	 * 
	 * @return 元本
	 */
	public long getGanponAmount() {
		return this.ganponAmount;
	}

	/**
	 * 元本を設定.
	 * 
	 * @param piGanponAmount
	 *            元本
	 */
	public void setGanponAmount(long piGanponAmount) {
		this.ganponAmount = piGanponAmount;
	}

	/**
	 * 利息を取得.
	 * 
	 * @return 利息
	 */
	public long getRisokuAmount() {
		return this.risokuAmount;
	}

	/**
	 * 利息を設定.
	 * 
	 * @param piRisokuAmount
	 *            利息
	 */
	public void setRisokuAmount(long piRisokuAmount) {
		this.risokuAmount = piRisokuAmount;
	}

	/**
	 * 維持管理費を取得.
	 * 
	 * @return 維持管理費
	 */
	public long getIjiAmount() {
		return this.ijiAmount;
	}

	/**
	 * 維持管理費を設定.
	 * 
	 * @param piIjiAmount
	 *            維持管理費
	 */
	public void setIjiAmount(long piIjiAmount) {
		this.ijiAmount = piIjiAmount;
	}

	/**
	 * 役務提供費を取得.
	 * 
	 * @return 役務提供費
	 */
	public long getEkimuAmount() {
		return this.ekimuAmount;
	}

	/**
	 * 役務提供費を設定.
	 * 
	 * @param piEkimuAmount
	 *            役務提供費
	 */
	public void setEkimuAmount(long piEkimuAmount) {
		this.ekimuAmount = piEkimuAmount;
	}

	/**
	 * 償却費を取得.
	 * 
	 * @return 償却費
	 */
	public long getShoukyakuAmount() {
		return this.shoukyakuAmount;
	}

	/**
	 * 償却費を設定.
	 * 
	 * @param piShoukyakuAmount
	 *            償却費
	 */
	public void setShoukyakuAmount(long piShoukyakuAmount) {
		this.shoukyakuAmount = piShoukyakuAmount;
	}

}
