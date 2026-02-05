package jp.co.pro_app.lacs.affairs.syousai.writer;

import java.io.File;
import java.sql.Connection;

import jakarta.servlet.ServletContext;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiBean;
import jp.co.pro_app.lacs.affairs.syousai.data.entity.LACSSyousaiCSVEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;
import jp.co.pro_app.projframe.common.exception.NoDataException;

/**
 * 契約詳細帳票出力：契約詳細表CSV出力.
 * 
 * @author yokota
 * @version 20081017
 */
public class LACSReportCSVKeiyakuSyousaiWriter extends LACSReportCSVWriterBase {

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
	public LACSReportCSVKeiyakuSyousaiWriter(LACSCommonBean piCommonBean, LACSModelBase piModel, Connection piCon) {
		super(piCommonBean, piModel, piCon);
	}

	/**
	 * CSV作成.
	 * 
	 * @param piSyousaiBean
	 *            契約詳細Bean
	 * @param piDateMode
	 *            西暦和暦モード
	 * @param piContext
	 *            ServletContext
	 * @return PDFファイル名
	 * @exception Exception
	 *                実行例外
	 */
	public String makeCSV(LACSSyousaiBean piSyousaiBean, String piDateMode, ServletContext piContext) throws Exception {
		LACSSyousaiCSVEntity syousaiCSVEntity = new LACSSyousaiCSVEntity(super.model, this.commonBean, piSyousaiBean);
		String fileName = "";

		syousaiCSVEntity.setKeiyakuNo(piSyousaiBean.getKeiyakuNo());
		syousaiCSVEntity.setLeasCompanyCode(piSyousaiBean.getLeasCompanyCode());

		File tmpFile = null; // 出力先ファイル
		String[] header = new String[]{ "作成日", "リース会社名", "開示先", "契約番号", "リース期間", "契約日", "検収日", "満了日", "中途解約日", "代表物件名", "譲渡条件付フラグ", "譲渡条件名称", "割安購入選択権付フラグ", "割安購入選択権名称", "特別仕様物件フラグ", "特別仕様物件名称", "中途解約可能区分", "中途解約可能区分名称", "リース取引分類", "リース取引分類名称", "リース資産計上額", "契約額", "見積現金購入価格", "消費税総額", "支払利息相当額総額", "残価保証額", "維持管理費相当額総額", "役務提供費相当額総額", "利息配分方法", "利息配分方法名称", "リース料計算基準", "リース料計算基準名称", "減価償却端数調整コード", "減価償却端数調整方法名称", "少額資産区分", "少額資産名称", "物件番号", "物件名", "機械番号", "固定資産科目コード", "固定資産科目名称", "数量", "単位", "設置場所", "取得価格相当額", "割引計算利子率", "利息計算利子率", "償却計上方法", "償却計上方法名称", "残価保証有無", "維持管理費相当額", "役務提供費相当額" };

		String[] columns = new String[]{ "CREATE_DATE", "LEASE_COMPANY_NM", "LEASE_USER_NM", "HYJYO_KEI_NO", "KEI_TERM", "KEI_YMD", "KNSHU_YMD", "MRYO_YMD", "KAI_YMD", "DIH_BKN_NM", "JOTO_JKN_FLG", "JOTO_JKN_NM", "WRYS_KNU_SNTK_FLG", "WRYS_KNU_SNTK_NM", "SPCL_SIYO_BKN_FLG", "SPCL_SIYO_BKN_NM", "CYT_KAI_KANO_KBN", "CYT_KAI_KANO_KBN_NM", "TRD_HNTE_KEKA_KBN", "TRD_HNTE_KEKA_NM", "LAMT_SUM", "KEI_AMT", "KNU_AMT", "KEI_AMT_STAX_SUM", "RSK_SUM", "ZANK_HSHO_AMT_SUM", "IJI_HYO_SUM", "EKM_HYO_SUM", "RSK_KEIJ_HOHO_KBN", "RSK_KEIJ_HOHO_KBN_NM", "TNKI_HOHO_KBN", "FKN_TNKI_HOHO_NM", "GNKSK_HASU_CHSE_CD", "HASU_CHSE_NM", "SGK_SSN_KBN", "SGK_SSN", "BKN_NO", "BKN_NM", "KKI_NO", "SSN_SRI_CD", "SSN_SRI_NM", "BKN_SU", "BKN_UNT", "ST_PLC_ADR", "WRBK_PV", "WRBK_RS_RT", "RSK_CLC_RS_RT", "SKK_KEIJ_HOHO_KBN", "DISP_SKK_HOHO_NM", "ZANK_UMU", "IJI_KANRI_HI", "EKM_TEIK_HI" };
		try {
			syousaiCSVEntity.setCon(super.con);

			if (syousaiCSVEntity.execSQL() == 0) {
				throw new NoDataException();
			}

			scratchDirectory = new File(piContext.getRealPath(SCRATCH_PATH));

			tmpFile = File.createTempFile("csv31_", ".csv", scratchDirectory);

			syousaiCSVEntity.write(tmpFile.getAbsolutePath(), header, columns);

			fileName = tmpFile.getName();
		}
		finally {
			syousaiCSVEntity.close();
		}

		return fileName;

	}
}
