package org.demon.service;

import cn.hutool.core.lang.UUID;
import org.junit.Test;

public class JavaTest {

    @Test
    public void test() {
        String code = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(code);
    }

    /**
     * java字符串拼接效率
     */
    @Test
    public void test_string() {
        String a = "";
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            a = a + "a";
        }
        long time1 = System.currentTimeMillis();
        System.out.println(a);
        System.out.println(time1 - time);


        StringBuilder b = new StringBuilder();
        long time2 = System.currentTimeMillis();
        for (int j = 0; j < 100000; j++) {
            b.append("a");
        }
        long time3 = System.currentTimeMillis();
        System.out.println(b);
        System.out.println(time3 - time2);


    }
}
