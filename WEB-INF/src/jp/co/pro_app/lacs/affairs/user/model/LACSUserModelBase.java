package jp.co.pro_app.lacs.affairs.user.model;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSDispControlCommon;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSAcShrKbnEntity;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSBatchPrintTimingCdEntity;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSHasuTyoseiEntity;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSRisokuKeijyoHohoEntity;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSSyokyakuHohoEntity;
import jp.co.pro_app.lacs.affairs.user.bean.LACSUserBean;
import jp.co.pro_app.lacs.common.model.LACSSessionDBModelBase;
import jp.co.pro_app.projframe.common.html.ComboArray;
import jp.co.pro_app.projframe.common.html.ComboValue;

/**
 * リースユーザーマスタスーパークラス.
 * 
 * @author takeda
 * @version 20070904
 */
public abstract class LACSUserModelBase extends LACSSessionDBModelBase {

	/**
	 * 機能名を取得.
	 * 
	 * @return 機能名
	 */
	public String getProcName() {
		return "開示先メンテナンス";
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

		LACSUserBean userBean = super.getUserBean();

		commonBean.setDispID("U001");
		dispControlCommon = new LACSDispControlCommon(userBean.getDispControl(), this, this.con);

		this.init(userBean);
		this.initSub(userBean);
		this.businessProc(userBean);
		super.getLogger().end();

	}

	/**
	 * 業務個別処理.
	 * 
	 * @param piUserBean
	 *            リースユーザーマスタBean
	 * @throws Exception
	 *             例外発生時.
	 */
	protected void businessProc(LACSUserBean piUserBean) throws Exception {
		return;
	}

	/**
	 * 初期化.
	 * 
	 * @param piUserBean
	 *            リースユーザーマスタBean
	 */
	protected final void init(LACSUserBean piUserBean) {
		piUserBean.setMessage("");
		piUserBean.setUserCosmosCode(super.getInput("targetCosmosCode", "").trim());
		piUserBean.setCondCosmosCode(super.getInput("condCosmosCode", "").trim());
		piUserBean.setProcMode(super.getParam("procMode", 0));

		piUserBean.setleasCompanyNm(super.getInput("leasCompanyNm", "").trim());
		piUserBean.setleasCompany(super.getInput("leasCompany", "").trim());

		String pageNo = super.getInput("PageNo", "").trim();
		if (pageNo != null && pageNo.length() > 0) {
			piUserBean.setPageNo(Integer.parseInt(super.getInput("PageNo", "").trim()));
			piUserBean.setCurrentW(Integer.parseInt(super.getInput("PageNo", "").trim()));
		}
		else {
			piUserBean.setPageNo(1);
			piUserBean.setCurrentW(1);
		}

	}

	/**
	 * 業務固有初期化.
	 * 
	 * @param piUserBean
	 *            リースユーザーマスタBean
	 * @exception Exception
	 *                例外発生時
	 */
	protected abstract void initSub(LACSUserBean piUserBean) throws Exception;

	/**
	 * コンボボックス生成.
	 * 
	 * @param piUserBean
	 *            リースユーザーマスタBean
	 * @throws SQLException
	 *             SQL実行例外
	 */

