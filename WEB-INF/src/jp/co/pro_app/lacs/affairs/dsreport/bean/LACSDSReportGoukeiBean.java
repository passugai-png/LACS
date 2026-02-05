package jp.co.pro_app.lacs.affairs.dsreport.bean;

/**
 * 帳票出力：リース会計注記合計表Bean.
 * 
 * @author takeda
 * @version 20070817
 */
public class LACSDSReportGoukeiBean {

	private String	termFrom			= "";	// 対象期間(開始)

	private String	termTo				= "";	// 対象期間(終了)

	private String	termFirstFrom		= "";	// １年内(開始) FIRST_START_KEIJ_YM

	private String	termFirstTo			= "";	// １年内(終了) FIRST_END_KEIJ_YM

	private String	termSecondFrom		= "";	// ２年内(開始) SECOND_START_KEIJ_YM

	private String	termSecondTo		= "";	// ２年内(終了) SECOND_END_KEIJ_YM

	private String	termThirdFrom		= "";	// ３年内(開始) THIRD_START_KEIJ_YM

	private String	termThirdTo			= "";	// ３年内(終了) THIRD_END_KEIJ_YM

	private String	termFourthFrom		= "";	// ４年内(開始) FOURTH_START_KEIJ_YM

	private String	termFourthTo		= "";	// ４年内(終了) FOURTH_END_KEIJ_YM

	private String	termFifthFrom		= "";	// ５年内(開始) FIFTH_START_KEIJ_YM

	private String	termFifthTo			= "";	// ５年内(終了) FIFTH_END_KEIJ_YM

	private String	termOver			= "";	// ５年超 OVER_START_KEIJ_YM

	private long	b1aLeaseAmount		= 0;	// １：所有権移転外：未経過リース料 B1_GFL_A_LAMT

	private long	b1bMtmrZanzonAmount	= 0;	// １：所有権移転外：見積残存価格 B1_GFL_B_MTMR_ZANZON_AMT

	private long	b1cRisokuAmount		= 0;	// １：所有権移転外：受取利息相当額 B1_GFL_C_HSE_RSK

	private long	b1dEkimuAmount		= 0;	// １：所有権移転外：維持管理費用相当額 B1_GFL_D_IJI_KANRI_AMT

	private long	b1eIjiAmount		= 0;	// １：所有権移転外：役務提供費相当額 B1_GFL_E_EKIM_TEIK_AMT

	private long	b1fGanpon			= 0;	// １：所有権移転外：うち元本 B1_GFL_F_GNPN_AMT

	private long	b2ItengaiFirst		= 0;	// ２：所有権移転外：１年内 B2_FL_FIRST_AMT

	private long	b2ItengaiSecond		= 0;	// ２：所有権移転外：２年内 B2_FL_SECOND_AMT

	private long	b2ItengaiThird		= 0;	// ２：所有権移転外：３年内 B2_FL_THIRD_AMT

	private long	b2ItengaiFourth		= 0;	// ２：所有権移転外：４年内 B2_FL_FOURTH_AMT

	private long	b2ItengaiFifth		= 0;	// ２：所有権移転外：５年内 B2_FL_FIFTH_AMT

	private long	b2ItengaiOver		= 0;	// ２：所有権移転外：５年超 B2_FL_OVER_AMT

	private long	b2ItenFirst			= 0;	// ２：所有権移転：１年内 B2_GFL_FIRST_AMT

	private long	b2ItenSecond		= 0;	// ２：所有権移転：２年内 B2_GFL_SECOND_AMT

	private long	b2ItenThird			= 0;	// ２：所有権移転：３年内 B2_GFL_THIRD_AMT

	private long	b2ItenFourth		= 0;	// ２：所有権移転：４年内 B2_GFL_FOURTH_AMT

	private long	b2ItenFifth			= 0;	// ２：所有権移転：５年内 B2_GFL_FIFTH_AMT

	private long	b2ItenOver			= 0;	// ２：所有権移転：５年超 B2_GFL_OVER_AMT

	private long	b3OperationFirst	= 0;	// ３：オペリース：１年内 B3_OP_FIRST_AMT

	private long	b3OperationOver		= 0;	// ３：オペリース：１年超 B3_OP_OVER_AMT

