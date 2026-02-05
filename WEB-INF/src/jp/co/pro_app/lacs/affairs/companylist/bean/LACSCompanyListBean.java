package jp.co.pro_app.lacs.affairs.companylist.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSBeanBase;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.company.bean.LACSCompanyBean;

/**
 * リース会社マスタ一覧Bean.
 * 
 * @author active
 * @version 20071210
 */
public class LACSCompanyListBean extends LACSBeanBase {

	private static final long serialVersionUID = 1L;

	private String	leasCompanyCode	= "";	// リース会社コード

	private String	condCompanyCode	= "";	// リース会社コード(条件)

	/**
	 * コンストラクタ.
	 */
	public LACSCompanyListBean() {
		this.setPageServlet("page.companylist");
	}

	/**
	 * 初期化.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 */
	public void init(LACSCommonBean piCommonBean) {
		this.leasCompanyCode = "";
		this.condCompanyCode = "";

		super.init();
	}

	/**
	 * 明細を追加.
	 * 
	 * @param piDetail
	 *            明細
	 */
	public void addDetail(LACSCompanyBean piDetail) {
		super.add(piDetail);
	}

	/**
	 * 明細を取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 明細
	 */
	public LACSCompanyBean getDetail(int piIdx) {
		return (LACSCompanyBean)super.get(piIdx);
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

}
