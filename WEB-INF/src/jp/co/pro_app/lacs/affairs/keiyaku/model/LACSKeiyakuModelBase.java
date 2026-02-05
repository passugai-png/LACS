package jp.co.pro_app.lacs.affairs.keiyaku.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuBean;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;

/**
 * 契約検索Modelスーパークラス.
 * 
 * @author katoken
 * @version 20070312
 */
public abstract class LACSKeiyakuModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "契約検索";
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

		LACSKeiyakuBean keiyakuBean = super.getKeiyakuBean();

		commonBean.setDispID("K001");
		super.setForwardPath("/jsp/K001.jsp");

		this.init(keiyakuBean);
		this.initSub(keiyakuBean);
		this.businessProc(keiyakuBean);

		super.getLogger().end();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piKeiyakuBean
	 *            契約検索Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSKeiyakuBean piKeiyakuBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piKeiyakuBean
	 *            契約検索Bean
	 */
	protected final void init(LACSKeiyakuBean piKeiyakuBean) {

		super.getMReportBean().setDownloadPath("");

	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piKeiyakuBean
	 *            契約検索Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSKeiyakuBean piKeiyakuBean) throws Exception {
		return;
	}

	/**
	 * コンボボックス生成.
	 * 
	 * @param piKeiyakuBean
	 *            契約検索Bean
	 * @throws SQLException
	 *             SQL実行例外
	 */

	protected void prepareComoboBox(LACSKeiyakuBean piKeiyakuBean) throws SQLException {
		LACSComboMaker.makeCombo(piKeiyakuBean, super.getCommonBean(), super.con, this, false);
	}

}
