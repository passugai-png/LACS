package jp.co.pro_app.lacs.affairs.monthreport.bean;

/**
 * 月次帳票出力：消費税明細票 Bean.
 * 
 * @author yokota
 * @version 20081030
 */
public class LACSMReportSyouhizeiBean {

	private String	createDate				= "";	// 作成日

	private String	termFrom				= "";	// 対象期間From

	private String	termTo					= "";	// 対象期間To

	private String	leaseUserNm				= "";	// リースユーザ名

	private String	leaseCompany			= "";	// リース会社名

	private String	brakeKey0				= "";	// ブレイクキー0

	private String	brakeKey1				= "";	// ブレイクキー1

	private String	brakeKey2				= "";	// ブレイクキー2

	private String	brakeKey3				= "";	// ブレイクキー3

	private String	brakeKey4				= "";	// ブレイクキー4

	private String	cosmosCd				= "";	// COSMOSコード

	private String	keiyakuNo				= "";	// 契約番号

	private String	hyoujiYouKeiyakuNo		= "";	// 表示用契約番号

	private String	acKijyunName			= "";	// 会計基準名

	private String	acKijyunCd				= "";	// 会計基準コード

	private String	acShrKbnName			= "";	// 会計処理方法

	private String	staxIktKojKbnName		= "";	// 控除区分方法

	private String	leaseBunrui				= "";	// リース取引分類

	private String	leaseFrom				= "";	// リース開始日

	private String	leaseTo					= "";	// リース終了日

	private String	leaseTerm				= "";	// リース期間

	private String	bukenNo					= "";	// 物件番号

	private String	bukenNm					= "";	// 物件名

	private String	kaiyakuYmd				= "";	// 中途解約日

	private long	leaseSougaku			= 0;	// リース料総額

	private long	zankHoshoAmt			= 0;	// うち保証残価

	private long	syouhizeiSougaku		= 0;	// 消費税総額

	private long	toukSiharaiLeaseRyou	= 0;	// 当期支払リース料

	private long	toukKariSyouhizeigaku	= 0;	// 当期仮払消費税額

	private long	kariSyouhizeiRuikei		= 0;	// 仮払消費税累計

	private long	mibaraiSyouhizeiZan		= 0;	// 未払消費税残高

	private long	mibaraiSyouhizeiZan1Nai	= 0;	// 未払消費税残高（内１年内）

	private long	mibaraiSyouhizeiZan1Cyo	= 0;	// 未払消費税残高（内１年超）

