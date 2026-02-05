package jp.co.pro_app.lacs.affairs.tantolist.model;

import jp.co.pro_app.lacs.affairs.tantolist.bean.LACSTantoListBean;

/**
 * リースユーザー担当者マスタ一覧：絞り込みModel.
 * 
 * @author katoken
 * @version 20070616
 */
public class LACSTantoListFilterModel extends LACSTantoListModelBase {

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
	 * @param piTantoListBean
	 *            リースユーザー担当者マスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void initSub(LACSTantoListBean piTantoListBean) throws Exception {
		piTantoListBean.init(super.getCommonBean());

		piTantoListBean.setUserID(super.getInput("condUserID", ""));
		piTantoListBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));
		super.prepareComoboBox(piTantoListBean);

		piTantoListBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));
		piTantoListBean.getTantJti().setSelectedValue(super.getInput("tantJti", ""));
	}

}
