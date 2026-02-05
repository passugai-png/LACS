package jp.co.pro_app.lacs.affairs.ukebarai.bean;

import java.util.ArrayList;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSDateBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSReportDetailBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSViewBeanBase;

/**
 * 受払合計表Bean.
 * 
 * @author active
 * @version 20080808
 */
public class LACSUkebaraiBean extends LACSViewBeanBase {

	private static final long serialVersionUID = 1L;

	private String					lcName					= "";							// リース会社

	private String					leaseUserNm				= "";							// リースユーザー名(開示先)

	private String					leaseTrhkBunrui			= "";							// リース取引分類

	private String					leaseTrhkBunruiNm		= "";							// リース取引分類名

	private String					tsukiSu					= "";							// 月数

	private ArrayList<Object>		ukebaraiDetailList		= new ArrayList<Object>();		// 明細

	private LACSReportDetailBean	gokei					= new LACSReportDetailBean();	// 受払合計表

	private LACSReportDetailBean	sisan					= new LACSReportDetailBean();	// リース資産受払明細表

	private LACSReportDetailBean	lease					= new LACSReportDetailBean();	// リース料受払明細表

	private LACSReportDetailBean	hiyo					= new LACSReportDetailBean();	// 費用受払明細表

	// 2020/05/22 REP START
	//private ArrayList<Object>		newBaibaiItengaiList	= new ArrayList<Object>();		// 新会計基準：売買処理：所有権移転外ファイナンスリース

	//private ArrayList<Object>		newBaibaiItenList		= new ArrayList<Object>();		// 新会計基準：売買処理：所有権移転ファイナンスリース

	//private ArrayList<Object>		newOperateList			= new ArrayList<Object>();		// 新会計基準：オペレーティングリース

	//private ArrayList<Object>		oldBaibaiItengaiList	= new ArrayList<Object>();		// 旧会計基準：売買処理：所有権移転外ファイナンスリース

	//private ArrayList<Object>		oldBaibaiItenList		= new ArrayList<Object>();		// 旧会計基準：売買処理：所有権移転ファイナンスリース

	//private ArrayList<Object>		oldOperateList			= new ArrayList<Object>();		// 旧会計基準：オペレーティングリース

	//private ArrayList<Object>		newTintaiItengaiList	= new ArrayList<Object>();		// 新会計基準：賃貸借処理：所有権移転外ファイナンスリース

	//private ArrayList<Object>		newTintaiItenList		= new ArrayList<Object>();		// 新会計基準：賃貸借処理：所有権移転ファイナンスリース

	//private ArrayList<Object>		oldTintaiItengaiList	= new ArrayList<Object>();		// 旧会計基準：賃貸借処理：所有権移転外ファイナンスリース

	//private ArrayList<Object>		oldTintaiItenList		= new ArrayList<Object>();		// 旧会計基準：賃貸借処理：所有権移転ファイナンスリース


	
	private ArrayList<Object>		JyNnewBaibaiItengaiList	= new ArrayList<Object>();		// 重要性無:新会計基準：売買処理：所有権移転外ファイナンスリース

	private ArrayList<Object>		JyNnewBaibaiItenList	= new ArrayList<Object>();		// 重要性無:新会計基準：売買処理：所有権移転ファイナンスリース

	private ArrayList<Object>		JyNnewOperateList		= new ArrayList<Object>();		// 重要性無:新会計基準：オペレーティングリース

	private ArrayList<Object>		JyNoldBaibaiItengaiList	= new ArrayList<Object>();		// 重要性無:旧会計基準：売買処理：所有権移転外ファイナンスリース

	private ArrayList<Object>		JyNoldBaibaiItenList	= new ArrayList<Object>();		// 重要性無:旧会計基準：売買処理：所有権移転ファイナンスリース

	private ArrayList<Object>		JyNoldOperateList		= new ArrayList<Object>();		// 重要性無:旧会計基準：オペレーティングリース

	private ArrayList<Object>		JyNnewTintaiItengaiList	= new ArrayList<Object>();		// 重要性無:新会計基準：賃貸借処理：所有権移転外ファイナンスリース

	private ArrayList<Object>		JyNnewTintaiItenList	= new ArrayList<Object>();		// 重要性無:新会計基準：賃貸借処理：所有権移転ファイナンスリース

	private ArrayList<Object>		JyNoldTintaiItengaiList	= new ArrayList<Object>();		// 重要性無:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース

	private ArrayList<Object>		JyNoldTintaiItenList	= new ArrayList<Object>();		// 重要性無:旧会計基準：賃貸借処理：所有権移転ファイナンスリース

	
	private ArrayList<Object>		JyAnewBaibaiItengaiList	= new ArrayList<Object>();		// 重要性有:新会計基準：売買処理：所有権移転外ファイナンスリース

	private ArrayList<Object>		JyAnewBaibaiItenList	= new ArrayList<Object>();		// 重要性有:新会計基準：売買処理：所有権移転ファイナンスリース

	private ArrayList<Object>		JyAnewOperateList		= new ArrayList<Object>();		// 重要性有:新会計基準：オペレーティングリース

	private ArrayList<Object>		JyAoldBaibaiItengaiList	= new ArrayList<Object>();		// 重要性有:旧会計基準：売買処理：所有権移転外ファイナンスリース

	private ArrayList<Object>		JyAoldBaibaiItenList	= new ArrayList<Object>();		// 重要性有:旧会計基準：売買処理：所有権移転ファイナンスリース

	private ArrayList<Object>		JyAoldOperateList		= new ArrayList<Object>();		// 重要性有:旧会計基準：オペレーティングリース

	private ArrayList<Object>		JyAnewTintaiItengaiList	= new ArrayList<Object>();		// 重要性有:新会計基準：賃貸借処理：所有権移転外ファイナンスリース

	private ArrayList<Object>		JyAnewTintaiItenList	= new ArrayList<Object>();		// 重要性有:新会計基準：賃貸借処理：所有権移転ファイナンスリース

	private ArrayList<Object>		JyAoldTintaiItengaiList	= new ArrayList<Object>();		// 重要性有:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース

	private ArrayList<Object>		JyAoldTintaiItenList	= new ArrayList<Object>();		// 重要性有:旧会計基準：賃貸借処理：所有権移転ファイナンスリース
	// 2020/05/22 REP END

	private String					leasCompanyUkebarai		= "";							// リース会社受払定義マスタ用

	// 2020/05/22 REP START
	//private String					newBaibaiItengaiFlg		= "";							// 新会計基準：売買処理：所有権移転外ファイナンスリース

	//private String					newBaibaiItenFlg		= "";							// 新会計基準：売買処理：所有権移転ファイナンスリース

	//private String					newOperateFlg			= "";							// 新会計基準：オペレーティングリース

	//private String					oldBaibaiItengaiFlg		= "";							// 旧会計基準：売買処理：所有権移転外ファイナンスリース

	//private String					oldBaibaiItenFlg		= "";							// 旧会計基準：売買処理：所有権移転ファイナンスリース

	//private String					oldOperateFlg			= "";							// 旧会計基準：オペレーティングリース

	//private String					newTintaiItengaiFlg		= "";							// 新会計基準：賃貸借処理：所有権移転外ファイナンスリース

	//private String					newTintaiItenFlg		= "";							// 新会計基準：賃貸借処理：所有権移転ファイナンスリース

	//private String					oldTintaiItengaiFlg		= "";							// 旧会計基準：賃貸借処理：所有権移転外ファイナンスリース

	//private String					oldTintaiItenFlg		= "";							// 旧会計基準：賃貸借処理：所有権移転ファイナンスリース

