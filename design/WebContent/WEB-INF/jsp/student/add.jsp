<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	pageContext.setAttribute("path", path);
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML>
<html>
	<head>
		<base href="basePath">
		<meta charset="UTF-8">
		<title>添加学生</title>
		<link href="${basePath }resource/css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="place">
		    <span>位置：</span>
		    <ul class="placeul">
			    <li>首页</li>
			    <li>添加学生</li>
		    </ul>
	    </div>
	    <form method="post" action="${basePath }sys/student/add" id="studentForm">
		    <div class="formbody">
		    	<div class="formtitle"><span>学生信息</span></div>
			    <ul class="forminfo">
				    <li><label>姓名</label><input onkeyup="value=value.replace(/[\d]/g,'')" onchange="value=value.replace(/[\d]/g,'')" id="student_name" name="student_name" type="text" class="dfinput" maxlength="10"/><i>姓名不能超过10个字符</i></li>
				    <li><label>年龄</label><input id="student_age" name="student_age" type="tel" class="dfinput" onkeyup="this.value=this.value.replace(/\D/g,'')" onchange="this.value=this.value.replace(/\D/g,'')" maxlength="3"/></li>
				    <li><label>性别</label><cite><input id="student_sex" name="student_sex" type="radio" value="1" checked="checked" />男&nbsp;&nbsp;&nbsp;&nbsp;<input id="student_sex" name="student_sex" type="radio" value="0" />女</cite></li>
				    <li><label>政治面貌</label><cite><input id="student_social_presence" name="student_social_presence" type="radio" value="0" checked="checked" />群众&nbsp;&nbsp;&nbsp;&nbsp;<input id="student_social_presence" name="student_social_presence" type="radio" value="1" />团员&nbsp;&nbsp;&nbsp;&nbsp;<input id="student_social_presence" name="student_social_presence" type="radio" value="2" />党员</cite></li>
				    <li>
				    	<label>专业</label>
					    <select name="student_major" id="student_major" class="dfinput">   
						    <option value="0">请选择专业</option>
						    <c:forEach items="${majorList }" var="ml" >
						    	<option value="${ml.major_id }">${ml.major_name }</option> 
						    </c:forEach>
					    </select>  
				    </li>
				    <li><label>联系电话</label><input id="student_tel" name="student_tel" type="tel" class="dfinput" onkeyup="this.value=this.value.replace(/\D/g,'')" onchange="this.value=this.value.replace(/\D/g,'')" maxlength="11"/></li>
				    <li><label>家庭住址</label><input id="student_home" name="student_home" type="text" class="dfinput" maxlength="50"/><i>家庭住址不能超过50个字符</i></li>
				    <li><label>&nbsp;</label><input id="addBtn" name="addBtn" type="button" class="btn" value="添加"/></li>
			    </ul>
		    </div>
	    </form>
	   	<script type="text/javascript" src="${basePath }resource/js/jquery.js"></script>
	   	<script type="text/javascript">
	   		$("#addBtn").on("click",function(){	
	   			var student_name = $("#student_name").val();
	   			var student_age = $("#student_age").val();
	   			var student_major = $("#student_major").val();
	   			var student_tel = $("#student_tel").val();
	   			var student_home = $("#student_home").val();
	   			if(student_name === ""){
	   				alert("请输入学生姓名!");
	   				return;
	   			}
	   			if(student_age === ""){
	   				alert("请输入学生年龄!");
	   				return;
	   			}
	   			if(parseInt(student_age)>150 || parseInt(student_age)==0){
	   				alert("请输入正确的学生年龄!");
	   				return;
	   			}
	   			if(student_major === "" || student_major === "0"){
	   				alert("请选择学生专业!");
	   				return;
	   			}
	   			if(student_tel === ""){
	   				alert("请输入学生联系电话!");
	   				return;
	   			}
	   			if(student_tel.length != 7 && student_tel.length != 11){
	   				alert("请输入正确的电话格式!");
	   				return;
	   			}
	   			if(student_home === ""){
	   				alert("请输入学生家庭住址!");
	   				return;
	   			}
	   			$("#studentForm").submit();
	   		});	   	
	   	</script>
	</body>
</html>