package jp.co.pro_app.lacs.affairs.common.command;

import java.sql.Connection;
import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSBeanBase;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSTantJtiKbnEntity;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSTradeHanteiKbnEntity;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSUserLeasCompanyEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.html.ComboArray;
import jp.co.pro_app.projframe.common.html.ComboValue;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * LACS用共通コンボボックス作成.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSComboMaker {

	/**
	 * コンストラクタ.
	 */
	private LACSComboMaker() {
	}

	/**
	 * コンボボックス作成.
	 * 
	 * @param piBean
	 *            画面Bean
	 * @param piCommonBean
	 *            共通Bean
	 * @param piCon
	 *            DB接続
	 * @param piModel
	 *            モデル
	 * @param piShowAll
	 *            全ユーザー表示フラグ
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public static void makeCombo(LACSBeanBase piBean, LACSCommonBean piCommonBean, Connection piCon, DBModelBase piModel, boolean piShowAll) throws SQLException {
		LACSUserLeasCompanyEntity userLeasCompanyEntity = new LACSUserLeasCompanyEntity(piModel);
		LACSTradeHanteiKbnEntity tradeHanteiKbnEntity = new LACSTradeHanteiKbnEntity(piModel);
		LACSTantJtiKbnEntity tantJtiKbnEntity = new LACSTantJtiKbnEntity(piModel);

		ComboArray leasCompanyArray = piBean.getLeasCompany();
		ComboArray tradehanteiKekkaArray = piBean.getTradeHanteiKekka();
		ComboArray tantJtiArray = piBean.getTantJti();

		leasCompanyArray.clear();
		tradehanteiKekkaArray.clear();
		tantJtiArray.clear();
		leasCompanyArray.add(new ComboValue("", ""));
		tradehanteiKekkaArray.add(new ComboValue("", ""));
		tantJtiArray.add(new ComboValue("", ""));

		try {
			userLeasCompanyEntity.setCon(piCon);

			if (piCommonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {
				userLeasCompanyEntity.setCompanyCode(piCommonBean.getCompanyCode());
			}
			else {
				userLeasCompanyEntity.setCosmosCode(piCommonBean.getCosmosCode());
			}

			userLeasCompanyEntity.setLeasCompanyNm(piBean.getLeasCompanyNm());

			userLeasCompanyEntity.setShowAll(piShowAll);
			userLeasCompanyEntity.execSQL();

			while (userLeasCompanyEntity.next()) {
				if (piCommonBean.getEnableUserList().contains(LACSDefine.INFO_ALL) || piCommonBean.getEnableUserList().contains(userLeasCompanyEntity.getCosmosCode())) {
					leasCompanyArray.add(new ComboValue(userLeasCompanyEntity.getUserName(), userLeasCompanyEntity.getCosmosCode()));
				}
			}

			tradeHanteiKbnEntity.setCon(piCon);

			tradeHanteiKbnEntity.execSQL();

			while (tradeHanteiKbnEntity.next()) {
				tradehanteiKekkaArray.add(new ComboValue(tradeHanteiKbnEntity.getTradeHanteiKekkaName(), tradeHanteiKbnEntity.getTradeHanteiKekkaCode()));
			}

			tantJtiKbnEntity.setCon(piCon);

			tantJtiKbnEntity.execSQL();

			while (tantJtiKbnEntity.next()) {
				tantJtiArray.add(new ComboValue(tantJtiKbnEntity.getTantJtiName(), tantJtiKbnEntity.getTantJtiKbn()));
			}
		}
		finally {
			userLeasCompanyEntity.close();
			tradeHanteiKbnEntity.close();
			tantJtiKbnEntity.close();
		}
	}
}
