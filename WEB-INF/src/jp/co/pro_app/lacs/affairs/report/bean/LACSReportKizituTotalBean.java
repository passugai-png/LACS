package jp.co.pro_app.lacs.affairs.report.bean;

/**
 * 帳票出力：期日別予定表（合計表）Bean.
 * 
 * @author arai
 * @version 20200615
 */

public class LACSReportKizituTotalBean {

	private String createdate                          = "";   // 作成日

	private String kijundate                            = "";   // 基準日

	private String leaseCompany                        = "";   // リース会社
	 
	private String Lu_nm                              = "";   // 開示先名

	private String jysiUm                              = "";   // 重要性有無
	
	private String leaseBunrui                         = "";   // リース取引分類
	
	private String kaikeiSyoriHouhou                   = "";   // 会計処理方法
	
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

    private String usyutokukagakuWithinOneYear          = "";   // 有形 - 取得価額(1年以内)
	
	private String ugenkaSyokyakuRuikeiWithinOneYear    = "";   // 有形 - 減価償却累計額(1年以内)
	
	private long ugenkaSyokyahiWithinOneYear     = 0;   // 有形 - 減価償却費(1年以内)
	
	private long ubokaWithinOneYear                   = 0;   // 有形 - 簿価(1年以内)
		
	private String usyutokukagakuWithinTwoYear          = "";   // 有形 - 取得価額(2年以内)
	
	private String ugenkaSyokyakuRuikeiWithinTwoYear    = "";   // 有形 - 減価償却累計額(2年以内)
	
	private long ugenkaSyokyahiWithinTwoYear     = 0;   // 有形 - 減価償却費(2年以内)
	
	private long ubokaWithinTwoYear                   = 0;   // 有形 - 簿価(2年以内)
	
    private String usyutokukagakuWithinThreeYear        = "";   // 有形 - 取得価額(3年以内)
	
	private String ugenkaSyokyakuRuikeiWithinThreeYear  = "";   // 有形 - 減価償却累計額(3年以内)
	
	private long ugenkaSyokyahiWithinThreeYear   = 0;   // 有形 - 減価償却費(3年以内)
	
	private long ubokaWithinThreeYear                 = 0;   // 有形 - 簿価(3年以内)
	
    private String usyutokukagakuWithinFourYear         = "";    // 有形 - 取得価額(4年以内)
	
	private String ugenkaSyokyakuRuikeiWithinFourYear   = "";    // 有形 - 減価償却累計額(4年以内)
	
	private long ugenkaSyokyahiWithinFourYear    = 0;    // 有形 - 減価償却費(4年以内)
	
	private long ubokaWithinFourYear                  = 0;    // 有形 - 簿価(4年以内)
	
    private String usyutokukagakuWithinFiveYear         = "";    // 有形 - 取得価額(5年以内)
	 
	private String ugenkaSyokyakuRuikeiWithinFiveYear   = "";    // 有形 - 減価償却累計額(5年以内)
	
	private long ugenkaSyokyahiWithinFiveYear    = 0;    // 有形 - 減価償却費(5年以内)
	
	private long ubokaWithinFiveYear                  = 0;    // 有形 - 簿価(5年以内)
	
    private String usyutokukagakuOverFiveYear           = "";    // 有形 - 取得価額(5年超)
	
	private String ugenkaSyokyakuRuikeiOverFiveYear     = "";    // 有形 - 減価償却累計額(5年超)
	
	private long ugenkaSyokyahiOverFiveYear      = 0;    // 有形 - 減価償却費(5年超)
	
	private long ubokaOverFiveYear                    = 0;    // 有形 - 簿価(5年超)
	
    private long usyutokukagakuTotal                  = 0;    // 有形 - 取得価額(合計)
	
	private long ugenkaSyokyakuRuikeiTotal           = 0;    // 有形 - 減価償却累計額(合計)
	
	private String ugenkaSyokyahiTotal                 = "";    // 有形 - 減価償却費(合計)
	
	private long ubokaTotal                          = 0;    // 有形 - 簿価(合計)	
	
    private String msyutokukagakuWithinOneYear          = "";   // 無形 - 取得価額(1年以内)
	
	private String mgenkaSyokyakuRuikeiWithinOneYear    = "";   // 無形 - 減価償却累計額(1年以内)
	
	private long mgenkaSyokyahiWithinOneYear     = 0;   // 無形 - 減価償却費(1年以内)
	
	private long mbokaWithinOneYear                   = 0;   // 無形 - 簿価(1年以内)
		
	private String msyutokukagakuWithinTwoYear          = "";   // 無形 - 取得価額(2年以内)
	
	private String mgenkaSyokyakuRuikeiWithinTwoYear    = "";   // 無形 - 減価償却累計額(2年以内)
	
	private long mgenkaSyokyahiWithinTwoYear     = 0;   // 無形 - 減価償却費(2年以内)
	
	private long mbokaWithinTwoYear                   = 0;   // 無形 - 簿価(2年以内)
	
    private String msyutokukagakuWithinThreeYear        = "";   // 無形 - 取得価額(3年以内)
	
	private String mgenkaSyokyakuRuikeiWithinThreeYear  = "";   // 無形 - 減価償却累計額(3年以内)
	
	private long mgenkaSyokyahiWithinThreeYear   = 0;   // 無形 - 減価償却費(3年以内)
	
	private long mbokaWithinThreeYear                 = 0;   // 無形 - 簿価(3年以内)
	
    private String msyutokukagakuWithinFourYear         = "";    // 無形 - 取得価額(4年以内)
	
	private String mgenkaSyokyakuRuikeiWithinFourYear   = "";    // 無形 - 減価償却累計額(4年以内)
	
