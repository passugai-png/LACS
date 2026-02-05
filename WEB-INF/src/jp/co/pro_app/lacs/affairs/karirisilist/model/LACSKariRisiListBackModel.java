package jp.co.pro_app.lacs.affairs.karirisilist.model;

import jp.co.pro_app.lacs.affairs.karirisi.bean.LACSKariRisiBean;
import jp.co.pro_app.lacs.affairs.karirisilist.bean.LACSKariRisiListBean;

/**
 * リースユーザー別借入利子率マスタ一覧：戻るModel.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSKariRisiListBackModel extends LACSKariRisiListModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {

		LACSKariRisiBean kariRisiBean = new LACSKariRisiBean();
		LACSKariRisiListBean kariRisiListBean = new LACSKariRisiListBean();

		kariRisiBean.setPageNo(1);
		kariRisiListBean.setCurrentW(1);

		return "戻る";
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}
}
