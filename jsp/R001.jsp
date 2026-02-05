<%@ page language="java"
	contentType="text/html;charset=windows-31j"
	import="jp.co.pro_app.lacs.affairs.report.html.*"
	import="jp.co.pro_app.lacs.common.define.LACSDefine"
%>
<jsp:useBean id="commonBean" scope="session" class="jp.co.pro_app.lacs.affairs.common.bean.LACSCommonBean" />
<jsp:useBean id="reportBean" scope="session" class="jp.co.pro_app.lacs.affairs.report.bean.LACSReportBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Language" content="ja"/>
	<title>注記帳票出力</title>
	<link href="css/style.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/script.js"></script>
	<script language="javascript" src="js/report.js"></script>
</head>
<body onload="javascript:prepared();setFocus(<%= reportBean.getNextFocus() %>)">
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
<%= LACSReportHTMLUtil.outHTMLHeader(commonBean) %>
		</div>
		<div class="main">
<%= reportBean.getMessage() %>
			<div class="function-title">出力条件</div>
			<div class="disclosure-recipient">
<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY || commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_FIXED_USER){ %>
	<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) { %>
				<span class="font-red">* </span>
	<% } %>
				開示先：
<% } else{ %>
				リース会社：
<% } %>
			
<% if(commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY) { %>
				<input type="text" class="textbox-nine" name="leasCompanyNm"  value="<%= LACSReportHTMLUtil.encode(reportBean.getLeasCompanyNm()) %>" />
				<input type="button" class="button" value="絞　込" onclick="post('filter.report')" />
				<select class="pulldown-six" name="leasCompany" onchange = "post('usersearch.report')">
<%= LACSReportHTMLUtil.outHTMLCombo(reportBean.getLeasCompany())%>
				</select>
<% } else { %>
				<input type="hidden" value="<%= LACSReportHTMLUtil.encode(reportBean.getLeasCompany().getValue()) %>" name="leasCompany" /><%= LACSReportHTMLUtil.encode(reportBean.getLeasCompany().getName()) %>
<% } %>
			</div>
			<div class="section">契約番号：
				<input class="textbox-seven" type="text" value="<%= LACSReportHTMLUtil.encode(reportBean.getKeiyakuNo()) %>" maxlength="20" name="keiyakuNo" />
				<span class="section">物件番号：
					<input class="textbox-seven" type="text" value="<%= LACSReportHTMLUtil.encode(reportBean.getBukkenNo()) %>" maxlength="20" name="bukkenNo" />
				</span>
			</div>				
			<div class="function-title">対象期間</div>
			<div class="section"><span class="font-red">* </span>開始日	
