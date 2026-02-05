package jp.co.pro_app.lacs.affairs.shiharai.model;

import jp.co.pro_app.lacs.affairs.shiharai.bean.LACSShiharaiBean;

/**
 * Œ_–ñŒŸõx•¥„ˆÚ•\‘JˆÚƒNƒ‰ƒX.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSShiharaiBukkenModel extends LACSShiharaiModelBase {

	/**
	 * ‹Æ–±ŒÅ—Lˆ—.
	 * 
	 * @param piBean
	 *            Œ_–ñŒŸõBean
	 */
	protected void businessProc(LACSShiharaiBean piBean) {
		super.setForwardPath("/back.bukken");
	}

	/**
	 * ˆ—–¼‚ğæ“¾ .
	 * 
	 * @return ˆ—–¼
	 */
	public String getProcSubName() {
		return "–ß‚é";
	}

}
