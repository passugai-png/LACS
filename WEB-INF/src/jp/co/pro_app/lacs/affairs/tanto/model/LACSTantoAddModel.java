package jp.co.pro_app.lacs.affairs.tanto.model;

import jp.co.pro_app.lacs.affairs.tanto.bean.LACSTantoBean;
import jp.co.pro_app.lacs.affairs.tanto.bean.LACSTantoUserComboBean;

/**
 * 担当者マスタメンテ：開示先追加Model.
 * 
 * @author katoken
 * @version 20070616
 */
public class LACSTantoAddModel extends LACSTantoModelBase {

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
		return "追加";
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
			tantoUserComboBean.getUserList().setSelectedValue(super.getInput("leasCompanyEntry" + i, ""));
		}

		piTantoBean.setUserTantoName(super.getInput("userTantoName", "").trim());
		piTantoBean.setPassword(super.getInput("password1", "").trim());
		piTantoBean.setPassword2(super.getInput("password2", "").trim());
		piTantoBean.setKriPassFlg(super.getInput("chkKriPassFlg", "").trim());

		piTantoBean.getUserList(piTantoBean.getLeasCompany()).init(1);
	}

}
