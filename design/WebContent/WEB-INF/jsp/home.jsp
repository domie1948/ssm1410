<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("path", path);
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML>
<html>
	<head>

		<base href="${basePath}">
		<meta charset="UTF-8">
		<title>胖先生后台管理系统 | IFRAME版本</title>

    <!-- 基础定义的样式  -->

    <!-- 后台框架页面样式 -->
    <link rel="stylesheet" href="resource/css2/admin.css" type="text/css"/>
    <!-- 引入字体图表 -->
    <link href="resource/css/Font-Awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!-- Jquery支持 -->
    <script type="text/javascript" src="resource/js/jquery.js"></script>  
    <!-- Layer支持 -->
    <script type="text/javascript" src="resource/layer/layer.js"></script>
    <!-- 后台框架控制 -->
    <script type="text/javascript" src="resource/js/admin.js"></script>

</head>

<body>
<div class="backAdmin">
    <div class="top">
        <!-- logo  -->
        <div class="topleft">
            <a href="sys/content" target="rightFrame"><img src="resource/images/logo.png" title="系统首页"/></a>
        </div>

        <!-- 首页导航
        <ul class="nav">
            <li><a href="default.html" target="rightFrame" class="selected"><img src="resource/images/icon01.png" title="工作台"/>
                <h2>工作台</h2></a>
            </li>
            <li><a href="javascript:;" target="rightFrame">
                <img src="resource/images/icon02.png" title="模型管理"/>
                <h2>模型管理</h2>
            </a>
            </li>
            <li><a href="imglist.html" target="rightFrame"><img src="resource/images/icon03.png" title="模块设计"/>
                <h2>模块设计</h2></a>
            </li>
            <li><a href="tools.html" target="rightFrame"><img src="resource/images/icon04.png" title="常用工具"/>
                <h2>常用工具</h2></a>
            </li>
            <li><a href="computer.html" target="rightFrame"><img src="resource/images/icon05.png" title="文件管理"/>
                <h2>文件管理</h2></a>
            </li>
            <li><a href="tab.html" target="rightFrame"><img src="resource/images/icon06.png" title="系统设置"/>
                <h2>系统设置</h2></a>
            </li>
        </ul>
        -->

        <div class="topright">
            <ul>
                <li><a href="sys/loginOut" id="loginOut">安全退出</a></li>
            </ul>

            <div class="user">
                <img src="resource/images/i07.png"  alt="用户头像"/>
                <span>${sessionScope.session_manager.manager_name }</span>
                <!-- 
                <b>5</b>
                 -->
            </div>

        </div>
    </div>

    <div class="left">
        <div class="lefttop">
            <i class="icon-cloud icon-large pull-left icon-border"></i>
            <span>信息导航</span>
        </div>

        <dl class="leftmenu">
<!-- 菜单开始 -->
		<c:if test="${sessionScope.session_manager.manager_role == 3}">
            <dd>
                <div class="title">
                    <i class="icon-gears icon-large pull-left icon-border"></i>
                    <span>分班管理</span>
                </div>
                <ul class="menuson">
                    <li>
                        <i class="icon-home"></i>
                        <a href="sys/class/assigned" target="rightFrame">报到分班</a>
                    </li>
                    <li>
                        <i class="icon-table"></i>
                        <a href="sys/class/checkAssigned" target="rightFrame">分班情况查询</a>
                    </li>
                </ul>
            </dd>
		</c:if>
		<c:if test="${sessionScope.session_manager.manager_role == 2}">
            <dd>
                <div class="title">
                    <i class="icon-calendar icon-large pull-left icon-border"></i>
                    <span>收费管理</span>
                </div>
                <ul class="menuson">
                    <li>
                        <i class="icon-list"></i>
                        <a href="sys/student/charge" target="rightFrame">学生登记缴费</a>
                    </li>
                    <li>
                        <i class="icon-list"></i>
                        <a href="sys/student/queryCharge" target="rightFrame">查询收费情况</a>
                    </li>
                </ul>
            </dd>
		</c:if>
		<c:if test="${sessionScope.session_manager.manager_role == 1}">

            <dd>
                <div class="title">
                    <i class="icon-user-md icon-large pull-left icon-border"></i>
                    <span>宿舍管理</span>
                </div>
                <ul class="menuson">
                    <li>
	                    <i class="icon-list"></i>
	                    <a href="sys/dorm/assigned" target="rightFrame">学生分配宿舍</a>
                    </li>
                    <li>
	                    <i class="icon-adn"></i>
	                    <a href="sys/dorm/checkAssigned" target="rightFrame">查询分配情况</a>
                    </li>
                </ul>
            </dd>
		</c:if>
		<c:if test="${sessionScope.session_manager.manager_role == 0}">

            <dd>
                <div class="title">
                    <i class="icon-edit icon-large pull-left icon-border"></i>
                    <span>基础数据管理</span>
                </div>
                <ul class="menuson">
                    <li>
	                    <i class="icon-list"></i>
	                    <a href="sys/major/list" target="rightFrame">专业管理</a>
                    </li>
                    <li>
	                    <i class="icon-list"></i>
	                    <a href="sys/student/list" target="rightFrame">录取学生名册管理</a>
                    </li>
                    <li>
	                    <i class="icon-list"></i>
	                    <a href="sys/dorm/list" target="rightFrame">学生宿舍管理</a>
                    </li>
                    <li>
	                    <i class="icon-list"></i>
	                    <a href="sys/class/list" target="rightFrame">班级管理</a>
                    </li>
                    <li>
	                    <i class="icon-list"></i>
	                    <a href="sys/manager/list" target="rightFrame">系统用户管理</a>
                    </li>
                </ul>
            </dd>
		</c:if>

            <dd>
                <div class="title">
                    <i class="icon-calendar icon-large pull-left icon-border"></i>
                    <span>学生信息管理</span>
                </div>
                <ul class="menuson">
                    <li><i class="icon-list"></i><a href="sys/student/toAdd" target="rightFrame">学生个人信息录入</a></li>
                </ul>
            </dd>
<!-- 菜单结束 -->
        </dl>


    </div>
    <div class="right">
        <div class="inner">
            <!-- 设置iframe -->
            <iframe id="rightFrame" name="rightFrame" class="mainIframe" scrolling="no" frameborder="0" src="sys/content"
                    onload="initIframe()"></iframe>
        </div>
    </div>
    <div class="bottom">
        <span>仅供学习交流，请勿用于任何商业用途</span>
        <i> 版权所有 @</i>
    </div>
</div>

<script type="text/javascript">
$(function(){//跟window.onload的区别?
		$("#loginOut").on("click",function(){
			/* if(window.confirm("您确定要退出该系统吗?")){
				window.location.href = "sys/loginOut";
			} */
			//询问框
			layer.confirm('您确定要退出该系统吗?', {
			  btn: ['狠心一下','继续光顾'] 
			}, function(){
			 window.location.href = "${basePath}/sys/loginOut";
			}, function(){
			  
			});
		});

		
	
});
</script>

</body>
</html>