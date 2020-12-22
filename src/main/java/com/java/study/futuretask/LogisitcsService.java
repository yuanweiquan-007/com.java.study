package com.java.study.futuretask;

import com.google.common.collect.Maps;

import java.util.Map;

public class LogisitcsService {

     public Map<String, Object> get(String code) throws Exception {
          Map<String, Object> map = Maps.newHashMap();
          map.put("logisitcsCode", code);
          map.put("logisticsName", "承运商" + code);
          Thread.sleep(2000);
          return map;
     }

}
