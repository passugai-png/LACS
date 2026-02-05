package jp.co.pro_app.lacs.affairs.monthreport.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 月次帳票出力：消費税明細票 Entity.
 * 
 * @author fukuhara
 * @version 20080415
 */
public class LACSMReportSyouhizeiEntity extends LACSMReportEntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 * @param piCommonBean
	 *            LACS共通Bean
	 * @param piReportBean
	 *            帳票出力Bean
	 */
	public LACSMReportSyouhizeiEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSMReportBean piReportBean) {
		super(piModel, piCommonBean, piReportBean);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT RPAD(KB.LU_COSMOS_CD, 10, ' ') BRAKE_KEY0 " + "\n");
		super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.TAISHO_AC_KIJYUN_CD, 1, ' ') BRAKE_KEY1 " + "\n");
		super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.TAISHO_AC_KIJYUN_CD, 1, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') BRAKE_KEY2 " + "\n");
		super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.TAISHO_AC_KIJYUN_CD, 1, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG, 1, ' ') BRAKE_KEY3 " + "\n");
		super.sql.append("      ,RPAD(KB.LU_COSMOS_CD, 10, ' ') || RPAD(KB.TAISHO_AC_KIJYUN_CD, 1, ' ') || RPAD(KB.TRD_HNTE_KEKA_KBN, 1, ' ') || RPAD(KB.CTSHK_FLG, 1, ' ') || RPAD(KB.STAX_IKT_KOJ_KBN, 1, ' ') BRAKE_KEY4 " + "\n");
		super.sql.append("      ,DECODE(LU.PDF_COMPANY_NM, NULL, M_LC.LC_NM, LU.PDF_COMPANY_NM) LEASE_COMPANY " + "\n");
		super.sql.append("      ,LU.LU_NM LEASE_USER " + "\n");
		super.sql.append("      ,KB.TAISHO_AC_KIJYUN_CD TAISHO_AC_KIJYUN_CD " + "\n");
		super.sql.append("      ,DECODE(KB.TAISHO_AC_KIJYUN_CD,'0','旧リース会計基準','1','新リース会計基準') TAISHO_AC_NM " + "\n");
		super.sql.append("      ,TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("      ,TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_NM LEASE_BUNRUI " + "\n");
		super.sql.append("      ,KB.HYJYO_KEI_NO KEI_NO " + "\n");
		super.sql.append("      ,KB.KNSHU_YMD " + "\n");
		super.sql.append("      ,KB.MRYO_YMD " + "\n");
		super.sql.append("      ,KB.KEI_TERM " + "\n");
		super.sql.append("	  ,KB.BKN_NO || " + "\n");
		super.sql.append("       CASE " + "\n");
		super.sql.append("		   WHEN TRIM(KB.BKN_EDANO) IS NULL THEN " + "\n");
		super.sql.append("			'' " + "\n");
		super.sql.append("		   ELSE " + "\n");
		super.sql.append("			'-' || KB.BKN_EDANO " + "\n");
		super.sql.append("	   END BKN_NO " + "\n");
		super.sql.append("	  ,KB.BKN_NM " + "\n");
		super.sql.append("	  ,KB.KAI_YMD " + "\n");
		super.sql.append("	  ,KB.KEI_AMT + " + "\n");
		super.sql.append("       CASE " + "\n");
		super.sql.append("		   WHEN KB.LU_TRSK_CD IN (KB.IPN_ZANK_HSHOSK_CD, KB.ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("			KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("		   ELSE " + "\n");
		super.sql.append("			0 " + "\n");
		super.sql.append("	   END KEI_AMT " + "\n");
		super.sql.append("	  ,CASE " + "\n");
		super.sql.append("		   WHEN KB.LU_TRSK_CD IN (KB.IPN_ZANK_HSHOSK_CD, KB.ZANK_HSHOSK_CD) THEN " + "\n");
		super.sql.append("			KB.ZANK_HSHO_AMT " + "\n");
		super.sql.append("		   ELSE " + "\n");
		super.sql.append("			0 " + "\n");
		super.sql.append("	   END ZANK_HSHO_AMT " + "\n");
		super.sql.append("	  ,KB.KEI_AMT_STAX KEI_AMT_STAX " + "\n");
		super.sql.append("	  ,NVL((SELECT SUM(UKB_TNKI_HEAD.LAMT) " + "\n");
		super.sql.append("			FROM   T_UKB_TNKI_HEAD UKB_TNKI_HEAD " + "\n");
		super.sql.append("			WHERE  UKB_TNKI_HEAD.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("			AND    UKB_TNKI_HEAD.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("			AND    UKB_TNKI_HEAD.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("			AND    UKB_TNKI_HEAD.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("			AND    UKB_TNKI_HEAD.KEIJ_YM BETWEEN START_KEIJ_YM AND FKN_KEIJ_YM_LAST) " + "\n");
		super.sql.append("	   ,0) " + "\n");
		super.sql.append("	   LAMT " + "\n");
		super.sql.append("	  ,NVL((SELECT SUM(UKB_TNKI_HEAD.LAMT_STAX) " + "\n");
		super.sql.append("			FROM   T_UKB_TNKI_HEAD UKB_TNKI_HEAD " + "\n");
		super.sql.append("			WHERE  UKB_TNKI_HEAD.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("			AND    UKB_TNKI_HEAD.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("			AND    UKB_TNKI_HEAD.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("			AND    UKB_TNKI_HEAD.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("			AND    UKB_TNKI_HEAD.KEIJ_YM BETWEEN START_KEIJ_YM AND FKN_KEIJ_YM_LAST) " + "\n");
		super.sql.append("	   ,0) " + "\n");
		super.sql.append("	   LAMT_STAX " + "\n");
		super.sql.append("	  ,NVL((SELECT UKB_TNKI_HEAD.RUI_LAMT_STAX " + "\n");
		super.sql.append("			FROM   T_UKB_TNKI_HEAD UKB_TNKI_HEAD " + "\n");
		super.sql.append("			WHERE  UKB_TNKI_HEAD.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("			AND    UKB_TNKI_HEAD.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("			AND    UKB_TNKI_HEAD.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("			AND    UKB_TNKI_HEAD.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("			AND    UKB_TNKI_HEAD.KEIJ_YM = LEAST(FKN_KEIJ_YM_LAST, FKN_KEIJ_YM_MAX_KAI)) " + "\n");
		super.sql.append("	   ,0) " + "\n");
		super.sql.append("	   LAMT_STAX_RUI " + "\n");
		super.sql.append("	  ,CASE " + "\n");
		super.sql.append("		   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("				OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("				OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("			0 " + "\n");
		super.sql.append("		   ELSE " + "\n");
		super.sql.append("			NVL((SELECT SUM(CASE WHEN UKB_TNKI_HEAD.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN UKB_TNKI_HEAD.LAMT_STAX " + "\n");
		super.sql.append("								 ELSE UKB_TNKI_HEAD.YTE_LAMT_STAX " + "\n");
		super.sql.append("							END) " + "\n");
		super.sql.append("				FROM   T_UKB_TNKI_HEAD UKB_TNKI_HEAD " + "\n");
		super.sql.append("				WHERE  UKB_TNKI_HEAD.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("				AND    UKB_TNKI_HEAD.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("				AND    UKB_TNKI_HEAD.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("				AND    UKB_TNKI_HEAD.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("				AND    UKB_TNKI_HEAD.KEIJ_YM >= NEXT_START_KEIJ_YM) " + "\n");
		super.sql.append("			   ,0) " + "\n");
		super.sql.append("	   END MIBARI_STAX_ZAN " + "\n");
		super.sql.append("	  ,CASE " + "\n");
		super.sql.append("		   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("				OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("				OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("			0 " + "\n");
		super.sql.append("		   ELSE " + "\n");
		super.sql.append("			NVL((SELECT SUM(CASE WHEN UKB_TNKI_HEAD.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN UKB_TNKI_HEAD.LAMT_STAX " + "\n");
		super.sql.append("								 ELSE UKB_TNKI_HEAD.YTE_LAMT_STAX " + "\n");
		super.sql.append("							END) " + "\n");
		super.sql.append("				FROM   T_UKB_TNKI_HEAD UKB_TNKI_HEAD " + "\n");
		super.sql.append("				WHERE  UKB_TNKI_HEAD.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("				AND    UKB_TNKI_HEAD.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("				AND    UKB_TNKI_HEAD.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("				AND    UKB_TNKI_HEAD.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("				AND    UKB_TNKI_HEAD.KEIJ_YM BETWEEN NEXT_START_KEIJ_YM AND NEXT_END_KEIJ_YM) " + "\n");
		super.sql.append("			   ,0) " + "\n");
		super.sql.append("	   END MIBARI_STAX_ZAN_1NAI " + "\n");
		super.sql.append("	  ,CASE " + "\n");
		super.sql.append("		   WHEN KB.KAI_YMD < START_YMD " + "\n");
		super.sql.append("				OR KB.KAI_YMD BETWEEN START_YMD AND END_YMD " + "\n");
		super.sql.append("				OR (KB.KAI_YMD IS NULL AND FKN_LAST_YMD <= END_YMD) THEN " + "\n");
		super.sql.append("			0 " + "\n");
		super.sql.append("		   ELSE " + "\n");
		super.sql.append("			NVL((SELECT SUM(CASE WHEN UKB_TNKI_HEAD.KEIJ_YM < LEAST(M_LC.SHR_YM, KAI_KEIJ_YM) THEN UKB_TNKI_HEAD.LAMT_STAX " + "\n");
		super.sql.append("								 ELSE UKB_TNKI_HEAD.YTE_LAMT_STAX " + "\n");
		super.sql.append("							END) " + "\n");
		super.sql.append("				FROM   T_UKB_TNKI_HEAD UKB_TNKI_HEAD " + "\n");
		super.sql.append("				WHERE  UKB_TNKI_HEAD.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("				AND    UKB_TNKI_HEAD.KEI_NO = KB.KEI_NO " + "\n");
		super.sql.append("				AND    UKB_TNKI_HEAD.BKN_NO = KB.BKN_NO " + "\n");
		super.sql.append("				AND    UKB_TNKI_HEAD.BKN_EDANO = KB.BKN_EDANO " + "\n");
		super.sql.append("				AND    UKB_TNKI_HEAD.KEIJ_YM >= OVER_NEXT_START_KEIJ_YM) " + "\n");
		super.sql.append("			   ,0) " + "\n");
		super.sql.append("	   END MIBARI_STAX_ZAN_1CYO " + "\n");
		super.sql.append("	  ,TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("	  ,KB.CTSHK_FLG AC_SHR_KBN " + "\n");
		super.sql.append("	  ,DECODE(KB.CTSHK_FLG ,'0' ,'売買処理' ,'賃貸借処理') AC_SHR_KBN_NM " + "\n");
		super.sql.append("	  ,TO_CHAR(SYSDATE ,'YYYYMMDD') CREATE_DATE " + "\n");
		super.sql.append("	  ,START_YMD " + "\n");
		super.sql.append("	  ,END_YMD " + "\n");
		super.sql.append("	  ,NEXT_START_YMD " + "\n");
		super.sql.append("	  ,NEXT_END_YMD " + "\n");
		super.sql.append("	  ,OVER_NEXT_END_YMD " + "\n");
		super.sql.append("	  ,START_KEIJ_YM " + "\n");
		super.sql.append("	  ,END_KEIJ_YM " + "\n");
		super.sql.append("	  ,NEXT_START_KEIJ_YM " + "\n");
		super.sql.append("	  ,NEXT_END_KEIJ_YM " + "\n");
		super.sql.append("	  ,OVER_NEXT_START_KEIJ_YM " + "\n");
		super.sql.append("	  ,KAI_START_KEIJ_YM " + "\n");
		super.sql.append("	  ,MRYO_KEIJ_YM " + "\n");
		super.sql.append("	  ,KB.STAX_IKT_KOJ_KBN " + "\n");
		super.sql.append("	  ,DECODE(KB.STAX_IKT_KOJ_KBN ,'0' ,'一括控除' ,'分割控除') STAX_IKT_KOJ_KBN_NM " + "\n");
		super.sql.append("FROM   (" + super.getCoreSQL() + ") KB " + "\n");
		super.sql.append("LEFT   JOIN M_LC M_LC ON M_LC.LC_CD = KB.LC_CD " + "\n");
		super.sql.append("LEFT   JOIN M_TRD_HNTE_KEKA_KBN TRD_HNTE_KEKA_KBN ON TRD_HNTE_KEKA_KBN.TRD_HNTE_KEKA_KBN = KB.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("LEFT   JOIN M_LU LU ON LU.LU_COSMOS_CD = KB.LU_COSMOS_CD " + "\n");
		super.sql.append("LEFT   JOIN M_FKN_TNKI_HOHO_CD FKN_TNKI_HOHO_CD ON FKN_TNKI_HOHO_CD.FKN_TNKI_HOHO_CD = KB.TNKI_HOHO_KBN " + "\n");
		super.sql.append("WHERE  ((KB.KNSHU_YMD <> NVL(KB.KAI_YMD,'A') " + "\n");
		super.sql.append("    AND ((KAI_YMD IS NULL AND KB.START_YMD <= FKN_LAST_YMD) OR (KAI_YMD IS NOT NULL AND KAI_YMD >= START_YMD))) " + "\n");
		super.sql.append("    OR  (KB.KNSHU_YMD = KB.KAI_YMD AND KB.START_YMD <= KB.KNSHU_YMD) " + "\n");
		super.sql.append("  OR  (KB.START_YMD = NVL(KB.KAI_YMD,'0'))) " + "\n");
		super.sql.append("AND    KB.KNSHU_YMD <= KB.END_YMD " + "\n");
		super.sql.append("AND    KB.LU_COSMOS_CD = '" + this.leasCompanyCode + "' " + "\n");

		if (this.keiyakuNo.trim().length() > 0) {
			super.sql.append("AND    KB.HYJYO_KEI_NO = '" + this.keiyakuNo + "' " + "\n"); // 契約番号
		}

		if (super.gtjkeiyakuGaku.equals("0")) {
			super.sql.append("  AND    ((KB.SGK_SSN_KBN IS NULL AND KB.KEI_AMT_KEI > 3000000) " + "\n"); // 契約金額３００万円以下(KEI_AMTは物件から取得しているためKEI_AMT_KEIを使用)
			super.sql.append("      OR   (KB.SGK_SSN_KBN IS NOT NULL AND KB.SGK_SSN_KBN = '0')) " + "\n");
		}

		if (super.gtjleaseKikan.equals("0")) {
			super.sql.append("  AND KB.KEI_TERM > 12 " + "\n"); // リース期間１年以内
		}

		if (super.gtjsaiLease.equals("0")) {
			super.sql.append("  AND KB.RLS_TMS = 0" + "\n"); // 再リース契約
		}

		if (super.gtjtyutoKaiyaku.equals("0")) {
			super.sql.append("  AND KB.KAI_YMD IS NULL" + "\n"); // 中途解約物件
		}

		if ("1".equals(super.commonBean.getControlSyouhizeiDsp())) { // 消費税明細表表示制御
			super.sql.append("  AND TAISHO_AC_KIJYUN_CD = '1'" + "\n"); // 対象会計基準＝新リース会計基準
			super.sql.append("  AND STAX_IKT_KOJ_KBN = '0'" + "\n"); // 消費税一括控除区分＝一括控除
		}

		super.sql.append("ORDER  BY KB.LC_CD " + "\n");
		super.sql.append("         ,KB.TAISHO_AC_KIJYUN_CD " + "\n");
		super.sql.append("         ,KB.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("         ,KB.CTSHK_FLG " + "\n");
		super.sql.append("         ,KB.STAX_IKT_KOJ_KBN " + "\n");
		super.sql.append("         ,KB.HYJYO_KEI_NO " + "\n");
		super.sql.append("         ,KB.BKN_NO " + "\n");
		super.sql.append("         ,KB.BKN_EDANO " + "\n");
		super.sql.append("         ,KB.KEI_NO " + "\n");
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
	 * リース会社を取得.
	 * 
	 * @return リース会社
	 */
	public String getLeaseCompany() {
		return super.getString("LEASE_COMPANY");
	}

	/**
	 * リースユーザを取得.
	 * 
	 * @return リースユーザ
	 */
	public String getLeasUserNm() {
		return super.getString("LEASE_USER");
	}

	/**
	 * 会計基準名称を取得.
	 * 
	 * @return 会計基準名称
	 */
	public String getAcKijyunName() {
		return super.getString("TAISHO_AC_NM");
	}

	/**
	 * 会計処理方法を取得.
	 * 
	 * @return 会計処理方法
	 */
	public String getAcShrKbnName() {
		return super.getString("AC_SHR_KBN_NM");
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
	 * 消費税控除方法を取得.
	 * 
	 * @return 消費税控除方法を取得
	 */
	public String getStaxIktKbnName() {
		return super.getString("STAX_IKT_KOJ_KBN_NM");
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
	 * 表示用契約番号を取得.
	 * 
	 * @return 表示用契約番号
	 */
	public String getHyoujiYouKeiyakuNo() {
		return super.getString("KEI_NO");
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
	 * リース期間を取得.
	 * 
	 * @return リース期間
	 */
	public String getLeaseTerm() {
		return super.getString("KEI_TERM");
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
	 * 中途解約日を取得.
	 * 
	 * @return 中途解約日
	 */
	public String getKaiyakuYmd() {
		return super.getString("KAI_YMD");
	}

	/**
	 * リース料総額を取得.
	 * 
	 * @return リース料総額
	 */
	public long getLeaseSougaku() {
		return super.getLong("KEI_AMT");
	}

	/**
	 * うち保証残価を取得.
	 * 
	 * @return うち保証残価
	 */
	public long getZankHoshoAmt() {
		return super.getLong("ZANK_HSHO_AMT");
	}

	/**
	 * 消費税総額を取得.
	 * 
	 * @return 消費税総額
	 */
	public long getSyouhizeiSougaku() {
		return super.getLong("KEI_AMT_STAX");
	}

	/**
	 * 当期支払リース料を取得.
	 * 
	 * @return 当期支払リース料
	 */
	public long getToukSiharaiLeaseRyou() {
		return super.getLong("LAMT");
	}

	/**
	 * 当期仮払消費税額を取得.
	 * 
	 * @return 当期仮払消費税額を取得
	 */
	public long getToukKariSyouhizeigaku() {
		return super.getLong("LAMT_STAX");
	}

	/**
	 * 仮払消費税累計を取得.
	 * 
	 * @return 仮払消費税累計を取得
	 */
	public long getKariSyouhizeiRuikei() {
		return super.getLong("LAMT_STAX_RUI");
	}

	/**
	 * 未払消費税残高を取得.
	 * 
	 * @return 未払消費税残高を取得
	 */
	public long getMibaraiSyouhizeiZan() {
		return super.getLong("MIBARI_STAX_ZAN");
	}

	/**
	 * 未払消費税残高（１年内）を取得.
	 * 
	 * @return 未払消費税残高（１年内）を取得
	 */
	public long getMibaraiSyouhizeiZan1Nai() {
		return super.getLong("MIBARI_STAX_ZAN_1NAI");
	}

	/**
	 * 未払消費税残高（１年超）を取得.
	 * 
	 * @return 未払消費税残高（１年超）を取得
	 */
	public long getMibaraiSyouhizeiZan1Cyo() {
		return super.getLong("MIBARI_STAX_ZAN_1CYO");
	}
}
