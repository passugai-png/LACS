package jp.co.pro_app.lacs.affairs.infolist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.infolist.bean.LACSInfoListBean;
import jp.co.pro_app.projframe.common.dbaccess.NotSelectExecute;

/**
 * お知らせ一覧：検索処理Model.
 * 
 * @author Katoh
 * @version 20071218
 */
public class LACSInfoListDeleteModel extends LACSInfoListSearchModel {

	private String	targetRowId	= "";

	/**
	 * 業務個別処理.
	 * 
	 * @param piInfoListBean
	 *            リース会社マスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSInfoListBean piInfoListBean) throws Exception {

		if (this.checkData()) {
			this.delete();
		}

		piInfoListBean.setMessage(message.getMessage());
		super.businessProc(piInfoListBean);
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piInfoListBean
	 *            お知らせ一覧Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSInfoListBean piInfoListBean) throws SQLException {
		this.targetRowId = super.getInput("targetRowId", "").trim();
	}

	private boolean checkData() {
		boolean result = true;

		return result;
	}

	private void delete() throws SQLException {

		NotSelectExecute notSelectExecute = new NotSelectExecute();

		try {
			notSelectExecute.setCon(super.con);

			notSelectExecute.execState("DELETE FROM T_INFO WHERE ROWID = '" + targetRowId + "'");
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
