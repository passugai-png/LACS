package jp.co.pro_app.lacs.affairs.tantolist.html;

import jp.co.pro_app.lacs.affairs.common.html.LACSHTMLUtil;
import jp.co.pro_app.lacs.affairs.tantolist.bean.LACSTantoListBean;
import jp.co.pro_app.lacs.affairs.tantolist.bean.LACSTantoListDetailBean;
import jp.co.pro_app.projframe.common.html.HTMLUtil;

/**
 * リースユーザー担当者マスタ一覧HTML生成.
 * 
 * @author active
 * @version 20071210
 * @author tatsumi
 * @version 20240912
 */
public class LACSTantoListHTMLUtil extends LACSHTMLUtil {

	/**
	 * 明細行生成.
	 * 
	 * @param piBean
	 *            リースユーザー担当者マスタ一覧Bean
	 * @return 明細業
	 */
	public static String outHTMLList(LACSTantoListBean piBean) {

		StringBuffer buf = new StringBuffer();
		LACSTantoListDetailBean detail = null;
		String bg = "";
		String disabled = "";

		buf.append("				<table class=\"search-list-main\"> " + "\n");
		buf.append("					<tr class=\"cells-word-position-center\"> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							ユーザID " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-five\" style=\"width: 300px\"> " + "\n");
		buf.append("							開示先 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\" style=\"width: 120px\"> " + "\n");
		buf.append("							担当者名 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\" style=\"width: 80px\"> " + "\n");
		buf.append("							利用者権限 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\" style=\"width: 80px\"> " + "\n");
		buf.append("							有効期限 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\" style=\"width: 80px\"> " + "\n");
		buf.append("							状態 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-two\" style=\"width: 45px\"> " + "\n");
		buf.append("							" + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-two\" style=\"width: 45px\"> " + "\n");
		buf.append("							" + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-two\" style=\"width: 45px\"> " + "\n");
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

			if ("3".equals(detail.getTantJtiKbn())) {
				disabled = "";
			}
			else {
				disabled = " disabled";
			}

			buf.append("					<tr " + bg + "> " + "\n");
			buf.append("						<td calss=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getUserID()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td calss=\"cells-word-position-left\"> " + "\n");
			for (int j = 0; j < detail.getUserName().size(); j++) {
				buf.append("							" + HTMLUtil.encode(((String)detail.getUserName().get(j))) + "<br> " + "\n");
			}
			buf.append("						</td> " + "\n");
			buf.append("						<td calss=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getUserTantoName()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getUserRightName()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getPasswordYukoTerm()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getTantJtiKbnName()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							<input type=\"button\" class=\"link-button\" value=\"修正\" onclick=\"javascript:editTanto('edit.tantolist', '" + HTMLUtil.encode(detail.getUserID()) + "', '" + detail.getUserRight() + "')\" /> " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							<input type=\"button\" class=\"link-button\" value=\"削除\" onclick=\"javascript:deleteTanto('delete.tantolist', '" + HTMLUtil.encode(detail.getUserID()) + "')\" /> " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							<input type=\"button\" class=\"link-button\" value=\"解除\" onclick=\"javascript:unlockTanto('unlock.tantolist', '" + HTMLUtil.encode(detail.getUserID()) + "')\"" + disabled + " /> " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("					</tr> " + "\n");
		}

		buf.append("				</table> " + "\n");

		return buf.toString();
	}
}