	//
	private String					JyNnewBaibaiItengaiFlg	= "";							// 重要性無:新会計基準：売買処理：所有権移転外ファイナンスリース

	private String					JyNnewBaibaiItenFlg		= "";							// 重要性無:新会計基準：売買処理：所有権移転ファイナンスリース

	private String					JyNnewOperateFlg		= "";							// 重要性無:新会計基準：オペレーティングリース

	private String					JyNoldBaibaiItengaiFlg	= "";							// 重要性無:旧会計基準：売買処理：所有権移転外ファイナンスリース

	private String					JyNoldBaibaiItenFlg		= "";							// 重要性無:旧会計基準：売買処理：所有権移転ファイナンスリース

	private String					JyNoldOperateFlg		= "";							// 重要性無:旧会計基準：オペレーティングリース

	private String					JyNnewTintaiItengaiFlg	= "";							// 重要性無:新会計基準：賃貸借処理：所有権移転外ファイナンスリース

	private String					JyNnewTintaiItenFlg		= "";							// 重要性無:新会計基準：賃貸借処理：所有権移転ファイナンスリース

	private String					JyNoldTintaiItengaiFlg	= "";							// 重要性無:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース

	private String					JyNoldTintaiItenFlg		= "";							// 重要性無:旧会計基準：賃貸借処理：所有権移転ファイナンスリース

	//
	private String					JyAnewBaibaiItengaiFlg	= "";							// 重要性有:新会計基準：売買処理：所有権移転外ファイナンスリース

	private String					JyAnewBaibaiItenFlg		= "";							// 重要性有:新会計基準：売買処理：所有権移転ファイナンスリース

	private String					JyAnewOperateFlg		= "";							// 重要性有:新会計基準：オペレーティングリース

	private String					JyAoldBaibaiItengaiFlg	= "";							// 重要性有:旧会計基準：売買処理：所有権移転外ファイナンスリース

	private String					JyAoldBaibaiItenFlg		= "";							// 重要性有:旧会計基準：売買処理：所有権移転ファイナンスリース

	private String					JyAoldOperateFlg		= "";							// 重要性有:旧会計基準：オペレーティングリース

	private String					JyAnewTintaiItengaiFlg	= "";							// 重要性有:新会計基準：賃貸借処理：所有権移転外ファイナンスリース

	private String					JyAnewTintaiItenFlg		= "";							// 重要性有:新会計基準：賃貸借処理：所有権移転ファイナンスリース

	private String					JyAoldTintaiItengaiFlg	= "";							// 重要性有:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース

	private String					JyAoldTintaiItenFlg		= "";							// 重要性有:旧会計基準：賃貸借処理：所有権移転ファイナンスリース
// 2020/05/22 REP END

	private int						nextFocus				= 0;							// 次のフォーカス

	/**
	 * 初期化.
	 * 
	 * @param piCommonBean
	 *            LACS共通Bean
	 */
	public void init(LACSCommonBean piCommonBean) {
		super.init(piCommonBean);

		this.getTermTo().setPlane(true);
		this.tsukiSu = "1";

		gokei.init(0);
		sisan.init(0);
		lease.init(0);
		hiyo.init(0);
	}

	/**
	 * 明細行初期化.
	 * 
	 * @param piCommonBean
	 *            LACS共通Bean
	 */
	public void initsub(LACSCommonBean piCommonBean) {
		super.termFrom = new LACSDateBean(piCommonBean);
		super.termFrom.setName("termFrom");
		super.termFrom.setOnChange("focusNextU(this)");
		super.showList = false;
	}

	/**
	 * リース取引分類を取得.
	 * 
	 * @return リース取引分類
	 */
	public String getLeaseTrhkBunrui() {
		return this.leaseTrhkBunrui;
	}

	/**
	 * リース取引分類を設定.
	 * 
	 * @param piLeaseTrhkBunrui
	 *            リース取引分類
	 */
	public void setLeaseTrhkBunrui(String piLeaseTrhkBunrui) {
		this.leaseTrhkBunrui = piLeaseTrhkBunrui;
	}

	/**
	 * リース取引分類名を取得.
	 * 
	 * @return リース取引分類名
	 */
	public String getLeaseTrhkBunruiNm() {
		return this.leaseTrhkBunruiNm;
	}

	/**
	 * リース取引分類名を設定.
	 * 
	 * @param piLeaseTrhkBunruiNm
	 *            リース取引分類名
	 */
	public void setLeaseTrhkBunruiNm(String piLeaseTrhkBunruiNm) {
		this.leaseTrhkBunruiNm = piLeaseTrhkBunruiNm;
	}

	/**
	 * 月数を取得.
	 * 
	 * @return 月数
	 */
	public String getTsukiSu() {
		return this.tsukiSu;
	}

	/**
	 * 月数を設定.
	 * 
	 * @param piTsukiSu
	 *            月数
	 */
	public void setTsukiSu(String piTsukiSu) {
		this.tsukiSu = piTsukiSu;
	}

	/**
	 * 明細を取得.
	 * 
	 * @return 明細
	 */
	public ArrayList<Object> getUkebaraiDetailList() {
		return this.ukebaraiDetailList;
	}

	/**
	 * 明細を設定.
	 * 
	 * @param piUkebaraiDetailList
	 *            明細
	 */
	public void setUkebaraiDetailList(ArrayList<Object> piUkebaraiDetailList) {
		this.ukebaraiDetailList = piUkebaraiDetailList;
	}

	/**
	 * リースユーザー名(開示先)を取得.
	 * 
	 * @return リースユーザー名(開示先)
	 */
	public String getLeaseUserNm() {
		return this.leaseUserNm;
	}

	/**
	 * リースユーザー名(開示先)を設定.
	 * 
	 * @param piLeaseUserNm
	 *            リースユーザー名(開示先)
	 */
	public void setLeaseUserNm(String piLeaseUserNm) {
		this.leaseUserNm = piLeaseUserNm;
	}

	/**
	 * リース会社を取得.
	 * 
	 * @return リース会社
	 */
	public String getLcName() {
		return this.lcName;
	}

	/**
	 * リース会社を設定.
	 * 
	 * @param piLcName
	 *            リース会社
	 */
	public void setLcName(String piLcName) {
		this.lcName = piLcName;
	}

	// 2020/05/22 DEL START
	/**
	 * 新会計基準：売買処理：所有権移転外ファイナンスリース格納リストを取得.
	 * 
	 * @return 新会計基準：売買処理：所有権移転外ファイナンスリース格納リスト
	 */
	//public ArrayList<Object> getNewBaibaiItengaiList() {
	//	return this.newBaibaiItengaiList;
	//}

	/**
	 * 新会計基準：売買処理：所有権移転外ファイナンスリース格納リストを設定.
	 * 
	 * @param piNewBaibaiItengaiList
	 *            新会計基準：売買処理：所有権移転外ファイナンスリース格納リスト
	 */
	//public void setNewBaibaiItengaiList(ArrayList<Object> piNewBaibaiItengaiList) {
	//	this.newBaibaiItengaiList = piNewBaibaiItengaiList;
	//}

	/**
	 * 新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リストを取得.
	 * 
	 * @return 新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リスト
	 */
	//public ArrayList<Object> getNewTintaiItengaiList() {
	//	return this.newTintaiItengaiList;
	//}

	/**
	 * 新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リストを設定.
	 * 
	 * @param piNewTintaiItengaiList
	 *            新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リスト
	 */
	//public void setNewTintaiItengaiList(ArrayList<Object> piNewTintaiItengaiList) {
	//	this.newTintaiItengaiList = piNewTintaiItengaiList;
	//}

