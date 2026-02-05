package jp.co.pro_app.lacs.affairs.report.bean;

/**
 * 帳票出力：リース料支払スケジュール（物件単位）Bean.
 * 
 * @author ohmura
 * @version 20070905
 */
public class LACSReportBukkenBean {

	private String	brakeKey					= "";	// ブレイクキー

	private String	leaseCompany				= "";	// リース会社

	private String	keiyakuNo					= "";	// 契約番号

	private String	bukenNo						= "";	// 物件番号

	private String	leaseBunrui					= "";	// リース取引分類

	private String	koteiSisanKamoku			= "";	// 固定資産科目

	private String	leaseFrom					= "";	// リース開始日

	private String	leaseTo						= "";	// リース終了日

	private long	leaseTerm					= 0;	// リース期間

	private String	bukenNm						= "";	// 物件名

	private long	leaseSougaku				= 0;	// リース料総額

	private long	ekmTeikhyoSougaku			= 0;	// 役務提供費総額

	private long	ijikanriHiSougaku			= 0;	// 維持管理費総額

	private long	mitumoriGenkinKakaku		= 0;	// 見積現金購入価格

	private long	zanHosyou					= 0;	// 残価保証額

	private String	waribikiRisiRitu			= "";	// 割引計算利子率

	private String	maeBaraiAtoBarai			= "";	// 前払後払区分

	private String	rskkeijhohoKbn				= "";	// 利息計算方法区分

	private long	waribikiGenzaiKakaku		= 0;	// 割引現在価格

	private long	syutokuKakakuSoutou			= 0;	// 取得価格相当額

	private long	siharaiRisokuSougaku		= 0;	// 支払利息総額

	private String	risokuRisiRitu				= "";	// 利息計算利子率

	private String	toukiReaseRyouKeisanKijyun	= "";	// 当期支払リース料計算基準

	private String	risokuBunpaiHouhou			= "";	// 利息相当額配分方法

	private String	siharaiNenTuki				= "";	// 支払年月

	private long	siharaiLeaseRyou			= 0;	// 支払リース料

	private long	ekmTeikhyo					= 0;	// 役務提供費

	private long	ijikanriHi					= 0;	// 維持管理費相当額

	private long	netSiharaiLeaseRyou			= 0;	// NET支払リース料

	private long	uchiRisokuBun				= 0;	// うち利息分

	private long	uchiLeaseSaimuBun			= 0;	// うちリース債務分

	private long	mikeikaKimatuZan			= 0;	// 期末残高相当額

	private long	siharaiRisoku				= 0;	// 支払利息相当額

	private String	leasCompanyNm				= "";	// リース会社名

	private String	leasUserNm					= "";	// リースユーザ名

	private String	acShrKbnName				= "";	// 会計処理方法

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
	 * @param piLeasuserNm
	 *            リース会社名
	 */
	public void setLeasUserNm(String piLeasuserNm) {
		this.leasUserNm = piLeasuserNm;
	}

	/**
	 * ブレイクキーを取得.
	 * 
	 * @return ブレイクキー
	 */
	public String getBrakeKey() {
		return this.brakeKey;
	}

