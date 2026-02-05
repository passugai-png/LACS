package jp.co.pro_app.lacs.affairs.syousai.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiBean;

/**
 * Œ_–ñÚ×F‘JˆÚˆ—Model.
 * 
 * @author yokota
 * @version 20081017
 */
public class LACSSyousaiSelectModel extends LACSSyousaiSearchModel {

	/**
	 * ‹Æ–±ŒÅ—L‰Šú‰».
	 * 
	 * @param piSyousaiBean
	 *            Œ_–ñÚ×Bean
	 * @exception SQLException
	 *                SQLÀs—áŠO
	 */
	protected void initSub(LACSSyousaiBean piSyousaiBean) throws SQLException {

		super.prepareComoboBox(piSyousaiBean);

		piSyousaiBean.setKeiyakuNo(super.getInput("selKeiyakuNo", ""));
		piSyousaiBean.setHyoujiKeiyakuNo(super.getInput("selHyoujiKeiyakuNo", ""));
		piSyousaiBean.setBukkenNo(super.getInput("selBukkenNo", ""));
		piSyousaiBean.setBukkenEdaNo(super.getInput("selBukkenEdaNo", ""));

		piSyousaiBean.setLeasCompanyCode(super.getInput("selLeasCompany", ""));
		piSyousaiBean.getTradeHanteiKekka().setSelectedValue(super.getInput("selTradeHanteiKekka", ""));
		piSyousaiBean.setPageFrom(super.getParam("selPageFrom", 0));
		piSyousaiBean.setDownloadPath("");
		piSyousaiBean.setCSVDownloadPath("");
		piSyousaiBean.setCurrent(1);

		piSyousaiBean.clearList();

	}
}
