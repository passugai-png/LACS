package jp.co.pro_app.lacs.affairs.infolist.model;

import jp.co.pro_app.lacs.affairs.infolist.bean.LACSInfoListBean;

/**
 * リース会社別リースユーザーマスタ一覧：絞り込みModel.
 * 
 * @author katoken
 * @version 20070616
 */
public class LACSInfoListFilterModel extends LACSInfoListModelBase {

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
	 * @param piInfoListBean
	 *            お知らせ一覧Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSInfoListBean piInfoListBean) throws Exception {
		piInfoListBean.init(super.getCommonBean());
		piInfoListBean.setLeasCompanyNm(super.getInput("condleasCompanyNm", ""));
		super.prepareComoboBox(piInfoListBean);

		piInfoListBean.setCondStartYmd(super.getInput("condStartYmd", ""));
		piInfoListBean.setCondEndYmd(super.getInput("condEndYmd", ""));
		piInfoListBean.setCondInfoData(super.getInput("condInfoData", ""));
		piInfoListBean.getLeasCompany().setSelectedValue(super.getInput("condleasCompany", ""));

	}

}
