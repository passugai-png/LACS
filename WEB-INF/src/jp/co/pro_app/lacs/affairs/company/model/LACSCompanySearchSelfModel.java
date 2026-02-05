package jp.co.pro_app.lacs.affairs.company.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.company.bean.LACSCompanyBean;
import jp.co.pro_app.lacs.affairs.company.data.entity.LACSCompanyEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;

/**
 * リース会社マスタ：検索処理Model.
 * 
 * @author takeda
 * @version 20070911
 */
public class LACSCompanySearchSelfModel extends LACSCompanyModelBase {

	/**
	 * 業務個別処理.
	 * 
	 * @param piCompanyBean
	 *            リース会社マスタBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSCompanyBean piCompanyBean) throws Exception {

		this.getData(piCompanyBean);

		super.setForwardPath("/jsp/C001.jsp");
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piCompanyBean
	 *            リース会社マスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSCompanyBean piCompanyBean) throws SQLException {

		piCompanyBean.setMessage("");
		piCompanyBean.setLeasCompanyCode(super.getCommonBean().getCompanyCode());
		piCompanyBean.setCondCompanyCode(super.getCommonBean().getCompanyCode());
		piCompanyBean.setProcMode(LACSDefine.ProcMode.PROC_MODE_UPD);
		piCompanyBean.getDispControl().clear();
		piCompanyBean.setMessage("");
	}

	/**
	 * データ取得.
	 * 
	 * @param piCompanyBean
	 *            リース会社マスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	private void getData(LACSCompanyBean piCompanyBean) throws SQLException {
		LACSCompanyEntity companyEntity = new LACSCompanyEntity(this);

		try {
			companyEntity.setCon(super.con);

			companyEntity.setLeasCompanyCode(Command.changeQt(super.getCommonBean().getCompanyCode()));
			piCompanyBean.setName("");
			piCompanyBean.setLogo("");
			piCompanyBean.setZip1("");
			piCompanyBean.setZip2("");
			piCompanyBean.setAddress1("");
			piCompanyBean.setAddress2("");
			piCompanyBean.setBusyo("");
			piCompanyBean.setTanto("");
			piCompanyBean.setTantoTel("");
			piCompanyBean.setKakinPattern("");
			piCompanyBean.setKihonAmount("");
			piCompanyBean.setWaribiki("");
			piCompanyBean.setKaisyuKbn("1");
			piCompanyBean.setSyoriYM("");

			piCompanyBean.setKimatsuAmtOutCtl("0");

			piCompanyBean.setSessionTimeOut("");
			piCompanyBean.setLoginErrorMaxCount("");
			piCompanyBean.setTempPassValidityTerm("");
			piCompanyBean.setPassValidityTerm("");
			piCompanyBean.setPasswordLengthMin("");
			piCompanyBean.setPasswordLengthMax("");
			piCompanyBean.setErrorLockType("0");
			piCompanyBean.setLogoFileName("");
			piCompanyBean.setCertificateMarkURL("");
			piCompanyBean.setFreeWord("");
			if ("1".equals(super.getCommonBean().getShowTyukiComment())) {
				piCompanyBean.setTyukiComment1("");
				piCompanyBean.setTyukiComment2("");
			}

			companyEntity.execSQL();

			if (companyEntity.next()) {
				piCompanyBean.setName(Command.init(companyEntity.getName(), ""));
				piCompanyBean.setLogo(Command.init(companyEntity.getLogo(), ""));
				piCompanyBean.setZip1(Command.init(companyEntity.getZip1(), ""));
				piCompanyBean.setZip2(Command.init(companyEntity.getZip2(), ""));
				piCompanyBean.setAddress1(Command.init(companyEntity.getAddress1(), ""));
				piCompanyBean.setAddress2(Command.init(companyEntity.getAddress2(), ""));
				piCompanyBean.setBusyo(Command.init(companyEntity.getBusyo(), ""));
				piCompanyBean.setTanto(Command.init(companyEntity.getTanto(), ""));
				piCompanyBean.setTantoTel(Command.init(companyEntity.getTantoTel(), ""));
				piCompanyBean.setKakinPattern(Command.init(companyEntity.getKakinPattern(), ""));
				piCompanyBean.setKihonAmount(Long.toString(companyEntity.getKihonAmount()));
				piCompanyBean.setWaribiki(Double.toString(companyEntity.getWaribiki()));
				piCompanyBean.setKaisyuKbn(Command.init(companyEntity.getKaisyuKbn(), ""));
				piCompanyBean.setSyoriYM(Command.init(companyEntity.getSyoriYM(), ""));

				piCompanyBean.setKimatsuAmtOutCtl(companyEntity.getKimatsuAmtOutCtl());

				piCompanyBean.setSessionTimeOut(Command.init(companyEntity.getSessionTimeOut(), ""));
				piCompanyBean.setLoginErrorMaxCount(Command.init(companyEntity.getLoginErrorMaxCount(), ""));
				piCompanyBean.setTempPassValidityTerm(Command.init(companyEntity.getTempPassValidityTerm(), ""));
				piCompanyBean.setPassValidityTerm(Command.init(companyEntity.getPassValidityTerm(), ""));
				piCompanyBean.setPasswordLengthMin(Command.init(companyEntity.getPasswordLengthMin(), ""));
				piCompanyBean.setPasswordLengthMax(Command.init(companyEntity.getPasswordLengthMax(), ""));
				piCompanyBean.setErrorLockType(companyEntity.getErrorLockType());
				piCompanyBean.setLogoFileName(Command.init(companyEntity.getLogoFileName(), ""));
				piCompanyBean.setCertificateMarkURL(Command.init(companyEntity.getCertificateMarkURL(), ""));
				piCompanyBean.setFreeWord(Command.init(companyEntity.getFreeWord(), ""));
				if ("1".equals(super.getCommonBean().getShowTyukiComment())) {
					piCompanyBean.setTyukiComment1(Command.init(companyEntity.getTyukiComment1(), ""));
					piCompanyBean.setTyukiComment2(Command.init(companyEntity.getTyukiComment2(), ""));
				}
			}

			piCompanyBean.setDataMax(companyEntity.getAllDataCount());

			dispControlCommon.getDBDispControl(LACSDefine.INFO_ALL, 0);
		}
		finally {
			companyEntity.close();
		}
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "表示";
	}
}
