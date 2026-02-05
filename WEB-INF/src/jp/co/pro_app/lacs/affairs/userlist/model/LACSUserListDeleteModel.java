package jp.co.pro_app.lacs.affairs.userlist.model;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.pro_app.lacs.affairs.userlist.bean.LACSUserListBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.dbaccess.NotSelectExecute;
import jp.co.pro_app.projframe.common.dbaccess.SelectEx;

/**
 * リースユーザーマスタ一覧：削除Model.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSUserListDeleteModel extends LACSUserListSearchModel {

	private String	targetCosmosCode	= "";

	/**
	 * 業務個別処理.
	 * 
	 * @param piUserListBean
	 *            リースユーザーマスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSUserListBean piUserListBean) throws Exception {

		if (this.checkData()) {
			this.delete();
		}

		piUserListBean.setMessage(message.getMessage());
		super.businessProc(piUserListBean);
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piUserListBean
	 *            リースユーザーマスタ一覧Bean
	 */
	protected void initSub(LACSUserListBean piUserListBean) {
		this.targetCosmosCode = super.getInput("targetCosmosCode", "").trim();
	}

	private boolean checkData() throws SQLException {
		boolean result = true;

		SelectEx select = new SelectEx(super.con);

		if (select.getRecordCount("M_LC_BETU_LU", "LU_COSMOS_CD = '" + targetCosmosCode + "'") > 0) {
			message.addMessage(LACSDefine.MessageCode.ERROR_DB_RELATE_DATA_EXIST, new String[]{ "開示先", "顧客別開示先" });
			result = false;
		}

		if (select.getRecordCount("M_LU_BETU_KRI_RS_RT", "LU_COSMOS_CD = '" + targetCosmosCode + "'") > 0) {
			message.addMessage(LACSDefine.MessageCode.ERROR_DB_RELATE_DATA_EXIST, new String[]{ "開示先", "借入利子率" });
			result = false;
		}

		if (select.getRecordCount("M_LU_TNT_BETU_USER", "LU_COSMOS_CD = '" + targetCosmosCode + "'") > 0) {
			message.addMessage(LACSDefine.MessageCode.ERROR_DB_RELATE_DATA_EXIST, new String[]{ "開示先", "担当者" });
			result = false;
		}

		return result;
	}

	private void delete() throws SQLException {

		NotSelectExecute notSelectExecute = new NotSelectExecute();
		ArrayList<String> sqls = new ArrayList<String>();

		try {
			notSelectExecute.setCon(super.con);

			sqls.add("DELETE FROM M_LU WHERE LU_COSMOS_CD = '" + targetCosmosCode + "'");
			sqls.add("DELETE FROM M_DSP_CTRL WHERE LU_COSMOS_CD = '" + targetCosmosCode + "'");
			notSelectExecute.execState(sqls);
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
