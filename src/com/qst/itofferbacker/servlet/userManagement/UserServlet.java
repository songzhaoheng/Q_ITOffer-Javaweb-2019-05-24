package com.qst.itofferbacker.servlet.userManagement;

import com.mybatis.dao.retrieveAccount.RetrieveAccountDao;
import com.mybatis.dao.userInfo.UserInfoDao;
import com.qst.itofferbacker.javabean.Page;
import com.qst.itofferbacker.javabean.PageBean;
import com.qst.itofferbacker.javabean.UserInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取当前页参数，第一次访问为空

        String currPage = req.getParameter("currenPage");

        // 判断，如果为空，则设置为1

        if (currPage == null || "".equals(currPage.trim())) {

            currPage = "1";

        }

        //调用service返回分页类实例

        PageBean<UserInfo> pageBean=new PageService().getPage(currPage);

        //设置相应文本类型

        resp.setContentType("application/json;charset=utf-8");

        //响应前端

        //resp.getWriter().print(new Gson().toJson(pageBean));

    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        /*request.setCharacterEncoding("utf-8");
        String o = request.getParameter("option");

        UserInfoDao userInfoDao = new UserInfoDao();
        response.setContentType("text/html;charset=utf-8");
        HttpSession session  = request.getSession();
        PrintWriter out = response.getWriter();

        //判断用户角色，只能管理员登录
        if("login".equals(o)){
            System.out.println("222222222222");
            String userName = request.getParameter("userLogname");
            String passWord = request.getParameter("userPwd");
            UserInfo userInfo = new RetrieveAccountDao().selectUserInfo(userName,passWord,"null");

            //获取用户角色
            int a  = userInfo.getUSER_ROLE();

            if(a == 1){
                response.sendRedirect("manage/main.html");    //匹配成功重定向到路径/manage/main.html
                session.setAttribute("LoginUser",userName);
            }else if(a == -1){
                out.print("<script type='text/javascript'> alert('您的权限不足！');");
                out.print("window.location='login.html';");
                out.print("</script>");
            }
            else{
                out.print("<script type='text/javascript'> alert('账号密码错误！');");
                out.print("window.location='login.html';");
                out.print("</script>");
            }

        }


        session.setAttribute("list",new UserInfoDao().selectUser());

        if("selectAll".equals(o)||"PageNext".equals(o)||"PagePrevious".equals(o)||"firstPage".equals(o)||"lastPage".equals(o)){  //查找所有用户的所有
            Page page = new Page();
            List<UserInfo> list = new ArrayList<UserInfo>();

            if("selectAll".equals(o)){
                //查询页数
                int allCount = userInfoDao.selectCount();   //查询有多少条数据
                page.setNowPage(1);
                page.setAllCount(allCount);
                session.setAttribute("userPage",page);

                //根据每页多少条数据来查询用户
                list = userInfoDao.selectAllUser(page);
                session.setAttribute("allUser",list);
                response.sendRedirect("manage/userList.jsp");
            }
            if("PageNext".equals(o)){
                int allCount = userInfoDao.selectCount();   //查询有多少条数据
                page.setAllCount(allCount);

                String nowpage = request.getParameter("nowPage");
                int nowPage = Integer.parseInt(nowpage);

                page.setNowPage(nowPage);       //获取当前页
                if(page.getNowPage() < page.getPage()){    //如果当前页面小于总页面数才可以进行下一页操作
                    page.setNowPage(nowPage+1);
                    list = userInfoDao.selectAllUser(page);
                    session.setAttribute("allUser",list);
                    session.setAttribute("userPage",page);
                    response.sendRedirect("manage/userList.jsp");
                }else{
                    response.sendRedirect("manage/userList.jsp");
                }
            }
            if("PagePrevious".equals(o)){   //上一页
                int allCount = userInfoDao.selectCount();   //查询有多少条数据
                page.setAllCount(allCount);

                String nowpage = request.getParameter("nowPage");
                int nowPage = Integer.parseInt(nowpage);

                page.setNowPage(nowPage);       //获取当前页
                if(page.getNowPage() != 1){    //如果当前页面不是第一页
                    page.setNowPage(nowPage-1);
                    list = userInfoDao.selectAllUser(page);
                    session.setAttribute("allUser",list);
                    session.setAttribute("userPage",page);
                    response.sendRedirect("manage/userList.jsp");
                }else{
                    response.sendRedirect("manage/userList.jsp");
                }
            }
            if("firstPage".equals(o)){   //首页
                int allCount = userInfoDao.selectCount();   //查询有多少条数据
                page.setAllCount(allCount);

                page.setNowPage(1);
                list = userInfoDao.selectAllUser(page);
                session.setAttribute("allUser",list);
                session.setAttribute("userPage",page);
                response.sendRedirect("manage/userList.jsp");

            }
            if("lastPage".equals(o)){   //尾页
                int allCount = userInfoDao.selectCount();   //查询有多少条数据
                page.setAllCount(allCount);

                page.setNowPage(page.getPage());
                list = userInfoDao.selectAllUser(page);
                session.setAttribute("allUser",list);
                session.setAttribute("userPage",page);
                response.sendRedirect("manage/userList.jsp");
            }
        }
        */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
}
