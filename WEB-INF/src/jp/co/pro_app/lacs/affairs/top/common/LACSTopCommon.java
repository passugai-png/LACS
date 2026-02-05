package jp.co.pro_app.lacs.affairs.top.common;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.top.data.entity.LACSKeiyakuErrorEntity;
import jp.co.pro_app.lacs.affairs.top.data.entity.LACSTopInfoEntity;
import jp.co.pro_app.lacs.affairs.top.data.entity.LACSVersionEntity;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;

/**
 * トップメニュー：共通機能.
 * 
 * @author Katoken
 * @version 20080725
 */
public class LACSTopCommon {

	/**
	 * コンストラクタ.
	 */
	private LACSTopCommon() {
	}

	/**
	 * お知らせ出力.
	 * 
	 * @param piCommonBean
	 *            LACS共通Bean
	 * @param piModel
	 *            モデル
	 * @param piCon
	 *            DB接続
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public static void getInfo(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) throws SQLException {

		LACSVersionEntity versionEntity = new LACSVersionEntity(piModel);

		if (piCommonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {
			getErrorData(piCommonBean, piModel, piCon);
		}
		else {
			getInfoData(piCommonBean, piModel, piCon);
		}

		try {
			versionEntity.setCon(piCon);

			versionEntity.execSQL();

			if (versionEntity.next()) {
				if (versionEntity.getCustomVer().trim().length() == 0) {
					piCommonBean.setVersion(versionEntity.getCommonVer());
				}
				else {
					piCommonBean.setVersion(versionEntity.getCommonVer() + "．" + versionEntity.getCustomVer());
				}
			}
		}
		finally {
			versionEntity.close();
		}

	}

	private static void getErrorData(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) throws SQLException {
		LACSKeiyakuErrorEntity keiyakuErrorEntity = new LACSKeiyakuErrorEntity(piModel);

		boolean firstSw = true;

		String pre = "";
		String now = "";
		piCommonBean.getInfo().clear();

		try {
			keiyakuErrorEntity.setCon(piCon);

			if (keiyakuErrorEntity.execSQL() > 0) {

				piCommonBean.getInfo().add("下記の契約番号に不整合が発生しています。");

				while (keiyakuErrorEntity.next()) {
					if (keiyakuErrorEntity.getDispOrder().equals("1")) {
						if (firstSw) {
							piCommonBean.getInfo().add("");
							firstSw = false;
						}

						if (keiyakuErrorEntity.getKeiyakuNo().equals(LACSDefine.ERROR_KEIYAKU)) {
							piCommonBean.getInfo().add("   " + keiyakuErrorEntity.getErrMsg());
						}
						else {
							piCommonBean.getInfo().add("   " + keiyakuErrorEntity.getKeiyakuNo() + " ： " + keiyakuErrorEntity.getErrMsg());
						}
					}
					else {
						if (piCommonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) {
							now = keiyakuErrorEntity.getUserName();
						}
						else {
							now = keiyakuErrorEntity.getCompanyName();
						}

						if (!pre.equals(now)) {
							piCommonBean.getInfo().add("");

							piCommonBean.getInfo().add("リースユーザー名：" + keiyakuErrorEntity.getUserName());

							pre = now;

							piCommonBean.getInfo().add("契約番号：");
						}

						piCommonBean.getInfo().add("   " + keiyakuErrorEntity.getKeiyakuNo() + " ： " + keiyakuErrorEntity.getErrMsg());
					}
				}
			}
		}
		finally {
			keiyakuErrorEntity.close();
		}
	}

	private static void getInfoData(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) throws SQLException {
		LACSTopInfoEntity entity = new LACSTopInfoEntity(piModel);
		String today = Convert.toString(new Date(), Convert.FORMAT_YYYYMMDD);
		LACSKeiyakuErrorEntity keiyakuErrorEntity = new LACSKeiyakuErrorEntity(piModel);
		String[] lines = null;
		boolean firstSw = true;

		piCommonBean.getInfo().clear();

		try {
			keiyakuErrorEntity.setCon(piCon);

			if ("1".equals(piCommonBean.getErrorDisplayFlg())) {
				keiyakuErrorEntity.setCosmosCd(piCommonBean.getCosmosCode());
			}

			piCommonBean.setErrorFlg("0");

			if (keiyakuErrorEntity.execSQL() > 0 || piModel.checkBatchExecute()) {
				piCon.commit();

				piCommonBean.setErrorFlg("1");
			}

			if (piCommonBean.getErrorFlg().equals("1")) {
				piCommonBean.getInfo().add("現在メンテナンス中です。しばらくしてから再度お試し下さい。");
				firstSw = false;
			}

			entity.setCon(piCon);
			entity.setStartYmd(today);
			entity.setEndYmd(today);
			entity.setMenuCosmosCode(piCommonBean.getCosmosCode());

			entity.execSQL();

			while (entity.next()) {
				lines = entity.getInfoData().replaceAll("\r", "").split("\n");

				if (firstSw) {
					firstSw = false;
				}
				else {
					piCommonBean.getInfo().add("");
					piCommonBean.getInfo().add("     -----------------------------------------------------------------------------------------------------------------------------------------------------");
					piCommonBean.getInfo().add("");
				}

				for (int i = 0; i < lines.length; i++) {
					piCommonBean.getInfo().add(lines[i]);
				}
			}
		}
		finally {
			keiyakuErrorEntity.close();
			entity.close();
		}
	}
}
