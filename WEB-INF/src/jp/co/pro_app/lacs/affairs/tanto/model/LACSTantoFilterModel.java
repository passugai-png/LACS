package jp.co.pro_app.lacs.affairs.tanto.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSUserLeasCompanyEntity;
import jp.co.pro_app.lacs.affairs.tanto.bean.LACSTantoBean;
import jp.co.pro_app.lacs.affairs.tanto.bean.LACSTantoUserComboBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.html.ComboValue;

/**
 * 担当者マスタメンテ：絞り込みModel.
 * 
 * @author katoken
 * @version 20070616
 */
public class LACSTantoFilterModel extends LACSTantoModelBase {

	/**
	 * 業務個別処理.
	 * 
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSTantoBean piTantoBean) throws Exception {
		super.setForwardPath("/jsp/T001.jsp");
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "絞込";
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piTantoBean
	 *            担当者マスタメンテBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void initSub(LACSTantoBean piTantoBean) throws Exception {

		int userListCount = super.getParam("userListCount", 0);
		LACSTantoUserComboBean tantoUserComboBean = null;

		for (int i = 0; i < userListCount; i++) {
			tantoUserComboBean = piTantoBean.getUserList().get(i);

			tantoUserComboBean.setFilterString(super.getInput("leasCompanyNmEntry" + i, "").trim());
		}

		piTantoBean.setUserTantoName(super.getInput("userTantoName", "").trim());
		piTantoBean.setPassword(super.getInput("password1", "").trim());
		piTantoBean.setPassword2(super.getInput("password2", "").trim());
		piTantoBean.setKriPassFlg(super.getInput("chkKriPassFlg", "").trim());

		this.filter(piTantoBean);

		for (int i = 0; i < userListCount; i++) {
			tantoUserComboBean = piTantoBean.getUserList().get(i);

			tantoUserComboBean.getUserList().setSelectedValue(super.getInput("leasCompanyEntry" + i, ""));
		}
	}

	private void filter(LACSTantoBean piTantoBean) throws SQLException {
		LACSCommonBean commonBean = super.getCommonBean();

		LACSUserLeasCompanyEntity userLeasCompanyEntity = new LACSUserLeasCompanyEntity(this);

		int filterIndex = super.getParam("filterIndex", 0);

		LACSTantoUserComboBean tantoUserComboBean = null;

		try {
			userLeasCompanyEntity.setCon(this.con);

			if (commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {
				userLeasCompanyEntity.setCompanyCode(commonBean.getCompanyCode());
			}
			else {
				userLeasCompanyEntity.setCosmosCode(commonBean.getCosmosCode());
			}

			tantoUserComboBean = piTantoBean.getUserList().get(filterIndex);

			userLeasCompanyEntity.setLeasCompanyNm(tantoUserComboBean.getFilterString());

			if (piTantoBean.getUserRight().equals(LACSDefine.UserRight.ADMIN)) {
				userLeasCompanyEntity.setShowAll(true);
			}
			else if (piTantoBean.getUserRight().equals(LACSDefine.UserRight.GENERAL)) {
				userLeasCompanyEntity.setShowAll(false);
			}
			else {
				userLeasCompanyEntity.setShowAll(false);
			}

			userLeasCompanyEntity.execSQL();
			tantoUserComboBean.getUserList().clear();

			tantoUserComboBean.getUserList().add(new ComboValue("", ""));

			if (piTantoBean.getUserRight().equals(LACSDefine.UserRight.ADMIN) || piTantoBean.getUserRight().equals(LACSDefine.UserRight.GENERAL)) {
				tantoUserComboBean.getUserList().add(new ComboValue("全開示先", LACSDefine.INFO_ALL));
			}

			while (userLeasCompanyEntity.next()) {
				tantoUserComboBean.getUserList().add(new ComboValue(userLeasCompanyEntity.getUserName(), userLeasCompanyEntity.getCosmosCode()));
			}
		}
		finally {
			userLeasCompanyEntity.close();
		}

	}

}
