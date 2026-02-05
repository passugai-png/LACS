<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.companyuser.html.*"
	import="jp.co.pro_app.lacs.common.define.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="companyUserBean" scope="session" class="jp.co.pro_app.lacs.affairs.companyuser.bean.LACSCompanyUserBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>顧客別開示先メンテナンス</title>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<link href="css/style.css" type="text/css" rel="stylesheet"/>
		<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240821 -->
	<form name="frm" class="background">
		<input type="hidden" name="condCompanyCode" value="<%= companyUserBean.getCondCompanyCode() %>"/>
		<input type="hidden" name="condTorihikiCode" value="<%= companyUserBean.getCondTorihikiCode() %>"/>
		<input type="hidden" name="condCosmosCode" value="<%= companyUserBean.getCondCosmosCode() %>"/>
		<input type="hidden" name="procMode" value="<%= companyUserBean.getProcMode() %>"/>
		<input type="hidden" name="leasCompanyNm" value="<%= companyUserBean.getleasCompanyNm() %>"/>
		<input type="hidden" name="leasCompany" value="<%= companyUserBean.getleasCompany() %>"/>
		<input type="hidden" name="PageNo" value="<%= companyUserBean.getPageNo() %>"/>
		<div class="common-header">
<%= LACSCompanyUserHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= companyUserBean.getMessage() %>
			<div class="input-group-row">
				<div class="section">
					<div class="section-right">
						<span class="font-red">* </span>リース会社コード：
					</div>
					<div class="section-right">
						<span class="font-red">* </span>取引先コード：
					</div>
					<div class="section-right">
						<span class="font-red">* </span>開示先コード：
					</div>
				</div>
				<div class="section">
					<div class="section">
<% if(companyUserBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_UPD){ %>
						<input type="text" class="textbox-seven" value="<%= LACSCompanyUserHTMLUtil.encode(companyUserBean.getLeasCompanyCode()) %>" name="leasCompanyCodeDmy" size="6" maxlength="5" disabled="disabled" />
						<input type="hidden" value="<%= LACSCompanyUserHTMLUtil.encode(companyUserBean.getLeasCompanyCode()) %>" name="targetCompanyCode"/>
<% }else{ %>
						<input type="text" class="gray-textbox" value="LACS" name="targetCompanyCode" size="6" maxlength="5" readonly="readonly" />
<% }%>
					</div>
					<div class="section">
<% if(companyUserBean.getProcMode() == LACSDefine.ProcMode.PROC_MODE_UPD){ %>
						<input type="text" class="textbox-seven" value="<%= LACSCompanyUserHTMLUtil.encode(companyUserBean.getTorihikiCode()) %>" name="torihikiCodeDmy" size="13" maxlength="10" disabled="disabled" />
						<input type="hidden" value="<%= LACSCompanyUserHTMLUtil.encode(companyUserBean.getTorihikiCode()) %>" name="targetTorihikiCode"/>
<% }else{ %>
						<input type="text" class="textbox-seven" value="<%= LACSCompanyUserHTMLUtil.encode(companyUserBean.getTorihikiCode()) %>" name="targetTorihikiCode" size="13" maxlength="10"/>
<% }%>
					</div>
					<div class="section">
						<input type="text" class="textbox-seven" value="<%= LACSCompanyUserHTMLUtil.encode(companyUserBean.getCosmosCode()) %>" name="cosmosCode" size="13" maxlength="10"/>
					</div>
				</div>
			</div>
			<p class="command-button">
				<input type="button" class="button" value=" 登  録 " onclick="kakuninRegist('regist.companyuser')" name="regist"/>
				<input type="button" class="button" value=" 戻　る " onclick="post('back.companyuser')" name="return"/>
			</p>
		</div>
		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>