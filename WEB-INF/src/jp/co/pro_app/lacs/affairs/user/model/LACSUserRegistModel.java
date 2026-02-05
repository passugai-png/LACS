package jp.co.pro_app.lacs.affairs.user.model;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCheckUtl;
import jp.co.pro_app.lacs.affairs.user.bean.LACSUserBean;
import jp.co.pro_app.lacs.affairs.user.data.entity.LACSUserCheckEntity;
import jp.co.pro_app.lacs.affairs.user.data.entity.LACSUserEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.StringUtl;
import jp.co.pro_app.projframe.common.dbaccess.MakeSQLInsertBase;
import jp.co.pro_app.projframe.common.dbaccess.MakeSQLUpdateBase;
import jp.co.pro_app.projframe.common.dbaccess.NotSelectExecute;

/**
 * リースユーザーマスタ：登録処理Model.
 * 
 * @author takeda
 * @version 20070911
 */
public class LACSUserRegistModel extends LACSUserModelBase {

	/**
	 * テーブル名.
	 */
	private static final String	TABLE_NAME	= "M_LU";

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "登録";
	}

	/**
	 * データ数.
	 */
	protected int	dataCount	= 0;	// データ数

	/**
	 * 業務個別処理.
	 * 
	 * @param piUserBean
	 *            リースユーザーマスタBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSUserBean piUserBean) throws Exception {

		NotSelectExecute notSelectExecute = new NotSelectExecute();
		ArrayList<String> sqls = null;

		try {
			if (this.checkInput(super.getCommonBean(), piUserBean)) {

				this.getData(piUserBean);

				notSelectExecute.setCon(super.con);

				sqls = dispControlCommon.getSQLDispControl(piUserBean.getUserCosmosCode());
				sqls.add(makeSQL(piUserBean));
				notSelectExecute.execState(sqls);
			}

			if (message.hasMessage()) {
				piUserBean.setMessage(message.getMessage());
				super.setForwardPath("/jsp/U001.jsp");
			}
			else {
				super.setForwardPath("/return.userlist");
			}
		}
		finally {
			notSelectExecute.closeState();
		}
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

		piUserBean.setUserName(super.getInput("userName", ""));
		piUserBean.setUserZip1(super.getInput("userZip1", ""));
		piUserBean.setUserZip2(super.getInput("userZip2", ""));
		piUserBean.setUserAddress1(super.getInput("userAddress1", ""));
		piUserBean.setUserAddress2(super.getInput("userAddress2", ""));
		piUserBean.setUserTelNo(super.getInput("userTelNo", ""));
		piUserBean.setUserTantoName(super.getInput("userTantoName", ""));
		piUserBean.getSeirekiWarekiCode().setSelectedValue(super.getInput("seirekiWarekiCode", ""));
		piUserBean.getAcShrKbn().setSelectedValue(super.getInput("acShrKbn", ""));
		piUserBean.setKesnKiMM(super.getInput("kesnKiMM", ""));
		piUserBean.setKesnKiDD(super.getInput("kesnKiDD", ""));
		piUserBean.setGtjSrtKeiJgiFlg(super.getInput("gtjSrtKeiJgiFlg", ""));
		piUserBean.setGtjRlsKeiJgiFlg(super.getInput("gtjRlsKeiJgiFlg", ""));
		piUserBean.setGtjSgkKeiJgiFlg(super.getInput("gtjSgkKeiJgiFlg", ""));
		piUserBean.setGtjCytKaiJgiFlg(super.getInput("gtjCytKaiJgiFlg", ""));
		piUserBean.setDataSource(super.getInput("dataSource", ""));
		piUserBean.getOldItenYukeiSkkHohoCd().setSelectedValue(super.getInput("oldItenYukeiSkkHohoCd", ""));
		piUserBean.getOldItenMukeiSkkHohoCd().setSelectedValue(super.getInput("oldItenMukeiSkkHohoCd", ""));
		piUserBean.getOldItengiYukeiSkkHohoCd().setSelectedValue(super.getInput("oldItengiYukeiSkkHohoCd", ""));
		piUserBean.getOldItengiMukeiSkkHohoCd().setSelectedValue(super.getInput("oldItengiMukeiSkkHohoCd", ""));
		piUserBean.getOldMbriAbriKbn().setSelectedValue(super.getInput("oldMbriAbriKbn", ""));
		piUserBean.getOldRskClcHohoCd().setSelectedValue(super.getInput("oldRskClcHohoCd", ""));
		piUserBean.getOldFknTnkiHohoCd().setSelectedValue(super.getInput("oldFknTnkiHohoCd", ""));
		piUserBean.getOldIjiKnriHyoJyoKbn().setSelectedValue(super.getInput("oldIjiKnriHyoJyoKbn", ""));
		piUserBean.getOldEkmTeikHyoJyoKbn().setSelectedValue(super.getInput("oldEkmTeikHyoJyoKbn", ""));
		piUserBean.getOldGnkskHasuChseCd().setSelectedValue(super.getInput("oldGnkskHasuChseCd", ""));
		piUserBean.getOldFknTnkiHasuChseCd().setSelectedValue(super.getInput("oldFknTnkiHasuChseCd", ""));
		piUserBean.setOldKnuAmtTutiUmFlg(super.getInput("oldKnuAmtTutiUmFlg", ""));
		piUserBean.getNewItenYukeiSkkHohoCd().setSelectedValue(super.getInput("newItenYukeiSkkHohoCd", ""));
		piUserBean.getNewItenMukeiSkkHohoCd().setSelectedValue(super.getInput("newItenMukeiSkkHohoCd", ""));
		piUserBean.getNewItengiYukeiSkkHohoCd().setSelectedValue(super.getInput("newItengiYukeiSkkHohoCd", ""));
		piUserBean.getNewItengiMukeiSkkHohoCd().setSelectedValue(super.getInput("newItengiMukeiSkkHohoCd", ""));
		piUserBean.getNewMbriAbriKbn().setSelectedValue(super.getInput("newMbriAbriKbn", ""));
		piUserBean.getNewRskClcHohoCd().setSelectedValue(super.getInput("newRskClcHohoCd", ""));
		piUserBean.getNewFknTnkiHohoCd().setSelectedValue(super.getInput("newFknTnkiHohoCd", ""));
		piUserBean.getNewIjiKnriHyoJyoKbn().setSelectedValue(super.getInput("newIjiKnriHyoJyoKbn", ""));
		piUserBean.getNewEkmTeikHyoJyoKbn().setSelectedValue(super.getInput("newEkmTeikHyoJyoKbn", ""));
		piUserBean.getNewGnkskHasuChseCd().setSelectedValue(super.getInput("newGnkskHasuChseCd", ""));
		piUserBean.getNewFknTnkiHasuChseCd().setSelectedValue(super.getInput("newFknTnkiHasuChseCd", ""));
		piUserBean.setNewKnuAmtTutiUmFlg(super.getInput("newKnuAmtTutiUmFlg", ""));
		piUserBean.getSyosuKetasu().setSelectedValue(super.getParam("syosuKetasu", 4));

		piUserBean.setPdfCompanyName(super.getInput("pdfCompanyName", ""));
		piUserBean.setPdfCompanyZip1(super.getInput("pdfCompanyZip1", ""));
		piUserBean.setPdfCompanyZip2(super.getInput("pdfCompanyZip2", ""));
		piUserBean.setPdfCompanyAddress1(super.getInput("pdfCompanyAddress1", ""));
		piUserBean.setPdfCompanyAddress2(super.getInput("pdfCompanyAddress2", ""));
		piUserBean.setPdfCompanyTel(super.getInput("pdfCompanyTel", ""));

		piUserBean.setOldSrtKeiJgiFlg(super.getInput("oldSrtKeiJgiFlg", ""));
		piUserBean.setOldRlsKeiJgiFlg(super.getInput("oldRlsKeiJgiFlg", ""));
		piUserBean.setOldSgkKeiJgiFlg(super.getInput("oldSgkKeiJgiFlg", ""));
		piUserBean.setOldCytKaiJgiFlg(super.getInput("oldCytKaiJgiFlg", ""));
		piUserBean.setNewSrtKeiJgiFlg(super.getInput("newSrtKeiJgiFlg", ""));
		piUserBean.setNewRlsKeiJgiFlg(super.getInput("newRlsKeiJgiFlg", ""));
		piUserBean.setNewSgkKeiJgiFlg(super.getInput("newSgkKeiJgiFlg", ""));
		piUserBean.setNewCytKaiJgiFlg(super.getInput("newCytKaiJgiFlg", ""));

		piUserBean.setOldSumUnt(super.getInput("oldSumUnt", LACSDefine.SumUnit.SUM_UNT_BKN_1));
		piUserBean.setNewSumUnt(super.getInput("newSumUnt", LACSDefine.SumUnit.SUM_UNT_BKN_1));

		//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/21 start
		piUserBean.getBatchPrintTimingCd().setSelectedValue(super.getInput("batchPrintTimingCd", ""));
		piUserBean.setLcShzkSho(super.getInput("lcShzkSho", ""));
		piUserBean.setLcShzkBu(super.getInput("lcShzkBu", ""));
		piUserBean.setLcShzkGrp(super.getInput("lcShzkGrp", ""));
		piUserBean.setLcShzkNm(super.getInput("lcShzkNm", ""));
		piUserBean.setLcTntCd(super.getInput("lcTntCd", ""));
		piUserBean.setLcTntNm(super.getInput("lcTntNm", ""));
		//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/21 end
		//20200529 出力タイミング 追加 arai
		piUserBean.getBatchPrintTimingCd().setSelectedValue(super.getInput("batchPrintTimingCd", ""));

		dispControlCommon.getInputDispControl();

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

		try {
			userEntity.setCon(super.con);

			userEntity.setCosmosCode(piUserBean.getUserCosmosCode());

			userEntity.execSQL();

			piUserBean.setDataMax(userEntity.getAllDataCount());
		}
		finally {
			userEntity.close();
		}

		LACSUserCheckEntity userCheckEntity = new LACSUserCheckEntity(this, piUserBean);
		try {
			userCheckEntity.setCon(super.con);

			userCheckEntity.setCosmosCode(piUserBean.getUserCosmosCode());

			userCheckEntity.execSQL();

			dataCount = userCheckEntity.getAllDataCount();
		}
		finally {
			userCheckEntity.close();
		}

	}

	/**
	 * 入力チェック.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piUserBean
	 *            リースユーザーマスタBean
	 * @return チェック結果
	 * @throws SQLException
	 *             SQL実行例外
	 */
	private boolean checkInput(LACSCommonBean piCommonBean, LACSUserBean piUserBean) throws SQLException {
		boolean result = true;

		LACSCheckUtl checkUtl = new LACSCheckUtl(message);

		result &= checkUtl.checkMandatory("開示先コード", piUserBean.getUserCosmosCode());
		result &= checkUtl.checkTabooChar("開示先コード", piUserBean.getUserCosmosCode());

		result &= checkUtl.checkMandatory("開示先", piUserBean.getUserName());

		//MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 start
		//MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/05/28 start
		//if ("1".equals(piCommonBean.getControlTyukiPdf())) {
		if ("1".equals(piCommonBean.getControlTyukiPdf())||("0".equals(piCommonBean.getControlTyukiPdf())&&"1".equals(piCommonBean.getAdress()))) {
		//MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/05/28 end
		//if ("1".equals(piCommonBean.getAdress())) {
		//MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 end
			result &= checkUtl.checkMandatory("郵便番号１", piUserBean.getUserZip1());
		}
		
		result &= checkUtl.checkNumeric("郵便番号１", piUserBean.getUserZip1());

		//MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 start
		//MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/05/28 start
		//if ("1".equals(piCommonBean.getControlTyukiPdf())) {
		if ("1".equals(piCommonBean.getControlTyukiPdf())||("0".equals(piCommonBean.getControlTyukiPdf())&&"1".equals(piCommonBean.getAdress()))) {
		//MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/05/28 end
		//if ("1".equals(piCommonBean.getAdress())) {
		//MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 end
			result &= checkUtl.checkMandatory("郵便番号２", piUserBean.getUserZip2());
		}
		
		result &= checkUtl.checkNumeric("郵便番号２", piUserBean.getUserZip2());

		//MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 start
		//MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/05/28 start
		//if ("1".equals(piCommonBean.getControlTyukiPdf())) {
		if ("1".equals(piCommonBean.getControlTyukiPdf())||("0".equals(piCommonBean.getControlTyukiPdf())&&"1".equals(piCommonBean.getAdress()))) {
		//MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/05/28 end
		//if ("1".equals(piCommonBean.getAdress())) {
		//MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 end
			result &= checkUtl.checkMandatory("住所１", piUserBean.getUserAddress1());
		}		

		result &= checkUtl.checkTelFax("電話番号", piUserBean.getUserTelNo());

		result &= checkUtl.checkMandatory("決算日(月)", piUserBean.getKesnKiMM());
		result &= checkUtl.checkAlNumHalf("決算日(月)", piUserBean.getKesnKiMM());
		result &= checkUtl.checkMandatory("決算日(日)", piUserBean.getKesnKiDD());
		result &= checkUtl.checkAlNumHalf("決算日(日)", piUserBean.getKesnKiDD());

		if (piUserBean.getKesnKiMM().trim().length() > 0 && piUserBean.getKesnKiDD().trim().length() > 0) {
			result &= checkUtl.checkDate("決算日", "2001" + StringUtl.paddingLeft(piUserBean.getKesnKiMM(), "0", 2) + StringUtl.paddingLeft(piUserBean.getKesnKiDD(), "0", 2));
		}

		if (piUserBean.getOldRskClcHohoCd().getValue().equals(LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201)) {
			if (piUserBean.getOldItenYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221) || piUserBean.getOldItenYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222) || piUserBean.getOldItenYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_KYSHO_223)) {
			}
			else {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_RISOKUMUSI, new String[]{ "旧リース会計基準", "所有権移転FLにおける償却方法(有形資産)" });
				result = false;
			}

			if (piUserBean.getOldItenMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221) || piUserBean.getOldItenMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222) || piUserBean.getOldItenMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_KYSHO_223)) {
			}
			else {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_RISOKUMUSI, new String[]{ "旧リース会計基準", "所有権移転FLにおける償却方法(無形資産)" });
				result = false;
			}

			if (piUserBean.getOldItengiYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221) || piUserBean.getOldItengiYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222) || piUserBean.getOldItengiYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_KYSHO_223)) {
			}
			else {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_RISOKUMUSI, new String[]{ "旧リース会計基準", "所有権移転外FLにおける償却方法(有形資産)" });
				result = false;
			}

			if (piUserBean.getOldItengiMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221) || piUserBean.getOldItengiMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222) || piUserBean.getOldItengiMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_KYSHO_223)) {
			}
			else {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_RISOKUMUSI, new String[]{ "旧リース会計基準", "所有権移転外FLにおける償却方法(無形資産)" });
				result = false;
			}

			// 20210412 arai start 維持管理費用重要性区分「計上する」および役務提供費重要性区分「計上する」を選択できるように改修			
			//if (piUserBean.getOldIjiKnriHyoJyoKbn().getValue().equals("1")) {
			//	message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_RISOKUMUSI_JYUYOUSEI, new String[]{ "旧リース会計基準", "維持管理費重要性" });
			//	result = false;
			//}

			//if (piUserBean.getOldEkmTeikHyoJyoKbn().getValue().equals("1")) {
			//	message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_RISOKUMUSI_JYUYOUSEI, new String[]{ "旧リース会計基準", "役務提供費重要性" });
			//	result = false;
			//}
			
			// 20210412 arai end 

		}
		else {
			if (piUserBean.getOldItenYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221) || piUserBean.getOldItenYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222) || piUserBean.getOldItenYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_KYSHO_223)) {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_NOT_RISOKUMUSI, new String[]{ "旧リース会計基準", "所有権移転FLにおける償却方法(有形資産)" });
				result = false;
			}

			if (piUserBean.getOldItenMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221) || piUserBean.getOldItenMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222) || piUserBean.getOldItenMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_KYSHO_223)) {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_NOT_RISOKUMUSI, new String[]{ "旧リース会計基準", "所有権移転FLにおける償却方法(無形資産)" });
				result = false;
			}

			if (piUserBean.getOldItengiYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221) || piUserBean.getOldItengiYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222) || piUserBean.getOldItengiYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_KYSHO_223)) {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_NOT_RISOKUMUSI, new String[]{ "旧リース会計基準", "所有権移転外FLにおける償却方法(有形資産)" });
				result = false;
			}

			if (piUserBean.getOldItengiMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221) || piUserBean.getOldItengiMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222) || piUserBean.getOldItengiMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_KYSHO_223)) {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_NOT_RISOKUMUSI, new String[]{ "旧リース会計基準", "所有権移転外FLにおける償却方法(無形資産)" });
				result = false;
			}
		}
		if (piUserBean.getNewRskClcHohoCd().getValue().equals(LACSDefine.RisokuKeijoHohoKbn.RSKMUSI_201)) {
			if (piUserBean.getNewItenYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221) || piUserBean.getNewItenYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222) || piUserBean.getNewItenYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_KYSHO_223)) {
			}
			else {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_RISOKUMUSI, new String[]{ "新リース会計基準", "所有権移転FLにおける償却方法(有形資産)" });
				result = false;
			}

			if (piUserBean.getNewItenMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221) || piUserBean.getNewItenMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222) || piUserBean.getNewItenMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_KYSHO_223)) {
			}
			else {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_RISOKUMUSI, new String[]{ "新リース会計基準", "所有権移転FLにおける償却方法(無形資産)" });
				result = false;
			}

			if (piUserBean.getNewItengiYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221) || piUserBean.getNewItengiYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222) || piUserBean.getNewItengiYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_KYSHO_223)) {
			}
			else {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_RISOKUMUSI, new String[]{ "新リース会計基準", "所有権移転外FLにおける償却方法(有形資産)" });
				result = false;
			}

			if (piUserBean.getNewItengiMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221) || piUserBean.getNewItengiMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222) || piUserBean.getNewItengiMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_KYSHO_223)) {
			}
			else {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_RISOKUMUSI, new String[]{ "新リース会計基準", "所有権移転外FLにおける償却方法(無形資産)" });
				result = false;
			}

			// 20210412 arai start 維持管理費用重要性区分「計上する」および役務提供費重要性区分「計上する」を選択できるように改修
			
			//if (piUserBean.getNewIjiKnriHyoJyoKbn().getValue().equals("1")) {
			//	message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_RISOKUMUSI_JYUYOUSEI, new String[]{ "新リース会計基準", "維持管理費重要性" });
			//	result = false;
			//}

			//f (piUserBean.getNewEkmTeikHyoJyoKbn().getValue().equals("1")) {
			//	message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_RISOKUMUSI_JYUYOUSEI, new String[]{ "新リース会計基準", "役務提供費重要性" });
			//	result = false;
			//}

			// 20210412 arai end
			
		}
		else {
			if (piUserBean.getNewItenYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221) || piUserBean.getNewItenYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222) || piUserBean.getNewItenYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_KYSHO_223)) {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_NOT_RISOKUMUSI, new String[]{ "新リース会計基準", "所有権移転FLにおける償却方法(有形資産)" });
				result = false;
			}

			if (piUserBean.getNewItenMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221) || piUserBean.getNewItenMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222) || piUserBean.getNewItenMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_KYSHO_223)) {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_NOT_RISOKUMUSI, new String[]{ "新リース会計基準", "所有権移転FLにおける償却方法(無形資産)" });
				result = false;
			}

			if (piUserBean.getNewItengiYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221) || piUserBean.getNewItengiYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222) || piUserBean.getNewItengiYukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_KYSHO_223)) {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_NOT_RISOKUMUSI, new String[]{ "新リース会計基準", "所有権移転外FLにおける償却方法(有形資産)" });
				result = false;
			}

			if (piUserBean.getNewItengiMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TGKHO_221) || piUserBean.getNewItengiMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_TRTHO_222) || piUserBean.getNewItengiMukeiSkkHohoCd().getValue().equals(LACSDefine.ShoukyakuKeijoHohoKbn.LTRM_LS_TTL_KYSHO_223)) {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_NOT_RISOKUMUSI, new String[]{ "新リース会計基準", "所有権移転外FLにおける償却方法(無形資産)" });
				result = false;
			}
		}

		if (piUserBean.getPdfCompanyName().trim().length() > 0 || piUserBean.getPdfCompanyZip1().trim().length() > 0 || piUserBean.getPdfCompanyZip2().trim().length() > 0 || piUserBean.getPdfCompanyAddress1().trim().length() > 0 || piUserBean.getPdfCompanyAddress2().trim().length() > 0 || piUserBean.getPdfCompanyTel().trim().length() > 0) {
			if (piUserBean.getPdfCompanyName().trim().length() == 0) {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_PDF_COMPANY, "表示用リース会社情報（リース会社）");
				result = false;
			}

			if (piUserBean.getPdfCompanyZip1().trim().length() == 0) {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_PDF_COMPANY, "表示用リース会社情報（郵便番号１）");
				result = false;
			}

			if (piUserBean.getPdfCompanyZip2().trim().length() == 0) {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_PDF_COMPANY, "表示用リース会社情報（郵便番号２）");
				result = false;
			}

			result &= checkUtl.checkNumeric("表示用リース会社情報（郵便番号１）", piUserBean.getPdfCompanyZip1());
			result &= checkUtl.checkNumeric("表示用リース会社情報（郵便番号２）", piUserBean.getPdfCompanyZip2());

			if (piUserBean.getPdfCompanyAddress1().trim().length() == 0) {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_PDF_COMPANY, "表示用リース会社情報（住所１）");
				result = false;
			}

			if (piUserBean.getPdfCompanyTel().trim().length() == 0) {
				message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_PDF_COMPANY, "表示用リース会社情報（電話番号）");
				result = false;
			}

			result &= checkUtl.checkTelFax("表示用リース会社情報（電話番号）", piUserBean.getPdfCompanyTel());
		}

		result &= dispControlCommon.checkInputRealation(piUserBean.getDispControl(), message);
		
		//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/21 start
		//MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/05/27 start		
		//if ("1".equals(piCommonBean.getAdress())) {	
		//	result &= checkUtl.checkMandatory("部署コード 所コード", piUserBean.getLcShzkSho());
		//}
		result &= checkUtl.checkAlNumHalf("部署コード 所コード", piUserBean.getLcShzkSho());
		
		//if ("1".equals(piCommonBean.getAdress())) {	
		//	result &= checkUtl.checkMandatory("部署コード 部コード", piUserBean.getLcShzkBu());
		//}
		result &= checkUtl.checkAlNumHalf("部署コード 部コード", piUserBean.getLcShzkBu());
		
		//if ("1".equals(piCommonBean.getAdress())) {	
		//	result &= checkUtl.checkMandatory("部署コード  グループコード", piUserBean.getLcShzkGrp());
		//}
		result &= checkUtl.checkAlNumHalf("部署コード  グループコード", piUserBean.getLcShzkGrp());
		
		//if ("1".equals(piCommonBean.getAdress())) {	
		//	result &= checkUtl.checkMandatory("部署名", piUserBean.getLcShzkNm());
		//}
		
		//if ("1".equals(piCommonBean.getAdress())) {	
		//	result &= checkUtl.checkMandatory("担当者コード", piUserBean.getLcTntCd());
		//}
		result &= checkUtl.checkAlNumHalf("担当者コード", piUserBean.getLcTntCd());
		
		//if ("1".equals(piCommonBean.getAdress())) {	
		//	result &= checkUtl.checkMandatory("担当者名", piUserBean.getLcTntNm());
		//}
		//MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/05/27 end
		//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/21 end
		
		this.getData(piUserBean);

		if (piUserBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_NEW && piUserBean.getDataMax() > 0) {
			message.addMessage(LACSDefine.MessageCode.ERROR_DB_DATA_EXIST, "開示先コード");
			result = false;
		}
		return result;
	}

	/**
	 * SQL文作成.
	 * 
	 * @param piUserBean
	 *            リースユーザーマスタBean
	 * @return SQL
	 */
	private String makeSQL(LACSUserBean piUserBean) {
		StringBuffer sql = new StringBuffer();
		ArrayList<String> items = getItems(piUserBean);
		ArrayList<String> values = getValues(piUserBean);

		if (piUserBean.getDataMax() > 0) {

			StringBuffer where = new StringBuffer();
			where.append("LU_COSMOS_CD = '" + Command.changeQt(piUserBean.getUserCosmosCode()) + "' " + "\n");

			MakeSQLUpdateBase.makeSQL(sql, TABLE_NAME, items, values, where.toString());
		}
		else {

			MakeSQLInsertBase.makeSQL(sql, TABLE_NAME, items, values);
		}

		return sql.toString();
	}

	/**
	 * DBカラム名取得.
	 * 
	 * @param piUserBean
	 *            リースユーザーマスタBean
	 * @return DBカラム名
	 */
	private ArrayList<String> getItems(LACSUserBean piUserBean) {
		ArrayList<String> items = new ArrayList<String>();

		if (piUserBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_NEW) {

			items.add("LU_COSMOS_CD"); // COSMOSコード
			items.add("ENT_DATE"); // 登録日時
			items.add("ENT_USR"); // 登録ユーザ
		}

		items.add("UPD_DATE"); // 更新日時
		items.add("UPD_USR"); // 更新ユーザ
		items.add("LU_NM"); // リースユーザー名称
		items.add("LU_ZIP1"); // リースユーザー郵便番号１
		items.add("LU_ZIP2"); // リースユーザー郵便番号２
		items.add("LU_ADR1"); // リースユーザー住所１
		items.add("LU_ADR2"); // リースユーザー住所２
		items.add("LU_TELNO"); // リースユーザー電話番号
		items.add("LU_TNT_NM"); // リースユーザー担当者名
		items.add("SRKI_WRKI_CD"); // 西暦和暦コード
		items.add("AC_SHR_KBN"); // 会計処理区分
		items.add("KESN_KI"); // 決算期FROM
		items.add("GTJ_SRT_KEI_JGI_FLG"); // 短期契約除外フラグ
		items.add("GTJ_RLS_KEI_JGI_FLG"); // 再リース契約除外フラグ
		items.add("GTJ_SGK_KEI_JGI_FLG"); // 少額契約除外フラグ
		items.add("GTJ_CYT_KAI_JGI_FLG"); // 中途解約除外フラグ
		items.add("WEB_DB_DATA_SRC"); // オンラインDBデータソース名
		items.add("OLD_ITN_YUKEI_SKK_HOHO_CD"); // 旧会計基準-所有権移転有形償却方法コード
		items.add("OLD_ITN_MUKEI_SKK_HOHO_CD"); // 旧会計基準-所有権移転無形償却方法コード
		items.add("OLD_ITNGI_YUKEI_SKK_HOHO_CD"); // 旧会計基準-所有権移転外有形償却方法コード
		items.add("OLD_ITNGI_MUKEI_SKK_HOHO_CD"); // 旧会計基準-所有権移転外無形償却方法コード
		items.add("OLD_MBRI_ABRI_KBN"); // 旧会計基準-前払後払区分
		items.add("OLD_RSK_CLC_HOHO_CD"); // 旧会計基準-利息計算方法コード
		items.add("OLD_FKN_TNKI_HOHO_CD"); // 旧会計基準-賦金展開方法コード
		items.add("OLD_IJI_KNRI_HYO_JYO_KBN"); // 旧会計基準-維持管理費重要性区分
		items.add("OLD_EKM_TEIK_HYO_JYO_KBN"); // 旧会計基準-役務提供費用重要性区分
		items.add("OLD_GNKSK_HASU_CHSE_CD"); // 旧会計基準-減価償却端数調整コード
		items.add("OLD_FKN_TNKI_CHSE_CD"); // 旧会計基準-賦金展開調整コード
		items.add("OLD_KNU_AMT_TUTI_UM_FLG"); // 旧会計基準-購入額通知有無フラグ
		items.add("NEW_ITN_YUKEI_SKK_HOHO_CD"); // 新会計基準-所有権移転有形償却方法コード
		items.add("NEW_ITN_MUKEI_SKK_HOHO_CD"); // 新会計基準-所有権移転無形償却方法コード
		items.add("NEW_ITNGI_YUKEI_SKK_HOHO_CD"); // 新会計基準-所有権移転外有形償却方法コード
		items.add("NEW_ITNGI_MUKEI_SKK_HOHO_CD"); // 新会計基準-所有権移転外無形償却方法コード
		items.add("NEW_MBRI_ABRI_KBN"); // 新会計基準-前払後払区分
		items.add("NEW_RSK_CLC_HOHO_CD"); // 新会計基準-利息計算方法コード
		items.add("NEW_FKN_TNKI_HOHO_CD"); // 新会計基準-賦金展開方法コード
		items.add("NEW_IJI_KNRI_HYO_JYO_KBN"); // 新会計基準-維持管理費重要性区分
		items.add("NEW_EKM_TEIK_HYO_JYO_KBN"); // 新会計基準-役務提供費用重要性区分
		items.add("NEW_GNKSK_HASU_CHSE_CD"); // 新会計基準-減価償却端数調整コード
		items.add("NEW_FKN_TNKI_CHSE_CD"); // 新会計基準-賦金展開調整コード
		items.add("NEW_KNU_AMT_TUTI_UM_FLG"); // 新会計基準-購入額通知有無フラグ
		items.add("SYOSU_KETASU"); // 利子率の精度

		items.add("CHANGE_FLG"); // 開示先変更フラグ

		items.add("PDF_COMPANY_NM"); // 帳票表示リース会社
		items.add("PDF_COMPANY_ZIP1"); // 帳票表示郵便番号１
		items.add("PDF_COMPANY_ZIP2"); // 帳票表示郵便番号２
		items.add("PDF_COMPANY_ADR1"); // 帳票表示住所１
		items.add("PDF_COMPANY_ADR2"); // 帳票表示住所２
		items.add("PDF_COMPANY_TELNO"); // 帳票表示電話番号
		items.add("OLD_SRT_KEI_JGI_FLG"); // 短期契約除外フラグ
		items.add("OLD_RLS_KEI_JGI_FLG"); // 再リース契約除外フラグ
		items.add("OLD_SGK_KEI_JGI_FLG"); // 少額契約除外フラグ
		items.add("OLD_CYT_KAI_JGI_FLG"); // 中途解約除外フラグ
		items.add("NEW_SRT_KEI_JGI_FLG"); // 短期契約除外フラグ
		items.add("NEW_RLS_KEI_JGI_FLG"); // 再リース契約除外フラグ
		items.add("NEW_SGK_KEI_JGI_FLG"); // 少額契約除外フラグ
		items.add("NEW_CYT_KAI_JGI_FLG"); // 中途解約除外フラグ

		if (piUserBean.getDataMax() == 0 || super.getCommonBean().isShowSumUnt()) {
			items.add("OLD_SUM_UNT"); // 旧会計基準-集計単位
			items.add("NEW_SUM_UNT"); // 新会計基準-集計単位
		}
		
		//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/21 start
		items.add("BATCH_PRINT_TIMING_CD"); // 出力タイミング
		items.add("LC_SHZK_SHO");			// リース会社担当者コード
		items.add("LC_SHZK_BU");			// リース会社担当者名
		items.add("LC_SHZK_GRP");			// リース会社部署 所コード
		items.add("LC_SHZK_NM");			// リース会社部署 部コード
		items.add("LC_TNT_CD");				// リース会社部署 グループコード
		items.add("LC_TNT_NM");				// リース会社部署名称		
		//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/21 end				
		items.add("OUTPUT_KBN");            // 20200529 出力タイミング 追加 arai
				
		return items;
	}

	/**
	 * DB更新値取得.
	 * 
	 * @param piUserBean
	 *            リースユーザーマスタBean
	 * @return DB更新値
	 */
	private ArrayList<String> getValues(LACSUserBean piUserBean) {
		ArrayList<String> values = new ArrayList<String>();
		String oldMbriAbriKbn = LACSDefine.MaebaraiAtobaraiKbn.ATO_BARAI_1;

		String newMbriAbriKbn = LACSDefine.MaebaraiAtobaraiKbn.ATO_BARAI_1;

		if (piUserBean.getOldRskClcHohoCd().getValue().equals(LACSDefine.RisokuKeijoHohoKbn.RSKHO_ZEN_GET_101)) {
			oldMbriAbriKbn = LACSDefine.MaebaraiAtobaraiKbn.MAE_BARAI_0;
		}

		if (piUserBean.getNewRskClcHohoCd().getValue().equals(LACSDefine.RisokuKeijoHohoKbn.RSKHO_ZEN_GET_101)) {
			newMbriAbriKbn = LACSDefine.MaebaraiAtobaraiKbn.MAE_BARAI_0;
		}

		if (piUserBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_NEW) {

			values.add("'" + Command.changeQt(piUserBean.getUserCosmosCode()) + "'");
			values.add("SYSDATE");
			values.add("'" + super.getCommonBean().getCosmosCode() + "'");
		}

		values.add("SYSDATE");
		values.add("'" + Command.changeQt(super.getCommonBean().getCosmosCode()) + "'");
		values.add("'" + Command.changeQt(piUserBean.getUserName()) + "'");
		values.add("'" + Command.changeQt(piUserBean.getUserZip1()) + "'");
		values.add("'" + Command.changeQt(piUserBean.getUserZip2()) + "'");
		values.add("'" + Command.changeQt(piUserBean.getUserAddress1()) + "'");
		values.add("'" + Command.changeQt(piUserBean.getUserAddress2()) + "'");
		values.add("'" + piUserBean.getUserTelNo() + "'");
		values.add("'" + Command.changeQt(piUserBean.getUserTantoName()) + "'");
		values.add("'" + piUserBean.getSeirekiWarekiCode().getValue() + "'");
		values.add("'" + piUserBean.getAcShrKbn().getValue() + "'");
		values.add("'" + StringUtl.paddingLeft(piUserBean.getKesnKiMM(), "0", 2) + StringUtl.paddingLeft(piUserBean.getKesnKiDD(), "0", 2) + "'");
		values.add("'" + piUserBean.getGtjSrtKeiJgiFlg() + "'");
		values.add("'" + piUserBean.getGtjRlsKeiJgiFlg() + "'");
		values.add("'" + piUserBean.getGtjSgkKeiJgiFlg() + "'");
		values.add("'" + piUserBean.getGtjCytKaiJgiFlg() + "'");
		values.add("'" + piUserBean.getDataSource() + "'");
		values.add("'" + piUserBean.getOldItenYukeiSkkHohoCd().getValue() + "'");
		values.add("'" + piUserBean.getOldItenMukeiSkkHohoCd().getValue() + "'");
		values.add("'" + piUserBean.getOldItengiYukeiSkkHohoCd().getValue() + "'");
		values.add("'" + piUserBean.getOldItengiMukeiSkkHohoCd().getValue() + "'");
		values.add("'" + oldMbriAbriKbn + "'");
		values.add("'" + piUserBean.getOldRskClcHohoCd().getValue() + "'");
		values.add("'" + piUserBean.getOldFknTnkiHohoCd().getValue() + "'");
		values.add("'" + piUserBean.getOldIjiKnriHyoJyoKbn().getValue() + "'");
		values.add("'" + piUserBean.getOldEkmTeikHyoJyoKbn().getValue() + "'");
		values.add("'" + piUserBean.getOldGnkskHasuChseCd().getValue() + "'");
		values.add("'" + piUserBean.getOldFknTnkiHasuChseCd().getValue() + "'");
		values.add("'" + piUserBean.getOldKnuAmtTutiUmFlg() + "'");
		values.add("'" + piUserBean.getNewItenYukeiSkkHohoCd().getValue() + "'");
		values.add("'" + piUserBean.getNewItenMukeiSkkHohoCd().getValue() + "'");
		values.add("'" + piUserBean.getNewItengiYukeiSkkHohoCd().getValue() + "'");
		values.add("'" + piUserBean.getNewItengiMukeiSkkHohoCd().getValue() + "'");
		values.add("'" + newMbriAbriKbn + "'");
		values.add("'" + piUserBean.getNewRskClcHohoCd().getValue() + "'");
		values.add("'" + piUserBean.getNewFknTnkiHohoCd().getValue() + "'");
		values.add("'" + piUserBean.getNewIjiKnriHyoJyoKbn().getValue() + "'");
		values.add("'" + piUserBean.getNewEkmTeikHyoJyoKbn().getValue() + "'");
		values.add("'" + piUserBean.getNewGnkskHasuChseCd().getValue() + "'");
		values.add("'" + piUserBean.getNewFknTnkiHasuChseCd().getValue() + "'");
		values.add("'" + piUserBean.getNewKnuAmtTutiUmFlg() + "'");
		values.add("'" + piUserBean.getSyosuKetasu().getValue() + "'");

		if (piUserBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_NEW) {
			values.add("'1'");
		}
		else {
			if (dataCount < 1) {
				values.add("'1'");
			}
			else {
				values.add("'0'");
			}
		}

		values.add("'" + Command.changeQt(piUserBean.getPdfCompanyName()) + "'");
		values.add("'" + Command.changeQt(piUserBean.getPdfCompanyZip1()) + "'");
		values.add("'" + Command.changeQt(piUserBean.getPdfCompanyZip2()) + "'");
		values.add("'" + Command.changeQt(piUserBean.getPdfCompanyAddress1()) + "'");
		values.add("'" + Command.changeQt(piUserBean.getPdfCompanyAddress2()) + "'");
		values.add("'" + Command.changeQt(piUserBean.getPdfCompanyTel()) + "'");
		values.add("'" + piUserBean.getOldSrtKeiJgiFlg() + "'");
		values.add("'" + piUserBean.getOldRlsKeiJgiFlg() + "'");
		values.add("'" + piUserBean.getOldSgkKeiJgiFlg() + "'");
		values.add("'" + piUserBean.getOldCytKaiJgiFlg() + "'");
		values.add("'" + piUserBean.getNewSrtKeiJgiFlg() + "'");
		values.add("'" + piUserBean.getNewRlsKeiJgiFlg() + "'");
		values.add("'" + piUserBean.getNewSgkKeiJgiFlg() + "'");
		values.add("'" + piUserBean.getNewCytKaiJgiFlg() + "'");
		if (piUserBean.getDataMax() == 0 || super.getCommonBean().isShowSumUnt()) {
			values.add("'" + piUserBean.getOldSumUnt() + "'");
			values.add("'" + piUserBean.getNewSumUnt() + "'");
		}
		
		//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/21 start
		values.add("'" + piUserBean.getBatchPrintTimingCd().getValue() + "'");
		values.add("'" + Command.changeQt(piUserBean.getLcShzkSho()) + "'");
		values.add("'" + Command.changeQt(piUserBean.getLcShzkBu()) + "'");
		values.add("'" + Command.changeQt(piUserBean.getLcShzkGrp()) + "'");
		values.add("'" + Command.changeQt(piUserBean.getLcShzkNm()) + "'");
		values.add("'" + Command.changeQt(piUserBean.getLcTntCd()) + "'");
		values.add("'" + Command.changeQt(piUserBean.getLcTntNm()) + "'");
		//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/21 end
		// 20200529 出力タイミング追加 arai
		values.add("'" + Command.changeQt(piUserBean.getBatchPrintTimingCd().getValue()) + "'");
	
		return values;
	}

}
