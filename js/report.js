
/**
 * 帳票出力：入力可否設定
 *
 * @param なし
 *
 */
function setDisableReportGamen(){
 	if (document.all["reportBukken"].checked==true) {
 		document.all["leasCompany"].disabled=false;
 		document.all["bukkenNo"].disabled=false;
 		document.all["keiyakuNo"].disabled=false;
 		document.all["bukkenEdaNo"].disabled=false;
 	}
 	else {
 		document.all["leasCompany"].value="";
 		document.all["bukkenNo"].value="";
 		document.all["keiyakuNo"].value="";
 		document.all["bukkenEdaNo"].value="";
  		document.all["leasCompany"].disabled=true;
  		document.all["bukkenNo"].disabled=true;
  		document.all["keiyakuNo"].disabled=true;
  		document.all["bukkenEdaNo"].disabled=true;
  	}
 }

/**
 * 帳票出力：PDFファイルOPEN
 *
 * @param URL
 * @param ウィンドウ名
 * @param 画面サイズ
 *
 */
function openPDF(piUrl, piWindowName){
    var screen_width = screen.width - 10;
    var screen_height = screen.height - 54;
    var str = "left=0,top=0,width=" + screen_width + ",height=" + screen_height + ",";
    str += "toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes";

    windowname=window.open(piUrl, piWindowName, str );
}

function focusNext(piObject){
	var num = 0;

	switch(piObject.name){
		case "termFromData":
			num = 1;
			break;
		case "termFromMonth":
			num = 2;
			break;
		case "termFromDay":
			num = 3;
			break;
		case "termNum":
			num = 4;
			break;
		default:
			num = 0;
	}

	getObject("nextFocus")[0].value = num;
	post('termchange.report');
}

function focusNextM(piObject){
	var num = 0;

	switch(piObject.name){
		case "termFromData":
			num = 1;
			break;
		case "termFromMonth":
			num = 2;
			break;
		case "termFromDay":
			num = 3;
			break;
		case "termNum":
			num = 4;
			break;
		default:
			num = 0;
	}

	getObject("nextFocus")[0].value = num;
	post('termchange.monthreport');
}

function focusNextNS(piObject){
	var num = 0;

	switch(piObject.name){
		case "termFromData":
			num = 1;
			break;
		case "termFromMonth":
			num = 2;
			break;
		case "termNum":
			num = 3;
			break;
		default:
			num = 0;
	}

	getObject("nextFocus")[0].value = num;
	post('termchange.nsreport');
}

function setFocusNS(piNum){
	var obj = null;
	var idx = 0;

	switch(piNum){
		case 1:
			obj = getObject("termFromMonth")[0];
			break;
		case 2:
			var rdo = getObject("quarter");
			for(idx = 0 ; idx < rdo.length ; idx++){
				if(rdo[idx].checked){
					obj = rdo[idx];
				}
			}
			break;
		case 0:
			return;
	}

	obj.focus();
	obj.select();
}


function setFocus(piNum){
	var obj = null;
	var idx = 0;

	switch(piNum){
		case 1:
			obj = getObject("termFromMonth")[0];
			break;
		case 2:
			obj = getObject("termFromDay")[0];
			break;
		case 3:
			var rdo = getObject("quarter");
			for(idx = 0 ; idx < rdo.length ; idx++){
				if(rdo[idx].checked){
					obj = rdo[idx];
				}
			}
			break;
		case 4:
			var rdo = getObject("keiyakuGaku");
			for(idx = 0 ; idx < rdo.length ; idx++){
				if(rdo[idx].checked){
					obj = rdo[idx];
				}
			}
			break;
		case 0:
			return;
	}

	obj.focus();
	obj.select();
}

function focusNextDS(piObject){
	var num = 0;

	switch(piObject.name){
		case "termFromData":
			num = 1;
			break;
		case "termFromMonth":
			num = 2;
			break;
		default:
			num = 0;
	}

	getObject("nextFocus")[0].value = num;
	post('termchange.dsreport');
}

function setFocusDS(piNum){
	var obj = null;
	var idx = 0;

	switch(piNum){
		case 1:
			obj = getObject("termFromMonth")[0];
			break;
		case 2:
			var rdo = getObject("quarter");
			for(idx = 0 ; idx < rdo.length ; idx++){
				if(rdo[idx].checked){
					obj = rdo[idx];
				}
			}
			break;
		case 0:
			return;
	}

	obj.focus();
	obj.select();
}

function setWaitScreen(){
//	var waitScreen = getObject("waitScreen")[0];   del 2020/05/21
	var waitScreen = document.getElementById("waitScreen")
	var clientWidth = document.body.clientWidth;

	var center = Math.floor(clientWidth / 2);
	
	var left = center - 400;
	var str = "";
	var obj;

	waitScreen.style.width="800px";
	waitScreen.style.left=left + "px";
	waitScreen.style.display="";

	for(obj in waitScreen){
		str += obj + ":" + waitScreen[obj] + "\n";
	}
}

function downloadCSV(piName){
	getObject("csvName")[0].value=piName;

	if(post("csvdownload.report")){
		executeSw = false;
	}

	return false;
}
//2008/12/04 ACT Fukushima ADD START
function focusNextU(piObject){
	var num = 0;

	switch(piObject.name){
		case "termFromData":
			num = 1;
			break;
		case "termFromMonth":
			num = 2;
			break;
		case "termFromDay":
			num = 3;
			break;
		case "tsukiSu":
			num = 4;
			break;
		default:
			num = 0;
	}

	getObject("nextFocus")[0].value = num;
	post('termchange.ukebarai');
}

function setFocusU(piNum){
	var obj = null;
	var idx = 0;
	var sel = 1;

	switch(piNum){
		case 1:
			obj = getObject("termFromMonth")[0];
			break;
		case 2:
			obj = getObject("termFromDay")[0];
			break;
		case 3:
			obj = getObject("tsukiSu")[0];
			break;
		case 4:
			obj = getObject("searchButton")[0];
			sel = 0;
			break;
		case 0:
			return;
	}

	obj.focus();
	if(sel == 1){
		obj.select();
	}
}
//2008/12/04 ACT Fukushima ADD END

//2008/12/16 ACT Shimada ADD START

function onloadFunction(){
	var isIE = 0<=window.navigator.userAgent.indexOf("MSIE");
	if(isIE && document.compatMode=="BackCompat"){
		document.body.onscroll = scrollUKB;
	}else{
		document.documentElement.onscroll = scrollUKB;
	}
}

function setWaitScreenUKB(){
//	var waitScreen = getObject("waitScreen")[0];  2020/05/21
	var waitScreen = document.getElementById("waitScreen");
     waitScreen.style.top=document.documentElement.scrollTop + 100 + "px";
    
    setWaitScreen();
}

function scrollUKB(){

//	var waitScreen = getObject("waitScreen")[0];  2020/05/21
	var waitScreen = document.getElementById("waitScreen");
    
    if (waitScreen.style.display != "none") {
    
    	setWaitScreenUKB();
    	
    }

}
//2008/12/16 ACT Shimada ADD END