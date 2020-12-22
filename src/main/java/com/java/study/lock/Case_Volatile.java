package com.java.study.lock;

import lombok.Data;

import java.util.stream.IntStream;

@Data
public class Case_Volatile {

    private volatile Integer number = 0;

    public void add() {
        //volatile只能保证单次读写原子的可见性，像++这种复合操作是不能保证的。
        number = number + 1;
    }

    public static void main(String[] args) throws Exception {

        Case_Volatile aVolatile = new Case_Volatile();
        IntStream.rangeClosed(1, 100).parallel().forEach(i -> {
            aVolatile.add();
        });

        System.out.println(aVolatile.getNumber());
    }

}
