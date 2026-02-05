package jp.co.pro_app.lacs.affairs.common.html;

import java.math.BigDecimal;
import java.math.RoundingMode;

import jp.co.pro_app.lacs.affairs.common.bean.LACSBeanBase;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSDateBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSDispControlBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSReportDetailBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.bean.PageBeanBase;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.StringUtl;
import jp.co.pro_app.projframe.common.html.HTMLUtil;

/**
 * 共通HTML生成.
 * 
 * @author katoken
 * @version 20070312
 * @author tatsumi
 * @version 20240920
 */
public class LACSHTMLUtil extends HTMLUtil {

	/**
	 * ヘッダー部生成.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @return ヘッダー部
	 */
	public static String outHTMLHeader(LACSCommonBean piCommonBean) {
		StringBuffer buf = new StringBuffer();

		String importDate = "";
		LACSMenuData data = LACSMenuData.getData(piCommonBean, true);
		LACSMenuDataLine line = null;
		LACSMenuDataLineDetail detail = null;
		String scriptName = "";

		importDate = piCommonBean.getShoriYMD();
		boolean errorSw = piCommonBean.getErrorFlg().equals("1");

		buf.append("					<div class=\"common-header-size\"> " + "\n");
		buf.append("						<div class=\"section-ratio-one\"> " + "\n");
		buf.append("							<img src=\"img/logo.gif\" class=\"img-logo\" /> " + "\n");
		buf.append("						</div> " + "\n");
		buf.append("						<div class=\"section-ratio-one\"> " + "\n");
		buf.append("							<div class=\"common-header-date\"> " + "\n");
		buf.append("								処理済年月：" + Command.init(importDate, "") + " ");
		buf.append("							</div> " + "\n");
		buf.append("							<div class=\"common-header-transition\"> " + "\n");

		for (int i = 0; i < data.size(); i++) {

			line = data.get(i);

			buf.append("								<div class=\"common-header-section\"> " + "\n");

			for (int j = 0; j < line.size(); j++) {
				detail = line.get(j);

				scriptName = (detail.getActionMode() == 0) ? "post" : "openWindow";

				if (j > 0) {
					buf.append("<span class=\"tilde\">|</span>");
				}

				if (detail.getDispID().equals("O000")) {
					buf.append("<span class=\"common-header-word\" onclick=\"javascript:" + scriptName + "('" + detail.getUrl() + "')\">");
				}
				else {
					if (!detail.getDispID().equals(piCommonBean.getDispID()) && !errorSw) {
						buf.append("<span class=\"common-header-word\" onclick=\"javascript:" + scriptName + "('" + detail.getUrl() + "')\">");
					}
				}

				buf.append(detail.getDispName());

				if (detail.getDispID().equals("O000")) {
					buf.append("</span>");
				}
				else {
					if (!detail.getDispID().equals(piCommonBean.getDispID()) && !errorSw) {
						buf.append("</span>");
					}
				}

				buf.append("\n");
			}

			buf.append("								</div> " + "\n");
		}

		buf.append("							</div> " + "\n");
		buf.append("						</div> " + "\n");
		buf.append("					</div> " + "\n");

		return buf.toString();
	}

	/**
	 * ページ制御生成.
	 * 
	 * @param piBean
	 *            ページBean
	 * @return ページ制御部
	 */
	public static String outHTMLPageChange(PageBeanBase piBean) {
		StringBuffer buf = new StringBuffer();

		boolean first = false;
		boolean last = false;
		double count = piBean.getDataMax();
		int current = piBean.getCurrent();
		int per = piBean.getPer();
		int max = 0;
		String pageSevlet = piBean.getPageServlet();

		if (current <= 1) {
			first = true;
		}

		if (count <= (per * (current))) {
			last = true;
		}

		max = new BigDecimal(count / per).setScale(0, RoundingMode.UP).intValue();
		
		buf.append("				<div class=\"page-position-front\"> ");
		
		if (!first) {
			buf.append("					<span class=\"common-header-word\" onclick=\"javascript:setPage(" + (current - 1) + ", '" + pageSevlet + "')\">");
		}

		buf.append("＜前の" + per + "件へ");

		if (!first) {
			buf.append("					</span>");
		}
		
		buf.append("				</div> " + "\n");
		buf.append("				<div class=\"page-position-number\"> ");

		buf.append("					<select class=\"pulldown-seven\" onchange=\"setComboPage(this, '" + pageSevlet + "')\"> " + "\n");

		for (int i = 1; i <= max; i++) {
			buf.append("						<option value=\"" + i + "\"" + (i == current ? " selected" : "") + ">" + i + "</option> " + "\n");
		}

		buf.append("					</select> " + "\n");
		buf.append("					<span class=\"tilde\">/</span>" + max + "ページ" + "\n");
		buf.append("				</div> " + "\n");
		buf.append("				<div class=\"page-position-next\"> ");

		if (!last) {
			buf.append("					<span class=\"common-header-word\" onclick=\"javascript:setPage(" + (current + 1) + ", '" + pageSevlet + "')\">");
		}

		buf.append("次の" + per + "件へ＞");

		if (!last) {
			buf.append("					</span>");
		}
		
		buf.append("				</div> " + "\n");
		
		return buf.toString();
	}

