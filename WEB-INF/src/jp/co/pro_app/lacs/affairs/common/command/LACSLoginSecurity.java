package jp.co.pro_app.lacs.affairs.common.command;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import jp.co.pro_app.lacs.affairs.common.data.entity.LACSLoginSecurityEntity;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSPasswordHistoryEntity;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.command.SecurityUtl;
import jp.co.pro_app.projframe.common.dbaccess.NotSelectExecute;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * ログインセキュリティクラス.
 * 
 * @author Katoken
 * @version 20080917
 */
public class LACSLoginSecurity {

	private DBModelBase	model	= null;

	private Connection	con		= null;

	private String		userId	= "";

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            DB接続のあるModelスーパークラス
	 * @param piCon
	 *            DB接続
	 * @param piUserId
	 *            ユーザID
	 */
	public LACSLoginSecurity(DBModelBase piModel, Connection piCon, String piUserId) {
		model = piModel;
		con = piCon;
		userId = piUserId;
	}

	/**
	 * ログインチェック.
	 * 
	 * @return ログイン可否
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public boolean checkLogin() throws SQLException {
		return checkLogin("");
	}

	/**
	 * ログインチェック.
	 * 
	 * @param piOneTimePassword
	 *            ワンタイムパスワード
	 * @return ログイン可否
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public boolean checkLogin(String piOneTimePassword) throws SQLException {
		boolean result = false;

		LACSLoginSecurityEntity entity = new LACSLoginSecurityEntity(model);
		Date lastAccessDateTime = null;
		Date saveTime = null;
		int sessionTimeOut = 0;

		try {
			entity.setCon(con);
			entity.setUserId(userId);

			entity.execSQL();

			if (entity.next()) {
				if (piOneTimePassword.trim().length() > 0 && !piOneTimePassword.equals(entity.getOneTimePassword())) {
					return false;
				}

				lastAccessDateTime = entity.getLastAccessDateTime();
				sessionTimeOut = entity.getSessionTimeOut();

				saveTime = DateUtl.add(Calendar.MINUTE, sessionTimeOut, lastAccessDateTime);

				if (new Date().compareTo(saveTime) <= 0) {
					result = true;
				}
			}
		}
		finally {
			entity.close();
		}

		return result;
	}

	/**
	 * 最終アクセス日時の更新.
	 * 
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public void access() throws SQLException {
		NotSelectExecute execute = new NotSelectExecute();

		try {
			execute.setCon(con);

			if (execute.execState("UPDATE T_RQST_CTL_TBL SET LST_ACS_DTM = TO_DATE('" + Convert.toString(new Date(), Convert.FORMAT_YYYY_MM_DD_HH24_MI_SS) + "','YYYY/MM/DD HH24:MI:SS') WHERE LU_ID = '" + userId + "'") == 0) {
				execute.execState("INSERT INTO T_RQST_CTL_TBL(LU_ID, LST_ACS_DTM) VALUES ('" + userId + "', TO_DATE('" + Convert.toString(new Date(), Convert.FORMAT_YYYY_MM_DD_HH24_MI_SS) + "','YYYY/MM/DD HH24:MI:SS'))");
			}
		}
		finally {
			execute.closeState();
		}
	}

	/**
	 * 最終アクセス日時の更新.
	 * 
	 * @param piOneTimePassword
	 *            ワンタイムパスワード
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public void access(String piOneTimePassword) throws SQLException {
		NotSelectExecute execute = new NotSelectExecute();

		try {
			execute.setCon(con);

			if (execute.execState("UPDATE T_RQST_CTL_TBL SET LST_ACS_DTM = TO_DATE('" + Convert.toString(new Date(), Convert.FORMAT_YYYY_MM_DD_HH24_MI_SS) + "','YYYY/MM/DD HH24:MI:SS'), ONE_TIM_PSWD = '" + piOneTimePassword + "' WHERE LU_ID = '" + userId + "'") == 0) {
				execute.execState("INSERT INTO T_RQST_CTL_TBL(LU_ID, LST_ACS_DTM, ONE_TIM_PSWD) VALUES ('" + userId + "', TO_DATE('" + Convert.toString(new Date(), Convert.FORMAT_YYYY_MM_DD_HH24_MI_SS) + "','YYYY/MM/DD HH24:MI:SS'), '" + piOneTimePassword + "')");
			}
		}
		finally {
			execute.closeState();
		}
	}

	/**
	 * 最終アクセス日時の削除.
	 * 
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public void delete() throws SQLException {
		NotSelectExecute execute = new NotSelectExecute();

		try {
			execute.setCon(con);

			execute.execState("DELETE FROM T_RQST_CTL_TBL WHERE LU_ID = '" + userId + "'");
		}
		finally {
			execute.closeState();
		}
	}

	/**
	 * パスワード履歴チェック.
	 * 
	 * @param piPassword
	 *            パスワード
	 * @param piCheckDepth
	 *            過去回数
	 * @return チェック結果[true:使用化/false:使用不可]
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public boolean checkPasswordHistory(String piPassword, int piCheckDepth) throws SQLException {
		LACSPasswordHistoryEntity entity = new LACSPasswordHistoryEntity(model);
		boolean result = true;
		int depth = 0;
		String password = SecurityUtl.getMD5(piPassword);

		try {
			entity.setCon(con);
			entity.setUserId(userId);
			entity.execSQL();

			while (entity.next()) {
				if (entity.getPassword().equals(password)) {
					result = false;
					break;
				}

				if (++depth >= piCheckDepth) {
					break;
				}
			}

		}
		finally {
			entity.close();
		}

		return result;
	}

	/**
	 * パスワード履歴更新.
	 * 
	 * @param piPassword
	 *            パスワード
	 * @param piCheckDepth
	 *            保存回数
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public void writePasswordHistory(String piPassword, int piCheckDepth) throws SQLException {
		LACSPasswordHistoryEntity entity = new LACSPasswordHistoryEntity(model);
		NotSelectExecute execute = new NotSelectExecute();
		int depth = 0;
		String changeTime = "";
		String password = SecurityUtl.getMD5(piPassword);

		try {
			execute.setCon(con);
			execute.execState("INSERT INTO T_LU_PASSWORD_RRK (LU_ID, CHG_DTM, LU_PASSWD)VALUES ('" + Command.changeQt(userId) + "', '" + Convert.toString(new Date(), Convert.FORMAT_YYYYMMDDHHMMSSMMM) + "', '" + password + "') ");

			entity.setCon(con);
			entity.setUserId(userId);
			entity.execSQL();

			while (entity.next()) {
				changeTime = entity.getChangeTime();

				if (++depth >= piCheckDepth) {
					break;
				}
			}

			execute.execState("DELETE FROM T_LU_PASSWORD_RRK WHERE LU_ID = '" + Command.changeQt(userId) + "' AND CHG_DTM < '" + changeTime + "'");
		}
		finally {
			entity.close();
			execute.closeState();
		}
	}
}
