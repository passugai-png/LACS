package jp.co.pro_app.lacs.affairs.password.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.login.data.entity.LACSCompnayEntity;
import jp.co.pro_app.lacs.affairs.password.bean.LACSPasswordBean;

/**
 * ログイン：ログイン処理.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSPasswordStartModel extends LACSPasswordModelBase {

	/**
	 * セッションチェックフラグ取得.
	 * 
	 * @return セッションチェックを行うか
	 */
	protected boolean checkSession() {
		return true;
	}

	private void getData(LACSPasswordBean piBean) throws SQLException {
		LACSCompnayEntity entity = new LACSCompnayEntity(this);

		try {
			entity.setCon(super.con);

			entity.execSQL();

			if (entity.next()) {
				piBean.setMinLength(entity.getMinLength());
				piBean.setMaxLength(entity.getMaxLength());
				piBean.setAvailableDays(entity.getAvailableDays());
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
	 *                実行例外
	 */
	protected void businessProc(LACSPasswordBean piBean) throws Exception {
		this.getData(piBean);
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
		piBean.setUserId(super.getInput("userId", ""));
	}

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public String getProcSubName() {
		return "表示";
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
	}

}
