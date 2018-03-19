<%@ page import="com.yzd.classes.UserOperate" %>
<%@ page import="com.yzd.classes.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: YE
  Date: 2018/1/4
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/manage.css" rel="stylesheet" type="text/css"/>
    <script src="js/manage.js" charset="UTF-8"></script>
    <title>登录成功</title>
</head>
<body onLoad="goPage(1);">
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
            <h2>用户信息管理</h2>
            <table id="table" border="2" cellpadding="0" cellspacing="0" width="400" >
                <tr>
                <th>用户名</th><th>密码</th><th>类型</th><th>操作</th>
                </tr>
                <tbody id="itable">
                <%
                    UserOperate uo = new UserOperate();
                    List<User> list=uo.getAllUser();
                    for(User user:list){
                        out.print("<tr>" +
                                "<td>"+user.getName()+"</td>"+
                                "<td>"+user.getPwd()+"</td>"+
                                "<td>"+user.getType()+"</td>"+
                                "<td><a href='/delete?username="+user.getName()+"' onclick='return del();'>删除</a></td>" +
                                "</tr>");
                    }
                %>
                </tbody>
            </table>
            <div id="paging">
                <div id="barcon" name="barcon"></div>
            </div>

        </div>
    </div>
    <div id="footer">
        <p>经营许可证编号：京ICP0706888号 京ICP备09000888号</p>
    </div>
</div>
<script>zebrastripe()</script>
</body>
</html>
