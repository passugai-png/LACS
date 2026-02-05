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
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportPDFBukkenWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportPDFGenkaWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportPDFGoukeiWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportPDFKizitubetuSaimuWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportPDFKizitubetuSisanWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportPDFMikeikaBWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportPDFSiharaiWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSReportPDFTyukiWriter;
import jp.co.pro_app.lacs.affairs.report.writer.LACSreportPDFKizitubetuGoukeiWriter;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.DateUtl;

/**
 * 帳票出力：検索処理Model.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSReportPDFPrintModel extends LACSReportModelBase {

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

		piReportBean.setOutputMode(1);

		LACSReportUserEntity entity = new LACSReportUserEntity(this);

		boolean outPut = false;
		ServletConfig config = this.getServlet().getServletConfig();
		ServletContext context = config.getServletContext();

		String dateMode = "";

		try {

			this.deletePDF(context);

			dateMode = super.getCommonBean().getDateMode();

			if (super.getCommonBean().getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {
				entity.setCon(super.con);

				entity.setLeasCompany(piReportBean.getLeasCompany().getValue());

				entity.execSQL();

				if (entity.next()) {
					dateMode = entity.getSeirekiWarekiCode();
				}
			}

			if (piReportBean.getGoukeiOld().getCheckOutput() == 1) {
				LACSReportPDFGoukeiWriter model = new LACSReportPDFGoukeiWriter(super.getCommonBean(), this, super.con);

				model.setAcStd("0");

				model.setModelBase(this);

				model.getData(piReportBean);

				if (piReportBean.getDataMax() > 0) {

					String fileName = model.makePDF(piReportBean, dateMode, context);

					piReportBean.getGoukeiOld().setFileName(SCRATCH_PATH + "/" + fileName);

					outPut = true; // 出力フラグ

					piReportBean.clearList();
				}
			}

			if (piReportBean.getGoukeiNew().getCheckOutput() == 1) {
				LACSReportPDFGoukeiWriter model = new LACSReportPDFGoukeiWriter(super.getCommonBean(), this, super.con);

				model.setAcStd("1");

				model.setModelBase(this);

				model.getData(piReportBean);

				if (piReportBean.getDataMax() > 0) {

					String fileName = model.makePDF(piReportBean, dateMode, context);

					piReportBean.getGoukeiNew().setFileName(SCRATCH_PATH + "/" + fileName);

					outPut = true; // 出力フラグ

					piReportBean.clearList();
				}
			}

			if (piReportBean.getMikeikaBOld().getCheckOutput() == 1) {
				LACSReportPDFMikeikaBWriter model = new LACSReportPDFMikeikaBWriter(super.getCommonBean(), this, super.con);

				model.setAcStd("0");

				model.setModelBase(this);

				model.getData(piReportBean);

				if (piReportBean.getDataMax() > 0) {

					String fileName = model.makePDF(piReportBean, dateMode, context);

					piReportBean.getMikeikaBOld().setFileName(SCRATCH_PATH + "/" + fileName);

					outPut = true; // 出力フラグ

					piReportBean.clearList();
				}
			}

			if (piReportBean.getMikeikaBNew().getCheckOutput() == 1) {
				LACSReportPDFMikeikaBWriter model = new LACSReportPDFMikeikaBWriter(super.getCommonBean(), this, super.con);

				model.setAcStd("1");

				model.setModelBase(this);

				model.getData(piReportBean);

				if (piReportBean.getDataMax() > 0) {

					String fileName = model.makePDF(piReportBean, dateMode, context);

					piReportBean.getMikeikaBNew().setFileName(SCRATCH_PATH + "/" + fileName);

					outPut = true; // 出力フラグ

					piReportBean.clearList();
				}
			}

			if (piReportBean.getGenkaOld().getCheckOutput() == 1) {
				LACSReportPDFGenkaWriter model = new LACSReportPDFGenkaWriter(super.getCommonBean(), this, super.con);

				model.setAcStd("0");
				model.getData(piReportBean);

				if (piReportBean.getDataMax() > 0) {

					String fileName = model.makePDF(piReportBean, dateMode, context);

					piReportBean.getGenkaOld().setFileName(SCRATCH_PATH + "/" + fileName);

					outPut = true; // 出力フラグ

					piReportBean.clearList();
				}
			}

			if (piReportBean.getGenkaNew().getCheckOutput() == 1) {
				LACSReportPDFGenkaWriter model = new LACSReportPDFGenkaWriter(super.getCommonBean(), this, super.con);

				model.setAcStd("1");
				model.getData(piReportBean);

				if (piReportBean.getDataMax() > 0) {

					String fileName = model.makePDF(piReportBean, dateMode, context);

					piReportBean.getGenkaNew().setFileName(SCRATCH_PATH + "/" + fileName);

					outPut = true; // 出力フラグ

					piReportBean.clearList();
				}
			}

			if (piReportBean.getShiharaiOld().getCheckOutput() == 1) {
				LACSReportPDFSiharaiWriter model = new LACSReportPDFSiharaiWriter(super.getCommonBean(), this, super.con);

				model.setAcStd("0");
				model.getData(piReportBean);

				if (piReportBean.getDataMax() > 0) {

					String fileName = model.makePDF(piReportBean, dateMode, context);

					piReportBean.getShiharaiOld().setFileName(SCRATCH_PATH + "/" + fileName);

					outPut = true; // 出力フラグ

					piReportBean.clearList();
				}
			}

			if (piReportBean.getShiharaiNew().getCheckOutput() == 1) {
				LACSReportPDFSiharaiWriter model = new LACSReportPDFSiharaiWriter(super.getCommonBean(), this, super.con);

				model.setAcStd("1");
				model.getData(piReportBean);

				if (piReportBean.getDataMax() > 0) {

					String fileName = model.makePDF(piReportBean, dateMode, context);

					piReportBean.getShiharaiNew().setFileName(SCRATCH_PATH + "/" + fileName);

					outPut = true; // 出力フラグ

					piReportBean.clearList();
				}
			}

			if (piReportBean.getSchedule().getCheckOutput() == 1) {
				LACSReportPDFBukkenWriter model = new LACSReportPDFBukkenWriter(super.getCommonBean(), this, super.con);

				model.getData(piReportBean);

				if (piReportBean.getDataMax() > 0) {

					String fileName = model.makePDF(piReportBean, dateMode, context);

					piReportBean.getSchedule().setFileName(SCRATCH_PATH + "/" + fileName);

					outPut = true; // 出力フラグ

					piReportBean.clearList();
				}
			}

			if (piReportBean.getTyuki().getCheckOutput() == 1) {
				LACSReportPDFTyukiWriter model = new LACSReportPDFTyukiWriter(super.getCommonBean(), this, super.con);

				model.getData(piReportBean);

				if (piReportBean.getDataMax() > 0) {

					String fileName = model.makePDF(piReportBean, dateMode, context);

					piReportBean.getTyuki().setFileName(SCRATCH_PATH + "/" + fileName);

					outPut = true; // 出力フラグ

					piReportBean.clearList();
				}
			}
			
			// 20200617 arai 追加 start
			if (piReportBean.getKizituGoukeiOld().getCheckOutput() == 1) {
				LACSreportPDFKizitubetuGoukeiWriter model = new LACSreportPDFKizitubetuGoukeiWriter(super.getCommonBean(), this, super.con);

				model.setAcStd("0");
				model.getData(piReportBean);				

				if (piReportBean.getDataMax() > 0) {

					String fileName = model.makePDF(piReportBean, dateMode, context);

					piReportBean.getKizituGoukeiOld().setFileName(SCRATCH_PATH + "/" + fileName);

					outPut = true; // 出力フラグ

					piReportBean.clearList();
				}
			}

			if (piReportBean.getKizituGoukeiNew().getCheckOutput() == 1) {
				LACSreportPDFKizitubetuGoukeiWriter model = new LACSreportPDFKizitubetuGoukeiWriter(super.getCommonBean(), this, super.con);

				model.setAcStd("1");
				model.getData(piReportBean);

				if (piReportBean.getDataMax() > 0) {

					String fileName = model.makePDF(piReportBean, dateMode, context);

					piReportBean.getKizituGoukeiNew().setFileName(SCRATCH_PATH + "/" + fileName);

					outPut = true; // 出力フラグ

					piReportBean.clearList();
				}
			}
			
			if (piReportBean.getKizituSaimuOld().getCheckOutput() == 1) {
				LACSReportPDFKizitubetuSaimuWriter model = new LACSReportPDFKizitubetuSaimuWriter(super.getCommonBean(), this, super.con);

				model.setAcStd("0");
				model.getData(piReportBean);

				if (piReportBean.getDataMax() > 0) {

					String fileName = model.makePDF(piReportBean, dateMode, context);

					piReportBean.getKizituSaimuOld().setFileName(SCRATCH_PATH + "/" + fileName);

					outPut = true; // 出力フラグ

					piReportBean.clearList();
				}
			}

			if (piReportBean.getKizituSaimuNew().getCheckOutput() == 1) {
				LACSReportPDFKizitubetuSaimuWriter model = new LACSReportPDFKizitubetuSaimuWriter(super.getCommonBean(), this, super.con);

				model.setAcStd("1");
				model.getData(piReportBean);

				if (piReportBean.getDataMax() > 0) {

					String fileName = model.makePDF(piReportBean, dateMode, context);

					piReportBean.getKizituSaimuNew().setFileName(SCRATCH_PATH + "/" + fileName);

					outPut = true; // 出力フラグ

					piReportBean.clearList();
				}
	
			}

			if (piReportBean.getKizituSisanOld().getCheckOutput() == 1) {
				LACSReportPDFKizitubetuSisanWriter model = new LACSReportPDFKizitubetuSisanWriter(super.getCommonBean(), this, super.con);

				model.setAcStd("0");
				model.getData(piReportBean);

				if (piReportBean.getDataMax() > 0) {

					String fileName = model.makePDF(piReportBean, dateMode, context);

					piReportBean.getKizituSisanOld().setFileName(SCRATCH_PATH + "/" + fileName);

					outPut = true; // 出力フラグ

					piReportBean.clearList();
				}
			}

			if (piReportBean.getKizituSisanNew().getCheckOutput() == 1) {
				LACSReportPDFKizitubetuSisanWriter model = new LACSReportPDFKizitubetuSisanWriter(super.getCommonBean(), this, super.con);

				model.setAcStd("1");
				model.getData(piReportBean);

				if (piReportBean.getDataMax() > 0) {

					String fileName = model.makePDF(piReportBean, dateMode, context);

					piReportBean.getKizituSisanNew().setFileName(SCRATCH_PATH + "/" + fileName);

					outPut = true; // 出力フラグ

					piReportBean.clearList();
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
		LACSReportCommon.getInput(super.getCommonBean(), this.con, piReportBean, this, LACSReportCommon.TIMING_PRINT_PDF);
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
		return LACSReportCommon.checkInput(piCommonBean, con, this, piReportBean, piMessage, LACSReportCommon.TIMING_PRINT_PDF);
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

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}
}
