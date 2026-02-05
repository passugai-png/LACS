package jp.co.pro_app.lacs.affairs.user.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSDispControlBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSMaintenanceBeanBase;
import jp.co.pro_app.projframe.common.html.ComboArray;

/**
 * リースユーザーマスタBean.
 * 
 * @author takeda
 * @version 20070911
 */
public class LACSUserBean extends LACSMaintenanceBeanBase {

	private static final long serialVersionUID = 1L;

	private String				userCosmosCode			= "";							// COSMOSコード

	private String				userName				= "";							// リースユーザー名称

	private String				userZip1				= "";							// リースユーザー郵便番号１

	private String				userZip2				= "";							// リースユーザー郵便番号２

	private String				userAddress1			= "";							// リースユーザー住所１

	private String				userAddress2			= "";							// リースユーザー住所２

	private String				userTelNo				= "";							// リースユーザー電話番号

	private String				userTantoName			= "";							// リースユーザー担当者名

	private ComboArray			seirekiWarekiCode		= new ComboArray();			// 西暦和暦コード

	private ComboArray			acShrKbn				= new ComboArray();			// 会計処理区分

	private String				kesnKiMM				= "";							// 決算期FROM(月)

	private String				kesnKiDD				= "";							// 決算期FROM(日)

	private String				gtjSrtKeiJgiFlg			= "";							// 月次帳票-短期契約除外フラグ

	private String				gtjRlsKeiJgiFlg			= "";							// 月次帳票-再リース契約除外フラグ

	private String				gtjSgkKeiJgiFlg			= "";							// 月次帳票-少額契約除外フラグ

	private String				gtjCytKaiJgiFlg			= "";							// 月次帳票-中途解約除外フラグ

	private String				dataSource				= "";							// オンラインDBデータソース名

	private ComboArray			oldItenYukeiSkkHohoCd	= new ComboArray();			// 旧会計基準-所有権移転有形償却方法コード

	private ComboArray			oldItenMukeiSkkHohoCd	= new ComboArray();			// 旧会計基準-所有権移転無形償却方法コード

	private ComboArray			oldItengiYukeiSkkHohoCd	= new ComboArray();			// 旧会計基準-所有権移転外有形償却方法コード

	private ComboArray			oldItengiMukeiSkkHohoCd	= new ComboArray();			// 旧会計基準-所有権移転外無形償却方法コード

	private ComboArray			oldMbriAbriKbn			= new ComboArray();			// 旧会計基準-前払後払区分

	private ComboArray			oldRskClcHohoCd			= new ComboArray();			// 旧会計基準-利息計算方法コード

	private ComboArray			oldFknTnkiHohoCd		= new ComboArray();			// 旧会計基準-賦金展開方法コード

	private ComboArray			oldIjiKnriHyoJyoKbn		= new ComboArray();			// 旧会計基準-維持管理費重要性区分

	private ComboArray			oldEkmTeikHyoJyoKbn		= new ComboArray();			// 旧会計基準-役務提供費用重要性区分

	private ComboArray			oldGnkskHasuChseCd		= new ComboArray();			// 旧会計基準-減価償却端数調整コード

	private ComboArray			oldFknTnkiHasuChseCd	= new ComboArray();			// 旧会計基準-賦金展開調整コード

	private String				oldKnuAmtTutiUmFlg		= "";							// 旧会計基準-購入額通知有無フラグ

	private ComboArray			newItenYukeiSkkHohoCd	= new ComboArray();			// 新会計基準-所有権移転有形償却方法コード

	private ComboArray			newItenMukeiSkkHohoCd	= new ComboArray();			// 新会計基準-所有権移転無形償却方法コード

	private ComboArray			newItengiYukeiSkkHohoCd	= new ComboArray();			// 新会計基準-所有権移転外有形償却方法コード

	private ComboArray			newItengiMukeiSkkHohoCd	= new ComboArray();			// 新会計基準-所有権移転外無形償却方法コード

	private ComboArray			newMbriAbriKbn			= new ComboArray();			// 新会計基準-前払後払区分

	private ComboArray			newRskClcHohoCd			= new ComboArray();			// 新会計基準-利息計算方法コード

	private ComboArray			newFknTnkiHohoCd		= new ComboArray();			// 新会計基準-賦金展開方法コード

	private ComboArray			newIjiKnriHyoJyoKbn		= new ComboArray();			// 新会計基準-維持管理費重要性区分

	private ComboArray			newEkmTeikHyoJyoKbn		= new ComboArray();			// 新会計基準-役務提供費用重要性区分

	private ComboArray			newGnkskHasuChseCd		= new ComboArray();			// 新会計基準-減価償却端数調整コード

