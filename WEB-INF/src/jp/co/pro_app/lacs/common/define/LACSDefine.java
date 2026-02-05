package jp.co.pro_app.lacs.common.define;

/**
 * 定数.
 * 
 * @author katoken
 * @version 20070312
 */
public final class LACSDefine {

	/**
	 * Bean名.
	 * 
	 * @author katoken
	 * @version 20070312
	 */
	public class BeanName {

		/**
		 * 共通Bean.
		 */
		public static final String	COMMON_BEAN				= "commonBean";

		/**
		 * 支払推移表Bean.
		 */
		public static final String	SHIHARAI_BEAN			= "shiharaiBean";

		/**
		 * 仕訳照会Bean.
		 */
		public static final String	SHIWAKE_BEAN			= "shiwakeBean";

		/**
		 * 契約検索Bean.
		 */
		public static final String	KEIYAKU_BEAN			= "keiyakuBean";

		/**
		 * 物件検索Bean.
		 */
		public static final String	BUKKEN_BEAN				= "bukkenBean";

		/**
		 * 帳票出力Bean.
		 */
		public static final String	REPORT_BEAN				= "reportBean";

		/**
		 * リース会社マスタBean.
		 */
		public static final String	COMPANY_BEAN			= "companyBean";

		/**
		 * リース会社別リースユーザーマスタBean.
		 */
		public static final String	COMPANYUSER_BEAN		= "companyUserBean";

		/**
		 * リースユーザーマスタBean.
		 */
		public static final String	USER_BEAN				= "userBean";

		/**
		 * リースユーザー別借入利子率マスタBean.
		 */
		public static final String	KARI_RISI_BEAN			= "kariRisiBean";

		/**
		 * リースユーザー担当者マスタBean.
		 */
		public static final String	TANTO_BEAN				= "tantoBean";

		/**
		 * リース会社マスタ一覧Bean.
		 */
		public static final String	COMPANY_LIST_BEAN		= "companyListBean";

		/**
		 * リース会社別リースユーザーマスタ一覧Bean.
		 */
		public static final String	COMPANY_USER_LIST_BEAN	= "companyUserListBean";

		/**
		 * リースユーザーマスタ一覧Bean.
		 */
		public static final String	USER_LIST_BEAN			= "userListBean";

		/**
		 * リースユーザー担当者マスタ一覧Bean.
		 */
		public static final String	TANTO_LIST_BEAN			= "tantoListBean";

		/**
		 * リースユーザー別借入利子率マスタ一覧Bean.
		 */
		public static final String	KARI_RISI_LIST_BEAN		= "kariRisiListBean";

		/**
		 * 月次帳票出力Bean.
		 */
		public static final String	MREPORT_BEAN			= "mreportBean";

		/**
		 * 注記合計表印刷予約Bean.
		 */
		public static final String	NSREPORT_BEAN			= "nsreportBean";

		/**
		 * お知らせBean.
		 */
		public static final String	INFO_BEAN				= "infoBean";

		/**
		 * お知らせ一覧Bean.
		 */
		public static final String	INFO_LIST_BEAN			= "infoListBean";

		/**
		 * 受払合計表Bean.
		 */
		public static final String	UKEBARAI_BEAN			= "ukebaraiBean";

		/**
		 * 契約詳細Bean.
		 */
		public static final String	SYOUSAI_BEAN			= "syousaiBean";

		/**
		 * 契約詳細帳票出力Bean.
		 */
		public static final String	SYOUSAI_REPORT_BEAN		= "syousaireportBean";

		/**
		 * ログインBean.
		 */
		public static final String	LOGIN_BEAN				= "loginBean";

		/**
		 * パスワードBean.
		 */
		public static final String	PASSWORD_BEAN			= "passwordBean";

		/**
		 * DS向け注記合計表.
		 */
		public static final String	DS_REPORT_BEAN			= "dsReportBean";

		/**
		 * 強制変更一覧.
		 */
		public static final String	COMPULSORY_CHANGE_BEAN	= "compulsorychangeBean";
	}

	/**
	 * 西暦和暦区分.
	 * 
	 * @author katoken
	 * @version 20070312
	 */
	public class DateMode {

		/**
		 * 西暦.
		 */
		public static final String	SEIREKI	= "1";

		/**
		 * 和暦.
		 */
		public static final String	WAREKI	= "2";
	}

