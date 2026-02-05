package jp.co.pro_app.lacs.affairs.companyuserlist.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSBeanBase;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.companyuser.bean.LACSCompanyUserBean;

/**
 * リース会社別リースユーザーマスタ一覧Bean.
 * 
 * @author active
 * @version 20071210
 */
public class LACSCompanyUserListBean extends LACSBeanBase {

	private static final long serialVersionUID = 1L;

	private String	leasCompanyCode	= "";	// リース会社コード

	private String	torihikiCode	= "";	// リースユーザー取引先コード

	private String	cosmosCode		= "";	// COSMOSコード

	/**
	 * コンストラクタ.
	 */
	public LACSCompanyUserListBean() {
		super.setPageServlet("page.companyuserlist");
	}

	/**
	 * 初期化.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 */
	public void init(LACSCommonBean piCommonBean) {
		this.leasCompanyCode = "";
		this.torihikiCode = "";
		this.cosmosCode = "";

		super.init();
	}

	/**
	 * 明細を追加.
	 * 
	 * @param piDetail
	 *            明細
	 */
	public void addDetail(LACSCompanyUserBean piDetail) {
		super.add(piDetail);
	}

	/**
	 * 明細を取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 明細
	 */
	public LACSCompanyUserBean getDetail(int piIdx) {
		return (LACSCompanyUserBean)super.get(piIdx);
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

}
