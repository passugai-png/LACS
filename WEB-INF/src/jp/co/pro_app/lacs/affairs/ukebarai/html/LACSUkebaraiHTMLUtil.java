package jp.co.pro_app.lacs.affairs.ukebarai.html;

import java.util.ArrayList;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSDispControlBean;
import jp.co.pro_app.lacs.affairs.common.html.LACSHTMLUtil;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiDetailBean;
import jp.co.pro_app.lacs.affairs.ukebarai.common.LACSUkebaraiCommon;
import jp.co.pro_app.projframe.common.command.StringUtl;

/**
 * 受払合計表用HTML生成.
 * 
 * @author active
 * @version 20080808
 * @auther tatsummi
 * @version 20240910
 */
public class LACSUkebaraiHTMLUtil extends LACSHTMLUtil {

	/**
	 * 明細生成.
	 * 
	 * @param piBean
	 *            受払合計表Bean
	 * @return 明細
	 */
	public static String outHTMLList(LACSUkebaraiBean piBean) {

		StringBuffer buf = new StringBuffer();

		// 2020/05/22 REP START
//		if ("0".equals(piBean.getOldBaibaiItenFlg())) {
//			buf.append(getBSPLList(piBean.getOldBaibaiItenList(), "旧リース会計基準", "売買処理", "所有権移転ファイナンスリース"));
//
//			buf.append("                    <br /> " + "\n");
//		}
//		if ("0".equals(piBean.getOldTintaiItenFlg())) {
//			buf.append(getTintaiBSPLList(piBean.getOldTintaiItenList(), "旧リース会計基準", "賃貸借処理", "所有権移転ファイナンスリース"));
//
//			buf.append("                    <br /> " + "\n");
//		}
//		if ("0".equals(piBean.getOldBaibaiItengaiFlg())) {
//			buf.append(getBSPLList(piBean.getOldBaibaiItengaiList(), "旧リース会計基準", "売買処理", "所有権移転外ファイナンスリース"));
//
//			buf.append("                    <br /> " + "\n");
//		}
//		if ("0".equals(piBean.getOldTintaiItengaiFlg())) {
//			buf.append(getTintaiBSPLList(piBean.getOldTintaiItengaiList(), "旧リース会計基準", "賃貸借処理", "所有権移転外ファイナンスリース"));
//
//			buf.append("                    <br /> " + "\n");
//		}
//		if ("0".equals(piBean.getOldOperateFlg())) {
//			buf.append(getTintaiList(piBean.getOldOperateList(), "旧リース会計基準", "賃貸借処理", "オペレーティングリース"));
//
//			buf.append("                    <br /> " + "\n");
//		}
//		if ("0".equals(piBean.getNewBaibaiItenFlg())) {
//			buf.append(getBSPLList(piBean.getNewBaibaiItenList(), "新リース会計基準", "売買処理", "所有権移転ファイナンスリース"));
//
//			buf.append("                    <br /> " + "\n");
//		}
//		if ("0".equals(piBean.getNewTintaiItenFlg())) {
//			buf.append(getTintaiBSPLList(piBean.getNewTintaiItenList(), "新リース会計基準", "賃貸借処理", "所有権移転ファイナンスリース"));
//
//			buf.append("                    <br /> " + "\n");
//		}
//		if ("0".equals(piBean.getNewBaibaiItengaiFlg())) {
//			buf.append(getBSPLList(piBean.getNewBaibaiItengaiList(), "新リース会計基準", "売買処理", "所有権移転外ファイナンスリース"));
//
//			buf.append("                    <br /> " + "\n");
//		}
//		if ("0".equals(piBean.getNewTintaiItengaiFlg())) {
//			buf.append(getTintaiBSPLList(piBean.getNewTintaiItengaiList(), "新リース会計基準", "賃貸借処理", "所有権移転外ファイナンスリース"));
//
//			buf.append("                    <br /> " + "\n");
//		}
//		if ("0".equals(piBean.getNewOperateFlg())) {
//			buf.append(getTintaiList(piBean.getNewOperateList(), "新リース会計基準", "賃貸借処理", "オペレーティングリース"));
//		}

		//
		if ("0".equals(piBean.getJyNOldBaibaiItenFlg())) {
			buf.append(getBSPLList(piBean.getJyNOldBaibaiItenList(), "旧リース会計基準", "売買処理", "所有権移転ファイナンスリース", "なし"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyNOldTintaiItenFlg())) {
			buf.append(getTintaiBSPLList(piBean.getJyNOldTintaiItenList(), "旧リース会計基準", "賃貸借処理", "所有権移転ファイナンスリース", "なし"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyNOldBaibaiItengaiFlg())) {
			buf.append(getBSPLList(piBean.getJyNOldBaibaiItengaiList(), "旧リース会計基準", "売買処理", "所有権移転外ファイナンスリース", "なし"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyNOldTintaiItengaiFlg())) {
			buf.append(getTintaiBSPLList(piBean.getJyNOldTintaiItengaiList(), "旧リース会計基準", "賃貸借処理", "所有権移転外ファイナンスリース", "なし"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyNOldOperateFlg())) {
			buf.append(getTintaiList(piBean.getJyNOldOperateList(), "旧リース会計基準", "賃貸借処理", "オペレーティングリース", "なし"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyNNewBaibaiItenFlg())) {
			buf.append(getBSPLList(piBean.getJyNNewBaibaiItenList(), "新リース会計基準", "売買処理", "所有権移転ファイナンスリース", "なし"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyNNewTintaiItenFlg())) {
			buf.append(getTintaiBSPLList(piBean.getJyNNewTintaiItenList(), "新リース会計基準", "賃貸借処理", "所有権移転ファイナンスリース", "なし"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyNNewBaibaiItengaiFlg())) {
			buf.append(getBSPLList(piBean.getJyNNewBaibaiItengaiList(), "新リース会計基準", "売買処理", "所有権移転外ファイナンスリース", "なし"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyNNewTintaiItengaiFlg())) {
			buf.append(getTintaiBSPLList(piBean.getJyNNewTintaiItengaiList(), "新リース会計基準", "賃貸借処理", "所有権移転外ファイナンスリース", "なし"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyNNewOperateFlg())) {
			buf.append(getTintaiList(piBean.getJyNNewOperateList(), "新リース会計基準", "賃貸借処理", "オペレーティングリース", "なし"));
		}
		//
		if ("0".equals(piBean.getJyAOldBaibaiItenFlg())) {
			buf.append(getBSPLList(piBean.getJyAOldBaibaiItenList(), "旧リース会計基準", "売買処理", "所有権移転ファイナンスリース", "あり"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyAOldTintaiItenFlg())) {
			buf.append(getTintaiBSPLList(piBean.getJyAOldTintaiItenList(), "旧リース会計基準", "賃貸借処理", "所有権移転ファイナンスリース", "あり"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyAOldBaibaiItengaiFlg())) {
			buf.append(getBSPLList(piBean.getJyAOldBaibaiItengaiList(), "旧リース会計基準", "売買処理", "所有権移転外ファイナンスリース", "あり"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyAOldTintaiItengaiFlg())) {
			buf.append(getTintaiBSPLList(piBean.getJyAOldTintaiItengaiList(), "旧リース会計基準", "賃貸借処理", "所有権移転外ファイナンスリース", "あり"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyAOldOperateFlg())) {
			buf.append(getTintaiList(piBean.getJyAOldOperateList(), "旧リース会計基準", "賃貸借処理", "オペレーティングリース", "あり"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyANewBaibaiItenFlg())) {
			buf.append(getBSPLList(piBean.getJyANewBaibaiItenList(), "新リース会計基準", "売買処理", "所有権移転ファイナンスリース", "あり"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyANewTintaiItenFlg())) {
			buf.append(getTintaiBSPLList(piBean.getJyANewTintaiItenList(), "新リース会計基準", "賃貸借処理", "所有権移転ファイナンスリース", "あり"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyANewBaibaiItengaiFlg())) {
			buf.append(getBSPLList(piBean.getJyANewBaibaiItengaiList(), "新リース会計基準", "売買処理", "所有権移転外ファイナンスリース", "あり"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyANewTintaiItengaiFlg())) {
			buf.append(getTintaiBSPLList(piBean.getJyANewTintaiItengaiList(), "新リース会計基準", "賃貸借処理", "所有権移転外ファイナンスリース", "あり"));

			buf.append("                    <br /> " + "\n");
		}
		if ("0".equals(piBean.getJyANewOperateFlg())) {
			buf.append(getTintaiList(piBean.getJyANewOperateList(), "新リース会計基準", "賃貸借処理", "オペレーティングリース", "あり"));
		}
		// 2020/05/22 REP END

		return buf.toString();
	}

	/**
	 * 出力条件を1行出力する.
	 * 
	 * @param piTitle
	 *            タイトル
	 * @param piItemName
	 *            出力条件
	 * @return StringBuffer
	 */
	private static StringBuffer getSubTitle(String piTitle, String piItemName) {
		StringBuffer buf = new StringBuffer();

		buf.append("				<div class=\"display-group-one-row-nospase\"> " + "\n");
		buf.append("					<div class=\"section-right-one-row\"> " +  piTitle + "：</div>" + "\n");
		buf.append("					<div class=\"section-left-one-row\"> " + piItemName + "</div> " + "\n");
		buf.append("				</div> " + "\n");

		return buf;
	}

	/**
	 * 売買処理の明細を出力する.
	 * 
	 * @param piDetailList
	 *            明細格納リスト
	 * @param piKijun
	 *            リース会計基準の項目名
	 * @param piHouhou
	 *            会計処理方法の項目名
	 * @param piKubun
	 *            出力条件
	 * @return StringBuffer
	 */
	// 2020/05/22 REP START
	//private static StringBuffer getBSPLList(ArrayList<Object> piDetailList, String piKijun, String piHouhou, String piKubun) {
	private static StringBuffer getBSPLList(ArrayList<Object> piDetailList, String piKijun, String piHouhou, String piKubun,  String piJysiUm) {
	// 2020/05/22 REP END
		StringBuffer buf = new StringBuffer();

		buf.append("			<div class=\"display-group-section\" > " + "\n");
		// 2020/05/22 ADD START
		buf.append(getSubTitle("重要性有無", piJysiUm));
		// 2020/05/22 ADD END
		buf.append(getSubTitle("リース会計基準", piKijun));
		buf.append(getSubTitle("リース取引分類", piKubun));
		buf.append(getSubTitle("会計処理方法", piHouhou));

		buf.append("			</div> " + "\n");
		buf.append("			<div class=\"function-title\"> " + "ＢＳ科目残高推移</div>" + "\n");
		buf.append("			<div class=\"search-list\">  " + "\n");

		buf.append(getTableTitle(true));

		buf.append(getListDetail(piDetailList, 0, LACSUkebaraiCommon.BS_LIST_COUNT));

		buf.append("			</div>  " + "\n");
		
		buf.append("			<div class=\"function-title\"> " + "ＰＬ科目累計推移</div>" + "\n");
		buf.append("			<div class=\"search-list\">  " + "\n");

		buf.append(getTableTitle(false));
		
		buf.append(getListDetail(piDetailList, LACSUkebaraiCommon.BS_LIST_COUNT, LACSUkebaraiCommon.PL_LIST_COUNT));
		
		buf.append("			</div>  " + "\n");
		
		return buf;
	}

	/**
	 * 賃貸借処理の明細を出力する.
	 * 
	 * @param piDetailList
	 *            明細格納リスト
	 * @param piKijun
	 *            リース会計基準の項目名
	 * @param piHouhou
	 *            会計処理方法の項目名
	 * @param piKubun
	 *            出力条件
	 * @return StringBuffer
	 */
	// 2020/05/22 ADD START
	//private static StringBuffer getTintaiList(ArrayList<Object> piDetailList, String piKijun, String piHouhou, String piKubun) {
	private static StringBuffer getTintaiList(ArrayList<Object> piDetailList, String piKijun, String piHouhou, String piKubun, String piJysiUm) {
	// 2020/05/22 ADD END
		StringBuffer buf = new StringBuffer();

		buf.append("			<div class=\"display-group-section\" > " + "\n");
		// 2020/05/22 ADD START
		buf.append(getSubTitle("重要性有無", piJysiUm));
		// 2020/05/22 ADD END
		buf.append(getSubTitle("リース会計基準", piKijun));
		buf.append(getSubTitle("リース取引分類", piKubun));
		buf.append(getSubTitle("会計処理方法", piHouhou));
		
		buf.append("			</div> " + "\n");
		buf.append("			<div class=\"function-title\"> " + "ＢＳ科目残高推移</div>" + "\n");
		buf.append("			<div class=\"search-list\">  " + "\n");
		
		buf.append(getTableTitle(false));
		buf.append(getListDetail(piDetailList, LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT));
		
		buf.append("			</div>  " + "\n");
		
		return buf;
	}

	/**
	 * 賃貸借処理でファイナンスリースの明細を出力する.
	 * 
	 * @param piDetailList
	 *            明細格納リスト
	 * @param piKijun
	 *            リース会計基準の項目名
	 * @param piHouhou
	 *            会計処理方法の項目名
	 * @param piKubun
	 *            出力条件
	 * @return StringBuffer
	 */
	// 2020/05/22 ADD START
	//private static StringBuffer getTintaiBSPLList(ArrayList<Object> piDetailList, String piKijun, String piHouhou, String piKubun) {
	private static StringBuffer getTintaiBSPLList(ArrayList<Object> piDetailList, String piKijun, String piHouhou, String piKubun, String piJysiUm) {
	// 2020/05/22 ADD END
		StringBuffer buf = new StringBuffer();

		buf.append("			<div class=\"display-group-section\" > " + "\n");
		// 2020/05/22 ADD START
		buf.append(getSubTitle("重要性有無", piJysiUm));
		// 2020/05/22 ADD END
		buf.append(getSubTitle("リース会計基準", piKijun));
		buf.append(getSubTitle("リース取引分類", piKubun));
		buf.append(getSubTitle("会計処理方法", piHouhou));
		
		buf.append("			</div> " + "\n");
		buf.append("			<div class=\"function-title\"> " + "ＢＳ科目残高推移</div>" + "\n");
		buf.append("			<div class=\"search-list\">  " + "\n");

		buf.append(getTableTitle(true));

		buf.append(getListDetail(piDetailList, 0, LACSUkebaraiCommon.BS_LIST_COUNT));
		
		buf.append("			</div>  " + "\n");
		
		buf.append("			<div class=\"function-title\"> " + "ＰＬ科目累計推移</div>" + "\n");
		buf.append("			<div class=\"search-list\">  " + "\n");

		buf.append(getTableTitle(false));
		buf.append(getListDetail(piDetailList, LACSUkebaraiCommon.PL_LIST_COUNT, LACSUkebaraiCommon.MAX_LIST_COUNT));
		
		buf.append("			</div>  " + "\n");
		
		return buf;
	}

	/**
	 * 明細行を出力する.
	 * 
	 * @param piDetailList
	 *            明細行データ格納リスト
	 * @param piStartIdx
	 *            リスト開始インデックス
	 * @param piBreakIdx
	 *            リスト終了インデックス
	 * @return StringBuffer HTML
	 */
	private static StringBuffer getListDetail(ArrayList<Object> piDetailList, int piStartIdx, int piBreakIdx) {
		StringBuffer buf = new StringBuffer();

		LACSUkebaraiDetailBean bean = null;

		int c = 0;
		for (int i = piStartIdx; i < piDetailList.size(); i++) {

			if (i == piBreakIdx) {
				break;
			}

			bean = (LACSUkebaraiDetailBean)piDetailList.get(i);
			
			if (c++ % 2 == 0) {
				buf.append("					<tr class=\"rows-ivory\">   " + "\n");
			}
			else {
				buf.append("					<tr class=\"rows-blue\">   " + "\n");
			}
			
			buf.append("						<td class=\"cells-left\">  " + "\n");
			buf.append("							" + bean.getKamokuNm() + "\n");
			buf.append("						</td>  " + "\n");
			buf.append("						<td class=\"cells-right\">  " + "\n");
			if (bean.isZenFlag()) {
				buf.append("							" + StringUtl.formatNumber(bean.getZenCost()) + "\n");
			}
			buf.append("						</td>  " + "\n");
			buf.append("						<td class=\"cells-right\">  " + "\n");
			if (bean.isTouzouFlag()) {
				buf.append("							" + StringUtl.formatNumber(bean.getTouzouCost()) + "\n");
			}
			buf.append("						</td>  " + "\n");
			buf.append("						<td class=\"cells-right\">  " + "\n");
			if (bean.isToujitFlag()) {
				buf.append("							" + StringUtl.formatNumber(bean.getToujitCost()) + "\n");
			}
			buf.append("						</td>  " + "\n");
			buf.append("						<td class=\"cells-right\">  " + "\n");
			if (bean.isTougenFlag()) {
				buf.append("							" + StringUtl.formatNumber(bean.getTougenCost()) + "\n");
			}
			buf.append("						</td>  " + "\n");
			buf.append("						<td class=\"cells-right\">  " + "\n");
			if (bean.isTouzanFlag()) {
				buf.append("							" + StringUtl.formatNumber(bean.getTouzanCost()) + "\n");
			}
			buf.append("						</td>  " + "\n");
			buf.append("					</tr>  " + "\n");
		}
		
		buf.append("					</table> " + "\n");
		
		return buf;
	}

	/**
	 * 表のタイトルを設定する.
	 * 
	 * @param piAllFlag
	 *            すべての項目名を出力するフラグ
	 * @return StringBuffer タイトル行
	 */
	private static StringBuffer getTableTitle(boolean piAllFlag) {

		StringBuffer buf = new StringBuffer();
		
		buf.append("				<table class=\"search-list-main\"> " + "\n");
		buf.append("					<tr class=\"cells-center\"> " + "\n");
		buf.append("						<th class=\"cells-width-four\">  " + "\n");
		buf.append("							科目名  " + "\n");
		buf.append("						</th>  " + "\n");
		buf.append("						<th class=\"cells-width-three\">  " + "\n");
		if (piAllFlag) {
			buf.append("							前期末残高  " + "\n");
		}
		else {
			buf.append("							前期末累計  " + "\n");
		}
		buf.append("						</th>  " + "\n");
		buf.append("						<th class=\"cells-width-three\">  " + "\n");
		if (piAllFlag) {
			buf.append("							当期増加  " + "\n");
		}
		buf.append("						</th>  " + "\n");
		buf.append("						<th class=\"cells-width-three\">  " + "\n");
		if (piAllFlag) {
			buf.append("							当期実現  " + "\n");
		}
		else {
			buf.append("							当期発生  " + "\n");
		}
		buf.append("						</th>  " + "\n");
		buf.append("						<th class=\"cells-width-three\">  " + "\n");
		if (piAllFlag) {
			buf.append("							当期減少  " + "\n");
		}
		else {
			buf.append("							当期減少  " + "\n");
		}
		buf.append("						</th>  " + "\n");
		buf.append("						<th class=\"cells-width-three\">  " + "\n");
		if (piAllFlag) {
			buf.append("							当期末残高  " + "\n");
		}
		else {
			buf.append("							当期末累計  " + "\n");
		}
		buf.append("						</th>  " + "\n");
		buf.append("					</tr>  " + "\n");
		
		return buf;
	}

	/**
	 * ボタンを作成.
	 * 
	 * @param piBean
	 *            受払合計表Bean
	 * @param piCommonBean
	 *            LACS共通Bean
	 * @return ボタン
	 */
	public static String outHTMLButton(LACSUkebaraiBean piBean, LACSCommonBean piCommonBean) {

		StringBuffer buf = new StringBuffer();
		LACSDispControlBean dispControlBean = piCommonBean.getDispControl();

		if (dispControlBean.isAvailableAny(new String[]{ "P0000021", "P0000022", "P0000023", "P0000024" })) {
			buf.append("				<input type=\"button\" class=\"button\" value=\"帳票印刷\" onclick=\"setWaitScreenUKB();execSubmit('print');post('pdfprint.ukebarai')\" name=\"print\"  />" + "\n");
			buf.append("				<input type=\"button\" class=\"button\" value=\"CSV作成\" onclick=\"setWaitScreenUKB();execSubmit('print');post('csvprint.ukebarai')\" name=\"print\" />" + "\n");
		}
		return buf.toString();
	}

}
