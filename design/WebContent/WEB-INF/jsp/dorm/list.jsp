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
            <li><a href="javascript:void(0);">学生宿舍管理</a></li>
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
                <th>宿舍名</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dormList }" var="dorm">
	            <tr>
	                <td>${dorm.dorm_id }</td>
	                <td>${dorm.dorm_name }</td>
	                <td><a href="sys/dorm/delete/${dorm.dorm_id }" class="tablelink"> 删除</a></td>
	            </tr>
			</c:forEach>
            </tbody>
        </table>


      <!--   <div class="pagin">
            <div class="message">共<i class="blue">1256</i>条记录，当前显示第&nbsp;<i class="blue">2&nbsp;</i>页</div>
            <ul class="paginList">
                <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
                <li class="paginItem"><a href="javascript:;">1</a></li>
                <li class="paginItem current"><a href="javascript:;">2</a></li>
                <li class="paginItem"><a href="javascript:;">3</a></li>
                <li class="paginItem"><a href="javascript:;">4</a></li>
                <li class="paginItem"><a href="javascript:;">5</a></li>
                <li class="paginItem more"><a href="javascript:;">...</a></li>
                <li class="paginItem"><a href="javascript:;">10</a></li>
                <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
            </ul>
        </div> -->


    </div>

    <script type="text/javascript">
        $('.tablelist tbody tr:odd').addClass('odd');
    </script>

    </body>

</html>