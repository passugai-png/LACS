package jp.co.pro_app.lacs.affairs.login.model;

import java.sql.SQLException;
import java.util.Date;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.common.command.LACSDispControlCommon;
import jp.co.pro_app.lacs.affairs.common.command.LACSLoginSecurity;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSADSOptionEntity;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSCopyRightEntity;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSFixedUserInfoEntity;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSLoginCompanyEntity;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSOptionEntity;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSTantoUserEntity;
import jp.co.pro_app.lacs.affairs.login.bean.LACSLoginBean;
import jp.co.pro_app.lacs.affairs.login.data.entity.LACSUserTantoEntity;
import jp.co.pro_app.lacs.affairs.top.data.entity.LACSWarekiEntity;
import jp.co.pro_app.lacs.common.define.LACSCustomizeDefine;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.SecurityUtl;
import jp.co.pro_app.projframe.common.dbaccess.NotSelectExecute;
import jp.co.pro_app.projframe.common.html.ComboValue;

/**
 * ログイン：ログイン処理.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSLoginNextModel extends LACSLoginModelBase {

	/**
	 * LACS用権限制御共通部品.
	 */
	protected LACSDispControlCommon	dispControlCommon	= null;

	private boolean checkInput(LACSCommonBean piCommonBean, LACSLoginBean piBean) throws SQLException {
		boolean result = false;

		LACSUserTantoEntity entity = new LACSUserTantoEntity(this);
		NotSelectExecute exeute = new NotSelectExecute();
		LACSLoginSecurity security = new LACSLoginSecurity(this, super.con, piBean.getUserId());

		try {

			entity.setCon(super.con);

			entity.setUserId(piBean.getUserId());

			entity.execSQL();

			if (entity.next()) {
				if (entity.getPassword().equals(SecurityUtl.getMD5(piBean.getPassword()))) {
					switch (Convert.toInt(entity.getStatus())) {
						case 1:
							message.addMessage(LACSDefine.MessageCode.ERROR_DB_USER_FORCE_HONPW);
							break;
						case 2:
							message.addMessage(LACSDefine.MessageCode.ERROR_DB_USER_KARIPW_EXPIRED);
							break;
						case 3:
							message.addMessage(LACSDefine.MessageCode.ERROR_DB_USER_LOCKED);
							break;
						case 4:
							message.addMessage(LACSDefine.MessageCode.ERROR_DB_USER_HONPW_EXPIRED);
							break;
						default:
							if (security.checkLogin()) {
								message.addMessage(LACSDefine.MessageCode.ERROR_DB_USER_LOGGED_IN);
							}
							else {
								security.access(piCommonBean.getOneTimePassword());
								piCommonBean.setUserRight(entity.getUserRight());
								piCommonBean.setTantoName(entity.getTantoName());
								result = true;
							}

							break;
					}
				}
				else {
					message.addMessage(LACSDefine.MessageCode.ERROR_DB_LOGIN);
					if (entity.getMissCount() < 9) {
						exeute.setCon(this.con);
						exeute.execState("UPDATE M_LU_TNT SET MISS_CNT = MISS_CNT + 1 WHERE LU_ID = '" + Command.changeQt(piBean.getUserId()) + "'");
					}
				}
			}
			else {
				message.addMessage(LACSDefine.MessageCode.ERROR_DB_LOGIN);
			}

			if (result) {
				exeute.setCon(this.con);
				exeute.execState("UPDATE M_LU_TNT SET MISS_CNT = 0 WHERE LU_ID = '" + Command.changeQt(piBean.getUserId()) + "'");
			}
		}
		finally {
			entity.close();
		}

		return result;
	}

	/**
	 * データ取得.
	 * 
	 * @param piCommonBean
	 *            LACS共通Bean
	 * @param piBean
	 *            ログインBean
	 * @throws SQLException
	 *             SQL実行例外
	 */
	private void getData(LACSCommonBean piCommonBean, LACSLoginBean piBean) throws SQLException {

		LACSTantoUserEntity tantoUserEntity = new LACSTantoUserEntity(this);

		try {
			tantoUserEntity.setCon(super.con);

			tantoUserEntity.setUserId(piCommonBean.getLoginUserId());
			tantoUserEntity.execSQL();

			piCommonBean.getEnableUserList().clear();

			while (tantoUserEntity.next()) {
				piCommonBean.getEnableUserList().add(tantoUserEntity.getCosmosCode());
			}

			this.getCompanyInfo(piCommonBean);

			if (piCommonBean.getUserRight().equals(LACSDefine.UserRight.ADMIN)) {
				piCommonBean.setAppMode(LACSDefine.AppMode.APP_MODE_COMPANY);
				piCommonBean.setMenuMode(LACSDefine.MenuMode.MENU_MODE_ADMIN);
				piCommonBean.setErrorFlg("0");
			}
			else if (piCommonBean.getUserRight().equals(LACSDefine.UserRight.GENERAL)) {
				piCommonBean.setAppMode(LACSDefine.AppMode.APP_MODE_COMPANY);
				piCommonBean.setMenuMode(LACSDefine.MenuMode.MENU_MODE_OFFICE);
			}
			else {
				piCommonBean.setAppMode(LACSDefine.AppMode.APP_MODE_FIXED_USER);
				this.getUserInfo(piCommonBean);
			}
		}
		finally {
			tantoUserEntity.close();
		}
	}

	private void getUserInfo(LACSCommonBean piCommonBean) throws SQLException {
		LACSFixedUserInfoEntity userInfoEntity = new LACSFixedUserInfoEntity(this);
		LACSWarekiEntity warekiEntity = new LACSWarekiEntity(this);
		LACSCopyRightEntity copyrightEntity = new LACSCopyRightEntity(this);
		LACSOptionEntity optionEntity = new LACSOptionEntity(this);

		try {
			userInfoEntity.setCon(super.con);

			userInfoEntity.setCompanyCode(piCommonBean.getCompanyCode());
			userInfoEntity.setUserId(piCommonBean.getLoginUserId());

			userInfoEntity.execSQL();

			if (userInfoEntity.next()) {
				piCommonBean.setCosmosCode(userInfoEntity.getCOSMOSCode());
				piCommonBean.setCosmosName(userInfoEntity.getUserName());
				piCommonBean.setDateMode(userInfoEntity.getSeirekiWarekiCode());
			}

			warekiEntity.setCon(this.con);
			warekiEntity.execSQL();

			piCommonBean.getWarekiArray().clear();
			piCommonBean.getWarekiArray().add(new ComboValue("", ""));

			while (warekiEntity.next()) {
				piCommonBean.getWarekiArray().add(new ComboValue(warekiEntity.getWarekiName(), warekiEntity.getWarekiCode()));
			}

			copyrightEntity.setCon(super.con);

			copyrightEntity.execSQL();
			piCommonBean.setCopyRight("");
			if (copyrightEntity.next()) {
				piCommonBean.setCopyRight(copyrightEntity.getCopyRight());
			}

			optionEntity.setCon(super.con);
			optionEntity.setOptionCode(LACSDefine.OptionCode.USER_HELP);
			optionEntity.execSQL();

			if (optionEntity.next()) {
				piCommonBean.setShowUserHelp(optionEntity.getOptionValue());
			}

			if (dispControlCommon.getDBDispControl(piCommonBean.getCosmosCode(), 0) == 0) {
				dispControlCommon.getDBDispControl(LACSDefine.INFO_ALL, 0);
			}

			/*
			 * 顧客個別1対応
			 */
			piCommonBean.getDispControl().add(LACSCustomizeDefine.DispContorolId.DISP_ID_CUSTUMIZE_1, "0");
		}
		finally {
			userInfoEntity.close();
			warekiEntity.close();
			copyrightEntity.close();
			optionEntity.close();
		}
	}

	private void getCompanyInfo(LACSCommonBean piCommonBean) throws SQLException {
		LACSLoginCompanyEntity loginCompanyEntity = new LACSLoginCompanyEntity(this);
		LACSWarekiEntity warekiEntity = new LACSWarekiEntity(this);
		LACSOptionEntity optionEntity = new LACSOptionEntity(this);
		
		//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 start
		LACSADSOptionEntity adsEntity = new LACSADSOptionEntity(this);
		//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 end

		try {
			loginCompanyEntity.setCon(super.con);

			loginCompanyEntity.setCompanyCode(piCommonBean.getCompanyCode());

			loginCompanyEntity.execSQL();

			if (loginCompanyEntity.next()) {
				piCommonBean.setShoriYMD((LACSCommand.toDateYYYYMM(piCommonBean, super.con, this, loginCompanyEntity.getShoriYM() + "01")));
				piCommonBean.setErrorDisplayFlg(loginCompanyEntity.getErrorDisplayFlg());
			}

			warekiEntity.setCon(this.con);
			warekiEntity.execSQL();

			piCommonBean.getWarekiArray().clear();
			piCommonBean.getWarekiArray().add(new ComboValue("", ""));

			while (warekiEntity.next()) {
				piCommonBean.getWarekiArray().add(new ComboValue(warekiEntity.getWarekiName(), warekiEntity.getWarekiCode()));
			}

			dispControlCommon.getDBDispControl(LACSDefine.INFO_ALL, 1);

			/*
			 * 顧客個別1対応
			 */
			optionEntity.setCon(this.con);
			optionEntity.setOptionCode(6);
			optionEntity.execSQL();
			if (optionEntity.next()) {
				piCommonBean.getDispControl().add(LACSCustomizeDefine.DispContorolId.DISP_ID_CUSTUMIZE_1, optionEntity.getOptionValue());
			}
			else {
				piCommonBean.getDispControl().add(LACSCustomizeDefine.DispContorolId.DISP_ID_CUSTUMIZE_1, "0");
			}

			optionEntity.setOptionCode(22);
			optionEntity.execSQL();

			piCommonBean.setShowSumUnt(false);

			if (optionEntity.next()) {
				if (optionEntity.getOptionValue().equals("1")) {
					piCommonBean.setShowSumUnt(true);
				}
			}
			/*
			 * 解約不能期間使用制御オプション取得
			 */
			optionEntity.setOptionCode(24);
			optionEntity.execSQL();
			piCommonBean.setShowKaiKnoOpt(false);
			if (optionEntity.next()) {
				if (optionEntity.getOptionValue().equals("1")) {
					piCommonBean.setShowKaiKnoOpt(true);
				}
			}
			/*
			 * 注記書類作成基準書制御オプション取得
			 */
			optionEntity.setOptionCode(LACSDefine.OptionCode.TYUKI_PDF);
			optionEntity.execSQL();
			if (optionEntity.next()) {
				piCommonBean.setControlTyukiPdf(optionEntity.getOptionValue());
			}
			
			//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 start
			adsEntity.setCon(this.con);
			adsEntity.setOptionCode(28);
			adsEntity.execSQL();
			if (adsEntity.next()) {
				piCommonBean.setAdress(adsEntity.getOptionValue());
			}
			//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 end

			/*
			 * 注記源泉CSV１年超明細有無オプション取得
			 */
			optionEntity.setOptionCode(LACSDefine.OptionCode.TYUKI_GENSEN_MEISAI_DSP);
			optionEntity.execSQL();
			if (optionEntity.next()) {
				piCommonBean.setControlTyukiGensenMeisaiDsp(optionEntity.getOptionValue());
			}

			//2014/05/19 ADD START
			/*
			 * 未経過リース料期末残高別表消費税有無オプション取得
			 */
			optionEntity.setOptionCode(33);
			optionEntity.execSQL();
			if (optionEntity.next()) {
				piCommonBean.setControlMikeikaBStaxDsp(optionEntity.getOptionValue());
			}
			//2014/05/19 ADD END
		}
		finally {
			optionEntity.close();
			loginCompanyEntity.close();
			warekiEntity.close();
			
			//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 start
			adsEntity.close();
			//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 end
		}
	}

	/**
	 * 業務固有処理.
	 * 
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 * @exception Exception
	 *                実行例外
	 */
	protected void businessProc(LACSLoginBean piShiharaiBean) throws Exception {
		LACSCommonBean commonBean = super.getCommonBean();
		LACSLoginBean loginBean = super.getLoginBean();

		dispControlCommon = new LACSDispControlCommon(commonBean.getDispControl(), this, this.con);

		if (this.checkInput(commonBean, loginBean)) {
			this.getData(commonBean, loginBean);
			commonBean.setDispID("M002");
			super.setForwardPath("/show.top");
		}

		loginBean.setMessage(this.message.getMessage());
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piShiharaiBean
	 *            支払推移表Bean
	 * @exception Exception
	 *                実行例外
	 */
	protected void initSub(LACSLoginBean piShiharaiBean) throws Exception {
		LACSCommonBean commonBean = super.getCommonBean();

		piShiharaiBean.setUserId(super.getInput("userId", ""));
		piShiharaiBean.setPassword(super.getInput("identifier", ""));

		commonBean.setLoginUserId(piShiharaiBean.getUserId());
		commonBean.setOneTimePassword(SecurityUtl.getMD5(Convert.toString(new Date(), Convert.FORMAT_YYYY_MM_DD_HH24_MI_SS) + piShiharaiBean.getUserId()));
		commonBean.getInfo().clear();

		commonBean.setCosmosCode("");
		commonBean.setCosmosName("");
		commonBean.setTantoName("");
		commonBean.setDateMode(LACSDefine.DateMode.SEIREKI);
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "ログイン";
	}

	/**
	 * セッションチェックフラグ取得.
	 * 
	 * @return セッションチェックを行うか
	 */
	protected boolean isSessionCheck() {
		return false;
	}

//	/**
//	 * 業務個別処理(セッションクリア機能追加).
//	 * 
//	 * @throws Exception
//	 *             例外発生時.
//	 */
//	public void performSub() throws Exception {
//		super.removeBean();
//
//		super.performSub();
//	}
}