	/**
	 * 利息計上方法区分.
	 * 
	 * @author katoken
	 * @version 20070312
	 */
	public class RisokuKeijoHohoKbn {

		/**
		 * 利息法（前取）.
		 */
		public static final String	RSKHO_ZEN_GET_101	= "101";

		/**
		 * 利息法（後取）.
		 */
		public static final String	RSKHO_ATO_GET_102	= "102";

		/**
		 * 利息無視.
		 */
		public static final String	RSKMUSI_201			= "201";

		/**
		 * 均等.
		 */
		public static final String	KINTOHO_301			= "301";
	}

	/**
	 * 償却計上方法区分.
	 * 
	 * @author katoken
	 * @version 20070312
	 */
	public class ShoukyakuKeijoHohoKbn {

		/**
		 * 償却総額=見積現金購入価格、償却期間＝耐用年数、償却計算方法＝定額法.
		 */
		public static final String	TY_YSU_TGKHO_111		= "111";

		/**
		 * 償却総額=見積現金購入価格、償却期間＝耐用年数、償却計算方法＝定率法.
		 */
		public static final String	TY_YSU_TRTHO_112		= "112";

		/**
		 * 償却総額=見積現金購入価格、償却期間＝耐用年数、償却計算方法＝級数法.
		 */
		public static final String	TY_YSU_KYSHO_113		= "113";

		/**
		 * 償却総額=見積現金購入価格、償却期間＝リース期間、償却計算方法＝定額法.
		 */
		public static final String	LTRM_BKN_PS_TGKHO_121	= "121";

		/**
		 * 償却総額=見積現金購入価格、償却期間＝リース期間、償却計算方法＝定率法.
		 */
		public static final String	LTRM_BKN_PS_TRTHO_122	= "122";

		/**
		 * 償却総額=見積現金購入価格、償却期間＝リース期間、償却計算方法＝級数法.
		 */
		public static final String	LTRM_BKN_PS_KYSHO_123	= "123";

		/**
		 * 償却総額=リース料総額、償却期間＝リース期間、償却計算方法＝定額法.
		 */
		public static final String	LTRM_LS_TTL_TGKHO_221	= "221";

		/**
		 * 償却総額=リース料総額、償却期間＝リース期間、償却計算方法＝定率法.
		 */
		public static final String	LTRM_LS_TTL_TRTHO_222	= "222";

		/**
		 * 償却総額=リース料総額、償却期間＝リース期間、償却計算方法＝級数法.
		 */
		public static final String	LTRM_LS_TTL_KYSHO_223	= "223";
	}

	/**
	 * 取引判定結果区分.
	 * 
	 * @author takeda
	 * @version 20070823
	 */
	public class TorihikiHanteiKekkaKbn {

		/**
		 * 所有権移転ファイナンスリース.
		 */
		public static final String	ITEN_FINANCE_LEAS_1		= "1";

		/**
		 * 所有権移転外ファイナンスリース.
		 */
		public static final String	ITEN_GAI_FINANCE_LEAS_2	= "2";

		/**
		 * オペレーティングリース.
		 */
		public static final String	OPERATING_LEAS_3		= "3";
	}

	/**
	 * 資産種類コード.
	 * 
	 * @author takeda
	 * @version 20070823
	 */
	public class SisanSyuruiCode {

		/**
		 * 構築物・建物付属設備.
		 */
		public static final String	KOUTIKU_TATEMOMO_1	= "1";

		/**
		 * 機械及び装置.
		 */
		public static final String	KIKAI_SOUTI_2		= "2";

		/**
		 * 船舶.
		 */
		public static final String	SENPAKU_3			= "3";

		/**
		 * 航空機.
		 */
		public static final String	KOUKUKI_4			= "4";

		/**
		 * 車両及び運搬具.
		 */
		public static final String	SYARYOU_UNPAN_5		= "5";

		/**
		 * 工具器具及び備品.
		 */
		public static final String	KOUGU_BIHIN_6		= "6";

		/**
		 * 無形固定資産.
		 */
		public static final String	MUKEI_KOTEI_SISAN_9	= "9";
	}

	/**
	 * 前払後払区分.
	 * 
	 * @author ohmura
	 * @version 20070828
	 */
	public class MaebaraiAtobaraiKbn {

		/**
		 * 前払.
		 */
		public static final String	MAE_BARAI_0	= "0";