	/**
	 * 新会計基準：売買処理：所有権移転ファイナンスリース格納リストを取得.
	 * 
	 * @return 新会計基準：売買処理：所有権移転ファイナンスリース格納リスト
	 */
	//public ArrayList<Object> getNewBaibaiItenList() {
	//	return this.newBaibaiItenList;
	//}

	/**
	 * 新会計基準：売買処理：所有権移転ファイナンスリース格納リストを設定.
	 * 
	 * @param piNewBaibaiItenList
	 *            新会計基準：売買処理：所有権移転ファイナンスリース格納リスト
	 */
	//public void setNewBaibaiItenList(ArrayList<Object> piNewBaibaiItenList) {
	//	this.newBaibaiItenList = piNewBaibaiItenList;
	//}

	/**
	 * 新会計基準：賃貸借処理：所有権移転ファイナンスリース格納リストを取得.
	 * 
	 * @return 新会計基準：賃貸借処理：所有権移転ファイナンスリース格納リスト
	 */
	//public ArrayList<Object> getNewTintaiItenList() {
	//	return this.newTintaiItenList;
	//}

	/**
	 * 新会計基準：賃貸借処理：所有権移転ファイナンスリース格納リストを設定.
	 * 
	 * @param piNewTintaiItenList
	 *            新会計基準：賃貸借処理：所有権移転ファイナンスリース格納リスト
	 */
	//public void setNewTintaiItenList(ArrayList<Object> piNewTintaiItenList) {
	//	this.newTintaiItenList = piNewTintaiItenList;
	//}

	/**
	 * 新会計基準：オペレーティングリース格納リストを取得.
	 * 
	 * @return 新会計基準：オペレーティングリース格納リスト
	 */
	//public ArrayList<Object> getNewOperateList() {
	//	return this.newOperateList;
	//}

	/**
	 * 新会計基準：オペレーティングリース格納リストを設定.
	 * 
	 * @param piNewOperateList
	 *            新会計基準：オペレーティングリース格納リスト
	 */
	//public void setNewOperateList(ArrayList<Object> piNewOperateList) {
	//	this.newOperateList = piNewOperateList;
	//}

	/**
	 * 旧会計基準：売買処理：所有権移転外ファイナンスリース格納リストを取得.
	 * 
	 * @return 旧会計基準：売買処理：所有権移転外ファイナンスリース格納リスト
	 */
	//public ArrayList<Object> getOldBaibaiItengaiList() {
	//	return this.oldBaibaiItengaiList;
	//}

	/**
	 * 旧会計基準：売買処理：所有権移転外ファイナンスリース格納リストを設定.
	 * 
	 * @param piOldBaibaiItengaiList
	 *            旧会計基準：売買処理：所有権移転外ファイナンスリース格納リスト
	 */
	//public void setOldBaibaiItengaiList(ArrayList<Object> piOldBaibaiItengaiList) {
	//	this.oldBaibaiItengaiList = piOldBaibaiItengaiList;
	//}

	/**
	 * 旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リストを取得.
	 * 
	 * @return 旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リスト
	 */
	//public ArrayList<Object> getOldTintaiItengaiList() {
	//	return this.oldTintaiItengaiList;
	//}

	/**
	 * 旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リストを設定.
	 * 
	 * @param piOldTintaiItengaiList
	 *            旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リスト
	 */
	//public void setOldTintaiItengaiList(ArrayList<Object> piOldTintaiItengaiList) {
	//	this.oldTintaiItengaiList = piOldTintaiItengaiList;
	//}

	/**
	 * 旧会計基準：売買処理：所有権移転ファイナンスリース格納リストを取得.
	 * 
	 * @return 旧会計基準：売買処理：所有権移転ファイナンスリース格納リスト
	 */
	//public ArrayList<Object> getOldBaibaiItenList() {
	//	return this.oldBaibaiItenList;
	//}

	/**
	 * 旧会計基準：売買処理：所有権移転ファイナンスリース格納リストを設定.
	 * 
	 * @param piOldBaibaiItenList
	 *            旧会計基準：売買処理：所有権移転ファイナンスリース格納リスト
	 */
	//public void setOldBaibaiItenList(ArrayList<Object> piOldBaibaiItenList) {
	//	this.oldBaibaiItenList = piOldBaibaiItenList;
	//}

	/**
	 * 旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納リストを取得.
	 * 
	 * @return 旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納リスト
	 */
	//public ArrayList<Object> getOldTintaiItenList() {
	//	return this.oldTintaiItenList;
	//}

	/**
	 * 旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納リストを設定.
	 * 
	 * @param piOldTintaiItenList
	 *            旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納リスト
	 */
	//public void setOldTintaiItenList(ArrayList<Object> piOldTintaiItenList) {
	//	this.oldTintaiItenList = piOldTintaiItenList;
	//}

	/**
	 * 旧会計基準：オペレーティングリース格納リストを取得.
	 * 
	 * @return 旧会計基準：オペレーティングリース格納リスト
	 */
	//public ArrayList<Object> getOldOperateList() {
	//	return this.oldOperateList;
	//}

	/**
	 * 旧会計基準：オペレーティングリース格納リストを設定.
	 * 
	 * @param piOldOperateList
	 *            旧会計基準：オペレーティングリース格納リスト
	 */
	//public void setOldOperateList(ArrayList<Object> piOldOperateList) {
	//	this.oldOperateList = piOldOperateList;
	//}
	// 2020/05/22 DEL END

	//--------------------------------------------------------------------------------//
	// 2020/05/22 ADD START
	/**
	 * 重要性無:新会計基準：売買処理：所有権移転外ファイナンスリース格納リストを取得.
	 * 
	 * @return 重要性無:新会計基準：売買処理：所有権移転外ファイナンスリース格納リスト
	 */
	public ArrayList<Object> getJyNNewBaibaiItengaiList() {
		return this.JyNnewBaibaiItengaiList;
	}

	/**
	 * 重要性無:新会計基準：売買処理：所有権移転外ファイナンスリース格納リストを設定.
	 * 
	 * @param piJyNNewBaibaiItengaiList
	 *            重要性無:新会計基準：売買処理：所有権移転外ファイナンスリース格納リスト
	 */
	public void setJyNNewBaibaiItengaiList(ArrayList<Object> piJyNNewBaibaiItengaiList) {
		this.JyNnewBaibaiItengaiList = piJyNNewBaibaiItengaiList;
	}

	/**
	 * 重要性無:新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リストを取得.
	 * 
	 * @return 重要性無:新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リスト
	 */
	public ArrayList<Object> getJyNNewTintaiItengaiList() {
		return this.JyNnewTintaiItengaiList;
	}

	/**
	 * 重要性無:新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リストを設定.
	 * 
	 * @param piJyNNewTintaiItengaiList
	 *            重要性無:新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リスト
	 */
	public void setJyNNewTintaiItengaiList(ArrayList<Object> piJyNNewTintaiItengaiList) {
		this.JyNnewTintaiItengaiList = piJyNNewTintaiItengaiList;
	}

	/**
	 * 重要性無:新会計基準：売買処理：所有権移転ファイナンスリース格納リストを取得.
	 * 
	 * @return 重要性無:新会計基準：売買処理：所有権移転ファイナンスリース格納リスト
	 */
	public ArrayList<Object> getJyNNewBaibaiItenList() {
		return this.JyNnewBaibaiItenList;
	}

	/**
	 * 重要性無:新会計基準：売買処理：所有権移転ファイナンスリース格納リストを設定.
	 * 
	 * @param piJyNNewBaibaiItenList
	 *            重要性無:新会計基準：売買処理：所有権移転ファイナンスリース格納リスト
	 */
	public void setJyNNewBaibaiItenList(ArrayList<Object> piJyNNewBaibaiItenList) {
		this.JyNnewBaibaiItenList = piJyNNewBaibaiItenList;
	}

