package jp.co.pro_app.lacs.affairs.report.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.common.command.LACSDispControlCommon;
import jp.co.pro_app.lacs.affairs.common.command.LACSMessage;
import jp.co.pro_app.lacs.affairs.common.command.LACSZipIO;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSLoginCompanyEntity;
import jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuBean;
import jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuDetailBean;
import jp.co.pro_app.lacs.affairs.keiyaku.data.entity.LACSKeiyakuEntity;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.affairs.monthreport.common.LACSMReportCommon;
import jp.co.pro_app.lacs.affairs.monthreport.writer.LACSMReportPDFKaikeiMeisaiWriter;
import jp.co.pro_app.lacs.affairs.monthreport.writer.LACSMReportPDFSiwakeWriter;
//2020/05/22 ADD START LACS帳票バッチ出力
//期日別予定表をimport
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportPDFKizitubetuSisanWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportPDFKizitubetuSaimuWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSreportPDFKizitubetuGoukeiWriter;
//2020/05/22 ADD END   LACS帳票バッチ出力
//import jp.co.pro_app.lacs.affairs.report.bean.LACSReportAtesakiBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.common.LACSReportCommon;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportUserBatchEntity;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportUserEntity;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSUserLeasCompanyBatchEntity;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportCSVPrintBatchWriter;
//import jp.co.pro_app.lacs.affairs.report.writer.LACSReportPDFAtesakiWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportPDFGoukeiWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportPDFTyukiWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportPDFSiharaiWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportPDFGenkaWriter;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.affairs.ukebarai.common.LACSUkebaraiCommon;
import jp.co.pro_app.lacs.affairs.ukebarai.writer.LACSUkebaraiPDFGokeiWriter;
import jp.co.pro_app.lacs.affairs.ukebarai.writer.LACSUkebaraiPDFLeaseWriter;
import jp.co.pro_app.lacs.affairs.ukebarai.writer.LACSUkebaraiPDFSisanWriter;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.command.FileUtil;
import jp.co.pro_app.projframe.common.command.StringUtl;
import jp.co.pro_app.projframe.common.exception.IllegalOperationException;
import jp.co.pro_app.projframe.common.html.ComboValue;

/**
 * LACS帳票バッチ出力model.
 * 
 * @author Ren.SL
 * @version 20130411
 */
public class LACSReportPDFPrintBatchModel extends LACSReportModelBase {

	private static final String SCRATCH_PATH = "out_pdf";

	private static final String BATCH_SCRATCH_PATH = "batch_out_pdf";

	/**
	 * CSVファイル作成用.
	 */
	class ReportCVS {
		private List<String[]> lines = new ArrayList<String[]>();

		// 2020/05/22 REP START LACS帳票バッチ出力
//		private static final int COLUM_NUM = 15;
		private static final int COLUM_NUM = 1;
		// 2020/05/22 REP END LACS帳票バッチ出力

		// 2020/05/22 ADD START LACS帳票バッチ出力
		private static final int CVS_CELL_KAIJI_CD_NM = 0; // 開示先コード_開示先名
		// 2020/05/22 ADD END LACS帳票バッチ出力

// 2020/05/22 DEL START LACS帳票バッチ出力
//		private static final int CVS_CELL_SHZK_CD = 0;          // 部署コード
//		private static final int CVS_CELL_SHZK_NM = 1;			// 部署名
//		private static final int CVS_CELL_TNT_CD = 2;			// 担当者コード
//		private static final int CVS_CELL_TNT_NM = 3;			// 担当者名
//		private static final int CVS_CELL_COSMOS_CD = 4;		// 開示先コード
//		private static final int CVS_CELL_LU_NM = 5;			// 開示先名称
//		private static final int CVS_CELL_ATESAKI= 6;				// 注記書類作成基準書
//		private static final int CVS_CELL_TYUKI= 7;				// 注記書類作成基準書
// 2020/05/22 DEL END   LACS帳票バッチ出力

		// 2020/05/22 DEL START LACS帳票バッチ出力
		// private static final int CVS_CELL_GOUKEI_OLD_TOUKI = 8; // リース契約注記合計表【旧】 -
		// 当期分
		// private static final int CVS_CELL_GOUKEI_OLD_TUKI = 9; // リース契約注記合計表【旧】 - 通期分
		// private static final int CVS_CELL_GOUKEI_NEW_TOUKI = 10; // リース契約注記合計表【新】 -
		// 当期分
		// private static final int CVS_CELL_GOUKEI_NEW_TUKI = 11; // リース契約注記合計表【新】 -
		// 通期分
		// private static final int CVS_CELL_UKEBARAI_TOUKI = 12; // 受払合計表 - 当期分
		// private static final int CVS_CELL_UKEBARAI_TUKI = 13; // 受払合計表 - 通期分
		// private static final int CVS_CELL_KAIKEI = 14; // リース会計基準明細書
		// 2020/05/22 DEL END LACS帳票バッチ出力

// 2020/05/22 ADD START LACS帳票バッチ出力
//		private static final int CVS_CELL_SIWAKE_TOUKI = 8;	// 仕訳合計表 - 当期分
//		private static final int CVS_CELL_SIWAKE_TUKI = 9;		// 仕訳合計表 - 通期分
//		private static final int CVS_CELL_UKEBARAI_TOUKI = 10;	// 受払合計表 - 当期分
//		private static final int CVS_CELL_UKEBARAI_TUKI = 11;	// 受払合計表 - 通期分
//		private static final int CVS_CELL_LEAS_UKE_TOUKI = 12;	// リース料受払明細表 - 当期分
//		private static final int CVS_CELL_LEAS_UKE_TUKI = 13;	// リース料受払明細 - 通期分
//		private static final int CVS_CELL_SISAN_UKE_TOUKI = 14;	// リース資産受払明細表 - 当期分
//		private static final int CVS_CELL_SISAN_UKE_TUKI = 15;	// リース資産受払明細 - 通期分
//		private static final int CVS_CELL_GOUKEI_OLD_TOUKI = 16;	// リース契約注記合計表【旧】 - 当期分
//		private static final int CVS_CELL_GOUKEI_OLD_TUKI = 17;	// リース契約注記合計表【旧】 - 通期分
//		private static final int CVS_CELL_GOUKEI_NEW_TOUKI = 18;	// リース契約注記合計表【新】 - 当期分
//		private static final int CVS_CELL_GOUKEI_NEW_TUKI = 19;	// リース契約注記合計表【新】 - 通期分
//		private static final int CVS_CELL_SIHARAI_OLD_TOUKI = 20;	// 支払リース料【旧】 - 当期分
//		private static final int CVS_CELL_SIHARAI_OLD_TUKI = 21;	// 支払リース料【旧】 - 通期分
//		private static final int CVS_CELL_SIHARAI_NEW_TOUKI = 22;	// 支払リース料【新】 - 当期分
//		private static final int CVS_CELL_SIHARAI_NEW_TUKI = 23;	// 支払リース料【新】 - 通期分
//		private static final int CVS_CELL_GENKA_OLD_TOUKI = 24;	// 減価償却費【旧】 - 当期分
//		private static final int CVS_CELL_GENKA_OLD_TUKI = 25;	// 減価償却費【旧】 - 通期分
//		private static final int CVS_CELL_GENKA_NEW_TOUKI = 26;	// 減価償却費【新】 - 当期分
//		private static final int CVS_CELL_GENKA_NEW_TUKI = 27;	// 減価償却費【新】 - 通期分
//		private static final int CVS_CELL_KIJITU_GOUKEI_OLD_TOUKI = 28;	// 期日別予定表(合計)【旧】 - 当期分
//		private static final int CVS_CELL_KIJITU_GOUKEI_OLD_TUKI = 29;	// 期日別予定表(合計)【旧】 - 通期分
//		private static final int CVS_CELL_KIJITU_GOUKEI_NEW_TOUKI = 30;	// 期日別予定表(合計)【新】 - 当期分
//		private static final int CVS_CELL_KIJITU_GOUKEI_NEW_TUKI = 31;	// 期日別予定表(合計)【新】 - 通期分
//		private static final int CVS_CELL_KIJITU_SAIM_OLD_TOUKI = 32;	// 期日別予定表(債務)【旧】 - 当期分
//		private static final int CVS_CELL_KIJITU_SAIM_OLD_TUKI = 33;	// 期日別予定表(債務)【旧】 - 通期分
//		private static final int CVS_CELL_KIJITU_SAIM_NEW_TOUKI = 34;	// 期日別予定表(債務)【新】 - 当期分
//		private static final int CVS_CELL_KIJITU_SAIM_NEW_TUKI = 35;	// 期日別予定表(債務)【新】 - 通期分
//		private static final int CVS_CELL_KIJITU_SISAN_OLD_TOUKI = 36;	// 期日別予定表(資産)【旧】 - 当期分
//		private static final int CVS_CELL_KIJITU_SISAN_OLD_TUKI = 37;	// 期日別予定表(資産)【旧】 - 通期分
//		private static final int CVS_CELL_KIJITU_SISAN_NEW_TOUKI = 38;	// 期日別予定表(資産)【新】 - 当期分
//		private static final int CVS_CELL_KIJITU_SISAN_NEW_TUKI = 39;	// 期日別予定表(資産)【新】 - 通期分

// 2020/05/22 ADD END   LACS帳票バッチ出力

		private static final String DEFAULT_STRING = ""; // デフォルト値
		@SuppressWarnings("unused")
		private static final String DEFAULT_NUM = "0"; // デフォルト値

		public void clear() {
			lines.clear();
		}

		public void init(String[] line) {
			// 2020/05/22 ADD START LACS帳票バッチ出力
			line[CVS_CELL_KAIJI_CD_NM] = DEFAULT_STRING;
			// 2020/05/22 ADD END LACS帳票バッチ出力
// 2020/05/22 DEL START LACS帳票バッチ出力
//			line[CVS_CELL_SHZK_CD] = DEFAULT_STRING;
//			line[CVS_CELL_SHZK_NM] = DEFAULT_STRING;
//			line[CVS_CELL_TNT_CD] = DEFAULT_STRING;
//			line[CVS_CELL_TNT_NM] = DEFAULT_STRING;
//			line[CVS_CELL_COSMOS_CD] = DEFAULT_STRING;
//			line[CVS_CELL_LU_NM] = DEFAULT_STRING;
//			line[CVS_CELL_ATESAKI] = DEFAULT_NUM;
//			line[CVS_CELL_TYUKI] = DEFAULT_NUM;
// 2020/05/22 DEL END   LACS帳票バッチ出力

			// 2020/05/22 DEL START LACS帳票バッチ出力
			// line[CVS_CELL_GOUKEI_OLD_TOUKI] = DEFAULT_NUM;
			// line[CVS_CELL_GOUKEI_OLD_TUKI] = DEFAULT_NUM;
			// line[CVS_CELL_GOUKEI_NEW_TOUKI] = DEFAULT_NUM;
			// line[CVS_CELL_GOUKEI_NEW_TUKI] = DEFAULT_NUM;
			// line[CVS_CELL_UKEBARAI_TOUKI] = DEFAULT_NUM;
			// line[CVS_CELL_UKEBARAI_TUKI] = DEFAULT_NUM;
			// line[CVS_CELL_KAIKEI] = DEFAULT_NUM;
			// 2020/05/22 DEL END LACS帳票バッチ出力

			// 2020/05/22 ADD START LACS帳票バッチ出力
//			line[CVS_CELL_SIWAKE_TOUKI] = DEFAULT_NUM;
//			line[CVS_CELL_SIWAKE_TUKI] = DEFAULT_NUM;
//			line[CVS_CELL_UKEBARAI_TOUKI] = DEFAULT_NUM;
//			line[CVS_CELL_UKEBARAI_TUKI] = DEFAULT_NUM;
//			line[CVS_CELL_LEAS_UKE_TOUKI] = DEFAULT_NUM;
//			line[CVS_CELL_LEAS_UKE_TUKI] = DEFAULT_NUM;
//			line[CVS_CELL_SISAN_UKE_TOUKI] = DEFAULT_NUM;
//			line[CVS_CELL_SISAN_UKE_TUKI] = DEFAULT_NUM;
//			line[CVS_CELL_GOUKEI_OLD_TOUKI] = DEFAULT_NUM;
//			line[CVS_CELL_GOUKEI_OLD_TUKI] = DEFAULT_NUM;
//			line[CVS_CELL_GOUKEI_NEW_TOUKI] = DEFAULT_NUM;
//			line[CVS_CELL_GOUKEI_NEW_TUKI] = DEFAULT_NUM;
//			line[CVS_CELL_SIHARAI_OLD_TOUKI] = DEFAULT_NUM;
//			line[CVS_CELL_SIHARAI_OLD_TUKI] = DEFAULT_NUM;
//			line[CVS_CELL_SIHARAI_NEW_TOUKI] = DEFAULT_NUM;
//			line[CVS_CELL_SIHARAI_NEW_TUKI] = DEFAULT_NUM;
//			line[CVS_CELL_GENKA_OLD_TOUKI] = DEFAULT_NUM;
//			line[CVS_CELL_GENKA_OLD_TUKI] = DEFAULT_NUM;
//			line[CVS_CELL_GENKA_NEW_TOUKI] = DEFAULT_NUM;
//			line[CVS_CELL_GENKA_NEW_TUKI] = DEFAULT_NUM;
//			line[CVS_CELL_KIJITU_GOUKEI_OLD_TOUKI] = DEFAULT_NUM;
//			line[CVS_CELL_KIJITU_GOUKEI_OLD_TUKI] = DEFAULT_NUM;
//			line[CVS_CELL_KIJITU_GOUKEI_NEW_TOUKI] = DEFAULT_NUM;
//			line[CVS_CELL_KIJITU_GOUKEI_NEW_TUKI] = DEFAULT_NUM;
//			line[CVS_CELL_KIJITU_SAIM_OLD_TOUKI] = DEFAULT_NUM;
//			line[CVS_CELL_KIJITU_SAIM_OLD_TUKI] = DEFAULT_NUM;
//			line[CVS_CELL_KIJITU_SAIM_NEW_TOUKI] = DEFAULT_NUM;
//			line[CVS_CELL_KIJITU_SAIM_NEW_TUKI] = DEFAULT_NUM;
//			line[CVS_CELL_KIJITU_SISAN_OLD_TOUKI] = DEFAULT_NUM;
//			line[CVS_CELL_KIJITU_SISAN_OLD_TUKI] = DEFAULT_NUM;
//			line[CVS_CELL_KIJITU_SISAN_NEW_TOUKI] = DEFAULT_NUM;
//			line[CVS_CELL_KIJITU_SISAN_NEW_TUKI] = DEFAULT_NUM;
			// 2020/05/22 ADD END LACS帳票バッチ出力
		}

		public void nextLine() {
			String[] line = new String[COLUM_NUM];
			this.init(line);
			lines.add(line);
		}

		public int getCurrentIndex() {
			return lines.size() - 1;
		}

		public void setCell(int cell, String value) {
			if (value != null && !value.equals("--")) {
				lines.get(getCurrentIndex())[cell] = value;
			}
		}

		public String[][] getData() {
			String[][] data = new String[lines.size()][COLUM_NUM];
			for (int i = 0; i < lines.size(); i++) {
				System.arraycopy(lines.get(i), 0, data[i], 0, COLUM_NUM);
			}
			return data;
		}
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "帳票印刷";
	}

	/**
	 * 処理開始ログ出力.
	 * 
	 * @param piPrintBean 月次帳票出力Bean
	 */
	protected void start(LACSReportBean piPrintBean) {
		super.getLogger().start(piPrintBean.getLeasCompany());
	}