	private long mgenkaSyokyahiWithinFourYear    = 0;    // 無形 - 減価償却費(4年以内)
	
	private long mbokaWithinFourYear                  = 0;    // 無形 - 簿価(4年以内)
	
    private String msyutokukagakuWithinFiveYear         = "";    // 無形 - 取得価額(5年以内)
	 
	private String mgenkaSyokyakuRuikeiWithinFiveYear   = "";    // 無形 - 減価償却累計額(5年以内)
	
	private long mgenkaSyokyahiWithinFiveYear    = 0;    // 無形 - 減価償却費(5年以内)
	
	private long mbokaWithinFiveYear                  = 0;    // 無形 - 簿価(5年以内)
	
    private String msyutokukagakuOverFiveYear           = "";    // 無形 - 取得価額(5年超)
	
	private String mgenkaSyokyakuRuikeiOverFiveYear     = "";    // 無形 - 減価償却累計額(5年超)
	
	private long mgenkaSyokyahiOverFiveYear      = 0;    // 無形 - 減価償却費(5年超)
	
	private long mbokaOverFiveYear                    = 0;    // 無形 - 簿価(5年超)
	
    private long msyutokukagakuTotal                  = 0;    // 無形 - 取得価額(合計)
	
	private long mgenkaSyokyakuRuikeiTotal           = 0;    // 無形 - 減価償却累計額(合計)
	
	private String mgenkaSyokyahiTotal                 = "";    // 無形 - 減価償却費(合計)
	
	private long mbokaTotal                          = 0;    // 無形 - 簿価(合計)	
		
	
	
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
//
	/**
	 * 作成日を取得.
	 * 
	 * @return 作成日
	 */
	public String getCreateDate() {
		return this.createdate;
	}
	
	/**
	 * 作成日を設定.
	 * 
	 * @param piCreateDate
	 *           リース会社
	 */
	public void setCreateDate(String piCreateDate) {
		this.createdate = piCreateDate;
	}

	/**
	 * 基準日を取得.
	 * 
	 * @return 基準日
	 */
	public String getKijunDate() {
		return this.kijundate;
	}
	
	/**
	 * 基準日を設定.
	 * 
	 * @param piKijunDate
	 *           基準日
	 */
	public void setKijunDate(String piKijunDate) {
		this.kijundate = piKijunDate;
	}
//
	/**
	 * 開示先を取得.
	 * 
	 * @return 開示先
	 */
	public String getKaizisaki() {
		return this.Lu_nm;
	}
	
