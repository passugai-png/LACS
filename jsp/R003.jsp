<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.dsreport.html.*"
	import="jp.co.pro_app.lacs.common.define.LACSDefine"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="dsReportBean" scope="session" class="jp.co.pro_app.lacs.affairs.dsreport.bean.LACSDSReportBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>貸手側注記帳票出力</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
	<script language="javascript" src="js/report.js"></script>
</head>
	<body onload="javascript:prepared();setFocusDS(<%= dsReportBean.getNextFocus() %>)">
		<div id="waitScreen" style="display:none;position:absolute;left:0;height:300px">
			<div class="center" style="position:absolute;top:200px;width:100%;height:100%;filter: alpha(style=0, opacity=80)">
				<table style="height:100%;" width="100%">
					<tr>
						<td class="middle center" style="background-color:gray"><span style="font-size:24pt">しばらくお待ちください。</span></td>
					</tr>
				</table>
			</div>
		</div>
		<form name="frm" class="center" style="width:976px">
			<input type="hidden" name="nextFocus"/>
			<input type="hidden" name="csvName"/>
			<table border="0" style="height:88px;" class="border left">
				<tr>
					<td>
<%= LACSDSReportHTMLUtil.outHTMLHeader(commonBean) %>
					</td>
				</tr>
			</table>
			<br />
			<table border="0" style="height:458px;" class="border left">
				<tr>
					<td class="top">
<%= dsReportBean.getMessage() %>
						<table class="left" border="0">
							<tr>
								<td colspan="7" class="header">
									出力条件
								</td>
							</tr>
							<tr>
								<td class="left" style="width: 0px">
									&nbsp;
								</td>
								<td class="left">
<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY || commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER){ %>
									&nbsp;&nbsp;&nbsp;
									開示先：
<% } else{ %>
									&nbsp;&nbsp;&nbsp; リース会社：
<% } %>
								</td>
								<td class="left" colspan="5">
<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) { %>
									<input type="text" name="leasCompanyNm"  style="width:200px" value="<%= dsReportBean.getLeasCompanyNm() %>" />
									<input type="button" value="絞込" onclick="post('filter.dsreport')" />
									<select style="width: 250px" name="leasCompany" onchange = "post('usersearch.dsreport')">
											<%= LACSDSReportHTMLUtil.outHTMLCombo(dsReportBean.getLeasCompany())%>
									</select>
<% } else { %>
									<input type="hidden" value="<%= LACSDSReportHTMLUtil.encode(dsReportBean.getLeasCompany().getValue()) %>" name="leasCompany" /><%= LACSDSReportHTMLUtil.encode(dsReportBean.getLeasCompany().getName()) %>
<% } %>
								</td>
							</tr>
						</table>
						<table border="0">
							<tr>
								<td class="header">
									対象期間
								</td>
							</tr>
							<tr>
								<td class="left">
									<table class="left" border="0">
										<tr>
											<td class="left" style="width: 132;">
												&nbsp; <span class="font-red">* </span>開始日
											</td>
											<td class="left" style="width: 143;">
<%= LACSDSReportHTMLUtil.outHTMLDateInputFieldYM(commonBean, dsReportBean.getTermFrom()) %>
											</td>
											<td class="left" style="width: 591px;">
												&nbsp;
											</td>
	 									</tr>
									</table>
									<table class="left" border="0">
										<tr>
											<td class="left">
												<input type="radio" name="quarter" value="0" <%= dsReportBean.getQuarter().equals("0") ? "checked" : "" %>/>
												<input type="text" value="<%= dsReportBean.getTermNum0() %>" maxlength="2" size="2" name="termNum0" class="right" onchange="focusNextDS(this)" />ヶ月
											</td>
											<td class="left" colspan="2">
												（ <%= LACSDSReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, dsReportBean.getTermTo0()) %>）
											</td>
										</tr>
										<tr>
											<td class="left">
												<input type="radio" name="quarter" value="1" <%= dsReportBean.getQuarter().equals("1") ? "checked" : "" %>/>
												<input type="hidden" value="3" name="termNum1"/>
												第１四半期
											</td>
											<td class="left" width="143">
												（ <%= LACSDSReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, dsReportBean.getTermTo1()) %>）
											</td>
											<td class="left">
												 |---------------|
											</td>
										</tr>
										<tr>
											<td class="left">
												<input type="radio" name="quarter" value="2" <%= dsReportBean.getQuarter().equals("2") ? "checked" : "" %>/>
												<input type="hidden" value="6" name="termNum2"/>
												半期</td>
											<td class="left">
												（ <%= LACSDSReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, dsReportBean.getTermTo2()) %>）
											</td>
											<td class="left">
												 |---------------|---------------|
											</td>
										</tr>
										<tr>
											<td class="left">
												<input type="radio" name="quarter" value="3" <%= dsReportBean.getQuarter().equals("3") ? "checked" : "" %>/>
												<input type="hidden" value="9" name="termNum3"/>
												第３四半期</td>
											<td class="left">
												（ <%= LACSDSReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, dsReportBean.getTermTo3()) %>）
											</td>
											<td class="left">
												 |---------------|---------------|---------------|
											</td>
										</tr>
										<tr>
											<td class="left">
												<input type="radio" name="quarter" value="4" <%= dsReportBean.getQuarter().equals("4") ? "checked" : "" %>/>
												<input type="hidden" value="12" name="termNum4"/>
												通期</td>
											<td class="left">
												（ <%= LACSDSReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, dsReportBean.getTermTo4()) %>）
											</td>
											<td class="left">
												 |---------------|---------------|---------------|---------------|
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<table border="0">
							<tr>
								<td class="top" >
									<table class="left" border="0">
										<tr>
											<td class="left"style="width:138px">&nbsp;</td>
											<td class="left">&nbsp;</td>
											<td class="right bottom" width="570">
<% if (dsReportBean.getPdfFileName().trim().length() == 0 ) { %>
												<input type="button" value="帳票印刷" onclick="setWaitScreen();execSubmit('printpdf');post('pdfprint.dsreport')" name="printpdf" />
<% } else { %>
												<a href='<%= dsReportBean.getPdfFileName() %>' target='Tyuki' >注記合計表PDF</a> <img src="img/acrobat.gif" style="width: 16px;height: 16px"/>&nbsp;
												
<% } %>
<% if (dsReportBean.getCsvFileName().trim().length() == 0 ) { %>
												<input type="button" value="CSV作成" onclick="setWaitScreen();execSubmit('printcsv');post('csvprint.dsreport')" name="printcsv" />
<% } else { %>
												<a href='#' onclick="javascript:downloadCSV('<%= dsReportBean.getCsvFileName() %>');return false;">注記合計表CSV</a>
<% } %>
											</td>
										</tr>
									</table>
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