package jp.co.pro_app.lacs.affairs.report.bean;

/**
 * 帳票出力：期日別予定表（債務）Bean.
 * 
 * @author arai
 * @version 20200615
 */

public class LACSReportKizituSaimuBean  {

	private String leaseCompany                    = "";   // リース会社
	
	private String kaizisaki                       = "";   // 開示先
	
	private String baseDate                       = "";   // 基準日
	 
	private String jysiUm                          = "";   // 重要性有無
	
	private String leaseBunrui                     = "";   // リース取引分類
	
	private String kaikeiSyoriHouhou               = "";   // 会計処理方法
	
	private String risokuBunpaiHouhou              = "";   // 利息相当額配分方法
	
	private String toukiReaseRyouKeisanKijyun	   = "";   // 当期支払リース料計算基準
	
	private String keiyakuNo                       = "";   // 契約番号
	
	private String bukenNo	                       = "";   // 物件番号
	
	private String bukenName                      = "";   // 物件名
	
	private String leaseFrom                       = "";   // リース開始日
	
	private String leaseTo                         = "";   // リース終了日	
	
	private String KaiyakuYmd                      = "";   // 中途解約日
	
	private long mikeikaLeaseWithinOneYear       = 0;   // 未経過リース料(1年以内)
	
	private long zankaHosyogakuWithinOneYear     = 0;   // 残価保証額(1年以内)
	
	private long ganponWithinOneYear             = 0;   // 元本(1年以内)
	
	private long risokuWithinOneYear             = 0;   // 利息(1年以内)
	
	private long izikanrihiWithinOneYear         = 0;   // 維持管理費(1年以内)
	
	private long ekimuteikyouhiWithinOneYear     = 0;   // 役務提供費(1年以内)
	
	private long syohizeiWithinOneYear           = 0;   // 消費税等(1年以内)
	
    private long mikeikaLeaseWithinTwoYears       = 0;   // 未経過リース料(2年以内)
	
	private long zankaHosyogakuWithinTwoYears     = 0;   // 残価保証額(2年以内)
	
	private long ganponWithinTwoYears             = 0;   // 元本(2年以内)
	
	private long risokuWithinTwoYears             = 0;   // 利息(2年以内)
	
	private long izikanrihiWithinTwoYears         = 0;   // 維持管理費(2年以内)
	
	private long ekimuteikyouhiWithinTwoYears     = 0;   // 役務提供費(2年以内)
	
	private long syohizeiWithinTwoYears           = 0;   // 消費税等(2年以内)
	
    private long mikeikaLeaseWithinThreeYears     = 0;   // 未経過リース料(3年以内)
	
	private long zankaHosyogakuWithinThreeYears   = 0;   // 残価保証額(3年以内)
	
	private long ganponWithinThreeYears           = 0;   // 元本(3年以内)
	
	private long risokuWithinThreeYears           = 0;   // 利息(3年以内)
	
	private long izikanrihiWithinThreeYears       = 0;   // 維持管理費(3年以内)
	
	private long ekimuteikyouhiWithinThreeYears   = 0;   // 役務提供費(3年以内)
	
	private long syohizeiWithinThreeYears         = 0;   // 消費税等(3年以内) 
	
    private long mikeikaLeaseWithinFourYears     = 0;    // 未経過リース料(4年以内)
	
	private long zankaHosyogakuWithinFourYears   = 0;    // 残価保証額(4年以内)
	
	private long ganponWithinFourYears           = 0;    // 元本(4年以内)
	
	private long risokuWithinFourYears           = 0;    // 利息(4年以内)
	
	private long izikanrihiWithinFourYears       = 0;    // 維持管理費(4年以内)
	
	private long ekimuteikyouhiWithinFourYears   = 0;    // 役務提供費(4年以内)
	
	private long syohizeiWithinFourYears         = 0;    // 消費税等(4年以内)
	
    private long mikeikaLeaseWithinFiveYears     = 0;    // 未経過リース料(5年以内)
	
	private long zankaHosyogakuWithinFiveYears   = 0;    // 残価保証額(5年以内)
	
	private long ganponWithinFiveYears           = 0;    // 元本(5年以内)
	
	private long risokuWithinFiveYears           = 0;    // 利息(5年以内)
	 
	private long izikanrihiWithinFiveYears       = 0;    // 維持管理費(5年以内)
	
	private long ekimuteikyouhiWithinFiveYears   = 0;    // 役務提供費(5年以内)
	
	private long syohizeiWithinFiveYears         = 0;    // 消費税等(5年以内)
	
    private long mikeikaLeaseOverFiveYears     = 0;     // 未経過リース料(5年超)
	
	private long zankaHosyogakuOverFiveYears   = 0;     // 残価保証額(5年超)
	
	private long ganponOverFiveYears           = 0;     // 元本(5年超)
	
	private long risokuOverFiveYears           = 0;     // 利息(5年超)
	
	private long izikanrihiOverFiveYears       = 0;     // 維持管理費(5年超)
	
	private long ekimuteikyouhiOverFiveYears   = 0;     // 役務提供費(5年超)
	
	private long syohizeiOverFiveYears         = 0;     // 消費税等(5年超)
	
    private long mikeikaLeaseTotal            = 0;     // 未経過リース料(合計)
	
