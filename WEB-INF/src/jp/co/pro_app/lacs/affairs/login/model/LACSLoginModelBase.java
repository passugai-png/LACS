package jp.co.pro_app.lacs.affairs.login.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.login.bean.LACSLoginBean;
import jp.co.pro_app.lacs.common.model.LACSConstDBModelBase;

/**
 * 支払推移表Modelスーパークラス.
 * 
 * @author katoken
 * @version 20070312
 */
public abstract class LACSLoginModelBase extends LACSConstDBModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcName() {
		return "ログイン";
	}

	/**
	 * 処理開始ログ出力.
	 */
	protected void start() {
		super.getLogger().start();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @throws Exception
	 *             例外発生時.
	 */
	public void performSub() throws Exception {
		LACSCommonBean commonBean = super.getCommonBean();

		LACSLoginBean bean = super.getLoginBean();

		this.start();
		commonBean.setDispID("M000");

		super.setForwardPath("/jsp/M000.jsp");

		this.init(bean);
		this.initSub(bean);
		this.businessProc(bean);

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
	protected void businessProc(LACSLoginBean piShiharaiBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 */
	protected final void init(LACSLoginBean piShiharaiBean) {
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
	protected void initSub(LACSLoginBean piShiharaiBean) throws Exception {
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

	protected void prepareComoboBox(LACSLoginBean piShiharaiBean) throws SQLException {
		LACSComboMaker.makeCombo(piShiharaiBean, super.getCommonBean(), super.con, this, false);
	}

	/**
	 * バッチ処理中チェック.
	 * 
	 * @return バッチ処理フラグ
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public boolean checkBatchExecute() throws SQLException {
		return false;
	}
}
