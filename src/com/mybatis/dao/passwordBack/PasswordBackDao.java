package com.mybatis.dao.passwordBack;

import com.mybatis.MyBatisSqlSessionFactory;
import com.mybatis.interfacer.passwordBack.PasswordBackInterface;
import com.qst.itofferbacker.javabean.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;

/*
* 进行用户密码找回
* */
public class PasswordBackDao {

    public String selectUserInfo(String userName, String userReallyName, String userEmail) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession  = sqlSessionFactory.openSession();

        try {
            PasswordBackInterface passwordBackInterface = sqlSession.getMapper(PasswordBackInterface.class);
            UserInfo userInfo = passwordBackInterface.selectUserInfo(userName,userReallyName,userEmail);

            if(userInfo != null){
                return userInfo.getUSER_PWD();
            }else {
                return null;
            }

        }finally {
            sqlSession.close();
        }

    }

}
