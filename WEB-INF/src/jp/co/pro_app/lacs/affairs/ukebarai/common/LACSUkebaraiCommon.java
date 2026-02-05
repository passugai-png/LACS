package jp.co.pro_app.lacs.affairs.ukebarai.common;

import java.sql.Connection;
import java.sql.SQLException;

import jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean;
import jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiTable;
import jp.co.pro_app.lacs.affairs.ukebarai.data.entity.LACSUkebaraiLeaseCtskSTaxEntity;
import jp.co.pro_app.lacs.affairs.ukebarai.data.entity.LACSUkebaraiLeaseEntity;
import jp.co.pro_app.lacs.affairs.ukebarai.data.entity.LACSUkebaraiSisanEntity;
import jp.co.pro_app.lacs.common.model.LACSModelBase;

/**
 * 受払合計表：共通機能.
 * 
 * @author active
 * @version 20080812
 */
public class LACSUkebaraiCommon {

	// 2020/05/22 REP START
	/** . BS科目残高推移表最大件数 */
	//public static final int	BS_LIST_COUNT	= 8;

	/** . PL科目累計額推移表最大件数 */
	//public static final int	PL_LIST_COUNT	= 13;

	/** . 賃貸借処理表最大件数 */
	//public static final int	MAX_LIST_COUNT	= 15;

	
	/** . BS科目残高推移表最大件数 */
	public static final int	BS_LIST_COUNT	= 9;

	/** . PL科目累計額推移表最大件数 */
	public static final int	PL_LIST_COUNT	= 14;

	/** . 賃貸借処理表最大件数 */
	public static final int	MAX_LIST_COUNT	= 16;
	// 2020/05/22 REP END

	/**
	 * コンストラクタ.
	 */
	private LACSUkebaraiCommon() {
	}

	private static void setDispFLBuy(LACSUkebaraiTable piTable) {
		piTable.getTableBS().add(1, 1, 0, 1, 1, "リース資産(有形)");
		piTable.getTableBS().add(1, 0, 1, 0, 1, "減価償却累計額(有形)");
		piTable.getTableBS().add(1, 1, 0, 1, 1, "有形資産簿価");
		piTable.getTableBS().add(1, 1, 0, 1, 1, "リース資産(無形)");
		piTable.getTableBS().add(1, 0, 1, 0, 1, "減価償却累計額(無形)");
		piTable.getTableBS().add(1, 1, 0, 1, 1, "無形資産簿価");
		piTable.getTableBS().add(1, 1, 1, 1, 1, "リース債務");
		piTable.getTableBS().add(1, 1, 1, 1, 1, "未払金(消費税)");
		// 2020/05/22 ADD START
		piTable.getTableBS().add(1, 1, 0, 1, 1, "残価保証額");
		// 2020/05/22 ADD END

		piTable.getTablePL().add(1, 0, 1, 1, 1, "減価償却費(有形)");
		piTable.getTablePL().add(1, 0, 1, 1, 1, "減価償却費(無形)");
		piTable.getTablePL().add(1, 0, 1, 1, 1, "支払利息");
		piTable.getTablePL().add(1, 0, 1, 1, 1, "維持管理費相当額");
		piTable.getTablePL().add(1, 0, 1, 1, 1, "役務提供費相当額");

	}

	private static void setDispFLRent(LACSUkebaraiTable piTable) {
		piTable.getTableBS().add(1, 1, 0, 1, 1, "リース資産(有形)");
		piTable.getTableBS().add(1, 0, 1, 0, 1, "減価償却累計額(有形)");
		piTable.getTableBS().add(1, 1, 0, 1, 1, "有形資産簿価");
		piTable.getTableBS().add(1, 1, 0, 1, 1, "リース資産(無形)");
		piTable.getTableBS().add(1, 0, 1, 0, 1, "減価償却累計額(無形)");
		piTable.getTableBS().add(1, 1, 0, 1, 1, "無形資産簿価");
		piTable.getTableBS().add(1, 1, 1, 1, 1, "リース債務");
		piTable.getTableBS().add(1, 1, 1, 1, 1, "未払金(消費税)");
		// 2020/05/22 ADD START
		piTable.getTableBS().add(1, 1, 0, 1, 1, "残価保証額");
		// 2020/05/22 ADD END
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");

		piTable.getTablePL().add(1, 0, 1, 1, 1, "支払リース料");
		piTable.getTablePL().add(1, 0, 1, 1, 1, "仮払消費税");
	}

	private static void setDispOP(LACSUkebaraiTable piTable) {
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		// 2020/05/22 ADD START
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		// 2020/05/22 ADD END
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");
		piTable.getTableBS().add(0, 0, 0, 0, 0, "ダミー");

		piTable.getTablePL().add(1, 0, 1, 1, 1, "支払リース料");
		piTable.getTablePL().add(1, 0, 1, 1, 1, "仮払消費税");
	}

