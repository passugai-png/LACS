package jp.co.pro_app.lacs.affairs.tantolist.model;

import jp.co.pro_app.lacs.affairs.tanto.bean.LACSTantoBean;
import jp.co.pro_app.lacs.affairs.tantolist.bean.LACSTantoListBean;

/**
 * リースユーザー担当者マスタ一覧：戻るModel.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSTantoListBackModel extends LACSTantoListModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {

		LACSTantoBean tantoBean = new LACSTantoBean();
		LACSTantoListBean tantoListBean = new LACSTantoListBean();

		tantoBean.setPageNo(1);
		tantoListBean.setCurrentW(1);

		return "戻る";
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}
}
