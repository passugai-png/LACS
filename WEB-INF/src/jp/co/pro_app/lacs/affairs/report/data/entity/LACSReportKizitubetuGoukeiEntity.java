package jp.co.pro_app.lacs.affairs.report.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
//import jp.co.pro_app.lacs.affairs.report.common.LACSReportCommon;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.model.DBModelBase;


	/**
	 * 帳票出力：期日別予定表(合計）Entity.
	 * 
	 * @author arai
	 * @version 20200616
	 */

	public class LACSReportKizitubetuGoukeiEntity extends LACSReportEntityBase {		
		
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
		public LACSReportKizitubetuGoukeiEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSReportBean piReportBean, String piAcStd) {		
			
			super(piModel, piCommonBean, piReportBean, piAcStd);		
			super.dateFrom = piReportBean.getTermFrom().getYYYYMMDD();
			super.termNum = piReportBean.getTermNum();	
			
		}
		
		/**
		 * SQLを生成.
		 */
		protected void makeSQL() {
	
//
			   super.sql.append("SELECT  " + "\n");
			   super.sql.append("         TO_CHAR(SYSDATE, 'YYYYMMDD') CREATE_DATE " + "\n"); // 作成日
			   super.sql.append("        ,LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ") KIJUN_DATE " + "\n"); // 基準日				
			   super.sql.append("        ,GOKEI.LEASE_COMPANY " + "\n");
			   super.sql.append("        ,GOKEI.LU_NM " + "\n");
			   super.sql.append("        ,CASE WHEN NVL(GOKEI.JYSI_UM_CD,'0') = '0' THEN '0' ELSE '1' END JYSI_UM_CD " + "\n");
			   super.sql.append("        ,GOKEI.JYSI_UM_NM " + "\n");
			   super.sql.append("        ,GOKEI.LEASE_BUNRUI_CD " + "\n");
			   super.sql.append("        ,GOKEI.LEASE_BUNRUI  " + "\n");
			   super.sql.append("        ,GOKEI.AC_SHR_KBN  " + "\n");
			   super.sql.append("        ,GOKEI.AC_SHR_NM  " + "\n");
			   super.sql.append("--債務 " + "\n");
			   super.sql.append("        ,SUM(GOKEI.MIKEIKA_LEASE_ONE_YEAR)          MIKEIKA_LEASE_ONE_YEAR " + "\n");
			   super.sql.append("        ,SUM(GOKEI.ZANK_HOSYOGAKU_ONE_YEAR)         ZANK_HOSYOGAKU_ONE_YEAR " + "\n");
			   super.sql.append("        ,SUM(GOKEI.GNPN_ONE_YEAR)                   GNPN_ONE_YEAR  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.RSK_ONE_YEAR)                    RSK_ONE_YEAR  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.IJI_KANRIHI_ONE_YEAR)            IJI_KANRIHI_ONE_YEAR  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.EKM_TEIK_ONE_YEAR)               EKM_TEIK_ONE_YEAR  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.LAMT_STAX_ONE_YEAR)              LAMT_STAX_ONE_YEAR  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.MIKEIKA_LEASE_TWO_YEARS)         MIKEIKA_LEASE_TWO_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.ZANK_HOSYOGAKU_TWO_YEARS)        ZANK_HOSYOGAKU_TWO_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.GNPN_TWO_YEARS)                  GNPN_TWO_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.RSK_TWO_YEARS)                   RSK_TWO_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.IJI_KANRIHI_TWO_YEARS)           IJI_KANRIHI_TWO_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.EKM_TEIK_TWO_YEARS)              EKM_TEIK_TWO_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.LAMT_STAX_TWO_YEARS)             LAMT_STAX_TWO_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.MIKEIKA_LEASE_THREE_YEARS)       MIKEIKA_LEASE_THREE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.ZANK_HOSYOGAKU_THREE_YEARS)      ZANK_HOSYOGAKU_THREE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.GNPN_THREE_YEARS)                GNPN_THREE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.RSK_THREE_YEARS)                 RSK_THREE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.IJI_KANRIHI_THREE_YEARS)         IJI_KANRIHI_THREE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.EKM_TEIK_THREE_YEARS)            EKM_TEIK_THREE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.LAMT_STAX_THREE_YEARS)           LAMT_STAX_THREE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.MIKEIKA_LEASE_FOUR_YEARS)        MIKEIKA_LEASE_FOUR_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.ZANK_HOSYOGAKU_FOUR_YEARS)       ZANK_HOSYOGAKU_FOUR_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.GNPN_FOUR_YEARS)                 GNPN_FOUR_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.RSK_FOUR_YEARS)                  RSK_FOUR_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.IJI_KANRIHI_FOUR_YEARS)          IJI_KANRIHI_FOUR_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.EKM_TEIK_FOUR_YEARS)             EKM_TEIK_FOUR_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.LAMT_STAX_FOUR_YEARS)            LAMT_STAX_FOUR_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.MIKEIKA_LEASE_FIVE_YEARS)        MIKEIKA_LEASE_FIVE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.ZANK_HOSYOGAKU_FIVE_YEARS)       ZANK_HOSYOGAKU_FIVE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.GNPN_FIVE_YEARS)                 GNPN_FIVE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.RSK_FIVE_YEARS)                  RSK_FIVE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.IJI_KANRIHI_FIVE_YEARS)          IJI_KANRIHI_FIVE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.EKM_TEIK_FIVE_YEARS)             EKM_TEIK_FIVE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.LAMT_STAX_FIVE_YEARS)            LAMT_STAX_FIVE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.MIKEIKA_LEASE_OVER_FIVE_YEARS)   MIKEIKA_LEASE_OVER_FIVE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.ZANK_HOSYOGAKU_OVER_FIVE_YEARS)  ZANK_HOSYOGAKU_OVER_FIVE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.GNPN_OVER_FIVE_YEARS)            GNPN_OVER_FIVE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.RSK_OVER_FIVE_YEARS)             RSK_OVER_FIVE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.IJI_KANRIHI_OVER_FIVE_YEARS)     IJI_KANRIHI_OVER_FIVE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.EKM_TEIK_OVER_FIVE_YEARS)        EKM_TEIK_OVER_FIVE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.LAMT_STAX_OVER_FIVE_YEARS)       LAMT_STAX_OVER_FIVE_YEARS  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.MIKEIKA_LEASE_TOTAL)             MIKEIKA_LEASE_TOTAL  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.ZANK_HOSYOGAKU_TOTAL)            ZANK_HOSYOGAKU_TOTAL  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.GNPN_TOTAL)                      GNPN_TOTAL  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.RSK_TOTAL)                       RSK_TOTAL  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.IJI_KANRIHI_TOTAL)               IJI_KANRIHI_TOTAL  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.EKM_TEIK_TOTAL)                  EKM_TEIK_TOTAL  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.LAMT_STAX_TOTAL)                 LAMT_STAX_TOTAL  " + "\n");
			   super.sql.append("--有形資産 " + "\n");
			   super.sql.append("        ,'-'                                        FIRST_Y_KNU_AMT  " + "\n");
			   super.sql.append("        ,'-'                                        FIRST_Y_GNK_RUI_AMT  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.FIRST_GNK_SKK_AMT_Y)             FIRST_Y_GNK_SKK_AMT " + "\n");
			   super.sql.append("        ,SUM(GOKEI.FIRST_BOKA_AMT_Y)                FIRST_Y_BOKA_AMT " + "\n");
			   super.sql.append("        ,'-'                                        SECOND_Y_KNU_AMT   " + "\n");
			   super.sql.append("        ,'-'                                        SECOND_Y_GNK_RUI_AMT   " + "\n");
			   super.sql.append("        ,SUM(GOKEI.SECOND_GNK_SKK_AMT_Y)            SECOND_Y_GNK_SKK_AMT " + "\n");
			   super.sql.append("        ,SUM(GOKEI.SECOND_BOKA_AMT_Y)               SECOND_Y_BOKA_AMT " + "\n");
			   super.sql.append("        ,'-'                                        THIRD_Y_KNU_AMT  " + "\n");
			   super.sql.append("        ,'-'                                        THIRD_Y_GNK_RUI_AMT  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.THIRD_GNK_SKK_AMT_Y)             THIRD_Y_GNK_SKK_AMT " + "\n");
			   super.sql.append("        ,SUM(GOKEI.THIRD_BOKA_AMT_Y)                THIRD_Y_BOKA_AMT " + "\n");
			   super.sql.append("        ,'-'                                        FOURTH_Y_KNU_AMT  " + "\n");
			   super.sql.append("        ,'-'                                        FOURTH_Y_GNK_RUI_AMT  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.FOURTH_GNK_SKK_AMT_Y)            FOURTH_Y_GNK_SKK_AMT " + "\n");
			   super.sql.append("        ,SUM(GOKEI.FOURTH_BOKA_AMT_Y)               FOURTH_Y_BOKA_AMT " + "\n");
			   super.sql.append("        ,'-'                                        FIFTH_Y_KNU_AMT  " + "\n");
			   super.sql.append("        ,'-'                                        FIFTH_Y_GNK_RUI_AMT  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.FIFTH_GNK_SKK_AMT_Y)             FIFTH_Y_GNK_SKK_AMT " + "\n");
			   super.sql.append("        ,SUM(GOKEI.FIFTH_BOKA_AMT_Y)                FIFTH_Y_BOKA_AMT " + "\n");
			   super.sql.append("        ,'-'                                        OVER_FIFTH_Y_KNU_AMT  " + "\n");
			   super.sql.append("        ,'-'                                        OVER_FIFTH_Y_GNK_RUI_AMT  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.OVER_FIFTH_GNK_SKK_AMT_Y)        OVER_FIFTH_Y_GNK_SKK_AMT " + "\n");
			   super.sql.append("        ,SUM(GOKEI.OVER_FIFTH_BOKA_AMT_Y)           OVER_FIFTH_Y_BOKA_AMT " + "\n");
			   super.sql.append("        ,SUM(GOKEI.TOTAL_KNU_AMT_Y)                 TOTAL_Y_KNU_AMT " + "\n");
			   super.sql.append("        ,SUM(GOKEI.TOTAL_GNK_RUI_AMT_Y)             TOTAL_Y_GNK_RUI_AMT " + "\n");
			   super.sql.append("        ,'-'                                        TOTAL_Y_GNK_SKK_AMT  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.TOTAL_BOKA_AMT_Y)                TOTAL_Y_BOKA_AMT " + "\n");
			   super.sql.append("--無形資産 " + "\n");
			   super.sql.append("        ,'-'                                        FIRST_M_KNU_AMT  " + "\n");
			   super.sql.append("        ,'-'                                        FIRST_M_GNK_RUI_AMT  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.FIRST_GNK_SKK_AMT_N)             FIRST_M_GNK_SKK_AMT " + "\n");
			   super.sql.append("        ,SUM(GOKEI.FIRST_BOKA_AMT_N)                FIRST_M_BOKA_AMT " + "\n");
			   super.sql.append("        ,'-'                                        SECOND_M_KNU_AMT  " + "\n");
			   super.sql.append("        ,'-'                                        SECOND_M_GNK_RUI_AMT  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.SECOND_GNK_SKK_AMT_N)            SECOND_M_GNK_SKK_AMT " + "\n");
			   super.sql.append("        ,SUM(GOKEI.SECOND_BOKA_AMT_N)               SECOND_M_BOKA_AMT " + "\n");
			   super.sql.append("        ,'-'                                        THIRD_M_KNU_AMT  " + "\n");
			   super.sql.append("        ,'-'                                        THIRD_M_GNK_RUI_AMT  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.THIRD_GNK_SKK_AMT_N)             THIRD_M_GNK_SKK_AMT " + "\n");
			   super.sql.append("        ,SUM(GOKEI.THIRD_BOKA_AMT_N)                THIRD_M_BOKA_AMT " + "\n");
			   super.sql.append("        ,'-'                                        FOURTH_M_KNU_AMT  " + "\n");
			   super.sql.append("        ,'-'                                        FOURTH_M_GNK_RUI_AMT  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.FOURTH_GNK_SKK_AMT_N)            FOURTH_M_GNK_SKK_AMT " + "\n");
			   super.sql.append("        ,SUM(GOKEI.FOURTH_BOKA_AMT_N)               FOURTH_M_BOKA_AMT " + "\n");
			   super.sql.append("        ,'-'                                        FIFTH_M_KNU_AMT  " + "\n");
			   super.sql.append("        ,'-'                                        FIFTH_M_GNK_RUI_AMT  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.FIFTH_GNK_SKK_AMT_N)             FIFTH_M_GNK_SKK_AMT " + "\n");
			   super.sql.append("        ,SUM(GOKEI.FIFTH_BOKA_AMT_N)                FIFTH_M_BOKA_AMT " + "\n");
			   super.sql.append("        ,'-'                                        OVER_FIFTH_M_KNU_AMT  " + "\n");
			   super.sql.append("        ,'-'                                        OVER_FIFTH_M_GNK_RUI_AMT  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.OVER_FIFTH_GNK_SKK_AMT_N)        OVER_FIFTH_M_GNK_SKK_AMT " + "\n");
			   super.sql.append("        ,SUM(GOKEI.OVER_FIFTH_BOKA_AMT_N)           OVER_FIFTH_M_BOKA_AMT " + "\n");
			   super.sql.append("        ,SUM(GOKEI.TOTAL_KNU_AMT_N)                 TOTAL_M_KNU_AMT " + "\n");
			   super.sql.append("        ,SUM(GOKEI.TOTAL_GNK_RUI_AMT_N)             TOTAL_M_GNK_RUI_AMT " + "\n");
			   super.sql.append("        ,'-'                                        TOTAL_M_GNK_SKK_AMT  " + "\n");
			   super.sql.append("        ,SUM(GOKEI.TOTAL_BOKA_AMT_N)                TOTAL_M_BOKA_AMT " + "\n");
			   super.sql.append(" " + "\n");
			   super.sql.append("FROM ( " + "\n");
			   super.sql.append("    --債務合計取得 " + "\n");
			   super.sql.append("    SELECT " + "\n");
			   super.sql.append("             SAIM.LEASE_COMPANY " + "\n");
			   super.sql.append("            ,SAIM.LU_NM " + "\n");
			   super.sql.append("            ,SAIM.JYSI_UM_CD " + "\n");
			   super.sql.append("            ,SAIM.JYSI_UM JYSI_UM_NM " + "\n");
			   super.sql.append("            ,SAIM.LEASE_BUNRUI_CD " + "\n");
			   super.sql.append("            ,SAIM.LEASE_BUNRUI  " + "\n");
			   super.sql.append("            ,SAIM.AC_SHR_KBN  " + "\n");
			   super.sql.append("            ,SAIM.AC_SHR_NM  " + "\n");
			   super.sql.append("    --債務 " + "\n");
			   super.sql.append("            ,SUM(MIKEIKA_LEASE_ONE_YEAR)            MIKEIKA_LEASE_ONE_YEAR " + "\n");
			   super.sql.append("            ,SUM(ZANK_HOSYOGAKU_ONE_YEAR)           ZANK_HOSYOGAKU_ONE_YEAR " + "\n");
			   super.sql.append("            ,SUM(GNPN_ONE_YEAR)                     GNPN_ONE_YEAR  " + "\n");
			   super.sql.append("            ,SUM(RSK_ONE_YEAR)                      RSK_ONE_YEAR  " + "\n");
			   super.sql.append("            ,SUM(IJI_KANRIHI_ONE_YEAR)              IJI_KANRIHI_ONE_YEAR  " + "\n");
			   super.sql.append("            ,SUM(EKM_TEIK_ONE_YEAR)                 EKM_TEIK_ONE_YEAR  " + "\n");
			   super.sql.append("            ,SUM(LAMT_STAX_ONE_YEAR)                LAMT_STAX_ONE_YEAR  " + "\n");
			   super.sql.append("            ,SUM(MIKEIKA_LEASE_TWO_YEARS)           MIKEIKA_LEASE_TWO_YEARS  " + "\n");
			   super.sql.append("            ,SUM(ZANK_HOSYOGAKU_TWO_YEARS)          ZANK_HOSYOGAKU_TWO_YEARS  " + "\n");
			   super.sql.append("            ,SUM(GNPN_TWO_YEARS)                    GNPN_TWO_YEARS  " + "\n");
			   super.sql.append("            ,SUM(RSK_TWO_YEARS)                     RSK_TWO_YEARS  " + "\n");
			   super.sql.append("            ,SUM(IJI_KANRIHI_TWO_YEARS)             IJI_KANRIHI_TWO_YEARS  " + "\n");
			   super.sql.append("            ,SUM(EKM_TEIK_TWO_YEARS)                EKM_TEIK_TWO_YEARS  " + "\n");
			   super.sql.append("            ,SUM(LAMT_STAX_TWO_YEARS)               LAMT_STAX_TWO_YEARS  " + "\n");
			   super.sql.append("            ,SUM(MIKEIKA_LEASE_THREE_YEARS)         MIKEIKA_LEASE_THREE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(ZANK_HOSYOGAKU_THREE_YEARS)        ZANK_HOSYOGAKU_THREE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(GNPN_THREE_YEARS)                  GNPN_THREE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(RSK_THREE_YEARS)                   RSK_THREE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(IJI_KANRIHI_THREE_YEARS)           IJI_KANRIHI_THREE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(EKM_TEIK_THREE_YEARS)              EKM_TEIK_THREE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(LAMT_STAX_THREE_YEARS)             LAMT_STAX_THREE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(MIKEIKA_LEASE_FOUR_YEARS)          MIKEIKA_LEASE_FOUR_YEARS  " + "\n");
			   super.sql.append("            ,SUM(ZANK_HOSYOGAKU_FOUR_YEARS)         ZANK_HOSYOGAKU_FOUR_YEARS  " + "\n");
			   super.sql.append("            ,SUM(GNPN_FOUR_YEARS)                   GNPN_FOUR_YEARS  " + "\n");
			   super.sql.append("            ,SUM(RSK_FOUR_YEARS)                    RSK_FOUR_YEARS  " + "\n");
			   super.sql.append("            ,SUM(IJI_KANRIHI_FOUR_YEARS)            IJI_KANRIHI_FOUR_YEARS  " + "\n");
			   super.sql.append("            ,SUM(EKM_TEIK_FOUR_YEARS)               EKM_TEIK_FOUR_YEARS  " + "\n");
			   super.sql.append("            ,SUM(LAMT_STAX_FOUR_YEARS)              LAMT_STAX_FOUR_YEARS  " + "\n");
			   super.sql.append("            ,SUM(MIKEIKA_LEASE_FIVE_YEARS)          MIKEIKA_LEASE_FIVE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(ZANK_HOSYOGAKU_FIVE_YEARS)         ZANK_HOSYOGAKU_FIVE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(GNPN_FIVE_YEARS)                   GNPN_FIVE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(RSK_FIVE_YEARS)                    RSK_FIVE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(IJI_KANRIHI_FIVE_YEARS)            IJI_KANRIHI_FIVE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(EKM_TEIK_FIVE_YEARS)               EKM_TEIK_FIVE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(LAMT_STAX_FIVE_YEARS)              LAMT_STAX_FIVE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(MIKEIKA_LEASE_OVER_FIVE_YEARS)     MIKEIKA_LEASE_OVER_FIVE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(ZANK_HOSYOGAKU_OVER_FIVE_YEARS)    ZANK_HOSYOGAKU_OVER_FIVE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(GNPN_OVER_FIVE_YEARS)              GNPN_OVER_FIVE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(RSK_OVER_FIVE_YEARS)               RSK_OVER_FIVE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(IJI_KANRIHI_OVER_FIVE_YEARS)       IJI_KANRIHI_OVER_FIVE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(EKM_TEIK_OVER_FIVE_YEARS)          EKM_TEIK_OVER_FIVE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(LAMT_STAX_OVER_FIVE_YEARS)         LAMT_STAX_OVER_FIVE_YEARS  " + "\n");
			   super.sql.append("            ,SUM(MIKEIKA_LEASE_TOTAL)               MIKEIKA_LEASE_TOTAL  " + "\n");
			   super.sql.append("            ,SUM(ZANK_HOSYOGAKU_TOTAL)              ZANK_HOSYOGAKU_TOTAL  " + "\n");
			   super.sql.append("            ,SUM(GNPN_TOTAL)                        GNPN_TOTAL  " + "\n");
			   super.sql.append("            ,SUM(RSK_TOTAL)                         RSK_TOTAL  " + "\n");
			   super.sql.append("            ,SUM(IJI_KANRIHI_TOTAL)                 IJI_KANRIHI_TOTAL  " + "\n");
			   super.sql.append("            ,SUM(EKM_TEIK_TOTAL)                    EKM_TEIK_TOTAL  " + "\n");
			   super.sql.append("            ,SUM(LAMT_STAX_TOTAL)                   LAMT_STAX_TOTAL  " + "\n");
			   super.sql.append("    --有形資産 " + "\n");
			   super.sql.append("            ,'-'                                    FIRST_KNU_AMT_Y  " + "\n");
			   super.sql.append("            ,'-'                                    FIRST_GNK_RUI_AMT_Y  " + "\n");
			   super.sql.append("            ,0                                      FIRST_GNK_SKK_AMT_Y " + "\n");
			   super.sql.append("            ,0                                      FIRST_BOKA_AMT_Y " + "\n");
			   super.sql.append("            ,'-'                                    SECOND_KNU_AMT_Y  " + "\n");
			   super.sql.append("            ,'-'                                    SECOND_GNK_RUI_AMT_Y  " + "\n");
			   super.sql.append("            ,0                                      SECOND_GNK_SKK_AMT_Y " + "\n");
			   super.sql.append("            ,0                                      SECOND_BOKA_AMT_Y " + "\n");
			   super.sql.append("            ,'-'                                    THIRD_KNU_AMT_Y  " + "\n");
			   super.sql.append("            ,'-'                                    THIRD_GNK_RUI_AMT_Y  " + "\n");
			   super.sql.append("            ,0                                      THIRD_GNK_SKK_AMT_Y " + "\n");
			   super.sql.append("            ,0                                      THIRD_BOKA_AMT_Y " + "\n");
			   super.sql.append("            ,'-'                                    FOURTH_KNU_AMT_Y  " + "\n");
			   super.sql.append("            ,'-'                                    FOURTH_GNK_RUI_AMT_Y  " + "\n");
			   super.sql.append("            ,0                                      FOURTH_GNK_SKK_AMT_Y " + "\n");
			   super.sql.append("            ,0                                      FOURTH_BOKA_AMT_Y " + "\n");
			   super.sql.append("            ,'-'                                    FIFTH_KNU_AMT_Y  " + "\n");
			   super.sql.append("            ,'-'                                    FIFTH_GNK_RUI_AMT_Y  " + "\n");
			   super.sql.append("            ,0                                      FIFTH_GNK_SKK_AMT_Y " + "\n");
			   super.sql.append("            ,0                                      FIFTH_BOKA_AMT_Y " + "\n");
			   super.sql.append("            ,'-'                                    OVER_FIFTH_KNU_AMT_Y  " + "\n");
			   super.sql.append("            ,'-'                                    OVER_FIFTH_GNK_RUI_AMT_Y  " + "\n");
			   super.sql.append("            ,0                                      OVER_FIFTH_GNK_SKK_AMT_Y " + "\n");
			   super.sql.append("            ,0                                      OVER_FIFTH_BOKA_AMT_Y " + "\n");
			   super.sql.append("            ,0                                      TOTAL_KNU_AMT_Y " + "\n");
			   super.sql.append("            ,0                                      TOTAL_GNK_RUI_AMT_Y " + "\n");
			   super.sql.append("            ,'-'                                    TOTAL_GNK_SKK_AMT_Y  " + "\n");
			   super.sql.append("            ,0                                      TOTAL_BOKA_AMT_Y " + "\n");
			   super.sql.append("    --無形資産 " + "\n");
			   super.sql.append("            ,'-'                                    FIRST_KNU_AMT_N  " + "\n");
			   super.sql.append("            ,'-'                                    FIRST_GNK_RUI_AMT_N  " + "\n");
			   super.sql.append("            ,0                                      FIRST_GNK_SKK_AMT_N " + "\n");
			   super.sql.append("            ,0                                      FIRST_BOKA_AMT_N " + "\n");
			   super.sql.append("            ,'-'                                    SECOND_KNU_AMT_N  " + "\n");
			   super.sql.append("            ,'-'                                    SECOND_GNK_RUI_AMT_N  " + "\n");
			   super.sql.append("            ,0                                      SECOND_GNK_SKK_AMT_N " + "\n");
			   super.sql.append("            ,0                                      SECOND_BOKA_AMT_N " + "\n");
			   super.sql.append("            ,'-'                                    THIRD_KNU_AMT_N  " + "\n");
			   super.sql.append("            ,'-'                                    THIRD_GNK_RUI_AMT_N  " + "\n");
			   super.sql.append("            ,0                                      THIRD_GNK_SKK_AMT_N " + "\n");
			   super.sql.append("            ,0                                      THIRD_BOKA_AMT_N " + "\n");
			   super.sql.append("            ,'-'                                    FOURTH_KNU_AMT_N  " + "\n");
			   super.sql.append("            ,'-'                                    FOURTH_GNK_RUI_AMT_N  " + "\n");
			   super.sql.append("            ,0                                      FOURTH_GNK_SKK_AMT_N " + "\n");
			   super.sql.append("            ,0                                      FOURTH_BOKA_AMT_N " + "\n");
			   super.sql.append("            ,'-'                                    FIFTH_KNU_AMT_N  " + "\n");
			   super.sql.append("            ,'-'                                    FIFTH_GNK_RUI_AMT_N  " + "\n");
			   super.sql.append("            ,0                                      FIFTH_GNK_SKK_AMT_N " + "\n");
			   super.sql.append("            ,0                                      FIFTH_BOKA_AMT_N " + "\n");
			   super.sql.append("            ,'-'                                    OVER_FIFTH_KNU_AMT_N  " + "\n");
			   super.sql.append("            ,'-'                                    OVER_FIFTH_GNK_RUI_AMT_N  " + "\n");
			   super.sql.append("            ,0                                      OVER_FIFTH_GNK_SKK_AMT_N " + "\n");
			   super.sql.append("            ,0                                      OVER_FIFTH_BOKA_AMT_N " + "\n");
			   super.sql.append("            ,0                                      TOTAL_KNU_AMT_N " + "\n");
			   super.sql.append("            ,0                                      TOTAL_GNK_RUI_AMT_N " + "\n");
			   super.sql.append("            ,'-'                                    TOTAL_GNK_SKK_AMT_N  " + "\n");
			   super.sql.append("            ,0                                      TOTAL_BOKA_AMT_N " + "\n");
			   super.sql.append(" " + "\n");
			   super.sql.append("    FROM (                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   " + "\n");
			   //      -- 期日別予定表(債務SQL) Start
				super.sql.append("SELECT  DECODE(LU.PDF_COMPANY_NM, NULL, M_LC.LC_NM, LU.PDF_COMPANY_NM) LEASE_COMPANY " + "\n"); // リース会社		
				super.sql.append("        ,TO_CHAR(SYSDATE, 'YYYYMMDD') CREATE_DATE " + "\n"); // 作成日
				super.sql.append("        ,LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ") END_YMD " + "\n"); // 基準日				
				super.sql.append("        ,LU.LU_NM LU_NM " +  "\n"); // 開示先
				super.sql.append("        ,CASE WHEN KEI.JYSI_UM = 1 THEN 'あり' ELSE 'なし' END JYSI_UM " + "\n"); // 重要性有無
				super.sql.append("        ,KEI.JYSI_UM JYSI_UM_CD" + "\n"); // 重要性有無コード
				super.sql.append("        ,TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN LEASE_BUNRUI_CD  " + "\n"); // リース取引分類コード		
				super.sql.append("        ,AC.AC_SHR_KBN AC_SHR_KBN" + "\n"); // 会計処理方法コード
				super.sql.append("        ,AC.AC_SHR_NM AC_SHR_NM" + "\n"); // 会計処理方法コード
				super.sql.append("        ,RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN" + "\n"); // 利息相当額配分方法コード
				super.sql.append("        ,FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_CD FKN_TNKI_HOHO_CD " + "\n"); // 当期支払リース料計算基準コード 
				super.sql.append("        ,BKN.BKN_NO BKN_NO" + "\n");	
				super.sql.append("        ,DECODE(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, '3', '解約不能') || TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_NM LEASE_BUNRUI " + "\n"); // リース取引分類
				super.sql.append("        ,AC.AC_SHR_NM AC_SHR_KBN_NM" + "\n"); // 会計処理方法
				super.sql.append("        ,RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN_NM " + "\n"); //利息相当額配分方法
				super.sql.append("        ,FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_NM " + "\n"); // 当期支払リース料計算基準
				super.sql.append("        ,KEI.HYJYO_KEI_NO KEI_NO " + "\n"); // 契約番号
				super.sql.append("        ,BKN.BKN_NO || " + "\n");		
				super.sql.append("         CASE WHEN TRIM(BKN.BKN_EDANO) IS NULL THEN '' ELSE '-' || BKN.BKN_EDANO END " + "\n"); // 物件番号
				super.sql.append("        ,BKN.BKN_NM BKN_NM " + "\n"); // 物件名
				super.sql.append("        ,TO_CHAR(TO_DATE(KEI.KNSHU_YMD), 'YYYY/MM/DD') KNSHU_YMD " + "\n"); // リース開始日
				super.sql.append("        ,TO_CHAR(TO_DATE(KEI.MRYO_YMD), 'YYYY/MM/DD') MRYO_YMD " + "\n"); // リース終了日
				super.sql.append("        ,TO_CHAR(TO_DATE(KEI.KAI_YMD), 'YYYY/MM/DD') KAI_YMD " + "\n"); // 中途解約日
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) MIKEIKA_LEASE_ONE_YEAR " + "\n"); // 未経過リース料(1年以内)
				super.sql.append("        ,MAX(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) ZANK_HOSYOGAKU_ONE_YEAR " + "\n"); // 残価保証額(1年以内)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) GNPN_ONE_YEAR " + "\n"); // 元本(1年以内)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) RSK_ONE_YEAR " + "\n"); // 利息(1年以内)
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.OTH_CST " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) IJI_KANRIHI_ONE_YEAR " + "\n"); // 維持管理費(1年以内)
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) EKM_TEIK_ONE_YEAR " + "\n"); // 役務提供費(1年以内)	
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT_STAX " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) LAMT_STAX_ONE_YEAR " + "\n"); //  消費税等(1年以内)			
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) MIKEIKA_LEASE_TWO_YEARS " + "\n"); // 未経過リース料(2年以内)
				super.sql.append("        ,MAX(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) ZANK_HOSYOGAKU_TWO_YEARS " + "\n"); // 残価保証額(2年以内)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) GNPN_TWO_YEARS " + "\n"); // 元本(2年以内)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) RSK_TWO_YEARS " + "\n"); // 利息(2年以内)
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.OTH_CST " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) IJI_KANRIHI_TWO_YEARS " + "\n"); // 維持管理費(2年以内)
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) EKM_TEIK_TWO_YEARS " + "\n"); // 役務提供費(2年以内)	
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT_STAX " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) LAMT_STAX_TWO_YEARS " + "\n"); //  消費税等(2年以内)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) MIKEIKA_LEASE_THREE_YEARS " + "\n"); // 未経過リース料(3年以内)
				super.sql.append("        ,MAX(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) ZANK_HOSYOGAKU_THREE_YEARS " + "\n"); // 残価保証額(3年以内)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) GNPN_THREE_YEARS " + "\n"); // 元本(3年以内)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) RSK_THREE_YEARS " + "\n"); // 利息(3年以内)
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.OTH_CST " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) IJI_KANRIHI_THREE_YEARS " + "\n"); // 維持管理費(3年以内)
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) EKM_TEIK_THREE_YEARS " + "\n"); // 役務提供費(3年以内)	
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT_STAX " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) LAMT_STAX_THREE_YEARS " + "\n"); //  消費税等(3年以内)
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) MIKEIKA_LEASE_FOUR_YEARS " + "\n"); // 未経過リース料(4年以内)
				super.sql.append("        ,MAX(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) ZANK_HOSYOGAKU_FOUR_YEARS " + "\n"); // 残価保証額(4年以内)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) GNPN_FOUR_YEARS " + "\n"); // 元本(4年以内)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
				super.sql.append("             ELSE " + "\n");
				
				
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) RSK_FOUR_YEARS " + "\n"); // 利息(4年以内)
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.OTH_CST " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) IJI_KANRIHI_FOUR_YEARS " + "\n"); // 維持管理費(4年以内)
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) EKM_TEIK_FOUR_YEARS " + "\n"); // 役務提供費(4年以内)	
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT_STAX " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) LAMT_STAX_FOUR_YEARS " + "\n"); //  消費税等(4年以内)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) MIKEIKA_LEASE_FIVE_YEARS " + "\n"); // 未経過リース料(5年以内)
				super.sql.append("        ,MAX(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) ZANK_HOSYOGAKU_FIVE_YEARS " + "\n"); // 残価保証額(5年以内)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) GNPN_FIVE_YEARS " + "\n"); // 元本(5年以内)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) RSK_FIVE_YEARS " + "\n"); // 利息(5年以内)
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.OTH_CST " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) IJI_KANRIHI_FIVE_YEARS " + "\n"); // 維持管理費(5年以内)
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) EKM_TEIK_FIVE_YEARS " + "\n"); // 役務提供費(5年以内)	
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT_STAX " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) LAMT_STAX_FIVE_YEARS " + "\n"); //  消費税等(5年以内)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");		
				super.sql.append("                 TNKI.LAMT " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) MIKEIKA_LEASE_OVER_FIVE_YEARS " + "\n"); // 未経過リース料(5年超)
				super.sql.append("        ,MAX(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");
				super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) ZANK_HOSYOGAKU_OVER_FIVE_YEARS " + "\n"); // 残価保証額(5年超)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) GNPN_OVER_FIVE_YEARS " + "\n"); // 元本(5年超)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) RSK_OVER_FIVE_YEARS " + "\n"); // 利息(5年超)
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");
				super.sql.append("                 TNKI.OTH_CST " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) IJI_KANRIHI_OVER_FIVE_YEARS " + "\n"); // 維持管理費(5年超)
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");
				super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) EKM_TEIK_OVER_FIVE_YEARS " + "\n"); // 役務提供費(5年超)	
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");
				super.sql.append("                 TNKI.LAMT_STAX " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) LAMT_STAX_OVER_FIVE_YEARS " + "\n"); //  消費税等(5年超)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n"); 
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n"); 
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END " + "\n"); 
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n"); 
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n");
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM THEN " + "\n");		
				super.sql.append("                 TNKI.LAMT " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) MIKEIKA_LEASE_TOTAL " + "\n"); // 未経過リース料(合計)
				super.sql.append("        ,MAX(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END) " + "\n"); 
				super.sql.append("        + MAX(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END )  " + "\n"); 
				super.sql.append("        + MAX(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END )  " + "\n");
				super.sql.append("        + MAX(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END )  " + "\n");
				super.sql.append("        + MAX(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")), 60), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END )  " + "\n");
				super.sql.append("        + MAX(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <=  TNKI.KEIJ_YM THEN " + "\n");
				super.sql.append("                 TNKI.SOU_USER_ZANK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) ZANK_HOSYOGAKU_TOTAL " + "\n"); // 残価保証額(合計)
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END   " + "\n"); 		
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END   " + "\n"); 				
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END   " + "\n");
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n");
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n");
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_GNPN " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) GNPN_TOTAL " + "\n"); 
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n"); 
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n");
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n");
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n");
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI_DETAIL.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n");
				super.sql.append("       + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI_DETAIL.KEIJ_YM THEN " + "\n");
				super.sql.append("                 TNKI_DETAIL.TGTU_RSK " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) RSK_TOTAL " + "\n"); // 利息(合計)		
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.OTH_CST " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n"); 		
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.OTH_CST " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n"); 
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.OTH_CST " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n");
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.OTH_CST " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n");
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.OTH_CST " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n");
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");
				super.sql.append("                 TNKI.OTH_CST " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) IJI_KANRIHI_TOTAL " + "\n"); // 維持管理費(合計)
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n"); 
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n"); 
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n"); 
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n"); 		
				super.sql.append("        + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");
				super.sql.append("                 TNKI.IPN_EKM_TEIK_HYO + TNKI.SHRY_EKM_TEIK_HYO " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) EKM_TEIK_TOTAL " + "\n"); // 役務提供費(合計)
				super.sql.append("        ,SUM(CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),12), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT_STAX " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n"); 
				super.sql.append("       + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,12), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),24), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT_STAX " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n"); 
				super.sql.append("       + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,24), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),36), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT_STAX " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n");
				super.sql.append("       + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,36), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),48), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT_STAX " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n");
				super.sql.append("       + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,48), 'YYYYMM') <= TNKI.KEIJ_YM " + "\n");
				super.sql.append("             AND TNKI.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")),60), 'YYYYMM') THEN " + "\n");
				super.sql.append("                 TNKI.LAMT_STAX " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END  " + "\n");	
				super.sql.append("       + CASE " + "\n"); 
				super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1,60), 'YYYYMM') <= TNKI.KEIJ_YM THEN " + "\n");
				super.sql.append("                 TNKI.LAMT_STAX " + "\n");
				super.sql.append("             ELSE " + "\n");
				super.sql.append("                 0 " + "\n");
				super.sql.append("             END ) LAMT_STAX_TOTAL " + "\n"); // 消費税等(合計)		
				//super.sql.append("FROM   (" + super.getCoreSQL() + ") KB " + "\n");				
				super.sql.append("FROM   T_KEI KEI " + "\n");
				super.sql.append("LEFT   JOIN (SELECT BKN.LC_CD, BKN.KEI_NO, BKN.BKN_NO, BKN.BKN_EDANO, BKN.BKN_NM, " + super.getRisokuKeijoHohoKbn("BKN") + " AS RSK_KEIJ_HOHO_KBN FROM T_BKN BKN) BKN ON BKN.LC_CD = KEI.LC_CD AND BKN.KEI_NO = KEI.KEI_NO " + "\n");		
				super.sql.append("LEFT   JOIN M_LC ON KEI.LC_CD = M_LC.LC_CD " + "\n");
				super.sql.append("LEFT   JOIN M_LU LU ON LU.LU_COSMOS_CD = KEI.LU_COSMOS_CD " + "\n");
				super.sql.append("LEFT   JOIN M_RSK_KEIJ_HOHO_KBN RSK_KEIJ_HOHO_KBN ON RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN = BKN.RSK_KEIJ_HOHO_KBN " + "\n");
				super.sql.append("LEFT   JOIN M_FKN_TNKI_HOHO_CD FKN_TNKI_HOHO_CD ON FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_CD = KEI.TNKI_HOHO_KBN " + "\n");
				super.sql.append("LEFT   JOIN M_TRD_HNTE_KEKA_KBN TRD_HNTE_KEKA_KBN ON TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN = KEI.TRD_HNTE_KEKA_KBN " + "\n");
			    super.sql.append("LEFT   JOIN M_AC_SHR_KBN AC ON  AC.CTSHK_FLG = KEI.CTSHK_FLG AND AC.AC_SHR_KBN = " + super.kaikeiSyori + " \n");	
			    super.sql.append("LEFT   JOIN T_UKB_TNKI_HEAD TNKI  ON TNKI.LC_CD = KEI.LC_CD AND TNKI.KEI_NO = KEI.KEI_NO AND TNKI.BKN_NO = BKN.BKN_NO AND TNKI.BKN_EDANO = BKN.BKN_EDANO " + "\n");
			    super.sql.append("LEFT   JOIN T_UKB_TNKI_DETAIL TNKI_DETAIL ON TNKI_DETAIL.LC_CD = TNKI.LC_CD AND TNKI_DETAIL.KEI_NO = KEI.KEI_NO AND TNKI_DETAIL.BKN_NO = BKN.BKN_NO AND TNKI_DETAIL.BKN_EDANO = BKN.BKN_EDANO AND TNKI.KEIJ_YM = TNKI_DETAIL.KEIJ_YM " + "\n");	    	  
			    super.sql.append("            AND BKN.RSK_KEIJ_HOHO_KBN = TNKI_DETAIL.KEIJ_HOHO_KBN AND TNKI.KEIJ_YM = TNKI_DETAIL.KEIJ_YM " + "\n");
			    //super.sql.append("LEFT   JOIN T_UKB_GNKSK GNKSK ON GNKSK.LC_CD = KEI.LC_CD AND GNKSK.KEI_NO = KEI.KEI_NO AND GNKSK.BKN_NO = BKN.BKN_NO AND GNKSK.BKN_EDANO = BKN.BKN_EDANO " + "\n");	    	  
			    //super.sql.append("            AND GNKSK.KEIJ_HOHO_KBN = BKN.SKK_KEIJ_HOHO_KBN " + "\n");
			    super.sql.append("WHERE  KEI.TRD_HNTE_KEKA_KBN IN ('1', '2', '3')" + "\n");
				super.sql.append("AND    KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "' " + "\n"); // リースユーザ
				super.sql.append("AND    KEI.TAISHO_AC_KIJYUN_CD ='" + super.acStd + "'" + "\n");	
				super.sql.append("AND    AC.AC_SHR_KBN = " + super.kaikeiSyori + "\n");
			   	super.sql.append("AND    NVL(SUBSTR(KEI.KAI_YMD, 1, 6), '999999') > LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ") " +  "\n");
				
			    // 20210525 arai 対象期間内に受払データが存在するデータのみ取得 start
				super.sql.append("AND  TNKI.KEIJ_YM >= TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') " +  "\n");
			    // 20210525 arai 対象期間内に受払データが存在するデータのみ取得 end
 				
				// 20210524 arai 解約可能リース可能対応 start
				if (commonBean.isShowKaiKnoOpt()) {
					if (super.kaiknoTermkei.equals("0")) {
						super.sql.append("AND    TNKI.KAI_FNO_FLG = '1' " + "\n");
					}
				}
				// 20210524 arai 解約可能リース対応 end
				
				// 20210528 arai 会計処理方法による出力変更対応 start
				if (kaikeiSyori.equals(LACSDefine.KaikeiSyori.SYOUSAI_0)) {
				 	super.sql.append("AND    BKN.RSK_KEIJ_HOHO_KBN = " + getRisokuKeijoHohoKbn("BKN") + " " + "\n");
				} else {
					super.sql.append("AND    BKN.RSK_KEIJ_HOHO_KBN = '" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' " + "\n");
				}
				// 20210528 arai 会計処理方法による出力変更対応 end
				
				if (super.keiyakuNo.trim().length() > 0) {
					super.sql.append("AND    KEI.HYJYO_KEI_NO = '" + super.keiyakuNo + "' \n"); // 契約番号
				}

				if (this.bukkenNo.trim().length() > 0) {
					super.sql.append("AND    BKN.BKN_NO || CASE WHEN TRIM(BKN.BKN_EDANO) IS NULL THEN '' ELSE '-' || BKN.BKN_EDANO END = '" + this.bukkenNo + "' " + "\n"); // 物件番号
				}

				// 抽出条件-旧会計基準
				if (super.acStd.equals(LACSDefine.AccountStandard.OLD_0)) {
					if (super.oldkeiyakuGaku.equals("0")) {
						super.sql.append("  AND    ((KEI.SGK_SSN_KBN IS NULL AND KEI.KEI_AMT > 3000000) " + "\n"); // 契約金額３００万円以下(KEI_AMTは物件から取得しているためKEI.KEI_AMTを使用)
						super.sql.append("      OR   (KEI.SGK_SSN_KBN IS NOT NULL AND KEI.SGK_SSN_KBN = '0')) " + "\n");
					}

					if (super.oldleaseKikan.equals("0")) {
						super.sql.append("  AND KEI.KEI_TERM >= 12 " + "\n"); // リース期間１年未満
					}

					if (super.oldsaiLease.equals("0")) {
						super.sql.append("  AND KEI.RLS_TMS = 0" + "\n"); // 再リース契約
					}

					if (super.oldtyutoKaiyaku.equals("0")) {
						super.sql.append("  AND KEI.KAI_YMD IS NULL" + "\n"); // 中途解約物件
					}

					if ("1".equals(super.commonBean.getControlGokeiDsp())) {
						super.sql.append("  AND KEI.CTSHK_FLG = '1'" + "\n"); // 注記合計表表示制御
					}
				}
				// 抽出条件-新会計基準
				if (super.acStd.equals(LACSDefine.AccountStandard.NEW_1)) {
					if (super.newkeiyakuGaku.equals("0")) {
						super.sql.append("  AND    ((KEI.SGK_SSN_KBN IS NULL AND KEI.KEI_AMT > 3000000) " + "\n"); // 契約金額３００万円以下(KEI_AMTは物件から取得しているためKEI.KEI_AMTを使用)
						super.sql.append("      OR   (KEI.SGK_SSN_KBN IS NOT NULL AND KEI.SGK_SSN_KBN = '0')) " + "\n");
					}

					if (super.newleaseKikan.equals("0")) {
						super.sql.append("  AND KEI.KEI_TERM > 12 " + "\n"); // リース期間１年以内
					}

					if (super.newsaiLease.equals("0")) {
						super.sql.append("  AND KEI.RLS_TMS = 0" + "\n"); // 再リース契約
					}

					if (super.newtyutoKaiyaku.equals("0")) {
						super.sql.append("  AND KEI.KAI_YMD IS NULL" + "\n"); // 中途解約物件
					}
				}

				super.sql.append("GROUP  BY DECODE(LU.PDF_COMPANY_NM, NULL, M_LC.LC_NM, LU.PDF_COMPANY_NM) " + "\n");
				super.sql.append("         ,LU.LU_NM " + "\n");		
				super.sql.append("         ,CASE WHEN KEI.JYSI_UM = 1 THEN 'あり' ELSE 'なし' END " + "\n");
				super.sql.append("         ,DECODE(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, '3', '解約不能') || TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_NM " + "\n");
				super.sql.append("         ,AC.AC_SHR_NM " + "\n");
				super.sql.append("         ,FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_NM " + "\n");
				super.sql.append("         ,RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN_NM " + "\n");
				super.sql.append("         ,KEI.HYJYO_KEI_NO " + "\n");
				super.sql.append("         ,BKN.BKN_NO || " + "\n");	
				super.sql.append("          CASE WHEN TRIM(BKN.BKN_EDANO) IS NULL THEN '' ELSE '-' || BKN.BKN_EDANO END " + "\n");
				super.sql.append("         ,KNSHU_YMD " + "\n");
				super.sql.append("         ,MRYO_YMD " + "\n");
				super.sql.append("         ,KAI_YMD " + "\n");
				super.sql.append("         ,BKN.BKN_NM " + "\n");
				super.sql.append("         ,KEI.JYSI_UM " + "\n");
				super.sql.append("         ,TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN " + "\n");		                 
				super.sql.append("         ,AC.AC_SHR_KBN " + "\n");
				super.sql.append("         ,RSK_KEIJ_HOHO_KBN.RSK_KEIJ_HOHO_KBN " + "\n");
				super.sql.append("         ,FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_CD " + "\n");			
				super.sql.append("         ,BKN.BKN_NO " + "\n");		
//				super.sql.append("ORDER  BY JYSI_UM_CD" + "\n");
//				super.sql.append("         ,TRD_HNTE_KEKA_KBN  " + "\n");		
//				super.sql.append("         ,AC_SHR_KBN" + "\n");
//				super.sql.append("         ,RSK_KEIJ_HOHO_KBN" + "\n");
//				super.sql.append("         ,FKN_TNKI_HOHO_CD " + "\n");		
//				super.sql.append("         ,BKN_NO" + "\n");	
//				super.sql.append("         ,KEI.HYJYO_KEI_NO " + "\n");			
//      -- 期日別予定表(債務SQL) End
				   super.sql.append("    -- 債務 " + "\n");
				   super.sql.append("    ) SAIM " + "\n");
				   super.sql.append("    GROUP BY  " + "\n");
				   super.sql.append("             SAIM.LEASE_COMPANY " + "\n");
				   super.sql.append("            ,SAIM.LU_NM " + "\n");
				   super.sql.append("            ,SAIM.JYSI_UM_CD " + "\n");
				   super.sql.append("            ,SAIM.JYSI_UM " + "\n");
				   super.sql.append("            ,SAIM.LEASE_BUNRUI_CD " + "\n");
				   super.sql.append("            ,SAIM.LEASE_BUNRUI  " + "\n");
				   super.sql.append("            ,SAIM.AC_SHR_KBN  " + "\n");
				   super.sql.append("            ,SAIM.AC_SHR_NM  " + "\n");
				   super.sql.append(" " + "\n");
				   super.sql.append("    -- " + "\n");
				   super.sql.append("    UNION ALL " + "\n");
				   super.sql.append("    -- " + "\n");
				   super.sql.append("    --資産合計取得 " + "\n");
				   super.sql.append("    SELECT " + "\n");
				   super.sql.append("             SSN.LEASE_COMPANY " + "\n");
				   super.sql.append("            ,SSN.LU_NM " + "\n");
				   super.sql.append("            ,SSN.JYSI_UM_CD " + "\n");
				   super.sql.append("            ,SSN.JYSI_UM_NM " + "\n");
				   super.sql.append("            ,SSN.LEASE_BUNRUI_CD " + "\n");
				   super.sql.append("            ,SSN.LEASE_BUNRUI  " + "\n");
				   super.sql.append("            ,SSN.AC_SHR_KBN  " + "\n");
				   super.sql.append("            ,SSN.AC_SHR_NM  " + "\n");
				   super.sql.append("    --債務 " + "\n");
				   super.sql.append("            ,0                                      MIKEIKA_LEASE_ONE_YEAR " + "\n");
				   super.sql.append("            ,0                                      ZANK_HOSYOGAKU_ONE_YEAR " + "\n");
				   super.sql.append("            ,0                                      GNPN_ONE_YEAR  " + "\n");
				   super.sql.append("            ,0                                      RSK_ONE_YEAR  " + "\n");
				   super.sql.append("            ,0                                      IJI_KANRIHI_ONE_YEAR  " + "\n");
				   super.sql.append("            ,0                                      EKM_TEIK_ONE_YEAR  " + "\n");
				   super.sql.append("            ,0                                      LAMT_STAX_ONE_YEAR  " + "\n");
				   super.sql.append("            ,0                                      MIKEIKA_LEASE_TWO_YEARS  " + "\n");
				   super.sql.append("            ,0                                      ZANK_HOSYOGAKU_TWO_YEARS  " + "\n");
				   super.sql.append("            ,0                                      GNPN_TWO_YEARS  " + "\n");
				   super.sql.append("            ,0                                      RSK_TWO_YEARS  " + "\n");
				   super.sql.append("            ,0                                      IJI_KANRIHI_TWO_YEARS  " + "\n");
				   super.sql.append("            ,0                                      EKM_TEIK_TWO_YEARS  " + "\n");
				   super.sql.append("            ,0                                      LAMT_STAX_TWO_YEARS  " + "\n");
				   super.sql.append("            ,0                                      MIKEIKA_LEASE_THREE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      ZANK_HOSYOGAKU_THREE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      GNPN_THREE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      RSK_THREE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      IJI_KANRIHI_THREE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      EKM_TEIK_THREE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      LAMT_STAX_THREE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      MIKEIKA_LEASE_FOUR_YEARS  " + "\n");
				   super.sql.append("            ,0                                      ZANK_HOSYOGAKU_FOUR_YEARS  " + "\n");
				   super.sql.append("            ,0                                      GNPN_FOUR_YEARS  " + "\n");
				   super.sql.append("            ,0                                      RSK_FOUR_YEARS  " + "\n");
				   super.sql.append("            ,0                                      IJI_KANRIHI_FOUR_YEARS  " + "\n");
				   super.sql.append("            ,0                                      EKM_TEIK_FOUR_YEARS  " + "\n");
				   super.sql.append("            ,0                                      LAMT_STAX_FOUR_YEARS  " + "\n");
				   super.sql.append("            ,0                                      MIKEIKA_LEASE_FIVE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      ZANK_HOSYOGAKU_FIVE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      GNPN_FIVE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      RSK_FIVE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      IJI_KANRIHI_FIVE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      EKM_TEIK_FIVE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      LAMT_STAX_FIVE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      MIKEIKA_LEASE_OVER_FIVE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      ZANK_HOSYOGAKU_OVER_FIVE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      GNPN_OVER_FIVE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      RSK_OVER_FIVE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      IJI_KANRIHI_OVER_FIVE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      EKM_TEIK_OVER_FIVE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      LAMT_STAX_OVER_FIVE_YEARS  " + "\n");
				   super.sql.append("            ,0                                      MIKEIKA_LEASE_TOTAL  " + "\n");
				   super.sql.append("            ,0                                      ZANK_HOSYOGAKU_TOTAL  " + "\n");
				   super.sql.append("            ,0                                      GNPN_TOTAL  " + "\n");
				   super.sql.append("            ,0                                      RSK_TOTAL  " + "\n");
				   super.sql.append("            ,0                                      IJI_KANRIHI_TOTAL  " + "\n");
				   super.sql.append("            ,0                                      EKM_TEIK_TOTAL  " + "\n");
				   super.sql.append("            ,0                                      LAMT_STAX_TOTAL  " + "\n");
				   super.sql.append("    --有形資産 " + "\n");
				   super.sql.append("            ,'-'                                                                              FIRST_Y_KNU_AMT  " + "\n");
				   super.sql.append("            ,'-'                                                                              FIRST_Y_GNK_RUI_AMT  " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN SSN.FIRST_GNK_SKK_AMT ELSE 0 END )  FIRST_Y_GNK_SKK_AMT " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN SSN.FIRST_BOKA_AMT ELSE 0 END )     FIRST_Y_BOKA_AMT " + "\n");
				   super.sql.append("            ,'-'                                                                              SECOND_Y_KNU_AMT  " + "\n");
				   super.sql.append("            ,'-'                                                                              SECOND_Y_GNK_RUI_AMT  " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN SSN.SECOND_GNK_SKK_AMT ELSE 0 END ) SECOND_Y_GNK_SKK_AMT " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN SSN.SECOND_BOKA_AMT ELSE 0 END ) SECOND_Y_BOKA_AMT " + "\n");
				   super.sql.append("            ,'-'                                                                              THIRD_Y_KNU_AMT  " + "\n");
				   super.sql.append("            ,'-'                                                                              THIRD_Y_GNK_RUI_AMT  " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN SSN.THIRD_GNK_SKK_AMT ELSE 0 END )  THIRD_Y_GNK_SKK_AMT " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN SSN.THIRD_BOKA_AMT ELSE 0 END )     THIRD_Y_BOKA_AMT " + "\n");
				   super.sql.append("            ,'-'                                                                              FOURTH_Y_KNU_AMT  " + "\n");
				   super.sql.append("            ,'-'                                                                              FOURTH_Y_GNK_RUI_AMT  " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN SSN.FOURTH_GNK_SKK_AMT ELSE 0 END ) FOURTH_Y_GNK_SKK_AMT " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN SSN.FOURTH_BOKA_AMT ELSE 0 END )    FOURTH_Y_BOKA_AMT " + "\n");
				   super.sql.append("            ,'-'                                                                              FIFTH_Y_KNU_AMT  " + "\n");
				   super.sql.append("            ,'-'                                                                              FIFTH_Y_GNK_RUI_AMT  " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN SSN.FIFTH_GNK_SKK_AMT ELSE 0 END )  FIFTH_Y_GNK_SKK_AMT " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN SSN.FIFTH_BOKA_AMT ELSE 0 END )     FIFTH_Y_BOKA_AMT " + "\n");
				   super.sql.append("            ,'-'                                                                              OVER_FIFTH_Y_KNU_AMT  " + "\n");
				   super.sql.append("            ,'-'                                                                              OVER_FIFTH_Y_GNK_RUI_AMT  " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN SSN.OVER_FIFTH_GNK_SKK_AMT ELSE 0 END ) OVER_FIFTH_Y_GNK_SKK_AMT " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN SSN.OVER_FIFTH_BOKA_AMT ELSE 0 END )    OVER_FIFTH_Y_BOKA_AMT " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN SSN.TOTAL_KNU_AMT ELSE 0 END )      TOTAL_Y_KNU_AMT " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN SSN.TOTAL_GNK_RUI_AMT ELSE 0 END )  TOTAL_Y_GNK_RUI_AMT " + "\n");
				   super.sql.append("            ,'-'                                                                              TOTAL_Y_GNK_SKK_AMT  " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN SSN.TOTAL_BOKA_AMT ELSE 0 END )     TOTAL_Y_BOKA_AMT " + "\n");
				   super.sql.append("      --無形資産 " + "\n");
				   super.sql.append("            ,'-'                                                                              FIRST_M_KNU_AMT  " + "\n");
				   super.sql.append("            ,'-'                                                                              FIRST_M_GNK_RUI_AMT  " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN 0 ELSE SSN.FIRST_GNK_SKK_AMT END )  FIRST_M_GNK_SKK_AMT " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN 0 ELSE SSN.FIRST_BOKA_AMT END )     FIRST_M_BOKA_AMT " + "\n");
				   super.sql.append("            ,'-'                                                                              SECOND_M_KNU_AMT  " + "\n");
				   super.sql.append("            ,'-'                                                                              SECOND_M_GNK_RUI_AMT  " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN 0 ELSE SSN.SECOND_GNK_SKK_AMT END ) SECOND_M_GNK_SKK_AMT " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN 0 ELSE SSN.SECOND_BOKA_AMT END )    SECOND_M_BOKA_AMT " + "\n");
				   super.sql.append("            ,'-'                                                                              THIRD_M_KNU_AMT  " + "\n");
				   super.sql.append("            ,'-'                                                                              THIRD_M_GNK_RUI_AMT  " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN 0 ELSE SSN.THIRD_GNK_SKK_AMT END )  THIRD_M_GNK_SKK_AMT " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN 0 ELSE SSN.THIRD_BOKA_AMT END )     THIRD_M_BOKA_AMT " + "\n");
				   super.sql.append("            ,'-'                                                                              FOURTH_M_KNU_AMT  " + "\n");
				   super.sql.append("            ,'-'                                                                              FOURTH_M_GNK_RUI_AMT  " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN 0 ELSE SSN.FOURTH_GNK_SKK_AMT END ) FOURTH_M_GNK_SKK_AMT " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN 0 ELSE SSN.FOURTH_BOKA_AMT END )    FOURTH_M_BOKA_AMT " + "\n");
				   super.sql.append("            ,'-'                                                                              FIFTH_M_KNU_AMT  " + "\n");
				   super.sql.append("            ,'-'                                                                              FIFTH_M_GNK_RUI_AMT  " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN 0 ELSE SSN.FIFTH_GNK_SKK_AMT END )  FIFTH_M_GNK_SKK_AMT " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN 0 ELSE SSN.FIFTH_BOKA_AMT END )     FIFTH_M_BOKA_AMT " + "\n");
				   super.sql.append("            ,'-'                                                                              OVER_FIFTH_M_KNU_AMT  " + "\n");
				   super.sql.append("            ,'-'                                                                              OVER_FIFTH_M_GNK_RUI_AMT  " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN 0 ELSE SSN.OVER_FIFTH_GNK_SKK_AMT END ) OVER_FIFTH_M_GNK_SKK_AMT " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN 0 ELSE SSN.OVER_FIFTH_BOKA_AMT END )    OVER_FIFTH_M_BOKA_AMT " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN 0 ELSE SSN.TOTAL_KNU_AMT END )      TOTAL_M_KNU_AMT " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN 0 ELSE SSN.TOTAL_GNK_RUI_AMT END )  TOTAL_M_GNK_RUI_AMT " + "\n");
				   super.sql.append("            ,'-'                                                                              TOTAL_M_GNK_SKK_AMT  " + "\n");
				   super.sql.append("            ,SUM(CASE WHEN SSN.YUKEI_MUKEI_KBN = '1' THEN 0 ELSE SSN.TOTAL_BOKA_AMT END )     TOTAL_M_BOKA_AMT " + "\n");
				   super.sql.append("    FROM  " + "\n");
				   super.sql.append("      -- 期日別予定表(資産SQL) " + "\n");
				   super.sql.append("      ( " + "\n");
				   super.sql.append(" " + "\n");
				   super.sql.append("    -- 資産 " + "\n");
