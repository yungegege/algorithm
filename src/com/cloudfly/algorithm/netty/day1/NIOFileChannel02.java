package com.cloudfly.algorithm.netty.day1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 往文件里面读
 */
public class NIOFileChannel02 {

    public static void main(String[] args) throws Exception{
        File file = new File("file02.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
        // 从channel读数据放入buffer
        fileChannel.read(byteBuffer);
        fileChannel.close();
        System.out.println(new String(byteBuffer.array()));

    }
}
