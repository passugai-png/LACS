package jp.co.pro_app.lacs.affairs.report.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 帳票出力：資産種類Entity.
 * 
 * @author PAS Yokota
 * @version 20080612
 */
public class LACSReportSsnSriEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSReportSsnSriEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		super.sql.append(" SELECT 	SSN_SRI_CD " + "\n"); // 資産種類コード
		super.sql.append("		,	SSN_SRI_NM" + "\n"); // 資産種類名称
		super.sql.append(" FROM 	M_SSN_SRI SSN_SRI" + "\n");

		super.sql.append(" ORDER BY 	SSN_SRI_CD " + "\n");

	}

	/**
	 * 資産種類名称を取得.
	 * 
	 * @return 資産種類名称
	 */
	public String getSsnSriNm() {
		return super.getString("SSN_SRI_NM");
	}

	/**
	 * 資産種類コードを取得.
	 * 
	 * @return 資産種類コード
	 */
	public String getSsnSriCd() {
		return super.getString("SSN_SRI_CD");
	}
}
