//依赖jquery.dataCheck.js,jquery.singlevalidate.js,autovalidate.css
(function($){
	$.fn.autovalidate = function(){
	  	var returnCode = true;
	  	$(this).find("[title][title!='']").each(function( i, n) {
			returnCode = $.singlevalidate( n, true);
			if (!returnCode) {
				return false;
			}
	  	});
	    return returnCode;		
	}; 
  
	$.fn.autovalidatetab = function(id){
	  	var returnCode = true;
	  	$(this).find("[title][title!='']").each(function(i,n) {
			returnCode = $.singlevalidate(n, true);
			if (!returnCode) {
				showTabs(id);
				$(n).focus();
				return false;
			}
	  	});
	    return returnCode;		
	};
  
	$.fn.autovalidateForm = function(id) {
	  	var returnCode = true;
	  	$('form[id="'+id+'"]').find("[title][title!='']").each(function(i,n) {
			returnCode = $.singlevalidate(n, true);
			if (!returnCode) {
				return false;
			}
	  	});
	    return returnCode;		
	};  
})(jQuery);