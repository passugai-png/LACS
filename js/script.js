var executeSw = true;

function prepared(){
	executeSw = false;
}

function post(piURL){
	if(!executeSw){
		executeSw = true;
		var obj = getObject("frm")[0];

		var dt = new Date();
		
		var oneTime = parseInt(dt.getYear() + dt.getMonth() + dt.getDate() + dt.getHours() + dt.getMinutes() + dt.getSeconds() * Math.random() * Math.random() * 1000000000);

		obj.action = piURL + "?" + oneTime;
		obj.method = "post";
		obj.submit();

		return true;
	}
	else{
		return false;
	}
}

function openWindow(piURL){
	window.open(piURL);
}

function getObject(piName){
	return document.getElementsByName(piName);
}

function setPage(piPage,piNext){
	document.all["nextPage"].value = piPage;
	post(piNext);
}

function setComboPage(piCombo, piNext){
	setPage(piCombo.value, piNext);
}

function setKeiyaku(piNext, piKeiyakuNo, piHyoujiKeiyakuNo, piBukkenNo, piBukkenEdaNo, piLeasCompany, piTradeHanteiKekka, piPageFrom){
	document.all["selKeiyakuNo"].value = piKeiyakuNo;
	document.all["selHyoujiKeiyakuNo"].value = piHyoujiKeiyakuNo;

	if(piBukkenNo != null){
		document.all["selBukkenNo"].value = piBukkenNo;
		document.all["selBukkenEdaNo"].value = piBukkenEdaNo;
	}

	document.all["selLeasCompany"].value = piLeasCompany;
	document.all["selTradeHanteiKekka"].value = piTradeHanteiKekka;

	document.all["selPageFrom"].value = piPageFrom;

	post(piNext);
}

function printKeiyaku(piNext, piKeiyakuNo, piHyoujiKeiyakuNo, piBukkenNo, piBukkenEdaNo, piLeasCompany, piTradeHanteiKekka, piPageFrom){
	if(!executeSw){
		executeSw = true;
		var subFrame = document.all["printFrm"].document.all["frm"];
		subFrame.all["selKeiyakuNo"].value = piKeiyakuNo;
		subFrame.all["selHyoujiKeiyakuNo"].value = piHyoujiKeiyakuNo;

		if(piBukkenNo != null){
			subFrame.all["selBukkenNo"].value = piBukkenNo;
			subFrame.all["selBukkenEdaNo"].value = piBukkenEdaNo;
		}

		subFrame.all["selLeasCompany"].value = piLeasCompany;
		subFrame.all["selTradeHanteiKekka"].value = piTradeHanteiKekka;

		subFrame.all["selPageFrom"].value = piPageFrom;

		subFrame.action = piNext;
		subFrame.method = "post";
		subFrame.target = "printFrm";
		subFrame.submit();
		subFrame.target = "_self";
	}
}
function newCompany(piNext){
	getObject("frm")[0].reset();
	document.all["targetCompanyCode"].value = "";
	document.all["procMode"].value = 1;
	post(piNext);
}
function editCompany(piNext, piLeasCompanyCode){
	getObject("frm")[0].reset();
	document.all["targetCompanyCode"].value = piLeasCompanyCode;
	document.all["procMode"].value = 2;
	post(piNext);
}
function deleteCompany(piNext, piLeasCompanyCode){
	if(kakuninDelete()){
		getObject("frm")[0].reset();
		document.all["targetCompanyCode"].value = piLeasCompanyCode;
		post(piNext);
	}
}

function newCompanyUser(piNext){
	getObject("frm")[0].reset();
	document.all["targetCompanyCode"].value = "";
	document.all["targetTorihikiCode"].value = "";
	document.all["procMode"].value = 1;
	post(piNext);
}
function editCompanyUser(piNext, piLeasCompanyCode, piTorihikiCode){
	getObject("frm")[0].reset();
	document.all["targetCompanyCode"].value = piLeasCompanyCode;
	document.all["targetTorihikiCode"].value = piTorihikiCode;
	document.all["procMode"].value = 2;
	post(piNext);
}
function deleteCompanyUser(piNext, piLeasCompanyCode, piTorihikiCode){
	if(kakuninDelete()){
		getObject("frm")[0].reset();
		document.all["targetCompanyCode"].value = piLeasCompanyCode;
		document.all["targetTorihikiCode"].value = piTorihikiCode;
		post(piNext);
	}
}

function newUser(piNext){
	getObject("frm")[0].reset();
	document.all["targetCosmosCode"].value = "";
	document.all["procMode"].value = 1;
	post(piNext);
}
function editUser(piNext, piCosmosCode){
	getObject("frm")[0].reset();
	document.all["targetCosmosCode"].value = piCosmosCode;
	document.all["procMode"].value = 2;
	post(piNext);
}
function deleteUser(piNext, piCosmosCode){
	if(kakuninDelete()){
		getObject("frm")[0].reset();
		document.all["targetCosmosCode"].value = piCosmosCode;
		post(piNext);
	}
}

