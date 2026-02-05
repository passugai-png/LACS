package jp.co.pro_app.lacs.affairs.top.model;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.top.common.LACSTopCommon;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;

/**
 * 処理メニューModel.
 * 
 * @author katoken
 * @version 20071204
 */
public class LACSTopMenuModel extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "処理メニュー";
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "表示";
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

		commonBean.setDispID("M002");

		LACSTopCommon.getInfo(commonBean, this, this.con);
		commonBean.setInfoFile("");
		this.print();

		super.setForwardPath("/jsp/M002.jsp");
		super.getLogger().end();
	}

	/**
	 * 印刷処理.
	 * 
	 * @throws Exception
	 *             例外発生時
	 */
	protected void print() throws Exception {
	}

	/**
	 * バッチ実行中無視フラグ.
	 * 
	 * @return true：無視／false：チェックする
	 */
	protected boolean ignoreBatchExecute() {
		boolean result = false;
		if (super.getCommonBean().getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER) {
			result = true;
		}

		return result;
	}
}
