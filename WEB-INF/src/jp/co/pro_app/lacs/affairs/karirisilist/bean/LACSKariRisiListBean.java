package jp.co.pro_app.lacs.affairs.karirisilist.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSMaintenanceBeanBase;
import jp.co.pro_app.lacs.affairs.karirisi.bean.LACSKariRisiBean;

/**
 * リースユーザー別借入利子率マスタ一覧Bean.
 * 
 * @author active
 * @version 20071210
 */
public class LACSKariRisiListBean extends LACSMaintenanceBeanBase {

	private static final long serialVersionUID = 1L;
	
	private String	cosmosCode	= "";	// COSMOSコード

	/**
	 * コンストラクタ.
	 */
	public LACSKariRisiListBean() {
		super.setPageServlet("page.karirisilist");
	}

	/**
	 * 初期化.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 */
	public void init(LACSCommonBean piCommonBean) {
		this.cosmosCode = "";

		super.init();
	}

	/**
	 * 明細を追加.
	 * 
	 * @param piDetail
	 *            明細
	 */
	public void addDetail(LACSKariRisiBean piDetail) {
		super.add(piDetail);
	}

	/**
	 * 明細を取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 明細
	 */
	public LACSKariRisiBean getDetail(int piIdx) {
		return (LACSKariRisiBean)super.get(piIdx);
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
