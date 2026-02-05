package jp.co.pro_app.lacs.affairs.report.bean;

import java.io.Serializable;

public class LACSReportAtesakiBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String	leaseCompanyNm				= "";	// ƒŠ[ƒX‰ïĞ–¼

	private String	leaseCompanyZipCd			= "";	// ƒŠ[ƒX‰ïĞ—X•Ö”Ô†

	private String	leaseCompanyAddr1			= "";	// ƒŠ[ƒX‰ïĞZŠ‚P

	private String	leaseCompanyAddr2			= "";	// ƒŠ[ƒX‰ïĞZŠ‚Q

	private String	tantosyaName			= "";			 // ’S“–Ò
	
	public String getLeaseCompanyNm() {
		return leaseCompanyNm;
	}

	public void setLeaseCompanyNm(String leaseCompanyNm) {
		this.leaseCompanyNm = leaseCompanyNm;
	}

	public String getLeaseCompanyZipCd() {
		return leaseCompanyZipCd;
	}

	public void setLeaseCompanyZipCd(String leaseCompanyZipCd) {
		this.leaseCompanyZipCd = leaseCompanyZipCd;
	}

	public String getLeaseCompanyAddr1() {
		return leaseCompanyAddr1;
	}

	public void setLeaseCompanyAddr1(String leaseCompanyAddr1) {
		this.leaseCompanyAddr1 = leaseCompanyAddr1;
	}

	public String getLeaseCompanyAddr2() {
		return leaseCompanyAddr2;
	}

	public void setLeaseCompanyAddr2(String leaseCompanyAddr2) {
		this.leaseCompanyAddr2 = leaseCompanyAddr2;
	}

	public String getTantosyaName() {
		return tantosyaName;
	}

	public void setTantosyaName(String tantosyaName) {
		this.tantosyaName = tantosyaName;
	}
}
