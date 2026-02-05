package jp.co.pro_app.lacs.affairs.info.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.info.bean.LACSInfoBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;
import jp.co.pro_app.projframe.common.html.ComboArray;
import jp.co.pro_app.projframe.common.html.ComboValue;

/**
 * お知らせスーパークラス.
 * 
 * @author takeda
 * @version 20070904
 */
public abstract class LACSInfoModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "お知らせメンテナンス";
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

		LACSInfoBean infoBean = super.getInfoBean();

		commonBean.setDispID("I001");

		this.init(infoBean);
		this.initSub(infoBean);
		this.businessProc(infoBean);
		super.getLogger().end();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piInfoBean
	 *            お知らせBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSInfoBean piInfoBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piInfoBean
	 *            お知らせBean
	 */
	protected final void init(LACSInfoBean piInfoBean) {
		piInfoBean.setMessage("");
		piInfoBean.setCondStartYmd(super.getInput("condStartYmd", "").trim());
		piInfoBean.setCondEndYmd(super.getInput("condEndYmd", "").trim());
		piInfoBean.setCondInfoData(super.getInput("condInfoData", ""));
		piInfoBean.getLeasCompany().setSelectedValue(super.getInput("condleasCompany", ""));
		piInfoBean.setProcMode(super.getParam("procMode", 0));

		String pageNo = super.getInput("PageNo", "").trim();
		if (pageNo != null && pageNo.length() > 0) {
			piInfoBean.setPageNo(Integer.parseInt(super.getInput("PageNo", "").trim()));
			piInfoBean.setCurrentW(Integer.parseInt(super.getInput("PageNo", "").trim()));
		}
		else {
			piInfoBean.setPageNo(1);
			piInfoBean.setCurrentW(1);
		}

	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piInfoBean
	 *            お知らせBean
	 * @exception Exception
	 *                例外発生時
	 */
	protected abstract void initSub(LACSInfoBean piInfoBean) throws Exception;

	/**
	 * コンボボックス生成.
	 * 
	 * @param piInfoBean
	 *            お知らせBean
	 * @throws SQLException
	 *             SQL実行例外
	 */
	protected void prepareComoboBox(LACSInfoBean piInfoBean) throws SQLException {
		LACSComboMaker.makeCombo(piInfoBean, super.getCommonBean(), super.con, this, false);
		ComboArray leasCompanyArray = piInfoBean.getLeasCompany();
		leasCompanyArray.add(1, new ComboValue("全開示先", LACSDefine.INFO_ALL));
	}

}