<%= LACSReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, reportBean.getTermFrom()) %>
			</div>
			<div class="quarter">
				<div class="quarter-input">			
					<div class="section">
						<label>
							<input type="radio" class="radiobutton" name="quarter" value="0" <%= reportBean.getQuarter().equals("0") ? "checked" : "" %>/>
							<input type="text" class="textbox-four" value="<%= LACSReportHTMLUtil.encode(reportBean.getTermNum0()) %>" maxlength="2" size="2" name="termNum0" onchange="focusNext(this)" />
							ヶ月
						</label>
					</div>
					<div class="section">
						<label>
							<input type="radio" class="radiobutton" name="quarter" value="1" <%= reportBean.getQuarter().equals("1") ? "checked" : "" %>/>
							<input type="hidden" value="3" name="termNum1"/>
							第１四半期
						</label>						
					</div>
					<div class="section">
						<label>
							<input type="radio" class="radiobutton" name="quarter" value="2" <%= reportBean.getQuarter().equals("2") ? "checked" : "" %>/>
							<input type="hidden" value="6" name="termNum2"/>
							半期
						</label>
					</div>
					<div class="section">
						<label>
							<input type="radio" class="radiobutton" name="quarter" value="3" <%= reportBean.getQuarter().equals("3") ? "checked" : "" %>/>
							<input type="hidden" value="9" name="termNum3"/>
							第３四半期
						</label>
					</div>
					<div class="section">
						<label>
							<input type="radio" class="radiobutton" name="quarter" value="4" <%= reportBean.getQuarter().equals("4") ? "checked" : "" %>/>
							<input type="hidden" value="12" name="termNum4"/>
							通期
						</label>
					</div>
				</div>
				<div class="quarter-date">
					<div class="section">（ <%= LACSReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, reportBean.getTermTo0()) %>）</div>
					<div class="section">（ <%= LACSReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, reportBean.getTermTo1()) %>）</div>
					<div class="section">（ <%= LACSReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, reportBean.getTermTo2()) %>）</div>
					<div class="section">（ <%= LACSReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, reportBean.getTermTo3()) %>）</div>
					<div class="section">（ <%= LACSReportHTMLUtil.outHTMLDateInputFieldYMD(commonBean, reportBean.getTermTo4()) %>）</div>
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
					<div class="accounting-standard-of-exttaction">旧会計基準
						<div class="input-group-row">
							<div class="input-group-col">
								<span class="section">少額資産</span>
								<span class="section">リース期間１年未満</span>
								<span class="section">再リース契約</span>
								<span class="section">中途解約物件</span>
							</div>
							<div class="input-group-col">
								<span class="section">
									<label><input type="radio" class="radiobutton" name="oldkeiyakuGaku" value="0" <%= reportBean.getOldKeiyakuGaku().equals("0") ? "checked" : "" %>/>除く</label>
									<label><input type="radio" class="radiobutton" name="oldkeiyakuGaku" value="1" <%= reportBean.getOldKeiyakuGaku().equals("1") ? "checked" : "" %>/>除かない</label>
								</span>	
								<span class="section">
									<label><input type="radio" class="radiobutton" name="oldleaseKikan" value="0" <%= reportBean.getOldLeaseKikan().equals("0") ? "checked" : "" %>/>除く</label>
									<label><input type="radio" class="radiobutton" name="oldleaseKikan" value="1" <%= reportBean.getOldLeaseKikan().equals("1") ? "checked" : "" %>/>除かない</label>
								</span>				
								<span class="section">
									<label><input type="radio" class="radiobutton" name="oldsaiLease" value="0" <%= reportBean.getOldSaiLease().equals("0") ? "checked" : "" %>/>除く</label>
									<label><input type="radio" class="radiobutton" name="oldsaiLease" value="1" <%= reportBean.getOldSaiLease().equals("1") ? "checked" : "" %>/>除かない</label>
								</span>
								<span class="section">
									<label><input type="radio" class="radiobutton" name="oldtyutoKaiyaku" value="0" <%= reportBean.getOldTyutoKaiyaku().equals("0") ? "checked" : "" %>/>除く</label>
									<label><input type="radio" class="radiobutton" name="oldtyutoKaiyaku" value="1" <%= reportBean.getOldTyutoKaiyaku().equals("1") ? "checked" : "" %>/>除かない</label>
								</span>				
							</div>
						</div>
					</div>
					<div class="accounting-standard-of-exttaction">新会計基準
						<div class="input-group-row">
							<div class="input-group-col">
								<span class="section">少額資産</span>
								<span class="section">リース期間１年以内</span>
								<span class="section">再リース契約</span>
								<span class="section">中途解約物件</span>
							</div>
							<div class="input-group-col">
								<span class="section">
									<label><input type="radio" class="radiobutton" name="newkeiyakuGaku" value="0" <%= reportBean.getNewKeiyakuGaku().equals("0") ? "checked" : "" %>/>除く</label>
									<label><input type="radio" class="radiobutton" name="newkeiyakuGaku" value="1" <%= reportBean.getNewKeiyakuGaku().equals("1") ? "checked" : "" %>/>除かない</label>
								</span>
								<span class="section">
									<label><input type="radio" class="radiobutton" name="newleaseKikan" value="0" <%= reportBean.getNewLeaseKikan().equals("0") ? "checked" : "" %>/>除く</label>
									<label><input type="radio" class="radiobutton" name="newleaseKikan" value="1" <%= reportBean.getNewLeaseKikan().equals("1") ? "checked" : "" %>/>除かない</label>
								</span>
								<span class="section">
									<label><input type="radio" class="radiobutton" name="newsaiLease" value="0" <%= reportBean.getNewSaiLease().equals("0") ? "checked" : "" %>/>除く</label>
									<label><input type="radio" class="radiobutton" name="newsaiLease" value="1" <%= reportBean.getNewSaiLease().equals("1") ? "checked" : "" %>/>除かない</label>
								</span>
								<span class="section">
									<label><input type="radio" class="radiobutton" name="newtyutoKaiyaku" value="0" <%= reportBean.getNewTyutoKaiyaku().equals("0") ? "checked" : "" %>/>除く</label>
									<label><input type="radio" class="radiobutton" name="newtyutoKaiyaku" value="1" <%= reportBean.getNewTyutoKaiyaku().equals("1") ? "checked" : "" %>/>除かない</label>
								</span>
							</div>
						</div>
					</div>
				</div>
				<div class="output-target-form">
					<div class="function-title">出力対象帳票</div>
					<div class="section">
