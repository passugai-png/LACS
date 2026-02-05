package jp.co.pro_app.lacs.affairs.shiwake.model;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.shiwake.bean.LACSShiwakeBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * 仕訳照会：初期表示処理Model.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiwakeStartModel extends LACSShiwakeModelBase {

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
	 * @param piShiwakeBean
	 *            仕訳照会Bean
	 * @exception Exception
	 *                実行例外
	 */
	protected void initSub(LACSShiwakeBean piShiwakeBean) throws Exception {

		LACSCommonBean commonBean = super.getCommonBean();

		piShiwakeBean.initTerm(commonBean, this.con, this);

		piShiwakeBean.init(super.getCommonBean());
		super.prepareComoboBox(piShiwakeBean);

		if (commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER) {
			piShiwakeBean.getLeasCompany().setSelectedValue(commonBean.getCosmosCode());
		}

	}
}
