package jp.co.pro_app.lacs.affairs.tantolist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.tantolist.bean.LACSTantoListBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;
import jp.co.pro_app.projframe.common.html.ComboValue;

/**
 * リースユーザー担当者マスタ一覧Modelスーパークラス.
 * 
 * @author active
 * @version 20071210
 */
public abstract class LACSTantoListModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "担当者一覧";
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

		LACSTantoListBean tantoListBean = super.getTantoListBean();

		commonBean.setDispID("T001");
		super.setForwardPath("/jsp/L005.jsp");

		this.init(tantoListBean);
		this.initSub(tantoListBean);
		this.businessProc(tantoListBean);

		super.getLogger().end();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piTantoListBean
	 *            リースユーザー担当者マスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSTantoListBean piTantoListBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piTantoListBean
	 *            リースユーザー担当者マスタ一覧Bean
	 */
	protected final void init(LACSTantoListBean piTantoListBean) {
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piTantoListBean
	 *            リースユーザー担当者マスタ一覧Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSTantoListBean piTantoListBean) throws Exception {
		return;
	}

	/**
	 * コンボボックス生成.
	 * 
	 * @param piTantoListBean
	 *            リースユーザー担当者マスタ一覧Bean
	 * @throws SQLException
	 *             SQL実行例外
	 */

	protected void prepareComoboBox(LACSTantoListBean piTantoListBean) throws SQLException {
		LACSComboMaker.makeCombo(piTantoListBean, super.getCommonBean(), super.con, this, true);
		piTantoListBean.getLeasCompany().add(1, new ComboValue("全開示先", LACSDefine.INFO_ALL));
	}

}
