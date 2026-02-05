package jp.co.pro_app.lacs.affairs.ukebarai.bean;

/**
 * 費用受払明細表 Bean.
 * 
 * @author active
 * @version 20080814
 */
public class LACSUkebaraiHiyoBean {

	private String	brakeKey1			= "";	// ブレイクキー１

	private String	brakeKey2			= "";	// ブレイクキー２

	private String	brakeKey3			= "";	// ブレイクキー３

	private String	brakeKey4			= "";	// ブレイクキー４

	private String	brakeKey5			= "";	// ブレイクキー５

	private String	createDate			= "";	// 作成日

	private String	kikanStart			= "";	// 対象期間開始

	private String	kikanEnd			= "";	// 対象期間終了

	private String	lcNm				= "";	// リース会社

	private String	luNm				= "";	// 開示先

	private String	kamokuNm			= "";	// 科目名

	private String	trdHnteiKekaNm		= "";	// リース取引分類

	private String	taishoAcKijyunNm	= "";	// リース会計基準

	private String	acShrNm				= "";	// 会計処理方法

	private String	keiNo				= "";	// 契約番号

	private String	bknNo				= "";	// 物件番号

	private String	bknNm				= "";	// 物件名称

	private String	knshuYmd			= "";	// リース開始日

	private String	mryoYmd				= "";	// リース終了日

	private String	kaiYmd				= "";	// 中途解約日

	private long	sougakuAmt			= 0;	// 総額

	private long	zenkiMatuAmt		= 0;	// 前期末累計額

	private long	toukiAmt			= 0;	// 当期計上高

	private long	toukiGenAmt			= 0;	// 当期減少

	private long	toukiMatuAmt		= 0;	// 当期末累計額

