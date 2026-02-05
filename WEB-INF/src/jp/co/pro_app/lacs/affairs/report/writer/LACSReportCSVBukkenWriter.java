package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportBukkenEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 帳票出力：リース会計資料（減価償却費）Model.
 * 
 * @author katoken
 * @version 20080328
 */
public class LACSReportCSVBukkenWriter extends LACSReportCSVWriterBase {

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
	public LACSReportCSVBukkenWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
		LACSReportBukkenEntity reportEntity = new LACSReportBukkenEntity(super.model, this.commonBean, piReportBean, acStd);
		String fileName = "";

		File tmpFile = null; // 出力先ファイル

		String[] header = new String[]{ "作成日", "基準日", "リース会社", "開示先", "契約番号", "物件番号", "リース取引分類コード", "リース取引分類名称", "会計処理方法コード", "会計処理方法名称", "固定資産科目コード", "固定資産科目名称", "検収日", "満了日", "契約期間", "物件名", "前払／後払区分", "前払／後払区分名称", "利息相当額配分方法コード", "利息相当額配分方法名称", "賦金展開方法コード", "賦金展開方法名称", "割引計算利子率", "割引現在価値", "リース料相当額総額", "維持管理費相当額総額", "役務提供費相当額総額", "見積現金購入価格", "残価保証額", "取得価格相当額", "支払利息相当額総額", "利息計算利子率", "支払年月", "支払リース料", "維持管理費相当額", "役務提供費相当額", "NET支払リース料", "うち利息分", "うちリース債務分", "未経過リース料期末残高相当額", "支払利息相当額" };

		String[] columns = new String[]{ "CREATE_DATE", "CREATE_DATE", "LEASE_COMPANY", "LEASE_USER", "KEI_NO", "BKN_NO", "TRD_HNTE_KEKA_KBN", "LEASE_BUNRUI", "AC_SHR_KBN", "AC_SHR_KBN_NM", "SSN_SRI_CD", "SSN_SRI_NM", "KNSHU_YMD", "MRYO_YMD", "KEI_TERM", "BKN_NM", "MBRI_ABRI_KBN", "MBRI_ABRI_KBN_NM", "RSK_KEIJ_HOHO_KBN", "RSK_KEIJ_HOHO_KBN_NM", "FKN_TNKI_HOHO_CD", "FKN_TNKI_HOHO_NM", "WRBK_CLC_RS_RT", "WRBK_PV", "KEI_AMT", "IJI_KANRIHI_SOU", "EKM_TEIK_HYO_SOU", "KNU_AMT", "ZANK_HSHO_AMT", "SYUTOKU_AMT", "SIHARAI_RSK", "RSK_CLC_RS_RT", "KEIJ_YM", "LAMT", "IJI_KANRIHI", "EKM_TEIK_HYO", "NET_LEASE", "UCHI_RISOKU", "UCHI_SAIMU", "KIMATU_ZAN", "SIHARAI_RISOKU" };

		try {
			reportEntity.setCon(super.con);

			if (reportEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			tmpFile = File.createTempFile("csv05_", ".csv", scratchDirectory);

			reportEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			reportEntity.close();
		}

		return fileName;

	}
}
