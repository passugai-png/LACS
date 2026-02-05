package jp.co.pro_app.lacs.affairs.monthreport.bean;

/**
 * 月次帳票出力：資産台帳 Bean.
 * 
 * @author yokota
 * @version 20081030
 */
public class LACSMReportSisanBean {

	private String	createDate			= "";	// 作成日

	private String	termFrom			= "";	// 対象期間From

	private String	termTo				= "";	// 対象期間To

	private String	leaseUserNm			= "";	// リースユーザ名

	private String	leaseCompanyNm		= "";	// リース会社名

	private String	brakeKey0			= "";	// ブレイクキー０

	private String	brakeKey1			= "";	// ブレイクキー1

	private String	brakeKey2			= "";	// ブレイクキー2

	private String	brakeKey3			= "";	// ブレイクキー3

	private String	brakeKey4			= "";	// ブレイクキー4

	private String	cosmosCd			= "";	// COSMOSコード

	private String	keiyakuNo			= "";	// 契約番号

	private String	hyoujiYouKeiyakuNo	= "";	// 表示用契約番号

	private String	acKijyunName		= "";	// 会計基準名

	private String	acKijyunCd			= "";	// 会計基準コード

	private String	trdHnteKekaName		= "";	// リース取引分類名

	private String	trdHnteKekaKbn		= "";	// リース取引分類

	private String	acShrKbnName		= "";	// 会計処理方法名

	private String	acShrKbn			= "";	// 会計処理方法

	private String	sisanKbnName		= "";	// 資産区分名

	private String	sisanKbn			= "";	// 資産区分

	private String	sisanSyuruiName		= "";	// 資産種類名

	private String	sisanSyurui			= "";	// 資産種類

	private String	leaseFrom			= "";	// リース開始日

	private String	bukenNo				= "";	// 物件番号

	private String	bukenNm				= "";	// 物件名

	private String	suryou				= "";	// 数量

	private long	syutokuAmt			= 0;	// 取得価格

	private long	syoukyakuTerm		= 0;	// 償却期間

	private String	syoukyakuHohoKbn	= "";	// 償却方法区分

	private String	syoukyakuHohoNm		= "";	// 償却方法名

	private String	syoukyakuRt			= "";	// 償却率

	private long	monthCount			= 0;	// 月数

	private String	zenkimatsuBoka		= "";	// 前期末簿価

	private String	tougetsuHassei		= "";	// 当月発生

	private String	tougetsuGensyo		= "";	// 当月減少

	private String	tougetsuJitsugen	= "";	// 当月実現

	private String	toukimatsuBoka		= "";	// 当月実現

	/**
	 * 作成日を取得.
	 * 
	 * @return 作成日
	 */
	public String getCreateDate() {
		return this.createDate;
	}

	/**
	 * 対象期間Fromを取得.
	 * 
	 * @return 対象期間From
	 */
	public String getTermFrom() {
		return this.termFrom;
	}

	/**
	 * 対象期間Toを取得.
	 * 
	 * @return 対象期間To
	 */
	public String getTermTo() {
		return this.termTo;
	}

	/**
	 * ブレイクキー０を取得.
	 * 
	 * @return ブレイクキー０
	 */
	public String getBrakeKey0() {
		return this.brakeKey0;

	}

	/**
	 * ブレイクキー1を取得.
	 * 
	 * @return ブレイクキー1
	 */
	public String getBrakeKey1() {
		return this.brakeKey1;
	}

	/**
	 * ブレイクキー2を取得.
	 * 
	 * @return ブレイクキー2
	 */
	public String getBrakeKey2() {
		return this.brakeKey2;
	}

	/**
	 * ブレイクキー3を取得.
	 * 
	 * @return ブレイクキー3
	 */
	public String getBrakeKey3() {
		return this.brakeKey3;
	}

	/**
	 * ブレイクキー4を取得.
	 * 
	 * @return ブレイクキー4
	 */
	public String getBrakeKey4() {
		return this.brakeKey4;
	}

	/**
	 * リースユーザ名を取得.
	 * 
	 * @return リースユーザ名
	 */
	public String getLeasUserNm() {
		return this.leaseUserNm;
	}

	/**
	 * リース会社名を取得.
	 * 
	 * @return リース会社名
	 */
	public String getLeasCompanyNm() {
		return this.leaseCompanyNm;
	}

