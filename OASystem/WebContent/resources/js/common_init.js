$(document).ready( function() {
	$("body").keydown(function(){
		_onkeydown();
	});
	//对非负整数的输入进行限制
	$(".input_num1").each(function(i,n) {
	    var obj = n;
		$(obj).blur(function(){
		    if ($(obj).val() == '' || parseFloat($(obj).val()) == 0) {
			    return false;
			}
		    if($.validate.checkNum1(obj)){
			   ;
			}else{
				alert(Message.getString("MSG_COMM_0008",getDisplayName(obj)));
				$(obj).focus();
				return false;
			}		    
		});
		$(obj).keypress(function(){ allowNumber(this);});
	});
	//对非负整数的输入进行限制(不包括0)
	$(".input_num2").each(function(i,n) {
	    var obj = n;
		$(obj).blur(function(){
		    if ($(obj).val() == '') {
			    return false;
			}
		    if(!$.validate.checkNum1(obj) || parseFloat($(obj).val()) == 0){
			   	alert(Message.getString("MSG_COMM_0006",getDisplayName(obj)));
				$(obj).focus();
				return false;
			}		    
		});
		$(obj).keypress(function(){ allowNumber(this);});
	});
	//对数量的输入进行限制
	$(".input_amount").each(function(i,n) {
	    var obj = n;
		$(obj).blur(function() {
		    if ($(obj).val() == '' || parseFloat($(obj).val()) == 0) {
			    return false;
			}
		    if ( $.validate.checkIntege(obj) ) {
		        formatNumber(this,"#,###");
		    } else {
				return false;
			}

		} );
		$(obj).focus(function() { parseNumber(this); } );
		$(obj).keypress( function() { allowNumber(this); } );
	});	
	//对单价的输入进行限制
	$(".input_price").each(function(i,n) {
	    var obj = n;
		$(obj).blur(function() {
		    if ($(obj).val() == '') {
			    return false;
			}
			
			if (parseFloat($(obj).val()) == 0) {
			   this.value = "0.00";
			}

		    if ( $.validate.checkDecmal4(obj) ) {
			    formatNumber(this,"#,##0.00");
			} else {				
				return false;
			}
		});
		$(obj).focus(function() { parseNumber(this); });
		$(obj).keypress(function() { allowAmount(this); });
	});	
	//对金额的输入进行限制
	$(".input_money").each(function(i,n) {		
	    var obj = n;
		$(obj).blur(function(){			
		    if($(obj).val() == ''){
			    return false;
			}
			parseNumber(obj);
			if(parseFloat($(obj).val()) == 0){
			   this.value = "0.00";
			   return false;
			}		
		    if($.validate.checkMoney(obj)){
			    formatNumber(this,"#,##0.00");
			}else{
				alert(Message.getString("MSG_COMM_0025",getDisplayName(obj)));
				$(obj).focus();
				return false;
			}		    
		});
		$(obj).focus(function(){ parseNumber(this);});
		$(obj).keypress(function(){ allowAmount(this);});
	});	
	//对金额的输入进行限制
	$(".check_float").each(function(i,n) {
	    var obj = n;
		$(obj).blur(function(){
		    if($(obj).val() == ''){
			    return false;
			}
			parseNumber(obj);
			if(parseFloat($(obj).val()) == 0){
			   this.value = "0.00";
			   return false;
			}
		    if($.validate.checkFloat(obj)){
			    formatNumber(this,"#,##0.00");
			}else{
				alert(Message.getString("MSG_COMM_0021",getDisplayName(obj)));
				$(obj).focus();
				return false;
			}		    
		} );
		$(obj).focus(function(){ parseNumber(this);});
		$(obj).keypress(function(){ allowFloat(this);});
	});	
	//对利率的输入进行限制
	$(".input_rate").each(function(i,n){
		var obj = n;		
		$(obj).blur(function(){
			if($(obj).val() == ''){
				return false;
			}
			if(parseFloat($(obj).val()) == 0){
			   this.value = "0.00";
			   return false;
			}
			if(parseFloat($(obj).val()) == 100){
			   this.value = "100.00";
			   return false;
			}
			if($.validate.checkRate(obj)){
				formatNumber(this,"#,##0.00");
				return false;
			}else{
				alert(Message.getString("MSG_COMM_0021",getDisplayName(obj)));
				$(obj).focus();
				return false;
			}
		});
		$(obj).keypress(function(){ allowAmount(this);	});
	});	
	//自动格式化年月
	$(".input_ym").each( function (i,n) {
	      var obj = n;
	      $(obj).blur(function() { 
	          if ( $(obj).val() == null || $(obj).val() == '' ) {
	              return false;
	          }
	          if (!$.validate.CheckDateYM(obj)) {
	              return false;
	          }
	          $(obj).val( formatYM2($(obj).val()));
	      });
	      if ( $(obj).val() != null && $(obj).val() != '' && $.validate.CheckDateYM(obj) ) {
	              $(obj).val( formatYM2($(obj).val()) );
	      }
	});	
	//特殊字符过滤
	$(".check_specialchar").find(":input").each(function(i,n){
		var obj = n;
		$(obj).blur(function(){
			if($(obj).attr("readonly") == false)
				$(obj).val( $(obj).val().replace(/'/g,'').replace(/%/g,'').replace(/_/g,'').replace(/(\<+|\>+)/g,''));
			return false;
		});
	});
	//input textarea特殊字符过滤
	$(":input").each(function(i,n){
		var obj = n;
		$(obj).blur(function(){
			if($(obj).attr("readonly") == false)
				$(obj).val( $(obj).val().replace(/(\<+|\>+)/g,''));
			return false;
		});
	});
	//所有按钮样式的初始化
	$('input[type="button"]').each(function(i,n){
		var obj = n;
		$(obj).mouseover(function(){
			$(obj).attr( "class", "btn_mouseover");
		});
		$(obj).mouseout(function(){
			$(obj).attr( "class", "btn");
		});
	});
});