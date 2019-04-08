package org.demon.nio;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
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


    /**
     * 使用mark()方法后，reset只能还原会mark的节点
     */
    @Test
    public void markAndResetTest() {
        //创建一个byteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(15);
        for (int i = 0; i < 10; i++) {
            byteBuffer.put((byte) i);
        }
        byteBuffer.flip();

        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.println(byteBuffer.get());
            if (i == 4) {
                byteBuffer.mark();
                System.out.println("mark at " + i);
            }
        }
        byteBuffer.reset();
        System.out.println("reset to mark");
        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }
    }

    /**
     * 使用duplicate()方法，能生成和原缓冲一样的缓冲区。两个缓冲数据修改彼此可见，只是
     * 各自都维护一套position，limit，mark
     */
    @Test
    public void duplicateTest() {
        ByteBuffer b = ByteBuffer.allocate(15);
        for (int i = 0; i < 10; i++) {
            b.put((byte) i);
        }
        ByteBuffer c = b.duplicate();
        System.out.println(b);
        System.out.println(c);

        c.flip();
        System.out.println("c.flip()");
        System.out.println(b);
        System.out.println(c);

        c.put((byte) 100);
        System.out.println(b.get(0));
        System.out.println(c.get(0));
    }


    /**
     * 将文件映射到内存，读取。再通过buffer修改，将数据刷到磁盘上
     */
    @Test
    public void mappedByteBufferTest() {
        try (RandomAccessFile raf = new RandomAccessFile("/Users/demon/Desktop/test.txt", "rw")) {
            FileChannel fc = raf.getChannel();
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, raf.length());
            while (mbb.hasRemaining()) {
                System.out.println(mbb.get());
            }
            mbb.put(0, (byte) 98);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void mappedTest() {
        int numOfInts = 4000000;
        //IO
        long t1 = System.currentTimeMillis();
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File("tmp_stream.tmp"))))) {
            for (int i = 0; i < numOfInts; i++) {
                dos.writeInt(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long t2 = System.currentTimeMillis();
        System.out.println("stream写入耗时:" + (t2 - t1));

        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File("tmp_stream.tmp"))))) {
            for (int i = 0; i < numOfInts; i++) {
                dis.readInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long t3 = System.currentTimeMillis();
        System.out.println("stream读取耗时:" + (t3 - t2));

        //NIO
        try (FileOutputStream fout = new FileOutputStream(new File("tmp_nio.tmp"));
             FileChannel fc = fout.getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(numOfInts * 4);
            for (int i = 0; i < numOfInts; i++) {
                byteBuffer.put(int2byte(i));
            }
            byteBuffer.flip();
            fc.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long t4 = System.currentTimeMillis();
        System.out.println("nio写入耗时:" + (t4 - t3));

        try (FileInputStream fin = new FileInputStream(new File("tmp_nio.tmp"));
             FileChannel fc = fin.getChannel()) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(numOfInts * 4);
            fc.read(byteBuffer);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                byte2int(byteBuffer.get(), byteBuffer.get(), byteBuffer.get(), byteBuffer.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long t5 = System.currentTimeMillis();
        System.out.println("nio读取耗时:" + (t5 - t4));

        try (FileChannel fc = new RandomAccessFile("tmp_mmp.tmp", "rw").getChannel()) {
            IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, numOfInts * 4).asIntBuffer();
            for (int i = 0; i < numOfInts; i++) {
                ib.put(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long t6 = System.currentTimeMillis();
        System.out.println("mapp写入耗时:" + (t6 - t5));

        try (FileChannel fc = new FileInputStream("tmp_mmp.tmp").getChannel()) {
            IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
            while (ib.hasRemaining()) {
                ib.get();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long t7 = System.currentTimeMillis();
        System.out.println("mapp读取耗时:" + (t7 - t6));


    }

    public byte[] int2byte(int res) {
        byte[] targets = new byte[4];
        targets[3] = (byte) (res & 0xff);
        targets[2] = (byte) (res >> 8 & 0xff);
        targets[1] = (byte) (res >> 16 & 0xff);
        targets[0] = (byte) (res >>> 24);
        return targets;
    }

    public int byte2int(byte b1, byte b2, byte b3, byte b4) {
        return ((b1 & 0xff) << 24) | ((b2 & 0xff) << 16) | ((b3 & 0xff) << 8) | (b4 & 0xff);

    }

}
