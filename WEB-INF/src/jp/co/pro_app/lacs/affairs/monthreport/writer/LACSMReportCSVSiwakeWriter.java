package jp.co.pro_app.lacs.affairs.monthreport.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
//2020/05/22 REP START
//import jp.co.pro_app.lacs.affairs.monthreport.data.entity.LACSMReportSiwakeEntity;
import jp.co.pro_app.lacs.affairs.monthreport.data.entity.LACSMReportSiwakeCSVEntity;
//2020/05/22 REP END
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 月次帳票出力：仕訳合計表CSV出力.
 * 
 * @author fukuhara
 * @version 20080415
 */
public class LACSMReportCSVSiwakeWriter extends LACSMReportCSVWriterBase {

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
	public LACSMReportCSVSiwakeWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
		//2020/05/22 REP START
		//LACSMReportSiwakeEntity reportEntity = new LACSMReportSiwakeEntity(super.model, this.commonBean, piReportBean);
		LACSMReportSiwakeCSVEntity reportEntity = new LACSMReportSiwakeCSVEntity(super.model, this.commonBean, piReportBean);
		//2020/05/22 REP END
		String fileName = "";

		File tmpFile = null; // 出力先ファイル

		String[] header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "開示先", "リース会社", "リース会社郵便番号", "リース会社住所１", "リース会社住所２", "リース会計基準コード", "リース会計基準名称", "会計処理方法コード", "会計処理方法名称", "重要性有無コード", "重要性有無", "支払年月", "借方科目コード", "借方科目名称", "借方金額", "貸方科目コード", "貸方科目名称", "貸方金額" };

		String[] columns = new String[]{ "CREATE_DATE", "TERM_FROM", "TERM_TO", "LEASE_USER_NM", "LEASE_COMPANY_NM", "LEASE_COMPANY_ZIP", "LEASE_COMPANY_ADDR1", "LEASE_COMPANY_ADDR2", "TAISHO_AC_KIJYUN_CD", "TAISHO_AC_KIJYUN_NM", "CTSHK_FLG", "CTSHK_FLG_NM", "JYSI_UM_CD", "JYSI_UM","KEIJ_YM", "KR_KNJ_KMK_CD", "KR_KNJ_KMK_NM", "KRKT_AMT", "KS_KNJ_KMK_CD", "KS_KNJ_KMK_NM", "KSKT_AMT" };

		try {
			reportEntity.setCon(super.con);

			if (reportEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			tmpFile = File.createTempFile("csv13_", ".csv", scratchDirectory);

			reportEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			reportEntity.close();
		}

		return fileName;

	}
}
