package jp.co.pro_app.lacs.affairs.login.model;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSLoginSecurity;
import jp.co.pro_app.lacs.affairs.login.bean.LACSLoginBean;

/**
 * リース会社トップModel.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSLoginLogoutModel extends LACSLoginModelBase {

	/**
	 * 業務固有初期化.
	 * 
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 * @exception Exception
	 *                実行例外
	 */
	protected void businessProc(LACSLoginBean piShiharaiBean) throws Exception {
		LACSCommonBean commonBean = super.getCommonBean();

		LACSLoginSecurity security = new LACSLoginSecurity(this, super.con, commonBean.getLoginUserId());

		if (security.checkLogin(commonBean.getOneTimePassword())) {
			security.delete();
		}

		piShiharaiBean.setUserId("");

		super.setForwardPath("/jsp/M000.jsp");
	}

	/**
	 * セッションチェックフラグ取得.
	 * 
	 * @return セッションチェックを行うか
	 */
	protected boolean isSessionCheck() {
		return false;
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "ログアウト";
	}

	/**
	 * バッチ実行中無視フラグ.
	 * 
	 * @return true：無視／false：チェックする
	 */
	protected boolean ignoreBatchExecute() {
		return true;
	}
}
