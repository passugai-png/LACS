<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.karirisi.html.*"
	import="jp.co.pro_app.lacs.common.define.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="kariRisiBean" scope="session" class="jp.co.pro_app.lacs.affairs.karirisi.bean.LACSKariRisiBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>借入利子率メンテナンス</title>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<link href="css/style.css" type="text/css" rel="stylesheet"/>
		<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240821 -->
	<form name="frm" class="background">
		<input type="hidden" name="condCosmosCode" value="<%= kariRisiBean.getCondCosmosCode() %>"/>
		<input type="hidden" name="procMode" value="<%= kariRisiBean.getProcMode() %>"/>
		<input type="hidden" name="retuSu"/>
		<input type="hidden" name="leasCompanyNm" value="<%= kariRisiBean.getleasCompanyNm() %>"/>
		<input type="hidden" name="leasCompany" value="<%= kariRisiBean.getleasCompany() %>"/>
		<input type="hidden" name="PageNo" value="<%= kariRisiBean.getPageNo() %>"/>
		<div class="common-header">
<%= LACSKariRisiHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= kariRisiBean.getMessage() %>
			<div class="section">
				<span class="font-red">* </span>開示先コード：
<% if(kariRisiBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_UPD){ %>
				<input type="text" value="<%= LACSKariRisiHTMLUtil.encode(kariRisiBean.getCosmosCode()) %>" name="cosmosCodeDmy" size="13" maxlength="10" disabled="disabled" class="ime-disabled"/>
				<input type="hidden" value="<%= LACSKariRisiHTMLUtil.encode(kariRisiBean.getCosmosCode()) %>" name="targetCosmosCode"/>&nbsp;&nbsp;&nbsp;<%= LACSKariRisiHTMLUtil.encode(kariRisiBean.getUserName()) %>
<% }else{ %>
				<input type="text" value="<%= LACSKariRisiHTMLUtil.encode(kariRisiBean.getCosmosCode()) %>" name="targetCosmosCode" size="13" maxlength="10"/>
<% }%>
				<input type="text" name="dummy" style="position:absolute;visibility:hidden"/>
			</div>							
			<div class="interest-rate-table">
				<%= LACSKariRisiHTMLUtil.outHTMLList(kariRisiBean) %>
			</div>
			<p class="command-button">
				<input type="button" class="button" value=" 登  録 " onclick="kakuninRegist('regist.karirisi')" name="regist"/>
				<input type="button" class="button" value=" 戻  る " onclick="post('back.karirisi')" name="return"/>
			</p>
		</div>
		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>