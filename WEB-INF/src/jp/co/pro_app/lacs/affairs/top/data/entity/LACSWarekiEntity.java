package jp.co.pro_app.lacs.affairs.top.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * エラー契約取得Entity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSWarekiEntity extends EntityBase {

	private String	targetDate	= "";

	private String	warekiCode	= "";

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSWarekiEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {
		sql.append("SELECT T.WRKI_CD " + "\n");
		sql.append("	  ,T.WRKI_NM " + "\n");
		sql.append("	  ,T.WRKI_FROM " + "\n");
		sql.append("	  ,T.WRKI_TO " + "\n");
		sql.append("FROM   M_SRKI_WRKI_CD T " + "\n");

		if (this.targetDate.trim().length() > 0) {
			sql.append(super.getWhereAnd() + " '" + this.targetDate + "' BETWEEN T.WRKI_FROM AND T.WRKI_TO " + "\n");
		}

		if (this.warekiCode.trim().length() > 0) {
			sql.append(super.getWhereAnd() + " T.WRKI_CD = '" + this.warekiCode + "' " + "\n");
		}

		sql.append("ORDER  BY T.WRKI_FROM " + "\n");
	}

	/**
	 * 検索対象日を設定.
	 * 
	 * @param piTargetDate
	 *            検索対象日
	 */
	public void setTargetDate(String piTargetDate) {
		this.targetDate = piTargetDate;
	}

	/**
	 * 和暦コードを取得.
	 * 
	 * @return 和暦コード
	 */
	public String getWarekiCode() {
		return super.getString("WRKI_CD");
	}

	/**
	 * 和暦名を取得.
	 * 
	 * @return 和暦名
	 */
	public String getWarekiName() {
		return super.getString("WRKI_NM");
	}

	/**
	 * 和暦開始日を取得.
	 * 
	 * @return 和暦開始日
	 */
	public String getWarekiFrom() {
		return super.getString("WRKI_FROM");
	}

	/**
	 * 和暦終了日を取得.
	 * 
	 * @return 和暦終了日
	 */
	public String getWarekiTo() {
		return super.getString("WRKI_TO");
	}

	/**
	 * 検索対象の和暦コードを設定.
	 * 
	 * @param piWarekiCode
	 *            検索対象の和暦コード
	 */
	public void setWarekiCode(String piWarekiCode) {
		this.warekiCode = piWarekiCode;
	}
}