	/**
	 * リース受払合計表データを取得.
	 * 
	 * @param piCommonBean
	 *            LACS共通Bean
	 * @param piUkebaraiBean
	 *            画面Bean
	 * @param piModel
	 *            モデル
	 * @param piCon
	 *            DB接続
	 * @throws SQLException
	 *             SQL実行例外
	 */
	public static void getUkebaraiData(LACSCommonBean piCommonBean, LACSUkebaraiBean piUkebaraiBean, LACSModelBase piModel, Connection piCon) throws SQLException {
		LACSUkebaraiSisanEntity sisanEntity = new LACSUkebaraiSisanEntity(piModel, piCommonBean, piUkebaraiBean);
		LACSUkebaraiLeaseEntity leaseEntity = new LACSUkebaraiLeaseEntity(piModel, piCommonBean, piUkebaraiBean);
		LACSUkebaraiLeaseCtskSTaxEntity staxEntity = new LACSUkebaraiLeaseCtskSTaxEntity(piModel, piCommonBean, piUkebaraiBean);

		// 2020/05/22 REP START
		//LACSUkebaraiTable oldFinacalBuy = new LACSUkebaraiTable(8, 5);
		//LACSUkebaraiTable oldFinacalRent = new LACSUkebaraiTable(8, 2);
		//LACSUkebaraiTable oldFinacalGaiBuy = new LACSUkebaraiTable(8, 5);
		//LACSUkebaraiTable oldFinacalGaiRent = new LACSUkebaraiTable(8, 2);
		//LACSUkebaraiTable oldOperation = new LACSUkebaraiTable(8, 2);
		//LACSUkebaraiTable newFinacalBuy = new LACSUkebaraiTable(8, 5);
		//LACSUkebaraiTable newFinacalRent = new LACSUkebaraiTable(8, 2);
		//LACSUkebaraiTable newFinacalGaiBuy = new LACSUkebaraiTable(8, 5);
		//LACSUkebaraiTable newFinacalGaiRent = new LACSUkebaraiTable(8, 2);
		//LACSUkebaraiTable newOperation = new LACSUkebaraiTable(8, 2);

		LACSUkebaraiTable JyNoldFinacalBuy = new LACSUkebaraiTable(9, 5);
		LACSUkebaraiTable JyNoldFinacalRent = new LACSUkebaraiTable(9, 2);
		LACSUkebaraiTable JyNoldFinacalGaiBuy = new LACSUkebaraiTable(9, 5);
		LACSUkebaraiTable JyNoldFinacalGaiRent = new LACSUkebaraiTable(9, 2);
		LACSUkebaraiTable JyNoldOperation = new LACSUkebaraiTable(9, 2);
		LACSUkebaraiTable JyNnewFinacalBuy = new LACSUkebaraiTable(9, 5);
		LACSUkebaraiTable JyNnewFinacalRent = new LACSUkebaraiTable(9, 2);
		LACSUkebaraiTable JyNnewFinacalGaiBuy = new LACSUkebaraiTable(9, 5);
		LACSUkebaraiTable JyNnewFinacalGaiRent = new LACSUkebaraiTable(9, 2);
		LACSUkebaraiTable JyNnewOperation = new LACSUkebaraiTable(9, 2);
		//
		LACSUkebaraiTable JyAoldFinacalBuy = new LACSUkebaraiTable(9, 5);
		LACSUkebaraiTable JyAoldFinacalRent = new LACSUkebaraiTable(9, 2);
		LACSUkebaraiTable JyAoldFinacalGaiBuy = new LACSUkebaraiTable(9, 5);
		LACSUkebaraiTable JyAoldFinacalGaiRent = new LACSUkebaraiTable(9, 2);
		LACSUkebaraiTable JyAoldOperation = new LACSUkebaraiTable(9, 2);
		LACSUkebaraiTable JyAnewFinacalBuy = new LACSUkebaraiTable(9, 5);
		LACSUkebaraiTable JyAnewFinacalRent = new LACSUkebaraiTable(9, 2);
		LACSUkebaraiTable JyAnewFinacalGaiBuy = new LACSUkebaraiTable(9, 5);
		LACSUkebaraiTable JyAnewFinacalGaiRent = new LACSUkebaraiTable(9, 2);
		LACSUkebaraiTable JyAnewOperation = new LACSUkebaraiTable(9, 2);
		// 2020/05/22 REP END

		// 2020/05/22 ADD TEST START
		//System.out.println("SQL getUkebaraiData start");
		//System.out.println(super.sql);
		//System.out.println("SQL getUkebaraiData end");
		// 2020/05/22 ADD TEST END

		try {

			// 2020/05/22 REP START
			//setDispFLBuy(oldFinacalBuy);
			//setDispFLBuy(oldFinacalGaiBuy);
			//setDispFLBuy(newFinacalBuy);
			//setDispFLBuy(newFinacalGaiBuy);

			//setDispFLRent(oldFinacalRent);
			//setDispFLRent(oldFinacalGaiRent);
			//setDispFLRent(newFinacalRent);
			//setDispFLRent(newFinacalGaiRent);

			//setDispOP(oldOperation);
			//setDispOP(newOperation);
			//
			setDispFLBuy(JyNoldFinacalBuy);
			setDispFLBuy(JyNoldFinacalGaiBuy);
			setDispFLBuy(JyNnewFinacalBuy);
			setDispFLBuy(JyNnewFinacalGaiBuy);

			setDispFLRent(JyNoldFinacalRent);
			setDispFLRent(JyNoldFinacalGaiRent);
			setDispFLRent(JyNnewFinacalRent);
			setDispFLRent(JyNnewFinacalGaiRent);

			setDispOP(JyNoldOperation);
			setDispOP(JyNnewOperation);
			//
			setDispFLBuy(JyAoldFinacalBuy);
			setDispFLBuy(JyAoldFinacalGaiBuy);
			setDispFLBuy(JyAnewFinacalBuy);
			setDispFLBuy(JyAnewFinacalGaiBuy);

			setDispFLRent(JyAoldFinacalRent);
			setDispFLRent(JyAoldFinacalGaiRent);
			setDispFLRent(JyAnewFinacalRent);
			setDispFLRent(JyAnewFinacalGaiRent);

			setDispOP(JyAoldOperation);
			setDispOP(JyAnewOperation);
			// 2020/05/22 REP END

			sisanEntity.setCon(piCon);

			piUkebaraiBean.setDataMax(sisanEntity.execSQL());

			while (sisanEntity.next()) {
				// 2020/05/22 REP START
//				if (sisanEntity.getTaishoAcKijyunCd().equals("0")) {
//					/* 旧リース会計基準 */
//					if (sisanEntity.getTrdHnteiKekaCd().equals("1")) {
//						/* 所有権移転ファイナンスリース */
//						if (sisanEntity.getAcShrCd().equals("0")) {
//							setSisanFinancial(sisanEntity, oldFinacalBuy);
//							oldFinacalBuy.setPageCnt("0");
//						}
//						else {
//							/* 賃貸借処理 */
//							setSisanFinancial(sisanEntity, oldFinacalRent);
//							oldFinacalRent.setPageCnt("0");
//							// 2020/05/22 REP START
//							// 2020/05/22 REP END
//						}
//					}
//					else if (sisanEntity.getTrdHnteiKekaCd().equals("2")) {
//						/* 所有権移転外ファイナンスリース */
//						if (sisanEntity.getAcShrCd().equals("0")) {
//							/* 売買処理 */
//							setSisanFinancial(sisanEntity, oldFinacalGaiBuy);
//							oldFinacalGaiBuy.setPageCnt("0");
//						}
//						else {
//							/* 賃貸借処理 */
//							setSisanFinancial(sisanEntity, oldFinacalGaiRent);
//							oldFinacalGaiRent.setPageCnt("0");
//						}
//					}
//				}
//				else {
//					/* 新リース会計基準 */
//					if (sisanEntity.getTrdHnteiKekaCd().equals("1")) {
//						/* 所有権移転ファイナンスリース */
//						if (sisanEntity.getAcShrCd().equals("0")) {
//							/* 売買処理 */
//							setSisanFinancial(sisanEntity, newFinacalBuy);
//							newFinacalBuy.setPageCnt("0");
//						}
//						else {
//							/* 賃貸借処理 */
//							setSisanFinancial(sisanEntity, newFinacalRent);
//							newFinacalRent.setPageCnt("0");
//						}
//					}
//					else if (sisanEntity.getTrdHnteiKekaCd().equals("2")) {
//						/* 所有権移転外ファイナンスリース */
//						if (sisanEntity.getAcShrCd().equals("0")) {
//							/* 売買処理 */
//							setSisanFinancial(sisanEntity, newFinacalGaiBuy);
//							newFinacalGaiBuy.setPageCnt("0");
//						}
//						else {
//							/* 賃貸借処理 */
//							setSisanFinancial(sisanEntity, newFinacalGaiRent);
//							newFinacalGaiRent.setPageCnt("0");
//						}
//					}
//				}
				//
				if (sisanEntity.getJysiUm().equals("なし")) {
					/* 重要性無 */
					if (sisanEntity.getTaishoAcKijyunCd().equals("0")) {
						/* 旧リース会計基準 */
						if (sisanEntity.getTrdHnteiKekaCd().equals("1")) {
							/* 所有権移転ファイナンスリース */
							if (sisanEntity.getAcShrCd().equals("0")) {
								setSisanFinancial(sisanEntity, JyNoldFinacalBuy);
								JyNoldFinacalBuy.setPageCnt("0");
							}
							else {
								/* 賃貸借処理 */
								setSisanFinancial(sisanEntity, JyNoldFinacalRent);
								JyNoldFinacalRent.setPageCnt("0");
							}
						}
						else if (sisanEntity.getTrdHnteiKekaCd().equals("2")) {
							/* 所有権移転外ファイナンスリース */
							if (sisanEntity.getAcShrCd().equals("0")) {
								/* 売買処理 */
								setSisanFinancial(sisanEntity, JyNoldFinacalGaiBuy);
								JyNoldFinacalGaiBuy.setPageCnt("0");
							}
							else {
								/* 賃貸借処理 */
								setSisanFinancial(sisanEntity, JyNoldFinacalGaiRent);
								JyNoldFinacalGaiRent.setPageCnt("0");
							}
						}
					}
					else {
						/* 新リース会計基準 */
						if (sisanEntity.getTrdHnteiKekaCd().equals("1")) {
							/* 所有権移転ファイナンスリース */
							if (sisanEntity.getAcShrCd().equals("0")) {
								/* 売買処理 */
								setSisanFinancial(sisanEntity, JyNnewFinacalBuy);
								JyNnewFinacalBuy.setPageCnt("0");
							}
							else {
								/* 賃貸借処理 */
								setSisanFinancial(sisanEntity, JyNnewFinacalRent);
								JyNnewFinacalRent.setPageCnt("0");
							}
						}
						else if (sisanEntity.getTrdHnteiKekaCd().equals("2")) {
							/* 所有権移転外ファイナンスリース */
							if (sisanEntity.getAcShrCd().equals("0")) {
								/* 売買処理 */
								setSisanFinancial(sisanEntity, JyNnewFinacalGaiBuy);
								JyNnewFinacalGaiBuy.setPageCnt("0");
							}
							else {
								/* 賃貸借処理 */
								setSisanFinancial(sisanEntity, JyNnewFinacalGaiRent);
								JyNnewFinacalGaiRent.setPageCnt("0");
							}
						}
					}
				}
				else {
					/* 重要性有 */
					if (sisanEntity.getTaishoAcKijyunCd().equals("0")) {
						/* 旧リース会計基準 */
						if (sisanEntity.getTrdHnteiKekaCd().equals("1")) {
							/* 所有権移転ファイナンスリース */
							if (sisanEntity.getAcShrCd().equals("0")) {
								setSisanFinancial(sisanEntity, JyAoldFinacalBuy);
								JyAoldFinacalBuy.setPageCnt("0");
							}
							else {
								/* 賃貸借処理 */
								setSisanFinancial(sisanEntity, JyAoldFinacalRent);
								JyAoldFinacalRent.setPageCnt("0");
							}
						}
						else if (sisanEntity.getTrdHnteiKekaCd().equals("2")) {
							/* 所有権移転外ファイナンスリース */
							if (sisanEntity.getAcShrCd().equals("0")) {
								/* 売買処理 */
								setSisanFinancial(sisanEntity, JyAoldFinacalGaiBuy);
								JyAoldFinacalGaiBuy.setPageCnt("0");
							}
							else {
								/* 賃貸借処理 */
								setSisanFinancial(sisanEntity, JyAoldFinacalGaiRent);
								JyAoldFinacalGaiRent.setPageCnt("0");
							}
						}
					}
					else {
						/* 新リース会計基準 */
						if (sisanEntity.getTrdHnteiKekaCd().equals("1")) {
							/* 所有権移転ファイナンスリース */
							if (sisanEntity.getAcShrCd().equals("0")) {
								/* 売買処理 */
								setSisanFinancial(sisanEntity, JyAnewFinacalBuy);
								JyAnewFinacalBuy.setPageCnt("0");
							}
							else {
								/* 賃貸借処理 */
								setSisanFinancial(sisanEntity, JyAnewFinacalRent);
								JyAnewFinacalRent.setPageCnt("0");
							}
						}
						else if (sisanEntity.getTrdHnteiKekaCd().equals("2")) {
							/* 所有権移転外ファイナンスリース */
							if (sisanEntity.getAcShrCd().equals("0")) {
								/* 売買処理 */
								setSisanFinancial(sisanEntity, JyAnewFinacalGaiBuy);
								JyAnewFinacalGaiBuy.setPageCnt("0");
							}
							else {
								/* 賃貸借処理 */
								setSisanFinancial(sisanEntity, JyAnewFinacalGaiRent);
								JyAnewFinacalGaiRent.setPageCnt("0");
							}
						}
					}					
				}
				// 2020/05/22 REP END
			}

			leaseEntity.setCon(piCon);

			leaseEntity.execSQL();

			while (leaseEntity.next()) {
				piUkebaraiBean.setLcName(leaseEntity.getLcNm());

				// 2020/05/22 REP START
//				if (leaseEntity.getTaishoAcKijyunCd().equals("0")) {
//					/* 旧リース会計基準 */
//					if (leaseEntity.getTrdHnteiKekaCd().equals("1")) {
//						/* 所有権移転ファイナンスリース */
//						if (leaseEntity.getAcShrCd().equals("0")) {
//							setLeaseFinancial(leaseEntity, oldFinacalBuy);
//							oldFinacalBuy.setPageCnt("0");
//						}
//						else {
//							/* 賃貸借処理 */
//							setLeaseFinancial(leaseEntity, oldFinacalRent);
//							oldFinacalRent.setPageCnt("0");
//						}
//					}
//					else if (leaseEntity.getTrdHnteiKekaCd().equals("2")) {
//						/* 所有権移転外ファイナンスリース */
//						if (leaseEntity.getAcShrCd().equals("0")) {
//							/* 売買処理 */
//							setLeaseFinancial(leaseEntity, oldFinacalGaiBuy);
//							oldFinacalGaiBuy.setPageCnt("0");
//						}
//						else {
//							/* 賃貸借処理 */
//							setLeaseFinancial(leaseEntity, oldFinacalGaiRent);
//							oldFinacalGaiRent.setPageCnt("0");
//						}
//					}
//					else {
//						/* オペリース */
//						setLeaseOperation(leaseEntity, oldOperation);
//						oldOperation.setPageCnt("0");
//					}
//				}
//				else {
//					/* 新リース会計基準 */
//					if (leaseEntity.getTrdHnteiKekaCd().equals("1")) {
//						/* 所有権移転ファイナンスリース */
//						if (leaseEntity.getAcShrCd().equals("0")) {
//							/* 売買処理 */
//							setLeaseFinancial(leaseEntity, newFinacalBuy);
//							newFinacalBuy.setPageCnt("0");
//						}
//						else {
//							/* 賃貸借処理 */
//							setLeaseFinancial(leaseEntity, newFinacalRent);
//							newFinacalRent.setPageCnt("0");
//						}
//					}
//					else if (leaseEntity.getTrdHnteiKekaCd().equals("2")) {
//						/* 所有権移転外ファイナンスリース */
//						if (leaseEntity.getAcShrCd().equals("0")) {
//							/* 売買処理 */
//							setLeaseFinancial(leaseEntity, newFinacalGaiBuy);
//							newFinacalGaiBuy.setPageCnt("0");
//						}
//						else {
//							/* 賃貸借処理 */
//							setLeaseFinancial(leaseEntity, newFinacalGaiRent);
//							newFinacalGaiRent.setPageCnt("0");
//						}
//					}
//					else {
//						/* オペリース */
//						setLeaseOperation(leaseEntity, newOperation);
//						newOperation.setPageCnt("0");
//					}
//				}		
				//
				if (leaseEntity.getJysiUm().equals("なし")) {
					/* 重要性無 */
					if (leaseEntity.getTaishoAcKijyunCd().equals("0")) {
						/* 旧リース会計基準 */
						if (leaseEntity.getTrdHnteiKekaCd().equals("1")) {
							/* 所有権移転ファイナンスリース */
							if (leaseEntity.getAcShrCd().equals("0")) {
								setLeaseFinancial(leaseEntity, JyNoldFinacalBuy);
								JyNoldFinacalBuy.setPageCnt("0");
							}
							else {
								/* 賃貸借処理 */
								setLeaseFinancial(leaseEntity, JyNoldFinacalRent);
								JyNoldFinacalRent.setPageCnt("0");
							}
						}
						else if (leaseEntity.getTrdHnteiKekaCd().equals("2")) {
							/* 所有権移転外ファイナンスリース */
							if (leaseEntity.getAcShrCd().equals("0")) {
								/* 売買処理 */
								setLeaseFinancial(leaseEntity, JyNoldFinacalGaiBuy);
								JyNoldFinacalGaiBuy.setPageCnt("0");
							}
							else {
								/* 賃貸借処理 */
								setLeaseFinancial(leaseEntity, JyNoldFinacalGaiRent);
								JyNoldFinacalGaiRent.setPageCnt("0");
							}
						}
						else {
							/* オペリース */
							setLeaseOperation(leaseEntity, JyNoldOperation);
							JyNoldOperation.setPageCnt("0");
						}
					}
					else {
						/* 新リース会計基準 */
						if (leaseEntity.getTrdHnteiKekaCd().equals("1")) {
							/* 所有権移転ファイナンスリース */
							if (leaseEntity.getAcShrCd().equals("0")) {
								/* 売買処理 */
								setLeaseFinancial(leaseEntity, JyNnewFinacalBuy);
								JyNnewFinacalBuy.setPageCnt("0");
							}
							else {
								/* 賃貸借処理 */
								setLeaseFinancial(leaseEntity, JyNnewFinacalRent);
								JyNnewFinacalRent.setPageCnt("0");
							}
						}
						else if (leaseEntity.getTrdHnteiKekaCd().equals("2")) {
							/* 所有権移転外ファイナンスリース */
							if (leaseEntity.getAcShrCd().equals("0")) {
								/* 売買処理 */
								setLeaseFinancial(leaseEntity, JyNnewFinacalGaiBuy);
								JyNnewFinacalGaiBuy.setPageCnt("0");
							}
							else {
								/* 賃貸借処理 */
								setLeaseFinancial(leaseEntity, JyNnewFinacalGaiRent);
								JyNnewFinacalGaiRent.setPageCnt("0");
							}
						}
						else {
							/* オペリース */
							setLeaseOperation(leaseEntity, JyNnewOperation);
							JyNnewOperation.setPageCnt("0");
						}
					}		
				}
				else
				{
					/* 重要性有 */
					if (leaseEntity.getTaishoAcKijyunCd().equals("0")) {
						/* 旧リース会計基準 */
						if (leaseEntity.getTrdHnteiKekaCd().equals("1")) {
							/* 所有権移転ファイナンスリース */
							if (leaseEntity.getAcShrCd().equals("0")) {
								setLeaseFinancial(leaseEntity, JyAoldFinacalBuy);
								JyAoldFinacalBuy.setPageCnt("0");
							}
							else {
								/* 賃貸借処理 */
								setLeaseFinancial(leaseEntity, JyAoldFinacalRent);
								JyAoldFinacalRent.setPageCnt("0");
							}
						}
						else if (leaseEntity.getTrdHnteiKekaCd().equals("2")) {
							/* 所有権移転外ファイナンスリース */
							if (leaseEntity.getAcShrCd().equals("0")) {
								/* 売買処理 */
								setLeaseFinancial(leaseEntity, JyAoldFinacalGaiBuy);
								JyAoldFinacalGaiBuy.setPageCnt("0");
							}
							else {
								/* 賃貸借処理 */
								setLeaseFinancial(leaseEntity, JyAoldFinacalGaiRent);
								JyAoldFinacalGaiRent.setPageCnt("0");
							}
						}
						else {
							/* オペリース */
							setLeaseOperation(leaseEntity, JyAoldOperation);
							JyAoldOperation.setPageCnt("0");
						}
					}
					else {
						/* 新リース会計基準 */
						if (leaseEntity.getTrdHnteiKekaCd().equals("1")) {
							/* 所有権移転ファイナンスリース */
							if (leaseEntity.getAcShrCd().equals("0")) {
								/* 売買処理 */
								setLeaseFinancial(leaseEntity, JyAnewFinacalBuy);
								JyAnewFinacalBuy.setPageCnt("0");
							}
							else {
								/* 賃貸借処理 */
								setLeaseFinancial(leaseEntity, JyAnewFinacalRent);
								JyAnewFinacalRent.setPageCnt("0");
							}
						}
						else if (leaseEntity.getTrdHnteiKekaCd().equals("2")) {
							/* 所有権移転外ファイナンスリース */
							if (leaseEntity.getAcShrCd().equals("0")) {
								/* 売買処理 */
								setLeaseFinancial(leaseEntity, JyAnewFinacalGaiBuy);
								JyAnewFinacalGaiBuy.setPageCnt("0");
							}
							else {
								/* 賃貸借処理 */
								setLeaseFinancial(leaseEntity, JyAnewFinacalGaiRent);
								JyAnewFinacalGaiRent.setPageCnt("0");
							}
						}
						else {
							/* オペリース */
							setLeaseOperation(leaseEntity, JyAnewOperation);
							JyAnewOperation.setPageCnt("0");
						}
					}		
				}
				// 2020/05/22 REP START
			}

			staxEntity.setCon(piCon);

			staxEntity.execSQL();

			while (staxEntity.next()) {
				// 2020/05/22 REP START
//				if (staxEntity.getTaishoAcKijyunCd().equals("0")) {
//					/* 旧リース会計基準 */
//					if (staxEntity.getTrdHnteiKekaCd().equals("1")) {
//						/* 所有権移転ファイナンスリース */
//						if (staxEntity.getAcShrCd().equals("1")) {
//							/* 賃貸借処理 */
//							setStaxFinancial(staxEntity, oldFinacalRent);
//							oldFinacalRent.setPageCnt("0");
//						}
//					}
//					else if (staxEntity.getTrdHnteiKekaCd().equals("2")) {
//						/* 所有権移転外ファイナンスリース */
//						if (staxEntity.getAcShrCd().equals("1")) {
//							/* 賃貸借処理 */
//							setStaxFinancial(staxEntity, oldFinacalGaiRent);
//							oldFinacalGaiRent.setPageCnt("0");
//						}
//					}
//				}
//				else {
//					/* 新リース会計基準 */
//					if (staxEntity.getTrdHnteiKekaCd().equals("1")) {
//						/* 所有権移転ファイナンスリース */
//						if (staxEntity.getAcShrCd().equals("1")) {
//							/* 賃貸借処理 */
//							setStaxFinancial(staxEntity, newFinacalRent);
//							newFinacalRent.setPageCnt("0");
//						}
//					}
//					else if (staxEntity.getTrdHnteiKekaCd().equals("2")) {
//						/* 所有権移転外ファイナンスリース */
//						if (staxEntity.getAcShrCd().equals("1")) {
//							/* 賃貸借処理 */
//							setStaxFinancial(staxEntity, newFinacalGaiRent);
//							newFinacalGaiRent.setPageCnt("0");
//						}
//					}
//				}
				//
				if (staxEntity.getJysiUm().equals("なし")) {
					/* 重要性無 */
					if (staxEntity.getTaishoAcKijyunCd().equals("0")) {
						/* 旧リース会計基準 */
						if (staxEntity.getTrdHnteiKekaCd().equals("1")) {
							/* 所有権移転ファイナンスリース */
							if (staxEntity.getAcShrCd().equals("1")) {
								/* 賃貸借処理 */
								setStaxFinancial(staxEntity, JyNoldFinacalRent);
								JyNoldFinacalRent.setPageCnt("0");
							}
						}
						else if (staxEntity.getTrdHnteiKekaCd().equals("2")) {
							/* 所有権移転外ファイナンスリース */
							if (staxEntity.getAcShrCd().equals("1")) {
								/* 賃貸借処理 */
								setStaxFinancial(staxEntity, JyNoldFinacalGaiRent);
								JyNoldFinacalGaiRent.setPageCnt("0");
							}
						}
					}
					else {
						/* 新リース会計基準 */
						if (staxEntity.getTrdHnteiKekaCd().equals("1")) {
							/* 所有権移転ファイナンスリース */
							if (staxEntity.getAcShrCd().equals("1")) {
								/* 賃貸借処理 */
								setStaxFinancial(staxEntity, JyNnewFinacalRent);
								JyNnewFinacalRent.setPageCnt("0");
							}
						}
						else if (staxEntity.getTrdHnteiKekaCd().equals("2")) {
							/* 所有権移転外ファイナンスリース */
							if (staxEntity.getAcShrCd().equals("1")) {
								/* 賃貸借処理 */
								setStaxFinancial(staxEntity, JyNnewFinacalGaiRent);
								JyNnewFinacalGaiRent.setPageCnt("0");
							}
						}
					}
				}
				else
				{
					/* 重要性有 */
					if (staxEntity.getTaishoAcKijyunCd().equals("0")) {
						/* 旧リース会計基準 */
						if (staxEntity.getTrdHnteiKekaCd().equals("1")) {
							/* 所有権移転ファイナンスリース */
							if (staxEntity.getAcShrCd().equals("1")) {
								/* 賃貸借処理 */
								setStaxFinancial(staxEntity, JyAoldFinacalRent);
								JyAoldFinacalRent.setPageCnt("0");
							}
						}
						else if (staxEntity.getTrdHnteiKekaCd().equals("2")) {
							/* 所有権移転外ファイナンスリース */
							if (staxEntity.getAcShrCd().equals("1")) {
								/* 賃貸借処理 */
								setStaxFinancial(staxEntity, JyAoldFinacalGaiRent);
								JyAoldFinacalGaiRent.setPageCnt("0");
							}
						}
					}
					else {
						/* 新リース会計基準 */
						if (staxEntity.getTrdHnteiKekaCd().equals("1")) {
							/* 所有権移転ファイナンスリース */
							if (staxEntity.getAcShrCd().equals("1")) {
								/* 賃貸借処理 */
								setStaxFinancial(staxEntity, JyAnewFinacalRent);
								JyAnewFinacalRent.setPageCnt("0");
							}
						}
						else if (staxEntity.getTrdHnteiKekaCd().equals("2")) {
							/* 所有権移転外ファイナンスリース */
							if (staxEntity.getAcShrCd().equals("1")) {
								/* 賃貸借処理 */
								setStaxFinancial(staxEntity, JyAnewFinacalGaiRent);
								JyAnewFinacalGaiRent.setPageCnt("0");
							}
						}
					}
				}
				// 2020/05/22 REP END
			}

			// 2020/05/22 REP START
//			piUkebaraiBean.setOldBaibaiItenList(oldFinacalBuy.toArray());
//			piUkebaraiBean.setOldTintaiItenList(oldFinacalRent.toArray());
//			piUkebaraiBean.setOldBaibaiItengaiList(oldFinacalGaiBuy.toArray());
//			piUkebaraiBean.setOldTintaiItengaiList(oldFinacalGaiRent.toArray());
//			piUkebaraiBean.setOldOperateList(oldOperation.toArray());
//
//			piUkebaraiBean.setNewBaibaiItenList(newFinacalBuy.toArray());
//			piUkebaraiBean.setNewTintaiItenList(newFinacalRent.toArray());
//			piUkebaraiBean.setNewBaibaiItengaiList(newFinacalGaiBuy.toArray());
//			piUkebaraiBean.setNewTintaiItengaiList(newFinacalGaiRent.toArray());
//			piUkebaraiBean.setNewOperateList(newOperation.toArray());
//
//			piUkebaraiBean.setOldBaibaiItenFlg(oldFinacalBuy.getPageCnt());
//			piUkebaraiBean.setOldTintaiItenFlg(oldFinacalRent.getPageCnt());
//			piUkebaraiBean.setOldBaibaiItengaiFlg(oldFinacalGaiBuy.getPageCnt());
//			piUkebaraiBean.setOldTintaiItengaiFlg(oldFinacalGaiRent.getPageCnt());
//			piUkebaraiBean.setOldOperateFlg(oldOperation.getPageCnt());
//
//			piUkebaraiBean.setNewBaibaiItenFlg(newFinacalBuy.getPageCnt());
//			piUkebaraiBean.setNewTintaiItenFlg(newFinacalRent.getPageCnt());
//			piUkebaraiBean.setNewBaibaiItengaiFlg(newFinacalGaiBuy.getPageCnt());
//			piUkebaraiBean.setNewTintaiItengaiFlg(newFinacalGaiRent.getPageCnt());
//			piUkebaraiBean.setNewOperateFlg(newOperation.getPageCnt());
			//
			piUkebaraiBean.setJyNOldBaibaiItenList(JyNoldFinacalBuy.toArray());
			piUkebaraiBean.setJyNOldTintaiItenList(JyNoldFinacalRent.toArray());
			piUkebaraiBean.setJyNOldBaibaiItengaiList(JyNoldFinacalGaiBuy.toArray());
			piUkebaraiBean.setJyNOldTintaiItengaiList(JyNoldFinacalGaiRent.toArray());
			piUkebaraiBean.setJyNOldOperateList(JyNoldOperation.toArray());

			piUkebaraiBean.setJyNNewBaibaiItenList(JyNnewFinacalBuy.toArray());
			piUkebaraiBean.setJyNNewTintaiItenList(JyNnewFinacalRent.toArray());
			piUkebaraiBean.setJyNNewBaibaiItengaiList(JyNnewFinacalGaiBuy.toArray());
			piUkebaraiBean.setJyNNewTintaiItengaiList(JyNnewFinacalGaiRent.toArray());
			piUkebaraiBean.setJyNNewOperateList(JyNnewOperation.toArray());

			piUkebaraiBean.setJyNOldBaibaiItenFlg(JyNoldFinacalBuy.getPageCnt());
			piUkebaraiBean.setJyNOldTintaiItenFlg(JyNoldFinacalRent.getPageCnt());
			piUkebaraiBean.setJyNOldBaibaiItengaiFlg(JyNoldFinacalGaiBuy.getPageCnt());
			piUkebaraiBean.setJyNOldTintaiItengaiFlg(JyNoldFinacalGaiRent.getPageCnt());
			piUkebaraiBean.setJyNOldOperateFlg(JyNoldOperation.getPageCnt());

			piUkebaraiBean.setJyNNewBaibaiItenFlg(JyNnewFinacalBuy.getPageCnt());
			piUkebaraiBean.setJyNNewTintaiItenFlg(JyNnewFinacalRent.getPageCnt());
			piUkebaraiBean.setJyNNewBaibaiItengaiFlg(JyNnewFinacalGaiBuy.getPageCnt());
			piUkebaraiBean.setJyNNewTintaiItengaiFlg(JyNnewFinacalGaiRent.getPageCnt());
			piUkebaraiBean.setJyNNewOperateFlg(JyNnewOperation.getPageCnt());
			//
			piUkebaraiBean.setJyAOldBaibaiItenList(JyAoldFinacalBuy.toArray());
			piUkebaraiBean.setJyAOldTintaiItenList(JyAoldFinacalRent.toArray());
			piUkebaraiBean.setJyAOldBaibaiItengaiList(JyAoldFinacalGaiBuy.toArray());
			piUkebaraiBean.setJyAOldTintaiItengaiList(JyAoldFinacalGaiRent.toArray());
			piUkebaraiBean.setJyAOldOperateList(JyAoldOperation.toArray());

			piUkebaraiBean.setJyANewBaibaiItenList(JyAnewFinacalBuy.toArray());
			piUkebaraiBean.setJyANewTintaiItenList(JyAnewFinacalRent.toArray());
			piUkebaraiBean.setJyANewBaibaiItengaiList(JyAnewFinacalGaiBuy.toArray());
			piUkebaraiBean.setJyANewTintaiItengaiList(JyAnewFinacalGaiRent.toArray());
			piUkebaraiBean.setJyANewOperateList(JyAnewOperation.toArray());

			piUkebaraiBean.setJyAOldBaibaiItenFlg(JyAoldFinacalBuy.getPageCnt());
			piUkebaraiBean.setJyAOldTintaiItenFlg(JyAoldFinacalRent.getPageCnt());
			piUkebaraiBean.setJyAOldBaibaiItengaiFlg(JyAoldFinacalGaiBuy.getPageCnt());
			piUkebaraiBean.setJyAOldTintaiItengaiFlg(JyAoldFinacalGaiRent.getPageCnt());
			piUkebaraiBean.setJyAOldOperateFlg(JyAoldOperation.getPageCnt());

			piUkebaraiBean.setJyANewBaibaiItenFlg(JyAnewFinacalBuy.getPageCnt());
			piUkebaraiBean.setJyANewTintaiItenFlg(JyAnewFinacalRent.getPageCnt());
			piUkebaraiBean.setJyANewBaibaiItengaiFlg(JyAnewFinacalGaiBuy.getPageCnt());
			piUkebaraiBean.setJyANewTintaiItengaiFlg(JyAnewFinacalGaiRent.getPageCnt());
			piUkebaraiBean.setJyANewOperateFlg(JyAnewOperation.getPageCnt());
			// 2020/05/22 REP END

		}
		finally {
			sisanEntity.close();
			leaseEntity.close();
			staxEntity.close();
		}
	}

