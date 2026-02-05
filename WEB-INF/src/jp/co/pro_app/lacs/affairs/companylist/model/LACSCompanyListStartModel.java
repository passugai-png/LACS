package jp.co.pro_app.lacs.affairs.companylist.model;

import jp.co.pro_app.lacs.affairs.companylist.bean.LACSCompanyListBean;

/**
 * リース会社マスタ一覧：初期表示Model.
 * 
 * @author PAD Katoh
 * @version 20071212
 */
public class LACSCompanyListStartModel extends LACSCompanyListModelBase {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piCompanyListBean
	 *            リース会社マスタ一覧Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSCompanyListBean piCompanyListBean) throws Exception {
		piCompanyListBean.init(super.getCommonBean());
	}

	/**
	 * 遷移先変更処理を行うか.
	 * 
	 * @return true:行う／false:行わない
	 */
	protected boolean isForwordEdit() {
		return true;
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "表示";
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}
}
