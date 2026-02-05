package jp.co.pro_app.lacs.affairs.shiwake.html;

import jp.co.pro_app.lacs.affairs.common.html.LACSHTMLUtil;
import jp.co.pro_app.lacs.affairs.shiwake.bean.LACSShiwakeBean;
import jp.co.pro_app.lacs.affairs.shiwake.bean.LACSShiwakeDetailBean;
import jp.co.pro_app.lacs.affairs.shiwake.bean.LACSShiwakeMonthBean;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.StringUtl;
import jp.co.pro_app.projframe.common.html.HTMLUtil;

/**
 * édñÛè∆âÔHTMLê∂ê¨.
 * 
 * @author katoken
 * @version 20070312
 * @author tatsumi
 * @version 20240902
 */
public class LACSShiwakeHTMLUtil extends LACSHTMLUtil {

	/**
	 * ñæç◊çsê∂ê¨.
	 * 
	 * @param piBean
	 *            édñÛè∆âÔBean
	 * @return ñæç◊çs
	 */
	public static String outHTMLList(LACSShiwakeBean piBean) {

		StringBuffer buf = new StringBuffer();
		LACSShiwakeMonthBean month = null;
		LACSShiwakeDetailBean detail = null;
		String preKrKmk = "";
		String preKsKmk = "";
		boolean krBlankSw = false;
		boolean ksBlankSw = false;

		String bg = "";

		buf.append("				<table class=\"search-list-main\"> " + "\n");
		buf.append("					<tr class=\"cells-word-position-center\"> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");

		buf.append("							éxï•îNåé " + "\n");

		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");

		buf.append("							éxï•ÉäÅ[ÉXóø(ê≈çû) " + "\n");

		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-four\"> " + "\n");
		buf.append("							éÿï˚â»ñ⁄ " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							éÿï˚ã‡äz " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("                        <th class=\"cells-width-four\"> " + "\n");
		buf.append("							ë›ï˚â»ñ⁄ " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							ë›ï˚ã‡äz " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("					</tr> " + "\n");

		for (int i = 0; i < piBean.getListCount(); i++) {
			month = piBean.getDetail(i);

			if (i % 2 == 0) {
				bg = " class=\"rows-ivory\"";
			}
			else {
				bg = " class=\"rows-blue\"";
			}

			preKrKmk = "";
			preKsKmk = "";

			for (int j = 0; j < month.size(); j++) {
				detail = month.get(j);

				krBlankSw = (detail.getKamokuAmountLKari() == 0 && (preKrKmk.equals(detail.getKamokuLKari())));
				ksBlankSw = (detail.getKamokuAmountRKashi() == 0 && (preKsKmk.equals(detail.getKamokuRKashi())));

				buf.append("					<tr" + bg + "> " + "\n");
				if (j == 0) {
					buf.append("						<td class=\"cells-word-position-left\" rowspan=\"" + month.size() + "\"> " + "\n");
					buf.append("							" + month.getDate() + " " + "\n");
					buf.append("                        </td> " + "\n");
					buf.append("						<td class=\"cells-word-position-right\" rowspan=\"" + month.size() + "\"> " + "\n");
					buf.append("							" + StringUtl.formatNumber(month.getLeasAmount()) + " " + "\n");
					buf.append("						</td> " + "\n");
				}
				buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
				if (krBlankSw) {
					buf.append("							&nbsp; " + "\n");
				}
				else {
					buf.append("							" + HTMLUtil.encode(Command.init(detail.getKamokuLKari(), "")) + " " + "\n");
				}
				buf.append("						</td> " + "\n");
				buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
				if (krBlankSw) {
					buf.append("							&nbsp; " + "\n");
				}
				else {
					buf.append("							" + StringUtl.formatNumber(detail.getKamokuAmountLKari()) + " " + "\n");
				}
				buf.append("						</td> " + "\n");
				buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
				if (ksBlankSw) {
					buf.append("							&nbsp; " + "\n");
				}
				else {
					buf.append("							" + HTMLUtil.encode(Command.init(detail.getKamokuRKashi(), "")) + " " + "\n");
				}
				buf.append("						</td> " + "\n");
				buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
				if (ksBlankSw) {
					buf.append("							&nbsp; " + "\n");
				}
				else {
					buf.append("							" + StringUtl.formatNumber(detail.getKamokuAmountRKashi()) + " " + "\n");
				}
				buf.append("						</td> " + "\n");
				buf.append("					</tr> " + "\n");

				preKrKmk = detail.getKamokuLKari();
				preKsKmk = detail.getKamokuRKashi();
			}
		}

		buf.append("				</table> " + "\n");

		return buf.toString();
	}
}
