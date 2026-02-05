package jp.co.pro_app.lacs.affairs.top.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Date;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.projframe.common.command.DateUtl;

/**
 * 処理メニュー：お知らせ印刷Model.
 * 
 * @author Katoh
 * @version 20080616
 */
public class LACSTopPrintModel extends LACSTopMenuModel {

	private static final String	SCRATCH_PATH	= "txt";

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "印刷";
	}

	/**
	 * 印刷処理.
	 * 
	 * @throws Exception
	 *             例外発生時
	 */
	protected void print() throws Exception {

		LACSCommonBean commonBean = super.getCommonBean();
		ServletConfig config = this.getServlet().getServletConfig();
		ServletContext context = config.getServletContext();

		String fileName = "";

		try {
			this.deleteText(context);

			fileName = getData(commonBean);

			if (fileName.trim().length() > 0) {
				commonBean.setInfoFile(SCRATCH_PATH + "/" + fileName);
			}
		}
		finally {

		}
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 */
	protected void init(LACSMReportBean piReportBean) {
	}

	/**
	 * 過去のPDFファイルを削除する.
	 * 
	 * @param piContext
	 *            コンテキスト
	 * @throws Exception
	 *             例外発生時.
	 */
	private void deleteText(ServletContext piContext) throws Exception {
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

	private String getData(LACSCommonBean piCommonBean) throws IOException {
		StringBuffer buf = new StringBuffer();

		File scratchDirectory = null;

		File tmpFile = null;

		for (int i = 0; i < piCommonBean.getInfo().size(); i++) {
			buf.append(piCommonBean.getInfo().get(i).replaceAll("&nbsp;", " ") + "\r\n");
		}

		scratchDirectory = new File(super.getServlet().getServletContext().getRealPath(SCRATCH_PATH));

		tmpFile = File.createTempFile("info_", ".txt", scratchDirectory);

		write(tmpFile.getAbsolutePath(), buf.toString());

		return tmpFile.getName();
	}

	private void write(String piPath, String piData) throws IOException {
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(piPath, true), "windows-31j"));
			writer.write(piData);
		}
		catch (IOException e) {
			throw e;
		}
		finally {
			writer.close();
		}
	}
}
