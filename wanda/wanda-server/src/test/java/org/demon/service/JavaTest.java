package org.demon.service;

import cn.hutool.core.lang.UUID;
import org.junit.Test;

public class JavaTest {

    @Test
    public void test() {
        String code = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println(code);
    }
}
