package jp.co.pro_app.lacs.affairs.dsreport.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSBeanBase;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSDateBean;

/**
 * DS帳票出力Bean.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSDSReportBean extends LACSBeanBase {

	private static final long serialVersionUID = 1L;

	private LACSDateBean	termFrom	= new LACSDateBean();	// 期間開始

	private String			termNum		= "";					// 期間

	private String			termNum0	= "";					// 期間

	private LACSDateBean	termTo0		= new LACSDateBean();	// 期間終了

	private LACSDateBean	termTo1		= new LACSDateBean();	// 第1四半期

	private LACSDateBean	termTo2		= new LACSDateBean();	// 半期

	private LACSDateBean	termTo3		= new LACSDateBean();	// 第3四半期

	private LACSDateBean	termTo4		= new LACSDateBean();	// 通期

	private LACSDateBean	termTo		= new LACSDateBean();	// 処理用期間終了

	private String			quarter		= "";					// 四半期

	private int				nextFocus	= 0;					// 次のフォーカス 初期値：0

	private String			pdfFileName	= "";					// PDFファイル名

	private String			csvFileName	= "";					// CSVファイル名

	/**
	 * コンストラクタ.
	 */
	public LACSDSReportBean() {
	}

	/**
	 * 初期化.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 */
	public void init(LACSCommonBean piCommonBean) {

		this.quarter = "0";
		this.termNum0 = "1";

		this.termFrom = new LACSDateBean(piCommonBean);
		this.termFrom.setName("termFrom");
		this.termFrom.setOnChange("focusNextDS(this)");

		this.termTo0 = new LACSDateBean(piCommonBean);
		this.termTo0.setName("termTo0");
		this.termTo0.setPlane(true);

		this.termTo1 = new LACSDateBean(piCommonBean);
		this.termTo1.setName("termTo1");
		this.termTo1.setPlane(true);

		this.termTo2 = new LACSDateBean(piCommonBean);
		this.termTo2.setName("termTo2");
		this.termTo2.setPlane(true);

		this.termTo3 = new LACSDateBean(piCommonBean);
		this.termTo3.setName("termTo3");
		this.termTo3.setPlane(true);

		this.termTo4 = new LACSDateBean(piCommonBean);
		this.termTo4.setName("termTo4");
		this.termTo4.setPlane(true);

		this.termTo = new LACSDateBean(piCommonBean);

		this.pdfFileName = "";
		this.csvFileName = "";

		super.init();
	}

	/**
	 * リース会計注記合計表Beanを追加.
	 * 
	 * @param piBean
	 *            リース会計注記合計表Bean
	 */
	public void addGoukeiBean(LACSDSReportGoukeiBean piBean) {
		super.add(piBean);
	}

	/**
	 * リース会計注記合計表Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return リース会計注記合計表Bean
	 */
	public LACSDSReportGoukeiBean getGoukeiBean(int piIdx) {
		return (LACSDSReportGoukeiBean)super.get(piIdx);
	}

	/**
	 * 四半期を取得.
	 * 
	 * @return 四半期
	 */
	public String getQuarter() {
		return quarter;
	}

	/**
	 * 四半期を設定.
	 * 
	 * @param piQuarter
	 *            四半期
	 */
	public void setQuarter(String piQuarter) {
		this.quarter = piQuarter;
	}

	/**
	 * 期間開始を取得.
	 * 
	 * @return 期間開始
	 */
	public LACSDateBean getTermFrom() {
		return this.termFrom;
	}

	/**
	 * 期間終了を取得.
	 * 
	 * @return 期間終了
	 */
	public LACSDateBean getTermTo0() {
		return this.termTo0;
	}

	/**
	 * 期間終了を設定.
	 * 
	 * @param piTermTo
	 *            期間終了
	 */
	public void setTermTo0(LACSDateBean piTermTo) {
		this.termTo0 = piTermTo;
	}

	/**
	 * 第1四半期を取得.
	 * 
	 * @return 第1四半期
	 */
	public LACSDateBean getTermTo1() {
		return this.termTo1;
	}

	/**
	 * 半期を取得.
	 * 
	 * @return 半期
	 */
	public LACSDateBean getTermTo2() {
		return this.termTo2;
	}

	/**
	 * 第3四半期を取得.
	 * 
	 * @return 第3四半期
	 */
	public LACSDateBean getTermTo3() {
		return this.termTo3;
	}

	/**
	 * 通期を取得.
	 * 
	 * @return 通期
	 */
	public LACSDateBean getTermTo4() {
		return this.termTo4;
	}

	/**
	 * 処理用期間終了を取得.
	 * 
	 * @return 処理用期間終了
	 */
	public LACSDateBean getTermTo() {
		return this.termTo;
	}

	/**
	 * 次のフォーカスを取得.
	 * 
	 * @return 次のフォーカス
	 */
	public int getNextFocus() {
		return this.nextFocus;
	}

	/**
	 * 次のフォーカスを設定.
	 * 
	 * @param piNextFocus
	 *            次のフォーカス
	 */
	public void setNextFocus(int piNextFocus) {
		this.nextFocus = piNextFocus;
	}

	/**
	 * 期間(手入力)を取得.
	 * 
	 * @return 期間(手入力)
	 */
	public String getTermNum0() {
		return this.termNum0;
	}

	/**
	 * 期間(手入力)を設定.
	 * 
	 * @param piTermNum0
	 *            期間(手入力)
	 */
	public void setTermNum0(String piTermNum0) {
		this.termNum0 = piTermNum0;
	}

	/**
	 * 期間を取得.
	 * 
	 * @return 期間
	 */
	public String getTermNum() {
		return this.termNum;
	}

	/**
	 * 期間を設定.
	 * 
	 * @param piTermNum
	 *            期間
	 */
	public void setTermNum(String piTermNum) {
		this.termNum = piTermNum;
	}

	/**
	 * PDFファイル名を取得.
	 * 
	 * @return PDFファイル名
	 */
	public String getPdfFileName() {
		return this.pdfFileName;
	}

	/**
	 * PDFファイル名を設定.
	 * 
	 * @param piPdfFileName
	 *            PDFファイル名
	 */
	public void setPdfFileName(String piPdfFileName) {
		this.pdfFileName = piPdfFileName;
	}

	/**
	 * CSVファイル名を取得.
	 * 
	 * @return CSVファイル名
	 */
	public String getCsvFileName() {
		return this.csvFileName;
	}

	/**
	 * CSVファイル名を設定.
	 * 
	 * @param piCsvFileName
	 *            CSVファイル名
	 */
	public void setCsvFileName(String piCsvFileName) {
		this.csvFileName = piCsvFileName;
	}
}
