package com.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*
* 获取mybatis配置文件
* 进行SqlSessionFactory
 * */
public class MyBatisSqlSessionFactory {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {

        String path = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(path);
        return new SqlSessionFactoryBuilder().build(inputStream);

    }
}
