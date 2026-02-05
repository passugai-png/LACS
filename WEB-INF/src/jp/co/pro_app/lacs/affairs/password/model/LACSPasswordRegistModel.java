package jp.co.pro_app.lacs.affairs.password.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCheckUtlBase;
import jp.co.pro_app.lacs.affairs.common.command.LACSLoginSecurity;
import jp.co.pro_app.lacs.affairs.login.data.entity.LACSUserTantoEntity;
import jp.co.pro_app.lacs.affairs.password.bean.LACSPasswordBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.DateUtl;
import jp.co.pro_app.projframe.common.command.SecurityUtl;
import jp.co.pro_app.projframe.common.dbaccess.MakeSQLUpdateBase;
import jp.co.pro_app.projframe.common.dbaccess.NotSelectExecute;

/**
 * ログイン：ログイン処理.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSPasswordRegistModel extends LACSPasswordModelBase {

	/**
	 * パスワード更新.
	 * 
	 * @param piBean
	 * @throws SQLException
	 */
	private void update(LACSPasswordBean piBean) throws SQLException {
		LACSLoginSecurity security = new LACSLoginSecurity(this, this.con, piBean.getUserId());
		StringBuffer sql = new StringBuffer();
		NotSelectExecute execute = new NotSelectExecute();
		ArrayList<String> items = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		Date dt = new Date();

		dt = DateUtl.add(Calendar.DAY_OF_YEAR, piBean.getAvailableDays(), dt);

		items.add("UPD_DATE");
		items.add("LU_TNT_PASSWD");
		items.add("PASSWD_YUKO_TERM");
		items.add("KRI_PASS_FLG");
		items.add("MISS_CNT");

		values.add("SYSDATE");
		values.add("'" + SecurityUtl.getMD5(piBean.getNewPassword1()) + "'");
		values.add("'" + Convert.toString(dt, Convert.FORMAT_YYYYMMDD) + "'");
		values.add("'0'");
		values.add("0");

		try {
			MakeSQLUpdateBase.makeSQL(sql, "M_LU_TNT", items, values, "LU_ID = '" + Command.changeQt(piBean.getUserId()) + "'");

			execute.setCon(this.con);

			execute.execState(sql.toString());

			security.writePasswordHistory(piBean.getNewPassword1(), 5);
		}
		finally {
			execute.closeState();
		}
	}

	private boolean checkInput(LACSPasswordBean piBean) throws SQLException {
		boolean result = true;

		LACSCheckUtlBase checkUtl = new LACSCheckUtlBase(message);
		LACSUserTantoEntity tantoEntity = new LACSUserTantoEntity(this);
		LACSLoginSecurity security = new LACSLoginSecurity(this, this.con, piBean.getUserId());
		NotSelectExecute exeute = new NotSelectExecute();

		try {
			result &= checkUtl.checkMandatory("ユーザＩＤ", piBean.getUserId());
			result &= checkUtl.checkMandatory("現在のパスワード", piBean.getOldPassword());

			if (piBean.getUserId().trim().length() > 0) {
				tantoEntity.setCon(super.con);
				tantoEntity.setUserId(piBean.getUserId());

				tantoEntity.execSQL();

				if (tantoEntity.next()) {
					if (!tantoEntity.getPassword().equals(SecurityUtl.getMD5(piBean.getOldPassword()))) {
						result &= false;
						this.message.addMessage(LACSDefine.MessageCode.ERROR_DB_DATA_DIFFERENT, "ユーザＩＤと現在のパスワード");
						exeute.setCon(this.con);
						exeute.startTrans();
						exeute.execState("UPDATE M_LU_TNT SET MISS_CNT = MISS_CNT + 1 WHERE LU_ID = '" + Command.changeQt(piBean.getUserId()) + "'");
						exeute.commit();
						exeute.closeState();
					}
					else if (tantoEntity.getStatus().equals("2")) {
						result &= false;
						this.message.addMessage(LACSDefine.MessageCode.ERROR_DB_USER_KARIPW_EXPIRED);
					}
					else if (tantoEntity.getStatus().equals("3")) {
						result &= false;
						this.message.addMessage(LACSDefine.MessageCode.ERROR_DB_USER_LOCKED);
					}
					else if (security.checkLogin()) {
						result &= false;
						this.message.addMessage(LACSDefine.MessageCode.ERROR_DB_USER_LOGGED_IN);
					}
				}
				else {
					result &= false;
					this.message.addMessage(LACSDefine.MessageCode.ERROR_DB_DATA_DIFFERENT, "ユーザＩＤと現在のパスワード");
				}
			}

			result &= checkUtl.checkMandatory("新しいパスワード", piBean.getNewPassword1());		    
			// 20200522 arai 複雑性チェックに変更
			result &= checkUtl.checkComplex("新しいパスワード", piBean.getNewPassword1(), true, true, true);
			result &= checkUtl.checkLength("新しいパスワード", piBean.getNewPassword1(), piBean.getMinLength(), piBean.getMaxLength());

			if (!piBean.getNewPassword1().equals(piBean.getNewPassword2())) {
				result &= false;
				this.message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_FIELD_DIFFERENT, new String[]{ "新しいパスワード", "確認パスワード" });
			}

			if (!security.checkPasswordHistory(piBean.getNewPassword1(), 5)) {
				result &= false;
				this.message.addMessage(LACSDefine.MessageCode.ERROR_DB_USED_PASSWORD);
			}
		}
		finally {
			tantoEntity.close();
		}
		return result;
	}

	/**
	 * セッションチェックフラグ取得.
	 * 
	 * @return セッションチェックを行うか
	 */
	protected boolean checkSession() {
		return true;
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piBean
	 *            支払推移表Bean
	 * @exception Exception
	 *                実行例外
	 */
	protected void businessProc(LACSPasswordBean piBean) throws Exception {
		if (this.checkInput(piBean)) {
			this.update(piBean);
			super.setForwardPath("/back.login");
		}

		this.logWrite(piBean);
		piBean.setMessage(message.getMessage());
	}

	private void logWrite(LACSPasswordBean piBean) throws SQLException {
		LACSUserTantoEntity entity = new LACSUserTantoEntity(this);
		LACSCommonBean commonBean = super.getCommonBean();

		try {
			entity.setCon(super.con);
	
			entity.setUserId(piBean.getUserId());
	
			entity.execSQL();
			if (entity.next()) {
				commonBean.setUserRight(entity.getUserRight());
				commonBean.setTantoName(entity.getTantoName());
			}
		}
		finally {
			entity.close();
		}
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piBean
	 *            支払推移表Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSPasswordBean piBean) throws Exception {
		super.initSub(piBean);
		piBean.setUserId(super.getInput("userId", ""));
		piBean.setOldPassword(super.getInput("oldPassword", ""));
		piBean.setNewPassword1(super.getInput("newPassword1", ""));
		piBean.setNewPassword2(super.getInput("newPassword2", ""));
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
