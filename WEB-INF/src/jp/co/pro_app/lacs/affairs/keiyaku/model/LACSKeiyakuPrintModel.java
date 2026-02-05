package jp.co.pro_app.lacs.affairs.keiyaku.model;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuBean;
import jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuDetailBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.affairs.monthreport.writer.LACSMReportPDFKaikeiMeisaiWriter;
import jp.co.pro_app.lacs.affairs.report.data.entity.LACSReportUserEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.html.ComboValue;

/**
 * 契約検索：印刷Model.
 * 
 * @author yamaguchi
 * @version 20080408
 */
public class LACSKeiyakuPrintModel extends LACSSessionDBModelBase {

	private static final String	SCRATCH_PATH	= "out_pdf";

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "契約検索";
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "会計";
	}

	/**
	 * 業務個別処理.
	 * 
	 * @throws Exception
	 *             例外発生時.
	 */
	public void performSub() throws Exception {
		super.getLogger().start();
		LACSCommonBean commonBean = super.getCommonBean();

		LACSMReportBean reportBean = super.getMReportBean();
		LACSComboMaker.makeCombo(reportBean, super.getCommonBean(), super.con, this, false);

		LACSKeiyakuBean keiyakuBean = super.getKeiyakuBean();

		commonBean.setDispID("K001");

		this.init(reportBean);

		LACSKeiyakuDetailBean detail = null;
		for (int i = 0; i < keiyakuBean.getListCount(); i++) {
			detail = keiyakuBean.getDetail(i);
			if (detail.getKeiyakuNo().equals(super.getInput("selKeiyakuNo"))) {
				break;
			}
		}

		String fileName = SCRATCH_PATH + "/" + this.businessProc(reportBean);
		reportBean.setDownloadPath(fileName);

		detail.setDownloadPath(fileName);

		super.setForwardPath("/jsp/K001.jsp");

		super.getLogger().end();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @return ファイルパス
	 * @throws Exception
	 *             例外発生時.
	 */
	protected String businessProc(LACSMReportBean piReportBean) throws Exception {

		LACSCommonBean commonBean = super.getCommonBean();
		LACSReportUserEntity entity = new LACSReportUserEntity(this);
		LACSMReportPDFKaikeiMeisaiWriter model = new LACSMReportPDFKaikeiMeisaiWriter(commonBean, this, super.con);

		ServletConfig config = this.getServlet().getServletConfig();
		ServletContext context = config.getServletContext();

		String dateMode = "";
		piReportBean.setOutputMode(1);
		String fileName = "";

		try {

			this.deletePDF(context);

			dateMode = commonBean.getDateMode();

			if (super.getCommonBean().getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {
				entity.setCon(super.con);

				entity.setLeasCompany(piReportBean.getLeasCompany().getValue());

				entity.execSQL();

				if (entity.next()) {
					dateMode = entity.getSeirekiWarekiCode();
				}
			}

			model.getData(piReportBean);

			if (piReportBean.getDataMax() > 0) {

				fileName = model.makePDF(piReportBean, dateMode, context);

				piReportBean.clearList();
			}
		}
		finally {
			entity.close();
		}
		return fileName;
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 */
	protected void init(LACSMReportBean piReportBean) {

		String leasCompanyCode = super.getInput("selLeasCompany", "");
		piReportBean.setKeiyakuNo(super.getInput("selKeiyakuNo"));

		piReportBean.getLeasCompany().clear();
		piReportBean.getLeasCompany().add(new ComboValue(leasCompanyCode, leasCompanyCode, true));
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
