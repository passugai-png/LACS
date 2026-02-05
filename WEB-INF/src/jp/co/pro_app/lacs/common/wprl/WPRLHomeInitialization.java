package jp.co.pro_app.lacs.common.wprl;

import java.io.IOException;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import wkc.pdf.PdfProperties;

/**
 * 帳票出力リスナクラス. WebKCore PDFレポート Library Edition[WPRL]をサーブレット環境 から使用する場合に利用するシステム環境変数 WKC_PDF_HOME を Webアプリケーション起動時に設定するリスナクラスです。
 * 
 * @author takeda
 * @version 20070820
 */
public class WPRLHomeInitialization implements ServletContextListener {

	/**
	 * 初期化.
	 * 
	 * @param piServletContextEvent
	 *            イベント
	 */
	public void contextInitialized(ServletContextEvent piServletContextEvent) {
		final String home = piServletContextEvent.getServletContext().getRealPath("WEB-INF/wprl");
		try {
			PdfProperties.getInstance().setProperty(PdfProperties.WKC_PDF_HOME, home);
		}
		catch (IOException e) {
			piServletContextEvent.getServletContext().log("Can't set up $WKC_PDF_HOME .", e);
		}
	}

	/**
	 * 破棄.
	 * 
	 * @param piServletContextEvent
	 *            イベント
	 */
	public void contextDestroyed(ServletContextEvent piServletContextEvent) {
	}

}
