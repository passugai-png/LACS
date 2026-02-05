package jp.co.pro_app.lacs.affairs.monthreport.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSBeanBase;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSDateBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSReportDetailBean;

/**
 * 月次帳票出力Bean.
 * 
 * @author yamaguchi
 * @version 20070408
 */
public class LACSMReportBean extends LACSBeanBase {

	private static final long serialVersionUID = 1L;

	private String					keiyakuNo		= "";							// 契約番号

	private String					hyoujiKeiyakuNo	= "";							// 表示用契約番号

	private String					bukkenNo		= "";							// 物件番号

	private String					bukkenEdaNo		= "";							// 物件枝番号

	private LACSDateBean			termFrom		= new LACSDateBean();			// 期間開始

	private String					termNum			= "";							// 期間

	private String					termNum0		= "";							// 期間

	private LACSDateBean			termTo0			= new LACSDateBean();			// 期間終了

	private LACSDateBean			termTo1			= new LACSDateBean();			// 第1四半期

	private LACSDateBean			termTo2			= new LACSDateBean();			// 半期

	private LACSDateBean			termTo3			= new LACSDateBean();			// 第3四半期

	private LACSDateBean			termTo4			= new LACSDateBean();			// 通期

	private LACSDateBean			termTo			= new LACSDateBean();			// 処理用期間終了

	private String					quarter			= "";							// 四半期

	private String					gtjkeiyakuGaku	= "0";							// 月次帳票-契約金額３００万円以下 0：除く 1：除かない

	private String					gtjleaseKikan	= "0";							// 月次帳票-リース期間１年未満 0：除く 1：除かない

	private String					gtjsaiLease		= "0";							// 月次帳票-再リース契約 0：除く 1：除かない

	private String					gtjtyutoKaiyaku	= "0";							// 月次帳票-中途解約物件 0：除く 1：除かない

	private LACSReportDetailBean	kaikeiMeisai	= new LACSReportDetailBean();	// リース会計基準明細書

	private LACSReportDetailBean	removeAssert	= new LACSReportDetailBean();	// 除却資産一覧

	private LACSReportDetailBean	siwake			= new LACSReportDetailBean();	// 仕訳合計表

	private LACSReportDetailBean	sisan			= new LACSReportDetailBean();	// 資産台帳

	private LACSReportDetailBean	syouhizei		= new LACSReportDetailBean();	// 消費税明細票

	private LACSReportDetailBean	download		= new LACSReportDetailBean();	// 明細ダウンロード

	private int						nextFocus		= 0;							// 次のフォーカス

	private String					downloadPath	= "";							// ダウンロードパス

	/**
	 * コンストラクタ.
	 */
	public LACSMReportBean() {
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
		this.gtjkeiyakuGaku = "0";
		this.gtjleaseKikan = "0";
		this.gtjsaiLease = "0";
		this.gtjtyutoKaiyaku = "0";
		this.keiyakuNo = "";
		this.hyoujiKeiyakuNo = "";
		this.bukkenNo = "";
		this.bukkenEdaNo = "";
				
		this.termFrom = new LACSDateBean(piCommonBean);
		this.termFrom.setName("termFrom");
		this.termFrom.setOnChange("focusNextM(this)");

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

		removeAssert.init();

		kaikeiMeisai.init(0);

		siwake.init();

		sisan.init();
		syouhizei.init();

		download.init(0);

		super.init();
	}

	/**
	 * 除却資産一覧Beanを追加.
	 * 
	 * @param piBean
	 *            除却資産一覧Bean
	 */
	public void addRemoveAssertBean(LACSMReportRemoveAssertBean piBean) {
		super.add(piBean);
	}

	/**
	 * 除却資産一覧表Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 除却資産一覧表Bean
	 */
	public LACSMReportRemoveAssertBean getRemoveAssertBean(int piIdx) {
		return (LACSMReportRemoveAssertBean)super.get(piIdx);
	}

	/**
	 * リース会計基準明細書Beanを追加.
	 * 
	 * @param piBean
	 *            リース会計基準明細書Bean
	 */
	public void addKaikeiMeisaiBean(LACSMReportKaikeiMeisaiBean piBean) {
		super.add(piBean);
	}

	/**
	 * リース会計基準明細書表Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return リース会計基準明細書表Bean
	 */
	public LACSMReportKaikeiMeisaiBean getKaikeiMeisaiBean(int piIdx) {
		return (LACSMReportKaikeiMeisaiBean)super.get(piIdx);
	}

	/**
	 * 仕訳合計表Beanを追加.
	 * 
	 * @param piBean
	 *            仕訳合計表Bean
	 */
	public void addSiwakeBean(LACSMReportSiwakeBean piBean) {
		super.add(piBean);
	}

	/**
	 * 仕訳合計表Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return リース仕訳合計表Bean
	 */
	public LACSMReportSiwakeBean getSiwakeBean(int piIdx) {
		return (LACSMReportSiwakeBean)super.get(piIdx);
	}

	/**
	 * 資産台帳Beanを追加.
	 * 
	 * @param piBean
	 *            資産台帳Bean
	 */
	public void addSisanBean(LACSMReportSisanBean piBean) {
		super.add(piBean);
	}

	/**
	 * 資産台帳Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 資産台帳Bean
	 */
	public LACSMReportSisanBean getSisanBean(int piIdx) {
		return (LACSMReportSisanBean)super.get(piIdx);
	}

	/**
	 * 消費税明細票追加.
	 * 
	 * @param piBean
	 *            消費税明細票Bean
	 */
	public void addSyouhizeiBean(LACSMReportSyouhizeiBean piBean) {
		super.add(piBean);
	}

