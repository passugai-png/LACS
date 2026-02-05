package jp.co.pro_app.lacs.affairs.syousai.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSViewBeanBase;

/**
 * 契約詳細Bean.
 * 
 * @author yokota
 * @version 20081017
 */
public class LACSSyousaiBean extends LACSViewBeanBase {

	private static final long serialVersionUID = 1L;

	private String					keiyakuNo					= "";							// 契約番号

	private String					kaijisakiName				= "";							// 開示先

	private String					leaseCompanyNm				= "";							// リース会社名

	private String					leaseTerm					= "";							// リース期間

	private String					keiyakuYmd					= "";							// 契約日

	private String					kensyuYmd					= "";							// 検収日

	private String					manryoYmd					= "";							// 満了日

	private String					kaiyakuYmd					= "";							// 解約日

	private String					leasTradeBunrui				= "";							// リース取引分類

	private String					leasTradeBunruiName			= "";							// リース取引分類名

	private String					daihyoBukkenName			= "";							// 代表物件名

	private String					joutoJouken					= "";							// 譲渡条件

	private String					joutoJoukenName				= "";							// 譲渡条件名

	private String					wariyasuKonyuSentakuKen		= "";							// 割安購入選択権

	private String					wariyasuKonyuSentakuKenName	= "";							// 割安購入選択権名

	private String					tokubetiSiyoBukken			= "";							// 特別仕様物件

	private String					tokubetiSiyoBukkenName		= "";							// 特別仕様物件名

	private String					tyutoKaiyaku				= "";							// 中途解約

	private String					tyutoKaiyakuName			= "";							// 中途解約名

	private long					keiWaribikiGenzaiKati		= 0;							// 割引現在価値（契約） 初期値：0

	private long					leaseRyouSogaku				= 0;							// リース料総額 初期値：0

	private long					mitumoriGenkinKakaku		= 0;							// 見積現金購入価格 初期値：0

	private long					taxSougaku					= 0;							// 消費税総額 初期値：0

	private long					risokuSoutouSougaku			= 0;							// 支払利息相当額総額 初期値：0

	private long					zanHosyou					= 0;							// 残価保証額 初期値：0

	private long					ijikanriHiSougaku			= 0;							// 維持管理費相当額総額 初期値：0

	private long					ekimuteikyoHiSougaku		= 0;							// 役務提供費相当額総額 初期値：0

	private String					risokuHaibunHohou			= "";							// 利息相当配分方法

	private String					risokuHaibunHohouName		= "";							// 利息相当配分方法名

	private String					leaseRyouKeisanKijun		= "";							// リース料計算基準

	private String					leaseRyouKeisanKijunName	= "";							// リース料計算基準名

	private String					gnkskHasuChoseiHohou		= "";							// 減価償却端数調整方法

	private String					gnkskHasuChoseiHohouName	= "";							// 減価償却端数調整方法名

	private String					leasCompanyCode				= "";

	private String					downloadPath				= "";							// ダウンロードパス

	private String					createDate					= "";							// 作成日

	private String					csvdownloadPath				= "";							// CSVダウンロードパス

	private LACSSyousaiDetailBean	keiyakuSyousai				= new LACSSyousaiDetailBean();	// 契約詳細表

	private String					syougakuSisanName			= "";

	/**
	 * コンストラクタ.
	 */
	public LACSSyousaiBean() {
		this.setPageServlet("page.syousai");
		this.per = 10;
	}

	/**
	 * 明細を追加.
	 * 
	 * @param piDetail
	 *            明細
	 */
	public void addDetail(LACSSyousaiDetailBean piDetail) {
		super.add(piDetail);
	}

	/**
	 * 代表物件名を取得.
	 * 
	 * @return 代表物件名
	 */
	public String getDaihyoBukkenName() {
		return this.daihyoBukkenName;
	}

	/**
	 * 明細を取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 明細
	 */
	public LACSSyousaiDetailBean getDetail(int piIdx) {
		return (LACSSyousaiDetailBean)super.get(piIdx);
	}

	/**
	 * 役務提供費相当額総額を取得.
	 * 
	 * @return 役務提供費相当額総額
	 */
	public long getEkimuteikyoHiSougaku() {
		return this.ekimuteikyoHiSougaku;
	}

