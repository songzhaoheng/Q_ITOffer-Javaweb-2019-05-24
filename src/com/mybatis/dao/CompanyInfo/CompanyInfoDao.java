package com.mybatis.dao.CompanyInfo;

import com.mybatis.MyBatisSqlSessionFactory;
import com.mybatis.interfacer.companyInfo.CompanyInfoInterface;
import com.qst.itofferbacker.javabean.CompanyInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/*
* 查询企业信息
* */
public class CompanyInfoDao {

    //查询企业是否存在
    public boolean getCompanyName(String companyName) throws IOException {
        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

            CompanyInfoInterface companyInfoInterface = sqlSession.getMapper(CompanyInfoInterface.class);

            CompanyInfo companyInfo = companyInfoInterface.getCompanyName(companyName);
            //判断企业信息是否存在
            if(companyInfo != null){
                return true;
            }else {
                return false;
            }

        }finally {
            sqlSession.close();
        }

    }

    //获取所有企业信息
    public List<CompanyInfo> selectCompanyInfo() throws IOException {
        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            CompanyInfoInterface companyInfoInterface = sqlSession.getMapper(CompanyInfoInterface.class);
            List<CompanyInfo> list = companyInfoInterface.selectCompanyInfo();

            if (list != null){
                return list;
            }else {
                return null;
            }
        }finally {
            sqlSession.close();
        }

    }

}
