package jp.co.pro_app.lacs.affairs.dsreport.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jp.co.pro_app.projframe.common.model.ModelBase;

/**
 * 帳票出力：出力対象帳票Bean.
 * 
 * @author katoken
 * @version 20080328
 */
public class LACSDSReportCSVDownloadModel extends ModelBase {

	/**
	 * コンストラクタ.
	 */
	public LACSDSReportCSVDownloadModel() {
		super();
	}

	/**
	 * 業務処理.
	 * 
	 * @exception Exception
	 *                例外発生時
	 */
	public void perform() throws Exception {
		String targetFile = super.getInput("csvName");

		byte[] b = null;

		String realPath = super.getRealPath(targetFile);

		File file = new File(realPath);

		b = new byte[(int)file.length()];

		FileInputStream reader = null;

		try {
			reader = new FileInputStream(file);

			for (int i = 0; i < b.length; i++) {
				b[i] = (byte)reader.read();
			}

			super.setResponseData(b, file.getName());
		}
		catch (IOException ex) {
		}
		finally {
			if (reader != null) {
				reader.close();
			}
		}
	}

	/**
	 * セッションチェックフラグ取得.
	 * 
	 * @return セッションチェックを行うか
	 */
	protected boolean checkSession() {
		return true;
	}
}
