package com.mybatis.dao.companyInfoRegister;

import com.mybatis.MyBatisSqlSessionFactory;
import com.mybatis.interfacer.companyInfoRegister.CompanyInfoRegisterInterface;
import com.qst.itofferbacker.javabean.CompanyInfoAdd;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;

/*
* 插入
* */
public class CompanyInfoRegisterDao {
    public void setCompanyInfoRegister(CompanyInfoAdd companyInfoAdd) throws IOException {
        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            CompanyInfoRegisterInterface companyInfoRegisterInterface = sqlSession.getMapper(CompanyInfoRegisterInterface.class);
            companyInfoRegisterInterface.insertCompanyInfo(companyInfoAdd);
        }finally {
            sqlSession.commit();
            sqlSession.commit();
        }
    }

}
