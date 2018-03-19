package com.yzd.servlet;

import com.yzd.classes.UserOperate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

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
        HttpSession session=req.getSession();
        Integer count=(Integer) session.getAttribute("count");
        if(count==null) {
            count = 0;
        }
        if(!uo.isExist(name)){
            resp.getWriter().write("<script>alert('用户不存在！');history.go(-1);</script>");
        }else if(uo.isValid(name, pwd)==-1){
            count++;
            session.setAttribute("count",count);
            actionfalse(count,resp);
        }else {
            actiontrue(count,uo.isValid(name,pwd),req,resp,session);
        }

    }

    public void actionfalse(int count,HttpServletResponse resp) throws ServletException, IOException{
        if(count>=3){
            resp.getWriter().write("<script>alert('密码错误3次！禁止登录!');history.go(-1);</script>");
        }else{
            resp.getWriter().write("<script>alert('密码错误"+count+"次！');history.go(-1);</script>");
        }
    }
    public void actiontrue(int count,int n,HttpServletRequest req,HttpServletResponse resp,HttpSession session) throws ServletException, IOException{
        if(count>=3) {
            resp.getWriter().write("<script>alert('密码错误3次！禁止登录!');history.go(-1);</script>");
        }else{
            session.setAttribute("count",0);
            if(n==0) doSuccess(req, resp);
            if(n==1) doManage(req, resp);
        }
    }

    protected void doSuccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.setAttribute("USERNAME",req.getParameter("user"));
        resp.sendRedirect("success.jsp");
    }
    protected void doManage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.setAttribute("USERNAME",req.getParameter("user"));
        resp.sendRedirect("manage.jsp");
    }
}
