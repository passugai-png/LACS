<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.karirisilist.html.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="kariRisiListBean" scope="session" class="jp.co.pro_app.lacs.affairs.karirisilist.bean.LACSKariRisiListBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>借入利子率一覧</title>
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
<%= LACSKariRisiListHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= kariRisiListBean.getMessage() %>
			<div class="function-title">検索条件</div>
			<div class="disclosure-recipient">
				開示先：
				<input type="text" class="textbox-nine" name="leasCompanyNm" value="<%= LACSKariRisiListHTMLUtil.encode(kariRisiListBean.getLeasCompanyNm()) %>" />
				<input type="button" class="button" value="絞　込" onclick="post('filter.karirisilist')"/>
				<select class="pulldown-six" name="leasCompany">
<%= LACSKariRisiListHTMLUtil.outHTMLCombo(kariRisiListBean.getLeasCompany())%>
				</select>
				<input type="text" class="hide-textbox" name="dummy" />
			</div>		
			<p class="command-button">
				<input type="button" class="button" onclick="post('search.karirisilist')" value=" 検　索 "/>
				<input type="button" class="button" onclick="newKariRisi('new.karirisilist')" value=" 新　規 "/>
			</p>	
<% if(kariRisiListBean.isShowList()){ %>
			<hr />
			<div class="function-title">検索結果 (<%= kariRisiListBean.getDataMax() %>件)</div>
			<div class="page-position">
<%= LACSKariRisiListHTMLUtil.outHTMLPageChange(kariRisiListBean) %>
				<input type="hidden" name="PageNo" style="width:200px" value="<%= kariRisiListBean.getCurrent() %>" />
			</div>
 		 	<div class="search-list">
<%= LACSKariRisiListHTMLUtil.outHTMLList(kariRisiListBean) %>
			</div>
			<div class="page-position">
<%= LACSKariRisiListHTMLUtil.outHTMLPageChange(kariRisiListBean) %>
			</div>
<%	}%>
		</div>
		
		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>