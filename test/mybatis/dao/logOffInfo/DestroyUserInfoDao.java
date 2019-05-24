package mybatis.dao.logOffInfo;

import itofferbacker.javabean.UserInfoBackSelect;
import mybatis.MyBatisSqlSessionFactory;
import mybatis.interfacer.destroyUserInfo.DestroyUserInfoInterface;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.util.List;

/*
* 自动删除7天的用户数据信息
* */
public class DestroyUserInfoDao {

    public void destroyUserInfo() throws IOException {
        SqlSessionFactory sqlSessionFactory = new MyBatisSqlSessionFactory().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try{

            DestroyUserInfoInterface destroyUserInfoInterface = sqlSession.getMapper(DestroyUserInfoInterface.class);

            List<UserInfoBackSelect> list = destroyUserInfoInterface.selectUserInfoBackDate();

            for (int i = 0; i < list.size(); i++) {
                destroyUserInfoInterface.deleteUserInfoBack(list.get(i).getUSER_ID());
                //System.out.println(list.get(i).getUSER_ID());
            }


            /*
            ListIterator listIterator = list.listIterator();

            while (listIterator.hasNext()){
                System.out.println(listIterator.next().toString());
            }

             */
            /*
            Iterator iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
            /*System.out.println(list);
             */

        }finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
