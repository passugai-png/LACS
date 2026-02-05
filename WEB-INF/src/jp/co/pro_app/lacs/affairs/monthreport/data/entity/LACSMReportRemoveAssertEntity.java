package jp.co.pro_app.lacs.affairs.monthreport.data.entity;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 月次帳票出力：除却資産一覧Entity.
 * 
 * @author yamaguchi
 * @version 20080408
 */
public class LACSMReportRemoveAssertEntity extends LACSMReportEntityBase {

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
	public LACSMReportRemoveAssertEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSMReportBean piReportBean) {
		super(piModel, piCommonBean, piReportBean);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append(" SELECT " + "\n");
		super.sql.append(" TO_CHAR(SYSDATE, 'YYYYMMDD') CREATE_DATE" + "\n");
		super.sql.append(" ," + super.taisyouFrom + " START_YMD" + "\n");
		super.sql.append(" ," + super.taisyouTo + " END_YMD" + "\n");
		super.sql.append(" ,BKN.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append(" ,KEI.LC_CD BRAKE_KEY0" + "\n");
		super.sql.append(" ,KEI.LC_CD || KEI.TAISHO_AC_KIJYUN_CD BRAKE_KEY1" + "\n");
		super.sql.append(" ,KEI.LC_CD || KEI.TAISHO_AC_KIJYUN_CD || BKN.SKK_KEIJ_HOHO_KBN BRAKE_KEY2" + "\n");
		super.sql.append(" ,SKK_KEIJ_HOHO.SKK_AMT_NM" + "\n");
		super.sql.append(" ,SKK_KEIJ_HOHO.SKK_TERM_NM" + "\n");
		super.sql.append(" ,SKK_KEIJ_HOHO.SKK_HOHO_NM" + "\n");
		super.sql.append(" ,KEI.HYJYO_KEI_NO" + "\n");
		super.sql.append(" ,BKN.BKN_NM" + "\n");
		super.sql.append("      ,BKN.BKN_NO || CASE WHEN TRIM(BKN.BKN_EDANO) IS NULL THEN '' ELSE '-' || BKN.BKN_EDANO END BKN_NO" + "\n");
		super.sql.append(" ,KEI.KNSHU_YMD" + "\n");
		super.sql.append(" ,KEI.MRYO_YMD" + "\n");
		super.sql.append(" ,KEI.KAI_YMD" + "\n");
		super.sql.append(" ,BKN.SSN_SRI_CD" + "\n");
		super.sql.append(" ,SSN_SRI.SSN_SRI_NM" + "\n");
		super.sql.append(" ,INVIO_FUNC.KAI_KEIK_TERM_RET(KEI.KNSHU_YMD, TO_CHAR(TO_DATE(LEAST('" + super.taisyouTo + "', KEI.MRYO_YMD, NVL(TO_CHAR(TO_DATE(KEI.KAI_YMD, 'YYYYMMDD') - 1, 'YYYYMMDD'), '99999999')), 'YYYYMMDD') + 1, 'YYYYMMDD')) KI " + "\n");
		super.sql.append(" ,GNKSK.RUI_SKK_AMT + CASE WHEN KEI.KAI_YMD IS NULL AND KEI.MRYO_YMD BETWEEN '" + super.taisyouFrom + "' AND '" + super.taisyouTo + "' THEN GNKSK.USER_ZANK ELSE 0 END RUI_SKK_AMT " + "\n");
		super.sql.append(" ,GNKSK.GNPN_TTL " + "\n");
		super.sql.append(" ,GNKSK.ZAND_SKK_AMT + CASE WHEN KEI.KAI_YMD IS NOT NULL AND KEI.KAI_YMD BETWEEN '" + super.taisyouFrom + "' AND '" + super.taisyouTo + "' THEN GNKSK.USER_ZANK ELSE 0 END ZAND_SKK_AMT" + "\n");
		super.sql.append(" ,CASE BKN.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("  WHEN '111' THEN BKN.TY_YSU * 12" + "\n");
		super.sql.append("  WHEN '112' THEN BKN.TY_YSU * 12" + "\n");
		super.sql.append("  WHEN '113' THEN BKN.TY_YSU * 12" + "\n");
		super.sql.append("  WHEN '121' THEN KEI.KEI_TERM" + "\n");
		super.sql.append("  WHEN '122' THEN KEI.KEI_TERM" + "\n");
		super.sql.append("  WHEN '123' THEN KEI.KEI_TERM" + "\n");
		super.sql.append("  WHEN '221' THEN KEI.KEI_TERM" + "\n");
		super.sql.append("  WHEN '222' THEN KEI.KEI_TERM" + "\n");
		super.sql.append("  WHEN '223' THEN KEI.KEI_TERM" + "\n");
		super.sql.append(" END SOU" + "\n");
		super.sql.append(" ,CASE WHEN KEI.KAI_YMD BETWEEN '" + super.taisyouFrom + "' AND '" + super.taisyouTo + "' THEN 0 ELSE " + "\n");
		super.sql.append("  DECODE(KEI.LU_TRSK_CD, BKN.IPN_ZANK_HSHOSK_CD, BKN.ZANK_HSHO_AMT, " + "\n");
		super.sql.append(" 	 DECODE(KEI.LU_TRSK_CD, BKN.ZANK_HSHOSK_CD,  BKN.ZANK_HSHO_AMT, 0)) END ZANK_AMT" + "\n");
		super.sql.append(" , GNKSK.RUI_SKK_AMT + GNKSK.ZAND_SKK_AMT + DECODE(KEI.LU_TRSK_CD, BKN.IPN_ZANK_HSHOSK_CD, BKN.ZANK_HSHO_AMT, " + "\n");
		super.sql.append(" 	 DECODE(KEI.LU_TRSK_CD, BKN.ZANK_HSHOSK_CD,  BKN.ZANK_HSHO_AMT, 0)) SOUGAKU" + "\n");
		super.sql.append(" ,DECODE(LU.PDF_COMPANY_NM, NULL, LC.LC_NM, LU.PDF_COMPANY_NM) LC_NM " + "\n");
		super.sql.append(" ,LU.LU_NM LU_NM" + "\n");
		super.sql.append(" ,DECODE(KEI.TAISHO_AC_KIJYUN_CD,0,'旧リース会計基準','新リース会計基準') AC_KIJYUN_NM " + "\n");
		super.sql.append(" FROM T_KEI KEI" + "\n");
		super.sql.append(" ,(SELECT BKN.LC_CD " + "\n");
		super.sql.append("                 ,BKN.KEI_NO " + "\n");
		super.sql.append("                 ,BKN.BKN_NO " + "\n");
		super.sql.append("                 ,BKN.BKN_EDANO " + "\n");
		super.sql.append("                 ,BKN.BKN_NM " + "\n");
		super.sql.append("                 ,BKN.TY_YSU " + "\n");
		super.sql.append("                 ,BKN.SSN_SRI_CD " + "\n");
		super.sql.append("                 ,BKN.ZANK_HSHO_AMT " + "\n");
		super.sql.append("                 ,BKN.ZANK_HSHOSK_CD " + "\n");
		super.sql.append("                 ,BKN.IPN_ZANK_HSHOSK_CD " + "\n");
		super.sql.append("                 ,BKN.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                 ,CASE KEI.RSK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                      WHEN '101' THEN " + "\n");
		super.sql.append("                          LEAST(BKN.MBRI_WRBK_PV, BKN.KNU_AMT) " + "\n");
		super.sql.append("                      WHEN '201' THEN " + "\n");
		super.sql.append("                          BKN.KEI_AMT + CASE WHEN (BKN.ZANK_HSHOSK_CD = KEI.LU_TRSK_CD) OR (BKN.IPN_ZANK_HSHOSK_CD = KEI.LU_TRSK_CD) THEN BKN.ZANK_HSHO_AMT ELSE 0 END " + "\n");
		super.sql.append("                      ELSE " + "\n");
		super.sql.append("                          LEAST(BKN.ABRI_WRBK_PV, BKN.KNU_AMT) " + "\n");
		super.sql.append("                  END " + "\n");
		super.sql.append("                  KNU_AMT " + "\n");
		super.sql.append("                 ,BKN.MBRI_WRBK_PV " + "\n");
		super.sql.append("                 ,BKN.ABRI_WRBK_PV " + "\n");
		super.sql.append("                 ,BKN.FKN_KEIJ_YM_MAX " + "\n");
		super.sql.append("                 ,BKN.GNKSK_KEIJ_YM_MAX " + "\n");
		super.sql.append("             FROM (SELECT B.* " + "\n");
		super.sql.append("              ,(SELECT MAX(KEIJ_YM) " + "\n");
		super.sql.append("                FROM   T_UKB_TNKI_HEAD FKN_HEAD " + "\n");
		super.sql.append("                WHERE  FKN_HEAD.LC_CD = B.LC_CD " + "\n");
		super.sql.append("                AND    FKN_HEAD.KEI_NO = B.KEI_NO " + "\n");
		super.sql.append("                AND    FKN_HEAD.BKN_NO = B.BKN_NO " + "\n");
		super.sql.append("                AND    FKN_HEAD.BKN_EDANO = B.BKN_EDANO " + "\n");
		super.sql.append("                AND    FKN_HEAD.KAI_REC_FLG = '0' " + "\n");
		super.sql.append("                ) FKN_KEIJ_YM_MAX " + "\n");
		super.sql.append("              ,(SELECT MAX(KEIJ_YM) " + "\n");
		super.sql.append("                FROM   T_UKB_GNKSK GNKSK " + "\n");
		super.sql.append("                WHERE  GNKSK.LC_CD = B.LC_CD " + "\n");
		super.sql.append("                AND    GNKSK.KEI_NO = B.KEI_NO " + "\n");
		super.sql.append("                AND    GNKSK.BKN_NO = B.BKN_NO " + "\n");
		super.sql.append("                AND    GNKSK.BKN_EDANO = B.BKN_EDANO " + "\n");
		super.sql.append("                AND    GNKSK.KEIJ_HOHO_KBN = B.SKK_KEIJ_HOHO_KBN " + "\n");
		super.sql.append("                AND    GNKSK.KAI_REC_FLG = '0' " + "\n");
		super.sql.append("                ) GNKSK_KEIJ_YM_MAX " + "\n");
		super.sql.append("        FROM   T_BKN B) BKN " + "\n");
		super.sql.append("        LEFT JOIN T_KEI KEI ON BKN.LC_CD = KEI.LC_CD AND BKN.KEI_NO = KEI.KEI_NO " + "\n");
		super.sql.append("        LEFT JOIN M_LU LU   ON LU.LU_COSMOS_CD = KEI.LU_COSMOS_CD) BKN " + "\n");
		super.sql.append(" ,M_SKK_KEIJ_HOHO_KBN SKK_KEIJ_HOHO" + "\n");
		super.sql.append(" ,M_SSN_SRI SSN_SRI" + "\n");
		super.sql.append(" ,T_UKB_GNKSK GNKSK" + "\n");
		super.sql.append(" ,M_LC LC" + "\n");
		super.sql.append(" ,M_LU LU" + "\n");
		super.sql.append(" WHERE KEI.LC_CD = BKN.LC_CD" + "\n");
		super.sql.append(" AND KEI.KEI_NO = BKN.KEI_NO" + "\n");
		super.sql.append(" AND BKN.SKK_KEIJ_HOHO_KBN = SKK_KEIJ_HOHO.SKK_KEIJ_HOHO_KBN" + "\n");
		super.sql.append(" AND BKN.SSN_SRI_CD = SSN_SRI.SSN_SRI_CD" + "\n");
		super.sql.append(" AND BKN.LC_CD = GNKSK.LC_CD" + "\n");
		super.sql.append(" AND BKN.KEI_NO = GNKSK.KEI_NO" + "\n");
		super.sql.append(" AND BKN.BKN_NO = GNKSK.BKN_NO" + "\n");
		super.sql.append(" AND BKN.BKN_EDANO = GNKSK.BKN_EDANO" + "\n");
		super.sql.append(" AND BKN.SKK_KEIJ_HOHO_KBN = GNKSK.KEIJ_HOHO_KBN" + "\n");
		super.sql.append(" AND BKN.GNKSK_KEIJ_YM_MAX = GNKSK.KEIJ_YM " + "\n");
		super.sql.append(" AND KEI.LU_COSMOS_CD = '" + this.leasCompanyCode + "' " + "\n"); // リースユーザ

		if (super.gtjtyutoKaiyaku.equals("0")) {
			super.sql.append(" AND KEI.MRYO_YMD BETWEEN  '" + super.taisyouFrom + "' AND '" + super.taisyouTo + "' " + "\n");
			super.sql.append(" AND KEI.KAI_YMD IS NULL ");
		}
		else {
			super.sql.append(" AND COALESCE(KEI.KAI_YMD,KEI.MRYO_YMD) BETWEEN  '" + super.taisyouFrom + "' AND '" + super.taisyouTo + "' " + "\n");
		}

		if (super.keiyakuNo.trim().length() > 0) {
			super.sql.append("		AND KEI.HYJYO_KEI_NO = '" + super.keiyakuNo + "' \n");
		}

		if (super.gtjkeiyakuGaku.equals("0")) {
			super.sql.append("  AND    ((KEI.SGK_SSN_KBN IS NULL AND KEI.KEI_AMT > 3000000) " + "\n");
			super.sql.append("      OR   (KEI.SGK_SSN_KBN IS NOT NULL AND KEI.SGK_SSN_KBN = '0')) " + "\n");
		}

		if (super.gtjleaseKikan.equals("0")) {
			super.sql.append("  AND KEI.KEI_TERM > 12 " + "\n"); // リース期間１年以内
		}

		if (super.gtjsaiLease.equals("0")) {
			super.sql.append("  AND KEI.RLS_TMS = 0" + "\n"); // 再リース契約
		}

		if (super.gtjtyutoKaiyaku.equals("0")) {
			super.sql.append("  AND KEI.KAI_YMD IS NULL" + "\n"); // 中途解約物件
		}

		super.sql.append(" AND KEI.LC_CD = LC.LC_CD" + "\n");
		super.sql.append(" AND KEI.LU_COSMOS_CD = LU.LU_COSMOS_CD" + "\n");
		super.sql.append(" ORDER BY KEI.LC_CD " + "\n");
		super.sql.append(" ,KEI.TAISHO_AC_KIJYUN_CD" + "\n");
		super.sql.append(" ,BKN.SKK_KEIJ_HOHO_KBN" + "\n");
		super.sql.append(" ,KEI.HYJYO_KEI_NO" + "\n");
		super.sql.append(" ,BKN.BKN_NO" + "\n");
		super.sql.append(" ,BKN.BKN_EDANO" + "\n");
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
	 * 物件名を取得.
	 * 
	 * @return 物件名
	 */
	public String getBknNm() {
		return super.getString("BKN_NM");
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
	 * 表示用契約番号を取得.
	 * 
	 * @return 表示用契約番号
	 */
	public String getHyjyoKeiNo() {
		return super.getString("HYJYO_KEI_NO");
	}

	/**
	 * 解約日を取得.
	 * 
	 * @return 解約日
	 */
	public String getKaiYmd() {
		return super.getString("KAI_YMD");
	}

	/**
	 * 経過を取得.
	 * 
	 * @return 経過
	 */
	public long getKi() {
		return super.getLong("KI");
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
	 * 償却累計額を取得.
	 * 
	 * @return 償却累計額
	 */
	public long getRuiSkkAmt() {
		return super.getLong("RUI_SKK_AMT");
	}

	/**
	 * 償却額名称を取得.
	 * 
	 * @return 償却額名称
	 */
	public String getSkkAmtNm() {
		return super.getString("SKK_AMT_NM");
	}

	/**
	 * 償却方法名称を取得.
	 * 
	 * @return 償却方法名称
	 */
	public String getSkkHohoNm() {
		return super.getString("SKK_HOHO_NM");
	}

	/**
	 * 償却期間名称を取得.
	 * 
	 * @return 償却期間名称
	 */
	public String getSkkTermNm() {
		return super.getString("SKK_TERM_NM");
	}

	/**
	 * 償却期間総を取得.
	 * 
	 * @return 償却期間総
	 */
	public long getSou() {
		return super.getLong("SOU");
	}

	/**
	 * 資産種類コードを取得.
	 * 
	 * @return 資産種類コード
	 */
	public String getSsnSriCd() {
		return super.getString("SSN_SRI_CD");
	}

	/**
	 * 資産種類名を取得.
	 * 
	 * @return 資産種類名
	 */
	public String getSsnSriNm() {
		return super.getString("SSN_SRI_NM");
	}

	/**
	 * 満了時簿価を取得.
	 * 
	 * @return 残価保証額
	 */
	public long getZandSkkAmt() {
		return super.getLong("ZAND_SKK_AMT");
	}

	/**
	 * 残価保証額を取得.
	 * 
	 * @return 残価保証額
	 */
	public long getZankAmt() {
		return super.getLong("ZANK_AMT");
	}

	/**
	 * リース会社名を取得.
	 * 
	 * @return リース会社名
	 */
	public String getLeaseCompanyNm() {
		return super.getString("LC_NM");
	}

	/**
	 * リースユーザ名を取得.
	 * 
	 * @return リースユーザ名
	 */
	public String getLeaseUserNm() {
		return super.getString("LU_NM");
	}

	/**
	 * ブレークキー２を取得.
	 * 
	 * @return ブレークキー２
	 */
	public String getBrakeKey2() {
		return super.getString("BRAKE_KEY2");
	}

	/**
	 * リース会計基準名を取得.
	 * 
	 * @return リース会計基準名
	 */
	public String getAcKijyunNm() {
		return super.getString("AC_KIJYUN_NM");
	}

	/**
	 * 取得価格相当額を取得.
	 * 
	 * @return 取得価格相当額
	 */
	public long getGnpnTtl() {
		return super.getLong("GNPN_TTL");
	}

}
