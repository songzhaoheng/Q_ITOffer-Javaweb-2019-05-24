package com.mybatis.dao.logOffInfo;

import com.mybatis.MyBatisSqlSessionFactory;
import com.mybatis.interfacer.destroyUserInfo.DestroyUserInfoInterface;
import com.mybatis.interfacer.logOffInfo.LogOffInfoInterface;
import com.qst.itofferbacker.javabean.UserInfoBackSelect;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
