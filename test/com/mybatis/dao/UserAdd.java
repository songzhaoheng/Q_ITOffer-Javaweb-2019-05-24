package com.mybatis.dao;

import com.mybatis.interfacer.userInfo.UserInfoInterface;
import com.qst.itofferbacker.javabean.UserInfoAdd;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserAdd {

    public SqlSessionFactory getSqlSessionFactory() throws IOException, IOException {
        System.out.println(222222);
        String resource = "mybatis-config.xml";
        System.out.println(33333333);
        InputStream inputStream = Resources.getResourceAsStream(resource);
        System.out.println(444444445);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void userAdd() throws IOException {
        //获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        //获取SQLSession对象
        SqlSession session = sqlSessionFactory.openSession();
        try {

            UserInfoInterface userInfoInterface = session.getMapper(UserInfoInterface.class);
            UserInfoAdd userInfoAdd = new UserInfoAdd("Hern","10043632","宋兆恒","2336909208@qq.com",3,1);
            boolean flag = userInfoInterface.setinsertUserInfo(userInfoAdd);
            if (flag){
                System.out.println(flag);
            }else {
                System.out.println(flag);
            }

        }finally {
            session.close();
        }
    }

}
