package jp.co.pro_app.lacs.affairs.monthreport.bean;

/**
 * 月次帳票出力：除却資産一覧Bean.
 * 
 * @author yamaguhci
 * @version 20080408
 */
public class LACSMReportRemoveAssertBean {

	private String	brakeKey0		= "";	// ブレークキー０

	private String	brakeKey1		= "";	// ブレークキー１

	private String	skkAmtNm		= "";	// 償却費総額名

	private String	skkTermNm		= "";	// 償却期間名

	private String	skkHohoNm		= "";	// 償却方法名

	private String	hyjyoKeiNo		= "";	// 表示用契約番号

	private String	bknNm			= "";	// 物件名

	private String	bknNo			= "";	// 物件番号

	private String	knshuYmd		= "";	// リース開始日

	private String	mryoYmd			= "";	// リース終了日

	private String	kaiYmd			= "";	// 中途解約日

	private String	ssnSriCd		= "";	// 資産種類コード

	private String	ssnSriNm		= "";	// 資産種類名

	private long	skkSougaku		= 0;	// 償却対象総額

	private long	ki				= 0;	// 経過

	private long	ruiSkkAmt		= 0;	// 償却累計額

	private long	zandSkkAmt		= 0;	// 解約・満了時簿価

	private String	skkKeijHohoKbn	= "";	// 償却計上方法区分

	private long	sou				= 0;	// 償却期間総

	private long	zankAmt			= 0;	// 残価保証額

	private String	leaseCompanyNm	= "";	// リース会社名

	private String	leaseUserNm		= "";	// リースユーザ名

	private String	brakeKey2		= "";	// ブレークキー２

	private String	acKijyunNm		= "";	// リース会計基準名

	/**
	 * 物件名を取得.
	 * 
	 * @return 物件名
	 */
	public String getBknNm() {
		return this.bknNm;
	}

	/**
	 * 物件名を設定.
	 * 
	 * @param piBknNm
	 *            物件名
	 */
	public void setBknNm(String piBknNm) {
		this.bknNm = piBknNm;
	}

	/**
	 * 物件番号を取得.
	 * 
	 * @return 物件番号
	 */
	public String getBknNo() {
		return this.bknNo;
	}

	/**
	 * 物件番号を設定.
	 * 
	 * @param piBknNo
	 *            物件番号
	 */
	public void setBknNo(String piBknNo) {
		this.bknNo = piBknNo;
	}

	/**
	 * ブレークキー０を取得.
	 * 
	 * @return ブレークキー０
	 */
	public String getBrakeKey0() {
		return this.brakeKey0;
	}

	/**
	 * ブレークキー０を設定.
	 * 
	 * @param piBrakeKey0
	 *            ブレークキー０
	 */
	public void setBrakeKey0(String piBrakeKey0) {
		this.brakeKey0 = piBrakeKey0;
	}

	/**
	 * ブレークキー１を取得.
	 * 
	 * @return ブレークキー１
	 */
	public String getBrakeKey1() {
		return this.brakeKey1;
	}