	private ComboArray			newFknTnkiHasuChseCd	= new ComboArray();			// 新会計基準-賦金展開調整コード

	private String				newKnuAmtTutiUmFlg		= "";							// 新会計基準-購入額通知有無フラグ

	private String				condCosmosCode			= "";							// COSMOSコード(条件)

	private ComboArray			syosuKetasu				= new ComboArray();			// 利子率の精度

	private String				leasCompanyNm			= "";							// 開示先コード(条件)

	private String				leasCompany				= "";							// 絞込(条件)

	private int					pageNo					= 0;							// 現ページ保持

	private String				pdfCompanyName			= "";							// 帳票表示リース会社

	private String				pdfCompanyZip1			= "";							// 帳票表示郵便番号１

	private String				pdfCompanyZip2			= "";							// 帳票表示郵便番号２

	private String				pdfCompanyAddress1		= "";							// 帳票表示住所１

	private String				pdfCompanyAddress2		= "";							// 帳票表示住所２

	private String				pdfCompanyTel			= "";							// 帳票表示電話番号

	private LACSDispControlBean	dispControl				= new LACSDispControlBean();	// 表示制御

	private String				oldSrtKeiJgiFlg			= "";							// 旧会計基準-短期契約除外フラグ

	private String				oldRlsKeiJgiFlg			= "";							// 旧会計基準-再リース契約除外フラグ

	private String				oldSgkKeiJgiFlg			= "";							// 旧会計基準-少額契約除外フラグ

	private String				oldCytKaiJgiFlg			= "";							// 旧会計基準-中途解約除外フラグ

	private String				newSrtKeiJgiFlg			= "";							// 新会計基準-短期契約除外フラグ

	private String				newRlsKeiJgiFlg			= "";							// 新会計基準-再リース契約除外フラグ

	private String				newSgkKeiJgiFlg			= "";							// 新会計基準-少額契約除外フラグ

	private String				newCytKaiJgiFlg			= "";							// 新会計基準-中途解約除外フラグ

	private String				oldSumUnt				= "";							// 旧会計基準－集計単位 0：契約単位／1：資産単位

	private String				newSumUnt				= "";							// 新会計基準－集計単位 0：契約単位／1：資産単位
	
	//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 start
	
	private ComboArray			batchPrintTimingCd		= new ComboArray();				// 出力サイクルコード
	
	private String				lcShzkSho				= "";							// リース会社部署 所コード
	
	private String				lcShzkBu				= "";							// リース会社部署 部コード
	
	private String				lcShzkGrp				= "";							// リース会社部署 グループコード
	
	private String				lcShzkNm				= "";							// リース会社部署名称
	
	private String				lcTntCd					= "";							// リース会社担当者コード
	
	private String				lcTntNm					= "";							// リース会社担当者名		
	
	//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 end
	/**
	 * コンストラクタ.
	 */
	public LACSUserBean() {
	}

	/**
	 * 初期化.
	 */
	public void init() {
		this.userCosmosCode = "";

		super.init();
	}

	/**
	 * COSMOSコードを取得.
	 * 
	 * @return COSMOSコード
	 */
	public String getUserCosmosCode() {
		return this.userCosmosCode;
	}

	/**
	 * COSMOSコードを設定.
	 * 
	 * @param piUserCosmosCode
	 *            COSMOSコード
	 */
	public void setUserCosmosCode(String piUserCosmosCode) {
		this.userCosmosCode = piUserCosmosCode;
	}

	/**
	 * リースユーザー名称を取得.
	 * 
	 * @return リースユーザー名称
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * リースユーザー名称を設定.
	 * 
	 * @param piUserName
	 *            リースユーザー名称
	 */
	public void setUserName(String piUserName) {
		this.userName = piUserName;
	}

	/**
	 * リースユーザー郵便番号１を取得.
	 * 
	 * @return リースユーザー郵便番号１
	 */
	public String getUserZip1() {
		return this.userZip1;
	}

	/**
	 * リースユーザー郵便番号１を設定.
	 * 
	 * @param piUserZip1
	 *            リースユーザー郵便番号１
	 */
	public void setUserZip1(String piUserZip1) {
		this.userZip1 = piUserZip1;
	}

	/**
	 * リースユーザー郵便番号２を取得.
	 * 
	 * @return リースユーザー郵便番号２
	 */
	public String getUserZip2() {
		return this.userZip2;
	}

	/**
	 * リースユーザー郵便番号２を設定.
	 * 
	 * @param piUserZip2
	 *            リースユーザー郵便番号２
	 */
	public void setUserZip2(String piUserZip2) {
		this.userZip2 = piUserZip2;
	}

