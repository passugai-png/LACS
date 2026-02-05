package jp.co.pro_app.lacs.affairs.companyuserlist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.companyuserlist.bean.LACSCompanyUserListBean;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;

/**
 * リース会社別リースユーザーマスタ一覧Modelスーパークラス.
 * 
 * @author active
 * @version 20071210
 */
public abstract class LACSCompanyUserListModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "顧客別開示先一覧";
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

		LACSCompanyUserListBean companyuserListBean = super.getCompanyUserListBean();

		commonBean.setDispID("C002");
		super.setForwardPath("/jsp/L002.jsp");

		this.init(companyuserListBean);
		this.initSub(companyuserListBean);
		this.businessProc(companyuserListBean);

		super.getLogger().end();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piCompanyUserListBean
	 *            リース会社別リースユーザーマスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSCompanyUserListBean piCompanyUserListBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piCompanyUserListBean
	 *            リース会社別リースユーザーマスタ一覧Bean
	 */
	protected final void init(LACSCompanyUserListBean piCompanyUserListBean) {
		return;
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piCompanyUserListBean
	 *            リース会社別リースユーザーマスタ一覧Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSCompanyUserListBean piCompanyUserListBean) throws Exception {
		return;
	}

	/**
	 * コンボボックス生成.
	 * 
	 * @param piCompanyUserListBean
	 *            リース会社別リースユーザーマスタ一覧Bean
	 * @throws SQLException
	 *             SQL実行例外
	 */

	protected void prepareComoboBox(LACSCompanyUserListBean piCompanyUserListBean) throws SQLException {

		LACSComboMaker.makeCombo(piCompanyUserListBean, super.getCommonBean(), super.con, this, false);

	}
}
