<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.companyuserlist.html.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="companyUserListBean" scope="session" class="jp.co.pro_app.lacs.affairs.companyuserlist.bean.LACSCompanyUserListBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>顧客別開示先一覧</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240823 -->
	<form name="frm" class="background">
		<input type="hidden" name="nextPage" value=""/>
		<input type="hidden" name="procMode" value=""/>
		<input type="hidden" name="targetCompanyCode" value=""/>
		<input type="hidden" name="targetTorihikiCode" value=""/>
		<input type="hidden" name="targetCosmosCode" value=""/>
		<div class="common-header">
<%= LACSCompanyUserListHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= companyUserListBean.getMessage() %>
			<div class="function-title">検索条件</div>
			<div class="input-group-row-nospase">
				<div class="section">
					<div class="section-right">取引先コード：</div>
					<div class="section-right">開示先：</div>	
				</div>
				<div class="section-inputbox">
					<div class="section-inputbox">
						<input type="text" class="textbox-seven" value="<%= LACSCompanyUserListHTMLUtil.encode(companyUserListBean.getTorihikiCode()) %>" name="condTorihikiCode" size="13" maxlength="10"/>
					</div>
					<div class="section-inputbox">
						<input type="text" class="textbox-nine" name="leasCompanyNm" value="<%= LACSCompanyUserListHTMLUtil.encode(companyUserListBean.getLeasCompanyNm()) %>" />
						<input type="button" class="button" value="絞　込" onclick="post('filter.companyuserlist')"/>
						<select class="pulldown-six" name="leasCompany">
							<%= LACSCompanyUserListHTMLUtil.outHTMLCombo(companyUserListBean.getLeasCompany())%>
						</select>
					</div>
				</div>
			</div>
			<p class="command-button">
				<input type="button" class="button" value=" 検　索" onclick="post('search.companyuserlist')" />
				<input type="button" class="button" value=" 新　規 " onclick="newCompanyUser('new.companyuserlist')" />
			</p>
			
<% if(companyUserListBean.isShowList()){ %>
			<hr />				
			<div class="function-title">
				検索結果 (<%= companyUserListBean.getDataMax() %>件)
			</div>
			<div class="page-position">
<%= LACSCompanyUserListHTMLUtil.outHTMLPageChange(companyUserListBean) %>
 		 		<input type="hidden" name="PageNo" style="width:200px" value="<%= companyUserListBean.getCurrent() %>" />
			</div>
			<div class="search-list">
<%= LACSCompanyUserListHTMLUtil.outHTMLList(companyUserListBean) %>
			</div>
			<div class="page-position">
<%= LACSCompanyUserListHTMLUtil.outHTMLPageChange(companyUserListBean) %>
			</div>
<%	}%>
		</div>

		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>