	/**
	 * 減価償却端数調整方法を取得.
	 * 
	 * @return 減価償却端数調整方法
	 */
	public String getGnkskHasuChoseiHohou() {
		return this.gnkskHasuChoseiHohou;
	}

	/**
	 * 減価償却端数調整方法名を取得.
	 * 
	 * @return 減価償却端数調整方法名
	 */
	public String getGnkskHasuChoseiHohouName() {
		return this.gnkskHasuChoseiHohouName;
	}

	/**
	 * 維持管理費相当額総額を取得.
	 * 
	 * @return 維持管理費相当額総額
	 */
	public long getIjikanriHiSougaku() {
		return this.ijikanriHiSougaku;
	}

	/**
	 * 譲渡条件を取得.
	 * 
	 * @return 譲渡条件
	 */
	public String getJoutoJouken() {
		return this.joutoJouken;
	}

	/**
	 * 譲渡条件名を取得.
	 * 
	 * @return 譲渡条件名
	 */
	public String getJoutoJoukenName() {
		return this.joutoJoukenName;
	}

	/**
	 * 開示先を取得.
	 * 
	 * @return 開示先
	 */
	public String getKaijisakiName() {
		return this.kaijisakiName;
	}

	/**
	 * リース会社名を取得.
	 * 
	 * @return リース会社名
	 */
	public String getLeaseCompanyNm() {
		return this.leaseCompanyNm;
	}

	/**
	 * 解約日を取得.
	 * 
	 * @return 解約日
	 */
	public String getKaiyakuYmd() {
		return this.kaiyakuYmd;
	}

