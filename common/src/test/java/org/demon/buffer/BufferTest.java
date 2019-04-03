package org.demon.buffer;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BufferTest {

    private static final int CIRCLE = 1000000;

    @Test
    public void noBuffer() {
        long t = System.currentTimeMillis();
        try (Writer writer = new FileWriter("/Users/demon/Desktop/test.txt")) {
            for (int i = 0; i < CIRCLE; i++) {
                writer.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("不使用缓冲耗时：" + (System.currentTimeMillis() - t));
    }


    @Test
    public void withBuffer() {
        long t = System.currentTimeMillis();
        try (Writer writer = new BufferedWriter(new FileWriter("/Users/demon/Desktop/test.txt"))) {
            for (int i = 0; i < CIRCLE; i++) {
                writer.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("使用缓冲耗时：" + (System.currentTimeMillis() - t));
    }

}
