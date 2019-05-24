package mybatis.dao.userInfoLogin;

import itofferbacker.javabean.LoginSelect;
import mybatis.MyBatisSqlSessionFactory;
import mybatis.interfacer.userInfoLogin.LoginSelectInterface;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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

            if (loginSelect1 != null){
                return true;
            }else {
                return false;
            }
        } finally {
            sqlSession.close();
        }

    }

}
