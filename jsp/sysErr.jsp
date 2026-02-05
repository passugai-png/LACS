<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	pageEncoding="windows-31j"
%>
<jsp:useBean id="bean" scope="request" class="jp.co.pro_app.projframe.common.bean.ExceptionBean" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta charset="windows-31j">
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title><%= bean.getTitle() %></title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240823 -->
	<form name="frm" class="background">
		<input type="hidden" name="nextPage" value=""/>
		<div class="no-transition-common-header">
			<img src="img/logo.gif" class="img-logo" />
		</div>
		<div class="main">
			<div class="err-box">
				<div class="err-massage-section">
					<span class="err-caution"><%= bean.getMessage() %></span>
				</div>
<% if(bean.isSystemError()){ %>
				<div class="err-massage-section">
					ご迷惑をお掛けして申し訳ありません。<br />
					下記エラー番号を管理担当者へお問い合わせ下さい。<br />
					エラー番号：<%= jp.co.pro_app.projframe.common.bean.ExceptionBean.getErrorNo() %><br />
				</div>	
<%--			<div class="err-massage-section">
					お問い合わせ先<br />
					〒123-4567<br />
					東京都千代田区1-1-1<br />
					Tel 03-1234-5678<br />
					株式会社○○○○○○
				</div> --%>
<% }else{ %>
				<div class="err-massage-section">				
					もう一度始めからやり直してください。
				</div>
<%--			<div class="err-massage-section">
					ログインは<a href="../LACSLogin/start.login">こちら</a>。
				</div>	--%>
<% } %>
			</div>
		</div>
	</form>
</body>
</html>
