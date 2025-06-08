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
<link href="resource/css/style.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="resource/js/jquery.js"></script>
        <script type="text/javascript" src="resource/layer/layer.js"></script>
        <script type="text/javascript" src="resource/commons/hp_layer_helper-v0.1.js"></script>
        <script>
            $(function () {
                //绑定添加事件
                $("#add").click(function () {
                	top.layer.open({
                        type: 2,
                        area: ['700px', '530px'],
                        fix: false, //不固定
                        maxmin: true,
                        content: 'sys/dorm/add',
                        end: function () {
                            location.reload();
                        }
                    })
                })

            });


        </script>


    </head>
    <body>

    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="javascript:void(0);">基础数据管理</a></li>
            <li><a href="javascript:void(0);">录取学生名册</a></li>
        </ul>
    </div>

    <div class="rightinfo">
        <table class="tablelist">
            <thead>
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>性别	</th>
                <th>政治面貌	</th>
                <th>专业</th>
                <th>班级</th>
                <th>宿舍</th>
                <th>联系电话</th>
                <th>家庭住址</th>
                <th>是否缴费</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${studentsList }" var="student">
	            <tr>
	                <td>${student.student_id }</td>
	                <td>${student.student_name }</td>
	                <td>${student.student_age }</td>
	                <td>
	                	<c:if test="${student.student_sex == 0}">女</c:if>
	                	<c:if test="${student.student_sex == 1}">男</c:if>
	                </td>
	                <td>
	                	<c:if test="${student.student_sex == 0}">群众</c:if>
	                	<c:if test="${student.student_sex == 1}">团员</c:if>
	                	<c:if test="${student.student_sex == 2}">党员</c:if>
	                </td>
	                <td>
	                	<c:forEach items="${majorList }" var="major">
	                		<c:if test="${student.student_major == major.major_id}">${major.major_name}</c:if>
	                	</c:forEach>
	                </td>
	                <td>
	                	<c:if test="${student.student_class == 0}">尚未分班</c:if>
	                	<c:forEach items="${classesList }" var="classes">
	                		<c:if test="${student.student_class == classes.class_id}">${classes.class_name}</c:if>
	                	</c:forEach>
	                </td>
	                <td>
	                	<c:if test="${student.student_dorm == 0}">尚无宿舍</c:if>
	                	<c:forEach items="${dormList }" var="dorm">
	                		<c:if test="${student.student_dorm == dorm.dorm_id}">${dorm.dorm_name}</c:if>
	                	</c:forEach>
	                </td>
	                <td>${student.student_tel }</td>
	                <td>${student.student_home }</td>
	                <td>
	                	<c:if test="${student.student_tuition == 0}">尚未缴费</c:if>
	                	<c:if test="${student.student_tuition == 1}">已缴费</c:if>
	                </td>
	            </tr>
			</c:forEach>
            </tbody>
        </table>
    </div>
    <script type="text/javascript">
        $('.tablelist tbody tr:odd').addClass('odd');
    </script>

    </body>

</html>