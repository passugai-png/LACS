package jp.co.pro_app.lacs.affairs.ukebarai.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.affairs.ukebarai.data.entity.LACSUkebaraiLeaseEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 受払合計表：費用受払表CSV出力.
 * 
 * @author active
 * @version 20080816
 */
public class LACSUkebaraiCSVLeaseWriter extends LACSUkebaraiCSVWriterBase {

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
	public LACSUkebaraiCSVLeaseWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
		LACSUkebaraiLeaseEntity reportEntity = new LACSUkebaraiLeaseEntity(super.model, this.commonBean, piReportBean);
		String fileName = "";

		File tmpFile = null; // 出力先ファイル
		// 2020/05/22 REP START
		//String[] header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "リース会社", "開示先", "リース会計基準コード", "リース会計基準名称", "リース取引分類コード", "リース取引分類名称", "会計処理方法コード", "会計処理方法名称", "資産区分コード", "資産区分名称", "契約番号", "物件番号", "物件名", "リース開始日", "リース終了日", "中途解約日", "リース料総額", "うち残価保証額", "リース債務残高総額", "リース債務残高前期末", "リース債務残高当期増加", "リース債務残高当期実現", "リース債務残高当期減少", "リース債務残高当期末", "支払利息累計総額", "支払利息累計前期末", "支払利息累計当期実現", "支払利息累計当期減少", "支払利息累計当期末", "維持管理費相当額累計総額", "維持管理費相当額累計前期末", "維持管理費相当額累計当期実現", "維持管理費相当額累計当期減少", "維持管理費相当額累計当期末", "役務提供費相当額累計総額", "役務提供費相当額累計前期末", "役務提供費相当額累計当期実現", "役務提供費相当額累計当期減少", "役務提供費相当額累計当期末", "リース料累計総額", "リース料累計前期末", "リース料累計当期実現", "リース料累計当期減少", "リース料累計当期末", "未払金(消費税)残高総額", "未払金(消費税)残高前期末", "未払金(消費税)残高当期増加", "未払金(消費税)残高当期実現", "未払金(消費税)残高当期減少", "未払金(消費税)残高当期末" };
		//String[] columns = new String[]{ "CREATE_DATE", "KIKAN_START", "KIKAN_END", "LC_NM", "LU_NM", "TAISHO_AC_KIJYUN_CD", "TAISHO_AC_KIJYUN_NM", "TRD_HNTE_KEKA_KBN", "TRD_HNTE_KEKA_NM", "CTSHK_FLG", "AC_SHR_NM", "YUKEI_MUKEI_KBN", "SSN_KBN", "KEI_NO", "BKN_NO", "BKN_NM", "KNSHU_YMD", "MRYO_YMD", "KAI_YMD", "LEAS_AMT_SOUGAKU", "ZANK_HSHO_AMT", "SAIMU_SOUGAKU", "SAIMU_ZENKIMATU_AMT", "SAIMU_TOUKI_ZOUKA_AMT", "SAIMU_TOUKI_JITUGEN_AMT", "SAIMU_TOUKI_GENSYO_AMT", "SAIMU_TOUKIMATU_AMT", "RSK_SOUGAKU", "RSK_ZENKIMATU_AMT", "RSK_TOUKI_JITUGEN_AMT", "RSK_TOUKI_GENSYO_AMT", "RSK_TOUKIMATU_AMT", "IJI_SOUGAKU", "IJI_ZENKIMATU_AMT", "IJI_TOUKI_JITUGEN_AMT", "IJI_TOUKI_GENSYO_AMT", "IJI_TOUKIMATU_AMT", "EKM_SOUGAKU", "EKM_ZENKIMATU_AMT", "EKM_TOUKI_JITUGEN_AMT", "EKM_TOUKI_GENSYO_AMT", "EKM_TOUKIMATU_AMT", "LEAS_SOUGAKU", "LEAS_ZENKIMATU_AMT", "LEAS_TOUKI_JITUGEN_AMT", "LEAS_TOUKI_GENSYO_AMT", "LEAS_TOUKIMATU_AMT", "MIBARAI_SOUGAKU", "MIBARAI_ZENKIMATU_AMT", "MIBARAI_TOUKI_ZOUKA_AMT", "MIBARAI_TOUKI_JITUGEN_AMT", "MIBARAI_TOUKI_GENSYO_AMT", "MIBARAI_TOUKIMATU_AMT" };
		String[] header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "リース会社", "開示先", "重要性有無", "リース会計基準コード", "リース会計基準名称", "リース取引分類コード", "リース取引分類名称", "会計処理方法コード", "会計処理方法名称", "資産区分コード", "資産区分名称", "契約番号", "物件番号", "物件名", "リース開始日", "リース終了日", "中途解約日", "リース料総額", "うち残価保証額", "リース債務残高総額", "リース債務残高前期末", "リース債務残高当期増加", "リース債務残高当期実現", "リース債務残高当期減少", "リース債務残高当期末", "残価保証額総額", "残価保証額前期末", "残価保証額当期増加", "残価保証額当期減少", "残価保証額当期末", "支払利息累計総額", "支払利息累計前期末", "支払利息累計当期実現", "支払利息累計当期減少", "支払利息累計当期末", "維持管理費相当額累計総額", "維持管理費相当額累計前期末", "維持管理費相当額累計当期実現", "維持管理費相当額累計当期減少", "維持管理費相当額累計当期末", "役務提供費相当額累計総額", "役務提供費相当額累計前期末", "役務提供費相当額累計当期実現", "役務提供費相当額累計当期減少", "役務提供費相当額累計当期末", "リース料累計総額", "リース料累計前期末", "リース料累計当期実現", "リース料累計当期減少", "リース料累計当期末", "未払金(消費税)残高総額", "未払金(消費税)残高前期末", "未払金(消費税)残高当期増加", "未払金(消費税)残高当期実現", "未払金(消費税)残高当期減少", "未払金(消費税)残高当期末" };
		String[] columns = new String[]{ "CREATE_DATE", "KIKAN_START", "KIKAN_END", "LC_NM", "LU_NM", "JYSI_UM", "TAISHO_AC_KIJYUN_CD", "TAISHO_AC_KIJYUN_NM", "TRD_HNTE_KEKA_KBN", "TRD_HNTE_KEKA_NM", "CTSHK_FLG", "AC_SHR_NM", "YUKEI_MUKEI_KBN", "SSN_KBN", "KEI_NO", "BKN_NO", "BKN_NM", "KNSHU_YMD", "MRYO_YMD", "KAI_YMD", "LEAS_AMT_SOUGAKU", "ZANK_HSHO_AMT", "SAIMU_SOUGAKU", "SAIMU_ZENKIMATU_AMT", "SAIMU_TOUKI_ZOUKA_AMT", "SAIMU_TOUKI_JITUGEN_AMT", "SAIMU_TOUKI_GENSYO_AMT", "SAIMU_TOUKIMATU_AMT", "ZANK_SOUGAKU", "ZANK_ZENKIMATU_AMT", "ZANK_TOUKI_ZOUKA_AMT", "ZANK_TOUKI_GENSYO_AMT", "ZANK_TOUKIMATU_AMT", "RSK_SOUGAKU", "RSK_ZENKIMATU_AMT", "RSK_TOUKI_JITUGEN_AMT", "RSK_TOUKI_GENSYO_AMT", "RSK_TOUKIMATU_AMT", "IJI_SOUGAKU", "IJI_ZENKIMATU_AMT", "IJI_TOUKI_JITUGEN_AMT", "IJI_TOUKI_GENSYO_AMT", "IJI_TOUKIMATU_AMT", "EKM_SOUGAKU", "EKM_ZENKIMATU_AMT", "EKM_TOUKI_JITUGEN_AMT", "EKM_TOUKI_GENSYO_AMT", "EKM_TOUKIMATU_AMT", "LEAS_SOUGAKU", "LEAS_ZENKIMATU_AMT", "LEAS_TOUKI_JITUGEN_AMT", "LEAS_TOUKI_GENSYO_AMT", "LEAS_TOUKIMATU_AMT", "MIBARAI_SOUGAKU", "MIBARAI_ZENKIMATU_AMT", "MIBARAI_TOUKI_ZOUKA_AMT", "MIBARAI_TOUKI_JITUGEN_AMT", "MIBARAI_TOUKI_GENSYO_AMT", "MIBARAI_TOUKIMATU_AMT" };
		// 2020/05/22 REP END
		try {
			reportEntity.setCon(super.con);

			if (reportEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			tmpFile = File.createTempFile("csv23_", ".csv", scratchDirectory);

			reportEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			reportEntity.close();
		}

		return fileName;

	}
}
