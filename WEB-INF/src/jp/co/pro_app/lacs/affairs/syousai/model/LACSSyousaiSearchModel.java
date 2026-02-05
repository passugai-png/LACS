package jp.co.pro_app.lacs.affairs.syousai.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiBean;
import jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiDetailBean;
import jp.co.pro_app.lacs.affairs.syousai.data.entity.LACSSyousaiDetailEntity;
import jp.co.pro_app.lacs.affairs.syousai.data.entity.LACSSyousaiEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * 契約詳細：検索処理Model.
 * 
 * @author yokota
 * @version 20081017
 */
public class LACSSyousaiSearchModel extends LACSSyousaiModelBase {

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "表示";
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piSyousaiBean
	 *            契約詳細Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSSyousaiBean piSyousaiBean) throws Exception {
		piSyousaiBean.setShowList(false);

		if (checkInput(super.getCommonBean(), piSyousaiBean)) {
			this.getData(piSyousaiBean);

			if (piSyousaiBean.getDataMax() > 0) {
				piSyousaiBean.setShowList(true);
			}
			else {
				message.addMessage(LACSDefine.MessageCode.WARN_DB_NORESULT);
			}
		}

		piSyousaiBean.setMessage(message.getMessage());
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piSyousaiBean
	 *            契約詳細Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSSyousaiBean piSyousaiBean) throws SQLException {

		piSyousaiBean.setKeiyakuNo(super.getInput("keiyakuNo", ""));

		piSyousaiBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));

		piSyousaiBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));
		piSyousaiBean.setDownloadPath("");
		piSyousaiBean.setCSVDownloadPath("");
		piSyousaiBean.setCurrent(1);
		piSyousaiBean.setMessage("");

		piSyousaiBean.clearList();
	}

	private boolean checkInput(LACSCommonBean piCommonBean, LACSSyousaiBean piSyousaiBean) {
		boolean result = true;

		return result;
	}

	private void getData(LACSSyousaiBean piSyousaiBean) throws SQLException {
		LACSCommonBean commonBean = super.getCommonBean();
		LACSSyousaiEntity syousaiEntity = new LACSSyousaiEntity(this, commonBean, piSyousaiBean);
		LACSSyousaiDetailEntity detailEntity = new LACSSyousaiDetailEntity(this);
		LACSSyousaiDetailBean detailBean = null;

		int per = piSyousaiBean.getPer();
		int current = piSyousaiBean.getCurrent();
		int from = (current - 1) * per + 1;
		int to = (current) * per;

		try {
			syousaiEntity.setCon(super.con);

			syousaiEntity.setKeiyakuNo(piSyousaiBean.getKeiyakuNo());

			syousaiEntity.setLeasCompanyCode(piSyousaiBean.getLeasCompanyCode());

			syousaiEntity.execSQL();

			if (syousaiEntity.next()) {
				piSyousaiBean.setKaijisakiName(syousaiEntity.getKaijisakiName());

				piSyousaiBean.setLeaseTerm(syousaiEntity.getLeaseTerm());

				piSyousaiBean.setKeiyakuYmd(LACSCommand.toDateYYYYMMDD(commonBean, super.con, this, syousaiEntity.getKeiyakuYmd()));
				piSyousaiBean.setKensyuYmd(LACSCommand.toDateYYYYMMDD(commonBean, super.con, this, syousaiEntity.getKensyuYmd()));
				piSyousaiBean.setManryoYmd(LACSCommand.toDateYYYYMMDD(commonBean, super.con, this, syousaiEntity.getManryoYmd()));
				piSyousaiBean.setKaiyakuYmd(LACSCommand.toDateYYYYMMDD(commonBean, super.con, this, syousaiEntity.getKaiyakuYmd()));

				piSyousaiBean.setLeasTradeBunruiName(syousaiEntity.getTradeHanteiKekkaName());
				piSyousaiBean.setDaihyoBukkenName(syousaiEntity.getDaihyoBukkenName());
				piSyousaiBean.setJoutoJoukenName(syousaiEntity.getJoutoJoukenName());
				piSyousaiBean.setWariyasuKonyuSentakuKenName(syousaiEntity.getWariyasuKonyuSentakuKenName());
				piSyousaiBean.setTokubetiSiyoBukkenName(syousaiEntity.getTokubetiSiyoBukkenName());
				piSyousaiBean.setTyutoKaiyakuName(syousaiEntity.getTyutoKaiyakuName());

				piSyousaiBean.setKeiWaribikiGenzaiKati(syousaiEntity.getKeiWaribikiGenzaiKati());
				piSyousaiBean.setLeaseRyouSogaku(syousaiEntity.getLeaseRyouSogaku());
				piSyousaiBean.setMitumoriGenkinKakaku(syousaiEntity.getMitumoriGenkinKakaku());
				piSyousaiBean.setTaxSougaku(syousaiEntity.getTaxSougaku());
				piSyousaiBean.setRisokuSoutouSougaku(syousaiEntity.getRisokuSoutouSougaku());
				piSyousaiBean.setZanHosyou(syousaiEntity.getZanHosyou());
				piSyousaiBean.setIjikanriHiSougaku(syousaiEntity.getIjikanriHiSougaku());
				piSyousaiBean.setEkimuteikyoHiSougaku(syousaiEntity.getEkimuteikyoHiSougaku());

				piSyousaiBean.setRisokuHaibunHohouName(syousaiEntity.getRisokuHaibunHohouName());
				piSyousaiBean.setLeaseRyouKeisanKijunName(syousaiEntity.getLeaseRyouKeisanKijunName());
				piSyousaiBean.setGnkskHasuChoseiHohouName(syousaiEntity.getGnkskHasuChoseiHohouName());
				piSyousaiBean.setSyougakuSisanName(syousaiEntity.getSyougakuSisanName());

			}
			detailEntity.setCon(super.con);

			detailEntity.setKeiyakuNo(piSyousaiBean.getKeiyakuNo());
			detailEntity.setLeasCompanyCode(piSyousaiBean.getLeasCompanyCode());

			detailEntity.setFrom(from);
			detailEntity.setTo(to);

			detailEntity.execSQL();
			while (detailEntity.next()) {

				detailBean = new LACSSyousaiDetailBean();
				piSyousaiBean.addDetail(detailBean);

				detailBean.setBukkenNo(detailEntity.getBukkenNo());
				detailBean.setBukkenName(detailEntity.getBukkenName());
				detailBean.setKikaiNo(detailEntity.getKikaiNo());
				detailBean.setSisanSyuruiName(detailEntity.getSisanSyuruiName());
				detailBean.setSettiBasyo(detailEntity.getSettiBasyo());
				detailBean.setSuryo(detailEntity.getSuryo());
				detailBean.setTani(detailEntity.getTani());
				detailBean.setBknWaribikiGenzaiKati(detailEntity.getBknWaribikiGenzaiKati());
				detailBean.setWaribikiKeisanRisiRitu(detailEntity.getWaribikiKeisanRisiRitu());
				detailBean.setRisokuKeisanRisiRitu(detailEntity.getRisokuKeisanRisiRitu());
				detailBean.setSaiyoSkkKeijoKbnName(detailEntity.getSaiyoSkkKeijoKbnName());
				detailBean.setZankaHosyoUmu(detailEntity.getZankaHosyoUmu());
				detailBean.setIjikanriHi(detailEntity.getIjikanriHi());
				detailBean.setEkimuteikyoHi(detailEntity.getEkimuteikyoHi());
				detailBean.setRskKeijHohoKbn(detailEntity.getRskKeijHohoKbn());
			}
			piSyousaiBean.setDataMax(detailEntity.getAllDataCount());
		}
		finally {
			syousaiEntity.close();
			detailEntity.close();
		}
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}
}
