package com.mybatis.interfacer.userInfo;

import com.qst.itofferbacker.javabean.Page;
import com.qst.itofferbacker.javabean.UserInfo;
import com.qst.itofferbacker.javabean.UserInfoAdd;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
* mybatisMapper接口
* */
public interface UserInfoInterface {

    //插入用户信息
    public boolean setinsertUserInfo(UserInfoAdd userInfoAdd);

    //获取用户名称
    public UserInfo getUserName(String userName);

    //获取用户邮箱
    public UserInfo getUserEmail(String userEmail);

    //获取用户真实姓名
    public UserInfo getUserReallyName(String userReallyName);

    //获取用户数
    public int getPageNum();

    //查询所有用户
    public List<UserInfo> selectAllUser(@Param("offSet") int nowCount, @Param("limit") int numBer);

    //获取所有用户
    public List<UserInfo> selectUser();
}
