package com.cloudfly.algorithm.netty.day1;

import sun.nio.ch.FileChannelImpl;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 往文件里面写
 */
public class NIOFileChannel01 {

    public static void main(String[] args) throws Exception{
        String str = "hello,云飞";
        FileOutputStream fileOutputStream = new FileOutputStream("file02.txt");
//        fileOutputStream.write(str.getBytes());
//        fileOutputStream.close();
        FileChannel fileChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byte[] bytes = str.getBytes();
        byteBuffer.put(bytes);

        byteBuffer.flip();
        // 从buffer读数据写入channel，所以这个write是针对channel的
        fileChannel.write(byteBuffer);
        fileOutputStream.close();

    }
}
