package jp.co.pro_app.lacs.affairs.ukebarai.model;

import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;

/**
 * 受払合計表：絞り込みModel.
 * 
 * @author active
 * @version 20080809
 */
public class LACSUkebaraiFilterModel extends LACSUkebaraiModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "絞込";
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @exception Exception
	 *                実行例外
	 */
	protected void initSub(LACSUkebaraiBean piUkebaraiBean) throws Exception {
		piUkebaraiBean.init(super.getCommonBean());
		piUkebaraiBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));
		super.prepareComoboBox(piUkebaraiBean);

		piUkebaraiBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));
		piUkebaraiBean.getTermFrom().setDate(super.getInput("termFromEra", ""), super.getInput("termFromData", ""), super.getInput("termFromMonth", ""), super.getInput("termFromDay", ""));
		piUkebaraiBean.setTsukiSu(super.getInput("tsukiSu", ""));

	}

}
