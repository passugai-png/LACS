package jp.co.pro_app.lacs.affairs.report.bean;

/**
 * 帳票出力：リース会計注記合計表Bean.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSReportGoukeiBean {

	private String	leaseCompany	= "";	// リース会社

	private long	syutoku01		= 0;	// 取得価額相当額（建物）

	private long	syutoku02		= 0;	// 取得価額相当額（建物付属設備）

	private long	syutoku03		= 0;	// 取得価額相当額（構築物）

	private long	syutoku04		= 0;	// 取得価額相当額（機械および装置）

	private long	syutoku05		= 0;	// 取得価額相当額（船舶）

	private long	syutoku06		= 0;	// 取得価額相当額（航空機）

	private long	syutoku07		= 0;	// 取得価額相当額（車輛および運搬具）

// 2020/05/22 ADD START	
	private long	syutoku08		= 0;	// 取得価額相当額（工具器具備品）

	private long	syutoku09		= 0;	// 取得価額相当額（無形固定資産）
// 2020/05/22 ADD END

	private long	syutokuTotal	= 0;	// 取得価額相当額（合計）

	private long	genka01			= 0;	// 減価償却累計額（建物）

	private long	genka02			= 0;	// 減価償却累計額（建物付属設備）

	private long	genka03			= 0;	// 減価償却累計額（構築物）

	private long	genka04			= 0;	// 減価償却累計額（機械および装置）

	private long	genka05			= 0;	// 減価償却累計額（船舶)

	private long	genka06			= 0;	// 減価償却累計額（航空機）

	private long	genka07			= 0;	// 減価償却累計額（車輛および運搬具）

// 2020/05/22 ADD START	
	private long	genka08			= 0;	// 減価償却累計額（工具器具備品）

	private long	genka09			= 0;	// 減価償却累計額（無形固定資産）
// 2020/05/22 ADD END

	private long	genkaTotal		= 0;	// 減価償却累計額（合計）

	private long	zandaka01		= 0;	// 期末残高相当額（建物）

	private long	zandaka02		= 0;	// 期末残高相当額（建物付属設備）

	private long	zandaka03		= 0;	// 期末残高相当額（構築物）

	private long	zandaka04		= 0;	// 期末残高相当額（機械および装置）

	private long	zandaka05		= 0;	// 期末残高相当額（船舶）

	private long	zandaka06		= 0;	// 期末残高相当額（航空機）

	private long	zandaka07		= 0;	// 期末残高相当額（車輛および運搬具）

// 2020/05/22 ADD START	
	private long	zandaka08		= 0;	// 期末残高相当額（工具器具備品）

	private long	zandaka09		= 0;	// 期末残高相当額（無形固定資産）
// 2020/05/22 ADD END
	
	private long	zandakaTotal	= 0;	// 期末残高相当額（合計）

	private long	mikeika01		= 0;	// 未経過リース料期末残高相当額（一年以内）

	private long	mikeika02		= 0;	// 未経過リース料期末残高相当額（一年超）

	private long	mikeika03		= 0;	// 未経過リース料期末残高相当額（合計）

	private long	toukiGenka		= 0;	// 支払リース料

	private long	toukiRisoku		= 0;	// 減価償却費相当額

	private long	toukiSiharai	= 0;	// 支払利息相当額

	private long	mikeikaZan01	= 0;	// 未経過リース料（一年以内）

	private long	mikeikaZan02	= 0;	// 未経過リース料（一年超）

	private long	mikeikaZan03	= 0;	// 未経過リース料（合計）

	private String	leascompanyNm	= "";	// リース会社名

	private String	leasUserNm		= "";	// リースユーザ名

	private String	yukeiSkkHoho	= "";	// 所有権移転外有形償却方法コード

	private String	mukeiSkkHoho	= "";	// 所有権移転外無形償却方法コード

	private String	rskClcHoho		= "";	// 利息計算方法コード

	private String	acShrKbnName	= "";	// 会計処理方法

	/**
	 * リース会社名を取得.
	 * 
	 * @return リース会社名
	 */
	public String getLeasCompanyNm() {
		return this.leascompanyNm;
	}

	/**
	 * リース会社名を設定.
	 * 
	 * @param piLeasCompanyNm
	 *            リース会社名
	 */
	public void setLeasCompanyNm(String piLeasCompanyNm) {
		this.leascompanyNm = piLeasCompanyNm;
	}

	/**
	 * リースユーザ名を取得.
	 * 
	 * @return リース会社名
	 */
	public String getLeasUserNm() {
		return this.leasUserNm;
	}

	/**
	 * リースユーザを設定.
	 * 
	 * @param piLeasUserNm
	 *            リース会社名
	 */
	public void setLeasUserNm(String piLeasUserNm) {
		this.leasUserNm = piLeasUserNm;
	}

	/**
	 * リース会社を取得.
	 * 
	 * @return リース会社
	 */
	public String getLeaseCompany() {
		return this.leaseCompany;
	}

	/**
	 * リース会社を設定.
	 * 
	 * @param piLeaseCompany
	 *            リース会社
	 */
	public void setLeaseCompany(String piLeaseCompany) {
		this.leaseCompany = piLeaseCompany;
	}

	/**
	 * 取得価額相当額（建物）を取得.
	 * 
	 * @return 取得価額相当額（建物）
	 */
	public long getSyutoku01() {
		return this.syutoku01;
	}

	/**
	 * 取得価額相当額（建物）を設定.
	 * 
	 * @param piSyutoku01
	 *            取得価額相当額（建物）
	 */
	public void setSyutoku01(long piSyutoku01) {
		this.syutoku01 = piSyutoku01;
	}

	/**
	 * 取得価額相当額（建物付属設備）を取得.
	 * 
	 * @return 取得価額相当額（建物付属設備）
	 */
	public long getSyutoku02() {
		return this.syutoku02;
	}

	/**
	 * 取得価額相当額（建物付属設備）を設定.
	 * 
	 * @param piSyutoku02
	 *            取得価額相当額（建物付属設備）
	 */
	public void setSyutoku02(long piSyutoku02) {
		this.syutoku02 = piSyutoku02;
	}

	/**
	 * 取得価額相当額（構築物）を取得.
	 * 
	 * @return 取得価額相当額（構築物）
	 */
	public long getSyutoku03() {
		return this.syutoku03;
	}

	/**
	 * 取得価額相当額（構築物）を設定.
	 * 
	 * @param piSyutoku03
	 *            取得価額相当額（構築物）
	 */
	public void setSyutoku03(long piSyutoku03) {
		this.syutoku03 = piSyutoku03;
	}

	/**
	 * 取得価額相当額（機械および装置）を取得.
	 * 
	 * @return 取得価額相当額（機械および装置）
	 */
	public long getSyutoku04() {
		return this.syutoku04;
	}

	/**
	 * 取得価額相当額（機械および装置）を設定.
	 * 
	 * @param piSyutoku04
	 *            取得価額相当額（機械および装置）
	 */
	public void setSyutoku04(long piSyutoku04) {
		this.syutoku04 = piSyutoku04;
	}

	/**
	 * 取得価額相当額（船舶）を取得.
	 * 
	 * @return 取得価額相当額（船舶）
	 */
	public long getSyutoku05() {
		return this.syutoku05;
	}

	/**
	 * 取得価額相当額（船舶）を設定.
	 * 
	 * @param piSyutoku05
	 *            取得価額相当額（船舶）
	 */
	public void setSyutoku05(long piSyutoku05) {
		this.syutoku05 = piSyutoku05;
	}

	/**
	 * 取得価額相当額（航空機）を取得.
	 * 
	 * @return 取得価額相当額（航空機）
	 */
	public long getSyutoku06() {
		return this.syutoku06;
	}

	/**
	 * 取得価額相当額（航空機）を設定.
	 * 
	 * @param piSyutoku06
	 *            取得価額相当額（航空機）
	 */
	public void setSyutoku06(long piSyutoku06) {
		this.syutoku06 = piSyutoku06;
	}

	/**
	 * 取得価額相当額（車輛および運搬具）を取得.
	 * 
	 * @return 取得価額相当額（車輛および運搬具）
	 */
	public long getSyutoku07() {
		return this.syutoku07;
	}

	/**
	 * 取得価額相当額（車輛および運搬具）を設定.
	 * 
	 * @param piSyutoku07
	 *            取得価額相当額（車輛および運搬具）
	 */
	public void setSyutoku07(long piSyutoku07) {
		this.syutoku07 = piSyutoku07;
	}

