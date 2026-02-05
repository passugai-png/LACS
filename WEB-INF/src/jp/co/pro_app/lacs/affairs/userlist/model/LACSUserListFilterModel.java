package jp.co.pro_app.lacs.affairs.userlist.model;

import jp.co.pro_app.lacs.affairs.userlist.bean.LACSUserListBean;

/**
 * リースユーザーマスタ一覧：絞り込みModel.
 * 
 * @author katoken
 * @version 20080616
 */
public class LACSUserListFilterModel extends LACSUserListModelBase {

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
	 * @param piUserListBean
	 *            リースユーザーマスタ一覧Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSUserListBean piUserListBean) throws Exception {
		piUserListBean.init(super.getCommonBean());
		piUserListBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));
		super.prepareComoboBox(piUserListBean);

		piUserListBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));

	}

}