	/**
	 * 重要性無:新会計基準：賃貸借処理：所有権移転ファイナンスリース格納リストを取得.
	 * 
	 * @return 重要性無:新会計基準：賃貸借処理：所有権移転ファイナンスリース格納リスト
	 */
	public ArrayList<Object> getJyNNewTintaiItenList() {
		return this.JyNnewTintaiItenList;
	}

	/**
	 * 重要性無:新会計基準：賃貸借処理：所有権移転ファイナンスリース格納リストを設定.
	 * 
	 * @param piJyNNewTintaiItenList
	 *            重要性無:新会計基準：賃貸借処理：所有権移転ファイナンスリース格納リスト
	 */
	public void setJyNNewTintaiItenList(ArrayList<Object> piJyNNewTintaiItenList) {
		this.JyNnewTintaiItenList = piJyNNewTintaiItenList;
	}

	/**
	 * 重要性無:新会計基準：オペレーティングリース格納リストを取得.
	 * 
	 * @return 重要性無:新会計基準：オペレーティングリース格納リスト
	 */
	public ArrayList<Object> getJyNNewOperateList() {
		return this.JyNnewOperateList;
	}

	/**
	 * 重要性無:新会計基準：オペレーティングリース格納リストを設定.
	 * 
	 * @param piJyNNewOperateList
	 *            重要性無:新会計基準：オペレーティングリース格納リスト
	 */
	public void setJyNNewOperateList(ArrayList<Object> piJyNNewOperateList) {
		this.JyNnewOperateList = piJyNNewOperateList;
	}

	/**
	 * 重要性無:旧会計基準：売買処理：所有権移転外ファイナンスリース格納リストを取得.
	 * 
	 * @return 重要性無:旧会計基準：売買処理：所有権移転外ファイナンスリース格納リスト
	 */
	public ArrayList<Object> getJyNOldBaibaiItengaiList() {
		return this.JyNoldBaibaiItengaiList;
	}

	/**
	 * 重要性無:旧会計基準：売買処理：所有権移転外ファイナンスリース格納リストを設定.
	 * 
	 * @param piJyNOldBaibaiItengaiList
	 *            重要性無:旧会計基準：売買処理：所有権移転外ファイナンスリース格納リスト
	 */
	public void setJyNOldBaibaiItengaiList(ArrayList<Object> piJyNOldBaibaiItengaiList) {
		this.JyNoldBaibaiItengaiList = piJyNOldBaibaiItengaiList;
	}

	/**
	 * 重要性無:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リストを取得.
	 * 
	 * @return 重要性無:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リスト
	 */
	public ArrayList<Object> getJyNOldTintaiItengaiList() {
		return this.JyNoldTintaiItengaiList;
	}

	/**
	 * 重要性無:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リストを設定.
	 * 
	 * @param piJyNOldTintaiItengaiList
	 *            重要性無:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リスト
	 */
	public void setJyNOldTintaiItengaiList(ArrayList<Object> piJyNOldTintaiItengaiList) {
		this.JyNoldTintaiItengaiList = piJyNOldTintaiItengaiList;
	}

	/**
	 * 重要性無:旧会計基準：売買処理：所有権移転ファイナンスリース格納リストを取得.
	 * 
	 * @return 重要性無:旧会計基準：売買処理：所有権移転ファイナンスリース格納リスト
	 */
	public ArrayList<Object> getJyNOldBaibaiItenList() {
		return this.JyNoldBaibaiItenList;
	}

	/**
	 * 重要性無:旧会計基準：売買処理：所有権移転ファイナンスリース格納リストを設定.
	 * 
	 * @param piJyNOldBaibaiItenList
	 *            重要性無:旧会計基準：売買処理：所有権移転ファイナンスリース格納リスト
	 */
	public void setJyNOldBaibaiItenList(ArrayList<Object> piJyNOldBaibaiItenList) {
		this.JyNoldBaibaiItenList = piJyNOldBaibaiItenList;
	}

	/**
	 * 重要性無:旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納リストを取得.
	 * 
	 * @return 重要性無:旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納リスト
	 */
	public ArrayList<Object> getJyNOldTintaiItenList() {
		return this.JyNoldTintaiItenList;
	}

	/**
	 * 重要性無:旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納リストを設定.
	 * 
	 * @param piJyNOldTintaiItenList
	 *            重要性無:旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納リスト
	 */
	public void setJyNOldTintaiItenList(ArrayList<Object> piJyNOldTintaiItenList) {
		this.JyNoldTintaiItenList = piJyNOldTintaiItenList;
	}

	/**
	 * 重要性無:旧会計基準：オペレーティングリース格納リストを取得.
	 * 
	 * @return 重要性無:旧会計基準：オペレーティングリース格納リスト
	 */
	public ArrayList<Object> getJyNOldOperateList() {
		return this.JyNoldOperateList;
	}

	/**
	 * 重要性無:旧会計基準：オペレーティングリース格納リストを設定.
	 * 
	 * @param piJyNOldOperateList
	 *            重要性無:旧会計基準：オペレーティングリース格納リスト
	 */
	public void setJyNOldOperateList(ArrayList<Object> piJyNOldOperateList) {
		this.JyNoldOperateList = piJyNOldOperateList;
	}

	//有
	/**
	 * 重要性有:新会計基準：売買処理：所有権移転外ファイナンスリース格納リストを取得.
	 * 
	 * @return 重要性有:新会計基準：売買処理：所有権移転外ファイナンスリース格納リスト
	 */
	public ArrayList<Object> getJyANewBaibaiItengaiList() {
		return this.JyAnewBaibaiItengaiList;
	}

	/**
	 * 重要性有:新会計基準：売買処理：所有権移転外ファイナンスリース格納リストを設定.
	 * 
	 * @param piJyANewBaibaiItengaiList
	 *            重要性有:新会計基準：売買処理：所有権移転外ファイナンスリース格納リスト
	 */
	public void setJyANewBaibaiItengaiList(ArrayList<Object> piJyANewBaibaiItengaiList) {
		this.JyAnewBaibaiItengaiList = piJyANewBaibaiItengaiList;
	}

	/**
	 * 重要性有:新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リストを取得.
	 * 
	 * @return 重要性有:新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リスト
	 */
	public ArrayList<Object> getJyANewTintaiItengaiList() {
		return this.JyAnewTintaiItengaiList;
	}

	/**
	 * 重要性有:新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リストを設定.
	 * 
	 * @param piJyANewTintaiItengaiList
	 *            重要性有:新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リスト
	 */
	public void setJyANewTintaiItengaiList(ArrayList<Object> piJyANewTintaiItengaiList) {
		this.JyAnewTintaiItengaiList = piJyANewTintaiItengaiList;
	}

	/**
	 * 重要性有:新会計基準：売買処理：所有権移転ファイナンスリース格納リストを取得.
	 * 
	 * @return 重要性有:新会計基準：売買処理：所有権移転ファイナンスリース格納リスト
	 */
	public ArrayList<Object> getJyANewBaibaiItenList() {
		return this.JyAnewBaibaiItenList;
	}

	/**
	 * 重要性有:新会計基準：売買処理：所有権移転ファイナンスリース格納リストを設定.
	 * 
	 * @param piJyANewBaibaiItenList
	 *            重要性有:新会計基準：売買処理：所有権移転ファイナンスリース格納リスト
	 */
	public void setJyANewBaibaiItenList(ArrayList<Object> piJyANewBaibaiItenList) {
		this.JyAnewBaibaiItenList = piJyANewBaibaiItenList;
	}

