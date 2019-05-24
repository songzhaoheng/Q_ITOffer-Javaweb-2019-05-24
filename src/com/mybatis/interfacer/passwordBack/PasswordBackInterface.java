package com.mybatis.interfacer.passwordBack;

import com.qst.itofferbacker.javabean.UserInfo;
import org.apache.ibatis.annotations.Param;

/*
* 查询用户信息，方便进行用户密码找回
* */
public interface PasswordBackInterface {

    public UserInfo selectUserInfo(@Param("USER_LOGNAME") String USER_LOGNAME,@Param("USER_REALNAME") String USER_REALNAME, @Param("USER_EMAIL") String USER_EMAIL);
}
