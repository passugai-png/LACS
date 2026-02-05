package jp.co.pro_app.lacs.affairs.password.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.password.bean.LACSPasswordBean;
import jp.co.pro_app.lacs.common.model.LACSConstDBModelBase;

/**
 * 支払推移表Modelスーパークラス.
 * 
 * @author katoken
 * @version 20070312
 */
public abstract class LACSPasswordModelBase extends LACSConstDBModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcName() {
		return "パスワード変更";
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

		LACSPasswordBean bean = super.getPasswordBean();

		commonBean.setDispID("P000");

		super.setForwardPath("/jsp/P000.jsp");

		this.init(bean);
		this.initSub(bean);
		this.businessProc(bean);

		super.getLogger().end();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piBean
	 *            支払推移表Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSPasswordBean piBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piBean
	 *            支払推移表Bean
	 */
	protected final void init(LACSPasswordBean piBean) {
		piBean.setMessage("");
		piBean.setOldPassword("");
		piBean.setNewPassword1("");
		piBean.setNewPassword2("");
		piBean.clearList();
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piBean
	 *            支払推移表Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSPasswordBean piBean) throws Exception {
		piBean.setUserId("");
	}

	/**
	 * コンボボックス生成.
	 * 
	 * @param piBean
	 *            支払推移表Bean
	 * @throws SQLException
	 *             SQL実行例外
	 */
	protected void prepareComoboBox(LACSPasswordBean piBean) throws SQLException {
		LACSComboMaker.makeCombo(piBean, super.getCommonBean(), super.con, this, false);
	}

	/**
	 * セッションチェックフラグ取得.
	 * 
	 * @return セッションチェックを行うか
	 */
	protected boolean isSessionCheck() {
		return false;
	}

}
