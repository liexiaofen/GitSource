<%@ page language="java" import="com.winsolution.weixin.common.URIUtil" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String basePath = URIUtil.getURI(request);
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<title>员工签到/签退情况</title>
	<style type="text/css">
		body, html{width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
		#l-map{width:80%;height:100%;float:left; }
		#r-result{width:20%;height:100%;font-size:14px;line-height:20px;float:right;}
		#result{height:600px; overflow:auto;}
		#result div{padding:4px;cursor:pointer; }
		#result div div{color:#AAA;font-size:9pt;border-bottom:1px dotted #ccc;}
	</style>
	<script type="text/javascript" src="js/js.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=G5e7QBHuagRsRsFz1RpkLCLG"></script>
	<script type="text/javascript" src="http://developer.baidu.com/map/jsdemo/demo/convertor.js"></script>
</head>
<body onload="loadMap();">
	<div id="l-map"></div>
	<div id="r-result">
		<div id="condation">
			<form method="post" id="form1" name="form1" action="<%=basePath%>map.html">
				<fieldset>
					<legend>查询条件</legend>
					<div>
						登记类型
						<label for="radall">全部</label><input type="radio" name="gender" id="radall" value="radall" <c:if test='${param.gender==null || param.gender=="radall"}'> checked</c:if> />
						<label for="radsignin">签到</label><input type="radio" name="gender" id="radsignin" value="radsignin" <c:if test='${param.gender=="radsignin"}'> checked</c:if> />
						<label for="radsignout">签退</label><input type="radio" name="gender" id="radsignout" value="radsignout" <c:if test='${param.gender=="radsignout"}'> checked</c:if> />
					</div>
					<div>
						<label for="txtStartDate">查询日期</label>
						<input type="text" name="txtStartDate" id="txtStartDate" value="${startDate}" style="width:80px;" />
						<input type="button" onclick="query_info();" data-role="button" data-inline="true" id="btnSearch" data-icon="search" value="查询" />
					</div>
				</fieldset>
			</form>
		</div>
		<div id="result"></div>
	</div>
</body>
</html>
<script type="text/javascript">
	var map = new BMap.Map("l-map");
	map.centerAndZoom("上海",13);      	// 初始化地图,用城市名设置地图中心点
	map.enableScrollWheelZoom(true);
	//定义地图控件
	//设置地图偏移量
	defaultOffset = new BMap.Size(10, 50);
	var navigationControl = new BMap.NavigationControl({
	    // 靠左上角位置
	    offset:defaultOffset,
	    anchor: BMAP_ANCHOR_TOP_LEFT,
	    // LARGE类型
	    type: BMAP_NAVIGATION_CONTROL_LARGE,
	    // 启用显示定位
	    enableGeolocation: true
	  });
	defaultOffset = new BMap.Size(100, 100);
	//添加地图类型和缩略图
	var mapType1 = new BMap.MapTypeControl({mapTypes: [BMAP_NORMAL_MAP,BMAP_HYBRID_MAP]});
	var mapType2 = new BMap.MapTypeControl({anchor: BMAP_ANCHOR_TOP_LEFT});
	var overView = new BMap.OverviewMapControl();
	var overViewOpen = new BMap.OverviewMapControl({isOpen:true, anchor: BMAP_ANCHOR_BOTTOM_RIGHT});
	//添加地图控件
	map.addControl(navigationControl);
	map.addControl(mapType1);			//2D图，卫星图
	map.addControl(mapType2);         	//左上角，默认地图控件
	map.addControl(overView);          	//添加默认缩略地图控件
	map.addControl(overViewOpen);	//右下角，打开
	//添加缩小事件，当鼠标右击地图时，地图缩小
	 map.addEventListener("rightclick",
		 	 function(){
	  			map.zoomOut();
		  	 }
		);
	var jsonstr = '${emponmap_list}';	
	//var jsonstr = '[{"empname":"王秀营","signtime":"09:29","geo":{"lng":121.514244,"lat":31.245049}},{"empname":"刘振华","signtime":"09:20","geo":{"lng":121.525403,"lat":31.248791}},{"empname":"徐文进","signtime":"09:19","geo":{"lng":121.510941,"lat":31.246584}},{"empname":"王作昆","signtime":"08:56","geo":{"lng":121.510941,"lat":31.246584}},{"empname":"高宇","signtime":"09:46","geo":{"lng":121.413376,"lat":31.203213}}]';
	if(jsonstr==""){
		jsonstr="[]";
	}
	var jsonobj = eval("(" + jsonstr + ")");
	var gpspnts = new Array(jsonobj.length);//原始GPS坐标数组
	var baidpnts = new Array(jsonobj.length);//对应百度坐标数组
   	var index = 0;//用以延时模式计数
   	var myGeo = new BMap.Geocoder();
	//new BMap.Point(121.525403,31.248791),//良丰
	//new BMap.Point(121.510941,31.246584),//汇亚
	//new BMap.Point(121.413376,31.203213),//文广
	//new BMap.Point(121.513376,31.103213)//未知

    function loadMap(){
		orient();//首选进行屏幕切换调整
		//查询完毕的回调函数
		if(jsonobj.length>0){
			for(var cnt = 0; cnt < jsonobj.length; cnt++){
				var lng = jsonobj[cnt].geo.lng;
				var lat = jsonobj[cnt].geo.lat;
				var pnt =new BMap.Point(lng,lat);
			    gpspnts[cnt] = pnt;
			}
			bdGEO();
		}
    }
	
	function orient() {
		if (window.orientation == 90 || window.orientation == -90) {
		//ipad、iphone竖屏；Andriod横屏
			$("#l-map").css({"width":"80%","height":"100%","float":"left"});
			$("#r-result").css({"width":"20%","height":"100%","font-size":"14px","line-height":"20px","float":"right"});
			//$("#result").css({"height":"80%","overflow":"auto"});
			orientation = 'landscape';
			return false;
		}
		else if (window.orientation == 0 || window.orientation == 180) {
		//ipad、iphone横屏；Andriod竖屏
			$("#l-map").css({"width":"100%","height":"80%"});
			$("#r-result").css({"width":"100%","height":"20%","font-size":"14px","line-height":"20px"});
			//$("#result").css({"height":"200px","overflow":"auto"});
			orientation = 'portrait';
			return false;
		}
	}
		//用户变化屏幕方向时调用
	$(window).bind( 'orientationchange', function(e){
		orient();
	});
		
	function bdGEO(){
		var pnt = gpspnts[index];//取出一个标记点(GPS坐标)
		BMap.Convertor.translate(pnt,0,geocodeSearch);
	}
	function geocodeSearch(point){//转换成百度坐标，并进行反向解析，取出地点名
		var sign = jsonobj[index];
		myGeo.getLocation(point, function(rs){
			if(!rs){
				return;
			}
			try{
				var addc = rs.address;//详细地址
				var addn=rs.surroundingPois;//默认附近100米内6个地点
				var nearestPOI = addn[0].title;//解析最近的地点名
				var params = {"index":index,"empname":sign.empname,"signtime":sign.signtime,"posname":nearestPOI,"address":addc};
				baidpnts[index] = point;
				addMarker(point,params);
			}catch(e){
				//alert(e);
			}
		});
		if(index < gpspnts.length-1){
			index++;
			setTimeout(window.bdGEO,200);
		}
	}
	var content_pre = "<div  style='font-size:13px;font-weight:normal;'><b>员工姓名:</b>{0}</br><b>记录时间:</b>{1}</br><b>附近位置:</b>{2}</br><b>大致地址:</b>{3}</div>";
	var title_pre = "{empname}@{posname}[{signtime}]";
	var textlist_pre = "<div onclick='openInfo(this);' data-index='{index}' data-empname='{empname}' data-signtime='{signtime}' data-posname='{posname}' data-address='{address}'>{empname} [{signtime}] {posname}<div>大致位置：{address}</div></div>";
	function addMarker(point,params){
		 // 百度地图API功能
		var marker = new BMap.Marker(point);
		map.addOverlay(marker);               // 将标注添加到地图中
		marker.setLabel(new BMap.Label(params.empname+":["+params.signtime+"]",{offset:new BMap.Size(20,-10)}));
		var title = title_pre.format(params);
		var content = content_pre.format(params.empname,params.signtime,params.posname,params.address);
		var jsons={"point":point,"title":title,"content":content};
		marker.addEventListener("click",function(e){openInfo(jsons);});
		//添加放大事件，当鼠标左击标记时，地图放大
		marker.addEventListener("dblclick",
		 		 function(){
					map.zoomIn();
		  		 }
		);
		$("#result").append(textlist_pre.format(params));
	}
	
	function openInfo(obj){
		var isjson = typeof(obj) == "object" && Object.prototype.toString.call(obj).toLowerCase() == "[object object]" && !obj.length;   
		var point;
		var title;
		var content;
		if(isjson){
			point = obj.point;
			title = obj.title;
			content = obj.content;
		}else{
			var params = {"index":$(obj).data("index"),"empname":$(obj).data("empname"),"signtime":$(obj).data("signtime"),"posname":$(obj).data("posname"),"address":$(obj).data("address")};
			var idx = 0+params.index;
			point = baidpnts[idx];
			title = title_pre.format(params);
			content = content_pre.format(params.empname,params.signtime,params.posname,params.address);
		}
		var infoWindow = new BMap.InfoWindow(content,{title:"<span style='font-size:14px;color:#0A8021;font-weight:bold;'>"+title+"</span>"});  // 创建信息窗口对象 
		map.openInfoWindow(infoWindow,point); //开启信息窗口
	}
	
	function query_info() {
		$("#form1").submit();
	}
	
</script>
