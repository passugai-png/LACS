package jp.co.pro_app.lacs.affairs.common.bean;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import jp.co.pro_app.projframe.common.bean.BeanBase;

/**
 * LACS用権限制御Bean.
 * 
 * @author katoken
 * @version 20090121
 */
public class LACSDispControlBean extends BeanBase {

	private static final long serialVersionUID = 1L;

	private Hashtable<String, String>	hash	= new Hashtable<String, String>();

	/**
	 * コンストラクタ.
	 */
	public LACSDispControlBean() {
		super();
		hash.clear();
	}

	/**
	 * クリア.
	 */
	public void clear() {
		hash.clear();
	}

	/**
	 * 権限の追加.
	 * 
	 * @param piControlID
	 *            コントロールコード
	 * @param piControlValue
	 *            設定値
	 */
	public void add(String piControlID, String piControlValue) {
		hash.put(piControlID, piControlValue);
	}

	/**
	 * 権限の取得.
	 * 
	 * @param piControlID
	 *            コントロールコード
	 * @return 設定値
	 */
	public String get(String piControlID) {
		return (String)hash.get(piControlID);
	}

	/**
	 * 利用可否の取得.
	 * 
	 * @param piControlID
	 *            コントロールコード
	 * @return 利用可否
	 */
	public boolean isAvailable(String piControlID) {
		return "1".equals(this.get(piControlID));
	}

	/**
	 * 利用可否の取得.
	 * 
	 * @param piControlID
	 *            コントロールコード
	 * @return 利用可否
	 */
	public boolean isAvailableAny(String[] piControlID) {
		boolean result = false;

		for (int i = 0; i < piControlID.length; i++) {
			result |= this.isAvailable(piControlID[i]);
		}

		return result;
	}

	/**
	 * キーの一覧を取得.
	 * 
	 * @return キーの一覧
	 */
	public String[] getKeys() {
		Enumeration<String> list = this.hash.keys();

		ArrayList<String> array = new ArrayList<String>();

		while (list.hasMoreElements()) {
			array.add(list.nextElement());
		}

		return (String[])array.toArray(new String[0]);
	}
}
