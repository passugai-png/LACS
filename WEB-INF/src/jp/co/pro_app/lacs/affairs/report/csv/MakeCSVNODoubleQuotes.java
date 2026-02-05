package jp.co.pro_app.lacs.affairs.report.csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * CSV出力：帳票一括出力用CSV.（各帳票の出力ページ数を出力する）
 * 
 * @author Liu.ZJ
 * @version 2013/03/29
 */
public class MakeCSVNODoubleQuotes {
	
	//CSV出力：ヘーダ設定
	@SuppressWarnings("unused")
	private String[] header = null;

	//CSV出力：出力内容設定
	private String[][] values = null;

	/**
	 * コンストラクタ 指定されたヘッダで出力用ＣＳＶを設定します.
	 * 
	 * @param piHeader
	 *            ヘッダ
	 */
	public MakeCSVNODoubleQuotes(String[] piHeader) {
		this.header = piHeader;
	}

	/**
	 * 出力内容配列を設定します.
	 * 
	 * @param piValues
	 *            出力内容
	 */
	public void setValues(String[][] piValues) {
		this.values = piValues;
	}

	/**
	 * ＣＳＶ編集した文字列を取得します.
	 * 
	 * @return 編集後文字列
	 */
	public String toString() {
		
		//CSVヘーダ出力
		StringBuffer buf = new StringBuffer();
		// 2020/05/22 DEL START LACS帳票バッチ出力
		//buf.append(makeLine(this.header, ""));
		// 2020/05/22 DEL END   LACS帳票バッチ出力

		//CSV内容出力
		for (int i = 0; i < this.values.length; i++) {
			buf.append(makeLine(this.values[i], ""));
		}

		//編集後文字列戻る
		return buf.toString();
	}

	/**
	 * 配列を元と区切り文字を元に1行分の文字列を作成します.
	 * 
	 * @param piData
	 *            配列
	 * @param piDelimiter
	 *            区切り文字
	 * @return 結果
	 */
	private String makeLine(String[] piData, String piDelimiter) {
		StringBuffer buf = new StringBuffer();
		boolean commaFlg = false;

		//出力各行内容
		for (int i = 0; i < piData.length; i++) {
			
			//コーマを追加
			if (commaFlg) {
				buf.append(",");
			}

			//各項目追加
			buf.append(piDelimiter + piData[i] + piDelimiter);
			commaFlg = true;
		}

		//結果を戻る
		return buf.toString() + "\n";
	}

	/**
	 * 生成した値をＣＳＶファイルに書き出します.
	 * 
	 * @param piPath
	 *            書き出すファイル名
	 * @throws IOException
	 *             入出力例外発生
	 */
	public void write(String piPath) throws IOException {
		BufferedWriter writer = null;

		try {
			
			//ファイルストリーム設定
			writer = new BufferedWriter(new FileWriter(piPath));

			//CSV出力
			writer.write(this.toString());
		}
		catch (IOException e) {
			throw e;
		}
		finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}