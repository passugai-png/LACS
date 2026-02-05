package jp.co.pro_app.lacs.affairs.common.html;

import java.util.ArrayList;

/**
 * メニュー行データ.
 * 
 * @author katoken
 * @version 20071205
 */
public class LACSMenuDataLine {

	private ArrayList<LACSMenuDataLineDetail>	list		= new ArrayList<LACSMenuDataLineDetail>();

	private boolean		showButton	= true;

	/**
	 * メニュー詳細データ数を取得.
	 * 
	 * @return メニュー詳細データ数
	 */
	public int size() {
		return list.size();
	}

	/**
	 * コンストラクタ.
	 * 
	 * @param piShowButton
	 *            ボタン表示非表示
	 */
	public LACSMenuDataLine(boolean piShowButton) {
		this.showButton = piShowButton;
	}

	/**
	 * メニュー詳細データを追加.
	 * 
	 * @param piDetail
	 *            メニュー詳細データ
	 */
	public void add(LACSMenuDataLineDetail piDetail) {
		list.add(piDetail);
	}

	/**
	 * メニュー詳細データを取得.
	 * 
	 * @param piIdx
	 *            要素番号
	 * @return メニュー詳細データ
	 */
	public LACSMenuDataLineDetail get(int piIdx) {
		return (LACSMenuDataLineDetail)list.get(piIdx);
	}

	/**
	 * ボタン表示非表示を取得.
	 * 
	 * @return ボタン表示非表示
	 */
	public boolean isShowButton() {
		return this.showButton;
	}
}
