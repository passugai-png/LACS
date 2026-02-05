package jp.co.pro_app.lacs.affairs.common.bean;

import java.util.ArrayList;

import jp.co.pro_app.projframe.common.bean.BeanBase;

/**
 * LACS用お知らせBean.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSInformationBean extends BeanBase {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<String>	infos	= new ArrayList<String>();

	/**
	 * お知らせの行数を取得.
	 * 
	 * @return 行数
	 */
	public int size() {
		return infos.size();
	}

	/**
	 * お知らせ内容を取得.
	 * 
	 * @param piIndex
	 *            番号
	 * @return お知らせ内容
	 */
	public String get(int piIndex) {
		return (String)infos.get(piIndex);
	}

	/**
	 * お知らせ内容を追加.
	 * 
	 * @param piInfo
	 *            お知らせ
	 */
	public void add(String piInfo) {
		infos.add(piInfo);
	}

	/**
	 * お知らせを削除.
	 */
	public void clear() {
		infos.clear();
	}
}