	private static void setSisanFinancial(LACSUkebaraiSisanEntity piEntity, LACSUkebaraiTable piTable) {
		// 2020/05/22 ADD TEST START
		//System.out.println("SQL setSisanFinancial start");
		//System.out.println(super.sql);
		//System.out.println("SQL setSisanFinancial end");
		// 2020/05/22 ADD TEST END
		int yukeiMukei = 0;

		if (piEntity.getSisanKbnCd().equals("9")) {
			yukeiMukei = 1;
		}

		if (piTable.getPageCnt().equals("")) {
			piTable.setCompanyName(piEntity.getLcNm());
			piTable.setUserName(piEntity.getLuNm());
			piTable.setKaikeiKijunCode(piEntity.getTaishoAcKijyunCd());
			piTable.setKaikeiKijunName(piEntity.getTaishoAcKijyunNm());
			piTable.setTrdHanteiCode(piEntity.getTrdHnteiKekaCd());
			piTable.setTrdHanteiName(piEntity.getTrdHnteiKekaNm());
			piTable.setKaikeiKijunCode(piEntity.getAcShrCd());
			piTable.setKaikeiKijunName(piEntity.getAcShrNm());
			// 2020/05/22 ADD START
			piTable.setJysiUm(piEntity.getJysiUm());
			// 2020/05/22 ADD END
		}

		piTable.getTableBS().getRow(0 + yukeiMukei * 3).setZenki(piEntity.getZenkimatuZanAmt());
		piTable.getTableBS().getRow(0 + yukeiMukei * 3).setZouka(piEntity.getToukiZoukaAmt());
		piTable.getTableBS().getRow(0 + yukeiMukei * 3).setGenshou(piEntity.getToukiGensyoAmt());
		piTable.getTableBS().getRow(0 + yukeiMukei * 3).setKimatsu(piEntity.getToukimatuZanAmt());

		piTable.getTableBS().getRow(1 + yukeiMukei * 3).setZenki(piEntity.getZenkimatuSyokyakuAmt());
		piTable.getTableBS().getRow(1 + yukeiMukei * 3).setTouki(piEntity.getToukiJitugenAmt());
		piTable.getTableBS().getRow(1 + yukeiMukei * 3).setKimatsu(piEntity.getToukimatuSyokyakuAmt());

		piTable.getTableBS().getRow(2 + yukeiMukei * 3).setZenki(piEntity.getZenkimatuBokaAmt());
		piTable.getTableBS().getRow(2 + yukeiMukei * 3).setZouka(piEntity.getToukiZoukaBokaAmt());
		piTable.getTableBS().getRow(2 + yukeiMukei * 3).setGenshou(piEntity.getToukiGensyoBokaAmt());
		piTable.getTableBS().getRow(2 + yukeiMukei * 3).setKimatsu(piEntity.getToukimatuBokaAmt());

		if (piEntity.getAcShrCd().equals("0")) {
			piTable.getTablePL().getRow(0 + yukeiMukei).setZenki(piEntity.getZenkimatuSyokyakuAmt());
			piTable.getTablePL().getRow(0 + yukeiMukei).setTouki(piEntity.getToukiJitugenAmt());
			piTable.getTablePL().getRow(0 + yukeiMukei).setGenshou(piEntity.getToukiGensyoAmt() - piEntity.getToukiGensyoBokaAmt());
			piTable.getTablePL().getRow(0 + yukeiMukei).setKimatsu(piEntity.getToukimatuSyokyakuAmt());
		}
	}

