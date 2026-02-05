package jp.co.pro_app.lacs.affairs.syousai.model;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiBean;
import jp.co.pro_app.lacs.affairs.syousai.data.entity.LACSReportUserEntity;
import jp.co.pro_app.lacs.affairs.syousai.writer.LACSReportCSVKeiyakuSyousaiWriter;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.DateUtl;

/**
 * 契約詳細：CSV印刷Model.
 * 
 * @author yokota
 * @version 20081017
 */
public class LACSSyousaiCSVPrintModel extends LACSSyousaiModelBase {

	private static final String	SCRATCH_PATH	= "csv/";

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "契約詳細照会";
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "CSV作成";
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piSyousaiBean
	 *            契約詳細Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSSyousaiBean piSyousaiBean) throws Exception {

		LACSCommonBean commonBean = super.getCommonBean();
		LACSReportUserEntity entity = new LACSReportUserEntity(this);
		LACSReportCSVKeiyakuSyousaiWriter model = new LACSReportCSVKeiyakuSyousaiWriter(commonBean, this, super.con);

		ServletConfig config = this.getServlet().getServletConfig();
		ServletContext context = config.getServletContext();

		String dateMode = "";
		piSyousaiBean.setOutputMode(1);
		String fileName = "";

		try {

			this.deleteCSV(context);

			dateMode = commonBean.getDateMode();

			fileName = model.makeCSV(piSyousaiBean, dateMode, context);

			piSyousaiBean.setCSVDownloadPath(SCRATCH_PATH + fileName);

		}
		finally {
			entity.close();
		}
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piSyousaiBean
	 *            契約詳細Bean
	 */
	protected void initSub(LACSSyousaiBean piSyousaiBean) {
		Command.noOperation();
	}

	/**
	 * 過去のCSVファイルを削除する.
	 * 
	 * @param piContext
	 *            コンテキスト
	 * @throws Exception
	 *             例外発生時.
	 */
	private void deleteCSV(ServletContext piContext) throws Exception {
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
