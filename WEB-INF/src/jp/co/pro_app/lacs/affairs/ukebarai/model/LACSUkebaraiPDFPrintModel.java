package jp.co.pro_app.lacs.affairs.ukebarai.model;

import java.io.File;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.affairs.ukebarai.writer.LACSUkebaraiPDFGokeiWriter;
import jp.co.pro_app.lacs.affairs.ukebarai.writer.LACSUkebaraiPDFHiyoWriter;
import jp.co.pro_app.lacs.affairs.ukebarai.writer.LACSUkebaraiPDFLeaseWriter;
import jp.co.pro_app.lacs.affairs.ukebarai.writer.LACSUkebaraiPDFSisanWriter;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.DateUtl;

/**
 * 受払合計表：PDF出力処理Model.
 * 
 * @author active
 * @version 20080812
 */
public class LACSUkebaraiPDFPrintModel extends LACSUkebaraiModelBase {

	private static final String	SCRATCH_PATH	= "out_pdf";

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
	 * @param piPrintBean
	 *            月次帳票出力Bean
	 */
	protected void start(LACSUkebaraiBean piPrintBean) {
		super.getLogger().start(piPrintBean.getLeasCompany());
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
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

		piUkebaraiBean.setOutputMode(1);

		boolean outPut = false;
		ServletConfig config = this.getServlet().getServletConfig();
		ServletContext context = config.getServletContext();

		this.deletePDF(context);

		if (piUkebaraiBean.getGokei().getCheckOutput() == 1) {
			LACSUkebaraiPDFGokeiWriter model = new LACSUkebaraiPDFGokeiWriter(super.getCommonBean(), this, super.con);

			model.getGokeiData(piUkebaraiBean);

			if (piUkebaraiBean.getDataMax() > 0) {

				String fileName = model.makePDF(piUkebaraiBean, context);

				piUkebaraiBean.getGokei().setFileName(SCRATCH_PATH + "/" + fileName);

				outPut = true; // 出力フラグ
			}

		}

		if (piUkebaraiBean.getSisan().getCheckOutput() == 1) {
			LACSUkebaraiPDFSisanWriter model = new LACSUkebaraiPDFSisanWriter(super.getCommonBean(), this, super.con);

			model.getSisanData(piUkebaraiBean);

			if (piUkebaraiBean.getDataMax() > 0) {

				String fileName = model.makePDF(piUkebaraiBean, context);

				piUkebaraiBean.getSisan().setFileName(SCRATCH_PATH + "/" + fileName);

				outPut = true; // 出力フラグ

				piUkebaraiBean.clearList();

			}

		}

		if (piUkebaraiBean.getLease().getCheckOutput() == 1) {
			LACSUkebaraiPDFLeaseWriter model = new LACSUkebaraiPDFLeaseWriter(super.getCommonBean(), this, super.con);

			model.getLeaseData(piUkebaraiBean);

			if (piUkebaraiBean.getDataMax() > 0) {

				String fileName = model.makePDF(piUkebaraiBean, context);

				piUkebaraiBean.getLease().setFileName(SCRATCH_PATH + "/" + fileName);

				outPut = true; // 出力フラグ

				piUkebaraiBean.clearList();

			}

		}

		if (piUkebaraiBean.getHiyo().getCheckOutput() == 1) {
			LACSUkebaraiPDFHiyoWriter model = new LACSUkebaraiPDFHiyoWriter(super.getCommonBean(), this, super.con);

			model.getHiyoData(piUkebaraiBean);

			if (piUkebaraiBean.getDataMax() > 0) {

				String fileName = model.makePDF(piUkebaraiBean, context);

				piUkebaraiBean.getHiyo().setFileName(SCRATCH_PATH + "/" + fileName);

				outPut = true; // 出力フラグ

				piUkebaraiBean.clearList();

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
	 * 過去のPDFファイルを削除する.
	 * 
	 * @param piContext
	 *            コンテキスト
	 * @throws Exception
	 *             例外発生時.
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
			}
			catch (Exception ex) {
			}
		}
	}
}
