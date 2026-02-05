package jp.co.pro_app.lacs.affairs.ukebarai.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リース料受払明細表Entity.
 * 
 * @author active
 * @version 20080811
 */
public class LACSUkebaraiLeaseCtskSTaxEntity extends EntityBase {

	private String	cosmosCode	= "";	// COSMOSコード

	private String	dateFrom	= "";	// 期間開始年月日

	private String	term		= "";	// 集計期間

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 * @param piCommonBean
	 *            共通Bean
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 */
	public LACSUkebaraiLeaseCtskSTaxEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSUkebaraiBean piUkebaraiBean) {
		super(piModel);

		this.cosmosCode = piUkebaraiBean.getLeasCompany().getValue();

		this.dateFrom = piUkebaraiBean.getTermFrom().getYYYYMMDD();

		this.term = piUkebaraiBean.getTsukiSu();
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT KEI.TAISHO_AC_KIJYUN_CD " + "\n");
		// 2020/05/22 ADD START
		super.sql.append("      ,CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN 'あり' ELSE 'なし' END                                            JYSI_UM                     -- 重要性有無" + "\n");
		// 2020/05/22 ADD END
		super.sql.append("      ,KEI.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("      ,KEI.KEI_NO                                                                                                                           -- 契約番号 " + "\n");
		super.sql.append("      ,KEI.HYJYO_KEI_NO                                                                                                                     -- 契約番号（表示用契約番号） " + "\n");
		super.sql.append("      ,CTSHK_FLG " + "\n");
		super.sql.append("      ,CASE WHEN RTRIM(BKN.BKN_EDANO) IS NOT NULL THEN " + "\n");
		super.sql.append("                 BKN.BKN_NO || '-' || BKN.BKN_EDANO " + "\n");
		super.sql.append("            ELSE BKN.BKN_NO " + "\n");
		super.sql.append("       END                                                                                                      BKN_NO                      -- 物件番号 " + "\n");
		super.sql.append("      ,SUM(KARIBARAI_SOUGAKU)                                                                                   KARIBARAI_SOUGAKU             -- 仮払消費税-総額 " + "\n");
		super.sql.append("      ,SUM(KARIBARAI_ZENKIMATU_AMT)                                                                             KARIBARAI_ZENKIMATU_AMT       -- 仮払消費税-前期末 " + "\n");
		super.sql.append("      ,SUM(KARIBARAI_TOUKI_JITUGEN_AMT)                                                                         KARIBARAI_TOUKI_JITUGEN_AMT   -- 仮払消費税-当期実現 " + "\n");
		super.sql.append("      ,SUM(KARIBARAI_TOUKI_GENSYO_AMT)                                                                          KARIBARAI_TOUKI_GENSYO_AMT    -- 仮払消費税-当期減少 " + "\n");
		super.sql.append("      ,SUM(KARIBARAI_TOUKIMATU_AMT)                                                                             KARIBARAI_TOUKIMATU_AMT       -- 仮払消費税-当期末 " + "\n");
		super.sql.append("      ,SUM(KARIBARAI_TOUKIMATU_AMT)                                                                             KARIBARAI_TOUKIMATU_AMT       -- 仮払消費税-当期末 " + "\n");
		super.sql.append("  FROM ( " + "\n");
		super.sql.append("        SELECT UKB_HEAD.LC_CD                                                                                                               -- リース会社コード " + "\n");
		super.sql.append("              ,UKB_HEAD.KEI_NO                                                                                                              -- 契約番号 " + "\n");
		super.sql.append("              ,UKB_HEAD.BKN_NO                                                                                                              -- 物件番号 " + "\n");
		super.sql.append("              ,UKB_HEAD.BKN_EDANO                                                                                                           -- 物件番号枝番 " + "\n");
		super.sql.append("              ,NVL(UKB_HEAD.SOU_LAMT_STAX, 0)                                                                 KARIBARAI_SOUGAKU             -- 仮払消費税-総額 " + "\n");
		super.sql.append("              ,0                                                                                              KARIBARAI_ZENKIMATU_AMT       -- 仮払消費税-前期末 " + "\n");
		super.sql.append("              ,0                                                                                              KARIBARAI_TOUKI_JITUGEN_AMT   -- 仮払消費税-当期実現 " + "\n");
		super.sql.append("              ,0                                                                                              KARIBARAI_TOUKI_GENSYO_AMT    -- 仮払消費税-当期減少 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         CASE WHEN WHEAD.MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                   0 " + "\n");
		super.sql.append("                              ELSE " + "\n");
		super.sql.append("                                   NVL(UKB_HEAD.RUI_LAMT_STAX, 0) " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         CASE WHEN GREATEST(WHEAD.MAX_KEIJ_YM, MRYO_KEIJ_YM) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                   0 " + "\n");
		super.sql.append("                              ELSE " + "\n");
		super.sql.append("                                   NVL(UKB_HEAD.RUI_LAMT_STAX, 0) " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("               END                                                                                            KARIBARAI_TOUKIMATU_AMT       -- 仮払消費税-当期末 " + "\n");
		super.sql.append("        FROM   (SELECT KEI.LC_CD -- リース会社コード " + "\n");
		super.sql.append("                      ,KEI.KEI_NO -- 契約番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_NO -- 物件番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_EDANO -- 物件番号枝番 " + "\n");
		super.sql.append("                      ,BKN.RSK_KEIJ_HOHO_KBN -- 採用利息計上方法区分 " + "\n");
		super.sql.append("                      ,KEI.KAI_YMD " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', '" + this.dateFrom + "') STR_KEIJ_YM -- 対象期間開始年月 " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', LACS_COMMON.GET_TERM_DATE(SUBSTR('" + this.dateFrom + "', 1, 6) || '01', " + this.term + ")) END_KEIJ_YM -- 対象期間終了年月 " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', KEI.MRYO_YMD) MRYO_KEIJ_YM -- 満了計上年月 " + "\n");
		super.sql.append("                FROM   T_KEI KEI " + "\n");
		super.sql.append("                      ,T_BKN BKN " + "\n");
		super.sql.append("                WHERE  KEI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("                AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("                AND    KEI.LC_CD = 'LACS' " + "\n");
		super.sql.append("                AND    KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
		super.sql.append("                AND    KEI.ERR_FLG = '0') BSE " + "\n");
		super.sql.append("              ,(SELECT HEAD.LC_CD -- リース会社コード " + "\n");
		super.sql.append("                      ,HEAD.KEI_NO -- 契約番号 " + "\n");
		super.sql.append("                      ,HEAD.BKN_NO -- 物件番号 " + "\n");
		super.sql.append("                      ,HEAD.BKN_EDANO -- 物件番号枝番 " + "\n");
		super.sql.append("                      ,MIN(HEAD.KEIJ_YM) MIN_KEIJ_YM -- 最小計上年月 " + "\n");
		super.sql.append("                      ,MAX(HEAD.KEIJ_YM) MAX_KEIJ_YM -- 最大計上年月 " + "\n");
		super.sql.append("                FROM   T_KEI           KEI " + "\n");
		super.sql.append("                      ,T_BKN           BKN " + "\n");
		super.sql.append("                      ,T_UKB_TNKI_HEAD HEAD " + "\n");
		super.sql.append("                WHERE  KEI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("                AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("                AND    HEAD.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("                AND    HEAD.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("                AND    HEAD.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("                AND    HEAD.BKN_EDANO = BKN.BKN_EDANO " + "\n");
		super.sql.append("                AND    KEI.LC_CD = 'LACS' " + "\n");
		super.sql.append("                AND    KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
		super.sql.append("                AND    KEI.ERR_FLG      = '0' " + "\n");
		super.sql.append("                AND    HEAD.KAI_REC_FLG = '0' " + "\n");
		super.sql.append("                GROUP  BY HEAD.LC_CD " + "\n");
		super.sql.append("                         ,HEAD.KEI_NO " + "\n");
		super.sql.append("                         ,HEAD.BKN_NO " + "\n");
		super.sql.append("                         ,HEAD.BKN_EDANO) WHEAD " + "\n");
		super.sql.append("              ,T_UKB_TNKI_HEAD   UKB_HEAD " + "\n");
		super.sql.append("              ,T_UKB_TNKI_DETAIL UKB_DTL " + "\n");
		super.sql.append("        WHERE  UKB_HEAD.LC_CD = BSE.LC_CD " + "\n");
		super.sql.append("        AND    UKB_HEAD.KEI_NO = BSE.KEI_NO " + "\n");
		super.sql.append("        AND    UKB_HEAD.BKN_NO = BSE.BKN_NO " + "\n");
		super.sql.append("        AND    UKB_HEAD.BKN_EDANO = BSE.BKN_EDANO " + "\n");
		super.sql.append("        AND    UKB_HEAD.KEIJ_YM = LEAST(BSE.END_KEIJ_YM, WHEAD.MAX_KEIJ_YM) " + "\n");
		super.sql.append("        AND    UKB_HEAD.LC_CD = UKB_DTL.LC_CD " + "\n");
		super.sql.append("        AND    UKB_HEAD.KEI_NO = UKB_DTL.KEI_NO " + "\n");
		super.sql.append("        AND    UKB_HEAD.BKN_NO = UKB_DTL.BKN_NO " + "\n");
		super.sql.append("        AND    UKB_HEAD.BKN_EDANO = UKB_DTL.BKN_EDANO " + "\n");
		super.sql.append("        AND    UKB_HEAD.KEIJ_YM = UKB_DTL.KEIJ_YM " + "\n");
		super.sql.append("        AND    BSE.RSK_KEIJ_HOHO_KBN = UKB_DTL.KEIJ_HOHO_KBN " + "\n");
		super.sql.append("        AND    BSE.LC_CD = WHEAD.LC_CD " + "\n");
		super.sql.append("        AND    BSE.KEI_NO = WHEAD.KEI_NO " + "\n");
		super.sql.append("        AND    BSE.BKN_NO = WHEAD.BKN_NO " + "\n");
		super.sql.append("        AND    BSE.BKN_EDANO = WHEAD.BKN_EDANO " + "\n");
		super.sql.append("        AND    BSE.END_KEIJ_YM >= WHEAD.MIN_KEIJ_YM " + "\n");
		super.sql.append("        AND    BSE.STR_KEIJ_YM <= CASE WHEN BSE.KAI_YMD IS NOT NULL THEN WHEAD.MAX_KEIJ_YM ELSE GREATEST(WHEAD.MAX_KEIJ_YM, MRYO_KEIJ_YM) END " + "\n");
		super.sql.append("        UNION ALL " + "\n");
		super.sql.append("        SELECT UKB_HEAD.LC_CD                                                                                                               -- リース会社コード " + "\n");
		super.sql.append("              ,UKB_HEAD.KEI_NO                                                                                                              -- 契約番号 " + "\n");
		super.sql.append("              ,UKB_HEAD.BKN_NO                                                                                                              -- 物件番号 " + "\n");
		super.sql.append("              ,UKB_HEAD.BKN_EDANO                                                                                                           -- 物件番号枝番 " + "\n");
		super.sql.append("              ,0                                                                                              KARIBARAI_SOUGAKU             -- 仮払消費税-総額 " + "\n");
		super.sql.append("              ,NVL(UKB_HEAD.RUI_LAMT_STAX, 0)                                                                 KARIBARAI_ZENKIMATU_AMT       -- 仮払消費税-前期末 " + "\n");
		super.sql.append("              ,0                                                                                              KARIBARAI_TOUKI_JITUGEN_AMT   -- 仮払消費税-当期実現 " + "\n");
		super.sql.append("              ,0                                                                                              KARIBARAI_TOUKI_GENSYO_AMT    -- 仮払消費税-当期減少 " + "\n");
		super.sql.append("              ,0                                                                                              KARIBARAI_TOUKIMATU_AMT       -- 仮払消費税-当期末 " + "\n");
		super.sql.append("        FROM   (SELECT KEI.LC_CD -- リース会社コード " + "\n");
		super.sql.append("                      ,KEI.KEI_NO -- 契約番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_NO -- 物件番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_EDANO -- 物件番号枝番 " + "\n");
		super.sql.append("                      ,BKN.RSK_KEIJ_HOHO_KBN -- 採用利息計上方法区分 " + "\n");
		super.sql.append("                      ,KEI.KAI_YMD " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', '" + this.dateFrom + "') STR_KEIJ_YM -- 対象期間開始年月 " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', LACS_COMMON.GET_TERM_DATE(SUBSTR('" + this.dateFrom + "', 1, 6) || '01', " + this.term + ")) END_KEIJ_YM -- 対象期間終了年月 " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', KEI.MRYO_YMD) MRYO_KEIJ_YM -- 満了計上年月 " + "\n");
		super.sql.append("                FROM   T_KEI KEI " + "\n");
		super.sql.append("                      ,T_BKN BKN " + "\n");
		super.sql.append("                WHERE  KEI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("                AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("                AND    KEI.LC_CD = 'LACS' " + "\n");
		super.sql.append("                AND    KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
		super.sql.append("                AND    KEI.ERR_FLG      = '0') BSE " + "\n");
		super.sql.append("              ,(SELECT HEAD.LC_CD -- リース会社コード " + "\n");
		super.sql.append("                      ,HEAD.KEI_NO -- 契約番号 " + "\n");
		super.sql.append("                      ,HEAD.BKN_NO -- 物件番号 " + "\n");
		super.sql.append("                      ,HEAD.BKN_EDANO -- 物件番号枝番 " + "\n");
		super.sql.append("                      ,MIN(HEAD.KEIJ_YM) MIN_KEIJ_YM -- 最小計上年月 " + "\n");
		super.sql.append("                      ,MAX(HEAD.KEIJ_YM) MAX_KEIJ_YM -- 最大計上年月 " + "\n");
		super.sql.append("                FROM   T_KEI           KEI " + "\n");
		super.sql.append("                      ,T_BKN           BKN " + "\n");
		super.sql.append("                      ,T_UKB_TNKI_HEAD HEAD " + "\n");
		super.sql.append("                WHERE  KEI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("                AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("                AND    HEAD.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("                AND    HEAD.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("                AND    HEAD.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("                AND    HEAD.BKN_EDANO = BKN.BKN_EDANO " + "\n");
		super.sql.append("                AND    KEI.LC_CD = 'LACS' " + "\n");
		super.sql.append("                AND    KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
		super.sql.append("                AND    KEI.ERR_FLG      = '0' " + "\n");
		super.sql.append("                AND    HEAD.KAI_REC_FLG = '0' " + "\n");
		super.sql.append("                GROUP  BY HEAD.LC_CD " + "\n");
		super.sql.append("                         ,HEAD.KEI_NO " + "\n");
		super.sql.append("                         ,HEAD.BKN_NO " + "\n");
		super.sql.append("                         ,HEAD.BKN_EDANO) WHEAD " + "\n");
		super.sql.append("              ,T_UKB_TNKI_HEAD   UKB_HEAD " + "\n");
		super.sql.append("              ,T_UKB_TNKI_DETAIL UKB_DTL " + "\n");
		super.sql.append("        WHERE  UKB_HEAD.LC_CD = BSE.LC_CD " + "\n");
		super.sql.append("        AND    UKB_HEAD.KEI_NO = BSE.KEI_NO " + "\n");
		super.sql.append("        AND    UKB_HEAD.BKN_NO = BSE.BKN_NO " + "\n");
		super.sql.append("        AND    UKB_HEAD.BKN_EDANO = BSE.BKN_EDANO " + "\n");
		super.sql.append("        AND    UKB_HEAD.KEIJ_YM = LEAST(LACS_COMMON.ADD_MONTHS_YM(BSE.STR_KEIJ_YM, -1), WHEAD.MAX_KEIJ_YM) " + "\n");
		super.sql.append("        AND    UKB_HEAD.LC_CD = UKB_DTL.LC_CD " + "\n");
		super.sql.append("        AND    UKB_HEAD.KEI_NO = UKB_DTL.KEI_NO " + "\n");
		super.sql.append("        AND    UKB_HEAD.BKN_NO = UKB_DTL.BKN_NO " + "\n");
		super.sql.append("        AND    UKB_HEAD.BKN_EDANO = UKB_DTL.BKN_EDANO " + "\n");
		super.sql.append("        AND    UKB_HEAD.KEIJ_YM = UKB_DTL.KEIJ_YM " + "\n");
		super.sql.append("        AND    BSE.RSK_KEIJ_HOHO_KBN = UKB_DTL.KEIJ_HOHO_KBN " + "\n");
		super.sql.append("        AND    BSE.LC_CD = WHEAD.LC_CD " + "\n");
		super.sql.append("        AND    BSE.KEI_NO = WHEAD.KEI_NO " + "\n");
		super.sql.append("        AND    BSE.BKN_NO = WHEAD.BKN_NO " + "\n");
		super.sql.append("        AND    BSE.BKN_EDANO = WHEAD.BKN_EDANO " + "\n");
		super.sql.append("        AND    BSE.END_KEIJ_YM >= WHEAD.MIN_KEIJ_YM " + "\n");
		super.sql.append("        AND    BSE.STR_KEIJ_YM <= CASE WHEN BSE.KAI_YMD IS NOT NULL THEN WHEAD.MAX_KEIJ_YM ELSE GREATEST(WHEAD.MAX_KEIJ_YM, MRYO_KEIJ_YM) END " + "\n");
		super.sql.append("        UNION ALL " + "\n");
		super.sql.append("        SELECT UKB_HEAD.LC_CD                                                                                                               -- リース会社コード " + "\n");
		super.sql.append("              ,UKB_HEAD.KEI_NO                                                                                                              -- 契約番号 " + "\n");
		super.sql.append("              ,UKB_HEAD.BKN_NO                                                                                                              -- 物件番号 " + "\n");
		super.sql.append("              ,UKB_HEAD.BKN_EDANO                                                                                                           -- 物件番号枝番 " + "\n");
		super.sql.append("              ,0                                                                                              KARIBARAI_SOUGAKU             -- 仮払消費税-総額 " + "\n");
		super.sql.append("              ,0                                                                                              KARIBARAI_ZENKIMATU_AMT       -- 仮払消費税-前期末 " + "\n");
		super.sql.append("              ,NVL(LAMT_STAX, 0)                                                                              KARIBARAI_TOUKI_JITUGEN_AMT   -- 仮払消費税-当期実現 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN  " + "\n");
		super.sql.append("                         CASE WHEN WHEAD.MAX_KEIJ_YM = UKB_HEAD.KEIJ_YM THEN  " + "\n");
		super.sql.append("                                   NVL(UKB_HEAD.RUI_LAMT_STAX, 0) " + "\n");
		super.sql.append("                              ELSE 0  " + "\n");
		super.sql.append("                         END  " + "\n");
		super.sql.append("                    ELSE  " + "\n");
		super.sql.append("                         0 " + "\n");
		super.sql.append("               END                                                                                            KARIBARAI_TOUKI_GENSYO_AMT    -- 仮払消費税-当期減少 " + "\n");
		super.sql.append("              ,0                                                                                              KARIBARAI_TOUKIMATU_AMT       -- 仮払消費税-当期末 " + "\n");
		super.sql.append("        FROM   (SELECT KEI.LC_CD -- リース会社コード " + "\n");
		super.sql.append("                      ,KEI.KEI_NO -- 契約番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_NO -- 物件番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_EDANO -- 物件番号枝番 " + "\n");
		super.sql.append("                      ,BKN.RSK_KEIJ_HOHO_KBN -- 採用利息計上方法区分 " + "\n");
		super.sql.append("                      ,KEI.KAI_YMD " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', '" + this.dateFrom + "') STR_KEIJ_YM -- 対象期間開始年月 " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', LACS_COMMON.GET_TERM_DATE(SUBSTR('" + this.dateFrom + "', 1, 6) || '01', " + this.term + ")) END_KEIJ_YM -- 対象期間終了年月 " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', KEI.MRYO_YMD) MRYO_KEIJ_YM -- 満了計上年月 " + "\n");
		super.sql.append("                FROM   T_KEI KEI " + "\n");
		super.sql.append("                      ,T_BKN BKN " + "\n");
		super.sql.append("                WHERE  KEI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("                AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("                AND    KEI.LC_CD = 'LACS' " + "\n");
		super.sql.append("                AND    KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
		super.sql.append("                AND    KEI.ERR_FLG      = '0') BSE " + "\n");
		super.sql.append("              ,(SELECT HEAD.LC_CD -- リース会社コード " + "\n");
		super.sql.append("                      ,HEAD.KEI_NO -- 契約番号 " + "\n");
		super.sql.append("                      ,HEAD.BKN_NO -- 物件番号 " + "\n");
		super.sql.append("                      ,HEAD.BKN_EDANO -- 物件番号枝番 " + "\n");
		super.sql.append("                      ,MIN(HEAD.KEIJ_YM) MIN_KEIJ_YM -- 最小計上年月 " + "\n");
		super.sql.append("                      ,MAX(HEAD.KEIJ_YM) MAX_KEIJ_YM -- 最大計上年月 " + "\n");
		super.sql.append("                FROM   T_KEI           KEI " + "\n");
		super.sql.append("                      ,T_BKN           BKN " + "\n");
		super.sql.append("                      ,T_UKB_TNKI_HEAD HEAD " + "\n");
		super.sql.append("                WHERE  KEI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("                AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("                AND    HEAD.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("                AND    HEAD.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("                AND    HEAD.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("                AND    HEAD.BKN_EDANO = BKN.BKN_EDANO " + "\n");
		super.sql.append("                AND    KEI.LC_CD = 'LACS' " + "\n");
		super.sql.append("                AND    KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
		super.sql.append("                AND    KEI.ERR_FLG      = '0' " + "\n");
		super.sql.append("                AND    HEAD.KAI_REC_FLG = '0' " + "\n");
		super.sql.append("                GROUP  BY HEAD.LC_CD " + "\n");
		super.sql.append("                         ,HEAD.KEI_NO " + "\n");
		super.sql.append("                         ,HEAD.BKN_NO " + "\n");
		super.sql.append("                         ,HEAD.BKN_EDANO) WHEAD " + "\n");
		super.sql.append("              ,T_UKB_TNKI_HEAD   UKB_HEAD " + "\n");
		super.sql.append("              ,T_UKB_TNKI_DETAIL UKB_DTL " + "\n");
		super.sql.append("        WHERE  UKB_HEAD.LC_CD = BSE.LC_CD " + "\n");
		super.sql.append("        AND    UKB_HEAD.KEI_NO = BSE.KEI_NO " + "\n");
		super.sql.append("        AND    UKB_HEAD.BKN_NO = BSE.BKN_NO " + "\n");
		super.sql.append("        AND    UKB_HEAD.BKN_EDANO = BSE.BKN_EDANO " + "\n");
		super.sql.append("        AND    UKB_HEAD.KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM " + "\n");
		super.sql.append("        AND    UKB_HEAD.LC_CD = UKB_DTL.LC_CD " + "\n");
		super.sql.append("        AND    UKB_HEAD.KEI_NO = UKB_DTL.KEI_NO " + "\n");
		super.sql.append("        AND    UKB_HEAD.BKN_NO = UKB_DTL.BKN_NO " + "\n");
		super.sql.append("        AND    UKB_HEAD.BKN_EDANO = UKB_DTL.BKN_EDANO " + "\n");
		super.sql.append("        AND    UKB_HEAD.KEIJ_YM = UKB_DTL.KEIJ_YM " + "\n");
		super.sql.append("        AND    BSE.RSK_KEIJ_HOHO_KBN = UKB_DTL.KEIJ_HOHO_KBN " + "\n");
		super.sql.append("        AND    BSE.LC_CD = WHEAD.LC_CD " + "\n");
		super.sql.append("        AND    BSE.KEI_NO = WHEAD.KEI_NO " + "\n");
		super.sql.append("        AND    BSE.BKN_NO = WHEAD.BKN_NO " + "\n");
		super.sql.append("        AND    BSE.BKN_EDANO = WHEAD.BKN_EDANO " + "\n");
		super.sql.append("        AND    BSE.END_KEIJ_YM >= WHEAD.MIN_KEIJ_YM " + "\n");
		super.sql.append("        AND    BSE.STR_KEIJ_YM <= CASE WHEN BSE.KAI_YMD IS NOT NULL THEN WHEAD.MAX_KEIJ_YM ELSE GREATEST(WHEAD.MAX_KEIJ_YM, MRYO_KEIJ_YM) END " + "\n");
		super.sql.append("        UNION ALL " + "\n");
		super.sql.append("        SELECT UKB_HEAD.LC_CD                                                                                                               -- リース会社コード " + "\n");
		super.sql.append("              ,UKB_HEAD.KEI_NO                                                                                                              -- 契約番号 " + "\n");
		super.sql.append("              ,UKB_HEAD.BKN_NO                                                                                                              -- 物件番号 " + "\n");
		super.sql.append("              ,UKB_HEAD.BKN_EDANO                                                                                                           -- 物件番号枝番 " + "\n");
		super.sql.append("              ,0                                                                                              KARIBARAI_SOUGAKU             -- 仮払消費税-総額 " + "\n");
		super.sql.append("              ,0                                                                                              KARIBARAI_ZENKIMATU_AMT       -- 仮払消費税-前期末 " + "\n");
		super.sql.append("              ,0                                                                                              KARIBARAI_TOUKI_JITUGEN_AMT   -- 仮払消費税-当期実現 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN  " + "\n");
		super.sql.append("                         0  " + "\n");
		super.sql.append("                    ELSE  " + "\n");
		super.sql.append("                         NVL(UKB_HEAD.RUI_LAMT_STAX, 0) " + "\n");
		super.sql.append("               END                                                                                            KARIBARAI_TOUKI_GENSYO_AMT    -- 仮払消費税-当期減少 " + "\n");
		super.sql.append("              ,0                                                                                              KARIBARAI_TOUKIMATU_AMT       -- 仮払消費税-当期末 " + "\n");
		super.sql.append("        FROM   (SELECT KEI.LC_CD -- リース会社コード " + "\n");
		super.sql.append("                      ,KEI.KEI_NO -- 契約番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_NO -- 物件番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_EDANO -- 物件番号枝番 " + "\n");
		super.sql.append("                      ,BKN.RSK_KEIJ_HOHO_KBN -- 採用利息計上方法区分 " + "\n");
		super.sql.append("                      ,KEI.KAI_YMD " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', '" + this.dateFrom + "') STR_KEIJ_YM -- 対象期間開始年月 " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', LACS_COMMON.GET_TERM_DATE(SUBSTR('" + this.dateFrom + "', 1, 6) || '01', " + this.term + ")) END_KEIJ_YM -- 対象期間終了年月 " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', KEI.MRYO_YMD) MRYO_KEIJ_YM -- 満了計上年月 " + "\n");
		super.sql.append("                FROM   T_KEI KEI " + "\n");
		super.sql.append("                      ,T_BKN BKN " + "\n");
		super.sql.append("                WHERE  KEI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("                AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("                AND    KEI.LC_CD = 'LACS' " + "\n");
		super.sql.append("                AND    KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
		super.sql.append("                AND    KEI.ERR_FLG      = '0') BSE " + "\n");
		super.sql.append("              ,(SELECT HEAD.LC_CD -- リース会社コード " + "\n");
		super.sql.append("                      ,HEAD.KEI_NO -- 契約番号 " + "\n");
		super.sql.append("                      ,HEAD.BKN_NO -- 物件番号 " + "\n");
		super.sql.append("                      ,HEAD.BKN_EDANO -- 物件番号枝番 " + "\n");
		super.sql.append("                      ,MIN(HEAD.KEIJ_YM) MIN_KEIJ_YM -- 最小計上年月 " + "\n");
		super.sql.append("                      ,MAX(HEAD.KEIJ_YM) MAX_KEIJ_YM -- 最大計上年月 " + "\n");
		super.sql.append("                FROM   T_KEI           KEI " + "\n");
		super.sql.append("                      ,T_BKN           BKN " + "\n");
		super.sql.append("                      ,T_UKB_TNKI_HEAD HEAD " + "\n");
		super.sql.append("                WHERE  KEI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("                AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("                AND    HEAD.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("                AND    HEAD.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("                AND    HEAD.BKN_NO = BKN.BKN_NO " + "\n");
		super.sql.append("                AND    HEAD.BKN_EDANO = BKN.BKN_EDANO " + "\n");
		super.sql.append("                AND    KEI.LC_CD = 'LACS' " + "\n");
		super.sql.append("                AND    KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
		super.sql.append("                AND    KEI.ERR_FLG      = '0' " + "\n");
		super.sql.append("                AND    HEAD.KAI_REC_FLG = '0' " + "\n");
		super.sql.append("                GROUP  BY HEAD.LC_CD " + "\n");
		super.sql.append("                         ,HEAD.KEI_NO " + "\n");
		super.sql.append("                         ,HEAD.BKN_NO " + "\n");
		super.sql.append("                         ,HEAD.BKN_EDANO) WHEAD " + "\n");
		super.sql.append("              ,T_UKB_TNKI_HEAD   UKB_HEAD " + "\n");
		super.sql.append("              ,T_UKB_TNKI_DETAIL UKB_DTL " + "\n");
		super.sql.append("        WHERE  UKB_HEAD.LC_CD = BSE.LC_CD " + "\n");
		super.sql.append("        AND    UKB_HEAD.KEI_NO = BSE.KEI_NO " + "\n");
		super.sql.append("        AND    UKB_HEAD.BKN_NO = BSE.BKN_NO " + "\n");
		super.sql.append("        AND    UKB_HEAD.BKN_EDANO = BSE.BKN_EDANO " + "\n");
		super.sql.append("        AND    GREATEST(MRYO_KEIJ_YM, WHEAD.MAX_KEIJ_YM) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM " + "\n");
		super.sql.append("        AND    UKB_HEAD.LC_CD = UKB_DTL.LC_CD " + "\n");
		super.sql.append("        AND    UKB_HEAD.KEI_NO = UKB_DTL.KEI_NO " + "\n");
		super.sql.append("        AND    UKB_HEAD.BKN_NO = UKB_DTL.BKN_NO " + "\n");
		super.sql.append("        AND    UKB_HEAD.BKN_EDANO = UKB_DTL.BKN_EDANO " + "\n");
		super.sql.append("        AND    UKB_HEAD.KEIJ_YM = UKB_DTL.KEIJ_YM " + "\n");
		super.sql.append("        AND    BSE.RSK_KEIJ_HOHO_KBN = UKB_DTL.KEIJ_HOHO_KBN " + "\n");
		super.sql.append("        AND    BSE.LC_CD = WHEAD.LC_CD " + "\n");
		super.sql.append("        AND    BSE.KEI_NO = WHEAD.KEI_NO " + "\n");
		super.sql.append("        AND    BSE.BKN_NO = WHEAD.BKN_NO " + "\n");
		super.sql.append("        AND    BSE.BKN_EDANO = WHEAD.BKN_EDANO " + "\n");
		super.sql.append("        AND    WHEAD.MAX_KEIJ_YM = UKB_HEAD.KEIJ_YM " + "\n");
		super.sql.append("        AND    BSE.KAI_YMD IS NULL " + "\n");
		super.sql.append("       ) UKB " + "\n");
		super.sql.append("      ,T_KEI KEI " + "\n");
		super.sql.append("      ,T_BKN BKN " + "\n");
		super.sql.append(" WHERE KEI.LC_CD              = BKN.LC_CD " + "\n");
		super.sql.append("   AND KEI.KEI_NO             = BKN.KEI_NO " + "\n");
		super.sql.append("   AND BKN.LC_CD              = UKB.LC_CD " + "\n");
		super.sql.append("   AND BKN.KEI_NO             = UKB.KEI_NO " + "\n");
		super.sql.append("   AND BKN.BKN_NO             = UKB.BKN_NO " + "\n");
		super.sql.append("   AND BKN.BKN_EDANO          = UKB.BKN_EDANO " + "\n");		
		// 20210609 arai 再リース契約除外対応 start
		super.sql.append("   AND KEI.RLS_TMS            = 0 " + "\n");
		// 20210609 arai 再リース契約除外対応 end		
		super.sql.append(" GROUP BY KEI.LC_CD " + "\n");
		// 2020/05/22 ADD START
		super.sql.append("      ,CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN 'あり' ELSE 'なし' END" + "\n");
		super.sql.append("         ,CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END" + "\n");
		// 2020/05/22 ADD END
		super.sql.append("         ,KEI.TAISHO_AC_KIJYUN_CD " + "\n");
		super.sql.append("         ,KEI.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("         ,KEI.KEI_NO " + "\n");
		super.sql.append("         ,KEI.HYJYO_KEI_NO " + "\n");
		super.sql.append("         ,CTSHK_FLG " + "\n");
		super.sql.append("         ,BKN.BKN_NO " + "\n");
		super.sql.append("         ,BKN.BKN_EDANO " + "\n");
		super.sql.append("         ,BKN.BKN_NM " + "\n");
		super.sql.append(" ORDER BY KEI.LC_CD " + "\n");
		// 2020/05/22 ADD START
		super.sql.append("         ,CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END" + "\n");
		// 2020/05/22 ADD END
		super.sql.append("         ,KEI.TAISHO_AC_KIJYUN_CD " + "\n");
		super.sql.append("         ,KEI.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("         ,KEI.HYJYO_KEI_NO " + "\n");
		super.sql.append("         ,CTSHK_FLG " + "\n");
		super.sql.append("         ,BKN.BKN_NO " + "\n");
		super.sql.append("         ,BKN.BKN_EDANO " + "\n");
		// 2020/05/22 ADD TEST START
		//System.out.println("SQL LACSUkebaraiLeaseCtskSTaxEntity.java start");
		//System.out.println(super.sql);
		//System.out.println("SQL LACSUkebaraiLeaseCtskSTaxEntity.java out end");
		// 2020/05/22 ADD TEST END

	}

	/**
	 * ブレイクキー０を取得.
	 * 
	 * @return ブレイクキー０
	 */
	public String getBrakeKey0() {
		return super.getString("BRAKE_KEY0");
	}

	/**
	 * ブレイクキー１を取得.
	 * 
	 * @return ブレイクキー１
	 */
	public String getBrakeKey1() {
		return super.getString("BRAKE_KEY1");
	}

	/**
	 * ブレイクキー２を取得.
	 * 
	 * @return ブレイクキー２
	 */
	public String getBrakeKey2() {
		return super.getString("BRAKE_KEY2");
	}

	/**
	 * ブレイクキー３を取得.
	 * 
	 * @return ブレイクキー３
	 */
	public String getBrakeKey3() {
		return super.getString("BRAKE_KEY3");
	}

	/**
	 * ブレイクキー４を取得.
	 * 
	 * @return ブレイクキー４
	 */
	public String getBrakeKey4() {
		return super.getString("BRAKE_KEY4");
	}

	/**
	 * ブレイクキー５を取得.
	 * 
	 * @return ブレイクキー５
	 */
	public String getBrakeKey5() {
		return super.getString("BRAKE_KEY5");
	}

	/**
	 * 作成日を取得.
	 * 
	 * @return 作成日
	 */
	public String getCreateDate() {
		return super.getString("CREATE_DATE");
	}

	/**
	 * 対象期間開始を取得.
	 * 
	 * @return 対象期間開始
	 */
	public String getKikanStart() {
		return super.getString("KIKAN_START");
	}

	/**
	 * 対象期間終了を取得.
	 * 
	 * @return 対象期間終了
	 */
	public String getKikanEnd() {
		return super.getString("KIKAN_END");
	}

	/**
	 * リース会社名称を取得.
	 * 
	 * @return リース会社名称
	 */
	public String getLcNm() {
		return super.getString("LC_NM");
	}

	/**
	 * 開示先を取得.
	 * 
	 * @return 開示先
	 */
	public String getLuNm() {
		return super.getString("LU_NM");
	}

	/**
	 * 対象会計基準コードを取得.
	 * 
	 * @return 対象会計基準コード
	 */
	public String getTaishoAcKijyunCd() {
		return super.getString("TAISHO_AC_KIJYUN_CD");
	}

	/**
	 * リース会計基準を取得.
	 * 
	 * @return リース会計基準
	 */
	public String getTaishoAcKijyunNm() {
		return super.getString("TAISHO_AC_KIJYUN_NM");
	}

	/**
	 * 賃貸借フラグを取得.
	 * 
	 * @return 賃貸借フラグ
	 */
	public String getAcShrCd() {
		return super.getString("CTSHK_FLG");
	}

	/**
	 * 会計処理方法を取得.
	 * 
	 * @return 会計処理方法
	 */
	public String getAcShrNm() {
		return super.getString("AC_SHR_NM");
	}

	/**
	 * 取引判定結果を取得.
	 * 
	 * @return 取引判定結果
	 */
	public String getTrdHnteiKekaCd() {
		return super.getString("TRD_HNTE_KEKA_KBN");
	}

	/**
	 * リース取引分類を取得.
	 * 
	 * @return リース取引分類
	 */
	public String getTrdHnteiKekaNm() {
		return super.getString("TRD_HNTE_KEKA_NM");
	}

	/**
	 * 未払金(消費税)総額を取得.
	 * 
	 * @return 未払金(消費税)総額
	 */
	public long getMibaraiSougaku() {
		return super.getLong("KARIBARAI_SOUGAKU");
	}

	/**
	 * 未払金(消費税)前期末を取得.
	 * 
	 * @return 未払金(消費税)前期末
	 */
	public long getMibaraiZenkimatuAmt() {
		return super.getLong("KARIBARAI_ZENKIMATU_AMT");
	}

	/**
	 * 未払金(消費税)当期増加を取得.
	 * 
	 * @return 未払金(消費税)当期増加
	 */
	public long getMibaraiToukiZoukaAmt() {
		return super.getLong("KARIBARAI_TOUKI_ZOUKA_AMT");
	}

	/**
	 * 未払金(消費税)当期実現を取得.
	 * 
	 * @return 未払金(消費税)当期実現
	 */
	public long getMibaraiToukiJitugenAmt() {
		return super.getLong("KARIBARAI_TOUKI_JITUGEN_AMT");
	}

	/**
	 * 未払金(消費税)当期減少を取得.
	 * 
	 * @return 未払金(消費税)当期減少
	 */
	public long getMibaraiToukiGensyoAmt() {
		return super.getLong("KARIBARAI_TOUKI_GENSYO_AMT");
	}

	/**
	 * 未払金(消費税)当期末を取得.
	 * 
	 * @return 未払金(消費税)当期末
	 */
	public long getMibaraiToukimatuAmt() {
		return super.getLong("KARIBARAI_TOUKIMATU_AMT");
	}
	// 2020/05/22 ADD START
	/**
	 * 重要性有無を取得.
	 * 
	 * @return 重要性有無
	 */
	public String getJysiUm() {
		return super.getString("JYSI_UM");
	}
	// 2020/05/22 ADD END
}
