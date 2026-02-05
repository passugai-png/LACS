package jp.co.pro_app.lacs.affairs.karirisi.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSMaintenanceBeanBase;

/**
 * リースユーザー別借入利子率マスタBean.
 * 
 * @author ohmura
 * @version 20070918
 */
public class LACSKariRisiBean extends LACSMaintenanceBeanBase {

	private static final long serialVersionUID = 1L;

	private String	cosmosCode		= "";	// COSMOSコード

	private String	condCosmosCode	= "";	// COSMOSコード(条件)

	private int		retuSu			= 0;	// 表示列数

	private String	username		= "";	// 開示先名称

	private String	leasCompanyNm	= "";	// 開示先コード(条件)

	private String	leasCompany		= "";	// 絞込(条件)

	private int		pageNo;				// 現ページ保持

	/**
	 * コンストラクタ.
	 */
	public LACSKariRisiBean() {
		super.setPageServlet("page.karirisilist");
	}

	/**
	 * 初期化.
	 */
	public void init() {
		this.cosmosCode = "";
		this.retuSu = 0;

		super.init();
	}

	/**
	 * 表示列数を取得.
	 * 
	 * @return 表示列数
	 */
	public int getRetuSu() {
		return this.retuSu;
	}

	/**
	 * 表示列数を設定.
	 * 
	 * @param piRetuSu
	 *            表示列数
	 */
	public void setRetuSu(int piRetuSu) {
		this.retuSu = piRetuSu;
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
	 * 明細を追加.
	 * 
	 * @param piDetail
	 *            明細
	 */
	public void addDetail(LACSKariRisiDetailBean piDetail) {
		super.add(piDetail);
	}

	/**
	 * 明細を取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 明細
	 */
	public LACSKariRisiDetailBean getDetail(int piIdx) {
		return (LACSKariRisiDetailBean)super.get(piIdx);
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
	 * 開示先名称を取得.
	 * 
	 * @return 開示先名称
	 */
	public String getUserName() {
		return this.username;
	}

	/**
	 * 開示先名称を設定.
	 * 
	 * @param piUserName
	 *            開示先名称
	 */
	public void setUserName(String piUserName) {
		this.username = piUserName;
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
