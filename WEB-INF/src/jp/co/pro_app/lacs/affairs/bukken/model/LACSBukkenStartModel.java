package jp.co.pro_app.lacs.affairs.bukken.model;

import jp.co.pro_app.lacs.affairs.bukken.bean.LACSBukkenBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * 物件検索：初期表示処理Model.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSBukkenStartModel extends LACSBukkenModelBase {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piBukkenBean
	 *            物件検索Bean
	 * @exception Exception
	 *                実行例外
	 */
	protected void initSub(LACSBukkenBean piBukkenBean) throws Exception {

		LACSCommonBean commonBean = super.getCommonBean();

		piBukkenBean.init();
		super.prepareComoboBox(piBukkenBean);

		if (commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER) {
			piBukkenBean.getLeasCompany().setSelectedValue(commonBean.getCosmosCode());
		}

	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "表示";
	}

}
