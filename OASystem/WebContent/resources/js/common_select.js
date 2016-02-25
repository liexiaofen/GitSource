/*
*名       称: change_refreshEmp( obj, orgcdid, empselectid)
*输入参数: obj, orgcdid, empselectid
*输出参数: 无
*机       能: 根据部门查询员工
*创 建  者: yuliang          
*创建时间: 2015-12-22
*更 新  者: 
*更新时间: 
*/
function change_refreshEmp( obj, orgcdid, empselectid){
	//获取depid
	var depid = $(obj).val();	
	//获取组织id
	var orgcdid = $('#'+orgcdid).val();
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:contextPath+'/common/ajax/getEmpsByOrgcdDepid.do?flg='+escape(new Date())+'&orgcdid='+escape(orgcdid)+'&depid='+escape(depid),
		success:function(data){			
			addOptions( data, empselectid, 0);
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			return;
		}		
	});
}
/*
*名       称: change_refreshDepEmp( obj, depselectid, empselectid, selectindex)
*输入参数: obj, depselectid, empselectid, selectindex
*输出参数: 无
*机       能: 根据组织id查询部门，员工
*创 建  者: yuliang          
*创建时间: 2015-12-18
*更 新  者: 
*更新时间: 
*/
function change_refreshDepEmp( obj, depselectid, empselectid, selectindex){
	//获取orgcdid
	var orgcdid = $(obj).val();
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:contextPath+'/common/ajax/getDepsByOrgcdid.do?flg='+escape(new Date())+'&orgcdid='+escape(orgcdid),
		success:function(data){			
			addOptions( data, depselectid, selectindex);
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			return;
		}		
	});
	//获取部门经理审核人员列表
	var depid = $('#'+depselectid).val();
	$.ajax({
		async: false,
		data:"",
		type:"GET",
		dataType: 'json',
		url:contextPath+'/common/ajax/getEmpsByOrgcdDepid.do?flg='+escape(new Date())+'&orgcdid='+escape(orgcdid)+'&depid='+escape(depid),
		success:function(data){			
			addOptions( data, empselectid, 0);
		},
		error:function(data){
			alert(Message.getString("ERROR_COMM_0037")); 
			return;
		}		
	});
}
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
