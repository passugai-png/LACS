package jp.co.pro_app.lacs.affairs.ukebarai.bean;

/**
 * 受払合計表行Bean.
 * 
 * @author Katoken
 * @version 20090101
 */
public class LACSUkebaraiRowBean {

	private String	name		= "";	// 科目名

	private long	zenki		= 0;	// 前期末

	private long	zouka		= 0;	// 増加

	private long	touki		= 0;	// 当期

	private long	genshou		= 0;	// 減少

	private long	kimatsu		= 0;	// 当期末

	private boolean	dispZenki	= true; // 前期末表示有無

	private boolean	dispZouka	= true; // 増加表示有無

	private boolean	dispTouki	= true; // 当期表示有無

	private boolean	dispGenshou	= true; // 減少表示有無

	private boolean	dispKimatsu	= true; // 期末表示有無

	/**
	 * コンストラクタ.
	 * 
	 * @param piName
	 *            科目名
	 * @param piDispZenki
	 *            前期表示有無 true：表示／false：非表示
	 * @param piDispZouka
	 *            増加表示有無 true：表示／false：非表示
	 * @param piDispTouki
	 *            当期表示有無 true：表示／false：非表示
	 * @param piDispGenshou
	 *            減少表示有無 true：表示／false：非表示
	 * @param piDispKimatsu
	 *            期末表示有無 true：表示／false：非表示
	 */
	public LACSUkebaraiRowBean(String piName, boolean piDispZenki, boolean piDispZouka, boolean piDispTouki, boolean piDispGenshou, boolean piDispKimatsu) {
		this.name = piName;
		this.dispZenki = piDispZenki;
		this.dispZouka = piDispZouka;
		this.dispTouki = piDispTouki;
		this.dispGenshou = piDispGenshou;
		this.dispKimatsu = piDispKimatsu;

	}

	/**
	 * 科目名を取得.
	 * 
	 * @return 科目名
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 科目名を設定.
	 * 
	 * @param piName
	 *            科目名
	 */
	public void setName(String piName) {
		this.name = piName;
	}

	/**
	 * 前期末を取得.
	 * 
	 * @return 前期末
	 */
	public long getZenki() {
		return this.zenki;
	}

	/**
	 * 前期末を設定.
	 * 
	 * @param piZenki
	 *            前期末
	 */
	public void setZenki(long piZenki) {
		this.zenki += piZenki;
	}

	/**
	 * 増加を取得.
	 * 
	 * @return 増加
	 */
	public long getZouka() {
		return this.zouka;
	}

	/**
	 * 増加を設定.
	 * 
	 * @param piZouka
	 *            増加
	 */
	public void setZouka(long piZouka) {
		this.zouka += piZouka;
	}

	/**
	 * 当期を取得.
	 * 
	 * @return 当期
	 */
	public long getTouki() {
		return this.touki;
	}

	/**
	 * 当期を設定.
	 * 
	 * @param piTouki
	 *            当期
	 */
	public void setTouki(long piTouki) {
		this.touki += piTouki;
	}

	/**
	 * 減少を取得.
	 * 
	 * @return 減少
	 */
	public long getGenshou() {
		return this.genshou;
	}

	/**
	 * 減少を設定.
	 * 
	 * @param piGenshou
	 *            減少
	 */
	public void setGenshou(long piGenshou) {
		this.genshou += piGenshou;
	}

	/**
	 * 当期末を取得.
	 * 
	 * @return 当期末
	 */
	public long getKimatsu() {
		return this.kimatsu;
	}

	/**
	 * 前期末表示有無を取得.
	 * 
	 * @return 前期末表示有無
	 */
	public boolean isDispZenki() {
		return this.dispZenki;
	}

	/**
	 * 前期末表示有無を設定.
	 * 
	 * @param piDispZenki
	 *            前期末表示有無
	 */
	public void setDispZenki(boolean piDispZenki) {
		this.dispZenki = piDispZenki;
	}

	/**
	 * 増加表示有無を取得.
	 * 
	 * @return 増加表示有無
	 */
	public boolean isDispZouka() {
		return this.dispZouka;
	}

	/**
	 * 増加表示有無を設定.
	 * 
	 * @param piDispZouka
	 *            増加表示有無
	 */
	public void setDispZouka(boolean piDispZouka) {
		this.dispZouka = piDispZouka;
	}

	/**
	 * 当期表示有無を取得.
	 * 
	 * @return 当期表示有無
	 */
	public boolean isDispTouki() {
		return this.dispTouki;
	}

	/**
	 * 当期表示有無を設定.
	 * 
	 * @param piDispTouki
	 *            当期表示有無
	 */
	public void setDispTouki(boolean piDispTouki) {
		this.dispTouki = piDispTouki;
	}

	/**
	 * 減少表示有無を取得.
	 * 
	 * @return 減少表示有無
	 */
	public boolean isDispGenshou() {
		return this.dispGenshou;
	}

	/**
	 * 減少表示有無を設定.
	 * 
	 * @param piDispGenshou
	 *            減少表示有無
	 */
	public void setDispGenshou(boolean piDispGenshou) {
		this.dispGenshou = piDispGenshou;
	}

	/**
	 * 期末表示有無を取得.
	 * 
	 * @return 期末表示有無
	 */
	public boolean isDispKimatsu() {
		return this.dispKimatsu;
	}

	/**
	 * 期末表示有無を設定.
	 * 
	 * @param piDispKimatsu
	 *            期末表示有無
	 */
	public void setDispKimatsu(boolean piDispKimatsu) {
		this.dispKimatsu = piDispKimatsu;
	}

	/**
	 * 当期末を設定.
	 * 
	 * @param piToukimatsu
	 *            当期末
	 */
	public void setKimatsu(long piToukimatsu) {
		this.kimatsu += piToukimatsu;
	}
	
	/**
	 * 画面情報へコンバート.
	 * 
	 * @return 画面情報
	 */
	public LACSUkebaraiDetailBean convert() {
		LACSUkebaraiDetailBean detailBean = new LACSUkebaraiDetailBean();

		detailBean.setKamokuNm(this.name);
		detailBean.setZenCost(this.zenki);
		detailBean.setTouzouCost(this.zouka);
		detailBean.setToujitCost(this.touki);
		detailBean.setTougenCost(this.genshou);
		detailBean.setTouzanCost(this.kimatsu);
		detailBean.setZenFlag(this.dispZenki);
		detailBean.setTouzouFlag(this.dispZouka);
		detailBean.setToujitFlag(this.dispTouki);
		detailBean.setTougenFlag(this.dispGenshou);
		detailBean.setTouzanFlag(this.dispKimatsu);

		return detailBean;
	}
}
