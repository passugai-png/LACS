package jp.co.pro_app.lacs.affairs.report.bean;

/**
 * 帳票出力：リース会計資料（支払リース料等）Bean.
 * 
 * @author ohmura
 * @version 20070903
 */
public class LACSReportSiharaiBean {

	private String	brakeKey0						= "";	// ブレイクキー０

	private String	brakeKey1						= "";	// ブレイクキー１

	private String	brakeKey2						= "";	// ブレイクキー２

	private String	brakeKey3						= "";	// ブレイクキー３

	private String	brakeKey4						= "";	// ブレイクキー４

	private String	brakeKey5						= "";	// ブレイクキー５

	// 2020/05/22 ADD START
	private String	brakeKey0_1				= "";	// ブレイクキー0_1 重要性有無
	// 2020/05/22 ADD START

	private String	leaseCompany					= "";	// リース会社

	// 2020/05/22 ADD START
	private String	jysiUm				= "";		// 重要性有無
	// 2020/05/22 ADD START

	private String	leaseBunrui						= "";	// リース取引分類

	private String	koteiSisanKamoku				= "";	// 固定資産科目

	private String	risokuBunpaiHouhou				= "";	// 利息相当額配分方法

	private String	toukiReaseRyouKeisanKijyun		= "";	// 当期支払リース料計算基準

	private String	mikeikaReaseRyouKeisanKijyun	= "";	// 未経過リース料等計算基準

	private String	keiyakuNo						= "";	// 契約番号

	private String	leaseFrom						= "";	// リース開始日

	private String	leaseTo							= "";	// リース終了日
	
	private String	kaiFunoYMD						= "";	// 解約不能期間リース終了日

	private String	bukenNo							= "";	// 物件番号

	private String	bukenNm							= "";	// 物件名

	private String	kaiyakuYmd						= "";	// 中途解約日

	private String	keisanRisiRitu					= "";	// 計算利子率

	private long	leaseSougaku					= 0;	// リース料総額

	private long	syutokuKakakuSoutou				= 0;	// 取得価格相当額

	private long	ijikanriHi						= 0;	// 維持管理費相当額

	private long	ekmTeik							= 0;	// 役務提供費

	private long	zanHosyou						= 0;	// 残価保証額

	private long	toukSiharaiLeaseRyou			= 0;	// 当期支払リース料

	private long	toukiIjiKanriHi					= 0;	// 当期維持管理費

	private long	toukiEkmTeik					= 0;	// 当期役務提供費

	private long	siharaiRisoku					= 0;	// 支払利息相当額

	private long	leaseSaimuHensaiGaku			= 0;	// リース債務相当額

	private long	mikeikaKimatuZan				= 0;	// 期末残高相当額

	private long	mikeikaKimatuZan1Nai			= 0;	// 期末残高相当額（内１年内）

	private long	mikeikaKimatuZan1Cyo			= 0;	// 期末残高相当額（内１年超）

	private String	leasCompanyNm					= "";	// リース会社名

	private String	leasUserNm						= "";	// リースユーザ名

	private String	acShrKbnName					= "";	// 会計処理方法

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

	/**
	 * ブレイクキー５を取得.
	 * 
	 * @return ブレイクキー５
	 */
	public String getBrakeKey5() {
		return this.brakeKey5;
	}