	/**
	 * 日付フィールド生成.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piField
	 *            日付フィールドデータ
	 * @return 日付フィールド部
	 */
	public static String outHTMLDateInputField(LACSCommonBean piCommonBean, LACSDateBean piField) {
		StringBuffer buf = new StringBuffer();

		if (piCommonBean.getDateMode().equals(LACSDefine.DateMode.SEIREKI)) {
			buf.append("<input type=\"text\" class=\"textbox-six\" name=\"" + piField.getName() + "Data\" maxlength=\"7\" ");
			buf.append("value=\"" + HTMLUtil.encode(piField.getInputString1() + (piField.getInputString2().trim().length() > 0 ? StringUtl.formatNumber(piField.getInputString2(), "00") : "")) + "\" />");
		}
		else {
			buf.append("<select class=\"pulldown-three\" name=\"" + piField.getName() + "Era\">");
			buf.append(HTMLUtil.outHTMLCombo(piField.getEra()));
			buf.append("</select>");

			buf.append("<input type=\"text\" class=\"textbox-three\" name=\"" + piField.getName() + "Data\" maxlength=\"7\" ");
			buf.append("value=\"" + HTMLUtil.encode(piField.getInputString1()) + "\" />年");

			buf.append("<input type=\"text\" class=\"textbox-one\" name=\"" + piField.getName() + "Month\" maxlength=\"7\" ");
			buf.append("value=\"" + HTMLUtil.encode(piField.getInputString2()) + "\" />月");
		}

		return buf.toString();
	}

