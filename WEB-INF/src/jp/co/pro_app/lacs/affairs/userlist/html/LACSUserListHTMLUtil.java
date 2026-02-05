package jp.co.pro_app.lacs.affairs.userlist.html;

import jp.co.pro_app.lacs.affairs.common.html.LACSHTMLUtil;
import jp.co.pro_app.lacs.affairs.user.bean.LACSUserBean;
import jp.co.pro_app.lacs.affairs.userlist.bean.LACSUserListBean;
import jp.co.pro_app.projframe.common.html.HTMLUtil;

/**
 * リースユーザーマスタ一覧HTML生成.
 * 
 * @author active
 * @version 20071210
 * @author tatsumi
 * @version 20240910
 */
public class LACSUserListHTMLUtil extends LACSHTMLUtil {

	/**
	 * 明細行生成.
	 * 
	 * @param piBean
	 *            リースユーザーマスタ一覧Bean
	 * @return 明細業
	 */
	public static String outHTMLList(LACSUserListBean piBean) {

		StringBuffer buf = new StringBuffer();
		LACSUserBean detail = null;
		String bg = "";

		buf.append("				<table class=\"search-list-main\"> " + "\n");
		buf.append("					<tr class=\"cells-word-position-center\"> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							開示先コード " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-four\"> " + "\n");
		buf.append("							開示先 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-five\"> " + "\n");
		buf.append("							住所 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							電話番号 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-four\"> " + "\n");
		buf.append("							担当者名 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-two\"> " + "\n");
		buf.append("							" + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-two\"> " + "\n");
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
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getUserCosmosCode()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getUserName()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getUserAddress1()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getUserTelNo()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getUserTantoName()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							<input type=\"button\" class=\"link-button\" value=\"修正\" onclick=\"javascript:editUser('edit.userlist', '" + HTMLUtil.encode(detail.getUserCosmosCode()) + "')\" /> " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							<input type=\"button\" class=\"link-button\" value=\"削除\" onclick=\"javascript:deleteUser('delete.userlist', '" + HTMLUtil.encode(detail.getUserCosmosCode()) + "')\" /> " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("					</tr> " + "\n");
		}

		buf.append("				</table> " + "\n");

		return buf.toString();
	}
}
