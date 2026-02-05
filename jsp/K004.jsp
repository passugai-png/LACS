<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.syousai.html.*"
	import="jp.co.pro_app.lacs.common.define.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="syousaiBean" scope="session" class="jp.co.pro_app.lacs.affairs.syousai.bean.LACSSyousaiBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>契約詳細情報</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
	<script language="javascript" src="js/report.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240814 -->
	<form name="frm" class="background">
		<input type="hidden" name="nextPage" value=""/>
		<input type="hidden" name="selKeiyakuNo"/>
		<input type="hidden" name="selHyoujiKeiyakuNo"/>
		<input type="hidden" name="selLeasCompany"/>
		<input type="hidden" name="selTradeHanteiKekka"/>
		<input type="hidden" name="selPageFrom"/>
		<input type="hidden" name="csvName"/>
		<div class="common-header">
<%= LACSSyousaiHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= syousaiBean.getMessage() %>
			<div class="function-title">検索条件</div>
<% if(syousaiBean.getPageFrom() != 0){ %>
	<% if(syousaiBean.getPageFrom() == 1 || syousaiBean.getPageFrom() == 2){ %>
			<div class="section-period">
				契約番号：
				<input type="hidden" value="<%= LACSSyousaiHTMLUtil.encode(syousaiBean.getKeiyakuNo()) %>" name="keiyakuNo" />
				<input type="hidden" value="<%= LACSSyousaiHTMLUtil.encode(syousaiBean.getHyoujiKeiyakuNo()) %>" name="hyoujiKeiyakuNo" />
				<%= LACSSyousaiHTMLUtil.encode(syousaiBean.getHyoujiKeiyakuNo()) %> 
			</div>
	<% } %>
<% } %>
			<p class="command-button">
<% switch(syousaiBean.getPageFrom()){
	case 1: %>
				<input type="button" class="button" value=" 戻  る " onclick="post('keiyaku.syousai')" />
		<% break;
	case 2: %>
				<input type="button" class="button" value=" 戻  る " onclick="post('bukken.syousai')" />
		<% break;
} %>
			</p>
<% if(syousaiBean.isShowList()){ %>
			<hr />
			<div class="function-title">契約情報</div>
			<p class="command-button">
<% if (commonBean.getDispControl().isAvailable("P0000031")) { %>
		<% if (syousaiBean.getDownloadPath().length() == 0) { %>
				<input type="button" class="button" value="帳票印刷" onclick="javascript:setKeiyaku('pdfprint.syousai', '<%= LACSSyousaiHTMLUtil.encode(syousaiBean.getKeiyakuNo())%>','<%= LACSSyousaiHTMLUtil.encode(syousaiBean.getHyoujiKeiyakuNo())%>', null, null, null, null, 1)" />							
		<% } else{ %>
				<a href='<%= syousaiBean.getDownloadPath() %>'  target='syousai' >契約詳細情報PDF</a>
		<% } %>
		<% if (syousaiBean.getCSVDownloadPath().length() == 0) { %>
				<input type="button" class="button" value="CSV作成" onclick="javascript:setKeiyaku('csvprint.syousai', '<%= LACSSyousaiHTMLUtil.encode(syousaiBean.getKeiyakuNo())%>','<%= LACSSyousaiHTMLUtil.encode(syousaiBean.getHyoujiKeiyakuNo())%>', null, null, null, null, 1)" />
		<% } else{ %>						
				<%= LACSSyousaiHTMLUtil.outHTMLPdfPath(syousaiBean, syousaiBean.getCSVDownloadPath(), "契約詳細情報CSV", "download") %>
		<% } %>
<% } %>
			</p>
			<div class="search-list-detail">
<%= LACSSyousaiHTMLUtil.outHTMLHeader(syousaiBean) %>
			</div>
			
			<div class="function-title">物件情報</div>
			<div class="page-position">
<%= LACSSyousaiHTMLUtil.outHTMLPageChange(syousaiBean) %>
			</div>
			<div class="search-list">
<%= LACSSyousaiHTMLUtil.outHTMLList(syousaiBean) %> 
			</div>
			<div class="page-position">
<%= LACSSyousaiHTMLUtil.outHTMLPageChange(syousaiBean) %>
			</div>
<%	}%>
		</div>

		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>