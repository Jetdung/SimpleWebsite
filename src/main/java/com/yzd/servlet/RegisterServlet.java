package com.yzd.servlet;

import com.yzd.classes.UserOperate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        UserOperate uo = new UserOperate();
        String name = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        if(uo.isExist(name)) {
            resp.getWriter().write("<script>alert('用户已存在！');history.go(-1);</script>");
        }else{
            uo.insertUser(name,pwd);
            resp.getWriter().write("<script>alert('注册成功！');window.location.href='index.html';</script>");
        }


    }
}
