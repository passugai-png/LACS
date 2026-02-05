package jp.co.pro_app.lacs.affairs.karirisilist.html;

import jp.co.pro_app.lacs.affairs.common.html.LACSHTMLUtil;
import jp.co.pro_app.lacs.affairs.karirisi.bean.LACSKariRisiDetailBean;
import jp.co.pro_app.lacs.affairs.karirisilist.bean.LACSKariRisiListBean;
import jp.co.pro_app.projframe.common.html.HTMLUtil;

/**
 * リースユーザー別借入利子率マスタ一覧HTML生成.
 * 
 * @author active
 * @version 20071210
 * @author tatsumi
 * @version 20240911

 */
public class LACSKariRisiListHTMLUtil extends LACSHTMLUtil {

	/**
	 * 明細行生成.
	 * 
	 * @param piBean
	 *            リースユーザー別借入利子率マスタ一覧Bean
	 * @return 明細業
	 */
	public static String outHTMLList(LACSKariRisiListBean piBean) {

		StringBuffer buf = new StringBuffer();
		LACSKariRisiDetailBean detail = null;
		String bg = "";

		buf.append("				<table class=\"search-list-main\"> " + "\n");
		buf.append("					<tr class=\"cells-word-position-center\"> " + "\n");
		buf.append("						<th class=\"cells-width-four\"> " + "\n");
		buf.append("							開示先コード " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-five\"> " + "\n");
		buf.append("							開示先 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-four\"> " + "\n");
		buf.append("							現在の借入利子率" + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-two\"> " + "\n");
		buf.append("							件数 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-two\"> " + "\n");
		buf.append("							" + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-two\"> " + "\n");
		buf.append("							" + "\n");
		buf.append("						</th> " + "\n");
		buf.append("					</tr> " + "\n");

		for (int i = 0; i < piBean.getListCount(); i++) {
			detail = piBean.getDetail(i).getDetail(0);

			if (i % 2 == 0) {
				bg = " class=\"rows-ivory\"";
			}
			else {
				bg = " class=\"rows-blue\"";
			}

			buf.append("					<tr " + bg + "> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + detail.getCosmosCode() + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + detail.getUserName() + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
			buf.append("							" + detail.getRisiRitu() + " % " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
			buf.append("							" + detail.getCount() + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							<input type=\"button\" class=\"link-button\" value=\"修正\" onclick=\"javascript:editKariRisi('edit.karirisilist', '" + HTMLUtil.encode(detail.getCosmosCode()) + "')\" /> " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							<input type=\"button\" class=\"link-button\" value=\"削除\" onclick=\"javascript:deleteKariRisi('delete.karirisilist', '" + HTMLUtil.encode(detail.getCosmosCode()) + "')\" /> " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("					</tr> " + "\n");
		}

		buf.append("				</table> " + "\n");

		return buf.toString();
	}
}
