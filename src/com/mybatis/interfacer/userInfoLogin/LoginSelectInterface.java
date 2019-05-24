package com.mybatis.interfacer.userInfoLogin;

import com.qst.itofferbacker.javabean.LoginSelect;
import com.qst.itofferbacker.javabean.UserInfo;
import org.apache.ibatis.annotations.Param;

/*
 * 查询用户名和密码
 * */
public interface LoginSelectInterface {

    public LoginSelect loginSelect(@Param("USER_LOGNAME")String USER_LOGNAME, @Param("USER_PWD")String USER_PWD);


}
