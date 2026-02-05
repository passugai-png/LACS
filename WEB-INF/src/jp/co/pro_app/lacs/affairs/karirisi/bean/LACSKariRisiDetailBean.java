package jp.co.pro_app.lacs.affairs.karirisi.bean;

import jp.co.pro_app.projframe.common.bean.BeanBase;

/**
 * リースユーザー別借入利子率マスタ明細Bean.
 * 
 * @author ohmura
 * @version 20070919
 */
public class LACSKariRisiDetailBean extends BeanBase {

	private static final long serialVersionUID = 1L;

	private String	cosmosCode	= "";	// COSMOSコード

	private String	userName	= "";	// リースユーザー名

	private String	kikanTo		= "";	// 適用期間開始

	private String	kikanFrom	= "";	// 適用期間終了

	private String	risiRitu	= "";	// 自社借入利率

	private int		count		= 0;	// 件数

	/**
	 * COSMOSコードを取得.
	 * 
	 * @return COSMOSコード
	 */
	public String getCosmosCode() {
		return this.cosmosCode;
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
	 * 適用期間開始を取得.
	 * 
	 * @return 適用期間開始
	 */
	public String getKikanTo() {
		return this.kikanTo;
	}

	/**
	 * 適用期間開始を設定.
	 * 
	 * @param piKikanTo
	 *            適用期間開始
	 */
	public void setKikanTo(String piKikanTo) {
		this.kikanTo = piKikanTo;
	}

	/**
	 * 適用期間終了を取得.
	 * 
	 * @return 適用期間終了
	 */
	public String getKikanFrom() {
		return this.kikanFrom;
	}

	/**
	 * 適用期間終了を設定.
	 * 
	 * @param piKikanFrom
	 *            適用期間終了
	 */
	public void setKikanFrom(String piKikanFrom) {
		this.kikanFrom = piKikanFrom;
	}

	/**
	 * 自社借入利率を取得.
	 * 
	 * @return 自社借入利率
	 */
	public String getRisiRitu() {
		return this.risiRitu;
	}

	/**
	 * 自社借入利率を設定.
	 * 
	 * @param piRisiRitu
	 *            自社借入利率
	 */
	public void setRisiRitu(String piRisiRitu) {
		this.risiRitu = piRisiRitu;
	}

	/**
	 * 件数を取得.
	 * 
	 * @return 件数
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * 件数を設定.
	 * 
	 * @param piCount
	 *            件数
	 */
	public void setCount(int piCount) {
		this.count = piCount;
	}

	/**
	 * リースユーザー名を取得.
	 * 
	 * @return リースユーザー名
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * リースユーザー名を設定.
	 * 
	 * @param piUserName
	 *            リースユーザー名
	 */
	public void setUserName(String piUserName) {
		this.userName = piUserName;
	}
}
