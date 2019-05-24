package mybatis.dao.userInfoUpdate;

import itofferbacker.javabean.UserInfo;
import mybatis.MyBatisSqlSessionFactory;
import mybatis.interfacer.userInfoUpdate.UserInfoUpdateInterface;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

/*
* 用户信息更新
* */
public class UserInfoUpdateDao {

    //判断用户名和密码是否存在
    public boolean getUserReallyName(String userName, String userPass) throws IOException {

        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            UserInfoUpdateInterface userInfoUpdateInterface = sqlSession.getMapper(UserInfoUpdateInterface.class);
            UserInfo userInfo = userInfoUpdateInterface.getUserReallyName(userName,userPass);
            if (userInfo != null){
                return true;
            }else {
                return false;
            }
        }finally {
            sqlSession.close();
        }

    }

    //更新密码
    public void setUserInfoPass(String userReallyName, String userPass) throws IOException {
        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {

            UserInfoUpdateInterface userInfoUpdateInterface = sqlSession.getMapper(UserInfoUpdateInterface.class);
            userInfoUpdateInterface.setUserInfoPass(userReallyName,userPass);
            System.out.println(userPass + "   "+userReallyName);

        }finally {
            sqlSession.commit();
            sqlSession.close();

        }
    }

}
