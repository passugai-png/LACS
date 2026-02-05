package jp.co.pro_app.lacs.affairs.tantolist.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSBeanBase;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;

/**
 * リースユーザー担当者マスタ一覧Bean.
 * 
 * @author active
 * @version 20071210
 */
public class LACSTantoListBean extends LACSBeanBase {

	private static final long serialVersionUID = 1L;

	private String	userID		= "";	// ユーザーID

	private String	cosmosCode	= "";	// COSMOSコード

	private String	userRight	= "";	// 利用者権限

	/**
	 * コンストラクタ.
	 */
	public LACSTantoListBean() {
		super.setPageServlet("page.tantolist");
	}

	/**
	 * 初期化.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 */
	public void init(LACSCommonBean piCommonBean) {
		this.userID = "";
		this.userRight = "0";

		super.init();
	}

	/**
	 * 明細を追加.
	 * 
	 * @param piDetail
	 *            明細
	 */
	public void addDetail(LACSTantoListDetailBean piDetail) {
		super.add(piDetail);
	}

	/**
	 * 明細を取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 明細
	 */
	public LACSTantoListDetailBean getDetail(int piIdx) {
		return (LACSTantoListDetailBean)super.get(piIdx);
	}

	/**
	 * ユーザーIDを取得.
	 * 
	 * @return ユーザーID
	 */
	public String getUserID() {
		return this.userID;
	}

	/**
	 * ユーザーIDを設定.
	 * 
	 * @param piUserID
	 *            ユーザーID
	 */
	public void setUserID(String piUserID) {
		this.userID = piUserID;
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

	/**
	 * 利用者権限を取得.
	 * 
	 * @return 利用者権限
	 */
	public String getUserRight() {
		return this.userRight;
	}

	/**
	 * 利用者権限を設定.
	 * 
	 * @param piUserRight
	 *            利用者権限
	 */
	public void setUserRight(String piUserRight) {
		this.userRight = piUserRight;
	}

}
