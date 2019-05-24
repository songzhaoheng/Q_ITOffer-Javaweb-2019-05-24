package com.qst.itofferbacker.servlet.userManagement;

import com.mybatis.dao.userInfo.UserInfoDao;
import com.qst.itofferbacker.javabean.Page;
import com.qst.itofferbacker.javabean.PageBean;
import com.qst.itofferbacker.javabean.UserInfo;

import java.io.IOException;
import java.util.List;

public class PageService {

    public PageBean getPage(String currPage) throws IOException {

        //类型转换 当前页数

        Integer currenPage = Integer.valueOf(currPage);

        //实例化分页类

        PageBean<UserInfo> pageBean = new PageBean();

        //实例化CityDaoImpl类
        UserInfoDao userInfoDao = new UserInfoDao();


        //数据库第几行开始查询

        int startPage=(currenPage-1)*pageBean.getPageCount();

        //查询多少行数据 分页类里默认30行

        int selectCount=pageBean.getPageCount();

        //查询数据库获取分页返回的数据 : select * from regional_info limit startPage,selectCount

        List<UserInfo> list=userInfoDao.selectAllUser(new Page());

        //获取总数

        int cityCount=userInfoDao.selectCount();

        //设置查询的数据

        pageBean.setPageData(list);

        //共多少行

        pageBean.setTotalCount(cityCount);

        //设置总页数
        pageBean.setTotalPage(cityCount/pageBean.getPageCount()+1);

        return pageBean;
    }

}
