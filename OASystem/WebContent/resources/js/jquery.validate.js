(function($){
	var regexEnum = 
	{
		email:/^([-_A-Za-z0-9\.]+)@([_A-Za-z0-9\-]+\.)+[A-Za-z0-9]{2,3}$/, 	//邮件
		numChar:/^\d+$/,													//数字字符
		num1:/^[1-9]{1}[0-9]{0,}|[0]{1}$/,									//正整数和0
		intege1:/^[1-9]\d*$/,												//正整数		
		intege:/^-?[1-9]\d*$/,												//整数		
		intege2:/^-[1-9]\d*$/,												//负整数
		num:/^([+-]?)\d*\.?\d+$/,											//数字
		//num1:/^[1-9]\d*|0$/,												//正数（正整数 + 0）		
		num2:/^-[1-9]\d*|0$/,												//负数（负整数 + 0）
		decmal:/^([+-]?)\d*\.\d+$/,											//浮点数
		//decmal1:/^[1-9]\d*.\d*|0.\d*[1-9]\d*$/,　　	//正浮点数
		//decmal2:/^-([1-9]\d*.\d*|0.\d*[1-9]\d*)$/,　 //负浮点数
		//decmal3:/^-?([1-9]\d*.\d*|0.\d*[1-9]\d*|0?.0+|0)$/,　 //浮点数
		//decmal4:/^[1-9]\d*.\d*|0.\d*[1-9]\d*|0?.0+|0$/,　　 //非负浮点数（正浮点数 + 0）
		//decmal5:/^(-([1-9]\d*.\d*|0.\d*[1-9]\d*))|0?.0+|0$/,　　//非正浮点数（负浮点数 + 0）
		decmal1:/^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/,		//正浮点数
		decmal2:/^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/,	//负浮点数
		decmal3:/^(-?\d+)(\.\d+)?$/,										//浮点数
		decmal4:/^\d+(\.\d+)?$/,											//非负浮点数（正浮点数 + 0）
		decmal5:/^((-\d+(\.\d+)?)|(0+(\.0+)?))$/,							//非正浮点数（负浮点数 + 0）
		money:/^((([1-9](\d){0,9})(\.\d{1,2})?)|(0(\.\d{1,2})?))$/,        //非负浮点数(10位整数，俩位小数)
		float:/^((-?([1-9](\d){0,9})(\.\d{1,2})?)|(-?0(\.\d{1,2})?))$/,    //正负浮点数(10位整数，俩位小数)
		rate:/^(([1-9](\d)?(\.\d{1,2})?)|(0(\.\d{1,2})?))$/,                                  //利率
		decmalperct:/^((100(\.(0{1,2})?)?)|(([0-9]{1,2})?(\.(\d{1,2})?)?))$/,	//百分比中的非负浮点数（0，0.00 -- 100.00）		
		//url:/^((http:[/][/])?\w+([.]\w+|[/]\w*)*)?$/,						//url
		chinese:/^[\u4E00-\u9FA5\uF900-\uFA2D]+$/,							//仅中文
		//ascii:/^[\\x00-\\xFF]+$/,	//仅ACSII字符
		ascii:/^[\x00-\xFF]+$/,												//仅ACSII字符
		//zipcode:/^\d{6}$/,						//邮编
		zipcode:/^[A-Za-z0-9]|(\-)+$/,			//邮编
		mobile:/^(13|15|17|18)[0-9]{9}$/,				//手机
		ip4:/^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5]).(\d{1,2}|1\d\d|2[0-4]\d|25[0-5]).(d{1,2}|1\d\d|2[0-4]\d|25[0-5]).(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/,				//ip地址
		picture:/(.*)\\.(jpg|bmp|gif|ico|pcx|jpeg|tif|png|raw|tga)$/,		//图片
		rar:/(.*)\\.(rar|zip|7zip|tgz)$/,									//压缩文件
		//tel:/^(\d{3}-|\d{4}-)?(\d{8}|\d{7})$/,	//国内电话
		tel:/^\+?(\([0-9]{1,4}\))?[0-9]{1,20}([\s-][0-9]{1,10}){0,4}(\([0-9]{1,5}\))?$/,//国内电话
		username:/^\\w+$/,							//用来用户注册。匹配由数字、26个英文字母或者下划线组成的字符串
		letter:/^[A-Za-z]+$/,						//字母
		letter_u:/^[A-Z]+$/,						//大写字母
		letter_l:/^[a-z]+$/,						//小写字母
		idcard:/^[1-9]([0-9]{14}|[0-9]{17})$/,		//身份证
		numorlett:/^[A-Za-z0-9]+$/,					//英数字
		isnotnormal:/^[^?!$%^*？！\s]*$/,			//非法字符验证
		//11-15:"北京","天津","河北","山西","内蒙古",
		//21-23:"辽宁","吉林","黑龙江",
		//31-37:"上海","江苏","浙江","安徽","福建","江西","山东",
		//41-46:"河南","湖北","湖南","广东","广西","海南",
		//50-54:"重庆","四川","贵州","云南","西藏",
		//61-65:"陕西","甘肃","青海","宁夏","新疆",
		//71:"台湾",81:"香港",82:"澳门",91:"国外"
		ChinaIdcard15:/^(1[1-5]|2[1-3]|3[1-7]|4[1-6]|5[0-4]|6[1-5]|8[12]|91)\d{6}(0[1-9]|1[0-2])(0[1-9]|[12]\d|3[01])\d{3}$/,			//身份证15位
		ChinaIdcard18:/^(1[1-5]|2[1-3]|3[1-7]|4[1-6]|5[0-4]|6[1-5]|8[12]|91)\d{8}(0[1-9]|1[0-2])(0[1-9]|[12]\d|3[01])\d{3}[\d|X]$/,	//身份证18位
	    ZhOrNumOrLett:/^[0-9a-zA-Z\u4e00-\u9fa5]+$/	//汉字、字母、数字	
	};
	
	//构造函数
	$.validate = function(){
	};
	
	$.validate.checkNumber = function(obj){
		return new RegExp(regexEnum.numChar).test(obj.value);
	};
	
	$.validate.checkIntege = function(obj){
		return new RegExp(regexEnum.intege).test(obj.value);
	};
	
	$.validate.checkIntege1 = function(obj){
		return new RegExp(regexEnum.intege1).test(obj.value);
	};

	$.validate.checkIntege2 = function(obj){
		return new RegExp(regexEnum.intege2).test(obj.value);
	};

	$.validate.checkNum = function(obj){
		return new RegExp(regexEnum.num).test(obj.value);
	};
	
	$.validate.checkNum1 = function(obj){
		return new RegExp(regexEnum.num1).test(obj.value);
	};

	$.validate.checkNum2 = function(obj){
		return new RegExp(regexEnum.num2).test(obj.value);
	};
	
	$.validate.checkDecmal = function(obj){
		return new RegExp(regexEnum.decmal).test(obj.value);
	};

	$.validate.checkDecmal1 = function(obj){
		return new RegExp(regexEnum.decmal1).test(obj.value);
	};
	
	$.validate.checkDecmal2 = function(obj){
		return new RegExp(regexEnum.decmal2).test(obj.value);
	};
	
	$.validate.checkDecmal3 = function(obj){
		return new RegExp(regexEnum.decmal3).test(obj.value);
	};
	
	$.validate.checkDecmal4 = function(obj){
		return new RegExp(regexEnum.decmal4).test(obj.value);
	};
	
	$.validate.checkDecmal5 = function(obj){
		return new RegExp(regexEnum.decmal5).test(obj.value);
	};
	
	$.validate.checkMoney = function(obj){
		return new RegExp(regexEnum.money).test(obj.value);
	};
	
	$.validate.checkFloat = function(obj){
		return new RegExp(regexEnum.float).test(obj.value);
	};	
	
	$.validate.checkRate = function(obj){
		return new RegExp(regexEnum.rate).test(obj.value);
	};
	
	$.validate.checkDecmalperct = function(obj){
		return new RegExp(regexEnum.decmalperct).test(obj.value);
	};
	
	$.validate.checkIsnotnormal = function(obj){
		return new RegExp(regexEnum.isnotnormal).test(obj.value);
	};
	
	$.validate.checkEmail = function(obj){
		return new RegExp(regexEnum.email).test(obj.value);
	};
	
	$.validate.checkUrl = function(obj){
		return new RegExp(regexEnum.url).test(obj.value);
	};
	
	$.validate.checkChinese = function(obj){
		return new RegExp(regexEnum.chinese).test(obj.value);
	};
	
	$.validate.checkAscii = function(obj){
		return new RegExp(regexEnum.ascii).test(obj.value);
	};
	
	$.validate.checkZipcode = function(obj){
		return new RegExp(regexEnum.zipcode).test(obj.value);
	};
	
	$.validate.checkMobile = function(obj){
		return new RegExp(regexEnum.mobile).test(obj.value);
	};
	
	$.validate.checkIp4 = function(obj){
		return new RegExp(regexEnum.ip4).test(obj.value);
	};
	/*
	$.validate.checkNoEmpty = function(obj){
		return new RegExp(regexEnum.notempty).test(obj.value);
	};
	*/
	$.validate.checkPicture = function(obj){
		return new RegExp(regexEnum.picture).test(obj.value);
	};
	
	$.validate.checkRar = function(obj){
		return new RegExp(regexEnum.rar).test(obj.value);
	};
	
	/*
	$.validate.checkDate = function(obj){
		return new RegExp(regexEnum.date).test(obj.value)
	}
	*/
	
	$.validate.checkQQ = function(obj){
		return new RegExp(regexEnum.qq).test(obj.value);
	};
	
	$.validate.checkTel = function(obj){
		return new RegExp(regexEnum.tel).test(obj.value);
	};
	
	$.validate.checkLetter = function(obj){
		return new RegExp(regexEnum.letter).test(obj.value);
	};

	$.validate.checkLetter_U = function(obj){
		return new RegExp(regexEnum.letter_u).test(obj.value);
	};

	$.validate.checkLetter_l = function(obj){
		return new RegExp(regexEnum.letter_l).test(obj.value);
	};

	$.validate.checkIdcard = function(obj){
		return new RegExp(regexEnum.idcard).test(obj.value);
	};
	
	$.validate.checkNumorlett = function(obj){
		return new RegExp(regexEnum.numorlett).test(obj.value);
	};

	$.validate.checkZhOrNumOrLett = function(obj){
		return new RegExp(regexEnum.ZhOrNumOrLett).test(obj.value);
	};
	
	$.validate.checkChinaIDcard = function(obj){
		var value = obj.value;
		var result = false;
		if (value.length == 15) {
			result =  new RegExp(regexEnum.ChinaIdcard15).test(value);
		}
		
		if (value.length == 18) {
			result =  new RegExp(regexEnum.ChinaIdcard18).test(value);
		}
		
		if (result == true) {
			if (value.length == 18) {
				var re = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/; 
				var arrsplit = value.match(re);
				var birthday = arrsplit[2] + arrsplit[3] + arrsplit[4];
				//if (birthday < "19000101" || birthday > currentDate) return false;
			}
			return true;
		}
		
		return false;
	};
	
	//判断是否为日期(格式:yyyy年MM月dd日,yyyy-MM-dd,yyyy/MM/dd,yyyyMMdd)
	$.validate.checkDate = function(obj,format){
			var date = obj.value;
			if(format == undefined) format = "yyyyMMdd";
			if(date.length==0) return true;
			var year,month,day,datePat,matchArray;
			
			if(/^(y{4})(-|\/)(M{1,2})\2(d{1,2})$/.test(format))
				datePat = /^(\d{4})(-|\/)(\d{1,2})\2(\d{1,2})$/;
			else if(/^(y{4})(年)(M{1,2})(月)(d{1,2})(日)$/.test(format))
				datePat = /^(\d{4})年(\d{1,2})月(\d{1,2})日$/;
			else if(format=="yyyyMMdd")
				datePat = /^(\d{4})(\d{2})(\d{2})$/;
			else
			{
				return false;
			}
			matchArray = date.match(datePat);
			if(matchArray == null) 
			{
				return false;
			}
			if(/^(y{4})(-|\/)(M{1,2})\2(d{1,2})$/.test(format))
			{
				year = matchArray[1];
				month = matchArray[3];
				day = matchArray[4];
			} else
			{
				year = matchArray[1];
				month = matchArray[2];
				day = matchArray[3];
			}
			if (month < 1 || month > 12)
			{			  
				return false;
			}
			if (day < 1 || day > 31)
			{
				return false;
			}     
			if ((month==4 || month==6 || month==9 || month==11) && day==31)
			{
				return false;
			}     
			if (month==2)
			{
				var isleap=(year % 4==0 && (year % 100 !=0 || year % 400==0));
				if (day>29)
				{				
					return false;
				}
				if ((day==29) && (!isleap))
				{				
					return false;
				}
			}
			return true;
	};	
	//短日期，形如 (2003-12-05)
	$.validate.checkShortDate = function(obj){
		var str = obj.value;
		var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/); 
		if(r==null)return false; 
		var d= new Date(r[1], r[3]-1, r[4]); 
		return (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]);
	};
	//长时间，形如 (2003-12-05 13:04:06)
	$.validate.checkLongDate = function(obj){
		var str = obj.value;
		var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/; 
		var r = str.match(reg); 
		if(r==null) return false; 
		var d= new Date(r[1], r[3]-1,r[4],r[5],r[6],r[7]); 
		return (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]&&d.getHours()==r[5]&&d.getMinutes()==r[6]&&d.getSeconds()==r[7]);
	};
	//年月，形如 yyyyMM,yyyy-MM
	$.validate.checkDateYM = function(obj){
		var date = $.trim(obj.value);
		if(date.length==0) return true;
		var y,m,year,month;
		if(/^(\d{4})(-)(\d{2})$/.test(date)) {
			y = date.substring(0,4);
			m = date.substring(5,7);
		} else if (/^(\d{4})(\d{2})$/.test(date)) {
			y = date.substring(0,4);
			m = date.substring(4,6);
		} else {
			return false;
		}
		year = parseInt(y,10);
		month = parseInt(m,10);
		if (year < 1900 || year > 2100)
		{			  
			return false;
		}
		if (month < 1 || month > 12)
		{	
			return false;
		}
		//obj.value = "" + y + "-" + m;
		return true;		
	};
	//短时间，形如 (13:04:06)
	$.validate.checkTime = function(obj){
		var str = obj.value;
		var a = str.match(/^(\d{1,2})(:)?(\d{1,2})\2(\d{1,2})$/);
		if (a == null) {return false;};
		if (a[1]>24 || a[3]>60 || a[4]>60)
		{
			return false;
		}
		return true;		
	};	
	//
	$.validate.checkBirthday = function(obj){
		if($(obj).val() == null || $(obj).val() == ''){
	        return true;
	    }
	    var val = $(obj).val().replace(/-/g,'');
	    if(val > currentDate){
	    	return false;
	    }
	    return true;
	};
})(jQuery);