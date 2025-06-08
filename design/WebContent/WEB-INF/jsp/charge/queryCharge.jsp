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
<title>无标题文档</title>
<link href="resource/css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

    <div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="javascript:void(0);">收费管理</a></li>
    <li><a href="javascript:void(0);">收费情况查询</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>收费情况查询</span></div>
    
    <ul class="forminfo">
	    <li>
	        <label>姓名</label>
	        <input type="text"  id="student_name" class="dfinput" readonly="readonly" placeholder="检测用文本框,无需输入">
	    </li>
	    <li>
	        <label>学号</label>
	        <input type="text" name="student_id" id="student_id" class="dfinput " placeholder="请输入学号">
	    </li>
	    <li><label>&nbsp;</label><font id="info"></font></li>
	    <li><label>&nbsp;</label><input type="button" class="btn" id="testBtn" value="检测" /><input type="button" class="btn" id="subBtn" value="查询是否缴费" style="display: none;"/></li>
	    </ul>
    </div>
    
    <!-- 引入JQuery -->
    <script type="text/javascript" src="resource/js/jquery.js"></script>
    <!-- 引入role.js -->
    <script type="text/javascript">
	    $("#testBtn").on("click",function(){
	        //有验证
	        var student_id = $("#student_id").val();
	        if(student_id===""){
	        	alert("学号不能为空");
	        	return;
        	}
	        $.post("sys/student/nameTest",{student_id:student_id},function(data){
                if(data.flag==="success"){
                	$("#student_name").val(data.student_name);
                	$("#info").attr("color","green").html("检测成功,请核对信息并进行查询");
                	$("#subBtn").removeAttr("style");
                	$("#testBtn").attr("style","display: none;");
                	$("#student_id").attr("readonly","readonly");
                	
                }else{
                	$("#info").attr("color","red").html("检测失败,请重新输入学号");
                	$("#student_id").val("").focus();
                }
          }); 
	    });
	    $("#subBtn").on("click",function(){
	        //有验证
	        var student_id = $("#student_id").val();
	        if(student_id===""){
	        	alert("学号不能为空");
	        	return;
        	}
	        $.post("sys/student/queryCharge",{student_id:student_id},function(data){
                if(data.flag==="success"){
    	        	alert("该生已缴费");
    	        	location.href ="sys/student/queryCharge";
    	        	return;
                }else{
    	        	alert("该生尚未缴费，即将跳转学生缴费页面");
    	        	location.href ="sys/student/charge";
    	        	return;
                }
          }); 
	    });
    </script>
</body>
</html>