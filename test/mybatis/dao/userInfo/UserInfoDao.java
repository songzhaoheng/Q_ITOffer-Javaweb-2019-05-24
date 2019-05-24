package mybatis.dao.userInfo;

import itofferbacker.javabean.Page;
import itofferbacker.javabean.UserInfo;
import mybatis.MyBatisSqlSessionFactory;
import mybatis.interfacer.userInfo.UserInfoInterface;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

/*
* 获取用户信息
* */
public class UserInfoDao {

    //获取用户名
    public boolean getUserName(String userName) throws IOException {
        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try{
            UserInfoInterface userInfoInterface = sqlSession.getMapper(UserInfoInterface.class);

            UserInfo userInfo = userInfoInterface.getUserName(userName);

            if (userInfo != null){
                return true;
            }else {
                return false;
            }



        }finally {
            sqlSession.close();
        }
    }

    //获取用户真实姓名
    public boolean getUserReallyName(String userReallyName) throws IOException {
        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try{
            UserInfoInterface userInfoInterface = sqlSession.getMapper(UserInfoInterface.class);

            UserInfo userInfo = userInfoInterface.getUserReallyName(userReallyName);

            if (userInfo != null){
                return true;
            }else {
                return false;
            }



        }finally {
            sqlSession.close();
        }
    }

    //获取用户邮箱
    public boolean getUserEmail(String userEmail) throws IOException {
        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try{
            UserInfoInterface userInfoInterface = sqlSession.getMapper(UserInfoInterface.class);

            UserInfo userInfo = userInfoInterface.getUserEmail(userEmail);

            if (userInfo != null){
                return true;
            }else {
                return false;
            }



        }finally {
            sqlSession.close();
        }
    }

    //获取用户数量
    public int selectCount() throws IOException {
        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            UserInfoInterface userInfoInterface = sqlSession.getMapper(UserInfoInterface.class);
            int num = userInfoInterface.getPageNum();
            if (num>0){
                return num;
            }else {
                return 0;
            }
        }finally {
            sqlSession.close();
        }
    }

    //查询所有用户
    public List<UserInfo> selectAllUser(Page page) throws IOException {
        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserInfoInterface userInfoInterface = sqlSession.getMapper(UserInfoInterface.class);
            List<UserInfo> list = userInfoInterface.selectAllUser(page.getStart(),page.getSize());
            if (list!= null){
                return list;
            }else {
                return null;
            }
        }finally {
            sqlSession.close();
        }

    }

    //查询所有用户信息
    public List<UserInfo> selectUser() throws IOException {
        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserInfoInterface userInfoInterface = sqlSession.getMapper(UserInfoInterface.class);
            List<UserInfo> list = userInfoInterface.selectUser();
            if (list!= null){
                return list;
            }else {
                return null;
            }
        }finally {
            sqlSession.close();
        }

    }

}
