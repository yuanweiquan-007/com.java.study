package com.java.study.network;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2021/1/4 11:10 上午
 */
@Slf4j
public class Case_InetAddress {

    public static void main(String[] args) throws Exception {

        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        log.info("{}", inetAddress);

        System.out.println();

        for (InetAddress address : InetAddress.getAllByName("www.baidu.com")) {
            log.info("{}", address);
        }

    }

}
