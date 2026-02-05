package jp.co.pro_app.lacs.affairs.karirisilist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.karirisilist.bean.LACSKariRisiListBean;
import jp.co.pro_app.projframe.common.dbaccess.NotSelectExecute;

/**
 * リースユーザー別借入利子率マスタ一覧：削除Model.
 * 
 * @author active
 * @version 20071210
 */
public class LACSKariRisiListDeleteModel extends LACSKariRisiListSearchModel {

	private String	targetCosmosCode	= "";

	/**
	 * 業務個別処理.
	 * 
	 * @param piKariRisiListBean
	 *            リースユーザー別借入利子率マスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSKariRisiListBean piKariRisiListBean) throws Exception {

		if (this.checkData()) {
			this.delete();
		}

		piKariRisiListBean.setMessage(message.getMessage());
		super.businessProc(piKariRisiListBean);
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piKariRisiListBean
	 *            リースユーザー別借入利子率マスタ一覧Bean
	 */
	protected void initSub(LACSKariRisiListBean piKariRisiListBean) {
		this.targetCosmosCode = super.getInput("targetCosmosCode", "").trim();
	}

	private boolean checkData() {
		boolean result = true;

		return result;
	}

	private void delete() throws SQLException {

		NotSelectExecute notSelectExecute = new NotSelectExecute();

		try {
			notSelectExecute.setCon(super.con);

			notSelectExecute.execState("DELETE FROM M_LU_BETU_KRI_RS_RT WHERE LU_COSMOS_CD = '" + targetCosmosCode + "'");
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
