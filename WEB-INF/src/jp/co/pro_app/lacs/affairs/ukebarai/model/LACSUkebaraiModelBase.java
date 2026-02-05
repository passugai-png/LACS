package jp.co.pro_app.lacs.affairs.ukebarai.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCheckUtl;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.common.command.LACSMessage;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;

/**
 * 受払合計表Modelスーパークラス.
 * 
 * @author active
 * @version 20080808
 */
public abstract class LACSUkebaraiModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "受払合計表";
	}

	/**
	 * 処理開始ログ出力.
	 * 
	 * @param piPrintBean
	 *            月次帳票出力Bean
	 */
	protected void start(LACSUkebaraiBean piPrintBean) {
		super.getLogger().start();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void performSub() throws Exception {
		LACSCommonBean commonBean = super.getCommonBean();

		LACSUkebaraiBean ukebaraiBean = super.getUkebaraiBean();
		this.start(ukebaraiBean);
		commonBean.setDispID("U002");

		this.init(ukebaraiBean);
		this.initSub(ukebaraiBean);
		this.businessProc(ukebaraiBean);

		super.setForwardPath("/jsp/U002.jsp");
		super.getLogger().end();

	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSUkebaraiBean piUkebaraiBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 */
	protected final void init(LACSUkebaraiBean piUkebaraiBean) {
		piUkebaraiBean.clearList();
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSUkebaraiBean piUkebaraiBean) throws Exception {
		return;
	}

	/**
	 * コンボボックス生成.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @throws SQLException
	 *             SQL実行例外
	 */

	protected void prepareComoboBox(LACSUkebaraiBean piUkebaraiBean) throws SQLException {
		LACSComboMaker.makeCombo(piUkebaraiBean, super.getCommonBean(), super.con, this, false);
	}

	/**
	 * 入力チェックを行う.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @return boolean チェック結果
	 * @throws SQLException
	 *             SQL実行例外
	 */
	protected boolean checkInput(LACSCommonBean piCommonBean, LACSUkebaraiBean piUkebaraiBean) throws SQLException {
		boolean result = true;

		LACSCheckUtl checkUtl = new LACSCheckUtl(message);
		String displayString = "";

		if (piCommonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {

			displayString = "開示先";

		}
		else {
			displayString = "リース会社";
		}

		if (piUkebaraiBean.getLeasCompany().getValue().equals("")) {
			if (piCommonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_NON_CHECK, displayString);
				result = false;
			}
		}

		if (piUkebaraiBean.getPageFrom() == 0) {

			String termFrom = "";
			piUkebaraiBean.getTermFrom().setYYYYMMDD(termFrom);

			termFrom = LACSCommand.toDateYYYYMMDD(piCommonBean, con, this, piUkebaraiBean.getTermFrom());
			result &= checkUtl.checkDate("対象期間：開始日", termFrom);
			piUkebaraiBean.getTermFrom().setYYYYMMDD(termFrom);

			result &= checkUtl.checkMandatory("対象期間：○○ヶ月", piUkebaraiBean.getTsukiSu());
			result &= checkUtl.checkNumeric("対象期間：○○ヶ月", piUkebaraiBean.getTsukiSu());

		}

		return result;
	}

	/**
	 * 帳票用入力チェックを行う.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @param piMessage
	 *            エラーメッセージ
	 * @return boolean チェック結果
	 * @throws SQLException
	 *             SQL実行例外
	 */
	protected boolean checkInputForReport(LACSCommonBean piCommonBean, LACSUkebaraiBean piUkebaraiBean, LACSMessage piMessage) throws SQLException {
		boolean result = true;

		boolean reportSelected = false;

		reportSelected |= piUkebaraiBean.getGokei().getCheckOutput() == 1;
		reportSelected |= piUkebaraiBean.getSisan().getCheckOutput() == 1;
		reportSelected |= piUkebaraiBean.getLease().getCheckOutput() == 1;
		reportSelected |= piUkebaraiBean.getHiyo().getCheckOutput() == 1;

		if (!reportSelected) {
			piMessage.addMessage(LACSDefine.MessageCode.ERROR_RELATE_NON_CHECK, "出力対象帳票");
			result = false;
		}

		return result &= checkInput(piCommonBean, piUkebaraiBean);
	}

	/**
	 * PDF・CSV出力用の入力項目取得処理.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 */
	protected void getInputForOUtput(LACSUkebaraiBean piUkebaraiBean) {

		piUkebaraiBean.getLeasCompany().setSelectedValue(super.getInput("hidLeasCompany", ""));
		piUkebaraiBean.getGokei().init(this.getParam("chkGokei", 0));
		piUkebaraiBean.getSisan().init(this.getParam("chkSisan", 0));
		piUkebaraiBean.getLease().init(this.getParam("chkLease", 0));
		piUkebaraiBean.getHiyo().init(this.getParam("chkHiyo", 0));

		piUkebaraiBean.setMessage("");

	}

}
