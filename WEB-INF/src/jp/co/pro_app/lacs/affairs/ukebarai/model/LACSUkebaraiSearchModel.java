package jp.co.pro_app.lacs.affairs.ukebarai.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.affairs.ukebarai.common.LACSUkebaraiCommon;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * 受払合計表：検索処理Model.
 * 
 * @author active
 * @version 20080809
 */
public class LACSUkebaraiSearchModel extends LACSUkebaraiModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "検索";
	}

	/**
	 * 処理開始ログ出力.
	 * 
	 * @param piPrintBean
	 *            月次帳票出力Bean
	 */
	protected void start(LACSUkebaraiBean piPrintBean) {
		super.getLogger().start(piPrintBean.getLeasCompany());
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
		piUkebaraiBean.setShowList(false);
		LACSCommonBean commonBean = super.getCommonBean();

		if (checkInput(commonBean, piUkebaraiBean)) {
			LACSUkebaraiCommon.getUkebaraiData(commonBean, piUkebaraiBean, this, this.con);
			/*
			 * piUkebaraiBean.setShowList(true); piUkebaraiBean.setUkbGokei("1"); piUkebaraiBean.setUkbSisan("1"); piUkebaraiBean.setUkbLease("1"); piUkebaraiBean.setUkbHiyo("1");
			 */
			if (piUkebaraiBean.getDataMax() > 0) {
				piUkebaraiBean.setShowList(true);
			}
			else {
				message.addMessage(LACSDefine.MessageCode.WARN_DB_NORESULT);
			}
		}

		piUkebaraiBean.setMessage(message.getMessage());

	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSUkebaraiBean piUkebaraiBean) throws SQLException {
		String termFrom = "";
		termFrom = super.getInput("termFromData", "") + super.getInput("termFromMonth", "") + super.getInput("termFromDay", "");
		if ("".equals(termFrom)) {
			piUkebaraiBean.getTermFrom().setDate(super.getInput("Era", ""), super.getInput("Data", ""), super.getInput("Month", ""), super.getInput("Day", ""));
		}
		else {
			piUkebaraiBean.getTermFrom().setDate(super.getInput("termFromEra", ""), super.getInput("termFromData", ""), super.getInput("termFromMonth", ""), super.getInput("termFromDay", ""));
		}
		piUkebaraiBean.setNextFocus(this.getParam("nextFocus", 0));
		piUkebaraiBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));
		piUkebaraiBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));
		piUkebaraiBean.setTsukiSu(super.getInput("tsukiSu", ""));

		// piUkebaraiBean.setPathGokei("");
		// piUkebaraiBean.setPathSisan("");
		// piUkebaraiBean.setPathLease("");
		// piUkebaraiBean.setPathHiyo("");
		// piUkebaraiBean.setChkGokei("");
		// piUkebaraiBean.setChkSisan("");
		// piUkebaraiBean.setChkLease("");
		// piUkebaraiBean.setChkHiyo("");
		piUkebaraiBean.getGokei().init(0);
		piUkebaraiBean.getSisan().init(0);
		piUkebaraiBean.getLease().init(0);
		piUkebaraiBean.getHiyo().init(0);

		piUkebaraiBean.setCurrent(1);
		piUkebaraiBean.setMessage("");
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}
}
