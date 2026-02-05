package jp.co.pro_app.lacs.affairs.companylist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.company.bean.LACSCompanyBean;
import jp.co.pro_app.lacs.affairs.companylist.bean.LACSCompanyListBean;
import jp.co.pro_app.lacs.affairs.companylist.data.entity.LACSCompanyListEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * リース会社マスタ一覧：検索処理Model.
 * 
 * @author active
 * @version 20071210
 */
public class LACSCompanyListSearchModel extends LACSCompanyListModelBase {

	/**
	 * 業務個別処理.
	 * 
	 * @param piCompanyListBean
	 *            リース会社マスタ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSCompanyListBean piCompanyListBean) throws Exception {

		this.getData(piCompanyListBean);

		if (piCompanyListBean.getDataMax() > 0) {
			piCompanyListBean.setShowList(true);
		}
		else {
			piCompanyListBean.setShowList(false);
			message.addMessage(LACSDefine.MessageCode.WARN_DB_NORESULT);
		}
		piCompanyListBean.setMessage(message.getMessage());
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

		super.prepareComoboBox(piCompanyListBean);

		piCompanyListBean.setCondCompanyCode(super.getInput("condCompanyCode", ""));

		piCompanyListBean.setCurrent(1);
		piCompanyListBean.setMessage("");
	}

	private void getData(LACSCompanyListBean piCompanyListBean) throws SQLException {
		LACSCompanyListEntity companyListEntity = new LACSCompanyListEntity(this);
		LACSCompanyBean detail = null;

		int per = piCompanyListBean.getPer();
		int current = piCompanyListBean.getCurrent();
		int from = (current - 1) * per + 1;
		int to = (current) * per;

		try {
			piCompanyListBean.clearList();

			companyListEntity.setCon(super.con);

			companyListEntity.setLeasCompanyCode(piCompanyListBean.getCondCompanyCode());

			companyListEntity.setFrom(from);
			companyListEntity.setTo(to);

			companyListEntity.execSQL();

			while (companyListEntity.next()) {
				detail = new LACSCompanyBean();
				piCompanyListBean.addDetail(detail);

				detail.setLeasCompanyCode(companyListEntity.getLeasCompanyCode());
				detail.setName(companyListEntity.getName());
				detail.setAddress1(companyListEntity.getAddress1());
				detail.setBusyo(companyListEntity.getBusyo());
				detail.setTanto(companyListEntity.getTanto());
				detail.setTantoTel(companyListEntity.getTantoTel());
				detail.setKakinPattern(companyListEntity.getKakinPattern());
				detail.setKihonAmount(companyListEntity.getKihonAmount());
				detail.setWaribiki(companyListEntity.getWaribiki());
				detail.setKaisyuKbn(companyListEntity.getKaisyuKbn());
				detail.setSyoriYM(companyListEntity.getSyoriYM());

			}

			piCompanyListBean.setDataMax(companyListEntity.getAllDataCount());
		}
		finally {
			companyListEntity.close();
		}
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "検索";
	}
}
