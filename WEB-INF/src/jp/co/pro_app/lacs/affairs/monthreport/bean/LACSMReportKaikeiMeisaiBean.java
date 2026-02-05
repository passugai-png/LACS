package jp.co.pro_app.lacs.affairs.monthreport.bean;

/**
 * 月次帳票出力：リース会計基準明細書 Bean.
 * 
 * @author fukuhara
 * @version 20080411
 */
public class LACSMReportKaikeiMeisaiBean {

	private String	createDate			= "";	// 作成日

	private String	leaseUserNm			= "";	// リースユーザ名

	private String	leaseCompanyNm		= "";	// リース会社名

	private String	leaseCompanyZip		= "";	// リース会社郵便番号

	private String	leaseCompanyAddr1	= "";	// リース会社住所１

	private String	leaseCompanyAddr2	= "";	// リース会社住所２

	private String	leaseCompanyTelno	= "";	// リース会社電話番号

	private String	keiNo				= "";	// 契約番号

	private String	keiTerm				= "";	// 期間

	private String	keiYmd				= "";	// 契約日

	private String	knshuYmd			= "";	// 検収日

	private String	mryoYmd				= "";	// 満了日

	private String	dihBknNm			= "";	// 代表物件名

	private String	trdHnteKekaKbn		= "";	// 取引判定結果区分

	private String	trdHnteKekaNm		= "";	// 取引判定結果名称

	private String	lamtSum				= "";	// リース料総額現在価値

	private String	keiAmt				= "";	// 契約額

	private String	knuAmt				= "";	// 見積購入価額

	private String	keiAmtStaxSum		= "";	// 消費税総額

	private String	rskSum				= "";	// 利息総額

	private String	zankHshoAmtSum		= "";	// 残価

	private String	ijiHyoSum			= "";	// 維持管理費総額

	private String	ekmHyoSum			= "";	// 役務提供総額

	private String	rskKeijHohoKbn		= "";	// 利息計上方法区分

	private String	rskKeijHohoKbnNm	= "";	// 利息計上方法名称

	private String	tnkiHohoKbn			= "";	// 回収スケジュール展開方法

	private String	fknTnkiHohoNm		= "";	// 回収スケジュール展開方法名称

	private String	gnkskHasuChseCd		= "";	// 減価償却端数調整コード

	private String	hasuChseNm			= "";	// 減価償却端数調整方法名称

	private String	keijYm				= "";	// 年月

	private String	lamt				= "";	// お支払金額

	private String	tgtuGnpn			= "";	// うち元本

	private String	tgtuRsk				= "";	// うち利息

	private String	ijiKanriHyo			= "";	// 維持管理費

	private String	ekmTeikHyo			= "";	// 役務提供費

	private String	zandGnpn			= "";	// 元本残高

	private String	mkLam				= "";	// 未経過リース料

	private String	krKnjKmkCd			= "";	// 借方科目コード

	private String	krKnjKmkNm			= "";	// 借方科目名称

	private String	krktAmt				= "";	// 借方金額

	private String	ksKnjKmkCd			= "";	// 貸方科目コード

	private String	ksKnjKmkNm			= "";	// 貸方科目名称

	private String	ksktAmt				= "";	// 貸方金額

	private String	warning1			= "";	// 注意１

	private String	warning2			= "";	// 注意２

	private String	warning3			= "";	// 注意３

	private String	hyjyoKeiNo			= "";	// 表示用契約番号

	// 20210901 リース会計明細基準書 対応 start
	private String	breakKey0			= "";	// ブレイクキー
	// 20210901 リース会計明細基準書 対応 end
	
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
	 * ブレイクキー0を取得.
	 * 
	 * @return ブレイクキー1
	 */
	public String getBrakeKey0() {
		return this.breakKey0;
	}
	
	/**
	 * 作成日を取得.
	 * 
	 * @return 作成日
	 */
	public String getCreateDate() {
		return this.createDate;
	}

	/**
	 * リースユーザ名を取得.
	 * 
	 * @return リースユーザ名
	 */
	public String getLeaseUserNm() {
		return this.leaseUserNm;
	}

