package jp.co.pro_app.lacs.affairs.ukebarai.model;

import java.io.File;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.affairs.ukebarai.writer.LACSUkebaraiCSVGokeiWriter;
import jp.co.pro_app.lacs.affairs.ukebarai.writer.LACSUkebaraiCSVHiyoWriter;
import jp.co.pro_app.lacs.affairs.ukebarai.writer.LACSUkebaraiCSVLeaseWriter;
import jp.co.pro_app.lacs.affairs.ukebarai.writer.LACSUkebaraiCSVSisanWriter;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 受払合計表：CSV出力処理Model.
 * 
 * @author active
 * @version 20080813
 */
public class LACSUkebaraiCSVPrintModel extends LACSUkebaraiModelBase {

	private static final String	SCRATCH_PATH	= "csv";

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "CSV作成";
	}

	/**
	 * 処理開始ログ出力.
	 * 
	 * @param piPrintBean
	 *            月次帳票出力Bean
	 */
	protected void start(LACSUkebaraiBean piPrintBean) {
		super.getLogger().start(piPrintBean.getLeasCompany());
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSUkebaraiBean piUkebaraiBean) throws Exception {
		LACSCommonBean commonBean = super.getCommonBean();

		if (!checkInputForReport(commonBean, piUkebaraiBean, message)) {
			piUkebaraiBean.setMessage(message.getMessage());
			return;
		}

		piUkebaraiBean.setOutputMode(2);

		boolean outPut = false;
		ServletConfig config = this.getServlet().getServletConfig();
		ServletContext context = config.getServletContext();

		this.deleteCSV(context);

		if (piUkebaraiBean.getGokei().getCheckOutput() == 1) {
			LACSUkebaraiCSVGokeiWriter model = new LACSUkebaraiCSVGokeiWriter(super.getCommonBean(), this, super.con);

			model.getGokeiData(piUkebaraiBean);

			if (piUkebaraiBean.getDataMax() > 0) {

				String fileName = model.makeCSV(piUkebaraiBean, context);

				piUkebaraiBean.getGokei().setFileName(SCRATCH_PATH + "/" + fileName);

				outPut = true; // 出力フラグ
			}

		}

		if (piUkebaraiBean.getSisan().getCheckOutput() == 1) {
			LACSUkebaraiCSVSisanWriter model = new LACSUkebaraiCSVSisanWriter(super.getCommonBean(), this, super.con);

			try {

				String fileName = model.makeCSV(piUkebaraiBean, context);

				piUkebaraiBean.getSisan().setFileName(SCRATCH_PATH + "/" + fileName);

				outPut = true; // 出力フラグ
			}
			catch (NoDataException ex) {
			}

		}

		if (piUkebaraiBean.getLease().getCheckOutput() == 1) {
			LACSUkebaraiCSVLeaseWriter model = new LACSUkebaraiCSVLeaseWriter(super.getCommonBean(), this, super.con);

			try {

				String fileName = model.makeCSV(piUkebaraiBean, context);

				piUkebaraiBean.getLease().setFileName(SCRATCH_PATH + "/" + fileName);

				outPut = true; // 出力フラグ
			}
			catch (NoDataException ex) {
			}

		}

		if (piUkebaraiBean.getHiyo().getCheckOutput() == 1) {
			LACSUkebaraiCSVHiyoWriter model = new LACSUkebaraiCSVHiyoWriter(super.getCommonBean(), this, super.con);

			try {

				String fileName = model.makeCSV(piUkebaraiBean, context);

				piUkebaraiBean.getHiyo().setFileName(SCRATCH_PATH + "/" + fileName);

				outPut = true; // 出力フラグ
			}
			catch (NoDataException ex) {
			}
		}

		if (outPut == false) {
			message.addMessage(LACSDefine.MessageCode.WARN_DB_NORESULT);
		}

		piUkebaraiBean.setMessage(message.getMessage());
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSUkebaraiBean piUkebaraiBean) throws SQLException {

		super.getInputForOUtput(piUkebaraiBean);
	}

	/**
	 * 過去のCSVファイルを削除する.
	 * 
	 * @param piContext
	 *            コンテキスト
	 * @throws Exception
	 *             例外発生時.
	 */
	public void deleteCSV(ServletContext piContext) throws Exception {
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
			}
			catch (Exception ex) {
			}
		}
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}
}