	private static void setLeaseFinancial(LACSUkebaraiLeaseEntity piEntity, LACSUkebaraiTable piTable) {

		// 2020/05/22 ADD TEST START
		//System.out.println("SQL setLeaseFinancial start");
		//System.out.println(super.sql);
		//System.out.println("SQL setLeaseFinancial end");
		// 2020/05/22 ADD TEST END

		if (piTable.getPageCnt().equals("")) {
			piTable.setCompanyName(piEntity.getLcNm());
			piTable.setUserName(piEntity.getLuNm());
			piTable.setKaikeiKijunCode(piEntity.getTaishoAcKijyunCd());
			piTable.setKaikeiKijunName(piEntity.getTaishoAcKijyunNm());
			piTable.setTrdHanteiCode(piEntity.getTrdHnteiKekaCd());
			piTable.setTrdHanteiName(piEntity.getTrdHnteiKekaNm());
			piTable.setKaikeiKijunCode(piEntity.getAcShrCd());
			piTable.setKaikeiKijunName(piEntity.getAcShrNm());
			// 2020/05/22 ADD START
			piTable.setJysiUm(piEntity.getJysiUm());
			// 2020/05/22 ADD END
		}

		piTable.getTableBS().getRow(6).setZenki(piEntity.getSaimuZenkimatuAmt());
		piTable.getTableBS().getRow(6).setZouka(piEntity.getSaimuToukiZoukaAmt());
		piTable.getTableBS().getRow(6).setTouki(piEntity.getSaimuToukiJitugenAmt());
		piTable.getTableBS().getRow(6).setGenshou(piEntity.getSaimuToukiGensyoAmt());
		piTable.getTableBS().getRow(6).setKimatsu(piEntity.getSaimuToukimatuAmt());

		piTable.getTableBS().getRow(7).setZenki(piEntity.getMibaraiZenkimatuAmt());
		piTable.getTableBS().getRow(7).setZouka(piEntity.getMibaraiToukiZoukaAmt());
		piTable.getTableBS().getRow(7).setTouki(piEntity.getMibaraiToukiJitugenAmt());
		piTable.getTableBS().getRow(7).setGenshou(piEntity.getMibaraiToukiGensyoAmt());
		piTable.getTableBS().getRow(7).setKimatsu(piEntity.getMibaraiToukimatuAmt());

		// 2020/05/22 ADD START
		piTable.getTableBS().getRow(8).setZenki(piEntity.getZankZenkimatuAmt());
		piTable.getTableBS().getRow(8).setZouka(piEntity.getZankToukiZoukaAmt());
		piTable.getTableBS().getRow(8).setTouki(piEntity.getZankToukiJitugenAmt());
		piTable.getTableBS().getRow(8).setGenshou(piEntity.getZankToukiGensyoAmt());
		piTable.getTableBS().getRow(8).setKimatsu(piEntity.getZankToukimatuAmt());
		// 2020/05/22 ADD END

		if (piEntity.getAcShrCd().equals("0")) {
			piTable.getTablePL().getRow(2).setZenki(piEntity.getRskZenkimatuAmt());
			piTable.getTablePL().getRow(2).setTouki(piEntity.getRskToukiJitugenAmt());
			piTable.getTablePL().getRow(2).setGenshou(piEntity.getRskToukiGensyoAmt());
			piTable.getTablePL().getRow(2).setKimatsu(piEntity.getRskToukimatuAmt());

			piTable.getTablePL().getRow(3).setZenki(piEntity.getIjiZenkimatuAmt());
			piTable.getTablePL().getRow(3).setTouki(piEntity.getIjiToukiJitugenAmt());
			piTable.getTablePL().getRow(3).setGenshou(piEntity.getIjiToukiGensyoAmt());
			piTable.getTablePL().getRow(3).setKimatsu(piEntity.getIjiToukimatuAmt());

			piTable.getTablePL().getRow(4).setZenki(piEntity.getEkmZenkimatuAmt());
			piTable.getTablePL().getRow(4).setTouki(piEntity.getEkmToukiJitugenAmt());
			piTable.getTablePL().getRow(4).setGenshou(piEntity.getEkmToukiGensyoAmt());
			piTable.getTablePL().getRow(4).setKimatsu(piEntity.getEkmToukimatuAmt());
		}
		else {
			piTable.getTablePL().getRow(0).setZenki(piEntity.getLeasAmtRuiZenkimatuAmt());
			piTable.getTablePL().getRow(0).setTouki(piEntity.getLeasAmtRuiToukiJitugenAmt());
			piTable.getTablePL().getRow(0).setGenshou(piEntity.getLeasAmtRuiToukiGensyoAmt());
			piTable.getTablePL().getRow(0).setKimatsu(piEntity.getLeasAmtRuiToukimatuAmt());
		}
	}