		/**
		 * 後払.
		 */
		public static final String	ATO_BARAI_1	= "1";
	}

	/**
	 * 賦金展開方法コード.
	 * 
	 * @author ohmura
	 * @version 20070903
	 */
	public class FukinTenkaiHouhouCd {

		/**
		 * 費用発生ベース.
		 */
		public static final String	HIYOU_BASE_1	= "1";

		/**
		 * 支払日ベース.
		 */
		public static final String	SIHARAI_BASE_2	= "2";
	}

	/**
	 * メッセージID.
	 * 
	 * @author katoken
	 */
	public class MessageCode {

		/**
		 * DBチェック 検索結果0件.
		 */
		public static final String	WARN_DB_NORESULT							= "IW0001";

		/**
		 * 単項目チェック 必須エラー.
		 */
		public static final String	ERROR_FIELD_MANDATORY						= "EWT001";

		/**
		 * 関連チェック 組み合わせエラー.
		 */
		public static final String	ERROR_RELATE_COMBINATION					= "EWK002";

		/**
		 * DBチェック ログインエラー.
		 */
		public static final String	ERROR_DB_LOGIN								= "EWD003";

		/**
		 * 単項目チェック 日付エラー.
		 */
		public static final String	ERROR_FIELD_INVALID_DATE					= "EWT004";

		/**
		 * 単項目チェック 数値エラー.
		 */
		public static final String	ERROR_FIELD_INVALID_NUMERIC					= "EWT005";

		/**
		 * 単項目チェック 未存在エラー.
		 */
		public static final String	ERROR_FIELD_NOT_EXIST						= "EWT006";

		/**
		 * 単項目チェック 桁数エラー.
		 */
		public static final String	ERROR_FIELD_LENGTH							= "EWT007";

		/**
		 * 関連チェック 未選択エラー.
		 */
		public static final String	ERROR_RELATE_NON_CHECK						= "EWK008";

		/**
		 * 単項目チェック 電話番号エラー.
		 */
		public static final String	ERROR_FIELD_INVALID_TEL_FAX					= "EWT009";

		/**
		 * DBチェック 関連データ有り.
		 */
		public static final String	ERROR_DB_RELATE_DATA_EXIST					= "EWD010";

		/**
		 * DBチェック 関連データ有り.
		 */
		public static final String	ERROR_DB_DATA_EXIST							= "EWD011";

		/**
		 * 関連チェック リース料支払スケジュール表出力時に契約番号が指定されていない.
		 */
		public static final String	ERROR_RELATE_SHIHARAI_SCHEDUKE_KEI_NO		= "EWK012";

		/**
		 * 関連チェック リース会計基準明細書出力時に契約番号が指定されていない.
		 */
		public static final String	ERROR_RELATE_KAIKEI_MEISAI_KEI_NO			= "EWK013";

		/**
		 * 関連チェック 利息無視でリース料総額以外を選択.
		 */
		public static final String	ERROR_RELATE_RISOKUMUSI						= "EWK014";

		/**
		 * 関連チェック 利息無視以外でリース料総額を選択.
		 */
		public static final String	ERROR_RELATE_NOT_RISOKUMUSI					= "EWK015";

		/**
		 * 関連チェック 利息無視の時に重要性区分は計上するを選択.
		 */
		public static final String	ERROR_RELATE_RISOKUMUSI_JYUYOUSEI			= "EWK016";

		/**
		 * 単項目チェック 文字数オーバー(バイト数ではない).
		 */
		public static final String	ERROR_FIELD_CHAR_COUNT						= "EWT017";

		/**
		 * 関連チェック 契約番号未指定で物件番号指定の場合.
		 */
		public static final String	ERROR_RELATE_KEI_NO_BKN_NO					= "EWK018";

		/**
		 * 単項目チェック 禁則文字エラー.
		 */
		public static final String	ERROR_FIELD_TABOO_CHAR						= "EWT019";

		/**
		 * 関連チェック 帳票およびＣＳＶ表示用リース会社情報入力時で入力漏れがある場合.
		 */
		public static final String	ERROR_RELATE_PDF_COMPANY					= "EWK020";

		/**
		 * 単項目チェック 数値上限エラー.
		 */
		public static final String	ERROR_FIELD_OVER_MAX_NUMBER					= "EWT021";

		/**
		 * 単項目チェック 数値下限エラー.
		 */
		public static final String	ERROR_FIELD_OVER_MIN_NUMBER					= "EWT022";

