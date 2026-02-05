package jp.co.pro_app.lacs.affairs.common.bean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.command.StringUtl;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 表示系Beanスーパークラス.
 * 
 * @author katoken
 * @version 20071205
 */
public class LACSViewBeanBase extends LACSBeanBase {

	private static final long serialVersionUID = 1L;

	private String			keiyakuNo		= "";					// 契約番号

	private String			hyoujiKeiyakuNo	= "";					// 表示用契約番号

	private String			bukkenNo		= "";					// 物件番号

	private String			bukkenEdaNo		= "";					// 物件枝番号

	/**
	 * 期間From.
	 */
	protected LACSDateBean	termFrom		= new LACSDateBean();	// 期間From

	private LACSDateBean	termTo			= new LACSDateBean();	// 期間To

	private int				pageFrom		= 0;					// 遷移元ページ 0：処理メニュー 1：契約検索 2：物件検索

	/**
	 * 初期化.
	 * 
	 * @param piCommonBean
	 *            LACS共通Bean
	 */
	protected void init(LACSCommonBean piCommonBean) {

		super.init();

		this.keiyakuNo = "";
		this.bukkenNo = "";

		this.pageFrom = 0;
		this.per = 12;
	}

	/**
	 * 期間項目の初期化.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piCon
	 *            DB接続
	 * @param piModel
	 *            Model
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public void initTerm(LACSCommonBean piCommonBean, Connection piCon, DBModelBase piModel) throws SQLException {
		Date term = new Date();

		this.termFrom = new LACSDateBean(piCommonBean);
		this.termFrom.setName("termFrom");
		this.termTo = new LACSDateBean(piCommonBean);
		this.termTo.setName("termTo");

		LACSCommand.setDateField(piCommonBean, piCon, piModel, Convert.toString(DateUtl.getYear(term)) + StringUtl.formatNumber(DateUtl.getMonth(term), "00") + "01", this.termFrom);

		term = DateUtl.add(Calendar.MONTH, 11, term);

		LACSCommand.setDateField(piCommonBean, piCon, piModel, Convert.toString(DateUtl.getYear(term)) + StringUtl.formatNumber(DateUtl.getMonth(term), "00") + "01", this.termTo);
	}

	/**
	 * コンストラクタ.
	 */
	public LACSViewBeanBase() {
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
	 * 物件枝番号を取得.
	 * 
	 * @return 物件枝番号
	 */
	public String getBukkenEdaNo() {
		return this.bukkenEdaNo;
	}

	/**
	 * 物件枝番号を設定.
	 * 
	 * @param piBukkenEdaNo
	 *            物件枝番号
	 */
	public void setBukkenEdaNo(String piBukkenEdaNo) {
		this.bukkenEdaNo = piBukkenEdaNo;
	}

	/**
	 * 遷移元ページを取得.
	 * 
	 * @return 遷移元ページ
	 */
	public int getPageFrom() {
		return this.pageFrom;
	}

	/**
	 * 遷移元ページを設定.
	 * 
	 * @param piPageFrom
	 *            遷移元ページ
	 */
	public void setPageFrom(int piPageFrom) {
		this.pageFrom = piPageFrom;
	}

	/**
	 * 期間Fromを取得.
	 * 
	 * @return 期間From
	 */
	public LACSDateBean getTermFrom() {
		return this.termFrom;
	}

	/**
	 * 期間Toを取得.
	 * 
	 * @return 期間To
	 */
	public LACSDateBean getTermTo() {
		return this.termTo;
	}

}