	/**
	 * リースユーザー住所１を取得.
	 * 
	 * @return リースユーザー住所１
	 */
	public String getUserAddress1() {
		return this.userAddress1;
	}

	/**
	 * リースユーザー住所１を設定.
	 * 
	 * @param piUserAddress1
	 *            リースユーザー住所１
	 */
	public void setUserAddress1(String piUserAddress1) {
		this.userAddress1 = piUserAddress1;
	}

	/**
	 * リースユーザー住所２を取得.
	 * 
	 * @return リースユーザー住所２
	 */
	public String getUserAddress2() {
		return this.userAddress2;
	}

	/**
	 * リースユーザー住所２を設定.
	 * 
	 * @param piUserAddress2
	 *            リースユーザー住所２
	 */
	public void setUserAddress2(String piUserAddress2) {
		this.userAddress2 = piUserAddress2;
	}

	/**
	 * リースユーザー電話番号を取得.
	 * 
	 * @return リースユーザー電話番号
	 */
	public String getUserTelNo() {
		return this.userTelNo;
	}

	/**
	 * リースユーザー電話番号を設定.
	 * 
	 * @param piUserTelNo
	 *            リースユーザー電話番号
	 */
	public void setUserTelNo(String piUserTelNo) {
		this.userTelNo = piUserTelNo;
	}

	/**
	 * リースユーザー担当者名を取得.
	 * 
	 * @return リースユーザー担当者名
	 */
	public String getUserTantoName() {
		return this.userTantoName;
	}

	/**
	 * リースユーザー担当者名を設定.
	 * 
	 * @param piUserTantoName
	 *            リースユーザー担当者名
	 */
	public void setUserTantoName(String piUserTantoName) {
		this.userTantoName = piUserTantoName;
	}

	/**
	 * 西暦和暦コードを取得.
	 * 
	 * @return 西暦和暦コード
	 */
	public ComboArray getSeirekiWarekiCode() {
		return this.seirekiWarekiCode;
	}

	/**
	 * 会計処理区分を取得.
	 * 
	 * @return 会計処理区分
	 */
	public ComboArray getAcShrKbn() {
		return this.acShrKbn;
	}

	/**
	 * 決算期FROM(月)を取得.
	 * 
	 * @return 決算期FROM(月)
	 */
	public String getKesnKiMM() {
		return this.kesnKiMM;
	}

	/**
	 * 決算期FROM(月)を設定.
	 * 
	 * @param piKesnKiMM
	 *            決算期FROM(月)
	 */
	public void setKesnKiMM(String piKesnKiMM) {
		this.kesnKiMM = piKesnKiMM;
	}

	/**
	 * 決算期FROM(日)を取得.
	 * 
	 * @return 決算期FROM(日)
	 */
	public String getKesnKiDD() {
		return this.kesnKiDD;
	}

	/**
	 * 決算期FROM(日)を設定.
	 * 
	 * @param piKesnKiDD
	 *            決算期FROM(日)
	 */
	public void setKesnKiDD(String piKesnKiDD) {
		this.kesnKiDD = piKesnKiDD;
	}

	/**
	 * 月次帳票-短期契約除外フラグを取得.
	 * 
	 * @return 月次帳票-短期契約除外フラグ
	 */
	public String getGtjSrtKeiJgiFlg() {
		return this.gtjSrtKeiJgiFlg;
	}

	/**
	 * 月次帳票-短期契約除外フラグを設定.
	 * 
	 * @param piGtjSrtKeiJgiFlg
	 *            月次帳票-短期契約除外フラグ
	 */
	public void setGtjSrtKeiJgiFlg(String piGtjSrtKeiJgiFlg) {
		this.gtjSrtKeiJgiFlg = piGtjSrtKeiJgiFlg;
	}

	/**
	 * 月次帳票-再リース契約除外フラグを取得.
	 * 
	 * @return 月次帳票-再リース契約除外フラグ
	 */
	public String getGtjRlsKeiJgiFlg() {
		return this.gtjRlsKeiJgiFlg;
	}

	/**
	 * 月次帳票-再リース契約除外フラグを設定.
	 * 
	 * @param piGtjRlsKeiJgiFlg
	 *            月次帳票-再リース契約除外フラグ
	 */
	public void setGtjRlsKeiJgiFlg(String piGtjRlsKeiJgiFlg) {
		this.gtjRlsKeiJgiFlg = piGtjRlsKeiJgiFlg;
	}

	/**
	 * 月次帳票-少額契約除外フラグを取得.
	 * 
	 * @return 月次帳票-少額契約除外フラグ
	 */
	public String getGtjSgkKeiJgiFlg() {
		return this.gtjSgkKeiJgiFlg;
	}

