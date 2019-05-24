package com.qst.itofferbacker.servlet.login;

import com.mybatis.dao.passwordBack.PasswordBackDao;
import com.sendEmail.SendEmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/passwordBackServlet")
public class PasswordBackServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String userName = request.getParameter("userName");
        String userReallyName = request.getParameter("userReallyName");
        String userEmail = request.getParameter("userEmail");

        String userPass = new PasswordBackDao().selectUserInfo(userName,userReallyName,userEmail);
        String sendinfo = "尊敬的"+userReallyName+"，您正在进行——Hern商城密码找回";

        if (userPass != null){
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out =response.getWriter();
            out.print("<script text ='javascript' >");
            out.print(" alert('密码已发送至邮箱');");
            out.print("window.location='index.jsp';");
            out.print("</script>");
            new SendEmail().sendEmail(userEmail,sendinfo,userPass);
        }else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out =response.getWriter();
            out.print("<script text ='javascript' >");
            out.print(" alert('您输入的信息错误，请重新输入！');");
            out.print("window.location='jsp/passwordBack.jsp';");
            out.print("</script>");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
