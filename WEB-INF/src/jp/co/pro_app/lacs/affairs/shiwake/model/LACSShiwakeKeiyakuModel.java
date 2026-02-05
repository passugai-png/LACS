package jp.co.pro_app.lacs.affairs.shiwake.model;

import jp.co.pro_app.lacs.affairs.shiwake.bean.LACSShiwakeBean;

/**
 * Œ_–ñŒŸõx•¥„ˆÚ•\‘JˆÚƒNƒ‰ƒX.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSShiwakeKeiyakuModel extends LACSShiwakeModelBase {

	/**
	 * ‹Æ–±ŒÅ—Lˆ—.
	 * 
	 * @param piBean
	 *            Œ_–ñŒŸõBean
	 */
	protected void businessProc(LACSShiwakeBean piBean) {
		super.setForwardPath("/back.keiyaku");
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
