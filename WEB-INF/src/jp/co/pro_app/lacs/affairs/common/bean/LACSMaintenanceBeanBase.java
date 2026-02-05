package jp.co.pro_app.lacs.affairs.common.bean;

/**
 * メンテナンス系Beanスーパークラス.
 * 
 * @author katoken
 * @version 20071218
 */
public abstract class LACSMaintenanceBeanBase extends LACSBeanBase {

	private static final long serialVersionUID = 1L;
	
	private int	procMode	= 0;	// 処理モード 1：新規作成 2：修正

	/**
	 * 処理モードを取得.
	 * 
	 * @return 処理モード
	 */
	public int getProcMode() {
		return this.procMode;
	}

	/**
	 * 処理モードを設定.
	 * 
	 * @param piProcMode
	 *            処理モード
	 */
	public void setProcMode(int piProcMode) {
		this.procMode = piProcMode;
	}
}
