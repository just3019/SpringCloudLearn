package org.demon.service;

import cn.hutool.core.lang.UUID;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
        StringBuilder a = new StringBuilder();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            a.append("a");
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


    @Test
    public void test_map() throws InterruptedException {
        Map<Integer, Integer> map = new HashMap<>();

        ExecutorService executorService = new ThreadPoolExecutor(200, 200, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            int finalI = i;
            int finalI1 = i;
            executorService.execute(() -> map.put(finalI, finalI1));
        }
        System.out.println("完成" + (System.currentTimeMillis() - time));
        Thread.sleep(5000);
        System.out.println(map.size());

    }

    @Test
    public void test_concurrentmap() throws InterruptedException {
        ConcurrentMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
        ExecutorService executorService = new ThreadPoolExecutor(200, 200, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            int finalI = i;
            int finalI1 = i;
            executorService.execute(() -> map.put(finalI, finalI1));
        }
        System.out.println("完成" + (System.currentTimeMillis() - time));
        Thread.sleep(1000);
        System.out.println(map.size());

    }
}
