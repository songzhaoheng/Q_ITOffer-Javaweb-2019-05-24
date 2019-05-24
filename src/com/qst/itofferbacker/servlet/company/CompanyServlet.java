package com.qst.itofferbacker.servlet.company;

import com.mybatis.dao.CompanyInfo.CompanyInfoDao;
import com.qst.itofferbacker.javabean.CompanyInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CompanyServlet")
@MultipartConfig
public class CompanyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        if ("list".equals(type)) { //查询所有企业信息
            List<CompanyInfo> list = new CompanyInfoDao().selectCompanyInfo();
            request.setAttribute("list", list);
            RequestDispatcher dispatch = request.getRequestDispatcher("manage/CompanyList.jsp");
            dispatch.forward(request, response);
        }
    }
}
