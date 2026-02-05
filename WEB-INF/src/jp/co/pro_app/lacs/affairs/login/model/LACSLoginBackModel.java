package jp.co.pro_app.lacs.affairs.login.model;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSCopyRightEntity;
import jp.co.pro_app.lacs.affairs.login.bean.LACSLoginBean;
import jp.co.pro_app.lacs.affairs.login.data.entity.LACSCompnayEntity;

/**
 * ログイン：ログイン処理.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSLoginBackModel extends LACSLoginModelBase {

	/**
	 * 業務固有処理.
	 * 
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 * @exception Exception
	 *                実行例外
	 */
	protected void businessProc(LACSLoginBean piShiharaiBean) throws Exception {
		LACSCompnayEntity entity = new LACSCompnayEntity(this);
		LACSCopyRightEntity copyrightEntity = new LACSCopyRightEntity(this);
		LACSCommonBean commonBean = super.getCommonBean();

		try {
			entity.setCon(this.con);

			entity.execSQL();

			if (entity.next()) {
				piShiharaiBean.setLogo(entity.getLogoImage());
				piShiharaiBean.setLoginInfo(entity.getLoginInfo());
				piShiharaiBean.setSecurityInfo(entity.getSecurityInfo());
			}
			copyrightEntity.setCon(super.con);

			copyrightEntity.execSQL();
			if (copyrightEntity.next()) {
				commonBean.setCopyRight(copyrightEntity.getCopyRight());
			}
		}
		finally {
			entity.close();
			copyrightEntity.close();
		}
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 * @exception Exception
	 *                実行例外
	 */
	protected void initSub(LACSLoginBean piShiharaiBean) throws Exception {

		LACSCommonBean commonBean = super.getCommonBean();

		piShiharaiBean.init(commonBean);

		piShiharaiBean.setUserId(super.getInput("userId", ""));

		super.prepareComoboBox(piShiharaiBean);

	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "戻る";
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
