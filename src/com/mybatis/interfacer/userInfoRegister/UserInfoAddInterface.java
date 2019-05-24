package com.mybatis.interfacer.userInfoRegister;

import com.qst.itofferbacker.javabean.UserInfo;
import com.qst.itofferbacker.javabean.UserInfoAdd;
import org.apache.ibatis.annotations.Mapper;

//用户信息添加mybatisMapper接口

public interface UserInfoAddInterface {

    //插入用户信息
    public boolean insertUserInfoAdd(UserInfoAdd userInfoAdd);

    //判断是否存在该用户名称
    public UserInfo selectUserInfoName(Integer USER_ID);
}
