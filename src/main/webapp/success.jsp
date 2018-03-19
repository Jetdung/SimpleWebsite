<%--
  Created by IntelliJ IDEA.
  User: YE
  Date: 2018/1/4
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/success.css" rel="stylesheet" type="text/css"/>
    <title>登录成功</title>
</head>
<body>
<%
    String name=(String)session.getAttribute("USERNAME");               //禁止匿名登录
    if(name==null){
%>
<script>alert('请先登录！');window.location.href='index.html';</script>
<%
    }
%>
<div id="main">
    <div id="header">
        <ul>
            <li><a href="oneday.jsp">一日游</a></li>
            <li><a href="twoday.jsp">二日游</a></li>
            <li><a href="#">暑假特惠</a></li>
            <li><a href="#">周末特惠</a></li>
            <li><a href="#">定制游</a></li>

        </ul>
    </div>
    <div id="content">
        <div id="left">
            <div id="user">
                <h3>用户登录</h3>
                <div id="login">
                    <p>用户：<span id="name"><%=name %></span></p><br/><br/>
                    <p><input id="btn" type="submit" value="退出" onclick="window.location.href='/logout'"/></p>
                </div>
            </div>
        </div>
        <div id="right">
            <h2>欢迎您！</h2>
        </div>
    </div>
    <div id="footer">
        <p>经营许可证编号：京ICP0706888号 京ICP备09000888号</p>
    </div>
</div>
</body>
</html>
