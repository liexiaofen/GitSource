//依赖jquery.dataCheck.js
(function($){
	$.singlevalidate = function(n, requiredflg){
		var opt={
	  		mail:"email",
	  		num:"number",
	  		num1:"num1",
	  		intege1:"intege1",
	  		decmal1:"decmal1",
	  		decmalperct:"decmalperct",
	  		decimalscale:"decimalscale",
	  		ratescale:"ratescale",
	  		date:"date",
	  		dateYM:"dateym",	  		
	  		numorlett:"numorlett",
	  		letter:"letter",	  		
	  		maxlength:"maxlength",
	  		mobile:"mobile",
	  		tel:"tel",
	  		zipcode:"zipcode",
	  		ascii:"ascii",
	  		required:"required",
	  		//business check	  		
	  		isnotnormal:"isnotnormal",
	  		chinaidcard:"chinaidcard",
	  		chinese:"chinese",
	  		birthday:"birthday",
	  		page:"page"	  		
		};
	  	var validateignore = $(n).attr("validateignore");
	  	if (validateignore == "true") {
	  		return true;
	  	}
	  	var flg = true;
	  	var returnCode = true;
	  	var returncode_b = true;
		var messageid = "";
	  	var obj = n;
		var array = obj.title.split(",");
		$(array).each(function(i,v){			
	    	var index_n = i;
			flg = true&&flg;
	 		if(obj.value != "" || v == opt.required || v == opt.page){
	 			if(v==opt.mail){
					if(!$.validate.checkEmail(n)){
						flg = false;
						messageid = "MSG_COMM_0021";
					}
				}	
				if(v==opt.num){
					if(!$.validate.checkNumber(n)){
						flg = false;
						messageid = "MSG_COMM_0005";
					}
				}	
				if(v==opt.num1){
					if(!$.validate.checkNum1(n)){
						flg = false;
						messageid = "MSG_COMM_0008";
					}
				}
				if(v==opt.intege1){
					if(!$.validate.checkIntege1(n)){
						flg = false;
						messageid = "MSG_COMM_0006";
					}
				}								
				if(v==opt.page){
					if(n.value.replace(/^(\s|\u3000)+/, '')=="") {
						flg = false;
						messageid = "MSG_COMM_0016";
					}
					if(flg&&!$.validate.checkIntege1(n)){
						flg = false;
						messageid = "MSG_COMM_0016";
					}
					if (flg) {
						var pagenum = parseInt(n.value);
						if (pagenum > 1000) {
							flg = false;
							messageid = "MSG_COMM_0016";
						}
					}					
				}				
				if(v==opt.decmal1){
			  		var n_temp = n;
			  		n_temp.value = n.value.toString().replace(/,/g,"");
		  			if(!$.validate.checkDecmal4(n_temp)){
		  				flg = false;
		  				messageid = "MSG_COMM_0004";
		  			}			  		
			  	}				
				if(v==opt.decmalperct){
					var n_temp = n;
					n_temp.value = n.value.toString().replace(/,/g,"");
					if(!$.validate.checkDecmalperct(n_temp)){
						flg = false;
						messageid = "MSG_COMM_0020";
					}
				}				
				if(v==opt.decimalscale){
					var maxdecimal = 100000000000;
					var value_scale_n = n.value.toString().replace(/,/g,"");
					if( !(parseFloat(value_scale_n) >=0 && parseFloat(value_scale_n) < parseFloat(maxdecimal)) ) {
						flg = false;
						messageid = "MSG_COMM_0010";
					}
				}				
				if(v==opt.ratescale){
					var maxdecimal = 99.9999;
					var value_scale_n = n.value.toString().replace(/,/g,"");
					if( !(parseFloat(value_scale_n) >=0 && parseFloat(value_scale_n) <= parseFloat(maxdecimal)) ) {
							flg = false;
							messageid = "MSG_COMM_0010";
					}
				}		
				if(v==opt.date){	
					if(n.dateformat == "undefined"){
						if(!$.validate.checkDate(n)){
							flg = false;
							messageid = "MSG_COMM_0009";
						}
					}	
					else{
						if(!$.validate.checkDate(n,n.dateformat)){
							flg = false;
							messageid = "MSG_COMM_0009";
						}
					}		
				}				
				if(v==opt.dateYM){
					if(!$.validate.checkDateYM(n)){
						flg = false;
						messageid = "MSG_COMM_0011";
					}
				}				
				if(v==opt.birthday){
					if(!$.validate.checkBirthday(n)){
						flg = false;
						messageid = "MSG_COMM_0027";
					}
				}				
				if(v==opt.numorlett){
					if(!$.validate.checkNumorlett(n)){
						flg = false;
						messageid = "MSG_COMM_0002";
					}					
				}				
				if(v==opt.letter){
					if(!$.validate.checkLetter(n)){
						flg = false;
						messageid = "MSG_COMM_0014";
					}									
				}				
				if(v==opt.chinese){
					if(!$.validate.checkChinese(n)){
						flg = false;					
					}
				}			
				if(v==opt.ascii){
					if(!$.validate.checkAscii(n)){
						flg = false;
						messageid = "MSG_COMM_0021";
					}
				}			
				var textarealen_n = 170;
				if(v==opt.maxlength) {
					var value1 ;
					if($(n).is("textarea")){
						value1=$(n).text();
					}
					else{
						value1=$(n).val();
					}
					var deflength = $(n).attr("maxlength");
					if(deflength){
						textarealen_n = deflength;
					}
					var charlength = 0;
					if (value1 == null || value1 == "") {
						charlength = 0;
					}					
					var charcode = 0;
					for (var i = 0; i < value1.length; i++) {
						charcode = value1.charCodeAt(i);
						if (charcode <= 127) {
							charlength += 1;
						} else {
							charlength += 2;
						}
					}
					if (charlength > textarealen_n) {
						flg = false;
						messageid = "MSG_COMM_0010";
					}					
				}
				if(v==opt.mobile){
					if(!$.validate.checkMobile(n)){
						flg = false;
						messageid = "MSG_COMM_0021";
					}			
				}
				if(v==opt.tel){
					if(!$.validate.checkTel(n)){
						flg = false;
						messageid = "MSG_COMM_0021";
					}			
				}				
				if(v==opt.zipcode){					
					if (!$.validate.checkZipcode(n)){
						flg = false;
						messageid = "MSG_COMM_0021";
					}					
				}				
				if(v==opt.isnotnormal){
					if (!$.validate.checkIsnotnormal(n)){
						flg = false;
						messageid = "MSG_COMM_0021";
					}
				}				
				if(v==opt.chinaidcard){
					if (!$.validate.checkChinaIDcard(n)){
						flg = false;
						messageid = "MSG_COMM_0021";
					}
					if(flg){
						if($(n).val().length == 18){
							re = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/; 
							var arrsplit = $(n).val().match(re);				
							//检查生日日期是否正确 
							var dtmbirth = arrsplit[2] + arrsplit[3] + arrsplit[4]; 
//							if(dtmbirth > currentDate){
//						    	flg = false;
//						    	messageid = "MSG_COMM_0029";
//						    }
						}
					}						
				}				
				if(v==opt.required && requiredflg){
					var tagname = $(n).attr("tagName").toLowerCase();
					var tagtype = $(n).attr("type");					
					if (tagname=="input" && tagtype=="radio") {
						var name = $(n).attr("name");
						var count = 0;
						$(n).parent().parent().find("input[type='radio'][name='" + name + "']").each(function(i,n){
							if (n.checked) {
								count++;
							}
						});
						if (count <= 0) {
							flg = false;
							messageid = "MSG_COMM_0007";
						}						
					} else if(n.value.replace(/^(\s|\u3000)+/, '')==""){
						flg = false;
						messageid = "MSG_COMM_0001";
					}
				}
	 		}		
			if(!flg){
				returncode_b = false;
				returnCode = false;				
				var array = "";
				if ($(n).attr("errortip") != undefined) {
					array = $(n).attr("errortip").split(",");
				}				
				var name_s = getDisplayName(n);
				var i_n = index_n;
		        var text = "";		        
		        try {
			        if ($(n).attr("errortip") == '' || $(n).attr("errortip") == undefined || array.length == 0 || array[i_n] == null || array[i_n] == undefined || array[i_n] == '' ) {
			            text = Message.getString(messageid,name_s);
			            if(text == null || text == undefined || text == "") {
			            	text = messageid;
			            }
			        } else {			        
			            if(v==opt.maxlength) {
			                var num_n = textarealen_n; 
			                text = Message.getString(array[i_n],name_s,num_n);			                
			            } else {
			                text = Message.getString(array[i_n],name_s);
			            }		            
			        }		        
		        }catch(e){
		        	text = "";
		        }				
				alert(text);
				$(n).focus();				
				flg = true;
				return false;
			}   			
		});		
		if (!returncode_b) {
		    return false;
		}	  		
	    return returnCode;		
	};
})(jQuery);