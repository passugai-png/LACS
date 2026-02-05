package jp.co.pro_app.lacs.affairs.bukken.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.bukken.bean.LACSBukkenBean;
import jp.co.pro_app.lacs.affairs.bukken.bean.LACSBukkenDetailBean;
import jp.co.pro_app.lacs.affairs.bukken.data.entity.LACSBukkenEntity;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * 物件検索：検索処理Model.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSBukkenSearchModel extends LACSBukkenModelBase {

	/**
	 * 業務個別処理.
	 * 
	 * @param piBukkenBean
	 *            物件検索Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSBukkenBean piBukkenBean) throws Exception {
		piBukkenBean.setShowList(false);

		if (this.checkInput(super.getCommonBean(), piBukkenBean)) {
			this.getData(piBukkenBean);

			if (piBukkenBean.getDataMax() > 0) {
				piBukkenBean.setShowList(true);
			}
			else {
				message.addMessage(LACSDefine.MessageCode.WARN_DB_NORESULT);
			}
		}

		piBukkenBean.setMessage(message.getMessage());
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piBukkenBean
	 *            物件検索Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSBukkenBean piBukkenBean) throws SQLException {

		piBukkenBean.setKeiyakuNo(super.getInput("keiyakuNo", ""));
		piBukkenBean.setBukkenName(super.getInput("bukkenName", ""));
		piBukkenBean.setBukkenNameSerchPtn(super.getInput("bukkenNameSerchPtn", ""));
		piBukkenBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));
		piBukkenBean.getTradeHanteiKekka().setSelectedValue(super.getInput("tradeHanteiKekka", ""));

		piBukkenBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));

		piBukkenBean.setCurrent(1);
		piBukkenBean.setMessage("");
	}

	private void getData(LACSBukkenBean piBukkenBean) throws SQLException {
		LACSBukkenEntity bukkenEntity = new LACSBukkenEntity(this);
		LACSCommonBean commonBean = super.getCommonBean();

		LACSBukkenDetailBean detail = null;

		int per = piBukkenBean.getPer();
		int current = piBukkenBean.getCurrent();
		int from = (current - 1) * per + 1;
		int to = (current) * per;

		try {
			piBukkenBean.clearList();

			bukkenEntity.setCon(super.con);

			bukkenEntity.setCosmosCode(piBukkenBean.getLeasCompany().getValue());
			bukkenEntity.setEnabledUser(commonBean.getEnableUserList());

			bukkenEntity.setKeiyakuNo(piBukkenBean.getKeiyakuNo());
			bukkenEntity.setBukkenName(piBukkenBean.getBukkenName());
			bukkenEntity.setBukkenNameSerchPtn(piBukkenBean.getBukkenNameSerchPtn());
			bukkenEntity.setTradeHanteiKekkaCode(piBukkenBean.getTradeHanteiKekka().getValue());

			bukkenEntity.setFrom(from);
			bukkenEntity.setTo(to);

			bukkenEntity.execSQL();

			while (bukkenEntity.next()) {
				detail = new LACSBukkenDetailBean();
				piBukkenBean.addDetail(detail);

				detail.setLeasCompanyCode(bukkenEntity.getLeasCompanyCode());
				detail.setLeasCompanyName(bukkenEntity.getLeasCompanyName());
				detail.setCosmosCode(bukkenEntity.getCosmosCode());
				detail.setLeaseUserName(bukkenEntity.getLeasUserName());
				detail.setKeiyakuNo(bukkenEntity.getKeiyakuNo());
				detail.setHyoujiKeiyakuNo(bukkenEntity.getHyoujiKeiyakuNo());
				detail.setBukkenNo(bukkenEntity.getBukkenNo());
				detail.setBukkenEdaNo(bukkenEntity.getBukkenEdaNo());
				detail.setTradeHanteiKekkaCode(bukkenEntity.getTradeHanteiKekkaCode());
				detail.setTradeHanteiKekka(bukkenEntity.getTradeHanteiKekkaName());
				detail.setBukkenName(bukkenEntity.getBukkenName());

			}

			piBukkenBean.setDataMax(bukkenEntity.getAllDataCount());
		}
		finally {
			bukkenEntity.close();
		}
	}

	/**
	 * 入力チェック.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piBukkenBean
	 *            契約検索Bean
	 * @return チェック結果
	 */
	private boolean checkInput(LACSCommonBean piCommonBean, LACSBukkenBean piBukkenBean) {
		boolean result = true;

		return result;
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "検索";
	}
}
