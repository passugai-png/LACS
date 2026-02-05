package jp.co.pro_app.lacs.affairs.karirisi.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.karirisi.bean.LACSKariRisiBean;
import jp.co.pro_app.lacs.affairs.karirisi.bean.LACSKariRisiDetailBean;
import jp.co.pro_app.lacs.affairs.karirisi.data.entity.LACSKariRisiEntity;

/**
 * リースユーザー別借入利子率マスタ：検索処理Model.
 * 
 * @author ohmura
 * @version 20070918
 */
public class LACSKariRisiSearchModel extends LACSKariRisiModelBase {

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
	 * @param piKariRisiBean
	 *            リースユーザーマスタBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSKariRisiBean piKariRisiBean) throws Exception {

		this.getData(piKariRisiBean);

		piKariRisiBean.setShowList(true);

		super.setForwardPath("/jsp/K003.jsp");
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piKariRisiBean
	 *            リースユーザーマスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSKariRisiBean piKariRisiBean) throws SQLException {

		piKariRisiBean.setMessage("");
	}

	/**
	 * データ取得.
	 * 
	 * @param piKariRisiBean
	 *            リースユーザーマスタBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	private void getData(LACSKariRisiBean piKariRisiBean) throws SQLException {
		LACSKariRisiEntity kariRisiEntity = new LACSKariRisiEntity(this);
		LACSKariRisiDetailBean detail = null;
		piKariRisiBean.clearList();

		try {
			kariRisiEntity.setCon(super.con);

			kariRisiEntity.setCosmosCode(piKariRisiBean.getCosmosCode());

			kariRisiEntity.execSQL();

			detail = new LACSKariRisiDetailBean();
			piKariRisiBean.addDetail(detail);

			detail.setKikanFrom("");
			detail.setKikanTo("");
			detail.setRisiRitu("");

			while (kariRisiEntity.next()) {

				piKariRisiBean.setUserName(kariRisiEntity.getUserName());

				detail = new LACSKariRisiDetailBean();
				piKariRisiBean.addDetail(detail);

				detail.setKikanFrom(kariRisiEntity.getKikanFrom());
				detail.setKikanTo(kariRisiEntity.getKikanTo());
				detail.setRisiRitu(kariRisiEntity.getRisiRitu());
			}

			piKariRisiBean.setRetuSu(kariRisiEntity.getAllDataCount() + 1);
			piKariRisiBean.setDataMax(kariRisiEntity.getAllDataCount());
		}
		finally {
			kariRisiEntity.close();
		}
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}
}