	/**
	 * 割引現在価値（契約）を取得.
	 * 
	 * @return 割引現在価値（契約）
	 */
	public long getKeiWaribikiGenzaiKati() {
		return this.keiWaribikiGenzaiKati;
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
	 * 契約日を取得.
	 * 
	 * @return 契約日
	 */
	public String getKeiyakuYmd() {
		return this.keiyakuYmd;
	}

	/**
	 * 検収日を取得.
	 * 
	 * @return 検収日
	 */
	public String getKensyuYmd() {
		return this.kensyuYmd;
	}

	/**
	 * リース料計算基準を取得.
	 * 
	 * @return リース料計算基準
	 */
	public String getLeaseRyouKeisanKijun() {
		return this.leaseRyouKeisanKijun;
	}

	/**
	 * リース料計算基準名を取得.
	 * 
	 * @return リース料計算基準名
	 */
	public String getLeaseRyouKeisanKijunName() {
		return this.leaseRyouKeisanKijunName;
	}

	/**
	 * リース料総額を取得.
	 * 
	 * @return リース料総額
	 */
	public long getLeaseRyouSogaku() {
		return this.leaseRyouSogaku;
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
	 * リース取引分類を取得.
	 * 
	 * @return リース取引分類
	 */
	public String getLeasTradeBunrui() {
		return this.leasTradeBunrui;
	}

	/**
	 * リース取引分類名を取得.
	 * 
	 * @return リース取引分類名
	 */
	public String getLeasTradeBunruiName() {
		return this.leasTradeBunruiName;
	}

	/**
	 * 満了日を取得.
	 * 
	 * @return 満了日
	 */
	public String getManryoYmd() {
		return this.manryoYmd;
	}

	/**
	 * 見積現金購入価格を取得.
	 * 
	 * @return 見積現金購入価格
	 */
	public long getMitumoriGenkinKakaku() {
		return this.mitumoriGenkinKakaku;
	}

	/**
	 * 利息相当配分方法を取得.
	 * 
	 * @return 利息相当配分方法
	 */
	public String getRisokuHaibunHohou() {
		return this.risokuHaibunHohou;
	}

	/**
	 * 利息相当配分方法名を取得.
	 * 
	 * @return 利息相当配分方法名
	 */
	public String getRisokuHaibunHohouName() {
		return this.risokuHaibunHohouName;
	}

	/**
	 * 支払利息相当額総額を取得.
	 * 
	 * @return 支払利息相当額総額
	 */
	public long getRisokuSoutouSougaku() {
		return this.risokuSoutouSougaku;
	}

	/**
	 * 消費税総額を取得.
	 * 
	 * @return 消費税総額
	 */
	public long getTaxSougaku() {
		return this.taxSougaku;
	}

	/**
	 * 特別仕様物件を取得.
	 * 
	 * @return 特別仕様物件
	 */
	public String getTokubetiSiyoBukken() {
		return this.tokubetiSiyoBukken;
	}

	/**
	 * 特別仕様物件名を取得.
	 * 
	 * @return 特別仕様物件名
	 */
	public String getTokubetiSiyoBukkenName() {
		return this.tokubetiSiyoBukkenName;
	}

	/**
	 * 中途解約を取得.
	 * 
	 * @return 中途解約
	 */
	public String getTyutoKaiyaku() {
		return this.tyutoKaiyaku;
	}

	/**
	 * 中途解約名を取得.
	 * 
	 * @return 中途解約名
	 */
	public String getTyutoKaiyakuName() {
		return this.tyutoKaiyakuName;
	}

	/**
	 * 割安購入選択権を取得.
	 * 
	 * @return 割安購入選択権
	 */
	public String getWariyasuKonyuSentakuKen() {
		return this.wariyasuKonyuSentakuKen;
	}

	/**
	 * 割安購入選択権名を取得.
	 * 
	 * @return 割安購入選択権名
	 */
	public String getWariyasuKonyuSentakuKenName() {
		return this.wariyasuKonyuSentakuKenName;
	}

	/**
	 * 残価保証額を取得.
	 * 
	 * @return 残価保証額
	 */
	public long getZanHosyou() {
		return this.zanHosyou;
	}

	/**
	 * 初期化.
	 * 
	 * @param piCommonBean
	 *            LACS共通Bean
	 */
	public void init(LACSCommonBean piCommonBean) {
		super.init(piCommonBean);

		this.per = 10;

	}

	/**
	 * 代表物件名を設定.
	 * 
	 * @param piDaihyoBukkenName
	 *            代表物件名
	 */
	public void setDaihyoBukkenName(String piDaihyoBukkenName) {
		this.daihyoBukkenName = piDaihyoBukkenName;
	}

	/**
	 * 役務提供費相当額総額を設定.
	 * 
	 * @param piEkimuteikyoHiSougaku
	 *            役務提供費相当額総額
	 */
	public void setEkimuteikyoHiSougaku(long piEkimuteikyoHiSougaku) {
		this.ekimuteikyoHiSougaku = piEkimuteikyoHiSougaku;
	}

	/**
	 * 減価償却端数調整方法を設定.
	 * 
	 * @param piGnkskHasuChoseiHohou
	 *            減価償却端数調整方法
	 */
	public void setGnkskHasuChoseiHohou(String piGnkskHasuChoseiHohou) {
		this.gnkskHasuChoseiHohou = piGnkskHasuChoseiHohou;
	}

	/**
	 * 減価償却端数調整方法名を設定.
	 * 
	 * @param piGnkskHasuChoseiHohouName
	 *            減価償却端数調整方法名
	 */
	public void setGnkskHasuChoseiHohouName(String piGnkskHasuChoseiHohouName) {
		this.gnkskHasuChoseiHohouName = piGnkskHasuChoseiHohouName;
	}

	/**
	 * 維持管理費相当額総額を設定.
	 * 
	 * @param piIjikanriHiSougaku
	 *            維持管理費相当額総額
	 */
	public void setIjikanriHiSougaku(long piIjikanriHiSougaku) {
		this.ijikanriHiSougaku = piIjikanriHiSougaku;
	}

	/**
	 * 譲渡条件を設定.
	 * 
	 * @param piJoutoJouken
	 *            譲渡条件
	 */
	public void setJoutoJouken(String piJoutoJouken) {
		this.joutoJouken = piJoutoJouken;
	}

	/**
	 * 譲渡条件名を設定.
	 * 
	 * @param piJoutoJoukenName
	 *            譲渡条件名
	 */
	public void setJoutoJoukenName(String piJoutoJoukenName) {
		this.joutoJoukenName = piJoutoJoukenName;
	}

	/**
	 * 開示先を設定.
	 * 
	 * @param piKaijisakiName
	 *            開示先
	 */
	public void setKaijisakiName(String piKaijisakiName) {
		this.kaijisakiName = piKaijisakiName;
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
	 * 解約日を設定.
	 * 
	 * @param piKaiyakuYmd
	 *            解約日
	 */
	public void setKaiyakuYmd(String piKaiyakuYmd) {
		this.kaiyakuYmd = piKaiyakuYmd;
	}

	/**
	 * 割引現在価値（契約）を設定.
	 * 
	 * @param piKeiWaribikiGenzaiKati
	 *            割引現在価値（契約）
	 */
	public void setKeiWaribikiGenzaiKati(long piKeiWaribikiGenzaiKati) {
		this.keiWaribikiGenzaiKati = piKeiWaribikiGenzaiKati;
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
	 * 契約日を設定.
	 * 
	 * @param piKeiyakuYmd
	 *            契約日
	 */
	public void setKeiyakuYmd(String piKeiyakuYmd) {
		this.keiyakuYmd = piKeiyakuYmd;
	}

	/**
	 * 検収日を設定.
	 * 
	 * @param piKensyuYmd
	 *            検収日
	 */
	public void setKensyuYmd(String piKensyuYmd) {
		this.kensyuYmd = piKensyuYmd;
	}

	/**
	 * リース料計算基準を設定.
	 * 
	 * @param piLeaseRyouKeisanKijun
	 *            リース料計算基準
	 */
	public void setLeaseRyouKeisanKijun(String piLeaseRyouKeisanKijun) {
		this.leaseRyouKeisanKijun = piLeaseRyouKeisanKijun;
	}

	/**
	 * リース料計算基準を設定名.
	 * 
	 * @param piLeaseRyouKeisanKijunName
	 *            リース料計算基準名
	 */
	public void setLeaseRyouKeisanKijunName(String piLeaseRyouKeisanKijunName) {
		this.leaseRyouKeisanKijunName = piLeaseRyouKeisanKijunName;
	}

	/**
	 * リース料総額を設定.
	 * 
	 * @param piLeaseRyouSogaku
	 *            リース料総額
	 */
	public void setLeaseRyouSogaku(long piLeaseRyouSogaku) {
		this.leaseRyouSogaku = piLeaseRyouSogaku;
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
	 * リース取引分類を設定.
	 * 
	 * @param piLeasTradeBunrui
	 *            リース取引分類
	 */
	public void setLeasTradeBunrui(String piLeasTradeBunrui) {
		this.leasTradeBunrui = piLeasTradeBunrui;
	}

	/**
	 * リース取引分類名を設定.
	 * 
	 * @param piLeasTradeBunruiName
	 *            リース取引分類名
	 */
	public void setLeasTradeBunruiName(String piLeasTradeBunruiName) {
		this.leasTradeBunruiName = piLeasTradeBunruiName;
	}

	/**
	 * 満了日を設定.
	 * 
	 * @param piManryoYmd
	 *            満了日
	 */
	public void setManryoYmd(String piManryoYmd) {
		this.manryoYmd = piManryoYmd;
	}

	/**
	 * 見積現金購入価格を設定.
	 * 
	 * @param piMitumoriGenkinKakaku
	 *            見積現金購入価格
	 */
	public void setMitumoriGenkinKakaku(long piMitumoriGenkinKakaku) {
		this.mitumoriGenkinKakaku = piMitumoriGenkinKakaku;
	}

	/**
	 * 利息相当配分方法を設定.
	 * 
	 * @param piRisokuHaibunHohou
	 *            利息相当配分方法
	 */
	public void setRisokuHaibunHohou(String piRisokuHaibunHohou) {
		this.risokuHaibunHohou = piRisokuHaibunHohou;
	}

	/**
	 * 利息相当配分方法を設定名.
	 * 
	 * @param piRisokuHaibunHohouName
	 *            利息相当配分方法名
	 */
	public void setRisokuHaibunHohouName(String piRisokuHaibunHohouName) {
		this.risokuHaibunHohouName = piRisokuHaibunHohouName;
	}

	/**
	 * 支払利息相当額総額を設定.
	 * 
	 * @param piRisokuSoutouSougaku
	 *            支払利息相当額総額
	 */
	public void setRisokuSoutouSougaku(long piRisokuSoutouSougaku) {
		this.risokuSoutouSougaku = piRisokuSoutouSougaku;
	}

	/**
	 * 消費税総額を設定.
	 * 
	 * @param piTaxSougaku
	 *            消費税総額
	 */
	public void setTaxSougaku(long piTaxSougaku) {
		this.taxSougaku = piTaxSougaku;
	}

	/**
	 * 特別仕様物件を設定.
	 * 
	 * @param piTokubetiSiyoBukken
	 *            特別仕様物件
	 */
	public void setTokubetiSiyoBukken(String piTokubetiSiyoBukken) {
		this.tokubetiSiyoBukken = piTokubetiSiyoBukken;
	}

	/**
	 * 特別仕様物件名を設定.
	 * 
	 * @param piTokubetiSiyoBukkenName
	 *            特別仕様物件名
	 */
	public void setTokubetiSiyoBukkenName(String piTokubetiSiyoBukkenName) {
		this.tokubetiSiyoBukkenName = piTokubetiSiyoBukkenName;
	}

	/**
	 * 中途解約を設定.
	 * 
	 * @param piTyutoKaiyaku
	 *            中途解約
	 */
	public void setTyutoKaiyaku(String piTyutoKaiyaku) {
		this.tyutoKaiyaku = piTyutoKaiyaku;
	}

	/**
	 * 中途解約名を設定.
	 * 
	 * @param piTyutoKaiyakuName
	 *            中途解約名
	 */
	public void setTyutoKaiyakuName(String piTyutoKaiyakuName) {
		this.tyutoKaiyakuName = piTyutoKaiyakuName;
	}

	/**
	 * 割安購入選択権を設定.
	 * 
	 * @param piWariyasuKonyuSentakuKen
	 *            割安購入選択権
	 */
	public void setWariyasuKonyuSentakuKen(String piWariyasuKonyuSentakuKen) {
		this.wariyasuKonyuSentakuKen = piWariyasuKonyuSentakuKen;
	}

	/**
	 * 割安購入選択権名を設定.
	 * 
	 * @param piWariyasuKonyuSentakuKenName
	 *            割安購入選択権名
	 */
	public void setWariyasuKonyuSentakuKenName(String piWariyasuKonyuSentakuKenName) {
		this.wariyasuKonyuSentakuKenName = piWariyasuKonyuSentakuKenName;
	}

	/**
	 * 残価保証額を取得.
	 * 
	 * @param piZanHosyou
	 *            残価保証額
	 */
	public void setZanHosyou(long piZanHosyou) {
		this.zanHosyou = piZanHosyou;

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
	 * リース会社コードを取得.
	 * 
	 * @return リース会社コード
	 */
	public String getLeasCompanyCode() {
		return this.leasCompanyCode;
	}

	/**
	 * ダウンロードパスを取得.
	 * 
	 * @return ダウンロードパス
	 */
	public String getDownloadPath() {
		return this.downloadPath;
	}

	/**
	 * ダウンロードパスを設定.
	 * 
	 * @param piDownloadPath
	 *            ダウンロードパス
	 */
	public void setDownloadPath(String piDownloadPath) {
		this.downloadPath = piDownloadPath;
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
	 * 作成日を設定.
	 * 
	 * @param piCreateDate
	 *            作成日
	 */
	public void setCreateDate(String piCreateDate) {
		this.createDate = piCreateDate;
	}

	/**
	 * CSVダウンロードパスを取得.
	 * 
	 * @return CSVダウンロードパス
	 */
	public String getCSVDownloadPath() {
		return this.csvdownloadPath;
	}

	/**
	 * CSVダウンロードパスを設定.
	 * 
	 * @param piCSVDownloadPath
	 *            CSVダウンロードパス
	 */
	public void setCSVDownloadPath(String piCSVDownloadPath) {
		this.csvdownloadPath = piCSVDownloadPath;
	}

	/**
	 * 契約詳細表を取得.
	 * 
	 * @return 契約詳細表
	 */
	public LACSSyousaiDetailBean getKeiyakuSyousai() {
		return this.keiyakuSyousai;
	}

	/**
	 * 少額資産名を取得.
	 * 
	 * @return 少額資産名
	 */
	public String getSyougakuSisanName() {
		return this.syougakuSisanName;
	}

	/**
	 * 少額資産名を設定.
	 * 
	 * @param piSyougakuSisanName
	 *            少額資産名
	 */
	public void setSyougakuSisanName(String piSyougakuSisanName) {
		this.syougakuSisanName = piSyougakuSisanName;
	}
}
