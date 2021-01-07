package com.java.study.network.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2021/1/5 5:55 下午
 */
@Slf4j
public class SocketClient {

    public static void main(String[] args) throws Exception {
        Socket socket = null;
        String context = "Hello Joke";
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8081);
        try {
            socket = new Socket();
            socket.connect(inetSocketAddress);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());


            outputStream.writeUTF(context);
            outputStream.flush();
            log.info("发送请求：{}", context);

            log.info("接受到返回值：{}", inputStream.readUTF());
        } finally {
            if (null != inputStream) {
                inputStream.close();
            }
            if (null != outputStream) {
                outputStream.close();
            }
            if (null != socket) {
                socket.close();
            }
        }
    }

}
