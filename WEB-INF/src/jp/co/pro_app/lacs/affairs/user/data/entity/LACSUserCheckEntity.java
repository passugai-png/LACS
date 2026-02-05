package jp.co.pro_app.lacs.affairs.user.data.entity;

import jp.co.pro_app.lacs.affairs.user.bean.LACSUserBean;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * リースユーザーマスタEntity.
 * 
 * @author yokota
 * @version 20080709
 */
public class LACSUserCheckEntity extends EntityBase {

	/**
	 * 利子率の精度.
	 */
	protected String	syosuKetasu				= "";	// 利子率の精度

	/**
	 * 旧会計基準-所有権移転有形償却方法コード.
	 */
	protected String	oldItenYukeiSkkHohoCd	= "";	// 旧会計基準-所有権移転有形償却方法コード

	/**
	 * 旧会計基準-所有権移転無形償却方法コード.
	 */
	protected String	oldItenMukeiSkkHohoCd	= "";	// 旧会計基準-所有権移転無形償却方法コード

	/**
	 * 旧会計基準-所有権移転外有形償却方法コード.
	 */
	protected String	oldItengiYukeiSkkHohoCd	= "";	// 旧会計基準-所有権移転外有形償却方法コード

	/**
	 * 旧会計基準-所有権移転外無形償却方法コード.
	 */
	protected String	oldItengiMukeiSkkHohoCd	= "";	// 旧会計基準-所有権移転外無形償却方法コード

	/**
	 * 旧会計基準-前払後払区分.
	 */
	protected String	oldMbriAbriKbn			= "";	// 旧会計基準-前払後払区分

	/**
	 * 旧会計基準-利息計算方法コード.
	 */
	protected String	oldRskClcHohoCd			= "";	// 旧会計基準-利息計算方法コード

	/**
	 * 旧会計基準-賦金展開方法コード.
	 */
	protected String	oldFknTnkiHohoCd		= "";	// 旧会計基準-賦金展開方法コード

	/**
	 * 旧会計基準-維持管理費重要性区分.
	 */
	protected String	oldIjiKnriHyoJyoKbn		= "";	// 旧会計基準-維持管理費重要性区分

	/**
	 * 旧会計基準-役務提供費用重要性区分.
	 */
	protected String	oldEkmTeikHyoJyoKbn		= "";	// 旧会計基準-役務提供費用重要性区分

	/**
	 * 旧会計基準-減価償却端数調整コード.
	 */
	protected String	oldGnkskHasuChseCd		= "";	// 旧会計基準-減価償却端数調整コード

	/**
	 * 旧会計基準-賦金展開調整コード.
	 */
	protected String	oldFknTnkiHasuChseCd	= "";	// 旧会計基準-賦金展開調整コード

	/**
	 * 旧会計基準-購入額通知有無フラグ.
	 */
	protected String	oldKnuAmtTutiUmFlg		= "";	// 旧会計基準-購入額通知有無フラグ

	/**
	 * 新会計基準-所有権移転有形償却方法コード.
	 */
	protected String	newItenYukeiSkkHohoCd	= "";	// 新会計基準-所有権移転有形償却方法コード

	/**
	 * 新会計基準-所有権移転無形償却方法コード.
	 */
	protected String	newItenMukeiSkkHohoCd	= "";	// 新会計基準-所有権移転無形償却方法コード

	/**
	 * 新会計基準-所有権移転外有形償却方法コード.
	 */
	protected String	newItengiYukeiSkkHohoCd	= "";	// 新会計基準-所有権移転外有形償却方法コード

	/**
	 * 新会計基準-所有権移転外無形償却方法コード.
	 */
	protected String	newItengiMukeiSkkHohoCd	= "";	// 新会計基準-所有権移転外無形償却方法コード

	/**
	 * 新会計基準-前払後払区分.
	 */
	protected String	newMbriAbriKbn			= "";	// 新会計基準-前払後払区分

	/**
	 * 新会計基準-利息計算方法コード.
	 */
	protected String	newRskClcHohoCd			= "";	// 新会計基準-利息計算方法コード

