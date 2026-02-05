package jp.co.pro_app.lacs.affairs.common.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**.
 * Zip 形式でアーカイブするサンプルです。
 * ※日本語ファイル名、ディレクトリ名に未対応
 * @author Zhen.XB
 * @version 20130328
 */
public class LACSZipIO {

    /**.
     * 基準になるディレクトリかファイル
     */
    private File baseFile;

    /**.
     * 起点になるディレクトリ（ファイル）の絶対パス
     */
    private String baseFilePath;
    
    /**.
     * コンストラクタ
     * @param piBase 起点になるディレクトリ、又はファイル
     */
    public LACSZipIO(File piBase) {
    	super();
        this.baseFile = piBase;
        this.baseFilePath = piBase.getAbsolutePath();
    }

    /**.
     * baseFile を圧縮します。
     */
    public void archive() {
    	
        // 出力先ファイル
		File zipfile = new File(this.baseFile.getParent(),
				this.baseFile.getName() + ".zip");
		
        ZipOutputStream zos = null;
        
        try {
        	
            // 出力先 OutputStream を生成
        	zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipfile)));
            
            archive(zos, this.baseFile);
            
        }catch (FileNotFoundException e) {
        	
            e.printStackTrace();
            
        } finally {
            try {
                zos.close();
            }
            catch (IOException e) {
            }
        }
    }

    /**.
     * baseFile を圧縮します。
     * @param piZipfile zipファイル出力ストリーム
     */
    public void archive(String piZipfile) {
    	
        // 出力先ファイル
		File zipfile = new File(this.baseFile.getParent(), piZipfile);
		
        ZipOutputStream zos = null;
        
        try {
        	
            // 出力先 OutputStream を生成
        	zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipfile)));
        	
            archive(zos, this.baseFile);
            
        }catch (FileNotFoundException e) {
        	
            e.printStackTrace();
            
        } finally {
            try {
                zos.close();
            }
            catch (IOException e) {
            }
        }
    }

    /**.
     * piFile を piZos に出力します。
     * @param piZos zipファイル出力ストリーム
     * @param piFile 入力元ファイル
     */
    private void archive(ZipOutputStream piZos, File piFile) {

        if (piFile.isDirectory()) {
        	
            // ディレクトリは含まれるファイルを再起呼び出し。
            File[] files = piFile.listFiles();
            
			for (int i = 0; i < files.length; i++) {
				
				archive(piZos, files[i]);
			} 
        } 
        else {
        	
            BufferedInputStream fis = null;
            
            try {
            	
                // 入力ストリーム生成
                fis = new BufferedInputStream(new FileInputStream(piFile));

                // Entry 名称を取得する。
				String entryName = piFile.getAbsolutePath()
						.replaceAll("\\Q" + this.baseFilePath + "\\E", "")
						.substring(1);
				
                // 出力先 Entry を設定する。
                piZos.putNextEntry(new ZipEntry(entryName));
                
                // 入力ファイルを読み込み出力ストリームに書き込んでいく
                int ava = 0;
                
                while ((ava = fis.available()) > 0) {
                	
                    byte[] bs = new byte[ava];
                    
                    fis.read(bs);
                    
                    piZos.write(bs);
                }

                // 書き込んだら Entry を close する。
                piZos.closeEntry();
                
            }catch (FileNotFoundException e) {
            	
                e.printStackTrace();
                
            }catch (IOException e) {
            	
                e.printStackTrace();
                
            }finally {
                try {
                    fis.close();
                    
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}