	/**
	 * 開示先を設定.
	 * 
	 * @param piLu_nm
	 *           開示先
	 */
	public void setKaizisaki(String piLu_nm) {
		this.Lu_nm = piLu_nm;
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

	
	/**
	 * 無形-取得価額(1年以内)を取得.
	 * 
	 * @return 無形-取得価額(1年以内)
	 */
	public String getmsyutokukagakuWithinOneYear() {
		return msyutokukagakuWithinOneYear;
	}

	/**
	 * 無形-取得価額(1年以内)を設定.
	 * 
	 * @param pimsyutokukagakuWithinOneYear
	 *           取得価(1年以内)額
	 */
	public void setmsyutokukagakuWithinOneYear(String pimsyutokukagakuWithinOneYear) {
		this.msyutokukagakuWithinOneYear = pimsyutokukagakuWithinOneYear;
	}

	/**
	 * 無形-減価償却累計額(1年以内)を取得.
	 * 
	 * @return 無形-減価償却累計額(1年以内)
	 */
	public String getmgenkaSyokyakuRuikeiWithinOneYear() {
		return mgenkaSyokyakuRuikeiWithinOneYear;
	}

	/**
	 * 無形-減価償却累計額(1年以内)を設定.
	 * 
	 * @param pimgenkaSyokyakuRuikeiWithinOneYear
	 *           無形-減価償却累計額(1年以内)
	 */
	public void setmgenkaSyokyakuRuikeiWithinOneYear(String pimgenkaSyokyakuRuikeiWithinOneYear) {
		this.mgenkaSyokyakuRuikeiWithinOneYear = pimgenkaSyokyakuRuikeiWithinOneYear;
	}

	/**
	 * 無形-減価償却費(1年以内)を取得.
	 * 
	 * @return 無形-減価償却費(1年以内)
	 */
	public long getmgenkaSyokyahiWithinOneYear() {
		return mgenkaSyokyahiWithinOneYear;
	}

	/**
	 * 無形-減価償却費(1年以内)を設定.
	 * 
	 * @param pimgenkaSyokyahiWithinOneYear
	 *           無形-減価償却費(1年以内)
	 */
	public void setmgenkaSyokyahiWithinOneYear(long pimgenkaSyokyahiWithinOneYear) {
		this.mgenkaSyokyahiWithinOneYear = pimgenkaSyokyahiWithinOneYear;
	}

	/**
	 * 無形-簿価(1年以内)を取得.
	 * 
	 * @return 無形-簿価(1年以内)
	 */
	public long getmbokaWithinOneYear() {
		return mbokaWithinOneYear;
	}

	/**
	 * 無形-簿価(1年以内)を設定.
	 * 
	 * @param pimbokaWithinOneYear
	 *           無形-簿価(1年以内)
	 */
	public void setmbokaWithinOneYear(long pimbokaWithinOneYear) {
		this.mbokaWithinOneYear = pimbokaWithinOneYear;
	}

	/**
	 * 無形-取得価額(2年以内)を取得.
	 * 
	 * @return 無形-取得価額(2年以内)
	 */
	public String getmsyutokukagakuWithinTwoYear() {
		return msyutokukagakuWithinTwoYear;
	}

	/**
	 * 無形-取得価額(2年以内)を設定.
	 * 
	 * @param pimsyutokukagakuWithinTwoYear
	 *           取得価(2年以内)額
	 */
	public void setmsyutokukagakuWithinTwoYear(String pimsyutokukagakuWithinTwoYear) {
		this.msyutokukagakuWithinTwoYear = pimsyutokukagakuWithinTwoYear;
	}

	/**
	 * 無形-減価償却累計額(2年以内)を取得.
	 * 
	 * @return 無形-減価償却累計額(2年以内)
	 */
	public String getmgenkaSyokyakuRuikeiWithinTwoYear() {
		return mgenkaSyokyakuRuikeiWithinTwoYear;
	}

	/**
	 * 無形-減価償却累計額(2年以内)を設定.
	 * 
	 * @param pimgenkaSyokyakuRuikeiWithinTwoYear
	 *           無形-減価償却累計額(2年以内)
	 */
	public void setmgenkaSyokyakuRuikeiWithinTwoYear(String pimgenkaSyokyakuRuikeiWithinTwoYear) {
		this.mgenkaSyokyakuRuikeiWithinTwoYear = pimgenkaSyokyakuRuikeiWithinTwoYear;
	}

	/**
	 * 無形-減価償却費(2年以内)を取得.
	 * 
	 * @return 無形-減価償却費(2年以内)
	 */
	public long getmgenkaSyokyahiWithinTwoYear() {
		return mgenkaSyokyahiWithinTwoYear;
	}

	/**
	 * 無形-減価償却費(2年以内)を設定.
	 * 
	 * @param pimgenkaSyokyahiWithinTwoYear
	 *           無形-減価償却費(2年以内)
	 */
	public void setmgenkaSyokyahiWithinTwoYear(long pimgenkaSyokyahiWithinTwoYear) {
		this.mgenkaSyokyahiWithinTwoYear = pimgenkaSyokyahiWithinTwoYear;
	}

	/**
	 * 無形-簿価(2年以内)を取得.
	 * 
	 * @return 無形-簿価(2年以内)
	 */
	public long getmbokaWithinTwoYear() {
		return mbokaWithinTwoYear;
	}

	/**
	 * 無形-簿価(2年以内)を設定.
	 * 
	 * @param pimbokaWithinTwoYear
	 *           無形-簿価(2年以内)
	 */
	public void setmbokaWithinTwoYear(long pimbokaWithinTwoYear) {
		this.mbokaWithinTwoYear = pimbokaWithinTwoYear;
	}

	/**
	 * 無形-取得価額(3年以内)を取得.
	 * 
	 * @return 無形-取得価額(3年以内)
	 */
	public String getmsyutokukagakuWithinThreeYear() {
		return msyutokukagakuWithinThreeYear;
	}

	/**
	 * 無形-取得価額(3年以内)を設定.
	 * 
	 * @param pimsyutokukagakuWithinThreeYear
	 *           取得価(3年以内)額
	 */
	public void setmsyutokukagakuWithinThreeYear(String pimsyutokukagakuWithinThreeYear) {
		this.msyutokukagakuWithinThreeYear = pimsyutokukagakuWithinThreeYear;
	}

	/**
	 * 無形-減価償却累計額(3年以内)を取得.
	 * 
	 * @return 無形-減価償却累計額(3年以内)
	 */
	public String getmgenkaSyokyakuRuikeiWithinThreeYear() {
		return mgenkaSyokyakuRuikeiWithinThreeYear;
	}

	/**
	 * 無形-減価償却累計額(3年以内)を設定.
	 * 
	 * @param pimgenkaSyokyakuRuikeiWithinThreeYear
	 *           無形-減価償却累計額(3年以内)
	 */
	public void setmgenkaSyokyakuRuikeiWithinThreeYear(String pimgenkaSyokyakuRuikeiWithinThreeYear) {
		this.mgenkaSyokyakuRuikeiWithinThreeYear = pimgenkaSyokyakuRuikeiWithinThreeYear;
	}

	/**
	 * 無形-減価償却費(3年以内)を取得.
	 * 
	 * @return 無形-減価償却費(3年以内)
	 */
	public long getmgenkaSyokyahiWithinThreeYear() {
		return mgenkaSyokyahiWithinThreeYear;
	}

	/**
	 * 無形-減価償却費(3年以内)を設定.
	 * 
	 * @param pimgenkaSyokyahiWithinThreeYear
	 *           無形-減価償却費(3年以内)
	 */
	public void setmgenkaSyokyahiWithinThreeYear(long pimgenkaSyokyahiWithinThreeYear) {
		this.mgenkaSyokyahiWithinThreeYear = pimgenkaSyokyahiWithinThreeYear;
	}

	/**
	 * 無形-簿価(3年以内)を取得.
	 * 
	 * @return 無形-簿価(3年以内)
	 */
	public long getmbokaWithinThreeYear() {
		return mbokaWithinThreeYear;
	}

	/**
	 * 無形-簿価(3年以内)を設定.
	 * 
	 * @param pimbokaWithinThreeYear
	 *           無形-簿価(3年以内)
	 */
	public void setmbokaWithinThreeYear(long pimbokaWithinThreeYear) {
		this.mbokaWithinThreeYear = pimbokaWithinThreeYear;
	}

	/**
	 * 無形-取得価額(4年以内)を取得.
	 * 
	 * @return 無形-取得価額(4年以内)
	 */
	public String getmsyutokukagakuWithinFourYear() {
		return msyutokukagakuWithinFourYear;
	}

	/**
	 * 無形-取得価額(4年以内)を設定.
	 * 
	 * @param pimsyutokukagakuWithinFourYear
	 *           取得価(4年以内)額
	 */
	public void setmsyutokukagakuWithinFourYear(String pimsyutokukagakuWithinFourYear) {
		this.msyutokukagakuWithinFourYear = pimsyutokukagakuWithinFourYear;
	}

	/**
	 * 無形-減価償却累計額(4年以内)を取得.
	 * 
	 * @return 無形-減価償却累計額(4年以内)
	 */
	public String getmgenkaSyokyakuRuikeiWithinFourYear() {
		return mgenkaSyokyakuRuikeiWithinFourYear;
	}

	/**
	 * 無形-減価償却累計額(4年以内)を設定.
	 * 
	 * @param pimgenkaSyokyakuRuikeiWithinFourYear
	 *           無形-減価償却累計額(4年以内)
	 */
	public void setmgenkaSyokyakuRuikeiWithinFourYear(String pimgenkaSyokyakuRuikeiWithinFourYear) {
		this.mgenkaSyokyakuRuikeiWithinFourYear = pimgenkaSyokyakuRuikeiWithinFourYear;
	}

	/**
	 * 無形-減価償却費(4年以内)を取得.
	 * 
	 * @return 無形-減価償却費(4年以内)
	 */
	public long getmgenkaSyokyahiWithinFourYear() {
		return mgenkaSyokyahiWithinFourYear;
	}

	/**
	 * 無形-減価償却費(4年以内)を設定.
	 * 
	 * @param pimgenkaSyokyahiWithinFourYear
	 *           無形-減価償却費(4年以内)
	 */
	public void setmgenkaSyokyahiWithinFourYear(long pimgenkaSyokyahiWithinFourYear) {
		this.mgenkaSyokyahiWithinFourYear = pimgenkaSyokyahiWithinFourYear;
	}

	/**
	 * 無形-簿価(4年以内)を取得.
	 * 
	 * @return 無形-簿価(4年以内)
	 */
	public long getmbokaWithinFourYear() {
		return mbokaWithinFourYear;
	}

	/**
	 * 無形-簿価(4年以内)を設定.
	 * 
	 * @param pimbokaWithinFourYear
	 *           無形-簿価(4年以内)
	 */
	public void setmbokaWithinFourYear(long pimbokaWithinFourYear) {
		this.mbokaWithinFourYear = pimbokaWithinFourYear;
	}
	
	/**
	 * 無形-取得価額(5年以内)を取得.
	 * 
	 * @return 無形-取得価額(5年以内)
	 */
	public String getmsyutokukagakuWithinFiveYear() {
		return msyutokukagakuWithinFiveYear;
	}

	/**
	 * 無形-取得価額(5年以内)を設定.
	 * 
	 * @param pimsyutokukagakuWithinFiveYear
	 *           取得価(5年以内)額
	 */
	public void setmsyutokukagakuWithinFiveYear(String pimsyutokukagakuWithinFiveYear) {
		this.msyutokukagakuWithinFiveYear = pimsyutokukagakuWithinFiveYear;
	}

	/**
	 * 無形-減価償却累計額(5年以内)を取得.
	 * 
	 * @return 無形-減価償却累計額(5年以内)
	 */
	public String getmgenkaSyokyakuRuikeiWithinFiveYear() {
		return mgenkaSyokyakuRuikeiWithinFiveYear;
	}

	/**
	 * 無形-減価償却累計額(5年以内)を設定.
	 * 
	 * @param pimgenkaSyokyakuRuikeiWithinFiveYear
	 *           無形-減価償却累計額(5年以内)
	 */
	public void setmgenkaSyokyakuRuikeiWithinFiveYear(String pimgenkaSyokyakuRuikeiWithinFiveYear) {
		this.mgenkaSyokyakuRuikeiWithinFiveYear = pimgenkaSyokyakuRuikeiWithinFiveYear;
	}

	/**
	 * 無形-減価償却費(5年以内)を取得.
	 * 
	 * @return 無形-減価償却費(5年以内)
	 */
	public long getmgenkaSyokyahiWithinFiveYear() {
		return mgenkaSyokyahiWithinFiveYear;
	}

	/**
	 * 無形-減価償却費(5年以内)を設定.
	 * 
	 * @param pimgenkaSyokyahiWithinFiveYear
	 *           無形-減価償却費(5年以内)
	 */
	public void setmgenkaSyokyahiWithinFiveYear(long pimgenkaSyokyahiWithinFiveYear) {
		this.mgenkaSyokyahiWithinFiveYear = pimgenkaSyokyahiWithinFiveYear;
	}

	/**
	 * 無形-簿価(5年以内)を取得.
	 * 
	 * @return 無形-簿価(5年以内)
	 */
	public long getmbokaWithinFiveYear() {
		return mbokaWithinFiveYear;
	}

	/**
	 * 無形-簿価(5年以内)を設定.
	 * 
	 * @param pimbokaWithinFiveYear
	 *           無形-簿価(5年以内)
	 */
	public void setmbokaWithinFiveYear(long pimbokaWithinFiveYear) {
		this.mbokaWithinFiveYear = pimbokaWithinFiveYear;
	}
	
	/**
	 * 無形-取得価額(5年超)を取得.
	 * 
	 * @return 無形-取得価額(5年超)
	 */
	public String getmsyutokukagakuOverFiveYear() {
		return msyutokukagakuOverFiveYear;
	}

	/**
	 * 無形-取得価額(5年超)を設定.
	 * 
	 * @param pimsyutokukagakuOverFiveYear
	 *           取得価(5年超)額
	 */
	public void setmsyutokukagakuOverFiveYear(String pimsyutokukagakuOverFiveYear) {
		this.msyutokukagakuOverFiveYear = pimsyutokukagakuOverFiveYear;
	}

	/**
	 * 無形-減価償却累計額(5年超)を取得.
	 * 
	 * @return 無形-減価償却累計額(5年超)
	 */
	public String getmgenkaSyokyakuRuikeiOverFiveYear() {
		return mgenkaSyokyakuRuikeiOverFiveYear;
	}

	/**
	 * 無形-減価償却累計額(5年超)を設定.
	 * 
	 * @param pimgenkaSyokyakuRuikeiOverFiveYear
	 *           無形-減価償却累計額(5年超)
	 */
	public void setmgenkaSyokyakuRuikeiOverFiveYear(String pimgenkaSyokyakuRuikeiOverFiveYear) {
		this.mgenkaSyokyakuRuikeiOverFiveYear = pimgenkaSyokyakuRuikeiOverFiveYear;
	}

	/**
	 * 無形-減価償却費(5年超)を取得.
	 * 
	 * @return 無形-減価償却費(5年超)
	 */
	public long getmgenkaSyokyahiOverFiveYear() {
		return mgenkaSyokyahiOverFiveYear;
	}

	/**
	 * 無形-減価償却費(5年超)を設定.
	 * 
	 * @param pimgenkaSyokyahiOverFiveYear
	 *           無形-減価償却費(5年超)
	 */
	public void setmgenkaSyokyahiOverFiveYear(long pimgenkaSyokyahiOverFiveYear) {
		this.mgenkaSyokyahiOverFiveYear = pimgenkaSyokyahiOverFiveYear;
	}

	/**
	 * 無形-簿価(5年超)を取得.
	 * 
	 * @return 無形-簿価(5年超)
	 */
	public long getmbokaOverFiveYear() {
		return mbokaOverFiveYear;
	}

	/**
	 * 無形-簿価(5年超)を設定.
	 * 
	 * @param pimbokaOverFiveYear
	 *           無形-簿価(5年超)
	 */
	public void setmbokaOverFiveYear(long pimbokaOverFiveYear) {
		this.mbokaOverFiveYear = pimbokaOverFiveYear;
	}
	
	/**
	 * 無形-取得価額(合計)を取得.
	 * 
	 * @return 無形-取得価額(合計)
	 */
	public long getmsyutokukagakuTotal() {
		return msyutokukagakuTotal;
	}

	/**
	 * 無形-取得価額(合計)を設定.
	 * 
	 * @param pimsyutokukagakuTotal
	 *           取得価(合計)額
	 */
	public void setmsyutokukagakuTotal(long pimsyutokukagakuTotal) {
		this.msyutokukagakuTotal = pimsyutokukagakuTotal;
	}

	/**
	 * 無形-減価償却累計額(合計)を取得.
	 * 
	 * @return 無形-減価償却累計額(合計)
	 */
	public long getmgenkaSyokyakuRuikeiTotal() {
		return mgenkaSyokyakuRuikeiTotal;
	}

	/**
	 * 無形-減価償却累計額(合計)を設定.
	 * 
	 * @param pimgenkaSyokyakuRuikeiTotal
	 *           無形-減価償却累計額(合計)
	 */
	public void setmgenkaSyokyakuRuikeiTotal(long pimgenkaSyokyakuRuikeiTotal) {
		this.mgenkaSyokyakuRuikeiTotal = pimgenkaSyokyakuRuikeiTotal;
	}

	/**
	 * 無形-減価償却費(合計)を取得.
	 * 
	 * @return 無形-減価償却費(合計)
	 */
	public String getmgenkaSyokyahi() {
		return mgenkaSyokyahiTotal;
	}

	/**
	 * 無形-減価償却費(合計)を設定.
	 * 
	 * @param pimgenkaSyokyahi
	 *           無形-減価償却費(合計)
	 */
	public void setmgenkaSyokyahi(String pimgenkaSyokyahi) {
		this.mgenkaSyokyahiTotal = pimgenkaSyokyahi;
	}

	/**
	 * 無形-簿価(合計)を取得.
	 * 
	 * @return 無形-簿価(合計)
	 */
	public long getmbokaTotal() {
		return mbokaTotal;
	}

	/**
	 * 無形-簿価(合計)を設定.
	 * 
	 * @param pimbokaTotal
	 *           無形-簿価(合計)
	 */
	public void setmbokaTotal(long pimbokaTotal) {
		this.mbokaTotal = pimbokaTotal;
	}


	
	/**
	 * 有形-取得価額(1年以内)を取得.
	 * 
	 * @return 有形-取得価額(1年以内)
	 */
	public String getusyutokukagakuWithinOneYear() {
		return usyutokukagakuWithinOneYear;
	}

	/**
	 * 有形-取得価額(1年以内)を設定.
	 * 
	 * @param piusyutokukagakuWithinOneYear
	 *           取得価(1年以内)額
	 */
	public void setusyutokukagakuWithinOneYear(String piusyutokukagakuWithinOneYear) {
		this.usyutokukagakuWithinOneYear = piusyutokukagakuWithinOneYear;
	}

	/**
	 * 有形-減価償却累計額(1年以内)を取得.
	 * 
	 * @return 有形-減価償却累計額(1年以内)
	 */
	public String getugenkaSyokyakuRuikeiWithinOneYear() {
		return ugenkaSyokyakuRuikeiWithinOneYear;
	}

	/**
	 * 有形-減価償却累計額(1年以内)を設定.
	 * 
	 * @param piugenkaSyokyakuRuikeiWithinOneYear
	 *           有形-減価償却累計額(1年以内)
	 */
	public void setugenkaSyokyakuRuikeiWithinOneYear(String piugenkaSyokyakuRuikeiWithinOneYear) {
		this.ugenkaSyokyakuRuikeiWithinOneYear = piugenkaSyokyakuRuikeiWithinOneYear;
	}

	/**
	 * 有形-減価償却費(1年以内)を取得.
	 * 
	 * @return 有形-減価償却費(1年以内)
	 */
	public long getugenkaSyokyahiWithinOneYear() {
		return ugenkaSyokyahiWithinOneYear;
	}

	/**
	 * 有形-減価償却費(1年以内)を設定.
	 * 
	 * @param piugenkaSyokyahiWithinOneYear
	 *           有形-減価償却費(1年以内)
	 */
	public void setugenkaSyokyahiWithinOneYear(long piugenkaSyokyahiWithinOneYear) {
		this.ugenkaSyokyahiWithinOneYear = piugenkaSyokyahiWithinOneYear;
	}

	/**
	 * 有形-簿価(1年以内)を取得.
	 * 
	 * @return 有形-簿価(1年以内)
	 */
	public long getubokaWithinOneYear() {
		return ubokaWithinOneYear;
	}

	/**
	 * 有形-簿価(1年以内)を設定.
	 * 
	 * @param piubokaWithinOneYear
	 *           有形-簿価(1年以内)
	 */
	public void setubokaWithinOneYear(long piubokaWithinOneYear) {
		this.ubokaWithinOneYear = piubokaWithinOneYear;
	}

	/**
	 * 有形-取得価額(2年以内)を取得.
	 * 
	 * @return 有形-取得価額(2年以内)
	 */
	public String getusyutokukagakuWithinTwoYear() {
		return usyutokukagakuWithinTwoYear;
	}

	/**
	 * 有形-取得価額(2年以内)を設定.
	 * 
	 * @param piusyutokukagakuWithinTwoYear
	 *           取得価(2年以内)額
	 */
	public void setusyutokukagakuWithinTwoYear(String piusyutokukagakuWithinTwoYear) {
		this.usyutokukagakuWithinTwoYear = piusyutokukagakuWithinTwoYear;
	}

	/**
	 * 有形-減価償却累計額(2年以内)を取得.
	 * 
	 * @return 有形-減価償却累計額(2年以内)
	 */
	public String getugenkaSyokyakuRuikeiWithinTwoYear() {
		return ugenkaSyokyakuRuikeiWithinTwoYear;
	}

	/**
	 * 有形-減価償却累計額(2年以内)を設定.
	 * 
	 * @param piugenkaSyokyakuRuikeiWithinTwoYear
	 *           有形-減価償却累計額(2年以内)
	 */
	public void setugenkaSyokyakuRuikeiWithinTwoYear(String piugenkaSyokyakuRuikeiWithinTwoYear) {
		this.ugenkaSyokyakuRuikeiWithinTwoYear = piugenkaSyokyakuRuikeiWithinTwoYear;
	}

	/**
	 * 有形-減価償却費(2年以内)を取得.
	 * 
	 * @return 有形-減価償却費(2年以内)
	 */
	public long getugenkaSyokyahiWithinTwoYear() {
		return ugenkaSyokyahiWithinTwoYear;
	}

	/**
	 * 有形-減価償却費(2年以内)を設定.
	 * 
	 * @param piugenkaSyokyahiWithinTwoYear
	 *           有形-減価償却費(2年以内)
	 */
	public void setugenkaSyokyahiWithinTwoYear(long piugenkaSyokyahiWithinTwoYear) {
		this.ugenkaSyokyahiWithinTwoYear = piugenkaSyokyahiWithinTwoYear;
	}

	/**
	 * 有形-簿価(2年以内)を取得.
	 * 
	 * @return 有形-簿価(2年以内)
	 */
	public long getubokaWithinTwoYear() {
		return ubokaWithinTwoYear;
	}

	/**
	 * 有形-簿価(2年以内)を設定.
	 * 
	 * @param piubokaWithinTwoYear
	 *           有形-簿価(2年以内)
	 */
	public void setubokaWithinTwoYear(long piubokaWithinTwoYear) {
		this.ubokaWithinTwoYear = piubokaWithinTwoYear;
	}

	/**
	 * 有形-取得価額(3年以内)を取得.
	 * 
	 * @return 有形-取得価額(3年以内)
	 */
	public String getusyutokukagakuWithinThreeYear() {
		return usyutokukagakuWithinThreeYear;
	}

	/**
	 * 有形-取得価額(3年以内)を設定.
	 * 
	 * @param piusyutokukagakuWithinThreeYear
	 *           取得価(3年以内)額
	 */
	public void setusyutokukagakuWithinThreeYear(String piusyutokukagakuWithinThreeYear) {
		this.usyutokukagakuWithinThreeYear = piusyutokukagakuWithinThreeYear;
	}

	/**
	 * 有形-減価償却累計額(3年以内)を取得.
	 * 
	 * @return 有形-減価償却累計額(3年以内)
	 */
	public String getugenkaSyokyakuRuikeiWithinThreeYear() {
		return ugenkaSyokyakuRuikeiWithinThreeYear;
	}

	/**
	 * 有形-減価償却累計額(3年以内)を設定.
	 * 
	 * @param piugenkaSyokyakuRuikeiWithinThreeYear
	 *           有形-減価償却累計額(3年以内)
	 */
	public void setugenkaSyokyakuRuikeiWithinThreeYear(String piugenkaSyokyakuRuikeiWithinThreeYear) {
		this.ugenkaSyokyakuRuikeiWithinThreeYear = piugenkaSyokyakuRuikeiWithinThreeYear;
	}

	/**
	 * 有形-減価償却費(3年以内)を取得.
	 * 
	 * @return 有形-減価償却費(3年以内)
	 */
	public long getugenkaSyokyahiWithinThreeYear() {
		return ugenkaSyokyahiWithinThreeYear;
	}

	/**
	 * 有形-減価償却費(3年以内)を設定.
	 * 
	 * @param piugenkaSyokyahiWithinThreeYear
	 *           有形-減価償却費(3年以内)
	 */
	public void setugenkaSyokyahiWithinThreeYear(long piugenkaSyokyahiWithinThreeYear) {
		this.ugenkaSyokyahiWithinThreeYear = piugenkaSyokyahiWithinThreeYear;
	}

	/**
	 * 有形-簿価(3年以内)を取得.
	 * 
	 * @return 有形-簿価(3年以内)
	 */
	public long getubokaWithinThreeYear() {
		return ubokaWithinThreeYear;
	}

	/**
	 * 有形-簿価(3年以内)を設定.
	 * 
	 * @param piubokaWithinThreeYear
	 *           有形-簿価(3年以内)
	 */
	public void setubokaWithinThreeYear(long piubokaWithinThreeYear) {
		this.ubokaWithinThreeYear = piubokaWithinThreeYear;
	}

	/**
	 * 有形-取得価額(4年以内)を取得.
	 * 
	 * @return 有形-取得価額(4年以内)
	 */
	public String getusyutokukagakuWithinFourYear() {
		return usyutokukagakuWithinFourYear;
	}

	/**
	 * 有形-取得価額(4年以内)を設定.
	 * 
	 * @param piusyutokukagakuWithinFourYear
	 *           取得価(4年以内)額
	 */
	public void setusyutokukagakuWithinFourYear(String piusyutokukagakuWithinFourYear) {
		this.usyutokukagakuWithinFourYear = piusyutokukagakuWithinFourYear;
	}

	/**
	 * 有形-減価償却累計額(4年以内)を取得.
	 * 
	 * @return 有形-減価償却累計額(4年以内)
	 */
	public String getugenkaSyokyakuRuikeiWithinFourYear() {
		return ugenkaSyokyakuRuikeiWithinFourYear;
	}

	/**
	 * 有形-減価償却累計額(4年以内)を設定.
	 * 
	 * @param piugenkaSyokyakuRuikeiWithinFourYear
	 *           有形-減価償却累計額(4年以内)
	 */
	public void setugenkaSyokyakuRuikeiWithinFourYear(String piugenkaSyokyakuRuikeiWithinFourYear) {
		this.ugenkaSyokyakuRuikeiWithinFourYear = piugenkaSyokyakuRuikeiWithinFourYear;
	}

	/**
	 * 有形-減価償却費(4年以内)を取得.
	 * 
	 * @return 有形-減価償却費(4年以内)
	 */
	public long getugenkaSyokyahiWithinFourYear() {
		return ugenkaSyokyahiWithinFourYear;
	}

	/**
	 * 有形-減価償却費(4年以内)を設定.
	 * 
	 * @param piugenkaSyokyahiWithinFourYear
	 *           有形-減価償却費(4年以内)
	 */
	public void setugenkaSyokyahiWithinFourYear(long piugenkaSyokyahiWithinFourYear) {
		this.ugenkaSyokyahiWithinFourYear = piugenkaSyokyahiWithinFourYear;
	}

	/**
	 * 有形-簿価(4年以内)を取得.
	 * 
	 * @return 有形-簿価(4年以内)
	 */
	public long getubokaWithinFourYear() {
		return ubokaWithinFourYear;
	}

	/**
	 * 有形-簿価(4年以内)を設定.
	 * 
	 * @param piubokaWithinFourYear
	 *           有形-簿価(4年以内)
	 */
	public void setubokaWithinFourYear(long piubokaWithinFourYear) {
		this.ubokaWithinFourYear = piubokaWithinFourYear;
	}
	
	/**
	 * 有形-取得価額(5年以内)を取得.
	 * 
	 * @return 有形-取得価額(5年以内)
	 */
	public String getusyutokukagakuWithinFiveYear() {
		return usyutokukagakuWithinFiveYear;
	}

	/**
	 * 有形-取得価額(5年以内)を設定.
	 * 
	 * @param piusyutokukagakuWithinFiveYear
	 *           取得価(5年以内)額
	 */
	public void setusyutokukagakuWithinFiveYear(String piusyutokukagakuWithinFiveYear) {
		this.usyutokukagakuWithinFiveYear = piusyutokukagakuWithinFiveYear;
	}

	/**
	 * 有形-減価償却累計額(5年以内)を取得.
	 * 
	 * @return 有形-減価償却累計額(5年以内)
	 */
	public String getugenkaSyokyakuRuikeiWithinFiveYear() {
		return ugenkaSyokyakuRuikeiWithinFiveYear;
	}

	/**
	 * 有形-減価償却累計額(5年以内)を設定.
	 * 
	 * @param piugenkaSyokyakuRuikeiWithinFiveYear
	 *           有形-減価償却累計額(5年以内)
	 */
	public void setugenkaSyokyakuRuikeiWithinFiveYear(String piugenkaSyokyakuRuikeiWithinFiveYear) {
		this.ugenkaSyokyakuRuikeiWithinFiveYear = piugenkaSyokyakuRuikeiWithinFiveYear;
	}

	/**
	 * 有形-減価償却費(5年以内)を取得.
	 * 
	 * @return 有形-減価償却費(5年以内)
	 */
	public long getugenkaSyokyahiWithinFiveYear() {
		return ugenkaSyokyahiWithinFiveYear;
	}

	/**
	 * 有形-減価償却費(5年以内)を設定.
	 * 
	 * @param piugenkaSyokyahiWithinFiveYear
	 *           有形-減価償却費(5年以内)
	 */
	public void setugenkaSyokyahiWithinFiveYear(long piugenkaSyokyahiWithinFiveYear) {
		this.ugenkaSyokyahiWithinFiveYear = piugenkaSyokyahiWithinFiveYear;
	}

	/**
	 * 有形-簿価(5年以内)を取得.
	 * 
	 * @return 有形-簿価(5年以内)
	 */
	public long getubokaWithinFiveYear() {
		return ubokaWithinFiveYear;
	}

	/**
	 * 有形-簿価(5年以内)を設定.
	 * 
	 * @param piubokaWithinFiveYear
	 *           有形-簿価(5年以内)
	 */
	public void setubokaWithinFiveYear(long piubokaWithinFiveYear) {
		this.ubokaWithinFiveYear = piubokaWithinFiveYear;
	}
	
	/**
	 * 有形-取得価額(5年超)を取得.
	 * 
	 * @return 有形-取得価額(5年超)
	 */
	public String getusyutokukagakuOverFiveYear() {
		return usyutokukagakuOverFiveYear;
	}

	/**
	 * 有形-取得価額(5年超)を設定.
	 * 
	 * @param piusyutokukagakuOverFiveYear
	 *           取得価(5年超)額
	 */
	public void setusyutokukagakuOverFiveYear(String piusyutokukagakuOverFiveYear) {
		this.usyutokukagakuOverFiveYear = piusyutokukagakuOverFiveYear;
	}

	/**
	 * 有形-減価償却累計額(5年超)を取得.
	 * 
	 * @return 有形-減価償却累計額(5年超)
	 */
	public String getugenkaSyokyakuRuikeiOverFiveYear() {
		return ugenkaSyokyakuRuikeiOverFiveYear;
	}

	/**
	 * 有形-減価償却累計額(5年超)を設定.
	 * 
	 * @param piugenkaSyokyakuRuikeiOverFiveYear
	 *           有形-減価償却累計額(5年超)
	 */
	public void setugenkaSyokyakuRuikeiOverFiveYear(String piugenkaSyokyakuRuikeiOverFiveYear) {
		this.ugenkaSyokyakuRuikeiOverFiveYear = piugenkaSyokyakuRuikeiOverFiveYear;
	}

	/**
	 * 有形-減価償却費(5年超)を取得.
	 * 
	 * @return 有形-減価償却費(5年超)
	 */
	public long getugenkaSyokyahiOverFiveYear() {
		return ugenkaSyokyahiOverFiveYear;
	}

	/**
	 * 有形-減価償却費(5年超)を設定.
	 * 
	 * @param piugenkaSyokyahiOverFiveYear
	 *           有形-減価償却費(5年超)
	 */
	public void setugenkaSyokyahiOverFiveYear(long piugenkaSyokyahiOverFiveYear) {
		this.ugenkaSyokyahiOverFiveYear = piugenkaSyokyahiOverFiveYear;
	}

	/**
	 * 有形-簿価(5年超)を取得.
	 * 
	 * @return 有形-簿価(5年超)
	 */
	public long getubokaOverFiveYear() {
		return ubokaOverFiveYear;
	}

	/**
	 * 有形-簿価(5年超)を設定.
	 * 
	 * @param piubokaOverFiveYear
	 *           有形-簿価(5年超)
	 */
	public void setubokaOverFiveYear(long piubokaOverFiveYear) {
		this.ubokaOverFiveYear = piubokaOverFiveYear;
	}
	
	/**
	 * 有形-取得価額(合計)を取得.
	 * 
	 * @return 有形-取得価額(合計)
	 */
	public long getusyutokukagakuTotal() {
		return usyutokukagakuTotal;
	}

	/**
	 * 有形-取得価額(合計)を設定.
	 * 
	 * @param piusyutokukagakuTotal
	 *           取得価(合計)額
	 */
	public void setusyutokukagakuTotal(long piusyutokukagakuTotal) {
		this.usyutokukagakuTotal = piusyutokukagakuTotal;
	}

	/**
	 * 有形-減価償却累計額(合計)を取得.
	 * 
	 * @return 有形-減価償却累計額(合計)
	 */
	public long getugenkaSyokyakuRuikeiTotal() {
		return ugenkaSyokyakuRuikeiTotal;
	}

	/**
	 * 有形-減価償却累計額(合計)を設定.
	 * 
	 * @param piugenkaSyokyakuRuikeiTotal
	 *           有形-減価償却累計額(合計)
	 */
	public void setugenkaSyokyakuRuikeiTotal(long piugenkaSyokyakuRuikeiTotal) {
		this.ugenkaSyokyakuRuikeiTotal = piugenkaSyokyakuRuikeiTotal;
	}

	/**
	 * 有形-減価償却費(合計)を取得.
	 * 
	 * @return 有形-減価償却費(合計)
	 */
	public String getugenkaSyokyahi() {
		return ugenkaSyokyahiTotal;
	}

	/**
	 * 有形-減価償却費(合計)を設定.
	 * 
	 * @param piugenkaSyokyahi
	 *           有形-減価償却費(合計)
	 */
	public void setugenkaSyokyahi(String piugenkaSyokyahi) {
		this.ugenkaSyokyahiTotal = piugenkaSyokyahi;
	}

	/**
	 * 有形-簿価(合計)を取得.
	 * 
	 * @return 有形-簿価(合計)
	 */
	public long getubokaTotal() {
		return ubokaTotal;
	}

	/**
	 * 有形-簿価(合計)を設定.
	 * 
	 * @param piubokaTotal
	 *           有形-簿価(合計)
	 */
	public void setubokaTotal(long piubokaTotal) {
		this.ubokaTotal = piubokaTotal;
	}
	
	
	
	
	

}
