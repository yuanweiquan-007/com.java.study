package com.java.study.lombok;

import lombok.Data;

import java.util.stream.IntStream;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/11 2:43 下午
 */
public class Case_Set {
    public static void main(String[] args) throws Exception {
        IntStream.range(1, 2).parallel().forEach(i -> {
            User user = new User();
            user.setUserCode(String.valueOf(i));
            user.setVSkuCode(String.valueOf(i));
            System.out.println(user);
        });
    }
}

@Data
class User {
    private String userCode;
    private String vSkuCode;
}
