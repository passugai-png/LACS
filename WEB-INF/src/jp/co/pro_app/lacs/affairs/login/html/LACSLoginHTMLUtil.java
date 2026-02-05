package jp.co.pro_app.lacs.affairs.login.html;

import jp.co.pro_app.lacs.affairs.login.bean.LACSLoginBean;
import jp.co.pro_app.projframe.common.html.HTMLUtil;

/**
 * リースユーザーマスタ一覧HTML生成.
 * 
 * @author active
 * @version 20071210
 * @author tatsumi
 * @version 20240917
 */
public class LACSLoginHTMLUtil extends HTMLUtil {

	/**
	 * リース会社ロゴHTMLを取得.
	 * 
	 * @param piBean
	 *            ログインBean
	 * @return リース会社ロゴHTML
	 */
	public static String outHTMLCompanyLogo(LACSLoginBean piBean) {
		String temp = "";

		if (piBean.getLogo().trim().length() > 0) {
			temp = "<img src=\"customimg/" + piBean.getLogo() + "\" /> " + "\n";
		}
		else {
//			temp = "&nbsp;";
		}

		return temp;
	}
	
	/**
	 * ログインお知らせHTMLを取得.
	 * 
	 * @param piBean
	 *            ログインBean
	 * @return ログインお知らせHTML
	 */
	public static String outHTMLInformation(LACSLoginBean piBean) {
		StringBuffer buf = new StringBuffer();

		String[] lines = piBean.getLoginInfo().replaceAll("\r\n", "\n").split("\n");

		if (piBean.getLoginInfo().trim().length() > 0) {
			for (int i = 0; i < lines.length; i++) {
				buf.append(lines[i] + "<br>");
			}
		}

		return buf.toString();
	}

	/**
	 * セキュリティロゴHTMLを取得.
	 * 
	 * @param piBean
	 *            ログインBean
	 * @return セキュリティロゴHTML
	 */
	public static String outHTMLSecurityLogo(LACSLoginBean piBean) {
		String temp = "";

		if (piBean.getSecurityInfo().trim().length() > 0) {
			temp = piBean.getSecurityInfo();
		}
		else {
//			temp = "&nbsp;";
		}

		return temp;
	}
}
