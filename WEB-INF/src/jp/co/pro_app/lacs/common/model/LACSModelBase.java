package jp.co.pro_app.lacs.common.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.bukken.bean.LACSBukkenBean;
import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.common.command.LACSLoginSecurity;
import jp.co.pro_app.lacs.affairs.common.command.LACSMessage;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSLoginCompanyEntity;
import jp.co.pro_app.lacs.affairs.company.bean.LACSCompanyBean;
import jp.co.pro_app.lacs.affairs.companylist.bean.LACSCompanyListBean;
import jp.co.pro_app.lacs.affairs.companyuser.bean.LACSCompanyUserBean;
import jp.co.pro_app.lacs.affairs.companyuserlist.bean.LACSCompanyUserListBean;
import jp.co.pro_app.lacs.affairs.dsreport.bean.LACSDSReportBean;
import jp.co.pro_app.lacs.affairs.info.bean.LACSInfoBean;
import jp.co.pro_app.lacs.affairs.infolist.bean.LACSInfoListBean;
import jp.co.pro_app.lacs.affairs.karirisi.bean.LACSKariRisiBean;
import jp.co.pro_app.lacs.affairs.karirisilist.bean.LACSKariRisiListBean;
import jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuBean;
import jp.co.pro_app.lacs.affairs.login.bean.LACSLoginBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.affairs.password.bean.LACSPasswordBean;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.affairs.shiharai.bean.LACSShiharaiBean;
import jp.co.pro_app.lacs.affairs.shiwake.bean.LACSShiwakeBean;
import jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiBean;
import jp.co.pro_app.lacs.affairs.tanto.bean.LACSTantoBean;
import jp.co.pro_app.lacs.affairs.tantolist.bean.LACSTantoListBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.affairs.user.bean.LACSUserBean;
import jp.co.pro_app.lacs.affairs.userlist.bean.LACSUserListBean;
import jp.co.pro_app.lacs.common.data.entity.LACSBatchProcEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.log.LACSLog;
import jp.co.pro_app.projframe.common.bean.ExceptionBean;
import jp.co.pro_app.projframe.common.model.CustomDBModelBase;

/**
 * LACSModelスーパークラス.
 * 
 * @author katoken
 * @version 20070312
 */
public abstract class LACSModelBase extends CustomDBModelBase {

	/**
	 * メッセージオブジェクト.
	 */
	protected LACSMessage	message	= null;

	/**
	 * 共通情報Beanを取得.
	 * 
	 * @return 共通情報Bean
	 */
	public LACSCommonBean getCommonBean() {
		LACSCommonBean commonBean = (LACSCommonBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.COMMON_BEAN);

		if (commonBean == null) {
			commonBean = new LACSCommonBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.COMMON_BEAN, commonBean);
		}

