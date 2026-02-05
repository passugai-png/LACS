package jp.co.pro_app.lacs.affairs.karirisi.html;

import jp.co.pro_app.lacs.affairs.common.html.LACSHTMLUtil;
import jp.co.pro_app.lacs.affairs.karirisi.bean.LACSKariRisiBean;
import jp.co.pro_app.lacs.affairs.karirisi.bean.LACSKariRisiDetailBean;

/**
 * リースユーザー別借入利子率マスタHTML生成.
 * 
 * @author ohmura
 * @version 20070918
 * @author tatsumi
 * @version 20240911
 */
public class LACSKariRisiHTMLUtil extends LACSHTMLUtil {

	/**
	 * 明細行生成.
	 * 
	 * @param piBean
	 *            リースユーザ別借入利子率マスタBean
	 * @return 明細業
	 */
	public static String outHTMLList(LACSKariRisiBean piBean) {

		StringBuffer buf = new StringBuffer();
		LACSKariRisiDetailBean detail = null;

		buf.append("				<table class=\"search-list-main\"> " + "\n");
		buf.append("					<tr class=\"cells-word-position-center\"> " + "\n");
		buf.append("						<th class=\"cells-width-one\"></th> " + "\n");
		buf.append("						<th class=\"cells-width-five\"> " + "\n");
		buf.append("							適用期間 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							借入利子率 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("					</tr> " + "\n");

		for (int i = 0; i < piBean.getListCount(); i++) {
			detail = piBean.getDetail(i);
			buf.append("					<tr> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\">" + (i + 1)  + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							<input type=\"text\" class=\"textbox-six\" size=\"10\" " + "\n");
			buf.append("								value=\"" + encode(detail.getKikanFrom()) + "\"" + "\n");
			buf.append("								\" name=\"kikanFrom" + i + "\"" + "\n");
			buf.append("								maxlength=\"8\" > " + "\n");
			buf.append("							<span class=\"tilde\">～</span> " + "\n");
			buf.append("							<input type=\"text\" class=\"textbox-six\" size=\"10\" " + "\n");
			buf.append("								value=\"" + encode(detail.getKikanTo()) + "\"" + "\n");
			buf.append("								\" name=\"kikanTo" + i + "\"" + "\n");
			buf.append("								maxlength=\"8\"> " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							<input type=\"text\" class=\"textbox-six\" size=\"13\" " + "\n");
			buf.append("								value=\"" + encode(detail.getRisiRitu()) + "\"" + "\n");
			buf.append("								\" name=\"risiRitu" + i + "\"" + "\n");
			buf.append("								maxlength=\"10\"> " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("					</tr> " + "\n");
		}

		buf.append("				</table> " + "\n");

		return buf.toString();
	}

}
