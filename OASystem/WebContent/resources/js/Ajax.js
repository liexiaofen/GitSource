	var xmlhttp;
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari
		xmlhttp=new XMLHttpRequest();
	}else
	{// code for IE6, IE5
	  	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("GET","<%=path%>/pa/pa001/checkUniqueCardno",true);
	//xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("cardno="+$("#cardno").val()+"&"+escape(new Date()));
	xmlhttp.onreadystatechange = function()
	{
		if (xmlhttp.readyState==4 ) 
	    {
			if(xmlhttp.status==200)
		    	alert(xmlhttp.responseXML);
	    }
	}


$.ajax({
	data:"cardno="+$("#cardno").val(),
	type:"POST",
	dataType: "json",
	url:"<%=path%>/common/ajax/checkUniqueCardno",
	success:function(data){
		alert("data.msg:"+data.msg);
		if(data.msg == '0'){
			alert("身份证号重复！");
			flag = false;
		}else{
			flag = true;
		}
	},
	error:function(data){
		alert("data.msg:"+data.msg);
		alert("网络连接出错！"); 
	}		
});