package jp.co.pro_app.lacs.affairs.ukebarai.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リース資産受払明細表Entity.
 * 
 * @author active
 * @version 20080811
 */
public class LACSUkebaraiSisanEntity extends EntityBase {

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
	public LACSUkebaraiSisanEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSUkebaraiBean piUkebaraiBean) {
		super(piModel);

		this.cosmosCode = piUkebaraiBean.getLeasCompany().getValue();

		this.dateFrom = piUkebaraiBean.getTermFrom().getYYYYMMDD();

		this.term = piUkebaraiBean.getTsukiSu();
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append("SELECT KEI.LC_CD                                                                                            BRAKE_KEY1                      -- ブレイクキー１ " + "\n");
		// 2020/05/22 REP START
		// super.sql.append("      ,KEI.LC_CD || KEI.TAISHO_AC_KIJYUN_CD                                                                 BRAKE_KEY2                      -- ブレイクキー２ " + "\n");
		// super.sql.append("      ,KEI.LC_CD || KEI.TAISHO_AC_KIJYUN_CD || KEI.TRD_HNTE_KEKA_KBN                                        BRAKE_KEY3                      -- ブレイクキー３ " + "\n");
		// super.sql.append("      ,KEI.LC_CD || KEI.TAISHO_AC_KIJYUN_CD || KEI.TRD_HNTE_KEKA_KBN || KEI.CTSHK_FLG                       BRAKE_KEY4                      -- ブレイクキー４ " + "\n");
		// super.sql.append("      ,KEI.LC_CD || KEI.TAISHO_AC_KIJYUN_CD || KEI.TRD_HNTE_KEKA_KBN || KEI.CTSHK_FLG || SSN.YUKEI_MUKEI_KBN    BRAKE_KEY5                      -- ブレイクキー５ " + "\n");

		super.sql.append("      ,KEI.LC_CD || CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END                                                                                                                  BRAKE_KEY1_0 -- ブレイクキー1_0 " + "\n");
		super.sql.append("      ,KEI.LC_CD || CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END || KEI.TAISHO_AC_KIJYUN_CD                                                                                       BRAKE_KEY2  -- ブレイクキー２ " + "\n");
		super.sql.append("      ,KEI.LC_CD || CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END || KEI.TAISHO_AC_KIJYUN_CD || KEI.TRD_HNTE_KEKA_KBN                                                              BRAKE_KEY3  -- ブレイクキー３ " + "\n");
		super.sql.append("      ,KEI.LC_CD || CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END || KEI.TAISHO_AC_KIJYUN_CD || KEI.TRD_HNTE_KEKA_KBN || KEI.CTSHK_FLG                                             BRAKE_KEY4  -- ブレイクキー４ " + "\n");
		super.sql.append("      ,KEI.LC_CD || CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END || KEI.TAISHO_AC_KIJYUN_CD || KEI.TRD_HNTE_KEKA_KBN || KEI.CTSHK_FLG || SSN.YUKEI_MUKEI_KBN                      BRAKE_KEY5  -- ブレイクキー５ " + "\n");
		super.sql.append("      ,KEI.LC_CD || CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END || KEI.TAISHO_AC_KIJYUN_CD || KEI.TRD_HNTE_KEKA_KBN || KEI.CTSHK_FLG || SSN.YUKEI_MUKEI_KBN || BKN.SSN_SRI_CD    BRAKE_KEY6  -- ブレイクキー５ " + "\n");
		// 2020/05/22 REP END
		super.sql.append("      ,TO_CHAR(SYSDATE, 'YYYYMMDD')                                                                         CREATE_DATE                     -- 作成日 " + "\n");
		super.sql.append("      ,'" + dateFrom + "'                                                                                           KIKAN_START                     -- 対象期間開始 " + "\n");
		super.sql.append("      ,TO_CHAR(ADD_MONTHS(TO_DATE('" + dateFrom + "', 'YYYYMMDD') -1, " + term + "), 'YYYYMMDD')                               KIKAN_END                       -- 対象期間終了 " + "\n");
		super.sql.append("      ,DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_NM, LU.PDF_COMPANY_NM) LC_NM                                                                                                                             -- リース会社 " + "\n");
		super.sql.append("      ,LU.LU_NM                                                                                                                             -- 開示先 " + "\n");
		super.sql.append("      ,DECODE(KEI.TAISHO_AC_KIJYUN_CD, '0', '旧リース会計基準', '新リース会計基準')                         TAISHO_AC_KIJYUN_NM             -- リース会計基準 " + "\n");
		super.sql.append("      ,KEI.TAISHO_AC_KIJYUN_CD                                                                              TAISHO_AC_KIJYUN_CD             -- リース会計基準 " + "\n");

		super.sql.append("      ,DECODE(KEI.CTSHK_FLG, '0', '売買処理', '賃貸借処理')                                                 AC_SHR_NM                       -- 会計処理方法 " + "\n");
		super.sql.append("      ,KEI.CTSHK_FLG　　　　　　　　　　　　　　　　　　　　                                                AC_SHR_CD                       -- 会計処理方法コード " + "\n");

		super.sql.append("      ,DECODE(SSN.YUKEI_MUKEI_KBN, '1', '有形資産', '無形資産')                                             SSN_KBN                         -- 資産区分 " + "\n");
		super.sql.append("      ,SSN.YUKEI_MUKEI_KBN　　　　　　　　　　　　　　　　　　　                                            SSN_KBN_CD                      -- 資産区分コード " + "\n");

		super.sql.append("      ,TRD.TRD_HNTE_KEKA_NM                                                                                 TRD_HNTE_KEKA_NM                -- リース取引分類 " + "\n");
		super.sql.append("      ,KEI.TRD_HNTE_KEKA_KBN                                                                                TRD_HNTE_KEKA_CD               -- リース取引分類コード " + "\n");

		super.sql.append("      ,KEI.HYJYO_KEI_NO                                                                                     KEI_NO                          -- 契約番号(表示用契約番号) " + "\n");
		super.sql.append("      ,CASE WHEN RTRIM(BKN.BKN_EDANO) IS NOT NULL THEN " + "\n");
		super.sql.append("            BKN.BKN_NO || '-' || BKN.BKN_EDANO " + "\n");
		super.sql.append("       ELSE BKN.BKN_NO " + "\n");
		super.sql.append("       END                                                                                                  BKN_NO                          -- 物件番号 " + "\n");
		super.sql.append("      ,BKN.BKN_NM                                                                                                                           -- 物件名称 " + "\n");
		super.sql.append("      ,KEI.KNSHU_YMD                                                                                                                        -- リース開始日 " + "\n");
		super.sql.append("      ,KEI.MRYO_YMD                                                                                                                         -- リース終了日 " + "\n");
		super.sql.append("      ,KEI.KAI_YMD                                                                                                                          -- 中途解約日 " + "\n");
		super.sql.append("      ,SUM(UKB.ZENKI_MATU_ZAN_AMT)                                                                          ZENKI_MATU_ZAN_AMT              -- 前期末残高 " + "\n");
		super.sql.append("      ,SUM(UKB.ZENKI_MATU_SYOKYAKU_AMT)                                                                     ZENKI_MATU_SYOKYAKU_AMT         -- 前期末償却累計 " + "\n");
		super.sql.append("      ,SUM(UKB.ZENKI_MATU_BOKA_AMT)                                                                         ZENKI_MATU_BOKA_AMT             -- 前期末簿価 " + "\n");
		super.sql.append("      ,SUM(UKB.TOUKI_ZOUKA_AMT)                                                                             TOUKI_ZOUKA_AMT                 -- 当期増加高 " + "\n");
		super.sql.append("      ,SUM(UKB.TOUKI_ZOUKA_BOKA_AMT)                                                                        TOUKI_ZOUKA_BOKA_AMT            -- 当期増加簿価 " + "\n");
		super.sql.append("      ,SUM(UKB.TOUKI_JITUGEN_AMT)                                                                           TOUKI_JITUGEN_AMT               -- 当期実現 " + "\n");
		super.sql.append("      ,SUM(UKB.TOUKI_GENSYO_AMT)                                                                            TOUKI_GENSYO_AMT                -- 当期減少高 " + "\n");
		super.sql.append("      ,SUM(UKB.TOUKI_GENSYO_BOKA_AMT)                                                                       TOUKI_GENSYO_BOKA_AMT           -- 当期減少簿価 " + "\n");
		super.sql.append("      ,SUM(UKB.TOUKI_MATU_ZAN_AMT)                                                                          TOUKI_MATU_ZAN_AMT              -- 当期末残高 " + "\n");
		super.sql.append("      ,SUM(UKB.TOUKI_MATU_SYOKYAKU_AMT)                                                                     TOUKI_MATU_SYOKYAKU_AMT         -- 当期末償却累計 " + "\n");
		super.sql.append("      ,SUM(UKB.TOUKI_MATU_BOKA_AMT)                                                                         TOUKI_MATU_BOKA_AMT             -- 当期末簿価 " + "\n");
		// 2020/05/22 ADD START
		super.sql.append("      ,CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN 'あり' ELSE 'なし' END                                        JYSI_UM                         -- 重要性有無 " + "\n");
		super.sql.append("      ,BKN.ZANK_HSHO_AMT                                                                                    ZANK_HSHO_AMT                   -- 残価保証額 " + "\n"); 
		super.sql.append("      ,SSN.SSN_SRI_NM                                                                                       SSN_SRI_NM                      -- 固定資産種類 " + "\n");
		super.sql.append("      ,BKN.SSN_SRI_CD                                                                                       SSN_SRI_CD                      -- 固定資産種類名称 " + "\n");
		// 2020/05/22 ADD END
		super.sql.append("  FROM ( " + "\n");
		super.sql.append("        SELECT GNK.LC_CD                                                                                                                    -- リース会社コード " + "\n");
		super.sql.append("              ,GNK.KEI_NO                                                                                                                   -- 契約番号 " + "\n");
		super.sql.append("              ,GNK.BKN_NO                                                                                                                   -- 物件番号 " + "\n");
		super.sql.append("              ,GNK.BKN_EDANO                                                                                                                -- 物件番号枝番 " + "\n");
		super.sql.append("              ,NVL(GNK.GNPN_TTL, 0)                             ZENKI_MATU_ZAN_AMT                                                          -- 前期末残高 " + "\n");
		super.sql.append("              ,CASE WHEN MAX_KEIJ_YM < STR_KEIJ_YM AND SUBSTR(BSE.MRYO_YMD, 1, 6) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                   NVL(GNK.GNPN_TTL, 0) " + "\n");
		super.sql.append("               ELSE " + "\n");
		super.sql.append("                   NVL(GNK.RUI_SKK_AMT, 0) " + "\n");
		super.sql.append("               END                                              ZENKI_MATU_SYOKYAKU_AMT                                                     -- 前期末償却累計 " + "\n");
		super.sql.append("              ,CASE WHEN MAX_KEIJ_YM < STR_KEIJ_YM AND SUBSTR(BSE.MRYO_YMD, 1, 6) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                   0 " + "\n");
		super.sql.append("               ELSE " + "\n");
		super.sql.append("                   NVL(GNK.GNPN_TTL - GNK.RUI_SKK_AMT, 0) " + "\n");
		super.sql.append("               END                                              ZENKI_MATU_BOKA_AMT                                                         -- 前期末簿価 " + "\n");
		super.sql.append("              ,0                                                TOUKI_ZOUKA_AMT                                                             -- 当期増加高 " + "\n");
		super.sql.append("              ,0                                                TOUKI_ZOUKA_BOKA_AMT                                                        -- 当期増加簿価 " + "\n");
		super.sql.append("              ,0                                                TOUKI_JITUGEN_AMT                                                           -- 当期実現 " + "\n");
		super.sql.append("              ,CASE WHEN MAX_KEIJ_YM < STR_KEIJ_YM AND MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
//		super.sql.append("              ,CASE WHEN MAX_KEIJ_YM < STR_KEIJ_YM AND SUBSTR(BSE.MRYO_YMD, 1, 6) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                   NVL(GNK.GNPN_TTL, 0) " + "\n");
		super.sql.append("               ELSE " + "\n");
		super.sql.append("                   0 " + "\n");
		super.sql.append("               END                                              TOUKI_GENSYO_AMT                                                            -- 当期減少高 " + "\n");
		super.sql.append("              ,0                                                TOUKI_GENSYO_BOKA_AMT                                                       -- 当期減少簿価 " + "\n");
		super.sql.append("              ,0                                                TOUKI_MATU_ZAN_AMT                                                          -- 当期末残高 " + "\n");
		super.sql.append("              ,0                                                TOUKI_MATU_SYOKYAKU_AMT                                                     -- 当期末償却累計 " + "\n");
		super.sql.append("              ,0                                                TOUKI_MATU_BOKA_AMT                                                         -- 当期末簿価 " + "\n");
		super.sql.append("          FROM T_UKB_GNKSK          GNK " + "\n");
		super.sql.append("              ,( " + "\n");
		super.sql.append("                SELECT KEI.LC_CD                                                                                                    -- リース会社コード " + "\n");
		super.sql.append("                      ,KEI.KEI_NO                                                                                                   -- 契約番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_NO                                                                                                   -- 物件番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_EDANO                                                                                                -- 物件番号枝番 " + "\n");
		super.sql.append("                      ,BKN.SKK_KEIJ_HOHO_KBN                                                                                        -- 採用償却計上方法区分 " + "\n");
		super.sql.append("                      ,KEI.KAI_YMD                                                                                                  -- 解約日" + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD , '" + dateFrom + "', '" + dateFrom + "') STR_KEIJ_YM                              -- 対象期間開始年月 " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD , '" + dateFrom + "', " + "\n");
		super.sql.append("                                                   LACS_COMMON.GET_TERM_DATE(SUBSTR('" + dateFrom + "', 1, 6) || '01', " + term + ")) END_KEIJ_YM      -- 対象期間終了年月 " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + dateFrom + "', KEI.MRYO_YMD)                        MRYO_KEIJ_YM     -- 満了計上年月 " + "\n");
		super.sql.append("                      ,KEI.MRYO_YMD                                                                                                 -- 満了日 " + "\n");
		super.sql.append("                  FROM T_KEI    KEI " + "\n");
		super.sql.append("                      ,T_BKN    BKN " + "\n");
		super.sql.append("                 WHERE KEI.LC_CD                 = BKN.LC_CD " + "\n");
		super.sql.append("                   AND KEI.KEI_NO                = BKN.KEI_NO " + "\n");
		super.sql.append("                      AND KEI.TRD_HNTE_KEKA_KBN IN ('1', '2') " + "\n");
		super.sql.append("                      AND KEI.LC_CD              = 'LACS' " + "\n");
		super.sql.append("                      AND KEI.LU_COSMOS_CD       = '" + cosmosCode + "' " + "\n");
		super.sql.append("                      AND KEI.ERR_FLG            = '0' " + "\n");
		super.sql.append("                  ) BSE " + "\n");
		super.sql.append("                 ,( " + "\n");
		super.sql.append("                   SELECT GNK.LC_CD                                                                                                    -- リース会社コード " + "\n");
		super.sql.append("                         ,GNK.KEI_NO                                                                                                   -- 契約番号 " + "\n");
		super.sql.append("                         ,GNK.BKN_NO                                                                                                   -- 物件番号 " + "\n");
		super.sql.append("                         ,GNK.BKN_EDANO                                                                                                -- 物件番号枝番 " + "\n");
		super.sql.append("                         ,GNK.KEIJ_HOHO_KBN                                                                                            -- 計上方法区分 " + "\n");
		super.sql.append("                         ,MIN(GNK.KEIJ_YM)   MIN_KEIJ_YM                                                                               -- 最小計上年月 " + "\n");
		super.sql.append("                         ,MAX(GNK.KEIJ_YM)   MAX_KEIJ_YM                                                                               -- 最大計上年月 " + "\n");
		super.sql.append("                     FROM T_KEI       KEI " + "\n");
		super.sql.append("                         ,T_BKN       BKN " + "\n");
		super.sql.append("                         ,T_UKB_GNKSK GNK " + "\n");
		super.sql.append("                    WHERE KEI.LC_CD              = BKN.LC_CD " + "\n");
		super.sql.append("                      AND KEI.KEI_NO             = BKN.KEI_NO " + "\n");
		super.sql.append("                      AND GNK.LC_CD              = BKN.LC_CD " + "\n");
		super.sql.append("                      AND GNK.KEI_NO             = BKN.KEI_NO " + "\n");
		super.sql.append("                      AND GNK.BKN_NO             = BKN.BKN_NO " + "\n");
		super.sql.append("                      AND GNK.BKN_EDANO          = BKN.BKN_EDANO " + "\n");
		super.sql.append("                      AND GNK.KEIJ_HOHO_KBN      = BKN.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                      AND GNK.KAI_REC_FLG        = '0' " + "\n");
		super.sql.append("                      AND KEI.TRD_HNTE_KEKA_KBN IN ('1', '2') " + "\n");
		super.sql.append("                      AND KEI.LC_CD              = 'LACS' " + "\n");
		super.sql.append("                      AND KEI.LU_COSMOS_CD       = '" + cosmosCode + "' " + "\n");
		super.sql.append("                      AND KEI.ERR_FLG            = '0' " + "\n");
		super.sql.append("                 GROUP BY GNK.LC_CD " + "\n");
		super.sql.append("                         ,GNK.KEI_NO " + "\n");
		super.sql.append("                         ,GNK.BKN_NO " + "\n");
		super.sql.append("                         ,GNK.BKN_EDANO " + "\n");
		super.sql.append("                         ,GNK.KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                  ) WGNK " + "\n");
		super.sql.append("         WHERE GNK.LC_CD                   = BSE.LC_CD " + "\n");
		super.sql.append("           AND GNK.KEI_NO                  = BSE.KEI_NO " + "\n");
		super.sql.append("           AND GNK.BKN_NO                  = BSE.BKN_NO " + "\n");
		super.sql.append("           AND GNK.BKN_EDANO               = BSE.BKN_EDANO " + "\n");
		super.sql.append("           AND GNK.KEIJ_YM                 = LEAST(LACS_COMMON.ADD_MONTHS_YM(BSE.STR_KEIJ_YM, -1), WGNK.MAX_KEIJ_YM)  " + "\n");
		super.sql.append("           AND GNK.KEIJ_HOHO_KBN           = BSE.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("           AND BSE.LC_CD                   = WGNK.LC_CD " + "\n");
		super.sql.append("           AND BSE.KEI_NO                  = WGNK.KEI_NO " + "\n");
		super.sql.append("           AND BSE.BKN_NO                  = WGNK.BKN_NO " + "\n");
		super.sql.append("           AND BSE.BKN_EDANO               = WGNK.BKN_EDANO " + "\n");
		super.sql.append("           AND BSE.STR_KEIJ_YM            <= CASE WHEN BSE.KAI_YMD IS NOT NULL THEN WGNK.MAX_KEIJ_YM " + "\n");
		super.sql.append("                                                  ELSE GREATEST(WGNK.MAX_KEIJ_YM, MRYO_KEIJ_YM) " + "\n");
		super.sql.append("                                             END " + "\n");
		super.sql.append("           AND BSE.END_KEIJ_YM            >= WGNK.MIN_KEIJ_YM " + "\n");
		super.sql.append("        UNION ALL " + "\n");
		super.sql.append("        SELECT GNK.LC_CD                                                                                                                    -- リース会社コード " + "\n");
		super.sql.append("              ,GNK.KEI_NO                                                                                                                   -- 契約番号 " + "\n");
		super.sql.append("              ,GNK.BKN_NO                                                                                                                   -- 物件番号 " + "\n");
		super.sql.append("              ,GNK.BKN_EDANO                                                                                                                -- 物件番号枝番 " + "\n");
		super.sql.append("              ,0                                                   ZENKI_MATU_ZAN_AMT                                                       -- 前期末残高 " + "\n");
		super.sql.append("              ,0                                                   ZENKI_MATU_SYOKYAKU_AMT                                                  -- 前期末償却累計 " + "\n");
		super.sql.append("              ,0                                                   ZENKI_MATU_BOKA_AMT                                                      -- 前期末簿価 " + "\n");
		super.sql.append("              ,CASE WHEN WGNK.MIN_KEIJ_YM = GNK.KEIJ_YM THEN " + "\n");
		super.sql.append("                         NVL(GNK.GNPN_TTL, 0) " + "\n");
		super.sql.append("                    ELSE 0 " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("               + NVL(GNK.ZOU_GNPN, 0)                              TOUKI_ZOUKA_AMT                                                          -- 当期増加高 " + "\n");
		super.sql.append("              ,CASE WHEN WGNK.MIN_KEIJ_YM = GNK.KEIJ_YM THEN " + "\n");
		super.sql.append("                         NVL(GNK.GNPN_TTL, 0) " + "\n");
		super.sql.append("                    ELSE 0 " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("               + NVL(GNK.ZOU_GNPN, 0)                              TOUKI_ZOUKA_BOKA_AMT                                                     -- 当期増加簿価 " + "\n");
//		当期実現に残価を含むパターン
//		super.sql.append("              ,NVL(GNK.TGTU_SKK_AMT, 0)                             " + "\n");
//		super.sql.append("               + CASE WHEN WGNK.MAX_KEIJ_YM = GNK.KEIJ_YM AND KAI_YMD IS NULL THEN " + "\n");
//		super.sql.append("                           NVL(GNK.USER_ZANK, 0) " + "\n");
//		super.sql.append("                      ELSE 0 " + "\n");
//		super.sql.append("                 END TOUKI_JITUGEN_AMT                                                                                                      -- 当期実現" + "\n");
		super.sql.append("              ,NVL(GNK.TGTU_SKK_AMT, 0)                            TOUKI_JITUGEN_AMT                                                        -- 当期実現 " + "\n");

		super.sql.append("              ,CASE WHEN WGNK.MAX_KEIJ_YM = GNK.KEIJ_YM AND BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         NVL(GNK.GNPN_TTL, 0) " + "\n");
		super.sql.append("                    WHEN WGNK.MAX_KEIJ_YM = GNK.KEIJ_YM AND WGNK.MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
//		super.sql.append("                    WHEN WGNK.MAX_KEIJ_YM = GNK.KEIJ_YM AND SUBSTR(BSE.MRYO_YMD, 1, 6) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                         NVL(GNK.GNPN_TTL, 0) " + "\n");
		super.sql.append("                    ELSE 0 " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("               + NVL(GNK.GEN_GNPN, 0)                              TOUKI_GENSYO_AMT                                                         -- 当期減少高 " + "\n");

//		当期実現に残価を含むパターン
//		super.sql.append("              ,CASE WHEN WGNK.MAX_KEIJ_YM = GNK.KEIJ_YM THEN " + "\n");
//		super.sql.append("                        CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
//		super.sql.append("                                  GNK.KAI_SISAN_BOKA " + "\n");
//		super.sql.append("                             ELSE " + "\n");
//		super.sql.append("                                  GNK.ZAND_SKK_AMT " + "\n");
//		super.sql.append("                        END  " + "\n");
//		super.sql.append("                    ELSE 0 " + "\n");
//		super.sql.append("                END " + "\n");
//		super.sql.append("                + NVL(GNK.GEN_GNPN, 0)                             TOUKI_GENSYO_BOKA_AMT                                                    -- 当期減少簿価 " + "\n");
		super.sql.append("              ,CASE WHEN WGNK.MAX_KEIJ_YM = GNK.KEIJ_YM THEN " + "\n");
		super.sql.append("                        CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                                  GNK.KAI_SISAN_BOKA " + "\n");
		super.sql.append("                             ELSE " + "\n");
		super.sql.append("                                  GNK.ZAND_SKK_AMT " + "\n");
		super.sql.append("                        END  " + "\n");
		super.sql.append("                    ELSE 0 " + "\n");
		super.sql.append("                END " + "\n");
		super.sql.append("                + NVL(GNK.GEN_GNPN, 0) " + "\n");
		super.sql.append("               + CASE WHEN WGNK.MAX_KEIJ_YM = GNK.KEIJ_YM AND KAI_YMD IS NULL THEN " + "\n");
		super.sql.append("                           NVL(GNK.USER_ZANK, 0) " + "\n");
		super.sql.append("                      ELSE 0 " + "\n");
		super.sql.append("                 END                                               TOUKI_GENSYO_BOKA_AMT                                                    -- 当期減少簿価 " + "\n");

		super.sql.append("              ,0                                                   TOUKI_MATU_ZAN_AMT                                                       -- 当期末残高 " + "\n");
		super.sql.append("              ,0                                                   TOUKI_MATU_SYOKYAKU_AMT                                                  -- 当期末償却累計 " + "\n");
		super.sql.append("              ,0                                                   TOUKI_MATU_BOKA_AMT                                                      -- 当期末簿価 " + "\n");
		super.sql.append("          FROM T_UKB_GNKSK          GNK " + "\n");
		super.sql.append("              ,( " + "\n");
		super.sql.append("                SELECT KEI.LC_CD                                                                                                    -- リース会社コード " + "\n");
		super.sql.append("                      ,KEI.KEI_NO                                                                                                   -- 契約番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_NO                                                                                                   -- 物件番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_EDANO                                                                                                -- 物件番号枝番 " + "\n");
		super.sql.append("                      ,BKN.SKK_KEIJ_HOHO_KBN                                                                                        -- 採用償却計上方法区分 " + "\n");
		super.sql.append("                      ,KEI.KAI_YMD                                                                                                  -- 解約日" + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD , '" + dateFrom + "', '" + dateFrom + "') STR_KEIJ_YM                              -- 対象期間開始年月 " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD , '" + dateFrom + "', " + "\n");
		super.sql.append("                                                   LACS_COMMON.GET_TERM_DATE(SUBSTR('" + dateFrom + "', 1, 6) || '01', " + term + ")) END_KEIJ_YM      -- 対象期間終了年月 " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + dateFrom + "', KEI.MRYO_YMD)                        MRYO_KEIJ_YM     -- 満了計上年月 " + "\n");
		super.sql.append("                      ,KEI.MRYO_YMD                                                                                                 -- 満了日 " + "\n");
		super.sql.append("                  FROM T_KEI    KEI " + "\n");
		super.sql.append("                      ,T_BKN    BKN " + "\n");
		super.sql.append("                 WHERE KEI.LC_CD                 = BKN.LC_CD " + "\n");
		super.sql.append("                   AND KEI.KEI_NO                = BKN.KEI_NO " + "\n");
		super.sql.append("                      AND KEI.TRD_HNTE_KEKA_KBN IN ('1', '2') " + "\n");
		super.sql.append("                      AND KEI.LC_CD              = 'LACS' " + "\n");
		super.sql.append("                      AND KEI.LU_COSMOS_CD       = '" + cosmosCode + "' " + "\n");
		super.sql.append("                      AND KEI.ERR_FLG            = '0' " + "\n");
		super.sql.append("                  ) BSE " + "\n");
		super.sql.append("                 ,( " + "\n");
		super.sql.append("                   SELECT GNK.LC_CD                                                                                                    -- リース会社コード " + "\n");
		super.sql.append("                         ,GNK.KEI_NO                                                                                                   -- 契約番号 " + "\n");
		super.sql.append("                         ,GNK.BKN_NO                                                                                                   -- 物件番号 " + "\n");
		super.sql.append("                         ,GNK.BKN_EDANO                                                                                                -- 物件番号枝番 " + "\n");
		super.sql.append("                         ,GNK.KEIJ_HOHO_KBN                                                                                            -- 計上方法区分 " + "\n");
		super.sql.append("                         ,MIN(GNK.KEIJ_YM)   MIN_KEIJ_YM                                                                               -- 最小計上年月 " + "\n");
		super.sql.append("                         ,MAX(GNK.KEIJ_YM)   MAX_KEIJ_YM                                                                               -- 最大計上年月 " + "\n");
		super.sql.append("                     FROM T_KEI       KEI " + "\n");
		super.sql.append("                         ,T_BKN       BKN " + "\n");
		super.sql.append("                         ,T_UKB_GNKSK GNK " + "\n");
		super.sql.append("                    WHERE KEI.LC_CD              = BKN.LC_CD " + "\n");
		super.sql.append("                      AND KEI.KEI_NO             = BKN.KEI_NO " + "\n");
		super.sql.append("                      AND GNK.LC_CD              = BKN.LC_CD " + "\n");
		super.sql.append("                      AND GNK.KEI_NO             = BKN.KEI_NO " + "\n");
		super.sql.append("                      AND GNK.BKN_NO             = BKN.BKN_NO " + "\n");
		super.sql.append("                      AND GNK.BKN_EDANO          = BKN.BKN_EDANO " + "\n");
		super.sql.append("                      AND GNK.KEIJ_HOHO_KBN      = BKN.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                      AND GNK.KAI_REC_FLG        = '0' " + "\n");
		super.sql.append("                      AND KEI.TRD_HNTE_KEKA_KBN IN ('1', '2') " + "\n");
		super.sql.append("                      AND KEI.LC_CD              = 'LACS' " + "\n");
		super.sql.append("                      AND KEI.LU_COSMOS_CD       = '" + cosmosCode + "' " + "\n");
		super.sql.append("                      AND KEI.ERR_FLG            = '0' " + "\n");
		super.sql.append("                 GROUP BY GNK.LC_CD " + "\n");
		super.sql.append("                         ,GNK.KEI_NO " + "\n");
		super.sql.append("                         ,GNK.BKN_NO " + "\n");
		super.sql.append("                         ,GNK.BKN_EDANO " + "\n");
		super.sql.append("                         ,GNK.KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                  ) WGNK " + "\n");
		super.sql.append("         WHERE GNK.LC_CD                   = BSE.LC_CD " + "\n");
		super.sql.append("           AND GNK.KEI_NO                  = BSE.KEI_NO " + "\n");
		super.sql.append("           AND GNK.BKN_NO                  = BSE.BKN_NO " + "\n");
		super.sql.append("           AND GNK.BKN_EDANO               = BSE.BKN_EDANO " + "\n");
		super.sql.append("           AND GNK.KEIJ_YM                 BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM " + "\n");
		super.sql.append("           AND GNK.KEIJ_HOHO_KBN           = BSE.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("           AND BSE.LC_CD                   = WGNK.LC_CD " + "\n");
		super.sql.append("           AND BSE.KEI_NO                  = WGNK.KEI_NO " + "\n");
		super.sql.append("           AND BSE.BKN_NO                  = WGNK.BKN_NO " + "\n");
		super.sql.append("           AND BSE.BKN_EDANO               = WGNK.BKN_EDANO " + "\n");
		super.sql.append("           AND BSE.STR_KEIJ_YM            <= CASE WHEN BSE.KAI_YMD IS NOT NULL THEN WGNK.MAX_KEIJ_YM " + "\n");
		super.sql.append("                                                  ELSE GREATEST(WGNK.MAX_KEIJ_YM, MRYO_KEIJ_YM) " + "\n");
		super.sql.append("                                             END " + "\n");
		super.sql.append("           AND BSE.END_KEIJ_YM            >= WGNK.MIN_KEIJ_YM " + "\n");
		super.sql.append("        UNION ALL " + "\n");
		super.sql.append("        SELECT GNK.LC_CD                                                                                                                    -- リース会社コード " + "\n");
		super.sql.append("              ,GNK.KEI_NO                                                                                                                   -- 契約番号 " + "\n");
		super.sql.append("              ,GNK.BKN_NO                                                                                                                   -- 物件番号 " + "\n");
		super.sql.append("              ,GNK.BKN_EDANO                                                                                                                -- 物件番号枝番 " + "\n");
		super.sql.append("              ,0                                                        ZENKI_MATU_ZAN_AMT                                                  -- 前期末残高 " + "\n");
		super.sql.append("              ,0                                                        ZENKI_MATU_SYOKYAKU_AMT                                             -- 前期末償却累計 " + "\n");
		super.sql.append("              ,0                                                        ZENKI_MATU_BOKA_AMT                                                 -- 前期末簿価 " + "\n");
		super.sql.append("              ,0                                                        TOUKI_ZOUKA_AMT                                                     -- 当期増加高 " + "\n");
		super.sql.append("              ,0                                                        TOUKI_ZOUKA_BOKA_AMT                                                -- 当期増加簿価 " + "\n");
		super.sql.append("              ,0                                                        TOUKI_JITUGEN_AMT                                                   -- 当期実現 " + "\n");
		super.sql.append("              ,0                                                        TOUKI_GENSYO_AMT                                                    -- 当期減少高 " + "\n");
		super.sql.append("              ,0                                                        TOUKI_GENSYO_BOKA_AMT                                               -- 当期減少簿価 " + "\n");
		super.sql.append("              ,CASE WHEN WGNK.MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM AND BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         0 " + "\n");
		super.sql.append("                    WHEN WGNK.MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM AND BSE.KAI_YMD IS NULL THEN " + "\n");
//		super.sql.append("                    WHEN SUBSTR(BSE.MRYO_YMD, 1,6) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM AND BSE.KAI_YMD IS NULL THEN " + "\n");
		super.sql.append("                         0 " + "\n");
		super.sql.append("                    ELSE NVL(GNK.GNPN_TTL, 0) " + "\n");
		super.sql.append("               END                                                      TOUKI_MATU_ZAN_AMT                                                  -- 当期末残高" + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                        CASE WHEN WGNK.MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                  0 " + "\n");
		super.sql.append("                             ELSE NVL(GNK.RUI_SKK_AMT, 0) " + "\n");
		super.sql.append("                        END " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                        CASE WHEN WGNK.MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
//		super.sql.append("                        CASE WHEN SUBSTR(BSE.MRYO_YMD, 1,6) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM AND BSE.MRYO_KEIJ_YM <= BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                  0 " + "\n");
		super.sql.append("                             ELSE NVL(GNK.RUI_SKK_AMT, 0) " + "\n");
		super.sql.append("                                  + CASE WHEN WGNK.MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                               NVL(GNK.USER_ZANK, 0) " + "\n");
		super.sql.append("                                         ELSE 0 " + "\n");
		super.sql.append("                                    END " + "\n");
		super.sql.append("                        END " + "\n");
		super.sql.append("               END                                                      TOUKI_MATU_SYOKYAKU_AMT                                             -- 当期末償却累計 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                        CASE WHEN WGNK.MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                  0 " + "\n");
		super.sql.append("                             ELSE NVL(GNK.GNPN_TTL, 0) - NVL(GNK.RUI_SKK_AMT, 0) " + "\n");
		super.sql.append("                        END " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                        CASE WHEN WGNK.MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                  NVL(GNK.ZAND_SKK_AMT, 0) " + "\n");
		super.sql.append("                             ELSE NVL(GNK.GNPN_TTL, 0) - NVL(GNK.RUI_SKK_AMT, 0) " + "\n");
		super.sql.append("                                  - CASE WHEN SUBSTR(BSE.MRYO_YMD, 1,6) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM AND BSE.MRYO_KEIJ_YM < BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                               NVL(GNK.USER_ZANK, 0) " + "\n");
		super.sql.append("                                         ELSE 0 " + "\n");
		super.sql.append("                                    END " + "\n");
		super.sql.append("                        END " + "\n");
		super.sql.append("               END                                                      TOUKI_MATU_BOKA_AMT                                                 -- 当期末簿価 " + "\n");

		super.sql.append("          FROM T_UKB_GNKSK          GNK " + "\n");
		super.sql.append("              ,( " + "\n");
		super.sql.append("                SELECT KEI.LC_CD                                                                                                    -- リース会社コード " + "\n");
		super.sql.append("                      ,KEI.KEI_NO                                                                                                   -- 契約番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_NO                                                                                                   -- 物件番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_EDANO                                                                                                -- 物件番号枝番 " + "\n");
		super.sql.append("                      ,BKN.SKK_KEIJ_HOHO_KBN                                                                                        -- 採用償却計上方法区分 " + "\n");
		super.sql.append("                      ,KEI.KAI_YMD                                                                                                  -- 解約日" + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD , '" + dateFrom + "', '" + dateFrom + "') STR_KEIJ_YM                              -- 対象期間開始年月 " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD , '" + dateFrom + "', " + "\n");
		super.sql.append("                                                   LACS_COMMON.GET_TERM_DATE(SUBSTR('" + dateFrom + "', 1, 6) || '01', " + term + ")) END_KEIJ_YM      -- 対象期間終了年月 " + "\n");
		super.sql.append("                      ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + dateFrom + "', KEI.MRYO_YMD)                        MRYO_KEIJ_YM     -- 満了計上年月 " + "\n");
		super.sql.append("                      ,KEI.MRYO_YMD                                                                                                 -- 満了日 " + "\n");
		super.sql.append("                  FROM T_KEI    KEI " + "\n");
		super.sql.append("                      ,T_BKN    BKN " + "\n");
		super.sql.append("                 WHERE KEI.LC_CD                 = BKN.LC_CD " + "\n");
		super.sql.append("                   AND KEI.KEI_NO                = BKN.KEI_NO " + "\n");
		super.sql.append("                      AND KEI.TRD_HNTE_KEKA_KBN IN ('1', '2') " + "\n");
		super.sql.append("                      AND KEI.LC_CD              = 'LACS' " + "\n");
		super.sql.append("                      AND KEI.LU_COSMOS_CD       = '" + cosmosCode + "' " + "\n");
		super.sql.append("                      AND KEI.ERR_FLG            = '0' " + "\n");
		super.sql.append("                  ) BSE " + "\n");
		super.sql.append("                 ,( " + "\n");
		super.sql.append("                   SELECT GNK.LC_CD                                                                                                    -- リース会社コード " + "\n");
		super.sql.append("                         ,GNK.KEI_NO                                                                                                   -- 契約番号 " + "\n");
		super.sql.append("                         ,GNK.BKN_NO                                                                                                   -- 物件番号 " + "\n");
		super.sql.append("                         ,GNK.BKN_EDANO                                                                                                -- 物件番号枝番 " + "\n");
		super.sql.append("                         ,GNK.KEIJ_HOHO_KBN                                                                                            -- 計上方法区分 " + "\n");
		super.sql.append("                         ,MIN(GNK.KEIJ_YM)   MIN_KEIJ_YM                                                                               -- 最小計上年月 " + "\n");
		super.sql.append("                         ,MAX(GNK.KEIJ_YM)   MAX_KEIJ_YM                                                                               -- 最大計上年月 " + "\n");
		super.sql.append("                     FROM T_KEI       KEI " + "\n");
		super.sql.append("                         ,T_BKN       BKN " + "\n");
		super.sql.append("                         ,T_UKB_GNKSK GNK " + "\n");
		super.sql.append("                    WHERE KEI.LC_CD              = BKN.LC_CD " + "\n");
		super.sql.append("                      AND KEI.KEI_NO             = BKN.KEI_NO " + "\n");
		super.sql.append("                      AND GNK.LC_CD              = BKN.LC_CD " + "\n");
		super.sql.append("                      AND GNK.KEI_NO             = BKN.KEI_NO " + "\n");
		super.sql.append("                      AND GNK.BKN_NO             = BKN.BKN_NO " + "\n");
		super.sql.append("                      AND GNK.BKN_EDANO          = BKN.BKN_EDANO " + "\n");
		super.sql.append("                      AND GNK.KEIJ_HOHO_KBN      = BKN.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                      AND GNK.KAI_REC_FLG        = '0' " + "\n");
		super.sql.append("                      AND KEI.TRD_HNTE_KEKA_KBN IN ('1', '2') " + "\n");
		super.sql.append("                      AND KEI.LC_CD              = 'LACS' " + "\n");
		super.sql.append("                      AND KEI.LU_COSMOS_CD       = '" + cosmosCode + "' " + "\n");
		super.sql.append("                      AND KEI.ERR_FLG            = '0' " + "\n");
		super.sql.append("                 GROUP BY GNK.LC_CD " + "\n");
		super.sql.append("                         ,GNK.KEI_NO " + "\n");
		super.sql.append("                         ,GNK.BKN_NO " + "\n");
		super.sql.append("                         ,GNK.BKN_EDANO " + "\n");
		super.sql.append("                         ,GNK.KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                  ) WGNK " + "\n");
		super.sql.append("         WHERE GNK.LC_CD                   = BSE.LC_CD " + "\n");
		super.sql.append("           AND GNK.KEI_NO                  = BSE.KEI_NO " + "\n");
		super.sql.append("           AND GNK.BKN_NO                  = BSE.BKN_NO " + "\n");
		super.sql.append("           AND GNK.BKN_EDANO               = BSE.BKN_EDANO " + "\n");
		super.sql.append("           AND GNK.KEIJ_YM                 = LEAST(BSE.END_KEIJ_YM, WGNK.MAX_KEIJ_YM)  " + "\n");
		super.sql.append("           AND GNK.KEIJ_HOHO_KBN           = BSE.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("           AND BSE.LC_CD                   = WGNK.LC_CD " + "\n");
		super.sql.append("           AND BSE.KEI_NO                  = WGNK.KEI_NO " + "\n");
		super.sql.append("           AND BSE.BKN_NO                  = WGNK.BKN_NO " + "\n");
		super.sql.append("           AND BSE.BKN_EDANO               = WGNK.BKN_EDANO " + "\n");
		super.sql.append("           AND BSE.STR_KEIJ_YM            <= CASE WHEN BSE.KAI_YMD IS NOT NULL THEN WGNK.MAX_KEIJ_YM " + "\n");
		super.sql.append("                                                  ELSE GREATEST(WGNK.MAX_KEIJ_YM, MRYO_KEIJ_YM) " + "\n");
		super.sql.append("                                             END " + "\n");
		super.sql.append("           AND BSE.END_KEIJ_YM            >= WGNK.MIN_KEIJ_YM " + "\n");
		super.sql.append("       ) UKB " + "\n");
		super.sql.append("      ,M_LC                     LC " + "\n");
		super.sql.append("      ,M_LU                     LU " + "\n");
		super.sql.append("      ,M_SSN_SRI                SSN " + "\n");
		super.sql.append("      ,M_TRD_HNTE_KEKA_KBN      TRD " + "\n");
		super.sql.append("      ,T_KEI                    KEI " + "\n");
		super.sql.append("      ,T_BKN                    BKN " + "\n");
		super.sql.append(" WHERE KEI.LC_CD              = LC.LC_CD " + "\n");
		super.sql.append("   AND KEI.LU_COSMOS_CD       = LU.LU_COSMOS_CD " + "\n");
		super.sql.append("   AND BKN.SSN_SRI_CD         = SSN.SSN_SRI_CD " + "\n");
		super.sql.append("   AND KEI.TRD_HNTE_KEKA_KBN  = TRD.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("   AND KEI.LC_CD              = BKN.LC_CD " + "\n");
		super.sql.append("   AND KEI.KEI_NO             = BKN.KEI_NO " + "\n");
		super.sql.append("   AND BKN.LC_CD              = UKB.LC_CD " + "\n");
		super.sql.append("   AND BKN.KEI_NO             = UKB.KEI_NO " + "\n");
		super.sql.append("   AND BKN.BKN_NO             = UKB.BKN_NO " + "\n");
		super.sql.append("   AND BKN.BKN_EDANO          = UKB.BKN_EDANO " + "\n");
		// 20210609 arai 再リース契約除外対応 start
		super.sql.append("   AND KEI.RLS_TMS            = 0 " + "\n");
		// 20210609 arai 再リース契約除外対応 end		
		super.sql.append(" GROUP BY KEI.LC_CD " + "\n");
		super.sql.append("         ,KEI.TAISHO_AC_KIJYUN_CD " + "\n");
		super.sql.append("         ,KEI.CTSHK_FLG " + "\n");
		super.sql.append("         ,KEI.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("         ,SSN.YUKEI_MUKEI_KBN " + "\n");
		super.sql.append("         ,DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_NM, LU.PDF_COMPANY_NM) " + "\n");
		super.sql.append("         ,LU.LU_NM " + "\n");
		super.sql.append("         ,TRD.TRD_HNTE_KEKA_NM " + "\n");
		super.sql.append("         ,KEI.KEI_NO " + "\n");
		super.sql.append("         ,KEI.HYJYO_KEI_NO " + "\n");
		super.sql.append("         ,BKN.BKN_NO " + "\n");
		super.sql.append("         ,BKN.BKN_EDANO " + "\n");
		super.sql.append("         ,BKN.BKN_NM " + "\n");
		super.sql.append("         ,KEI.KNSHU_YMD " + "\n");
		super.sql.append("         ,KEI.MRYO_YMD " + "\n");
		super.sql.append("         ,KEI.KAI_YMD " + "\n");
		// 2020/05/22 ADD START
		super.sql.append("         ,BKN.SSN_SRI_CD " + "\n");
		super.sql.append("         ,CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN 'あり' ELSE 'なし' END " + "\n");
		super.sql.append("         ,CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END " + "\n");
		super.sql.append("         ,BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("         ,SSN.SSN_SRI_NM " + "\n");
		// 2020/05/22 ADD END		
		super.sql.append(" ORDER BY KEI.LC_CD " + "\n");
		// 2020/05/22 ADD START
		super.sql.append("         ,CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END " + "\n");
		// 2020/05/22 ADD END		
		super.sql.append("         ,KEI.TAISHO_AC_KIJYUN_CD " + "\n");
		super.sql.append("         ,KEI.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("         ,KEI.CTSHK_FLG " + "\n");
		super.sql.append("         ,SSN.YUKEI_MUKEI_KBN " + "\n");
		// 2020/05/22 ADD START
		super.sql.append("         ,BKN.SSN_SRI_CD " + "\n");
		// 2020/05/22 ADD END		
		super.sql.append("         ,KEI_NO " + "\n");
		super.sql.append("         ,BKN.BKN_NO " + "\n");
		super.sql.append("         ,BKN.BKN_EDANO " + "\n");
		
		//System.out.println(sql);
		// 2020/05/22 ADD TEST START
		//System.out.println("SQL LACSUkebaraiSisanEntity.java start");
		System.out.println(super.sql);
		//System.out.println("SQL LACSUkebaraiSisanEntity.java end");
		// 2020/05/22 ADD TEST END
	}

	/**
	 * ブレイクキー１を取得.
	 * 
	 * @return ブレイクキー１
	 */
	public String getBrakeKey1() {
		return super.getString("BRAKE_KEY1");
	}

	// 2020/05/22 ADD START
	/**
	 * ブレイクキー１_0を取得.
	 * 
	 * @return ブレイクキー１_0
	 */
	public String getBrakeKey1_0() {
		return super.getString("BRAKE_KEY1_0");
	}

	/**
	 * ブレイクキー6を取得.
	 * 
	 * @return ブレイクキー6
	 */
	public String getBrakeKey6() {
		return super.getString("BRAKE_KEY6");
	}
// 2020/05/22 ADD END

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
	 * 資産区分を取得.
	 * 
	 * @return 資産区分
	 */
	public String getSisanKbn() {
		return super.getString("SSN_KBN");
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
	 * 会計処理方法を取得.
	 * 
	 * @return 会計処理方法
	 */
	public String getAcShrNm() {
		return super.getString("AC_SHR_NM");
	}

	/**
	 * 契約番号を取得.
	 * 
	 * @return 契約番号
	 */
	public String getKeiNo() {
		return super.getString("KEI_NO");
	}

	/**
	 * 物件番号を取得.
	 * 
	 * @return 物件番号
	 */
	public String getBknNo() {
		return super.getString("BKN_NO");
	}

	/**
	 * 物件名称を取得.
	 * 
	 * @return 物件名称
	 */
	public String getBknNm() {
		return super.getString("BKN_NM");
	}

	/**
	 * リース開始日を取得.
	 * 
	 * @return リース開始日
	 */
	public String getKnshuYmd() {
		return super.getString("KNSHU_YMD");
	}

	/**
	 * リース終了日を取得.
	 * 
	 * @return リース終了日
	 */
	public String getMryoYmd() {
		return super.getString("MRYO_YMD");
	}

	/**
	 * 中途解約日を取得.
	 * 
	 * @return 中途解約日
	 */
	public String getKaiYmd() {
		return super.getString("KAI_YMD");
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
	 * 前期末残高を取得.
	 * 
	 * @return 前期末残高
	 */
	public long getZenkimatuZanAmt() {
		return super.getLong("ZENKI_MATU_ZAN_AMT");
	}

	/**
	 * 当期増加を取得.
	 * 
	 * @return 当期増加
	 */
	public long getToukiZoukaAmt() {
		return super.getLong("TOUKI_ZOUKA_AMT");
	}

	/**
	 * 当期減少高を取得.
	 * 
	 * @return 当期減少高
	 */
	public long getToukiGensyoAmt() {
		return super.getLong("TOUKI_GENSYO_AMT");
	}

	/**
	 * 当期末残高を取得.
	 * 
	 * @return 当期末残高
	 */
	public long getToukimatuZanAmt() {
		return super.getLong("TOUKI_MATU_ZAN_AMT");
	}

	/**
	 * 前期末簿価を取得.
	 * 
	 * @return 前期末簿価
	 */
	public long getZenkimatuBokaAmt() {
		return super.getLong("ZENKI_MATU_BOKA_AMT");
	}

	/**
	 * 当期実現を取得.
	 * 
	 * @return 当期実現
	 */
	public long getToukiJitugenAmt() {
		return super.getLong("TOUKI_JITUGEN_AMT");
	}

	/**
	 * 当期減少簿価を取得.
	 * 
	 * @return 当期減少簿価
	 */
	public long getToukiGensyoBokaAmt() {
		return super.getLong("TOUKI_GENSYO_BOKA_AMT");
	}

	/**
	 * 当期末簿価を取得.
	 * 
	 * @return 当期末簿価
	 */
	public long getToukimatuBokaAmt() {
		return super.getLong("TOUKI_MATU_BOKA_AMT");
	}

	/**
	 * 前期末償却累計を取得.
	 * 
	 * @return 前期末償却累計
	 */
	public long getZenkimatuSyokyakuAmt() {
		return super.getLong("ZENKI_MATU_SYOKYAKU_AMT");
	}

	/**
	 * 当期末償却累計を取得.
	 * 
	 * @return 当期末償却累計
	 */
	public long getToukimatuSyokyakuAmt() {
		return super.getLong("TOUKI_MATU_SYOKYAKU_AMT");
	}

	/**
	 * 当期増加簿価を取得.
	 * 
	 * @return 当期増加簿価
	 */
	public long getToukiZoukaBokaAmt() {
		return super.getLong("TOUKI_ZOUKA_BOKA_AMT");
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
	 * リース取引分類コードを取得.
	 * 
	 * @return リース取引分類コード
	 */
	public String getTrdHnteiKekaCd() {
		return super.getString("TRD_HNTE_KEKA_CD");
	}

	/**
	 * 会計処理方法コードを取得.
	 * 
	 * @return 会計処理方法コード
	 */
	public String getAcShrCd() {
		return super.getString("AC_SHR_CD");
	}

	/**
	 * 資産区分コードを取得.
	 * 
	 * @return 資産区分コード
	 */
	public String getSisanKbnCd() {
		return super.getString("SSN_KBN_CD");
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
	
	/**
	 * 残価保証額を取得.
	 * 
	 * @return 残価保証額
	 */
	public long getZankHshoAmt() {
		return super.getLong("ZANK_HSHO_AMT");
	}
	
	/**
	 * 固定資産種類名を取得.
	 * 
	 * @return 固定資産種類名額
	 */
	public String getSsnSriNm() {
		return super.getString("SSN_SRI_NM");
	}
	// 2020/05/22 ADD END

}
