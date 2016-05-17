/*******************************************************************************
*业务js处理共通方法
********************************************************************************/
/*
*名       称: btn_applyFormDownload()
*输入参数: 无
*输出参数: 无
*机       能: 申请单下载
*创 建  者: yuliang          
*创建时间: 2016-01-08
*更 新  者: 
*更新时间: 
*/
function btn_applyFormDownload()
{
	//是否下载
	if(!window.confirm(Message.getString("MSG_IC_COMM_0006")))
	{
		return;
	}
	c_ShowProgressBar(3);
	$('#downloadForm').attr( "action", "applyFormDownload.do");
	$('#downloadForm').submit();
}
/*
名       称: checkTimeBgnEndDate(  dailystart, dailyend, dailystarthm, dailyendhm)
输入参数:  dailystart, dailyend, dailystarthm, dailyendhm
输出参数: true（合法）false（不合法）
机       能: check时间开始日是否大于结束日
创 建  者: yuliang          
创建时间: 2015-11-06
更 新  者:
更新时间:
*/
function checkTimeBgnEndDate( dailystart, dailyend, dailystarthm, dailyendhm){
	var startTime = (dailystart + dailystarthm).replace( /-/g, '').replace( /:/g, '');
	var endTime = (dailyend + dailyendhm).replace( /-/g, '').replace( /:/g, '');
	if(dailystart != "" && dailyend != "" && dailystarthm != "" && dailyendhm != ""){
		if(startTime > endTime){		
			return false;
		} 
	}
	return true;
}
/*
*名       称: c_ShowProgressBar(newtime)
*输入参数: newtime
*输出参数: 无
*机       能: 提交时显示“处理中，请稍候...”
*创 建  者:  yuliang          
*创建时间: 2015-10-12
*更 新  者:
*更新时间:
*/
function c_ShowProgressBar(newtime){
	if(true){
		c_DisAllButton();
		var loadDiv = document.createElement("div");
		loadDiv.id="loaddata";
		loadDiv.className="loaddivcss";
		loadDiv.innerHTML='<img align="absmiddle" src="'+contextPath+'/resources/images/loading.gif"/>&nbsp;<span style="text-align:center;">处理中，请稍候&hellip;&nbsp;&nbsp;</span>';
		document.body.appendChild(loadDiv);
		if(!isNaN(newtime)){
			newtime=newtime*1000;
		}else{
			newtime=undefined;
		}
		if(newtime!=undefined){
			setTimeout(
				function(){
					document.body.removeChild(loadDiv);
					c_EnableAllButton();
				},newtime);
		}
	}
}
/*
*名       称: c_DisAllButton
*输入参数: 无
*输出参数: 无
*机       能: 提交时，按钮disabled
*创 建  者: yuliang          
*创建时间: 2015-10-12
*更 新  者:
*更新时间:
*/
function c_DisAllButton(){
	var _treg = /^((submit)|(reset)|(button)){1}$/i;
	var tags = document.getElementsByTagName('input');
	var taglength = tags.length;
	for(var j=0;j<taglength;j++){
		var e=tags[j];
		if(new RegExp(_treg).test(e.type)){
			if(e.disabled==true){
				e.setAttribute("flg_disabled", "1");
			}
			e.disabled = true;
		}
	}
}
/*
*名       称: c_EnableAllButton
*输入参数: 无
*输出参数: 无
*机       能: 提交后，按钮enabled
*创 建  者: yuliang          
*创建时间: 2015-10-12
*更 新  者:
*更新时间:
*/
function c_EnableAllButton(){
	var _treg = /^((submit)|(reset)|(button)){1}$/i;
	var tags = document.getElementsByTagName('input');
	var taglength = tags.length;
	for(var j=0;j<taglength;j++){
		var e=tags[j];
		if(new RegExp(_treg).test(e.type)){
			e.disabled = false;
		}
		if(e.flg_disabled !=undefined) {
			if(e.flg_disabled == "1") {
				e.disabled = true;			
			}
		}
	}
}
/*
名       称: checkBgnEndDate()
输入参数: beginDate,endDate
输出参数: true（合法）false（不合法）
机       能: check开始日是否大于结束日
创 建  者: yuliang          
创建时间: 2015-10-27
更 新  者:
更新时间:
*/
function checkBgnEndDate( beginDate, endDate){
	var sdate = beginDate.replace( /-/g, '');
	var edate = endDate.replace( /-/g, '');
	if(sdate != "" && edate != ""){
		if(sdate > edate){		
			return false;
		} 
	}
	return true;
}
/*
名       称: 弹出子画面
输入参数: 当前对象
输出参数: 无
机       能: 共通调用
创 建   者: yuliang
创建时间: 2015-11-11
更 新  者: 
更新时间: 
*/
function selectZoom( url, obj) {	
	//alert(navigator.userAgent);
	if(navigator.userAgent.indexOf("Chrome") >0 ){
		;
	}
	var result = window.showModalDialog( url, obj, 'dialogWidth=700px;dialogHeight=500px');
	if (result == null) {
		return "";
	}
	return result;
}
/*
名       称: getDisplayName(obj)
输入参数: obj
输出参数: 无
机       能: 获取显示名称
创 建   者: yuliang
创建时间: 2015-11-11
更 新  者: 
更新时间: 
*/
function getDisplayName(obj) {
	var name_s = "";
	try {
	    name_s = Message.getString($(obj).attr("displayname"));	    
	} catch(e) {
	    name_s = $(obj).attr("displayname");
	}
	try {
	    name_s = Message.getString($(obj).attr("role"));	    
	} catch(e) {
	    name_s = $(obj).attr("role");
	}
	if (name_s == "" || name_s == null || name_s == undefined) {
		name_s = $(obj).parent().prev().find(".message").text();
	}
	return name_s;
}
/*
名       称: allowNumber(obj)
输入参数: DOM元素
输出参数: 结果
机       能: 只允许输入半角数字
创 建   者: yuliang
创建时间: 2015-11-11
更 新  者: 
更新时间: 
*/
function allowNumber(obj) {
	var value_b = true;
	if (event.keyCode >= 48 && event.keyCode <= 57) {
		value_b = true;
	} else {
		value_b = false;
	}
	event.returnValue = value_b;
}
/*
*名    称：浮点数加法
*输入参数：arg1,arg2
*输出参数：运算结果
*创 建 者：yuliang
*创建时间：2012-10-19
*更 新 者：
*更新时间：
*/
function dcmAdd(arg1,arg2) {
    var r1,r2,m;
    try{r1=arg1.toString().split(".")[1].length;}catch(e){r1=0;}
    try{r2=arg2.toString().split(".")[1].length;}catch(e){r2=0;}
    m=Math.pow(10,Math.max(r1,r2));
    return (dcmMul(arg1,m)+dcmMul(arg2,m))/m;
}
/*
*名    称：浮点数乘法
*输入参数：arg1,arg2
*输出参数：运算结果
*创 建 者：yuliang
*创建时间：2012-10-19
*更 新 者：
*更新时间：
*/
function dcmMul(arg1,arg2){
    var m=0,s1=arg1.toString(),s2=arg2.toString();
    try{m+=s1.split(".")[1].length;}catch(e){}
    try{m+=s2.split(".")[1].length;}catch(e){}
    return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m);
}
/*
*名    称：浮点数减法
*输入参数：arg1,arg2
*输出参数：运算结果
*创 建 者：yuliang
*创建时间：2012-10-19
*更 新 者：
*更新时间：
*/
function dcmSub(arg1,arg2) {
     return dcmAdd(arg1,-arg2);
}
/*
*名    称：对指定的数字进行格式化还原
*输入参数：DOM元素、格式化字符串
*输出参数：返回转换后的值
*创 建 者：yuliang
*创建时间：2012-10-19
*更 新 者：
*更新时间：
*/
function parseStringToNumber(obj) {
	return obj.replace(/,/g,"");
}
/*
*名    称：对指定的对象进行数字格式化
*输入参数：DOM元素、格式化字符串
*输出参数：结果
*创 建 者：yuliang
*创建时间：2012-10-19
*更 新 者：
*更新时间：
*/
function formatNumber(obj, formatstring) {	
    var val = $(obj).val();
    var length = formatstring.length;    
    if (val == '') {
        return;
    }        
    var index = val.indexOf("-");
    if(index != -1){
    	val = val.substr(1);
    }
    if (length == 12) {
         $(obj).val( Math.round(parseFloat(val)*1000000)/1000000 );
    }
    if (length == 10) {
         $(obj).val( Math.round(parseFloat(val)*10000)/10000 );
    }     
    if (length == 8) {
        $(obj).val( Math.round(parseFloat(val)*100)/100 );
    } 
	
	$(obj).format({format:formatstring});
	if(index != -1){
		$(obj).val('-'+$(obj).val());
	}
}
/*
*名    称：对指定的对象进行数字格式化还原
*输入参数：DOM元素、格式化字符串
*输出参数：结果
*创 建 者：yuliang
*创建时间：2012-10-19
*更 新 者：
*更新时间：
*/
function parseNumber(obj) {
    if ($(obj).val() != '') {
    	$(obj).val( $(obj).val().toString().replace(/,/g,""));
	}
}
/*
*名    称：只允许输入半角数字'.'
*输入参数：DOM元素
*输出参数：结果
*创 建 者：yuliang          
*创建时间：2012-02-09
*更 新 者：
*更新时间：
*/
function allowAmount(obj) {
    var dot_s = ".";
	var value_b = true;
	if (event.keyCode >= 48 && event.keyCode <= 57) {
		value_b = true;
	} else if (event.keyCode == 46 && $(obj).val().indexOf(dot_s) < 0) {
		value_b = true;
	} else {
		value_b = false;
	}
	event.returnValue = value_b;
}
/*
*名    称：只允许输入半角数字'.'、'-'
*输入参数：DOM元素
*输出参数：结果
*创 建 者：yuliang          
*创建时间：2014-02-09
*更 新 者：
*更新时间：
*/
function allowFloat(obj) {
    var amount_e = $(obj);
	var value_b = true;
	if(event.keyCode >= 48 && event.keyCode <= 57){
		value_b = true;
	} else if(event.keyCode == 46 && amount_e.val().indexOf(".") < 0){
		value_b = true;
	} else if(event.keyCode == 45 && amount_e.val().indexOf("-") < 0){
		value_b = true;
	} else{
		value_b = false;
	}
	event.returnValue = value_b;
}
/*
*名    称：moneyProcessSubmitDefault(formName)
*输入参数：表单名称
*输出参数：无
*机    能: 提交金额的格式化处理 为空项默认为0.00
*创 建 者：yuliang          
*创建时间：2014-02-10
*更 新 者：
*更新时间：
*/
function moneyProcessSubmitDefault(formName){
	$('form[name="'+formName+'"]').find(".input_money").each(function( i, n) {
	    var obj = n;
	    if ($(obj).val() == ''){
	        $(obj).val('0.00');
	    } else if(parseFloat($(obj).val()) == 0){
		   $(obj).val('0.00');
		} else{
		  parseNumber(this);
		}
	});
}

