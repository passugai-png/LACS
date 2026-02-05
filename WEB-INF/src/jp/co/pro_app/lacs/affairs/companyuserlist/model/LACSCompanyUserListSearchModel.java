package jp.co.pro_app.lacs.affairs.companyuserlist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.companyuser.bean.LACSCompanyUserBean;
import jp.co.pro_app.lacs.affairs.companyuserlist.bean.LACSCompanyUserListBean;
import jp.co.pro_app.lacs.affairs.companyuserlist.data.entity.LACSCompanyUserListEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * リース会社別リースユーザーマスタ一覧：検索処理Model.
 * 
 * @author active
 * @version 20071210
 */
public class LACSCompanyUserListSearchModel extends LACSCompanyUserListModelBase {

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
	 * @param piCompanyUserListBean
	 *            リース会社別リースユーザーマスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSCompanyUserListBean piCompanyUserListBean) throws Exception {
		this.getData(piCompanyUserListBean);

		if (piCompanyUserListBean.getDataMax() > 0) {
			piCompanyUserListBean.setShowList(true);
		}
		else {
			piCompanyUserListBean.setShowList(false);
			message.addMessage(LACSDefine.MessageCode.WARN_DB_NORESULT);
		}
		piCompanyUserListBean.setMessage(message.getMessage());
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
		piCompanyUserListBean.init(this.getCommonBean());
		super.prepareComoboBox(piCompanyUserListBean);

		piCompanyUserListBean.setLeasCompanyCode(super.getInput("condCompanyCode", ""));
		piCompanyUserListBean.setTorihikiCode(super.getInput("condTorihikiCode", ""));

		piCompanyUserListBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));

		piCompanyUserListBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));

		piCompanyUserListBean.setCurrent(1);

		piCompanyUserListBean.setMessage("");
	}

	private void getData(LACSCompanyUserListBean piCompanyUserListBean) throws SQLException {
		LACSCompanyUserListEntity companyUserListEntity = new LACSCompanyUserListEntity(this);
		LACSCompanyUserBean detail = null;

		int per = piCompanyUserListBean.getPer();
		int current = piCompanyUserListBean.getCurrent();
		int from = (current - 1) * per + 1;
		int to = (current) * per;

		if (LACSCompanyUserListDeleteModel.class.equals(this.getClass()) && piCompanyUserListBean.getMessage().trim().length() == 0) {
			int maxCount = piCompanyUserListBean.getDataMax();
			if ((current - 1) * per + 1 == maxCount) {
				from = (current - 2) * per + 1;
				to = (current - 1) * per;
				piCompanyUserListBean.setCurrent(current - 1);
			}
		}

		try {
			piCompanyUserListBean.clearList();

			companyUserListEntity.setCon(super.con);

			companyUserListEntity.setLeasCompanyCode(piCompanyUserListBean.getLeasCompanyCode());
			companyUserListEntity.setTorihikiCode(piCompanyUserListBean.getTorihikiCode());

			companyUserListEntity.setCosmosCode(piCompanyUserListBean.getLeasCompany().getValue());

			companyUserListEntity.setFrom(from);
			companyUserListEntity.setTo(to);

			companyUserListEntity.execSQL();

			while (companyUserListEntity.next()) {
				detail = new LACSCompanyUserBean();
				piCompanyUserListBean.addDetail(detail);

				detail.setLeasCompanyCode(companyUserListEntity.getLeasCompanyCode());
				detail.setTorihikiCode(companyUserListEntity.getTorihikiCode());
				detail.setCosmosCode(companyUserListEntity.getCosmosCode());
				detail.setTeikyouYMD(companyUserListEntity.getTeikyouYMD());
				detail.setTeikyouYM(companyUserListEntity.getTeikyouYM());

				detail.setUserName(companyUserListEntity.getUserName());

			}

			piCompanyUserListBean.setDataMax(companyUserListEntity.getAllDataCount());
		}
		finally {
			companyUserListEntity.close();
		}
	}

}
