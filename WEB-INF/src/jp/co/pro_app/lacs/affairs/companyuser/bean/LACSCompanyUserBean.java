package jp.co.pro_app.lacs.affairs.companyuser.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSMaintenanceBeanBase;

/**
 * リース会社別リースユーザーマスタBean.
 * 
 * @author takeda
 * @version 20070907
 */
public class LACSCompanyUserBean extends LACSMaintenanceBeanBase {

	private static final long serialVersionUID = 1L;

	private String	leasCompanyCode		= "";	// リース会社コード

	private String	torihikiCode		= "";	// リースユーザー取引先コード

	private String	cosmosCode			= "";	// リースユーザーCOSMOSコード

	private String	teikyouYMD			= "";	// 最新データ提供年月日

	private String	teikyouYM			= "";	// 最新データ提供月

	private String	condCompanyCode		= "";	// リース会社コード(条件)

	private String	condTorihikiCode	= "";	// 取引先コード(条件)

	private String	condCosmosCode		= "";	// COSMOSコード(条件)

	private String	userName			= "";	// リースユーザー名

	private String	leasCompanyNm		= "";	// 開示先コード(条件)

	private String	leasCompany			= "";	// 絞込(条件)

	private int		pageNo;					// 現ページ保持

	/**
	 * コンストラクタ.
	 */
	public LACSCompanyUserBean() {
	}

	/**
	 * 初期化.
	 */
	public void init() {
		this.leasCompanyCode = "";
		this.torihikiCode = "";

		super.init();
	}

	/**
	 * リース会社コードを取得.
	 * 
	 * @return リース会社コード
	 */
	public String getLeasCompanyCode() {
		return this.leasCompanyCode;
	}

	/**
	 * リース会社コードを設定.
	 * 
	 * @param piLeasCompanyCode
	 *            リース会社コード
	 */
	public void setLeasCompanyCode(String piLeasCompanyCode) {
		this.leasCompanyCode = piLeasCompanyCode;
	}

	/**
	 * リースユーザー取引先コードを取得.
	 * 
	 * @return リースユーザー取引先コード
	 */
	public String getTorihikiCode() {
		return this.torihikiCode;
	}

	/**
	 * リースユーザー取引先コードを設定.
	 * 
	 * @param piTorihikiCode
	 *            リースユーザー取引先コード
	 */
	public void setTorihikiCode(String piTorihikiCode) {
		this.torihikiCode = piTorihikiCode;
	}

	/**
	 * リースユーザーCOSMOSコードを取得.
	 * 
	 * @return リースユーザーCOSMOSコード
	 */
	public String getCosmosCode() {
		return this.cosmosCode;
	}

	/**
	 * リースユーザーCOSMOSコードを設定.
	 * 
	 * @param piCosmosCode
	 *            リースユーザーCOSMOSコード
	 */
	public void setCosmosCode(String piCosmosCode) {
		this.cosmosCode = piCosmosCode;
	}

	/**
	 * 最新データ提供年月日を取得.
	 * 
	 * @return 最新データ提供年月日
	 */
	public String getTeikyouYMD() {
		return this.teikyouYMD;
	}

	/**
	 * 最新データ提供年月日を設定.
	 * 
	 * @param piTeikyouYMD
	 *            最新データ提供年月日
	 */
	public void setTeikyouYMD(String piTeikyouYMD) {
		this.teikyouYMD = piTeikyouYMD;
	}

	/**
	 * 最新データ提供月を取得.
	 * 
	 * @return 最新データ提供月
	 */
	public String getTeikyouYM() {
		return this.teikyouYM;
	}

	/**
	 * 最新データ提供月を設定.
	 * 
	 * @param piTeikyouYM
	 *            最新データ提供月
	 */
	public void setTeikyouYM(String piTeikyouYM) {
		this.teikyouYM = piTeikyouYM;
	}

	/**
	 * リース会社コード(条件)を取得.
	 * 
	 * @return リース会社コード(条件)
	 */
	public String getCondCompanyCode() {
		return this.condCompanyCode;
	}

	/**
	 * リース会社コード(条件)を設定.
	 * 
	 * @param piCondCompanyCode
	 *            リース会社コード(条件)
	 */
	public void setCondCompanyCode(String piCondCompanyCode) {
		this.condCompanyCode = piCondCompanyCode;
	}

	/**
	 * 取引先コード(条件)を取得.
	 * 
	 * @return 取引先コード(条件)
	 */
	public String getCondTorihikiCode() {
		return this.condTorihikiCode;
	}

	/**
	 * 取引先コード(条件)を設定.
	 * 
	 * @param piCondTorihikiCode
	 *            取引先コード(条件)
	 */
	public void setCondTorihikiCode(String piCondTorihikiCode) {
		this.condTorihikiCode = piCondTorihikiCode;
	}

	/**
	 * COSMOSコード(条件)を取得.
	 * 
	 * @return COSMOSコード(条件)
	 */
	public String getCondCosmosCode() {
		return this.condCosmosCode;
	}

	/**
	 * COSMOSコード(条件)を設定.
	 * 
	 * @param piCondCosmosCode
	 *            COSMOSコード(条件)
	 */
	public void setCondCosmosCode(String piCondCosmosCode) {
		this.condCosmosCode = piCondCosmosCode;
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

	/**
	 * 絞込(条件)を取得.
	 * 
	 * @return 絞込(条件)
	 */
	public String getleasCompany() {
		return this.leasCompany;
	}

	/**
	 * 絞込(条件)を設定.
	 * 
	 * @param piLeasCompany
	 *            絞込(条件)
	 */
	public void setleasCompany(String piLeasCompany) {
		this.leasCompany = piLeasCompany;
	}

	/**
	 * 開示先コード(条件)を取得.
	 * 
	 * @return 開示先コード(条件)
	 */
	public String getleasCompanyNm() {
		return this.leasCompanyNm;
	}

	/**
	 * 開示先コード(条件)を設定.
	 * 
	 * @param piLeasCompanyNm
	 *            開示先コード(条件)
	 */
	public void setleasCompanyNm(String piLeasCompanyNm) {
		this.leasCompanyNm = piLeasCompanyNm;
	}

	/**
	 * 現在ページを取得.
	 * 
	 * @return 現在ページ
	 */
	public int getPageNo() {
		return this.pageNo;
	}

	/**
	 * 現在ページを設定.
	 * 
	 * @param piPageNo
	 *            現在ページ
	 */
	public void setPageNo(int piPageNo) {
		this.pageNo = piPageNo;
	}

}
