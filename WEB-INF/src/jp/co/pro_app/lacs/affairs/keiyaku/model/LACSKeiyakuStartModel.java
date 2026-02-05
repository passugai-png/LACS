package jp.co.pro_app.lacs.affairs.keiyaku.model;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * 契約検索：初期表示処理Model.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSKeiyakuStartModel extends LACSKeiyakuModelBase {

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
	 * @param piKeiyakuBean
	 *            契約検索Bean
	 * @exception Exception
	 *                実行例外
	 */
	protected void initSub(LACSKeiyakuBean piKeiyakuBean) throws Exception {

		LACSCommonBean commonBean = super.getCommonBean();

		piKeiyakuBean.init(this.getCommonBean());
		piKeiyakuBean.clearList();
		super.prepareComoboBox(piKeiyakuBean);

		if (commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER) {
			piKeiyakuBean.getLeasCompany().setSelectedValue(commonBean.getCosmosCode());
		}

	}

}
