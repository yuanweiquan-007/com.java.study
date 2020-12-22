package com.java.study.tool;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/20 11:40 上午
 */
@Slf4j
public class Case_escape {

    public static void main(String[] args) throws Exception {
        String context = "";
        System.out.println("开始");
        for (int i = 1; i <= 10; i++) {
            try {
                context = "当前进度：" + String.valueOf(i * 10) + "%";
                System.out.print("\r" + context);
                Thread.sleep(100);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("结束");
    }

}