	private long zankaHosyogakuTotal          = 0;     // 残価保証額(合計)
	
	private long ganponTotal                  = 0;     // 元本(合計)
	
	private long risokuTotal                  = 0;     // 利息(合計)
	
	private long izikanrihiTotal              = 0;     // 維持管理費(合計)
	
	private long ekimuteikyouhiTotal          = 0;     // 役務提供費(合計)
	
	private long syohizeiTotal                = 0;     // 消費税等(合計)
	
	private String breakKey0                    = "";     // ブレイクキー0
	
	private String breakKey1                    = "";     // ブレイクキー1

	private String breakKey2                    = "";     // ブレイクキー2
	
	private String breakKey3                    = "";     // ブレイクキー3
	
	private String breakKey4                    = "";     // ブレイクキー4
	
	private String breakKey5                    = "";     // ブレイクキー5
	
//	private String total = "";

	
	/**
	 * ブレイクキー0を取得.
	 * 
	 * @return ブレイクキー0
	 */
	public String getBrakeKey0() {
		return this.breakKey0;
	}

	/**
	 * ブレイクキー0を設定.
	 * 
	 * @param piBrakeKey0
	 *           ブレイクキー0
	 */
	public void setBrakeKey0(String piBrakeKey0) {
		this.breakKey0 = piBrakeKey0;
	}

	/**
	 * ブレイクキー1を取得.
	 * 
	 * @return ブレイクキー1
	 */
	public String getBrakeKey1() {
		return this.breakKey1;
	}

	/**
	 * ブレイクキー1を設定.
	 * 
	 * @param piBrakeKey1
	 *           ブレイクキー1
	 */
	public void setBrakeKey1(String piBrakeKey1) {
		this.breakKey1 = piBrakeKey1;
	}

	/**
	 * ブレイクキー2を取得.
	 * 
	 * @return ブレイクキー2
	 */
	public String getBrakeKey2() {
		return this.breakKey2;
	}

	/**
	 * ブレイクキー2を設定.
	 * 
	 * @param piBrakeKey2
	 *           ブレイクキー2
	 */
	public void setBrakeKey2(String piBrakeKey2) {
		this.breakKey2 = piBrakeKey2;
	}
	
	/**
	 * ブレイクキー3を取得.
	 * 
	 * @return ブレイクキー3
	 */
	public String getBrakeKey3() {
		return this.breakKey3;
	}

	/**
	 * ブレイクキー3を設定.
	 * 
	 * @param piBrakeKey3
	 *           ブレイクキー3
	 */
	public void setBrakeKey3(String piBrakeKey3) {
		this.breakKey3 = piBrakeKey3;
	}

	/**
	 * ブレイクキー4を取得.
	 * 
	 * @return ブレイクキー4
	 */
	public String getBrakeKey4() {
		return this.breakKey4;
	}

	/**
	 * ブレイクキー4を設定.
	 * 
	 * @param piBrakeKey4
	 *           ブレイクキー4
	 */
	public void setBrakeKey4(String piBrakeKey4) {
		this.breakKey4 = piBrakeKey4;
	}

	/**
	 * ブレイクキー5を取得.
	 * 
	 * @return ブレイクキー5
	 */
	public String getBrakeKey5() {
		return this.breakKey5;
	}

	/**
	 * ブレイクキー5を設定.
	 * 
	 * @param piBrakeKey5
	 *           ブレイクキー5
	 */
	public void setBrakeKey5(String piBrakeKey5) {
		this.breakKey5 = piBrakeKey5;
	}

	
	
	/**
	 * リース会社を取得.
	 * 
	 * @return リース会社
	 */
	public String getLeaseCompany() {
		return this.leaseCompany;
	}

	/**
	 * リース会社を設定.
	 * 
	 * @param piLeaseCompany
	 *           リース会社
	 */
	public void setLeaseCompany(String piLeaseCompany) {
		this.leaseCompany = piLeaseCompany;
	}

	/**
	 * 開示先を取得.
	 * 
	 * @return 開示先
	 */
	public String getKaizisaki() {
		return this.kaizisaki;
	}

	/**
	 * 開示先を設定.
	 * 
	 * @param piKaizisaki
	 *           開示先
	 */
	public void setKaizisaki(String piKaizisaki) {
		this.kaizisaki = piKaizisaki;
	}

	/**
	 * 開示先を取得.
	 * 
	 * @return 開示先
	 */
	public String getBaseDate() {
		return this.baseDate;
	}

	/**
	 * 開示先を設定.
	 * 
	 * @param piKaizisaki
	 *           開示先
	 */
	public void setBaseDate(String piBaseDate) {
		this.baseDate = piBaseDate;
	}

	
	
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
	 * @param pijysiUm
	 *           重要性有無
	 */
	public void setJysiUm(String piJysiNm) {
		this.jysiUm = piJysiNm;
	}
	
	/**
	 * リース取引分類を取得.
	 * 
	 * @return リース取引分類
	 */
	public String getLeaseBunrui() {
		return this.leaseBunrui;
	}

	/**
	 * リース取引分類を設定.
	 * 
	 * @param piLeaseBunrui
	 *           リース取引分類
	 */
	public void setLeaseBunrui(String piLeaseBunrui) {
		this.leaseBunrui = piLeaseBunrui;
	}
	
