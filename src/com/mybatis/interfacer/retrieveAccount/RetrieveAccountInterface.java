package com.mybatis.interfacer.retrieveAccount;

import com.qst.itofferbacker.javabean.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface RetrieveAccountInterface {

    //查找用户信息
    public UserInfo selectUserInfo(@Param("USER_LOGNAME") String USER_LOGNAME, @Param("USER_REALNAME") String USER_REALNAME, @Param("USER_EMAIL") String USER_EMAIL);

    //将从备份数据库中找到的用户信息插入到用户信息数据库中
    public void insertUserInfo(UserInfo userInfo);

    //删除用户信息
    public void deleteUserInfo(String USER_LOGNAME);

}
