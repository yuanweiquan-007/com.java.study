package com.java.study.map;

import java.util.HashMap;
import java.util.Map;

public class MapSize {

     public static void main(String[] args) {
          Map<String, Object> map = new HashMap<>(16);
          for (int i = 0; i < 24; i++) {
               map.put("key" + i, i);
          }
          System.out.println(map.size());
     }

}