	/**
	 * リース会社名を取得.
	 * 
	 * @return リース会社名
	 */
	public String getLeaseCompanyNm() {
		return this.leaseCompanyNm;
	}

	/**
	 * リース会社郵便番号を取得.
	 * 
	 * @return リース会社郵便番号
	 */
	public String getLeaseCompanyZip() {
		return this.leaseCompanyZip;
	}

	/**
	 * リース会社住所１を取得.
	 * 
	 * @return リース会社住所１
	 */
	public String getLeaseCompanyAddr1() {
		return this.leaseCompanyAddr1;
	}

	/**
	 * リース会社住所２を取得.
	 * 
	 * @return リース会社住所２
	 */
	public String getLeaseCompanyAddr2() {
		return this.leaseCompanyAddr2;
	}

	/**
	 * リース会社電話番号を取得.
	 * 
	 * @return リース会社電話番号
	 */
	public String getLeaseCompanyTelno() {
		return this.leaseCompanyTelno;
	}

	/**
	 * 契約番号を取得.
	 * 
	 * @return 契約番号
	 */
	public String getKeiNo() {
		return this.keiNo;
	}

	/**
	 * 期間を取得.
	 * 
	 * @return 期間
	 */
	public String getKeiTerm() {
		return this.keiTerm;
	}

	/**
	 * 契約日を取得.
	 * 
	 * @return 契約日
	 */
	public String getKeiYmd() {
		return this.keiYmd;
	}

	/**
	 * 検収日を取得.
	 * 
	 * @return 検収日
	 */
	public String getKnshuYmd() {
		return this.knshuYmd;
	}

	/**
	 * 満了日を取得.
	 * 
	 * @return 満了日
	 */
	public String getMryoYmd() {
		return this.mryoYmd;
	}

	/**
	 * 代表物件名を取得.
	 * 
	 * @return 代表物件名
	 */
	public String getDihBknNm() {
		return this.dihBknNm;
	}

	/**
	 * 取引判定結果区分を取得.
	 * 
	 * @return 取引判定結果区分
	 */
	public String getTrdHnteKekaKbn() {
		return this.trdHnteKekaKbn;
	}

	/**
	 * 取引判定結果名称を取得.
	 * 
	 * @return 取引判定結果名称
	 */
	public String getTrdHnteKekaNm() {
		return this.trdHnteKekaNm;
	}

	/**
	 * リース料総額現在価値を取得.
	 * 
	 * @return リース料総額現在価値
	 */
	public String getLamtSum() {
		return this.lamtSum;
	}

	/**
	 * 契約額を取得.
	 * 
	 * @return 契約額
	 */
	public String getKeiAmt() {
		return this.keiAmt;
	}

	/**
	 * 見積購入価額を取得.
	 * 
	 * @return 見積購入価額
	 */
	public String getKnuAmt() {
		return this.knuAmt;
	}

	/**
	 * 消費税総額を取得.
	 * 
	 * @return 消費税総額
	 */
	public String getKeiAmtStaxSum() {
		return this.keiAmtStaxSum;
	}

	/**
	 * 利息総額を取得.
	 * 
	 * @return 利息総額
	 */
	public String getRskSum() {
		return this.rskSum;
	}

	/**
	 * 残価を取得.
	 * 
	 * @return 残価
	 */
	public String getZankHshoAmtSum() {
		return this.zankHshoAmtSum;
	}

	/**
	 * 維持管理費総額を取得.
	 * 
	 * @return 維持管理費総額
	 */
	public String getIjiHyoSum() {
		return this.ijiHyoSum;
	}

	/**
	 * 役務提供総額を取得.
	 * 
	 * @return 役務提供総額
	 */
	public String getEkmHyoSum() {
		return this.ekmHyoSum;
	}

	/**
	 * 利息計上方法区分を取得.
	 * 
	 * @return 利息計上方法区分
	 */
	public String getRskKeijHohoKbn() {
		return this.rskKeijHohoKbn;
	}

	/**
	 * 利息計上方法名称を取得.
	 * 
	 * @return 利息計上方法名称
	 */
	public String getRskKeijHohoKbnNm() {
		return this.rskKeijHohoKbnNm;
	}

