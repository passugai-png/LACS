package jp.co.pro_app.lacs.affairs.report.bean;

/**
 * 帳票出力：期日別予定表（債務）Bean.
 * 
 * @author arai
 * @version 20200615
 */


public class LACSReportKizituSisanBean  {

	private String leaseCompany                        = "";   // リース会社
	 
	private String kaizisaki                           = "";   // 開示先
	
	private String Kijyun                           = "";   // 基準日
	
	private String jysiUm                              = "";   // 重要性有無
	
	private String leaseBunrui                         = "";   // リース取引分類

	private String koteiSisanKamoku                    = "";   // 固定資産科目
	
	private String kaikeiSyoriHouhou                   = "";   // 会計処理方法
	
	private String sisanKbn                            = "";   // 資産区分
	  
	private String genkaSyokyakuHouhou                 = "";   // 減価償却方法
	
	private String keiyakuNo                           = "";   // 契約番号
	
	private String bukenNo	                           = "";   // 物件番号
	
	private String bukenName                          = "";   // 物件名
	
	private String leaseFrom                           = "";   // リース開始日
	
	private String leaseTo                             = "";   // リース終了日	
	
	private String kaiyakuYmd                            = "";   // 中途解約日
	
    private String syutokukagakuWithinOneYear          = "";   // 取得価額(1年以内)
	
	private String genkaSyokyakuRuikeiWithinOneYear    = "";   // 減価償却累計額(1年以内)
	
	private long genkaSyokyahiWithinOneYear          = 0;   // 減価償却費(1年以内)
	
	private long bokaWithinOneYear                   = 0;   // 簿価(1年以内)
		
	private String syutokukagakuWithinTwoYear          = "";   // 取得価額(2年以内)
	
	private String genkaSyokyakuRuikeiWithinTwoYear    = "";   // 減価償却累計額(2年以内)
	
	private long genkaSyokyahiWithinTwoYear          = 0;   // 減価償却費(2年以内)
	
	private long bokaWithinTwoYear                   = 0;   // 簿価(2年以内)
	
    private String syutokukagakuWithinThreeYear        = "";   // 取得価額(3年以内)
	
	private String genkaSyokyakuRuikeiWithinThreeYear  = "";   // 減価償却累計額(3年以内)
	
	private long genkaSyokyahiWithinThreeYear        = 0;   // 減価償却費(3年以内)
	
	private long bokaWithinThreeYear                 = 0;   // 簿価(3年以内)
	
    private String syutokukagakuWithinFourYear        = "";    // 取得価額(4年以内)
	
	private String genkaSyokyakuRuikeiWithinFourYear  = "";    // 減価償却累計額(4年以内)
	
	private long genkaSyokyahiWithinFourYear        = 0;    // 減価償却費(4年以内)
	
	private long bokaWithinFourYear                 = 0;    // 簿価(4年以内)
	
    private String syutokukagakuWithinFiveYear        = "";    // 取得価額(5年以内)
	 
	private String genkaSyokyakuRuikeiWithinFiveYear  = "";    // 減価償却累計額(5年以内)
	
	private long genkaSyokyahiWithinFiveYear        = 0;    // 減価償却費(5年以内)
	
	private long bokaWithinFiveYear                 = 0;    // 簿価(5年以内)
	
    private String syutokukagakuOverFiveYear          = "";    // 取得価額(5年超)
	
	private String genkaSyokyakuRuikeiOverFiveYear    = "";    // 減価償却累計額(5年超)
	
	private long genkaSyokyahiOverFiveYear          = 0;    // 減価償却費(5年超)
	
	private long bokaOverFiveYear                   = 0;    // 簿価(5年超)
	
    private long syutokukagakuTotal                 = 0;    // 取得価額(合計)
	
	private long genkaSyokyakuRuikeiTotal           = 0;    // 減価償却累計額(合計)
	
	private String genkaSyokyahiTotal                 = "";    // 減価償却費(合計)
	
	private long bokaTotal                          = 0;    // 簿価(合計)
	
	private String breakKey0                    = "";     // ブレイクキー0
	
