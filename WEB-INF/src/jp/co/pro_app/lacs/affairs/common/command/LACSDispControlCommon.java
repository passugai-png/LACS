package jp.co.pro_app.lacs.affairs.common.command;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.co.pro_app.lacs.affairs.common.bean.LACSDispControlBean;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSDispControlEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.dbaccess.SelectEx;

/**
 * LACS用権限制御共通部品.
 * 
 * @author katoken
 * @version 20090121
 */
public class LACSDispControlCommon {

	private LACSDispControlBean	dispControlBean;

	private LACSModelBase		model;

	private Connection			con	= null;

	/**
	 * コンストラクタ.
	 * 
	 * @param piDispControlBean
	 *            LACS用権限制御Bean
	 * @param piModel
	 *            LACSModelスーパークラス
	 * @param piCon
	 *            DB接続
	 */
	public LACSDispControlCommon(LACSDispControlBean piDispControlBean, LACSModelBase piModel, Connection piCon) {
		this.dispControlBean = piDispControlBean;
		this.model = piModel;
		this.con = piCon;

	}

	/**
	 * DB設定値取得.
	 * 
	 * @param piUserID
	 *            ユーザーID
	 * @param piAdminMode
	 *            管理者モード
	 * @return 取得件数
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public int getDBDispControl(String piUserID, int piAdminMode) throws SQLException {
		LACSDispControlEntity dispControlEntity = new LACSDispControlEntity(this.model);
		int cnt = 0;

		try {
			dispControlEntity.setCosmosCode(piUserID);
			dispControlEntity.setAdminMode(piAdminMode);

			dispControlEntity.setCon(this.con);
			dispControlEntity.execSQL();

			while (dispControlEntity.next()) {
				dispControlBean.add(dispControlEntity.getControlID(), dispControlEntity.getControlValue());
				cnt++;
			}
		}
		finally {
			dispControlEntity.close();
		}

		return cnt;
	}

	/**
	 * 画面設定値取得.
	 */
	public void getInputDispControl() {
		String[] keys = dispControlBean.getKeys();

		for (int i = 0; i < keys.length; i++) {
			dispControlBean.add(keys[i], model.getInput("chk" + keys[i], "0"));
		}
	}

	/**
	 * 更新用SQL取得.
	 * 
	 * @param piUserID
	 *            ユーザーID
	 * @throws SQLException
	 *             SQL実行例外
	 * @return SQL
	 */
	public ArrayList<String> getSQLDispControl(String piUserID) throws SQLException {
		String[] keys = dispControlBean.getKeys();
		ArrayList<String> array = new ArrayList<String>();

		SelectEx selectEx = new SelectEx(this.con);
		String where = "";

		for (int i = 0; i < keys.length; i++) {
			where = "LU_COSMOS_CD = '" + Command.changeQt(piUserID) + "' AND CTRL_ID = '" + Command.changeQt(keys[i]) + "'";

			if (selectEx.getRecordCount("M_DSP_CTRL", where) == 0) {
				array.add("INSERT INTO M_DSP_CTRL (LU_COSMOS_CD, CTRL_ID, ENT_DATE, ENT_USR, UPD_DATE, UPD_USR, CTRL_VALUE) VALUES ('" + Command.changeQt(piUserID) + "','" + Command.changeQt(keys[i]) + "', SYSDATE, 'LACS', SYSDATE, 'LACS', '" + model.getInput("chk" + keys[i], "0") + "')");
			}
			else {
				array.add("UPDATE M_DSP_CTRL SET CTRL_VALUE = '" + model.getInput("chk" + keys[i], "0") + "', UPD_DATE = SYSDATE, UPD_USR = 'LACS' WHERE " + where);
			}
		}

		return array;
	}

	/**
	 * 入力チェック.
	 * 
	 * @param piControlBean
	 *            LACS用権限制御Bean
	 * @param piMessage
	 *            メッセージ
	 * @return チェック結果
	 */
	public boolean checkInputRealation(LACSDispControlBean piControlBean, LACSMessage piMessage) {
		boolean result = true;

		if (!piControlBean.isAvailableAny(new String[]{ "G0000001", "G0000002", "G0000003", "G0000004", "G0000005", "G0000006", "G0000007" })) {
			piMessage.addMessage(LACSDefine.MessageCode.ERROR_RELATE_NO_AVAILABLE_FUNCTION);
			result = false;
		}
		
		// 20200528　 チェック処理に期日別予定表を追加 arai
		if (piControlBean.isAvailable("G0000005") && !piControlBean.isAvailableAny(new String[]{ "P0000005", "P0000004", "P0000001", "P0000002", "P0000003", "P0000006", "P0000032","P0000033","P0000034" })) {
			piMessage.addMessage(LACSDefine.MessageCode.ERROR_RELATE_NO_AVAILABLE_REPORT, "注記帳票出力");
			result = false;
		}

		if (piControlBean.isAvailable("G0000006") && !piControlBean.isAvailableAny(new String[]{ "P0000011", "P0000012", "P0000013", "P0000016", "P0000015", "P0000014" })) {
			piMessage.addMessage(LACSDefine.MessageCode.ERROR_RELATE_NO_AVAILABLE_REPORT, "月次帳票出力");
			result = false;
		}

		return result;
	}
}
