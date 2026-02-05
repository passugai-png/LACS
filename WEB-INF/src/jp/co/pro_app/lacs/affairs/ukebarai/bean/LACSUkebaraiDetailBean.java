package jp.co.pro_app.lacs.affairs.ukebarai.bean;

/**
 * 受払合計表明細Bean.
 * 
 * @author active
 * @version 20080808
 */
public class LACSUkebaraiDetailBean extends LACSUkebaraiBean {

	private static final long serialVersionUID = 1L;

	private int		tateDispIdx	= 0;		// 縦表示インデックス

	private String	ctshkFlag	= "";		// 賃貸借フラグ

	private String	kamokuNm	= "";		// 科目名

	private long	zenCost		= 0;		// 前期末残高 or 前期末累計

	private long	touzouCost	= 0;		// 当期増加

	private long	toujitCost	= 0;		// 当期実現

	private long	tougenCost	= 0;		// 当期減少

	private long	touzanCost	= 0;		// 当期末残高

	private boolean	zenFlag		= false;	// 前期末表示フラグ

	private boolean	touzouFlag	= false;	// 当期増加表示フラグ

	private boolean	toujitFlag	= false;	// 当期実現表示フラグ

	private boolean	tougenFlag	= false;	// 当期減少表示フラグ

	private boolean	touzanFlag	= false;	// 当期末残高表示フラグ

	/**
	 * 賃貸借フラグを取得.
	 * 
	 * @return 賃貸借フラグ
	 */
	public String getCtshkFlag() {
		return this.ctshkFlag;
	}

	/**
	 * 賃貸借フラグを設定.
	 * 
	 * @param piCtshkFlag
	 *            賃貸借フラグ
	 */
	public void setCtshkFlag(String piCtshkFlag) {
		this.ctshkFlag = piCtshkFlag;
	}

	/**
	 * 科目名を取得.
	 * 
	 * @return 科目名
	 */
	public String getKamokuNm() {
		return this.kamokuNm;
	}

	/**
	 * 科目名を設定.
	 * 
	 * @param piKamokuNm
	 *            科目名
	 */
	public void setKamokuNm(String piKamokuNm) {
		this.kamokuNm = piKamokuNm;
	}

	/**
	 * 縦表示インデックスを取得.
	 * 
	 * @return 縦表示インデックス
	 */
	public int getTateDispIdx() {
		return this.tateDispIdx;
	}

	/**
	 * 縦表示インデックスを設定.
	 * 
	 * @param piTateDispIdx
	 *            縦表示インデックス
	 */
	public void setTateDispIdx(int piTateDispIdx) {
		this.tateDispIdx = piTateDispIdx;
	}

	/**
	 * 当期減少を取得.
	 * 
	 * @return 当期減少
	 */
	public long getTougenCost() {
		return this.tougenCost;
	}

	/**
	 * 当期減少を設定.
	 * 
	 * @param piTougenCost
	 *            当期減少
	 */
	public void setTougenCost(long piTougenCost) {
		this.tougenCost = piTougenCost;
	}

	/**
	 * 当期実現を取得.
	 * 
	 * @return 当期実現
	 */
	public long getToujitCost() {
		return this.toujitCost;
	}

	/**
	 * 当期実現を設定.
	 * 
	 * @param piToujitCost
	 *            当期実現
	 */
	public void setToujitCost(long piToujitCost) {
		this.toujitCost = piToujitCost;
	}

	/**
	 * 当期末残高を取得.
	 * 
	 * @return 当期末残高
	 */
	public long getTouzanCost() {
		return this.touzanCost;
	}

	/**
	 * 当期末残高を設定.
	 * 
	 * @param piTouzanCost
	 *            当期末残高
	 */
	public void setTouzanCost(long piTouzanCost) {
		this.touzanCost = piTouzanCost;
	}

	/**
	 * 当期増加を取得.
	 * 
	 * @return 当期増加
	 */
	public long getTouzouCost() {
		return this.touzouCost;
	}

	/**
	 * 当期増加を設定.
	 * 
	 * @param piTouzouCost
	 *            当期増加
	 */
	public void setTouzouCost(long piTouzouCost) {
		this.touzouCost = piTouzouCost;
	}

	/**
	 * 前期末残高 or 前期末累計を取得.
	 * 
	 * @return 前期末残高 or 前期末累計
	 */
	public long getZenCost() {
		return this.zenCost;
	}

	/**
	 * 前期末残高 or 前期末累計を設定.
	 * 
	 * @param piZenCost
	 *            前期末残高 or 前期末累計
	 */
	public void setZenCost(long piZenCost) {
		this.zenCost = piZenCost;
	}

	/**
	 * 当期減少表示フラグを取得.
	 * 
	 * @return 当期減少表示フラグ
	 */
	public boolean isTougenFlag() {
		return this.tougenFlag;
	}

	/**
	 * 当期減少表示フラグを設定.
	 * 
	 * @param piTougenFlag
	 *            当期減少表示フラグ
	 */
	public void setTougenFlag(boolean piTougenFlag) {
		this.tougenFlag = piTougenFlag;
	}

	/**
	 * 当期実現表示フラグを取得.
	 * 
	 * @return 当期実現表示フラグ
	 */
	public boolean isToujitFlag() {
		return this.toujitFlag;
	}

	/**
	 * 当期実現表示フラグを設定.
	 * 
	 * @param piToujitFlag
	 *            当期実現表示フラグ
	 */
	public void setToujitFlag(boolean piToujitFlag) {
		this.toujitFlag = piToujitFlag;
	}

	/**
	 * 当期末残高表示フラグを取得.
	 * 
	 * @return 当期末残高表示フラグ
	 */
	public boolean isTouzanFlag() {
		return this.touzanFlag;
	}

	/**
	 * 当期末残高表示フラグを設定.
	 * 
	 * @param piTouzanFlag
	 *            当期末残高表示フラグ
	 */
	public void setTouzanFlag(boolean piTouzanFlag) {
		this.touzanFlag = piTouzanFlag;
	}

	/**
	 * 当期増加表示フラグを取得.
	 * 
	 * @return 当期増加表示フラグ
	 */
	public boolean isTouzouFlag() {
		return this.touzouFlag;
	}

	/**
	 * 当期増加表示フラグを設定.
	 * 
	 * @param piTouzouFlag
	 *            当期増加表示フラグ
	 */
	public void setTouzouFlag(boolean piTouzouFlag) {
		this.touzouFlag = piTouzouFlag;
	}

	/**
	 * 前期末表示フラグを取得.
	 * 
	 * @return 前期末表示フラグ
	 */
	public boolean isZenFlag() {
		return this.zenFlag;
	}

	/**
	 * 前期末表示フラグを設定.
	 * 
	 * @param piZenFlag
	 *            前期末表示フラグ
	 */
	public void setZenFlag(boolean piZenFlag) {
		this.zenFlag = piZenFlag;
	}

}