	/**
	 * バッチ処理中チェック.
	 * 
	 * @return バッチ処理フラグ
	 * @throws SQLException SQL実行例外
	 */
	public boolean checkBatchExecute() throws SQLException {
		return false;
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piReportBean 帳票出力Bean
	 * @throws Exception 例外発生時.
	 */
	@SuppressWarnings("unused")
	protected void businessProc(LACSReportBean piReportBean) throws Exception {

		// 西暦和暦コード
		String dateMode = "";

		// 出力タイミング
		String batchPrintTimingCd = "";

		// 期間計算フラグ
		String termComputeCd = "";

		// 担当者コード
		String tantoCd = "";

		// 担当者名
		String lcTantoNm = "";

		// 担当者名
		String luTantoNm = "";

		// 部署コード
		String shzkCd = "";

		// 部署名
		String shzkNm = "";

		// 開示先名称
		String lacsUserNm = "";

		// 開示先社郵便番号
		String leaseCompanyZipCd = "";

		// リース会社住所１
		String leaseCompanyAddr1 = "";

		// リース会社住所２
		String leaseCompanyAddr2 = "";

		// リースユーザ：リースユーザEntity.
		LACSReportUserBatchEntity entity = null;

		// 帳票出力：リース会計注記合計表【旧】Model
		LACSReportPDFGoukeiWriter gowmodelOld = null;

		// 帳票出力：リース会計注記合計表【新】Model
		LACSReportPDFGoukeiWriter gowmodelNew = null;

		// 帳票出力：注記書類作成基準書 Model
		LACSReportPDFTyukiWriter tywmodel = null;

		// 受払合計表：受払合計表PDF Model
		LACSUkebaraiPDFGokeiWriter ukemodel = null;

		// 月次帳票出力：リース会計基準明細書 Model.
		LACSMReportPDFKaikeiMeisaiWriter kaimodel = null;

		// 2020/05/22 ADD START LACS帳票バッチ出力
		// 月次帳票出力：仕訳合計表 Model.
		LACSMReportPDFSiwakeWriter siwakemodel = null;

		// 月次帳票出力：リース料受払明細表 Model.
		LACSUkebaraiPDFLeaseWriter leasukemodel = null;

		// 月次帳票出力：リース資産受払明細表 Model.
		LACSUkebaraiPDFSisanWriter sisanukemodel = null;

		// 帳票出力：支払リース料【旧】 Model.
		LACSReportPDFSiharaiWriter siharaimodelOld = null;

		// 帳票出力：支払リース料【新】 Model.
		LACSReportPDFSiharaiWriter siharaimodelNew = null;

		// 帳票出力：減価償却費【旧】 Model.
		LACSReportPDFGenkaWriter genkamodelOld = null;

		// 帳票出力：減価償却費【新】 Model.
		LACSReportPDFGenkaWriter genkamodelNew = null;

		// 帳票出力：期日別予定表(合計表)【旧】 Model.
		LACSreportPDFKizitubetuGoukeiWriter kijitugoukeimodelOld = null;

		// 帳票出力：期日別予定表(合計表)【新】 Model.
		LACSreportPDFKizitubetuGoukeiWriter kijitugoukeimodelNew = null;

		// 帳票出力：期日別予定表(債務)【旧】 Model.
		LACSReportPDFKizitubetuSaimuWriter kijitusaimmodelOld = null;

		// 帳票出力：期日別予定表(債務)【新】 Model.
		LACSReportPDFKizitubetuSaimuWriter kijitusaimmodelNew = null;

		// 帳票出力：期日別予定表(資産)【旧】 Model.
		LACSReportPDFKizitubetuSisanWriter kijitusisanmodelOld = null;

		// 帳票出力：期日別予定表(資産)【新】 Model.
		LACSReportPDFKizitubetuSisanWriter kijitusisanmodelNew = null;

		String key_tyuki_cd = ""; // 注記書類作成基準書 開示先コード
		String key_tyuki_nm = ""; // 注記書類作成基準書 開示先名

		String key_siwake_cd = ""; // 仕訳合計表 開示先コード
		String key_siwake_nm = ""; // 仕訳合計表

		String key_ukebarai_cd = ""; // 受払合計表 開示先コード
		String key_ukebarai_nm = ""; // 受払合計表 開示先名

		String key_leas_uke_cd = ""; // リース料受払明細表 開示先コード
		String key_leas_uke_nm = ""; // リース料受払明細 開示先名

		String key_sisan_uke_cd = ""; // リース資産受払明細表 開示先コード
		String key_sisan_uke_nm = ""; // リース資産受払明細 開示先名

		String key_goukei_old_cd = ""; // リース契約注記合計表【旧】 開示先コード
		String key_goukei_old_nm = ""; // リース契約注記合計表【旧】 開示先名

		String key_goukei_new_cd = ""; // リース契約注記合計表【新】 開示先コード
		String key_goukei_new_nm = ""; // リース契約注記合計表【新】 開示先名

		String key_siharai_old_cd = ""; // 支払リース料【旧】 開示先コード
		String key_siharai_old_nm = ""; // 支払リース料【旧】 開示先名

		String key_siharai_new_cd = ""; // 支払リース料【新】 開示先コード
		String key_siharai_new_nm = ""; // 支払リース料【新】 開示先名

		String key_genka_old_cd = ""; // 減価償却費【旧】 開示先コード
		String key_genka_old_nm = ""; // 減価償却費【旧】 開示先名

		String key_genka_new_cd = ""; // 減価償却費【新】 開示先コード
		String key_genka_new_nm = ""; // 減価償却費【新】 開示先名

		String key_kijitu_goukei_old_cd = ""; // 期日別予定表(合計)【旧】 開示先コード
		String key_kijitu_goukei_old_nm = ""; // 期日別予定表(合計)【旧】 開示先名

		String key_kijitu_goukei_new_cd = ""; // 期日別予定表(合計)【新】 開示先コード
		String key_kijitu_goukei_new_nm = ""; // 期日別予定表(合計)【新】 開示先名

		String key_kijitu_saim_old_cd = ""; // 期日別予定表(債務)【旧】 開示先コード
		String key_kijitu_saim_old_nm = ""; // 期日別予定表(債務)【旧】 開示先名

		String key_kijitu_saim_new_cd = ""; // 期日別予定表(債務)【新】 開示先コード
		String key_kijitu_saim_new_nm = ""; // 期日別予定表(債務)【新】 開示先名

		String key_kijitu_sisan_old_cd = ""; // 期日別予定表(資産)【旧】 開示先コード
		String key_kijitu_sisan_old_nm = ""; // 期日別予定表(資産)【旧】 開示先名

		String key_kijitu_sisan_new_cd = ""; // 期日別予定表(資産)【新】 開示先コード
		String key_kijitu_sisan_new_nm = ""; // 期日別予定表(資産)【新】 開示先名

		// 2020/05/22 ADD END LACS帳票バッチ出力

		// 2020/05/22 DEL START LACS帳票バッチ出力
		// 宛先出力 Model
		// LACSReportPDFAtesakiWriter atemodel = null;
		// 2020/05/22 DEL END LACS帳票バッチ出力

		// CSV出力：帳票一括出力用CSV.（各帳票の出力ページ数を出力する）
		LACSReportCSVPrintBatchWriter cvsmodel = null;

		// まとめ後のPDF出力ホルダ
		String pdffilepath = "";

		LACSZipIO zio = null;

		int outputCount = 0;

		// 処理終了年月
		String shrym = "";
		String termFrom = "";
		String syoriY = "";
		String syoriM = "";

		// 出力対象外フラグ
		boolean taisyoFlg = true;

		// 当期と通期の期間重複フラグ
		boolean bFirstFlg = false;
		
		String batchError = "";

		// 正常終了（作成対象なし）時のレスポンスバイト配列
		byte[] zeroB = new byte[0];

		// レスポンスに書き込むバイト配列
		byte[] b = null;

		File file = null;

		boolean errorFlg = false;

		Properties batchprop = new Properties();
		
		synchronized (super.getServlet()) {
			try {
				batchprop.load(new FileInputStream(
						super.getServlet().getServletContext().getRealPath("/WEB-INF/" + "batchPrint.properties")));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		try {
			try {
				batchError = "batch0001";

				Properties prop = super.getServlet().getDefaultProperties();
				ServletConfig config = this.getServlet().getServletConfig();
				ServletContext context = config.getServletContext();

				pdffilepath = context.getRealPath(BATCH_SCRATCH_PATH) + "/" + "0000" + "_LACS_PDF";

				// リースユーザー別リース会社Entity
				LACSLoginCompanyEntity loginCompanyEntity = new LACSLoginCompanyEntity(this);
				loginCompanyEntity.setCon(super.con);
				loginCompanyEntity.setCompanyCode(prop.getProperty("companyCode", ""));
				loginCompanyEntity.execSQL();

				batchError = "batch0002";

				if (loginCompanyEntity.next()) {

					// 処理済み年月を取得
					shrym = loginCompanyEntity.getShoriYM();
					syoriY = shrym.substring(0, 4);
					syoriM = shrym.substring(4, 6);
				}
				loginCompanyEntity.close();

				batchError = "batch0003";

				super.getCommonBean().setShowSumUnt(false);

				File scrarchPath = new File(super.getServlet().getServletContext().getRealPath(SCRATCH_PATH));

				if (!scrarchPath.exists()) {
					scrarchPath.mkdirs();
				} else {
					this.deletePDF(context);
				}

				piReportBean.setOutputMode(1);

				String companycode = "";
				String fileName = "";

				pdffilepath = context.getRealPath(BATCH_SCRATCH_PATH) + "/" + shrym + "_LACS_PDF";

				// PDFまとめ後のファイルの削除
				FileUtil.delfile(new File(pdffilepath));

				new File(pdffilepath + "/").mkdirs();

				batchError = "batch0004";

				String y = "";
				String m = "";
				String d = "";

				// 処理済み年月月初年月日
				Date getusyoDate = Convert.toDate(syoriY, syoriM, "01");

				// To年月日用
				Date dateWk = getusyoDate;

				// 月末日の取得
				int maxday = DateUtl.getDayOfMonth(dateWk);

				Date dateTo = null;
				dateTo = Convert.toDate(Convert.toString(DateUtl.getYear(dateWk)),
						Convert.toString(DateUtl.getMonth(dateWk)), Convert.toString(maxday));

				// From年月日用
				Date dateFrom = null;

				// 開示先別四半期別開始終了年月
				String startY = "";
				String startM = "";
				String startD = "";
				String endY = "";
				String endM = "";
				String endD = "";

				String startYY = "";
				String startMM = "";
				String startDD = "";
				String endYY = "";
				String endMM = "";
				String endDD = "";

				String start1Y = "";
				String start2Y = "";
				String start3Y = "";
				String start4Y = "";
				String start1M = "";
				String start2M = "";
				String start3M = "";
				String start4M = "";
				String start1D = "";
				String start2D = "";
				String start3D = "";
				String start4D = "";
				String end1Y = "";
				String end2Y = "";
				String end3Y = "";
				String end4Y = "";
				String end1M = "";
				String end2M = "";
				String end3M = "";
				String end4M = "";
				String end1D = "";
				String end2D = "";
				String end3D = "";
				String end4D = "";

				Date kesanDateTo = null;
				String kesanDateToY = "";
				String kesanDateToM = "";
				String kesanDateToD = "";
				int kikan = 0;

				int pageCount = 0;

				// 当期か通期かの判断フラグ
				boolean bToukiTukiFlg = true;

				// CVSデータ格納オブジェクト
				ReportCVS reportCVS = new ReportCVS();

				// 注記書類作成基準書 Model
				tywmodel = new LACSReportPDFTyukiWriter(super.getCommonBean(), this, super.con);
				tywmodel.setBatchFlg(true);

				// リース会計注記合計表【旧】Model
				gowmodelOld = new LACSReportPDFGoukeiWriter(super.getCommonBean(), this, super.con);
				gowmodelOld.setBatchFlg(true);

				// リース会計注記合計表【新】Model
				gowmodelNew = new LACSReportPDFGoukeiWriter(super.getCommonBean(), this, super.con);
				gowmodelNew.setBatchFlg(true);

				// 受払合計表：受払合計表PDF Model
				ukemodel = new LACSUkebaraiPDFGokeiWriter(super.getCommonBean(), this, super.con);
				ukemodel.setBatchFlg(true);

				// 月次帳票出力：リース会計基準明細書 Model.
				kaimodel = new LACSMReportPDFKaikeiMeisaiWriter(super.getCommonBean(), this, super.con);
				kaimodel.setBatchFlg(true);

				// 2020/05/22 ADD START LACS帳票バッチ出力
				// 月次帳票出力：仕訳合計表 Model.
				siwakemodel = new LACSMReportPDFSiwakeWriter(super.getCommonBean(), this, super.con);
				siwakemodel.setBatchFlg(true);
				// 2020/05/22 ADD END LACS帳票バッチ出力

				// 2020/05/22 ADD START LACS帳票バッチ出力
				// 受払合計表出力：リース料受払明細表 Model.
				leasukemodel = new LACSUkebaraiPDFLeaseWriter(super.getCommonBean(), this, super.con);
				leasukemodel.setBatchFlg(true);
				// 2020/05/22 ADD END LACS帳票バッチ出力

				// 2020/05/22 ADD START LACS帳票バッチ出力
				// 受払合計表出力：リース資産受払明細表 Model.
				sisanukemodel = new LACSUkebaraiPDFSisanWriter(super.getCommonBean(), this, super.con);
				sisanukemodel.setBatchFlg(true);
				// 2020/05/22 ADD END LACS帳票バッチ出力

				// 2020/05/22 ADD START LACS帳票バッチ出力
				// 帳票出力：支払リース料【旧】 Model.
				siharaimodelOld = new LACSReportPDFSiharaiWriter(super.getCommonBean(), this, super.con);
				siharaimodelOld.setBatchFlg(true);

				// 帳票出力：支払リース料【新】 Model.
				siharaimodelNew = new LACSReportPDFSiharaiWriter(super.getCommonBean(), this, super.con);
				siharaimodelNew.setBatchFlg(true);
				// 2020/05/22 ADD END LACS帳票バッチ出力

				// 2020/05/22 ADD START LACS帳票バッチ出力
				// 帳票出力：減価償却費【旧】 Model.
				genkamodelOld = new LACSReportPDFGenkaWriter(super.getCommonBean(), this, super.con);
				genkamodelOld.setBatchFlg(true);

				// 帳票出力：減価償却費【新】 Model.
				genkamodelNew = new LACSReportPDFGenkaWriter(super.getCommonBean(), this, super.con);
				genkamodelNew.setBatchFlg(true);
				// 2020/05/22 ADD END LACS帳票バッチ出力

				//
				// 2020/05/22 ADD START LACS帳票バッチ出力
				// 帳票出力：期日別予定表(合計表)【旧】 Model.
				kijitugoukeimodelOld = new LACSreportPDFKizitubetuGoukeiWriter(super.getCommonBean(), this, super.con);
				kijitugoukeimodelOld.setBatchFlg(true);

				// 帳票出力：期日別予定表(合計表)【新】 Model.
				kijitugoukeimodelNew = new LACSreportPDFKizitubetuGoukeiWriter(super.getCommonBean(), this, super.con);
				kijitugoukeimodelNew.setBatchFlg(true);
				// 2020/05/22 ADD END LACS帳票バッチ出力

				// 2020/05/22 ADD START LACS帳票バッチ出力
				// 帳票出力：期日別予定表(債務)【旧】 Model.
				kijitusaimmodelOld = new LACSReportPDFKizitubetuSaimuWriter(super.getCommonBean(), this, super.con);
				kijitusaimmodelOld.setBatchFlg(true);

				// 帳票出力：期日別予定表(債務)【新】 Model.
				kijitusaimmodelNew = new LACSReportPDFKizitubetuSaimuWriter(super.getCommonBean(), this, super.con);
				kijitusaimmodelNew.setBatchFlg(true);
				// 2020/05/22 ADD END LACS帳票バッチ出力

				// 2020/05/22 ADD START LACS帳票バッチ出力
				// 帳票出力：期日別予定表(資産)【旧】 Model.
				kijitusisanmodelOld = new LACSReportPDFKizitubetuSisanWriter(super.getCommonBean(), this, super.con);
				kijitusisanmodelOld.setBatchFlg(true);

				// 帳票出力：期日別予定表(資産)【新】 Model.
				kijitusisanmodelNew = new LACSReportPDFKizitubetuSisanWriter(super.getCommonBean(), this, super.con);
				kijitusisanmodelNew.setBatchFlg(true);
				// 2020/05/22 ADD END LACS帳票バッチ出力

				// 2020/05/22 DEL START LACS帳票バッチ出力
				// 宛先出力 Model
				// atemodel = new LACSReportPDFAtesakiWriter(super.getCommonBean(), this,
				// super.con);

				// List<LACSReportAtesakiBean> atesakiList = new
				// ArrayList<LACSReportAtesakiBean>();
				// 2020/05/22 DEL END LACS帳票バッチ出力

				for (int i = 0; i < piReportBean.getLeasCompany().size() * 2; i++) {

					// 奇数の時は通期(false)、偶数の時は当期(true)
					bToukiTukiFlg = (i % 2 == 0) ? true : false;

					if (bToukiTukiFlg) {
						outputCount = 0;
						reportCVS.nextLine();
					}

					int current = (int) Math.floor(i / 2);

					// 開示先コード
					companycode = piReportBean.getLeasCompany().get(current).getValue();

					piReportBean.getLeasCompany().setSelectedValue(companycode);

					entity = new LACSReportUserBatchEntity(this);

					try {

						dateMode = super.getCommonBean().getDateMode();

						batchError = "batch0005";

						if (super.getCommonBean().getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {
							entity.setCon(super.con);
							entity.setLeasCompany(companycode);
							entity.execSQL();

							batchPrintTimingCd = "0";

							if (entity.next()) {

								// 担当者コード
								tantoCd = entity.getTantosyaCode();

								// 担当者名
								lcTantoNm = entity.getLcTantosyaName();

								// 担当者名
								luTantoNm = entity.getLuTantosyaName();

								// 部署コード
								shzkCd = entity.getShzkCode();

								// 部署名
								shzkNm = entity.getShzkName();

								// 開示先名称
								lacsUserNm = entity.getLacsUserName();

								// リース会社郵便番号
								leaseCompanyZipCd = entity.getLeaseCompanyZip();

								// リース会社住所１
								leaseCompanyAddr1 = entity.getLeaseCompanyAddr1();

								// リース会社住所 2
								leaseCompanyAddr2 = entity.getLeaseCompanyAddr2();

								// 西暦和暦コード
								dateMode = entity.getSeirekiWarekiCode() == null ? LACSDefine.DateMode.SEIREKI
										: entity.getSeirekiWarekiCode();

								// 出力タイミング
								batchPrintTimingCd = entity.getBatchPrintTimingCd() == null ? "0"
										: entity.getBatchPrintTimingCd();
							}
						}
						entity.close();

						// 2020/05/22 ADD START LACS帳票バッチ出力
						reportCVS.setCell(ReportCVS.CVS_CELL_KAIJI_CD_NM, companycode + "_" + lacsUserNm);
						// 2020/05/22 ADD END LACS帳票バッチ出力
						// 2020/05/22 DEL START LACS帳票バッチ出力
//						reportCVS.setCell(ReportCVS.CVS_CELL_COSMOS_CD, companycode);
//						reportCVS.setCell(ReportCVS.CVS_CELL_TNT_CD, tantoCd);
//						reportCVS.setCell(ReportCVS.CVS_CELL_TNT_NM, lcTantoNm);
//						reportCVS.setCell(ReportCVS.CVS_CELL_SHZK_CD, shzkCd);
//						reportCVS.setCell(ReportCVS.CVS_CELL_SHZK_NM, shzkNm);
//						reportCVS.setCell(ReportCVS.CVS_CELL_LU_NM, lacsUserNm);
						// 2020/05/22 DEL END LACS帳票バッチ出力

						// 開示先別に出力サイクルを設定
						/*
						 * batchPrintTimingCd 0 出力なし 1 毎月出力 2 四半期毎出力 3 半期毎出力 4 年毎出力
						 */

						termComputeCd = "0";

						if (batchPrintTimingCd.equals("0")) {
							continue;
						} else if (batchPrintTimingCd.equals("1")) {
							termComputeCd = bToukiTukiFlg ? "1" : "2";
							piReportBean.setQuarter("0");
						} else if (batchPrintTimingCd.equals("2")) {
							termComputeCd = bToukiTukiFlg ? "3" : "4";
							piReportBean.setQuarter("1");
						} else if (batchPrintTimingCd.equals("3")) {
							termComputeCd = bToukiTukiFlg ? "5" : "6";
							piReportBean.setQuarter("2");
						} else if (batchPrintTimingCd.equals("4")) {
							termComputeCd = "7";
							piReportBean.setQuarter("4");
						} else {
							continue;
						}

						batchError = "batch0006";

						// 毎月指定用（getDataを実行するための仮期間）
						piReportBean.setTermNum0("1");

						// 開示先単位の画面情報の取得（デフォルト値の設定）
						getUserReporData(piReportBean, getusyoDate);

						// 開示先別の対象開始年月日（デフォルト値：決算開始年月日）の取得
						y = piReportBean.getTermFrom().getInputString1();
						m = piReportBean.getTermFrom().getInputString2();
						d = piReportBean.getTermFrom().getInputString3();

						// 開示先別の各種日付情報の取得(フォーマット済み日付）
						// 第1四半期の開始日の作成
						start1Y = StringUtl.formatNumber(y, "0000");
						start1M = StringUtl.formatNumber(m, "00");
						start1D = StringUtl.formatNumber(d, "00");

						// 決算開始年月日の前日（決算日）を算出し1日の日付を算出する
						dateWk = Convert.toDate(y, m, d);
						dateWk = DateUtl.add(Calendar.DAY_OF_MONTH, -1, dateWk);
						dateFrom = Convert.toDate(StringUtl.formatNumber(DateUtl.getYear(dateWk), "0000"),
								StringUtl.formatNumber(DateUtl.getMonth(dateWk), "00"), "01");

						// 決算日の月から処理当月までの経過月数を算出
						kikan = DateUtl.differenceMonth(getusyoDate, dateFrom);

						// 決算開始年月日に経過月数を加算した日の前日を算出する（処理当月内の決算終了日の応答日となる）
						dateWk = Convert.toDate(y, m, d);
						dateWk = DateUtl.add(Calendar.MONTH, kikan, dateWk);
						kesanDateTo = DateUtl.add(Calendar.DAY_OF_MONTH, -1, dateWk);
						kesanDateToY = StringUtl.formatNumber(DateUtl.getYear(kesanDateTo), "0000");
						kesanDateToM = StringUtl.formatNumber(DateUtl.getMonth(kesanDateTo), "00");
						kesanDateToD = StringUtl.formatNumber(DateUtl.getDay(kesanDateTo), "00");

						// 第1四半期の終了日の作成
						// 画面の第1四半期終了年月日より作成
						end1Y = StringUtl.formatNumber(piReportBean.getTermTo1().getInputString1(), "0000");
						end1M = StringUtl.formatNumber(piReportBean.getTermTo1().getInputString2(), "00");
						end1D = StringUtl.formatNumber(piReportBean.getTermTo1().getInputString3(), "00");

						// 第1四半期の終了日の翌日を作成
						dateWk = Convert.toDate(end1Y, end1M, end1D);
						dateWk = DateUtl.add(Calendar.DAY_OF_MONTH, 1, dateWk);

						// 第2四半期の開始日の作成
						start2Y = StringUtl.formatNumber(DateUtl.getYear(dateWk), "0000");
						start2M = StringUtl.formatNumber(DateUtl.getMonth(dateWk), "00");
						start2D = StringUtl.formatNumber(DateUtl.getDay(dateWk), "00");

						// 第2四半期の終了日の作成
						// 画面の半期終了年月日より作成
						end2Y = StringUtl.formatNumber(piReportBean.getTermTo2().getInputString1(), "0000");
						end2M = StringUtl.formatNumber(piReportBean.getTermTo2().getInputString2(), "00");
						end2D = StringUtl.formatNumber(piReportBean.getTermTo2().getInputString3(), "00");

						// 第2四半期の終了日の翌日を作成
						dateWk = Convert.toDate(end2Y, end2M, end2D);
						dateWk = DateUtl.add(Calendar.DAY_OF_MONTH, 1, dateWk);

						// 第3四半期開始日の作成
						start3Y = StringUtl.formatNumber(DateUtl.getYear(dateWk), "0000");
						start3M = StringUtl.formatNumber(DateUtl.getMonth(dateWk), "00");
						start3D = StringUtl.formatNumber(DateUtl.getDay(dateWk), "00");

						// 第3四半期終了年月の算出
						// 画面の第3四半期終了年月日より作成
						end3Y = StringUtl.formatNumber(piReportBean.getTermTo3().getInputString1(), "0000");
						end3M = StringUtl.formatNumber(piReportBean.getTermTo3().getInputString2(), "00");
						end3D = StringUtl.formatNumber(piReportBean.getTermTo3().getInputString3(), "00");

						// 第4四半期の終了日の翌日を作成
						dateWk = Convert.toDate(end3Y, end3M, end3D);
						dateWk = DateUtl.add(Calendar.DAY_OF_MONTH, 1, dateWk);

						// 第4四半期開始年月の算出
						start4Y = StringUtl.formatNumber(DateUtl.getYear(dateWk), "0000");
						start4M = StringUtl.formatNumber(DateUtl.getMonth(dateWk), "00");
						start4D = StringUtl.formatNumber(DateUtl.getDay(dateWk), "00");

						// 第4四半期終了日の算出
						// 画面の通期より作成
						end4Y = StringUtl.formatNumber(piReportBean.getTermTo4().getInputString1(), "0000");
						end4M = StringUtl.formatNumber(piReportBean.getTermTo4().getInputString2(), "00");
						end4D = StringUtl.formatNumber(piReportBean.getTermTo4().getInputString3(), "00");

						// 処理当月が含まれている四半期の開始年月と終了年月を取得する
						// 第1四半期に含まれている場合
						if (Integer.parseInt(start1Y + start1M + start1D) <= Integer
								.parseInt(kesanDateToY + kesanDateToM + kesanDateToD)
								&& Integer.parseInt(kesanDateToY + kesanDateToM + kesanDateToD) <= Integer
										.parseInt(end1Y + end1M + end1D)) {

							// 四半期用パラメータ
							startY = start1Y;
							startM = start1M;
							startD = start1D;
							endY = end1Y;
							endM = end1M;
							endD = end1D;

							// 半期用パラメータ
							startYY = start1Y;
							startMM = start1M;
							startDD = start1D;
							endYY = end2Y;
							endMM = end2M;
							endDD = end2D;
						}

						// 第2四半期に含まれている場合
						else if (Integer.parseInt(start2Y + start2M + start2D) <= Integer
								.parseInt(kesanDateToY + kesanDateToM + kesanDateToD)
								&& Integer.parseInt(kesanDateToY + kesanDateToM + kesanDateToD) <= Integer
										.parseInt(end2Y + end2M + end2D)) {

							// 四半期用パラメータ
							startY = start2Y;
							startM = start2M;
							startD = start2D;
							endY = end2Y;
							endM = end2M;
							endD = end2D;

							// 半期用パラメータ
							startYY = start1Y;
							startMM = start1M;
							startDD = start1D;
							endYY = end2Y;
							endMM = end2M;
							endDD = end2D;
						}

						// 第3四半期に含まれている場合
						else if (Integer.parseInt(start3Y + start3M + start3D) <= Integer
								.parseInt(kesanDateToY + kesanDateToM + kesanDateToD)
								&& Integer.parseInt(kesanDateToY + kesanDateToM + kesanDateToD) <= Integer
										.parseInt(end3Y + end3M + end3D)) {

							// 四半期用パラメータ
							startY = start3Y;
							startM = start3M;
							startD = start3D;
							endY = end3Y;
							endM = end3M;
							endD = end3D;

							// 半期用パラメータ
							startYY = start3Y;
							startMM = start3M;
							startDD = start3D;
							endYY = end4Y;
							endMM = end4M;
							endDD = end4D;
						}

						// 第4四半期に含まれている場合
						else if (Integer.parseInt(start4Y + start4M + start4D) <= Integer
								.parseInt(kesanDateToY + kesanDateToM + kesanDateToD)
								&& Integer.parseInt(kesanDateToY + kesanDateToM + kesanDateToD) <= Integer
										.parseInt(end4Y + end4M + end4D)) {

							// 四半期用パラメータ
							startY = start4Y;
							startM = start4M;
							startD = start4D;
							endY = end4Y;
							endM = end4M;
							endD = end4D;

							// 半期用パラメータ
							startYY = start3Y;
							startMM = start3M;
							startDD = start3D;
							endYY = end4Y;
							endMM = end4M;
							endDD = end4D;
						}

						// 出力サイクル別の帳票出力パラメータの設定
						// 出力なしの場合
						if (termComputeCd.equals("0")) {
							continue;
						}

						// 毎月出力指定の場合
						else if (termComputeCd.equals("1")) {

							batchError = "batch0007";

							// 対象期間開始にバッチ処理年月末の直近の決算終了日の応答年月日から算出した決算開始日の応答年月日を指定

							// バッチ処理年月内の決算開始日の応答日を決算終了日の応答日から作成
							dateWk = DateUtl.add(Calendar.DAY_OF_MONTH, 1, kesanDateTo);
							dateWk = DateUtl.add(Calendar.MONTH, -1, dateWk);

							termFrom = StringUtl.formatNumber(DateUtl.getYear(dateWk), "0000")
									+ StringUtl.formatNumber(DateUtl.getMonth(dateWk), "00")
									+ StringUtl.formatNumber(DateUtl.getDay(dateWk), "00");

							piReportBean.getTermFrom()
									.setInputString1(StringUtl.formatNumber(DateUtl.getYear(dateWk), "0000"));
							piReportBean.getTermFrom()
									.setInputString2(StringUtl.formatNumber(DateUtl.getMonth(dateWk), "00"));
							piReportBean.getTermFrom()
									.setInputString3(StringUtl.formatNumber(DateUtl.getDay(dateWk), "00"));

							// 期間を設定
							piReportBean.setTermNum0("1");

							// 期間変更時のアクション実施
							LACSReportCommon.setTerm(super.getCommonBean(), super.con, this, piReportBean,
									Convert.toDate(termFrom, Convert.FORMAT_YYYYMMDD),
									LACSReportCommon.TIMING_TERM_CHANGE);

							// ヶ月の終了年月日を対象期間終了（TermTo）へ設定
							piReportBean.getTermTo().setDate("", piReportBean.getTermTo0().getInputString1(),
									piReportBean.getTermTo0().getInputString2(),
									piReportBean.getTermTo0().getInputString3());

							// 期間（TermNum）へ設定
							piReportBean.setTermNum("1");
						}

						// 毎月（通期）出力指定の場合
						else if (termComputeCd.equals("2")) {

							batchError = "batch0008";

							// 開示先別の対象開始年月日（デフォルト値：決算開始年月）から処理当月までの期間を算出し、期間（TermNum0）に設定
							dateFrom = Convert.toDateEx(start1Y, start1M, start1D);
							dateTo = DateUtl.add(Calendar.DAY_OF_MONTH, 1, kesanDateTo);

							piReportBean.setTermNum0(Convert.toString(DateUtl.differenceMonth(dateTo, dateFrom)));
							termFrom = start1Y + start1M + start1D;

							// 期間変更時のアクション実施
							LACSReportCommon.setTerm(super.getCommonBean(), super.con, this, piReportBean,
									Convert.toDate(termFrom, Convert.FORMAT_YYYYMMDD),
									LACSReportCommon.TIMING_TERM_CHANGE);

							// ヶ月の終了年月日を対象期間終了（TermTo）へ設定
							piReportBean.getTermTo().setDate("", piReportBean.getTermTo0().getInputString1(),
									piReportBean.getTermTo0().getInputString2(),
									piReportBean.getTermTo0().getInputString3());

							// 期間（TermNum）へ設定
							piReportBean.setTermNum(Convert.toString(DateUtl.differenceMonth(dateTo, dateFrom)));
						}

						// 四半期毎指定の場合
						else if (termComputeCd.equals("3")) {

							batchError = "batch0009";

							// 対象期間開始に、処理当月が含まれている四半期の開始日を設定
							termFrom = startY + startM + startD;
							piReportBean.getTermFrom().setInputString1(startY);
							piReportBean.getTermFrom().setInputString2(startM);
							piReportBean.getTermFrom().setInputString3(startD);

							// 期間変更時のアクション実施
							LACSReportCommon.setTerm(super.getCommonBean(), super.con, this, piReportBean,
									Convert.toDate(termFrom, Convert.FORMAT_YYYYMMDD),
									LACSReportCommon.TIMING_TERM_CHANGE);

							// 第1四半期の終了年月日を対象期間終了（TermTo）へ設定
							piReportBean.getTermTo().setDate("", piReportBean.getTermTo1().getInputString1(),
									piReportBean.getTermTo1().getInputString2(),
									piReportBean.getTermTo1().getInputString3());

							// 対象期間（TermNum）へ設定
							dateFrom = Convert.toDate(startY, startM, startD);

							dateTo = Convert.toDateEx(piReportBean.getTermTo1().getInputString1(),
									piReportBean.getTermTo1().getInputString2(),
									piReportBean.getTermTo1().getInputString3());

							dateTo = DateUtl.add(Calendar.DAY_OF_MONTH, 1, dateTo);

							piReportBean.setTermNum(Convert.toString(DateUtl.differenceMonth(dateTo, dateFrom)));
						}

						// 四半期毎（通期）指定の場合
						else if (termComputeCd.equals("4")) {

							batchError = "batch0010";

							// 対象期間開始は、デフォルトで決算開始日が設定されているためそのまま
							// 対象期間終了に、処理当月が含まれている四半期の終了日を設定
							piReportBean.getTermTo().setDate("", endY, endM, endD);

							// 対象期間（TermNum）へ設定
							dateFrom = Convert.toDate(start1Y, start1M, start1D);
							dateTo = Convert.toDateEx(endY, endM, endD);
							dateTo = DateUtl.add(Calendar.DAY_OF_MONTH, 1, dateTo);
							piReportBean.setTermNum(Convert.toString(DateUtl.differenceMonth(dateTo, dateFrom)));
						}

						// 半期毎指定の場合
						else if (termComputeCd.equals("5")) {

							batchError = "batch0011";

							// 対象期間開始に、処理当月が含まれている半期の開始日を設定
							termFrom = startYY + startMM + startDD;
							piReportBean.getTermFrom().setInputString1(startYY);
							piReportBean.getTermFrom().setInputString2(startMM);
							piReportBean.getTermFrom().setInputString3(startDD);

							// 期間変更時のアクション実施
							LACSReportCommon.setTerm(super.getCommonBean(), super.con, this, piReportBean,
									Convert.toDate(termFrom, Convert.FORMAT_YYYYMMDD),
									LACSReportCommon.TIMING_TERM_CHANGE);

							// 半期の終了年月日を対象期間終了（TermTo）へ設定
							piReportBean.getTermTo().setDate("", piReportBean.getTermTo2().getInputString1(),
									piReportBean.getTermTo2().getInputString2(),
									piReportBean.getTermTo2().getInputString3());

							// 対象期間（TermNum）へ設定
							dateFrom = Convert.toDate(startYY, startMM, startDD);
							dateTo = Convert.toDateEx(piReportBean.getTermTo2().getInputString1(),
									piReportBean.getTermTo2().getInputString2(),
									piReportBean.getTermTo2().getInputString3());
							dateTo = DateUtl.add(Calendar.DAY_OF_MONTH, 1, dateTo);
							piReportBean.setTermNum(Convert.toString(DateUtl.differenceMonth(dateTo, dateFrom)));
						}

						// 半期毎（通期）指定の場合
						else if (termComputeCd.equals("6")) {

							batchError = "batch0012";

							// 対象期間開始は、デフォルトで決算開始日が設定されているためそのまま
							// 対象期間終了に、処理当月が含まれている半期の終了日を設定
							piReportBean.getTermTo().setDate("", endYY, endMM, endDD);

							// 対象期間（TermNum）へ設定
							dateFrom = Convert.toDate(start1Y, start1M, start1D);
							dateTo = Convert.toDateEx(endYY, endMM, endDD);
							dateTo = DateUtl.add(Calendar.DAY_OF_MONTH, 1, dateTo);
							piReportBean.setTermNum(Convert.toString(DateUtl.differenceMonth(dateTo, dateFrom)));
						}

						// 年毎指定の場合
						else {

							batchError = "batch0013";

							// 対象期間開始は、デフォルトで決算開始日が設定されているためそのまま
							// 対象期間（TermTo）へ設定
							piReportBean.getTermTo().setDate("", piReportBean.getTermTo4().getInputString1(),
									piReportBean.getTermTo4().getInputString2(),
									piReportBean.getTermTo4().getInputString3());

							// 対象期間（TermNum）へ設定
							dateFrom = Convert.toDate(start1Y, start1M, start1D);
							dateTo = Convert.toDateEx(piReportBean.getTermTo4().getInputString1(),
									piReportBean.getTermTo4().getInputString2(),
									piReportBean.getTermTo4().getInputString3());
							dateTo = DateUtl.add(Calendar.DAY_OF_MONTH, 1, dateTo);
							piReportBean.setTermNum(Convert.toString(DateUtl.differenceMonth(dateTo, dateFrom)));
						}

						batchError = "batch0014";
/*
						// 出力対象判定
						if (!(StringUtl.formatNumber(DateUtl.getYear(kesanDateTo), "0000")
								+ StringUtl.formatNumber(DateUtl.getMonth(kesanDateTo), "00")
								+ StringUtl.formatNumber(DateUtl.getDay(kesanDateTo), "00")).equals(
										StringUtl.formatNumber(piReportBean.getTermTo().getInputString1(), "0000")
												+ StringUtl.formatNumber(piReportBean.getTermTo().getInputString2(),
														"00")
												+ StringUtl.formatNumber(piReportBean.getTermTo().getInputString3(),
														"00"))) {

							// 出力対象外
							taisyoFlg = false;
						} else {

							taisyoFlg = true;
						}
*/
						taisyoFlg = true;

						// 当期と通期の対象期間が重複しているか確認
						//   例：四半期出力で第1期の場合、当期と通期が重複する
						bFirstFlg = false;
						// 通期出力の場合のみ
						if (!bToukiTukiFlg) {
							// 出力タイミングが「毎月」の場合
							if (batchPrintTimingCd.equals("1")) {
								// 処理年月の月と対象期間FROMの月が一致、且つ処理年月の月と対象期間TOの月が一致している場合
								if (syoriM.equals(piReportBean.getTermFrom().getInputString2()) && syoriM.equals(StringUtl.formatNumber(piReportBean.getTermTo0().getInputString2(),"00"))) {
									// 第1期フラグにtrueを設定
									bFirstFlg = true;
								}
							// 出力タイミングが「四半期毎」の場合
							} else if (batchPrintTimingCd.equals("2")) {
								// 決算開始月と対象期間FROMの月が一致、且つ処理年月の月と対象期間TOの月が一致している場合
								if (start1M.equals(piReportBean.getTermFrom().getInputString2()) && syoriM.equals(StringUtl.formatNumber(piReportBean.getTermTo1().getInputString2(),"00"))) {
									// 第1期フラグにtrueを設定
									bFirstFlg = true;
								}
							// 出力タイミングが「半期毎」の場合
							} else if (batchPrintTimingCd.equals("3")) {
								// 決算開始月と対象期間FROMの月が一致、且つ処理年月の月と対象期間TOの月が一致している場合
								if (start1M.equals(piReportBean.getTermFrom().getInputString2()) && syoriM.equals(StringUtl.formatNumber(piReportBean.getTermTo2().getInputString2(),"00"))) {
									// 第1期フラグにtrueを設定
									bFirstFlg = true;
								}
							// 出力タイミングが「年毎」の場合
							} else if (batchPrintTimingCd.equals("4")) {
								// 決算開始月と対象期間FROMの月が一致、且つ処理年月の月と対象期間TOの月が一致している場合
								if (start1M.equals(piReportBean.getTermFrom().getInputString2()) && syoriM.equals(StringUtl.formatNumber(piReportBean.getTermTo4().getInputString2(),"00"))) {
									// 第1期フラグにtrueを設定
									bFirstFlg = true;
								}
							// 上記以外の場合
							} else {
								// 第1期フラグにfalseを設定
								bFirstFlg = false;
							}
						}
						
						batchError = "batch0015";

						this.checkInput(super.getCommonBean(), piReportBean, message);

						// 2020/05/22 ADD START LACS帳票バッチ出力
						// 注記書類作成基準書ブレイクキー
						if (key_tyuki_cd.equals("")) {
							key_tyuki_cd = companycode;
							key_tyuki_nm = lacsUserNm;
						}
						// 仕訳合計表ブレイクキー
						if (key_siwake_cd.equals("")) {
							key_siwake_cd = companycode;
							key_siwake_nm = lacsUserNm;
						}
						// 受払合計表ブレイクキー
						if (key_ukebarai_cd.equals("")) {
							key_ukebarai_cd = companycode;
							key_ukebarai_nm = lacsUserNm;
						}
						// リース料受払明細表ブレイクキー
						if (key_leas_uke_cd.equals("")) {
							key_leas_uke_cd = companycode;
							key_leas_uke_nm = lacsUserNm;
						}
						// リース資産受払明細表ブレイクキー
						if (key_sisan_uke_cd.equals("")) {
							key_sisan_uke_cd = companycode;
							key_sisan_uke_nm = lacsUserNm;
						}
						// リース契約注記合計表ブレイクキー
						if (key_goukei_old_cd.equals("")) {
							key_goukei_old_cd = companycode;
							key_goukei_old_nm = lacsUserNm;
						}
						// リース契約注記合計表【新】ブレイクキー
						if (key_goukei_new_cd.equals("")) {
							key_goukei_new_cd = companycode;
							key_goukei_new_nm = lacsUserNm;
						}
						// 支払リース料【旧】ブレイクキー
						if (key_siharai_old_cd.equals("")) {
							key_siharai_old_cd = companycode;
							key_siharai_old_nm = lacsUserNm;
						}
						// 支払リース料【新】ブレイクキー
						if (key_siharai_new_cd.equals("")) {
							key_siharai_new_cd = companycode;
							key_siharai_new_nm = lacsUserNm;
						}
						// 減価償却費【旧】
						if (key_genka_old_cd.equals("")) {
							key_genka_old_cd = companycode;
							key_genka_old_nm = lacsUserNm;
						}
						// 減価償却費【新】ブレイクキー
						if (key_genka_new_cd.equals("")) {
							key_genka_new_cd = companycode;
							key_genka_new_nm = lacsUserNm;
						}
						// 期日別予定表(合計)【旧】
						if (key_kijitu_goukei_old_cd.equals("")) {
							key_kijitu_goukei_old_cd = companycode;
							key_kijitu_goukei_old_nm = lacsUserNm;
						}
						// 期日別予定表(合計)【新】ブレイクキー
						if (key_kijitu_goukei_new_cd.equals("")) {
							key_kijitu_goukei_new_cd = companycode;
							key_kijitu_goukei_new_nm = lacsUserNm;
						}
						// 期日別予定表(債務)【旧】ブレイクキー
						if (key_kijitu_saim_old_cd.equals("")) {
							key_kijitu_saim_old_cd = companycode;
							key_kijitu_saim_old_nm = lacsUserNm;
						}
						// 期日別予定表(債務)【新】ブレイクキー
						if (key_kijitu_saim_new_cd.equals("")) {
							key_kijitu_saim_new_cd = companycode;
							key_kijitu_saim_new_nm = lacsUserNm;
						}
						// 期日別予定表(資産)【旧】ブレイクキー
						if (key_kijitu_sisan_old_cd.equals("")) {
							key_kijitu_sisan_old_cd = companycode;
							key_kijitu_sisan_old_nm = lacsUserNm;
						}
						// 期日別予定表(資産)【新】ブレイクキー
						if (key_kijitu_sisan_new_cd.equals("")) {
							key_kijitu_sisan_new_cd = companycode;
							key_kijitu_sisan_new_nm = lacsUserNm;
						}

						//
						// 2020/05/22 ADD END LACS帳票バッチ出力

						// 注記書類作成基準書
						if (!bToukiTukiFlg && taisyoFlg) {

							// 2020/05/22 ADD START LACS帳票バッチ出力
							// 開示先コードが変わった場合帳票を出力
							if (!key_tyuki_cd.equals(companycode)) {

								// 注記書類作成基準書PDFを作成
								batchError = "batch0026";
								tywmodel.endReport();
								fileName = tywmodel.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName)
											.renameTo(new File(pdffilepath + "/" + "01_注記書類作成基準書_" + shrym + "_"
													+ key_tyuki_cd + "_" + key_tyuki_nm + ".pdf"));
								}
								// 注記書類作成基準書 Model
								tywmodel = new LACSReportPDFTyukiWriter(super.getCommonBean(), this, super.con);
								tywmodel.setBatchFlg(true);
								// ブレイクキー設定
								key_tyuki_cd = companycode;
								key_tyuki_nm = lacsUserNm;
							}
							// 2020/05/22 ADD END LACS帳票バッチ出力

							batchError = "batch0016";

							tywmodel.getData(piReportBean);

							pageCount = 0;

							if (piReportBean.getDataMax() > 0) {

								batchError = "batch0017";
								tywmodel.makePDF(piReportBean, dateMode, context);
								outputCount++;
								pageCount = piReportBean.getDataMax();
							}

							piReportBean.clearList();

							// CVSデータ出力
							// 2020/05/22 DEL START LACS帳票バッチ出力
							// reportCVS.setCell(ReportCVS.CVS_CELL_TYUKI, String.valueOf(pageCount));
							// 2020/05/22 DEL END LACS帳票バッチ出力
						}

						// 旧会計-リース契約注記合計表
//						if ((!batchPrintTimingCd.equals("4") || !bToukiTukiFlg) && taisyoFlg) {
						if (taisyoFlg) {

							// 2020/05/22 ADD START LACS帳票バッチ出力
							// 開示先コードが変わった場合帳票を出力
							if (!key_goukei_old_cd.equals(companycode)) {
								batchError = "batch0026";

								// 2020/05/22 ADD START LACS帳票バッチ出力
								// リース契約注記合計表【旧】PDFを作成
								batchError = "batch0027";
								gowmodelOld.endReport();
								fileName = gowmodelOld.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
									// 2020/05/22 REP START LACS帳票バッチ出力
											renameTo(new File(pdffilepath + "/" + "06_リース契約注記合計表【旧】_" + shrym + "_"
													+ key_goukei_old_cd + "_" + key_goukei_old_nm + ".pdf"));
									// 2020/05/22 REP END LACS帳票バッチ出力
								}
								// リース会計注記合計表【旧】Model
								gowmodelOld = new LACSReportPDFGoukeiWriter(super.getCommonBean(), this, super.con);
								gowmodelOld.setBatchFlg(true);
								// ブレイクキー設定
								key_goukei_old_cd = companycode;
								key_goukei_old_nm = lacsUserNm;

							}
							// 2020/05/22 ADD END LACS帳票バッチ出力
							batchError = "batch0018";

							// （通期且つ第1期）以外の場合
							if (!bFirstFlg) {
								gowmodelOld.setAcStd("0");
								gowmodelOld.setModelBase(this);
								gowmodelOld.getData(piReportBean);
	
								pageCount = 0;
	
								if (piReportBean.getDataMax() > 0) {
	
									batchError = "batch0019";
									gowmodelOld.makePDF(piReportBean, dateMode, context);
									outputCount++;
									pageCount = piReportBean.getDataMax();
								}
	
								piReportBean.clearList();
							}
							// CVSデータ出力
							// 2020/05/22 DEL START LACS帳票バッチ出力
//							if (bToukiTukiFlg) {
//								reportCVS.setCell(ReportCVS.CVS_CELL_GOUKEI_OLD_TOUKI, String.valueOf(pageCount));
//							} else {
//								reportCVS.setCell(ReportCVS.CVS_CELL_GOUKEI_OLD_TUKI, String.valueOf(pageCount));
//							}
							// 2020/05/22 DEL END LACS帳票バッチ出力
						}

						// 新会計-リース契約注記合計表
//						if ((!batchPrintTimingCd.equals("4") || !bToukiTukiFlg) && taisyoFlg) {
						if (taisyoFlg) {
							// 2020/05/22 ADD START LACS帳票バッチ出力
							// 開示先コードが変わった場合帳票を出力
							if (!key_goukei_new_cd.equals(companycode)) {
								// リース契約注記合計表【新】PDFを作成
								batchError = "batch0028";
								gowmodelNew.endReport();
								fileName = gowmodelNew.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
									// 2020/05/22 REP START LACS帳票バッチ出力
											renameTo(new File(pdffilepath + "/" + "06_リース契約注記合計表【新】_" + shrym + "_"
													+ key_goukei_new_cd + "_" + key_goukei_new_nm + ".pdf"));
									// 2020/05/22 REP END LACS帳票バッチ出力
								}
								// リース会計注記合計表【新】Model
								gowmodelNew = new LACSReportPDFGoukeiWriter(super.getCommonBean(), this, super.con);
								gowmodelNew.setBatchFlg(true);
								// ブレイクキー設定
								key_goukei_new_cd = companycode;
								key_goukei_new_nm = lacsUserNm;
							}
							// 2020/05/22 ADD END LACS帳票バッチ出力

							batchError = "batch0020";

							// （通期且つ第1期）以外の場合
							if (!bFirstFlg) {
								gowmodelNew.setAcStd("1");
								gowmodelNew.setModelBase(this);
								gowmodelNew.getData(piReportBean);
	
								pageCount = 0;
	
								if (piReportBean.getDataMax() > 0) {
	
									batchError = "batch0021";
									gowmodelNew.makePDF(piReportBean, dateMode, context);
									outputCount++;
									pageCount = piReportBean.getDataMax();
								}
	
								piReportBean.clearList();
							}
							// CVSデータ出力
							// 2020/05/22 DEL START LACS帳票バッチ出力
//							if (bToukiTukiFlg) {
//								reportCVS.setCell(ReportCVS.CVS_CELL_GOUKEI_NEW_TOUKI, String.valueOf(pageCount));
//							} else {
//								reportCVS.setCell(ReportCVS.CVS_CELL_GOUKEI_NEW_TUKI, String.valueOf(pageCount));
//							}
							// 2020/05/22 DEL END LACS帳票バッチ出力
						}

						// 受払合計表
//						if ((!batchPrintTimingCd.equals("4") || !bToukiTukiFlg) && taisyoFlg) {
						if (taisyoFlg) {
							// 2020/05/22 ADD START LACS帳票バッチ出力
							// 開示先コードが変わった場合帳票を出力
							if (!key_ukebarai_cd.equals(companycode)) {
								// 受払合計表PDFを作成
								batchError = "batch0029";
								ukemodel.endReport();
								fileName = ukemodel.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
									// 2020/05/22 REP START LACS帳票バッチ出力
											renameTo(new File(pdffilepath + "/" + "03_受払合計表_" + shrym + "_"
													+ key_ukebarai_cd + "_" + key_ukebarai_nm + ".pdf"));
									// 2020/05/22 REP END LACS帳票バッチ出力
								}
								// 受払合計表：受払合計表PDF Model
								ukemodel = new LACSUkebaraiPDFGokeiWriter(super.getCommonBean(), this, super.con);
								ukemodel.setBatchFlg(true);
								// ブレイクキー設定
								key_ukebarai_cd = companycode;
								key_ukebarai_nm = lacsUserNm;
							}
							// 2020/05/22 ADD END LACS帳票バッチ出力

							batchError = "batch0022";

							// （通期且つ第1期）以外の場合
							if (!bFirstFlg) {
								LACSUkebaraiBean piUkebaraiBean = new LACSUkebaraiBean();
	
								// PDF出力モード
								piUkebaraiBean.setOutputMode(1);
	
								piUkebaraiBean.getTermFrom().setDate("", piReportBean.getTermFrom().getInputString1(),
										piReportBean.getTermFrom().getInputString2(),
										piReportBean.getTermFrom().getInputString3());
	
								piUkebaraiBean.getTermTo().setDate("", piReportBean.getTermTo().getInputString1(),
										piReportBean.getTermTo().getInputString2(),
										piReportBean.getTermTo().getInputString3());
	
								piUkebaraiBean.getLeasCompany().add(new ComboValue("", companycode, true));
	
								// 経過月数を設定
								piUkebaraiBean.setTsukiSu(piReportBean.getTermNum());
	
								// 出力対象開始時間
								String iTermFrom = LACSCommand.toDateYYYYMMDD(super.getCommonBean(), super.con, this,
										piUkebaraiBean.getTermFrom());
								piUkebaraiBean.getTermFrom().setYYYYMMDD(iTermFrom);
								// 2025/02/26 START
								System.out.println("-- ukebarai TermFrom YYYYMMDD:" + piUkebaraiBean.getTermFrom().getYYYYMMDD());
								System.out.println("-- ukebarai TermFrom YYYYMM:" + piUkebaraiBean.getTermFrom().getYYYYMM());
								
								// 出力対象終了時間
								String iTermTo = LACSCommand.toDateYYYYMMDD(super.getCommonBean(), super.con, this,
										piUkebaraiBean.getTermTo());
								piUkebaraiBean.getTermTo().setYYYYMMDD(iTermTo);
								System.out.println("-- ukebarai TermTo YYYYMMDD:" + piUkebaraiBean.getTermTo().getYYYYMMDD());
								System.out.println("-- ukebarai TermTo YYYYMM:" + piUkebaraiBean.getTermTo().getYYYYMM());
								// 2025/02/26 END
								
								piUkebaraiBean.setShowList(false);
								LACSUkebaraiCommon.getUkebaraiData(super.getCommonBean(), piUkebaraiBean, this, this.con);
								if (piUkebaraiBean.getDataMax() > 0) {
									piUkebaraiBean.setShowList(true);
								}
	
								ukemodel.getGokeiData(piUkebaraiBean);
								piUkebaraiBean.setLeaseUserNm(lacsUserNm);
	
								pageCount = 0;
	
								if (piUkebaraiBean.getDataMax() > 0) {
	
									batchError = "batch0023";
									ukemodel.makePDF(piUkebaraiBean, context);
									outputCount++;
	
									pageCount = ukemodel.getBatchPrintedPage();
								}
	
								piUkebaraiBean.clearList();
							}
							// CVSデータ出力
							// 2020/05/22 DEL START LACS帳票バッチ出力
//							if (bToukiTukiFlg) {
//								reportCVS.setCell(ReportCVS.CVS_CELL_UKEBARAI_TOUKI, String.valueOf(pageCount));
//							} else {
//								reportCVS.setCell(ReportCVS.CVS_CELL_UKEBARAI_TUKI, String.valueOf(pageCount));
//							}
							// 2020/05/22 DEL END LACS帳票バッチ出力
						}

						// 2020/05/22 ADD START LACS帳票バッチ出力
						// 仕訳合計表
//						if ((!batchPrintTimingCd.equals("4") || !bToukiTukiFlg) && taisyoFlg) {
						if (taisyoFlg) {
							// 2020/05/22 ADD START LACS帳票バッチ出力
							// 開示先コードが変わった場合帳票を出力
							if (!key_siwake_cd.equals(companycode)) {
								// 仕訳合計表PDFを作成
								batchError = "batch0070";
								siwakemodel.endReport();
								fileName = siwakemodel.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
									// 2020/05/22 REP START LACS帳票バッチ出力
											renameTo(new File(pdffilepath + "/" + "02_仕訳合計表_" + shrym + "_"
													+ key_siwake_cd + "_" + key_siwake_nm + ".pdf"));
									// 2020/05/22 REP END LACS帳票バッチ出力
								}
								// 月次帳票出力：仕訳合計表 Model.
								siwakemodel = new LACSMReportPDFSiwakeWriter(super.getCommonBean(), this, super.con);
								siwakemodel.setBatchFlg(true);
								// ブレイクキー設定
								key_siwake_cd = companycode;
								key_siwake_nm = lacsUserNm;
							}
							// 2020/05/22 ADD END LACS帳票バッチ出力

							batchError = "batch0040";

							// （通期且つ第1期）以外の場合
							if (!bFirstFlg) {
								// System.out.println("-- test siwake st cd:" + companycode);
								LACSMReportBean piMReportBean = new LACSMReportBean();
								piMReportBean.init(super.getCommonBean());
	
								// PDF出力
								piMReportBean.setOutputMode(1);
								pageCount = 0;
	
								// 各パラメータ設定
								piMReportBean.getTermFrom().setDate("", piReportBean.getTermFrom().getInputString1(),
										piReportBean.getTermFrom().getInputString2(),
										piReportBean.getTermFrom().getInputString3());
	
								piMReportBean.getTermTo().setDate("", piReportBean.getTermTo().getInputString1(),
										piReportBean.getTermTo().getInputString2(),
										piReportBean.getTermTo().getInputString3());
	
								// 出力対象開始時間
								String iTermFrom = LACSCommand.toDateYYYYMMDD(super.getCommonBean(), super.con, this,
										piMReportBean.getTermFrom());
								piMReportBean.getTermFrom().setYYYYMMDD(iTermFrom);
								System.out.println("-- siwake TermFrom:" + piMReportBean.getTermFrom().getYYYYMM());
	
								//Date iTermFrom = Convert.toDate(LACSCommand.toDateYYYYMMDD(super.getCommonBean(), super.con, this,
								//		piMReportBean.getTermFrom()));
								//piMReportBean.getTermFrom().setYYYYMMDD(iTermFrom.toString());
								
								// 出力対象終了時間
								String iTermTo = LACSCommand.toDateYYYYMMDD(super.getCommonBean(), super.con, this,
										piMReportBean.getTermTo());
								piMReportBean.getTermTo().setYYYYMMDD(iTermTo);
								System.out.println("-- siwake TermTo:" + piMReportBean.getTermTo().getYYYYMM());
	
								//Date iTermTo = Convert.toDate(LACSCommand.toDateYYYYMMDD(super.getCommonBean(), super.con, this,
								//		piMReportBean.getTermFrom()));
								//piMReportBean.getTermFrom().setYYYYMMDD(iTermTo.toString());
								
								// 経過月数を設定　20210629 arai 当月の対象期間の設定方法の修正
								//piMReportBean.setTsukiSu(piReportBean.getTermNum());
								if (bToukiTukiFlg && batchPrintTimingCd.equals("1")) {
								    piMReportBean.setTermNum("1");
								} else {
								    piMReportBean.setTermNum(Convert.toString(DateUtl.differenceMonth(dateTo, dateFrom)));
								}
								System.out.println("-- siwake TermNm:" + piMReportBean.getTermNum());
	
								// Cosmosコードを設定
								piMReportBean.getLeasCompany().clear();
								piMReportBean.getLeasCompany().add(new ComboValue("", companycode, true));
	
								// 物件Bean
								// LACSKeiyakuBean piKeiyakuBean= new LACSKeiyakuBean();
	
								// 開示先単位の画面情報の取得（デフォルト値の設定）
								getUserMReporData(piMReportBean);
								siwakemodel.getData(piMReportBean);
								System.out.println("-- siwake CNT:" + piMReportBean.getDataMax());
	
								if (piMReportBean.getDataMax() > 0) {
									batchError = "batch0041";
									siwakemodel.makePDF(piMReportBean, dateMode, context);
									outputCount++;
									// pageCount = piMReportBean.getDataMax();
									pageCount = siwakemodel.getBatchPrintedPage();
								}
								piMReportBean.clearList();
							}
							// CVSデータ出力
							// 2020/05/22 DEL START LACS帳票バッチ出力
//							if (bToukiTukiFlg) {
//								reportCVS.setCell(ReportCVS.CVS_CELL_SIWAKE_TOUKI, String.valueOf(pageCount));
//							} else {
//								reportCVS.setCell(ReportCVS.CVS_CELL_SIWAKE_TUKI, String.valueOf(pageCount));
//							}
							// 2020/05/22 DEL END LACS帳票バッチ出力
							// System.out.println("-- test siwake ed cd:" + companycode);
						}
						// 2020/05/22 ADD END LACS帳票バッチ出力
						// 2020/05/22 ADD START LACS帳票バッチ出力
						// リース料受払明細表
//						if ((!batchPrintTimingCd.equals("4") || !bToukiTukiFlg) && taisyoFlg) {
						if (taisyoFlg) {
							System.out.println("-- test LeasUke st cd:" + companycode);

							// 開示先コードが変わった場合帳票を出力
							if (!key_leas_uke_cd.equals(companycode)) {
								// リース資産受払明細表PDFを作成
								batchError = "batch0071";
								leasukemodel.endReport();
								fileName = leasukemodel.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
									// 2020/05/22 REP START LACS帳票バッチ出力
											renameTo(new File(pdffilepath + "/" + "04_リース料受払明細表_" + shrym + "_"
													+ key_leas_uke_cd + "_" + key_leas_uke_nm + ".pdf"));
									// 2020/05/22 REP END LACS帳票バッチ出力
								}
								// 受払合計表出力：リース料受払明細表 Model.
								leasukemodel = new LACSUkebaraiPDFLeaseWriter(super.getCommonBean(), this, super.con);
								leasukemodel.setBatchFlg(true);
								// ブレイクキー設定
								key_leas_uke_cd = companycode;
								key_leas_uke_nm = lacsUserNm;
							}
							// 2020/05/22 ADD END LACS帳票バッチ出力

							// （通期且つ第1期）以外の場合
							if (!bFirstFlg) {
								batchError = "batch0042";
	
								LACSUkebaraiBean piUkebaraiBean = new LACSUkebaraiBean();
	
								// PDF出力モード
								piUkebaraiBean.setOutputMode(1);
	
								piUkebaraiBean.getTermFrom().setDate("", piReportBean.getTermFrom().getInputString1(),
										piReportBean.getTermFrom().getInputString2(),
										piReportBean.getTermFrom().getInputString3());
	
								piUkebaraiBean.getTermTo().setDate("", piReportBean.getTermTo().getInputString1(),
										piReportBean.getTermTo().getInputString2(),
										piReportBean.getTermTo().getInputString3());
	
								piUkebaraiBean.getLeasCompany().add(new ComboValue("", companycode, true));
	
								// 経過月数を設定
								piUkebaraiBean.setTsukiSu(piReportBean.getTermNum());
	
								// 出力対象開始時間
								String iTermFrom = LACSCommand.toDateYYYYMMDD(super.getCommonBean(), super.con, this,
										piUkebaraiBean.getTermFrom());
								piUkebaraiBean.getTermFrom().setYYYYMMDD(iTermFrom);
	
								// 出力対象終了時間
								String iTermTo = LACSCommand.toDateYYYYMMDD(super.getCommonBean(), super.con, this,
										piUkebaraiBean.getTermTo());
								piUkebaraiBean.getTermTo().setYYYYMMDD(iTermTo);
	
								leasukemodel.getLeaseData(piUkebaraiBean);
								// piUkebaraiBean.setShowList(false);
								// LACSUkebaraiCommon.getUkebaraiData(super.getCommonBean(), piUkebaraiBean,
								// this, this.con);
	
								pageCount = 0;
	
								// System.out.println("-- LeasUke CNT:" + piUkebaraiBean.getDataMax());
								if (piUkebaraiBean.getDataMax() > 0) {
	
									// piUkebaraiBean.setShowList(true);
									batchError = "batch0043";
									leasukemodel.makePDF(piUkebaraiBean, context);
									outputCount++;
									// pageCount = piUkebaraiBean.getDataMax();
									pageCount = leasukemodel.getBatchPrintedPage();
								}
	
								piUkebaraiBean.clearList();
							}
							// CVSデータ出力
							// 2020/05/22 DEL START LACS帳票バッチ出力
//							if (bToukiTukiFlg) {
//								reportCVS.setCell(ReportCVS.CVS_CELL_LEAS_UKE_TOUKI, String.valueOf(pageCount));
//							} else {
//								reportCVS.setCell(ReportCVS.CVS_CELL_LEAS_UKE_TUKI, String.valueOf(pageCount));
//							}
							// 2020/05/22 DEL END LACS帳票バッチ出力
							System.out.println("-- test LeasUke ed cd:" + companycode);
						}

						// 2020/05/22 ADD END LACS帳票バッチ出力
						// 2020/05/22 ADD START LACS帳票バッチ出力
						// リース資産受払明細表
//						if ((!batchPrintTimingCd.equals("4") || !bToukiTukiFlg) && taisyoFlg) {
						if (taisyoFlg) {
							System.out.println("-- test SisanUke st cd:" + companycode);
							// 2020/05/22 ADD START LACS帳票バッチ出力
							// 開示先コードが変わった場合帳票を出力
							if (!key_sisan_uke_cd.equals(companycode)) {
								// リース資産受払明細表PDFを作成
								batchError = "batch0072";
								sisanukemodel.endReport();
								fileName = sisanukemodel.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName)
											.renameTo(new File(pdffilepath + "/" + "05_リース資産受払明細表_" + shrym + "_"
													+ key_sisan_uke_cd + "_" + key_sisan_uke_nm + ".pdf"));
								}
								// 受払合計表出力：リース資産受払明細表 Model.
								sisanukemodel = new LACSUkebaraiPDFSisanWriter(super.getCommonBean(), this, super.con);
								sisanukemodel.setBatchFlg(true);
								// ブレイクキー設定
								key_sisan_uke_cd = companycode;
								key_sisan_uke_nm = lacsUserNm;
							}
							// 2020/05/22 ADD END LACS帳票バッチ出力

							batchError = "batch0044";

							// （通期且つ第1期）以外の場合
							if (!bFirstFlg) {
								LACSUkebaraiBean piUkebaraiBean = new LACSUkebaraiBean();
	
								// PDF出力モード
								piUkebaraiBean.setOutputMode(1);
	
								piUkebaraiBean.getTermFrom().setDate("", piReportBean.getTermFrom().getInputString1(),
										piReportBean.getTermFrom().getInputString2(),
										piReportBean.getTermFrom().getInputString3());
	
								piUkebaraiBean.getTermTo().setDate("", piReportBean.getTermTo().getInputString1(),
										piReportBean.getTermTo().getInputString2(),
										piReportBean.getTermTo().getInputString3());
	
								piUkebaraiBean.getLeasCompany().add(new ComboValue("", companycode, true));
	
								// 経過月数を設定
								piUkebaraiBean.setTsukiSu(piReportBean.getTermNum());
	
								// 出力対象開始時間
								String iTermFrom = LACSCommand.toDateYYYYMMDD(super.getCommonBean(), super.con, this,
										piUkebaraiBean.getTermFrom());
								piUkebaraiBean.getTermFrom().setYYYYMMDD(iTermFrom);
	
								// 出力対象終了時間
								String iTermTo = LACSCommand.toDateYYYYMMDD(super.getCommonBean(), super.con, this,
										piUkebaraiBean.getTermTo());
								piUkebaraiBean.getTermTo().setYYYYMMDD(iTermTo);
	
								sisanukemodel.getSisanData(piUkebaraiBean);
								// piUkebaraiBean.setShowList(false);
								// LACSUkebaraiCommon.getUkebaraiData(super.getCommonBean(), piUkebaraiBean,
								// this, this.con);
	
								pageCount = 0;
	
								// System.out.println("-- LeasUke CNT:" + piUkebaraiBean.getDataMax());
								if (piUkebaraiBean.getDataMax() > 0) {
	
									// piUkebaraiBean.setShowList(true);
									batchError = "batch0045";
									sisanukemodel.makePDF(piUkebaraiBean, context);
									outputCount++;
									// pageCount = piUkebaraiBean.getDataMax();
									pageCount = sisanukemodel.getBatchPrintedPage();
								}
	
								piUkebaraiBean.clearList();
							}
							// CVSデータ出力
							// 2020/05/22 DEL START LACS帳票バッチ出力
//							if (bToukiTukiFlg) {
//								reportCVS.setCell(ReportCVS.CVS_CELL_SISAN_UKE_TOUKI, String.valueOf(pageCount));
//							} else {
//								reportCVS.setCell(ReportCVS.CVS_CELL_SISAN_UKE_TUKI, String.valueOf(pageCount));
//							}
							// 2020/05/22 DEL END LACS帳票バッチ出力
							System.out.println("-- test LeasUke ed cd:" + companycode);
						}
						// 2020/05/22 ADD END LACS帳票バッチ出力

