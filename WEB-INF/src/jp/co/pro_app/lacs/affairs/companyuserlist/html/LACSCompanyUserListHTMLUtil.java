package jp.co.pro_app.lacs.affairs.companyuserlist.html;

import jp.co.pro_app.lacs.affairs.common.html.LACSHTMLUtil;
import jp.co.pro_app.lacs.affairs.companyuser.bean.LACSCompanyUserBean;
import jp.co.pro_app.lacs.affairs.companyuserlist.bean.LACSCompanyUserListBean;
import jp.co.pro_app.projframe.common.html.HTMLUtil;

/**
 * リース会社別リースユーザーマスタ一覧HTML生成.
 * 
 * @author active
 * @version 20071210
 * @author tatsumi
 * @version 20240917
 */
public class LACSCompanyUserListHTMLUtil extends LACSHTMLUtil {

	/**
	 * 明細行生成.
	 * 
	 * @param piBean
	 *            リース会社別リースユーザーマスタ一覧Bean
	 * @return 明細業
	 */
	public static String outHTMLList(LACSCompanyUserListBean piBean) {

		StringBuffer buf = new StringBuffer();
		LACSCompanyUserBean detail = null;
		String bg = "";

		buf.append("				<table class=\"search-list-main\"> " + "\n");
		buf.append("					<tr class=\"cells-word-position-center\"> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							取引先コード " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							開示先コード " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-five\"> " + "\n");
		buf.append("							開示先 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-one\"> " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-one\"> " + "\n");
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
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getTorihikiCode()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getCosmosCode()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getUserName()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							<input type=\"button\" class=\"link-button\" value=\"修正\" onclick=\"javascript:editCompanyUser('edit.companyuserlist', '" + HTMLUtil.encode(detail.getLeasCompanyCode()) + "', '" + HTMLUtil.encode(detail.getTorihikiCode()) + "')\" /> " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							<input type=\"button\" class=\"link-button\" value=\"削除\" onclick=\"javascript:deleteCompanyUser('delete.companyuserlist', '" + HTMLUtil.encode(detail.getLeasCompanyCode()) + "', '" + HTMLUtil.encode(detail.getTorihikiCode()) + "')\" /> " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("					</tr> " + "\n");
		}

		buf.append("				</table> " + "\n");

		return buf.toString();
	}
}
