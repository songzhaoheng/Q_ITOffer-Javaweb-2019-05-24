package com.other;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;

/*
* 生成随机4位数
* */
@Getter
@Setter
@ToString
public class RandNum {

    private Integer num;

    public RandNum() {
        super();
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        this.num = threadLocalRandom.nextInt(1000,9999);
    }
}
