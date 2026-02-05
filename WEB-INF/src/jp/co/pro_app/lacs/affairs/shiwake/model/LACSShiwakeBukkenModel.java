package jp.co.pro_app.lacs.affairs.shiwake.model;

import jp.co.pro_app.lacs.affairs.shiwake.bean.LACSShiwakeBean;

/**
 * Œ_–ñŒŸõx•¥„ˆÚ•\‘JˆÚƒNƒ‰ƒX.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSShiwakeBukkenModel extends LACSShiwakeModelBase {

	/**
	 * ‹Æ–±ŒÅ—Lˆ—.
	 * 
	 * @param piBean
	 *            Œ_–ñŒŸõBean
	 */
	protected void businessProc(LACSShiwakeBean piBean) {
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
