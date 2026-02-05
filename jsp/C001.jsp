<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.company.html.*"
	import="jp.co.pro_app.lacs.common.define.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="companyBean" scope="session" class="jp.co.pro_app.lacs.affairs.company.bean.LACSCompanyBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>ﾘｰｽ会社メンテナンス</title>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<link href="css/style.css" type="text/css" rel="stylesheet"/>
		<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240827 -->
	<form name="frm" class="background">
		<input type="hidden" name="condCompanyCode" value="<%= companyBean.getCondCompanyCode() %>"/>
		<input type="hidden" name="procMode" value="<%= companyBean.getProcMode() %>"/>
		<div class="common-header">
<%= LACSCompanyHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= companyBean.getMessage() %>
			<div class="section">
				<span class="font-red">*</span> リース会社コード：
<% if(companyBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_UPD){ %>
				<input type="text" class="textbox-seven" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getLeasCompanyCode()) %>" name="leasCompanyCodeDmy" size="6" maxlength="5" disabled="disabled" tabindex="1"/>
				<input type="hidden" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getLeasCompanyCode()) %>" name="targetCompanyCode"/>
<% }else{ %>
				<input type="text" class="textbox-seven" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getLeasCompanyCode()) %>" name="targetCompanyCode" size="6" maxlength="5" tabindex="1"/>
<% }%>
			</div>
			<div class="company-info">	
				<div class="company-info-display">
					<div class="section">
						<span class="font-red">* </span>名称：
					</div>
					<div class="section">
						<span class="font-red">* </span>住所：
					</div>
				</div>
				<div class="company-info-input">
					<div class="section">
						<input type="text" class="textbox-eleven" maxlength="50" size="60" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getName()) %>" name="name" tabindex="3"/>
					</div>
					<div class="section">
						〒
						<input type="text" class="textbox-two" maxlength="3" size="4" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getZip1()) %>" name="zip1" tabindex="4"/>
						<span class="tilde">-</span> 
						<input type="text" class="textbox-three" maxlength="4" size="5" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getZip2()) %>" name="zip2" tabindex="4"/>
					</div>
					<div class="section">
						<input type="text" class="textbox-eleven" maxlength="30" size="65" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getAddress1()) %>" name="address1" tabindex="4"/>
					</div>
					<div class="section">
						<input type="text" class="textbox-eleven" maxlength="30" size="65" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getAddress2()) %>" name="address2" tabindex="4"/>
					</div>
				</div>
				<div class="manager-related-display">
					<div class="manager-related-section">
						担当者部署：
					</div>
					<div class="manager-related-section">
						担当者：
					</div>
					<div class="manager-related-section">
						<span class="font-red">* </span>担当電話番号：
					</div>
					<div class="manager-related-section">
						<span class="font-red">* </span>処理済年月：
					</div>
				</div>
				<div class="manager-related-input">
					<div class="section">
						<input type="text" class="textbox-eight" maxlength="25" size="50" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getBusyo()) %>" name="busyo" tabindex="6"/>
					</div>
					<div class="section">
						<input type="text" class="textbox-eight" maxlength="25" size="50" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getTanto()) %>" name="tanto" tabindex="7"/>
					</div>
					<div class="section">
						<input type="text" class="textbox-seven" maxlength="13" size="17" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getTantoTel()) %>" name="tantoTel" tabindex="8"/>
					</div>
					<div class="section">
						<input type="text" class="textbox-five" maxlength="6" size="8" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getSyoriYM()) %>" name="syoriYM" tabindex="12"/>
					</div>
				</div>
			</div>
			<div class="input-group-row-nospase">
				<div class="section">
					<div class="classification-section-one">回収予定分割区分：</div>
					<div class="classification-section-two">期末資産残高表示方法区分：</div>
