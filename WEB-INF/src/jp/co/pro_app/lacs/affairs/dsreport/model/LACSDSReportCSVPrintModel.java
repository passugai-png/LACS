package jp.co.pro_app.lacs.affairs.dsreport.model;

import java.io.File;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSMessage;
import jp.co.pro_app.lacs.affairs.dsreport.bean.LACSDSReportBean;
import jp.co.pro_app.lacs.affairs.dsreport.common.LACSDSReportCommon;
import jp.co.pro_app.lacs.affairs.dsreport.writer.LACSDSReportCSVGoukeiWriter;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 帳票出力：検索処理Model.
 * 
 * @author katoken
 * @version 20080328
 */
public class LACSDSReportCSVPrintModel extends LACSDSReportModelBase {

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
	protected void start(LACSDSReportBean piPrintBean) {
		super.getLogger().start(piPrintBean.getLeasCompany());
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSDSReportBean piReportBean) throws Exception {

		if (!this.checkInput(super.getCommonBean(), piReportBean, message)) {
			piReportBean.setMessage(message.getMessage());
			return;
		}

		piReportBean.setOutputMode(0);

		boolean outPut = false;
		ServletConfig config = this.getServlet().getServletConfig();
		ServletContext context = config.getServletContext();

		String fileName = "";

		try {
			this.deleteCSV(context);

			LACSDSReportCSVGoukeiWriter writer = new LACSDSReportCSVGoukeiWriter(super.getCommonBean(), this, super.con);

			try {
				fileName = writer.makeCSV(piReportBean, context);

				piReportBean.setCsvFileName(SCRATCH_PATH + "/" + fileName);
				outPut = true; // 出力フラグ
			}
			catch (NoDataException ex) {
			}

			if (outPut == false) {
				message.addMessage(LACSDefine.MessageCode.WARN_DB_NORESULT);
			}

			piReportBean.setMessage(message.getMessage());
		}
		finally {
		}
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSDSReportBean piReportBean) throws SQLException {

		LACSDSReportCommon.getInput(super.getCommonBean(), this.con, piReportBean, this, LACSDSReportCommon.TIMING_PRINT_CSV);

	}

	/**
	 * 入力チェック.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piReportBean
	 *            帳票出力Bean
	 * @param piMessage
	 *            メッセージ
	 * @return チェック結果
	 * @throws SQLException
	 *             SQL実行例外
	 */
	private boolean checkInput(LACSCommonBean piCommonBean, LACSDSReportBean piReportBean, LACSMessage piMessage) throws SQLException {

		return LACSDSReportCommon.checkInput(piCommonBean, con, this, piReportBean, piMessage, LACSDSReportCommon.TIMING_PRINT_CSV);

	}

	/**
	 * 過去のPDFファイルを削除する.
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