						// 2020/05/22 ADD START LACS帳票バッチ出力
						// 旧会計-支払リース料
//						if ((!batchPrintTimingCd.equals("4") || !bToukiTukiFlg) && taisyoFlg) {
						if (taisyoFlg) {
							// 2020/05/22 ADD START LACS帳票バッチ出力
							// 開示先コードが変わった場合帳票を出力
							if (!key_siharai_old_cd.equals(companycode)) {
								// 支払リース料【旧】PDFを作成
								batchError = "batch0073";
								siharaimodelOld.endReport();
								fileName = siharaimodelOld.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
									// 2020/05/22 REP START LACS帳票バッチ出力
											renameTo(new File(pdffilepath + "/" + "07_リース会計資料(支払リース料等)【旧】_" + shrym
													+ "_" + key_siharai_old_cd + "_" + key_siharai_old_nm + ".pdf"));
									// 2020/05/22 REP END LACS帳票バッチ出力
								}
								// 帳票出力：支払リース料【旧】 Model.
								siharaimodelOld = new LACSReportPDFSiharaiWriter(super.getCommonBean(), this,
										super.con);
								siharaimodelOld.setBatchFlg(true);
								// ブレイクキー設定
								key_siharai_old_cd = companycode;
								key_siharai_old_nm = lacsUserNm;
							}
							// 2020/05/22 ADD END LACS帳票バッチ出力

