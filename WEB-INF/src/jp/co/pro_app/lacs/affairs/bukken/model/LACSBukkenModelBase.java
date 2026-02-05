package jp.co.pro_app.lacs.affairs.bukken.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.bukken.bean.LACSBukkenBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;

/**
 * 物件検索Modelスーパークラス.
 * 
 * @author katoken
 * @version 20070312
 */
public abstract class LACSBukkenModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "物件検索";
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

		LACSBukkenBean bukkenBean = super.getBukkenBean();

		commonBean.setDispID("K002");
		super.setForwardPath("/jsp/K002.jsp");

		this.init(bukkenBean);
		this.initSub(bukkenBean);
		this.businessProc(bukkenBean);

		super.getLogger().end();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piBukkenBean
	 *            物件検索Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSBukkenBean piBukkenBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piBukkenBean
	 *            物件検索Bean
	 */
	protected final void init(LACSBukkenBean piBukkenBean) {
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piBukkenBean
	 *            物件検索Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSBukkenBean piBukkenBean) throws Exception {
		return;
	}

	/**
	 * コンボボックス生成.
	 * 
	 * @param piBukkenBean
	 *            物件検索Bean
	 * @throws SQLException
	 *             SQL実行例外
	 */
	protected void prepareComoboBox(LACSBukkenBean piBukkenBean) throws SQLException {
		LACSComboMaker.makeCombo(piBukkenBean, super.getCommonBean(), super.con, this, false);
	}

}
