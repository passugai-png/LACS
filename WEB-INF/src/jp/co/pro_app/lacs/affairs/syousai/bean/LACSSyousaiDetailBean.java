package jp.co.pro_app.lacs.affairs.syousai.bean;

import jp.co.pro_app.projframe.common.bean.BeanBase;

/**
 * 契約詳細明細Bean.
 * 
 * @author yokota
 * @version 20081017
 */
public class LACSSyousaiDetailBean extends BeanBase {

	private static final long serialVersionUID = 1L;

	private String	keiyakuNo				= "";	// 契約番号

	private String	bukkenNo				= "";	// 物件番号

	private String	bukkenName				= "";	// 物件名

	private String	kikaiNo					= "";	// 機械番号

	private String	sisanSyuruiName			= "";	// 資産種類

	private String	settiBasyo				= "";	// 設置場所

	private long	suryo					= 0;	// 数量 初期値：0

	private String	tani					= "";	// 単位

	private long	bknWaribikiGenzaiKati	= 0;	// 割引現在価値（物件） 初期値：0

	private double	waribikiKeisanRisiRitu	= 0;	// 割引計算利子率 初期値：0

	private double	risokuKeisanRisiRitu	= 0;	// 利息計算利子率 初期値：0

	private String	saiyoSkkKeijoKbn		= "";	// 採用償却計上方法区分

	private String	saiyoSkkKeijoKbnName	= "";	// 採用償却計上方法区分名称

	private String	zankaHosyoUmu			= "";	// 残価保証有無

	private long	ijikanriHi				= 0;	// 維持管理費 初期値：0

	private long	ekimuteikyoHi			= 0;	// 役務提供費 初期値：0

	private String	rskKeijHohoKbn			= "";	// 利息計上方法区分コード

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
	public String getBukkenNo() {
		return this.bukkenNo;
	}

	/**
	 * 物件番号を設定.
	 * 
	 * @param piBukkenNo
	 *            物件番号
	 */
	public void setBukkenNo(String piBukkenNo) {
		this.bukkenNo = piBukkenNo;
	}

	/**
	 * 物件名を取得.
	 * 
	 * @return 物件名
	 */
	public String getBukkenName() {
		return this.bukkenName;
	}

	/**
	 * 物件名を設定.
	 * 
	 * @param piBukkenName
	 *            物件名
	 */
	public void setBukkenName(String piBukkenName) {
		this.bukkenName = piBukkenName;
	}

	/**
	 * 機械番号を取得.
	 * 
	 * @return 機械番号
	 */
	public String getKikaiNo() {
		return this.kikaiNo;
	}

	/**
	 * 機械番号を設定.
	 * 
	 * @param piKikaiNo
	 *            機械番号
	 */
	public void setKikaiNo(String piKikaiNo) {
		this.kikaiNo = piKikaiNo;
	}

	/**
	 * 資産種類を取得.
	 * 
	 * @return 資産種類
	 */
	public String getSisanSyuruiName() {
		return this.sisanSyuruiName;
	}

	/**
	 * 資産種類を設定.
	 * 
	 * @param piSisanSyuruiName
	 *            資産種類
	 */
	public void setSisanSyuruiName(String piSisanSyuruiName) {
		this.sisanSyuruiName = piSisanSyuruiName;
	}

	/**
	 * 設置場所を取得.
	 * 
	 * @return 設置場所
	 */
	public String getSettiBasyo() {
		return this.settiBasyo;
	}

	/**
	 * 設置場所を設定.
	 * 
	 * @param piSettiBasyo
	 *            設置場所
	 */
	public void setSettiBasyo(String piSettiBasyo) {
		this.settiBasyo = piSettiBasyo;
	}

	/**
	 * 数量を取得.
	 * 
	 * @return 数量
	 */
	public long getSuryo() {
		return this.suryo;
	}

	/**
	 * 数量を設定.
	 * 
	 * @param piSuryo
	 *            数量
	 */
	public void setSuryo(long piSuryo) {
		this.suryo = piSuryo;
	}

	/**
	 * 単位を取得.
	 * 
	 * @return 単位
	 */
	public String getTani() {
		return this.tani;
	}

	/**
	 * 単位を設定.
	 * 
	 * @param piTani
	 *            単位
	 */
	public void setTani(String piTani) {
		this.tani = piTani;
	}

	/**
	 * 割引現在価値（物件）を取得.
	 * 
	 * @return 割引現在価値（物件）
	 */
	public long getBknWaribikiGenzaiKati() {
		return this.bknWaribikiGenzaiKati;
	}

