<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.user.html.*"
	import="jp.co.pro_app.lacs.common.define.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="userBean" scope="session" class="jp.co.pro_app.lacs.affairs.user.bean.LACSUserBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>開示先メンテナンス</title>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<link href="css/style.css" type="text/css" rel="stylesheet"/>
		<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240827 -->
	<form name="frm" class="background">
		<input type="hidden" name="condCosmosCode" value="<%= userBean.getCondCosmosCode() %>"/>
		<input type="hidden" name="procMode" value="<%= userBean.getProcMode() %>"/>
		<input type="hidden" name="leasCompanyNm" value="<%= userBean.getleasCompanyNm() %>"/>
		<input type="hidden" name="leasCompany" value="<%= userBean.getleasCompany() %>"/>
		<input type="hidden" name="PageNo" value="<%= userBean.getPageNo() %>"/>
		<div class="common-header">
<%= LACSUserHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= userBean.getMessage() %>
			<div class="section">
				<span class="font-red">※この画面での設定内容は、次回取り込み時より反映されるものであり、すでに取り込み済みの契約には反映されません。※</span>
			</div>
			<div class="section">
				<span class="font-red">* </span>開示先コード：
<% if(userBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_UPD){ %>
				<input type="text" class="textbox-seven" value="<%= LACSUserHTMLUtil.encode(userBean.getUserCosmosCode()) %>" name="cosmosCodeDmy" size="13" maxlength="10" disabled="disabled" tabindex="1"/>
				<input type="hidden" value="<%= LACSUserHTMLUtil.encode(userBean.getUserCosmosCode()) %>" name="targetCosmosCode"/>
<% }else{ %>
				<input type="text" class="textbox-seven" value="<%= LACSUserHTMLUtil.encode(userBean.getUserCosmosCode()) %>" name="targetCosmosCode" size="13" maxlength="10" tabindex="1"/>
<% }%>
			</div>
			<div class="registration-info">
				<div class="registration-info-display">
					<div class="section">
						<span class="font-red">* </span>開示先：
					</div>
					<div class="section">
						<span class="font-red">* </span>住所：
					</div>
				</div>
				<div class="registration-info-input">
					<div class="section">
<% if ("1".equals(commonBean.getControlTyukiPdf())) { %>
						<input type="text" class="textbox-seven" maxlength="25" size="65" value="<%= LACSUserHTMLUtil.encode(userBean.getUserName()) %>" name="userName" tabindex="2"/>
<% }else{ %>
						<input type="text" class="textbox-seven" maxlength="25" size="65" value="<%= LACSUserHTMLUtil.encode(userBean.getUserName()) %>" name="userName" tabindex="2"/>
<% }%>
					</div>
					<div class="section">
<!-- MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 start -->
<% if ("1".equals(commonBean.getControlTyukiPdf())||("0".equals(commonBean.getControlTyukiPdf())&&"1".equals(commonBean.getAdress()))) { %>
	<!-- MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/26 start -->	
						〒 <input type="text" class="textbox-two" maxlength="3" size="4" value="<%= LACSUserHTMLUtil.encode(userBean.getUserZip1()) %>" name="userZip1" tabindex="4"/>
						<span class="tilde">-</span>
						<input type="text" class="textbox-three" maxlength="4" size="5" value="<%= LACSUserHTMLUtil.encode(userBean.getUserZip2()) %>" name="userZip2" tabindex="4"/>
<% }else{ %>
						〒 <input type="text" class="textbox-two" maxlength="3" size="4" value="<%= LACSUserHTMLUtil.encode(userBean.getUserZip1()) %>" name="userZip1" tabindex="4"/>
						<span class="tilde">-</span>
	 					<input type="text" class="textbox-three" maxlength="4" size="5" value="<%= LACSUserHTMLUtil.encode(userBean.getUserZip2()) %>" name="userZip2" tabindex="4"/>
<% }%>				
					</div>
					<div class="section">
