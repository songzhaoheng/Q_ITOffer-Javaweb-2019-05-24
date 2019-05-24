package mybatis.dao.logOffInfo;

import itofferbacker.javabean.UserInfo;
import itofferbacker.javabean.UserInfoBack;
import mybatis.MyBatisSqlSessionFactory;
import mybatis.interfacer.logOffInfo.LogOffInfoInterface;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class LogOffInfoDao {

    //查询用户信息是否存在，若存在则对用户信息进行备份，然后进行删除
    public boolean getUserReallyName(String userReallyName, String userPass) throws IOException {
        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try{

            LogOffInfoInterface logOffInfoInterface = sqlSession.getMapper(LogOffInfoInterface.class);
            UserInfo userInfo = logOffInfoInterface.getUserReallyName(userReallyName,userPass);
            if (userInfo != null){
                //获取当前时间
                Timestamp timestamp = new Timestamp(new Date().getTime());

                //进行用户数据信息备份
                UserInfoBack userInfoBack = new UserInfoBack(userInfo.getUSER_LOGNAME(),userInfo.getUSER_PWD(),userInfo.getUSER_REALNAME(),userInfo.getUSER_EMAIL(),userInfo.getUSER_ROLE(),userInfo.getUSER_STATE(),timestamp);
                logOffInfoInterface.insertUserInfoBack(userInfoBack);

                //删除用户信息
                logOffInfoInterface.deleteUserInfo(userInfo.getUSER_ID());

                sqlSession.commit();

                return true;
            }else {
                return false;
            }

        }finally {
            sqlSession.close();
        }
    }

}
