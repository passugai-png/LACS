package jp.co.pro_app.lacs.affairs.shiharai.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.shiharai.bean.LACSShiharaiBean;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;

/**
 * 支払推移表Modelスーパークラス.
 * 
 * @author katoken
 * @version 20070312
 */
public abstract class LACSShiharaiModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "支払推移表";
	}

	/**
	 * 業務個別処理.
	 * 
	 * @throws Exception
	 *             例外発生時.
	 */
	public void performSub() throws Exception {
		super.getLogger().start();
		LACSCommonBean commonBean = super.getCommonBean();

		LACSShiharaiBean shiharaiBean = super.getShiharaiBean();

		commonBean.setDispID("S001");
		super.setForwardPath("/jsp/S001.jsp");

		this.init(shiharaiBean);
		this.initSub(shiharaiBean);
		this.businessProc(shiharaiBean);

		super.getLogger().end();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSShiharaiBean piShiharaiBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 */
	protected final void init(LACSShiharaiBean piShiharaiBean) {
		piShiharaiBean.setMessage("");
		piShiharaiBean.clearList();
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSShiharaiBean piShiharaiBean) throws Exception {
		return;
	}

	/**
	 * コンボボックス生成.
	 * 
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 * @throws SQLException
	 *             SQL実行例外
	 */

	protected void prepareComoboBox(LACSShiharaiBean piShiharaiBean) throws SQLException {
		LACSComboMaker.makeCombo(piShiharaiBean, super.getCommonBean(), super.con, this, false);
	}

}
