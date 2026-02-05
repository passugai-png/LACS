package jp.co.pro_app.lacs.affairs.info.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSMaintenanceBeanBase;

/**
 * お知らせBean.
 * 
 * @author takeda
 * @version 20070907
 */
public class LACSInfoBean extends LACSMaintenanceBeanBase {

	private static final long serialVersionUID = 1L;

	private String	startYmd		= "";	// 期間開始

	private String	endYmd			= "";	// 期間終了

	private String	infoData		= "";	// 内容

	private String	rowId			= "";	// ROWID

	private String	condStartYmd	= "";	// 期間開始(条件)

	private String	condEndYmd		= "";	// 期間終了(条件)

	private String	condInfoData	= "";	// 内容(条件)

	private int		pageNo;				// 現ページ保持

	private String	userCosmosCode	= "";	// COSMOSコード

	private String	userName		= "";	// 開示先名

	/**
	 * コンストラクタ.
	 */
	public LACSInfoBean() {
	}

	/**
	 * 初期化.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 */
	public void init(LACSCommonBean piCommonBean) {
		this.startYmd = "";
		this.endYmd = "";
		this.infoData = "";
		this.rowId = "";
		this.userCosmosCode = "";
		this.userName = "";

		super.init();
	}

	/**
	 * 期間開始を取得.
	 * 
	 * @return 期間開始
	 */
	public String getStartYmd() {
		return this.startYmd;
	}

	/**
	 * 期間開始を設定.
	 * 
	 * @param piStartYmd
	 *            期間開始
	 */
	public void setStartYmd(String piStartYmd) {
		this.startYmd = piStartYmd;
	}

	/**
	 * 期間終了を取得.
	 * 
	 * @return 期間終了
	 */
	public String getEndYmd() {
		return this.endYmd;
	}

	/**
	 * 期間終了を設定.
	 * 
	 * @param piEndYmd
	 *            期間終了
	 */
	public void setEndYmd(String piEndYmd) {
		this.endYmd = piEndYmd;
	}

	/**
	 * 内容を取得.
	 * 
	 * @return 内容
	 */
	public String getInfoData() {
		return this.infoData;
	}

	/**
	 * 内容を設定.
	 * 
	 * @param piInfoData
	 *            内容
	 */
	public void setInfoData(String piInfoData) {
		this.infoData = piInfoData;
	}

	/**
	 * ROWIDを取得.
	 * 
	 * @return ROWID
	 */
	public String getRowId() {
		return this.rowId;
	}

	/**
	 * ROWIDを設定.
	 * 
	 * @param piRowId
	 *            ROWID
	 */
	public void setRowId(String piRowId) {
		this.rowId = piRowId;
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

	/**
	 * COSMOSコードを取得.
	 * 
	 * @return COSMOSコード
	 */
	public String getCondUserCosmosCode() {
		return this.userCosmosCode;
	}

	/**
	 * COSMOSコードを設定.
	 * 
	 * @param piUserCosmosCode
	 *            COSMOSコード
	 */
	public void setCondUserCosmosCode(String piUserCosmosCode) {
		this.userCosmosCode = piUserCosmosCode;
	}

	/**
	 * 開示先名を取得.
	 * 
	 * @return 開示先名
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * 開示先名を設定.
	 * 
	 * @param piUserName
	 *            開示先名
	 */
	public void setUserName(String piUserName) {
		this.userName = piUserName;
	}
}
