<%@page import="jp.co.pro_app.lacs.affairs.keiyaku.bean.LACSKeiyakuDetailBean"%>
<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.monthreport.html.*"
	import="jp.co.pro_app.lacs.common.define.LACSDefine"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="mreportBean" scope="session" class="jp.co.pro_app.lacs.affairs.monthreport.bean.LACSMReportBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>月次帳票出力</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
	<script language="javascript" src="js/report.js"></script>
</head>
<body onload="javascript:prepared();setFocus(<%= mreportBean.getNextFocus() %>)">
	<!-- @autor tatsumi @version 20240815 -->
	<div id="waitScreen" class="screen">
		<table class="screen-wordbox">
			<tr>
				<td class="screen-wordbox-size"><span class="screen-word">しばらくお待ちください。</span></td>
			</tr>
		</table>
	</div>
	<form name="frm" class="background">
		<input type="hidden" name="nextFocus"/>
		<input type="hidden" name="csvName"/>
		<div class="common-header">
<%= LACSMReportHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= mreportBean.getMessage() %>
			<div class="function-title">出力条件</div>
			<div class="disclosure-recipient">
<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY || commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER) { %>
	<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) { %>
				<span class="font-red">* </span>
	<% } %>
				開示先：
<% } else{ %>
				リース会社：
<% } %>

<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) { %>
				<input type="text" class="textbox-nine" name="leasCompanyNm" value="<%= LACSMReportHTMLUtil.encode(mreportBean.getLeasCompanyNm()) %>" />
				<input type="button" class="button" value="絞　込" onclick="post('filter.monthreport')" />
				<select class="pulldown-six" name="leasCompany" onchange = "post('usersearch.monthreport')">
<%= LACSMReportHTMLUtil.outHTMLCombo(mreportBean.getLeasCompany())%>
				</select>
<% } else{ %>
				<input type="hidden" value="<%= LACSMReportHTMLUtil.encode(mreportBean.getLeasCompany().getValue()) %>" name="leasCompany" /><%= LACSMReportHTMLUtil.encode(mreportBean.getLeasCompany().getName()) %>
<% } %>
			</div>
			<div class="section">契約番号：
<%-- if(mreportBean.getRemoveAssert().getCheckOutput() == 1){ --%>
				<input type="text" class="textbox-seven" value="<%= LACSMReportHTMLUtil.encode(mreportBean.getKeiyakuNo()) %>" maxlength="20" size="" name="keiyakuNo" />														   									　　									    	                                    							
<%-- } --%>
			</div>
			<div class="function-title">対象期間</div>	
			<div class="section"><span class="font-red">* </span>開始日
<%= LACSMReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, mreportBean.getTermFrom()) %>
			</div>
			<div class="quarter">
				<div class="quarter-input">
					<div class="section">
						<label>
							<input type="radio" class="radiobutton" name="quarter" value="0" <%= mreportBean.getQuarter().equals("0") ? "checked" : "" %>/>
							<input type="text" class="textbox-four" value="<%= LACSMReportHTMLUtil.encode(mreportBean.getTermNum0()) %>" maxlength="2" size="2" name="termNum0" onchange="focusNextM(this)" />
							ヶ月
						</label>
					</div>
					<div class="section">
						<label>
							<input type="radio" class="radiobutton" name="quarter" value="1" <%= mreportBean.getQuarter().equals("1") ? "checked" : "" %>/>
							<input type="hidden" value="3" name="termNum1"/>
							第１四半期
						</label>
					</div>
					<div class="section">
						<label>
							<input type="radio" class="radiobutton" name="quarter" value="2" <%= mreportBean.getQuarter().equals("2") ? "checked" : "" %>/>
							<input type="hidden" value="6" name="termNum2"/>
							半期
						</label>
					</div>
					<div class="section">
						<label>
							<input type="radio" class="radiobutton" name="quarter" value="3" <%= mreportBean.getQuarter().equals("3") ? "checked" : "" %>/>
							<input type="hidden" class="radiobutton" value="9" name="termNum3"/>
							第３四半期
						</label>
					</div>
					<div class="section">
						<label>
							<input type="radio" class="radiobutton" name="quarter" value="4" <%= mreportBean.getQuarter().equals("4") ? "checked" : "" %>/>
							<input type="hidden" value="12" name="termNum4"/>
							通期
						</label>
					</div>
				</div>
				<div class="quarter-date">
					<div class="section">（ <%= LACSMReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, mreportBean.getTermTo0()) %>）</div>
					<div class="section">（ <%= LACSMReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, mreportBean.getTermTo1()) %>）</div>
					<div class="section">（ <%= LACSMReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, mreportBean.getTermTo2()) %>）</div>
					<div class="section">（ <%= LACSMReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, mreportBean.getTermTo3()) %>）</div>
					<div class="section">（ <%= LACSMReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, mreportBean.getTermTo4()) %>）</div>
				</div>
				<div class="quarter-mark">
						<div class="section">|---------------|</div>
						<div class="section">|---------------|---------------|</div>
						<div class="section">|---------------|---------------|---------------|</div>
						<div class="section">|---------------|---------------|---------------|---------------|</div>
				</div>
			</div>
			<div class="exttaction-condition">
				<div class="exttaction-condition-display">
					<div class="function-title">抽出条件</div>
					<div class="input-group-row">
						<div class="input-group-col">
							<span class="section">少額資産</span>
							<span class="section">リース期間１年以内</span>
							<span class="section">再リース契約</span>
							<span class="section">中途解約物件</span>
						</div>
						<div class="input-group-col">
							<span class="section">	
								<label><input type="radio" class="radiobutton" name="gtjkeiyakuGaku" value="0" <%= mreportBean.getGtjKeiyakuGaku().equals("0") ? "checked" : "" %>/>除く</label>
								<label><input type="radio" class="radiobutton" name="gtjkeiyakuGaku" value="1" <%= mreportBean.getGtjKeiyakuGaku().equals("1") ? "checked" : "" %>/>除かない</label>
							</span>
							<span class="section">
								<label><input type="radio" class="radiobutton" name="gtjleaseKikan" value="0" <%= mreportBean.getGtjLeaseKikan().equals("0") ? "checked" : "" %>/>除く</label>
								<label><input type="radio" class="radiobutton" name="gtjleaseKikan" value="1" <%= mreportBean.getGtjLeaseKikan().equals("1") ? "checked" : "" %>/>除かない</label>
							</span>
							<span class="section">
								<label><input type="radio" class="radiobutton" name="gtjsaiLease" value="0" <%= mreportBean.getGtjSaiLease().equals("0") ? "checked" : "" %>/>除く</label>
								<label><input type="radio" class="radiobutton" name="gtjsaiLease" value="1" <%= mreportBean.getGtjSaiLease().equals("1") ? "checked" : "" %>/>除かない</label>
							</span>
							<span class="section">
								<label><input type="radio" class="radiobutton" name="gtjtyutoKaiyaku" value="0" <%= mreportBean.getGtjTyutoKaiyaku().equals("0") ? "checked" : "" %>/>除く</label>
								<label><input type="radio" class="radiobutton" name="gtjtyutoKaiyaku" value="1" <%= mreportBean.getGtjTyutoKaiyaku().equals("1") ? "checked" : "" %>/>除かない</label>
							</span>
						</div>
					</div>
				</div>
				<div class="output-target-form-monthly">
					<div class="function-title">出力対象帳票</div>
					<div class="section">
