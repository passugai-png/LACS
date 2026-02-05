package jp.co.pro_app.lacs.affairs.shiwake.bean;

import jp.co.pro_app.projframe.common.bean.BeanBase;

/**
 * d–óÆ‰ï–¾×Bean.
 * 
 * @author katoken
 * @version 20070312
 */
public class LACSShiwakeDetailBean extends BeanBase {

	private static final long serialVersionUID = 1L;

	private String	kamokuLKari			= "";	// Ø•û‰È–Ú–¼

	private String	kamokuRKashi		= "";	// ‘İ•û‰È–Ú–¼

	private long	kamokuAmountLKari	= 0;	// Ø•û‹àŠz

	private long	kamokuAmountRKashi	= 0;	// ‘İ•û‹àŠz

	/**
	 * Ø•û‰È–Ú–¼‚ğæ“¾.
	 * 
	 * @return Ø•û‰È–Ú–¼
	 */
	public String getKamokuLKari() {
		return this.kamokuLKari;
	}

	/**
	 * Ø•û‰È–Ú–¼‚ğİ’è.
	 * 
	 * @param piKamokuLKari
	 *            Ø•û‰È–Ú–¼
	 */
	public void setKamokuLKari(String piKamokuLKari) {
		this.kamokuLKari = piKamokuLKari;
	}

	/**
	 * ‘İ•û‰È–Ú–¼‚ğæ“¾.
	 * 
	 * @return ‘İ•û‰È–Ú–¼
	 */
	public String getKamokuRKashi() {
		return this.kamokuRKashi;
	}

	/**
	 * ‘İ•û‰È–Ú–¼‚ğİ’è.
	 * 
	 * @param piKamokuRKashi
	 *            ‘İ•û‰È–Ú–¼
	 */
	public void setKamokuRKashi(String piKamokuRKashi) {
		this.kamokuRKashi = piKamokuRKashi;
	}

	/**
	 * Ø•û‹àŠz‚ğæ“¾.
	 * 
	 * @return Ø•û‹àŠz
	 */
	public long getKamokuAmountLKari() {
		return this.kamokuAmountLKari;
	}

	/**
	 * Ø•û‹àŠz‚ğİ’è.
	 * 
	 * @param piKamokuAmountLKari
	 *            Ø•û‹àŠz
	 */
	public void setKamokuAmountLKari(long piKamokuAmountLKari) {
		this.kamokuAmountLKari = piKamokuAmountLKari;
	}

	/**
	 * ‘İ•û‹àŠz‚ğæ“¾.
	 * 
	 * @return ‘İ•û‹àŠz
	 */
	public long getKamokuAmountRKashi() {
		return this.kamokuAmountRKashi;
	}

	/**
	 * ‘İ•û‹àŠz‚ğİ’è.
	 * 
	 * @param piKamokuAmountRKashi
	 *            ‘İ•û‹àŠz
	 */
	public void setKamokuAmountRKashi(long piKamokuAmountRKashi) {
		this.kamokuAmountRKashi = piKamokuAmountRKashi;
	}

}
