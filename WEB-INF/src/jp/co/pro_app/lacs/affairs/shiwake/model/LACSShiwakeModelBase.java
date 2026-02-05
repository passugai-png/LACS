package jp.co.pro_app.lacs.affairs.shiwake.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.shiwake.bean.LACSShiwakeBean;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;

/**
 * 仕訳照会Modelスーパークラス.
 * 
 * @author katoken
 * @version 20070312
 */
public abstract class LACSShiwakeModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "仕訳照会";
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

		LACSShiwakeBean shiwakeBean = super.getShiwakeBean();

		commonBean.setDispID("S002");
		super.setForwardPath("/jsp/S002.jsp");

		this.init(shiwakeBean);
		this.initSub(shiwakeBean);
		this.businessProc(shiwakeBean);

		super.getLogger().end();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piShiwakeBean
	 *            仕訳照会Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSShiwakeBean piShiwakeBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piShiwakeBean
	 *            仕訳照会Bean
	 */
	protected final void init(LACSShiwakeBean piShiwakeBean) {
		piShiwakeBean.clearList();
		piShiwakeBean.setMessage("");
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piShiwakeBean
	 *            仕訳照会Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSShiwakeBean piShiwakeBean) throws Exception {
		return;
	}

	/**
	 * コンボボックス生成.
	 * 
	 * @param piShiwakeBean
	 *            仕訳照会Bean
	 * @throws SQLException
	 *             SQL実行例外
	 */

	protected void prepareComoboBox(LACSShiwakeBean piShiwakeBean) throws SQLException {
		LACSComboMaker.makeCombo(piShiwakeBean, super.getCommonBean(), super.con, this, false);
	}

}
