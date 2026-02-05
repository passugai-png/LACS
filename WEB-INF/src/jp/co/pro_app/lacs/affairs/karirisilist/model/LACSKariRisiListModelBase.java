package jp.co.pro_app.lacs.affairs.karirisilist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.karirisilist.bean.LACSKariRisiListBean;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;

/**
 * リースユーザー別借入利子率マスタ一覧Modelスーパークラス.
 * 
 * @author active
 * @version 20071210
 */
public abstract class LACSKariRisiListModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "借入利子率一覧";
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

		LACSKariRisiListBean kariRisiListBean = super.getKariRisiListBean();

		commonBean.setDispID("K003");
		super.setForwardPath("/jsp/L004.jsp");

		this.init(kariRisiListBean);
		this.initSub(kariRisiListBean);
		this.businessProc(kariRisiListBean);

		super.getLogger().end();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piKariRisiListBean
	 *            リースユーザー別借入利子率マスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSKariRisiListBean piKariRisiListBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piKariRisiListBean
	 *            リースユーザー別借入利子率マスタ一覧Bean
	 */
	protected final void init(LACSKariRisiListBean piKariRisiListBean) {
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piKariRisiListBean
	 *            リースユーザー別借入利子率マスタ一覧Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSKariRisiListBean piKariRisiListBean) throws Exception {
	}

	/**
	 * コンボボックス生成.
	 * 
	 * @param piKariRisiListBean
	 *            リースユーザー別借入利子率マスタ一覧Bean
	 * @throws SQLException
	 *             SQL実行例外
	 */
	protected void prepareComoboBox(LACSKariRisiListBean piKariRisiListBean) throws SQLException {
		LACSComboMaker.makeCombo(piKariRisiListBean, super.getCommonBean(), super.con, this, true);

	}

}
