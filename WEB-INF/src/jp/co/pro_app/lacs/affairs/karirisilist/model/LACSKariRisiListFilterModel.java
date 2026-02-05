package jp.co.pro_app.lacs.affairs.karirisilist.model;

import jp.co.pro_app.lacs.affairs.karirisilist.bean.LACSKariRisiListBean;

/**
 * リースユーザー別借入利子率マスタ一覧：絞り込みModel.
 * 
 * @author katoken
 * @version 20070616
 */
public class LACSKariRisiListFilterModel extends LACSKariRisiListModelBase {

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
	 * @param piKariRisiListBean
	 *            リースユーザー別借入利子率マスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void initSub(LACSKariRisiListBean piKariRisiListBean) throws Exception {
		piKariRisiListBean.init(super.getCommonBean());
		piKariRisiListBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));
		super.prepareComoboBox(piKariRisiListBean);

		piKariRisiListBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));

	}

}