//
///*
//名    称：弹出子画面
//输入参数：当前对象
//输出参数：无
//机    能: 模块调用
//创 建 者：yuliang
//创建时间：2012-07-20
//更 新 者：
//更新时间：
//*/
//function selectZoomPage(action,actionname,width,height) {
//
//	var g_url = "com.mcl.common.ShowModalDialogPanel.flow?sysComm/action="+action+"&sysComm/_eosFlowAction="+actionname;
//	var result = $.openModalDialog(self,g_url,"",width,height);
//	
//	if (result == null) {
//		return "";
//	}
//	return result;
//}
//
///*
//名    称：弹出子画面
//输入参数：当前对象
//输出参数：无
//机    能: 共通调用
//创 建 者：yuliang
//创建时间：2012-08-02
//更 新 者：
//更新时间：
//*/
//function selectModalDialog( action, width, height) {
//	var result = $.openModalDialog( self, action, "", width, height);		
//	if (result == null) {
//		return "";
//	}
//	return result;
//}
//
///*
//名    称：checkSelectCount()
//输入参数：DOM元素复选框集合
//输出参数：有选中true、否则false
//机    能: 结果一览中的复选框
//创 建 者：zhuhuali          
//创建时间：2011-11-08
//更 新 者：
//更新时间：
//*/
//function checkSelectCount(objs) {
//    var count = 0;
//    $(objs).each(function (i,n) {
//        if (n.checked == true) {
//            count++;
//            return false;
//        }
//    })
//    
//    if (count <= 0) {
//        alert(Message.getString("MSG_ID_COMM_010"));
//        return false;
//    } else {
//        return true;
//    }
//
//}
///*
//名    称：removeErrorStyle()
//输入参数：目标对象
//输出参数：无
//机    能: 除去出错样式
//创 建 者：zhuhuali          
//创建时间：2011-11-08
//更 新 者：
//更新时间：
//*/
//function removeErrorStyle(obj) {
//
//    $(obj).find("input[type='text']").each(function(i,n) {
//        $(n).removeClass("error");
//	    //$("#simpleTooltip").remove();
//	    $(n).unbind("mouseenter").unbind("mouseleave");
//    })
//
//}
//
///*
//名    称：clearSelect()
//输入参数：下拉框对象
//输出参数：无
//机    能: 清空指定下拉框的信息
//创 建 者：zhuhuali          
//创建时间：2011-11-08
//更 新 者：
//更新时间：
//*/
//function clearSelect(obj) {
//    $(obj).find("option").remove();
//    var html = "<option value=''>全部</option>";
//    $(obj).append(html);
//}
///*
//名    称：clearSelectAsLabel()
//输入参数：清空指定下拉框的信息并指定空对应的标题
//输出参数：无
//机    能: 清空指定下拉框的信息
//创 建 者：zhuhuali          
//创建时间：2011-11-08
//更 新 者：
//更新时间：
//*/
//function clearSelectAsLabel(obj,nullvalue) {
//    $(obj).find("option").remove();
//    var html = "<option value=''>" + nullvalue + "</option>";
//    $(obj).append(html);
//}
//
///*
//名    称：ConvertMoney()
//输入参数：数字
//输出参数：金额大写
//机    能: 转换指定数字为金额大写字符串
//创 建 者：zhuhuali          
//创建时间：2011-11-08
//更 新 者：
//更新时间：
//*/
//function ConvertMoney(num){
//		var strOutput = "";  
//  		var strUnit = '仟佰拾亿仟佰拾万仟佰拾元角分';
//  		var strFlg = "负";
//  		num += "";
//  		var intPos = num.indexOf('.');
//  		var intFLg1 = num.indexOf('-');
//  		var dot = num.substr(intPos+1).length;
//  		if(intPos==-1){
//  			num += "00";
//  	    }else{
//  	    	if(dot==1){
//  	    		num += "0";
//  	    	}else{
//  				num += "";
//  			}
//  	    }
//  		var strSymbol="";
//  		var intFlg="";
//  		if (intFLg1>=0){
//  			num=num.substr(1);
//  			intPos = num.indexOf('.');
//  			strSymbol = "-";
//  		}
//  		if (intPos >= 0)  
//    		num = num.substring(0, intPos) + num.substr(intPos+1, 2); 
//  		strUnit = strUnit.substr(strUnit.length - num.length); 
//  		
//  		for (var i=0; i < num.length; i++) {
//    		strOutput += '零壹贰叁肆伍陆柒捌玖'.substr(num.substr(i,1),1) + strUnit.substr(i,1);
//    		}
//    	strOutput = strSymbol+strOutput;
//    	return strOutput.replace(/-/, strFlg)
//    			.replace(/零角零分$/, '整')
//    			.replace(/零[仟佰拾]/g, '零')
//    			.replace(/零{2,}/g, '零')
//    			.replace(/零([亿|万])/g, '$1')	
//    			.replace(/零+元/, '元')
//    			.replace(/亿零{0,3}万/, '亿')
//    			.replace(/^元/, "零元")
//    			.replace(/零分$/, "")
//    			.replace(/零角/, "零"); 
//}
///*
//名    称：reCalcIframeHeight(iframeName)
//输入参数：iframe名称
//输出参数：无
//机    能: 调整iframe高度
//创 建 者：zhuhuali          
//创建时间：2011-11-08
//更 新 者：
//更新时间：
//*/
//function reCalcIframeHeight(iframeName){
//		var iframe = document.frames(iframeName);		
//		var initIframeHight = document.getElementsByName(iframeName)[0].style.height;
//		var interval = window.setInterval(function(){
//			if( iframe.document.body != null){
//				document.getElementsByName(iframeName)[0].style.height=iframe.document.body.scrollHeight;
//				var  mainFrame = document.parentWindow.parent.document.getElementById("mainFrame");
//				mainFrame.height = parseInt(mainFrame.height) + parseInt(iframe.document.body.scrollHeight) - parseInt(initIframeHight);
//						
//				window.clearInterval(interval);
//				
//			}
//		},500);
//}
//
//    
///*
//功能描述：只允许输入半角英文字母
//输入参数：无
//输出参数：结果
//创 建 者：zhuhuali	
//更 新 者：zhuhuali
//*/
//function allowLetter() {
//	var value = true;
//	if (event.keyCode >= 97 && event.keyCode <= 122) {
//		value = true;
//	} else if (event.keyCode >= 65 && event.keyCode <= 90) {
//	    value = true;
//	}else if (event.keyCode == 32) {
//		value = true;
//	} else {
//		value = false;
//	}
//	event.returnValue = value;
//}
//
//
///*
//功能描述：只允许输入半角英数
//输入参数：无
//输出参数：结果
//创 建 者：zhuhuali	
//更 新 者：zhuhuali
//*/
//function allowHAString() {
//	var value = true;
//	if (event.keyCode >= 48 && event.keyCode <= 57) {
//		value = true;
//	} else if (event.keyCode >= 97 && event.keyCode <= 122) {
//		value = true;
//	} else if (event.keyCode >= 65 && event.keyCode <= 90) {
//	    value = true;
//	} else {
//		value = false;
//	}
//	event.returnValue = value;
//}
//
//
///*
//功能描述：只允许输入半角数字和'/'
//输入参数：无
//输出参数：结果
//创 建 者：zhuhuali	
//更 新 者：zhuhuali
//*/
//function allowDate() {
//	var value = true;
//	if (event.keyCode >= 48 && event.keyCode <= 57) {
//		value = true;
//	} else if (event.keyCode == 47) {
//		value = true;
//	} else {
//		value = false;
//	}
//	event.returnValue = value;
//}
//
//
//
//
//
//
//
//
//
///*
//功能描述：对指定的对象进行数字格式化
//输入参数：DOM元素、格式化字符串
//输出参数：结果
//创 建 者：zhuhuali	
//更 新 者：zhuhuali
//*/
//function formatNumberExt(obj, formatstring) {
//    var number_o = $(obj);
//    var length = formatstring.length;
//    
//    if (number_o.val() == '') {
//        return;
//    }
//    
//    if (length == 10) {
//         number_o.val( Math.round(parseFloat(number_o.val())*10000)/10000 );
//    } 
//    
//    if (length == 8) {
//        //number_o.val( Math.round(parseFloat(number_o.val())*100)/100 );
//        var tmp = parseFloat(number_o.val())*100;
//        var index = tmp.toString().indexOf('.');
//        if ( index != -1 ) {
//        	tmp = tmp.toString().substr(0,index);
//        }
//        
//        number_o.val(parseFloat(tmp)/100);
//    }
//    
//    if (length == 7) {
//        //number_o.val( Math.round(parseFloat(number_o.val())*100)/100 );
//        var tmp = parseFloat(number_o.val())*10;
//        var index = tmp.toString().indexOf('.');
//        if ( index != -1 ) {
//        	tmp = tmp.toString().substr(0,index);
//        }
//        
//        number_o.val(parseFloat(tmp)/10);
//    }
//    
//    
//    var f = "";
//    if (number_o.val().toString().indexOf('-') != -1) {
//        f = "-";
//        number_o.val( number_o.val().toString().replace(/-/g,"") );
//    }
//	
//	number_o.format( {format:formatstring} );
//	number_o.val( f + number_o.val() );
//}
//
//
//
//
//
///*
//名    称：initPageNode()
//输入参数：无
//输出参数：无
//机    能: 重新初始化页面元素
//创 建 者：zhuhuali          
//创建时间：2011-11-08
//更 新 者：
//更新时间：
//*/
//function initPageNode(){
//	
//}
//
//
//
///*
//名    称：moneyProcessInit(formName)
//输入参数：表单名称
//输出参数：无
//机    能: 初始化金额的格式化处理
//创 建 者：yuliang          
//创建时间：2012-02-10
//更 新 者：
//更新时间：
//*/
//function moneyProcessInit(formName) {
//	$('form[name="'+formName+'"]').find(".input_money").each(function( i, n) {
//	    var obj = n;
//	    if ($(obj).val() == '') {
//	        $(obj).val('');
//	    } else if(parseFloat($(obj).val()) == 0 ) {
//		   $(obj).val('0.00');
//		} else{
//		  formatNumber(this,"#,##0.00");
//		}
//	});
//}
//
///*
//名    称：moneyProcessSubmit(formName)
//输入参数：表单名称
//输出参数：无
//机    能: 提交金额的格式化处理
//创 建 者：yuliang          
//创建时间：2012-02-10
//更 新 者：
//更新时间：
//*/
//function moneyProcessSubmit(formName) {
//	$('form[name="'+formName+'"]').find(".input_money").each(function( i, n) {
//	    var obj = n;
//	    if ($(obj).val() == '') {
//	        $(obj).val('');
//	    } else if(parseFloat($(obj).val()) == 0 ) {
//		   $(obj).val('0.00');
//		} else{
//		  parseNumber(this);
//		}
//	});
//}
//

