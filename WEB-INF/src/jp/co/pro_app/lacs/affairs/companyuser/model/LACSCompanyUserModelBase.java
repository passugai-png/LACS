package jp.co.pro_app.lacs.affairs.companyuser.model;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.companyuser.bean.LACSCompanyUserBean;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;

/**
 * リース会社別リースユーザーマスタスーパークラス.
 * 
 * @author takeda
 * @version 20070904
 */
public abstract class LACSCompanyUserModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "顧客別開示先メンテナンス";
	}

	/**
	 * 業務個別処理.
	 * 
	 * @throws Exception
	 *             例外発生時.
	 */
	public final void performSub() throws Exception {
		super.getLogger().start();
		LACSCommonBean commonBean = super.getCommonBean();

		LACSCompanyUserBean companyUserBean = super.getCompanyUserBean();

		commonBean.setDispID("C002");
		super.setForwardPath("/jsp/C002.jsp");

		this.init(companyUserBean);
		this.initSub(companyUserBean);
		this.businessProc(companyUserBean);
		super.getLogger().end();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piCompanyUserBean
	 *            リース会社別リースユーザーマスタBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected abstract void businessProc(LACSCompanyUserBean piCompanyUserBean) throws Exception;

	/**
	 * 初期化.
	 * 
	 * @param piCompanyUserBean
	 *            リース会社別リースユーザーマスタBean
	 */
	protected final void init(LACSCompanyUserBean piCompanyUserBean) {
		piCompanyUserBean.setMessage("");
		piCompanyUserBean.setLeasCompanyCode(super.getInput("targetCompanyCode", "").trim());
		piCompanyUserBean.setTorihikiCode(super.getInput("targetTorihikiCode", "").trim());
		piCompanyUserBean.setCondCompanyCode(super.getInput("condCompanyCode", "").trim());
		piCompanyUserBean.setCondTorihikiCode(super.getInput("condTorihikiCode", "").trim());
		piCompanyUserBean.setCondCosmosCode(super.getInput("condCosmosCode", ""));

		piCompanyUserBean.setProcMode(super.getParam("procMode", 0));

		piCompanyUserBean.setleasCompanyNm(super.getInput("leasCompanyNm", "").trim());
		piCompanyUserBean.setleasCompany(super.getInput("leasCompany", "").trim());

		String pageNo = super.getInput("PageNo", "").trim();
		if (pageNo != null && pageNo.length() > 0) {
			piCompanyUserBean.setPageNo(Integer.parseInt(super.getInput("PageNo", "").trim()));
			piCompanyUserBean.setCurrentW(Integer.parseInt(super.getInput("PageNo", "").trim()));
		}
		else {
			piCompanyUserBean.setPageNo(1);
			piCompanyUserBean.setCurrentW(1);
		}

	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piCompanyUserBean
	 *            リース会社別リースユーザーマスタBean
	 * @exception Exception
	 *                例外発生時
	 */
	protected abstract void initSub(LACSCompanyUserBean piCompanyUserBean) throws Exception;

	/**
	 * コンボボックス生成.
	 * 
	 * @param piCompanyUserBean
	 *            リース会社別リースユーザーマスタBean
	 */
	protected void prepareComoboBox(LACSCompanyUserBean piCompanyUserBean) {
		return;
	}

}