	/**
	 * 重要性有:新会計基準：賃貸借処理：所有権移転ファイナンスリース格納リストを取得.
	 * 
	 * @return 重要性有:新会計基準：賃貸借処理：所有権移転ファイナンスリース格納リスト
	 */
	public ArrayList<Object> getJyANewTintaiItenList() {
		return this.JyAnewTintaiItenList;
	}

	/**
	 * 重要性有:新会計基準：賃貸借処理：所有権移転ファイナンスリース格納リストを設定.
	 * 
	 * @param piJyANewTintaiItenList
	 *            重要性有:新会計基準：賃貸借処理：所有権移転ファイナンスリース格納リスト
	 */
	public void setJyANewTintaiItenList(ArrayList<Object> piJyANewTintaiItenList) {
		this.JyAnewTintaiItenList = piJyANewTintaiItenList;
	}

	/**
	 * 重要性有:新会計基準：オペレーティングリース格納リストを取得.
	 * 
	 * @return 重要性有:新会計基準：オペレーティングリース格納リスト
	 */
	public ArrayList<Object> getJyANewOperateList() {
		return this.JyAnewOperateList;
	}

	/**
	 * 重要性有:新会計基準：オペレーティングリース格納リストを設定.
	 * 
	 * @param piJyANewOperateList
	 *            重要性有:新会計基準：オペレーティングリース格納リスト
	 */
	public void setJyANewOperateList(ArrayList<Object> piJyANewOperateList) {
		this.JyAnewOperateList = piJyANewOperateList;
	}

	/**
	 * 重要性有:旧会計基準：売買処理：所有権移転外ファイナンスリース格納リストを取得.
	 * 
	 * @return 重要性有:旧会計基準：売買処理：所有権移転外ファイナンスリース格納リスト
	 */
	public ArrayList<Object> getJyAOldBaibaiItengaiList() {
		return this.JyAoldBaibaiItengaiList;
	}

	/**
	 * 重要性有:旧会計基準：売買処理：所有権移転外ファイナンスリース格納リストを設定.
	 * 
	 * @param piJyAOldBaibaiItengaiList
	 *            重要性有:旧会計基準：売買処理：所有権移転外ファイナンスリース格納リスト
	 */
	public void setJyAOldBaibaiItengaiList(ArrayList<Object> piJyAOldBaibaiItengaiList) {
		this.JyAoldBaibaiItengaiList = piJyAOldBaibaiItengaiList;
	}

	/**
	 * 重要性有:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リストを取得.
	 * 
	 * @return 重要性有:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リスト
	 */
	public ArrayList<Object> getJyAOldTintaiItengaiList() {
		return this.JyAoldTintaiItengaiList;
	}

	/**
	 * 重要性有:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リストを設定.
	 * 
	 * @param piJyAOldTintaiItengaiList
	 *            重要性有:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納リスト
	 */
	public void setJyAOldTintaiItengaiList(ArrayList<Object> piJyAOldTintaiItengaiList) {
		this.JyAoldTintaiItengaiList = piJyAOldTintaiItengaiList;
	}

	/**
	 * 重要性有:旧会計基準：売買処理：所有権移転ファイナンスリース格納リストを取得.
	 * 
	 * @return 重要性有:旧会計基準：売買処理：所有権移転ファイナンスリース格納リスト
	 */
	public ArrayList<Object> getJyAOldBaibaiItenList() {
		return this.JyAoldBaibaiItenList;
	}

	/**
	 * 重要性有:旧会計基準：売買処理：所有権移転ファイナンスリース格納リストを設定.
	 * 
	 * @param piJyAOldBaibaiItenList
	 *            重要性有:旧会計基準：売買処理：所有権移転ファイナンスリース格納リスト
	 */
	public void setJyAOldBaibaiItenList(ArrayList<Object> piJyAOldBaibaiItenList) {
		this.JyAoldBaibaiItenList = piJyAOldBaibaiItenList;
	}

	/**
	 * 重要性有:旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納リストを取得.
	 * 
	 * @return 重要性有:旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納リスト
	 */
	public ArrayList<Object> getJyAOldTintaiItenList() {
		return this.JyAoldTintaiItenList;
	}

	/**
	 * 重要性有:旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納リストを設定.
	 * 
	 * @param piJyAOldTintaiItenList
	 *            重要性有:旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納リスト
	 */
	public void setJyAOldTintaiItenList(ArrayList<Object> piJyAOldTintaiItenList) {
		this.JyAoldTintaiItenList = piJyAOldTintaiItenList;
	}

	/**
	 * 重要性有:旧会計基準：オペレーティングリース格納リストを取得.
	 * 
	 * @return 重要性有:旧会計基準：オペレーティングリース格納リスト
	 */
	public ArrayList<Object> getJyAOldOperateList() {
		return this.JyAoldOperateList;
	}

	/**
	 * 重要性有:旧会計基準：オペレーティングリース格納リストを設定.
	 * 
	 * @param piJyAOldOperateList
	 *            重要性有:旧会計基準：オペレーティングリース格納リスト
	 */
	public void setJyAOldOperateList(ArrayList<Object> piJyAOldOperateList) {
		this.JyAoldOperateList = piJyAOldOperateList;
	}
	// 2020/05/22 ADD END
	
	/**
	 * 費用受払明細表 Beanを追加.
	 * 
	 * @param piBean
	 *            費用受払明細表 Bean
	 */
	public void addUkebaraiHiyoBean(LACSUkebaraiHiyoBean piBean) {
		super.add(piBean);
	}

	/**
	 * 費用受払明細表 Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return 費用受払明細表 Bean
	 */
	public LACSUkebaraiHiyoBean getUkebaraiHiyoBean(int piIdx) {
		return (LACSUkebaraiHiyoBean)super.get(piIdx);
	}

	/**
	 * リース資産受払明細表 Beanを追加.
	 * 
	 * @param piBean
	 *            リース資産受払明細表 Bean
	 */
	public void addUkebaraiSisanBean(LACSUkebaraiSisanBean piBean) {
		super.add(piBean);
	}

	/**
	 * リース資産受払明細表 Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return リース資産受払明細表 Bean
	 */
	public LACSUkebaraiSisanBean getUkebaraiSisanBean(int piIdx) {
		return (LACSUkebaraiSisanBean)super.get(piIdx);
	}

	/**
	 * リース料受払明細表 Beanを追加.
	 * 
	 * @param piBean
	 *            リース料受払明細表 Bean
	 */
	public void addUkebaraiLeaseBean(LACSUkebaraiLeaseBean piBean) {
		super.add(piBean);
	}

	/**
	 * リース料受払明細表 Beanを取得.
	 * 
	 * @param piIdx
	 *            行番号
	 * @return リース料受払明細表 Bean
	 */
	public LACSUkebaraiLeaseBean getUkebaraiLeaseBean(int piIdx) {
		return (LACSUkebaraiLeaseBean)super.get(piIdx);
	}

	/**
	 * リース会社受払定義マスタ用を取得.
	 * 
	 * @return リース会社受払定義マスタ用
	 */
	public String getLeasCompanyUkebarai() {
		return this.leasCompanyUkebarai;
	}

	/**
	 * リース会社受払定義マスタ用を設定.
	 * 
	 * @param piLeasCompanyUkebarai
	 *            リース会社受払定義マスタ用
	 */
	public void setLeasCompanyUkebarai(String piLeasCompanyUkebarai) {
		this.leasCompanyUkebarai = piLeasCompanyUkebarai;
	}

	
	// 2020/05/22 DEL START
	/**
	 * 旧会計基準：売買処理：所有権移転ファイナンスリース格納フラグを取得.
	 * 
	 * @return 旧会計基準：売買処理：所有権移転ファイナンスリース格納フラグ
	 */
	//public String getOldBaibaiItenFlg() {
	//	return this.oldBaibaiItenFlg;
	//}