//
///*
//名    称：moneyProcessSubmitSpecial(formName)
//输入参数：表单名称
//输出参数：无
//机    能: 提交金额的格式化处理
//创 建 者：yuliang          
//创建时间：2012-02-23
//更 新 者：
//更新时间：
//*/
//function moneyProcessSubmitSpecial(formName) {
//	$('form[name="'+formName+'"]').find(".submit_money").each(function( i, n) {
//	    var obj = n;
//	    if ($(obj).val() == '') {
//	        $(obj).val('0.00');
//	    } else if(parseFloat($(obj).val()) == 0 ) {
//		   $(obj).val('0.00');
//		} else{
//		  parseNumber(this);
//		}
//	});
//}
//
///*三种报表打印方式：Excel、PDF、直接打印
//*	reportType: 	"xls" 		Excel导出
//*					"pdf"		PDF导出
//*					"drprint"	直接打印
//*
//*	reportFile: 	报表模板文件（.raq)
//*	expFileName:	导出文件名（若为xls或pdf）
//*	params：			报表参数（以";"号分割）
//*/
//function reportPrint(reportType,reportFile,expFileName,params){
//	if(reportType){
//		//直接打印
// 		if(reportType=='drprint'){
//	 		var rqdr = new RQreportDrPrint(reportFile,params);
//	 		rqdr.drPrint();
//	 		
// 		}else{
// 		//导出PDF或Excel
// 			document.getElementById('raqEntity/reportType').value=reportType;
// 			document.getElementById('raqEntity/reportFile').value=reportFile;
// 			document.getElementById('raqEntity/expFileName').value=expFileName;
// 			document.getElementById('raqEntity/param').value=params;
//			RQreportDownload(reportForm);
// 		}
// 	}
//}
//