// 2020/05/22 ADD START	
	/**
	 * 取得価額相当額（工具器具備品）を取得.
	 * 
	 * @return 取得価額相当額（工具器具備品）
	 */
	public long getSyutoku08() {
		return this.syutoku08;
	}

	/**
	 * 取得価額相当額（工具器具備品）を設定.
	 * 
	 * @param piSyutoku08
	 *            取得価額相当額（工具器具備品）
	 */
	public void setSyutoku08(long piSyutoku08) {
		this.syutoku08 = piSyutoku08;
	}

	/**
	 * 取得価額相当額（無形固定資産）を取得.
	 * 
	 * @return 取得価額相当額（無形固定資産）
	 */
	public long getSyutoku09() {
		return this.syutoku09;
	}

	/**
	 * 取得価額相当額（無形固定資産）を設定.
	 * 
	 * @param piSyutoku09
	 *            取得価額相当額（無形固定資産）
	 */
	public void setSyutoku09(long piSyutoku09) {
		this.syutoku09 = piSyutoku09;
	}
// 2020/05/22 ADD END
	
	/**
	 * 取得価額相当額（合計）を取得.
	 * 
	 * @return 取得価額相当額（合計）
	 */
	public long getSyutokuTotal() {
		return this.syutokuTotal;
	}

	/**
	 * 取得価額相当額（合計）を設定.
	 * 
	 * @param piSyutokuTotal
	 *            取得価額相当額（合計）
	 */
	public void setSyutokuTotal(long piSyutokuTotal) {
		this.syutokuTotal = piSyutokuTotal;
	}

	/**
	 * 減価償却累計額（建物）を取得.
	 * 
	 * @return 減価償却累計額（建物）
	 */
	public long getGenka01() {
		return this.genka01;
	}

	/**
	 * 減価償却累計額（建物）を設定.
	 * 
	 * @param piGenka01
	 *            減価償却累計額（建物）
	 */
	public void setGenka01(long piGenka01) {
		this.genka01 = piGenka01;
	}

	/**
	 * 減価償却累計額（建物付属設備）を取得.
	 * 
	 * @return 減価償却累計額（建物付属設備）
	 */
	public long getGenka02() {
		return this.genka02;
	}

	/**
	 * 減価償却累計額（建物付属設備）を設定.
	 * 
	 * @param piGenka02
	 *            減価償却累計額（建物付属設備）
	 */
	public void setGenka02(long piGenka02) {
		this.genka02 = piGenka02;
	}

	/**
	 * 減価償却累計額（構築物）を取得.
	 * 
	 * @return 減価償却累計額（構築物）
	 */
	public long getGenka03() {
		return this.genka03;
	}

	/**
	 * 減価償却累計額（構築物）を設定.
	 * 
	 * @param piGenka03
	 *            減価償却累計額（構築物）
	 */
	public void setGenka03(long piGenka03) {
		this.genka03 = piGenka03;
	}

	/**
	 * 減価償却累計額（機械および装置）を取得.
	 * 
	 * @return 減価償却累計額（機械および装置）
	 */
	public long getGenka04() {
		return this.genka04;
	}

	/**
	 * 減価償却累計額（機械および装置）を設定.
	 * 
	 * @param piGenka04
	 *            減価償却累計額（機械および装置）
	 */
	public void setGenka04(long piGenka04) {
		this.genka04 = piGenka04;
	}

	/**
	 * 減価償却累計額（船舶）を取得.
	 * 
	 * @return 減価償却累計額（船舶）
	 */
	public long getGenka05() {
		return this.genka05;
	}

	/**
	 * 減価償却累計額（船舶）を設定.
	 * 
	 * @param piGenka05
	 *            減価償却累計額（船舶）
	 */
	public void setGenka05(long piGenka05) {
		this.genka05 = piGenka05;
	}

	/**
	 * 減価償却累計額（航空機）を取得.
	 * 
	 * @return 減価償却累計額（航空機）
	 */
	public long getGenka06() {
		return this.genka06;
	}

	/**
	 * 減価償却累計額（航空機）を設定.
	 * 
	 * @param piGenka06
	 *            減価償却累計額（航空機）
	 */
	public void setGenka06(long piGenka06) {
		this.genka06 = piGenka06;
	}

	/**
	 * 減価償却累計額（車輛および運搬具）を取得.
	 * 
	 * @return 減価償却累計額（車輛および運搬具）
	 */
	public long getGenka07() {
		return this.genka07;
	}

	/**
	 * 減価償却累計額（車輛および運搬具）を設定.
	 * 
	 * @param piGenka07
	 *            減価償却累計額（車輛および運搬具）
	 */
	public void setGenka07(long piGenka07) {
		this.genka07 = piGenka07;
	}

