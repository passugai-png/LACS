package jp.co.pro_app.lacs.affairs.monthreport.bean;

/**
 * 月次帳票出力：仕訳合計表 Bean.
 * 
 * @author fukuhara
 * @version 20080415
 */
public class LACSMReportSiwakeBean {

	private String	createDate			= "";	// 作成日

	private String	termFrom			= "";	// 対象期間From

	private String	termTo				= "";	// 対象期間To

	private String	leaseUserNm			= "";	// リースユーザ名

	private String	leaseCompanyNm		= "";	// リース会社名

	private String	leaseCompanyZip		= "";	// リース会社郵便番号

	private String	leaseCompanyAddr1	= "";	// リース会社住所１

	private String	leaseCompanyAddr2	= "";	// リース会社住所２

	private String	taishoAcKijyunCd	= "";	// リース会計基準コード

	private String	taishoAcKijyunNm	= "";	// リース会計基準名称

	private String	ctshkFlg			= "";	// 会計処理コード

	private String	ctshkFlgNm			= "";	// 会計処理名称

	private String	keijYm				= "";	// 年月

	private String	krKnjKmkCd			= "";	// 借方科目コード

	private String	krKnjKmkNm			= "";	// 借方科目名称

	private String	krktAmt				= "";	// 借方金額

	private String	ksKnjKmkCd			= "";	// 貸方科目コード

	private String	ksKnjKmkNm			= "";	// 貸方科目名称

	private String	ksktAmt				= "";	// 貸方金額

	// 2020/05/22 ADD START
	private String	mesiKbn				= "";	// 明細区分
	// 2020/05/22 ADD END

	// 2021/03/01 arai 重要性有無コードおよび重要性有無の追加 start
	private String	jysiUmCd		= "";	// 重要性有無コード
	private String	jysiUm		= "";	// 重要性有無	
	// 2021/03/01 arai 重要性有無コードおよび重要性有無の追加 end
	
	/**
	 * 作成日を取得.
	 * 
	 * @return 作成日
	 */
	public String getCreateDate() {
		return this.createDate;
	}

	/**
	 * 対象期間Fromを取得.
	 * 
	 * @return 対象期間From
	 */
	public String getTermFrom() {
		return this.termFrom;
	}

	/**
	 * 対象期間Toを取得.
	 * 
	 * @return 対象期間To
	 */
	public String getTermTo() {
		return this.termTo;
	}

