package jp.co.pro_app.lacs.affairs.top.html;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.html.LACSHTMLUtil;
import jp.co.pro_app.lacs.affairs.common.html.LACSMenuData;
import jp.co.pro_app.lacs.affairs.common.html.LACSMenuDataLine;
import jp.co.pro_app.lacs.affairs.common.html.LACSMenuDataLineDetail;
import jp.co.pro_app.projframe.common.html.HTMLUtil;

/**
 * Topメニュー用HTML生成.
 * 
 * @author katoken
 * @version 20070312
 * @author tatsumi
 * @version 20240917
 */
public class LACSTopHTMLUtil extends LACSHTMLUtil {

	/**
	 * お知らせHTMLを取得.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @return お知らせHTML
	 */
	public static String outHTMLInformation(LACSCommonBean piCommonBean) {
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < piCommonBean.getInfo().size(); i++) {
//			buf.append(HTMLUtil.encode(piCommonBean.getInfo().get(i)).replaceAll(" ", "&nbsp;") + "<br>");
			buf.append(HTMLUtil.encode(piCommonBean.getInfo().get(i)) + "<br>");
		}

		return buf.toString();
	}

	/**
	 * ボタン部生成.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @return ヘッダー部
	 */
	public static String outHTMLButton(LACSCommonBean piCommonBean) {
		StringBuffer buf = new StringBuffer();
		LACSMenuData data = LACSMenuData.getData(piCommonBean, false);
		LACSMenuDataLine line = null;
		LACSMenuDataLineDetail detail = null;

		String disabled = piCommonBean.getErrorFlg().equals("1") ? " disabled" : "";

		for (int i = 0; i < data.size(); i++) {
			line = data.get(i);

			buf.append("				<div class=\"input-group-col\"> " + "\n");

			for (int j = 0; j < line.size(); j++) {
				detail = line.get(j);

				buf.append("					<div class=\"transition-button-detail\"> " + "\n");
				buf.append("						<input type=\"button\" class=\"menu-button\" value=\"" + detail.getDispName() + "\" onclick=\"post('" + detail.getUrl() + "')\" " + disabled + "/> " + "\n");
				buf.append("					</div> " + "\n");
			}

			buf.append("				</div> " + "\n");

		}

		return buf.toString();

	}

	/**
	 * お知らせ印刷ボタン生成.
	 * 
	 * @param piCoBean
	 *            TXT出力Bean
	 * @return TXTファイルパス&lt;a$gt;タグ
	 */
	public static String outHTMLTxtPath(LACSCommonBean piCoBean) {

		StringBuffer buf = new StringBuffer();
		String txtPath = piCoBean.getInfoFile();

		if (txtPath == null || txtPath.trim().length() == 0) {
			buf.append("<input type=\"button\" class=\"button\" value=\"印　刷\" onclick=\"javascript:post(\'print.top\')\">");
		}
		else {
			buf.append("<a href='#' onclick=\"javascript:downloadCSV('" + txtPath + "');return false;\">印　刷</a>");
		}

		return buf.toString();
	}

}
