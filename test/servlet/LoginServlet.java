package servlet;

import com.qst.itofferbacker.javabean.LoginSelect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* 登录检查Servlet
* */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取用户名和密码
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");

        //封装成JavaBean对象
        LoginSelect loginSelect = new LoginSelect(username,userpass);

        //进行用户名和密码的检验

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
