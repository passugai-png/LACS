<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.info.html.*"
	import="jp.co.pro_app.lacs.common.define.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="infoBean" scope="session" class="jp.co.pro_app.lacs.affairs.info.bean.LACSInfoBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<title>お知らせメンテナンス</title>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<link href="css/style.css" type="text/css" rel="stylesheet"/>
		<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240823 -->
	<form name="frm" class="background">
		<input type="hidden" name="condStartYmd" value="<%= infoBean.getCondStartYmd() %>"/>
		<input type="hidden" name="condEndYmd" value="<%= infoBean.getCondEndYmd() %>"/>
		<input type="hidden" name="condInfoData" value="<%= infoBean.getCondInfoData() %>"/>
		<input type="hidden" name="targetRowId" value="<%= infoBean.getRowId() %>"/>
		<input type="hidden" name="procMode" value="<%= infoBean.getProcMode() %>"/>
		<input type="hidden" name="PageNo" value="<%= infoBean.getPageNo() %>"/>
		<div class="common-header">
<%= LACSInfoHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= infoBean.getMessage() %>
			<div class="input-group-row-nospase">
				<div class="section">
					<div class="section-right"><span class="font-red">* </span>掲載期間：</div>
					<div class="section-right"><span class="font-red">* </span>開示先：</div>
					<div class="section-right"><span class="font-red">* </span>内容：</div>
				</div>
				<div class="section">
					<div class="section-inputbox">
						<input type="text" class="textbox-six" value="<%= LACSInfoHTMLUtil.encode(infoBean.getStartYmd()) %>" name="startYmd" size="10" maxlength="8"/>
						<span class="tilde">～</span> 
						<input type="text" class="textbox-six" value="<%= LACSInfoHTMLUtil.encode(infoBean.getEndYmd()) %>" name="endYmd" size="10" maxlength="8"/>
					</div>
					<div class="section-inputbox">
						<input type="text" name="leasCompanyNm" class="textbox-nine" value="<%= LACSInfoHTMLUtil.encode(infoBean.getLeasCompanyNm()) %>" />
						<input type="button" class="button" value="絞　込" onclick="post('filter.info')"/>
						<select class="pulldown-six" name="leasCompany">
						<%= LACSInfoHTMLUtil.outHTMLCombo(infoBean.getLeasCompany())%>
						</select>
						<input type="text" name="dummy" style="position:absolute;visibility:hidden" size="20"/>		
					</div>
					<textarea name="infoData" class="textarea-two" rows="1" cols="20"><%= LACSInfoHTMLUtil.encode(infoBean.getInfoData()) %></textarea>	
				</div>	
			</div>
			<p class="create-button">
				<input type="button" class="button" value=" 登  録 " onclick="kakuninRegist('regist.info')" name="regist"/>
				<input type="button" class="button" value=" 戻　る " onclick="post('back.info')" name="return"/>
			</p>
		</div>
		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>