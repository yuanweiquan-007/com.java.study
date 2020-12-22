package com.java.study.function;

import java.util.function.Function;

public class Functions {

     public static void main(String[] args) {
          System.out.println(function.apply("1"));
          Boolean empty = isEmpty(1, x -> x == null);
          System.out.println(empty);
     }

     static Function<String, String> function = new Function<String, String>() {
          public String apply(String o) {
               return o;
          }
     };

     static Boolean isEmpty(Object object, Function<Object, Boolean> function) {
          return function.apply(object);
     }

}
