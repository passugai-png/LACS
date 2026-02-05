<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.shiharai.html.*"
	import="jp.co.pro_app.lacs.common.define.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="shiharaiBean" scope="session" class="jp.co.pro_app.lacs.affairs.shiharai.bean.LACSShiharaiBean" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>支払推移表</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240823 -->
	<form name="frm" class="background">
		<input type="hidden" name="nextPage" value=""/>
		<div class="common-header">
<%= LACSShiharaiHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= shiharaiBean.getMessage() %>
			<div class="function-title">検索条件</div>
<% if(shiharaiBean.getPageFrom() != 0){ %>						
	<% if(shiharaiBean.getPageFrom() == 1 || shiharaiBean.getPageFrom() == 2){ %>
			<div class="section-number">
				契約番号：
				<input type="hidden" value="<%= LACSShiharaiHTMLUtil.encode(shiharaiBean.getKeiyakuNo()) %>" name="keiyakuNo" />
				<input type="hidden" value="<%= LACSShiharaiHTMLUtil.encode(shiharaiBean.getHyoujiKeiyakuNo()) %>" name="hyoujiKeiyakuNo" /><%= LACSShiharaiHTMLUtil.encode(shiharaiBean.getHyoujiKeiyakuNo()) %>
			</div>
	<% } %>

	<% if(shiharaiBean.getPageFrom() == 2){ %>
			<div class="section-number">
				物件番号：
				<input type="hidden" value="<%= LACSShiharaiHTMLUtil.encode(shiharaiBean.getBukkenNo()) %>" name="bukkenNo" />
				<input type="hidden" value="<%= LACSShiharaiHTMLUtil.encode(shiharaiBean.getBukkenEdaNo()) %>" name="bukkenEdaNo" /><%= LACSShiharaiHTMLUtil.encode(shiharaiBean.getBukkenNo()) %><%= (shiharaiBean.getBukkenEdaNo() == null || shiharaiBean.getBukkenEdaNo().trim().length() == 0 ) ? "" : "-" %><%= LACSShiharaiHTMLUtil.encode(shiharaiBean.getBukkenEdaNo()) %>
			</div>
	<% }else{ %>
	<% } %>
<% } %>

			<div class="section-number">
<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY || commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER){ %>
	<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY && shiharaiBean.getPageFrom() == 0){ %>
				<span class="font-red">*</span>
	<% } %>
				開示先：
<% }else{ %>
				リース会社：
<% } %>
<% if(shiharaiBean.getPageFrom() != 0  || commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER){ %>
				<input type="hidden" value="<%= LACSShiharaiHTMLUtil.encode(shiharaiBean.getLeasCompany().getValue()) %>" name="leasCompany" /><%= LACSShiharaiHTMLUtil.encode(shiharaiBean.getLeasCompany().getName()) %>
<% } else{ %>
				<input type = "text" class="textbox-nine" name ="leasCompanyNm" value ="<%= LACSShiharaiHTMLUtil.encode(shiharaiBean.getLeasCompanyNm()) %>" />
				<input type = "button" class ="button" value="絞　込" onclick="post('filter.shiharai')" />
				<select class="pulldown-six" name="leasCompany">
<%= LACSShiharaiHTMLUtil.outHTMLCombo(shiharaiBean.getLeasCompany())%>
				</select>
<% } %>
			</div>
<% if(shiharaiBean.getPageFrom() == 0){ %>
			<div class="input-group-row">		
				<div class="section">リース取引分類：
	<% if(shiharaiBean.getPageFrom() == 0){ %>
					<select class="pulldown-five" name="tradeHanteiKekka">
<%= LACSShiharaiHTMLUtil.outHTMLCombo(shiharaiBean.getTradeHanteiKekka())%>
					</select>
	<% } else{ %>
					<input type="hidden" value="<%= LACSShiharaiHTMLUtil.encode(shiharaiBean.getTradeHanteiKekka().getValue()) %>" name="tradeHanteiKekka" /><%= LACSShiharaiHTMLUtil.encode(shiharaiBean.getTradeHanteiKekka().getName()) %>
	<% } %>
				</div>
				<div class="section">
					期間：
					<%= LACSShiharaiHTMLUtil.outHTMLDateInputField(commonBean, shiharaiBean.getTermFrom()) %>
					<span class="tilde">～</span>
					<%= LACSShiharaiHTMLUtil.outHTMLDateInputField(commonBean, shiharaiBean.getTermTo()) %>
				</div>
			</div>						
<% } %>
			<p class="command-button">
<% switch(shiharaiBean.getPageFrom()){ 
	case 0: %>
				<input type="button" class="button" value=" 検  索 " onclick="post('search.shiharai')" />
		<% break;
	case 1: %>
				<input type="button" class="button" value=" 戻  る " onclick="post('keiyaku.shiharai')" />
		<% break;
	case 2: %>
				<input type="button" class="button" value=" 戻  る " onclick="post('bukken.shiharai')" />
		<% break;
} %>
			</p>
				
<% if(shiharaiBean.isShowList()){ %>
			<hr />
			<div class="function-title">	
				検索結果 (<%= shiharaiBean.getDataMax() %>件)
			</div>
			<div class="page-position">
<%= LACSShiharaiHTMLUtil.outHTMLPageChange(shiharaiBean) %>
			</div>
			<div class="search-list">
<%= LACSShiharaiHTMLUtil.outHTMLList(shiharaiBean) %>
			</div>
			<div class="page-position">
<%= LACSShiharaiHTMLUtil.outHTMLPageChange(shiharaiBean) %>
			</div>
<%	}%>
		</div>

		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>
