package jp.co.pro_app.lacs.affairs.tanto.bean;

import java.util.ArrayList;

import jp.co.pro_app.projframe.common.bean.SerializableBean;
import jp.co.pro_app.projframe.common.html.ComboArray;

/**
 * リースユーザー担当者マスタ開示先管理クラス.
 * 
 * @author katoken
 * @version 20090206
 */
public class LACSTantoUserManageBean extends SerializableBean {

	private static final long serialVersionUID = 1L;

	private ArrayList<LACSTantoUserComboBean>	list	= new ArrayList<LACSTantoUserComboBean>();

	private ComboArray	defaultCombo	= null;

	/**
	 * コンストラクタ.
	 * 
	 * @param piDefaultCombo
	 *            デフォルト開示先.
	 */
	public LACSTantoUserManageBean(ComboArray piDefaultCombo) {
		super();
		this.defaultCombo = piDefaultCombo.copy();
	}

	/**
	 * 初期化.
	 * 
	 * @param piCount
	 *            初期開示先数.
	 */
	public void init(int piCount) {
		LACSTantoUserComboBean user = null;
		for (int i = 0; i < piCount; i++) {
			user = new LACSTantoUserComboBean(this.defaultCombo);
			user.getUserList().setSelectedFalse();
			list.add(user);
		}
	}

	/**
	 * 開示先取得.
	 * 
	 * @param piIdx
	 *            開示先番号
	 * @return 開示先
	 */
	public LACSTantoUserComboBean get(int piIdx) {
		return (LACSTantoUserComboBean)list.get(piIdx);
	}

	/**
	 * 開示先追加.
	 * 
	 * @param piCosmosCode
	 *            選択済み開示先コード
	 */
	public void add(String piCosmosCode) {
		LACSTantoUserComboBean detail = new LACSTantoUserComboBean(this.defaultCombo);

		detail.getUserList().setSelectedValue(piCosmosCode);

		list.add(detail);
	}

	/**
	 * 初期化.
	 */
	public void clear() {
		list.clear();
	}

	/**
	 * 開示先数取得.
	 * 
	 * @return 開示先数
	 */
	public int size() {
		return list.size();
	}
}