	/**
	 * 回収スケジュール展開方法を取得.
	 * 
	 * @return 回収スケジュール展開方法
	 */
	public String getTnkiHohoKbn() {
		return this.tnkiHohoKbn;
	}

	/**
	 * 回収スケジュール展開方法名称を取得.
	 * 
	 * @return 回収スケジュール展開方法名称
	 */
	public String getFknTnkiHohoNm() {
		return this.fknTnkiHohoNm;
	}

	/**
	 * 減価償却端数調整コードを取得.
	 * 
	 * @return 減価償却端数調整コード
	 */
	public String getGnkskHasuChseCd() {
		return this.gnkskHasuChseCd;
	}

	/**
	 * 減価償却端数調整方法名称を取得.
	 * 
	 * @return 減価償却端数調整方法名称
	 */
	public String getHasuChseNm() {
		return this.hasuChseNm;
	}

	/**
	 * 年月を取得.
	 * 
	 * @return 年月
	 */
	public String getKeijYm() {
		return this.keijYm;
	}

	/**
	 * お支払金額を取得.
	 * 
	 * @return お支払金額
	 */
	public String getLamt() {
		return this.lamt;
	}

	/**
	 * うち元本を取得.
	 * 
	 * @return うち元本
	 */
	public String getTgtuGnpn() {
		return this.tgtuGnpn;
	}

	/**
	 * うち利息を取得.
	 * 
	 * @return うち利息
	 */
	public String getTgtuRsk() {
		return this.tgtuRsk;
	}

	/**
	 * 維持管理費を取得.
	 * 
	 * @return 維持管理費
	 */
	public String getIjiKanriHyo() {
		return this.ijiKanriHyo;
	}

	/**
	 * 役務提供費を取得.
	 * 
	 * @return 役務提供費
	 */
	public String getEkmTeikHyo() {
		return this.ekmTeikHyo;
	}

	/**
	 * 元本残高を取得.
	 * 
	 * @return 元本残高
	 */
	public String getZandGnpn() {
		return this.zandGnpn;
	}

	/**
	 * 未経過リース料を取得.
	 * 
	 * @return 未経過リース料
	 */
	public String getMkLamt() {
		return this.mkLam;
	}

	/**
	 * 借方科目コードを取得.
	 * 
	 * @return 借方科目コード
	 */
	public String getKrKnjKmkCd() {
		return this.krKnjKmkCd;
	}

	/**
	 * 借方科目名称を取得.
	 * 
	 * @return 借方科目名称
	 */
	public String getKrKnjKmkNm() {
		return this.krKnjKmkNm;
	}

	/**
	 * 借方金額を取得.
	 * 
	 * @return 借方金額
	 */
	public String getKrktAmt() {
		return this.krktAmt;
	}

	/**
	 * 貸方科目コードを取得.
	 * 
	 * @return 貸方科目コード
	 */
	public String getKsKnjKmkCd() {
		return this.ksKnjKmkCd;
	}

	/**
	 * 貸方科目名称を取得.
	 * 
	 * @return 貸方科目名称
	 */
	public String getKsKnjKmkNm() {
		return this.ksKnjKmkNm;
	}

	/**
	 * 貸方金額を取得. *
	 * 
	 * @return 貸方金額
	 */
	public String getKsktAmt() {
		return this.ksktAmt;
	}

	/**
	 * 作成日を設定.
	 * 
	 * @param piCreateDate
	 *            作成日
	 */
	public void setCreateDate(String piCreateDate) {
		this.createDate = piCreateDate;
	}

	/**
	 * リースユーザ名を設定.
	 * 
	 * @param piLeaseUserNm
	 *            リースユーザ名
	 */
	public void setLeaseUserNm(String piLeaseUserNm) {
		this.leaseUserNm = piLeaseUserNm;
	}

	/**
	 * リース会社名を設定.
	 * 
	 * @param piLeaseCompanyNm
	 *            リース会社名
	 */
	public void setLeaseCompanyNm(String piLeaseCompanyNm) {
		this.leaseCompanyNm = piLeaseCompanyNm;
	}

