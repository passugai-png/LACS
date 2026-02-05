<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.top.html.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>処理メニュー</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
	<script language="javascript" src="js/report.js"></script>
</head>
<body onload="javascript:prepared();">
	<!-- @autor tatsumi @version 20240827 -->
	<form name="frm" class="background">
		<div class="common-header">
<%= LACSTopHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="transition-button-column">
			<p class="newest-version">
				Ｖｅｒ． <%= commonBean.getVersion() %>
			</p>
			<div class="transition-button">
				<%= LACSTopHTMLUtil.outHTMLButton(commonBean) %>
			</div>
		</div>
		<div class="news-column">
			<div class="input-group-row">
				<div class="news-column-title">お知らせ</div>
				<div class="news-column-button">
					<% if(commonBean.getInfo().size() > 0) { %><%= LACSTopHTMLUtil.outHTMLTxtPath(commonBean) %><% } %>
					<input type="hidden" name="csvName"/>
				</div>
			</div>
			<hr />
			<div class="news-column-display">
<%= LACSTopHTMLUtil.outHTMLInformation(commonBean) %>
			</div>
		</div>
		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>