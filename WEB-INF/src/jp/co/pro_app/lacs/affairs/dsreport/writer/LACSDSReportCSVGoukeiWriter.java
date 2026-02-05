package jp.co.pro_app.lacs.affairs.dsreport.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.dsreport.bean.LACSDSReportBean;
import jp.co.pro_app.lacs.affairs.dsreport.data.entity.LACSDSReportGoukeiEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 帳票出力：リース会計注記合計表Model.
 * 
 * @author katoken
 * @version 20080328
 */
public class LACSDSReportCSVGoukeiWriter extends LACSDSReportCSVWriterBase {

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
	public LACSDSReportCSVGoukeiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
	}

	/**
	 * CSV作成.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @param piContext
	 *            ServletContext
	 * @return PDFファイル名
	 * @exception Exception
	 *                実行例外
	 */
	public String makeCSV(LACSDSReportBean piReportBean, ServletContext piContext) throws Exception {
		LACSDSReportGoukeiEntity reportEntity = new LACSDSReportGoukeiEntity(super.model, this.commonBean, piReportBean);
		String fileName = "";

		File tmpFile = null; // 出力先ファイル

		String[] header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "１年内開始", "１年内終了", "２年内開始", "２年内終了", "３年内開始", "３年内終了", "４年内開始", "４年内終了", "５年内開始", "５年内終了", "１年超", "５年超", "所有権移転外ファイナンスリース未経過リース料", "所有権移転外ファイナンスリース見積残存価格", "所有権移転外ファイナンスリース受取利息相当額", "所有権移転外ファイナンスリース維持管理費用相当額", "所有権移転外ファイナンスリース役務提供費相当額", "所有権移転外ファイナンスリースうち、元本", "所有権移転ファイナンスリース(１年内)", "所有権移転ファイナンスリース(2年内)", "所有権移転ファイナンスリース(3年内)", "所有権移転ファイナンスリース(4年内)", "所有権移転ファイナンスリース(5年内)", "所有権移転ファイナンスリース(5年超)", "所有権移転外ファイナンスリース(１年内)", "所有権移転外ファイナンスリース(2年内)", "所有権移転外ファイナンスリース(3年内)", "所有権移転外ファイナンスリース(4年内)", "所有権移転外ファイナンスリース(5年内)", "所有権移転外ファイナンスリース(5年超)", "オペレーティングリース(１年内)", "オペレーティングリース(１年超)", "オペレーティングリース(合計)" };

		String[] columns = new String[]{ "CREATE_DATE", "START_YMD", "END_YMD", "FIRST_START_KEIJ_YM", "FIRST_END_KEIJ_YM", "SECOND_START_KEIJ_YM", "SECOND_END_KEIJ_YM", "THIRD_START_KEIJ_YM", "THIRD_END_KEIJ_YM", "FOURTH_START_KEIJ_YM", "FOURTH_END_KEIJ_YM", "FIFTH_START_KEIJ_YM", "FIFTH_END_KEIJ_YM", "SECOND_START_KEIJ_YM", "OVER_START_KEIJ_YM", "B1_GFL_A_LAMT", "B1_GFL_B_MTMR_ZANZON_AMT", "B1_GFL_C_HSE_RSK", "B1_GFL_D_IJI_KANRI_AMT", "B1_GFL_E_EKIM_TEIK_AMT", "B1_GFL_F_GNPN_AMT", "B2_FL_FIRST_AMT", "B2_FL_SECOND_AMT", "B2_FL_THIRD_AMT", "B2_FL_FOURTH_AMT", "B2_FL_FIFTH_AMT", "B2_FL_OVER_AMT", "B2_GFL_FIRST_AMT", "B2_GFL_SECOND_AMT", "B2_GFL_THIRD_AMT", "B2_GFL_FOURTH_AMT", "B2_GFL_FIFTH_AMT", "B2_GFL_OVER_AMT", "B3_OP_FIRST_AMT", "B3_OP_OVER_AMT", "B3_OP_TOTAL_AMT", };

		try {
			reportEntity.setCon(super.con);

			if (reportEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			tmpFile = File.createTempFile("csv41_", ".csv", scratchDirectory);

			reportEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			reportEntity.close();
		}

		return fileName;

	}
}