	protected void prepareComoboBox(LACSUserBean piUserBean) throws SQLException {
		LACSSyokyakuHohoEntity syokyakuHohoEntity = new LACSSyokyakuHohoEntity(this);
		LACSRisokuKeijyoHohoEntity risokuKeijyoHohoEntity = new LACSRisokuKeijyoHohoEntity(this);
		LACSHasuTyoseiEntity hasuTyoseiEntity = new LACSHasuTyoseiEntity(this);
		LACSAcShrKbnEntity acShrKbnEntity = new LACSAcShrKbnEntity(this);

		ComboArray seirekiWarekiCode = piUserBean.getSeirekiWarekiCode();
		ComboArray acShoriKbn = piUserBean.getAcShrKbn();

		ComboArray oldItenYukeiSkkHohoCd = piUserBean.getOldItenYukeiSkkHohoCd();
		ComboArray oldItenMukeiSkkHohoCd = piUserBean.getOldItenMukeiSkkHohoCd();
		ComboArray oldItengiYukeiSkkHohoCd = piUserBean.getOldItengiYukeiSkkHohoCd();
		ComboArray oldItengiMukeiSkkHohoCd = piUserBean.getOldItengiMukeiSkkHohoCd();
		ComboArray oldRskClcHohoCd = piUserBean.getOldRskClcHohoCd();
		ComboArray oldFknTnkiHasuChseCd = piUserBean.getOldFknTnkiHasuChseCd();
		ComboArray oldIjiKnriHyoJyoKbn = piUserBean.getOldIjiKnriHyoJyoKbn();
		ComboArray oldEkmTeikHyoJyoKbn = piUserBean.getOldEkmTeikHyoJyoKbn();
		ComboArray oldGnkskHasuChseCd = piUserBean.getOldGnkskHasuChseCd();
		ComboArray oldFknTnkiHohoCd = piUserBean.getOldFknTnkiHohoCd();

		ComboArray newItenYukeiSkkHohoCd = piUserBean.getNewItenYukeiSkkHohoCd();
		ComboArray newItenMukeiSkkHohoCd = piUserBean.getNewItenMukeiSkkHohoCd();
		ComboArray newItengiYukeiSkkHohoCd = piUserBean.getNewItengiYukeiSkkHohoCd();
		ComboArray newItengiMukeiSkkHohoCd = piUserBean.getNewItengiMukeiSkkHohoCd();
		ComboArray newRskClcHohoCd = piUserBean.getNewRskClcHohoCd();
		ComboArray newFknTnkiHasuChseCd = piUserBean.getNewFknTnkiHasuChseCd();
		ComboArray newIjiKnriHyoJyoKbn = piUserBean.getNewIjiKnriHyoJyoKbn();
		ComboArray newEkmTeikHyoJyoKbn = piUserBean.getNewEkmTeikHyoJyoKbn();
		ComboArray newGnkskHasuChseCd = piUserBean.getNewGnkskHasuChseCd();
		ComboArray newFknTnkiHohoCd = piUserBean.getNewFknTnkiHohoCd();
		ComboArray syosuKetasu = piUserBean.getSyosuKetasu();
		
		//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 start
		//出力タイミング
		ComboArray batchPrintTimingCd = piUserBean.getBatchPrintTimingCd();
		LACSBatchPrintTimingCdEntity batchPrintTimingCdEntity = new LACSBatchPrintTimingCdEntity(this);
		//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 end

		seirekiWarekiCode.clear();
		acShoriKbn.clear();

		oldItenYukeiSkkHohoCd.clear();
		oldItenMukeiSkkHohoCd.clear();
		oldItengiYukeiSkkHohoCd.clear();
		oldItengiMukeiSkkHohoCd.clear();
		oldRskClcHohoCd.clear();
		oldFknTnkiHasuChseCd.clear();
		oldIjiKnriHyoJyoKbn.clear();
		oldEkmTeikHyoJyoKbn.clear();
		oldGnkskHasuChseCd.clear();
		oldFknTnkiHohoCd.clear();

		newItenYukeiSkkHohoCd.clear();
		newItenMukeiSkkHohoCd.clear();
		newItengiYukeiSkkHohoCd.clear();
		newItengiMukeiSkkHohoCd.clear();
		newRskClcHohoCd.clear();
		newFknTnkiHasuChseCd.clear();
		newIjiKnriHyoJyoKbn.clear();
		newEkmTeikHyoJyoKbn.clear();
		newGnkskHasuChseCd.clear();
		newFknTnkiHohoCd.clear();

		syosuKetasu.clear();
		
		//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 start
		batchPrintTimingCd.clear();
		//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 end
		
		try {

			acShrKbnEntity.setCon(super.con);
			acShrKbnEntity.execSQL();
			while (acShrKbnEntity.next()) {
				acShoriKbn.add(new ComboValue(acShrKbnEntity.getAcShrRyaku(), acShrKbnEntity.getAcShrKbn()));
			}

			seirekiWarekiCode.add(new ComboValue("西暦", "1"));
			seirekiWarekiCode.add(new ComboValue("和暦", "2"));

			syokyakuHohoEntity.setCon(super.con);
			syokyakuHohoEntity.execSQL();
			while (syokyakuHohoEntity.next()) {
				oldItenYukeiSkkHohoCd.add(new ComboValue(syokyakuHohoEntity.getSyokyakuHohoName(), syokyakuHohoEntity.getSyokyakuHohoCode()));
				oldItenMukeiSkkHohoCd.add(new ComboValue(syokyakuHohoEntity.getSyokyakuHohoName(), syokyakuHohoEntity.getSyokyakuHohoCode()));
				oldItengiYukeiSkkHohoCd.add(new ComboValue(syokyakuHohoEntity.getSyokyakuHohoName(), syokyakuHohoEntity.getSyokyakuHohoCode()));
				oldItengiMukeiSkkHohoCd.add(new ComboValue(syokyakuHohoEntity.getSyokyakuHohoName(), syokyakuHohoEntity.getSyokyakuHohoCode()));

				newItenYukeiSkkHohoCd.add(new ComboValue(syokyakuHohoEntity.getSyokyakuHohoName(), syokyakuHohoEntity.getSyokyakuHohoCode()));
				newItenMukeiSkkHohoCd.add(new ComboValue(syokyakuHohoEntity.getSyokyakuHohoName(), syokyakuHohoEntity.getSyokyakuHohoCode()));
				newItengiYukeiSkkHohoCd.add(new ComboValue(syokyakuHohoEntity.getSyokyakuHohoName(), syokyakuHohoEntity.getSyokyakuHohoCode()));
				newItengiMukeiSkkHohoCd.add(new ComboValue(syokyakuHohoEntity.getSyokyakuHohoName(), syokyakuHohoEntity.getSyokyakuHohoCode()));
			}

			risokuKeijyoHohoEntity.setCon(super.con);
			risokuKeijyoHohoEntity.execSQL();
			while (risokuKeijyoHohoEntity.next()) {
				oldRskClcHohoCd.add(new ComboValue(risokuKeijyoHohoEntity.getSyokyakuHohoName(), risokuKeijyoHohoEntity.getSyokyakuHohoCode()));

				newRskClcHohoCd.add(new ComboValue(risokuKeijyoHohoEntity.getSyokyakuHohoName(), risokuKeijyoHohoEntity.getSyokyakuHohoCode()));
			}

			oldFknTnkiHohoCd.add(new ComboValue("費用発生ベース", "1"));
			oldFknTnkiHohoCd.add(new ComboValue("支払日ベース", "2"));

			newFknTnkiHohoCd.add(new ComboValue("費用発生ベース", "1"));
			newFknTnkiHohoCd.add(new ComboValue("支払日ベース", "2"));

			oldIjiKnriHyoJyoKbn.add(new ComboValue("計上しない", "0"));
			oldIjiKnriHyoJyoKbn.add(new ComboValue("計上する", "1"));

			newIjiKnriHyoJyoKbn.add(new ComboValue("計上しない", "0"));
			newIjiKnriHyoJyoKbn.add(new ComboValue("計上する", "1"));

			oldEkmTeikHyoJyoKbn.add(new ComboValue("計上しない", "0"));
			oldEkmTeikHyoJyoKbn.add(new ComboValue("計上する", "1"));

			newEkmTeikHyoJyoKbn.add(new ComboValue("計上しない", "0"));
			newEkmTeikHyoJyoKbn.add(new ComboValue("計上する", "1"));

			hasuTyoseiEntity.setCon(super.con);
			hasuTyoseiEntity.execSQL();
			while (hasuTyoseiEntity.next()) {
				oldFknTnkiHasuChseCd.add(new ComboValue(hasuTyoseiEntity.getHasuTyoseiName(), hasuTyoseiEntity.getHasuTyoseiCode()));
				oldGnkskHasuChseCd.add(new ComboValue(hasuTyoseiEntity.getHasuTyoseiName(), hasuTyoseiEntity.getHasuTyoseiCode()));

				newFknTnkiHasuChseCd.add(new ComboValue(hasuTyoseiEntity.getHasuTyoseiName(), hasuTyoseiEntity.getHasuTyoseiCode()));
				newGnkskHasuChseCd.add(new ComboValue(hasuTyoseiEntity.getHasuTyoseiName(), hasuTyoseiEntity.getHasuTyoseiCode()));
			}

			oldFknTnkiHasuChseCd.setSelectedValue("2");
			oldGnkskHasuChseCd.setSelectedValue("2");

			newFknTnkiHasuChseCd.setSelectedValue("2");
			newGnkskHasuChseCd.setSelectedValue("2");

			for (int i = 3; i <= 6; i++) {
				syosuKetasu.add(new ComboValue(i, i, i == 4));
			}
			
			//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 start
			batchPrintTimingCdEntity.setCon(super.con);
			batchPrintTimingCdEntity.execSQL();
			while (batchPrintTimingCdEntity.next()) {
				batchPrintTimingCd.add(new ComboValue(batchPrintTimingCdEntity.getTimingNm(), batchPrintTimingCdEntity.getBatchPrintTimingCd()));
			}
			//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 end
		}
		finally {
			syokyakuHohoEntity.close();
			risokuKeijyoHohoEntity.close();
			hasuTyoseiEntity.close();
			acShrKbnEntity.close();
			//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 start
			batchPrintTimingCdEntity.close();
			//ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/20 end
		}
	}
}
