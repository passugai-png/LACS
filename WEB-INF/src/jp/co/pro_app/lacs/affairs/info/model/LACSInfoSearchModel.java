package jp.co.pro_app.lacs.affairs.info.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.info.bean.LACSInfoBean;
import jp.co.pro_app.lacs.affairs.info.data.entity.LACSInfoEntity;
import jp.co.pro_app.projframe.common.command.Command;

/**
 * お知らせ：検索処理Model.
 * 
 * @author takeda
 * @version 20070907
 */
public class LACSInfoSearchModel extends LACSInfoModelBase {

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
	 * @param piInfoBean
	 *            お知らせBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSInfoBean piInfoBean) throws Exception {

		this.getData(piInfoBean);

		super.setForwardPath("/jsp/I001.jsp");
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piInfoBean
	 *            お知らせBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	protected void initSub(LACSInfoBean piInfoBean) throws SQLException {

		piInfoBean.setRowId(super.getInput("targetRowId", ""));
		piInfoBean.setLeasCompanyNm("");

		super.prepareComoboBox(piInfoBean);

		piInfoBean.setCondStartYmd(super.getInput("condStartYmd", ""));
		piInfoBean.setCondEndYmd(super.getInput("condEndYmd", ""));
		piInfoBean.setCondInfoData(super.getInput("condInfoData", ""));

		piInfoBean.getLeasCompany().setSelectedValue(super.getInput("condleasCompany", ""));

		piInfoBean.setLeasCompanyNm(super.getInput("condleasCompanyNm", ""));

		piInfoBean.setMessage("");
	}

	/**
	 * データ取得.
	 * 
	 * @param piInfoBean
	 *            お知らせBean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	private void getData(LACSInfoBean piInfoBean) throws SQLException {
		LACSInfoEntity infoEntity = new LACSInfoEntity(this);

		try {
			infoEntity.setCon(super.con);

			infoEntity.setRowId(piInfoBean.getRowId());
			piInfoBean.setStartYmd("");
			piInfoBean.setEndYmd("");
			piInfoBean.setInfoData("");
			piInfoBean.getLeasCompany().setSelectedValue("");
			piInfoBean.setLeasCompanyNm("");

			infoEntity.execSQL();

			if (infoEntity.next()) {
				piInfoBean.setStartYmd(Command.init(infoEntity.getStartYmd(), ""));
				piInfoBean.setEndYmd(Command.init(infoEntity.getEndYmd(), ""));
				piInfoBean.setInfoData(Command.init(infoEntity.getInfoData(), ""));
				piInfoBean.getLeasCompany().setSelectedValue(infoEntity.getCosmosCode());
			}

			piInfoBean.setDataMax(infoEntity.getAllDataCount());
		}
		finally {
			infoEntity.close();
		}
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}
}