	/**
	 * 日付フィールド生成.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piField
	 *            日付フィールドデータ
	 * @return 日付フィールド部
	 */
	public static String outHTMLDateInputFieldYMD(LACSCommonBean piCommonBean, LACSDateBean piField) {
		StringBuffer buf = new StringBuffer();

		if (piCommonBean.getDateMode().equals(LACSDefine.DateMode.SEIREKI)) {
			if (piField.isPlane()) {
				buf.append("<input type=\"hidden\" name=\"" + piField.getName() + "Data\" ");
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString1()) + "\" />");

				buf.append("<input type=\"hidden\" name=\"" + piField.getName() + "Month\" ");
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString2()) + "\" />");

				buf.append("<input type=\"hidden\" name=\"" + piField.getName() + "Day\"  ");
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString3()) + "\" >");

				buf.append(HTMLUtil.encode(piField.getInputString1()) + "年 ");

				buf.append(HTMLUtil.encode(piField.getInputString2()) + "月 ");

				buf.append(HTMLUtil.encode(piField.getInputString3()) + "日");
			}
			else {
				buf.append("<input type=\"text\" class=\"textbox-three\" name=\"" + piField.getName() + "Data\" maxlength=\"4\" ");
				
				if (piField.getOnChange().trim().length() > 0) {
					buf.append("onchange=\"" + piField.getOnChange() + "\" ");
				}
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString1()) + "\" />年 ");

				buf.append("<input type=\"text\" class=\"textbox-one\" name=\"" + piField.getName() + "Month\" maxlength=\"2\" ");
				if (piField.getOnChange().trim().length() > 0) {
					buf.append("onchange=\"" + piField.getOnChange() + "\" ");
				}
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString2()) + "\" />月 ");

				buf.append("<input type=\"text\" class=\"textbox-one\" name=\"" + piField.getName() + "Day\" maxlength=\"2\"");
				if (piField.getOnChange().trim().length() > 0) {
					buf.append("onchange=\"" + piField.getOnChange() + "\" ");
				}
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString3()) + "\" >日");
			}
		}
		else {
			if (piField.isPlane()) {
				buf.append("<input type=\"hidden\" name=\"" + piField.getName() + "Era\" ");
				buf.append("value=\"" + HTMLUtil.encode(piField.getEra().getValue()) + "\" />");
				buf.append(piField.getEra().getName());

				buf.append("<input type=\"hidden\" name=\"" + piField.getName() + "Data\" ");
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString1()) + "\" />");

				buf.append("<input type=\"hidden\" name=\"" + piField.getName() + "Month\" ");
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString2()) + "\" />");

				buf.append("<input type=\"hidden\" name=\"" + piField.getName() + "Day\"  ");
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString3()) + "\" >");

				buf.append(HTMLUtil.encode(piField.getInputString1()) + "年 ");
				buf.append(HTMLUtil.encode(piField.getInputString2()) + "月 ");
				buf.append(HTMLUtil.encode(piField.getInputString3()) + "日");
			}
			else {
				buf.append("<select class=\"pulldown-three\" name=\"" + piField.getName() + "Era\"");
				
				if (piField.getOnChange().trim().length() > 0) {
					buf.append("onchange=\"" + piField.getOnChange() + "\" ");
				}
				
				buf.append(">");
				buf.append(HTMLUtil.outHTMLCombo(piField.getEra()));
				buf.append("</select>");

				buf.append("<input type=\"text\" class=\"textbox-three\" name=\"" + piField.getName() + "Data\" maxlength=\"4\" ");
				
				if (piField.getOnChange().trim().length() > 0) {
					buf.append("onchange=\"" + piField.getOnChange() + "\" ");
				}
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString1()) + "\" />年 ");

				buf.append("<input type=\"text\" class=\"textbox-one\" name=\"" + piField.getName() + "Month\" maxlength=\"2\" ");
				
				if (piField.getOnChange().trim().length() > 0) {
					buf.append("onchange=\"" + piField.getOnChange() + "\" ");
				}
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString2()) + "\" />月 ");

				buf.append("<input type=\"text\" class=\"textbox-one\" name=\"" + piField.getName() + "Day\"  ");
				
				if (piField.getOnChange().trim().length() > 0) {
					buf.append("onchange=\"" + piField.getOnChange() + "\" ");
				}
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString3()) + "\" />日");
			}
		}

		return buf.toString();
	}

	/**
	 * 日付フィールド生成.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piField
	 *            日付フィールドデータ
	 * @return 日付フィールド部
	 */
	public static String outHTMLDateInputFieldYM(LACSCommonBean piCommonBean, LACSDateBean piField) {
		StringBuffer buf = new StringBuffer();

		if (piCommonBean.getDateMode().equals(LACSDefine.DateMode.SEIREKI)) {
			if (piField.isPlane()) {
				buf.append("<input type=\"hidden\" name=\"" + piField.getName() + "Data\" ");
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString1()) + "\" />");

				buf.append("<input type=\"hidden\" name=\"" + piField.getName() + "Month\" ");
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString2()) + "\" />");

				buf.append("<input type=\"hidden\" name=\"" + piField.getName() + "Day\"  ");
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString3()) + "\" >");

				buf.append(HTMLUtil.encode(piField.getInputString1()) + "年 ");
				buf.append(HTMLUtil.encode(piField.getInputString2()) + "月 ");
				buf.append(HTMLUtil.encode(piField.getInputString3()) + "日");
			}
			else {
				buf.append("<input type=\"text\" class=\"textbox-three\" name=\"" + piField.getName() + "Data\" maxlength=\"4\" ");
				
				if (piField.getOnChange().trim().length() > 0) {
					buf.append("onchange=\"" + piField.getOnChange() + "\" ");
				}
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString1()) + "\" />年 ");

				buf.append("<input type=\"text\" class=\"textbox-one\" name=\"" + piField.getName() + "Month\" maxlength=\"2\" ");
				
				if (piField.getOnChange().trim().length() > 0) {
					buf.append("onchange=\"" + piField.getOnChange() + "\" ");
				}
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString2()) + "\" />月 ");

				buf.append("<input type=\"hidden\" name=\"" + piField.getName() + "Day\"  ");
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString3()) + "\" >");
				buf.append(HTMLUtil.encode(piField.getInputString3()) + "日");

				// buf.append("<input type=\"text\" name=\"" + piField.getName() + "Day\" maxlength=\"2\"");
				// buf.append("style=\"width:20px\" ");
				// if (piField.getOnChange().trim().length() > 0) {
				// buf.append("onchange=\"" + piField.getOnChange() + "\" ");
				// }
				// buf.append("value=\"" + HTMLUtil.encode(piField.getInputString3()) + "\" >日");
			}
		}
		else {
			if (piField.isPlane()) {
				buf.append("<input type=\"hidden\" name=\"" + piField.getName() + "Era\" ");
				buf.append("value=\"" + HTMLUtil.encode(piField.getEra().getValue()) + "\" />");
				buf.append(piField.getEra().getName());

				buf.append("<input type=\"hidden\" name=\"" + piField.getName() + "Data\" ");
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString1()) + "\" />");

				buf.append("<input type=\"hidden\" name=\"" + piField.getName() + "Month\" ");
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString2()) + "\" />");

				buf.append("<input type=\"hidden\" name=\"" + piField.getName() + "Day\"  ");
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString3()) + "\" >");

				buf.append(HTMLUtil.encode(piField.getInputString1()) + "年 ");
				buf.append(HTMLUtil.encode(piField.getInputString2()) + "月 ");
				buf.append(HTMLUtil.encode(piField.getInputString3()) + "日");
			}
			else {
				buf.append("<select name=\"" + piField.getName() + "Era\"");
				if (piField.getOnChange().trim().length() > 0) {
					buf.append("onchange=\"" + piField.getOnChange() + "\" ");
				}
				buf.append(">");
				buf.append(HTMLUtil.outHTMLCombo(piField.getEra()));
				buf.append("</select>");

				buf.append("<input type=\"text\" class=\"textbox-three\" name=\"" + piField.getName() + "Data\" maxlength=\"4\" ");
				
				if (piField.getOnChange().trim().length() > 0) {
					buf.append("onchange=\"" + piField.getOnChange() + "\" ");
				}
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString1()) + "\" />年 ");

				buf.append("<input type=\"text\" class=\"textbox-one\" name=\"" + piField.getName() + "Month\" maxlength=\"2\" ");
				
				if (piField.getOnChange().trim().length() > 0) {
					buf.append("onchange=\"" + piField.getOnChange() + "\" ");
				}
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString2()) + "\" />月 ");

				buf.append("<input type=\"hidden\" name=\"" + piField.getName() + "Day\"  ");
				buf.append("value=\"" + HTMLUtil.encode(piField.getInputString3()) + "\" >");
				buf.append(HTMLUtil.encode(piField.getInputString3()) + "日");
				// buf.append("<input type=\"text\" name=\"" + piField.getName() + "Day\" ");
				// buf.append("style=\"width:20px\" ");
				// if (piField.getOnChange().trim().length() > 0) {
				// buf.append("onchange=\"" + piField.getOnChange() + "\" ");
				// }
				// buf.append("value=\"" + HTMLUtil.encode(piField.getInputString3()) + "\" />日");
			}
		}

		return buf.toString();
	}

	/**
	 * 表示権限チェックボックスHTML出力.
	 * 
	 * @param piDispControlBean
	 *            LACS用権限制御Bean
	 * @param piControlID
	 *            コントロールコード
	 * @param piTabIndex
	 *            タブインデックス
	 * @param piDisplayName
	 *            表示名
	 * @return 表示権限チェックボックスHTML
	 */
	public static String outHTMLDisplayControl(LACSDispControlBean piDispControlBean, String piControlID, int piTabIndex, String piDisplayName) {
		StringBuffer buf = new StringBuffer();
		
		buf.append("<label> " + "\n");
		buf.append("	<input type=\"checkbox\" class=\"checkbox\" name=\"chk" + piControlID + "\" value=\"1\" tabindex=\"" + piTabIndex + "\" " + ("1".equals(piDispControlBean.get(piControlID)) ? " checked" : "") + "/>" + piDisplayName + " " + "\n");
		buf.append("</label> " + "\n");
		
		return buf.toString();
	}

	/**
	 * ファイルパス.
	 * 
	 * @param piBean
	 *            帳票出力Bean
	 * @param piDetail
	 *            出力対象帳票Bean
	 * @param piReport
	 *            帳票名
	 * @param piWindowName
	 *            ウィンドウ名
	 * @return PDFファイルパス&lt;a$gt;タグ
	 */
	public static String outHTMLPdfPath(LACSBeanBase piBean, LACSReportDetailBean piDetail, String piReport, String piWindowName) {

		StringBuffer buf = new StringBuffer();

		if (piDetail.getFileName().trim().length() == 0) {
			buf.append(piReport);
		}
		else {
			if (piBean.getOutputMode() == 1) {
				buf.append("<a href=\'" + piDetail.getFileName() + "\' target=\'" + piWindowName + "\' >" + piReport + "</a>");
				buf.append(" <img src=\"img/acrobat.gif\" class=\"img-acrobat\"/>");
				
			}
			else {
				buf.append("<a href='#' onclick=\"javascript:downloadCSV('" + piDetail.getFileName() + "');return false;\">" + piReport + "</a>");
			}
		}

		return buf.toString();
	}

}