	/**
	 * 月次帳票-少額契約除外フラグを設定.
	 * 
	 * @param piGtjSgkKeiJgiFlg
	 *            月次帳票-少額契約除外フラグ
	 */
	public void setGtjSgkKeiJgiFlg(String piGtjSgkKeiJgiFlg) {
		this.gtjSgkKeiJgiFlg = piGtjSgkKeiJgiFlg;
	}

	/**
	 * 月次帳票-中途解約除外フラグを取得.
	 * 
	 * @return 月次帳票-中途解約除外フラグ
	 */
	public String getGtjCytKaiJgiFlg() {
		return this.gtjCytKaiJgiFlg;
	}

	/**
	 * 月次帳票-中途解約除外フラグを設定.
	 * 
	 * @param piGtjCytKaiJgiFlg
	 *            月次帳票-中途解約除外フラグ
	 */
	public void setGtjCytKaiJgiFlg(String piGtjCytKaiJgiFlg) {
		this.gtjCytKaiJgiFlg = piGtjCytKaiJgiFlg;
	}

	/**
	 * オンラインDBデータソース名を取得.
	 * 
	 * @return オンラインDBデータソース名
	 */
	public String getDataSource() {
		return this.dataSource;
	}

	/**
	 * オンラインDBデータソース名を設定.
	 * 
	 * @param piDataSource
	 *            オンラインDBデータソース名
	 */
	public void setDataSource(String piDataSource) {
		this.dataSource = piDataSource;
	}

	/**
	 * 旧会計基準-所有権移転有形償却方法コードを取得.
	 * 
	 * @return 旧会計基準-所有権移転有形償却方法コード
	 */
	public ComboArray getOldItenYukeiSkkHohoCd() {
		return this.oldItenYukeiSkkHohoCd;
	}

	/**
	 * 旧会計基準-所有権移転無形償却方法コードを取得.
	 * 
	 * @return 旧会計基準-所有権移転無形償却方法コード
	 */
	public ComboArray getOldItenMukeiSkkHohoCd() {
		return this.oldItenMukeiSkkHohoCd;
	}

	/**
	 * 旧会計基準-所有権移転外有形償却方法コードを取得.
	 * 
	 * @return 旧会計基準-所有権移転外有形償却方法コード
	 */
	public ComboArray getOldItengiYukeiSkkHohoCd() {
		return this.oldItengiYukeiSkkHohoCd;
	}

	/**
	 * 旧会計基準-所有権移転外無形償却方法コードを取得.
	 * 
	 * @return 旧会計基準-所有権移転外無形償却方法コード
	 */
	public ComboArray getOldItengiMukeiSkkHohoCd() {
		return this.oldItengiMukeiSkkHohoCd;
	}

	/**
	 * 旧会計基準-前払後払区分を取得.
	 * 
	 * @return 旧会計基準-前払後払区分
	 */
	public ComboArray getOldMbriAbriKbn() {
		return this.oldMbriAbriKbn;
	}

	/**
	 * 旧会計基準-利息計算方法コードを取得.
	 * 
	 * @return 旧会計基準-利息計算方法コード
	 */
	public ComboArray getOldRskClcHohoCd() {
		return this.oldRskClcHohoCd;
	}

	/**
	 * 旧会計基準-賦金展開方法コードを取得.
	 * 
	 * @return 旧会計基準-賦金展開方法コード
	 */
	public ComboArray getOldFknTnkiHohoCd() {
		return this.oldFknTnkiHohoCd;
	}

	/**
	 * 旧会計基準-維持管理費重要性区分を取得.
	 * 
	 * @return 旧会計基準-維持管理費重要性区分
	 */
	public ComboArray getOldIjiKnriHyoJyoKbn() {
		return this.oldIjiKnriHyoJyoKbn;
	}

	/**
	 * 旧会計基準-役務提供費用重要性区分を取得.
	 * 
	 * @return 旧会計基準-役務提供費用重要性区分
	 */
	public ComboArray getOldEkmTeikHyoJyoKbn() {
		return this.oldEkmTeikHyoJyoKbn;
	}

	/**
	 * 旧会計基準-減価償却端数調整コードを取得.
	 * 
	 * @return 旧会計基準-減価償却端数調整コード
	 */
	public ComboArray getOldGnkskHasuChseCd() {
		return this.oldGnkskHasuChseCd;
	}

	/**
	 * 旧会計基準-賦金展開調整コードを取得.
	 * 
	 * @return 旧会計基準-賦金展開調整コード
	 */
	public ComboArray getOldFknTnkiHasuChseCd() {
		return this.oldFknTnkiHasuChseCd;
	}