	private long	b3OperationTotal	= 0;	// ３：オペリース：合計 B3_OP_OVER_TOTAL

	/**
	 * 対象期間(開始)を取得.
	 * 
	 * @return 対象期間(開始)
	 */
	public String getTermFrom() {
		return this.termFrom;
	}

	/**
	 * 対象期間(開始)を設定.
	 * 
	 * @param piTermFrom
	 *            対象期間(開始)
	 */
	public void setTermFrom(String piTermFrom) {
		this.termFrom = piTermFrom;
	}

	/**
	 * 対象期間(終了)を取得.
	 * 
	 * @return 対象期間(終了)
	 */
	public String getTermTo() {
		return this.termTo;
	}

	/**
	 * 対象期間(終了)を設定.
	 * 
	 * @param piTermTo
	 *            対象期間(終了)
	 */
	public void setTermTo(String piTermTo) {
		this.termTo = piTermTo;
	}

	/**
	 * １年内(開始)を取得.
	 * 
	 * @return １年内(開始)
	 */
	public String getTermFirstFrom() {
		return this.termFirstFrom;
	}

	/**
	 * １年内(開始)を設定.
	 * 
	 * @param piTermFirstFrom
	 *            １年内(開始)
	 */
	public void setTermFirstFrom(String piTermFirstFrom) {
		this.termFirstFrom = piTermFirstFrom;
	}

	/**
	 * １年内(終了)を取得.
	 * 
	 * @return １年内(終了)
	 */
	public String getTermFirstTo() {
		return this.termFirstTo;
	}

	/**
	 * １年内(終了)を設定.
	 * 
	 * @param piTermFirstTo
	 *            １年内(終了)
	 */
	public void setTermFirstTo(String piTermFirstTo) {
		this.termFirstTo = piTermFirstTo;
	}

	/**
	 * ２年内(開始)を取得.
	 * 
	 * @return ２年内(開始)
	 */
	public String getTermSecondFrom() {
		return this.termSecondFrom;
	}

	/**
	 * ２年内(開始)を設定.
	 * 
	 * @param piTermSecondFrom
	 *            ２年内(開始)
	 */
	public void setTermSecondFrom(String piTermSecondFrom) {
		this.termSecondFrom = piTermSecondFrom;
	}

	/**
	 * ２年内(終了)を取得.
	 * 
	 * @return ２年内(終了)
	 */
	public String getTermSecondTo() {
		return this.termSecondTo;
	}

	/**
	 * ２年内(終了)を設定.
	 * 
	 * @param piTermSecondTo
	 *            ２年内(終了)
	 */
	public void setTermSecondTo(String piTermSecondTo) {
		this.termSecondTo = piTermSecondTo;
	}

	/**
	 * ３年内(開始)を取得.
	 * 
	 * @return ３年内(開始)
	 */
	public String getTermThirdFrom() {
		return this.termThirdFrom;
	}

	/**
	 * ３年内(開始)を設定.
	 * 
	 * @param piTermThirdFrom
	 *            ３年内(開始)
	 */
	public void setTermThirdFrom(String piTermThirdFrom) {
		this.termThirdFrom = piTermThirdFrom;
	}

	/**
	 * ３年内(終了)を取得.
	 * 
	 * @return ３年内(終了)
	 */
	public String getTermThirdTo() {
		return this.termThirdTo;
	}

	/**
	 * ３年内(終了)を設定.
	 * 
	 * @param piTermThirdTo
	 *            ３年内(終了)
	 */
	public void setTermThirdTo(String piTermThirdTo) {
		this.termThirdTo = piTermThirdTo;
	}

	/**
	 * ４年内(開始)を取得.
	 * 
	 * @return ４年内(開始)
	 */
	public String getTermFourthFrom() {
		return this.termFourthFrom;
	}

	/**
	 * ４年内(開始)を設定.
	 * 
	 * @param piTermFourthFrom
	 *            ４年内(開始)
	 */
	public void setTermFourthFrom(String piTermFourthFrom) {
		this.termFourthFrom = piTermFourthFrom;
	}

	/**
	 * ４年内(終了)を取得.
	 * 
	 * @return ４年内(終了)
	 */
	public String getTermFourthTo() {
		return this.termFourthTo;
	}

