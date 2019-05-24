package com.qst.itofferbacker.servlet.login;

import com.mybatis.dao.userInfoLogin.LoginSelectDao;
import com.qst.itofferbacker.javabean.LoginSelect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/*
* 登录检查Servlet
* */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取用户名和密码
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");

        //进行用户名和密码的检验
        if(new LoginSelectDao().loginSelect(username,userpass)){

            HttpSession session = request.getSession(); //
            session.setAttribute("username", username); //存登录信息
            response.sendRedirect("manage/main.html");
        }else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out =response.getWriter();
            out.print("<script text ='javascript' >");
            out.print(" alert('用户名或密码错误');");
            out.print("window.location='login.html';");
            out.print("</script>");
            response.sendRedirect("html/login_fail.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理用户退出的逻辑
        String type=request.getParameter("type");
        if("logout".equals(type)) {  //用户退出
            HttpSession session = request.getSession();
            session.invalidate();//清空session
            //页面跳转，跳转到登录界面
            response.sendRedirect("index.jsp");
        }
    }
}
