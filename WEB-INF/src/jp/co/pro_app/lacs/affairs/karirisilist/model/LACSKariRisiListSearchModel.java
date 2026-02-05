package jp.co.pro_app.lacs.affairs.karirisilist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.karirisi.bean.LACSKariRisiBean;
import jp.co.pro_app.lacs.affairs.karirisi.bean.LACSKariRisiDetailBean;
import jp.co.pro_app.lacs.affairs.karirisilist.bean.LACSKariRisiListBean;
import jp.co.pro_app.lacs.affairs.karirisilist.data.entity.LACSKariRisiListEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.StringUtl;

/**
 * リースユーザー別借入利子率マスタ一覧：検索処理Model.
 * 
 * @author active
 * @version 20071210
 */
public class LACSKariRisiListSearchModel extends LACSKariRisiListModelBase {

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
	 * @param piKariRisiListBean
	 *            リースユーザー別借入利子率マスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSKariRisiListBean piKariRisiListBean) throws Exception {
		this.getData(piKariRisiListBean);

		if (piKariRisiListBean.getDataMax() > 0) {
			piKariRisiListBean.setShowList(true);
		}
		else {
			piKariRisiListBean.setShowList(false);
			message.addMessage(LACSDefine.MessageCode.WARN_DB_NORESULT);
		}
		piKariRisiListBean.setMessage(message.getMessage());
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piKariRisiListBean
	 *            リースユーザー別借入利子率マスタ一覧Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSKariRisiListBean piKariRisiListBean) throws SQLException {

		super.prepareComoboBox(piKariRisiListBean);

		piKariRisiListBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));

		piKariRisiListBean.setLeasCompanyNm(super.getInput("leasCompanyNm", ""));

		piKariRisiListBean.setCurrent(1);

		piKariRisiListBean.setMessage("");
	}

	private void getData(LACSKariRisiListBean piKariRisiListBean) throws SQLException {
		LACSKariRisiListEntity kariRisiListEntity = new LACSKariRisiListEntity(this);
		LACSKariRisiBean detail = null;
		LACSKariRisiDetailBean detail2 = null;

		int per = piKariRisiListBean.getPer();
		int current = piKariRisiListBean.getCurrent();
		int from = (current - 1) * per + 1;
		int to = (current) * per;

		try {
			piKariRisiListBean.clearList();

			kariRisiListEntity.setCon(super.con);

			kariRisiListEntity.setCosmosCode(piKariRisiListBean.getLeasCompany().getValue());

			kariRisiListEntity.setFrom(from);
			kariRisiListEntity.setTo(to);

			kariRisiListEntity.execSQL();

			while (kariRisiListEntity.next()) {
				detail = new LACSKariRisiBean();
				detail2 = new LACSKariRisiDetailBean();
				piKariRisiListBean.addDetail(detail);
				detail.addDetail(detail2);

				detail2.setCosmosCode(kariRisiListEntity.getCosmosCode());
				detail2.setUserName(kariRisiListEntity.getUserName());
				detail2.setKikanFrom(kariRisiListEntity.getKikanFrom());
				detail2.setKikanTo(kariRisiListEntity.getKikanTo());
				detail2.setRisiRitu(StringUtl.formatNumber(kariRisiListEntity.getRisiRitu(), "0.000"));
				detail2.setCount(kariRisiListEntity.getCount());
			}

			piKariRisiListBean.setDataMax(kariRisiListEntity.getAllDataCount());
		}
		finally {
			kariRisiListEntity.close();
		}
	}

}
