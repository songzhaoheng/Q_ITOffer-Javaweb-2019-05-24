package com.qst.itofferbacker.listener;

import com.mybatis.dao.logOffInfo.DestroyUserInfoDao;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {

    private  static final int C_SCHEDULE_HOUR = 0;
    private static boolean isRunning = false;
    private ServletContext context = null;

    public MyTask(ServletContext servletContext) {
        this.context = servletContext;

    }

    //运行
    public void run(){
        Calendar cal  =  Calendar.getInstance();
        if  (!isRunning)    {
            if  (C_SCHEDULE_HOUR  ==  cal.get(Calendar.HOUR_OF_DAY))  {
                isRunning  =  true;

                context.log("开始执行指定任务");

                try {
                    new DestroyUserInfoDao().destroyUserInfo();
                    String info = new Timestamp(new Date().getTime()) + "——————————  成功删除备份用户数据信息";
                    context.log(info);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                isRunning  =  false;
                context.log("指定任务执行结束");
            }
        }  else  {
            context.log("上一次任务执行还未结束");
        }
    }
}
