package jp.co.pro_app.lacs.affairs.info.model;

import jp.co.pro_app.lacs.affairs.info.bean.LACSInfoBean;

/**
 * お知らせメンテナンス：絞り込みModel.
 * 
 * @author katoken
 * @version 20070616
 */
public class LACSInfoFilterModel extends LACSInfoModelBase {

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
	 * @param piInfoBean
	 *            お知らせメンテナンスBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSInfoBean piInfoBean) throws Exception {
		super.setForwardPath("/jsp/I001.jsp");
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piInfoBean
	 *            お知らせメンテナンスBean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSInfoBean piInfoBean) throws Exception {
		piInfoBean.init(super.getCommonBean());
		piInfoBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));
		super.prepareComoboBox(piInfoBean);

		piInfoBean.setCondStartYmd(super.getInput("condStartYmd", ""));
		piInfoBean.setCondEndYmd(super.getInput("condEndYmd", ""));
		piInfoBean.setCondInfoData(super.getInput("condInfoData", ""));
		piInfoBean.getLeasCompany().setSelectedValue(super.getInput("condleasCompany", ""));
		piInfoBean.setStartYmd(super.getInput("startYmd", "").trim());
		piInfoBean.setEndYmd(super.getInput("endYmd", "").trim());
		piInfoBean.setInfoData(super.getInput("infoData", "").trim());
		piInfoBean.setRowId(super.getInput("targetRowId", "").trim());
		piInfoBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));
	}

}
