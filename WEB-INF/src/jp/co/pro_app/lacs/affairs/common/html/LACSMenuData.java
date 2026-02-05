package jp.co.pro_app.lacs.affairs.common.html;

import java.util.ArrayList;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSDispControlBean;
import jp.co.pro_app.lacs.common.define.LACSCustomizeDefine;
import jp.co.pro_app.lacs.common.define.LACSDefine;

/**
 * メニューデータ.
 * 
 * @author katoken
 * @version 20071205
 */
public class LACSMenuData {

	private ArrayList<LACSMenuDataLine>	list	= new ArrayList<LACSMenuDataLine>();

	/**
	 * メニュー要素数を取得.
	 * 
	 * @return メニュー要素数
	 */
	public int size() {
		return list.size();
	}

	/**
	 * メニュー行データを追加.
	 * 
	 * @param piDetail
	 *            メニュー行データ
	 */
	public void add(LACSMenuDataLine piDetail) {
		list.add(piDetail);
	}

	/**
	 * メニュー行細データを取得.
	 * 
	 * @param piIdx
	 *            要素番号
	 * @return メニュー行データ
	 */
	public LACSMenuDataLine get(int piIdx) {
		return (LACSMenuDataLine)list.get(piIdx);
	}

	/**
	 * メニューの初期化.
	 * 
	 * @param piCommonBean
	 *            LACS用共通Bean
	 */
	private void init(LACSCommonBean piCommonBean) {

		LACSMenuDataLine line = null;
		LACSDispControlBean dispControlBean = piCommonBean.getDispControl();

		line = new LACSMenuDataLine(false);
		this.list.add(line);
		line.add(new LACSMenuDataLineDetail("M002", 0, "処理メニュー", "menu.top", true, true, true));
		line.add(new LACSMenuDataLineDetail("O000", 0, "ログアウト", "logout.login", true, true, true));
		line.add(new LACSMenuDataLineDetail("USERHELP", 1, "ヘルプ", "../USERHELP/index.html", true, false, false));

		line = new LACSMenuDataLine(true);
		this.list.add(line);
		line.add(new LACSMenuDataLineDetail("S001", 0, "支払推移表", "start.shiharai", dispControlBean.isAvailable("G0000001"), true, true));
		line.add(new LACSMenuDataLineDetail("S002", 0, "仕訳照会", "start.shiwake", dispControlBean.isAvailable("G0000002"), true, true));
		line.add(new LACSMenuDataLineDetail("K001", 0, "契約検索", "start.keiyaku", dispControlBean.isAvailable("G0000003"), true, true));
		line.add(new LACSMenuDataLineDetail("K002", 0, "物件検索", "start.bukken", dispControlBean.isAvailable("G0000004"), true, true));
		line.add(new LACSMenuDataLineDetail("R001", 0, "注記帳票出力", "start.report", dispControlBean.isAvailable("G0000005"), true, true));
		line.add(new LACSMenuDataLineDetail("R002", 0, "月次帳票出力", "start.monthreport", dispControlBean.isAvailable("G0000006"), true, true));
		line.add(new LACSMenuDataLineDetail("U002", 0, "受払合計表", "start.ukebarai", dispControlBean.isAvailable("G0000007"), true, true));

		line = new LACSMenuDataLine(true);
		this.list.add(line);
		line.add(new LACSMenuDataLineDetail("C001", 0, "ﾘｰｽ会社", "start.companylist", false, false, true));
		line.add(new LACSMenuDataLineDetail("C002", 0, "顧客別開示先", "start.companyuserlist", false, false, true));
		line.add(new LACSMenuDataLineDetail("U001", 0, "開示先", "start.userlist", false, false, true));
		line.add(new LACSMenuDataLineDetail("K003", 0, "借入利子率", "start.karirisilist", false, false, true));
		line.add(new LACSMenuDataLineDetail("T001", 0, "担当者", "start.tantolist", false, false, true));
		line.add(new LACSMenuDataLineDetail("I001", 0, "お知らせ", "start.infolist", false, false, true));
		line.add(new LACSMenuDataLineDetail("R003", 0, "貸手向け帳票", "start.dsreport", false, false, dispControlBean.isAvailable(LACSCustomizeDefine.DispContorolId.DISP_ID_CUSTUMIZE_1)));
		// line.add(new LACSMenuDataLineDetail("R004", 0, "注記合計表印刷予約", "start.nsreport", false, true, true));
		// line.add(new LACSMenuDataLineDetail("K006", 0, "強制変更一覧", "start.compulsorychange", false, true, true));
	}

	/**
	 * コンストラクタ.
	 */
	private LACSMenuData() {
	}

	/**
	 * メニューデータを取得.
	 * 
	 * @param piCommonBean
	 *            LACS共通Bean
	 * @param piShowHeader
	 *            ヘッダ用情報取得フラグ
	 * @return メニューデータ
	 */
	public static LACSMenuData getData(LACSCommonBean piCommonBean, boolean piShowHeader) {
		LACSMenuData data = new LACSMenuData();
		LACSMenuDataLine line = null;
		LACSMenuDataLineDetail detail = null;

		LACSMenuData newData = new LACSMenuData();
		LACSMenuDataLine newLine = null;

		int security = 0;

		switch (piCommonBean.getAppMode()) {

			case LACSDefine.AppMode.APP_MODE_COMPANY:

				switch (piCommonBean.getMenuMode()) {
					case LACSDefine.MenuMode.MENU_MODE_OFFICE:
						security = 2;
						break;
					default:
						security = 4;
						break;
				}

				break;
			case LACSDefine.AppMode.APP_MODE_FIXED_USER:
				security = 1;
				break;
			default:
				security = 4;
				break;
		}

		data.init(piCommonBean);

		for (int i = 0; i < data.size(); i++) {
			line = data.get(i);
			newLine = new LACSMenuDataLine(line.isShowButton());

			if (newLine.isShowButton() || piShowHeader) {
				for (int j = 0; j < line.size(); j++) {
					detail = line.get(j);

					if ((detail.getSecurity() & security) == security) {

						if (detail.getDispID().equals("USERHELP") && "0".equals(piCommonBean.getShowUserHelp())) {
							continue;
						}

						newLine.add(detail);
					}
				}

				if (newLine.size() > 0) {
					newData.add(newLine);
				}
			}
		}

		return newData;
	}
}
