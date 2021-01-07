package com.java.study.network.socket;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2021/1/5 5:33 下午
 */
@Slf4j
public class SocketServer {

    private static final ExecutorService execute = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8081);
        log.info("Server start");
        while (true) {
            execute.execute(new ServerTask(serverSocket.accept()));
        }
    }

    private static class ServerTask implements Runnable {
        private Socket socket;

        public ServerTask(Socket socket) {
            this.socket = socket;
        }

        @SneakyThrows
        @Override
        public void run() {
            try {
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                String clientContext = inputStream.readUTF();
                log.info("接受到客户端请求内容：{}", clientContext);
                outputStream.writeUTF("接受请求成功，请求内容为：" + clientContext);
                outputStream.flush();
            } finally {
                if (null != socket) {
                    socket.close();
                }
            }
        }
    }

}
