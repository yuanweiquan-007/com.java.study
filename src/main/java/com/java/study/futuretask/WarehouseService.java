package com.java.study.futuretask;

import com.google.common.collect.Maps;

import java.util.Map;

public class WarehouseService {

     public Map<String, Object> get(String code) throws Exception {
          Map<String, Object> map = Maps.newHashMap();
          map.put("warehouseCode", code);
          map.put("warehouseName", "仓库" + code);
          Thread.sleep(2000);
          return map;
     }

}
