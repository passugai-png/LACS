package jp.co.pro_app.lacs.affairs.shiharai.model;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.shiharai.bean.LACSShiharaiBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * 支払推移表：初期表示処理Model.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiharaiStartModel extends LACSShiharaiModelBase {

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
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 * @exception Exception
	 *                実行例外
	 */
	protected void initSub(LACSShiharaiBean piShiharaiBean) throws Exception {

		LACSCommonBean commonBean = super.getCommonBean();

		piShiharaiBean.initTerm(commonBean, this.con, this);

		piShiharaiBean.init(super.getCommonBean());
		super.prepareComoboBox(piShiharaiBean);

		if (commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER) {
			piShiharaiBean.getLeasCompany().setSelectedValue(commonBean.getCosmosCode());
		}

	}
}