	/**
	 * 会計処理方法を取得.
	 * 
	 * @return 会計処理方法
	 */
	public String getKaikeisyoriHouhou() {
		return this.kaikeiSyoriHouhou;
	}

	/**
	 * 会計処理方法を設定.
	 * 
	 * @param piKaikeiSyoriHouhou
	 *           会計処理方法
	 */
	public void setKaikeiSyoriHouhou(String piKaikeiSyoriHouhou) {
		this.kaikeiSyoriHouhou = piKaikeiSyoriHouhou;
	}

	/**
	 * 利息相当額配分方法を取得.
	 * 
	 * @return 利息相当額配分方法
	 */
	public String getRisokuBunpaiHouhou() {
		return this.risokuBunpaiHouhou;
	}

	/**
	 * 利息相当額配分方法を設定.
	 * 
	 * @param piRisokuBunpaiHouhou
	 *           利息相当額配分方法
	 */
	public void setRisokuBunpaiHouhou(String piRisokuBunpaiHouhou) {
		this.risokuBunpaiHouhou = piRisokuBunpaiHouhou;
	}
	
	/**
	 * 当期支払リース料計算基準を取得.
	 * 
	 * @return 当期支払リース料計算基準
	 */
	public String getToukiReaseKeisanKijyun() {
		return this.toukiReaseRyouKeisanKijyun;
	}

