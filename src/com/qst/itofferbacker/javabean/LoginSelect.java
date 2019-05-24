package com.qst.itofferbacker.javabean;

/*
* 用户登录信息JavaBean
* */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoginSelect {
    private String USER_LOGNAME;
    private String USER_PWD;

    public LoginSelect() {
        super();
    }

    public LoginSelect(String USER_LOGNAME, String USER_PWD) {
        this.USER_LOGNAME = USER_LOGNAME;
        this.USER_PWD = USER_PWD;
    }
}
