package com.mybatis.interfacer.userInfoUpdate;

import com.qst.itofferbacker.javabean.UserInfo;
import org.apache.ibatis.annotations.Param;

/*
* 更新用户信息
* */
public interface UserInfoUpdateInterface {

    //获取用户真实姓名、密码
    public UserInfo getUserReallyName(@Param("USER_REALNAME") String userReallyName, @Param("USER_PWD") String userPass);

    //更新用户密码
    public void setUserInfoPass(@Param("USER_REALNAME") String userReallyName, @Param("USER_PWD") String userPass);
}