	/**
	 * ４年内(終了)を設定.
	 * 
	 * @param piTermFourthTo
	 *            ４年内(終了)
	 */
	public void setTermFourthTo(String piTermFourthTo) {
		this.termFourthTo = piTermFourthTo;
	}

	/**
	 * ５年内(開始)を取得.
	 * 
	 * @return ５年内(開始)
	 */
	public String getTermFifthFrom() {
		return this.termFifthFrom;
	}

	/**
	 * ５年内(開始)を設定.
	 * 
	 * @param piTermFifthFrom
	 *            ５年内(開始)
	 */
	public void setTermFifthFrom(String piTermFifthFrom) {
		this.termFifthFrom = piTermFifthFrom;
	}

	/**
	 * ５年内(終了)を取得.
	 * 
	 * @return ５年内(終了)
	 */
	public String getTermFifthTo() {
		return this.termFifthTo;
	}

	/**
	 * ５年内(終了)を設定.
	 * 
	 * @param piTermFifthTo
	 *            ５年内(終了)
	 */
	public void setTermFifthTo(String piTermFifthTo) {
		this.termFifthTo = piTermFifthTo;
	}

	/**
	 * ５年超を取得.
	 * 
	 * @return ５年超
	 */
	public String getTermOver() {
		return this.termOver;
	}

	/**
	 * ５年超を設定.
	 * 
	 * @param piTermOver
	 *            ５年超
	 */
	public void setTermOver(String piTermOver) {
		this.termOver = piTermOver;
	}

	/**
	 * １：所有権移転外：未経過リース料を取得.
	 * 
	 * @return １：所有権移転外：未経過リース料
	 */
	public long getB1aLeaseAmount() {
		return this.b1aLeaseAmount;
	}

	/**
	 * １：所有権移転外：未経過リース料を設定.
	 * 
	 * @param piB1aLeaseAmount
	 *            １：所有権移転外：未経過リース料
	 */
	public void setB1aLeaseAmount(long piB1aLeaseAmount) {
		this.b1aLeaseAmount = piB1aLeaseAmount;
	}

	/**
	 * １：所有権移転外：見積残存価格を取得.
	 * 
	 * @return １：所有権移転外：見積残存価格
	 */
	public long getB1bMtmrZanzonAmount() {
		return this.b1bMtmrZanzonAmount;
	}

	/**
	 * １：所有権移転外：見積残存価格を設定.
	 * 
	 * @param piB1bMtmrZanzonAmount
	 *            １：所有権移転外：見積残存価格
	 */
	public void setB1bMtmrZanzonAmount(long piB1bMtmrZanzonAmount) {
		this.b1bMtmrZanzonAmount = piB1bMtmrZanzonAmount;
	}

	/**
	 * １：所有権移転外：受取利息相当額を取得.
	 * 
	 * @return １：所有権移転外：受取利息相当額
	 */
	public long getB1cRisokuAmount() {
		return this.b1cRisokuAmount;
	}

	/**
	 * １：所有権移転外：受取利息相当額を設定.
	 * 
	 * @param piB1cRisokuAmount
	 *            １：所有権移転外：受取利息相当額
	 */
	public void setB1cRisokuAmount(long piB1cRisokuAmount) {
		this.b1cRisokuAmount = piB1cRisokuAmount;
	}

	/**
	 * １：所有権移転外：維持管理費用相当額を取得.
	 * 
	 * @return １：所有権移転外：維持管理費用相当額
	 */
	public long getB1dEkimuAmount() {
		return this.b1dEkimuAmount;
	}

	/**
	 * １：所有権移転外：維持管理費用相当額を設定.
	 * 
	 * @param piB1dEkimuAmount
	 *            １：所有権移転外：維持管理費用相当額
	 */
	public void setB1dEkimuAmount(long piB1dEkimuAmount) {
		this.b1dEkimuAmount = piB1dEkimuAmount;
	}

	/**
	 * １：所有権移転外：役務提供費相当額を取得.
	 * 
	 * @return １：所有権移転外：役務提供費相当額
	 */
	public long getB1eIjiAmount() {
		return this.b1eIjiAmount;
	}