	/**
	 * 割引現在価値（物件）を設定.
	 * 
	 * @param piBknWaribikiGenzaiKati
	 *            割引現在価値（物件）
	 */
	public void setBknWaribikiGenzaiKati(long piBknWaribikiGenzaiKati) {
		this.bknWaribikiGenzaiKati = piBknWaribikiGenzaiKati;
	}

	/**
	 * 割引計算利子率を取得.
	 * 
	 * @return 割引計算利子率
	 */
	public double getWaribikiKeisanRisiRitu() {
		return this.waribikiKeisanRisiRitu;
	}

	/**
	 * 割引計算利子率を設定.
	 * 
	 * @param piWaribikiKeisanRisiRitu
	 *            割引計算利子率
	 */
	public void setWaribikiKeisanRisiRitu(double piWaribikiKeisanRisiRitu) {
		this.waribikiKeisanRisiRitu = piWaribikiKeisanRisiRitu;
	}

	/**
	 * 利息計算利子率を取得.
	 * 
	 * @return 利息計算利子率
	 */
	public double getRisokuKeisanRisiRitu() {
		return this.risokuKeisanRisiRitu;
	}

	/**
	 * 利息計算利子率を設定.
	 * 
	 * @param piRisokuKeisanRisiRitu
	 *            利息計算利子率
	 */
	public void setRisokuKeisanRisiRitu(double piRisokuKeisanRisiRitu) {
		this.risokuKeisanRisiRitu = piRisokuKeisanRisiRitu;
	}

	/**
	 * 採用償却計上方法区分を取得.
	 * 
	 * @return 採用償却計上方法区分
	 */
	public String getSaiyoSkkKeijoKbn() {
		return this.saiyoSkkKeijoKbn;
	}

	/**
	 * 採用償却計上方法区分を設定.
	 * 
	 * @param piSaiyoSkkKeijoKbn
	 *            採用償却計上方法区分
	 */
	public void setSaiyoSkkKeijoKbn(String piSaiyoSkkKeijoKbn) {
		this.saiyoSkkKeijoKbn = piSaiyoSkkKeijoKbn;
	}

	/**
	 * 採用償却計上方法区分名称を取得.
	 * 
	 * @return 採用償却計上方法区分名称
	 */
	public String getSaiyoSkkKeijoKbnName() {
		return this.saiyoSkkKeijoKbnName;
	}

	/**
	 * 採用償却計上方法区分名称を設定.
	 * 
	 * @param piSaiyoSkkKeijoKbnName
	 *            採用償却計上方法区分名称
	 */
	public void setSaiyoSkkKeijoKbnName(String piSaiyoSkkKeijoKbnName) {
		this.saiyoSkkKeijoKbnName = piSaiyoSkkKeijoKbnName;
	}

	/**
	 * 残価保証有無を取得.
	 * 
	 * @return 残価保証有無
	 */
	public String getZankaHosyoUmu() {
		return this.zankaHosyoUmu;
	}

	/**
	 * 残価保証有無を設定.
	 * 
	 * @param piZankaHosyoUmu
	 *            残価保証有無
	 */
	public void setZankaHosyoUmu(String piZankaHosyoUmu) {
		this.zankaHosyoUmu = piZankaHosyoUmu;
	}

	/**
	 * 維持管理費を取得.
	 * 
	 * @return 維持管理費
	 */
	public long getIjikanriHi() {
		return this.ijikanriHi;
	}

	/**
	 * 維持管理費を設定.
	 * 
	 * @param piIjikanriHi
	 *            維持管理費
	 */
	public void setIjikanriHi(long piIjikanriHi) {
		this.ijikanriHi = piIjikanriHi;
	}

	/**
	 * 役務提供費を取得.
	 * 
	 * @return 役務提供費
	 */
	public long getEkimuteikyoHi() {
		return this.ekimuteikyoHi;
	}

	/**
	 * 役務提供費を設定.
	 * 
	 * @param piEkimuteikyoHi
	 *            役務提供費
	 */
	public void setEkimuteikyoHi(long piEkimuteikyoHi) {
		this.ekimuteikyoHi = piEkimuteikyoHi;
	}

	/**
	 * 利息計上方法区分コードを取得.
	 * 
	 * @return 利息計上方法区分コード
	 */
	public String getRskKeijHohoKbn() {
		return this.rskKeijHohoKbn;
	}

	/**
	 * 利息計上方法区分コードを設定.
	 * 
	 * @param piRskKeijHohoKbn
	 *            利息計上方法区分コード
	 */
	public void setRskKeijHohoKbn(String piRskKeijHohoKbn) {
		this.rskKeijHohoKbn = piRskKeijHohoKbn;
	}

}
