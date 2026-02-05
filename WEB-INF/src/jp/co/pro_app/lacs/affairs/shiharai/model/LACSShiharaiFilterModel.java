package jp.co.pro_app.lacs.affairs.shiharai.model;

import jp.co.pro_app.lacs.affairs.shiharai.bean.LACSShiharaiBean;

/**
 * x•¥„ˆÚ•\Fi‚è‚İModel.
 * 
 * @author katoken
 * @version 20080616
 */
public class LACSShiharaiFilterModel extends LACSShiharaiModelBase {

	/**
	 * ˆ—–¼‚ğæ“¾.
	 * 
	 * @return ˆ—–¼
	 */
	public String getProcSubName() {
		return "i";
	}

	/**
	 * ‹Æ–±ŒÅ—L‰Šú‰».
	 * 
	 * @param piShiharaiBean
	 *            x•¥„ˆÚ•\Bean
	 * @exception Exception
	 *                Às—áŠO
	 */
	protected void initSub(LACSShiharaiBean piShiharaiBean) throws Exception {
		piShiharaiBean.init(super.getCommonBean());
		piShiharaiBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));
		super.prepareComoboBox(piShiharaiBean);

		piShiharaiBean.setKeiyakuNo(super.getInput("keiyakuNo", ""));
		piShiharaiBean.setBukkenNo(super.getInput("bukkenNo", ""));
		piShiharaiBean.setBukkenEdaNo(super.getInput("bukkenEdaNo", ""));
		piShiharaiBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));
		piShiharaiBean.getTradeHanteiKekka().setSelectedValue(super.getInput("tradeHanteiKekka", ""));
		piShiharaiBean.getTermFrom().setDate(super.getInput("termFromEra", ""), super.getInput("termFromData", ""), super.getInput("termFromMonth", ""));
		piShiharaiBean.getTermTo().setDate(super.getInput("termToEra", ""), super.getInput("termToData", ""), super.getInput("termToMonth", ""));

	}

}
