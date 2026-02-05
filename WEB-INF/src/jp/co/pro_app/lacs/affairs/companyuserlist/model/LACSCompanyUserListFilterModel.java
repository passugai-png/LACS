package jp.co.pro_app.lacs.affairs.companyuserlist.model;

import jp.co.pro_app.lacs.affairs.companyuserlist.bean.LACSCompanyUserListBean;

/**
 * リース会社別リースユーザーマスタ一覧：絞り込みModel.
 * 
 * @author katoken
 * @version 20070616
 */
public class LACSCompanyUserListFilterModel extends LACSCompanyUserListModelBase {

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
	 * @param piCompanyUserListBean
	 *            リース会社別リースユーザーマスタ一覧Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSCompanyUserListBean piCompanyUserListBean) throws Exception {
		piCompanyUserListBean.init(super.getCommonBean());
		piCompanyUserListBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));
		super.prepareComoboBox(piCompanyUserListBean);

		piCompanyUserListBean.setLeasCompanyCode(super.getInput("condCompanyCode", ""));
		piCompanyUserListBean.setTorihikiCode(super.getInput("condTorihikiCode", ""));
		piCompanyUserListBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));

	}

}
