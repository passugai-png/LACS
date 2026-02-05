package jp.co.pro_app.lacs.affairs.ukebarai.bean;

/**
 * 費用受払明細表 Bean.
 * 
 * @author active
 * @version 20080814
 */
public class LACSUkebaraiSisanBean {

	private String	brakeKey1				= "";	// ブレイクキー１

	// 2020/05/22 ADD START
	private String	brakeKey1_0				= "";	// ブレイクキー１_0
	private String	brakeKey6				= "";	// ブレイクキー6
	// 2020/05/22 ADD END

	private String	brakeKey2				= "";	// ブレイクキー２

	private String	brakeKey3				= "";	// ブレイクキー３

	private String	brakeKey4				= "";	// ブレイクキー４

	private String	brakeKey5				= "";	// ブレイクキー５

	private String	createDate				= "";	// 作成日

	private String	kikanStart				= "";	// 対象期間開始

	private String	kikanEnd				= "";	// 対象期間終了

	private String	lcNm					= "";	// リース会社

	private String	luNm					= "";	// 開示先

	private String	sisanKbn				= "";	// 資産区分

	private String	taishoAcKijyunNm		= "";	// リース会計基準

	private String	acShrNm					= "";	// 会計処理方法

	private String	trdHnteiKekaNm			= "";	// リース取引分類

	private String	keiNo					= "";	// 契約番号

	private String	bknNo					= "";	// 物件番号

	private String	bknNm					= "";	// 物件名称

	private String	knshuYmd				= "";	// リース開始日

	private String	mryoYmd					= "";	// リース終了日

	private String	kaiYmd					= "";	// 中途解約日

	private long	zenkimatuZanAmt			= 0;	// 前期末残高

	private long	toukiZoukaAmt			= 0;	// 当期増加

	private long	toukiGensyoAmt			= 0;	// 当期減少高

	private long	toukimatuZanAmt			= 0;	// 当期末残高

	private long	zenkimatuBokaAmt		= 0;	// 前期末簿価

	private long	toukiJitugenAmt			= 0;	// 当期実現

	private long	toukiGensyoBokaAmt		= 0;	// 当期減少簿価

	private long	toukimatuBokaAmt		= 0;	// 当期末簿価

	private long	zenkimatuSyokyakuAmt	= 0;	// 前期末償却累計

	private long	toukimatuSyokyakuAmt	= 0;	// 当期末償却累計

	private long	toukiZoukaBokaAmt		= 0;	// 当期増加簿価

	// 2020/05/22 ADD START
	private String	jysiUm					= "";	// 重要性有無

	private long	zankHshoAmt				= 0;	// 残価保証額

	private String	ssnSriNm				= "";	// 固定資産種類
	// 2020/05/22 ADD END
	