	/**
	 * 旧会計基準-購入額通知有無フラグを取得.
	 * 
	 * @return 旧会計基準-購入額通知有無フラグ
	 */
	public String getOldKnuAmtTutiUmFlg() {
		return this.oldKnuAmtTutiUmFlg;
	}

	/**
	 * 旧会計基準-購入額通知有無フラグを設定.
	 * 
	 * @param piOldKnuAmtTutiUmFlg
	 *            旧会計基準-購入額通知有無フラグ
	 */
	public void setOldKnuAmtTutiUmFlg(String piOldKnuAmtTutiUmFlg) {
		this.oldKnuAmtTutiUmFlg = piOldKnuAmtTutiUmFlg;
	}

	/**
	 * 新会計基準-所有権移転有形償却方法コードを取得.
	 * 
	 * @return 新会計基準-所有権移転有形償却方法コード
	 */
	public ComboArray getNewItenYukeiSkkHohoCd() {
		return this.newItenYukeiSkkHohoCd;
	}

	/**
	 * 新会計基準-所有権移転無形償却方法コードを取得.
	 * 
	 * @return 新会計基準-所有権移転無形償却方法コード
	 */
	public ComboArray getNewItenMukeiSkkHohoCd() {
		return this.newItenMukeiSkkHohoCd;
	}

	/**
	 * 新会計基準-所有権移転外有形償却方法コードを取得.
	 * 
	 * @return 新会計基準-所有権移転外有形償却方法コード
	 */
	public ComboArray getNewItengiYukeiSkkHohoCd() {
		return this.newItengiYukeiSkkHohoCd;
	}

	/**
	 * 新会計基準-所有権移転外無形償却方法コードを取得.
	 * 
	 * @return 新会計基準-所有権移転外無形償却方法コード
	 */
	public ComboArray getNewItengiMukeiSkkHohoCd() {
		return this.newItengiMukeiSkkHohoCd;
	}

	/**
	 * 新会計基準-前払後払区分を取得.
	 * 
	 * @return 新会計基準-前払後払区分
	 */
	public ComboArray getNewMbriAbriKbn() {
		return this.newMbriAbriKbn;
	}

	/**
	 * 新会計基準-利息計算方法コードを取得.
	 * 
	 * @return 新会計基準-利息計算方法コード
	 */
	public ComboArray getNewRskClcHohoCd() {
		return this.newRskClcHohoCd;
	}

	/**
	 * 新会計基準-賦金展開方法コードを取得.
	 * 
	 * @return 新会計基準-賦金展開方法コード
	 */
	public ComboArray getNewFknTnkiHohoCd() {
		return this.newFknTnkiHohoCd;
	}

	/**
	 * 新会計基準-維持管理費重要性区分を取得.
	 * 
	 * @return 新会計基準-維持管理費重要性区分
	 */
	public ComboArray getNewIjiKnriHyoJyoKbn() {
		return this.newIjiKnriHyoJyoKbn;
	}

	/**
	 * 新会計基準-役務提供費用重要性区分を取得.
	 * 
	 * @return 新会計基準-役務提供費用重要性区分
	 */
	public ComboArray getNewEkmTeikHyoJyoKbn() {
		return this.newEkmTeikHyoJyoKbn;
	}

	/**
	 * 新会計基準-減価償却端数調整コードを取得.
	 * 
	 * @return 新会計基準-減価償却端数調整コード
	 */
	public ComboArray getNewGnkskHasuChseCd() {
		return this.newGnkskHasuChseCd;
	}

	/**
	 * 新会計基準-賦金展開調整コードを取得.
	 * 
	 * @return 新会計基準-賦金展開調整コード
	 */
	public ComboArray getNewFknTnkiHasuChseCd() {
		return this.newFknTnkiHasuChseCd;
	}

	/**
	 * 新会計基準-購入額通知有無フラグを取得.
	 * 
	 * @return 新会計基準-購入額通知有無フラグ
	 */
	public String getNewKnuAmtTutiUmFlg() {
		return this.newKnuAmtTutiUmFlg;
	}

	/**
	 * 新会計基準-購入額通知有無フラグを設定.
	 * 
	 * @param piNewKnuAmtTutiUmFlg
	 *            新会計基準-購入額通知有無フラグ
	 */
	public void setNewKnuAmtTutiUmFlg(String piNewKnuAmtTutiUmFlg) {
		this.newKnuAmtTutiUmFlg = piNewKnuAmtTutiUmFlg;
	}

	/**
	 * COSMOSコード(条件)を取得.
	 * 
	 * @return COSMOSコード(条件)
	 */
	public String getCondCosmosCode() {
		return this.condCosmosCode;
	}

