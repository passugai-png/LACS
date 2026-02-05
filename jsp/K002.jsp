<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.bukken.html.*"
	import="jp.co.pro_app.lacs.common.define.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="bukkenBean" scope="session" class="jp.co.pro_app.lacs.affairs.bukken.bean.LACSBukkenBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>物件検索</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<!-- @autor tatsumi @version 20240823 -->
	<form name="frm" class="background">
		<input type="hidden" name="nextPage" value=""/>
		<input type="hidden" name="selKeiyakuNo"/>
		<input type="hidden" name="selHyoujiKeiyakuNo"/>
		<input type="hidden" name="selBukkenNo"/>
		<input type="hidden" name="selBukkenEdaNo"/>
		<input type="hidden" name="selLeasCompany"/>
		<input type="hidden" name="selTradeHanteiKekka"/>
		<input type="hidden" name="selPageFrom"/>
		<div class="common-header">
<%= LACSBukkenHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= bukkenBean.getMessage() %>
			<div class="function-title">検索条件</div>
			<div class="input-group-row-nospase">
				<div class="section">
					<div class="section-right">
<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY || commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER){ %>
						開示先：
<% }else{ %>
						リース会社：
<% } %>
					</div>
					<div class="section-right">契約番号：</div>
					<div class="section-right">物件名：</div>
				</div>
				<div class="section-inputbox">
					<div class="section-inputbox">
<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER){ %>
						<input type="hidden" value="<%= LACSBukkenHTMLUtil.encode(bukkenBean.getLeasCompany().getValue()) %>" name="leasCompany" /><%= LACSBukkenHTMLUtil.encode(bukkenBean.getLeasCompany().getName()) %>
<% } else{ %>
						<input type="text" class="textbox-nine" name="leasCompanyNm" value="<%= LACSBukkenHTMLUtil.encode(bukkenBean.getLeasCompanyNm()) %>" />
						<input type="button" class="button" value="絞　込" onclick="post('filter.bukken')" />
						<select class="pulldown-six" name="leasCompany">
<%= LACSBukkenHTMLUtil.outHTMLCombo(bukkenBean.getLeasCompany())%>
						</select>
<% } %>
					</div>
					<div class="input-group-one-row">
						<div class="section-inputbox">
							<input type="text" class="textbox-seven" value="<%= LACSBukkenHTMLUtil.encode(bukkenBean.getKeiyakuNo()) %>" maxlength="25" size="" name="keiyakuNo"/>
						</div>
						<div class="section">リース取引分類：
							<select class="pulldown-five" name="tradeHanteiKekka">
<%= LACSBukkenHTMLUtil.outHTMLCombo(bukkenBean.getTradeHanteiKekka())%>
							</select>
						</div>
					</div>
					<div class="section-inputbox">
						<input type="text" class="textbox-eleven" value="<%= LACSBukkenHTMLUtil.encode(bukkenBean.getBukkenName()) %>" maxlength="25" size="" name="bukkenName"/>
						<label><input type="radio" class="radiobutton" name="bukkenNameSerchPtn" value="1" <%= bukkenBean.getBukkenNameSerchPtn().equals("1") ? "checked" : "" %> />前方一致</label>
						<label><input type="radio" class="radiobutton" name="bukkenNameSerchPtn" value="2" <%= bukkenBean.getBukkenNameSerchPtn().equals("2") ? "checked" : "" %>/>部分一致</label>
						<label><input type="radio" class="radiobutton" name="bukkenNameSerchPtn" value="3" <%= bukkenBean.getBukkenNameSerchPtn().equals("3") ? "checked" : "" %>/>完全一致</label>
					</div>
				</div>
			</div>
			<p class="command-button">
				<input type="button" value=" 検  索 " onclick="post('search.bukken')" />
			</p>

<% if(bukkenBean.isShowList()){ %>
			<hr />
			<div class="function-title">	
				検索結果 (<%= bukkenBean.getDataMax() %>件)
			</div>			
			<div class="page-position">
<%= LACSBukkenHTMLUtil.outHTMLPageChange(bukkenBean) %>
			</div>
			<div class="search-list">
<%= LACSBukkenHTMLUtil.outHTMLList(bukkenBean, commonBean) %>
			</div>
			<div class="page-position">
<%= LACSBukkenHTMLUtil.outHTMLPageChange(bukkenBean) %>
			</div>
<%	}%>
		</div>
		
		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>