//      -- 期日別予定表(資産SQL) Start
					super.sql.append("SELECT  DECODE(LU.PDF_COMPANY_NM, NULL, M_LC.LC_NM, LU.PDF_COMPANY_NM) LEASE_COMPANY " + "\n"); // リース会社
					super.sql.append("        ,LU.LU_NM LU_NM " + "\n"); // 開示先
					super.sql.append("        ,KB.JYSI_UM JYSI_UM_CD " + "\n"); // 重要性有無コード
					super.sql.append("        ,CASE WHEN KB.JYSI_UM = 1 THEN 'あり' ELSE 'なし' END JYSI_UM_NM " + "\n"); // 重要性有無
					super.sql.append("        ,TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN LEASE_BUNRUI_CD " + "\n"); // リース取引分類コード
					super.sql.append("        ,DECODE(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, '3', '解約不能') || TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_NM LEASE_BUNRUI " + "\n"); // リース取引分類		
					super.sql.append("        ,AC.AC_SHR_KBN AC_SHR_KBN " + "\n"); // 会計処理方法区分コード
					super.sql.append("        ,AC.AC_SHR_NM  AC_SHR_NM " + "\n"); //会計処理方法
					super.sql.append("        ,M_SSN_SRI.YUKEI_MUKEI_KBN YUKEI_MUKEI_KBN " + "\n"); // 資産区分コード
					super.sql.append("      　　        ,DECODE(M_SSN_SRI.YUKEI_MUKEI_KBN, '1', '有形資産', '無形資産') YUKEI_MUKEI_KBN_NM " + "\n"); // 資産区分
					super.sql.append("      　　        ,M_SSN_SRI.SSN_SRI_CD SSN_SRI_CD　" + "\n"); // 固定資産科目コード
					super.sql.append("      　　        ,M_SSN_SRI.SSN_SRI_NM SSN_SRI_NM　" + "\n"); // 固定資産科目
					super.sql.append("      　　        ,KB.SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN " + "\n"); // 減価償却方法コード
					super.sql.append("      　　        ,M_SKK_KEIJ_HOHO_KBN.SKK_HOHO_NM " + "\n"); // 減価償却方法		
					super.sql.append("        ,KB.HYJYO_KEI_NO KEI_NO " + "\n"); // 契約番号
					super.sql.append("        ,KB.BKN_NO BKN_NO " + "\n");
					super.sql.append("        ,KB.BKN_NO || " + "\n");		
					super.sql.append("         CASE WHEN TRIM(KB.BKN_EDANO) IS NULL THEN '' ELSE '-' || KB.BKN_EDANO END BKN_EDANO " + "\n"); // 物件番号
					super.sql.append("        ,KB.BKN_NM BKN_NM " + "\n"); // 物件名
					super.sql.append("        ,TO_CHAR(TO_DATE(KB.KNSHU_YMD), 'YYYY/MM/DD') KNSHU_YMD " + "\n"); // リース開始日
					super.sql.append("        ,TO_CHAR(TO_DATE(KB.MRYO_YMD), 'YYYY/MM/DD') MRYO_YMD " + "\n"); // リース終了日
					super.sql.append("        ,TO_CHAR(TO_DATE(KB.KAI_YMD), 'YYYY/MM/DD') KAI_YMD " + "\n"); // 中途解約日
					super.sql.append("        ,'-' FIRST_KNU_AMT " + "\n"); // 取得価額(1年以内)
					super.sql.append("        ,'-' FIRST_GNK_RUI_AMT " + "\n"); // 減価償却累計額(1年以内)
					super.sql.append("        ,SUM(CASE " + "\n"); 
					super.sql.append("             WHEN TO_CHAR(TO_DATE(KB.END_YMD)+1, 'YYYYMM') <= GNKSK.KEIJ_YM " + "\n");
					super.sql.append("             AND GNKSK.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(KB.END_YMD),12), 'YYYYMM') THEN " + "\n");
					super.sql.append("                 GNKSK.TGTU_SKK_AMT " + "\n");
					super.sql.append("             ELSE " + "\n");
					super.sql.append("                 0 " + "\n");
					super.sql.append("             END ) FIRST_GNK_SKK_AMT " + "\n"); // 減価償却費(1年以内)
					super.sql.append("        ,SUM(CASE " + "\n"); 
					super.sql.append("             WHEN GNKSK.KEIJ_YM = TO_CHAR(ADD_MONTHS(TO_DATE(KB.END_YMD),12), 'YYYYMM') THEN" + "\n");
					super.sql.append("                  GNKSK.ZAND_SKK_AMT " + "\n");
					super.sql.append("             ELSE " + "\n");
					super.sql.append("                 0 " + "\n");
					super.sql.append("             END ) FIRST_BOKA_AMT " + "\n"); //簿価(1年以内)
					super.sql.append("        ,'-' SECOND_KNU_AMT " + "\n"); // 取得価額(2年以内)
					super.sql.append("        ,'-' SECOND_GNK_RUI_AMT " + "\n"); // 減価償却累計額(2年以内)
					super.sql.append("        ,SUM(CASE " + "\n"); 
					super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(KB.END_YMD)+1,12), 'YYYYMM') <= GNKSK.KEIJ_YM " + "\n");
					super.sql.append("             AND GNKSK.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(KB.END_YMD),24), 'YYYYMM') THEN " + "\n");
					super.sql.append("                 GNKSK.TGTU_SKK_AMT " + "\n");
					super.sql.append("             ELSE " + "\n");
					super.sql.append("                 0 " + "\n");
					super.sql.append("             END ) SECOND_GNK_SKK_AMT " + "\n"); // 減価償却費(2年以内)
					super.sql.append("        ,SUM(CASE " + "\n"); 
					super.sql.append("             WHEN GNKSK.KEIJ_YM = TO_CHAR(ADD_MONTHS(TO_DATE(KB.END_YMD),24), 'YYYYMM') THEN" + "\n");
					super.sql.append("                  GNKSK.ZAND_SKK_AMT " + "\n");
					super.sql.append("             ELSE " + "\n");
					super.sql.append("                 0 " + "\n");
					super.sql.append("             END ) SECOND_BOKA_AMT " + "\n"); // 簿価(2年以内)		
					super.sql.append("        ,'-' THIRD_KNU_AMT " + "\n"); // 取得価額(3年以内)
					super.sql.append("        ,'-' THIRD_GNK_RUI_AMT " + "\n"); // 減価償却累計額(3年以内)
					super.sql.append("        ,SUM(CASE " + "\n"); 
					super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(KB.END_YMD)+1,24), 'YYYYMM') <= GNKSK.KEIJ_YM " + "\n");
					super.sql.append("             AND GNKSK.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(KB.END_YMD),36), 'YYYYMM') THEN " + "\n");
					super.sql.append("                 GNKSK.TGTU_SKK_AMT " + "\n");
					super.sql.append("             ELSE " + "\n");
					super.sql.append("                 0 " + "\n");
					super.sql.append("             END ) THIRD_GNK_SKK_AMT " + "\n"); // 減価償却費(3年以内)
					super.sql.append("        ,SUM(CASE " + "\n"); 
					super.sql.append("             WHEN GNKSK.KEIJ_YM = TO_CHAR(ADD_MONTHS(TO_DATE(KB.END_YMD),36), 'YYYYMM') THEN" + "\n");
					super.sql.append("                  GNKSK.ZAND_SKK_AMT " + "\n");
					super.sql.append("             ELSE " + "\n");
					super.sql.append("                 0 " + "\n");
					super.sql.append("             END ) THIRD_BOKA_AMT " + "\n"); // 簿価(3年以内)		
					super.sql.append("        ,'-' FOURTH_KNU_AMT " + "\n"); // 取得価額(4年以内)
					super.sql.append("        ,'-' FOURTH_GNK_RUI_AMT " + "\n"); // 減価償却累計額(4年以内)
					super.sql.append("        ,SUM(CASE " + "\n"); 
					super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(KB.END_YMD)+1,36), 'YYYYMM') <= GNKSK.KEIJ_YM " + "\n");
					super.sql.append("             AND GNKSK.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(KB.END_YMD),48), 'YYYYMM') THEN " + "\n");
					super.sql.append("                 GNKSK.TGTU_SKK_AMT " + "\n");
					super.sql.append("             ELSE " + "\n");
					super.sql.append("                 0 " + "\n");
					super.sql.append("             END ) FOURTH_GNK_SKK_AMT " + "\n"); // 減価償却費(4年以内)
					super.sql.append("        ,SUM(CASE " + "\n"); 
					super.sql.append("             WHEN GNKSK.KEIJ_YM = TO_CHAR(ADD_MONTHS(TO_DATE(KB.END_YMD),48), 'YYYYMM') THEN" + "\n");
					super.sql.append("                  GNKSK.ZAND_SKK_AMT " + "\n");
					super.sql.append("             ELSE " + "\n");
					super.sql.append("                 0 " + "\n");
					super.sql.append("             END ) FOURTH_BOKA_AMT " + "\n"); // 簿価(4年以内)		
					super.sql.append("        ,'-' FIFTH_KNU_AMT " + "\n"); // 取得価額(5年以内)
					super.sql.append("        ,'-' FIFTH_GNK_RUI_AMT " + "\n"); // 減価償却累計額(5年以内)
					super.sql.append("        ,SUM(CASE " + "\n"); 
					super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(KB.END_YMD)+1,48), 'YYYYMM') <= GNKSK.KEIJ_YM " + "\n");
					super.sql.append("             AND GNKSK.KEIJ_YM <= TO_CHAR(ADD_MONTHS(TO_DATE(KB.END_YMD),60), 'YYYYMM') THEN " + "\n");
					super.sql.append("                 GNKSK.TGTU_SKK_AMT " + "\n");
					super.sql.append("             ELSE " + "\n");
					super.sql.append("                 0 " + "\n");
					super.sql.append("             END ) FIFTH_GNK_SKK_AMT " + "\n"); // 減価償却費(5年以内)
					super.sql.append("        ,SUM(CASE " + "\n"); 
					super.sql.append("             WHEN GNKSK.KEIJ_YM = TO_CHAR(ADD_MONTHS(TO_DATE(KB.END_YMD),60), 'YYYYMM') THEN" + "\n");
					super.sql.append("                  GNKSK.ZAND_SKK_AMT " + "\n");
					super.sql.append("             ELSE " + "\n");
					super.sql.append("                 0 " + "\n");
					super.sql.append("             END ) FIFTH_BOKA_AMT " + "\n"); // 簿価(5年以内)		
					super.sql.append("        ,'-' OVER_FIFTH_KNU_AMT " + "\n"); // 取得価額(5年超)
					super.sql.append("        ,'-' OVER_FIFTH_GNK_RUI_AMT " + "\n"); // 減価償却累計額(5年超)
					super.sql.append("        ,SUM(CASE " + "\n"); 
					super.sql.append("             WHEN TO_CHAR(ADD_MONTHS(TO_DATE(KB.END_YMD)+1,60), 'YYYYMM') <= GNKSK.KEIJ_YM THEN " + "\n");		
					super.sql.append("                 GNKSK.TGTU_SKK_AMT " + "\n");
					super.sql.append("             ELSE " + "\n");
					super.sql.append("                 0 " + "\n");
					super.sql.append("             END ) OVER_FIFTH_GNK_SKK_AMT " + "\n"); // 減価償却費(5年超)
					super.sql.append("        ,SUM(CASE " + "\n"); 
					super.sql.append("             WHEN GNKSK.KEIJ_YM = KB.GNKSK_KEIJ_YM_MAX THEN" + "\n");
					super.sql.append("                  GNKSK.ZAND_SKK_AMT " + "\n");
					super.sql.append("             ELSE " + "\n");
					super.sql.append("                 0 " + "\n");
					super.sql.append("             END) OVER_FIFTH_BOKA_AMT " + "\n"); // 簿価(5年超)			
					super.sql.append("        ,MAX(BKN.GET_PRC_SHOMI) TOTAL_KNU_AMT " + "\n"); // 取得価額(合計)
					super.sql.append("        ,SUM(CASE WHEN M_SSN_SRI.YUKEI_MUKEI_KBN = '1' AND GNKSK.KEIJ_YM = SUBSTR(KB.END_YMD, 1,6) THEN " + "\n"); 
					super.sql.append("                   GNKSK.RUI_SKK_AMT " + "\n"); 
					super.sql.append("              ELSE  " + "\n"); 
					super.sql.append("                  0 " + "\n");
					super.sql.append("              END) TOTAL_GNK_RUI_AMT " + "\n"); // 減価償却累計額(合計)
					super.sql.append("        ,'-' TOTAL_GNK_SKK_AMT " + "\n"); // 減価償却費(合計)
					super.sql.append("        ,SUM(CASE " + "\n"); 
					super.sql.append("             WHEN M_SSN_SRI.YUKEI_MUKEI_KBN = '1' AND GNKSK.KEIJ_YM = SUBSTR(KB.END_YMD, 1,6) THEN " + "\n"); 
					super.sql.append("                   GNKSK.ZAND_SKK_AMT " + "\n"); 
					super.sql.append("              ELSE  " + "\n"); 
					super.sql.append("                  0 " + "\n");
					super.sql.append("              END) TOTAL_BOKA_AMT " + "\n"); // 簿価(合計)		
					super.sql.append("      ,TO_CHAR(SYSDATE, 'YYYYMMDD') CREATE_DATE " + "\n"); // 作成日
					super.sql.append("      ,KB.END_YMD END_YMD " + "\n"); // 基準日
					super.sql.append("FROM   (" + super.getCoreSQL() + ") KB " + "\n");
					super.sql.append("LEFT   JOIN M_LC ON KB.LC_CD = M_LC.LC_CD " + "\n");
					super.sql.append("LEFT   JOIN M_LU LU ON LU.LU_COSMOS_CD = KB.LU_COSMOS_CD " + "\n");
					super.sql.append("LEFT   JOIN M_TRD_HNTE_KEKA_KBN TRD_HNTE_KEKA_KBN ON TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN = KB.TRD_HNTE_KEKA_KBN " + "\n");
					super.sql.append("LEFT   JOIN M_SSN_SRI ON M_SSN_SRI.SSN_SRI_CD = KB.SSN_SRI_CD " + "\n");
					super.sql.append("LEFT   JOIN M_SKK_KEIJ_HOHO_KBN ON KB.SKK_KEIJ_HOHO_KBN = M_SKK_KEIJ_HOHO_KBN.SKK_KEIJ_HOHO_KBN " + "\n");
					super.sql.append("LEFT   JOIN T_BKN BKN ON BKN.LC_CD = KB.LC_CD AND BKN.KEI_NO = KB.KEI_NO AND BKN.BKN_NO = KB.BKN_NO AND BKN.BKN_EDANO = KB.BKN_EDANO " + "\n");
					super.sql.append("LEFT   JOIN T_UKB_GNKSK GNKSK ON GNKSK.LC_CD = KB.LC_CD AND GNKSK.KEI_NO = KB.KEI_NO AND GNKSK.BKN_NO = KB.BKN_NO AND GNKSK.BKN_EDANO = KB.BKN_EDANO AND GNKSK.KEIJ_HOHO_KBN = KB.SKK_KEIJ_HOHO_KBN " + "\n");
					super.sql.append("LEFT   JOIN M_AC_SHR_KBN AC ON AC.CTSHK_FLG = KB.CTSHK_FLG AND AC.AC_SHR_KBN = '" + super.kaikeiSyori + "'" + "\n");
