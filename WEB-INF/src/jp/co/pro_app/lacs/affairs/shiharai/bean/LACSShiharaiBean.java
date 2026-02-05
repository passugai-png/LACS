package jp.co.pro_app.lacs.affairs.shiharai.bean;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSViewBeanBase;

/**
 * 支払推移表Bean.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiharaiBean extends LACSViewBeanBase {

	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ.
	 */
	public LACSShiharaiBean() {
		this.setPageServlet("page.shiharai");
		this.per = 12;
	}

	/**
	 * 明細を追加.
	 * 
	 * @param piDetail
	 *            明細
	 */
	public void addDetail(LACSShiharaiDetailBean piDetail) {
		super.add(piDetail);
	}

	/**
	 * 明細を取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 明細
	 */
	public LACSShiharaiDetailBean getDetail(int piIdx) {
		return (LACSShiharaiDetailBean)super.get(piIdx);
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

}
