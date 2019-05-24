package com.mybatis.interfacer.logOffInfo;

import com.qst.itofferbacker.javabean.UserInfo;
import com.qst.itofferbacker.javabean.UserInfoAdd;
import com.qst.itofferbacker.javabean.UserInfoBack;
import com.qst.itofferbacker.javabean.UserInfoBackSelect;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/*
* 注销用户信息接口
* */
public interface LogOffInfoInterface {

    //获取用户真实姓名、密码
    public UserInfo getUserReallyName(@Param("USER_REALNAME") String userReallyName, @Param("USER_PWD") String userPass);

    //删除用户信息
    public void deleteUserInfo(int USER_ID);

    //向备份表中插入
    public void insertUserInfoBack(UserInfoBack userInfoBack);

}