	/**
	 * COSMOSコード(条件)を設定.
	 * 
	 * @param piCondCosmosCode
	 *            COSMOSコード(条件)
	 */
	public void setCondCosmosCode(String piCondCosmosCode) {
		this.condCosmosCode = piCondCosmosCode;
	}

	/**
	 * 利子率の精度を取得.
	 * 
	 * @return 利子率の精度
	 */
	public ComboArray getSyosuKetasu() {
		return this.syosuKetasu;
	}

	/**
	 * 絞込(条件)を取得.
	 * 
	 * @return 絞込(条件)
	 */
	public String getleasCompany() {
		return this.leasCompany;
	}

	/**
	 * 絞込(条件)を設定.
	 * 
	 * @param piLeasCompany
	 *            絞込(条件)
	 */
	public void setleasCompany(String piLeasCompany) {
		this.leasCompany = piLeasCompany;
	}

	/**
	 * 開示先コード(条件)を取得.
	 * 
	 * @return 開示先コード(条件)
	 */
	public String getleasCompanyNm() {
		return this.leasCompanyNm;
	}

	/**
	 * 開示先コード(条件)を設定.
	 * 
	 * @param piLeasCompanyNm
	 *            開示先コード(条件)
	 */
	public void setleasCompanyNm(String piLeasCompanyNm) {
		this.leasCompanyNm = piLeasCompanyNm;
	}

	/**
	 * 現在ページを取得.
	 * 
	 * @return 現在ページ
	 */
	public int getPageNo() {
		return this.pageNo;
	}

	/**
	 * 現在ページを設定.
	 * 
	 * @param piPageNo
	 *            現在ページ
	 */
	public void setPageNo(int piPageNo) {
		this.pageNo = piPageNo;
	}

	/**
	 * 帳票表示リース会社を取得.
	 * 
	 * @return 帳票表示リース会社
	 */
	public String getPdfCompanyName() {
		return this.pdfCompanyName;
	}

	/**
	 * 帳票表示リース会社を設定.
	 * 
	 * @param piPdfCompanyName
	 *            帳票表示リース会社
	 */
	public void setPdfCompanyName(String piPdfCompanyName) {
		this.pdfCompanyName = piPdfCompanyName;
	}

	/**
	 * 帳票表示郵便番号１を取得.
	 * 
	 * @return 帳票表示郵便番号１
	 */
	public String getPdfCompanyZip1() {
		return this.pdfCompanyZip1;
	}

	/**
	 * 帳票表示郵便番号１を設定.
	 * 
	 * @param piPdfCompanyZip1
	 *            帳票表示郵便番号１
	 */
	public void setPdfCompanyZip1(String piPdfCompanyZip1) {
		this.pdfCompanyZip1 = piPdfCompanyZip1;
	}

	/**
	 * 帳票表示郵便番号２を取得.
	 * 
	 * @return 帳票表示郵便番号２
	 */
	public String getPdfCompanyZip2() {
		return this.pdfCompanyZip2;
	}

	/**
	 * 帳票表示郵便番号２を設定.
	 * 
	 * @param piPdfCompanyZip2
	 *            帳票表示郵便番号２
	 */
	public void setPdfCompanyZip2(String piPdfCompanyZip2) {
		this.pdfCompanyZip2 = piPdfCompanyZip2;
	}

	/**
	 * 帳票表示住所１を取得.
	 * 
	 * @return 帳票表示住所１
	 */
	public String getPdfCompanyAddress1() {
		return this.pdfCompanyAddress1;
	}

	/**
	 * 帳票表示住所１を設定.
	 * 
	 * @param piPdfCompanyAddress1
	 *            帳票表示住所１
	 */
	public void setPdfCompanyAddress1(String piPdfCompanyAddress1) {
		this.pdfCompanyAddress1 = piPdfCompanyAddress1;
	}

	/**
	 * 帳票表示住所２を取得.
	 * 
	 * @return 帳票表示住所２
	 */
	public String getPdfCompanyAddress2() {
		return this.pdfCompanyAddress2;
	}

	/**
	 * 帳票表示住所２を設定.
	 * 
	 * @param piPdfCompanyAddress2
	 *            帳票表示住所２
	 */
	public void setPdfCompanyAddress2(String piPdfCompanyAddress2) {
		this.pdfCompanyAddress2 = piPdfCompanyAddress2;
	}

	/**
	 * 帳票表示電話番号を取得.
	 * 
	 * @return 帳票表示電話番号
	 */
	public String getPdfCompanyTel() {
		return this.pdfCompanyTel;
	}