//					super.sql.append("LEFT   JOIN T_BKN BKN ON BKN.LC_CD = KB.LC_CD AND BKN.KEI_NO = KB.KEI_NO " + "\n");
					super.sql.append("WHERE  KB.TRD_HNTE_KEKA_KBN IN ('1', '2', '3')" + "\n");
					super.sql.append("AND    KB.LU_COSMOS_CD = '" + this.leasCompanyCode + "' " + "\n"); // リースユーザ
					super.sql.append("AND    KB.TAISHO_AC_KIJYUN_CD ='" + super.acStd + "'" + "\n");
					super.sql.append("AND    AC.AC_SHR_KBN = " + super.kaikeiSyori + "\n");
				   	super.sql.append("AND    NVL(SUBSTR(KB.KAI_YMD, 1, 6), '999999') > KB.END_YMD " + "\n");

				    // 20210525 arai 対象期間内に受払データが存在するデータのみ取得 start
					super.sql.append("AND  GNKSK.KEIJ_YM >= TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') " +  "\n");
				    // 20210525 arai 対象期間内に受払データが存在するデータのみ取得 end
				   	
					// 20210528 arai 会計処理方法による出力変更対応 start
					if (kaikeiSyori.equals(LACSDefine.KaikeiSyori.SYOUSAI_0)) {
					 	super.sql.append("AND    KB.RSK_KEIJ_HOHO_KBN = " + getRisokuKeijoHohoKbn("BKN") + " " + "\n");
					} else {
						super.sql.append("AND    KB.RSK_KEIJ_HOHO_KBN = '" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' " + "\n");
					}
					// 20210528 arai 会計処理方法による出力変更対応 end
					
					if (super.keiyakuNo.trim().length() > 0) {
						super.sql.append("AND    KB.HYJYO_KEI_NO = '" + super.keiyakuNo + "' \n"); // 契約番号
					}

					if (this.bukkenNo.trim().length() > 0) {
						super.sql.append("AND    KB.BKN_NO || CASE WHEN TRIM(KB.BKN_EDANO) IS NULL THEN '' ELSE '-' || KB.BKN_EDANO END = '" + this.bukkenNo + "' " + "\n"); // 物件番号
					}

					// 抽出条件-旧会計基準
					if (super.acStd.equals(LACSDefine.AccountStandard.OLD_0)) {
						if (super.oldkeiyakuGaku.equals("0")) {
							super.sql.append("  AND    ((KB.SGK_SSN_KBN IS NULL AND KB.KEI_AMT_KEI > 3000000) " + "\n"); // 契約金額３００万円以下(KEI_AMTは物件から取得しているためKEI_AMT_KEIを使用)
							super.sql.append("      OR   (KB.SGK_SSN_KBN IS NOT NULL AND KB.SGK_SSN_KBN = '0')) " + "\n");
						}

						if (super.oldleaseKikan.equals("0")) {
							super.sql.append("  AND KB.KEI_TERM >= 12 " + "\n"); // リース期間１年未満
						}

						if (super.oldsaiLease.equals("0")) {
							super.sql.append("  AND KB.RLS_TMS = 0" + "\n"); // 再リース契約
						}

						if (super.oldtyutoKaiyaku.equals("0")) {
							super.sql.append("  AND KB.KAI_YMD IS NULL" + "\n"); // 中途解約物件
						}

						if ("1".equals(super.commonBean.getControlGokeiDsp())) {
							super.sql.append("  AND CTSHK_FLG = '1'" + "\n"); // 注記合計表表示制御
						}
					}
					// 抽出条件-新会計基準
					if (super.acStd.equals(LACSDefine.AccountStandard.NEW_1)) {
						if (super.newkeiyakuGaku.equals("0")) {
							super.sql.append("  AND    ((KB.SGK_SSN_KBN IS NULL AND KB.KEI_AMT_KEI > 3000000) " + "\n"); // 契約金額３００万円以下(KEI_AMTは物件から取得しているためKEI_AMT_KEIを使用)
							super.sql.append("      OR   (KB.SGK_SSN_KBN IS NOT NULL AND KB.SGK_SSN_KBN = '0')) " + "\n");
						}

						if (super.newleaseKikan.equals("0")) {
							super.sql.append("  AND KB.KEI_TERM > 12 " + "\n"); // リース期間１年以内
						}

						if (super.newsaiLease.equals("0")) {
							super.sql.append("  AND KB.RLS_TMS = 0" + "\n"); // 再リース契約
						}

						if (super.newtyutoKaiyaku.equals("0")) {
							super.sql.append("  AND KB.KAI_YMD IS NULL" + "\n"); // 中途解約物件
						}
					}

					super.sql.append("GROUP  BY KNSHU_YMD " + "\n");		
					super.sql.append("         ,MRYO_YMD " + "\n");
					super.sql.append("         ,KAI_YMD " + "\n");
					super.sql.append("         ,DECODE(LU.PDF_COMPANY_NM, NULL, M_LC.LC_NM, LU.PDF_COMPANY_NM) " + "\n");
					super.sql.append("         ,LU.LU_NM " + "\n");
					super.sql.append("         ,KB.JYSI_UM " + "\n");
					super.sql.append("         ,TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN " + "\n");
					super.sql.append("         ,CASE WHEN KB.JYSI_UM = 1 THEN 'あり' ELSE 'なし' END " + "\n");		
					super.sql.append("         ,TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN " + "\n");
					super.sql.append("         ,DECODE(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, '3', '解約不能') || TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_NM " + "\n");
					super.sql.append("         ,AC.AC_SHR_NM " + "\n");
					super.sql.append("         ,AC.AC_SHR_KBN " + "\n");
					super.sql.append("         ,M_SSN_SRI.YUKEI_MUKEI_KBN " + "\n");
					super.sql.append("         ,DECODE(M_SSN_SRI.YUKEI_MUKEI_KBN, '1', '有形資産', '無形資産') " + "\n");
					super.sql.append("         ,M_SSN_SRI.SSN_SRI_NM " + "\n");
					super.sql.append("         ,M_SKK_KEIJ_HOHO_KBN.SKK_HOHO_NM " + "\n");
					super.sql.append("         ,KB.HYJYO_KEI_NO " + "\n");
					super.sql.append("         ,KB.BKN_NO " + "\n");		
					super.sql.append("         ,KB.BKN_NO || CASE WHEN TRIM(KB.BKN_EDANO) IS NULL THEN '' ELSE '-' || KB.BKN_EDANO  END " + "\n");
					super.sql.append("         ,KB.BKN_NM   " + "\n"); 							
					super.sql.append("        ,YUKEI_MUKEI_KBN  " + "\n");
					super.sql.append("        ,KB.SKK_KEIJ_HOHO_KBN  " + "\n");
					super.sql.append("        ,M_SSN_SRI.SSN_SRI_CD  " + "\n");	
					super.sql.append("        ,KB.END_YMD " + "\n");		
//					super.sql.append("ORDER  BY LEASE_COMPANY " + "\n");
//					super.sql.append("         ,LU_NM " + "\n");		
//					super.sql.append("         ,JYSI_UM_NM " + "\n");
//					super.sql.append("         ,LEASE_BUNRUI " + "\n");
//					super.sql.append("         ,AC_SHR_NM " + "\n");
//					super.sql.append("         ,M_SSN_SRI.YUKEI_MUKEI_KBN " + "\n");
//					super.sql.append("         ,YUKEI_MUKEI_KBN " + "\n");
//					super.sql.append("         ,SSN_SRI_NM " + "\n");
//					super.sql.append("         ,SKK_HOHO_NM " + "\n");
//					super.sql.append("         ,KEI_NO " + "\n");
//					super.sql.append("         ,KB.BKN_NO " + "\n");
//					super.sql.append("         ,BKN_EDANO " + "\n");

//      -- 期日別予定表(債務SQL) End
					   super.sql.append(" " + "\n");
					   super.sql.append("    ) SSN " + "\n");
					   super.sql.append("    GROUP BY  " + "\n");
					   super.sql.append("             SSN.LEASE_COMPANY " + "\n");
					   super.sql.append("            ,SSN.LU_NM " + "\n");
					   super.sql.append("            ,SSN.JYSI_UM_CD " + "\n");
					   super.sql.append("            ,SSN.JYSI_UM_NM " + "\n");
					   super.sql.append("            ,SSN.LEASE_BUNRUI_CD " + "\n");
					   super.sql.append("            ,SSN.LEASE_BUNRUI  " + "\n");
					   super.sql.append("            ,SSN.AC_SHR_KBN  " + "\n");
					   super.sql.append("            ,SSN.AC_SHR_NM  " + "\n");
					   super.sql.append(" " + "\n");
					   super.sql.append(") GOKEI " + "\n");
					   super.sql.append("    GROUP BY  " + "\n");
//					   super.sql.append("        ,TO_CHAR(SYSDATE, 'YYYYMMDD') CREATE_DATE " + "\n"); // 作成日
//					   super.sql.append("        ,LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ") END_YMD " + "\n"); // 基準日				
					   super.sql.append("         TO_CHAR(SYSDATE, 'YYYYMMDD') \n"); // 作成日
					   super.sql.append("        ,LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + ")" + "\n"); // 基準日				
					   super.sql.append("        ,GOKEI.LEASE_COMPANY " + "\n");
					   super.sql.append("        ,GOKEI.LU_NM " + "\n");
					   super.sql.append("        ,CASE WHEN NVL(GOKEI.JYSI_UM_CD,'0') = '0' THEN '0' ELSE '1' END  " + "\n");
					   super.sql.append("        ,GOKEI.JYSI_UM_NM " + "\n");
					   super.sql.append("        ,GOKEI.LEASE_BUNRUI_CD " + "\n");
					   super.sql.append("        ,GOKEI.LEASE_BUNRUI  " + "\n");
					   super.sql.append("        ,GOKEI.AC_SHR_KBN  " + "\n");
					   super.sql.append("        ,GOKEI.AC_SHR_NM  " + "\n");
					   super.sql.append("    ORDER BY  " + "\n");
					   super.sql.append("         GOKEI.LEASE_COMPANY " + "\n");
					   super.sql.append("        ,GOKEI.LU_NM " + "\n");
					   super.sql.append("        ,CASE WHEN NVL(GOKEI.JYSI_UM_CD,'0') = '0' THEN '0' ELSE '1' END  " + "\n");
					   super.sql.append("        ,GOKEI.LEASE_BUNRUI_CD " + "\n");
					   super.sql.append("        ,GOKEI.AC_SHR_KBN  " + "\n");

//				
		
			//System.out.print("KizituGokei sql st");
			//System.out.print(super.sql);
			//System.out.print("KizituGokei sql ed");
			
		}
