package jp.co.pro_app.lacs.affairs.bukken.model;

import jp.co.pro_app.lacs.affairs.bukken.bean.LACSBukkenBean;

/**
 * 物件検索支払推移表遷移クラス.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSBukkenDetailModel extends LACSBukkenModelBase {

	/**
	 * 業務固有処理.
	 * 
	 * @param piBean
	 *            物件検索Bean
	 */
	protected void businessProc(LACSBukkenBean piBean) {
		super.setForwardPath("/select.syousai");
	}

	/**
	 * 処理名を取得 .
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "詳細照会";
	}

}
