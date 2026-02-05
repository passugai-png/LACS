package jp.co.pro_app.lacs.affairs.ukebarai.data.entity;

import java.util.Iterator;
import java.util.LinkedHashMap;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 費用受払表Entity.
 * 
 * @author active
 * @version 20080811
 */
public class LACSUkebaraiHiyoEntity extends EntityBase {

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
	public LACSUkebaraiHiyoEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSUkebaraiBean piUkebaraiBean) {
		super(piModel);

		this.cosmosCode = piUkebaraiBean.getLeasCompany().getValue();

		this.dateFrom = piUkebaraiBean.getTermFrom().getYYYYMMDD();

		this.term = piUkebaraiBean.getTsukiSu();
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		LinkedHashMap<String, String> hash = new LinkedHashMap<String, String>();
		Iterator<String> itr = null;
		boolean firstSw = true;
		String key = "";
		String col = "";

		hash.put("ENT_SHOHYO_KZI", "1"); // 登録諸費用（課税）
		hash.put("ENT_SHOHYO_HKZI", "2"); // 登録諸費用（非課税）
		hash.put("GTAX", "3"); // 取得税
		hash.put("CTAX", "4"); // 自動車税
		hash.put("JTAX", "5"); // 重量税
		hash.put("JBSK_HKN", "6"); // 自賠責保険
		hash.put("NNI_HKN", "7"); // 任意保険
		hash.put("RCYCL_RYO_KNRI_AMT", "8"); // リサイクル料管理費
		hash.put("DOSO", "9"); // 動総
		hash.put("KOZEI", "10"); // 固税
		hash.put("OTH_CST", "11"); // その他原価
		hash.put("IPN_EKM_TEIK_HYO", "12"); // 一般用役務提供費
		hash.put("SHRY_EKM_TEIK_HYO", "12"); // 車両用役務提供費

		super.sql.append("SELECT TBL2.LC_CD BRAKE_KEY1 " + "\n");
		super.sql.append("      ,TBL2.LC_CD || K.TAISHO_AC_KIJYUN_CD BRAKE_KEY2 " + "\n");
		super.sql.append("      ,TBL2.LC_CD || K.TAISHO_AC_KIJYUN_CD || K.TRD_HNTE_KEKA_KBN BRAKE_KEY3 " + "\n");
		super.sql.append("      ,TBL2.LC_CD || K.TAISHO_AC_KIJYUN_CD || K.TRD_HNTE_KEKA_KBN || K.CTSHK_FLG BRAKE_KEY4 " + "\n");
		super.sql.append("      ,TBL2.LC_CD || K.TAISHO_AC_KIJYUN_CD || K.TRD_HNTE_KEKA_KBN || K.CTSHK_FLG || TBL2.KAMOKU_CD BRAKE_KEY5 " + "\n");
		super.sql.append("      ,TO_CHAR(SYSDATE,'YYYYMMDD') CREATE_DATE -- 作成日" + "\n");
		super.sql.append("      ,'" + this.dateFrom + "' KIKAN_START -- 対象期間開始" + "\n");
		super.sql.append("      ,TO_CHAR(ADD_MONTHS(TO_DATE('" + this.dateFrom + "','YYYYMMDD') -1, " + this.term + "), 'YYYYMMDD') KIKAN_END -- 対象期間終了" + "\n");
		super.sql.append("      ,TBL2.LC_CD " + "\n");
		super.sql.append("      ,DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_NM, LU.PDF_COMPANY_NM) LC_NM " + "\n");
		super.sql.append("      ,K.LU_COSMOS_CD " + "\n");
		super.sql.append("      ,LU.LU_NM " + "\n");

		super.sql.append("      ,K.TAISHO_AC_KIJYUN_CD " + "\n");
		super.sql.append("      ,K.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("      ,K.CTSHK_FLG " + "\n");
		super.sql.append("      ,TBL2.KAMOKU_CD " + "\n");

		super.sql.append("      ,K.HYJYO_KEI_NO KEI_NO " + "\n");
		super.sql.append("      ,TBL2.BKN_NO " + "\n");
		super.sql.append("      ,TBL2.BKN_EDANO " + "\n");
		super.sql.append("      ,TBL2.KAMOKU_CD " + "\n");
		super.sql.append("      ,TBL2.SOU SOUGAKU_AMT " + "\n");
		super.sql.append("      ,TBL2.ZENKI ZENKI_MATU_AMT " + "\n");
		super.sql.append("      ,TBL2.TOUKI TOUKI_AMT " + "\n");
		super.sql.append("      ,TBL2.GEN TOUKI_GEN_AMT " + "\n");
		super.sql.append("      ,TBL2.ZENKI + TBL2.TOUKI - TBL2.GEN TOUKI_MATU_AMT " + "\n");
		super.sql.append("      ,DECODE(K.TAISHO_AC_KIJYUN_CD, '0', '旧リース会計基準', '新リース会計基準') TAISHO_AC_KIJYUN_NM " + "\n");
		super.sql.append("      ,TRD.TRD_HNTE_KEKA_NM " + "\n");
		super.sql.append("      ,'売買処理' AC_SHR_NM " + "\n");
		super.sql.append("      ,KMK.KAMOKU_NM " + "\n");
		super.sql.append("      ,B.BKN_NM " + "\n");
		super.sql.append("      ,K.KNSHU_YMD " + "\n");
		super.sql.append("      ,K.MRYO_YMD " + "\n");
		super.sql.append("      ,K.KAI_YMD " + "\n");

		super.sql.append("FROM   (SELECT TBL.LC_CD " + "\n");
		super.sql.append("              ,TBL.KEI_NO " + "\n");
		super.sql.append("              ,TBL.BKN_NO " + "\n");
		super.sql.append("              ,TBL.BKN_EDANO " + "\n");
		super.sql.append("              ,KAMOKU_CD " + "\n");
		super.sql.append("              ,SUM(SOU) SOU " + "\n");
		super.sql.append("              ,SUM(ZENKI) ZENKI " + "\n");
		super.sql.append("              ,SUM(TOUKI) TOUKI " + "\n");
		super.sql.append("              ,SUM(GEN) GEN " + "\n");
		super.sql.append("        FROM   ( " + "\n");

		itr = hash.keySet().iterator();

		super.sql.append("                /*汎用部分ここから*/ " + "\n");
		while (itr.hasNext()) {
			col = itr.next().toString();
			key = hash.get(col).toString();

			if (firstSw) {
				firstSw = false;
			}
			else {
				super.sql.append("                UNION ALL " + "\n");
			}

			super.sql.append("SELECT BSE.LC_CD -- リース会社コード " + "\n");
			super.sql.append("      ,BSE.KEI_NO -- 契約番号 " + "\n");
			super.sql.append("      ,BSE.BKN_NO -- 物件番号 " + "\n");
			super.sql.append("      ,BSE.BKN_EDANO -- 物件番号枝番 " + "\n");
			super.sql.append("      ," + key + " KAMOKU_CD " + "\n");
			super.sql.append("      ,UKB_HEAD.KEIJ_YM " + "\n");
			super.sql.append("      ,NVL(SOU_" + col + ", 0) SOU --総額 " + "\n");
			super.sql.append("      ,0 ZENKI --前期末 " + "\n");
			super.sql.append("      ,0 TOUKI --当期 " + "\n");
			super.sql.append("      ,0 GEN " + "\n");
			super.sql.append("FROM   (SELECT KEI.LC_CD -- リース会社コード " + "\n");
			super.sql.append("              ,KEI.KEI_NO -- 契約番号 " + "\n");
			super.sql.append("              ,BKN.BKN_NO -- 物件番号 " + "\n");
			super.sql.append("              ,BKN.BKN_EDANO -- 物件番号枝番 " + "\n");
			super.sql.append("              ,BKN.RSK_KEIJ_HOHO_KBN -- 採用利息計上方法区分 " + "\n");
			super.sql.append("              ,KEI.CTSHK_FLG " + "\n");
			super.sql.append("              ,KEI.KAI_YMD " + "\n");
			super.sql.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', '" + this.dateFrom + "') STR_KEIJ_YM -- 対象期間開始年月 " + "\n");
			super.sql.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', LACS_COMMON.GET_TERM_DATE(SUBSTR('" + this.dateFrom + "', 1, 6) || '01', " + this.term + ")) END_KEIJ_YM -- 対象期間終了年月 " + "\n");
			super.sql.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', KEI.MRYO_YMD) MRYO_KEIJ_YM -- 満了計上年月 " + "\n");
			// 20210609 arai 再リース契約除外対応 start
			super.sql.append("              ,KEI.RLS_TMS " + "\n");
			// 20210609 arai 再リース契約除外対応 end		
			super.sql.append("        FROM   T_KEI KEI " + "\n");
			super.sql.append("              ,T_BKN BKN " + "\n");
			super.sql.append("        WHERE  KEI.LC_CD = BKN.LC_CD " + "\n");
			super.sql.append("        AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
			super.sql.append("        AND    KEI.CTSHK_FLG = '0' " + "\n");
			super.sql.append("        AND    KEI.LC_CD = 'LACS' " + "\n");
			super.sql.append("        AND    KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
			super.sql.append("        AND    KEI.ERR_FLG      = '0' " + "\n");
			// 20210609 arai 再リース契約除外対応 start
			super.sql.append("        AND    KEI.RLS_TMS            = 0 " + "\n");
			// 20210609 arai 再リース契約除外対応 end	
			super.sql.append("        AND    BKN.RSK_KEIJ_HOHO_KBN IN ('101', '102', '301')) BSE " + "\n");
			super.sql.append("      ,(SELECT HEAD.LC_CD -- リース会社コード " + "\n");
			super.sql.append("              ,HEAD.KEI_NO -- 契約番号 " + "\n");
			super.sql.append("              ,HEAD.BKN_NO -- 物件番号 " + "\n");
			super.sql.append("              ,HEAD.BKN_EDANO -- 物件番号枝番 " + "\n");
			super.sql.append("              ,MIN(HEAD.KEIJ_YM) MIN_KEIJ_YM -- 最小計上年月 " + "\n");
			super.sql.append("              ,MAX(HEAD.KEIJ_YM) MAX_KEIJ_YM -- 最大計上年月 " + "\n");
			super.sql.append("        FROM   T_KEI           KEI " + "\n");
			super.sql.append("              ,T_BKN           BKN " + "\n");
			super.sql.append("              ,T_UKB_TNKI_HEAD HEAD " + "\n");
			super.sql.append("        WHERE  KEI.LC_CD = BKN.LC_CD " + "\n");
			super.sql.append("        AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
			super.sql.append("        AND    HEAD.LC_CD = BKN.LC_CD " + "\n");
			super.sql.append("        AND    HEAD.KEI_NO = BKN.KEI_NO " + "\n");
			super.sql.append("        AND    HEAD.BKN_NO = BKN.BKN_NO " + "\n");
			super.sql.append("        AND    HEAD.BKN_EDANO = BKN.BKN_EDANO " + "\n");
			super.sql.append("        AND    KEI.CTSHK_FLG = '0' " + "\n");
			super.sql.append("        AND    KEI.LC_CD = 'LACS' " + "\n");
			super.sql.append("        AND    KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
			super.sql.append("        AND    KEI.ERR_FLG      = '0' " + "\n");
			super.sql.append("        AND    BKN.RSK_KEIJ_HOHO_KBN IN ('101', '102', '301') " + "\n");
			super.sql.append("        AND    HEAD.KAI_REC_FLG = '0' " + "\n");
			super.sql.append("        GROUP  BY HEAD.LC_CD " + "\n");
			super.sql.append("                 ,HEAD.KEI_NO " + "\n");
			super.sql.append("                 ,HEAD.BKN_NO " + "\n");
			super.sql.append("                 ,HEAD.BKN_EDANO) WHEAD " + "\n");
			super.sql.append("      ,T_UKB_TNKI_HEAD UKB_HEAD " + "\n");
			super.sql.append("WHERE  UKB_HEAD.LC_CD = BSE.LC_CD " + "\n");
			super.sql.append("AND    UKB_HEAD.KEI_NO = BSE.KEI_NO " + "\n");
			super.sql.append("AND    UKB_HEAD.BKN_NO = BSE.BKN_NO " + "\n");
			super.sql.append("AND    UKB_HEAD.BKN_EDANO = BSE.BKN_EDANO " + "\n");
			super.sql.append("AND    UKB_HEAD.KEIJ_YM = LEAST(BSE.END_KEIJ_YM, WHEAD.MAX_KEIJ_YM) " + "\n");
			super.sql.append("AND    BSE.LC_CD = WHEAD.LC_CD " + "\n");
			super.sql.append("AND    BSE.KEI_NO = WHEAD.KEI_NO " + "\n");
			super.sql.append("AND    BSE.BKN_NO = WHEAD.BKN_NO " + "\n");
			super.sql.append("AND    BSE.BKN_EDANO = WHEAD.BKN_EDANO " + "\n");
			super.sql.append("AND    BSE.END_KEIJ_YM >= WHEAD.MIN_KEIJ_YM " + "\n");
			super.sql.append("AND    BSE.STR_KEIJ_YM <= CASE WHEN BSE.KAI_YMD IS NOT NULL THEN WHEAD.MAX_KEIJ_YM ELSE GREATEST(WHEAD.MAX_KEIJ_YM, MRYO_KEIJ_YM) END " + "\n");	
			super.sql.append("UNION ALL " + "\n");
			super.sql.append("SELECT BSE.LC_CD -- リース会社コード " + "\n");
			super.sql.append("      ,BSE.KEI_NO -- 契約番号 " + "\n");
			super.sql.append("      ,BSE.BKN_NO -- 物件番号 " + "\n");
			super.sql.append("      ,BSE.BKN_EDANO -- 物件番号枝番 " + "\n");
			super.sql.append("      ," + key + " KAMOKU_CD " + "\n");
			super.sql.append("      ,UKB_HEAD.KEIJ_YM " + "\n");
			super.sql.append("      ,0 SOU --総額 " + "\n");
			super.sql.append("      ,NVL(UKB_HEAD.RUI_" + col + ", 0) ZENKI --前期末 " + "\n");
			super.sql.append("      ,0 TOUKI --当期 " + "\n");
			super.sql.append("      ,0 GEN " + "\n");
			super.sql.append("FROM   (SELECT KEI.LC_CD -- リース会社コード " + "\n");
			super.sql.append("              ,KEI.KEI_NO -- 契約番号 " + "\n");
			super.sql.append("              ,BKN.BKN_NO -- 物件番号 " + "\n");
			super.sql.append("              ,BKN.BKN_EDANO -- 物件番号枝番 " + "\n");
			super.sql.append("              ,BKN.RSK_KEIJ_HOHO_KBN -- 採用利息計上方法区分 " + "\n");
			super.sql.append("              ,KEI.CTSHK_FLG " + "\n");
			super.sql.append("              ,KEI.KAI_YMD " + "\n");
			super.sql.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', '" + this.dateFrom + "') STR_KEIJ_YM -- 対象期間開始年月 " + "\n");
			super.sql.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', LACS_COMMON.GET_TERM_DATE(SUBSTR('" + this.dateFrom + "', 1, 6) || '01', " + this.term + ")) END_KEIJ_YM -- 対象期間終了年月 " + "\n");
			super.sql.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', KEI.MRYO_YMD) MRYO_KEIJ_YM -- 満了計上年月 " + "\n");
			// 20210609 arai 再リース契約除外対応 start
			super.sql.append("              ,KEI.RLS_TMS " + "\n");
			// 20210609 arai 再リース契約除外対応 end	
			super.sql.append("        FROM   T_KEI KEI " + "\n");
			super.sql.append("              ,T_BKN BKN " + "\n");
			super.sql.append("        WHERE  KEI.LC_CD = BKN.LC_CD " + "\n");
			super.sql.append("        AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
			super.sql.append("        AND    KEI.CTSHK_FLG = '0' " + "\n");
			super.sql.append("        AND    KEI.LC_CD = 'LACS' " + "\n");
			super.sql.append("        AND    KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
			super.sql.append("        AND    KEI.ERR_FLG      = '0' " + "\n");
			// 20210609 arai 再リース契約除外対応 start
			super.sql.append("        AND    KEI.RLS_TMS      = 0 " + "\n");
			// 20210609 arai 再リース契約除外対応 end
			super.sql.append("        AND    BKN.RSK_KEIJ_HOHO_KBN IN ('101', '102', '301')) BSE " + "\n");
			super.sql.append("      ,(SELECT HEAD.LC_CD -- リース会社コード " + "\n");
			super.sql.append("              ,HEAD.KEI_NO -- 契約番号 " + "\n");
			super.sql.append("              ,HEAD.BKN_NO -- 物件番号 " + "\n");
			super.sql.append("              ,HEAD.BKN_EDANO -- 物件番号枝番 " + "\n");
			super.sql.append("              ,MIN(HEAD.KEIJ_YM) MIN_KEIJ_YM -- 最小計上年月 " + "\n");
			super.sql.append("              ,MAX(HEAD.KEIJ_YM) MAX_KEIJ_YM -- 最大計上年月 " + "\n");
			super.sql.append("        FROM   T_KEI           KEI " + "\n");
			super.sql.append("              ,T_BKN           BKN " + "\n");
			super.sql.append("              ,T_UKB_TNKI_HEAD HEAD " + "\n");
			super.sql.append("        WHERE  KEI.LC_CD = BKN.LC_CD " + "\n");
			super.sql.append("        AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
			super.sql.append("        AND    HEAD.LC_CD = BKN.LC_CD " + "\n");
			super.sql.append("        AND    HEAD.KEI_NO = BKN.KEI_NO " + "\n");
			super.sql.append("        AND    HEAD.BKN_NO = BKN.BKN_NO " + "\n");
			super.sql.append("        AND    HEAD.BKN_EDANO = BKN.BKN_EDANO " + "\n");
			super.sql.append("        AND    KEI.CTSHK_FLG = '0' " + "\n");
			super.sql.append("        AND    KEI.LC_CD = 'LACS' " + "\n");
			super.sql.append("        AND    KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
			super.sql.append("        AND    KEI.ERR_FLG      = '0' " + "\n");
			super.sql.append("        AND    BKN.RSK_KEIJ_HOHO_KBN IN ('101', '102', '301') " + "\n");
			super.sql.append("        AND    HEAD.KAI_REC_FLG = '0' " + "\n");
			super.sql.append("        GROUP  BY HEAD.LC_CD " + "\n");
			super.sql.append("                 ,HEAD.KEI_NO " + "\n");
			super.sql.append("                 ,HEAD.BKN_NO " + "\n");
			super.sql.append("                 ,HEAD.BKN_EDANO) WHEAD " + "\n");
			super.sql.append("      ,T_UKB_TNKI_HEAD UKB_HEAD " + "\n");
			super.sql.append("WHERE  UKB_HEAD.LC_CD = BSE.LC_CD " + "\n");
			super.sql.append("AND    UKB_HEAD.KEI_NO = BSE.KEI_NO " + "\n");
			super.sql.append("AND    UKB_HEAD.BKN_NO = BSE.BKN_NO " + "\n");
			super.sql.append("AND    UKB_HEAD.BKN_EDANO = BSE.BKN_EDANO " + "\n");
			super.sql.append("AND    UKB_HEAD.KEIJ_YM = LEAST(LACS_COMMON.ADD_MONTHS_YM(BSE.STR_KEIJ_YM, -1), WHEAD.MAX_KEIJ_YM) " + "\n");
			super.sql.append("AND    BSE.LC_CD = WHEAD.LC_CD " + "\n");
			super.sql.append("AND    BSE.KEI_NO = WHEAD.KEI_NO " + "\n");
			super.sql.append("AND    BSE.BKN_NO = WHEAD.BKN_NO " + "\n");
			super.sql.append("AND    BSE.BKN_EDANO = WHEAD.BKN_EDANO " + "\n");
			super.sql.append("AND    BSE.END_KEIJ_YM >= WHEAD.MIN_KEIJ_YM " + "\n");
			super.sql.append("AND    BSE.STR_KEIJ_YM <= CASE WHEN BSE.KAI_YMD IS NOT NULL THEN WHEAD.MAX_KEIJ_YM ELSE GREATEST(WHEAD.MAX_KEIJ_YM, MRYO_KEIJ_YM) END " + "\n");
			super.sql.append("UNION ALL " + "\n");
			super.sql.append("SELECT BSE.LC_CD -- リース会社コード " + "\n");
			super.sql.append("      ,BSE.KEI_NO -- 契約番号 " + "\n");
			super.sql.append("      ,BSE.BKN_NO -- 物件番号 " + "\n");
			super.sql.append("      ,BSE.BKN_EDANO -- 物件番号枝番 " + "\n");
			super.sql.append("      ," + key + " KAMOKU_CD " + "\n");
			super.sql.append("      ,UKB_HEAD.KEIJ_YM " + "\n");
			super.sql.append("      ,0 SOU --総額 " + "\n");
			super.sql.append("      ,0 ZENKI --前期末 " + "\n");
			super.sql.append("      ,NVL(" + col + ", 0) TOUKI --当期 " + "\n");
			super.sql.append("      ,CASE " + "\n");
			super.sql.append("           WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
			super.sql.append("            CASE " + "\n");
			super.sql.append("           WHEN WHEAD.MAX_KEIJ_YM = UKB_HEAD.KEIJ_YM THEN " + "\n");
			super.sql.append("            NVL(UKB_HEAD.RUI_" + col + ", 0) " + "\n");
			super.sql.append("           ELSE " + "\n");
			super.sql.append("            0 " + "\n");
			super.sql.append("       END ELSE 0 END GEN " + "\n");
			super.sql.append("FROM   (SELECT KEI.LC_CD -- リース会社コード " + "\n");
			super.sql.append("              ,KEI.KEI_NO -- 契約番号 " + "\n");
			super.sql.append("              ,BKN.BKN_NO -- 物件番号 " + "\n");
			super.sql.append("              ,BKN.BKN_EDANO -- 物件番号枝番 " + "\n");
			super.sql.append("              ,BKN.RSK_KEIJ_HOHO_KBN -- 採用利息計上方法区分 " + "\n");
			super.sql.append("              ,KEI.CTSHK_FLG " + "\n");
			super.sql.append("              ,KEI.KAI_YMD " + "\n");
			super.sql.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', '" + this.dateFrom + "') STR_KEIJ_YM -- 対象期間開始年月 " + "\n");
			super.sql.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', LACS_COMMON.GET_TERM_DATE(SUBSTR('" + this.dateFrom + "', 1, 6) || '01', " + this.term + ")) END_KEIJ_YM -- 対象期間終了年月 " + "\n");
			super.sql.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', KEI.MRYO_YMD) MRYO_KEIJ_YM -- 満了計上年月 " + "\n");
			// 20210609 arai 再リース契約除外対応 start
			super.sql.append("              ,KEI.RLS_TMS " + "\n");
			// 20210609 arai 再リース契約除外対応 end
			super.sql.append("        FROM   T_KEI KEI " + "\n");
			super.sql.append("              ,T_BKN BKN " + "\n");
			super.sql.append("        WHERE  KEI.LC_CD = BKN.LC_CD " + "\n");
			super.sql.append("        AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
			super.sql.append("        AND    KEI.CTSHK_FLG = '0' " + "\n");
			super.sql.append("        AND    KEI.LC_CD = 'LACS' " + "\n");
			super.sql.append("        AND    KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
			super.sql.append("        AND    KEI.ERR_FLG      = '0' " + "\n");
			// 20210609 arai 再リース契約除外対応 start
			super.sql.append("        AND    KEI.RLS_TMS      = 0 " + "\n");	
			// 20210609 arai 再リース契約除外対応 start			
			super.sql.append("        AND    BKN.RSK_KEIJ_HOHO_KBN IN ('101', '102', '301')) BSE " + "\n");
			super.sql.append("      ,(SELECT HEAD.LC_CD -- リース会社コード " + "\n");
			super.sql.append("              ,HEAD.KEI_NO -- 契約番号 " + "\n");
			super.sql.append("              ,HEAD.BKN_NO -- 物件番号 " + "\n");
			super.sql.append("              ,HEAD.BKN_EDANO -- 物件番号枝番 " + "\n");
			super.sql.append("              ,MIN(HEAD.KEIJ_YM) MIN_KEIJ_YM -- 最小計上年月 " + "\n");
			super.sql.append("              ,MAX(HEAD.KEIJ_YM) MAX_KEIJ_YM -- 最大計上年月 " + "\n");
			super.sql.append("        FROM   T_KEI           KEI " + "\n");
			super.sql.append("              ,T_BKN           BKN " + "\n");
			super.sql.append("              ,T_UKB_TNKI_HEAD HEAD " + "\n");
			super.sql.append("        WHERE  KEI.LC_CD = BKN.LC_CD " + "\n");
			super.sql.append("        AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
			super.sql.append("        AND    HEAD.LC_CD = BKN.LC_CD " + "\n");
			super.sql.append("        AND    HEAD.KEI_NO = BKN.KEI_NO " + "\n");
			super.sql.append("        AND    HEAD.BKN_NO = BKN.BKN_NO " + "\n");
			super.sql.append("        AND    HEAD.BKN_EDANO = BKN.BKN_EDANO " + "\n");
			super.sql.append("        AND    KEI.CTSHK_FLG = '0' " + "\n");
			super.sql.append("        AND    KEI.LC_CD = 'LACS' " + "\n");
			super.sql.append("        AND    KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
			super.sql.append("        AND    KEI.ERR_FLG      = '0' " + "\n");
			super.sql.append("        AND    BKN.RSK_KEIJ_HOHO_KBN IN ('101', '102', '301') " + "\n");
			super.sql.append("        AND    HEAD.KAI_REC_FLG = '0' " + "\n");
			super.sql.append("        GROUP  BY HEAD.LC_CD " + "\n");
			super.sql.append("                 ,HEAD.KEI_NO " + "\n");
			super.sql.append("                 ,HEAD.BKN_NO " + "\n");
			super.sql.append("                 ,HEAD.BKN_EDANO) WHEAD " + "\n");
			super.sql.append("      ,T_UKB_TNKI_HEAD UKB_HEAD " + "\n");
			super.sql.append("WHERE  UKB_HEAD.LC_CD = BSE.LC_CD " + "\n");
			super.sql.append("AND    UKB_HEAD.KEI_NO = BSE.KEI_NO " + "\n");
			super.sql.append("AND    UKB_HEAD.BKN_NO = BSE.BKN_NO " + "\n");
			super.sql.append("AND    UKB_HEAD.BKN_EDANO = BSE.BKN_EDANO " + "\n");
			super.sql.append("AND    UKB_HEAD.KEIJ_YM BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM " + "\n");
			super.sql.append("AND    BSE.LC_CD = WHEAD.LC_CD " + "\n");
			super.sql.append("AND    BSE.KEI_NO = WHEAD.KEI_NO " + "\n");
			super.sql.append("AND    BSE.BKN_NO = WHEAD.BKN_NO " + "\n");
			super.sql.append("AND    BSE.BKN_EDANO = WHEAD.BKN_EDANO " + "\n");
			super.sql.append("AND    BSE.END_KEIJ_YM >= WHEAD.MIN_KEIJ_YM " + "\n");
			super.sql.append("AND    BSE.STR_KEIJ_YM <= CASE WHEN BSE.KAI_YMD IS NOT NULL THEN WHEAD.MAX_KEIJ_YM ELSE GREATEST(WHEAD.MAX_KEIJ_YM, MRYO_KEIJ_YM) END " + "\n");
			super.sql.append("UNION ALL " + "\n");
			super.sql.append("SELECT BSE.LC_CD -- リース会社コード " + "\n");
			super.sql.append("      ,BSE.KEI_NO -- 契約番号 " + "\n");
			super.sql.append("      ,BSE.BKN_NO -- 物件番号 " + "\n");
			super.sql.append("      ,BSE.BKN_EDANO -- 物件番号枝番 " + "\n");
			super.sql.append("      ," + key + " KAMOKU_CD " + "\n");
			super.sql.append("      ,UKB_HEAD.KEIJ_YM " + "\n");
			super.sql.append("      ,0 SOU --総額 " + "\n");
			super.sql.append("      ,0 ZENKI --前期末 " + "\n");
			super.sql.append("      ,0 TOUKI --当期 " + "\n");
			super.sql.append("      ,CASE " + "\n");
			super.sql.append("           WHEN BSE.KAI_YMD IS NOT NULL THEN " + "\n");
			super.sql.append("            0 " + "\n");
			super.sql.append("           ELSE " + "\n");
			super.sql.append("            NVL(UKB_HEAD.RUI_" + col + ", 0) " + "\n");
			super.sql.append("       END GEN " + "\n");
			super.sql.append("FROM   (SELECT KEI.LC_CD -- リース会社コード " + "\n");
			super.sql.append("              ,KEI.KEI_NO -- 契約番号 " + "\n");
			super.sql.append("              ,BKN.BKN_NO -- 物件番号 " + "\n");
			super.sql.append("              ,BKN.BKN_EDANO -- 物件番号枝番 " + "\n");
			super.sql.append("              ,BKN.RSK_KEIJ_HOHO_KBN -- 採用利息計上方法区分 " + "\n");
			super.sql.append("              ,KEI.CTSHK_FLG " + "\n");
			super.sql.append("              ,KEI.KAI_YMD " + "\n");
			super.sql.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', '" + this.dateFrom + "') STR_KEIJ_YM -- 対象期間開始年月 " + "\n");
			super.sql.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', LACS_COMMON.GET_TERM_DATE(SUBSTR('" + this.dateFrom + "', 1, 6) || '01', " + this.term + ")) END_KEIJ_YM -- 対象期間終了年月 " + "\n");
			super.sql.append("              ,LACS_COMMON.GET_KEIJ_YYYYMM(KEI.KNSHU_YMD, '" + this.dateFrom + "', KEI.MRYO_YMD) MRYO_KEIJ_YM -- 満了計上年月 " + "\n");
			// 20210609 arai 再リース契約除外対応 start
			super.sql.append("              ,KEI.RLS_TMS " + "\n");
			// 20210609 arai 再リース契約除外対応 end	
			super.sql.append("        FROM   T_KEI KEI " + "\n");
			super.sql.append("              ,T_BKN BKN " + "\n");
			super.sql.append("        WHERE  KEI.LC_CD = BKN.LC_CD " + "\n");
			super.sql.append("        AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
			super.sql.append("        AND    KEI.CTSHK_FLG = '0' " + "\n");
			super.sql.append("        AND    KEI.LC_CD = 'LACS' " + "\n");
			super.sql.append("        AND    KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
			super.sql.append("        AND    KEI.ERR_FLG      = '0' " + "\n");
			// 20210609 arai 再リース契約除外対応 start
			super.sql.append("        AND    KEI.RLS_TMS      = 0 " + "\n");	
			// 20210609 arai 再リース契約除外対応 start			
			super.sql.append("        AND    BKN.RSK_KEIJ_HOHO_KBN IN ('101', '102', '301')) BSE " + "\n");
			super.sql.append("      ,(SELECT HEAD.LC_CD -- リース会社コード " + "\n");
			super.sql.append("              ,HEAD.KEI_NO -- 契約番号 " + "\n");
			super.sql.append("              ,HEAD.BKN_NO -- 物件番号 " + "\n");
			super.sql.append("              ,HEAD.BKN_EDANO -- 物件番号枝番 " + "\n");
			super.sql.append("              ,MIN(HEAD.KEIJ_YM) MIN_KEIJ_YM -- 最小計上年月 " + "\n");
			super.sql.append("              ,MAX(HEAD.KEIJ_YM) MAX_KEIJ_YM -- 最大計上年月 " + "\n");
			super.sql.append("        FROM   T_KEI           KEI " + "\n");
			super.sql.append("              ,T_BKN           BKN " + "\n");
			super.sql.append("              ,T_UKB_TNKI_HEAD HEAD " + "\n");
			super.sql.append("        WHERE  KEI.LC_CD = BKN.LC_CD " + "\n");
			super.sql.append("        AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
			super.sql.append("        AND    HEAD.LC_CD = BKN.LC_CD " + "\n");
			super.sql.append("        AND    HEAD.KEI_NO = BKN.KEI_NO " + "\n");
			super.sql.append("        AND    HEAD.BKN_NO = BKN.BKN_NO " + "\n");
			super.sql.append("        AND    HEAD.BKN_EDANO = BKN.BKN_EDANO " + "\n");
			super.sql.append("        AND    KEI.CTSHK_FLG = '0' " + "\n");
			super.sql.append("        AND    KEI.LC_CD = 'LACS' " + "\n");
			super.sql.append("        AND    KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n");
			super.sql.append("        AND    KEI.ERR_FLG      = '0' " + "\n");
			super.sql.append("        AND    BKN.RSK_KEIJ_HOHO_KBN IN ('101', '102', '301') " + "\n");
			super.sql.append("        AND    HEAD.KAI_REC_FLG = '0' " + "\n");
			super.sql.append("        GROUP  BY HEAD.LC_CD " + "\n");
			super.sql.append("                 ,HEAD.KEI_NO " + "\n");
			super.sql.append("                 ,HEAD.BKN_NO " + "\n");
			super.sql.append("                 ,HEAD.BKN_EDANO) WHEAD " + "\n");
			super.sql.append("      ,T_UKB_TNKI_HEAD UKB_HEAD " + "\n");
			super.sql.append("WHERE  UKB_HEAD.LC_CD = BSE.LC_CD " + "\n");
			super.sql.append("AND    UKB_HEAD.KEI_NO = BSE.KEI_NO " + "\n");
			super.sql.append("AND    UKB_HEAD.BKN_NO = BSE.BKN_NO " + "\n");
			super.sql.append("AND    UKB_HEAD.BKN_EDANO = BSE.BKN_EDANO " + "\n");
			super.sql.append("AND    GREATEST(MRYO_KEIJ_YM, WHEAD.MAX_KEIJ_YM) BETWEEN BSE.STR_KEIJ_YM AND BSE.END_KEIJ_YM " + "\n");
			super.sql.append("AND    BSE.LC_CD = WHEAD.LC_CD " + "\n");
			super.sql.append("AND    BSE.KEI_NO = WHEAD.KEI_NO " + "\n");
			super.sql.append("AND    BSE.BKN_NO = WHEAD.BKN_NO " + "\n");
			super.sql.append("AND    BSE.BKN_EDANO = WHEAD.BKN_EDANO " + "\n");
			super.sql.append("AND    WHEAD.MAX_KEIJ_YM = UKB_HEAD.KEIJ_YM " + "\n");
			super.sql.append("AND    BSE.KAI_YMD IS NULL " + "\n");
		}

		super.sql.append("                /*汎用部分ここまで*/ " + "\n");

		super.sql.append("                ) TBL " + "\n");
		super.sql.append("        GROUP  BY TBL.LC_CD " + "\n");
		super.sql.append("                 ,TBL.KEI_NO " + "\n");
		super.sql.append("                 ,TBL.BKN_NO " + "\n");
		super.sql.append("                 ,TBL.BKN_EDANO " + "\n");
		super.sql.append("                 ,KAMOKU_CD) TBL2 " + "\n");
		super.sql.append("JOIN   T_KEI K ON  TBL2.LC_CD = K.LC_CD " + "\n");
		super.sql.append("               AND TBL2.KEI_NO = K.KEI_NO " + "\n");
		super.sql.append("JOIN   T_BKN B ON  TBL2.LC_CD = B.LC_CD " + "\n");
		super.sql.append("               AND TBL2.KEI_NO = B.KEI_NO " + "\n");
		super.sql.append("               AND TBL2.BKN_NO = B.BKN_NO " + "\n");
		super.sql.append("               AND TBL2.BKN_EDANO = B.BKN_EDANO " + "\n");
		super.sql.append("JOIN   M_LC LC ON  LC.LC_CD = 'LACS' " + "\n");
		super.sql.append("JOIN   M_LU LU ON  LU.LU_COSMOS_CD = K.LU_COSMOS_CD " + "\n");
		super.sql.append("JOIN   M_TRD_HNTE_KEKA_KBN TRD ON  TRD.TRD_HNTE_KEKA_KBN = K.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("JOIN   M_KAMOKU KMK ON KMK.KAMOKU_CD = TBL2.KAMOKU_CD " + "\n");

		super.sql.append("WHERE SOU <> 0 OR ZENKI <> 0 OR TOUKI <> 0 OR GEN <>0 " + "\n");
		super.sql.append("ORDER  BY TBL2.LC_CD " + "\n");
		super.sql.append("         ,K.TAISHO_AC_KIJYUN_CD " + "\n");
		super.sql.append("         ,K.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("         ,K.CTSHK_FLG " + "\n");
		super.sql.append("         ,TBL2.KAMOKU_CD " + "\n");
		super.sql.append("         ,K.HYJYO_KEI_NO " + "\n");
		super.sql.append("         ,TBL2.BKN_NO " + "\n");
		super.sql.append("         ,TBL2.BKN_EDANO " + "\n");

		System.out.println(sql);
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
	 * 科目名を取得.
	 * 
	 * @return 科目名
	 */
	public String getKamokuNm() {
		return super.getString("KAMOKU_NM");
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
	 * 総額を取得.
	 * 
	 * @return 総額
	 */
	public long getSougakuAmt() {
		return super.getLong("SOUGAKU_AMT");
	}

	/**
	 * 前期末累計額を取得.
	 * 
	 * @return 前期末累計額
	 */
	public long getZenkiMatuAmt() {
		return super.getLong("ZENKI_MATU_AMT");
	}

	/**
	 * 当期計上高を取得.
	 * 
	 * @return 当期計上高
	 */
	public long getToukiAmt() {
		return super.getLong("TOUKI_AMT");
	}

	/**
	 * 当期減少を取得.
	 * 
	 * @return 当期減少
	 */
	public long getToukiGenAmt() {
		return super.getLong("TOUKI_GEN_AMT");
	}

	/**
	 * 当期末累計額を取得.
	 * 
	 * @return 当期末累計額
	 */
	public long getToukiMatuAmt() {
		return super.getLong("TOUKI_MATU_AMT");
	}

}
