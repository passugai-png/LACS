package jp.co.pro_app.lacs.affairs.karirisi.model;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.karirisi.bean.LACSKariRisiBean;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;

/**
 * リースユーザー別借入利子率マスタスーパークラス.
 * 
 * @author active
 * @version 20071210
 */
public abstract class LACSKariRisiModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "借入利子率メンテナンス";
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

		LACSKariRisiBean kariRisiBean = super.getKariRisiBean();

		commonBean.setDispID("K003");

		this.init(kariRisiBean);
		this.initSub(kariRisiBean);
		this.businessProc(kariRisiBean);
		super.getLogger().end();

	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piShiharaiBean
	 *            リースユーザー別借入利子率マスタBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSKariRisiBean piShiharaiBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piKariRisiBean
	 *            リースユーザー別借入利子率マスタBean
	 */
	protected final void init(LACSKariRisiBean piKariRisiBean) {
		piKariRisiBean.setMessage("");
		piKariRisiBean.setCosmosCode(super.getInput("targetCosmosCode", "").trim());
		piKariRisiBean.setCondCosmosCode(super.getInput("condCosmosCode", "").trim());
		piKariRisiBean.setProcMode(super.getParam("procMode", 0));

		piKariRisiBean.setleasCompanyNm(super.getInput("leasCompanyNm", "").trim());
		piKariRisiBean.setleasCompany(super.getInput("leasCompany", "").trim());

		String pageNo = super.getInput("PageNo", "").trim();
		if (pageNo != null && pageNo.length() > 0) {
			piKariRisiBean.setPageNo(Integer.parseInt(super.getInput("PageNo", "").trim()));
			piKariRisiBean.setCurrentW(Integer.parseInt(super.getInput("PageNo", "").trim()));
		}
		else {
			piKariRisiBean.setPageNo(1);
			piKariRisiBean.setCurrentW(1);
		}

	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piKariRisiBean
	 *            リースユーザー別借入利子率マスタBean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSKariRisiBean piKariRisiBean) throws Exception {
		return;
	}

	/**
	 * コンボボックス生成.
	 * 
	 * @param piKariRisiBean
	 *            リースユーザー別借入利子率マスタBean
	 */

	protected void prepareComoboBox(LACSKariRisiBean piKariRisiBean) {
	}

}
