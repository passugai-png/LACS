package jp.co.pro_app.lacs.affairs.dsreport.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.dsreport.bean.LACSDSReportBean;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 帳票出力Entity用スーパークラス.
 * 
 * @author Katoh
 * @version 20080215
 */
public abstract class LACSDSReportEntityBase extends EntityBase {

	/**
	 * リース会社コード.
	 */
	protected String			leasCompanyCode	= "";

	/**
	 * LACS共通Bean.
	 */
	protected LACSCommonBean	commonBean;

	/**
	 * 契約有効期間From.
	 */
	protected String			dateFrom		= "";

	/**
	 * 対象月数.
	 */
	protected String			termNum			= "";

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            Model
	 * @param piCommonBean
	 *            LACS共通Bean
	 * @param piReportBean
	 *            帳票出力Bean
	 */
	public LACSDSReportEntityBase(DBModelBase piModel, LACSCommonBean piCommonBean, LACSDSReportBean piReportBean) {
		super(piModel);

		this.dateFrom = piReportBean.getTermFrom().getYYYYMMDD();
		this.termNum = piReportBean.getTermNum();

		this.leasCompanyCode = piReportBean.getLeasCompany().getValue();

		this.commonBean = piCommonBean;

	}

	/**
	 * 利息計上方法区分取得.
	 * 
	 * @param piTableName
	 *            テーブル名
	 * @return 利息計上方法区分
	 */
	protected String getRisokuKeijoHohoKbn(String piTableName) {
		return (piTableName == null || piTableName.trim().length() > 0 ? piTableName + "." : "") + "RSK_KEIJ_HOHO_KBN";
	}

	/**
	 * 償却計上方法区分取得.
	 * 
	 * @param piTableName
	 *            テーブル名
	 * @return 償却計上方法区分
	 */
	protected String getShoukyakuKeijoHohoKbn(String piTableName) {
		return (piTableName == null || piTableName.trim().length() > 0 ? piTableName + "." : "") + "SKK_KEIJ_HOHO_KBN";
	}

