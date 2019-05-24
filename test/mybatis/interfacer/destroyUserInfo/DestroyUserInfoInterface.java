package mybatis.interfacer.destroyUserInfo;

import itofferbacker.javabean.UserInfoBackSelect;

import java.util.List;

public interface DestroyUserInfoInterface {

    //获取备份数据库的用户信息，7天前的用户信息
    public List<UserInfoBackSelect> selectUserInfoBackDate();

    //删除备份数据
    public void deleteUserInfoBack(int id);
}