	/**
	 * ブレイクキーを設定.
	 * 
	 * @param piBrakeKey
	 *            ブレイクキー
	 */
	public void setBrakeKey(String piBrakeKey) {
		this.brakeKey = piBrakeKey;
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
	 *            リース会社
	 */
	public void setLeaseCompany(String piLeaseCompany) {
		this.leaseCompany = piLeaseCompany;
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
	 * リース期間を取得.
	 * 
	 * @return リース期間
	 */
	public long getLeaseTerm() {
		return this.leaseTerm;
	}

	/**
	 * リース期間を設定.
	 * 
	 * @param piLeaseTerm
	 *            リース期間
	 */
	public void setLeaseTerm(long piLeaseTerm) {
		this.leaseTerm = piLeaseTerm;
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
	 * 役務提供費を取得.
	 * 
	 * @return 役務提供費
	 */
	public long getEkmteikhyoSougaku() {
		return this.ekmTeikhyoSougaku;
	}

	/**
	 * 役務提供費を設定.
	 * 
	 * @param piEkmTeikhyoSougaku
	 *            役務提供費
	 */
	public void setEkmteikhyoSougaku(long piEkmTeikhyoSougaku) {
		this.ekmTeikhyoSougaku = piEkmTeikhyoSougaku;
	}

	/**
	 * 維持管理費総額を取得.
	 * 
	 * @return 維持管理費総額
	 */
	public long getIjikanriHiSougaku() {
		return this.ijikanriHiSougaku;
	}

	/**
	 * 維持管理費総額を設定.
	 * 
	 * @param piIjikanriHiSougaku
	 *            維持管理費総額
	 */
	public void setIjikanriHiSougaku(long piIjikanriHiSougaku) {
		this.ijikanriHiSougaku = piIjikanriHiSougaku;
	}

	/**
	 * 見積現金価格を取得.
	 * 
	 * @return 見積現金価格
	 */
	public long getMitumoriGenkinKakaku() {
		return this.mitumoriGenkinKakaku;
	}

	/**
	 * 見積現金価格を設定.
	 * 
	 * @param piMitumoriGenkinKakaku
	 *            見積現金価格
	 */
	public void setMitumoriGenkinKakaku(long piMitumoriGenkinKakaku) {
		this.mitumoriGenkinKakaku = piMitumoriGenkinKakaku;
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
	 * 割引計算利子率を取得.
	 * 
	 * @return 割引計算利子率
	 */
	public String getWaribikiRisiRitu() {
		return this.waribikiRisiRitu;
	}

	/**
	 * 割引計算利子率を設定.
	 * 
	 * @param piWaribikiRisiRitu
	 *            割引計算利子率
	 */
	public void setWaribikiRisiRitu(String piWaribikiRisiRitu) {
		this.waribikiRisiRitu = piWaribikiRisiRitu;
	}

	/**
	 * 利息方法区分を取得.
	 * 
	 * @return 利息方法区分
	 */
	public String getRskkeijhohoKbn() {
		return this.rskkeijhohoKbn;
	}

	/**
	 * 利息方法区分を設定.
	 * 
	 * @param piRskkeijhohoKbn
	 *            利息方法区分
	 */
	public void setRskkeijhohoKbn(String piRskkeijhohoKbn) {
		this.rskkeijhohoKbn = piRskkeijhohoKbn;
	}

	/**
	 * 前払後払区分を取得.
	 * 
	 * @return 前払後払区分
	 */
	public String getMaeBaraiAtoBarai() {
		return this.maeBaraiAtoBarai;
	}

	/**
	 * 前払後払区分を設定.
	 * 
	 * @param piMaeBaraiAtoBarai
	 *            前払後払区分
	 */
	public void setMaeBaraiAtoBarai(String piMaeBaraiAtoBarai) {
		this.maeBaraiAtoBarai = piMaeBaraiAtoBarai;
	}

	/**
	 * 割引現在価格を取得.
	 * 
	 * @return 割引現在価格
	 */
	public long getWaribikiGenzaiKakaku() {
		return this.waribikiGenzaiKakaku;
	}

	/**
	 * 割引現在価格を設定.
	 * 
	 * @param piWaribikiGenzaiKakaku
	 *            割引現在価格
	 */
	public void setWaribikiGenzaiKakaku(long piWaribikiGenzaiKakaku) {
		this.waribikiGenzaiKakaku = piWaribikiGenzaiKakaku;
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
	 * 支払利息総額を取得.
	 * 
	 * @return 支払利息総額
	 */
	public long getSiharaiRisokuSougaku() {
		return this.siharaiRisokuSougaku;
	}

	/**
	 * 支払利息総額を設定.
	 * 
	 * @param piSiharaiRisokuSougaku
	 *            支払利息総額
	 */
	public void setSiharaiRisokuSougaku(long piSiharaiRisokuSougaku) {
		this.siharaiRisokuSougaku = piSiharaiRisokuSougaku;
	}

	/**
	 * 利息計算利子率を取得.
	 * 
	 * @return 利息計算利子率
	 */
	public String getRisokuRisiRitu() {
		return this.risokuRisiRitu;
	}

	/**
	 * 利息計算利子率を設定.
	 * 
	 * @param piRisokuRisiRitu
	 *            利息計算利子率
	 */
	public void setRisokuRisiRitu(String piRisokuRisiRitu) {
		this.risokuRisiRitu = piRisokuRisiRitu;
	}

	/**
	 * 支払リース料計算基準を取得.
	 * 
	 * @return 支払リース料計算基準
	 */
	public String getToukiReaseRyouKeisanKijyun() {
		return this.toukiReaseRyouKeisanKijyun;
	}

	/**
	 * 支払リース料計算基準を設定.
	 * 
	 * @param piToukiReaseRyouKeisanKijyun
	 *            支払リース料計算基準
	 */
	public void setToukiReaseRyouKeisanKijyun(String piToukiReaseRyouKeisanKijyun) {
		this.toukiReaseRyouKeisanKijyun = piToukiReaseRyouKeisanKijyun;
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
	 * 支払年月を取得.
	 * 
	 * @return 支払年月
	 */
	public String getSiharaiNenTuki() {
		return this.siharaiNenTuki;
	}

	/**
	 * 支払年月を設定.
	 * 
	 * @param piSiharaiNenTuki
	 *            支払年月
	 */
	public void setSiharaiNenTuki(String piSiharaiNenTuki) {
		this.siharaiNenTuki = piSiharaiNenTuki;
	}

	/**
	 * 支払リース料を取得.
	 * 
	 * @return 支払リース料
	 */
	public long getSiharaiLeaseRyou() {
		return this.siharaiLeaseRyou;
	}

	/**
	 * 支払リース料を設定.
	 * 
	 * @param piSiharaiLeaseRyou
	 *            支払リース料
	 */
	public void setSiharaiLeaseRyou(long piSiharaiLeaseRyou) {
		this.siharaiLeaseRyou = piSiharaiLeaseRyou;
	}

	/**
	 * 役務提供費を取得.
	 * 
	 * @return 役務提供費
	 */
	public long getEkmTeikhyo() {
		return this.ekmTeikhyo;
	}

	/**
	 * 役務提供費を設定.
	 * 
	 * @param piEkmTeikhyo
	 *            役務提供費
	 */
	public void setEkmTeikhyo(long piEkmTeikhyo) {
		this.ekmTeikhyo = piEkmTeikhyo;
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
	 * NET支払リース料を取得.
	 * 
	 * @return NET支払リース料
	 */
	public long getNetSiharaiLeaseRyou() {
		return this.netSiharaiLeaseRyou;
	}

	/**
	 * NET支払リース料を設定.
	 * 
	 * @param piNetSiharaiLeaseRyou
	 *            NET支払リース料
	 */
	public void setNetSiharaiLeaseRyou(long piNetSiharaiLeaseRyou) {
		this.netSiharaiLeaseRyou = piNetSiharaiLeaseRyou;
	}

	/**
	 * うち利息分を取得.
	 * 
	 * @return うち利息分
	 */
	public long getUchiRisokuBun() {
		return this.uchiRisokuBun;
	}

	/**
	 * うち利息分を設定.
	 * 
	 * @param piUchiRisokuBun
	 *            うち利息分
	 */
	public void setUchiRisokuBun(long piUchiRisokuBun) {
		this.uchiRisokuBun = piUchiRisokuBun;
	}

	/**
	 * うちリース債務分を取得.
	 * 
	 * @return うちリース債務分
	 */
	public long getUchiLeaseSaimuBun() {
		return this.uchiLeaseSaimuBun;
	}

	/**
	 * うちリース債務分を設定.
	 * 
	 * @param piUchiLeaseSaimuBun
	 *            うちリース債務分
	 */
	public void setUchiLeaseSaimuBun(long piUchiLeaseSaimuBun) {
		this.uchiLeaseSaimuBun = piUchiLeaseSaimuBun;
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

}