<% if ("1".equals(commonBean.getControlTyukiPdf())||("0".equals(commonBean.getControlTyukiPdf())&&"1".equals(commonBean.getAdress()))) { %>
						<input type="text" class="textbox-eleven" maxlength="30" size="76" value="<%= LACSUserHTMLUtil.encode(userBean.getUserAddress1()) %>" name="userAddress1" tabindex="4"/>
<% }else{ %>
						<input type="text" class="textbox-eleven" maxlength="30" size="76" value="<%= LACSUserHTMLUtil.encode(userBean.getUserAddress1()) %>" name="userAddress1" tabindex="4"/>
<% }%>
					</div>
					<div class="section">
<% if ("1".equals(commonBean.getControlTyukiPdf())||("0".equals(commonBean.getControlTyukiPdf())&&"1".equals(commonBean.getAdress()))) { %>
						<input type="text" class="textbox-eleven" maxlength="30" size="76" value="<%= LACSUserHTMLUtil.encode(userBean.getUserAddress2()) %>" name="userAddress2" tabindex="4"/>
<% }else{ %>
						<input type="text" class="textbox-eleven" maxlength="30" size="76" value="<%= LACSUserHTMLUtil.encode(userBean.getUserAddress2()) %>" name="userAddress2" tabindex="4"/>
<% }%>
					</div>				
				</div>
				<div class="registration-info-manager-related-display">
					<div class="section">電話番号：</div>
					<div class="section">担当者：</div>
				</div>
				<div class="registration-info-manager-related-input">
					<div class="section">
						<input type="text" class="textbox-seven" maxlength="13" size="17" value="<%= LACSUserHTMLUtil.encode(userBean.getUserTelNo()) %>" name="userTelNo" tabindex="3"/>
					</div>
					<div class="section">						
						<input type="text" class="textbox-eight" maxlength="25" size="40" value="<%= LACSUserHTMLUtil.encode(userBean.getUserTantoName()) %>" name="userTantoName" tabindex="5"/>
					</div>
				</div>
			</div>
			<div class="closing-date">
				<div class="section">
					<span class="font-red">* </span>決算日：
					<input type="text" class="textbox-one" size="2" value="<%= LACSUserHTMLUtil.encode(userBean.getKesnKiMM()) %>" name="kesnKiMM" maxlength="2" tabindex="7" />
					月
					<input type="text" class="textbox-one" size="2" value="<%= LACSUserHTMLUtil.encode(userBean.getKesnKiDD()) %>" name="kesnKiDD" maxlength="2" tabindex="7" />
					日
				</div>
				<div class="section">
<!-- ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/21 start -->
<!-- MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/05/27 start -->
<% if ("1".equals(commonBean.getAdress())) { %>
					出力サイクル：
					<select class="pulldown-four" name="batchPrintTimingCd" tabindex="7">
					<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getBatchPrintTimingCd())%>
					</select>
<% }%>
				</div>
			</div>
