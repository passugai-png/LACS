package jp.co.pro_app.lacs.affairs.common.data.entity;

import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * ’S“–Òó‘ÔEntity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSTantJtiKbnEntity extends EntityBase {

	/**
	 * ƒRƒ“ƒXƒgƒ‰ƒNƒ^.
	 * 
	 * @param piModel
	 *            ƒ‚ƒfƒ‹
	 */
	public LACSTantJtiKbnEntity(DBModelBase piModel) {
		super(piModel);
	}

	/**
	 * ‚r‚p‚k‚ğ¶¬.
	 */
	protected void makeSQL() {
		super.sql.append("SELECT LU_TNT_JTI_KBN " + "\n");
		super.sql.append("	  ,LU_TNT_JTI_NM " + "\n");
		super.sql.append("FROM   M_LU_TNT_JTI_KBN " + "\n");
		super.sql.append("ORDER  BY LU_TNT_JTI_KBN " + "\n");
	}

	/**
	 * ’S“–Òó‘Ô‹æ•ª‚ğæ“¾.
	 * 
	 * @return ’S“–Òó‘Ô‹æ•ª
	 */
	public String getTantJtiKbn() {
		return super.getString("LU_TNT_JTI_KBN");
	}

	/**
	 * ’S“–Òó‘Ô–¼‚ğæ“¾.
	 * 
	 * @return ’S“–Òó‘Ô–¼
	 */
	public String getTantJtiName() {
		return super.getString("LU_TNT_JTI_NM");
	}

}
