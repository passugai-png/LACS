package jp.co.pro_app.lacs.affairs.ukebarai.bean;

/**
 * リース料受払明細表 Bean.
 * 
 * @author active
 * @version 20080814
 */
public class LACSUkebaraiLeaseBean {

	private String	brakeKey0					= "";	// ブレイクキー０

	private String	brakeKey1					= "";	// ブレイクキー１

	private String	brakeKey2					= "";	// ブレイクキー２

	private String	brakeKey3					= "";	// ブレイクキー３

	private String	brakeKey4					= "";	// ブレイクキー４

	private String	brakeKey5					= "";	// ブレイクキー５

	private String	createDate					= "";	// 作成日

	private String	kikanStart					= "";	// 対象期間開始

	private String	kikanEnd					= "";	// 対象期間終了

	private String	lcNm						= "";	// リース会社

	private String	luNm						= "";	// 開示先

	private String	taishoAcKijyunNm			= "";	// リース会計基準

	private String	acShrNm						= "";	// 会計処理方法

	private String	trdHnteiKekaNm				= "";	// リース取引分類

	private String	sisanKbn					= "";	// 資産区分

	private String	keiNo						= "";	// 契約番号

	private String	bknNo						= "";	// 物件番号

	private String	bknNm						= "";	// 物件名称

	private String	knshuYmd					= "";	// リース開始日

	private String	mryoYmd						= "";	// リース終了日

	private String	kaiYmd						= "";	// 中途解約日

	private long	leasAmtSougaku				= 0;	// リース料総額

	private long	zankaHosyoAmt				= 0;	// 残価保証額

	private long	saimuSougaku				= 0;	// リース債務総額

	private long	saimuZenkimatuAmt			= 0;	// リース債務前期末

	private long	saimuToukiZoukaAmt			= 0;	// リース債務当期増加

	private long	saimuToukiJitugenAmt		= 0;	// リース債務当期実現

	private long	saimuToukiGensyoAmt			= 0;	// リース債務当期減少

	private long	saimuToukimatuAmt			= 0;	// リース債務当期末

	private long	rskSougaku					= 0;	// 利息総額

	private long	rskZenkimatuAmt				= 0;	// 利息前期末

	private long	rskToukiJitugenAmt			= 0;	// 利息当期実現

	private long	rskToukiGensyoAmt			= 0;	// 利息 当期減少

	private long	rskToukimatuAmt				= 0;	// 利息当期末

	private long	ijiSougaku					= 0;	// 維持管理費総額

	private long	ijiZenkimatuAmt				= 0;	// 維持管理費前期末

	private long	ijiToukiJitugenAmt			= 0;	// 維持管理費当期実現

	private long	ijiToukiGensyoAmt			= 0;	// 維持管理費 当期減少

	private long	ijiToukimatuAmt				= 0;	// 維持管理費当期末

	private long	ekmSougaku					= 0;	// 役務提供費総額

	private long	ekmZenkimatuAmt				= 0;	// 役務提供費前期末

	private long	ekmToukiJitugenAmt			= 0;	// 役務提供費当期実現

	private long	ekmToukiGensyoAmt			= 0;	// 役務提供費 当期減少

	private long	ekmToukimatuAmt				= 0;	// 役務提供費当期末

	private long	leasAmtRuiSougaku			= 0;	// リース料累計 総額

	private long	leasAmtRuiZenkimatuAmt		= 0;	// リース料累計 前期末

	private long	leasAmtRuiToukiJitugenAmt	= 0;	// リース料累計 当期実現

	private long	leasAmtRuiToukiGensyoAmt	= 0;	// リース料累計 当期減少

	private long	leasAmtRuiToukimatuAmt		= 0;	// リース料累計 当期末

	private long	mibaraiSougaku				= 0;	// 未払金(消費税)総額

	private long	mibaraiZenkimatuAmt			= 0;	// 未払金(消費税)前期末

	private long	mibaraiToukiZoukaAmt		= 0;	// 未払金(消費税)当期増加

	private long	mibaraiToukiJitugenAmt		= 0;	// 未払金(消費税)当期実現

