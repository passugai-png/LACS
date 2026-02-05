package jp.co.pro_app.lacs.affairs.monthreport.data.entity;

import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean;
//import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.model.DBModelBase;


/**
 * ŒŸ’ •[o—Í‰æ–Ê F ƒŠ[ƒX‰ïŒv–¾×Šî€‘ : Œ_–ñ”Ô†‚ğæ“¾ Entity.
 * 
 * @author arai
 * @version 20210819
 */
public class LACSMonthGetKeiyakuNoEntity extends LACSMReportEntityBase {

	/**
	 * ƒRƒ“ƒXƒgƒ‰ƒNƒ^.
	 * 
	 * @param piModel
	 *            ƒ‚ƒfƒ‹
	 * @param piCommonBean
	 *            LACS‹¤’ÊBean
	 * @param piReportBean
	 *            ’ •[o—ÍBean
	 */
	public LACSMonthGetKeiyakuNoEntity(DBModelBase piModel, LACSCommonBean piCommonBean, LACSMReportBean piReportBean) throws SQLException {
		super(piModel, piCommonBean, piReportBean);		
		
	}	
	
	/**
	 * •\¦—pŒ_–ñ”Ô†‚©‚çŒ_–ñ”Ô†‚ğæ“¾‚·‚é‚r‚p‚k.
	 */
	@Override
	protected void makeSQL() {

		// Œ_–ñ”Ô†‚ğæ“¾
		super.sql.append("SELECT \n");
		super.sql.append("  KEI_NO  \n");
		super.sql.append("FROM \n");
		super.sql.append("  T_KEI \n");
		super.sql.append("WHERE \n");
		super.sql.append("  HYJYO_KEI_NO = '" + this.keiyakuNo + "' \n");
		
		System.out.println(super.sql);
	}
	
	
	/**
	 * Œ_–ñ”Ô†‚ğæ“¾.
	 * 
	 * @return Œ_–ñ”Ô†
	 */
	public String getKeiyakuNo() {
		return super.getString("KEI_NO");
	}
	
}	
	
	
	
	
	
	
	
	
	
	

