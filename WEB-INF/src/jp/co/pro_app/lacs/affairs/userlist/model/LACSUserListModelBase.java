package jp.co.pro_app.lacs.affairs.userlist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.userlist.bean.LACSUserListBean;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;

/**
 * リースユーザーマスタ一覧Modelスーパークラス.
 * 
 * @author active
 * @version 20071210
 */
public abstract class LACSUserListModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "開示先一覧";
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

		LACSUserListBean userListBean = super.getUserListBean();

		commonBean.setDispID("U001");
		super.setForwardPath("/jsp/L003.jsp");

		this.init(userListBean);
		this.initSub(userListBean);
		this.businessProc(userListBean);

		super.getLogger().end();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piUserListBean
	 *            リースユーザーマスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSUserListBean piUserListBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piUserListBean
	 *            リースユーザーマスタ一覧Bean
	 */
	protected final void init(LACSUserListBean piUserListBean) {
		return;
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piUserListBean
	 *            リースユーザーマスタ一覧Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSUserListBean piUserListBean) throws Exception {
		return;
	}

	/**
	 * コンボボックス生成.
	 * 
	 * @param piUserListBean
	 *            リースユーザーマスタ一覧Bean
	 * @throws SQLException
	 *             SQL実行例外
	 */

	protected void prepareComoboBox(LACSUserListBean piUserListBean) throws SQLException {

		LACSComboMaker.makeCombo(piUserListBean, super.getCommonBean(), super.con, this, true);

	}

}
