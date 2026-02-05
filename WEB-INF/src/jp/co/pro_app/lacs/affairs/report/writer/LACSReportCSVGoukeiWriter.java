package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportGoukeiEntity;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportSsnSriEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 帳票出力：リース会計注記合計表Model.
 * 
 * @author katoken
 * @version 20080328
 */
public class LACSReportCSVGoukeiWriter extends LACSReportCSVWriterBase {

	private DBModelBase	modelBase	= null;

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
	public LACSReportCSVGoukeiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
		LACSReportGoukeiEntity reportEntity = new LACSReportGoukeiEntity(super.model, this.commonBean, piReportBean, acStd);
		String fileName = "";

		LACSReportSsnSriEntity reportSsnSriEntity = new LACSReportSsnSriEntity(modelBase);

		String ssnSriNm1 = ""; // 資産種類名称（CODE=1）
		String ssnSriNm2 = ""; // 資産種類名称（CODE=2）
		String ssnSriNm3 = ""; // 資産種類名称（CODE=3）
		String ssnSriNm4 = ""; // 資産種類名称（CODE=4）
		String ssnSriNm5 = ""; // 資産種類名称（CODE=5）
		String ssnSriNm6 = ""; // 資産種類名称（CODE=6）
		String ssnSriNm7 = ""; // 資産種類名称（CODE=7）
		// 2020/05/22 ADD START
		String ssnSriNm8 = ""; // 資産種類名称（CODE=8）
		String ssnSriNm9 = ""; // 資産種類名称（CODE=9）
		// 2020/05/22 ADD END

		int intCnt = 1;

		reportSsnSriEntity.setCon(super.con);
		reportSsnSriEntity.execSQL();

		while (reportSsnSriEntity.next()) {

			switch (intCnt) {
				case 1:
					ssnSriNm1 = "(" + reportSsnSriEntity.getSsnSriNm() + ")";
					break;
				case 2:
					ssnSriNm2 = "(" + reportSsnSriEntity.getSsnSriNm() + ")";
					break;
				case 3:
					ssnSriNm3 = "(" + reportSsnSriEntity.getSsnSriNm() + ")";
					break;
				case 4:
					ssnSriNm4 = "(" + reportSsnSriEntity.getSsnSriNm() + ")";
					break;
				case 5:
					ssnSriNm5 = "(" + reportSsnSriEntity.getSsnSriNm() + ")";
					break;
				case 6:
					ssnSriNm6 = "(" + reportSsnSriEntity.getSsnSriNm() + ")";
					break;
				case 7:
					ssnSriNm7 = "(" + reportSsnSriEntity.getSsnSriNm() + ")";
					break;
				// 2020/05/22 ADD START
				case 8:
					ssnSriNm8 = "(" + reportSsnSriEntity.getSsnSriNm() + ")";
					break;
				case 9:
					ssnSriNm9 = "(" + reportSsnSriEntity.getSsnSriNm() + ")";
					break;
				// 2020/05/22 ADD END
				default:
					break;
			}
			intCnt++;

		}
		reportSsnSriEntity.close();

		File tmpFile = null; // 出力先ファイル

