package com.mybatis.dao.userInfoRegister;

import com.mybatis.MyBatisSqlSessionFactory;
import com.mybatis.interfacer.userInfoRegister.UserInfoAddInterface;
import com.qst.itofferbacker.javabean.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;

//判断用户名是否重复
public class UserInfoAddSelectDao {

    @Test
    public void test() throws IOException {
        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try{

            UserInfoAddInterface userInfoAddInterface = sqlSession.getMapper(UserInfoAddInterface.class);

            UserInfo userInfo = userInfoAddInterface.selectUserInfoName(1);
            System.out.println(UserInfoAddInterface.class);
            System.out.println(UserInfo.class);
            System.out.println(userInfo.toString());

        }finally {
            sqlSession.close();
        }
    }
}