	private static void setLeaseOperation(LACSUkebaraiLeaseEntity piEntity, LACSUkebaraiTable piTable) {
		// 2020/05/22 ADD TEST START
		//System.out.println("SQL setLeaseOperation start");
		//System.out.println(super.sql);
		//System.out.println("SQL setLeaseOperation end");
		// 2020/05/22 ADD TEST END
		if (piTable.getPageCnt().equals("")) {
			piTable.setCompanyName(piEntity.getLcNm());
			piTable.setUserName(piEntity.getLuNm());
			piTable.setKaikeiKijunCode(piEntity.getTaishoAcKijyunCd());
			piTable.setKaikeiKijunName(piEntity.getTaishoAcKijyunNm());
			piTable.setTrdHanteiCode(piEntity.getTrdHnteiKekaCd());
			piTable.setTrdHanteiName(piEntity.getTrdHnteiKekaNm());
			piTable.setKaikeiKijunCode(piEntity.getAcShrCd());
			piTable.setKaikeiKijunName(piEntity.getAcShrNm());
			// 2020/05/22 ADD START
			piTable.setJysiUm(piEntity.getJysiUm());
			// 2020/05/22 ADD END
		}

		piTable.getTablePL().getRow(0).setZenki(piEntity.getLeasAmtRuiZenkimatuAmt());
		piTable.getTablePL().getRow(0).setTouki(piEntity.getLeasAmtRuiToukiJitugenAmt());
		piTable.getTablePL().getRow(0).setGenshou(piEntity.getLeasAmtRuiToukiGensyoAmt());
		piTable.getTablePL().getRow(0).setKimatsu(piEntity.getLeasAmtRuiToukimatuAmt());

		piTable.getTablePL().getRow(1).setZenki(piEntity.getMibaraiZenkimatuAmt());
		piTable.getTablePL().getRow(1).setTouki(piEntity.getMibaraiToukiJitugenAmt());
		piTable.getTablePL().getRow(1).setGenshou(piEntity.getMibaraiToukiGensyoAmt());
		piTable.getTablePL().getRow(1).setKimatsu(piEntity.getMibaraiToukimatuAmt());
	}