	/**
	 * 当期支払リース料計算基準を設定.
	 * 
	 * @param piToukiReaseKeisanKijyun
	 *           当期支払リース料計算基準
	 */
	public void setToukiReaseKeisanKijyun(String piToukiReaseKeisanKijyun) {
		this.toukiReaseRyouKeisanKijyun = piToukiReaseKeisanKijyun;
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
	 *           契約番号
	 */
	public void setKeiyakuNo(String piKeiyakuNo) {
		this.keiyakuNo = piKeiyakuNo;
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
	 * 物件番号を設定.
	 * 
	 * @param piBukkenNo
	 *           物件番号
	 */
	public void setBukenNo(String piBukenNo) {
		this.bukenNo = piBukenNo;
	}
	
	/**
	 * 物件名を取得.
	 * 
	 * @return 物件名
	 */
	public String getBukenName() {
		return this.bukenName;
	}

	/**
	 * 物件名を設定.
	 * 
	 * @param piBukkenName
	 *           物件名
	 */
	public void setBukenName(String piBukenName) {
		this.bukenName = piBukenName;
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
	 * リース開始日を設定.
	 * 
	 * @param piLeaseFrom
	 *           リース開始日
	 */
	public void setLeaseFrom(String piLeaseFrom) {
		this.leaseFrom = piLeaseFrom;
	}
	
	/**
	 * リース終了日を取得.
	 * 
	 * @return リース終了日
	 */
	public String getLeaseTo() {
		return this.leaseTo;
	}

	/**
	 * リース終了日を設定.
	 * 
	 * @param piLeaseTo
	 *           リース終了日
	 */
	public void setLeaseTo(String piLeaseTo) {
		this.leaseTo = piLeaseTo;
	}
	
	/**
	 * 中途解約日を取得.
	 * 
	 * @return 中途解約日
	 */
	public String getKaiyakuYmd() {
		return this.KaiyakuYmd;
	}

	/**
	 * 中途解約日を設定.
	 * 
	 * @param pityutoMD
	 *           中途解約日
	 */
	public void setKaiyakuYmd(String KaiyakuYmd) {
		this.KaiyakuYmd = KaiyakuYmd;
	}

	/**
	 * 未経過リース料(1年以内)を取得.
	 * 
	 * @return 未経過リース料(1年以内)
	 */
	public long getMikeikaLeaseWithinOneYear() {
		return mikeikaLeaseWithinOneYear;
	}

	/**
	 * 未経過リース料(1年以内)を設定.
	 * 
	 * @param pimikeikaLeaseWithinOneYear
	 *           未経過リース料(1年以内)
	 */
	public void setMikeikaLeaseWithinOneYear(long pimikeikaLeaseWithinOneYear) {
		this.mikeikaLeaseWithinOneYear = pimikeikaLeaseWithinOneYear;
	}

	/**
	 * 残価保証額(1年以内)を取得.
	 * 
	 * @return 残価保証額(1年以内)
	 */
	public long getZankaHosyogakuWithinOneYear() {
		return zankaHosyogakuWithinOneYear;
	}

	/**
	 * 残価保証額(1年以内)を設定.
	 * 
	 * @param pizankaHosyogakuWithinOneYear
	 *           残価保証額(1年以内)
	 */
	public void setZankaHosyogakuWithinOneYear(long pizankaHosyogakuWithinOneYear) {
		this.zankaHosyogakuWithinOneYear = pizankaHosyogakuWithinOneYear;
	}

	/**
	 * 元本(1年以内)を取得.
	 * 
	 * @return 元本(1年以内)
	 */
	public long getGanponWithinOneYear() {
		return ganponWithinOneYear;
	}

	/**
	 * 元本(1年以内)を設定.
	 * 
	 * @param piganponWithinOneYear
	 *           元本(1年以内)
	 */
	public void setGanponWithinOneYear(long piganponWithinOneYear) {
		this.ganponWithinOneYear = piganponWithinOneYear;
	}

	/**
	 * 利息(1年以内)を取得.
	 * 
	 * @return 利息(1年以内)
	 */
	public long getRisokuWithinOneYear() {
		return risokuWithinOneYear;
	}

	/**
	 * 利息(1年以内)を設定.
	 * 
	 * @param piganponWithinOneYear
	 *           利息(1年以内)
	 */
	public void setRisokuWithinOneYear(long pirisokuWithinOneYear) {
		this.risokuWithinOneYear = pirisokuWithinOneYear;
	}

	/**
	 * 維持管理費(1年以内)を取得.
	 * 
	 * @return 維持管理費(1年以内)
	 */
	public long getIzikanrihiWithinOneYear() {
		return izikanrihiWithinOneYear;
	}

	/**
	 * 維持管理費(1年以内)を設定.
	 * 
	 * @param piizikanrihiWithinOneYear
	 *          維持管理費(1年以内)
	 */
	public void setIzikanrihiWithinOneYear(long piizikanrihiWithinOneYear) {
		this.izikanrihiWithinOneYear = piizikanrihiWithinOneYear;
	}

	/**
	 * 役務提供費(1年以内)を取得.
	 * 
	 * @return 役務提供費(1年以内)
	 */
	public long getEkimuteikyouhiWithinOneYear() {
		return ekimuteikyouhiWithinOneYear;
	}

	/**
	 * 役務提供費(1年以内)を設定.
	 * 
	 * @param piizikanrihiWithinOneYear
	 *          役務提供費(1年以内)
	 */
	public void setEkimuteikyouhiWithinOneYear(long piekimuteikyouhiWithinOneYear) {
		this.ekimuteikyouhiWithinOneYear = piekimuteikyouhiWithinOneYear;
	}

	/**
	 * 消費税等(1年以内)を取得.
	 * 
	 * @return 消費税等(1年以内)
	 */
	public long getSyohizeiWithinOneYear() {
		return syohizeiWithinOneYear;
	}

	/**
	 * 消費税等(1年以内)を設定.
	 * 
	 * @param pisyohizeiWithinOneYear
	 *          消費税等(1年以内)
	 */
	public void setSyohizeiWithinOneYear(long pisyohizeiWithinOneYear) {
		this.syohizeiWithinOneYear = pisyohizeiWithinOneYear;
	}

	/**
	 * 未経過リース料(2年以内)を取得.
	 * 
	 * @return 未経過リース料(2年以内)
	 */
	public long getMikeikaLeaseWithinTwoYears() {
		return mikeikaLeaseWithinTwoYears;
	}

	/**
	 * 未経過リース料(2年以内)を取得.
	 * 
	 * @param pimikeikaLeaseWithinTwoYear
	 *          未経過リース料(2年以内)
	 */
	public void setMikeikaLeaseWithinTwoYears(long pimikeikaLeaseWithinTwoYears) {
		this.mikeikaLeaseWithinTwoYears = pimikeikaLeaseWithinTwoYears;
	}

	/**
	 * 残価保証額(2年以内)を取得.
	 * 
	 * @return 残価保証額(2年以内)
	 */
	public long getZankaHosyogakuWithinTwoYears() {
		return zankaHosyogakuWithinTwoYears;
	}

	/**
	 * 残価保証額(2年以内)を設定.
	 * 
	 * @param pizankaHosyogakuWithinTwoYear
	 *           残価保証額(2年以内)
	 */
	public void setZankaHosyogakuWithinTwoYears(long pizankaHosyogakuWithinTwoYears) {
		this.zankaHosyogakuWithinTwoYears = pizankaHosyogakuWithinTwoYears;
	}

	/**
	 * 元本(2年以内)を取得.
	 * 
	 * @return 元本(2年以内)
	 */
	public long getGanponWithinTwoYears() {
		return ganponWithinTwoYears;
	}

	/**
	 * 元本(2年以内)を設定.
	 * 
	 * @param piganponWithinTwoYear
	 *           元本(2年以内)
	 */
	public void setGanponWithinTwoYears(long piganponWithinTwoYears) {
		this.ganponWithinTwoYears = piganponWithinTwoYears;
	}

	/**
	 * 利息(2年以内)を取得.
	 * 
	 * @return 利息(2年以内)
	 */
	public long getRisokuWithinTwoYears() {
		return risokuWithinTwoYears;
	}

	/**
	 * 利息(2年以内)を設定.
	 * 
	 * @param piganponWithinOneYear
	 *           利息(2年以内)
	 */
	public void setRisokuWithinTwoYear(long pirisokuWithinTwoYears) {
		this.risokuWithinTwoYears = pirisokuWithinTwoYears;
	}

	/**
	 * 維持管理費(2年以内)を取得.
	 * 
	 * @return 維持管理費(2年以内)
	 */
	public long getIzikanrihiWithinTwoYears() {
		return izikanrihiWithinTwoYears;
	}

	/**
	 * 維持管理費(2年以内)を設定.
	 * 
	 * @param piizikanrihiWithinTwoYear
	 *          維持管理費(2年以内)
	 */
	public void setIzikanrihiWithinTwoYears(long piizikanrihiWithinTwoYears) {
		this.izikanrihiWithinTwoYears = piizikanrihiWithinTwoYears;
	}

	/**
	 * 役務提供費(2年以内)を取得.
	 * 
	 * @return 役務提供費(2年以内)
	 */
	public long getEkimuteikyouhiWithinTwoYears() {
		return ekimuteikyouhiWithinTwoYears;
	}

	/**
	 * 役務提供費(2年以内)を設定.
	 * 
	 * @param piizikanrihiWithinTwoYear
	 *          役務提供費(2年以内)
	 */
	public void setEkimuteikyouhiWithinTwoYear(long piekimuteikyouhiWithinTwoYears) {
		this.ekimuteikyouhiWithinTwoYears = piekimuteikyouhiWithinTwoYears;
	}

	/**
	 * 消費税等(2年以内)を取得.
	 * 
	 * @return 消費税等(2年以内)
	 */
	public long getSyohizeiWithinTwoYears() {
		return syohizeiWithinTwoYears;
	}

	/**
	 * 消費税等(2年以内)を設定.
	 * 
	 * @param pisyohizeiWithinTwoYear
	 *          消費税等(2年以内)
	 */
	public void setSyohizeiWithinTwoYears(long pisyohizeiWithinTwoYears) {
		this.syohizeiWithinTwoYears = pisyohizeiWithinTwoYears;
	}

	/**
	 * 未経過リース料(3年以内)を取得.
	 * 
	 * @return 未経過リース料(3年以内)
	 */
	public long getMikeikaLeaseWithinThreeYears() {
		return mikeikaLeaseWithinThreeYears;
	}

	/**
	 * 未経過リース料(3年以内)を取得.
	 * 
	 * @param pimikeikaLeaseWithinThreeYears
	 *          未経過リース料(3年以内)
	 */
	public void setMikeikaLeaseWithinThreeYears(long pimikeikaLeaseWithinThreeYears) {
		this.mikeikaLeaseWithinThreeYears = pimikeikaLeaseWithinThreeYears;
	}

	/**
	 * 残価保証額(3年以内)を取得.
	 * 
	 * @return 残価保証額(3年以内)
	 */
	public long getZankaHosyogakuWithinThreeYears() {
		return zankaHosyogakuWithinThreeYears;
	}

	/**
	 * 残価保証額(3年以内)を設定.
	 * 
	 * @param pizankaHosyogakuWithinThreeYears
	 *           残価保証額(3年以内)
	 */
	public void setZankaHosyogakuWithinThreeYears(long pizankaHosyogakuWithinThreeYears) {
		this.zankaHosyogakuWithinThreeYears = pizankaHosyogakuWithinThreeYears;
	}

	/**
	 * 元本(3年以内)を取得.
	 * 
	 * @return 元本(3年以内)
	 */
	public long getGanponWithinThreeYears() {
		return ganponWithinThreeYears;
	}

	/**
	 * 元本(3年以内)を設定.
	 * 
	 * @param piganponWithinThreeYears
	 *           元本(3年以内)
	 */
	public void setGanponWithinThreeYears(long piganponWithinThreeYears) {
		this.ganponWithinThreeYears = piganponWithinThreeYears;
	}

	/**
	 * 利息(3年以内)を取得.
	 * 
	 * @return 利息(3年以内)
	 */
	public long getRisokuWithinThreeYears() {
		return risokuWithinThreeYears;
	}

	/**
	 * 利息(3年以内)を設定.
	 * 
	 * @param piganponWithinThreeYears
	 *           利息(3年以内)
	 */
	public void setRisokuWithinThreeYears(long pirisokuWithinThreeYears) {
		this.risokuWithinThreeYears = pirisokuWithinThreeYears;
	}

	/**
	 * 維持管理費(3年以内)を取得.
	 * 
	 * @return 維持管理費(3年以内)
	 */
	public long getIzikanrihiWithinThreeYears() {
		return izikanrihiWithinThreeYears;
	}

	/**
	 * 維持管理費(3年以内)を設定.
	 * 
	 * @param piizikanrihiWithinThreeYears
	 *          維持管理費(3年以内)
	 */
	public void setIzikanrihiWithinThreeYears(long piizikanrihiWithinThreeYears) {
		this.izikanrihiWithinThreeYears = piizikanrihiWithinThreeYears;
	}

	/**
	 * 役務提供費(3年以内)を取得.
	 * 
	 * @return 役務提供費(3年以内)
	 */
	public long getEkimuteikyouhiWithinThreeYears() {
		return ekimuteikyouhiWithinThreeYears;
	}

	/**
	 * 役務提供費(3年以内)を設定.
	 * 
	 * @param piizikanrihiWithinThreeYears
	 *          役務提供費(3年以内)
	 */
	public void setEkimuteikyouhiWithinThreeYears(long piekimuteikyouhiWithinThreeYears) {
		this.ekimuteikyouhiWithinThreeYears = piekimuteikyouhiWithinThreeYears;
	}

	/**
	 * 消費税等(3年以内)を取得.
	 * 
	 * @return 消費税等(3年以内)
	 */
	public long getSyohizeiWithinThreeYears() {
		return syohizeiWithinThreeYears;
	}

	/**
	 * 消費税等(3年以内)を設定.
	 * 
	 * @param pisyohizeiWithinThreeYears
	 *          消費税等(3年以内)
	 */
	public void setSyohizeiWithinThreeYears(long pisyohizeiWithinThreeYears) {
		this.syohizeiWithinThreeYears = pisyohizeiWithinThreeYears;
	}
	
	/**
	 * 未経過リース料(4年以内)を取得.
	 * 
	 * @return 未経過リース料(4年以内)
	 */
	public long getMikeikaLeaseWithinFourYears() {
		return mikeikaLeaseWithinFourYears;
	}

	/**
	 * 未経過リース料(4年以内)を取得.
	 * 
	 * @param pimikeikaLeaseWithinFourYears
	 *          未経過リース料(4年以内)
	 */
	public void setMikeikaLeaseWithinFourYears(long pimikeikaLeaseWithinFourYears) {
		this.mikeikaLeaseWithinFourYears = pimikeikaLeaseWithinFourYears;
	}

	/**
	 * 残価保証額(4年以内)を取得.
	 * 
	 * @return 残価保証額(4年以内)
	 */
	public long getZankaHosyogakuWithinFourYears() {
		return zankaHosyogakuWithinFourYears;
	}

	/**
	 * 残価保証額(4年以内)を設定.
	 * 
	 * @param pizankaHosyogakuWithinFourYears
	 *           残価保証額(4年以内)
	 */
	public void setZankaHosyogakuWithinFourYears(long pizankaHosyogakuWithinFourYears) {
		this.zankaHosyogakuWithinFourYears = pizankaHosyogakuWithinFourYears;
	}

	/**
	 * 元本(4年以内)を取得.
	 * 
	 * @return 元本(4年以内)
	 */
	public long getGanponWithinFourYears() {
		return ganponWithinFourYears;
	}

	/**
	 * 元本(4年以内)を設定.
	 * 
	 * @param piganponWithinFourYears
	 *           元本(4年以内)
	 */
	public void setGanponWithinFourYears(long piganponWithinFourYears) {
		this.ganponWithinFourYears = piganponWithinFourYears;
	}

	/**
	 * 利息(4年以内)を取得.
	 * 
	 * @return 利息(4年以内)
	 */
	public long getRisokuWithinFourYears() {
		return risokuWithinFourYears;
	}

	/**
	 * 利息(4年以内)を設定.
	 * 
	 * @param piganponWithinFourYears
	 *           利息(4年以内)
	 */
	public void setRisokuWithinFourYears(long pirisokuWithinFourYears) {
		this.risokuWithinFourYears = pirisokuWithinFourYears;
	}

	/**
	 * 維持管理費(4年以内)を取得.
	 * 
	 * @return 維持管理費(4年以内)
	 */
	public long getIzikanrihiWithinFourYears() {
		return izikanrihiWithinFourYears;
	}

	/**
	 * 維持管理費(4年以内)を設定.
	 * 
	 * @param piizikanrihiWithinFourYears
	 *          維持管理費(4年以内)
	 */
	public void setIzikanrihiWithinFourYears(long piizikanrihiWithinFourYears) {
		this.izikanrihiWithinFourYears = piizikanrihiWithinFourYears;
	}

	/**
	 * 役務提供費(4年以内)を取得.
	 * 
	 * @return 役務提供費(4年以内)
	 */
	public long getEkimuteikyouhiWithinFourYears() {
		return ekimuteikyouhiWithinFourYears;
	}

	/**
	 * 役務提供費(4年以内)を設定.
	 * 
	 * @param piizikanrihiWithinFourYears
	 *          役務提供費(4年以内)
	 */
	public void setEkimuteikyouhiWithinFourYears(long piekimuteikyouhiWithinFourYears) {
		this.ekimuteikyouhiWithinFourYears = piekimuteikyouhiWithinFourYears;
	}

	/**
	 * 消費税等(4年以内)を取得.
	 * 
	 * @return 消費税等(4年以内)
	 */
	public long getSyohizeiWithinFourYears() {
		return syohizeiWithinFourYears;
	}

	/**
	 * 消費税等(4年以内)を設定.
	 * 
	 * @param pisyohizeiWithinFourYears
	 *          消費税等(4年以内)
	 */
	public void setSyohizeiWithinFourYears(long pisyohizeiWithinFourYears) {
		this.syohizeiWithinFourYears = pisyohizeiWithinFourYears;
	}
	
	/**
	 * 未経過リース料(5年以内)を取得.
	 * 
	 * @return 未経過リース料(5年以内)
	 */
	public long getMikeikaLeaseWithinFiveYears() {
		return mikeikaLeaseWithinFiveYears;
	}

	/**
	 * 未経過リース料(5年以内)を取得.
	 * 
	 * @param pimikeikaLeaseWithinFiveYears
	 *          未経過リース料(5年以内)
	 */
	public void setMikeikaLeaseWithinFiveYears(long pimikeikaLeaseWithinFiveYears) {
		this.mikeikaLeaseWithinFiveYears = pimikeikaLeaseWithinFiveYears;
	}

	/**
	 * 残価保証額(5年以内)を取得.
	 * 
	 * @return 残価保証額(5年以内)
	 */
	public long getZankaHosyogakuWithinFiveYears() {
		return zankaHosyogakuWithinFiveYears;
	}

	/**
	 * 残価保証額(5年以内)を設定.
	 * 
	 * @param pizankaHosyogakuWithinFiveYears
	 *           残価保証額(5年以内)
	 */
	public void setZankaHosyogakuWithinFiveYears(long pizankaHosyogakuWithinFiveYears) {
		this.zankaHosyogakuWithinFiveYears = pizankaHosyogakuWithinFiveYears;
	}

	/**
	 * 元本(5年以内)を取得.
	 * 
	 * @return 元本(5年以内)
	 */
	public long getGanponWithinFiveYears() {
		return ganponWithinFiveYears;
	}

	/**
	 * 元本(5年以内)を設定.
	 * 
	 * @param piganponWithinFiveYears
	 *           元本(5年以内)
	 */
	public void setGanponWithinFiveYears(long piganponWithinFiveYears) {
		this.ganponWithinFiveYears = piganponWithinFiveYears;
	}

	/**
	 * 利息(5年以内)を取得.
	 * 
	 * @return 利息(5年以内)
	 */
	public long getRisokuWithinFiveYears() {
		return risokuWithinFiveYears;
	}

	/**
	 * 利息(5年以内)を設定.
	 * 
	 * @param piganponWithinFiveYears
	 *           利息(5年以内)
	 */
	public void setRisokuWithinFiveYears(long pirisokuWithinFiveYears) {
		this.risokuWithinFiveYears = pirisokuWithinFiveYears;
	}

	/**
	 * 維持管理費(5年以内)を取得.
	 * 
	 * @return 維持管理費(5年以内)
	 */
	public long getIzikanrihiWithinFiveYears() {
		return izikanrihiWithinFiveYears;
	}

	/**
	 * 維持管理費(5年以内)を設定.
	 * 
	 * @param piizikanrihiWithinFiveYears
	 *          維持管理費(5年以内)
	 */
	public void setIzikanrihiWithinFiveYears(long piizikanrihiWithinFiveYears) {
		this.izikanrihiWithinFiveYears = piizikanrihiWithinFiveYears;
	}

	/**
	 * 役務提供費(5年以内)を取得.
	 * 
	 * @return 役務提供費(5年以内)
	 */
	public long getEkimuteikyouhiWithinFiveYears() {
		return ekimuteikyouhiWithinFiveYears;
	}

	/**
	 * 役務提供費(5年以内)を設定.
	 * 
	 * @param piizikanrihiWithinFiveYears
	 *          役務提供費(5年以内)
	 */
	public void setEkimuteikyouhiWithinFiveYears(long piekimuteikyouhiWithinFiveYears) {
		this.ekimuteikyouhiWithinFiveYears = piekimuteikyouhiWithinFiveYears;
	}

	/**
	 * 消費税等(5年以内)を取得.
	 * 
	 * @return 消費税等(5年以内)
	 */
	public long getSyohizeiWithinFiveYears() {
		return syohizeiWithinFiveYears;
	}

	/**
	 * 消費税等(5年以内)を設定.
	 * 
	 * @param pisyohizeiWithinFiveYears
	 *          消費税等(5年以内)
	 */
	public void setSyohizeiWithinFiveYears(long pisyohizeiWithinFiveYears) {
		this.syohizeiWithinFiveYears = pisyohizeiWithinFiveYears;
	}
	
	/**
	 * 未経過リース料(5年超)を取得.
	 * 
	 * @return 未経過リース料(5年超)
	 */
	public long getMikeikaLeaseOverFiveYears() {
		return mikeikaLeaseOverFiveYears;
	}

	/**
	 * 未経過リース料(5年超)を取得.
	 * 
	 * @param pimikeikaLeaseOverFiveYears
	 *          未経過リース料(5年超)
	 */
	public void setMikeikaLeaseOverFiveYears(long pimikeikaLeaseOverFiveYears) {
		this.mikeikaLeaseOverFiveYears = pimikeikaLeaseOverFiveYears;
	}

	/**
	 * 残価保証額(5年超)を取得.
	 * 
	 * @return 残価保証額(5年超)
	 */
	public long getZankaHosyogakuOverFiveYears() {
		return zankaHosyogakuOverFiveYears;
	}

	/**
	 * 残価保証額(5年超)を設定.
	 * 
	 * @param pizankaHosyogakuOverFiveYears
	 *           残価保証額(5年超)
	 */
	public void setZankaHosyogakuOverFiveYears(long pizankaHosyogakuOverFiveYears) {
		this.zankaHosyogakuOverFiveYears = pizankaHosyogakuOverFiveYears;
	}

	/**
	 * 元本(5年超)を取得.
	 * 
	 * @return 元本(5年超)
	 */
	public long getGanponOverFiveYears() {
		return ganponOverFiveYears;
	}

	/**
	 * 元本(5年超)を設定.
	 * 
	 * @param piganponOverFiveYears
	 *           元本(5年超)
	 */
	public void setGanponOverFiveYears(long piganponOverFiveYears) {
		this.ganponOverFiveYears = piganponOverFiveYears;
	}

	/**
	 * 利息(5年超)を取得.
	 * 
	 * @return 利息(5年超)
	 */
	public long getRisokuOverFiveYears() {
		return risokuOverFiveYears;
	}

	/**
	 * 利息(5年超)を設定.
	 * 
	 * @param piganponWithinOneYear
	 *           利息(5年超)
	 */
	public void setRisokuOverFiveYears(long pirisokuOverFiveYears) {
		this.risokuOverFiveYears = pirisokuOverFiveYears;
	}

	/**
	 * 維持管理費(5年超)を取得.
	 * 
	 * @return 維持管理費(5年超)
	 */
	public long getIzikanrihiOverFiveYears() {
		return izikanrihiOverFiveYears;
	}

	/**
	 * 維持管理費(5年超)を設定.
	 * 
	 * @param piizikanrihiOverFiveYears
	 *          維持管理費(5年超)
	 */
	public void setIzikanrihiOverFiveYears(long piizikanrihiOverFiveYears) {
		this.izikanrihiOverFiveYears = piizikanrihiOverFiveYears;
	}

	/**
	 * 役務提供費(5年超)を取得.
	 * 
	 * @return 役務提供費(5年超)
	 */
	public long getEkimuteikyouhiOverFiveYears() {
		return ekimuteikyouhiOverFiveYears;
	}

	/**
	 * 役務提供費(5年超)を設定.
	 * 
	 * @param piizikanrihiOverFiveYears
	 *          役務提供費(5年超)
	 */
	public void setEkimuteikyouhiOverFiveYears(long piekimuteikyouhiOverFiveYears) {
		this.ekimuteikyouhiOverFiveYears = piekimuteikyouhiOverFiveYears;
	}

	/**
	 * 消費税等(5年超)を取得.
	 * 
	 * @return 消費税等(5年超)
	 */
	public long getSyohizeiOverFiveYears() {
		return syohizeiOverFiveYears;
	}

	/**
	 * 消費税等(5年超)を設定.
	 * 
	 * @param pisyohizeiOverFiveYears
	 *          消費税等(5年超)
	 */
	public void setSyohizeiOverFiveYears(long pisyohizeiOverFiveYears) {
		this.syohizeiOverFiveYears = pisyohizeiOverFiveYears;
	}
	
	
	/**
	 * 未経過リース料(合計)を取得.
	 * 
	 * @return 未経過リース料(合計)
	 */
	public long getMikeikaLeaseTotal() {
		return mikeikaLeaseTotal;
	}

	/**
	 * 未経過リース料(合計)を取得.
	 * 
	 * @param pimikeikaLeaseTotal
	 *          未経過リース料(合計)
	 */
	public void setMikeikaLeaseTotal(long pimikeikaLeaseTotal) {
		this.mikeikaLeaseTotal = pimikeikaLeaseTotal;
	}

	/**
	 * 残価保証額(合計)を取得.
	 * 
	 * @return 残価保証額(合計)
	 */
	public long getZankaHosyogakuTotal() {
		return zankaHosyogakuTotal;
	}

	/**
	 * 残価保証額(合計)を設定.
	 * 
	 * @param pizankaHosyogakuTotal
	 *           残価保証額(合計)
	 */
	public void setZankaHosyogakuTotal(long pizankaHosyogakuTotal) {
		this.zankaHosyogakuTotal = pizankaHosyogakuTotal;
	}

	/**
	 * 元本(合計)を取得.
	 * 
	 * @return 元本(合計)
	 */
	public long getGanponTotal() {
		return ganponTotal;
	}

	/**
	 * 元本(合計)を設定.
	 * 
	 * @param piganponTotal
	 *           元本(合計)
	 */
	public void setGanponTotal(long piganponTotal) {
		this.ganponTotal = piganponTotal;
	}

	/**
	 * 利息(合計)を取得.
	 * 
	 * @return 利息(合計)
	 */
	public long getRisokuTotal() {
		return risokuTotal;
	}

	/**
	 * 利息(合計)を設定.
	 * 
	 * @param piganponWithinOneYear
	 *           利息(合計)
	 */
	public void setRisokuTotal(long pirisokuTotal) {
		this.risokuTotal = pirisokuTotal;
	}

	/**
	 * 維持管理費(合計)を取得.
	 * 
	 * @return 維持管理費(合計)
	 */
	public long getIzikanrihiTotal() {
		return izikanrihiTotal;
	}

	/**
	 * 維持管理費(合計)を設定.
	 * 
	 * @param piizikanrihiTotal
	 *          維持管理費(合計)
	 */
	public void setIzikanrihiTotal(long piizikanrihiTotal) {
		this.izikanrihiTotal = piizikanrihiTotal;
	}

	/**
	 * 役務提供費(合計)を取得.
	 * 
	 * @return 役務提供費(合計)
	 */
	public long getEkimuteikyouhiTotal() {
		return ekimuteikyouhiTotal;
	}

	/**
	 * 役務提供費(合計)を設定.
	 * 
	 * @param piizikanrihiTotal
	 *          役務提供費(合計)
	 */
	public void setEkimuteikyouhiTotal(long piekimuteikyouhiTotal) {
		this.ekimuteikyouhiTotal = piekimuteikyouhiTotal;
	}

	/**
	 * 消費税等(合計)を取得.
	 * 
	 * @return 消費税等(合計)
	 */
	public long getSyohizeiTotal() {
		return syohizeiTotal;
	}

	/**
	 * 消費税等(合計)を設定.
	 * 
	 * @param pisyohizeiTotal
	 *          消費税等(合計)
	 */
	public void setSyohizeiTotal(long pisyohizeiTotal) {
		this.syohizeiTotal = pisyohizeiTotal;
	}
	
	
	

}
