package jp.co.pro_app.lacs.affairs.syousai.html;

import jp.co.pro_app.lacs.affairs.common.bean.LACSReportDetailBean;
import jp.co.pro_app.lacs.affairs.common.html.LACSHTMLUtil;
import jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiBean;
import jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiDetailBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.StringUtl;

/**
 * 契約詳細HTML生成.
 * 
 * @author yokota
 * @version 20081017
 * @author tatsumi
 * @version 20240906
 */
public class LACSSyousaiHTMLUtil extends LACSHTMLUtil {

	/**
	 * PDFファイルパス.
	 * 
	 * @param piBean
	 *            契約詳細Bean
	 * @param piPdfPath
	 *            PDFファイルパス
	 * @param piReport
	 *            帳票名
	 * @param piWindowName
	 *            ウィンドウ名
	 * @return PDFファイルパス&lt;a$gt;タグ
	 */
	public static String outHTMLPdfPath(LACSSyousaiBean piBean, String piPdfPath, String piReport, String piWindowName) {

		StringBuffer buf = new StringBuffer();

		if (piPdfPath.trim().length() == 0) {
			buf.append(piReport);
		}
		else {
			buf.append("<a href='#' onclick=\"javascript:downloadCSV('" + piPdfPath + "');return false;\">" + piReport + "</a>");
		}

		return buf.toString();
	}

	/**
	 * ファイルパス.
	 * 
	 * @param piBean
	 *            契約詳細Bean
	 * @param piDetail
	 *            出力対象帳票Bean
	 * @param piReport
	 *            帳票名
	 * @param piWindowName
	 *            ウィンドウ名
	 * @return PDFファイルパス&lt;a$gt;タグ
	 */
	public static String outHTMLPdfPath(LACSSyousaiBean piBean, LACSReportDetailBean piDetail, String piReport, String piWindowName) {

		StringBuffer buf = new StringBuffer();

		if (piDetail.getFileName().trim().length() == 0) {
			buf.append(piReport);
		}
		else {
			buf.append("<a href='#' onclick=\"javascript:downloadCSV('" + piDetail.getFileName() + "');return false;\">" + piReport + "</a>");

		}

		return buf.toString();
	}

