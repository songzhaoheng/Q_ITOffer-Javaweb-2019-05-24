package com.qst.itofferbacker.javabean;

/*
* 插入用户信息JavaBean
* */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserInfoAdd {

    private String USER_LOGNAME;
    private String USER_PWD;
    private String USER_REALNAME;
    private String USER_EMAIL;
    private int USER_ROLE;
    private int USER_STATE;

    public UserInfoAdd() {
        super();
    }

    public UserInfoAdd(String USER_LOGNAME, String USER_PWD, String USER_REALNAME, String USER_EMAIL, int USER_ROLE, int USER_STATE) {
        this.USER_LOGNAME = USER_LOGNAME;
        this.USER_PWD = USER_PWD;
        this.USER_REALNAME = USER_REALNAME;
        this.USER_EMAIL = USER_EMAIL;
        this.USER_ROLE = USER_ROLE;
        this.USER_STATE = USER_STATE;
    }
}
