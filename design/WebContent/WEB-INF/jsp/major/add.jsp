<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
<title>模拟提交表单功能</title>
<link href="resource/css/style.css" rel="stylesheet" type="text/css" />

</head>
<body style="overflow-x:hidden ">
<div class="formbody">
    
    <div class="formtitle"><span>专业信息</span></div>
    <form action="" method="post" id="majorForm">
    <ul class="forminfo">
    <li>
        <label>专业名称</label>
        <input type="text" name="major_name" id="major_name" class="dfinput" >
    </li>
    <li><label>&nbsp;</label><input type="button" class="btn" id="addMajorBtn" value="新增专业信息"/></li>
    </ul>
    </form>
    
    </div>
    
    <!-- 引入JQuery -->
    <script type="text/javascript" src="resource/js/jquery.js"></script>
    <!-- 引入role.js -->
    <script type="text/javascript">
	    $("#addMajorBtn").on("click",function(){
	        //有验证
	        var major_name = $("#major_name").val();
	        if(major_name===""){
	        	top.layer.alert("专业名不能为空", {title: "错误提示", icon: 5});
	        	return;
        	}
	        $.post("sys/major/add",{major_name:major_name},function(data){
                if(data.flag==="success"){
                	parent.layer.closeAll();
                }else{
                    top.layer.alert(data.message, {title: "错误提示", icon: 5});
                }
          	}); 
	    });
    </script>
</body>
</html>