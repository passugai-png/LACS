package jp.co.pro_app.lacs.affairs.syousai.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiBean;
import jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiDetailBean;
import jp.co.pro_app.lacs.affairs.syousai.data.entity.LACSSyousaiDetailEntity;
import jp.co.pro_app.lacs.affairs.syousai.data.entity.LACSSyousaiEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;
import wkc.pdf.PdfProperties;
import wkc.pdf.tool.Field;
import wkc.pdf.tool.Report;
import wkc.pdf.tool.ReportException;

/**
 * 契約詳細帳票出力：契約詳細表 Model.
 * 
 * @author yokota
 * @version 20081017
 */
public class LACSReportPDFKeiyakuSyousaiWriter extends LACSReportPDFWriterBase {

	private final int	page1Max	= 5;	// １ページ目の最大行

	private final int	page2Max	= 12;	// ２ページ目以降の最大行

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
	public LACSReportPDFKeiyakuSyousaiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
	}

	/**
	 * 出力データ取得.
	 * 
	 * @param piSyousaiBean
	 *            契約詳細Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	public void getData(LACSSyousaiBean piSyousaiBean) throws SQLException {
		LACSSyousaiEntity syousaiEntity = new LACSSyousaiEntity(super.model, commonBean, piSyousaiBean);
		LACSSyousaiDetailEntity detailEntity = new LACSSyousaiDetailEntity(super.model);
		LACSSyousaiDetailBean detailBean = null;

		try {
			syousaiEntity.setCon(super.con);

			syousaiEntity.setKeiyakuNo(piSyousaiBean.getKeiyakuNo());
			syousaiEntity.setLeasCompanyCode(piSyousaiBean.getLeasCompanyCode());
			syousaiEntity.execSQL();
			int dataCount = 0;

			if (syousaiEntity.next()) {

				piSyousaiBean.setCreateDate(syousaiEntity.getCreateDate());
				piSyousaiBean.setKaijisakiName(syousaiEntity.getKaijisakiName());
				piSyousaiBean.setLeasCompanyNm(syousaiEntity.getLeaseCompanyNm());
				piSyousaiBean.setKeiyakuNo(syousaiEntity.getKeiyakuNo());
				piSyousaiBean.setHyoujiKeiyakuNo(syousaiEntity.getHyoujiKeiyakuNo());
				piSyousaiBean.setLeaseTerm(syousaiEntity.getLeaseTerm());
				piSyousaiBean.setKeiyakuYmd(syousaiEntity.getKeiyakuYmd());
				piSyousaiBean.setKensyuYmd(syousaiEntity.getKensyuYmd());
				piSyousaiBean.setManryoYmd(syousaiEntity.getManryoYmd());
				piSyousaiBean.setKaiyakuYmd(syousaiEntity.getKaiyakuYmd());
				piSyousaiBean.setDaihyoBukkenName(syousaiEntity.getDaihyoBukkenName());
				piSyousaiBean.setJoutoJoukenName(syousaiEntity.getJoutoJoukenName());
				piSyousaiBean.setWariyasuKonyuSentakuKenName(syousaiEntity.getWariyasuKonyuSentakuKenName());
				piSyousaiBean.setTokubetiSiyoBukkenName(syousaiEntity.getTokubetiSiyoBukkenName());
				piSyousaiBean.setTyutoKaiyakuName(syousaiEntity.getTyutoKaiyakuName());
				piSyousaiBean.setLeasTradeBunruiName(syousaiEntity.getTradeHanteiKekkaName());
				piSyousaiBean.setKeiWaribikiGenzaiKati(syousaiEntity.getKeiWaribikiGenzaiKati());
				piSyousaiBean.setLeaseRyouSogaku(syousaiEntity.getLeaseRyouSogaku());
				piSyousaiBean.setMitumoriGenkinKakaku(syousaiEntity.getMitumoriGenkinKakaku());
				piSyousaiBean.setTaxSougaku(syousaiEntity.getTaxSougaku());
				piSyousaiBean.setRisokuSoutouSougaku(syousaiEntity.getRisokuSoutouSougaku());
				piSyousaiBean.setZanHosyou(syousaiEntity.getZanHosyou());
				piSyousaiBean.setIjikanriHiSougaku(syousaiEntity.getIjikanriHiSougaku());
				piSyousaiBean.setEkimuteikyoHiSougaku(syousaiEntity.getEkimuteikyoHiSougaku());
				piSyousaiBean.setRisokuHaibunHohouName(syousaiEntity.getRisokuHaibunHohouName());
				piSyousaiBean.setLeaseRyouKeisanKijunName(syousaiEntity.getLeaseRyouKeisanKijunName());
				piSyousaiBean.setGnkskHasuChoseiHohouName(syousaiEntity.getGnkskHasuChoseiHohouName());
				piSyousaiBean.setSyougakuSisanName(syousaiEntity.getSyougakuSisanName());

				detailEntity.setCon(super.con);

				detailEntity.setKeiyakuNo(piSyousaiBean.getKeiyakuNo());
				detailEntity.setLeasCompanyCode(piSyousaiBean.getLeasCompanyCode());

				detailEntity.execSQL();
				while (detailEntity.next()) {

					detailBean = new LACSSyousaiDetailBean();
					piSyousaiBean.addDetail(detailBean);

					detailBean.setBukkenNo(detailEntity.getBukkenNo());
					detailBean.setBukkenName(detailEntity.getBukkenName());
					detailBean.setKikaiNo(detailEntity.getKikaiNo());
					detailBean.setSisanSyuruiName(detailEntity.getSisanSyuruiName());
					detailBean.setSettiBasyo(detailEntity.getSettiBasyo());
					detailBean.setSuryo(detailEntity.getSuryo());
					detailBean.setTani(detailEntity.getTani());
					detailBean.setBknWaribikiGenzaiKati(detailEntity.getBknWaribikiGenzaiKati());
					detailBean.setWaribikiKeisanRisiRitu(detailEntity.getWaribikiKeisanRisiRitu());
					detailBean.setRisokuKeisanRisiRitu(detailEntity.getRisokuKeisanRisiRitu());
					detailBean.setSaiyoSkkKeijoKbnName(detailEntity.getSaiyoSkkKeijoKbnName());
					detailBean.setZankaHosyoUmu(detailEntity.getZankaHosyoUmu());
					detailBean.setIjikanriHi(detailEntity.getIjikanriHi());
					detailBean.setEkimuteikyoHi(detailEntity.getEkimuteikyoHi());
					detailBean.setRskKeijHohoKbn(detailEntity.getRskKeijHohoKbn());
					dataCount++;
				}

			}
			piSyousaiBean.setDataMax(dataCount);

		}
		finally {
			syousaiEntity.close();
			detailEntity.close();
		}
	}

	/**
	 * PDF作成.
	 * 
	 * @param piSyousaiBean
	 *            契約詳細Bean
	 * @param piDateMode
	 *            西暦和暦モード
	 * @param piContext
	 *            ServletContext
	 * @return PDFファイル名
	 * @exception Exception
	 *                実行例外
	 */
	public String makePDF(LACSSyousaiBean piSyousaiBean, String piDateMode, ServletContext piContext) throws Exception {
		Report report = null; // WebKCoreレポートオブジェクト
		LACSSyousaiDetailBean detail = null;

		File wprlHomeDirectory = new File(PdfProperties.getInstance().getProperty(PdfProperties.WKC_PDF_HOME));
		File formFile = null;
		File datFile = null;
		Field field = null;

		File tmpFile = null; // 出力先ファイル
		FileOutputStream fout = null; // 出力ファイルストリーム

		scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));
		formDirectory = new File(wprlHomeDirectory, FORM_PATH);
		report = null; // WebKCoreレポートオブジェクト
		detail = null;
		int pageCount = 1;
		int meisaiCount = 0;
		String pIdx = "";

		int souPage = 0; // 総ページ数
		double numResult = 0;

		try {

			tmpFile = File.createTempFile("pdf31_", ".pdf", scratchDirectory);
			fout = new FileOutputStream(tmpFile);
			formFile = new File(formDirectory, "Syousai.pdf");
			datFile = new File(formDirectory, "Syousai.dat");
			report = new Report(formFile, datFile, fout);

			numResult = piSyousaiBean.getDataMax() - page1Max;
			numResult = Math.ceil(numResult / page2Max);
			souPage = 1 + (int)numResult;

			for (int i = 0; i < piSyousaiBean.getDataMax(); i++) {
				detail = piSyousaiBean.getDetail(i);
				if (i == 0) {

					report.createPage(1);

					// field = report.getField("xPageTittle"); // ページ
					// report.putFieldData(field, "ページ :");
					// field = report.getField("xDateTittle"); // 作成日
					// report.putFieldData(field, "作成日 :");
					// field = report.getField("xTaniTittle"); // 単位
					// report.putFieldData(field, "単位 :");
					field = report.getField("xTaniKigo"); // 単位
					report.putFieldData(field, "円");

					field = report.getField("xPage" + pIdx); // ページ

					report.putFieldData(field, StringUtl.formatNumber(pageCount) + "/" + souPage);
					headPrint(report, piSyousaiBean, piDateMode);
					meisaiHaedPrint(report, detail, piDateMode, pIdx);

					field = report.getField("xDate");
					report.putFieldData(field, super.convertReki(Convert.toString(new Date()), piDateMode));
				}
				if (pageCount == 1) {
					if (meisaiCount == page1Max) {

						report.createPage(2);
						pIdx = "2";
						pageCount++;

						// field = report.getField("xPageTittle"); // ページ
						// report.putFieldData(field, "ページ :");
						// field = report.getField("xDateTittle"); // 作成日
						// report.putFieldData(field, "作成日 :");
						// field = report.getField("xTaniTittle"); // 単位
						// report.putFieldData(field, "単位 :");
						field = report.getField("xTaniKigo"); // 単位
						report.putFieldData(field, "円");

						field = report.getField("xPage" + pIdx); // ページ
						report.putFieldData(field, StringUtl.formatNumber(pageCount) + "/" + souPage);

						meisaiHaedPrint(report, detail, piDateMode, pIdx);

						field = report.getField("xDate");
						report.putFieldData(field, super.convertReki(Convert.toString(new Date()), piDateMode));

						// field = report.getField("xLeaseCompanyTittle"); // リース会社名
						// report.putFieldData(field, "リース会社名:");

						field = report.getField("xLeaseCompany"); // リース会社名
						report.putFieldData(field, piSyousaiBean.getLeasCompanyNm());

						field = report.getField("xLeaseUserNm"); // リースユーザ名
						report.putFieldData(field, piSyousaiBean.getKaijisakiName());

						field = report.getField("xKeiNo"); // 契約番号
						report.putFieldData(field, piSyousaiBean.getHyoujiKeiyakuNo());

						meisaiCount = 0;
					}
				}
				else {
					if (meisaiCount == page2Max) {

						report.createPage(2);
						pIdx = "2";
						pageCount++;

						// field = report.getField("xPageTittle"); // ページ
						// report.putFieldData(field, "ページ :");
						// field = report.getField("xDateTittle"); // 作成日
						// report.putFieldData(field, "作成日 :");
						// field = report.getField("xTaniTittle"); // 単位
						// report.putFieldData(field, "単位 :");
						field = report.getField("xTaniKigo"); // 単位
						report.putFieldData(field, "円");

						field = report.getField("xPage" + pIdx); // ページ
						meisaiHaedPrint(report, detail, piDateMode, pIdx);
						report.putFieldData(field, StringUtl.formatNumber(pageCount) + "/" + souPage);

						field = report.getField("xDate");
						report.putFieldData(field, super.convertReki(Convert.toString(new Date()), piDateMode));

						// field = report.getField("xLeaseCompanyTittle"); // リース会社名
						// report.putFieldData(field, "リース会社名:");
						field = report.getField("xLeaseCompany"); // リース会社名
						report.putFieldData(field, piSyousaiBean.getLeasCompanyNm());

						field = report.getField("xLeaseUserNm"); // リースユーザ名
						// report.putFieldData(field, piSyousaiBean.getLeasCompanyNm());
						report.putFieldData(field, piSyousaiBean.getKaijisakiName());

						field = report.getField("xKeiNo"); // 契約番号
						report.putFieldData(field, piSyousaiBean.getHyoujiKeiyakuNo());
						meisaiCount = 0;
					}
				}

				field = report.getField("xBknNo" + pIdx + "." + meisaiCount); // 物件番号
				report.putFieldData(field, detail.getBukkenNo());

				field = report.getField("xBknNm" + pIdx + "." + meisaiCount); // 物件名
				report.putFieldData(field, detail.getBukkenName());

				field = report.getField("xKiiNo" + pIdx + "." + meisaiCount); // 機械番号
				report.putFieldData(field, detail.getKikaiNo());

				field = report.getField("xSsnSri" + pIdx + "." + meisaiCount); // 資産種類
				report.putFieldData(field, detail.getSisanSyuruiName());

				field = report.getField("xSuryo" + pIdx + "." + meisaiCount); // 数量
				report.putFieldData(field, StringUtl.formatNumber(detail.getSuryo()));

				field = report.getField("xTani" + pIdx + "." + meisaiCount); // 単位
				report.putFieldData(field, detail.getTani());

				field = report.getField("xSettiBasyo" + pIdx + "." + meisaiCount); // 設置場所
				report.putFieldData(field, detail.getSettiBasyo());

				field = report.getField("xBknWaribikiGenzaiKati" + pIdx + "." + meisaiCount); // 割引現在価値（物件）
				report.putFieldData(field, StringUtl.formatNumber(detail.getBknWaribikiGenzaiKati()));

				field = report.getField("xWaribikiKeisanRisiRitu" + pIdx + "." + meisaiCount); // 割引計算利子率
				report.putFieldData(field, StringUtl.formatNumber(detail.getWaribikiKeisanRisiRitu(), "###,##0.0000") + "%");

				field = report.getField("xRisokuKeisanRisiRitu" + pIdx + "." + meisaiCount); // 利息計算利子率
				if (LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201.equals(detail.getRskKeijHohoKbn())) {
					report.putFieldData(field, "");
				}
				else {
					report.putFieldData(field, StringUtl.formatNumber(detail.getRisokuKeisanRisiRitu(), "###,##0.0000") + "%");
				}
				field = report.getField("xSaiyoSkkKeijoKbnNm" + pIdx + "." + meisaiCount); // 償却計上方法
				report.putFieldData(field, detail.getSaiyoSkkKeijoKbnName());

				field = report.getField("xZankaHosyoUmu" + pIdx + "." + meisaiCount); // 残価保証有無
				report.putFieldData(field, detail.getZankaHosyoUmu());

				field = report.getField("xIjikanriHi" + pIdx + "." + meisaiCount); // 維持管理費
				report.putFieldData(field, StringUtl.formatNumber(detail.getIjikanriHi()));

				field = report.getField("xEkimuteikyoHi" + pIdx + "." + meisaiCount); // 役務提供費
				report.putFieldData(field, StringUtl.formatNumber(detail.getEkimuteikyoHi()));

				field = report.getField("xComment");
				report.putFieldData(field, COMMENT);

				meisaiCount++;
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
	 * ヘッダ部出力.
	 * 
	 * @param piReport
	 *            レポート
	 * @param piSyousai
	 *            出力情報
	 * @param piDateMode
	 *            西暦和暦モード
	 * @exception Exception
	 *                例外
	 */
	private void headPrint(Report piReport, LACSSyousaiBean piSyousai, String piDateMode) throws Exception {
		Field field = null;
		// field = piReport.getField("xLeaseCompanyTittle"); // リース会社名
		// piReport.putFieldData(field, "リース会社名:");
		field = piReport.getField("xLeaseCompanyNm"); // リース会社名
		piReport.putFieldData(field, piSyousai.getLeasCompanyNm());

		field = piReport.getField("xLeaseUserNm"); // リースユーザ名

		piReport.putFieldData(field, piSyousai.getKaijisakiName());
		field = piReport.getField("xKeiNo"); // 契約番号

		piReport.putFieldData(field, piSyousai.getHyoujiKeiyakuNo());

		field = piReport.getField("xKeiTerm"); // 期間
		piReport.putFieldData(field, piSyousai.getLeaseTerm() + " ヶ月");

		field = piReport.getField("xKeiYmd"); // 契約日
		piReport.putFieldData(field, super.convertReki(piSyousai.getKeiyakuYmd(), piDateMode));

		field = piReport.getField("xKnshuYmd"); // 検収日
		piReport.putFieldData(field, super.convertReki(piSyousai.getKensyuYmd(), piDateMode));

		field = piReport.getField("xMryoYmd"); // 満了日
		piReport.putFieldData(field, super.convertReki(piSyousai.getManryoYmd(), piDateMode));

		field = piReport.getField("xKaiyakuYmd"); // 解約日
		piReport.putFieldData(field, super.convertReki(piSyousai.getKaiyakuYmd(), piDateMode));

		field = piReport.getField("xDihBknNm"); // 代表物件名
		piReport.putFieldData(field, piSyousai.getDaihyoBukkenName());

		field = piReport.getField("xJoutoJoukenNm"); // 譲渡条件
		piReport.putFieldData(field, piSyousai.getJoutoJoukenName());

		field = piReport.getField("xWariyasuKonyuSentakuKenNm"); // 割安購入選択権
		piReport.putFieldData(field, piSyousai.getWariyasuKonyuSentakuKenName());

		field = piReport.getField("xTokubetiSiyoBukkenNm"); // 特別仕様物件
		piReport.putFieldData(field, piSyousai.getTokubetiSiyoBukkenName());

		field = piReport.getField("xTyutoKaiyakuNm"); // 中途解約
		piReport.putFieldData(field, piSyousai.getTyutoKaiyakuName());

		field = piReport.getField("xLeasTradeBunruiNm"); // リース取引分類
		piReport.putFieldData(field, piSyousai.getLeasTradeBunruiName());

		field = piReport.getField("xKeiWaribikiGenzaiKati"); // 割引現在価値（契約）
		piReport.putFieldData(field, StringUtl.formatNumber(piSyousai.getKeiWaribikiGenzaiKati()));

		field = piReport.getField("xLeaseRyouSogaku"); // リース料総額
		piReport.putFieldData(field, StringUtl.formatNumber(piSyousai.getLeaseRyouSogaku()));

		field = piReport.getField("xMitumoriGenkinKakaku"); // 見積購入価額
		piReport.putFieldData(field, StringUtl.formatNumber(piSyousai.getMitumoriGenkinKakaku()));

		field = piReport.getField("xTaxSougaku"); // 消費税総額
		piReport.putFieldData(field, StringUtl.formatNumber(piSyousai.getTaxSougaku()));

		field = piReport.getField("xRisokuSoutouSougaku"); // 支払利息相当額総額
		piReport.putFieldData(field, StringUtl.formatNumber(piSyousai.getRisokuSoutouSougaku()));

		field = piReport.getField("xZanHosyou"); // 残価保証額
		piReport.putFieldData(field, StringUtl.formatNumber(piSyousai.getZanHosyou()));

		field = piReport.getField("xIjikanriHiSougaku"); // 維持管理費総額
		piReport.putFieldData(field, StringUtl.formatNumber(piSyousai.getIjikanriHiSougaku()));

		field = piReport.getField("xEkimuteikyoHiSougaku"); // 役務提供総額
		piReport.putFieldData(field, StringUtl.formatNumber(piSyousai.getEkimuteikyoHiSougaku()));

		field = piReport.getField("xRisokuHaibunHohouNm"); // 利息配分方法名称
		piReport.putFieldData(field, piSyousai.getRisokuHaibunHohouName());

		field = piReport.getField("xLeaseRyouKeisanKijunNm"); // リース料計算基準
		piReport.putFieldData(field, piSyousai.getLeaseRyouKeisanKijunName());

		field = piReport.getField("xGnkskHasuChoseiHohouNm"); // 減価償却端数調整方法名称
		piReport.putFieldData(field, piSyousai.getGnkskHasuChoseiHohouName());

		field = piReport.getField("xSyougakuSsnNm"); // 少額資産名称
		piReport.putFieldData(field, piSyousai.getSyougakuSisanName());

		field = piReport.getField("xComment");
		piReport.putFieldData(field, COMMENT);

	}

	/**
	 * 明細ヘッダ部出力.
	 * 
	 * @param piReport
	 *            レポート
	 * @param piDetail
	 *            出力情報
	 * @param piDateMode
	 *            西暦和暦モード
	 * @param piIdx
	 *            ページ識別
	 * @exception Exception
	 *                SQL実行例外
	 */
	private void meisaiHaedPrint(Report piReport, LACSSyousaiDetailBean piDetail, String piDateMode, String piIdx) throws Exception {

	}

	/**
	 * 出力データ取得2.
	 * 
	 * @param piSyousaiDetail
	 *            契約詳細明細Bean
	 * @return 帳票データ
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected ArrayList<Object> getData2(LACSSyousaiDetailBean piSyousaiDetail) throws SQLException {
		return null;
	}

}
