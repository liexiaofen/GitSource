/*******************************************************************************
*分页共通
********************************************************************************/
function pagination(page,action,formName,curPage,totalPage,isFirst,isLast){
	var isCount = true;
	var count = document.forms[formName].elements["totalRecord"].value;
	var length = document.forms[formName].elements["pageSize"].value;	
	var htmltext = "";
	if(isFirst != 'true'){
		htmltext += "<a href=\"#\" onclick=\"javascript:c_DisAllButton();prevPageOne('1', '"+action+"', '"+formName+"');return false;\">" + "&lt;&lt;" + "</a>";
		htmltext += "&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:c_DisAllButton();prevPage('"+curPage+"', '"+action+"', '"+formName+"');return false;\">" + "&lt;" + "</a>";
	}
	else
	{
		htmltext +=  "&lt;&lt;";
		htmltext += "&nbsp;&nbsp;&lt;";
	}	
	if (isCount) {
		htmltext += "<span class=\"span_page\">&nbsp;&nbsp;" + curPage + "/" + totalPage + "Page";
		htmltext += "&nbsp;&nbsp;"+ count + "Records" + "&nbsp;&nbsp;</span>";
	
	}		
	if(isLast != 'true'){	
		htmltext += "<a href=\"#\" onclick=\"javascript:c_DisAllButton();nextPage('"+curPage+"', '"+totalPage+"', '"+action+"', '"+formName+"');return false;\">" + "&gt;" + "</a>";
		htmltext += "&nbsp;&nbsp;<a href=\"#\" onclick=\"javascript:c_DisAllButton();nextPageLast('"+totalPage+"', '"+action+"', '"+formName+"');return false;\">" + "&gt;&gt;" + "</a>";
	}
	else
	{
		htmltext += "&gt;";
		htmltext += "&nbsp;&nbsp;&gt;&gt;";
	}
	//alert(htmltext);
	htmltext += "&nbsp;&nbsp;<input type=\"text\" class=\"page input_num2\" id=\"pageno\" maxlength=\"5\" name=\"pageno\" size=3 value='"+curPage+"'>";
	htmltext += "&nbsp;"+"页"+"&nbsp;<input type=\"button\" class=\"btn\" value=\"go\" name=\"gopage\" onclick=\"javascript:c_DisAllButton();gotoPage( document.getElementById('pageno').value, '"+totalPage+"', '"+action+"', '"+formName+"');return false;\" \/>";
	document.write( htmltext );
} 
/**
 * 页面跳转函数.
 * @param {int} pageno 要跳转到的页数
 * @param {int} totalPage 总页数
 * @param {String} Controller
 * @param {String} formId form的id
 */
function gotoPage( pageno, totalPage, formAction, formId){
	var pageno= !pageno?1:Number(pageno);
	if (typeof(pageno)!='number'){
		pageno=$e(pageno).value;
	}
	pageno=parseInt(pageno/1);
	pageno=isNaN(pageno)||pageno<1?1:pageno;
	if(pageno > parseInt(totalPage/1)){
		pageno = parseInt(totalPage/1);
	}
	$('form[id="'+formId+'"]').find('input[name="curPage"]').val(pageno);
	$('form[id="'+formId+'"]').attr( "action", formAction);
	$('form[id="'+formId+'"]').submit();
}
/**
 * 页面跳转函数--第一页.
 * @param {int} pageno 要跳转到的页数
 * @param {String} Controller
 * @param {String} formId form的id
 */
function prevPageOne(pageno, formAction, formId){
	var pageno= !pageno?1:Number(pageno);
	if (typeof(pageno)!='number'){
		pageno=$e(pageno).value;
	}
	pageno=parseInt(pageno/1);
	pageno=isNaN(pageno)||pageno<1?1:pageno;
	$('form[id="'+formId+'"]').find('input[name="curPage"]').val(pageno);
	$('form[id="'+formId+'"]').attr( "action", formAction);
	$('form[id="'+formId+'"]').submit();
}
/**
 * 页面跳转函数--前一页.
 * @param {int} pageno 要跳转到的页数 
 * @param {String} Controller
 * @param {String} formId form的id
 */
function prevPage(pageno, formAction, formId){
	var pageno= !pageno?1:Number(pageno);
	if (typeof(pageno)!='number'){
		pageno=$e(pageno).value;
	}
	pageno=parseInt(pageno/1);
	pageno=isNaN(pageno)||pageno<1?1:pageno;
	pageno = pageno - 1;
	if(pageno < 1){
		pageno = 1;
	}
	$('form[id="'+formId+'"]').find('input[name="curPage"]').val(pageno);
	$('form[id="'+formId+'"]').attr( "action", formAction);
	$('form[id="'+formId+'"]').submit();
}
/**
 * 页面跳转函数--后一页.
 * @param {int} pageno 要跳转到的页数
 * @param {int} totalPage 总页数
 * @param {String} Controller
 * @param {String} formId form的id
 */
function nextPage(pageno, totalPage, formAction, formId){
	var pageno= !pageno?1:Number(pageno);
	if (typeof(pageno)!='number'){
		pageno=$e(pageno).value;
	}
	pageno=parseInt(pageno/1);
	pageno=isNaN(pageno)||pageno<1?1:pageno;
	pageno = pageno + 1;
	if(pageno > parseInt(totalPage/1)){
		pageno = parseInt(totalPage/1);
	}
	$('form[id="'+formId+'"]').find('input[name="curPage"]').val(pageno);
	$('form[id="'+formId+'"]').attr( "action", formAction);
	$('form[id="'+formId+'"]').submit();
}
/**
 * 页面跳转函数--最末页.
 * @param {int} pageno 要跳转到的页数
 * @param {String} Controller
 * @param {String} formId form的id
 */
function nextPageLast(pageno, formAction, formId){
	var pageno= !pageno?1:Number(pageno);
	if (typeof(pageno)!='number'){
		pageno=$e(pageno).value;
	}
	pageno=parseInt(pageno/1);
	pageno=isNaN(pageno)||pageno<1?1:pageno;
	$('form[id="'+formId+'"]').find('input[name="curPage"]').val(pageno);
	$('form[id="'+formId+'"]').attr( "action", formAction);
	$('form[id="'+formId+'"]').submit();
}