	/**
	 * 新会計基準-賦金展開方法コード.
	 */
	protected String	newFknTnkiHohoCd		= "";	// 新会計基準-賦金展開方法コード

	/**
	 * 新会計基準-維持管理費重要性区分.
	 */
	protected String	newIjiKnriHyoJyoKbn		= "";	// 新会計基準-維持管理費重要性区分

	/**
	 * 新会計基準-役務提供費用重要性区分.
	 */
	protected String	newEkmTeikHyoJyoKbn		= "";	// 新会計基準-役務提供費用重要性区分

	/**
	 * 新会計基準-減価償却端数調整コード.
	 */
	protected String	newGnkskHasuChseCd		= "";	// 新会計基準-減価償却端数調整コード

	/**
	 * 新会計基準-賦金展開調整コード.
	 */
	protected String	newFknTnkiHasuChseCd	= "";	// 新会計基準-賦金展開調整コード

	/**
	 * 新会計基準-購入額通知有無フラグ.
	 */
	protected String	newKnuAmtTutiUmFlg		= "";	// 新会計基準-購入額通知有無フラグ

	/**
	 * リースユーザーマスタ コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 * @param piUserBean
	 *            LACSユーザーBean
	 */
	public LACSUserCheckEntity(DBModelBase piModel, LACSUserBean piUserBean) {
		super(piModel);

		oldMbriAbriKbn = LACSDefine.MaebaraiAtobaraiKbn.ATO_BARAI_1;
		newMbriAbriKbn = LACSDefine.MaebaraiAtobaraiKbn.ATO_BARAI_1;

		if (piUserBean.getOldRskClcHohoCd().getValue().equals(LACSDefine.RisokuKeijoHohoKbn.RSKHO_ZEN_GET_101)) {
			oldMbriAbriKbn = LACSDefine.MaebaraiAtobaraiKbn.MAE_BARAI_0;
		}

		if (piUserBean.getNewRskClcHohoCd().getValue().equals(LACSDefine.RisokuKeijoHohoKbn.RSKHO_ZEN_GET_101)) {
			newMbriAbriKbn = LACSDefine.MaebaraiAtobaraiKbn.MAE_BARAI_0;
		}

		this.syosuKetasu = Command.changeQt(piUserBean.getSyosuKetasu().getValue()); // 利子率の精度
		this.oldItenYukeiSkkHohoCd = Command.changeQt(piUserBean.getOldItenYukeiSkkHohoCd().getValue()); // 旧会計基準-所有権移転有形償却方法コード
		this.oldItenMukeiSkkHohoCd = Command.changeQt(piUserBean.getOldItenMukeiSkkHohoCd().getValue()); // 旧会計基準-所有権移転無形償却方法コード
		this.oldItengiYukeiSkkHohoCd = Command.changeQt(piUserBean.getOldItengiYukeiSkkHohoCd().getValue()); // 旧会計基準-所有権移転外有形償却方法コード
		this.oldItengiMukeiSkkHohoCd = Command.changeQt(piUserBean.getOldItengiMukeiSkkHohoCd().getValue()); // 旧会計基準-所有権移転外無形償却方法コード
		this.oldRskClcHohoCd = Command.changeQt(piUserBean.getOldRskClcHohoCd().getValue()); // 旧会計基準-利息計算方法コード
		this.oldFknTnkiHohoCd = Command.changeQt(piUserBean.getOldFknTnkiHohoCd().getValue()); // 旧会計基準-賦金展開方法コード
		this.oldIjiKnriHyoJyoKbn = Command.changeQt(piUserBean.getOldIjiKnriHyoJyoKbn().getValue()); // 旧会計基準-維持管理費重要性区分
		this.oldEkmTeikHyoJyoKbn = Command.changeQt(piUserBean.getOldEkmTeikHyoJyoKbn().getValue()); // 旧会計基準-役務提供費用重要性区分
		this.oldGnkskHasuChseCd = Command.changeQt(piUserBean.getOldGnkskHasuChseCd().getValue()); // 旧会計基準-減価償却端数調整コード
		this.oldFknTnkiHasuChseCd = Command.changeQt(piUserBean.getOldFknTnkiHasuChseCd().getValue()); // 旧会計基準-賦金展開調整コード
		this.oldKnuAmtTutiUmFlg = Command.changeQt(piUserBean.getOldKnuAmtTutiUmFlg()); // 旧会計基準-購入額通知有無フラグ
		this.newItenYukeiSkkHohoCd = Command.changeQt(piUserBean.getNewItenYukeiSkkHohoCd().getValue()); // 新会計基準-所有権移転有形償却方法コード
		this.newItenMukeiSkkHohoCd = Command.changeQt(piUserBean.getNewItenMukeiSkkHohoCd().getValue()); // 新会計基準-所有権移転無形償却方法コード
		this.newItengiYukeiSkkHohoCd = Command.changeQt(piUserBean.getNewItengiYukeiSkkHohoCd().getValue()); // 新会計基準-所有権移転外有形償却方法コード
		this.newItengiMukeiSkkHohoCd = Command.changeQt(piUserBean.getNewItengiMukeiSkkHohoCd().getValue()); // 新会計基準-所有権移転外無形償却方法コード
		this.newRskClcHohoCd = Command.changeQt(piUserBean.getNewRskClcHohoCd().getValue()); // 新会計基準-利息計算方法コード
		this.newFknTnkiHohoCd = Command.changeQt(piUserBean.getNewFknTnkiHohoCd().getValue()); // 新会計基準-賦金展開方法コード
		this.newIjiKnriHyoJyoKbn = Command.changeQt(piUserBean.getNewIjiKnriHyoJyoKbn().getValue()); // 新会計基準-維持管理費重要性区分
		this.newEkmTeikHyoJyoKbn = Command.changeQt(piUserBean.getNewEkmTeikHyoJyoKbn().getValue()); // 新会計基準-役務提供費用重要性区分
		this.newGnkskHasuChseCd = Command.changeQt(piUserBean.getNewGnkskHasuChseCd().getValue()); // 新会計基準-減価償却端数調整コード
		this.newFknTnkiHasuChseCd = Command.changeQt(piUserBean.getNewFknTnkiHasuChseCd().getValue()); // 新会計基準-賦金展開調整コード
		this.newKnuAmtTutiUmFlg = Command.changeQt(piUserBean.getNewKnuAmtTutiUmFlg()); // 新会計基準-購入額通知有無フラグ
	}

