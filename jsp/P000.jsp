<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.projframe.common.html.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="passwordBean" scope="session" class="jp.co.pro_app.lacs.affairs.password.bean.LACSPasswordBean" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>パスワード変更</title>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<link href="css/style.css" type="text/css" rel="stylesheet"/>
		<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240827 -->
	<form name="frm" class="background">
		<input type="hidden" name="condCompanyCode" value="LACS"/>
		<input type="hidden" name="procMode" value="2"/>
		<div class="no-transition-common-header">
			<img src="img/logo.gif" class="img-logo" /> 
		</div>
		<div class="main">
<%= passwordBean.getMessage() %>
			<div class="password-box">
				<div class="password-section">
					・ご自分のユーザＩＤを入力してください<br />
					<input type="text" class="textbox-ten" size="50" name="userId" value="<%= HTMLUtil.encode(passwordBean.getUserId()) %>"/> 
					（例：f52a1648）
				</div>
				<div class="password-section">
					・今まで使用していた現在のパスワード（仮パスワード）を入力してください<br />
					　これが正しくない場合、パスワードを変更する事はできません<br />
					<input type="password" class="textbox-ten" size="50" name="oldPassword" value="<%= HTMLUtil.encode(passwordBean.getOldPassword()) %>"/> 
				</div>
				<div class="password-section">
					・新しいパスワードを入力してください。（半角「<%= passwordBean.getMinLength() %>文字以上<%= passwordBean.getMaxLength() %>文字以内」で「英大文字、英小文字、数字、記号のうち、3種類以上の複合利用」）<br />
					　注意…過去5世代前までに使用したパスワードを再利用する事はできません<br />
					<input type="password" class="textbox-ten" size="50" name="newPassword1" value="<%= HTMLUtil.encode(passwordBean.getNewPassword1()) %>"/> 
				</div>
				<div class="password-section">
					・確認のため、もう一度新しいパスワードを入力してください<br />
					<input type="password" class="textbox-ten" size="50" name="newPassword2" value="<%= HTMLUtil.encode(passwordBean.getNewPassword2()) %>"/> 
				</div>
			</div>
			<div class="password-button">
				<input type="button" class="button" value=" 登  録 " onclick="kakuninRegist('regist.password')" name="regist"/>
				<input type="button" class="button" value=" 戻  る " onclick="post('back.login')" name="return"/>
			</div>
		</div>
		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>