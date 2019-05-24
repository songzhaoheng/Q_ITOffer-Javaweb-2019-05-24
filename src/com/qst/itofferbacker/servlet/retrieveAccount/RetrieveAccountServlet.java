package com.qst.itofferbacker.servlet.retrieveAccount;

import com.mybatis.dao.passwordBack.PasswordBackDao;
import com.mybatis.dao.retrieveAccount.RetrieveAccountDao;
import com.qst.itofferbacker.javabean.UserInfo;
import com.sendEmail.SendEmail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/retrieveAccountServlet")
public class RetrieveAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String userName = request.getParameter("userName");
        String userReallyName = request.getParameter("userReallyName");
        String userEmail = request.getParameter("userEmail");

        //获取用户信息
        UserInfo userInfo = new RetrieveAccountDao().selectUserInfo(userName,userReallyName,userEmail);

        //判断是否找到存在该用户信息
        if (userInfo != null){
            //将找回的用户信息从备份数据库中删除
            new RetrieveAccountDao().deleteUserInfo(userInfo.getUSER_LOGNAME());

            //将找回的用户信息插入到数据库中
            new RetrieveAccountDao().insertUserInfo(userInfo);

            String sendinfo = "尊敬的"+userReallyName+"，您正在进行——Hern商城账户找回";

            response.setContentType("text/html;charset=utf-8");
            PrintWriter out =response.getWriter();
            out.print("<script text ='javascript' >");
            out.print(" alert('您已成功找回，账户信息已发送至您的邮箱');");
            out.print("window.location='index.jsp';");
            out.print("</script>");
            new SendEmail().sendEmail(userEmail,sendinfo,userInfo.getUSER_PWD());
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
