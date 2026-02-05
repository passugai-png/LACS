package jp.co.pro_app.lacs.affairs.companylist.html;

import jp.co.pro_app.lacs.affairs.common.html.LACSHTMLUtil;
import jp.co.pro_app.lacs.affairs.company.bean.LACSCompanyBean;
import jp.co.pro_app.lacs.affairs.companylist.bean.LACSCompanyListBean;
import jp.co.pro_app.projframe.common.html.HTMLUtil;

/**
 * リース会社マスタ一覧HTML生成.
 * 
 * @author active
 * @version 20071210
 * @tatsumi 20240920
 */
public class LACSCompanyListHTMLUtil extends LACSHTMLUtil {

	/**
	 * 明細行生成.
	 * 
	 * @param piBean
	 *            リース会社マスタ一覧Bean
	 * @return 明細業
	 */
	public static String outHTMLList(LACSCompanyListBean piBean) {

		StringBuffer buf = new StringBuffer();
		LACSCompanyBean detail = null;
		String bg = "";

		buf.append("				<table class=\"search-list-main\"> " + "\n");
		buf.append("					<tr class=\"cells-word-position-center\"> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							リース会社コード " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-five\"> " + "\n");
		buf.append("							名称 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-five\"> " + "\n");
		buf.append("							住所 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							担当者部署 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							担当者 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							担当電話番号 " + "\n");
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
			buf.append("							" + HTMLUtil.encode(detail.getLeasCompanyCode()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getName()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getAddress1()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getBusyo()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getTanto()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getTantoTel()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							<input type=\"button\" class=\"link-button\" value=\"修正\" onclick=\"javascript:editCompany('search.company', '" + HTMLUtil.encode(detail.getLeasCompanyCode()) + "')\" /> " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							<input type=\"button\" class=\"link-button\" value=\"削除\" onclick=\"javascript:deleteCompany('delete.companylist', '" + HTMLUtil.encode(detail.getLeasCompanyCode()) + "')\" /> " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("					</tr> " + "\n");
		}

		buf.append("				</table> " + "\n");

		return buf.toString();
	}
}