	/**
	 * 旧会計基準：売買処理：所有権移転ファイナンスリース格納フラグを設定.
	 * 
	 * @param piOldBaibaiItenFlg
	 *            旧会計基準：売買処理：所有権移転ファイナンスリース格納フラグ
	 */
	//public void setOldBaibaiItenFlg(String piOldBaibaiItenFlg) {
	//	this.oldBaibaiItenFlg = piOldBaibaiItenFlg;
	//}

	/**
	 * 旧会計基準：売買処理：所有権移転外ファイナンスリース格納フラグを取得.
	 * 
	 * @return 旧会計基準：売買処理：所有権移転外ファイナンスリース格納フラグ
	 */
	//public String getOldBaibaiItengaiFlg() {
	//	return this.oldBaibaiItengaiFlg;
	//}

	/**
	 * 旧会計基準：売買処理：所有権移転外ファイナンスリース格納フラグを設定.
	 * 
	 * @param piOldBaibaiItengaiFlg
	 *            旧会計基準：売買処理：所有権移転外ファイナンスリース格納フラグ
	 */
	//public void setOldBaibaiItengaiFlg(String piOldBaibaiItengaiFlg) {
	//	this.oldBaibaiItengaiFlg = piOldBaibaiItengaiFlg;
	//}

	/**
	 * 旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグを取得.
	 * 
	 * @return 旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグ
	 */
	//public String getOldTintaiItenFlg() {
	//	return this.oldTintaiItenFlg;
	//}

	/**
	 * 旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグを設定.
	 * 
	 * @param piOldTintaiItenFlg
	 *            旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグ
	 */
	//public void setOldTintaiItenFlg(String piOldTintaiItenFlg) {
	//	this.oldTintaiItenFlg = piOldTintaiItenFlg;
	//}

	/**
	 * 旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグを取得.
	 * 
	 * @return 旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグ
	 */
	//public String getOldTintaiItengaiFlg() {
	//	return this.oldTintaiItengaiFlg;
	//}

	/**
	 * 旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグを設定.
	 * 
	 * @param piOldTintaiItengaiFlg
	 *            旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグ
	 */
	//public void setOldTintaiItengaiFlg(String piOldTintaiItengaiFlg) {
	//	this.oldTintaiItengaiFlg = piOldTintaiItengaiFlg;
	//}

	/**
	 * 旧会計基準：オペレーティングリース格納フラグを取得.
	 * 
	 * @return 旧会計基準：オペレーティングリース格納フラグ
	 */
	//public String getOldOperateFlg() {
	//	return this.oldOperateFlg;
	//}

	/**
	 * 旧会計基準：オペレーティングリース格納フラグを設定.
	 * 
	 * @param piOldOperateFlg
	 *            旧会計基準：オペレーティングリース格納フラグ
	 */
	//public void setOldOperateFlg(String piOldOperateFlg) {
	//	this.oldOperateFlg = piOldOperateFlg;
	//}

	/**
	 * 新会計基準：売買処理：所有権移転ファイナンスリース格納フラグを取得.
	 * 
	 * @return 新会計基準：売買処理：所有権移転ファイナンスリース格納フラグ
	 */
	//public String getNewBaibaiItenFlg() {
	//	return this.newBaibaiItenFlg;
	//}

	/**
	 * 新会計基準：売買処理：所有権移転ファイナンスリース格納フラグを設定.
	 * 
	 * @param piNewBaibaiItenFlg
	 *            新会計基準：売買処理：所有権移転ファイナンスリース格納フラグ
	 */
	//public void setNewBaibaiItenFlg(String piNewBaibaiItenFlg) {
	//	this.newBaibaiItenFlg = piNewBaibaiItenFlg;
	//}

	/**
	 * 新会計基準：売買処理：所有権移転外ファイナンスリース格納フラグを取得.
	 * 
	 * @return 新会計基準：売買処理：所有権移転外ファイナンスリース格納フラグ
	 */
	//public String getNewBaibaiItengaiFlg() {
	//	return this.newBaibaiItengaiFlg;
	//}

	/**
	 * 新会計基準：売買処理：所有権移転外ファイナンスリース格納フラグを設定.
	 * 
	 * @param piNewBaibaiItengaiFlg
	 *            新会計基準：売買処理：所有権移転外ファイナンスリース格納フラグ
	 */
	//public void setNewBaibaiItengaiFlg(String piNewBaibaiItengaiFlg) {
	//	this.newBaibaiItengaiFlg = piNewBaibaiItengaiFlg;
	//}

	/**
	 * 新会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグを取得.
	 * 
	 * @return 新会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグ
	 */
	//public String getNewTintaiItenFlg() {
	//	return this.newTintaiItenFlg;
	//}

	/**
	 * 新会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグを設定.
	 * 
	 * @param piNewTintaiItenFlg
	 *            新会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグ
	 */
	//public void setNewTintaiItenFlg(String piNewTintaiItenFlg) {
	//	this.newTintaiItenFlg = piNewTintaiItenFlg;
	//}

	/**
	 * 新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグを取得.
	 * 
	 * @return 新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグ
	 */
	//public String getNewTintaiItengaiFlg() {
	//	return this.newTintaiItengaiFlg;
	//}

	/**
	 * 新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグを設定.
	 * 
	 * @param piNewTintaiItengaiFlg
	 *            新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグ
	 */
	//public void setNewTintaiItengaiFlg(String piNewTintaiItengaiFlg) {
	//	this.newTintaiItengaiFlg = piNewTintaiItengaiFlg;
	//}

	/**
	 * 新会計基準：オペレーティングリース格納フラグを取得.
	 * 
	 * @return 新会計基準：オペレーティングリース格納フラグ
	 */
	//public String getNewOperateFlg() {
	//	return this.newOperateFlg;
	//}

	/**
	 * 新会計基準：オペレーティングリース格納フラグを設定.
	 * 
	 * @param piNewOperateFlg
	 *            新会計基準：オペレーティングリース格納フラグ
	 */
	//public void setNewOperateFlg(String piNewOperateFlg) {
	//	this.newOperateFlg = piNewOperateFlg;
	//}
	// 2020/05/22 DEL END

	// 2020/05/22 ADD START
	/**
	 * 重要性無:旧会計基準：売買処理：所有権移転ファイナンスリース格納フラグを取得.
	 * 
	 * @return 重要性無:旧会計基準：売買処理：所有権移転ファイナンスリース格納フラグ
	 */
	public String getJyNOldBaibaiItenFlg() {
		return this.JyNoldBaibaiItenFlg;
	}

	/**
	 * 重要性無:旧会計基準：売買処理：所有権移転ファイナンスリース格納フラグを設定.
	 * 
	 * @param piJyNOldBaibaiItenFlg
	 *            重要性無:旧会計基準：売買処理：所有権移転ファイナンスリース格納フラグ
	 */
	public void setJyNOldBaibaiItenFlg(String piJyNOldBaibaiItenFlg) {
		this.JyNoldBaibaiItenFlg = piJyNOldBaibaiItenFlg;
	}

	/**
	 * 重要性無:旧会計基準：売買処理：所有権移転外ファイナンスリース格納フラグを取得.
	 * 
	 * @return 重要性無:旧会計基準：売買処理：所有権移転外ファイナンスリース格納フラグ
	 */
	public String getJyNOldBaibaiItengaiFlg() {
		return this.JyNoldBaibaiItengaiFlg;
	}