	/**
	 * １：所有権移転外：役務提供費相当額を設定.
	 * 
	 * @param piB1eIjiAmount
	 *            １：所有権移転外：役務提供費相当額
	 */
	public void setB1eIjiAmount(long piB1eIjiAmount) {
		this.b1eIjiAmount = piB1eIjiAmount;
	}

	/**
	 * １：所有権移転外：うち元本を取得.
	 * 
	 * @return １：所有権移転外：うち元本
	 */
	public long getB1fGanpon() {
		return this.b1fGanpon;
	}

	/**
	 * １：所有権移転外：うち元本を設定.
	 * 
	 * @param piB1fGanpon
	 *            １：所有権移転外：うち元本
	 */
	public void setB1fGanpon(long piB1fGanpon) {
		this.b1fGanpon = piB1fGanpon;
	}

	/**
	 * ２：所有権移転外：１年内を取得.
	 * 
	 * @return ２：所有権移転外：１年内
	 */
	public long getB2ItengaiFirst() {
		return this.b2ItengaiFirst;
	}

	/**
	 * ２：所有権移転外：１年内を設定.
	 * 
	 * @param piB2ItengaiFirst
	 *            ２：所有権移転外：１年内
	 */
	public void setB2ItengaiFirst(long piB2ItengaiFirst) {
		this.b2ItengaiFirst = piB2ItengaiFirst;
	}

	/**
	 * ２：所有権移転外：２年内を取得.
	 * 
	 * @return ２：所有権移転外：２年内
	 */
	public long getB2ItengaiSecond() {
		return this.b2ItengaiSecond;
	}

	/**
	 * ２：所有権移転外：２年内を設定.
	 * 
	 * @param piB2ItengaiSecond
	 *            ２：所有権移転外：２年内
	 */
	public void setB2ItengaiSecond(long piB2ItengaiSecond) {
		this.b2ItengaiSecond = piB2ItengaiSecond;
	}

	/**
	 * ２：所有権移転外：３年内を取得.
	 * 
	 * @return ２：所有権移転外：３年内
	 */
	public long getB2ItengaiThird() {
		return this.b2ItengaiThird;
	}

	/**
	 * ２：所有権移転外：３年内を設定.
	 * 
	 * @param piB2ItengaiThird
	 *            ２：所有権移転外：３年内
	 */
	public void setB2ItengaiThird(long piB2ItengaiThird) {
		this.b2ItengaiThird = piB2ItengaiThird;
	}

	/**
	 * ２：所有権移転外：４年内を取得.
	 * 
	 * @return ２：所有権移転外：４年内
	 */
	public long getB2ItengaiFourth() {
		return this.b2ItengaiFourth;
	}

	/**
	 * ２：所有権移転外：４年内を設定.
	 * 
	 * @param piB2ItengaiFourth
	 *            ２：所有権移転外：４年内
	 */
	public void setB2ItengaiFourth(long piB2ItengaiFourth) {
		this.b2ItengaiFourth = piB2ItengaiFourth;
	}

	/**
	 * ２：所有権移転外：５年内を取得.
	 * 
	 * @return ２：所有権移転外：５年内
	 */
	public long getB2ItengaiFifth() {
		return this.b2ItengaiFifth;
	}

	/**
	 * ２：所有権移転外：５年内を設定.
	 * 
	 * @param piB2ItengaiFifth
	 *            ２：所有権移転外：５年内
	 */
	public void setB2ItengaiFifth(long piB2ItengaiFifth) {
		this.b2ItengaiFifth = piB2ItengaiFifth;
	}

	/**
	 * ２：所有権移転外：５年超を取得.
	 * 
	 * @return ２：所有権移転外：５年超
	 */
	public long getB2ItengaiOver() {
		return this.b2ItengaiOver;
	}

	/**
	 * ２：所有権移転外：５年超を設定.
	 * 
	 * @param piB2ItengaiOver
	 *            ２：所有権移転外：５年超
	 */
	public void setB2ItengaiOver(long piB2ItengaiOver) {
		this.b2ItengaiOver = piB2ItengaiOver;
	}

	/**
	 * ２：所有権移転：１年内を取得.
	 * 
	 * @return ２：所有権移転：１年内
	 */
	public long getB2ItenFirst() {
		return this.b2ItenFirst;
	}