	/**
	 * リース会社郵便番号を設定.
	 * 
	 * @param piLeaseCompanyZip
	 *            リース会社郵便番号
	 */
	public void setLeaseCompanyZip(String piLeaseCompanyZip) {
		this.leaseCompanyZip = piLeaseCompanyZip;
	}

	/**
	 * リース会社住所１を設定.
	 * 
	 * @param piLeaseCompanyAddr1
	 *            リース会社住所１
	 */
	public void setLeaseCompanyAddr1(String piLeaseCompanyAddr1) {
		this.leaseCompanyAddr1 = piLeaseCompanyAddr1;
	}

	/**
	 * リース会社住所２を設定.
	 * 
	 * @param piLeaseCompanyAddr2
	 *            リース会社住所２
	 */
	public void setLeaseCompanyAddr2(String piLeaseCompanyAddr2) {
		this.leaseCompanyAddr2 = piLeaseCompanyAddr2;
	}

	/**
	 * リース会社電話番号を設定.
	 * 
	 * @param piLeaseCompanyTelno
	 *            リース会社電話番号
	 */
	public void setLeaseCompanyTelno(String piLeaseCompanyTelno) {
		this.leaseCompanyTelno = piLeaseCompanyTelno;
	}

	/**
	 * 契約番号を設定.
	 * 
	 * @param piKeiNo
	 *            契約番号
	 */
	public void setKeiNo(String piKeiNo) {
		this.keiNo = piKeiNo;
	}

	/**
	 * 期間を設定.
	 * 
	 * @param piKeiTerm
	 *            期間
	 */
	public void setKeiTerm(String piKeiTerm) {
		this.keiTerm = piKeiTerm;
	}

	/**
	 * 契約日を設定.
	 * 
	 * @param piKeiYmd
	 *            契約日
	 */
	public void setKeiYmd(String piKeiYmd) {
		this.keiYmd = piKeiYmd;
	}

	/**
	 * 検収日を設定.
	 * 
	 * @param piKnshuYmd
	 *            検収日
	 */
	public void setKnshuYmd(String piKnshuYmd) {
		this.knshuYmd = piKnshuYmd;
	}

	/**
	 * 満了日を設定.
	 * 
	 * @param piMryoYmd
	 *            満了日
	 */
	public void setMryoYmd(String piMryoYmd) {
		this.mryoYmd = piMryoYmd;
	}

	/**
	 * 代表物件名を設定.
	 * 
	 * @param piDihBknNm
	 *            代表物件名
	 */
	public void setDihBknNm(String piDihBknNm) {
		this.dihBknNm = piDihBknNm;
	}

	/**
	 * 取引判定結果区分を設定.
	 * 
	 * @param piTrdHnteKekaKbn
	 *            取引判定結果区分
	 */
	public void setTrdHnteKekaKbn(String piTrdHnteKekaKbn) {
		this.trdHnteKekaKbn = piTrdHnteKekaKbn;
	}

	/**
	 * 取引判定結果名称を設定.
	 * 
	 * @param piTrdHnteKekaNm
	 *            取引判定結果名称
	 */
	public void setTrdHnteKekaNm(String piTrdHnteKekaNm) {
		this.trdHnteKekaNm = piTrdHnteKekaNm;
	}

	/**
	 * リース料総額現在価値を設定.
	 * 
	 * @param piLamtSum
	 *            リース料総額現在価値
	 */
	public void setLamtSum(String piLamtSum) {
		this.lamtSum = piLamtSum;
	}

	/**
	 * 契約額を設定.
	 * 
	 * @param piKeiAmt
	 *            契約額
	 */
	public void setKeiAmt(String piKeiAmt) {
		this.keiAmt = piKeiAmt;
	}

	/**
	 * 見積購入価額を設定.
	 * 
	 * @param piKnuAmt
	 *            見積購入価額
	 */
	public void setKnuAmt(String piKnuAmt) {
		this.knuAmt = piKnuAmt;
	}

