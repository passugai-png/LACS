package jp.co.pro_app.lacs.affairs.report.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 帳票出力：注記書類作成基準書 Entity.
 * 
 * @author fukuhara
 * @version 20080409
 */
public class LACSReportTyukiEntity extends LACSReportEntityBase {

	private LACSReportBean	reportBean	= null;

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 * @param piCommonBean
	 *            LACS共通Bean
	 * @param piReportBean
	 *            帳票出力Bean
	 * @param piAcStd
	 *            対象会計基準
	 */
	public LACSReportTyukiEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSReportBean piReportBean, String piAcStd) {
		super(piModel, piCommonBean, piReportBean, piAcStd);
		this.reportBean = piReportBean;

	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT distinct to_char(CURRENT_DATE,'yyyymmdd') CREATE_DATE \n");
		super.sql.append(",LU.LU_ZIP1 || '-' || LU.LU_ZIP2 LEASE_USER_ZIP \n");
		super.sql.append(",LU.LU_ADR1 LEASE_USER_ADDR1 \n");
		super.sql.append(",LU.LU_ADR2 LEASE_USER_ADDR2 \n");
		super.sql.append(",LU.LU_NM LEASE_USER_NM \n");
		super.sql.append(",DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_NM, LU.PDF_COMPANY_NM) LEASE_COMPANY_NM \n");
		super.sql.append(",DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_ZIP1 || '-' || LC.LC_ZIP2, LU.PDF_COMPANY_ZIP1 || '-' || LU.PDF_COMPANY_ZIP2) LEASE_COMPANY_ZIP \n");
		super.sql.append(",DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_ADR1, LU.PDF_COMPANY_ADR1) LEASE_COMPANY_ADDR1 \n");
		super.sql.append(",DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_ADR2, LU.PDF_COMPANY_ADR2) LEASE_COMPANY_ADDR2 \n");

		super.sql.append(",'" + reportBean.getTermFrom().getYYYYMMDD() + "' TERM_FROM \n");
		super.sql.append(",'" + reportBean.getTermTo().getYYYYMMDD() + "' TERM_TO \n");

		super.sql.append(",DECODE('" + reportBean.getKaikeiSyori() + "','0','詳細注記','簡略注記') KAIKEI_SYORI \n");

		super.sql.append(",DECODE('" + reportBean.getOldKeiyakuGaku() + "','0','除く','除かない') OLD_KEIYAKU_GAKU \n");
		super.sql.append(",DECODE('" + reportBean.getOldLeaseKikan() + "','0','除く','除かない') OLD_LEASE_KIKAN \n");
		super.sql.append(",DECODE('" + reportBean.getOldSaiLease() + "','0','除く','除かない') OLD_SAI_LEASE \n");
		super.sql.append(",DECODE('" + reportBean.getOldTyutoKaiyaku() + "','0','除く','除かない') OLD_TYUTO_KAIYAKU \n");
		super.sql.append(",DECODE('" + reportBean.getNewKeiyakuGaku() + "','0','除く','除かない') NEW_KEIYAKU_GAKU \n");
		super.sql.append(",DECODE('" + reportBean.getNewLeaseKikan() + "','0','除く','除かない') NEW_LEASE_KIKAN \n");
		super.sql.append(",DECODE('" + reportBean.getNewSaiLease() + "','0','除く','除かない') NEW_SAI_LEASE \n");
		super.sql.append(",DECODE('" + reportBean.getNewTyutoKaiyaku() + "','0','除く','除かない') NEW_TYUTO_KAIYAKU \n");

		if (super.kaikeiSyori.equals(LACSDefine.KaikeiSyori.SYOUSAI_0)) {
			super.sql.append(",SKK_KEIJ_HOHO_KBN1.SKK_KEIJ_HOHO_KBN OLD_ITN_YUKEI_SKK_HOHO_KBN \n");
			super.sql.append(",SKK_KEIJ_HOHO_KBN2.SKK_KEIJ_HOHO_KBN OLD_ITN_MUKEI_SKK_HOHO_KBN \n");
			super.sql.append(",SKK_KEIJ_HOHO_KBN3.SKK_KEIJ_HOHO_KBN OLD_ITNGI_YUKEI_SKK_HOHO_KBN \n");
			super.sql.append(",SKK_KEIJ_HOHO_KBN4.SKK_KEIJ_HOHO_KBN OLD_ITNGI_MUKEI_SKK_HOHO_KBN \n");
		}
		else {
			super.sql.append(",'" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' OLD_ITN_YUKEI_SKK_HOHO_KBN \n");
			super.sql.append(",'" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' OLD_ITN_MUKEI_SKK_HOHO_KBN \n");
			super.sql.append(",'" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' OLD_ITNGI_YUKEI_SKK_HOHO_KBN \n");
			super.sql.append(",'" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' OLD_ITNGI_MUKEI_SKK_HOHO_KBN \n");
		}
		super.sql.append(",SKK_KEIJ_HOHO_KBN1.DISP_SKK_HOHO_NM OLD_ITN_YUKEI_SKK_HOHO_NM \n");
		super.sql.append(",SKK_KEIJ_HOHO_KBN2.DISP_SKK_HOHO_NM OLD_ITN_MUKEI_SKK_HOHO_NM \n");
		super.sql.append(",SKK_KEIJ_HOHO_KBN3.DISP_SKK_HOHO_NM OLD_ITNGI_YUKEI_SKK_HOHO_NM \n");
		super.sql.append(",SKK_KEIJ_HOHO_KBN4.DISP_SKK_HOHO_NM OLD_ITNGI_MUKEI_SKK_HOHO_NM \n");

		super.sql.append(",HASU_CHSE_CD1.HASU_CHSE_CD OLD_GNKSK_HASU_CHSE_KBN \n");
		super.sql.append(",HASU_CHSE_CD1.HASU_CHSE_NM OLD_GNKSK_HASU_CHSE_NM \n");

		if (super.kaikeiSyori.equals(LACSDefine.KaikeiSyori.SYOUSAI_0)) {
			super.sql.append(",RSK_KEIJ_HOHO_KBN1.RSK_KEIJ_HOHO_KBN OLD_RSK_CLC_HOHO_KBN \n");
		}
		else {
			super.sql.append(",'" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' OLD_RSK_CLC_HOHO_KBN \n");
		}
		super.sql.append(",RSK_KEIJ_HOHO_KBN1.RSK_KEIJ_HOHO_KBN_NM OLD_RSK_CLC_HOHO_NM \n");

		super.sql.append(",FKN_TNKI_HOHO_CD1.FKN_TNKI_HOHO_CD OLD_FKN_TNKI_HOHO_KBN \n");
		super.sql.append(",FKN_TNKI_HOHO_CD1.FKN_TNKI_HOHO_NM OLD_FKN_TNKI_HOHO_NM \n");
		super.sql.append(",HASU_CHSE_CD2.HASU_CHSE_CD OLD_FKN_TNKI_CHSE_KBN \n");
		super.sql.append(",HASU_CHSE_CD2.HASU_CHSE_NM OLD_FKN_TNKI_CHSE_NM \n");
		super.sql.append(",LU.OLD_IJI_KNRI_HYO_JYO_KBN OLD_IJI_KNRI_HYO_JYO_KBN \n");
		super.sql.append(",DECODE(LU.OLD_IJI_KNRI_HYO_JYO_KBN,'0','なし','あり') OLD_IJI_KNRI_HYO_JYO_NM \n");
		super.sql.append(",LU.OLD_EKM_TEIK_HYO_JYO_KBN OLD_EKM_TEIK_HYO_JYO_KBN \n");
		super.sql.append(",DECODE(LU.OLD_EKM_TEIK_HYO_JYO_KBN,'0','なし','あり') OLD_EKM_TEIK_HYO_JYO_NM \n");

		if (super.kaikeiSyori.equals(LACSDefine.KaikeiSyori.SYOUSAI_0)) {
			super.sql.append(",SKK_KEIJ_HOHO_KBN5.SKK_KEIJ_HOHO_KBN NEW_ITN_YUKEI_SKK_HOHO_KBN \n");
			super.sql.append(",SKK_KEIJ_HOHO_KBN6.SKK_KEIJ_HOHO_KBN NEW_ITN_MUKEI_SKK_HOHO_KBN \n");
			super.sql.append(",SKK_KEIJ_HOHO_KBN7.SKK_KEIJ_HOHO_KBN NEW_ITNGI_YUKEI_SKK_HOHO_KBN \n");
			super.sql.append(",SKK_KEIJ_HOHO_KBN8.SKK_KEIJ_HOHO_KBN NEW_ITNGI_MUKEI_SKK_HOHO_KBN \n");
		}
		else {
			super.sql.append(",'" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' NEW_ITN_YUKEI_SKK_HOHO_KBN \n");
			super.sql.append(",'" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' NEW_ITN_MUKEI_SKK_HOHO_KBN \n");
			super.sql.append(",'" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' NEW_ITNGI_YUKEI_SKK_HOHO_KBN \n");
			super.sql.append(",'" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' NEW_ITNGI_MUKEI_SKK_HOHO_KBN \n");
		}
		super.sql.append(",SKK_KEIJ_HOHO_KBN5.DISP_SKK_HOHO_NM NEW_ITN_YUKEI_SKK_HOHO_NM \n");
		super.sql.append(",SKK_KEIJ_HOHO_KBN6.DISP_SKK_HOHO_NM NEW_ITN_MUKEI_SKK_HOHO_NM \n");
		super.sql.append(",SKK_KEIJ_HOHO_KBN7.DISP_SKK_HOHO_NM NEW_ITNGI_YUKEI_SKK_HOHO_NM \n");
		super.sql.append(",SKK_KEIJ_HOHO_KBN8.DISP_SKK_HOHO_NM NEW_ITNGI_MUKEI_SKK_HOHO_NM \n");

		super.sql.append(",HASU_CHSE_CD3.HASU_CHSE_CD NEW_GNKSK_HASU_CHSE_KBN \n");
		super.sql.append(",HASU_CHSE_CD3.HASU_CHSE_NM NEW_GNKSK_HASU_CHSE_NM \n");

		if (super.kaikeiSyori.equals(LACSDefine.KaikeiSyori.SYOUSAI_0)) {
			super.sql.append(",RSK_KEIJ_HOHO_KBN2.RSK_KEIJ_HOHO_KBN NEW_RSK_CLC_HOHO_KBN \n");
		}
		else {
			super.sql.append(",'" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' NEW_RSK_CLC_HOHO_KBN \n");
		}
		super.sql.append(",RSK_KEIJ_HOHO_KBN2.RSK_KEIJ_HOHO_KBN_NM NEW_RSK_CLC_HOHO_NM \n");

		super.sql.append(",FKN_TNKI_HOHO_CD2.FKN_TNKI_HOHO_CD NEW_FKN_TNKI_HOHO_KBN \n");
		super.sql.append(",FKN_TNKI_HOHO_CD2.FKN_TNKI_HOHO_NM NEW_FKN_TNKI_HOHO_NM \n");
		super.sql.append(",HASU_CHSE_CD4.HASU_CHSE_CD NEW_FKN_TNKI_CHSE_KBN \n");
		super.sql.append(",HASU_CHSE_CD4.HASU_CHSE_NM NEW_FKN_TNKI_CHSE_NM \n");
		super.sql.append(",LU.NEW_IJI_KNRI_HYO_JYO_KBN NEW_IJI_KNRI_HYO_JYO_KBN \n");
		super.sql.append(",DECODE(LU.NEW_IJI_KNRI_HYO_JYO_KBN,'0','なし','あり') NEW_IJI_KNRI_HYO_JYO_NM \n");
		super.sql.append(",LU.NEW_EKM_TEIK_HYO_JYO_KBN NEW_EKM_TEIK_HYO_JYO_KBN \n");
		super.sql.append(",DECODE(LU.NEW_EKM_TEIK_HYO_JYO_KBN,'0','なし','あり') NEW_EKM_TEIK_HYO_JYO_NM \n");
		super.sql.append(",LC.TYUKI_COMMENT1 TYUKI_COMMENT1 \n");
		super.sql.append(",LC.TYUKI_COMMENT2 TYUKI_COMMENT2 \n");

		super.sql.append(" FROM M_LU LU \n");
		super.sql.append(" INNER JOIN M_LC_BETU_LU LC_BETU_LU ON LC_BETU_LU.LU_COSMOS_CD = LU.LU_COSMOS_CD \n");
		super.sql.append(" INNER JOIN M_LC LC ON LC.LC_CD = LC_BETU_LU.LC_CD \n");

		if (super.kaikeiSyori.equals(LACSDefine.KaikeiSyori.SYOUSAI_0)) {
			super.sql.append(" LEFT JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN1 ON SKK_KEIJ_HOHO_KBN1.SKK_KEIJ_HOHO_KBN = LU.OLD_ITN_YUKEI_SKK_HOHO_CD \n");
			super.sql.append(" LEFT JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN2 ON SKK_KEIJ_HOHO_KBN2.SKK_KEIJ_HOHO_KBN = LU.OLD_ITN_MUKEI_SKK_HOHO_CD \n");
			super.sql.append(" LEFT JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN3 ON SKK_KEIJ_HOHO_KBN3.SKK_KEIJ_HOHO_KBN = LU.OLD_ITNGI_YUKEI_SKK_HOHO_CD \n");
			super.sql.append(" LEFT JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN4 ON SKK_KEIJ_HOHO_KBN4.SKK_KEIJ_HOHO_KBN = LU.OLD_ITNGI_MUKEI_SKK_HOHO_CD \n");
		}
		else {
			super.sql.append(" LEFT JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN1 ON SKK_KEIJ_HOHO_KBN1.SKK_KEIJ_HOHO_KBN = '" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' \n");
			super.sql.append(" LEFT JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN2 ON SKK_KEIJ_HOHO_KBN2.SKK_KEIJ_HOHO_KBN = '" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' \n");
			super.sql.append(" LEFT JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN3 ON SKK_KEIJ_HOHO_KBN3.SKK_KEIJ_HOHO_KBN = '" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' \n");
			super.sql.append(" LEFT JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN4 ON SKK_KEIJ_HOHO_KBN4.SKK_KEIJ_HOHO_KBN = '" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' \n");
		}

		super.sql.append(" LEFT JOIN M_HASU_CHSE_CD HASU_CHSE_CD1 ON HASU_CHSE_CD1.HASU_CHSE_CD = LU.OLD_GNKSK_HASU_CHSE_CD \n");

		if (super.kaikeiSyori.equals(LACSDefine.KaikeiSyori.SYOUSAI_0)) {
			super.sql.append(" LEFT JOIN M_RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN1 ON RSK_KEIJ_HOHO_KBN1.RSK_KEIJ_HOHO_KBN = LU.OLD_RSK_CLC_HOHO_CD \n");
		}
		else {
			super.sql.append(" LEFT JOIN M_RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN1 ON RSK_KEIJ_HOHO_KBN1.RSK_KEIJ_HOHO_KBN = '" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' \n");
		}

		super.sql.append(" LEFT JOIN M_FKN_TNKI_HOHO_CD FKN_TNKI_HOHO_CD1 ON FKN_TNKI_HOHO_CD1.FKN_TNKI_HOHO_CD = LU.OLD_FKN_TNKI_HOHO_CD \n");
		super.sql.append(" LEFT JOIN M_HASU_CHSE_CD HASU_CHSE_CD2 ON HASU_CHSE_CD2.HASU_CHSE_CD = LU.OLD_FKN_TNKI_CHSE_CD \n");

		if (super.kaikeiSyori.equals(LACSDefine.KaikeiSyori.SYOUSAI_0)) {
			super.sql.append(" LEFT JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN5 ON SKK_KEIJ_HOHO_KBN5.SKK_KEIJ_HOHO_KBN = LU.NEW_ITN_YUKEI_SKK_HOHO_CD \n");
			super.sql.append(" LEFT JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN6 ON SKK_KEIJ_HOHO_KBN6.SKK_KEIJ_HOHO_KBN = LU.NEW_ITN_MUKEI_SKK_HOHO_CD \n");
			super.sql.append(" LEFT JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN7 ON SKK_KEIJ_HOHO_KBN7.SKK_KEIJ_HOHO_KBN = LU.NEW_ITNGI_YUKEI_SKK_HOHO_CD \n");
			super.sql.append(" LEFT JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN8 ON SKK_KEIJ_HOHO_KBN8.SKK_KEIJ_HOHO_KBN = LU.NEW_ITNGI_MUKEI_SKK_HOHO_CD \n");
		}
		else {
			super.sql.append(" LEFT JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN5 ON SKK_KEIJ_HOHO_KBN5.SKK_KEIJ_HOHO_KBN = '" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' \n");
			super.sql.append(" LEFT JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN6 ON SKK_KEIJ_HOHO_KBN6.SKK_KEIJ_HOHO_KBN = '" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' \n");
			super.sql.append(" LEFT JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN7 ON SKK_KEIJ_HOHO_KBN7.SKK_KEIJ_HOHO_KBN = '" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' \n");
			super.sql.append(" LEFT JOIN M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN8 ON SKK_KEIJ_HOHO_KBN8.SKK_KEIJ_HOHO_KBN = '" + LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221 + "' \n");
		}

		super.sql.append(" LEFT JOIN M_HASU_CHSE_CD HASU_CHSE_CD3 ON HASU_CHSE_CD3.HASU_CHSE_CD = LU.NEW_GNKSK_HASU_CHSE_CD \n");

		if (super.kaikeiSyori.equals(LACSDefine.KaikeiSyori.SYOUSAI_0)) {
			super.sql.append(" LEFT JOIN M_RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN2 ON RSK_KEIJ_HOHO_KBN2.RSK_KEIJ_HOHO_KBN = LU.NEW_RSK_CLC_HOHO_CD \n");
		}
		else {
			super.sql.append(" LEFT JOIN M_RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN2 ON RSK_KEIJ_HOHO_KBN2.RSK_KEIJ_HOHO_KBN = '" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' \n");
		}
		super.sql.append(" LEFT JOIN M_FKN_TNKI_HOHO_CD FKN_TNKI_HOHO_CD2 ON FKN_TNKI_HOHO_CD2.FKN_TNKI_HOHO_CD = LU.NEW_FKN_TNKI_HOHO_CD \n");
		super.sql.append(" LEFT JOIN M_HASU_CHSE_CD HASU_CHSE_CD4 ON HASU_CHSE_CD4.HASU_CHSE_CD = LU.NEW_FKN_TNKI_CHSE_CD \n");
		super.sql.append(" WHERE LU.LU_COSMOS_CD = '" + this.leasCompanyCode + "' \n");

		System.out.println(super.sql);
		
	}
	
	/**
	 * リース会社を取得.
	 * 
	 * @return リース会社
	 */
	public String getLeaseCompanyNm() {
		return super.getString("LEASE_COMPANY_NM");
	}

	/**
	 * リース会社郵便番号を取得.
	 * 
	 * @return リース会社郵便番号
	 */
	public String getLeaseCompanyZipCd() {
		return super.getString("LEASE_COMPANY_ZIP");
	}

	/**
	 * リース会社住所１を取得.
	 * 
	 * @return リース会社住所１
	 */
	public String getLeaseCompanyAddr1() {
		return super.getString("LEASE_COMPANY_ADDR1");
	}

	/**
	 * リース会社住所２を取得.
	 * 
	 * @return リース会社住所２
	 */
	public String getLeaseCompanyAddr2() {
		return super.getString("LEASE_COMPANY_ADDR2");
	}

	/**
	 * リースユーザー郵便番号を取得.
	 * 
	 * @return リースユーザー郵便番号
	 */
	public String getLeaseUserZipCd() {
		return super.getString("LEASE_USER_ZIP");
	}

	/**
	 * リースユーザー住所１を取得.
	 * 
	 * @return リースユーザー住所１
	 */
	public String getLeaseUserAddr1() {
		return super.getString("LEASE_USER_ADDR1");
	}

	/**
	 * リースユーザー住所２を取得.
	 * 
	 * @return リースユーザー住所２
	 */
	public String getLeaseUserAddr2() {
		return super.getString("LEASE_USER_ADDR2");
	}

	/**
	 * リースユーザを取得.
	 * 
	 * @return リースユーザ
	 */
	public String getLeaseUserNm() {
		return super.getString("LEASE_USER_NM");
	}

	/**
	 * 旧移転償却方法 有形資産を取得.
	 * 
	 * @return 旧移転償却方法 有形資産
	 */
	public String getOldItenSyoukyakuYukei() {
		return super.getString("OLD_ITN_YUKEI_SKK_HOHO_NM");
	}

	/**
	 * 旧移転償却方法 無形資産を取得.
	 * 
	 * @return 旧移転償却方法 無形資産
	 */
	public String getOldItenSyoukyakuMukei() {
		return super.getString("OLD_ITN_MUKEI_SKK_HOHO_NM");
	}

	/**
	 * 旧移転外償却方法 有形資産を取得.
	 * 
	 * @return 旧移転外償却方法 有形資産
	 */
	public String getOldItenGaiSyoukyakuYukei() {
		return super.getString("OLD_ITNGI_YUKEI_SKK_HOHO_NM");
	}

	/**
	 * 旧移転外償却方法 無形資産を取得.
	 * 
	 * @return 旧移転外償却方法 無形資産
	 */
	public String getOldItenGaiSyoukyakuMukei() {
		return super.getString("OLD_ITNGI_MUKEI_SKK_HOHO_NM");
	}

	/**
	 * 旧移転外償却方法 端数調整を取得.
	 * 
	 * @return 旧移転外償却方法 端数調整
	 */
	public String getOldItenGaiSyoukyakuHasu() {
		return super.getString("OLD_GNKSK_HASU_CHSE_NM");
	}

	/**
	 * 旧利息計算方法 利息計算方法を取得.
	 * 
	 * @return 旧利息計算方法 利息計算方法
	 */
	public String getOldRisokuKeisan() {
		return super.getString("OLD_RSK_CLC_HOHO_NM");
	}

	/**
	 * 旧利息計算方法 賦金展開方法を取得.
	 * 
	 * @return 旧利息計算方法 賦金展開方法
	 */
	public String getOldRisokuHukin() {
		return super.getString("OLD_FKN_TNKI_HOHO_NM");
	}

	/**
	 * 旧利息計算方法 端数調整を取得.
	 * 
	 * @return 旧利息計算方法 端数調整
	 */
	public String getOldRisokuHasu() {
		return super.getString("OLD_FKN_TNKI_CHSE_NM");
	}

	/**
	 * 旧維持管理費重要性を取得.
	 * 
	 * @return 旧維持管理費重要性
	 */
	public String getOldJyuyouIji() {
		return super.getString("OLD_IJI_KNRI_HYO_JYO_KBN");
	}

	/**
	 * 旧役務提供費重要性を取得.
	 * 
	 * @return 旧役務提供費重要性
	 */
	public String getOldJyuyouEkimu() {
		return super.getString("OLD_EKM_TEIK_HYO_JYO_KBN");
	}

	/**
	 * 新移転償却方法 有形資産を取得.
	 * 
	 * @return 新移転償却方法 有形資産
	 */
	public String getNewItenSyoukyakuYukei() {
		return super.getString("NEW_ITN_YUKEI_SKK_HOHO_NM");
	}

	/**
	 * 新移転償却方法 無形資産を取得.
	 * 
	 * @return 新移転償却方法 無形資産
	 */
	public String getNewItenSyoukyakuMukei() {
		return super.getString("NEW_ITN_MUKEI_SKK_HOHO_NM");
	}

	/**
	 * 新移転外償却方法 有形資産を取得.
	 * 
	 * @return 新移転外償却方法 有形資産
	 */
	public String getNewItenGaiSyoukyakuYukei() {
		return super.getString("NEW_ITNGI_YUKEI_SKK_HOHO_NM");
	}

	/**
	 * 新移転外償却方法 無形資産を取得.
	 * 
	 * @return 新移転外償却方法 無形資産
	 */
	public String getNewItenGaiSyoukyakuMukei() {
		return super.getString("NEW_ITNGI_MUKEI_SKK_HOHO_NM");
	}

	/**
	 * 新移転外償却方法 端数調整を取得.
	 * 
	 * @return 新移転外償却方法 端数調整
	 */
	public String getNewItenGaiSyoukyakuHasu() {
		return super.getString("NEW_GNKSK_HASU_CHSE_NM");
	}

	/**
	 * 新利息計算方法 利息計算方法を取得.
	 * 
	 * @return 新利息計算方法 利息計算方法
	 */
	public String getNewRisokuKeisan() {
		return super.getString("NEW_RSK_CLC_HOHO_NM");
	}

	/**
	 * 新利息計算方法 賦金展開方法を取得.
	 * 
	 * @return 新利息計算方法 賦金展開方法
	 */
	public String getNewRisokuHukin() {
		return super.getString("NEW_FKN_TNKI_HOHO_NM");
	}

	/**
	 * 新利息計算方法 端数調整を取得.
	 * 
	 * @return 新利息計算方法 端数調整
	 */
	public String getNewRisokuHasu() {
		return super.getString("NEW_FKN_TNKI_CHSE_NM");
	}

	/**
	 * 新維持管理費重要性を取得.
	 * 
	 * @return 新維持管理費重要性
	 */
	public String getNewJyuyouIji() {
		return super.getString("NEW_IJI_KNRI_HYO_JYO_KBN");
	}

	/**
	 * 新役務提供費重要性を取得.
	 * 
	 * @return 新役務提供費重要性
	 */
	public String getNewJyuyouEkimu() {
		return super.getString("NEW_EKM_TEIK_HYO_JYO_KBN");
	}

	/**
	 * 注記書類作成基準書可変文言１を取得.
	 * 
	 * @return 注記書類作成基準書可変文言１
	 */
	public String getTyukiComment1() {
		return super.getString("TYUKI_COMMENT1");
	}

	/**
	 * 注記書類作成基準書可変文言２を取得.
	 * 
	 * @return 注記書類作成基準書可変文言２
	 */
	public String getTyukiComment2() {
		return super.getString("TYUKI_COMMENT2");
	}

}
