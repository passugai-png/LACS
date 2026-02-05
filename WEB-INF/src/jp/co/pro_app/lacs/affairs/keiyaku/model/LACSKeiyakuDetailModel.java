package jp.co.pro_app.lacs.affairs.keiyaku.model;

import jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuBean;

/**
 * 物件検索支払推移表遷移クラス.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSKeiyakuDetailModel extends LACSKeiyakuModelBase {

	/**
	 * 業務固有処理.
	 * 
	 * @param piBean
	 *            物件検索Bean
	 */
	protected void businessProc(LACSKeiyakuBean piBean) {
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
