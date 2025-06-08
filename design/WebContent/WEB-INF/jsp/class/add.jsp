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
    
    <div class="formtitle"><span>班级信息</span></div>
    <form action="" method="post" id="dormForm">
    <ul class="forminfo">
    <li>
    	<label>专业</label>
	    <select name="class_major" id="class_major" class="dfinput">   
		    <option value="0">请选择专业</option>
		    <c:forEach items="${majorList }" var="ml" >
		    	<option value="${ml.major_id }">${ml.major_name }</option> 
		    </c:forEach>
	    </select>  
    </li>
    <li>
        <label>班级名称</label>
        <input type="text" name="class_name" id="class_name" class="dfinput" >
    </li>
    <li><label>&nbsp;</label><input type="button" class="btn" id="addClassBtn" value="新增班级"/></li>
    </ul>
    </form>
    
    </div>
    
    <!-- 引入JQuery -->
    <script type="text/javascript" src="resource/js/jquery.js"></script>
    <!-- 引入role.js -->
    <script type="text/javascript">
	    $("#addClassBtn").on("click",function(){
	        //有验证
	        var class_name = $("#class_name").val();
	        var class_major = $("#class_major").val();
	        if(class_major==0){
	        	top.layer.alert("请选择专业", {title: "错误提示", icon: 5});
	        	return;
        	}
	        if(class_name===""){
	        	top.layer.alert("班级名不能为空", {title: "错误提示", icon: 5});
	        	return;
        	}
	        $.post("sys/class/add",{class_name:class_name,class_major:class_major},function(data){
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