	/**
	 * ２：所有権移転：１年内を設定.
	 * 
	 * @param piB2ItenFirst
	 *            ２：所有権移転：１年内
	 */
	public void setB2ItenFirst(long piB2ItenFirst) {
		this.b2ItenFirst = piB2ItenFirst;
	}

	/**
	 * ２：所有権移転：２年内を取得.
	 * 
	 * @return ２：所有権移転：２年内
	 */
	public long getB2ItenSecond() {
		return this.b2ItenSecond;
	}

	/**
	 * ２：所有権移転：２年内を設定.
	 * 
	 * @param piB2ItenSecond
	 *            ２：所有権移転：２年内
	 */
	public void setB2ItenSecond(long piB2ItenSecond) {
		this.b2ItenSecond = piB2ItenSecond;
	}

	/**
	 * ２：所有権移転：３年内を取得.
	 * 
	 * @return ２：所有権移転：３年内
	 */
	public long getB2ItenThird() {
		return this.b2ItenThird;
	}

	/**
	 * ２：所有権移転：３年内を設定.
	 * 
	 * @param piB2ItenThird
	 *            ２：所有権移転：３年内
	 */
	public void setB2ItenThird(long piB2ItenThird) {
		this.b2ItenThird = piB2ItenThird;
	}

	/**
	 * ２：所有権移転：４年内を取得.
	 * 
	 * @return ２：所有権移転：４年内
	 */
	public long getB2ItenFourth() {
		return this.b2ItenFourth;
	}

	/**
	 * ２：所有権移転：４年内を設定.
	 * 
	 * @param piB2ItenFourth
	 *            ２：所有権移転：４年内
	 */
	public void setB2ItenFourth(long piB2ItenFourth) {
		this.b2ItenFourth = piB2ItenFourth;
	}

	/**
	 * ２：所有権移転：５年内を取得.
	 * 
	 * @return ２：所有権移転：５年内
	 */
	public long getB2ItenFifth() {
		return this.b2ItenFifth;
	}

	/**
	 * ２：所有権移転：５年内を設定.
	 * 
	 * @param piB2ItenFifth
	 *            ２：所有権移転：５年内
	 */
	public void setB2ItenFifth(long piB2ItenFifth) {
		this.b2ItenFifth = piB2ItenFifth;
	}

	/**
	 * ２：所有権移転：５年超を取得.
	 * 
	 * @return ２：所有権移転：５年超
	 */
	public long getB2ItenOver() {
		return this.b2ItenOver;
	}

	/**
	 * ２：所有権移転：５年超を設定.
	 * 
	 * @param piB2ItenOver
	 *            ２：所有権移転：５年超
	 */
	public void setB2ItenOver(long piB2ItenOver) {
		this.b2ItenOver = piB2ItenOver;
	}

	/**
	 * ３：オペリース：１年内を取得.
	 * 
	 * @return ３：オペリース：１年内
	 */
	public long getB3OperationFirst() {
		return this.b3OperationFirst;
	}

	/**
	 * ３：オペリース：１年内を設定.
	 * 
	 * @param piB3OperationFirst
	 *            ３：オペリース：１年内
	 */
	public void setB3OperationFirst(long piB3OperationFirst) {
		this.b3OperationFirst = piB3OperationFirst;
	}

	/**
	 * ３：オペリース：１年超を取得.
	 * 
	 * @return ３：オペリース：１年超
	 */
	public long getB3OperationOver() {
		return this.b3OperationOver;
	}

	/**
	 * ３：オペリース：１年超を設定.
	 * 
	 * @param piB3OperationOver
	 *            ３：オペリース：１年超
	 */
	public void setB3OperationOver(long piB3OperationOver) {
		this.b3OperationOver = piB3OperationOver;
	}

	/**
	 * ３：オペリース：合計を取得.
	 * 
	 * @return ３：オペリース：合計
	 */
	public long getB3OperationTotal() {
		return this.b3OperationTotal;
	}

	/**
	 * ３：オペリース：合計を設定.
	 * 
	 * @param piB3OperationTotal
	 *            ３：オペリース：合計
	 */
	public void setB3OperationTotal(long piB3OperationTotal) {
		this.b3OperationTotal = piB3OperationTotal;
	}

}
