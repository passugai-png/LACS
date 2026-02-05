<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.ukebarai.html.*"
	import="jp.co.pro_app.lacs.common.define.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="ukebaraiBean" scope="session" class="jp.co.pro_app.lacs.affairs.ukebarai.bean.LACSUkebaraiBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>受払合計表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<link href="css/style.css" type="text/css" rel="stylesheet"/>
		<script language="javascript" src="js/script.js"></script>
		<script language="javascript" src="js/report.js"></script>
</head>
<body onload="javascript:prepared();setFocusU(<%= ukebaraiBean.getNextFocus() %>);onloadFunction()">
	<!-- @autor tatsumi @version 20240823 -->
	<div id="waitScreen" class="screen">
		<table class="screen-wordbox">
			<tr>
				<td class="screen-wordbox-size"><span class="screen-word">しばらくお待ちください。</span></td>
			</tr>
		</table>
	</div>
	<form name="frm" class="background">
 		<input type="hidden" name="nextFocus"/>
 		<div class="common-header">
<%= LACSUkebaraiHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= ukebaraiBean.getMessage() %>
			<div class="function-title">検索条件</div>
			<div class="disclosure-recipient">					
<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY || commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER){ %>
	<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) { %>
				<span class="font-red">* </span>
	<% } %>
				開示先：
<% } else{ %>
				リース会社：
<% } %>
				
<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) { %>
				<input type="text" class="textbox-nine" name="leasCompanyNm" value="<%= LACSUkebaraiHTMLUtil.encode(ukebaraiBean.getLeasCompanyNm()) %>" />
				<input type="button" class="button" value="絞　込" onclick="post('filter.ukebarai')" />    
				<select class="pulldown-six" name="leasCompany" onchange = "post('userchange.ukebarai')">
<%= LACSUkebaraiHTMLUtil.outHTMLCombo(ukebaraiBean.getLeasCompany())%>
				</select>
<% } else { %>
				<input type="hidden" value="<%= LACSUkebaraiHTMLUtil.encode(ukebaraiBean.getLeasCompany().getValue()) %>" name="leasCompany" /><%= LACSUkebaraiHTMLUtil.encode(ukebaraiBean.getLeasCompany().getName()) %>
<% } %>
			</div>
			<div class="section-period">
				<span class="font-red">* </span>
				期間：
				<%= LACSUkebaraiHTMLUtil.outHTMLDateInputFieldYMD(commonBean, ukebaraiBean.getTermFrom()) %>
				<span class="tilde">～</span>
				<input type="text" class="textbox-four" name="tsukiSu" maxlength="2" value="<%= LACSUkebaraiHTMLUtil.encode(ukebaraiBean.getTsukiSu()) %>" onchange="focusNextU(this)"/>
				ヶ月
				（ <%= LACSUkebaraiHTMLUtil.outHTMLDateInputFieldYMD(commonBean, ukebaraiBean.getTermTo()) %>）
			</div>
			<p class="command-button">
				<input name="searchButton" type="button" class="button" value=" 検  索 " onclick="post('search.ukebarai')" />
			</p>
<% if (ukebaraiBean.isShowList()) { %>
			<hr />
<%= LACSUkebaraiHTMLUtil.outHTMLList(ukebaraiBean) %>
			<div class="receipt-check-row">
<% if (commonBean.getDispControl().isAvailable("P0000021")) { %>
				<div class="receipt-check-section">
					<label>
						<input type="checkbox" class="checkbox" name="chkGokei" value="1" <%= ukebaraiBean.getGokei().getCheckOutput() == 1 ? "checked" : "" %>/>
						<%= LACSUkebaraiHTMLUtil.outHTMLPdfPath(ukebaraiBean, ukebaraiBean.getGokei(), "受払合計表", "gokei") %>
					</label>
				</div>	
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000022")) { %>
				<div class="receipt-check-section">
					<label>
						<input type="checkbox" class="checkbox" name="chkSisan" value="1" <%= ukebaraiBean.getSisan().getCheckOutput() == 1 ? "checked" : "" %>/>
						<%= LACSUkebaraiHTMLUtil.outHTMLPdfPath(ukebaraiBean, ukebaraiBean.getSisan(), "リース資産受払明細表", "sisan") %>
					</label>
				</div> 
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000023")) { %>
				<div class="receipt-check-section">
					<label>			
						<input type="checkbox" class="checkbox" name="chkLease" value="1" <%= ukebaraiBean.getLease().getCheckOutput() == 1 ? "checked" : "" %>/>
						<%= LACSUkebaraiHTMLUtil.outHTMLPdfPath(ukebaraiBean, ukebaraiBean.getLease(), "リース料受払明細表", "lease") %>
					</label>
				</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000024")) { %>
				<div class="receipt-check-section">				
					<label>
						<input type="checkbox" class="checkbox" name="chkHiyo" value="1" <%= ukebaraiBean.getHiyo().getCheckOutput() == 1 ? "checked" : "" %>/>
						<%= LACSUkebaraiHTMLUtil.outHTMLPdfPath(ukebaraiBean, ukebaraiBean.getHiyo(), "費用受払明細表", "hiyo") %>
					</label>
				</div>
<% } %>
			</div>
			<p class="command-button">
				<input type="hidden" name="hidLeasCompany" value="<%= ukebaraiBean.getLeasCompany().getValue() %>"/>
				<input type="hidden" name="hidTermFromData" value="<%= ukebaraiBean.getTermFrom().getYYYYMMDD() %>"/>
				<input type="hidden" name="hidTsukiSu" value="<%= ukebaraiBean.getTsukiSu() %>"/>
<%= LACSUkebaraiHTMLUtil.outHTMLButton(ukebaraiBean, commonBean) %>
				<input type="hidden" name="csvName"/>
			</p>
<% } %>
		</div>

		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>