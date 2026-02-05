package jp.co.pro_app.lacs.affairs.common.command;

import java.util.Date;

import jp.co.pro_app.lacs.common.define.LACSDefine;
//import jp.co.pro_app.lacs.common.define.LACSDefine.MessageCode;
import jp.co.pro_app.projframe.common.command.CheckUtl;
import jp.co.pro_app.projframe.common.command.Convert;
import jp.co.pro_app.projframe.common.command.StringUtl;

/**
 * 入力チェック部品スーパークラス.
 * 
 * @author katoken
 * @version 20080918
 */
public class LACSCheckUtlBase {

	private static final String[]	TABOO_CHAR	= new String[]{ "'" };

	/**
	 * メッセージ.
	 */
	protected LACSMessage			message		= null;

	/**
	 * コンストラクタ.
	 * 
	 * @param piMessage
	 *            メッセージ
	 */
	public LACSCheckUtlBase(LACSMessage piMessage) {
		this.message = piMessage;
	}

	/**
	 * 日付順チェック.
	 * 
	 * @param piName
	 *            項目名
	 * @param piDateFrom
	 *            開始日付オブジェクト
	 * @param piDateTo
	 *            終了日付オブジェクト
	 * @return 判定結果
	 */
	public boolean checkDateOrder(String piName, Date piDateFrom, Date piDateTo) {
		boolean result = true;

		if (piDateFrom.compareTo(piDateTo) > 0) {
			this.message.addMessage(LACSDefine.MessageCode.ERROR_RELATE_COMBINATION, piName);
			result = false;
		}

		return result;
	}

	/**
	 * 数値チェック.
	 * 
	 * @param piName
	 *            項目名
	 * @param piData
	 *            オブジェクト
	 * @return 判定結果
	 */
	public boolean checkNumeric(String piName, String piData) {
		return this.checkNumeric(piName, piData, 0);
	}

