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
    
    <div class="formtitle"><span>管理信息</span></div>
    <form action="" method="post" id="dormForm">
    <ul class="forminfo">
    <li>
        <label>账号</label>
        <input type="text" name="manager_account" id="manager_account" class="dfinput" >
    </li>
    <li>
        <label>密码</label>
        <input type="password" name="manager_password" id="manager_password" class="dfinput" >
    </li>
    <li>
        <label>确认密码</label>
        <input type="password" id="manager_password1" class="dfinput" >
    </li>
    <li>
        <label>姓名</label>
        <input type="text" name="manager_name" id="manager_name" class="dfinput" >
    </li>
    <li>
        <label>权限</label>
        <select name="manager_role" id="manager_role" class="dfinput">   
		    <option value="-1">请选择权限</option>
		    <option value="3">系部管理人员</option> 
		    <option value="2">财务管理人员</option> 
		    <option value="1">宿舍管理人员</option> 
		    <option value="0">系统管理人员</option> 
	    </select> 
    </li>
    <li><label>&nbsp;</label><input type="button" class="btn" id="addDormBtn" value="新增管理员信息"/></li>
    </ul>
    </form>
    
    </div>
    
    <!-- 引入JQuery -->
    <script type="text/javascript" src="resource/js/jquery.js"></script>
    <!-- 引入role.js -->
    <script type="text/javascript">
	    $("#addDormBtn").on("click",function(){
	        //有验证
	        var manager_account = $("#manager_account").val();
	        if(manager_account===""){
	        	top.layer.alert("账号不能为空", {title: "错误提示", icon: 5});
	        	return;
        	}
	        var manager_password = $("#manager_password").val();
	        if(manager_password===""){
	        	top.layer.alert("密码不能为空", {title: "错误提示", icon: 5});
	        	return;
        	}
	        var manager_password1 = $("#manager_password1").val();
	        if(manager_password1===""){
	        	top.layer.alert("确认密码不能为空", {title: "错误提示", icon: 5});
	        	return;
        	}
	        if(manager_password1!=manager_password){
	        	top.layer.alert("两次密码输入不一致", {title: "错误提示", icon: 5});
	        	return;
	        }
	        var manager_name = $("#manager_name").val();
	        if(manager_name===""){
	        	top.layer.alert("姓名不能为空", {title: "错误提示", icon: 5});
	        	return;
        	}
	        var manager_role = $("#manager_role").val();
	        if(manager_role=="-1"){
	        	top.layer.alert("请选择权限", {title: "错误提示", icon: 5});
	        	return;
        	}
	        $.post("sys/manager/add",{
	        	manager_account:manager_account,
	        	manager_password:manager_password,
	        	manager_name:manager_name,
	        	manager_role:manager_role
	        	},function(data){
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