		return commonBean;
	}

	/**
	 * 支払推移表Beanを取得.
	 * 
	 * @return 支払推移表Bean
	 */
	public LACSShiharaiBean getShiharaiBean() {
		LACSShiharaiBean shiharaiBean = (LACSShiharaiBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.SHIHARAI_BEAN);

		if (shiharaiBean == null) {
			shiharaiBean = new LACSShiharaiBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.SHIHARAI_BEAN, shiharaiBean);
		}

		return shiharaiBean;
	}

	/**
	 * 仕訳照会Beanを取得.
	 * 
	 * @return 仕訳照会Bean
	 */
	public LACSShiwakeBean getShiwakeBean() {
		LACSShiwakeBean shiwakeBean = (LACSShiwakeBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.SHIWAKE_BEAN);

		if (shiwakeBean == null) {
			shiwakeBean = new LACSShiwakeBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.SHIWAKE_BEAN, shiwakeBean);
		}

		return shiwakeBean;
	}

	/**
	 * 契約検索Beanを取得.
	 * 
	 * @return 契約検索Bean
	 */
	public LACSKeiyakuBean getKeiyakuBean() {
		LACSKeiyakuBean keiyakuBean = (LACSKeiyakuBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.KEIYAKU_BEAN);

		if (keiyakuBean == null) {
			keiyakuBean = new LACSKeiyakuBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.KEIYAKU_BEAN, keiyakuBean);
		}

		return keiyakuBean;
	}

	/**
	 * 物件検索Beanを取得.
	 * 
	 * @return 物件検索Bean
	 */
	public LACSBukkenBean getBukkenBean() {
		LACSBukkenBean bukkenBean = (LACSBukkenBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.BUKKEN_BEAN);

		if (bukkenBean == null) {
			bukkenBean = new LACSBukkenBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.BUKKEN_BEAN, bukkenBean);
		}

		return bukkenBean;
	}

	/**
	 * 帳票出力Beanを取得.
	 * 
	 * @return 帳票出力Bean
	 */
	public LACSReportBean getReportBean() {
		LACSReportBean reportBean = (LACSReportBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.REPORT_BEAN);

		if (reportBean == null) {
			reportBean = new LACSReportBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.REPORT_BEAN, reportBean);
		}

		return reportBean;
	}

	/**
	 * 帳票出力Beanを取得.
	 * 
	 * @return 帳票出力Bean
	 */
	public LACSDSReportBean getDSReportBean() {
		LACSDSReportBean reportBean = (LACSDSReportBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.DS_REPORT_BEAN);

		if (reportBean == null) {
			reportBean = new LACSDSReportBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.DS_REPORT_BEAN, reportBean);
		}

		return reportBean;
	}

	/**
	 * リース会社マスタBeanを取得.
	 * 
	 * @return リース会社マスタBean
	 */
	public LACSCompanyBean getCompanyBean() {
		LACSCompanyBean companyBean = (LACSCompanyBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.COMPANY_BEAN);

		if (companyBean == null) {
			companyBean = new LACSCompanyBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.COMPANY_BEAN, companyBean);
		}

		return companyBean;
	}

	/**
	 * リース会社別リースユーザーマスタBeanを取得.
	 * 
	 * @return リース会社別リースユーザーマスタBean
	 */
	public LACSCompanyUserBean getCompanyUserBean() {
		LACSCompanyUserBean companyUserBean = (LACSCompanyUserBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.COMPANYUSER_BEAN);

		if (companyUserBean == null) {
			companyUserBean = new LACSCompanyUserBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.COMPANYUSER_BEAN, companyUserBean);
		}

		return companyUserBean;
	}

	/**
	 * リースユーザーマスタBeanを取得.
	 * 
	 * @return リースユーザーマスタBean
	 */
	public LACSUserBean getUserBean() {
		LACSUserBean userBean = (LACSUserBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.USER_BEAN);

		if (userBean == null) {
			userBean = new LACSUserBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.USER_BEAN, userBean);
		}

		return userBean;
	}

	/**
	 * リースユーザー別借入利子率マスタBeanを取得.
	 * 
	 * @return リースユーザー別借入利子率マスタBean
	 */
	public LACSKariRisiBean getKariRisiBean() {
		LACSKariRisiBean kariRisiBean = (LACSKariRisiBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.KARI_RISI_BEAN);

		if (kariRisiBean == null) {
			kariRisiBean = new LACSKariRisiBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.KARI_RISI_BEAN, kariRisiBean);
		}

		return kariRisiBean;
	}

	/**
	 * リースユーザー担当者マスタBeanを取得.
	 * 
	 * @return リースユーザー担当者マスタBean
	 */
	public LACSTantoBean getTantoBean() {
		LACSTantoBean tantoBean = (LACSTantoBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.TANTO_BEAN);

		if (tantoBean == null) {
			tantoBean = new LACSTantoBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.TANTO_BEAN, tantoBean);
		}

		return tantoBean;
	}

	/**
	 * リース会社マスタ一覧Beanを取得.
	 * 
	 * @return リース会社マスタ一覧Bean
	 */
	public LACSCompanyListBean getCompanyListBean() {
		LACSCompanyListBean companyListBean = (LACSCompanyListBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.COMPANY_LIST_BEAN);

		if (companyListBean == null) {
			companyListBean = new LACSCompanyListBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.COMPANY_LIST_BEAN, companyListBean);
		}

		return companyListBean;
	}

	/**
	 * リース会社別リースユーザーマスタ一覧Beanを取得.
	 * 
	 * @return リース会社別リースユーザーマスタ一覧Bean
	 */
	public LACSCompanyUserListBean getCompanyUserListBean() {
		LACSCompanyUserListBean companyUserListBean = (LACSCompanyUserListBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.COMPANY_USER_LIST_BEAN);

		if (companyUserListBean == null) {
			companyUserListBean = new LACSCompanyUserListBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.COMPANY_USER_LIST_BEAN, companyUserListBean);
		}

		return companyUserListBean;
	}

	/**
	 * リースユーザーマスタ一覧Beanを取得.
	 * 
	 * @return リースユーザーマスタ一覧Bean
	 */
	public LACSUserListBean getUserListBean() {
		LACSUserListBean userListBean = (LACSUserListBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.USER_LIST_BEAN);

		if (userListBean == null) {
			userListBean = new LACSUserListBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.USER_LIST_BEAN, userListBean);
		}

		return userListBean;
	}

	/**
	 * リースユーザー担当者マスタ一覧Beanを取得.
	 * 
	 * @return リースユーザー担当者マスタ一覧Bean
	 */
	public LACSTantoListBean getTantoListBean() {
		LACSTantoListBean tantoListBean = (LACSTantoListBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.TANTO_LIST_BEAN);

		if (tantoListBean == null) {
			tantoListBean = new LACSTantoListBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.TANTO_LIST_BEAN, tantoListBean);
		}

		return tantoListBean;
	}

	/**
	 * リースユーザー別借入利子率マスタ一覧Beanを取得.
	 * 
	 * @return リースユーザー別借入利子率マスタ一覧Bean
	 */
	public LACSKariRisiListBean getKariRisiListBean() {
		LACSKariRisiListBean kariRisiListBean = (LACSKariRisiListBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.KARI_RISI_LIST_BEAN);

		if (kariRisiListBean == null) {
			kariRisiListBean = new LACSKariRisiListBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.KARI_RISI_LIST_BEAN, kariRisiListBean);
		}

		return kariRisiListBean;
	}

	/**
	 * 月次帳票出力Beanを取得.
	 * 
	 * @return 帳票出力Bean
	 */
	public LACSMReportBean getMReportBean() {
		LACSMReportBean reportBean = (LACSMReportBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.MREPORT_BEAN);

		if (reportBean == null) {
			reportBean = new LACSMReportBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.MREPORT_BEAN, reportBean);
		}
		return reportBean;
	}

	/**
	 * お知らせBeanを取得.
	 * 
	 * @return お知らせBean
	 */
	public LACSInfoBean getInfoBean() {
		LACSInfoBean infoBean = (LACSInfoBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.INFO_BEAN);

		if (infoBean == null) {
			infoBean = new LACSInfoBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.INFO_BEAN, infoBean);
		}

		return infoBean;
	}

	/**
	 * お知らせ一覧Beanを取得.
	 * 
	 * @return お知らせ一覧Bean
	 */
	public LACSInfoListBean getInfoListBean() {
		LACSInfoListBean infoListBean = (LACSInfoListBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.INFO_LIST_BEAN);

		if (infoListBean == null) {
			infoListBean = new LACSInfoListBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.INFO_LIST_BEAN, infoListBean);
		}

		return infoListBean;
	}

	/**
	 * 受払合計表Beanを取得.
	 * 
	 * @return 受払合計表Bean
	 */
	public LACSUkebaraiBean getUkebaraiBean() {
		LACSUkebaraiBean ukebaraiBean = (LACSUkebaraiBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.UKEBARAI_BEAN);

		if (ukebaraiBean == null) {
			ukebaraiBean = new LACSUkebaraiBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.UKEBARAI_BEAN, ukebaraiBean);
		}

		return ukebaraiBean;
	}

	/**
	 * 契約詳細Beanを取得.
	 * 
	 * @return 契約詳細Bean
	 */
	public LACSSyousaiBean getSyousaiBean() {
		LACSSyousaiBean syousaiBean = (LACSSyousaiBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.SYOUSAI_BEAN);

		if (syousaiBean == null) {
			syousaiBean = new LACSSyousaiBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.SYOUSAI_BEAN, syousaiBean);
		}

		return syousaiBean;
	}

	/**
	 * ログインBeanを取得.
	 * 
	 * @return ログインBean
	 */
	public LACSLoginBean getLoginBean() {
		LACSLoginBean loginBean = (LACSLoginBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.LOGIN_BEAN);

		if (loginBean == null) {
			loginBean = new LACSLoginBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.LOGIN_BEAN, loginBean);
		}

		return loginBean;
	}

	/**
	 * パスワード変更Beanを取得.
	 * 
	 * @return パスワード変更Bean
	 */
	public LACSPasswordBean getPasswordBean() {
		LACSPasswordBean passwordBean = (LACSPasswordBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.PASSWORD_BEAN);

		if (passwordBean == null) {
			passwordBean = new LACSPasswordBean();

			super.getRequest().getSession().setAttribute(LACSDefine.BeanName.PASSWORD_BEAN, passwordBean);
		}

		return passwordBean;
	}

	/**
	 * セッションチェックフラグ取得.
	 * 
	 * @return セッションチェックを行うか
	 * @throws SQLException
	 *             SQL実行例外
	 */
	protected boolean checkSession() throws SQLException {
		boolean result = true;
		LACSCommonBean commonBean = (LACSCommonBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.COMMON_BEAN);

		if (commonBean == null) {
			result = false;
		}
		else {
			LACSLoginSecurity security = new LACSLoginSecurity(this, super.con, commonBean.getLoginUserId());
			if (security.checkLogin(commonBean.getOneTimePassword())) {
				security.access();
			}
			else {
				result = false;
			}
		}

		return result;
	}

	/**
	 * 業務処理.
	 * 
	 * @exception Exception
	 *                例外発生時
	 */
	public void perform() throws Exception {

		try {
			boolean result = true;
			boolean executeMain = true;

			if (!ignoreBatchExecute()) {
				if (this.checkBatchExecute()) {
					if (this.getCommonBean().getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER) {
						super.setForwardPath("/menu.top");
						executeMain = false;
					}
					else {
						new LACSLoginSecurity(this, this.con, this.getCommonBean().getLoginUserId()).delete();
						throw new Exception("現在バッチ処理中です。<br>しばらくしてから再度お試し下さい。");
					}
				}
			}

			if (this.isSessionCheck()) {
				result = this.checkSession();
			}

			if (executeMain) {
				if (result) {
					message = LACSMessage.createLACSMessage(this, super.con);
					this.performSub();
					this.action();
					getSyoriYM();

				}
				else {
					super.setForwardPath("/jsp/M003.jsp");
				}
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
			ExceptionBean exceptionBean = new ExceptionBean("システムエラー発生", ex, true);

			StackTraceElement[] stack = ex.getStackTrace();
			int errorNo = ExceptionBean.getErrorNo();
			String errorMessage = ex.getMessage();
			if (errorMessage != null) {

				if (errorMessage.endsWith("\n")) {
					errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
				}
				if (errorMessage.endsWith("\r")) {
					errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
				}

				this.getLogger().error("システムエラー発生(" + errorNo + ")", errorMessage);
				if (stack != null) {
					for (int i = 0; i < stack.length; i++) {
						this.getLogger().error("システムエラー発生(" + errorNo + ")", stack[i].toString());
					}
				}
			}
			else {
				this.getLogger().error("システムエラー発生(" + errorNo + ")", "");
				if (stack != null) {
					for (int i = 0; i < stack.length; i++) {
						this.getLogger().error("システムエラー発生(" + errorNo + ")", stack[i].toString());
					}
				}
			}

			super.setBean(exceptionBean);
			super.setForwardPath("/jsp/sysErr.jsp");
		}
	}

	/**
	 * 業務個別処理.
	 * 
	 * @throws Exception
	 *             例外発生時.
	 */
	protected abstract void performSub() throws Exception;

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public abstract String getProcName();

	/**
	 * 処理名を取得.
	 * 
	 * @return 処理名
	 */
	public abstract String getProcSubName();

	/**
	 * ロガーを取得.
	 * 
	 * @return ロガー
	 */
	protected LACSLog getLogger() {
		return new LACSLog(this.getServlet(), /* this.getCommonBean().getLogName(), */this, this.getProcName() + "：" + this.getProcSubName(), (LACSCommonBean)super.getRequest().getSession().getAttribute(LACSDefine.BeanName.COMMON_BEAN));
	}

	/**
	 * バッチ処理中チェック.
	 * 
	 * @return バッチ処理フラグ
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public boolean checkBatchExecute() throws SQLException {
		LACSBatchProcEntity entity = new LACSBatchProcEntity(this);
		boolean result = false;

		try {
			entity.setCon(super.con);

			if (entity.execSQL() != 0) {
				result = true;
			}
		}
		finally {
			entity.close();
		}

		return result;
	}

	private void getSyoriYM() throws SQLException {
		LACSLoginCompanyEntity loginCompanyEntity = new LACSLoginCompanyEntity(this);
		LACSCommonBean commonBean = getCommonBean();

		try {
			loginCompanyEntity.setCon(super.con);

			loginCompanyEntity.setCompanyCode(commonBean.getCompanyCode());

			loginCompanyEntity.execSQL();

			if (loginCompanyEntity.next()) {
				if (loginCompanyEntity.getShoriYM() != null) {
					commonBean.setShoriYMD((LACSCommand.toDateYYYYMM(commonBean, super.con, this, loginCompanyEntity.getShoriYM() + "01")));
				}
			}
		}
		finally {
			loginCompanyEntity.close();
		}
	}

	/**
	 * バッチ実行中無視フラグ.
	 * 
	 * @return true：無視／false：チェックする
	 */
	protected boolean ignoreBatchExecute() {
		return false;
	}

	/**
	 * アクションログ書き出し.
	 */
	protected void action() {
		this.getLogger().action();
	}
}
