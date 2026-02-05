package jp.co.pro_app.lacs.affairs.ukebarai.bean;

import java.util.ArrayList;

/**
 * 受払合計表テーブルBean.
 * 
 * @author Katoken
 * @version 20090101
 */
public class LACSUkebaraiTableDetail {

	private ArrayList<Object>	rows		= new ArrayList<Object>();

	private int			rowCount	= 0;

	/**
	 * コンストラクタ.
	 * 
	 * @param piRows
	 *            初期行数
	 */
	public LACSUkebaraiTableDetail(int piRows) {
		rowCount = piRows;
	}

	/**
	 * 行追加.
	 * 
	 * @param piDispZenki
	 *            前期末表示有無 1：表示／0：非表示
	 * @param piDispZouka
	 *            増加表示有無 1：表示／0：非表示
	 * @param piDispTouki
	 *            当期表示有無 1：表示／0：非表示
	 * @param piDispGenshou
	 *            減少表示有無 1：表示／0：非表示
	 * @param piDispKimatsu
	 *            期末表示有無 1：表示／0：非表示
	 * @param piName
	 *            科目名
	 */
	public void add(int piDispZenki, int piDispZouka, int piDispTouki, int piDispGenshou, int piDispKimatsu, String piName) {
		rows.add(new LACSUkebaraiRowBean(piName, piDispZenki == 1, piDispZouka == 1, piDispTouki == 1, piDispGenshou == 1, piDispKimatsu == 1));
	}

	/**
	 * 行を取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 行
	 */
	public LACSUkebaraiRowBean getRow(int piIdx) {
		return (LACSUkebaraiRowBean)rows.get(piIdx);
	}

	/**
	 * 配列化.
	 * 
	 * @param piArray
	 *            格納先配列
	 */
	public void toArray(ArrayList<Object> piArray) {
		if (this.rowCount > 0) {
			for (int i = 0; i < rows.size(); i++) {
				piArray.add(((LACSUkebaraiRowBean)rows.get(i)).convert());
			}
		}
	}
}