							batchError = "batch0046";
							// （通期且つ第1期）以外の場合
							if (!bFirstFlg) {
								System.out.println("-- test SiharaiOLD st cd:" + companycode);
								siharaimodelOld.setAcStd("0");
								// siharaimodelOld.setModelBase(this);
								siharaimodelOld.getData(piReportBean);
	
								pageCount = 0;
	
								System.out.println("-- SiharaiOLD CNT:" + piReportBean.getDataMax());
								if (piReportBean.getDataMax() > 0) {
	
									batchError = "batch0047";
									siharaimodelOld.makePDF(piReportBean, dateMode, context);
									outputCount++;
									pageCount = siharaimodelOld.getBatchPrintedPage();
								}
	
								piReportBean.clearList();
							}
							// CVSデータ出力
							// 2020/05/22 DEL START LACS帳票バッチ出力
//							if (bToukiTukiFlg) {
//								reportCVS.setCell(ReportCVS.CVS_CELL_SIHARAI_OLD_TOUKI, String.valueOf(pageCount));
//							} else {
//								reportCVS.setCell(ReportCVS.CVS_CELL_SIHARAI_OLD_TUKI, String.valueOf(pageCount));
//							}
							// 2020/05/22 DEL END LACS帳票バッチ出力
							System.out.println("-- test SiharaiOLD ed cd:" + companycode);
						}

						// 新会計-支払リース料
