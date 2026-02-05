<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.userlist.html.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="userListBean" scope="session" class="jp.co.pro_app.lacs.affairs.userlist.bean.LACSUserListBean" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>開示先一覧</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240821 -->
	<form name="frm" class="background">
		<input type="hidden" name="nextPage" value=""/>
		<input type="hidden" name="procMode" value=""/>
		<input type="hidden" name="targetCosmosCode" value=""/>
		<div class="common-header">
<%= LACSUserListHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= userListBean.getMessage() %>
			<div class="function-title">検索条件</div>
			<div class="disclosure-recipient">
				開示先：
				<input type="text" class="textbox-nine" name="leasCompanyNm" value="<%= LACSUserListHTMLUtil.encode(userListBean.getLeasCompanyNm()) %>" />
				<input type="button" class="button" value="絞　込" onclick="post('filter.userlist')"/>
				<select class="pulldown-six" name="leasCompany">
<%= LACSUserListHTMLUtil.outHTMLCombo(userListBean.getLeasCompany())%>
				</select>
				<input type="text" name="dummy" style="position:absolute;visibility:hidden"/>
			</div>
			<p class="command-button">
				<input type="button" class="button" onclick="post('search.userlist')" value=" 検  索 "/>
				<input type="button" class="button" onclick="newUser('new.userlist')" value=" 新  規 "/>
			</p>
<% if(userListBean.isShowList()){ %>
			<hr />
			<div class="function-title">検索結果 (<%= userListBean.getDataMax() %>件)</div>
			<div class="page-position">
<%= LACSUserListHTMLUtil.outHTMLPageChange(userListBean) %>
 		 		<input type="hidden" name="PageNo" style="width:200px" value="<%= userListBean.getCurrent() %>" />
			</div>	
			<div class="search-list">
<%= LACSUserListHTMLUtil.outHTMLList(userListBean) %>
			</div>
			<div class="page-position">
<%= LACSUserListHTMLUtil.outHTMLPageChange(userListBean) %>
			</div>
<%	}%>
		</div>				

		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>
