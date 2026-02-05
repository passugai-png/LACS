package jp.co.pro_app.lacs.affairs.bukken.data.entity;

import java.util.ArrayList;

import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 物件検索Entity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSBukkenEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSBukkenEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String		cosmosCode				= "";				// COSMOSコード

	private String		keiyakuNo				= "";				// 契約番号

	private String		bukkenName				= "";				// 物件名

	private String		bukkenNameSerchPtn		= "";				// 物件名検索パターン

	private String		leasCompanyCode			= "";				// リース会社コード

	private String		tradeHanteiKekkaCode	= "";				// 取引判定結果区分

	private ArrayList<Object>	enabledUser				= new ArrayList<Object>();

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		StringBuffer where = new StringBuffer();

		StringBuffer temp = new StringBuffer();
		boolean firstSw = true;

		super.whereSw = true;
		where.append(super.getWhereAnd("KEI.ERR_FLG = '0' " + "\n"));

		if (this.leasCompanyCode.trim().length() > 0) {
			where.append(super.getWhereAnd("KEI.LC_CD = '" + Command.changeQt(this.leasCompanyCode) + "' " + "\n"));
		}

		if (this.cosmosCode.trim().length() > 0) {
			where.append(super.getWhereAnd("KEI.LU_COSMOS_CD = '" + this.cosmosCode + "' " + "\n"));
		}
		else if (!this.enabledUser.contains(LACSDefine.INFO_ALL)) {
			for (int i = 0; i < enabledUser.size(); i++) {
				if (firstSw) {
					firstSw = false;
				}
				else {
					temp.append(", ");
				}
				temp.append("'" + Command.changeQt(((String)(this.enabledUser.get(i)))) + "'");
			}

			where.append(super.getWhereAnd("KEI.LU_COSMOS_CD IN (" + temp.toString() + ") " + "\n"));
		}

		if (this.tradeHanteiKekkaCode.trim().length() > 0) {
			where.append(super.getWhereAnd("KEI.TRD_HNTE_KEKA_KBN = '" + this.tradeHanteiKekkaCode + "' " + "\n"));
		}

		if (this.keiyakuNo.trim().length() > 0) {
			where.append(super.getWhereAnd("KEI.HYJYO_KEI_NO LIKE  '" + Command.changeQt(this.keiyakuNo) + "%' " + "\n"));
		}

		if (this.bukkenName.trim().length() > 0) {
			if (this.bukkenNameSerchPtn.equals("1")) {
				where.append(super.getWhereAnd("BKN.BKN_NM LIKE  '" + Command.changeQt(this.bukkenName) + "%' " + "\n"));
			}
			else if (this.bukkenNameSerchPtn.equals("2")) {
				where.append(super.getWhereAnd("BKN.BKN_NM LIKE  '%" + Command.changeQt(this.bukkenName) + "%' " + "\n"));
			}
			else if (this.bukkenNameSerchPtn.equals("3")) {
				where.append(super.getWhereAnd("BKN.BKN_NM    =  '" + Command.changeQt(this.bukkenName) + "' " + "\n"));
			}
		}

		super.sql.append("SELECT LC.LC_CD " + "\n");
		super.sql.append("	  ,LC.LC_NM " + "\n");
		super.sql.append("	  ,LU.LU_COSMOS_CD " + "\n");
		super.sql.append("	  ,LU.LU_NM " + "\n");
		super.sql.append("	  ,BKN.KEI_NO " + "\n");
		super.sql.append("	  ,KEI.HYJYO_KEI_NO " + "\n");
		super.sql.append("	  ,BKN.BKN_NO " + "\n");
		super.sql.append("	  ,BKN.BKN_EDANO " + "\n");
		super.sql.append("	  ,TRADE.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("	  ,TRADE.TRD_HNTE_KEKA_RYA " + "\n");
		super.sql.append("	  ,BKN.BKN_NM " + "\n");
		super.sql.append("FROM   T_BKN BKN " + "\n");
		super.sql.append("JOIN   T_KEI KEI ON KEI.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("			 AND    KEI.KEI_NO = BKN.KEI_NO " + "\n");
		super.sql.append("JOIN   M_LC LC ON LC.LC_CD = BKN.LC_CD " + "\n");
		super.sql.append("JOIN   M_TRD_HNTE_KEKA_KBN TRADE ON KEI.TRD_HNTE_KEKA_KBN = TRADE.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("JOIN   M_LU LU ON KEI.LU_COSMOS_CD = LU.LU_COSMOS_CD " + "\n");
		super.sql.append(where);
		super.sql.append("ORDER BY LC.LC_CD " + "\n");
		super.sql.append("	  ,KEI.LU_COSMOS_CD " + "\n");
		super.sql.append("	  ,KEI.HYJYO_KEI_NO " + "\n");
		super.sql.append("	  ,BKN.BKN_NO " + "\n");
		super.sql.append("	  ,BKN.BKN_EDANO " + "\n");
		super.sql.append("	  ,KEI.KEI_NO " + "\n");
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
	 * 契約番号を設定.
	 * 
	 * @param piKeiyakuNo
	 *            契約番号
	 */
	public void setKeiyakuNo(String piKeiyakuNo) {
		this.keiyakuNo = piKeiyakuNo;
	}

	/**
	 * 物件名を設定.
	 * 
	 * @param piBukkenName
	 *            物件名
	 */
	public void setBukkenName(String piBukkenName) {
		this.bukkenName = piBukkenName;
	}

	/**
	 * 物件名検索パターンを設定.
	 * 
	 * @param piBukkenNameSerchPtn
	 *            物件名検索パターン
	 */
	public void setBukkenNameSerchPtn(String piBukkenNameSerchPtn) {
		this.bukkenNameSerchPtn = piBukkenNameSerchPtn;
	}

	/**
	 * リース会社コードを設定.
	 * 
	 * @param piLeasCompanyCode
	 *            リース会社コード
	 */
	public void setLeasCompanyCode(String piLeasCompanyCode) {
		this.leasCompanyCode = piLeasCompanyCode;
	}

	/**
	 * 取引判定結果区分を設定.
	 * 
	 * @param piTradeHanteiKekkaCode
	 *            取引判定結果区分
	 */
	public void setTradeHanteiKekkaCode(String piTradeHanteiKekkaCode) {
		this.tradeHanteiKekkaCode = piTradeHanteiKekkaCode;
	}

	/**
	 * リース会社コードを取得.
	 * 
	 * @return リース会社コード
	 */
	public String getLeasCompanyCode() {
		return super.getString("LC_CD");
	}

	/**
	 * リース会社名を取得.
	 * 
	 * @return リース会社名
	 */
	public String getLeasCompanyName() {
		return super.getString("LC_NM");
	}

	/**
	 * COSMOSコードを取得.
	 * 
	 * @return COSMOSコード
	 */
	public String getCosmosCode() {
		return super.getString("LU_COSMOS_CD");
	}

	/**
	 * リースユーザー名を取得.
	 * 
	 * @return リースユーザー名
	 */
	public String getLeasUserName() {
		return super.getString("LU_NM");
	}

	/**
	 * 表示用契約番号を取得.
	 * 
	 * @return 表示用契約番号
	 */
	public String getHyoujiKeiyakuNo() {
		return super.getString("HYJYO_KEI_NO");
	}

	/**
	 * 取引判定結果区分を取得.
	 * 
	 * @return 取引判定結果区分
	 */
	public String getTradeHanteiKekkaCode() {
		return super.getString("TRD_HNTE_KEKA_KBN");
	}

	/**
	 * 取引判定結果略称を取得.
	 * 
	 * @return 取引判定結果略称
	 */
	public String getTradeHanteiKekkaName() {
		return super.getString("TRD_HNTE_KEKA_RYA");
	}

	/**
	 * 契約番号を取得.
	 * 
	 * @return 契約番号
	 */
	public String getKeiyakuNo() {
		return super.getString("KEI_NO");
	}

	/**
	 * 物件名を取得.
	 * 
	 * @return 物件名
	 */
	public String getBukkenName() {
		return super.getString("BKN_NM");
	}

	/**
	 * 物件番号を取得.
	 * 
	 * @return 物件番号
	 */
	public String getBukkenNo() {
		return super.getString("BKN_NO");
	}

	/**
	 * 物件枝番を取得.
	 * 
	 * @return 物件枝番
	 */
	public String getBukkenEdaNo() {
		return super.getString("BKN_EDANO");
	}

	/**
	 * 利用可能開示先を設定.
	 * 
	 * @param piEnabledUser
	 *            利用可能開示先
	 */
	public void setEnabledUser(ArrayList<Object> piEnabledUser) {
		this.enabledUser = piEnabledUser;
	}
}