//						if ((!batchPrintTimingCd.equals("4") || !bToukiTukiFlg) && taisyoFlg) {
						if (taisyoFlg) {
							// 2020/05/22 ADD START LACS帳票バッチ出力
							// 開示先コードが変わった場合帳票を出力
							if (!key_siharai_new_cd.equals(companycode)) {
								// 支払リース料【新】PDFを作成
								batchError = "batch0074";
								siharaimodelNew.endReport();
								fileName = siharaimodelNew.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
									// 2020/05/22 REP START LACS帳票バッチ出力
											renameTo(new File(pdffilepath + "/" + "07_リース会計資料(支払リース料等)【新】_" + shrym
													+ "_" + key_siharai_new_cd + "_" + key_siharai_new_nm + ".pdf"));
									// 2020/05/22 REP END LACS帳票バッチ出力
								}
								// 帳票出力：支払リース料【新】 Model.
								siharaimodelNew = new LACSReportPDFSiharaiWriter(super.getCommonBean(), this,
										super.con);
								siharaimodelNew.setBatchFlg(true);
								// ブレイクキー設定
								key_siharai_new_cd = companycode;
								key_siharai_new_nm = lacsUserNm;
							}
							// 2020/05/22 ADD END LACS帳票バッチ出力

							batchError = "batch0048";
							// System.out.println("-- test SiharaiNEW st cd:" + companycode);

							// （通期且つ第1期）以外の場合
							if (!bFirstFlg) {
								siharaimodelNew.setAcStd("1");
								// siharaimodelNew.setModelBase(this);
								siharaimodelNew.getData(piReportBean);
	
								pageCount = 0;
	
								// System.out.println("-- SiharaiNEW CNT:" + piReportBean.getDataMax());
								if (piReportBean.getDataMax() > 0) {
	
									batchError = "batch0049";
									siharaimodelNew.makePDF(piReportBean, dateMode, context);
									outputCount++;
									pageCount = siharaimodelOld.getBatchPrintedPage();
								}
	
								piReportBean.clearList();
							}
							// CVSデータ出力
							// 2020/05/22 DEL START LACS帳票バッチ出力
