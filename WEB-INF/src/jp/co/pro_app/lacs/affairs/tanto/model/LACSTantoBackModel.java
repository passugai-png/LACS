package jp.co.pro_app.lacs.affairs.tanto.model;

import jp.co.pro_app.lacs.affairs.tanto.bean.LACSTantoBean;

/**
 * 契約検索支払推移表遷移クラス.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSTantoBackModel extends LACSTantoModelBase {

	/**
	 * 業務個別処理.
	 * 
	 * @param piUserBean
	 *            リースユーザーマスタBean
	 */
	protected void businessProc(LACSTantoBean piUserBean) {
		super.setForwardPath("/back.tantolist");
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piUserBean
	 *            リースユーザーマスタBean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSTantoBean piUserBean) throws Exception {
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
