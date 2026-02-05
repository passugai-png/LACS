package jp.co.pro_app.lacs.affairs.syousai.model;

import jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiBean;

/**
 * Œ_–ñŒŸõx•¥„ˆÚ•\‘JˆÚƒNƒ‰ƒX.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSSyousaiBukkenModel extends LACSSyousaiModelBase {

	/**
	 * ‹Æ–±ŒÅ—Lˆ—.
	 * 
	 * @param piBean
	 *            Œ_–ñŒŸõBean
	 */
	protected void businessProc(LACSSyousaiBean piBean) {
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
