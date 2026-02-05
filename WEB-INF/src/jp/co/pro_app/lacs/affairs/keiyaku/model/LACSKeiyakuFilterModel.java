package jp.co.pro_app.lacs.affairs.keiyaku.model;

import jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuBean;

/**
 * Œ_–ñŒŸõFi‚è‚İModel.
 * 
 * @author katoken
 * @version 20080616
 */
public class LACSKeiyakuFilterModel extends LACSKeiyakuModelBase {

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
	 * @param piKeiyakuBean
	 *            Œ_–ñŒŸõBean
	 * @exception Exception
	 *                Às—áŠO
	 */
	protected void initSub(LACSKeiyakuBean piKeiyakuBean) throws Exception {
		piKeiyakuBean.init(this.getCommonBean());
		piKeiyakuBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));
		piKeiyakuBean.clearList();
		super.prepareComoboBox(piKeiyakuBean);

		piKeiyakuBean.setKeiyakuNo(super.getInput("keiyakuNo", ""));
		piKeiyakuBean.setKeiyakuAmtChk(super.getInput("keiyakuAmtChk", ""));
		piKeiyakuBean.setKeiyakuAmt(super.getInput("keiyakuAmt", ""));
		piKeiyakuBean.setKeiyakuTermChk(super.getInput("keiyakuTermChk", ""));
		piKeiyakuBean.setKeiyakuTerm(super.getInput("keiyakuTerm", ""));
		piKeiyakuBean.setKenPatn(super.getInput("kenPatn", ""));
		piKeiyakuBean.setKeiyakuRls(super.getInput("keiyakuRls", ""));
		piKeiyakuBean.setDaihyoBukkenName(super.getInput("daihyoBukkenName", ""));
		piKeiyakuBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));
		piKeiyakuBean.getTradeHanteiKekka().setSelectedValue(super.getInput("tradeHanteiKekka", ""));
		piKeiyakuBean.getKenshuFrom().setDate(super.getInput("kenshuFromEra", ""), super.getInput("kenshuFromData", ""), super.getInput("kenshuFromMonth", ""));
		piKeiyakuBean.getKenshuTo().setDate(super.getInput("kenshuToEra", ""), super.getInput("kenshuToData", ""), super.getInput("kenshuToMonth", ""));
		piKeiyakuBean.getManryoFrom().setDate(super.getInput("manryoFromEra", ""), super.getInput("manryoFromData", ""), super.getInput("manryoFromMonth", ""));
		piKeiyakuBean.getManryoTo().setDate(super.getInput("manryoToEra", ""), super.getInput("manryoToData", ""), super.getInput("manryoToMonth", ""));
		piKeiyakuBean.getKaiyakuFrom().setDate(super.getInput("kaiyakuFromEra", ""), super.getInput("kaiyakuFromData", ""), super.getInput("kaiyakuFromMonth", ""));
		piKeiyakuBean.getKaiyakuTo().setDate(super.getInput("kaiyakuToEra", ""), super.getInput("kaiyakuToData", ""), super.getInput("kaiyakuToMonth", ""));

	}
}
