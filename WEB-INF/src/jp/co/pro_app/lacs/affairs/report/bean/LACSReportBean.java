package jp.co.pro_app.lacs.affairs.report.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSBeanBase;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSDateBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSReportDetailBean;

/**
 * 帳票出力Bean.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSReportBean extends LACSBeanBase {

	private static final long serialVersionUID = 1L;

	private String					keiyakuNo		= "";							// 契約番号

	private String					hyoujiKeiyakuNo	= "";							// 表示用契約番号

	private String					bukkenNo		= "";							// 物件番号

	private String					bukkenEdaNo		= "";							// 物件枝番号

	private LACSDateBean			termFrom		= new LACSDateBean();			// 期間開始

	private String					termNum			= "";							// 期間

	private String					termNum0		= "";							// 期間

	private LACSDateBean			termTo0			= new LACSDateBean();			// 期間終了

	private LACSDateBean			termTo1			= new LACSDateBean();			// 第1四半期

	private LACSDateBean			termTo2			= new LACSDateBean();			// 半期

	private LACSDateBean			termTo3			= new LACSDateBean();			// 第3四半期

	private LACSDateBean			termTo4			= new LACSDateBean();			// 通期

	private LACSDateBean			termTo			= new LACSDateBean();			// 処理用期間終了
	
	@SuppressWarnings("unused")
	private LACSDateBean			basedate	    = new LACSDateBean();			// 基準日

	private String					quarter			= "";							// 四半期

	private String					oldKeiyakuGaku	= "0";							// 旧会計基準-少額資産 0：除く 1：除かない

	private String					oldLeaseKikan	= "0";							// 旧会計基準-リース期間１年未満 0：除く 1：除かない

	private String					oldSaiLease		= "0";							// 旧会計基準-再リース契約 0：除く 1：除かない

	private String					oldTyutoKaiyaku	= "0";							// 旧会計基準-中途解約物件 0：除く 1：除かない

	private String					newKeiyakuGaku	= "0";							// 新会計基準-契約金額３００万円以下 0：除く 1：除かない

	private String					newLeaseKikan	= "0";							// 新会計基準-リース期間１年未満 0：除く 1：除かない

	private String					newSaiLease		= "0";							// 新会計基準-再リース契約 0：除く 1：除かない

	private String					newTyutoKaiyaku	= "0";							// 新会計基準-中途解約物件 0：除く 1：除かない

	private LACSReportDetailBean	gensenOld		= new LACSReportDetailBean();	// 注記源泉情報(旧)

	private LACSReportDetailBean	gensenNew		= new LACSReportDetailBean();	// 注記源泉情報(新)

	private LACSReportDetailBean	goukeiOld		= new LACSReportDetailBean();	// リース会計注記合計表"(旧)

	private LACSReportDetailBean	goukeiNew		= new LACSReportDetailBean();	// リース会計注記合計表"(新)

	private LACSReportDetailBean	mikeikaBOld		= new LACSReportDetailBean();	// 未経過リース料期末残高別表(旧)

	private LACSReportDetailBean	mikeikaBNew		= new LACSReportDetailBean();	// 未経過リース料期末残高別表(新)

	private LACSReportDetailBean	genkaOld		= new LACSReportDetailBean();	// リース会計資料（減価償却費）(旧)

	private LACSReportDetailBean	genkaNew		= new LACSReportDetailBean();	// リース会計資料（減価償却費）(新)

	private LACSReportDetailBean	shiharaiOld		= new LACSReportDetailBean();	// リース会計資料（支払リース料等）(旧)

	private LACSReportDetailBean	shiharaiNew		= new LACSReportDetailBean();	// リース会計資料（支払リース料等）(新)

	private LACSReportDetailBean	schedule		= new LACSReportDetailBean();	// リース料支払スケジュール表（物件単位）

	private LACSReportDetailBean	tyuki			= new LACSReportDetailBean();	// 注記書類作成基準書

	private String					kaikeiSyori		= "0";							// 会計処理区分 0：賃貸借処理(詳細注記) 1：賃貸借処理(簡略注記)

	private String					kaiknoTermkei	= "0";							// 解約可能期間未経過リース料計上  0：計上しない 1：計上する

	private int						newACCount		= 0;							// 新会計基準契約数

	private int						oldACCount		= 0;							// 旧会計基準契約数

	private int						nextFocus		= 0;							// 次のフォーカス

	private String					oldSumUnt		= "";							// 旧会計基準－集計単位 初期値1、0：契約単位／1：資産単位

	private String					newSumUnt		= "";							// 新会計基準－集計単位 初期値1、0：契約単位／1：資産単位
	
	// 20200615 arai 追加
	private LACSReportDetailBean	kizituGoukeiNew = new LACSReportDetailBean();	// 期日別予定表(合計表)(新)

	private LACSReportDetailBean	kizituGoukeiOld  = new LACSReportDetailBean();	// 期日別予定表(合計表)(旧)
	
	private LACSReportDetailBean	kizituSaimuNew = new LACSReportDetailBean();	// 期日別予定表(債務)(新)

	private LACSReportDetailBean	kizituSaimuOld  = new LACSReportDetailBean();	// 期日別予定表(債務)(旧)

	private LACSReportDetailBean	kizituSisanNew = new LACSReportDetailBean();	// 期日別予定表(資産)(新)

	private LACSReportDetailBean	kizituSisanOld  = new LACSReportDetailBean();	// 期日別予定表(資産)(旧)


	/**
	 * コンストラクタ.
	 */
	public LACSReportBean() {
	}

	/**
	 * 初期化.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 */
	public void init(LACSCommonBean piCommonBean) {

		this.quarter = "0";
		this.termNum0 = "1";
		this.oldKeiyakuGaku = "0";
		this.oldLeaseKikan = "0";
		this.oldSaiLease = "0";
		this.oldTyutoKaiyaku = "0";
		this.newKeiyakuGaku = "0";
		this.newLeaseKikan = "0";
		this.newSaiLease = "0";
		this.newTyutoKaiyaku = "0";
		this.kaikeiSyori = "0";
		this.kaiknoTermkei = "0";
		this.keiyakuNo = "";
		this.hyoujiKeiyakuNo = "";
		this.bukkenNo = "";
		this.bukkenEdaNo = "";

		this.termFrom = new LACSDateBean(piCommonBean);
		this.termFrom.setName("termFrom");
		this.termFrom.setOnChange("focusNext(this)");

		this.termTo0 = new LACSDateBean(piCommonBean);
		this.termTo0.setName("termTo0");
		this.termTo0.setPlane(true);

		this.termTo1 = new LACSDateBean(piCommonBean);
		this.termTo1.setName("termTo1");
		this.termTo1.setPlane(true);

		this.termTo2 = new LACSDateBean(piCommonBean);
		this.termTo2.setName("termTo2");
		this.termTo2.setPlane(true);

		this.termTo3 = new LACSDateBean(piCommonBean);
		this.termTo3.setName("termTo3");
		this.termTo3.setPlane(true);

		this.termTo4 = new LACSDateBean(piCommonBean);
		this.termTo4.setName("termTo4");
		this.termTo4.setPlane(true);

		this.termTo = new LACSDateBean(piCommonBean);

		this.newACCount = 1;
		this.oldACCount = 1;

		this.oldSumUnt = "0";
		this.newSumUnt = "1";

		gensenOld.init(0);
		gensenNew.init(0);

		goukeiOld.init();
		goukeiNew.init();

		mikeikaBOld.init();
		mikeikaBNew.init();
		
		genkaOld.init();
		genkaNew.init();
		shiharaiOld.init();
		shiharaiNew.init();
		schedule.init(0);
		tyuki.init();
		
		// arai 20200615 追加		
	    kizituGoukeiNew.init();
		kizituGoukeiOld.init();
		kizituSaimuNew.init();
		kizituSaimuOld.init();
		kizituSisanNew.init();
		kizituSisanOld.init();
        
		super.init();
	}

	/**
	 * リース会計注記合計表Beanを追加.
	 * 
	 * @param piBean
	 *            リース会計注記合計表Bean
	 */
	public void addGoukeiBean(LACSReportGoukeiBean piBean) {
		super.add(piBean);
	}
	
	//ADD Ren.SL LACS帳票バッチ対応 2013/05/30 start
	/**
	 * リース会計注記合計表Beanを追加.
	 * 
	 * @param piBean
	 *            リース会計注記合計表Bean
	 */
	public void addAtesakiBean(LACSReportAtesakiBean piBean) {
		super.add(piBean);
	}
	//ADD Ren.SL LACS帳票バッチ対応 2013/05/30 end
	
	//ADD Ren.SL LACS帳票バッチ対応 2013/05/30 start
	/**
	 * リース会計注記合計表Beanを追加.
	 * 
	 * @param piBean
	 *            リース会計注記合計表Bean
	 */
	public LACSReportAtesakiBean getAtesakiBean(int piIdx) {
		return (LACSReportAtesakiBean)super.get(piIdx);
	}
	//ADD Ren.SL LACS帳票バッチ対応 2013/05/30 end
		
	/**
	 * リース会計注記合計表Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return リース会計注記合計表Bean
	 */
	public LACSReportGoukeiBean getGoukeiBean(int piIdx) {
		return (LACSReportGoukeiBean)super.get(piIdx);
	}

	/**
	 * 未経過リース料期末残高別表Beanを追加.
	 * 
	 * @param piBean
	 *            未経過リース料期末残高別表Bean
	 */
	public void addMikeikaBBean(LACSReportMikeikaBBean piBean) {
		super.add(piBean);
	}

	/**
	 * 未経過リース料期末残高別表Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 未経過リース料期末残高別表Bean
	 */
	public LACSReportMikeikaBBean getMikeikaBBean(int piIdx) {
		return (LACSReportMikeikaBBean)super.get(piIdx);
	}

	/**
	 * リース会計資料（減価償却費） Beanを追加.
	 * 
	 * @param piBean
	 *            リース会計資料（減価償却費） Bean
	 */
	public void addGenkaBean(LACSReportGenkaBean piBean) {
		super.add(piBean);
	}

	/**
	 * リース会計資料（減価償却費） Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return リース会計資料（減価償却費） Bean
	 */
	public LACSReportGenkaBean getGenkaBean(int piIdx) {
		return (LACSReportGenkaBean)super.get(piIdx);
	}

	/**
	 * リース会計資料（支払リース料等） Beanを追加.
	 * 
	 * @param piBean
	 *            リース会計資料（支払リース料等） Bean
	 */
	public void addSiharaiBean(LACSReportSiharaiBean piBean) {
		super.add(piBean);
	}

	/**
	 * リース会計資料（支払リース料等） Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return リース会計資料（支払リース料等） Bean
	 */
	public LACSReportSiharaiBean getSiharaiBean(int piIdx) {
		return (LACSReportSiharaiBean)super.get(piIdx);
	}

	/**
	 * リース会計資料（物件単位） Beanを追加.
	 * 
	 * @param piBean
	 *            リース会計資料（物件単位） Bean
	 */
	public void addBukkenBean(LACSReportBukkenBean piBean) {
		super.add(piBean);
	}

	/**
	 * リース会計資料（物件単位） Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return リース会計資料（物件単位） Bean
	 */
	public LACSReportBukkenBean getBukkenBean(int piIdx) {
		return (LACSReportBukkenBean)super.get(piIdx);
	}

	/**
	 * 注記書類作成基準書 Beanを追加.
	 * 
	 * @param piBean
	 *            注記書類作成基準書 Bean
	 */
	public void addTyukiBean(LACSReportTyukiBean piBean) {
		super.add(piBean);
	}

	/**
	 * 注記書類作成基準書 Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 注記書類作成基準書 Bean
	 */
	public LACSReportTyukiBean getTyukiBean(int piIdx) {
		return (LACSReportTyukiBean)super.get(piIdx);
	}
	
	// 20200617 arai 追加
	/**
	 * 期日別予定表(合計表) Beanを追加.
	 * 
	 * @param piBean
	 *            期日別予定表(合計表) Bean
	 */
	public void addKizituGoukei(LACSReportKizituTotalBean piBean) {
		super.add(piBean);
	}
	
	/**
	 * 期日別予定表(合計表) Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 期日別予定表(合計表) Bean
	 */
	public LACSReportKizituTotalBean getKizituGoukei(int piIdx) {
		return (LACSReportKizituTotalBean)super.get(piIdx);
	}
	
	/**
	 * 期日別予定表(債務) Beanを追加.
	 * 
	 * @param piBean
	 *            期日別予定表(債務) Bean
	 */
	public void addKizituSaimu(LACSReportKizituSaimuBean piBean) {
		super.add(piBean);
	}
	
	/**
	 * 期日別予定表(債務) Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 期日別予定表(債務) Bean
	 */
	public LACSReportKizituSaimuBean getKizituSaimu(int piIdx) {
		return (LACSReportKizituSaimuBean)super.get(piIdx);
	}
	
	/**
	 * 期日別予定表(資産) Beanを追加.
	 * 
	 * @param piBean
	 *            期日別予定表(資産) Bean
	 */
	public void addKizituSisan(LACSReportKizituSisanBean piBean) {
		super.add(piBean);
	}
	
	/**
	 * 期日別予定表(資産) Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 期日別予定表(資産) Bean
	 */
	public LACSReportKizituSisanBean getKizituSisan(int piIdx) {
		return (LACSReportKizituSisanBean)super.get(piIdx);
	}
	
	/**
	 * 四半期を取得.
	 * 
	 * @return 四半期
	 */
	public String getQuarter() {
		return quarter;
	}

	/**
	 * 四半期を設定.
	 * 
	 * @param piQuarter
	 *            四半期
	 */
	public void setQuarter(String piQuarter) {
		this.quarter = piQuarter;
	}

	/**
	 * 旧会計基準-少額資産を取得.
	 * 
	 * @return 旧会計基準-少額資産
	 */
	public String getOldKeiyakuGaku() {
		return this.oldKeiyakuGaku;
	}

	/**
	 * 旧会計基準-少額資産を設定.
	 * 
	 * @param piOldKeiyakuGaku
	 *            旧会計基準-少額資産
	 */
	public void setOldKeiyakuGaku(String piOldKeiyakuGaku) {
		this.oldKeiyakuGaku = piOldKeiyakuGaku;
	}

	/**
	 * 旧会計基準-リース期間１年未満を取得.
	 * 
	 * @return 旧会計基準-リース期間１年未満
	 */
	public String getOldLeaseKikan() {
		return this.oldLeaseKikan;
	}

	/**
	 * 旧会計基準-リース期間１年未満を設定.
	 * 
	 * @param piOldLeaseKikan
	 *            旧会計基準-リース期間１年未満
	 */

	public void setOldLeaseKikan(String piOldLeaseKikan) {
		this.oldLeaseKikan = piOldLeaseKikan;
	}

	/**
	 * 旧会計基準-再リース契約を取得.
	 * 
	 * @return 旧会計基準-再リース契約
	 */
	public String getOldSaiLease() {
		return this.oldSaiLease;
	}

	/**
	 * 旧会計基準-再リース契約を設定.
	 * 
	 * @param piOldSaiLease
	 *            旧会計基準-再リース契約
	 */
	public void setOldSaiLease(String piOldSaiLease) {
		this.oldSaiLease = piOldSaiLease;
	}

	/**
	 * 旧会計基準-中途解約物件を取得.
	 * 
	 * @return 旧会計基準-中途解約物件
	 */
	public String getOldTyutoKaiyaku() {
		return this.oldTyutoKaiyaku;
	}

	/**
	 * 旧会計基準-中途解約物件を設定.
	 * 
	 * @param piOldTyutoKaiyaku
	 *            旧会計基準-中途解約物件
	 */
	public void setOldTyutoKaiyaku(String piOldTyutoKaiyaku) {
		this.oldTyutoKaiyaku = piOldTyutoKaiyaku;
	}

	/**
	 * 新会計基準-少額資産を取得.
	 * 
	 * @return 新会計基準-少額資産
	 */
	public String getNewKeiyakuGaku() {
		return this.newKeiyakuGaku;
	}

	/**
	 * 新会計基準-少額資産を設定.
	 * 
	 * @param piNewKeiyakuGaku
	 *            新会計基準-少額資産
	 */
	public void setNewKeiyakuGaku(String piNewKeiyakuGaku) {
		this.newKeiyakuGaku = piNewKeiyakuGaku;
	}

	/**
	 * 新会計基準-リース期間１年内を取得.
	 * 
	 * @return 新会計基準-リース期間１年内
	 */
	public String getNewLeaseKikan() {
		return this.newLeaseKikan;
	}

	/**
	 * 新会計基準-リース期間１年内を設定.
	 * 
	 * @param piNewLeaseKikan
	 *            新会計基準-リース期間１年内
	 */

	public void setNewLeaseKikan(String piNewLeaseKikan) {
		this.newLeaseKikan = piNewLeaseKikan;
	}

	/**
	 * 新会計基準-再リース契約を取得.
	 * 
	 * @return 新会計基準-再リース契約
	 */
	public String getNewSaiLease() {
		return this.newSaiLease;
	}

	/**
	 * 新会計基準-再リース契約を設定.
	 * 
	 * @param piNewSaiLease
	 *            新会計基準-再リース契約
	 */
	public void setNewSaiLease(String piNewSaiLease) {
		this.newSaiLease = piNewSaiLease;
	}

	/**
	 * 新会計基準-中途解約物件を取得.
	 * 
	 * @return 新会計基準-中途解約物件
	 */
	public String getNewTyutoKaiyaku() {
		return this.newTyutoKaiyaku;
	}

	/**
	 * 新会計基準-中途解約物件を設定.
	 * 
	 * @param piNewTyutoKaiyaku
	 *            新会計基準-中途解約物件
	 */
	public void setNewTyutoKaiyaku(String piNewTyutoKaiyaku) {
		this.newTyutoKaiyaku = piNewTyutoKaiyaku;
	}

	/**
	 * 会計処理区分を取得.
	 * 
	 * @return 会計処理区分
	 */
	public String getKaikeiSyori() {
		return this.kaikeiSyori;
	}

	/**
	 * 会計処理区分を設定.
	 * 
	 * @param piKaikeiSyori
	 *            会計処理区分
	 */
	public void setKaikeiSyori(String piKaikeiSyori) {
		this.kaikeiSyori = piKaikeiSyori;
	}

	/**
	 * 解約可能期間未経過リース料計上有無を取得.
	 * 
	 * @return 解約可能期間未経過リース料計上有無
	 */
	public String getkaiknoTermkei() {
		return this.kaiknoTermkei;
	}

	/**
	 * 解約可能期間未経過リース料計上有無を設定.
	 * 
	 * @param piKaiknoTermkei
	 *            解約可能期間未経過リース料計上有無
	 */
	public void setKaiknoTermkei(String piKaiknoTermkei) {
		this.kaiknoTermkei = piKaiknoTermkei;
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
	 * 注記源泉情報(旧)を取得.
	 * 
	 * @return 注記源泉情報(旧)
	 */
	public LACSReportDetailBean getGensenOld() {
		return this.gensenOld;
	}

	/**
	 * 注記源泉情報(新)を取得.
	 * 
	 * @return 注記源泉情報(新)
	 */
	public LACSReportDetailBean getGensenNew() {
		return this.gensenNew;
	}

	/**
	 * リース会計注記合計表"(旧)を取得.
	 * 
	 * @return リース会計注記合計表"(旧)
	 */
	public LACSReportDetailBean getGoukeiOld() {
		return this.goukeiOld;
	}

	/**
	 * リース会計注記合計表"(新)を取得.
	 * 
	 * @return リース会計注記合計表"(新)
	 */
	public LACSReportDetailBean getGoukeiNew() {
		return this.goukeiNew;
	}

	/**
	 * 未経過リース料期末残高別表(旧)を取得.
	 * 
	 * @return 未経過リース料期末残高別表(旧)
	 */
	public LACSReportDetailBean getMikeikaBOld() {
		return this.mikeikaBOld;
	}

	/**
	 * 未経過リース料期末残高別表(新)を取得.
	 * 
	 * @return 未経過リース料期末残高別表(新)
	 */
	public LACSReportDetailBean getMikeikaBNew() {
		return this.mikeikaBNew;
	}

	/**
	 * リース会計資料（減価償却費）(旧)を取得.
	 * 
	 * @return リース会計資料（減価償却費）(旧)
	 */
	public LACSReportDetailBean getGenkaOld() {
		return this.genkaOld;
	}

	/**
	 * リース会計資料（減価償却費）(新)を取得.
	 * 
	 * @return リース会計資料（減価償却費）(新)
	 */
	public LACSReportDetailBean getGenkaNew() {
		return this.genkaNew;
	}

	/**
	 * リース会計資料（支払リース料等）(旧)を取得.
	 * 
	 * @return リース会計資料（支払リース料等）(旧)
	 */
	public LACSReportDetailBean getShiharaiOld() {
		return this.shiharaiOld;
	}

	/**
	 * リース会計資料（支払リース料等）(新)を取得.
	 * 
	 * @return リース会計資料（支払リース料等）(新)
	 */
	public LACSReportDetailBean getShiharaiNew() {
		return this.shiharaiNew;
	}
	
	// 20200615 arai 追加 start
	/**
	 * 期日別予定表(合計表）(新)を取得.
	 * 
	 * @return 期日別予定表（合計表）(新)
	 */
	public LACSReportDetailBean getKizituGoukeiNew() {
		return this.kizituGoukeiNew;
	}
	
	/**
	 * 期日別予定表（合計表）(旧)を取得.
	 * 
	 * @return 期日別予定表（合計表）(旧)
	 */
	public LACSReportDetailBean getKizituGoukeiOld() {
		return this.kizituGoukeiOld;
	}

	/**
	 * 期日別予定表（債務）(新)を取得.
	 * 
	 * @return 期日別予定表（債務）(新)
	 */
	public LACSReportDetailBean getKizituSaimuNew() {
		return this.kizituSaimuNew;
	}
	
	/**
	 * 期日別予定表（債務）(旧)を取得.
	 * 
	 * @return 期日別予定表（債務）(旧)
	 */
	public LACSReportDetailBean getKizituSaimuOld() {
		return this.kizituSaimuOld;
	}

	/**
	 * 期日別予定表（資産）(新)を取得.
	 * 
	 * @return 期日別予定表（資産）(新)
	 */
	public LACSReportDetailBean getKizituSisanNew() {
		return this.kizituSisanNew;
	}
	
	/**
	 * 期日別予定表（資産）(旧)を取得.
	 * 
	 * @return 期日別予定表（資産）(旧)
	 */
	public LACSReportDetailBean getKizituSisanOld() {
		return this.kizituSisanOld;
	}
	// 20200615 arai 追加 end

	/**
	 * リース料支払スケジュール表（物件単位）を取得.
	 * 
	 * @return リース料支払スケジュール表（物件単位）
	 */
	public LACSReportDetailBean getSchedule() {
		return this.schedule;
	}

	/**
	 * 注記書類作成基準書を取得.
	 * 
	 * @return 注記書類作成基準書
	 */
	public LACSReportDetailBean getTyuki() {
		return this.tyuki;
	}

	/**
	 * 新会計基準契約数を取得.
	 * 
	 * @return 新会計基準契約数
	 */
	public int getNewACCount() {
		return this.newACCount;
	}

	/**
	 * 新会計基準契約数を設定.
	 * 
	 * @param piNewACCount
	 *            新会計基準契約数
	 */
	public void setNewACCount(int piNewACCount) {
		this.newACCount = piNewACCount;
	}

	/**
	 * 旧会計基準契約数を取得.
	 * 
	 * @return 旧会計基準契約数
	 */
	public int getOldACCount() {
		return this.oldACCount;
	}

	/**
	 * 旧会計基準契約数を設定.
	 * 
	 * @param piOldACCount
	 *            旧会計基準契約数
	 */
	public void setOldACCount(int piOldACCount) {
		this.oldACCount = piOldACCount;
	}

	/**
	 * 期間開始を取得.
	 * 
	 * @return 期間開始
	 */
	public LACSDateBean getTermFrom() {
		return this.termFrom;
	}

	/**
	 * 期間終了を取得.
	 * 
	 * @return 期間終了
	 */
	public LACSDateBean getTermTo0() {
		return this.termTo0;
	}

	/**
	 * 期間終了を設定.
	 * 
	 * @param piTermTo
	 *            期間終了
	 */
	public void setTermTo0(LACSDateBean piTermTo) {
		this.termTo0 = piTermTo;
	}
	
	/**
	 * 基準日を設定.
	 * 
	 * @param piBaseDate
	 *            基準日
	 */
	public void setBaseDate(LACSDateBean piBaseDate) {
		this.basedate = piBaseDate;
	}
	

	/**
	 * 第1四半期を取得.
	 * 
	 * @return 第1四半期
	 */
	public LACSDateBean getTermTo1() {
		return this.termTo1;
	}

	/**
	 * 半期を取得.
	 * 
	 * @return 半期
	 */
	public LACSDateBean getTermTo2() {
		return this.termTo2;
	}

	/**
	 * 第3四半期を取得.
	 * 
	 * @return 第3四半期
	 */
	public LACSDateBean getTermTo3() {
		return this.termTo3;
	}

	/**
	 * 通期を取得.
	 * 
	 * @return 通期
	 */
	public LACSDateBean getTermTo4() {
		return this.termTo4;
	}

	/**
	 * 処理用期間終了を取得.
	 * 
	 * @return 処理用期間終了
	 */
	public LACSDateBean getTermTo() {
		return this.termTo;
	}

	/**
	 * 次のフォーカスを取得.
	 * 
	 * @return 次のフォーカス
	 */
	public int getNextFocus() {
		return this.nextFocus;
	}

	/**
	 * 次のフォーカスを設定.
	 * 
	 * @param piNextFocus
	 *            次のフォーカス
	 */
	public void setNextFocus(int piNextFocus) {
		this.nextFocus = piNextFocus;
	}

	/**
	 * 期間(手入力)を取得.
	 * 
	 * @return 期間(手入力)
	 */
	public String getTermNum0() {
		return this.termNum0;
	}

	/**
	 * 期間(手入力)を設定.
	 * 
	 * @param piTermNum0
	 *            期間(手入力)
	 */
	public void setTermNum0(String piTermNum0) {
		this.termNum0 = piTermNum0;
	}

	/**
	 * 期間を取得.
	 * 
	 * @return 期間
	 */
	public String getTermNum() {
		return this.termNum;
	}

	/**
	 * 期間を設定.
	 * 
	 * @param piTermNum
	 *            期間
	 */
	public void setTermNum(String piTermNum) {
		this.termNum = piTermNum;
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
	
	
}
