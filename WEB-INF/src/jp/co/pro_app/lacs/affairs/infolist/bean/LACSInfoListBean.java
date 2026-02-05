package jp.co.pro_app.lacs.affairs.infolist.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSBeanBase;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.info.bean.LACSInfoBean;

/**
 * お知らせ一覧Bean.
 * 
 * @author active
 * @version 20071210
 */
public class LACSInfoListBean extends LACSBeanBase {

	private static final long serialVersionUID = 1L;

	private String	condStartYmd	= "";	// 期間開始(条件)

	private String	condEndYmd		= "";	// 期間終了(条件)

	private String	condInfoData	= "";	// 内容(条件)

	private String	condcosmosCode	= "";	// COSMOSコード

	/**
	 * コンストラクタ.
	 */
	public LACSInfoListBean() {
		super.setPageServlet("page.infolist");
	}

	/**
	 * 初期化.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 */
	public void init(LACSCommonBean piCommonBean) {
		this.condStartYmd = "";
		this.condEndYmd = "";
		this.condInfoData = "";

		this.condcosmosCode = "";

		super.init();
	}

	/**
	 * 明細を追加.
	 * 
	 * @param piDetail
	 *            明細
	 */
	public void addDetail(LACSInfoBean piDetail) {
		super.add(piDetail);
	}

	/**
	 * 明細を取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 明細
	 */
	public LACSInfoBean getDetail(int piIdx) {
		return (LACSInfoBean)super.get(piIdx);
	}

	/**
	 * 期間開始(条件)を取得.
	 * 
	 * @return 期間開始(条件)
	 */
	public String getCondStartYmd() {
		return this.condStartYmd;
	}

	/**
	 * 期間開始(条件)を設定.
	 * 
	 * @param piCondStartYmd
	 *            期間開始(条件)
	 */
	public void setCondStartYmd(String piCondStartYmd) {
		this.condStartYmd = piCondStartYmd;
	}

	/**
	 * 期間終了(条件)を取得.
	 * 
	 * @return 期間終了(条件)
	 */
	public String getCondEndYmd() {
		return this.condEndYmd;
	}

	/**
	 * 期間終了(条件)を設定.
	 * 
	 * @param piCondEndYmd
	 *            期間終了(条件)
	 */
	public void setCondEndYmd(String piCondEndYmd) {
		this.condEndYmd = piCondEndYmd;
	}

	/**
	 * 内容(条件)を取得.
	 * 
	 * @return 内容(条件)
	 */
	public String getCondInfoData() {
		return this.condInfoData;
	}

	/**
	 * 内容(条件)を設定.
	 * 
	 * @param piCondInfoData
	 *            内容(条件)
	 */
	public void setCondInfoData(String piCondInfoData) {
		this.condInfoData = piCondInfoData;
	}

	/**
	 * COSMOSコードを取得.
	 * 
	 * @return COSMOSコード
	 */
	public String getCosmosCode() {
		return this.condcosmosCode;
	}

	/**
	 * COSMOSコードを設定.
	 * 
	 * @param piCosmosCode
	 *            COSMOSコード
	 */
	public void setCosmosCode(String piCosmosCode) {
		this.condcosmosCode = piCosmosCode;
	}

}
