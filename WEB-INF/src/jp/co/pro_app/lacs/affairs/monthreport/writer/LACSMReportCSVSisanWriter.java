package jp.co.pro_app.lacs.affairs.monthreport.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.affairs.monthreport.data.entity.LACSMReportSisanEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 月次帳票出力：資産台帳Model.
 * 
 * @author yokota
 * @version 20081030
 */
public class LACSMReportCSVSisanWriter extends LACSMReportCSVWriterBase {

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
	public LACSMReportCSVSisanWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
		LACSMReportSisanEntity reportEntity = new LACSMReportSisanEntity(super.model, this.commonBean, piReportBean);
		String fileName = "";

		File tmpFile = null; // 出力先ファイル
		String[] header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "リース会社", "開示先", "会計基準コード", "会計基準名称", "リース取引分類", "リース取引分類名称", "会計処理方法", "会計処理方法名称", "資産区分", "資産区分名称", "固定資産科目コード", "固定資産科目名称", "契約番号", "物件番号", "物件名", "数量", "検収年月", "取得価格相当額", "償却期間", "償却方法区分", "償却方法名称", "償却率", "月数", "前期末簿価", "当月発生", "当月減少", "当月実現", "当期末簿価" };
		String[] columns = new String[]{ "CREATE_DATE", "START_YMD", "END_YMD", "LEASE_COMPANY", "LEASE_USER", "TAISHO_AC_KIJYUN_CD", "TAISHO_AC_KIJYUN_NM", "TRD_HNTE_KEKA_KBN", "TRD_HNTE_KEKA_NM", "CTSHK_FLG", "AC_SHR_KBN_NM", "YUKEI_MUKEI_KBN", "YUKEI_MUKEI_NM", "SSN_SRI_CD", "SSN_SRI_NM", "HYJYO_KEI_NO", "BKN_NO", "BKN_NM", "BKN_SU", "KNSHU_YM", "SYUTOKU_AMT", "SYOUKYAKU_TERM", "SKK_KEIJ_HOHO_KBN", "SKK_HOHO_NM", "SKK_RT", "M_COUNT", "ZENKI_BOKA", "TOU_HASSEI", "TOU_GENSYO", "TOU_JITSU", "TOUKIMATSU_BOKA" };

		try {
			reportEntity.setCon(super.con);

			if (reportEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			tmpFile = File.createTempFile("csv15_", ".csv", scratchDirectory);
			reportEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			reportEntity.close();
		}

		return fileName;

	}
}
