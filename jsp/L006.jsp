<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.infolist.html.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="infoListBean" scope="session" class="jp.co.pro_app.lacs.affairs.infolist.bean.LACSInfoListBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>お知らせ一覧</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240822 -->
	<form name="frm" class="background">
		<input type="hidden" name="nextPage" value=""/>
		<input type="hidden" name="procMode" value=""/>
		<input type="hidden" name="targetRowId" value=""/>
		<div class="common-header">
<%= LACSInfoListHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= infoListBean.getMessage() %>
			<div class="function-title">検索条件</div>
			<div class="input-group-row-nospase">
				<div class="section">
					<div class="section-right">掲載期間：</div>
					<div class="section-right">開示先：</div>
					<div class="section-right">内容：</div>
				</div>
				<div class="section">
					<div class="section-inputbox">
						<input type="text" class="textbox-five" value="<%= LACSInfoListHTMLUtil.encode(infoListBean.getCondStartYmd()) %>" name="condStartYmd" size="10" maxlength="8"/>
						<span class="tilde">～</span> 
						<input type="text" class="textbox-five" value="<%= LACSInfoListHTMLUtil.encode(infoListBean.getCondEndYmd()) %>" name="condEndYmd" size="10" maxlength="8"/>
					</div>
					<div class="section-inputbox">
						<input type="text" class="textbox-nine" name="condleasCompanyNm" value="<%= LACSInfoListHTMLUtil.encode(infoListBean.getLeasCompanyNm()) %>" size="20" />
						<input type="button" class="button" value="絞　込" onclick="post('filter.infolist')"/>
						<select class="pulldown-six" name="condleasCompany">
							<%= LACSInfoListHTMLUtil.outHTMLCombo(infoListBean.getLeasCompany())%>
						</select>
						<input type="text" name="dummy" style="position:absolute;visibility:hidden" size="20"/>
					</div>
					<div class="section-inputbox">
						<input type="text" class="textbox-twelve" value="<%= LACSInfoListHTMLUtil.encode(infoListBean.getCondInfoData()) %>" name="condInfoData" size="50" maxlength="100"/>
					</div>
				</div>
			</div>
			<p class="create-button">
				<input type="button" class="button" onclick="post('search.infolist')" value=" 検  索 "/>
				<input type="button" class="button" onclick="newInfo('new.infolist')" value=" 新　規 "/>
			</p>
<% if(infoListBean.isShowList()){ %>
			<hr />
			<div class="function-title">
				検索結果 (<%= infoListBean.getDataMax() %>件)
			</div>
			<div class="page-position">	
<%= LACSInfoListHTMLUtil.outHTMLPageChange(infoListBean) %>
				<input type="hidden" class="textbox-seven" name="PageNo" value="<%= infoListBean.getCurrent() %>" />
			</div>
			<div class="search-list">
<%= LACSInfoListHTMLUtil.outHTMLList(infoListBean) %>
			</div>
			<div class="page-position">
<%= LACSInfoListHTMLUtil.outHTMLPageChange(infoListBean) %>
			</div>
<%	}%>
		</div>

		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>