	/**
	 * 消費税総額を設定.
	 * 
	 * @param piKeiAmtStaxSum
	 *            消費税総額
	 */
	public void setKeiAmtStaxSum(String piKeiAmtStaxSum) {
		this.keiAmtStaxSum = piKeiAmtStaxSum;
	}

	/**
	 * 利息総額を設定.
	 * 
	 * @param piRskSum
	 *            利息総額
	 */
	public void setRskSum(String piRskSum) {
		this.rskSum = piRskSum;
	}

	/**
	 * 残価を設定.
	 * 
	 * @param piZankHshoAmtSum
	 *            残価
	 */
	public void setZankHshoAmtSum(String piZankHshoAmtSum) {
		this.zankHshoAmtSum = piZankHshoAmtSum;
	}

	/**
	 * 維持管理費総額を設定.
	 * 
	 * @param piIjiHyoSum
	 *            維持管理費総額
	 */
	public void setIjiHyoSum(String piIjiHyoSum) {
		this.ijiHyoSum = piIjiHyoSum;
	}

	/**
	 * 役務提供総額を設定.
	 * 
	 * @param piEkmHyoSum
	 *            役務提供総額
	 */
	public void setEkmHyoSum(String piEkmHyoSum) {
		this.ekmHyoSum = piEkmHyoSum;
	}

	/**
	 * 利息計上方法区分を設定.
	 * 
	 * @param piRskKeijHohoKbn
	 *            利息計上方法区分
	 */
	public void setRskKeijHohoKbn(String piRskKeijHohoKbn) {
		this.rskKeijHohoKbn = piRskKeijHohoKbn;
	}

	/**
	 * 利息計上方法名称を設定.
	 * 
	 * @param piRskKeijHohoKbnNm
	 *            利息計上方法名称
	 */
	public void setRskKeijHohoKbnNm(String piRskKeijHohoKbnNm) {
		this.rskKeijHohoKbnNm = piRskKeijHohoKbnNm;
	}

	/**
	 * 回収スケジュール展開方法を設定.
	 * 
	 * @param piTnkiHohoKbn
	 *            回収スケジュール展開方法
	 */
	public void setTnkiHohoKbn(String piTnkiHohoKbn) {
		this.tnkiHohoKbn = piTnkiHohoKbn;
	}

	/**
	 * 回収スケジュール展開方法名称を設定.
	 * 
	 * @param piFknTnkiHohoNm
	 *            回収スケジュール展開方法名称
	 */
	public void setFknTnkiHohoNm(String piFknTnkiHohoNm) {
		this.fknTnkiHohoNm = piFknTnkiHohoNm;
	}

	/**
	 * 減価償却端数調整コードを設定.
	 * 
	 * @param piGnkskHasuChseCd
	 *            減価償却端数調整コード
	 */
	public void setGnkskHasuChseCd(String piGnkskHasuChseCd) {
		this.gnkskHasuChseCd = piGnkskHasuChseCd;
	}

	/**
	 * 減価償却端数調整方法名称を設定.
	 * 
	 * @param piHasuChseNm
	 *            減価償却端数調整方法名称
	 */
	public void setHasuChseNm(String piHasuChseNm) {
		this.hasuChseNm = piHasuChseNm;
	}

	/**
	 * 年月を設定.
	 * 
	 * @param piKeijYm
	 *            年月
	 */
	public void setKeijYm(String piKeijYm) {
		this.keijYm = piKeijYm;
	}

	/**
	 * お支払金額を設定.
	 * 
	 * @param piLamt
	 *            お支払金額
	 */
	public void setLamt(String piLamt) {
		this.lamt = piLamt;
	}

	/**
	 * うち元本を設定.
	 * 
	 * @param piTgtuGnpn
	 *            うち元本
	 */
	public void setTgtuGnpn(String piTgtuGnpn) {
		this.tgtuGnpn = piTgtuGnpn;
	}

	/**
	 * うち利息を設定.
	 * 
	 * @param piTgtuRsk
	 *            うち利息
	 */
	public void setTgtuRsk(String piTgtuRsk) {
		this.tgtuRsk = piTgtuRsk;
	}

