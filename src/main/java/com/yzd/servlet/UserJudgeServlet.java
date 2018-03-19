package com.yzd.servlet;

import com.yzd.classes.UserOperate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserJudgeServlet extends HttpServlet {
    protected void service (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("name");
        UserOperate uo=new UserOperate();
        resp.getWriter().write(""+uo.isExist(username));
    }
}