<% if (commonBean.getDispControl().isAvailable("P0000005")) { %>
						<div class="section">
							<label>
								<input type="checkbox" class="checkbox" name="chkSchedule" value="1" <%= reportBean.getSchedule().getCheckOutput() == 1 ? "checked" : "" %> <%= commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY ? "" : "onclick=\"setDisableReportGamen()\"" %>/>
								<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getSchedule(), "リース料支払スケジュール表（物件単位）", "schedule") %>
							</label>
						</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000004")) { %>
						<div class="section">
							<label>
								<input type="checkbox" class="checkbox" name="chkTyuki" value="1" <%= reportBean.getTyuki().getCheckOutput() == 1 ? "checked" : "" %> <%= commonBean.getAppMode() == LACSDefine.AppMode.APP_MODE_COMPANY ? "" : "onclick=\"setDisableReportGamen()\"" %>/>
								<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getTyuki(), "注記書類作成基準書", "Tyuki") %>
							</label>
						</div>
<% } %>
					</div>
					<div class="accounting-standard-of-output-target-form">
<% if (reportBean.getOldACCount() > 0){ %>
						<div class="input-group-col">旧会計基準
<% if (commonBean.getDispControl().isAvailable("P0000001")) { %>
							<div class="section">
								<label>
									<input type="checkbox" class="checkbox" name="chkGoukeiOld" value="1" <%= reportBean.getGoukeiOld().getCheckOutput() == 1 && reportBean.getOldACCount() != 0 ? "checked" : "" %> <%= reportBean.getOldACCount() == 0 ? "disabled" : "" %>/>
									<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getGoukeiOld(), "リース契約注記合計表", "goukeiOld") %>
								</label>
							</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000007")) { %>
							<div class="section">
								<label>
									<input type="checkbox" class="checkbox" name="chkMikeikaBOld" value="1" <%= reportBean.getMikeikaBOld().getCheckOutput() == 1 && reportBean.getOldACCount() != 0 ? "checked" : "" %> <%= reportBean.getOldACCount() == 0 ? "disabled" : "" %>/>
									<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getMikeikaBOld(), "未経過リース料期末残高別表", "mikeikaBOld") %>
								</label>
							</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000002")) { %>
							<div class="section">
								<label>
									<input type="checkbox" class="checkbox" name="chkGenkaOld" value="1" <%= reportBean.getGenkaOld().getCheckOutput() == 1 ? "checked" : "" %>/>
									<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getGenkaOld(), "リース会計資料（減価償却費）", "genkaOld") %>
								</label>
							</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000003")) { %>
							<div class="section">
								<label>
									<input type="checkbox" class="checkbox" name="chkShiharaiOld" value="1" <%= reportBean.getShiharaiOld().getCheckOutput() == 1 ? "checked" : "" %>/>
									<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getShiharaiOld(), "リース会計資料（支払リース料等）", "shiharaiOld") %>													
								</label>
							</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000032")) { %>
							<div class="section">
								<label>
									<input type="checkbox" class="checkbox" name="chkKizituGoukeiOld" value="1" <%= reportBean.getKizituGoukeiOld().getCheckOutput() == 1 ? "checked" : "" %>/>	
									<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getKizituGoukeiOld(), "期日別予定表（合計表）", "kizituGoukeiOld") %>
								</label>
							</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000033")) { %>
							<div class="section">
								<label>
									<input type="checkbox" class="checkbox" name="chkKizituSaimuOld" value="1" <%= reportBean.getKizituSaimuOld().getCheckOutput() == 1 ? "checked" : "" %>/>
									<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getKizituSaimuOld(), "期日別予定表（債務）", "kizituSaimuOld") %>
								</label>
							</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000034")) { %>
							<div class="section">
								<label>
									<input type="checkbox" class="checkbox" name="chkKizituSisanOld" value="1" <%= reportBean.getKizituSisanOld().getCheckOutput() == 1 ? "checked" : "" %>/>
									<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getKizituSisanOld(), "期日別予定表（資産）", "kizituSisanOld") %>
								</label>
							</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000006")) { %>
							<div class="section">
								<label>
									<input type="checkbox" class="checkbox" name="chkGensenOld" value="1" <%= reportBean.getGensenOld().getCheckOutput() == 1 ? "checked" : "" %>/>
									<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getGensenOld(), "注記源泉情報(CSV作成のみ)", "gensenOld") %>
								</label>
							</div>
