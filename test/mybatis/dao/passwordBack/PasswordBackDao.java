package mybatis.dao.passwordBack;

import itofferbacker.javabean.UserInfo;
import mybatis.MyBatisSqlSessionFactory;
import mybatis.interfacer.passwordBack.PasswordBackInterface;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
