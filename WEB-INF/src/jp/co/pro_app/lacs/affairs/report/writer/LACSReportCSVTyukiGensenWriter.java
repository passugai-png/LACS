package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportTyukiGensenEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 月次帳票出力：明細データCSV出力.
 * 
 * @author yamaguchi
 * @version 20080409
 */
public class LACSReportCSVTyukiGensenWriter extends LACSReportCSVWriterBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piCommonBean
	 *            LACS用共通Bean
	 * @param piModel
	 *            モデルクラス
	 * @param piCon
	 *            DB接続
	 */
	public LACSReportCSVTyukiGensenWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
	}

	/**
	 * CSV作成.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @param piDateMode
	 *            西暦和暦モード
	 * @param piContext
	 *            ServletContext
	 * @return PDFファイル名
	 * @exception Exception
	 *                実行例外
	 */
	public String makeCSV(LACSReportBean piReportBean, String piDateMode, ServletContext piContext) throws Exception {
		LACSReportTyukiGensenEntity reportEntity = new LACSReportTyukiGensenEntity(super.model, this.commonBean, piReportBean, acStd);
		String fileName = "";
		String[] header = null;
		String[] columns = null;

		File tmpFile = null; // 出力先ファイル

		if ("1".equals(super.commonBean.getControlTyukiGensenMeisaiDsp())) {
			header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "表示用契約番号", "物件番号", "物件番号枝番", "固定資産科目コード", "固定資産科目名称", "開示先コード", "開示先", "リース取引分類コード", "リース取引分類名称", "契約日", "検収日", "満了日", "中途解約日", "契約期間", "経過月数", "対象会計基準コード", "賃貸借フラグ", "耐用年数", "物件名", "利息相当額配分方法コード", "利息相当額配分方法名称", "賦金展開方法コード", "賦金展開方法名称", "維持管理費重要性区分", "維持管理費重要性区分名称", "役務提供費重要性区分", "役務提供費重要性区分名称", "賦金展開端数調整方法コード", "賦金展開端数調整方法名称", "減価償却方法コード", "減価償却方法名称", "減価償却端数調整方法コード", "減価償却端数調整方法名称", "リース料総額税抜", "リース料消費税", "割引現在価値", "割引計算利子率", "見積現金購入価格", "うち残価保証額", "取得価格相当額", "利息計算利子率", "支払利息相当額総額", "月額リース料税抜", "月額リース料消費税", "月額均等償却費相当額", "当期支払リース料", "当期支払リース料消費税", "当期支払リース料うちリース債務相当額", "当期支払リース料支払利息相当額", "当期支払リース料うち登録諸費用（課税）相当額", "当期支払リース料うち登録諸費用（非課税）相当額", "当期支払リース料うち取得税相当額", "当期支払リース料うち自動車税相当額", "当期支払リース料うち重量税相当額", "当期支払リース料うち自賠責保険相当額", "当期支払リース料うち任意保険相当額", "当期支払リース料うちリサイクル料管理費相当額", "当期支払リース料うち動総相当額", "当期支払リース料うち固税相当額", "当期支払リース料うちその他原価相当額", "当期支払リース料うち保守料相当額", "当期減価償却費相当額", "支払リース料累計額", "支払リース料消費税累計額", "支払リース料うちリース債務相当額累計額", "支払リース料支払利息累計額相当額", "支払リース料うち登録諸費用（課税）累計額相当額", "支払リース料うち登録諸費用（非課税）累計額相当額", "支払リース料うち取得税累計額相当額", "支払リース料うち自動車税累計額相当額", "支払リース料うち重量税累計額相当額", "支払リース料うち自賠責保険累計額相当額", "支払リース料うち任意保険累計額相当額", "支払リース料うちリサイクル料管理費累計額相当額", "支払リース料うち動総累計額相当額", "支払リース料うち固税累計額相当額", "支払リース料うちその他原価累計額相当額", "支払リース料うち保守料累計額相当額", "減価償却累計額相当額", "支払リース料相当額（1年内合計）", "支払リース料消費税相当額（1年内合計）", "支払リース料うちリース債務相当額（1年内合計）", "支払リース料支払利息相当額（1年内合計）", "支払リース料うち登録諸費用（課税）相当額（1年内合計）", "支払リース料うち登録諸費用（非課税）相当額（1年内合計）", "支払リース料うち取得税相当額（1年内合計）", "支払リース料うち自動車税相当額（1年内合計）", "支払リース料うち重量税相当額（1年内合計）", "支払リース料うち自賠責保険相当額（1年内合計）", "支払リース料うち任意保険相当額（1年内合計）", "支払リース料うちリサイクル料管理費相当額（1年内合計）", "支払リース料うち動総相当額（1年内合計）", "支払リース料うち固税相当額（1年内合計）", "支払リース料うちその他原価相当額（1年内合計）", "支払リース料うち保守料相当額（1年内合計）", "減価償却相当額（1年内合計）", "支払リース料相当額（1年超合計）", "支払リース料消費税相当額（1年超合計）", "支払リース料うちリース債務相当額（1年超合計）", "支払リース料支払利息相当額（1年超合計）", "支払リース料うち登録諸費用（課税）相当額（1年超合計）", "支払リース料うち登録諸費用（非課税）相当額（1年超合計）", "支払リース料うち取得税相当額（1年超合計）", "支払リース料うち自動車税相当額（1年超合計）", "支払リース料うち重量税相当額（1年超合計）", "支払リース料うち自賠責保険相当額（1年超合計）", "支払リース料うち任意保険相当額（1年超合計）", "支払リース料うちリサイクル料管理費相当額（1年超合計）", "支払リース料うち動総相当額（1年超合計）", "支払リース料うち固税相当額（1年超合計）", "支払リース料うちその他原価相当額（1年超合計）", "支払リース料うち保守料相当額（1年超合計）", "減価償却相当額（1年超合計）", "支払リース料相当額（1年内1年超合計）", "支払リース料消費税相当額（1年内1年超合計）", "支払リース料うちリース債務相当額（1年内1年超合計）", "支払リース料支払利息相当額（1年内1年超合計）", "支払リース料うち登録諸費用（課税）相当額（1年内1年超合計）", "支払リース料うち登録諸費用（非課税）相当額（1年内1年超合計）", "支払リース料うち取得税相当額（1年内1年超合計）", "支払リース料うち自動車税相当額（1年内1年超合計）", "支払リース料うち重量税相当額（1年内1年超合計）", "支払リース料うち自賠責保険相当額（1年内1年超合計）", "支払リース料うち任意保険相当額（1年内1年超合計）", "支払リース料うちリサイクル料管理費相当額（1年内1年超合計）", "支払リース料うち動総相当額（1年内1年超合計）", "支払リース料うち固税相当額（1年内1年超合計）", "支払リース料うちその他原価相当額（1年内1年超合計）", "支払リース料うち保守料相当額（1年内1年超合計）", "減価償却相当額（1年内1年超合計）", "支払リース料相当額（1年超2年内合計）", "支払リース料消費税相当額（1年超2年内合計）", "支払リース料うちリース債務相当額（1年超2年内合計）", "支払リース料支払利息相当額（1年超2年内合計）", "支払リース料うち登録諸費用（課税）相当額（1年超2年内合計）", "支払リース料うち登録諸費用（非課税）相当額（1年超2年内合計）", "支払リース料うち取得税相当額（1年超2年内合計）", "支払リース料うち自動車税相当額（1年超2年内合計）", "支払リース料うち重量税相当額（1年超2年内合計）", "支払リース料うち自賠責保険相当額（1年超2年内合計）", "支払リース料うち任意保険相当額（1年超2年内合計）", "支払リース料うちリサイクル料管理費相当額（1年超2年内合計）", "支払リース料うち動総相当額（1年超2年内合計）", "支払リース料うち固税相当額（1年超2年内合計）", "支払リース料うちその他原価相当額（1年超2年内合計）", "支払リース料うち保守料相当額（1年超2年内合計）", "減価償却相当額（1年超2年内合計）", "支払リース料相当額（2年超3年内合計）", "支払リース料消費税相当額（2年超3年内合計）", "支払リース料うちリース債務相当額（2年超3年内合計）", "支払リース料支払利息相当額（2年超3年内合計）", "支払リース料うち登録諸費用（課税）相当額（2年超3年内合計）", "支払リース料うち登録諸費用（非課税）相当額（2年超3年内合計）", "支払リース料うち取得税相当額（2年超3年内合計）", "支払リース料うち自動車税相当額（2年超3年内合計）", "支払リース料うち重量税相当額（2年超3年内合計）", "支払リース料うち自賠責保険相当額（2年超3年内合計）", "支払リース料うち任意保険相当額（2年超3年内合計）", "支払リース料うちリサイクル料管理費相当額（2年超3年内合計）", "支払リース料うち動総相当額（2年超3年内合計）", "支払リース料うち固税相当額（2年超3年内合計）", "支払リース料うちその他原価相当額（2年超3年内合計）", "支払リース料うち保守料相当額（2年超3年内合計）", "減価償却相当額（2年超3年内合計）", "支払リース料相当額（3年超4年内合計）", "支払リース料消費税相当額（3年超4年内合計）", "支払リース料うちリース債務相当額（3年超4年内合計）", "支払リース料支払利息相当額（3年超4年内合計）", "支払リース料うち登録諸費用（課税）相当額（3年超4年内合計）", "支払リース料うち登録諸費用（非課税）相当額（3年超4年内合計）", "支払リース料うち取得税相当額（3年超4年内合計）", "支払リース料うち自動車税相当額（3年超4年内合計）", "支払リース料うち重量税相当額（3年超4年内合計）", "支払リース料うち自賠責保険相当額（3年超4年内合計）", "支払リース料うち任意保険相当額（3年超4年内合計）", "支払リース料うちリサイクル料管理費相当額（3年超4年内合計）", "支払リース料うち動総相当額（3年超4年内合計）", "支払リース料うち固税相当額（3年超4年内合計）", "支払リース料うちその他原価相当額（3年超4年内合計）", "支払リース料うち保守料相当額（3年超4年内合計）", "減価償却相当額（3年超4年内合計）", "支払リース料相当額（4年超5年内合計）", "支払リース料消費税相当額（4年超5年内合計）", "支払リース料うちリース債務相当額（4年超5年内合計）", "支払リース料支払利息相当額（4年超5年内合計）", "支払リース料うち登録諸費用（課税）相当額（4年超5年内合計）", "支払リース料うち登録諸費用（非課税）相当額（4年超5年内合計）", "支払リース料うち取得税相当額（4年超5年内合計）", "支払リース料うち自動車税相当額（4年超5年内合計）", "支払リース料うち重量税相当額（4年超5年内合計）", "支払リース料うち自賠責保険相当額（4年超5年内合計）", "支払リース料うち任意保険相当額（4年超5年内合計）", "支払リース料うちリサイクル料管理費相当額（4年超5年内合計）", "支払リース料うち動総相当額（4年超5年内合計）", "支払リース料うち固税相当額（4年超5年内合計）", "支払リース料うちその他原価相当額（4年超5年内合計）", "支払リース料うち保守料相当額（4年超5年内合計）", "減価償却相当額（4年超5年内合計）", "支払リース料相当額（5年超合計）", "支払リース料消費税相当額（5年超合計）", "支払リース料うちリース債務相当額（5年超合計）", "支払リース料支払利息相当額（5年超合計）", "支払リース料うち登録諸費用（課税）相当額（5年超合計）", "支払リース料うち登録諸費用（非課税）相当額（5年超合計）", "支払リース料うち取得税相当額（5年超合計）", "支払リース料うち自動車税相当額（5年超合計）", "支払リース料うち重量税相当額（5年超合計）", "支払リース料うち自賠責保険相当額（5年超合計）", "支払リース料うち任意保険相当額（5年超合計）", "支払リース料うちリサイクル料管理費相当額（5年超合計）", "支払リース料うち動総相当額（5年超合計）", "支払リース料うち固税相当額（5年超合計）", "支払リース料うちその他原価相当額（5年超合計）", "支払リース料うち保守料相当額（5年超合計）", "減価償却相当額（5年超合計）" };

			columns = new String[]{ "CREATE_DATE", "START_YMD", "END_YMD", "HYJYO_KEI_NO", "BKN_NO", "BKN_EDANO", "SSN_SRI_CD", "SSN_SRI_NM", "LU_TRSK_CD", "LU_NM", "TRD_HNTE_KEKA_KBN", "TRD_HNTE_KEKA_NM", "KEI_YMD", "KNSHU_YMD", "MRYO_YMD", "KAI_YMD", "KEI_TERM", "KEI_PAST", "TAISHO_AC_KIJYUN_CD", "CTSHK_FLG", "TY_YSU", "BKN_NM", "RSK_KEIJ_HOHO_KBN", "RSK_KEIJ_HOHO_KBN_NM", "TNKI_HOHO_KBN", "TNKI_HOHO_KBN_NM", "IJI_KNRI_HYO_JYO_KBN", "IJI_KNRI_HYO_JYO_KBN_NM", "EKM_TEIK_HYO_JYO_KBN", "EKM_TEIK_HYO_JYO_KBN_NM", "FKN_TNKI_CHSE_CD", "FKN_TNKI_CHSE_CD_NM", "SKK_KEIJ_HOHO_KBN", "SKK_KEIJ_HOHO_KBN_NM", "GNKSK_HASU_CHSE_CD", "GNKSK_HASU_CHSE_CD_NM", "KEI_AMT", "KEI_TAX", "WRBK_PV", "WRBK_RS_RT", "KNU_AMT", "ZANK_AMT", "GNPN_TTL", "RSK_CLC_RS_RT", "RSK_SOU_AMT", "MONTH_AMT", "MONTH_AMT_TAX", "MONTH_KINTO", "LAMT", "LAMT_STAX", "TGTU_GNPN", "TGTU_RSK", "ENT_SHOHYO_KZI", "ENT_SHOHYO_HKZI", "GTAX", "CTAX", "JTAX", "JBSK_HKN", "NNI_HKN", "RCYCL_RYO_KNRI_AMT", "DOSO", "KOZEI", "OTH_CST", "EKM_TEIK_HYO", "TGTU_SKK_AMT", "LAMT_ALL", "LAMT_STAX_ALL", "TGTU_GNPN_ALL", "TGTU_RSK_ALL", "ENT_SHOHYO_KZI_ALL", "ENT_SHOHYO_HKZI_ALL", "GTAX_ALL", "CTAX_ALL", "JTAX_ALL", "JBSK_HKN_ALL", "NNI_HKN_ALL", "RCYCL_RYO_KNRI_AMT_ALL", "DOSO_ALL", "KOZEI_ALL", "OTH_CST_ALL", "EKM_TEIK_HYO_ALL", "TGTU_SKK_AMT_ALL", "LAMT_ZAN_NAI", "LAMT_STAX_ZAN_NAI", "TGTU_GNPN_ZAN_NAI", "TGTU_RSK_ZAN_NAI", "ENT_SHOHYO_KZI_ZAN_NAI", "ENT_SHOHYO_HKZI_ZAN_NAI", "GTAX_ZAN_NAI", "CTAX_ZAN_NAI", "JTAX_ZAN_NAI", "JBSK_HKN_ZAN_NAI", "NNI_HKN_ZAN_NAI", "RCYCL_RYO_KNRI_AMT_ZAN_NAI", "DOSO_ZAN_NAI", "KOZEI_ZAN_NAI", "OTH_CST_ZAN_NAI", "EKM_TEIK_HYO_ZAN_NAI", "TGTU_SKK_AMT_ZAN_NAI", "LAMT_ZAN_CYO", "LAMT_STAX_ZAN_CYO", "TGTU_GNPN_ZAN_CYO", "TGTU_RSK_ZAN_CYO", "ENT_SHOHYO_KZI_ZAN_CYO", "ENT_SHOHYO_HKZI_ZAN_CYO", "GTAX_ZAN_CYO", "CTAX_ZAN_CYO", "JTAX_ZAN_CYO", "JBSK_HKN_ZAN_CYO", "NNI_HKN_ZAN_CYO", "RCYCL_RYO_KNRI_AMT_ZAN_CYO", "DOSO_ZAN_CYO", "KOZEI_ZAN_CYO", "OTH_CST_ZAN_CYO", "EKM_TEIK_HYO_ZAN_CYO", "TGTU_SKK_AMT_ZAN_CYO", "LAMT_ZAN", "LAMT_STAX_ZAN", "TGTU_GNPN_ZAN", "TGTU_RSK_ZAN", "ENT_SHOHYO_KZI_ZAN", "ENT_SHOHYO_HKZI_ZAN", "GTAX_ZAN", "CTAX_ZAN", "JTAX_ZAN", "JBSK_HKN_ZAN", "NNI_HKN_ZAN", "RCYCL_RYO_KNRI_AMT_ZAN", "DOSO_ZAN", "KOZEI_ZAN", "OTH_CST_ZAN", "EKM_TEIK_HYO_ZAN", "TGTU_SKK_AMT_ZAN", "LAMT_ZAN_SECOND", "LAMT_STAX_ZAN_SECOND", "TGTU_GNPN_ZAN_SECOND", "TGTU_RSK_ZAN_SECOND", "ENT_SHOHYO_KZI_ZAN_SECOND", "ENT_SHOHYO_HKZI_ZAN_SECOND", "GTAX_ZAN_SECOND", "CTAX_ZAN_SECOND", "JTAX_ZAN_SECOND", "JBSK_HKN_ZAN_SECOND", "NNI_HKN_ZAN_SECOND", "RCYCL_RYO_KNRI_AMT_ZAN_SECOND", "DOSO_ZAN_SECOND", "KOZEI_ZAN_SECOND", "OTH_CST_ZAN_SECOND", "EKM_TEIK_HYO_ZAN_SECOND", "TGTU_SKK_AMT_ZAN_SECOND", "LAMT_ZAN_THIRD", "LAMT_STAX_ZAN_THIRD", "TGTU_GNPN_ZAN_THIRD", "TGTU_RSK_ZAN_THIRD", "ENT_SHOHYO_KZI_ZAN_THIRD", "ENT_SHOHYO_HKZI_ZAN_THIRD", "GTAX_ZAN_THIRD", "CTAX_ZAN_THIRD", "JTAX_ZAN_THIRD", "JBSK_HKN_ZAN_THIRD", "NNI_HKN_ZAN_THIRD", "RCYCL_RYO_KNRI_AMT_ZAN_THIRD", "DOSO_ZAN_THIRD", "KOZEI_ZAN_THIRD", "OTH_CST_ZAN_THIRD", "EKM_TEIK_HYO_ZAN_THIRD", "TGTU_SKK_AMT_ZAN_THIRD", "LAMT_ZAN_FOURTH", "LAMT_STAX_ZAN_FOURTH", "TGTU_GNPN_ZAN_FOURTH", "TGTU_RSK_ZAN_FOURTH", "ENT_SHOHYO_KZI_ZAN_FOURTH", "ENT_SHOHYO_HKZI_ZAN_FOURTH", "GTAX_ZAN_FOURTH", "CTAX_ZAN_FOURTH", "JTAX_ZAN_FOURTH", "JBSK_HKN_ZAN_FOURTH", "NNI_HKN_ZAN_FOURTH", "RCYCL_RYO_KNRI_AMT_ZAN_FOURTH", "DOSO_ZAN_FOURTH", "KOZEI_ZAN_FOURTH", "OTH_CST_ZAN_FOURTH", "EKM_TEIK_HYO_ZAN_FOURTH", "TGTU_SKK_AMT_ZAN_FOURTH", "LAMT_ZAN_FIFTH", "LAMT_STAX_ZAN_FIFTH", "TGTU_GNPN_ZAN_FIFTH", "TGTU_RSK_ZAN_FIFTH", "ENT_SHOHYO_KZI_ZAN_FIFTH", "ENT_SHOHYO_HKZI_ZAN_FIFTH", "GTAX_ZAN_FIFTH", "CTAX_ZAN_FIFTH", "JTAX_ZAN_FIFTH", "JBSK_HKN_ZAN_FIFTH", "NNI_HKN_ZAN_FIFTH", "RCYCL_RYO_KNRI_AMT_ZAN_FIFTH", "DOSO_ZAN_FIFTH", "KOZEI_ZAN_FIFTH", "OTH_CST_ZAN_FIFTH", "EKM_TEIK_HYO_ZAN_FIFTH", "TGTU_SKK_AMT_ZAN_FIFTH", "LAMT_ZAN_OVER", "LAMT_STAX_ZAN_OVER", "TGTU_GNPN_ZAN_OVER", "TGTU_RSK_ZAN_OVER", "ENT_SHOHYO_KZI_ZAN_OVER", "ENT_SHOHYO_HKZI_ZAN_OVER", "GTAX_ZAN_OVER", "CTAX_ZAN_OVER", "JTAX_ZAN_OVER", "JBSK_HKN_ZAN_OVER", "NNI_HKN_ZAN_OVER", "RCYCL_RYO_KNRI_AMT_ZAN_OVER", "DOSO_ZAN_OVER", "KOZEI_ZAN_OVER", "OTH_CST_ZAN_OVER", "EKM_TEIK_HYO_ZAN_OVER", "TGTU_SKK_AMT_ZAN_OVER" };
		}
		else {
			header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "表示用契約番号", "物件番号", "物件番号枝番", "固定資産科目コード", "固定資産科目名称", "開示先コード", "開示先", "リース取引分類コード", "リース取引分類名称", "契約日", "検収日", "満了日", "中途解約日", "契約期間", "経過月数", "対象会計基準コード", "賃貸借フラグ", "耐用年数", "物件名", "利息相当額配分方法コード", "利息相当額配分方法名称", "賦金展開方法コード", "賦金展開方法名称", "維持管理費重要性区分", "維持管理費重要性区分名称", "役務提供費重要性区分", "役務提供費重要性区分名称", "賦金展開端数調整方法コード", "賦金展開端数調整方法名称", "減価償却方法コード", "減価償却方法名称", "減価償却端数調整方法コード", "減価償却端数調整方法名称", "リース料総額税抜", "リース料消費税", "割引現在価値", "割引計算利子率", "見積現金購入価格", "うち残価保証額", "取得価格相当額", "利息計算利子率", "支払利息相当額総額", "月額リース料税抜", "月額リース料消費税", "月額均等償却費相当額", "当期支払リース料", "当期支払リース料消費税", "当期支払リース料うちリース債務返済額", "当期支払リース料支払利息相当額", "当期支払リース料うち登録諸費用（課税）相当額", "当期支払リース料うち登録諸費用（非課税）相当額", "当期支払リース料うち取得税相当額", "当期支払リース料うち自動車税相当額", "当期支払リース料うち重量税相当額", "当期支払リース料うち自賠責保険相当額", "当期支払リース料うち任意保険相当額", "当期支払リース料うちリサイクル料管理費相当額", "当期支払リース料うち動総相当額", "当期支払リース料うち固税相当額", "当期支払リース料うちその他原価相当額", "当期支払リース料うち保守料相当額", "当期減価償却費相当額", "支払リース料累計額", "支払リース料消費税累計額", "支払リース料うちリース債務返済額累計額", "支払リース料支払利息累計額相当額", "支払リース料うち登録諸費用（課税）累計額相当額", "支払リース料うち登録諸費用（非課税）累計額相当額", "支払リース料うち取得税累計額相当額", "支払リース料うち自動車税累計額相当額", "支払リース料うち重量税累計額相当額", "支払リース料うち自賠責保険累計額相当額", "支払リース料うち任意保険累計額相当額", "支払リース料うちリサイクル料管理費累計額相当額", "支払リース料うち動総累計額相当額", "支払リース料うち固税累計額相当額", "支払リース料うちその他原価累計額相当額", "支払リース料うち保守料累計額相当額", "減価償却累計額相当額", "支払リース料残高（一年内）", "支払リース料消費税残高（一年内）", "支払リース料うちリース債務返済額（1年内合計）", "支払リース料支払利息相当額（1年内合計）", "支払リース料うち登録諸費用（課税）相当額（1年内合計）", "支払リース料うち登録諸費用（非課税）相当額（1年内合計）", "支払リース料うち取得税相当額（1年内合計）", "支払リース料うち自動車税相当額（1年内合計）", "支払リース料うち重量税相当額（1年内合計）", "支払リース料うち自賠責保険相当額（1年内合計）", "支払リース料うち任意保険相当額（1年内合計）", "支払リース料うちリサイクル料管理費相当額（1年内合計）", "支払リース料うち動総相当額（1年内合計）", "支払リース料うち固税相当額（1年内合計）", "支払リース料うちその他原価相当額（1年内合計）", "支払リース料うち保守料相当額（1年内合計）", "減価償却相当額（1年内合計）", "支払リース料残高（一年超）", "支払リース料消費税残高（一年超）", "支払リース料うちリース債務返済額（1年超合計）", "支払リース料支払利息相当額（1年超合計）", "支払リース料うち登録諸費用（課税）相当額（1年超合計）", "支払リース料うち登録諸費用（非課税）相当額（1年超合計）", "支払リース料うち取得税相当額（1年超合計）", "支払リース料うち自動車税相当額（1年超合計）", "支払リース料うち重量税相当額（1年超合計）", "支払リース料うち自賠責保険相当額（1年超合計）", "支払リース料うち任意保険相当額（1年超合計）", "支払リース料うちリサイクル料管理費相当額（1年超合計）", "支払リース料うち動総相当額（1年超合計）", "支払リース料うち固税相当額（1年超合計）", "支払リース料うちその他原価相当額（1年超合計）", "支払リース料うち保守料相当額（1年超合計）", "減価償却相当額（1年超合計）", "支払リース料残高（合計）", "支払リース料消費税残高（合計）", "支払リース料うちリース債務返済額（１年内１年超合計）", "支払リース料支払利息相当額（１年内１年超合計）", "支払リース料うち登録諸費用（課税）相当額（１年内１年超合計）", "支払リース料うち登録諸費用（非課税）相当額（１年内１年超合計）", "支払リース料うち取得税相当額（１年内１年超合計）", "支払リース料うち自動車税相当額（１年内１年超合計）", "支払リース料うち重量税相当額（１年内１年超合計）", "支払リース料うち自賠責保険相当額（１年内１年超合計）", "支払リース料うち任意保険相当額（１年内１年超合計）", "支払リース料うちリサイクル料管理費相当額（１年内１年超合計）", "支払リース料うち動総相当額（１年内１年超合計）", "支払リース料うち固税相当額（１年内１年超合計）", "支払リース料うちその他原価相当額（１年内１年超合計）", "支払リース料うち保守料相当額（１年内１年超合計）", "減価償却相当額（１年内１年超合計）" };

			columns = new String[]{ "CREATE_DATE", "START_YMD", "END_YMD", "HYJYO_KEI_NO", "BKN_NO", "BKN_EDANO", "SSN_SRI_CD", "SSN_SRI_NM", "LU_TRSK_CD", "LU_NM", "TRD_HNTE_KEKA_KBN", "TRD_HNTE_KEKA_NM", "KEI_YMD", "KNSHU_YMD", "MRYO_YMD", "KAI_YMD", "KEI_TERM", "KEI_PAST", "TAISHO_AC_KIJYUN_CD", "CTSHK_FLG", "TY_YSU", "BKN_NM", "RSK_KEIJ_HOHO_KBN", "RSK_KEIJ_HOHO_KBN_NM", "TNKI_HOHO_KBN", "TNKI_HOHO_KBN_NM", "IJI_KNRI_HYO_JYO_KBN", "IJI_KNRI_HYO_JYO_KBN_NM", "EKM_TEIK_HYO_JYO_KBN", "EKM_TEIK_HYO_JYO_KBN_NM", "FKN_TNKI_CHSE_CD", "FKN_TNKI_CHSE_CD_NM", "SKK_KEIJ_HOHO_KBN", "SKK_KEIJ_HOHO_KBN_NM", "GNKSK_HASU_CHSE_CD", "GNKSK_HASU_CHSE_CD_NM", "KEI_AMT", "KEI_TAX", "WRBK_PV", "WRBK_RS_RT", "KNU_AMT", "ZANK_AMT", "GNPN_TTL", "RSK_CLC_RS_RT", "RSK_SOU_AMT", "MONTH_AMT", "MONTH_AMT_TAX", "MONTH_KINTO", "LAMT", "LAMT_STAX", "TGTU_GNPN", "TGTU_RSK", "ENT_SHOHYO_KZI", "ENT_SHOHYO_HKZI", "GTAX", "CTAX", "JTAX", "JBSK_HKN", "NNI_HKN", "RCYCL_RYO_KNRI_AMT", "DOSO", "KOZEI", "OTH_CST", "EKM_TEIK_HYO", "TGTU_SKK_AMT", "LAMT_ALL", "LAMT_STAX_ALL", "TGTU_GNPN_ALL", "TGTU_RSK_ALL", "ENT_SHOHYO_KZI_ALL", "ENT_SHOHYO_HKZI_ALL", "GTAX_ALL", "CTAX_ALL", "JTAX_ALL", "JBSK_HKN_ALL", "NNI_HKN_ALL", "RCYCL_RYO_KNRI_AMT_ALL", "DOSO_ALL", "KOZEI_ALL", "OTH_CST_ALL", "EKM_TEIK_HYO_ALL", "TGTU_SKK_AMT_ALL", "LAMT_ZAN_NAI", "LAMT_STAX_ZAN_NAI", "TGTU_GNPN_ZAN_NAI", "TGTU_RSK_ZAN_NAI", "ENT_SHOHYO_KZI_ZAN_NAI", "ENT_SHOHYO_HKZI_ZAN_NAI", "GTAX_ZAN_NAI", "CTAX_ZAN_NAI", "JTAX_ZAN_NAI", "JBSK_HKN_ZAN_NAI", "NNI_HKN_ZAN_NAI", "RCYCL_RYO_KNRI_AMT_ZAN_NAI", "DOSO_ZAN_NAI", "KOZEI_ZAN_NAI", "OTH_CST_ZAN_NAI", "EKM_TEIK_HYO_ZAN_NAI", "TGTU_SKK_AMT_ZAN_NAI", "LAMT_ZAN_CYO", "LAMT_STAX_ZAN_CYO", "TGTU_GNPN_ZAN_CYO", "TGTU_RSK_ZAN_CYO", "ENT_SHOHYO_KZI_ZAN_CYO", "ENT_SHOHYO_HKZI_ZAN_CYO", "GTAX_ZAN_CYO", "CTAX_ZAN_CYO", "JTAX_ZAN_CYO", "JBSK_HKN_ZAN_CYO", "NNI_HKN_ZAN_CYO", "RCYCL_RYO_KNRI_AMT_ZAN_CYO", "DOSO_ZAN_CYO", "KOZEI_ZAN_CYO", "OTH_CST_ZAN_CYO", "EKM_TEIK_HYO_ZAN_CYO", "TGTU_SKK_AMT_ZAN_CYO", "LAMT_ZAN", "LAMT_STAX_ZAN", "TGTU_GNPN_ZAN", "TGTU_RSK_ZAN", "ENT_SHOHYO_KZI_ZAN", "ENT_SHOHYO_HKZI_ZAN", "GTAX_ZAN", "CTAX_ZAN", "JTAX_ZAN", "JBSK_HKN_ZAN", "NNI_HKN_ZAN", "RCYCL_RYO_KNRI_AMT_ZAN", "DOSO_ZAN", "KOZEI_ZAN", "OTH_CST_ZAN", "EKM_TEIK_HYO_ZAN", "TGTU_SKK_AMT_ZAN" };
		}

		try {
			reportEntity.setCon(super.con);

			if (reportEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			tmpFile = File.createTempFile("csv06_" + prefix + "_", ".csv", scratchDirectory);

			reportEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			reportEntity.close();
		}

		return fileName;

	}

}
