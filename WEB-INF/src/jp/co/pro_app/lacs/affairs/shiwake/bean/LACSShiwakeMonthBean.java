package jp.co.pro_app.lacs.affairs.shiwake.bean;

import java.util.ArrayList;

import jp.co.pro_app.projframe.common.bean.BeanBase;

/**
 * 仕訳照会明細Bean.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiwakeMonthBean extends BeanBase {

	private static final long serialVersionUID = 1L;

	private String		date		= "";				// 年月

	private long		leasAmount	= 0;				// リース料

	private ArrayList<LACSShiwakeDetailBean>	detail		= new ArrayList<LACSShiwakeDetailBean>();

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
	 * 詳細数を取得.
	 * 
	 * @return 詳細数
	 */
	public int size() {
		return detail.size();
	}

	/**
	 * 詳細を取得.
	 * 
	 * @param piIdx
	 *            番号
	 * @return 詳細
	 */
	public LACSShiwakeDetailBean get(int piIdx) {
		return (LACSShiwakeDetailBean)detail.get(piIdx);
	}

	/**
	 * 詳細を追加.
	 * 
	 * @param piDetail
	 *            詳細
	 */
	public void add(LACSShiwakeDetailBean piDetail) {
		detail.add(piDetail);
	}
}
