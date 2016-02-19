/*
*名       称: addOptions( str, selectid, selectindex)
*输入参数: jsondata, selectid, selectindex
*输出参数: 无
*机       能: 添加option选项
*创 建  者: yuliang          
*创建时间: 2015-12-18
*更 新  者: 
*更新时间: 
*/
function addOptions( str, selectid, selectindex) {
	// JSON字符串转JSON对象
    var jsonArray = eval(str); 
	$("#"+selectid).empty();
    for(var i=0; i<jsonArray.length; i++) {
        if (jsonArray[i].busidictid == selectindex) {
        	$("#"+selectid).append("<option value="+jsonArray[i].busidictid+" selected='selected'>"+jsonArray[i].busidictname+"</option>");   
        }else{//设定第一项为被选项
        	$("#"+selectid).append("<option value="+jsonArray[i].busidictid+" >"+jsonArray[i].busidictname+"</option>");   //添加到列表
        }
    }
}
