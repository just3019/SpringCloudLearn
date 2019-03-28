package org.demon;

import org.demon.pool.ExecutorPool;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * desc:
 *
 * @author demon
 * @date 2018-12-11 09:50
 */
public class JavaTest {

    /**
     * 测试线程安全类， Integer ，AtomicInteger， LongAdder
     */
    private Integer data0 = 0;
    private AtomicInteger data1 = new AtomicInteger(0);
    private LongAdder data2 = new LongAdder();

    @Test
    public void test_01() throws InterruptedException {
        int n = 1000;
        for (int i = 0; i < n; i++) {
            ExecutorPool.getInstance().execute(() -> data0++);
        }
        Thread.sleep(100);
        System.out.println(data0);

        for (int i = 0; i < n; i++) {
            ExecutorPool.getInstance().execute(() -> data1.incrementAndGet());
        }
        Thread.sleep(10);
        System.out.println(data1);

        for (int i = 0; i < n; i++) {
            ExecutorPool.getInstance().execute(() -> data2.increment());
        }
        Thread.sleep(10);
        System.out.println(data2);
    }

}
