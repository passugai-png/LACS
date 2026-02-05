package jp.co.pro_app.lacs.affairs.companyuser.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.companyuser.bean.LACSCompanyUserBean;
import jp.co.pro_app.lacs.affairs.companyuser.data.entity.LACSCompanyUserEntity;
import jp.co.pro_app.projframe.common.command.Command;

/**
 * リース会社別リースユーザーマスタ：検索処理Model.
 * 
 * @author takeda
 * @version 20070907
 */
public class LACSCompanyUserSearchModel extends LACSCompanyUserModelBase {

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
	 * @param piCompanyUserBean
	 *            リース会社別リースユーザーマスタBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSCompanyUserBean piCompanyUserBean) throws Exception {

		this.getData(piCompanyUserBean);
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piCompanyUserBean
	 *            リース会社別リースユーザーマスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSCompanyUserBean piCompanyUserBean) throws SQLException {

		piCompanyUserBean.setMessage("");
	}

	/**
	 * データ取得.
	 * 
	 * @param piCompanyUserBean
	 *            リース会社別リースユーザーマスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	private void getData(LACSCompanyUserBean piCompanyUserBean) throws SQLException {
		LACSCompanyUserEntity companyUserEntity = new LACSCompanyUserEntity(this);

		try {
			companyUserEntity.setCon(super.con);

			companyUserEntity.setLeasCompanyCode(Command.changeQt(piCompanyUserBean.getLeasCompanyCode()));
			companyUserEntity.setTorihikiCode(Command.changeQt(piCompanyUserBean.getTorihikiCode()));
			piCompanyUserBean.setCosmosCode("");
			piCompanyUserBean.setTeikyouYMD("");
			piCompanyUserBean.setTeikyouYM("");

			companyUserEntity.execSQL();

			if (companyUserEntity.next()) {
				piCompanyUserBean.setCosmosCode(Command.init(companyUserEntity.getCosmosCode(), ""));
				piCompanyUserBean.setTeikyouYMD(Command.init(companyUserEntity.getTeikyouYMD(), ""));
				piCompanyUserBean.setTeikyouYM(Command.init(companyUserEntity.getTeikyouYM(), ""));
			}

			piCompanyUserBean.setDataMax(companyUserEntity.getAllDataCount());
		}
		finally {
			companyUserEntity.close();
		}
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}

}