<% } %>							
						</div>										
<% } %>			
<% if (reportBean.getNewACCount() > 0){ %>
						<div class="input-group-col">新会計基準
<% if (commonBean.getDispControl().isAvailable("P0000001")) { %>
							<div class="section">
								<label>
									<input type="checkbox" class="checkbox" name="chkGoukeiNew" value="1" <%= reportBean.getGoukeiNew().getCheckOutput() == 1 && reportBean.getNewACCount() != 0 ? "checked" : "" %> <%= reportBean.getNewACCount() == 0 ? "disabled" : "" %>/>		
									<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getGoukeiNew(), "リース契約注記合計表", "goukeiNew") %>
								</label>
							</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000007")) { %>
							<div class="section">
								<label>
									<input type="checkbox" class="checkbox" name="chkMikeikaBNew" value="1" <%= reportBean.getMikeikaBNew().getCheckOutput() == 1 && reportBean.getNewACCount() != 0 ? "checked" : "" %> <%= reportBean.getNewACCount() == 0 ? "disabled" : "" %>/>
									<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getMikeikaBNew(), "未経過リース料期末残高別表", "mikeikaBNew") %>
								</label>
							</div>										
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000002")) { %>
							<div class="section">
								<label>
									<input type="checkbox" class="checkbox" name="chkGenkaNew" value="1" <%= reportBean.getGenkaNew().getCheckOutput() == 1 ? "checked" : "" %>/>
									<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getGenkaNew(), "リース会計資料（減価償却費）", "genkaNew") %>
								</label>
							</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000003")) { %>
							<div class="section">
								<label>
									<input type="checkbox" class="checkbox" name="chkShiharaiNew" value="1" <%= reportBean.getShiharaiNew().getCheckOutput() == 1 ? "checked" : "" %>/>
									<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getShiharaiNew(), "リース会計資料（支払リース料等）", "ghiharaiNew") %>
								</label>
							</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000032")) { %>
							<div class="section">
								<label>
									<input type="checkbox" class="checkbox" name="chkKizituGoukeiNew" value="1" <%= reportBean.getKizituGoukeiNew().getCheckOutput() == 1 ? "checked" : "" %>/>
									<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getKizituGoukeiNew(), "期日別予定表（合計表）", "kizituGoukeiNew") %>
								</label>
							</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000033")) { %>
							<div class="section">
								<label>	
									<input type="checkbox" class="checkbox" name="chkKizituSaimuNew" value="1" <%= reportBean.getKizituSaimuNew().getCheckOutput() == 1 ? "checked" : "" %>/>
									<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getKizituSaimuNew(), "期日別予定表（債務）", "kizituSaimuNew") %>
								</label>
							</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000034")) { %>
							<div class="section">
								<label>
									<input type="checkbox" class="checkbox" name="chkKizituSisanNew" value="1" <%= reportBean.getKizituSisanNew().getCheckOutput() == 1 ? "checked" : "" %>/>
									<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getKizituSisanNew(), "期日別予定表（資産）", "kizituSisanNew") %>
								</label>
							</div>
