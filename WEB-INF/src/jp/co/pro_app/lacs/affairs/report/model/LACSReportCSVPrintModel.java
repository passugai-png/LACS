package jp.co.pro_app.lacs.affairs.report.model;

import java.io.File;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSMessage;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.report.common.LACSReportCommon;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportUserEntity;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportCSVBukkenWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportCSVGenkaWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportCSVGoukeiWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportCSVKizitubetuGoukeiWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportCSVKizitubetuSaimuWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportCSVKizitubetuSisanWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportCSVMikeikaBWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportCSVShiharaiWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportCSVTyukiGensenWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportCSVTyukiWriter;
//import jp.co.pro_app.lacs.affairs.report.writer.LACSreportPDFKizitubetuGoukeiWriter;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 帳票出力：検索処理Model.
 * 
 * @author katoken
 * @version 20080328
 */
public class LACSReportCSVPrintModel extends LACSReportModelBase {

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
	protected void start(LACSReportBean piPrintBean) {
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
	protected void businessProc(LACSReportBean piReportBean) throws Exception {

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

			if (piReportBean.getGoukeiOld().getCheckOutput() + piReportBean.getGoukeiNew().getCheckOutput() > 0) {
				LACSReportCSVGoukeiWriter writer = new LACSReportCSVGoukeiWriter(super.getCommonBean(), this, super.con);

				writer.setModelBase(this);

				if (piReportBean.getGoukeiOld().getCheckOutput() == 1) {

					writer.setAcStd("0");

					try {
						fileName = writer.makeCSV(piReportBean, dateMode, context);

						piReportBean.getGoukeiOld().setFileName(SCRATCH_PATH + "/" + fileName);
						outPut = true; // 出力フラグ
					}
					catch (NoDataException ex) {
					}
				}

				if (piReportBean.getGoukeiNew().getCheckOutput() == 1) {
					writer.setAcStd("1");
					try {
						fileName = writer.makeCSV(piReportBean, dateMode, context);

						piReportBean.getGoukeiNew().setFileName(SCRATCH_PATH + "/" + fileName);
						outPut = true; // 出力フラグ
					}
					catch (NoDataException ex) {
					}
				}
			}

			if (piReportBean.getMikeikaBOld().getCheckOutput() + piReportBean.getMikeikaBNew().getCheckOutput() > 0) {
				LACSReportCSVMikeikaBWriter writer = new LACSReportCSVMikeikaBWriter(super.getCommonBean(), this, super.con);

				writer.setModelBase(this);

				if (piReportBean.getMikeikaBOld().getCheckOutput() == 1) {

					writer.setAcStd("0");

					try {
						fileName = writer.makeCSV(piReportBean, dateMode, context);

						piReportBean.getMikeikaBOld().setFileName(SCRATCH_PATH + "/" + fileName);
						outPut = true; // 出力フラグ
					}
					catch (NoDataException ex) {
					}
				}

				if (piReportBean.getMikeikaBNew().getCheckOutput() == 1) {
					writer.setAcStd("1");
					try {
						fileName = writer.makeCSV(piReportBean, dateMode, context);

						piReportBean.getMikeikaBNew().setFileName(SCRATCH_PATH + "/" + fileName);
						outPut = true; // 出力フラグ
					}
					catch (NoDataException ex) {
					}
				}
			}

			if (piReportBean.getGenkaOld().getCheckOutput() + piReportBean.getGenkaNew().getCheckOutput() > 0) {
				LACSReportCSVGenkaWriter writer = new LACSReportCSVGenkaWriter(super.getCommonBean(), this, super.con);

				if (piReportBean.getGenkaOld().getCheckOutput() == 1) {

					writer.setAcStd("0");

					try {
						fileName = writer.makeCSV(piReportBean, dateMode, context);

						piReportBean.getGenkaOld().setFileName(SCRATCH_PATH + "/" + fileName);
						outPut = true; // 出力フラグ
					}
					catch (NoDataException ex) {
					}
				}

				if (piReportBean.getGenkaNew().getCheckOutput() == 1) {
					writer.setAcStd("1");
					try {
						fileName = writer.makeCSV(piReportBean, dateMode, context);

						piReportBean.getGenkaNew().setFileName(SCRATCH_PATH + "/" + fileName);
						outPut = true; // 出力フラグ
					}
					catch (NoDataException ex) {
					}
				}
			}

			if (piReportBean.getShiharaiOld().getCheckOutput() + piReportBean.getShiharaiNew().getCheckOutput() > 0) {
				LACSReportCSVShiharaiWriter writer = new LACSReportCSVShiharaiWriter(super.getCommonBean(), this, super.con);

				if (piReportBean.getShiharaiOld().getCheckOutput() == 1) {

					writer.setAcStd("0");

					try {
						fileName = writer.makeCSV(piReportBean, dateMode, context);

						piReportBean.getShiharaiOld().setFileName(SCRATCH_PATH + "/" + fileName);
						outPut = true; // 出力フラグ
					}
					catch (NoDataException ex) {
					}
				}

				if (piReportBean.getShiharaiNew().getCheckOutput() == 1) {
					writer.setAcStd("1");
					try {
						fileName = writer.makeCSV(piReportBean, dateMode, context);

						piReportBean.getShiharaiNew().setFileName(SCRATCH_PATH + "/" + fileName);
						outPut = true; // 出力フラグ
					}
					catch (NoDataException ex) {
					}
				}
			}

			if (piReportBean.getGensenOld().getCheckOutput() + piReportBean.getGensenNew().getCheckOutput() > 0) {
				LACSReportCSVTyukiGensenWriter writer = new LACSReportCSVTyukiGensenWriter(super.getCommonBean(), this, super.con);

				if (piReportBean.getGensenOld().getCheckOutput() == 1) {

					writer.setAcStd("0");

					try {
						fileName = writer.makeCSV(piReportBean, dateMode, context);

						piReportBean.getGensenOld().setFileName(SCRATCH_PATH + "/" + fileName);
						outPut = true; // 出力フラグ
					}
					catch (NoDataException ex) {
					}
				}

				if (piReportBean.getGensenNew().getCheckOutput() == 1) {
					writer.setAcStd("1");
					try {
						fileName = writer.makeCSV(piReportBean, dateMode, context);

						piReportBean.getGensenNew().setFileName(SCRATCH_PATH + "/" + fileName);
						outPut = true; // 出力フラグ
					}
					catch (NoDataException ex) {
					}
				}
			}

			if (piReportBean.getSchedule().getCheckOutput() > 0) {
				LACSReportCSVBukkenWriter writer = new LACSReportCSVBukkenWriter(super.getCommonBean(), this, super.con);

				try {
					fileName = writer.makeCSV(piReportBean, dateMode, context);

					piReportBean.getSchedule().setFileName(SCRATCH_PATH + "/" + fileName);
					outPut = true; // 出力フラグ
				}
				catch (NoDataException ex) {
				}
			}

			if (piReportBean.getTyuki().getCheckOutput() == 1) {
				LACSReportCSVTyukiWriter writer = new LACSReportCSVTyukiWriter(super.getCommonBean(), this, super.con);
				try {
					fileName = writer.makeCSV(piReportBean, dateMode, context);

					piReportBean.getTyuki().setFileName(SCRATCH_PATH + "/" + fileName);
					outPut = true; // 出力フラグ
				}
				catch (NoDataException ex) {
				}
			}
			
			// 20200617 arai 追加
			if (piReportBean.getKizituGoukeiNew().getCheckOutput() + piReportBean.getKizituGoukeiOld().getCheckOutput() > 0) {
				LACSReportCSVKizitubetuGoukeiWriter writer = new LACSReportCSVKizitubetuGoukeiWriter(super.getCommonBean(), this, super.con);

				if (piReportBean.getKizituGoukeiOld().getCheckOutput() == 1) {

					writer.setAcStd("0");

					try {
						fileName = writer.makeCSV(piReportBean, dateMode, context);

						piReportBean.getKizituGoukeiOld().setFileName(SCRATCH_PATH + "/" + fileName);
						outPut = true; // 出力フラグ
					}
					catch (NoDataException ex) {
					}
				}

				if (piReportBean.getKizituGoukeiNew().getCheckOutput() == 1) {
					writer.setAcStd("1");
					try {
						fileName = writer.makeCSV(piReportBean, dateMode, context);

						piReportBean.getKizituGoukeiNew().setFileName(SCRATCH_PATH + "/" + fileName);
						outPut = true; // 出力フラグ
					}
					catch (NoDataException ex) {
					}
				}
			}

			if (piReportBean.getKizituSaimuNew().getCheckOutput() + piReportBean.getKizituGoukeiOld().getCheckOutput() > 0) {
				LACSReportCSVKizitubetuSaimuWriter writer = new LACSReportCSVKizitubetuSaimuWriter(super.getCommonBean(), this, super.con);

				if (piReportBean.getKizituSaimuOld().getCheckOutput() == 1) {

					writer.setAcStd("0");

					try {
						fileName = writer.makeCSV(piReportBean, dateMode, context);

						piReportBean.getKizituSaimuOld().setFileName(SCRATCH_PATH + "/" + fileName);
						outPut = true; // 出力フラグ
					}
					catch (NoDataException ex) {
					}
				}

				if (piReportBean.getKizituSaimuNew().getCheckOutput() == 1) {
					writer.setAcStd("1");
					try {
						fileName = writer.makeCSV(piReportBean, dateMode, context);

						piReportBean.getKizituSaimuNew().setFileName(SCRATCH_PATH + "/" + fileName);
						outPut = true; // 出力フラグ
					}
					catch (NoDataException ex) {
					}
				}
			}

			if (piReportBean.getKizituSisanNew().getCheckOutput() + piReportBean.getKizituSisanOld().getCheckOutput() > 0) {
				LACSReportCSVKizitubetuSisanWriter writer = new LACSReportCSVKizitubetuSisanWriter(super.getCommonBean(), this, super.con);

				writer.setModelBase(this);
				
				if (piReportBean.getKizituSisanOld().getCheckOutput() == 1) {

					writer.setAcStd("0");

					try {
						fileName = writer.makeCSV(piReportBean, dateMode, context);

						piReportBean.getKizituSisanOld().setFileName(SCRATCH_PATH + "/" + fileName);
						outPut = true; // 出力フラグ
					}
					catch (NoDataException ex) {
					}
				}

				if (piReportBean.getKizituSisanNew().getCheckOutput() == 1) {
					writer.setAcStd("1");
					try {
						fileName = writer.makeCSV(piReportBean, dateMode, context);

						piReportBean.getKizituSisanNew().setFileName(SCRATCH_PATH + "/" + fileName);
						outPut = true; // 出力フラグ
					}
					catch (NoDataException ex) {
					}
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
	protected void initSub(LACSReportBean piReportBean) throws SQLException {

		LACSReportCommon.getInput(super.getCommonBean(), this.con, piReportBean, this, LACSReportCommon.TIMING_PRINT_CSV);

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
	private boolean checkInput(LACSCommonBean piCommonBean, LACSReportBean piReportBean, LACSMessage piMessage) throws SQLException {

		return LACSReportCommon.checkInput(piCommonBean, con, this, piReportBean, piMessage, LACSReportCommon.TIMING_PRINT_CSV);

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
