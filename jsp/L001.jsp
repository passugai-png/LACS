<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.companylist.html.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="companyListBean" scope="session" class="jp.co.pro_app.lacs.affairs.companylist.bean.LACSCompanyListBean" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>リース会社マスタ一覧</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared()">
	<form name="frm">
		<input type="hidden" name="nextPage" value=""/>
		<input type="hidden" name="procMode" value=""/>
		<input type="hidden" name="targetCompanyCode" value=""/>
		<table border="0" style="height:88px;" class="border">
			<tr>
				<td>
<%= LACSCompanyListHTMLUtil.outHTMLHeader(commonBean) %>
				</td>
			</tr>
		</table>
		<br />
		<table border="0" style="height:458px;" class="border">
			<tr>
				<td class="top">
<%= companyListBean.getMessage() %>
					<table style="height:16px;" width="971" border="0">
						<tr>
							<td class="left">
								<table class="left" border="0">
									<tr>
										<td colspan="3" class="header">
											検索条件
										</td>
										<td width="10"></td>
										<td class="right">リース会社コード：</td>
										<td class="left">
											<input type="text" value="<%= companyListBean.getCondCompanyCode() %>" name="condCompanyCode" size="6" maxlength="5" class="ime-disabled"/>
											<input type="text" name="dummy" style="position:absolute;visibility:hidden"/>
										</td>
										<td class="right" width="10"></td>
										<td>
											<input onclick="post('search.companylist')" type="button" value=" 検  索 "/>
											<input onclick="newCompany('search.company')" type="button" value=" 新  規 "/>
										</td>										
									</tr>
								</table>
							</td>
						</tr>
					</table>
<% if(companyListBean.isShowList()){ %>
					<hr style="width: 95%" />
					<table border="0" width="100%">
						<tr>
							<td colspan="2" class="header">
								検索結果 (<%= companyListBean.getDataMax() %>件)</td>
						</tr>
						<tr>
							<td colspan="2" class="center middle">
<%= LACSCompanyListHTMLUtil.outHTMLPageChange(companyListBean) %>
							</td>
						</tr>
						<tr>
							<td class="center" style="overflow: auto">
<%= LACSCompanyListHTMLUtil.outHTMLList(companyListBean) %>
							</td>
						</tr>
						<tr>
							<td colspan="2" class="center middle">
<%= LACSCompanyListHTMLUtil.outHTMLPageChange(companyListBean) %>
							</td>
						</tr>
					</table>
<%	}%>
				</td>
			</tr>
		</table>
		<table border="0" width="978">
			<tr style="height:8px;">
				<th width="972" align="right">
<%= commonBean.getCopyRight() %>
				</th>
			</tr>
		</table>
	</form>
</body>
</html>
