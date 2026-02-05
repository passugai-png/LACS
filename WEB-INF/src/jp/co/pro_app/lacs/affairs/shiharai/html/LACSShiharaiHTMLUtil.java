package jp.co.pro_app.lacs.affairs.shiharai.html;

import jp.co.pro_app.lacs.affairs.common.html.LACSHTMLUtil;
import jp.co.pro_app.lacs.affairs.shiharai.bean.LACSShiharaiBean;
import jp.co.pro_app.lacs.affairs.shiharai.bean.LACSShiharaiDetailBean;
import jp.co.pro_app.projframe.common.command.StringUtl;

/**
 * x•¥„ˆÚ•\HTML¶¬.
 * 
 * @author katoken
 * @version 20070312
 * @author tatsumi
 * @version 20240830
 */
public class LACSShiharaiHTMLUtil extends LACSHTMLUtil {

	/**
	 * –¾×s¶¬.
	 * 
	 * @param piBean
	 *            x•¥„ˆÚ•\Bean
	 * @return –¾×‹Æ
	 */
	public static String outHTMLList(LACSShiharaiBean piBean) {

		StringBuffer buf = new StringBuffer();
		LACSShiharaiDetailBean detail = null;
		String bg = "";

		buf.append("				<table class=\"search-list-main\"> " + "\n");
		buf.append("					<tr class=\"cells-word-position-center\"> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");

		buf.append("							x•¥”NŒ " + "\n");

		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");

		buf.append("							x•¥ƒŠ[ƒX—¿(Å”²) " + "\n");

		buf.append("						</th> " + "\n");
		buf.append("                        <th class=\"cells-width-three\"> " + "\n");

		buf.append("							x•¥ƒŠ[ƒX—¿<br /> " + "\n");
		buf.append("							(Á”ïÅ) " + "\n");

		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");

		buf.append("							‚¤‚¿ƒŠ[ƒXÂ–±•ª " + "\n");

		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");

		buf.append("							‚¤‚¿—˜‘§•ª " + "\n");

		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");

		buf.append("							ˆÛŠÇ—”ï‘Š“–Šz " + "\n");

		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");

		buf.append("							–ğ–±’ñ‹Ÿ”ï‘Š“–Šz " + "\n");

		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");

		buf.append("							Œ¸‰¿‹p‘Š“–Šz " + "\n");

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
			buf.append("							" + detail.getDate() + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
			buf.append("							" + StringUtl.formatNumber(detail.getLeasAmount()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
			buf.append("							" + StringUtl.formatNumber(detail.getStaxAmount()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
			buf.append("							" + StringUtl.formatNumber(detail.getGanponAmount()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
			buf.append("							" + StringUtl.formatNumber(detail.getRisokuAmount()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
			buf.append("							" + StringUtl.formatNumber(detail.getIjiAmount()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
			buf.append("							" + StringUtl.formatNumber(detail.getEkimuAmount()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
			buf.append("							" + StringUtl.formatNumber(detail.getShoukyakuAmount()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("					</tr> " + "\n");
		}

		buf.append("					</table> " + "\n");

		return buf.toString();
	}
}
