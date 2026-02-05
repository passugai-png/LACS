package jp.co.pro_app.lacs.affairs.report.bean;

/**
 * 帳票出力：未経過リース料期末残高別表Bean.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSReportMikeikaBBean {

	private String	leaseCompany	= "";	// リース会社

	private long	s1mikeikaZan01	= 0;	// 未経過リース料（一年以内）（建物）

	private long	s2mikeikaZan01	= 0;	// 未経過リース料（一年以内）（建物付属設備）

	private long	s3mikeikaZan01	= 0;	// 未経過リース料（一年以内）（構築物）

	private long	s4mikeikaZan01	= 0;	// 未経過リース料（一年以内）（機械および装置）

	private long	s5mikeikaZan01	= 0;	// 未経過リース料（一年以内）（船舶）

	private long	s6mikeikaZan01	= 0;	// 未経過リース料（一年以内）（航空機）

	private long	s7mikeikaZan01	= 0;	// 未経過リース料（一年以内）（車輛および運搬具）

	
	// 2020/05/22 ADD START
	private long	s8mikeikaZan01	= 0;	// 未経過リース料（一年以内）（工具器具備品）

	private long	s9mikeikaZan01	= 0;	// 未経過リース料（一年以内）（無形固定資産）
	// 2020/05/22 ADD END

	// private long syutokuTotal = 0; // 取得価額相当額（合計）

	private long	s1mikeikaZan02	= 0;	// 未経過リース料（一年超）（建物）

	private long	s2mikeikaZan02	= 0;	// 未経過リース料（一年超）（建物付属設備）

	private long	s3mikeikaZan02	= 0;	// 未経過リース料（一年超）（構築物）

	private long	s4mikeikaZan02	= 0;	// 未経過リース料（一年超）（機械および装置）

	private long	s5mikeikaZan02	= 0;	// 未経過リース料（一年超）（船舶）

	private long	s6mikeikaZan02	= 0;	// 未経過リース料（一年超）（航空機）

	private long	s7mikeikaZan02	= 0;	// 未経過リース料（一年超）（車輛および運搬具）

	// 2020/05/22 ADD START
	private long	s8mikeikaZan02	= 0;	// 未経過リース料（一年超）（工具器具備品）

	private long	s9mikeikaZan02	= 0;	// 未経過リース料（一年超）（無形固定資産）
	// 2020/05/22 ADD END
	
	private long	mikeikaZan01	= 0;	// 未経過リース料（一年以内）

	private long	mikeikaZan02	= 0;	// 未経過リース料（一年超）

	private long	mikeikaZan03	= 0;	// 未経過リース料（合計）

	private String	leascompanyNm	= "";	// リース会社名

	private String	leasUserNm		= "";	// リースユーザ名

	private String	acShrKbnName	= "";	// 会計処理方法

/* 2014/05/19 START */
	private String	trdHnteKekaKbn	= "";	// 取引判定結果

	private long	s1mikeikaStax01	= 0;	// 消費税（一年以内）（建物）

	private long	s2mikeikaStax01	= 0;	// 消費税（一年以内）（建物付属設備）

	private long	s3mikeikaStax01	= 0;	// 消費税（一年以内）（構築物）

	private long	s4mikeikaStax01	= 0;	// 消費税（一年以内）（機械および装置）

	private long	s5mikeikaStax01	= 0;	// 消費税（一年以内）（船舶）

	private long	s6mikeikaStax01	= 0;	// 消費税（一年以内）（航空機）

	private long	s7mikeikaStax01	= 0;	// 消費税（一年以内）（車輛および運搬具）

	// 2020/05/22 ADD START
	private long	s8mikeikaStax01	= 0;	// 消費税（一年以内）（工具器具備品）

	private long	s9mikeikaStax01	= 0;	// 消費税（一年以内）（無形固定資産）
	// 2020/05/22 ADD END

	private long	s1mikeikaStax02	= 0;	// 消費税（一年超）（構築物）

	private long	s2mikeikaStax02	= 0;	// 消費税（一年超）（建物付属設備）

	private long	s3mikeikaStax02	= 0;	// 消費税（一年超）（構築物）

	private long	s4mikeikaStax02	= 0;	// 消費税（一年超）（機械および装置）

	private long	s5mikeikaStax02	= 0;	// 消費税（一年超）（船舶）

	private long	s6mikeikaStax02	= 0;	// 消費税（一年超）（航空機）

	private long	s7mikeikaStax02	= 0;	// 消費税（一年超）（車輛および運搬具）

	// 2020/05/22 ADD START
	private long	s8mikeikaStax02	= 0;	// 消費税（一年超）（工具器具備品）

	private long	s9mikeikaStax02	= 0;	// 消費税（一年超）（無形固定資産）
	// 2020/05/22 ADD END

	private long	mikeikaStax01	= 0;	// 消費税（一年以内）

	private long	mikeikaStax02	= 0;	// 消費税（一年超）

	private long	mikeikaStax03	= 0;	// 消費税（合計）