	/**
	 * ブレイクキー５を設定.
	 * 
	 * @param piBrakeKey5
	 *            ブレイクキー５
	 */
	public void setBrakeKey5(String piBrakeKey5) {
		this.brakeKey5 = piBrakeKey5;
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
	 *            利息相当額配分方法
	 */
	public void setRisokuBunpaiHouhou(String piRisokuBunpaiHouhou) {
		this.risokuBunpaiHouhou = piRisokuBunpaiHouhou;
	}

	/**
	 * 当期支払リース料計算基準を取得.
	 * 
	 * @return 当期支払リース料計算基準
	 */
	public String getToukiReaseRyouKeisanKijyun() {
		return this.toukiReaseRyouKeisanKijyun;
	}

	/**
	 * 当期支払リース料計算基準を設定.
	 * 
	 * @param piToukiReaseRyouKeisanKijyun
	 *            当期支払リース料計算基準
	 */
	public void setToukiReaseRyouKeisanKijyun(String piToukiReaseRyouKeisanKijyun) {
		this.toukiReaseRyouKeisanKijyun = piToukiReaseRyouKeisanKijyun;
	}

	/**
	 * 未経過リース料等計算基準を取得.
	 * 
	 * @return 未経過リース料等計算基準
	 */
	public String getMikeikaReaseRyouKeisanKijyun() {
		return this.mikeikaReaseRyouKeisanKijyun;
	}

	/**
	 * 未経過リース料等計算基準を設定.
	 * 
	 * @param piMikeikaReaseRyouKeisanKijyun
	 *            未経過リース料等計算基準
	 */
	public void setMikeikaReaseRyouKeisanKijyun(String piMikeikaReaseRyouKeisanKijyun) {
		this.mikeikaReaseRyouKeisanKijyun = piMikeikaReaseRyouKeisanKijyun;
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
	 * 計算利子率を取得.
	 * 
	 * @return 計算利子率
	 */
	public String getKeisanRisiRitu() {
		return this.keisanRisiRitu;
	}

	/**
	 * 計算利子率を設定.
	 * 
	 * @param piKeisanRisiRitu
	 *            計算利子率
	 */
	public void setKeisanRisiRitu(String piKeisanRisiRitu) {
		this.keisanRisiRitu = piKeisanRisiRitu;
	}

	/**
	 * リース料総額を取得.
	 * 
	 * @return リース料総額
	 */
	public long getLeaseSougaku() {
		return this.leaseSougaku;
	}

	/**
	 * リース料総額を設定.
	 * 
	 * @param piLeaseSougaku
	 *            リース料総額
	 */
	public void setLeaseSougaku(long piLeaseSougaku) {
		this.leaseSougaku = piLeaseSougaku;
	}

	/**
	 * 取得価格相当額を取得.
	 * 
	 * @return 取得価格相当額
	 */
	public long getSyutokuKakakuSoutou() {
		return this.syutokuKakakuSoutou;
	}

	/**
	 * 取得価格相当額を設定.
	 * 
	 * @param piSyutokuKakakuSoutou
	 *            取得価格相当額
	 */
	public void setSyutokuKakakuSoutou(long piSyutokuKakakuSoutou) {
		this.syutokuKakakuSoutou = piSyutokuKakakuSoutou;
	}

	/**
	 * 維持管理費相当額を取得.
	 * 
	 * @return 維持管理費相当額
	 */
	public long getEkmTeik() {
		return this.ekmTeik;
	}

	/**
	 * 維持管理費相当額を設定.
	 * 
	 * @param piEkmTeik
	 *            維持管理費相当額
	 */
	public void setEkmTeik(long piEkmTeik) {
		this.ekmTeik = piEkmTeik;
	}

	/**
	 * 維持管理費相当額を取得.
	 * 
	 * @return 維持管理費相当額
	 */
	public long getIjikanriHi() {
		return this.ijikanriHi;
	}

	/**
	 * 維持管理費相当額を設定.
	 * 
	 * @param piIjikanriHi
	 *            維持管理費相当額
	 */
	public void setIjikanriHi(long piIjikanriHi) {
		this.ijikanriHi = piIjikanriHi;
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
	 * 当期支払リース料を取得.
	 * 
	 * @return 当期支払リース料
	 */
	public long getToukSiharaiLeaseRyou() {
		return this.toukSiharaiLeaseRyou;
	}

	/**
	 * 当期支払リース料を設定.
	 * 
	 * @param piToukSiharaiLeaseRyou
	 *            当期支払リース料
	 */
	public void setToukSiharaiLeaseRyou(long piToukSiharaiLeaseRyou) {
		this.toukSiharaiLeaseRyou = piToukSiharaiLeaseRyou;
	}

	/**
	 * 維持管理費相当額を取得.
	 * 
	 * @return 維持管理費相当額
	 */
	public long getToukiEkmTeik() {
		return this.toukiEkmTeik;
	}

	/**
	 * 維持管理費相当額を設定.
	 * 
	 * @param piToukiEkmTeik
	 *            維持管理費相当額
	 */
	public void setToukiEkmTeik(long piToukiEkmTeik) {
		this.toukiEkmTeik = piToukiEkmTeik;
	}

	/**
	 * 当期維持管理費を取得.
	 * 
	 * @return 当期維持管理費
	 */
	public long getToukiIjiKanriHi() {
		return this.toukiIjiKanriHi;
	}

	/**
	 * 当期維持管理費を設定.
	 * 
	 * @param piToukiIjiKanriHi
	 *            当期維持管理費
	 */
	public void setToukiIjiKanriHi(long piToukiIjiKanriHi) {
		this.toukiIjiKanriHi = piToukiIjiKanriHi;
	}

	/**
	 * 支払利息相当額を取得.
	 * 
	 * @return 支払利息相当額
	 */
	public long getSiharaiRisoku() {
		return this.siharaiRisoku;
	}

	/**
	 * 支払利息相当額を設定.
	 * 
	 * @param piSiharaiRisoku
	 *            支払利息相当額
	 */
	public void setSiharaiRisoku(long piSiharaiRisoku) {
		this.siharaiRisoku = piSiharaiRisoku;
	}

	/**
	 * リース債務相当額を取得.
	 * 
	 * @return リース債務相当額
	 */
	public long getLeaseSaimuHensaiGaku() {
		return this.leaseSaimuHensaiGaku;
	}

	/**
	 * リース債務相当額を設定.
	 * 
	 * @param piLeaseSaimuHensaiGaku
	 *            リース債務相当額
	 */
	public void setLeaseSaimuHensaiGaku(long piLeaseSaimuHensaiGaku) {
		this.leaseSaimuHensaiGaku = piLeaseSaimuHensaiGaku;
	}

	/**
	 * 期末残高相当額を取得.
	 * 
	 * @return 期末残高相当額
	 */
	public long getMikeikaKimatuZan() {
		return this.mikeikaKimatuZan;
	}

	/**
	 * 期末残高相当額を設定.
	 * 
	 * @param piMikeikaKimatuZan
	 *            期末残高相当額
	 */
	public void setMikeikaKimatuZan(long piMikeikaKimatuZan) {
		this.mikeikaKimatuZan = piMikeikaKimatuZan;
	}

	/**
	 * 期末残高相当額（内１年内）を取得.
	 * 
	 * @return 期末残高相当額（内１年内）
	 */
	public long getMikeikaKimatuZan1Nai() {
		return this.mikeikaKimatuZan1Nai;
	}

	/**
	 * 期末残高相当額（内１年内）を設定.
	 * 
	 * @param piMikeikaKimatuZan1Nai
	 *            期末残高相当額（内１年内）
	 */
	public void setMikeikaKimatuZan1Nai(long piMikeikaKimatuZan1Nai) {
		this.mikeikaKimatuZan1Nai = piMikeikaKimatuZan1Nai;
	}

	/**
	 * 期末残高相当額（内１年超）を取得.
	 * 
	 * @return 期末残高相当額（内１年超）
	 */
	public long getMikeikaKimatuZan1Cyo() {
		return this.mikeikaKimatuZan1Cyo;
	}

	/**
	 * 期末残高相当額（内１年超）を設定.
	 * 
	 * @param piMikeikaKimatuZan1Cyo
	 *            期末残高相当額（内１年超）
	 */
	public void setMikeikaKimatuZan1Cyo(long piMikeikaKimatuZan1Cyo) {
		this.mikeikaKimatuZan1Cyo = piMikeikaKimatuZan1Cyo;
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
	 * 解約不能リース終了日を取得.
	 * 
	 * @return 解約不能リース終了日
	 */
	public String getKaiFunoYMD() {
		return this.kaiFunoYMD;
	}

	/**
	 * 解約不能リース終了日を設定.
	 * 
	 * @param piKaiFunoYMD
	 *            解約不能リース終了日
	 */
	public void setKaiFunoYMD(String piKaiFunoYMD) {
		this.kaiFunoYMD = piKaiFunoYMD;
	}

}
