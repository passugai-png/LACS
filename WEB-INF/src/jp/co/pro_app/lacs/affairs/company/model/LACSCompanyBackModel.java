package jp.co.pro_app.lacs.affairs.company.model;

import jp.co.pro_app.lacs.affairs.company.bean.LACSCompanyBean;

/**
 * 契約検索支払推移表遷移クラス.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSCompanyBackModel extends LACSCompanyModelBase {

	/**
	 * 業務固有処理.
	 * 
	 * @param piBean
	 *            契約検索Bean
	 */
	protected void businessProc(LACSCompanyBean piBean) {
		super.setForwardPath("/show.top");
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piCompanyBean
	 *            リース会社マスタBean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSCompanyBean piCompanyBean) throws Exception {
	}

	/**
	 * 処理名を取得 .
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "戻る";
	}

}
