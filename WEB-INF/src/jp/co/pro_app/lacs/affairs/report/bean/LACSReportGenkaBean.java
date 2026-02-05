package jp.co.pro_app.lacs.affairs.report.bean;

/**
 * 帳票出力：リース会計資料（減価償却費）Bean.
 * 
 * @author ohmura
 * @version 20070829
 */
public class LACSReportGenkaBean {

	private String	brakeKey0				= "";	// ブレイクキー０

	private String	brakeKey1				= "";	// ブレイクキー１

	private String	brakeKey2				= "";	// ブレイクキー２

	private String	brakeKey3				= "";	// ブレイクキー３

	private String	brakeKey4				= "";	// ブレイクキー３

	// 2020/05/22 ADD START
	private String	brakeKey0_1				= "";	// ブレイクキー0_1 重要性有無
	// 2020/05/22 ADD START

	private String	leaseCompany			= "";	// リース会社

	// 2020/05/22 ADD START
	private String	jysiUm				= "";		// 重要性有無
	// 2020/05/22 ADD START

	private String	leaseBunrui				= "";	// リース取引分類

	private String	koteiSisanKamoku		= "";	// 固定資産科目

	private String	genkaSyoukyakuHohou		= "";	// 減価償却方法

	private String	keiyakuNo				= "";	// 契約番号

	private String	leaseFrom				= "";	// リース開始日

	private String	leaseTo					= "";	// リース終了日

	private String	bukenNo					= "";	// 物件番号

	private String	bukenNm					= "";	// 物件名

	private String	kaiyakuYmd				= "";	// 中途解約日

	private String	leaseTerm				= "";	// リース期間

	private String	taiyouNensu				= "";	// 耐用年数

	private long	syutokuKakaku			= 0;	// 取得価額相当額

	private long	zanHosyou				= 0;	// 残価保証額

	private long	toukiGenkasyokyaku		= 0;	// 当期減価償却費

	private long	genkasyoukyakuRuikei	= 0;	// 減価償却累計額

	private long	kimatuZan				= 0;	// 期末残高相当額

	private String	leasCompanyNm			= "";	// リース会社名

	private String	leasUserNm				= "";	// リースユーザ名

	private String	acShrKbnName			= "";	// 会計処理方法

	private String	waribikiKeisanRisiRitu	= "";	// 割引計算利子率

	/**
	 * リース会社名を取得.
	 * 
	 * @return リース会社名
	 */
	public String getLeasCompanyNm() {
		return this.leasCompanyNm;
	}

	/**
	 * リース会社名を設定.
	 * 
	 * @param piLeasCompanyNm
	 *            リース会社名
	 */
	public void setLeasCompanyNm(String piLeasCompanyNm) {
		this.leasCompanyNm = piLeasCompanyNm;
	}

	/**
	 * リースユーザ名を取得.
	 * 
	 * @return リース会社名
	 */
	public String getLeasUserNm() {
		return this.leasUserNm;
	}

