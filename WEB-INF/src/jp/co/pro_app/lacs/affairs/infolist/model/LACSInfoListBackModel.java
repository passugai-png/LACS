package jp.co.pro_app.lacs.affairs.infolist.model;

import jp.co.pro_app.lacs.affairs.info.bean.LACSInfoBean;
import jp.co.pro_app.lacs.affairs.infolist.bean.LACSInfoListBean;

/**
 * お知らせ一覧：戻るModel.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSInfoListBackModel extends LACSInfoListModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {

		LACSInfoListBean infoListBean = new LACSInfoListBean();
		LACSInfoBean infoBean = new LACSInfoBean();

		infoListBean.setCurrentW(1);
		infoBean.setPageNo(1);

		return "戻る";
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}
}
