package jp.co.pro_app.lacs.affairs.report.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 帳票出力：期日別予定表(資産）Entity.
 * 
 * @author arai
 * @version 20200617
 */

public class LACSReportKizituSisanEntity extends LACSReportEntityBase {
	
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
	public LACSReportKizituSisanEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSReportBean piReportBean, String piAcStd) {
		super(piModel, piCommonBean, piReportBean, piAcStd);
	}

	/**
	 * SQLを生成.
	 * 
	 */
	protected void makeSQL() {
		super.sql.append("SELECT RPAD(KB.LU_COSMOS_CD, 10, ' ') BRAKE_KEY0 " + "\n");
		super.sql.append("        ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') BRAKE_KEY1 " + "\n");
		super.sql.append("        ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ') BRAKE_KEY2 " + "\n");
		super.sql.append("        ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG , 1, ' ') BRAKE_KEY3 " + "\n");
		super.sql.append("        ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG , 1, ' ') || RPAD(M_SSN_SRI.YUKEI_MUKEI_KBN , 1, ' ') BRAKE_KEY4 " + "\n");
		super.sql.append("        ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG , 1, ' ') || RPAD(M_SSN_SRI.YUKEI_MUKEI_KBN , 1, ' ') || RPAD(KB.SSN_SRI_CD , 1, ' ') BRAKE_KEY5 " + "\n");
		super.sql.append("        ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG , 1, ' ') || RPAD(M_SSN_SRI.YUKEI_MUKEI_KBN , 1, ' ') || RPAD(KB.SSN_SRI_CD , 1, ' ') || RPAD(M_SKK_KEIJ_HOHO_KBN.SKK_KEIJ_HOHO_KBN , 1, ' ') BRAKE_KEY6 " + "\n");
		super.sql.append("        ,DECODE(LU.PDF_COMPANY_NM, NULL, M_LC.LC_NM, LU.PDF_COMPANY_NM) LEASE_COMPANY " + "\n"); // リース会社		
		super.sql.append("        ,LU.LU_NM LU_NM " + "\n"); // 開示先
		super.sql.append("        ,KB.JYSI_UM JYSI_UM_CD " + "\n"); // 重要性有無コード
		super.sql.append("        ,CASE WHEN KB.JYSI_UM = 1 THEN 'あり' ELSE 'なし' END JYSI_UM_NM " + "\n"); // 重要性有無
		super.sql.append("        ,TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN LEASE_BUNRUI_CD " + "\n"); // リース取引分類コード
		super.sql.append("        ,DECODE(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, '3', '解約不能') || TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_NM LEASE_BUNRUI " + "\n"); // リース取引分類		
		super.sql.append("        ,AC.AC_SHR_KBN AC_SHR_KBN " + "\n"); // 会計処理方法区分コード
		super.sql.append("        ,AC.AC_SHR_NM  AC_SHR_NM " + "\n"); //会計処理方法
		super.sql.append("        ,M_SSN_SRI.YUKEI_MUKEI_KBN YUKEI_MUKEI_KBN " + "\n"); // 資産区分コード
		super.sql.append("        ,DECODE(M_SSN_SRI.YUKEI_MUKEI_KBN, '1', '有形資産', '無形資産') YUKEI_MUKEI_KBN_NM " + "\n"); // 資産区分
		super.sql.append("        ,M_SSN_SRI.SSN_SRI_CD SSN_SRI_CD　" + "\n"); // 固定資産科目コード
		super.sql.append("        ,M_SSN_SRI.SSN_SRI_NM SSN_SRI_NM　" + "\n"); // 固定資産科目
		super.sql.append("        ,M_SKK_KEIJ_HOHO_KBN.SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO_KBN " + "\n"); // 減価償却方法コード
		super.sql.append("        ,M_SKK_KEIJ_HOHO_KBN.SKK_HOHO_NM " + "\n"); // 減価償却方法		
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
		super.sql.append("LEFT   JOIN T_UKB_GNKSK GNKSK ON GNKSK.LC_CD = KB.LC_CD AND GNKSK.KEI_NO = KB.KEI_NO AND GNKSK.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("            AND KB.SKK_KEIJ_HOHO_KBN = GNKSK.KEIJ_HOHO_KBN AND GNKSK.BKN_EDANO = KB.BKN_EDANO " + "\n");		
		super.sql.append("LEFT   JOIN M_AC_SHR_KBN AC ON AC.CTSHK_FLG = KB.CTSHK_FLG AND AC.AC_SHR_KBN = " + super.kaikeiSyori + "\n");
		super.sql.append("LEFT   JOIN T_BKN BKN ON BKN.LC_CD = KB.LC_CD AND BKN.KEI_NO = KB.KEI_NO AND BKN.BKN_NO = KB.BKN_NO AND BKN.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("WHERE  KB.TRD_HNTE_KEKA_KBN IN ('1', '2', '3')" + "\n");
		super.sql.append("AND    KB.LU_COSMOS_CD = '" + this.leasCompanyCode + "' " + "\n"); // リースユーザ
		super.sql.append("AND    KB.TAISHO_AC_KIJYUN_CD ='" + super.acStd + "'" + "\n");
		super.sql.append("AND    AC.AC_SHR_KBN = " + super.kaikeiSyori + "\n");
		super.sql.append("AND    NVL(SUBSTR(KB.KAI_YMD, 1, 6), '999999') > KB.END_YMD " + "\n");
		
	    // 20210525 arai 対象期間内に受払データが存在するデータのみ取得 START
		super.sql.append("AND  GNKSK.KEIJ_YM >= TO_CHAR(TO_DATE(LACS_COMMON.GET_TERM_DATE('" + super.dateFrom + "', " + super.termNum + "))+1, 'YYYYMM') " +  "\n");
	    // 20210525 arai 対象期間内に受払データが存在するデータのみ取得 END
		
		if (super.keiyakuNo.trim().length() > 0) {
			super.sql.append("AND    KB.HYJYO_KEI_NO = '" + super.keiyakuNo + "' \n"); // 契約番号
		}

		// 20210528 arai 会計処理方法による出力変更対応 start
		if (kaikeiSyori.equals(LACSDefine.KaikeiSyori.SYOUSAI_0)) {
		 	super.sql.append("AND  	  KB.RSK_KEIJ_HOHO_KBN = " + getRisokuKeijoHohoKbn("BKN") + " " + "\n");
		} else {
			super.sql.append("AND    KB.RSK_KEIJ_HOHO_KBN = '" + LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201 + "' " + "\n");
		}
		//20210528 arai 会計処理方法による出力変更対応 end
		
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
		super.sql.append("         ,M_SKK_KEIJ_HOHO_KBN.SKK_HOHO_CD " + "\n");
		super.sql.append("         ,KB.HYJYO_KEI_NO " + "\n");
		super.sql.append("         ,KB.BKN_NO " + "\n");		
		super.sql.append("         ,KB.BKN_NO || CASE WHEN TRIM(KB.BKN_EDANO) IS NULL THEN '' ELSE '-' || KB.BKN_EDANO  END " + "\n");
		super.sql.append("         ,KB.BKN_NM   " + "\n"); 				 	
		super.sql.append("        ,YUKEI_MUKEI_KBN  " + "\n");
		super.sql.append("        ,M_SKK_KEIJ_HOHO_KBN.SKK_KEIJ_HOHO_KBN  " + "\n");
		super.sql.append("        ,M_SSN_SRI.SSN_SRI_CD  " + "\n");	
		super.sql.append("        ,END_YMD " + "\n");							
		super.sql.append("        ,RPAD(KB.LU_COSMOS_CD, 10, ' ')  " + "\n");
		super.sql.append("        ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ')  " + "\n");
		super.sql.append("        ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ')  " + "\n");
		super.sql.append("        ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG , 1, ' ')  " + "\n");
		super.sql.append("        ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG , 1, ' ') || RPAD(M_SSN_SRI.YUKEI_MUKEI_KBN , 1, ' ')  " + "\n");
		super.sql.append("        ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG , 1, ' ') || RPAD(M_SSN_SRI.YUKEI_MUKEI_KBN , 1, ' ') || RPAD(KB.SSN_SRI_CD , 1, ' ')  " + "\n");
		super.sql.append("        ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.JYSI_UM, 1, ' ') || RPAD(TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG , 1, ' ') || RPAD(M_SSN_SRI.YUKEI_MUKEI_KBN , 1, ' ') || RPAD(KB.SSN_SRI_CD , 1, ' ') || RPAD(KB.SKK_KEIJ_HOHO_KBN , 1, ' ')  " + "\n");
		super.sql.append("ORDER  BY LEASE_COMPANY " + "\n");
		super.sql.append("         ,LU_NM " + "\n");		
		super.sql.append("         ,JYSI_UM " + "\n");
		super.sql.append("         ,LEASE_BUNRUI_CD " + "\n");
		super.sql.append("         ,AC.AC_SHR_KBN " + "\n");
		//super.sql.append("         ,M_SSN_SRI.YUKEI_MUKEI_KBN " + "\n");
		super.sql.append("         ,YUKEI_MUKEI_KBN " + "\n");
		super.sql.append("         ,SSN_SRI_CD " + "\n");
		super.sql.append("         ,SKK_HOHO_CD " + "\n");
		super.sql.append("         ,KEI_NO " + "\n");
		super.sql.append("         ,KB.BKN_NO " + "\n");
		super.sql.append("         ,BKN_EDANO " + "\n");
				
		

		//System.out.print(sql);
		
	}
	
	/**
	 * ブレイクキー0を取得.
	 * 
	 * @return ブレイクキー0
	 */
	public String getBreakKey0() {
		return super.getString("BRAKE_KEY0");
	}
	
	/**
	 * ブレイクキー0を取得.
	 * 
	 * @return ブレイクキー0
	 */
	public String getBreakKey1() {
		return super.getString("BRAKE_KEY1");
	}
	
	/**
	 * ブレイクキー2を取得.
	 * 
	 * @return ブレイクキー2
	 */
	public String getBreakKey2() {
		return super.getString("BRAKE_KEY2");
	}
	
	/**
	 * ブレイクキー3を取得.
	 * 
	 * @return ブレイクキー3
	 */
	public String getBreakKey3() {
		return super.getString("BRAKE_KEY3");
	
	}
	
	/**
	 * ブレイクキー4を取得.
	 * 
	 * @return ブレイクキー4
	 */
	public String getBreakKey4() {
		return super.getString("BRAKE_KEY4");
	}
	
	/**
	 * ブレイクキー5を取得.
	 * 
	 * @return ブレイクキー5
	 */
	public String getBreakKey5() {
		return super.getString("BRAKE_KEY5");
	
	}
	
	/**
	 * ブレイクキー5を取得.
	 * 
	 * @return ブレイクキー5
	 */
	public String getBreakKey6() {
		return super.getString("BRAKE_KEY6");	
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
	 * 基準日を取得.
	 * 
	 * @return 基準 
	 */
	public String getStandardDate() {
		return super.getString("END_YMD");
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
	 * 重要性有無コードを取得.
	 * 
	 * @return 重要性有無
	 */
	public String getJysiUmCd() {
		return super.getString("JYSI_UM_CD");
	}	
	
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
	public String getkaizisaki() {
		return super.getString("LU_NM");
	}
	
	/**
	 * リース取引分類を取得.
	 * 
	 * @return リース会社
	 */
	public String getLeaseBunrui() {
		return super.getString("LEASE_BUNRUI");
	}
	
	/**
	 * リース取引分類コードを取得.
	 * 
	 * @return リース会社
	 */
	public String getLeaseBunruiCd() {
		return super.getString("LEASE_BUNRUI_CD");
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
	 * 会計処理方法区分を取得.
	 * 
	 * @return 会計処理方法
	 */
	public String getKaikeiSyoriKbn() {
		return super.getString("AC_SHR_KBN_NM");
	}
	
	/**
	 * 資産区分名称を取得.
	 * 
	 * @return 資産区分
	 */
	public String getSisanKbn() {
		return super.getString("YUKEI_MUKEI_KBN_NM");
	}
	
	/**
	 * 資産区分コードを取得.
	 * 
	 * @return 資産区分コード
	 */
	public String getSisanKbnCd() {
		return super.getString("YUKEI_MUKEI_KBN");
	}
	
	
	
	/**
	 * 固定資産科目を取得.
	 * 
	 * @return 固定資産科目
	 */
	public String getSisanKamoku() {
		return super.getString("SSN_SRI_NM");
	}
	
	/**
	 * 減価償却方法を取得.
	 * 
	 * @return 減価償却方法
	 */
	public String getGenkaSyokyakuMethod() {
		return super.getString("SKK_HOHO_NM");
	}
	
	/**
	 * 減価償却方法コードを取得.
	 * 
	 * @return 減価償却方法
	 */
	public String getGenkaSyokyakuMethodKBn() {
		return super.getString("SKK_KEIJ_HOHO_KBN");
	}	
	
	/**
	 * 契約番号を取得.
	 * 
	 * @return 契約番号
	 */
	public String getKeiyakuNo() {
		return super.getString("KEI_NO");
	}
	
	/**
	 * 物件番号を取得.
	 * 
	 * @return 物件番号
	 */
	public String getBukenNo() {
		return super.getString("BKN_NO");
	}
	
	/**
	 * 物件名を取得.
	 * 
	 * @return 物件名
	 */
	public String getBukenNm() {
		return super.getString("BKN_NM");
	}

	/**
	 * リース開始日を取得.
	 * 
	 * @return リース開始日
	 */
	public String getLeaseFrom() {
		return super.getString("KNSHU_YMD");
	}

	/**
	 * リース終了日を取得.
	 * 
	 * @return リース終了日
	 */
	public String getLeaseTo() {
		return super.getString("MRYO_YMD");
	}

	/**
	 * 中途解約日を取得.
	 * 
	 * @return 中途解約日
	 */
	public String getKaiyakuYmd() {
		return super.getString("KAI_YMD");
	}
	
	/**
	 * 取得価額(1年以内)を取得.
	 * 
	 * @return 取得価額(1年以内)
	 */
	public String getSyutokuKagakuWithinOneYear() {
		return super.getString("FIRST_KNU_AMT");
	}
	
	/**
	 * 取得価額(2年以内)を取得.
	 * 
	 * @return 取得価額(2年以内)
	 */
	public String getSyutokuKagakuWithinTwoYears() {
		return super.getString("SECOND_KNU_AMT");
	}
	
	/**
	 * 取得価額(3年以内)を取得.
	 * 
	 * @return 取得価額(3年以内)
	 */
	public String getSyutokuKagakuWithinThreeYears() {
		return super.getString("THIRD_KNU_AMT");
	}
	
	/**
	 * 取得価額(4年以内)を取得.
	 * 
	 * @return 取得価額(4年以内)
	 */
	public String getSyutokuKagakuWithinFourYears() {
		return super.getString("FOURTH_KNU_AMT");
	}
	
	/**
	 * 取得価額(5年以内)を取得.
	 * 
	 * @return 取得価額(5年以内)
	 */
	public String getSyutokuKagakuWithinFiveYears() {
		return super.getString("FIFTH_KNU_AMT");
	}
	
	/**
	 * 取得価額(5年超)を取得.
	 * 
	 * @return 取得価額(5年超)
	 */
	public String getSyutokuKagakuWithinOverFiveYears() {
		return super.getString("OVER_FIFTH_KNU_AMT");
	}
	
	/**
	 * 取得価額(合計)を取得.
	 * 
	 * @return 取得価額(合計)
	 */
	public long getSyutokuKagakuTotal() {
		return super.getLong("TOTAL_KNU_AMT");
	}
	
	/**
	 * 減価償却累計額(1年以内)を取得.
	 * 
	 * @return 減価償却累計額(1年以内)
	 */
	public String getGenkaRuikeiWithinOneYear() {
		return super.getString("FIRST_GNK_RUI_AMT");
	}
	
	/**
	 * 減価償却累計額(2年以内)を取得.
	 * 
	 * @return 減価償却累計額(2年以内)
	 */
	public String getGenkaRuikeiWithinTwoYears() {
		return super.getString("SECOND_GNK_RUI_AMT");
	}
	
	/**
	 * 減価償却累計額(3年以内)を取得.
	 * 
	 * @return 減価償却累計額(3年以内)
	 */
	public String getGenkaRuikeiWithinThreeYears() {
		return super.getString("THIRD_GNK_RUI_AMT");
	}
	
	/**
	 * 減価償却累計額(4年以内)を取得.
	 * 
	 * @return 減価償却累計額(4年以内)
	 */
	public String getGenkaRuikeiWithinFourYears() {
		return super.getString("FOURTH_GNK_RUI_AMT");
	}
	
	/**
	 * 減価償却累計額(5年以内)を取得.
	 * 
	 * @return 減価償却累計額(5年以内)
	 */
	public String getGenkaRuikeiWithinFiveYears() {
		return super.getString("FIFTH_GNK_RUI_AMT");
	}
	
	/**
	 * 減価償却累計額(5年超)を取得.
	 * 
	 * @return 減価償却累計額(5年超)
	 */
	public String getGenkaRuikeiWithinOverFiveYears() {
		return super.getString("OVER_FIFTH_GNK_RUI_AMT");
	}
	
	/**
	 * 減価償却累計額(合計)を取得.
	 * 
	 * @return 減価償却累計額(合計)
	 */
	public long getGenkaRuikeiTotal() {
		return super.getLong("TOTAL_GNK_RUI_AMT");
	}
	
	/**
	 * 減価償却費(1年以内)を取得.
	 * 
	 * @return 減価償却費(1年以内)
	 */
	public long getGenkaSyokyakuWithinOneYear() {
		return super.getLong("FIRST_GNK_SKK_AMT");
	}
	
	/**
	 * 減価償却費(2年以内)を取得.
	 * 
	 * @return 減価償却費(2年以内)
	 */
	public long getGenkaSyokyakuWithinTwoYears() {
		return super.getLong("SECOND_GNK_SKK_AMT");
	}
	
	/**
	 * 減価償却費(3年以内)を取得.
	 * 
	 * @return 減価償却費(3年以内)
	 */
	public long getGenkaSyokyakuWithinThreeYears() {
		return super.getLong("THIRD_GNK_SKK_AMT");
	}
	
	/**
	 * 減価償却費(4年以内)を取得.
	 * 
	 * @return 減価償却費(4年以内)
	 */
	public long getGenkaSyokyakuWithinFourYears() {
		return super.getLong("FOURTH_GNK_SKK_AMT");
	}
	
	/**
	 * 減価償却費(5年以内)を取得.
	 * 
	 * @return 減価償却費(5年以内)
	 */
	public long getGenkaSyokyakuWithinFiveYears() {
		return super.getLong("FIFTH_GNK_SKK_AMT");
	}
	
	/**
	 * 減価償却費(5年超)を取得.
	 * 
	 * @return 減価償却費(5年超)
	 */
	public long getGenkaSyokyakuOverFiveYears() {
		return super.getLong("OVER_FIFTH_GNK_SKK_AMT");
	}
	
	/**
	 * 減価償却費(合計)を取得.
	 * 
	 * @return 減価償却費(合計)
	 */
	public String getGenkaSyokyakuTotal() {
		return super.getString("TOTAL_GNK_SKK_AMT");
	}
	
	/**
	 * 簿価(1年以内)を取得.
	 * 
	 * @return 簿価(1年以内)
	 */
	public long getBokaWithinOneYear() {
		return super.getLong("FIRST_BOKA_AMT");
	}
	
	/**
	 * 簿価(2年以内)を取得.
	 * 
	 * @return 簿価(2年以内)
	 */
	public long getBokaWithinTwoYears() {
		return super.getLong("SECOND_BOKA_AMT");
	}
	
	/**
	 * 簿価(3年以内)を取得.
	 * 
	 * @return 簿価(3年以内)
	 */
	public long getBokaWithinThreeYears() {
		return super.getLong("THIRD_BOKA_AMT");
	}
	
	/**
	 * 簿価(4年以内)を取得.
	 * 
	 * @return 簿価(4年以内)
	 */
	public long getBokaWithinFourYears() {
		return super.getLong("FOURTH_BOKA_AMT");
	}
	
	/**
	 * 簿価(5年以内)を取得.
	 * 
	 * @return 簿価(5年以内)
	 */
	public long getBokaWithinFiveYears() {
		return super.getLong("FIFTH_BOKA_AMT");
	}
	
	/**
	 * 簿価(5年超)を取得.
	 * 
	 * @return 簿価(5年超)
	 */
	public long getBokaWithinOverFiveYears() {
		return super.getLong("OVER_FIFTH_BOKA_AMT");
	}
	
	/**
	 * 簿価(合計)を取得.
	 * 
	 * @return 簿価(合計)
	 */
	public long getBokaTotal() {
		return super.getLong("TOTAL_BOKA_AMT");
	}
	
	
	
	
	

}