<% } %>
<% if (commonBean.getDispControl().isAvailable("P0000006")) { %>
							<div class="section">
								<label>
									<input type="checkbox" class="checkbox" name="chkGensenNew" value="1" <%= reportBean.getGensenNew().getCheckOutput() == 1 ? "checked" : "" %>/>
									<%= LACSReportHTMLUtil.outHTMLPdfPath(reportBean, reportBean.getGensenNew(), "注記源泉情報(CSV作成のみ)", "gensenNew") %>
								</label>
							</div>
<% } %>
						</div>
<% } %>	
					</div>
				</div>
			</div>
				<div class="section">
					<div class="function-title">計算方法</div>
					<div class="section">
						会計処理方法
						<label><input type="radio" class="radiobutton" name="kaikeiSyori" value="0" <%= reportBean.getKaikeiSyori().equals("0") ? "checked" : "" %>/>詳細注記</label>
						<label><input type="radio" class="radiobutton" name="kaikeiSyori" value="1" <%= reportBean.getKaikeiSyori().equals("1") ? "checked" : "" %>/>簡略注記</label>
					</div>
<% if(commonBean.isShowKaiKnoOpt()) { %>
					<div class="section">
						解約可能期間<br />
						未経過リース料
						<label><input type="radio" class="radiobutton" name="kaiknoTermkei" value="0" <%= reportBean.getkaiknoTermkei().equals("0") ? "checked" : "" %>/>計上しない</label>
						<label><input type="radio" class="radiobutton" name="kaiknoTermkei" value="1" <%= reportBean.getkaiknoTermkei().equals("1") ? "checked" : "" %>/>計上する</label>
					</div>
<% } %>
				</div>
<% if(commonBean.isShowSumUnt()) { %>				
				<div class="section">
					<div class="function-title">集計単位</div>
					<div class="section">
						旧会計基準
						<label><input type="radio" class="radiobutton" name="oldSumUnt" value="0" <%= reportBean.getOldSumUnt().equals("0") ? "checked" : "" %>/>契約単位</label>
						<label><input type="radio" class="radiobutton" name="oldSumUnt" value="1" <%= reportBean.getOldSumUnt().equals("1") ? "checked" : "" %>/>資産単位</label>	
					</div>
					<div class="section">
						新会計基準
						<label><input type="radio" class="radiobutton" name="newSumUnt" value="0" <%= reportBean.getNewSumUnt().equals("0") ? "checked" : "" %>/>契約単位</label>
						<label><input type="radio" class="radiobutton" name="newSumUnt" value="1" <%= reportBean.getNewSumUnt().equals("1") ? "checked" : "" %>/>資産単位</label>
					</div>
				</div>
<% } %>					
				<p class="command-button">
					<input type="button" class="button" value="帳票印刷" onclick="setWaitScreen();execSubmit('print');post('pdfprint.report')" name="print" />
					<input type="button" class="button" value="CSV作成" onclick="setWaitScreen();execSubmit('print');post('csvprint.report')" name="print" />
				</p>
			</div>

			<div class="footer">
<%= commonBean.getCopyRight() %>
			</div>
		</form>
	</body>
</html>