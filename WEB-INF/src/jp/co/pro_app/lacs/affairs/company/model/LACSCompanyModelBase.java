package jp.co.pro_app.lacs.affairs.company.model;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSDispControlCommon;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSOptionEntity;
import jp.co.pro_app.lacs.affairs.company.bean.LACSCompanyBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;

/**
 * リース会社マスタスーパークラス.
 * 
 * @author takeda
 * @version 20070904
 */
public abstract class LACSCompanyModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "リース会社メンテナンス";
	}

	/**
	 * LACS用権限制御共通部品.
	 */
	protected LACSDispControlCommon	dispControlCommon	= null;

	/**
	 * 業務個別処理.
	 * 
	 * @throws Exception
	 *             例外発生時.
	 */
	public final void performSub() throws Exception {
		super.getLogger().start();
		LACSCommonBean commonBean = super.getCommonBean();

		LACSCompanyBean companyBean = super.getCompanyBean();

		commonBean.setDispID("C001");
		dispControlCommon = new LACSDispControlCommon(companyBean.getDispControl(), this, this.con);

		this.init(companyBean);
		this.initSub(companyBean);
		this.getUserInfo(commonBean);

		this.businessProc(companyBean);
		super.getLogger().end();
	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piCompanyBean
	 *            リース会社マスタBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected abstract void businessProc(LACSCompanyBean piCompanyBean) throws Exception;

	/**
	 * 初期化.
	 * 
	 * @param piCompanyBean
	 *            リース会社マスタBean
	 */
	protected final void init(LACSCompanyBean piCompanyBean) {
		piCompanyBean.setMessage("");
		piCompanyBean.setLeasCompanyCode(super.getInput("targetCompanyCode", "").trim());
		piCompanyBean.setCondCompanyCode(super.getInput("condCompanyCode", "").trim());
		piCompanyBean.setProcMode(super.getParam("procMode", 0));
	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piCompanyBean
	 *            リース会社マスタBean
	 * @exception Exception
	 *                例外発生時
	 */
	protected abstract void initSub(LACSCompanyBean piCompanyBean) throws Exception;

	/**
	 * コンボボックス生成.
	 * 
	 * @param piCompanyBean
	 *            リース会社マスタBean
	 */
	protected void prepareComoboBox(LACSCompanyBean piCompanyBean) {
		return;
	}

	/**
	 * 注記書類作成基準書可変文言表示権限を設定.
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

		}
		finally {
			optionEntity.close();
		}
	}

}
