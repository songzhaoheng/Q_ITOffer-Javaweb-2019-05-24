package mybatis.dao.userInfoRegister;

import itofferbacker.javabean.UserInfoAdd;
import mybatis.MyBatisSqlSessionFactory;
import mybatis.interfacer.userInfoRegister.UserInfoAddInterface;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

//用户信息添加
public class UserInfoAddDao {

    public boolean userInfoAddDao(UserInfoAdd userInfoAdd) throws IOException {
        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {

            UserInfoAddInterface userInfoAddInterface = sqlSession.getMapper(UserInfoAddInterface.class);

            //UserInfoAdd userInfoAdd = new UserInfoAdd("Hern","10043632","是否","123456@163.com",2,3);

            if (userInfoAddInterface.insertUserInfoAdd(userInfoAdd)){
                return true;
            }else {
                return false;
            }


        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }

}