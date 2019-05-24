package com.qst.itofferbacker.javabean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

/*
* 用户id、时间
* */
@Getter
@Setter
@ToString
public class UserInfoBackSelect {

    private int USER_ID;
    private Timestamp USER_DATE;

    public UserInfoBackSelect() {
        super();
    }

    public UserInfoBackSelect(int USER_ID, Timestamp USER_DATE) {
        this.USER_ID = USER_ID;
        this.USER_DATE = USER_DATE;
    }
}
