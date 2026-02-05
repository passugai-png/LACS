package jp.co.pro_app.lacs.affairs.karirisi.model;

import jp.co.pro_app.lacs.affairs.karirisi.bean.LACSKariRisiBean;
import jp.co.pro_app.lacs.affairs.user.bean.LACSUserBean;

/**
 * 契約検索支払推移表遷移クラス.
 * 
 * @author Katoken
 * @version 20090210
 */
public class LACSKariRisiBackModel extends LACSKariRisiModelBase {

	/**
	 * 業務個別処理.
	 * 
	 * @param piUserBean
	 *            リースユーザーマスタBean
	 */
	protected void businessProc(LACSKariRisiBean piUserBean) {
		super.setForwardPath("/back.karirisilist");
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piUserBean
	 *            リースユーザーマスタBean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSUserBean piUserBean) throws Exception {
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
