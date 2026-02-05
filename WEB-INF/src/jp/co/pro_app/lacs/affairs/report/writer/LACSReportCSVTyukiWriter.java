package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportTyukiEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 帳票出力：注記書類作成基準書 Model.
 * 
 * @author fukuhara
 * @version 20080409
 */
public class LACSReportCSVTyukiWriter extends LACSReportCSVWriterBase {

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
	public LACSReportCSVTyukiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
		LACSReportTyukiEntity reportEntity = new LACSReportTyukiEntity(super.model, this.commonBean, piReportBean, acStd);
		String fileName = "";
		String[] header = null;
		String[] columns = null;

		File tmpFile = null; // 出力先ファイル

		if ("1".equals(super.commonBean.getControlTyukiPdf())) {
			header = new String[]{ "作成日", "開示先", "開示先郵便番号", "開示先住所１", "開示先住所２", "リース会社", "リース会社郵便番号", "リース会社住所１", "リース会社住所２", "対象期間開始", "対象期間終了", "会計処理方法", "旧会計基準-少額資産", "旧会計基準-リース期間1年未満", "旧会計基準-再リース契約", "旧会計基準-中途解約物件", "新会計基準-少額資産", "新会計基準-リース期間1年以内", "新会計基準-再リース契約", "新会計基準-中途解約物件", "旧会計基準-所有権移転有形償却方法コード", "旧会計基準-所有権移転有形償却方法名称", "旧会計基準-所有権移転無形償却方法コード", "旧会計基準-所有権移転無形償却方法名称", "旧会計基準-所有権移転外有形償却方法コード", "旧会計基準-所有権移転外有形償却方法名称", "旧会計基準-所有権移転外無形償却方法コード", "旧会計基準-所有権移転外無形償却方法名称", "旧会計基準-減価償却端数調整コード", "旧会計基準-減価償却端数調整名称", "旧会計基準-利息相当額配分方法コード", "旧会計基準-利息相当額配分方法名称", "旧会計基準-賦金展開方法コード", "旧会計基準-賦金展開方法名称", "旧会計基準-賦金展開調整コード", "旧会計基準-賦金展開調整名称", "旧会計基準-維持管理費重要性区分", "旧会計基準-維持管理費重要性区分名称", "旧会計基準-役務提供費用重要性区分", "旧会計基準-役務提供費用重要性区分名称", "新会計基準-所有権移転有形償却方法コード", "新会計基準-所有権移転有形償却方法名称", "新会計基準-所有権移転無形償却方法コード", "新会計基準-所有権移転無形償却方法名称", "新会計基準-所有権移転外有形償却方法コード", "新会計基準-所有権移転外有形償却方法名称", "新会計基準-所有権移転外無形償却方法コード", "新会計基準-所有権移転外無形償却方法名称", "新会計基準-減価償却端数調整コード", "新会計基準-減価償却端数調整名称", "新会計基準-利息相当額配分方法コード", "新会計基準-利息相当額配分方法名称", "新会計基準-賦金展開方法コード", "新会計基準-賦金展開方法名称", "新会計基準-賦金展開調整コード", "新会計基準-賦金展開調整名称", "新会計基準-維持管理費重要性区分", "新会計基準-維持管理費重要性区分名称", "新会計基準-役務提供費用重要性区分", "新会計基準-役務提供費用重要性区分名称" };

			columns = new String[]{ "CREATE_DATE", "LEASE_USER_NM", "LEASE_USER_ZIP", "LEASE_USER_ADDR1", "LEASE_USER_ADDR2", "LEASE_COMPANY_NM", "LEASE_COMPANY_ZIP", "LEASE_COMPANY_ADDR1", "LEASE_COMPANY_ADDR2", "TERM_FROM", "TERM_TO", "KAIKEI_SYORI", "OLD_KEIYAKU_GAKU", "OLD_LEASE_KIKAN", "OLD_SAI_LEASE", "OLD_TYUTO_KAIYAKU", "NEW_KEIYAKU_GAKU", "NEW_LEASE_KIKAN", "NEW_SAI_LEASE", "NEW_TYUTO_KAIYAKU", "OLD_ITN_YUKEI_SKK_HOHO_KBN", "OLD_ITN_YUKEI_SKK_HOHO_NM", "OLD_ITN_MUKEI_SKK_HOHO_KBN", "OLD_ITN_MUKEI_SKK_HOHO_NM", "OLD_ITNGI_YUKEI_SKK_HOHO_KBN", "OLD_ITNGI_YUKEI_SKK_HOHO_NM", "OLD_ITNGI_MUKEI_SKK_HOHO_KBN", "OLD_ITNGI_MUKEI_SKK_HOHO_NM", "OLD_GNKSK_HASU_CHSE_KBN", "OLD_GNKSK_HASU_CHSE_NM", "OLD_RSK_CLC_HOHO_KBN", "OLD_RSK_CLC_HOHO_NM", "OLD_FKN_TNKI_HOHO_KBN", "OLD_FKN_TNKI_HOHO_NM", "OLD_FKN_TNKI_CHSE_KBN", "OLD_FKN_TNKI_CHSE_NM", "OLD_IJI_KNRI_HYO_JYO_KBN", "OLD_IJI_KNRI_HYO_JYO_NM", "OLD_EKM_TEIK_HYO_JYO_KBN", "OLD_EKM_TEIK_HYO_JYO_NM", "NEW_ITN_YUKEI_SKK_HOHO_KBN", "NEW_ITN_YUKEI_SKK_HOHO_NM", "NEW_ITN_MUKEI_SKK_HOHO_KBN", "NEW_ITN_MUKEI_SKK_HOHO_NM", "NEW_ITNGI_YUKEI_SKK_HOHO_KBN", "NEW_ITNGI_YUKEI_SKK_HOHO_NM", "NEW_ITNGI_MUKEI_SKK_HOHO_KBN", "NEW_ITNGI_MUKEI_SKK_HOHO_NM", "NEW_GNKSK_HASU_CHSE_KBN", "NEW_GNKSK_HASU_CHSE_NM", "NEW_RSK_CLC_HOHO_KBN", "NEW_RSK_CLC_HOHO_NM", "NEW_FKN_TNKI_HOHO_KBN", "NEW_FKN_TNKI_HOHO_NM", "NEW_FKN_TNKI_CHSE_KBN", "NEW_FKN_TNKI_CHSE_NM", "NEW_IJI_KNRI_HYO_JYO_KBN", "NEW_IJI_KNRI_HYO_JYO_NM", "NEW_EKM_TEIK_HYO_JYO_KBN", "NEW_EKM_TEIK_HYO_JYO_NM" };
		}
		else {
			header = new String[]{ "作成日", "開示先", "リース会社", "リース会社郵便番号", "リース会社住所１", "リース会社住所２", "対象期間開始", "対象期間終了", "会計処理方法", "旧会計基準-少額資産", "旧会計基準-リース期間1年未満", "旧会計基準-再リース契約", "旧会計基準-中途解約物件", "新会計基準-少額資産", "新会計基準-リース期間1年以内", "新会計基準-再リース契約", "新会計基準-中途解約物件", "旧会計基準-所有権移転有形償却方法コード", "旧会計基準-所有権移転有形償却方法名称", "旧会計基準-所有権移転無形償却方法コード", "旧会計基準-所有権移転無形償却方法名称", "旧会計基準-所有権移転外有形償却方法コード", "旧会計基準-所有権移転外有形償却方法名称", "旧会計基準-所有権移転外無形償却方法コード", "旧会計基準-所有権移転外無形償却方法名称", "旧会計基準-減価償却端数調整コード", "旧会計基準-減価償却端数調整名称", "旧会計基準-利息相当額配分方法コード", "旧会計基準-利息相当額配分方法名称", "旧会計基準-賦金展開方法コード", "旧会計基準-賦金展開方法名称", "旧会計基準-賦金展開調整コード", "旧会計基準-賦金展開調整名称", "旧会計基準-維持管理費重要性区分", "旧会計基準-維持管理費重要性区分名称", "旧会計基準-役務提供費用重要性区分", "旧会計基準-役務提供費用重要性区分名称", "新会計基準-所有権移転有形償却方法コード", "新会計基準-所有権移転有形償却方法名称", "新会計基準-所有権移転無形償却方法コード", "新会計基準-所有権移転無形償却方法名称", "新会計基準-所有権移転外有形償却方法コード", "新会計基準-所有権移転外有形償却方法名称", "新会計基準-所有権移転外無形償却方法コード", "新会計基準-所有権移転外無形償却方法名称", "新会計基準-減価償却端数調整コード", "新会計基準-減価償却端数調整名称", "新会計基準-利息相当額配分方法コード", "新会計基準-利息相当額配分方法名称", "新会計基準-賦金展開方法コード", "新会計基準-賦金展開方法名称", "新会計基準-賦金展開調整コード", "新会計基準-賦金展開調整名称", "新会計基準-維持管理費重要性区分", "新会計基準-維持管理費重要性区分名称", "新会計基準-役務提供費用重要性区分", "新会計基準-役務提供費用重要性区分名称" };

			columns = new String[]{ "CREATE_DATE", "LEASE_USER_NM", "LEASE_COMPANY_NM", "LEASE_COMPANY_ZIP", "LEASE_COMPANY_ADDR1", "LEASE_COMPANY_ADDR2", "TERM_FROM", "TERM_TO", "KAIKEI_SYORI", "OLD_KEIYAKU_GAKU", "OLD_LEASE_KIKAN", "OLD_SAI_LEASE", "OLD_TYUTO_KAIYAKU", "NEW_KEIYAKU_GAKU", "NEW_LEASE_KIKAN", "NEW_SAI_LEASE", "NEW_TYUTO_KAIYAKU", "OLD_ITN_YUKEI_SKK_HOHO_KBN", "OLD_ITN_YUKEI_SKK_HOHO_NM", "OLD_ITN_MUKEI_SKK_HOHO_KBN", "OLD_ITN_MUKEI_SKK_HOHO_NM", "OLD_ITNGI_YUKEI_SKK_HOHO_KBN", "OLD_ITNGI_YUKEI_SKK_HOHO_NM", "OLD_ITNGI_MUKEI_SKK_HOHO_KBN", "OLD_ITNGI_MUKEI_SKK_HOHO_NM", "OLD_GNKSK_HASU_CHSE_KBN", "OLD_GNKSK_HASU_CHSE_NM", "OLD_RSK_CLC_HOHO_KBN", "OLD_RSK_CLC_HOHO_NM", "OLD_FKN_TNKI_HOHO_KBN", "OLD_FKN_TNKI_HOHO_NM", "OLD_FKN_TNKI_CHSE_KBN", "OLD_FKN_TNKI_CHSE_NM", "OLD_IJI_KNRI_HYO_JYO_KBN", "OLD_IJI_KNRI_HYO_JYO_NM", "OLD_EKM_TEIK_HYO_JYO_KBN", "OLD_EKM_TEIK_HYO_JYO_NM", "NEW_ITN_YUKEI_SKK_HOHO_KBN", "NEW_ITN_YUKEI_SKK_HOHO_NM", "NEW_ITN_MUKEI_SKK_HOHO_KBN", "NEW_ITN_MUKEI_SKK_HOHO_NM", "NEW_ITNGI_YUKEI_SKK_HOHO_KBN", "NEW_ITNGI_YUKEI_SKK_HOHO_NM", "NEW_ITNGI_MUKEI_SKK_HOHO_KBN", "NEW_ITNGI_MUKEI_SKK_HOHO_NM", "NEW_GNKSK_HASU_CHSE_KBN", "NEW_GNKSK_HASU_CHSE_NM", "NEW_RSK_CLC_HOHO_KBN", "NEW_RSK_CLC_HOHO_NM", "NEW_FKN_TNKI_HOHO_KBN", "NEW_FKN_TNKI_HOHO_NM", "NEW_FKN_TNKI_CHSE_KBN", "NEW_FKN_TNKI_CHSE_NM", "NEW_IJI_KNRI_HYO_JYO_KBN", "NEW_IJI_KNRI_HYO_JYO_NM", "NEW_EKM_TEIK_HYO_JYO_KBN", "NEW_EKM_TEIK_HYO_JYO_NM" };
		}

		try {
			reportEntity.setCon(super.con);

			if (reportEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			if ("1".equals(super.commonBean.getControlTyukiPdf())) {
				tmpFile = File.createTempFile("csv04_agl_", ".csv", scratchDirectory);
			}
			else {
				tmpFile = File.createTempFile("csv04_", ".csv", scratchDirectory);
			}

			reportEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			reportEntity.close();
		}

		return fileName;

	}
}
