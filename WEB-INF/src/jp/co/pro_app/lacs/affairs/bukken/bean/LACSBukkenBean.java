package jp.co.pro_app.lacs.affairs.bukken.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSBeanBase;

/**
 * 物件検索Bean.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSBukkenBean extends LACSBeanBase {

	private static final long serialVersionUID = 1L;

	private String	keiyakuNo			= "";	// 契約番号

	private String	bukkenName			= "";	// 物件名

	private String	bukkenNameSerchPtn	= "";	// 物件名検索パターン

	/**
	 * コンストラクタ.
	 */
	public LACSBukkenBean() {
		this.setPageServlet("page.bukken");
	}

	/**
	 * 初期化.
	 */
	public void init() {
		this.keiyakuNo = "";
		this.bukkenName = "";
		this.bukkenNameSerchPtn = "1";

		super.init();
	}

	/**
	 * 明細行を追加.
	 * 
	 * @param piDetail
	 *            明細行
	 */
	public void addDetail(LACSBukkenDetailBean piDetail) {
		super.add(piDetail);
	}

	/**
	 * 明細行を取得.
	 * 
	 * @param piIdx
	 *            番号
	 * @return 明細行
	 */
	public LACSBukkenDetailBean getDetail(int piIdx) {
		return (LACSBukkenDetailBean)super.get(piIdx);
	}

	/**
	 * 契約番号を取得.
	 * 
	 * @return 契約番号
	 */
	public String getKeiyakuNo() {
		return this.keiyakuNo;
	}

	/**
	 * 契約番号を設定.
	 * 
	 * @param piKeiyakuNo
	 *            契約番号
	 */
	public void setKeiyakuNo(String piKeiyakuNo) {
		this.keiyakuNo = piKeiyakuNo;
	}

	/**
	 * 物件名を取得.
	 * 
	 * @return 物件名
	 */
	public String getBukkenName() {
		return this.bukkenName;
	}

	/**
	 * 物件名を設定.
	 * 
	 * @param piBukkenName
	 *            物件名
	 */
	public void setBukkenName(String piBukkenName) {
		this.bukkenName = piBukkenName;
	}

	/**
	 * 物件名検索パターンを取得.
	 * 
	 * @return 物件名検索パターン
	 */
	public String getBukkenNameSerchPtn() {
		return this.bukkenNameSerchPtn;
	}

	/**
	 * 物件名検索パターンを設定.
	 * 
	 * @param piBukkenNameSerchPtn
	 *            物件名検索パターン
	 */
	public void setBukkenNameSerchPtn(String piBukkenNameSerchPtn) {
		this.bukkenNameSerchPtn = piBukkenNameSerchPtn;
	}
}
