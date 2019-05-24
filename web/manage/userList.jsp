<%@ page import="com.qst.itofferbacker.javabean.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
    <%
    String path = request.getContextPath();
    %>
    <!--<base href="http://localhost:8080/Q_ITOffer/"/>-->
    <meta charset="utf-8">
    <title>企业列表</title>
    <link rel="shortcut icon" href="<%=path%>\images\logo\ico.png" type="image/x-icon" >
    <link href="<%=path%>\css\manageadmin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="place"> <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">用户列表</a></li>
    </ul>
</div>

<div class="rightinfo">
    <div class="tools">
        <ul class="toolbar">
            <li class="click"><span><img src="<%=path%>\images\t01.png" /></span><a href="manage/userAdd.html">添加</a></li>
            <li class="click"><span><img src="<%=path%>\images\t01.png" /></span><a href="manage/passwordModification.html">修改</a></li>
            <li><span><img src="<%=path%>\images\t03.png"/></span><a href="manage/logoff.html">删除</a></li>
        </ul>
        <iframe src="<%=path%>\manage\userSearch.html" scrolling="no" frameborder="0" width="400" height="42"></iframe>
    </div>
    <table class="imgtable">
        <thead>
        <tr>
            <th ><input name="" type="checkbox" value="" checked="checked"/></th>
            <th>用户ID</th>
            <th>用户登录名</th>
            <th>用户密码</th>
            <th>用户真实姓名</th>
            <th>用户Email</th>
            <th>用户角色</th>
            <th>用户状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user" varStatus="userindex">
            <tr height="50px">
                <td ><input name="" type="checkbox" value="" /></td>
                <td>${user.USER_ID}</td>
                <td>${user.USER_LOGNAME}</td>
                <td>${user.USER_PWD}</td>
                <td>${user.USER_REALNAME}</td>
                <td>${user.USER_EMAIL}</td>
                <td>${user.USER_ROLE}</td>
                <td>${user.USER_STATE}</td>
                <td ><a href="userAdd.html" class="tablelink">修改</a> &nbsp;&nbsp;<a href="#" class="tablelink"> 删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagin">
        <ul class="paginList">
            <li class="paginItem"><a href="?curpage=1">首页</a></li>
            <li class="paginItem"></span>
                <c:forEach begin="${page.lpage}" end="${page.rpage}" var="pageNum">
                    <span class="paginItem">
                        <a href="?curpage=${pageNum }">${pageNum }</a>
                    </span>
                </c:forEach>
            </li>
            <li class="paginItem"><a href="javascript:;">下一页<span class="pagenxt"></span></a></li>
            <li class="paginItem"><a href="?curpage=${page.last }">尾页</a></li>
        </ul>
    </div>
</div>
</body>
</html>
