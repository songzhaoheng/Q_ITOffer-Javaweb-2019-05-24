package com.qst.itofferbacker.servlet.passwordModification;

import com.mybatis.dao.userInfoUpdate.UserInfoUpdateDao;
import com.qrCode.CreateQRCode;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/PasswordModificationServlet")
public class PasswordModificationServlet extends HttpServlet {

    public PasswordModificationServlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //更新二维码信息
        try {
            new CreateQRCode().code();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        //更新二维码信息
        new CreateQRCode().code();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //更新二维码信息
        new CreateQRCode().code();

        //获取信息
        String userReallyName = request.getParameter("userLogname");
        String userPass = request.getParameter("userPwd");
        String userNewPass = request.getParameter("userNewPwd");

        //
        if(new UserInfoUpdateDao().getUserReallyName(userReallyName,userPass)){
            //更新密码
            new UserInfoUpdateDao().setUserInfoPass(userReallyName,userNewPass);
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out =response.getWriter();
            out.print("<script text ='javascript' >");
            out.print(" alert('修改成功');");
            out.print("window.location='manage/index.html';");
            out.print("</script>");
        }else {//该用户不存在
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out =response.getWriter();
            out.print("<script text ='javascript' >");
            out.print(" alert('该用户不存在');");
            out.print("window.location='manage/passwordModification.html';");
            out.print("</script>");

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