	/**
	 * リースユーザ名を取得.
	 * 
	 * @return リースユーザ名
	 */
	public String getLeaseUserNm() {
		return this.leaseUserNm;
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
	 * リース会社郵便番号を取得.
	 * 
	 * @return リース会社郵便番号
	 */
	public String getLeaseCompanyZip() {
		return this.leaseCompanyZip;
	}

	/**
	 * リース会社住所１を取得.
	 * 
	 * @return リース会社住所１
	 */
	public String getLeaseCompanyAddr1() {
		return this.leaseCompanyAddr1;
	}

	/**
	 * リース会社住所２を取得.
	 * 
	 * @return リース会社住所２
	 */
	public String getLeaseCompanyAddr2() {
		return this.leaseCompanyAddr2;
	}

	/**
	 * リース会計基準コードを取得.
	 * 
	 * @return リース会計基準コード
	 */
	public String getTaishoAcKijyunCd() {
		return this.taishoAcKijyunCd;
	}

	/**
	 * リース会計基準名称を取得.
	 * 
	 * @return リース会計基準名称
	 */
	public String getTaishoAcKijyunNm() {
		return this.taishoAcKijyunNm;
	}

	/**
	 * 会計処理コードを取得.
	 * 
	 * @return 会計処理コード
	 */
	public String getCtshkFlg() {
		return this.ctshkFlg;
	}

	/**
	 * 会計処理名称を取得.
	 * 
	 * @return 会計処理名称
	 */
	public String getCtshkFlgNm() {
		return this.ctshkFlgNm;
	}

	/**
	 * 年月を取得.
	 * 
	 * @return 年月
	 */
	public String getKeijYm() {
		return this.keijYm;
	}

	/**
	 * 借方科目コードを取得.
	 * 
	 * @return 借方科目コード
	 */
	public String getKrKnjKmkCd() {
		return this.krKnjKmkCd;
	}

	/**
	 * 借方科目名称を取得.
	 * 
	 * @return 借方科目名称
	 */
	public String getKrKnjKmkNm() {
		return this.krKnjKmkNm;
	}

	/**
	 * 借方金額を取得.
	 * 
	 * @return 借方金額
	 */
	public String getKrktAmt() {
		return this.krktAmt;
	}

	/**
	 * 貸方科目コードを取得.
	 * 
	 * @return 貸方科目コード
	 */
	public String getKsKnjKmkCd() {
		return this.ksKnjKmkCd;
	}

	/**
	 * 貸方科目名称を取得.
	 * 
	 * @return 貸方科目名称
	 */
	public String getKsKnjKmkNm() {
		return this.ksKnjKmkNm;
	}

	/**
	 * 貸方金額を取得.
	 * 
	 * @return 貸方金額
	 */
	public String getKsktAmt() {
		return this.ksktAmt;
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
	 * 対象期間Fromを設定.
	 * 
	 * @param piTermFrom
	 *            対象期間From
	 */
	public void setTermFrom(String piTermFrom) {
		this.termFrom = piTermFrom;
	}

	/**
	 * 対象期間Toを設定.
	 * 
	 * @param piTermTo
	 *            対象期間To
	 */
	public void setTermTo(String piTermTo) {
		this.termTo = piTermTo;
	}

	/**
	 * リースユーザ名を設定.
	 * 
	 * @param piLeaseUserNm
	 *            リースユーザ名
	 */
	public void setLeaseUserNm(String piLeaseUserNm) {
		this.leaseUserNm = piLeaseUserNm;
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
	 * リース会社郵便番号を設定.
	 * 
	 * @param piLeaseCompanyZip
	 *            リース会社郵便番号
	 */
	public void setLeaseCompanyZip(String piLeaseCompanyZip) {
		this.leaseCompanyZip = piLeaseCompanyZip;
	}

	/**
	 * リース会社住所１を設定.
	 * 
	 * @param piLeaseCompanyAddr1
	 *            リース会社住所１
	 */
	public void setLeaseCompanyAddr1(String piLeaseCompanyAddr1) {
		this.leaseCompanyAddr1 = piLeaseCompanyAddr1;
	}

	/**
	 * リース会社住所２を設定.
	 * 
	 * @param piLeaseCompanyAddr2
	 *            リース会社住所２
	 */
	public void setLeaseCompanyAddr2(String piLeaseCompanyAddr2) {
		this.leaseCompanyAddr2 = piLeaseCompanyAddr2;
	}

	/**
	 * リース会計基準コードを設定.
	 * 
	 * @param piTaishoAcKijyunCd
	 *            リース会計基準コード
	 */
	public void setTaishoAcKijyunCd(String piTaishoAcKijyunCd) {
		this.taishoAcKijyunCd = piTaishoAcKijyunCd;
	}

	/**
	 * リース会計基準名称を設定.
	 * 
	 * @param piTaishoAcKijyunNm
	 *            リース会計基準名称
	 */
	public void setTaishoAcKijyunNm(String piTaishoAcKijyunNm) {
		this.taishoAcKijyunNm = piTaishoAcKijyunNm;
	}

	/**
	 * 会計処理コードを設定.
	 * 
	 * @param piCtshkFlg
	 *            会計処理コード
	 */
	public void setCtshkFlg(String piCtshkFlg) {
		this.ctshkFlg = piCtshkFlg;
	}

	/**
	 * 会計処理名称を設定.
	 * 
	 * @param piCtshkFlgNm
	 *            会計処理名称
	 */
	public void setCtshkFlgNm(String piCtshkFlgNm) {
		this.ctshkFlgNm = piCtshkFlgNm;
	}

	/**
	 * 年月を設定.
	 * 
	 * @param piKeijYm
	 *            年月
	 */
	public void setKeijYm(String piKeijYm) {
		this.keijYm = piKeijYm;
	}

	/**
	 * 借方科目コードを設定.
	 * 
	 * @param piKrKnjKmkCd
	 *            借方科目コード
	 */
	public void setKrKnjKmkCd(String piKrKnjKmkCd) {
		this.krKnjKmkCd = piKrKnjKmkCd;
	}

	/**
	 * 借方科目名称を設定.
	 * 
	 * @param piKrKnjKmkNm
	 *            借方科目名称
	 */
	public void setKrKnjKmkNm(String piKrKnjKmkNm) {
		this.krKnjKmkNm = piKrKnjKmkNm;
	}

	/**
	 * 借方金額を設定.
	 * 
	 * @param piKrktAmt
	 *            借方金額
	 */
	public void setKrktAmt(String piKrktAmt) {
		this.krktAmt = piKrktAmt;
	}

	/**
	 * 貸方科目コードを設定.
	 * 
	 * @param piKsKnjKmkCd
	 *            貸方科目コード
	 */
	public void setKsKnjKmkCd(String piKsKnjKmkCd) {
		this.ksKnjKmkCd = piKsKnjKmkCd;
	}

	/**
	 * 貸方科目名称を設定.
	 * 
	 * @param piKsKnjKmkNm
	 *            貸方科目名称
	 */
	public void setKsKnjKmkNm(String piKsKnjKmkNm) {
		this.ksKnjKmkNm = piKsKnjKmkNm;
	}

	/**
	 * 貸方金額を設定.
	 * 
	 * @param piKsktAmt
	 *            貸方金額
	 */
	public void setKsktAmt(String piKsktAmt) {
		this.ksktAmt = piKsktAmt;
	}

	// 2020/05/22 ADD START
	/**
	 * 明細区分を取得.
	 * 
	 * @return 明細区分
	 */
	public String getMesiKbn() {
		return this.mesiKbn;
	}

	/**
	 * 明細区分を設定.
	 * 
	 * @param pimesiKbn
	 *            明細区分
	 */
	public void setMesiKbn(String pimesiKbn) {
		this.mesiKbn = pimesiKbn;
	}
	// 2020/05/22 ADD END

	// 2021/03/01 arai 重要性有無コードおよび重要性有無の追加 start
	/**
	 * 重要性有無を取得.
	 * 
	 * @param piJysiUm
	 *            重要性有無
	 */
	public void setJysiUm(String piJysiUm) {
		this.jysiUm = piJysiUm;
	}
	
	public String getJysiUm() {
		return this.jysiUm;
	}		
	// 2021/03/01 arai 重要性有無コードおよび重要性有無の追加 end
	
	// 2021/03/01 arai 重要性有無コードおよび重要性有無の追加 start
	/**
	 * 重要性有無コードを取得.
	 * 
	 * @param piJysiUm
	 *            重要性有無コード
	 */
	public void setJysiUmCd(String piJysiUmCd) {
		this.jysiUmCd = piJysiUmCd;
}
	
	public String getJysiUmCd() {
		return this.jysiUmCd;
	}		
	// 2021/03/01 arai 重要性有無コードおよび重要性有無の追加 end
}
