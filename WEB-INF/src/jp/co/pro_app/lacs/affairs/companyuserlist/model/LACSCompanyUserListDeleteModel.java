package jp.co.pro_app.lacs.affairs.companyuserlist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.companyuserlist.bean.LACSCompanyUserListBean;
import jp.co.pro_app.projframe.common.dbaccess.NotSelectExecute;

/**
 * リース会社別リースユーザーマスタ一覧：検索処理Model.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSCompanyUserListDeleteModel extends LACSCompanyUserListSearchModel {

	private String	targetCompanyCode	= "";

	private String	targetTorihikiCode	= "";

	/**
	 * 業務個別処理.
	 * 
	 * @param piCompanyUserListBean
	 *            リース会社マスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSCompanyUserListBean piCompanyUserListBean) throws Exception {

		if (this.checkData()) {
			this.delete();
		}

		piCompanyUserListBean.setMessage(message.getMessage());
		super.businessProc(piCompanyUserListBean);
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piCompanyUserListBean
	 *            リース会社別リースユーザーマスタ一覧Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSCompanyUserListBean piCompanyUserListBean) throws SQLException {
		this.targetCompanyCode = super.getInput("targetCompanyCode", "").trim();
		this.targetTorihikiCode = super.getInput("targetTorihikiCode", "").trim();
	}

	private boolean checkData() {
		boolean result = true;

		return result;
	}

	private void delete() throws SQLException {

		NotSelectExecute notSelectExecute = new NotSelectExecute();

		try {
			notSelectExecute.setCon(super.con);

			notSelectExecute.execState("DELETE FROM M_LC_BETU_LU WHERE LC_CD = '" + targetCompanyCode + "' AND LU_TRSK_CD = '" + targetTorihikiCode + "'");
		}
		finally {
			notSelectExecute.closeState();
		}
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "削除";
	}
}