//							if (bToukiTukiFlg) {
//								reportCVS.setCell(ReportCVS.CVS_CELL_SIHARAI_NEW_TOUKI, String.valueOf(pageCount));
//							} else {
//								reportCVS.setCell(ReportCVS.CVS_CELL_SIHARAI_NEW_TUKI, String.valueOf(pageCount));
//							}
							// 2020/05/22 DEL END LACS帳票バッチ出力
							// System.out.println("-- test SiharaiNEW ed cd:" + companycode);
						}
						// 2020/05/22 ADD END LACS帳票バッチ出力

						// 2020/05/22 ADD START LACS帳票バッチ出力
						// 旧会計-減価償却費
//						if ((!batchPrintTimingCd.equals("4") || !bToukiTukiFlg) && taisyoFlg) {
						if (taisyoFlg) {
							// 2020/05/22 ADD START LACS帳票バッチ出力
							// 開示先コードが変わった場合帳票を出力
							if (!key_genka_old_cd.equals(companycode)) {
								// 減価償却費【旧】PDFを作成
								batchError = "batch0075";
								genkamodelOld.endReport();
								fileName = genkamodelOld.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
									// 2020/05/22 REP START LACS帳票バッチ出力
											renameTo(new File(pdffilepath + "/" + "08_リース会計資料(減価償却費)【旧】_" + shrym + "_"
													+ key_genka_old_cd + "_" + key_genka_old_nm + ".pdf"));
									// 2020/05/22 REP END LACS帳票バッチ出力
								}
								// 帳票出力：減価償却費【旧】 Model.
								genkamodelOld = new LACSReportPDFGenkaWriter(super.getCommonBean(), this, super.con);
								genkamodelOld.setBatchFlg(true);
								// ブレイクキー設定
								key_genka_old_cd = companycode;
								key_genka_old_nm = lacsUserNm;
							}
							// 2020/05/22 ADD END LACS帳票バッチ出力

							batchError = "batch0050";
							System.out.println("-- test GenkaOLD st cd:" + companycode);
							// （通期且つ第1期）以外の場合
							if (!bFirstFlg) {
								genkamodelOld.setAcStd("0");
								// siharaimodelOld.setModelBase(this);
								genkamodelOld.getData(piReportBean);
	
								pageCount = 0;
	
								// System.out.println("-- GenkaOLD CNT:" + piReportBean.getDataMax());
								if (piReportBean.getDataMax() > 0) {
	
									batchError = "batch0051";
									genkamodelOld.makePDF(piReportBean, dateMode, context);
									outputCount++;
									pageCount = genkamodelOld.getBatchPrintedPage();
								}
	
								piReportBean.clearList();
							}
							// CVSデータ出力
							// 2020/05/22 DEL START LACS帳票バッチ出力
//							if (bToukiTukiFlg) {
//								reportCVS.setCell(ReportCVS.CVS_CELL_GENKA_OLD_TOUKI, String.valueOf(pageCount));
//							} else {
//								reportCVS.setCell(ReportCVS.CVS_CELL_GENKA_OLD_TUKI, String.valueOf(pageCount));
//							}
							// 2020/05/22 DEL END LACS帳票バッチ出力
							System.out.println("-- test GenkaOLD ed cd:" + companycode);
						}

						// 新会計-減価償却費
//						if ((!batchPrintTimingCd.equals("4") || !bToukiTukiFlg) && taisyoFlg) {
						if (taisyoFlg) {
							// 2020/05/22 ADD START LACS帳票バッチ出力
							// 開示先コードが変わった場合帳票を出力
							if (!key_genka_new_cd.equals(companycode)) {
								// 減価償却費【新】PDFを作成
								batchError = "batch0076";
								genkamodelNew.endReport();
								fileName = genkamodelNew.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
									// 2020/05/22 REP START LACS帳票バッチ出力
											renameTo(new File(pdffilepath + "/" + "08_リース会計資料(減価償却費)【新】_" + shrym + "_"
													+ key_genka_new_cd + "_" + key_genka_new_nm + ".pdf"));
									// 2020/05/22 REP END LACS帳票バッチ出力
								}
								// 帳票出力：減価償却費【新】 Model.
								genkamodelNew = new LACSReportPDFGenkaWriter(super.getCommonBean(), this, super.con);
								genkamodelNew.setBatchFlg(true);
								// ブレイクキー設定
								key_genka_new_cd = companycode;
								key_genka_new_nm = lacsUserNm;
							}
							// 2020/05/22 ADD END LACS帳票バッチ出力

							batchError = "batch0052";
							// System.out.println("-- test GenkaNEW st cd:" + companycode);

							// （通期且つ第1期）以外の場合
							if (!bFirstFlg) {
								genkamodelNew.setAcStd("1");
								// siharaimodelNew.setModelBase(this);
								genkamodelNew.getData(piReportBean);
	
								pageCount = 0;
	
								// System.out.println("-- GenkaNEW CNT:" + piReportBean.getDataMax());
								if (piReportBean.getDataMax() > 0) {
	
									batchError = "batch0053";
									genkamodelNew.makePDF(piReportBean, dateMode, context);
									outputCount++;
									pageCount = genkamodelNew.getBatchPrintedPage();
								}
	
								piReportBean.clearList();
							}
							// CVSデータ出力
							// 2020/05/22 DEL START LACS帳票バッチ出力
//							if (bToukiTukiFlg) {
//								reportCVS.setCell(ReportCVS.CVS_CELL_GENKA_NEW_TOUKI, String.valueOf(pageCount));
//							} else {
//								reportCVS.setCell(ReportCVS.CVS_CELL_GENKA_NEW_TUKI, String.valueOf(pageCount));
//							}
							// 2020/05/22 DEL END LACS帳票バッチ出力
							System.out.println("-- test GenkaNEW ed cd:" + companycode);
						}
						// 2020/05/22 ADD END LACS帳票バッチ出力

						// 2020/05/22 DEL START LACS帳票バッチ出力
						// リース会計基準明細書
//						if ( bToukiTukiFlg ) {
//							batchError = "batch0024";
//							
//							LACSMReportBean piMReportBean = new LACSMReportBean();
//							piMReportBean.init(super.getCommonBean());
//							
//							// PDF出力モード
//							piMReportBean.setOutputMode(1);
//							
//							// Cosmosコードを設定する
//							piMReportBean.getLeasCompany().clear();
//							piMReportBean.getLeasCompany().add(new ComboValue("", companycode, true));
//							
//							// 物件検索Bean
//							LACSKeiyakuBean piKeiyakuBean= new LACSKeiyakuBean();
//							
//							// 契約No検索条件を設定する
//							piKeiyakuBean.getLeasCompany().add(new ComboValue("", companycode, true));
//							piKeiyakuBean.setKeiyakuRls("1");
//							super.getCommonBean().getEnableUserList().add(LACSDefine.INFO_ALL);
//							
//							// 契約Noを検索する
//							this.getLacsKeiyakuNoList(piKeiyakuBean);
//							
//							batchError = "batch0025";
//							
//							//　出力した総ページ数
//							pageCount = 0;
//
//							for (int j = 0; j < piKeiyakuBean.getListCount(); j++) {
//								piMReportBean.setKeiyakuNo(piKeiyakuBean.getDetail(j).getHyoujiKeiyakuNo());
//								
//								kaimodel.getData(piMReportBean);
//								
//								if (piMReportBean.getDataMax() > 0) {
//									
//									kaimodel.makePDF(piMReportBean, dateMode, context);
//									pageCount += kaimodel.getBatchPrintedPage();
//									outputCount++;
//								}
//								
//								piMReportBean.clearList();
//							}
//							
//							// CVSデータ出力
//							reportCVS.setCell(ReportCVS.CVS_CELL_KAIKEI, String.valueOf(pageCount));
//						}
						// 2020/05/22 DEL END LACS帳票バッチ出力

// 2020/05/22 ADD START LACS帳票バッチ出力
						// 旧会計-期日別予定表(合計表)
//						if ((!batchPrintTimingCd.equals("4") || !bToukiTukiFlg) && taisyoFlg) {
						if (taisyoFlg) {

							// 開示先コードが変わった場合帳票を出力
							if (!key_kijitu_goukei_old_cd.equals(companycode)) {
								// 期日別予定表(合計表)【旧】PDFを作成
								batchError = "batch0077";
								kijitugoukeimodelOld.endReport();
								fileName = kijitugoukeimodelOld.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName)
											.renameTo(new File(pdffilepath + "/" + "09_期日別予定表(合計表)【旧】_" + shrym + "_"
													+ key_kijitu_goukei_old_cd + "_" + key_kijitu_goukei_old_nm
													+ ".pdf"));
								}
								// 帳票出力：期日別予定表(合計表)【旧】 Model.
								kijitugoukeimodelOld = new LACSreportPDFKizitubetuGoukeiWriter(super.getCommonBean(),
										this, super.con);
								kijitugoukeimodelOld.setBatchFlg(true);
								// ブレイクキー設定
								key_kijitu_goukei_old_cd = companycode;
								key_kijitu_goukei_old_nm = lacsUserNm;
							}
// 2021/06/08 期日別予定表 当期分のみ出力対応 START
							// 当期のみ出力
							if (bToukiTukiFlg) {
								batchError = "batch0054";

								kijitugoukeimodelOld.setAcStd("0");
								// kijitugoukeimodelOld.setModelBase(this);
								kijitugoukeimodelOld.getData(piReportBean);

								pageCount = 0;

								if (piReportBean.getDataMax() > 0) {

									batchError = "batch0055";
									kijitugoukeimodelOld.makePDF(piReportBean, dateMode, context);
									outputCount++;
									// pageCount = kijitugoukeimodelOld.getBatchPrintedPage;
								}

								piReportBean.clearList();
							}
// 2021/06/08 期日別予定表 当期分のみ出力対応 END
							// CVSデータ出力
							// if (bToukiTukiFlg) {
							// reportCVS.setCell(ReportCVS.CVS_CELL_KIJITU_GOUKEI_OLD_TOUKI,
							// String.valueOf(pageCount));
							// } else {
							// reportCVS.setCell(ReportCVS.CVS_CELL_KIJITU_GOUKEI_OLD_TUKI,
							// String.valueOf(pageCount));
							// }
						}
// 2020/05/22 ADD END   LACS帳票バッチ出力
// 2020/05/22 ADD START LACS帳票バッチ出力
						// 新会計-期日別予定表(合計表)
//						if ((!batchPrintTimingCd.equals("4") || !bToukiTukiFlg) && taisyoFlg) {
						if (taisyoFlg) {
							// 開示先コードが変わった場合帳票を出力
							if (!key_kijitu_goukei_new_cd.equals(companycode)) {
								// 期日別予定表(合計表)【新】PDFを作成
								batchError = "batch0078";
								kijitugoukeimodelNew.endReport();
								fileName = kijitugoukeimodelNew.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName)
											.renameTo(new File(pdffilepath + "/" + "09_期日別予定表(合計表)【新】_" + shrym + "_"
													+ key_kijitu_goukei_new_cd + "_" + key_kijitu_goukei_new_nm
													+ ".pdf"));
								}
								// 帳票出力：期日別予定表(合計表)【新】 Model.
								kijitugoukeimodelNew = new LACSreportPDFKizitubetuGoukeiWriter(super.getCommonBean(),
										this, super.con);
								kijitugoukeimodelNew.setBatchFlg(true);
								// ブレイクキー設定
								key_kijitu_goukei_new_cd = companycode;
								key_kijitu_goukei_new_nm = lacsUserNm;
							}
// 2021/06/08 期日別予定表 当期分のみ出力対応 START
							// 当期のみ出力
							if (bToukiTukiFlg) {
								batchError = "batch0056";

								kijitugoukeimodelNew.setAcStd("1");
								// kijitugoukeimodelNew.setModelBase(this);
								kijitugoukeimodelNew.getData(piReportBean);

								pageCount = 0;

								if (piReportBean.getDataMax() > 0) {

									batchError = "batch0057";
									kijitugoukeimodelNew.makePDF(piReportBean, dateMode, context);
									outputCount++;
									// pageCount = kijitugoukeimodelNew.getBatchPrintedPage;
								}

								piReportBean.clearList();
							}
// 2021/06/08 期日別予定表 当期分のみ出力対応 END
							// CVSデータ出力
							// if (bToukiTukiFlg) {
							// reportCVS.setCell(ReportCVS.CVS_CELL_KIJITU_GOUKEI_NEW_TOUKI,
							// String.valueOf(pageCount));
							// } else {
							// reportCVS.setCell(ReportCVS.CVS_CELL_KIJITU_GOUKEI_NEW_TUKI,
							// String.valueOf(pageCount));
							// }
						}
// 2020/05/22 ADD END   LACS帳票バッチ出力
//
// 2020/05/22 ADD START LACS帳票バッチ出力
						// 旧会計-期日別予定表(債務)
//						if ((!batchPrintTimingCd.equals("4") || !bToukiTukiFlg) && taisyoFlg) {
						if (taisyoFlg) {
							// 開示先コードが変わった場合帳票を出力
							if (!key_kijitu_saim_old_cd.equals(companycode)) {
								// 期日別予定表(債務)【旧】PDFを作成
								batchError = "batch0079";
								kijitusaimmodelOld.endReport();
								fileName = kijitusaimmodelOld.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName)
											.renameTo(new File(pdffilepath + "/" + "10_期日別予定表(債務)【旧】_" + shrym + "_"
													+ key_kijitu_saim_old_cd + "_" + key_kijitu_saim_old_nm + ".pdf"));
								}
								// 帳票出力：期日別予定表(債務)【旧】 Model.
								kijitusaimmodelOld = new LACSReportPDFKizitubetuSaimuWriter(super.getCommonBean(), this,
										super.con);
								kijitusaimmodelOld.setBatchFlg(true);
								// ブレイクキー設定
								key_kijitu_saim_old_cd = companycode;
								key_kijitu_saim_old_nm = lacsUserNm;
							}

// 2021/06/08 期日別予定表 当期分のみ出力対応 START
							// 当期のみ出力
							if (bToukiTukiFlg) {

								batchError = "batch0058";

								kijitusaimmodelOld.setAcStd("0");
								// kijitusaimmodelOld.setModelBase(this);
								kijitusaimmodelOld.getData(piReportBean);

								pageCount = 0;

								if (piReportBean.getDataMax() > 0) {

									batchError = "batch0059";
									kijitusaimmodelOld.makePDF(piReportBean, dateMode, context);
									outputCount++;
									// pageCount = kijitusaimmodelOld.getBatchPrintedPage;
								}

								piReportBean.clearList();
							}
// 2021/06/08 期日別予定表 当期分のみ出力対応 END
//							//　CVSデータ出力
//							if (bToukiTukiFlg) {
//								reportCVS.setCell(ReportCVS.CVS_CELL_KIJITU_SAIM_OLD_TOUKI, String.valueOf(pageCount));
//							} else {
//								reportCVS.setCell(ReportCVS.CVS_CELL_KIJITU_SAIM_OLD_TUKI, String.valueOf(pageCount));
//							}
						}
// 2020/05/22 ADD END   LACS帳票バッチ出力
// 2020/05/22 ADD START LACS帳票バッチ出力
						// 新会計-期日別予定表(債務)
//						if ((!batchPrintTimingCd.equals("4") || !bToukiTukiFlg) && taisyoFlg) {
						if (taisyoFlg) {
							// 開示先コードが変わった場合帳票を出力
							if (!key_kijitu_saim_new_cd.equals(companycode)) {
								// 期日別予定表(債務)【新】PDFを作成
								batchError = "batch0080";
								kijitusaimmodelNew.endReport();
								fileName = kijitusaimmodelNew.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName)
											.renameTo(new File(pdffilepath + "/" + "10_期日別予定表(債務)【新】_" + shrym + "_"
													+ key_kijitu_saim_new_cd + "_" + key_kijitu_saim_new_nm + ".pdf"));
								}
								// 帳票出力：期日別予定表(債務)【新】 Model.
								kijitusaimmodelNew = new LACSReportPDFKizitubetuSaimuWriter(super.getCommonBean(), this,
										super.con);
								kijitusaimmodelNew.setBatchFlg(true);
								// ブレイクキー設定
								key_kijitu_saim_new_cd = companycode;
								key_kijitu_saim_new_nm = lacsUserNm;
							}
// 2021/06/08 期日別予定表 当期分のみ出力対応 START
							// 当期のみ出力
							if (bToukiTukiFlg) {
								batchError = "batch0060";

								kijitusaimmodelNew.setAcStd("1");
								// kijitusaimmodelNew.setModelBase(this);
								kijitusaimmodelNew.getData(piReportBean);

								pageCount = 0;

								if (piReportBean.getDataMax() > 0) {

									batchError = "batch0061";
									kijitusaimmodelNew.makePDF(piReportBean, dateMode, context);
									outputCount++;
									// pageCount = kijitusaimmodelNew.getBatchPrintedPage;
								}

								piReportBean.clearList();
							}
