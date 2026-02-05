package jp.co.pro_app.lacs.affairs.common.bean;

import java.util.ArrayList;

import jp.co.pro_app.projframe.common.bean.BeanBase;
import jp.co.pro_app.projframe.common.html.ComboArray;

/**
 * LACS用共通Bean.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSCommonBean extends BeanBase {

	private static final long serialVersionUID = 1L;

	private String				dispID				= "";							// 画面ID

	private String				cosmosCode			= "";							// ログインCOSMOSコード

	private String				cosmosName			= "";							// ログイン開示先名

	private String				loginUserId			= "";							// ログインユーザーID

	private String				loginPassword		= "";							// ログインパスワード

	private String				tantoName			= "";							// お客様名

	private String				dateMode			= "";							// 西暦和暦コード 1：西暦 2：和暦

	private String				dbUserId			= "";							// データベースユーザーID

	private String				dbPassword			= "";							// データベースパスワード

	private String				shoriYMD			= "";							// 処理年月

	private LACSInformationBean	info				= new LACSInformationBean();	// お知らせ

	private ComboArray			warekiArray			= new ComboArray();			// 元号配列

	private String				companyCode			= "";							// リース会社コード

	private int					appMode				= 0;							// 動作モード 0：リース会社 1：リースユーザー

	private int					menuMode			= 0;							// メニューモード 0：管理者モード 1：事業所モード

	private String				logName				= "";							// ログ名

	private String				copyRight			= "";							// コピーライト表記

	private String				infoFile			= "";							// お知らせファイル

	private String				version				= "";							// バージョン

	private String				oneTimePassword		= "";							// ワンタイムパスワード

	private String				errorFlg			= "";							// エラーフラグ

	private String				errorDisplayFlg		= "";							// エラー時の処理メニューの制御

	private String				showUserHelp		= "";							// ユーザーヘルプ表示有無

	private String				showTyukiComment	= "";							// 注記書類作成基準書可変文言表示有無

	private LACSDispControlBean	dispControl			= new LACSDispControlBean();	// 表示制御

	private String				userRight			= "";							// 利用者権限区分

	private ArrayList<Object>	enableUserList		= new ArrayList<Object>();		// 表示可能開示先

	private String				controlSisanDsp		= "";							// 固定資産台帳表示制御

	private String				controlSyouhizeiDsp	= "";							// 消費税明細表表示制御

	private String				controlGokeiDsp		= "";							// 注記合計表表示制御

	private boolean				showSumUnt			= true;						// 集計単位表示区分 0：非表示／1：表示

	private boolean				showKaiKnoOpt		= false;						// 解約可能期間表示区分 0：非表示／1：表示

	private String				controlTyukiPdf		= "";							// 注記書類作成基準書制御

	//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 start
	private String				adress				= "";							// 住所制御
	//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 end
	
	private String				controlTyukiGensenMeisaiDsp		= "";				// 注記源泉CSV１年超明細有無

	//2014/05/19 ADD START	
	private String				controlMikeikaBStaxDsp			= "";				// 未経過リース料期末残高別表消費税有無
	//2014/05/19 ADD END
	/**
	 * 画面IDを取得.
	 * 
	 * @return 画面ID
	 */
	public String getDispID() {
		return this.dispID;
	}

	/**
	 * 画面IDを設定.
	 * 
	 * @param piDispID
	 *            画面ID
	 */
	public void setDispID(String piDispID) {
		this.dispID = piDispID;
	}

	/**
	 * ログインCOSMOSコードを取得.
	 * 
	 * @return ログインCOSMOSコード
	 */
	public String getCosmosCode() {
		return this.cosmosCode;
	}

	/**
	 * ログインCOSMOSコードを設定.
	 * 
	 * @param piCosmosCode
	 *            ログインCOSMOSコード
	 */
	public void setCosmosCode(String piCosmosCode) {
		this.cosmosCode = piCosmosCode;
	}

	/**
	 * ログイン開示先名を取得.
	 * 
	 * @return ログイン開示先名
	 */
	public String getCosmosName() {
		return this.cosmosName;
	}

	/**
	 * ログイン開示先名を設定.
	 * 
	 * @param piCosmosName
	 *            ログイン開示先名
	 */
	public void setCosmosName(String piCosmosName) {
		this.cosmosName = piCosmosName;
	}

	/**
	 * ログインユーザーIDを取得.
	 * 
	 * @return ログインユーザーID
	 */
	public String getLoginUserId() {
		return this.loginUserId;
	}

	/**
	 * ログインユーザーIDを設定.
	 * 
	 * @param piLoginUserId
	 *            ログインユーザーID
	 */
	public void setLoginUserId(String piLoginUserId) {
		this.loginUserId = piLoginUserId;
	}

	/**
	 * ログインパスワードを取得.
	 * 
	 * @return ログインパスワード
	 */
	public String getLoginPassword() {
		return this.loginPassword;
	}

	/**
	 * ログインパスワードを設定.
	 * 
	 * @param piLoginPassword
	 *            ログインパスワード
	 */
	public void setLoginPassword(String piLoginPassword) {
		this.loginPassword = piLoginPassword;
	}

	/**
	 * お客様名を取得.
	 * 
	 * @return お客様名
	 */
	public String getTantoName() {
		return this.tantoName;
	}

	/**
	 * お客様名を設定.
	 * 
	 * @param piTantoName
	 *            お客様名
	 */
	public void setTantoName(String piTantoName) {
		this.tantoName = piTantoName;
	}

	/**
	 * 西暦和暦コード を取得.
	 * 
	 * @return 西暦和暦コード
	 */
	public String getDateMode() {
		return this.dateMode;
	}

	/**
	 * 西暦和暦コード を設定.
	 * 
	 * @param piDateMode
	 *            西暦和暦コード
	 */
	public void setDateMode(String piDateMode) {
		this.dateMode = piDateMode;
	}

	/**
	 * データベースユーザーIDを取得.
	 * 
	 * @return データベースユーザーID
	 */
	public String getDbUserId() {
		return this.dbUserId;
	}

	/**
	 * データベースユーザーIDを設定.
	 * 
	 * @param piDbUserId
	 *            データベースユーザーID
	 */
	public void setDbUserId(String piDbUserId) {
		this.dbUserId = piDbUserId;
	}

	/**
	 * データベースパスワードを取得.
	 * 
	 * @return データベースパスワード
	 */
	public String getDbPassword() {
		return this.dbPassword;
	}

	/**
	 * データベースパスワードを設定.
	 * 
	 * @param piDbPassword
	 *            データベースパスワード
	 */
	public void setDbPassword(String piDbPassword) {
		this.dbPassword = piDbPassword;
	}

	/**
	 * 処理年月を取得.
	 * 
	 * @return 処理年月
	 */
	public String getShoriYMD() {
		return this.shoriYMD;
	}

	/**
	 * 処理年月を設定.
	 * 
	 * @param piShoriYMD
	 *            処理年月
	 */
	public void setShoriYMD(String piShoriYMD) {
		this.shoriYMD = piShoriYMD;
	}

	/**
	 * お知らせを取得.
	 * 
	 * @return お知らせ
	 */
	public LACSInformationBean getInfo() {
		return this.info;
	}

	/**
	 * 元号配列を取得.
	 * 
	 * @return 元号配列
	 */
	public ComboArray getWarekiArray() {
		return this.warekiArray;
	}

	/**
	 * リース会社コードを取得.
	 * 
	 * @return リース会社コード
	 */
	public String getCompanyCode() {
		return this.companyCode;
	}

	/**
	 * リース会社コードを設定.
	 * 
	 * @param piCompanyCode
	 *            リース会社コード
	 */
	public void setCompanyCode(String piCompanyCode) {
		this.companyCode = piCompanyCode;
	}

	/**
	 * 動作モード を取得.
	 * 
	 * @return 動作モード
	 */
	public int getAppMode() {
		return this.appMode;
	}

	/**
	 * 動作モード を設定.
	 * 
	 * @param piAppMode
	 *            動作モード
	 */
	public void setAppMode(int piAppMode) {
		this.appMode = piAppMode;
	}

	/**
	 * ログ名を取得.
	 * 
	 * @return ログ名
	 */
	public String getLogName() {
		return this.logName;
	}

	/**
	 * ログ名を設定.
	 * 
	 * @param piLogName
	 *            ログ名
	 */
	public void setLogName(String piLogName) {
		this.logName = piLogName;
	}

	/**
	 * コピーライト表記を取得.
	 * 
	 * @return コピーライト表記
	 */
	public String getCopyRight() {
		return this.copyRight;
	}

	/**
	 * コピーライト表記を設定.
	 * 
	 * @param piCopyRight
	 *            コピーライト表記
	 */
	public void setCopyRight(String piCopyRight) {
		this.copyRight = piCopyRight;
	}

	/**
	 * メニューモード を取得.
	 * 
	 * @return メニューモード
	 */
	public int getMenuMode() {
		return this.menuMode;
	}

	/**
	 * メニューモード を設定.
	 * 
	 * @param piMenuMode
	 *            メニューモード
	 */
	public void setMenuMode(int piMenuMode) {
		this.menuMode = piMenuMode;
	}

	/**
	 * お知らせファイルを取得.
	 * 
	 * @return お知らせファイル
	 */
	public String getInfoFile() {
		return this.infoFile;
	}

	/**
	 * お知らせファイルを設定.
	 * 
	 * @param piInfoFile
	 *            お知らせファイル
	 */
	public void setInfoFile(String piInfoFile) {
		this.infoFile = piInfoFile;
	}

	/**
	 * バージョンを取得.
	 * 
	 * @return バージョン
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * バージョンを設定.
	 * 
	 * @param piVersion
	 *            バージョン
	 */
	public void setVersion(String piVersion) {
		this.version = piVersion;
	}

	/**
	 * ワンタイムパスワードを取得.
	 * 
	 * @return ワンタイムパスワード
	 */
	public String getOneTimePassword() {
		return this.oneTimePassword;
	}

	/**
	 * ワンタイムパスワードを設定.
	 * 
	 * @param piOneTimePassword
	 *            ワンタイムパスワード
	 */
	public void setOneTimePassword(String piOneTimePassword) {
		this.oneTimePassword = piOneTimePassword;
	}

	/**
	 * エラーフラグを取得.
	 * 
	 * @return エラーフラグ
	 */
	public String getErrorFlg() {
		return this.errorFlg;
	}

	/**
	 * エラーフラグを設定.
	 * 
	 * @param piErrorFlg
	 *            エラーフラグ
	 */
	public void setErrorFlg(String piErrorFlg) {
		this.errorFlg = piErrorFlg;
	}

	/**
	 * エラー時の処理メニューの制御を取得.
	 * 
	 * @return エラー時の処理メニューの制御
	 */
	public String getErrorDisplayFlg() {
		return this.errorDisplayFlg;
	}

	/**
	 * エラー時の処理メニューの制御を設定.
	 * 
	 * @param piErrorDisplayFlg
	 *            エラー時の処理メニューの制御
	 */
	public void setErrorDisplayFlg(String piErrorDisplayFlg) {
		this.errorDisplayFlg = piErrorDisplayFlg;
	}

	/**
	 * ユーザーヘルプ表示有無を取得.
	 * 
	 * @return ユーザーヘルプ表示有無
	 */
	public String getShowUserHelp() {
		return this.showUserHelp;
	}

	/**
	 * ユーザーヘルプ表示有無を設定.
	 * 
	 * @param piShowUserHelp
	 *            ユーザーヘルプ表示有無
	 */
	public void setShowUserHelp(String piShowUserHelp) {
		this.showUserHelp = piShowUserHelp;
	}

	/**
	 * 注記書類作成基準書可変文言表示有無を取得.
	 * 
	 * @return 注記書類作成基準書可変文言表示有無
	 */
	public String getShowTyukiComment() {
		return this.showTyukiComment;
	}

	/**
	 * 注記書類作成基準書可変文言表示有無を設定.
	 * 
	 * @param piShowTyukiComment
	 *            注記書類作成基準書可変文言表示有無
	 */
	public void setShowTyukiComment(String piShowTyukiComment) {
		this.showTyukiComment = piShowTyukiComment;
	}

	/**
	 * 表示制御を取得.
	 * 
	 * @return 表示制御
	 */
	public LACSDispControlBean getDispControl() {
		return this.dispControl;
	}

	/**
	 * 利用者権限区分を取得.
	 * 
	 * @return 利用者権限区分
	 */
	public String getUserRight() {
		return this.userRight;
	}

	/**
	 * 利用者権限区分を設定.
	 * 
	 * @param piUserRight
	 *            利用者権限区分
	 */
	public void setUserRight(String piUserRight) {
		this.userRight = piUserRight;
	}

	/**
	 * 表示可能開示先を取得.
	 * 
	 * @return 表示可能開示先
	 */
	public ArrayList<Object> getEnableUserList() {
		return this.enableUserList;
	}

	/**
	 * 固定資産台帳表示制御を取得.
	 * 
	 * @return 固定資産台帳表示制御
	 */
	public String getControlSisanDsp() {
		return this.controlSisanDsp;
	}

	/**
	 * 固定資産台帳表示制御を設定.
	 * 
	 * @param piControlSisanDsp
	 *            固定資産台帳表示制御
	 */
	public void setControlSisanDsp(String piControlSisanDsp) {
		this.controlSisanDsp = piControlSisanDsp;
	}

	/**
	 * 消費税明細表表示制御を取得.
	 * 
	 * @return 消費税明細表表示制御
	 */
	public String getControlSyouhizeiDsp() {
		return this.controlSyouhizeiDsp;
	}

	/**
	 * 消費税明細表表示制御を設定.
	 * 
	 * @param piControlSyouhizeiDsp
	 *            消費税明細表表示制御
	 */
	public void setControlSyouhizeiDsp(String piControlSyouhizeiDsp) {
		this.controlSyouhizeiDsp = piControlSyouhizeiDsp;
	}

	/**
	 * 注記合計表表示制御を取得.
	 * 
	 * @return 注記合計表表示制御
	 */
	public String getControlGokeiDsp() {
		return this.controlGokeiDsp;
	}

	/**
	 * 注記合計表表示制御を設定.
	 * 
	 * @param piControlGokeiDsp
	 *            注記合計表表示制御
	 */
	public void setControlGokeiDsp(String piControlGokeiDsp) {
		this.controlGokeiDsp = piControlGokeiDsp;
	}

	/**
	 * 集計単位表示区分を取得.
	 * 
	 * @return 集計単位表示区分
	 */
	public boolean isShowSumUnt() {
		return this.showSumUnt;
	}

	/**
	 * 集計単位表示区分を設定.
	 * 
	 * @param piShowSumUnt
	 *            集計単位表示区分
	 */
	public void setShowSumUnt(boolean piShowSumUnt) {
		this.showSumUnt = piShowSumUnt;
	}

	/**
	 * 解約可能期間表示区分を取得.
	 * 
	 * @return 解約可能期間表示区分
	 */
	public boolean isShowKaiKnoOpt() {
		return this.showKaiKnoOpt;
	}

	/**
	 * 解約可能期間表示区分を設定.
	 * 
	 * @param piShowKaiKnoOpt
	 *            解約可能期間表示区分
	 */
	public void setShowKaiKnoOpt(boolean piShowKaiKnoOpt) {
		this.showKaiKnoOpt = piShowKaiKnoOpt;
	}

	/**
	 * 注記書類作成基準書制御を取得.
	 * 
	 * @return 注記書類作成基準書制御
	 */
	public String getControlTyukiPdf() {
		return this.controlTyukiPdf;
	}

	/**
	 * 注記書類作成基準書制御を設定.
	 * 
	 * @param piControlTyukiPdf
	 *            注記書類作成基準書制御
	 */
	public void setControlTyukiPdf(String piControlTyukiPdf) {
		this.controlTyukiPdf = piControlTyukiPdf;
	}

	//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 start
	/**
	 * 住所制御を取得.
	 * 
	 * @return 住所制御
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * 住所制御制御を設定.
	 * 
	 * @param adress
	 *            住所制御
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 end

	/**
	 * 注記源泉CSV１年超明細有無を取得.
	 * 
	 * @return 注記源泉CSV１年超明細有無
	 */
	public String getControlTyukiGensenMeisaiDsp() {
		return this.controlTyukiGensenMeisaiDsp;
	}

	/**
	 * 注記源泉CSV１年超明細有無を設定.
	 * 
	 * @param piControlTyukiGensenMeisaiDsp
	 *            注記源泉CSV１年超明細有無
	 */
	public void setControlTyukiGensenMeisaiDsp(String piControlTyukiGensenMeisaiDsp) {
		this.controlTyukiGensenMeisaiDsp = piControlTyukiGensenMeisaiDsp;
	}

	//2014/05/19 ADD START
	/**
	 * 未経過リース料期末残高別表消費税有無を取得.
	 * 
	 * @return 未経過リース料期末残高別表消費税有無
	 */
	public String getControlMikeikaBStaxDsp() {
		return this.controlMikeikaBStaxDsp;
	}

	/**
	 * 未経過リース料期末残高別表消費税有無を設定.
	 * 
	 * @param piControlMikeikaBStaxDsp
	 *            未経過リース料期末残高別表消費税有無
	 */
	public void setControlMikeikaBStaxDsp(String piControlMikeikaBStaxDsp) {
		this.controlMikeikaBStaxDsp = piControlMikeikaBStaxDsp;
	}
	//2014/05/19 ADD END 
}