<% if (commonBean.getDispControl().isAvailable("P0000011")) { %>
						<div class="section">
							<label>
								<input type="checkbox" class="checkbox" name="chkDeteil" value="1" <%= mreportBean.getKaikeiMeisai().getCheckOutput() == 1 ? "checked" : "" %> <%= commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY ? "" : "onclick=\"setDisableReportGamen()\"" %>/>
								<%= LACSMReportHTMLUtil.outHTMLPdfPath(mreportBean, mreportBean.getKaikeiMeisai(), "リース会計基準明細書", "kaikeiMeisai") %>
							</label>
						</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000012")) { %>
						<div class="section">
							<label>
								<input type="checkbox" class="checkbox" name="chkRemoveAssert" value="1" <%= mreportBean.getRemoveAssert().getCheckOutput() == 1 ? "checked" : "" %> <%= commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY ? "" : "onclick=\"setDisableReportGamen()\"" %>/>
								<%= LACSMReportHTMLUtil.outHTMLPdfPath(mreportBean, mreportBean.getRemoveAssert(), "除却資産一覧", "removeAssert") %>
							</label>
						</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000013")) { %>
						<div class="section">
							<label>
								<input type="checkbox" class="checkbox" name="chkShiwake" value="1" <%= mreportBean.getSiwake().getCheckOutput() == 1 ? "checked" : "" %> <%= commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY ? "" : "onclick=\"setDisableReportGamen()\"" %>/>
								<%= LACSMReportHTMLUtil.outHTMLPdfPath(mreportBean, mreportBean.getSiwake(), "仕訳合計表", "siwake") %>
							</label>
						</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000016")) { %>
						<div class="section">
							<label>
								<input type="checkbox" class="checkbox" name="chkSisan" value="1" <%= mreportBean.getSisan().getCheckOutput() == 1 ? "checked" : "" %> <%= commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY ? "" : "onclick=\"setDisableReportGamen()\"" %>/>
								<%= LACSMReportHTMLUtil.outHTMLPdfPath(mreportBean, mreportBean.getSisan(), "固定資産台帳(リース資産)", "download") %>
							</label>
						</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000015")) { %>
						<div class="section">
							<label>
								<input type="checkbox" class="checkbox" name="chkSyouhizei" value="1" <%= mreportBean.getSyouhizei().getCheckOutput() == 1 ? "checked" : "" %> <%= commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY ? "" : "onclick=\"setDisableReportGamen()\"" %>/>
								<%= LACSMReportHTMLUtil.outHTMLPdfPath(mreportBean, mreportBean.getSyouhizei(), "消費税明細表", "download") %>
							</label>
						</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000014")) { %>
						<div class="section">		
							<label>	
								<input type="checkbox" class="checkbox" name="chkDereilDl" value="1" <%= mreportBean.getDownload().getCheckOutput() == 1 ? "checked" : "" %> <%= commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY ? "" : "onclick=\"setDisableReportGamen()\"" %>/>
								<%= LACSMReportHTMLUtil.outHTMLPdfPath(mreportBean, mreportBean.getDownload(), "仕訳源泉情報(CSV作成のみ)", "download") %>
							</label>
						</div>
<% } %>
					</div>
				</div>
			</div>	
			<p class="command-button">
				<input type="button" class="button" value="帳票印刷" onclick="setWaitScreen();execSubmit('print');post('pdfprint.monthreport')" name="print" />
				<input type="button" class="button" value="CSV作成" onclick="setWaitScreen();execSubmit('print');post('csvprint.monthreport')" name="print" />
			</p>
		</div>
		<div class="footer">
<%= commonBean.getCopyRight() %>
		</div>
	</form>
</body>
</html>