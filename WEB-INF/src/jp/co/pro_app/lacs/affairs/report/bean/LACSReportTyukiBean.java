package jp.co.pro_app.lacs.affairs.report.bean;

/**
 * 帳票出力：注記書類作成基準書 Bean.
 * 
 * @author fukuhara
 * @version 20080409
 */
public class LACSReportTyukiBean {

	private String	leaseCompanyNm				= "";	// リース会社名

	private String	leaseUserNm					= "";	// リースユーザ名

	private String	leaseCompanyZipCd			= "";	// リース会社郵便番号

	private String	leaseCompanyAddr1			= "";	// リース会社住所１

	private String	leaseCompanyAddr2			= "";	// リース会社住所２

	private String	leaseUserZipCd				= "";	// リースユーザ郵便番号

	private String	leaseUserAddr1				= "";	// リースユーザ住所１

	private String	leaseUserAddr2				= "";	// リースユーザ住所２

	private String	oldItenSyoukyakuYukei		= "";	// 旧移転償却方法 有形資産

	private String	oldItenSyoukyakuMukei		= "";	// 旧移転償却方法 無形資産

	private String	oldItenGaiSyoukyakuYukei	= "";	// 旧移転外償却方法 有形資産

	private String	oldItenGaiSyoukyakuMukei	= "";	// 旧移転外償却方法 無形資産

	private String	oldItenGaiSyoukyakuHasu		= "";	// 旧移転外償却方法 端数調整

	private String	oldRisokuKeisan				= "";	// 旧利息計算方法 利息計算方法

	private String	oldRisokuHukin				= "";	// 旧利息計算方法 賦金展開方法

	private String	oldRisokuHasu				= "";	// 旧利息計算方法 端数調整

	private String	oldJyuyouIji				= "";	// 旧維持管理重要性

	private String	oldJyuyouEkimu				= "";	// 旧役務管理重要性

	private String	newItenSyoukyakuYukei		= "";	// 旧移転償却方法 有形資産

	private String	newItenSyoukyakuMukei		= "";	// 旧移転償却方法 無形資産

	private String	newItenGaiSyoukyakuYukei	= "";	// 旧移転外償却方法 有形資産

	private String	newItenGaiSyoukyakuMukei	= "";	// 旧移転外償却方法 無形資産

	private String	newItenGaiSyoukyakuHasu		= "";	// 旧移転外償却方法 端数調整

	private String	newRisokuKeisan				= "";	// 旧利息計算方法 利息計算方法

	private String	newRisokuHukin				= "";	// 旧利息計算方法 賦金展開方法

	private String	newRisokuHasu				= "";	// 旧利息計算方法 端数調整

	private String	newJyuyouIji				= "";	// 旧維持管理重要性

	private String	newJyuyouEkimu				= "";	// 旧役務管理重要性

	private String	tyukiComment1				= "";	// 注記書類作成基準書可変文言１

	private String	tyukiComment2				= "";	// 注記書類作成基準書可変文言２

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
	 * リースユーザを取得.
	 * 
	 * @return リースユーザ
	 */
	public String getLeaseUserNm() {
		return this.leaseUserNm;
	}

	/**
	 * リースユーザを設定.
	 * 
	 * @param piLeaseUserNm
	 *            リースユーザ
	 */
	public void setLeaseUserNm(String piLeaseUserNm) {
		this.leaseUserNm = piLeaseUserNm;
	}

	/**
	 * リース会社郵便番号を取得.
	 * 
	 * @return リース会社郵便番号
	 */
	public String getLeaseCompanyZipCd() {
		return this.leaseCompanyZipCd;
	}

