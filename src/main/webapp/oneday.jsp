<%@ page import="java.util.List" %>
<%@ page import="com.yzd.classes.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.yzd.classes.UserOperate" %>
<%@ page import="com.yzd.classes.ItemOperate" %><%--
  Created by IntelliJ IDEA.
  User: YE
  Date: 2018/1/4
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/travel.css" rel="stylesheet" type="text/css"/>
    <script src="js/travel.js"></script>
    <title>一日游</title>
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
            <table id="table" border="1" cellpadding="0" cellspacing="0" >
                <tr height="25px">
                    <th>景点</th><th>价格</th><th>详情</th>
                </tr>
                <tbody id="itable">
                <%
                    ItemOperate io=new ItemOperate();
                    List<Item> list= io.getAllItem();
                    for(int i=0;i<list.size();i++){
                        if(list.get(i).getType()==1){
                            out.print("<tr>" +
                                    "<td><img src=\"images/"+list.get(i).getSight()+".png\"/><br/><input onclick=\"GetRadioValue()\" type=\"radio\" name=\"radios\" value=\""+list.get(i).getPrice()+"\"/>"+"<input style=\"display:none\" type=\"radio\" name=\"ra\" value=\""+list.get(i).getItemid()+"\"/>"+list.get(i).getSight()+"</td>"+
                                    "<td>￥"+list.get(i).getPrice()+"</td>"+
                                    "<td id=\"detail\">"+list.get(i).getDetail()+"</td>"+
                                    "</tr>");
                        }
                    }
                %>
                </tbody>
            </table>
            <div id="paging">
                <div id="barcon" name="barcon"></div>
            </div>
            <div id="bottom">
                人数：<input class="control" type="button" value="-" onclick="sub()">
                <span id="n">1</span>
                <input class="control" type="button" value="+" width="50px" onclick="plus()">
                <span id="pri">价格：￥<span id="price">0</span><span id="hid"></span></span>
                <input id="st" type="submit" value="提交" onclick="goorder()">
            </div>

        </div>
    </div>
    <div id="footer">
        <p>经营许可证编号：京ICP0706888号 京ICP备09000888号</p>
    </div>
</div>
</body>
</html>
