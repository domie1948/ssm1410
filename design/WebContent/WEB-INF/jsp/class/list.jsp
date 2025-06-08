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
                        content: 'sys/class/add',
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
            <li><a href="javascript:void(0);">班级管理</a></li>
        </ul>
    </div>

    <div class="rightinfo">
        <div class="tools">
            <ul class="toolbar">
                <li class="click" id="add"><span><img src="resource/images/t01.png"/></span>添加</li>
            </ul>
            <ul class="toolbar1">
            </ul>
        </div>


        <table class="tablelist">
            <thead>
            <tr>
                <th>编号</th>
                <th>所属专业</th>
                <th>班级名</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${classesList }" var="classes">
	           <tr>
	                <td>${classes.class_id}</td>
	                <td>${classes.class_major }</td>
	                <td>${classes.class_name }</td>
	                <td><a href="sys/class/delete/${classes.class_id }" class="tablelink" onClick="return confirm('确定删除?');"> 删除</a></td>
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