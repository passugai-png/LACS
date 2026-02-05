<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.login.html.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="loginBean" scope="session" class="jp.co.pro_app.lacs.affairs.login.bean.LACSLoginBean" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>ログイン画面</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240827 -->
	<form name="frm" class="background">
		<div class="no-transition-common-header">
			<img src="img/logo.gif" class="img-logo"/>
			<%= LACSLoginHTMLUtil.outHTMLCompanyLogo(loginBean) %>
		</div>
		<div class="main">
			<div class="top-box">
				<div class="toppage-section">
					<%= loginBean.getMessage() %>
				</div>
				<div class="toppage-section">
					ユーザーID：
					<input type="text" class="textbox-seven" name="userId" value="<%= LACSLoginHTMLUtil.encode(loginBean.getUserId()) %>"/>
				</div>
				<div class="toppage-section">
					パスワード：
					<input type="password" class="textbox-seven" name="identifier"/>
				</div>
				<p class="toppage-section">
					<input type="button" class="button" name="login" value="ログイン" onclick="post('next.login')" />
					<input type="button" class="button" name="reset" value="リセット" onclick="post('reset.login')" />
					<input type="button" class="button" name="reset" value="パスワード変更" onclick="post('passwordchange.login')" />
				</p>
				<div class="section-bold">
					<%= LACSLoginHTMLUtil.outHTMLInformation(loginBean) %>
				</div>
				<div class="toppage-section">
					<%= LACSLoginHTMLUtil.outHTMLSecurityLogo(loginBean) %>
				</div>
			</div>
		</div>
		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>
