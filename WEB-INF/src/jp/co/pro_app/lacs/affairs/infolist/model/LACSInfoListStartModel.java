package jp.co.pro_app.lacs.affairs.infolist.model;

import jp.co.pro_app.lacs.affairs.infolist.bean.LACSInfoListBean;

/**
 * お知らせ一覧：初期表示Model.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSInfoListStartModel extends LACSInfoListModelBase {

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
	 * @param piInfoListBean
	 *            お知らせ一覧Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSInfoListBean piInfoListBean) throws Exception {
		piInfoListBean.init(super.getCommonBean());

		super.prepareComoboBox(piInfoListBean);

	}
}
