package mybatis.dao.companyInfoRegister;

import itofferbacker.javabean.CompanyInfoAdd;
import mybatis.MyBatisSqlSessionFactory;
import mybatis.interfacer.companyInfoRegister.CompanyInfoRegisterInterface;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
