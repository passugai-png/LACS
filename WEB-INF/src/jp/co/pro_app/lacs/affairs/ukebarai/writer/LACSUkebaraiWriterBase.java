package jp.co.pro_app.lacs.affairs.ukebarai.writer;

import java.sql.Connection;
import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.common.command.LACSCommand;
import jp.co.pro_app.lacs.affairs.common.data.entity.LACSFixedUserInfoEntity;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.affairs.ukebarai.common.LACSUkebaraiCommon;
import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.command.Convert;

/**
 * 受払合計表：PDF・CSV作成Modelスーパークラス.
 * 
 * @author active
 * @version 20080812
 */
public class LACSUkebaraiWriterBase {

	/**
	 * Modelクラス.
	 */
	protected LACSModelBase		model	= null;

	/**
	 * LACS用共通Bean.
	 */
	protected LACSCommonBean	commonBean;

	/**
	 * DB接続.
	 */
	protected Connection		con		= null;

	/**
	 * 対象会計基準.
	 */
	protected String			acStd	= "";

	/**
	 * 対象会計基準接頭辞.
	 */
	protected String			prefix	= "";

	/**
	 * コンストラクタ.
	 * 
	 * @param piCommonBean
	 *            LACS用共通Bean
	 * @param piModel
	 *            モデルクラス
	 * @param piCon
	 *            DB接続
	 */
	public LACSUkebaraiWriterBase(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		this.commonBean = piCommonBean;
		this.model = piModel;
		this.con = piCon;
	}

	/**
	 * 西暦和暦変換(yyyy年MM月dd日、eeeyy年MM月dd日 形式).
	 * 
	 * @param piDateString
	 *            日付文字列
	 * @param piDateMode
	 *            西暦和暦モード
	 * @return 日付
	 * @throws SQLException
	 *             SQL例外
	 */
	protected String convertRekiLong(String piDateString, String piDateMode) throws SQLException {
		String result = "";
		String dateString = piDateString.replaceAll("/", "");

		if (piDateMode.equals(LACSDefine.DateMode.SEIREKI)) {
			result = Convert.toString(Convert.toDate(Convert.toDateString(dateString)), Convert.FORMAT_YYYY_MM_DD_JP);
		}
		else {
			result = piDateString == null ? "" : LACSCommand.toDateYYYYMMDD(this.commonBean, this.con, this.model, dateString, piDateMode);
		}

		return result;
	}

	/**
	 * 西暦和暦変換(yyyy/MM/dd、eyy/MM/dd 形式).
	 * 
	 * @param piDateString
	 *            日付文字列
	 * @param piDateMode
	 *            西暦和暦モード
	 * @return 日付
	 * @throws SQLException
	 *             SQL例外
	 */
	protected String convertReki(String piDateString, String piDateMode) throws SQLException {
		String result = piDateString == null ? "" : LACSCommand.toDateYYYYMMDD(this.commonBean, this.con, this.model, piDateString.replaceAll("/", ""), piDateMode);

		result = result.replaceAll("昭和", "S");
		result = result.replaceAll("平成", "H");
		result = result.replaceAll("元", "1");
		result = result.replaceAll("年", "/");
		result = result.replaceAll("月", "/");
		result = result.replaceAll("日", "");

		return result;
	}

	/**
	 * 対象会計基準を設定.
	 * 
	 * @param piAcStd
	 *            対象会計基準
	 */
	public void setAcStd(String piAcStd) {
		this.acStd = piAcStd;
		this.prefix = acStd.equals(LACSDefine.AccountStandard.NEW_1) ? "new" : "old";
	}

	/**
	 * 西暦和暦コードを取得する.
	 * 
	 * @param piLuCd
	 *            リース会社コード
	 * @param piCosmosCd
	 *            COSMOSコード
	 * @return String 西暦和暦コード
	 * @throws SQLException
	 *             SQL例外
	 */
	protected String getSeirekiWarekiCode(String piLuCd, String piCosmosCd) throws SQLException {

		LACSFixedUserInfoEntity entity = new LACSFixedUserInfoEntity(this.model);

		entity.setCompanyCode(piLuCd);
		// entity.setTrhkskCode(piCosmosCd);

		entity.setCon(this.con);

		entity.execSQL();

		String ret = "";
		if (entity.next()) {
			ret = entity.getSeirekiWarekiCode();
		}
		else {
			ret = commonBean.getDateMode();
		}

		entity.close();

		return ret;
	}

	/**
	 * 受払合計表用出力データ取得. 出力データをBeanに設定して返却する
	 * 
	 * @param piUkebaraiBean
	 *            受払合計表Bean
	 * @exception SQLException
	 *                SQL実行例外
	 */
	public void getGokeiData(LACSUkebaraiBean piUkebaraiBean) throws SQLException {

		try {
			LACSUkebaraiCommon.getUkebaraiData(commonBean, piUkebaraiBean, model, con);
			piUkebaraiBean.setLeaseUserNm(piUkebaraiBean.getLeasCompany().getName());
		}
		finally {
		}
	}
}
