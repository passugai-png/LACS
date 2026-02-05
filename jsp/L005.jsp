<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.tantolist.html.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="tantoListBean" scope="session" class="jp.co.pro_app.lacs.affairs.tantolist.bean.LACSTantoListBean" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>担当者一覧</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240827 -->
	<form name="frm" class="background">
		<input type="hidden" name="nextPage" value=""/>
		<input type="hidden" name="procMode" value=""/>
		<input type="hidden" name="userRightMode" value=""/>
		<input type="hidden" name="targetUserID" value=""/>
		<div class="common-header">
<%= LACSTantoListHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= tantoListBean.getMessage() %>
			<div class="function-title">検索条件</div>
			<div class="input-group-row-nospase">
				<div class="section">
					<div class="section-right">ユーザID：</div>
					<div class="section-right">開示先：</div>
					<div class="section-right">利用者権限：</div>
				</div>
				<div class="section-ratio-one">
					<div class="section-inputbox">
						<input type="text" class="textbox-seven" value="<%= LACSTantoListHTMLUtil.encode(tantoListBean.getUserID()) %>" name="condUserID" size="13" maxlength="10" />
						<input type="text" class="hide-textbox" name="dummy" />
						<span class="section">状態：
							<select class="pulldown-four" name="tantJti">
<%= LACSTantoListHTMLUtil.outHTMLCombo(tantoListBean.getTantJti())%>
							</select>
						</span>
					</div>
					<div class="section-inputbox">
						<div class="section-inputbox">
							<input type="text" class="textbox-nine" name="leasCompanyNm" value="<%= LACSTantoListHTMLUtil.encode(tantoListBean.getLeasCompanyNm()) %>" />
							<input type="button" class="button" value="絞　込" onclick="post('filter.tantolist')"/>
							<select class="pulldown-six" name="leasCompany">
<%= LACSTantoListHTMLUtil.outHTMLCombo(tantoListBean.getLeasCompany())%>
							</select>
						</div>
					</div>
					<div class="section-inputbox">
						<input type="radio" class="radiobutton" name="condUserRight" value="0" <%= "0".equals(tantoListBean.getUserRight()) ? "checked" : ""%>/>全ユーザ
						<input type="radio" class="radiobutton" name="condUserRight" value="1" <%= "1".equals(tantoListBean.getUserRight()) ? "checked" : ""%>/>エンドユーザ
						<input type="radio" class="radiobutton" name="condUserRight" value="2" <%= "2".equals(tantoListBean.getUserRight()) ? "checked" : ""%>/>一般社員
						<input type="radio" class="radiobutton" name="condUserRight" value="3" <%= "3".equals(tantoListBean.getUserRight()) ? "checked" : ""%>/>管理者
					</div>		
				</div>
			</div>
			<p class="command-button">
				<input onclick="post('search.tantolist')" type="button" class="button" value="　検　索　"/>
				<input onclick="newTanto('newenduser.tantolist', 1)" type="button" class="button" value=" エンドユーザ(新規) "/>
				<input onclick="newTanto('newgeneral.tantolist', 2)" type="button" class="button" value=" 一般社員(新規) "/>
				<input onclick="newTanto('newadmin.tantolist', 3)" type="button" class="button" value=" 管理者(新規) "/>
			</p>			
<% if(tantoListBean.isShowList()){ %>
			<hr />
			<div class="function-title">検索結果 (<%= tantoListBean.getDataMax() %>件)</div>
			<div class="page-position">
<%= LACSTantoListHTMLUtil.outHTMLPageChange(tantoListBean) %>
 		 		<input type="hidden" name="PageNo" style="width:200px" value="<%= tantoListBean.getCurrent() %>" />
			</div>	
			<div class="search-list">
<%= LACSTantoListHTMLUtil.outHTMLList(tantoListBean) %>
			</div>
			<div class="page-position">
<%= LACSTantoListHTMLUtil.outHTMLPageChange(tantoListBean) %>
			</div>
<%	}%>
		</div>

		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>
