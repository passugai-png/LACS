package jp.co.pro_app.lacs.affairs.companylist.model;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.companylist.bean.LACSCompanyListBean;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;

/**
 * リース会社マスタ一覧Modelスーパークラス.
 * 
 * @author active
 * @version 20071210
 */
public abstract class LACSCompanyListModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "リース会社一覧";
	}

	/**
	 * 業務個別処理.
	 * 
	 * @throws Exception
	 *             例外発生時.
	 */
	public final void performSub() throws Exception {
		if (isForwordEdit()) {
			super.setForwardPath("/self.company");
		}
		else {
			super.getLogger().start();
			LACSCommonBean commonBean = super.getCommonBean();

			LACSCompanyListBean companyListBean = super.getCompanyListBean();

			commonBean.setDispID("C001");

			this.init(companyListBean);
			this.initSub(companyListBean);
			this.businessProc(companyListBean);

			super.setForwardPath("/jsp/L001.jsp");
			super.getLogger().end();
		}
	}

	/**
	 * 遷移先変更処理を行うか.
	 * 
	 * @return true:行う／false:行わない
	 */
	protected boolean isForwordEdit() {
		return false;
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piCompanyListBean
	 *            リース会社マスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSCompanyListBean piCompanyListBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piCompanyListBean
	 *            リース会社マスタ一覧Bean
	 */
	protected final void init(LACSCompanyListBean piCompanyListBean) {
		return;
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piCompanyListBean
	 *            リース会社マスタ一覧Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSCompanyListBean piCompanyListBean) throws Exception {
	}

	/**
	 * コンボボックス生成.
	 * 
	 * @param piCompanyListBean
	 *            リース会社マスタ一覧Bean
	 */
	protected void prepareComoboBox(LACSCompanyListBean piCompanyListBean) {
	}

}
