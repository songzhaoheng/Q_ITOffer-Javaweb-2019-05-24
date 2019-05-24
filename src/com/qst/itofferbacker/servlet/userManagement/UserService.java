package com.qst.itofferbacker.servlet.userManagement;

import com.qst.itofferbacker.javabean.Page;
import com.qst.itofferbacker.javabean.UserInfo;

import java.io.IOException;
import java.util.List;

public interface UserService {
    /**
     * 获取总数量
     * @return 返回总数
     */
    int getAmount() throws IOException;

    /**
     * 获取当前页的数据
     * @param page
     * @return 返回前页的数据
     */
    List<UserInfo> getUserInfo(Page page) throws IOException;
}