	/**
	 * 消費税明細票Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 消費税明細票Bean
	 */
	public LACSMReportSyouhizeiBean getSyouhizeiBean(int piIdx) {
		return (LACSMReportSyouhizeiBean)super.get(piIdx);
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
	 * 月次帳票-契約金額３００万円以下を取得.
	 * 
	 * @return 月次帳票-契約金額３００万円以下
	 */
	public String getGtjKeiyakuGaku() {
		return this.gtjkeiyakuGaku;
	}

	/**
	 * 月次帳票-契約金額３００万円以下を設定.
	 * 
	 * @param piGtjKeiyakuGaku
	 *            月次帳票-契約金額３００万円以下
	 */
	public void setGtjKeiyakuGaku(String piGtjKeiyakuGaku) {
		this.gtjkeiyakuGaku = piGtjKeiyakuGaku;
	}

	/**
	 * 月次帳票-リース期間１年未満を取得.
	 * 
	 * @return 月次帳票-リース期間１年未満
	 */
	public String getGtjLeaseKikan() {
		return this.gtjleaseKikan;
	}

	/**
	 * 月次帳票-リース期間１年未満を設定.
	 * 
	 * @param piGtjLeaseKikan
	 *            月次帳票-リース期間１年未満
	 */

	public void setGtjLeaseKikan(String piGtjLeaseKikan) {
		this.gtjleaseKikan = piGtjLeaseKikan;
	}

	/**
	 * 月次帳票-再リース契約を取得.
	 * 
	 * @return 月次帳票-再リース契約
	 */
	public String getGtjSaiLease() {
		return this.gtjsaiLease;
	}

	/**
	 * 月次帳票-再リース契約を設定.
	 * 
	 * @param piGtjSaiLease
	 *            月次帳票-再リース契約
	 */
	public void setGtjSaiLease(String piGtjSaiLease) {
		this.gtjsaiLease = piGtjSaiLease;
	}

	/**
	 * 月次帳票-中途解約物件を取得.
	 * 
	 * @return 月次帳票-中途解約物件
	 */
	public String getGtjTyutoKaiyaku() {
		return this.gtjtyutoKaiyaku;
	}

	/**
	 * 月次帳票-中途解約物件を設定.
	 * 
	 * @param piGtjTyutoKaiyaku
	 *            月次帳票-中途解約物件
	 */
	public void setGtjTyutoKaiyaku(String piGtjTyutoKaiyaku) {
		this.gtjtyutoKaiyaku = piGtjTyutoKaiyaku;
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
	 * 表示用契約番号を取得.
	 * 
	 * @return 表示用契約番号
	 */
	public String getHyoujiKeiyakuNo() {
		return this.hyoujiKeiyakuNo;
	}

	/**
	 * 表示用契約番号を設定.
	 * 
	 * @param piHyoujiKeiyakuNo
	 *            表示用契約番号
	 */
	public void setHyoujiKeiyakuNo(String piHyoujiKeiyakuNo) {
		this.hyoujiKeiyakuNo = piHyoujiKeiyakuNo;
	}

	/**
	 * 物件番号を取得.
	 * 
	 * @return 物件番号
	 */
	public String getBukkenNo() {
		return this.bukkenNo;
	}

	/**
	 * 物件番号を設定.
	 * 
	 * @param piBukkenNo
	 *            物件番号
	 */
	public void setBukkenNo(String piBukkenNo) {
		this.bukkenNo = piBukkenNo;
	}

	/**
	 * 物件枝番号を取得.
	 * 
	 * @return 物件枝番号
	 */
	public String getBukkenEdaNo() {
		return this.bukkenEdaNo;
	}

	/**
	 * 物件枝番号を設定.
	 * 
	 * @param piBukkenEdaNo
	 *            物件枝番号
	 */
	public void setBukkenEdaNo(String piBukkenEdaNo) {
		this.bukkenEdaNo = piBukkenEdaNo;
	}

	/**
	 * 除却資産一覧を取得.
	 * 
	 * @return 除却資産一覧
	 */
	public LACSReportDetailBean getRemoveAssert() {
		return this.removeAssert;
	}

	/**
	 * リース会計基準明細書を取得.
	 * 
	 * @return リース会計基準明細書
	 */
	public LACSReportDetailBean getKaikeiMeisai() {
		return this.kaikeiMeisai;
	}

	/**
	 * 仕訳合計表を取得.
	 * 
	 * @return 仕訳合計表
	 */
	public LACSReportDetailBean getSiwake() {
		return this.siwake;
	}

	/**
	 * 資産台帳を取得.
	 * 
	 * @return 資産台帳
	 */
	public LACSReportDetailBean getSisan() {
		return this.sisan;
	}

	/**
	 * 消費税明細票を取得.
	 * 
	 * @return 資産台帳
	 */
	public LACSReportDetailBean getSyouhizei() {
		return this.syouhizei;
	}

	/**
	 * 明細ダウンロード（CSV作成のみ）を取得.
	 * 
	 * @return 明細ダウンロード（CSV作成のみ）
	 */
	public LACSReportDetailBean getDownload() {
		return this.download;
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
	 * ダウンロードパスを取得.
	 * 
	 * @return ダウンロードパス
	 */
	public String getDownloadPath() {
		return this.downloadPath;
	}

	/**
	 * ダウンロードパスを設定.
	 * 
	 * @param piDownloadPath
	 *            ダウンロードパス
	 */
	public void setDownloadPath(String piDownloadPath) {
		this.downloadPath = piDownloadPath;
	}

}