function newTanto(piNext, piUserRightMode){
	getObject("frm")[0].reset();
	document.all["targetUserID"].value = "";
	document.all["procMode"].value = 1;
	document.all["userRightMode"].value = piUserRightMode;
	post(piNext);
}
function editTanto(piNext, piUserId, piUserRightMode){
	getObject("frm")[0].reset();
	document.all["targetUserID"].value = piUserId;
	document.all["procMode"].value = 2;
	document.all["userRightMode"].value = piUserRightMode;
	post(piNext);
}
function deleteTanto(piNext, piUserId){
	if(kakuninDelete()){
		getObject("frm")[0].reset();
		document.all["targetUserID"].value = piUserId;
		post(piNext);
	}
}
function filterTanto(piNext, piIndex){
	document.all["filterIndex"].value = piIndex;
	post(piNext);
}

function newKariRisi(piNext){
	getObject("frm")[0].reset();
	document.all["targetCosmosCode"].value = "";
	document.all["procMode"].value = 1;
	post(piNext);
}
function editKariRisi(piNext, piCosmosCode){
	getObject("frm")[0].reset();
	document.all["targetCosmosCode"].value = piCosmosCode;
	document.all["procMode"].value = 2;
	post(piNext);
}
function deleteKariRisi(piNext, piCosmosCode){
	if(kakuninDelete()){
		getObject("frm")[0].reset();
		document.all["targetCosmosCode"].value = piCosmosCode;
		post(piNext);
	}
}
function editCompulsoryChange(piNext, piKeiyakuNo,piYukoMukoKbn){
	if(kakuninEdit()){
		getObject("frm")[0].reset();
		document.all["selKeiyakuNo"].value = piKeiyakuNo;
		document.all["selYukoMukoKbn"].value = piYukoMukoKbn;
		post(piNext);
	}
}
function newInfo(piNext){
	getObject("frm")[0].reset();
	document.all["targetRowId"].value = "";
	document.all["procMode"].value = 1;
	post(piNext);
}
function editInfo(piNext, piRowId){
	getObject("frm")[0].reset();
	document.all["targetRowId"].value = piRowId;
	document.all["procMode"].value = 2;
	post(piNext);
}
function deleteInfo(piNext, piRowId){
	if(kakuninDelete()){
		getObject("frm")[0].reset();
		document.all["targetRowId"].value = piRowId;
		post(piNext);
	}
}



function kakuninRegist(piNext){
	if(window.confirm('登録します。よろしいですか？')){
		execSubmit('regist');
		post(piNext);
	}
}
function kakuninDelete(){
	return window.confirm('選択されたレコードを削除します。よろしいですか？');
}
function kakuninEdit(){
	return window.confirm('選択されたレコードを変更します。よろしいですか？');
}

/**
 * 帳票出力：和暦から西暦に変換
 *
 * @param 期首年
 * @param 西暦和暦コード
 *
*/
function convertToSeireki(piKisyuYear, piDateMode){
	var rtn = piKisyuYear;
	if (piDateMode == "2"){
		switch (document.all["kisyuEra"].value){
			case "1":	// 昭和
				rtn = (parseInt(piKisyuYear) + 1925).toString();
				break;
			case "2":	// 平成
				rtn = (parseInt(piKisyuYear) + 1988).toString();
				break;
			default:
		}
	}
	return rtn
}

/**
 * 帳票出力：西暦から和暦に変換
 *
 * @param 期首年
 * @param 西暦和暦コード
 *
*/
function convertToWareki(piSeireki, piDateMode){
	var rtn = piSeireki;
	if (piDateMode == "2"){
		// 平成
		if (piSeireki >= "1989/01/08"){
		    rtn = "H" + (parseInt(piSeireki.substring(0, 4)) - 1988).toString() + piSeireki.substring(4, 10);
	 	}
		// 昭和
	 	else if (piSeireki >= "1926/12/25"){
		    rtn = "S" + (parseInt(piSeireki.substring(0, 4)) - 1925).toString() + piSeireki.substring(4, 10);
		}
 	}
	return rtn
}

/**
 * 契約検索：入力可否設定
 *
 * @param なし
 *
 */
 function setDisableKeiyakuAmtChk(){
 	if (document.all["keiyakuAmtChk"].checked==true) {
 		document.all["keiyakuAmt"].disabled=false; }
 	else {
 		document.all["keiyakuAmt"].value="";
 		document.all["keiyakuAmt"].disabled=true;
 	}
 }
 function setDisableKeiyakuTermChk(){
 	if (document.all["keiyakuTermChk"].checked==true) {
 		document.all["keiyakuTerm"].disabled=false; }
 	else {
 		document.all["keiyakuTerm"].value="";
 		document.all["keiyakuTerm"].disabled=true;
 	}
 }

