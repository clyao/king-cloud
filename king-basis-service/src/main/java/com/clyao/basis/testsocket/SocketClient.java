package com.clyao.basis.testsocket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {

    public static void main(String[] args) {
        try {
            //创建一个socket连接
            Socket socket = new Socket("127.0.0.1", 8888);
            //使用printWriter读取数据
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            //创建一个输入
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("请输入内容：");
                printWriter.println(scanner.nextLine());
                printWriter.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