	private static void setStaxFinancial(LACSUkebaraiLeaseCtskSTaxEntity piEntity, LACSUkebaraiTable piTable) {
		// 2020/05/22 ADD TEST START
		//System.out.println("SQL setStaxFinancial start");
		//System.out.println(super.sql);
		//System.out.println("SQL setStaxFinancial end");
		// 2020/05/22 ADD TEST END
		if (piTable.getPageCnt().equals("")) {
			piTable.setKaikeiKijunCode(piEntity.getTaishoAcKijyunCd());
			piTable.setKaikeiKijunName(piEntity.getTaishoAcKijyunNm());
			piTable.setTrdHanteiCode(piEntity.getTrdHnteiKekaCd());
			piTable.setTrdHanteiName(piEntity.getTrdHnteiKekaNm());
			piTable.setKaikeiKijunCode(piEntity.getAcShrCd());
			piTable.setKaikeiKijunName(piEntity.getAcShrNm());
			// 2020/05/22 ADD START
			piTable.setJysiUm(piEntity.getJysiUm());
			// 2020/05/22 ADD END
		}

		piTable.getTablePL().getRow(1).setZenki(piEntity.getMibaraiZenkimatuAmt());
		piTable.getTablePL().getRow(1).setTouki(piEntity.getMibaraiToukiJitugenAmt());
		piTable.getTablePL().getRow(1).setGenshou(piEntity.getMibaraiToukiGensyoAmt());
		piTable.getTablePL().getRow(1).setKimatsu(piEntity.getMibaraiToukimatuAmt());
	}

}
