package jp.co.pro_app.lacs.affairs.dsreport.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.dsreport.bean.LACSDSReportBean;
import jp.co.pro_app.lacs.affairs.dsreport.bean.LACSDSReportGoukeiBean;
import jp.co.pro_app.lacs.affairs.dsreport.data.entity.LACSDSReportGoukeiEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

/**
 * 帳票出力：リース会計注記合計表Model.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSDSReportPDFGoukeiWriter extends LACSDSReportPDFWriterBase {

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
	public LACSDSReportPDFGoukeiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
	}

	/**
	 * 出力データ取得.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	public void getData(LACSDSReportBean piReportBean) throws SQLException {
		LACSDSReportGoukeiEntity reportEntity = new LACSDSReportGoukeiEntity(super.model, commonBean, piReportBean);
		LACSDSReportGoukeiBean detail = null;

		try {
			reportEntity.setCon(super.con);

			piReportBean.setDataMax(reportEntity.execSQL());

			while (reportEntity.next()) {
				detail = new LACSDSReportGoukeiBean();
				piReportBean.addGoukeiBean(detail);

				detail.setTermFrom(reportEntity.getTermFrom());
				detail.setTermTo(reportEntity.getTermTo());

				detail.setTermFirstFrom(reportEntity.getTermFirstFrom());
				detail.setTermFirstTo(reportEntity.getTermFirstTo());
				detail.setTermSecondFrom(reportEntity.getTermSecondFrom());
				detail.setTermSecondTo(reportEntity.getTermSecondTo());
				detail.setTermThirdFrom(reportEntity.getTermThirdFrom());
				detail.setTermThirdTo(reportEntity.getTermThirdTo());
				detail.setTermFourthFrom(reportEntity.getTermFourthFrom());
				detail.setTermFourthTo(reportEntity.getTermFourthTo());
				detail.setTermFifthFrom(reportEntity.getTermFifthFrom());
				detail.setTermFifthTo(reportEntity.getTermFifthTo());
				detail.setTermOver(reportEntity.getTermOver());

				detail.setB1aLeaseAmount(reportEntity.getB1aLeaseAmount());
				detail.setB1bMtmrZanzonAmount(reportEntity.getB1bMtmrZanzonAmount());
				detail.setB1cRisokuAmount(reportEntity.getB1cRisokuAmount());
				detail.setB1dEkimuAmount(reportEntity.getB1dEkimuAmount());
				detail.setB1eIjiAmount(reportEntity.getB1eIjiAmount());
				detail.setB1fGanpon(reportEntity.getB1fGanpon());

				detail.setB2ItenFirst(reportEntity.getB2ItenFirst());
				detail.setB2ItenSecond(reportEntity.getB2ItenSecond());
				detail.setB2ItenThird(reportEntity.getB2ItenThird());
				detail.setB2ItenFourth(reportEntity.getB2ItenFourth());
				detail.setB2ItenFifth(reportEntity.getB2ItenFifth());
				detail.setB2ItenOver(reportEntity.getB2ItenOver());

				detail.setB2ItengaiFirst(reportEntity.getB2ItengaiFirst());
				detail.setB2ItengaiSecond(reportEntity.getB2ItengaiSecond());
				detail.setB2ItengaiThird(reportEntity.getB2ItengaiThird());
				detail.setB2ItengaiFourth(reportEntity.getB2ItengaiFourth());
				detail.setB2ItengaiFifth(reportEntity.getB2ItengaiFifth());
				detail.setB2ItengaiOver(reportEntity.getB2ItengaiOver());

				detail.setB3OperationFirst(reportEntity.getB3OperationFirst());
				detail.setB3OperationOver(reportEntity.getB3OperationOver());
				detail.setB3OperationTotal(reportEntity.getB3OperationTotal());
			}
		}
		finally {
			reportEntity.close();
		}
	}

	/**
	 * PDF作成.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @param piContext
	 *            ServletContext
	 * @return PDFファイル名
	 * @exception Exception
	 *                実行例外
	 */
	public String makePDF(LACSDSReportBean piReportBean, ServletContext piContext) throws Exception {

		File wprlHomeDirectory = new File(PdfProperties.getInstance().getProperty(PdfProperties.WKC_PDF_HOME));
		File formFile = null;
		File datFile = null;

		File tmpFile = null; // 出力先ファイル
		FileOutputStream fout = null; // 出力ファイルストリーム

		Field field = null;

		LACSDSReportGoukeiBean detail = null;

		Report report = null; // WebKCoreレポートオブジェクト

		try {
			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
			formDirectory = new File(wprlHomeDirectory, FORM_PATH);

			tmpFile = File.createTempFile("pdf41_", ".pdf", scratchDirectory);
			fout = new FileOutputStream(tmpFile);
			formFile = new File(formDirectory, "DSGoukei.pdf");
			datFile = new File(formDirectory, "DSGoukei.dat");

			report = new Report(formFile, datFile, fout);

			for (int i = 0; i < piReportBean.getDataMax(); i++) {
				detail = piReportBean.getGoukeiBean(i);

				report.createPage(1);

				field = report.getField("xTerm");
				report.putFieldData(field, "対象期間：" + Convert.toDateString(detail.getTermFrom()) + "～" + Convert.toDateString(detail.getTermTo()));

				field = report.getField("xDate");
				report.putFieldData(field, Convert.toString(new Date(), Convert.FORMAT_YYYY_MM_DD));

				field = report.getField("xUserName");
				report.putFieldData(field, piReportBean.getLeasCompany().getName());

				field = report.getField("xB1A");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB1aLeaseAmount()));

				field = report.getField("xB1B");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB1bMtmrZanzonAmount()));

				field = report.getField("xB1C");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB1cRisokuAmount()));

				field = report.getField("xB1D");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB1dEkimuAmount()));

				field = report.getField("xB1E");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB1eIjiAmount()));

				field = report.getField("xB1F");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB1fGanpon()));

				field = report.getField("xB2TermFirst");
				report.putFieldData(field, Convert.toDateStringYM(detail.getTermFirstFrom()) + "～" + Convert.toDateStringYM(detail.getTermFirstTo()));

				field = report.getField("xB2TermSecond");
				report.putFieldData(field, Convert.toDateStringYM(detail.getTermSecondFrom()) + "～" + Convert.toDateStringYM(detail.getTermSecondTo()));

				field = report.getField("xB2TermThird");
				report.putFieldData(field, Convert.toDateStringYM(detail.getTermThirdFrom()) + "～" + Convert.toDateStringYM(detail.getTermThirdTo()));

				field = report.getField("xB2TermFourth");
				report.putFieldData(field, Convert.toDateStringYM(detail.getTermFourthFrom()) + "～" + Convert.toDateStringYM(detail.getTermFourthTo()));

				field = report.getField("xB2TermFifth");
				report.putFieldData(field, Convert.toDateStringYM(detail.getTermFifthFrom()) + "～" + Convert.toDateStringYM(detail.getTermFifthTo()));

				field = report.getField("xB2TermOver");
				report.putFieldData(field, Convert.toDateStringYM(detail.getTermOver()) + "～");

				field = report.getField("xB2FLFirst");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB2ItenFirst()));

				field = report.getField("xB2FLSecond");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB2ItenSecond()));

				field = report.getField("xB2FLThird");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB2ItenThird()));

				field = report.getField("xB2FLFourth");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB2ItenFourth()));

				field = report.getField("xB2FLFifth");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB2ItenFifth()));

				field = report.getField("xB2FLOver");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB2ItenOver()));

				field = report.getField("xB2GFLFirst");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB2ItengaiFirst()));

				field = report.getField("xB2GFLSecond");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB2ItengaiSecond()));

				field = report.getField("xB2GFLThird");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB2ItengaiThird()));

				field = report.getField("xB2GFLFourth");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB2ItengaiFourth()));

				field = report.getField("xB2GFLFifth");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB2ItengaiFifth()));

				field = report.getField("xB2GFLOver");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB2ItengaiOver()));

				field = report.getField("xB3TermFirst");
				report.putFieldData(field, Convert.toDateStringYM(detail.getTermFirstFrom()) + "～" + Convert.toDateStringYM(detail.getTermFirstTo()));

				field = report.getField("xB3TermOver");
				report.putFieldData(field, Convert.toDateStringYM(detail.getTermSecondFrom()) + "～");

				field = report.getField("xB3First");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB3OperationFirst()));

				field = report.getField("xB3Over");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB3OperationOver()));

				field = report.getField("xB3Total");
				report.putFieldData(field, StringUtl.formatNumber(detail.getB3OperationTotal()));

			}

			report.close();
			report = null;

			return tmpFile.getName();
		}
		finally {
			if (report != null) {
				try {
					report.close();
				}
				catch (ReportException e) {
				}
				report = null;
			}
			if (fout != null) {
				fout.close();
			}
		}
	}

	/**
	 * 減価償却方法名称取得.
	 * 
	 * @param piSkkHohoCd
	 *            減価償却方法コード
	 * @return 減価償却方法名称
	 * @exception Exception
	 *                実行例外
	 */
	public String getSkkHohoNm(String piSkkHohoCd) throws Exception {

		String skkHohoNm;

		if (piSkkHohoCd.equals(LACSDefine.ShoukyakuKeijoHohoKbn.TY_YSU_TGKHO_111) || piSkkHohoCd.equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_BKN_PS_TGKHO_121) || piSkkHohoCd.equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221)) {
			skkHohoNm = "定額法";
		}
		else if (piSkkHohoCd.equals(LACSDefine.ShoukyakuKeijoHohoKbn.TY_YSU_TRTHO_112) || piSkkHohoCd.equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_BKN_PS_TRTHO_122) || piSkkHohoCd.equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222)) {
			skkHohoNm = "定率法";
		}
		else {
			skkHohoNm = "級数法";
		}

		return skkHohoNm;

	}

	/**
	 * 利息計算方法名称取得.
	 * 
	 * @param piRskClcHohoCd
	 *            利息計算方法コード
	 * @return 利息計算方法名称
	 * @exception Exception
	 *                実行例外
	 */
	public String getRskClcHohoNm(String piRskClcHohoCd) throws Exception {

		String rskClcHohoNm;

		if (piRskClcHohoCd.equals(LACSDefine.RisokuKeijoHohoKbn.RSKHO_ZEN_GET_101) || piRskClcHohoCd.equals(LACSDefine.RisokuKeijoHohoKbn.RSKHO_ATO_GET_102)) {
			rskClcHohoNm = "利息法";
		}
		else if (piRskClcHohoCd.equals(LACSDefine.RisokuKeijoHohoKbn.KINTOHO_301)) {
			rskClcHohoNm = "均等法";
		}
		else {
			rskClcHohoNm = "利息無視法";
		}

		return rskClcHohoNm;

	}
}
