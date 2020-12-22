package com.java.study.enums;

/**
 * @author yuanweiquan
 */
public enum OrderType implements AbstractEnum {
     
     SALE(1000, "销售订单"),
     Reissue(1001, "补发订单");

     private Integer key;
     private String value;

     OrderType(Integer key, String value) {
          this.key = key;
          this.value = value;
     }

     @Override
     public Integer getKey() {
          return null;
     }

     @Override
     public String getValue() {
          return null;
     }
}