	/**
	 * 重要性無:旧会計基準：売買処理：所有権移転外ファイナンスリース格納フラグを設定.
	 * 
	 * @param piJyNOldBaibaiItengaiFlg
	 *            重要性無:旧会計基準：売買処理：所有権移転外ファイナンスリース格納フラグ
	 */
	public void setJyNOldBaibaiItengaiFlg(String piJyNOldBaibaiItengaiFlg) {
		this.JyNoldBaibaiItengaiFlg = piJyNOldBaibaiItengaiFlg;
	}

	/**
	 * 重要性無:旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグを取得.
	 * 
	 * @return 重要性無:旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグ
	 */
	public String getJyNOldTintaiItenFlg() {
		return this.JyNoldTintaiItenFlg;
	}

	/**
	 * 重要性無:旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグを設定.
	 * 
	 * @param piJyNOldTintaiItenFlg
	 *            重要性無:旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグ
	 */
	public void setJyNOldTintaiItenFlg(String piJyNOldTintaiItenFlg) {
		this.JyNoldTintaiItenFlg = piJyNOldTintaiItenFlg;
	}

	/**
	 * 重要性無:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグを取得.
	 * 
	 * @return 重要性無:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグ
	 */
	public String getJyNOldTintaiItengaiFlg() {
		return this.JyNoldTintaiItengaiFlg;
	}

	/**
	 * 重要性無:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグを設定.
	 * 
	 * @param piJyNOldTintaiItengaiFlg
	 *            重要性無:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグ
	 */
	public void setJyNOldTintaiItengaiFlg(String piJyNOldTintaiItengaiFlg) {
		this.JyNoldTintaiItengaiFlg = piJyNOldTintaiItengaiFlg;
	}

	/**
	 * 重要性無:旧会計基準：オペレーティングリース格納フラグを取得.
	 * 
	 * @return 重要性無:旧会計基準：オペレーティングリース格納フラグ
	 */
	public String getJyNOldOperateFlg() {
		return this.JyNoldOperateFlg;
	}

	/**
	 * 重要性無:旧会計基準：オペレーティングリース格納フラグを設定.
	 * 
	 * @param piJyNOldOperateFlg
	 *            重要性無:旧会計基準：オペレーティングリース格納フラグ
	 */
	public void setJyNOldOperateFlg(String piJyNOldOperateFlg) {
		this.JyNoldOperateFlg = piJyNOldOperateFlg;
	}

	/**
	 * 重要性無:新会計基準：売買処理：所有権移転ファイナンスリース格納フラグを取得.
	 * 
	 * @return 重要性無:新会計基準：売買処理：所有権移転ファイナンスリース格納フラグ
	 */
	public String getJyNNewBaibaiItenFlg() {
		return this.JyNnewBaibaiItenFlg;
	}

	/**
	 * 重要性無:新会計基準：売買処理：所有権移転ファイナンスリース格納フラグを設定.
	 * 
	 * @param piJyNNewBaibaiItenFlg
	 *            重要性無:新会計基準：売買処理：所有権移転ファイナンスリース格納フラグ
	 */
	public void setJyNNewBaibaiItenFlg(String piJyNNewBaibaiItenFlg) {
		this.JyNnewBaibaiItenFlg = piJyNNewBaibaiItenFlg;
	}

	/**
	 * 重要性無:新会計基準：売買処理：所有権移転外ファイナンスリース格納フラグを取得.
	 * 
	 * @return 重要性無:新会計基準：売買処理：所有権移転外ファイナンスリース格納フラグ
	 */
	public String getJyNNewBaibaiItengaiFlg() {
		return this.JyNnewBaibaiItengaiFlg;
	}

	/**
	 * 重要性無:新会計基準：売買処理：所有権移転外ファイナンスリース格納フラグを設定.
	 * 
	 * @param piJyNNewBaibaiItengaiFlg
	 *            重要性無:新会計基準：売買処理：所有権移転外ファイナンスリース格納フラグ
	 */
	public void setJyNNewBaibaiItengaiFlg(String piJyNNewBaibaiItengaiFlg) {
		this.JyNnewBaibaiItengaiFlg = piJyNNewBaibaiItengaiFlg;
	}

	/**
	 * 重要性無:新会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグを取得.
	 * 
	 * @return 重要性無:新会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグ
	 */
	public String getJyNNewTintaiItenFlg() {
		return this.JyNnewTintaiItenFlg;
	}

	/**
	 * 重要性無:新会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグを設定.
	 * 
	 * @param piJyNNewTintaiItenFlg
	 *            重要性無:新会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグ
	 */
	public void setJyNNewTintaiItenFlg(String piJyNNewTintaiItenFlg) {
		this.JyNnewTintaiItenFlg = piJyNNewTintaiItenFlg;
	}

	/**
	 * 重要性無:新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグを取得.
	 * 
	 * @return 重要性無:新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグ
	 */
	public String getJyNNewTintaiItengaiFlg() {
		return this.JyNnewTintaiItengaiFlg;
	}

	/**
	 * 重要性無:新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグを設定.
	 * 
	 * @param piJyNNewTintaiItengaiFlg
	 *            重要性無:新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグ
	 */
	public void setJyNNewTintaiItengaiFlg(String piJyNNewTintaiItengaiFlg) {
		this.JyNnewTintaiItengaiFlg = piJyNNewTintaiItengaiFlg;
	}

	/**
	 * 重要性無:新会計基準：オペレーティングリース格納フラグを取得.
	 * 
	 * @return 重要性無:新会計基準：オペレーティングリース格納フラグ
	 */
	public String getJyNNewOperateFlg() {
		return this.JyNnewOperateFlg;
	}

	/**
	 * 重要性無:新会計基準：オペレーティングリース格納フラグを設定.
	 * 
	 * @param piJyNNewOperateFlg
	 *            重要性無:新会計基準：オペレーティングリース格納フラグ
	 */
	public void setJyNNewOperateFlg(String piJyNNewOperateFlg) {
		this.JyNnewOperateFlg = piJyNNewOperateFlg;
	}

	//
	/**
	 * 重要性有:旧会計基準：売買処理：所有権移転ファイナンスリース格納フラグを取得.
	 * 
	 * @return 重要性有:旧会計基準：売買処理：所有権移転ファイナンスリース格納フラグ
	 */
	public String getJyAOldBaibaiItenFlg() {
		return this.JyAoldBaibaiItenFlg;
	}

	/**
	 * 重要性有:旧会計基準：売買処理：所有権移転ファイナンスリース格納フラグを設定.
	 * 
	 * @param piJyAOldBaibaiItenFlg
	 *            重要性有:旧会計基準：売買処理：所有権移転ファイナンスリース格納フラグ
	 */
	public void setJyAOldBaibaiItenFlg(String piJyAOldBaibaiItenFlg) {
		this.JyAoldBaibaiItenFlg = piJyAOldBaibaiItenFlg;
	}

	/**
	 * 重要性有:旧会計基準：売買処理：所有権移転外ファイナンスリース格納フラグを取得.
	 * 
	 * @return 重要性有:旧会計基準：売買処理：所有権移転外ファイナンスリース格納フラグ
	 */
	public String getJyAOldBaibaiItengaiFlg() {
		return this.JyAoldBaibaiItengaiFlg;
	}

	/**
	 * 重要性有:旧会計基準：売買処理：所有権移転外ファイナンスリース格納フラグを設定.
	 * 
	 * @param piJyAOldBaibaiItengaiFlg
	 *            重要性有:旧会計基準：売買処理：所有権移転外ファイナンスリース格納フラグ
	 */
	public void setJyAOldBaibaiItengaiFlg(String piJyAOldBaibaiItengaiFlg) {
		this.JyAoldBaibaiItengaiFlg = piJyAOldBaibaiItengaiFlg;
	}