	/**
	 * リースユーザを設定.
	 * 
	 * @param piLeasUserNm
	 *            リース会社名
	 */
	public void setLeasUserNm(String piLeasUserNm) {
		this.leasUserNm = piLeasUserNm;
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
	 * ブレイクキー０を設定.
	 * 
	 * @param piBrakeKey0
	 *            ブレイクキー０
	 */
	public void setBrakeKey0(String piBrakeKey0) {
		this.brakeKey0 = piBrakeKey0;
	}

	/**
	 * ブレイクキー１を取得.
	 * 
	 * @return ブレイクキー１
	 */
	public String getBrakeKey1() {
		return this.brakeKey1;
	}

	/**
	 * ブレイクキー１を設定.
	 * 
	 * @param piBrakeKey1
	 *            ブレイクキー１
	 */
	public void setBrakeKey1(String piBrakeKey1) {
		this.brakeKey1 = piBrakeKey1;
	}

	/**
	 * ブレイクキー２を取得.
	 * 
	 * @return ブレイクキー２
	 */
	public String getBrakeKey2() {
		return this.brakeKey2;
	}

	/**
	 * ブレイクキー２を設定.
	 * 
	 * @param piBrakeKey2
	 *            ブレイクキー２
	 */
	public void setBrakeKey2(String piBrakeKey2) {
		this.brakeKey2 = piBrakeKey2;
	}

	/**
	 * ブレイクキー３を取得.
	 * 
	 * @return ブレイクキー３
	 */
	public String getBrakeKey3() {
		return this.brakeKey3;
	}

	/**
	 * ブレイクキー３を設定.
	 * 
	 * @param piBrakeKey3
	 *            ブレイクキー３
	 */
	public void setBrakeKey3(String piBrakeKey3) {
		this.brakeKey3 = piBrakeKey3;
	}

	/**
	 * ブレイクキー４を取得.
	 * 
	 * @return ブレイクキー４
	 */
	public String getBrakeKey4() {
		return this.brakeKey4;
	}

	/**
	 * ブレイクキー４を設定.
	 * 
	 * @param piBrakeKey4
	 *            ブレイクキー４
	 */
	public void setBrakeKey4(String piBrakeKey4) {
		this.brakeKey4 = piBrakeKey4;
	}

	// 2020/05/22 ADD START
	/**
	 * ブレイクキー0_1を取得.
	 * 
	 * @return ブレイクキー0_1
	 */
	public String getBrakeKey0_1() {
		return this.brakeKey0_1;
	}

	/**
	 * ブレイクキー0_1を設定.
	 * 
	 * @param piBrakeKey0_1
	 *            ブレイクキー0_1
	 */
	public void setBrakeKey0_1(String piBrakeKey0_1) {
		this.brakeKey0_1 = piBrakeKey0_1;
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
	 * @param piJysiUm
	 *            重要性有無
	 */
	public void setJysiUm(String piJysiUm) {
		this.jysiUm = piJysiUm;
	}
		
	// 2020/05/22 ADD END
	
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
	 *            リース会社
	 */
	public void setLeaseCompany(String piLeaseCompany) {
		this.leaseCompany = piLeaseCompany;
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
	 *            リース取引分類
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
	 *            固定資産科目
	 */
	public void setKoteiSisanKamoku(String piKoteiSisanKamoku) {
		this.koteiSisanKamoku = piKoteiSisanKamoku;
	}

	/**
	 * 減価償却方法を取得.
	 * 
	 * @return 減価償却方法
	 */
	public String getGenkaSyoukyakuHohou() {
		return this.genkaSyoukyakuHohou;
	}

	/**
	 * 減価償却方法を設定.
	 * 
	 * @param piGenkaSyoukyakuHohou
	 *            減価償却方法
	 */
	public void setGenkaSyoukyakuHohou(String piGenkaSyoukyakuHohou) {
		this.genkaSyoukyakuHohou = piGenkaSyoukyakuHohou;
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
	 *            リース開始日
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
	 *            リース終了日
	 */
	public void setLeaseTo(String piLeaseTo) {
		this.leaseTo = piLeaseTo;
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
	 * @param piBukenNo
	 *            物件番号
	 */
	public void setBukenNo(String piBukenNo) {
		this.bukenNo = piBukenNo;
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
	 * 物件名を設定.
	 * 
	 * @param piBukenNm
	 *            物件名
	 */
	public void setBukenNm(String piBukenNm) {
		this.bukenNm = piBukenNm;
	}

	/**
	 * 中途解約日を取得.
	 * 
	 * @return 中途解約日
	 */
	public String getKaiyakuYmd() {
		return this.kaiyakuYmd;
	}

	/**
	 * 中途解約日を設定.
	 * 
	 * @param piKaiyakuYmd
	 *            中途解約日
	 */
	public void setKaiyakuYmd(String piKaiyakuYmd) {
		this.kaiyakuYmd = piKaiyakuYmd;
	}

	/**
	 * リース期間を取得.
	 * 
	 * @return リース期間
	 */
	public String getLeaseTerm() {
		return this.leaseTerm;
	}

	/**
	 * リース期間を設定.
	 * 
	 * @param piLeaseTerm
	 *            リース期間
	 */
	public void setLeaseTerm(String piLeaseTerm) {
		this.leaseTerm = piLeaseTerm;
	}

	/**
	 * 耐用年数を取得.
	 * 
	 * @return 耐用年数
	 */
	public String getTaiyouNensu() {
		return this.taiyouNensu;
	}

	/**
	 * 耐用年数を設定.
	 * 
	 * @param piTaiyouNensu
	 *            耐用年数
	 */
	public void setTaiyouNensu(String piTaiyouNensu) {
		this.taiyouNensu = piTaiyouNensu;
	}

	/**
	 * 取得価額相当額を取得.
	 * 
	 * @return 取得価額相当額
	 */
	public long getSyutokuKakaku() {
		return this.syutokuKakaku;
	}

	/**
	 * 取得価額相当額を設定.
	 * 
	 * @param piSyutokuKakaku
	 *            取得価額相当額
	 */
	public void setSyutokuKakaku(long piSyutokuKakaku) {
		this.syutokuKakaku = piSyutokuKakaku;
	}

	/**
	 * 残価保証額を取得.
	 * 
	 * @return 残価保証額
	 */
	public long getZanHosyou() {
		return this.zanHosyou;
	}

	/**
	 * 残価保証額を設定.
	 * 
	 * @param piZanHosyou
	 *            残価保証額
	 */
	public void setZanHosyou(long piZanHosyou) {
		this.zanHosyou = piZanHosyou;
	}

	/**
	 * 当期減価償却費を取得.
	 * 
	 * @return 当期減価償却費
	 */
	public long getToukiGenkasyokyaku() {
		return this.toukiGenkasyokyaku;
	}

	/**
	 * 当期減価償却費を設定.
	 * 
	 * @param piToukiGenkasyokyaku
	 *            当期減価償却費
	 */
	public void setToukiGenkasyokyaku(long piToukiGenkasyokyaku) {
		this.toukiGenkasyokyaku = piToukiGenkasyokyaku;
	}

	/**
	 * 減価償却累計額を取得.
	 * 
	 * @return 減価償却累計額
	 */
	public long getGenkasyoukyakuRuikei() {
		return this.genkasyoukyakuRuikei;
	}

	/**
	 * 減価償却累計額を設定.
	 * 
	 * @param piGenkasyoukyakuRuikei
	 *            減価償却累計額
	 */
	public void setGenkasyoukyakuRuikei(long piGenkasyoukyakuRuikei) {
		this.genkasyoukyakuRuikei = piGenkasyoukyakuRuikei;
	}

	/**
	 * 期末残高相当額を取得.
	 * 
	 * @return 期末残高相当額
	 */
	public long getKimatuZan() {
		return this.kimatuZan;
	}

	/**
	 * 期末残高相当額を設定.
	 * 
	 * @param piKimatuZan
	 *            期末残高相当額
	 */
	public void setKimatuZan(long piKimatuZan) {
		this.kimatuZan = piKimatuZan;
	}

	/**
	 * 会計処理方法を取得.
	 * 
	 * @return 会計処理方法
	 */
	public String getAcShrKbnName() {
		return this.acShrKbnName;
	}

	/**
	 * 会計処理方法を設定.
	 * 
	 * @param piAcShrKbnName
	 *            会計処理方法
	 */
	public void setAcShrKbnName(String piAcShrKbnName) {
		this.acShrKbnName = piAcShrKbnName;
	}

	/**
	 * 割引計算利子率を取得.
	 * 
	 * @return 割引計算利子率
	 */
	public String getWaribikiKeisanRisiRitu() {
		return this.waribikiKeisanRisiRitu;
	}

	/**
	 * 割引計算利子率を設定.
	 * 
	 * @param piWaribikiKeisanRisiRitu
	 *            割引計算利子率
	 */
	public void setWaribikiKeisanRisiRitu(String piWaribikiKeisanRisiRitu) {
		this.waribikiKeisanRisiRitu = piWaribikiKeisanRisiRitu;
	}

}
