package jp.co.pro_app.lacs.affairs.monthreport.model;

import java.sql.SQLException;
import java.util.Date;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSOptionEntity;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;
import jp.co.pro_app.projframe.common.command.DateUtl;

/**
 * 月次帳票出力Modelスーパークラス.
 * 
 * @author yamaguchi
 * @version 20080408
 */
public abstract class LACSMReportModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "月次帳票出力";
	}

	/**
	 * 業務個別処理.
	 * 
	 * @throws Exception
	 *             例外発生時.
	 */
	public void performSub() throws Exception {
		super.getLogger().start();
		LACSCommonBean commonBean = super.getCommonBean();

		LACSMReportBean printBean = super.getMReportBean();
		this.start(printBean);

		commonBean.setDispID("R002");
		this.getUserInfo(commonBean);

		this.init(printBean);
		this.initSub(printBean);
		this.businessProc(printBean);

		super.setForwardPath("/jsp/R002.jsp");
		super.getLogger().end();
	
	}

	/**
	 * 処理開始ログ出力.
	 * 
	 * @param piPrintBean
	 *            月次帳票出力Bean
	 */
	protected void start(LACSMReportBean piPrintBean) {
		super.getLogger().start();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSMReportBean piReportBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 */
	protected final void init(LACSMReportBean piReportBean) {
		piReportBean.clearList();
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @exception Exception
	 *                例外発生時
	 */
	protected void initSub(LACSMReportBean piReportBean) throws Exception {
		return;
	}

	/**
	 * コンボボックス生成.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 * @throws SQLException
	 *             SQL実行例外
	 */
	protected void prepareComoboBox(LACSMReportBean piReportBean) throws SQLException {
		LACSComboMaker.makeCombo(piReportBean, super.getCommonBean(), super.con, this, false);
	}

	/**
	 * 期首年初期値取得.
	 * 
	 * @return 期首年
	 */
	protected static String getDefaultKisyuYear() {
		String result = "";
		if (DateUtl.getMonth(new Date()) < 4) {
			result = Integer.toString(DateUtl.getYear(new Date()) - 1);
		}
		else {
			result = Integer.toString(DateUtl.getYear(new Date()));
		}

		return result;
	}

	/**
	 * オプションを設定.
	 * 
	 * @param piCommonBean
	 *            リース会社マスタBean
	 * @exception Exception
	 *                例外発生時
	 */
	private void getUserInfo(LACSCommonBean piCommonBean) throws Exception {
		LACSOptionEntity optionEntity = new LACSOptionEntity(this);

		try {

			optionEntity.setCon(super.con);
			optionEntity.setOptionCode(LACSDefine.OptionCode.SISAN_DSP);
			optionEntity.execSQL();

			if (optionEntity.next()) {
				piCommonBean.setControlSisanDsp(optionEntity.getOptionValue());
			}

			optionEntity.setOptionCode(LACSDefine.OptionCode.SYOUHIZEI_DSP);
			optionEntity.execSQL();

			if (optionEntity.next()) {
				piCommonBean.setControlSyouhizeiDsp(optionEntity.getOptionValue());
			}
		}
		finally {
			optionEntity.close();
		}
	}
}