	/**
	 * ブレイクキー１を取得.
	 * 
	 * @return ブレイクキー１
	 */
	public String getBrakeKey1() {
		return this.brakeKey1;
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
	 * ブレイクキー6を取得.
	 * 
	 * @return ブレイクキー6
	 */
	public String getBrakeKey6() {
		return this.brakeKey6;
	}
// 2020/05/22 ADD END

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
	 * 資産区分を取得.
	 * 
	 * @return 資産区分
	 */
	public String getSisanKbn() {
		return this.sisanKbn;
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
	 * 前期末残高を取得.
	 * 
	 * @return 前期末残高
	 */
	public long getZenkimatuZanAmt() {
		return this.zenkimatuZanAmt;
	}

	/**
	 * 当期増加を取得.
	 * 
	 * @return 当期増加
	 */
	public long getToukiZoukaAmt() {
		return this.toukiZoukaAmt;
	}

	/**
	 * 当期減少高を取得.
	 * 
	 * @return 当期減少高
	 */
	public long getToukiGensyoAmt() {
		return this.toukiGensyoAmt;
	}

	/**
	 * 当期末残高を取得.
	 * 
	 * @return 当期末残高
	 */
	public long getToukimatuZanAmt() {
		return this.toukimatuZanAmt;
	}

	/**
	 * 前期末簿価を取得.
	 * 
	 * @return 前期末簿価
	 */
	public long getZenkimatuBokaAmt() {
		return this.zenkimatuBokaAmt;
	}

	/**
	 * 当期実現を取得.
	 * 
	 * @return 当期実現
	 */
	public long getToukiJitugenAmt() {
		return this.toukiJitugenAmt;
	}

	/**
	 * 当期減少簿価を取得.
	 * 
	 * @return 当期減少簿価
	 */
	public long getToukiGensyoBokaAmt() {
		return this.toukiGensyoBokaAmt;
	}

	/**
	 * 当期末簿価を取得.
	 * 
	 * @return 当期末簿価
	 */
	public long getToukimatuBokaAmt() {
		return this.toukimatuBokaAmt;
	}

	/**
	 * 前期末償却累計を取得.
	 * 
	 * @return 前期末償却累計
	 */
	public long getZenkimatuSyokyakuAmt() {
		return this.zenkimatuSyokyakuAmt;
	}

	/**
	 * 当期末償却累計を取得.
	 * 
	 * @return 当期末償却累計
	 */
	public long getToukimatuSyokyakuAmt() {
		return this.toukimatuSyokyakuAmt;
	}

	/**
	 * 当期増加簿価を取得.
	 * 
	 * @return 当期増加簿価
	 */
	public long getToukiZoukaBokaAmt() {
		return this.toukiZoukaBokaAmt;
	}

	// 2020/05/22 ADD START
	/**
	 * 重要性有無を取得.
	 * 
	 * @return 重要性有無
	 */
	public String getJysiUm() {
		return this.jysiUm;
	}
	
	/**
	 * 固定資産種類を取得.
	 * 
	 * @return 固定資産種類
	 */
	public String getSsnSriNm() {
		return this.ssnSriNm;
	}

	/**
	 * 残価保証額を取得.
	 * 
	 * @return 残価保証額
	 */
	public long getZankHshoAmt() {
		return this.zankHshoAmt;
	}
// 2020/05/22 ADD END

	/**
	 * ブレイクキー１を設定.
	 * 
	 * @param piBrakeKey1
	 *            ブレイクキー１
	 */
	public void setBrakeKey1(String piBrakeKey1) {
		this.brakeKey1 = piBrakeKey1;
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
	 * ブレイクキー6を設定.
	 * 
	 * @param piBrakeKey6
	 *            ブレイクキー6
	 */
	public void setBrakeKey6(String piBrakeKey6) {
		this.brakeKey6 = piBrakeKey6;
	}
// 2020/05/22 ADD END

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
	 * 資産区分を設定.
	 * 
	 * @param piSisanKbn
	 *            資産区分
	 */
	public void setSisanKbn(String piSisanKbn) {
		this.sisanKbn = piSisanKbn;
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
	 * 前期末残高を設定.
	 * 
	 * @param piZenkimatuZanAmt
	 *            前期末残高
	 */
	public void setZenkimatuZanAmt(long piZenkimatuZanAmt) {
		this.zenkimatuZanAmt = piZenkimatuZanAmt;
	}

	/**
	 * 当期増加を設定.
	 * 
	 * @param piToukiZoukaAmt
	 *            当期増加
	 */
	public void setToukiZoukaAmt(long piToukiZoukaAmt) {
		this.toukiZoukaAmt = piToukiZoukaAmt;
	}

	/**
	 * 当期減少高を設定.
	 * 
	 * @param piToukiGensyoAmt
	 *            当期減少高
	 */
	public void setToukiGensyoAmt(long piToukiGensyoAmt) {
		this.toukiGensyoAmt = piToukiGensyoAmt;
	}

	/**
	 * 当期末残高を設定.
	 * 
	 * @param piToukimatuZanAmt
	 *            当期末残高
	 */
	public void setToukimatuZanAmt(long piToukimatuZanAmt) {
		this.toukimatuZanAmt = piToukimatuZanAmt;
	}

	/**
	 * 前期末簿価を設定.
	 * 
	 * @param piZenkimatuBokaAmt
	 *            前期末簿価
	 */
	public void setZenkimatuBokaAmt(long piZenkimatuBokaAmt) {
		this.zenkimatuBokaAmt = piZenkimatuBokaAmt;
	}

	/**
	 * 当期実現を設定.
	 * 
	 * @param piToukiJitugenAmt
	 *            当期実現
	 */
	public void setToukiJitugenAmt(long piToukiJitugenAmt) {
		this.toukiJitugenAmt = piToukiJitugenAmt;
	}

	/**
	 * 当期減少簿価を設定.
	 * 
	 * @param piToukiGensyoBokaAmt
	 *            当期減少簿価
	 */
	public void setToukiGensyoBokaAmt(long piToukiGensyoBokaAmt) {
		this.toukiGensyoBokaAmt = piToukiGensyoBokaAmt;
	}

	/**
	 * 当期末簿価を設定.
	 * 
	 * @param piToukimatuBokaAmt
	 *            当期末簿価
	 */
	public void setToukimatuBokaAmt(long piToukimatuBokaAmt) {
		this.toukimatuBokaAmt = piToukimatuBokaAmt;
	}

	/**
	 * 前期末償却累計を設定.
	 * 
	 * @param piZenkimatuSyokyakuAmt
	 *            前期末償却累計
	 */
	public void setZenkimatuSyokyakuAmt(long piZenkimatuSyokyakuAmt) {
		this.zenkimatuSyokyakuAmt = piZenkimatuSyokyakuAmt;
	}

	/**
	 * 当期末償却累計を設定.
	 * 
	 * @param piToukimatuSyokyakuAmt
	 *            当期末償却累計
	 */
	public void setToukimatuSyokyakuAmt(long piToukimatuSyokyakuAmt) {
		this.toukimatuSyokyakuAmt = piToukimatuSyokyakuAmt;
	}

	/**
	 * 当期増加簿価を設定.
	 * 
	 * @param piToukiZoukaBokaAmt
	 *            当期増加簿価
	 */
	public void setToukiZoukaBokaAmt(long piToukiZoukaBokaAmt) {
		this.toukiZoukaBokaAmt = piToukiZoukaBokaAmt;
	}

	// 2020/05/22 ADD START
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
	 * 固定資産種類を設定.
	 * 
	 * @param piSsnSriNm
	 *            固定資産種類
	 */
	public void setSsnSriNm(String piSsnSriNm) {
		this.ssnSriNm = piSsnSriNm;
	}
	
	/**
	 * 残価保証額を設定.
	 * 
	 * @param piZankHshoAmt
	 *            残価保証額
	 */
	public void setZankHshoAmt(long piZankHshoAmt) {
		this.zankHshoAmt = piZankHshoAmt;
	}	
	// 2020/05/22 ADD END

}
