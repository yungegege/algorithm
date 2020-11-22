package com.cloudfly.algorithm.netty.day1;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    public static void main(String[] args) throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(7000));
        // 设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 创建Selector
        Selector selector = Selector.open();
        // 把serverSocketChannel注册到selector，关心的事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 等待客户端连接
        while (true){
            // 1秒没有事件发生
            if (selector.select(2000)==0){
                System.out.println("服务器等待了2秒，无连接");
                continue;
            }
            // 返回的值>0,获取到相关的SelectionKey集合，即已经获取到的关心的事件
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selector.keys();

            // 遍历
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                // 根据key发生的事件做相应的处理
                if (key.isAcceptable()){ // 客户端连接
                    // 生成该客户端对于的socketChannel,这一步不会阻塞了
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    System.out.println("客户端连接成功，生成了一个SocketChannel "+socketChannel.hashCode());
                    // 注册到selector
                    socketChannel.register(selector,SelectionKey.OP_READ,ByteBuffer.allocate(1024));
                }
                // 读事件
                if (key.isReadable()){
                    // 获取channel
                    SocketChannel channel = (SocketChannel)key.channel();
                    ByteBuffer byteBuffer = (ByteBuffer)key.attachment();
                    channel.read(byteBuffer);
                    System.out.println(new String(byteBuffer.array()));
                }
                // 删除SelectionKey
                keyIterator.remove();
            }
        }
    }
}