// 2021/06/08 期日別予定表 当期分のみ出力対応 END
//							//　CVSデータ出力
//							if (bToukiTukiFlg) {
//								reportCVS.setCell(ReportCVS.CVS_CELL_KIJITU_SAIM_NEW_TOUKI, String.valueOf(pageCount));
//							} else {
//								reportCVS.setCell(ReportCVS.CVS_CELL_KIJITU_SAIM_NEW_TUKI, String.valueOf(pageCount));
//							}
						}
// 2020/05/22 ADD END   LACS帳票バッチ出力
//
// 2020/05/22 ADD START LACS帳票バッチ出力
						// 旧会計-期日別予定表(資産)
//						if ((!batchPrintTimingCd.equals("4") || !bToukiTukiFlg) && taisyoFlg) {
						if (taisyoFlg) {
							// 開示先コードが変わった場合帳票を出力
							if (!key_kijitu_sisan_old_cd.equals(companycode)) {
								// 期日別予定表(資産)【旧】PDFを作成
								batchError = "batch0081";
								kijitusisanmodelOld.endReport();
								fileName = kijitusisanmodelOld.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName)
											.renameTo(new File(pdffilepath + "/" + "11_期日別予定表(資産)【旧】_" + shrym + "_"
													+ key_kijitu_sisan_old_cd + "_" + key_kijitu_sisan_old_nm
													+ ".pdf"));
								}
								// 帳票出力：期日別予定表(資産)【旧】 Model.
								kijitusisanmodelOld = new LACSReportPDFKizitubetuSisanWriter(super.getCommonBean(),
										this, super.con);
								kijitusisanmodelOld.setBatchFlg(true);
								// ブレイクキー設定
								key_kijitu_sisan_old_cd = companycode;
								key_kijitu_sisan_old_nm = lacsUserNm;
							}
// 2021/06/08 期日別予定表 当期分のみ出力対応 START
							// 当期のみ出力
							if (bToukiTukiFlg) {
								batchError = "batch0062";

								kijitusisanmodelOld.setAcStd("0");
								// kijitusisanmodelOld.setModelBase(this);
								kijitusisanmodelOld.getData(piReportBean);

								pageCount = 0;

								if (piReportBean.getDataMax() > 0) {

									batchError = "batch0063";
									kijitusisanmodelOld.makePDF(piReportBean, dateMode, context);
									outputCount++;
									// pageCount = kijitusisanmodelOld.getBatchPrintedPage;
								}

								piReportBean.clearList();
							}
// 2021/06/08 期日別予定表 当期分のみ出力対応 END
							// CVSデータ出力
//							if (bToukiTukiFlg) {
//								reportCVS.setCell(ReportCVS.CVS_CELL_KIJITU_SISAN_OLD_TOUKI, String.valueOf(pageCount));
//							} else {
//								reportCVS.setCell(ReportCVS.CVS_CELL_KIJITU_SISAN_OLD_TUKI, String.valueOf(pageCount));
//							}
						}
// 2020/05/22 ADD END   LACS帳票バッチ出力
// 2020/05/22 ADD START LACS帳票バッチ出力
						// 新会計-期日別予定表(資産)
//						if ((!batchPrintTimingCd.equals("4") || !bToukiTukiFlg) && taisyoFlg) {
						if (taisyoFlg) {
							// 開示先コードが変わった場合帳票を出力
							if (!key_kijitu_sisan_new_cd.equals(companycode)) {
								// 期日別予定表(資産)【新】PDFを作成
								batchError = "batch0082";
								kijitusisanmodelNew.endReport();
								fileName = kijitusisanmodelNew.getFileName();

								// ファイルを移動する
								if (!fileName.trim().equals("")) {
									new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName)
											.renameTo(new File(pdffilepath + "/" + "11_期日別予定表(資産)【新】_" + shrym + "_"
													+ key_kijitu_sisan_new_cd + "_" + key_kijitu_sisan_new_nm
													+ ".pdf"));
								}
								// 帳票出力：期日別予定表(資産)【新】 Model.
								kijitusisanmodelNew = new LACSReportPDFKizitubetuSisanWriter(super.getCommonBean(),
										this, super.con);
								kijitusisanmodelNew.setBatchFlg(true);
								// ブレイクキー設定
								key_kijitu_sisan_new_cd = companycode;
								key_kijitu_sisan_new_nm = lacsUserNm;
							}
// 2021/06/08 期日別予定表 当期分のみ出力対応 START
							// 当期のみ出力
							if (bToukiTukiFlg) {
								batchError = "batch0064";

								kijitusisanmodelNew.setAcStd("1");
								// kijitusisanmodelNew.setModelBase(this);
								kijitusisanmodelNew.getData(piReportBean);

								pageCount = 0;

								if (piReportBean.getDataMax() > 0) {

									batchError = "batch0065";
									kijitusisanmodelNew.makePDF(piReportBean, dateMode, context);
									outputCount++;
									// pageCount = kijitusisanmodelNew.getBatchPrintedPage;
								}

								piReportBean.clearList();
							}
// 2021/06/08 期日別予定表 当期分のみ出力対応 END
							// CVSデータ出力
//							if (bToukiTukiFlg) {
//								reportCVS.setCell(ReportCVS.CVS_CELL_KIJITU_SISAN_NEW_TOUKI, String.valueOf(pageCount));
//							} else {
//								reportCVS.setCell(ReportCVS.CVS_CELL_KIJITU_SISAN_NEW_TUKI, String.valueOf(pageCount));
//							}
						}
// 2020/05/22 ADD END   LACS帳票バッチ出力

// 2020/05/22 DEL START LACS帳票バッチ出力
//						if ( !bToukiTukiFlg ) {
//							if ( outputCount > 0) {
//								LACSReportAtesakiBean atesakiBean  = new LACSReportAtesakiBean();
//								atesakiBean.setLeaseCompanyNm(lacsUserNm);
//								atesakiBean.setTantosyaName(luTantoNm);
//								atesakiBean.setLeaseCompanyZipCd(leaseCompanyZipCd);
//								atesakiBean.setLeaseCompanyAddr1(leaseCompanyAddr1);
//								atesakiBean.setLeaseCompanyAddr2(leaseCompanyAddr2);
//								atesakiList.add(atesakiBean);
//								
//								// CVSデータ出力
//								reportCVS.setCell(ReportCVS.CVS_CELL_ATESAKI, String.valueOf(1));
//							}
//						}
// 2020/05/22 DEL END   LACS帳票バッチ出力
					} catch (Exception ex) {
						ex.printStackTrace();
						errorFlg = true;
						throw new IllegalOperationException();
					}
					// 2020/05/22 DEL END LACS帳票バッチ出力

				} // 開示先Forの終了

				if (piReportBean.getLeasCompany().size() > 0) {

					batchError = "batch0026";

					// 注記書類作成基準書PDFを作成
					tywmodel.endReport();
					fileName = tywmodel.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
						// 2020/05/22 REP START LACS帳票バッチ出力
								renameTo(new File(pdffilepath + "/" + "01_注記書類作成基準書_" + shrym + "_" + key_tyuki_cd + "_"
										+ key_tyuki_nm + ".pdf"));
						// 2020/05/22 REP END LACS帳票バッチ出力
					}

					batchError = "batch0027";

					// リース契約注記合計表【旧】PDFを作成
					gowmodelOld.endReport();
					fileName = gowmodelOld.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
						// 2020/05/22 REP START LACS帳票バッチ出力
						// renameTo(new File(pdffilepath + "/" + "リース契約注記合計表【旧】_" + shrym + ".pdf"));
								renameTo(new File(pdffilepath + "/" + "06_リース契約注記合計表【旧】_" + shrym + "_"
										+ key_goukei_old_cd + "_" + key_goukei_old_nm + ".pdf"));
						// 2020/05/22 REP END LACS帳票バッチ出力
					}

					batchError = "batch0028";

					// リース契約注記合計表【新】PDFを作成
					gowmodelNew.endReport();
					fileName = gowmodelNew.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
						// 2020/05/22 REP START LACS帳票バッチ出力
						// renameTo(new File(pdffilepath + "/" + "リース契約注記合計表【新】_" + shrym + ".pdf"));
								renameTo(new File(pdffilepath + "/" + "06_リース契約注記合計表【新】_" + shrym + "_"
										+ key_goukei_new_cd + "_" + key_goukei_new_nm + ".pdf"));
						// 2020/05/22 REP END LACS帳票バッチ出力
					}

					batchError = "batch0029";

					// 受払合計表PDFを作成
					ukemodel.endReport();
					fileName = ukemodel.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
						// 2020/05/22 REP START LACS帳票バッチ出力
						// renameTo(new File(pdffilepath + "/" + "受払合計表_" + shrym + ".pdf"));
								renameTo(new File(pdffilepath + "/" + "03_受払合計表_" + shrym + "_" + key_ukebarai_cd + "_"
										+ key_ukebarai_nm + ".pdf"));
						// 2020/05/22 REP END LACS帳票バッチ出力
					}

					// 2020/05/22 ADD START LACS帳票バッチ出力
					// 仕訳合計表PDFを作成
					batchError = "batch0070";
					siwakemodel.endReport();
					fileName = siwakemodel.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
						// 2020/05/22 REP START LACS帳票バッチ出力
						// renameTo(new File(pdffilepath + "/" + "仕訳合計表_" + shrym + ".pdf"));
								renameTo(new File(pdffilepath + "/" + "02_仕訳合計表_" + shrym + "_" + key_siwake_cd + "_"
										+ key_siwake_nm + ".pdf"));
						// 2020/05/22 REP END LACS帳票バッチ出力
					}
					// 2020/05/22 ADD END LACS帳票バッチ出力
					// 2020/05/22 ADD START LACS帳票バッチ出力
					// リース資産受払明細表PDFを作成
					batchError = "batch0071";
					sisanukemodel.endReport();
					fileName = sisanukemodel.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
						// 2020/05/22 REP START LACS帳票バッチ出力
						// renameTo(new File(pdffilepath + "/" + "リース資産受払明細表_" + shrym + ".pdf"));
								renameTo(new File(pdffilepath + "/" + "05_リース資産受払明細表_" + shrym + "_" + key_sisan_uke_cd
										+ "_" + key_sisan_uke_nm + ".pdf"));
						// 2020/05/22 REP END LACS帳票バッチ出力
					}
					// 2020/05/22 ADD END LACS帳票バッチ出力
					// 2020/05/22 ADD START LACS帳票バッチ出力
					// リース料受払明細表PDFを作成
					batchError = "batch0072";
					leasukemodel.endReport();
					fileName = leasukemodel.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
						// 2020/05/22 REP START LACS帳票バッチ出力
						// renameTo(new File(pdffilepath + "/" + "リース料受払明細表_" + shrym + ".pdf"));
								renameTo(new File(pdffilepath + "/" + "04_リース料受払明細表_" + shrym + "_" + key_leas_uke_cd
										+ "_" + key_leas_uke_nm + ".pdf"));
						// 2020/05/22 REP END LACS帳票バッチ出力
					}
					// 2020/05/22 ADD END LACS帳票バッチ出力
					// 2020/05/22 ADD START LACS帳票バッチ出力
					// 支払リース料【旧】PDFを作成
					batchError = "batch0073";
					siharaimodelOld.endReport();
					fileName = siharaimodelOld.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
						// 2020/05/22 REP START LACS帳票バッチ出力
						// renameTo(new File(pdffilepath + "/" + "リース会計資料(支払リース料等)【旧】_" + shrym +
						// ".pdf"));
								renameTo(new File(pdffilepath + "/" + "07_リース会計資料(支払リース料等)【旧】_" + shrym + "_"
										+ key_siharai_old_cd + "_" + key_siharai_old_nm + ".pdf"));
						// 2020/05/22 REP END LACS帳票バッチ出力
					}
					// 2020/05/22 ADD END LACS帳票バッチ出力
					// 2020/05/22 ADD START LACS帳票バッチ出力
					// 支払リース料【新】PDFを作成
					batchError = "batch0074";
					siharaimodelNew.endReport();
					fileName = siharaimodelNew.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
						// 2020/05/22 REP START LACS帳票バッチ出力
						// renameTo(new File(pdffilepath + "/" + "リース会計資料(支払リース料等)【新】_" + shrym +
						// ".pdf"));
								renameTo(new File(pdffilepath + "/" + "07_リース会計資料(支払リース料等)【新】_" + shrym + "_"
										+ key_siharai_new_cd + "_" + key_siharai_new_nm + ".pdf"));
						// 2020/05/22 REP END LACS帳票バッチ出力
					}
					// 2020/05/22 ADD END LACS帳票バッチ出力
					// 2020/05/22 ADD START LACS帳票バッチ出力
					// 減価償却費【旧】PDFを作成
					batchError = "batch0075";
					genkamodelOld.endReport();
					fileName = genkamodelOld.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
						// 2020/05/22 REP START LACS帳票バッチ出力
						// renameTo(new File(pdffilepath + "/" + "リース会計資料(減価償却費)【旧】_" + shrym +
						// ".pdf"));
								renameTo(new File(pdffilepath + "/" + "08_リース会計資料(減価償却費)【旧】_" + shrym + "_"
										+ key_genka_old_cd + "_" + key_genka_old_nm + ".pdf"));
						// 2020/05/22 REP END LACS帳票バッチ出力
					}
					// 2020/05/22 ADD END LACS帳票バッチ出力
					// 2020/05/22 ADD START LACS帳票バッチ出力
					// 減価償却費【新】PDFを作成
					batchError = "batch0076";
					genkamodelNew.endReport();
					fileName = genkamodelNew.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
						// 2020/05/22 REP START LACS帳票バッチ出力
						// renameTo(new File(pdffilepath + "/" + "リース会計資料(減価償却費)【新】_" + shrym +
						// ".pdf"));
								renameTo(new File(pdffilepath + "/" + "08_リース会計資料(減価償却費)【新】_" + shrym + "_"
										+ key_genka_new_cd + "_" + key_genka_new_nm + ".pdf"));
						// 2020/05/22 REP END LACS帳票バッチ出力
					}
					// 2020/05/22 ADD END LACS帳票バッチ出力

					// 2020/05/22 ADD START LACS帳票バッチ出力
//					// 期日別予定表(合計表)【旧】PDFを作成
					batchError = "batch0077";
					kijitugoukeimodelOld.endReport();
					fileName = kijitugoukeimodelOld.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName)
								.renameTo(new File(pdffilepath + "/" + "09_期日別予定表(合計表)【旧】_" + shrym + "_"
										+ key_kijitu_goukei_old_cd + "_" + key_kijitu_goukei_old_nm + ".pdf"));
					}
// 2020/05/22 ADD END   LACS帳票バッチ出力
// 2020/05/22 ADD START LACS帳票バッチ出力
//					// 期日別予定表(合計表)【新】PDFを作成
					batchError = "batch0078";
					kijitugoukeimodelNew.endReport();
					fileName = kijitugoukeimodelNew.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName)
								.renameTo(new File(pdffilepath + "/" + "09_期日別予定表(合計表)【新】_" + shrym + "_"
										+ key_kijitu_goukei_new_cd + "_" + key_kijitu_goukei_new_nm + ".pdf"));
					}
// 2020/05/22 ADD END   LACS帳票バッチ出力
// 2020/05/22 ADD START LACS帳票バッチ出力
					// 期日別予定表(債務)【旧】PDFを作成
					batchError = "batch0079";
					kijitusaimmodelOld.endReport();
					fileName = kijitusaimmodelOld.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName)
								.renameTo(new File(pdffilepath + "/" + "10_期日別予定表(債務)【旧】_" + shrym + "_"
										+ key_kijitu_saim_old_cd + "_" + key_kijitu_saim_old_nm + ".pdf"));
					}
// 2020/05/22 ADD END   LACS帳票バッチ出力
// 2020/05/22 ADD START LACS帳票バッチ出力
					// 期日別予定表(債務)【新】PDFを作成
					batchError = "batch0080";
					kijitusaimmodelNew.endReport();
					fileName = kijitusaimmodelNew.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName)
								.renameTo(new File(pdffilepath + "/" + "10_期日別予定表(債務)【新】_" + shrym + "_"
										+ key_kijitu_saim_new_cd + "_" + key_kijitu_saim_new_nm + ".pdf"));
					}
// 2020/05/22 ADD END   LACS帳票バッチ出力
// 2020/05/22 ADD START LACS帳票バッチ出力
					// 期日別予定表(資産)【旧】PDFを作成
					batchError = "batch0081";
					kijitusisanmodelOld.endReport();
					fileName = kijitusisanmodelOld.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName)
								.renameTo(new File(pdffilepath + "/" + "11_期日別予定表(資産)【旧】_" + shrym + "_"
										+ key_kijitu_sisan_old_cd + "_" + key_kijitu_sisan_old_nm + ".pdf"));
					}
// 2020/05/22 ADD END   LACS帳票バッチ出力
// 2020/05/22 ADD START LACS帳票バッチ出力
					// 期日別予定表(資産)【新】PDFを作成
					batchError = "batch0082";
					kijitusisanmodelNew.endReport();
					fileName = kijitusisanmodelNew.getFileName();

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName)
								.renameTo(new File(pdffilepath + "/" + "11_期日別予定表(資産)【新】_" + shrym + "_"
										+ key_kijitu_sisan_new_cd + "_" + key_kijitu_sisan_new_nm + ".pdf"));
					}
// 2020/05/22 ADD END   LACS帳票バッチ出力

