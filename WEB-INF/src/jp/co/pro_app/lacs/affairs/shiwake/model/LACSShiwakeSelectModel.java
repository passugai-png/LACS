package jp.co.pro_app.lacs.affairs.shiwake.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.shiwake.bean.LACSShiwakeBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * 仕訳照会：遷移処理Model.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiwakeSelectModel extends LACSShiwakeSearchModel {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piShiwakeBean
	 *            仕訳照会Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSShiwakeBean piShiwakeBean) throws SQLException {

		LACSCommonBean commonBean = super.getCommonBean();

		super.prepareComoboBox(piShiwakeBean);

		piShiwakeBean.setKeiyakuNo(super.getInput("selKeiyakuNo", ""));
		piShiwakeBean.setHyoujiKeiyakuNo(super.getInput("selHyoujiKeiyakuNo", ""));
		piShiwakeBean.setBukkenNo(super.getInput("selBukkenNo", ""));
		piShiwakeBean.setBukkenEdaNo(super.getInput("selBukkenEdaNo", ""));
		piShiwakeBean.getLeasCompany().setSelectedValue(super.getInput("selLeasCompany", ""));
		piShiwakeBean.getTradeHanteiKekka().setSelectedValue(super.getInput("selTradeHanteiKekka", ""));
		piShiwakeBean.setPageFrom(super.getParam("selPageFrom", 0));

		piShiwakeBean.setCurrent(1);

		if (commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER) {
			piShiwakeBean.getLeasCompany().setSelectedValue(commonBean.getCosmosCode());
		}
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}
}
