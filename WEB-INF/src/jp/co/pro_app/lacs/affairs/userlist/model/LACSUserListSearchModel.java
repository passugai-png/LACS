package jp.co.pro_app.lacs.affairs.userlist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.user.bean.LACSUserBean;
import jp.co.pro_app.lacs.affairs.userlist.bean.LACSUserListBean;
import jp.co.pro_app.lacs.affairs.userlist.data.entity.LACSUserListEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * リースユーザーマスタ一覧：検索処理Model.
 * 
 * @author active
 * @version 20071210
 */
public class LACSUserListSearchModel extends LACSUserListModelBase {

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
	 * @param piUserListBean
	 *            リースユーザーマスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSUserListBean piUserListBean) throws Exception {

		this.getData(piUserListBean);

		if (piUserListBean.getDataMax() > 0) {
			piUserListBean.setShowList(true);
		}
		else {
			piUserListBean.setShowList(false);
			message.addMessage(LACSDefine.MessageCode.WARN_DB_NORESULT);
		}
		piUserListBean.setMessage(message.getMessage());
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piUserListBean
	 *            リースユーザーマスタ一覧Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSUserListBean piUserListBean) throws SQLException {

		piUserListBean.init(this.getCommonBean());

		piUserListBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));

		super.prepareComoboBox(piUserListBean);

		piUserListBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));

		piUserListBean.setCurrent(1);

		piUserListBean.setMessage("");
	}

	private void getData(LACSUserListBean piUserListBean) throws SQLException {
		LACSUserListEntity userListEntity = new LACSUserListEntity(this);
		LACSUserBean detail = null;

		int per = piUserListBean.getPer();
		int current = piUserListBean.getCurrent();
		int from = (current - 1) * per + 1;
		int to = (current) * per;

		if (LACSUserListDeleteModel.class.equals(this.getClass()) && piUserListBean.getMessage().trim().length() == 0) {
			int maxCount = piUserListBean.getDataMax();
			if ((current - 1) * per + 1 == maxCount) {
				from = (current - 2) * per + 1;
				to = (current - 1) * per;
				piUserListBean.setCurrent(current - 1);
			}
		}

		try {
			piUserListBean.clearList();

			userListEntity.setCon(super.con);

			userListEntity.setCosmosCode(piUserListBean.getLeasCompany().getValue());

			userListEntity.setFrom(from);
			userListEntity.setTo(to);

			userListEntity.execSQL();

			while (userListEntity.next()) {
				detail = new LACSUserBean();
				piUserListBean.addDetail(detail);

				detail.setUserCosmosCode(userListEntity.getCosmosCode());
				detail.setUserName(userListEntity.getName());
				detail.setUserAddress1(userListEntity.getAddress());
				detail.setUserTelNo(userListEntity.getTel());
				detail.setUserTantoName(userListEntity.getTanto());
			}

			piUserListBean.setDataMax(userListEntity.getAllDataCount());
		}
		finally {
			userListEntity.close();
		}
	}

}