// 2020/05/22 DEL START LACS帳票バッチ出力				
//					batchError = "batch0030";
//
//					// リース会計基準明細書PDFを作成
//					kaimodel.endReport();
//					List<String> batchPdfFiles = kaimodel.getBatchOutPDFFiles();
//					
//					for (int i = 0; i < batchPdfFiles.size(); i++) {
//						fileName = batchPdfFiles.get(i);
//						
//						//　ファイルのコピーを行う
//						if (!fileName.trim().equals("")) {
//							new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
//							renameTo(new File(pdffilepath + "/" + "リース会計基準明細書_" + shrym + "_" + StringUtl.formatNumber(i+1, "00") + ".pdf"));  
//						}
//					}
					// 2020/05/22 DEL END LACS帳票バッチ出力

					batchError = "batch0031";

					// 出力された各帳票のリストのCSVファイル作成
					cvsmodel = new LACSReportCSVPrintBatchWriter(super.getCommonBean(), this, super.con);
					fileName = cvsmodel.makeCsv(reportCVS.getData(), shrym, context);

					// ファイルを移動する
					if (!fileName.trim().equals("")) {
						new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName)
								.renameTo(new File(pdffilepath + "/" + fileName));
					}

//					batchError = "batch0032";

					// 2020/05/22 DEL START LACS帳票バッチ出力
					// 宛先PDFを作成
//					if (atesakiList.size() > 0) {
//						
//						piReportBean.clearList();
//						
//						for ( int i = 0; i < atesakiList.size(); i++ ) {
//							piReportBean.addAtesakiBean(atesakiList.get(i));
//						}
//						
//						fileName = atemodel.makePDF(piReportBean, "", context);
//						
//						// ファイルを移動する
//						if (!fileName.trim().equals("")) {
//							new File(context.getRealPath(SCRATCH_PATH) + "/" + fileName).
//					        renameTo(new File(pdffilepath + "/" + "/" + "宛名_" + shrym + ".pdf"));
//						}
//					}
					// 2020/05/22 DEL END LACS帳票バッチ出力
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				errorFlg = true;
				throw new IllegalOperationException();
			}

		} catch (IllegalOperationException ex) {
			ex.printStackTrace();
			errorFlg = true;
		} finally {

			boolean errorInZipoutFlg = false;

			// 出力なし、もしくわエラーが発生した場合
			// MODIFY LIU.ZJ LACS帳票バッチ_開示先メンテナンス画面の改修 2013/05/28 start
			// if (errorFlg || outputCountAll < 1) {
			if (errorFlg || piReportBean.getLeasCompany().size() < 1) {
				// MODIFY LIU.ZJ LACS帳票バッチ_開示先メンテナンス画面の改修 2013/05/28 end

				FileUtil.delfile(new File(pdffilepath));
				new File(pdffilepath).mkdirs();

				FileOutputStream fout = null;

				try {

					String fn = errorFlg ? "error.txt" : "zero.txt";
					File ferr = new File(pdffilepath + "/" + fn);

					fout = new FileOutputStream(ferr);

					if (errorFlg) {

						String msg = batchprop.getProperty(batchError);

						fout.write((batchError + ": " + msg).getBytes());
					} else {
						fout.write("出力は一件も有りませんてした。".getBytes());
					}

				} catch (Exception ex) {
					errorInZipoutFlg = true;
					ex.printStackTrace();

				} finally {
					if (null != fout) {
						fout.close();
					}
				}
			}

			// まとめ後のPDF出力ホルダ中の全てのファイルをZIPに変換する
			file = new File(pdffilepath + ".zip");

			try {

				zio = new LACSZipIO(new File(pdffilepath));
				zio.archive();

				b = new byte[(int) file.length()];

				FileInputStream reader = null;

				try {

					reader = new FileInputStream(file);
					for (int i = 0; i < b.length; i++) {
						b[i] = (byte) reader.read();
					}
				} catch (Exception e) {
					e.printStackTrace();
					errorInZipoutFlg = true;
				} finally {

					try {

						if (reader != null) {
							reader.close();
						}

						file.delete();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			} catch (Exception e3) {
				e3.printStackTrace();
				errorInZipoutFlg = true;
			}

			// レスポンスに出力する
			if (!errorInZipoutFlg) {

				super.setResponseData(b, file.getName());

			} else {

				super.setResponseData(zeroB, file.getName());
			}

			try {

				// ZIP圧縮前ファイルの削除
				FileUtil.delfile(new File(pdffilepath));
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piReportBean 帳票出力Bean
	 * @exception SQLException SQL実行例外
	 */
	protected void initSub(LACSReportBean piReportBean) throws SQLException {
		super.getCommonBean().setDateMode(LACSDefine.DateMode.SEIREKI);
		LACSReportCommon.getInput(super.getCommonBean(), this.con, piReportBean, this,
				LACSReportCommon.TIMING_PRINT_PDF);
		LACSCommonBean commonBean = super.getCommonBean();
		LACSDispControlCommon dispControlCommon = new LACSDispControlCommon(commonBean.getDispControl(), this,
				this.con);

		commonBean.setDateMode(LACSDefine.DateMode.SEIREKI);
		commonBean.setLoginUserId("");
		commonBean.getEnableUserList().add(LACSDefine.INFO_ALL);
		commonBean.setShowKaiKnoOpt(true);
		
		dispControlCommon.getDBDispControl(LACSDefine.INFO_ALL, 1);

		LACSReportBean reportBean = super.getReportBean();
		reportBean.setOldACCount(1);
		reportBean.setNewACCount(1);

		LACSUserLeasCompanyBatchEntity userLeasCompanyEntity = new LACSUserLeasCompanyBatchEntity(this);
		userLeasCompanyEntity.setCon(super.con);
		userLeasCompanyEntity.setShowAll(true);
		userLeasCompanyEntity.execSQL();

		reportBean.getLeasCompany().clear();

		while (userLeasCompanyEntity.next()) {
			reportBean.getLeasCompany()
					.add(new ComboValue(userLeasCompanyEntity.getUserName(), userLeasCompanyEntity.getCosmosCode()));
		}

		userLeasCompanyEntity.close();

	}

	/**
	 * 入力チェック.
	 * 
	 * @param piCommonBean 共通Bean
	 * @param piReportBean 帳票出力Bean
	 * @param piMessage    メッセージ
	 * @return チェック結果
	 * @throws SQLException SQL実行例外
	 */
	private boolean checkInput(LACSCommonBean piCommonBean, LACSReportBean piReportBean, LACSMessage piMessage)
			throws SQLException {
		return LACSReportCommon.checkInput(piCommonBean, con, this, piReportBean, piMessage,
				LACSReportCommon.TIMING_PRINT_PDF);
	}

	/**
	 * 過去のPDFファイルを削除する.
	 * 
	 * @param piContext コンテキスト
	 * @throws Exception 例外発生時.
	 */
	private void deletePDF(ServletContext piContext) throws Exception {
		File dir = new File(piContext.getRealPath(SCRATCH_PATH));
		String[] fnames = dir.list();
		File file = null;
		long modTime = 0;
		Date date = DateUtl.add(Calendar.MONTH, -1, new Date());

		for (int i = 0; i < fnames.length; i++) {
			try {
				file = new File(piContext.getRealPath(SCRATCH_PATH) + "\\" + fnames[i]);
				modTime = file.lastModified(); // 更新日時

				if (new Date(modTime).compareTo(date) < 0) {
					file.delete();
				}
			} catch (Exception ex) {
			}
		}
	}

	/**
	 * セッションチェックフラグ取得.
	 * 
	 * @return セッションチェックを行うか
	 */
	protected boolean isSessionCheck() {
		return false;
	}

	/**
	 * レスポンスのフォワードを阻止する.
	 * 
	 * @return レスポンスのフォワードを阻止するか
	 */
	@Override
	public boolean isResponseSw() {

		return true;
	}

	/**
	 * 契約Noリストを取得
	 * 
	 * @param piKeiyakuBean 物件検索Bean
	 * @throws SQLException SQL実行例外
	 */
	@SuppressWarnings("unused")
	private void getLacsKeiyakuNoList(LACSKeiyakuBean piKeiyakuBean) throws SQLException {
		LACSKeiyakuEntity keiyakuEntity = new LACSKeiyakuEntity(this);
		LACSCommonBean commonBean = super.getCommonBean();
		LACSKeiyakuDetailBean detail = null;

		int from = 0;
		int to = 0;

		try {
			piKeiyakuBean.clearList();

			keiyakuEntity.setBatchFlg(true);

			keiyakuEntity.setCon(super.con);

			keiyakuEntity.setCosmosCode(piKeiyakuBean.getLeasCompany().getValue());

			keiyakuEntity.setEnabledUser(commonBean.getEnableUserList());

			keiyakuEntity.setKeiyakuNo(piKeiyakuBean.getKeiyakuNo());

			keiyakuEntity.setKeiyakuAmt(piKeiyakuBean.getKeiyakuAmt());

			keiyakuEntity.setKeiyakuTerm(piKeiyakuBean.getKeiyakuTerm());
			keiyakuEntity.setKenPatn(piKeiyakuBean.getKenPatn());
			keiyakuEntity.setKeiyakuRls(piKeiyakuBean.getKeiyakuRls());

			keiyakuEntity.setDaihyoBukkenName(piKeiyakuBean.getDaihyoBukkenName());
			keiyakuEntity.setTradeHanteiKekkaCode(piKeiyakuBean.getTradeHanteiKekka().getValue());

			keiyakuEntity.setKenshuFrom(piKeiyakuBean.getKenshuFrom().getYYYYMM());
			keiyakuEntity.setKenshuTo(piKeiyakuBean.getKenshuTo().getYYYYMM());
			keiyakuEntity.setManryoFrom(piKeiyakuBean.getManryoFrom().getYYYYMM());
			keiyakuEntity.setManryoTo(piKeiyakuBean.getManryoTo().getYYYYMM());
			keiyakuEntity.setKaiyakuFrom(piKeiyakuBean.getKaiyakuFrom().getYYYYMM());
			keiyakuEntity.setKaiyakuTo(piKeiyakuBean.getKaiyakuTo().getYYYYMM());

			keiyakuEntity.setFrom(from);
			keiyakuEntity.setTo(to);

			keiyakuEntity.execSQL();

			while (keiyakuEntity.next()) {
				detail = new LACSKeiyakuDetailBean();
				piKeiyakuBean.addDetail(detail);

				detail.setLeasCompanyCode(keiyakuEntity.getLeasCompanyCode());
				detail.setLeasCompanyName(keiyakuEntity.getLeasCompanyName());
				detail.setCosmosCode(keiyakuEntity.getCosmosCode());
				detail.setLeaseUserName(keiyakuEntity.getLeasUserName());
				detail.setKeiyakuNo(keiyakuEntity.getKeiyakuNo());
				detail.setHyoujiKeiyakuNo(keiyakuEntity.getHyoujiKeiyakuNo());
				detail.setTradeHanteiKekkaCode(keiyakuEntity.getTradeHanteiKekkaCode());
				detail.setTradeHanteiKekka(keiyakuEntity.getTradeHanteiKekkaName());
				detail.setKenshuYMD(
						LACSCommand.toDateYYYYMMDD(commonBean, super.con, this, keiyakuEntity.getKenshuYMD()));
				detail.setManryoYMD(
						LACSCommand.toDateYYYYMMDD(commonBean, super.con, this, keiyakuEntity.getManryoYMD()));
				detail.setKaiyakuYMD(
						LACSCommand.toDateYYYYMMDD(commonBean, super.con, this, keiyakuEntity.getKaiyakuYMD()));
				detail.setKeiyakuTerm(keiyakuEntity.getKeiyakuTerm());
				detail.setDaihyouBukkenName(keiyakuEntity.getDaihyoBukkenName());

			}

			piKeiyakuBean.setDataMax(keiyakuEntity.getAllDataCount());
		} finally {
			keiyakuEntity.close();
		}
	}

	/**
	 * データ取得
	 * 
	 * @param piReportBean LACS帳票Bean
	 * @param piNow        基準日
	 * @throws SQLException SQL実行例外
	 */
	public void getUserReporData(LACSReportBean piReportBean, Date piNow) throws SQLException {
		LACSReportUserEntity reportUserEntity = new LACSReportUserEntity(this);

		Date termFrom = null;
		Date now = piNow;

		Calendar calendar = Calendar.getInstance();

		try {
			reportUserEntity.setCon(con);

			reportUserEntity.setLeasCompany(piReportBean.getLeasCompany().getValue());
			reportUserEntity.execSQL();
			if (reportUserEntity.next()) {
				termFrom = Convert.toDate(DateUtl.getYear(now) + reportUserEntity.getKesnKi(), Convert.FORMAT_YYYYMMDD);

				calendar.setTime(now);

				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);

				// MODIFY FU.PL LACS帳票バッチ_開示先メンテナンス画面の改修 2013/05/28 start
				// if (calendar.getTime().compareTo(termFrom) < 0) {
				if (calendar.getTime().compareTo(termFrom) <= 0) {
					// MODIFY FU.PL LACS帳票バッチ_開示先メンテナンス画面の改修 2013/05/28 start
					termFrom = DateUtl.add(Calendar.YEAR, -1, termFrom);
				}

				termFrom = DateUtl.add(Calendar.DAY_OF_MONTH, 1, termFrom);

				if (reportUserEntity.getKesnKi().equals("0228")) {
					calendar.setTime(termFrom);
					calendar.set(Calendar.MONTH, 2);
					calendar.set(Calendar.DAY_OF_MONTH, 1);

					termFrom = calendar.getTime();
				}

				piReportBean.getTermFrom().setDate("", StringUtl.paddingLeft(DateUtl.getYear(termFrom), "0", 4),
						StringUtl.paddingLeft(DateUtl.getMonth(termFrom), "0", 2),
						StringUtl.paddingLeft(DateUtl.getDay(termFrom), "0", 2));
				piReportBean.setOldTyutoKaiyaku(Command.init(reportUserEntity.getOldCytKaiJgiFlg(), "0"));
				piReportBean.setOldSaiLease(Command.init(reportUserEntity.getOldRlsKeiJgiFlg(), "0"));
				piReportBean.setOldKeiyakuGaku(Command.init(reportUserEntity.getOldSgkKeiJgiFlg(), "0"));
				piReportBean.setOldLeaseKikan(Command.init(reportUserEntity.getOldSrtKeiJgiFlg(), "0"));
				piReportBean.setNewTyutoKaiyaku(Command.init(reportUserEntity.getNewCytKaiJgiFlg(), "0"));
				piReportBean.setNewSaiLease(Command.init(reportUserEntity.getNewRlsKeiJgiFlg(), "0"));
				piReportBean.setNewKeiyakuGaku(Command.init(reportUserEntity.getNewSgkKeiJgiFlg(), "0"));
				piReportBean.setNewLeaseKikan(Command.init(reportUserEntity.getNewSrtKeiJgiFlg(), "0"));
				piReportBean.setKaikeiSyori(Command.init(reportUserEntity.getAcShrKbn(), "0"));

				piReportBean.setOldSumUnt(Command.init(reportUserEntity.getOldSumUnit(), "0"));
				piReportBean.setNewSumUnt(Command.init(reportUserEntity.getNewSumUnit(), "1"));

				piReportBean.setNewACCount(reportUserEntity.getNewACCount());
				piReportBean.setOldACCount(reportUserEntity.getOldACCount());

				LACSReportCommon.setTerm(super.getCommonBean(), con, this, piReportBean, termFrom,
						LACSReportCommon.TIMING_USER_CHANGE);
			} else {
				piReportBean.setNewACCount(1);
				piReportBean.setOldACCount(1);
			}
		} finally {
			reportUserEntity.close();
		}
	}

	// 2020/05/22 ADD START LACS帳票バッチ出力
	/**
	 * データ取得.
	 * 
	 * @param piReportBean 月次帳票Bean
	 * @exception SQLException SQL実行例外
	 */
	private void getUserMReporData(LACSMReportBean piReportBean) throws SQLException {
		LACSReportUserEntity reportUserEntity = new LACSReportUserEntity(this);

		Date termFrom = null;
		Date now = new Date();

		Calendar calendar = Calendar.getInstance();

		try {
			reportUserEntity.setCon(super.con);

			reportUserEntity.setLeasCompany(piReportBean.getLeasCompany().getValue());
			reportUserEntity.execSQL();
			if (reportUserEntity.next()) {
				termFrom = Convert.toDate(DateUtl.getYear(now) + reportUserEntity.getKesnKi(), Convert.FORMAT_YYYYMMDD);

				calendar.setTime(now);

				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);

				if (calendar.getTime().compareTo(termFrom) < 0) {
					termFrom = DateUtl.add(Calendar.YEAR, -1, termFrom);
				}

				termFrom = DateUtl.add(Calendar.DAY_OF_MONTH, 1, termFrom);

				if (reportUserEntity.getKesnKi().equals("0228")) {
					calendar.setTime(termFrom);
					calendar.set(Calendar.MONTH, 2);
					calendar.set(Calendar.DAY_OF_MONTH, 1);

					termFrom = calendar.getTime();
				}

				piReportBean.getTermFrom().setDate("", StringUtl.paddingLeft(DateUtl.getYear(termFrom), "0", 4),
						StringUtl.paddingLeft(DateUtl.getMonth(termFrom), "0", 2),
						StringUtl.paddingLeft(DateUtl.getDay(termFrom), "0", 2));
				piReportBean.setGtjTyutoKaiyaku(Command.init(reportUserEntity.getGtjCytKaiJgiFlg(), "0"));
				piReportBean.setGtjSaiLease(Command.init(reportUserEntity.getGtjRlsKeiJgiFlg(), "0"));
				piReportBean.setGtjKeiyakuGaku(Command.init(reportUserEntity.getGtjSgkKeiJgiFlg(), "0"));
				piReportBean.setGtjLeaseKikan(Command.init(reportUserEntity.getGtjSrtKeiJgiFlg(), "0"));

				LACSMReportCommon.setTerm(super.getCommonBean(), this.con, this, piReportBean, termFrom,
						LACSMReportCommon.TIMING_USER_CHANGE);
			}
		} finally {
			reportUserEntity.close();
		}
	}
	// 2020/05/22 ADD END LACS帳票バッチ出力

}
