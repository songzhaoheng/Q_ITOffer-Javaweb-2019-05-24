package com.qst.itofferbacker.javabean;

/*
* 用户信息显示
* */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString
public class UserInfo {

    private int USER_ID;
    private String USER_LOGNAME;
    private String USER_PWD;
    private String USER_REALNAME;
    private String USER_EMAIL;
    private int USER_ROLE;
    private int USER_STATE;

    public UserInfo() {
        super();
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "USER_ID=" + USER_ID +
                ", USER_LOGNAME='" + USER_LOGNAME + '\'' +
                ", USER_PWD='" + USER_PWD + '\'' +
                ", USER_REALNAME='" + USER_REALNAME + '\'' +
                ", USER_EMAIL='" + USER_EMAIL + '\'' +
                ", USER_ROLE=" + USER_ROLE +
                ", USER_STATE=" + USER_STATE +
                '}';
    }

    public UserInfo(int USER_ID, String USER_LOGNAME, String USER_PWD, String USER_REALNAME, String USER_EMAIL, int USER_ROLE, int USER_STATE) {
        this.USER_ID = USER_ID;
        this.USER_LOGNAME = USER_LOGNAME;
        this.USER_PWD = USER_PWD;
        this.USER_REALNAME = USER_REALNAME;
        this.USER_EMAIL = USER_EMAIL;
        this.USER_ROLE = USER_ROLE;
        this.USER_STATE = USER_STATE;
    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_LOGNAME() {
        return USER_LOGNAME;
    }

    public void setUSER_LOGNAME(String USER_LOGNAME) {
        this.USER_LOGNAME = USER_LOGNAME;
    }

    public String getUSER_PWD() {
        return USER_PWD;
    }

    public void setUSER_PWD(String USER_PWD) {
        this.USER_PWD = USER_PWD;
    }

    public String getUSER_REALNAME() {
        return USER_REALNAME;
    }

    public void setUSER_REALNAME(String USER_REALNAME) {
        this.USER_REALNAME = USER_REALNAME;
    }

    public String getUSER_EMAIL() {
        return USER_EMAIL;
    }

    public void setUSER_EMAIL(String USER_EMAIL) {
        this.USER_EMAIL = USER_EMAIL;
    }

    public int getUSER_ROLE() {
        return USER_ROLE;
    }

    public void setUSER_ROLE(int USER_ROLE) {
        this.USER_ROLE = USER_ROLE;
    }

    public int getUSER_STATE() {
        return USER_STATE;
    }

    public void setUSER_STATE(int USER_STATE) {
        this.USER_STATE = USER_STATE;
    }
}
