package jp.co.pro_app.lacs.affairs.tantolist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.command.LACSLoginSecurity;
import jp.co.pro_app.lacs.affairs.tantolist.bean.LACSTantoListBean;
import jp.co.pro_app.projframe.common.dbaccess.NotSelectExecute;

/**
 * リースユーザー担当者マスタ一覧：削除Model.
 * 
 * @author katoh
 * @version 20071218
 */
public class LACSTantoListUnlockModel extends LACSTantoListSearchModel {

	private String	targetUserID	= "";

	/**
	 * 業務個別処理.
	 * 
	 * @param piTantoListBean
	 *            リースユーザー担当者マスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSTantoListBean piTantoListBean) throws Exception {

		if (this.checkData()) {
			this.delete();
		}

		piTantoListBean.setMessage(message.getMessage());
		super.businessProc(piTantoListBean);
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piTantoListBean
	 *            リースユーザー担当者マスタ一覧Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSTantoListBean piTantoListBean) throws SQLException {
		this.targetUserID = super.getInput("targetUserID", "").trim();
	}

	private boolean checkData() {
		boolean result = true;

		return result;
	}

	private void delete() throws SQLException {

		NotSelectExecute notSelectExecute = new NotSelectExecute();
		LACSLoginSecurity security = new LACSLoginSecurity(this, super.con, targetUserID);

		try {
			notSelectExecute.setCon(super.con);

			notSelectExecute.execState("UPDATE M_LU_TNT SET MISS_CNT = 0 WHERE LU_ID = '" + targetUserID + "'");

			security.delete();
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
		return "解除";
	}
}
