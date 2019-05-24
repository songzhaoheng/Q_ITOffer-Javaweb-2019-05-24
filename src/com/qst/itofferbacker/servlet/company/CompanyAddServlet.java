package com.qst.itofferbacker.servlet.company;

import com.mybatis.dao.CompanyInfo.CompanyInfoDao;
import com.mybatis.dao.companyInfoRegister.CompanyInfoRegisterDao;
import com.qst.itofferbacker.javabean.CompanyInfoAdd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.MultipartConfig;

@WebServlet("/CompanyAddServlet")
@MultipartConfig
public class CompanyAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String companyName =  request.getParameter("companyName");//企业名称
        String companyArea =  request.getParameter("companyArea");//企业所在地
        String companySize =  request.getParameter("companySize");//企业规模
        String companyType =  request.getParameter("companyType");//企业性质

        String companyBrief =  request.getParameter("companyBrief");//企业简介
        String companyState =  request.getParameter("companyState");//企业招聘状态
        String companySort =  request.getParameter("companySort");//企业顺序
        Part part = request.getPart("companyPic");
        //一个是给图片赋予一个存放路径 (计划将这个图片放在与这个项目同级的一个文件夹upload/image)
        String path = getServletContext().getRealPath("/");
        String projectName = getServletContext().getServletContextName();
        path = path.substring(0,path.indexOf(projectName) );
        path=path+"/upload/image/";
        File f = new File(path);
        if(!f.exists()) {
            f.mkdirs();
        }
        //取文件扩展名
        String fileName = part.getHeader("Content-Disposition");
        String kzm= fileName.substring(fileName.indexOf("."));//.jpg .png
        String newFileName =System.currentTimeMillis()+kzm;
        //将part对象写入到最新的文件
        part.write(path+newFileName); //完成图片存储

        //判断企业信息是否存在
        if(new CompanyInfoDao().getCompanyName(companyName)){
            response.sendRedirect("/html/companyRegister_fail.html");

        }else {
            //存储企业相关的数据到数据库
            CompanyInfoAdd companyInfoAdd = new CompanyInfoAdd(companyName,companyArea,companySize,companyType,companyBrief,Integer.parseInt(companyState),Integer.parseInt(companySort),"0",newFileName);

            new CompanyInfoRegisterDao().setCompanyInfoRegister(companyInfoAdd);

            //请求转发 重定向
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script type='text/javascript' >");
            out.print(" alert('企业信息添加成功');");
            out.print(" window.location='manage/companyList.html';");
            //js代码实现页面
            out.print("</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
}
