package com.qst.itofferbacker.servlet.logoff;

import com.mybatis.dao.logOffInfo.LogOffInfoDao;
import com.sendEmail.LogOffSendEmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LogoOffServlet")
public class LogoOffServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取用户信息
        String userName = request.getParameter("userLogname");
        String userPass = request.getParameter("userPwd");
        String userReallyName = request.getParameter("userReallyName");
        String userEmail = request.getParameter("userEmail");

        //判断该用户信息是否存在
        if (new LogOffInfoDao().getUserReallyName(userReallyName,userPass)){
            String sendinfo = "尊敬的"+userReallyName+"，您正在进行——Hern用户注销";
            new LogOffSendEmail().sendEmail(userEmail,sendinfo,userReallyName);
            HttpSession session = request.getSession();
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out =response.getWriter();
            out.print("<script text ='javascript' >");
            out.print(" alert('已经成功注销！');");
            //out.print("window.close()");
            out.print("window.open('index.jsp')");
            out.print("</script>");
            //response.sendRedirect("index.jsp");
        }else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out =response.getWriter();
            out.print("<script text ='javascript' >");
            out.print(" alert('您输入的信息错误，请重新输入！');");
            out.print("window.location='manage/logoff.html';");
            out.print("</script>");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