//		
		/**
		 * 作成日を取得.
		 * 
		 * @return 作成日
		 */
		public String getCreateDate() {
			return super.getString("CREATE_DATE");
		}
		
		/**
		 * 基準日を取得.
		 * 
		 * @return 基準日
		 */
		public String getKijunDate() {
			return super.getString("KIJUN_DATE");
		}
//		
		/**
		 * リース会社を取得.
		 * 
		 * @return リース会社
		 */
		public String getLeaseCompany() {
			return super.getString("LEASE_COMPANY");
		}

		/**
		 * 開示先を取得.
		 * 
		 * @return 開示先
		 */
		public String getKaizisaki() {
			return super.getString("LU_NM");
		}
		
		/**
		 * 重要性有無を取得.
		 * 
		 * @return 重要性有無
		 */
		public String getJysiUm() {
			return super.getString("JYSI_UM_NM");
		}
			 
		/**
		 * リース取引分類を取得.
		 * 
		 * @return リース会社
		 */
		public String getLeaseBunruiCd() {
			return super.getString("TRD_HNTE_KEKA_KBN");
		}
		
		/**
		 * リース取引分類名を取得.
		 * 
		 * @return リース取引分類名
		 */
		public String getLeaseBunrui() {
			return super.getString("LEASE_BUNRUI");
		}

		/**
		 * 会計処理方法を取得.
		 * 
		 * @return 会計処理方法
		 */
		public String getKaikeiSyori() {
			return super.getString("AC_SHR_NM");
		}
			
		/**
		 * 未経過リース料(1年以内)を取得.
		 * 
		 * @return 未経過リース料(1年以内)
		 */
		public long getMikeikaLeaseWithinOneYear() {
			return super.getLong("MIKEIKA_LEASE_ONE_YEAR");
		}
		
		/**
		 * 未経過リース料(2年以内)を取得.
		 * 
		 * @return 未経過リース料(2年以内)
		 */
		public long getMikeikaLeaseWithinTwoYears() {
			return super.getLong("MIKEIKA_LEASE_TWO_YEARS");
		}
		
		/**
		 * 未経過リース料(3年以内)を取得.
		 * 
		 * @return 未経過リース料(3年以内)
		 */
		public long getMikeikaLeaseWithinThreeYears() {
			return super.getLong("MIKEIKA_LEASE_THREE_YEARS");
		}
		
		/**
		 * 未経過リース料(4年以内)を取得.
		 * 
		 * @return 未経過リース料(4年以内)
		 */
		public long getMikeikaLeaseWithinFourYears() {
			return super.getLong("MIKEIKA_LEASE_FOUR_YEARS");
		}
		
		/**
		 * 未経過リース料(5年以内)を取得.
		 * 
		 * @return 未経過リース料(5年以内)
		 */
		public long getMikeikaLeaseWithinFiveYears() {
			return super.getLong("MIKEIKA_LEASE_FIVE_YEARS");
		}
		
		/**
		 * 未経過リース料(5年超)を取得.
		 * 
		 * @return 未経過リース料(5年超)
		 */
		public long getMikeikaLeaseOverFiveYears() {
			return super.getLong("MIKEIKA_LEASE_OVER_FIVE_YEARS");
		}
		
		/**
		 * 残価保証額(1年以内)を取得.
		 * 
		 * @return 残価保証額(1年以内)
		 */
		public long getZankaHosyogakuWithinOneYear() {
			return super.getLong("ZANK_HOSYOGAKU_ONE_YEAR");
		}
		
		/**
		 * 残価保証額(2年以内)を取得.
		 * 
		 * @return 残価保証額(2年以内)
		 */
		public long getZankaHosyogakuWithinTwoYears() {
			return super.getLong("ZANK_HOSYOGAKU_TWO_YEARS");
		}
		
		/**
		 * 残価保証額(3年以内)を取得.
		 * 
		 * @return 残価保証額(3年以内)
		 */
		public long getZankaHosyogakuWithinThreeYears() {
			return super.getLong("ZANK_HOSYOGAKU_THREE_YEARS");
		}
		
		/**
		 * 残価保証額(4年以内)を取得.
		 * 
		 * @return 残価保証額(4年以内)
		 */
		public long getZankaHosyogakuWithinFourYears() {
			return super.getLong("ZANK_HOSYOGAKU_FOUR_YEARS");
		}
		
		/**
		 * 残価保証額(5年以内)を取得.
		 * 
		 * @return 残価保証額(5年以内)
		 */
		public long getZankaHosyogakuWithinFiveYears() {
			return super.getLong("ZANK_HOSYOGAKU_FIVE_YEARS");
		}
		
		/**
		 * 残価保証額(5年超)を取得.
		 * 
		 * @return 残価保証額(5年超)
		 */
		public long getZankaHosyogakuOverFiveYears() {
			return super.getLong("ZANK_HOSYOGAKU_OVER_FIVE_YEARS");
		}
		
		/**
		 * 元本(1年以内)を取得.
		 * 
		 * @return 元本(1年以内)
		 */
		public long getGanponWithinOneYear() {
			return super.getLong("GNPN_ONE_YEAR");
		}
		
		/**
		 * 元本(2年以内)を取得.
		 * 
		 * @return 元本(2年以内)
		 */
		public long getGanponWithinTwoYears() {
			return super.getLong("GNPN_TWO_YEARS");
		}
		
		/**
		 * 元本(3年以内)を取得.
		 * 
		 * @return 元本(3年以内)
		 */
		public long getGanponWithinThreeYears() {
			return super.getLong("GNPN_THREE_YEARS");
		}
		
		/**
		 * 元本(4年以内)を取得.
		 * 
		 * @return 元本(4年以内)
		 */
		public long getGanponWithinFourYears() {
			return super.getLong("GNPN_FOUR_YEARS");
		}
		
		/**
		 * 元本(5年以内)を取得.
		 * 
		 * @return 元本(5年以内)
		 */
		public long getGanponWithinFiveYears() {
			return super.getLong("GNPN_FIVE_YEARS");
		}
		
		/**
		 * 元本(5年超)を取得.
		 * 
		 * @return 元本(5年超)
		 */
		public long getGanponOverFiveYears() {
			return super.getLong("GNPN_OVER_FIVE_YEARS");
		}
		
		/**
		 * 利息(1年以内)を取得.
		 * 
		 * @return 利息(1年以内)
		 */
		public long getRisokuWithinOneYear() {
			return super.getLong("RSK_ONE_YEAR");
		}
		
		/**
		 * 利息(2年以内)を取得.
		 * 
		 * @return 利息(2年以内)
		 */
		public long getRisokuWithinTwoYears() {
			return super.getLong("RSK_TWO_YEARS");
		}
		
		/**
		 * 利息(3年以内)を取得.
		 * 
		 * @return 利息(3年以内)
		 */
		public long getRisokuWithinThreeYears() {
			return super.getLong("RSK_THREE_YEARS");
		}
		
		/**
		 * 利息(4年以内)を取得.
		 * 
		 * @return 利息(4年以内)
		 */
		public long getRisokuWithinFourYears() {
			return super.getLong("RSK_FOUR_YEARS");
		}
		
		/**
		 * 利息(5年以内)を取得.
		 * 
		 * @return 利息(5年以内)
		 */
		public long getRisokuWithinFiveYears() {
			return super.getLong("RSK_FIVE_YEARS");
		}
		
		/**
		 * 利息(5年超)を取得.
		 * 
		 * @return 利息(5年超)
		 */
		public long getRisokuOverFiveYears() {
			return super.getLong("RSK_OVER_FIVE_YEARS");
		}

		/**
		 * 維持管理費(1年以内)を取得.
		 * 
		 * @return 維持管理費(1年以内)
		 */
		public long getIjiKanrihiWithinOneYear() {
			return super.getLong("IJI_KANRIHI_ONE_YEAR");
		}
		
		/**
		 * 維持管理費(2年以内)を取得.
		 * 
		 * @return 維持管理費(2年以内)
		 */
		public long getIjiKanrihiWithinTwoYears() {
			return super.getLong("IJI_KANRIHI_TWO_YEARS");
		}
		
		/**
		 * 維持管理費(3年以内)を取得.
		 * 
		 * @return 維持管理費(3年以内)
		 */
		public long getIjiKanrihiWithinThreeYears() {
			return super.getLong("IJI_KANRIHI_THREE_YEARS");
		}
		
		/**
		 * 維持管理費(4年以内)を取得.
		 * 
		 * @return 維持管理費(4年以内)
		 */
		public long getIjiKanrihiWithinFourYears() {
			return super.getLong("IJI_KANRIHI_FOUR_YEARS");
		}
		
		/**
		 * 維持管理費(5年以内)を取得.
		 * 
		 * @return 維持管理費(5年以内)
		 */
		public long getIjiKanrihiWithinFiveYears() {
			return super.getLong("IJI_KANRIHI_FIVE_YEARS");
		}
		
		/**
		 * 維持管理費(5年超)を取得.
		 * 
		 * @return 維持管理費(5年超)
		 */
		public long getIjiKanrihiOverFiveYears() {
			return super.getLong("IJI_KANRIHI_OVER_FIVE_YEARS");
		}
		
		/**
		 * 役務提供費(1年以内)を取得.
		 * 
		 * @return 役務提供費(1年以内)
		 */
		public long getEkimuteikiWithinOneYear() {
			return super.getLong("EKM_TEIK_ONE_YEAR");
		}
		
		/**
		 * 役務提供費(2年以内)を取得.
		 * 
		 * @return 役務提供費(2年以内)
		 */
		public long getEkimuteikiWithinTwoYears() {
			return super.getLong("EKM_TEIK_TWO_YEARS");
		}
		
		/**
		 * 役務提供費(3年以内)を取得.
		 * 
		 * @return 役務提供費(3年以内)
		 */
		public long getEkimuteikiWithinThreeYears() {
			return super.getLong("EKM_TEIK_THREE_YEARS");
		}
		
		/**
		 * 役務提供費(4年以内)を取得.
		 * 
		 * @return 役務提供費(4年以内)
		 */
		public long getEkimuteikiWithinFourYears() {
			return super.getLong("EKM_TEIK_FOUR_YEARS");
		}
		
		/**
		 * 役務提供費(5年以内)を取得.
		 * 
		 * @return 役務提供費(5年以内)
		 */
		public long getEkimuteikiWithinFiveYears() {
			return super.getLong("EKM_TEIK_FIVE_YEARS");
		}
		
		/**
		 * 役務提供費(5年超)を取得.
		 * 
		 * @return 役務提供費(5年超)
		 */
		public long getEkimuteikiOverFiveYears() {
			return super.getLong("EKM_TEIK_OVER_FIVE_YEARS");
		}
		
		/**
		 * 消費税等(1年以内)を取得.
		 * 
		 * @return 消費税等(1年以内)
		 */
		public long getSyohizeiWithinOneYear() {
			return super.getLong("LAMT_STAX_ONE_YEAR");
		}
		
		/**
		 * 消費税等(2年以内)を取得.
		 * 
		 * @return 消費税等(2年以内)
		 */
		public long getSyohizeiWithinTwoYears() {
			return super.getLong("LAMT_STAX_TWO_YEARS");
		}
		
		/**
		 * 消費税等(3年以内)を取得.
		 * 
		 * @return 消費税等(3年以内)
		 */
		public long getSyohizeiWithinThreeYears() {
			return super.getLong("LAMT_STAX_THREE_YEARS");
		}
		
		/**
		 * 消費税等(4年以内)を取得.
		 * 
		 * @return 消費税等(4年以内)
		 */
		public long getSyohizeiWithinFourYears() {
			return super.getLong("LAMT_STAX_FOUR_YEARS");
		}
		
		/**
		 * 消費税等(5年以内)を取得.
		 * 
		 * @return 消費税等(5年以内)
		 */
		public long getSyohizeiWithinFiveYears() {
			return super.getLong("LAMT_STAX_FIVE_YEARS");
		}
		
		/**
		 * 消費税等(5年超)を取得.
		 * 
		 * @return 消費税等(5年超)
		 */
		public long getSyohizeiOverFiveYears() {
			return super.getLong("LAMT_STAX_OVER_FIVE_YEARS");
		}
		
	    /**
		 * 未経過リース料(合計)を取得.
		 * 
		 * @return 未経過リース料(合計)
		 */
		public long getMikeikaLeaseTotal() {
			return super.getLong("MIKEIKA_LEASE_TOTAL");
		}
		
		/**
		 * 残価保証額(合計)を取得.
		 * 
		 * @return 残価保証額(合計)
		 */
		public long getZankaHosyogakuTotal() {
			return super.getLong("ZANK_HOSYOGAKU_TOTAL");
		}
	 
	    /**
		 * 元本(合計)を取得.
		 * 
		 * @return 元本(合計)
		 */
		public long getGanponTotal() {
			return super.getLong("GNPN_TOTAL");
		}
	 
	    /**
		 * 利息(合計)を取得.
		 * 
		 * @return 利息(合計)
		 */
		public long getRisokuTotal() {
			return super.getLong("RSK_TOTAL");
		}
		
		/**
		 * 維持管理費(合計)を取得.
		 * 
		 * @return 維持管理費(合計)
		 */
		public long getIjiKanrihiTotal() {
			return super.getLong("IJI_KANRIHI_TOTAL");
		}
		
		/**
		 * 役務提供費(合計)を取得.
		 * 
		 * @return 役務提供費(合計)
		 */
		public long getEkimuteikiTotal() {
			return super.getLong("EKM_TEIK_TOTAL");
		}
		
		/**
		 * 消費税等(合計)を取得.
		 * 
		 * @return 消費税等(合計)
		 */
		public long getSyohizeiTotal() {
			return super.getLong("LAMT_STAX_TOTAL");
		}

		
		
		/**
		 * 有形-取得価額(1年以内)を取得.
		 * 
		 * @return 有形-取得価額(1年以内)
		 */
		public String getYsyutokuKagakuWithinOneYear() {
			return super.getString("FIRST_Y_KNU_AMT");
		}
		
		/**
		 * 有形-取得価額(2年以内)を取得.
		 * 
		 * @return 有形-取得価額(2年以内)
		 */
		public String getYsyutokuKagakuWithinTwoYears() {
			return super.getString("SECOND_Y_KNU_AMT");
		}
		
		/**
		 * 有形-取得価額(3年以内)を取得.
		 * 
		 * @return 有形-取得価額(3年以内)
		 */
		public String getYsyutokuKagakuWithinThreeYears() {
			return super.getString("THIRD_Y_KNU_AMT");
		}
		
		/**
		 * 有形-取得価額(4年以内)を取得.
		 * 
		 * @return 有形-取得価額(4年以内)
		 */
		public String getYsyutokuKagakuWithinFourYears() {
			return super.getString("FOURTH_Y_KNU_AMT");
		}
		
		/**
		 * 有形-取得価額(5年以内)を取得.
		 * 
		 * @return 有形-取得価額(5年以内)
		 */
		public String getYsyutokuKagakuWithinFiveYears() {
			return super.getString("FIFTH_Y_KNU_AMT");
		}
		
		/**
		 * 有形-取得価額(5年超)を取得.
		 * 
		 * @return 有形-取得価額(5年超)
		 */
		public String getYsyutokuKagakuWithinOverFiveYears() {
			return super.getString("OVER_FIFTH_Y_KNU_AMT");
		}
		
		/**
		 * 有形-取得価額(合計)を取得.
		 * 
		 * @return 有形-取得価額(合計)
		 */
		public long getYsyutokuKagakuTotal() {
			return super.getLong("TOTAL_Y_KNU_AMT");
		}
		
		/**
		 * 有形-減価償却累計額(1年以内)を取得.
		 * 
		 * @return 有形-減価償却累計額(1年以内)
		 */
		public String getYgenkaRuikeiWithinOneYear() {
			return super.getString("FIRST_Y_GNK_RUI_AMT");
		}
		
		/**
		 * 有形-減価償却累計額(2年以内)を取得.
		 * 
		 * @return 有形-減価償却累計額(2年以内)
		 */
		public String getYgenkaRuikeiWithinTwoYears() {
			return super.getString("SECOND_Y_GNK_RUI_AMT");
		}
		
		/**
		 * 有形-減価償却累計額(3年以内)を取得.
		 * 
		 * @return 有形-減価償却累計額(3年以内)
		 */
		public String getYgenkaRuikeiWithinThreeYears() {
			return super.getString("THIRD_Y_GNK_RUI_AMT");
		}
		
		/**
		 * 有形-減価償却累計額(4年以内)を取得.
		 * 
		 * @return 有形-減価償却累計額(4年以内)
		 */
		public String getYgenkaRuikeiWithinFourYears() {
			return super.getString("FOURTH_Y_GNK_RUI_AMT");
		}
		
		/**
		 * 有形-減価償却累計額(5年以内)を取得.
		 * 
		 * @return 有形-減価償却累計額(5年以内)
		 */
		public String getYgenkaRuikeiWithinFiveYears() {
			return super.getString("FIFTH_Y_GNK_RUI_AMT");
		}
		
		/**
		 * 有形-減価償却累計額(5年超)を取得.
		 * 
		 * @return 有形-減価償却累計額(5年超)
		 */
		public String getYgenkaRuikeiWithinOverFiveYears() {
			return super.getString("OVER_FIFTH_Y_GNK_RUI_AMT");
		}
		
		/**
		 * 有形-減価償却累計額(合計)を取得.
		 * 
		 * @return 有形-減価償却累計額(合計)
		 */
		public long getYgenkaRuikeiTotal() {
			return super.getLong("TOTAL_Y_GNK_RUI_AMT");
		}
		
		/**
		 * 有形-減価償却累計額(1年以内)を取得.
		 * 
		 * @return 有形-減価償却累計額(1年以内)
		 */
		public long getYgenkaSyokyakuWithinOneYear() {
			return super.getLong("FIRST_Y_GNK_SKK_AMT");
		}
		
		/**
		 * 有形-減価償却累計額(2年以内)を取得.
		 * 
		 * @return 有形-減価償却累計額(2年以内)
		 */
		public long getYgenkaSyokyakuWithinTwoYears() {
			return super.getLong("SECOND_Y_GNK_SKK_AMT");
		}
		
		/**
		 * 有形-減価償却累計額(3年以内)を取得.
		 * 
		 * @return 有形-減価償却累計額(3年以内)
		 */
		public long getYgenkaSyokyakuWithinThreeYears() {
			return super.getLong("THIRD_Y_GNK_SKK_AMT");
		}
		
		/**
		 * 有形-減価償却累計額(4年以内)を取得.
		 * 
		 * @return 有形-減価償却累計額(4年以内)
		 */
		public long getYgenkaSyokyakuWithinFourYears() {
			return super.getLong("FOURTH_Y_GNK_SKK_AMT");
		}
		
		/**
		 * 有形-減価償却累計額(5年以内)を取得.
		 * 
		 * @return 有形-減価償却累計額(5年以内)
		 */
		public long getYgenkaSyokyakuWithinFiveYears() {
			return super.getLong("FIFTH_Y_GNK_SKK_AMT");
		}
		
		/**
		 * 有形-減価償却累計額(5年超)を取得.
		 * 
		 * @return 有形-減価償却累計額(5年超)
		 */
		public long getYgenkaSyokyakuOverFiveYears() {
			return super.getLong("OVER_FIFTH_Y_GNK_SKK_AMT");
		}
		
		/**
		 * 有形-減価償却累計額(合計)を取得.
		 * 
		 * @return 有形-減価償却累計額(合計)
		 */
		public String getYgenkaSyokyakuTotal() {
			return super.getString("TOTAL_Y_GNK_SKK_AMT");
		}
		
		/**
		 * 有形-簿価(1年以内)を取得.
		 * 
		 * @return 有形-簿価(1年以内)
		 */
		public long getYbokaWithinOneYear() {
			return super.getLong("FIRST_Y_BOKA_AMT");
		}
		
		/**
		 * 有形-簿価(2年以内)を取得.
		 * 
		 * @return 有形-簿価(2年以内)
		 */
		public long getYbokaWithinTwoYears() {
			return super.getLong("SECOND_Y_BOKA_AMT");
		}
		
		/**
		 * 有形-簿価(3年以内)を取得.
		 * 
		 * @return 有形-簿価(3年以内)
		 */
		public long getYbokaWithinThreeYears() {
			return super.getLong("THIRD_Y_BOKA_AMT");
		}
		
		/**
		 * 有形-簿価(4年以内)を取得.
		 * 
		 * @return 有形-簿価(4年以内)
		 */
		public long getYbokaWithinFourYears() {
			return super.getLong("FOURTH_Y_BOKA_AMT");
		}
		
		/**
		 * 有形-簿価(5年以内)を取得.
		 * 
		 * @return 有形-簿価(5年以内)
		 */
		public long getYbokaWithinFiveYears() {
			return super.getLong("FIFTH_Y_BOKA_AMT");
		}
		
		/**
		 * 有形-簿価(5年超)を取得.
		 * 
		 * @return 有形-簿価(5年超)
		 */
		public long getYbokaWithinOverFiveYears() {
			return super.getLong("OVER_FIFTH_Y_BOKA_AMT");
		}
		
		/**
		 * 有形-簿価(合計)を取得.
		 * 
		 * @return 有形-簿価(合計)
		 */
		public long getYbokaTotal() {
			return super.getLong("TOTAL_Y_BOKA_AMT");
		}

		/**
		 * 無形-取得価額(1年以内)を取得.
		 * 
		 * @return 無形-取得価額(1年以内)
		 */
		public String getMsyutokuKagakuWithinOneYear() {
			return super.getString("FIRST_M_KNU_AMT");
		}
		
		/**
		 * 無形-取得価額(2年以内)を取得.
		 * 
		 * @return 無形-取得価額(2年以内)
		 */
		public String getMsyutokuKagakuWithinTwoYears() {
			return super.getString("SECOND_M_KNU_AMT");
		}
		
		/**
		 * 無形-取得価額(3年以内)を取得.
		 * 
		 * @return 無形-取得価額(3年以内)
		 */
		public String getMsyutokuKagakuWithinThreeYears() {
			return super.getString("THIRD_M_KNU_AMT");
		}
		
		/**
		 * 無形-取得価額(4年以内)を取得.
		 * 
		 * @return 無形-取得価額(4年以内)
		 */
		public String getMsyutokuKagakuWithinFourYears() {
			return super.getString("FOURTH_M_KNU_AMT");
		}
		
		/**
		 * 無形-取得価額(5年以内)を取得.
		 * 
		 * @return 無形-取得価額(5年以内)
		 */
		public String getMsyutokuKagakuWithinFiveYears() {
			return super.getString("FIFTH_M_KNU_AMT");
		}
		
		/**
		 * 無形-取得価額(5年超)を取得.
		 * 
		 * @return 無形-取得価額(5年超)
		 */
		public String getMsyutokuKagakuWithinOverFiveYears() {
			return super.getString("OVER_FIFTH_M_KNU_AMT");
		}
		
		/**
		 * 無形-取得価額(合計)を取得.
		 * 
		 * @return 無形-取得価額(合計)
		 */
		public long getMsyutokuKagakuTotal() {
			return super.getLong("TOTAL_M_KNU_AMT");
		}
		
		/**
		 * 無形-減価償却累計額(1年以内)を取得.
		 * 
		 * @return 無形-減価償却累計額(1年以内)
		 */
		public String getMgenkaRuikeiWithinOneYear() {
			return super.getString("FIRST_M_GNK_RUI_AMT");
		}
		
		/**
		 * 無形-減価償却累計額(2年以内)を取得.
		 * 
		 * @return 無形-減価償却累計額(2年以内)
		 */
		public String getMgenkaRuikeiWithinTwoYears() {
			return super.getString("SECOND_M_GNK_RUI_AMT");
		}
		
		/**
		 * 無形-減価償却累計額(3年以内)を取得.
		 * 
		 * @return 無形-減価償却累計額(3年以内)
		 */
		public String getMgenkaRuikeiWithinThreeYears() {
			return super.getString("THIRD_M_GNK_RUI_AMT");
		}
		
		/**
		 * 無形-減価償却累計額(4年以内)を取得.
		 * 
		 * @return 無形-減価償却累計額(4年以内)
		 */
		public String getMgenkaRuikeiWithinFourYears() {
			return super.getString("FOURTH_M_GNK_RUI_AMT");
		}
		
		/**
		 * 無形-減価償却累計額(5年以内)を取得.
		 * 
		 * @return 無形-減価償却累計額(5年以内)
		 */
		public String getMgenkaRuikeiWithinFiveYears() {
			return super.getString("FIFTH_M_GNK_RUI_AMT");
		}
		
		/**
		 * 無形-減価償却累計額(5年超)を取得.
		 * 
		 * @return 無形-減価償却累計額(5年超)
		 */
		public String getMgenkaRuikeiWithinOverFiveYears() {
			return super.getString("OVER_FIFTH_M_GNK_RUI_AMT");
		}
		
		/**
		 * 無形-減価償却累計額(合計)を取得.
		 * 
		 * @return 無形-減価償却累計額(合計)
		 */
		public long getMgenkaRuikeiTotal() {
			return super.getLong("TOTAL_M_GNK_RUI_AMT");
		}
		
		/**
		 * 無形-減価償却累計額(1年以内)を取得.
		 * 
		 * @return 無形-減価償却累計額(1年以内)
		 */
		public long getMgenkaSyokyakuWithinOneYear() {
			return super.getLong("FIRST_M_GNK_SKK_AMT");
		}
		
		/**
		 * 無形-減価償却累計額(2年以内)を取得.
		 * 
		 * @return 無形-減価償却累計額(2年以内)
		 */
		public long getMgenkaSyokyakuWithinTwoYears() {
			return super.getLong("SECOND_M_GNK_SKK_AMT");
		}
		
		/**
		 * 無形-減価償却累計額(3年以内)を取得.
		 * 
		 * @return 無形-減価償却累計額(3年以内)
		 */
		public long getMgenkaSyokyakuWithinThreeYears() {
			return super.getLong("THIRD_M_GNK_SKK_AMT");
		}
		
		/**
		 * 無形-減価償却累計額(4年以内)を取得.
		 * 
		 * @return 無形-減価償却累計額(4年以内)
		 */
		public long getMgenkaSyokyakuWithinFourYears() {
			return super.getLong("FOURTH_M_GNK_SKK_AMT");
		}
		
		/**
		 * 無形-減価償却累計額(5年以内)を取得.
		 * 
		 * @return 無形-減価償却累計額(5年以内)
		 */
		public long getMgenkaSyokyakuWithinFiveYears() {
			return super.getLong("FIFTH_M_GNK_SKK_AMT");
		}
		
		/**
		 * 無形-減価償却累計額(5年超)を取得.
		 * 
		 * @return 無形-減価償却累計額(5年超)
		 */
		public long getMgenkaSyokyakuOverFiveYears() {
			return super.getLong("OVER_FIFTH_M_GNK_SKK_AMT");
		}
		
		/**
		 * 無形-減価償却累計額(合計)を取得.
		 * 
		 * @return 無形-減価償却累計額(合計)
		 */
		public String getMgenkaSyokyakuTotal() {
			return super.getString("TOTAL_M_GNK_SKK_AMT");
		}
		
		/**
		 * 無形-簿価(1年以内)を取得.
		 * 
		 * @return 無形-簿価(1年以内)
		 */
		public long getMbokaWithinOneYear() {
			return super.getLong("FIRST_M_BOKA_AMT");
		}
		
		/**
		 * 無形-簿価(2年以内)を取得.
		 * 
		 * @return 無形-簿価(2年以内)
		 */
		public long getMbokaWithinTwoYears() {
			return super.getLong("SECOND_M_BOKA_AMT");
		}
		
		/**
		 * 無形-簿価(3年以内)を取得.
		 * 
		 * @return 無形-簿価(3年以内)
		 */
		public long getMbokaWithinThreeYears() {
			return super.getLong("THIRD_M_BOKA_AMT");
		}
		
		/**
		 * 無形-簿価(4年以内)を取得.
		 * 
		 * @return 無形-簿価(4年以内)
		 */
		public long getMbokaWithinFourYears() {
			return super.getLong("FOURTH_M_BOKA_AMT");
		}
		
		/**
		 * 無形-簿価(5年以内)を取得.
		 * 
		 * @return 無形-簿価(5年以内)
		 */
		public long getMbokaWithinFiveYears() {
			return super.getLong("FIFTH_M_BOKA_AMT");
		}
		
		/**
		 * 無形-簿価(5年超)を取得.
		 * 
		 * @return 無形-簿価(5年超)
		 */
		public long getMbokaWithinOverFiveYears() {
			return super.getLong("OVER_FIFTH_M_BOKA_AMT");
		}
		
		/**
		 * 無形-簿価(合計)を取得.
		 * 
		 * @return 無形-簿価(合計)
		 */
		public long getMbokaTotal() {
			return super.getLong("TOTAL_M_BOKA_AMT");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
     }
