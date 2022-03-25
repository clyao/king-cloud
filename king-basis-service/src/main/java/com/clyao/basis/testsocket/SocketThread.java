package com.clyao.basis.testsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketThread implements Runnable{

    private Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //读取通道数据
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            //转成缓存流
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //循环读取数据
            String msg;
            while ((msg = bufferedReader.readLine()) != null){
                System.out.println("客户端发送的消息：" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
