package jp.co.pro_app.lacs.affairs.keiyaku.html;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.html.LACSHTMLUtil;
import jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuBean;
import jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuDetailBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.html.HTMLUtil;

/**
 * 契約検索HTML生成.
 * 
 * @author katoken
 * @version 20070312
 * @author tatsumi
 * @version 20240905
 */
public class LACSKeiyakuHTMLUtil extends LACSHTMLUtil {

	/**
	 * 明細行生成.
	 * 
	 * @param piBean
	 *            契約検索Bean
	 * @param piCommonBean
	 *            LACS共通Bean
	 * @return 明細業
	 */
	public static String outHTMLList(LACSKeiyakuBean piBean, LACSCommonBean piCommonBean) {
		StringBuffer buf = new StringBuffer();
		LACSKeiyakuDetailBean detail = null;

		String bg = "";
		String kaiyaku = "";

		buf.append("				<table class=\"search-list-main\"> " + "\n");
		buf.append("					<tr class=\"cells-word-position-center\"> " + "\n");
		buf.append("						<th class=\"cells-width-five\"> " + "\n");
		if (piCommonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {

			buf.append("							開示先 " + "\n");

		}
		else {
			buf.append("							リース会社 " + "\n");
		}
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							契約番号 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");

		buf.append("							リース取引分類 " + "\n");

		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							検収日 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							満了日<br /> " + "\n");

		buf.append("							中途解約日 " + "\n");

		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-one\"> " + "\n");
		buf.append("							解約 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-two\"> " + "\n");

		buf.append("							契約期間 " + "\n");

		buf.append("						</th> " + "\n");

		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							代表物件名 " + "\n");
		buf.append("						</th> " + "\n");

		if (piCommonBean.getDispControl().isAvailable("G0000001")) {
			buf.append("						<th class=\"cells-width-three\"> " + "\n");
			buf.append("							支払推移表 " + "\n");
			buf.append("						</th> " + "\n");
		}
		if (piCommonBean.getDispControl().isAvailable("G0000002")) {
			buf.append("						<th class=\"cells-width-two\"> " + "\n");
			buf.append("							仕訳照会 " + "\n");
			buf.append("						</th> " + "\n");
		}
		if (piCommonBean.getDispControl().isAvailable("P0000011")) {
			buf.append("						<th class=\"cells-width-two\"> " + "\n");
			buf.append("							会計明細 " + "\n");
			buf.append("						</th> " + "\n");
		}

		buf.append("						</tr> " + "\n");

		for (int i = 0; i < piBean.getListCount(); i++) {
			detail = piBean.getDetail(i);

			if (detail.getKaiyakuYMD() != null && detail.getKaiyakuYMD().trim().length() > 0) {
				kaiyaku = "解";
			}

			if (i % 2 == 0) {
				bg = " class=\"rows-ivory\"";
			}
			else {
				bg = " class=\"rows-blue\"";
			}

			buf.append("					<tr " + bg + "> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			if (piCommonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {
				buf.append("							" + HTMLUtil.encode(detail.getLeaseUserName()) + " " + "\n");
			}
			else {
				buf.append("							" + HTMLUtil.encode(detail.getLeasCompanyName()) + " " + "\n");
			}
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");

			if (piCommonBean.getDispControl().isAvailable("G0000008")) {
				buf.append("							<a href=\"javascript:setKeiyaku('detail.keiyaku', '" + HTMLUtil.encode(detail.getKeiyakuNo()) + "','" + HTMLUtil.encode(detail.getHyoujiKeiyakuNo()) + "', null, null, '" + HTMLUtil.encode(detail.getCosmosCode()) + "', '" + HTMLUtil.encode(detail.getTradeHanteiKekkaCode()) + "', 1)\" />" + HTMLUtil.encode(detail.getHyoujiKeiyakuNo()) + "</a>\n");
			}
			else {
				buf.append("							" + HTMLUtil.encode(detail.getHyoujiKeiyakuNo()) + "\n");
			}
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getTradeHanteiKekka()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getKenshuYMD()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(Command.init(detail.getKaiyakuYMD(), detail.getManryoYMD())) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							" + kaiyaku + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-right\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getKeiyakuTerm()) + " " + "\n");
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getDaihyouBukkenName()) + " " + "\n");
			buf.append("						</td> " + "\n");

			if (piCommonBean.getDispControl().isAvailable("G0000001")) {
				buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
				buf.append("							<input type=\"button\" class=\"link-button\" value=\"推移表\" onclick=\"javascript:setKeiyaku('shiharai.keiyaku', '" + HTMLUtil.encode(detail.getKeiyakuNo()) + "','" + HTMLUtil.encode(detail.getHyoujiKeiyakuNo()) + "', null, null, '" + HTMLUtil.encode(piCommonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY ? detail.getCosmosCode() : detail.getLeasCompanyCode()) + "', '" + HTMLUtil.encode(detail.getTradeHanteiKekkaCode()) + "', 1)\" /> " + "\n");
				buf.append("						</td> " + "\n");
			}

			if (piCommonBean.getDispControl().isAvailable("G0000002")) {
				buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
				buf.append("							<input type=\"button\" class=\"link-button\" value=\"仕訳\" onclick=\"javascript:setKeiyaku('shiwake.keiyaku', '" + HTMLUtil.encode(detail.getKeiyakuNo()) + "','" + HTMLUtil.encode(detail.getHyoujiKeiyakuNo()) + "', null, null, '" + HTMLUtil.encode(piCommonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY ? detail.getCosmosCode() : detail.getLeasCompanyCode()) + "', '" + HTMLUtil.encode(detail.getTradeHanteiKekkaCode()) + "', 1)\" /> " + "\n");
				buf.append("						</td> " + "\n");
			}

			if (piCommonBean.getDispControl().isAvailable("P0000011")) {
				buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
				if (detail.getDownloadPath().length() == 0) {
					buf.append("							<input type=\"button\" class=\"link-button\" value=\"会計\" onclick=\"javascript:setKeiyaku('print.keiyaku', '" + HTMLUtil.encode(detail.getKeiyakuNo()) + "','" + HTMLUtil.encode(detail.getHyoujiKeiyakuNo()) + "', null, null, '" + HTMLUtil.encode(detail.getCosmosCode()) + "', '" + HTMLUtil.encode(detail.getTradeHanteiKekkaCode()) + "', 1)\" maxlength=\"20\" /> " + "\n");				
				}
				else {
					buf.append("							<a href=\'" + detail.getDownloadPath() + "\' target=\'" + "kaikeiMeisai" + "\' >" + "会計" + "</a>\n");
				}

				buf.append("						</td> " + "\n");
			}
			buf.append("						</tr> " + "\n");
		}

		buf.append("				</table> " + "\n");

		return buf.toString();
	}
}