	/**
	 * 基本となるSQLを取得.
	 * 
	 * @return 基本となるSQL
	 */
	protected String getCoreSQL() {
		StringBuffer buf = new StringBuffer();

		buf.append("SELECT KEI.LC_CD " + "\n");
		buf.append("      ,KEI.KEI_NO " + "\n");
		buf.append("      ,KEI.HYJYO_KEI_NO HYJYO_KEI_NO " + "\n");
		buf.append("      ,KEI.RLS_TMS " + "\n");
		buf.append("      ,KEI.LU_COSMOS_CD " + "\n");
		buf.append("      ,KEI.LU_TRSK_CD " + "\n");
		buf.append("      ,KEI.KEI_YMD " + "\n");
		buf.append("      ,KEI.KNSHU_YMD " + "\n");
		buf.append("      ,KEI.MRYO_YMD " + "\n");
		buf.append("      ,KEI.KAI_YMD " + "\n");
		buf.append("      ,TO_CHAR(TO_DATE(KEI.KAI_YMD, 'YYYYMMDD') - 1,'YYYYMMDD') KAI_YMD_PRE " + "\n");
		buf.append("      ,KEI.KEI_TERM " + "\n");
		buf.append("      ,KEI.START_YMD " + "\n");
		buf.append("      ,KEI.END_YMD " + "\n");
		buf.append("      ,KEI.TRD_HNTE_KEKA_KBN " + "\n");
		buf.append("      ,KEI.TAISHO_AC_KIJYUN_CD " + "\n");
		buf.append("      ,KEI.CTSHK_FLG " + "\n");
		buf.append("      ,KEI.KEI_AMT KEI_AMT_KEI " + "\n");
		buf.append("      ,KEI.TNKI_HOHO_KBN " + "\n");
		buf.append("      ,KEI.CYT_KAI_KANO_KBN " + "\n");
		buf.append("      ,KEI.FKN_TNKI_CHSE_CD " + "\n");
		buf.append("      ,KEI.GNKSK_HASU_CHSE_CD " + "\n");
		buf.append("      ,KEI.IJI_KNRI_HYO_JYO_KBN " + "\n");
		buf.append("      ,KEI.EKM_TEIK_HYO_JYO_KBN " + "\n");
		buf.append("      ,KEI.SGK_SSN_KBN " + "\n");
		buf.append("      ,BKN.BKN_NO " + "\n");
		buf.append("      ,BKN.BKN_EDANO " + "\n");
		buf.append("      ," + this.getRisokuKeijoHohoKbn("BKN") + " RSK_KEIJ_HOHO_KBN " + "\n");
		buf.append("      ," + this.getShoukyakuKeijoHohoKbn("BKN") + " SKK_KEIJ_HOHO_KBN " + "\n");
		buf.append("      ,BKN.SSN_SRI_CD " + "\n");
		buf.append("      ,BKN.ZANK_HSHO_AMT " + "\n");
		buf.append("      ,BKN.ZANK_HSHOSK_CD " + "\n");
		buf.append("      ,BKN.IPN_ZANK_HSHOSK_CD " + "\n");
		buf.append("      ,BKN.KNU_AMT " + "\n");
		buf.append("      ,BKN.ABRI_WRBK_PV " + "\n");
		buf.append("      ,BKN.MBRI_WRBK_PV " + "\n");
		buf.append("      ,BKN.KEI_AMT " + "\n");
		buf.append("      ,BKN.KEI_AMT_STAX " + "\n");
		buf.append("      ,BKN.TY_YSU " + "\n");
		buf.append("      ,BKN.BKN_NM " + "\n");
		buf.append("      ,BKN.MBRI_WRBK_CLC_RS_RT " + "\n");
		buf.append("      ,BKN.ABRI_WRBK_CLC_RS_RT " + "\n");
		buf.append("      ,BKN.MBRI_RSK_CLC_RS_RT " + "\n");
		buf.append("      ,BKN.ABRI_RSK_CLC_RS_RT " + "\n");
		buf.append("      ,BKN.ENT_SHOHYO_KZI " + "\n");
		buf.append("      ,BKN.ENT_SHOHYO_HKZI " + "\n");
		buf.append("      ,BKN.GTAX " + "\n");
		buf.append("      ,BKN.CTAX " + "\n");
		buf.append("      ,BKN.JTAX " + "\n");
		buf.append("      ,BKN.JBSK_HKN " + "\n");
		buf.append("      ,BKN.NNI_HKN " + "\n");
		buf.append("      ,BKN.RCYCL_RYO_KNRI_AMT " + "\n");
		buf.append("      ,BKN.DOSO " + "\n");
		buf.append("      ,BKN.KOZEI " + "\n");
		buf.append("      ,BKN.OTH_CST " + "\n");
		buf.append("      ,BKN.IPN_EKM_TEIK_HYO " + "\n");
		buf.append("      ,BKN.SHRY_EKM_TEIK_HYO " + "\n");
		buf.append("      ,KEI.NEXT_START_YMD " + "\n");
		buf.append("      ,KEI.NEXT_END_YMD " + "\n");
		buf.append("      ,KEI.OVER_NEXT_END_YMD " + "\n");
		buf.append("      ,KEI.START_KEIJ_YM " + "\n");
		buf.append("      ,KEI.END_KEIJ_YM " + "\n");
		buf.append("      ,KEI.NEXT_START_KEIJ_YM " + "\n");
		buf.append("      ,KEI.NEXT_END_KEIJ_YM " + "\n");
		buf.append("      ,KEI.OVER_NEXT_START_KEIJ_YM " + "\n");
		buf.append("      ,KEI.MRYO_KEIJ_YM " + "\n");
		buf.append("      ,KEI.KAI_START_KEIJ_YM " + "\n");
		buf.append("      ,BKN.FKN_KEIJ_YM_MAX " + "\n");
		buf.append("      ,BKN.GNKSK_KEIJ_YM_MAX " + "\n");
		buf.append("      ,BKN.GNKSK_KEIJ_YM_ZANKA_LAST " + "\n");
		buf.append("      ,NVL(KEI.KAI_KEIJ_YM, '999999') KAI_KEIJ_YM " + "\n");
		buf.append("      ,GREATEST(BKN.FKN_KEIJ_YM_MAX, DECODE(KAI_YMD, NULL, KEI.MRYO_KEIJ_YM, '000000')) FKN_KEIJ_YM_GREATEST " + "\n");
		buf.append("      ,GREATEST(BKN.GNKSK_KEIJ_YM_MAX, DECODE(KAI_YMD, NULL, KEI.MRYO_KEIJ_YM, '000000')) GNKSK_KEIJ_YM_GREATEST " + "\n");
		buf.append("      ,LEAST(GREATEST(BKN.FKN_KEIJ_YM_MAX, DECODE(KAI_YMD, NULL, KEI.MRYO_KEIJ_YM, '000000')), KEI.END_KEIJ_YM, NVL(KEI.KAI_KEIJ_YM,'999999')) FKN_KEIJ_YM_LAST " + "\n");
		buf.append("      ,LEAST(GREATEST(BKN.GNKSK_KEIJ_YM_MAX, DECODE(KAI_YMD, NULL, KEI.MRYO_KEIJ_YM, '000000')), KEI.END_KEIJ_YM, NVL(KEI.KAI_KEIJ_YM,'999999')) GNKSK_KEIJ_YM_LAST " + "\n");
		buf.append("      ,CASE " + "\n");
		buf.append("           WHEN SUBSTR(KEI.MRYO_YMD, 1, 6) >= GNKSK_KEIJ_YM_MAX THEN " + "\n");
		buf.append("               KEI.MRYO_YMD " + "\n");
		buf.append("           ELSE " + "\n");
		buf.append("               TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.TO_BACK_DATE(NVL(GNKSK_KEIJ_YM_MAX, '999911') || SUBSTR(KNSHU_YMD, -2)), 'YYYYMMDD'), 1) -1, 'YYYYMMDD') " + "\n");
		buf.append("       END GNKSK_LAST_YMD " + "\n");
		buf.append("      ,CASE " + "\n");
		buf.append("           WHEN SUBSTR(KEI.MRYO_YMD, 1, 6) >= FKN_KEIJ_YM_MAX THEN " + "\n");
		buf.append("               KEI.MRYO_YMD " + "\n");
		buf.append("           ELSE " + "\n");
		buf.append("               TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.TO_BACK_DATE(NVL(FKN_KEIJ_YM_MAX, '999911') || SUBSTR(KNSHU_YMD, -2)), 'YYYYMMDD'), 1) -1, 'YYYYMMDD') " + "\n");
		buf.append("       END FKN_LAST_YMD " + "\n");
		buf.append("FROM   (SELECT T.* " + "\n");
		buf.append("              ,'" + this.dateFrom + "' START_YMD " + "\n");
		buf.append("              ,LACS_COMMON.GET_TERM_DATE('" + this.dateFrom + "', " + this.termNum + ") END_YMD " + "\n");
		buf.append("              ,LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE('" + this.dateFrom + "', " + this.termNum + ")) NEXT_START_YMD " + "\n");
		buf.append("              ,LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE(LACS_COMMON.GET_TERM_DATE('" + this.dateFrom + "', " + this.termNum + "), 12)) NEXT_END_YMD " + "\n");
		buf.append("              ,LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE(LACS_COMMON.GET_TERM_DATE('" + this.dateFrom + "', " + this.termNum + "), 12))) OVER_NEXT_END_YMD " + "\n");
		buf.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD, '" + this.dateFrom + "', '" + this.dateFrom + "') START_KEIJ_YM " + "\n");
		buf.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD, '" + this.dateFrom + "', LACS_COMMON.GET_TERM_DATE(SUBSTR('" + this.dateFrom + "', 1, 6) || '01', " + this.termNum + ")) END_KEIJ_YM " + "\n");
		buf.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD, '" + this.dateFrom + "', LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE(SUBSTR('" + this.dateFrom + "', 1, 6) || '01', " + this.termNum + "))) NEXT_START_KEIJ_YM " + "\n");
		buf.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD, '" + this.dateFrom + "', LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE(LACS_COMMON.GET_TERM_DATE(SUBSTR('" + this.dateFrom + "', 1, 6) || '01', " + this.termNum + "), 12))) NEXT_END_KEIJ_YM " + "\n");
		buf.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD, '" + this.dateFrom + "', LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_NEXT_DATE(LACS_COMMON.GET_TERM_DATE(LACS_COMMON.GET_TERM_DATE(SUBSTR('" + this.dateFrom + "', 1, 6) || '01', " + this.termNum + "), 12)))) OVER_NEXT_START_KEIJ_YM " + "\n");
		buf.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD, '" + this.dateFrom + "', T.MRYO_YMD) MRYO_KEIJ_YM " + "\n");
		buf.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD, '" + this.dateFrom + "', TO_CHAR(TO_DATE(T.KAI_YMD, 'YYYYMMDD') - 1, 'YYYYMMDD')) KAI_KEIJ_YM " + "\n");
		buf.append("              ,NVL(LACS_COMMON.GET_KEIJ_YYYYMM(T.KNSHU_YMD, KAI_YMD, KAI_YMD), '999999') KAI_START_KEIJ_YM " + "\n");
		buf.append("        FROM   T_KEI T " + "\n");
		buf.append("        WHERE  T.ERR_FLG = '0') KEI " + "\n");
		buf.append("INNER  JOIN (SELECT B.* " + "\n");
		buf.append("                  ,(SELECT MAX(KEIJ_YM) " + "\n");
		buf.append("                    FROM   T_UKB_TNKI_HEAD FKN_HEAD " + "\n");
		buf.append("                    WHERE  FKN_HEAD.LC_CD = B.LC_CD " + "\n");
		buf.append("                    AND    FKN_HEAD.KEI_NO = B.KEI_NO " + "\n");
		buf.append("                    AND    FKN_HEAD.BKN_NO = B.BKN_NO " + "\n");
		buf.append("                    AND    FKN_HEAD.BKN_EDANO = B.BKN_EDANO " + "\n");
		buf.append("                    AND    FKN_HEAD.KAI_REC_FLG = '0') FKN_KEIJ_YM_MAX " + "\n");
		buf.append("                  ,(SELECT MAX(KEIJ_YM) " + "\n");
		buf.append("                    FROM   T_UKB_GNKSK GNKSK " + "\n");
		buf.append("                    WHERE  GNKSK.LC_CD = B.LC_CD " + "\n");
		buf.append("                    AND    GNKSK.KEI_NO = B.KEI_NO " + "\n");
		buf.append("                    AND    GNKSK.BKN_NO = B.BKN_NO " + "\n");
		buf.append("                    AND    GNKSK.BKN_EDANO = B.BKN_EDANO " + "\n");
		buf.append("                    AND    GNKSK.KEIJ_HOHO_KBN = " + this.getShoukyakuKeijoHohoKbn("B") + " " + "\n");
		buf.append("                    AND    GNKSK.KAI_REC_FLG = '0') GNKSK_KEIJ_YM_MAX " + "\n");
		buf.append("                  ,(SELECT MAX(KEIJ_YM) " + "\n");
		buf.append("                    FROM   T_UKB_GNKSK GNKSK " + "\n");
		buf.append("                    WHERE  GNKSK.LC_CD = B.LC_CD " + "\n");
		buf.append("                    AND    GNKSK.KEI_NO = B.KEI_NO " + "\n");
		buf.append("                    AND    GNKSK.BKN_NO = B.BKN_NO " + "\n");
		buf.append("                    AND    GNKSK.BKN_EDANO = B.BKN_EDANO " + "\n");
		buf.append("                    AND    GNKSK.KEIJ_HOHO_KBN = " + this.getShoukyakuKeijoHohoKbn("B") + ") GNKSK_KEIJ_YM_ZANKA_LAST " + "\n");
		buf.append("            FROM   T_BKN B) BKN ON KEI.LC_CD = BKN.LC_CD " + "\n");
		buf.append("                            AND    KEI.KEI_NO = BKN.KEI_NO ");

		return buf.toString();
	}

}