<% if("1".equals(commonBean.getShowTyukiComment())){ %>
					<div class="classification-section-one">注記書類作成基準書文言１：</div>
					<div class="classification-section-one">注記書類作成基準書文言２：</div>
<% }%>
				</div>
				<div class="section-inputbox">
					<div class="section-inputbox">
						契約単位
						<% if(companyBean.getKaisyuKbn().equals("1")){ %>
							<label><input type="radio" class="radiobutton" value="1" name="kaisyuKbn" tabindex="9" checked="checked"/>未展開</label>
						<% } else{ %>
							<label><input type="radio" class="radiobutton" value="1" name="kaisyuKbn" tabindex="9"/>未展開</label>
						<% } %>
						<% if(companyBean.getKaisyuKbn().equals("3")){ %>
							<label><input type="radio" class="radiobutton" value="3" name="kaisyuKbn" tabindex="9" checked="checked"/>展開済</label>
						<% } else{ %>
							<label><input type="radio" class="radiobutton" value="3" name="kaisyuKbn" tabindex="9"/>展開済</label>
						<% } %>
					</div>
					<div class="section-inputbox">
						物件単位
						<% if(companyBean.getKaisyuKbn().equals("2")){ %>
							<label><input type="radio" class="radiobutton" value="2" name="kaisyuKbn" tabindex="9" checked="checked"/>未展開</label>
						<% } else{ %>
							<label><input type="radio" class="radiobutton" value="2" name="kaisyuKbn" tabindex="9"/>未展開</label>
						<% } %>
						<% if(companyBean.getKaisyuKbn().equals("4")){ %>
							<label><input type="radio" class="radiobutton" value="4" name="kaisyuKbn" tabindex="9" checked="checked"/>展開済</label>
						<% } else{ %>
							<label><input type="radio" class="radiobutton" value="4" name="kaisyuKbn" tabindex="9"/>展開済</label>
						<% } %>
					</div>
					<div class="section-inputbox">
						<label><input type="radio" class="radiobutton" value="0" name="kimatsuAmtOutCtl" tabindex="13" <%= companyBean.getKimatsuAmtOutCtl().equals("0") ? "checked" : "" %>/>期中終了契約を表示しない</label>
						<label><input type="radio" class="radiobutton" value="1" name="kimatsuAmtOutCtl" tabindex="13" <%= companyBean.getKimatsuAmtOutCtl().equals("1") ? "checked" : "" %>/>期中終了契約を表示する</label>
					</div>
<% if("1".equals(commonBean.getShowTyukiComment())){ %>
					<div class="section-inputbox">
						<input type="text" class="textbox-twelve" maxlength="75" size="140" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getTyukiComment1()) %>" name="tyukiComment1" tabindex="14"/>
					</div>
					<div class="section-inputbox">
						<input type="text" class="textbox-twelve" maxlength="75" size="140" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getTyukiComment2()) %>" name="tyukiComment2" tabindex="15"/>
					</div>
