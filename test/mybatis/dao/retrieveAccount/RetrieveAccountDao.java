package mybatis.dao.retrieveAccount;

import itofferbacker.javabean.UserInfo;
import mybatis.MyBatisSqlSessionFactory;
import mybatis.interfacer.retrieveAccount.RetrieveAccountInterface;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

/*
 * 进行用户账户找回
 * */
public class RetrieveAccountDao {

    //找回用户信息
    public UserInfo selectUserInfo(String userName, String userReallyName, String userEmail) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession  = sqlSessionFactory.openSession();

        try {
            RetrieveAccountInterface retrieveAccountInterface = sqlSession.getMapper(RetrieveAccountInterface.class);
            UserInfo userInfo = retrieveAccountInterface.selectUserInfo(userName,userReallyName,userEmail);

            if(userInfo != null){
                return userInfo;
            }else {
                return null;
            }

        }finally {
            sqlSession.close();
        }

    }

    //将找回的信息插入到用户信息数据库中
    public void insertUserInfo(UserInfo userInfo) throws IOException {
        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession  = sqlSessionFactory.openSession();
        try {

            RetrieveAccountInterface retrieveAccountInterface = sqlSession.getMapper(RetrieveAccountInterface.class);
            retrieveAccountInterface.insertUserInfo(userInfo);
        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

    public void deleteUserInfo(String username) throws IOException {
        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession  = sqlSessionFactory.openSession();
        try {

            RetrieveAccountInterface retrieveAccountInterface = sqlSession.getMapper(RetrieveAccountInterface.class);
            retrieveAccountInterface.deleteUserInfo(username);
            System.out.println(username);
        }finally {
            sqlSession.commit();
            sqlSession.close();
        }

    }
}