/* 2014/05/19 END   */

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
	 * 未経過リース料期末残高相当額（一年以内）（建物）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（建物）
	 */
	public long getS1MikeikaZan01() {
		return this.s1mikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（建物）を設定.
	 * 
	 * @param piS1MikeikaZan01
	 *            未経過リース料期末残高相当額（一年以内）（建物）
	 */
	public void setS1MikeikaZan01(long piS1MikeikaZan01) {
		this.s1mikeikaZan01 = piS1MikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（建物付属設備）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（建物付属設備）
	 */
	public long getS2MikeikaZan01() {
		return this.s2mikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（建物付属設備）を設定.
	 * 
	 * @param piS2MikeikaZan01
	 *            未経過リース料期末残高相当額（一年以内）（建物付属設備）
	 */
	public void setS2MikeikaZan01(long piS2MikeikaZan01) {
		this.s2mikeikaZan01 = piS2MikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（構築物）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（構築物）
	 */
	public long getS3MikeikaZan01() {
		return this.s3mikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（構築物）を設定.
	 * 
	 * @param piS3MikeikaZan01
	 *            未経過リース料期末残高相当額（一年以内）（構築物）
	 */
	public void setS3MikeikaZan01(long piS3MikeikaZan01) {
		this.s3mikeikaZan01 = piS3MikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（機械および装置）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（機械および装置）
	 */
	public long getS4MikeikaZan01() {
		return this.s4mikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（機械および装置）を設定.
	 * 
	 * @param piS4MikeikaZan01
	 *            未経過リース料期末残高相当額（一年以内）（機械および装置）
	 */
	public void setS4MikeikaZan01(long piS4MikeikaZan01) {
		this.s4mikeikaZan01 = piS4MikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（船舶）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（船舶）
	 */
	public long getS5MikeikaZan01() {
		return this.s5mikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（船舶）を設定.
	 * 
	 * @param piS5MikeikaZan01
	 *            未経過リース料期末残高相当額（一年以内）（船舶）
	 */
	public void setS5MikeikaZan01(long piS5MikeikaZan01) {
		this.s5mikeikaZan01 = piS5MikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（航空機）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（航空機）
	 */
	public long getS6MikeikaZan01() {
		return this.s6mikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（航空機）を設定.
	 * 
	 * @param piS6MikeikaZan01
	 *            未経過リース料期末残高相当額（一年以内）（航空機）
	 */
	public void setS6MikeikaZan01(long piS6MikeikaZan01) {
		this.s6mikeikaZan01 = piS6MikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（車輛および運搬具）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（車輛および運搬具）
	 */
	public long getS7MikeikaZan01() {
		return this.s7mikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（車輛および運搬具）を設定.
	 * 
	 * @param piS7MikeikaZan01
	 *            未経過リース料期末残高相当額（一年以内）（車輛および運搬具）
	 */
	public void setS7MikeikaZan01(long piS7MikeikaZan01) {
		this.s7mikeikaZan01 = piS7MikeikaZan01;
	}

	// 2020/05/22 ADD START
	/**
	 * 未経過リース料期末残高相当額（一年以内）（工具器具備品）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（工具器具備品）
	 */
	public long getS8MikeikaZan01() {
		return this.s8mikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（工具器具備品）を設定.
	 * 
	 * @param piS8MikeikaZan01
	 *            未経過リース料期末残高相当額（一年以内）（工具器具備品）
	 */
	public void setS8MikeikaZan01(long piS8MikeikaZan01) {
		this.s8mikeikaZan01 = piS8MikeikaZan01;
	}
	
	//
	/**
	 * 未経過リース料期末残高相当額（一年以内）（無形固定資産）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年以内）（無形固定資産）
	 */
	public long getS9MikeikaZan01() {
		return this.s9mikeikaZan01;
	}

	/**
	 * 未経過リース料期末残高相当額（一年以内）（無形固定資産）を設定.
	 * 
	 * @param piS9MikeikaZan01
	 *            未経過リース料期末残高相当額（一年以内）（無形固定資産）
	 */
	public void setS9MikeikaZan01(long piS9MikeikaZan01) {
		this.s9mikeikaZan01 = piS9MikeikaZan01;
	}
	
	// 2020/05/22 ADD END

	/**
	 * 未経過リース料期末残高相当額（一年超）（建物）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（建物）
	 */
	public long getS1MikeikaZan02() {
		return this.s1mikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（建物）を設定.
	 * 
	 * @param piS1MikeikaZan02
	 *            未経過リース料期末残高相当額（一年超）（建物）
	 */
	public void setS1MikeikaZan02(long piS1MikeikaZan02) {
		this.s1mikeikaZan02 = piS1MikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（建物付属設備）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（建物付属設備）
	 */
	public long getS2MikeikaZan02() {
		return this.s2mikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（建物付属設備）を設定.
	 * 
	 * @param piS2MikeikaZan02
	 *            未経過リース料期末残高相当額（一年超）（建物付属設備）
	 */
	public void setS2MikeikaZan02(long piS2MikeikaZan02) {
		this.s2mikeikaZan02 = piS2MikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（構築物）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（構築物）
	 */
	public long getS3MikeikaZan02() {
		return this.s3mikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（構築物）を設定.
	 * 
	 * @param piS3MikeikaZan02
	 *            未経過リース料期末残高相当額（一年超）（構築物）
	 */
	public void setS3MikeikaZan02(long piS3MikeikaZan02) {
		this.s3mikeikaZan02 = piS3MikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（機械および装置）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（機械および装置）
	 */
	public long getS4MikeikaZan02() {
		return this.s4mikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（機械および装置）を設定.
	 * 
	 * @param piS4MikeikaZan02
	 *            未経過リース料期末残高相当額（一年超）（機械および装置）
	 */
	public void setS4MikeikaZan02(long piS4MikeikaZan02) {
		this.s4mikeikaZan02 = piS4MikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（船舶）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（船舶）
	 */
	public long getS5MikeikaZan02() {
		return this.s5mikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（船舶）を設定.
	 * 
	 * @param piS5MikeikaZan02
	 *            未経過リース料期末残高相当額（一年超）（船舶）
	 */
	public void setS5MikeikaZan02(long piS5MikeikaZan02) {
		this.s5mikeikaZan02 = piS5MikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（航空機）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（航空機）
	 */
	public long getS6MikeikaZan02() {
		return this.s6mikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（航空機）を設定.
	 * 
	 * @param piS6MikeikaZan02
	 *            未経過リース料期末残高相当額（一年超）（航空機）
	 */
	public void setS6MikeikaZan02(long piS6MikeikaZan02) {
		this.s6mikeikaZan02 = piS6MikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（車輛および運搬具）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（車輛および運搬具）
	 */
	public long getS7MikeikaZan02() {
		return this.s7mikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（車輛および運搬具）を設定.
	 * 
	 * @param piS7MikeikaZan02
	 *            未経過リース料期末残高相当額（一年超）（車輛および運搬具）
	 */
	public void setS7MikeikaZan02(long piS7MikeikaZan02) {
		this.s7mikeikaZan02 = piS7MikeikaZan02;
	}

	// 2020/05/22 ADD START
	/**
	 * 未経過リース料期末残高相当額（一年超）（工具器具備品）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（工具器具備品）
	 */
	public long getS8MikeikaZan02() {
		return this.s8mikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（工具器具備品）を設定.
	 * 
	 * @param piS8MikeikaZan02
	 *            未経過リース料期末残高相当額（一年超）（工具器具備品）
	 */
	public void setS8MikeikaZan02(long piS8MikeikaZan02) {
		this.s8mikeikaZan02 = piS8MikeikaZan02;
	}
	//
	/**
	 * 未経過リース料期末残高相当額（一年超）（無形固定資産）を取得.
	 * 
	 * @return 未経過リース料期末残高相当額（一年超）（無形固定資産）
	 */
	public long getS9MikeikaZan02() {
		return this.s9mikeikaZan02;
	}

	/**
	 * 未経過リース料期末残高相当額（一年超）（無形固定資産）を設定.
	 * 
	 * @param piS9MikeikaZan02
	 *            未経過リース料期末残高相当額（一年超）（無形固定資産）
	 */
	public void setS9MikeikaZan02(long piS9MikeikaZan02) {
		this.s9mikeikaZan02 = piS9MikeikaZan02;
	}
	// 2020/05/22 ADD END
	
	
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

/* 2014/05/19 START */
	/**
	 * 取引判定結果を取得.
	 * 
	 * @return 取引判定結果
	 */
	public String getTrdHnteKekaKbn() {
		return this.trdHnteKekaKbn;
	}

	/**
	 * 取引判定結果を設定.
	 * 
	 * @param piTrdHnteKekaKbn
	 *            取引判定結果
	 */
	public void setTrdHnteKekaKbn(String piTrdHnteKekaKbn) {
		this.trdHnteKekaKbn = piTrdHnteKekaKbn;
	}

	/**
	 * 消費税（一年以内）（建物）を取得.
	 * 
	 * @return 消費税（一年以内）（建物）
	 */
	public long getS1MikeikaStax01() {
		return this.s1mikeikaStax01;
	}

	/**
	 * 消費税（一年以内）（建物）を設定.
	 * 
	 * @param piS1MikeikaStax01
	 *            消費税（一年以内）（建物）
	 */
	public void setS1MikeikaStax01(long piS1MikeikaStax01) {
		this.s1mikeikaStax01 = piS1MikeikaStax01;
	}

	/**
	 * 消費税（一年以内）（建物付属設備）を取得.
	 * 
	 * @return 消費税（一年以内）（建物付属設備）
	 */
	public long getS2MikeikaStax01() {
		return this.s2mikeikaStax01;
	}

	/**
	 * 消費税（一年以内）（建物付属設備）を設定.
	 * 
	 * @param piS2MikeikaStax01
	 *            消費税（一年以内）（建物付属設備）
	 */
	public void setS2MikeikaStax01(long piS2MikeikaStax01) {
		this.s2mikeikaStax01 = piS2MikeikaStax01;
	}

	/**
	 * 消費税（一年以内）（構築物）を取得.
	 * 
	 * @return 消費税（一年以内）（構築物）
	 */
	public long getS3MikeikaStax01() {
		return this.s3mikeikaStax01;
	}

	/**
	 * 消費税（一年以内）（構築物）を設定.
	 * 
	 * @param piS3MikeikaStax01
	 *            消費税（一年以内）（構築物）
	 */
	public void setS3MikeikaStax01(long piS3MikeikaStax01) {
		this.s3mikeikaStax01 = piS3MikeikaStax01;
	}

	/**
	 * 消費税（一年以内）（機械および装置）を取得.
	 * 
	 * @return 消費税（一年以内）（機械および装置）
	 */
	public long getS4MikeikaStax01() {
		return this.s4mikeikaStax01;
	}

	/**
	 * 消費税（一年以内）（機械および装置）を設定.
	 * 
	 * @param piS4MikeikaStax01
	 *            消費税（一年以内）（機械および装置）
	 */
	public void setS4MikeikaStax01(long piS4MikeikaStax01) {
		this.s4mikeikaStax01 = piS4MikeikaStax01;
	}

	/**
	 * 消費税（一年以内）（船舶）を取得.
	 * 
	 * @return 消費税（一年以内）（船舶）
	 */
	public long getS5MikeikaStax01() {
		return this.s5mikeikaStax01;
	}

	/**
	 * 消費税（一年以内）（船舶）を設定.
	 * 
	 * @param piS5MikeikaStax01
	 *            消費税（一年以内）（船舶）
	 */
	public void setS5MikeikaStax01(long piS5MikeikaStax01) {
		this.s5mikeikaStax01 = piS5MikeikaStax01;
	}

	/**
	 * 消費税（一年以内）（航空機）を取得.
	 * 
	 * @return 消費税（一年以内）（航空機）
	 */
	public long getS6MikeikaStax01() {
		return this.s6mikeikaStax01;
	}

	/**
	 * 消費税（一年以内）（航空機）を設定.
	 * 
	 * @param piS6MikeikaStax01
	 *            消費税（一年以内）（航空機）
	 */
	public void setS6MikeikaStax01(long piS6MikeikaStax01) {
		this.s6mikeikaStax01 = piS6MikeikaStax01;
	}

	/**
	 * 消費税（一年以内）（車輛および運搬具）を取得.
	 * 
	 * @return 消費税（一年以内）（車輛および運搬具）
	 */
	public long getS7MikeikaStax01() {
		return this.s7mikeikaStax01;
	}

	/**
	 * 消費税（一年以内）（車輛および運搬具）を設定.
	 * 
	 * @param piS7MikeikaStax01
	 *            消費税（一年以内）（車輛および運搬具）
	 */
	public void setS7MikeikaStax01(long piS7MikeikaStax01) {
		this.s7mikeikaStax01 = piS7MikeikaStax01;
	}

	// 2020/05/22 ADD START
	/**
	 * 消費税（一年以内）（工具器具備品）を取得.
	 * 
	 * @return 消費税（一年以内）（工具器具備品）
	 */
	public long getS8MikeikaStax01() {
		return this.s8mikeikaStax01;
	}

	/**
	 * 消費税（一年以内）（工具器具備品）を設定.
	 * 
	 * @param piS8MikeikaStax01
	 *            消費税（一年以内）（工具器具備品）
	 */
	public void setS8MikeikaStax01(long piS8MikeikaStax01) {
		this.s8mikeikaStax01 = piS8MikeikaStax01;
	}
	//
	/**
	 * 消費税（一年以内）（無形固定資産）を取得.
	 * 
	 * @return 消費税（一年以内）（無形固定資産）
	 */
	public long getS9MikeikaStax01() {
		return this.s9mikeikaStax01;
	}

	/**
	 * 消費税（一年以内）（無形固定資産）を設定.
	 * 
	 * @param piS9MikeikaStax01
	 *            消費税（一年以内）（無形固定資産）
	 */
	public void setS9MikeikaStax01(long piS9MikeikaStax01) {
		this.s9mikeikaStax01 = piS9MikeikaStax01;
	}
	// 2020/05/22 ADD END

	/**
	 * 消費税（一年超）（建物）を取得.
	 * 
	 * @return 消費税（一年超）（建物）
	 */
	public long getS1MikeikaStax02() {
		return this.s1mikeikaStax02;
	}

	/**
	 * 消費税（一年超）（建物）を設定.
	 * 
	 * @param piS1MikeikaStax02
	 *            消費税（一年超）（建物）
	 */
	public void setS1MikeikaStax02(long piS1MikeikaStax02) {
		this.s1mikeikaStax02 = piS1MikeikaStax02;
	}

	/**
	 * 消費税（一年超）（建物付属設備）を取得.
	 * 
	 * @return 消費税（一年超）（建物付属設備）
	 */
	public long getS2MikeikaStax02() {
		return this.s2mikeikaStax02;
	}

	/**
	 * 消費税（一年超）（建物付属設備）を設定.
	 * 
	 * @param piS2MikeikaStax02
	 *            消費税（一年超）（建物付属設備）
	 */
	public void setS2MikeikaStax02(long piS2MikeikaStax02) {
		this.s2mikeikaStax02 = piS2MikeikaStax02;
	}

	/**
	 * 消費税（一年超）（構築物）を取得.
	 * 
	 * @return 消費税（一年超）（構築物）
	 */
	public long getS3MikeikaStax02() {
		return this.s3mikeikaStax02;
	}

	/**
	 * 消費税（一年超）（構築物）を設定.
	 * 
	 * @param piS3MikeikaStax02
	 *            消費税（一年超）（構築物）
	 */
	public void setS3MikeikaStax02(long piS3MikeikaStax02) {
		this.s3mikeikaStax02 = piS3MikeikaStax02;
	}

	/**
	 * 消費税（一年超）（機械および装置）を取得.
	 * 
	 * @return 消費税（一年超）（機械および装置）
	 */
	public long getS4MikeikaStax02() {
		return this.s4mikeikaStax02;
	}

	/**
	 * 消費税（一年超）（機械および装置）を設定.
	 * 
	 * @param piS4MikeikaStax02
	 *            消費税（一年超）（機械および装置）
	 */
	public void setS4MikeikaStax02(long piS4MikeikaStax02) {
		this.s4mikeikaStax02 = piS4MikeikaStax02;
	}

	/**
	 * 消費税（一年超）（船舶）を取得.
	 * 
	 * @return 消費税（一年超）（船舶）
	 */
	public long getS5MikeikaStax02() {
		return this.s5mikeikaStax02;
	}

	/**
	 * 消費税（一年超）（船舶）を設定.
	 * 
	 * @param piS5MikeikaStax02
	 *            消費税（一年超）（船舶）
	 */
	public void setS5MikeikaStax02(long piS5MikeikaStax02) {
		this.s5mikeikaStax02 = piS5MikeikaStax02;
	}

	/**
	 * 消費税（一年超）（航空機）を取得.
	 * 
	 * @return 消費税（一年超）（航空機）
	 */
	public long getS6MikeikaStax02() {
		return this.s6mikeikaStax02;
	}

	/**
	 * 消費税（一年超）（航空機）を設定.
	 * 
	 * @param piS6MikeikaStax02
	 *            消費税（一年超）（航空機）
	 */
	public void setS6MikeikaStax02(long piS6MikeikaStax02) {
		this.s6mikeikaStax02 = piS6MikeikaStax02;
	}

	/**
	 * 消費税（一年超）（車輛および運搬具）を取得.
	 * 
	 * @return 消費税（一年超）（車輛および運搬具）
	 */
	public long getS7MikeikaStax02() {
		return this.s7mikeikaStax02;
	}

	/**
	 * 消費税（一年超）（車輛および運搬具）を設定.
	 * 
	 * @param piS7MikeikaStax02
	 *            消費税（一年超）（車輛および運搬具）
	 */
	public void setS7MikeikaStax02(long piS7MikeikaStax02) {
		this.s7mikeikaStax02 = piS7MikeikaStax02;
	}

	// 2020/05/22 ADD START
	/**
	 * 消費税（一年超）（工具器具備品）を取得.
	 * 
	 * @return 消費税（一年超）（工具器具備品）
	 */
	public long getS8MikeikaStax02() {
		return this.s8mikeikaStax02;
	}

	/**
	 * 消費税（一年超）（工具器具備品）を設定.
	 * 
	 * @param piS8MikeikaStax02
	 *            消費税（一年超）（工具器具備品）
	 */
	public void setS8MikeikaStax02(long piS8MikeikaStax02) {
		this.s8mikeikaStax02 = piS8MikeikaStax02;
	}
	//
	/**
	 * 消費税（一年超）（無形固定資産）を取得.
	 * 
	 * @return 消費税（一年超）（無形固定資産）
	 */
	public long getS9MikeikaStax02() {
		return this.s9mikeikaStax02;
	}

	/**
	 * 消費税（一年超）（無形固定資産）を設定.
	 * 
	 * @param piS9MikeikaStax02
	 *            消費税（一年超）（無形固定資産）
	 */
	public void setS9MikeikaStax02(long piS9MikeikaStax02) {
		this.s9mikeikaStax02 = piS9MikeikaStax02;
	}
	// 2020/05/22 ADD END

	/**
	 * 消費税（一年以内）を取得.
	 * 
	 * @return 消費税（一年以内）
	 */
	public long getMikeikaStax01() {
		return this.mikeikaStax01;
	}

	/**
	 * 消費税（一年以内）を設定.
	 * 
	 * @param piMikeikaStax01
	 *            消費税（一年以内）
	 */
	public void setMikeikaStax01(long piMikeikaStax01) {
		this.mikeikaStax01 = piMikeikaStax01;
	}

	/**
	 * 消費税（一年超）を取得.
	 * 
	 * @return 消費税（一年超）
	 */
	public long getMikeikaStax02() {
		return this.mikeikaStax02;
	}

	/**
	 * 消費税（一年超）を設定.
	 * 
	 * @param piMikeikaStax02
	 *            消費税（一年超）
	 */
	public void setMikeikaStax02(long piMikeikaStax02) {
		this.mikeikaStax02 = piMikeikaStax02;
	}

	/**
	 * 消費税（合計）を取得.
	 * 
	 * @return 消費税（合計）
	 */
	public long getMikeikaStax03() {
		return this.mikeikaStax03;
	}

	/**
	 * 消費税（合計）を設定.
	 * 
	 * @param piMikeikaStax03
	 *            消費税（合計）
	 */
	public void setMikeikaStax03(long piMikeikaStax03) {
		this.mikeikaStax03 = piMikeikaStax03;
	}

/* 2014/05/19 END   */

}