	/**
	 * 作成日を取得.
	 * 
	 * @return 作成日
	 */
	public String getCreateDate() {
		return this.createDate;
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
	 * ブレイクキー０を設定.
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
	 * @return ブレイクキー1
	 */
	public String getBrakeKey1() {
		return this.brakeKey1;
	}

	/**
	 * ブレイクキー1を設定.
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
	 * @return ブレイクキー2
	 */
	public String getBrakeKey2() {
		return this.brakeKey2;
	}

	/**
	 * ブレイクキー2を設定.
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
	 * @return ブレイクキー3
	 */
	public String getBrakeKey3() {
		return this.brakeKey3;
	}

	/**
	 * ブレイクキー3を設定.
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
	 * @return ブレイクキー4
	 */
	public String getBrakeKey4() {
		return this.brakeKey4;
	}

	/**
	 * ブレイクキー4を設定.
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
	 * @return リースユーザ名
	 */
	public String getLeasUserNm() {
		return this.leaseUserNm;
	}

	/**
	 * リースユーザ名を設定.
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
	 * @return リース会社名
	 */
	public String getLeaseCompany() {
		return this.leaseCompany;
	}

	/**
	 * リース会社名を設定.
	 * 
	 * @param piLeasCompany
	 *            リース会社名
	 */
	public void setLeaseCompany(String piLeasCompany) {
		this.leaseCompany = piLeasCompany;
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
	 * COSMOSCDを設定.
	 * 
	 * @param piCosmosCd
	 *            COSMOSCD
	 */
	public void setCosmosCd(String piCosmosCd) {
		this.cosmosCd = piCosmosCd;
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
	 * 会計基準名を設定.
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
	 * @return 会計基準コード
	 */
	public String getAcKijyunCd() {
		return this.acKijyunCd;
	}

	/**
	 * 会計基準コードを設定.
	 * 
	 * @param piAcKijyunCd
	 *            会計基準コード
	 */
	public void setAcKijyunCd(String piAcKijyunCd) {
		this.acKijyunCd = piAcKijyunCd;
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
	 * 消費税控除方法を取得.
	 * 
	 * @return 消費税控除方法
	 */
	public String getStaxIktKbnName() {
		return this.staxIktKojKbnName;
	}

	/**
	 * 消費税控除方法を設定.
	 * 
	 * @param piStaxIktKbnName
	 *            消費税控除方法
	 */
	public void setStaxIktKbnName(String piStaxIktKbnName) {
		this.staxIktKojKbnName = piStaxIktKbnName;
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
	 * 表示用契約番号を取得.
	 * 
	 * @return 表示用契約番号
	 */
	public String getHyoujiYouKeiyakuNo() {
		return this.hyoujiYouKeiyakuNo;
	}

	/**
	 * 表示用契約番号を設定.
	 * 
	 * @param piHyoujiYouKeiyakuNo
	 *            表示用契約番号
	 */
	public void setHyoujiYouKeiyakuNo(String piHyoujiYouKeiyakuNo) {
		this.hyoujiYouKeiyakuNo = piHyoujiYouKeiyakuNo;
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
	 * 物件名を設定.
	 * 
	 * @param piBukenNm
	 *            物件名
	 */
	public void setBukenNm(String piBukenNm) {
		this.bukenNm = piBukenNm;
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
	 * うち保証残価を取得.
	 * 
	 * @return うち保証残価
	 */
	public long getZankHoshoAmt() {
		return this.zankHoshoAmt;
	}

	/**
	 * うち保証残価を設定.
	 * 
	 * @param piZankHoshoAmt
	 *            うち保証残価
	 */
	public void setZankHoshoAmt(long piZankHoshoAmt) {
		this.zankHoshoAmt = piZankHoshoAmt;
	}

	/**
	 * 消費税総額を取得.
	 * 
	 * @return 消費税総額
	 */
	public long getSyouhizeiSougaku() {
		return this.syouhizeiSougaku;
	}

	/**
	 * 消費税総額を設定.
	 * 
	 * @param piSyouhizeiSougaku
	 *            消費税総額
	 */
	public void setSyouhizeiSougaku(long piSyouhizeiSougaku) {
		this.syouhizeiSougaku = piSyouhizeiSougaku;
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
	 * 当期仮払消費税額を取得.
	 * 
	 * @return 当期仮払消費税額
	 */
	public long getToukKariSyouhizeigaku() {
		return this.toukKariSyouhizeigaku;
	}

	/**
	 * 当期仮払消費税額を設定.
	 * 
	 * @param piToukKariSyouhizeigaku
	 *            当期仮払消費税額
	 */
	public void setToukKariSyouhizeigaku(long piToukKariSyouhizeigaku) {
		this.toukKariSyouhizeigaku = piToukKariSyouhizeigaku;
	}

	/**
	 * 仮払消費税累計を取得.
	 * 
	 * @return 仮払消費税累計
	 */
	public long getKariSyouhizeiRuikei() {
		return this.kariSyouhizeiRuikei;
	}

	/**
	 * 仮払消費税累計を設定.
	 * 
	 * @param piKariSyouhizeiRuikei
	 *            仮払消費税累計
	 */
	public void setKariSyouhizeiRuikei(long piKariSyouhizeiRuikei) {
		this.kariSyouhizeiRuikei = piKariSyouhizeiRuikei;
	}

	/**
	 * 未払消費税残高を取得.
	 * 
	 * @return 未払消費税残高
	 */
	public long getMibaraiSyouhizeiZan() {
		return this.mibaraiSyouhizeiZan;
	}

	/**
	 * 未払消費税残高を設定.
	 * 
	 * @param piMibaraiSyouhizeiZan
	 *            未払消費税残高
	 */
	public void setMibaraiSyouhizeiZan(long piMibaraiSyouhizeiZan) {
		this.mibaraiSyouhizeiZan = piMibaraiSyouhizeiZan;
	}

	/**
	 * 未払消費税残高（１年内）を取得.
	 * 
	 * @return 未払消費税残高（１年内）
	 */
	public long getMibaraiSyouhizeiZan1Nai() {
		return this.mibaraiSyouhizeiZan1Nai;
	}

	/**
	 * 未払消費税残高（１年内）を設定.
	 * 
	 * @param piMibaraiSyouhizeiZan1Nai
	 *            未払消費税残高（１年内）
	 */
	public void setMibaraiSyouhizeiZan1Nai(long piMibaraiSyouhizeiZan1Nai) {
		this.mibaraiSyouhizeiZan1Nai = piMibaraiSyouhizeiZan1Nai;
	}

	/**
	 * 未払消費税残高（１年超）を取得.
	 * 
	 * @return 未払消費税残高（１年超）
	 */
	public long getMibaraiSyouhizeiZan1Cyo() {
		return this.mibaraiSyouhizeiZan1Cyo;
	}

	/**
	 * 未払消費税残高（１年超）を設定.
	 * 
	 * @param piMibaraiSyouhizeiZan1Cyo
	 *            未払消費税残高（１年超）
	 */
	public void setMibaraiSyouhizeiZan1Cyo(long piMibaraiSyouhizeiZan1Cyo) {
		this.mibaraiSyouhizeiZan1Cyo = piMibaraiSyouhizeiZan1Cyo;
	}

}