<% }%>
				</div>
			</div>									
			<hr />
			<p class="section">
				ユーザ開示情報
			</p>
			<div class="user-disclosure-info-title">セキュリティ関連</div>
			<div class="user-disclosure-info-block">
				<div class="security-related">
					<div class="section">
						<span class="font-red">* </span>
						セッションタイムアウト時間：
					</div>
					<div class="section">
						<span class="font-red">* </span>
						仮パスワード有効期間：
					</div>
					<div class="section">
						<span class="font-red">* </span>
						パスワード文字の下限：
					</div>
				</div>
				<div class="security-related-input">
					<div class="section">
						<input type="text" class="textbox-three" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getSessionTimeOut()) %>" name="sessionTimeOut" size="5" maxlength="2" tabindex="16"/>
						分
					</div>
					<div class="section">
						<input type="text" class="textbox-three" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getTempPassValidityTerm()) %>" name="tempPassValidityTerm" size="5" maxlength="2" tabindex="18"/>
						日
					</div>
					<div class="section">
						<input type="text" class="textbox-three" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getPasswordLengthMin()) %>" name="passwordLengthMin" size="5" maxlength="2" tabindex="20"/>
						文字
					</div>
				</div>
				<div class="security-related">
					<div class="section">
						<span class="font-red">* </span>
						ログインエラー許容回数：	
					</div>
					<div class="section">
						<span class="font-red">* </span>
						本パスワード有効期間：
					</div>
					<div class="section">
						<span class="font-red">* </span>
						パスワード文字の上限：
					</div>
				</div>
				<div class="security-related-input">
					<div class="section">
						<input type="text" class="textbox-three" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getLoginErrorMaxCount()) %>" name="loginErrorMaxCount" size="5" maxlength="1" style="text-align:right" tabindex="17"/>
						回
					</div>
					<div class="section">
						<input type="text" class="textbox-three" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getPassValidityTerm()) %>" name="passValidityTerm" size="5" maxlength="3" style="text-align:right" tabindex="19"/>
						日	
					</div>
					<div class="section">
						<input type="text" class="textbox-three" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getPasswordLengthMax()) %>" name="passwordLengthMax" size="5" maxlength="2" style="text-align:right" tabindex="21"/>
						文字
					</div>
				</div>
			</div>
			<div class="user-disclosure-info-title">メニュー制御関連</div>
			<div class="user-disclosure-info-block">
				<div class="section">
					エラー時の処理メニューの制御：
					<label><input type="radio" class="radiobutton" value="0" name="errorLockType" tabindex="22" <%= companyBean.getErrorLockType().equals("0") ? "checked" : "" %>/>全開示先をロック</label>
					<label><input type="radio" class="radiobutton" value="1" name="errorLockType" tabindex="22" <%= companyBean.getErrorLockType().equals("1") ? "checked" : "" %>/>エラーのある開示先のみでロック</label>
				</div>
			</div>
			<div class="user-disclosure-info-title">ログイン画面関連</div>
			<div class="user-disclosure-info-block">
				<div class="login-related">
					<div class="section">
						リース会社ロゴファイル名：
					</div>
					<div class="section">
						SSL証明書のマーク：
					</div>
					<div class="section">
						お問合せ：
					</div>
				</div>
				<div class="login-related-input">
					<div class="section">
						<input type="text" class="textbox-twelve" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getLogoFileName()) %>" name="logoFileName" size="100" maxlength="50" tabindex="23"/>
					</div>
					<div class="section">
						<input type="text" class="textbox-twelve" value="<%= LACSCompanyHTMLUtil.encode(companyBean.getCertificateMarkURL()) %>" name="certificateMarkURL" size="100" maxlength="300" tabindex="24"/>
					</div>
					<div class="section">
						<textarea class="textarea-one" name="freeWord" tabindex="25" rows="3" cols="70"><%= LACSCompanyHTMLUtil.encode(companyBean.getFreeWord()) %></textarea>
					</div>
				</div>
			</div>
			<div class="user-disclosure-info-title">開示先追加時の使用可能機能初期設定</div>
			<div class="user-disclosure-info-block">
				<div class="addable-screen">
					<p>画面</p>
					<div class="section">
						<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"G0000001",26,"支払推移表") %></label>
					</div>
					<div class="section">
						<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"G0000002",27,"仕訳照会") %></label>
					</div>
					<div class="section">
						<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000005",34,"リース料支払スケジュール表（物件単位）") %></label>
					</div>
					<div class="section">
						<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"G0000003",28,"契約検索") %></label>
					</div>
					<div class="section">
						<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"G0000004",29,"物件検索") %></label>
					</div>
					<div class="section">
						<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"G0000005",30,"注記帳票出力") %></label>
					</div>
					<div class="section">
						<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"G0000006",31,"月次帳票出力") %></label>
					</div>
					<div class="section">
						<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"G0000007",32,"受払合計表") %></label>
					</div>
					<div class="section">
						<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"G0000008",33,"契約詳細照会") %></label>
					</div>
				</div>
				<div class="csv-leader">
					<p>帳票／ＣＳＶ</p>
					<div class="input-group-row">
						<div class="csv-leader-input-group">
							注記帳票出力
							<div class="section">
								<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000011",40,"リース会計基準明細書") %></label>
							</div>
							<div class="section">
								<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000004",35,"注記書類作成基準書") %></label>
							</div>
							<div class="section">
								<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000001",36,"リース会計注記合計表") %></label>
							</div>
							<div class="section">
								<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000007",37,"未経過リース料期末残高別表") %></label>
							</div>
							<div class="section">
								<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000002",37,"リース会計資料（減価償却費）") %></label>
							</div>
							<div class="section">
								<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000003",38,"リース会計資料（支払リース料等）") %></label>
							</div>
							<div class="section">
								<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000032",39,"期日別予定表（合計表）") %></label>
							</div>
							<div class="section">
								<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000033",39,"期日別予定表（債務）") %></label>
							</div>
							<div class="section">
								<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000034",39,"期日別予定表（資産）") %></label>
							</div>
							<div class="section">
								<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000006",39,"注記源泉情報") %></label>
							</div>
						</div>
						<div class="csv-leader-input-group">
							月次帳票出力
							<div class="section">
								<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000021",46,"受払合計表") %></label>
							</div>
							<div class="section">
								<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000012",41,"除却資産一覧") %></label>
							</div>
							<div class="section">
								<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000013",42,"仕訳合計表") %></label>
							</div>
							<div class="section">
								<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000016",44,"固定資産台帳（リース資産）") %></label>
							</div>
							<div class="section">
								<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000015",45,"消費税明細表") %></label>
							</div>
							<div class="section">
								<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000014",43,"仕訳源泉情報") %></label>
							</div>
						</div>
						<div class="csv-leader-input-group">
							<div class="section">
								受払合計表
								<div class="section">
									<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000022",47,"リース資産受払明細表") %></label>
								</div>
								<div class="section">
									<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000023",48,"リース料受払明細表") %></label>
								</div>
								<div class="section">
									<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000024",49,"費用受払明細表") %></label>
								</div>
							</div>
							<div class="section">
								契約詳細照会
								<div class="section">
									<label><%= LACSCompanyHTMLUtil.outHTMLDisplayControl(companyBean.getDispControl(),"P0000031",50,"契約詳細情報") %></label>
								</div>
							</div>
						</div>							
					</div>
				</div>
			</div>
			<p class="create-button">
				<input type="button" class="button" value=" 登  録 " onclick="kakuninRegist('regist.company')" name="regist" tabindex="98"/>
				<input type="button" class="button" value=" 戻  る " onclick="post('back.company')" name="return" tabindex="99"/>
			</p>
		</div>
		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>