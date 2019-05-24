package com.qst.itofferbacker.servlet.userManagement;

import com.qst.itofferbacker.javabean.Page;
import com.qst.itofferbacker.javabean.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ListServlet")
public class ListServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("...doGet...");

        // 获取当前页
        String curpage = req.getParameter("curpage");
        UserService userService = new UserServiceImpl();
        // 获取总数量
        int count = userService.getAmount();
        //字符串转成整型
        int currentpage = super.currentPage(curpage);
        // 创建page对象
        Page page = new Page(count, currentpage, pagesize);
        // 获取当前页的数据
        List<UserInfo> users = userService.getUserInfo(page);
        //将相关数据存储起来
        req.setAttribute("page", page);
        req.setAttribute("users", users);

        //转发
        req.getRequestDispatcher("manage/userList.jsp").forward(req, resp);
    }

}
