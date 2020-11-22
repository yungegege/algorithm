package com.cloudfly.algorithm.netty.day1;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {

    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);

        if (!socketChannel.connect(new InetSocketAddress("127.0.0.1",7000))){
            while (!socketChannel.finishConnect()){
                System.out.println("连接需要时间，客户端不会阻塞，可以做其他工作");
            }
        }

        ByteBuffer buffer = ByteBuffer.wrap("李云飞你好".getBytes());
        socketChannel.write(buffer);
        System.in.read();


    }
}