	/**
	 * 帳票表示電話番号を設定.
	 * 
	 * @param piPdfCompanyTel
	 *            帳票表示電話番号
	 */
	public void setPdfCompanyTel(String piPdfCompanyTel) {
		this.pdfCompanyTel = piPdfCompanyTel;
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
	 * 旧会計基準-短期契約除外フラグを取得.
	 * 
	 * @return 旧会計基準-短期契約除外フラグ
	 */
	public String getOldSrtKeiJgiFlg() {
		return this.oldSrtKeiJgiFlg;
	}

	/**
	 * 旧会計基準-短期契約除外フラグを設定.
	 * 
	 * @param piOldSrtKeiJgiFlg
	 *            旧会計基準-短期契約除外フラグ
	 */
	public void setOldSrtKeiJgiFlg(String piOldSrtKeiJgiFlg) {
		this.oldSrtKeiJgiFlg = piOldSrtKeiJgiFlg;
	}

	/**
	 * 旧会計基準-再リース契約除外フラグを取得.
	 * 
	 * @return 旧会計基準-再リース契約除外フラグ
	 */
	public String getOldRlsKeiJgiFlg() {
		return this.oldRlsKeiJgiFlg;
	}

	/**
	 * 旧会計基準-再リース契約除外フラグを設定.
	 * 
	 * @param piOldRlsKeiJgiFlg
	 *            旧会計基準-再リース契約除外フラグ
	 */
	public void setOldRlsKeiJgiFlg(String piOldRlsKeiJgiFlg) {
		this.oldRlsKeiJgiFlg = piOldRlsKeiJgiFlg;
	}

	/**
	 * 旧会計基準-少額契約除外フラグを取得.
	 * 
	 * @return 旧会計基準-少額契約除外フラグ
	 */
	public String getOldSgkKeiJgiFlg() {
		return this.oldSgkKeiJgiFlg;
	}

	/**
	 * 旧会計基準-少額契約除外フラグを設定.
	 * 
	 * @param piOldSgkKeiJgiFlg
	 *            旧会計基準-少額契約除外フラグ
	 */
	public void setOldSgkKeiJgiFlg(String piOldSgkKeiJgiFlg) {
		this.oldSgkKeiJgiFlg = piOldSgkKeiJgiFlg;
	}

	/**
	 * 旧会計基準-中途解約除外フラグを取得.
	 * 
	 * @return 旧会計基準-中途解約除外フラグ
	 */
	public String getOldCytKaiJgiFlg() {
		return this.oldCytKaiJgiFlg;
	}

	/**
	 * 旧会計基準-中途解約除外フラグを設定.
	 * 
	 * @param piOldCytKaiJgiFlg
	 *            旧会計基準-中途解約除外フラグ
	 */
	public void setOldCytKaiJgiFlg(String piOldCytKaiJgiFlg) {
		this.oldCytKaiJgiFlg = piOldCytKaiJgiFlg;
	}

	/**
	 * 新会計基準-短期契約除外フラグを取得.
	 * 
	 * @return 新会計基準-短期契約除外フラグ
	 */
	public String getNewSrtKeiJgiFlg() {
		return this.newSrtKeiJgiFlg;
	}

	/**
	 * 新会計基準-短期契約除外フラグを設定.
	 * 
	 * @param piNewSrtKeiJgiFlg
	 *            新会計基準-短期契約除外フラグ
	 */
	public void setNewSrtKeiJgiFlg(String piNewSrtKeiJgiFlg) {
		this.newSrtKeiJgiFlg = piNewSrtKeiJgiFlg;
	}

	/**
	 * 新会計基準-再リース契約除外フラグを取得.
	 * 
	 * @return 新会計基準-再リース契約除外フラグ
	 */
	public String getNewRlsKeiJgiFlg() {
		return this.newRlsKeiJgiFlg;
	}

	/**
	 * 新会計基準-再リース契約除外フラグを設定.
	 * 
	 * @param piNewRlsKeiJgiFlg
	 *            新会計基準-再リース契約除外フラグ
	 */
	public void setNewRlsKeiJgiFlg(String piNewRlsKeiJgiFlg) {
		this.newRlsKeiJgiFlg = piNewRlsKeiJgiFlg;
	}

	/**
	 * 新会計基準-少額契約除外フラグを取得.
	 * 
	 * @return 新会計基準-少額契約除外フラグ
	 */
	public String getNewSgkKeiJgiFlg() {
		return this.newSgkKeiJgiFlg;
	}

	/**
	 * 新会計基準-少額契約除外フラグを設定.
	 * 
	 * @param piNewSgkKeiJgiFlg
	 *            新会計基準-少額契約除外フラグ
	 */
	public void setNewSgkKeiJgiFlg(String piNewSgkKeiJgiFlg) {
		this.newSgkKeiJgiFlg = piNewSgkKeiJgiFlg;
	}

	/**
	 * 新会計基準-中途解約除外フラグを取得.
	 * 
	 * @return 新会計基準-中途解約除外フラグ
	 */
	public String getNewCytKaiJgiFlg() {
		return this.newCytKaiJgiFlg;
	}

	/**
	 * 新会計基準-中途解約除外フラグを設定.
	 * 
	 * @param piNewCytKaiJgiFlg
	 *            新会計基準-中途解約除外フラグ
	 */
	public void setNewCytKaiJgiFlg(String piNewCytKaiJgiFlg) {
		this.newCytKaiJgiFlg = piNewCytKaiJgiFlg;
	}

	/**
	 * 旧会計基準－集計単位を取得.
	 * 
	 * @return 旧会計基準－集計単位
	 */
	public String getOldSumUnt() {
		return this.oldSumUnt;
	}

	/**
	 * 旧会計基準－集計単位を設定.
	 * 
	 * @param piOldSumUnt
	 *            旧会計基準－集計単位
	 */
	public void setOldSumUnt(String piOldSumUnt) {
		this.oldSumUnt = piOldSumUnt;
	}

	/**
	 * 新会計基準－集計単位を取得.
	 * 
	 * @return 新会計基準－集計単位
	 */
	public String getNewSumUnt() {
		return this.newSumUnt;
	}

	/**
	 * 新会計基準－集計単位を設定.
	 * 
	 * @param piNewSumUnt
	 *            新会計基準－集計単位
	 */
	public void setNewSumUnt(String piNewSumUnt) {
		this.newSumUnt = piNewSumUnt;
	}
	
	//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 start
	
	/**
	 * 出力サイクルを取得.
	 * @return 出力サイクル
	 */
	public ComboArray getBatchPrintTimingCd() {
		return this.batchPrintTimingCd;
	}

	/**
	 * リース会社部署 所コードを取得.
	 * 
	 * @return リース会社部署 所コード
	 */
	public String getLcShzkSho() {
		return lcShzkSho;
	}

	/**
	 * リース会社部署 所コードを設定.
	 * 
	 * @param lcShzkSho
	 *            リース会社部署 所コード
	 */
	public void setLcShzkSho(String lcShzkSho) {
		this.lcShzkSho = lcShzkSho;
	}

	/**
	 * リース会社部署 部コードを取得.
	 * 
	 * @return リース会社部署 部コード
	 */
	public String getLcShzkBu() {
		return lcShzkBu;
	}

	/**
	 * リース会社部署 部コードを設定.
	 * 
	 * @param lcShzkBu
	 *            リース会社部署 部コード
	 */
	public void setLcShzkBu(String lcShzkBu) {
		this.lcShzkBu = lcShzkBu;
	}

	/**
	 * リース会社部署 グループコードを取得.
	 * 
	 * @return リース会社部署 グループコード
	 */
	public String getLcShzkGrp() {
		return lcShzkGrp;
	}

	/**
	 * リース会社部署 グループコードを設定.
	 * 
	 * @param lcShzkGrp
	 *            リース会社部署 グループコード
	 */
	public void setLcShzkGrp(String lcShzkGrp) {
		this.lcShzkGrp = lcShzkGrp;
	}

	/**
	 * リース会社部署名称を取得.
	 * 
	 * @return リース会社部署名称単位
	 */
	public String getLcShzkNm() {
		return lcShzkNm;
	}

	/**
	 * リース会社部署名称単位を設定.
	 * 
	 * @param lcShzkNm
	 *            リース会社部署名称単位
	 */
	public void setLcShzkNm(String lcShzkNm) {
		this.lcShzkNm = lcShzkNm;
	}

	/**
	 * リース会社担当者コードを取得.
	 * 
	 * @return リース会社担当者コード
	 */
	public String getLcTntCd() {
		return lcTntCd;
	}

	/**
	 * リース会社担当者コードを設定.
	 * 
	 * @param lcTntCd
	 *            リース会社担当者コード
	 */
	public void setLcTntCd(String lcTntCd) {
		this.lcTntCd = lcTntCd;
	}

	/**
	 * リース会社担当者名を取得.
	 * 
	 * @return リース会社担当者名
	 */
	public String getLcTntNm() {
		return lcTntNm;
	}

	/**
	 * リース会社担当者名を設定.
	 * 
	 * @param lcTntNm
	 *           リース会社担当者名
	 */
	public void setLcTntNm(String lcTntNm) {
		this.lcTntNm = lcTntNm;
	}
	
	//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 end
}
