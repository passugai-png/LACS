package jp.co.pro_app.lacs.affairs.ukebarai.bean;

import java.util.ArrayList;

/**
 * 受払合計表テーブルBean.
 * 
 * @author Katoken
 * @version 20090101
 */
public class LACSUkebaraiTable {

	private String					companyName		= "";	// リース会社名

	private String					userName		= "";	// 開示先名

	private String					kaikeiKijunCode	= "";	// リース会計基準コード

	private String					kaikeiKijunname	= "";	// リース会計基準名称

	private String					trdHanteiCode	= "";	// リース取引分類コード

	private String					trdHanteiname	= "";	// リース取引分類名称

	private String					kaikeiShoriCode	= "";	// 会計処理方法コード

	private String					kaikeiShoriname	= "";	// 会計処理方法名称

	private String					pageCnt			= "";	// データ有無

	// 2020/05/22 ADD START
	private String					jysiUm	= "";			// 重要性有無
	// 2020/05/22 ADD END

	private LACSUkebaraiTableDetail	tableBS			= null; // BS科目残高推移

	private LACSUkebaraiTableDetail	tablePL			= null; // PL科目累計額推移

	/**
	 * コンストラクタ.
	 * 
	 * @param piBSRows
	 *            BS科目残高推移行数
	 * @param piPLRows
	 *            PL科目累計額推移行数
	 */
	public LACSUkebaraiTable(int piBSRows, int piPLRows) {
		tableBS = new LACSUkebaraiTableDetail(piBSRows);
		tablePL = new LACSUkebaraiTableDetail(piPLRows);
	}

	/**
	 * リース会計基準コードを取得.
	 * 
	 * @return リース会計基準コード
	 */
	public String getKaikeiKijunCode() {
		return this.kaikeiKijunCode;
	}

	/**
	 * リース会計基準コードを設定.
	 * 
	 * @param piKaikeiKijunCode
	 *            リース会計基準コード
	 */
	public void setKaikeiKijunCode(String piKaikeiKijunCode) {
		this.kaikeiKijunCode = piKaikeiKijunCode;
	}

	/**
	 * リース会計基準名称を取得.
	 * 
	 * @return リース会計基準名称
	 */
	public String getKaikeiKijunname() {
		return this.kaikeiKijunname;
	}

	/**
	 * リース会計基準名称を設定.
	 * 
	 * @param piKaikeiKijunname
	 *            リース会計基準名称
	 */
	public void setKaikeiKijunName(String piKaikeiKijunname) {
		this.kaikeiKijunname = piKaikeiKijunname;
	}

	/**
	 * リース取引分類コードを取得.
	 * 
	 * @return リース取引分類コード
	 */
	public String getTrdHanteiCode() {
		return this.trdHanteiCode;
	}

	/**
	 * リース取引分類コードを設定.
	 * 
	 * @param piTrdHanteiCode
	 *            リース取引分類コード
	 */
	public void setTrdHanteiCode(String piTrdHanteiCode) {
		this.trdHanteiCode = piTrdHanteiCode;
	}

	/**
	 * リース取引分類名称を取得.
	 * 
	 * @return リース取引分類名称
	 */
	public String getTrdHanteiname() {
		return this.trdHanteiname;
	}

	/**
	 * リース取引分類名称を設定.
	 * 
	 * @param piTrdHanteiname
	 *            リース取引分類名称
	 */
	public void setTrdHanteiName(String piTrdHanteiname) {
		this.trdHanteiname = piTrdHanteiname;
	}

	/**
	 * 会計処理方法コードを取得.
	 * 
	 * @return 会計処理方法コード
	 */
	public String getKaikeiShoriCode() {
		return this.kaikeiShoriCode;
	}

	/**
	 * 会計処理方法コードを設定.
	 * 
	 * @param piKaikeiShoriCode
	 *            会計処理方法コード
	 */
	public void setKaikeiShoriCode(String piKaikeiShoriCode) {
		this.kaikeiShoriCode = piKaikeiShoriCode;
	}

	/**
	 * 会計処理方法名称を取得.
	 * 
	 * @return 会計処理方法名称
	 */
	public String getKaikeiShoriname() {
		return this.kaikeiShoriname;
	}

	/**
	 * 会計処理方法名称を設定.
	 * 
	 * @param piKaikeiShoriname
	 *            会計処理方法名称
	 */
	public void setKaikeiShoriname(String piKaikeiShoriname) {
		this.kaikeiShoriname = piKaikeiShoriname;
	}

	/**
	 * データ有無を取得.
	 * 
	 * @return データ有無
	 */
	public String getPageCnt() {
		return this.pageCnt;
	}

	/**
	 * データ有無を設定.
	 * 
	 * @param piPageCnt
	 *            データ有無
	 */
	public void setPageCnt(String piPageCnt) {
		this.pageCnt = piPageCnt;
	}

	// 2020/05/22 ADD START
	/**
	 * 重要性有無を取得.
	 * 
	 * @return 重要性有無
	 */
	public String getJysiUm() {
		return this.jysiUm;
	}

	/**
	 * 重要性有無を設定.
	 * 
	 * @param piJysiUm
	 *            重要性有無
	 */
	public void setJysiUm(String piJysiUm) {
		this.jysiUm = piJysiUm;
	}
	// 2020/05/22 ADD END

	/**
	 * BS科目残高推移を取得.
	 * 
	 * @return BS科目残高推移
	 */
	public LACSUkebaraiTableDetail getTableBS() {
		return this.tableBS;
	}

	/**
	 * BS科目残高推移を設定.
	 * 
	 * @param piTableBS
	 *            BS科目残高推移
	 */
	public void setTableBS(LACSUkebaraiTableDetail piTableBS) {
		this.tableBS = piTableBS;
	}

	/**
	 * PL科目累計額推移を取得.
	 * 
	 * @return PL科目累計額推移
	 */
	public LACSUkebaraiTableDetail getTablePL() {
		return this.tablePL;
	}

	/**
	 * PL科目累計額推移を設定.
	 * 
	 * @param piTablePL
	 *            PL科目累計額推移
	 */
	public void setTablePL(LACSUkebaraiTableDetail piTablePL) {
		this.tablePL = piTablePL;
	}

	/**
	 * 配列化.
	 * 
	 * @return 保持情報の配列
	 */
	public ArrayList<Object> toArray() {
		ArrayList<Object> array = new ArrayList<Object>();

		this.tableBS.toArray(array);
		this.tablePL.toArray(array);

		return array;
	}

	/**
	 * リース会社名を取得.
	 * 
	 * @return リース会社名
	 */
	public String getCompanyName() {
		return this.companyName;
	}

	/**
	 * リース会社名を設定.
	 * 
	 * @param piCompanyName
	 *            リース会社名
	 */
	public void setCompanyName(String piCompanyName) {
		this.companyName = piCompanyName;
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