// 2020/05/22 ADD START	
	/**
	 * 減価償却累計額（工具器具備品）を取得.
	 * 
	 * @return 減価償却累計額（工具器具備品）
	 */
	public long getGenka08() {
		return this.genka08;
	}

	/**
	 * 減価償却累計額（工具器具備品）を設定.
	 * 
	 * @param piGenka08
	 *            減価償却累計額（工具器具備品）
	 */
	public void setGenka08(long piGenka08) {
		this.genka08 = piGenka08;
	}

	/**
	 * 減価償却累計額（無形固定資産）を取得.
	 * 
	 * @return 減価償却累計額（無形固定資産）
	 */
	public long getGenka09() {
		return this.genka09;
	}

	/**
	 * 減価償却累計額（無形固定資産）を設定.
	 * 
	 * @param piGenka09
	 *            減価償却累計額（無形固定資産）
	 */
	public void setGenka09(long piGenka09) {
		this.genka09 = piGenka09;
	}
// 2020/05/22 ADD END
	
	/**
	 * 減価償却累計額（合計）を取得.
	 * 
	 * @return 減価償却累計額（合計）
	 */
	public long getGenkaTotal() {
		return this.genkaTotal;
	}

	/**
	 * 減価償却累計額（合計）を設定.
	 * 
	 * @param piGenkaTotal
	 *            減価償却累計額（合計）
	 */
	public void setGenkaTotal(long piGenkaTotal) {
		this.genkaTotal = piGenkaTotal;
	}

	/**
	 * 期末残高相当額（建物）を取得.
	 * 
	 * @return 期末残高相当額（建物）
	 */
	public long getZandaka01() {
		return this.zandaka01;
	}

	/**
	 * 期末残高相当額（建物）を設定.
	 * 
	 * @param piZandaka01
	 *            期末残高相当額（建物）
	 */
	public void setZandaka01(long piZandaka01) {
		this.zandaka01 = piZandaka01;
	}

	/**
	 * 期末残高相当額（建物付属設備）を取得.
	 * 
	 * @return 期末残高相当額（建物付属設備）
	 */
	public long getZandaka02() {
		return this.zandaka02;
	}

	/**
	 * 期末残高相当額（建物付属設備）を設定.
	 * 
	 * @param piZandaka02
	 *            期末残高相当額（建物付属設備）
	 */
	public void setZandaka02(long piZandaka02) {
		this.zandaka02 = piZandaka02;
	}

	/**
	 * 期末残高相当額（構築物）を取得.
	 * 
	 * @return 期末残高相当額（構築物）
	 */
	public long getZandaka03() {
		return this.zandaka03;
	}

	/**
	 * 期末残高相当額（構築物）を設定.
	 * 
	 * @param piZandaka03
	 *            期末残高相当額（構築物）
	 */
	public void setZandaka03(long piZandaka03) {
		this.zandaka03 = piZandaka03;
	}

	/**
	 * 期末残高相当額（機械および装置）を取得.
	 * 
	 * @return 期末残高相当額（機械および装置）
	 */
	public long getZandaka04() {
		return this.zandaka04;
	}

	/**
	 * 期末残高相当額（機械および装置）を設定.
	 * 
	 * @param piZandaka04
	 *            期末残高相当額（機械および装置）
	 */
	public void setZandaka04(long piZandaka04) {
		this.zandaka04 = piZandaka04;
	}

	/**
	 * 期末残高相当額（船舶）を取得.
	 * 
	 * @return 期末残高相当額（船舶）
	 */
	public long getZandaka05() {
		return this.zandaka05;
	}

	/**
	 * 期末残高相当額（船舶）を設定.
	 * 
	 * @param piZandaka05
	 *            期末残高相当額（船舶）
	 */
	public void setZandaka05(long piZandaka05) {
		this.zandaka05 = piZandaka05;
	}

	/**
	 * 期末残高相当額（航空機）を取得.
	 * 
	 * @return 期末残高相当額（航空機）
	 */
	public long getZandaka06() {
		return this.zandaka06;
	}

	/**
	 * 期末残高相当額（航空機）を設定.
	 * 
	 * @param piZandaka06
	 *            期末残高相当額（航空機）
	 */
	public void setZandaka06(long piZandaka06) {
		this.zandaka06 = piZandaka06;
	}

	/**
	 * 期末残高相当額（車輛および運搬具）を取得.
	 * 
	 * @return 期末残高相当額（車輛および運搬具）
	 */
	public long getZandaka07() {
		return this.zandaka07;
	}

	/**
	 * 期末残高相当額（車輛および運搬具）を設定.
	 * 
	 * @param piZandaka07
	 *            期末残高相当額（車輛および運搬具）
	 */
	public void setZandaka07(long piZandaka07) {
		this.zandaka07 = piZandaka07;
	}

