package jp.co.pro_app.lacs.affairs.common.bean;

import jp.co.pro_app.projframe.common.bean.BeanBase;
import jp.co.pro_app.projframe.common.html.ComboArray;

/**
 * LACS用日付Bean.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSDateBean extends BeanBase {

	private static final long serialVersionUID = 1L;

	private ComboArray	era				= new ComboArray(); // 和暦コンボボックス

	private String		name			= "";				// 項目名

	private String		cssClass		= "";				// CSSクラス

	private String		inputString1	= "";				// 日付項目1

	private String		inputString2	= "";				// 日付項目2

	private String		inputString3	= "";				// 日付項目2

	private boolean		checkResult		= false;			// チェック結果

	private String		yyyymm			= "";				// 年月

	private String		yyyymmdd		= "";				// 年月日

	private boolean		plane			= false;			// ラベル表示モード

	private String		onChange		= "";				// 変更時イベント

	/**
	 * コンストラクタ(使用時は再初期化する事).
	 */
	public LACSDateBean() {
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param piCommonBean
	 *            LACS用共通Bean
	 */
	public LACSDateBean(LACSCommonBean piCommonBean) {
		this.era = piCommonBean.getWarekiArray().copy();
	}

	/**
	 * 日付を設定.
	 * 
	 * @param piEraCode
	 *            和暦コード
	 * @param piDateString1
	 *            日付項目1
	 * @param piDateString2
	 *            日付項目2
	 * @param piDateString3
	 *            日付項目3
	 */
	public void setDate(String piEraCode, String piDateString1, String piDateString2, String piDateString3) {
		this.inputString1 = piDateString1;
		this.inputString2 = piDateString2;
		this.inputString3 = piDateString3;
		this.era.setSelectedValue(piEraCode);
	}

	/**
	 * 日付を設定.
	 * 
	 * @param piEraCode
	 *            和暦コード
	 * @param piDateString1
	 *            日付項目1
	 * @param piDateString2
	 *            日付項目2
	 */
	public void setDate(String piEraCode, String piDateString1, String piDateString2) {
		this.inputString1 = piDateString1;
		this.inputString2 = piDateString2;
		this.inputString3 = "";
		this.era.setSelectedValue(piEraCode);
	}

	/**
	 * 和暦コンボボックスを取得.
	 * 
	 * @return 和暦コンボボックス
	 */
	public ComboArray getEra() {
		return this.era;
	}

	/**
	 * 和暦コンボボックスを設定.
	 * 
	 * @param piEra
	 *            和暦コンボボックス
	 */
	public void setEra(ComboArray piEra) {
		this.era = piEra;
	}

	/**
	 * 項目名を取得.
	 * 
	 * @return 項目名
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 項目名を設定.
	 * 
	 * @param piName
	 *            項目名
	 */
	public void setName(String piName) {
		this.name = piName;
	}

	/**
	 * CSSクラスを取得.
	 * 
	 * @return CSSクラス
	 */
	public String getCssClass() {
		return this.cssClass;
	}

	/**
	 * CSSクラスを設定.
	 * 
	 * @param piCssClass
	 *            CSSクラス
	 */
	public void setCssClass(String piCssClass) {
		this.cssClass = piCssClass;
	}

	/**
	 * 日付項目1を取得.
	 * 
	 * @return 日付項目1
	 */
	public String getInputString1() {
		return this.inputString1;
	}

	/**
	 * 日付項目1を設定.
	 * 
	 * @param piInputString1
	 *            日付項目1
	 */
	public void setInputString1(String piInputString1) {
		this.inputString1 = piInputString1;
	}

	/**
	 * 日付項目2を取得.
	 * 
	 * @return 日付項目2
	 */
	public String getInputString2() {
		return this.inputString2;
	}

	/**
	 * 日付項目2を設定.
	 * 
	 * @param piInputString2
	 *            日付項目2
	 */
	public void setInputString2(String piInputString2) {
		this.inputString2 = piInputString2;
	}

	/**
	 * 日付項目3を取得.
	 * 
	 * @return 日付項目3
	 */
	public String getInputString3() {
		return this.inputString3;
	}

	/**
	 * 日付項目3を設定.
	 * 
	 * @param piInputString3
	 *            日付項目3
	 */
	public void setInputString3(String piInputString3) {
		this.inputString3 = piInputString3;
	}

	/**
	 * チェック結果を取得.
	 * 
	 * @return チェック結果
	 */
	public boolean isCheckResult() {
		return this.checkResult;
	}

	/**
	 * チェック結果を設定.
	 * 
	 * @param piCheckResult
	 *            チェック結果
	 */
	public void setCheckResult(boolean piCheckResult) {
		this.checkResult = piCheckResult;
	}

	/**
	 * 年月を取得.
	 * 
	 * @return 年月
	 */
	public String getYYYYMM() {
		return this.yyyymm;
	}

	/**
	 * 年月を設定.
	 * 
	 * @param piYYYYMM
	 *            年月
	 */
	public void setYYYYMM(String piYYYYMM) {
		this.yyyymm = piYYYYMM;
	}

	/**
	 * 年月日を取得.
	 * 
	 * @return 年月日
	 */
	public String getYYYYMMDD() {
		return this.yyyymmdd;
	}

	/**
	 * 年月日を設定.
	 * 
	 * @param piYYYYMMDD
	 *            年月日
	 */
	public void setYYYYMMDD(String piYYYYMMDD) {
		this.yyyymmdd = piYYYYMMDD;
	}

	/**
	 * ラベル表示モードを取得.
	 * 
	 * @return ラベル表示モード
	 */
	public boolean isPlane() {
		return this.plane;
	}

	/**
	 * ラベル表示モードを設定.
	 * 
	 * @param piPlane
	 *            ラベル表示モード
	 */
	public void setPlane(boolean piPlane) {
		this.plane = piPlane;
	}

	/**
	 * 変更時イベントを取得.
	 * 
	 * @return 変更時イベント
	 */
	public String getOnChange() {
		return this.onChange;
	}

	/**
	 * 変更時イベントを設定.
	 * 
	 * @param piOnChange
	 *            変更時イベント
	 */
	public void setOnChange(String piOnChange) {
		this.onChange = piOnChange;
	}
}
