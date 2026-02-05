<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.tanto.html.*"
	import="jp.co.pro_app.lacs.common.define.*"
	import="jp.co.pro_app.projframe.common.command.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="tantoBean" scope="session" class="jp.co.pro_app.lacs.affairs.tanto.bean.LACSTantoBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>担当者メンテナンス</title>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<link href="css/style.css" type="text/css" rel="stylesheet"/>
		<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240821 -->
	<form name="frm" class="background">
		<input type="hidden" name="condUserID" value="<%= tantoBean.getCondUserID() %>"/>
		<input type="hidden" name="procMode" value="<%= tantoBean.getProcMode() %>"/>
		<input type="hidden" name="userRightMode" value="<%= tantoBean.getUserRight() %>"/>
		<input type="hidden" name="condCosmosCode" value="<%= tantoBean.getCondCosmosCode() %>"/>
		<input type="hidden" name="condUserRight" value="<%= tantoBean.getCondUserRight()%>"/>
		<input type="hidden" name="filterIndex" value=""/>
		<input type="hidden" name="PageNo" value="<%= tantoBean.getPageNo() %>"/>
		<div class="common-header">
<%= LACSTantoHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= tantoBean.getMessage() %>
			<div class="input-group-one-row">
				<div class="new-user-section">
					<span class="font-red">* </span>ユーザID：
				</div>
				<div class="new-user-section-input">
<% if(tantoBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_UPD){ %>
					<input type="text" class="textbox-seven" value="<%= LACSTantoHTMLUtil.encode(tantoBean.getUserID()) %>" name="userIDDmy" size="13" maxlength="10" disabled="disabled" />
					<input type="hidden" value="<%= LACSTantoHTMLUtil.encode(tantoBean.getUserID()) %>" name="targetUserID"/>
<% }else{ %>
					<input type="text" class="textbox-seven" value="<%= LACSTantoHTMLUtil.encode(tantoBean.getUserID()) %>" name="targetUserID" size="13" maxlength="10" />
<% }%>
				</div>
			</div>							
<% if (tantoBean.getUserRight().equals(LACSDefine.UserRight.ADMIN)) { %>
			<div class="input-group-one-row">	
				<div class="new-user-section">開示先：</div>
				<div class="all-disclosure-recipient">全開示先</div>
				<input type="hidden"name="leasCompanyEntry0" value="<%= LACSDefine.INFO_ALL %>"/>
				<input type="hidden" name="userListCount" value="1" />
			</div>
<% } else if (tantoBean.getUserRight().equals(LACSDefine.UserRight.END_USER)) { %>
			<div class="input-group-one-row">
				<div class="new-user-section">
					<span class="font-red">* </span>開示先：
				</div>
				<div class="new-user-section-input">
<%= LACSTantoHTMLUtil.outHTMLUserInputEndUser(tantoBean) %>
				</div>
			</div>
<% }%>
			<div class="input-group-one-row">
				<div class="new-user-section">担当者名：</div>
				<div class="new-user-section-input">
					<input type="text" class="textbox-eight" maxlength="25" size="70" value="<%= LACSTantoHTMLUtil.encode(tantoBean.getUserTantoName()) %>" name="userTantoName" />
				</div>
			</div>
			<div class="input-group-row">
				<div class="new-user-section">
					<span class="font-red">* </span>パスワード：
				</div>
				<div class="new-user-section-input">
					<input type="password" class="textbox-ten" size="70" value="<%= LACSTantoHTMLUtil.encode(tantoBean.getPassword()) %>" name="password1"/><br />
					（半角<%= tantoBean.getMinLength() %>文字以上<%= tantoBean.getMaxLength() %>文字以内で英大文字、英小文字、数字、記号のうち、3種類以上の複合利用)
				</div>
			</div>
			<div class="input-group-one-row">
				<div class="new-user-section">
					<span class="font-red">* </span>確認用：
				</div>
				<div class="new-user-section-input">
					<input type="password" class="textbox-ten" size="70" value="<%= LACSTantoHTMLUtil.encode(tantoBean.getPassword2()) %>" name="password2"/>
				</div>
			</div>
			<div class="input-group-one-row">
				<div class="new-user-section">仮発行：</div>
				<div class="new-user-section-input">
<% if(tantoBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_UPD){ %>
					<input type="checkbox" name="chkKriPassFlg" value="1" <%= "1".equals(tantoBean.getKriPassFlg()) ? "checked" : "" %> />
<% }else{ %>
					<input type="checkbox" name="chkDummy" value="1" checked="checked" disabled="disabled" />
					<input type="hidden" name="chkKriPassFlg" value="1" />
<% }%>
				</div>
			</div>				
			<div class="input-group-one-row">
				<div class="new-user-section">有効期限：</div>
				<div class="new-user-section-input">
					仮パスワード<br />
					本パスワード
				</div>
				<div class="section">
					<%= Convert.toDateString(tantoBean.getKriPasswordTerm()) %> まで<br />
					<%= Convert.toDateString(tantoBean.getHonPasswordTerm()) %> まで
				</div>
			</div>
<% if (tantoBean.getUserRight().equals(LACSDefine.UserRight.GENERAL)) { %>
			<div class="new-user-list">
<%= LACSTantoHTMLUtil.outHTMLUserInputGeneral(tantoBean) %>
			</div>
<% } %>
			<p class="command-button">
				<input type="button" class="button" value=" 登  録 " onclick="tantoKakuninRegist('regist.tanto', <%= tantoBean.getUserRight() %>)" name="regist"/>
				<input type="button" class="button" value=" 戻　る " onclick="post('back.tanto')" name="return"/>
			</p>
		</div>
		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>