package jp.co.pro_app.lacs.affairs.ukebarai.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiDetailBean;
import jp.co.pro_app.lacs.affairs.ukebarai.common.LACSUkebaraiCommon;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.Convert;

/**
 * 受払合計表：受払合計表CSV Model.
 * 
 * @author active
 * @version 20080813
 */
public class LACSUkebaraiCSVGokeiWriter extends LACSUkebaraiCSVWriterBase {

	private static final String	LINE_MARK	= "\n";

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
	public LACSUkebaraiCSVGokeiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
	}

	/**
	 * CSV作成.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @param piContext
	 *            ServletContext
	 * @return CSVファイル名
	 * @exception Exception
	 *                実行例外
	 */
	public String makeCSV(LACSUkebaraiBean piUkebaraiBean, ServletContext piContext) throws Exception {
		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		String fileName = "";

		File tmpFile = null; // 出力先ファイル

		try {

			tmpFile = File.createTempFile("csv21_", ".csv", scratchDirectory);

			this.write(tmpFile.getAbsolutePath(), piUkebaraiBean);

			fileName = tmpFile.getName();

		}
		finally {
		}

		return fileName;
	}

	/**
	 * CSVファイルに出力する処理.
	 * 
	 * @param piPath
	 *            書き出すファイル名
	 * @param piUkebaraiBean
	 *            受払合計Bean
	 * @throws IOException
	 *             IO例外
	 */
	private void write(String piPath, LACSUkebaraiBean piUkebaraiBean) throws IOException {

		BufferedWriter writer = null;
		StringBuffer buf = new StringBuffer();

		// 2020/05/22 REP START
		//String[] comHeaderData = new String[]{ "作成日", "対象期間開始", "対象期間終了", "リース会社", "開示先", "リース会計基準コード", "リース会計基準", "リース取引分類コード", "リース取引分類名称", "会計処理方法コード", "会計処理方法", "項目", "科目名", "前期末", "当期増加", "当期", "当期減少", "当期末" };
		String[] comHeaderData = new String[]{ "作成日", "対象期間開始", "対象期間終了", "リース会社", "開示先", "重要性有無", "リース会計基準コード", "リース会計基準", "リース取引分類コード", "リース取引分類名称", "会計処理方法コード", "会計処理方法", "項目", "科目名", "前期末", "当期増加", "当期", "当期減少", "当期末" };
		// 2020/05/22 REP END

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(piPath, true), "windows-31j"));
			buf.append(writeHeader(comHeaderData));
			buf.append(LINE_MARK);

			// 2020/05/22 REP START
