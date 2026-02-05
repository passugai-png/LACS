package jp.co.pro_app.lacs.affairs.bukken.model;

import jp.co.pro_app.lacs.affairs.bukken.bean.LACSBukkenBean;

/**
 * Œ_–ñŒŸõx•¥„ˆÚ•\‘JˆÚƒNƒ‰ƒX.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSBukkenShiwakeModel extends LACSBukkenModelBase {

	/**
	 * ‹Æ–±ŒÅ—Lˆ—.
	 * 
	 * @param piKeiyakuBean
	 *            Œ_–ñŒŸõBean
	 */
	protected void businessProc(LACSBukkenBean piKeiyakuBean) {
		super.setForwardPath("/select.shiwake");
	}

	/**
	 * ˆ—–¼‚ğæ“¾ .
	 * 
	 * @return ˆ—–¼
	 */
	public String getProcSubName() {
		return "d–ó";
	}

}
