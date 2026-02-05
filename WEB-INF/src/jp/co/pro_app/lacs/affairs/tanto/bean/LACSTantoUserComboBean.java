package jp.co.pro_app.lacs.affairs.tanto.bean;

import jp.co.pro_app.projframe.common.bean.SerializableBean;
import jp.co.pro_app.projframe.common.html.ComboArray;

/**
 * リースユーザー担当者マスタ開示先Bean.
 * 
 * @author katoken
 * @version 20090206
 */
public class LACSTantoUserComboBean extends SerializableBean {

	private static final long serialVersionUID = 1L;

	private String		filterString	= "";				// 絞込文字列

	private ComboArray	userList		= new ComboArray(); // 開示先

	/**
	 * コンストラクタ.
	 * 
	 * @param piDefaultCombo
	 *            デフォルト開示先
	 */
	public LACSTantoUserComboBean(ComboArray piDefaultCombo) {
		super();

		this.userList = piDefaultCombo.copy();
	}

	/**
	 * 絞込文字列を取得.
	 * 
	 * @return 絞込文字列
	 */
	public String getFilterString() {
		return this.filterString;
	}

	/**
	 * 絞込文字列を設定.
	 * 
	 * @param piFilterString
	 *            絞込文字列
	 */
	public void setFilterString(String piFilterString) {
		this.filterString = piFilterString;
	}

	/**
	 * 開示先を取得.
	 * 
	 * @return 開示先
	 */
	public ComboArray getUserList() {
		return this.userList;
	}

	/**
	 * 開示先を設定.
	 * 
	 * @param piUserList
	 *            開示先
	 */
	public void setUserList(ComboArray piUserList) {
		this.userList = piUserList;
	}

}
