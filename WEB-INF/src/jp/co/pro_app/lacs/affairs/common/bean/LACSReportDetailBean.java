package jp.co.pro_app.lacs.affairs.common.bean;

/**
 * 帳票出力：出力対象帳票Bean.
 * 
 * @author ohmura
 * @version 20070905
 */
public class LACSReportDetailBean extends LACSBeanBase {

	private static final long serialVersionUID = 1L;

	private String	fileName	= "";	// ファイル名

	private int		checkOutput	= 0;	// 出力対象チェック

	/**
	 * 初期化.
	 */
	public void init() {
		fileName = "";
		checkOutput = 1;
	}

	/**
	 * 初期化.
	 * 
	 * @param piCheckOutput
	 *            出力チェック
	 */
	public void init(int piCheckOutput) {
		fileName = "";
		checkOutput = piCheckOutput;
	}

	/**
	 * ファイル名を取得.
	 * 
	 * @return ファイル名
	 */
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * ファイル名を設定.
	 * 
	 * @param piFileName
	 *            ファイル名
	 */
	public void setFileName(String piFileName) {
		this.fileName = piFileName;
	}

	/**
	 * 出力対象チェックを取得.
	 * 
	 * @return 出力対象チェック
	 */
	public int getCheckOutput() {
		return this.checkOutput;
	}

	/**
	 * 出力対象チェックを設定.
	 * 
	 * @param piCheckOutput
	 *            出力対象チェック
	 */
	public void setCheckOutput(int piCheckOutput) {
		this.checkOutput = piCheckOutput;
	}

}
