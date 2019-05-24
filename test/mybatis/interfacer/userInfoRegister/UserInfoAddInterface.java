package mybatis.interfacer.userInfoRegister;

import itofferbacker.javabean.UserInfo;
import itofferbacker.javabean.UserInfoAdd;

//用户信息添加mybatisMapper接口

public interface UserInfoAddInterface {

    //插入用户信息
    public boolean insertUserInfoAdd(UserInfoAdd userInfoAdd);

    //判断是否存在该用户名称
    public UserInfo selectUserInfoName(Integer USER_ID);
}
