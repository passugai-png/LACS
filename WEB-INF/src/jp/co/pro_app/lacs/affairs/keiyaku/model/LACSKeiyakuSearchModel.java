package jp.co.pro_app.lacs.affairs.keiyaku.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCheckUtl;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuBean;
import jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuDetailBean;
import jp.co.pro_app.lacs.affairs.keiyaku.data.entity.LACSKeiyakuEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * 契約検索：検索処理Model.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSKeiyakuSearchModel extends LACSKeiyakuModelBase {

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
	 * @param piKeiyakuBean
	 *            契約検索Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSKeiyakuBean piKeiyakuBean) throws Exception {
		piKeiyakuBean.setShowList(false);

		if (this.checkInput(super.getCommonBean(), piKeiyakuBean)) {
			this.getData(piKeiyakuBean);

			if (piKeiyakuBean.getDataMax() > 0) {
				piKeiyakuBean.setShowList(true);
			}
			else {
				message.addMessage(LACSDefine.MessageCode.WARN_DB_NORESULT);
			}
		}

		piKeiyakuBean.setMessage(message.getMessage());
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piKeiyakuBean
	 *            契約検索Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSKeiyakuBean piKeiyakuBean) throws SQLException {

		piKeiyakuBean.setKeiyakuNo(super.getInput("keiyakuNo", ""));
		piKeiyakuBean.setKeiyakuAmtChk(super.getInput("keiyakuAmtChk", ""));
		piKeiyakuBean.setKeiyakuAmt(super.getInput("keiyakuAmt", ""));
		piKeiyakuBean.setKeiyakuTermChk(super.getInput("keiyakuTermChk", ""));
		piKeiyakuBean.setKeiyakuTerm(super.getInput("keiyakuTerm", ""));
		piKeiyakuBean.setKenPatn(super.getInput("kenPatn", ""));
		piKeiyakuBean.setKeiyakuRls(super.getInput("keiyakuRls", ""));

		piKeiyakuBean.setDaihyoBukkenName(super.getInput("daihyoBukkenName", ""));
		piKeiyakuBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));
		piKeiyakuBean.getTradeHanteiKekka().setSelectedValue(super.getInput("tradeHanteiKekka", ""));

		piKeiyakuBean.getKenshuFrom().setDate(super.getInput("kenshuFromEra", ""), super.getInput("kenshuFromData", ""), super.getInput("kenshuFromMonth", ""));
		piKeiyakuBean.getKenshuTo().setDate(super.getInput("kenshuToEra", ""), super.getInput("kenshuToData", ""), super.getInput("kenshuToMonth", ""));
		piKeiyakuBean.getManryoFrom().setDate(super.getInput("manryoFromEra", ""), super.getInput("manryoFromData", ""), super.getInput("manryoFromMonth", ""));
		piKeiyakuBean.getManryoTo().setDate(super.getInput("manryoToEra", ""), super.getInput("manryoToData", ""), super.getInput("manryoToMonth", ""));
		piKeiyakuBean.getKaiyakuFrom().setDate(super.getInput("kaiyakuFromEra", ""), super.getInput("kaiyakuFromData", ""), super.getInput("kaiyakuFromMonth", ""));
		piKeiyakuBean.getKaiyakuTo().setDate(super.getInput("kaiyakuToEra", ""), super.getInput("kaiyakuToData", ""), super.getInput("kaiyakuToMonth", ""));

		piKeiyakuBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));

		piKeiyakuBean.setCurrent(1);
		piKeiyakuBean.setMessage("");
	}

	private void getData(LACSKeiyakuBean piKeiyakuBean) throws SQLException {
		LACSKeiyakuEntity keiyakuEntity = new LACSKeiyakuEntity(this);
		LACSCommonBean commonBean = super.getCommonBean();
		LACSKeiyakuDetailBean detail = null;

		int per = piKeiyakuBean.getPer();
		int current = piKeiyakuBean.getCurrent();
		int from = (current - 1) * per + 1;
		int to = (current) * per;

		try {
			piKeiyakuBean.clearList();

			keiyakuEntity.setCon(super.con);

			keiyakuEntity.setCosmosCode(piKeiyakuBean.getLeasCompany().getValue());

			keiyakuEntity.setEnabledUser(commonBean.getEnableUserList());

			keiyakuEntity.setKeiyakuNo(piKeiyakuBean.getKeiyakuNo());

			keiyakuEntity.setKeiyakuAmt(piKeiyakuBean.getKeiyakuAmt());

			keiyakuEntity.setKeiyakuTerm(piKeiyakuBean.getKeiyakuTerm());
			keiyakuEntity.setKenPatn(piKeiyakuBean.getKenPatn());
			keiyakuEntity.setKeiyakuRls(piKeiyakuBean.getKeiyakuRls());

			keiyakuEntity.setDaihyoBukkenName(piKeiyakuBean.getDaihyoBukkenName());
			keiyakuEntity.setTradeHanteiKekkaCode(piKeiyakuBean.getTradeHanteiKekka().getValue());

			keiyakuEntity.setKenshuFrom(piKeiyakuBean.getKenshuFrom().getYYYYMM());
			keiyakuEntity.setKenshuTo(piKeiyakuBean.getKenshuTo().getYYYYMM());
			keiyakuEntity.setManryoFrom(piKeiyakuBean.getManryoFrom().getYYYYMM());
			keiyakuEntity.setManryoTo(piKeiyakuBean.getManryoTo().getYYYYMM());
			keiyakuEntity.setKaiyakuFrom(piKeiyakuBean.getKaiyakuFrom().getYYYYMM());
			keiyakuEntity.setKaiyakuTo(piKeiyakuBean.getKaiyakuTo().getYYYYMM());

			keiyakuEntity.setFrom(from);
			keiyakuEntity.setTo(to);

			keiyakuEntity.execSQL();

			while (keiyakuEntity.next()) {
				detail = new LACSKeiyakuDetailBean();
				piKeiyakuBean.addDetail(detail);

				detail.setLeasCompanyCode(keiyakuEntity.getLeasCompanyCode());
				detail.setLeasCompanyName(keiyakuEntity.getLeasCompanyName());
				detail.setCosmosCode(keiyakuEntity.getCosmosCode());
				detail.setLeaseUserName(keiyakuEntity.getLeasUserName());
				detail.setKeiyakuNo(keiyakuEntity.getKeiyakuNo());
				detail.setHyoujiKeiyakuNo(keiyakuEntity.getHyoujiKeiyakuNo());
				detail.setTradeHanteiKekkaCode(keiyakuEntity.getTradeHanteiKekkaCode());
				detail.setTradeHanteiKekka(keiyakuEntity.getTradeHanteiKekkaName());
				detail.setKenshuYMD(LACSCommand.toDateYYYYMMDD(commonBean, super.con, this, keiyakuEntity.getKenshuYMD()));
				detail.setManryoYMD(LACSCommand.toDateYYYYMMDD(commonBean, super.con, this, keiyakuEntity.getManryoYMD()));
				detail.setKaiyakuYMD(LACSCommand.toDateYYYYMMDD(commonBean, super.con, this, keiyakuEntity.getKaiyakuYMD()));
				detail.setKeiyakuTerm(keiyakuEntity.getKeiyakuTerm());
				detail.setDaihyouBukkenName(keiyakuEntity.getDaihyoBukkenName());

			}

			piKeiyakuBean.setDataMax(keiyakuEntity.getAllDataCount());
		}
		finally {
			keiyakuEntity.close();
		}
	}

	/**
	 * 入力チェック.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piKeiyakuBean
	 *            契約検索Bean
	 * @return チェック結果
	 * @throws SQLException
	 */
	private boolean checkInput(LACSCommonBean piCommonBean, LACSKeiyakuBean piKeiyakuBean) throws SQLException {
		boolean result = true;

		LACSCheckUtl checkUtl = new LACSCheckUtl(message);

		result &= checkUtl.checkDate(piCommonBean, super.con, this, "検収月(開始)", piKeiyakuBean.getKenshuFrom(), false);
		result &= checkUtl.checkDate(piCommonBean, super.con, this, "検収月(終了)", piKeiyakuBean.getKenshuTo(), false);
		result &= checkUtl.checkDate(piCommonBean, super.con, this, "満了月(開始)", piKeiyakuBean.getManryoFrom(), false);
		result &= checkUtl.checkDate(piCommonBean, super.con, this, "満了月(終了)", piKeiyakuBean.getManryoTo(), false);
		result &= checkUtl.checkDate(piCommonBean, super.con, this, "解約月(開始)", piKeiyakuBean.getKaiyakuFrom(), false);
		result &= checkUtl.checkDate(piCommonBean, super.con, this, "解約月(終了)", piKeiyakuBean.getKaiyakuTo(), false);

		result &= checkUtl.checkDateOrder("検収月", piKeiyakuBean.getKenshuFrom(), piKeiyakuBean.getKenshuTo());
		result &= checkUtl.checkDateOrder("満了月", piKeiyakuBean.getManryoFrom(), piKeiyakuBean.getManryoTo());
		result &= checkUtl.checkDateOrder("解約月", piKeiyakuBean.getKaiyakuFrom(), piKeiyakuBean.getKaiyakuTo());

		result &= checkUtl.checkNumeric("契約金額", piKeiyakuBean.getKeiyakuAmt());

		result &= checkUtl.checkNumeric("リース期間", piKeiyakuBean.getKeiyakuTerm());

		return result;
	}
}
