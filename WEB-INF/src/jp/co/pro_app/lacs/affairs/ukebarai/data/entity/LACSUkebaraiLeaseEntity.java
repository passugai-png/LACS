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
public class LACSUkebaraiLeaseEntity extends EntityBase {

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
	public LACSUkebaraiLeaseEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSUkebaraiBean piUkebaraiBean) {
		super(piModel);

		this.cosmosCode = piUkebaraiBean.getLeasCompany().getValue();

		this.dateFrom = piUkebaraiBean.getTermFrom().getYYYYMMDD();

		this.term = piUkebaraiBean.getTsukiSu();
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		// 2020/05/22 REP START
		//super.sql.append("SELECT DECODE(KEI.TRD_HNTE_KEKA_KBN,'3','1','0')                                                                                                          BRAKE_KEY0  -- ブレイクキー０ " + "\n");
		//super.sql.append("      ,DECODE(KEI.TRD_HNTE_KEKA_KBN,'3','1','0') || KEI.LC_CD                                                                                             BRAKE_KEY1  -- ブレイクキー１ " + "\n");
		//super.sql.append("      ,DECODE(KEI.TRD_HNTE_KEKA_KBN,'3','1','0') || KEI.LC_CD || KEI.TAISHO_AC_KIJYUN_CD                                                                  BRAKE_KEY2  -- ブレイクキー２ " + "\n");
		//super.sql.append("      ,DECODE(KEI.TRD_HNTE_KEKA_KBN,'3','1','0') || KEI.LC_CD || KEI.TAISHO_AC_KIJYUN_CD || KEI.TRD_HNTE_KEKA_KBN                                         BRAKE_KEY3  -- ブレイクキー３ " + "\n");
		//super.sql.append("      ,DECODE(KEI.TRD_HNTE_KEKA_KBN,'3','1','0') || KEI.LC_CD || KEI.TAISHO_AC_KIJYUN_CD || KEI.TRD_HNTE_KEKA_KBN || KEI.CTSHK_FLG                        BRAKE_KEY4  -- ブレイクキー４ " + "\n");
		//super.sql.append("      ,DECODE(KEI.TRD_HNTE_KEKA_KBN,'3','1','0') || KEI.LC_CD || KEI.TAISHO_AC_KIJYUN_CD || KEI.TRD_HNTE_KEKA_KBN || KEI.CTSHK_FLG || SSN.YUKEI_MUKEI_KBN BRAKE_KEY5  -- ブレイクキー５ " + "\n");

		super.sql.append("SELECT KEI.LC_CD                                                                                                                                                                                                        BRAKE_KEY0  -- ブレイクキー０ " + "\n");
		super.sql.append("      ,KEI.LC_CD                                                                                                                                                                                                        BRAKE_KEY1  -- ブレイクキー１ " + "\n");
		super.sql.append("      ,KEI.LC_CD || CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END || DECODE(KEI.TRD_HNTE_KEKA_KBN,'3','1','0')                                                                                             BRAKE_KEY1_0  -- ブレイクキー１_0 " + "\n");
		super.sql.append("      ,KEI.LC_CD || CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END || DECODE(KEI.TRD_HNTE_KEKA_KBN,'3','1','0') || KEI.TAISHO_AC_KIJYUN_CD                                                                  BRAKE_KEY2  -- ブレイクキー２ " + "\n");
		super.sql.append("      ,KEI.LC_CD || CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END || DECODE(KEI.TRD_HNTE_KEKA_KBN,'3','1','0') || KEI.TAISHO_AC_KIJYUN_CD || KEI.TRD_HNTE_KEKA_KBN                                         BRAKE_KEY3  -- ブレイクキー３ " + "\n");
		super.sql.append("      ,KEI.LC_CD || CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END || DECODE(KEI.TRD_HNTE_KEKA_KBN,'3','1','0') || KEI.TAISHO_AC_KIJYUN_CD || KEI.TRD_HNTE_KEKA_KBN || KEI.CTSHK_FLG                        BRAKE_KEY4  -- ブレイクキー４ " + "\n");
		super.sql.append("      ,KEI.LC_CD || CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END || DECODE(KEI.TRD_HNTE_KEKA_KBN,'3','1','0') || KEI.TAISHO_AC_KIJYUN_CD || KEI.TRD_HNTE_KEKA_KBN || KEI.CTSHK_FLG || SSN.YUKEI_MUKEI_KBN BRAKE_KEY5  -- ブレイクキー５ " + "\n");

		// //super.sql.append("      ,DECODE(KEI.TRD_HNTE_KEKA_KBN,'3','1','0') || KEI.LC_CD || CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END                                                                                               BRAKE_KEY1_0  -- ブレイクキー１_0 " + "\n");
		// //super.sql.append("      ,DECODE(KEI.TRD_HNTE_KEKA_KBN,'3','1','0') || KEI.LC_CD || CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END || KEI.TAISHO_AC_KIJYUN_CD                                                                  BRAKE_KEY2  -- ブレイクキー２ " + "\n");
		// //super.sql.append("      ,DECODE(KEI.TRD_HNTE_KEKA_KBN,'3','1','0') || KEI.LC_CD || CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END || KEI.TAISHO_AC_KIJYUN_CD || KEI.TRD_HNTE_KEKA_KBN                                         BRAKE_KEY3  -- ブレイクキー３ " + "\n");
		// //super.sql.append("      ,DECODE(KEI.TRD_HNTE_KEKA_KBN,'3','1','0') || KEI.LC_CD || CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END || KEI.TAISHO_AC_KIJYUN_CD || KEI.TRD_HNTE_KEKA_KBN || KEI.CTSHK_FLG                        BRAKE_KEY4  -- ブレイクキー４ " + "\n");
		// //super.sql.append("      ,DECODE(KEI.TRD_HNTE_KEKA_KBN,'3','1','0') || KEI.LC_CD || CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END || KEI.TAISHO_AC_KIJYUN_CD || KEI.TRD_HNTE_KEKA_KBN || KEI.CTSHK_FLG || SSN.YUKEI_MUKEI_KBN BRAKE_KEY5  -- ブレイクキー５ " + "\n");
		// 2020/05/22 REP END
		super.sql.append("      ,TO_CHAR(SYSDATE,'YYYYMMDD')                                                                              CREATE_DATE                 -- 作成日 " + "\n");
		super.sql.append("      ,'" + this.dateFrom + "'                                                                                  KIKAN_START                 -- 対象期間開始 " + "\n");
		super.sql.append("      ,TO_CHAR(ADD_MONTHS(TO_DATE('" + this.dateFrom + "', 'YYYYMMDD') -1, " + this.term + "), 'YYYYMMDD')      KIKAN_END                   -- 対象期間終了 " + "\n");
		super.sql.append("      ,DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_NM, LU.PDF_COMPANY_NM) LC_NM                                                                                                                             -- リース会社 " + "\n");
		super.sql.append("      ,LU.LU_NM                                                                                                                             -- 開示先 " + "\n");
		// 2020/05/22 ADD START
		super.sql.append("      ,CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN 'あり' ELSE 'なし' END                                            JYSI_UM                     -- 重要性有無" + "\n");
		// 2020/05/22 ADD END
		super.sql.append("      ,KEI.CTSHK_FLG                                                                                                                        -- 賃貸借フラグ " + "\n");
		super.sql.append("      ,DECODE(KEI.CTSHK_FLG, '0', '売買処理', '賃貸借処理')                                                     AC_SHR_NM                   -- 会計処理方法 " + "\n");
		super.sql.append("      ,KEI.TAISHO_AC_KIJYUN_CD                                                                                                              -- 対象会計基準コード " + "\n");
		super.sql.append("      ,DECODE(KEI.TAISHO_AC_KIJYUN_CD, '0', '旧リース会計基準', '新リース会計基準')                             TAISHO_AC_KIJYUN_NM         -- リース会計基準 " + "\n");
		super.sql.append("      ,KEI.TRD_HNTE_KEKA_KBN                                                                                                                -- 取引判定結果区分 " + "\n");
		super.sql.append("      ,TRD.TRD_HNTE_KEKA_NM                                                                                                                 -- リース取引分類 " + "\n");
		super.sql.append("      ,SSN.YUKEI_MUKEI_KBN                                                                                                                  -- 資産区分コード " + "\n");
		super.sql.append("      ,DECODE(SSN.YUKEI_MUKEI_KBN, '1', '有形資産', '無形資産')                                                 SSN_KBN                     -- 資産区分 " + "\n");
		super.sql.append("      ,KEI.HYJYO_KEI_NO                                                                                         KEI_NO                      -- 契約番号（表示用契約番号） " + "\n");
		super.sql.append("      ,CASE WHEN RTRIM(BKN.BKN_EDANO) IS NOT NULL THEN " + "\n");
		super.sql.append("                 BKN.BKN_NO || '-' || BKN.BKN_EDANO " + "\n");
		super.sql.append("            ELSE BKN.BKN_NO " + "\n");
		super.sql.append("       END                                                                                                      BKN_NO                      -- 物件番号 " + "\n");
		super.sql.append("      ,BKN.BKN_NM                                                                                                                           -- 物件名称 " + "\n");
		super.sql.append("      ,KEI.KNSHU_YMD                                                                                                                        -- リース開始日 " + "\n");
		super.sql.append("      ,KEI.MRYO_YMD                                                                                                                         -- リース終了日 " + "\n");
		super.sql.append("      ,KEI.KAI_YMD                                                                                                                          -- 中途解約日 " + "\n");
		super.sql.append("      ,SUM(LEAS_AMT_SOUGAKU)                                                                                    LEAS_AMT_SOUGAKU            -- リース料総額 " + "\n");
		super.sql.append("      ,SUM(UKB.ZANK_HSHO_AMT)                                                                                   ZANK_HSHO_AMT               -- 残価保証額 " + "\n");
		super.sql.append("      ,SUM(SAIMU_SOUGAKU)                                                                                       SAIMU_SOUGAKU               -- リース債務総額 " + "\n");
		super.sql.append("      ,SUM(SAIMU_ZENKIMATU_AMT)                                                                                 SAIMU_ZENKIMATU_AMT         -- リース債務前期末 " + "\n");
		super.sql.append("      ,SUM(SAIMU_TOUKI_ZOUKA_AMT)                                                                               SAIMU_TOUKI_ZOUKA_AMT       -- リース債務当期増加 " + "\n");
		super.sql.append("      ,SUM(SAIMU_TOUKI_JITUGEN_AMT)                                                                             SAIMU_TOUKI_JITUGEN_AMT     -- リース債務当期実現 " + "\n");
		super.sql.append("      ,SUM(SAIMU_TOUKI_GENSYO_AMT)                                                                              SAIMU_TOUKI_GENSYO_AMT      -- リース債務当期減少 " + "\n");
		super.sql.append("      ,SUM(SAIMU_TOUKIMATU_AMT)                                                                                 SAIMU_TOUKIMATU_AMT         -- リース債務当期末 " + "\n");
		// 2020/05/22 ADD START
		super.sql.append("      ,SUM(ZANK_SOUGAKU)                                                                                        ZANK_SOUGAKU                -- 残価保証額総額 " + "\n");
		super.sql.append("      ,SUM(ZANK_ZENKIMATU_AMT)                                                                                  ZANK_ZENKIMATU_AMT          -- 残価保証額前期末 " + "\n");
		super.sql.append("      ,SUM(ZANK_TOUKI_ZOUKA_AMT)                                                                                ZANK_TOUKI_ZOUKA_AMT        -- 残価保証額当期増加 " + "\n");
		super.sql.append("      ,SUM(ZANK_TOUKI_JITUGEN_AMT)                                                                              ZANK_TOUKI_JITUGEN_AMT      -- 残価保証額当期実現 " + "\n");
		super.sql.append("      ,SUM(ZANK_TOUKI_GENSYO_AMT)                                                                               ZANK_TOUKI_GENSYO_AMT       -- 残価保証額当期減少 " + "\n");
		super.sql.append("      ,SUM(ZANK_TOUKIMATU_AMT)                                                                                  ZANK_TOUKIMATU_AMT          -- 残価保証額当期末 " + "\n");
		// 2020/05/22 ADD END
		super.sql.append("      ,SUM(RSK_SOUGAKU)                                                                                         RSK_SOUGAKU                 -- 利息総額 " + "\n");
		super.sql.append("      ,SUM(RSK_ZENKIMATU_AMT)                                                                                   RSK_ZENKIMATU_AMT           -- 利息前期末 " + "\n");
		super.sql.append("      ,SUM(RSK_TOUKI_JITUGEN_AMT)                                                                               RSK_TOUKI_JITUGEN_AMT       -- 利息当期実現 " + "\n");
		super.sql.append("      ,SUM(RSK_TOUKI_GENSYO_AMT)                                                                                RSK_TOUKI_GENSYO_AMT        -- 利息当期減少 " + "\n");
		super.sql.append("      ,SUM(RSK_TOUKIMATU_AMT)                                                                                   RSK_TOUKIMATU_AMT           -- 利息当期末 " + "\n");
		super.sql.append("      ,SUM(IJI_SOUGAKU)                                                                                         IJI_SOUGAKU                 -- 維持管理費総額 " + "\n");
		super.sql.append("      ,SUM(IJI_ZENKIMATU_AMT)                                                                                   IJI_ZENKIMATU_AMT           -- 維持管理費前期末 " + "\n");
		super.sql.append("      ,SUM(IJI_TOUKI_JITUGEN_AMT)                                                                               IJI_TOUKI_JITUGEN_AMT       -- 維持管理費当期実現 " + "\n");
		super.sql.append("      ,SUM(IJI_TOUKI_GENSYO_AMT)                                                                                IJI_TOUKI_GENSYO_AMT        -- 維持管理費当期減少 " + "\n");
		super.sql.append("      ,SUM(IJI_TOUKIMATU_AMT)                                                                                   IJI_TOUKIMATU_AMT           -- 維持管理費当期末 " + "\n");
		super.sql.append("      ,SUM(EKM_SOUGAKU)                                                                                         EKM_SOUGAKU                 -- 役務提供費総額 " + "\n");
		super.sql.append("      ,SUM(EKM_ZENKIMATU_AMT)                                                                                   EKM_ZENKIMATU_AMT           -- 役務提供費前期末 " + "\n");
		super.sql.append("      ,SUM(EKM_TOUKI_JITUGEN_AMT)                                                                               EKM_TOUKI_JITUGEN_AMT       -- 役務提供費当期実現 " + "\n");
		super.sql.append("      ,SUM(EKM_TOUKI_GENSYO_AMT)                                                                                EKM_TOUKI_GENSYO_AMT        -- 役務提供費当期減少 " + "\n");
		super.sql.append("      ,SUM(EKM_TOUKIMATU_AMT)                                                                                   EKM_TOUKIMATU_AMT           -- 役務提供費当期末 " + "\n");
		super.sql.append("      ,SUM(LEAS_SOUGAKU)                                                                                        LEAS_SOUGAKU                -- リース料累計 総額 " + "\n");
		super.sql.append("      ,SUM(LEAS_ZENKIMATU_AMT)                                                                                  LEAS_ZENKIMATU_AMT          -- リース料累計 前期末 " + "\n");
		super.sql.append("      ,SUM(LEAS_TOUKI_JITUGEN_AMT)                                                                              LEAS_TOUKI_JITUGEN_AMT      -- リース料累計 当期実現 " + "\n");
		super.sql.append("      ,SUM(LEAS_TOUKI_GENSYO_AMT)                                                                               LEAS_TOUKI_GENSYO_AMT       -- リース料累計 当期減少 " + "\n");
		super.sql.append("      ,SUM(LEAS_TOUKIMATU_AMT)                                                                                  LEAS_TOUKIMATU_AMT          -- リース料累計 当期末 " + "\n");
		super.sql.append("      ,SUM(MIBARAI_SOUGAKU)                                                                                     MIBARAI_SOUGAKU             -- 未払金(消費税)総額 " + "\n");
		super.sql.append("      ,SUM(MIBARAI_ZENKIMATU_AMT)                                                                               MIBARAI_ZENKIMATU_AMT       -- 未払金(消費税)前期末 " + "\n");
		super.sql.append("      ,SUM(MIBARAI_TOUKI_ZOUKA_AMT)                                                                             MIBARAI_TOUKI_ZOUKA_AMT     -- 未払金(消費税)当期増加 " + "\n");
		super.sql.append("      ,SUM(MIBARAI_TOUKI_JITUGEN_AMT)                                                                           MIBARAI_TOUKI_JITUGEN_AMT   -- 未払金(消費税)当期実現 " + "\n");
		super.sql.append("      ,SUM(MIBARAI_TOUKI_GENSYO_AMT)                                                                            MIBARAI_TOUKI_GENSYO_AMT    -- 未払金(消費税)当期減少 " + "\n");
		super.sql.append("      ,SUM(MIBARAI_TOUKIMATU_AMT)                                                                               MIBARAI_TOUKIMATU_AMT       -- 未払金(消費税)当期末 " + "\n");
		super.sql.append("  FROM ( " + "\n");
		super.sql.append("        SELECT UKB_HEAD.LC_CD                                                                                                               -- リース会社コード " + "\n");
		super.sql.append("              ,UKB_HEAD.KEI_NO                                                                                                              -- 契約番号 " + "\n");
		super.sql.append("              ,UKB_HEAD.BKN_NO                                                                                                              -- 物件番号 " + "\n");
		super.sql.append("              ,UKB_HEAD.BKN_EDANO                                                                                                           -- 物件番号枝番 " + "\n");
		super.sql.append("              ,NVL(UKB_HEAD.SOU_LAMT, 0) + NVL(UKB_HEAD.SOU_USER_ZANK, 0)                                       LEAS_AMT_SOUGAKU            -- リース料総額 " + "\n");
		super.sql.append("              ,NVL(UKB_HEAD.SOU_USER_ZANK, 0)                                                                   ZANK_HSHO_AMT               -- 残価保証額 " + "\n");
		super.sql.append("              ,NVL(UKB_DTL.GNPN_TTL, 0)                                                                         SAIMU_SOUGAKU               -- リース債務総額 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_ZENKIMATU_AMT         -- リース債務前期末 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_TOUKI_ZOUKA_AMT       -- リース債務当期増加 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_TOUKI_JITUGEN_AMT     -- リース債務当期実現 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_TOUKI_GENSYO_AMT      -- リース債務当期減少 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         CASE WHEN WHEAD.MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                   0 " + "\n");
		super.sql.append("                              ELSE NVL(UKB_DTL.ZAND_GNPN, 0) " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         CASE WHEN GREATEST(WHEAD.MAX_KEIJ_YM, MRYO_KEIJ_YM) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                   0 " + "\n");
		super.sql.append("                              ELSE NVL(UKB_DTL.ZAND_GNPN, 0) " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("               END                                                                                              SAIMU_TOUKIMATU_AMT         -- リース債務当期末 " + "\n");
		// 2020/05/22 ADD START
		super.sql.append("              ,NVL(UKB_HEAD.SOU_USER_ZANK, 0)                                                                   ZANK_SOUGAKU                -- 残価保証額総額 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_ZENKIMATU_AMT          -- 残価保証額前期末 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_TOUKI_ZOUKA_AMT        -- 残価保証額当期増加 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_TOUKI_JITUGEN_AMT      -- 残価保証額当期実現 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_TOUKI_GENSYO_AMT       -- 残価保証額当期減少 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         CASE WHEN WHEAD.MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                   0 " + "\n");
		super.sql.append("                              ELSE NVL(UKB_HEAD.SOU_USER_ZANK, 0) " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         CASE WHEN GREATEST(WHEAD.MAX_KEIJ_YM, MRYO_KEIJ_YM) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                   0 " + "\n");
		super.sql.append("                              ELSE NVL(UKB_HEAD.SOU_USER_ZANK, 0) " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("               END                                                                                              ZANK_TOUKIMATU_AMT          -- 残価保証額当期末 " + "\n");
		// 2020/05/22 ADD END
		super.sql.append("              ,CASE BSE.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                    WHEN '201' THEN 0 " + "\n");
		super.sql.append("                    ELSE NVL(UKB_HEAD.SOU_LAMT, 0) + NVL(UKB_HEAD.SOU_USER_ZANK, 0) " + "\n");
		super.sql.append("                         - NVL(UKB_DTL.GNPN_TTL, 0) " + "\n");
		super.sql.append("                         - NVL(SOU_ENT_SHOHYO_KZI, 0) - NVL(SOU_ENT_SHOHYO_HKZI, 0) - NVL(SOU_GTAX, 0) " + "\n");
		super.sql.append("                         - NVL(SOU_CTAX, 0) - NVL(SOU_JTAX, 0) - NVL(SOU_JBSK_HKN, 0) " + "\n");
		super.sql.append("                         - NVL(SOU_NNI_HKN, 0) - NVL(SOU_RCYCL_RYO_KNRI_AMT, 0) - NVL(SOU_DOSO, 0) " + "\n");
		super.sql.append("                         - NVL(SOU_KOZEI, 0) - NVL(SOU_OTH_CST, 0) - NVL(SOU_IPN_EKM_TEIK_HYO, 0) " + "\n");
		super.sql.append("                         - NVL(SOU_SHRY_EKM_TEIK_HYO, 0) " + "\n");
		super.sql.append("                END                                                                                             RSK_SOUGAKU                 -- 利息総額 " + "\n");
		super.sql.append("              ,0                                                                                                RSK_ZENKIMATU_AMT           -- 利息前期末 " + "\n");
		super.sql.append("              ,0                                                                                                RSK_TOUKI_JITUGEN_AMT       -- 利息当期実現 " + "\n");
		super.sql.append("              ,0                                                                                                RSK_TOUKI_GENSYO_AMT        -- 利息当期減少 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         CASE WHEN WHEAD.MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                   0 " + "\n");
		super.sql.append("                              ELSE NVL(UKB_DTL.RUI_RSK, 0) " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         CASE WHEN GREATEST(WHEAD.MAX_KEIJ_YM, MRYO_KEIJ_YM) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                   0 " + "\n");
		super.sql.append("                              ELSE NVL(UKB_DTL.RUI_RSK, 0) " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("               END                                                                                              RSK_TOUKIMATU_AMT           -- 利息当期末 " + "\n");
		super.sql.append("              ,CASE BSE.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                    WHEN '201' THEN 0 " + "\n");
		super.sql.append("                    ELSE NVL(SOU_ENT_SHOHYO_KZI, 0) + NVL(SOU_ENT_SHOHYO_HKZI, 0) + NVL(SOU_GTAX, 0) " + "\n");
		super.sql.append("                         + NVL(SOU_CTAX, 0) + NVL(SOU_JTAX, 0) + NVL(SOU_JBSK_HKN, 0) " + "\n");
		super.sql.append("                         + NVL(SOU_NNI_HKN, 0) + NVL(SOU_RCYCL_RYO_KNRI_AMT, 0) + NVL(SOU_DOSO, 0) " + "\n");
		super.sql.append("                         + NVL(SOU_KOZEI, 0) + NVL(SOU_OTH_CST, 0) " + "\n");
		super.sql.append("                END                                                                                             IJI_SOUGAKU                 -- 維持管理費総額 " + "\n");
		super.sql.append("              ,0                                                                                                IJI_ZENKIMATU_AMT           -- 維持管理費前期末 " + "\n");
		super.sql.append("              ,0                                                                                                IJI_TOUKI_JITUGEN_AMT       -- 維持管理費当期実現 " + "\n");
		super.sql.append("              ,0                                                                                                IJI_TOUKI_GENSYO_AMT        -- 維持管理当期減少 " + "\n");
		super.sql.append("              ,CASE BSE.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                    WHEN '201' THEN 0 " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                              CASE WHEN WHEAD.MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                        0 " + "\n");
		super.sql.append("                                   ELSE NVL(RUI_ENT_SHOHYO_KZI, 0) + NVL(RUI_ENT_SHOHYO_HKZI, 0) + NVL(RUI_GTAX, 0) " + "\n");
		super.sql.append("                                        + NVL(RUI_CTAX, 0) + NVL(RUI_JTAX, 0) + NVL(RUI_JBSK_HKN, 0) " + "\n");
		super.sql.append("                                        + NVL(RUI_NNI_HKN, 0) + NVL(RUI_RCYCL_RYO_KNRI_AMT, 0) + NVL(RUI_DOSO, 0) " + "\n");
		super.sql.append("                                        + NVL(RUI_KOZEI, 0) + NVL(RUI_OTH_CST, 0) " + "\n");
		super.sql.append("                              END " + "\n");
		super.sql.append("                         ELSE " + "\n");
		super.sql.append("                              CASE WHEN GREATEST(WHEAD.MAX_KEIJ_YM, MRYO_KEIJ_YM) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                        0 " + "\n");
		super.sql.append("                                   ELSE NVL(RUI_ENT_SHOHYO_KZI, 0) + NVL(RUI_ENT_SHOHYO_HKZI, 0) + NVL(RUI_GTAX, 0) " + "\n");
		super.sql.append("                                        + NVL(RUI_CTAX, 0) + NVL(RUI_JTAX, 0) + NVL(RUI_JBSK_HKN, 0) " + "\n");
		super.sql.append("                                        + NVL(RUI_NNI_HKN, 0) + NVL(RUI_RCYCL_RYO_KNRI_AMT, 0) + NVL(RUI_DOSO, 0) " + "\n");
		super.sql.append("                                        + NVL(RUI_KOZEI, 0) + NVL(RUI_OTH_CST, 0) " + "\n");
		super.sql.append("                              END " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("                END                                                                                             IJI_TOUKIMATU_AMT           -- 維持管理費当期末 " + "\n");
		super.sql.append("              ,CASE BSE.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                    WHEN '201' THEN 0 " + "\n");
		super.sql.append("                    ELSE NVL(SOU_IPN_EKM_TEIK_HYO, 0) + NVL(SOU_SHRY_EKM_TEIK_HYO, 0) " + "\n");
		super.sql.append("                END                                                                                             EKM_SOUGAKU                 -- 役務提供費総額 " + "\n");
		super.sql.append("              ,0                                                                                                EKM_ZENKIMATU_AMT           -- 役務提供費前期末 " + "\n");
		super.sql.append("              ,0                                                                                                EKM_TOUKI_JITUGEN_AMT       -- 役務提供費当期実現 " + "\n");
		super.sql.append("              ,0                                                                                                EKM_TOUKI_GENSYO_AMT        -- 役務提供費当期減少 " + "\n");
		super.sql.append("              ,CASE BSE.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                    WHEN '201' THEN 0 " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                              CASE WHEN WHEAD.MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                        0 " + "\n");
		super.sql.append("                                   ELSE NVL(RUI_IPN_EKM_TEIK_HYO, 0) + NVL(RUI_SHRY_EKM_TEIK_HYO, 0) " + "\n");
		super.sql.append("                              END " + "\n");
		super.sql.append("                         ELSE " + "\n");
		super.sql.append("                              CASE WHEN GREATEST(WHEAD.MAX_KEIJ_YM, MRYO_KEIJ_YM) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                        0 " + "\n");
		super.sql.append("                                   ELSE NVL(RUI_IPN_EKM_TEIK_HYO, 0) + NVL(RUI_SHRY_EKM_TEIK_HYO, 0) " + "\n");
		super.sql.append("                              END " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("               END                                                                                              EKM_TOUKIMATU_AMT           -- 役務提供費当期末 " + "\n");
		super.sql.append("              ,NVL(UKB_HEAD.SOU_LAMT, 0) + NVL(UKB_HEAD.SOU_USER_ZANK, 0)                                       LEAS_SOUGAKU                -- リース料累計 総額 " + "\n");
		super.sql.append("              ,0                                                                                                LEAS_ZENKIMATU_AMT          -- リース料累計 前期末 " + "\n");
		super.sql.append("              ,0                                                                                                LEAS_TOUKI_JITUGEN_AMT      -- リース料累計 当期実現 " + "\n");
		super.sql.append("              ,0                                                                                                LEAS_TOUKI_GENSYO_AMT       -- リース料累計 当期減少 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         CASE WHEN WHEAD.MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                   0 " + "\n");
		super.sql.append("                              ELSE NVL(UKB_HEAD.RUI_LAMT, 0) " + "\n");
		super.sql.append("                                 + CASE WHEN BSE.MRYO_KEIJ_YM <= BSE.STR_KEIJ_YM OR (BSE.MRYO_KEIJ_YM > WHEAD.MAX_KEIJ_YM AND WHEAD.MAX_KEIJ_YM = UKB_HEAD.KEIJ_YM) THEN " + "\n");
		super.sql.append("                                             NVL(UKB_HEAD.SOU_USER_ZANK, 0) " + "\n");
		super.sql.append("                                        ELSE 0 " + "\n");
		super.sql.append("                                   END " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         CASE WHEN GREATEST(WHEAD.MAX_KEIJ_YM, BSE.MRYO_KEIJ_YM) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                   0 " + "\n");
		super.sql.append("                              ELSE NVL(UKB_HEAD.RUI_LAMT, 0) " + "\n");
		super.sql.append("                                 + CASE WHEN BSE.MRYO_KEIJ_YM <= BSE.STR_KEIJ_YM OR (BSE.MRYO_KEIJ_YM > WHEAD.MAX_KEIJ_YM AND WHEAD.MAX_KEIJ_YM = UKB_HEAD.KEIJ_YM) THEN " + "\n");
		super.sql.append("                                             NVL(UKB_HEAD.SOU_USER_ZANK, 0) " + "\n");
		super.sql.append("                                        ELSE 0 " + "\n");
		super.sql.append("                                   END " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("               END                                                                                              LEAS_TOUKIMATU_AMT          -- リース料累計 当期末 " + "\n");
		super.sql.append("              ,NVL(UKB_HEAD.SOU_LAMT_STAX, 0)                                                                   MIBARAI_SOUGAKU             -- 未払金(消費税)総額 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_ZENKIMATU_AMT       -- 未払金(消費税)前期末 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_TOUKI_ZOUKA_AMT     -- 未払金(消費税)当期増加 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_TOUKI_JITUGEN_AMT   -- 未払金(消費税)当期実現 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_TOUKI_GENSYO_AMT    -- 未払金(消費税)当期減少 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         CASE WHEN WHEAD.MAX_KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                   0 " + "\n");
		super.sql.append("                              ELSE " + "\n");
		super.sql.append("                                   CASE BSE.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("                                        WHEN '3' THEN NVL(UKB_HEAD.RUI_LAMT_STAX, 0) " + "\n");
		super.sql.append("                                        ELSE NVL(UKB_HEAD.ZAN_LAMT_STAX, 0) " + "\n");
		super.sql.append("                                   END " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         CASE WHEN GREATEST(WHEAD.MAX_KEIJ_YM, MRYO_KEIJ_YM) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM THEN " + "\n");
		super.sql.append("                                   0 " + "\n");
		super.sql.append("                              ELSE " + "\n");
		super.sql.append("                                   CASE BSE.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("                                        WHEN '3' THEN NVL(UKB_HEAD.RUI_LAMT_STAX, 0) " + "\n");
		super.sql.append("                                        ELSE NVL(UKB_HEAD.ZAN_LAMT_STAX, 0) " + "\n");
		super.sql.append("                                   END " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("               END                                                                                              MIBARAI_TOUKIMATU_AMT       -- 未払金(消費税)当期末 " + "\n");
		super.sql.append("        FROM   (SELECT KEI.LC_CD -- リース会社コード " + "\n");
		super.sql.append("                      ,KEI.KEI_NO -- 契約番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_NO -- 物件番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_EDANO -- 物件番号枝番 " + "\n");
		super.sql.append("                      ,BKN.RSK_KEIJ_HOHO_KBN -- 採用利息計上方法区分 " + "\n");
		super.sql.append("                      ,KEI.TRD_HNTE_KEKA_KBN -- 取引判定結果区分 " + "\n");
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
		super.sql.append("                AND    HEAD.KAI_REC_FLG = '0' " + "\n");
		super.sql.append("                GROUP  BY HEAD.LC_CD " + "\n");
		super.sql.append("                         ,HEAD.KEI_NO " + "\n");
		super.sql.append("                         ,HEAD.BKN_NO " + "\n");
		super.sql.append("                         ,HEAD.BKN_EDANO) WHEAD " + "\n");
		super.sql.append("              ,T_UKB_TNKI_HEAD UKB_HEAD " + "\n");
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
		super.sql.append("              ,0                                                                                                LEAS_AMT_SOUGAKU            -- リース料総額 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_HSHO_AMT               -- 残価保証額 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_SOUGAKU               -- リース債務総額 " + "\n");
		super.sql.append("              ,NVL(UKB_DTL.ZAND_GNPN, 0)                                                                        SAIMU_ZENKIMATU_AMT         -- リース債務前期末 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_TOUKI_ZOUKA_AMT       -- リース債務当期増加 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_TOUKI_JITUGEN_AMT     -- リース債務当期実現 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_TOUKI_GENSYO_AMT      -- リース債務当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_TOUKIMATU_AMT         -- リース債務当期末 " + "\n");
		// 2020/05/22 ADD START
		super.sql.append("              ,0                                                                                                ZANK_SOUGAKU                -- 残価保証額総額 " + "\n");
		super.sql.append("              ,NVL(UKB_HEAD.SOU_USER_ZANK, 0)                                                                   ZANK_ZENKIMATU_AMT          -- 残価保証額前期末 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_TOUKI_ZOUKA_AMT        -- 残価保証額当期増加 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_TOUKI_JITUGEN_AMT      -- 残価保証額当期実現 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_TOUKI_GENSYO_AMT       -- 残価保証額当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_TOUKIMATU_AMT          -- 残価保証額当期末 " + "\n");
		// 2020/05/22 ADD END
		super.sql.append("              ,0                                                                                                RSK_SOUGAKU                 -- 利息総額 " + "\n");
		super.sql.append("              ,NVL(UKB_DTL.RUI_RSK, 0)                                                                          RSK_ZENKIMATU_AMT           -- 利息前期末 " + "\n");
		super.sql.append("              ,0                                                                                                RSK_TOUKI_JITUGEN_AMT       -- 利息当期実現 " + "\n");
		super.sql.append("              ,0                                                                                                RSK_TOUKI_GENSYO_AMT        -- 利息当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                RSK_TOUKIMATU_AMT           -- 利息当期末 " + "\n");
		super.sql.append("              ,0                                                                                                IJI_SOUGAKU                 -- 維持管理費総額 " + "\n");
		super.sql.append("              ,(NVL(UKB_HEAD.RUI_ENT_SHOHYO_KZI, 0) + " + "\n");
		super.sql.append("                NVL(UKB_HEAD.RUI_ENT_SHOHYO_HKZI, 0) + " + "\n");
		super.sql.append("                NVL(UKB_HEAD.RUI_GTAX, 0) + " + "\n");
		super.sql.append("                NVL(UKB_HEAD.RUI_CTAX, 0) + " + "\n");
		super.sql.append("                NVL(UKB_HEAD.RUI_JTAX, 0) + " + "\n");
		super.sql.append("                NVL(UKB_HEAD.RUI_JBSK_HKN, 0) + " + "\n");
		super.sql.append("                NVL(UKB_HEAD.RUI_NNI_HKN, 0) + " + "\n");
		super.sql.append("                NVL(UKB_HEAD.RUI_RCYCL_RYO_KNRI_AMT, 0) + " + "\n");
		super.sql.append("                NVL(UKB_HEAD.RUI_DOSO, 0) + " + "\n");
		super.sql.append("                NVL(UKB_HEAD.RUI_KOZEI, 0) + " + "\n");
		super.sql.append("                NVL(UKB_HEAD.RUI_OTH_CST, 0))                                                                   IJI_ZENKIMATU_AMT           -- 維持管理費前期末 " + "\n");
		super.sql.append("              ,0                                                                                                IJI_TOUKI_JITUGEN_AMT       -- 維持管理費当期実現 " + "\n");
		super.sql.append("              ,0                                                                                                IJI_TOUKI_GENSYO_AMT        -- 維持管理当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                IJI_TOUKIMATU_AMT           -- 維持管理費当期末 " + "\n");
		super.sql.append("              ,0                                                                                                EKM_SOUGAKU                 -- 役務提供費総額 " + "\n");
		super.sql.append("              ,NVL(UKB_HEAD.RUI_IPN_EKM_TEIK_HYO, 0) + " + "\n");
		super.sql.append("               NVL(UKB_HEAD.RUI_SHRY_EKM_TEIK_HYO, 0)                                                           EKM_ZENKIMATU_AMT           -- 役務提供費前期末 " + "\n");
		super.sql.append("              ,0                                                                                                EKM_TOUKI_JITUGEN_AMT       -- 役務提供費当期実現 " + "\n");
		super.sql.append("              ,0                                                                                                EKM_TOUKI_GENSYO_AMT        -- 役務提供費当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                EKM_TOUKIMATU_AMT           -- 役務提供費当期末 " + "\n");
		super.sql.append("              ,0                                                                                                LEAS_SOUGAKU                -- リース料累計 総額 " + "\n");
		super.sql.append("              ,NVL(UKB_HEAD.RUI_LAMT, 0) " + "\n");
		super.sql.append("               + CASE WHEN BSE.MRYO_KEIJ_YM < BSE.STR_KEIJ_YM OR (BSE.MRYO_KEIJ_YM > WHEAD.MAX_KEIJ_YM AND WHEAD.MAX_KEIJ_YM < BSE.STR_KEIJ_YM) THEN " + "\n");
		super.sql.append("                           NVL(UKB_HEAD.SOU_USER_ZANK,0) " + "\n");
		super.sql.append("                      ELSE 0 " + "\n");
		super.sql.append("                 END                                                                                            LEAS_ZENKIMATU_AMT          -- リース料累計 前期末  " + "\n");
		super.sql.append("              ,0                                                                                                LEAS_TOUKI_JITUGEN_AMT      -- リース料累計 当期実現 " + "\n");
		super.sql.append("              ,0                                                                                                LEAS_TOUKI_GENSYO_AMT       -- リース料累計 当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                LEAS_TOUKIMATU_AMT          -- リース料累計 当期末 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_SOUGAKU             -- 未払金(消費税)総額 " + "\n");
		super.sql.append("              ,CASE BSE.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("                    WHEN '3' THEN NVL(UKB_HEAD.RUI_LAMT_STAX, 0) " + "\n");
		super.sql.append("                    ELSE NVL(UKB_HEAD.ZAN_LAMT_STAX, 0) " + "\n");
		super.sql.append("               END                                                                                              MIBARAI_ZENKIMATU_AMT       -- 未払金(消費税)前期末 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_TOUKI_ZOUKA_AMT     -- 未払金(消費税)当期増加 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_TOUKI_JITUGEN_AMT   -- 未払金(消費税)当期実現 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_TOUKI_GENSYO_AMT    -- 未払金(消費税)当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_TOUKIMATU_AMT       -- 未払金(消費税)当期末 " + "\n");
		super.sql.append("        FROM   (SELECT KEI.LC_CD -- リース会社コード " + "\n");
		super.sql.append("                      ,KEI.KEI_NO -- 契約番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_NO -- 物件番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_EDANO -- 物件番号枝番 " + "\n");
		super.sql.append("                      ,BKN.RSK_KEIJ_HOHO_KBN -- 採用利息計上方法区分 " + "\n");
		super.sql.append("                      ,KEI.TRD_HNTE_KEKA_KBN -- 取引判定結果区分 " + "\n");
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
		super.sql.append("                AND    HEAD.KAI_REC_FLG = '0' " + "\n");
		super.sql.append("                GROUP  BY HEAD.LC_CD " + "\n");
		super.sql.append("                         ,HEAD.KEI_NO " + "\n");
		super.sql.append("                         ,HEAD.BKN_NO " + "\n");
		super.sql.append("                         ,HEAD.BKN_EDANO) WHEAD " + "\n");
		super.sql.append("              ,T_UKB_TNKI_HEAD UKB_HEAD " + "\n");
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
		super.sql.append("              ,0                                                                                                LEAS_AMT_SOUGAKU            -- リース料総額 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_HSHO_AMT               -- 残価保証額 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_SOUGAKU               -- リース債務総額 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_ZENKIMATU_AMT         -- リース債務前期末 " + "\n");
		super.sql.append("              ,CASE WHEN WHEAD.MIN_KEIJ_YM = UKB_HEAD.KEIJ_YM THEN NVL(UKB_DTL.GNPN_TTL, 0) " + "\n");
		super.sql.append("                    ELSE 0 " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("               + NVL(UKB_DTL.ZOU_GNPN, 0)                                                                       SAIMU_TOUKI_ZOUKA_AMT       -- リース債務当期増加 " + "\n");
		super.sql.append("              ,NVL(UKB_DTL.TGTU_GNPN, 0)                                                                        SAIMU_TOUKI_JITUGEN_AMT     -- リース債務当期実現 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         CASE WHEN WHEAD.MAX_KEIJ_YM = UKB_HEAD.KEIJ_YM THEN " + "\n");
		super.sql.append("                                   NVL(UKB_DTL.KAI_LEASE_SAIM_ZAN, 0) " + "\n");
		super.sql.append("                              ELSE 0 " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         0 " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("               + NVL(UKB_DTL.GEN_GNPN, 0)                                                                       SAIMU_TOUKI_GENSYO_AMT      -- リース債務当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_TOUKIMATU_AMT         -- リース債務当期末 " + "\n");
		// 2020/05/22 ADD START
		super.sql.append("              ,0                                                                                                ZANK_SOUGAKU               -- 残価保証額総額 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_ZENKIMATU_AMT         -- 残価保証額前期末 " + "\n");
		super.sql.append("              ,CASE WHEN WHEAD.MIN_KEIJ_YM = UKB_HEAD.KEIJ_YM THEN NVL(UKB_HEAD.SOU_USER_ZANK, 0) " + "\n");
		super.sql.append("                    ELSE 0 " + "\n");
		super.sql.append("               END                                                                                              ZANK_TOUKI_ZOUKA_AMT       -- 残価保証額当期増加 " + "\n");
		super.sql.append("              ,NVL(UKB_HEAD.SOU_USER_ZANK, 0)                                                                   ZANK_TOUKI_JITUGEN_AMT     -- 残価保証額当期実現 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         CASE WHEN WHEAD.MAX_KEIJ_YM = UKB_HEAD.KEIJ_YM THEN " + "\n");
		super.sql.append("                                   NVL(UKB_HEAD.SOU_USER_ZANK, 0) " + "\n");
		super.sql.append("                              ELSE 0 " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         0 " + "\n");
		super.sql.append("               END                                                                                              ZANK_TOUKI_GENSYO_AMT       -- 残価保証額当期減少 " + "\n");
		//super.sql.append("              ,NVL(UKB_HEAD.SOU_USER_ZANK, 0)                                                                     ZANK_TOUKI_GENSYO_AMT     -- 残価保証額当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_TOUKIMATU_AMT          -- 残価保証額当期末 " + "\n");
		// 2020/05/22 ADD END
		super.sql.append("              ,0                                                                                                RSK_SOUGAKU                 -- 利息総額 " + "\n");
		super.sql.append("              ,0                                                                                                RSK_ZENKIMATU_AMT           -- 利息前期末 " + "\n");
		super.sql.append("              ,NVL(UKB_DTL.TGTU_RSK, 0)                                                                         RSK_TOUKI_JITUGEN_AMT       -- 利息当期実現 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         CASE WHEN WHEAD.MAX_KEIJ_YM = UKB_HEAD.KEIJ_YM THEN " + "\n");
		super.sql.append("                                   NVL(UKB_DTL.RUI_RSK, 0) " + "\n");
		super.sql.append("                              ELSE 0 " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         0 " + "\n");
		super.sql.append("               END                                                                                              RSK_TOUKI_GENSYO_AMT        -- 利息当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                RSK_TOUKIMATU_AMT           -- 利息当期末 " + "\n");
		super.sql.append("              ,0                                                                                                IJI_SOUGAKU                 -- 維持管理費総額 " + "\n");
		super.sql.append("              ,0                                                                                                IJI_ZENKIMATU_AMT           -- 維持管理費前期末 " + "\n");
		super.sql.append("              ,(NVL(ENT_SHOHYO_KZI, 0) + " + "\n");
		super.sql.append("                NVL(ENT_SHOHYO_HKZI, 0) + " + "\n");
		super.sql.append("                NVL(GTAX, 0) + " + "\n");
		super.sql.append("                NVL(CTAX, 0) + " + "\n");
		super.sql.append("                NVL(JTAX, 0) + " + "\n");
		super.sql.append("                NVL(JBSK_HKN,0) + " + "\n");
		super.sql.append("                NVL(NNI_HKN,0) + " + "\n");
		super.sql.append("                NVL(RCYCL_RYO_KNRI_AMT, 0) + " + "\n");
		super.sql.append("                NVL(DOSO, 0) + " + "\n");
		super.sql.append("                NVL(KOZEI, 0) + " + "\n");
		super.sql.append("                NVL(OTH_CST, 0))                                                                                IJI_TOUKI_JITUGEN_AMT       -- 維持管理費当期実現 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         CASE WHEN WHEAD.MAX_KEIJ_YM = UKB_HEAD.KEIJ_YM THEN " + "\n");
		super.sql.append("                                   NVL(UKB_HEAD.RUI_ENT_SHOHYO_KZI, 0) + NVL(UKB_HEAD.RUI_ENT_SHOHYO_HKZI, 0) + NVL(UKB_HEAD.RUI_GTAX, 0) " + "\n");
		super.sql.append("                                   + NVL(UKB_HEAD.RUI_CTAX, 0) + NVL(UKB_HEAD.RUI_JTAX, 0) + NVL(UKB_HEAD.RUI_JBSK_HKN, 0) " + "\n");
		super.sql.append("                                   + NVL(UKB_HEAD.RUI_NNI_HKN, 0) + NVL(UKB_HEAD.RUI_RCYCL_RYO_KNRI_AMT, 0) + NVL(UKB_HEAD.RUI_DOSO, 0) + " + "\n");
		super.sql.append("                                   + NVL(UKB_HEAD.RUI_KOZEI, 0) + NVL(UKB_HEAD.RUI_OTH_CST, 0) " + "\n");
		super.sql.append("                              ELSE 0 " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         0 " + "\n");
		super.sql.append("               END                                                                                              IJI_TOUKI_GENSYO_AMT        -- 維持管理費当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                IJI_TOUKIMATU_AMT           -- 維持管理費当期末 " + "\n");
		super.sql.append("              ,0                                                                                                EKM_SOUGAKU                 -- 役務提供費総額 " + "\n");
		super.sql.append("              ,0                                                                                                EKM_ZENKIMATU_AMT           -- 役務提供費前期末 " + "\n");
		super.sql.append("              ,NVL(IPN_EKM_TEIK_HYO, 0) + NVL(SHRY_EKM_TEIK_HYO,0)                                              EKM_TOUKI_JITUGEN_AMT       -- 役務提供費当期実現 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         CASE WHEN WHEAD.MAX_KEIJ_YM = UKB_HEAD.KEIJ_YM THEN " + "\n");
		super.sql.append("                                   NVL(UKB_HEAD.RUI_IPN_EKM_TEIK_HYO, 0) + NVL(UKB_HEAD.RUI_SHRY_EKM_TEIK_HYO, 0) " + "\n");
		super.sql.append("                              ELSE 0 " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         0 " + "\n");
		super.sql.append("               END                                                                                              EKM_TOUKI_GENSYO_AMT        -- 役務提供費当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                EKM_TOUKIMATU_AMT           -- 役務提供費当期末 " + "\n");
		super.sql.append("              ,0                                                                                                LEAS_SOUGAKU                -- リース料累計 総額 " + "\n");
		super.sql.append("              ,0                                                                                                LEAS_ZENKIMATU_AMT          -- リース料累計 前期末 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NULL THEN " + "\n");
		super.sql.append("                         CASE WHEN UKB_HEAD.KEIJ_YM = MRYO_KEIJ_YM OR (BSE.MRYO_KEIJ_YM > WHEAD.MAX_KEIJ_YM AND WHEAD.MAX_KEIJ_YM = UKB_HEAD.KEIJ_YM) THEN " + "\n");
		super.sql.append("                                   NVL(UKB_HEAD.SOU_USER_ZANK, 0) " + "\n");
		super.sql.append("                              ELSE 0 " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("                    ELSE 0 " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("               + NVL(UKB_HEAD.LAMT, 0)                                                                          LEAS_TOUKI_JITUGEN_AMT      -- リース料累計 当期実現 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         CASE WHEN WHEAD.MAX_KEIJ_YM = UKB_HEAD.KEIJ_YM THEN " + "\n");
		super.sql.append("                                   NVL(UKB_HEAD.RUI_LAMT, 0) " + "\n");
		super.sql.append("                              ELSE 0 " + "\n");
		super.sql.append("                         END " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         0 " + "\n");
		super.sql.append("               END                                                                                              LEAS_TOUKI_GENSYO_AMT       -- リース料累計 当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                LEAS_TOUKIMATU_AMT          -- リース料累計 当期末 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_SOUGAKU             -- 未払金(消費税)総額 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_ZENKIMATU_AMT       -- 未払金(消費税)前期末 " + "\n");
		super.sql.append("              ,CASE WHEN WHEAD.MIN_KEIJ_YM = UKB_HEAD.KEIJ_YM THEN NVL(UKB_HEAD.SOU_LAMT_STAX, 0) " + "\n");
		super.sql.append("                    ELSE 0 " + "\n");
		super.sql.append("               END " + "\n");
		super.sql.append("               + NVL(UKB_HEAD.ZOU_LAMT_STAX, 0)                                                                 MIBARAI_TOUKI_ZOUKA_AMT     -- 未払金(消費税)当期増加 " + "\n");
		super.sql.append("              ,NVL(LAMT_STAX, 0)                                                                                MIBARAI_TOUKI_JITUGEN_AMT   -- 未払金(消費税)当期実現 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN  " + "\n");
		super.sql.append("                         CASE WHEN WHEAD.MAX_KEIJ_YM = UKB_HEAD.KEIJ_YM THEN  " + "\n");
		super.sql.append("                                   CASE BSE.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("                                        WHEN '3' THEN NVL(UKB_HEAD.RUI_LAMT_STAX, 0) " + "\n");
		super.sql.append("                                        ELSE NVL(UKB_HEAD.KAI_LAMT_STAX, 0) " + "\n");
		super.sql.append("                                   END " + "\n");
		super.sql.append("                              ELSE 0  " + "\n");
		super.sql.append("                         END  " + "\n");
		super.sql.append("                    ELSE  " + "\n");
		super.sql.append("                         0 " + "\n");
		super.sql.append("               END  " + "\n");
		super.sql.append("               + CASE BSE.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("                    WHEN '3' THEN 0 " + "\n");
		super.sql.append("                    ELSE NVL(UKB_HEAD.GEN_LAMT_STAX, 0) " + "\n");
		super.sql.append("               END                                                                                              MIBARAI_TOUKI_GENSYO_AMT    -- 未払金(消費税)当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_TOUKIMATU_AMT       -- 未払金(消費税)当期末 " + "\n");
		super.sql.append("        FROM   (SELECT KEI.LC_CD -- リース会社コード " + "\n");
		super.sql.append("                      ,KEI.KEI_NO -- 契約番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_NO -- 物件番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_EDANO -- 物件番号枝番 " + "\n");
		super.sql.append("                      ,BKN.RSK_KEIJ_HOHO_KBN -- 採用利息計上方法区分 " + "\n");
		super.sql.append("                      ,KEI.TRD_HNTE_KEKA_KBN -- 取引判定結果区分 " + "\n");
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
		super.sql.append("                AND    HEAD.KAI_REC_FLG = '0' " + "\n");
		super.sql.append("                GROUP  BY HEAD.LC_CD " + "\n");
		super.sql.append("                         ,HEAD.KEI_NO " + "\n");
		super.sql.append("                         ,HEAD.BKN_NO " + "\n");
		super.sql.append("                         ,HEAD.BKN_EDANO) WHEAD " + "\n");
		super.sql.append("              ,T_UKB_TNKI_HEAD UKB_HEAD " + "\n");
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
		super.sql.append("              ,0                                                                                                LEAS_AMT_SOUGAKU            -- リース料総額 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_HSHO_AMT               -- 残価保証額 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_SOUGAKU               -- リース債務総額 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_ZENKIMATU_AMT         -- リース債務前期末 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_TOUKI_ZOUKA_AMT       -- リース債務当期増加 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_TOUKI_JITUGEN_AMT     -- リース債務当期実現 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_TOUKI_GENSYO_AMT      -- リース債務当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                SAIMU_TOUKIMATU_AMT         -- リース債務当期末 " + "\n");
		// 2020/05/22 ADD START
		super.sql.append("              ,0                                                                                                ZANK_SOUGAKU               -- 残価保証額総額 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_ZENKIMATU_AMT         -- 残価保証額前期末 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_TOUKI_ZOUKA_AMT       -- 残価保証額当期増加 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_TOUKI_JITUGEN_AMT     -- 残価保証額当期実現 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_TOUKI_GENSYO_AMT      -- 残価保証額当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                ZANK_TOUKIMATU_AMT         -- 残価保証額当期末 " + "\n");
		// 2020/05/22 ADD END
		super.sql.append("              ,0                                                                                                RSK_SOUGAKU                 -- 利息総額 " + "\n");
		super.sql.append("              ,0                                                                                                RSK_ZENKIMATU_AMT           -- 利息前期末 " + "\n");
		super.sql.append("              ,0                                                                                                RSK_TOUKI_JITUGEN_AMT       -- 利息当期実現 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         0 " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         NVL(UKB_DTL.RUI_RSK, 0) " + "\n");
		super.sql.append("               END                                                                                              RSK_TOUKI_GENSYO_AMT        -- 利息当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                RSK_TOUKIMATU_AMT           -- 利息当期末 " + "\n");
		super.sql.append("              ,0                                                                                                IJI_SOUGAKU                 -- 維持管理費総額 " + "\n");
		super.sql.append("              ,0                                                                                                IJI_ZENKIMATU_AMT           -- 維持管理費前期末 " + "\n");
		super.sql.append("              ,0                                                                                                IJI_TOUKI_JITUGEN_AMT       -- 維持管理費当期実現 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         0 " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         NVL(UKB_HEAD.RUI_ENT_SHOHYO_KZI, 0) + NVL(UKB_HEAD.RUI_ENT_SHOHYO_HKZI, 0) + NVL(UKB_HEAD.RUI_GTAX, 0) " + "\n");
		super.sql.append("                         + NVL(UKB_HEAD.RUI_CTAX, 0) + NVL(UKB_HEAD.RUI_JTAX, 0) + NVL(UKB_HEAD.RUI_JBSK_HKN, 0) " + "\n");
		super.sql.append("                         + NVL(UKB_HEAD.RUI_NNI_HKN, 0) + NVL(UKB_HEAD.RUI_RCYCL_RYO_KNRI_AMT, 0) + NVL(UKB_HEAD.RUI_DOSO, 0) + " + "\n");
		super.sql.append("                         + NVL(UKB_HEAD.RUI_KOZEI, 0) + NVL(UKB_HEAD.RUI_OTH_CST, 0) " + "\n");
		super.sql.append("               END                                                                                              IJI_TOUKI_GENSYO_AMT        -- 維持管理費当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                IJI_TOUKIMATU_AMT           -- 維持管理費当期末 " + "\n");
		super.sql.append("              ,0                                                                                                EKM_SOUGAKU                 -- 役務提供費総額 " + "\n");
		super.sql.append("              ,0                                                                                                EKM_ZENKIMATU_AMT           -- 役務提供費前期末 " + "\n");
		super.sql.append("              ,0                                                                                                EKM_TOUKI_JITUGEN_AMT       -- 役務提供費当期実現 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         0 " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         NVL(UKB_HEAD.RUI_IPN_EKM_TEIK_HYO, 0) + NVL(UKB_HEAD.RUI_SHRY_EKM_TEIK_HYO, 0) " + "\n");
		super.sql.append("               END                                                                                              EKM_TOUKI_GENSYO_AMT        -- 役務提供費当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                EKM_TOUKIMATU_AMT           -- 役務提供費当期末 " + "\n");
		super.sql.append("              ,0                                                                                                LEAS_SOUGAKU                -- リース料累計 総額 " + "\n");
		super.sql.append("              ,0                                                                                                LEAS_ZENKIMATU_AMT          -- リース料累計 前期末 " + "\n");
		super.sql.append("              ,0                                                                                                LEAS_TOUKI_JITUGEN_AMT      -- リース料累計 当期実現 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
		super.sql.append("                         0 " + "\n");
		super.sql.append("                    ELSE " + "\n");
		super.sql.append("                         NVL(UKB_HEAD.RUI_LAMT, 0) + NVL(UKB_HEAD.SOU_USER_ZANK, 0) " + "\n");
		super.sql.append("               END                                                                                              LEAS_TOUKI_GENSYO_AMT       -- リース料累計 当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                LEAS_TOUKIMATU_AMT          -- リース料累計 当期末 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_SOUGAKU             -- 未払金(消費税)総額 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_ZENKIMATU_AMT       -- 未払金(消費税)前期末 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_TOUKI_ZOUKA_AMT     -- 未払金(消費税)当期増加 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_TOUKI_JITUGEN_AMT   -- 未払金(消費税)当期実現 " + "\n");
		super.sql.append("              ,CASE WHEN BSE.KAI_YMD IS NOT NULL THEN  " + "\n");
		super.sql.append("                         0  " + "\n");
		super.sql.append("                    ELSE  " + "\n");
		super.sql.append("                         CASE BSE.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("                              WHEN '3' THEN NVL(UKB_HEAD.RUI_LAMT_STAX, 0) " + "\n");
		super.sql.append("                              ELSE NVL(UKB_HEAD.ZAN_LAMT_STAX, 0) " + "\n");
		super.sql.append("                         END  " + "\n");
		super.sql.append("               END                                                                                              MIBARAI_TOUKI_GENSYO_AMT    -- 未払金(消費税)当期減少 " + "\n");
		super.sql.append("              ,0                                                                                                MIBARAI_TOUKIMATU_AMT       -- 未払金(消費税)当期末 " + "\n");
		super.sql.append("        FROM   (SELECT KEI.LC_CD -- リース会社コード " + "\n");
		super.sql.append("                      ,KEI.KEI_NO -- 契約番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_NO -- 物件番号 " + "\n");
		super.sql.append("                      ,BKN.BKN_EDANO -- 物件番号枝番 " + "\n");
		super.sql.append("                      ,BKN.RSK_KEIJ_HOHO_KBN -- 採用利息計上方法区分 " + "\n");
		super.sql.append("                      ,KEI.TRD_HNTE_KEKA_KBN -- 取引判定結果区分 " + "\n");
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
		super.sql.append("                AND    HEAD.KAI_REC_FLG = '0' " + "\n");
		super.sql.append("                GROUP  BY HEAD.LC_CD " + "\n");
		super.sql.append("                         ,HEAD.KEI_NO " + "\n");
		super.sql.append("                         ,HEAD.BKN_NO " + "\n");
		super.sql.append("                         ,HEAD.BKN_EDANO) WHEAD " + "\n");
		super.sql.append("              ,T_UKB_TNKI_HEAD UKB_HEAD " + "\n");
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
		super.sql.append("      ,M_LC LC " + "\n");
		super.sql.append("      ,M_LU LU " + "\n");
		super.sql.append("      ,M_SSN_SRI SSN " + "\n");
		super.sql.append("      ,M_TRD_HNTE_KEKA_KBN TRD " + "\n");
		super.sql.append("      ,T_KEI KEI " + "\n");
		super.sql.append("      ,T_BKN BKN " + "\n");
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
		// 2020/05/22 ADD START
		super.sql.append("         ,CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN 'あり' ELSE 'なし' END " + "\n");
		super.sql.append("         ,CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END " + "\n");
		// 2020/05/22 ADD END
		super.sql.append("         ,KEI.TAISHO_AC_KIJYUN_CD " + "\n");
		super.sql.append("         ,KEI.CTSHK_FLG " + "\n");
		super.sql.append("         ,KEI.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("         ,SSN.YUKEI_MUKEI_KBN " + "\n");
		super.sql.append("         ,DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_NM, LU.PDF_COMPANY_NM) " + "\n");
		super.sql.append("         ,LU.LU_NM " + "\n");
		super.sql.append("         ,KEI.KEI_NO " + "\n");
		super.sql.append("         ,KEI.HYJYO_KEI_NO " + "\n");
		super.sql.append("         ,BKN.BKN_NO " + "\n");
		super.sql.append("         ,BKN.BKN_EDANO " + "\n");
		super.sql.append("         ,BKN.BKN_NM " + "\n");
		super.sql.append("         ,KEI.KNSHU_YMD " + "\n");
		super.sql.append("         ,KEI.MRYO_YMD " + "\n");
		super.sql.append("         ,KEI.KAI_YMD " + "\n");
		super.sql.append("         ,TRD.TRD_HNTE_KEKA_NM " + "\n");
		// 2020/05/22 REP START
		//super.sql.append(" ORDER BY DECODE(KEI.TRD_HNTE_KEKA_KBN, '3', '1', '0') " + "\n");
		//super.sql.append("         ,KEI.LC_CD " + "\n");

		//super.sql.append(" ORDER BY DECODE(KEI.TRD_HNTE_KEKA_KBN, '3', '1', '0') " + "\n");
		super.sql.append(" ORDER BY KEI.LC_CD " + "\n");
		super.sql.append("         ,CASE WHEN NVL(KEI.JYSI_UM,'0') = '1' THEN '1' ELSE '0' END " + "\n");
		super.sql.append("         ,DECODE(KEI.TRD_HNTE_KEKA_KBN, '3', '1', '0') " + "\n");
		// 2020/05/22 REP END
		super.sql.append("         ,KEI.TAISHO_AC_KIJYUN_CD " + "\n");
		super.sql.append("         ,KEI.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("         ,KEI.CTSHK_FLG " + "\n");
		super.sql.append("         ,SSN.YUKEI_MUKEI_KBN " + "\n");
		super.sql.append("         ,KEI.HYJYO_KEI_NO " + "\n");
		super.sql.append("         ,BKN.BKN_NO " + "\n");
		super.sql.append("         ,BKN.BKN_EDANO " + "\n");

		// 2020/05/22 ADD TEST START
		//System.out.println("SQL LACSUkebaraiLeaseEntity.java start");
		//System.out.println(super.sql);
		//System.out.println("SQL LACSUkebaraiLeaseEntity.java end");
		// 2020/05/22 ADD TEST END
		//System.out.println(sql);
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
	 * 資産区分コードを取得.
	 * 
	 * @return 資産区分コード
	 */
	public String getYukeiMukeiKbn() {
		return super.getString("YUKEI_MUKEI_KBN");
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
	 * リース料総額を取得.
	 * 
	 * @return リース料総額
	 */
	public long getLeasAmtSougaku() {
		return super.getLong("LEAS_AMT_SOUGAKU");
	}

	/**
	 * 残価保証額を取得.
	 * 
	 * @return 残価保証額
	 */
	public long getZankaHosyoAmt() {
		return super.getLong("ZANK_HSHO_AMT");
	}

	/**
	 * リース債務総額を取得.
	 * 
	 * @return リース債務総額
	 */
	public long getSaimuSougaku() {
		return super.getLong("SAIMU_SOUGAKU");
	}

	/**
	 * リース債務前期末を取得.
	 * 
	 * @return リース債務前期末
	 */
	public long getSaimuZenkimatuAmt() {
		return super.getLong("SAIMU_ZENKIMATU_AMT");
	}

	/**
	 * リース債務当期増加を取得.
	 * 
	 * @return リース債務当期増加
	 */
	public long getSaimuToukiZoukaAmt() {
		return super.getLong("SAIMU_TOUKI_ZOUKA_AMT");
	}

	/**
	 * リース債務当期実現を取得.
	 * 
	 * @return リース債務当期実現
	 */
	public long getSaimuToukiJitugenAmt() {
		return super.getLong("SAIMU_TOUKI_JITUGEN_AMT");
	}

	/**
	 * リース債務当期減少を取得.
	 * 
	 * @return リース債務当期減少
	 */
	public long getSaimuToukiGensyoAmt() {
		return super.getLong("SAIMU_TOUKI_GENSYO_AMT");
	}

	/**
	 * リース債務当期末を取得.
	 * 
	 * @return リース債務当期末
	 */
	public long getSaimuToukimatuAmt() {
		return super.getLong("SAIMU_TOUKIMATU_AMT");
	}

	/**
	 * 利息総額を取得.
	 * 
	 * @return 利息総額
	 */
	public long getRskSougaku() {
		return super.getLong("RSK_SOUGAKU");
	}

	/**
	 * 利息前期末を取得.
	 * 
	 * @return 利息前期末
	 */
	public long getRskZenkimatuAmt() {
		return super.getLong("RSK_ZENKIMATU_AMT");
	}

	/**
	 * 利息当期実現を取得.
	 * 
	 * @return 利息当期実現
	 */
	public long getRskToukiJitugenAmt() {
		return super.getLong("RSK_TOUKI_JITUGEN_AMT");
	}

	/**
	 * 利息当期減少を取得.
	 * 
	 * @return 利息当期減少
	 */
	public long getRskToukiGensyoAmt() {
		return super.getLong("RSK_TOUKI_GENSYO_AMT");
	}

	/**
	 * 利息当期末を取得.
	 * 
	 * @return 利息当期末
	 */
	public long getRskToukimatuAmt() {
		return super.getLong("RSK_TOUKIMATU_AMT");
	}

	/**
	 * 維持管理費総額を取得.
	 * 
	 * @return 維持管理費総額
	 */
	public long getIjiSougaku() {
		return super.getLong("IJI_SOUGAKU");
	}

	/**
	 * 維持管理費前期末を取得.
	 * 
	 * @return 維持管理費前期末
	 */
	public long getIjiZenkimatuAmt() {
		return super.getLong("IJI_ZENKIMATU_AMT");
	}

	/**
	 * 維持管理費当期実現を取得.
	 * 
	 * @return 維持管理費当期実現
	 */
	public long getIjiToukiJitugenAmt() {
		return super.getLong("IJI_TOUKI_JITUGEN_AMT");
	}

	/**
	 * 維持管理費当期減少を取得.
	 * 
	 * @return 維持管理費当期減少
	 */
	public long getIjiToukiGensyoAmt() {
		return super.getLong("IJI_TOUKI_GENSYO_AMT");
	}

	/**
	 * 維持管理費当期末を取得.
	 * 
	 * @return 維持管理費当期末
	 */
	public long getIjiToukimatuAmt() {
		return super.getLong("IJI_TOUKIMATU_AMT");
	}

	/**
	 * 役務提供費総額を取得.
	 * 
	 * @return 役務提供費総額
	 */
	public long getEkmSougaku() {
		return super.getLong("EKM_SOUGAKU");
	}

	/**
	 * 役務提供費前期末を取得.
	 * 
	 * @return 役務提供費前期末
	 */
	public long getEkmZenkimatuAmt() {
		return super.getLong("EKM_ZENKIMATU_AMT");
	}

	/**
	 * 役務提供費当期実現を取得.
	 * 
	 * @return 役務提供費当期実現
	 */
	public long getEkmToukiJitugenAmt() {
		return super.getLong("EKM_TOUKI_JITUGEN_AMT");
	}

	/**
	 * 役務提供費当期減少を取得.
	 * 
	 * @return 役務提供費当期減少
	 */
	public long getEkmToukiGensyoAmt() {
		return super.getLong("EKM_TOUKI_GENSYO_AMT");
	}

	/**
	 * 役務提供費当期末を取得.
	 * 
	 * @return 役務提供費当期末
	 */
	public long getEkmToukimatuAmt() {
		return super.getLong("EKM_TOUKIMATU_AMT");
	}

	/**
	 * リース料累計 総額を取得.
	 * 
	 * @return リース料累計 総額
	 */
	public long getLeasAmtRuiSougaku() {
		return super.getLong("LEAS_SOUGAKU");
	}

	/**
	 * リース料累計 前期末を取得.
	 * 
	 * @return リース料累計 前期末
	 */
	public long getLeasAmtRuiZenkimatuAmt() {
		return super.getLong("LEAS_ZENKIMATU_AMT");
	}

	/**
	 * リース料累計 当期実現を取得.
	 * 
	 * @return リース料累計 当期実現
	 */
	public long getLeasAmtRuiToukiJitugenAmt() {
		return super.getLong("LEAS_TOUKI_JITUGEN_AMT");
	}

	/**
	 * リース料累計 当期減少を取得.
	 * 
	 * @return リース料累計 当期減少
	 */
	public long getLeasAmtRuiToukiGensyoAmt() {
		return super.getLong("LEAS_TOUKI_GENSYO_AMT");
	}

	/**
	 * リース料累計 当期末を取得.
	 * 
	 * @return リース料累計 当期末
	 */
	public long getLeasAmtRuiToukimatuAmt() {
		return super.getLong("LEAS_TOUKIMATU_AMT");
	}

	/**
	 * 未払金(消費税)総額を取得.
	 * 
	 * @return 未払金(消費税)総額
	 */
	public long getMibaraiSougaku() {
		return super.getLong("MIBARAI_SOUGAKU");
	}

	/**
	 * 未払金(消費税)前期末を取得.
	 * 
	 * @return 未払金(消費税)前期末
	 */
	public long getMibaraiZenkimatuAmt() {
		return super.getLong("MIBARAI_ZENKIMATU_AMT");
	}

	/**
	 * 未払金(消費税)当期増加を取得.
	 * 
	 * @return 未払金(消費税)当期増加
	 */
	public long getMibaraiToukiZoukaAmt() {
		return super.getLong("MIBARAI_TOUKI_ZOUKA_AMT");
	}

	/**
	 * 未払金(消費税)当期実現を取得.
	 * 
	 * @return 未払金(消費税)当期実現
	 */
	public long getMibaraiToukiJitugenAmt() {
		return super.getLong("MIBARAI_TOUKI_JITUGEN_AMT");
	}

	/**
	 * 未払金(消費税)当期減少を取得.
	 * 
	 * @return 未払金(消費税)当期減少
	 */
	public long getMibaraiToukiGensyoAmt() {
		return super.getLong("MIBARAI_TOUKI_GENSYO_AMT");
	}

	/**
	 * 未払金(消費税)当期末を取得.
	 * 
	 * @return 未払金(消費税)当期末
	 */
	public long getMibaraiToukimatuAmt() {
		return super.getLong("MIBARAI_TOUKIMATU_AMT");
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
	 * 重要性有無を取得.
	 * 
	 * @return 重要性有無
	 */
	public String getJysiUm() {
		return super.getString("JYSI_UM");
	}

	/**
	 * 残価保証額総額を取得.
	 * 
	 * @return 残価保証額総額
	 */
	public long getZankSougaku() {
		return super.getLong("ZANK_SOUGAKU");
	}

	/**
	 * 残価保証額前期末を取得.
	 * 
	 * @return 残価保証額前期末
	 */
	public long getZankZenkimatuAmt() {
		return super.getLong("ZANK_ZENKIMATU_AMT");
	}

	/**
	 * 残価保証額当期増加を取得.
	 * 
	 * @return 残価保証額当期増加
	 */
	public long getZankToukiZoukaAmt() {
		return super.getLong("ZANK_TOUKI_ZOUKA_AMT");
	}
	
	/**
	 * 残価保証額当期実現を取得.
	 * 
	 * @return 残価保証額当期実現
	 */
	public long getZankToukiJitugenAmt() {
		return super.getLong("ZANK_TOUKI_JITUGEN_AMT");
	}
    
	/**
	 * 残価保証額当期減少を取得.
	 * 
	 * @return 残価保証額当期減少
	 */
	public long getZankToukiGensyoAmt() {
		return super.getLong("ZANK_TOUKI_GENSYO_AMT");
	}

	/**
	 * 残価保証額当期末を取得.
	 * 
	 * @return 残価保証額当期末
	 */
	public long getZankToukimatuAmt() {
		return super.getLong("ZANK_TOUKIMATU_AMT");
	}
	// 2020/05/22 ADD END
}
