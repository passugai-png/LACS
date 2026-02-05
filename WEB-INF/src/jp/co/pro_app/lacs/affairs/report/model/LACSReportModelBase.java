package jp.co.pro_app.lacs.affairs.report.model;

import java.sql.SQLException;
import java.util.Date;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSComboMaker;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSOptionEntity;
import jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;
import jp.co.pro_app.projframe.common.command.DateUtl;

/**
 * 帳票出力Modelスーパークラス.
 * 
 * @author takeda
 * @version 20070817
 */
public abstract class LACSReportModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "注記帳票出力";
	}

	/**
	 * 業務個別処理.
	 * 
	 * @throws Exception
	 *             例外発生時.
	 */
	public void performSub() throws Exception {
		LACSCommonBean commonBean = super.getCommonBean();

		LACSReportBean printBean = super.getReportBean();
		this.start(printBean);

		commonBean.setDispID("R001");
		this.getUserInfo(commonBean);

		this.init(printBean);
		this.initSub(printBean);
		this.businessProc(printBean);

		super.setForwardPath("/jsp/R001.jsp");
		super.getLogger().end();
	}

	/**
	 * 処理開始ログ出力.
	 * 
	 * @param piPrintBean
	 *            月次帳票出力Bean
	 */
	protected void start(LACSReportBean piPrintBean) {
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
	protected void businessProc(LACSReportBean piReportBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piReportBean
	 *            帳票出力Bean
	 */
	protected final void init(LACSReportBean piReportBean) {
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
	protected void initSub(LACSReportBean piReportBean) throws Exception {
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
	protected void prepareComoboBox(LACSReportBean piReportBean) throws SQLException {
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
			optionEntity.setOptionCode(LACSDefine.OptionCode.TYUKI_COMMENT);
			optionEntity.execSQL();

			if (optionEntity.next()) {
				piCommonBean.setShowTyukiComment(optionEntity.getOptionValue());
			}

			optionEntity.setOptionCode(LACSDefine.OptionCode.GOKEI_DSP);
			optionEntity.execSQL();

			if (optionEntity.next()) {
				piCommonBean.setControlGokeiDsp(optionEntity.getOptionValue());
			}
		}
		finally {
			optionEntity.close();
		}
	}

}
