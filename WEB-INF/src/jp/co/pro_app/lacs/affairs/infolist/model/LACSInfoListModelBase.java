package jp.co.pro_app.lacs.affairs.infolist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.infolist.bean.LACSInfoListBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;
import jp.co.pro_app.projframe.common.html.ComboArray;
import jp.co.pro_app.projframe.common.html.ComboValue;

/**
 * お知らせ一覧Modelスーパークラス.
 * 
 * @author active
 * @version 20071210
 */
public abstract class LACSInfoListModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "お知らせ一覧";
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

		LACSInfoListBean infoListBean = super.getInfoListBean();

		commonBean.setDispID("I001");
		super.setForwardPath("/jsp/L006.jsp");

		this.init(infoListBean);
		this.initSub(infoListBean);
		this.businessProc(infoListBean);

		super.getLogger().end();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piInfoListBean
	 *            お知らせ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSInfoListBean piInfoListBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piInfoListBean
	 *            お知らせ一覧Bean
	 */
	protected final void init(LACSInfoListBean piInfoListBean) {
		return;
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piInfoListBean
	 *            お知らせ一覧Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSInfoListBean piInfoListBean) throws Exception {
		return;
	}

	/**
	 * コンボボックス生成.
	 * 
	 * @param piInfoListBean
	 *            リース会社別リースユーザーマスタ一覧Bean
	 * @throws SQLException
	 *             SQL実行例外
	 */
	protected void prepareComoboBox(LACSInfoListBean piInfoListBean) throws SQLException {
		LACSComboMaker.makeCombo(piInfoListBean, super.getCommonBean(), super.con, this, false);
		ComboArray leasCompanyArray = piInfoListBean.getLeasCompany();
		leasCompanyArray.add(1, new ComboValue("全開示先", LACSDefine.INFO_ALL));
	}
}