	/**
	 * 維持管理費を設定.
	 * 
	 * @param piIjiKanriHyo
	 *            維持管理費
	 */
	public void setIjiKanriHyo(String piIjiKanriHyo) {
		this.ijiKanriHyo = piIjiKanriHyo;
	}

	/**
	 * 役務提供費を設定.
	 * 
	 * @param piEkmTeikHyo
	 *            役務提供費
	 */
	public void setEkmTeikHyo(String piEkmTeikHyo) {
		this.ekmTeikHyo = piEkmTeikHyo;
	}

	/**
	 * 元本残高を設定.
	 * 
	 * @param piZandGnpn
	 *            元本残高
	 */
	public void setZandGnpn(String piZandGnpn) {
		this.zandGnpn = piZandGnpn;
	}

	/**
	 * 未経過リース料を設定.
	 * 
	 * @param piMkLamt
	 *            未経過リース料
	 */
	public void setMkLamt(String piMkLamt) {
		this.mkLam = piMkLamt;
	}

	/**
	 * 借方科目コードを設定.
	 * 
	 * @param piKrKnjKmkCd
	 *            借方科目コード
	 */
	public void setKrKnjKmkCd(String piKrKnjKmkCd) {
		this.krKnjKmkCd = piKrKnjKmkCd;
	}

	/**
	 * 借方科目名称を設定.
	 * 
	 * @param piKrKnjKmkNm
	 *            借方科目名称
	 */
	public void setKrKnjKmkNm(String piKrKnjKmkNm) {
		this.krKnjKmkNm = piKrKnjKmkNm;
	}

	/**
	 * 借方金額を設定.
	 * 
	 * @param piKrktAmt
	 *            借方金額
	 */
	public void setKrktAmt(String piKrktAmt) {
		this.krktAmt = piKrktAmt;
	}

	/**
	 * 貸方科目コードを設定.
	 * 
	 * @param piKsKnjKmkCd
	 *            貸方科目コード
	 */
	public void setKsKnjKmkCd(String piKsKnjKmkCd) {
		this.ksKnjKmkCd = piKsKnjKmkCd;
	}

	/**
	 * 貸方科目名称を設定.
	 * 
	 * @param piKsKnjKmkNm
	 *            貸方科目名称
	 */
	public void setKsKnjKmkNm(String piKsKnjKmkNm) {
		this.ksKnjKmkNm = piKsKnjKmkNm;
	}

	/**
	 * 貸方金額を設定.
	 * 
	 * @param piKsktAmt
	 *            貸方金額
	 */
	public void setKsktAmt(String piKsktAmt) {
		this.ksktAmt = piKsktAmt;
	}

	/**
	 * 注意１を取得.
	 * 
	 * @return 注意１
	 */
	public String getWarning1() {
		return this.warning1;
	}

	/**
	 * 注意１を設定.
	 * 
	 * @param piWarning1
	 *            注意１
	 */
	public void setWarning1(String piWarning1) {
		this.warning1 = piWarning1;
	}

	/**
	 * 注意２を取得.
	 * 
	 * @return 注意２
	 */
	public String getWarning2() {
		return this.warning2;
	}

	/**
	 * 注意２を設定.
	 * 
	 * @param piWarning2
	 *            注意２
	 */
	public void setWarning2(String piWarning2) {
		this.warning2 = piWarning2;
	}

	/**
	 * 注意３を取得.
	 * 
	 * @return 注意３
	 */
	public String getWarning3() {
		return this.warning3;
	}

	/**
	 * 注意３を設定.
	 * 
	 * @param piWarning3
	 *            注意３
	 */
	public void setWarning3(String piWarning3) {
		this.warning3 = piWarning3;
	}

	/**
	 * 表示用契約番号を取得.
	 * 
	 * @return 表示用契約番号
	 */
	public String getHyjyoKeiNo() {
		return this.hyjyoKeiNo;
	}

	/**
	 * 表示用契約番号を設定.
	 * 
	 * @param piHyjyoKeiNo
	 *            表示用契約番号
	 */
	public void setHyjyoKeiNo(String piHyjyoKeiNo) {
		this.hyjyoKeiNo = piHyjyoKeiNo;
	}
}
