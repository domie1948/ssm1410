<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("path", path);
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录后台管理系统</title>
    <link href="resource/css/login.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="resource/js/jquery.js"></script>

    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });
    </script>

</head>

<body style="background-color:#1c77ac; background-image:url(resource/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <!--导航条 -->
    <div class="logintop">
        <span>后台管理</span>
        <ul>
            <li>请登录</li>
            <!--
            <li><a href="javascript:;">帮助</a></li>
            <li><a href="javascript:;">关于</a></li>
            -->
        </ul>
    </div>

    <div class="loginbody">

        <span class="systemlogo"></span>

        <!-- 登录标签 START-->
        <!--  说明:action属性在js文件设置,私密好一些! -->
        <form method="post" id="loginForm" action="sys/login">
            <div class="loginbox loginbox3">
                <ul>
                    <li>
                        <input id="account" name="account" type="text" class="loginuser" placeholder="请输入账号信息"
                             value="${account }"   onfocus="true"/>
                    </li>
                    <li>
                        <input id="password" name="password" type="password" class="loginpwd" placeholder="请输入密码"/>
                    </li>
                    <li class="yzm">
                    <span>
                        <input name="code" id="code" type="text" placeholder="请输入验证码信息"/>
                    </span>
                        <!--应设置img标签,显示验证码 -->
                        <img alt="验证码" title="看不清楚,换一下" src="sys/code" >
                    </li>
                    <li>
                            <!-- 使用Jquery绑定事件操作  -->
                            <input type="submit" class="loginbtn" value="登录"/>
                            <!--用于显示错误信息,但是没有定义style-->
                            <label style="color: darkred;">${message }</label>
                    </li>
                </ul>
            </div>
        </form>
        <!-- 登录标签 ENMD-->

    </div>


    <div class="loginbm">版权所有 @仅供学习交流，勿用于任何商业用途</div>

 <!-- 引入jQuery库的支持 -->
        <script src="resource/admin/js/jquery.js"></script>
        <script type="text/javascript" src="resource/login.js"></script>
        <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });
        
        
        $(function(){
            loginJS.validCode();
        });
        </script>
</body>

</html>