<!-- MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/05/27 end -->
<!-- MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/05/22 start -->
<% if ("1".equals(commonBean.getAdress())) { %>
			<div class="manager-related">
				<div class="section-ratio-one">
					<div class="section">
						部署コード：
						<input type="text" class="textbox-three" size="2" value="<%= LACSUserHTMLUtil.encode(userBean.getLcShzkSho()) %>" name="lcShzkSho" maxlength="2" tabindex="8" />
						<span class="tilde">-</span>
						<input type="text" class="textbox-three" size="2" value="<%= LACSUserHTMLUtil.encode(userBean.getLcShzkBu()) %>" name="lcShzkBu" maxlength="2" tabindex="8" />
						<span class="tilde">-</span>
						<input type="text" class="textbox-three" size="2" value="<%= LACSUserHTMLUtil.encode(userBean.getLcShzkGrp()) %>" name="lcShzkGrp" maxlength="2" tabindex="8" />
						<span class="section">部署名：</span>
						<input type="text" class="textbox-eight" value="<%= LACSUserHTMLUtil.encode(userBean.getLcShzkNm()) %>" name="lcShzkNm" size="13" maxlength="6" tabindex="9"/>
					</div>
				</div>
				<div class="section-ratio-one">
					<div class="section">
						担当者コード：
						<input type="text" class="textbox-six" value="<%= LACSUserHTMLUtil.encode(userBean.getLcTntCd()) %>" name="lcTntCd" size="4" maxlength="4" tabindex="9"/>
						<span class="section">担当者名：</span>
						<input type="text" class="textbox-eight" value="<%= LACSUserHTMLUtil.encode(userBean.getLcTntNm()) %>" name="lcTntNm" size="18" maxlength="10" tabindex="9"/>
					</div>
				</div>
			</div>
<% }%>
<!-- MODIFY Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/05/22 end -->
<!-- ADD Zhen.XB LACS帳票バッチ_開示先メンテナンス画面の改修 2013/03/21 end -->
			<div class="other-section">
				<div class="section">
					会計処理方法：
					<select class="pulldown-three" name="acShrKbn"  tabindex="10">
						<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getAcShrKbn())%>
					</select>
				</div>
				<div class="section">
					西暦和暦：
					<select class="pulldown-two" name="seirekiWarekiCode"  tabindex="10">
						<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getSeirekiWarekiCode())%>
					</select>
				</div>
				<div class="section">
					利子率の精度：
					<select class="pulldown-one" name="syosuKetasu"  tabindex="10">
						<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getSyosuKetasu())%>
					</select>
				</div>
			</div>
