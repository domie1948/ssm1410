<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("path", path);
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>无标题文档</title>
        <link href="${basePath}/resource/css/style.css" rel="stylesheet" type="text/css" />
        

</head>


<body>

    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">工作台</a></li>
    </ul>
    </div>
    
    
    <div class="mainbox">
    
    <div class="mainleft">
    
    
    <div class="leftinfo">
    <div class="listtitle"><a href="#" class="more1">更多</a>数据统计</div>
        
    <div class="maintj" id="mzl">  
    
    </div>
    
    </div>
    <!--leftinfo end-->
    
    
    <div class="leftinfos">
    
   
    <div class="infoleft">
    
    <div class="listtitle"><a href="#" class="more1">更多</a>待办事项</div>    
    <ul class="newlist">
    <li><a href="#">上海自贸区今日正式挂牌成立</a><b>10-09</b></li>
    <li><a href="#">习近平将访东南亚两国 首次出席APEC峰会</a><b>10-08</b></li>
    <li><a href="#">最高法:谎称炸弹致航班备降者从重追刑责</a><b>10-09</b></li>
    <li><a href="#">华北大部遭遇雾霾天 北京全城陷重污染</a><b>10-06</b></li>
    <li><a href="#">"环保专家"董良杰涉嫌寻衅滋事被刑拘</a><b>10-05</b></li>
    <li><a href="#">中央巡视组：重庆对一把手监督不到位</a><b>10-04</b></li>
    <li><a href="#">囧!悍马没改好成华丽马车(图)</a><b>10-03</b></li>
    </ul>   
    
    </div>
    
    
    <div class="inforight">
    <div class="listtitle"><a href="#" class="more1">添加</a>常用工具</div>
    
    <ul class="tooli">
    <li><span><img src="${basePath}/resource/images/d01.png" /></span><p><a href="#">信息资料</a></p></li>
    <li><span><img src="${basePath}/resource/images/d02.png" /></span><p><a href="#">编辑</a></p></li>
    <li><span><img src="${basePath}/resource/images/d03.png" /></span><p><a href="#">记事本</a></p></li>
    <li><span><img src="${basePath}/resource/images/d04.png" /></span><p><a href="#">任务日历</a></p></li>
    <li><span><img src="${basePath}/resource/images/d05.png" /></span><p><a href="#">图片管理</a></p></li>
    <li><span><img src="${basePath}/resource/images/d06.png" /></span><p><a href="#">交易</a></p></li>
    <li><span><img src="${basePath}/resource/images/d07.png" /></span><p><a href="#">档案袋</a></p></li>    
    </ul>
    
    </div>
    
    
    </div>
    
    
    </div>
    <!--mainleft end-->
    
    
    <div class="mainright">
    
    
    <div class="dflist">
    <div class="listtitle"><a href="#" class="more1">更多</a>最新信息</div>    
    <ul class="newlist">
    <li><a href="#">上海自贸区今日正式挂牌成立</a></li>
    <li><a href="#">习近平将访东南亚两国 首次出席APEC峰会</a></li>
    <li><a href="#">最高法:谎称炸弹致航班备降者从重追刑责</a></li>
    <li><a href="#">华北大部遭遇雾霾天 北京全城陷重污染</a></li>
    <li><a href="#">"环保专家"董良杰涉嫌寻衅滋事被刑拘</a></li>
    <li><a href="#">中央巡视组：重庆对一把手监督不到位</a></li>
    <li><a href="#">囧!悍马没改好成华丽马车(图)</a></li>
    <li><a href="#">澳门黄金周加派稽查人员监察出租车违规行为</a></li>
    <li><a href="#">香港环境局长吁民众支持政府扩建堆填区</a></li> 
    </ul>        
    </div>
    
    
    <div class="dflist1">
    <div class="listtitle"><a href="#" class="more1">更多</a>信息统计</div>    
    <ul class="newlist">
    <li><i>会员数：</a></i>2535462</li>
    <li><i>文档数：</a></i>5546</li>
    <li><i>普通文章：</a></i>2315</li>
    <li><i>软件：</a></i>1585</li>
    <li><i>评论数：</a></i>5342</li>    
    </ul>        
    </div>
    
    

    
    
    </div>
    <!--mainright end-->
    
    </div>
</body>
<script type="text/javascript" src="${basePath}/resource/js/jquery.js"></script>
<script type="text/javascript" src="${basePath}/resource/fusioncharts/fusioncharts.js"></script><!--引入主类库-->
<script type="text/javascript">
$(function(){
	
	$.get("${basePath}/sys/role/chart",function(data){
		if(data!=null&&data.length>0){
		    var jsonObject = {
		            chart:{
		                //定义属性
		                yaxisname:"Sales Figure",
		                caption:"角色信息统计",
		                useroundedges:"1",
		                bgcolor:"FFFFFF,FFFFFF",
		                showborder:0,
		                numbersuffix:"位",
		                showLegend:"1",
		                legendBgColor: "#ffffff",
		                legendBorderAlpha: '0',
		                legendShadow: '0',
		                legendItemFontSize: '10',
		                legendItemFontColor: '#666666'
		                
		            }
		    };
		    jsonObject.data=data;
		    
		    var chart = new FusionCharts("doughnut2d.swf", "ChartId", "650", "250", "0", "0");
		    //创建一个FusionCharts对象，第一个参数为swf文件的路径，第二个为id用来标识这个对象，第三个为宽度，第四个为高度
		    chart.setJSONData(JSON.stringify(jsonObject));
		    chart.render("mzl");//将FusionCharts对象填充到指定的div标签处：render（div）
		}
	});
	
	
	
	
	
	
}) 

</script>

<script type="text/javascript">
    setWidth();
    $(window).resize(function(){
        setWidth(); 
    });
    function setWidth(){
        var width = ($('.leftinfos').width()-12)/2;
        $('.infoleft,.inforight').width(width);
    }
</script>
</html>