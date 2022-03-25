package com.clyao.basis.testsocket;

import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) {
        try {
            //创建一个serverSocket
            ServerSocket serverSocket = new ServerSocket(8888);
            //等待一个请求
            while (true){
                Socket socket = serverSocket.accept();
                new SocketThread(socket).run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