// 2020/05/22 ADD START	
	/**
	 * 期末残高相当額（工具器具備品）を取得.
	 * 
	 * @return 期末残高相当額（工具器具備品）
	 */
	public long getZandaka08() {
		return this.zandaka08;
	}

	/**
	 * 期末残高相当額（工具器具備品）を設定.
	 * 
	 * @param piZandaka08
	 *            期末残高相当額（工具器具備品）
	 */
	public void setZandaka08(long piZandaka08) {
		this.zandaka08 = piZandaka08;
	}

	/**
	 * 期末残高相当額（無形固定資産）を取得.
	 * 
	 * @return 期末残高相当額（無形固定資産）
	 */
	public long getZandaka09() {
		return this.zandaka09;
	}

	/**
	 * 期末残高相当額（無形固定資産）を設定.
	 * 
	 * @param piZandaka09
	 *            期末残高相当額（無形固定資産）
	 */
	public void setZandaka09(long piZandaka09) {
		this.zandaka09 = piZandaka09;
	}
// 2020/05/22 ADD END

	/**
	 * 期末残高相当額（合計）を取得.
	 * 
	 * @return 期末残高相当額（合計）
	 */
	public long getZandakaTotal() {
		return this.zandakaTotal;
	}

	/**
	 * 期末残高相当額（合計）を設定.
	 * 
	 * @param piZandakaTotal
	 *            期末残高相当額（合計）
	 */
	public void setZandakaTotal(long piZandakaTotal) {
		this.zandakaTotal = piZandakaTotal;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）
	 */
	public long getMikeikaZan01() {
		return this.mikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）を設定.
	 * 
	 * @param piMikeikaZan01
	 *            未経過リース料期末残高相当額（一年以内）
	 */
	public void setMikeikaZan01(long piMikeikaZan01) {
		this.mikeikaZan01 = piMikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）
	 */
	public long getMikeikaZan02() {
		return this.mikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）を設定.
	 * 
	 * @param piMikeikaZan02
	 *            未経過リース料期末残高相当額（一年超）
	 */
	public void setMikeikaZan02(long piMikeikaZan02) {
		this.mikeikaZan02 = piMikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（合計）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（合計）
	 */
	public long getMikeikaZan03() {
		return this.mikeikaZan03;
	}

	/**
	 * 未経過リース料期末残高相当額（合計）を設定.
	 * 
	 * @param piMikeikaZan03
	 *            未経過リース料期末残高相当額（合計）
	 */
	public void setMikeikaZan03(long piMikeikaZan03) {
		this.mikeikaZan03 = piMikeikaZan03;
	}

	/**
	 * 支払リース料を取得.
	 * 
	 * @return 支払リース料
	 */
	public long getToukiSiharai() {
		return this.toukiSiharai;
	}

	/**
	 * 支払リース料を設定.
	 * 
	 * @param piToukiSiharai
	 *            支払リース料
	 */
	public void setToukiSiharai(long piToukiSiharai) {
		this.toukiSiharai = piToukiSiharai;
	}

	/**
	 * 減価償却費相当額を取得.
	 * 
	 * @return 減価償却費相当額
	 */
	public long getToukiGenka() {
		return this.toukiGenka;
	}

	/**
	 * 減価償却費相当額を設定.
	 * 
	 * @param piToukiGenka
	 *            減価償却費相当額
	 */
	public void setToukiGenka(long piToukiGenka) {
		this.toukiGenka = piToukiGenka;
	}

	/**
	 * 支払利息相当額を取得.
	 * 
	 * @return 支払利息相当額
	 */
	public long getToukiRisoku() {
		return this.toukiRisoku;
	}

	/**
	 * 支払利息相当額を設定.
	 * 
	 * @param piToukiRisoku
	 *            支払利息相当額
	 */
	public void setToukiRisoku(long piToukiRisoku) {
		this.toukiRisoku = piToukiRisoku;
	}

	/**
	 * 未経過リース料（一年以内）を取得.
	 * 
	 * @return 未経過リース料（一年以内）
	 */
	public long getMikeika01() {
		return this.mikeika01;
	}

	/**
	 * 未経過リース料（一年以内）を設定.
	 * 
	 * @param piMikeika01
	 *            未経過リース料（一年以内）
	 */
	public void setMikeika01(long piMikeika01) {
		this.mikeika01 = piMikeika01;
	}

	/**
	 * 未経過リース料（一年超）を取得.
	 * 
	 * @return 未経過リース料（一年超）
	 */
	public long getMikeika02() {
		return this.mikeika02;
	}

	/**
	 * 未経過リース料（一年超）を設定.
	 * 
	 * @param piMikeika02
	 *            未経過リース料（一年超）
	 */
	public void setMikeika02(long piMikeika02) {
		this.mikeika02 = piMikeika02;
	}

	/**
	 * 未経過リース料（合計）を取得.
	 * 
	 * @return 未経過リース料（合計）
	 */
	public long getMikeika03() {
		return this.mikeika03;
	}

	/**
	 * 未経過リース料（合計）を設定.
	 * 
	 * @param piMikeika03
	 *            未経過リース料（合計）
	 */
	public void setMikeika03(long piMikeika03) {
		this.mikeika03 = piMikeika03;
	}

	/**
	 * 所有権移転外有形償却方法コードを取得.
	 * 
	 * @return 所有権移転外有形償却方法コード
	 */
	public String getYukeiSkkHoho() {
		return this.yukeiSkkHoho;
	}

	/**
	 * 所有権移転外有形償却方法コードを設定.
	 * 
	 * @param piYukeiSkkHoho
	 *            所有権移転外有形償却方法コード
	 */
	public void setYukeiSkkHoho(String piYukeiSkkHoho) {
		this.yukeiSkkHoho = piYukeiSkkHoho;
	}

	/**
	 * 所有権移転外無形償却方法コードを取得.
	 * 
	 * @return 所有権移転外無形償却方法コード
	 */
	public String getMukeiSkkHoho() {
		return this.mukeiSkkHoho;
	}

	/**
	 * 所有権移転外無形償却方法コードを設定.
	 * 
	 * @param piMukeiSkkHoho
	 *            所有権移転外無形償却方法コード
	 */
	public void setMukeiSkkHoho(String piMukeiSkkHoho) {
		this.mukeiSkkHoho = piMukeiSkkHoho;
	}

	/**
	 * 利息計算方法コードを取得.
	 * 
	 * @return 利息計算方法コード
	 */
	public String getRskClcHoho() {
		return this.rskClcHoho;
	}

	/**
	 * 利息計算方法コードを設定.
	 * 
	 * @param piRskClcHoho
	 *            利息計算方法コード
	 */
	public void setRskClcHoho(String piRskClcHoho) {
		this.rskClcHoho = piRskClcHoho;
	}

	/**
	 * 会計処理方法を取得.
	 * 
	 * @return 会計処理方法
	 */
	public String getAcShrKbnName() {
		return this.acShrKbnName;
	}

	/**
	 * 会計処理方法を設定.
	 * 
	 * @param piAcShrKbnName
	 *            会計処理方法
	 */
	public void setAcShrKbnName(String piAcShrKbnName) {
		this.acShrKbnName = piAcShrKbnName;
	}

}