	/**
	 * 数値チェック.
	 * 
	 * @param piName
	 *            項目名
	 * @param piData
	 *            オブジェクト
	 * @param piMax
	 *            最大値
	 * @return 判定結果
	 */
	public boolean checkNumeric(String piName, String piData, long piMax) {
		boolean result = true;

		if (piData.trim().length() > 0) {
			if (!CheckUtl.isLong(piData)) {
				this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_INVALID_NUMERIC, piName);
				result = false;
			}
			else {
				if (piMax > 0 && Long.parseLong(piData) > piMax) {
					this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_OVER_MAX_NUMBER, new String[]{ piName, Convert.toString(piMax) });
					result = false;
				}
			}
		}

		return result;
	}

	/**
	 * 必須チェック.
	 * 
	 * @param piName
	 *            項目名
	 * @param piData
	 *            オブジェクト
	 * @return 判定結果
	 */
	public boolean checkMandatory(String piName, String piData) {
		boolean result = true;

		if (piData.trim().length() == 0) {
			this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_MANDATORY, piName);
			result = false;
		}

		return result;
	}

	/**
	 * 半角チェック.
	 * 
	 * @param piName
	 *            項目名
	 * @param piData
	 *            オブジェクト
	 * @return 判定結果
	 */
	public boolean checkHalfOnly(String piName, String piData) {
		boolean result = true;

		if (piData.trim().length() > 0) {
			if (!CheckUtl.checkHalfOnly(piData)) {
				this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_INVALID_DATE, piName);
				result = false;
			}
		}

		return result;
	}

	/**
	 * 半角英数チェック.
	 * 
	 * @param piName
	 *            項目名
	 * @param piData
	 *            オブジェクト
	 * @return 判定結果
	 */
	public boolean checkAlNumHalf(String piName, String piData) {
		boolean result = true;

		if (piData.trim().length() > 0) {
			if (!CheckUtl.checkAlNumHalf(piData)) {
				this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_ALNUM_HALF, piName);
				result = false;
			}
		}

		return result;
	}

	/**
	 * 複数文字種が入力されている事をチェックします. 20200522 arai 
	 * 
	 * @param piName
	 *            項目名
	 * @param piData
	 *            オブジェクト
	 * @param piMustAlphabet
	 *            アルファベットの必須有無[true：必須／false：任意]
	 * @param piMustNumber
	 *            数字の必須有無[true：必須／false：任意]
	 * @param piMustSymbol
	 *            記号の必須有無[true：必須／false：任意]
	 * @return 判定結果
	 */
	public boolean checkComplex(String piName, String piData, boolean piMustAlphabet, boolean piMustNumber, boolean piMustSymbol) {
		boolean result = true;
		int complex = 0;
		int mustCount = 0;
		boolean hitSw = false;	
		boolean hitSw2 = false;

		if (piMustAlphabet) {
			mustCount++;
		}

		if (piMustNumber) {
			mustCount++;
		}

		if (piMustSymbol) {
			mustCount++;
		}

		if (piData.trim().length() > 0) {
			if (piMustAlphabet) {
				for (int i = 0; i < piData.length(); i++) {
					if (('a' <= piData.charAt(i) && piData.charAt(i) <= 'z')) {
						complex++;
						break;
					}			       
				}
				
				for (int i = 0; i < piData.length(); i++) {
					if (('A' <= piData.charAt(i) && piData.charAt(i) <= 'Z')) {
						complex++;
						break;
					}			       
				}
			}

			if (piMustNumber) {
				for (int i = 0; i < piData.length(); i++) {
					if ('0' <= piData.charAt(i) && piData.charAt(i) <= '9') {
						complex++;
						break;
					}
				}
			}

			if (piMustSymbol) {				
				for (int i = 0; i < piData.length(); i++) {
					switch (piData.charAt(i)) {
						case '!':
						case '#':
						case '$':
						case '&':
						case '(':
						case ')':
						case '=':
						case '~':
						case '\\':
						case '[':
						case ']':
						case '<':
						case '>':
						case '_':
						case '/':
						case '*':
						case '-':
						case '+':
							hitSw = true;
							break;
						default:
							if (!(('a' <= piData.charAt(i) && piData.charAt(i) <= 'z') || ('A' <= piData.charAt(i) && piData.charAt(i) <= 'Z') || ('0' <= piData.charAt(i) && piData.charAt(i) <= '9'))) {								   
								hitSw2 = true;							
								break;
							}
							break;
					}

					if (hitSw) {
						complex++;
						break;
					}
				}							
			}

			if (complex < mustCount || hitSw2) {
				this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_COMPLEX_CHARACTER, piName);				
				result = false;
			}
						
		}

		return result;
	}

	/**
	 * 電話番号チェック.
	 * 
	 * @param piName
	 *            項目名
	 * @param piData
	 *            オブジェクト
	 * @return 判定結果
	 */
	public boolean checkTelFax(String piName, String piData) {
		boolean result = true;

		if (!CheckUtl.isTelFax(piData)) {
			this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_INVALID_TEL_FAX, piName);
			result = false;
		}

		return result;
	}

	/**
	 * 日付チェック.
	 * 
	 * @param piName
	 *            項目名
	 * @param piData
	 *            オブジェクト
	 * @return 判定結果
	 */
	public boolean checkDate(String piName, String piData) {
		boolean result = true;

		if (piData.trim().length() >= 8) {
			if (!CheckUtl.isDate(CheckUtl.isLong(piData) ? Convert.toDateString(piData) : piData)) {
				this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_INVALID_DATE, piName);
				result = false;
			}
		}
		else if (piData.trim().length() > 0) {
			this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_INVALID_DATE, piName);
			result = false;
		}

		return result;
	}

	/**
	 * 桁数チェック.
	 * 
	 * @param piName
	 *            項目名
	 * @param piData
	 *            オブジェクト
	 * @param piLength
	 *            桁数
	 * @return 判定結果
	 */
	public boolean checkLength(String piName, String piData, int piLength) {
		boolean result = true;

		if (piData.trim().length() > 0) {
			if (piData.getBytes().length > piLength) {
				this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_LENGTH, piName);
				result = false;
			}
		}

		return result;
	}

	/**
	 * 桁数チェック.
	 * 
	 * @param piName
	 *            項目名
	 * @param piData
	 *            オブジェクト
	 * @param piMinLength
	 *            最小桁数
	 * @param piMaxLength
	 *            最大桁数
	 * @return 判定結果
	 */
	public boolean checkLength(String piName, String piData, int piMinLength, int piMaxLength) {
		boolean result = true;

		if (piData.trim().length() > 0) {
			if (piData.getBytes().length < piMinLength || piMaxLength < piData.getBytes().length) {
				if (piMinLength == piMaxLength) {
					this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_LENGTH_RANGE_SAME, new String[]{ piName, Convert.toString(piMinLength) });
				}
				else {
					this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_LENGTH_RANGE, new String[]{ piName, Convert.toString(piMinLength), Convert.toString(piMaxLength) });
				}
				result = false;
			}
		}

		return result;
	}

	/**
	 * 小数チェック.
	 * 
	 * @param piName
	 *            項目名
	 * @param piData
	 *            オブジェクト
	 * @param piSeiLen
	 *            整数桁数
	 * @param piSyouLen
	 *            小数桁数
	 * @param piMessage
	 *            メッセージ
	 * @return 判定結果
	 */
	public boolean checkDecimal(String piName, String piData, int piSeiLen, int piSyouLen, LACSMessage piMessage) {
		boolean result = true;

		if (piData.trim().length() > 0) {
			try {
				double data = Double.parseDouble(StringUtl.toHalfChar(piData.trim()).replaceAll("．", "."));
				String[] dataAry = Double.toString(data).split("\\.");

				if (Long.toString(Math.abs(Long.parseLong(dataAry[0]))).length() > piSeiLen) {
					piMessage.addMessage(LACSDefine.MessageCode.ERROR_FIELD_LENGTH, piName);
					result = false;
				}
				else if (dataAry.length > 1 && Long.toString(Long.parseLong(dataAry[1])).length() > piSyouLen) {
					piMessage.addMessage(LACSDefine.MessageCode.ERROR_FIELD_LENGTH, piName);
					result = false;
				}
			}
			catch (Exception ex) {
				piMessage.addMessage(LACSDefine.MessageCode.ERROR_FIELD_INVALID_DATE, piName);
				result = false;
			}
		}

		return result;
	}

	/**
	 * 禁則文字チェック.
	 * 
	 * @param piName
	 *            項目名
	 * @param piData
	 *            オブジェクト
	 * @return 判定結果
	 */
	public boolean checkTabooChar(String piName, String piData) {
		boolean result = true;

		if (piData.trim().length() > 0) {
			for (int i = 0; i < TABOO_CHAR.length; i++) {
				if (piData.indexOf(TABOO_CHAR[i]) >= 0) {
					this.message.addMessage(LACSDefine.MessageCode.ERROR_FIELD_TABOO_CHAR, piName);
					result = false;
					break;
				}
			}
		}

		return result;
	}
}