	/**
	 * 明細行生成.
	 * 
	 * @param piBean
	 *            契約詳細Bean
	 * @return 明細業
	 */
	public static String outHTMLList(LACSSyousaiBean piBean) {

		StringBuffer buf = new StringBuffer();
		LACSSyousaiDetailBean detail = null;
		String bg = "";

		buf.append("				<table class=\"search-list-main\"> " + "\n");
		buf.append("					<tr class=\"cells-word-position-center\"> " + "\n");
		buf.append("						<th class=\"cells-width-two\"> " + "\n");
		buf.append("							物件番号 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							物件名 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-two\"> " + "\n");
		buf.append("							機械番号<br /> " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-six\"> " + "\n");
		buf.append("							固定資産科目 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-two\"> " + "\n");
		buf.append("							設置場所 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-one\"> " + "\n");
		buf.append("							数量 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-one\"> " + "\n");
		buf.append("							単位 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-six\"> " + "\n");
		buf.append("							取得価格相当額 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-six\"> " + "\n");
		buf.append("							割引計算利子率 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-six\"> " + "\n");
		buf.append("							利息計算利子率 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							採用償却計上方法 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-six\"> " + "\n");
		buf.append("							残価保証有無 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							維持管理費相当額 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							役務提供費相当額 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("					</tr> " + "\n");

		for (int i = 0; i < piBean.getListCount(); i++) {
			detail = piBean.getDetail(i);

			if (i % 2 == 0) {
				bg = " class=\"rows-ivory\"";
			}
			else {
				bg = " class=\"rows-blue\"";
			}

			buf.append("					<tr" + bg + "> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + detail.getBukkenNo() + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + detail.getBukkenName() + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + detail.getKikaiNo() + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + detail.getSisanSyuruiName() + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + detail.getSettiBasyo() + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
			buf.append("							" + StringUtl.formatNumber(detail.getSuryo()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + detail.getTani() + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
			buf.append("							" + StringUtl.formatNumber(detail.getBknWaribikiGenzaiKati()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
			buf.append("							" + StringUtl.formatNumber(detail.getWaribikiKeisanRisiRitu(), "###,##0.0000") + "% " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
			if (LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201.equals(detail.getRskKeijHohoKbn())) {
				buf.append("						&nbsp;\n");
			}
			else {
				buf.append("						" + StringUtl.formatNumber(detail.getRisokuKeisanRisiRitu(), "###,##0.0000") + "% " + "\n");
			}
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + detail.getSaiyoSkkKeijoKbnName() + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + detail.getZankaHosyoUmu() + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
			buf.append("							" + StringUtl.formatNumber(detail.getIjikanriHi()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
			buf.append("							" + StringUtl.formatNumber(detail.getEkimuteikyoHi()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("					</tr> " + "\n");
		}

		buf.append("				</table> " + "\n");

		return buf.toString();
	}

	/**
	 * ヘッダー生成.
	 * 
	 * @param piBean
	 *            契約詳細Bean
	 * @return ヘッダー欄
	 */
	public static String outHTMLHeader(LACSSyousaiBean piBean) {

		StringBuffer buf = new StringBuffer();

		buf.append("				<table class=\"search-list-main\"> " + "\n");
		buf.append("					<tr> " + "\n");
		buf.append("					<td class=\"rows-blue-title\" >開示先</td> " + "\n");
		buf.append("					<td class=\"cells-left\" colspan=\"5\"> " + "\n");
		buf.append("						" + piBean.getKaijisakiName() + " " + "\n");
		buf.append("					</td> " + "\n");
		buf.append("					<td class=\"rows-blue-title\" >リース期間</td> " + "\n");
		buf.append("					<td class=\"cells-left\"> " + "\n");
		buf.append("						" + piBean.getLeaseTerm() + "ヶ月" + "\n");
		buf.append("					</td> " + "\n");
		buf.append("					</tr> " + "\n");
		buf.append("					<tr> " + "\n");
		buf.append("						<td class=\"rows-blue-title\" >契約日</td> " + "\n");
		buf.append("						<td class=\"cells-left\"> " + "\n");
		buf.append("							" + piBean.getKeiyakuYmd() + " " + "\n");
		buf.append("						</td> " + "\n");
		buf.append("						<td class=\"rows-blue-title\" >検収日</td> " + "\n");
		buf.append("						<td class=\"cells-left\"> " + "\n");
		buf.append("							" + piBean.getKensyuYmd() + " " + "\n");
		buf.append("						</td> " + "\n");
		buf.append("						<td class=\"rows-blue-title\" >満了日</td> " + "\n");
		buf.append("						<td class=\"cells-left\"> " + "\n");
		buf.append("							" + piBean.getManryoYmd() + " " + "\n");
		buf.append("						</td> " + "\n");
		buf.append("						<td class=\"rows-blue-title\" >中途解約日</td> " + "\n");
		buf.append("						<td class=\"cells-left\"> " + "\n");
		buf.append("							" + piBean.getKaiyakuYmd() + " " + "\n");
		buf.append("						</td> " + "\n");
		buf.append("					</tr> " + "\n");
		buf.append("					<tr> " + "\n");
		buf.append("						<td class=\"rows-blue-title\" >リース取引分類</td> " + "\n");
		buf.append("						<td class=\"cells-left\" colspan=\"7\"> " + "\n");
		buf.append("							" + piBean.getLeasTradeBunruiName() + " " + "\n");
		buf.append("						</td> " + "\n");
		buf.append("					</tr> " + "\n");
		buf.append("					<tr> " + "\n");
		buf.append("						<td class=\"rows-blue-title\" >代表物件</td> " + "\n");
		buf.append("						<td class=\"cells-left\" colspan=\"7\"> " + "\n");
		buf.append("							" + piBean.getDaihyoBukkenName() + " " + "\n");
		buf.append("						</td> " + "\n");
		buf.append("					</tr> " + "\n");
		buf.append("					<tr> " + "\n");
		buf.append("						<td class=\"rows-blue-title\" colspan=\"2\" >譲渡条件</td> " + "\n");
		buf.append("						<td class=\"cells-left\" colspan=\"2\"> " + "\n");
		buf.append("							" + piBean.getJoutoJoukenName() + " " + "\n");
		buf.append("						</td> " + "\n");
		buf.append("						<td class=\"rows-blue-title\" colspan=\"2\">割安購入選択権</td> " + "\n");
		buf.append("						<td class=\"cells-left\"  colspan=\"2\" nowrap> " + "\n");
		buf.append("							" + piBean.getWariyasuKonyuSentakuKenName() + " " + "\n");
		buf.append("						</td> " + "\n");
		buf.append("					</tr> " + "\n");
		buf.append("					<tr> " + "\n");
		buf.append("						<td class=\"rows-blue-title\" colspan=\"2\" >特別仕様物件</td> " + "\n");
		buf.append("						<td class=\"cells-left\" colspan=\"2\"> " + "\n");
		buf.append("							" + piBean.getTokubetiSiyoBukkenName() + " " + "\n");
		buf.append("						</td> " + "\n");
		buf.append("						<td class=\"rows-blue-title\" colspan=\"2\">中途解約</td> " + "\n");
		buf.append("						<td class=\"cells-left\" colspan=\"2\"> " + "\n");
		buf.append("							" + piBean.getTyutoKaiyakuName() + " " + "\n");
		buf.append("						</td> " + "\n");
		buf.append("					</tr> " + "\n");
		buf.append("					<tr> " + "\n");
		buf.append("						<td class=\"rows-blue-title\" colspan=\"2\" >リース資産計上額</td> " + "\n");
		buf.append("						<td class=\"cells-right\" colspan=\"2\"> " + "\n");
		buf.append("							" + StringUtl.formatNumber(piBean.getKeiWaribikiGenzaiKati()) + " " + "\n");
		buf.append("						</td> " + "\n");
		buf.append("						<td class=\"rows-blue-title\" colspan=\"2\">契約額</td> " + "\n");
		buf.append("						<td class=\"cells-right\" colspan=\"2\"> " + "\n");
		buf.append("							" + StringUtl.formatNumber(piBean.getLeaseRyouSogaku()) + " " + "\n");
		buf.append("						</td> " + "\n");
		buf.append("					</tr> " + "\n");
		buf.append("					<tr> " + "\n");
		buf.append("						<td class=\"rows-blue-title\" colspan=\"2\" >見積現金購入価格</td> " + "\n");
		buf.append("						<td class=\"cells-right\" colspan=\"2\"> " + "\n");
		buf.append("							" + StringUtl.formatNumber(piBean.getMitumoriGenkinKakaku()) + " " + "\n");
		buf.append("						</td> " + "\n");
		buf.append("						<td class=\"rows-blue-title\" colspan=\"2\">消費税総額</td> " + "\n");
		buf.append("						<td class=\"cells-right\" colspan=\"2\"> " + "\n");
		buf.append("							" + StringUtl.formatNumber(piBean.getTaxSougaku()) + " " + "\n");
		buf.append("						</td> " + "\n");
		buf.append("					</tr> " + "\n");
		buf.append("					<tr> " + "\n");
		buf.append("					<td class=\"rows-blue-title\" colspan=\"2\" >支払利息相当額総額</td> " + "\n");
		buf.append("					<td class=\"cells-right\" colspan=\"2\"> " + "\n");
		buf.append("						" + StringUtl.formatNumber(piBean.getRisokuSoutouSougaku()) + " " + "\n");
		buf.append("					</td> " + "\n");
		buf.append("					<td class=\"rows-blue-title\"   colspan=\"2\">残価保証額</td> " + "\n");
		buf.append("					<td class=\"cells-right\" colspan=\"2\"> " + "\n");
		buf.append("						" + StringUtl.formatNumber(piBean.getZanHosyou()) + " " + "\n");
		buf.append("					</td> " + "\n");
		buf.append("					</tr> " + "\n");
		buf.append("					<tr> " + "\n");
		buf.append("					<td class=\"rows-blue-title\" colspan=\"2\" >維持管理費相当額総額</td> " + "\n");
		buf.append("					<td class=\"cells-right\" colspan=\"2\"> " + "\n");
		buf.append("						" + StringUtl.formatNumber(piBean.getIjikanriHiSougaku()) + " " + "\n");
		buf.append("					</td> " + "\n");
		buf.append("					<td class=\"rows-blue-title\"  colspan=\"2\">役務提供費相当額総額</td> " + "\n");
		buf.append("					<td class=\"cells-right\" colspan=\"2\"> " + "\n");
		buf.append("						" + StringUtl.formatNumber(piBean.getEkimuteikyoHiSougaku()) + " " + "\n");
		buf.append("					</td> " + "\n");
		buf.append("				</tr> " + "\n");
		buf.append("				<tr> " + "\n");
		buf.append("					<td class=\"rows-blue-title\" colspan=\"2\" >利息相当配分方法</td> " + "\n");
		buf.append("					<td class=\"cells-left\" colspan=\"6\"> " + "\n");
		buf.append("						" + piBean.getRisokuHaibunHohouName() + " " + "\n");
		buf.append("					</td> " + "\n");
		buf.append("				</tr> " + "\n");
		buf.append("				<tr> " + "\n");
		buf.append("					<td class=\"rows-blue-title\" colspan=\"2\" >リース料計算基準</td> " + "\n");
		buf.append("					<td class=\"cells-left\" colspan=\"6\"> " + "\n");
		buf.append("						" + piBean.getLeaseRyouKeisanKijunName() + " " + "\n");
		buf.append("					</td> " + "\n");
		buf.append("				</tr> " + "\n");
		buf.append("				<tr> " + "\n");
		buf.append("					<td class=\"rows-blue-title\" colspan=\"2\" >減価償却端数調整方法</td> " + "\n");
		buf.append("					<td class=\"cells-left\" colspan=\"6\"> " + "\n");
		buf.append("						" + piBean.getGnkskHasuChoseiHohouName() + " " + "\n");
		buf.append("					</td> " + "\n");
		buf.append("				</tr> " + "\n");
		buf.append("				<tr> " + "\n");
		buf.append("					<td class=\"rows-blue-title\" colspan=\"2\" >少額資産</td> " + "\n");
		buf.append("					<td class=\"cells-left\" colspan=\"6\"> " + "\n");
		buf.append("						" + piBean.getSyougakuSisanName() + " " + "\n");
		buf.append("					</td> " + "\n");
		buf.append("				</tr> " + "\n");
		buf.append("			</table> " + "\n");

		return buf.toString();
	}

}
