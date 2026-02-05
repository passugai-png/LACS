package jp.co.pro_app.lacs.affairs.tanto.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.tanto.bean.LACSTantoBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;
import jp.co.pro_app.projframe.common.html.ComboValue;

/**
 * リースユーザー担当者マスタスーパークラス.
 * 
 * @author active
 * @version 20071210
 */
public abstract class LACSTantoModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "担当者メンテナンス";
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

		LACSTantoBean tantoBean = super.getTantoBean();

		commonBean.setDispID("T001");

		this.init(tantoBean);
		this.initSub(tantoBean);
		this.businessProc(tantoBean);

		super.getLogger().end();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSTantoBean piTantoBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 */
	protected final void init(LACSTantoBean piTantoBean) {
		piTantoBean.setMessage("");
		piTantoBean.setUserID(super.getInput("targetUserID", "").trim());
		piTantoBean.setCondUserID(super.getInput("condUserID", "").trim());
		piTantoBean.setCondUserRight(super.getInput("condUserRight", "0"));
		piTantoBean.setCondCosmosCode(super.getInput("condCosmosCode", "").trim());
		piTantoBean.setProcMode(super.getParam("procMode", 0));

		piTantoBean.setUserRight(super.getInput("userRightMode", "0"));

		String pageNo = super.getInput("PageNo", "").trim();
		if (pageNo != null && pageNo.length() > 0) {
			piTantoBean.setPageNo(Integer.parseInt(super.getInput("PageNo", "").trim()));
			piTantoBean.setCurrentW(Integer.parseInt(super.getInput("PageNo", "").trim()));
		}
		else {
			piTantoBean.setPageNo(1);
			piTantoBean.setCurrentW(1);
		}

	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 * @exception Exception
	 *                例外発生時
	 */
	protected abstract void initSub(LACSTantoBean piTantoBean) throws Exception;

	/**
	 * コンボボックス生成.
	 * 
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 * @throws SQLException
	 *             SQL例外発生時
	 */
	protected void prepareComoboBox(LACSTantoBean piTantoBean) throws SQLException {
		LACSComboMaker.makeCombo(piTantoBean, super.getCommonBean(), super.con, this, true);

		if (piTantoBean.getUserRight().equals(LACSDefine.UserRight.ADMIN) || piTantoBean.getUserRight().equals(LACSDefine.UserRight.GENERAL)) {
			piTantoBean.getLeasCompany().add(1, new ComboValue("全開示先", LACSDefine.INFO_ALL));
		}
	}
}
