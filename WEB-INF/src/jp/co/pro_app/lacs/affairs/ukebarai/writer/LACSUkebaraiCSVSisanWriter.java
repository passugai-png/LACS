package jp.co.pro_app.lacs.affairs.ukebarai.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.affairs.ukebarai.data.entity.LACSUkebaraiSisanEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 受払合計表：リース資産受払明細表CSV出力.
 * 
 * @author active
 * @version 20080816
 */
public class LACSUkebaraiCSVSisanWriter extends LACSUkebaraiCSVWriterBase {

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
	public LACSUkebaraiCSVSisanWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
	public String makeCSV(LACSUkebaraiBean piReportBean, ServletContext piContext) throws Exception {
		LACSUkebaraiSisanEntity reportEntity = new LACSUkebaraiSisanEntity(super.model, this.commonBean, piReportBean);
		String fileName = "";

		File tmpFile = null; // 出力先ファイル
		// 2020/05/22 ADD START
		// 2020/05/22 ADD END
		//String[] header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "リース会社", "開示先", "リース会計基準コード", "リース会計基準名称", "リース取引分類コード", "リース取引分類名称", "会計処理方法コード", "会計処理方法名称", "資産区分", "資産区分名称", "契約番号", "物件番号", "物件名", "リース開始日", "リース終了日", "中途解約日", "前期末残高", "前期末償却累計", "前期末簿価", "当期増加高", "当期増加簿価", "当期実現", "当期減少高", "当期減少簿価", "当期末残高", "当期末償却累計", "当期末簿価" };
		//String[] columns = new String[]{ "CREATE_DATE", "KIKAN_START", "KIKAN_END", "LC_NM", "LU_NM", "TAISHO_AC_KIJYUN_CD", "TAISHO_AC_KIJYUN_NM", "TRD_HNTE_KEKA_CD", "TRD_HNTE_KEKA_NM", "AC_SHR_CD", "AC_SHR_NM", "SSN_KBN_CD", "SSN_KBN", "KEI_NO", "BKN_NO", "BKN_NM", "KNSHU_YMD", "MRYO_YMD", "KAI_YMD", "ZENKI_MATU_ZAN_AMT", "ZENKI_MATU_SYOKYAKU_AMT", "ZENKI_MATU_BOKA_AMT", "TOUKI_ZOUKA_AMT", "TOUKI_ZOUKA_BOKA_AMT", "TOUKI_JITUGEN_AMT", "TOUKI_GENSYO_AMT", "TOUKI_GENSYO_BOKA_AMT", "TOUKI_MATU_ZAN_AMT", "TOUKI_MATU_SYOKYAKU_AMT", "TOUKI_MATU_BOKA_AMT" };

		String[] header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "リース会社", "重要性有無", "開示先", "リース会計基準コード", "リース会計基準名称", "リース取引分類コード", "リース取引分類名称", "会計処理方法コード", "会計処理方法名称", "資産区分", "資産区分名称", "資産種類コード", "固定資産区分名", "契約番号", "物件番号", "物件名", "リース開始日", "リース終了日", "中途解約日", "残価保証額", "前期末残高", "前期末償却累計", "前期末簿価", "当期増加高", "当期増加簿価", "当期実現", "当期減少高", "当期減少簿価", "当期末残高", "当期末償却累計", "当期末簿価" };
		String[] columns = new String[]{ "CREATE_DATE", "KIKAN_START", "KIKAN_END", "LC_NM", "JYSI_UM", "LU_NM", "TAISHO_AC_KIJYUN_CD", "TAISHO_AC_KIJYUN_NM", "TRD_HNTE_KEKA_CD", "TRD_HNTE_KEKA_NM", "AC_SHR_CD", "AC_SHR_NM", "SSN_KBN_CD", "SSN_KBN", "SSN_SRI_CD", "SSN_SRI_NM", "KEI_NO", "BKN_NO", "BKN_NM", "KNSHU_YMD", "MRYO_YMD", "KAI_YMD", "ZANK_HSHO_AMT", "ZENKI_MATU_ZAN_AMT", "ZENKI_MATU_SYOKYAKU_AMT", "ZENKI_MATU_BOKA_AMT", "TOUKI_ZOUKA_AMT", "TOUKI_ZOUKA_BOKA_AMT", "TOUKI_JITUGEN_AMT", "TOUKI_GENSYO_AMT", "TOUKI_GENSYO_BOKA_AMT", "TOUKI_MATU_ZAN_AMT", "TOUKI_MATU_SYOKYAKU_AMT", "TOUKI_MATU_BOKA_AMT" };
		// 2020/05/22 ADD END
		try {
			reportEntity.setCon(super.con);

			if (reportEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			tmpFile = File.createTempFile("csv22_", ".csv", scratchDirectory);

			reportEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			reportEntity.close();
		}

		return fileName;

	}
}
