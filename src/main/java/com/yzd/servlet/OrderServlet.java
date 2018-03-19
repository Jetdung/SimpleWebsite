package com.yzd.servlet;

import com.yzd.classes.Item;
import com.yzd.classes.ItemOperate;
import com.yzd.classes.OrderOperate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class OrderServlet extends HttpServlet{
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String name=req.getParameter("name");
        int num=Integer.parseInt(req.getParameter("n"));
        Double price=Double.parseDouble(req.getParameter("price"));
        int i=Integer.parseInt(req.getParameter("num"));
        ItemOperate io=new ItemOperate();
        List<Item> list=io.getAllItem();
        OrderOperate oo=new OrderOperate();
        oo.inserOrder(name,num,i,price);
        resp.getWriter().write("<script>alert('支付成功！');window.history.go(-1);</script>");
    }
}
