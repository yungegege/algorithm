package com.cloudfly.algorithm.netty.day1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端启动");

        while (true) {
            System.out.println("等待连接");
            Socket socket = serverSocket.accept();
            System.out.println("接收到客户端连接");
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        byte[] bytes = new byte[1024];
                        InputStream inputStream = socket.getInputStream();
                        int read;
                        while ((read = inputStream.read(bytes)) != -1) {
                            System.out.println(new String(bytes, 0, read));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("关闭客户端连接");
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
