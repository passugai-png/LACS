package jp.co.pro_app.lacs.affairs.ukebarai.model;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.CheckUtl;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.command.StringUtl;

/**
 * 受払合計表：検索処理Model.
 * 
 * @author active
 * @version 20081204
 */
public class LACSUkebaraiTermChangeModel extends LACSUkebaraiModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "期間変更";
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
		LACSCommonBean commonBean = super.getCommonBean();
		piUkebaraiBean.initsub(commonBean);
		initSub(piUkebaraiBean);
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
		LACSCommonBean commonBean = super.getCommonBean();

		piUkebaraiBean.setNextFocus(this.getParam("nextFocus", 0));
		if (commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER) {
			piUkebaraiBean.getTermFrom().setDate(this.getInput("termFromEra", ""), this.getInput("termFromData", ""), this.getInput("termFromMonth", ""), this.getInput("termFromDay", ""));
			piUkebaraiBean.setTsukiSu(super.getInput("tsukiSu", ""));
		}
		else {
			piUkebaraiBean.getTermFrom().setDate("", this.getInput("termFromData", ""), this.getInput("termFromMonth", ""), this.getInput("termFromDay", ""));
			piUkebaraiBean.setTsukiSu(super.getInput("tsukiSu", ""));
		}

		if (CheckUtl.isInteger(piUkebaraiBean.getTsukiSu())) {
			Date date = null;
			if (CheckUtl.isDate(LACSCommand.toDateYYYYMMDD(commonBean, super.con, this, piUkebaraiBean.getTermFrom()), "yyyyMMdd")) {
				date = Convert.toDate(LACSCommand.toDateYYYYMMDD(commonBean, super.con, this, piUkebaraiBean.getTermFrom()), Convert.FORMAT_YYYYMMDD);
				date = DateUtl.add(Calendar.MONTH, Convert.toInt(piUkebaraiBean.getTsukiSu()), date);
				date = DateUtl.add(Calendar.DAY_OF_YEAR, -1, date);

				LACSCommand.setDateField(commonBean, super.con, this, Convert.toString(DateUtl.getYear(date)) + StringUtl.formatNumber(DateUtl.getMonth(date), "00") + StringUtl.formatNumber(DateUtl.getDay(date)), piUkebaraiBean.getTermTo());
			}
		}

	}
}