	/**
	 * 重要性有:旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグを取得.
	 * 
	 * @return 重要性有:旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグ
	 */
	public String getJyAOldTintaiItenFlg() {
		return this.JyAoldTintaiItenFlg;
	}

	/**
	 * 重要性有:旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグを設定.
	 * 
	 * @param piJyAOldTintaiItenFlg
	 *            重要性有:旧会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグ
	 */
	public void setJyAOldTintaiItenFlg(String piJyAOldTintaiItenFlg) {
		this.JyAoldTintaiItenFlg = piJyAOldTintaiItenFlg;
	}

	/**
	 * 重要性有:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグを取得.
	 * 
	 * @return 重要性有:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグ
	 */
	public String getJyAOldTintaiItengaiFlg() {
		return this.JyAoldTintaiItengaiFlg;
	}

	/**
	 * 重要性有:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグを設定.
	 * 
	 * @param piJyAOldTintaiItengaiFlg
	 *            重要性有:旧会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグ
	 */
	public void setJyAOldTintaiItengaiFlg(String piJyAOldTintaiItengaiFlg) {
		this.JyAoldTintaiItengaiFlg = piJyAOldTintaiItengaiFlg;
	}

	/**
	 * 重要性有:旧会計基準：オペレーティングリース格納フラグを取得.
	 * 
	 * @return 重要性有:旧会計基準：オペレーティングリース格納フラグ
	 */
	public String getJyAOldOperateFlg() {
		return this.JyAoldOperateFlg;
	}

	/**
	 * 重要性有:旧会計基準：オペレーティングリース格納フラグを設定.
	 * 
	 * @param piJyAOldOperateFlg
	 *            重要性有:旧会計基準：オペレーティングリース格納フラグ
	 */
	public void setJyAOldOperateFlg(String piJyAOldOperateFlg) {
		this.JyAoldOperateFlg = piJyAOldOperateFlg;
	}

	/**
	 * 重要性有:新会計基準：売買処理：所有権移転ファイナンスリース格納フラグを取得.
	 * 
	 * @return 重要性有:新会計基準：売買処理：所有権移転ファイナンスリース格納フラグ
	 */
	public String getJyANewBaibaiItenFlg() {
		return this.JyAnewBaibaiItenFlg;
	}

	/**
	 * 重要性有:新会計基準：売買処理：所有権移転ファイナンスリース格納フラグを設定.
	 * 
	 * @param piJyANewBaibaiItenFlg
	 *            重要性有:新会計基準：売買処理：所有権移転ファイナンスリース格納フラグ
	 */
	public void setJyANewBaibaiItenFlg(String piJyANewBaibaiItenFlg) {
		this.JyAnewBaibaiItenFlg = piJyANewBaibaiItenFlg;
	}

	/**
	 * 重要性有:新会計基準：売買処理：所有権移転外ファイナンスリース格納フラグを取得.
	 * 
	 * @return 重要性有:新会計基準：売買処理：所有権移転外ファイナンスリース格納フラグ
	 */
	public String getJyANewBaibaiItengaiFlg() {
		return this.JyAnewBaibaiItengaiFlg;
	}

	/**
	 * 重要性有:新会計基準：売買処理：所有権移転外ファイナンスリース格納フラグを設定.
	 * 
	 * @param piJyANewBaibaiItengaiFlg
	 *            重要性有:新会計基準：売買処理：所有権移転外ファイナンスリース格納フラグ
	 */
	public void setJyANewBaibaiItengaiFlg(String piJyANewBaibaiItengaiFlg) {
		this.JyAnewBaibaiItengaiFlg = piJyANewBaibaiItengaiFlg;
	}

	/**
	 * 重要性有:新会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグを取得.
	 * 
	 * @return 重要性有:新会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグ
	 */
	public String getJyANewTintaiItenFlg() {
		return this.JyAnewTintaiItenFlg;
	}

	/**
	 * 重要性有:新会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグを設定.
	 * 
	 * @param piJyANewTintaiItenFlg
	 *            重要性有:新会計基準：賃貸借処理：所有権移転ファイナンスリース格納フラグ
	 */
	public void setJyANewTintaiItenFlg(String piJyANewTintaiItenFlg) {
		this.JyAnewTintaiItenFlg = piJyANewTintaiItenFlg;
	}

	/**
	 * 重要性有:新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグを取得.
	 * 
	 * @return 重要性有:新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグ
	 */
	public String getJyANewTintaiItengaiFlg() {
		return this.JyAnewTintaiItengaiFlg;
	}

	/**
	 * 重要性有:新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグを設定.
	 * 
	 * @param piJyANewTintaiItengaiFlg
	 *            重要性有:新会計基準：賃貸借処理：所有権移転外ファイナンスリース格納フラグ
	 */
	public void setJyANewTintaiItengaiFlg(String piJyANewTintaiItengaiFlg) {
		this.JyAnewTintaiItengaiFlg = piJyANewTintaiItengaiFlg;
	}

	/**
	 * 重要性有:新会計基準：オペレーティングリース格納フラグを取得.
	 * 
	 * @return 重要性有:新会計基準：オペレーティングリース格納フラグ
	 */
	public String getJyANewOperateFlg() {
		return this.JyAnewOperateFlg;
	}

	/**
	 * 重要性有:新会計基準：オペレーティングリース格納フラグを設定.
	 * 
	 * @param piJyANewOperateFlg
	 *            重要性有:新会計基準：オペレーティングリース格納フラグ
	 */
	public void setJyANewOperateFlg(String piJyANewOperateFlg) {
		this.JyAnewOperateFlg = piJyANewOperateFlg;
	}

	// 2020/05/22 ADD END

	/**
	 * 次のフォーカスを取得.
	 * 
	 * @return 次のフォーカス
	 */
	public int getNextFocus() {
		return this.nextFocus;
	}

	/**
	 * 次のフォーカスを設定.
	 * 
	 * @param piNextFocus
	 *            次のフォーカス
	 */
	public void setNextFocus(int piNextFocus) {
		this.nextFocus = piNextFocus;
	}

	/**
	 * 受払合計表を取得.
	 * 
	 * @return 受払合計表
	 */
	public LACSReportDetailBean getGokei() {
		return this.gokei;
	}

	/**
	 * 受払合計表を設定.
	 * 
	 * @param piGoukei
	 *            受払合計表
	 */
	public void setGokei(LACSReportDetailBean piGoukei) {
		this.gokei = piGoukei;
	}

	/**
	 * リース資産受払明細表を取得.
	 * 
	 * @return リース資産受払明細表
	 */
	public LACSReportDetailBean getSisan() {
		return this.sisan;
	}

	/**
	 * リース資産受払明細表を設定.
	 * 
	 * @param piSisan
	 *            リース資産受払明細表
	 */
	public void setSisan(LACSReportDetailBean piSisan) {
		this.sisan = piSisan;
	}

	/**
	 * リース料受払明細表を取得.
	 * 
	 * @return リース料受払明細表
	 */
	public LACSReportDetailBean getLease() {
		return this.lease;
	}

	/**
	 * リース料受払明細表を設定.
	 * 
	 * @param piLease
	 *            リース料受払明細表
	 */
	public void setLease(LACSReportDetailBean piLease) {
		this.lease = piLease;
	}

	/**
	 * 費用受払明細表を取得.
	 * 
	 * @return 費用受払明細表
	 */
	public LACSReportDetailBean getHiyo() {
		return this.hiyo;
	}

	/**
	 * 費用受払明細表を設定.
	 * 
	 * @param piHiyo
	 *            費用受払明細表
	 */
	public void setHiyo(LACSReportDetailBean piHiyo) {
		this.hiyo = piHiyo;
	}

}