	/**
	 * リース会社郵便番号を設定.
	 * 
	 * @param piLeaseCompanyZipCd
	 *            リース会社郵便番号
	 */
	public void setLeaseCompanyZipCd(String piLeaseCompanyZipCd) {
		this.leaseCompanyZipCd = piLeaseCompanyZipCd;
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
	 * リース会社住所１を設定.
	 * 
	 * @param piLeaseCompanyAddr1
	 *            リース会社住所１
	 */
	public void setLeaseCompanyAddr1(String piLeaseCompanyAddr1) {
		this.leaseCompanyAddr1 = piLeaseCompanyAddr1;
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
	 * リース会社住所２を設定.
	 * 
	 * @param piLeaseCompanyAddr2
	 *            リース会社住所２
	 */
	public void setLeaseCompanyAddr2(String piLeaseCompanyAddr2) {
		this.leaseCompanyAddr2 = piLeaseCompanyAddr2;
	}

	/**
	 * リースユーザ郵便番号を取得.
	 * 
	 * @return リースユーザ郵便番号
	 */
	public String getLeaseUserZipCd() {
		return this.leaseUserZipCd;
	}

	/**
	 * リースユーザ郵便番号を設定.
	 * 
	 * @param piLeaseUserZipCd
	 *            リースユーザ郵便番号
	 */
	public void setLeaseUserZipCd(String piLeaseUserZipCd) {
		this.leaseUserZipCd = piLeaseUserZipCd;
	}

	/**
	 * リースユーザ住所１を取得.
	 * 
	 * @return リースユーザ住所１
	 */
	public String getLeaseUserAddr1() {
		return this.leaseUserAddr1;
	}

	/**
	 * リースユーザ住所１を設定.
	 * 
	 * @param piLeaseUserAddr1
	 *            リースユーザ住所１
	 */
	public void setLeaseUserAddr1(String piLeaseUserAddr1) {
		this.leaseUserAddr1 = piLeaseUserAddr1;
	}

	/**
	 * リースユーザ住所２を取得.
	 * 
	 * @return リースユーザ住所２
	 */
	public String getLeaseUserAddr2() {
		return this.leaseUserAddr2;
	}

	/**
	 * リースユーザ住所２を設定.
	 * 
	 * @param piLeaseUserAddr2
	 *            リースユーザ住所２
	 */
	public void setLeaseUserAddr2(String piLeaseUserAddr2) {
		this.leaseUserAddr2 = piLeaseUserAddr2;
	}

	/**
	 * 旧移転償却方法 有形資産を取得.
	 * 
	 * @return 旧移転償却方法 有形資産
	 */
	public String getOldItenSyoukyakuYukei() {
		return this.oldItenSyoukyakuYukei;
	}

	/**
	 * 旧移転償却方法 有形資産を設定.
	 * 
	 * @param piOldItenSyoukyakuYukei
	 *            旧移転償却方法 有形資産
	 */
	public void setOldItenSyoukyakuYukei(String piOldItenSyoukyakuYukei) {
		this.oldItenSyoukyakuYukei = piOldItenSyoukyakuYukei;
	}

	/**
	 * 旧移転償却方法 無形資産を取得.
	 * 
	 * @return 旧移転償却方法 無形資産
	 */
	public String getOldItenSyoukyakuMukei() {
		return this.oldItenSyoukyakuMukei;
	}

	/**
	 * 旧移転償却方法 無形資産を設定.
	 * 
	 * @param piOldItenSyoukyakuMukei
	 *            旧移転償却方法 無形資産
	 */
	public void setOldItenSyoukyakuMukei(String piOldItenSyoukyakuMukei) {
		this.oldItenSyoukyakuMukei = piOldItenSyoukyakuMukei;
	}

	/**
	 * 旧移転外償却方法 有形資産を取得.
	 * 
	 * @return 旧移転外償却方法 有形資産
	 */
	public String getOldItenGaiSyoukyakuYukei() {
		return this.oldItenGaiSyoukyakuYukei;
	}

	/**
	 * 旧移転外償却方法 有形資産を設定.
	 * 
	 * @param piOldItenGaiSyoukyakuYukei
	 *            旧移転外償却方法 有形資産
	 */
	public void setOldItenGaiSyoukyakuYukei(String piOldItenGaiSyoukyakuYukei) {
		this.oldItenGaiSyoukyakuYukei = piOldItenGaiSyoukyakuYukei;
	}

	/**
	 * 旧移転外償却方法 無形資産を取得.
	 * 
	 * @return 旧移転外償却方法 無形資産
	 */
	public String getOldItenGaiSyoukyakuMukei() {
		return this.oldItenGaiSyoukyakuMukei;
	}

	/**
	 * 旧移転外償却方法 無形資産を設定.
	 * 
	 * @param piOldItenGaiSyoukyakuMukei
	 *            旧移転外償却方法 無形資産
	 */
	public void setOldItenGaiSyoukyakuMukei(String piOldItenGaiSyoukyakuMukei) {
		this.oldItenGaiSyoukyakuMukei = piOldItenGaiSyoukyakuMukei;
	}

	/**
	 * 旧移転外償却方法 端数調整を取得.
	 * 
	 * @return 旧移転外償却方法 端数調整
	 */
	public String getOldItenGaiSyoukyakuHasu() {
		return this.oldItenGaiSyoukyakuHasu;
	}

	/**
	 * 旧移転外償却方法 端数調整を設定.
	 * 
	 * @param piOldItenGaiSyoukyakuHasu
	 *            旧移転外償却方法 端数調整
	 */
	public void setOldItenGaiSyoukyakuHasu(String piOldItenGaiSyoukyakuHasu) {
		this.oldItenGaiSyoukyakuHasu = piOldItenGaiSyoukyakuHasu;
	}

	/**
	 * 旧利息計算方法 利息計算方法を取得.
	 * 
	 * @return 旧利息計算方法 利息計算方法
	 */
	public String getOldRisokuKeisan() {
		return this.oldRisokuKeisan;
	}

	/**
	 * 旧利息計算方法 利息計算方法を設定.
	 * 
	 * @param piOldRisokuKeisan
	 *            旧利息計算方法 利息計算方法
	 */
	public void setOldRisokuKeisan(String piOldRisokuKeisan) {
		this.oldRisokuKeisan = piOldRisokuKeisan;
	}

	/**
	 * 旧利息計算方法 賦金展開方法を取得.
	 * 
	 * @return 旧利息計算方法 賦金展開方法
	 */
	public String getOldRisokuHukin() {
		return this.oldRisokuHukin;
	}

	/**
	 * 旧利息計算方法 賦金展開方法を設定.
	 * 
	 * @param piOldRisokuHukin
	 *            旧利息計算方法 賦金展開方法
	 */
	public void setOldRisokuHukin(String piOldRisokuHukin) {
		this.oldRisokuHukin = piOldRisokuHukin;
	}

	/**
	 * 旧利息計算方法 端数調整を取得.
	 * 
	 * @return 旧利息計算方法 端数調整
	 */
	public String getOldRisokuHasu() {
		return this.oldRisokuHasu;
	}

	/**
	 * 旧利息計算方法 端数調整を設定.
	 * 
	 * @param piOldRisokuHasu
	 *            旧利息計算方法 端数調整
	 */
	public void setOldRisokuHasu(String piOldRisokuHasu) {
		this.oldRisokuHasu = piOldRisokuHasu;
	}

	/**
	 * 旧維持管理費重要性を取得.
	 * 
	 * @return 旧維持管理費重要性
	 */
	public String getOldJyuyouIji() {
		return this.oldJyuyouIji;
	}

	/**
	 * 旧維持管理費重要性を設定.
	 * 
	 * @param piOldJyuyouIji
	 *            旧維持管理費重要性
	 */
	public void setOldJyuyouIji(String piOldJyuyouIji) {
		this.oldJyuyouIji = piOldJyuyouIji;
	}

	/**
	 * 旧役務提供費重要性を取得.
	 * 
	 * @return 旧役務提供費重要性
	 */
	public String getOldJyuyouEkimu() {
		return this.oldJyuyouEkimu;
	}

	/**
	 * 旧役務提供費重要性を設定.
	 * 
	 * @param piOldJyuyouEkimu
	 *            旧役務提供費重要性
	 */
	public void setOldJyuyouEkimu(String piOldJyuyouEkimu) {
		this.oldJyuyouEkimu = piOldJyuyouEkimu;
	}

	/**
	 * 新移転償却方法 有形資産を取得.
	 * 
	 * @return 新移転償却方法 有形資産
	 */
	public String getNewItenSyoukyakuYukei() {
		return this.newItenSyoukyakuYukei;
	}

	/**
	 * 新移転償却方法 有形資産を設定.
	 * 
	 * @param piNewItenSyoukyakuYukei
	 *            新移転償却方法 有形資産
	 */
	public void setNewItenSyoukyakuYukei(String piNewItenSyoukyakuYukei) {
		this.newItenSyoukyakuYukei = piNewItenSyoukyakuYukei;
	}

	/**
	 * 新移転償却方法 無形資産を取得.
	 * 
	 * @return 新移転償却方法 無形資産
	 */
	public String getNewItenSyoukyakuMukei() {
		return this.newItenSyoukyakuMukei;
	}

	/**
	 * 新移転償却方法 無形資産を設定.
	 * 
	 * @param piNewItenSyoukyakuMukei
	 *            新移転償却方法 無形資産
	 */
	public void setNewItenSyoukyakuMukei(String piNewItenSyoukyakuMukei) {
		this.newItenSyoukyakuMukei = piNewItenSyoukyakuMukei;
	}

	/**
	 * 新移転外償却方法 有形資産を取得.
	 * 
	 * @return 新移転外償却方法 有形資産
	 */
	public String getNewItenGaiSyoukyakuYukei() {
		return this.newItenGaiSyoukyakuYukei;
	}

	/**
	 * 新移転外償却方法 有形資産を設定.
	 * 
	 * @param piNewItenGaiSyoukyakuYukei
	 *            新移転外償却方法 有形資産
	 */
	public void setNewItenGaiSyoukyakuYukei(String piNewItenGaiSyoukyakuYukei) {
		this.newItenGaiSyoukyakuYukei = piNewItenGaiSyoukyakuYukei;
	}

	/**
	 * 新移転外償却方法 無形資産を取得.
	 * 
	 * @return 新移転外償却方法 無形資産
	 */
	public String getNewItenGaiSyoukyakuMukei() {
		return this.newItenGaiSyoukyakuMukei;
	}

	/**
	 * 新移転外償却方法 無形資産を設定.
	 * 
	 * @param piNewItenGaiSyoukyakuMukei
	 *            新移転外償却方法 無形資産
	 */
	public void setNewItenGaiSyoukyakuMukei(String piNewItenGaiSyoukyakuMukei) {
		this.newItenGaiSyoukyakuMukei = piNewItenGaiSyoukyakuMukei;
	}

	/**
	 * 新移転外償却方法 端数調整を取得.
	 * 
	 * @return 新移転外償却方法 端数調整
	 */
	public String getNewItenGaiSyoukyakuHasu() {
		return this.newItenGaiSyoukyakuHasu;
	}

	/**
	 * 新移転外償却方法 端数調整を設定.
	 * 
	 * @param piNewItenGaiSyoukyakuHasu
	 *            新移転外償却方法 端数調整
	 */
	public void setNewItenGaiSyoukyakuHasu(String piNewItenGaiSyoukyakuHasu) {
		this.newItenGaiSyoukyakuHasu = piNewItenGaiSyoukyakuHasu;
	}

	/**
	 * 新利息計算方法 利息計算方法を取得.
	 * 
	 * @return 新利息計算方法 利息計算方法
	 */
	public String getNewRisokuKeisan() {
		return this.newRisokuKeisan;
	}

	/**
	 * 新利息計算方法 利息計算方法を設定.
	 * 
	 * @param piNewRisokuKeisan
	 *            新利息計算方法 利息計算方法
	 */
	public void setNewRisokuKeisan(String piNewRisokuKeisan) {
		this.newRisokuKeisan = piNewRisokuKeisan;
	}

	/**
	 * 新利息計算方法 賦金展開方法を取得.
	 * 
	 * @return 新利息計算方法 賦金展開方法
	 */
	public String getNewRisokuHukin() {
		return this.newRisokuHukin;
	}

	/**
	 * 新利息計算方法 賦金展開方法を設定.
	 * 
	 * @param piNewRisokuHukin
	 *            新利息計算方法 賦金展開方法
	 */
	public void setNewRisokuHukin(String piNewRisokuHukin) {
		this.newRisokuHukin = piNewRisokuHukin;
	}

	/**
	 * 新利息計算方法 端数調整を取得.
	 * 
	 * @return 新利息計算方法 端数調整
	 */
	public String getNewRisokuHasu() {
		return this.newRisokuHasu;
	}

	/**
	 * 新利息計算方法 端数調整を設定.
	 * 
	 * @param piNewRisokuHasu
	 *            新利息計算方法 端数調整
	 */
	public void setNewRisokuHasu(String piNewRisokuHasu) {
		this.newRisokuHasu = piNewRisokuHasu;
	}

	/**
	 * 新維持管理費重要性を取得.
	 * 
	 * @return 新維持管理費重要性
	 */
	public String getNewJyuyouIji() {
		return this.newJyuyouIji;
	}

	/**
	 * 新維持管理費重要性を設定.
	 * 
	 * @param piNewJyuyouIji
	 *            新維持管理費重要性
	 */
	public void setNewJyuyouIji(String piNewJyuyouIji) {
		this.newJyuyouIji = piNewJyuyouIji;
	}

	/**
	 * 新役務提供費重要性を取得.
	 * 
	 * @return 新役務提供費重要性
	 */
	public String getNewJyuyouEkimu() {
		return this.newJyuyouEkimu;
	}

	/**
	 * 新役務提供費重要性を設定.
	 * 
	 * @param piNewJyuyouEkimu
	 *            新役務提供費重要性
	 */
	public void setNewJyuyouEkimu(String piNewJyuyouEkimu) {
		this.newJyuyouEkimu = piNewJyuyouEkimu;
	}

	/**
	 * 注記書類作成基準書可変文言１を取得.
	 * 
	 * @return 注記書類作成基準書可変文言１
	 */
	public String getTyukiComment1() {
		return this.tyukiComment1;
	}

	/**
	 * 注記書類作成基準書可変文言１を設定.
	 * 
	 * @param piTyukiComment1
	 *            注記書類作成基準書可変文言１
	 */
	public void setTyukiComment1(String piTyukiComment1) {
		this.tyukiComment1 = piTyukiComment1;
	}

	/**
	 * 注記書類作成基準書可変文言２を取得.
	 * 
	 * @return 注記書類作成基準書可変文言２
	 */
	public String getTyukiComment2() {
		return this.tyukiComment2;
	}

	/**
	 * 注記書類作成基準書可変文言２を設定.
	 * 
	 * @param piTyukiComment2
	 *            注記書類作成基準書可変文言２
	 */
	public void setTyukiComment2(String piTyukiComment2) {
		this.tyukiComment2 = piTyukiComment2;
	}


}