<% if(commonBean.isShowSumUnt()) { %>
			<div class="new-disclosure-recipient-info-title">集計単位</div>
			<div class="new-disclosure-recipient-info-block">
				<div class="section-ratio-one">
					旧リース会計基準：
					<label><input tabindex="11" type="radio" class="radiobutton" value="0" name="oldSumUnt" <%= userBean.getOldSumUnt().equals("0") ? " checked" : "" %>/>契約単位</label>
					<label><input tabindex="11" type="radio" class="radiobutton" value="1" name="oldSumUnt" <%= userBean.getOldSumUnt().equals("1") ? " checked" : "" %>/>資産単位</label>
				</div>
				<div class="section-ratio-one">
					新リース会計基準：
					<label><input tabindex="11" type="radio" class="radiobutton" value="0" name="newSumUnt" <%= userBean.getNewSumUnt().equals("0") ? " checked" : "" %>/>契約単位</label>
					<label><input tabindex="11" type="radio" class="radiobutton" value="1" name="newSumUnt" <%= userBean.getNewSumUnt().equals("1") ? " checked" : "" %>/>資産単位</label>
				</div>
			</div>
<% } %>
			<div class="new-disclosure-recipient-info-title">抽出条件</div>
			<div class="new-disclosure-recipient-exttaction-condition">
				<div class="input-group-row">
					<div class="section-ratio-two">
						注記帳票出力
					</div>
					<div class="section-ratio-one">
						月次帳票出力
					</div>
				</div>
				<div class="accounting-standard-row">
					<div class="section-ratio-one">
						旧リース会計基準
					</div>
					<div class="section-ratio-three">
						新リース会計基準
					</div>
				</div>
				<div class="input-group-row">
					<div class="exttaction-condition-section">
						<div class="section">少額資産：</div>
						<div class="section">リース期間1年未満：</div>
						<div class="section">再リース契約：</div>
						<div class="section">中途解約物件：</div>
					</div>
					<div class="exttaction-condition-select">
						<div class="section">
							<label><input type="radio" class="radiobutton" value="0" name="oldSgkKeiJgiFlg" tabindex="11"<%= userBean.getOldSgkKeiJgiFlg().equals("0") ? " checked" : "" %>/>除く</label>
							<label><input type="radio" class="radiobutton" value="1" name="oldSgkKeiJgiFlg" tabindex="11"<%= userBean.getOldSgkKeiJgiFlg().equals("1") ? " checked" : "" %>/>除かない</label>
						</div>
						<div class="section">
							<label><input type="radio" class="radiobutton" value="0" name="oldSrtKeiJgiFlg" tabindex="11"<%= userBean.getOldSrtKeiJgiFlg().equals("0") ? " checked" : "" %>/>除く</label>
							<label><input type="radio" class="radiobutton" value="1" name="oldSrtKeiJgiFlg" tabindex="11"<%= userBean.getOldSrtKeiJgiFlg().equals("1") ? " checked" : "" %>/>除かない</label>
						</div>
						<div class="section">
							<label><input type="radio" class="radiobutton" value="0" name="oldRlsKeiJgiFlg" tabindex="11"<%= userBean.getOldRlsKeiJgiFlg().equals("0") ? " checked" : "" %>/>除く</label>
							<label><input type="radio" class="radiobutton" value="1" name="oldRlsKeiJgiFlg" tabindex="11"<%= userBean.getOldRlsKeiJgiFlg().equals("1") ? " checked" : "" %>/>除かない</label>
						</div>
						<div class="section">
							<label><input type="radio" class="radiobutton" value="0" name="oldCytKaiJgiFlg" tabindex="11"<%= userBean.getOldCytKaiJgiFlg().equals("0") ? " checked" : "" %>/>除く</label>
							<label><input type="radio" class="radiobutton" value="1" name="oldCytKaiJgiFlg" tabindex="11"<%= userBean.getOldCytKaiJgiFlg().equals("1") ? " checked" : "" %>/>除かない</label>
						</div>
					</div>
					<div class="exttaction-condition-section">
						<div class="section">少額資産：</div>
						<div class="section">リース期間1年未満：</div>
						<div class="section">再リース契約：</div>
						<div class="section">中途解約物件：</div>
					</div>
					<div class="exttaction-condition-select">
						<div class="section">
							<label><input type="radio" class="radiobutton" value="0" name="newSgkKeiJgiFlg" tabindex="12"<%= userBean.getNewSgkKeiJgiFlg().equals("0") ? " checked" : "" %>/>除く</label>
							<label><input type="radio" class="radiobutton" value="1" name="newSgkKeiJgiFlg" tabindex="12"<%= userBean.getNewSgkKeiJgiFlg().equals("1") ? " checked" : "" %>/>除かない</label>
						</div>
						<div class="section">
							<label><input type="radio" class="radiobutton" value="0" name="newSrtKeiJgiFlg" tabindex="12"<%= userBean.getNewSrtKeiJgiFlg().equals("0") ? " checked" : "" %>/>除く</label>
							<label><input type="radio" class="radiobutton" value="1" name="newSrtKeiJgiFlg" tabindex="12"<%= userBean.getNewSrtKeiJgiFlg().equals("1") ? " checked" : "" %>/>除かない</label>
						</div>
						<div class="section">
							<label><input type="radio" class="radiobutton" value="0" name="newRlsKeiJgiFlg" tabindex="12"<%= userBean.getNewRlsKeiJgiFlg().equals("0") ? " checked" : "" %>/>除く</label>
							<label><input type="radio" class="radiobutton" value="1" name="newRlsKeiJgiFlg" tabindex="12"<%= userBean.getNewRlsKeiJgiFlg().equals("1") ? " checked" : "" %>/>除かない</label>
						</div>
						<div class="section">
							<label><input type="radio" class="radiobutton" value="0" name="newCytKaiJgiFlg" tabindex="12"<%= userBean.getNewCytKaiJgiFlg().equals("0") ? " checked" : "" %>/>除く</label>
							<label><input type="radio" class="radiobutton" value="1" name="newCytKaiJgiFlg" tabindex="12"<%= userBean.getNewCytKaiJgiFlg().equals("1") ? " checked" : "" %>/>除かない</label>
						</div>
					</div>
					<div class="exttaction-condition-section">
						<div class="section">少額資産：</div>
						<div class="section">リース期間1年未満：</div>
						<div class="section">再リース契約：</div>
						<div class="section">中途解約物件：</div>
					</div>
					<div class="exttaction-condition-select">
						<div class="section">
							<label><input type="radio" class="radiobutton" value="0" name="gtjSgkKeiJgiFlg" tabindex="13"<%= userBean.getGtjSgkKeiJgiFlg().equals("0") ? " checked" : "" %>/>除く</label>
							<label><input type="radio" class="radiobutton" value="1" name="gtjSgkKeiJgiFlg" tabindex="13"<%= userBean.getGtjSgkKeiJgiFlg().equals("1") ? " checked" : "" %>/>除かない</label>
						</div>
						<div class="section">
							<label><input type="radio" class="radiobutton" value="0" name="gtjSrtKeiJgiFlg" tabindex="13"<%= userBean.getGtjSrtKeiJgiFlg().equals("0") ? " checked" : "" %>/>除く</label>
							<label><input type="radio" class="radiobutton" value="1" name="gtjSrtKeiJgiFlg" tabindex="13"<%= userBean.getGtjSrtKeiJgiFlg().equals("1") ? " checked" : "" %>/>除かない</label>
						</div>
						<div class="section">
							<label><input type="radio" class="radiobutton" value="0" name="gtjRlsKeiJgiFlg" tabindex="13"<%= userBean.getGtjRlsKeiJgiFlg().equals("0") ? " checked" : "" %>/>除く</label>
							<label><input type="radio" class="radiobutton" value="1" name="gtjRlsKeiJgiFlg" tabindex="13"<%= userBean.getGtjRlsKeiJgiFlg().equals("1") ? " checked" : "" %>/>除かない</label>
						</div>
						<div class="section">
							<label><input type="radio" class="radiobutton" value="0" name="gtjCytKaiJgiFlg" tabindex="13"<%= userBean.getGtjCytKaiJgiFlg().equals("0") ? " checked" : "" %>/>除く</label>
							<label><input type="radio" class="radiobutton" value="1" name="gtjCytKaiJgiFlg" tabindex="13"<%= userBean.getGtjCytKaiJgiFlg().equals("1") ? " checked" : "" %>/>除かない</label>
						</div>
					</div>
				</div>
			</div>
			<table class="registration-info-table">
				<tr>
					<td class="section-title-blue"></td>
					<td class="section-title-blue">旧リース会計基準</td>
					<td class="section-title-blue">新リース会計基準</td>
				</tr>
				<tr>
					<td class="section-title-blue">所有権移転ファイナンスリースにおける減価償却方法</td>
					<td class="section-ivory"></td>
					<td class="section-ivory"></td>
				</tr>
				<tr>
					<td class="section-blue">有形資産</td>
					<td class="section-ivory">
						<select class="pulldwon-five" name="oldItenYukeiSkkHohoCd" tabindex="15">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getOldItenYukeiSkkHohoCd())%>
						</select>
					</td>
					<td class="section-ivory">
						<select class="pulldwon-five" name="newItenYukeiSkkHohoCd" tabindex="16">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getNewItenYukeiSkkHohoCd())%>
						</select>
					</td>
				</tr>
				<tr>
					<td class="section-blue">無形資産</td>
					<td class="section-ivory">
						<select class="pulldwon-five" name="oldItenMukeiSkkHohoCd" tabindex="17">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getOldItenMukeiSkkHohoCd())%>
						</select>
					</td>
					<td class="section-ivory">
						<select class="pulldwon-five" name="newItenMukeiSkkHohoCd" tabindex="18">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getNewItenMukeiSkkHohoCd())%>
						</select>
					</td>
				</tr>
				<tr>
					<td class="section-title-blue">所有権移転外ファイナンスリースにおける減価償却方法</td>
					<td class="section-ivory"></td>
					<td class="section-ivory"></td>
				</tr>
				<tr>
					<td class="section-blue">有形資産</td>
					<td class="section-ivory">
						<select class="pulldwon-five" name="oldItengiYukeiSkkHohoCd" tabindex="19">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getOldItengiYukeiSkkHohoCd())%>
						</select>
					</td>
					<td class="section-ivory">
						<select class="pulldwon-five" name="newItengiYukeiSkkHohoCd" tabindex="20">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getNewItengiYukeiSkkHohoCd())%>
						</select>
					</td>
				</tr>
				<tr>
					<td class="section-blue">無形資産</td>
					<td class="section-ivory">
						<select class="pulldwon-five" name="oldItengiMukeiSkkHohoCd" tabindex="21">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getOldItengiMukeiSkkHohoCd())%>
						</select>
					</td>
					<td class="section-ivory">
						<select class="pulldwon-five" name="newItengiMukeiSkkHohoCd" tabindex="22">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getNewItengiMukeiSkkHohoCd())%>
						</select>
					</td>
				</tr>
				<tr>
					<td class="section-title-blue">利息計算方法</td>
					<td class="section-ivory"></td>
					<td class="section-ivory"></td>
				</tr>
				<tr>
					<td class="section-blue">利息相当額配分方法</td>
					<td class="section-ivory">
						<select class="pulldown-four" name="oldRskClcHohoCd" tabindex="23">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getOldRskClcHohoCd())%>
						</select>
					</td>
					<td class="section-ivory">
						<select class="pulldown-four" name="newRskClcHohoCd" tabindex="24">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getNewRskClcHohoCd())%>
						</select>
					</td>
				</tr>
				<tr>
					<td class="section-blue">賦金展開方法</td>
					<td class="section-ivory">
						<select class="pulldown-four" name="oldFknTnkiHohoCd" tabindex="25">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getOldFknTnkiHohoCd())%>
						</select>
					</td>
					<td class="section-ivory">
						<select class="pulldown-four" name="newFknTnkiHohoCd" tabindex="26">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getNewFknTnkiHohoCd())%>
						</select>
					</td>
				</tr>
				<tr>
					<td class="section-title-blue">重要性判断基準</td>
					<td class="section-ivory"></td>
					<td class="section-ivory"></td>
				</tr>
				<tr>
					<td class="section-blue">維持管理費重要性区分</td>
					<td class="section-ivory">
						<select class="pulldown-three" name="oldIjiKnriHyoJyoKbn" tabindex="27">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getOldIjiKnriHyoJyoKbn())%>
						</select>
					</td>
					<td class="section-ivory">
						<select class="pulldown-three" name="newIjiKnriHyoJyoKbn" tabindex="28">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getNewIjiKnriHyoJyoKbn())%>
						</select>
					</td>
				</tr>
				<tr>
					<td class="section-blue">役務提供費重要性区分</td>
					<td class="section-ivory">
						<select class="pulldown-three" name="oldEkmTeikHyoJyoKbn" tabindex="29">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getOldEkmTeikHyoJyoKbn())%>
						</select>
					</td>
					<td class="section-ivory">
						<select class="pulldown-three" name="newEkmTeikHyoJyoKbn" tabindex="30">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getNewEkmTeikHyoJyoKbn())%>
						</select>
					</td>
				</tr>
				<tr>
					<td class="section-title-blue">端数調整方法</td>
					<td class="section-ivory"></td>
					<td class="section-ivory"></td>
				</tr>
				<tr>
					<td class="section-blue">減価償却</td>
					<td class="section-ivory">
						<select class="pulldown-three" name="oldGnkskHasuChseCd" tabindex="31">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getOldGnkskHasuChseCd())%>
						</select>
					</td>
					<td class="section-ivory">
						<select class="pulldown-three" name="newGnkskHasuChseCd" tabindex="32">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getNewGnkskHasuChseCd())%>
						</select>
					</td>
				</tr>
				<tr>
					<td class="section-blue">賦金展開</td>
					<td class="section-ivory">
						<select class="pulldown-three" name="oldFknTnkiHasuChseCd" tabindex="33">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getOldFknTnkiHasuChseCd())%>
						</select>
					</td>
					<td class="section-ivory">
						<select class="pulldown-three" name="newFknTnkiHasuChseCd" tabindex="34">
							<%= LACSUserHTMLUtil.outHTMLCombo(userBean.getNewFknTnkiHasuChseCd())%>
						</select>
					</td>
				</tr>
				<tr>
					<td class="section-title-blue">購入通知有無</td>
					<td class="section-ivory">
						<label><input type="radio" class="radiobutton" value="0" name="oldKnuAmtTutiUmFlg" tabindex="35"<%= userBean.getOldKnuAmtTutiUmFlg().equals("0") ? " checked" : "" %>/>通知</label>
						<label><input type="radio" class="radiobutton" value="1" name="oldKnuAmtTutiUmFlg" tabindex="35"<%= userBean.getOldKnuAmtTutiUmFlg().equals("1") ? " checked" : "" %>/>非通知</label>
					</td>
					<td class="section-ivory">
						<label><input type="radio" class="radiobutton" value="0" name="newKnuAmtTutiUmFlg" tabindex="36"<%= userBean.getNewKnuAmtTutiUmFlg().equals("0") ? " checked" : "" %>/>通知</label>
						<label><input type="radio" class="radiobutton" value="1" name="newKnuAmtTutiUmFlg" tabindex="36"<%= userBean.getNewKnuAmtTutiUmFlg().equals("1") ? " checked" : "" %>/>非通知</label>
					</td>
				</tr>
			</table>							
			<div class="new-disclosure-recipient-info-title">表示用リース会社情報</div>
			<div class="new-disclosure-recipient-info-block">
				<div class="new-disclosure-recipient-info-display">
					<div class="section">リース会社：</div>
					<div class="section">住所：</div>
				</div>
				<div class="new-disclosure-recipient-info-input">
					<div class="section">
						<input type="text" class="textbox-seven" maxlength="25" size="65" value="<%= LACSUserHTMLUtil.encode(userBean.getPdfCompanyName()) %>" name="pdfCompanyName" tabindex="37"/>
					</div>
					<div class="section">
						〒 <input type="text" class="textbox-two" maxlength="3" size="4" value="<%= LACSUserHTMLUtil.encode(userBean.getPdfCompanyZip1()) %>" name="pdfCompanyZip1" tabindex="39"/>
						<span class="tilde">-</span> 
						<input type="text" class="textbox-three" maxlength="4" size="5" value="<%= LACSUserHTMLUtil.encode(userBean.getPdfCompanyZip2()) %>" name="pdfCompanyZip2" tabindex="40"/>
					</div>
					<div class="section">
						<input type="text" class="textbox-eleven" maxlength="30" size="76" value="<%= LACSUserHTMLUtil.encode(userBean.getPdfCompanyAddress1()) %>" name="pdfCompanyAddress1" tabindex="41"/>
					</div>
					<div class="section">
						<input type="text" class="textbox-eleven" maxlength="30" size="76" value="<%= LACSUserHTMLUtil.encode(userBean.getPdfCompanyAddress2()) %>" name="pdfCompanyAddress2" tabindex="42"/>
					</div>
				</div>
				<div class="new-disclosure-recipient-section">
					電話番号：
					<input type="text" class="textbox-seven" maxlength="13" size="17" value="<%= LACSUserHTMLUtil.encode(userBean.getPdfCompanyTel()) %>" name="pdfCompanyTel" tabindex="38"/>
				</div>
			</div>
			<div class="new-disclosure-recipient-info-title">使用可能機能</div>
			<div class="new-disclosure-recipient-info-block">
				<div class="addable-screen">
					<p>画面</p>
					<div class="section">
						<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"G0000001",43,"支払推移表") %></label>
					</div>
					<div class="section">
						<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"G0000002",44,"仕訳照会") %></label>
					</div>
					<div class="section">
						<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"G0000003",45,"契約検索") %></label>
					</div>
					<div class="section">
						<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"G0000004",46,"物件検索") %></label>
					</div>
					<div class="section">
						<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"G0000005",47,"注記帳票出力") %></label>
					</div>
					<div class="section">
						<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"G0000006",48,"月次帳票出力") %></label>
					</div>
					<div class="section">
						<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"G0000007",49,"受払合計表") %></label>
					</div>
					<div class="section">
						<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"G0000008",50,"契約詳細照会") %></label>
					</div>
				</div>
				<div class="csv-leader">
					<p>帳票／ＣＳＶ</p>
					<div class="input-group-row">
						<div class="csv-leader-input-group">
							注記帳票出力
							<div class="section">
								<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000005",51,"リース料支払スケジュール表（物件単位）") %></label>
							</div>
							<div class="section">
								<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000004",52,"注記書類作成基準書") %></label>
							</div>
							<div class="section">
								<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000001",53,"リース会計注記合計表") %></label>
							</div>
							<div class="section">
								<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000007",54,"未経過リース料期末残高別表") %></label>
							</div>
							<div class="section">
								<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000002",54,"リース会計資料（減価償却費）") %></label>
							</div>
							<div class="section">
								<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000003",55,"リース会計資料（支払リース料等）") %></label>
							</div>
							<div class="section">
								<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000032",56,"期日別予定表(合計表)") %></label>
							</div>
							<div class="section">
								<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000033",56,"期日別予定表(債務)") %></label>
							</div>
							<div class="section">
								<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000034",56,"期日別予定表(資産)") %></label>
							</div>
							<div class="section">
								<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000006",56,"注記源泉情報") %></label>
							</div>
						</div>
						<div class="csv-leader-input-group">
							月次帳票出力
							<div class="section">
								<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000011",57,"リース会計基準明細書") %></label>
							</div>
							<div class="section">
								<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000012",58,"除却資産一覧") %></label>
							</div>
							<div class="section">
								<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000013",59,"仕訳合計表") %></label>
							</div>
							<div class="section">
								<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000016",60,"固定資産台帳（リース資産）") %></label>
							</div>
							<div class="section">
								<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000015",61,"消費税明細表") %></label>
							</div>
							<div class="section">
								<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000014",62,"仕訳源泉情報") %></label>
							</div>
						</div>
						<div class="csv-leader-input-group">
							<div class="section">
								受払合計表
								<div class="section">
									<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000021",63,"受払合計表") %></label>
								</div>
								<div class="section">
									<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000022",64,"リース資産受払明細表") %></label>
								</div>
								<div class="section">
									<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000023",65,"リース料受払明細表") %></label>
								</div>
								<div class="section">
									<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000024",66,"費用受払明細表") %></label>
								</div>
							</div>
							<div class="section">
								契約詳細照会
								<div class="section">
									<label><%= LACSUserHTMLUtil.outHTMLDisplayControl(userBean.getDispControl(),"P0000031",67,"契約詳細情報") %></label>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<p class="create-button">
				<input type="button" class="button" value=" 登  録 " onclick="checkKnuAmtTutiUmFlg();kakuninRegist('regist.user')" name="regist" tabindex="98"/>
				<input type="button" class="button" value=" 戻　る " onclick="post('back.user')" name="return" tabindex="99"/>
			</p>		
		</div>
		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>
