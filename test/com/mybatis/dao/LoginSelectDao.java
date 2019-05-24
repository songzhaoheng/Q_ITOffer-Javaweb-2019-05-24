package com.mybatis.dao;

import com.mybatis.MyBatisSqlSessionFactory;
import com.mybatis.interfacer.userInfoLogin.LoginSelectInterface;
import com.qst.itofferbacker.javabean.LoginSelect;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;

/*
* 查询用户名、密码是否存在
* */
public class LoginSelectDao {

    public boolean loginSelect(String userName, String userPass) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();


        try {

            LoginSelectInterface loginSelectInterface = sqlSession.getMapper(LoginSelectInterface.class);

            LoginSelect loginSelect1 = loginSelectInterface.loginSelect(userName, userPass);
            System.out.println(loginSelect1.toString());

            if (loginSelect1 != null){
                return true;
            }else {
                return false;
            }
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void test() throws IOException {

        System.out.println(new LoginSelectDao().loginSelect("test","123456"));
    }

}