	private long	mibaraiToukiGensyoAmt		= 0;	// 未払金(消費税)当期減少

	private long	mibaraiToukimatuAmt			= 0;	// 未払金(消費税)当期末

	// 2020/05/22 ADD START
	private String	brakeKey1_0					= "";	// ブレイクキー１_0

	private String	jysiUm					    = "";	// 重要性有無
	
	private long	zankSougaku					= 0;	// 残価保証額総額

	private long	zankZenkimatuAmt			= 0;	// 残価保証額前期末

	private long	zankToukiZoukaAmt			= 0;	// 残価保証額当期増加

	private long	zankToukiJitugenAmt			= 0;	// 残価保証額当期実現

	private long	zankToukiGensyoAmt			= 0;	// 残価保証額当期減少

	private long	zankToukimatuAmt			= 0;	// 残価保証額当期末
	// 2020/05/22 ADD END
	/**
	 * ブレイクキー０を取得.
	 * 
	 * @return ブレイクキー０
	 */
	public String getBrakeKey0() {
		return this.brakeKey0;
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
	 * リース取引分類を取得.
	 * 
	 * @return リース取引分類
	 */
	public String getTrdHnteiKekaNm() {
		return this.trdHnteiKekaNm;
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
	 * リース料総額を取得.
	 * 
	 * @return リース料総額
	 */
	public long getLeasAmtSougaku() {
		return this.leasAmtSougaku;
	}

	/**
	 * 残価保証額を取得.
	 * 
	 * @return 残価保証額
	 */
	public long getZankaHosyoAmt() {
		return this.zankaHosyoAmt;
	}

	/**
	 * リース債務総額を取得.
	 * 
	 * @return リース債務総額
	 */
	public long getSaimuSougaku() {
		return this.saimuSougaku;
	}

	/**
	 * リース債務前期末を取得.
	 * 
	 * @return リース債務前期末
	 */
	public long getSaimuZenkimatuAmt() {
		return this.saimuZenkimatuAmt;
	}

	/**
	 * リース債務当期増加を取得.
	 * 
	 * @return リース債務当期増加
	 */
	public long getSaimuToukiZoukaAmt() {
		return this.saimuToukiZoukaAmt;
	}

	/**
	 * リース債務当期実現を取得.
	 * 
	 * @return リース債務当期実現
	 */
	public long getSaimuToukiJitugenAmt() {
		return this.saimuToukiJitugenAmt;
	}

	/**
	 * リース債務当期減少を取得.
	 * 
	 * @return リース債務当期減少
	 */
	public long getSaimuToukiGensyoAmt() {
		return this.saimuToukiGensyoAmt;
	}

	/**
	 * リース債務当期末を取得.
	 * 
	 * @return リース債務当期末
	 */
	public long getSaimuToukimatuAmt() {
		return this.saimuToukimatuAmt;
	}

	/**
	 * 利息総額を取得.
	 * 
	 * @return 利息総額
	 */
	public long getRskSougaku() {
		return this.rskSougaku;
	}

	/**
	 * 利息前期末を取得.
	 * 
	 * @return 利息前期末
	 */
	public long getRskZenkimatuAmt() {
		return this.rskZenkimatuAmt;
	}

	/**
	 * 利息当期実現を取得.
	 * 
	 * @return 利息当期実現
	 */
	public long getRskToukiJitugenAmt() {
		return this.rskToukiJitugenAmt;
	}

	/**
	 * 利息当期減少を取得.
	 * 
	 * @return 利息当期減少
	 */
	public long getRskToukiGensyoAmt() {
		return this.rskToukiGensyoAmt;
	}

	/**
	 * 利息当期末を取得.
	 * 
	 * @return 利息当期末
	 */
	public long getRskToukimatuAmt() {
		return this.rskToukimatuAmt;
	}

	/**
	 * 維持管理費総額を取得.
	 * 
	 * @return 維持管理費総額
	 */
	public long getIjiSougaku() {
		return this.ijiSougaku;
	}

	/**
	 * 維持管理費前期末を取得.
	 * 
	 * @return 維持管理費前期末
	 */
	public long getIjiZenkimatuAmt() {
		return this.ijiZenkimatuAmt;
	}

	/**
	 * 維持管理費当期実現を取得.
	 * 
	 * @return 維持管理費当期実現
	 */
	public long getIjiToukiJitugenAmt() {
		return this.ijiToukiJitugenAmt;
	}

	/**
	 * 維持管理費当期減少を取得.
	 * 
	 * @return 維持管理費当期減少
	 */
	public long getIjiToukiGensyoAmt() {
		return this.ijiToukiGensyoAmt;
	}

	/**
	 * 維持管理費当期末を取得.
	 * 
	 * @return 維持管理費当期末
	 */
	public long getIjiToukimatuAmt() {
		return this.ijiToukimatuAmt;
	}

	/**
	 * 役務提供費総額を取得.
	 * 
	 * @return 役務提供費総額
	 */
	public long getEkmSougaku() {
		return this.ekmSougaku;
	}

	/**
	 * 役務提供費前期末を取得.
	 * 
	 * @return 役務提供費前期末
	 */
	public long getEkmZenkimatuAmt() {
		return this.ekmZenkimatuAmt;
	}

	/**
	 * 役務提供費当期実現を取得.
	 * 
	 * @return 役務提供費当期実現
	 */
	public long getEkmToukiJitugenAmt() {
		return this.ekmToukiJitugenAmt;
	}

	/**
	 * 役務提供費当期減少を取得.
	 * 
	 * @return 役務提供費当期減少
	 */
	public long getEkmToukiGensyoAmt() {
		return this.ekmToukiGensyoAmt;
	}

	/**
	 * 役務提供費当期末を取得.
	 * 
	 * @return 役務提供費当期末
	 */
	public long getEkmToukimatuAmt() {
		return this.ekmToukimatuAmt;
	}

	/**
	 * リース料累計総額を取得.
	 * 
	 * @return リース料累計総額
	 */
	public long getLeasAmtRuiSougaku() {
		return this.leasAmtRuiSougaku;
	}

	/**
	 * リース料累計 前期末を取得.
	 * 
	 * @return リース料累計 前期末
	 */
	public long getLeasAmtRuiZenkimatuAmt() {
		return this.leasAmtRuiZenkimatuAmt;
	}

	/**
	 * リース料累計 当期実現を取得.
	 * 
	 * @return リース料累計 当期実現
	 */
	public long getLeasAmtRuiToukiJitugenAmt() {
		return this.leasAmtRuiToukiJitugenAmt;
	}

	/**
	 * リース料累計 当期減少を取得.
	 * 
	 * @return リース料累計 当期減少
	 */
	public long getLeasAmtRuiToukiGensyoAmt() {
		return this.leasAmtRuiToukiGensyoAmt;
	}

	/**
	 * リース料累計 当期末を取得.
	 * 
	 * @return リース料累計 当期末
	 */
	public long getLeasAmtRuiToukimatuAmt() {
		return this.leasAmtRuiToukimatuAmt;
	}

	/**
	 * 未払金(消費税)総額を取得.
	 * 
	 * @return 未払金(消費税)総額
	 */
	public long getMibaraiSougaku() {
		return this.mibaraiSougaku;
	}

	/**
	 * 未払金(消費税)前期末を取得.
	 * 
	 * @return 未払金(消費税)前期末
	 */
	public long getMibaraiZenkimatuAmt() {
		return this.mibaraiZenkimatuAmt;
	}

	/**
	 * 未払金(消費税)当期増加を取得.
	 * 
	 * @return 未払金(消費税)当期増加
	 */
	public long getMibaraiToukiZoukaAmt() {
		return this.mibaraiToukiZoukaAmt;
	}

	/**
	 * 未払金(消費税)当期実現を取得.
	 * 
	 * @return 未払金(消費税)当期実現
	 */
	public long getMibaraiToukiJitugenAmt() {
		return this.mibaraiToukiJitugenAmt;
	}

	/**
	 * 未払金(消費税)当期減少を取得.
	 * 
	 * @return 未払金(消費税)当期減少
	 */
	public long getMibaraiToukiGensyoAmt() {
		return this.mibaraiToukiGensyoAmt;
	}

	/**
	 * 未払金(消費税)当期末を取得.
	 * 
	 * @return 未払金(消費税)当期末
	 */
	public long getMibaraiToukimatuAmt() {
		return this.mibaraiToukimatuAmt;
	}

	// 2020/05/22 ADD START
	/**
	 * ブレイクキー１_0を取得.
	 * 
	 * @return ブレイクキー１_0
	 */
	public String getBrakeKey1_0() {
		return this.brakeKey1_0;
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
	 * 残価保証額総額を取得.
	 * 
	 * @return 残価保証額総額
	 */
	public long getZankSougaku() {
		return this.zankSougaku;
	}

	/**
	 * 残価保証額前期末を取得.
	 * 
	 * @return 残価保証額前期末
	 */
	public long getZankZenkimatuAmt() {
		return this.zankZenkimatuAmt;
	}

	/**
	 * 残価保証額当期増加を取得.
	 * 
	 * @return 残価保証額当期増加
	 */
	public long getZankToukiZoukaAmt() {
		return this.zankToukiZoukaAmt;
	}

	/**
	 * 残価保証額当期実現を取得.
	 * 
	 * @return 残価保証額当期実現
	 */
	public long getZankToukiJitugenAmt() {
		return this.zankToukiJitugenAmt;
	}

	/**
	 * 残価保証額当期減少を取得.
	 * 
	 * @return 残価保証額当期減少
	 */
	public long getZankToukiGensyoAmt() {
		return this.zankToukiGensyoAmt;
	}

	/**
	 * 残価保証額当期末を取得.
	 * 
	 * @return 残価保証額当期末
	 */
	public long getZankToukimatuAmt() {
		return this.zankToukimatuAmt;
	}
	// 2020/05/22 ADD END

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
	 * リース会計基準を設定.
	 * 
	 * @param piTaishoAcKijyunNm
	 *            リース会計基準
	 */
	public void setTaishoAcKijyunNm(String piTaishoAcKijyunNm) {
		this.taishoAcKijyunNm = piTaishoAcKijyunNm;
	}

	/**
	 * 会計処理方法を設定.
	 * 
	 * @param piAcShrNm
	 *            会計処理方法
	 */
	public void setAcShrNm(String piAcShrNm) {
		this.acShrNm = piAcShrNm;
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
	 * 資産区分を設定.
	 * 
	 * @param piSisanKbn
	 *            資産区分
	 */
	public void setSisanKbn(String piSisanKbn) {
		this.sisanKbn = piSisanKbn;
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
	 * リース料総額を設定.
	 * 
	 * @param piLeasAmtSougaku
	 *            リース料総額
	 */
	public void setLeasAmtSougaku(long piLeasAmtSougaku) {
		this.leasAmtSougaku = piLeasAmtSougaku;
	}

	/**
	 * 残価保証額を設定.
	 * 
	 * @param piZankaHosyoAmt
	 *            残価保証額
	 */
	public void setZankaHosyoAmt(long piZankaHosyoAmt) {
		this.zankaHosyoAmt = piZankaHosyoAmt;
	}

	/**
	 * リース債務総額を設定.
	 * 
	 * @param piSaimuSougaku
	 *            リース債務総額
	 */
	public void setSaimuSougaku(long piSaimuSougaku) {
		this.saimuSougaku = piSaimuSougaku;
	}

	/**
	 * リース債務前期末を設定.
	 * 
	 * @param piSaimuZenkimatuAmt
	 *            リース債務前期末
	 */
	public void setSaimuZenkimatuAmt(long piSaimuZenkimatuAmt) {
		this.saimuZenkimatuAmt = piSaimuZenkimatuAmt;
	}

	/**
	 * リース債務当期増加を設定.
	 * 
	 * @param piSaimuToukiZoukaAmt
	 *            リース債務当期増加
	 */
	public void setSaimuToukiZoukaAmt(long piSaimuToukiZoukaAmt) {
		this.saimuToukiZoukaAmt = piSaimuToukiZoukaAmt;
	}

	/**
	 * リース債務当期実現を設定.
	 * 
	 * @param piSaimuToukiJitugenAmt
	 *            リース債務当期実現
	 */
	public void setSaimuToukiJitugenAmt(long piSaimuToukiJitugenAmt) {
		this.saimuToukiJitugenAmt = piSaimuToukiJitugenAmt;
	}

	/**
	 * リース債務当期減少を設定.
	 * 
	 * @param piSaimuToukiGensyoAmt
	 *            リース債務当期減少
	 */
	public void setSaimuToukiGensyoAmt(long piSaimuToukiGensyoAmt) {
		this.saimuToukiGensyoAmt = piSaimuToukiGensyoAmt;
	}

	/**
	 * リース債務当期末を設定.
	 * 
	 * @param piSaimuToukimatuAmt
	 *            リース債務当期末
	 */
	public void setSaimuToukimatuAmt(long piSaimuToukimatuAmt) {
		this.saimuToukimatuAmt = piSaimuToukimatuAmt;
	}

	/**
	 * 利息総額を設定.
	 * 
	 * @param piRskSougaku
	 *            利息総額
	 */
	public void setRskSougaku(long piRskSougaku) {
		this.rskSougaku = piRskSougaku;
	}

	/**
	 * 利息前期末を設定.
	 * 
	 * @param piRskZenkimatuAmt
	 *            利息前期末
	 */
	public void setRskZenkimatuAmt(long piRskZenkimatuAmt) {
		this.rskZenkimatuAmt = piRskZenkimatuAmt;
	}

	/**
	 * 利息当期実現を設定.
	 * 
	 * @param piRskToukiJitugenAmt
	 *            利息当期実現
	 */
	public void setRskToukiJitugenAmt(long piRskToukiJitugenAmt) {
		this.rskToukiJitugenAmt = piRskToukiJitugenAmt;
	}

	/**
	 * 利息当期減少を設定.
	 * 
	 * @param piRskToukiGensyoAmt
	 *            利息当期減少
	 */
	public void setRskToukiGensyoAmt(long piRskToukiGensyoAmt) {
		this.rskToukiGensyoAmt = piRskToukiGensyoAmt;
	}

	/**
	 * 利息当期末を設定.
	 * 
	 * @param piRskToukimatuAmt
	 *            利息当期末
	 */
	public void setRskToukimatuAmt(long piRskToukimatuAmt) {
		this.rskToukimatuAmt = piRskToukimatuAmt;
	}

	/**
	 * 維持管理費総額を設定.
	 * 
	 * @param piIjiSougaku
	 *            維持管理費総額
	 */
	public void setIjiSougaku(long piIjiSougaku) {
		this.ijiSougaku = piIjiSougaku;
	}

	/**
	 * 維持管理費前期末を設定.
	 * 
	 * @param piIjiZenkimatuAmt
	 *            維持管理費前期末
	 */
	public void setIjiZenkimatuAmt(long piIjiZenkimatuAmt) {
		this.ijiZenkimatuAmt = piIjiZenkimatuAmt;
	}

	/**
	 * 維持管理費当期実現を設定.
	 * 
	 * @param piIjiToukiJitugenAmt
	 *            維持管理費当期実現
	 */
	public void setIjiToukiJitugenAmt(long piIjiToukiJitugenAmt) {
		this.ijiToukiJitugenAmt = piIjiToukiJitugenAmt;
	}

	/**
	 * 維持管理費当期減少を設定.
	 * 
	 * @param piIjiToukiGensyoAmt
	 *            維持管理費当期減少
	 */
	public void setIjiToukiGensyoAmt(long piIjiToukiGensyoAmt) {
		this.ijiToukiGensyoAmt = piIjiToukiGensyoAmt;
	}

	/**
	 * 維持管理費当期末を設定.
	 * 
	 * @param piIjiToukimatuAmt
	 *            維持管理費当期末
	 */
	public void setIjiToukimatuAmt(long piIjiToukimatuAmt) {
		this.ijiToukimatuAmt = piIjiToukimatuAmt;
	}

	/**
	 * 役務提供費総額を設定.
	 * 
	 * @param piEkmSougaku
	 *            役務提供費総額
	 */
	public void setEkmSougaku(long piEkmSougaku) {
		this.ekmSougaku = piEkmSougaku;
	}

	/**
	 * 役務提供費総額を設定.
	 * 
	 * @param piEkmZenkimatuAmt
	 *            役務提供費総額
	 */
	public void setEkmZenkimatuAmt(long piEkmZenkimatuAmt) {
		this.ekmZenkimatuAmt = piEkmZenkimatuAmt;
	}

	/**
	 * 役務提供費当期実現を設定.
	 * 
	 * @param piEkmToukiJitugenAmt
	 *            役務提供費当期実現
	 */
	public void setEkmToukiJitugenAmt(long piEkmToukiJitugenAmt) {
		this.ekmToukiJitugenAmt = piEkmToukiJitugenAmt;
	}

	/**
	 * 役務提供費当期減少を設定.
	 * 
	 * @param piEkmToukiGensyoAmt
	 *            役務提供費当期減少
	 */
	public void setEkmToukiGensyoAmt(long piEkmToukiGensyoAmt) {
		this.ekmToukiGensyoAmt = piEkmToukiGensyoAmt;
	}

	/**
	 * 役務提供費当期末を設定.
	 * 
	 * @param piEkmToukimatuAmt
	 *            役務提供費当期末
	 */
	public void setEkmToukimatuAmt(long piEkmToukimatuAmt) {
		this.ekmToukimatuAmt = piEkmToukimatuAmt;
	}

	/**
	 * リース料累計 総額を設定.
	 * 
	 * @param piLeasAmtRuiSougaku
	 *            リース料累計 総額
	 */
	public void setLeasAmtRuiSougaku(long piLeasAmtRuiSougaku) {
		this.leasAmtRuiSougaku = piLeasAmtRuiSougaku;
	}

	/**
	 * リース料累計 前期末を設定.
	 * 
	 * @param piLeasAmtRuiZenkimatuAmt
	 *            リース料累計 前期末
	 */
	public void setLeasAmtRuiZenkimatuAmt(long piLeasAmtRuiZenkimatuAmt) {
		this.leasAmtRuiZenkimatuAmt = piLeasAmtRuiZenkimatuAmt;
	}

	/**
	 * リース料累計 当期実現を設定.
	 * 
	 * @param piLeasAmtRuiToukiJitugenAmt
	 *            リース料累計 当期実現
	 */
	public void setLeasAmtRuiToukiJitugenAmt(long piLeasAmtRuiToukiJitugenAmt) {
		this.leasAmtRuiToukiJitugenAmt = piLeasAmtRuiToukiJitugenAmt;
	}

	/**
	 * リース料累計 当期減少を設定.
	 * 
	 * @param piLeasAmtRuiToukiGensyoAmt
	 *            リース料累計 当期減少
	 */
	public void setLeasAmtRuiToukiGensyoAmt(long piLeasAmtRuiToukiGensyoAmt) {
		this.leasAmtRuiToukiGensyoAmt = piLeasAmtRuiToukiGensyoAmt;
	}

	/**
	 * リース料累計 当期末を設定.
	 * 
	 * @param piLeasAmtRuiToukimatuAmt
	 *            リース料累計 当期末
	 */
	public void setLeasAmtRuiToukimatuAmt(long piLeasAmtRuiToukimatuAmt) {
		this.leasAmtRuiToukimatuAmt = piLeasAmtRuiToukimatuAmt;
	}

	/**
	 * 未払金(消費税)総額を設定.
	 * 
	 * @param piMibaraiSougaku
	 *            未払金(消費税)総額
	 */
	public void setMibaraiSougaku(long piMibaraiSougaku) {
		this.mibaraiSougaku = piMibaraiSougaku;
	}

	/**
	 * 未払金(消費税)前期末を設定.
	 * 
	 * @param piMibaraiZenkimatuAmt
	 *            未払金(消費税)前期末
	 */
	public void setMibaraiZenkimatuAmt(long piMibaraiZenkimatuAmt) {
		this.mibaraiZenkimatuAmt = piMibaraiZenkimatuAmt;
	}

	/**
	 * 未払金(消費税)当期増加を設定.
	 * 
	 * @param piMibaraiToukiZoukaAmt
	 *            未払金(消費税)当期増加
	 */
	public void setMibaraiToukiZoukaAmt(long piMibaraiToukiZoukaAmt) {
		this.mibaraiToukiZoukaAmt = piMibaraiToukiZoukaAmt;
	}

	/**
	 * 未払金(消費税)当期実現を設定.
	 * 
	 * @param piMibaraiToukiJitugenAmt
	 *            未払金(消費税)当期実現
	 */
	public void setMibaraiToukiJitugenAmt(long piMibaraiToukiJitugenAmt) {
		this.mibaraiToukiJitugenAmt = piMibaraiToukiJitugenAmt;
	}

	/**
	 * 未払金(消費税)当期減少を設定.
	 * 
	 * @param piMibaraiToukiGensyoAmt
	 *            未払金(消費税)当期減少
	 */
	public void setMibaraiToukiGensyoAmt(long piMibaraiToukiGensyoAmt) {
		this.mibaraiToukiGensyoAmt = piMibaraiToukiGensyoAmt;
	}

	/**
	 * 未払金(消費税)当期末を設定.
	 * 
	 * @param piMibaraiToukimatuAmt
	 *            未払金(消費税)当期末
	 */
	public void setMibaraiToukimatuAmt(long piMibaraiToukimatuAmt) {
		this.mibaraiToukimatuAmt = piMibaraiToukimatuAmt;
	}

	// 2020/05/22 ADD START
	/**
	 * ブレイクキー１_0を設定.
	 * 
	 * @param piBrakeKey1_0
	 *            ブレイクキー１_0
	 */
	public void setBrakeKey1_0(String piBrakeKey1_0) {
		this.brakeKey1_0 = piBrakeKey1_0;
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

	/**
	 * 残価保証額総額を設定.
	 * 
	 * @param piZankSougaku
	 *            残価保証額総額
	 */
	public void setZankSougaku(long piZankSougaku) {
		this.zankSougaku = piZankSougaku;
	}
	
	/**
	 * 残価保証額前期末を設定.
	 * 
	 * @param piZankZenkimatuAmt
	 *            残価保証額前期末
	 */
	public void setZankZenkimatuAmt(long piZankZenkimatuAmt) {
		this.zankZenkimatuAmt = piZankZenkimatuAmt;
	}

	/**
	 * 残価保証額当期増加を設定.
	 * 
	 * @param piZankToukiZoukaAmt
	 *            残価保証額当期増加
	 */
	public void setZankToukiZoukaAmt(long piZankToukiZoukaAmt) {
		this.zankToukiZoukaAmt = piZankToukiZoukaAmt;
	}

	/**
	 * 残価保証額当期実現を設定.
	 * 
	 * @param piZankToukiJitugenAmt
	 *            残価保証額当期実現
	 */
	public void setZankToukiJitugenAmt(long piZankToukiJitugenAmt) {
		this.zankToukiJitugenAmt = piZankToukiJitugenAmt;
	}

	/**
	 * 残価保証額当期減少を設定.
	 * 
	 * @param piZankToukiGensyoAmt
	 *            残価保証額当期減少
	 */
	public void setZankToukiGensyoAmt(long piZankToukiGensyoAmt) {
		this.zankToukiGensyoAmt = piZankToukiGensyoAmt;
	}

	/**
	 * 残価保証額当期末を設定.
	 * 
	 * @param piZankToukimatuAmt
	 *            残価保証額当期末
	 */
	public void setZankToukimatuAmt(long piZankToukimatuAmt) {
		this.zankToukimatuAmt = piZankToukimatuAmt;
	}
	// 2020/05/22 ADD END

}