/**
 * 数値チェック
 *
 * @param 値
 *
 */
function isNumber(piValue){
	return !(piValue.match(/[^0-9]/g));
}

/**
 * 全角数字→半角数字への変換
 *
 * @param 値
 *
 */
function toHankakuNum(piValue){
	han = "0123456789";
	zen = "０１２３４５６７８９";
	str = "";
	for(i = 0; i < piValue.length; i++){
		c = piValue.charAt(i);
		n = zen.indexOf(c,0);
		if(n >= 0){
			c = han.charAt(n);
		}
		str += c;
	}
	return str;
}

/**
 * 二度押し対応
 *
 * @param ボタンオブジェクト名
 *
 */
function execSubmit(piObjName){
	document.all[piObjName].disabled = true;
}


/**
 * リースユーザ担当者マスタ：次回期限取得
 *
*/
function setTantojikaiKigen(){
 	if (!isNaN(document.all["yukoKikan"].value) && (trim(document.all["yukoKikan"].value)!="")) {
	 	if (trim(document.all["jikaiKigen"].value)=="") {
			now=new Date();
			now.setMonth(now.getMonth()+Number(document.all["yukoKikan"].value)) ;
			yy=now.getYear().toString().substr(0,4);
			mm=(now.getMonth()+1).toString();
			dd=now.getDate().toString();
			yymmdd=yy
			if(Number(mm)<10){
				yymmdd+="0"+mm;
			} else {
				yymmdd+=mm;
			}
			if(Number(dd)<10){
				yymmdd+="0"+dd;
			} else {
				yymmdd+=dd;
			}
			document.all["jikaiKigen"].value=yymmdd;
	 	}
 	}
}

/**
 * リースユーザ担当者マスタ：パスワード有効期間取得
 *
*/
function setTantoyukoKikan(){
 	if (!isNaN(document.all["jikaiKigen"].value) && (document.all["jikaiKigen"].value.length == 8)) {
	 	if (trim(document.all["yukoKikan"].value)=="") {
			now=new Date();
			yy2=now.getYear().toString().substr(0,4);
			mm2=(now.getMonth()+1).toString();
			if (Number(document.all["jikaiKigen"].value.substr(4,2)) >= 1 && Number(document.all["jikaiKigen"].value.substr(4,2)) <= 12){
				d = new Date(document.all["jikaiKigen"].value.substr(0,4) + "/" + document.all["jikaiKigen"].value.substr(4,2) + "/" + document.all["jikaiKigen"].value.substr(6,2));
				yy1=d.getYear().toString().substr(0,4);
				mm1=(d.getMonth()+1).toString();
				yy = Number(yy1) - Number(yy2);
				mm = Number(mm1) - Number(mm2);
				sa = yy * 12 + mm
				if (sa > 999){
					sa = 999;
				}
				if (sa > 0){
					document.all["yukoKikan"].value=String(sa);
				}
			}
	 	}
 	}
}

/**
 * 文字列のTRIM
 *
 * @param 文字列
 *
 */
function trim(argValue){
    return String(argValue).replace(/^[ 　]*/gim, "").replace(/[ 　]*$/gim, "");
}

// 購入額非通知時にアラートを表示
function checkKnuAmtTutiUmFlg(){
	var oldObj = getObject("oldKnuAmtTutiUmFlg");
	var newObj = getObject("newKnuAmtTutiUmFlg");

	var dialog = false;

	var i = 0;

	for(i = 0 ; i < oldObj.length ; i++){
		if(oldObj[i].checked && oldObj[i].value == "1"){
			dialog = true;
		}
	}

	for(i = 0 ; i < newObj.length ; i++){
		if(newObj[i].checked && newObj[i].value == "1"){
			dialog = true;
		}
	}
	
	if(dialog){
		alert("購入通知有無の非通知を選択する場合は、借入利子率の設定画面での設定が必要となります。");
	}
}

function unlockTanto(piNext, piUserId){
	if(kakuninOpereation('解除')){
		getObject("frm")[0].reset();
		document.all["targetUserID"].value = piUserId;
		post(piNext);
	}
}

function kakuninOpereation(piOpereation){
	return window.confirm('選択されたレコードを' + piOpereation + 'します。よろしいですか？');
}

function tantoKakuninRegist(piNext, piUserRight){
	
	if(3 != piUserRight){
		alert('開示先を再度確認願います。');
	}
	if(window.confirm('登録します。よろしいですか？')){
		execSubmit('regist');
		post(piNext);
	}
}
