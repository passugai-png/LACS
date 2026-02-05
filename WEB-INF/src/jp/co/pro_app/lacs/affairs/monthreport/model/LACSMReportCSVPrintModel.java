package jp.co.pro_app.lacs.affairs.monthreport.model;

import java.io.File;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSMessage;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.affairs.monthreport.common.LACSMReportCommon;
import jp.co.pro_app.lacs.affairs.monthreport.writer.LACSMReportCSVKaikeiMeisaiWriter;
import jp.co.pro_app.lacs.affairs.monthreport.writer.LACSMReportCSVRemoveAssertWriter;
import jp.co.pro_app.lacs.affairs.monthreport.writer.LACSMReportCSVShiwakeGensenWriter;
import jp.co.pro_app.lacs.affairs.monthreport.writer.LACSMReportCSVSisanWriter;
import jp.co.pro_app.lacs.affairs.monthreport.writer.LACSMReportCSVSiwakeWriter;
import jp.co.pro_app.lacs.affairs.monthreport.writer.LACSMReportCSVSyouhizeiWriter;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportUserEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 月次帳票出力：検索処理Model.
 * 
 * @author fukuhara
 * @version 20080416
 */
public class LACSMReportCSVPrintModel extends LACSMReportModelBase {

	private static final String	SCRATCH_PATH	= "csv";

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "CSV出力";
	}

	/**
	 * 処理開始ログ出力.
	 * 
	 * @param piPrintBean
	 *            月次帳票出力Bean
	 */
	protected void start(LACSMReportBean piPrintBean) {
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
	protected void businessProc(LACSMReportBean piReportBean) throws Exception {

		if (!this.checkInput(super.getCommonBean(), piReportBean, message)) {
			piReportBean.setMessage(message.getMessage());
			return;
		}

		piReportBean.setOutputMode(0);

		LACSReportUserEntity entity = new LACSReportUserEntity(this);

		boolean outPut = false;
		ServletConfig config = this.getServlet().getServletConfig();
		ServletContext context = config.getServletContext();

		String fileName = "";

		String dateMode = "";

		try {
			this.deleteCSV(context);

			dateMode = super.getCommonBean().getDateMode();

			if (super.getCommonBean().getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {
				entity.setCon(super.con);

				entity.setLeasCompany(piReportBean.getLeasCompany().getValue());

				entity.execSQL();

				if (entity.next()) {
					dateMode = entity.getSeirekiWarekiCode();
				}
			}

			if (piReportBean.getRemoveAssert().getCheckOutput() > 0) {
				LACSMReportCSVRemoveAssertWriter writer = new LACSMReportCSVRemoveAssertWriter(super.getCommonBean(), this, super.con);

				try {
					fileName = writer.makeCSV(piReportBean, dateMode, context);

					piReportBean.getRemoveAssert().setFileName(SCRATCH_PATH + "/" + fileName);
					outPut = true; // 出力フラグ
				}
				catch (NoDataException ex) {
				}
			}

			if (piReportBean.getKaikeiMeisai().getCheckOutput() > 0) {
				LACSMReportCSVKaikeiMeisaiWriter writer = new LACSMReportCSVKaikeiMeisaiWriter(super.getCommonBean(), this, super.con);

				try {
					fileName = writer.makeCSV(piReportBean, dateMode, context);

					piReportBean.getKaikeiMeisai().setFileName(SCRATCH_PATH + "/" + fileName);
					outPut = true; // 出力フラグ
				}
				catch (NoDataException ex) {
				}
			}

			if (piReportBean.getSiwake().getCheckOutput() > 0) {
				LACSMReportCSVSiwakeWriter writer = new LACSMReportCSVSiwakeWriter(super.getCommonBean(), this, super.con);

				try {
					fileName = writer.makeCSV(piReportBean, dateMode, context);

					piReportBean.getSiwake().setFileName(SCRATCH_PATH + "/" + fileName);
					outPut = true; // 出力フラグ
				}
				catch (NoDataException ex) {
				}
			}

			if (piReportBean.getSisan().getCheckOutput() > 0) {
				LACSMReportCSVSisanWriter writer = new LACSMReportCSVSisanWriter(super.getCommonBean(), this, super.con);

				try {
					fileName = writer.makeCSV(piReportBean, dateMode, context);

					piReportBean.getSisan().setFileName(SCRATCH_PATH + "/" + fileName);
					outPut = true; // 出力フラグ
				}
				catch (NoDataException ex) {
				}
			}

			if (piReportBean.getSyouhizei().getCheckOutput() > 0) {
				LACSMReportCSVSyouhizeiWriter writer = new LACSMReportCSVSyouhizeiWriter(super.getCommonBean(), this, super.con);

				try {
					fileName = writer.makeCSV(piReportBean, dateMode, context);

					piReportBean.getSyouhizei().setFileName(SCRATCH_PATH + "/" + fileName);
					outPut = true; // 出力フラグ
				}
				catch (NoDataException ex) {
				}
			}

			if (piReportBean.getDownload().getCheckOutput() > 0) {
				LACSMReportCSVShiwakeGensenWriter writer = new LACSMReportCSVShiwakeGensenWriter(super.getCommonBean(), this, super.con);

				try {
					fileName = writer.makeCSV(piReportBean, dateMode, context);

					piReportBean.getDownload().setFileName(SCRATCH_PATH + "/" + fileName);
					outPut = true; // 出力フラグ
				}
				catch (NoDataException ex) {
				}
			}

			if (outPut == false) {
				message.addMessage(LACSDefine.MessageCode.WARN_DB_NORESULT);
			}

			piReportBean.setMessage(message.getMessage());
		}

		finally {
			entity.close();
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
	protected void initSub(LACSMReportBean piReportBean) throws SQLException {
		LACSMReportCommon.getInput(super.getCommonBean(), this.con, piReportBean, this, LACSMReportCommon.TIMING_PRINT_PDF);
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
	private boolean checkInput(LACSCommonBean piCommonBean, LACSMReportBean piReportBean, LACSMessage piMessage) throws SQLException {
		return LACSMReportCommon.checkInput(piCommonBean, con, this, piReportBean, piMessage, LACSMReportCommon.TIMING_PRINT_CSV);
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
