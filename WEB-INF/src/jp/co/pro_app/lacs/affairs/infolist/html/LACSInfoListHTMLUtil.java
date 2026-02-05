package jp.co.pro_app.lacs.affairs.infolist.html;

import jp.co.pro_app.lacs.affairs.common.html.LACSHTMLUtil;
import jp.co.pro_app.lacs.affairs.info.bean.LACSInfoBean;
import jp.co.pro_app.lacs.affairs.infolist.bean.LACSInfoListBean;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.html.HTMLUtil;

/**
 * Ç®ímÇÁÇπàÍóóHTMLê∂ê¨.
 * 
 * @author active
 * @version 20071210
 * @author tatsumi
 * @version 20240913
 */
public class LACSInfoListHTMLUtil extends LACSHTMLUtil {

	/**
	 * ñæç◊çsê∂ê¨.
	 * 
	 * @param piBean
	 *            Ç®ímÇÁÇπàÍóóBean
	 * @return ñæç◊ã∆
	 */
	public static String outHTMLList(LACSInfoListBean piBean) {

		StringBuffer buf = new StringBuffer();
		LACSInfoBean detail = null;
		String bg = "";

		buf.append("				<table class=\"search-list-main\"> " + "\n");
		buf.append("					<tr class=\"cells-word-position-center\"> " + "\n");
		buf.append("						<th class=\"cells-width-four\"> " + "\n");
		buf.append("							åfç⁄ä˙ä‘ " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-four\"> " + "\n");
		buf.append("							äJé¶êÊ " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-seven\"> " + "\n");
		buf.append("							ì‡óe " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-one\"> " + "\n");
		buf.append("							" + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-one\"> " + "\n");
		buf.append("							" + "\n");
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

			buf.append("					<tr " + bg + "> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(Convert.toString(Convert.toDate(detail.getStartYmd(), Convert.FORMAT_YYYYMMDD), Convert.FORMAT_YYYY_MM_DD)) + "\n");
			buf.append("							<span class=\"tilde\">Å`</span>" + "\n");
			buf.append("							" + HTMLUtil.encode(Convert.toString(Convert.toDate(detail.getEndYmd(), Convert.FORMAT_YYYYMMDD), Convert.FORMAT_YYYY_MM_DD)) + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.changeCRLFtoBR(HTMLUtil.encode(detail.getUserName()).replaceAll(" ", "&nbsp;") + " " + "\n"));
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.changeCRLFtoBR(HTMLUtil.encode(detail.getInfoData()).replaceAll(" ", "&nbsp;") + " " + "\n"));
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							<input type=\"button\" class=\"link-button\" value=\"èCê≥\" onclick=\"javascript:editInfo('edit.infolist', '" + HTMLUtil.encode(detail.getRowId()) + "')\" /> " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							<input type=\"button\" class=\"link-button\" value=\"çÌèú\" onclick=\"javascript:deleteInfo('delete.infolist', '" + HTMLUtil.encode(detail.getRowId()) + "')\" /> " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("					</tr> " + "\n");
		}

		buf.append("				</table> " + "\n");

		return buf.toString();
	}
}
