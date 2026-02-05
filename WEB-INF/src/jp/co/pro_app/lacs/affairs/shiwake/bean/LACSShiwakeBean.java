package jp.co.pro_app.lacs.affairs.shiwake.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSViewBeanBase;

/**
 * 仕訳照会Bean.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiwakeBean extends LACSViewBeanBase {

	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ.
	 */
	public LACSShiwakeBean() {
		this.setPageServlet("page.shiwake");
		this.per = 12;
	}

	/**
	 * 初期化.
	 * 
	 * @param piCommonBean
	 *            LACS共通Bean
	 */
	public void init(LACSCommonBean piCommonBean) {
		super.init(piCommonBean);

		this.per = 12;
	}

	/**
	 * 明細を追加.
	 * 
	 * @param piDetail
	 *            明細
	 */
	public void addDetail(LACSShiwakeMonthBean piDetail) {
		super.add(piDetail);
	}

	/**
	 * 明細を取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 明細
	 */
	public LACSShiwakeMonthBean getDetail(int piIdx) {
		return (LACSShiwakeMonthBean)super.get(piIdx);
	}

}
