package jp.co.pro_app.lacs.affairs.bukken.model;

import jp.co.pro_app.lacs.affairs.bukken.bean.LACSBukkenBean;

/**
 * 物件検索：絞り込みModel.
 * 
 * @author katoken
 * @version 20070616
 */
public class LACSBukkenFilterModel extends LACSBukkenModelBase {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piBukkenBean
	 *            物件検索Bean
	 * @exception Exception
	 *                実行例外
	 */
	protected void initSub(LACSBukkenBean piBukkenBean) throws Exception {

		piBukkenBean.init();
		piBukkenBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));

		super.prepareComoboBox(piBukkenBean);

		piBukkenBean.setKeiyakuNo(super.getInput("keiyakuNo", ""));
		piBukkenBean.setBukkenName(super.getInput("bukkenName", ""));
		piBukkenBean.setBukkenNameSerchPtn(super.getInput("bukkenNameSerchPtn", ""));
		piBukkenBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));
		piBukkenBean.getTradeHanteiKekka().setSelectedValue(super.getInput("tradeHanteiKekka", ""));

	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "絞込";
	}

}
