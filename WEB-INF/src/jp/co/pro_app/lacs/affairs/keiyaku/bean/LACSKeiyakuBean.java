package jp.co.pro_app.lacs.affairs.keiyaku.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSBeanBase;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSDateBean;
import jp.co.pro_app.projframe.common.html.ComboArray;

/**
 * 契約検索Bean.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSKeiyakuBean extends LACSBeanBase {

	private static final long serialVersionUID = 1L;

	private String			daihyoBukkenName	= "";					// 物件番号代表物件名

	private LACSDateBean	kenshuFrom			= new LACSDateBean();	// 検収年月From

	private LACSDateBean	kenshuTo			= new LACSDateBean();	// 検収年月To

	private LACSDateBean	manryoFrom			= new LACSDateBean();	// 満了年月From

	private LACSDateBean	manryoTo			= new LACSDateBean();	// 満了年月To

	private LACSDateBean	kaiyakuFrom			= new LACSDateBean();	// 解約年月From

	private LACSDateBean	kaiyakuTo			= new LACSDateBean();	// 解約年月To

	private String			keiyakuNo			= "";					// 契約番号

	private String			keiyakuAmtChk		= "";					// 契約金額 チェック

	private String			keiyakuAmt			= "";					// 契約金額

	private String			keiyakuTermChk		= "";					// 契約期間 チェック

	private String			keiyakuTerm			= "";					// 契約期間

	private String			kenPatn				= "";					// 代表 物件検索パターン

	private String			keiyakuRls			= "";					// 再リース指定

	/**
	 * コンストラクタ.
	 */
	public LACSKeiyakuBean() {
		this.setPageServlet("page.keiyaku");
	}

	/**
	 * 初期化.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 */
	public void init(LACSCommonBean piCommonBean) {
		this.daihyoBukkenName = "";
		this.keiyakuNo = "";
		this.keiyakuAmtChk = "";
		this.keiyakuAmt = "";
		this.keiyakuTermChk = "";
		this.keiyakuTerm = "";
		this.kenPatn = "1";
		this.keiyakuRls = "1";

		this.kenshuFrom = new LACSDateBean(piCommonBean);
		this.kenshuFrom.setName("kenshuFrom");

		this.kenshuTo = new LACSDateBean(piCommonBean);
		this.kenshuTo.setName("kenshuTo");

		this.manryoFrom = new LACSDateBean(piCommonBean);
		this.manryoFrom.setName("manryoFrom");

		this.manryoTo = new LACSDateBean(piCommonBean);
		this.manryoTo.setName("manryoTo");

		this.kaiyakuFrom = new LACSDateBean(piCommonBean);
		this.kaiyakuFrom.setName("kaiyakuFrom");

		this.kaiyakuTo = new LACSDateBean(piCommonBean);
		this.kaiyakuTo.setName("kaiyakuTo");

		super.init();
	}

	/**
	 * 和暦コンボボックスを設定.
	 * 
	 * @param piComboArray
	 *            和暦コンボボックス
	 */
	public void setWarekiConbo(ComboArray piComboArray) {
		piComboArray.setSelectedFalse();
		this.kenshuFrom.setEra(piComboArray.copy());
		this.kenshuTo.setEra(piComboArray.copy());
		this.manryoFrom.setEra(piComboArray.copy());
		this.manryoTo.setEra(piComboArray.copy());
		this.kaiyakuFrom.setEra(piComboArray.copy());
		this.kaiyakuTo.setEra(piComboArray.copy());
	}

	/**
	 * 明細を追加.
	 * 
	 * @param piDetail
	 *            明細
	 */
	public void addDetail(LACSKeiyakuDetailBean piDetail) {
		super.add(piDetail);
	}

	/**
	 * 明細を取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 明細
	 */
	public LACSKeiyakuDetailBean getDetail(int piIdx) {
		return (LACSKeiyakuDetailBean)super.get(piIdx);
	}

	/**
	 * 物件番号代表物件名を取得.
	 * 
	 * @return 物件番号代表物件名
	 */
	public String getDaihyoBukkenName() {
		return this.daihyoBukkenName;
	}

	/**
	 * 物件番号代表物件名を設定.
	 * 
	 * @param piDaihyoBukkenName
	 *            物件番号代表物件名
	 */
	public void setDaihyoBukkenName(String piDaihyoBukkenName) {
		this.daihyoBukkenName = piDaihyoBukkenName;
	}

	/**
	 * 検収年月Fromを取得.
	 * 
	 * @return 検収年月From
	 */
	public LACSDateBean getKenshuFrom() {
		return this.kenshuFrom;
	}

	/**
	 * 検収年月Toを取得.
	 * 
	 * @return 検収年月To
	 */
	public LACSDateBean getKenshuTo() {
		return this.kenshuTo;
	}

	/**
	 * 満了年月Fromを取得.
	 * 
	 * @return 満了年月From
	 */
	public LACSDateBean getManryoFrom() {
		return this.manryoFrom;
	}

	/**
	 * 満了年月Toを取得.
	 * 
	 * @return 満了年月To
	 */
	public LACSDateBean getManryoTo() {
		return this.manryoTo;
	}

	/**
	 * 解約年月Fromを取得.
	 * 
	 * @return 解約年月From
	 */
	public LACSDateBean getKaiyakuFrom() {
		return this.kaiyakuFrom;
	}

	/**
	 * 解約年月Toを取得.
	 * 
	 * @return 解約年月To
	 */
	public LACSDateBean getKaiyakuTo() {
		return this.kaiyakuTo;
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
	 * 契約金額チェックを取得.
	 * 
	 * @return 契約金額チェック
	 */
	public String getKeiyakuAmtChk() {
		return this.keiyakuAmtChk;
	}

	/**
	 * 契約金額チェックを設定.
	 * 
	 * @param piKeiyakuAmtChk
	 *            契約金額チェック
	 */
	public void setKeiyakuAmtChk(String piKeiyakuAmtChk) {
		this.keiyakuAmtChk = piKeiyakuAmtChk;
	}

	/**
	 * 契約金額を取得.
	 * 
	 * @return 契約金額
	 */
	public String getKeiyakuAmt() {
		return this.keiyakuAmt;
	}

	/**
	 * 契約金額を設定.
	 * 
	 * @param piKeiyakuAmt
	 *            契約金額
	 */
	public void setKeiyakuAmt(String piKeiyakuAmt) {
		this.keiyakuAmt = piKeiyakuAmt;
	}

	/**
	 * 契約期間チェックを取得.
	 * 
	 * @return 契約期間チェック
	 */
	public String getKeiyakuTermChk() {
		return this.keiyakuTermChk;
	}

	/**
	 * 契約期間チェックを設定.
	 * 
	 * @param piKeiyakuTermChk
	 *            契約期間チェック
	 */
	public void setKeiyakuTermChk(String piKeiyakuTermChk) {
		this.keiyakuTermChk = piKeiyakuTermChk;
	}

	/**
	 * 契約期間を取得.
	 * 
	 * @return 契約期間
	 */
	public String getKeiyakuTerm() {
		return this.keiyakuTerm;
	}

	/**
	 * 契約期間を設定.
	 * 
	 * @param piKeiyakuTerm
	 *            契約期間
	 */
	public void setKeiyakuTerm(String piKeiyakuTerm) {
		this.keiyakuTerm = piKeiyakuTerm;
	}

	/**
	 * 代表物件検索パターンを取得.
	 * 
	 * @return 代表 物件検索パターン
	 */
	public String getKenPatn() {
		return this.kenPatn;
	}

	/**
	 * 代表物件検索パターンを設定.
	 * 
	 * @param piKenPatn
	 *            代表物件検索パターン
	 */
	public void setKenPatn(String piKenPatn) {
		this.kenPatn = piKenPatn;
	}

	/**
	 * 再リース指定を取得.
	 * 
	 * @return 再リース指定
	 */
	public String getKeiyakuRls() {
		return this.keiyakuRls;
	}

	/**
	 * 再リース指定を設定.
	 * 
	 * @param piKeiyakuRls
	 *            再リース指定
	 */
	public void setKeiyakuRls(String piKeiyakuRls) {
		this.keiyakuRls = piKeiyakuRls;
	}

}
