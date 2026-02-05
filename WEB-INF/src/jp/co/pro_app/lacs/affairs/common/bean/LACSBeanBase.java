package jp.co.pro_app.lacs.affairs.common.bean;

import jp.co.pro_app.projframe.common.bean.PageBeanBase;
import jp.co.pro_app.projframe.common.html.ComboArray;

/**
 * LACS用Beanスーパークラス.
 * 
 * @author katoken
 * @version 20070312
 */
public abstract class LACSBeanBase extends PageBeanBase {

	private static final long serialVersionUID = 1L;

	private String		message				= "";				// メッセージ

	private ComboArray	leasCompany			= new ComboArray(); // リース会社コンボ

	private ComboArray	tradeHanteiKekka	= new ComboArray(); // 取引判定結果コンボ

	private ComboArray	tantJtiArray		= new ComboArray(); // 担当者状態コンボ

	private String		leasCompanyNm		= "";				// リース会社名（曖昧検索用）

	private int			outputMode			= 0;				// ファイル出力モード 1：PDF／1以外：CSV

	/**
	 * 初期化.
	 */
	protected void init() {
		this.message = "";
		this.leasCompany.clear();
		this.tradeHanteiKekka.clear();

		leasCompanyNm = "";

		super.init();
	}

	/**
	 * メッセージを取得.
	 * 
	 * @return メッセージ
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * メッセージを設定.
	 * 
	 * @param piMessage
	 *            メッセージ
	 */
	public void setMessage(String piMessage) {
		this.message = piMessage;
	}

	/**
	 * リース会社コンボを取得.
	 * 
	 * @return リース会社コンボ
	 */
	public ComboArray getLeasCompany() {
		return this.leasCompany;
	}

	/**
	 * 取引判定結果コンボを取得.
	 * 
	 * @return 取引判定結果コンボ
	 */
	public ComboArray getTradeHanteiKekka() {
		return this.tradeHanteiKekka;
	}

	/**
	 * 担当者状態コンボを取得.
	 * 
	 * @return 担当者状態コンボ
	 */
	public ComboArray getTantJti() {
		return this.tantJtiArray;
	}

	/**
	 * リース会社名（曖昧検索用）を取得.
	 * 
	 * @return リース会社名（曖昧検索用）
	 */
	public String getLeasCompanyNm() {
		return this.leasCompanyNm;
	}

	/**
	 * リース会社名（曖昧検索用）を設定.
	 * 
	 * @param piLeasCompanyNm
	 *            リース会社名（曖昧検索用）
	 */
	public void setLeasCompanyNm(String piLeasCompanyNm) {
		this.leasCompanyNm = piLeasCompanyNm;
	}

	/**
	 * ファイル出力モードを取得.
	 * 
	 * @return ファイル出力モード
	 */
	public int getOutputMode() {
		return this.outputMode;
	}

	/**
	 * ファイル出力モードを設定.
	 * 
	 * @param piOutputMode
	 *            ファイル出力モード
	 */
	public void setOutputMode(int piOutputMode) {
		this.outputMode = piOutputMode;
	}

}
