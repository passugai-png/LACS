package jp.co.pro_app.lacs.affairs.info.model;

import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCheckUtl;
import jp.co.pro_app.lacs.affairs.info.bean.LACSInfoBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.dbaccess.MakeSQLInsertBase;
import jp.co.pro_app.projframe.common.dbaccess.MakeSQLUpdateBase;
import jp.co.pro_app.projframe.common.dbaccess.NotSelectExecute;

/**
 * お知らせ：登録処理Model.
 * 
 * @author takeda
 * @version 20070907
 */
public class LACSInfoRegistModel extends LACSInfoModelBase {

	/**
	 * テーブル名.
	 */
	private static final String	TABLE_NAME	= "T_INFO";

	/**
	 * 業務個別処理.
	 * 
	 * @param piInfoBean
	 *            お知らせBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSInfoBean piInfoBean) throws Exception {
		NotSelectExecute notSelectExecute = new NotSelectExecute();

		try {
			if (this.checkInput(super.getCommonBean(), piInfoBean)) {

				notSelectExecute.setCon(super.con);
				notSelectExecute.execState(makeSQL(piInfoBean));
			}

			if (message.hasMessage()) {
				piInfoBean.setMessage(message.getMessage());
				super.setForwardPath("/jsp/I001.jsp");
			}
			else {
				super.setForwardPath("/return.infolist");
			}
		}
		finally {
			notSelectExecute.closeState();
		}

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

		piInfoBean.setStartYmd(super.getInput("startYmd", "").trim());
		piInfoBean.setEndYmd(super.getInput("endYmd", "").trim());
		piInfoBean.setInfoData(super.getInput("infoData", "").trim());
		piInfoBean.setRowId(super.getInput("targetRowId", "").trim());
		piInfoBean.getLeasCompany().setSelectedValue(super.getInput("leasCompany", ""));
		piInfoBean.setMessage("");
	}

	/**
	 * 入力チェック.
	 * 
	 * @param piCommonBean
	 *            共通Bean
	 * @param piInfoBean
	 *            お知らせBean
	 * @return チェック結果
	 */
	private boolean checkInput(LACSCommonBean piCommonBean, LACSInfoBean piInfoBean) {
		boolean result = true;

		LACSCheckUtl checkUtl = new LACSCheckUtl(message);

		result &= checkUtl.checkMandatory("掲載期間(開始)", piInfoBean.getStartYmd());
		result &= checkUtl.checkDate("掲載期間(開始)", piInfoBean.getStartYmd());
		result &= checkUtl.checkMandatory("掲載期間(終了)", piInfoBean.getEndYmd());
		result &= checkUtl.checkDate("掲載期間(終了)", piInfoBean.getEndYmd());
		if ((piInfoBean.getStartYmd().compareTo(piInfoBean.getEndYmd()) > 0)) {
			message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_COMBINATION, "掲載期間");
			result &= false;
		}

		if (piInfoBean.getLeasCompany().getValue().trim().length() == 0) {
			message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_MANDATORY, "開示先");
			result &= false;
		}

		result &= checkUtl.checkMandatory("内容", piInfoBean.getInfoData());

		if (piInfoBean.getInfoData().replaceAll("\r\n", "\n").length() > 1000) {
			message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_CHAR_COUNT, new String[]{ "内容", "1000" });
			result &= false;
		}

		return result;
	}

	/**
	 * SQL文作成.
	 * 
	 * @param piInfoBean
	 *            お知らせBean
	 * @return SQL
	 */
	private String makeSQL(LACSInfoBean piInfoBean) {
		StringBuffer sql = new StringBuffer();
		ArrayList<String> items = getItems(piInfoBean);
		ArrayList<String> values = getValues(piInfoBean);

		if (piInfoBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_UPD) {

			StringBuffer where = new StringBuffer();
			where.append("ROWID = '" + Command.changeQt(piInfoBean.getRowId()) + "' " + "\n");
			MakeSQLUpdateBase.makeSQL(sql, TABLE_NAME, items, values, where.toString());
		}
		else {

			MakeSQLInsertBase.makeSQL(sql, TABLE_NAME, items, values);
		}

		return sql.toString();
	}

	/**
	 * DBカラム名取得.
	 * 
	 * @param piInfoBean
	 *            リース会社マスタBean
	 * @return DBカラム名
	 */
	private ArrayList<String> getItems(LACSInfoBean piInfoBean) {
		ArrayList<String> items = new ArrayList<String>();

		if (piInfoBean.getDataMax() <= 0) {

			items.add("ENT_DATE"); // 登録日時
			items.add("ENT_USR"); // 登録ユーザ
		}
		items.add("UPD_DATE"); // 更新日時
		items.add("UPD_USR"); // 更新ユーザ
		items.add("START_YMD");
		items.add("END_YMD");
		items.add("INFO_DATA");
		items.add("LU_COSMOS_CD");
		return items;
	}

	/**
	 * DB更新値取得.
	 * 
	 * @param piInfoBean
	 *            お知らせBean
	 * @return DB更新値
	 */
	private ArrayList<String> getValues(LACSInfoBean piInfoBean) {
		ArrayList<String> values = new ArrayList<String>();

		if (piInfoBean.getDataMax() <= 0) {

			values.add("SYSDATE");
			values.add("'" + Command.changeQt(super.getCommonBean().getCompanyCode()) + "'");
		}
		values.add("SYSDATE");
		values.add("'" + Command.changeQt(super.getCommonBean().getCompanyCode()) + "'");
		values.add("'" + piInfoBean.getStartYmd() + "'");
		values.add("'" + piInfoBean.getEndYmd() + "'");
		values.add("'" + Command.changeQt(piInfoBean.getInfoData()) + "'");
		values.add("'" + piInfoBean.getLeasCompany().getValue() + "'");
		return values;
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "登録";
	}
}
