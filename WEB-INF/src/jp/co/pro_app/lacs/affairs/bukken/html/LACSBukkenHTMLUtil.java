package jp.co.pro_app.lacs.affairs.bukken.html;

import jp.co.pro_app.lacs.affairs.bukken.bean.LACSBukkenBean;
import jp.co.pro_app.lacs.affairs.bukken.bean.LACSBukkenDetailBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.html.LACSHTMLUtil;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.html.HTMLUtil;

/**
 * 物件検索HTML生成.
 * 
 * @author katoken
 * @version 20070312
 * @author tatsumi
 * @version 20240909
 */
public class LACSBukkenHTMLUtil extends LACSHTMLUtil {

	/**
	 * 明細行生成.
	 * 
	 * @param piBean
	 *            物件検索Bean
	 * @param piCommonBean
	 *            LACS共通Bean
	 * @return 明細業
	 */
	public static String outHTMLList(LACSBukkenBean piBean, LACSCommonBean piCommonBean) {

		StringBuffer buf = new StringBuffer();
		LACSBukkenDetailBean detail = null;
		String bg = "";

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
		buf.append("							物件番号 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-three\"> " + "\n");
		buf.append("							リース取引分類 " + "\n");
		buf.append("						</th> " + "\n");
		buf.append("						<th class=\"cells-width-four\"> " + "\n");
		buf.append("							物件名 " + "\n");
		buf.append("						</th> " + "\n");
		if (piCommonBean.getDispControl().isAvailable("G0000001")) {
			buf.append("						<th class=\"cells-width-three\"> " + "\n");
			buf.append("							支払推移表 " + "\n");
		}
		if (piCommonBean.getDispControl().isAvailable("G0000002")) {
			buf.append("						<th class=\"cells-width-two\"> " + "\n");
			buf.append("							仕訳照会 " + "\n");
		}
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
			if (piCommonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {
				buf.append("							" + HTMLUtil.encode(detail.getLeaseUserName()) + "</td> " + "\n");
			}
			else {
				buf.append("							" + HTMLUtil.encode(detail.getLeasCompanyName()) + "</td> " + "\n");
			}
			buf.append("						<td> " + "\n");
			if (piCommonBean.getDispControl().isAvailable("G0000008")) {
				buf.append("							<a href=\"javascript:setKeiyaku('detail.bukken', '" + HTMLUtil.encode(detail.getKeiyakuNo()) + "','" + HTMLUtil.encode(detail.getHyoujiKeiyakuNo()) + "', null, null, '" + HTMLUtil.encode(detail.getCosmosCode()) + "', '" + HTMLUtil.encode(detail.getTradeHanteiKekkaCode()) + "', 2)\" />" + HTMLUtil.encode(detail.getHyoujiKeiyakuNo()) + "</a>\n");
			}
			else {
				buf.append("							" + HTMLUtil.encode(detail.getHyoujiKeiyakuNo()) + "\n");
			}
			buf.append("						</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getBukkenNo() + (detail.getBukkenEdaNo() == null || detail.getBukkenEdaNo().trim().length() == 0 ? "" : "-" + detail.getBukkenEdaNo())) + "</td> " + "\n");
			buf.append("						<td class=\"cells-word-position-left\"> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getTradeHanteiKekka()) + "</td> " + "\n");
			buf.append("						<td> " + "\n");
			buf.append("							" + HTMLUtil.encode(detail.getBukkenName()) + "</td> " + "\n");
			if (piCommonBean.getDispControl().isAvailable("G0000001")) {
				buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
				buf.append("							<input type=\"button\" class=\"link-button\" value=\"推移表\" onclick=\"javascript:setKeiyaku('shiharai.bukken', '" + HTMLUtil.encode(detail.getKeiyakuNo()) + "','" + HTMLUtil.encode(detail.getHyoujiKeiyakuNo()) + "', '" + HTMLUtil.encode(detail.getBukkenNo()) + "', '" + HTMLUtil.encode(detail.getBukkenEdaNo()) + "', '" + HTMLUtil.encode(piCommonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY ? detail.getCosmosCode() : detail.getLeasCompanyCode()) + "', '" + HTMLUtil.encode(detail.getTradeHanteiKekkaCode()) + "', 2)\" /></td> " + "\n");
			}
			if (piCommonBean.getDispControl().isAvailable("G0000002")) {
				buf.append("						<td class=\"cells-word-position-center\"> " + "\n");
				buf.append("							<input type=\"button\" class=\"link-button\" value=\"仕訳\" onclick=\"javascript:setKeiyaku('shiwake.bukken', '" + HTMLUtil.encode(detail.getKeiyakuNo()) + "','" + HTMLUtil.encode(detail.getHyoujiKeiyakuNo()) + "', '" + HTMLUtil.encode(detail.getBukkenNo()) + "', '" + HTMLUtil.encode(detail.getBukkenEdaNo()) + "', '" + HTMLUtil.encode(piCommonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY ? detail.getCosmosCode() : detail.getLeasCompanyCode()) + "', '" + HTMLUtil.encode(detail.getTradeHanteiKekkaCode()) + "', 2)\"/></td> " + "\n");
			}
			buf.append("					</tr> " + "\n");
		}

		buf.append("				</table> " + "\n");

		return buf.toString();
	}
}
