package jp.co.pro_app.lacs.affairs.shiwake.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCheckUtl;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.shiwake.bean.LACSShiwakeBean;
import jp.co.pro_app.lacs.affairs.shiwake.bean.LACSShiwakeDetailBean;
import jp.co.pro_app.lacs.affairs.shiwake.bean.LACSShiwakeMonthBean;
import jp.co.pro_app.lacs.affairs.shiwake.data.entity.LACSShiwakeDetailEntity;
import jp.co.pro_app.lacs.affairs.shiwake.data.entity.LACSShiwakeMonthEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * 仕訳照会：検索処理Model.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiwakeSearchModel extends LACSShiwakeModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "検索";
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piShiwakeBean
	 *            仕訳照会Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSShiwakeBean piShiwakeBean) throws Exception {
		piShiwakeBean.setShowList(false);

		if (checkInput(super.getCommonBean(), piShiwakeBean)) {
			this.getData(piShiwakeBean);

			if (piShiwakeBean.getDataMax() > 0) {
				piShiwakeBean.setShowList(true);
			}
			else {
				message.addMessage(LACSDefine.MessageCode.WARN_DB_NORESULT);
			}
		}

		piShiwakeBean.setMessage(message.getMessage());

	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piShiwakeBean
	 *            仕訳照会Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSShiwakeBean piShiwakeBean) throws SQLException {

		piShiwakeBean.setKeiyakuNo(super.getInput("keiyakuNo", ""));
		piShiwakeBean.setBukkenNo(super.getInput("bukkenNo", ""));
		piShiwakeBean.setBukkenEdaNo(super.getInput("bukkenEdaNo", ""));
		piShiwakeBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));
		piShiwakeBean.getTradeHanteiKekka().setSelectedValue(super.getInput("tradeHanteiKekka", ""));
		piShiwakeBean.getTermFrom().setDate(super.getInput("termFromEra", ""), super.getInput("termFromData", ""), super.getInput("termFromMonth", ""));
		piShiwakeBean.getTermTo().setDate(super.getInput("termToEra", ""), super.getInput("termToData", ""), super.getInput("termToMonth", ""));

		piShiwakeBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));

		piShiwakeBean.setCurrent(1);
		piShiwakeBean.setMessage("");
	}

	private boolean checkInput(LACSCommonBean piCommonBean, LACSShiwakeBean piShiwakeBean) throws SQLException {
		boolean result = true;

		LACSCheckUtl checkUtl = new LACSCheckUtl(message);

		if (piCommonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {

			result &= checkUtl.checkMandatory("開示先", piShiwakeBean.getLeasCompany().getValue());

		}

		if (piShiwakeBean.getPageFrom() == 0) {
			result &= checkUtl.checkDate(piCommonBean, super.con, this, "期間(開始)", piShiwakeBean.getTermFrom(), false);
			result &= checkUtl.checkDate(piCommonBean, super.con, this, "期間(終了)", piShiwakeBean.getTermTo(), false);
			result &= checkUtl.checkDateOrder("期間", piShiwakeBean.getTermFrom(), piShiwakeBean.getTermTo());
		}

		return result;
	}

	private void getData(LACSShiwakeBean piShiwakeBean) throws SQLException {
		LACSShiwakeMonthEntity monthEntity = new LACSShiwakeMonthEntity(this);
		LACSShiwakeDetailEntity detailEntity = new LACSShiwakeDetailEntity(this);

		LACSCommonBean commonBean = super.getCommonBean();

		LACSShiwakeMonthBean monthBean = null;
		LACSShiwakeDetailBean detailBean = null;

		int per = piShiwakeBean.getPer();
		int current = piShiwakeBean.getCurrent();
		int from = (current - 1) * per + 1;
		int to = (current) * per;

		try {
			monthEntity.setCon(super.con);

			monthEntity.setCosmosCode(piShiwakeBean.getLeasCompany().getValue());

			monthEntity.setKeiyakuNo(piShiwakeBean.getKeiyakuNo());
			monthEntity.setBukkenNo(piShiwakeBean.getBukkenNo());
			monthEntity.setBukkenEdaNo(piShiwakeBean.getBukkenEdaNo());
			monthEntity.setTradeHanteiKekkaCode(piShiwakeBean.getTradeHanteiKekka().getValue());

			if (piShiwakeBean.getPageFrom() == 0) {
				monthEntity.setTermFrom(piShiwakeBean.getTermFrom().getYYYYMM());
				monthEntity.setTermTo(piShiwakeBean.getTermTo().getYYYYMM());
			}

			monthEntity.setFrom(from);
			monthEntity.setTo(to);

			detailEntity.setCon(super.con);

			detailEntity.setCosmosCode(piShiwakeBean.getLeasCompany().getValue());

			detailEntity.setKeiyakuNo(piShiwakeBean.getKeiyakuNo());
			detailEntity.setBukkenNo(piShiwakeBean.getBukkenNo());
			detailEntity.setBukkenEdaNo(piShiwakeBean.getBukkenEdaNo());
			detailEntity.setTradeHanteiKekkaCode(piShiwakeBean.getTradeHanteiKekka().getValue());

			monthEntity.execSQL();

			while (monthEntity.next()) {

				monthBean = new LACSShiwakeMonthBean();
				piShiwakeBean.addDetail(monthBean);

				monthBean.setDate(LACSCommand.toDateYYYYMM(commonBean, super.con, this, monthEntity.getKeijyoYM() + "01"));
				monthBean.setLeasAmount(monthEntity.getLeasAmount());

				detailEntity.setKeijyoYM(monthEntity.getKeijyoYM());

				detailEntity.execSQL();

				while (detailEntity.next()) {

					detailBean = new LACSShiwakeDetailBean();
					monthBean.add(detailBean);

					detailBean.setKamokuLKari(detailEntity.getKamokuLKari());
					detailBean.setKamokuAmountLKari(detailEntity.getKamokuAmountLKari());
					detailBean.setKamokuRKashi(detailEntity.getKamokuRKashi());
					detailBean.setKamokuAmountRKashi(detailEntity.getKamokuAmountRKashi());
				}

				detailEntity.close();
			}

			piShiwakeBean.setDataMax(monthEntity.getAllDataCount());
		}
		finally {
			monthEntity.close();
			detailEntity.close();
		}
	}
}