	private String	cosmosCode	= "";	// COSMOSコード

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT LU_COSMOS_CD " + "\n");
		super.sql.append("FROM   M_LU " + "\n");
		super.sql.append("WHERE  LU_COSMOS_CD = '" + Command.changeQt(this.cosmosCode) + "' AND " + "\n");
		super.sql.append("SYOSU_KETASU = '" + this.syosuKetasu + "' AND " + "\n"); // 利子率の精度
		super.sql.append("OLD_ITN_YUKEI_SKK_HOHO_CD = '" + this.oldItenYukeiSkkHohoCd + "' AND " + "\n"); // 旧会計基準-所有権移転有形償却方法コード
		super.sql.append("OLD_ITN_MUKEI_SKK_HOHO_CD = '" + this.oldItenMukeiSkkHohoCd + "' AND " + "\n"); // 旧会計基準-所有権移転無形償却方法コード
		super.sql.append("OLD_ITNGI_YUKEI_SKK_HOHO_CD = '" + this.oldItengiYukeiSkkHohoCd + "' AND " + "\n"); // 旧会計基準-所有権移転外有形償却方法コード
		super.sql.append("OLD_ITNGI_MUKEI_SKK_HOHO_CD = '" + this.oldItengiMukeiSkkHohoCd + "' AND " + "\n"); // 旧会計基準-所有権移転外無形償却方法コード
		super.sql.append("OLD_MBRI_ABRI_KBN = '" + this.oldMbriAbriKbn + "' AND " + "\n"); // 旧会計基準-前払後払区分
		super.sql.append("OLD_RSK_CLC_HOHO_CD = '" + this.oldRskClcHohoCd + "' AND " + "\n"); // 旧会計基準-利息計算方法コード
		super.sql.append("OLD_FKN_TNKI_HOHO_CD = '" + this.oldFknTnkiHohoCd + "' AND " + "\n"); // 旧会計基準-賦金展開方法コード
		super.sql.append("OLD_IJI_KNRI_HYO_JYO_KBN = '" + this.oldIjiKnriHyoJyoKbn + "' AND " + "\n"); // 旧会計基準-維持管理費重要性区分
		super.sql.append("OLD_EKM_TEIK_HYO_JYO_KBN = '" + this.oldEkmTeikHyoJyoKbn + "' AND " + "\n"); // 旧会計基準-役務提供費用重要性区分
		super.sql.append("OLD_GNKSK_HASU_CHSE_CD = '" + this.oldGnkskHasuChseCd + "' AND " + "\n"); // 旧会計基準-減価償却端数調整コード
		super.sql.append("OLD_FKN_TNKI_CHSE_CD = '" + this.oldFknTnkiHasuChseCd + "' AND " + "\n"); // 旧会計基準-賦金展開調整コード
		super.sql.append("OLD_KNU_AMT_TUTI_UM_FLG = '" + this.oldKnuAmtTutiUmFlg + "' AND " + "\n"); // 旧会計基準-購入額通知有無フラグ
		super.sql.append("NEW_ITN_YUKEI_SKK_HOHO_CD = '" + this.newItenYukeiSkkHohoCd + "' AND " + "\n"); // 新会計基準-所有権移転有形償却方法コード
		super.sql.append("NEW_ITN_MUKEI_SKK_HOHO_CD = '" + this.newItenMukeiSkkHohoCd + "' AND " + "\n"); // 新会計基準-所有権移転無形償却方法コード
		super.sql.append("NEW_ITNGI_YUKEI_SKK_HOHO_CD = '" + this.newItengiYukeiSkkHohoCd + "' AND " + "\n"); // 新会計基準-所有権移転外有形償却方法コード
		super.sql.append("NEW_ITNGI_MUKEI_SKK_HOHO_CD = '" + this.newItengiMukeiSkkHohoCd + "' AND " + "\n"); // 新会計基準-所有権移転外無形償却方法コード
		super.sql.append("NEW_MBRI_ABRI_KBN = '" + this.newMbriAbriKbn + "' AND " + "\n"); // 新会計基準-前払後払区分
		super.sql.append("NEW_RSK_CLC_HOHO_CD = '" + this.newRskClcHohoCd + "' AND " + "\n"); // 新会計基準-利息計算方法コード
		super.sql.append("NEW_FKN_TNKI_HOHO_CD = '" + this.newFknTnkiHohoCd + "' AND " + "\n"); // 新会計基準-賦金展開方法コード
		super.sql.append("NEW_IJI_KNRI_HYO_JYO_KBN = '" + this.newIjiKnriHyoJyoKbn + "' AND " + "\n"); // 新会計基準-維持管理費重要性区分
		super.sql.append("NEW_EKM_TEIK_HYO_JYO_KBN = '" + this.newEkmTeikHyoJyoKbn + "' AND " + "\n"); // 新会計基準-役務提供費用重要性区分
		super.sql.append("NEW_GNKSK_HASU_CHSE_CD = '" + this.newGnkskHasuChseCd + "' AND " + "\n"); // 新会計基準-減価償却端数調整コード
		super.sql.append("NEW_FKN_TNKI_CHSE_CD = '" + this.newFknTnkiHasuChseCd + "' AND " + "\n"); // 新会計基準-賦金展開調整コード
		super.sql.append("NEW_KNU_AMT_TUTI_UM_FLG = '" + this.newKnuAmtTutiUmFlg + "' AND " + "\n"); // 新会計基準-購入額通知有無フラグ
		super.sql.append("CHANGE_FLG = '0' " + "\n"); // 開示先変更フラグ
	}

	/**
	 * COSMOSコードを設定.
	 * 
	 * @param piCosmosCode
	 *            COSMOSコード
	 */
	public void setCosmosCode(String piCosmosCode) {
		this.cosmosCode = piCosmosCode;
	}

	/**
	 * COSMOSコードを取得.
	 * 
	 * @return COSMOSコード
	 */
	public String getUserCosmosCode() {
		return super.getString("LU_COSMOS_CD");
	}

}
