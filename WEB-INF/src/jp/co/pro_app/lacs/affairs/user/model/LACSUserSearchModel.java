package jp.co.pro_app.lacs.affairs.user.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.user.bean.LACSUserBean;
import jp.co.pro_app.lacs.affairs.user.data.entity.LACSUserEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;

/**
 * リースユーザーマスタ：検索処理Model.
 * 
 * @author takeda
 * @version 20070911
 */
public class LACSUserSearchModel extends LACSUserModelBase {

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
	 * @param piUserBean
	 *            リースユーザーマスタBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSUserBean piUserBean) throws Exception {

		this.getData(piUserBean);

		piUserBean.setShowList(true);

		super.setForwardPath("/jsp/U001.jsp");
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piUserBean
	 *            リースユーザーマスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSUserBean piUserBean) throws SQLException {

		super.prepareComoboBox(piUserBean);

		piUserBean.getDispControl().clear();
		piUserBean.setMessage("");
	}

	/**
	 * データ取得.
	 * 
	 * @param piUserBean
	 *            リースユーザーマスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	private void getData(LACSUserBean piUserBean) throws SQLException {
		LACSUserEntity userEntity = new LACSUserEntity(this);

		String kessanKi = "";

		try {
			userEntity.setCon(super.con);

			userEntity.setCosmosCode(Command.changeQt(piUserBean.getUserCosmosCode()));

			piUserBean.setUserName("");
			piUserBean.setUserZip1("");
			piUserBean.setUserZip2("");
			piUserBean.setUserAddress1("");
			piUserBean.setUserAddress2("");
			piUserBean.setUserTelNo("");
			piUserBean.setUserTantoName("");
			piUserBean.getSeirekiWarekiCode().setSelectedValue("");
			piUserBean.getAcShrKbn().setSelectedValue("");
			piUserBean.setKesnKiMM("");
			piUserBean.setKesnKiDD("");
			piUserBean.setGtjSrtKeiJgiFlg("0");
			piUserBean.setGtjRlsKeiJgiFlg("0");
			piUserBean.setGtjSgkKeiJgiFlg("0");
			piUserBean.setGtjCytKaiJgiFlg("0");
			piUserBean.setDataSource("");

			piUserBean.getOldItenYukeiSkkHohoCd().setSelectedValue("121");
			piUserBean.getOldItenMukeiSkkHohoCd().setSelectedValue("121");
			piUserBean.getOldItengiYukeiSkkHohoCd().setSelectedValue("121");
			piUserBean.getOldItengiMukeiSkkHohoCd().setSelectedValue("121");

			piUserBean.getOldMbriAbriKbn().setSelectedValue("");
			piUserBean.getOldRskClcHohoCd().setSelectedValue("");
			piUserBean.getOldFknTnkiHohoCd().setSelectedValue("");
			piUserBean.getOldIjiKnriHyoJyoKbn().setSelectedValue("");
			piUserBean.getOldEkmTeikHyoJyoKbn().setSelectedValue("");
			piUserBean.getOldGnkskHasuChseCd().setSelectedValue("");
			piUserBean.getOldFknTnkiHasuChseCd().setSelectedValue("");
			piUserBean.setOldKnuAmtTutiUmFlg("0");

			piUserBean.getNewItenYukeiSkkHohoCd().setSelectedValue("121");
			piUserBean.getNewItenMukeiSkkHohoCd().setSelectedValue("121");
			piUserBean.getNewItengiYukeiSkkHohoCd().setSelectedValue("121");
			piUserBean.getNewItengiMukeiSkkHohoCd().setSelectedValue("121");

			piUserBean.getNewMbriAbriKbn().setSelectedValue("");
			piUserBean.getNewRskClcHohoCd().setSelectedValue("");
			piUserBean.getNewFknTnkiHohoCd().setSelectedValue("");
			piUserBean.getNewIjiKnriHyoJyoKbn().setSelectedValue("");
			piUserBean.getNewEkmTeikHyoJyoKbn().setSelectedValue("");
			piUserBean.getNewGnkskHasuChseCd().setSelectedValue("");
			piUserBean.getNewFknTnkiHasuChseCd().setSelectedValue("");
			piUserBean.setNewKnuAmtTutiUmFlg("0");
			piUserBean.getSyosuKetasu().setSelectedValue(4);

			piUserBean.setPdfCompanyName("");
			piUserBean.setPdfCompanyZip1("");
			piUserBean.setPdfCompanyZip2("");
			piUserBean.setPdfCompanyAddress1("");
			piUserBean.setPdfCompanyAddress2("");
			piUserBean.setPdfCompanyTel("");

			piUserBean.setOldSrtKeiJgiFlg("0");
			piUserBean.setOldRlsKeiJgiFlg("0");
			piUserBean.setOldSgkKeiJgiFlg("0");
			piUserBean.setOldCytKaiJgiFlg("0");
			piUserBean.setNewSrtKeiJgiFlg("0");
			piUserBean.setNewRlsKeiJgiFlg("0");
			piUserBean.setNewSgkKeiJgiFlg("0");
			piUserBean.setNewCytKaiJgiFlg("0");

			piUserBean.setOldSumUnt("0");
			piUserBean.setNewSumUnt("1");
			
			//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 start
			piUserBean.getBatchPrintTimingCd().setSelectedValue("");
			piUserBean.setLcShzkSho("");
			piUserBean.setLcShzkBu("");
			piUserBean.setLcShzkGrp("");
			piUserBean.setLcShzkNm("");
			piUserBean.setLcTntCd("");
			piUserBean.setLcTntNm("");
			//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 end
			
			dispControlCommon.getDBDispControl(LACSDefine.INFO_ALL, 0);

			userEntity.execSQL();

			if (userEntity.next()) {

				kessanKi = userEntity.getKesnKi();

				piUserBean.setUserName(userEntity.getUserName());
				piUserBean.setUserZip1(userEntity.getUserZip1());
				piUserBean.setUserZip2(userEntity.getUserZip2());
				piUserBean.setUserAddress1(userEntity.getUserAddress1());
				piUserBean.setUserAddress2(userEntity.getUserAddress2());
				piUserBean.setUserTelNo(userEntity.getUserTelNo());
				piUserBean.setUserTantoName(userEntity.getUserTantoName());
				piUserBean.getSeirekiWarekiCode().setSelectedValue(userEntity.getSeirekiWarekiCode());
				piUserBean.getAcShrKbn().setSelectedValue(userEntity.getACShrKbn());
				piUserBean.setKesnKiMM(kessanKi.substring(0, 2));
				piUserBean.setKesnKiDD(kessanKi.substring(2, 4));
				piUserBean.setGtjSrtKeiJgiFlg(userEntity.getGtjSrtKeiJgiFlg());
				piUserBean.setGtjRlsKeiJgiFlg(userEntity.getGtjRlsKeiJgiFlg());
				piUserBean.setGtjSgkKeiJgiFlg(userEntity.getGtjSgkKeiJgiFlg());
				piUserBean.setGtjCytKaiJgiFlg(userEntity.getGtjCytKaiJgiFlg());
				piUserBean.setDataSource(userEntity.getDataSource());
				piUserBean.getOldItenYukeiSkkHohoCd().setSelectedValue(userEntity.getOldItenYukeiSkkHohoCd());
				piUserBean.getOldItenMukeiSkkHohoCd().setSelectedValue(userEntity.getOldItenMukeiSkkHohoCd());
				piUserBean.getOldItengiYukeiSkkHohoCd().setSelectedValue(userEntity.getOldItengiYukeiSkkHohoCd());
				piUserBean.getOldItengiMukeiSkkHohoCd().setSelectedValue(userEntity.getOldItengiMukeiSkkHohoCd());
				piUserBean.getOldMbriAbriKbn().setSelectedValue(userEntity.getOldMbriAbriKbn());
				piUserBean.getOldRskClcHohoCd().setSelectedValue(userEntity.getOldRskClcHohoCd());
				piUserBean.getOldFknTnkiHohoCd().setSelectedValue(userEntity.getOldFknTnkiHohoCd());
				piUserBean.getOldIjiKnriHyoJyoKbn().setSelectedValue(userEntity.getOldIjiKnriHyoJyoKbn());
				piUserBean.getOldEkmTeikHyoJyoKbn().setSelectedValue(userEntity.getOldEkmTeikHyoJyoKbn());
				piUserBean.getOldGnkskHasuChseCd().setSelectedValue(userEntity.getOldGnkskHasuChseCd());
				piUserBean.getOldFknTnkiHasuChseCd().setSelectedValue(userEntity.getOldFknTnkiHasuChseCd());
				piUserBean.setOldKnuAmtTutiUmFlg(userEntity.getOldKnuAmtTutiUmFlg());
				piUserBean.getNewItenYukeiSkkHohoCd().setSelectedValue(userEntity.getNewItenYukeiSkkHohoCd());
				piUserBean.getNewItenMukeiSkkHohoCd().setSelectedValue(userEntity.getNewItenMukeiSkkHohoCd());
				piUserBean.getNewItengiYukeiSkkHohoCd().setSelectedValue(userEntity.getNewItengiYukeiSkkHohoCd());
				piUserBean.getNewItengiMukeiSkkHohoCd().setSelectedValue(userEntity.getNewItengiMukeiSkkHohoCd());
				piUserBean.getNewMbriAbriKbn().setSelectedValue(userEntity.getNewMbriAbriKbn());
				piUserBean.getNewRskClcHohoCd().setSelectedValue(userEntity.getNewRskClcHohoCd());
				piUserBean.getNewFknTnkiHohoCd().setSelectedValue(userEntity.getNewFknTnkiHohoCd());
				piUserBean.getNewIjiKnriHyoJyoKbn().setSelectedValue(userEntity.getNewIjiKnriHyoJyoKbn());
				piUserBean.getNewEkmTeikHyoJyoKbn().setSelectedValue(userEntity.getNewEkmTeikHyoJyoKbn());
				piUserBean.getNewGnkskHasuChseCd().setSelectedValue(userEntity.getNewGnkskHasuChseCd());
				piUserBean.getNewFknTnkiHasuChseCd().setSelectedValue(userEntity.getNewFknTnkiHasuChseCd());
				piUserBean.setNewKnuAmtTutiUmFlg(userEntity.getNewKnuAmtTutiUmFlg());
				piUserBean.getSyosuKetasu().setSelectedValue(userEntity.getSyosuKetasu());

				piUserBean.setPdfCompanyName(userEntity.getPdfCompanyName());
				piUserBean.setPdfCompanyZip1(userEntity.getPdfCompanyZip1());
				piUserBean.setPdfCompanyZip2(userEntity.getPdfCompanyZip2());
				piUserBean.setPdfCompanyAddress1(userEntity.getPdfCompanyAddress1());
				piUserBean.setPdfCompanyAddress2(userEntity.getPdfCompanyAddress2());
				piUserBean.setPdfCompanyTel(userEntity.getPdfCompanyTel());

				piUserBean.setOldSrtKeiJgiFlg(userEntity.getOldSrtKeiJgiFlg());
				piUserBean.setOldRlsKeiJgiFlg(userEntity.getOldRlsKeiJgiFlg());
				piUserBean.setOldSgkKeiJgiFlg(userEntity.getOldSgkKeiJgiFlg());
				piUserBean.setOldCytKaiJgiFlg(userEntity.getOldCytKaiJgiFlg());
				piUserBean.setNewSrtKeiJgiFlg(userEntity.getNewSrtKeiJgiFlg());
				piUserBean.setNewRlsKeiJgiFlg(userEntity.getNewRlsKeiJgiFlg());
				piUserBean.setNewSgkKeiJgiFlg(userEntity.getNewSgkKeiJgiFlg());
				piUserBean.setNewCytKaiJgiFlg(userEntity.getNewCytKaiJgiFlg());

				piUserBean.setOldSumUnt(userEntity.getOldSumUnit());
				piUserBean.setNewSumUnt(userEntity.getNewSumUnit());
				
				//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/21 start
				piUserBean.getBatchPrintTimingCd().setSelectedValue(userEntity.getBatchPrintTimingCd());
				piUserBean.setLcShzkSho(userEntity.getLcShzkSho());
				piUserBean.setLcShzkBu(userEntity.getLcShzkBu());
				piUserBean.setLcShzkGrp(userEntity.getLcShzkGrp());
				piUserBean.setLcShzkNm(userEntity.getLcShzkNm());
				piUserBean.setLcTntCd(userEntity.getLcTntCd());
				piUserBean.setLcTntNm(userEntity.getLcTntNm());
				//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/21 end

				dispControlCommon.getDBDispControl(piUserBean.getUserCosmosCode(), 0);

			}
			else {
				dispControlCommon.getDBDispControl(LACSDefine.INFO_ALL, 0);
			}

			piUserBean.setDataMax(userEntity.getAllDataCount());
		}
		finally {
			userEntity.close();
		}
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}

}
