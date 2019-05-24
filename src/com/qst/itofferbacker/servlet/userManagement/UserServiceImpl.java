package com.qst.itofferbacker.servlet.userManagement;

import com.mybatis.dao.userInfo.UserInfoDao;
import com.qst.itofferbacker.javabean.Page;
import com.qst.itofferbacker.javabean.UserInfo;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserInfoDao userInfoDao;
    {
        userInfoDao = new UserInfoDao();
    }

    @Override
    public int getAmount() throws IOException {
        return userInfoDao.selectCount();
    }

    @Override
    public List<UserInfo> getUserInfo(Page page) throws IOException {
        return userInfoDao.selectAllUser(page);
    }
}
