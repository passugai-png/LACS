package jp.co.pro_app.lacs.affairs.tantolist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.data.entity.LACSTantoUserEntity;
import jp.co.pro_app.lacs.affairs.tantolist.bean.LACSTantoListBean;
import jp.co.pro_app.lacs.affairs.tantolist.bean.LACSTantoListDetailBean;
import jp.co.pro_app.lacs.affairs.tantolist.data.entity.LACSTantoListEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Convert;

/**
 * リースユーザー担当者マスタ一覧：検索処理Model.
 * 
 * @author active
 * @version 20071210
 */
public class LACSTantoListSearchModel extends LACSTantoListModelBase {

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
	 * @param piTantoListBean
	 *            リースユーザー担当者マスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSTantoListBean piTantoListBean) throws Exception {
		this.getData(piTantoListBean);

		if (piTantoListBean.getDataMax() > 0) {
			piTantoListBean.setShowList(true);
		}
		else {
			piTantoListBean.setShowList(false);
			message.addMessage(LACSDefine.MessageCode.WARN_DB_NORESULT);
		}
		piTantoListBean.setMessage(message.getMessage());
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

		piTantoListBean.init(this.getCommonBean());

		piTantoListBean.setUserID(super.getInput("condUserID", ""));
		piTantoListBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));
		piTantoListBean.setUserRight(super.getInput("condUserRight", "0"));

		super.prepareComoboBox(piTantoListBean);

		piTantoListBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));
		piTantoListBean.getTantJti().setSelectedValue(super.getInput("tantJti", ""));

		piTantoListBean.setCurrent(1);

		piTantoListBean.setMessage("");

	}

	private void getData(LACSTantoListBean piTantoListBean) throws SQLException {
		LACSTantoListEntity tantoListEntity = new LACSTantoListEntity(this);
		LACSTantoListDetailBean detail = null;
		LACSTantoUserEntity tantoUserEntity = new LACSTantoUserEntity(this);

		int per = piTantoListBean.getPer();
		int current = piTantoListBean.getCurrent();
		int from = (current - 1) * per + 1;
		int to = (current) * per;

		try {
			piTantoListBean.clearList();

			tantoListEntity.setCon(super.con);

			tantoListEntity.setUserId(piTantoListBean.getUserID());
			tantoListEntity.setCosmosCode(piTantoListBean.getLeasCompany().getValue());
			tantoListEntity.setTanJti(piTantoListBean.getTantJti().getValue());
			tantoListEntity.setUserRight(piTantoListBean.getUserRight());

			tantoListEntity.setFrom(from);
			tantoListEntity.setTo(to);

			tantoListEntity.execSQL();

			tantoUserEntity.setCon(super.con);

			while (tantoListEntity.next()) {
				detail = new LACSTantoListDetailBean();
				piTantoListBean.addDetail(detail);

				detail.setUserID(tantoListEntity.getUserId());
				detail.setUserTantoName(tantoListEntity.getUserTantoName());
				detail.setPasswordYukoTerm(Convert.toDateString(tantoListEntity.getPasswordYukoTerm()));
				detail.setTantJtiKbn(tantoListEntity.getTantJtiKbn());
				detail.setTantJtiKbnName(tantoListEntity.getTantJtiName());
				detail.setUserRight(tantoListEntity.getUserRight());
				detail.setUserRightName(tantoListEntity.getUserRightName());

				tantoUserEntity.setUserId(tantoListEntity.getUserId());
				tantoUserEntity.execSQL();

				while (tantoUserEntity.next()) {
					detail.getUserName().add(tantoUserEntity.getUserName());
				}
			}

			piTantoListBean.setDataMax(tantoListEntity.getAllDataCount());
		}
		finally {
			tantoListEntity.close();
			tantoUserEntity.close();
		}
	}

}
