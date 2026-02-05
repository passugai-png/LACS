package jp.co.pro_app.lacs.affairs.syousai.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiBean;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;

/**
 * 契約詳細Modelスーパークラス.
 * 
 * @author yokota
 * @version 20081017
 */
public abstract class LACSSyousaiModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "契約詳細照会";
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

		LACSSyousaiBean syousaiBean = super.getSyousaiBean();
		commonBean.setDispID("K004");
		super.setForwardPath("/jsp/K004.jsp");

		this.init(syousaiBean);
		this.initSub(syousaiBean);
		this.businessProc(syousaiBean);

		super.getLogger().end();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piSyousaiBean
	 *            契約詳細Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSSyousaiBean piSyousaiBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piSyousaiBean
	 *            契約詳細Bean
	 */
	protected final void init(LACSSyousaiBean piSyousaiBean) {
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piSyousaiBean
	 *            契約詳細Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSSyousaiBean piSyousaiBean) throws Exception {
		piSyousaiBean.clearList();
		piSyousaiBean.setMessage("");
	}

	/**
	 * コンボボックス生成.
	 * 
	 * @param piSyousaiBean
	 *            契約詳細Bean
	 * @throws SQLException
	 *             SQL実行例外
	 */

	protected void prepareComoboBox(LACSSyousaiBean piSyousaiBean) throws SQLException {
		LACSComboMaker.makeCombo(piSyousaiBean, super.getCommonBean(), super.con, this, false);
	}

}
