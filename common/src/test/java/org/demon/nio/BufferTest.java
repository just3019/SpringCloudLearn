package org.demon.nio;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * nio 重点在于channel和buffer。
 * 所有channel的操作都基于buffer，读取必须把数据写入buffer，写入必须从buffer中取数据写入
 */
@Log4j2
public class BufferTest {

    @Test
    public void test() {
        try (FileInputStream fileInputStream = new FileInputStream(new File("/Users/demon/Desktop/1.pdf"));
             FileChannel fileChannel = fileInputStream.getChannel()) {

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            fileChannel.read(byteBuffer);
            byteBuffer.flip();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用nio去拷贝文件
     */
    @Test
    public void nioCopyTest() {
        try (FileInputStream fileInputStream = new FileInputStream("/Users/demon/Desktop/1.pdf");
             FileOutputStream fileOutputStream = new FileOutputStream("/Users/demon/Desktop/2.pdf");
             FileChannel readChannel = fileInputStream.getChannel();
             FileChannel writeChannel = fileOutputStream.getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (true) {
                byteBuffer.clear();
                int len = readChannel.read(byteBuffer);
                if (len == -1) {
                    break;
                }
                byteBuffer.flip();
                writeChannel.write(byteBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void bufferVariableTest() {
        //创建一个byteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(15);
        log.info(byteBuffer.mark());

        //循环插入10个byte
        for (int i = 0; i < 10; i++) {
            byteBuffer.put((byte) i);
        }
        log.info(byteBuffer.mark());

        //flip处理
        byteBuffer.flip();
        log.info(byteBuffer.mark());

        //循环获取5个
        for (int i = 0; i < 5; i++) {
            System.out.print(byteBuffer.get());
        }
        System.out.println();
        log.info(byteBuffer.mark());

        //flip处理
        byteBuffer.flip();
        log.info(byteBuffer.mark());

    }
}
