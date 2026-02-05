package jp.co.pro_app.lacs.affairs.companylist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.companylist.bean.LACSCompanyListBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.dbaccess.NotSelectExecute;
import jp.co.pro_app.projframe.common.dbaccess.SelectEx;

/**
 * リース会社マスタ：削除Model.
 * 
 * @author katoken
 * @version 20071218
 */
public class LACSCompanyListDeleteModel extends LACSCompanyListSearchModel {

	private String	targetCompanyCode	= "";

	/**
	 * 業務個別処理.
	 * 
	 * @param piCompanyListBean
	 *            リース会社マスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSCompanyListBean piCompanyListBean) throws Exception {

		if (this.checkData()) {
			this.delete();
		}

		piCompanyListBean.setMessage(message.getMessage());
		super.businessProc(piCompanyListBean);
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piCompanyListBean
	 *            リース会社マスタ一覧Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSCompanyListBean piCompanyListBean) throws SQLException {
		this.targetCompanyCode = super.getInput("targetCompanyCode", "").trim();
	}

	private boolean checkData() throws SQLException {
		boolean result = true;

		SelectEx select = new SelectEx(super.con);

		if (select.getRecordCount("M_LC_BETU_LU", "LC_CD = '" + targetCompanyCode + "'") > 0) {
			message.addMessage(LACSDefine.MessageCode.ERROR_DB_RELATE_DATA_EXIST, new String[]{ "リース会社コード", "顧客別開示先" });
			result = false;
		}

		return result;
	}

	private void delete() throws SQLException {

		NotSelectExecute notSelectExecute = new NotSelectExecute();

		try {
			notSelectExecute.setCon(super.con);

			notSelectExecute.execState("DELETE FROM M_LC WHERE LC_CD = '" + targetCompanyCode + "'");
		}
		finally {
			notSelectExecute.closeState();
		}
	}
}
