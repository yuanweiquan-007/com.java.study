package com.java.study.hashcode;

public class HashCode {

    public static void main(String[] args) throws Exception {
        Integer integer = new Integer(10);
        System.out.println(integer.hashCode());
        System.out.println("-----------------------------------------------");

        Long aLong = new Long(1);
        System.out.println(aLong.hashCode());
        System.out.println("-----------------------------------------------");

        String string = "abcdefs";
        System.out.println(string.hashCode());
        System.out.println("-----------------------------------------------");
    }

}
