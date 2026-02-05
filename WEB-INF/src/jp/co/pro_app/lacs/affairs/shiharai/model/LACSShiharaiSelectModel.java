package jp.co.pro_app.lacs.affairs.shiharai.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.shiharai.bean.LACSShiharaiBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * 支払推移表：遷移処理Model.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiharaiSelectModel extends LACSShiharaiSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSShiharaiBean piShiharaiBean) throws SQLException {

		LACSCommonBean commonBean = super.getCommonBean();

		super.prepareComoboBox(piShiharaiBean);

		piShiharaiBean.setKeiyakuNo(super.getInput("selKeiyakuNo", ""));
		piShiharaiBean.setHyoujiKeiyakuNo(super.getInput("selHyoujiKeiyakuNo", ""));
		piShiharaiBean.setBukkenNo(super.getInput("selBukkenNo", ""));
		piShiharaiBean.setBukkenEdaNo(super.getInput("selBukkenEdaNo", ""));
		piShiharaiBean.getLeasCompany().setSelectedValue(super.getInput("selLeasCompany", ""));
		piShiharaiBean.getTradeHanteiKekka().setSelectedValue(super.getInput("selTradeHanteiKekka", ""));
		piShiharaiBean.setPageFrom(super.getParam("selPageFrom", 0));

		piShiharaiBean.setCurrent(1);

		if (commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER) {
			piShiharaiBean.getLeasCompany().setSelectedValue(commonBean.getCosmosCode());
		}
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}
}
