package jp.co.pro_app.lacs.affairs.bukken.bean;

import jp.co.pro_app.projframe.common.bean.BeanBase;

/**
 * 物件検索明細Bean.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSBukkenDetailBean extends BeanBase {

	private static final long serialVersionUID = 1L;

	private String	leasCompanyName			= "";	// リース会社名

	private String	leasCompanyCode			= "";	// リース会社コード

	private String	cosmosCode				= "";	// COSMOSコード

	private String	leaseUserName			= "";	// リースユーザー名

	private String	keiyakuNo				= "";	// 契約番号

	private String	hyoujiKeiyakuNo			= "";	// 表示用契約番号

	private String	bukkenNo				= "";	// 物件番号

	private String	bukkenEdaNo				= "";	// 物件枝番

	private String	tradeHanteiKekka		= "";	// 取引判定結果略称

	private String	tradeHanteiKekkaCode	= "";	// 取引判定結果区分

	private String	bukkenName				= "";	// 物件名

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
	 * 物件枝番を取得.
	 * 
	 * @return 物件枝番
	 */
	public String getBukkenEdaNo() {
		return this.bukkenEdaNo;
	}

	/**
	 * 物件枝番を設定.
	 * 
	 * @param piBukkenEdaNo
	 *            物件枝番
	 */
	public void setBukkenEdaNo(String piBukkenEdaNo) {
		this.bukkenEdaNo = piBukkenEdaNo;
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
}