		/**
		 * DBチェック ログイン中のユーザあり.
		 */
		public static final String	ERROR_DB_LOGGEDIN							= "EWD023";

		/**
		 * 単項目チェック 桁数の超過および不足.
		 */
		public static final String	ERROR_FIELD_LENGTH_RANGE					= "EWT024";

		/**
		 * 関連チェック 2項目の値が異なる.
		 */
		public static final String	ERROR_RELATE_FIELD_DIFFERENT				= "EWK025";

		/**
		 * DBチェック DBの値と異なる.
		 */
		public static final String	ERROR_DB_DATA_DIFFERENT						= "EWD026";

		/**
		 * DBチェック ユーザーがロックされている.
		 */
		public static final String	ERROR_DB_USER_LOCKED						= "EWD027";

		/**
		 * DBチェック 仮パスワード有効期限切れ.
		 */
		public static final String	ERROR_DB_USER_KARIPW_EXPIRED				= "EWD028";

		/**
		 * DBチェック ログイン中.
		 */
		public static final String	ERROR_DB_USER_LOGGED_IN						= "EWD029";

		/**
		 * DBチェック パスワード使用済み.
		 */
		public static final String	ERROR_DB_USED_PASSWORD						= "EWD030";

		/**
		 * 単項目チェック 半角英数字チェック.
		 */
		public static final String	ERROR_FIELD_ALNUM_HALF						= "EWT031";

		/**
		 * 関連チェック 利用できる画面がない.
		 */
		public static final String	ERROR_RELATE_NO_AVAILABLE_FUNCTION			= "EWK032";

		/**
		 * 関連チェック 利用できる帳票がない.
		 */
		public static final String	ERROR_RELATE_NO_AVAILABLE_REPORT			= "EWK033";

		/**
		 * 関連チェック 重複値あり.
		 */
		public static final String	ERROR_RELATE_DUPLICATE						= "EWK034";

		/**
		 * DBチェック 仮パスワードから本パスワードへの変更要求.
		 */
		public static final String	ERROR_DB_USER_FORCE_HONPW					= "EWD035";

		/**
		 * DBチェック 本パスワード有効期限切れ.
		 */
		public static final String	ERROR_DB_USER_HONPW_EXPIRED					= "EWD036";

		/**
		 * DBチェック 物件数が多いためリース料支払スケジュール表が出力できない.
		 */
		public static final String	ERROR_DB_BUKKEN_TOO_MANY					= "EWD037";

		/**
		 * 関連チェック リース料支払スケジュール表出力時に契約番号が指定されていない.
		 */
		public static final String	ERROR_RELATE_SHIHARAI_SCHEDUKE_KEI_KEI_NO	= "EWK038";

		/**
		 * 単項目チェック 英字・数字・記号の入力必須.
		 */
		public static final String	ERROR_FIELD_COMPLEX_CHARACTER				= "EWT039";

		/**
		 * 単項目チェック LDAP認証エラー(管理者へ連絡).
		 */
		public static final String	ERROR_FIELD_LDAP_ADMIN						= "EWT040";

		/**
		 * 単項目チェック パスワード有効期限切れ.
		 */
		public static final String	ERROR_FIELD_PW_EXPIRED						= "EWT041";

		/**
		 * 関連チェック パスワード変更時のＩＤ・パスワードエラー.
		 */
		public static final String	ERROR_RELATE_PWCHG_LOGIN					= "EWK042";

		/**
		 * DBチェック パスワード変更時のユーザー権限エラー.
		 */
		public static final String	ERROR_DB_PWCHG_RIGHT						= "EWD043";

		/**
		 * DBチェック パスワード有効期限切れ(NTF).
		 */
		public static final String	ERROR_FIELD_PW_EXPIRED_NTF					= "EWD044";

		/**
		 * 胆項目チェック 使用できない文字が入力されている.
		 */
		public static final String	ERROR_FIELD_TABOO_CHAR_EX					= "EWT046";

		/**
		 * 単項目チェック 桁数の超過および不足(最小=最大).
		 */
		public static final String	ERROR_FIELD_LENGTH_RANGE_SAME				= "EWT047";
	}

	/**
	 * 動作モード.
	 * 
	 * @author katoken
	 */
	public class AppMode {

		/**
		 * リース会社モード.
		 */
		public static final int	APP_MODE_COMPANY	= 0;

