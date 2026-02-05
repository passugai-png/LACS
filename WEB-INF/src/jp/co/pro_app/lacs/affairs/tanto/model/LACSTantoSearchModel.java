package jp.co.pro_app.lacs.affairs.tanto.model;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import jp.co.pro_app.lacs.affairs.common.data.entity.LACSTantoUserEntity;
import jp.co.pro_app.lacs.affairs.company.data.entity.LACSCompanyEntity;
import jp.co.pro_app.lacs.affairs.tanto.bean.LACSTantoBean;
import jp.co.pro_app.lacs.affairs.tanto.data.entity.LACSTantoEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;

/**
 * リースユーザー担当者マスタ：検索処理Model.
 * 
 * @author ohmura
 * @version 20070913
 */
public class LACSTantoSearchModel extends LACSTantoModelBase {

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
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSTantoBean piTantoBean) throws Exception {

		if (piTantoBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_UPD) {
			this.getData(piTantoBean);
		}
		else {
			if (piTantoBean.getUserRight().equals(LACSDefine.UserRight.ADMIN)) {
				piTantoBean.getUserList(piTantoBean.getLeasCompany()).init(1);
			}
			else if (piTantoBean.getUserRight().equals(LACSDefine.UserRight.GENERAL)) {
				piTantoBean.getUserList(piTantoBean.getLeasCompany()).init(5);
			}
			else {
				piTantoBean.getUserList(piTantoBean.getLeasCompany()).init(1);
			}
			this.getCompanyData(piTantoBean);
		}

		piTantoBean.setShowList(true);

		super.setForwardPath("/jsp/T001.jsp");
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSTantoBean piTantoBean) throws SQLException {

		this.clearData(piTantoBean);

		super.prepareComoboBox(piTantoBean);

		piTantoBean.setMessage("");

	}

	/**
	 * データ取得.
	 * 
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	private void getData(LACSTantoBean piTantoBean) throws SQLException {
		LACSTantoEntity tantoEntity = new LACSTantoEntity(this);
		LACSTantoUserEntity tantoUserEntity = new LACSTantoUserEntity(this);
		Date nowDate = new Date();
		Date dt;

		try {
			tantoEntity.setCon(super.con);

			tantoEntity.setUserId(piTantoBean.getUserID());
			tantoEntity.execSQL();

			if (tantoEntity.next()) {
				piTantoBean.setUserTantoName(Command.init(tantoEntity.getUserTantoName(), ""));
				piTantoBean.setKriPassFlg(Command.init(tantoEntity.getKriPassFlg(), ""));

				dt = DateUtl.add(Calendar.DAY_OF_YEAR, Convert.toInt(tantoEntity.getKriPasswordYukoTerm()), nowDate);
				piTantoBean.setKriPasswordTerm(Command.init(Convert.toString(dt, Convert.FORMAT_YYYYMMDD), ""));

				dt = DateUtl.add(Calendar.DAY_OF_YEAR, Convert.toInt(tantoEntity.getHonPasswordYukoTerm()), nowDate);
				piTantoBean.setHonPasswordTerm(Command.init(Convert.toString(dt, Convert.FORMAT_YYYYMMDD), ""));

				piTantoBean.setMinLength(Command.init(tantoEntity.getMinLength(), ""));
				piTantoBean.setMaxLength(Command.init(tantoEntity.getMaxLength(), ""));

				tantoUserEntity.setCon(super.con);
				tantoUserEntity.setUserId(piTantoBean.getUserID());
				tantoUserEntity.execSQL();

				while (tantoUserEntity.next()) {
					piTantoBean.getUserList(piTantoBean.getLeasCompany()).add(tantoUserEntity.getCosmosCode());
					piTantoBean.getLeasCompany().setSelectedValue(Command.init(tantoUserEntity.getCosmosCode(), ""));
				}
			}

			piTantoBean.setDataMax(tantoEntity.getAllDataCount());
		}
		finally {
			tantoEntity.close();
			tantoUserEntity.close();
		}
	}

	/**
	 * リース会社情報取得.
	 * 
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	private void getCompanyData(LACSTantoBean piTantoBean) throws SQLException {
		LACSCompanyEntity companyEntity = new LACSCompanyEntity(this);
		Date nowDate = new Date();
		Date dt;

		try {
			companyEntity.setCon(super.con);

			companyEntity.setLeasCompanyCode(super.getCommonBean().getCompanyCode());
			companyEntity.execSQL();

			if (companyEntity.next()) {

				dt = DateUtl.add(Calendar.DAY_OF_YEAR, Convert.toInt(companyEntity.getTempPassValidityTerm()), nowDate);
				piTantoBean.setKriPasswordTerm(Command.init(Convert.toString(dt, Convert.FORMAT_YYYYMMDD), ""));

				dt = DateUtl.add(Calendar.DAY_OF_YEAR, Convert.toInt(companyEntity.getPassValidityTerm()), nowDate);
				piTantoBean.setHonPasswordTerm(Command.init(Convert.toString(dt, Convert.FORMAT_YYYYMMDD), ""));

				piTantoBean.setMinLength(Command.init(companyEntity.getPasswordLengthMin(), ""));
				piTantoBean.setMaxLength(Command.init(companyEntity.getPasswordLengthMax(), ""));
			}

			piTantoBean.setDataMax(companyEntity.getAllDataCount());
		}
		finally {
			companyEntity.close();
		}
	}

	/**
	 * データクリア.
	 * 
	 * @param piTantoBean
	 *            リースユーザー担当者マスタBean
	 */
	private void clearData(LACSTantoBean piTantoBean) {

		piTantoBean.setCosmosCode("");
		piTantoBean.setPassword("");
		piTantoBean.setPassword2("");
		piTantoBean.setUserTantoName("");
		piTantoBean.setKriPassFlg("");
		piTantoBean.setKriPasswordTerm("");
		piTantoBean.setHonPasswordTerm("");
		piTantoBean.setLeasCompanyNm("");
		piTantoBean.clearUserList();
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}
}