	private String breakKey1                    = "";     // ブレイクキー1

	private String breakKey2                    = "";     // ブレイクキー2
	
	private String breakKey3                    = "";     // ブレイクキー3
	
	private String breakKey4                    = "";     // ブレイクキー4
	
	private String breakKey5                    = "";     // ブレイクキー5
	
	private String breakKey6                    = "";     // ブレイクキー6
	
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
	 * ブレイクキー6を取得.
	 * 
	 * @return ブレイクキー6
	 */
	public String getBrakeKey6() {
		return this.breakKey6;
	}

	/**
	 * ブレイクキー6を設定.
	 * 
	 * @param piBrakeKey6
	 *           ブレイクキー6
	 */
	public void setBrakeKey6(String piBrakeKey6) {
		this.breakKey6 = piBrakeKey6;
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
	 * 基準日を取得.
	 * 
	 * @return 開示先
	 */
	public String getKijyun() {
		return this.Kijyun;
	}

	/**
	 * 基準日を設定.
	 * 
	 * @param piKijyun
	 *           開示先
	 */
	public void setKijyun(String piKijyun) {
		this.Kijyun = piKijyun;
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
	 * 固定資産科目を取得.
	 * 
	 * @return 固定資産科目
	 */
	public String getKoteiSisanKamoku() {
		return this.koteiSisanKamoku;
	}

	/**
	 * 固定資産科目を設定.
	 * 
	 * @param piKoteiSisanKamoku
	 *           固定資産科目
	 */
	public void setKoteiSisanKamoku(String piKoteiSisanKamoku) {
		this.koteiSisanKamoku = piKoteiSisanKamoku;
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
	 * 資産区分を取得.
	 * 
	 * @return 資産区分
	 */
	public String getSisanKbn() {
		return this.sisanKbn;
	}

	/**
	 * 資産区分を設定.
	 * 
	 * @param pisisanKbn
	 *           資産区分
	 */
	public void setSisanKbn(String pisisanKbn) {
		this.sisanKbn = pisisanKbn;
	}
	
	/**
	 * 減価償却方法を取得.
	 * 
	 * @return 減価償却方法
	 */
	public String getGenkaSyokyakuHouhou() {
		return this.genkaSyokyakuHouhou;
	}

	/**
	 * 減価償却方法を設定.
	 * 
	 * @param piGenkaSyokyakuHouhou
	 *           減価償却方法
	 */
	public void setGenkaSyokyakuHouhou(String piGenkaSyokyakuHouhou) {
		this.genkaSyokyakuHouhou = piGenkaSyokyakuHouhou;
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
	public String getkaiyakuYmd() {
		return this.kaiyakuYmd;
	}

	/**
	 * 中途解約日を設定.
	 * 
	 * @param pityutoMD
	 *           中途解約日
	 */
	public void setkaiyakuYmd(String pikaiyakuYmd) {
		this.kaiyakuYmd = pikaiyakuYmd;
	}

	/**
	 * 取得価額(1年以内)を取得.
	 * 
	 * @return 取得価額(1年以内)
	 */
	public String getSyutokukagakuWithinOneYear() {
		return syutokukagakuWithinOneYear;
	}

	/**
	 * 取得価額(1年以内)を設定.
	 * 
	 * @param pisyutokukagakuWithinOneYear
	 *           取得価(1年以内)額
	 */
	public void setSyutokukagakuWithinOneYear(String pisyutokukagakuWithinOneYear) {
		this.syutokukagakuWithinOneYear = pisyutokukagakuWithinOneYear;
	}

	/**
	 * 減価償却累計額(1年以内)を取得.
	 * 
	 * @return 減価償却累計額(1年以内)
	 */
	public String getGenkaSyokyakuRuikeiWithinOneYear() {
		return genkaSyokyakuRuikeiWithinOneYear;
	}

	/**
	 * 減価償却累計額(1年以内)を設定.
	 * 
	 * @param pigenkaSyokyakuRuikeiWithinOneYear
	 *           減価償却累計額(1年以内)
	 */
	public void setGenkaSyokyakuRuikeiWithinOneYear(String pigenkaSyokyakuRuikeiWithinOneYear) {
		this.genkaSyokyakuRuikeiWithinOneYear = pigenkaSyokyakuRuikeiWithinOneYear;
	}

	/**
	 * 減価償却費(1年以内)を取得.
	 * 
	 * @return 減価償却費(1年以内)
	 */
	public long getGenkaSyokyahiWithinOneYear() {
		return genkaSyokyahiWithinOneYear;
	}

	/**
	 * 減価償却費(1年以内)を設定.
	 * 
	 * @param pigenkaSyokyahiWithinOneYear
	 *           減価償却費(1年以内)
	 */
	public void setGenkaSyokyahiWithinOneYear(long pigenkaSyokyahiWithinOneYear) {
		this.genkaSyokyahiWithinOneYear = pigenkaSyokyahiWithinOneYear;
	}

	/**
	 * 簿価(1年以内)を取得.
	 * 
	 * @return 簿価(1年以内)
	 */
	public long getBokaWithinOneYear() {
		return bokaWithinOneYear;
	}

	/**
	 * 簿価(1年以内)を設定.
	 * 
	 * @param pibokaWithinOneYear
	 *           簿価(1年以内)
	 */
	public void setBokaWithinOneYear(long pibokaWithinOneYear) {
		this.bokaWithinOneYear = pibokaWithinOneYear;
	}

	/**
	 * 取得価額(2年以内)を取得.
	 * 
	 * @return 取得価額(2年以内)
	 */
	public String getSyutokukagakuWithinTwoYear() {
		return syutokukagakuWithinTwoYear;
	}

	/**
	 * 取得価額(2年以内)を設定.
	 * 
	 * @param pisyutokukagakuWithinTwoYear
	 *           取得価(2年以内)額
	 */
	public void setSyutokukagakuWithinTwoYear(String pisyutokukagakuWithinTwoYear) {
		this.syutokukagakuWithinTwoYear = pisyutokukagakuWithinTwoYear;
	}

	/**
	 * 減価償却累計額(2年以内)を取得.
	 * 
	 * @return 減価償却累計額(2年以内)
	 */
	public String getGenkaSyokyakuRuikeiWithinTwoYear() {
		return genkaSyokyakuRuikeiWithinTwoYear;
	}

	/**
	 * 減価償却累計額(2年以内)を設定.
	 * 
	 * @param pigenkaSyokyakuRuikeiWithinTwoYear
	 *           減価償却累計額(2年以内)
	 */
	public void setGenkaSyokyakuRuikeiWithinTwoYear(String pigenkaSyokyakuRuikeiWithinTwoYear) {
		this.genkaSyokyakuRuikeiWithinTwoYear = pigenkaSyokyakuRuikeiWithinTwoYear;
	}

	/**
	 * 減価償却費(2年以内)を取得.
	 * 
	 * @return 減価償却費(2年以内)
	 */
	public long getGenkaSyokyahiWithinTwoYear() {
		return genkaSyokyahiWithinTwoYear;
	}

	/**
	 * 減価償却費(2年以内)を設定.
	 * 
	 * @param pigenkaSyokyahiWithinTwoYear
	 *           減価償却費(2年以内)
	 */
	public void setGenkaSyokyahiWithinTwoYear(long pigenkaSyokyahiWithinTwoYear) {
		this.genkaSyokyahiWithinTwoYear = pigenkaSyokyahiWithinTwoYear;
	}

	/**
	 * 簿価(2年以内)を取得.
	 * 
	 * @return 簿価(2年以内)
	 */
	public long getBokaWithinTwoYear() {
		return bokaWithinTwoYear;
	}

	/**
	 * 簿価(2年以内)を設定.
	 * 
	 * @param pibokaWithinTwoYear
	 *           簿価(2年以内)
	 */
	public void setBokaWithinTwoYear(long pibokaWithinTwoYear) {
		this.bokaWithinTwoYear = pibokaWithinTwoYear;
	}

	/**
	 * 取得価額(3年以内)を取得.
	 * 
	 * @return 取得価額(3年以内)
	 */
	public String getSyutokukagakuWithinThreeYear() {
		return syutokukagakuWithinThreeYear;
	}

	/**
	 * 取得価額(3年以内)を設定.
	 * 
	 * @param pisyutokukagakuWithinThreeYear
	 *           取得価(3年以内)額
	 */
	public void setSyutokukagakuWithinThreeYear(String pisyutokukagakuWithinThreeYear) {
		this.syutokukagakuWithinThreeYear = pisyutokukagakuWithinThreeYear;
	}

	/**
	 * 減価償却累計額(3年以内)を取得.
	 * 
	 * @return 減価償却累計額(3年以内)
	 */
	public String getGenkaSyokyakuRuikeiWithinThreeYear() {
		return genkaSyokyakuRuikeiWithinThreeYear;
	}

	/**
	 * 減価償却累計額(3年以内)を設定.
	 * 
	 * @param pigenkaSyokyakuRuikeiWithinThreeYear
	 *           減価償却累計額(3年以内)
	 */
	public void setGenkaSyokyakuRuikeiWithinThreeYear(String pigenkaSyokyakuRuikeiWithinThreeYear) {
		this.genkaSyokyakuRuikeiWithinThreeYear = pigenkaSyokyakuRuikeiWithinThreeYear;
	}

	/**
	 * 減価償却費(3年以内)を取得.
	 * 
	 * @return 減価償却費(3年以内)
	 */
	public long getGenkaSyokyahiWithinThreeYear() {
		return genkaSyokyahiWithinThreeYear;
	}

	/**
	 * 減価償却費(3年以内)を設定.
	 * 
	 * @param pigenkaSyokyahiWithinThreeYear
	 *           減価償却費(3年以内)
	 */
	public void setGenkaSyokyahiWithinThreeYear(long pigenkaSyokyahiWithinThreeYear) {
		this.genkaSyokyahiWithinThreeYear = pigenkaSyokyahiWithinThreeYear;
	}

	/**
	 * 簿価(3年以内)を取得.
	 * 
	 * @return 簿価(3年以内)
	 */
	public long getBokaWithinThreeYear() {
		return bokaWithinThreeYear;
	}

	/**
	 * 簿価(3年以内)を設定.
	 * 
	 * @param pibokaWithinThreeYear
	 *           簿価(3年以内)
	 */
	public void setBokaWithinThreeYear(long pibokaWithinThreeYear) {
		this.bokaWithinThreeYear = pibokaWithinThreeYear;
	}

	/**
	 * 取得価額(4年以内)を取得.
	 * 
	 * @return 取得価額(4年以内)
	 */
	public String getSyutokukagakuWithinFourYear() {
		return syutokukagakuWithinFourYear;
	}

	/**
	 * 取得価額(4年以内)を設定.
	 * 
	 * @param pisyutokukagakuWithinFourYear
	 *           取得価(4年以内)額
	 */
	public void setSyutokukagakuWithinFourYear(String pisyutokukagakuWithinFourYear) {
		this.syutokukagakuWithinFourYear = pisyutokukagakuWithinFourYear;
	}

	/**
	 * 減価償却累計額(4年以内)を取得.
	 * 
	 * @return 減価償却累計額(4年以内)
	 */
	public String getGenkaSyokyakuRuikeiWithinFourYear() {
		return genkaSyokyakuRuikeiWithinFourYear;
	}

	/**
	 * 減価償却累計額(4年以内)を設定.
	 * 
	 * @param pigenkaSyokyakuRuikeiWithinFourYear
	 *           減価償却累計額(4年以内)
	 */
	public void setGenkaSyokyakuRuikeiWithinFourYear(String pigenkaSyokyakuRuikeiWithinFourYear) {
		this.genkaSyokyakuRuikeiWithinFourYear = pigenkaSyokyakuRuikeiWithinFourYear;
	}

	/**
	 * 減価償却費(4年以内)を取得.
	 * 
	 * @return 減価償却費(4年以内)
	 */
	public long getGenkaSyokyahiWithinFourYear() {
		return genkaSyokyahiWithinFourYear;
	}

	/**
	 * 減価償却費(4年以内)を設定.
	 * 
	 * @param pigenkaSyokyahiWithinFourYear
	 *           減価償却費(4年以内)
	 */
	public void setGenkaSyokyahiWithinFourYear(long pigenkaSyokyahiWithinFourYear) {
		this.genkaSyokyahiWithinFourYear = pigenkaSyokyahiWithinFourYear;
	}

	/**
	 * 簿価(4年以内)を取得.
	 * 
	 * @return 簿価(4年以内)
	 */
	public long getBokaWithinFourYear() {
		return bokaWithinFourYear;
	}

	/**
	 * 簿価(4年以内)を設定.
	 * 
	 * @param pibokaWithinFourYear
	 *           簿価(4年以内)
	 */
	public void setBokaWithinFourYear(long pibokaWithinFourYear) {
		this.bokaWithinFourYear = pibokaWithinFourYear;
	}
	
	/**
	 * 取得価額(5年以内)を取得.
	 * 
	 * @return 取得価額(5年以内)
	 */
	public String getSyutokukagakuWithinFiveYear() {
		return syutokukagakuWithinFiveYear;
	}

	/**
	 * 取得価額(5年以内)を設定.
	 * 
	 * @param pisyutokukagakuWithinFiveYear
	 *           取得価(5年以内)額
	 */
	public void setSyutokukagakuWithinFiveYear(String pisyutokukagakuWithinFiveYear) {
		this.syutokukagakuWithinFiveYear = pisyutokukagakuWithinFiveYear;
	}

	/**
	 * 減価償却累計額(5年以内)を取得.
	 * 
	 * @return 減価償却累計額(5年以内)
	 */
	public String getGenkaSyokyakuRuikeiWithinFiveYear() {
		return genkaSyokyakuRuikeiWithinFiveYear;
	}

	/**
	 * 減価償却累計額(5年以内)を設定.
	 * 
	 * @param pigenkaSyokyakuRuikeiWithinFiveYear
	 *           減価償却累計額(5年以内)
	 */
	public void setGenkaSyokyakuRuikeiWithinFiveYear(String pigenkaSyokyakuRuikeiWithinFiveYear) {
		this.genkaSyokyakuRuikeiWithinFiveYear = pigenkaSyokyakuRuikeiWithinFiveYear;
	}

	/**
	 * 減価償却費(5年以内)を取得.
	 * 
	 * @return 減価償却費(5年以内)
	 */
	public long getGenkaSyokyahiWithinFiveYear() {
		return genkaSyokyahiWithinFiveYear;
	}

	/**
	 * 減価償却費(5年以内)を設定.
	 * 
	 * @param pigenkaSyokyahiWithinFiveYear
	 *           減価償却費(5年以内)
	 */
	public void setGenkaSyokyahiWithinFiveYear(long pigenkaSyokyahiWithinFiveYear) {
		this.genkaSyokyahiWithinFiveYear = pigenkaSyokyahiWithinFiveYear;
	}

	/**
	 * 簿価(5年以内)を取得.
	 * 
	 * @return 簿価(5年以内)
	 */
	public long getBokaWithinFiveYear() {
		return bokaWithinFiveYear;
	}

	/**
	 * 簿価(5年以内)を設定.
	 * 
	 * @param pibokaWithinFiveYear
	 *           簿価(5年以内)
	 */
	public void setBokaWithinFiveYear(long pibokaWithinFiveYear) {
		this.bokaWithinFiveYear = pibokaWithinFiveYear;
	}
	
	/**
	 * 取得価額(5年超)を取得.
	 * 
	 * @return 取得価額(5年超)
	 */
	public String getSyutokukagakuOverFiveYear() {
		return syutokukagakuOverFiveYear;
	}

	/**
	 * 取得価額(5年超)を設定.
	 * 
	 * @param pisyutokukagakuOverFiveYear
	 *           取得価(5年超)額
	 */
	public void setSyutokukagakuOverFiveYear(String pisyutokukagakuOverFiveYear) {
		this.syutokukagakuOverFiveYear = pisyutokukagakuOverFiveYear;
	}

	/**
	 * 減価償却累計額(5年超)を取得.
	 * 
	 * @return 減価償却累計額(5年超)
	 */
	public String getGenkaSyokyakuRuikeiOverFiveYear() {
		return genkaSyokyakuRuikeiOverFiveYear;
	}

	/**
	 * 減価償却累計額(5年超)を設定.
	 * 
	 * @param pigenkaSyokyakuRuikeiOverFiveYear
	 *           減価償却累計額(5年超)
	 */
	public void setGenkaSyokyakuRuikeiOverFiveYear(String pigenkaSyokyakuRuikeiOverFiveYear) {
		this.genkaSyokyakuRuikeiOverFiveYear = pigenkaSyokyakuRuikeiOverFiveYear;
	}

	/**
	 * 減価償却費(5年超)を取得.
	 * 
	 * @return 減価償却費(5年超)
	 */
	public long getGenkaSyokyahiOverFiveYear() {
		return genkaSyokyahiOverFiveYear;
	}

	/**
	 * 減価償却費(5年超)を設定.
	 * 
	 * @param pigenkaSyokyahiOverFiveYear
	 *           減価償却費(5年超)
	 */
	public void setGenkaSyokyahiOverFiveYear(long pigenkaSyokyahiOverFiveYear) {
		this.genkaSyokyahiOverFiveYear = pigenkaSyokyahiOverFiveYear;
	}

	/**
	 * 簿価(5年超)を取得.
	 * 
	 * @return 簿価(5年超)
	 */
	public long getBokaOverFiveYear() {
		return bokaOverFiveYear;
	}

	/**
	 * 簿価(5年超)を設定.
	 * 
	 * @param pibokaOverFiveYear
	 *           簿価(5年超)
	 */
	public void setBokaOverFiveYear(long pibokaOverFiveYear) {
		this.bokaOverFiveYear = pibokaOverFiveYear;
	}
	
	/**
	 * 取得価額(合計)を取得.
	 * 
	 * @return 取得価額(合計)
	 */
	public long getSyutokukagakuTotal() {
		return syutokukagakuTotal;
	}

	/**
	 * 取得価額(合計)を設定.
	 * 
	 * @param pisyutokukagakuTotal
	 *           取得価(合計)額
	 */
	public void setSyutokukagakuTotal(long pisyutokukagakuTotal) {
		this.syutokukagakuTotal = pisyutokukagakuTotal;
	}

	/**
	 * 減価償却累計額(合計)を取得.
	 * 
	 * @return 減価償却累計額(合計)
	 */
	public long getGenkaSyokyakuRuikeiTotal() {
		return genkaSyokyakuRuikeiTotal;
	}

	/**
	 * 減価償却累計額(合計)を設定.
	 * 
	 * @param pigenkaSyokyakuRuikeiTotal
	 *           減価償却累計額(合計)
	 */
	public void setGenkaSyokyakuRuikeiTotal(long pigenkaSyokyakuRuikeiTotal) {
		this.genkaSyokyakuRuikeiTotal = pigenkaSyokyakuRuikeiTotal;
	}

	/**
	 * 減価償却費(合計)を取得.
	 * 
	 * @return 減価償却費(合計)
	 */
	public String getGenkaSyokyahiTotal() {
		return genkaSyokyahiTotal;
	}

	/**
	 * 減価償却費(合計)を設定.
	 * 
	 * @param pigenkaSyokyahiTotal
	 *           減価償却費(合計)
	 */
	public void setGenkaSyokyahiTotal(String pigenkaSyokyahiTotal) {
		this.genkaSyokyahiTotal = pigenkaSyokyahiTotal;
	}

	/**
	 * 簿価(合計)を取得.
	 * 
	 * @return 簿価(合計)
	 */
	public long getBokaTotal() {
		return bokaTotal;
	}

	/**
	 * 簿価(合計)を設定.
	 * 
	 * @param pibokaTotal
	 *           簿価(合計)
	 */
	public void setBokaTotal(long pibokaTotal) {
		this.bokaTotal = pibokaTotal;
	}

}
