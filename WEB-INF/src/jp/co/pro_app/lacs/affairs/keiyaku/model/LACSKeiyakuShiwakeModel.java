package jp.co.pro_app.lacs.affairs.keiyaku.model;

import jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuBean;

/**
 * Œ_–ñŒŸõx•¥„ˆÚ•\‘JˆÚƒNƒ‰ƒX.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSKeiyakuShiwakeModel extends LACSKeiyakuModelBase {

	/**
	 * ‹Æ–±ŒÅ—Lˆ—.
	 * 
	 * @param piKeiyakuBean
	 *            Œ_–ñŒŸõBean
	 */
	protected void businessProc(LACSKeiyakuBean piKeiyakuBean) {
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