	/**
	 * COSMOSCDを取得.
	 * 
	 * @return COSMOSCD
	 */
	public String getCosmosCd() {
		return this.cosmosCd;
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
	 * 表示用契約番号を取得.
	 * 
	 * @return 表示用契約番号
	 */
	public String getHyoujiYouKeiyakuNo() {
		return this.hyoujiYouKeiyakuNo;
	}

	/**
	 * 会計基準名を取得.
	 * 
	 * @return 会計基準名
	 */
	public String getAcKijyunName() {
		return this.acKijyunName;
	}

	/**
	 * 会計基準コードを取得.
	 * 
	 * @return 会計基準コード
	 */
	public String getAcKijyunCd() {
		return this.acKijyunCd;
	}

	/**
	 * リース取引分類名を取得.
	 * 
	 * @return リース取引分類名
	 */
	public String getTrdHnteKekaName() {
		return this.trdHnteKekaName;
	}

	/**
	 * リース取引分類を取得.
	 * 
	 * @return リース取引分類
	 */
	public String getTrdHnteKekaKbn() {
		return this.trdHnteKekaKbn;
	}

	/**
	 * 会計処理方法名を取得.
	 * 
	 * @return 会計処理方法名
	 */
	public String getAcShrKbnName() {
		return this.acShrKbnName;
	}

	/**
	 * 会計処理方法を取得.
	 * 
	 * @return 会計処理方法
	 */
	public String getAcShrKbn() {
		return this.acShrKbn;
	}

	/**
	 * 資産区分名を取得.
	 * 
	 * @return 資産区分名
	 */
	public String getSisanKbnName() {
		return this.sisanKbnName;
	}

	/**
	 * 資産区分を取得.
	 * 
	 * @return 資産区分
	 */
	public String getSisanKbn() {
		return this.sisanKbn;
	}

	/**
	 * 資産種類名を取得.
	 * 
	 * @return 資産種類名
	 */
	public String getSisanSyuruiName() {
		return this.sisanSyuruiName;
	}

	/**
	 * 資産種類を取得.
	 * 
	 * @return 資産種類
	 */
	public String getSisanSyuruiCd() {
		return this.sisanSyurui;
	}

	/**
	 * リース開始日を取得.
	 * 
	 * @return リース開始日
	 */
	public String getLeaseFrom() {
		return this.leaseFrom;
	}

	/**
	 * 物件番号を取得.
	 * 
	 * @return 物件番号
	 */
	public String getBukenNo() {
		return this.bukenNo;
	}

	/**
	 * 物件名を取得.
	 * 
	 * @return 物件名
	 */
	public String getBukenNm() {
		return this.bukenNm;
	}

	/**
	 * 数量を取得.
	 * 
	 * @return 数量
	 */
	public String getSuryou() {
		return this.suryou;
	}

	/**
	 * 取得価格を取得.
	 * 
	 * @return 取得価格
	 */
	public long getSyutokuAmt() {
		return this.syutokuAmt;
	}

	/**
	 * 償却期間を取得.
	 * 
	 * @return 償却期間
	 */
	public long getSyoukyakuTerm() {
		return this.syoukyakuTerm;
	}

	/**
	 * 償却方法区分を取得.
	 * 
	 * @return 償却方法区分
	 */
	public String getSyoukyakuHohoKbn() {
		return this.syoukyakuHohoKbn;
	}

	/**
	 * 償却方法名称を取得.
	 * 
	 * @return 償却方法名称
	 */
	public String getSyoukyakuHohoNm() {
		return this.syoukyakuHohoNm;
	}

	/**
	 * 償却率を取得.
	 * 
	 * @return 償却率
	 */
	public String getSyoukyakuRt() {
		return this.syoukyakuRt;
	}

	/**
	 * 月数を取得.
	 * 
	 * @return 月数
	 */
	public long getMonthCount() {
		return this.monthCount;
	}

	/**
	 * 前期末簿価を取得.
	 * 
	 * @return 前期末簿価
	 */
	public String getZenkimatsuBoka() {
		return this.zenkimatsuBoka;
	}

	/**
	 * 当月発生を取得.
	 * 
	 * @return 当月発生
	 */
	public String getTougetsuHassei() {
		return this.tougetsuHassei;
	}

	/**
	 * 当月減少を取得.
	 * 
	 * @return 当月減少
	 */
	public String getTougetsuGensyo() {
		return this.tougetsuGensyo;
	}

	/**
	 * 当月実現を取得.
	 * 
	 * @return 当月実現
	 */
	public String getTougetsuJitsugen() {
		return this.tougetsuJitsugen;
	}

	/**
	 * 当期末簿価を取得.
	 * 
	 * @return 当期末簿価
	 */
	public String getToukimatsuBoka() {
		return this.toukimatsuBoka;
	}

	/**
	 * 作成日を取得.
	 * 
	 * @param piCreateDate
	 *            作成日
	 */
	public void setCreateDate(String piCreateDate) {
		this.createDate = piCreateDate;
	}

	/**
	 * 対象期間Fromを取得.
	 * 
	 * @param piTermFrom
	 *            対象期間From
	 */
	public void setTermFrom(String piTermFrom) {
		this.termFrom = piTermFrom;
	}

	/**
	 * 対象期間Toを取得.
	 * 
	 * @param piTermTo
	 *            対象期間To
	 */
	public void setTermTo(String piTermTo) {
		this.termTo = piTermTo;
	}

	/**
	 * ブレイクキー０を取得.
	 * 
	 * @param piBrakeKey0
	 *            ブレークキー０
	 */
	public void setBrakeKey0(String piBrakeKey0) {
		this.brakeKey0 = piBrakeKey0;
	}

	/**
	 * ブレイクキー1を取得.
	 * 
	 * @param piBrakeKey1
	 *            ブレークキー1
	 */
	public void setBrakeKey1(String piBrakeKey1) {
		this.brakeKey1 = piBrakeKey1;
	}

	/**
	 * ブレイクキー2を取得.
	 * 
	 * @param piBrakeKey2
	 *            ブレークキー2
	 */
	public void setBrakeKey2(String piBrakeKey2) {
		this.brakeKey2 = piBrakeKey2;
	}

	/**
	 * ブレイクキー3を取得.
	 * 
	 * @param piBrakeKey3
	 *            ブレークキー3
	 */
	public void setBrakeKey3(String piBrakeKey3) {
		this.brakeKey3 = piBrakeKey3;
	}

	/**
	 * ブレイクキー4を取得.
	 * 
	 * @param piBrakeKey4
	 *            ブレークキー4
	 */
	public void setBrakeKey4(String piBrakeKey4) {
		this.brakeKey4 = piBrakeKey4;
	}

	/**
	 * リースユーザ名を取得.
	 * 
	 * @param piLeasUserNm
	 *            リースユーザ名
	 */
	public void setLeasUserNm(String piLeasUserNm) {
		this.leaseUserNm = piLeasUserNm;
	}

	/**
	 * リース会社名を取得.
	 * 
	 * @param piLeasCompanyNm
	 *            リース会社名
	 */
	public void setLeasCompanyNm(String piLeasCompanyNm) {
		this.leaseCompanyNm = piLeasCompanyNm;
	}

	/**
	 * COSMOSCDを取得.
	 * 
	 * @param piCosmosCd
	 *            COSMOSCD
	 */
	public void setCosmosCd(String piCosmosCd) {
		this.cosmosCd = piCosmosCd;
	}

	/**
	 * 契約番号を取得.
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
	 * @param piHyoujiYouKeiyakuNo
	 *            表示用契約番号
	 */
	public void setHyoujiYouKeiyakuNo(String piHyoujiYouKeiyakuNo) {
		this.hyoujiYouKeiyakuNo = piHyoujiYouKeiyakuNo;
	}

	/**
	 * 会計基準名を取得.
	 * 
	 * @param piAcKijyunName
	 *            会計基準名
	 */
	public void setAcKijyunName(String piAcKijyunName) {
		this.acKijyunName = piAcKijyunName;
	}

	/**
	 * 会計基準コードを取得.
	 * 
	 * @param piAcKijyunCd
	 *            会計基準コード
	 */
	public void setAcKijyunCd(String piAcKijyunCd) {
		this.acKijyunCd = piAcKijyunCd;
	}

	/**
	 * リース取引分類名を取得.
	 * 
	 * @param piTrdHnteKekaName
	 *            リース取引分類名
	 */
	public void setTrdHnteKekaName(String piTrdHnteKekaName) {
		this.trdHnteKekaName = piTrdHnteKekaName;
	}

	/**
	 * リース取引分類を取得.
	 * 
	 * @param piTrdHnteKekaKbn
	 *            リース取引分類
	 */
	public void setTrdHnteKekaKbn(String piTrdHnteKekaKbn) {
		this.trdHnteKekaKbn = piTrdHnteKekaKbn;
	}

	/**
	 * 会計処理方法名を取得.
	 * 
	 * @param piAcShrKbnName
	 *            会計処理方法名
	 */
	public void setAcShrKbnName(String piAcShrKbnName) {
		this.acShrKbnName = piAcShrKbnName;
	}

	/**
	 * 会計処理方法を取得.
	 * 
	 * @param piAcShrKbn
	 *            会計処理方法
	 */
	public void setAcShrKbn(String piAcShrKbn) {
		this.acShrKbn = piAcShrKbn;
	}

	/**
	 * 資産区分名を取得.
	 * 
	 * @param piSisanKbnName
	 *            資産区分名
	 */
	public void setSisanKbnName(String piSisanKbnName) {
		this.sisanKbnName = piSisanKbnName;
	}

	/**
	 * 資産区分を取得.
	 * 
	 * @param piSisanKbn
	 *            資産区分
	 */
	public void setSisanKbn(String piSisanKbn) {
		this.sisanKbn = piSisanKbn;
	}

	/**
	 * 資産種類名を取得.
	 * 
	 * @param piSisanSyuruiName
	 *            資産種類名
	 */
	public void setSisanSyuruiName(String piSisanSyuruiName) {
		this.sisanSyuruiName = piSisanSyuruiName;
	}

	/**
	 * 資産種類を取得.
	 * 
	 * @param piSisanSyuruiCd
	 *            資産種類
	 */
	public void setSisanSyuruiCd(String piSisanSyuruiCd) {
		this.sisanSyurui = piSisanSyuruiCd;
	}

	/**
	 * リース開始日を取得.
	 * 
	 * @param piLeaseFrom
	 *            資産種類
	 */
	public void setLeaseFrom(String piLeaseFrom) {
		this.leaseFrom = piLeaseFrom;
	}

	/**
	 * 物件番号を取得.
	 * 
	 * @param piBukenNo
	 *            物件番号
	 */
	public void setBukenNo(String piBukenNo) {
		this.bukenNo = piBukenNo;
	}

	/**
	 * 物件名を取得.
	 * 
	 * @param piBukenNm
	 *            物件名
	 */
	public void setBukenNm(String piBukenNm) {
		this.bukenNm = piBukenNm;
	}

	/**
	 * 数量を取得.
	 * 
	 * @param piSuryou
	 *            数量
	 */

	public void setSuryou(String piSuryou) {
		this.suryou = piSuryou;
	}

	/**
	 * 取得価格を取得.
	 * 
	 * @param piSyutokuAmt
	 *            取得価格
	 */
	public void setSyutokuAmt(long piSyutokuAmt) {
		this.syutokuAmt = piSyutokuAmt;
	}

	/**
	 * 償却期間を取得.
	 * 
	 * @param piSyoukyakuTerm
	 *            償却期間
	 */
	public void setSyoukyakuTerm(long piSyoukyakuTerm) {
		this.syoukyakuTerm = piSyoukyakuTerm;
	}

	/**
	 * 償却方法区分を取得.
	 * 
	 * @param piSyoukyakuHohoKbn
	 *            償却方法区分
	 */
	public void setSyoukyakuHohoKbn(String piSyoukyakuHohoKbn) {
		this.syoukyakuHohoKbn = piSyoukyakuHohoKbn;
	}

	/**
	 * 償却方法名称を取得.
	 * 
	 * @param piSyoukyakuHohoNm
	 *            償却方法名称
	 */
	public void setSyoukyakuHohoNm(String piSyoukyakuHohoNm) {
		this.syoukyakuHohoNm = piSyoukyakuHohoNm;
	}

	/**
	 * 償却率を取得.
	 * 
	 * @param piSyoukyakuRt
	 *            償却率
	 */
	public void setSyoukyakuRt(String piSyoukyakuRt) {
		this.syoukyakuRt = piSyoukyakuRt;
	}

	/**
	 * 月数を取得.
	 * 
	 * @param piMonthCount
	 *            月数
	 */
	public void setMonthCount(long piMonthCount) {
		this.monthCount = piMonthCount;
	}

	/**
	 * 前期末簿価を取得.
	 * 
	 * @param piZenkimatsuBoka
	 *            前期末簿価
	 */
	public void setZenkimatsuBoka(String piZenkimatsuBoka) {
		this.zenkimatsuBoka = piZenkimatsuBoka;
	}

	/**
	 * 当月発生を取得.
	 * 
	 * @param piTougetsuHassei
	 *            当月発生
	 */
	public void setTougetsuHassei(String piTougetsuHassei) {
		this.tougetsuHassei = piTougetsuHassei;
	}

	/**
	 * 当月減少を取得.
	 * 
	 * @param piTougetsuGensyo
	 *            当月減少
	 */
	public void setTougetsuGensyo(String piTougetsuGensyo) {
		this.tougetsuGensyo = piTougetsuGensyo;
	}

	/**
	 * 当月実現を取得.
	 * 
	 * @param piTougetsuJitsugen
	 *            当月実現
	 */
	public void setTougetsuJitsugen(String piTougetsuJitsugen) {
		this.tougetsuJitsugen = piTougetsuJitsugen;
	}

	/**
	 * 当期末簿価を取得.
	 * 
	 * @param piToukimatsuBoka
	 *            当期末簿価
	 */
	public void setToukimatsuBoka(String piToukimatsuBoka) {
		this.toukimatsuBoka = piToukimatsuBoka;
	}
	

}
