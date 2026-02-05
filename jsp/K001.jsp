<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.keiyaku.html.*"
	import="jp.co.pro_app.lacs.common.define.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="keiyakuBean" scope="session" class="jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>契約検索</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240827 -->
	<form name="frm" class="background">
		<input type="hidden" name="nextPage" value=""/>
		<input type="hidden" name="selKeiyakuNo"/>
		<input type="hidden" name="selHyoujiKeiyakuNo"/>
		<input type="hidden" name="selLeasCompany"/>
		<input type="hidden" name="selTradeHanteiKekka"/>
		<input type="hidden" name="selPageFrom"/>
		<div class="common-header">
<%= LACSKeiyakuHTMLUtil.outHTMLHeader(commonBean) %>
		</div>		
		<div class="main">
<%= keiyakuBean.getMessage() %>
			<div class="function-title">検索条件</div>
			<div class="disclosure-recipient-contract-search">
<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY || commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER){ %>
				開示先：
<% }else{ %>
				リース会社：
<% } %>
					
<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER){ %>
				<input type="hidden" value="<%= LACSKeiyakuHTMLUtil.encode(keiyakuBean.getLeasCompany().getValue()) %>" name="leasCompany" /><%= LACSKeiyakuHTMLUtil.encode(keiyakuBean.getLeasCompany().getName()) %>
<% } else{ %>
				<input type="text" class="textbox-nine" name="leasCompanyNm" value="<%= LACSKeiyakuHTMLUtil.encode(keiyakuBean.getLeasCompanyNm()) %>" />
				<input type="button" class="button" value="絞　込" onclick="post('filter.keiyaku')" />
				<select class="pulldown-six" name="leasCompany">
<%= LACSKeiyakuHTMLUtil.outHTMLCombo(keiyakuBean.getLeasCompany())%>
				</select>
<% } %>
			</div>
			<div class="input-group-row">
				<div class="search-contract-row">
				<div class="section">
					<div class="section-right">契約番号：</div>
					<div class="section-right">リース取引分類：</div>
					<div class="section-right">代表物件名：</div>
					<div class="contract-amount">契約金額：</div>
				</div>
				<div class="section">
					<div class="section-inputbox">	
						<input type="text" class="textbox-seven" value="<%= LACSKeiyakuHTMLUtil.encode(keiyakuBean.getKeiyakuNo()) %>" maxlength="20" size="" name="keiyakuNo"/>
					</div>			
					<div class="section-inputbox">
						<select class="pulldown-five" name="tradeHanteiKekka">
<%= LACSKeiyakuHTMLUtil.outHTMLCombo(keiyakuBean.getTradeHanteiKekka())%>
						</select>
					</div>
					<div class="section-inputbox">
						<input type="text" class="textbox-eleven" value="<%= LACSKeiyakuHTMLUtil.encode(keiyakuBean.getDaihyoBukkenName()) %>" maxlength="25" size="" name="daihyoBukkenName"/>
					</div>
					<div class="section">
						<label><input type="radio" class="radiobutton" name="kenPatn" value="1" <%= keiyakuBean.getKenPatn().equals("1") ? "checked" : "" %> />前方一致</label>
						<label><input type="radio" class="radiobutton" name="kenPatn" value="2" <%= keiyakuBean.getKenPatn().equals("2") ? "checked" : "" %>/>部分一致</label>
						<label><input type="radio" class="radiobutton" name="kenPatn" value="3" <%= keiyakuBean.getKenPatn().equals("3") ? "checked" : "" %>/>完全一致</label>
					</div>
					<div class="section-inputbox">
						<input type="text" class="textbox-four" value="<%= LACSKeiyakuHTMLUtil.encode(keiyakuBean.getKeiyakuAmt()) %>" maxlength="13" size="" name="keiyakuAmt" />
						円以下を除く
					</div>
				</div>
				</div>
				<div class="search-contract-row">
				<div class="section">
					<div class="section-right">検収月：</div>
					<div class="section-right">満了月：</div>
					<div class="section-right">中途解約月：</div>
					<div class="section-right">再リース：</div>
					<div class="section-right">リース期間：</div>
				</div>
				<div class="section-ratio-one">
					<div class="section">
						<%= LACSKeiyakuHTMLUtil.outHTMLDateInputField(commonBean, keiyakuBean.getKenshuFrom()) %>
						<span class="tilde">～</span>
						<%= LACSKeiyakuHTMLUtil.outHTMLDateInputField(commonBean, keiyakuBean.getKenshuTo()) %>
					</div>
					<div class="section">
						<%= LACSKeiyakuHTMLUtil.outHTMLDateInputField(commonBean, keiyakuBean.getManryoFrom()) %>
						<span class="tilde">～</span>
						<%= LACSKeiyakuHTMLUtil.outHTMLDateInputField(commonBean, keiyakuBean.getManryoTo()) %>
					</div>
					<div class="section">
						<%= LACSKeiyakuHTMLUtil.outHTMLDateInputField(commonBean, keiyakuBean.getKaiyakuFrom()) %>
						<span class="tilde">～</span>
						<%= LACSKeiyakuHTMLUtil.outHTMLDateInputField(commonBean, keiyakuBean.getKaiyakuTo()) %>
					</div>
					<div class="section">
						<label><input type="radio" class="radiobutton" name="keiyakuRls" value="1" <%= keiyakuBean.getKeiyakuRls().equals("1") ? "checked" : "" %> />含む</label>
						<label><input type="radio" class="radiobutton" name="keiyakuRls" value="2" <%= keiyakuBean.getKeiyakuRls().equals("2") ? "checked" : "" %> />含まない</label>
						<label><input type="radio" class="radiobutton" name="keiyakuRls" value="3" <%= keiyakuBean.getKeiyakuRls().equals("3") ? "checked" : "" %> />再リースのみ</label>
					</div>
					<div class="section">
						<input type="text" class="textbox-four" value="<%= LACSKeiyakuHTMLUtil.encode(keiyakuBean.getKeiyakuTerm()) %>" maxlength="3" size="" name="keiyakuTerm" />
						ヶ月以下を除く
					</div>
				</div>
				</div>
			</div>
			<p class="create-button">
				<input type="button" class="button" value=" 検  索 " onclick="post('search.keiyaku')" />
			</p>		

<% if(keiyakuBean.isShowList()){ %>
			<hr />				
			<div class="function-title">
				検索結果 (<%= keiyakuBean.getDataMax() %>件)
			</div>
			<div class="page-position">
<%= LACSKeiyakuHTMLUtil.outHTMLPageChange(keiyakuBean) %>
			</div>
			<div class="search-list">
<%= LACSKeiyakuHTMLUtil.outHTMLList(keiyakuBean, commonBean) %>
			</div>
			<div class="page-position">
<%= LACSKeiyakuHTMLUtil.outHTMLPageChange(keiyakuBean) %>
			</div>
<%	}%>
		</div>

		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>