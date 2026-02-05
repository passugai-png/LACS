package jp.co.pro_app.lacs.affairs.infolist.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.info.bean.LACSInfoBean;
import jp.co.pro_app.lacs.affairs.infolist.bean.LACSInfoListBean;
import jp.co.pro_app.lacs.affairs.infolist.data.entity.LACSInfoListEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * お知らせ一覧：検索処理Model.
 * 
 * @author active
 * @version 20071210
 */
public class LACSInfoListSearchModel extends LACSInfoListModelBase {

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
	 * @param piInfoListBean
	 *            お知らせ一覧Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSInfoListBean piInfoListBean) throws Exception {
		this.getData(piInfoListBean);

		if (piInfoListBean.getDataMax() > 0) {
			piInfoListBean.setShowList(true);
		}
		else {
			piInfoListBean.setShowList(false);
			message.addMessage(LACSDefine.MessageCode.WARN_DB_NORESULT);
		}
		piInfoListBean.setMessage(message.getMessage());
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

		piInfoListBean.init(this.getCommonBean());
		super.prepareComoboBox(piInfoListBean);

		piInfoListBean.setCondStartYmd(super.getInput("condStartYmd", ""));
		piInfoListBean.setCondEndYmd(super.getInput("condEndYmd", ""));
		piInfoListBean.setCondInfoData(super.getInput("condInfoData", ""));

		piInfoListBean.getLeasCompany().setSelectedValue(super.getInput("condleasCompany", ""));
		piInfoListBean.setLeasCompanyNm(super.getInput("condleasCompanyNm", ""));

		piInfoListBean.setCurrent(1);

		piInfoListBean.setMessage("");
	}

	private void getData(LACSInfoListBean piInfoListBean) throws SQLException {
		LACSInfoListEntity infoListEntity = new LACSInfoListEntity(this);
		LACSInfoBean detail = null;

		int per = piInfoListBean.getPer();
		int current = piInfoListBean.getCurrent();
		int from = (current - 1) * per + 1;
		int to = (current) * per;

		try {
			piInfoListBean.clearList();

			infoListEntity.setCon(super.con);

			infoListEntity.setCosmosCode(piInfoListBean.getLeasCompany().getValue());

			infoListEntity.setFrom(from);
			infoListEntity.setTo(to);

			infoListEntity.setStartYmd(piInfoListBean.getCondStartYmd());
			infoListEntity.setEndYmd(piInfoListBean.getCondEndYmd());
			infoListEntity.setInfoData(piInfoListBean.getCondInfoData());

			infoListEntity.execSQL();

			while (infoListEntity.next()) {
				detail = new LACSInfoBean();
				piInfoListBean.addDetail(detail);

				detail.setCondUserCosmosCode(infoListEntity.getCosmosCode());

				detail.setStartYmd(infoListEntity.getStartYmd());
				detail.setEndYmd(infoListEntity.getEndYmd());
				detail.setInfoData(infoListEntity.getInfoData());
				detail.setRowId(infoListEntity.getRowId());
				detail.setUserName(infoListEntity.getUserName());
			}

			piInfoListBean.setDataMax(infoListEntity.getAllDataCount());
		}
		finally {
			infoListEntity.close();
		}
	}

}
