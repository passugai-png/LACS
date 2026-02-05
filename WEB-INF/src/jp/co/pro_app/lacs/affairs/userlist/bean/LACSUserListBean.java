package jp.co.pro_app.lacs.affairs.userlist.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSBeanBase;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.user.bean.LACSUserBean;

/**
 * リースユーザーマスタ一覧Bean.
 * 
 * @author active
 * @version 20071210
 */
public class LACSUserListBean extends LACSBeanBase {

	private static final long serialVersionUID = 1L;
	
	private String	cosmosCode	= "";	// COSMOSコード

	/**
	 * コンストラクタ.
	 */
	public LACSUserListBean() {
		this.setPageServlet("page.userlist");
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
	public void addDetail(LACSUserBean piDetail) {
		super.add(piDetail);
	}

	/**
	 * 明細を取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 明細
	 */
	public LACSUserBean getDetail(int piIdx) {
		return (LACSUserBean)super.get(piIdx);
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
