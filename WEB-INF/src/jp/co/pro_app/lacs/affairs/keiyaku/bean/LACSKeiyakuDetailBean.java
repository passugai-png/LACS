package jp.co.pro_app.lacs.affairs.keiyaku.bean;

import jp.co.pro_app.projframe.common.bean.BeanBase;

/**
 * 契約検索明細Bean.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSKeiyakuDetailBean extends BeanBase {

	private static final long serialVersionUID = 1L;

	private String	leasCompanyName			= "";	// リース会社名

	private String	leasCompanyCode			= "";	// リース会社コード

	private String	cosmosCode				= "";	// COSMOSコード

	private String	leaseUserName			= "";	// リースユーザー名

	private String	keiyakuNo				= "";	// 契約番号

	private String	hyoujiKeiyakuNo			= "";	// 表示用契約番号

	private String	tradeHanteiKekka		= "";	// 取引判定結果略称

	private String	tradeHanteiKekkaCode	= "";	// 取引判定結果区分

	private String	kenshuYMD				= "";	// 検収年月

	private String	manryoYMD				= "";	// 満了年月

	private String	kaiyakuYMD				= "";	// 解約年月

	private int		keiyakuTerm				= 0;	// 契約期間

	private String	daihyouBukkenName		= "";	// 代表物件名

	private String	downloadPath			= "";	// 明細ダウンロードパス

	/**
	 * リース会社名を取得.
	 * 
	 * @return リース会社名
	 */
	public String getLeasCompanyName() {
		return this.leasCompanyName;
	}

	/**
	 * リース会社名を設定.
	 * 
	 * @param piLeasCompanyName
	 *            リース会社名
	 */
	public void setLeasCompanyName(String piLeasCompanyName) {
		this.leasCompanyName = piLeasCompanyName;
	}

	/**
	 * リース会社コードを取得.
	 * 
	 * @return リース会社コード
	 */
	public String getLeasCompanyCode() {
		return this.leasCompanyCode;
	}

	/**
	 * リース会社コードを設定.
	 * 
	 * @param piLeasCompanyCode
	 *            リース会社コード
	 */
	public void setLeasCompanyCode(String piLeasCompanyCode) {
		this.leasCompanyCode = piLeasCompanyCode;
	}

	/**
	 * COSMOSコードを取得.
	 * 
	 * @return COSMOSコード
	 */
	public String getCosmosCode() {
		return this.cosmosCode;
	}

	/**
	 * COSMOSコードを設定.
	 * 
	 * @param piCosmosCode
	 *            COSMOSコード
	 */
	public void setCosmosCode(String piCosmosCode) {
		this.cosmosCode = piCosmosCode;
	}

	/**
	 * リースユーザー名を取得.
	 * 
	 * @return リースユーザー名
	 */
	public String getLeaseUserName() {
		return this.leaseUserName;
	}

	/**
	 * リースユーザー名を設定.
	 * 
	 * @param piLeaseUserName
	 *            リースユーザー名
	 */
	public void setLeaseUserName(String piLeaseUserName) {
		this.leaseUserName = piLeaseUserName;
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
	public String getHyoujiKeiyakuNo() {
		return this.hyoujiKeiyakuNo;
	}

	/**
	 * 表示用契約番号を設定.
	 * 
	 * @param piHyoujiKeiyakuNo
	 *            表示用契約番号
	 */
	public void setHyoujiKeiyakuNo(String piHyoujiKeiyakuNo) {
		this.hyoujiKeiyakuNo = piHyoujiKeiyakuNo;
	}

	/**
	 * 取引判定結果略称を取得.
	 * 
	 * @return 取引判定結果略称
	 */
	public String getTradeHanteiKekka() {
		return this.tradeHanteiKekka;
	}

	/**
	 * 取引判定結果略称を設定.
	 * 
	 * @param piTradeHanteiKekka
	 *            取引判定結果略称
	 */
	public void setTradeHanteiKekka(String piTradeHanteiKekka) {
		this.tradeHanteiKekka = piTradeHanteiKekka;
	}

	/**
	 * 取引判定結果区分を取得.
	 * 
	 * @return 取引判定結果区分
	 */
	public String getTradeHanteiKekkaCode() {
		return this.tradeHanteiKekkaCode;
	}

	/**
	 * 取引判定結果区分を設定.
	 * 
	 * @param piTradeHanteiKekkaCode
	 *            取引判定結果区分
	 */
	public void setTradeHanteiKekkaCode(String piTradeHanteiKekkaCode) {
		this.tradeHanteiKekkaCode = piTradeHanteiKekkaCode;
	}

	/**
	 * 検収年月を取得.
	 * 
	 * @return 検収年月
	 */
	public String getKenshuYMD() {
		return this.kenshuYMD;
	}

	/**
	 * 検収年月を設定.
	 * 
	 * @param piKenshuYMD
	 *            検収年月
	 */
	public void setKenshuYMD(String piKenshuYMD) {
		this.kenshuYMD = piKenshuYMD;
	}

	/**
	 * 満了年月を取得.
	 * 
	 * @return 満了年月
	 */
	public String getManryoYMD() {
		return this.manryoYMD;
	}

	/**
	 * 満了年月を設定.
	 * 
	 * @param piManryoYMD
	 *            満了年月
	 */
	public void setManryoYMD(String piManryoYMD) {
		this.manryoYMD = piManryoYMD;
	}

	/**
	 * 解約年月を取得.
	 * 
	 * @return 解約年月
	 */
	public String getKaiyakuYMD() {
		return this.kaiyakuYMD;
	}

	/**
	 * 解約年月を設定.
	 * 
	 * @param piKaiyakuYMD
	 *            解約年月
	 */
	public void setKaiyakuYMD(String piKaiyakuYMD) {
		this.kaiyakuYMD = piKaiyakuYMD;
	}

	/**
	 * 契約期間を取得.
	 * 
	 * @return 契約期間
	 */
	public int getKeiyakuTerm() {
		return this.keiyakuTerm;
	}

	/**
	 * 契約期間を設定.
	 * 
	 * @param piKeiyakuTerm
	 *            契約期間
	 */
	public void setKeiyakuTerm(int piKeiyakuTerm) {
		this.keiyakuTerm = piKeiyakuTerm;
	}

	/**
	 * 代表物件名を取得.
	 * 
	 * @return 代表物件名
	 */
	public String getDaihyouBukkenName() {
		return this.daihyouBukkenName;
	}

	/**
	 * 代表物件名を設定.
	 * 
	 * @param piDaihyouBukkenName
	 *            代表物件名
	 */
	public void setDaihyouBukkenName(String piDaihyouBukkenName) {
		this.daihyouBukkenName = piDaihyouBukkenName;
	}

	/** 2008/07/16 ACT Sakamoto Add Start */
	/**
	 * 明細ダウンロードパスを取得.
	 * 
	 * @return 明細ダウンロードパス
	 */
	public String getDownloadPath() {
		return this.downloadPath;
	}

	/**
	 * 明細ダウンロードパスを設定.
	 * 
	 * @param piDownloadPath
	 *            明細ダウンロードパス
	 */
	public void setDownloadPath(String piDownloadPath) {
		this.downloadPath = piDownloadPath;
	}
	/** 2008/07/16 ACT Sakamoto Add End */
}
