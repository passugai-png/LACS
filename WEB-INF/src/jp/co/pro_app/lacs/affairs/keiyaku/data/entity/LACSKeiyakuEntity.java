package jp.co.pro_app.lacs.affairs.keiyaku.data.entity;

import java.util.ArrayList;

import jp.co.pro_app.lacs.common.define.LACSDefine;
import jp.co.pro_app.projframe.common.command.Command;
import jp.co.pro_app.projframe.common.data.entity.EntityBase;
import jp.co.pro_app.projframe.common.model.DBModelBase;

/**
 * 契約検索Entity.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSKeiyakuEntity extends EntityBase {

	/**
	 * コンストラクタ.
	 * 
	 * @param piModel
	 *            モデル
	 */
	public LACSKeiyakuEntity(DBModelBase piModel) {
		super(piModel);
	}

	private String		cosmosCode				= "";				// COSMOSコード

	private String		keiyakuNo				= "";				// 契約番号

	private String		daihyoBukkenName		= "";				// 代表物件名

	private String		leasCompanyCode			= "";				// リース会社コード

	private String		tradeHanteiKekkaCode	= "";				// 取引判定結果区分

	private String		kenshuFrom				= "";				// 検収年月From

	private String		kenshuTo				= "";				// 検収年月To

	private String		manryoFrom				= "";				// 満了年月From

	private String		manryoTo				= "";				// 満了年月To

	private String		kaiyakuFrom				= "";				// 解約年月From

	private String		kaiyakuTo				= "";				// 解約年月To

	private String		keiyakuAmt				= "";				// 契約金額

	private String		keiyakuTerm				= "";				// 契約期間

	private String		kenPatn					= "";				// 代表 物件検索パターン

	private String		keiyakuRls				= "";				// 再リース指定
	
	//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 start
	private boolean 	batchFlg				= false;			// バッチ実行フラグ
	//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 end
	
	private ArrayList<Object>	enabledUser				= new ArrayList<Object>();

	/**
	 * ＳＱＬを生成.
	 */
	protected void makeSQL() {

		StringBuffer where = new StringBuffer();

		String from = "";
		String to = "";

		StringBuffer temp = new StringBuffer();
		boolean firstSw = true;

		super.whereSw = true;
		where.append(super.getWhereAnd("KEI.ERR_FLG = '0' " + "\n"));

		if (this.leasCompanyCode.trim().length() > 0) {
			where.append(super.getWhereAnd("KEI.LC_CD = '" + this.leasCompanyCode + "' " + "\n"));
		}

		if (this.cosmosCode.trim().length() > 0) {
			where.append(super.getWhereAnd("KEI.LU_COSMOS_CD = '" + Command.changeQt(this.cosmosCode) + "' " + "\n"));
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

		if (this.daihyoBukkenName.trim().length() > 0) {
			if (this.kenPatn.equals("1")) {
				where.append(super.getWhereAnd("KEI.DIH_BKN_NM LIKE  '" + Command.changeQt(this.daihyoBukkenName) + "%' " + "\n"));
			}
			else if (this.kenPatn.equals("2")) {
				where.append(super.getWhereAnd("KEI.DIH_BKN_NM LIKE  '%" + Command.changeQt(this.daihyoBukkenName) + "%' " + "\n"));
			}
			else if (this.kenPatn.equals("3")) {
				where.append(super.getWhereAnd("KEI.DIH_BKN_NM    =  '" + Command.changeQt(this.daihyoBukkenName) + "' " + "\n"));
			}
		}

		if (this.kenshuFrom.trim().length() > 0 || this.kenshuTo.trim().length() > 0) {
			from = Command.init(this.kenshuFrom, "000000").substring(0, 6) + "00";
			to = Command.init(this.kenshuTo, "999999").substring(0, 6) + "99";

			where.append(super.getWhereAnd("KEI.KNSHU_YMD BETWEEN '" + from + "' AND '" + to + "' " + "\n"));
		}

		if (this.manryoFrom.trim().length() > 0 || this.manryoTo.trim().length() > 0) {
			from = Command.init(this.manryoFrom, "000000").substring(0, 6) + "00";
			to = Command.init(this.manryoTo, "999999").substring(0, 6) + "99";

			where.append(super.getWhereAnd("KEI.MRYO_YMD BETWEEN '" + from + "' AND '" + to + "' " + "\n"));
		}

		if (this.kaiyakuFrom.trim().length() > 0 || this.kaiyakuTo.trim().length() > 0) {
			from = Command.init(this.kaiyakuFrom, "000000").substring(0, 6) + "00";
			to = Command.init(this.kaiyakuTo, "999999").substring(0, 6) + "99";

			where.append(super.getWhereAnd("KEI.KAI_YMD BETWEEN '" + from + "' AND '" + to + "' " + "\n"));
		}

		if (this.keiyakuAmt.trim().length() > 0) {
			where.append(super.getWhereAnd("KEI.KEI_AMT >  " + this.keiyakuAmt + "  " + "\n"));
		}
		if (this.keiyakuTerm.trim().length() > 0) {
			where.append(super.getWhereAnd("KEI.KEI_TERM >  " + this.keiyakuTerm + "  " + "\n"));
		}

		if (this.keiyakuRls.equals("2")) {
			where.append(super.getWhereAnd("KEI.RLS_TMS = 0" + "\n"));
		}
		else if (this.keiyakuRls.equals("3")) {
			where.append(super.getWhereAnd("KEI.RLS_TMS > 0" + "\n"));
		}
		
		//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 start
		if (batchFlg) {
			where.append(super.getWhereAnd("WKEI.ERR_FLG = '0'" + "\n"));
			where.append(super.getWhereAnd("WKEI.UPD_FLG IN ('1', '2')" + "\n"));
			where.append(super.getWhereAnd("WKEI.LC_CD = KEI.LC_CD" + "\n"));
			where.append(super.getWhereAnd("WKEI.KEI_NO = KEI.KEI_NO" + "\n"));
		}
		//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 end
		
		super.sql.append("SELECT LC.LC_CD " + "\n");
		super.sql.append("	  ,LC.LC_NM " + "\n");
		super.sql.append("	  ,LU.LU_COSMOS_CD " + "\n");
		super.sql.append("	  ,LU.LU_NM " + "\n");
		super.sql.append("	  ,KEI.KEI_NO " + "\n");
		super.sql.append("	  ,KEI.HYJYO_KEI_NO " + "\n");
		super.sql.append("	  ,TRADE.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("	  ,TRADE.TRD_HNTE_KEKA_RYA " + "\n");
		super.sql.append("	  ,KEI.KNSHU_YMD " + "\n");
		super.sql.append("	  ,KEI.MRYO_YMD " + "\n");
		super.sql.append("	  ,KEI.KAI_YMD " + "\n");
		super.sql.append("	  ,KEI.KEI_TERM " + "\n");
		super.sql.append("	  ,KEI.DIH_BKN_NM " + "\n");
		//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 start
		if (batchFlg) {
			super.sql.append("FROM   W_KEI WKEI " + "\n");
			super.sql.append("     , T_KEI KEI  " + "\n");
		} else {
		//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 end
			
			super.sql.append("FROM   T_KEI KEI " + "\n");
		//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 start
		}
		//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 end
		super.sql.append("JOIN   M_LC LC ON KEI.LC_CD = LC.LC_CD " + "\n");
		super.sql.append("JOIN   M_TRD_HNTE_KEKA_KBN TRADE ON KEI.TRD_HNTE_KEKA_KBN = TRADE.TRD_HNTE_KEKA_KBN " + "\n");
		super.sql.append("JOIN   M_LU LU ON KEI.LU_COSMOS_CD = LU.LU_COSMOS_CD " + "\n");
		
		super.sql.append(where);
		super.sql.append("ORDER BY LC.LC_CD " + "\n");
		super.sql.append("	  ,KEI.LU_COSMOS_CD " + "\n");
		super.sql.append("	  ,KEI.HYJYO_KEI_NO " + "\n");
		super.sql.append("	  ,KEI.KEI_NO " + "\n");
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
	 * 検収日を取得.
	 * 
	 * @return 検収日
	 */
	public String getKenshuYMD() {
		return super.getString("KNSHU_YMD");
	}

	/**
	 * 満了日を取得.
	 * 
	 * @return 満了日
	 */
	public String getManryoYMD() {
		return super.getString("MRYO_YMD");
	}

	/**
	 * 解約日を取得.
	 * 
	 * @return 解約日
	 */
	public String getKaiyakuYMD() {
		return super.getString("KAI_YMD");
	}

	/**
	 * 契約期間を取得.
	 * 
	 * @return 契約期間
	 */
	public int getKeiyakuTerm() {
		return super.getInt("KEI_TERM");
	}

	/**
	 * 代表物件名を取得.
	 * 
	 * @return 物件名
	 */
	public String getDaihyoBukkenName() {
		return super.getString("DIH_BKN_NM");
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
	 * 代表物件名を設定.
	 * 
	 * @param piDaihyoBukkenName
	 *            代表物件名
	 */
	public void setDaihyoBukkenName(String piDaihyoBukkenName) {
		this.daihyoBukkenName = piDaihyoBukkenName;
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
	 * 検収年月Fromを設定.
	 * 
	 * @param piKenshuFrom
	 *            検収年月From
	 */
	public void setKenshuFrom(String piKenshuFrom) {
		this.kenshuFrom = piKenshuFrom;
	}

	/**
	 * 検収年月Toを設定.
	 * 
	 * @param piKenshuTo
	 *            検収年月To
	 */
	public void setKenshuTo(String piKenshuTo) {
		this.kenshuTo = piKenshuTo;
	}

	/**
	 * 満了年月Fromを設定.
	 * 
	 * @param piManryoFrom
	 *            満了年月From
	 */
	public void setManryoFrom(String piManryoFrom) {
		this.manryoFrom = piManryoFrom;
	}

	/**
	 * 満了年月Toを設定.
	 * 
	 * @param piManryoTo
	 *            満了年月To
	 */
	public void setManryoTo(String piManryoTo) {
		this.manryoTo = piManryoTo;
	}

	/**
	 * 解約年月Fromを設定.
	 * 
	 * @param piKaiyakuFrom
	 *            解約年月From
	 */
	public void setKaiyakuFrom(String piKaiyakuFrom) {
		this.kaiyakuFrom = piKaiyakuFrom;
	}

	/**
	 * 解約年月Toを設定.
	 * 
	 * @param piKaiyakuTo
	 *            解約年月To
	 */
	public void setKaiyakuTo(String piKaiyakuTo) {
		this.kaiyakuTo = piKaiyakuTo;
	}

	/**
	 * 契約金額を設定.
	 * 
	 * @param piKeiyakuAmt
	 *            契約金額
	 */
	public void setKeiyakuAmt(String piKeiyakuAmt) {
		this.keiyakuAmt = piKeiyakuAmt;
	}

	/**
	 * 契約期間を設定.
	 * 
	 * @param piKeiyakuTerm
	 *            契約期間
	 */
	public void setKeiyakuTerm(String piKeiyakuTerm) {
		this.keiyakuTerm = piKeiyakuTerm;
	}

	/**
	 * 代表物件検索パターンを設定.
	 * 
	 * @param piKenPatn
	 *            代表物件検索パターン
	 */
	public void setKenPatn(String piKenPatn) {
		this.kenPatn = piKenPatn;
	}

	/**
	 * 再リース指定を設定.
	 * 
	 * @param piKeiyakuRls
	 *            再リース指定
	 */
	public void setKeiyakuRls(String piKeiyakuRls) {
		this.keiyakuRls = piKeiyakuRls;
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
	
	//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 start
	/** バッチ出力のみ使用する.
	 * @param batchFlg バッチ実行フラグ
	 */
	public void setBatchFlg(boolean batchFlg) {
		this.batchFlg = batchFlg;
	}
	//　ADD Ren.SL LACS帳票バッチ出力  2013/04/10 end
}
