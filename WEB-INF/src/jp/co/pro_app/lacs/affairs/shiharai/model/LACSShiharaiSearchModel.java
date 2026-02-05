package jp.co.pro_app.lacs.affairs.shiharai.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCheckUtl;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.shiharai.bean.LACSShiharaiBean;
import jp.co.pro_app.lacs.affairs.shiharai.bean.LACSShiharaiDetailBean;
import jp.co.pro_app.lacs.affairs.shiharai.data.entity.LACSShiharaiEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * 支払推移表：検索処理Model.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiharaiSearchModel extends LACSShiharaiModelBase {

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
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSShiharaiBean piShiharaiBean) throws Exception {
		piShiharaiBean.setShowList(false);

		if (checkInput(super.getCommonBean(), piShiharaiBean)) {
			this.getData(piShiharaiBean);

			if (piShiharaiBean.getDataMax() > 0) {
				piShiharaiBean.setShowList(true);
			}
			else {
				message.addMessage(LACSDefine.MessageCode.WARN_DB_NORESULT);
			}
		}

		piShiharaiBean.setMessage(message.getMessage());
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSShiharaiBean piShiharaiBean) throws SQLException {

		piShiharaiBean.setKeiyakuNo(super.getInput("keiyakuNo", ""));
		piShiharaiBean.setBukkenNo(super.getInput("bukkenNo", ""));
		piShiharaiBean.setBukkenEdaNo(super.getInput("bukkenEdaNo", ""));
		piShiharaiBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));
		piShiharaiBean.getTradeHanteiKekka().setSelectedValue(super.getInput("tradeHanteiKekka", ""));
		piShiharaiBean.getTermFrom().setDate(super.getInput("termFromEra", ""), super.getInput("termFromData", ""), super.getInput("termFromMonth", ""));
		piShiharaiBean.getTermTo().setDate(super.getInput("termToEra", ""), super.getInput("termToData", ""), super.getInput("termToMonth", ""));

		piShiharaiBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));

		piShiharaiBean.setCurrent(1);
		piShiharaiBean.setMessage("");
	}

	private boolean checkInput(LACSCommonBean piCommonBean, LACSShiharaiBean piShiharaiBean) throws SQLException {
		boolean result = true;

		LACSCheckUtl checkUtl = new LACSCheckUtl(message);

		if (piCommonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {
			result &= checkUtl.checkMandatory("開示先", piShiharaiBean.getLeasCompany().getValue());
		}

		if (piShiharaiBean.getPageFrom() == 0) {
			result &= checkUtl.checkDate(piCommonBean, super.con, this, "期間(開始)", piShiharaiBean.getTermFrom(), false);
			result &= checkUtl.checkDate(piCommonBean, super.con, this, "期間(終了)", piShiharaiBean.getTermTo(), false);
			result &= checkUtl.checkDateOrder("期間", piShiharaiBean.getTermFrom(), piShiharaiBean.getTermTo());
		}
		return result;
	}

	private void getData(LACSShiharaiBean piShiharaiBean) throws SQLException {
		LACSShiharaiEntity shiharaiEntity = new LACSShiharaiEntity(this);
		LACSCommonBean commonBean = super.getCommonBean();
		LACSShiharaiDetailBean detail = null;

		int per = piShiharaiBean.getPer();
		int current = piShiharaiBean.getCurrent();
		int from = (current - 1) * per + 1;
		int to = (current) * per;

		try {
			shiharaiEntity.setCon(super.con);

			shiharaiEntity.setCosmosCode(piShiharaiBean.getLeasCompany().getValue());

			shiharaiEntity.setKeiyakuNo(piShiharaiBean.getKeiyakuNo());
			shiharaiEntity.setBukkenNo(piShiharaiBean.getBukkenNo());
			shiharaiEntity.setBukkenEdaNo(piShiharaiBean.getBukkenEdaNo());
			shiharaiEntity.setTradeHanteiKekkaCode(piShiharaiBean.getTradeHanteiKekka().getValue());

			if (piShiharaiBean.getPageFrom() == 0) {
				shiharaiEntity.setTermFrom(piShiharaiBean.getTermFrom().getYYYYMM());
				shiharaiEntity.setTermTo(piShiharaiBean.getTermTo().getYYYYMM());
			}

			shiharaiEntity.setFrom(from);
			shiharaiEntity.setTo(to);

			shiharaiEntity.execSQL();

			while (shiharaiEntity.next()) {
				detail = new LACSShiharaiDetailBean();
				piShiharaiBean.addDetail(detail);

				detail.setDate(LACSCommand.toDateYYYYMM(commonBean, super.con, this, shiharaiEntity.getDate() + "01"));
				detail.setLeasAmount(shiharaiEntity.getLeasAmount());
				detail.setStaxAmount(shiharaiEntity.getLeasAmountSTAX());
				detail.setGanponAmount(shiharaiEntity.getGanponAmount());
				detail.setRisokuAmount(shiharaiEntity.getRisokuAmount());
				detail.setIjiAmount(shiharaiEntity.getIjiKanriAmount());
				detail.setEkimuAmount(shiharaiEntity.getEkimuTeikyouAmount());
				detail.setShoukyakuAmount(shiharaiEntity.getShoukyakuAmount());

			}

			piShiharaiBean.setDataMax(shiharaiEntity.getAllDataCount());
		}
		finally {
			shiharaiEntity.close();
		}
	}
}
