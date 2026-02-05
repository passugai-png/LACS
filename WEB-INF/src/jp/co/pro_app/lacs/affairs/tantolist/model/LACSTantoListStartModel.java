package jp.co.pro_app.lacs.affairs.tantolist.model;

import jp.co.pro_app.lacs.affairs.tantolist.bean.LACSTantoListBean;

/**
 * リースユーザー担当者マスタ一覧：初期表示Model.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSTantoListStartModel extends LACSTantoListModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "表示";
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piTantoListBean
	 *            リースユーザー担当者マスタ一覧Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSTantoListBean piTantoListBean) throws Exception {
		piTantoListBean.init(super.getCommonBean());

		super.prepareComoboBox(piTantoListBean);

	}
}
