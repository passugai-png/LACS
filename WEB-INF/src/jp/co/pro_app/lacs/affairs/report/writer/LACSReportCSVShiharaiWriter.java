package jp.co.pro_app.lacs.affairs.report.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportSiharaiEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 帳票出力：リース会計注記合計表Model.
 * 
 * @author katoken
 * @version 20080328
 */
public class LACSReportCSVShiharaiWriter extends LACSReportCSVWriterBase {

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
	public LACSReportCSVShiharaiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
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
		LACSReportSiharaiEntity reportEntity = new LACSReportSiharaiEntity(super.model, this.commonBean, piReportBean, acStd);
		String fileName = "";

		File tmpFile = null; // 出力先ファイル

		// 2020/05/22 REP START
		//String[] header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "リース会社", "開示先", "リース取引分類コード", "リース取引分類名称", "会計処理方法コード", "会計処理方法名称", "固定資産科目コード", "固定資産科目名称", "利息相当額配分方法コード", "利息相当額配分方法名称", "当期支払リース料計算基準コード", "当期支払リース料計算基準名称", "未経過リース料等計算基準コード", "未経過リース料等計算基準名称", "契約番号", "リース開始日", "リース終了日", "物件番号", "物件名", "中途解約日", "利息計算利子率", "リース料総額", "取得価格相当額", "維持管理費相当額", "役務提供費相当額", "うち残価保証額", "当期支払リース料", "当期維持管理費", "当期役務提供費", "当期支払利息相当額", "当期リース債務返済額", "未経過リース料期末残高相当額", "未経過リース料期末残高相当額(うち1年内)", "未経過リース料期末残高相当額(うち1年超)", "解約不能" };
		//String[] columns = new String[]{ "CREATE_DATE", "START_YMD", "END_YMD", "LEASE_COMPANY", "LEASE_USER", "TRD_HNTE_KEKA_KBN", "LEASE_BUNRUI", "AC_SHR_KBN", "AC_SHR_KBN_NM", "SSN_SRI_CD", "SSN_SRI_NM", "RSK_KEIJ_HOHO_KBN", "RSK_KEIJ_HOHO_KBN_NM", "TNKI_HOHO_KBN", "FKN_TNKI_HOHO_NM", "TNKI_HOHO_KBN", "FKN_TNKI_HOHO_NM", "KEI_NO", "KNSHU_YMD", "MRYO_YMD", "BKN_NO", "BKN_NM", "KAI_YMD", "RSK_CLC_RS_RT", "KEI_AMT", "KNU_AMT", "IJI_KANRIHI", "EKM_TEIK", "ZANK_HSHO_AMT", "LAMT", "TOUKI_IJI_KANRIHI", "TOUKI_EKM_TEIK", "SIHARAI_RSK", "LEASE_SAIMU", "KIMATU_ZAN", "KIMATU_ZAN_1NAI", "KIMATU_ZAN_1CYO", "KAI_FNO_YMD" };
		String[] header = new String[]{ "作成日", "対象期間開始", "対象期間終了", "リース会社", "重要性有無", "開示先", "リース取引分類コード", "リース取引分類名称", "会計処理方法コード", "会計処理方法名称", "固定資産科目コード", "固定資産科目名称", "利息相当額配分方法コード", "利息相当額配分方法名称", "当期支払リース料計算基準コード", "当期支払リース料計算基準名称", "未経過リース料等計算基準コード", "未経過リース料等計算基準名称", "契約番号", "リース開始日", "リース終了日", "物件番号", "物件名", "中途解約日", "利息計算利子率", "リース料総額", "取得価格相当額", "維持管理費相当額", "役務提供費相当額", "うち残価保証額", "当期支払リース料", "当期維持管理費", "当期役務提供費", "当期支払利息相当額", "当期リース債務返済額", "未経過リース料期末残高相当額", "未経過リース料期末残高相当額(うち1年内)", "未経過リース料期末残高相当額(うち1年超)", "解約不能" };
		String[] columns = new String[]{ "CREATE_DATE", "START_YMD", "END_YMD", "LEASE_COMPANY", "JYSI_UM", "LEASE_USER", "TRD_HNTE_KEKA_KBN", "LEASE_BUNRUI", "AC_SHR_KBN", "AC_SHR_KBN_NM", "SSN_SRI_CD", "SSN_SRI_NM", "RSK_KEIJ_HOHO_KBN", "RSK_KEIJ_HOHO_KBN_NM", "TNKI_HOHO_KBN", "FKN_TNKI_HOHO_NM", "TNKI_HOHO_KBN", "FKN_TNKI_HOHO_NM", "KEI_NO", "KNSHU_YMD", "MRYO_YMD", "BKN_NO", "BKN_NM", "KAI_YMD", "RSK_CLC_RS_RT", "KEI_AMT", "KNU_AMT", "IJI_KANRIHI", "EKM_TEIK", "ZANK_HSHO_AMT", "LAMT", "TOUKI_IJI_KANRIHI", "TOUKI_EKM_TEIK", "SIHARAI_RSK", "LEASE_SAIMU", "KIMATU_ZAN", "KIMATU_ZAN_1NAI", "KIMATU_ZAN_1CYO", "KAI_FNO_YMD" };
		// 2020/05/22 REP END

		try {
			reportEntity.setCon(super.con);

			if (reportEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			tmpFile = File.createTempFile("csv03_" + prefix + "_", ".csv", scratchDirectory);

			reportEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			reportEntity.close();
		}

		return fileName;

	}
}