		// 2020/05/22 REP START
		String[] header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "リース会社", "開示先", "会計処理方法コード", "会計処理方法", "取得価格相当額" + ssnSriNm1, "減価償却累計額相当額" + ssnSriNm1, "期末残高相当額" + ssnSriNm1, "取得価格相当額" + ssnSriNm2, "減価償却累計額相当額" + ssnSriNm2, "期末残高相当額" + ssnSriNm2, "取得価格相当額" + ssnSriNm3, "減価償却累計額相当額" + ssnSriNm3, "期末残高相当額" + ssnSriNm3, "取得価格相当額" + ssnSriNm4, "減価償却累計額相当額" + ssnSriNm4, "期末残高相当額" + ssnSriNm4, "取得価格相当額" + ssnSriNm5, "減価償却累計額相当額" + ssnSriNm5, "期末残高相当額" + ssnSriNm5, "取得価格相当額" + ssnSriNm6, "減価償却累計額相当額" + ssnSriNm6, "期末残高相当額" + ssnSriNm6, "取得価格相当額" + ssnSriNm7, "減価償却累計額相当額" + ssnSriNm7, "期末残高相当額" + ssnSriNm7, "取得価格相当額" + ssnSriNm8, "減価償却累計額相当額" + ssnSriNm8, "期末残高相当額" + ssnSriNm8, "取得価格相当額" + ssnSriNm9, "減価償却累計額相当額" + ssnSriNm9, "期末残高相当額" + ssnSriNm9, "取得価格相当額（合計）", "減価償却累計額相当額（合計）", "期末残高相当額（合計）", "未経過リース料期末残高相当額（１年内）", "未経過リース料期末残高相当額（１年超）", "未経過リース料期末残高相当額（合計）", "支払リース料", "減価償却費相当額", "支払利息相当額", "未経過リース料（１年内）", "未経過リース料（１年超）", "未経過リース料（合計）" };
		//String[] header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "リース会社", "開示先", "会計処理方法コード", "会計処理方法", "取得価格相当額" + ssnSriNm1, "減価償却累計額相当額" + ssnSriNm1, "期末残高相当額" + ssnSriNm1, "取得価格相当額" + ssnSriNm2, "減価償却累計額相当額" + ssnSriNm2, "期末残高相当額" + ssnSriNm2, "取得価格相当額" + ssnSriNm3, "減価償却累計額相当額" + ssnSriNm3, "期末残高相当額" + ssnSriNm3, "取得価格相当額" + ssnSriNm4, "減価償却累計額相当額" + ssnSriNm4, "期末残高相当額" + ssnSriNm4, "取得価格相当額" + ssnSriNm5, "減価償却累計額相当額" + ssnSriNm5, "期末残高相当額" + ssnSriNm5, "取得価格相当額" + ssnSriNm6, "減価償却累計額相当額" + ssnSriNm6, "期末残高相当額" + ssnSriNm6, "取得価格相当額" + ssnSriNm7, "減価償却累計額相当額" + ssnSriNm7, "期末残高相当額" + ssnSriNm7, "取得価格相当額（合計）", "減価償却累計額相当額（合計）", "期末残高相当額（合計）", "未経過リース料期末残高相当額（１年内）", "未経過リース料期末残高相当額（１年超）", "未経過リース料期末残高相当額（合計）", "支払リース料", "減価償却費相当額", "支払利息相当額", "未経過リース料（１年内）", "未経過リース料（１年超）", "未経過リース料（合計）" };
		// 2020/05/22 REP END

		// 2020/05/22 REP START
		String[] columns = new String[]{ "CREATE_DATE", "START_YMD", "END_YMD", "LC_NM", "LU_NM", "AC_SHR_KBN", "KAIKEI_SHYORI", "SYUTOKU01", "GENKA01", "ZANDAKA01", "SYUTOKU02", "GENKA02", "ZANDAKA02", "SYUTOKU03", "GENKA03", "ZANDAKA03", "SYUTOKU04", "GENKA04", "ZANDAKA04", "SYUTOKU05", "GENKA05", "ZANDAKA05", "SYUTOKU06", "GENKA06", "ZANDAKA06", "SYUTOKU07", "GENKA07", "ZANDAKA07", "SYUTOKU08", "GENKA08", "ZANDAKA08", "SYUTOKU09", "GENKA09", "ZANDAKA09", "SYUTOKU_TOTAL", "GENKA_TOTAL", "ZANDAKA_TOTAL", "MIKEIKA_ZAN01", "MIKEIKA_ZAN02", "MIKEIKA_ZAN03", "TOUKI_SIHARAI", "TOUKI_GENKA", "TOUKI_RISOKU", "MIKEIKA01", "MIKEIKA02", "MIKEIKA03" };
		//String[] columns = new String[]{ "CREATE_DATE", "START_YMD", "END_YMD", "LC_NM", "LU_NM", "AC_SHR_KBN", "KAIKEI_SHYORI", "SYUTOKU01", "GENKA01", "ZANDAKA01", "SYUTOKU02", "GENKA02", "ZANDAKA02", "SYUTOKU03", "GENKA03", "ZANDAKA03", "SYUTOKU04", "GENKA04", "ZANDAKA04", "SYUTOKU05", "GENKA05", "ZANDAKA05", "SYUTOKU06", "GENKA06", "ZANDAKA06", "SYUTOKU07", "GENKA07", "ZANDAKA07", "SYUTOKU_TOTAL", "GENKA_TOTAL", "ZANDAKA_TOTAL", "MIKEIKA_ZAN01", "MIKEIKA_ZAN02", "MIKEIKA_ZAN03", "TOUKI_SIHARAI", "TOUKI_GENKA", "TOUKI_RISOKU", "MIKEIKA01", "MIKEIKA02", "MIKEIKA03" };
		// 2020/05/22 REP END

		try {
			reportEntity.setCon(super.con);

			if (reportEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			tmpFile = File.createTempFile("csv01_" + prefix + "_", ".csv", scratchDirectory);

			reportEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			reportEntity.close();
		}

		return fileName;

	}

	/**
	 * DBModelBase設定.
	 * 
	 * @param piModelBase
	 *            DBModelBase
	 */
	public void setModelBase(DBModelBase piModelBase) {
		this.modelBase = piModelBase;
	}

}