//			if ("0".equals(piUkebaraiBean.getOldBaibaiItenFlg())) {
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getOldBaibaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "0", "旧リース会計基準", "1", "所有権移転ファイナンスリース", "0", "売買処理", "ＢＳ科目残高推移"));
//
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getOldBaibaiItenList(), LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, "0", "旧リース会計基準", "1", "所有権移転ファイナンスリース", "0", "売買処理", "ＰＬ科目累計額推移"));
//			}
//			if ("0".equals(piUkebaraiBean.getOldTintaiItenFlg())) {
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getOldTintaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "0", "旧リース会計基準", "1", "所有権移転ファイナンスリース", "1", "賃貸借処理", "ＢＳ科目残高推移"));
//
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getOldTintaiItenList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "0", "旧リース会計基準", "1", "所有権移転ファイナンスリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
//			}
//			if ("0".equals(piUkebaraiBean.getOldBaibaiItengaiFlg())) {
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getOldBaibaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "0", "旧リース会計基準", "2", "所有権移転外ファイナンスリース", "0", "売買処理", "ＢＳ科目残高推移"));
//
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getOldBaibaiItengaiList(), LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, "0", "旧リース会計基準", "2", "所有権移転外ファイナンスリース", "0", "売買処理", "ＰＬ科目累計額推移"));
//			}
//			if ("0".equals(piUkebaraiBean.getOldTintaiItengaiFlg())) {
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getOldTintaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "0", "旧リース会計基準", "2", "所有権移転外ファイナンスリース", "1", "賃貸借処理", "ＢＳ科目残高推移"));
//
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getOldTintaiItengaiList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "0", "旧リース会計基準", "2", "所有権移転外ファイナンスリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
//			}
//			if ("0".equals(piUkebaraiBean.getOldOperateFlg())) {
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getOldOperateList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "0", "旧リース会計基準", "3", "オペレーティングリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
//			}
//			if ("0".equals(piUkebaraiBean.getNewBaibaiItenFlg())) {
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getNewBaibaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "1", "新リース会計基準", "1", "所有権移転ファイナンスリース", "0", "売買処理", "ＢＳ科目残高推移"));
//
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getNewBaibaiItenList(), LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, "1", "新リース会計基準", "1", "所有権移転ファイナンスリース", "0", "売買処理", "ＰＬ科目累計額推移"));
//			}
//			if ("0".equals(piUkebaraiBean.getNewTintaiItenFlg())) {
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getNewTintaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "1", "新リース会計基準", "1", "所有権移転ファイナンスリース", "1", "賃貸借処理", "ＢＳ科目残高推移"));
//
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getNewTintaiItenList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "1", "新リース会計基準", "1", "所有権移転ファイナンスリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
//			}
//			if ("0".equals(piUkebaraiBean.getNewBaibaiItengaiFlg())) {
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getNewBaibaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "1", "新リース会計基準", "2", "所有権移転外ファイナンスリース", "0", "売買処理", "ＢＳ科目残高推移"));
//
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getNewBaibaiItengaiList(), LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, "1", "新リース会計基準", "2", "所有権移転外ファイナンスリース", "0", "売買処理", "ＰＬ科目累計額推移"));
//			}
//			if ("0".equals(piUkebaraiBean.getNewTintaiItengaiFlg())) {
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getNewTintaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "1", "新リース会計基準", "2", "所有権移転外ファイナンスリース", "1", "賃貸借処理", "ＢＳ科目残高推移"));
//
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getNewTintaiItengaiList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "1", "新リース会計基準", "2", "所有権移転外ファイナンスリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
//			}
//			if ("0".equals(piUkebaraiBean.getNewOperateFlg())) {
//				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getNewOperateList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "1", "新リース会計基準", "3", "オペレーティングリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
//			}
			//
			// 重要性無
			if ("0".equals(piUkebaraiBean.getJyNOldBaibaiItenFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNOldBaibaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "なし", "0", "旧リース会計基準", "1", "所有権移転ファイナンスリース", "0", "売買処理", "ＢＳ科目残高推移"));

				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNOldBaibaiItenList(), LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, "なし", "0", "旧リース会計基準", "1", "所有権移転ファイナンスリース", "0", "売買処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyNOldTintaiItenFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNOldTintaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "なし", "0", "旧リース会計基準", "1", "所有権移転ファイナンスリース", "1", "賃貸借処理", "ＢＳ科目残高推移"));

				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNOldTintaiItenList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "なし", "0", "旧リース会計基準", "1", "所有権移転ファイナンスリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyNOldBaibaiItengaiFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNOldBaibaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "なし", "0", "旧リース会計基準", "2", "所有権移転外ファイナンスリース", "0", "売買処理", "ＢＳ科目残高推移"));

				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNOldBaibaiItengaiList(), LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, "なし", "0", "旧リース会計基準", "2", "所有権移転外ファイナンスリース", "0", "売買処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyNOldTintaiItengaiFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNOldTintaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "なし", "0", "旧リース会計基準", "2", "所有権移転外ファイナンスリース", "1", "賃貸借処理", "ＢＳ科目残高推移"));

				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNOldTintaiItengaiList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "なし", "0", "旧リース会計基準", "2", "所有権移転外ファイナンスリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyNOldOperateFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNOldOperateList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "なし", "0", "旧リース会計基準", "3", "オペレーティングリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyNNewBaibaiItenFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNNewBaibaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "なし", "1", "新リース会計基準", "1", "所有権移転ファイナンスリース", "0", "売買処理", "ＢＳ科目残高推移"));

				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNNewBaibaiItenList(), LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, "なし", "1", "新リース会計基準", "1", "所有権移転ファイナンスリース", "0", "売買処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyNNewTintaiItenFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNNewTintaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "なし", "1", "新リース会計基準", "1", "所有権移転ファイナンスリース", "1", "賃貸借処理", "ＢＳ科目残高推移"));

				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNNewTintaiItenList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "なし", "1", "新リース会計基準", "1", "所有権移転ファイナンスリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyNNewBaibaiItengaiFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNNewBaibaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "なし", "1", "新リース会計基準", "2", "所有権移転外ファイナンスリース", "0", "売買処理", "ＢＳ科目残高推移"));

				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNNewBaibaiItengaiList(), LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, "なし", "1", "新リース会計基準", "2", "所有権移転外ファイナンスリース", "0", "売買処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyNNewTintaiItengaiFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNNewTintaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "なし", "1", "新リース会計基準", "2", "所有権移転外ファイナンスリース", "1", "賃貸借処理", "ＢＳ科目残高推移"));

				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNNewTintaiItengaiList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "なし", "1", "新リース会計基準", "2", "所有権移転外ファイナンスリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyNNewOperateFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyNNewOperateList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "なし", "1", "新リース会計基準", "3", "オペレーティングリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
			}
			//
			// 重要性有
			if ("0".equals(piUkebaraiBean.getJyAOldBaibaiItenFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyAOldBaibaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "あり", "0", "旧リース会計基準", "1", "所有権移転ファイナンスリース", "0", "売買処理", "ＢＳ科目残高推移"));

				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyAOldBaibaiItenList(), LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, "あり", "0", "旧リース会計基準", "1", "所有権移転ファイナンスリース", "0", "売買処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyAOldTintaiItenFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyAOldTintaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "あり", "0", "旧リース会計基準", "1", "所有権移転ファイナンスリース", "1", "賃貸借処理", "ＢＳ科目残高推移"));

				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyAOldTintaiItenList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "あり", "0", "旧リース会計基準", "1", "所有権移転ファイナンスリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyAOldBaibaiItengaiFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyAOldBaibaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "あり", "0", "旧リース会計基準", "2", "所有権移転外ファイナンスリース", "0", "売買処理", "ＢＳ科目残高推移"));

				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyAOldBaibaiItengaiList(), LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, "あり", "0", "旧リース会計基準", "2", "所有権移転外ファイナンスリース", "0", "売買処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyAOldTintaiItengaiFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyAOldTintaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "あり", "0", "旧リース会計基準", "2", "所有権移転外ファイナンスリース", "1", "賃貸借処理", "ＢＳ科目残高推移"));

				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyAOldTintaiItengaiList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "あり", "0", "旧リース会計基準", "2", "所有権移転外ファイナンスリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyAOldOperateFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyAOldOperateList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "あり", "0", "旧リース会計基準", "3", "オペレーティングリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyANewBaibaiItenFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyANewBaibaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "あり", "1", "新リース会計基準", "1", "所有権移転ファイナンスリース", "0", "売買処理", "ＢＳ科目残高推移"));

				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyANewBaibaiItenList(), LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, "あり", "1", "新リース会計基準", "1", "所有権移転ファイナンスリース", "0", "売買処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyANewTintaiItenFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyANewTintaiItenList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "あり", "1", "新リース会計基準", "1", "所有権移転ファイナンスリース", "1", "賃貸借処理", "ＢＳ科目残高推移"));

				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyANewTintaiItenList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "あり", "1", "新リース会計基準", "1", "所有権移転ファイナンスリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyANewBaibaiItengaiFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyANewBaibaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "あり", "1", "新リース会計基準", "2", "所有権移転外ファイナンスリース", "0", "売買処理", "ＢＳ科目残高推移"));

				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyANewBaibaiItengaiList(), LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT, "あり", "1", "新リース会計基準", "2", "所有権移転外ファイナンスリース", "0", "売買処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyANewTintaiItengaiFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyANewTintaiItengaiList(), 0, LACSUkebaraiCommon.BS_LIST_COUNT, "あり", "1", "新リース会計基準", "2", "所有権移転外ファイナンスリース", "1", "賃貸借処理", "ＢＳ科目残高推移"));

				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyANewTintaiItengaiList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "あり", "1", "新リース会計基準", "2", "所有権移転外ファイナンスリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
			}
			if ("0".equals(piUkebaraiBean.getJyANewOperateFlg())) {
				buf.append(getListDetail(piUkebaraiBean, piUkebaraiBean.getJyANewOperateList(), LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT, "あり", "1", "新リース会計基準", "3", "オペレーティングリース", "1", "賃貸借処理", "ＰＬ科目累計額推移"));
			}
			// 2020/05/22 REP END
			writer.write(buf.toString() + "\n");

		}
		catch (IOException e) {
			throw e;
		}
		finally {
			writer.close();
		}

	}

	/**
	 * 検索条件等、科目名の前までを明細行に設定する.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
// 2020/05/22 ADD START
	 * @param piJysiUm
	 *            重要性有無
// 2020/05/22 ADD END
	 * @param piKijunCd
	 *            対象会計基準コード
	 * @param piKijun
	 *            対象会計基準
	 * @param piBunruiCd
	 *            償却分類コード
	 * @param piBunrui
	 *            償却分類
	 * @param piHouhouCd
	 *            計上方法区分コード
	 * @param piHouhou
	 *            計上方法区分
	 * @param piKoumoku
	 *            項目名（BS科目残高推移、PL課目累計額推移、賃貸借処理）
	 * @return StringBuffer 出力行
	 */
	private StringBuffer getCommonDetailData(LACSUkebaraiBean piUkebaraiBean, String piJysiUm, String piKijunCd, String piKijun, String piBunruiCd, String piBunrui, String piHouhouCd, String piHouhou, String piKoumoku) {

		String bknNo = piUkebaraiBean.getBukkenNo();
		if (piUkebaraiBean.getBukkenEdaNo().trim().length() > 0) {
			bknNo = bknNo + "-" + piUkebaraiBean.getBukkenEdaNo();
		}

		String[] ret = new String[]{

		Convert.toString(new Date(), Convert.FORMAT_YYYYMMDD)

		, piUkebaraiBean.getTermFrom().getYYYYMMDD()

		, piUkebaraiBean.getTermTo().getYYYYMMDD()

		, piUkebaraiBean.getLcName()

		, piUkebaraiBean.getLeaseUserNm()

		// 2020/05/22 ADD START
		,piJysiUm
		// 2020/05/22 ADD END
		
		, piKijunCd, piKijun

		, piBunruiCd, piBunrui

		, piHouhouCd, piHouhou

		, piKoumoku, };

		return spreadArg(ret);
	}

	/**
	 * DB取得項目を出力形式に設定する.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @param piDetailList
	 *            明細
	 * @param piStartIdx
	 *            リスト出力開始行
	 * @param piBreakIdx
	 *            リスト出力終了行
// 2020/05/22 ADD START
	 * @param piJysiUm
	 *            重要性有無
// 2020/05/22 ADD END
	 * @param piKijunCd
	 *            対象会計基準コード
	 * @param piKijun
	 *            対象会計基準
	 * @param piBunruiCd
	 *            償却分類コード
	 * @param piBunrui
	 *            償却分類
	 * @param piHouhouCd
	 *            計上方法コード
	 * @param piHouhou
	 *            計上方法
	 * @param piKoumoku
	 *            項目名
	 * @return StringBuffer 明細
	 */
	// 2020/05/22 REP START
	//private StringBuffer getListDetail(LACSUkebaraiBean piUkebaraiBean, ArrayList<Object> piDetailList, int piStartIdx, int piBreakIdx, String piKijunCd, String piKijun, String piBunruiCd, String piBunrui, String piHouhouCd, String piHouhou, String piKoumoku) {
	private StringBuffer getListDetail(LACSUkebaraiBean piUkebaraiBean, ArrayList<Object> piDetailList, int piStartIdx, int piBreakIdx, String piJysiUm, String piKijunCd, String piKijun, String piBunruiCd, String piBunrui, String piHouhouCd, String piHouhou, String piKoumoku) {
	// 2020/05/22 REP END
		StringBuffer buf = new StringBuffer();

		// 2020/05/22 REP START
		//StringBuffer comBuf = getCommonDetailData(piUkebaraiBean, piKijunCd, piKijun, piBunruiCd, piBunrui, piHouhouCd, piHouhou, piKoumoku);
		StringBuffer comBuf = getCommonDetailData(piUkebaraiBean, piJysiUm, piKijunCd, piKijun, piBunruiCd, piBunrui, piHouhouCd, piHouhou, piKoumoku);
		// 2020/05/22 REP END

		LACSUkebaraiDetailBean bean = null;
		for (int i = piStartIdx; i < piDetailList.size(); i++) {

			if (i == piBreakIdx) {
				break;
			}

			buf.append(comBuf);
			buf.append(",");

			bean = (LACSUkebaraiDetailBean)piDetailList.get(i);
			buf.append(appendComma(bean.getKamokuNm()));

			if (bean.isZenFlag()) {
				buf.append(appendComma(String.valueOf(bean.getZenCost())));
			}
			else {
				buf.append("\"\",");
			}

			if (bean.isTouzouFlag()) {
				buf.append(appendComma(String.valueOf(bean.getTouzouCost())));
			}
			else {
				buf.append("\"\",");
			}

			if (bean.isToujitFlag()) {
				buf.append(appendComma(String.valueOf(bean.getToujitCost())));
			}
			else {
				buf.append("\"\",");
			}

			if (bean.isTougenFlag()) {
				buf.append(appendComma(String.valueOf(bean.getTougenCost())));
			}
			else {
				buf.append("\"\",");
			}

			if (bean.isTouzanFlag()) {
				buf.append(Command.changeDBtoWin(String.valueOf(bean.getTouzanCost())));
			}
			else {
				buf.append("\"\",");
			}

			buf.append(LINE_MARK);

		}

		return buf;
	}

	/**
	 * 項目のタイトルを設定する.
	 * 
	 * @param piCom
	 *            タイトル
	 * @return StringBuffer タイトル行
	 */
	private StringBuffer writeHeader(String[] piCom) {

		StringBuffer buf = new StringBuffer();

		buf.append(spreadArg(piCom));

		return buf;
	}

	/**
	 * 配列を展開してカンマ区切りに設定する. データはダブルクォートでくくる
	 * 
	 * @param piArg
	 *            展開する配列
	 * @return StringBuffer カンマで区切られた１行
	 */
	private StringBuffer spreadArg(String[] piArg) {

		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < piArg.length; i++) {
			if (i > 0) {
				buf.append(",");
			}

			buf.append("\"" + Command.changeDBtoWin(piArg[i]) + "\"");
		}

		return buf;
	}

	/**
	 * ダブルクォートでデータを囲ってカンマをつける.
	 * 
	 * @param piData
	 *            データ
	 * @return StringBuffer フォーマットした１行
	 */
	private StringBuffer appendComma(String piData) {

		StringBuffer buf = new StringBuffer();
		buf.append("\"");
		buf.append(Command.changeDBtoWin(piData));
		buf.append("\",");

		return buf;
	}
}