///*
//名    称：checkSession()
//输入参数：无
//输出参数：无
//机    能: 验证session失效
//创 建 者：yuliang          
//创建时间：2012-03-06
//更 新 者：
//更新时间：
//*/
//function checkSession()
//{
//	try{
//		var ajax = new Ajax( "com.mcl.common.ValidationBiz.validateSession.biz");
//		ajax.submit();
//		var json = $.xmlToJSON( ajax.retDom);
//		var result = json.data[0].result[0].Text;
//		if (result == '-1') {
//			checkSessionExit();
//			return -1;
//		}
//	}catch(e){
//		checkSessionExit();
//		return -1;
//	}
//	return 0;
//}
///*
//名    称：checkSessionExit()
//输入参数：无
//输出参数：无
//机    能: session失效退出
//创 建 者：yuliang          
//创建时间：2012-03-06
//更 新 者：
//更新时间：
//*/
//function checkSessionExit(){
//	window.open("org.gocom.abframe.auth.Login.flow?_eosFlowAction=logout","_top");
//}
//
///*
//$(document).ready( function(){	
//	initPageNode();
//	try {
//		parent.initMainframe();	
//	}catch(e){
//	}
//})
//*/
//
///*
//名    称：encrypt()
//输入参数：需要加密的值(数组)
//输出参数：加密以后的值(数组)
//机    能: 参数加密
//创 建 者：陈振华          
//创建时间：2012-03-08
//更 新 者：
//更新时间：
//*/
//function encrypt(){
//
//	if (arguments.length == 0) return null;
//	var length = arguments.length;
//	var ajax = new AjaxExt( "com.mcl.common.URLBiz.encryptPassword.biz");
//	for(var i=0;i<length;i++){
//		ajax.addParam("param[" + i + "]/para",arguments[i]);
//	}
//	if(ajax.submit() == ajax.fail) return;
//	var json = $.xmlToJSON(ajax.retDom);
//	var encryptpara = new Array();
//	for(var j=0;j<length;j++){	
//		encryptpara[j] = json.data[0].param[j].para[0].Text;
//	}
//	return encryptpara;
//		
//}
//
///*
//名    称：checkBgnEndNumber()
//输入参数：beginNumber,endNumber
//输出参数：true（合法）false（不合法）
//机    能: check左边数字是否大于右边数字
//创 建 者：xuwenjin          
//创建时间：2012-07-24
//更 新 者：
//更新时间：
//*/
//function checkBgnEndNumber(beginNumber,endNumber){
//	if(beginNumber!=""&&endNumber!=""){
//		if(beginNumber>endNumber){		
//			return false;
//		} 
//	}
//	return true;
//}
//
///*
//名    称：checkXLS()
//输入参数：filename
//输出参数：true（合法）false（不合法）
//机    能: check文件后缀是否是XLS
//创 建 者：chenzhenhua         
//创建时间：2012-06-21
//更 新 者：
//更新时间：
//*/
//function checkXLS(filename){
//	var strRegex = "(.xls|.XLS)$";
//	var re=new RegExp(strRegex);
//	if (re.test(filename.toLowerCase())){
//		return true;
//     }
//     else{
//     	alert(Message.getString("MSG_COMM_0034"));
//       	return false;    
//     }
//}
//
//
///*
//*名    称：checkabatedate
//*输入参数：scheabateid
//*输出参数：flg:-1 数据过期  1:未过期
//*机    能: check预定冲销数据生成日是否是当前日期
//*创 建 者：chenzhenhua  
//*创建时间：2012-08-01
//*更 新 者：
//*更新时间：
//*/
//function checkabatedate(scheabateid){
//		var abateAjax = new AjaxExt( "com.mcl.common.receipt.ReceiptBiz.checkAbateDate.biz" );
//		abateAjax.addParam( "scheabateid", scheabateid);
//		if(abateAjax.submit() == abateAjax.fail) return false;
//		var json = $.xmlToJSON( abateAjax.retDom );
//		var flg = json.data[0].flg[0].Text;
//		return flg;		
//}
///*
//*名    称：checkSelectOne
//*输入参数：mes1,mes2
//*输出参数：false，true
//*机    能: check批次号从大到小删除，相同批次号同时删除
//*创 建 者：xuwenjin  
//*创建时间：2012-08-23
//*更 新 者：
//*更新时间：
//*/
//function checkSelectOneObj(mes1,mes2)
//{	
//	//选中的checkbox
//	var objs1 = $("#body_result :checked");
//	//没有选中checkbox
//	var objs2=$("#body_result :checkbox").not("input:checked");
//	//所有checkbox(除全选)
//	var objs3= $("#body_result :checkbox");
//
//	var cblength1=objs1.length;
//	var cblength2=objs2.length;
//	var cblength3=objs3.length;	
//	//没有选中的checkbox
//	if(cblength1==0)
//	{
//		alert(Message.getString("MSG_COMM_0007"));
//        return false;
//	}
//	//全选
//	if(cblength2==0)
//	{
//        return true;
//	}
//	var arr1 = new Array(); 
//	var arr2 = new Array();
//	var arr3 = new Array(); 
//	
//	var tmp1=objs1[cblength1-1]["id"];
//	var tmp2=objs2[cblength2-1]["id"];
//	var tmp3=objs3[cblength3-1]["id"];
//	
//	var count1=0;
//	var count2=0;
//	var count3=0;
//	//选中 checkbox(不包括重复)
//	for(var i=objs1.length-1;i>=0;i--)
//	{
//		if(tmp1==objs1[i]["id"])
//		{
//			count1++;		
//		}
//		else{			
//			tmp1=objs1[i]["id"];
//			count1=1;
//		}
//		if(count1==1)
//		{
//			arr1.push(objs1[i]["id"]);	
//		}		
//	}
//
//	//没选 checkbox(不包括重复)
//	for(var i=objs2.length-1;i>=0;i--)
//	{
//		if(tmp2==objs2[i]["id"])
//		{
//			count2++;		
//		}
//		else{			
//			tmp2=objs2[i]["id"];
//			count2=1;
//		}
//		if(count2==1)
//		{
//			arr2.push(objs2[i]["id"]);	
//		}		
//	}
//
//	//全部 checkbox(不包括重复)
//	for(var i=objs3.length-1;i>=0;i--)
//	{
//		if(tmp3==objs3[i]["id"])
//		{
//			count3++;
//		}
//		else{			
//			tmp3=objs3[i]["id"];
//			count3=1;
//		}
//		if(count3==1)
//		{
//			arr3.push(objs3[i]["id"]);	
//		}		
//	}
//
//	var flag1 = false;
//	var flag2 = false;
//	//退出标识
//	var endflag = false;
//	//全部arr3
//	for(var i=0;i<arr3.length;i++)
//	{//选中arr1
//		var a1 = arr3[i];
//		for(var j=0;j<arr1.length;j++)
//		{
//			flag1 = false;
//			var a2 = arr1[j];
//			if(!flag2){
//				if(a1==a2)
//				{
//					flag1 = true;
//					break;
//				}				
//			}else{
//				if(a1==a2)
//				{
//					endflag = true;
//					break;
//				}
//			}			
//		}
//		if(!flag1){
//			flag2 = true;
//		}
//		if(endflag){
//			break;
//		}
//	}
//	if(endflag){
//		alert(Message.getString(mes1));
//		return false;
//	}
//	//不选中arr2
//	for(var i=0;i<arr2.length;i++)
//	{//选中arr1
//		for(var j=0;j<arr1.length;j++)
//		{
//			if(arr2[i]==arr1[j])
//			{
//				alert(Message.getString(mes2));
//        		return false;
//			}
//		}
//	}
//	return true;
//}