	/**
	 * ブレイクキー１を取得.
	 * 
	 * @return ブレイクキー１
	 */
	public String getBrakeKey1() {
		return this.brakeKey1;
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
	 * ブレイクキー３を取得.
	 * 
	 * @return ブレイクキー３
	 */
	public String getBrakeKey3() {
		return this.brakeKey3;
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
	 * ブレイクキー５を取得.
	 * 
	 * @return ブレイクキー５
	 */
	public String getBrakeKey5() {
		return this.brakeKey5;
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
	 * 対象期間開始を取得.
	 * 
	 * @return 対象期間開始
	 */
	public String getkikanStart() {
		return this.kikanStart;
	}

	/**
	 * 対象期間終了を取得.
	 * 
	 * @return 対象期間終了
	 */
	public String getkikanEnd() {
		return this.kikanEnd;
	}

	/**
	 * リース会社名称を取得.
	 * 
	 * @return リース会社名称
	 */
	public String getLcNm() {
		return this.lcNm;
	}

	/**
	 * 開示先を取得.
	 * 
	 * @return 開示先
	 */
	public String getLuNm() {
		return this.luNm;
	}

	/**
	 * 科目名を取得.
	 * 
	 * @return 科目名
	 */
	public String getKamokuNm() {
		return this.kamokuNm;
	}

	/**
	 * リース会計基準を取得.
	 * 
	 * @return リース会計基準
	 */
	public String getTaishoAcKijyunNm() {
		return this.taishoAcKijyunNm;
	}

	/**
	 * 会計処理方法を取得.
	 * 
	 * @return 会計処理方法
	 */
	public String getAcShrNm() {
		return this.acShrNm;
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
	 * 物件番号を取得.
	 * 
	 * @return 物件番号
	 */
	public String getBknNo() {
		return this.bknNo;
	}

	/**
	 * 物件名称を取得.
	 * 
	 * @return 物件名称
	 */
	public String getBknNm() {
		return this.bknNm;
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
	 * リース終了日を取得.
	 * 
	 * @return リース終了日
	 */
	public String getMryoYmd() {
		return this.mryoYmd;
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
	 * リース取引分類を取得.
	 * 
	 * @return リース取引分類
	 */
	public String getTrdHnteiKekaNm() {
		return this.trdHnteiKekaNm;
	}

	/**
	 * 総額を取得.
	 * 
	 * @return 総額
	 */
	public long getSougakuAmt() {
		return this.sougakuAmt;
	}

	/**
	 * 前期末累計額を取得.
	 * 
	 * @return 前期末累計額
	 */
	public long getZenkiMatuAmt() {
		return this.zenkiMatuAmt;
	}

	/**
	 * 当期計上高を取得.
	 * 
	 * @return 当期計上高
	 */
	public long getToukiAmt() {
		return this.toukiAmt;
	}

	/**
	 * 当期減少を取得.
	 * 
	 * @return 当期減少
	 */
	public long getToukiGenAmt() {
		return this.toukiGenAmt;
	}

	/**
	 * 当期末累計額を取得.
	 * 
	 * @return 当期末累計額
	 */
	public long getToukiMatuAmt() {
		return this.toukiMatuAmt;
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
	 * ブレイクキー２を設定.
	 * 
	 * @param piBrakeKey2
	 *            ブレイクキー２
	 */
	public void setBrakeKey2(String piBrakeKey2) {
		this.brakeKey2 = piBrakeKey2;
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
	 * ブレイクキー４を設定.
	 * 
	 * @param piBrakeKey4
	 *            ブレイクキー４
	 */
	public void setBrakeKey4(String piBrakeKey4) {
		this.brakeKey4 = piBrakeKey4;
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
	 * 対象期間開始を設定.
	 * 
	 * @param piKikanStart
	 *            対象期間開始
	 */
	public void setKikanStart(String piKikanStart) {
		this.kikanStart = piKikanStart;
	}

	/**
	 * 対象期間終了を設定.
	 * 
	 * @param piKikanEnd
	 *            対象期間終了
	 */
	public void setKikanEnd(String piKikanEnd) {
		this.kikanEnd = piKikanEnd;
	}

	/**
	 * リース会社名称を設定.
	 * 
	 * @param piLcNm
	 *            リース会社名称
	 */
	public void setLcNm(String piLcNm) {
		this.lcNm = piLcNm;
	}

	/**
	 * 開示先を設定.
	 * 
	 * @param piLuNm
	 *            開示先
	 */
	public void setLuNm(String piLuNm) {
		this.luNm = piLuNm;
	}

	/**
	 * 科目名を設定.
	 * 
	 * @param piKamokuNm
	 *            科目名
	 */
	public void setKamokuNm(String piKamokuNm) {
		this.kamokuNm = piKamokuNm;
	}

	/**
	 * リース会計基準を設定.
	 * 
	 * @param piTaishoAcKijyunNm
	 *            リース会計基準
	 */
	public void setTaishoAcKijyunNm(String piTaishoAcKijyunNm) {
		this.taishoAcKijyunNm = piTaishoAcKijyunNm;
	}

	/**
	 * 会計処理方法ヘッダを設定.
	 * 
	 * @param piAcShrNm
	 *            会計処理方法
	 */
	public void setAcShrNm(String piAcShrNm) {
		this.acShrNm = piAcShrNm;
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
	 * 物件番号を設定.
	 * 
	 * @param piBknNo
	 *            物件番号
	 */
	public void setBknNo(String piBknNo) {
		this.bknNo = piBknNo;
	}

	/**
	 * 物件名称を設定.
	 * 
	 * @param piBknNm
	 *            物件名称
	 */
	public void setBknNm(String piBknNm) {
		this.bknNm = piBknNm;
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
	 * リース終了日を設定.
	 * 
	 * @param piMryoYmd
	 *            リース終了日
	 */
	public void setMryoYmd(String piMryoYmd) {
		this.mryoYmd = piMryoYmd;
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
	 * リース取引分類を設定.
	 * 
	 * @param piTrdHnteiKekaNm
	 *            リース取引分類
	 */
	public void setTrdHnteiKekaNm(String piTrdHnteiKekaNm) {
		this.trdHnteiKekaNm = piTrdHnteiKekaNm;
	}

	/**
	 * 総額を設定.
	 * 
	 * @param piSougakuAmt
	 *            総額
	 */
	public void setSougakuAmt(long piSougakuAmt) {
		this.sougakuAmt = piSougakuAmt;
	}

	/**
	 * 前期末累計額を設定.
	 * 
	 * @param piZenkiMatuAmt
	 *            前期末累計額
	 */
	public void setZenkiMatuAmt(long piZenkiMatuAmt) {
		this.zenkiMatuAmt = piZenkiMatuAmt;
	}

	/**
	 * 当期計上高を設定.
	 * 
	 * @param piToukiAmt
	 *            当期計上高
	 */
	public void setToukiAmt(long piToukiAmt) {
		this.toukiAmt = piToukiAmt;
	}

	/**
	 * 当期減少を設定.
	 * 
	 * @param piToukiGenAmt
	 *            当期減少
	 */
	public void setToukiGenAmt(long piToukiGenAmt) {
		this.toukiGenAmt = piToukiGenAmt;
	}

	/**
	 * 当期末累計額を設定.
	 * 
	 * @param piToukiMatuAmt
	 *            当期末累計額
	 */
	public void setToukiMatuAmt(long piToukiMatuAmt) {
		this.toukiMatuAmt = piToukiMatuAmt;
	}
}