	/**
	 * ブレークキー１を設定.
	 * 
	 * @param piBrakeKey1
	 *            ブレークキー１
	 */
	public void setBrakeKey1(String piBrakeKey1) {
		this.brakeKey1 = piBrakeKey1;
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

	/**
	 * 中途解約日を取得.
	 * 
	 * @return 中途解約日
	 */
	public String getKaiYmd() {
		return this.kaiYmd;
	}

	/**
	 * 中途解約日を設定.
	 * 
	 * @param piKaiYmd
	 *            中途解約日
	 */
	public void setKaiYmd(String piKaiYmd) {
		this.kaiYmd = piKaiYmd;
	}

	/**
	 * 償却期間・経過を取得.
	 * 
	 * @return 償却期間・経過
	 */
	public long getKi() {
		return this.ki;
	}

	/**
	 * 償却期間・経過を設定.
	 * 
	 * @param piKi
	 *            償却期間・経過
	 */
	public void setKi(long piKi) {
		this.ki = piKi;
	}

	/**
	 * リース開始日を取得.
	 * 
	 * @return リース開始日
	 */
	public String getKnshuYmd() {
		return this.knshuYmd;
	}

	/**
	 * リース開始日を設定.
	 * 
	 * @param piKnshuYmd
	 *            リース開始日
	 */
	public void setKnshuYmd(String piKnshuYmd) {
		this.knshuYmd = piKnshuYmd;
	}

	/**
	 * リース終了日を取得.
	 * 
	 * @return mryoYmd
	 */
	public String getMryoYmd() {
		return this.mryoYmd;
	}

	/**
	 * リース終了日を設定.
	 * 
	 * @param piMryoYmd
	 *            リース終了日
	 */
	public void setMryoYmd(String piMryoYmd) {
		this.mryoYmd = piMryoYmd;
	}

	/**
	 * 償却累計額を取得.
	 * 
	 * @return 償却累計額
	 */
	public long getRuiSkkAmt() {
		return this.ruiSkkAmt;
	}

	/**
	 * 償却累計額を設定.
	 * 
	 * @param piRuiSkkAmt
	 *            償却累計額
	 */
	public void setRuiSkkAmt(long piRuiSkkAmt) {
		this.ruiSkkAmt = piRuiSkkAmt;
	}

	/**
	 * 償却費総額名を取得.
	 * 
	 * @return 償却費総額名
	 */
	public String getSkkAmtNm() {
		return this.skkAmtNm;
	}

	/**
	 * 償却費総額名を設定.
	 * 
	 * @param piSkkAmtNm
	 *            償却費総額名
	 */
	public void setSkkAmtNm(String piSkkAmtNm) {
		this.skkAmtNm = piSkkAmtNm;
	}

	/**
	 * 償却費計算方法名を取得.
	 * 
	 * @return 償却費計算方法名
	 */
	public String getSkkHohoNm() {
		return this.skkHohoNm;
	}

	/**
	 * 償却費計算方法名を設定.
	 * 
	 * @param piSkkHohoNm
	 *            償却費計算方法名
	 */
	public void setSkkHohoNm(String piSkkHohoNm) {
		this.skkHohoNm = piSkkHohoNm;
	}

	/**
	 * 償却計上方法区分を取得.
	 * 
	 * @return 償却計上方法区分
	 */
	public String getSkkKeijHohoKbn() {
		return this.skkKeijHohoKbn;
	}

	/**
	 * 償却計上方法区分を設定.
	 * 
	 * @param piSkkKeijHohoKbn
	 *            償却計上方法区分
	 */
	public void setSkkKeijHohoKbn(String piSkkKeijHohoKbn) {
		this.skkKeijHohoKbn = piSkkKeijHohoKbn;
	}

	/**
	 * 償却期間名を取得.
	 * 
	 * @return 償却期間名
	 */
	public String getSkkTermNm() {
		return this.skkTermNm;
	}

	/**
	 * 償却期間名を設定.
	 * 
	 * @param piSkkTermNm
	 *            償却期間名
	 */
	public void setSkkTermNm(String piSkkTermNm) {
		this.skkTermNm = piSkkTermNm;
	}

	/**
	 * 償却期間・総を取得.
	 * 
	 * @return 償却期間・総
	 */
	public long getSou() {
		return this.sou;
	}

	/**
	 * 償却期間・総を設定.
	 * 
	 * @param piSou
	 *            償却期間・総
	 */
	public void setSou(long piSou) {
		this.sou = piSou;
	}

	/**
	 * 資産種類コードを取得.
	 * 
	 * @return 資産種類コード
	 */
	public String getSsnSriCd() {
		return this.ssnSriCd;
	}

	/**
	 * 資産種類コードを設定.
	 * 
	 * @param piSsnSriCd
	 *            資産種類コード
	 */
	public void setSsnSriCd(String piSsnSriCd) {
		this.ssnSriCd = piSsnSriCd;
	}

	/**
	 * 資産種類コード名を取得.
	 * 
	 * @return 資産種類コード名
	 */
	public String getSsnSriNm() {
		return this.ssnSriNm;
	}

	/**
	 * 資産種類コード名を設定.
	 * 
	 * @param piSsnSriNm
	 *            資産種類コード名
	 */
	public void setSsnSriNm(String piSsnSriNm) {
		this.ssnSriNm = piSsnSriNm;
	}

	/**
	 * 解約/満了時簿価を取得.
	 * 
	 * @return 解約/満了時簿価
	 */
	public long getZandSkkAmt() {
		return this.zandSkkAmt;
	}

	/**
	 * 解約/満了時簿価を設定.
	 * 
	 * @param piZandSkkAmt
	 *            解約/満了時簿価
	 */
	public void setZandSkkAmt(long piZandSkkAmt) {
		this.zandSkkAmt = piZandSkkAmt;
	}

	/**
	 * 残価保証額を取得.
	 * 
	 * @return 残価保証額
	 */
	public long getZankAmt() {
		return this.zankAmt;
	}

	/**
	 * 残価保証額を設定.
	 * 
	 * @param piZankAmt
	 *            残価保証額
	 */
	public void setZankAmt(long piZankAmt) {
		this.zankAmt = piZankAmt;
	}

	/**
	 * 償却対象総額を取得.
	 * 
	 * @return 償却対象総額
	 */
	public long getSkkSougaku() {
		return this.skkSougaku;
	}

	/**
	 * 償却対象総額を設定.
	 * 
	 * @param piSkkSougaku
	 *            償却対象総額
	 */
	public void setSkkSougaku(long piSkkSougaku) {
		this.skkSougaku = piSkkSougaku;
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
	 * リース会社名を設定.
	 * 
	 * @param piLeaseCompanyNm
	 *            リース会社名
	 */
	public void setLeaseCompanyNm(String piLeaseCompanyNm) {
		this.leaseCompanyNm = piLeaseCompanyNm;
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
	 * リースユーザ名を取得.
	 * 
	 * @return リースユーザ名
	 */
	public String getLeaseUserNm() {
		return this.leaseUserNm;
	}

	/**
	 * ブレークキー２を取得.
	 * 
	 * @return ブレークキー２
	 */
	public String getBrakeKey2() {
		return this.brakeKey2;
	}

	/**
	 * ブレークキー２を設定.
	 * 
	 * @param piBrakeKey2
	 *            ブレークキー２
	 */
	public void setBrakeKey2(String piBrakeKey2) {
		this.brakeKey2 = piBrakeKey2;
	}

	/**
	 * リース会計基準名を取得.
	 * 
	 * @return リース会計基準名
	 */
	public String getAcKijyunNm() {
		return this.acKijyunNm;
	}

	/**
	 * リース会計基準名を設定.
	 * 
	 * @param piAcKijyunNm
	 *            リース会計基準名
	 */
	public void setAcKijyunNm(String piAcKijyunNm) {
		this.acKijyunNm = piAcKijyunNm;
	}

}
