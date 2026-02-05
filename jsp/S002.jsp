<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.shiwake.html.*"
	import="jp.co.pro_app.lacs.common.define.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="shiwakeBean" scope="session" class="jp.co.pro_app.lacs.affairs.shiwake.bean.LACSShiwakeBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>仕訳照会</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240823 -->
	<form name="frm" class="background">
		<input type="hidden" name="nextPage" value=""/>
		<div class="common-header">
<%= LACSShiwakeHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= shiwakeBean.getMessage() %>
			<div class="function-title">検索条件</div>
<% if(shiwakeBean.getPageFrom() != 0){ %>
	<% if(shiwakeBean.getPageFrom() == 1 || shiwakeBean.getPageFrom() == 2){ %>
			<div class="section-number">
				契約番号：
				<input type="hidden" value="<%= LACSShiwakeHTMLUtil.encode(shiwakeBean.getKeiyakuNo()) %>" name="keiyakuNo" />
				<input type="hidden" value="<%= LACSShiwakeHTMLUtil.encode(shiwakeBean.getHyoujiKeiyakuNo()) %>" name="hyoujiKeiyakuNo" /><%= LACSShiwakeHTMLUtil.encode(shiwakeBean.getHyoujiKeiyakuNo()) %>
			</div>								
	<% } %>
									
	<% if(shiwakeBean.getPageFrom() == 2){ %>
			<div class="section-number">
				物件番号：
				<input type="hidden" value="<%= LACSShiwakeHTMLUtil.encode(shiwakeBean.getBukkenNo()) %>" name="bukkenNo" />
				<input type="hidden" value="<%= LACSShiwakeHTMLUtil.encode(shiwakeBean.getBukkenEdaNo()) %>" name="bukkenEdaNo" /><%= LACSShiwakeHTMLUtil.encode(shiwakeBean.getBukkenNo()) %><%= (shiwakeBean.getBukkenEdaNo() == null || shiwakeBean.getBukkenEdaNo().trim().length() == 0 ) ? "" : "-" %><%= LACSShiwakeHTMLUtil.encode(shiwakeBean.getBukkenEdaNo()) %>
			</div>
	<% }else{ %>
	<% } %>
<% } %>
			<div class="section-number">
<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY || commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER){ %>
	<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY && shiwakeBean.getPageFrom() == 0){ %>
				<span class="font-red">*</span>
	<% } %>
				開示先：
<% }else{ %>
				リース会社：
<% } %>
										
<% if(shiwakeBean.getPageFrom() != 0  || commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER){ %>
				<input type="hidden" value="<%= LACSShiwakeHTMLUtil.encode(shiwakeBean.getLeasCompany().getValue()) %>" name="leasCompany" /><%= LACSShiwakeHTMLUtil.encode(shiwakeBean.getLeasCompany().getName()) %>
<% } else{ %>
				<input type="text" class="textbox-nine" name="leasCompanyNm" value="<%= LACSShiwakeHTMLUtil.encode(shiwakeBean.getLeasCompanyNm()) %>" />
				<input type="button" class="button" value="絞　込" onclick="post('filter.shiwake')" />
				<select class="pulldown-six" name="leasCompany">
<%= LACSShiwakeHTMLUtil.outHTMLCombo(shiwakeBean.getLeasCompany())%>
				</select>
<% } %>
			</div>
<% if(shiwakeBean.getPageFrom() == 0){ %>
			<div class="input-group-row">
				<div class="section">リース取引分類：
	<% if(shiwakeBean.getPageFrom() == 0){ %>
					<select class="pulldown-five" name="tradeHanteiKekka">
<%= LACSShiwakeHTMLUtil.outHTMLCombo(shiwakeBean.getTradeHanteiKekka())%>
					</select>
	<% } else{ %>
					<input type="hidden" value="<%= LACSShiwakeHTMLUtil.encode(shiwakeBean.getTradeHanteiKekka().getValue()) %>" name="tradeHanteiKekka" /><%= LACSShiwakeHTMLUtil.encode(shiwakeBean.getTradeHanteiKekka().getName()) %>
	<% } %>
				</div>
				<div class="section">期間：
					<%= LACSShiwakeHTMLUtil.outHTMLDateInputField(commonBean, shiwakeBean.getTermFrom()) %>
					<span class="tilde">～</span>
					<%= LACSShiwakeHTMLUtil.outHTMLDateInputField(commonBean, shiwakeBean.getTermTo()) %>
				</div>
			</div>
<% } %>
			<p class="command-button">
<% switch(shiwakeBean.getPageFrom()){
	case 0: %>
				<input type="button" class="button" value=" 検  索 " onclick="post('search.shiwake')" />
		<% break;
	case 1: %>
				<input type="button" class="button" value=" 戻  る " onclick="post('keiyaku.shiwake')" />
		<% break;
	case 2: %>
				<input type="button" class="button" value=" 戻  る " onclick="post('bukken.shiwake')" />
		<% break;
} %>
			</p>
<% if(shiwakeBean.isShowList()){ %>
			<hr />
			<div class="function-title">	
				検索結果 (<%= shiwakeBean.getDataMax() %>件(単位：年月))
			</div>
			<div class="page-position">
<%= LACSShiwakeHTMLUtil.outHTMLPageChange(shiwakeBean) %>
			</div>
			<div class="search-list">				
<%= LACSShiwakeHTMLUtil.outHTMLList(shiwakeBean) %>
			</div>
			<div class="page-position">
<%= LACSShiwakeHTMLUtil.outHTMLPageChange(shiwakeBean) %>
			</div>
<%	}%>
		</div>

		<div class="footer">	
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>