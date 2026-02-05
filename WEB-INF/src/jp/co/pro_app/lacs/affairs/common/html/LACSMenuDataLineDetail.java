package jp.co.pro_app.lacs.affairs.common.html;

/**
 * メニュー詳細データ.
 * 
 * @author katoken
 * @version 20071205
 */
public class LACSMenuDataLineDetail {

	private String	dispID		= "";	// 画面ID

	private String	dispName	= "";	// 画面名

	private String	url			= "";	// 遷移先URL

	private boolean	showUser	= true; // 表示権限(リースユーザー)

	private boolean	showCompany	= true; // 表示権限(リース会社)

	private boolean	showAdmin	= true; // 表示権限(管理者)

	private int		actionMode	= 0;	// アクションモード(0:画面遷移／1:新規ウィンドウ)

	/**
	 * コンストラクタ.
	 * 
	 * @param piDispId
	 *            画面ID
	 * @param piActionMode
	 *            アクションモード
	 * @param piDispName
	 *            画面名
	 * @param piURL
	 *            遷移先URL
	 * @param piShowUser
	 *            表示権限(リースユーザー)
	 * @param piShowCompany
	 *            表示権限(リース会社)
	 * @param piShowAdmin
	 *            表示権限(管理者)
	 */
	public LACSMenuDataLineDetail(String piDispId, int piActionMode, String piDispName, String piURL, boolean piShowUser, boolean piShowCompany, boolean piShowAdmin) {
		this.dispID = piDispId;
		this.dispName = piDispName;
		this.url = piURL;
		this.showUser = piShowUser;
		this.showCompany = piShowCompany;
		this.showAdmin = piShowAdmin;
		this.actionMode = piActionMode;
	}

	/**
	 * 画面IDを取得.
	 * 
	 * @return 画面ID
	 */
	public String getDispID() {
		return this.dispID;
	}

	/**
	 * 画面名を取得.
	 * 
	 * @return 画面名
	 */
	public String getDispName() {
		return this.dispName;
	}

	/**
	 * 遷移先URLを取得.
	 * 
	 * @return 遷移先URL
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * 表示権限を取得.
	 * 
	 * @return 表示権限
	 */
	public int getSecurity() {
		return (1 * (this.showUser ? 1 : 0)) + (2 * (this.showCompany ? 1 : 0)) + (4 * (this.showAdmin ? 1 : 0));
	}

	/**
	 * 遷移先アクションモードを取得.
	 * 
	 * @return アクションモード
	 */
	public int getActionMode() {
		return this.actionMode;
	}
}