		/**
		 * リースユーザーモード.
		 */
		public static final int	APP_MODE_FIXED_USER	= 1;
	}

	/**
	 * メニューモード.
	 * 
	 * @author katoken
	 */
	public class MenuMode {

		/**
		 * 管理者モード.
		 */
		public static final int	MENU_MODE_ADMIN		= 0;

		/**
		 * 事業所モード.
		 */
		public static final int	MENU_MODE_OFFICE	= 1;
	}

	/**
	 * 処理モード.
	 * 
	 * @author katoken
	 */
	public class ProcMode {

		/**
		 * 新規.
		 */
		public static final int	PROC_MODE_NEW	= 1;

		/**
		 * 更新.
		 */
		public static final int	PROC_MODE_UPD	= 2;
	}

	/**
	 * 対象会計基準.
	 * 
	 * @author katoken
	 */
	public class AccountStandard {

		/**
		 * 旧会計基準.
		 */
		public static final String	OLD_0		= "0";

		/**
		 * 旧会計基準名称.
		 */
		public static final String	OLD_0_NAME	= "旧リース会計基準";

		/**
		 * 新会計基準.
		 */
		public static final String	NEW_1		= "1";

		/**
		 * 新会計基準名称.
		 */
		public static final String	NEW_1_NAME	= "新リース会計基準";

	}

	/**
	 * 会計処理区分.
	 * 
	 * @author katoken
	 */
	public class KaikeiSyori {

		/**
		 * 詳細.
		 */
		public static final String	SYOUSAI_0		= "0";

		/**
		 * 簡略.
		 */
		public static final String	KANRYAKU_1		= "1";

		/**
		 * 詳細.
		 */
		public static final String	SYOUSAI_NM_0	= "詳細注記";

		/**
		 * 簡略.
		 */
		public static final String	KANRYAKU_NM_1	= "簡略注記";
	}

	/**
	 * オプションコード.
	 * 
	 * @author Katoken
	 */
	public class OptionCode {

		/**
		 * 受払履歴オプション.
		 */
		public static final int	HISTORY_DATA	= 1;

		/**
		 * ユーザーヘルプ出力制御.
		 */
		public static final int	USER_HELP		= 2;

		/**
		 * コピーライト表示有無.
		 */
		public static final int	COPY_RIGHT		= 3;

		/**
		 * 可変文言出力制御.
		 */
		public static final int	TYUKI_COMMENT	= 4;

		/**
		 * リース料支払スケジュール件数.
		 */
		public static final int	SCHEDULE_MAX	= 5;

		/**
		 * 固定資産台帳表示制御.
		 */
		public static final int	SISAN_DSP		= 13;

		/**
		 * 消費税明細表表示制御.
		 */
		public static final int	SYOUHIZEI_DSP	= 14;

		/**
		 * 注記合計表表示制御.
		 */
		public static final int	GOKEI_DSP		= 15;

		/**
		 * 注記書類作成基準書制御.
		 */
		public static final int	TYUKI_PDF		= 25;
		
		/**
		 * PDF分割ページ数.
		 */
		public static final int	PDF_CUT_PAGE	= 26;

		/**
		 * 注記源泉CSV１年超明細有無.
		 */
		public static final int	TYUKI_GENSEN_MEISAI_DSP	= 31;
	}

	/**
	 * 利用者権限.
	 * 
	 * @author Katoken
	 */
	public class UserRight {

		/**
		 * エンドユーザー.
		 */
		public static final String	END_USER	= "1";

		/**
		 * 一般社員.
		 */
		public static final String	GENERAL		= "2";

		/**
		 * 管理者.
		 */
		public static final String	ADMIN		= "3";
	}

	/**
	 * 集計単位.
	 * 
	 * @author Katoken
	 */
	public class SumUnit {

		/**
		 * 契約単位.
		 */
		public static final String	SUM_UNT_KEI_0	= "0";

		/**
		 * 物件単位.
		 */
		public static final String	SUM_UNT_BKN_1	= "1";
	}

	/**
	 * 契約が存在しないエラーの契約番号.
	 */
	public static final String	ERROR_KEIYAKU	= "####################";

	/**
	 * 是開示先対象のお知らせ用COSMOSコード.
	 */
	public static final String	INFO_ALL		= "##########";

	/**
	 * リース会社コード.
	 */
	public static final String	LC_CD			= "LACS";
}
