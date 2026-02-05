package jp.co.pro_app.lacs.affairs.shiwake.model;

import jp.co.pro_app.lacs.affairs.shiwake.bean.LACSShiwakeBean;

/**
 * 仕訳照会：絞り込みModel.
 * 
 * @author katoken
 * @version 20080616
 */
public class LACSShiwakeFilterModel extends LACSShiwakeModelBase {

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
	 * @param piShiwakeBean
	 *            仕訳照会Bean
	 * @exception Exception
	 *                実行例外
	 */
	protected void initSub(LACSShiwakeBean piShiwakeBean) throws Exception {
		piShiwakeBean.init(super.getCommonBean());
		piShiwakeBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));
		super.prepareComoboBox(piShiwakeBean);

		piShiwakeBean.setKeiyakuNo(super.getInput("keiyakuNo", ""));
		piShiwakeBean.setBukkenNo(super.getInput("bukkenNo", ""));
		piShiwakeBean.setBukkenEdaNo(super.getInput("bukkenEdaNo", ""));
		piShiwakeBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));
		piShiwakeBean.getTradeHanteiKekka().setSelectedValue(super.getInput("tradeHanteiKekka", ""));
		piShiwakeBean.getTermFrom().setDate(super.getInput("termFromEra", ""), super.getInput("termFromData", ""), super.getInput("termFromMonth", ""));
		piShiwakeBean.getTermTo().setDate(super.getInput("termToEra", ""), super.getInput("termToData", ""), super.getInput("termToMonth", ""));

	}

}
