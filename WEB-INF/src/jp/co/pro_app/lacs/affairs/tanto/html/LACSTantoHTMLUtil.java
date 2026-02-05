package jp.co.pro_app.lacs.affairs.tanto.html;

import jp.co.pro_app.lacs.affairs.common.html.LACSHTMLUtil;
import jp.co.pro_app.lacs.affairs.tanto.bean.LACSTantoBean;
import jp.co.pro_app.projframe.common.html.HTMLUtil;

/**
 * リースユーザーマスタHTML生成.
 * 
 * @author ohmura
 * @version 20070913
 * @author tatsumi
 * @version 20240912
 */
public class LACSTantoHTMLUtil extends LACSHTMLUtil {

	/**
	 * エンドユーザー向け開示先入力部分.
	 * 
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 * @return エンドユーザー向け開示先入力部分
	 */
	public static String outHTMLUserInputEndUser(LACSTantoBean piTantoBean) {

		StringBuffer buf = new StringBuffer();

		buf.append("					<input type=\"hidden\" name=\"userListCount\" value=\"1\" /> " + "\n");
		buf.append("					<input type=\"text\" class=\"textbox-nine\" name=\"leasCompanyNmEntry0\"  value=\"" + encode(piTantoBean.getUserList().get(0).getFilterString()) + "\" /> " + "\n");
		buf.append("					<input type=\"button\" class=\"button\" value=\"絞　込\" onclick=\"filterTanto('filter.tanto', 0)\"/> " + "\n");
		buf.append("					<select class=\"pulldown-six\" name=\"leasCompanyEntry0\"> " + "\n");
		buf.append(HTMLUtil.outHTMLCombo(piTantoBean.getUserList().get(0).getUserList()));
		buf.append("					</select> " + "\n");

		return buf.toString();
	}

	/**
	 * 一般社員向け開示先入力部分.
	 * 
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 * @return 一般社員向け開示先入力部分
	 */
	public static String outHTMLUserInputGeneral(LACSTantoBean piTantoBean) {
		StringBuffer buf = new StringBuffer();
		
		buf.append("				<div class=\"input-group-row-nospase\"> " + "\n");
		buf.append("					<div class=\"new-user-section\"><span class=\"font-red\">* </span>開示先：</div> " + "\n");
		buf.append("					<div class=\"new-user-section-input\"> " + "\n");
		buf.append("						<input type=\"button\" class=\"button\" value=\" 追　加 \" name=add onclick=\"post('add.tanto')\"> " + "\n");
		buf.append("						<input type=\"hidden\" name=\"userListCount\" value=\"" + piTantoBean.getUserList().size() + "\" > " + "\n");
		buf.append("					</div> " + "\n");
		buf.append("				</div> " + "\n");

		for (int i = 0; i < piTantoBean.getUserList().size(); i++) {
			buf.append("				<div class=\"add-disclosure-recipient\"> " + "\n");
			buf.append("					<input type=\"text\" class=\"textbox-nine\" name=\"leasCompanyNmEntry" + i + "\" value=\"" + encode(piTantoBean.getUserList().get(i).getFilterString()) + "\" /> " + "\n");
			buf.append("					<input type=\"button\" class=\"button\" value=\"絞　込\" onclick=\"filterTanto('filter.tanto', " + i + ")\"/> " + "\n");
			buf.append("					<select class=\"pulldown-six\" name=\"leasCompanyEntry" + i + "\"> " + "\n");
			buf.append(HTMLUtil.outHTMLCombo(piTantoBean.getUserList().get(i).getUserList()));
			buf.append("					</select> " + "\n");
			buf.append("				</div> " + "\n");
		}

		return buf.toString();
	}
}
