/*
*名       称: _onkeydown()
*输入参数: 无
*输出参数: 无
*机       能: 禁用特殊键
*创 建  者: yuliang          
*创建时间: 2015-12-10
*更 新  者:
*更新时间:
*/
function _onkeydown(){ 
	if (typeof window.event != 'undefined') {
		document.onkeydown = function() {
		    var type = event.srcElement.type;
		    var code = event.keyCode;
		    if(((window.event.altKey) &&((code==37) || (code==39)))){
		    	//屏蔽Alt+方向键←  //屏蔽Alt+方向键→    
		    	event.returnValue = false;  
		    }
		    if(event.keyCode==116) {//屏蔽F5
		    	event.keyCode=0;   
		    	event.returnValue = false;   
		  	}	    
		    return (( code != 8 && code != 13 && code != 116 ) || //屏蔽退格，回车，屏蔽F5刷新键 
		            ( type == 'text' && code != 13 && !(code=8 && event.srcElement.readOnly) ) ||
		            ( type == 'password' && code != 13 && !(code=8 && event.srcElement.readOnly) )|| 
		            ( type == 'textarea' && !(code=8 && event.srcElement.readOnly) ) ||
		            ( type == 'submit' && code == 13) );
		}
	}else{ // FireFox/Others
		document.onkeypress = function(e) {
		    var type = e.target.localName.toLowerCase();
		    var code = e.keyCode;
		    if ((code != 8 && code != 13 && code != 116) ||
		        (type == 'input' && code != 13 && !(code=8 && event.srcElement.readOnly)) ||
		        (type == 'textarea') ||
		        (type == 'submit' && code == 13 && !(code=8 && event.srcElement.readOnly))) {
		        return true;
		    }else{
		        return false ;
		    }
		}
	}
}