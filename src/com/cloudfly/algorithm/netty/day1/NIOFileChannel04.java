package com.cloudfly.algorithm.netty.day1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * transferFrom拷贝
 */
public class NIOFileChannel04 {

    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = new FileInputStream("1.txt");
        FileChannel sourceCh = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
        FileChannel destCh = fileOutputStream.getChannel();

//        destCh.transferFrom(sourceCh,0,sourceCh.size());
        sourceCh.transferTo(0,sourceCh.size(),destCh);
        fileInputStream.close();
        fileOutputStream.close();



    }
}
