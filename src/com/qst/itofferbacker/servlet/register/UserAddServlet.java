package com.qst.itofferbacker.servlet.register;

import com.mybatis.dao.userInfo.UserInfoDao;
import com.mybatis.dao.userInfoRegister.UserInfoAddDao;
import com.qst.itofferbacker.javabean.UserInfoAdd;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/*
* 用户信息添加Servlet
* */
@WebServlet("/useraddServlet")
public class UserAddServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //对用户信息进行编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取用户信息
        String userLogname = request.getParameter("userLogname");
        String userPwd = request.getParameter("userPwd");
        String userRealname = request.getParameter("userRealname");
        String userEmail = request.getParameter("userEmail");
        String userRole = request.getParameter("userRole");
        String userState = request.getParameter("userState");

        //将用户角色和用户状态进行转换
        int role = Integer.parseInt(userRole);
        int state = Integer.parseInt(userState);

        System.out.println(userEmail+" " + userLogname+" " +userPwd+" "+userRealname+" "+userRole+" "+userState);

        UserInfoDao userInfoDao = new UserInfoDao();

        //判断该用户信息是否存在：用户名、用户真实名、用户邮箱
        //该用户信息存在
        if(userInfoDao.getUserName(userLogname)==false&&userInfoDao.getUserEmail(userEmail)==false&&userInfoDao.getUserReallyName(userRealname)==false){
            UserInfoAdd userInfoAdd = new UserInfoAdd(userLogname,userPwd,userRealname,userEmail,role,state);
            new UserInfoAddDao().userInfoAddDao(userInfoAdd);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out =response.getWriter();
            out.print("<script text ='javascript' >");
            out.print(" alert('添加成功！');");
            out.print("</script>");
            response.sendRedirect("manage/userList.html");
        }else{
            response.sendRedirect("html/registered_fail.html");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
