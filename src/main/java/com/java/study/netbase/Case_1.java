package com.java.study.netbase;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2021/1/4 11:21 上午
 */
@Slf4j
public class Case_1 {

    public static void main(String[] args) throws Exception {

        String host = "127.0.0.1";
        InetAddress inetAddress = InetAddress.getByName(host);

        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(inetAddress);
        networkInterface.getInterfaceAddresses().forEach(x -> {
            log.info("{}", x);
        });
    }

}
