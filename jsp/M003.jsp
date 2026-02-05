<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.top.html.*"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>マスタメンテナンスメニュー</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
</head>
<body onload="javascript:prepared();post('start.login')">
	<form name="frm">
		<table border="0" style="height:88px;" class="border">
			<tr>
				<td width="100%">
					<table width="100%">
						<tr>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<br />
		<table border="0" width="100%" class="border left">
			<tr>
				<td class="center"width="100%">
					<table width="100%" style="height:100%;" border="0">
						<tr style="height:352px;">
							<td>
								<table>
									<tr>
										<td class="center" style="height: 21px">
										</td>
									</tr>
									<tr>
										<td class="center" style="height: 21px">
										</td>
									</tr>
									<tr>
										<td class="center" style="height: 21px">
										</td>
									</tr>
									<tr>
										<td class="center" style="height: 21px">
										</td>
									</tr>
									<tr>
										<td class="center">
										</td>
									</tr>
								</table>
								<table>
									<tr>
										<td class="right">
										</td>
										<td class="left">
										</td>
									</tr>
									<tr>
										<td class="right">
										</td>
										<td class="left">
										</td>
									</tr>
									<tr>
										<td class="center" colspan="2" style="height: 21px">
										</td>
									</tr>
									<tr>
										<td class="center" colspan="2" style="height: 21px">
										</td>
									</tr>
									<tr>
										<td class="center" colspan="2">
										</td>
									</tr>
									<tr>
										<td class="center" colspan="2" style="height: 21px">
										</td>
									</tr>
									<tr>
										<td class="center" colspan="2">
										</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr style="height:100px;">
							<td class="right bottom" width="100%" height="100%">
							</td>
						</tr>
					</table>
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
