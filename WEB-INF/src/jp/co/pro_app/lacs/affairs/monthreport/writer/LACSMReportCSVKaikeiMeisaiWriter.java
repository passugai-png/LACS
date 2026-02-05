package jp.co.pro_app.lacs.affairs.monthreport.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.affairs.monthreport.data.entity.LACSMReportKaikeiMeisaiEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 月次帳票出力：リース会計基準明細書CSV出力.
 * 
 * @author fukuhara
 * @version 20080412
 */
public class LACSMReportCSVKaikeiMeisaiWriter extends LACSMReportCSVWriterBase {

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
	public LACSMReportCSVKaikeiMeisaiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
	public String makeCSV(LACSMReportBean piReportBean, String piDateMode, ServletContext piContext) throws Exception {
		LACSMReportKaikeiMeisaiEntity reportEntity = new LACSMReportKaikeiMeisaiEntity(super.model, this.commonBean, piReportBean);
		String fileName = "";

		File tmpFile = null; // 出力先ファイル

		String[] header = new String[]{ "作成日", "開示先", "リース会社", "リース会社郵便番号", "リース会社住所１", "リース会社住所２", "リース会社電話番号", "契約番号", "リース期間", "契約日", "検収日", "満了日", "代表物件名", "リース取引分類コード", "リース取引分類名称", "リース資産計上額", "契約額", "見積現金購入価格", "消費税総額", "支払利息相当額総額", "残価保証額", "維持管理費相当額総額", "役務提供費相当額総額", "賦金展開方法コード", "賦金展開方法名称", "回収スケジュール展開方法", "回収スケジュール展開方法名称", "減価償却端数調整コード", "減価償却端数調整方法名称", "支払年月", "月額リース料", "うちリース債務分", "うち利息分", "維持管理費相当額", "役務提供費相当額", "未経過リース料", "元本残高", "借方科目コード", "借方科目名称", "借方金額", "貸方科目コード", "貸方科目名称", "貸方金額", "変更年月" };

		String[] columns = new String[]{ "CREATE_DATE", "LEASE_USER_NM", "LEASE_COMPANY_NM", "LEASE_COMPANY_ZIP", "LEASE_COMPANY_ADDR1", "LEASE_COMPANY_ADDR2", "LEASE_COMPANY_TELNO", "HYJYO_KEI_NO", "KEI_TERM", "KEI_YMD", "KNSHU_YMD", "MRYO_YMD", "DIH_BKN_NM", "TRD_HNTE_KEKA_KBN", "TRD_HNTE_KEKA_NM", "LAMT_SUM", "KEI_AMT", "KNU_AMT", "KEI_AMT_STAX_SUM", "RSK_SUM", "ZANK_HSHO_AMT_SUM", "IJI_HYO_SUM", "EKM_HYO_SUM", "RSK_KEIJ_HOHO_KBN", "RSK_KEIJ_HOHO_KBN_NM", "TNKI_HOHO_KBN", "FKN_TNKI_HOHO_NM", "GNKSK_HASU_CHSE_CD", "HASU_CHSE_NM", "KEIJ_YM", "LAMT", "TGTU_GNPN", "TGTU_RSK", "IJI_KANRI_HYO", "EKM_TEIK_HYO", "MK_LAMT", "ZAND_GNPN", "KR_KNJ_KMK_CD", "KR_KNJ_KMK_NM", "KRKT_AMT", "KS_KNJ_KMK_CD", "KS_KNJ_KMK_NM", "KSKT_AMT", "CHA_YM" };
		try {
			reportEntity.setCon(super.con);

			if (reportEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			tmpFile = File.createTempFile("csv11_", ".csv", scratchDirectory);

			reportEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			reportEntity.close();
		}

		return fileName;

	}
}
